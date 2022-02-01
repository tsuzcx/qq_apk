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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class x
  extends b<BaseFinderFeed>
{
  final FinderFoldedScrollLayout.b rbS;
  private final int rbr;
  
  public x(FinderFoldedScrollLayout.b paramb)
  {
    this.rbS = paramb;
    this.rbr = 2131496200;
  }
  
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    parame.asD.setOnClickListener((View.OnClickListener)new a(this, parame));
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramBaseFinderFeed, "item");
    ImageView localImageView = (ImageView)parame.adJ(2131299971);
    TextView localTextView = (TextView)parame.adJ(2131300017);
    if (this.rbS.cEY() == 1)
    {
      d.g.b.k.g(localImageView, "avatar");
      localImageView.setVisibility(0);
      d.g.b.k.g(localTextView, "nickname");
      localTextView.setVisibility(0);
      paramList = h.rtK;
      d locald = h.cwo();
      paramList = paramBaseFinderFeed.contact;
      if (paramList != null)
      {
        paramList = paramList.crZ();
        paramList = new com.tencent.mm.plugin.finder.loader.a(bs.nullAsNil(paramList));
        h localh = h.rtK;
        locald.a(paramList, localImageView, h.a(h.a.rtN));
        localTextView.setText((CharSequence)paramBaseFinderFeed.feedObject.getNickNameSpan());
        aj.a((Paint)localTextView.getPaint(), 0.8F);
        paramList = paramBaseFinderFeed.contact;
        if (paramList != null)
        {
          paramList = paramList.field_authInfo;
          if (paramList == null) {
            break label332;
          }
          paramInt1 = paramList.authIconType;
          label192:
          if (paramInt1 <= 0) {
            break label431;
          }
          switch (paramInt1)
          {
          default: 
            parame.kl(2131296977, 8);
          }
        }
      }
    }
    for (;;)
    {
      paramList = parame.adJ(2131300005);
      d.g.b.k.g(paramList, "likeContainer");
      paramList.setVisibility(8);
      paramList = (TextView)parame.adJ(2131299988);
      if (bs.isNullOrNil(paramBaseFinderFeed.feedObject.getDescription())) {
        break label483;
      }
      d.g.b.k.g(paramList, "descTv");
      paramList.setVisibility(0);
      paramList.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)paramBaseFinderFeed.feedObject.getDescription()));
      return;
      paramList = null;
      break;
      label332:
      paramInt1 = 0;
      break label192;
      parame.kl(2131296977, 0);
      ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131100725)));
      continue;
      parame.kl(2131296977, 0);
      ((ImageView)parame.adJ(2131296977)).setImageDrawable(am.k(parame.getContext(), 2131690481, com.tencent.mm.cc.a.n(parame.getContext(), 2131099748)));
      continue;
      parame.kl(2131296977, 8);
      continue;
      label431:
      parame.kl(2131296977, 8);
      continue;
      d.g.b.k.g(localImageView, "avatar");
      localImageView.setVisibility(8);
      d.g.b.k.g(localTextView, "nickname");
      localTextView.setVisibility(8);
      parame.kl(2131296977, 8);
    }
    label483:
    d.g.b.k.g(paramList, "descTv");
    paramList.setText((CharSequence)"");
  }
  
  public final int getLayoutId()
  {
    return this.rbr;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(x paramx, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201325);
      this.rbT.rbS.f(parame);
      AppMethodBeat.o(201325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.x
 * JD-Core Version:    0.7.0.1
 */