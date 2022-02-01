package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class h$a
{
  public String izu;
  public long pOU;
  public long pOV;
  public boolean pOW;
  public long pOX;
  public String pOY;
  public boolean pOZ;
  public boolean pPa;
  public int type;
  
  public h$a(int paramInt, String paramString)
  {
    AppMethodBeat.i(103741);
    this.type = paramInt;
    this.pOY = paramString;
    switch (this.type)
    {
    default: 
      ad.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
      this.type = 100;
      AppMethodBeat.o(103741);
      return;
    case 0: 
      this.pOU = 30L;
      this.pOV = 7000L;
      this.izu = aj.getContext().getString(2131764084);
      this.pOW = true;
      this.pOX = 2500L;
      this.pOZ = false;
      this.pPa = false;
      AppMethodBeat.o(103741);
      return;
    case 1: 
      this.pOU = 30L;
      this.pOV = 7000L;
      this.izu = aj.getContext().getString(2131758720);
      this.pOW = false;
      this.pOX = -1L;
      this.pOZ = true;
      this.pPa = true;
      AppMethodBeat.o(103741);
      return;
    case 2: 
      this.pOU = 30L;
      this.pOV = 7000L;
      this.izu = aj.getContext().getString(2131758721);
      this.pOW = false;
      this.pOX = -1L;
      this.pOZ = true;
      this.pPa = true;
      AppMethodBeat.o(103741);
      return;
    case 3: 
      this.pOU = 30L;
      this.pOV = 7000L;
      this.izu = aj.getContext().getString(2131758719);
      this.pOW = true;
      this.pOX = -1L;
      this.pOZ = true;
      this.pPa = true;
      AppMethodBeat.o(103741);
      return;
    }
    this.pOU = 30L;
    this.pOV = 7000L;
    this.izu = aj.getContext().getString(2131758722);
    this.pOW = true;
    this.pOX = 1000L;
    this.pOZ = true;
    this.pPa = true;
    AppMethodBeat.o(103741);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103742);
    String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.pOU + ", hintTween=" + this.pOV + ", hintStr='" + this.izu + '\'' + ", isCheckFace=" + this.pOW + ", minSuccTime=" + this.pOX + ", actionData='" + this.pOY + '\'' + '}';
    AppMethodBeat.o(103742);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h.a
 * JD-Core Version:    0.7.0.1
 */