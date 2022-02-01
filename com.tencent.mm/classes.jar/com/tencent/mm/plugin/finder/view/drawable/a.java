package com.tencent.mm.plugin.finder.view.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/drawable/UrlBitmapDrawable;", "Landroid/graphics/drawable/Drawable;", "url", "", "id", "", "view", "Landroid/view/View;", "(Ljava/lang/String;ILandroid/view/View;)V", "TAG", "bitmap", "Landroid/graphics/Bitmap;", "getId", "()I", "viewRef", "Ljava/lang/ref/WeakReference;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends Drawable
{
  private final String TAG;
  private Bitmap bitmap;
  private final int id;
  private final String url;
  private final WeakReference<View> viewRef;
  
  public a(String paramString, int paramInt, View paramView)
  {
    AppMethodBeat.i(344814);
    this.url = paramString;
    this.id = paramInt;
    this.TAG = "Finder.UrlBitmapDrawable";
    this.viewRef = new WeakReference(paramView);
    if (paramView != null) {
      paramView.setTag(this.id, this.url);
    }
    AppMethodBeat.o(344814);
  }
  
  private static final void a(a parama1, a parama2, com.tencent.mm.loader.g.a.a parama, g paramg, final Bitmap paramBitmap)
  {
    paramg = null;
    AppMethodBeat.i(344828);
    kotlin.g.b.s.u(parama1, "$this_run");
    kotlin.g.b.s.u(parama2, "this$0");
    if (paramBitmap != null)
    {
      int i;
      if (!paramBitmap.isRecycled())
      {
        i = 1;
        if (i == 0) {
          break label173;
        }
        label40:
        if (paramBitmap == null) {
          break label262;
        }
        String str = parama1.TAG;
        StringBuilder localStringBuilder = new StringBuilder("loaded, view:");
        parama = (View)parama1.viewRef.get();
        if (parama != null) {
          break label179;
        }
        parama = null;
        label79:
        Log.i(str, parama + ", " + parama2.url);
        parama = (View)parama1.viewRef.get();
        if (parama != null) {
          break label190;
        }
        parama = null;
        label122:
        if (!(parama instanceof String)) {
          break label202;
        }
      }
      label173:
      label179:
      label190:
      label202:
      for (parama = (String)parama;; parama = null)
      {
        if (!kotlin.g.b.s.p(parama2.url, parama)) {
          break label207;
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(parama1, paramBitmap));
        AppMethodBeat.o(344828);
        return;
        i = 0;
        break;
        paramBitmap = null;
        break label40;
        parama = Integer.valueOf(parama.hashCode());
        break label79;
        parama = parama.getTag(parama1.id);
        break label122;
      }
      label207:
      parama2 = parama1.TAG;
      paramBitmap = new StringBuilder("loaded not match, view:");
      parama1 = (View)parama1.viewRef.get();
      if (parama1 != null) {
        break label268;
      }
    }
    label262:
    label268:
    for (parama1 = paramg;; parama1 = Integer.valueOf(parama1.hashCode()))
    {
      Log.i(parama2, parama1 + ", lastUrl:" + parama);
      AppMethodBeat.o(344828);
      return;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    com.tencent.mm.plugin.finder.loader.s locals = null;
    AppMethodBeat.i(344882);
    kotlin.g.b.s.u(paramCanvas, "canvas");
    Object localObject1 = this.bitmap;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      paramCanvas = null;
      if (paramCanvas == null)
      {
        localObject1 = (a)this;
        localObject2 = ((a)localObject1).TAG;
        localStringBuilder = new StringBuilder("start load, view:");
        paramCanvas = (View)((a)localObject1).viewRef.get();
        if (paramCanvas != null) {
          break label260;
        }
      }
    }
    label260:
    for (paramCanvas = locals;; paramCanvas = Integer.valueOf(paramCanvas.hashCode()))
    {
      Log.i((String)localObject2, paramCanvas + ", " + ((a)localObject1).url);
      paramCanvas = p.ExI;
      paramCanvas = p.eCl();
      locals = new com.tencent.mm.plugin.finder.loader.s(((a)localObject1).url, v.FKY);
      localObject2 = p.ExI;
      paramCanvas.a(locals, p.a(p.a.ExS)).a(new a..ExternalSyntheticLambda0((a)localObject1, this)).blg();
      AppMethodBeat.o(344882);
      return;
      paramCanvas.drawBitmap((Bitmap)localObject1, null, getBounds(), new Paint());
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("draw, view:");
      paramCanvas = (View)this.viewRef.get();
      if (paramCanvas == null) {}
      for (paramCanvas = null;; paramCanvas = Integer.valueOf(paramCanvas.hashCode()))
      {
        Log.i((String)localObject1, paramCanvas + ", rect:" + getBounds() + ", " + this.url);
        paramCanvas = ah.aiuX;
        break;
      }
    }
  }
  
  public final int getOpacity()
  {
    return -1;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.drawable.a
 * JD-Core Version:    0.7.0.1
 */