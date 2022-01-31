package com.tencent.mm.modelvideo;

import com.tencent.mm.h.b.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class i
  implements f.a
{
  public boolean eGA = false;
  public boolean eGB = false;
  private boolean eGC = false;
  private boolean eGD = false;
  f eGE = null;
  long eGF = 0L;
  LinkedList<bi> eGw = new LinkedList();
  long eGx = 0L;
  private int eGy = 0;
  private int eGz = 0;
  
  public final void Sk()
  {
    g.DS().O(new i.2(this));
  }
  
  public final void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramf == null)
    {
      y.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    if (this.eGE != paramf) {
      y.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    y.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.getTips(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g.DS().O(new i.3(this, paramf));
  }
  
  public final void a(String paramString1, int paramInt1, long paramLong, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(bk.UX()).append(",");
    localStringBuffer.append(bk.UX()).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramString1).append(",");
    localStringBuffer.append(paramInt1).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramLong).append(",");
    localStringBuffer.append(",");
    localStringBuffer.append(paramString2).append(",");
    localStringBuffer.append(paramString3).append(",");
    localStringBuffer.append(paramInt2).append(",");
    localStringBuffer.append(paramString4).append(",");
    localStringBuffer.append(paramString5).append(",");
    localStringBuffer.append(c.PU(paramString6));
    paramString1 = localStringBuffer.toString();
    y.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString1 });
    new p(paramString1).QX();
  }
  
  public final void cf(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.eGy = ((Integer)g.DP().Dz().get(ac.a.uwF, Integer.valueOf(0))).intValue();
      this.eGy += 1;
      g.DP().Dz().c(ac.a.uwF, Integer.valueOf(this.eGy));
      return;
    }
    this.eGz = ((Integer)g.DP().Dz().get(ac.a.uwG, Integer.valueOf(0))).intValue();
    this.eGz += 1;
    g.DP().Dz().c(ac.a.uwG, Integer.valueOf(this.eGz));
  }
  
  public final boolean cg(boolean paramBoolean)
  {
    int k = 100;
    this.eGx = ((Long)g.DP().Dz().get(ac.a.uwE, Long.valueOf(-1L))).longValue();
    if (bk.co(this.eGx) >= 86400000L)
    {
      this.eGx = bk.UY();
      g.DP().Dz().c(ac.a.uwE, Long.valueOf(this.eGx));
      g.DP().Dz().c(ac.a.uwF, Integer.valueOf(0));
      g.DP().Dz().c(ac.a.uwG, Integer.valueOf(0));
      this.eGD = false;
      this.eGC = false;
    }
    this.eGy = ((Integer)g.DP().Dz().get(ac.a.uwF, Integer.valueOf(0))).intValue();
    this.eGz = ((Integer)g.DP().Dz().get(ac.a.uwG, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.eGy;
      i = ((a)g.r(a.class)).AA().getInt("C2CMaxPreloadVideo", 100);
      if (i > 0) {
        break label380;
      }
      i = k;
    }
    label212:
    label351:
    label380:
    for (;;)
    {
      boolean bool;
      if (j >= i)
      {
        bool = true;
        y.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.eGy), Integer.valueOf(this.eGz) });
        if (bool)
        {
          if (!paramBoolean) {
            break label351;
          }
          if (!this.eGC)
          {
            this.eGC = true;
            h.nFQ.a(354L, 127L, 1L, false);
          }
        }
      }
      while (this.eGD)
      {
        return bool;
        j = this.eGz;
        i = ((a)g.r(a.class)).AA().getInt("SnsMaxPreloadVideo", 100);
        break;
        bool = false;
        break label212;
      }
      this.eGD = true;
      h.nFQ.a(354L, 128L, 1L, false);
      return bool;
    }
  }
  
  public final void stopDownload()
  {
    y.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    g.DS().O(new i.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i
 * JD-Core Version:    0.7.0.1
 */