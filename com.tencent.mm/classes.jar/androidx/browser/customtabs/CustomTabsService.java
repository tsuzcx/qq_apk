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
  final Map<IBinder, IBinder.DeathRecipient> yv = new androidx.b.a();
  private b.a yw = new b.a()
  {
    public final boolean R()
    {
      AppMethodBeat.i(191299);
      boolean bool = CustomTabsService.this.R();
      AppMethodBeat.o(191299);
      return bool;
    }
    
    public final Bundle S()
    {
      AppMethodBeat.i(191309);
      Bundle localBundle = CustomTabsService.this.S();
      AppMethodBeat.o(191309);
      return localBundle;
    }
    
    public final boolean a(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(191305);
      ??? = new c(paramAnonymousa);
      try
      {
        IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            AppMethodBeat.i(191294);
            CustomTabsService.this.a(this.yy);
            AppMethodBeat.o(191294);
          }
        };
        synchronized (CustomTabsService.this.yv)
        {
          paramAnonymousa.asBinder().linkToDeath(local1, 0);
          CustomTabsService.this.yv.put(paramAnonymousa.asBinder(), local1);
          boolean bool = CustomTabsService.this.eO();
          AppMethodBeat.o(191305);
          return bool;
        }
        return false;
      }
      catch (RemoteException paramAnonymousa)
      {
        AppMethodBeat.o(191305);
      }
    }
    
    public final boolean b(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(191307);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.eP();
      AppMethodBeat.o(191307);
      return bool;
    }
    
    public final boolean c(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(191311);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.eQ();
      AppMethodBeat.o(191311);
      return bool;
    }
    
    public final boolean d(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(191314);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.eR();
      AppMethodBeat.o(191314);
      return bool;
    }
    
    public final int e(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(191316);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      int i = localCustomTabsService.eS();
      AppMethodBeat.o(191316);
      return i;
    }
    
    public final boolean f(android.support.a.a paramAnonymousa)
    {
      AppMethodBeat.i(191318);
      CustomTabsService localCustomTabsService = CustomTabsService.this;
      new c(paramAnonymousa);
      boolean bool = localCustomTabsService.eT();
      AppMethodBeat.o(191318);
      return bool;
    }
  };
  
  protected abstract boolean R();
  
  protected abstract Bundle S();
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.yv)
      {
        paramc = paramc.eU();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.yv.get(paramc), 0);
        this.yv.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean eO();
  
  protected abstract boolean eP();
  
  protected abstract boolean eQ();
  
  protected abstract boolean eR();
  
  protected abstract int eS();
  
  protected abstract boolean eT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.browser.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */