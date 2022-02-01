package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.b.a.a.f;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.downloader_app.e.c;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;

public class BottomEntranceView
  extends RelativeLayout
{
  private f xtA;
  private TextView xtB;
  private ImageView xtC;
  private int xtD;
  private int xtE;
  
  public BottomEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getDisplayHeight()
  {
    AppMethodBeat.i(8975);
    int i = bf.bf(getContext()).y;
    AppMethodBeat.o(8975);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8973);
    super.onFinishInflate();
    this.xtB = ((TextView)findViewById(e.e.xql));
    this.xtC = ((ImageView)findViewById(e.e.xqk));
    float f = com.tencent.mm.cd.a.getScaleSize(getContext());
    this.xtC.getLayoutParams().height = ((int)(this.xtC.getLayoutParams().height * f));
    this.xtC.getLayoutParams().width = ((int)(f * this.xtC.getLayoutParams().width));
    this.xtC.requestLayout();
    this.xtE = (getDisplayHeight() - bf.fs(getContext()) - bf.getStatusBarHeight(getContext()) - bf.bk(getContext()));
    this.xtD = getResources().getDimensionPixelSize(e.c.xpJ);
    Log.d("MicroMsg.BottomEntranceView", "mContentH = %d", new Object[] { Integer.valueOf(this.xtE) });
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(8971);
        BottomEntranceView.a(BottomEntranceView.this);
        AppMethodBeat.o(8971);
      }
    });
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(8972);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/ui/BottomEntranceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((BottomEntranceView.b(BottomEntranceView.this) != null) && (!Util.isNullOrNil(BottomEntranceView.b(BottomEntranceView.this).jump_url)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", BottomEntranceView.b(BottomEntranceView.this).jump_url);
          ((c)h.ax(c.class)).f(BottomEntranceView.this.getContext(), paramAnonymousView);
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1005, 1, 40, "", "", "");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/BottomEntranceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(8972);
      }
    });
    AppMethodBeat.o(8973);
  }
  
  public void setData(f paramf)
  {
    AppMethodBeat.i(8974);
    if ((paramf == null) || (Util.isNullOrNil(paramf.desc)) || (Util.isNullOrNil(paramf.jump_url)))
    {
      setVisibility(8);
      AppMethodBeat.o(8974);
      return;
    }
    this.xtA = paramf;
    setVisibility(0);
    this.xtB.setText(this.xtA.desc);
    AppMethodBeat.o(8974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView
 * JD-Core Version:    0.7.0.1
 */