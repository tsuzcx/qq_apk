package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "curRoleType", "", "getCurRoleType", "()I", "setCurRoleType", "(I)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "enableCreate", "", "getEnableCreate", "()Z", "setEnableCreate", "(Z)V", "onItemClikListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "chooseItem", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClikListener", "Lkotlin/Function2;", "Landroid/view/View;", "itemView", "getOnItemLongClikListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClikListener", "(Lkotlin/jvm/functions/Function2;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$BottomViewHolder;", "position", "bindVisitorModeViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$VisitorModeViewHolder;", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateAliasInfoList", "roleType", "list", "BottomViewHolder", "Companion", "VisitorModeViewHolder", "plugin-finder_release"})
public final class z
  extends RecyclerView.a<RecyclerView.v>
{
  public static final b zad;
  private LinkedList<axc> syG;
  public kotlin.g.a.b<? super axc, x> yZZ;
  public m<? super axc, ? super View, x> zaa;
  int zab;
  boolean zac;
  
  static
  {
    AppMethodBeat.i(291999);
    zad = new b((byte)0);
    AppMethodBeat.o(291999);
  }
  
  public z()
  {
    AppMethodBeat.i(291998);
    this.syG = new LinkedList();
    this.zab = 1;
    AppMethodBeat.o(291998);
  }
  
  private final axc NT(int paramInt)
  {
    AppMethodBeat.i(291997);
    int i = this.syG.size();
    if (paramInt < 0) {}
    while (i <= paramInt)
    {
      AppMethodBeat.o(291997);
      return null;
    }
    axc localaxc = (axc)this.syG.get(paramInt);
    AppMethodBeat.o(291997);
    return localaxc;
  }
  
  public final void a(int paramInt, LinkedList<axc> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(291994);
    StringBuilder localStringBuilder = new StringBuilder("updateAliasInfoList,ori size:").append(this.syG.size()).append(",new size:");
    if (paramLinkedList != null) {}
    for (Object localObject = Integer.valueOf(paramLinkedList.size());; localObject = null)
    {
      Log.i("FinderLiveVisitorRoleAdapter", localObject + ",curroleType:" + this.zab + ",roleType:" + paramInt + ",enableCreate:" + paramBoolean);
      this.zab = paramInt;
      this.zac = paramBoolean;
      if (paramLinkedList == null) {
        break;
      }
      this.syG.clear();
      this.syG.addAll((Collection)paramLinkedList);
      paramLinkedList = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.ar(this.syG))
      {
        paramLinkedList = this.syG;
        localObject = new axc();
        ((axc)localObject).SJy = 10001;
        paramLinkedList.add(localObject);
      }
      AppMethodBeat.o(291994);
      return;
    }
    AppMethodBeat.o(291994);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(291991);
    p.k(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = View.inflate(paramViewGroup.getContext(), b.g.finder_live_visitor_role_item_ui, null);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(291991);
      return paramViewGroup;
    }
    paramViewGroup = View.inflate(paramViewGroup.getContext(), b.g.finder_live_visitor_role_create_item_ui, null);
    p.j(paramViewGroup, "itemView");
    paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
    AppMethodBeat.o(291991);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, final int paramInt)
  {
    AppMethodBeat.i(291995);
    p.k(paramv, "holder");
    Object localObject1;
    Object localObject2;
    if ((paramv instanceof c))
    {
      paramv = (c)paramv;
      localObject1 = NT(paramInt);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
        localObject2 = com.tencent.mm.plugin.finder.loader.t.dJi();
        Object localObject3 = new e(((axc)localObject1).ueX);
        ImageView localImageView = paramv.mWb;
        com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
        ((d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
        paramv.zai.setText((CharSequence)((axc)localObject1).nickname);
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.NI(((axc)localObject1).SJy);
        localObject3 = (CharSequence)localObject2;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label232;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label237;
        }
        paramv.zaj.setVisibility(8);
        label149:
        if (((axc)localObject1).SJy != this.zab) {
          break label260;
        }
        paramv.zak.setVisibility(0);
      }
      for (;;)
      {
        localObject2 = paramv.amk;
        p.j(localObject2, "holder.itemView");
        ((View)localObject2).setTag(localObject1);
        paramv.amk.setOnClickListener((View.OnClickListener)new e(this, paramv));
        paramv.amk.setOnLongClickListener((View.OnLongClickListener)new f(this));
        AppMethodBeat.o(291995);
        return;
        label232:
        paramInt = 0;
        break;
        label237:
        paramv.zaj.setVisibility(0);
        paramv.zaj.setText((CharSequence)localObject2);
        break label149;
        label260:
        paramv.zak.setVisibility(4);
      }
    }
    if ((paramv instanceof a))
    {
      paramv = (a)paramv;
      if (!this.zac) {
        break label391;
      }
      localObject1 = paramv.zae;
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_9));
      localObject1 = paramv.zaf;
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_9));
      paramv.zag.setVisibility(0);
    }
    for (;;)
    {
      paramv.amk.setOnClickListener((View.OnClickListener)new d(this, paramInt, paramv));
      AppMethodBeat.o(291995);
      return;
      label391:
      localObject1 = paramv.zae;
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_5));
      localObject1 = paramv.zaf;
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      ((TextView)localObject1).setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_5));
      paramv.zag.setVisibility(4);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(291992);
    int i = this.syG.size();
    AppMethodBeat.o(291992);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(291993);
    paramInt = ((axc)this.syG.get(paramInt)).SJy;
    AppMethodBeat.o(291993);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$BottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;Landroid/view/View;)V", "createArrowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCreateArrowIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCreateArrowIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "createIv", "getCreateIv", "setCreateIv", "createTv", "Landroid/widget/TextView;", "getCreateTv", "()Landroid/widget/TextView;", "setCreateTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class a
    extends RecyclerView.v
  {
    WeImageView zae;
    TextView zaf;
    WeImageView zag;
    
    public a()
    {
      super();
      AppMethodBeat.i(282076);
      this$1 = localObject.findViewById(b.f.visitor_create_iv);
      p.j(z.this, "itemView.findViewById(R.id.visitor_create_iv)");
      this.zae = ((WeImageView)z.this);
      this$1 = localObject.findViewById(b.f.visitor_create_tv);
      p.j(z.this, "itemView.findViewById(R.id.visitor_create_tv)");
      this.zaf = ((TextView)z.this);
      this$1 = localObject.findViewById(b.f.visitor_create_arrow_iv);
      p.j(z.this, "itemView.findViewById(R.….visitor_create_arrow_iv)");
      this.zag = ((WeImageView)z.this);
      AppMethodBeat.o(282076);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$Companion;", "", "()V", "TAG", "", "TYPE_BOTTOM", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$VisitorModeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "chooser", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getChooser", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setChooser", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mode", "Landroid/widget/TextView;", "getMode", "()Landroid/widget/TextView;", "setMode", "(Landroid/widget/TextView;)V", "nickname", "getNickname", "setNickname", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    ImageView mWb;
    TextView zai;
    TextView zaj;
    WeImageView zak;
    
    public c()
    {
      super();
      AppMethodBeat.i(291235);
      this$1 = localObject.findViewById(b.f.visitor_avatar_iv);
      p.j(z.this, "itemView.findViewById(R.id.visitor_avatar_iv)");
      this.mWb = ((ImageView)z.this);
      this$1 = localObject.findViewById(b.f.visitor_nick_name_tv);
      p.j(z.this, "itemView.findViewById(R.id.visitor_nick_name_tv)");
      this.zai = ((TextView)z.this);
      this$1 = localObject.findViewById(b.f.visitor_mode_tips_tv);
      p.j(z.this, "itemView.findViewById(R.id.visitor_mode_tips_tv)");
      this.zaj = ((TextView)z.this);
      this$1 = localObject.findViewById(b.f.visitor_choose_iv);
      p.j(z.this, "itemView.findViewById(R.id.visitor_choose_iv)");
      this.zak = ((WeImageView)z.this);
      AppMethodBeat.o(291235);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(z paramz, int paramInt, z.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280180);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindBottomViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (this.zah.zac)
      {
        localObject = z.a(this.zah, paramInt);
        kotlin.g.a.b localb = this.zah.yZZ;
        if (localb != null)
        {
          paramView = (View)localObject;
          if (localObject == null)
          {
            paramView = new axc();
            paramView.SJy = 10001;
          }
          localb.invoke(paramView);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindBottomViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(280180);
        return;
        paramView = paramv.amk;
        p.j(paramView, "holder.itemView");
        paramView = paramView.getContext();
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        w.a(paramView, ((Context)localObject).getResources().getString(b.j.finder_live_visitor_role_ban_edit), (w.b)1.zam);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(z paramz, z.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283665);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.j(paramView, "it");
      if ((paramView.getTag() instanceof axc))
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAliasInfo");
          AppMethodBeat.o(283665);
          throw paramView;
        }
        paramView = (axc)paramView;
        this.zah.zab = paramView.SJy;
        localObject = this.zah.yZZ;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramView);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(283665);
        return;
        localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject = paramv.amk;
        p.j(localObject, "holder.itemView");
        localObject = ((View)localObject).getContext();
        p.j(localObject, "holder.itemView.context");
        com.tencent.mm.plugin.finder.live.utils.a.aC((Context)localObject, "type error!");
        Log.e("FinderLiveVisitorRoleAdapter", "bindVisitorModeViewHolder it.tag:" + paramView.getTag());
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class f
    implements View.OnLongClickListener
  {
    f(z paramz) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(280085);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.j(paramView, "it");
      if ((paramView.getTag() instanceof axc))
      {
        localObject = paramView.getTag();
        if (localObject == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAliasInfo");
          AppMethodBeat.o(280085);
          throw paramView;
        }
        localObject = (axc)localObject;
        m localm = this.zah.zaa;
        if (localm != null) {
          localm.invoke(localObject, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(280085);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.z
 * JD-Core Version:    0.7.0.1
 */