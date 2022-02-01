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
    h.CyF.a(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.source) });
    AppMethodBeat.o(94389);
  }
  
  public static void a(b paramb, String paramString)
  {
    AppMethodBeat.i(94388);
    h localh = h.CyF;
    int j = paramb.scene;
    if (paramb.ifz) {}
    for (int i = 2;; i = 1)
    {
      localh.a(14362, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramb.zxk), Integer.valueOf(paramb.zxl), Integer.valueOf(paramb.zxn), Boolean.valueOf(paramb.zxm), Integer.valueOf(paramb.gpA), Integer.valueOf(paramb.zxi), Integer.valueOf(paramb.zxj), Integer.valueOf(paramb.zxo), Integer.valueOf(0), Integer.valueOf(paramb.textColor), paramString, Long.valueOf(Util.nowSecond()) });
      Log.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", new Object[] { paramb.toString() });
      AppMethodBeat.o(94388);
      return;
    }
  }
  
  public static final class b
  {
    public int gpA;
    public boolean ifz;
    public int scene;
    public int textColor;
    public int zxi;
    public int zxj;
    public int zxk;
    public int zxl;
    public boolean zxm;
    public int zxn;
    public int zxo;
    
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
      String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.ifz + ", rawDuration=" + this.zxi + ", cropDuration=" + this.zxj + ", emojiItemCount=" + this.zxk + ", textItemCount=" + this.zxl + ", isCrop=" + this.zxm + ", undoCount=" + this.gpA + ", doodleCount=" + this.zxn + ", penColors=" + this.zxo + ", textColor=" + this.textColor + '}';
      AppMethodBeat.o(94387);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */