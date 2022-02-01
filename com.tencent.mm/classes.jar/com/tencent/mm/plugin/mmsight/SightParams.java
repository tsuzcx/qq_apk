package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.storage.ao;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public String AvN;
  public int EYi;
  public String EYj;
  public String EYk;
  public String EYl;
  public String EYm;
  public String EYn;
  public boolean EYo;
  public boolean EYp;
  public boolean EYq;
  public boolean EYr;
  public int EYs;
  public VideoTransPara lgX;
  public int mode;
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
    this.EYi = 2;
    this.EYj = "";
    this.EYk = "";
    this.EYl = "";
    this.EYm = "";
    this.EYn = "";
    this.EYo = true;
    this.scene = -1;
    this.EYp = true;
    this.AvN = "";
    this.EYq = true;
    this.EYr = false;
    if (paramInt1 == 1) {
      this.lgX = e.bkp().bkq();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      h.aHH();
      this.EYs = ((Integer)h.aHG().aHp().b(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.lgX = e.bkp().bkr();
      } else if (paramInt1 == 7) {
        this.lgX = e.bkp().bkw();
      } else {
        this.lgX = e.bkp().bkr();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.EYi = 2;
    this.EYj = "";
    this.EYk = "";
    this.EYl = "";
    this.EYm = "";
    this.EYn = "";
    this.EYo = true;
    this.scene = -1;
    this.EYp = true;
    this.AvN = "";
    this.EYq = true;
    this.EYr = false;
    this.mode = paramParcel.readInt();
    this.lgX = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.EYj = paramParcel.readString();
    this.EYk = paramParcel.readString();
    this.EYl = paramParcel.readString();
    this.EYm = paramParcel.readString();
    this.EYs = paramParcel.readInt();
    this.EYi = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.EYo = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.EYp = bool1;
      this.AvN = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.EYq = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.EYr = bool1;
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
  
  public final SightParams A(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.EYl = paramString1;
    this.EYj = paramString2;
    this.EYk = paramString3;
    this.EYm = paramString4;
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
    paramParcel.writeParcelable(this.lgX, paramInt);
    paramParcel.writeString(this.EYj);
    paramParcel.writeString(this.EYk);
    paramParcel.writeString(this.EYl);
    paramParcel.writeString(this.EYm);
    paramParcel.writeInt(this.EYs);
    paramParcel.writeInt(this.EYi);
    byte b;
    if (this.EYo)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.EYp) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.AvN);
      if (!this.EYq) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.EYr) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.SightParams
 * JD-Core Version:    0.7.0.1
 */