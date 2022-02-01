package com.tencent.qav.controller.multi;

import com.tencent.qav.QavDef.MultiParams;

public abstract interface IMultiOperator
{
  public abstract void enableLocalAudio(boolean paramBoolean);
  
  public abstract void enableRemoteAudio(boolean paramBoolean);
  
  public abstract int enterRoom(QavDef.MultiParams paramMultiParams);
  
  public abstract void exitRoom();
  
  public abstract int getAudioRoute();
  
  public abstract boolean isLocalAudioEnable();
  
  public abstract boolean isRemoteAudioEnable();
  
  public abstract void setAudioRoute(int paramInt);
  
  public abstract void updateRoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.multi.IMultiOperator
 * JD-Core Version:    0.7.0.1
 */