package com.tencent.mm.plugin.comm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/MusicMvUIUtil;", "", "()V", "TAG", "", "addGradientDrawableToBitmap", "Landroid/graphics/Bitmap;", "isDarkMode", "", "bm", "calcAndUpdateBlurBm", "", "context", "Landroid/content/Context;", "container", "Landroid/view/View;", "bitmap", "md5Key", "targetWidth", "", "targetHeight", "updateBlurBmBackground", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b xeH;
  
  static
  {
    AppMethodBeat.i(260524);
    xeH = new b();
    AppMethodBeat.o(260524);
  }
  
  public static Bitmap a(boolean paramBoolean, Bitmap paramBitmap)
  {
    AppMethodBeat.i(260506);
    s.u(paramBitmap, "bm");
    Log.e("MicroMsg.Mv.MusicMvUIUtil", "addGradientDrawableToBitmap, start ");
    long l = System.currentTimeMillis();
    Object localObject = new int[2];
    localObject[0] = -1711802377;
    localObject[1] = -134744073;
    if (paramBoolean)
    {
      localObject = new int[2];
      localObject[0] = -1289542877;
      localObject[1] = -232578269;
    }
    localObject = new GradientDrawable(GradientDrawable.Orientation.BL_TR, (int[])localObject);
    ((GradientDrawable)localObject).setGradientType(0);
    ((GradientDrawable)localObject).setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    ((GradientDrawable)localObject).draw(new Canvas(paramBitmap));
    localObject = am.aixg;
    localObject = String.format(" addGradientDrawableToBitmap end, cost:%d", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis() - l) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    Log.e("MicroMsg.Mv.MusicMvUIUtil", (String)localObject);
    AppMethodBeat.o(260506);
    return paramBitmap;
  }
  
  public static void a(Context paramContext, View paramView, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(260516);
    s.u(paramContext, "context");
    s.u(paramView, "container");
    s.u(paramBitmap, "bitmap");
    s.u(paramString, "md5Key");
    Bitmap localBitmap = r.bKe().Oo(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      d.uiThread((kotlin.g.a.a)new b.a(paramContext, localBitmap, paramView));
      AppMethodBeat.o(260516);
      return;
    }
    if ((paramView.getWidth() > 0) && (paramView.getHeight() > 0))
    {
      a(paramContext, paramView, paramBitmap, paramString, paramView.getWidth(), paramView.getHeight());
      AppMethodBeat.o(260516);
      return;
    }
    paramView.post(new b..ExternalSyntheticLambda0(paramView, paramContext, paramBitmap, paramString));
    AppMethodBeat.o(260516);
  }
  
  /* Error */
  private static void a(Context paramContext, View paramView, Bitmap paramBitmap, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 213	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   8: lstore 9
    //   10: aload_2
    //   11: invokestatic 217	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   14: aload_2
    //   15: invokevirtual 111	android/graphics/Bitmap:getHeight	()I
    //   18: istore 8
    //   20: aload_2
    //   21: invokevirtual 108	android/graphics/Bitmap:getWidth	()I
    //   24: istore 7
    //   26: iload 8
    //   28: i2f
    //   29: fconst_1
    //   30: fmul
    //   31: iload 5
    //   33: i2f
    //   34: fconst_1
    //   35: fmul
    //   36: iload 4
    //   38: i2f
    //   39: fdiv
    //   40: fmul
    //   41: f2i
    //   42: istore 4
    //   44: new 219	android/graphics/Matrix
    //   47: dup
    //   48: invokespecial 220	android/graphics/Matrix:<init>	()V
    //   51: astore 11
    //   53: iload 5
    //   55: i2f
    //   56: fconst_1
    //   57: fmul
    //   58: iload 4
    //   60: i2f
    //   61: fdiv
    //   62: ldc 221
    //   64: fmul
    //   65: ldc 221
    //   67: fmul
    //   68: fstore 6
    //   70: aload 11
    //   72: fload 6
    //   74: fload 6
    //   76: invokevirtual 225	android/graphics/Matrix:postScale	(FF)Z
    //   79: pop
    //   80: aload_2
    //   81: iconst_0
    //   82: aload_2
    //   83: invokevirtual 111	android/graphics/Bitmap:getHeight	()I
    //   86: iload 4
    //   88: isub
    //   89: iconst_2
    //   90: idiv
    //   91: iload 7
    //   93: iload 4
    //   95: aload 11
    //   97: iconst_0
    //   98: invokestatic 229	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   101: astore 11
    //   103: new 231	com/tencent/mm/ui/blur/f
    //   106: dup
    //   107: invokestatic 237	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   110: invokespecial 240	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   113: aload 11
    //   115: ldc 241
    //   117: invokevirtual 245	com/tencent/mm/ui/blur/f:c	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   120: astore 11
    //   122: aload 11
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +30 -> 156
    //   129: invokestatic 167	com/tencent/mm/modelimage/r:bKe	()Lcom/tencent/mm/modelimage/loader/a;
    //   132: aload_3
    //   133: aload_2
    //   134: invokevirtual 249	com/tencent/mm/modelimage/loader/a:h	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   137: aload_1
    //   138: new 251	android/graphics/drawable/BitmapDrawable
    //   141: dup
    //   142: aload_0
    //   143: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   146: aload_2
    //   147: invokespecial 260	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   150: checkcast 262	android/graphics/drawable/Drawable
    //   153: invokevirtual 266	android/view/View:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   156: ldc 70
    //   158: ldc_w 268
    //   161: lload 9
    //   163: invokestatic 272	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   166: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   169: invokestatic 276	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: ldc 208
    //   177: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: astore 11
    //   183: ldc 70
    //   185: ldc_w 280
    //   188: aload 11
    //   190: invokevirtual 286	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   193: invokestatic 276	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_2
    //   200: bipush 30
    //   202: invokestatic 292	com/tencent/mm/sdk/platformtools/BitmapUtil:fastblur	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   205: astore_2
    //   206: goto -81 -> 125
    //   209: astore_0
    //   210: ldc 208
    //   212: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_0
    //   216: athrow
    //   217: astore_0
    //   218: ldc 70
    //   220: ldc_w 294
    //   223: aload_0
    //   224: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokestatic 276	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   230: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: ldc 208
    //   235: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	Context
    //   0	239	1	paramView	View
    //   0	239	2	paramBitmap	Bitmap
    //   0	239	3	paramString	String
    //   0	239	4	paramInt1	int
    //   0	239	5	paramInt2	int
    //   68	7	6	f	float
    //   24	68	7	i	int
    //   18	9	8	j	int
    //   8	154	9	l	long
    //   51	72	11	localObject1	Object
    //   181	8	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	122	181	finally
    //   183	206	209	finally
    //   5	10	217	java/lang/Exception
    //   129	156	217	java/lang/Exception
    //   156	175	217	java/lang/Exception
    //   210	217	217	java/lang/Exception
  }
  
  private static final void a(View paramView, Context paramContext, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(260520);
    s.u(paramView, "$container");
    s.u(paramContext, "$context");
    s.u(paramBitmap, "$bitmap");
    s.u(paramString, "$md5Key");
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0))
    {
      i = com.tencent.mm.cd.a.fromDPToPix(paramContext, 268);
      j = com.tencent.mm.cd.a.fromDPToPix(paramContext, 80);
    }
    a(paramContext, paramView, paramBitmap, paramString, i, j);
    AppMethodBeat.o(260520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b
 * JD-Core Version:    0.7.0.1
 */