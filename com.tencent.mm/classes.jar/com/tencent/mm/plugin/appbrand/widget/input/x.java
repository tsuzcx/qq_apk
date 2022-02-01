package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public abstract class x
  extends i
{
  final void a(y paramy)
  {
    if (paramy == null)
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramy.getInputId();
    paramy.b(this.mCS);
    if (this.mCY == null) {}
    for (paramy = null; paramy == null; paramy = (aa)this.mCY.get())
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramy = paramy.lCv;
    if (paramy == null)
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    ac.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramy.se(i)) });
  }
  
  final boolean a(y paramy, e parame)
  {
    if (paramy == null)
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.mCo;
    if (this.mCY != null)
    {
      localObject = (aa)this.mCY.get();
      if (localObject != null) {}
    }
    else
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((aa)localObject).lCv;
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    int i;
    int k;
    float f1;
    float f2;
    float f3;
    float f4;
    if ((parame.mIP != null) && (parame.mIP.booleanValue()))
    {
      i = 4;
      k = parame.mIu;
      f1 = parame.mIC.intValue();
      f2 = parame.mIB.intValue();
      f3 = parame.mIz.intValue();
      f4 = parame.mIA.intValue();
      if ((parame.mIT == null) || (!parame.mIT.booleanValue())) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      bool = ((am)localObject).a(paramy, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool);
      ac.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
      i = 0;
      break;
    }
  }
  
  final boolean b(y paramy, e parame)
  {
    if (paramy == null)
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramy.getInputId();
    if (this.mCY != null)
    {
      paramy = (aa)this.mCY.get();
      if (paramy != null) {}
    }
    else
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramy = paramy.lCv;
    if (paramy == null)
    {
      ac.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.mIP != null) && (parame.mIP.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.mIC.intValue();
      float f2 = parame.mIB.intValue();
      float f3 = parame.mIz.intValue();
      float f4 = parame.mIA.intValue();
      parame = parame.mIT;
      Boolean localBoolean = Boolean.FALSE;
      boolean bool = paramy.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame, localBoolean);
      ac.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.x
 * JD-Core Version:    0.7.0.1
 */