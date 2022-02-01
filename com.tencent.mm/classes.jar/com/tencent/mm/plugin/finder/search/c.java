package com.tencent.mm.plugin.finder.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "infoLayout", "Landroid/widget/LinearLayout;", "professionTV", "titleTV", "onBindView", "", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "itemClickListener", "Landroid/view/View$OnClickListener;", "needDivider", "", "plugin-finder_release"})
public final class c
  extends RecyclerView.w
{
  private final String TAG;
  private ImageView fOf;
  private View iVT;
  private TextView iVq;
  private TextView rDS;
  private TextView rDU;
  private TextView sth;
  private LinearLayout sti;
  private TextView stj;
  private View stk;
  private ImageView stl;
  
  public c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166801);
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(2131299171);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.divider_view)");
    this.iVT = localView;
    localView = paramView.findViewById(2131297008);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fOf = ((ImageView)localView);
    localView = paramView.findViewById(2131305948);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.title_tv)");
    this.iVq = ((TextView)localView);
    localView = paramView.findViewById(2131300192);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.follow_tv)");
    this.sth = ((TextView)localView);
    localView = paramView.findViewById(2131301010);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.info_layout)");
    this.sti = ((LinearLayout)localView);
    localView = paramView.findViewById(2131303440);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.profession_tv)");
    this.stj = ((TextView)localView);
    localView = paramView.findViewById(2131298997);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.rDS = ((TextView)localView);
    localView = paramView.findViewById(2131298998);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.rDU = ((TextView)localView);
    localView = paramView.findViewById(2131300191);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.follow_layout)");
    this.stk = localView;
    paramView = paramView.findViewById(2131296978);
    d.g.b.p.g(paramView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.stl = ((ImageView)paramView);
    AppMethodBeat.o(166801);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(ard paramard, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(166799);
    d.g.b.p.h(paramard, "finderSearchInfo");
    d.g.b.p.h(paramOnClickListener, "itemClickListener");
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
      this.iVT.setVisibility(0);
      localObject1 = this.iVq;
      localObject2 = aj.getContext();
      localObject3 = h.stT;
      localObject3 = paramard.GoW;
      d.g.b.p.g(localObject3, "finderSearchInfo.highlightNickname");
      ((TextView)localObject1).setText((CharSequence)k.d((Context)localObject2, (CharSequence)h.ahY((String)localObject3), this.iVq.getTextSize()));
      localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
      localObject1 = paramard.contact;
      if (localObject1 == null) {
        break label478;
      }
      localObject1 = ((FinderContact)localObject1).username;
      if (!c.a.agZ((String)localObject1)) {
        break label484;
      }
      this.sth.setVisibility(0);
      if (paramard.friendFollowCount <= 0) {
        break label576;
      }
      this.stk.setVisibility(0);
      localObject3 = "";
      localObject4 = "";
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (paramard.friendFollowCount > 0)
      {
        if (bt.isNullOrNil("")) {
          break label496;
        }
        localObject1 = this.auu;
        d.g.b.p.g(localObject1, "itemView");
        localObject2 = ((View)localObject1).getContext().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.h.FG(paramard.friendFollowCount) });
        d.g.b.p.g(localObject2, "itemView.context.getStri…hInfo.friendFollowCount))");
        localObject1 = localObject3;
      }
      if (bt.isNullOrNil((String)localObject1)) {
        break label549;
      }
      this.rDS.setText((CharSequence)localObject1);
      this.rDS.setVisibility(0);
      if (bt.isNullOrNil((String)localObject2)) {
        break label561;
      }
      this.rDU.setText((CharSequence)localObject2);
      this.rDU.setVisibility(0);
      i = 2;
      label280:
      localObject1 = i.sja;
      localObject1 = i.cCC();
      localObject2 = new a(paramard.contact.headUrl);
      localObject3 = this.fOf;
      localObject4 = i.sja;
      ((d)localObject1).a(localObject2, (ImageView)localObject3, i.a(i.a.sjd));
      localObject1 = paramard.contact.authInfo;
      if (localObject1 == null) {
        break label743;
      }
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a(this.stl, (FinderAuthInfo)localObject1);
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        this.stl.setVisibility(8);
        this.stj.setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.auu;
      d.g.b.p.g(localObject1, "itemView");
      ((View)localObject1).setTag(paramard);
      this.auu.setOnClickListener(paramOnClickListener);
      if (i > 2) {
        break label772;
      }
      this.sti.setGravity(16);
      AppMethodBeat.o(166799);
      return;
      this.iVT.setVisibility(8);
      break;
      label478:
      localObject1 = null;
      break label109;
      label484:
      this.sth.setVisibility(8);
      break label125;
      label496:
      localObject1 = this.auu;
      d.g.b.p.g(localObject1, "itemView");
      localObject1 = ((View)localObject1).getContext().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.h.FG(paramard.friendFollowCount) });
      d.g.b.p.g(localObject1, "itemView.context.getStri…hInfo.friendFollowCount))");
      localObject2 = localObject4;
      break label221;
      label549:
      this.rDS.setVisibility(8);
      break label249;
      label561:
      this.rDU.setVisibility(8);
      i = 2;
      break label280;
      label576:
      this.stk.setVisibility(8);
      i = 1;
      break label280;
      this.stl.setVisibility(0);
      this.stj.setVisibility(0);
      if (bt.isNullOrNil(paramard.GoY)) {
        this.stj.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = this.stj;
        localObject2 = aj.getContext();
        localObject3 = h.stT;
        localObject3 = paramard.GoY;
        d.g.b.p.g(localObject3, "finderSearchInfo.highlightProfession");
        ((TextView)localObject1).setText((CharSequence)k.d((Context)localObject2, (CharSequence)h.ahY((String)localObject3), this.stj.getTextSize()));
      }
      this.stl.setVisibility(0);
      this.stj.setVisibility(8);
      continue;
      this.stl.setVisibility(8);
      this.stj.setVisibility(8);
      continue;
      label743:
      localObject1 = (c)this;
      ((c)localObject1).stl.setVisibility(8);
      ((c)localObject1).stj.setVisibility(8);
    }
    label772:
    this.sti.setGravity(0);
    AppMethodBeat.o(166799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */