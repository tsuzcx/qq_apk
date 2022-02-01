package com.tencent.mm.console.a.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.i.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storagebase.h;
import java.util.List;

public class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final int[] gML;
  
  static
  {
    AppMethodBeat.i(20217);
    gML = new int[] { 0, 1 };
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
      Log.printErrStackTrace("MicroMsg.AgingTestCommand", localThrowable, "", new Object[0]);
      AppMethodBeat.o(20217);
    }
  }
  
  private static as M(String paramString, int paramInt)
  {
    AppMethodBeat.i(20206);
    as localas = new as();
    localas.gMZ = (100000 + paramInt);
    localas.setUsername(paramString);
    localas.BC("alias_".concat(String.valueOf(paramInt)));
    localas.setNickname("nickName_".concat(String.valueOf(paramInt)));
    localas.BG("quanPin_".concat(String.valueOf(paramInt)));
    localas.BF("pyInitial_".concat(String.valueOf(paramInt)));
    localas.setType(3);
    AppMethodBeat.o(20206);
    return localas;
  }
  
  private static int oO(int paramInt)
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
  
  private static byte[] yW(long paramLong)
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
    paramString = z.aTY();
    final b localb = new b();
    int i = 5001;
    while (i <= 6000)
    {
      localb.gMT.add("rdgztest_atm".concat(String.valueOf(i)));
      i += 1;
    }
    h localh = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().getDB();
    Cursor localCursor1 = localh.rawQuery("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[] { paramString });
    while (localCursor1.moveToNext())
    {
      ca localca = new ca();
      localca.convertFrom(localCursor1);
      Cursor localCursor2;
      Object localObject;
      switch (localca.getType())
      {
      default: 
        break;
      case 3: 
        localCursor2 = localh.rawQuery("SELECT * FROM " + i.d.OH(paramString) + " WHERE msgSvrId=?", new String[] { String.valueOf(localca.field_msgSvrId) });
        if (localCursor2.moveToNext())
        {
          localObject = new com.tencent.mm.av.g();
          ((com.tencent.mm.av.g)localObject).convertFrom(localCursor2);
          localb.gMU.add(new c(localca, localObject));
        }
        localCursor2.close();
        break;
      case 43: 
        localCursor2 = localh.rawQuery("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[] { String.valueOf(localca.field_msgSvrId) });
        if (localCursor2.moveToNext())
        {
          localObject = new s();
          ((s)localObject).convertFrom(localCursor2);
          localb.gMV.add(new c(localca, localObject));
        }
        localCursor2.close();
        break;
      case 47: 
        localCursor2 = localh.rawQuery("SELECT * FROM EmojiInfo WHERE md5=?", new String[] { localca.field_imgPath });
        if (localCursor2.moveToNext())
        {
          localObject = new EmojiInfo();
          ((EmojiInfo)localObject).convertFrom(localCursor2);
          localb.gMW.add(new c(localca, localObject));
        }
        localCursor2.close();
      }
    }
    localCursor1.close();
    if ((localb.gMU.isEmpty()) && (localb.gMW.isEmpty()) && (localb.gMV.isEmpty()))
    {
      Toast.makeText(paramContext, "please send some data(img,video,emoji) to yourself", 1).show();
      AppMethodBeat.o(20204);
      return false;
    }
    Log.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[] { Integer.valueOf(localb.gMT.size()), Integer.valueOf(localb.gMU.size()), Integer.valueOf(localb.gMW.size()), Integer.valueOf(localb.gMV.size()) });
    if (paramArrayOfString.length == 2)
    {
      Toast.makeText(paramContext, "aging begin", 1).show();
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(20199);
          a.Z(localb.gMT);
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
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(20200);
        a.oP(j);
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
    bg.aAk().postToWorker(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a
 * JD-Core Version:    0.7.0.1
 */