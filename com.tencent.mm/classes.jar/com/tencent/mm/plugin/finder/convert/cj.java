package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "getTabType", "()I", "bindData", "", "cardView", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getLayoutId", "jump2HotTab", "context", "Lcom/tencent/mm/ui/MMActivity;", "item", "action", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class cj
  extends e<ag>
{
  public static final a tHc;
  private final int dLS;
  private final kotlin.f tGQ;
  private final bbn ttO;
  
  static
  {
    AppMethodBeat.i(243368);
    tHc = new a((byte)0);
    AppMethodBeat.o(243368);
  }
  
  public cj(bbn parambbn, int paramInt)
  {
    AppMethodBeat.i(243367);
    this.ttO = parambbn;
    this.dLS = paramInt;
    this.tGQ = g.ah((kotlin.g.a.a)i.tHf);
    AppMethodBeat.o(243367);
  }
  
  private static void a(View paramView, FinderObject paramFinderObject)
  {
    ImageView localImageView = null;
    AppMethodBeat.i(243365);
    paramView.setTag(paramFinderObject);
    Object localObject2 = (TextView)paramView.findViewById(2131303177);
    p.g(localObject2, "cardView.like_count_tv");
    Object localObject3;
    if (paramFinderObject.likeCount > 0)
    {
      localObject1 = (CharSequence)com.tencent.mm.plugin.finder.utils.k.gm(2, paramFinderObject.likeCount);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (TextView)paramView.findViewById(2131305429);
      p.g(localObject2, "cardView.nickName");
      localObject3 = paramView.getContext();
      localObject1 = paramFinderObject.contact;
      if (localObject1 == null) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
      localObject1 = m.uJa;
      localObject2 = m.dka();
      localObject3 = paramFinderObject.contact;
      localObject1 = localImageView;
      if (localObject3 != null) {
        localObject1 = ((FinderContact)localObject3).headUrl;
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localImageView = (ImageView)paramView.findViewById(2131297119);
      p.g(localImageView, "cardView.avatar");
      localObject3 = m.uJa;
      ((com.tencent.mm.loader.d)localObject2).a(localObject1, localImageView, m.a(m.a.uJe));
      localObject1 = m.uJa;
      paramFinderObject = m.djY().bQ(f(paramFinderObject));
      localObject1 = m.uJa;
      paramFinderObject = paramFinderObject.a(m.a(m.a.uJb));
      paramView = (ImageView)paramView.findViewById(2131299277);
      p.g(paramView, "cardView.cover");
      paramFinderObject.c(paramView);
      AppMethodBeat.o(243365);
      return;
      localObject1 = (CharSequence)"0";
      break;
    }
  }
  
  private final FinderStreamCardVM cZQ()
  {
    AppMethodBeat.i(243362);
    FinderStreamCardVM localFinderStreamCardVM = (FinderStreamCardVM)this.tGQ.getValue();
    AppMethodBeat.o(243362);
    return localFinderStreamCardVM;
  }
  
  private static com.tencent.mm.plugin.finder.loader.k f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(243366);
    Object localObject = c.vGN;
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
    paramFinderObject = new com.tencent.mm.plugin.finder.loader.k(c.a.b(paramFinderObject), x.vEo, null, null, 12);
    AppMethodBeat.o(243366);
    return paramFinderObject;
  }
  
  public final void a(RecyclerView paramRecyclerView, final h paramh, int paramInt)
  {
    AppMethodBeat.i(243363);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131309195);
    p.g(paramRecyclerView, "holder.itemView.title");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131303211);
    p.g(paramRecyclerView, "holder.itemView.linkTitle");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131298007);
    p.g(paramRecyclerView, "holder.itemView.card1");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131305429);
    p.g(paramRecyclerView, "holder.itemView.card1.nickName");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131298008);
    p.g(paramRecyclerView, "holder.itemView.card2");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131305429);
    p.g(paramRecyclerView, "holder.itemView.card2.nickName");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131298009);
    p.g(paramRecyclerView, "holder.itemView.card3");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131305429);
    p.g(paramRecyclerView, "holder.itemView.card3.nickName");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131298007);
    p.g(paramRecyclerView, "holder.itemView.card1");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131303182);
    Context localContext1 = paramh.getContext();
    Context localContext2 = paramh.getContext();
    p.g(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(ar.m(localContext1, 2131690436, localContext2.getResources().getColor(2131099844)));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131298008);
    p.g(paramRecyclerView, "holder.itemView.card2");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131303182);
    localContext1 = paramh.getContext();
    localContext2 = paramh.getContext();
    p.g(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(ar.m(localContext1, 2131690436, localContext2.getResources().getColor(2131099844)));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131298009);
    p.g(paramRecyclerView, "holder.itemView.card3");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131303182);
    localContext1 = paramh.getContext();
    localContext2 = paramh.getContext();
    p.g(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(ar.m(localContext1, 2131690436, localContext2.getResources().getColor(2131099844)));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    com.tencent.mm.view.f.a(paramRecyclerView, (e.b)new h(this, paramh));
    AppMethodBeat.o(243363);
  }
  
  public final int getLayoutId()
  {
    return 2131492890;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(cj paramcj, ag paramag, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243354);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.tHe;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243354);
        throw paramView;
      }
      cj.a((cj)localObject, (MMActivity)paramView, null, this.tGw, 4, this.gUj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243354);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(cj paramcj, h paramh, ag paramag, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243355);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      cj localcj = this.tHe;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243355);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.qhp.aus;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131298007);
      p.g(paramView, "holder.itemView.card1");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      cj.a(localcj, localMMActivity, (FinderObject)paramView, this.tGw, 1, this.gUj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243355);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(cj paramcj, h paramh, ag paramag, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243356);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      cj localcj = this.tHe;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243356);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.qhp.aus;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131298008);
      p.g(paramView, "holder.itemView.card2");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      cj.a(localcj, localMMActivity, (FinderObject)paramView, this.tGw, 1, this.gUj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243356);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(cj paramcj, h paramh, ag paramag, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243357);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      cj localcj = this.tHe;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243357);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.qhp.aus;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131298009);
      p.g(paramView, "holder.itemView.card3");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      cj.a(localcj, localMMActivity, (FinderObject)paramView, this.tGw, 1, this.gUj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243357);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(cj paramcj, ag paramag, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243358);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = this.tHe;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243358);
        throw paramView;
      }
      cj.a((cj)localObject, (MMActivity)paramView, null, this.tGw, 3, this.gUj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243358);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
  public static final class h
    extends e.b
  {
    h(h paramh) {}
    
    public final void p(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(243359);
      p.h(paramView, "view");
      if (!paramBoolean)
      {
        AppMethodBeat.o(243359);
        return;
      }
      paramView = "";
      for (;;)
      {
        try
        {
          Object localObject1 = (ag)paramh.hgv();
          if (localObject1 == null) {
            break label266;
          }
          Object localObject2 = ((ag)localObject1).tQQ.object.subList(0, Math.min(3, ((ag)localObject1).tQQ.object.size()));
          p.g(localObject2, "it.card.`object`.subList…, it.card.`object`.size))");
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            paramView = paramView + com.tencent.mm.ac.d.zs(((FinderObject)localObject3).id) + '|';
            continue;
          }
          localObject2 = cj.a(this.tHe);
          if (localObject2 == null) {
            break;
          }
          Object localObject3 = com.tencent.mm.ui.component.a.PRN;
          localObject3 = (FinderStreamCardVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class);
          p.h(localObject1, "item");
          localObject1 = (Integer)((FinderStreamCardVM)localObject3).wuE.get(FinderStreamCardVM.a.b((ag)localObject1));
          if (localObject1 != null)
          {
            i = ((Integer)localObject1).intValue();
            localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(paramView, i, (bbn)localObject2);
            AppMethodBeat.o(243359);
            return;
          }
        }
        catch (Exception paramView)
        {
          Log.printErrStackTrace("Finder.StreamCardFeedConvert", (Throwable)paramView, "", new Object[0]);
          AppMethodBeat.o(243359);
          return;
        }
        int i = -1;
      }
      AppMethodBeat.o(243359);
      return;
      label266:
      AppMethodBeat.o(243359);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<FinderStreamCardVM>
  {
    public static final i tHf;
    
    static
    {
      AppMethodBeat.i(243361);
      tHf = new i();
      AppMethodBeat.o(243361);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cj
 * JD-Core Version:    0.7.0.1
 */