package com.tencent.mm.media.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T>
{
  protected T gNT;
  
  protected int U(String paramString, int paramInt)
  {
    k.h(paramString, "key");
    if (ai.ciE())
    {
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      k.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return bs.getInt(((com.tencent.mm.plugin.zero.b.a)locala).ZY().getValue(paramString), paramInt);
    }
    return bs.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final T aqm()
  {
    Object localObject = this.gNT;
    if (localObject == null) {
      k.aVY("elementConfig");
    }
    return localObject;
  }
  
  public abstract T aqn();
  
  public abstract void aqo();
  
  public final T aqp()
  {
    this.gNT = aqn();
    aqo();
    Object localObject = this.gNT;
    if (localObject == null) {
      k.aVY("elementConfig");
    }
    return localObject;
  }
  
  protected final void bH(T paramT)
  {
    k.h(paramT, "<set-?>");
    this.gNT = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */