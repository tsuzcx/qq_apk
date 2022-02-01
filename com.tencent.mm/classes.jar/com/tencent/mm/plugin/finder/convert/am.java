package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class am
  extends e<BaseFinderFeed>
{
  private final int tDB;
  final FinderFoldedScrollLayout.b tEj;
  
  public am(FinderFoldedScrollLayout.b paramb, int paramInt)
  {
    this.tEj = paramb;
    this.tDB = paramInt;
  }
  
  public void a(RecyclerView paramRecyclerView, final h paramh, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramh.aus.setOnClickListener((View.OnClickListener)new a(this, paramh));
    this.tEj.cZE();
    paramRecyclerView = (ImageView)paramh.Mn(2131300773);
    TextView localTextView = (TextView)paramh.Mn(2131301380);
    if (localTextView != null) {
      localTextView.setOnClickListener((View.OnClickListener)new am.b(paramRecyclerView));
    }
    if (paramRecyclerView != null) {
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(paramh));
    }
  }
  
  public void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    p.h(paramh, "holder");
    p.h(paramBaseFinderFeed, "item");
    Object localObject1 = (ImageView)paramh.Mn(2131300773);
    Object localObject2 = (TextView)paramh.Mn(2131301380);
    paramh.Mn(2131303177);
    if (this.tEj.cZG() == 1)
    {
      p.g(localObject1, "avatar");
      ((ImageView)localObject1).setVisibility(0);
      paramList = m.uJa;
      d locald = m.dka();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        paramList = paramList.cXH();
        paramList = new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(paramList));
        m localm = m.uJa;
        locald.a(paramList, (ImageView)localObject1, m.a(m.a.uJe));
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(0);
          ((TextView)localObject2).setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
          ao.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
        }
        paramList = (ImageView)paramh.Mn(2131297096);
        if (paramList != null)
        {
          localObject1 = paramBaseFinderFeed.contact;
          if (localObject1 != null)
          {
            localObject2 = y.vXH;
            y.a(paramList, ((g)localObject1).field_authInfo);
          }
        }
      }
    }
    for (;;)
    {
      paramList = paramh.Mn(2131300858);
      if (paramList != null)
      {
        paramBaseFinderFeed.feedObject.getLikeCount();
        this.tEj.cZF();
        paramList.setVisibility(8);
        this.tEj.cZF();
      }
      paramh = (TextView)paramh.Mn(2131300801);
      if (paramh != null)
      {
        if (Util.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
          break label361;
        }
        paramh.setVisibility(0);
        paramh.setText((CharSequence)paramBaseFinderFeed.feedObject.getDescriptionSpan());
      }
      return;
      paramList = null;
      break;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      paramList = (ImageView)paramh.Mn(2131297096);
      if (paramList != null) {
        paramList.setVisibility(8);
      }
    }
    label361:
    paramh.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.tDB;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(am paramam, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243125);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.tEk.tEj.h(paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243125);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243127);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      paramView = new Intent();
      localObject1 = (BaseFinderFeed)this.qhp.hgv();
      paramView.putExtra("finder_username", ((BaseFinderFeed)localObject1).feedObject.getUserName());
      Object localObject2 = FinderReporterUIC.wzC;
      localObject2 = this.qhp.getContext();
      p.g(localObject2, "holder.context");
      FinderReporterUIC.a.a((Context)localObject2, paramView, ((BaseFinderFeed)localObject1).lT(), 5, false, 64);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject1 = this.qhp.getContext();
      p.g(localObject1, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject1, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am
 * JD-Core Version:    0.7.0.1
 */