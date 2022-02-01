package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import mqq.manager.Manager;

public class RecentManagerFor3rdPart
  implements Manager
{
  private QQAppInterface a;
  
  public RecentManagerFor3rdPart(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new NullPointerException("RecentManagerFor3rdPart, app is null");
    }
    this.a = paramQQAppInterface;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.e())
      {
        bool1 = bool2;
        if (this.a.a().a().b(paramString, paramInt) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.e())
      {
        RecentUserProxy localRecentUserProxy = this.a.a().a();
        paramString = localRecentUserProxy.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          paramString.lastmsgtime = paramLong;
          localRecentUserProxy.a(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.e())
      {
        RecentUserProxy localRecentUserProxy = this.a.a().a();
        paramString = localRecentUserProxy.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          paramString.lastmsgtime = paramLong1;
          paramString.lastmsgdrafttime = paramLong2;
          localRecentUserProxy.a(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if ((this.a != null) && (this.a.e()))
    {
      RecentUserProxy localRecentUserProxy = this.a.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(paramString1, paramInt);
      localRecentUser.uin = paramString1;
      localRecentUser.type = paramInt;
      localRecentUser.displayName = paramString2;
      localRecentUser.lastmsgtime = paramLong1;
      localRecentUser.lastmsgdrafttime = paramLong2;
      localRecentUserProxy.a(localRecentUser);
    }
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if ((this.a != null) && (this.a.e()))
    {
      RecentUserProxy localRecentUserProxy = this.a.a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(paramString1, paramInt);
      localRecentUser.uin = paramString1;
      localRecentUser.type = paramInt;
      localRecentUser.troopUin = paramString2;
      localRecentUser.displayName = paramString3;
      localRecentUser.lastmsgtime = paramLong1;
      localRecentUser.lastmsgdrafttime = paramLong2;
      localRecentUserProxy.a(localRecentUser);
    }
    return true;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.e())
      {
        RecentUserProxy localRecentUserProxy = this.a.a().a();
        paramString = localRecentUserProxy.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          localRecentUserProxy.b(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RecentManagerFor3rdPart
 * JD-Core Version:    0.7.0.1
 */