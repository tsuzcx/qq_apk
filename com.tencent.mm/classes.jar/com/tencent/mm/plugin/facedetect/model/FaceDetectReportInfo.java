package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

class FaceDetectReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceDetectReportInfo> CREATOR;
  protected int ciX;
  protected int mgC;
  protected int miA;
  protected int miB;
  protected int miC;
  protected int miD;
  protected int miE;
  protected HashMap<Integer, Long> miF;
  protected HashMap<Integer, Long> miG;
  protected int mio;
  protected int mip;
  protected int miq;
  protected int mir;
  protected int mis;
  protected int mit;
  protected int miu;
  protected int miv;
  protected int miw;
  protected int mix;
  protected int miy;
  protected int miz;
  protected long sessionId;
  
  static
  {
    AppMethodBeat.i(226);
    CREATOR = new FaceDetectReportInfo.1();
    AppMethodBeat.o(226);
  }
  
  public FaceDetectReportInfo()
  {
    AppMethodBeat.i(221);
    this.sessionId = 0L;
    this.mio = 0;
    this.mip = 0;
    this.miq = 0;
    this.mir = 0;
    this.mis = 0;
    this.mit = 0;
    this.miu = 0;
    this.miv = 0;
    this.miw = 0;
    this.mix = 0;
    this.miy = 0;
    this.miz = 0;
    this.miA = 0;
    this.miB = 0;
    this.miC = 0;
    this.ciX = 0;
    this.mgC = 0;
    this.miD = 0;
    this.miE = 0;
    this.miF = new HashMap();
    this.miG = new HashMap();
    AppMethodBeat.o(221);
  }
  
  protected FaceDetectReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(222);
    this.sessionId = 0L;
    this.mio = 0;
    this.mip = 0;
    this.miq = 0;
    this.mir = 0;
    this.mis = 0;
    this.mit = 0;
    this.miu = 0;
    this.miv = 0;
    this.miw = 0;
    this.mix = 0;
    this.miy = 0;
    this.miz = 0;
    this.miA = 0;
    this.miB = 0;
    this.miC = 0;
    this.ciX = 0;
    this.mgC = 0;
    this.miD = 0;
    this.miE = 0;
    this.miF = new HashMap();
    this.miG = new HashMap();
    this.sessionId = paramParcel.readLong();
    this.mio = paramParcel.readInt();
    this.mip = paramParcel.readInt();
    this.miq = paramParcel.readInt();
    this.mir = paramParcel.readInt();
    this.mis = paramParcel.readInt();
    this.mit = paramParcel.readInt();
    this.miu = paramParcel.readInt();
    this.miv = paramParcel.readInt();
    this.miw = paramParcel.readInt();
    this.mix = paramParcel.readInt();
    this.miy = paramParcel.readInt();
    this.miz = paramParcel.readInt();
    this.miA = paramParcel.readInt();
    this.miB = paramParcel.readInt();
    this.miC = paramParcel.readInt();
    this.ciX = paramParcel.readInt();
    this.mgC = paramParcel.readInt();
    this.miD = paramParcel.readInt();
    this.miE = paramParcel.readInt();
    try
    {
      this.miF = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.miG = paramParcel.readHashMap(HashMap.class.getClassLoader());
      AppMethodBeat.o(222);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectReportInfo", paramParcel, "", new Object[0]);
      AppMethodBeat.o(222);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(224);
    this.sessionId = 0L;
    this.mip = 0;
    this.miq = 0;
    this.mir = 0;
    this.mio = 0;
    this.mis = 0;
    this.mit = 0;
    this.miu = 0;
    this.miv = 0;
    this.miw = 0;
    this.mix = 0;
    this.miy = 0;
    this.miz = 0;
    this.miA = 0;
    this.ciX = 0;
    this.mgC = 0;
    this.miD = 0;
    this.miE = 0;
    this.miF.clear();
    this.miG.clear();
    AppMethodBeat.o(224);
  }
  
  public String toString()
  {
    AppMethodBeat.i(225);
    String str = "detectOk: " + this.mip + ", motionOk: " + this.miq + ", noFace: " + this.mir + ", systemErr: " + this.mio + ", noLiveFace: " + this.mis + ", tooDark: " + this.mit + ", tooLight: " + this.miu + ", backLight: " + this.miv + ", tooSmall: " + this.miw + ", tooBig: " + this.mix + ", tooActive: " + this.miy + ", poseNotValid: " + this.miz + ", timeOut: " + this.miA + ", totalFrame: " + this.ciX + ", verifyTime: " + this.mgC + ", processTimePerFrame: " + this.miE;
    AppMethodBeat.o(225);
    return str;
  }
  
  public final void vF(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 1)
      {
        this.mip += 1;
        return;
      }
      if (paramInt == 2)
      {
        this.miq += 1;
        return;
      }
      this.mip += 1;
      return;
    }
    if (paramInt == 0)
    {
      this.mir += 1;
      return;
    }
    if (paramInt == -11)
    {
      this.mit += 1;
      return;
    }
    if (paramInt == -12)
    {
      this.miu += 1;
      return;
    }
    if (paramInt == -13)
    {
      this.miv += 1;
      return;
    }
    if (paramInt == -101)
    {
      this.miz += 1;
      return;
    }
    if (paramInt == -102)
    {
      this.miw += 1;
      return;
    }
    if (paramInt == -103)
    {
      this.mix += 1;
      return;
    }
    if (paramInt == -105)
    {
      this.miy += 1;
      return;
    }
    if (paramInt == -106)
    {
      this.mis += 1;
      return;
    }
    if (paramInt == -107)
    {
      this.miA += 1;
      return;
    }
    if (paramInt == -108)
    {
      this.miB += 1;
      return;
    }
    if (paramInt == -109)
    {
      this.miC += 1;
      return;
    }
    this.mio += 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223);
    paramParcel.writeLong(this.sessionId);
    paramParcel.writeInt(this.mio);
    paramParcel.writeInt(this.mip);
    paramParcel.writeInt(this.miq);
    paramParcel.writeInt(this.mir);
    paramParcel.writeInt(this.mis);
    paramParcel.writeInt(this.mit);
    paramParcel.writeInt(this.miu);
    paramParcel.writeInt(this.miv);
    paramParcel.writeInt(this.miw);
    paramParcel.writeInt(this.mix);
    paramParcel.writeInt(this.miy);
    paramParcel.writeInt(this.miz);
    paramParcel.writeInt(this.miA);
    paramParcel.writeInt(this.miB);
    paramParcel.writeInt(this.miC);
    paramParcel.writeInt(this.ciX);
    paramParcel.writeInt(this.mgC);
    paramParcel.writeInt(this.miD);
    paramParcel.writeInt(this.miE);
    paramParcel.writeMap(this.miF);
    paramParcel.writeMap(this.miG);
    AppMethodBeat.o(223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.FaceDetectReportInfo
 * JD-Core Version:    0.7.0.1
 */