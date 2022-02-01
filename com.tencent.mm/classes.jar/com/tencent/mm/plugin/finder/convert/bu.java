package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jm;
import com.tencent.mm.autogen.a.jm.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "finderStreamCards", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFinderStreamCards", "()Ljava/util/List;", "doReport", "", "index", "jumpType", "wording", "", "feedIds", "getFeedIds", "finderObjects", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLayoutId", "initInnerRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "objectActions", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "isFinderClose", "", "extStatus", "", "jumpFinderTimelineUI", "context", "Landroid/content/Context;", "onBindViewHolder", "item", "type", "isHotPatch", "payloads", "", "onCreateViewHolder", "openFinderEntrance", "toIntSafely", "Companion", "RvAdapter", "RvItemDecoration", "ViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bu
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.model.b>
{
  public static final a ALq;
  private final List<bwa> ALr;
  final bui Auc;
  private final int hJx;
  
  static
  {
    AppMethodBeat.i(350379);
    ALq = new a((byte)0);
    AppMethodBeat.o(350379);
  }
  
  public bu(bui parambui, int paramInt, List<? extends bwa> paramList)
  {
    this.Auc = parambui;
    this.hJx = paramInt;
    this.ALr = paramList;
  }
  
  private static final void a(bu parambu, ah.d paramd, RecyclerView paramRecyclerView, LinearLayout paramLinearLayout, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(350353);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambu);
    localb.cH(paramd);
    localb.cH(paramRecyclerView);
    localb.cH(paramLinearLayout);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambu, "this$0");
    kotlin.g.b.s.u(paramd, "$jumpType");
    kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
    kotlin.g.b.s.u(paramf, "$wording");
    paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
    int j = ((Number)com.tencent.mm.plugin.finder.storage.d.eUU().bmg()).intValue();
    int i;
    switch (j)
    {
    default: 
      i = 1;
    }
    for (;;)
    {
      paramView = cn.AMo;
      cn.setTabType(i);
      paramView = cn.AMo;
      cn.dYa();
      i = paramd.aixb;
      paramd = paramRecyclerView.getContext();
      kotlin.g.b.s.s(paramd, "recyclerView.context");
      parambu.a(j, i, paramd, paramLinearLayout.getTag(), (String)paramf.aqH, "");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350353);
      return;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  private static int fg(Object paramObject)
  {
    AppMethodBeat.i(350341);
    if ((paramObject == null) || (!(paramObject instanceof Integer)))
    {
      AppMethodBeat.o(350341);
      return -1;
    }
    int i = ((Number)paramObject).intValue();
    AppMethodBeat.o(350341);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, Context paramContext, Object paramObject, String paramString1, String paramString2)
  {
    AppMethodBeat.i(350423);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "wording");
    kotlin.g.b.s.u(paramString2, "feedIds");
    Object localObject = this.Auc;
    int i;
    if (localObject == null)
    {
      localObject = null;
      com.tencent.mm.plugin.expt.hellhound.core.b.aqZ((String)localObject);
      long l = z.bAR();
      if ((0x0 & l) == 0L) {
        break label463;
      }
      i = 1;
      label67:
      if (i != 0)
      {
        l = 0xFFFFFFFF & l;
        com.tencent.mm.kernel.h.baE().ban().B(147457, Long.valueOf(l));
        Log.i("Finder.FinderOpenEntranceTipConvert", kotlin.g.b.s.X("openFinderEntrance extstatus:", Long.valueOf(l)));
        localObject = new cas();
        ((cas)localObject).aajJ = 57;
        ((cas)localObject).NkL = 1;
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz().d((k.b)new k.a(23, (com.tencent.mm.bx.a)localObject));
        Log.d("Finder.FinderOpenEntranceTipConvert", "openFinderEntrance switch functionId:" + ((cas)localObject).aajJ + " to " + ((cas)localObject).NkL);
      }
      int j = fg(paramObject);
      switch (paramInt1)
      {
      case 1: 
      default: 
        paramObject = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
        i = 18;
        label257:
        if (j > 0)
        {
          localObject = ac.Fsk;
          ac.eNa();
          ac.a(this.Auc, 2, com.tencent.mm.model.cn.bDv(), j, paramInt2, paramString1, null, paramString2, 64);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(15185, new Object[] { Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(2) });
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).finish();
        }
        paramString1 = new Intent();
        paramString1.putExtra(paramObject, true);
        paramString1.putExtra("KEY_FROM_SHARE_REL", true);
        paramString1.putExtra("key_auto_trigger_type", 3);
        paramObject = this.Auc;
        if (paramObject == null) {
          paramInt1 = -1;
        }
        break;
      }
    }
    for (;;)
    {
      if ((paramInt1 > 0) && (i > 0)) {
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(paramInt1, 9, i, paramString1);
      }
      paramObject = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.eMN();
      paramObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.a(paramContext, paramString1, 1, false, 8);
      AppMethodBeat.o(350423);
      return;
      localObject = ((bui)localObject).zIO;
      break;
      label463:
      i = 0;
      break label67;
      paramObject = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
      i = 20;
      break label257;
      paramObject = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
      i = 17;
      break label257;
      paramObject = paramObject.zIO;
      if (paramObject == null)
      {
        paramInt1 = -1;
      }
      else
      {
        paramObject = kotlin.n.n.a((CharSequence)paramObject, new char[] { '-' }, 0, 6);
        if (paramObject == null)
        {
          paramInt1 = -1;
        }
        else
        {
          paramObject = (String)paramObject.get(0);
          if (paramObject == null) {
            paramInt1 = -1;
          } else {
            paramInt1 = Integer.parseInt(paramObject);
          }
        }
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350407);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    final ah.f localf1 = new ah.f();
    Object localObject2 = null;
    final ah.f localf2 = new ah.f();
    localf2.aqH = "";
    final ah.d locald = new ah.d();
    locald.aixb = 1;
    Object localObject1 = (Collection)this.ALr;
    Object localObject3;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label689;
      }
      localObject3 = (bwa)this.ALr.get(0);
      localObject2 = ((bwa)localObject3).Wqu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localf2.aqH = localObject1;
      localf1.aqH = ((bwa)localObject3).object;
      localObject1 = (List)((bwa)localObject3).aadO;
      localObject2 = ((bwa)localObject3).AEA;
      localObject3 = (List)localf1.aqH;
      if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
        break label674;
      }
      paramInt = 1;
      label189:
      if (paramInt != 0) {
        locald.aixb = 3;
      }
    }
    for (;;)
    {
      localObject3 = (CharSequence)localf2.aqH;
      label226:
      Object localObject4;
      Object localObject5;
      String str;
      Object localObject6;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        paramInt = 1;
        if (paramInt != 0)
        {
          localObject3 = paramRecyclerView.getContext().getString(e.h.finder_feed_active_and_jump_finder);
          kotlin.g.b.s.s(localObject3, "recyclerView.context.get…d_active_and_jump_finder)");
          localf2.aqH = localObject3;
        }
        localObject3 = (LinearLayout)paramj.caK.findViewById(e.e.open_entrance_ll);
        localObject4 = (TextView)paramj.caK.findViewById(e.e.open_entrance_tv);
        aw.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
        ((TextView)localObject4).setText((CharSequence)localf2.aqH);
        localObject5 = ((LinearLayout)localObject3).getTag();
        str = (String)localf2.aqH;
        localObject4 = (List)localf1.aqH;
        localObject6 = (Collection)localObject4;
        if ((localObject6 != null) && (!((Collection)localObject6).isEmpty())) {
          break label684;
        }
      }
      label674:
      label684:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          ((WeImageView)paramj.caK.findViewById(e.e.open_entrance_iv)).setVisibility(0);
        }
        if ((localObject4 != null) && (localObject1 != null))
        {
          localObject6 = (RecyclerView)paramj.caK.findViewById(e.e.open_entrance_rv);
          ((RecyclerView)localObject6).setVisibility(0);
          paramRecyclerView.getContext();
          ((RecyclerView)localObject6).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
          paramInt = paramRecyclerView.getContext().getResources().getDimensionPixelSize(e.c.Edge_2A);
          int i = paramRecyclerView.getContext().getResources().getDimensionPixelSize(e.c.Edge_0_5_A);
          Context localContext = paramRecyclerView.getContext();
          kotlin.g.b.s.s(localContext, "recyclerView.context");
          localObject2 = new b(localContext, paramInt, i, localObject5, str, (com.tencent.mm.bx.b)localObject2);
          ((RecyclerView)localObject6).setAdapter((RecyclerView.a)localObject2);
          ((RecyclerView)localObject6).a((RecyclerView.h)new c(paramInt, i));
          kotlin.g.b.s.u(localObject4, "objects");
          kotlin.g.b.s.u(localObject1, "actions");
          ((b)localObject2).ALu.clear();
          ((b)localObject2).ALu.addAll((Collection)localObject4);
          ((b)localObject2).ALv.clear();
          ((b)localObject2).ALv.addAll((Collection)localObject1);
          ((RecyclerView.a)localObject2).bZE.notifyChanged();
        }
        paramj = paramj.caK;
        kotlin.g.b.s.s(paramj, "holder.itemView");
        com.tencent.mm.view.f.a(paramj, (e.b)new e(this, (LinearLayout)localObject3, localf1, locald, localf2));
        ((LinearLayout)localObject3).setOnClickListener(new bu..ExternalSyntheticLambda0(this, locald, paramRecyclerView, (LinearLayout)localObject3, localf2));
        AppMethodBeat.o(350407);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label189;
        paramInt = 0;
        break label226;
      }
      label689:
      localObject1 = null;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_open_entrance_tip_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$Companion;", "", "()V", "FINDER_ENTRANCE_ID", "", "STATUS_CLOSE", "STATUS_OPEN", "TAB_FOLLOW", "TAB_FRIEND", "TAB_HOT", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$RvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$ViewHolder;", "Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;", "context", "Landroid/content/Context;", "margin", "", "space", "position", "", "wording", "", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;Landroid/content/Context;IILjava/lang/Object;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getContext", "()Landroid/content/Context;", "descHeight", "finerObjects", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "imageHeight", "itemHeight", "itemWidth", "getMargin", "()I", "objectActions", "getPosition", "()Ljava/lang/Object;", "getSpace", "getWording", "()Ljava/lang/String;", "getItemCount", "isNewsObject", "", "item", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "objects", "", "actions", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<bu.d>
  {
    private final com.tencent.mm.bx.b AEA;
    private final int ALs;
    private final Object ALt;
    List<FinderObject> ALu;
    List<Integer> ALv;
    private int ALw;
    private final Context context;
    private int dpX;
    private int imageHeight;
    private final int space;
    private int wLI;
    private final String wording;
    
    public b(int paramInt1, int paramInt2, Object paramObject, String paramString, com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(349595);
      this.context = paramInt1;
      this.ALs = paramInt2;
      this.space = paramObject;
      this.ALt = paramString;
      this.wording = paramb;
      Object localObject;
      this.AEA = localObject;
      this.ALu = ((List)new ArrayList());
      this.ALv = ((List)new ArrayList());
      this.wLI = ((ao.mX(this.context).width - this.space * 2 - this.ALs * 2) / 3);
      this.dpX = (this.wLI * 4 / 3);
      this.ALw = ((int)(this.dpX / 5.6F));
      this.imageHeight = (this.dpX - this.ALw);
      AppMethodBeat.o(349595);
    }
    
    private static final void a(int paramInt1, b paramb, int paramInt2, bu parambu, FinderObject paramFinderObject, View paramView)
    {
      AppMethodBeat.i(349603);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sc(paramInt1);
      localb.cH(paramb);
      localb.sc(paramInt2);
      localb.cH(parambu);
      localb.cH(paramFinderObject);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "this$0");
      kotlin.g.b.s.u(parambu, "this$1");
      kotlin.g.b.s.u(paramFinderObject, "$finderObject");
      int i;
      int j;
      switch (paramInt1)
      {
      case 1: 
      case 2: 
      case 3: 
      default: 
        i = 1;
        j = 1;
      }
      for (;;)
      {
        paramView = cn.AMo;
        cn.a(paramb.ALu, paramb.ALv, paramb.AEA, i, paramInt1, paramInt2);
        parambu.a(j, 3, paramb.context, Integer.valueOf(paramInt2), paramb.wording, com.tencent.mm.ae.d.hF(paramFinderObject.id));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$RvAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(349603);
        return;
        i = 4;
        j = 2;
        continue;
        i = 1;
        j = 1;
        continue;
        i = 3;
        j = 0;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(349616);
      int i = this.ALu.size();
      AppMethodBeat.o(349616);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$RvItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "margin", "", "space", "(Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;II)V", "getMargin", "()I", "getSpace", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.h
  {
    private final int ALs;
    private final int space;
    
    public c(int paramInt)
    {
      AppMethodBeat.i(349587);
      this.ALs = paramInt;
      int i;
      this.space = i;
      AppMethodBeat.o(349587);
    }
    
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(349591);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      super.a(paramRect, paramInt, paramRecyclerView);
      paramInt %= 3;
      if (paramInt == 0)
      {
        paramRect.left = this.ALs;
        AppMethodBeat.o(349591);
        return;
      }
      paramRect.left = this.space;
      if (paramInt == 2) {
        paramRect.right = this.ALs;
      }
      AppMethodBeat.o(349591);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;Landroid/view/View;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "flagTv", "getFlagTv", "setFlagTv", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.v
  {
    TextView ALy;
    ImageView coverIv;
    TextView descTv;
    
    public d()
    {
      super();
      AppMethodBeat.i(349589);
      ((RoundCornerRelativeLayout)localObject).setRadius(((RoundCornerRelativeLayout)localObject).getContext().getResources().getDimension(e.c.Edge_A));
      this.coverIv = ((ImageView)localObject.findViewById(e.e.open_entrance_item_iv));
      this.descTv = ((TextView)localObject.findViewById(e.e.open_entrance_item_desc_tv));
      this.ALy = ((TextView)localObject.findViewById(e.e.open_entrance_item_flag_tv));
      AppMethodBeat.o(349589);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends e.b
  {
    e(bu parambu, LinearLayout paramLinearLayout, ah.f<List<FinderObject>> paramf, ah.d paramd, ah.f<String> paramf1) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(349598);
      kotlin.g.b.s.u(paramView, "view");
      int i = bu.fh(this.ALz.getTag());
      if (paramBoolean)
      {
        paramView = bu.fZ((List)localf1.aqH);
        localObject = ac.Fsk;
        ac.eNa();
        ac.a(this.ALx.Auc, 1, com.tencent.mm.model.cn.bDv(), i, locald.aixb, (String)localf2.aqH, null, paramView, 64);
      }
      paramView = new jm();
      paramView.hLc.position = (i - 1);
      Object localObject = paramView.hLc;
      if (paramBoolean) {}
      for (i = 1;; i = 0)
      {
        ((jm.a)localObject).type = i;
        paramView.publish();
        AppMethodBeat.o(349598);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bu
 * JD-Core Version:    0.7.0.1
 */