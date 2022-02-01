package com.tencent.mm.plugin.finder.live.view.adapter;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function0;", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function0;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "position", "", "bindWhiteListViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateWhiteList", "list", "BottomViewHolder", "Companion", "FinderLiveAudienceListFileWrapper", "WhiteListViewHolder", "plugin-finder_release"})
public final class i
  extends RecyclerView.a<RecyclerView.v>
{
  public static final b uCc;
  private LinkedList<c> ppH;
  public kotlin.g.a.a<x> uCb;
  
  static
  {
    AppMethodBeat.i(247867);
    uCc = new b((byte)0);
    AppMethodBeat.o(247867);
  }
  
  public i()
  {
    AppMethodBeat.i(247866);
    this.ppH = new LinkedList();
    AppMethodBeat.o(247866);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(247861);
    p.h(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = View.inflate(paramViewGroup.getContext(), 2131494488, null);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
      AppMethodBeat.o(247861);
      return paramViewGroup;
    }
    paramViewGroup = View.inflate(paramViewGroup.getContext(), 2131494487, null);
    p.g(paramViewGroup, "itemView");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(247861);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(247865);
    p.h(paramv, "holder");
    if ((paramv instanceof d))
    {
      Object localObject3 = (d)paramv;
      p.h(localObject3, "holder");
      int i = this.ppH.size();
      label48:
      boolean bool;
      label77:
      TextView localTextView;
      if (paramInt < 0)
      {
        paramv = null;
        localObject1 = ((d)localObject3).uCg;
        p.g(localObject1, "holder.check");
        if ((paramv == null) || (paramv.uCe != true)) {
          break label226;
        }
        bool = true;
        ((CheckBox)localObject1).setChecked(bool);
        ((d)localObject3).aus.setOnClickListener((View.OnClickListener)new e(this, paramv, (d)localObject3));
        localTextView = ((d)localObject3).uCh;
        p.g(localTextView, "holder.detail");
        if (paramv == null) {
          break label232;
        }
        localObject1 = paramv.uCf;
        if (localObject1 == null) {
          break label232;
        }
      }
      label226:
      label232:
      for (Object localObject1 = ((avh)localObject1).title;; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject3 = ((d)localObject3).uCh;
        p.g(localObject3, "holder.detail");
        localObject1 = localObject2;
        if (paramv != null)
        {
          paramv = paramv.uCf;
          localObject1 = localObject2;
          if (paramv != null) {
            localObject1 = paramv.KRd;
          }
        }
        ((TextView)localObject3).setTag(localObject1);
        AppMethodBeat.o(247865);
        return;
        if (i <= paramInt) {
          break;
        }
        paramv = (c)this.ppH.get(paramInt);
        break label48;
        bool = false;
        break label77;
      }
    }
    if ((paramv instanceof a)) {
      p.h((a)paramv, "holder");
    }
    AppMethodBeat.o(247865);
  }
  
  public final void ap(LinkedList<c> paramLinkedList)
  {
    AppMethodBeat.i(247864);
    StringBuilder localStringBuilder = new StringBuilder("updateWhiteList,ori size:").append(this.ppH.size()).append(",new size:");
    if (paramLinkedList != null) {}
    for (Integer localInteger = Integer.valueOf(paramLinkedList.size());; localInteger = null)
    {
      Log.i("FinderLiveWhiteListAdapter", localInteger);
      if (paramLinkedList == null) {
        break;
      }
      this.ppH.clear();
      this.ppH.addAll((Collection)paramLinkedList);
      this.ppH.add(new c(false, new avh(), 2));
      AppMethodBeat.o(247864);
      return;
    }
    AppMethodBeat.o(247864);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247862);
    int i = this.ppH.size();
    AppMethodBeat.o(247862);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(247863);
    paramInt = ((c)this.ppH.get(paramInt)).type;
    AppMethodBeat.o(247863);
    return paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$BottomViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class a
    extends RecyclerView.v
  {
    private TextView vr;
    
    public a()
    {
      super();
      AppMethodBeat.i(247857);
      this.vr = ((TextView)localObject.findViewById(2131310493));
      AppMethodBeat.o(247857);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$Companion;", "", "()V", "TAG", "", "TYPE_BOTTOM", "", "TYPE_NORMAL", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "", "choose", "", "audienceFile", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "type", "", "(ZLcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;I)V", "getAudienceFile", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChoose", "()Z", "setChoose", "(Z)V", "getType", "()I", "setType", "(I)V", "plugin-finder_release"})
  public static final class c
  {
    int type;
    public boolean uCe;
    public final avh uCf;
    
    public c(boolean paramBoolean, avh paramavh, int paramInt)
    {
      AppMethodBeat.i(247858);
      this.uCe = paramBoolean;
      this.uCf = paramavh;
      this.type = paramInt;
      AppMethodBeat.o(247858);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$WhiteListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;Landroid/view/View;)V", "check", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheck", "()Landroid/widget/CheckBox;", "setCheck", "(Landroid/widget/CheckBox;)V", "detail", "Landroid/widget/TextView;", "getDetail", "()Landroid/widget/TextView;", "setDetail", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class d
    extends RecyclerView.v
  {
    CheckBox uCg;
    TextView uCh;
    
    public d()
    {
      super();
      AppMethodBeat.i(247859);
      this.uCg = ((CheckBox)localObject.findViewById(2131310491));
      this.uCh = ((TextView)localObject.findViewById(2131310496));
      this$1 = this.uCg;
      p.g(i.this, "check");
      i.this.setClickable(false);
      AppMethodBeat.o(247859);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(i parami, i.c paramc, i.d paramd) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(247860);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = paramv;
      if (paramView != null)
      {
        localObject = paramv;
        if ((localObject != null) && (!((i.c)localObject).uCe))
        {
          bool1 = true;
          paramView.uCe = bool1;
        }
      }
      else
      {
        paramView = this.uCj.uCg;
        p.g(paramView, "holder.check");
        localObject = paramv;
        if ((localObject == null) || (((i.c)localObject).uCe != true)) {
          break label157;
        }
      }
      label157:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.setChecked(bool1);
        paramView = this.uCd.uCb;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247860);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.i
 * JD-Core Version:    0.7.0.1
 */