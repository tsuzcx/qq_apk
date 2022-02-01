package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.ai;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public VideoTransPara hvh;
  public int mode;
  public int scene;
  public int vMB;
  public String vMC;
  public String vMD;
  public String vME;
  public String vMF;
  public String vMG;
  public boolean vMH;
  public boolean vMI;
  public String vMJ;
  public boolean vMK;
  public boolean vML;
  public int vMM;
  
  static
  {
    AppMethodBeat.i(148787);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(148787);
  }
  
  public SightParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148784);
    this.mode = 0;
    this.vMB = 2;
    this.vMC = "";
    this.vMD = "";
    this.vME = "";
    this.vMF = "";
    this.vMG = "";
    this.vMH = true;
    this.scene = -1;
    this.vMI = true;
    this.vMJ = "";
    this.vMK = true;
    this.vML = false;
    if (paramInt1 == 1) {
      this.hvh = d.aGQ().aGR();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.ajD();
      this.vMM = ((Integer)g.ajC().ajl().get(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.hvh = d.aGQ().aGS();
      } else if (paramInt1 == 7) {
        this.hvh = d.aGQ().aGX();
      } else {
        this.hvh = d.aGQ().aGS();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.vMB = 2;
    this.vMC = "";
    this.vMD = "";
    this.vME = "";
    this.vMF = "";
    this.vMG = "";
    this.vMH = true;
    this.scene = -1;
    this.vMI = true;
    this.vMJ = "";
    this.vMK = true;
    this.vML = false;
    this.mode = paramParcel.readInt();
    this.hvh = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.vMC = paramParcel.readString();
    this.vMD = paramParcel.readString();
    this.vME = paramParcel.readString();
    this.vMF = paramParcel.readString();
    this.vMM = paramParcel.readInt();
    this.vMB = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.vMH = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.vMI = bool1;
      this.vMJ = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.vMK = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vML = bool1;
      AppMethodBeat.o(148785);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label185;
      bool1 = false;
      break label207;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final SightParams r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.vME = paramString1;
    this.vMC = paramString2;
    this.vMD = paramString3;
    this.vMF = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148786);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.hvh, paramInt);
    paramParcel.writeString(this.vMC);
    paramParcel.writeString(this.vMD);
    paramParcel.writeString(this.vME);
    paramParcel.writeString(this.vMF);
    paramParcel.writeInt(this.vMM);
    paramParcel.writeInt(this.vMB);
    byte b;
    if (this.vMH)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.vMI) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.vMJ);
      if (!this.vMK) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.vML) {
        break label169;
      }
    }
    label159:
    label164:
    label169:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(148786);
      return;
      paramInt = 0;
      break;
      b = 0;
      break label104;
      paramInt = 0;
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightParams
 * JD-Core Version:    0.7.0.1
 */