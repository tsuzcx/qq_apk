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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.ui.aw;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView
  extends RelativeLayout
{
  private final String TAG;
  private final ImageView kLd;
  private final ViewGroup kLe;
  private final ImageView kLf;
  private final ViewGroup kLg;
  private final ImageView kLh;
  private final ViewGroup kLi;
  private final TextView kLj;
  private c kLk;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(202043);
    AppMethodBeat.o(202043);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(202039);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, b.f.live_member_view, (ViewGroup)this);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon1);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.kLd = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon2);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.kLf = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon3);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.kLh = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon_group1);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.kLe = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon_group2);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.kLg = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon_group3);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.kLi = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_count_tv);
    p.j(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.kLj = ((TextView)paramAttributeSet);
    setPadding(aw.fromDPToPix(paramContext, 4), aw.fromDPToPix(paramContext, 4), aw.fromDPToPix(paramContext, 4), aw.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(b.d.live_member_bg));
    paramAttributeSet = this.kLj;
    af localaf = af.aaBG;
    paramContext = paramContext.getResources().getString(b.h.live_member_count);
    p.j(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    p.j(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.wy(b.g.default_avatar);
    this.kLk = paramContext.bmL();
    AppMethodBeat.o(202039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */