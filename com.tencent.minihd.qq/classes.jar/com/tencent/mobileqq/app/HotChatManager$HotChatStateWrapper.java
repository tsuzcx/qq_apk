package com.tencent.mobileqq.app;

import java.io.Serializable;

public class HotChatManager$HotChatStateWrapper
  implements Serializable
{
  public static final int ACTION_DELETE_SHELL = 3;
  public static final int ACTION_KEEP_RECENT_USER = 2;
  public static final int ACTION_NO = -1;
  public static final int ACTION_PULL_SHELL = 1;
  public static final HotChatStateWrapper STATE_LEFT_NORMAL = wrap(4, -1);
  public static final HotChatStateWrapper STATE_LEFT_NORMAL__ACTION_DELETE_SHELL = wrap(4, 3);
  public static final HotChatStateWrapper STATE_LEFT__LONG_TIME_NOT_SAY = wrap(1, -1);
  public static final HotChatStateWrapper STATE_LEFT__SWITCH_WIFI;
  public static final HotChatStateWrapper STATE_LEFT__SWITCH_WIFI__ACTION_KEEP_RU;
  public static final HotChatStateWrapper STATE_SWITCH_WIFI_PULL_SHELL = wrap(2, 1);
  public int action = -1;
  public int targetState;
  
  static
  {
    STATE_LEFT__SWITCH_WIFI = wrap(2, -1);
    STATE_LEFT__SWITCH_WIFI__ACTION_KEEP_RU = wrap(2, 2);
  }
  
  public static HotChatStateWrapper wrap(int paramInt)
  {
    HotChatStateWrapper localHotChatStateWrapper = new HotChatStateWrapper();
    localHotChatStateWrapper.targetState = paramInt;
    return localHotChatStateWrapper;
  }
  
  public static HotChatStateWrapper wrap(int paramInt1, int paramInt2)
  {
    HotChatStateWrapper localHotChatStateWrapper = new HotChatStateWrapper();
    localHotChatStateWrapper.targetState = paramInt1;
    localHotChatStateWrapper.action = paramInt2;
    return localHotChatStateWrapper;
  }
  
  public boolean hasAction()
  {
    return this.action != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper
 * JD-Core Version:    0.7.0.1
 */