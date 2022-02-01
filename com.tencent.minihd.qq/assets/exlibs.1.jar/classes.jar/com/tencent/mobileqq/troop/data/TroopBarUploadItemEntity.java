package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class TroopBarUploadItemEntity
  extends Entity
  implements Serializable, Cloneable
{
  public static final int UPLOAD_FROM_PUBLIC = 1001;
  public static final int UPLOAD_FROM_REPLY = 1002;
  public static final int UPLOAD_STATE_FAIL = 4;
  public static final int UPLOAD_STATE_NETWORK_DISABLED = 6;
  public static final int UPLOAD_STATE_NOT_START = 0;
  public static final int UPLOAD_STATE_PROCESS = 2;
  public static final int UPLOAD_STATE_START = 1;
  public static final int UPLOAD_STATE_STOP = 3;
  public static final int UPLOAD_STATE_SUCCESS = 5;
  private static final long serialVersionUID = 1L;
  public String mAudioPath;
  public String mAudioUrl;
  public String mBid;
  public String mCid;
  public String mContent;
  public int mFrom;
  public String mFromFlag;
  @unique
  public String mId;
  public int mItemType;
  public String mOpType;
  public int mPicCount;
  public String mPicList;
  public int mPicUploadCount;
  public String mPid;
  public float mProgress;
  public long mSize;
  public int mState;
  public long mTime;
  public String mTitle;
  public String mVid;
  public String mVideoPath;
  
  public TroopBarUploadItemEntity() {}
  
  public TroopBarUploadItemEntity(String paramString1, String paramString2, String paramString3)
  {
    this.mBid = paramString1;
    this.mPid = paramString2;
    this.mCid = paramString3;
    this.mId = getEntityId();
  }
  
  public String getEntityId()
  {
    return this.mBid + "_" + this.mPid + "_" + this.mCid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity
 * JD-Core Version:    0.7.0.1
 */