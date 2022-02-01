package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.storage.ao;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public VideoTransPara irT;
  public int mode;
  public int scene;
  public String vPa;
  public int zsH;
  public String zsI;
  public String zsJ;
  public String zsK;
  public String zsL;
  public String zsM;
  public boolean zsN;
  public boolean zsO;
  public boolean zsP;
  public boolean zsQ;
  public int zsR;
  
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
    this.zsH = 2;
    this.zsI = "";
    this.zsJ = "";
    this.zsK = "";
    this.zsL = "";
    this.zsM = "";
    this.zsN = true;
    this.scene = -1;
    this.zsO = true;
    this.vPa = "";
    this.zsP = true;
    this.zsQ = false;
    if (paramInt1 == 1) {
      this.irT = com.tencent.mm.modelcontrol.e.baZ().bba();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.aAi();
      this.zsR = ((Integer)g.aAh().azQ().get(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(148784);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.irT = com.tencent.mm.modelcontrol.e.baZ().bbb();
      } else if (paramInt1 == 7) {
        this.irT = com.tencent.mm.modelcontrol.e.baZ().bbh();
      } else {
        this.irT = com.tencent.mm.modelcontrol.e.baZ().bbb();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(148785);
    this.mode = 0;
    this.zsH = 2;
    this.zsI = "";
    this.zsJ = "";
    this.zsK = "";
    this.zsL = "";
    this.zsM = "";
    this.zsN = true;
    this.scene = -1;
    this.zsO = true;
    this.vPa = "";
    this.zsP = true;
    this.zsQ = false;
    this.mode = paramParcel.readInt();
    this.irT = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.zsI = paramParcel.readString();
    this.zsJ = paramParcel.readString();
    this.zsK = paramParcel.readString();
    this.zsL = paramParcel.readString();
    this.zsR = paramParcel.readInt();
    this.zsH = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.zsN = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.zsO = bool1;
      this.vPa = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.zsP = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zsQ = bool1;
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
  
  public final SightParams v(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.zsK = paramString1;
    this.zsI = paramString2;
    this.zsJ = paramString3;
    this.zsL = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148786);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.irT, paramInt);
    paramParcel.writeString(this.zsI);
    paramParcel.writeString(this.zsJ);
    paramParcel.writeString(this.zsK);
    paramParcel.writeString(this.zsL);
    paramParcel.writeInt(this.zsR);
    paramParcel.writeInt(this.zsH);
    byte b;
    if (this.zsN)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.zsO) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.vPa);
      if (!this.zsP) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.zsQ) {
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