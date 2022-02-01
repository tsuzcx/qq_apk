package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "curRoleType", "", "getCurRoleType", "()I", "setCurRoleType", "(I)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "enableCreate", "", "getEnableCreate", "()Z", "setEnableCreate", "(Z)V", "onItemClikListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "chooseItem", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClikListener", "Lkotlin/Function2;", "Landroid/view/View;", "itemView", "getOnItemLongClikListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClikListener", "(Lkotlin/jvm/functions/Function2;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$BottomViewHolder;", "position", "bindVisitorModeViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$VisitorModeViewHolder;", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateAliasInfoList", "roleType", "list", "BottomViewHolder", "Companion", "VisitorModeViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends RecyclerView.a<RecyclerView.v>
{
  public static final ai.b DTF;
  public kotlin.g.a.b<? super bcz, ah> DTG;
  public m<? super bcz, ? super View, ah> DTH;
  private int DTI;
  private boolean DTJ;
  private LinkedList<bcz> vEn;
  
  static
  {
    AppMethodBeat.i(358860);
    DTF = new ai.b((byte)0);
    AppMethodBeat.o(358860);
  }
  
  public ai()
  {
    AppMethodBeat.i(358803);
    this.vEn = new LinkedList();
    this.DTI = 1;
    AppMethodBeat.o(358803);
  }
  
  private final bcz PF(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(358810);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.vEn.size()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      bcz localbcz = (bcz)this.vEn.get(paramInt);
      AppMethodBeat.o(358810);
      return localbcz;
    }
    AppMethodBeat.o(358810);
    return null;
  }
  
  private static final void a(ai paramai, int paramInt, a parama, View paramView)
  {
    AppMethodBeat.i(358853);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramai);
    localb.sc(paramInt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramai, "this$0");
    s.u(parama, "$holder");
    if (paramai.DTJ)
    {
      parama = paramai.PF(paramInt);
      paramView = paramai.DTG;
      if (paramView != null)
      {
        paramai = parama;
        if (parama == null)
        {
          paramai = new bcz();
          paramai.ZNI = 10001;
          parama = ah.aiuX;
        }
        paramView.invoke(paramai);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358853);
      return;
      aa.a(parama.caK.getContext(), MMApplicationContext.getContext().getResources().getString(p.h.CtF), ai..ExternalSyntheticLambda3.INSTANCE);
    }
  }
  
  private static final void a(ai paramai, c paramc, View paramView)
  {
    AppMethodBeat.i(358821);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramai);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramai, "this$0");
    s.u(paramc, "$holder");
    if ((paramView.getTag() instanceof bcz))
    {
      paramc = paramView.getTag();
      if (paramc == null)
      {
        paramai = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAliasInfo");
        AppMethodBeat.o(358821);
        throw paramai;
      }
      paramc = (bcz)paramc;
      paramai.DTI = paramc.ZNI;
      paramai = paramai.DTG;
      if (paramai != null) {
        paramai.invoke(paramc);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358821);
      return;
      paramai = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramai = paramc.caK.getContext();
      s.s(paramai, "holder.itemView.context");
      com.tencent.mm.plugin.finder.live.utils.a.aD(paramai, "type error!");
      Log.e("FinderLiveVisitorRoleAdapter", s.X("bindVisitorModeViewHolder it.tag:", paramView.getTag()));
    }
  }
  
  private static final boolean a(ai paramai, View paramView)
  {
    AppMethodBeat.i(358830);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramai);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramai, "this$0");
    if ((paramView.getTag() instanceof bcz))
    {
      localObject = paramView.getTag();
      if (localObject == null)
      {
        paramai = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAliasInfo");
        AppMethodBeat.o(358830);
        throw paramai;
      }
      localObject = (bcz)localObject;
      paramai = paramai.DTH;
      if (paramai != null)
      {
        s.s(paramView, "it");
        paramai.invoke(localObject, paramView);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(358830);
    return true;
  }
  
  private static final void gj(View paramView)
  {
    AppMethodBeat.i(358844);
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_error);
      }
    }
    AppMethodBeat.o(358844);
  }
  
  public final void a(int paramInt, LinkedList<bcz> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(358909);
    Object localObject2 = new StringBuilder("updateAliasInfoList,ori size:").append(this.vEn.size()).append(",new size:");
    if (paramLinkedList == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramLinkedList.size()))
    {
      Log.i("FinderLiveVisitorRoleAdapter", localObject1 + ",curroleType:" + this.DTI + ",roleType:" + paramInt + ",enableCreate:" + paramBoolean);
      this.DTI = paramInt;
      this.DTJ = paramBoolean;
      if (paramLinkedList != null)
      {
        this.vEn.clear();
        this.vEn.addAll((Collection)paramLinkedList);
        paramLinkedList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.as(this.vEn))
        {
          paramLinkedList = this.vEn;
          localObject1 = new bcz();
          ((bcz)localObject1).ZNI = 10001;
          localObject2 = ah.aiuX;
          paramLinkedList.add(localObject1);
        }
      }
      AppMethodBeat.o(358909);
      return;
    }
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(358891);
    s.u(paramViewGroup, "parent");
    if (paramInt == 10001)
    {
      paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.Cgb, null);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new a(paramViewGroup);
      AppMethodBeat.o(358891);
      return paramViewGroup;
    }
    paramViewGroup = View.inflate(paramViewGroup.getContext(), p.f.Cgd, null);
    s.s(paramViewGroup, "itemView");
    paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
    AppMethodBeat.o(358891);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(358922);
    s.u(paramv, "holder");
    if ((paramv instanceof c))
    {
      paramv = (c)paramv;
      bcz localbcz = PF(paramInt);
      Object localObject1;
      if (localbcz != null)
      {
        localObject1 = p.ExI;
        localObject1 = p.eCq();
        Object localObject2 = new com.tencent.mm.plugin.finder.loader.b(localbcz.xkY);
        ImageView localImageView = paramv.avatar;
        p localp = p.ExI;
        ((d)localObject1).a(localObject2, localImageView, p.a(p.a.ExO));
        paramv.DTO.setText((CharSequence)localbcz.nickname);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.Pq(localbcz.ZNI);
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label214;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label219;
        }
        paramv.DTP.setVisibility(8);
        label149:
        if (localbcz.ZNI != this.DTI) {
          break label242;
        }
        paramv.DTQ.setVisibility(0);
      }
      for (;;)
      {
        paramv.caK.setTag(localbcz);
        paramv.caK.setOnClickListener(new ai..ExternalSyntheticLambda1(this, paramv));
        paramv.caK.setOnLongClickListener(new ai..ExternalSyntheticLambda2(this));
        AppMethodBeat.o(358922);
        return;
        label214:
        paramInt = 0;
        break;
        label219:
        paramv.DTP.setVisibility(0);
        paramv.DTP.setText((CharSequence)localObject1);
        break label149;
        label242:
        paramv.DTQ.setVisibility(4);
      }
    }
    if ((paramv instanceof a))
    {
      paramv = (a)paramv;
      if (!this.DTJ) {
        break label342;
      }
      paramv.DTK.setIconColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_0_Alpha_0_9));
      paramv.DTL.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_0_Alpha_0_9));
      paramv.DTM.setVisibility(0);
    }
    for (;;)
    {
      paramv.caK.setOnClickListener(new ai..ExternalSyntheticLambda0(this, paramInt, paramv));
      AppMethodBeat.o(358922);
      return;
      label342:
      paramv.DTK.setIconColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_0_Alpha_0_5));
      paramv.DTL.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_0_Alpha_0_5));
      paramv.DTM.setVisibility(4);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358899);
    int i = this.vEn.size();
    AppMethodBeat.o(358899);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(358902);
    paramInt = ((bcz)this.vEn.get(paramInt)).ZNI;
    AppMethodBeat.o(358902);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$BottomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;Landroid/view/View;)V", "createArrowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCreateArrowIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCreateArrowIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "createIv", "getCreateIv", "setCreateIv", "createTv", "Landroid/widget/TextView;", "getCreateTv", "()Landroid/widget/TextView;", "setCreateTv", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    WeImageView DTK;
    TextView DTL;
    WeImageView DTM;
    
    public a()
    {
      super();
      AppMethodBeat.i(359042);
      this$1 = localObject.findViewById(p.e.CbX);
      s.s(ai.this, "itemView.findViewById(R.id.visitor_create_iv)");
      this.DTK = ((WeImageView)ai.this);
      this$1 = localObject.findViewById(p.e.CbY);
      s.s(ai.this, "itemView.findViewById(R.id.visitor_create_tv)");
      this.DTL = ((TextView)ai.this);
      this$1 = localObject.findViewById(p.e.CbW);
      s.s(ai.this, "itemView.findViewById(R.….visitor_create_arrow_iv)");
      this.DTM = ((WeImageView)ai.this);
      AppMethodBeat.o(359042);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$VisitorModeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "chooser", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getChooser", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setChooser", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mode", "Landroid/widget/TextView;", "getMode", "()Landroid/widget/TextView;", "setMode", "(Landroid/widget/TextView;)V", "nickname", "getNickname", "setNickname", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
  {
    TextView DTO;
    TextView DTP;
    WeImageView DTQ;
    ImageView avatar;
    
    public c()
    {
      super();
      AppMethodBeat.i(359024);
      this$1 = localObject.findViewById(p.e.CbU);
      s.s(ai.this, "itemView.findViewById(R.id.visitor_avatar_iv)");
      this.avatar = ((ImageView)ai.this);
      this$1 = localObject.findViewById(p.e.Cca);
      s.s(ai.this, "itemView.findViewById(R.id.visitor_nick_name_tv)");
      this.DTO = ((TextView)ai.this);
      this$1 = localObject.findViewById(p.e.CbZ);
      s.s(ai.this, "itemView.findViewById(R.id.visitor_mode_tips_tv)");
      this.DTP = ((TextView)ai.this);
      this$1 = localObject.findViewById(p.e.CbV);
      s.s(ai.this, "itemView.findViewById(R.id.visitor_choose_iv)");
      this.DTQ = ((WeImageView)ai.this);
      AppMethodBeat.o(359024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ai
 * JD-Core Version:    0.7.0.1
 */