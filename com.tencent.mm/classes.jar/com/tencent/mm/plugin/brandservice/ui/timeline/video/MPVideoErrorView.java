package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", "init", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
public final class MPVideoErrorView
  extends RelativeLayout
{
  private final String TAG;
  View fQH;
  TextView ovl;
  ImageView ovm;
  
  public MPVideoErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7252);
    this.TAG = "MicroMsg.MPVideoErrorView";
    View.inflate(paramContext, 2131494953, (ViewGroup)this);
    paramContext = findViewById(2131297398);
    p.g(paramContext, "findViewById(R.id.biz_video_play_err_info_tv)");
    this.ovl = ((TextView)paramContext);
    paramContext = findViewById(2131297397);
    p.g(paramContext, "findViewById(R.id.biz_video_play_err_info_iv)");
    this.ovm = ((ImageView)paramContext);
    paramContext = findViewById(2131304239);
    p.g(paramContext, "findViewById(R.id.root)");
    this.fQH = paramContext;
    AppMethodBeat.o(7252);
  }
  
  public final void setCigError$505cff1c(String paramString)
  {
    AppMethodBeat.i(224147);
    this.ovm.setBackgroundResource(2131231310);
    if (!bu.isNullOrNil(paramString)) {
      this.ovl.setText((CharSequence)(getContext().getString(2131761343) + ' ' + paramString));
    }
    for (;;)
    {
      this.fQH.setClickable(true);
      AppMethodBeat.o(224147);
      return;
      this.ovl.setText((CharSequence)getContext().getString(2131761343));
    }
  }
  
  public final void setPlayError$505cff1c(String paramString)
  {
    AppMethodBeat.i(7250);
    this.ovm.setBackgroundResource(2131231304);
    this.ovl.setText((CharSequence)paramString);
    this.fQH.setClickable(false);
    AppMethodBeat.o(7250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView
 * JD-Core Version:    0.7.0.1
 */