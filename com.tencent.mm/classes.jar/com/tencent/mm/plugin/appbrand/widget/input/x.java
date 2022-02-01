package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am;
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
    paramy.b(this.sZW);
    if (this.tab == null) {}
    for (paramy = null; paramy == null; paramy = (aa)this.tab.get())
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramy = paramy.mbW;
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    ad.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramy.sG(i)) });
  }
  
  final boolean a(y paramy, e parame)
  {
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.ncO;
    if (this.tab != null)
    {
      localObject = (aa)this.tab.get();
      if (localObject != null) {}
    }
    else
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((aa)localObject).mbW;
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
    if ((parame.njl != null) && (parame.njl.booleanValue()))
    {
      i = 4;
      k = parame.niR;
      f1 = parame.niZ.intValue();
      f2 = parame.niY.intValue();
      f3 = parame.niW.intValue();
      f4 = parame.niX.intValue();
      if ((parame.njp == null) || (!parame.njp.booleanValue())) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      bool = ((am)localObject).a(paramy, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool);
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
    if (this.tab != null)
    {
      paramy = (aa)this.tab.get();
      if (paramy != null) {}
    }
    else
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramy = paramy.mbW;
    if (paramy == null)
    {
      ad.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.njl != null) && (parame.njl.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.niZ.intValue();
      float f2 = parame.niY.intValue();
      float f3 = parame.niW.intValue();
      float f4 = parame.niX.intValue();
      parame = parame.njp;
      Boolean localBoolean = Boolean.FALSE;
      boolean bool = paramy.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame, localBoolean);
      ad.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */