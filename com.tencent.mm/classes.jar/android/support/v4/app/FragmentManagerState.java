package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  FragmentState[] Gc;
  int[] Gd;
  BackStackState[] Ge;
  int Gf = -1;
  int mNextFragmentIndex;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.Gc = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.Gd = paramParcel.createIntArray();
    this.Ge = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.Gf = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.Gc, paramInt);
    paramParcel.writeIntArray(this.Gd);
    paramParcel.writeTypedArray(this.Ge, paramInt);
    paramParcel.writeInt(this.Gf);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */