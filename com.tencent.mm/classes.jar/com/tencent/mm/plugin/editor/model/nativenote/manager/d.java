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
  public PopupWindow qQv;
  public a qQw;
  
  public d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(181765);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131493887, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.qQv = new PopupWindow(paramContext, -2, -2, false);
    this.qQv.setClippingEnabled(false);
    paramContext.findViewById(2131310477).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181761);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.this.qQv.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.qQw != null) {
          d.this.qQw.cCL();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181761);
      }
    });
    paramContext.findViewById(2131310474).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181762);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.this.qQv.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.qQw != null) {
          d.this.qQw.cCM();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181762);
      }
    });
    paramContext.findViewById(2131310476).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181763);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.this.qQv.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.qQw != null) {
          d.this.qQw.cCN();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181763);
      }
    });
    paramContext.findViewById(2131310485).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181764);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        d.this.qQv.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.qQw != null) {
          d.this.qQw.cCO();
        }
        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/manager/EditorOperateWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181764);
      }
    });
    AppMethodBeat.o(181765);
  }
  
  public static abstract interface a
  {
    public abstract void cCL();
    
    public abstract void cCM();
    
    public abstract void cCN();
    
    public abstract void cCO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */