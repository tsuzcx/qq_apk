package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class y
  extends jz
{
  public int idx = 0;
  public float nVk = 0.0F;
  private String nVl = null;
  public int nVm;
  public int nVn;
  public int nVo;
  public int nVp;
  public int nVq = 0;
  public long nVr = -1L;
  public String nVs;
  public boolean nVt = false;
  
  public final String Hl(String paramString)
  {
    AppMethodBeat.i(116425);
    this.nVl = MD5Util.getMD5String(paramString + "_" + this.videoUrl);
    paramString = this.nVl;
    AppMethodBeat.o(116425);
    return paramString;
  }
  
  public final y a(jz paramjz)
  {
    if (paramjz == null) {
      return null;
    }
    this.YMm = paramjz.YMm;
    this.videoUrl = paramjz.videoUrl;
    this.YMn = paramjz.YMn;
    this.title = paramjz.title;
    this.nUM = paramjz.nUM;
    this.videoDuration = paramjz.videoDuration;
    this.width = paramjz.width;
    this.height = paramjz.height;
    this.url = paramjz.url;
    this.hEE = paramjz.hEE;
    this.nUF = paramjz.nUF;
    this.mso = paramjz.mso;
    this.iiu = paramjz.iiu;
    this.iit = paramjz.iit;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.y
 * JD-Core Version:    0.7.0.1
 */