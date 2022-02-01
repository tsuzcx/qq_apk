package com.tencent.av.gaudio;

import java.util.ArrayList;

public abstract interface QQGAudioCtrlCallback
{
  public abstract void dealInviteMemberRsp(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList);
  
  public abstract long getGAudioRoomId(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2);
  
  public abstract void onDetectAudioDataIssue(int paramInt);
  
  public abstract void onDoubleVideoMeetingInvite(long paramLong);
  
  public abstract void onEnterSuc(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void onFpsChange(int paramInt);
  
  public abstract void onGAudioInvite(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3);
  
  public abstract void onGAudioInviteResp(ArrayList<AVInviteAccount> paramArrayList);
  
  public abstract void onGAudioInviteRespFail(long paramLong1, long paramLong2, String paramString);
  
  public abstract void onGAudioKickOut(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void onGAudioMemAllUpdate(long paramLong, ArrayList<AVUserInfo> paramArrayList, int paramInt1, int paramInt2);
  
  public abstract void onGAudioMemAllUpdate(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2);
  
  public abstract void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void onGAudioMicSetByAdmin(long paramLong, boolean paramBoolean);
  
  public abstract void onGAudioRoomDistroy(int paramInt, long paramLong);
  
  public abstract void onGAudioRoomMicModeChanged(long paramLong, boolean paramBoolean);
  
  public abstract void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public abstract void onGAudioSetMicFailed(int paramInt, ArrayList<AVUserInfo> paramArrayList);
  
  public abstract void onGAudioTerminalEnterRoom(int paramInt, long paramLong, int... paramVarArgs);
  
  public abstract void onGAudioUserAudioSuspectNoisy(long paramLong1, boolean paramBoolean, long paramLong2);
  
  public abstract void onGVideoDownloadChannelCtlChanged(byte[] paramArrayOfByte);
  
  public abstract void onGaGoOffStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
  
  public abstract void onGaGoOnStageResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
  
  public abstract void onGaSwitchVideoResult(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
  
  public abstract void onGroupChatModeChange(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void onGroupSecurityLimit(long paramLong1, long paramLong2, String paramString);
  
  public abstract void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public abstract void onHowling();
  
  public abstract void onKickOutFail(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void onKickOutSuc(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs);
  
  public abstract void onMemberPosChanged(long paramLong, ArrayList<AVUserInfo> paramArrayList);
  
  public abstract void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
  
  public abstract void onOpenMicFail();
  
  public abstract void onPPTInOrOut(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract void onRemoteVideoDataComeIn(int paramInt1, long paramLong, int paramInt2);
  
  public abstract void onSetMicBySelf(long paramLong);
  
  public abstract void onVideoSrcChange(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void sendMultiVideoCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrlCallback
 * JD-Core Version:    0.7.0.1
 */