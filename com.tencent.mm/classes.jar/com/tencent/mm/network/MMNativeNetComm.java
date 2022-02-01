package com.tencent.mm.network;

public class MMNativeNetComm
{
  static final int CONNECTED = 5;
  static final int CONNECTTING = 4;
  static final int ECmdNormal = 0;
  static final int ECmdUser = 1;
  static final int EEXPECT_SENSITIVE = 1;
  static final int EFAST = 1;
  static final int ENORMAL = 0;
  static final int ETASK_PRIORITY_0 = 0;
  static final int ETASK_PRIORITY_1 = 1;
  static final int ETASK_PRIORITY_2 = 2;
  static final int ETASK_PRIORITY_3 = 3;
  static final int ETASK_PRIORITY_4 = 4;
  static final int ETASK_PRIORITY_5 = 5;
  static final int ETASK_PRIORITY_HIGHEST = 0;
  static final int ETASK_PRIORITY_LOWEST = 5;
  static final int ETASK_PRIORITY_NORMAL = 3;
  static final int GATEWAY_FAILED = 2;
  static final int NETWORK_CONNECTED = 1;
  static final int NETWORK_UNAVAILABLE = 0;
  static final int SERVER_DOWN = 6;
  static final int SERVER_FAILED = 3;
  static final int TYPE_DNS = 2;
  static final int TYPE_HC = 1;
  static final int TYPE_SVR_DNS = 3;
  static final int TYPE_WAP_HC = 4;
  static final int ectDial = 2;
  static final int ectDns = 3;
  static final int ectEnDecode = 7;
  static final int ectFalse = 1;
  static final int ectHttp = 5;
  static final int ectHttp_TaskTimeout = -500;
  static final int ectLocal = 9;
  static final int ectLocal_AntiAvalanche = -4;
  static final int ectLocal_StartTaskFail = -3;
  static final int ectLocal_TaskRetry = -2;
  static final int ectLocal_TaskTimeout = -1;
  static final int ectNetMsgXP = 6;
  static final int ectNetMsgXP_TaskTimeout = -500;
  static final int ectOK = 0;
  static final int ectServer = 8;
  static final int ectSocket = 4;
  
  static class AccountInfo
  {
    public int uin;
    public String username;
  }
  
  static class NetCmd
  {
    public static final int EBoth = 3;
    public static final int ELong = 2;
    public static final int EShort = 1;
    int cmduser_expectfinishtime = -1;
    int cmduser_expecttos = -1;
    int cmduser_firstpkgtimeout = -1;
    int cmduser_priority = 3;
    int cmduser_retrycount = -1;
    public boolean isFlowLimit;
    public boolean isNotResp;
    public boolean isSessionCmd;
    public int netStrategy;
    public int networkType;
    public int reqCmdID;
    public int respCmdID;
    public int rtType;
    public String uri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.MMNativeNetComm
 * JD-Core Version:    0.7.0.1
 */