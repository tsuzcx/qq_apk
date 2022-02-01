package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.cgi.r.a;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.model.u.a;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.a;
import com.tencent.mm.plugin.finder.report.live.s.aa;
import com.tencent.mm.plugin.finder.report.live.s.au;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "context", "Landroid/content/Context;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Landroid/content/Context;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "gotoFullScreenMiniProgram", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "Lkotlin/ParameterName;", "name", "bunde", "", "getGotoFullScreenMiniProgram", "()Lkotlin/jvm/functions/Function1;", "setGotoFullScreenMiniProgram", "(Lkotlin/jvm/functions/Function1;)V", "gotoHalfScreenMiniProgram", "getGotoHalfScreenMiniProgram", "setGotoHalfScreenMiniProgram", "onBuyClickCallback", "", "productId", "getOnBuyClickCallback", "setOnBuyClickCallback", "onItemLongClickCallback", "Lkotlin/Function3;", "holder", "Landroid/view/View;", "itemView", "", "pos", "getOnItemLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickCallback", "(Lkotlin/jvm/functions/Function3;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "promotingProductCallback", "", "promting", "getPromotingProductCallback", "setPromotingProductCallback", "updateProductCallback", "empty", "getUpdateProductCallback", "setUpdateProductCallback", "getItemCount", "getShoppingData", "modifyProduct", "scene", "onBindViewHolder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "promoteProduct", "reportStartTalk", "data", "reportStopTalk", "setOnClickListener", "setProductDesc", "productDescTv", "Landroid/widget/TextView;", "shopName", "", "goodsDesc", "setPromotingAnim", "promoting", "setUserActionText", "anchor", "sellOut", "showPopupMenu", "anchorPosX", "anchorPosY", "updatePromotingProduct", "promotingProduct", "updateShoppingList", "productList", "userProductAction", "Companion", "ShoppingViewHolder", "plugin-finder_release"})
public final class h
  extends RecyclerView.a<b>
{
  public static final a uBH;
  private final Context context;
  private final com.tencent.mm.live.c.b hOp;
  private final com.tencent.mm.plugin.finder.live.viewmodel.g liveData;
  public LinkedList<axg> ppH;
  public com.tencent.mm.ui.widget.b.a pqr;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> uBB;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.api.g, x> uBC;
  public kotlin.g.a.b<? super Boolean, x> uBD;
  public kotlin.g.a.b<? super Boolean, x> uBE;
  public kotlin.g.a.q<? super b, ? super View, ? super Integer, x> uBF;
  public kotlin.g.a.b<? super Long, x> uBG;
  
  static
  {
    AppMethodBeat.i(247849);
    uBH = new a((byte)0);
    AppMethodBeat.o(247849);
  }
  
  public h(Context paramContext, com.tencent.mm.live.c.b paramb, com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    AppMethodBeat.i(247848);
    this.context = paramContext;
    this.hOp = paramb;
    this.liveData = paramg;
    this.ppH = new LinkedList();
    this.pqr = new com.tencent.mm.ui.widget.b.a(this.context);
    AppMethodBeat.o(247848);
  }
  
  private static void a(TextView paramTextView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(247842);
    paramString2 = new com.tencent.mm.pluginsdk.ui.span.m(paramString1 + paramString2);
    Context localContext = paramTextView.getContext();
    p.g(localContext, "productDescTv.context");
    float f1 = localContext.getResources().getDimension(2131165277);
    float f2 = com.tencent.mm.view.d.e(paramTextView.getContext(), 2.0F);
    localContext = paramTextView.getContext();
    p.g(localContext, "productDescTv.context");
    int i = localContext.getResources().getColor(2131099838);
    localContext = paramTextView.getContext();
    p.g(localContext, "productDescTv.context");
    paramString2.a(new com.tencent.mm.plugin.finder.live.model.u(new u.a(f1, f1, f1, f1, f1, f2, i, localContext.getResources().getColor(2131099835), com.tencent.mm.view.d.e(paramTextView.getContext(), 12.0F))), (CharSequence)paramString1, 0);
    paramTextView.setText((CharSequence)paramString2);
    AppMethodBeat.o(247842);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(247840);
    p.h(paramb, "holder");
    Object localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
    localObject1 = com.tencent.mm.plugin.finder.loader.m.dkb();
    Object localObject2 = new com.tencent.mm.plugin.finder.loader.a(((axg)this.ppH.get(paramInt)).twt);
    Object localObject3 = paramb.uBJ;
    p.g(localObject3, "holder.productImg");
    Object localObject4 = com.tencent.mm.plugin.finder.loader.m.uJa;
    ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJg));
    localObject1 = paramb.uBK;
    p.g(localObject1, "holder.productSeq");
    ((TextView)localObject1).setText((CharSequence)String.valueOf(paramInt + 1));
    localObject4 = paramb.uBM;
    p.g(localObject4, "holder.productDesc");
    localObject1 = ((axg)this.ppH.get(paramInt)).LHM;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject3 = ((axg)this.ppH.get(paramInt)).title;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      a((TextView)localObject4, (String)localObject1, (String)localObject2);
      if ((((axg)this.ppH.get(paramInt)).AZr >= 0) && (((axg)this.ppH.get(paramInt)).AZq >= ((axg)this.ppH.get(paramInt)).AZr))
      {
        localObject1 = paramb.uBN;
        p.g(localObject1, "holder.productPrice");
        localObject2 = y.vXH;
        ((TextView)localObject1).setText((CharSequence)y.LS(((axg)this.ppH.get(paramInt)).AZr));
        localObject1 = paramb.uBO;
        p.g(localObject1, "holder.userAction");
        ((TextView)localObject1).setVisibility(0);
        if (this.liveData.liveInfo.liveId != 0L) {
          break label415;
        }
        localObject1 = paramb.uBO;
        p.g(localObject1, "holder.userAction");
        ((TextView)localObject1).setVisibility(8);
        label316:
        if (((axg)this.ppH.get(paramInt)).LHK != 1) {
          break label534;
        }
        a(true, paramb);
      }
      for (;;)
      {
        b(paramb, paramInt);
        AppMethodBeat.o(247840);
        return;
        Log.i("Finder.LiveShoppingListAdapter", "invalid price,min:" + ((axg)this.ppH.get(paramInt)).AZr + ",max:" + ((axg)this.ppH.get(paramInt)).AZq);
        break;
        label415:
        if (((axg)this.ppH.get(paramInt)).LHJ <= 0)
        {
          localObject1 = y.vXH;
          localObject1 = this.ppH.get(paramInt);
          p.g(localObject1, "dataList[position]");
          if (!y.c((axg)localObject1)) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
          if (com.tencent.mm.plugin.finder.utils.m.dBP())
          {
            if (((axg)this.ppH.get(paramInt)).LHK == 1)
            {
              a(true, true, false, paramb, paramInt);
              break label316;
            }
            a(true, false, false, paramb, paramInt);
            break label316;
          }
          a(false, false, false, paramb, paramInt);
          break label316;
        }
        a(false, false, true, paramb, paramInt);
        break label316;
        label534:
        a(false, paramb);
      }
    }
  }
  
  private final void a(final b paramb, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(247846);
    final z.f localf = new z.f();
    localf.SYG = Jp(paramInt1);
    axg localaxg = (axg)localf.SYG;
    if (localaxg != null)
    {
      Log.i("Finder.LiveShoppingListAdapter", "promoteProduct id:" + localaxg.uko + " scene:" + paramInt2);
      long l1 = this.liveData.liveInfo.liveId;
      long l2 = this.liveData.hFK;
      String str = z.aUg();
      p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
      new com.tencent.mm.plugin.finder.live.model.cgi.t(l1, l2, str, localaxg.uko, paramInt2, (t.a)new d(localaxg, this, paramInt2, paramb, paramInt1, localf)).aYI();
      AppMethodBeat.o(247846);
      return;
    }
    AppMethodBeat.o(247846);
  }
  
  private final void a(boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(247844);
    FinderLiveOnliveWidget localFinderLiveOnliveWidget;
    if (paramBoolean)
    {
      localFinderLiveOnliveWidget = paramb.uBL;
      p.g(localFinderLiveOnliveWidget, "holder.promoting");
      localFinderLiveOnliveWidget.setVisibility(0);
      paramb.uBL.dGW();
      if (this.hOp.getLiveRole() == 1)
      {
        paramb = k.vkd;
        k.dpl().vmn = true;
        AppMethodBeat.o(247844);
      }
    }
    else
    {
      localFinderLiveOnliveWidget = paramb.uBL;
      p.g(localFinderLiveOnliveWidget, "holder.promoting");
      localFinderLiveOnliveWidget.setVisibility(8);
      paramb.uBL.cEA();
    }
    AppMethodBeat.o(247844);
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b paramb, int paramInt)
  {
    AppMethodBeat.i(247843);
    Log.i("Finder.LiveShoppingListAdapter", "setAnchorPromoteText,anchor:" + paramBoolean1 + ",promoting:" + paramBoolean2 + ",pos:" + paramInt);
    TextView localTextView;
    Object localObject;
    if (paramBoolean3 == true)
    {
      localTextView = paramb.uBO;
      p.g(localTextView, "holder.userAction");
      localObject = paramb.uBO;
      p.g(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.g(localObject, "holder.userAction.context");
      localTextView.setText((CharSequence)((Context)localObject).getResources().getString(2131760185));
      localTextView = paramb.uBO;
      localObject = paramb.uBO;
      p.g(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.g(localObject, "holder.userAction.context");
      localTextView.setTextColor(((Context)localObject).getResources().getColor(2131099832));
      paramb.uBO.setBackgroundResource(2131232641);
      paramb = paramb.uBO;
      p.g(paramb, "holder.userAction");
      paramb.setEnabled(false);
      AppMethodBeat.o(247843);
      return;
    }
    if (!paramBoolean3)
    {
      if (paramBoolean1 != true) {
        break label488;
      }
      if (!paramBoolean2) {
        break label362;
      }
      localTextView = paramb.uBO;
      p.g(localTextView, "holder.userAction");
      localObject = paramb.uBO;
      p.g(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.g(localObject, "holder.userAction.context");
      localTextView.setText((CharSequence)((Context)localObject).getResources().getString(2131760188));
      localTextView = paramb.uBO;
      localObject = paramb.uBO;
      p.g(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.g(localObject, "holder.userAction.context");
      localTextView.setTextColor(((Context)localObject).getResources().getColor(2131100431));
      paramb.uBO.setBackgroundResource(2131232641);
    }
    for (;;)
    {
      paramb = paramb.uBO;
      p.g(paramb, "holder.userAction");
      paramb.setEnabled(true);
      AppMethodBeat.o(247843);
      return;
      label362:
      localTextView = paramb.uBO;
      p.g(localTextView, "holder.userAction");
      localObject = paramb.uBO;
      p.g(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.g(localObject, "holder.userAction.context");
      localTextView.setText((CharSequence)((Context)localObject).getResources().getString(2131760187));
      localTextView = paramb.uBO;
      localObject = paramb.uBO;
      p.g(localObject, "holder.userAction");
      localObject = ((TextView)localObject).getContext();
      p.g(localObject, "holder.userAction.context");
      localTextView.setTextColor(((Context)localObject).getResources().getColor(2131099844));
      paramb.uBO.setBackgroundResource(2131232578);
      continue;
      label488:
      if (!paramBoolean1)
      {
        localTextView = paramb.uBO;
        p.g(localTextView, "holder.userAction");
        localObject = paramb.uBO;
        p.g(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.g(localObject, "holder.userAction.context");
        localTextView.setText((CharSequence)((Context)localObject).getResources().getString(2131760179));
        localTextView = paramb.uBO;
        localObject = paramb.uBO;
        p.g(localObject, "holder.userAction");
        localObject = ((TextView)localObject).getContext();
        p.g(localObject, "holder.userAction.context");
        localTextView.setTextColor(((Context)localObject).getResources().getColor(2131099844));
        paramb.uBO.setBackgroundResource(2131232578);
      }
    }
  }
  
  private final void b(final b paramb, final int paramInt)
  {
    AppMethodBeat.i(247845);
    paramb.aus.setOnClickListener((View.OnClickListener)new e(this, paramInt));
    paramb.uBO.setOnClickListener((View.OnClickListener)new f(this, paramb, paramInt));
    Object localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
      paramb.aus.setOnLongClickListener((View.OnLongClickListener)new g(this, paramb, paramInt));
    }
    if (this.hOp.getLiveRole() == 0)
    {
      paramb = com.tencent.mm.plugin.finder.report.live.m.vli;
      localObject = s.au.vrW;
      paramb = Jp(paramInt);
      if (paramb == null) {
        break label129;
      }
    }
    label129:
    for (paramb = Long.valueOf(paramb.uko);; paramb = null)
    {
      com.tencent.mm.plugin.finder.report.live.m.a((s.au)localObject, null, String.valueOf(paramb));
      AppMethodBeat.o(247845);
      return;
    }
  }
  
  public final axg Jp(int paramInt)
  {
    AppMethodBeat.i(247847);
    int i = this.ppH.size();
    if (paramInt < 0) {}
    while (i <= paramInt)
    {
      AppMethodBeat.o(247847);
      return null;
    }
    axg localaxg = (axg)this.ppH.get(paramInt);
    AppMethodBeat.o(247847);
    return localaxg;
  }
  
  public final void ao(LinkedList<axg> paramLinkedList)
  {
    AppMethodBeat.i(247836);
    Object localObject2 = new StringBuilder("updateShoppingList,ori size:").append(this.ppH.size()).append(",new size:");
    Object localObject1;
    if (paramLinkedList != null)
    {
      localObject1 = Integer.valueOf(paramLinkedList.size());
      Log.i("Finder.LiveShoppingListAdapter", localObject1);
      if (paramLinkedList == null) {
        break label220;
      }
      this.ppH.clear();
      if (this.hOp.getLiveRole() != 1) {
        break label208;
      }
    }
    label208:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = k.vkd;
        k.dpl().vmp.clear();
      }
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (axg)((Iterator)localObject1).next();
        this.ppH.add(localObject2);
        if (i != 0)
        {
          k localk = k.vkd;
          k.dpl().vmp.add(Long.valueOf(((axg)localObject2).uko));
        }
        paramLinkedList.add(x.SXb);
      }
      localObject1 = null;
      break;
    }
    AppMethodBeat.o(247836);
    return;
    label220:
    AppMethodBeat.o(247836);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(247838);
    int i = this.ppH.size();
    AppMethodBeat.o(247838);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$Companion;", "", "()V", "MENU_ID_ITEM_DELETE", "", "MENU_ID_ITEM_MOVE_TO_FIRST", "TAG", "", "payloadDelete", "payloadMove", "payloadPromteFinish", "payloadPromting", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;Landroid/view/View;)V", "itemDetail", "kotlin.jvm.PlatformType", "getItemDetail", "()Landroid/view/View;", "setItemDetail", "(Landroid/view/View;)V", "productDesc", "Landroid/widget/TextView;", "getProductDesc", "()Landroid/widget/TextView;", "setProductDesc", "(Landroid/widget/TextView;)V", "productImg", "Landroid/widget/ImageView;", "getProductImg", "()Landroid/widget/ImageView;", "setProductImg", "(Landroid/widget/ImageView;)V", "productPrice", "getProductPrice", "setProductPrice", "productSeq", "getProductSeq", "setProductSeq", "promoting", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getPromoting", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setPromoting", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "userAction", "getUserAction", "setUserAction", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    private View uBI;
    ImageView uBJ;
    TextView uBK;
    FinderLiveOnliveWidget uBL;
    public TextView uBM;
    TextView uBN;
    TextView uBO;
    
    public b()
    {
      super();
      AppMethodBeat.i(247824);
      this.uBI = localObject.findViewById(2131302807);
      this.uBJ = ((ImageView)localObject.findViewById(2131306169));
      this.uBK = ((TextView)localObject.findViewById(2131306172));
      this.uBL = ((FinderLiveOnliveWidget)localObject.findViewById(2131306303));
      this.uBM = ((TextView)localObject.findViewById(2131306155));
      this.uBN = ((TextView)localObject.findViewById(2131306171));
      this.uBO = ((TextView)localObject.findViewById(2131306149));
      this$1 = y.vXH;
      this$1 = this.uBN;
      p.g(h.this, "productPrice");
      y.q(h.this);
      this.uBO.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(247823);
          Object localObject1 = new Rect();
          this.uBQ.uBO.getHitRect((Rect)localObject1);
          Object localObject2 = MMApplicationContext.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165314);
          ((Rect)localObject1).inset(-i, -i);
          localObject2 = this.uBQ.uBO;
          p.g(localObject2, "userAction");
          localObject2 = ((TextView)localObject2).getParent();
          if (localObject2 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(247823);
            throw ((Throwable)localObject1);
          }
          ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.uBQ.uBO));
          AppMethodBeat.o(247823);
        }
      });
      AppMethodBeat.o(247824);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$modifyProduct$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductResponse;", "plugin-finder_release"})
  public static final class c
    implements r.a
  {
    c(axg paramaxg, h paramh, int paramInt1, int paramInt2) {}
    
    public final void a(final int paramInt1, final int paramInt2, final awp paramawp)
    {
      AppMethodBeat.i(247826);
      p.h(paramawp, "resp");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new kotlin.g.b.q(paramawp) {});
      AppMethodBeat.o(247826);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$promoteProduct$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder_release"})
  public static final class d
    implements t.a
  {
    d(axg paramaxg, h paramh, int paramInt1, h.b paramb, int paramInt2, z.f paramf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final aww paramaww)
    {
      AppMethodBeat.i(247828);
      p.h(paramaww, "resp");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new kotlin.g.b.q(paramaww) {});
      AppMethodBeat.o(247828);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(h paramh, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(247830);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
      localObject2 = new z.f();
      ((z.f)localObject2).SYG = h.a(this.uBP, paramInt);
      axg localaxg = (axg)((z.f)localObject2).SYG;
      StringBuilder localStringBuilder;
      if (localaxg != null)
      {
        localStringBuilder = new StringBuilder("on product item click appId:");
        paramView = localaxg.LHI;
        if (paramView == null) {
          break label192;
        }
      }
      label192:
      for (paramView = paramView.appId;; paramView = null)
      {
        localStringBuilder = localStringBuilder.append(paramView).append(",path:");
        det localdet = localaxg.LHI;
        paramView = localObject1;
        if (localdet != null) {
          paramView = localdet.path;
        }
        Log.i("Finder.LiveShoppingListAdapter", paramView);
        paramView = com.tencent.mm.plugin.finder.live.g.ufT;
        com.tencent.mm.plugin.finder.live.g.a(h.a(this.uBP), localaxg, (kotlin.g.a.m)new a(this, (z.f)localObject2));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247830);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$1$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x>
    {
      a(h.e parame, z.f paramf)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(h paramh, h.b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247831);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      h.a(this.uBP, paramb, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247831);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    g(h paramh, h.b paramb, int paramInt) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(247832);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.uBP.uBF;
      if (localObject != null)
      {
        h.b localb = paramb;
        p.g(paramView, "it");
        ((kotlin.g.a.q)localObject).d(localb, paramView, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$setOnClickListener$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(247832);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  public static final class h
    implements View.OnCreateContextMenuListener
  {
    public h(h paramh) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(247833);
      paramContextMenu.add(0, 100, 0, (CharSequence)h.c(this.uBP).getResources().getString(2131760189));
      paramContextMenu.add(0, 101, 1, (CharSequence)h.c(this.uBP).getResources().getString(2131760181));
      AppMethodBeat.o(247833);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class i
    implements o.g
  {
    public i(h paramh, h.b paramb, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(247834);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      JSONObject localJSONObject;
      label164:
      long l;
      label324:
      label340:
      label741:
      do
      {
        Object localObject;
        do
        {
          do
          {
            AppMethodBeat.o(247834);
            return;
            h.d(this.uBP).gNq();
            h.a(this.uBP, this.prP, 1);
          } while (h.b(this.uBP).getLiveRole() != 1);
          localJSONObject = new JSONObject();
          localJSONObject.put("type", s.aa.vpN.action);
          paramMenuItem = k.vkd;
          localJSONObject.put("sessionid", k.dpl().vlJ);
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.uEl;
            if (paramMenuItem != null)
            {
              localObject = paramMenuItem.vtD;
              paramMenuItem = (MenuItem)localObject;
              if (localObject != null) {
                break label164;
              }
            }
          }
          paramMenuItem = "";
          localJSONObject.put("shopwindowid", paramMenuItem);
          paramMenuItem = h.a(this.uBP, this.prP);
          if (paramMenuItem != null) {}
          for (l = paramMenuItem.uko;; l = 0L)
          {
            localJSONObject.put("productid", l);
            paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
            paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if ((paramMenuItem == null) || (paramMenuItem.djk() != true)) {
              break;
            }
            paramMenuItem = k.vkd;
            k.q(s.a.vmz.hlf, localJSONObject.toString());
            AppMethodBeat.o(247834);
            return;
          }
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
          if (paramMenuItem != null) {
            if (paramMenuItem.isLiveStarted() == true)
            {
              paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
              paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
              if (paramMenuItem == null) {
                break label429;
              }
              paramMenuItem = paramMenuItem.uEq;
              localJSONObject.put("appid", paramMenuItem);
              paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
              paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
              if (paramMenuItem == null) {
                break label434;
              }
              paramMenuItem = paramMenuItem.liveInfo;
              if (paramMenuItem == null) {
                break label434;
              }
              l = paramMenuItem.liveId;
              if (l >= 0L) {
                break label441;
              }
              localJSONObject.put("liveid", "");
              paramMenuItem = c.sFa;
              localJSONObject.put("clickid", c.cOM());
              paramMenuItem = c.sFa;
              c.a.apD("");
              paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
              paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
              if (paramMenuItem == null) {
                break label456;
              }
              paramMenuItem = paramMenuItem.uEm;
              if (paramMenuItem == null) {
                break label456;
              }
            }
          }
          for (paramMenuItem = Long.valueOf(paramMenuItem.uko);; paramMenuItem = "")
          {
            localJSONObject.put("productid", paramMenuItem);
            paramMenuItem = k.vkd;
            k.a(s.c.vmV, localJSONObject.toString());
            AppMethodBeat.o(247834);
            return;
            AppMethodBeat.o(247834);
            return;
            paramMenuItem = null;
            break;
            l = -1L;
            break label324;
            localJSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(l));
            break label340;
          }
          h.d(this.uBP).gNq();
          h.a(this.uBP, this.prP, 2);
        } while (h.b(this.uBP).getLiveRole() != 1);
        paramMenuItem = h.a(this.uBP, this.prP);
        if ((paramMenuItem != null) && (paramMenuItem.LHK == 1))
        {
          localObject = k.vkd;
          localObject = k.dpl();
          l = paramMenuItem.uko;
          paramMenuItem = ((s)localObject).vmj.vtA;
          if (!paramMenuItem.isEmpty())
          {
            paramMenuItem = (LinkedList)paramMenuItem.get(Long.valueOf(l));
            if ((paramMenuItem != null) && (!paramMenuItem.isEmpty())) {
              break label741;
            }
          }
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("type", s.aa.vpM.action);
        paramMenuItem = k.vkd;
        localJSONObject.put("sessionid", k.dpl().vlJ);
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.uEl;
          if (paramMenuItem != null)
          {
            localObject = paramMenuItem.vtD;
            paramMenuItem = (MenuItem)localObject;
            if (localObject != null) {
              break label658;
            }
          }
        }
        paramMenuItem = "";
        localJSONObject.put("shopwindowid", paramMenuItem);
        paramMenuItem = h.a(this.uBP, this.prP);
        if (paramMenuItem != null) {}
        for (l = paramMenuItem.uko;; l = 0L)
        {
          localJSONObject.put("productid", l);
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
          paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
          if ((paramMenuItem == null) || (paramMenuItem.djk() != true)) {
            break label814;
          }
          paramMenuItem = k.vkd;
          k.q(s.a.vmz.hlf, localJSONObject.toString());
          AppMethodBeat.o(247834);
          return;
          if (((com.tencent.mm.plugin.finder.report.live.o)paramMenuItem.getLast()).vlm) {
            break;
          }
          l = System.currentTimeMillis() - ((com.tencent.mm.plugin.finder.report.live.o)paramMenuItem.getLast()).time;
          localObject = (com.tencent.mm.plugin.finder.report.live.o)paramMenuItem.getLast();
          if (l > 0L) {}
          for (;;)
          {
            ((com.tencent.mm.plugin.finder.report.live.o)localObject).time = l;
            ((com.tencent.mm.plugin.finder.report.live.o)paramMenuItem.getLast()).vlm = true;
            break;
            l = 0L;
          }
        }
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (paramMenuItem == null) {
          break;
        }
      } while (paramMenuItem.isLiveStarted() != true);
      label429:
      label434:
      label441:
      label456:
      paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
      label658:
      label814:
      paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.uEq;
        label851:
        localJSONObject.put("appid", paramMenuItem);
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (paramMenuItem == null) {
          break label993;
        }
        paramMenuItem = paramMenuItem.liveInfo;
        if (paramMenuItem == null) {
          break label993;
        }
        l = paramMenuItem.liveId;
        label886:
        if (l >= 0L) {
          break label1000;
        }
        localJSONObject.put("liveid", "");
        label902:
        paramMenuItem = c.sFa;
        localJSONObject.put("clickid", c.cOM());
        paramMenuItem = c.sFa;
        c.a.apD("");
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.ujN;
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.o.dfZ();
        if (paramMenuItem == null) {
          break label1015;
        }
        paramMenuItem = paramMenuItem.uEm;
        if (paramMenuItem == null) {
          break label1015;
        }
      }
      label993:
      label1000:
      label1015:
      for (paramMenuItem = Long.valueOf(paramMenuItem.uko);; paramMenuItem = "")
      {
        localJSONObject.put("productid", paramMenuItem);
        paramMenuItem = k.vkd;
        k.a(s.c.vmV, localJSONObject.toString());
        break;
        AppMethodBeat.o(247834);
        return;
        paramMenuItem = null;
        break label851;
        l = -1L;
        break label886;
        localJSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(l));
        break label902;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$userProductAction$1$1$1", "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$$special$$inlined$let$lambda$1"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x>
  {
    j(z.f paramf, h paramh, int paramInt, h.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.h
 * JD-Core Version:    0.7.0.1
 */