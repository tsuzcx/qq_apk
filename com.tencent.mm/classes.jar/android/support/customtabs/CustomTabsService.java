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
  private final Map<IBinder, IBinder.DeathRecipient> eF = new a();
  private e.a eG = new e.a()
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
            CustomTabsService.this.a(this.eI);
          }
        };
        synchronized (CustomTabsService.a(CustomTabsService.this))
        {
          paramAnonymousd.asBinder().linkToDeath(local1, 0);
          CustomTabsService.a(CustomTabsService.this).put(paramAnonymousd.asBinder(), local1);
          boolean bool = CustomTabsService.this.at();
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousd) {}
    }
    
    public final boolean as()
    {
      return CustomTabsService.this.as();
    }
    
    public final Bundle av()
    {
      return CustomTabsService.this.av();
    }
    
    public final boolean b(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.au();
    }
    
    public final boolean c(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aw();
    }
    
    public final boolean d(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.ax();
    }
    
    public final int e(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.ay();
    }
    
    public final boolean f(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.az();
    }
  };
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.eF)
      {
        paramc = paramc.aA();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.eF.get(paramc), 0);
        this.eF.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean as();
  
  protected abstract boolean at();
  
  protected abstract boolean au();
  
  protected abstract Bundle av();
  
  protected abstract boolean aw();
  
  protected abstract boolean ax();
  
  protected abstract int ay();
  
  protected abstract boolean az();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */