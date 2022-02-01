package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static void a(a.a parama)
  {
    AppMethodBeat.i(94389);
    ad.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    g.yhR.f(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.dnh) });
    AppMethodBeat.o(94389);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(94388);
    g localg = g.yhR;
    int j = paramb.scene;
    if (paramb.hjP) {}
    for (int i = 2;; i = 1)
    {
      localg.f(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.vRf), Integer.valueOf(paramb.vRg), Integer.valueOf(paramb.vRi), Boolean.valueOf(paramb.vRh), Integer.valueOf(paramb.fIh), Integer.valueOf(paramb.vRd), Integer.valueOf(paramb.vRe), Integer.valueOf(paramb.vRj), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(bt.aQJ()) });
      ad.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(94388);
      return;
    }
  }
  
  public static final class b
  {
    public int fIh;
    public boolean hjP;
    public int scene;
    public int textColor;
    public int vRd;
    public int vRe;
    public int vRf;
    public int vRg;
    public boolean vRh;
    public int vRi;
    public int vRj;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(94386);
      if (paramInt == 1)
      {
        this.scene = 2;
        AppMethodBeat.o(94386);
        return;
      }
      if (paramInt == 2)
      {
        this.scene = 4;
        AppMethodBeat.o(94386);
        return;
      }
      if (paramInt == 512)
      {
        this.scene = 3;
        AppMethodBeat.o(94386);
        return;
      }
      if (paramInt == 4) {
        this.scene = 8;
      }
      AppMethodBeat.o(94386);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(94387);
      String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.hjP + ", rawDuration=" + this.vRd + ", cropDuration=" + this.vRe + ", emojiItemCount=" + this.vRf + ", textItemCount=" + this.vRg + ", isCrop=" + this.vRh + ", undoCount=" + this.fIh + ", doodleCount=" + this.vRi + ", penColors=" + this.vRj + ", textColor=" + this.textColor + '}';
      AppMethodBeat.o(94387);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */