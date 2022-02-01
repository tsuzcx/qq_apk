package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.ae;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public VideoTransPara hcZ;
  public int mode;
  public int scene;
  public String uJA;
  public boolean uJB;
  public boolean uJC;
  public String uJD;
  public boolean uJE;
  public boolean uJF;
  public int uJG;
  public int uJv;
  public String uJw;
  public String uJx;
  public String uJy;
  public String uJz;
  
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
    this.uJv = 2;
    this.uJw = "";
    this.uJx = "";
    this.uJy = "";
    this.uJz = "";
    this.uJA = "";
    this.uJB = true;
    this.scene = -1;
    this.uJC = true;
    this.uJD = "";
    this.uJE = true;
    this.uJF = false;
    if (paramInt1 == 1) {
      this.hcZ = d.aDL().aDM();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.agS();
      this.uJG = ((Integer)g.agR().agA().get(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.hcZ = d.aDL().aDN();
      } else if (paramInt1 == 7) {
        this.hcZ = d.aDL().aDS();
      } else {
        this.hcZ = d.aDL().aDN();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.uJv = 2;
    this.uJw = "";
    this.uJx = "";
    this.uJy = "";
    this.uJz = "";
    this.uJA = "";
    this.uJB = true;
    this.scene = -1;
    this.uJC = true;
    this.uJD = "";
    this.uJE = true;
    this.uJF = false;
    this.mode = paramParcel.readInt();
    this.hcZ = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.uJw = paramParcel.readString();
    this.uJx = paramParcel.readString();
    this.uJy = paramParcel.readString();
    this.uJz = paramParcel.readString();
    this.uJG = paramParcel.readInt();
    this.uJv = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.uJB = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.uJC = bool1;
      this.uJD = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.uJE = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.uJF = bool1;
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
    this.uJy = paramString1;
    this.uJw = paramString2;
    this.uJx = paramString3;
    this.uJz = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148786);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.hcZ, paramInt);
    paramParcel.writeString(this.uJw);
    paramParcel.writeString(this.uJx);
    paramParcel.writeString(this.uJy);
    paramParcel.writeString(this.uJz);
    paramParcel.writeInt(this.uJG);
    paramParcel.writeInt(this.uJv);
    byte b;
    if (this.uJB)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.uJC) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.uJD);
      if (!this.uJE) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.uJF) {
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