package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a$g
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public a$g()
  {
    this.a = 544;
    this.b = 960;
    this.c = 15;
    this.d = 1200;
  }
  
  public a$g(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(211532);
    this.a = 544;
    this.b = 960;
    this.c = 15;
    this.d = 1200;
    paramV2TXLiveVideoResolutionMode = b.a(paramV2TXLiveVideoResolution, paramV2TXLiveVideoResolutionMode);
    this.a = paramV2TXLiveVideoResolutionMode.a;
    this.b = paramV2TXLiveVideoResolutionMode.b;
    this.d = b.b(paramV2TXLiveVideoResolution).b;
    this.c = 15;
    AppMethodBeat.o(211532);
  }
  
  public String toString()
  {
    AppMethodBeat.i(211539);
    String str = "[width:" + this.a + "][height:" + this.b + "][fps:" + this.c + "][bitrate:" + this.d + "]";
    AppMethodBeat.o(211539);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.impl.a.g
 * JD-Core Version:    0.7.0.1
 */