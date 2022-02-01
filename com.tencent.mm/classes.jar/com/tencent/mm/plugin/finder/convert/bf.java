package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "tabType", "", "(I)V", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "getTabType", "()I", "bindData", "", "cardView", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "getLayoutId", "jump2HotTab", "context", "Lcom/tencent/mm/ui/MMActivity;", "item", "action", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class bf
  extends com.tencent.mm.view.recyclerview.b<ab>
{
  public static final a rPP;
  private final int duh;
  private final f rPO;
  
  static
  {
    AppMethodBeat.i(201500);
    rPP = new a((byte)0);
    AppMethodBeat.o(201500);
  }
  
  public bf(int paramInt)
  {
    AppMethodBeat.i(201499);
    this.duh = paramInt;
    this.rPO = d.g.O((d.g.a.a)h.rPT);
    AppMethodBeat.o(201499);
  }
  
  private static void a(View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201497);
    paramView.setTag(paramFinderObject);
    Object localObject2 = (TextView)paramView.findViewById(2131301416);
    p.g(localObject2, "cardView.like_count_tv");
    if (paramFinderObject.likeCount > 0) {}
    for (Object localObject1 = (CharSequence)h.fR(2, paramFinderObject.likeCount);; localObject1 = (CharSequence)"0")
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (TextView)paramView.findViewById(2131308365);
      p.g(localObject1, "cardView.nickName");
      ((TextView)localObject1).setText((CharSequence)k.c(paramView.getContext(), (CharSequence)paramFinderObject.contact.nickname));
      localObject1 = i.sja;
      localObject1 = i.cCC();
      localObject2 = new com.tencent.mm.plugin.finder.loader.a(paramFinderObject.contact.headUrl);
      ImageView localImageView = (ImageView)paramView.findViewById(2131296996);
      p.g(localImageView, "cardView.avatar");
      i locali = i.sja;
      ((d)localObject1).a(localObject2, localImageView, i.a(i.a.sjd));
      localObject1 = i.sja;
      paramFinderObject = i.cCB().bI(f(paramFinderObject));
      localObject1 = i.sja;
      paramFinderObject = paramFinderObject.a(i.a(i.a.sjb));
      paramView = (ImageView)paramView.findViewById(2131298813);
      p.g(paramView, "cardView.cover");
      paramFinderObject.c(paramView);
      AppMethodBeat.o(201497);
      return;
    }
  }
  
  private final FinderStreamCardVM czd()
  {
    AppMethodBeat.i(201494);
    FinderStreamCardVM localFinderStreamCardVM = (FinderStreamCardVM)this.rPO.getValue();
    AppMethodBeat.o(201494);
    return localFinderStreamCardVM;
  }
  
  private static com.tencent.mm.plugin.finder.loader.g f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201498);
    b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    paramFinderObject = paramFinderObject.objectDesc.media;
    p.g(paramFinderObject, "finderObject.objectDesc.media");
    paramFinderObject = paramFinderObject.getFirst();
    p.g(paramFinderObject, "finderObject.objectDesc.media.first");
    paramFinderObject = new com.tencent.mm.plugin.finder.loader.g(b.a.a(2, (FinderMedia)paramFinderObject), r.syE);
    AppMethodBeat.o(201498);
    return paramFinderObject;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201495);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131305902);
    p.g(paramRecyclerView, "holder.itemView.title");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131308343);
    p.g(paramRecyclerView, "holder.itemView.linkTitle");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131308252);
    p.g(paramRecyclerView, "holder.itemView.card1");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131308365);
    p.g(paramRecyclerView, "holder.itemView.card1.nickName");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131308253);
    p.g(paramRecyclerView, "holder.itemView.card2");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131308365);
    p.g(paramRecyclerView, "holder.itemView.card2.nickName");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131308254);
    p.g(paramRecyclerView, "holder.itemView.card3");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131308365);
    p.g(paramRecyclerView, "holder.itemView.card3.nickName");
    al.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131308252);
    p.g(paramRecyclerView, "holder.itemView.card1");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131307492);
    Context localContext1 = parame.getContext();
    Context localContext2 = parame.getContext();
    p.g(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(ao.k(localContext1, 2131690326, localContext2.getResources().getColor(2131099828)));
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131308253);
    p.g(paramRecyclerView, "holder.itemView.card2");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131307492);
    localContext1 = parame.getContext();
    localContext2 = parame.getContext();
    p.g(localContext2, "holder.context");
    paramRecyclerView.setImageDrawable(ao.k(localContext1, 2131690326, localContext2.getResources().getColor(2131099828)));
    paramRecyclerView = parame.auu;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.findViewById(2131308254);
    p.g(paramRecyclerView, "holder.itemView.card3");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131307492);
    localContext1 = parame.getContext();
    parame = parame.getContext();
    p.g(parame, "holder.context");
    paramRecyclerView.setImageDrawable(ao.k(localContext1, 2131690326, parame.getResources().getColor(2131099828)));
    AppMethodBeat.o(201495);
  }
  
  public final int getLayoutId()
  {
    return 2131496427;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(bf parambf, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201487);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.rPR;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201487);
        throw paramView;
      }
      bf.a((bf)localObject, (MMActivity)paramView, null, this.rPS, 4, this.ghM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201487);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(bf parambf, e parame, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201488);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      bf localbf = this.rPR;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201488);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.oNd.auu;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131308252);
      p.g(paramView, "holder.itemView.card1");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      bf.a(localbf, localMMActivity, (FinderObject)paramView, this.rPS, 1, this.ghM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201488);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bf parambf, e parame, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201489);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      bf localbf = this.rPR;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201489);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.oNd.auu;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131308253);
      p.g(paramView, "holder.itemView.card2");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      bf.a(localbf, localMMActivity, (FinderObject)paramView, this.rPS, 1, this.ghM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201489);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(bf parambf, e parame, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201490);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      bf localbf = this.rPR;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201490);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.oNd.auu;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131308254);
      p.g(paramView, "holder.itemView.card3");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      bf.a(localbf, localMMActivity, (FinderObject)paramView, this.rPS, 1, this.ghM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201490);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(bf parambf, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201491);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = this.rPR;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201491);
        throw paramView;
      }
      bf.a((bf)localObject, (MMActivity)paramView, null, this.rPS, 3, this.ghM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardFeedConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201491);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<FinderStreamCardVM>
  {
    public static final h rPT;
    
    static
    {
      AppMethodBeat.i(201493);
      rPT = new h();
      AppMethodBeat.o(201493);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bf
 * JD-Core Version:    0.7.0.1
 */