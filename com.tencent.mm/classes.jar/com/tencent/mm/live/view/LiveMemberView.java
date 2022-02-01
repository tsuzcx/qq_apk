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
import com.tencent.mm.ui.ao;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView
  extends RelativeLayout
{
  private final ImageView KAJ;
  private final ViewGroup KAK;
  private final ImageView KAL;
  private final ViewGroup KAM;
  private final ImageView KAN;
  private final ViewGroup KAO;
  private final TextView KAP;
  private c KAQ;
  private final String TAG;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203451);
    AppMethodBeat.o(203451);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203450);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, 2131496318, (ViewGroup)this);
    paramAttributeSet = findViewById(2131307570);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.KAJ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307571);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.KAL = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307572);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.KAN = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131307573);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.KAK = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307574);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.KAM = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307575);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.KAO = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131307576);
    k.g(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.KAP = ((TextView)paramAttributeSet);
    setPadding(ao.fromDPToPix(paramContext, 4), ao.fromDPToPix(paramContext, 4), ao.fromDPToPix(paramContext, 4), ao.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(2131234914));
    paramAttributeSet = this.KAP;
    z localz = z.Jhz;
    paramContext = paramContext.getResources().getString(2131766591);
    k.g(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    k.g(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.oq(2131690013);
    this.KAQ = paramContext.azc();
    AppMethodBeat.o(203450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */