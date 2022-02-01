package androidx.browser.customtabs;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService
  extends Service
{
  final Map<IBinder, IBinder.DeathRecipient> zq = new androidx.b.a();
  private b.a zr = new b.a()
  {
    public final boolean a(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(192963);
      ??? = new c(paramAnonymousa);
      try
      {
        IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            AppMethodBeat.i(192960);
            CustomTabsService.this.a(this.zu);
            AppMethodBeat.o(192960);
          }
        };
        synchronized (CustomTabsService.this.zq)
        {
          paramAnonymousa.asBinder().linkToDeath(local1, 0);
          CustomTabsService.this.zq.put(paramAnonymousa.asBinder(), local1);
          boolean bool = CustomTabsService.this.fL();
          AppMethodBeat.o(192963);
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousa)
      {
        AppMethodBeat.o(192963);
      }
    }
    
    public final boolean aJ()
    {
      AppMethodBeat.i(192955);
      boolean bool = CustomTabsService.this.aJ();
      AppMethodBeat.o(192955);
      return bool;
    }
    
    public final Bundle aK()
    {
      AppMethodBeat.i(192983);
      Bundle localBundle = CustomTabsService.this.aK();
      AppMethodBeat.o(192983);
      return localBundle;
    }
    
    public final boolean b(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(192974);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.fM();
      AppMethodBeat.o(192974);
      return bool;
    }
    
    public final boolean c(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(192990);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.fN();
      AppMethodBeat.o(192990);
      return bool;
    }
    
    public final boolean d(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(192995);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.fO();
      AppMethodBeat.o(192995);
      return bool;
    }
    
    public final int e(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(193000);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      int i = localCustomTabsService.fP();
      AppMethodBeat.o(193000);
      return i;
    }
    
    public final boolean f(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(193011);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.fQ();
      AppMethodBeat.o(193011);
      return bool;
    }
  };
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.zq)
      {
        paramc = paramc.fR();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.zq.get(paramc), 0);
        this.zq.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean aJ();
  
  protected abstract Bundle aK();
  
  protected abstract boolean fL();
  
  protected abstract boolean fM();
  
  protected abstract boolean fN();
  
  protected abstract boolean fO();
  
  protected abstract int fP();
  
  protected abstract boolean fQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.browser.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */