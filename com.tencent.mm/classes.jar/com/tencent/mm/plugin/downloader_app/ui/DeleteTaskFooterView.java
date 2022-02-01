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
  private boolean Tf;
  private LinearLayout oiT;
  ImageView oiU;
  LinearLayout oiV;
  TextView oiW;
  ImageView oiX;
  boolean oiY;
  private d.c oiZ;
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8981);
    this.Tf = true;
    this.oiY = false;
    this.oiZ = new d.c()
    {
      public final void jk(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8978);
        DeleteTaskFooterView localDeleteTaskFooterView = DeleteTaskFooterView.this;
        if (paramAnonymousBoolean)
        {
          localDeleteTaskFooterView.oiV.setClickable(true);
          b.e(localDeleteTaskFooterView.oiX, "download_delete_enable");
          localDeleteTaskFooterView.oiW.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099803));
          AppMethodBeat.o(8978);
          return;
        }
        localDeleteTaskFooterView.oiV.setClickable(false);
        b.e(localDeleteTaskFooterView.oiX, "download_delete_disable");
        localDeleteTaskFooterView.oiW.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131099737));
        AppMethodBeat.o(8978);
      }
    };
    AppMethodBeat.o(8981);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8983);
    super.onAttachedToWindow();
    d.a(this.oiZ);
    AppMethodBeat.o(8983);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8984);
    super.onDetachedFromWindow();
    d.b(this.oiZ);
    AppMethodBeat.o(8984);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8982);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2131493691, this, true);
    this.oiT = ((LinearLayout)localView.findViewById(2131298220));
    this.oiU = ((ImageView)localView.findViewById(2131298219));
    this.oiT.setOnClickListener(new View.OnClickListener()
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
            DeleteTaskFooterView.jm(DeleteTaskFooterView.a(DeleteTaskFooterView.this));
          }
          DeleteTaskFooterView.d(DeleteTaskFooterView.this);
          AppMethodBeat.o(8979);
          return;
          DeleteTaskFooterView.a(DeleteTaskFooterView.this, true);
          b.e(DeleteTaskFooterView.b(DeleteTaskFooterView.this), "checkbox_cell_on");
        }
      }
    });
    this.oiV = ((LinearLayout)localView.findViewById(2131298986));
    this.oiV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8980);
        DeleteTaskFooterView.bRl();
        AppMethodBeat.o(8980);
      }
    });
    this.oiV.setClickable(false);
    this.oiW = ((TextView)localView.findViewById(2131298982));
    this.oiX = ((ImageView)localView.findViewById(2131298987));
    AppMethodBeat.o(8982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */