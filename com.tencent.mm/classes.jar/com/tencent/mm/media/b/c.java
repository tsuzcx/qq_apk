package com.tencent.mm.media.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T>
{
  protected T hkD;
  
  protected int Z(String paramString, int paramInt)
  {
    p.h(paramString, "key");
    if (ak.cpe())
    {
      com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
      p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return bu.getInt(((com.tencent.mm.plugin.zero.b.a)locala).acL().getValue(paramString), paramInt);
    }
    return bu.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final T atq()
  {
    Object localObject = this.hkD;
    if (localObject == null) {
      p.bdF("elementConfig");
    }
    return localObject;
  }
  
  public abstract T atr();
  
  public abstract void ats();
  
  public final T att()
  {
    this.hkD = atr();
    ats();
    Object localObject = this.hkD;
    if (localObject == null) {
      p.bdF("elementConfig");
    }
    return localObject;
  }
  
  protected final void bJ(T paramT)
  {
    p.h(paramT, "<set-?>");
    this.hkD = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */