package com.tencent.mm.live.model.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByBm", "", "bm", "blurRadius", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "genBlurBitmapByUsername", "username", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  private static final void A(kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(246815);
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(246815);
  }
  
  public static void a(Bitmap paramBitmap, int paramInt, float paramFloat, kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(246781);
    h.ahAA.bm(new a.a..ExternalSyntheticLambda0(paramBitmap, paramb, paramFloat, paramInt));
    AppMethodBeat.o(246781);
  }
  
  private static final void a(Bitmap paramBitmap, kotlin.g.a.b paramb, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(246820);
    if (paramBitmap == null)
    {
      if (paramb != null)
      {
        paramb.invoke(null);
        AppMethodBeat.o(246820);
      }
    }
    else {
      try
      {
        com.tencent.mm.videocomposition.effect.a locala = new com.tencent.mm.videocomposition.effect.a();
        locala.setInputBitmap(paramBitmap);
        locala.setOutputSize(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramBitmap = locala.HkF.GpO.jQj();
        paramBitmap.setRadius(paramFloat);
        paramBitmap.eC(5.0F);
        locala.aW((kotlin.g.a.b)new a.a.a(paramInt, paramb));
        AppMethodBeat.o(246820);
        return;
      }
      catch (Exception paramBitmap)
      {
        Log.e(a.access$getTAG$cp(), s.X("fastblur failed: ", paramBitmap.getMessage()));
        MMHandlerThread.postToMainThread(new a.a..ExternalSyntheticLambda2(paramb));
      }
    }
    AppMethodBeat.o(246820);
  }
  
  private static final void a(String paramString, kotlin.g.a.b paramb, int paramInt)
  {
    AppMethodBeat.i(246811);
    Object localObject;
    if (Util.isNullOrNil(paramString))
    {
      if (paramb != null)
      {
        paramb.invoke(null);
        AppMethodBeat.o(246811);
      }
    }
    else
    {
      localObject = a.b.iKa().loadBitmap(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = a.b.iKa().aCj();
      }
      if (paramString == null) {}
    }
    try
    {
      long l = Util.currentTicks();
      float f = aw.bf(MMApplicationContext.getContext()).y / aw.bf(MMApplicationContext.getContext()).x;
      int i = (int)(paramString.getHeight() / f);
      paramString = BitmapUtil.fastblur(BitmapUtil.extractThumbNail(paramString, paramString.getHeight(), i, true, false), 20);
      localObject = a.nbX;
      s.s(paramString, "blurBitmap");
      b(paramString, paramInt);
      c.hK(Util.ticksToNow(l));
      MMHandlerThread.postToMainThread(new a.a..ExternalSyntheticLambda5(paramb, paramString));
      MMHandlerThread.postToMainThread(new a.a..ExternalSyntheticLambda4(paramb));
      AppMethodBeat.o(246811);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(a.access$getTAG$cp(), s.X("fastblur failed: ", paramString.getMessage()));
        MMHandlerThread.postToMainThread(new a.a..ExternalSyntheticLambda3(paramb));
      }
    }
  }
  
  private static final void a(kotlin.g.a.b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(246796);
    if (paramb != null) {
      paramb.invoke(paramBitmap);
    }
    AppMethodBeat.o(246796);
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(246776);
    s.u(paramBitmap, "src");
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    Canvas localCanvas = new Canvas(paramBitmap);
    localPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawColor(paramInt);
    AppMethodBeat.o(246776);
    return paramBitmap;
  }
  
  public static void b(String paramString, int paramInt, kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(246766);
    h.ahAA.bm(new a.a..ExternalSyntheticLambda1(paramString, paramb, paramInt));
    AppMethodBeat.o(246766);
  }
  
  private static final void y(kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(246801);
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(246801);
  }
  
  private static final void z(kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(246803);
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(246803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.model.d.a.a
 * JD-Core Version:    0.7.0.1
 */