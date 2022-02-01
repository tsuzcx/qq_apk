package com.tencent.mm.ai;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;

public final class y
  extends io
{
  public float gKY = 0.0F;
  private String gKZ = null;
  public int gLa;
  public int gLb;
  public int gLc;
  public int gLd;
  public int gLe = 0;
  public long gLf = -1L;
  public String gLg;
  public boolean gLh = false;
  public int idx = 0;
  
  public final y a(io paramio)
  {
    if (paramio == null) {
      return null;
    }
    this.CEf = paramio.CEf;
    this.videoUrl = paramio.videoUrl;
    this.CEg = paramio.CEg;
    this.title = paramio.title;
    this.gKD = paramio.gKD;
    this.videoDuration = paramio.videoDuration;
    this.width = paramio.width;
    this.height = paramio.height;
    this.url = paramio.url;
    this.dfT = paramio.dfT;
    this.gKv = paramio.gKv;
    this.gKw = paramio.gKw;
    this.dEz = paramio.dEz;
    this.dEy = paramio.dEy;
    return this;
  }
  
  public final void apD()
  {
    AppMethodBeat.i(116426);
    if (this.gLf != -1L)
    {
      AppMethodBeat.o(116426);
      return;
    }
    try
    {
      Uri localUri = Uri.parse(this.CEf);
      this.gLf = bt.getLong(localUri.getQueryParameter("mid"), 0L);
      this.idx = bt.getInt(localUri.getQueryParameter("idx"), 0);
      AppMethodBeat.o(116426);
      return;
    }
    catch (Exception localException)
    {
      this.gLf = 0L;
      AppMethodBeat.o(116426);
    }
  }
  
  public final String rD(String paramString)
  {
    AppMethodBeat.i(116425);
    this.gKZ = ai.du(paramString + "_" + this.videoUrl);
    paramString = this.gKZ;
    AppMethodBeat.o(116425);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.y
 * JD-Core Version:    0.7.0.1
 */