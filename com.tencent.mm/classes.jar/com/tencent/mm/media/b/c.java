package com.tencent.mm.media.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getConfigByStatus", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T>
{
  protected T kSg;
  
  protected final T aTX()
  {
    Object localObject = this.kSg;
    if (localObject == null) {
      p.bGy("elementConfig");
    }
    return localObject;
  }
  
  public abstract T aTY();
  
  public abstract void aTZ();
  
  public void aUa() {}
  
  public final T aUb()
  {
    this.kSg = aTY();
    aTZ();
    Object localObject = this.kSg;
    if (localObject == null) {
      p.bGy("elementConfig");
    }
    return localObject;
  }
  
  public final T aUc()
  {
    this.kSg = aTY();
    aUa();
    Object localObject = this.kSg;
    if (localObject == null) {
      p.bGy("elementConfig");
    }
    return localObject;
  }
  
  protected int at(String paramString, int paramInt)
  {
    p.k(paramString, "key");
    if (MMApplicationContext.isMMProcess())
    {
      com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.zero.b.a.class);
      p.j(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return Util.getInt(((com.tencent.mm.plugin.zero.b.a)locala).axc().getValue(paramString), paramInt);
    }
    return Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final void bS(T paramT)
  {
    p.k(paramT, "<set-?>");
    this.kSg = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */