package com.tencent.mm.plugin.appbrand.widget.e;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.o;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c
  extends o
{
  private final TextView nmO;
  private final ImageView nmP;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51450);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, 2131493061, (ViewGroup)localObject);
    setContentView((View)localObject);
    localObject = getContentView().findViewById(2131303515);
    p.g(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(2131301215);
    p.g(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.nmP = ((ImageView)localObject);
    localObject = getContentView().findViewById(2131305902);
    p.g(localObject, "contentView.findViewById(R.id.title)");
    this.nmO = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.g(paramContext.getResources(), 2131689649);
    this.nmP.setVisibility(0);
    this.nmP.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.nmP.setImageDrawable(paramContext);
    AppMethodBeat.o(51450);
  }
  
  public final c H(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(51448);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label143;
      }
      this.nmO.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.nmO;
      View localView = getContentView();
      p.g(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.cc.a.fromDPToPix(localView.getContext(), 18)));
      this.nmO.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.nmO.setVisibility(0);
      paramCharSequence = getContentView();
      p.g(paramCharSequence, "contentView");
      i = com.tencent.mm.cc.a.fromDPToPix(paramCharSequence.getContext(), 27);
      getContentView().findViewById(2131304793).setPadding(0, i, 0, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(51448);
      return this;
      i = 0;
      break;
      label143:
      this.nmO.setVisibility(4);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(51449);
    Object localObject = getContentView();
    p.g(localObject, "contentView");
    localObject = com.tencent.mm.ui.statusbar.d.kA(((View)localObject).getContext());
    if (localObject != null)
    {
      super.showAtLocation(((Activity)localObject).findViewById(16908290), 17, 0, 0);
      aq.o((Runnable)new d(this), 1500L);
      AppMethodBeat.o(51449);
      return;
    }
    AppMethodBeat.o(51449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.c
 * JD-Core Version:    0.7.0.1
 */