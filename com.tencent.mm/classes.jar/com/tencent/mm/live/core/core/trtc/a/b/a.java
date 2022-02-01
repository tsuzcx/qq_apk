package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class a
  implements Serializable
{
  String fGM;
  private boolean gJb;
  private boolean gJq;
  private boolean gJy;
  private int gJz;
  private int mRotation;
  int mStreamType;
  
  public a(String paramString)
  {
    AppMethodBeat.i(216691);
    this.fGM = "";
    this.mStreamType = 0;
    this.gJq = true;
    this.gJb = true;
    this.gJy = false;
    this.mRotation = 0;
    this.gJz = 50;
    this.fGM = paramString;
    this.mStreamType = 0;
    AppMethodBeat.o(216691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.a
 * JD-Core Version:    0.7.0.1
 */