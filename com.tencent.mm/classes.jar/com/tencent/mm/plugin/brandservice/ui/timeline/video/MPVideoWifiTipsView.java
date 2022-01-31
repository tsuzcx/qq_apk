package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "coverIv", "Landroid/widget/ImageView;", "playBtn", "Landroid/widget/Button;", "tipsTv", "Landroid/widget/TextView;", "getCoverIv", "getSizeMB", "bytes", "", "cRound", "", "setStillPlayingOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "setTipsText", "fileSize", "netChange", "", "plugin-brandservice_release"})
public final class MPVideoWifiTipsView
  extends RelativeLayout
{
  private final String TAG;
  private TextView iEo;
  private Button kgZ;
  private ImageView kha;
  
  public MPVideoWifiTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152892);
    this.TAG = "MicroMsg.MPVideoWifiTipsView";
    View.inflate(paramContext, 2130970312, (ViewGroup)this);
    paramContext = findViewById(2131826385);
    j.p(paramContext, "findViewById(R.id.biz_video_wifi_tips_tv)");
    this.iEo = ((TextView)paramContext);
    paramContext = findViewById(2131826386);
    j.p(paramContext, "findViewById(R.id.biz_video_wifi_tips_btn)");
    this.kgZ = ((Button)paramContext);
    paramContext = findViewById(2131826384);
    j.p(paramContext, "findViewById(R.id.mp_video_wifi_tips_cover_iv)");
    this.kha = ((ImageView)paramContext);
    setOnClickListener((View.OnClickListener)MPVideoWifiTipsView.1.khb);
    AppMethodBeat.o(152892);
  }
  
  private static String ib(long paramLong)
  {
    AppMethodBeat.i(152891);
    double d = Math.round(paramLong * 10.0D / 1048576.0D) / 10.0D;
    AppMethodBeat.o(152891);
    return String.valueOf(d);
  }
  
  public final ImageView getCoverIv()
  {
    return this.kha;
  }
  
  public final void n(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(152889);
    Object localObject = getContext().getString(2131297743, new Object[] { ib(paramLong) });
    this.iEo.setText((CharSequence)localObject);
    Button localButton = this.kgZ;
    if (paramBoolean) {}
    for (localObject = (CharSequence)getContext().getString(2131297742);; localObject = (CharSequence)getContext().getString(2131297741))
    {
      localButton.setText((CharSequence)localObject);
      AppMethodBeat.o(152889);
      return;
    }
  }
  
  public final void setStillPlayingOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(152890);
    j.q(paramOnClickListener, "l");
    this.kgZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(152890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWifiTipsView
 * JD-Core Version:    0.7.0.1
 */