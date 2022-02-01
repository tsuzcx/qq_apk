package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public static void a(a.a parama)
  {
    AppMethodBeat.i(94389);
    ac.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    h.wUl.f(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.dbL) });
    AppMethodBeat.o(94389);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(94388);
    h localh = h.wUl;
    int j = paramb.scene;
    if (paramb.gRx) {}
    for (int i = 2;; i = 1)
    {
      localh.f(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.uNW), Integer.valueOf(paramb.uNX), Integer.valueOf(paramb.uNZ), Boolean.valueOf(paramb.uNY), Integer.valueOf(paramb.fqa), Integer.valueOf(paramb.uNU), Integer.valueOf(paramb.uNV), Integer.valueOf(paramb.uOa), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(bs.aNx()) });
      ac.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(94388);
      return;
    }
  }
  
  public static final class b
  {
    public int fqa;
    public boolean gRx;
    public int scene;
    public int textColor;
    public int uNU;
    public int uNV;
    public int uNW;
    public int uNX;
    public boolean uNY;
    public int uNZ;
    public int uOa;
    
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
      String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.gRx + ", rawDuration=" + this.uNU + ", cropDuration=" + this.uNV + ", emojiItemCount=" + this.uNW + ", textItemCount=" + this.uNX + ", isCrop=" + this.uNY + ", undoCount=" + this.fqa + ", doodleCount=" + this.uNZ + ", penColors=" + this.uOa + ", textColor=" + this.textColor + '}';
      AppMethodBeat.o(94387);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */