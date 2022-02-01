package com.tencent.mm.plugin.gallery.model;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SelectedItem
  implements Parcelable
{
  public static final Parcelable.Creator<SelectedItem> CREATOR;
  public Matrix gT;
  public String path;
  public int type;
  public long xjE;
  
  static
  {
    AppMethodBeat.i(164773);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(164773);
  }
  
  public SelectedItem() {}
  
  protected SelectedItem(Parcel paramParcel)
  {
    AppMethodBeat.i(164772);
    this.path = paramParcel.readString();
    this.xjE = paramParcel.readLong();
    this.gT.setValues(paramParcel.createFloatArray());
    this.type = paramParcel.readInt();
    AppMethodBeat.o(164772);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(164770);
    if ((paramObject instanceof SelectedItem))
    {
      if (((SelectedItem)paramObject).xjE == this.xjE)
      {
        AppMethodBeat.o(164770);
        return true;
      }
      AppMethodBeat.o(164770);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(164770);
    return bool;
  }
  
  public int hashCode()
  {
    return this.type;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(164771);
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.xjE);
    float[] arrayOfFloat = new float[9];
    this.gT.getValues(arrayOfFloat);
    paramParcel.writeFloatArray(arrayOfFloat);
    paramParcel.writeInt(this.type);
    AppMethodBeat.o(164771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.SelectedItem
 * JD-Core Version:    0.7.0.1
 */