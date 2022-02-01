package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.aj;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public VideoTransPara hxV;
  public int mode;
  public String sSE;
  public int scene;
  public int vYF;
  public String vYG;
  public String vYH;
  public String vYI;
  public String vYJ;
  public String vYK;
  public boolean vYL;
  public boolean vYM;
  public boolean vYN;
  public boolean vYO;
  public int vYP;
  
  static
  {
    AppMethodBeat.i(148787);
    CREATOR = new SightParams.1();
    AppMethodBeat.o(148787);
  }
  
  public SightParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148784);
    this.mode = 0;
    this.vYF = 2;
    this.vYG = "";
    this.vYH = "";
    this.vYI = "";
    this.vYJ = "";
    this.vYK = "";
    this.vYL = true;
    this.scene = -1;
    this.vYM = true;
    this.sSE = "";
    this.vYN = true;
    this.vYO = false;
    if (paramInt1 == 1) {
      this.hxV = d.aHh().aHi();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.ajS();
      this.vYP = ((Integer)g.ajR().ajA().get(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.hxV = d.aHh().aHj();
      } else if (paramInt1 == 7) {
        this.hxV = d.aHh().aHo();
      } else {
        this.hxV = d.aHh().aHj();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.vYF = 2;
    this.vYG = "";
    this.vYH = "";
    this.vYI = "";
    this.vYJ = "";
    this.vYK = "";
    this.vYL = true;
    this.scene = -1;
    this.vYM = true;
    this.sSE = "";
    this.vYN = true;
    this.vYO = false;
    this.mode = paramParcel.readInt();
    this.hxV = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.vYG = paramParcel.readString();
    this.vYH = paramParcel.readString();
    this.vYI = paramParcel.readString();
    this.vYJ = paramParcel.readString();
    this.vYP = paramParcel.readInt();
    this.vYF = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.vYL = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.vYM = bool1;
      this.sSE = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.vYN = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vYO = bool1;
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
    this.vYI = paramString1;
    this.vYG = paramString2;
    this.vYH = paramString3;
    this.vYJ = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148786);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.hxV, paramInt);
    paramParcel.writeString(this.vYG);
    paramParcel.writeString(this.vYH);
    paramParcel.writeString(this.vYI);
    paramParcel.writeString(this.vYJ);
    paramParcel.writeInt(this.vYP);
    paramParcel.writeInt(this.vYF);
    byte b;
    if (this.vYL)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.vYM) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.sSE);
      if (!this.vYN) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.vYO) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightParams
 * JD-Core Version:    0.7.0.1
 */