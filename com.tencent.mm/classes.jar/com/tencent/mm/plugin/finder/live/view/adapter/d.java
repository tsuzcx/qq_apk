package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.plugin.aa;
import com.tencent.mm.plugin.finder.live.plugin.aa.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.r;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "giftList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "Lkotlin/collections/ArrayList;", "onGiftItemClick", "Lkotlin/Function4;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "view", "Landroid/view/View;", "curThumbView", "giftId", "", "bottomMargin", "", "getOnGiftItemClick", "()Lkotlin/jvm/functions/Function4;", "setOnGiftItemClick", "(Lkotlin/jvm/functions/Function4;)V", "getCount", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "updateGift", "", "pageIndex", "FinderLiveGiftItemHolder", "plugin-finder_release"})
public final class d
  extends BaseAdapter
{
  private final String TAG;
  private final Context context;
  private final ArrayList<s> uAK;
  public r<? super ViewGroup, ? super View, ? super String, ? super Integer, kotlin.x> upn;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(247778);
    this.context = paramContext;
    this.TAG = "FinderLiveGiftGridAdapter";
    this.uAK = new ArrayList();
    AppMethodBeat.o(247778);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(247777);
    Log.i(this.TAG, "getCount:" + this.uAK.size());
    int i = this.uAK.size();
    AppMethodBeat.o(247777);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(247775);
    Log.i(this.TAG, "getItem:".concat(String.valueOf(paramInt)));
    Object localObject = this.uAK.get(paramInt);
    kotlin.g.b.p.g(localObject, "giftList[position]");
    AppMethodBeat.o(247775);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(247776);
    Log.i(this.TAG, "getItemId:".concat(String.valueOf(paramInt)));
    long l = paramInt;
    AppMethodBeat.o(247776);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(247774);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("getView position:").append(paramInt).append(",convertView is null:");
    boolean bool;
    if (paramView == null)
    {
      bool = true;
      Log.i((String)localObject1, bool);
      if (paramView != null) {
        break label223;
      }
      paramView = LayoutInflater.from(this.context).inflate(2131494397, paramViewGroup, false);
      kotlin.g.b.p.g(paramView, "LayoutInflater.from(cont…t_item_ui, parent, false)");
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      label92:
      localObject1 = this.uAK.get(paramInt);
      kotlin.g.b.p.g(localObject1, "giftList[position]");
      localObject1 = (s)localObject1;
      localObject2 = m.uJa;
      m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(((s)localObject1).field_thumbnailFileUrl, com.tencent.mm.plugin.finder.storage.x.vEo)).c(paramViewGroup.uAL);
      paramViewGroup.uAM.setText((CharSequence)((s)localObject1).field_name);
      paramInt = (int)((s)localObject1).field_price;
      if (paramInt <= 0) {
        break label258;
      }
      paramViewGroup.uAP.setText((CharSequence)String.valueOf(paramInt));
    }
    for (;;)
    {
      paramViewGroup.aus.setOnClickListener((View.OnClickListener)new b(this, paramViewGroup, (s)localObject1));
      AppMethodBeat.o(247774);
      return paramView;
      bool = false;
      break;
      label223:
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveGiftGridAdapter.FinderLiveGiftItemHolder");
        AppMethodBeat.o(247774);
        throw paramView;
      }
      paramViewGroup = (a)paramViewGroup;
      break label92;
      label258:
      paramViewGroup.uAP.setText((CharSequence)String.valueOf(((s)localObject1).field_price));
    }
  }
  
  public final void r(List<s> paramList, int paramInt)
  {
    AppMethodBeat.i(247773);
    kotlin.g.b.p.h(paramList, "giftList");
    int j = paramList.size();
    Log.i(this.TAG, "updateGift pageIndex:" + paramInt + ",size:" + j);
    this.uAK.clear();
    aa.a locala = aa.ups;
    int i = aa.dhj() * paramInt;
    locala = aa.ups;
    int k = aa.dhj();
    paramInt = i;
    while ((paramInt < j) && (paramInt < k + i))
    {
      this.uAK.add(paramList.get(paramInt));
      paramInt += 1;
    }
    AppMethodBeat.o(247773);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$FinderLiveGiftItemHolder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "giftName", "Landroid/widget/TextView;", "getGiftName", "()Landroid/widget/TextView;", "giftPriceGroup", "getGiftPriceGroup", "()Landroid/view/View;", "giftPriceIcon", "Landroid/widget/ImageView;", "getGiftPriceIcon", "()Landroid/widget/ImageView;", "giftPriceTv", "getGiftPriceTv", "giftThumb", "getGiftThumb", "getItemView", "plugin-finder_release"})
  public static final class a
  {
    final View aus;
    final ImageView uAL;
    final TextView uAM;
    final View uAN;
    private final ImageView uAO;
    final TextView uAP;
    
    public a(View paramView)
    {
      AppMethodBeat.i(247771);
      this.aus = paramView;
      paramView = this.aus.findViewById(2131301023);
      kotlin.g.b.p.g(paramView, "itemView.findViewById(R.id.finder_live_gift_thumb)");
      this.uAL = ((ImageView)paramView);
      paramView = this.aus.findViewById(2131300998);
      kotlin.g.b.p.g(paramView, "itemView.findViewById(R.id.finder_live_gift_name)");
      this.uAM = ((TextView)paramView);
      paramView = this.aus.findViewById(2131301015);
      kotlin.g.b.p.g(paramView, "itemView.findViewById(R.…er_live_gift_price_group)");
      this.uAN = paramView;
      paramView = this.aus.findViewById(2131301016);
      kotlin.g.b.p.g(paramView, "itemView.findViewById(R.…der_live_gift_price_icon)");
      this.uAO = ((ImageView)paramView);
      paramView = this.aus.findViewById(2131301017);
      kotlin.g.b.p.g(paramView, "itemView.findViewById(R.…inder_live_gift_price_tv)");
      this.uAP = ((TextView)paramView);
      this.uAM.setTextSize(1, 12.0F);
      this.uAP.setTextSize(1, 12.0F);
      AppMethodBeat.o(247771);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, d.a parama, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247772);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      int i = paramViewGroup.uAN.getMeasuredHeight();
      int j = paramViewGroup.uAM.getMeasuredHeight();
      kotlin.g.b.p.g(paramView, "it");
      int k = at.fromDPToPix(paramView.getContext(), 12);
      localObject = this.uAQ.upn;
      if (localObject != null)
      {
        paramView = (ViewGroup)paramView;
        ImageView localImageView = paramViewGroup.uAL;
        String str = this.uAS.field_rewardProductId;
        kotlin.g.b.p.g(str, "giftInfo.field_rewardProductId");
        ((r)localObject).invoke(paramView, localImageView, str, Integer.valueOf(i + j + k));
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.d
 * JD-Core Version:    0.7.0.1
 */