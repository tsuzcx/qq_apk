package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.storage.aq;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public String FUP;
  public int KTU;
  public String KTV;
  public String KTW;
  public String KTX;
  public String KTY;
  public String KTZ;
  public boolean KUa;
  public boolean KUb;
  public boolean KUc;
  public boolean KUd;
  public int KUe;
  public int mode;
  public VideoTransPara nLH;
  public int scene;
  
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
    this.KTU = 2;
    this.KTV = "";
    this.KTW = "";
    this.KTX = "";
    this.KTY = "";
    this.KTZ = "";
    this.KUa = true;
    this.scene = -1;
    this.KUb = true;
    this.FUP = "";
    this.KUc = true;
    this.KUd = false;
    if (paramInt1 == 1) {
      this.nLH = e.bIg().bIh();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      h.baF();
      this.KUe = ((Integer)h.baE().ban().d(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.nLH = e.bIg().bIi();
      } else if (paramInt1 == 7) {
        this.nLH = e.bIg().bIp();
      } else {
        this.nLH = e.bIg().bIi();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.KTU = 2;
    this.KTV = "";
    this.KTW = "";
    this.KTX = "";
    this.KTY = "";
    this.KTZ = "";
    this.KUa = true;
    this.scene = -1;
    this.KUb = true;
    this.FUP = "";
    this.KUc = true;
    this.KUd = false;
    this.mode = paramParcel.readInt();
    this.nLH = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.KTV = paramParcel.readString();
    this.KTW = paramParcel.readString();
    this.KTX = paramParcel.readString();
    this.KTY = paramParcel.readString();
    this.KUe = paramParcel.readInt();
    this.KTU = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.KUa = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.KUb = bool1;
      this.FUP = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.KUc = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.KUd = bool1;
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
  
  public final SightParams D(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.KTX = paramString1;
    this.KTV = paramString2;
    this.KTW = paramString3;
    this.KTY = paramString4;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148786);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.nLH, paramInt);
    paramParcel.writeString(this.KTV);
    paramParcel.writeString(this.KTW);
    paramParcel.writeString(this.KTX);
    paramParcel.writeString(this.KTY);
    paramParcel.writeInt(this.KUe);
    paramParcel.writeInt(this.KTU);
    byte b;
    if (this.KUa)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.KUb) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.FUP);
      if (!this.KUc) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.KUd) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightParams
 * JD-Core Version:    0.7.0.1
 */