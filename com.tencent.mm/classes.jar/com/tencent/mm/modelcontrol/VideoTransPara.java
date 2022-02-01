package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoTransPara
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<VideoTransPara> CREATOR;
  public int audioBitrate;
  public int audioSampleRate;
  public int duration;
  public int fps;
  public int gOb;
  public int gOc;
  public int gOt;
  public int hCA;
  public int hCK;
  public int hCL;
  public int hCM;
  public int hCN;
  public int hCO;
  public int hCP;
  public int hCQ;
  public int hCR;
  public int hCS;
  public int hCT;
  public int hCU;
  public int hCV;
  public int hCW;
  public int hCX;
  public int hCy;
  public int hCz;
  public int height;
  public boolean isDefault;
  public int minDuration;
  public int videoBitrate;
  public int width;
  
  static
  {
    AppMethodBeat.i(133565);
    CREATOR = new VideoTransPara.1();
    AppMethodBeat.o(133565);
  }
  
  public VideoTransPara()
  {
    this.gOt = 1;
    this.hCK = 0;
    this.hCW = 0;
    this.hCX = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.gOt = 1;
    this.hCK = 0;
    this.hCW = 0;
    this.hCX = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.hCy = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.hCz = paramParcel.readInt();
    this.hCA = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.isDefault = bool;
      this.hCK = paramParcel.readInt();
      this.hCL = paramParcel.readInt();
      this.hCM = paramParcel.readInt();
      this.hCN = paramParcel.readInt();
      this.hCO = paramParcel.readInt();
      this.hCP = paramParcel.readInt();
      this.hCQ = paramParcel.readInt();
      this.hCR = paramParcel.readInt();
      this.hCS = paramParcel.readInt();
      this.hCT = paramParcel.readInt();
      this.gOb = paramParcel.readInt();
      this.gOc = paramParcel.readInt();
      this.hCU = paramParcel.readInt();
      this.hCV = paramParcel.readInt();
      this.gOt = paramParcel.readInt();
      this.hCW = paramParcel.readInt();
      this.hCX = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.gOt = 1;
    this.hCK = 0;
    this.hCW = 0;
    this.hCX = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.hCy = paramVideoTransPara.hCy;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.hCz = paramVideoTransPara.hCz;
    this.hCA = paramVideoTransPara.hCA;
    this.isDefault = paramVideoTransPara.isDefault;
    this.hCK = paramVideoTransPara.hCK;
    this.hCL = paramVideoTransPara.hCL;
    this.hCM = paramVideoTransPara.hCM;
    this.hCN = paramVideoTransPara.hCN;
    this.hCO = paramVideoTransPara.hCO;
    this.hCP = paramVideoTransPara.hCP;
    this.hCQ = paramVideoTransPara.hCQ;
    this.hCR = paramVideoTransPara.hCR;
    this.hCS = paramVideoTransPara.hCS;
    this.hCT = paramVideoTransPara.hCT;
    this.gOb = paramVideoTransPara.gOb;
    this.gOc = paramVideoTransPara.gOc;
    this.hCU = paramVideoTransPara.hCU;
    this.hCV = paramVideoTransPara.hCV;
    this.gOt = paramVideoTransPara.gOt;
    this.hCW = paramVideoTransPara.hCW;
    this.hCX = paramVideoTransPara.hCX;
    this.minDuration = paramVideoTransPara.minDuration;
  }
  
  public Object clone()
  {
    AppMethodBeat.i(133564);
    Object localObject = super.clone();
    AppMethodBeat.o(133564);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133563);
    String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.hCy + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.gOt + " duration " + this.duration + " profile index " + this.hCz + " preset index " + this.hCA + " thumbSize " + this.hCK + " abaSwitch " + this.hCL + " qpSwitch " + this.hCM + " abaUpgear " + this.hCN + " abaDowngear " + this.hCO + " ceilingVideoBR " + this.hCP + " flooringVideoBR " + this.hCQ + " isEnableHEVCEncode " + this.hCR + " isEnable720p " + this.hCS + " maxVideoSize " + this.hCT + " minQP " + this.gOb + " maxQP " + this.gOc + " takePhotosVideoBR " + this.hCU + " remuxScene " + this.hCV + " hwEnableHevc " + this.hCW + " swEnableHevc " + this.hCX + "]";
    AppMethodBeat.o(133563);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(133562);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.fps);
    paramParcel.writeInt(this.videoBitrate);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.hCy);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.hCz);
    paramParcel.writeInt(this.hCA);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hCK);
      paramParcel.writeInt(this.hCL);
      paramParcel.writeInt(this.hCM);
      paramParcel.writeInt(this.hCN);
      paramParcel.writeInt(this.hCO);
      paramParcel.writeInt(this.hCP);
      paramParcel.writeInt(this.hCQ);
      paramParcel.writeInt(this.hCR);
      paramParcel.writeInt(this.hCS);
      paramParcel.writeInt(this.hCT);
      paramParcel.writeInt(this.gOb);
      paramParcel.writeInt(this.gOc);
      paramParcel.writeInt(this.hCU);
      paramParcel.writeInt(this.hCV);
      paramParcel.writeInt(this.gOt);
      paramParcel.writeInt(this.hCW);
      paramParcel.writeInt(this.hCX);
      paramParcel.writeInt(this.minDuration);
      AppMethodBeat.o(133562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.VideoTransPara
 * JD-Core Version:    0.7.0.1
 */