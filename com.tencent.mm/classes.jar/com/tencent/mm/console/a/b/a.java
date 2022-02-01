package com.tencent.mm.console.a.b;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j.d;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final int[] mau;
  
  static
  {
    AppMethodBeat.i(20217);
    mau = new int[] { 0, 1 };
    try
    {
      Object localObject = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
      if ((localObject != null) && ((localObject instanceof com.tencent.mm.pluginsdk.cmd.a))) {
        com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)localObject, new String[] { "//aging" });
      }
      AppMethodBeat.o(20217);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.AgingTestCommand", localThrowable, "", new Object[0]);
      AppMethodBeat.o(20217);
    }
  }
  
  private static au an(String paramString, int paramInt)
  {
    AppMethodBeat.i(20206);
    au localau = new au();
    localau.maN = (100000 + paramInt);
    localau.setUsername(paramString);
    localau.AV("alias_".concat(String.valueOf(paramInt)));
    localau.setNickname("nickName_".concat(String.valueOf(paramInt)));
    localau.AZ("quanPin_".concat(String.valueOf(paramInt)));
    localau.AY("pyInitial_".concat(String.valueOf(paramInt)));
    localau.setType(3);
    AppMethodBeat.o(20206);
    return localau;
  }
  
  private static byte[] hr(long paramLong)
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
  
  private static int rp(int paramInt)
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
  
  public final boolean a(final Context paramContext, final String[] paramArrayOfString, final String paramString)
  {
    AppMethodBeat.i(20204);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    paramString = com.tencent.mm.model.z.bAM();
    final b localb = new b();
    int i = 5001;
    while (i <= 6000)
    {
      localb.maB.add("rdgztest_atm".concat(String.valueOf(i)));
      i += 1;
    }
    com.tencent.mm.storagebase.h localh = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().getDB();
    Cursor localCursor1 = localh.rawQuery("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[] { paramString });
    while (localCursor1.moveToNext())
    {
      cc localcc = new cc();
      localcc.convertFrom(localCursor1);
      Cursor localCursor2;
      Object localObject;
      switch (localcc.getType())
      {
      default: 
        break;
      case 3: 
        localCursor2 = localh.rawQuery("SELECT * FROM " + j.d.Og(paramString) + " WHERE msgSvrId=?", new String[] { String.valueOf(localcc.field_msgSvrId) });
        if (localCursor2.moveToNext())
        {
          localObject = new com.tencent.mm.modelimage.h();
          ((com.tencent.mm.modelimage.h)localObject).convertFrom(localCursor2);
          localb.maC.add(new c(localcc, localObject));
        }
        localCursor2.close();
        break;
      case 43: 
        localCursor2 = localh.rawQuery("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[] { String.valueOf(localcc.field_msgSvrId) });
        if (localCursor2.moveToNext())
        {
          localObject = new com.tencent.mm.modelvideo.z();
          ((com.tencent.mm.modelvideo.z)localObject).convertFrom(localCursor2);
          localb.maD.add(new c(localcc, localObject));
        }
        localCursor2.close();
        break;
      case 47: 
        localCursor2 = localh.rawQuery("SELECT * FROM EmojiInfo WHERE md5=?", new String[] { localcc.field_imgPath });
        if (localCursor2.moveToNext())
        {
          localObject = new EmojiInfo();
          ((EmojiInfo)localObject).convertFrom(localCursor2);
          localb.maE.add(new c(localcc, localObject));
        }
        localCursor2.close();
      }
    }
    localCursor1.close();
    if ((localb.maC.isEmpty()) && (localb.maE.isEmpty()) && (localb.maD.isEmpty()))
    {
      Toast.makeText(paramContext, "please send some data(img,video,emoji) to yourself", 1).show();
      AppMethodBeat.o(20204);
      return false;
    }
    Log.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[] { Integer.valueOf(localb.maB.size()), Integer.valueOf(localb.maC.size()), Integer.valueOf(localb.maE.size()), Integer.valueOf(localb.maD.size()) });
    if (paramArrayOfString.length == 2)
    {
      Toast.makeText(paramContext, "aging begin", 1).show();
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20199);
          a.bx(localb.maB);
          a.a(a.this, null, Util.getInt(paramArrayOfString[1], 0), localb);
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
    final int j = Util.getInt(paramArrayOfString[2], 0);
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
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20200);
        a.rq(j);
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
    bh.baH().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a
 * JD-Core Version:    0.7.0.1
 */