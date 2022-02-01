package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new BackStackState.1();
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final int mTransition;
  final int mTransitionStyle;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }
  
  public BackStackState(FragmentManagerImpl paramFragmentManagerImpl, BackStackRecord paramBackStackRecord)
  {
    paramFragmentManagerImpl = paramBackStackRecord.mHead;
    int j;
    for (int i = 0; paramFragmentManagerImpl != null; i = j)
    {
      j = i;
      if (paramFragmentManagerImpl.removed != null) {
        j = i + paramFragmentManagerImpl.removed.size();
      }
      paramFragmentManagerImpl = paramFragmentManagerImpl.next;
    }
    this.mOps = new int[i + paramBackStackRecord.mNumOp * 7];
    if (!paramBackStackRecord.mAddToBackStack) {
      throw new IllegalStateException("Not on back stack");
    }
    paramFragmentManagerImpl = paramBackStackRecord.mHead;
    i = 0;
    if (paramFragmentManagerImpl != null)
    {
      int[] arrayOfInt = this.mOps;
      j = i + 1;
      arrayOfInt[i] = paramFragmentManagerImpl.cmd;
      arrayOfInt = this.mOps;
      int k = j + 1;
      if (paramFragmentManagerImpl.fragment != null) {}
      for (i = paramFragmentManagerImpl.fragment.mIndex;; i = -1)
      {
        arrayOfInt[j] = i;
        arrayOfInt = this.mOps;
        i = k + 1;
        arrayOfInt[k] = paramFragmentManagerImpl.enterAnim;
        arrayOfInt = this.mOps;
        j = i + 1;
        arrayOfInt[i] = paramFragmentManagerImpl.exitAnim;
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = paramFragmentManagerImpl.popEnterAnim;
        arrayOfInt = this.mOps;
        j = i + 1;
        arrayOfInt[i] = paramFragmentManagerImpl.popExitAnim;
        if (paramFragmentManagerImpl.removed == null) {
          break label311;
        }
        k = paramFragmentManagerImpl.removed.size();
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = k;
        j = 0;
        while (j < k)
        {
          this.mOps[i] = ((Fragment)paramFragmentManagerImpl.removed.get(j)).mIndex;
          j += 1;
          i += 1;
        }
      }
      for (;;)
      {
        paramFragmentManagerImpl = paramFragmentManagerImpl.next;
        break;
        label311:
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = 0;
      }
    }
    this.mTransition = paramBackStackRecord.mTransition;
    this.mTransitionStyle = paramBackStackRecord.mTransitionStyle;
    this.mName = paramBackStackRecord.mName;
    this.mIndex = paramBackStackRecord.mIndex;
    this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
    this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
    this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
    this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int k = 0;
    int i = 0;
    while (i < this.mOps.length)
    {
      BackStackRecord.Op localOp = new BackStackRecord.Op();
      Object localObject = this.mOps;
      int j = i + 1;
      localOp.cmd = localObject[i];
      if ((FragmentManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
        QLog.d("FragmentManager", 4, "Instantiate " + localBackStackRecord + " op #" + k + " base fragment #" + this.mOps[j]);
      }
      localObject = this.mOps;
      i = j + 1;
      j = localObject[j];
      if (j >= 0) {}
      for (localOp.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(j));; localOp.fragment = null)
      {
        localObject = this.mOps;
        j = i + 1;
        localOp.enterAnim = localObject[i];
        localObject = this.mOps;
        i = j + 1;
        localOp.exitAnim = localObject[j];
        localObject = this.mOps;
        j = i + 1;
        localOp.popEnterAnim = localObject[i];
        localObject = this.mOps;
        i = j + 1;
        localOp.popExitAnim = localObject[j];
        localObject = this.mOps;
        j = i + 1;
        int n = localObject[i];
        i = j;
        if (n <= 0) {
          break;
        }
        localOp.removed = new ArrayList(n);
        int m = 0;
        for (;;)
        {
          i = j;
          if (m >= n) {
            break;
          }
          if ((FragmentManagerImpl.DEBUG) && (QLog.isDevelopLevel())) {
            QLog.d("FragmentManager", 4, "Instantiate " + localBackStackRecord + " set remove fragment #" + this.mOps[j]);
          }
          localObject = (Fragment)paramFragmentManagerImpl.mActive.get(this.mOps[j]);
          localOp.removed.add(localObject);
          m += 1;
          j += 1;
        }
      }
      localBackStackRecord.addOp(localOp);
      k += 1;
    }
    localBackStackRecord.mTransition = this.mTransition;
    localBackStackRecord.mTransitionStyle = this.mTransitionStyle;
    localBackStackRecord.mName = this.mName;
    localBackStackRecord.mIndex = this.mIndex;
    localBackStackRecord.mAddToBackStack = true;
    localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeInt(this.mTransitionStyle);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */