package com.tencent.mm.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.ui.aq;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView
  extends RelativeLayout
{
  private final String TAG;
  private final ImageView hbb;
  private final ViewGroup hbc;
  private final ImageView hbd;
  private final ViewGroup hbe;
  private final ImageView hbf;
  private final ViewGroup hbg;
  private final TextView hbh;
  private c hbi;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(212969);
    AppMethodBeat.o(212969);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212968);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, 2131496327, (ViewGroup)this);
    paramAttributeSet = findViewById(2131307653);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.hbb = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307654);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.hbd = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307655);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.hbf = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307656);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.hbc = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307657);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.hbe = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307658);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.hbg = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307659);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.hbh = ((TextView)paramAttributeSet);
    setPadding(aq.fromDPToPix(paramContext, 4), aq.fromDPToPix(paramContext, 4), aq.fromDPToPix(paramContext, 4), aq.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(2131234923));
    paramAttributeSet = this.hbh;
    ad localad = ad.MLZ;
    paramContext = paramContext.getResources().getString(2131766623);
    p.g(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    p.g(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.pH(2131690013);
    this.hbi = paramContext.aJc();
    AppMethodBeat.o(212968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */