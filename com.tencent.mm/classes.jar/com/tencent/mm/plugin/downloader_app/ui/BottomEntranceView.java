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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ar;

public class BottomEntranceView
  extends RelativeLayout
{
  private f pwC;
  private TextView pwD;
  private int pwE;
  private int pwF;
  
  public BottomEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getDisplayHeight()
  {
    AppMethodBeat.i(8975);
    int i = ar.ck(getContext()).y;
    AppMethodBeat.o(8975);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8973);
    super.onFinishInflate();
    this.pwD = ((TextView)findViewById(2131299510));
    this.pwF = (getDisplayHeight() - ar.dX(getContext()) - ar.jN(getContext()) - ar.en(getContext()));
    this.pwE = getResources().getDimensionPixelSize(2131165922);
    ae.d("MicroMsg.BottomEntranceView", "mContentH = %d", new Object[] { Integer.valueOf(this.pwF) });
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
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/BottomEntranceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((BottomEntranceView.b(BottomEntranceView.this) != null) && (!bu.isNullOrNil(BottomEntranceView.b(BottomEntranceView.this).oGf)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", BottomEntranceView.b(BottomEntranceView.this).oGf);
          ((c)g.ab(c.class)).e(BottomEntranceView.this.getContext(), paramAnonymousView);
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
    if ((paramf == null) || (bu.isNullOrNil(paramf.desc)) || (bu.isNullOrNil(paramf.oGf)))
    {
      setVisibility(8);
      AppMethodBeat.o(8974);
      return;
    }
    this.pwC = paramf;
    setVisibility(0);
    this.pwD.setText(this.pwC.desc);
    AppMethodBeat.o(8974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView
 * JD-Core Version:    0.7.0.1
 */