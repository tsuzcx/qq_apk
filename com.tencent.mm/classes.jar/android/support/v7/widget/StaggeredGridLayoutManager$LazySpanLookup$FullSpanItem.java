package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
  int axi;
  int[] axj;
  boolean axk;
  int mPosition;
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.mPosition = paramParcel.readInt();
    this.axi = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.axk = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.axj = new int[i];
        paramParcel.readIntArray(this.axj);
      }
      return;
      bool = false;
    }
  }
  
  final int cP(int paramInt)
  {
    if (this.axj == null) {
      return 0;
    }
    return this.axj[paramInt];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.axi + ", mHasUnwantedGapAfter=" + this.axk + ", mGapPerSpan=" + Arrays.toString(this.axj) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mPosition);
    paramParcel.writeInt(this.axi);
    if (this.axk) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.axj == null) || (this.axj.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.axj.length);
      paramParcel.writeIntArray(this.axj);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */