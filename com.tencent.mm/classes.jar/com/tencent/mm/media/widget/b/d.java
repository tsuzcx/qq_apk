package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.RenderScript;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "rs", "Landroid/renderscript/RenderScript;", "script", "Lcom/tencent/mm/ScriptC_ImageRenderScriptUtil;", "flipBitmap", "Landroid/graphics/Bitmap;", "bitmap", "isVertical", "", "newHeight", "", "angle", "newWidth", "release", "", "rotateBitmap", "yuv2Rgb", "data", "", "width", "height", "yuv2RgbWithCrop", "planes", "", "Landroid/media/Image$Plane;", "yuvBytes", "xOffset", "yOffset", "([Landroid/media/Image$Plane;[[BIIII)Landroid/graphics/Bitmap;", "Companion", "plugin-mediaeditor_release"})
public final class d
{
  public static final d.a ioa;
  c inY;
  RenderScript inZ;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(94179);
    ioa = new d.a((byte)0);
    AppMethodBeat.o(94179);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(94178);
    this.mContext = paramContext;
    this.inZ = RenderScript.create(this.mContext);
    this.inY = new c(this.inZ);
    AppMethodBeat.o(94178);
  }
  
  private static int d(Bitmap paramBitmap, int paramInt)
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
  
  private static int e(Bitmap paramBitmap, int paramInt)
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
  
  public final Bitmap f(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94177);
    p.h(paramBitmap, "bitmap");
    if (paramInt == 0)
    {
      AppMethodBeat.o(94177);
      return paramBitmap;
    }
    Object localObject1 = this.inY;
    if (localObject1 != null) {
      ((c)localObject1).iA(paramBitmap.getWidth());
    }
    localObject1 = this.inY;
    if (localObject1 != null) {
      ((c)localObject1).iB(paramBitmap.getHeight());
    }
    localObject1 = Allocation.createFromBitmap(this.inZ, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    paramBitmap.recycle();
    Object localObject2 = this.inY;
    if (localObject2 != null) {
      ((c)localObject2).a((Allocation)localObject1);
    }
    int i = d(paramBitmap, paramInt);
    paramBitmap = Bitmap.createBitmap(e(paramBitmap, paramInt), i, paramBitmap.getConfig());
    localObject2 = Allocation.createFromBitmap(this.inZ, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
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
      c localc = this.inY;
      if (localc != null)
      {
        localc.a((Allocation)localObject2, (Allocation)localObject2);
        continue;
        localc = this.inY;
        if (localc != null)
        {
          localc.d((Allocation)localObject2, (Allocation)localObject2);
          continue;
          localc = this.inY;
          if (localc != null) {
            localc.b((Allocation)localObject2, (Allocation)localObject2);
          }
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(94174);
    Log.i("MicroMsg.RenderScriptImageHelper", "release rs script ");
    Object localObject = this.inY;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    localObject = this.inZ;
    if (localObject != null)
    {
      ((RenderScript)localObject).destroy();
      AppMethodBeat.o(94174);
      return;
    }
    AppMethodBeat.o(94174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */