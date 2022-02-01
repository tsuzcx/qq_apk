package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR;
  int anf;
  int[] ang;
  boolean anh;
  int mPosition;
  
  static
  {
    AppMethodBeat.i(262807);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(262807);
  }
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    AppMethodBeat.i(262801);
    this.mPosition = paramParcel.readInt();
    this.anf = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.anh = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.ang = new int[i];
        paramParcel.readIntArray(this.ang);
      }
      AppMethodBeat.o(262801);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  final int dq(int paramInt)
  {
    if (this.ang == null) {
      return 0;
    }
    return this.ang[paramInt];
  }
  
  public String toString()
  {
    AppMethodBeat.i(262805);
    String str = "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.anf + ", mHasUnwantedGapAfter=" + this.anh + ", mGapPerSpan=" + Arrays.toString(this.ang) + '}';
    AppMethodBeat.o(262805);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(262804);
    paramParcel.writeInt(this.mPosition);
    paramParcel.writeInt(this.anf);
    if (this.anh) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.ang == null) || (this.ang.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.ang.length);
      paramParcel.writeIntArray(this.ang);
      AppMethodBeat.o(262804);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(262804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */