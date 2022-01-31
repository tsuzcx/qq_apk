package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.storage.z;

public class SightParams
  implements Parcelable
{
  public static final Parcelable.Creator<SightParams> CREATOR;
  public VideoTransPara fcu;
  public int mode;
  public int oFP;
  public String oFQ;
  public String oFR;
  public String oFS;
  public String oFT;
  public String oFU;
  public boolean oFV;
  public boolean oFW;
  public String oFX;
  public boolean oFY;
  public boolean oFZ;
  public int oGa;
  public int scene;
  
  static
  {
    AppMethodBeat.i(60281);
    CREATOR = new SightParams.1();
    AppMethodBeat.o(60281);
  }
  
  public SightParams(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(60278);
    this.mode = 0;
    this.oFP = 2;
    this.oFQ = "";
    this.oFR = "";
    this.oFS = "";
    this.oFT = "";
    this.oFU = "";
    this.oFV = true;
    this.scene = -1;
    this.oFW = true;
    this.oFX = "";
    this.oFY = true;
    this.oFZ = false;
    if (paramInt1 == 1) {
      this.fcu = d.afW().afX();
    }
    for (;;)
    {
      this.scene = paramInt1;
      this.mode = paramInt2;
      g.RM();
      this.oGa = ((Integer)g.RL().Ru().get(344066, Integer.valueOf(0))).intValue();
      AppMethodBeat.o(60278);
      return;
      if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4)) {
        this.fcu = d.afW().afY();
      } else if (paramInt1 == 7) {
        this.fcu = d.afW().agb();
      } else {
        this.fcu = d.afW().afY();
      }
    }
  }
  
  protected SightParams(Parcel paramParcel)
  {
    AppMethodBeat.i(60279);
    this.mode = 0;
    this.oFP = 2;
    this.oFQ = "";
    this.oFR = "";
    this.oFS = "";
    this.oFT = "";
    this.oFU = "";
    this.oFV = true;
    this.scene = -1;
    this.oFW = true;
    this.oFX = "";
    this.oFY = true;
    this.oFZ = false;
    this.mode = paramParcel.readInt();
    this.fcu = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.oFQ = paramParcel.readString();
    this.oFR = paramParcel.readString();
    this.oFS = paramParcel.readString();
    this.oFT = paramParcel.readString();
    this.oGa = paramParcel.readInt();
    this.oFP = paramParcel.readInt();
    if (paramParcel.readInt() > 0)
    {
      bool1 = true;
      this.oFV = bool1;
      this.scene = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label237;
      }
      bool1 = true;
      label185:
      this.oFW = bool1;
      this.oFX = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label242;
      }
      bool1 = true;
      label207:
      this.oFY = bool1;
      if (paramParcel.readByte() == 0) {
        break label247;
      }
    }
    label237:
    label242:
    label247:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.oFZ = bool1;
      AppMethodBeat.o(60279);
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
  
  public final SightParams q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.oFS = paramString1;
    this.oFQ = paramString2;
    this.oFR = paramString3;
    this.oFT = paramString4;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(60280);
    paramParcel.writeInt(this.mode);
    paramParcel.writeParcelable(this.fcu, paramInt);
    paramParcel.writeString(this.oFQ);
    paramParcel.writeString(this.oFR);
    paramParcel.writeString(this.oFS);
    paramParcel.writeString(this.oFT);
    paramParcel.writeInt(this.oGa);
    paramParcel.writeInt(this.oFP);
    byte b;
    if (this.oFV)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.scene);
      if (!this.oFW) {
        break label159;
      }
      b = 1;
      label104:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.oFX);
      if (!this.oFY) {
        break label164;
      }
      paramInt = 1;
      label126:
      paramParcel.writeByte((byte)paramInt);
      if (!this.oFZ) {
        break label169;
      }
    }
    label159:
    label164:
    label169:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(60280);
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