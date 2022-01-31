package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoTransPara
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<VideoTransPara> CREATOR;
  public int audioSampleRate;
  public int duration;
  public int eRF;
  public int fAg;
  public int fAh;
  public int fAi;
  public int fAj;
  public int fAk;
  public int fAl;
  public int fAm;
  public int fAn;
  public int fAo;
  public int fAp;
  public int fps;
  public int fzT;
  public int fzU;
  public int fzV;
  public int fzW;
  public int height;
  public boolean isDefault;
  public int videoBitrate;
  public int width;
  
  static
  {
    AppMethodBeat.i(117279);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117279);
  }
  
  public VideoTransPara()
  {
    this.fAg = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(117276);
    this.fAg = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.fzU = paramParcel.readInt();
    this.fzT = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.fzV = paramParcel.readInt();
    this.fzW = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {
      bool = true;
    }
    this.isDefault = bool;
    this.fAg = paramParcel.readInt();
    this.fAh = paramParcel.readInt();
    this.fAi = paramParcel.readInt();
    this.fAj = paramParcel.readInt();
    this.fAk = paramParcel.readInt();
    this.fAl = paramParcel.readInt();
    this.fAm = paramParcel.readInt();
    this.fAn = paramParcel.readInt();
    this.fAo = paramParcel.readInt();
    this.fAp = paramParcel.readInt();
    this.eRF = paramParcel.readInt();
    AppMethodBeat.o(117276);
  }
  
  public Object clone()
  {
    AppMethodBeat.i(140307);
    Object localObject = super.clone();
    AppMethodBeat.o(140307);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117278);
    String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.fzU + " audio bitrate " + this.fzT + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.eRF + " duration " + this.duration + " profile index " + this.fzV + " preset index " + this.fzW + " thumbSize " + this.fAg + " abaSwitch " + this.fAh + " qpSwitch " + this.fAi + " abaUpgear " + this.fAj + " abaDowngear " + this.fAk + " abaIncreasesize " + this.fAl + " abaDecreasesize " + this.fAm + " minQP " + this.fAn + " maxQP " + this.fAo + " takePhotosVideoBR " + this.fAp + "]";
    AppMethodBeat.o(117278);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117277);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.fps);
    paramParcel.writeInt(this.videoBitrate);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.fzU);
    paramParcel.writeInt(this.fzT);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.fzV);
    paramParcel.writeInt(this.fzW);
    if (this.isDefault) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.fAg);
      paramParcel.writeInt(this.fAh);
      paramParcel.writeInt(this.fAi);
      paramParcel.writeInt(this.fAj);
      paramParcel.writeInt(this.fAk);
      paramParcel.writeInt(this.fAl);
      paramParcel.writeInt(this.fAm);
      paramParcel.writeInt(this.fAn);
      paramParcel.writeInt(this.fAo);
      paramParcel.writeInt(this.fAp);
      paramParcel.writeInt(this.eRF);
      AppMethodBeat.o(117277);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.VideoTransPara
 * JD-Core Version:    0.7.0.1
 */