package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", "init", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
public final class MPVideoErrorView
  extends RelativeLayout
{
  private final String TAG;
  View gvQ;
  TextView pIG;
  ImageView pIH;
  
  public MPVideoErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7252);
    this.TAG = "MicroMsg.MPVideoErrorView";
    View.inflate(paramContext, 2131495696, (ViewGroup)this);
    paramContext = findViewById(2131297616);
    p.g(paramContext, "findViewById(R.id.biz_video_play_err_info_tv)");
    this.pIG = ((TextView)paramContext);
    paramContext = findViewById(2131297615);
    p.g(paramContext, "findViewById(R.id.biz_video_play_err_info_iv)");
    this.pIH = ((ImageView)paramContext);
    paramContext = findViewById(2131307157);
    p.g(paramContext, "findViewById(R.id.root)");
    this.gvQ = paramContext;
    AppMethodBeat.o(7252);
  }
  
  public final void setCigError$505cff1c(String paramString)
  {
    AppMethodBeat.i(258334);
    this.pIH.setBackgroundResource(2131231373);
    if (!Util.isNullOrNil(paramString)) {
      this.pIG.setText((CharSequence)(getContext().getString(2131763170) + ' ' + paramString));
    }
    for (;;)
    {
      this.gvQ.setClickable(true);
      AppMethodBeat.o(258334);
      return;
      this.pIG.setText((CharSequence)getContext().getString(2131763170));
    }
  }
  
  public final void setPlayError$505cff1c(String paramString)
  {
    AppMethodBeat.i(7250);
    this.pIH.setBackgroundResource(2131231367);
    this.pIG.setText((CharSequence)paramString);
    this.gvQ.setClickable(false);
    AppMethodBeat.o(7250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView
 * JD-Core Version:    0.7.0.1
 */