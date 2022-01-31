package com.tencent.mm.plugin.appbrand.widget.f;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.o;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c
  extends o
{
  private final TextView jum;
  private final ImageView jun;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135265);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, 2130968739, (ViewGroup)localObject);
    setContentView((View)localObject);
    localObject = getContentView().findViewById(2131821404);
    j.p(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(2131821405);
    j.p(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.jun = ((ImageView)localObject);
    localObject = getContentView().findViewById(2131820680);
    j.p(localObject, "contentView.findViewById(R.id.title)");
    this.jum = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.g(paramContext.getResources(), 2131230888);
    this.jun.setVisibility(0);
    this.jun.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jun.setImageDrawable(paramContext);
    AppMethodBeat.o(135265);
  }
  
  public final c D(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135263);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label143;
      }
      this.jum.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.jum;
      View localView = getContentView();
      j.p(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.cb.a.fromDPToPix(localView.getContext(), 18)));
      this.jum.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.jum.setVisibility(0);
      paramCharSequence = getContentView();
      j.p(paramCharSequence, "contentView");
      i = com.tencent.mm.cb.a.fromDPToPix(paramCharSequence.getContext(), 27);
      getContentView().findViewById(2131821403).setPadding(0, i, 0, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(135263);
      return this;
      i = 0;
      break;
      label143:
      this.jum.setVisibility(4);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(135264);
    Object localObject = getContentView();
    j.p(localObject, "contentView");
    localObject = com.tencent.mm.ui.statusbar.d.iB(((View)localObject).getContext());
    if (localObject != null)
    {
      super.showAtLocation(((Activity)localObject).findViewById(16908290), 17, 0, 0);
      al.p((Runnable)new d(this), 1500L);
      AppMethodBeat.o(135264);
      return;
    }
    AppMethodBeat.o(135264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.c
 * JD-Core Version:    0.7.0.1
 */