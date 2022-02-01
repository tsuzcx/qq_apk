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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.ui.aq;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView
  extends RelativeLayout
{
  private final String TAG;
  private final ImageView hdP;
  private final ViewGroup hdQ;
  private final ImageView hdR;
  private final ViewGroup hdS;
  private final ImageView hdT;
  private final ViewGroup hdU;
  private final TextView hdV;
  private c hdW;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216599);
    AppMethodBeat.o(216599);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216598);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, 2131496327, (ViewGroup)this);
    paramAttributeSet = findViewById(2131307653);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.hdP = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307654);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.hdR = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307655);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.hdT = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307656);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.hdQ = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307657);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.hdS = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307658);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.hdU = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307659);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.hdV = ((TextView)paramAttributeSet);
    setPadding(aq.fromDPToPix(paramContext, 4), aq.fromDPToPix(paramContext, 4), aq.fromDPToPix(paramContext, 4), aq.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(2131234923));
    paramAttributeSet = this.hdV;
    ad localad = ad.Njc;
    paramContext = paramContext.getResources().getString(2131766623);
    p.g(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    p.g(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.pK(2131690013);
    this.hdW = paramContext.aJu();
    AppMethodBeat.o(216598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */