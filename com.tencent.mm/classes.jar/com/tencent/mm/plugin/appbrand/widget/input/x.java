package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public abstract class x
  extends i
{
  final void a(y paramy)
  {
    if (paramy == null)
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramy.getInputId();
    paramy.b(this.jle);
    if (this.jlj == null) {}
    for (paramy = null; paramy == null; paramy = (v)this.jlj.get())
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramy = paramy.ixm;
    if (paramy == null)
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    ab.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramy.pf(i)) });
  }
  
  final boolean a(y paramy, e parame)
  {
    if (paramy == null)
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.jkB;
    if (this.jlj != null)
    {
      localObject = (v)this.jlj.get();
      if (localObject != null) {}
    }
    else
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((v)localObject).ixm;
    if (localObject == null)
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    int i;
    int k;
    float f1;
    float f2;
    float f3;
    float f4;
    if ((parame.jqX != null) && (parame.jqX.booleanValue()))
    {
      i = 4;
      k = parame.jqB;
      f1 = parame.jqL.intValue();
      f2 = parame.jqK.intValue();
      f3 = parame.jqI.intValue();
      f4 = parame.jqJ.intValue();
      if ((parame.jrb == null) || (!parame.jrb.booleanValue())) {
        break label261;
      }
    }
    label261:
    for (boolean bool = true;; bool = false)
    {
      bool = ((af)localObject).a(paramy, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool, false);
      ab.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
      i = 0;
      break;
    }
  }
  
  final boolean b(y paramy, e parame)
  {
    if (paramy == null)
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramy.getInputId();
    if (this.jlj != null)
    {
      paramy = (v)this.jlj.get();
      if (paramy != null) {}
    }
    else
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramy = paramy.ixm;
    if (paramy == null)
    {
      ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.jqX != null) && (parame.jqX.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.jqL.intValue();
      float f2 = parame.jqK.intValue();
      float f3 = parame.jqI.intValue();
      float f4 = parame.jqJ.intValue();
      parame = parame.jrb;
      Boolean localBoolean = Boolean.FALSE;
      boolean bool = paramy.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame, localBoolean);
      ab.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */