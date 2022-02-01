package com.tencent.mm.plugin.finder.convert;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class as$b
  implements View.OnClickListener
{
  as$b(as paramas, long paramLong, String paramString, com.tencent.mm.bw.b paramb, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(243151);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = new Intent();
    ((Intent)localObject).putExtra("feed_object_id", this.tEz);
    ((Intent)localObject).putExtra("feed_object_nonceId", this.tEA);
    ((Intent)localObject).putExtra("key_show_jump_entry", false);
    paramView = this.tEB;
    if (paramView != null) {}
    for (paramView = paramView.toByteArray();; paramView = null)
    {
      ((Intent)localObject).putExtra("key_like_buffer", Util.encodeHexString(paramView));
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = this.qhp.getContext();
      p.g(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.G(paramView, (Intent)localObject);
      Log.i(this.tEw.TAG, "go detail, jumpFeedId:" + this.tEz);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243151);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.as.b
 * JD-Core Version:    0.7.0.1
 */