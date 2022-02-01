package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class y
  extends com.tencent.mm.view.recyclerview.b<BaseFinderFeed>
{
  private final int rWE;
  final FinderFoldedScrollLayout.b rXf;
  
  public y(FinderFoldedScrollLayout.b paramb)
  {
    this.rXf = paramb;
    this.rWE = 2131496200;
  }
  
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    parame.auu.setOnClickListener((View.OnClickListener)new a(this, parame));
    paramRecyclerView = this.rXf.cPX();
    if (paramRecyclerView != null)
    {
      Object localObject = parame.auu;
      d.g.b.p.g(localObject, "holder.itemView");
      localObject = (ImageView)((View)localObject).findViewById(2131305798);
      d.g.b.p.g(localObject, "holder.itemView.thumb_iv");
      ((ImageView)localObject).getLayoutParams().height = paramRecyclerView.height;
      localObject = parame.auu;
      d.g.b.p.g(localObject, "holder.itemView");
      localObject = (ImageView)((View)localObject).findViewById(2131305798);
      d.g.b.p.g(localObject, "holder.itemView.thumb_iv");
      ((ImageView)localObject).getLayoutParams().width = paramRecyclerView.width;
      parame.auu.requestLayout();
    }
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramBaseFinderFeed, "item");
    Object localObject = (ImageView)parame.GD(2131299971);
    TextView localTextView = (TextView)parame.GD(2131300017);
    if (this.rXf.cPV() == 1)
    {
      d.g.b.p.g(localObject, "avatar");
      ((ImageView)localObject).setVisibility(0);
      d.g.b.p.g(localTextView, "nickname");
      localTextView.setVisibility(0);
      paramList = i.srW;
      d locald = i.cEo();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        paramList = paramList.czm();
        paramList = new com.tencent.mm.plugin.finder.loader.a(bu.nullAsNil(paramList));
        i locali = i.srW;
        locald.a(paramList, (ImageView)localObject, i.a(i.a.srZ));
        localTextView.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
        al.a((Paint)localTextView.getPaint(), 0.8F);
        paramList = paramBaseFinderFeed.contact;
        if (paramList != null)
        {
          localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject = parame.GD(2131296977);
          d.g.b.p.g(localObject, "holder.getView<ImageView>(R.id.auth_icon)");
          com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject, paramList.field_authInfo);
        }
      }
    }
    for (;;)
    {
      paramList = parame.GD(2131300005);
      d.g.b.p.g(paramList, "likeContainer");
      paramList.setVisibility(8);
      paramList = (TextView)parame.GD(2131299988);
      if (bu.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label338;
      }
      d.g.b.p.g(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)k.c(parame.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription()));
      return;
      paramList = null;
      break;
      d.g.b.p.g(localObject, "avatar");
      ((ImageView)localObject).setVisibility(8);
      d.g.b.p.g(localTextView, "nickname");
      localTextView.setVisibility(8);
      parame.kH(2131296977, 8);
    }
    label338:
    d.g.b.p.g(paramList, "descTv");
    paramList.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.rWE;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(y paramy, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201848);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.rXg.rXf.g(parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201848);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.y
 * JD-Core Version:    0.7.0.1
 */