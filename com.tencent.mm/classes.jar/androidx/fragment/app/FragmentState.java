package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR;
  final int bDt;
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final boolean mHidden;
  final boolean mRemoving;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  final String mWho;
  
  static
  {
    AppMethodBeat.i(193382);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(193382);
  }
  
  FragmentState(Parcel paramParcel)
  {
    AppMethodBeat.i(193373);
    this.mClassName = paramParcel.readString();
    this.mWho = paramParcel.readString();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.mFromLayout = bool1;
      this.mFragmentId = paramParcel.readInt();
      this.mContainerId = paramParcel.readInt();
      this.mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label156;
      }
      bool1 = true;
      label74:
      this.mRetainInstance = bool1;
      if (paramParcel.readInt() == 0) {
        break label161;
      }
      bool1 = true;
      label88:
      this.mRemoving = bool1;
      if (paramParcel.readInt() == 0) {
        break label166;
      }
      bool1 = true;
      label102:
      this.mDetached = bool1;
      this.mArguments = paramParcel.readBundle();
      if (paramParcel.readInt() == 0) {
        break label171;
      }
    }
    label156:
    label161:
    label166:
    label171:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mHidden = bool1;
      this.mSavedFragmentState = paramParcel.readBundle();
      this.bDt = paramParcel.readInt();
      AppMethodBeat.o(193373);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label74;
      bool1 = false;
      break label88;
      bool1 = false;
      break label102;
    }
  }
  
  FragmentState(Fragment paramFragment)
  {
    AppMethodBeat.i(193366);
    this.mClassName = paramFragment.getClass().getName();
    this.mWho = paramFragment.mWho;
    this.mFromLayout = paramFragment.mFromLayout;
    this.mFragmentId = paramFragment.mFragmentId;
    this.mContainerId = paramFragment.mContainerId;
    this.mTag = paramFragment.mTag;
    this.mRetainInstance = paramFragment.mRetainInstance;
    this.mRemoving = paramFragment.mRemoving;
    this.mDetached = paramFragment.mDetached;
    this.mArguments = paramFragment.mArguments;
    this.mHidden = paramFragment.mHidden;
    this.bDt = paramFragment.mMaxState.ordinal();
    AppMethodBeat.o(193366);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193391);
    Object localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append("FragmentState{");
    ((StringBuilder)localObject).append(this.mClassName);
    ((StringBuilder)localObject).append(" (");
    ((StringBuilder)localObject).append(this.mWho);
    ((StringBuilder)localObject).append(")}:");
    if (this.mFromLayout) {
      ((StringBuilder)localObject).append(" fromLayout");
    }
    if (this.mContainerId != 0)
    {
      ((StringBuilder)localObject).append(" id=0x");
      ((StringBuilder)localObject).append(Integer.toHexString(this.mContainerId));
    }
    if ((this.mTag != null) && (!this.mTag.isEmpty()))
    {
      ((StringBuilder)localObject).append(" tag=");
      ((StringBuilder)localObject).append(this.mTag);
    }
    if (this.mRetainInstance) {
      ((StringBuilder)localObject).append(" retainInstance");
    }
    if (this.mRemoving) {
      ((StringBuilder)localObject).append(" removing");
    }
    if (this.mDetached) {
      ((StringBuilder)localObject).append(" detached");
    }
    if (this.mHidden) {
      ((StringBuilder)localObject).append(" hidden");
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(193391);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(193405);
    paramParcel.writeString(this.mClassName);
    paramParcel.writeString(this.mWho);
    if (this.mFromLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mFragmentId);
      paramParcel.writeInt(this.mContainerId);
      paramParcel.writeString(this.mTag);
      if (!this.mRetainInstance) {
        break label152;
      }
      paramInt = 1;
      label70:
      paramParcel.writeInt(paramInt);
      if (!this.mRemoving) {
        break label157;
      }
      paramInt = 1;
      label84:
      paramParcel.writeInt(paramInt);
      if (!this.mDetached) {
        break label162;
      }
      paramInt = 1;
      label98:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mArguments);
      if (!this.mHidden) {
        break label167;
      }
    }
    label152:
    label157:
    label162:
    label167:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mSavedFragmentState);
      paramParcel.writeInt(this.bDt);
      AppMethodBeat.o(193405);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label70;
      paramInt = 0;
      break label84;
      paramInt = 0;
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.FragmentState
 * JD-Core Version:    0.7.0.1
 */