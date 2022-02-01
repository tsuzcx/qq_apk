package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public abstract class ab
  extends i
{
  final void a(ac paramac)
  {
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramac.getInputId();
    paramac.b(this.uFH);
    if (this.uFM == null) {}
    for (paramac = null; paramac == null; paramac = (ad)this.uFM.get())
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramac = paramac.txd;
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramac.Am(i)) });
  }
  
  final boolean a(ac paramac, e parame)
  {
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.uES;
    if (this.uFM != null)
    {
      localObject = (ad)this.uFM.get();
      if (localObject != null) {}
    }
    else
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((ad)localObject).txd;
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    int i;
    int k;
    float f1;
    float f2;
    float f3;
    float f4;
    if ((parame.uLO != null) && (parame.uLO.booleanValue()))
    {
      i = 4;
      k = parame.uLu;
      f1 = parame.uLC.intValue();
      f2 = parame.uLB.intValue();
      f3 = parame.uLz.intValue();
      f4 = parame.uLA.intValue();
      if ((parame.uLS == null) || (!parame.uLS.booleanValue())) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      bool = ((ap)localObject).a(paramac, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool);
      Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
      i = 0;
      break;
    }
  }
  
  final boolean b(ac paramac, e parame)
  {
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramac.getInputId();
    if (this.uFM != null)
    {
      paramac = (ad)this.uFM.get();
      if (paramac != null) {}
    }
    else
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramac = paramac.txd;
    if (paramac == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.uLO != null) && (parame.uLO.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.uLC.intValue();
      float f2 = parame.uLB.intValue();
      float f3 = parame.uLz.intValue();
      float f4 = parame.uLA.intValue();
      parame = parame.uLS;
      Boolean localBoolean = Boolean.FALSE;
      boolean bool = paramac.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame, localBoolean);
      Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ab
 * JD-Core Version:    0.7.0.1
 */