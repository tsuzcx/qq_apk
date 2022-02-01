package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Arrays;

public final class h
{
  public static h rhr;
  public int pPf = 0;
  public int[] rhp = null;
  public int rhq = -1;
  
  public static a ctg()
  {
    AppMethodBeat.i(103743);
    int i = f.rhk.ctb();
    Object localObject = f.rhk.rhl.rjn;
    if (((g)localObject).rho == null) {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).rho.engineGetCurrMotionData())
    {
      localObject = new a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.rhp) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
  
  public static final class a
  {
    public String jsG;
    public long rhs;
    public long rht;
    public boolean rhu;
    public long rhv;
    public String rhw;
    public boolean rhx;
    public boolean rhy;
    public int type;
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(103741);
      this.type = paramInt;
      this.rhw = paramString;
      switch (this.type)
      {
      default: 
        ad.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
        this.type = 100;
        AppMethodBeat.o(103741);
        return;
      case 0: 
        this.rhs = 30L;
        this.rht = 7000L;
        this.jsG = aj.getContext().getString(2131764084);
        this.rhu = true;
        this.rhv = 2500L;
        this.rhx = false;
        this.rhy = false;
        AppMethodBeat.o(103741);
        return;
      case 1: 
        this.rhs = 30L;
        this.rht = 7000L;
        this.jsG = aj.getContext().getString(2131758720);
        this.rhu = false;
        this.rhv = -1L;
        this.rhx = true;
        this.rhy = true;
        AppMethodBeat.o(103741);
        return;
      case 2: 
        this.rhs = 30L;
        this.rht = 7000L;
        this.jsG = aj.getContext().getString(2131758721);
        this.rhu = false;
        this.rhv = -1L;
        this.rhx = true;
        this.rhy = true;
        AppMethodBeat.o(103741);
        return;
      case 3: 
        this.rhs = 30L;
        this.rht = 7000L;
        this.jsG = aj.getContext().getString(2131758719);
        this.rhu = true;
        this.rhv = -1L;
        this.rhx = true;
        this.rhy = true;
        AppMethodBeat.o(103741);
        return;
      }
      this.rhs = 30L;
      this.rht = 7000L;
      this.jsG = aj.getContext().getString(2131758722);
      this.rhu = true;
      this.rhv = 1000L;
      this.rhx = true;
      this.rhy = true;
      AppMethodBeat.o(103741);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(103742);
      String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.rhs + ", hintTween=" + this.rht + ", hintStr='" + this.jsG + '\'' + ", isCheckFace=" + this.rhu + ", minSuccTime=" + this.rhv + ", actionData='" + this.rhw + '\'' + '}';
      AppMethodBeat.o(103742);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */