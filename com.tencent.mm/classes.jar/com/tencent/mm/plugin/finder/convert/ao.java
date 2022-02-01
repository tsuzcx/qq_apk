package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "TAG", "", "formatDesc", "", "preCount", "", "incCount", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "id", "descTv", "Landroid/widget/TextView;", "getLayoutId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends f<BaseFinderFeed>
{
  private final String TAG = "Finder.FinderLikeConvert";
  
  private static void a(int paramInt1, int paramInt2, j paramj, int paramInt3, TextView paramTextView)
  {
    AppMethodBeat.i(350201);
    Object localObject = paramInt1 + " + " + paramInt2;
    int i = ((String)localObject).length() - n.a((CharSequence)localObject, '+', 0, false, 6);
    localObject = paramj.context.getString(paramInt3, new Object[] { paramInt1 + " + " + paramInt2 });
    s.s(localObject, "holder.context.getString… \"$preCount + $incCount\")");
    paramInt1 = n.a((CharSequence)localObject, '+', 0, false, 6);
    if ((paramInt1 > 0) && (paramInt1 + i < ((String)localObject).length()))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramj.context.getResources().getColor(e.b.Red)), paramInt1, i + paramInt1, 17);
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(350201);
      return;
    }
    paramTextView.setText((CharSequence)localObject);
    AppMethodBeat.o(350201);
  }
  
  private static final void a(long paramLong, String paramString, com.tencent.mm.bx.b paramb, j paramj, ao paramao, View paramView)
  {
    AppMethodBeat.i(350217);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.hB(paramLong);
    localb.cH(paramString);
    localb.cH(paramb);
    localb.cH(paramj);
    localb.cH(paramao);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramString, "$jumpNonceId");
    s.u(paramj, "$holder");
    s.u(paramao, "this$0");
    paramView = new Intent();
    paramView.putExtra("feed_object_id", paramLong);
    paramView.putExtra("feed_object_nonceId", paramString);
    paramView.putExtra("key_show_jump_entry", false);
    if (paramb == null) {}
    for (paramString = null;; paramString = paramb.toByteArray())
    {
      paramView.putExtra("key_like_buffer", Util.encodeHexString(paramString));
      paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramString = paramj.context;
      s.s(paramString, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.Z(paramString, paramView);
      Log.i(paramao.TAG, s.X("go detail, jumpFeedId:", Long.valueOf(paramLong)));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350217);
      return;
    }
  }
  
  private static final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.bx.b paramb, View paramView)
  {
    AppMethodBeat.i(350208);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramBaseFinderFeed);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "$holder");
    s.u(paramBaseFinderFeed, "$item");
    paramj = paramj.context;
    if ((paramj instanceof Activity))
    {
      paramj = (Activity)paramj;
      if (paramj != null) {
        break label145;
      }
    }
    label145:
    for (paramj = null;; paramj = (FinderLikeDrawer)paramj.findViewById(e.e.finder_feed_friend_like_drawer))
    {
      if (paramj != null) {
        paramj.a(paramBaseFinderFeed.feedObject, paramb);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderLikeConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350208);
      return;
      paramj = null;
      break;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350233);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = (TextView)paramj.UH(e.e.real_name_recommend_nickname);
    paramj = (TextView)paramj.UH(e.e.real_name_recommend_desc);
    aw.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    aw.a((Paint)paramj.getPaint(), 0.8F);
    AppMethodBeat.o(350233);
  }
  
  public final int getLayoutId()
  {
    return e.f._finder_feed_like_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ao
 * JD-Core Version:    0.7.0.1
 */