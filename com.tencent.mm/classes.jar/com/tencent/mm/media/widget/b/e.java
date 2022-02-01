package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.RenderScript;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "rs", "Landroid/renderscript/RenderScript;", "script", "Lcom/tencent/mm/ScriptC_ImageRenderScriptUtil;", "checkRS", "", "finalize", "flipBitmap", "Landroid/graphics/Bitmap;", "bitmap", "isVertical", "", "newHeight", "", "angle", "newWidth", "release", "rotateBitmap", "yuv2Rgb", "data", "", "width", "height", "yuv2RgbWithCrop", "planes", "", "Landroid/media/Image$Plane;", "yuvBytes", "xOffset", "yOffset", "([Landroid/media/Image$Plane;[[BIIII)Landroid/graphics/Bitmap;", "Companion", "plugin-mediaeditor_release"})
public final class e
{
  public static final e.a ldf;
  c ldd;
  RenderScript lde;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(94179);
    ldf = new e.a((byte)0);
    AppMethodBeat.o(94179);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(94178);
    this.mContext = paramContext;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptImageHelper", "rs create: ".concat(String.valueOf(this)));
    if (BuildInfo.DEBUG) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptImageHelper", "rs create: %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    this.lde = RenderScript.create(this.mContext);
    this.ldd = new c(this.lde);
    AppMethodBeat.o(94178);
  }
  
  private static int e(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94175);
    p.k(paramBitmap, "bitmap");
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
  
  private static int f(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94176);
    p.k(paramBitmap, "bitmap");
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
  
  final void aYD()
  {
    AppMethodBeat.i(258822);
    if (this.lde == null)
    {
      Throwable localThrowable = (Throwable)new NullPointerException("RenderScript has been destroyed!!! ".concat(String.valueOf(this)));
      AppMethodBeat.o(258822);
      throw localThrowable;
    }
    AppMethodBeat.o(258822);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(258820);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptImageHelper", "finalize");
    RenderScript localRenderScript = this.lde;
    if (localRenderScript != null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptImageHelper", "RS leak warning: maybe you forget to call destroy!!! ".concat(String.valueOf(this)));
      if (Build.VERSION.SDK_INT < 23)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptImageHelper", "help destroy RenderScript");
        localRenderScript.destroy();
        this.lde = null;
      }
      AppMethodBeat.o(258820);
      return;
    }
    AppMethodBeat.o(258820);
  }
  
  public final Bitmap g(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94177);
    p.k(paramBitmap, "bitmap");
    aYD();
    if (paramInt == 0)
    {
      AppMethodBeat.o(94177);
      return paramBitmap;
    }
    Object localObject1 = this.ldd;
    if (localObject1 != null) {
      ((c)localObject1).jM(paramBitmap.getWidth());
    }
    localObject1 = this.ldd;
    if (localObject1 != null) {
      ((c)localObject1).jN(paramBitmap.getHeight());
    }
    localObject1 = Allocation.createFromBitmap(this.lde, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    paramBitmap.recycle();
    Object localObject2 = this.ldd;
    if (localObject2 != null) {
      ((c)localObject2).a((Allocation)localObject1);
    }
    int i = e(paramBitmap, paramInt);
    paramBitmap = Bitmap.createBitmap(f(paramBitmap, paramInt), i, paramBitmap.getConfig());
    localObject2 = Allocation.createFromBitmap(this.lde, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((Allocation)localObject2).copyTo(paramBitmap);
      ((Allocation)localObject2).destroy();
      ((Allocation)localObject1).destroy();
      p.j(paramBitmap, "target");
      AppMethodBeat.o(94177);
      return paramBitmap;
      c localc = this.ldd;
      if (localc != null)
      {
        localc.a((Allocation)localObject2, (Allocation)localObject2);
        continue;
        localc = this.ldd;
        if (localc != null)
        {
          localc.d((Allocation)localObject2, (Allocation)localObject2);
          continue;
          localc = this.ldd;
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptImageHelper", "release rs script ".concat(String.valueOf(this)));
    Object localObject = this.ldd;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    localObject = this.lde;
    if (localObject != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptImageHelper", "rs destroy");
      ((RenderScript)localObject).destroy();
      this.lde = null;
      AppMethodBeat.o(94174);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptImageHelper", "rs has already been destroyed!!! ".concat(String.valueOf((e)this)));
    AppMethodBeat.o(94174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */