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
  public int audioChannelCount;
  public int audioSampleRate;
  public int duration;
  public int fps;
  public int hVA;
  public int hVB;
  public int hVC;
  public int hVe;
  public int hVf;
  public int hVp;
  public int hVq;
  public int hVr;
  public int hVs;
  public int hVt;
  public int hVu;
  public int hVv;
  public int hVw;
  public int hVx;
  public int hVy;
  public int hVz;
  public int height;
  public int hhV;
  public int hhW;
  public int hmx;
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
    this.audioChannelCount = 1;
    this.hVp = 0;
    this.hVB = 0;
    this.hVC = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.audioChannelCount = 1;
    this.hVp = 0;
    this.hVB = 0;
    this.hVC = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.hmx = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.hVe = paramParcel.readInt();
    this.hVf = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.isDefault = bool;
      this.hVp = paramParcel.readInt();
      this.hVq = paramParcel.readInt();
      this.hVr = paramParcel.readInt();
      this.hVs = paramParcel.readInt();
      this.hVt = paramParcel.readInt();
      this.hVu = paramParcel.readInt();
      this.hVv = paramParcel.readInt();
      this.hVw = paramParcel.readInt();
      this.hVx = paramParcel.readInt();
      this.hVy = paramParcel.readInt();
      this.hhV = paramParcel.readInt();
      this.hhW = paramParcel.readInt();
      this.hVz = paramParcel.readInt();
      this.hVA = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.hVB = paramParcel.readInt();
      this.hVC = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.audioChannelCount = 1;
    this.hVp = 0;
    this.hVB = 0;
    this.hVC = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.hmx = paramVideoTransPara.hmx;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.hVe = paramVideoTransPara.hVe;
    this.hVf = paramVideoTransPara.hVf;
    this.isDefault = paramVideoTransPara.isDefault;
    this.hVp = paramVideoTransPara.hVp;
    this.hVq = paramVideoTransPara.hVq;
    this.hVr = paramVideoTransPara.hVr;
    this.hVs = paramVideoTransPara.hVs;
    this.hVt = paramVideoTransPara.hVt;
    this.hVu = paramVideoTransPara.hVu;
    this.hVv = paramVideoTransPara.hVv;
    this.hVw = paramVideoTransPara.hVw;
    this.hVx = paramVideoTransPara.hVx;
    this.hVy = paramVideoTransPara.hVy;
    this.hhV = paramVideoTransPara.hhV;
    this.hhW = paramVideoTransPara.hhW;
    this.hVz = paramVideoTransPara.hVz;
    this.hVA = paramVideoTransPara.hVA;
    this.audioChannelCount = paramVideoTransPara.audioChannelCount;
    this.hVB = paramVideoTransPara.hVB;
    this.hVC = paramVideoTransPara.hVC;
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
    String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.hmx + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.audioChannelCount + " duration " + this.duration + " profile index " + this.hVe + " preset index " + this.hVf + " thumbSize " + this.hVp + " abaSwitch " + this.hVq + " qpSwitch " + this.hVr + " abaUpgear " + this.hVs + " abaDowngear " + this.hVt + " ceilingVideoBR " + this.hVu + " flooringVideoBR " + this.hVv + " isEnableHEVCEncode " + this.hVw + " isEnable720p " + this.hVx + " maxVideoSize " + this.hVy + " minQP " + this.hhV + " maxQP " + this.hhW + " takePhotosVideoBR " + this.hVz + " remuxScene " + this.hVA + " hwEnableHevc " + this.hVB + " swEnableHevc " + this.hVC + "]";
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
    paramParcel.writeInt(this.hmx);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.hVe);
    paramParcel.writeInt(this.hVf);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hVp);
      paramParcel.writeInt(this.hVq);
      paramParcel.writeInt(this.hVr);
      paramParcel.writeInt(this.hVs);
      paramParcel.writeInt(this.hVt);
      paramParcel.writeInt(this.hVu);
      paramParcel.writeInt(this.hVv);
      paramParcel.writeInt(this.hVw);
      paramParcel.writeInt(this.hVx);
      paramParcel.writeInt(this.hVy);
      paramParcel.writeInt(this.hhV);
      paramParcel.writeInt(this.hhW);
      paramParcel.writeInt(this.hVz);
      paramParcel.writeInt(this.hVA);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.hVB);
      paramParcel.writeInt(this.hVC);
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