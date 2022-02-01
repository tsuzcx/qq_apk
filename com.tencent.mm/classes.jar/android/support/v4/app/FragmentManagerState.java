package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  FragmentState[] FS;
  int[] FT;
  BackStackState[] FU;
  int FV = -1;
  int mNextFragmentIndex;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.FS = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.FT = paramParcel.createIntArray();
    this.FU = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.FV = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.FS, paramInt);
    paramParcel.writeIntArray(this.FT);
    paramParcel.writeTypedArray(this.FU, paramInt);
    paramParcel.writeInt(this.FV);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */