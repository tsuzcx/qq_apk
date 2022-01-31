package com.tencent.mm.aj;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

final class m$b
  implements az.a
{
  public byte[] frF = null;
  private final String fwM;
  private final String url;
  
  public m$b(String paramString1, String paramString2)
  {
    this.fwM = paramString1;
    this.url = paramString2;
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(11426);
    if ((bo.isNullOrNil(this.fwM)) || (bo.isNullOrNil(this.url)))
    {
      AppMethodBeat.o(11426);
      return false;
    }
    Object localObject1;
    Object localObject2;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject1 = b.x(this.url, 3000, 5000);
      if (localObject1 == null)
      {
        AppMethodBeat.o(11426);
        return false;
      }
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
    catch (Exception localException1)
    {
      ab.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bo.l(localException1) });
      ab.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
      this.frF = null;
      AppMethodBeat.o(11426);
      return false;
    }
    this.frF = localException1.toByteArray();
    localException1.close();
    if (bo.ce(this.frF))
    {
      ab.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.fwM);
      AppMethodBeat.o(11426);
      return false;
    }
    m.a locala;
    String str;
    if (g.RJ().QU())
    {
      ao.a.flJ.cq(this.frF.length, 0);
      locala = z.afs();
      localObject1 = this.fwM;
      str = this.url;
      localObject2 = this.frF;
    }
    try
    {
      str = (String)localObject1 + str;
      localObject2 = d.bT((byte[])localObject2);
      d.a((Bitmap)localObject2, 100, Bitmap.CompressFormat.PNG, m.a.sh(str), false);
      locala.g((String)localObject1, (Bitmap)localObject2);
      ab.i("MicroMsg.BrandLogic", "update brand icon for  " + (String)localObject1 + ", done");
      locala.fwJ.remove(localObject1);
      AppMethodBeat.o(11426);
      return true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bo.l(localException2) });
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(11427);
    m.a locala = z.afs();
    int i = 0;
    try
    {
      while (i < locala.fwI.size())
      {
        locala.fwI.get(i);
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.BrandLogic", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(11427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.m.b
 * JD-Core Version:    0.7.0.1
 */