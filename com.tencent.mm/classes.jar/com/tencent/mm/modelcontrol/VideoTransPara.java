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
  public int gnH;
  public int gnp;
  public int gnq;
  public int hbW;
  public int hbX;
  public int hbY;
  public int hci;
  public int hcj;
  public int hck;
  public int hcl;
  public int hcm;
  public int hcn;
  public int hco;
  public int hcp;
  public int hcq;
  public int hcr;
  public int hcs;
  public int hct;
  public int hcu;
  public int height;
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
    this.gnH = 1;
    this.hci = 0;
    this.hct = 0;
    this.hcu = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.gnH = 1;
    this.hci = 0;
    this.hct = 0;
    this.hcu = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.hbW = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.hbX = paramParcel.readInt();
    this.hbY = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.isDefault = bool;
      this.hci = paramParcel.readInt();
      this.hcj = paramParcel.readInt();
      this.hck = paramParcel.readInt();
      this.hcl = paramParcel.readInt();
      this.hcm = paramParcel.readInt();
      this.hcn = paramParcel.readInt();
      this.hco = paramParcel.readInt();
      this.hcp = paramParcel.readInt();
      this.hcq = paramParcel.readInt();
      this.gnp = paramParcel.readInt();
      this.gnq = paramParcel.readInt();
      this.hcr = paramParcel.readInt();
      this.hcs = paramParcel.readInt();
      this.gnH = paramParcel.readInt();
      this.hct = paramParcel.readInt();
      this.hcu = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.gnH = 1;
    this.hci = 0;
    this.hct = 0;
    this.hcu = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.hbW = paramVideoTransPara.hbW;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.hbX = paramVideoTransPara.hbX;
    this.hbY = paramVideoTransPara.hbY;
    this.isDefault = paramVideoTransPara.isDefault;
    this.hci = paramVideoTransPara.hci;
    this.hcj = paramVideoTransPara.hcj;
    this.hck = paramVideoTransPara.hck;
    this.hcl = paramVideoTransPara.hcl;
    this.hcm = paramVideoTransPara.hcm;
    this.hcn = paramVideoTransPara.hcn;
    this.hco = paramVideoTransPara.hco;
    this.hcp = paramVideoTransPara.hcp;
    this.gnp = paramVideoTransPara.gnp;
    this.gnq = paramVideoTransPara.gnq;
    this.hcr = paramVideoTransPara.hcr;
    this.hcs = paramVideoTransPara.hcs;
    this.gnH = paramVideoTransPara.gnH;
    this.hct = paramVideoTransPara.hct;
    this.hcu = paramVideoTransPara.hcu;
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
    String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.hbW + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.gnH + " duration " + this.duration + " profile index " + this.hbX + " preset index " + this.hbY + " thumbSize " + this.hci + " abaSwitch " + this.hcj + " qpSwitch " + this.hck + " abaUpgear " + this.hcl + " abaDowngear " + this.hcm + " abaIncreasesize " + this.hcn + " abaDecreasesize " + this.hco + " isEnableHEVCEncode " + this.hcp + " isEnable720p " + this.hcq + " minQP " + this.gnp + " maxQP " + this.gnq + " takePhotosVideoBR " + this.hcr + " remuxScene " + this.hcs + " hwEnableHevc " + this.hct + " swEnableHevc " + this.hcu + "]";
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
    paramParcel.writeInt(this.hbW);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.hbX);
    paramParcel.writeInt(this.hbY);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hci);
      paramParcel.writeInt(this.hcj);
      paramParcel.writeInt(this.hck);
      paramParcel.writeInt(this.hcl);
      paramParcel.writeInt(this.hcm);
      paramParcel.writeInt(this.hcn);
      paramParcel.writeInt(this.hco);
      paramParcel.writeInt(this.hcp);
      paramParcel.writeInt(this.hcq);
      paramParcel.writeInt(this.gnp);
      paramParcel.writeInt(this.gnq);
      paramParcel.writeInt(this.hcr);
      paramParcel.writeInt(this.hcs);
      paramParcel.writeInt(this.gnH);
      paramParcel.writeInt(this.hct);
      paramParcel.writeInt(this.hcu);
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