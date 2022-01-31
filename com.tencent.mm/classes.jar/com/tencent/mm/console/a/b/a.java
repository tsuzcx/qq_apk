package com.tencent.mm.console.a.b;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final int[] eur;
  
  static
  {
    AppMethodBeat.i(16172);
    eur = new int[] { 0, 1 };
    try
    {
      Object localObject = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
      if ((localObject != null) && ((localObject instanceof com.tencent.mm.pluginsdk.cmd.a))) {
        com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)localObject, new String[] { "//aging" });
      }
      AppMethodBeat.o(16172);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.AgingTestCommand", localThrowable, "", new Object[0]);
      AppMethodBeat.o(16172);
    }
  }
  
  private static ad G(String paramString, int paramInt)
  {
    AppMethodBeat.i(16161);
    ad localad = new ad();
    localad.euF = (100000 + paramInt);
    localad.setUsername(paramString);
    localad.jm("alias_".concat(String.valueOf(paramInt)));
    localad.jp("nickName_".concat(String.valueOf(paramInt)));
    localad.jr("quanPin_".concat(String.valueOf(paramInt)));
    localad.jq("pyInitial_".concat(String.valueOf(paramInt)));
    localad.setType(3);
    AppMethodBeat.o(16161);
    return localad;
  }
  
  private static byte[] gd(long paramLong)
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
  
  private static int jb(int paramInt)
  {
    AppMethodBeat.i(16160);
    int j = (int)(Math.random() * paramInt);
    int i = j;
    if (j >= paramInt) {
      i = 0;
    }
    AppMethodBeat.o(16160);
    return i;
  }
  
  public final boolean a(final Context paramContext, final String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16159);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(16159);
      return false;
    }
    if (paramArrayOfString.length <= 1)
    {
      AppMethodBeat.o(16159);
      return false;
    }
    Object localObject1 = r.Zn();
    final b localb = new b();
    int i = 5001;
    while (i <= 6000)
    {
      localb.euz.add("rdgztest_atm".concat(String.valueOf(i)));
      i += 1;
    }
    paramString = ((j)g.E(j.class)).bPQ().bPX();
    localObject1 = paramString.a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[] { localObject1 }, 0);
    while (((Cursor)localObject1).moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom((Cursor)localObject1);
      Cursor localCursor;
      Object localObject2;
      switch (localbi.getType())
      {
      default: 
        break;
      case 3: 
        localCursor = paramString.a("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[] { String.valueOf(localbi.field_msgSvrId) }, 0);
        if (localCursor.moveToNext())
        {
          localObject2 = new e();
          ((e)localObject2).convertFrom(localCursor);
          localb.euA.add(new c(localbi, localObject2));
        }
        localCursor.close();
        break;
      case 43: 
        localCursor = paramString.a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[] { String.valueOf(localbi.field_msgSvrId) }, 0);
        if (localCursor.moveToNext())
        {
          localObject2 = new s();
          ((s)localObject2).convertFrom(localCursor);
          localb.euB.add(new c(localbi, localObject2));
        }
        localCursor.close();
        break;
      case 47: 
        localCursor = paramString.a("SELECT * FROM EmojiInfo WHERE md5=?", new String[] { localbi.field_imgPath }, 0);
        if (localCursor.moveToNext())
        {
          localObject2 = new EmojiInfo();
          ((EmojiInfo)localObject2).convertFrom(localCursor);
          localb.euC.add(new c(localbi, localObject2));
        }
        localCursor.close();
      }
    }
    ((Cursor)localObject1).close();
    if ((localb.euA.isEmpty()) && (localb.euC.isEmpty()) && (localb.euB.isEmpty()))
    {
      Toast.makeText(paramContext, "please send some data(img,video,emoji) to yourself", 1).show();
      AppMethodBeat.o(16159);
      return false;
    }
    ab.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[] { Integer.valueOf(localb.euz.size()), Integer.valueOf(localb.euA.size()), Integer.valueOf(localb.euC.size()), Integer.valueOf(localb.euB.size()) });
    if (paramArrayOfString.length == 2)
    {
      Toast.makeText(paramContext, "aging begin", 1).show();
      aw.RO().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(16154);
          a.O(localb.euz);
          a.a(a.this, null, bo.getInt(paramArrayOfString[1], 0), localb);
          a.a(a.this, paramContext);
          AppMethodBeat.o(16154);
        }
      });
      AppMethodBeat.o(16159);
      return true;
    }
    if (paramArrayOfString.length < 3)
    {
      AppMethodBeat.o(16159);
      return false;
    }
    int j = bo.getInt(paramArrayOfString[2], 0);
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
        AppMethodBeat.o(16159);
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
    aw.RO().ac(new a.2(this, j, paramContext));
    AppMethodBeat.o(16159);
    return true;
    paramString = null;
    if (paramArrayOfString.length == 4) {
      paramString = paramArrayOfString[3];
    }
    aw.RO().ac(new a.3(this, paramString, j, localb, paramContext));
    AppMethodBeat.o(16159);
    return true;
    AppMethodBeat.o(16159);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a
 * JD-Core Version:    0.7.0.1
 */