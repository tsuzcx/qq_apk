package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoTransPara
  implements Parcelable
{
  public static final Parcelable.Creator<VideoTransPara> CREATOR = new VideoTransPara.1();
  public int audioSampleRate;
  public int duration;
  public int ejM;
  public int ejN;
  public int ejO;
  public int ejP;
  public int ejZ = 0;
  public int fps;
  public int height;
  public boolean isDefault;
  public int videoBitrate;
  public int width;
  
  public VideoTransPara() {}
  
  protected VideoTransPara(Parcel paramParcel)
  {
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.ejN = paramParcel.readInt();
    this.ejM = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.ejO = paramParcel.readInt();
    this.ejP = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {
      bool = true;
    }
    this.isDefault = bool;
    this.ejZ = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.ejN + " audio bitrate " + this.ejM + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.ejO + " preset index " + this.ejP + " thumbSize " + this.ejZ + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.fps);
    paramParcel.writeInt(this.videoBitrate);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.ejN);
    paramParcel.writeInt(this.ejM);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.ejO);
    paramParcel.writeInt(this.ejP);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.ejZ);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.VideoTransPara
 * JD-Core Version:    0.7.0.1
 */