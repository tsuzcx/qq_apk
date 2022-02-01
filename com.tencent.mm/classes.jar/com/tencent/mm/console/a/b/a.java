package com.tencent.mm.console.a.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final int[] fLv;
  
  static
  {
    AppMethodBeat.i(20217);
    fLv = new int[] { 0, 1 };
    try
    {
      Object localObject = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
      if ((localObject != null) && ((localObject instanceof com.tencent.mm.pluginsdk.cmd.a))) {
        com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)localObject, new String[] { "//aging" });
      }
      AppMethodBeat.o(20217);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.AgingTestCommand", localThrowable, "", new Object[0]);
      AppMethodBeat.o(20217);
    }
  }
  
  private static ai H(String paramString, int paramInt)
  {
    AppMethodBeat.i(20206);
    ai localai = new ai();
    localai.fLJ = (100000 + paramInt);
    localai.setUsername(paramString);
    localai.qg("alias_".concat(String.valueOf(paramInt)));
    localai.qj("nickName_".concat(String.valueOf(paramInt)));
    localai.ql("quanPin_".concat(String.valueOf(paramInt)));
    localai.qk("pyInitial_".concat(String.valueOf(paramInt)));
    localai.setType(3);
    AppMethodBeat.o(20206);
    return localai;
  }
  
  private static int lk(int paramInt)
  {
    AppMethodBeat.i(20205);
    int j = (int)(Math.random() * paramInt);
    int i = j;
    if (j >= paramInt) {
      i = 0;
    }
    AppMethodBeat.o(20205);
    return i;
  }
  
  private static byte[] oS(long paramLong)
  {
    int i = (byte)(int)(paramLong & 0xFF);
    int j = (byte)(int)(paramLong >> 8 & 0xFF);
    int k = (byte)(int)(paramLong >> 16 & 0xFF);
    int m = (byte)(int)(paramLong >> 24 & 0xFF);
    int n = (byte)(int)(paramLong >> 32 & 0xFF);
    int i1 = (byte)(int)(paramLong >> 40 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 48 & 0xFF);
    return new byte[] { (byte)(int)(paramLong >> 56 & 0xFF), i2, i1, n, m, k, j, i };
  }
  
  public final boolean a(final Context paramContext, final String[] paramArrayOfString, final String paramString)
  {
    AppMethodBeat.i(20204);
    if (ac.getLogLevel() > 1)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    Object localObject1 = u.axw();
    final b localb = new b();
    int i = 5001;
    while (i <= 6000)
    {
      localb.fLD.add("rdgztest_atm".concat(String.valueOf(i)));
      i += 1;
    }
    paramString = ((k)g.ab(k.class)).dcr().getDB();
    localObject1 = paramString.a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[] { localObject1 }, 0);
    while (((Cursor)localObject1).moveToNext())
    {
      bo localbo = new bo();
      localbo.convertFrom((Cursor)localObject1);
      Cursor localCursor;
      Object localObject2;
      switch (localbo.getType())
      {
      default: 
        break;
      case 3: 
        localCursor = paramString.a("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[] { String.valueOf(localbo.field_msgSvrId) }, 0);
        if (localCursor.moveToNext())
        {
          localObject2 = new e();
          ((e)localObject2).convertFrom(localCursor);
          localb.fLE.add(new c(localbo, localObject2));
        }
        localCursor.close();
        break;
      case 43: 
        localCursor = paramString.a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[] { String.valueOf(localbo.field_msgSvrId) }, 0);
        if (localCursor.moveToNext())
        {
          localObject2 = new s();
          ((s)localObject2).convertFrom(localCursor);
          localb.fLF.add(new c(localbo, localObject2));
        }
        localCursor.close();
        break;
      case 47: 
        localCursor = paramString.a("SELECT * FROM EmojiInfo WHERE md5=?", new String[] { localbo.field_imgPath }, 0);
        if (localCursor.moveToNext())
        {
          localObject2 = new EmojiInfo();
          ((EmojiInfo)localObject2).convertFrom(localCursor);
          localb.fLG.add(new c(localbo, localObject2));
        }
        localCursor.close();
      }
    }
    ((Cursor)localObject1).close();
    if ((localb.fLE.isEmpty()) && (localb.fLG.isEmpty()) && (localb.fLF.isEmpty()))
    {
      Toast.makeText(paramContext, "please send some data(img,video,emoji) to yourself", 1).show();
      AppMethodBeat.o(20204);
      return false;
    }
    ac.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[] { Integer.valueOf(localb.fLD.size()), Integer.valueOf(localb.fLE.size()), Integer.valueOf(localb.fLG.size()), Integer.valueOf(localb.fLF.size()) });
    if (paramArrayOfString.length == 2)
    {
      Toast.makeText(paramContext, "aging begin", 1).show();
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20199);
          a.S(localb.fLD);
          a.a(a.this, null, bs.getInt(paramArrayOfString[1], 0), localb);
          a.a(a.this, paramContext);
          AppMethodBeat.o(20199);
        }
      });
      AppMethodBeat.o(20204);
      return true;
    }
    if (paramArrayOfString.length < 3)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    final int j = bs.getInt(paramArrayOfString[2], 0);
    paramString = paramArrayOfString[1];
    i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(20204);
        return true;
        if (paramString.equals("1"))
        {
          i = 0;
          continue;
          if (paramString.equals("2"))
          {
            i = 1;
            continue;
            if (paramString.equals("3")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20200);
        a.ll(j);
        a.a(a.this, paramContext);
        AppMethodBeat.o(20200);
      }
    });
    AppMethodBeat.o(20204);
    return true;
    paramString = null;
    if (paramArrayOfString.length == 4) {
      paramString = paramArrayOfString[3];
    }
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20201);
        a.a(a.this, paramString, j, localb);
        a.a(a.this, paramContext);
        AppMethodBeat.o(20201);
      }
    });
    AppMethodBeat.o(20204);
    return true;
    AppMethodBeat.o(20204);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void execute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a
 * JD-Core Version:    0.7.0.1
 */