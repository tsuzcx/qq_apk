package com.tencent.qav.ipc;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.ObserverDispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ljg;

public class QavCallbackWrapper
  implements IBinder.DeathRecipient
{
  private static final String jdField_a_of_type_JavaLangString = "QavCallbackWrapper";
  private IQavCallback jdField_a_of_type_ComTencentQavIpcIQavCallback;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = true;
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ljg)localIterator.next();
      switch (ljf.a[localObject.jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper$PendingRequestType.ordinal()])
      {
      default: 
        break;
      case 1: 
        localObject = (Object[])((ljg)localObject).jdField_a_of_type_JavaLangObject;
        localObject = a(((Integer)localObject[0]).intValue(), (String)localObject[1]);
        if (localObject != null) {
          a((String)localObject);
        }
        break;
      case 2: 
        localObject = (Object[])((ljg)localObject).jdField_a_of_type_JavaLangObject;
        localObject = a(((Integer)localObject[0]).intValue(), (String)localObject[1]);
        if (localObject != null) {
          a((Bitmap)localObject);
        }
        break;
      case 3: 
        a((QavState)((ljg)localObject).jdField_a_of_type_JavaLangObject);
        break;
      case 4: 
        c((QavState)((ljg)localObject).jdField_a_of_type_JavaLangObject);
      }
    }
  }
  
  private void a(QavCallbackWrapper.PendingRequestType paramPendingRequestType, Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((ljg)((Iterator)localObject).next()).jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper$PendingRequestType == paramPendingRequestType) {
        return;
      }
    }
    localObject = new ljg(this, null);
    ((ljg)localObject).jdField_a_of_type_ComTencentQavIpcQavCallbackWrapper$PendingRequestType = paramPendingRequestType;
    ((ljg)localObject).jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaUtilList.add(localObject);
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null) {
        return this.jdField_a_of_type_ComTencentQavIpcIQavCallback.a(paramInt, paramString);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(QavCallbackWrapper.PendingRequestType.GET_DISPLAY_HEADER, new Object[] { Integer.valueOf(paramInt), paramString });
        return null;
      }
    }
    catch (Exception paramString)
    {
      AVLog.e("QavCallbackWrapper", "getDisplayHeader fail.", paramString);
    }
    return null;
  }
  
  public String a(int paramInt, String paramString)
  {
    String str = String.valueOf(paramString);
    try
    {
      if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null) {
        return this.jdField_a_of_type_ComTencentQavIpcIQavCallback.a(paramInt, paramString);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(QavCallbackWrapper.PendingRequestType.GET_DISPLAY_NAME, new Object[] { Integer.valueOf(paramInt), paramString });
        return str;
      }
    }
    catch (Exception paramString)
    {
      AVLog.e("QavCallbackWrapper", "getDisplayName fail.", paramString);
    }
    return str;
  }
  
  public void a(Bitmap paramBitmap)
  {
    ObserverDispatcher.instance().notifyObservers(QavCallbackObserver.class, 11, new Object[] { paramBitmap });
  }
  
  public void a(IQavCallback paramIQavCallback)
  {
    AVLog.d("QavCallbackWrapper", String.format("setQavCallback callback=%s", new Object[] { paramIQavCallback }));
    if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null) {
      this.jdField_a_of_type_ComTencentQavIpcIQavCallback.asBinder().unlinkToDeath(this, 0);
    }
    this.jdField_a_of_type_ComTencentQavIpcIQavCallback = paramIQavCallback;
    if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQavIpcIQavCallback.asBinder().linkToDeath(this, 0);
      this.jdField_a_of_type_Boolean = false;
      a();
      return;
    }
    catch (Exception paramIQavCallback)
    {
      for (;;)
      {
        AVLog.e("QavCallbackWrapper", "setQavCallback fail.", paramIQavCallback);
      }
    }
  }
  
  public void a(QavMsgRecord paramQavMsgRecord)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null) {
        this.jdField_a_of_type_ComTencentQavIpcIQavCallback.a(paramQavMsgRecord);
      }
      return;
    }
    catch (Exception paramQavMsgRecord)
    {
      AVLog.e("QavCallbackWrapper", "sendC2CVideoRecord fail.", paramQavMsgRecord);
    }
  }
  
  public void a(QavState paramQavState)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null)
      {
        this.jdField_a_of_type_ComTencentQavIpcIQavCallback.a(paramQavState);
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(QavCallbackWrapper.PendingRequestType.NOTIFY_START_VIDEO_CHAT, paramQavState);
        return;
      }
    }
    catch (Exception paramQavState)
    {
      AVLog.e("QavCallbackWrapper", "notifyStartVideoChat fail.", paramQavState);
    }
  }
  
  public void a(String paramString)
  {
    ObserverDispatcher.instance().notifyObservers(QavCallbackObserver.class, 10, new Object[] { paramString });
  }
  
  public void b(QavState paramQavState)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null)
      {
        this.jdField_a_of_type_ComTencentQavIpcIQavCallback.b(paramQavState);
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(QavCallbackWrapper.PendingRequestType.NOTIFY_UPDATE_VIDEO_CHAT, paramQavState);
        return;
      }
    }
    catch (Exception paramQavState)
    {
      AVLog.e("QavCallbackWrapper", "notifyUpdateVideoChat fail.", paramQavState);
    }
  }
  
  public void binderDied()
  {
    AVLog.w("QavCallbackWrapper", "binderDied");
    a(null);
  }
  
  public void c(QavState paramQavState)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentQavIpcIQavCallback != null)
      {
        this.jdField_a_of_type_ComTencentQavIpcIQavCallback.c(paramQavState);
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(QavCallbackWrapper.PendingRequestType.NOTIFY_STOP_VIDEO_CHAT, paramQavState);
        return;
      }
    }
    catch (Exception paramQavState)
    {
      AVLog.e("QavCallbackWrapper", "notifyStopVideoChat fail.", paramQavState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.ipc.QavCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */