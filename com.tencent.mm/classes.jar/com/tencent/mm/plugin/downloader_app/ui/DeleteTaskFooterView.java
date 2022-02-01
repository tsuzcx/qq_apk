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
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.a.d.c;
import com.tencent.mm.plugin.downloader_app.b;

public class DeleteTaskFooterView
  extends LinearLayout
{
  private boolean Ua;
  private LinearLayout oMt;
  ImageView oMu;
  LinearLayout oMv;
  TextView oMw;
  ImageView oMx;
  boolean oMy;
  private d.c oMz;
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8981);
    this.Ua = true;
    this.oMy = false;
    this.oMz = new d.c()
    {
      public final void jN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8978);
        DeleteTaskFooterView localDeleteTaskFooterView = DeleteTaskFooterView.this;
        if (paramAnonymousBoolean)
        {
          localDeleteTaskFooterView.oMv.setClickable(true);
          b.e(localDeleteTaskFooterView.oMx, "download_delete_enable");
          localDeleteTaskFooterView.oMw.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099803));
          AppMethodBeat.o(8978);
          return;
        }
        localDeleteTaskFooterView.oMv.setClickable(false);
        b.e(localDeleteTaskFooterView.oMx, "download_delete_disable");
        localDeleteTaskFooterView.oMw.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099737));
        AppMethodBeat.o(8978);
      }
    };
    AppMethodBeat.o(8981);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8983);
    super.onAttachedToWindow();
    d.a(this.oMz);
    AppMethodBeat.o(8983);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8984);
    super.onDetachedFromWindow();
    d.b(this.oMz);
    AppMethodBeat.o(8984);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8982);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131493691, this, true);
    this.oMt = ((LinearLayout)localView.findViewById(2131298220));
    this.oMu = ((ImageView)localView.findViewById(2131298219));
    this.oMt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8979);
        if (DeleteTaskFooterView.a(DeleteTaskFooterView.this))
        {
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, false);
          b.e(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_off");
        }
        for (;;)
        {
          if (DeleteTaskFooterView.c(DeleteTaskFooterView.this)) {
            DeleteTaskFooterView.jP(DeleteTaskFooterView.a(DeleteTaskFooterView.this));
          }
          DeleteTaskFooterView.d(DeleteTaskFooterView.this);
          AppMethodBeat.o(8979);
          return;
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, true);
          b.e(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_on");
        }
      }
    });
    this.oMv = ((LinearLayout)localView.findViewById(2131298986));
    this.oMv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8980);
        DeleteTaskFooterView.bYA();
        AppMethodBeat.o(8980);
      }
    });
    this.oMv.setClickable(false);
    this.oMw = ((TextView)localView.findViewById(2131298982));
    this.oMx = ((ImageView)localView.findViewById(2131298987));
    AppMethodBeat.o(8982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */