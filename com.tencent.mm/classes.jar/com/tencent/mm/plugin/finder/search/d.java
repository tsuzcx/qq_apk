package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.ag;
import com.tencent.mm.plugin.findersdk.a.cg;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isHighLightWord", "", "isDarkMode", "(Landroid/view/View;ZZ)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "darkFollowTextBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "darkFriendsTextBackground", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "followTextBackground", "followedTextColor", "", "friendsTextBackground", "friendsTextColor", "infoLayout", "Landroid/widget/LinearLayout;", "professionTV", "showLine", "titleSubContainer", "titleTV", "userOnLive", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "adjustTitleTvSize", "", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "getHighLightColor", "color", "handleDesc", "highlightSignature", "signature", "handleFollowView", "isFollowed", "friendFollowCount", "onBindView", "itemClickListener", "Landroid/view/View$OnClickListener;", "itemLongCLickListener", "Landroid/view/View$OnLongClickListener;", "needDivider", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.v
{
  private TextView AoR;
  private TextView AoT;
  private final boolean FwL;
  private TextView FwM;
  private LinearLayout FwN;
  private TextView FwO;
  private View FwP;
  private View FwQ;
  private ImageView FwR;
  private FinderLiveOnliveWidget FwS;
  private int FwT;
  private int FwU;
  private Drawable FwV;
  private Drawable FwW;
  private Drawable FwX;
  private Drawable FwY;
  private int FwZ;
  private final String TAG;
  private final boolean ehd;
  private ImageView lBC;
  private TextView pJJ;
  private View pKl;
  
  public d(View paramView, boolean paramBoolean)
  {
    super(paramView);
    AppMethodBeat.i(342741);
    this.FwL = true;
    this.ehd = paramBoolean;
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(e.e.divider_view);
    s.s(localView, "itemView.findViewById(R.id.divider_view)");
    this.pKl = localView;
    localView = paramView.findViewById(e.e.avatar_iv);
    s.s(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.lBC = ((ImageView)localView);
    localView = paramView.findViewById(e.e.title_tv);
    s.s(localView, "itemView.findViewById(R.id.title_tv)");
    this.pJJ = ((TextView)localView);
    localView = paramView.findViewById(e.e.follow_tv);
    s.s(localView, "itemView.findViewById(R.id.follow_tv)");
    this.FwM = ((TextView)localView);
    localView = paramView.findViewById(e.e.info_layout);
    s.s(localView, "itemView.findViewById(R.id.info_layout)");
    this.FwN = ((LinearLayout)localView);
    localView = paramView.findViewById(e.e.profession_tv);
    s.s(localView, "itemView.findViewById(R.id.profession_tv)");
    this.FwO = ((TextView)localView);
    localView = paramView.findViewById(e.e.desc_1_tv);
    s.s(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.AoR = ((TextView)localView);
    localView = paramView.findViewById(e.e.desc_2_tv);
    s.s(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.AoT = ((TextView)localView);
    localView = paramView.findViewById(e.e.title_sub_container);
    s.s(localView, "itemView.findViewById(R.id.title_sub_container)");
    this.FwP = localView;
    localView = paramView.findViewById(e.e.follow_layout);
    s.s(localView, "itemView.findViewById(R.id.follow_layout)");
    this.FwQ = localView;
    localView = paramView.findViewById(e.e.auth_icon_iv);
    s.s(localView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.FwR = ((ImageView)localView);
    localView = paramView.findViewById(e.e.finder_live_onlive_widget);
    s.s(localView, "itemView.findViewById(R.…inder_live_onlive_widget)");
    this.FwS = ((FinderLiveOnliveWidget)localView);
    this.FwT = paramView.getResources().getColor(e.b.Blue_100);
    this.FwU = paramView.getResources().getColor(e.b.Brand_100);
    this.FwV = paramView.getResources().getDrawable(e.d.finder_search_follow_shape);
    this.FwW = paramView.getResources().getDrawable(e.d.finder_search_follow_dark_shape);
    this.FwX = paramView.getResources().getDrawable(e.d.finder_search_friends_shape);
    this.FwY = paramView.getResources().getDrawable(e.d.finder_search_friends_dark_shape);
    this.FwZ = 1;
    this.FwS.post(new d..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(342741);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(342769);
    s.u(paramd, "this$0");
    Rect localRect = new Rect();
    paramd.FwS.getHitRect(localRect);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(e.c.Edge_0_5_A);
    localRect.inset(-i, -i);
    ViewParent localViewParent = paramd.FwS.getParent();
    if (localViewParent == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(342769);
      throw paramd;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, (View)paramd.FwS));
    AppMethodBeat.o(342769);
  }
  
  private static final void a(d paramd, m paramm, View paramView)
  {
    AppMethodBeat.i(342778);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramView = paramd.FwS.getContext();
    s.s(paramView, "userOnLive.context");
    if (paramm == null) {}
    for (paramm = null;; paramm = paramm.getUsername())
    {
      ((cg)new ag(paramView, paramm, paramd.KJ(), false)).vc(false);
      a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342778);
      return;
    }
  }
  
  private final String aAf(String paramString)
  {
    if (!this.FwL) {
      return paramString;
    }
    return "";
  }
  
  public final void a(final buy parambuy, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(342833);
    s.u(parambuy, "finderSearchInfo");
    s.u(paramOnClickListener, "itemClickListener");
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    label163:
    label181:
    Object localObject5;
    label236:
    int i;
    label261:
    label281:
    int k;
    int j;
    if (paramBoolean)
    {
      this.pKl.setVisibility(0);
      localObject3 = this.pJJ;
      localObject4 = MMApplicationContext.getContext();
      localObject1 = k.FxZ;
      localObject2 = parambuy.aact;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = am.aixg;
      localObject2 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & this.pJJ.getCurrentTextColor()) }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject4, (CharSequence)k.cm((String)localObject1, aAf((String)localObject2)), this.pJJ.getTextSize()));
      localObject1 = parambuy.contact;
      if (localObject1 != null) {
        break label725;
      }
      localObject2 = null;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      if (localObject2 != null) {
        break label737;
      }
      localObject1 = null;
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      localObject4 = this.lBC;
      localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject4, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      this.FwZ = 1;
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      if (localObject2 != null) {
        break label747;
      }
      localObject1 = null;
      paramBoolean = com.tencent.mm.plugin.finder.api.d.a.a((String)localObject1, null, false, false, 14);
      localObject1 = av.GiL;
      if (localObject2 != null) {
        break label757;
      }
      localObject1 = null;
      boolean bool = av.Iz((String)localObject1);
      if ((!paramBoolean) || (bool)) {
        break label767;
      }
      i = 1;
      k = parambuy.friendFollowCount;
      localObject3 = this.FwM;
      if ((i == 0) && (k <= 0)) {
        break label773;
      }
      j = 0;
      label306:
      ((TextView)localObject3).setVisibility(j);
      if (i == 0) {
        break label798;
      }
      ((TextView)localObject3).setText((CharSequence)this.caK.getResources().getString(e.h.has_follow_tip));
      if (!this.ehd) {
        break label780;
      }
      ((TextView)localObject3).setTextColor(this.FwT);
      localObject1 = this.FwW;
      label361:
      ((TextView)localObject3).setBackground((Drawable)localObject1);
      label368:
      localObject3 = parambuy.aacu;
      if (localObject3 != null) {
        break label886;
      }
      localObject3 = "";
      label384:
      if (localObject2 != null) {
        break label889;
      }
      localObject1 = "";
      label394:
      this.AoR.setVisibility(0);
      this.AoT.setVisibility(8);
      if (Util.isNullOrNil((String)localObject3)) {
        break label913;
      }
      localObject1 = this.AoR;
      localObject4 = MMApplicationContext.getContext();
      localObject5 = k.FxZ;
      localObject3 = n.m((String)localObject3, "\n", " ", false);
      localObject5 = am.aixg;
      localObject5 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & this.AoR.getCurrentTextColor()) }, 1));
      s.s(localObject5, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject4, (CharSequence)k.cm((String)localObject3, aAf((String)localObject5)), this.AoR.getTextSize()));
      this.FwZ += 1;
      label539:
      if (localObject2 != null) {
        break label968;
      }
      localObject1 = null;
      label547:
      if (localObject1 == null)
      {
        localObject1 = (d)this;
        ((d)localObject1).FwR.setVisibility(8);
        ((d)localObject1).FwO.setVisibility(8);
      }
      this.caK.setTag(parambuy);
      this.caK.setOnClickListener(paramOnClickListener);
      this.caK.setOnLongClickListener(paramOnLongClickListener);
      if ((localObject2 == null) || (((m)localObject2).field_liveStatus != 1)) {
        break label1309;
      }
      i = 1;
      label619:
      if (i == 0) {
        break label1315;
      }
      this.FwS.setVisibility(0);
      paramOnClickListener = this.FwS;
      if (paramOnClickListener != null) {
        paramOnClickListener.setOnClickListener(new d..ExternalSyntheticLambda0(this, (m)localObject2));
      }
      label655:
      if (this.FwZ > 2) {
        break label1327;
      }
      this.FwN.setGravity(16);
    }
    for (;;)
    {
      if (this.FwR.getVisibility() == 0)
      {
        paramOnClickListener = this.FwR.getLayoutParams();
        if (paramOnClickListener == null)
        {
          parambuy = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(342833);
          throw parambuy;
          this.pKl.setVisibility(8);
          break;
          label725:
          localObject2 = c.a((FinderContact)localObject1, null, false);
          break label163;
          label737:
          localObject1 = ((m)localObject2).amx();
          break label181;
          label747:
          localObject1 = ((m)localObject2).getUsername();
          break label236;
          label757:
          localObject1 = ((m)localObject2).getUsername();
          break label261;
          label767:
          i = 0;
          break label281;
          label773:
          j = 8;
          break label306;
          label780:
          ((TextView)localObject3).setTextColor(this.FwT);
          localObject1 = this.FwV;
          break label361;
          label798:
          if (k <= 0) {
            break label368;
          }
          ((TextView)localObject3).setText((CharSequence)this.caK.getResources().getString(e.h.finder_search_friend_follow, new Object[] { r.TP(k) }));
          if (this.ehd) {
            ((TextView)localObject3).setTextColor(this.FwU);
          }
          for (localObject1 = this.FwY;; localObject1 = this.FwX)
          {
            ((TextView)localObject3).setBackground((Drawable)localObject1);
            break;
            ((TextView)localObject3).setTextColor(this.FwU);
          }
          label886:
          break label384;
          label889:
          localObject4 = ((m)localObject2).getSignature();
          localObject1 = localObject4;
          if (localObject4 != null) {
            break label394;
          }
          localObject1 = "";
          break label394;
          label913:
          if (!Util.isNullOrNil((String)localObject1))
          {
            this.AoR.setText((CharSequence)n.m((String)localObject1, "\n", " ", false));
            this.FwZ += 1;
            break label539;
          }
          this.AoR.setVisibility(8);
          break label539;
          label968:
          localObject1 = ((m)localObject2).field_authInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label547;
          }
          localObject3 = av.GiL;
          av.a(this.FwR, (FinderAuthInfo)localObject1, 0, c.a((m)localObject2, false), 4);
          switch (((FinderAuthInfo)localObject1).authIconType)
          {
          default: 
            this.FwR.setVisibility(8);
            this.FwO.setVisibility(8);
            localObject1 = ah.aiuX;
            break;
          case 1: 
            this.FwR.setVisibility(0);
            this.FwO.setVisibility(0);
            if (Util.isNullOrNil(parambuy.aacv)) {
              this.FwO.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
            }
            for (;;)
            {
              i = this.FwZ;
              this.FwZ = (i + 1);
              localObject1 = Integer.valueOf(i);
              break;
              localObject4 = this.FwO;
              localObject5 = MMApplicationContext.getContext();
              localObject1 = k.FxZ;
              localObject3 = parambuy.aacv;
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "";
              }
              localObject3 = am.aixg;
              localObject3 = String.format("#%06X", Arrays.copyOf(new Object[] { Integer.valueOf(0xFFFFFF & this.FwO.getCurrentTextColor()) }, 1));
              s.s(localObject3, "java.lang.String.format(format, *args)");
              ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject5, (CharSequence)k.cm((String)localObject1, aAf((String)localObject3)), this.FwO.getTextSize()));
            }
          case 2: 
            this.FwR.setVisibility(0);
            this.FwO.setVisibility(8);
            localObject1 = ah.aiuX;
            break;
          case 100: 
            this.FwR.setVisibility(8);
            this.FwO.setVisibility(8);
            localObject1 = ah.aiuX;
            break;
            label1309:
            i = 0;
            break label619;
            label1315:
            this.FwS.setVisibility(8);
            break label655;
            label1327:
            this.FwN.setGravity(0);
            break;
          }
        }
        paramOnClickListener = (LinearLayout.LayoutParams)paramOnClickListener;
        paramOnClickListener.leftMargin = ((int)this.caK.getContext().getResources().getDimension(e.c.Edge_0_5_A));
        this.FwR.setLayoutParams((ViewGroup.LayoutParams)paramOnClickListener);
      }
    }
    this.pJJ.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(this, parambuy));
    AppMethodBeat.o(342833);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder$adjustTitleTvSize$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(d paramd, buy parambuy) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(342752);
      d.b(this.Fxa).getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      Object localObject = d.b(this.Fxa).getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(342752);
        throw ((Throwable)localObject);
      }
      int k = ((View)localObject).getWidth();
      int i = 0;
      if (d.c(this.Fxa).getVisibility() == 0) {
        i = d.c(this.Fxa).getWidth() + (int)d.c(this.Fxa).getResources().getDimension(e.c.Edge_0_5_A) + 0;
      }
      int j = i;
      if (d.d(this.Fxa).getVisibility() == 0) {
        j = i + (d.d(this.Fxa).getWidth() + (int)d.d(this.Fxa).getResources().getDimension(e.c.Edge_0_5_A));
      }
      TextPaint localTextPaint = d.b(this.Fxa).getPaint();
      localObject = parambuy.contact;
      float f;
      if (localObject == null)
      {
        localObject = "";
        f = localTextPaint.measureText((String)localObject);
        if (j + f <= k) {
          break label328;
        }
        d.b(this.Fxa).setWidth(k - j - 1);
        Log.i(d.e(this.Fxa), "adjustTitleTvSize titleW:" + d.b(this.Fxa).getWidth() + ", containerW:" + k + ",iconW:" + j);
      }
      for (;;)
      {
        AppMethodBeat.o(342752);
        return true;
        localObject = c.a((FinderContact)localObject);
        if (localObject == null)
        {
          localObject = "";
          break;
        }
        String str = ((m)localObject).getNickname();
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
        label328:
        d.b(this.Fxa).setWidth((int)f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.d
 * JD-Core Version:    0.7.0.1
 */