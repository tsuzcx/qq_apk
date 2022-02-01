package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR;
  Fragment Wm;
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final boolean mHidden;
  final int mIndex;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  
  static
  {
    AppMethodBeat.i(212868);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(212868);
  }
  
  FragmentState(Parcel paramParcel)
  {
    AppMethodBeat.i(212863);
    this.mClassName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.mFromLayout = bool1;
      this.mFragmentId = paramParcel.readInt();
      this.mContainerId = paramParcel.readInt();
      this.mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label134;
      }
      bool1 = true;
      label74:
      this.mRetainInstance = bool1;
      if (paramParcel.readInt() == 0) {
        break label139;
      }
      bool1 = true;
      label88:
      this.mDetached = bool1;
      this.mArguments = paramParcel.readBundle();
      if (paramParcel.readInt() == 0) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mHidden = bool1;
      this.mSavedFragmentState = paramParcel.readBundle();
      AppMethodBeat.o(212863);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label74;
      bool1 = false;
      break label88;
    }
  }
  
  FragmentState(Fragment paramFragment)
  {
    AppMethodBeat.i(212862);
    this.mClassName = paramFragment.getClass().getName();
    this.mIndex = paramFragment.mIndex;
    this.mFromLayout = paramFragment.mFromLayout;
    this.mFragmentId = paramFragment.mFragmentId;
    this.mContainerId = paramFragment.mContainerId;
    this.mTag = paramFragment.mTag;
    this.mRetainInstance = paramFragment.mRetainInstance;
    this.mDetached = paramFragment.mDetached;
    this.mArguments = paramFragment.mArguments;
    this.mHidden = paramFragment.mHidden;
    AppMethodBeat.o(212862);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(212865);
    paramParcel.writeString(this.mClassName);
    paramParcel.writeInt(this.mIndex);
    if (this.mFromLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mFragmentId);
      paramParcel.writeInt(this.mContainerId);
      paramParcel.writeString(this.mTag);
      if (!this.mRetainInstance) {
        break label130;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.mDetached) {
        break label135;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mArguments);
      if (!this.mHidden) {
        break label140;
      }
    }
    label130:
    label135:
    label140:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mSavedFragmentState);
      AppMethodBeat.o(212865);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label70;
      paramInt = 0;
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.fragment.app.FragmentState
 * JD-Core Version:    0.7.0.1
 */