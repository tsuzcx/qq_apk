package com.tencent.mm.media.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getConfigByStatus", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T>
{
  protected T idA;
  
  protected final T aLQ()
  {
    Object localObject = this.idA;
    if (localObject == null) {
      p.btv("elementConfig");
    }
    return localObject;
  }
  
  public abstract T aLR();
  
  public abstract void aLS();
  
  public final T aLT()
  {
    this.idA = aLR();
    aLS();
    Object localObject = this.idA;
    if (localObject == null) {
      p.btv("elementConfig");
    }
    return localObject;
  }
  
  protected int ab(String paramString, int paramInt)
  {
    p.h(paramString, "key");
    if (MMApplicationContext.isMMProcess())
    {
      com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.zero.b.a.class);
      p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return Util.getInt(((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getValue(paramString), paramInt);
    }
    return Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  public void ajX() {}
  
  public final T ajY()
  {
    this.idA = aLR();
    ajX();
    Object localObject = this.idA;
    if (localObject == null) {
      p.btv("elementConfig");
    }
    return localObject;
  }
  
  protected final void bS(T paramT)
  {
    p.h(paramT, "<set-?>");
    this.idA = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */