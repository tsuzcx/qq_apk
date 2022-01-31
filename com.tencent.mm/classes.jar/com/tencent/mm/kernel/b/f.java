package com.tencent.mm.kernel.b;

import com.tencent.mm.kernel.a.a.a.a;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.k;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public abstract class f
  implements d
{
  private static final String TAG = "MMKernel.Plugin";
  private boolean mConfigured = false;
  private boolean mDependencyMade = false;
  private boolean mInstalled = false;
  private boolean mIsPendingPlugin = false;
  private boolean mMakingDependencies = false;
  private HashSet<c> mPins = new HashSet();
  
  private void checkIfNeedDefaultDependency()
  {
    Object localObject = h.DT().DL();
    Class localClass = getClass();
    localObject = (a.a)((com.tencent.mm.kernel.c)localObject).dKh.dMd.get(localClass);
    if ((localObject != null) && ((((a.a)localObject).Ee()) || (((a.a)localObject).Eg()))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = h.DT().DL().dKk;
        if (localObject != null)
        {
          dependsOn((Class)localObject);
          k.i("MMKernel.Plugin", "plugin[%s] not specific any depOn, we using default one [%s]", new Object[] { this, localObject });
        }
      }
      return;
    }
  }
  
  private final void detectAlias()
  {
    Class[] arrayOfClass = getClass().getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (a.class.isAssignableFrom(localClass)) {
        alias(localClass);
      }
      i += 1;
    }
  }
  
  public void alias(Class<? extends a> paramClass)
  {
    Assert.assertNotNull(paramClass);
    Assert.assertTrue(paramClass.isInstance(this));
    h.DT().DL().c(getClass(), paramClass);
  }
  
  public void configure(g paramg) {}
  
  public void dependency() {}
  
  public void dependsOn(Class<? extends a> paramClass)
  {
    if (!this.mMakingDependencies)
    {
      k.w("MMKernel.Plugin", "Ignore this dependency. It's not dependency phase now!", new Object[0]);
      return;
    }
    h.DT().DL().d(getClass(), paramClass);
  }
  
  public void dependsOnRoot()
  {
    if (!this.mMakingDependencies)
    {
      k.w("MMKernel.Plugin", "Ignore this dependency. It's not dependency phase now!", new Object[0]);
      return;
    }
    h.DT().DL().d(getClass(), getClass());
  }
  
  public int hashCode()
  {
    return name().hashCode();
  }
  
  public String identify()
  {
    return getClass().getSimpleName();
  }
  
  public void installed() {}
  
  public void invokeConfigure(g paramg)
  {
    configure(paramg);
    this.mConfigured = true;
  }
  
  public void invokeDependency()
  {
    this.mMakingDependencies = true;
    dependency();
    checkIfNeedDefaultDependency();
    this.mDependencyMade = true;
    this.mMakingDependencies = false;
  }
  
  public void invokeInstalled()
  {
    this.mInstalled = true;
    installed();
    detectAlias();
  }
  
  public boolean isConfigured()
  {
    return this.mConfigured;
  }
  
  public boolean isDependencyMade()
  {
    return this.mDependencyMade;
  }
  
  public boolean isPendingPlugin()
  {
    return this.mIsPendingPlugin;
  }
  
  public void markAsPendingPlugin()
  {
    this.mIsPendingPlugin = true;
  }
  
  public String name()
  {
    return toString();
  }
  
  public String[] ofProcesses()
  {
    return new String[0];
  }
  
  public void pin(c paramc)
  {
    try
    {
      if (!this.mPins.contains(paramc))
      {
        this.mPins.add(paramc);
        h.DT().DL().a(paramc.getClass(), new e(paramc));
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public String toString()
  {
    return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
  }
  
  public void uninstalled()
  {
    this.mConfigured = false;
    this.mInstalled = false;
  }
  
  public void unpin(c paramc)
  {
    try
    {
      if (this.mPins.contains(paramc))
      {
        this.mPins.remove(paramc);
        h.DT().DL().s(paramc.getClass());
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.f
 * JD-Core Version:    0.7.0.1
 */