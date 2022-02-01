package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "TAG", "", "formatDesc", "", "preCount", "", "incCount", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "id", "descTv", "Landroid/widget/TextView;", "getLayoutId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class au
  extends e<BaseFinderFeed>
{
  final String TAG = "Finder.FinderLikeConvert";
  
  private static void a(int paramInt1, int paramInt2, i parami, int paramInt3, TextView paramTextView)
  {
    AppMethodBeat.i(290038);
    Object localObject = paramInt1 + " + " + paramInt2;
    int i = ((String)localObject).length() - n.a((CharSequence)localObject, '+', 0, false, 6);
    localObject = parami.getContext().getString(paramInt3, new Object[] { paramInt1 + " + " + paramInt2 });
    p.j(localObject, "holder.context.getString… \"$preCount + $incCount\")");
    paramInt1 = n.a((CharSequence)localObject, '+', 0, false, 6);
    if ((paramInt1 > 0) && (paramInt1 + i < ((String)localObject).length()))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      parami = parami.getContext();
      p.j(parami, "holder.context");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parami.getResources().getColor(b.c.Red)), paramInt1, i + paramInt1, 17);
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(290038);
      return;
    }
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(290038);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(290035);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (TextView)parami.RD(b.f.real_name_recommend_nickname);
    parami = (TextView)parami.RD(b.f.real_name_recommend_desc);
    p.j(paramRecyclerView, "nicknameTv");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    p.j(parami, "descTv");
    ar.a((Paint)parami.getPaint(), 0.8F);
    AppMethodBeat.o(290035);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_like_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$2$3"})
  static final class a
    implements View.OnClickListener
  {
    a(au paramau, i parami, List paramList, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.cd.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283256);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = this.xhb.getContext();
      paramView = (View)localObject;
      if (!(localObject instanceof Activity)) {
        paramView = null;
      }
      paramView = (Activity)paramView;
      if (paramView != null) {}
      for (paramView = (FinderLikeDrawer)paramView.findViewById(b.f.finder_feed_friend_like_drawer);; paramView = null)
      {
        if (paramView != null) {
          paramView.a(this.xij.feedObject, this.xna);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(283256);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(au paramau, long paramLong, String paramString, com.tencent.mm.cd.b paramb, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282000);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = new Intent();
      ((Intent)localObject).putExtra("feed_object_id", this.xnb);
      ((Intent)localObject).putExtra("feed_object_nonceId", this.xnc);
      ((Intent)localObject).putExtra("key_show_jump_entry", false);
      paramView = this.xnd;
      if (paramView != null) {}
      for (paramView = paramView.toByteArray();; paramView = null)
      {
        ((Intent)localObject).putExtra("key_like_buffer", Util.encodeHexString(paramView));
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.tDl.getContext();
        p.j(paramView, "holder.context");
        com.tencent.mm.plugin.finder.utils.a.F(paramView, (Intent)localObject);
        Log.i(this.xmY.TAG, "go detail, jumpFeedId:" + this.xnb);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(282000);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.au
 * JD-Core Version:    0.7.0.1
 */