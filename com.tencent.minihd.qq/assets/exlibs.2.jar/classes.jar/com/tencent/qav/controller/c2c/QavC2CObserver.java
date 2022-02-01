package com.tencent.qav.controller.c2c;

import com.tencent.qav.observer.FilterableObserver;

public class QavC2CObserver
  extends FilterableObserver
{
  public static final int MSG_ON_ACCEPTED_VIDEO = 2;
  public static final int MSG_ON_ANOTHER_HAVE_ACCEPT = 13;
  public static final int MSG_ON_ANOTHER_HAVE_REJECT = 14;
  public static final int MSG_ON_CANCEL_REQUEST = 12;
  public static final int MSG_ON_CHANNEL_READY = 21;
  public static final int MSG_ON_CLOSE_VIDEO = 27;
  public static final int MSG_ON_INVITE_REACHED = 1;
  public static final int MSG_ON_PAUSE_AUDIO = 26;
  public static final int MSG_ON_PAUSE_VIDEO = 24;
  public static final int MSG_ON_RECEIVE_FIRST_VIDEO_FRAME = 23;
  public static final int MSG_ON_REJECT_VIDEO = 3;
  public static final int MSG_ON_REQUEST_VIDEO = 11;
  public static final int MSG_ON_RESUME_AUDIO = 25;
  public static final int MSG_ON_RESUME_VIDEO = 22;
  public static final int MSG_ON_UPDATE_NET_LEVEL = 28;
  
  public void onAcceptedVideo(String paramString) {}
  
  public void onAnotherHaveAccept(String paramString) {}
  
  public void onAnotherHaveReject(String paramString) {}
  
  public void onCancelRequest(String paramString) {}
  
  public void onChannelReady(String paramString) {}
  
  public void onCloseVideo(String paramString, int paramInt, long paramLong) {}
  
  public void onInviteReached(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte) {}
  
  public void onPauseAudio(String paramString) {}
  
  public void onPauseVideo(String paramString) {}
  
  public void onReceiveFirstVideoFrame(String paramString) {}
  
  public void onRejectVideo(String paramString) {}
  
  public void onRequestVideo(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3) {}
  
  public void onResumeAudio(String paramString) {}
  
  public void onResumeVideo(String paramString) {}
  
  public void onUpdateNetLevel(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return;
    case 1: 
      onInviteReached((String)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue(), ((Long)paramVarArgs[2]).longValue(), (byte[])paramVarArgs[3]);
      return;
    case 2: 
      onAcceptedVideo((String)paramVarArgs[0]);
      return;
    case 3: 
      onRejectVideo((String)paramVarArgs[0]);
      return;
    case 11: 
      onRequestVideo(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1], (String)paramVarArgs[2], (byte[])paramVarArgs[3], ((Boolean)paramVarArgs[4]).booleanValue(), (String)paramVarArgs[5], ((Integer)paramVarArgs[6]).intValue(), ((Integer)paramVarArgs[7]).intValue());
      return;
    case 12: 
      onCancelRequest((String)paramVarArgs[0]);
      return;
    case 13: 
      onAnotherHaveAccept((String)paramVarArgs[0]);
      return;
    case 14: 
      onAnotherHaveReject((String)paramVarArgs[0]);
      return;
    case 21: 
      onChannelReady((String)paramVarArgs[0]);
      return;
    case 22: 
      onResumeVideo((String)paramVarArgs[0]);
      return;
    case 23: 
      onReceiveFirstVideoFrame((String)paramVarArgs[0]);
      return;
    case 24: 
      onPauseVideo((String)paramVarArgs[0]);
      return;
    case 25: 
      onResumeAudio((String)paramVarArgs[0]);
      return;
    case 26: 
      onPauseAudio((String)paramVarArgs[0]);
      return;
    case 27: 
      onCloseVideo((String)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue(), ((Long)paramVarArgs[2]).longValue());
      return;
    }
    onUpdateNetLevel(((Integer)paramVarArgs[0]).intValue(), ((Integer)paramVarArgs[1]).intValue(), ((Integer)paramVarArgs[2]).intValue(), (String)paramVarArgs[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.c2c.QavC2CObserver
 * JD-Core Version:    0.7.0.1
 */