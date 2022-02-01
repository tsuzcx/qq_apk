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
  private final Map<IBinder, IBinder.DeathRecipient> gA = new a();
  private e.a gB = new e.a()
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
            CustomTabsService.this.a(this.gD);
          }
        };
        synchronized (CustomTabsService.a(CustomTabsService.this))
        {
          paramAnonymousd.asBinder().linkToDeath(local1, 0);
          CustomTabsService.a(CustomTabsService.this).put(paramAnonymousd.asBinder(), local1);
          boolean bool = CustomTabsService.this.aL();
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousd) {}
    }
    
    public final boolean aK()
    {
      return CustomTabsService.this.aK();
    }
    
    public final Bundle aN()
    {
      return CustomTabsService.this.aN();
    }
    
    public final boolean b(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aM();
    }
    
    public final boolean c(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aO();
    }
    
    public final boolean d(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aP();
    }
    
    public final int e(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aQ();
    }
    
    public final boolean f(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aR();
    }
  };
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.gA)
      {
        paramc = paramc.aS();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.gA.get(paramc), 0);
        this.gA.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean aK();
  
  protected abstract boolean aL();
  
  protected abstract boolean aM();
  
  protected abstract Bundle aN();
  
  protected abstract boolean aO();
  
  protected abstract boolean aP();
  
  protected abstract int aQ();
  
  protected abstract boolean aR();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */