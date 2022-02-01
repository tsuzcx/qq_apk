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
import com.tencent.mm.ui.ao;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView
  extends RelativeLayout
{
  private final String TAG;
  private final ImageView gHr;
  private final ViewGroup gHs;
  private final ImageView gHt;
  private final ViewGroup gHu;
  private final ImageView gHv;
  private final ViewGroup gHw;
  private final TextView gHx;
  private c gHy;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190679);
    AppMethodBeat.o(190679);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190678);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, 2131496327, (ViewGroup)this);
    paramAttributeSet = findViewById(2131307653);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.gHr = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307654);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.gHt = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307655);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.gHv = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307656);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.gHs = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307657);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.gHu = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307658);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.gHw = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307659);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.gHx = ((TextView)paramAttributeSet);
    setPadding(ao.fromDPToPix(paramContext, 4), ao.fromDPToPix(paramContext, 4), ao.fromDPToPix(paramContext, 4), ao.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(2131234923));
    paramAttributeSet = this.gHx;
    z localz = z.KUT;
    paramContext = paramContext.getResources().getString(2131766623);
    k.g(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    k.g(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.pe(2131690013);
    this.gHy = paramContext.aFT();
    AppMethodBeat.o(190678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */