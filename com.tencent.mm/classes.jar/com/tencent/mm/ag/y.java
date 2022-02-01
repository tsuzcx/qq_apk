package com.tencent.mm.ag;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends jo
{
  public float iAJ = 0.0F;
  private String iAK = null;
  public int iAL;
  public int iAM;
  public int iAN;
  public int iAO;
  public int iAP = 0;
  public long iAQ = -1L;
  public String iAR;
  public boolean iAS = false;
  public int idx = 0;
  
  public final String HJ(String paramString)
  {
    AppMethodBeat.i(116425);
    this.iAK = MD5Util.getMD5String(paramString + "_" + this.videoUrl);
    paramString = this.iAK;
    AppMethodBeat.o(116425);
    return paramString;
  }
  
  public final y a(jo paramjo)
  {
    if (paramjo == null) {
      return null;
    }
    this.KOe = paramjo.KOe;
    this.videoUrl = paramjo.videoUrl;
    this.KOf = paramjo.KOf;
    this.title = paramjo.title;
    this.iAo = paramjo.iAo;
    this.videoDuration = paramjo.videoDuration;
    this.width = paramjo.width;
    this.height = paramjo.height;
    this.url = paramjo.url;
    this.dHc = paramjo.dHc;
    this.iAg = paramjo.iAg;
    this.iAh = paramjo.iAh;
    this.ehR = paramjo.ehR;
    this.ehQ = paramjo.ehQ;
    return this;
  }
  
  public final void aSB()
  {
    AppMethodBeat.i(116426);
    if (this.iAQ != -1L)
    {
      AppMethodBeat.o(116426);
      return;
    }
    try
    {
      Uri localUri = Uri.parse(this.KOe);
      this.iAQ = Util.getLong(localUri.getQueryParameter("mid"), 0L);
      this.idx = Util.getInt(localUri.getQueryParameter("idx"), 0);
      AppMethodBeat.o(116426);
      return;
    }
    catch (Exception localException)
    {
      this.iAQ = 0L;
      AppMethodBeat.o(116426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.y
 * JD-Core Version:    0.7.0.1
 */