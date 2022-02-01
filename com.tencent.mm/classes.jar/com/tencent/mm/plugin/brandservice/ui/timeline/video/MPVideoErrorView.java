package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", "init", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
public final class MPVideoErrorView
  extends RelativeLayout
{
  private final String TAG;
  View frN;
  TextView njU;
  ImageView njV;
  
  public MPVideoErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7252);
    this.TAG = "MicroMsg.MPVideoErrorView";
    View.inflate(paramContext, 2131494953, (ViewGroup)this);
    paramContext = findViewById(2131297398);
    k.g(paramContext, "findViewById(R.id.biz_video_play_err_info_tv)");
    this.njU = ((TextView)paramContext);
    paramContext = findViewById(2131297397);
    k.g(paramContext, "findViewById(R.id.biz_video_play_err_info_iv)");
    this.njV = ((ImageView)paramContext);
    paramContext = findViewById(2131304239);
    k.g(paramContext, "findViewById(R.id.root)");
    this.frN = paramContext;
    AppMethodBeat.o(7252);
  }
  
  public final void setCigError$505cff1c(String paramString)
  {
    AppMethodBeat.i(205025);
    this.njV.setBackgroundResource(2131231310);
    if (!bt.isNullOrNil(paramString)) {
      this.njU.setText((CharSequence)(getContext().getString(2131761343) + ' ' + paramString));
    }
    for (;;)
    {
      this.frN.setClickable(true);
      AppMethodBeat.o(205025);
      return;
      this.njU.setText((CharSequence)getContext().getString(2131761343));
    }
  }
  
  public final void setPlayError$505cff1c(String paramString)
  {
    AppMethodBeat.i(7250);
    this.njV.setBackgroundResource(2131231304);
    this.njU.setText((CharSequence)paramString);
    this.frN.setClickable(false);
    AppMethodBeat.o(7250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView
 * JD-Core Version:    0.7.0.1
 */