package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;

public class h
{
  private static h zSV;
  public int xYG = 0;
  public int[] zST = null;
  public int zSU = -1;
  
  public static h dOS()
  {
    AppMethodBeat.i(271885);
    if (zSV == null) {
      zSV = new h();
    }
    h localh = zSV;
    AppMethodBeat.o(271885);
    return localh;
  }
  
  public static a dOT()
  {
    AppMethodBeat.i(103743);
    int i = f.zSO.dOO();
    Object localObject = f.zSO.zSP.zUR;
    if (((g)localObject).zSS == null) {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).zSS.engineGetCurrMotionData())
    {
      localObject = new a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.zST) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
  
  public static final class a
  {
    public String qiK;
    public int type;
    public long zSW;
    public long zSX;
    public boolean zSY;
    public long zSZ;
    public String zTa;
    public boolean zTb;
    public boolean zTc;
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(103741);
      this.type = paramInt;
      this.zTa = paramString;
      switch (this.type)
      {
      default: 
        Log.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
        this.type = 100;
        AppMethodBeat.o(103741);
        return;
      case 0: 
        this.zSW = 30L;
        this.zSX = 7000L;
        this.qiK = MMApplicationContext.getContext().getString(a.i.soter_face_err_msg_ok);
        this.zSY = true;
        this.zSZ = 2500L;
        this.zTb = false;
        this.zTc = false;
        AppMethodBeat.o(103741);
        return;
      case 1: 
        this.zSW = 30L;
        this.zSX = 7000L;
        this.qiK = MMApplicationContext.getContext().getString(a.i.face_detect_hint_pose_left);
        this.zSY = false;
        this.zSZ = -1L;
        this.zTb = true;
        this.zTc = true;
        AppMethodBeat.o(103741);
        return;
      case 2: 
        this.zSW = 30L;
        this.zSX = 7000L;
        this.qiK = MMApplicationContext.getContext().getString(a.i.face_detect_hint_pose_right);
        this.zSY = false;
        this.zSZ = -1L;
        this.zTb = true;
        this.zTc = true;
        AppMethodBeat.o(103741);
        return;
      case 3: 
        this.zSW = 30L;
        this.zSX = 7000L;
        this.qiK = MMApplicationContext.getContext().getString(a.i.face_detect_hint_eye);
        this.zSY = true;
        this.zSZ = -1L;
        this.zTb = true;
        this.zTc = true;
        AppMethodBeat.o(103741);
        return;
      }
      this.zSW = 30L;
      this.zSX = 7000L;
      this.qiK = MMApplicationContext.getContext().getString(a.i.face_detect_hint_read_number);
      this.zSY = true;
      this.zSZ = 1000L;
      this.zTb = true;
      this.zTc = true;
      AppMethodBeat.o(103741);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(103742);
      String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.zSW + ", hintTween=" + this.zSX + ", hintStr='" + this.qiK + '\'' + ", isCheckFace=" + this.zSY + ", minSuccTime=" + this.zSZ + ", actionData='" + this.zTa + '\'' + '}';
      AppMethodBeat.o(103742);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */