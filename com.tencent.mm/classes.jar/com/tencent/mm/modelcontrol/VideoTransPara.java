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
  public int height;
  public int kSl;
  public int kSm;
  public int kXt;
  public int lJA;
  public int lJB;
  public int lJC;
  public int lJD;
  public int lJE;
  public int lJF;
  public int lJG;
  public int lJH;
  public int lJI;
  public int lJJ;
  public int lJK;
  public int lJL;
  public int lJm;
  public int lJn;
  public boolean lJx;
  public int lJy;
  public int lJz;
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
    this.lJy = 0;
    this.lJK = 0;
    this.lJL = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.audioChannelCount = 1;
    this.lJy = 0;
    this.lJK = 0;
    this.lJL = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.kXt = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.lJm = paramParcel.readInt();
    this.lJn = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.lJx = bool;
      this.lJy = paramParcel.readInt();
      this.lJz = paramParcel.readInt();
      this.lJA = paramParcel.readInt();
      this.lJB = paramParcel.readInt();
      this.lJC = paramParcel.readInt();
      this.lJD = paramParcel.readInt();
      this.lJE = paramParcel.readInt();
      this.lJF = paramParcel.readInt();
      this.lJG = paramParcel.readInt();
      this.lJH = paramParcel.readInt();
      this.kSl = paramParcel.readInt();
      this.kSm = paramParcel.readInt();
      this.lJI = paramParcel.readInt();
      this.lJJ = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.lJK = paramParcel.readInt();
      this.lJL = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.audioChannelCount = 1;
    this.lJy = 0;
    this.lJK = 0;
    this.lJL = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.kXt = paramVideoTransPara.kXt;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.lJm = paramVideoTransPara.lJm;
    this.lJn = paramVideoTransPara.lJn;
    this.lJx = paramVideoTransPara.lJx;
    this.lJy = paramVideoTransPara.lJy;
    this.lJz = paramVideoTransPara.lJz;
    this.lJA = paramVideoTransPara.lJA;
    this.lJB = paramVideoTransPara.lJB;
    this.lJC = paramVideoTransPara.lJC;
    this.lJD = paramVideoTransPara.lJD;
    this.lJE = paramVideoTransPara.lJE;
    this.lJF = paramVideoTransPara.lJF;
    this.lJG = paramVideoTransPara.lJG;
    this.lJH = paramVideoTransPara.lJH;
    this.kSl = paramVideoTransPara.kSl;
    this.kSm = paramVideoTransPara.kSm;
    this.lJI = paramVideoTransPara.lJI;
    this.lJJ = paramVideoTransPara.lJJ;
    this.audioChannelCount = paramVideoTransPara.audioChannelCount;
    this.lJK = paramVideoTransPara.lJK;
    this.lJL = paramVideoTransPara.lJL;
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
    String str = "[isDefault " + this.lJx + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.kXt + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.audioChannelCount + " duration " + this.duration + " profile index " + this.lJm + " preset index " + this.lJn + " thumbSize " + this.lJy + " abaSwitch " + this.lJz + " qpSwitch " + this.lJA + " abaUpgear " + this.lJB + " abaDowngear " + this.lJC + " ceilingVideoBR " + this.lJD + " flooringVideoBR " + this.lJE + " isEnableHEVCEncode " + this.lJF + " isEnable720p " + this.lJG + " maxVideoSize " + this.lJH + " minQP " + this.kSl + " maxQP " + this.kSm + " takePhotosVideoBR " + this.lJI + " remuxScene " + this.lJJ + " hwEnableHevc " + this.lJK + " swEnableHevc " + this.lJL + "]";
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
    paramParcel.writeInt(this.kXt);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.lJm);
    paramParcel.writeInt(this.lJn);
    if (this.lJx) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.lJy);
      paramParcel.writeInt(this.lJz);
      paramParcel.writeInt(this.lJA);
      paramParcel.writeInt(this.lJB);
      paramParcel.writeInt(this.lJC);
      paramParcel.writeInt(this.lJD);
      paramParcel.writeInt(this.lJE);
      paramParcel.writeInt(this.lJF);
      paramParcel.writeInt(this.lJG);
      paramParcel.writeInt(this.lJH);
      paramParcel.writeInt(this.kSl);
      paramParcel.writeInt(this.kSm);
      paramParcel.writeInt(this.lJI);
      paramParcel.writeInt(this.lJJ);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.lJK);
      paramParcel.writeInt(this.lJL);
      paramParcel.writeInt(this.minDuration);
      AppMethodBeat.o(133562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.VideoTransPara
 * JD-Core Version:    0.7.0.1
 */