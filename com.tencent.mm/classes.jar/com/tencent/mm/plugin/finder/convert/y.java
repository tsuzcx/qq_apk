package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class y
  extends com.tencent.mm.view.recyclerview.b<BaseFinderFeed>
{
  final FinderFoldedScrollLayout.b rOF;
  private final int rOh;
  
  public y(FinderFoldedScrollLayout.b paramb)
  {
    this.rOF = paramb;
    this.rOh = 2131496200;
  }
  
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    parame.auu.setOnClickListener((View.OnClickListener)new a(this, parame));
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.p.h(parame, "holder");
    d.g.b.p.h(paramBaseFinderFeed, "item");
    Object localObject = (ImageView)parame.Gd(2131299971);
    TextView localTextView = (TextView)parame.Gd(2131300017);
    if (this.rOF.cNn() == 1)
    {
      d.g.b.p.g(localObject, "avatar");
      ((ImageView)localObject).setVisibility(0);
      d.g.b.p.g(localTextView, "nickname");
      localTextView.setVisibility(0);
      paramList = i.sja;
      d locald = i.cCC();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        paramList = paramList.cxL();
        paramList = new com.tencent.mm.plugin.finder.loader.a(bt.nullAsNil(paramList));
        i locali = i.sja;
        locald.a(paramList, (ImageView)localObject, i.a(i.a.sjd));
        localTextView.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
        al.a((Paint)localTextView.getPaint(), 0.8F);
        paramList = paramBaseFinderFeed.contact;
        if (paramList != null)
        {
          localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject = parame.Gd(2131296977);
          d.g.b.p.g(localObject, "holder.getView<ImageView>(R.id.auth_icon)");
          com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject, paramList.field_authInfo);
        }
      }
    }
    for (;;)
    {
      paramList = parame.Gd(2131300005);
      d.g.b.p.g(paramList, "likeContainer");
      paramList.setVisibility(8);
      paramList = (TextView)parame.Gd(2131299988);
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
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
      parame.kA(2131296977, 8);
    }
    label338:
    d.g.b.p.g(paramList, "descTv");
    paramList.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.rOh;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(y paramy, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201410);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.rOG.rOF.g(parame);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.y
 * JD-Core Version:    0.7.0.1
 */