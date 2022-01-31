package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.h.b.a.j;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class n$2
  implements Runnable
{
  n$2(n paramn, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString6) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.sight.base.a locala = d.MH(this.dlh);
    if (locala == null)
    {
      y.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", new Object[] { this.dlh });
      return;
    }
    int j = e.bJ(this.dlh);
    Object localObject1 = null;
    if (this.eGU != null)
    {
      localObject1 = new StringBuffer();
      localObject2 = this.eGU;
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        ((StringBuffer)localObject1).append(localObject2[i]).append("|");
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject1).toString();
    }
    int i = aq.fJ(ae.getContext());
    f.Ne();
    Object localObject2 = com.tencent.mm.ak.a.lH(this.dlh);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dUz).append(",").append(this.eGV).append(",");
    localStringBuffer.append(this.eGW).append(",").append(this.eGX).append(",");
    localStringBuffer.append(this.eGY).append(",").append(i).append(",");
    localStringBuffer.append((String)localObject2).append(",").append(this.eow).append(",");
    localStringBuffer.append(this.eGZ).append(",").append(j).append(",");
    localStringBuffer.append(locala.jlu).append(",").append(locala.videoBitrate / 1000).append(",");
    localStringBuffer.append(locala.ejM / 1000).append(",").append(locala.eIM).append(",");
    localStringBuffer.append(locala.width).append(",").append(locala.height).append(",");
    localStringBuffer.append((String)localObject1).append(",").append(locala.odX).append(",");
    localStringBuffer.append(this.eHa).append(",").append(this.eHb).append(",");
    localStringBuffer.append(c.PU(this.eHc));
    y.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", new Object[] { localStringBuffer.toString() });
    new j(localStringBuffer.toString()).QX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n.2
 * JD-Core Version:    0.7.0.1
 */