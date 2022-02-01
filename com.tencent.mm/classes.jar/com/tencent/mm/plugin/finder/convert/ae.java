package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ae
  extends b<BaseFinderFeed>
{
  final FinderFoldedScrollLayout.b KLj;
  private final int qru;
  
  public ae(FinderFoldedScrollLayout.b paramb)
  {
    this.KLj = paramb;
    this.qru = 2131496199;
  }
  
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    parame.arI.setOnClickListener((View.OnClickListener)new a(this, parame));
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramBaseFinderFeed, "item");
    ImageView localImageView = (ImageView)parame.abq(2131299971);
    TextView localTextView = (TextView)parame.abq(2131300017);
    if (this.KLj.fWP() == 1)
    {
      paramList = h.qCF;
      d locald = h.cmV();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        paramList = paramList.cks();
        paramList = new com.tencent.mm.plugin.finder.loader.a(bt.nullAsNil(paramList));
        d.g.b.k.g(localImageView, "avatar");
        h localh = h.qCF;
        locald.a(paramList, localImageView, h.a(h.a.qCI));
        d.g.b.k.g(localTextView, "nickname");
        localTextView.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
        ai.a((Paint)localTextView.getPaint(), 0.8F);
        paramList = paramBaseFinderFeed.contact;
        if (paramList != null)
        {
          paramList = paramList.field_authInfo;
          if (paramList == null) {
            break label320;
          }
          paramInt1 = paramList.authIconType;
          label180:
          if (paramInt1 <= 0) {
            break label419;
          }
          switch (paramInt1)
          {
          default: 
            parame.jY(2131296977, 8);
          }
        }
      }
    }
    for (;;)
    {
      paramList = parame.abq(2131300005);
      d.g.b.k.g(paramList, "likeContainer");
      paramList.setVisibility(8);
      paramList = (TextView)parame.abq(2131299988);
      if (bt.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label471;
      }
      d.g.b.k.g(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription()));
      return;
      paramList = null;
      break;
      label320:
      paramInt1 = 0;
      break label180;
      parame.jY(2131296977, 0);
      ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131100725)));
      continue;
      parame.jY(2131296977, 0);
      ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131099748)));
      continue;
      parame.jY(2131296977, 8);
      continue;
      label419:
      parame.jY(2131296977, 8);
      continue;
      d.g.b.k.g(localImageView, "avatar");
      localImageView.setVisibility(8);
      d.g.b.k.g(localTextView, "nickname");
      localTextView.setVisibility(8);
      parame.jY(2131296977, 8);
    }
    label471:
    d.g.b.k.g(paramList, "descTv");
    paramList.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.qru;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(ae paramae, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197450);
      this.KLk.KLj.f(parame);
      AppMethodBeat.o(197450);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae
 * JD-Core Version:    0.7.0.1
 */