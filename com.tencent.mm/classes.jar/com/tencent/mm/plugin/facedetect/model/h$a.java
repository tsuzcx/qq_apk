package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class h$a
{
  public String iZx;
  public long qxC;
  public long qxD;
  public boolean qxE;
  public long qxF;
  public String qxG;
  public boolean qxH;
  public boolean qxI;
  public int type;
  
  public h$a(int paramInt, String paramString)
  {
    AppMethodBeat.i(103741);
    this.type = paramInt;
    this.qxG = paramString;
    switch (this.type)
    {
    default: 
      ac.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
      this.type = 100;
      AppMethodBeat.o(103741);
      return;
    case 0: 
      this.qxC = 30L;
      this.qxD = 7000L;
      this.iZx = ai.getContext().getString(2131764084);
      this.qxE = true;
      this.qxF = 2500L;
      this.qxH = false;
      this.qxI = false;
      AppMethodBeat.o(103741);
      return;
    case 1: 
      this.qxC = 30L;
      this.qxD = 7000L;
      this.iZx = ai.getContext().getString(2131758720);
      this.qxE = false;
      this.qxF = -1L;
      this.qxH = true;
      this.qxI = true;
      AppMethodBeat.o(103741);
      return;
    case 2: 
      this.qxC = 30L;
      this.qxD = 7000L;
      this.iZx = ai.getContext().getString(2131758721);
      this.qxE = false;
      this.qxF = -1L;
      this.qxH = true;
      this.qxI = true;
      AppMethodBeat.o(103741);
      return;
    case 3: 
      this.qxC = 30L;
      this.qxD = 7000L;
      this.iZx = ai.getContext().getString(2131758719);
      this.qxE = true;
      this.qxF = -1L;
      this.qxH = true;
      this.qxI = true;
      AppMethodBeat.o(103741);
      return;
    }
    this.qxC = 30L;
    this.qxD = 7000L;
    this.iZx = ai.getContext().getString(2131758722);
    this.qxE = true;
    this.qxF = 1000L;
    this.qxH = true;
    this.qxI = true;
    AppMethodBeat.o(103741);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103742);
    String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.qxC + ", hintTween=" + this.qxD + ", hintStr='" + this.iZx + '\'' + ", isCheckFace=" + this.qxE + ", minSuccTime=" + this.qxF + ", actionData='" + this.qxG + '\'' + '}';
    AppMethodBeat.o(103742);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h.a
 * JD-Core Version:    0.7.0.1
 */