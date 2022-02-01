package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public abstract class x
  extends i
{
  final void a(y paramy)
  {
    if (paramy == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramy.getInputId();
    paramy.b(this.OrS);
    if (this.OrX == null) {}
    for (paramy = null; paramy == null; paramy = (ac)this.OrX.get())
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramy = paramy.nqN;
    if (paramy == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramy.wF(i)) });
  }
  
  final boolean a(y paramy, e parame)
  {
    if (paramy == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.orE;
    if (this.OrX != null)
    {
      localObject = (ac)this.OrX.get();
      if (localObject != null) {}
    }
    else
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((ac)localObject).nqN;
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
    if ((parame.oxZ != null) && (parame.oxZ.booleanValue()))
    {
      i = 4;
      k = parame.oxF;
      f1 = parame.oxN.intValue();
      f2 = parame.oxM.intValue();
      f3 = parame.oxK.intValue();
      f4 = parame.oxL.intValue();
      if ((parame.oyd == null) || (!parame.oyd.booleanValue())) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      bool = ((ao)localObject).a(paramy, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool);
      Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
      i = 0;
      break;
    }
  }
  
  final boolean b(y paramy, e parame)
  {
    if (paramy == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramy.getInputId();
    if (this.OrX != null)
    {
      paramy = (ac)this.OrX.get();
      if (paramy != null) {}
    }
    else
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramy = paramy.nqN;
    if (paramy == null)
    {
      Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.oxZ != null) && (parame.oxZ.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.oxN.intValue();
      float f2 = parame.oxM.intValue();
      float f3 = parame.oxK.intValue();
      float f4 = parame.oxL.intValue();
      parame = parame.oyd;
      Boolean localBoolean = Boolean.FALSE;
      boolean bool = paramy.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame, localBoolean);
      Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */