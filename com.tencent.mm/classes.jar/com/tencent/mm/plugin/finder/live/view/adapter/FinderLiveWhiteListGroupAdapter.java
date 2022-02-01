package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$FinderLiveWhiteListGroupData;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function1;)V", "webWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getWebWhiteList", "setWebWhiteList", "bindWhiteListViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$WhiteListViewHolder;", "position", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "updateDataList", "list", "updateWhiteList", "whiteListCanChoose", "", "ChatRoomInfo", "Companion", "FinderLiveWhiteListGroupData", "WhiteListViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWhiteListGroupAdapter
  extends RecyclerView.a<RecyclerView.v>
{
  public static final FinderLiveWhiteListGroupAdapter.a DTX;
  public kotlin.g.a.b<? super Integer, ah> DTG;
  public LinkedList<bfh> DTY;
  private LinkedList<FinderLiveWhiteListGroupAdapter.b> vEn;
  
  static
  {
    AppMethodBeat.i(359141);
    DTX = new FinderLiveWhiteListGroupAdapter.a((byte)0);
    AppMethodBeat.o(359141);
  }
  
  public FinderLiveWhiteListGroupAdapter()
  {
    AppMethodBeat.i(359101);
    this.DTY = new LinkedList();
    this.vEn = new LinkedList();
    AppMethodBeat.o(359101);
  }
  
  private static final void a(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter, View paramView)
  {
    AppMethodBeat.i(359108);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveWhiteListGroupAdapter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveWhiteListGroupAdapter, "this$0");
    paramFinderLiveWhiteListGroupAdapter = paramFinderLiveWhiteListGroupAdapter.DTG;
    if (paramFinderLiveWhiteListGroupAdapter != null) {
      paramFinderLiveWhiteListGroupAdapter.invoke(Integer.valueOf(0));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359108);
  }
  
  private static final void b(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter, View paramView)
  {
    AppMethodBeat.i(359116);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveWhiteListGroupAdapter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveWhiteListGroupAdapter, "this$0");
    paramFinderLiveWhiteListGroupAdapter = paramFinderLiveWhiteListGroupAdapter.DTG;
    if (paramFinderLiveWhiteListGroupAdapter != null) {
      paramFinderLiveWhiteListGroupAdapter.invoke(Integer.valueOf(1));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359116);
  }
  
  private static final void c(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter, View paramView)
  {
    AppMethodBeat.i(359123);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveWhiteListGroupAdapter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveWhiteListGroupAdapter, "this$0");
    paramFinderLiveWhiteListGroupAdapter = paramFinderLiveWhiteListGroupAdapter.DTG;
    if (paramFinderLiveWhiteListGroupAdapter != null) {
      paramFinderLiveWhiteListGroupAdapter.invoke(Integer.valueOf(2));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359123);
  }
  
  private static final void d(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter, View paramView)
  {
    AppMethodBeat.i(359130);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveWhiteListGroupAdapter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveWhiteListGroupAdapter, "this$0");
    paramFinderLiveWhiteListGroupAdapter = paramFinderLiveWhiteListGroupAdapter.DTG;
    if (paramFinderLiveWhiteListGroupAdapter != null) {
      paramFinderLiveWhiteListGroupAdapter.invoke(Integer.valueOf(3));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359130);
  }
  
  private static final void e(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter, View paramView)
  {
    AppMethodBeat.i(359137);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveWhiteListGroupAdapter);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveWhiteListGroupAdapter, "this$0");
    paramFinderLiveWhiteListGroupAdapter = paramFinderLiveWhiteListGroupAdapter.DTG;
    if (paramFinderLiveWhiteListGroupAdapter != null) {
      paramFinderLiveWhiteListGroupAdapter.invoke(Integer.valueOf(4));
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(359137);
  }
  
  public final void az(LinkedList<FinderLiveWhiteListGroupAdapter.b> paramLinkedList)
  {
    AppMethodBeat.i(359202);
    s.u(paramLinkedList, "list");
    Log.i("Finder.FinderLiveWhiteListGroupAdapter", "updateWhiteList,ori size:" + this.vEn.size() + ",new size:" + Integer.valueOf(paramLinkedList.size()));
    this.vEn.clear();
    this.vEn.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(359202);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(359183);
    s.u(paramViewGroup, "parent");
    paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.Cgl, null);
    s.s(paramViewGroup, "inflate(parent.context, …list_group_item_ui, null)");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(359183);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    int j = 1;
    int m = 1;
    int n = 1;
    int k = 1;
    AppMethodBeat.i(359232);
    s.u(paramv, "holder");
    c localc;
    if ((paramv instanceof c))
    {
      localc = (c)paramv;
      int i;
      label71:
      Object localObject;
      if (paramInt >= 0) {
        if (paramInt < this.vEn.size())
        {
          i = 1;
          if (i == 0) {
            break label120;
          }
          paramv = (FinderLiveWhiteListGroupAdapter.b)this.vEn.get(paramInt);
          if (paramv != null) {
            break label125;
          }
          localObject = null;
          label78:
          if (localObject != null) {
            break label137;
          }
          label83:
          if (localObject != null) {
            break label307;
          }
          label88:
          if (localObject != null) {
            break label592;
          }
          label93:
          if (localObject != null) {
            break label763;
          }
        }
      }
      label519:
      for (;;)
      {
        label137:
        label907:
        if (localObject == null)
        {
          AppMethodBeat.o(359232);
          return;
          i = 0;
          break;
          i = 0;
          break;
          label120:
          paramv = null;
          break label71;
          label125:
          localObject = Integer.valueOf(paramv.type);
          break label78;
          if (((Integer)localObject).intValue() != 0) {
            break label83;
          }
          localc.mll.setTextColor(localc.mll.getContext().getResources().getColor(p.b.link_color));
          localc.mll.setText((CharSequence)localc.mll.getContext().getResources().getString(p.h.CtW));
          localc.pmf.setVisibility(8);
          localObject = (CharSequence)paramv.DTZ;
          paramInt = k;
          if (localObject != null)
          {
            if (((CharSequence)localObject).length() == 0) {
              paramInt = k;
            }
          }
          else
          {
            if (paramInt == 0) {
              break label280;
            }
            localc.DUb.setVisibility(8);
          }
          for (;;)
          {
            localc.caK.setOnClickListener(new FinderLiveWhiteListGroupAdapter..ExternalSyntheticLambda0(this));
            AppMethodBeat.o(359232);
            return;
            paramInt = 0;
            break;
            label280:
            localc.DUb.setVisibility(0);
            localc.DUa.setText((CharSequence)paramv.DTZ);
          }
          label307:
          if (((Integer)localObject).intValue() != 1) {
            break label88;
          }
          if (this.DTY.size() > 0)
          {
            paramInt = 1;
            if (paramInt == 0) {
              break label519;
            }
            localc.mll.setTextColor(localc.mll.getContext().getResources().getColor(p.b.link_color));
            localc.caK.setOnClickListener(new FinderLiveWhiteListGroupAdapter..ExternalSyntheticLambda2(this));
            label373:
            localc.mll.setText((CharSequence)localc.mll.getContext().getResources().getString(p.h.CtY));
            localc.pmf.setTextColor(localc.mll.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
            localc.pmf.setText((CharSequence)localc.pmf.getContext().getResources().getString(p.h.finder_live_visibility_no_white_list_tips));
            localc.pmf.setVisibility(0);
            localObject = (CharSequence)paramv.DTZ;
            paramInt = j;
            if (localObject != null) {
              if (((CharSequence)localObject).length() != 0) {
                break label556;
              }
            }
          }
          label556:
          for (paramInt = j;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label561;
            }
            localc.DUb.setVisibility(8);
            AppMethodBeat.o(359232);
            return;
            paramInt = 0;
            break;
            localc.mll.setTextColor(localc.mll.getContext().getResources().getColor(p.b.BW_100_Alpha_0_3));
            localc.caK.setOnClickListener(null);
            break label373;
          }
          label561:
          localc.DUb.setVisibility(0);
          localc.DUa.setText((CharSequence)paramv.DTZ);
          AppMethodBeat.o(359232);
          return;
          label592:
          if (((Integer)localObject).intValue() != 2) {
            break label93;
          }
          localc.mll.setTextColor(localc.mll.getContext().getResources().getColor(p.b.link_color));
          localc.mll.setText((CharSequence)localc.mll.getContext().getResources().getString(p.h.CtX));
          localc.pmf.setVisibility(8);
          localObject = (CharSequence)paramv.DTZ;
          paramInt = m;
          if (localObject != null)
          {
            if (((CharSequence)localObject).length() == 0) {
              paramInt = m;
            }
          }
          else
          {
            if (paramInt == 0) {
              break label736;
            }
            localc.DUb.setVisibility(8);
          }
          for (;;)
          {
            localc.caK.setOnClickListener(new FinderLiveWhiteListGroupAdapter..ExternalSyntheticLambda4(this));
            AppMethodBeat.o(359232);
            return;
            paramInt = 0;
            break;
            label736:
            localc.DUb.setVisibility(0);
            localc.DUa.setText((CharSequence)paramv.DTZ);
          }
          label763:
          if (((Integer)localObject).intValue() == 3)
          {
            localc.mll.setTextColor(localc.mll.getContext().getResources().getColor(p.b.link_color));
            localc.mll.setText((CharSequence)localc.mll.getContext().getResources().getString(p.h.CiT));
            localc.pmf.setVisibility(8);
            localObject = (CharSequence)paramv.DTZ;
            paramInt = n;
            if (localObject != null)
            {
              if (((CharSequence)localObject).length() == 0) {
                paramInt = n;
              }
            }
            else
            {
              if (paramInt == 0) {
                break label907;
              }
              localc.DUb.setVisibility(8);
            }
            for (;;)
            {
              localc.caK.setOnClickListener(new FinderLiveWhiteListGroupAdapter..ExternalSyntheticLambda1(this));
              AppMethodBeat.o(359232);
              return;
              paramInt = 0;
              break;
              localc.DUb.setVisibility(0);
              localc.DUa.setText((CharSequence)paramv.DTZ);
            }
          }
        }
      }
      if (((Integer)localObject).intValue() == 4)
      {
        localc.mll.setTextColor(localc.mll.getContext().getResources().getColor(p.b.link_color));
        localc.mll.setText((CharSequence)localc.mll.getContext().getResources().getString(p.h.CjJ));
        localc.pmf.setVisibility(8);
        localObject = (CharSequence)paramv.DTZ;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label1069;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label1074;
        }
        localc.DUb.setVisibility(8);
      }
    }
    for (;;)
    {
      localc.caK.setOnClickListener(new FinderLiveWhiteListGroupAdapter..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(359232);
      return;
      label1069:
      paramInt = 0;
      break;
      label1074:
      localc.DUb.setVisibility(0);
      localc.DUa.setText((CharSequence)paramv.DTZ);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(359190);
    int i = this.vEn.size();
    AppMethodBeat.o(359190);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(359195);
    paramInt = ((FinderLiveWhiteListGroupAdapter.b)this.vEn.get(paramInt)).type;
    AppMethodBeat.o(359195);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$WhiteListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "selectedGroup", "getSelectedGroup", "()Landroid/view/View;", "setSelectedGroup", "(Landroid/view/View;)V", "selectedTv", "getSelectedTv", "setSelectedTv", "title", "getTitle", "setTitle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
  {
    TextView DUa;
    View DUb;
    TextView mll;
    TextView pmf;
    
    public c()
    {
      super();
      AppMethodBeat.i(358626);
      this.mll = ((TextView)localObject.findViewById(p.e.BUu));
      this.pmf = ((TextView)localObject.findViewById(p.e.BUr));
      this.DUa = ((TextView)localObject.findViewById(p.e.BUt));
      this.DUb = localObject.findViewById(p.e.BUs);
      AppMethodBeat.o(358626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter
 * JD-Core Version:    0.7.0.1
 */