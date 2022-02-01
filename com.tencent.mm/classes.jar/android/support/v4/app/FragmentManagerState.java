package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  FragmentState[] Eb;
  int[] Ec;
  BackStackState[] Ed;
  int Ee = -1;
  int mNextFragmentIndex;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.Eb = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.Ec = paramParcel.createIntArray();
    this.Ed = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.Ee = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.Eb, paramInt);
    paramParcel.writeIntArray(this.Ec);
    paramParcel.writeTypedArray(this.Ed, paramInt);
    paramParcel.writeInt(this.Ee);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */