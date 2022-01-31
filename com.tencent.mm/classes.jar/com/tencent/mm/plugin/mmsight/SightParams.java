package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.z;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR = new SightParams.1();
  public int mfA;
  public int mfq = 2;
  public VideoTransPara mfr;
  public String mfs = "";
  public String mft = "";
  public String mfu = "";
  public String mfv = "";
  public String mfw = "";
  public boolean mfx = true;
  public boolean mfy = true;
  public String mfz = "";
  public int mode = 0;
  public int scene = -1;
  
  public SightParams(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      this.mfr = d.Nl().Nm();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.DQ();
      this.mfA = ((Integer)g.DP().Dz().get(344066, Integer.valueOf(0))).intValue();
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.mfr = d.Nl().Nn();
      } else {
        this.mfr = d.Nl().Nn();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    this.mode = paramParcel.readInt();
    this.mfr = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.mfs = paramParcel.readString();
    this.mft = paramParcel.readString();
    this.mfu = paramParcel.readString();
    this.mfv = paramParcel.readString();
    this.mfA = paramParcel.readInt();
    this.mfq = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.mfx = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label189;
      }
    }
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mfy = bool1;
      this.mfz = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final SightParams o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mfu = paramString1;
    this.mfs = paramString2;
    this.mft = paramString3;
    this.mfv = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b = 1;
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.mfr, paramInt);
    paramParcel.writeString(this.mfs);
    paramParcel.writeString(this.mft);
    paramParcel.writeString(this.mfu);
    paramParcel.writeString(this.mfv);
    paramParcel.writeInt(this.mfA);
    paramParcel.writeInt(this.mfq);
    if (this.mfx)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.mfy) {
        break label115;
      }
    }
    for (;;)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.mfz);
      return;
      paramInt = 0;
      break;
      label115:
      b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightParams
 * JD-Core Version:    0.7.0.1
 */