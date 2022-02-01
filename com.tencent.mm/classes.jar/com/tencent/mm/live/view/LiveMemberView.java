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
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.ui.bd;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveMemberView
  extends RelativeLayout
{
  private final String TAG;
  private final ImageView nng;
  private final ViewGroup nnh;
  private final ImageView nni;
  private final ViewGroup nnj;
  private final ImageView nnk;
  private final ViewGroup nnl;
  private final TextView nnm;
  private c nnn;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246163);
    AppMethodBeat.o(246163);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246160);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, b.f.live_member_view, (ViewGroup)this);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon1);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.nng = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon2);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.nni = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon3);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.nnk = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon_group1);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.nnh = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon_group2);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.nnj = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_avatar_icon_group3);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.nnl = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(b.e.live_member_count_tv);
    s.s(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.nnm = ((TextView)paramAttributeSet);
    setPadding(bd.fromDPToPix(paramContext, 4), bd.fromDPToPix(paramContext, 4), bd.fromDPToPix(paramContext, 4), bd.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(b.d.live_member_bg));
    paramAttributeSet = this.nnm;
    am localam = am.aixg;
    paramContext = paramContext.getResources().getString(b.h.live_member_count);
    s.s(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    s.s(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.oKB = b.g.default_avatar;
    this.nnn = paramContext.bKx();
    AppMethodBeat.o(246160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */