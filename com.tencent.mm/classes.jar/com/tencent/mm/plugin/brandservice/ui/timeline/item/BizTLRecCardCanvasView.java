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
import com.tencent.mm.plugin.webcanvas.e;
import com.tencent.mm.plugin.webcanvas.f;
import com.tencent.mm.plugin.webcanvas.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasNoneLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "setInfo", "(Lcom/tencent/mm/storage/BizTimeLineInfo;)V", "isDoingConfigurationChanged", "", "()Z", "setDoingConfigurationChanged", "(Z)V", "isVideoCard", "setVideoCard", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "logicEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "getLogicEngine", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "value", "videoStatus", "getVideoStatus", "()I", "setVideoStatus", "(I)V", "getVideoRelativePos", "", "init", "", "msgId", "", "canvasId", "type", "data", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onScreenShot", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "setBizTimeLineInfo", "bizTimeLineInfo", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTLRecCardCanvasView
  extends WebCanvasView
  implements f
{
  final String TAG;
  ab vGS;
  private boolean vKj;
  private final c vKs;
  private boolean vKt;
  private int videoStatus;
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(302593);
    AppMethodBeat.o(302593);
  }
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(302587);
    this.TAG = s.X("MicroMsg.BizTLRecCardCanvasView:", Integer.valueOf(hashCode()));
    this.vKj = true;
    this.vKs = ((c)getLogicEngine());
    AppMethodBeat.o(302587);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(302635);
    s.u(paramString1, "canvasId");
    s.u(paramString2, "type");
    s.u(paramString3, "data");
    ((Map)((BizTLRecCardJsEngine)getJsEngine()).vKV).put(paramString1, Long.valueOf(paramLong));
    Object localObject2 = this.vGS;
    if (localObject2 != null)
    {
      localObject1 = (Map)((BizTLRecCardJsEngine)getJsEngine()).vKW;
      localObject2 = ((ab)localObject2).getId();
      s.s(localObject2, "it.id");
      ((Map)localObject1).put(paramString1, localObject2);
    }
    Object localObject1 = (BizTLRecCardJsEngine)getJsEngine();
    localObject2 = new WeakReference(getContext());
    s.u(localObject2, "<set-?>");
    ((BizTLRecCardJsEngine)localObject1).context = ((WeakReference)localObject2);
    bo(paramString1, paramString2, paramString3);
    AppMethodBeat.o(302635);
  }
  
  public final void ddD()
  {
    AppMethodBeat.i(302647);
    BizTLRecCardJsEngine localBizTLRecCardJsEngine = getLogicEngine();
    String str = getCanvasId();
    s.u(str, "canvasId");
    c.a((c)localBizTLRecCardJsEngine, "scroll", str);
    AppMethodBeat.o(302647);
  }
  
  public final void ddE()
  {
    AppMethodBeat.i(302650);
    Object localObject = getLogicEngine();
    String str = getCanvasId();
    s.u(str, "canvasId");
    Log.i(BizTLRecCardJsEngine.TAG, s.X("onScreenShot ", str));
    c.a((c)localObject, "onScreenShot", str);
    localObject = ((BizTLRecCardJsEngine)localObject).ddN();
    s.u(str, "canvasId");
    i.a((i)localObject, "onScreenShot", str);
    AppMethodBeat.o(302650);
  }
  
  public final ab getInfo()
  {
    return this.vGS;
  }
  
  public final c getJsEngine()
  {
    return this.vKs;
  }
  
  final BizTLRecCardJsEngine getLogicEngine()
  {
    AppMethodBeat.i(302624);
    BizTLRecCardJsEngine localBizTLRecCardJsEngine = BizTLRecCardJsEngine.vKS.ddS();
    AppMethodBeat.o(302624);
    return localBizTLRecCardJsEngine;
  }
  
  public final float[] getVideoRelativePos()
  {
    AppMethodBeat.i(302672);
    float[] arrayOfFloat = getLogicEngine().bhN(getCanvasId());
    if (arrayOfFloat == null)
    {
      AppMethodBeat.o(302672);
      return new float[] { 0.0F, 0.0F };
    }
    AppMethodBeat.o(302672);
    return arrayOfFloat;
  }
  
  public final int getVideoStatus()
  {
    return this.videoStatus;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(302639);
    super.onAttachedToWindow();
    Object localObject = getContext();
    if ((localObject instanceof e)) {}
    for (localObject = (e)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((e)localObject).a((f)this);
      }
      AppMethodBeat.o(302639);
      return;
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(302663);
    if (this.vKt)
    {
      AppMethodBeat.o(302663);
      return;
    }
    this.vKt = true;
    c.a(getJsEngine(), getCanvasId());
    Log.d(this.TAG, "CanvasView onConfigurationChanged before:[" + getMeasuredWidth() + ", " + getMeasuredHeight() + ']');
    getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a(this));
    AppMethodBeat.o(302663);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(302642);
    super.onDetachedFromWindow();
    Object localObject = getContext();
    if ((localObject instanceof e)) {}
    for (localObject = (e)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((e)localObject).b((f)this);
      }
      if (this.videoStatus == 1) {
        getLogicEngine().ajb(getCanvasId());
      }
      AppMethodBeat.o(302642);
      return;
    }
  }
  
  public final void setBizTimeLineInfo(ab paramab)
  {
    AppMethodBeat.i(302631);
    s.u(paramab, "bizTimeLineInfo");
    getLogicEngine().vGS = paramab;
    this.vGS = paramab;
    AppMethodBeat.o(302631);
  }
  
  public final void setDoingConfigurationChanged(boolean paramBoolean)
  {
    this.vKt = paramBoolean;
  }
  
  public final void setInfo(ab paramab)
  {
    this.vGS = paramab;
  }
  
  public final void setVideoCard(boolean paramBoolean)
  {
    this.vKj = paramBoolean;
  }
  
  public final void setVideoStatus(int paramInt)
  {
    AppMethodBeat.i(302621);
    this.videoStatus = paramInt;
    Log.d(this.TAG, "set videoStatus = " + paramInt + ", " + getCanvasId());
    if (paramInt == 1)
    {
      Object localObject = getLogicEngine();
      String str = getCanvasId();
      s.u(str, "canvasId");
      Log.i(BizTLRecCardJsEngine.TAG, s.X("enterHotZone #", str));
      z localz = ((BizTLRecCardJsEngine)localObject).ddN();
      s.u(str, "canvasId");
      i.a((i)localz, "enterHotZone", str);
      localObject = ((BizTLRecCardJsEngine)localObject).ddN().bhV(str);
      if (localObject != null) {
        ((a)localObject).WjU = true;
      }
      AppMethodBeat.o(302621);
      return;
    }
    getLogicEngine().ajb(getCanvasId());
    AppMethodBeat.o(302621);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "counter", "", "onGlobalLayout", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int evg;
    
    a(BizTLRecCardCanvasView paramBizTLRecCardCanvasView) {}
    
    private static final void a(BizTLRecCardCanvasView paramBizTLRecCardCanvasView, a parama)
    {
      AppMethodBeat.i(302611);
      s.u(paramBizTLRecCardCanvasView, "this$0");
      s.u(parama, "this$1");
      paramBizTLRecCardCanvasView.setDoingConfigurationChanged(false);
      Log.i(BizTLRecCardCanvasView.b(paramBizTLRecCardCanvasView), "CanvasView onConfigurationChanged:[" + paramBizTLRecCardCanvasView.getMeasuredWidth() + ", " + paramBizTLRecCardCanvasView.getMeasuredHeight() + ']');
      c.a(paramBizTLRecCardCanvasView.getJsEngine(), BizTLRecCardCanvasView.a(paramBizTLRecCardCanvasView));
      paramBizTLRecCardCanvasView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)parama);
      AppMethodBeat.o(302611);
    }
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(302620);
      c.a(this.vKu.getJsEngine(), BizTLRecCardCanvasView.a(this.vKu));
      this.evg += 1;
      if (this.evg < 2)
      {
        AppMethodBeat.o(302620);
        return;
      }
      this.vKu.post(new BizTLRecCardCanvasView.a..ExternalSyntheticLambda0(this.vKu, this));
      AppMethodBeat.o(302620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView
 * JD-Core Version:    0.7.0.1
 */