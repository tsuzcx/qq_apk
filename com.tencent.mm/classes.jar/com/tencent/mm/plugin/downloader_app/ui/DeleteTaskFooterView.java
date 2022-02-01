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
  private boolean Wd;
  private LinearLayout qLY;
  ImageView qLZ;
  LinearLayout qMa;
  TextView qMb;
  ImageView qMc;
  boolean qMd;
  private d.c qMe;
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8981);
    this.Wd = true;
    this.qMd = false;
    this.qMe = new d.c()
    {
      public final void la(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8978);
        DeleteTaskFooterView localDeleteTaskFooterView = DeleteTaskFooterView.this;
        if (paramAnonymousBoolean)
        {
          localDeleteTaskFooterView.qMa.setClickable(true);
          com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.qMc, "download_delete_enable");
          localDeleteTaskFooterView.qMb.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099818));
          AppMethodBeat.o(8978);
          return;
        }
        localDeleteTaskFooterView.qMa.setClickable(false);
        com.tencent.mm.plugin.downloader_app.b.e(localDeleteTaskFooterView.qMc, "download_delete_disable");
        localDeleteTaskFooterView.qMb.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099751));
        AppMethodBeat.o(8978);
      }
    };
    AppMethodBeat.o(8981);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8983);
    super.onAttachedToWindow();
    d.a(this.qMe);
    AppMethodBeat.o(8983);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8984);
    super.onDetachedFromWindow();
    d.b(this.qMe);
    AppMethodBeat.o(8984);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8982);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131493822, this, true);
    this.qLY = ((LinearLayout)localView.findViewById(2131298603));
    this.qLZ = ((ImageView)localView.findViewById(2131298602));
    this.qLY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/downloader_app/ui/DeleteTaskFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (DeleteTaskFooterView.a(DeleteTaskFooterView.this))
        {
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, false);
          com.tencent.mm.plugin.downloader_app.b.e(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_off");
        }
        for (;;)
        {
          if (DeleteTaskFooterView.c(DeleteTaskFooterView.this)) {
            DeleteTaskFooterView.lc(DeleteTaskFooterView.a(DeleteTaskFooterView.this));
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
    this.qMa = ((LinearLayout)localView.findViewById(2131299480));
    this.qMa.setOnClickListener(new DeleteTaskFooterView.3(this));
    this.qMa.setClickable(false);
    this.qMb = ((TextView)localView.findViewById(2131299476));
    this.qMc = ((ImageView)localView.findViewById(2131299482));
    AppMethodBeat.o(8982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */