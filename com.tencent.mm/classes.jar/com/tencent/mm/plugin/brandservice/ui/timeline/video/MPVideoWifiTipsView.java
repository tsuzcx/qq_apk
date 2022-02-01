package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "tipsTv", "Landroid/widget/TextView;", "getSizeMB", "bytes", "", "cRound", "", "setTipsText", "", "fileSize", "wordingType", "", "Companion", "plugin-brandservice_release"})
public final class MPVideoWifiTipsView
  extends RelativeLayout
{
  public static final a nkx;
  private final String TAG;
  private TextView nkw;
  
  static
  {
    AppMethodBeat.i(175527);
    nkx = new a((byte)0);
    AppMethodBeat.o(175527);
  }
  
  public MPVideoWifiTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7273);
    this.TAG = "MicroMsg.MPVideoWifiTipsView";
    View.inflate(paramContext, 2131494958, (ViewGroup)this);
    paramContext = findViewById(2131297406);
    k.g(paramContext, "findViewById(R.id.biz_video_wifi_tips_tv)");
    this.nkw = ((TextView)paramContext);
    AppMethodBeat.o(7273);
  }
  
  private static String nJ(long paramLong)
  {
    AppMethodBeat.i(7272);
    double d = Math.round(paramLong * 10.0D / 1048576.0D) / 10.0D;
    AppMethodBeat.o(7272);
    return String.valueOf(d);
  }
  
  public final void p(long paramLong, int paramInt)
  {
    AppMethodBeat.i(175526);
    if (paramInt == 2) {}
    for (String str = getContext().getString(2131756664, new Object[] { nJ(paramLong) });; str = getContext().getString(2131756663))
    {
      this.nkw.setText((CharSequence)str);
      AppMethodBeat.o(175526);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView$Companion;", "", "()V", "canShowWording1OnFirstPlay", "", "showWifiTipsFlag", "", "canShowWording2OnFirstPlay", "canShowWording2OnNetChange", "plugin-brandservice_release"})
  public static final class a
  {
    public static boolean yv(int paramInt)
    {
      return (paramInt & 0x1) != 0;
    }
    
    public static boolean yw(int paramInt)
    {
      return (paramInt & 0x2) != 0;
    }
    
    public static boolean yx(int paramInt)
    {
      return (paramInt & 0x4) != 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWifiTipsView
 * JD-Core Version:    0.7.0.1
 */