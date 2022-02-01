package com.tencent.mm.aj;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
  extends jd
{
  public int idx = 0;
  public float lqh = 0.0F;
  private String lqi = null;
  public int lqj;
  public int lqk;
  public int lql;
  public int lqm;
  public int lqn = 0;
  public long lqo = -1L;
  public String lqp;
  public boolean lqq = false;
  
  public final String OW(String paramString)
  {
    AppMethodBeat.i(116425);
    this.lqi = MD5Util.getMD5String(paramString + "_" + this.videoUrl);
    paramString = this.lqi;
    AppMethodBeat.o(116425);
    return paramString;
  }
  
  public final y a(jd paramjd)
  {
    if (paramjd == null) {
      return null;
    }
    this.ROZ = paramjd.ROZ;
    this.videoUrl = paramjd.videoUrl;
    this.RPa = paramjd.RPa;
    this.title = paramjd.title;
    this.lpK = paramjd.lpK;
    this.videoDuration = paramjd.videoDuration;
    this.width = paramjd.width;
    this.height = paramjd.height;
    this.url = paramjd.url;
    this.fzT = paramjd.fzT;
    this.lpC = paramjd.lpC;
    this.lpD = paramjd.lpD;
    this.gci = paramjd.gci;
    this.gch = paramjd.gch;
    return this;
  }
  
  public final void bbz()
  {
    AppMethodBeat.i(116426);
    if (this.lqo != -1L)
    {
      AppMethodBeat.o(116426);
      return;
    }
    try
    {
      Uri localUri = Uri.parse(this.ROZ);
      this.lqo = Util.getLong(localUri.getQueryParameter("mid"), 0L);
      this.idx = Util.getInt(localUri.getQueryParameter("idx"), 0);
      AppMethodBeat.o(116426);
      return;
    }
    catch (Exception localException)
    {
      this.lqo = 0L;
      AppMethodBeat.o(116426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.y
 * JD-Core Version:    0.7.0.1
 */