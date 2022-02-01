package com.tencent.mm.ai;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;

public final class y
  extends jb
{
  public float hDI = 0.0F;
  private String hDJ = null;
  public int hDK;
  public int hDL;
  public int hDM;
  public int hDN;
  public int hDO = 0;
  public long hDP = -1L;
  public String hDQ;
  public boolean hDR = false;
  public int idx = 0;
  
  public final y a(jb paramjb)
  {
    if (paramjb == null) {
      return null;
    }
    this.FCb = paramjb.FCb;
    this.videoUrl = paramjb.videoUrl;
    this.FCc = paramjb.FCc;
    this.title = paramjb.title;
    this.hDm = paramjb.hDm;
    this.videoDuration = paramjb.videoDuration;
    this.width = paramjb.width;
    this.height = paramjb.height;
    this.url = paramjb.url;
    this.doK = paramjb.doK;
    this.hDe = paramjb.hDe;
    this.hDf = paramjb.hDf;
    this.dOy = paramjb.dOy;
    this.dOx = paramjb.dOx;
    return this;
  }
  
  public final void azf()
  {
    AppMethodBeat.i(116426);
    if (this.hDP != -1L)
    {
      AppMethodBeat.o(116426);
      return;
    }
    try
    {
      Uri localUri = Uri.parse(this.FCb);
      this.hDP = bt.getLong(localUri.getQueryParameter("mid"), 0L);
      this.idx = bt.getInt(localUri.getQueryParameter("idx"), 0);
      AppMethodBeat.o(116426);
      return;
    }
    catch (Exception localException)
    {
      this.hDP = 0L;
      AppMethodBeat.o(116426);
    }
  }
  
  public final String yx(String paramString)
  {
    AppMethodBeat.i(116425);
    this.hDJ = ai.ee(paramString + "_" + this.videoUrl);
    paramString = this.hDJ;
    AppMethodBeat.o(116425);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.y
 * JD-Core Version:    0.7.0.1
 */