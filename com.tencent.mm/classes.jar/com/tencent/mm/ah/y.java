package com.tencent.mm.ah;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;

public final class y
  extends iu
{
  public int hlA;
  public int hlB;
  public int hlC;
  public int hlD;
  public int hlE = 0;
  public long hlF = -1L;
  public String hlG;
  public boolean hlH = false;
  public float hly = 0.0F;
  private String hlz = null;
  public int idx = 0;
  
  public final y a(iu paramiu)
  {
    if (paramiu == null) {
      return null;
    }
    this.DWF = paramiu.DWF;
    this.videoUrl = paramiu.videoUrl;
    this.DWG = paramiu.DWG;
    this.title = paramiu.title;
    this.hld = paramiu.hld;
    this.videoDuration = paramiu.videoDuration;
    this.width = paramiu.width;
    this.height = paramiu.height;
    this.url = paramiu.url;
    this.ddo = paramiu.ddo;
    this.hkV = paramiu.hkV;
    this.hkW = paramiu.hkW;
    this.dCl = paramiu.dCl;
    this.dCk = paramiu.dCk;
    return this;
  }
  
  public final void aws()
  {
    AppMethodBeat.i(116426);
    if (this.hlF != -1L)
    {
      AppMethodBeat.o(116426);
      return;
    }
    try
    {
      Uri localUri = Uri.parse(this.DWF);
      this.hlF = bs.getLong(localUri.getQueryParameter("mid"), 0L);
      this.idx = bs.getInt(localUri.getQueryParameter("idx"), 0);
      AppMethodBeat.o(116426);
      return;
    }
    catch (Exception localException)
    {
      this.hlF = 0L;
      AppMethodBeat.o(116426);
    }
  }
  
  public final String vG(String paramString)
  {
    AppMethodBeat.i(116425);
    this.hlz = ah.dg(paramString + "_" + this.videoUrl);
    paramString = this.hlz;
    AppMethodBeat.o(116425);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.y
 * JD-Core Version:    0.7.0.1
 */