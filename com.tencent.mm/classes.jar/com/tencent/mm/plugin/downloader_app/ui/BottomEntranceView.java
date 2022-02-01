package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;

public class BottomEntranceView
  extends RelativeLayout
{
  private f qLT;
  private TextView qLU;
  private int qLV;
  private int qLW;
  
  public BottomEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getDisplayHeight()
  {
    AppMethodBeat.i(8975);
    int i = au.az(getContext()).y;
    AppMethodBeat.o(8975);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8973);
    super.onFinishInflate();
    this.qLU = ((TextView)findViewById(2131300147));
    this.qLW = (getDisplayHeight() - au.eu(getContext()) - au.getStatusBarHeight(getContext()) - au.aD(getContext()));
    this.qLV = getResources().getDimensionPixelSize(2131165949);
    Log.d("MicroMsg.BottomEntranceView", "mContentH = %d", new Object[] { Integer.valueOf(this.qLW) });
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/BottomEntranceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((BottomEntranceView.b(BottomEntranceView.this) != null) && (!Util.isNullOrNil(BottomEntranceView.b(BottomEntranceView.this).pTL)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", BottomEntranceView.b(BottomEntranceView.this).pTL);
          ((c)g.af(c.class)).e(BottomEntranceView.this.getContext(), paramAnonymousView);
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
    if ((paramf == null) || (Util.isNullOrNil(paramf.desc)) || (Util.isNullOrNil(paramf.pTL)))
    {
      setVisibility(8);
      AppMethodBeat.o(8974);
      return;
    }
    this.qLT = paramf;
    setVisibility(0);
    this.qLU.setText(this.qLT.desc);
    AppMethodBeat.o(8974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView
 * JD-Core Version:    0.7.0.1
 */