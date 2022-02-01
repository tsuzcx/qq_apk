package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ab;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;
import java.util.Iterator;

@l(gjZ={1, 1, 13}, gka={""}, gkb={"Lcom/tencent/magicbrush/ui/MagicBrushView$Companion;", "", "()V", "DEFAULT_VIEW_TYPE", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "TAG", "", "touchEventHandler", "Lcom/tencent/magicbrush/handler/JsTouchEventHandler;", "checkAnimationHandler", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "viewType", "checkViewTypeValid", "createRendererViewByViewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "context", "Landroid/content/Context;", "getRendererViewOrDefault", "view", "attr", "Landroid/util/AttributeSet;", "getViewTypeByAttributeSet", "getVirtualElementByAttributeSet", "", "(Landroid/util/AttributeSet;)Ljava/lang/Integer;", "getVirtualElementIdOrZero", "virtualElementId", "(Ljava/lang/Integer;Landroid/util/AttributeSet;)I", "tryReconfigureBitmapIfNeed", "Landroid/graphics/Bitmap;", "bitmap", "width", "height", "lib-magicbrush-nano_release"})
public final class MagicBrushView$a
{
  static MagicBrushView.b a(Context paramContext, MagicBrushView.h paramh)
  {
    AppMethodBeat.i(140250);
    switch (i.cqt[paramh.ordinal()])
    {
    default: 
      paramContext = (Throwable)new Exception("invalid viewType");
      AppMethodBeat.o(140250);
      throw paramContext;
    case 1: 
      paramContext = (MagicBrushView.b)new g(paramContext);
      AppMethodBeat.o(140250);
      return paramContext;
    }
    paramContext = (MagicBrushView.b)new h(paramContext);
    AppMethodBeat.o(140250);
    return paramContext;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140251);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(140251);
      return null;
    }
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      AppMethodBeat.o(140251);
      return paramBitmap;
    }
    try
    {
      paramBitmap.reconfigure(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      AppMethodBeat.o(140251);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      AppMethodBeat.o(140251);
    }
    return null;
  }
  
  static MagicBrushView.h g(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(140249);
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramAttributeSet != null)
    {
      Iterator localIterator = ((Iterable)j.lv(0, paramAttributeSet.getAttributeCount())).iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        int i = ((ab)localIterator).nextInt();
        if (!p.i("viewType", paramAttributeSet.getAttributeName(i))) {
          break label192;
        }
        localObject1 = paramAttributeSet.getAttributeValue(i);
        localObject2 = MagicBrushView.cAV;
        p.g(localObject1, "viewTypeName");
        if ((p.i(localObject1, "SurfaceView")) || (p.i(localObject1, "TextureView"))) {}
        for (i = 1; i == 0; i = 0)
        {
          paramAttributeSet = String.format("ViewType must be [SurfaceView|TextureView], but is [%s]", Arrays.copyOf(new Object[] { localObject1 }, 1));
          p.g(paramAttributeSet, "java.lang.String.format(this, *args)");
          paramAttributeSet = (Throwable)new IllegalStateException(paramAttributeSet.toString());
          AppMethodBeat.o(140249);
          throw paramAttributeSet;
        }
        if (p.i(localObject1, "SurfaceView")) {
          localObject1 = MagicBrushView.h.cAW;
        }
      }
    }
    label192:
    for (;;)
    {
      break;
      localObject1 = MagicBrushView.h.cAX;
      continue;
      AppMethodBeat.o(140249);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.ui.MagicBrushView.a
 * JD-Core Version:    0.7.0.1
 */