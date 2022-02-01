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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasNoneLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "isDoingConfigurationChanged", "", "()Z", "setDoingConfigurationChanged", "(Z)V", "isVideoCard", "setVideoCard", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "logicEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "value", "videoStatus", "getVideoStatus", "()I", "setVideoStatus", "(I)V", "getVideoRelativePos", "", "init", "", "msgId", "", "canvasId", "type", "data", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onScreenShot", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "setBizTimeLineInfo", "bizTimeLineInfo", "plugin-brandservice_release"})
public final class BizTLRecCardCanvasView
  extends WebCanvasView
  implements h
{
  final String TAG;
  z psm;
  private boolean pvi;
  final x pvt;
  private final c pvu;
  private boolean pvv;
  private int videoStatus;
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195386);
    this.TAG = ("MicroMsg.BizTLRecCardCanvasView:" + hashCode());
    this.pvi = true;
    paramContext = r.puL;
    this.pvt = r.a.cmU();
    this.pvu = ((c)this.pvt);
    AppMethodBeat.o(195386);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(195379);
    p.h(paramString1, "canvasId");
    p.h(paramString2, "type");
    p.h(paramString3, "data");
    Object localObject = getJsEngine();
    if (localObject == null)
    {
      paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine");
      AppMethodBeat.o(195379);
      throw paramString1;
    }
    ((Map)((x)localObject).pvX).put(paramString1, Long.valueOf(paramLong));
    localObject = (x)getJsEngine();
    WeakReference localWeakReference = new WeakReference(getContext());
    p.h(localWeakReference, "<set-?>");
    ((x)localObject).lAM = localWeakReference;
    bb(paramString1, paramString2, paramString3);
    AppMethodBeat.o(195379);
  }
  
  public final void cmV()
  {
    AppMethodBeat.i(195382);
    x localx = this.pvt;
    String str = getCanvasId();
    p.h(str, "canvasId");
    c.a(localx, "scroll", str);
    AppMethodBeat.o(195382);
  }
  
  public final void cmW()
  {
    AppMethodBeat.i(195383);
    x localx = this.pvt;
    String str = getCanvasId();
    p.h(str, "canvasId");
    Log.i(x.TAG, "onScreenShot ".concat(String.valueOf(str)));
    c.a(localx, "onScreenShot", str);
    AppMethodBeat.o(195383);
  }
  
  public final z getInfo()
  {
    return this.psm;
  }
  
  public final c getJsEngine()
  {
    return this.pvu;
  }
  
  public final float[] getVideoRelativePos()
  {
    AppMethodBeat.i(195385);
    float[] arrayOfFloat2 = this.pvt.aWv(getCanvasId());
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null)
    {
      arrayOfFloat1 = new float[2];
      float[] tmp28_27 = arrayOfFloat1;
      tmp28_27[0] = 0.0F;
      float[] tmp32_28 = tmp28_27;
      tmp32_28[1] = 0.0F;
      tmp32_28;
    }
    AppMethodBeat.o(195385);
    return arrayOfFloat1;
  }
  
  public final int getVideoStatus()
  {
    return this.videoStatus;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(195380);
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
      AppMethodBeat.o(195380);
      return;
    }
    AppMethodBeat.o(195380);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(195384);
    if (this.pvv)
    {
      AppMethodBeat.o(195384);
      return;
    }
    this.pvv = true;
    Log.d(this.TAG, "onConfigurationChanged before:[" + getMeasuredWidth() + ", " + getMeasuredHeight() + ']');
    getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a(this));
    AppMethodBeat.o(195384);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(195381);
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
      this.pvt.ahP(getCanvasId());
    }
    AppMethodBeat.o(195381);
  }
  
  public final void setBizTimeLineInfo(z paramz)
  {
    AppMethodBeat.i(195378);
    p.h(paramz, "bizTimeLineInfo");
    this.pvt.psm = paramz;
    this.psm = paramz;
    AppMethodBeat.o(195378);
  }
  
  public final void setDoingConfigurationChanged(boolean paramBoolean)
  {
    this.pvv = paramBoolean;
  }
  
  public final void setInfo(z paramz)
  {
    this.psm = paramz;
  }
  
  public final void setVideoCard(boolean paramBoolean)
  {
    this.pvi = paramBoolean;
  }
  
  public final void setVideoStatus(int paramInt)
  {
    AppMethodBeat.i(195377);
    this.videoStatus = paramInt;
    Log.d(this.TAG, "set videoStatus = " + paramInt + ", " + getCanvasId());
    if (paramInt == 1)
    {
      Object localObject = this.pvt;
      String str = getCanvasId();
      p.h(str, "canvasId");
      Log.i(x.TAG, "enterHotZone #".concat(String.valueOf(str)));
      ab localab = ((x)localObject).pvY;
      if (localab == null) {
        p.btv("tlRenderJsEngine");
      }
      p.h(str, "canvasId");
      k.a(localab, "enterHotZone", str);
      localObject = ((x)localObject).cnb().aWC(str);
      if (localObject != null)
      {
        ((a)localObject).IyZ = true;
        AppMethodBeat.o(195377);
        return;
      }
      AppMethodBeat.o(195377);
      return;
    }
    this.pvt.ahP(getCanvasId());
    AppMethodBeat.o(195377);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(195376);
      this.pvw.setDoingConfigurationChanged(false);
      Log.i(BizTLRecCardCanvasView.a(this.pvw), "onConfigurationChanged:[" + this.pvw.getMeasuredWidth() + ", " + this.pvw.getMeasuredHeight() + ']');
      c.a(this.pvw.getJsEngine(), BizTLRecCardCanvasView.b(this.pvw));
      this.pvw.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      AppMethodBeat.o(195376);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView
 * JD-Core Version:    0.7.0.1
 */