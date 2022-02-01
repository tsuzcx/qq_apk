package com.tencent.mm.plugin.finder.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "infoLayout", "Landroid/widget/LinearLayout;", "professionTV", "titleTV", "onBindView", "", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "itemClickListener", "Landroid/view/View$OnClickListener;", "needDivider", "", "plugin-finder_release"})
public final class c
  extends RecyclerView.w
{
  private final String TAG;
  private ImageView fuY;
  private View iCJ;
  private TextView iCg;
  private TextView qTP;
  private TextView qTR;
  private TextView rAU;
  private LinearLayout rAV;
  private TextView rAW;
  private View rAX;
  private ImageView rAY;
  
  public c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166801);
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(2131299171);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.divider_view)");
    this.iCJ = localView;
    localView = paramView.findViewById(2131297008);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fuY = ((ImageView)localView);
    localView = paramView.findViewById(2131305948);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.title_tv)");
    this.iCg = ((TextView)localView);
    localView = paramView.findViewById(2131300192);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.follow_tv)");
    this.rAU = ((TextView)localView);
    localView = paramView.findViewById(2131301010);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.info_layout)");
    this.rAV = ((LinearLayout)localView);
    localView = paramView.findViewById(2131303440);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profession_tv)");
    this.rAW = ((TextView)localView);
    localView = paramView.findViewById(2131298997);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.qTP = ((TextView)localView);
    localView = paramView.findViewById(2131298998);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.qTR = ((TextView)localView);
    localView = paramView.findViewById(2131300191);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.follow_layout)");
    this.rAX = localView;
    paramView = paramView.findViewById(2131296978);
    d.g.b.k.g(paramView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.rAY = ((ImageView)paramView);
    AppMethodBeat.o(166801);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(anr paramanr, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(166799);
    d.g.b.k.h(paramanr, "finderSearchInfo");
    d.g.b.k.h(paramOnClickListener, "itemClickListener");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label109:
    label125:
    Object localObject4;
    label221:
    label249:
    int i;
    if (paramBoolean)
    {
      this.iCJ.setVisibility(0);
      localObject1 = this.iCg;
      localObject2 = ai.getContext();
      localObject3 = h.rBC;
      localObject3 = paramanr.EGy;
      d.g.b.k.g(localObject3, "finderSearchInfo.highlightNickname");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject2, (CharSequence)h.adZ((String)localObject3), this.iCg.getTextSize()));
      localObject1 = b.qWt;
      localObject1 = paramanr.contact;
      if (localObject1 == null) {
        break label462;
      }
      localObject1 = ((FinderContact)localObject1).username;
      if (!b.a.adk((String)localObject1)) {
        break label468;
      }
      this.rAU.setVisibility(0);
      if (paramanr.friendFollowCount <= 0) {
        break label560;
      }
      this.rAX.setVisibility(0);
      localObject3 = "";
      localObject4 = "";
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (paramanr.friendFollowCount > 0)
      {
        if (bs.isNullOrNil("")) {
          break label480;
        }
        localObject1 = this.asD;
        d.g.b.k.g(localObject1, "itemView");
        localObject2 = ((View)localObject1).getContext().getString(2131759230, new Object[] { g.Ew(paramanr.friendFollowCount) });
        d.g.b.k.g(localObject2, "itemView.context.getStri…hInfo.friendFollowCount))");
        localObject1 = localObject3;
      }
      if (bs.isNullOrNil((String)localObject1)) {
        break label533;
      }
      this.qTP.setText((CharSequence)localObject1);
      this.qTP.setVisibility(0);
      if (bs.isNullOrNil((String)localObject2)) {
        break label545;
      }
      this.qTR.setText((CharSequence)localObject2);
      this.qTR.setVisibility(0);
      i = 2;
      label280:
      localObject1 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject1 = com.tencent.mm.plugin.finder.loader.h.cwo();
      localObject2 = new a(paramanr.contact.headUrl);
      localObject3 = this.fuY;
      localObject4 = com.tencent.mm.plugin.finder.loader.h.rtK;
      ((d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
      localObject1 = paramanr.contact.authInfo;
      if (localObject1 == null) {
        break label883;
      }
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        this.rAY.setVisibility(8);
        this.rAW.setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.asD;
      d.g.b.k.g(localObject1, "itemView");
      ((View)localObject1).setTag(paramanr);
      this.asD.setOnClickListener(paramOnClickListener);
      if (i > 2) {
        break label912;
      }
      this.rAV.setGravity(16);
      AppMethodBeat.o(166799);
      return;
      this.iCJ.setVisibility(8);
      break;
      label462:
      localObject1 = null;
      break label109;
      label468:
      this.rAU.setVisibility(8);
      break label125;
      label480:
      localObject1 = this.asD;
      d.g.b.k.g(localObject1, "itemView");
      localObject1 = ((View)localObject1).getContext().getString(2131759230, new Object[] { g.Ew(paramanr.friendFollowCount) });
      d.g.b.k.g(localObject1, "itemView.context.getStri…hInfo.friendFollowCount))");
      localObject2 = localObject4;
      break label221;
      label533:
      this.qTP.setVisibility(8);
      break label249;
      label545:
      this.qTR.setVisibility(8);
      i = 2;
      break label280;
      label560:
      this.rAX.setVisibility(8);
      i = 1;
      break label280;
      this.rAY.setVisibility(0);
      this.rAW.setVisibility(0);
      localObject2 = this.rAY;
      localObject3 = this.asD;
      d.g.b.k.g(localObject3, "itemView");
      localObject3 = ((View)localObject3).getContext();
      localObject4 = this.asD;
      d.g.b.k.g(localObject4, "itemView");
      localObject4 = ((View)localObject4).getContext();
      d.g.b.k.g(localObject4, "itemView.context");
      ((ImageView)localObject2).setImageDrawable(am.k((Context)localObject3, 2131690481, ((Context)localObject4).getResources().getColor(2131099777)));
      if (bs.isNullOrNil(paramanr.EGA)) {
        this.rAW.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = this.rAW;
        localObject2 = ai.getContext();
        localObject3 = h.rBC;
        localObject3 = paramanr.EGA;
        d.g.b.k.g(localObject3, "finderSearchInfo.highlightProfession");
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject2, (CharSequence)h.adZ((String)localObject3), this.rAW.getTextSize()));
      }
      this.rAY.setVisibility(0);
      this.rAW.setVisibility(8);
      localObject1 = this.rAY;
      localObject2 = this.asD;
      d.g.b.k.g(localObject2, "itemView");
      localObject2 = ((View)localObject2).getContext();
      localObject3 = this.asD;
      d.g.b.k.g(localObject3, "itemView");
      localObject3 = ((View)localObject3).getContext();
      d.g.b.k.g(localObject3, "itemView.context");
      ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690481, ((Context)localObject3).getResources().getColor(2131099748)));
      continue;
      this.rAY.setVisibility(8);
      this.rAW.setVisibility(8);
      continue;
      label883:
      localObject1 = (c)this;
      ((c)localObject1).rAY.setVisibility(8);
      ((c)localObject1).rAW.setVisibility(8);
    }
    label912:
    this.rAV.setGravity(0);
    AppMethodBeat.o(166799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */