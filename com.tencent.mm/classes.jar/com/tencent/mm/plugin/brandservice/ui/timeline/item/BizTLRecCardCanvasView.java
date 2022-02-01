package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.WebCanvasView;
import com.tencent.mm.plugin.webcanvas.a;
import com.tencent.mm.plugin.webcanvas.c;
import com.tencent.mm.plugin.webcanvas.g;
import com.tencent.mm.plugin.webcanvas.h;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasNoneLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "isDoingConfigurationChanged", "", "()Z", "setDoingConfigurationChanged", "(Z)V", "isVideoCard", "setVideoCard", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "logicEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "value", "videoStatus", "getVideoStatus", "()I", "setVideoStatus", "(I)V", "getVideoRelativePos", "", "init", "", "msgId", "", "canvasId", "type", "data", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onScreenShot", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "setBizTimeLineInfo", "bizTimeLineInfo", "plugin-brandservice_release"})
public final class BizTLRecCardCanvasView
  extends WebCanvasView
  implements h
{
  final String TAG;
  z sBt;
  final y sEK;
  private final c sEL;
  private boolean sEM;
  private boolean sEz;
  private int videoStatus;
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(265514);
    this.TAG = ("MicroMsg.BizTLRecCardCanvasView:" + hashCode());
    this.sEz = true;
    this.sEK = y.sFw.cAO();
    this.sEL = ((c)this.sEK);
    AppMethodBeat.o(265514);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(265507);
    p.k(paramString1, "canvasId");
    p.k(paramString2, "type");
    p.k(paramString3, "data");
    Object localObject1 = getJsEngine();
    if (localObject1 == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine");
      AppMethodBeat.o(265507);
      throw paramString1;
    }
    ((Map)((y)localObject1).sFp).put(paramString1, Long.valueOf(paramLong));
    Object localObject2 = this.sBt;
    if (localObject2 != null)
    {
      localObject1 = (Map)((y)getJsEngine()).sFq;
      localObject2 = ((z)localObject2).getId();
      p.j(localObject2, "it.id");
      ((Map)localObject1).put(paramString1, localObject2);
    }
    localObject1 = (y)getJsEngine();
    localObject2 = new WeakReference(getContext());
    p.k(localObject2, "<set-?>");
    ((y)localObject1).context = ((WeakReference)localObject2);
    aV(paramString1, paramString2, paramString3);
    AppMethodBeat.o(265507);
  }
  
  public final void cAD()
  {
    AppMethodBeat.i(265510);
    y localy = this.sEK;
    String str = getCanvasId();
    p.k(str, "canvasId");
    c.a(localy, "scroll", str);
    AppMethodBeat.o(265510);
  }
  
  public final void cAE()
  {
    AppMethodBeat.i(265511);
    Object localObject = this.sEK;
    String str = getCanvasId();
    p.k(str, "canvasId");
    Log.i(y.TAG, "onScreenShot ".concat(String.valueOf(str)));
    c.a((c)localObject, "onScreenShot", str);
    localObject = ((y)localObject).sFr;
    if (localObject == null) {
      p.bGy("tlRenderJsEngine");
    }
    p.k(str, "canvasId");
    k.a((k)localObject, "onScreenShot", str);
    AppMethodBeat.o(265511);
  }
  
  public final z getInfo()
  {
    return this.sBt;
  }
  
  public final c getJsEngine()
  {
    return this.sEL;
  }
  
  public final float[] getVideoRelativePos()
  {
    AppMethodBeat.i(265513);
    float[] arrayOfFloat2 = this.sEK.bic(getCanvasId());
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null)
    {
      arrayOfFloat1 = new float[2];
      float[] tmp29_28 = arrayOfFloat1;
      tmp29_28[0] = 0.0F;
      float[] tmp33_29 = tmp29_28;
      tmp33_29[1] = 0.0F;
      tmp33_29;
    }
    AppMethodBeat.o(265513);
    return arrayOfFloat1;
  }
  
  public final int getVideoStatus()
  {
    return this.videoStatus;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(265508);
    super.onAttachedToWindow();
    Context localContext = getContext();
    Object localObject = localContext;
    if (!(localContext instanceof g)) {
      localObject = null;
    }
    localObject = (g)localObject;
    if (localObject != null)
    {
      ((g)localObject).a((h)this);
      AppMethodBeat.o(265508);
      return;
    }
    AppMethodBeat.o(265508);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(265512);
    if (this.sEM)
    {
      AppMethodBeat.o(265512);
      return;
    }
    this.sEM = true;
    Log.d(this.TAG, "onConfigurationChanged before:[" + getMeasuredWidth() + ", " + getMeasuredHeight() + ']');
    getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a(this));
    AppMethodBeat.o(265512);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(265509);
    super.onDetachedFromWindow();
    Context localContext = getContext();
    Object localObject = localContext;
    if (!(localContext instanceof g)) {
      localObject = null;
    }
    localObject = (g)localObject;
    if (localObject != null) {
      ((g)localObject).b((h)this);
    }
    if (this.videoStatus == 1) {
      this.sEK.apB(getCanvasId());
    }
    AppMethodBeat.o(265509);
  }
  
  public final void setBizTimeLineInfo(z paramz)
  {
    AppMethodBeat.i(265506);
    p.k(paramz, "bizTimeLineInfo");
    this.sEK.sBt = paramz;
    this.sBt = paramz;
    AppMethodBeat.o(265506);
  }
  
  public final void setDoingConfigurationChanged(boolean paramBoolean)
  {
    this.sEM = paramBoolean;
  }
  
  public final void setInfo(z paramz)
  {
    this.sBt = paramz;
  }
  
  public final void setVideoCard(boolean paramBoolean)
  {
    this.sEz = paramBoolean;
  }
  
  public final void setVideoStatus(int paramInt)
  {
    AppMethodBeat.i(265505);
    this.videoStatus = paramInt;
    Log.d(this.TAG, "set videoStatus = " + paramInt + ", " + getCanvasId());
    if (paramInt == 1)
    {
      Object localObject = this.sEK;
      String str = getCanvasId();
      p.k(str, "canvasId");
      Log.i(y.TAG, "enterHotZone #".concat(String.valueOf(str)));
      ac localac = ((y)localObject).sFr;
      if (localac == null) {
        p.bGy("tlRenderJsEngine");
      }
      p.k(str, "canvasId");
      k.a(localac, "enterHotZone", str);
      localObject = ((y)localObject).cAK().bij(str);
      if (localObject != null)
      {
        ((a)localObject).Ptc = true;
        AppMethodBeat.o(265505);
        return;
      }
      AppMethodBeat.o(265505);
      return;
    }
    this.sEK.apB(getCanvasId());
    AppMethodBeat.o(265505);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(258192);
      this.sEN.setDoingConfigurationChanged(false);
      Log.i(BizTLRecCardCanvasView.a(this.sEN), "onConfigurationChanged:[" + this.sEN.getMeasuredWidth() + ", " + this.sEN.getMeasuredHeight() + ']');
      c.a(this.sEN.getJsEngine(), BizTLRecCardCanvasView.b(this.sEN));
      this.sEN.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(258192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView
 * JD-Core Version:    0.7.0.1
 */