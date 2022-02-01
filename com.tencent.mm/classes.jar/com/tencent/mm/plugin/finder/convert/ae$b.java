package com.tencent.mm.plugin.finder.convert;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class ae$b
  implements View.OnClickListener
{
  ae$b(ae paramae, long paramLong, String paramString, com.tencent.mm.bw.b paramb, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201871);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    localObject = new Intent();
    ((Intent)localObject).putExtra("feed_object_id", this.rXv);
    ((Intent)localObject).putExtra("feed_object_nonceId", this.rXw);
    ((Intent)localObject).putExtra("key_show_jump_entry", false);
    paramView = this.rXx;
    if (paramView != null) {}
    for (paramView = paramView.toByteArray();; paramView = null)
    {
      ((Intent)localObject).putExtra("key_like_buffer", bu.cH(paramView));
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = this.oTF.getContext();
      p.g(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.D(paramView, (Intent)localObject);
      com.tencent.mm.sdk.platformtools.ae.i(this.rXs.TAG, "go detail, jumpFeedId:" + this.rXv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201871);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ae.b
 * JD-Core Version:    0.7.0.1
 */