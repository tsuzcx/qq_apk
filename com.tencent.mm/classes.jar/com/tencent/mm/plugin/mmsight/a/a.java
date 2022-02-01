package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  public static void a(a parama)
  {
    AppMethodBeat.i(94389);
    ad.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    h.vKh.f(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.dep) });
    AppMethodBeat.o(94389);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(94388);
    h localh = h.vKh;
    int j = paramb.scene;
    if (paramb.gqP) {}
    for (int i = 2;; i = 1)
    {
      localh.f(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.tFB), Integer.valueOf(paramb.tFC), Integer.valueOf(paramb.tFE), Boolean.valueOf(paramb.tFD), Integer.valueOf(paramb.fmF), Integer.valueOf(paramb.tFz), Integer.valueOf(paramb.tFA), Integer.valueOf(paramb.tFF), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(bt.aGK()) });
      ad.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(94388);
      return;
    }
  }
  
  public static final class a
  {
    int dep;
    int scene;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(94384);
      this.dep = 2;
      if (paramInt == 1)
      {
        this.scene = 1;
        AppMethodBeat.o(94384);
        return;
      }
      if (paramInt == 2)
      {
        this.scene = 2;
        AppMethodBeat.o(94384);
        return;
      }
      if (paramInt == 512)
      {
        this.dep = 1;
        this.scene = 2;
        AppMethodBeat.o(94384);
        return;
      }
      if (paramInt == 4) {
        this.scene = 4;
      }
      AppMethodBeat.o(94384);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(94385);
      String str = "VideoEditCountData{scene=" + this.scene + ", source=" + this.dep + '}';
      AppMethodBeat.o(94385);
      return str;
    }
  }
  
  public static final class b
  {
    public int fmF;
    public boolean gqP;
    public int scene;
    public int tFA;
    public int tFB;
    public int tFC;
    public boolean tFD;
    public int tFE;
    public int tFF;
    public int tFz;
    public int textColor;
    
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
      String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.gqP + ", rawDuration=" + this.tFz + ", cropDuration=" + this.tFA + ", emojiItemCount=" + this.tFB + ", textItemCount=" + this.tFC + ", isCrop=" + this.tFD + ", undoCount=" + this.fmF + ", doodleCount=" + this.tFE + ", penColors=" + this.tFF + ", textColor=" + this.textColor + '}';
      AppMethodBeat.o(94387);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */