package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a$e
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public boolean f;
  public int g;
  public int h;
  
  public a$e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(215121);
    this.a = 15;
    this.b = 1300;
    this.c = 850;
    this.d = 3;
    this.e = 1;
    this.f = true;
    this.g = -1;
    this.h = -1;
    this.a = paramInt2;
    this.b = paramInt5;
    this.c = paramInt4;
    this.d = paramInt3;
    this.e = paramInt1;
    this.f = b.a(paramInt1);
    this.g = paramInt6;
    this.h = paramInt7;
    AppMethodBeat.o(215121);
  }
  
  public a$e(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(215122);
    this.a = 15;
    this.b = 1300;
    this.c = 850;
    this.d = 3;
    this.e = 1;
    this.f = true;
    this.g = -1;
    this.h = -1;
    this.e = b.a(paramV2TXLiveVideoResolution);
    paramV2TXLiveVideoResolution = b.b(paramV2TXLiveVideoResolution);
    this.c = paramV2TXLiveVideoResolution.a;
    this.b = paramV2TXLiveVideoResolution.b;
    this.a = 15;
    this.d = 3;
    if (paramV2TXLiveVideoResolutionMode == V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait)
    {
      this.f = bool;
      if (paramV2TXLiveVideoResolution.a == paramV2TXLiveVideoResolution.b) {
        break label145;
      }
    }
    for (;;)
    {
      this.h = i;
      this.g = -1;
      AppMethodBeat.o(215122);
      return;
      bool = false;
      break;
      label145:
      i = -1;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(215125);
    String str = "[resolution:" + this.e + "][fps:" + this.a + "][gop:" + this.d + "][maxBitrate:" + this.b + "][minBitrate:" + this.c + "][homeOrientation:" + this.g + "][portrait:" + this.f + "]";
    AppMethodBeat.o(215125);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.e
 * JD-Core Version:    0.7.0.1
 */