package android.support.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Map;

final class CustomTabsService$1
  extends e.a
{
  CustomTabsService$1(CustomTabsService paramCustomTabsService) {}
  
  public final boolean a(d paramd)
  {
    ??? = new c(paramd);
    try
    {
      CustomTabsService.1.1 local1 = new CustomTabsService.1.1(this, (c)???);
      synchronized (CustomTabsService.a(this.dG))
      {
        paramd.asBinder().linkToDeath(local1, 0);
        CustomTabsService.a(this.dG).put(paramd.asBinder(), local1);
        boolean bool = this.dG.aw();
        return bool;
      }
      return false;
    }
    catch (RemoteException paramd) {}
  }
  
  public final boolean av()
  {
    return this.dG.av();
  }
  
  public final Bundle ay()
  {
    return this.dG.ay();
  }
  
  public final boolean b(d paramd)
  {
    CustomTabsService localCustomTabsService = this.dG;
    new c(paramd);
    return localCustomTabsService.ax();
  }
  
  public final boolean c(d paramd)
  {
    CustomTabsService localCustomTabsService = this.dG;
    new c(paramd);
    return localCustomTabsService.az();
  }
  
  public final boolean d(d paramd)
  {
    CustomTabsService localCustomTabsService = this.dG;
    new c(paramd);
    return localCustomTabsService.aA();
  }
  
  public final int e(d paramd)
  {
    CustomTabsService localCustomTabsService = this.dG;
    new c(paramd);
    return localCustomTabsService.aB();
  }
  
  public final boolean f(d paramd)
  {
    CustomTabsService localCustomTabsService = this.dG;
    new c(paramd);
    return localCustomTabsService.aC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService.1
 * JD-Core Version:    0.7.0.1
 */