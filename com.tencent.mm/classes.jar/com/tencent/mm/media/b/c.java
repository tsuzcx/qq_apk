package com.tencent.mm.media.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T>
{
  protected T hhP;
  
  protected int Y(String paramString, int paramInt)
  {
    p.h(paramString, "key");
    if (aj.cnC())
    {
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return bt.getInt(((com.tencent.mm.plugin.zero.b.a)locala).acA().getValue(paramString), paramInt);
    }
    return bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final T atb()
  {
    Object localObject = this.hhP;
    if (localObject == null) {
      p.bcb("elementConfig");
    }
    return localObject;
  }
  
  public abstract T atc();
  
  public abstract void atd();
  
  public final T ate()
  {
    this.hhP = atc();
    atd();
    Object localObject = this.hhP;
    if (localObject == null) {
      p.bcb("elementConfig");
    }
    return localObject;
  }
  
  protected final void bJ(T paramT)
  {
    p.h(paramT, "<set-?>");
    this.hhP = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */