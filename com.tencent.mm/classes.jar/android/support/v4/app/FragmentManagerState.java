package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  int vp;
  FragmentState[] wn;
  int[] wo;
  BackStackState[] wp;
  int wq = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.wn = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.wo = paramParcel.createIntArray();
    this.wp = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.wq = paramParcel.readInt();
    this.vp = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.wn, paramInt);
    paramParcel.writeIntArray(this.wo);
    paramParcel.writeTypedArray(this.wp, paramInt);
    paramParcel.writeInt(this.wq);
    paramParcel.writeInt(this.vp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */