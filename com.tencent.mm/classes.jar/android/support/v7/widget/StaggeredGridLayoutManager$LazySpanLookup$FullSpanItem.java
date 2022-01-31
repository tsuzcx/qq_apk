package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1();
  int amY;
  int[] amZ;
  boolean ana;
  int mPosition;
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.mPosition = paramParcel.readInt();
    this.amY = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.ana = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.amZ = new int[i];
        paramParcel.readIntArray(this.amZ);
      }
      return;
      bool = false;
    }
  }
  
  final int cC(int paramInt)
  {
    if (this.amZ == null) {
      return 0;
    }
    return this.amZ[paramInt];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.amY + ", mHasUnwantedGapAfter=" + this.ana + ", mGapPerSpan=" + Arrays.toString(this.amZ) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mPosition);
    paramParcel.writeInt(this.amY);
    if (this.ana) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.amZ == null) || (this.amZ.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.amZ.length);
      paramParcel.writeIntArray(this.amZ);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */