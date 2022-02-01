package com.tencent.mm.plugin.finder.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isHighLightWord", "", "(Landroid/view/View;Z)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "infoLayout", "Landroid/widget/LinearLayout;", "()Z", "professionTV", "titleTV", "userOnLive", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "adjustTitleTvSize", "", "getHighLightColor", "color", "onBindView", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "itemClickListener", "Landroid/view/View$OnClickListener;", "itemLongCLickListener", "Landroid/view/View$OnLongClickListener;", "needDivider", "plugin-finder_release"})
public final class c
  extends RecyclerView.v
{
  private TextView Abd;
  private LinearLayout Abe;
  private TextView Abf;
  private View Abg;
  private ImageView Abh;
  private FinderLiveOnliveWidget Abi;
  private final boolean Abj;
  private final String TAG;
  private ImageView iZG;
  private View mND;
  private TextView mNb;
  private TextView wSo;
  private TextView wSq;
  
  public c(View paramView, boolean paramBoolean)
  {
    super(paramView);
    AppMethodBeat.i(268533);
    this.Abj = paramBoolean;
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(b.f.divider_view);
    p.j(localView, "itemView.findViewById(R.id.divider_view)");
    this.mND = localView;
    localView = paramView.findViewById(b.f.avatar_iv);
    p.j(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.iZG = ((ImageView)localView);
    localView = paramView.findViewById(b.f.title_tv);
    p.j(localView, "itemView.findViewById(R.id.title_tv)");
    this.mNb = ((TextView)localView);
    localView = paramView.findViewById(b.f.follow_tv);
    p.j(localView, "itemView.findViewById(R.id.follow_tv)");
    this.Abd = ((TextView)localView);
    localView = paramView.findViewById(b.f.info_layout);
    p.j(localView, "itemView.findViewById(R.id.info_layout)");
    this.Abe = ((LinearLayout)localView);
    localView = paramView.findViewById(b.f.profession_tv);
    p.j(localView, "itemView.findViewById(R.id.profession_tv)");
    this.Abf = ((TextView)localView);
    localView = paramView.findViewById(b.f.desc_1_tv);
    p.j(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.wSo = ((TextView)localView);
    localView = paramView.findViewById(b.f.desc_2_tv);
    p.j(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.wSq = ((TextView)localView);
    localView = paramView.findViewById(b.f.follow_layout);
    p.j(localView, "itemView.findViewById(R.id.follow_layout)");
    this.Abg = localView;
    localView = paramView.findViewById(b.f.auth_icon_iv);
    p.j(localView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.Abh = ((ImageView)localView);
    paramView = paramView.findViewById(b.f.finder_live_onlive_widget);
    p.j(paramView, "itemView.findViewById(R.…inder_live_onlive_widget)");
    this.Abi = ((FinderLiveOnliveWidget)paramView);
    this.Abi.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243459);
        Object localObject1 = new Rect();
        c.a(this.Abk).getHitRect((Rect)localObject1);
        Object localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_0_5_A);
        ((Rect)localObject1).inset(-i, -i);
        localObject2 = c.a(this.Abk).getParent();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(243459);
          throw ((Throwable)localObject1);
        }
        ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)c.a(this.Abk)));
        AppMethodBeat.o(243459);
      }
    });
    AppMethodBeat.o(268533);
  }
  
  private final String aEl(String paramString)
  {
    if (!this.Abj) {
      return paramString;
    }
    return "";
  }
  
  private final void dQM()
  {
    AppMethodBeat.i(268532);
    this.mNb.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(this));
    AppMethodBeat.o(268532);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final bip parambip, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(268530);
    p.k(parambip, "finderSearchInfo");
    p.k(paramOnClickListener, "itemClickListener");
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    label168:
    label184:
    int i;
    if (paramBoolean)
    {
      this.mND.setVisibility(0);
      localObject3 = this.mNb;
      localObject4 = MMApplicationContext.getContext();
      localObject1 = j.Acs;
      localObject2 = parambip.SSR;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = af.aaBG;
      localObject2 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & this.mNb.getCurrentTextColor()) }, 1));
      p.j(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject4, (CharSequence)j.bZ((String)localObject1, aEl((String)localObject2)), this.mNb.getTextSize()));
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject1 = parambip.contact;
      if (localObject1 == null) {
        break label624;
      }
      localObject1 = ((FinderContact)localObject1).username;
      if (!d.a.aAN((String)localObject1)) {
        break label630;
      }
      this.Abd.setVisibility(0);
      if (parambip.friendFollowCount <= 0) {
        break label724;
      }
      this.Abg.setVisibility(0);
      localObject3 = "";
      localObject4 = "";
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (parambip.friendFollowCount > 0)
      {
        if (Util.isNullOrNil("")) {
          break label642;
        }
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        localObject2 = ((View)localObject1).getContext().getString(b.j.finder_friend_follow, new Object[] { m.QF(parambip.friendFollowCount) });
        p.j(localObject2, "itemView.context.getStri…hInfo.friendFollowCount))");
        localObject1 = localObject3;
      }
      label282:
      if (Util.isNullOrNil((String)localObject1)) {
        break label697;
      }
      this.wSo.setText((CharSequence)localObject1);
      this.wSo.setVisibility(0);
      label310:
      if (Util.isNullOrNil((String)localObject2)) {
        break label709;
      }
      this.wSq.setText((CharSequence)localObject2);
      this.wSq.setVisibility(0);
      i = 2;
      label341:
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject1 = parambip.contact;
      if (localObject1 == null) {
        break label739;
      }
      localObject1 = ((FinderContact)localObject1).headUrl;
      label369:
      localObject1 = new e((String)localObject1);
      localObject3 = this.iZG;
      localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject1 = parambip.contact;
      if (localObject1 == null) {
        break label954;
      }
      localObject1 = ((FinderContact)localObject1).authInfo;
      if (localObject1 == null) {
        break label954;
      }
      localObject2 = aj.AGc;
      aj.a(this.Abh, (FinderAuthInfo)localObject1);
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        this.Abh.setVisibility(8);
        this.Abf.setVisibility(8);
        label502:
        localObject1 = this.amk;
        p.j(localObject1, "itemView");
        ((View)localObject1).setTag(parambip);
        this.amk.setOnClickListener(paramOnClickListener);
        this.amk.setOnLongClickListener(paramOnLongClickListener);
        if (i <= 2)
        {
          this.Abe.setGravity(16);
          label552:
          paramOnClickListener = parambip.contact;
          if ((paramOnClickListener == null) || (paramOnClickListener.liveStatus != 1)) {
            break label994;
          }
          this.Abi.setVisibility(0);
          paramOnClickListener = this.Abi;
          if (paramOnClickListener != null) {
            paramOnClickListener.setOnClickListener((View.OnClickListener)new b(this, parambip));
          }
        }
        break;
      }
    }
    for (;;)
    {
      dQM();
      AppMethodBeat.o(268530);
      return;
      this.mND.setVisibility(8);
      break;
      label624:
      localObject1 = null;
      break label168;
      label630:
      this.Abd.setVisibility(8);
      break label184;
      label642:
      localObject1 = this.amk;
      p.j(localObject1, "itemView");
      localObject1 = ((View)localObject1).getContext().getString(b.j.finder_friend_follow, new Object[] { m.QF(parambip.friendFollowCount) });
      p.j(localObject1, "itemView.context.getStri…hInfo.friendFollowCount))");
      localObject2 = localObject4;
      break label282;
      label697:
      this.wSo.setVisibility(8);
      break label310;
      label709:
      this.wSq.setVisibility(8);
      i = 2;
      break label341;
      label724:
      this.Abg.setVisibility(8);
      i = 1;
      break label341;
      label739:
      localObject1 = null;
      break label369;
      this.Abh.setVisibility(0);
      this.Abf.setVisibility(0);
      if (Util.isNullOrNil(parambip.SST)) {
        this.Abf.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject3 = this.Abf;
        localObject4 = MMApplicationContext.getContext();
        localObject1 = j.Acs;
        localObject2 = parambip.SST;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = af.aaBG;
        localObject2 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & this.Abf.getCurrentTextColor()) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject4, (CharSequence)j.bZ((String)localObject1, aEl((String)localObject2)), this.Abf.getTextSize()));
      }
      this.Abh.setVisibility(0);
      this.Abf.setVisibility(8);
      break label502;
      this.Abh.setVisibility(8);
      this.Abf.setVisibility(8);
      break label502;
      label954:
      localObject1 = (c)this;
      ((c)localObject1).Abh.setVisibility(8);
      ((c)localObject1).Abf.setVisibility(8);
      break label502;
      this.Abe.setGravity(0);
      break label552;
      label994:
      this.Abi.setVisibility(8);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$adjustTitleTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(291091);
      c.b(this.Abk).getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = c.b(this.Abk).getParent();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(291091);
        throw ((Throwable)localObject);
      }
      int k = ((View)localObject).getWidth();
      int i = 0;
      if (c.a(this.Abk).getVisibility() == 0) {
        i = c.a(this.Abk).getWidth() + (int)c.a(this.Abk).getResources().getDimension(b.d.Edge_2_5_A) + 0;
      }
      int j = i;
      if (c.c(this.Abk).getVisibility() == 0) {
        j = i + (c.c(this.Abk).getWidth() + (int)c.c(this.Abk).getResources().getDimension(b.d.Edge_A));
      }
      if (c.b(this.Abk).getWidth() + j > k)
      {
        c.b(this.Abk).setWidth(k - j);
        Log.i(c.d(this.Abk), "adjustTitleTvSize titleW:" + c.b(this.Abk).getWidth() + ", containerW:" + k + ",iconW:" + j);
      }
      AppMethodBeat.o(291091);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, bip parambip) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291119);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$onBindView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = c.a(this.Abk).getContext();
      p.j(localObject, "userOnLive.context");
      paramView = parambip.contact;
      if (paramView != null) {}
      for (paramView = paramView.username;; paramView = null)
      {
        new y((Context)localObject, paramView, this.Abk.md(), false).dvx();
        a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$onBindView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291119);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */