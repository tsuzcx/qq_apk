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

public class DeleteTaskFooterView
  extends LinearLayout
{
  private boolean VQ;
  private LinearLayout pqb;
  ImageView pqc;
  LinearLayout pqd;
  TextView pqe;
  ImageView pqf;
  boolean pqg;
  private d.c pqh;
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8981);
    this.VQ = true;
    this.pqg = false;
    this.pqh = new d.c()
    {
      public final void jY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8978);
        DeleteTaskFooterView localDeleteTaskFooterView = DeleteTaskFooterView.this;
        if (paramAnonymousBoolean)
        {
          localDeleteTaskFooterView.pqd.setClickable(true);
          com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.pqf, "download_delete_enable");
          localDeleteTaskFooterView.pqe.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099803));
          AppMethodBeat.o(8978);
          return;
        }
        localDeleteTaskFooterView.pqd.setClickable(false);
        com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.pqf, "download_delete_disable");
        localDeleteTaskFooterView.pqe.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099737));
        AppMethodBeat.o(8978);
      }
    };
    AppMethodBeat.o(8981);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8983);
    super.onAttachedToWindow();
    d.a(this.pqh);
    AppMethodBeat.o(8983);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8984);
    super.onDetachedFromWindow();
    d.b(this.pqh);
    AppMethodBeat.o(8984);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8982);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131493691, this, true);
    this.pqb = ((LinearLayout)localView.findViewById(2131298220));
    this.pqc = ((ImageView)localView.findViewById(2131298219));
    this.pqb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (DeleteTaskFooterView.a(DeleteTaskFooterView.this))
        {
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, false);
          com.tencent.mm.plugin.downloader_app.b.e(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_off");
        }
        for (;;)
        {
          if (DeleteTaskFooterView.c(DeleteTaskFooterView.this)) {
            DeleteTaskFooterView.ka(DeleteTaskFooterView.a(DeleteTaskFooterView.this));
          }
          DeleteTaskFooterView.d(DeleteTaskFooterView.this);
          a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8979);
          return;
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, true);
          com.tencent.mm.plugin.downloader_app.b.e(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_on");
        }
      }
    });
    this.pqd = ((LinearLayout)localView.findViewById(2131298986));
    this.pqd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8980);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        DeleteTaskFooterView.cde();
        a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(8980);
      }
    });
    this.pqd.setClickable(false);
    this.pqe = ((TextView)localView.findViewById(2131298982));
    this.pqf = ((ImageView)localView.findViewById(2131298987));
    AppMethodBeat.o(8982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */