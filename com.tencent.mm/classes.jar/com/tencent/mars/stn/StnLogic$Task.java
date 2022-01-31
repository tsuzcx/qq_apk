package com.tencent.mars.stn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StnLogic$Task
{
  public static final int EBoth = 3;
  public static final int EFAST = 1;
  public static final int ELong = 2;
  public static final int ENORMAL = 0;
  public static final int EShort = 1;
  public static final int ETASK_PRIORITY_0 = 0;
  public static final int ETASK_PRIORITY_1 = 1;
  public static final int ETASK_PRIORITY_2 = 2;
  public static final int ETASK_PRIORITY_3 = 3;
  public static final int ETASK_PRIORITY_4 = 4;
  public static final int ETASK_PRIORITY_5 = 5;
  public static final int ETASK_PRIORITY_HIGHEST = 0;
  public static final int ETASK_PRIORITY_LOWEST = 5;
  public static final int ETASK_PRIORITY_NORMAL = 3;
  private static AtomicInteger ai = new AtomicInteger(0);
  public String cgi;
  public int channelSelect;
  public int channelStrategy;
  public int cmdID;
  public Map<String, String> headers;
  public boolean limitFlow;
  public boolean limitFrequency;
  public boolean needAuthed;
  public boolean networkStatusSensitive;
  public int priority;
  public String reportArg;
  public int retryCount = -1;
  public boolean sendOnly;
  public int serverProcessCost;
  public ArrayList<String> shortLinkHostList;
  public int taskID = ai.incrementAndGet();
  public int totalTimeout;
  public Object userContext;
  
  public StnLogic$Task()
  {
    this.headers = new HashMap();
  }
  
  public StnLogic$Task(int paramInt1, int paramInt2, String paramString, ArrayList<String> paramArrayList)
  {
    this.channelSelect = paramInt1;
    this.cmdID = paramInt2;
    this.cgi = paramString;
    this.shortLinkHostList = paramArrayList;
    this.sendOnly = false;
    this.needAuthed = true;
    this.limitFlow = true;
    this.limitFrequency = true;
    this.channelStrategy = 0;
    this.networkStatusSensitive = false;
    this.priority = 3;
    this.retryCount = -1;
    this.serverProcessCost = 0;
    this.totalTimeout = 0;
    this.userContext = null;
    this.headers = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mars.stn.StnLogic.Task
 * JD-Core Version:    0.7.0.1
 */