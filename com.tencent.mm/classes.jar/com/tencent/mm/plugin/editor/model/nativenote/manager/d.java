package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.d.f;

public final class d
{
  public PopupWindow xyX;
  public View xyY;
  public a xyZ;
  
  public d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(181765);
    this.xyY = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(d.f.xwm, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.xyX = new PopupWindow(paramContext, -2, -2, false);
    this.xyX.setClippingEnabled(false);
    paramContext.findViewById(d.e.gdE).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181761);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        d.this.xyX.dismiss();
        d.this.xyY.setVisibility(8);
        if (d.this.xyZ != null) {
          d.this.xyZ.dvJ();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181761);
      }
    });
    paramContext.findViewById(d.e.gdB).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181762);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        d.this.xyX.dismiss();
        d.this.xyY.setVisibility(8);
        if (d.this.xyZ != null) {
          d.this.xyZ.dvK();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181762);
      }
    });
    paramContext.findViewById(d.e.gdD).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181763);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        d.this.xyX.dismiss();
        d.this.xyY.setVisibility(8);
        if (d.this.xyZ != null) {
          d.this.xyZ.dvL();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181763);
      }
    });
    paramContext.findViewById(d.e.gdL).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181764);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        d.this.xyX.dismiss();
        d.this.xyY.setVisibility(8);
        if (d.this.xyZ != null) {
          d.this.xyZ.dvM();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181764);
      }
    });
    AppMethodBeat.o(181765);
  }
  
  public static abstract interface a
  {
    public abstract void dvJ();
    
    public abstract void dvK();
    
    public abstract void dvL();
    
    public abstract void dvM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */