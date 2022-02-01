package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class a
  implements Serializable
{
  String iSn;
  private boolean koV;
  private boolean kpE;
  int kpF;
  private boolean kpr;
  private int mRotation;
  int mStreamType;
  
  public a(String paramString)
  {
    AppMethodBeat.i(199513);
    this.iSn = "";
    this.mStreamType = 0;
    this.kpr = true;
    this.koV = true;
    this.kpE = false;
    this.mRotation = 0;
    this.kpF = 50;
    this.iSn = paramString;
    this.mStreamType = 0;
    AppMethodBeat.o(199513);
  }
  
  public final void setVolume(int paramInt)
  {
    this.kpF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.a
 * JD-Core Version:    0.7.0.1
 */