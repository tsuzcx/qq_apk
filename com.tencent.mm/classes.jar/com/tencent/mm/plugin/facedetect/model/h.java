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
  private static h wwP;
  public int uPV = 0;
  public int[] wwN = null;
  public int wwO = -1;
  
  public static h dih()
  {
    AppMethodBeat.i(193762);
    if (wwP == null) {
      wwP = new h();
    }
    h localh = wwP;
    AppMethodBeat.o(193762);
    return localh;
  }
  
  public static a dii()
  {
    AppMethodBeat.i(103743);
    int i = f.wwI.did();
    Object localObject = f.wwI.wwJ.wyK;
    if (((g)localObject).wwM == null) {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
    }
    for (localObject = null;; localObject = ((g)localObject).wwM.engineGetCurrMotionData())
    {
      localObject = new a(i, (String)localObject);
      AppMethodBeat.o(103743);
      return localObject;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(103744);
    String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.wwN) + '}';
    AppMethodBeat.o(103744);
    return str;
  }
  
  public static final class a
  {
    public String nlB;
    public int type;
    public long wwQ;
    public long wwR;
    public boolean wwS;
    public long wwT;
    public String wwU;
    public boolean wwV;
    public boolean wwW;
    
    public a(int paramInt, String paramString)
    {
      AppMethodBeat.i(103741);
      this.type = paramInt;
      this.wwU = paramString;
      switch (this.type)
      {
      default: 
        Log.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
        this.type = 100;
        AppMethodBeat.o(103741);
        return;
      case 0: 
        this.wwQ = 30L;
        this.wwR = 7000L;
        this.nlB = MMApplicationContext.getContext().getString(a.i.soter_face_err_msg_ok);
        this.wwS = true;
        this.wwT = 2500L;
        this.wwV = false;
        this.wwW = false;
        AppMethodBeat.o(103741);
        return;
      case 1: 
        this.wwQ = 30L;
        this.wwR = 7000L;
        this.nlB = MMApplicationContext.getContext().getString(a.i.face_detect_hint_pose_left);
        this.wwS = false;
        this.wwT = -1L;
        this.wwV = true;
        this.wwW = true;
        AppMethodBeat.o(103741);
        return;
      case 2: 
        this.wwQ = 30L;
        this.wwR = 7000L;
        this.nlB = MMApplicationContext.getContext().getString(a.i.face_detect_hint_pose_right);
        this.wwS = false;
        this.wwT = -1L;
        this.wwV = true;
        this.wwW = true;
        AppMethodBeat.o(103741);
        return;
      case 3: 
        this.wwQ = 30L;
        this.wwR = 7000L;
        this.nlB = MMApplicationContext.getContext().getString(a.i.face_detect_hint_eye);
        this.wwS = true;
        this.wwT = -1L;
        this.wwV = true;
        this.wwW = true;
        AppMethodBeat.o(103741);
        return;
      }
      this.wwQ = 30L;
      this.wwR = 7000L;
      this.nlB = MMApplicationContext.getContext().getString(a.i.face_detect_hint_read_number);
      this.wwS = true;
      this.wwT = 1000L;
      this.wwV = true;
      this.wwW = true;
      AppMethodBeat.o(103741);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(103742);
      String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.wwQ + ", hintTween=" + this.wwR + ", hintStr='" + this.nlB + '\'' + ", isCheckFace=" + this.wwS + ", minSuccTime=" + this.wwT + ", actionData='" + this.wwU + '\'' + '}';
      AppMethodBeat.o(103742);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.h
 * JD-Core Version:    0.7.0.1
 */