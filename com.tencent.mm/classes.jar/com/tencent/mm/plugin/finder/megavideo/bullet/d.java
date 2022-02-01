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
import com.tencent.mm.protocal.protobuf.cni;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getItemViewType", "", "danmakuData", "", "onBindViewHolder", "", "itemViewType", "viewHolder", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "danmaku", "Lcom/tencent/mm/danmaku/data/ViewDanmaku;", "onCreateViewHolder", "TextViewHolder", "plugin-finder_release"})
public final class d
  extends h
{
  private final Context context;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(248281);
    this.context = paramContext;
    AppMethodBeat.o(248281);
  }
  
  public final void a(h.a parama, e parame)
  {
    AppMethodBeat.i(248280);
    p.h(parama, "viewHolder");
    p.h(parame, "danmaku");
    parame = parame.getData();
    if (parame == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoBulletCommentInfo");
      AppMethodBeat.o(248280);
      throw parama;
    }
    Object localObject = (cni)parame;
    parame = ((a)parama).uKi;
    parama = ((cni)localObject).content;
    Context localContext = parame.getContext();
    p.g(localContext, "context");
    int i = localContext.getResources().getColor(2131099679);
    if ((((cni)localObject).extFlag & 0x1) != 0)
    {
      parama = new StringBuilder();
      localContext = parame.getContext();
      p.g(localContext, "context");
      parama = localContext.getResources().getString(2131763008) + ((cni)localObject).content;
      localObject = parame.getContext();
      p.g(localObject, "context");
      i = ((Context)localObject).getResources().getColor(2131100801);
    }
    for (;;)
    {
      parame.setText((CharSequence)parama);
      parame.setTextColor(i);
      AppMethodBeat.o(248280);
      return;
      if ((((cni)localObject).extFlag & 0x2) != 0)
      {
        parama = new StringBuilder();
        localContext = parame.getContext();
        p.g(localContext, "context");
        parama = localContext.getResources().getString(2131763004) + ((cni)localObject).content;
        localObject = parame.getContext();
        p.g(localObject, "context");
        i = ((Context)localObject).getResources().getColor(2131100412);
      }
    }
  }
  
  public final h.a atg()
  {
    AppMethodBeat.i(248279);
    Object localObject = LayoutInflater.from(this.context).inflate(2131495479, null);
    p.g(localObject, "LayoutInflater.from(cont…mega_bullet_layout, null)");
    localObject = (h.a)new a((View)localObject);
    AppMethodBeat.o(248279);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender$TextViewHolder;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmakuRender;Landroid/view/View;)V", "bulletTv", "Landroid/widget/TextView;", "getBulletTv", "()Landroid/widget/TextView;", "getItemView", "()Landroid/view/View;", "plugin-finder_release"})
  public final class a
    extends h.a
  {
    private final View aus;
    final TextView uKi;
    
    public a()
    {
      super();
      AppMethodBeat.i(248278);
      this.aus = localObject;
      this$1 = this.aus.findViewById(2131297862);
      p.g(d.this, "itemView.findViewById(R.id.bullet_tv)");
      this.uKi = ((TextView)d.this);
      AppMethodBeat.o(248278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.d
 * JD-Core Version:    0.7.0.1
 */