package com.tencent.device.file;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessObserver;

public class DeviceFileObserver
  implements BusinessObserver
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  
  public void a(Session paramSession) {}
  
  public void a(Session paramSession, float paramFloat) {}
  
  public void a(Session paramSession, boolean paramBoolean) {}
  
  public void b(Session paramSession) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 100: 
      a((Session)paramObject);
      return;
    case 101: 
      b((Session)paramObject);
      return;
    case 102: 
      paramObject = (Object[])paramObject;
      a((Session)paramObject[0], ((Float)paramObject[1]).floatValue());
      return;
    }
    a((Session)paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileObserver
 * JD-Core Version:    0.7.0.1
 */