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
  public View mParentView;
  public PopupWindow usB;
  public a usC;
  
  public d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(181765);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(d.f.upP, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.usB = new PopupWindow(paramContext, -2, -2, false);
    this.usB.setClippingEnabled(false);
    paramContext.findViewById(d.e.eba).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181761);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.usB.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.usC != null) {
          d.this.usC.cRq();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181761);
      }
    });
    paramContext.findViewById(d.e.eaX).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181762);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.usB.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.usC != null) {
          d.this.usC.cRr();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181762);
      }
    });
    paramContext.findViewById(d.e.eaZ).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181763);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.usB.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.usC != null) {
          d.this.usC.cRs();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181763);
      }
    });
    paramContext.findViewById(d.e.ebh).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181764);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.this.usB.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.usC != null) {
          d.this.usC.cRt();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181764);
      }
    });
    AppMethodBeat.o(181765);
  }
  
  public static abstract interface a
  {
    public abstract void cRq();
    
    public abstract void cRr();
    
    public abstract void cRs();
    
    public abstract void cRt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */