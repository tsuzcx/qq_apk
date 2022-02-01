package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$FinderLiveWhiteListGroupData;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function1;)V", "webWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getWebWhiteList", "setWebWhiteList", "bindWhiteListViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$WhiteListViewHolder;", "position", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "updateDataList", "list", "updateWhiteList", "whiteListCanChoose", "", "ChatRoomInfo", "Companion", "FinderLiveWhiteListGroupData", "WhiteListViewHolder", "plugin-finder_release"})
public final class FinderLiveWhiteListGroupAdapter
  extends RecyclerView.a<RecyclerView.v>
{
  public static final a zay;
  private LinkedList<b> syG;
  public kotlin.g.a.b<? super Integer, x> yZZ;
  public LinkedList<ayj> zax;
  
  static
  {
    AppMethodBeat.i(287715);
    zay = new a((byte)0);
    AppMethodBeat.o(287715);
  }
  
  public FinderLiveWhiteListGroupAdapter()
  {
    AppMethodBeat.i(287714);
    this.zax = new LinkedList();
    this.syG = new LinkedList();
    AppMethodBeat.o(287714);
  }
  
  public final void av(LinkedList<b> paramLinkedList)
  {
    AppMethodBeat.i(287712);
    p.k(paramLinkedList, "list");
    Log.i("Finder.FinderLiveWhiteListGroupAdapter", "updateWhiteList,ori size:" + this.syG.size() + ",new size:" + paramLinkedList.size());
    this.syG.clear();
    this.syG.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(287712);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(287709);
    p.k(paramViewGroup, "parent");
    paramViewGroup = View.inflate(paramViewGroup.getContext(), b.g.finder_live_white_list_group_item_ui, null);
    p.j(paramViewGroup, "View.inflate(parent.cont…list_group_item_ui, null)");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(287709);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(287713);
    p.k(paramv, "holder");
    c localc;
    label44:
    Object localObject1;
    if ((paramv instanceof c))
    {
      localc = (c)paramv;
      int k = this.syG.size();
      if (paramInt < 0)
      {
        paramv = null;
        if (paramv == null) {
          break label99;
        }
        localObject1 = Integer.valueOf(paramv.type);
        label57:
        if (localObject1 != null) {
          break label105;
        }
        label62:
        if (localObject1 != null) {
          break label381;
        }
      }
      label99:
      label105:
      Object localObject2;
      label798:
      label803:
      for (;;)
      {
        label330:
        label476:
        label735:
        if (localObject1 == null)
        {
          AppMethodBeat.o(287713);
          return;
          if (k <= paramInt) {
            break;
          }
          paramv = (b)this.syG.get(paramInt);
          break label44;
          localObject1 = null;
          break label57;
          if (((Integer)localObject1).intValue() != 0) {
            break label62;
          }
          localObject1 = localc.jMg;
          localObject2 = localc.jMg;
          p.j(localObject2, "holder.title");
          localObject2 = ((TextView)localObject2).getContext();
          p.j(localObject2, "holder.title.context");
          ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.link_color));
          localObject1 = localc.jMg;
          p.j(localObject1, "holder.title");
          localObject2 = localc.jMg;
          p.j(localObject2, "holder.title");
          localObject2 = ((TextView)localObject2).getContext();
          p.j(localObject2, "holder.title.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_white_list_from_room));
          localObject1 = localc.msF;
          p.j(localObject1, "holder.desc");
          ((TextView)localObject1).setVisibility(8);
          localObject1 = (CharSequence)paramv.zaz;
          paramInt = j;
          if (localObject1 != null)
          {
            if (((CharSequence)localObject1).length() == 0) {
              paramInt = j;
            }
          }
          else
          {
            if (paramInt == 0) {
              break label330;
            }
            paramv = localc.zaB;
            p.j(paramv, "holder.selectedGroup");
            paramv.setVisibility(8);
          }
          for (;;)
          {
            localc.amk.setOnClickListener((View.OnClickListener)new d(this));
            AppMethodBeat.o(287713);
            return;
            paramInt = 0;
            break;
            localObject1 = localc.zaB;
            p.j(localObject1, "holder.selectedGroup");
            ((View)localObject1).setVisibility(0);
            localObject1 = localc.zaA;
            p.j(localObject1, "holder.selectedTv");
            ((TextView)localObject1).setText((CharSequence)paramv.zaz);
          }
          label381:
          if (((Integer)localObject1).intValue() == 1)
          {
            if (this.zax.size() > 0)
            {
              paramInt = 1;
              if (paramInt == 0) {
                break label735;
              }
              localObject1 = localc.jMg;
              localObject2 = localc.jMg;
              p.j(localObject2, "holder.title");
              localObject2 = ((TextView)localObject2).getContext();
              p.j(localObject2, "holder.title.context");
              ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.link_color));
              localc.amk.setOnClickListener((View.OnClickListener)new e(this));
              localObject1 = localc.jMg;
              p.j(localObject1, "holder.title");
              localObject2 = localc.jMg;
              p.j(localObject2, "holder.title");
              localObject2 = ((TextView)localObject2).getContext();
              p.j(localObject2, "holder.title.context");
              ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_white_list_from_web));
              localObject1 = localc.msF;
              localObject2 = localc.jMg;
              p.j(localObject2, "holder.title");
              localObject2 = ((TextView)localObject2).getContext();
              p.j(localObject2, "holder.title.context");
              ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_100_Alpha_0_3));
              localObject1 = localc.msF;
              p.j(localObject1, "holder.desc");
              localObject2 = localc.msF;
              p.j(localObject2, "holder.desc");
              localObject2 = ((TextView)localObject2).getContext();
              p.j(localObject2, "holder.desc.context");
              ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_visibility_no_white_list_tips));
              localObject1 = localc.msF;
              p.j(localObject1, "holder.desc");
              ((TextView)localObject1).setVisibility(0);
              localObject1 = (CharSequence)paramv.zaz;
              paramInt = i;
              if (localObject1 != null) {
                if (((CharSequence)localObject1).length() != 0) {
                  break label798;
                }
              }
            }
            for (paramInt = i;; paramInt = 0)
            {
              if (paramInt == 0) {
                break label803;
              }
              paramv = localc.zaB;
              p.j(paramv, "holder.selectedGroup");
              paramv.setVisibility(8);
              AppMethodBeat.o(287713);
              return;
              paramInt = 0;
              break;
              localObject1 = localc.jMg;
              localObject2 = localc.jMg;
              p.j(localObject2, "holder.title");
              localObject2 = ((TextView)localObject2).getContext();
              p.j(localObject2, "holder.title.context");
              ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_100_Alpha_0_3));
              localc.amk.setOnClickListener(null);
              break label476;
            }
            localObject1 = localc.zaB;
            p.j(localObject1, "holder.selectedGroup");
            ((View)localObject1).setVisibility(0);
            localObject1 = localc.zaA;
            p.j(localObject1, "holder.selectedTv");
            ((TextView)localObject1).setText((CharSequence)paramv.zaz);
            AppMethodBeat.o(287713);
            return;
          }
        }
      }
      if (((Integer)localObject1).intValue() == 2)
      {
        localObject1 = localc.jMg;
        localObject2 = localc.jMg;
        p.j(localObject2, "holder.title");
        localObject2 = ((TextView)localObject2).getContext();
        p.j(localObject2, "holder.title.context");
        ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.link_color));
        localObject1 = localc.jMg;
        p.j(localObject1, "holder.title");
        localObject2 = localc.jMg;
        p.j(localObject2, "holder.title");
        localObject2 = ((TextView)localObject2).getContext();
        p.j(localObject2, "holder.title.context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_white_list_from_user));
        localObject1 = localc.msF;
        p.j(localObject1, "holder.desc");
        ((TextView)localObject1).setVisibility(8);
        localObject1 = (CharSequence)paramv.zaz;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1074;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label1079;
        }
        paramv = localc.zaB;
        p.j(paramv, "holder.selectedGroup");
        paramv.setVisibility(8);
      }
    }
    for (;;)
    {
      localc.amk.setOnClickListener((View.OnClickListener)new f(this));
      AppMethodBeat.o(287713);
      return;
      label1074:
      paramInt = 0;
      break;
      label1079:
      localObject1 = localc.zaB;
      p.j(localObject1, "holder.selectedGroup");
      ((View)localObject1).setVisibility(0);
      localObject1 = localc.zaA;
      p.j(localObject1, "holder.selectedTv");
      ((TextView)localObject1).setText((CharSequence)paramv.zaz);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(287710);
    int i = this.syG.size();
    AppMethodBeat.o(287710);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(287711);
    paramInt = ((b)this.syG.get(paramInt)).type;
    AppMethodBeat.o(287711);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "nickname", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"})
  public static final class ChatRoomInfo
    implements Parcelable
  {
    public static final a CREATOR;
    private final String nickname;
    private final String username;
    
    static
    {
      AppMethodBeat.i(266508);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(266508);
    }
    
    public ChatRoomInfo(Parcel paramParcel)
    {
      this(paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.i(266506);
      AppMethodBeat.o(266506);
    }
    
    private ChatRoomInfo(String paramString1, String paramString2)
    {
      this.username = paramString1;
      this.nickname = paramString2;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(266511);
      if (this != paramObject)
      {
        if ((paramObject instanceof ChatRoomInfo))
        {
          paramObject = (ChatRoomInfo)paramObject;
          if ((!p.h(this.username, paramObject.username)) || (!p.h(this.nickname, paramObject.nickname))) {}
        }
      }
      else
      {
        AppMethodBeat.o(266511);
        return true;
      }
      AppMethodBeat.o(266511);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(266510);
      String str = this.username;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.nickname;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(266510);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(266509);
      String str = "ChatRoomInfo(username=" + this.username + ", nickname=" + this.nickname + ")";
      AppMethodBeat.o(266509);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(266504);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.nickname);
      AppMethodBeat.o(266504);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "plugin-finder_release"})
    public static final class a
      implements Parcelable.Creator<FinderLiveWhiteListGroupAdapter.ChatRoomInfo>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$Companion;", "", "()V", "TAG", "", "WHITE_LIST_GROUP_TYPE_ROOM", "", "WHITE_LIST_GROUP_TYPE_WEB", "WHITE_LIST_TYPE_USER", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$FinderLiveWhiteListGroupData;", "", "type", "", "selectedInfo", "", "(ILjava/lang/String;)V", "getSelectedInfo", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    final int type;
    final String zaz;
    
    public b(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.zaz = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(272877);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.type != paramObject.type) || (!p.h(this.zaz, paramObject.zaz))) {}
        }
      }
      else
      {
        AppMethodBeat.o(272877);
        return true;
      }
      AppMethodBeat.o(272877);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(272876);
      int j = this.type;
      String str = this.zaz;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(272876);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(272874);
      String str = "FinderLiveWhiteListGroupData(type=" + this.type + ", selectedInfo=" + this.zaz + ")";
      AppMethodBeat.o(272874);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$WhiteListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "selectedGroup", "getSelectedGroup", "()Landroid/view/View;", "setSelectedGroup", "(Landroid/view/View;)V", "selectedTv", "getSelectedTv", "setSelectedTv", "title", "getTitle", "setTitle", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView jMg;
    TextView msF;
    TextView zaA;
    View zaB;
    
    public c()
    {
      super();
      AppMethodBeat.i(272396);
      this.jMg = ((TextView)localObject.findViewById(b.f.finder_live_white_list_item_title_tv));
      this.msF = ((TextView)localObject.findViewById(b.f.finder_live_white_list_item_desc_tv));
      this.zaA = ((TextView)localObject.findViewById(b.f.finder_live_white_list_item_selected_tv));
      this.zaB = localObject.findViewById(b.f.finder_live_white_list_item_selected_group);
      AppMethodBeat.o(272396);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257844);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.zaC.yZZ;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(0));
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257844);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227109);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.zaC.yZZ;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(1));
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227109);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderLiveWhiteListGroupAdapter paramFinderLiveWhiteListGroupAdapter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265335);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.zaC.yZZ;
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(2));
      }
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter
 * JD-Core Version:    0.7.0.1
 */