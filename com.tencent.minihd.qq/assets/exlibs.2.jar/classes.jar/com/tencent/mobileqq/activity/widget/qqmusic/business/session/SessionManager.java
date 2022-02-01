package com.tencent.mobileqq.activity.widget.qqmusic.business.session;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.network.Network;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.SessionRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.task.TaskBlockManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import hdb;
import java.util.concurrent.atomic.AtomicBoolean;

public class SessionManager
{
  public static final int a = -1;
  private static SessionManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessSessionSessionManager;
  private static final String jdField_a_of_type_JavaLangString = "SessionManager";
  public static boolean a = false;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
  private final Session jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataSession = new Session();
  private OnResultListener jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener = new hdb(this);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean b = false;
  private boolean c = false;
  private int f = 2;
  private int g = 0;
  private int h = -1;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static SessionManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessSessionSessionManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessSessionSessionManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessSessionSessionManager = new SessionManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessSessionSessionManager;
    }
    finally {}
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return false;
        this.jdField_a_of_type_Long = MusicUtil.a();
      } while ((!this.c) && (this.f != 1));
      return true;
    case 1: 
      long l = MusicUtil.a();
      if (this.jdField_a_of_type_Long == l) {
        return true;
      }
      this.jdField_a_of_type_Long = l;
      return false;
    }
    if ((!ProgramState.c) && (!this.c))
    {
      this.c = true;
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.f = 2;
        int i = this.f;
        paramBoolean = bool;
        switch (i)
        {
        default: 
          paramBoolean = bool;
        case 4: 
          return paramBoolean;
        }
      }
      finally {}
      MLog.a("SessionManager", "caller is " + paramInt);
      b(paramInt);
      paramBoolean = bool;
      continue;
      this.g += 1;
      paramBoolean = bool;
      continue;
      paramBoolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) && (this.f != 1))
    {
      this.f = 3;
      Network.b(new SessionRequest(), this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkListenerOnResultListener);
      TaskBlockManager.a().a();
      return;
    }
    MLog.d("SessionManager", "mSession request already send.");
  }
  
  public Session a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataSession;
  }
  
  public void a()
  {
    MLog.a("SessionManager", "mSessionState is " + this.f + " and meetLoadingTimes = " + this.g);
    if ((this.f == 4) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.g = 0;
      this.f = 2;
    }
  }
  
  public void a(int paramInt)
  {
    if (a(paramInt)) {
      return;
    }
    if (this.f != 3)
    {
      a(paramInt, true);
      return;
    }
    this.h = paramInt;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null)) {}
    try
    {
      if (paramString.equals("FORBIDDEN"))
      {
        jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataSession.b(paramString);
        this.b = paramBoolean;
        return;
      }
      if (paramBoolean)
      {
        jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataSession.b(paramString);
        this.b = paramBoolean;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataSession.b(paramString);
      return;
      if ((!this.b) && (paramString != null) && (paramString.equals("FORBIDDEN"))) {
        jdField_a_of_type_Boolean = true;
      } else if (!this.b) {
        jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public boolean a()
  {
    a();
    return a(3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager
 * JD-Core Version:    0.7.0.1
 */