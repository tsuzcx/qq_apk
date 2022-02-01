package com.tencent.mm.ah;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;

public final class y
  extends jb
{
  public float hGA = 0.0F;
  private String hGB = null;
  public int hGC;
  public int hGD;
  public int hGE;
  public int hGF;
  public int hGG = 0;
  public long hGH = -1L;
  public String hGI;
  public boolean hGJ = false;
  public int idx = 0;
  
  public final y a(jb paramjb)
  {
    if (paramjb == null) {
      return null;
    }
    this.FUw = paramjb.FUw;
    this.videoUrl = paramjb.videoUrl;
    this.FUx = paramjb.FUx;
    this.title = paramjb.title;
    this.hGe = paramjb.hGe;
    this.videoDuration = paramjb.videoDuration;
    this.width = paramjb.width;
    this.height = paramjb.height;
    this.url = paramjb.url;
    this.dpP = paramjb.dpP;
    this.hFW = paramjb.hFW;
    this.hFX = paramjb.hFX;
    this.dPO = paramjb.dPO;
    this.dPN = paramjb.dPN;
    return this;
  }
  
  public final void azu()
  {
    AppMethodBeat.i(116426);
    if (this.hGH != -1L)
    {
      AppMethodBeat.o(116426);
      return;
    }
    try
    {
      Uri localUri = Uri.parse(this.FUw);
      this.hGH = bu.getLong(localUri.getQueryParameter("mid"), 0L);
      this.idx = bu.getInt(localUri.getQueryParameter("idx"), 0);
      AppMethodBeat.o(116426);
      return;
    }
    catch (Exception localException)
    {
      this.hGH = 0L;
      AppMethodBeat.o(116426);
    }
  }
  
  public final String zh(String paramString)
  {
    AppMethodBeat.i(116425);
    this.hGB = aj.ej(paramString + "_" + this.videoUrl);
    paramString = this.hGB;
    AppMethodBeat.o(116425);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.y
 * JD-Core Version:    0.7.0.1
 */