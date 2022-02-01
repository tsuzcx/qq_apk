package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  FragmentState[] Dd;
  int[] De;
  BackStackState[] Df;
  int Dg = -1;
  int mNextFragmentIndex;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.Dd = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.De = paramParcel.createIntArray();
    this.Df = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.Dg = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.Dd, paramInt);
    paramParcel.writeIntArray(this.De);
    paramParcel.writeTypedArray(this.Df, paramInt);
    paramParcel.writeInt(this.Dg);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */