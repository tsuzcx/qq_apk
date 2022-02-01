package com.tencent.qav.controller.nodereport;

public class NodeReportConst
{
  public static abstract interface BackgroundReason
  {
    public static final String ACTION_SCREEN_OFF = "4";
    public static final String DEFAULT = "0";
    public static final String OTHER = "5";
    public static final String PRESS_BACK_KEY = "2";
    public static final String PRESS_HIDE = "3";
    public static final String PRESS_HOME_KEY = "1";
  }
  
  public static abstract interface InviteUIState
  {
    public static final int INVITE_UI_NOT_START_ACTIVITY = 0;
    public static final int INVITE_UI_START_ACTIVITY = 1;
  }
  
  public static abstract interface LockScreenState
  {
    public static final int SCREEN_OFF = 2;
    public static final int SCREEN_ON = 1;
  }
  
  public static abstract interface ProcessInfoKey
  {
    public static final String AVAIL_MEM = "availMem";
    public static final String AVAIL_MEM2 = "availMem2";
    public static final String AVG_MEMORY = "avgMemory";
    public static final String BACKGROUND_REASON = "backgroundReason";
    public static final String BATTERY_VALUE = "batteryValue";
    public static final String CALL_DUR = "callDur";
    public static final String DEVICE_MEMORY = "deviceMemory";
    public static final String INVITEUI_STATE = "inviteUIState";
    public static final String LOW_MEMORY = "lowMemory";
    public static final String LOW_MEMORY_LEVEL = "lowMemoryLevel";
    public static final String MANU_FACTURER = "manufacturer";
    public static final String MODE = "mode";
    public static final String QQ_VERSION = "qqVersion";
    public static final String SCREEN_STATE = "screenState";
    public static final String STATE = "state";
    public static final String THRESHOLD = "threshold";
  }
  
  public static abstract interface ReportNode
  {
    public static final int RECEIVE_MSF = 3;
    public static final int REQUEST_VIDEO = 2;
    public static final int SHOW_UI = 1;
  }
  
  public static abstract interface State
  {
    public static final String BACKGROUND = "0";
    public static final String FOREGROUND = "1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.controller.nodereport.NodeReportConst
 * JD-Core Version:    0.7.0.1
 */