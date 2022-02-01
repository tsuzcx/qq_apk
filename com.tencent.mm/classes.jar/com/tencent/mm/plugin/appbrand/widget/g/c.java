package com.tencent.mm.plugin.appbrand.widget.g;

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
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.r;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c
  extends r
{
  private final TextView rEm;
  private final ImageView rEn;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51450);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, au.g.app_brand_show_toast, (ViewGroup)localObject);
    setContentView((View)localObject);
    localObject = getContentView().findViewById(au.f.progress);
    p.j(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(au.f.iv_icon);
    p.j(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.rEn = ((ImageView)localObject);
    localObject = getContentView().findViewById(au.f.title);
    p.j(localObject, "contentView.findViewById(R.id.title)");
    this.rEm = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.h(paramContext.getResources(), au.h.app_brand_show_toast_success);
    this.rEn.setVisibility(0);
    this.rEn.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.rEn.setImageDrawable(paramContext);
    AppMethodBeat.o(51450);
  }
  
  public final c T(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(51448);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label144;
      }
      this.rEm.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.rEm;
      View localView = getContentView();
      p.j(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.ci.a.fromDPToPix(localView.getContext(), 18)));
      this.rEm.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.rEm.setVisibility(0);
      paramCharSequence = getContentView();
      p.j(paramCharSequence, "contentView");
      i = com.tencent.mm.ci.a.fromDPToPix(paramCharSequence.getContext(), 27);
      getContentView().findViewById(au.f.show_toast_view_container).setPadding(0, i, 0, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(51448);
      return this;
      i = 0;
      break;
      label144:
      this.rEm.setVisibility(4);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(51449);
    Object localObject = getContentView();
    p.j(localObject, "contentView");
    localObject = com.tencent.mm.ui.statusbar.d.lz(((View)localObject).getContext());
    if (localObject != null)
    {
      super.showAtLocation(((Activity)localObject).findViewById(16908290), 17, 0, 0);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(this), 1500L);
      AppMethodBeat.o(51449);
      return;
    }
    AppMethodBeat.o(51449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.c
 * JD-Core Version:    0.7.0.1
 */