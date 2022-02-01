package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.ab;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public VideoTransPara gCB;
  public int mode;
  public int scene;
  public int tAY;
  public String tAZ;
  public String tBa;
  public String tBb;
  public String tBc;
  public String tBd;
  public boolean tBe;
  public boolean tBf;
  public String tBg;
  public boolean tBh;
  public boolean tBi;
  public int tBj;
  
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
    this.tAY = 2;
    this.tAZ = "";
    this.tBa = "";
    this.tBb = "";
    this.tBc = "";
    this.tBd = "";
    this.tBe = true;
    this.scene = -1;
    this.tBf = true;
    this.tBg = "";
    this.tBh = true;
    this.tBi = false;
    if (paramInt1 == 1) {
      this.gCB = d.awT().awU();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.afC();
      this.tBj = ((Integer)g.afB().afk().get(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.gCB = d.awT().awV();
      } else if (paramInt1 == 7) {
        this.gCB = d.awT().axa();
      } else {
        this.gCB = d.awT().awV();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.tAY = 2;
    this.tAZ = "";
    this.tBa = "";
    this.tBb = "";
    this.tBc = "";
    this.tBd = "";
    this.tBe = true;
    this.scene = -1;
    this.tBf = true;
    this.tBg = "";
    this.tBh = true;
    this.tBi = false;
    this.mode = paramParcel.readInt();
    this.gCB = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.tAZ = paramParcel.readString();
    this.tBa = paramParcel.readString();
    this.tBb = paramParcel.readString();
    this.tBc = paramParcel.readString();
    this.tBj = paramParcel.readInt();
    this.tAY = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.tBe = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.tBf = bool1;
      this.tBg = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.tBh = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.tBi = bool1;
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
  
  public final SightParams p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.tBb = paramString1;
    this.tAZ = paramString2;
    this.tBa = paramString3;
    this.tBc = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148786);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.gCB, paramInt);
    paramParcel.writeString(this.tAZ);
    paramParcel.writeString(this.tBa);
    paramParcel.writeString(this.tBb);
    paramParcel.writeString(this.tBc);
    paramParcel.writeInt(this.tBj);
    paramParcel.writeInt(this.tAY);
    byte b;
    if (this.tBe)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.tBf) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.tBg);
      if (!this.tBh) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.tBi) {
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