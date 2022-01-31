package com.tencent.mm.media.b;

import a.f.b.j;
import a.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class b<T>
{
  protected T eRt;
  
  protected int L(String paramString, int paramInt)
  {
    j.q(paramString, "key");
    if (ah.brt())
    {
      com.tencent.mm.kernel.c.a locala = g.E(com.tencent.mm.plugin.zero.b.a.class);
      j.p(locala, "MMKernel.service<IConfig…onfigService::class.java)");
      return bo.getInt(((com.tencent.mm.plugin.zero.b.a)locala).Nq().getValue(paramString), paramInt);
    }
    return bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final T Ut()
  {
    Object localObject = this.eRt;
    if (localObject == null) {
      j.ays("elementConfig");
    }
    return localObject;
  }
  
  public abstract T Uu();
  
  public abstract void Uv();
  
  public final T Uw()
  {
    this.eRt = Uu();
    Uv();
    Object localObject = this.eRt;
    if (localObject == null) {
      j.ays("elementConfig");
    }
    return localObject;
  }
  
  protected final void aF(T paramT)
  {
    j.q(paramT, "<set-?>");
    this.eRt = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.b.b
 * JD-Core Version:    0.7.0.1
 */