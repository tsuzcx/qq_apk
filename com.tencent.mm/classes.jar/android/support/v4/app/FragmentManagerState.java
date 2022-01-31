package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  int mNextFragmentIndex;
  FragmentState[] wF;
  int[] wG;
  BackStackState[] wH;
  int wI = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.wF = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.wG = paramParcel.createIntArray();
    this.wH = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.wI = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.wF, paramInt);
    paramParcel.writeIntArray(this.wG);
    paramParcel.writeTypedArray(this.wH, paramInt);
    paramParcel.writeInt(this.wI);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */