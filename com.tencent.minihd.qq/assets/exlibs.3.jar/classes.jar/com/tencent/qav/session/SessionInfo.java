package com.tencent.qav.session;

public class SessionInfo
{
  public boolean mIsReceiver = false;
  public boolean mLocalFrontCamera = true;
  public String mPeerUin;
  public boolean mRemoteHasVideo = false;
  public int mScreenLayoutStyle = 1;
  public String mSessionId;
  public int mSessionType = 0;
  public byte[] mSignature = null;
  public boolean mSpeakerOn = false;
  public int mState = 0;
  
  public void setRemoteHasVideo(boolean paramBoolean)
  {
    this.mRemoteHasVideo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.session.SessionInfo
 * JD-Core Version:    0.7.0.1
 */