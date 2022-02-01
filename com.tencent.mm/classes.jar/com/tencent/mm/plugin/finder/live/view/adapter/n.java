package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgx;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$AbsFansListViewHolder;", "()V", "DEFAULT_MEMBER_NICKNAME_MAX_WIDTH", "", "getDEFAULT_MEMBER_NICKNAME_MAX_WIDTH", "()I", "setDEFAULT_MEMBER_NICKNAME_MAX_WIDTH", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$FinderLiveContactInfo;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "itemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/ParameterName;", "name", "contact", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "memberCount", "getMemberCount", "setMemberCount", "bindFansItem", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$FansListViewHolder;", "position", "bindFansTitle", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$FansTitleViewHolder;", "getItemCount", "getItemViewType", "mergeMemberList", "fansMembers", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubMember;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateMemberList", "AbsFansListViewHolder", "Companion", "FansListViewHolder", "FansTitleViewHolder", "FinderLiveContactInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends RecyclerView.a<a>
{
  public static final b DQF;
  private int DQG;
  public int hQS;
  public kotlin.g.a.b<? super bgh, ah> nod;
  public ArrayList<e> pUj;
  
  static
  {
    AppMethodBeat.i(358690);
    DQF = new b((byte)0);
    AppMethodBeat.o(358690);
  }
  
  public n()
  {
    AppMethodBeat.i(358670);
    this.pUj = new ArrayList();
    this.DQG = MMApplicationContext.getResources().getDimensionPixelOffset(p.c.Edge_24A);
    AppMethodBeat.o(358670);
  }
  
  private static final void a(n paramn, bgh parambgh, View paramView)
  {
    AppMethodBeat.i(358681);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramn);
    localb.cH(parambgh);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramn, "this$0");
    paramn = paramn.nod;
    if (paramn != null) {
      paramn.invoke(parambgh);
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358681);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358705);
    int i = this.pUj.size();
    AppMethodBeat.o(358705);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(358713);
    paramInt = ((e)this.pUj.get(paramInt)).type;
    AppMethodBeat.o(358713);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$AbsFansListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(358774);
      AppMethodBeat.o(358774);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$Companion;", "", "()V", "TAG", "", "TYPE_FANS_ITEM", "", "TYPE_FANS_TITLE", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$FansListViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$AbsFansListViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;Landroid/view/View;)V", "closeValue", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCloseValue", "()Landroid/widget/TextView;", "fansTag", "getFansTag", "finder", "Landroid/widget/ImageView;", "getFinder", "()Landroid/widget/ImageView;", "nickName", "getNickName", "rank", "getRank", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends n.a
  {
    final TextView DQI;
    final ImageView DQJ;
    final TextView DQK;
    final TextView DQL;
    final TextView wBZ;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(358799);
      this.DQI = ((TextView)localObject.findViewById(p.e.Caf));
      this.wBZ = ((TextView)localObject.findViewById(p.e.nickname));
      this.DQJ = ((ImageView)localObject.findViewById(p.e.finder));
      this.DQK = ((TextView)localObject.findViewById(p.e.BDQ));
      this.DQL = ((TextView)localObject.findViewById(p.e.BCl));
      this.DQI.setTextSize(1, 15.0F);
      this.wBZ.setTextSize(1, 17.0F);
      this.DQL.setTextSize(1, 17.0F);
      AppMethodBeat.o(358799);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$FansTitleViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$AbsFansListViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;Landroid/view/View;)V", "closeValueTips", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCloseValueTips", "()Landroid/widget/TextView;", "setCloseValueTips", "(Landroid/widget/TextView;)V", "fansNum", "getFansNum", "setFansNum", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends n.a
  {
    TextView DQM;
    private TextView DQN;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(358812);
      this.DQM = ((TextView)localObject.findViewById(p.e.BDN));
      this.DQN = ((TextView)localObject.findViewById(p.e.BCm));
      AppMethodBeat.o(358812);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter$FinderLiveContactInfo;", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubMember;", "type", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubMember;I)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubMember;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    final bgx DQO;
    final int type;
    
    public e(bgx parambgx, int paramInt)
    {
      this.DQO = parambgx;
      this.type = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(358840);
      if (this == paramObject)
      {
        AppMethodBeat.o(358840);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(358840);
        return false;
      }
      paramObject = (e)paramObject;
      if (!s.p(this.DQO, paramObject.DQO))
      {
        AppMethodBeat.o(358840);
        return false;
      }
      if (this.type != paramObject.type)
      {
        AppMethodBeat.o(358840);
        return false;
      }
      AppMethodBeat.o(358840);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(358832);
      if (this.DQO == null) {}
      for (int i = 0;; i = this.DQO.hashCode())
      {
        int j = this.type;
        AppMethodBeat.o(358832);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(358825);
      String str = "FinderLiveContactInfo(contact=" + this.DQO + ", type=" + this.type + ')';
      AppMethodBeat.o(358825);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.n
 * JD-Core Version:    0.7.0.1
 */