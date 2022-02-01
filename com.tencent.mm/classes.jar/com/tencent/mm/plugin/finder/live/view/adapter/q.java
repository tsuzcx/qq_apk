package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.plugin.au;
import com.tencent.mm.plugin.finder.live.plugin.au.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.h;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "giftList", "Ljava/util/ArrayList;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "Lkotlin/collections/ArrayList;", "onGiftItemClick", "Lkotlin/Function4;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "view", "Landroid/view/View;", "curThumbView", "", "giftId", "", "bottomMargin", "", "getOnGiftItemClick", "()Lkotlin/jvm/functions/Function4;", "setOnGiftItemClick", "(Lkotlin/jvm/functions/Function4;)V", "getCount", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "setHolderPrice", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$FinderLiveGiftItemHolder;", "giftInfo", "updateGift", "", "pageIndex", "Companion", "FinderLiveGiftItemHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends BaseAdapter
{
  public static final q.a DRk;
  private final ArrayList<com.tencent.d.a.a.a.d.a.d> DRl;
  public r<? super ViewGroup, ? super View, ? super String, ? super Integer, ah> Dax;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(358706);
    DRk = new q.a((byte)0);
    AppMethodBeat.o(358706);
  }
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(358674);
    this.context = paramContext;
    this.DRl = new ArrayList();
    AppMethodBeat.o(358674);
  }
  
  private static void a(b paramb, com.tencent.d.a.a.a.d.a.d paramd)
  {
    AppMethodBeat.i(358687);
    int i = (int)paramd.field_price;
    if (i > 0)
    {
      paramb.DRq.setText((CharSequence)String.valueOf(i));
      AppMethodBeat.o(358687);
      return;
    }
    paramb.DRq.setText((CharSequence)String.valueOf(paramd.field_price));
    AppMethodBeat.o(358687);
  }
  
  private static final void a(b paramb, q paramq, com.tencent.d.a.a.a.d.a.d paramd, View paramView)
  {
    AppMethodBeat.i(358700);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramq);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "$holder");
    kotlin.g.b.s.u(paramq, "this$0");
    kotlin.g.b.s.u(paramd, "$giftInfo");
    int i = paramb.DRo.getMeasuredHeight();
    int j = paramb.DRn.getMeasuredHeight();
    int k = bd.fromDPToPix(paramView.getContext(), 12);
    paramq = paramq.Dax;
    if (paramq != null)
    {
      if (paramView == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(358700);
        throw paramb;
      }
      paramView = (ViewGroup)paramView;
      paramb = paramb.DRm;
      paramd = paramd.field_rewardProductId;
      kotlin.g.b.s.s(paramd, "giftInfo.field_rewardProductId");
      paramq.a(paramView, paramb, paramd, Integer.valueOf(i + j + k));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358700);
  }
  
  public final void G(List<com.tencent.d.a.a.a.d.a.d> paramList, int paramInt)
  {
    AppMethodBeat.i(358729);
    kotlin.g.b.s.u(paramList, "giftList");
    int j = paramList.size();
    Log.i("FinderLiveGiftGridAdapter", "updateGift pageIndex:" + paramInt + ",size:" + j);
    this.DRl.clear();
    au.a locala = au.CZY;
    int i = au.eqs() * paramInt;
    locala = au.CZY;
    int k = au.eqs();
    paramInt = i;
    while ((paramInt < j) && (paramInt < k + i))
    {
      this.DRl.add(paramList.get(paramInt));
      paramInt += 1;
    }
    AppMethodBeat.o(358729);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(358772);
    Log.i("FinderLiveGiftGridAdapter", kotlin.g.b.s.X("getCount:", Integer.valueOf(this.DRl.size())));
    int i = this.DRl.size();
    AppMethodBeat.o(358772);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(358756);
    Log.i("FinderLiveGiftGridAdapter", kotlin.g.b.s.X("getItem:", Integer.valueOf(paramInt)));
    Object localObject = this.DRl.get(paramInt);
    kotlin.g.b.s.s(localObject, "giftList[position]");
    AppMethodBeat.o(358756);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(358763);
    Log.i("FinderLiveGiftGridAdapter", kotlin.g.b.s.X("getItemId:", Integer.valueOf(paramInt)));
    long l = paramInt;
    AppMethodBeat.o(358763);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(358750);
    Object localObject1 = new StringBuilder("getView position:").append(paramInt).append(",convertView is null:");
    boolean bool1;
    label91:
    Object localObject2;
    int i;
    boolean bool2;
    if (paramView == null)
    {
      bool1 = true;
      Log.i("FinderLiveGiftGridAdapter", bool1);
      if (paramView != null) {
        break label372;
      }
      paramView = LayoutInflater.from(this.context).inflate(p.f.CdW, paramViewGroup, false);
      kotlin.g.b.s.s(paramView, "from(context).inflate(R.…t_item_ui, parent, false)");
      paramViewGroup = new b(paramView);
      paramView.setTag(paramViewGroup);
      localObject1 = this.DRl.get(paramInt);
      kotlin.g.b.s.s(localObject1, "giftList[position]");
      localObject1 = (com.tencent.d.a.a.a.d.a.d)localObject1;
      localObject2 = p.ExI;
      p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(((com.tencent.d.a.a.a.d.a.d)localObject1).field_thumbnailFileUrl, v.FKZ)).d(paramViewGroup.DRm);
      paramViewGroup.DRq.setTextSize(1, 12.0F);
      paramViewGroup.DRn.setText((CharSequence)((com.tencent.d.a.a.a.d.a.d)localObject1).field_name);
      if (!((com.tencent.d.a.a.a.d.a.d)localObject1).jWv()) {
        break label597;
      }
      paramViewGroup.DRr.setVisibility(0);
      i = ((com.tencent.d.a.a.a.d.a.d)localObject1).field_unlockIntimacyLevel;
      bool2 = com.tencent.mm.ae.d.ee(((com.tencent.d.a.a.a.d.a.d)localObject1).field_flag, 4);
      localObject2 = aj.CGT;
      localObject2 = (h)aj.business(h.class);
      if (localObject2 != null) {
        break label408;
      }
      paramInt = 0;
      label232:
      localObject2 = aj.CGT;
      localObject2 = (h)aj.business(h.class);
      if (localObject2 != null) {
        break label417;
      }
      bool1 = false;
      label256:
      if (!bool1) {
        break label486;
      }
      if (paramInt < i) {
        break label427;
      }
      a(paramViewGroup, (com.tencent.d.a.a.a.d.a.d)localObject1);
      paramViewGroup.DRp.setImageResource(p.g.coin_icon);
    }
    label408:
    label417:
    label427:
    label597:
    for (;;)
    {
      paramViewGroup.DRp.setIconColor(paramViewGroup.caK.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
      paramViewGroup.caK.setOnClickListener(new q..ExternalSyntheticLambda0(paramViewGroup, this, (com.tencent.d.a.a.a.d.a.d)localObject1));
      paramViewGroup.caK.setTag(p.e.BEr, paramViewGroup.DRn.getText());
      paramViewGroup.caK.setTag(p.e.BEs, paramViewGroup.DRq.getText());
      AppMethodBeat.o(358750);
      return paramView;
      bool1 = false;
      break;
      label372:
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveGiftGridAdapter.FinderLiveGiftItemHolder");
        AppMethodBeat.o(358750);
        throw paramView;
      }
      paramViewGroup = (b)paramViewGroup;
      break label91;
      paramInt = ((h)localObject2).eyQ();
      break label232;
      bool1 = ((h)localObject2).Eff;
      break label256;
      paramViewGroup.DRq.setText((CharSequence)paramViewGroup.caK.getContext().getString(p.h.Ctp, new Object[] { Integer.valueOf(i) }));
      paramViewGroup.DRq.setTextSize(1, 10.0F);
      paramViewGroup.DRp.setImageResource(p.g.icons_filled_lock);
      continue;
      label486:
      if (bool2)
      {
        paramViewGroup.DRq.setText((CharSequence)paramViewGroup.caK.getContext().getString(p.h.Cto));
        paramViewGroup.DRq.setTextSize(1, 10.0F);
        paramViewGroup.DRp.setImageResource(p.g.icons_filled_lock);
      }
      else
      {
        paramViewGroup.DRq.setText((CharSequence)paramViewGroup.caK.getContext().getString(p.h.Ctp, new Object[] { Integer.valueOf(i) }));
        paramViewGroup.DRq.setTextSize(1, 10.0F);
        paramViewGroup.DRp.setImageResource(p.g.icons_filled_lock);
        continue;
        paramViewGroup.DRr.setVisibility(8);
        a(paramViewGroup, (com.tencent.d.a.a.a.d.a.d)localObject1);
        paramViewGroup.DRp.setImageResource(p.g.coin_icon);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$FinderLiveGiftItemHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "fansGiftTag", "Landroid/widget/TextView;", "getFansGiftTag", "()Landroid/widget/TextView;", "giftName", "getGiftName", "giftPriceGroup", "getGiftPriceGroup", "()Landroid/view/View;", "giftPriceIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getGiftPriceIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "giftPriceTv", "getGiftPriceTv", "giftThumb", "Landroid/widget/ImageView;", "getGiftThumb", "()Landroid/widget/ImageView;", "getItemView", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final ImageView DRm;
    final TextView DRn;
    final View DRo;
    final WeImageView DRp;
    final TextView DRq;
    final TextView DRr;
    final View caK;
    
    public b(View paramView)
    {
      AppMethodBeat.i(359062);
      this.caK = paramView;
      paramView = this.caK.findViewById(p.e.BMc);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.id.finder_live_gift_thumb)");
      this.DRm = ((ImageView)paramView);
      paramView = this.caK.findViewById(p.e.BLC);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.id.finder_live_gift_name)");
      this.DRn = ((TextView)paramView);
      paramView = this.caK.findViewById(p.e.BLT);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.…er_live_gift_price_group)");
      this.DRo = paramView;
      paramView = this.caK.findViewById(p.e.BLU);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.…der_live_gift_price_icon)");
      this.DRp = ((WeImageView)paramView);
      paramView = this.caK.findViewById(p.e.BLV);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.…inder_live_gift_price_tv)");
      this.DRq = ((TextView)paramView);
      paramView = this.caK.findViewById(p.e.BDf);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.id.fans_gift_tag)");
      this.DRr = ((TextView)paramView);
      paramView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramView = this.caK.getContext();
      kotlin.g.b.s.s(paramView, "itemView.context");
      com.tencent.mm.plugin.finder.accessibility.a.a(paramView, this.DRn, 12.0F);
      paramView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
      paramView = this.caK.getContext();
      kotlin.g.b.s.s(paramView, "itemView.context");
      com.tencent.mm.plugin.finder.accessibility.a.a(paramView, this.DRr, 10.0F);
      AppMethodBeat.o(359062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.q
 * JD-Core Version:    0.7.0.1
 */