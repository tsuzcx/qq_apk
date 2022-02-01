package com.tencent.qav.controller.multi;

import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.observer.FilterableObserver;
import java.util.List;

public class QavMultiObserver
  extends FilterableObserver
{
  public static final int MSG_ON_ENTER_ROOM = 1;
  public static final int MSG_ON_ERROR = 2;
  public static final int MSG_ON_USER_AUDIO_AVAILABLE = 5;
  public static final int MSG_ON_USER_ENTER = 3;
  public static final int MSG_ON_USER_EXIT = 4;
  public static final int MSG_ON_USER_SPEAKING = 6;
  public static final int MSG_ON_USER_UPDATE = 7;
  
  public void onEnterRoom() {}
  
  public void onError(int paramInt) {}
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      onEnterRoom();
      return;
    case 2: 
      onError(((Integer)paramVarArgs[0]).intValue());
      return;
    case 3: 
      onUserEnter((QavDef.MultiUserInfo)paramVarArgs[0]);
      return;
    case 4: 
      onUserExit((QavDef.MultiUserInfo)paramVarArgs[0]);
      return;
    case 5: 
      onUserAudioAvailable((QavDef.MultiUserInfo)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 6: 
      onUserSpeaking((QavDef.MultiUserInfo)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    }
    onUserUpdate((List)paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.multi.QavMultiObserver
 * JD-Core Version:    0.7.0.1
 */