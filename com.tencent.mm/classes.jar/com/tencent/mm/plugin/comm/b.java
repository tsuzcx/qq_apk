package com.tencent.mm.plugin.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.blur.f;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/comm/MusicMvUIUtil;", "", "()V", "TAG", "", "addGradientDrawableToBitmap", "Landroid/graphics/Bitmap;", "isDarkMode", "", "bm", "calcAndUpdateBlurBm", "", "context", "Landroid/content/Context;", "container", "Landroid/view/View;", "bitmap", "md5Key", "targetWidth", "", "targetHeight", "updateBlurBmBackground", "plugin-comm_release"})
public final class b
{
  public static final b qCp;
  
  static
  {
    AppMethodBeat.i(223471);
    qCp = new b();
    AppMethodBeat.o(223471);
  }
  
  @SuppressLint({"WrongConstant"})
  public static Bitmap a(boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(223469);
    p.h(paramBitmap, "bm");
    Log.e("MicroMsg.Mv.MusicMvUIUtil", "addGradientDrawableToBitmap, start ");
    long l = System.currentTimeMillis();
    Object localObject = new int[2];
    Object tmp29_27 = localObject;
    tmp29_27[0] = -1711802377;
    Object tmp34_29 = tmp29_27;
    tmp34_29[1] = -134744073;
    tmp34_29;
    if (paramBoolean)
    {
      localObject = new int[2];
      Object tmp51_49 = localObject;
      tmp51_49[0] = -1289542877;
      Object tmp56_51 = tmp51_49;
      tmp56_51[1] = -232578269;
      tmp56_51;
    }
    tmp51_49 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, (int[])tmp51_49);
    ((GradientDrawable)tmp51_49).setGradientType(0);
    ((GradientDrawable)tmp51_49).setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    ((GradientDrawable)tmp51_49).draw(new Canvas(paramBitmap));
    tmp51_49 = ae.SYK;
    tmp51_49 = String.format(" addGradientDrawableToBitmap end, cost:%d", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis() - l) }, 1));
    p.g(tmp51_49, "java.lang.String.format(format, *args)");
    Log.e("MicroMsg.Mv.MusicMvUIUtil", (String)tmp51_49);
    AppMethodBeat.o(223469);
    return paramBitmap;
  }
  
  public static void a(final Context paramContext, View paramView, final Bitmap paramBitmap, final String paramString)
  {
    AppMethodBeat.i(223470);
    p.h(paramContext, "context");
    p.h(paramView, "container");
    p.h(paramBitmap, "bitmap");
    p.h(paramString, "md5Key");
    Bitmap localBitmap = q.bcV().OQ(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      d.h((kotlin.g.a.a)new b.a(paramContext, localBitmap, paramView));
      AppMethodBeat.o(223470);
      return;
    }
    if ((paramView.getWidth() > 0) && (paramView.getHeight() > 0))
    {
      a(paramContext, paramView, paramBitmap, paramString, paramView.getWidth(), paramView.getHeight());
      AppMethodBeat.o(223470);
      return;
    }
    paramView.post((Runnable)new b(paramView, paramContext, paramBitmap, paramString));
    AppMethodBeat.o(223470);
  }
  
  private static void a(Context paramContext, View paramView, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(258501);
    try
    {
      long l = Util.currentTicks();
      if (paramBitmap == null) {}
      try
      {
        p.hyc();
        int j = paramBitmap.getHeight();
        int i = paramBitmap.getWidth();
        paramInt1 = (int)(j * 1.0F * (paramInt2 * 1.0F / paramInt1));
        Object localObject = new Matrix();
        float f = paramInt2 * 1.0F / paramInt1 * 0.25F * 0.25F;
        ((Matrix)localObject).postScale(f, f);
        localObject = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - paramInt1) / 2, i, paramInt1, (Matrix)localObject, false);
        localObject = new f(MMApplicationContext.getContext()).b((Bitmap)localObject, 30.0F);
        paramBitmap = (Bitmap)localObject;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.Mv.MusicMvUIUtil", "setBlurBitmap error:" + localThrowable.getMessage());
          paramBitmap = BitmapUtil.fastblur(paramBitmap, 30);
        }
      }
      finally
      {
        AppMethodBeat.o(258501);
      }
      if (paramBitmap != null)
      {
        q.bcV().h(paramString, paramBitmap);
        paramView.setBackground((Drawable)new BitmapDrawable(paramContext.getResources(), paramBitmap));
      }
      Log.i("MicroMsg.Mv.MusicMvUIUtil", "updateBlurBmBackground, after blur, cost:" + Util.ticksToNow(l));
      AppMethodBeat.o(258501);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Mv.MusicMvUIUtil", "updateBlurBmBackground, fail, reason:" + paramContext.getMessage());
      AppMethodBeat.o(258501);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView, Context paramContext, Bitmap paramBitmap, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(258500);
      int i = this.qCr.getWidth();
      int j = this.qCr.getHeight();
      if ((this.qCr.getWidth() == 0) || (this.qCr.getHeight() == 0))
      {
        i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 268);
        j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 80);
      }
      b localb = b.qCp;
      b.b(paramContext, this.qCr, paramBitmap, paramString, i, j);
      AppMethodBeat.o(258500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b
 * JD-Core Version:    0.7.0.1
 */