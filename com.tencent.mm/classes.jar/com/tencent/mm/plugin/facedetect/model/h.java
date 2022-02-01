package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;

public final class h
{
  public static h sQT;
  public int rmJ = 0;
  public int[] sQR = null;
  public int sQS = -1;
  
  public static a cTd()
  {
    AppMethodBeat.i(103743);
    int i = f.sQM.cSZ();
    Object localObject = f.sQM.sQN.sSO;
    if (((g)localObject).sQQ == null) {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).sQQ.engineGetCurrMotionData())
    {
      localObject = new a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.sQR) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
  
  public static final class a
  {
    public String ktN;
    public long sQU;
    public long sQV;
    public boolean sQW;
    public long sQX;
    public String sQY;
    public boolean sQZ;
    public boolean sRa;
    public int type;
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(103741);
      this.type = paramInt;
      this.sQY = paramString;
      switch (this.type)
      {
      default: 
        Log.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
        this.type = 100;
        AppMethodBeat.o(103741);
        return;
      case 0: 
        this.sQU = 30L;
        this.sQV = 7000L;
        this.ktN = MMApplicationContext.getContext().getString(2131766326);
        this.sQW = true;
        this.sQX = 2500L;
        this.sQZ = false;
        this.sRa = false;
        AppMethodBeat.o(103741);
        return;
      case 1: 
        this.sQU = 30L;
        this.sQV = 7000L;
        this.ktN = MMApplicationContext.getContext().getString(2131759035);
        this.sQW = false;
        this.sQX = -1L;
        this.sQZ = true;
        this.sRa = true;
        AppMethodBeat.o(103741);
        return;
      case 2: 
        this.sQU = 30L;
        this.sQV = 7000L;
        this.ktN = MMApplicationContext.getContext().getString(2131759036);
        this.sQW = false;
        this.sQX = -1L;
        this.sQZ = true;
        this.sRa = true;
        AppMethodBeat.o(103741);
        return;
      case 3: 
        this.sQU = 30L;
        this.sQV = 7000L;
        this.ktN = MMApplicationContext.getContext().getString(2131759034);
        this.sQW = true;
        this.sQX = -1L;
        this.sQZ = true;
        this.sRa = true;
        AppMethodBeat.o(103741);
        return;
      }
      this.sQU = 30L;
      this.sQV = 7000L;
      this.ktN = MMApplicationContext.getContext().getString(2131759037);
      this.sQW = true;
      this.sQX = 1000L;
      this.sQZ = true;
      this.sRa = true;
      AppMethodBeat.o(103741);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(103742);
      String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.sQU + ", hintTween=" + this.sQV + ", hintStr='" + this.ktN + '\'' + ", isCheckFace=" + this.sQW + ", minSuccTime=" + this.sQX + ", actionData='" + this.sQY + '\'' + '}';
      AppMethodBeat.o(103742);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */