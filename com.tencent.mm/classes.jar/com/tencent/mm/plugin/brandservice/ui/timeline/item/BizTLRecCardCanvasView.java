package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.WebCanvasView;
import com.tencent.mm.plugin.webcanvas.c;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "jsEngine", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine;", "init", "", "msgId", "", "canvasId", "", "type", "data", "parent", "Landroid/view/View;", "plugin-brandservice_release"})
public final class BizTLRecCardCanvasView
  extends WebCanvasView
{
  private final c ojA;
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208735);
    paramContext = k.oiS;
    this.ojA = ((c)k.a.bPD());
    AppMethodBeat.o(208735);
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, String paramString3, View paramView)
  {
    AppMethodBeat.i(208734);
    p.h(paramString1, "canvasId");
    p.h(paramString2, "type");
    p.h(paramString3, "data");
    p.h(paramView, "parent");
    Object localObject = getJsEngine();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardJsEngine");
      AppMethodBeat.o(208734);
      throw paramString1;
    }
    ((Map)((q)localObject).ojZ).put(paramString1, Long.valueOf(paramLong));
    localObject = (q)getJsEngine();
    WeakReference localWeakReference = new WeakReference(getContext());
    p.h(localWeakReference, "<set-?>");
    ((q)localObject).kwC = localWeakReference;
    a(paramString1, paramString2, paramString3, paramView);
    AppMethodBeat.o(208734);
  }
  
  public final c getJsEngine()
  {
    return this.ojA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView
 * JD-Core Version:    0.7.0.1
 */