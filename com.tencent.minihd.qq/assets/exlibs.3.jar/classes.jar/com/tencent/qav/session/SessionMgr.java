package com.tencent.qav.session;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class SessionMgr
{
  private static final String TAG = "AvSessionMgr";
  private static volatile SessionMgr sSessionMgr = null;
  private SessionInfo mActiveSession;
  private Map<String, SessionInfo> mSessionList = new HashMap();
  
  public static SessionMgr getInstanse()
  {
    if (sSessionMgr == null) {}
    try
    {
      if (sSessionMgr == null) {
        sSessionMgr = new SessionMgr();
      }
      return sSessionMgr;
    }
    finally {}
  }
  
  public void clearSession()
  {
    if (this.mSessionList != null) {
      this.mSessionList.clear();
    }
  }
  
  public SessionInfo createSession(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.mSessionList.get(paramString) != null) {
      return (SessionInfo)this.mSessionList.get(paramString);
    }
    SessionInfo localSessionInfo = new SessionInfo();
    this.mActiveSession = localSessionInfo;
    this.mSessionList.put(paramString, localSessionInfo);
    localSessionInfo.mSessionId = paramString;
    return localSessionInfo;
  }
  
  public SessionInfo getMainSession()
  {
    return this.mActiveSession;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.session.SessionMgr
 * JD-Core Version:    0.7.0.1
 */