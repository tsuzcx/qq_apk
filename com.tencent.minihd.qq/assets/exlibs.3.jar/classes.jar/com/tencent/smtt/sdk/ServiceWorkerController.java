package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

public abstract class ServiceWorkerController
{
  public static ServiceWorkerController getInstance(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = x.a();
    ((x)localObject2).a(paramContext);
    if (((x)localObject2).b())
    {
      localObject2 = x.a().c().q();
      paramContext = localObject1;
      if (localObject2 != null) {
        paramContext = new ServiceWorkerController()
        {
          public ServiceWorkerWebSettings getServiceWorkerWebSettings()
          {
            return this.a.getServiceWorkerWebSettings();
          }
          
          public void setServiceWorkerClient(ServiceWorkerClient paramAnonymousServiceWorkerClient)
          {
            this.a.setServiceWorkerClient(paramAnonymousServiceWorkerClient);
          }
        };
      }
    }
    do
    {
      return paramContext;
      paramContext = localObject1;
    } while (Build.VERSION.SDK_INT < 24);
    return new l();
  }
  
  public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();
  
  public abstract void setServiceWorkerClient(ServiceWorkerClient paramServiceWorkerClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ServiceWorkerController
 * JD-Core Version:    0.7.0.1
 */