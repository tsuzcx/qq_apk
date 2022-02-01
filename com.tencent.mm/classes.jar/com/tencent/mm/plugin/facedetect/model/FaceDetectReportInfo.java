package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR;
  protected int frE;
  protected long sessionId;
  protected int unstableCount;
  protected int wvr;
  protected int wwX;
  protected int wwY;
  protected int wwZ;
  protected int wxa;
  protected int wxb;
  protected int wxc;
  protected int wxd;
  protected int wxe;
  protected int wxf;
  protected int wxg;
  protected int wxh;
  protected int wxi;
  protected int wxj;
  protected int wxk;
  protected int wxl;
  protected int wxm;
  protected HashMap<Integer, Long> wxn;
  protected HashMap<Integer, Long> wxo;
  
  static
  {
    AppMethodBeat.i(103751);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(103751);
  }
  
  public FaceDetectReportInfo()
  {
    AppMethodBeat.i(103746);
    this.sessionId = 0L;
    this.wwX = 0;
    this.wwY = 0;
    this.wwZ = 0;
    this.wxa = 0;
    this.wxb = 0;
    this.wxc = 0;
    this.wxd = 0;
    this.wxe = 0;
    this.wxf = 0;
    this.wxg = 0;
    this.wxh = 0;
    this.wxi = 0;
    this.wxj = 0;
    this.wxk = 0;
    this.unstableCount = 0;
    this.frE = 0;
    this.wvr = 0;
    this.wxl = 0;
    this.wxm = 0;
    this.wxn = new HashMap();
    this.wxo = new HashMap();
    AppMethodBeat.o(103746);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(103747);
    this.sessionId = 0L;
    this.wwX = 0;
    this.wwY = 0;
    this.wwZ = 0;
    this.wxa = 0;
    this.wxb = 0;
    this.wxc = 0;
    this.wxd = 0;
    this.wxe = 0;
    this.wxf = 0;
    this.wxg = 0;
    this.wxh = 0;
    this.wxi = 0;
    this.wxj = 0;
    this.wxk = 0;
    this.unstableCount = 0;
    this.frE = 0;
    this.wvr = 0;
    this.wxl = 0;
    this.wxm = 0;
    this.wxn = new HashMap();
    this.wxo = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.wwX = paramParcel.readInt();
    this.wwY = paramParcel.readInt();
    this.wwZ = paramParcel.readInt();
    this.wxa = paramParcel.readInt();
    this.wxb = paramParcel.readInt();
    this.wxc = paramParcel.readInt();
    this.wxd = paramParcel.readInt();
    this.wxe = paramParcel.readInt();
    this.wxf = paramParcel.readInt();
    this.wxg = paramParcel.readInt();
    this.wxh = paramParcel.readInt();
    this.wxi = paramParcel.readInt();
    this.wxj = paramParcel.readInt();
    this.wxk = paramParcel.readInt();
    this.unstableCount = paramParcel.readInt();
    this.frE = paramParcel.readInt();
    this.wvr = paramParcel.readInt();
    this.wxl = paramParcel.readInt();
    this.wxm = paramParcel.readInt();
    try
    {
      this.wxn = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.wxo = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(103747);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(103747);
    }
  }
  
  public final void Lt(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.wwY += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.wwZ += 1;
        return;
      }
      this.wwY += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.wxa += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.wxc += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.wxd += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.wxe += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.wxi += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.wxf += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.wxg += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.wxh += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.wxb += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.wxj += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.wxk += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.unstableCount += 1;
      return;
    }
    this.wwX += 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(103749);
    this.sessionId = 0L;
    this.wwY = 0;
    this.wwZ = 0;
    this.wxa = 0;
    this.wwX = 0;
    this.wxb = 0;
    this.wxc = 0;
    this.wxd = 0;
    this.wxe = 0;
    this.wxf = 0;
    this.wxg = 0;
    this.wxh = 0;
    this.wxi = 0;
    this.wxj = 0;
    this.frE = 0;
    this.wvr = 0;
    this.wxl = 0;
    this.wxm = 0;
    this.wxn.clear();
    this.wxo.clear();
    AppMethodBeat.o(103749);
  }
  
  public String toString()
  {
    AppMethodBeat.i(103750);
    String str = "detectOk: " + this.wwY + ", motionOk: " + this.wwZ + ", noFace: " + this.wxa + ", systemErr: " + this.wwX + ", noLiveFace: " + this.wxb + ", tooDark: " + this.wxc + ", tooLight: " + this.wxd + ", backLight: " + this.wxe + ", tooSmall: " + this.wxf + ", tooBig: " + this.wxg + ", tooActive: " + this.wxh + ", poseNotValid: " + this.wxi + ", timeOut: " + this.wxj + ", totalFrame: " + this.frE + ", verifyTime: " + this.wvr + ", processTimePerFrame: " + this.wxm;
    AppMethodBeat.o(103750);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103748);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.wwX);
    paramParcel.writeInt(this.wwY);
    paramParcel.writeInt(this.wwZ);
    paramParcel.writeInt(this.wxa);
    paramParcel.writeInt(this.wxb);
    paramParcel.writeInt(this.wxc);
    paramParcel.writeInt(this.wxd);
    paramParcel.writeInt(this.wxe);
    paramParcel.writeInt(this.wxf);
    paramParcel.writeInt(this.wxg);
    paramParcel.writeInt(this.wxh);
    paramParcel.writeInt(this.wxi);
    paramParcel.writeInt(this.wxj);
    paramParcel.writeInt(this.wxk);
    paramParcel.writeInt(this.unstableCount);
    paramParcel.writeInt(this.frE);
    paramParcel.writeInt(this.wvr);
    paramParcel.writeInt(this.wxl);
    paramParcel.writeInt(this.wxm);
    paramParcel.writeMap(this.wxn);
    paramParcel.writeMap(this.wxo);
    AppMethodBeat.o(103748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */