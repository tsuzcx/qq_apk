package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new StaggeredGridLayoutManager.SavedState.1();
  boolean aeb;
  int aew;
  boolean aey;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> akE;
  int akI;
  int akJ;
  int[] akK;
  int akL;
  int[] akM;
  boolean aks;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.aew = paramParcel.readInt();
    this.akI = paramParcel.readInt();
    this.akJ = paramParcel.readInt();
    if (this.akJ > 0)
    {
      this.akK = new int[this.akJ];
      paramParcel.readIntArray(this.akK);
    }
    this.akL = paramParcel.readInt();
    if (this.akL > 0)
    {
      this.akM = new int[this.akL];
      paramParcel.readIntArray(this.akM);
    }
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.aeb = bool1;
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label113:
      this.aey = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aks = bool1;
      this.akE = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.akJ = paramSavedState.akJ;
    this.aew = paramSavedState.aew;
    this.akI = paramSavedState.akI;
    this.akK = paramSavedState.akK;
    this.akL = paramSavedState.akL;
    this.akM = paramSavedState.akM;
    this.aeb = paramSavedState.aeb;
    this.aey = paramSavedState.aey;
    this.aks = paramSavedState.aks;
    this.akE = paramSavedState.akE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.aew);
    paramParcel.writeInt(this.akI);
    paramParcel.writeInt(this.akJ);
    if (this.akJ > 0) {
      paramParcel.writeIntArray(this.akK);
    }
    paramParcel.writeInt(this.akL);
    if (this.akL > 0) {
      paramParcel.writeIntArray(this.akM);
    }
    if (this.aeb)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.aey) {
        break label120;
      }
      paramInt = 1;
      label87:
      paramParcel.writeInt(paramInt);
      if (!this.aks) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.akE);
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