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
  private final Map<IBinder, IBinder.DeathRecipient> dF = new a();
  private e.a dG = new e.a()
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
            CustomTabsService.this.a(this.dI);
          }
        };
        synchronized (CustomTabsService.a(CustomTabsService.this))
        {
          paramAnonymousd.asBinder().linkToDeath(local1, 0);
          CustomTabsService.a(CustomTabsService.this).put(paramAnonymousd.asBinder(), local1);
          boolean bool = CustomTabsService.this.am();
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousd) {}
    }
    
    public final boolean af()
    {
      return CustomTabsService.this.af();
    }
    
    public final Bundle ao()
    {
      return CustomTabsService.this.ao();
    }
    
    public final boolean b(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.an();
    }
    
    public final boolean c(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.ap();
    }
    
    public final boolean d(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.aq();
    }
    
    public final int e(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.ar();
    }
    
    public final boolean f(d paramAnonymousd)
    {
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousd);
      return localCustomTabsService.as();
    }
  };
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.dF)
      {
        paramc = paramc.at();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.dF.get(paramc), 0);
        this.dF.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean af();
  
  protected abstract boolean am();
  
  protected abstract boolean an();
  
  protected abstract Bundle ao();
  
  protected abstract boolean ap();
  
  protected abstract boolean aq();
  
  protected abstract int ar();
  
  protected abstract boolean as();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */