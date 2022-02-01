package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PluginBaseInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new b();
  public static final int INSTALL_TYPE_DEAMON = 0;
  public static final int INSTALL_TYPE_NOTICE = 1;
  public static final int STATE_CANCEL = -1;
  public static final int STATE_DOWNLOADED = 2;
  public static final int STATE_DOWNLOADING = 1;
  public static final int STATE_ERROR = -2;
  public static final int STATE_INSTALLED = 4;
  public static final int STATE_INSTALLING = 3;
  public static final int STATE_NODOWNLOAD = 0;
  public static final int TYPE_APP = 2;
  public static final int TYPE_COUNT = 3;
  public static final int TYPE_PART = 0;
  public static final int TYPE_PLUGIN = 1;
  public static final int UPDATE_TYPE_FORCE = 1;
  public static final int UPDATE_TYPE_OPTIONAL = 0;
  public long mCurVersion = 0L;
  public float mDownloadProgress;
  public int mForceUrl;
  public String mID = "";
  public int mInstallType = 0;
  public String mInstalledPath;
  public long mLength = 0L;
  public String mMD5 = "";
  public String mName = "";
  public String mPackageName = "";
  public String[] mProcesses = new String[0];
  public int mState;
  public int mType;
  public String mURL = "";
  public int mUpdateType = 1;
  public String mVersion = "";
  
  public PluginBaseInfo() {}
  
  public PluginBaseInfo(Parcel paramParcel)
  {
    this.mProcesses = paramParcel.createStringArray();
    this.mID = paramParcel.readString();
    this.mName = paramParcel.readString();
    this.mVersion = paramParcel.readString();
    this.mURL = paramParcel.readString();
    this.mMD5 = paramParcel.readString();
    this.mLength = paramParcel.readLong();
    this.mType = paramParcel.readInt();
    this.mCurVersion = paramParcel.readLong();
    this.mPackageName = paramParcel.readString();
    this.mState = paramParcel.readInt();
    this.mDownloadProgress = paramParcel.readFloat();
    this.mUpdateType = paramParcel.readInt();
    this.mInstallType = paramParcel.readInt();
    this.mInstalledPath = paramParcel.readString();
  }
  
  public PluginBaseInfo clone()
  {
    try
    {
      PluginBaseInfo localPluginBaseInfo = (PluginBaseInfo)super.clone();
      return localPluginBaseInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "" + this.mID + ", " + this.mPackageName + ", " + super.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStringArray(this.mProcesses);
    paramParcel.writeString(this.mID);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mVersion);
    paramParcel.writeString(this.mURL);
    paramParcel.writeString(this.mMD5);
    paramParcel.writeLong(this.mLength);
    paramParcel.writeInt(this.mType);
    paramParcel.writeLong(this.mCurVersion);
    paramParcel.writeString(this.mPackageName);
    paramParcel.writeInt(this.mState);
    paramParcel.writeFloat(this.mDownloadProgress);
    paramParcel.writeInt(this.mUpdateType);
    paramParcel.writeInt(this.mInstallType);
    paramParcel.writeString(this.mInstalledPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginBaseInfo
 * JD-Core Version:    0.7.0.1
 */