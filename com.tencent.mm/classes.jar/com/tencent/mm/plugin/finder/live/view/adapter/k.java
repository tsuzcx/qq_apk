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
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.plugin.az;
import com.tencent.mm.plugin.finder.live.plugin.az.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "giftList", "Ljava/util/ArrayList;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "Lkotlin/collections/ArrayList;", "onGiftItemClick", "Lkotlin/Function4;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "view", "Landroid/view/View;", "curThumbView", "giftId", "", "bottomMargin", "", "getOnGiftItemClick", "()Lkotlin/jvm/functions/Function4;", "setOnGiftItemClick", "(Lkotlin/jvm/functions/Function4;)V", "getCount", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "updateGift", "", "pageIndex", "FinderLiveGiftItemHolder", "plugin-finder_release"})
public final class k
  extends BaseAdapter
{
  private final String TAG;
  private final Context context;
  private final ArrayList<com.tencent.c.a.a.a.d.a.b> yXE;
  public r<? super ViewGroup, ? super View, ? super String, ? super Integer, kotlin.x> yqs;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(242278);
    this.context = paramContext;
    this.TAG = "FinderLiveGiftGridAdapter";
    this.yXE = new ArrayList();
    AppMethodBeat.o(242278);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(242275);
    Log.i(this.TAG, "getCount:" + this.yXE.size());
    int i = this.yXE.size();
    AppMethodBeat.o(242275);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(242272);
    Log.i(this.TAG, "getItem:".concat(String.valueOf(paramInt)));
    Object localObject = this.yXE.get(paramInt);
    p.j(localObject, "giftList[position]");
    AppMethodBeat.o(242272);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(242273);
    Log.i(this.TAG, "getItemId:".concat(String.valueOf(paramInt)));
    long l = paramInt;
    AppMethodBeat.o(242273);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(242271);
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("getView position:").append(paramInt).append(",convertView is null:");
    boolean bool;
    if (paramView == null)
    {
      bool = true;
      Log.i((String)localObject1, bool);
      if (paramView != null) {
        break label224;
      }
      paramView = LayoutInflater.from(this.context).inflate(b.g.finder_live_gift_item_ui, paramViewGroup, false);
      p.j(paramView, "LayoutInflater.from(cont…t_item_ui, parent, false)");
      paramViewGroup = new k.a(paramView);
      paramView.setTag(paramViewGroup);
      label93:
      localObject1 = this.yXE.get(paramInt);
      p.j(localObject1, "giftList[position]");
      localObject1 = (com.tencent.c.a.a.a.d.a.b)localObject1;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      com.tencent.mm.plugin.finder.loader.t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x(((com.tencent.c.a.a.a.d.a.b)localObject1).field_thumbnailFileUrl, u.Alz)).c(paramViewGroup.yXF);
      paramViewGroup.yXG.setText((CharSequence)((com.tencent.c.a.a.a.d.a.b)localObject1).field_name);
      paramInt = (int)((com.tencent.c.a.a.a.d.a.b)localObject1).field_price;
      if (paramInt <= 0) {
        break label259;
      }
      paramViewGroup.yXJ.setText((CharSequence)String.valueOf(paramInt));
    }
    for (;;)
    {
      paramViewGroup.amk.setOnClickListener((View.OnClickListener)new b(this, paramViewGroup, (com.tencent.c.a.a.a.d.a.b)localObject1));
      AppMethodBeat.o(242271);
      return paramView;
      bool = false;
      break;
      label224:
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveGiftGridAdapter.FinderLiveGiftItemHolder");
        AppMethodBeat.o(242271);
        throw paramView;
      }
      paramViewGroup = (k.a)paramViewGroup;
      break label93;
      label259:
      paramViewGroup.yXJ.setText((CharSequence)String.valueOf(((com.tencent.c.a.a.a.d.a.b)localObject1).field_price));
    }
  }
  
  public final void p(List<com.tencent.c.a.a.a.d.a.b> paramList, int paramInt)
  {
    AppMethodBeat.i(242269);
    p.k(paramList, "giftList");
    int j = paramList.size();
    Log.i(this.TAG, "updateGift pageIndex:" + paramInt + ",size:" + j);
    this.yXE.clear();
    az.a locala = az.yqy;
    int i = az.dBE() * paramInt;
    locala = az.yqy;
    int k = az.dBE();
    paramInt = i;
    while ((paramInt < j) && (paramInt < k + i))
    {
      this.yXE.add(paramList.get(paramInt));
      paramInt += 1;
    }
    AppMethodBeat.o(242269);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(k paramk, k.a parama, com.tencent.c.a.a.a.d.a.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281550);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      int i = paramViewGroup.yXH.getMeasuredHeight();
      int j = paramViewGroup.yXG.getMeasuredHeight();
      p.j(paramView, "it");
      int k = aw.fromDPToPix(paramView.getContext(), 12);
      localObject = this.yXK.yqs;
      if (localObject != null)
      {
        paramView = (ViewGroup)paramView;
        ImageView localImageView = paramViewGroup.yXF;
        String str = this.yXM.field_rewardProductId;
        p.j(str, "giftInfo.field_rewardProductId");
        ((r)localObject).a(paramView, localImageView, str, Integer.valueOf(i + j + k));
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveGiftGridAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.k
 * JD-Core Version:    0.7.0.1
 */