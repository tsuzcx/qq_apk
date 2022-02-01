package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;

public class SecSvcObserver
  implements BusinessObserver
{
  public static final String a = "SecSvcObserver";
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString) {}
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    String str;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(paramInt, (Bundle)paramObject);
      return;
    case 2: 
      a(paramInt, (Bundle)paramObject);
      return;
    case 3: 
      int i = 0;
      str = "";
      localObject = str;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        localObject = str;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = paramObject.getInt("status");
          localObject = paramObject.getString("wording");
        }
      }
      a(paramBoolean, paramInt, (String)localObject);
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Bundle)paramObject;
      if (paramObject != null)
      {
        paramInt = paramObject.getInt(AuthDevRenameActivity.i);
        localObject = paramObject.getByteArray(AuthDevRenameActivity.h);
        paramObject = paramObject.getString(AuthDevRenameActivity.f);
      }
    }
    for (;;)
    {
      a(paramBoolean, paramInt, (byte[])localObject, paramObject);
      return;
      paramInt = -1;
      str = null;
      paramObject = localObject;
      localObject = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecSvcObserver
 * JD-Core Version:    0.7.0.1
 */