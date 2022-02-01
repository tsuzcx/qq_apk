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

public final class d
{
  public View mParentView;
  public PopupWindow pBe;
  public a pBf;
  
  public d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(181765);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131493745, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.pBe = new PopupWindow(paramContext, -2, -2, false);
    this.pBe.setClippingEnabled(false);
    paramContext.findViewById(2131306977).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181761);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.this.pBe.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.pBf != null) {
          d.this.pBf.ceV();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181761);
      }
    });
    paramContext.findViewById(2131306974).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181762);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.this.pBe.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.pBf != null) {
          d.this.pBf.ceW();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181762);
      }
    });
    paramContext.findViewById(2131306976).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181763);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.this.pBe.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.pBf != null) {
          d.this.pBf.ceX();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181763);
      }
    });
    paramContext.findViewById(2131306985).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181764);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.this.pBe.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.pBf != null) {
          d.this.pBf.ceY();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181764);
      }
    });
    AppMethodBeat.o(181765);
  }
  
  public static abstract interface a
  {
    public abstract void ceV();
    
    public abstract void ceW();
    
    public abstract void ceX();
    
    public abstract void ceY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */