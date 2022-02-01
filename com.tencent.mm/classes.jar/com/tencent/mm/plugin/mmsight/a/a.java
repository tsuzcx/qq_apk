package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static void a(a.a parama)
  {
    AppMethodBeat.i(94389);
    Log.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    h.IzE.a(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.source) });
    AppMethodBeat.o(94389);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(94388);
    h localh = h.IzE;
    int j = paramb.scene;
    if (paramb.kUn) {}
    for (int i = 2;; i = 1)
    {
      localh.a(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.FcE), Integer.valueOf(paramb.FcF), Integer.valueOf(paramb.FcH), Boolean.valueOf(paramb.FcG), Integer.valueOf(paramb.iTI), Integer.valueOf(paramb.FcC), Integer.valueOf(paramb.FcD), Integer.valueOf(paramb.FcI), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(Util.nowSecond()) });
      Log.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(94388);
      return;
    }
  }
  
  public static final class b
  {
    public int FcC;
    public int FcD;
    public int FcE;
    public int FcF;
    public boolean FcG;
    public int FcH;
    public int FcI;
    public int iTI;
    public boolean kUn;
    public int scene;
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
      String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.kUn + ", rawDuration=" + this.FcC + ", cropDuration=" + this.FcD + ", emojiItemCount=" + this.FcE + ", textItemCount=" + this.FcF + ", isCrop=" + this.FcG + ", undoCount=" + this.iTI + ", doodleCount=" + this.FcH + ", penColors=" + this.FcI + ", textColor=" + this.textColor + '}';
      AppMethodBeat.o(94387);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */