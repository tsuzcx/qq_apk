package com.tencent.mm.kernel.b;

import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import java.util.HashSet;
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
    Object localObject = h.RP().RH();
    Class localClass = getClass();
    if (!((com.tencent.mm.kernel.c)localObject).eHF.aw(localClass))
    {
      localObject = h.RP().RH().eHI;
      if (localObject != null)
      {
        dependsOn((Class)localObject);
        j.i("MMKernel.Plugin", "plugin[%s] not specific any depOn, we using default one [%s]", new Object[] { this, localObject });
      }
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
    h.RP().RH().d(getClass(), paramClass);
  }
  
  public void configure(g paramg) {}
  
  public void dependency() {}
  
  protected void dependsOn(Class<? extends a> paramClass)
  {
    if (!this.mMakingDependencies)
    {
      j.w("MMKernel.Plugin", "Ignore this dependency. It's not dependency phase now!", new Object[0]);
      return;
    }
    h.RP().RH().e(getClass(), paramClass);
  }
  
  protected void dependsOnRoot()
  {
    if (!this.mMakingDependencies)
    {
      j.w("MMKernel.Plugin", "Ignore this dependency. It's not dependency phase now!", new Object[0]);
      return;
    }
    h.RP().RH().e(getClass(), getClass());
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
        h.RP().RH().a(paramc.getClass(), new e(paramc));
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
        h.RP().RH().F(paramc.getClass());
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