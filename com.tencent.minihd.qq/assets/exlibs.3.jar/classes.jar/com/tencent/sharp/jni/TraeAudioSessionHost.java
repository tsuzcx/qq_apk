package com.tencent.sharp.jni;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList<SessionInfo> _sessionInfoList = new ArrayList();
  private ReentrantLock mLock = new ReentrantLock();
  
  public void add(long paramLong, Context paramContext)
  {
    if (find(paramLong) != null) {
      return;
    }
    paramContext = new SessionInfo();
    paramContext.sessionId = paramLong;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
  }
  
  public SessionInfo find(long paramLong)
  {
    Object localObject2 = null;
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < this._sessionInfoList.size())
      {
        localObject1 = (SessionInfo)this._sessionInfoList.get(i);
        if (((SessionInfo)localObject1).sessionId != paramLong) {}
      }
      else
      {
        this.mLock.unlock();
        return localObject1;
      }
      i += 1;
    }
  }
  
  public void remove(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((SessionInfo)this._sessionInfoList.get(i)).sessionId == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        return;
      }
      i += 1;
    }
  }
  
  public class SessionInfo
  {
    public long sessionId;
    
    public SessionInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioSessionHost
 * JD-Core Version:    0.7.0.1
 */