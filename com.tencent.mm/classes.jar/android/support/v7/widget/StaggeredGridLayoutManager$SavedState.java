package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new StaggeredGridLayoutManager.SavedState.1();
  int agJ;
  boolean agL;
  boolean ago;
  boolean amL;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> amX;
  int anb;
  int anc;
  int[] and;
  int ane;
  int[] anf;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.agJ = paramParcel.readInt();
    this.anb = paramParcel.readInt();
    this.anc = paramParcel.readInt();
    if (this.anc > 0)
    {
      this.and = new int[this.anc];
      paramParcel.readIntArray(this.and);
    }
    this.ane = paramParcel.readInt();
    if (this.ane > 0)
    {
      this.anf = new int[this.ane];
      paramParcel.readIntArray(this.anf);
    }
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.ago = bool1;
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label113:
      this.agL = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.amL = bool1;
      this.amX = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.anc = paramSavedState.anc;
    this.agJ = paramSavedState.agJ;
    this.anb = paramSavedState.anb;
    this.and = paramSavedState.and;
    this.ane = paramSavedState.ane;
    this.anf = paramSavedState.anf;
    this.ago = paramSavedState.ago;
    this.agL = paramSavedState.agL;
    this.amL = paramSavedState.amL;
    this.amX = paramSavedState.amX;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.agJ);
    paramParcel.writeInt(this.anb);
    paramParcel.writeInt(this.anc);
    if (this.anc > 0) {
      paramParcel.writeIntArray(this.and);
    }
    paramParcel.writeInt(this.ane);
    if (this.ane > 0) {
      paramParcel.writeIntArray(this.anf);
    }
    if (this.ago)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.agL) {
        break label120;
      }
      paramInt = 1;
      label87:
      paramParcel.writeInt(paramInt);
      if (!this.amL) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.amX);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */