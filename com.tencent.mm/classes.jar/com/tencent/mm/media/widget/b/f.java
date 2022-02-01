package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.RenderScript;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "rs", "Landroid/renderscript/RenderScript;", "script", "Lcom/tencent/mm/ScriptC_ImageRenderScriptUtil;", "flipBitmap", "Landroid/graphics/Bitmap;", "bitmap", "isVertical", "", "newHeight", "", "angle", "newWidth", "release", "", "rotateBitmap", "yuv2Rgb", "data", "", "width", "height", "yuv2RgbWithCrop", "planes", "", "Landroid/media/Image$Plane;", "yuvBytes", "xOffset", "yOffset", "([Landroid/media/Image$Plane;[[BIIII)Landroid/graphics/Bitmap;", "Companion", "plugin-mediaeditor_release"})
public final class f
{
  public static final f.a huz;
  d hux;
  RenderScript huy;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(94179);
    huz = new f.a((byte)0);
    AppMethodBeat.o(94179);
  }
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(94178);
    this.mContext = paramContext;
    this.huy = RenderScript.create(this.mContext);
    this.hux = new d(this.huy);
    AppMethodBeat.o(94178);
  }
  
  private static int c(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94175);
    p.h(paramBitmap, "bitmap");
    if ((paramInt == 90) || (paramInt == 270))
    {
      paramInt = paramBitmap.getWidth();
      AppMethodBeat.o(94175);
      return paramInt;
    }
    paramInt = paramBitmap.getHeight();
    AppMethodBeat.o(94175);
    return paramInt;
  }
  
  private static int d(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94176);
    p.h(paramBitmap, "bitmap");
    if ((paramInt == 90) || (paramInt == 270))
    {
      paramInt = paramBitmap.getHeight();
      AppMethodBeat.o(94176);
      return paramInt;
    }
    paramInt = paramBitmap.getWidth();
    AppMethodBeat.o(94176);
    return paramInt;
  }
  
  public final Bitmap e(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94177);
    p.h(paramBitmap, "bitmap");
    if (paramInt == 0)
    {
      AppMethodBeat.o(94177);
      return paramBitmap;
    }
    Object localObject1 = this.hux;
    if (localObject1 != null) {
      ((d)localObject1).hg(paramBitmap.getWidth());
    }
    localObject1 = this.hux;
    if (localObject1 != null) {
      ((d)localObject1).hh(paramBitmap.getHeight());
    }
    localObject1 = Allocation.createFromBitmap(this.huy, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    paramBitmap.recycle();
    Object localObject2 = this.hux;
    if (localObject2 != null) {
      ((d)localObject2).a((Allocation)localObject1);
    }
    int i = c(paramBitmap, paramInt);
    paramBitmap = Bitmap.createBitmap(d(paramBitmap, paramInt), i, paramBitmap.getConfig());
    localObject2 = Allocation.createFromBitmap(this.huy, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((Allocation)localObject2).copyTo(paramBitmap);
      ((Allocation)localObject2).destroy();
      ((Allocation)localObject1).destroy();
      p.g(paramBitmap, "target");
      AppMethodBeat.o(94177);
      return paramBitmap;
      d locald = this.hux;
      if (locald != null)
      {
        locald.a((Allocation)localObject2, (Allocation)localObject2);
        continue;
        locald = this.hux;
        if (locald != null)
        {
          locald.d((Allocation)localObject2, (Allocation)localObject2);
          continue;
          locald = this.hux;
          if (locald != null) {
            locald.b((Allocation)localObject2, (Allocation)localObject2);
          }
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94174);
    ae.i("MicroMsg.RenderScriptImageHelper", "release rs script ");
    Object localObject = this.hux;
    if (localObject != null) {
      ((d)localObject).destroy();
    }
    localObject = this.huy;
    if (localObject != null)
    {
      ((RenderScript)localObject).destroy();
      AppMethodBeat.o(94174);
      return;
    }
    AppMethodBeat.o(94174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.f
 * JD-Core Version:    0.7.0.1
 */