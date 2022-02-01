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
import d.l;
import d.v;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "tabType", "", "(I)V", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "getTabType", "()I", "bindData", "", "cardView", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "getLayoutId", "jump2HotTab", "context", "Lcom/tencent/mm/ui/MMActivity;", "item", "action", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class bh
  extends com.tencent.mm.view.recyclerview.b<ab>
{
  public static final bh.a rYr;
  private final int dvm;
  private final f rYq;
  
  static
  {
    AppMethodBeat.i(201945);
    rYr = new bh.a((byte)0);
    AppMethodBeat.o(201945);
  }
  
  public bh(int paramInt)
  {
    AppMethodBeat.i(201944);
    this.dvm = paramInt;
    this.rYq = d.g.O((d.g.a.a)bh.h.rYv);
    AppMethodBeat.o(201944);
  }
  
  private static void a(View paramView, FinderObject paramFinderObject)
  {
    ImageView localImageView = null;
    AppMethodBeat.i(201942);
    paramView.setTag(paramFinderObject);
    Object localObject2 = (TextView)paramView.findViewById(2131301416);
    p.g(localObject2, "cardView.like_count_tv");
    Object localObject3;
    if (paramFinderObject.likeCount > 0)
    {
      localObject1 = (CharSequence)h.fR(2, paramFinderObject.likeCount);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (TextView)paramView.findViewById(2131308365);
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
      ((TextView)localObject2).setText((CharSequence)k.c((Context)localObject3, (CharSequence)localObject1));
      localObject1 = i.srW;
      localObject2 = i.cEo();
      localObject3 = paramFinderObject.contact;
      localObject1 = localImageView;
      if (localObject3 != null) {
        localObject1 = ((FinderContact)localObject3).headUrl;
      }
      localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
      localImageView = (ImageView)paramView.findViewById(2131296996);
      p.g(localImageView, "cardView.avatar");
      localObject3 = i.srW;
      ((d)localObject2).a(localObject1, localImageView, i.a(i.a.srZ));
      localObject1 = i.srW;
      paramFinderObject = i.cEn().bI(f(paramFinderObject));
      localObject1 = i.srW;
      paramFinderObject = paramFinderObject.a(i.a(i.a.srX));
      paramView = (ImageView)paramView.findViewById(2131298813);
      p.g(paramView, "cardView.cover");
      paramFinderObject.c(paramView);
      AppMethodBeat.o(201942);
      return;
      localObject1 = (CharSequence)"0";
      break;
    }
  }
  
  private final FinderStreamCardVM cAH()
  {
    AppMethodBeat.i(201939);
    FinderStreamCardVM localFinderStreamCardVM = (FinderStreamCardVM)this.rYq.getValue();
    AppMethodBeat.o(201939);
    return localFinderStreamCardVM;
  }
  
  private static com.tencent.mm.plugin.finder.loader.g f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(201943);
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
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
    paramFinderObject = new com.tencent.mm.plugin.finder.loader.g(b.a.a(2, paramFinderObject), r.sJv);
    AppMethodBeat.o(201943);
    return paramFinderObject;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(201940);
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
    AppMethodBeat.o(201940);
  }
  
  public final int getLayoutId()
  {
    return 2131496506;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(bh parambh, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201932);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.rYt;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201932);
        throw paramView;
      }
      bh.a((bh)localObject, (MMActivity)paramView, null, this.rYu, 4, this.gke);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201932);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(bh parambh, e parame, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201933);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      bh localbh = this.rYt;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201933);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.oTF.auu;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131308252);
      p.g(paramView, "holder.itemView.card1");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      bh.a(localbh, localMMActivity, (FinderObject)paramView, this.rYu, 1, this.gke);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201933);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(bh parambh, e parame, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201934);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      bh localbh = this.rYt;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201934);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.oTF.auu;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131308253);
      p.g(paramView, "holder.itemView.card2");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      bh.a(localbh, localMMActivity, (FinderObject)paramView, this.rYu, 1, this.gke);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201934);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(bh parambh, e parame, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201935);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      bh localbh = this.rYt;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201935);
        throw paramView;
      }
      MMActivity localMMActivity = (MMActivity)paramView;
      paramView = this.oTF.auu;
      p.g(paramView, "holder.itemView");
      paramView = paramView.findViewById(2131308254);
      p.g(paramView, "holder.itemView.card3");
      localObject = paramView.getTag();
      paramView = (View)localObject;
      if (!(localObject instanceof FinderObject)) {
        paramView = null;
      }
      bh.a(localbh, localMMActivity, (FinderObject)paramView, this.rYu, 1, this.gke);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201935);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(bh parambh, ab paramab, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201936);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = this.rYt;
      p.g(paramView, "it");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(201936);
        throw paramView;
      }
      bh.a((bh)localObject, (MMActivity)paramView, null, this.rYu, 3, this.gke);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bh
 * JD-Core Version:    0.7.0.1
 */