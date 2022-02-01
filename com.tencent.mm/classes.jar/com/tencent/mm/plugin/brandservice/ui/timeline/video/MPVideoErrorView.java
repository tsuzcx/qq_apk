package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "errIv", "Landroid/widget/ImageView;", "errTv", "Landroid/widget/TextView;", "root", "Landroid/view/View;", "init", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setCigError", "errMsg", "errCode", "", "setPlayError", "plugin-brandservice_release"})
public final class MPVideoErrorView
  extends RelativeLayout
{
  private final String TAG;
  View fOB;
  TextView opt;
  ImageView opu;
  
  public MPVideoErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7252);
    this.TAG = "MicroMsg.MPVideoErrorView";
    View.inflate(paramContext, 2131494953, (ViewGroup)this);
    paramContext = findViewById(2131297398);
    p.g(paramContext, "findViewById(R.id.biz_video_play_err_info_tv)");
    this.opt = ((TextView)paramContext);
    paramContext = findViewById(2131297397);
    p.g(paramContext, "findViewById(R.id.biz_video_play_err_info_iv)");
    this.opu = ((ImageView)paramContext);
    paramContext = findViewById(2131304239);
    p.g(paramContext, "findViewById(R.id.root)");
    this.fOB = paramContext;
    AppMethodBeat.o(7252);
  }
  
  public final void setCigError$505cff1c(String paramString)
  {
    AppMethodBeat.i(221702);
    this.opu.setBackgroundResource(2131231310);
    if (!bt.isNullOrNil(paramString)) {
      this.opt.setText((CharSequence)(getContext().getString(2131761343) + ' ' + paramString));
    }
    for (;;)
    {
      this.fOB.setClickable(true);
      AppMethodBeat.o(221702);
      return;
      this.opt.setText((CharSequence)getContext().getString(2131761343));
    }
  }
  
  public final void setPlayError$505cff1c(String paramString)
  {
    AppMethodBeat.i(7250);
    this.opu.setBackgroundResource(2131231304);
    this.opt.setText((CharSequence)paramString);
    this.fOB.setClickable(false);
    AppMethodBeat.o(7250);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(MPVideoErrorView paramMPVideoErrorView, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7249);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.opv.setVisibility(8);
      this.opw.bRi();
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoErrorView
 * JD-Core Version:    0.7.0.1
 */