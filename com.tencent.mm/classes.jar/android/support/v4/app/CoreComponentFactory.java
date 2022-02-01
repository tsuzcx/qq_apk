package android.support.v4.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class CoreComponentFactory
  extends AppComponentFactory
{
  private static <T> T l(T paramT)
  {
    Object localObject1 = paramT;
    if ((paramT instanceof a))
    {
      Object localObject2 = ((a)paramT).ei();
      localObject1 = paramT;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public Activity instantiateActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return (Activity)l(super.instantiateActivity(paramClassLoader, paramString, paramIntent));
  }
  
  public Application instantiateApplication(ClassLoader paramClassLoader, String paramString)
  {
    return (Application)l(super.instantiateApplication(paramClassLoader, paramString));
  }
  
  public ContentProvider instantiateProvider(ClassLoader paramClassLoader, String paramString)
  {
    return (ContentProvider)l(super.instantiateProvider(paramClassLoader, paramString));
  }
  
  public BroadcastReceiver instantiateReceiver(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return (BroadcastReceiver)l(super.instantiateReceiver(paramClassLoader, paramString, paramIntent));
  }
  
  public Service instantiateService(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return (Service)l(super.instantiateService(paramClassLoader, paramString, paramIntent));
  }
  
  public static abstract interface a
  {
    public abstract Object ei();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.CoreComponentFactory
 * JD-Core Version:    0.7.0.1
 */