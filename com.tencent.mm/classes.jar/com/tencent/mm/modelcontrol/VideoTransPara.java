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
  public int iSU;
  public int iSV;
  public int iTf;
  public int iTg;
  public int iTh;
  public int iTi;
  public int iTj;
  public int iTk;
  public int iTl;
  public int iTm;
  public int iTn;
  public int iTo;
  public int iTp;
  public int iTq;
  public int iTr;
  public int iTs;
  public int idF;
  public int idG;
  public int iiH;
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
    this.iTf = 0;
    this.iTr = 0;
    this.iTs = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.audioChannelCount = 1;
    this.iTf = 0;
    this.iTr = 0;
    this.iTs = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.iiH = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.iSU = paramParcel.readInt();
    this.iSV = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.isDefault = bool;
      this.iTf = paramParcel.readInt();
      this.iTg = paramParcel.readInt();
      this.iTh = paramParcel.readInt();
      this.iTi = paramParcel.readInt();
      this.iTj = paramParcel.readInt();
      this.iTk = paramParcel.readInt();
      this.iTl = paramParcel.readInt();
      this.iTm = paramParcel.readInt();
      this.iTn = paramParcel.readInt();
      this.iTo = paramParcel.readInt();
      this.idF = paramParcel.readInt();
      this.idG = paramParcel.readInt();
      this.iTp = paramParcel.readInt();
      this.iTq = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.iTr = paramParcel.readInt();
      this.iTs = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.audioChannelCount = 1;
    this.iTf = 0;
    this.iTr = 0;
    this.iTs = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.iiH = paramVideoTransPara.iiH;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.iSU = paramVideoTransPara.iSU;
    this.iSV = paramVideoTransPara.iSV;
    this.isDefault = paramVideoTransPara.isDefault;
    this.iTf = paramVideoTransPara.iTf;
    this.iTg = paramVideoTransPara.iTg;
    this.iTh = paramVideoTransPara.iTh;
    this.iTi = paramVideoTransPara.iTi;
    this.iTj = paramVideoTransPara.iTj;
    this.iTk = paramVideoTransPara.iTk;
    this.iTl = paramVideoTransPara.iTl;
    this.iTm = paramVideoTransPara.iTm;
    this.iTn = paramVideoTransPara.iTn;
    this.iTo = paramVideoTransPara.iTo;
    this.idF = paramVideoTransPara.idF;
    this.idG = paramVideoTransPara.idG;
    this.iTp = paramVideoTransPara.iTp;
    this.iTq = paramVideoTransPara.iTq;
    this.audioChannelCount = paramVideoTransPara.audioChannelCount;
    this.iTr = paramVideoTransPara.iTr;
    this.iTs = paramVideoTransPara.iTs;
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
    String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.iiH + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.audioChannelCount + " duration " + this.duration + " profile index " + this.iSU + " preset index " + this.iSV + " thumbSize " + this.iTf + " abaSwitch " + this.iTg + " qpSwitch " + this.iTh + " abaUpgear " + this.iTi + " abaDowngear " + this.iTj + " ceilingVideoBR " + this.iTk + " flooringVideoBR " + this.iTl + " isEnableHEVCEncode " + this.iTm + " isEnable720p " + this.iTn + " maxVideoSize " + this.iTo + " minQP " + this.idF + " maxQP " + this.idG + " takePhotosVideoBR " + this.iTp + " remuxScene " + this.iTq + " hwEnableHevc " + this.iTr + " swEnableHevc " + this.iTs + "]";
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
    paramParcel.writeInt(this.iiH);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.iSU);
    paramParcel.writeInt(this.iSV);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.iTf);
      paramParcel.writeInt(this.iTg);
      paramParcel.writeInt(this.iTh);
      paramParcel.writeInt(this.iTi);
      paramParcel.writeInt(this.iTj);
      paramParcel.writeInt(this.iTk);
      paramParcel.writeInt(this.iTl);
      paramParcel.writeInt(this.iTm);
      paramParcel.writeInt(this.iTn);
      paramParcel.writeInt(this.iTo);
      paramParcel.writeInt(this.idF);
      paramParcel.writeInt(this.idG);
      paramParcel.writeInt(this.iTp);
      paramParcel.writeInt(this.iTq);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.iTr);
      paramParcel.writeInt(this.iTs);
      paramParcel.writeInt(this.minDuration);
      AppMethodBeat.o(133562);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.VideoTransPara
 * JD-Core Version:    0.7.0.1
 */