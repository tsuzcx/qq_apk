package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.RenderScript;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "rs", "Landroid/renderscript/RenderScript;", "script", "Lcom/tencent/mm/ScriptC_ImageRenderScriptUtil;", "checkRS", "", "finalize", "flipBitmap", "Landroid/graphics/Bitmap;", "bitmap", "isVertical", "", "newHeight", "", "angle", "newWidth", "release", "rotateBitmap", "yuv2Rgb", "data", "", "width", "height", "yuv2RgbWithCrop", "planes", "", "Landroid/media/Image$Plane;", "yuvBytes", "xOffset", "yOffset", "([Landroid/media/Image$Plane;[[BIIII)Landroid/graphics/Bitmap;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a nHQ;
  private Context mContext;
  d nHR;
  RenderScript nHS;
  
  static
  {
    AppMethodBeat.i(94179);
    nHQ = new e.a((byte)0);
    AppMethodBeat.o(94179);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(94178);
    this.mContext = paramContext;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptImageHelper", s.X("rs create: ", this));
    if (BuildInfo.DEBUG) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptImageHelper", "rs create: %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    }
    this.nHS = RenderScript.create(this.mContext);
    this.nHR = new d(this.nHS);
    AppMethodBeat.o(94178);
  }
  
  private static int d(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94175);
    s.u(paramBitmap, "bitmap");
    switch (paramInt)
    {
    default: 
      paramInt = paramBitmap.getHeight();
      AppMethodBeat.o(94175);
      return paramInt;
    }
    paramInt = paramBitmap.getWidth();
    AppMethodBeat.o(94175);
    return paramInt;
  }
  
  private static int e(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94176);
    s.u(paramBitmap, "bitmap");
    switch (paramInt)
    {
    default: 
      paramInt = paramBitmap.getWidth();
      AppMethodBeat.o(94176);
      return paramInt;
    }
    paramInt = paramBitmap.getHeight();
    AppMethodBeat.o(94176);
    return paramInt;
  }
  
  final void btC()
  {
    AppMethodBeat.i(237554);
    if (this.nHS == null)
    {
      NullPointerException localNullPointerException = new NullPointerException(s.X("RenderScript has been destroyed!!! ", this));
      AppMethodBeat.o(237554);
      throw localNullPointerException;
    }
    AppMethodBeat.o(237554);
  }
  
  public final Bitmap f(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(94177);
    s.u(paramBitmap, "bitmap");
    btC();
    if (paramInt == 0)
    {
      AppMethodBeat.o(94177);
      return paramBitmap;
    }
    Object localObject1 = this.nHR;
    if (localObject1 != null) {
      ((d)localObject1).nC(paramBitmap.getWidth());
    }
    localObject1 = this.nHR;
    if (localObject1 != null) {
      ((d)localObject1).nD(paramBitmap.getHeight());
    }
    localObject1 = Allocation.createFromBitmap(this.nHS, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    paramBitmap.recycle();
    Object localObject2 = this.nHR;
    if (localObject2 != null) {
      ((d)localObject2).a((Allocation)localObject1);
    }
    int i = d(paramBitmap, paramInt);
    paramBitmap = Bitmap.createBitmap(e(paramBitmap, paramInt), i, paramBitmap.getConfig());
    localObject2 = Allocation.createFromBitmap(this.nHS, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((Allocation)localObject2).copyTo(paramBitmap);
      ((Allocation)localObject2).destroy();
      ((Allocation)localObject1).destroy();
      s.s(paramBitmap, "target");
      AppMethodBeat.o(94177);
      return paramBitmap;
      d locald = this.nHR;
      if (locald != null)
      {
        locald.a((Allocation)localObject2, (Allocation)localObject2);
        continue;
        locald = this.nHR;
        if (locald != null)
        {
          locald.d((Allocation)localObject2, (Allocation)localObject2);
          continue;
          locald = this.nHR;
          if (locald != null) {
            locald.b((Allocation)localObject2, (Allocation)localObject2);
          }
        }
      }
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(237549);
    com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.RenderScriptImageHelper", "finalize");
    RenderScript localRenderScript = this.nHS;
    if (localRenderScript != null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptImageHelper", s.X("RS leak warning: maybe you forget to call destroy!!! ", this));
      if (Build.VERSION.SDK_INT < 23)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptImageHelper", "help destroy RenderScript");
        localRenderScript.destroy();
        this.nHS = null;
      }
    }
    AppMethodBeat.o(237549);
  }
  
  public final void release()
  {
    ah localah = null;
    AppMethodBeat.i(94174);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptImageHelper", s.X("release rs script ", this));
    Object localObject = this.nHR;
    if (localObject != null) {
      ((d)localObject).destroy();
    }
    localObject = this.nHS;
    if (localObject == null) {}
    for (;;)
    {
      if (localah == null) {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.RenderScriptImageHelper", s.X("rs has already been destroyed!!! ", (e)this));
      }
      AppMethodBeat.o(94174);
      return;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.RenderScriptImageHelper", "rs destroy");
      ((RenderScript)localObject).destroy();
      this.nHS = null;
      localah = ah.aiuX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */