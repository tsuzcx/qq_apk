package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "getTabType", "()I", "bindData", "", "cardView", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getLayoutId", "jump2HotTab", "context", "Lcom/tencent/mm/ui/MMActivity;", "item", "action", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class cq
  extends com.tencent.mm.view.recyclerview.e<an>
{
  public static final a xpO;
  private final int fEH;
  private final bid xbu;
  private final kotlin.f xpC;
  
  static
  {
    AppMethodBeat.i(279457);
    xpO = new a((byte)0);
    AppMethodBeat.o(279457);
  }
  
  public cq(bid parambid, int paramInt)
  {
    AppMethodBeat.i(279456);
    this.xbu = parambid;
    this.fEH = paramInt;
    this.xpC = kotlin.g.ar((kotlin.g.a.a)i.xpR);
    AppMethodBeat.o(279456);
  }
  
  private static void a(View paramView, FinderObject paramFinderObject)
  {
    ImageView localImageView = null;
    AppMethodBeat.i(279454);
    paramView.setTag(paramFinderObject);
    Object localObject2 = (TextView)paramView.findViewById(b.f.like_count_tv);
    p.j(localObject2, "cardView.like_count_tv");
    Object localObject3;
    if (paramFinderObject.likeCount > 0)
    {
      localObject1 = (CharSequence)m.gY(2, paramFinderObject.likeCount);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (TextView)paramView.findViewById(b.f.nickName);
      p.j(localObject2, "cardView.nickName");
      localObject3 = paramView.getContext();
      localObject1 = paramFinderObject.contact;
      if (localObject1 == null) {
        break label254;
      }
    }
    label254:
    for (Object localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject2 = com.tencent.mm.plugin.finder.loader.t.dJh();
      localObject3 = paramFinderObject.contact;
      localObject1 = localImageView;
      if (localObject3 != null) {
        localObject1 = ((FinderContact)localObject3).headUrl;
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.e((String)localObject1);
      localImageView = (ImageView)paramView.findViewById(b.f.avatar);
      p.j(localImageView, "cardView.avatar");
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramFinderObject = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(e(paramFinderObject));
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramFinderObject = paramFinderObject.a(com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      paramView = (ImageView)paramView.findViewById(b.f.cover);
      p.j(paramView, "cardView.cover");
      paramFinderObject.c(paramView);
      AppMethodBeat.o(279454);
      return;
      localObject1 = (CharSequence)"0";
      break;
    }
  }
  
  private final com.tencent.mm.plugin.finder.viewmodel.d dpN()
  {
    AppMethodBeat.i(279451);
    com.tencent.mm.plugin.finder.viewmodel.d locald = (com.tencent.mm.plugin.finder.viewmodel.d)this.xpC.getValue();
    AppMethodBeat.o(279451);
    return locald;
  }
  
  private static r e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(279455);
    Object localObject = c.AnK;
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        localObject = (FinderMedia)paramFinderObject.getFirst();
        paramFinderObject = (FinderObject)localObject;
        if (localObject != null) {
          break label50;
        }
      }
    }
    paramFinderObject = new FinderMedia();
    label50:
    paramFinderObject = new r(c.a.d(paramFinderObject), u.Alz, null, null, 12);
    AppMethodBeat.o(279455);
    return paramFinderObject;
  }
  
  public final void a(RecyclerView paramRecyclerView, final i parami, int paramInt)
  {
    AppMethodBeat.i(279452);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.title);
    p.j(paramRecyclerView, "holder.itemView.title");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.linkTitle);
    p.j(paramRecyclerView, "holder.itemView.linkTitle");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(b.f.card1);
    p.j(paramRecyclerView, "holder.itemView.card1");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.nickName);
    p.j(paramRecyclerView, "holder.itemView.card1.nickName");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(b.f.card2);
    p.j(paramRecyclerView, "holder.itemView.card2");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.nickName);
    p.j(paramRecyclerView, "holder.itemView.card2.nickName");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(b.f.card3);
    p.j(paramRecyclerView, "holder.itemView.card3");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.nickName);
    p.j(paramRecyclerView, "holder.itemView.card3.nickName");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(b.f.card1);
    p.j(paramRecyclerView, "holder.itemView.card1");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(b.f.like_icon_iv);
    Context localContext1 = parami.getContext();
    paramInt = b.i.icon_filled_awesome;
    Context localContext2 = parami.getContext();
    p.j(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(au.o(localContext1, paramInt, localContext2.getResources().getColor(b.c.White)));
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(b.f.card2);
    p.j(paramRecyclerView, "holder.itemView.card2");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(b.f.like_icon_iv);
    localContext1 = parami.getContext();
    paramInt = b.i.icon_filled_awesome;
    localContext2 = parami.getContext();
    p.j(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(au.o(localContext1, paramInt, localContext2.getResources().getColor(b.c.White)));
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(b.f.card3);
    p.j(paramRecyclerView, "holder.itemView.card3");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(b.f.like_icon_iv);
    localContext1 = parami.getContext();
    paramInt = b.i.icon_filled_awesome;
    localContext2 = parami.getContext();
    p.j(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(au.o(localContext1, paramInt, localContext2.getResources().getColor(b.c.White)));
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    com.tencent.mm.view.f.a(paramRecyclerView, (e.b)new h(this, parami));
    AppMethodBeat.o(279452);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_jump_hot_card_layout;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(cq paramcq, an paraman, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279510);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.xpQ;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(279510);
        throw paramView;
      }
      cq.a((cq)localObject, (MMActivity)paramView, null, this.xpj, 4, this.jEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279510);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(cq paramcq, i parami, an paraman, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282294);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      cq localcq = this.xpQ;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(282294);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.tDl.amk;
      p.j(paramView, "holder.itemView");
      paramView = paramView.findViewById(b.f.card1);
      p.j(paramView, "holder.itemView.card1");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      cq.a(localcq, localMMActivity, (FinderObject)paramView, this.xpj, 1, this.jEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282294);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(cq paramcq, i parami, an paraman, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272076);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      cq localcq = this.xpQ;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(272076);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.tDl.amk;
      p.j(paramView, "holder.itemView");
      paramView = paramView.findViewById(b.f.card2);
      p.j(paramView, "holder.itemView.card2");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      cq.a(localcq, localMMActivity, (FinderObject)paramView, this.xpj, 1, this.jEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272076);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(cq paramcq, i parami, an paraman, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273104);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      cq localcq = this.xpQ;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(273104);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.tDl.amk;
      p.j(paramView, "holder.itemView");
      paramView = paramView.findViewById(b.f.card3);
      p.j(paramView, "holder.itemView.card3");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      cq.a(localcq, localMMActivity, (FinderObject)paramView, this.xpj, 1, this.jEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273104);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(cq paramcq, an paraman, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264305);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.xpQ;
      p.j(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(264305);
        throw paramView;
      }
      cq.a((cq)localObject, (MMActivity)paramView, null, this.xpj, 3, this.jEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264305);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class h
    extends e.b
  {
    h(i parami) {}
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(277156);
      p.k(paramView, "view");
      if (!paramBoolean)
      {
        AppMethodBeat.o(277156);
        return;
      }
      paramView = "";
      for (;;)
      {
        try
        {
          Object localObject1 = (an)parami.ihX();
          if (localObject1 == null) {
            break label266;
          }
          Object localObject2 = ((an)localObject1).xBH.object.subList(0, Math.min(3, ((an)localObject1).xBH.object.size()));
          p.j(localObject2, "it.card.`object`.subList…, it.card.`object`.size))");
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            paramView = paramView + com.tencent.mm.ae.d.Fw(((FinderObject)localObject3).id) + '|';
            continue;
          }
          localObject2 = cq.a(this.xpQ);
          if (localObject2 == null) {
            break;
          }
          Object localObject3 = com.tencent.mm.ui.component.g.Xox;
          localObject3 = (com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.d.class);
          p.k(localObject1, "item");
          localObject1 = (Integer)((com.tencent.mm.plugin.finder.viewmodel.d)localObject3).Bhd.get(d.a.b((an)localObject1));
          if (localObject1 != null)
          {
            i = ((Integer)localObject1).intValue();
            localObject1 = n.zWF;
            n.a(paramView, i, (bid)localObject2);
            AppMethodBeat.o(277156);
            return;
          }
        }
        catch (Exception paramView)
        {
          Log.printErrStackTrace("Finder.StreamCardFeedConvert", (Throwable)paramView, "", new Object[0]);
          AppMethodBeat.o(277156);
          return;
        }
        int i = -1;
      }
      AppMethodBeat.o(277156);
      return;
      label266:
      AppMethodBeat.o(277156);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.d>
  {
    public static final i xpR;
    
    static
    {
      AppMethodBeat.i(258086);
      xpR = new i();
      AppMethodBeat.o(258086);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cq
 * JD-Core Version:    0.7.0.1
 */