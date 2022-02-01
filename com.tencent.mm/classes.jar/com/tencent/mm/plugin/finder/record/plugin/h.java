package com.tencent.mm.plugin.finder.record.plugin;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.fxr;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/TemplateHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bg", "kotlin.jvm.PlatformType", "image", "Landroid/widget/ImageView;", "loading", "Landroid/widget/ProgressBar;", "template", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "loadItem", "", "onClick", "Lkotlin/Function1;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends RecyclerView.v
{
  private final View EJx;
  private final ImageView Fjt;
  private fxr Fju;
  private final ProgressBar sIX;
  
  public h(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(336993);
    this.Fjt = ((ImageView)paramView.findViewById(l.e.Fif));
    this.sIX = ((ProgressBar)paramView.findViewById(l.e.loading));
    this.EJx = paramView.findViewById(l.e.Fia);
    AppMethodBeat.o(336993);
  }
  
  private static final void p(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(337003);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/record/plugin/TemplateHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$onClick");
    s.s(paramView, "it");
    paramb.invoke(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/record/plugin/TemplateHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(337003);
  }
  
  public final void a(fxr paramfxr, kotlin.g.a.b<? super View, ah> paramb)
  {
    AppMethodBeat.i(337020);
    s.u(paramfxr, "template");
    s.u(paramb, "onClick");
    this.Fju = paramfxr;
    View localView = this.EJx;
    if (s.p(paramfxr.id, "empty")) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      r.bKe().a(paramfxr.abVq.ZmV, this.Fjt, (com.tencent.mm.modelimage.loader.b.h)new a(this));
      if (s.p(paramfxr.id, "loading")) {
        break;
      }
      this.caK.setOnClickListener(new h..ExternalSyntheticLambda0(paramb));
      AppMethodBeat.o(337020);
      return;
    }
    this.sIX.setVisibility(0);
    AppMethodBeat.o(337020);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/record/plugin/TemplateHolder$loadItem$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.modelimage.loader.b.h
  {
    a(h paramh) {}
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
    {
      return null;
    }
    
    public final void b(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
    {
      AppMethodBeat.i(337010);
      d.uiThread((kotlin.g.a.a)new a(this.Fjv));
      AppMethodBeat.o(337010);
    }
    
    public final void c(String paramString, View paramView)
    {
      AppMethodBeat.i(336992);
      d.uiThread((kotlin.g.a.a)new b(this.Fjv));
      AppMethodBeat.o(336992);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(h paramh)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(h paramh)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.h
 * JD-Core Version:    0.7.0.1
 */