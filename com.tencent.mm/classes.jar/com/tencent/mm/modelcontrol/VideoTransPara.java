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
  public int hXW;
  public int hXX;
  public int hYh;
  public int hYi;
  public int hYj;
  public int hYk;
  public int hYl;
  public int hYm;
  public int hYn;
  public int hYo;
  public int hYp;
  public int hYq;
  public int hYr;
  public int hYs;
  public int hYt;
  public int hYu;
  public int height;
  public int hkJ;
  public int hkK;
  public int hpl;
  public boolean isDefault;
  public int minDuration;
  public int videoBitrate;
  public int width;
  
  static
  {
    AppMethodBeat.i(133565);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(133565);
  }
  
  public VideoTransPara()
  {
    this.audioChannelCount = 1;
    this.hYh = 0;
    this.hYt = 0;
    this.hYu = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.audioChannelCount = 1;
    this.hYh = 0;
    this.hYt = 0;
    this.hYu = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.hpl = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.hXW = paramParcel.readInt();
    this.hXX = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.isDefault = bool;
      this.hYh = paramParcel.readInt();
      this.hYi = paramParcel.readInt();
      this.hYj = paramParcel.readInt();
      this.hYk = paramParcel.readInt();
      this.hYl = paramParcel.readInt();
      this.hYm = paramParcel.readInt();
      this.hYn = paramParcel.readInt();
      this.hYo = paramParcel.readInt();
      this.hYp = paramParcel.readInt();
      this.hYq = paramParcel.readInt();
      this.hkJ = paramParcel.readInt();
      this.hkK = paramParcel.readInt();
      this.hYr = paramParcel.readInt();
      this.hYs = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.hYt = paramParcel.readInt();
      this.hYu = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.audioChannelCount = 1;
    this.hYh = 0;
    this.hYt = 0;
    this.hYu = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.hpl = paramVideoTransPara.hpl;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.hXW = paramVideoTransPara.hXW;
    this.hXX = paramVideoTransPara.hXX;
    this.isDefault = paramVideoTransPara.isDefault;
    this.hYh = paramVideoTransPara.hYh;
    this.hYi = paramVideoTransPara.hYi;
    this.hYj = paramVideoTransPara.hYj;
    this.hYk = paramVideoTransPara.hYk;
    this.hYl = paramVideoTransPara.hYl;
    this.hYm = paramVideoTransPara.hYm;
    this.hYn = paramVideoTransPara.hYn;
    this.hYo = paramVideoTransPara.hYo;
    this.hYp = paramVideoTransPara.hYp;
    this.hYq = paramVideoTransPara.hYq;
    this.hkJ = paramVideoTransPara.hkJ;
    this.hkK = paramVideoTransPara.hkK;
    this.hYr = paramVideoTransPara.hYr;
    this.hYs = paramVideoTransPara.hYs;
    this.audioChannelCount = paramVideoTransPara.audioChannelCount;
    this.hYt = paramVideoTransPara.hYt;
    this.hYu = paramVideoTransPara.hYu;
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
    String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.hpl + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.audioChannelCount + " duration " + this.duration + " profile index " + this.hXW + " preset index " + this.hXX + " thumbSize " + this.hYh + " abaSwitch " + this.hYi + " qpSwitch " + this.hYj + " abaUpgear " + this.hYk + " abaDowngear " + this.hYl + " ceilingVideoBR " + this.hYm + " flooringVideoBR " + this.hYn + " isEnableHEVCEncode " + this.hYo + " isEnable720p " + this.hYp + " maxVideoSize " + this.hYq + " minQP " + this.hkJ + " maxQP " + this.hkK + " takePhotosVideoBR " + this.hYr + " remuxScene " + this.hYs + " hwEnableHevc " + this.hYt + " swEnableHevc " + this.hYu + "]";
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
    paramParcel.writeInt(this.hpl);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.hXW);
    paramParcel.writeInt(this.hXX);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hYh);
      paramParcel.writeInt(this.hYi);
      paramParcel.writeInt(this.hYj);
      paramParcel.writeInt(this.hYk);
      paramParcel.writeInt(this.hYl);
      paramParcel.writeInt(this.hYm);
      paramParcel.writeInt(this.hYn);
      paramParcel.writeInt(this.hYo);
      paramParcel.writeInt(this.hYp);
      paramParcel.writeInt(this.hYq);
      paramParcel.writeInt(this.hkJ);
      paramParcel.writeInt(this.hkK);
      paramParcel.writeInt(this.hYr);
      paramParcel.writeInt(this.hYs);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.hYt);
      paramParcel.writeInt(this.hYu);
      paramParcel.writeInt(this.minDuration);
      AppMethodBeat.o(133562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.VideoTransPara
 * JD-Core Version:    0.7.0.1
 */