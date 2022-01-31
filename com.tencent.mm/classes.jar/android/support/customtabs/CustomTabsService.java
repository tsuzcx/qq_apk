package android.support.customtabs;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.support.v4.e.a;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService
  extends Service
{
  private final Map<IBinder, IBinder.DeathRecipient> dE = new a();
  private e.a dF = new CustomTabsService.1(this);
  
  protected final boolean a(c paramc)
  {
    try
    {
      synchronized (this.dE)
      {
        paramc = paramc.aD();
        paramc.unlinkToDeath((IBinder.DeathRecipient)this.dE.get(paramc), 0);
        this.dE.remove(paramc);
        return true;
      }
      return false;
    }
    catch (NoSuchElementException paramc) {}
  }
  
  protected abstract boolean aA();
  
  protected abstract int aB();
  
  protected abstract boolean aC();
  
  protected abstract boolean av();
  
  protected abstract boolean aw();
  
  protected abstract boolean ax();
  
  protected abstract Bundle ay();
  
  protected abstract boolean az();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * JD-Core Version:    0.7.0.1
 */