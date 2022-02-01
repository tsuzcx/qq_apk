package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.e;
import com.tencent.mm.danmaku.render.h;
import com.tencent.mm.danmaku.render.h.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.protocal.protobuf.cwa;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getItemViewType", "", "danmakuData", "", "onBindViewHolder", "", "itemViewType", "viewHolder", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "danmaku", "Lcom/tencent/mm/danmaku/data/ViewDanmaku;", "onCreateViewHolder", "TextViewHolder", "plugin-finder_release"})
public final class d
  extends h
{
  private final Context context;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(282799);
    this.context = paramContext;
    AppMethodBeat.o(282799);
  }
  
  public final void a(h.a parama, e parame)
  {
    AppMethodBeat.i(282798);
    p.k(parama, "viewHolder");
    p.k(parame, "danmaku");
    parame = parame.getData();
    if (parame == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoBulletCommentInfo");
      AppMethodBeat.o(282798);
      throw parama;
    }
    Object localObject = (cwa)parame;
    parame = ((a)parama).zvR;
    parama = ((cwa)localObject).content;
    Context localContext = parame.getContext();
    p.j(localContext, "context");
    int i = localContext.getResources().getColor(b.c.BW_100_Alpha_0_8);
    if ((((cwa)localObject).extFlag & 0x1) != 0)
    {
      parama = new StringBuilder();
      localContext = parame.getContext();
      p.j(localContext, "context");
      parama = localContext.getResources().getString(b.j.mega_video_bullet_self_header) + ((cwa)localObject).content;
      localObject = parame.getContext();
      p.j(localObject, "context");
      i = ((Context)localObject).getResources().getColor(b.c.mega_video_bullet_self_prefix_color);
    }
    for (;;)
    {
      parame.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(parame.getContext(), (CharSequence)parama));
      parame.setTextColor(i);
      AppMethodBeat.o(282798);
      return;
      if ((((cwa)localObject).extFlag & 0x2) != 0)
      {
        parama = new StringBuilder();
        localContext = parame.getContext();
        p.j(localContext, "context");
        parama = localContext.getResources().getString(b.j.mega_video_bullet_finder_header) + ((cwa)localObject).content;
        localObject = parame.getContext();
        p.j(localObject, "context");
        i = ((Context)localObject).getResources().getColor(b.c.finder_bullet_subtitle_prefix);
      }
    }
  }
  
  public final h.a azV()
  {
    AppMethodBeat.i(282796);
    Object localObject = LayoutInflater.from(this.context).inflate(b.g.mega_video_mega_bullet_layout, null);
    p.j(localObject, "LayoutInflater.from(cont…mega_bullet_layout, null)");
    localObject = (h.a)new a((View)localObject);
    AppMethodBeat.o(282796);
    return localObject;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender$TextViewHolder;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender;Landroid/view/View;)V", "bulletTv", "Landroid/widget/TextView;", "getBulletTv", "()Landroid/widget/TextView;", "getItemView", "()Landroid/view/View;", "plugin-finder_release"})
  public final class a
    extends h.a
  {
    private final View amk;
    final TextView zvR;
    
    public a()
    {
      super();
      AppMethodBeat.i(288707);
      this.amk = localObject;
      this$1 = this.amk.findViewById(b.f.bullet_tv);
      p.j(d.this, "itemView.findViewById(R.id.bullet_tv)");
      this.zvR = ((TextView)d.this);
      AppMethodBeat.o(288707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.d
 * JD-Core Version:    0.7.0.1
 */