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
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderMixFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "layoutResId", "", "(I)V", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "baseItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ai
  extends b<v>
{
  private final int qru = 2131494051;
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    parame.arI.setOnClickListener((View.OnClickListener)new a(parame));
  }
  
  public void a(e parame, v paramv, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    d.g.b.k.h(parame, "holder");
    d.g.b.k.h(paramv, "baseItem");
    paramList = paramv.KTl;
    if (paramList != null)
    {
      ImageView localImageView = (ImageView)parame.abq(2131299971);
      paramv = h.qCF;
      d locald = h.cmV();
      paramv = paramList.contact;
      if (paramv == null) {
        break label306;
      }
      paramv = paramv.cks();
      paramv = new com.tencent.mm.plugin.finder.loader.a(bt.nullAsNil(paramv));
      d.g.b.k.g(localImageView, "avatar");
      h localh = h.qCF;
      locald.a(paramv, localImageView, h.a(h.a.qCI));
      paramv = (TextView)parame.abq(2131300017);
      d.g.b.k.g(paramv, "nickname");
      paramv.setText((CharSequence)paramList.feedObject.getNickNameSpan());
      com.tencent.mm.ui.ai.a((Paint)paramv.getPaint(), 0.8F);
      paramv = (TextView)parame.abq(2131301416);
      d.g.b.k.g(paramv, "likeTv");
      paramv.setText((CharSequence)String.valueOf(paramList.feedObject.getLikeCount()));
      paramv = (TextView)parame.abq(2131299988);
      if (bt.isNullOrNil(paramList.feedObject.getDescription())) {
        break label311;
      }
      d.g.b.k.g(paramv, "descTv");
      paramv.setVisibility(0);
      paramv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(parame.getContext(), (CharSequence)paramList.feedObject.getDescription()));
      label233:
      paramv = paramList.contact;
      if (paramv != null)
      {
        paramv = paramv.field_authInfo;
        if (paramv == null) {
          break label326;
        }
        paramInt1 = paramv.authIconType;
      }
    }
    for (;;)
    {
      if (paramInt1 > 0) {
        switch (paramInt1)
        {
        default: 
          parame.jY(2131296977, 8);
          return;
          paramv = null;
          break;
          d.g.b.k.g(paramv, "descTv");
          paramv.setVisibility(8);
          break label233;
          paramInt1 = 0;
          break;
        case 1: 
          parame.jY(2131296977, 0);
          ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131100725)));
          return;
        case 2: 
          parame.jY(2131296977, 0);
          ((ImageView)parame.abq(2131296977)).setImageDrawable(am.i(parame.getContext(), 2131690481, com.tencent.mm.cd.a.n(parame.getContext(), 2131099748)));
          return;
        case 100: 
          label306:
          label311:
          label326:
          parame.jY(2131296977, 8);
          return;
        }
      }
    }
    parame.jY(2131296977, 8);
  }
  
  public final int getLayoutId()
  {
    return this.qru;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197461);
      paramView = (v)this.nGG.fjf();
      if (paramView != null)
      {
        Object localObject = paramView.KTl;
        if (localObject != null)
        {
          paramView = new Intent();
          paramView.putExtra("FEED_ID", ((BaseFinderFeed)localObject).feedObject.getId());
          paramView.putExtra("ENTER_COMMENT_SCENE", 15);
          paramView.putExtra("TAB_TYPE", 2);
          localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
          localObject = this.nGG.getContext();
          d.g.b.k.g(localObject, "holder.context");
          com.tencent.mm.plugin.finder.utils.a.aj((Context)localObject, paramView);
          AppMethodBeat.o(197461);
          return;
        }
      }
      AppMethodBeat.o(197461);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ai
 * JD-Core Version:    0.7.0.1
 */