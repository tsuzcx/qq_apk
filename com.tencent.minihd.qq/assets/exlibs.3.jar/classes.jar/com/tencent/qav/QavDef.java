package com.tencent.qav;

import java.util.Arrays;

public class QavDef
{
  public static final int AUDIO_ROUTE_EARPIECE = 0;
  public static final int AUDIO_ROUTE_SPEAKER = 1;
  public static final int MULTI_ENTER_ROOM_RESULT_DEVICE_TAKE_UP = -2;
  public static final int MULTI_ENTER_ROOM_RESULT_DUPLICATE_CALL = -3;
  public static final int MULTI_ENTER_ROOM_RESULT_FAIL = -1;
  public static final int MULTI_ENTER_ROOM_RESULT_SUCCESS = 0;
  public static final int MULTI_ERROR_ENTER_ROOM_FAIL = 2;
  public static final int MULTI_ERROR_ENTER_ROOM_TIMEOUT = 1;
  public static final int MULTI_ERROR_INTERRUPT_BY_THIRD_CALL = 4;
  public static final int MULTI_ERROR_NET_ERROR = 3;
  
  public static final class MultiParams
  {
    public int mMultiAVSubType;
    public int mMultiAVType;
    public String mOpenId;
    public int mRelationType;
    public int mRoomId;
    public byte[] mSig;
    public int mSourceId;
    public long mUin;
    
    public String toString()
    {
      return "MultiParams{mRelationType=" + this.mRelationType + ", mMultiAVType=" + this.mMultiAVType + ", mMultiAVSubType=" + this.mMultiAVSubType + ", mRoomId=" + this.mRoomId + ", mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + '\'' + ", mSourceId=" + this.mSourceId + ", mSig=" + Arrays.toString(this.mSig) + '}';
    }
  }
  
  public static final class MultiUserInfo
  {
    public boolean mMicOn;
    public String mOpenId;
    public long mUin;
    
    public String toString()
    {
      return "MultiUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + '\'' + ", mMicOn=" + this.mMicOn + '}';
    }
  }
  
  public static final class VideoFrame
  {
    public int angle;
    public byte[] data;
    public boolean frontCamera;
    public int height;
    public int pixelFormat;
    public int rotation;
    public long timestamp;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.QavDef
 * JD-Core Version:    0.7.0.1
 */