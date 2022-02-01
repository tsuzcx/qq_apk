package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  public static void a(a.a parama)
  {
    AppMethodBeat.i(94389);
    ae.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    g.yxI.f(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.doj) });
    AppMethodBeat.o(94389);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(94388);
    g localg = g.yxI;
    int j = paramb.scene;
    if (paramb.hmD) {}
    for (int i = 2;; i = 1)
    {
      localg.f(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.wdj), Integer.valueOf(paramb.wdk), Integer.valueOf(paramb.wdm), Boolean.valueOf(paramb.wdl), Integer.valueOf(paramb.fKl), Integer.valueOf(paramb.wdh), Integer.valueOf(paramb.wdi), Integer.valueOf(paramb.wdn), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(bu.aRi()) });
      ae.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(94388);
      return;
    }
  }
  
  public static final class b
  {
    public int fKl;
    public boolean hmD;
    public int scene;
    public int textColor;
    public int wdh;
    public int wdi;
    public int wdj;
    public int wdk;
    public boolean wdl;
    public int wdm;
    public int wdn;
    
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
      String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.hmD + ", rawDuration=" + this.wdh + ", cropDuration=" + this.wdi + ", emojiItemCount=" + this.wdj + ", textItemCount=" + this.wdk + ", isCrop=" + this.wdl + ", undoCount=" + this.fKl + ", doodleCount=" + this.wdm + ", penColors=" + this.wdn + ", textColor=" + this.textColor + '}';
      AppMethodBeat.o(94387);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */