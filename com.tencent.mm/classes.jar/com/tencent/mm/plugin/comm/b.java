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
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.blur.f;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/comm/MusicMvUIUtil;", "", "()V", "TAG", "", "addGradientDrawableToBitmap", "Landroid/graphics/Bitmap;", "isDarkMode", "", "bm", "calcAndUpdateBlurBm", "", "context", "Landroid/content/Context;", "container", "Landroid/view/View;", "bitmap", "md5Key", "targetWidth", "", "targetHeight", "updateBlurBmBackground", "plugin-comm_release"})
public final class b
{
  public static final b ubp;
  
  static
  {
    AppMethodBeat.i(204042);
    ubp = new b();
    AppMethodBeat.o(204042);
  }
  
  @SuppressLint({"WrongConstant"})
  public static Bitmap a(boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(204034);
    p.k(paramBitmap, "bm");
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
    tmp51_49 = af.aaBG;
    tmp51_49 = String.format(" addGradientDrawableToBitmap end, cost:%d", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis() - l) }, 1));
    p.j(tmp51_49, "java.lang.String.format(format, *args)");
    Log.e("MicroMsg.Mv.MusicMvUIUtil", (String)tmp51_49);
    AppMethodBeat.o(204034);
    return paramBitmap;
  }
  
  public static void a(final Context paramContext, final View paramView, final Bitmap paramBitmap, final String paramString)
  {
    AppMethodBeat.i(204040);
    p.k(paramContext, "context");
    p.k(paramView, "container");
    p.k(paramBitmap, "bitmap");
    p.k(paramString, "md5Key");
    final Bitmap localBitmap = com.tencent.mm.ay.q.bml().Wo(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      d.uiThread((kotlin.g.a.a)new a(paramContext, localBitmap, paramView));
      AppMethodBeat.o(204040);
      return;
    }
    if ((paramView.getWidth() > 0) && (paramView.getHeight() > 0))
    {
      a(paramContext, paramView, paramBitmap, paramString, paramView.getWidth(), paramView.getHeight());
      AppMethodBeat.o(204040);
      return;
    }
    paramView.post((Runnable)new b(paramView, paramContext, paramBitmap, paramString));
    AppMethodBeat.o(204040);
  }
  
  private static void a(Context paramContext, View paramView, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204038);
    try
    {
      long l = Util.currentTicks();
      if (paramBitmap == null) {}
      try
      {
        p.iCn();
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
        AppMethodBeat.o(204038);
      }
      if (paramBitmap != null)
      {
        com.tencent.mm.ay.q.bml().h(paramString, paramBitmap);
        paramView.setBackground((Drawable)new BitmapDrawable(paramContext.getResources(), paramBitmap));
      }
      Log.i("MicroMsg.Mv.MusicMvUIUtil", "updateBlurBmBackground, after blur, cost:" + Util.ticksToNow(l));
      AppMethodBeat.o(204038);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.Mv.MusicMvUIUtil", "updateBlurBmBackground, fail, reason:" + paramContext.getMessage());
      AppMethodBeat.o(204038);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(Context paramContext, Bitmap paramBitmap, View paramView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView, Context paramContext, Bitmap paramBitmap, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(199318);
      int i = this.ubr.getWidth();
      int j = this.ubr.getHeight();
      if ((this.ubr.getWidth() == 0) || (this.ubr.getHeight() == 0))
      {
        i = com.tencent.mm.ci.a.fromDPToPix(paramContext, 268);
        j = com.tencent.mm.ci.a.fromDPToPix(paramContext, 80);
      }
      b localb = b.ubp;
      b.b(paramContext, this.ubr, paramBitmap, paramString, i, j);
      AppMethodBeat.o(199318);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b
 * JD-Core Version:    0.7.0.1
 */