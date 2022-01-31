package com.tencent.mm.component.api.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class UICustomParam
  implements Parcelable
{
  public static final Parcelable.Creator<UICustomParam> CREATOR;
  public float etA;
  public float etr;
  public float ets;
  public float ett;
  public float etu;
  public Map<String, Boolean> etv;
  public int etw;
  public int etx;
  public String ety;
  public int etz;
  public String text;
  
  static
  {
    AppMethodBeat.i(141854);
    CREATOR = new UICustomParam.1();
    AppMethodBeat.o(141854);
  }
  
  private UICustomParam()
  {
    AppMethodBeat.i(141851);
    this.etr = 0.0F;
    this.ets = 0.0F;
    this.ett = 0.0F;
    this.etu = 0.0F;
    this.etw = 0;
    this.etx = 0;
    this.text = "";
    this.ety = "";
    this.etz = 0;
    this.etA = 0.0F;
    this.etv = new HashMap();
    AppMethodBeat.o(141851);
  }
  
  private UICustomParam(Parcel paramParcel)
  {
    AppMethodBeat.i(141852);
    this.etr = 0.0F;
    this.ets = 0.0F;
    this.ett = 0.0F;
    this.etu = 0.0F;
    this.etw = 0;
    this.etx = 0;
    this.text = "";
    this.ety = "";
    this.etz = 0;
    this.etA = 0.0F;
    this.etr = paramParcel.readFloat();
    this.ets = paramParcel.readFloat();
    this.ett = paramParcel.readFloat();
    this.etu = paramParcel.readFloat();
    this.etv = paramParcel.readHashMap(HashMap.class.getClassLoader());
    this.etw = paramParcel.readInt();
    this.etx = paramParcel.readInt();
    this.text = paramParcel.readString();
    this.ety = paramParcel.readString();
    this.etz = paramParcel.readInt();
    this.etA = paramParcel.readFloat();
    AppMethodBeat.o(141852);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(141853);
    paramParcel.writeFloat(this.etr);
    paramParcel.writeFloat(this.ets);
    paramParcel.writeFloat(this.ett);
    paramParcel.writeFloat(this.etu);
    paramParcel.writeMap(this.etv);
    paramParcel.writeInt(this.etw);
    paramParcel.writeInt(this.etx);
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.ety);
    paramParcel.writeInt(this.etz);
    paramParcel.writeFloat(this.etA);
    AppMethodBeat.o(141853);
  }
  
  public static final class a
  {
    public UICustomParam etB;
    
    public a()
    {
      AppMethodBeat.i(141850);
      this.etB = new UICustomParam((byte)0);
      AppMethodBeat.o(141850);
    }
    
    public final a f(int paramInt1, int paramInt2, String paramString)
    {
      this.etB.etw = paramInt1;
      this.etB.etx = paramInt2;
      this.etB.text = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.component.api.jumper.UICustomParam
 * JD-Core Version:    0.7.0.1
 */