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
  public int minDuration;
  public int nCd;
  public int nxU;
  public int nxV;
  public int oBO;
  public int oBP;
  public boolean oBZ;
  public int oCa;
  public int oCb;
  public int oCc;
  public float oCd;
  public float oCe;
  public int oCf;
  public int oCg;
  public int oCh;
  public int oCi;
  public int oCj;
  public int oCk;
  public int oCl;
  public int oCm;
  public int oCn;
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
    this.oCa = 0;
    this.oCm = 0;
    this.oCn = 0;
  }
  
  protected VideoTransPara(Parcel paramParcel)
  {
    AppMethodBeat.i(133561);
    this.audioChannelCount = 1;
    this.oCa = 0;
    this.oCm = 0;
    this.oCn = 0;
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.fps = paramParcel.readInt();
    this.videoBitrate = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.nCd = paramParcel.readInt();
    this.audioBitrate = paramParcel.readInt();
    this.audioSampleRate = paramParcel.readInt();
    this.oBO = paramParcel.readInt();
    this.oBP = paramParcel.readInt();
    if (paramParcel.readInt() > 0) {}
    for (;;)
    {
      this.oBZ = bool;
      this.oCa = paramParcel.readInt();
      this.oCb = paramParcel.readInt();
      this.oCc = paramParcel.readInt();
      this.oCd = paramParcel.readFloat();
      this.oCe = paramParcel.readFloat();
      this.oCf = paramParcel.readInt();
      this.oCg = paramParcel.readInt();
      this.oCh = paramParcel.readInt();
      this.oCi = paramParcel.readInt();
      this.oCj = paramParcel.readInt();
      this.nxU = paramParcel.readInt();
      this.nxV = paramParcel.readInt();
      this.oCk = paramParcel.readInt();
      this.oCl = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.oCm = paramParcel.readInt();
      this.oCn = paramParcel.readInt();
      this.minDuration = paramParcel.readInt();
      AppMethodBeat.o(133561);
      return;
      bool = false;
    }
  }
  
  public VideoTransPara(VideoTransPara paramVideoTransPara)
  {
    this.audioChannelCount = 1;
    this.oCa = 0;
    this.oCm = 0;
    this.oCn = 0;
    this.width = paramVideoTransPara.width;
    this.height = paramVideoTransPara.height;
    this.fps = paramVideoTransPara.fps;
    this.videoBitrate = paramVideoTransPara.videoBitrate;
    this.duration = paramVideoTransPara.duration;
    this.nCd = paramVideoTransPara.nCd;
    this.audioBitrate = paramVideoTransPara.audioBitrate;
    this.audioSampleRate = paramVideoTransPara.audioSampleRate;
    this.oBO = paramVideoTransPara.oBO;
    this.oBP = paramVideoTransPara.oBP;
    this.oBZ = paramVideoTransPara.oBZ;
    this.oCa = paramVideoTransPara.oCa;
    this.oCb = paramVideoTransPara.oCb;
    this.oCc = paramVideoTransPara.oCc;
    this.oCd = paramVideoTransPara.oCd;
    this.oCe = paramVideoTransPara.oCe;
    this.oCf = paramVideoTransPara.oCf;
    this.oCg = paramVideoTransPara.oCg;
    this.oCh = paramVideoTransPara.oCh;
    this.oCi = paramVideoTransPara.oCi;
    this.oCj = paramVideoTransPara.oCj;
    this.nxU = paramVideoTransPara.nxU;
    this.nxV = paramVideoTransPara.nxV;
    this.oCk = paramVideoTransPara.oCk;
    this.oCl = paramVideoTransPara.oCl;
    this.audioChannelCount = paramVideoTransPara.audioChannelCount;
    this.oCm = paramVideoTransPara.oCm;
    this.oCn = paramVideoTransPara.oCn;
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
    String str = "[isDefault " + this.oBZ + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.nCd + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.audioChannelCount + " duration " + this.duration + " profile index " + this.oBO + " preset index " + this.oBP + " thumbSize " + this.oCa + " abaSwitch " + this.oCb + " qpSwitch " + this.oCc + " swHevcRatio " + this.oCd + " hwHevcRatio " + this.oCe + " ceilingVideoBR " + this.oCf + " flooringVideoBR " + this.oCg + " isEnableHEVCEncode " + this.oCh + " isEnable1080p " + this.oCi + " maxVideoSize " + this.oCj + " minQP " + this.nxU + " maxQP " + this.nxV + " takePhotosVideoBR " + this.oCk + " remuxScene " + this.oCl + " hwEnableHevc " + this.oCm + " swEnableHevc " + this.oCn + "]";
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
    paramParcel.writeInt(this.nCd);
    paramParcel.writeInt(this.audioBitrate);
    paramParcel.writeInt(this.audioSampleRate);
    paramParcel.writeInt(this.oBO);
    paramParcel.writeInt(this.oBP);
    if (this.oBZ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.oCa);
      paramParcel.writeInt(this.oCb);
      paramParcel.writeInt(this.oCc);
      paramParcel.writeFloat(this.oCd);
      paramParcel.writeFloat(this.oCe);
      paramParcel.writeInt(this.oCf);
      paramParcel.writeInt(this.oCg);
      paramParcel.writeInt(this.oCh);
      paramParcel.writeInt(this.oCi);
      paramParcel.writeInt(this.oCj);
      paramParcel.writeInt(this.nxU);
      paramParcel.writeInt(this.nxV);
      paramParcel.writeInt(this.oCk);
      paramParcel.writeInt(this.oCl);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.oCm);
      paramParcel.writeInt(this.oCn);
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