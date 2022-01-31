package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", "init", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "aniHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
public final class MPVideoErrorView
  extends RelativeLayout
{
  private final String TAG;
  ImageView kgA;
  View kgr;
  TextView kgz;
  
  public MPVideoErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(15250);
    this.TAG = "MicroMsg.MPVideoErrorView";
    View.inflate(paramContext, 2130970309, (ViewGroup)this);
    paramContext = findViewById(2131826360);
    j.p(paramContext, "findViewById(R.id.biz_video_play_err_info_tv)");
    this.kgz = ((TextView)paramContext);
    paramContext = findViewById(2131826359);
    j.p(paramContext, "findViewById(R.id.biz_video_play_err_info_iv)");
    this.kgA = ((ImageView)paramContext);
    paramContext = findViewById(2131821003);
    j.p(paramContext, "findViewById(R.id.root)");
    this.kgr = paramContext;
    AppMethodBeat.o(15250);
  }
  
  public final void setCigError$505cff1c(String paramString)
  {
    AppMethodBeat.i(156912);
    this.kgA.setBackgroundResource(2130838005);
    if (!bo.isNullOrNil(paramString)) {
      this.kgz.setText((CharSequence)(getContext().getString(2131301634) + ' ' + paramString));
    }
    for (;;)
    {
      this.kgr.setClickable(true);
      AppMethodBeat.o(156912);
      return;
      this.kgz.setText((CharSequence)getContext().getString(2131301634));
    }
  }
  
  public final void setPlayError$505cff1c(String paramString)
  {
    AppMethodBeat.i(15248);
    this.kgA.setBackgroundResource(2130837999);
    this.kgz.setText((CharSequence)paramString);
    this.kgr.setClickable(false);
    AppMethodBeat.o(15248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView
 * JD-Core Version:    0.7.0.1
 */