package android.support.customtabs;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.e.a;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService
  extends Service
{
  private final Map<IBinder, IBinder.DeathRecipient> gy = new a();
  private e.a gz = new e.a()
  {
    public final boolean a(d paramAnonymousd)
    {
      ??? = new c(paramAnonymousd);
      try
      {
        IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            CustomTabsService.this.a(this.gB);
          }
        };
        synchronized (CustomTabsService.a(CustomTabsService.this))
        {
          paramAnonymousd.asBinder().linkToDeath(local1, 0);
          CustomTabsService.a(CustomTabsService.this).put(paramAnonymousd.asBinder(), local1);
          boolean bool = CustomTabsService.this.aJ();
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousd) {}
    }
    
    public final boolean aI()
    {
      return CustomTabsService.this.aI();
    }
    
    public final Bundle aL()
    {
      return CustomTabsService.this.aL();
    }
    
    public final boolean b(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aK();
    }
    
    public final boolean c(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aM();
    }
    
    public final boolean d(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aN();
    }
    
    public final int e(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aO();
    }
    
    public final boolean f(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aP();
    }
  };
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.gy)
      {
        paramc = paramc.aQ();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.gy.get(paramc), 0);
        this.gy.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean aI();
  
  protected abstract boolean aJ();
  
  protected abstract boolean aK();
  
  protected abstract Bundle aL();
  
  protected abstract boolean aM();
  
  protected abstract boolean aN();
  
  protected abstract int aO();
  
  protected abstract boolean aP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */