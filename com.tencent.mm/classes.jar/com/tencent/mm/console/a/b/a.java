package com.tencent.mm.console.a.b;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.as.e;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  private static final int[] dAQ = { 0, 1 };
  
  static
  {
    try
    {
      Object localObject = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
      if ((localObject != null) && ((localObject instanceof com.tencent.mm.pluginsdk.cmd.a))) {
        com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)localObject, new String[] { "//aging" });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.AgingTestCommand", localThrowable, "", new Object[0]);
    }
  }
  
  private static ad B(String paramString, int paramInt)
  {
    ad localad = new ad();
    localad.dBe = (100000 + paramInt);
    localad.setUsername(paramString);
    localad.cZ("alias_" + paramInt);
    localad.dk("nickName_" + paramInt);
    localad.dm("quanPin_" + paramInt);
    localad.dl("pyInitial_" + paramInt);
    localad.setType(3);
    return localad;
  }
  
  private static byte[] bt(long paramLong)
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
  
  private static int gO(int paramInt)
  {
    int j = (int)(Math.random() * paramInt);
    int i = j;
    if (j >= paramInt) {
      i = 0;
    }
    return i;
  }
  
  public final boolean a(final Context paramContext, final String[] paramArrayOfString)
  {
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length <= 1) {
      return false;
    }
    Object localObject2 = q.Gj();
    final b localb = new b();
    int i = 5001;
    while (i <= 6000)
    {
      localb.dAY.add("rdgztest_atm" + i);
      i += 1;
    }
    Object localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bhV();
    localObject2 = ((h)localObject1).a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[] { localObject2 }, 0);
    while (((Cursor)localObject2).moveToNext())
    {
      bi localbi = new bi();
      localbi.d((Cursor)localObject2);
      Cursor localCursor;
      Object localObject3;
      switch (localbi.getType())
      {
      default: 
        break;
      case 3: 
        localCursor = ((h)localObject1).a("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[] { String.valueOf(localbi.field_msgSvrId) }, 0);
        if (localCursor.moveToNext())
        {
          localObject3 = new e();
          ((e)localObject3).d(localCursor);
          localb.dAZ.add(new c(localbi, localObject3));
        }
        localCursor.close();
        break;
      case 43: 
        localCursor = ((h)localObject1).a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[] { String.valueOf(localbi.field_msgSvrId) }, 0);
        if (localCursor.moveToNext())
        {
          localObject3 = new s();
          ((s)localObject3).d(localCursor);
          localb.dBa.add(new c(localbi, localObject3));
        }
        localCursor.close();
        break;
      case 47: 
        localCursor = ((h)localObject1).a("SELECT * FROM EmojiInfo WHERE md5=?", new String[] { localbi.field_imgPath }, 0);
        if (localCursor.moveToNext())
        {
          localObject3 = new EmojiInfo();
          ((EmojiInfo)localObject3).d(localCursor);
          localb.dBb.add(new c(localbi, localObject3));
        }
        localCursor.close();
      }
    }
    ((Cursor)localObject2).close();
    if ((localb.dAZ.isEmpty()) && (localb.dBb.isEmpty()) && (localb.dBa.isEmpty()))
    {
      Toast.makeText(paramContext, "please send some data(img,video,emoji) to yourself", 1).show();
      return false;
    }
    y.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", new Object[] { Integer.valueOf(localb.dAY.size()), Integer.valueOf(localb.dAZ.size()), Integer.valueOf(localb.dBb.size()), Integer.valueOf(localb.dBa.size()) });
    if (paramArrayOfString.length == 2)
    {
      Toast.makeText(paramContext, "aging begin", 1).show();
      au.DS().O(new Runnable()
      {
        public final void run()
        {
          a.H(localb.dAY);
          a.a(a.this, null, bk.getInt(paramArrayOfString[1], 0), localb);
          a.a(a.this, paramContext);
        }
      });
      return true;
    }
    if (paramArrayOfString.length < 3) {
      return false;
    }
    int j = bk.getInt(paramArrayOfString[2], 0);
    localObject1 = paramArrayOfString[1];
    i = -1;
    switch (((String)localObject1).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return true;
        if (((String)localObject1).equals("1"))
        {
          i = 0;
          continue;
          if (((String)localObject1).equals("2"))
          {
            i = 1;
            continue;
            if (((String)localObject1).equals("3")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    au.DS().O(new a.2(this, j, paramContext));
    return true;
    localObject1 = null;
    if (paramArrayOfString.length == 4) {
      localObject1 = paramArrayOfString[3];
    }
    au.DS().O(new a.3(this, (String)localObject1, j, localb, paramContext));
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a
 * JD-Core Version:    0.7.0.1
 */