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
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "infoLayout", "Landroid/widget/LinearLayout;", "professionTV", "titleTV", "onBindView", "", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "itemClickListener", "Landroid/view/View$OnClickListener;", "needDivider", "", "plugin-finder_release"})
public final class c
  extends RecyclerView.w
{
  private final String TAG;
  private ImageView fQl;
  private View iYM;
  private TextView iYj;
  private TextView rMd;
  private TextView rMf;
  private TextView sDr;
  private LinearLayout sDs;
  private TextView sDt;
  private View sDu;
  private ImageView sDv;
  
  public c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166801);
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(2131299171);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.divider_view)");
    this.iYM = localView;
    localView = paramView.findViewById(2131297008);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.fQl = ((ImageView)localView);
    localView = paramView.findViewById(2131305948);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.title_tv)");
    this.iYj = ((TextView)localView);
    localView = paramView.findViewById(2131300192);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.follow_tv)");
    this.sDr = ((TextView)localView);
    localView = paramView.findViewById(2131301010);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.info_layout)");
    this.sDs = ((LinearLayout)localView);
    localView = paramView.findViewById(2131303440);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.profession_tv)");
    this.sDt = ((TextView)localView);
    localView = paramView.findViewById(2131298997);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.rMd = ((TextView)localView);
    localView = paramView.findViewById(2131298998);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.rMf = ((TextView)localView);
    localView = paramView.findViewById(2131300191);
    d.g.b.p.g(localView, "itemView.findViewById(R.id.follow_layout)");
    this.sDu = localView;
    paramView = paramView.findViewById(2131296978);
    d.g.b.p.g(paramView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.sDv = ((ImageView)paramView);
    AppMethodBeat.o(166801);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(ars paramars, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(166799);
    d.g.b.p.h(paramars, "finderSearchInfo");
    d.g.b.p.h(paramOnClickListener, "itemClickListener");
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject2;
    label115:
    label255:
    int i;
    if (paramBoolean)
    {
      this.iYM.setVisibility(0);
      localObject3 = this.iYj;
      localObject4 = ak.getContext();
      localObject1 = h.sEe;
      localObject2 = paramars.GIm;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((TextView)localObject3).setText((CharSequence)k.d((Context)localObject4, (CharSequence)h.aiW((String)localObject1), this.iYj.getTextSize()));
      localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
      localObject1 = paramars.contact;
      if (localObject1 == null) {
        break label506;
      }
      localObject1 = ((FinderContact)localObject1).username;
      if (!c.a.ahW((String)localObject1)) {
        break label512;
      }
      this.sDr.setVisibility(0);
      label131:
      if (paramars.friendFollowCount <= 0) {
        break label604;
      }
      this.sDu.setVisibility(0);
      localObject3 = "";
      localObject4 = "";
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (paramars.friendFollowCount > 0)
      {
        if (bu.isNullOrNil("")) {
          break label524;
        }
        localObject1 = this.auu;
        d.g.b.p.g(localObject1, "itemView");
        localObject2 = ((View)localObject1).getContext().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.h.Ge(paramars.friendFollowCount) });
        d.g.b.p.g(localObject2, "itemView.context.getStri…hInfo.friendFollowCount))");
        localObject1 = localObject3;
      }
      label227:
      if (bu.isNullOrNil((String)localObject1)) {
        break label577;
      }
      this.rMd.setText((CharSequence)localObject1);
      this.rMd.setVisibility(0);
      if (bu.isNullOrNil((String)localObject2)) {
        break label589;
      }
      this.rMf.setText((CharSequence)localObject2);
      this.rMf.setVisibility(0);
      i = 2;
      label286:
      localObject1 = i.srW;
      localObject2 = i.cEo();
      localObject1 = paramars.contact;
      if (localObject1 == null) {
        break label619;
      }
      localObject1 = ((FinderContact)localObject1).headUrl;
      label314:
      localObject1 = new a((String)localObject1);
      localObject3 = this.fQl;
      localObject4 = i.srW;
      ((d)localObject2).a(localObject1, (ImageView)localObject3, i.a(i.a.srZ));
      localObject1 = paramars.contact;
      if (localObject1 == null) {
        break label782;
      }
      localObject1 = ((FinderContact)localObject1).authInfo;
      if (localObject1 == null) {
        break label782;
      }
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      com.tencent.mm.plugin.finder.utils.p.a(this.sDv, (FinderAuthInfo)localObject1);
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        this.sDv.setVisibility(8);
        this.sDt.setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.auu;
      d.g.b.p.g(localObject1, "itemView");
      ((View)localObject1).setTag(paramars);
      this.auu.setOnClickListener(paramOnClickListener);
      if (i > 2) {
        break label811;
      }
      this.sDs.setGravity(16);
      AppMethodBeat.o(166799);
      return;
      this.iYM.setVisibility(8);
      break;
      label506:
      localObject1 = null;
      break label115;
      label512:
      this.sDr.setVisibility(8);
      break label131;
      label524:
      localObject1 = this.auu;
      d.g.b.p.g(localObject1, "itemView");
      localObject1 = ((View)localObject1).getContext().getString(2131759230, new Object[] { com.tencent.mm.plugin.finder.utils.h.Ge(paramars.friendFollowCount) });
      d.g.b.p.g(localObject1, "itemView.context.getStri…hInfo.friendFollowCount))");
      localObject2 = localObject4;
      break label227;
      label577:
      this.rMd.setVisibility(8);
      break label255;
      label589:
      this.rMf.setVisibility(8);
      i = 2;
      break label286;
      label604:
      this.sDu.setVisibility(8);
      i = 1;
      break label286;
      label619:
      localObject1 = null;
      break label314;
      this.sDv.setVisibility(0);
      this.sDt.setVisibility(0);
      if (bu.isNullOrNil(paramars.GIo)) {
        this.sDt.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject3 = this.sDt;
        localObject4 = ak.getContext();
        localObject1 = h.sEe;
        localObject2 = paramars.GIo;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((TextView)localObject3).setText((CharSequence)k.d((Context)localObject4, (CharSequence)h.aiW((String)localObject1), this.sDt.getTextSize()));
      }
      this.sDv.setVisibility(0);
      this.sDt.setVisibility(8);
      continue;
      this.sDv.setVisibility(8);
      this.sDt.setVisibility(8);
      continue;
      label782:
      localObject1 = (c)this;
      ((c)localObject1).sDv.setVisibility(8);
      ((c)localObject1).sDt.setVisibility(8);
    }
    label811:
    this.sDs.setGravity(0);
    AppMethodBeat.o(166799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */