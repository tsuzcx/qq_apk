package com.tencent.mm.plugin.appbrand.widget.h;

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
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.v;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "getMMessageText", "()Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends v
{
  private final TextView uPD;
  private final ImageView uPE;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51450);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, ba.g.app_brand_show_toast, (ViewGroup)localObject);
    ah localah = ah.aiuX;
    setContentView((View)localObject);
    getContentView().findViewById(ba.f.progress).setVisibility(8);
    localObject = getContentView().findViewById(ba.f.iv_icon);
    s.s(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.uPE = ((ImageView)localObject);
    localObject = getContentView().findViewById(ba.f.title);
    s.s(localObject, "contentView.findViewById(R.id.title)");
    this.uPD = ((TextView)localObject);
    paramContext = com.tencent.mm.svg.a.a.i(paramContext.getResources(), ba.h.app_brand_show_toast_success);
    this.uPE.setVisibility(0);
    this.uPE.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.uPE.setImageDrawable(paramContext);
    setFocusable(true);
    getContentView().setFocusable(true);
    this.uPD.setFocusable(true);
    AppMethodBeat.o(51450);
  }
  
  public final c X(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(51448);
    int i;
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label131;
      }
      this.uPD.setLineSpacing(0.0F, 1.0F);
      this.uPD.setSpannableFactory((Spannable.Factory)new e(com.tencent.mm.cd.a.fromDPToPix(getContentView().getContext(), 18)));
      this.uPD.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.uPD.setVisibility(0);
      i = com.tencent.mm.cd.a.fromDPToPix(getContentView().getContext(), 27);
      getContentView().findViewById(ba.f.show_toast_view_container).setPadding(0, i, 0, 0);
      this.uPD.setContentDescription(paramCharSequence);
    }
    for (;;)
    {
      AppMethodBeat.o(51448);
      return this;
      i = 0;
      break;
      label131:
      this.uPD.setVisibility(4);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(51449);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(getContentView().getContext());
    if (localActivity != null)
    {
      super.showAtLocation(localActivity.findViewById(16908290), 17, 0, 0);
      this.uPD.requestFocus();
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(this), 1500L);
    }
    AppMethodBeat.o(51449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.c
 * JD-Core Version:    0.7.0.1
 */