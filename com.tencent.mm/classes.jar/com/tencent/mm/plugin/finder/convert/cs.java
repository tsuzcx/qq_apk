package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.d.d;
import com.tencent.mm.plugin.finder.viewmodel.f.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "getTabType", "()I", "bindData", "", "cardView", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getLayoutId", "jump2HotTab", "context", "Lcom/tencent/mm/ui/MMActivity;", "item", "action", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cs
  extends com.tencent.mm.view.recyclerview.f<au>
{
  public static final a AMT;
  private final kotlin.j AMU;
  private final bui Auc;
  private final int hJx;
  
  static
  {
    AppMethodBeat.i(350040);
    AMT = new a((byte)0);
    AppMethodBeat.o(350040);
  }
  
  public cs(bui parambui, int paramInt)
  {
    AppMethodBeat.i(349915);
    this.Auc = parambui;
    this.hJx = paramInt;
    this.AMU = kotlin.k.cm((kotlin.g.a.a)d.AMX);
    AppMethodBeat.o(349915);
  }
  
  private static void a(View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(349946);
    paramView.setTag(paramFinderObject);
    Object localObject2 = (TextView)paramView.findViewById(e.e.like_count_tv);
    Object localObject1;
    if (paramFinderObject.likeCount > 0)
    {
      localObject1 = (CharSequence)r.ip(2, paramFinderObject.likeCount);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (TextView)paramView.findViewById(e.e.nickName);
      Object localObject3 = paramView.getContext();
      localObject1 = paramFinderObject.contact;
      if (localObject1 != null) {
        break label270;
      }
      localObject1 = null;
      label73:
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)localObject1));
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
      localObject1 = paramFinderObject.contact;
      if (localObject1 != null) {
        break label278;
      }
      localObject1 = null;
      label108:
      localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
      localObject3 = (ImageView)paramView.findViewById(e.e.avatar);
      s.s(localObject3, "cardView.avatar");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject != null) {
        break label286;
      }
      paramFinderObject = null;
    }
    for (;;)
    {
      localObject1 = paramFinderObject;
      if (paramFinderObject == null) {
        localObject1 = new FinderMedia();
      }
      paramFinderObject = ((com.tencent.mm.loader.d)localObject2).dk(new n(com.tencent.mm.plugin.finder.storage.logic.d.a.d((FinderMedia)localObject1), v.FKZ, null, null, 12));
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramFinderObject = paramFinderObject.a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      paramView = (ImageView)paramView.findViewById(e.e.cover);
      s.s(paramView, "cardView.cover");
      paramFinderObject.d(paramView);
      AppMethodBeat.o(349946);
      return;
      localObject1 = (CharSequence)"0";
      break;
      label270:
      localObject1 = ((FinderContact)localObject1).nickname;
      break label73;
      label278:
      localObject1 = ((FinderContact)localObject1).headUrl;
      break label108;
      label286:
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject == null) {
        paramFinderObject = null;
      } else {
        paramFinderObject = (FinderMedia)paramFinderObject.getFirst();
      }
    }
  }
  
  private static final void a(cs paramcs, au paramau, int paramInt, View paramView)
  {
    AppMethodBeat.i(349993);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcs);
    localb.cH(paramau);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcs, "this$0");
    s.u(paramau, "$item");
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramcs = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(349993);
      throw paramcs;
    }
    paramcs.a((MMActivity)paramView, null, paramau, 4, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349993);
  }
  
  private static final void a(cs paramcs, com.tencent.mm.view.recyclerview.j paramj, au paramau, int paramInt, View paramView)
  {
    AppMethodBeat.i(350004);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcs);
    localb.cH(paramj);
    localb.cH(paramau);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcs, "this$0");
    s.u(paramj, "$holder");
    s.u(paramau, "$item");
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramcs = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350004);
      throw paramcs;
    }
    paramView = (MMActivity)paramView;
    paramj = paramj.caK.findViewById(e.e.card1).getTag();
    if ((paramj instanceof FinderObject)) {}
    for (paramj = (FinderObject)paramj;; paramj = null)
    {
      paramcs.a(paramView, paramj, paramau, 1, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350004);
      return;
    }
  }
  
  private final void a(MMActivity paramMMActivity, FinderObject paramFinderObject, au paramau, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(349978);
    Object localObject1 = paramau.AYW.object;
    s.s(localObject1, "item.card.`object`");
    Object localObject2 = (List)localObject1;
    Object localObject3 = new StringBuilder("[jump2HotTab] finderObject=");
    if (paramFinderObject == null) {}
    for (localObject1 = null;; localObject1 = Long.valueOf(paramFinderObject.id))
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" objectList=");
      localObject4 = (Iterable)localObject2;
      localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Long.valueOf(((FinderObject)((Iterator)localObject4).next()).id));
      }
    }
    Log.i("Finder.StreamCardFeedConvert", (List)localObject3);
    localObject1 = (Collection)paramau.rvFeedList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("Finder.StreamCardFeedConvert", "rvFeedList is empty");
      AppMethodBeat.o(349978);
      return;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(FinderHomeUIC.class);
    s.s(localObject1, "UICProvider.of(context).…inderHomeUIC::class.java)");
    localObject3 = (FinderHomeUIC)localObject1;
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(4);
    ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject1).a(d.d.GKO);
    ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject1).GKz = System.currentTimeMillis();
    ((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject1).aE(new ArrayList((Collection)paramau.rvFeedList));
    Object localObject4 = new Bundle();
    localObject1 = dYf();
    Object localObject5 = paramau.AYW.object;
    s.s(localObject5, "item.card.`object`");
    localObject5 = (List)localObject5;
    Object localObject6 = com.tencent.mm.plugin.finder.viewmodel.f.GLc;
    localObject6 = f.a.c(paramau);
    kotlin.g.a.a locala = (kotlin.g.a.a)new cs.b((Bundle)localObject4);
    s.u(localObject5, "list");
    s.u(localObject6, "token");
    s.u(locala, "call");
    label499:
    int j;
    if (!((com.tencent.mm.plugin.finder.viewmodel.f)localObject1).GLd.containsKey(localObject6))
    {
      Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + (String)localObject6 + " not exist.");
      ((Map)((com.tencent.mm.plugin.finder.viewmodel.f)localObject1).GLd).put(localObject6, localObject5);
      locala.invoke();
      ((Bundle)localObject4).putInt("RequestScene", 1);
      if (paramFinderObject == null) {
        break label751;
      }
      i = 0;
      localObject1 = ((List)localObject2).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label745;
      }
      if (((FinderObject)((Iterator)localObject1).next()).id != paramFinderObject.id) {
        break label730;
      }
      j = 1;
      label533:
      if (j == 0) {
        break label736;
      }
      label538:
      ((Bundle)localObject4).putInt("ScrollPosition", i);
      switch (paramInt1)
      {
      case 2: 
      default: 
        ((Bundle)localObject4).putInt("Source", 4);
      }
    }
    for (;;)
    {
      localObject1 = "";
      paramau = paramau.AYW.object.subList(0, Math.min(3, paramau.AYW.object.size()));
      s.s(paramau, "item.card.`object`.subLi…item.card.`object`.size))");
      localObject2 = ((Iterable)paramau).iterator();
      for (paramau = (au)localObject1; ((Iterator)localObject2).hasNext(); paramau = paramau + com.tencent.mm.ae.d.hF(((FinderObject)localObject1).id) + '|') {
        localObject1 = (FinderObject)((Iterator)localObject2).next();
      }
      Log.i("Finder.StreamCardVM", "[checkPreloadForReportReadStats] token=" + (String)localObject6 + " has exist.");
      break;
      label730:
      j = 0;
      break label533;
      label736:
      i += 1;
      break label499;
      label745:
      i = -1;
      break label538;
      label751:
      i = -1;
      break label538;
      ((Bundle)localObject4).putInt("Source", 2);
      continue;
      ((Bundle)localObject4).putInt("Source", 3);
      continue;
      ((Bundle)localObject4).putInt("Source", 2);
    }
    localObject1 = z.FrZ;
    if (paramFinderObject == null) {}
    for (long l = 0L;; l = paramFinderObject.id)
    {
      paramFinderObject = com.tencent.mm.ae.d.hF(l);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      z.a(paramInt1, paramFinderObject, i + 1, paramau, paramInt2, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(as.class)).Vl(this.hJx));
      ((FinderHomeUIC)localObject3).u(4, (Bundle)localObject4);
      AppMethodBeat.o(349978);
      return;
    }
  }
  
  private static final void b(cs paramcs, au paramau, int paramInt, View paramView)
  {
    AppMethodBeat.i(350031);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcs);
    localb.cH(paramau);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcs, "this$0");
    s.u(paramau, "$item");
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramcs = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350031);
      throw paramcs;
    }
    paramcs.a((MMActivity)paramView, null, paramau, 3, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350031);
  }
  
  private static final void b(cs paramcs, com.tencent.mm.view.recyclerview.j paramj, au paramau, int paramInt, View paramView)
  {
    AppMethodBeat.i(350012);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcs);
    localb.cH(paramj);
    localb.cH(paramau);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcs, "this$0");
    s.u(paramj, "$holder");
    s.u(paramau, "$item");
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramcs = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350012);
      throw paramcs;
    }
    paramView = (MMActivity)paramView;
    paramj = paramj.caK.findViewById(e.e.card2).getTag();
    if ((paramj instanceof FinderObject)) {}
    for (paramj = (FinderObject)paramj;; paramj = null)
    {
      paramcs.a(paramView, paramj, paramau, 1, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350012);
      return;
    }
  }
  
  private static final void c(cs paramcs, com.tencent.mm.view.recyclerview.j paramj, au paramau, int paramInt, View paramView)
  {
    AppMethodBeat.i(350020);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcs);
    localb.cH(paramj);
    localb.cH(paramau);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcs, "this$0");
    s.u(paramj, "$holder");
    s.u(paramau, "$item");
    paramView = paramView.getContext();
    if (paramView == null)
    {
      paramcs = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350020);
      throw paramcs;
    }
    paramView = (MMActivity)paramView;
    paramj = paramj.caK.findViewById(e.e.card3).getTag();
    if ((paramj instanceof FinderObject)) {}
    for (paramj = (FinderObject)paramj;; paramj = null)
    {
      paramcs.a(paramView, paramj, paramau, 1, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350020);
      return;
    }
  }
  
  private final com.tencent.mm.plugin.finder.viewmodel.f dYf()
  {
    AppMethodBeat.i(349924);
    com.tencent.mm.plugin.finder.viewmodel.f localf = (com.tencent.mm.plugin.finder.viewmodel.f)this.AMU.getValue();
    AppMethodBeat.o(349924);
    return localf;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(350103);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.title)).getPaint(), 0.8F);
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.linkTitle)).getPaint(), 0.8F);
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.card1).findViewById(e.e.nickName)).getPaint(), 0.8F);
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.card2).findViewById(e.e.nickName)).getPaint(), 0.8F);
    aw.a((Paint)((TextView)paramj.caK.findViewById(e.e.card3).findViewById(e.e.nickName)).getPaint(), 0.8F);
    ((WeImageView)paramj.caK.findViewById(e.e.card1).findViewById(e.e.like_icon_iv)).setImageDrawable(bb.m(paramj.context, e.g.icon_filled_awesome, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.White)));
    ((WeImageView)paramj.caK.findViewById(e.e.card2).findViewById(e.e.like_icon_iv)).setImageDrawable(bb.m(paramj.context, e.g.icon_filled_awesome, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.White)));
    ((WeImageView)paramj.caK.findViewById(e.e.card3).findViewById(e.e.like_icon_iv)).setImageDrawable(bb.m(paramj.context, e.g.icon_filled_awesome, paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.White)));
    paramRecyclerView = paramj.caK;
    s.s(paramRecyclerView, "holder.itemView");
    com.tencent.mm.view.f.a(paramRecyclerView, (com.tencent.mm.view.e.b)new c(paramj, this));
    AppMethodBeat.o(350103);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_jump_hot_card_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.view.e.b
  {
    c(com.tencent.mm.view.recyclerview.j paramj, cs paramcs) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(349646);
      s.u(paramView, "view");
      if (!paramBoolean)
      {
        AppMethodBeat.o(349646);
        return;
      }
      paramView = "";
      try
      {
        Object localObject1 = (au)this.wHm.CSA;
        if (localObject1 != null)
        {
          Object localObject2 = jdField_this;
          Object localObject3 = ((au)localObject1).AYW.object.subList(0, Math.min(3, ((au)localObject1).AYW.object.size()));
          s.s(localObject3, "it.card.`object`.subList…, it.card.`object`.size))");
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            FinderObject localFinderObject = (FinderObject)((Iterator)localObject3).next();
            paramView = paramView + com.tencent.mm.ae.d.hF(localFinderObject.id) + '|';
          }
          localObject2 = cs.a((cs)localObject2);
          if (localObject2 != null)
          {
            localObject3 = com.tencent.mm.ui.component.k.aeZF;
            localObject3 = (com.tencent.mm.plugin.finder.viewmodel.f)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.f.class);
            s.u(localObject1, "item");
            localObject1 = (Integer)((com.tencent.mm.plugin.finder.viewmodel.f)localObject3).GLe.get(f.a.c((au)localObject1));
            if (localObject1 != null) {
              break label236;
            }
          }
          label236:
          for (int i = -1;; i = ((Integer)localObject1).intValue())
          {
            localObject1 = z.FrZ;
            z.a(paramView, i, (bui)localObject2);
            AppMethodBeat.o(349646);
            return;
          }
        }
        return;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("Finder.StreamCardFeedConvert", (Throwable)paramView, "", new Object[0]);
        AppMethodBeat.o(349646);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.f>
  {
    public static final d AMX;
    
    static
    {
      AppMethodBeat.i(349645);
      AMX = new d();
      AppMethodBeat.o(349645);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cs
 * JD-Core Version:    0.7.0.1
 */