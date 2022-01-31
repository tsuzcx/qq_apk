package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import java.lang.ref.WeakReference;

public abstract class w
  extends AppBrandInputInvokeHandler
{
  boolean addInputImpl(x paramx, e parame)
  {
    if (paramx == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
      return false;
    }
    int j = parame.hsX;
    if (this.mPageRef != null)
    {
      localObject = (q)this.mPageRef.get();
      if (localObject != null) {}
    }
    else
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    Object localObject = ((q)localObject).agW();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    int i;
    int k;
    float f1;
    float f2;
    float f3;
    float f4;
    if ((parame.hyN != null) && (parame.hyN.booleanValue()))
    {
      i = 4;
      k = parame.hyr;
      f1 = parame.hyB.intValue();
      f2 = parame.hyA.intValue();
      f3 = parame.hyy.intValue();
      f4 = parame.hyz.intValue();
      if ((parame.hyR == null) || (!parame.hyR.booleanValue())) {
        break label260;
      }
    }
    label260:
    for (boolean bool = true;; bool = false)
    {
      bool = ((com.tencent.mm.plugin.appbrand.page.y)localObject).a(paramx, j, k, new float[] { f1, f2, f3, f4, 0.0F }, i, bool);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
      i = 0;
      break;
    }
  }
  
  void removeInputImpl(x paramx)
  {
    if (paramx == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
      return;
    }
    int i = paramx.getInputId();
    paramx.b(this.mInputFocusChangeListenerImpl);
    if (this.mPageRef == null) {}
    for (paramx = null; paramx == null; paramx = (q)this.mPageRef.get())
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    paramx = paramx.agW();
    if (paramx == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(i) });
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramx.mc(i)) });
  }
  
  boolean updateInputPosition(x paramx, e parame)
  {
    if (paramx == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
      return false;
    }
    int j = paramx.getInputId();
    if (this.mPageRef != null)
    {
      paramx = (q)this.mPageRef.get();
      if (paramx != null) {}
    }
    else
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    paramx = paramx.agW();
    if (paramx == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[] { Integer.valueOf(j) });
      return false;
    }
    if ((parame.hyN != null) && (parame.hyN.booleanValue())) {}
    for (int i = 4;; i = 0)
    {
      float f1 = parame.hyB.intValue();
      float f2 = parame.hyA.intValue();
      float f3 = parame.hyy.intValue();
      float f4 = parame.hyz.intValue();
      parame = parame.hyR;
      boolean bool = paramx.a(j, new float[] { f1, f2, f3, f4, 0.0F }, i, parame);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.w
 * JD-Core Version:    0.7.0.1
 */