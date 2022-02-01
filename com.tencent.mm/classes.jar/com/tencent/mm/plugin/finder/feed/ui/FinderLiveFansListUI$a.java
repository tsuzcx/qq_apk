package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.loader.b;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axc;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "Landroid/widget/BaseAdapter;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "", "FansViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFansListUI$a
  extends BaseAdapter
{
  ArrayList<axc> pUj;
  
  public FinderLiveFansListUI$a()
  {
    AppMethodBeat.i(364354);
    this.pUj = new ArrayList();
    AppMethodBeat.o(364354);
  }
  
  private axc Oi(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(364364);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.pUj.size()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject = this.pUj.get(paramInt);
      s.s(localObject, "{\n                dataList[position]\n            }");
      localObject = (axc)localObject;
      AppMethodBeat.o(364364);
      return localObject;
    }
    Object localObject = new axc();
    AppMethodBeat.o(364364);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(364390);
    int i = this.pUj.size();
    AppMethodBeat.o(364390);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    AppMethodBeat.i(364377);
    s.u(paramViewGroup, "parent");
    View localView = paramView;
    if (paramView == null)
    {
      localView = View.inflate(paramViewGroup.getContext(), p.f.CdE, null);
      localView.setTag(new a(localView));
    }
    label68:
    Object localObject3;
    label101:
    Object localObject2;
    if (localView == null)
    {
      paramView = null;
      if (!(paramView instanceof a)) {
        break label222;
      }
      paramViewGroup = (a)paramView;
      if (paramViewGroup != null)
      {
        axc localaxc = Oi(paramInt);
        paramView = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCq();
        paramView = localaxc.contact;
        if (paramView != null) {
          break label227;
        }
        paramView = "";
        paramView = new b(paramView);
        localObject2 = paramViewGroup.avatar;
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((d)localObject3).a(paramView, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
        localObject2 = paramViewGroup.wBZ;
        localObject3 = paramViewGroup.wBZ.getContext();
        paramView = aw.Gjk;
        paramView = localaxc.contact;
        if (paramView != null) {
          break label247;
        }
        paramView = null;
        label166:
        paramViewGroup = localaxc.contact;
        if (paramViewGroup != null) {
          break label255;
        }
      }
    }
    label222:
    label227:
    label247:
    label255:
    for (paramViewGroup = localObject1;; paramViewGroup = paramViewGroup.nickname)
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)aw.is(paramView, paramViewGroup)));
      s.checkNotNull(localView);
      AppMethodBeat.o(364377);
      return localView;
      paramView = localView.getTag();
      break;
      paramViewGroup = null;
      break label68;
      localObject2 = paramView.headUrl;
      paramView = (View)localObject2;
      if (localObject2 != null) {
        break label101;
      }
      paramView = "";
      break label101;
      paramView = paramView.username;
      break label166;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter$FansViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    ImageView avatar;
    TextView wBZ;
    
    public a()
    {
      super();
      AppMethodBeat.i(365432);
      this$1 = localObject.findViewById(p.e.avatar_iv);
      s.s(FinderLiveFansListUI.a.this, "itemView.findViewById<ImageView>(R.id.avatar_iv)");
      this.avatar = ((ImageView)FinderLiveFansListUI.a.this);
      this$1 = localObject.findViewById(p.e.nickname_tv);
      s.s(FinderLiveFansListUI.a.this, "itemView.findViewById<TextView>(R.id.nickname_tv)");
      this.wBZ = ((TextView)FinderLiveFansListUI.a.this);
      AppMethodBeat.o(365432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI.a
 * JD-Core Version:    0.7.0.1
 */