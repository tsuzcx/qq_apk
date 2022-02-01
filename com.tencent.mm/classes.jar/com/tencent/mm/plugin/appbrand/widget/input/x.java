package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public abstract class x
  extends i
{
  final void a(y paramy)
  {
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramy.getInputId();
    paramy.b(this.KDJ);
    if (this.KDO == null) {}
    for (paramy = null; paramy == null; paramy = (aa)this.KDO.get())
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramy = paramy.laW;
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    ad.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramy.rr(i)) });
  }
  
  final boolean a(y paramy, e parame)
  {
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.mao;
    if (this.KDO != null)
    {
      localObject = (aa)this.KDO.get();
      if (localObject != null) {}
    }
    else
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((aa)localObject).laW;
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    int i;
    int k;
    float f1;
    float f2;
    float f3;
    float f4;
    if ((parame.mgO != null) && (parame.mgO.booleanValue()))
    {
      i = 4;
      k = parame.mgu;
      f1 = parame.mgC.intValue();
      f2 = parame.mgB.intValue();
      f3 = parame.mgz.intValue();
      f4 = parame.mgA.intValue();
      if ((parame.mgS == null) || (!parame.mgS.booleanValue())) {
        break label262;
      }
    }
    label262:
    for (boolean bool = true;; bool = false)
    {
      bool = ((ar)localObject).a(paramy, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool, false, false);
      ad.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
      i = 0;
      break;
    }
  }
  
  final boolean b(y paramy, e parame)
  {
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramy.getInputId();
    if (this.KDO != null)
    {
      paramy = (aa)this.KDO.get();
      if (paramy != null) {}
    }
    else
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramy = paramy.laW;
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.mgO != null) && (parame.mgO.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.mgC.intValue();
      float f2 = parame.mgB.intValue();
      float f3 = parame.mgz.intValue();
      float f4 = parame.mgA.intValue();
      parame = parame.mgS;
      Boolean localBoolean = Boolean.FALSE;
      boolean bool = paramy.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame, localBoolean);
      ad.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */