package com.tencent.mm.console.a.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.i.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storagebase.h;
import java.util.List;

public class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final int[] geV;
  
  static
  {
    AppMethodBeat.i(20217);
    geV = new int[] { 0, 1 };
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
      ad.printErrStackTrace("MicroMsg.AgingTestCommand", localThrowable, "", new Object[0]);
      AppMethodBeat.o(20217);
    }
  }
  
  private static am K(String paramString, int paramInt)
  {
    AppMethodBeat.i(20206);
    am localam = new am();
    localam.gfj = (100000 + paramInt);
    localam.setUsername(paramString);
    localam.sQ("alias_".concat(String.valueOf(paramInt)));
    localam.sT("nickName_".concat(String.valueOf(paramInt)));
    localam.sV("quanPin_".concat(String.valueOf(paramInt)));
    localam.sU("pyInitial_".concat(String.valueOf(paramInt)));
    localam.setType(3);
    AppMethodBeat.o(20206);
    return localam;
  }
  
  private static int lJ(int paramInt)
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
  
  private static byte[] qS(long paramLong)
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
    if (ad.getLogLevel() > 1)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(20204);
      return false;
    }
    paramString = u.aAm();
    final b localb = new b();
    int i = 5001;
    while (i <= 6000)
    {
      localb.gfd.add("rdgztest_atm".concat(String.valueOf(i)));
      i += 1;
    }
    h localh = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().getDB();
    Cursor localCursor1 = localh.a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[] { paramString }, 0);
    while (localCursor1.moveToNext())
    {
      bu localbu = new bu();
      localbu.convertFrom(localCursor1);
      Cursor localCursor2;
      Object localObject;
      switch (localbu.getType())
      {
      default: 
        break;
      case 3: 
        localCursor2 = localh.a("SELECT * FROM " + i.d.Fu(paramString) + " WHERE msgSvrId=?", new String[] { String.valueOf(localbu.field_msgSvrId) }, 0);
        if (localCursor2.moveToNext())
        {
          localObject = new com.tencent.mm.aw.g();
          ((com.tencent.mm.aw.g)localObject).convertFrom(localCursor2);
          localb.gfe.add(new c(localbu, localObject));
        }
        localCursor2.close();
        break;
      case 43: 
        localCursor2 = localh.a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[] { String.valueOf(localbu.field_msgSvrId) }, 0);
        if (localCursor2.moveToNext())
        {
          localObject = new s();
          ((s)localObject).convertFrom(localCursor2);
          localb.gff.add(new c(localbu, localObject));
        }
        localCursor2.close();
        break;
      case 47: 
        localCursor2 = localh.a("SELECT * FROM EmojiInfo WHERE md5=?", new String[] { localbu.field_imgPath }, 0);
        if (localCursor2.moveToNext())
        {
          localObject = new EmojiInfo();
          ((EmojiInfo)localObject).convertFrom(localCursor2);
          localb.gfg.add(new c(localbu, localObject));
        }
        localCursor2.close();
      }
    }
    localCursor1.close();
    if ((localb.gfe.isEmpty()) && (localb.gfg.isEmpty()) && (localb.gff.isEmpty()))
    {
      Toast.makeText(paramContext, "please send some data(img,video,emoji) to yourself", 1).show();
      AppMethodBeat.o(20204);
      return false;
    }
    ad.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[] { Integer.valueOf(localb.gfd.size()), Integer.valueOf(localb.gfe.size()), Integer.valueOf(localb.gfg.size()), Integer.valueOf(localb.gff.size()) });
    if (paramArrayOfString.length == 2)
    {
      Toast.makeText(paramContext, "aging begin", 1).show();
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20199);
          a.T(localb.gfd);
          a.a(a.this, null, bt.getInt(paramArrayOfString[1], 0), localb);
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
    final int j = bt.getInt(paramArrayOfString[2], 0);
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
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20200);
        a.lK(j);
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
    ba.ajF().ay(new Runnable()
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