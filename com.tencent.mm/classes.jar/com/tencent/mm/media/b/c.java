package com.tencent.mm.media.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T>
{
  protected T gng;
  
  protected int P(String paramString, int paramInt)
  {
    k.h(paramString, "key");
    if (aj.cbv())
    {
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      k.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return bt.getInt(((com.tencent.mm.plugin.zero.b.a)locala).Zd().getValue(paramString), paramInt);
    }
    return bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final T ajm()
  {
    Object localObject = this.gng;
    if (localObject == null) {
      k.aPZ("elementConfig");
    }
    return localObject;
  }
  
  public abstract T ajn();
  
  public abstract void ajo();
  
  public final T ajp()
  {
    this.gng = ajn();
    ajo();
    Object localObject = this.gng;
    if (localObject == null) {
      k.aPZ("elementConfig");
    }
    return localObject;
  }
  
  protected final void bJ(T paramT)
  {
    k.h(paramT, "<set-?>");
    this.gng = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */