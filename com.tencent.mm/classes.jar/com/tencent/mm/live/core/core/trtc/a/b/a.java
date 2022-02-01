package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class a
  implements Serializable
{
  String fIQ;
  private boolean gLK;
  private boolean gLZ;
  private boolean gMh;
  private int gMi;
  private int mRotation;
  int mStreamType;
  
  public a(String paramString)
  {
    AppMethodBeat.i(197090);
    this.fIQ = "";
    this.mStreamType = 0;
    this.gLZ = true;
    this.gLK = true;
    this.gMh = false;
    this.mRotation = 0;
    this.gMi = 50;
    this.fIQ = paramString;
    this.mStreamType = 0;
    AppMethodBeat.o(197090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.a
 * JD-Core Version:    0.7.0.1
 */