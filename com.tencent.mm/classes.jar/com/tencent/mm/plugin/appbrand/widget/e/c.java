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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c
  extends o
{
  private final TextView mkr;
  private final ImageView mks;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51450);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, 2131493061, (ViewGroup)localObject);
    setContentView((View)localObject);
    localObject = getContentView().findViewById(2131303515);
    k.g(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(2131301215);
    k.g(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.mks = ((ImageView)localObject);
    localObject = getContentView().findViewById(2131305902);
    k.g(localObject, "contentView.findViewById(R.id.title)");
    this.mkr = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.g(paramContext.getResources(), 2131689649);
    this.mks.setVisibility(0);
    this.mks.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.mks.setImageDrawable(paramContext);
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
      this.mkr.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.mkr;
      View localView = getContentView();
      k.g(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.cd.a.fromDPToPix(localView.getContext(), 18)));
      this.mkr.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.mkr.setVisibility(0);
      paramCharSequence = getContentView();
      k.g(paramCharSequence, "contentView");
      i = com.tencent.mm.cd.a.fromDPToPix(paramCharSequence.getContext(), 27);
      getContentView().findViewById(2131304793).setPadding(0, i, 0, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(51448);
      return this;
      i = 0;
      break;
      label143:
      this.mkr.setVisibility(4);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(51449);
    Object localObject = getContentView();
    k.g(localObject, "contentView");
    localObject = com.tencent.mm.ui.statusbar.d.kd(((View)localObject).getContext());
    if (localObject != null)
    {
      super.showAtLocation(((Activity)localObject).findViewById(16908290), 17, 0, 0);
      aq.n((Runnable)new d(this), 1500L);
      AppMethodBeat.o(51449);
      return;
    }
    AppMethodBeat.o(51449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.c
 * JD-Core Version:    0.7.0.1
 */