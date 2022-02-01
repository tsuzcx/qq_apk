package com.tencent.mm.plugin.appbrand.widget.f;

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
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.ui.base.p
{
  private final TextView oBD;
  private final ImageView oBE;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51450);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, 2131493100, (ViewGroup)localObject);
    setContentView((View)localObject);
    localObject = getContentView().findViewById(2131306281);
    kotlin.g.b.p.g(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(2131302896);
    kotlin.g.b.p.g(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.oBE = ((ImageView)localObject);
    localObject = getContentView().findViewById(2131309195);
    kotlin.g.b.p.g(localObject, "contentView.findViewById(R.id.title)");
    this.oBD = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.h(paramContext.getResources(), 2131689656);
    this.oBE.setVisibility(0);
    this.oBE.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.oBE.setImageDrawable(paramContext);
    AppMethodBeat.o(51450);
  }
  
  public final c K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(51448);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label143;
      }
      this.oBD.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.oBD;
      View localView = getContentView();
      kotlin.g.b.p.g(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.cb.a.fromDPToPix(localView.getContext(), 18)));
      this.oBD.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.oBD.setVisibility(0);
      paramCharSequence = getContentView();
      kotlin.g.b.p.g(paramCharSequence, "contentView");
      i = com.tencent.mm.cb.a.fromDPToPix(paramCharSequence.getContext(), 27);
      getContentView().findViewById(2131307875).setPadding(0, i, 0, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(51448);
      return this;
      i = 0;
      break;
      label143:
      this.oBD.setVisibility(4);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(51449);
    Object localObject = getContentView();
    kotlin.g.b.p.g(localObject, "contentView");
    localObject = com.tencent.mm.ui.statusbar.d.kD(((View)localObject).getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.c
 * JD-Core Version:    0.7.0.1
 */