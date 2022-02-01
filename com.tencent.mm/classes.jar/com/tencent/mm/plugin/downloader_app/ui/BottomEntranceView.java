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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ap;

public class BottomEntranceView
  extends RelativeLayout
{
  private f oMo;
  private TextView oMp;
  private int oMq;
  private int oMr;
  
  public BottomEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getDisplayHeight()
  {
    AppMethodBeat.i(8975);
    int i = ap.cl(getContext()).y;
    AppMethodBeat.o(8975);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8973);
    super.onFinishInflate();
    this.oMp = ((TextView)findViewById(2131299510));
    this.oMr = (getDisplayHeight() - ap.dT(getContext()) - ap.ji(getContext()) - ap.ej(getContext()));
    this.oMq = getResources().getDimensionPixelSize(2131165922);
    ac.d("MicroMsg.BottomEntranceView", "mContentH = %d", new Object[] { Integer.valueOf(this.oMr) });
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
        if ((BottomEntranceView.b(BottomEntranceView.this) != null) && (!bs.isNullOrNil(BottomEntranceView.b(BottomEntranceView.this).nWj)))
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("rawUrl", BottomEntranceView.b(BottomEntranceView.this).nWj);
          ((c)g.ab(c.class)).e(BottomEntranceView.this.getContext(), paramAnonymousView);
          a.a(10, 1005, 1, 40, "", "", "");
        }
        AppMethodBeat.o(8972);
      }
    });
    AppMethodBeat.o(8973);
  }
  
  public void setData(f paramf)
  {
    AppMethodBeat.i(8974);
    if ((paramf == null) || (bs.isNullOrNil(paramf.desc)) || (bs.isNullOrNil(paramf.nWj)))
    {
      setVisibility(8);
      AppMethodBeat.o(8974);
      return;
    }
    this.oMo = paramf;
    setVisibility(0);
    this.oMp.setText(this.oMo.desc);
    AppMethodBeat.o(8974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView
 * JD-Core Version:    0.7.0.1
 */