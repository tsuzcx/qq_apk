package com.tencent.mm.plugin.finder.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.v;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "infoLayout", "Landroid/widget/LinearLayout;", "professionTV", "titleTV", "userOnLive", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "adjustTitleTvSize", "", "onBindView", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "itemClickListener", "Landroid/view/View$OnClickListener;", "itemLongCLickListener", "Landroid/view/View$OnLongClickListener;", "needDivider", "", "plugin-finder_release"})
public final class c
  extends RecyclerView.v
{
  private final String TAG;
  private ImageView gvv;
  private TextView jVO;
  private View jWr;
  private TextView tlQ;
  private TextView tlS;
  private TextView vuk;
  private LinearLayout vul;
  private TextView vum;
  private View vun;
  private ImageView vuo;
  private FinderLiveOnliveWidget vup;
  
  public c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166801);
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(2131299715);
    p.g(localView, "itemView.findViewById(R.id.divider_view)");
    this.jWr = localView;
    localView = paramView.findViewById(2131297134);
    p.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.gvv = ((ImageView)localView);
    localView = paramView.findViewById(2131309249);
    p.g(localView, "itemView.findViewById(R.id.title_tv)");
    this.jVO = ((TextView)localView);
    localView = paramView.findViewById(2131301657);
    p.g(localView, "itemView.findViewById(R.id.follow_tv)");
    this.vuk = ((TextView)localView);
    localView = paramView.findViewById(2131302654);
    p.g(localView, "itemView.findViewById(R.id.info_layout)");
    this.vul = ((LinearLayout)localView);
    localView = paramView.findViewById(2131306174);
    p.g(localView, "itemView.findViewById(R.id.profession_tv)");
    this.vum = ((TextView)localView);
    localView = paramView.findViewById(2131299498);
    p.g(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.tlQ = ((TextView)localView);
    localView = paramView.findViewById(2131299499);
    p.g(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.tlS = ((TextView)localView);
    localView = paramView.findViewById(2131301650);
    p.g(localView, "itemView.findViewById(R.id.follow_layout)");
    this.vun = localView;
    localView = paramView.findViewById(2131297097);
    p.g(localView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.vuo = ((ImageView)localView);
    paramView = paramView.findViewById(2131301215);
    p.g(paramView, "itemView.findViewById(R.…inder_live_onlive_widget)");
    this.vup = ((FinderLiveOnliveWidget)paramView);
    this.vup.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(251303);
        Object localObject1 = new Rect();
        c.a(this.vuq).getHitRect((Rect)localObject1);
        Object localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165277);
        ((Rect)localObject1).inset(-i, -i);
        localObject2 = c.a(this.vuq).getParent();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(251303);
          throw ((Throwable)localObject1);
        }
        ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)c.a(this.vuq)));
        AppMethodBeat.o(251303);
      }
    });
    AppMethodBeat.o(166801);
  }
  
  private final void dpz()
  {
    AppMethodBeat.i(251308);
    this.jVO.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(this));
    AppMethodBeat.o(251308);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final bbz parambbz, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(251306);
    p.h(parambbz, "finderSearchInfo");
    p.h(paramOnClickListener, "itemClickListener");
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    label116:
    int i;
    if (paramBoolean)
    {
      this.jWr.setVisibility(0);
      localObject3 = this.jVO;
      localObject4 = MMApplicationContext.getContext();
      localObject1 = i.vvu;
      localObject2 = parambbz.LLd;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject4, (CharSequence)i.auZ((String)localObject1), this.jVO.getTextSize()));
      localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
      localObject1 = parambbz.contact;
      if (localObject1 == null) {
        break label572;
      }
      localObject1 = ((FinderContact)localObject1).username;
      if (!com.tencent.mm.plugin.finder.api.c.a.asJ((String)localObject1)) {
        break label578;
      }
      this.vuk.setVisibility(0);
      label132:
      if (parambbz.friendFollowCount <= 0) {
        break label672;
      }
      this.vun.setVisibility(0);
      localObject3 = "";
      localObject4 = "";
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (parambbz.friendFollowCount > 0)
      {
        if (Util.isNullOrNil("")) {
          break label590;
        }
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        localObject2 = ((View)localObject1).getContext().getString(2131759795, new Object[] { k.Lv(parambbz.friendFollowCount) });
        p.g(localObject2, "itemView.context.getStri…hInfo.friendFollowCount))");
        localObject1 = localObject3;
      }
      label230:
      if (Util.isNullOrNil((String)localObject1)) {
        break label645;
      }
      this.tlQ.setText((CharSequence)localObject1);
      this.tlQ.setVisibility(0);
      label258:
      if (Util.isNullOrNil((String)localObject2)) {
        break label657;
      }
      this.tlS.setText((CharSequence)localObject2);
      this.tlS.setVisibility(0);
      i = 2;
      label289:
      localObject1 = m.uJa;
      localObject2 = m.dka();
      localObject1 = parambbz.contact;
      if (localObject1 == null) {
        break label687;
      }
      localObject1 = ((FinderContact)localObject1).headUrl;
      label317:
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localObject3 = this.gvv;
      localObject4 = m.uJa;
      ((d)localObject2).a(localObject1, (ImageView)localObject3, m.a(m.a.uJe));
      localObject1 = parambbz.contact;
      if (localObject1 == null) {
        break label850;
      }
      localObject1 = ((FinderContact)localObject1).authInfo;
      if (localObject1 == null) {
        break label850;
      }
      localObject2 = y.vXH;
      y.a(this.vuo, (FinderAuthInfo)localObject1);
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        this.vuo.setVisibility(8);
        this.vum.setVisibility(8);
        label450:
        localObject1 = this.aus;
        p.g(localObject1, "itemView");
        ((View)localObject1).setTag(parambbz);
        this.aus.setOnClickListener(paramOnClickListener);
        this.aus.setOnLongClickListener(paramOnLongClickListener);
        if (i <= 2)
        {
          this.vul.setGravity(16);
          label500:
          paramOnClickListener = parambbz.contact;
          if ((paramOnClickListener == null) || (paramOnClickListener.liveStatus != 1)) {
            break label890;
          }
          this.vup.setVisibility(0);
          paramOnClickListener = this.vup;
          if (paramOnClickListener != null) {
            paramOnClickListener.setOnClickListener((View.OnClickListener)new b(this, parambbz));
          }
        }
        break;
      }
    }
    for (;;)
    {
      dpz();
      AppMethodBeat.o(251306);
      return;
      this.jWr.setVisibility(8);
      break;
      label572:
      localObject1 = null;
      break label116;
      label578:
      this.vuk.setVisibility(8);
      break label132;
      label590:
      localObject1 = this.aus;
      p.g(localObject1, "itemView");
      localObject1 = ((View)localObject1).getContext().getString(2131759795, new Object[] { k.Lv(parambbz.friendFollowCount) });
      p.g(localObject1, "itemView.context.getStri…hInfo.friendFollowCount))");
      localObject2 = localObject4;
      break label230;
      label645:
      this.tlQ.setVisibility(8);
      break label258;
      label657:
      this.tlS.setVisibility(8);
      i = 2;
      break label289;
      label672:
      this.vun.setVisibility(8);
      i = 1;
      break label289;
      label687:
      localObject1 = null;
      break label317;
      this.vuo.setVisibility(0);
      this.vum.setVisibility(0);
      if (Util.isNullOrNil(parambbz.LLf)) {
        this.vum.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject3 = this.vum;
        localObject4 = MMApplicationContext.getContext();
        localObject1 = i.vvu;
        localObject2 = parambbz.LLf;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)localObject4, (CharSequence)i.auZ((String)localObject1), this.vum.getTextSize()));
      }
      this.vuo.setVisibility(0);
      this.vum.setVisibility(8);
      break label450;
      this.vuo.setVisibility(8);
      this.vum.setVisibility(8);
      break label450;
      label850:
      localObject1 = (c)this;
      ((c)localObject1).vuo.setVisibility(8);
      ((c)localObject1).vum.setVisibility(8);
      break label450;
      this.vul.setGravity(0);
      break label500;
      label890:
      this.vup.setVisibility(8);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$adjustTitleTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"})
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(251304);
      c.b(this.vuq).getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = c.b(this.vuq).getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(251304);
        throw ((Throwable)localObject);
      }
      int k = ((View)localObject).getWidth();
      int i = 0;
      if (c.a(this.vuq).getVisibility() == 0) {
        i = c.a(this.vuq).getWidth() + (int)c.a(this.vuq).getResources().getDimension(2131165297) + 0;
      }
      int j = i;
      if (c.c(this.vuq).getVisibility() == 0) {
        j = i + (c.c(this.vuq).getWidth() + (int)c.c(this.vuq).getResources().getDimension(2131165314));
      }
      if (c.b(this.vuq).getWidth() + j > k)
      {
        c.b(this.vuq).setWidth(k - j);
        Log.i(c.d(this.vuq), "adjustTitleTvSize titleW:" + c.b(this.vuq).getWidth() + ", containerW:" + k + ",iconW:" + j);
      }
      AppMethodBeat.o(251304);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc, bbz parambbz) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251305);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$onBindView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      localObject = c.a(this.vuq).getContext();
      p.g(localObject, "userOnLive.context");
      paramView = parambbz.contact;
      if (paramView != null) {}
      for (paramView = paramView.username;; paramView = null)
      {
        new r((Context)localObject, paramView, this.vuq.lR(), false).dzC();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$onBindView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251305);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */