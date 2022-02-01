package com.tencent.mm.plugin.finder.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.e;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchContactItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "authIconIV", "Landroid/widget/ImageView;", "avatarIV", "desc1TV", "Landroid/widget/TextView;", "desc2TV", "divider", "followLayout", "followTV", "infoLayout", "Landroid/widget/LinearLayout;", "professionTV", "titleTV", "onBindView", "", "finderSearchInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "itemClickListener", "Landroid/view/View$OnClickListener;", "needDivider", "", "plugin-finder_release"})
public final class c
  extends RecyclerView.v
{
  private final String TAG;
  private ImageView frr;
  private View icB;
  private TextView ica;
  private TextView qHS;
  private LinearLayout qHT;
  private TextView qHU;
  private View qHV;
  private ImageView qHW;
  private TextView qln;
  private TextView qlp;
  
  public c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(166801);
    this.TAG = "Finder.MixSearchContactItemHolder";
    View localView = paramView.findViewById(2131299171);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.divider_view)");
    this.icB = localView;
    localView = paramView.findViewById(2131297008);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.avatar_iv)");
    this.frr = ((ImageView)localView);
    localView = paramView.findViewById(2131305948);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.title_tv)");
    this.ica = ((TextView)localView);
    localView = paramView.findViewById(2131300192);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.follow_tv)");
    this.qHS = ((TextView)localView);
    localView = paramView.findViewById(2131301010);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.info_layout)");
    this.qHT = ((LinearLayout)localView);
    localView = paramView.findViewById(2131303440);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.profession_tv)");
    this.qHU = ((TextView)localView);
    localView = paramView.findViewById(2131298997);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.desc_1_tv)");
    this.qln = ((TextView)localView);
    localView = paramView.findViewById(2131298998);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.desc_2_tv)");
    this.qlp = ((TextView)localView);
    localView = paramView.findViewById(2131300191);
    d.g.b.k.g(localView, "itemView.findViewById(R.id.follow_layout)");
    this.qHV = localView;
    paramView = paramView.findViewById(2131296978);
    d.g.b.k.g(paramView, "itemView.findViewById(R.id.auth_icon_iv)");
    this.qHW = ((ImageView)paramView);
    AppMethodBeat.o(166801);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(aky paramaky, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    AppMethodBeat.i(166799);
    d.g.b.k.h(paramaky, "finderSearchInfo");
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
      this.icB.setVisibility(0);
      localObject1 = this.ica;
      localObject2 = aj.getContext();
      localObject3 = i.qIB;
      localObject3 = paramaky.Dmv;
      d.g.b.k.g(localObject3, "finderSearchInfo.highlightNickname");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject2, (CharSequence)i.Zr((String)localObject3), this.ica.getTextSize()));
      localObject1 = b.qnX;
      localObject1 = paramaky.contact;
      if (localObject1 == null) {
        break label462;
      }
      localObject1 = ((FinderContact)localObject1).username;
      if (!b.a.YO((String)localObject1)) {
        break label468;
      }
      this.qHS.setVisibility(0);
      if (paramaky.friendFollowCount <= 0) {
        break label560;
      }
      this.qHV.setVisibility(0);
      localObject3 = "";
      localObject4 = "";
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (paramaky.friendFollowCount > 0)
      {
        if (bt.isNullOrNil("")) {
          break label480;
        }
        localObject1 = this.arI;
        d.g.b.k.g(localObject1, "itemView");
        localObject2 = ((View)localObject1).getContext().getString(2131759230, new Object[] { e.De(paramaky.friendFollowCount) });
        d.g.b.k.g(localObject2, "itemView.context.getStri…hInfo.friendFollowCount))");
        localObject1 = localObject3;
      }
      if (bt.isNullOrNil((String)localObject1)) {
        break label533;
      }
      this.qln.setText((CharSequence)localObject1);
      this.qln.setVisibility(0);
      if (bt.isNullOrNil((String)localObject2)) {
        break label545;
      }
      this.qlp.setText((CharSequence)localObject2);
      this.qlp.setVisibility(0);
      i = 2;
      label280:
      localObject1 = h.qCF;
      localObject1 = h.cmV();
      localObject2 = new a(paramaky.contact.headUrl);
      localObject3 = this.frr;
      localObject4 = h.qCF;
      ((d)localObject1).a(localObject2, (ImageView)localObject3, h.a(h.a.qCI));
      localObject1 = paramaky.contact.authInfo;
      if (localObject1 == null) {
        break label883;
      }
      switch (((FinderAuthInfo)localObject1).authIconType)
      {
      default: 
        this.qHW.setVisibility(8);
        this.qHU.setVisibility(8);
      }
    }
    for (;;)
    {
      localObject1 = this.arI;
      d.g.b.k.g(localObject1, "itemView");
      ((View)localObject1).setTag(paramaky);
      this.arI.setOnClickListener(paramOnClickListener);
      if (i > 2) {
        break label912;
      }
      this.qHT.setGravity(16);
      AppMethodBeat.o(166799);
      return;
      this.icB.setVisibility(8);
      break;
      label462:
      localObject1 = null;
      break label109;
      label468:
      this.qHS.setVisibility(8);
      break label125;
      label480:
      localObject1 = this.arI;
      d.g.b.k.g(localObject1, "itemView");
      localObject1 = ((View)localObject1).getContext().getString(2131759230, new Object[] { e.De(paramaky.friendFollowCount) });
      d.g.b.k.g(localObject1, "itemView.context.getStri…hInfo.friendFollowCount))");
      localObject2 = localObject4;
      break label221;
      label533:
      this.qln.setVisibility(8);
      break label249;
      label545:
      this.qlp.setVisibility(8);
      i = 2;
      break label280;
      label560:
      this.qHV.setVisibility(8);
      i = 1;
      break label280;
      this.qHW.setVisibility(0);
      this.qHU.setVisibility(0);
      localObject2 = this.qHW;
      localObject3 = this.arI;
      d.g.b.k.g(localObject3, "itemView");
      localObject3 = ((View)localObject3).getContext();
      localObject4 = this.arI;
      d.g.b.k.g(localObject4, "itemView");
      localObject4 = ((View)localObject4).getContext();
      d.g.b.k.g(localObject4, "itemView.context");
      ((ImageView)localObject2).setImageDrawable(am.i((Context)localObject3, 2131690481, ((Context)localObject4).getResources().getColor(2131099777)));
      if (bt.isNullOrNil(paramaky.Lyc)) {
        this.qHU.setText((CharSequence)((FinderAuthInfo)localObject1).authProfession);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = this.qHU;
        localObject2 = aj.getContext();
        localObject3 = i.qIB;
        localObject3 = paramaky.Lyc;
        d.g.b.k.g(localObject3, "finderSearchInfo.highlightProfession");
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.d((Context)localObject2, (CharSequence)i.Zr((String)localObject3), this.qHU.getTextSize()));
      }
      this.qHW.setVisibility(0);
      this.qHU.setVisibility(8);
      localObject1 = this.qHW;
      localObject2 = this.arI;
      d.g.b.k.g(localObject2, "itemView");
      localObject2 = ((View)localObject2).getContext();
      localObject3 = this.arI;
      d.g.b.k.g(localObject3, "itemView");
      localObject3 = ((View)localObject3).getContext();
      d.g.b.k.g(localObject3, "itemView.context");
      ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690481, ((Context)localObject3).getResources().getColor(2131099748)));
      continue;
      this.qHW.setVisibility(8);
      this.qHU.setVisibility(8);
      continue;
      label883:
      localObject1 = (c)this;
      ((c)localObject1).qHW.setVisibility(8);
      ((c)localObject1).qHU.setVisibility(8);
    }
    label912:
    this.qHT.setGravity(0);
    AppMethodBeat.o(166799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.c
 * JD-Core Version:    0.7.0.1
 */