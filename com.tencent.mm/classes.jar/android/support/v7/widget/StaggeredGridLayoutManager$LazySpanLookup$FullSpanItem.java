package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1();
  int akF;
  int[] akG;
  boolean akH;
  int mPosition;
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.mPosition = paramParcel.readInt();
    this.akF = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.akH = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.akG = new int[i];
        paramParcel.readIntArray(this.akG);
      }
      return;
      bool = false;
    }
  }
  
  final int cm(int paramInt)
  {
    if (this.akG == null) {
      return 0;
    }
    return this.akG[paramInt];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.akF + ", mHasUnwantedGapAfter=" + this.akH + ", mGapPerSpan=" + Arrays.toString(this.akG) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mPosition);
    paramParcel.writeInt(this.akF);
    if (this.akH) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.akG == null) || (this.akG.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.akG.length);
      paramParcel.writeIntArray(this.akG);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */