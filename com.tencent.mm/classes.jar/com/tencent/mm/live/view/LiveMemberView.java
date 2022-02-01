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
import com.tencent.mm.ui.at;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarGroup1", "Landroid/view/ViewGroup;", "avatarGroup2", "avatarGroup3", "avatarIcon1", "Landroid/widget/ImageView;", "avatarIcon2", "avatarIcon3", "loaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "memberCountTv", "Landroid/widget/TextView;", "updateMemberInfo", "", "headImgList", "", "onlineCount", "plugin-logic_release"})
public final class LiveMemberView
  extends RelativeLayout
{
  private final String TAG;
  private final ImageView hWB;
  private final ViewGroup hWC;
  private final ImageView hWD;
  private final ViewGroup hWE;
  private final ImageView hWF;
  private final ViewGroup hWG;
  private final TextView hWH;
  private c hWI;
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208564);
    AppMethodBeat.o(208564);
  }
  
  public LiveMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208563);
    this.TAG = "MicoroMSg.LiveMemberView";
    View.inflate(paramContext, 2131495267, (ViewGroup)this);
    paramAttributeSet = findViewById(2131303432);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon1)");
    this.hWB = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131303433);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon2)");
    this.hWD = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131303434);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon3)");
    this.hWF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131303435);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group1)");
    this.hWC = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131303436);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group2)");
    this.hWE = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131303437);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_avatar_icon_group3)");
    this.hWG = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131303439);
    p.g(paramAttributeSet, "findViewById(R.id.live_member_count_tv)");
    this.hWH = ((TextView)paramAttributeSet);
    setPadding(at.fromDPToPix(paramContext, 4), at.fromDPToPix(paramContext, 4), at.fromDPToPix(paramContext, 4), at.fromDPToPix(paramContext, 4));
    setBackground(paramContext.getResources().getDrawable(2131233484));
    paramAttributeSet = this.hWH;
    ae localae = ae.SYK;
    paramContext = paramContext.getResources().getString(2131762313);
    p.g(paramContext, "context.resources.getStr…string.live_member_count)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { Integer.valueOf(0) }, 1));
    p.g(paramContext, "java.lang.String.format(format, *args)");
    paramAttributeSet.setText((CharSequence)paramContext);
    paramContext = new c.a();
    paramContext.ty(2131690042);
    this.hWI = paramContext.bdv();
    AppMethodBeat.o(208563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveMemberView
 * JD-Core Version:    0.7.0.1
 */