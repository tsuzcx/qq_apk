package com.tencent.mm.plugin.appbrand.widget.e;

import a.d.b.g;
import a.k;
import android.app.Activity;
import android.content.Context;
import android.text.Spannable.Factory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.o;

public final class c
  extends o
{
  private final TextView hBT;
  private final ImageView hBU;
  
  public c(Context paramContext)
  {
    super(paramContext);
    Object localObject = LayoutInflater.from(paramContext);
    int i = y.h.app_brand_show_toast;
    View localView = getContentView();
    if (localView == null) {
      throw new k("null cannot be cast to non-null type android.view.ViewGroup");
    }
    setContentView(((LayoutInflater)localObject).inflate(i, (ViewGroup)localView, false));
    localObject = getContentView().findViewById(y.g.progress);
    g.j(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(y.g.iv_icon);
    g.j(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.hBU = ((ImageView)localObject);
    localObject = getContentView().findViewById(y.g.title);
    g.j(localObject, "contentView.findViewById(R.id.title)");
    this.hBT = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.e(paramContext.getResources(), y.i.app_brand_show_toast_success);
    this.hBU.setVisibility(0);
    this.hBU.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.hBU.setImageDrawable(paramContext);
  }
  
  public final void show()
  {
    Object localObject = getContentView();
    g.j(localObject, "contentView");
    localObject = com.tencent.mm.ui.statusbar.d.cx(((View)localObject).getContext());
    if (localObject != null)
    {
      super.showAtLocation(((Activity)localObject).findViewById(16908290), 17, 0, 0);
      ai.l((Runnable)new d(this), 1500L);
    }
  }
  
  public final c u(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.hBT.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.hBT;
      View localView = getContentView();
      g.j(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.cb.a.fromDPToPix(localView.getContext(), 18)));
      this.hBT.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.hBT.setVisibility(0);
      paramCharSequence = getContentView();
      g.j(paramCharSequence, "contentView");
      i = com.tencent.mm.cb.a.fromDPToPix(paramCharSequence.getContext(), 27);
      getContentView().findViewById(y.g.show_toast_view_container).setPadding(0, i, 0, 0);
      return this;
    }
    this.hBT.setVisibility(4);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.c
 * JD-Core Version:    0.7.0.1
 */