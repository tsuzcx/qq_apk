package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.a.d.c;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.f;

public class DeleteTaskFooterView
  extends LinearLayout
{
  private boolean cdL;
  private LinearLayout xtG;
  ImageView xtH;
  LinearLayout xtI;
  TextView xtJ;
  ImageView xtK;
  boolean xtL;
  private d.c xtM;
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8981);
    this.cdL = true;
    this.xtL = false;
    this.xtM = new d.c()
    {
      public final void nI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8978);
        DeleteTaskFooterView localDeleteTaskFooterView = DeleteTaskFooterView.this;
        if (paramAnonymousBoolean)
        {
          localDeleteTaskFooterView.xtI.setClickable(true);
          com.tencent.mm.plugin.downloader_app.b.i(localDeleteTaskFooterView.xtK, "download_delete_enable");
          localDeleteTaskFooterView.xtJ.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(e.b.Red));
          AppMethodBeat.o(8978);
          return;
        }
        localDeleteTaskFooterView.xtI.setClickable(false);
        com.tencent.mm.plugin.downloader_app.b.i(localDeleteTaskFooterView.xtK, "download_delete_disable");
        localDeleteTaskFooterView.xtJ.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(e.b.FG_4));
        AppMethodBeat.o(8978);
      }
    };
    AppMethodBeat.o(8981);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8983);
    super.onAttachedToWindow();
    d.a(this.xtM);
    AppMethodBeat.o(8983);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8984);
    super.onDetachedFromWindow();
    d.b(this.xtM);
    AppMethodBeat.o(8984);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8982);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(e.f.xqI, this, true);
    this.xtG = ((LinearLayout)localView.findViewById(e.e.fAS));
    this.xtH = ((ImageView)localView.findViewById(e.e.xpY));
    this.xtG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (DeleteTaskFooterView.a(DeleteTaskFooterView.this))
        {
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, false);
          com.tencent.mm.plugin.downloader_app.b.i(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_off");
        }
        for (;;)
        {
          if (DeleteTaskFooterView.c(DeleteTaskFooterView.this)) {
            DeleteTaskFooterView.nK(DeleteTaskFooterView.a(DeleteTaskFooterView.this));
          }
          DeleteTaskFooterView.d(DeleteTaskFooterView.this);
          a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8979);
          return;
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, true);
          com.tencent.mm.plugin.downloader_app.b.i(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_on");
        }
      }
    });
    this.xtI = ((LinearLayout)localView.findViewById(e.e.xpZ));
    this.xtI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8980);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        DeleteTaskFooterView.dvg();
        a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(8980);
      }
    });
    this.xtI.setClickable(false);
    this.xtJ = ((TextView)localView.findViewById(e.e.fEU));
    this.xtK = ((ImageView)localView.findViewById(e.e.xqa));
    AppMethodBeat.o(8982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */