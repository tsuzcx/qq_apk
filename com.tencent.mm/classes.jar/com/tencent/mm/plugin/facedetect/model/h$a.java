package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class h$a
{
  public String jvz;
  public String rpA;
  public boolean rpB;
  public boolean rpC;
  public long rpw;
  public long rpx;
  public boolean rpy;
  public long rpz;
  public int type;
  
  public h$a(int paramInt, String paramString)
  {
    AppMethodBeat.i(103741);
    this.type = paramInt;
    this.rpA = paramString;
    switch (this.type)
    {
    default: 
      ae.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
      this.type = 100;
      AppMethodBeat.o(103741);
      return;
    case 0: 
      this.rpw = 30L;
      this.rpx = 7000L;
      this.jvz = ak.getContext().getString(2131764084);
      this.rpy = true;
      this.rpz = 2500L;
      this.rpB = false;
      this.rpC = false;
      AppMethodBeat.o(103741);
      return;
    case 1: 
      this.rpw = 30L;
      this.rpx = 7000L;
      this.jvz = ak.getContext().getString(2131758720);
      this.rpy = false;
      this.rpz = -1L;
      this.rpB = true;
      this.rpC = true;
      AppMethodBeat.o(103741);
      return;
    case 2: 
      this.rpw = 30L;
      this.rpx = 7000L;
      this.jvz = ak.getContext().getString(2131758721);
      this.rpy = false;
      this.rpz = -1L;
      this.rpB = true;
      this.rpC = true;
      AppMethodBeat.o(103741);
      return;
    case 3: 
      this.rpw = 30L;
      this.rpx = 7000L;
      this.jvz = ak.getContext().getString(2131758719);
      this.rpy = true;
      this.rpz = -1L;
      this.rpB = true;
      this.rpC = true;
      AppMethodBeat.o(103741);
      return;
    }
    this.rpw = 30L;
    this.rpx = 7000L;
    this.jvz = ak.getContext().getString(2131758722);
    this.rpy = true;
    this.rpz = 1000L;
    this.rpB = true;
    this.rpC = true;
    AppMethodBeat.o(103741);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103742);
    String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.rpw + ", hintTween=" + this.rpx + ", hintStr='" + this.jvz + '\'' + ", isCheckFace=" + this.rpy + ", minSuccTime=" + this.rpz + ", actionData='" + this.rpA + '\'' + '}';
    AppMethodBeat.o(103742);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h.a
 * JD-Core Version:    0.7.0.1
 */