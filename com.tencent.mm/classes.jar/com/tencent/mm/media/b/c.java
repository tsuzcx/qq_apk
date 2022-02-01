package com.tencent.mm.media.b;

import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getConfigByStatus", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "resetConfig", "update", "parse", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<T>
{
  protected T nxM;
  
  protected int aC(String paramString, int paramInt)
  {
    s.u(paramString, "key");
    if (MMApplicationContext.isMMProcess()) {
      return Util.getInt(((a)h.ax(a.class)).aRC().getValue(paramString), paramInt);
    }
    return Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig(paramString), paramInt);
  }
  
  protected final T boB()
  {
    Object localObject = this.nxM;
    if (localObject != null) {
      return localObject;
    }
    s.bIx("elementConfig");
    return ah.aiuX;
  }
  
  public abstract T boC();
  
  public abstract void boD();
  
  public void boE() {}
  
  public final T boF()
  {
    dm(boC());
    boD();
    return boB();
  }
  
  public final T boG()
  {
    dm(boC());
    boE();
    return boB();
  }
  
  protected final void dm(T paramT)
  {
    s.u(paramT, "<set-?>");
    this.nxM = paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */