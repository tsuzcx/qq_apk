package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.protocal.protobuf.ayj;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function0;", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function0;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "position", "", "bindWhiteListViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateWhiteList", "list", "BottomViewHolder", "Companion", "FinderLiveAudienceListFileWrapper", "WhiteListViewHolder", "plugin-finder_release"})
public final class aa
  extends RecyclerView.a<RecyclerView.v>
{
  public static final b zap;
  public LinkedList<c> syG;
  public kotlin.g.a.a<x> zao;
  
  static
  {
    AppMethodBeat.i(275934);
    zap = new b((byte)0);
    AppMethodBeat.o(275934);
  }
  
  public aa()
  {
    AppMethodBeat.i(275933);
    this.syG = new LinkedList();
    AppMethodBeat.o(275933);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(275929);
    p.k(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = View.inflate(paramViewGroup.getContext(), b.g.finder_live_white_list_normal_item_ui, null);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
      AppMethodBeat.o(275929);
      return paramViewGroup;
    }
    paramViewGroup = View.inflate(paramViewGroup.getContext(), b.g.finder_live_white_list_bottom_item_ui, null);
    p.j(paramViewGroup, "itemView");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(275929);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(275932);
    p.k(paramv, "holder");
    Object localObject3;
    int i;
    label41:
    boolean bool;
    label70:
    TextView localTextView;
    if ((paramv instanceof d))
    {
      localObject3 = (d)paramv;
      i = this.syG.size();
      if (paramInt >= 0) {
        break label199;
      }
      paramv = null;
      localObject1 = ((d)localObject3).zat;
      p.j(localObject1, "holder.check");
      if ((paramv == null) || (paramv.zar != true)) {
        break label219;
      }
      bool = true;
      ((CheckBox)localObject1).setChecked(bool);
      ((d)localObject3).amk.setOnClickListener((View.OnClickListener)new e(this, paramv, (d)localObject3));
      localTextView = ((d)localObject3).zau;
      p.j(localTextView, "holder.detail");
      if (paramv == null) {
        break label225;
      }
      localObject1 = paramv.zas;
      if (localObject1 == null) {
        break label225;
      }
    }
    label199:
    label219:
    label225:
    for (Object localObject1 = ((ayj)localObject1).title;; localObject1 = null)
    {
      localTextView.setText((CharSequence)localObject1);
      localObject3 = ((d)localObject3).zau;
      p.j(localObject3, "holder.detail");
      localObject1 = localObject2;
      if (paramv != null)
      {
        paramv = paramv.zas;
        localObject1 = localObject2;
        if (paramv != null) {
          localObject1 = paramv.RRY;
        }
      }
      ((TextView)localObject3).setTag(localObject1);
      AppMethodBeat.o(275932);
      return;
      if (i <= paramInt) {
        break;
      }
      paramv = (c)this.syG.get(paramInt);
      break label41;
      bool = false;
      break label70;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(275930);
    int i = this.syG.size();
    AppMethodBeat.o(275930);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(275931);
    paramInt = ((c)this.syG.get(paramInt)).type;
    AppMethodBeat.o(275931);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class a
    extends RecyclerView.v
  {
    private TextView bFR;
    
    public a()
    {
      super();
      AppMethodBeat.i(282714);
      this.bFR = ((TextView)localObject.findViewById(b.f.white_list_content_bottom_tips));
      AppMethodBeat.o(282714);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$Companion;", "", "()V", "TAG", "", "TYPE_BOTTOM", "", "TYPE_NORMAL", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "", "choose", "", "audienceFile", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "type", "", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;I)V", "getAudienceFile", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChoose", "()Z", "setChoose", "(Z)V", "getType", "()I", "setType", "(I)V", "plugin-finder_release"})
  public static final class c
  {
    int type;
    public boolean zar;
    public final ayj zas;
    
    public c(boolean paramBoolean, ayj paramayj, int paramInt)
    {
      AppMethodBeat.i(289449);
      this.zar = paramBoolean;
      this.zas = paramayj;
      this.type = paramInt;
      AppMethodBeat.o(289449);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "check", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheck", "()Landroid/widget/CheckBox;", "setCheck", "(Landroid/widget/CheckBox;)V", "detail", "Landroid/widget/TextView;", "getDetail", "()Landroid/widget/TextView;", "setDetail", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.v
  {
    CheckBox zat;
    TextView zau;
    
    public d()
    {
      super();
      AppMethodBeat.i(277917);
      this.zat = ((CheckBox)localObject.findViewById(b.f.white_list_checkbox));
      this.zau = ((TextView)localObject.findViewById(b.f.white_list_detail_tv));
      this$1 = this.zat;
      p.j(aa.this, "check");
      aa.this.setClickable(false);
      AppMethodBeat.o(277917);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(aa paramaa, aa.c paramc, aa.d paramd) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(288238);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = paramv;
      if (paramView != null)
      {
        localObject = paramv;
        if ((localObject != null) && (!((aa.c)localObject).zar))
        {
          bool1 = true;
          paramView.zar = bool1;
        }
      }
      else
      {
        paramView = this.zaw.zat;
        p.j(paramView, "holder.check");
        localObject = paramv;
        if ((localObject == null) || (((aa.c)localObject).zar != true)) {
          break label157;
        }
      }
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.setChecked(bool1);
        paramView = this.zaq.zao;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288238);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.aa
 * JD-Core Version:    0.7.0.1
 */