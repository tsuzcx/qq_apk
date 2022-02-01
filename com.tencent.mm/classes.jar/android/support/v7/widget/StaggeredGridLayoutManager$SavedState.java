package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  int aqP;
  boolean aqR;
  boolean aqu;
  boolean awV;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> axh;
  int axl;
  int axm;
  int[] axn;
  int axo;
  int[] axp;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.aqP = paramParcel.readInt();
    this.axl = paramParcel.readInt();
    this.axm = paramParcel.readInt();
    if (this.axm > 0)
    {
      this.axn = new int[this.axm];
      paramParcel.readIntArray(this.axn);
    }
    this.axo = paramParcel.readInt();
    if (this.axo > 0)
    {
      this.axp = new int[this.axo];
      paramParcel.readIntArray(this.axp);
    }
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.aqu = bool1;
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label113:
      this.aqR = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.awV = bool1;
      this.axh = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.axm = paramSavedState.axm;
    this.aqP = paramSavedState.aqP;
    this.axl = paramSavedState.axl;
    this.axn = paramSavedState.axn;
    this.axo = paramSavedState.axo;
    this.axp = paramSavedState.axp;
    this.aqu = paramSavedState.aqu;
    this.aqR = paramSavedState.aqR;
    this.awV = paramSavedState.awV;
    this.axh = paramSavedState.axh;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  final void mK()
  {
    this.axn = null;
    this.axm = 0;
    this.aqP = -1;
    this.axl = -1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.aqP);
    paramParcel.writeInt(this.axl);
    paramParcel.writeInt(this.axm);
    if (this.axm > 0) {
      paramParcel.writeIntArray(this.axn);
    }
    paramParcel.writeInt(this.axo);
    if (this.axo > 0) {
      paramParcel.writeIntArray(this.axp);
    }
    if (this.aqu)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.aqR) {
        break label120;
      }
      paramInt = 1;
      label87:
      paramParcel.writeInt(paramInt);
      if (!this.awV) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.axh);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */