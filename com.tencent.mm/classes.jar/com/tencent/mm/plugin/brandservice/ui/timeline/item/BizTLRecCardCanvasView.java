package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webcanvas.WebCanvasView;
import com.tencent.mm.plugin.webcanvas.b;
import d.g.b.p;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "msgId", "", "canvasId", "", "jsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "type", "data", "parent", "Landroid/view/View;", "plugin-brandservice_release"})
public final class BizTLRecCardCanvasView
  extends WebCanvasView
{
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public BizTLRecCardCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209761);
    paramContext = k.ode;
    setJsEngine((b)k.a.bOF());
    AppMethodBeat.o(209761);
  }
  
  public final void a(long paramLong, String paramString1, q paramq, String paramString2, String paramString3, View paramView)
  {
    AppMethodBeat.i(209760);
    p.h(paramString1, "canvasId");
    p.h(paramq, "jsEngine");
    p.h(paramString2, "type");
    p.h(paramString3, "data");
    p.h(paramView, "parent");
    ((Map)paramq.oej).put(paramString1, Long.valueOf(paramLong));
    paramq.context = getContext();
    a(paramString1, (b)paramq, paramString2, paramString3, paramView);
    AppMethodBeat.o(209760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView
 * JD-Core Version:    0.7.0.1
 */