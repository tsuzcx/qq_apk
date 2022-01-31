package com.tencent.mm.ai;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.e;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

final class m$b
  implements av.a
{
  public byte[] ebn = null;
  private final String egI;
  private final String url;
  
  public m$b(String paramString1, String paramString2)
  {
    this.egI = paramString1;
    this.url = paramString2;
  }
  
  public final boolean JS()
  {
    if ((bk.bl(this.egI)) || (bk.bl(this.url))) {}
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return false;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject1 = b.n(this.url, 3000, 5000);
        if (localObject1 != null)
        {
          localObject2 = new byte[1024];
          for (;;)
          {
            int i = ((InputStream)localObject1).read((byte[])localObject2);
            if (i == -1) {
              break;
            }
            localByteArrayOutputStream.write((byte[])localObject2, 0, i);
          }
          ((InputStream)localObject1).close();
        }
      }
      catch (Exception localException1)
      {
        y.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bk.j(localException1) });
        y.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
        this.ebn = null;
        return false;
      }
    }
    this.ebn = localException1.toByteArray();
    localException1.close();
    if (bk.bE(this.ebn))
    {
      y.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.egI);
      return false;
    }
    m.a locala;
    String str;
    if (g.DN().Dc())
    {
      am.a.dVz.bg(this.ebn.length, 0);
      locala = z.MI();
      localObject1 = this.egI;
      str = this.url;
      localObject2 = this.ebn;
    }
    try
    {
      str = (String)localObject1 + str;
      localObject2 = c.bu((byte[])localObject2);
      c.a((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, m.a.ll(str), false);
      locala.f((String)localObject1, (Bitmap)localObject2);
      y.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
      locala.egF.remove(localObject1);
      return true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bk.j(localException2) });
      }
    }
  }
  
  public final boolean JT()
  {
    m.a locala = z.MI();
    String str = this.egI;
    int i = 0;
    try
    {
      while (i < locala.egE.size())
      {
        ((m.a.a)locala.egE.get(i)).lm(str);
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.m.b
 * JD-Core Version:    0.7.0.1
 */