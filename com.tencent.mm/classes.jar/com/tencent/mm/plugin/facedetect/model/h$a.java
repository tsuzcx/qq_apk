package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class h$a
{
  public String gLL;
  public long mig;
  public long mih;
  public boolean mii;
  public long mij;
  public String mik;
  public boolean mil;
  public boolean mim;
  public int type;
  
  public h$a(int paramInt, String paramString)
  {
    AppMethodBeat.i(216);
    this.type = paramInt;
    this.mik = paramString;
    switch (this.type)
    {
    default: 
      ab.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
      this.type = 100;
      AppMethodBeat.o(216);
      return;
    case 0: 
      this.mig = 30L;
      this.mih = 7000L;
      this.gLL = ah.getContext().getString(2131304061);
      this.mii = true;
      this.mij = 2500L;
      this.mil = false;
      this.mim = false;
      AppMethodBeat.o(216);
      return;
    case 1: 
      this.mig = 30L;
      this.mih = 7000L;
      this.gLL = ah.getContext().getString(2131299563);
      this.mii = false;
      this.mij = -1L;
      this.mil = true;
      this.mim = true;
      AppMethodBeat.o(216);
      return;
    case 2: 
      this.mig = 30L;
      this.mih = 7000L;
      this.gLL = ah.getContext().getString(2131299564);
      this.mii = false;
      this.mij = -1L;
      this.mil = true;
      this.mim = true;
      AppMethodBeat.o(216);
      return;
    case 3: 
      this.mig = 30L;
      this.mih = 7000L;
      this.gLL = ah.getContext().getString(2131299562);
      this.mii = true;
      this.mij = -1L;
      this.mil = true;
      this.mim = true;
      AppMethodBeat.o(216);
      return;
    }
    this.mig = 30L;
    this.mih = 7000L;
    this.gLL = ah.getContext().getString(2131299565);
    this.mii = true;
    this.mij = 1000L;
    this.mil = true;
    this.mim = true;
    AppMethodBeat.o(216);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(217);
    String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.mig + ", hintTween=" + this.mih + ", hintStr='" + this.gLL + '\'' + ", isCheckFace=" + this.mii + ", minSuccTime=" + this.mij + ", actionData='" + this.mik + '\'' + '}';
    AppMethodBeat.o(217);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h.a
 * JD-Core Version:    0.7.0.1
 */