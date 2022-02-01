package com.tencent.mm.plugin.finder.live.view.span;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan;", "Landroid/text/style/ImageSpan;", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawBackgroung", "drawLeftIcon", "drawRightText", "spanWidth", "Builder", "Companion", "FinderLiveImageSpanParams", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends ImageSpan
  implements k
{
  public static final b DWw;
  public e.c DWx;
  
  static
  {
    AppMethodBeat.i(358391);
    DWw = new b((byte)0);
    AppMethodBeat.o(358391);
  }
  
  public e(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(358384);
    this.DWx = new e.c();
    AppMethodBeat.o(358384);
  }
  
  /* Error */
  public final void draw(android.graphics.Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, android.graphics.Paint paramPaint)
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 101
    //   8: invokestatic 89	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload 9
    //   13: ldc 102
    //   15: invokestatic 89	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload 9
    //   20: invokevirtual 108	android/graphics/Paint:getColor	()I
    //   23: istore 4
    //   25: aload 9
    //   27: invokevirtual 112	android/graphics/Paint:getTextSize	()F
    //   30: fstore 10
    //   32: aload 9
    //   34: invokevirtual 116	android/graphics/Paint:getTypeface	()Landroid/graphics/Typeface;
    //   37: astore 17
    //   39: aload 9
    //   41: aload_0
    //   42: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   45: getfield 120	com/tencent/mm/plugin/finder/live/view/span/e$c:textSize	I
    //   48: i2f
    //   49: invokevirtual 124	android/graphics/Paint:setTextSize	(F)V
    //   52: aload 9
    //   54: aload_0
    //   55: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   58: getfield 128	com/tencent/mm/plugin/finder/live/view/span/e$c:bba	Ljava/lang/CharSequence;
    //   61: invokevirtual 134	java/lang/Object:toString	()Ljava/lang/String;
    //   64: invokevirtual 138	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   67: fstore 12
    //   69: aload_0
    //   70: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   73: getfield 141	com/tencent/mm/plugin/finder/live/view/span/e$c:bmt	I
    //   76: i2f
    //   77: fload 5
    //   79: fadd
    //   80: fstore 11
    //   82: fload 12
    //   84: aload_0
    //   85: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   88: getfield 144	com/tencent/mm/plugin/finder/live/view/span/e$c:DWz	I
    //   91: i2f
    //   92: fload 11
    //   94: fadd
    //   95: aload_0
    //   96: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   99: getfield 147	com/tencent/mm/plugin/finder/live/view/span/e$c:DWq	I
    //   102: i2f
    //   103: fadd
    //   104: aload_0
    //   105: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   108: getfield 150	com/tencent/mm/plugin/finder/live/view/span/e$c:DWB	I
    //   111: i2f
    //   112: fadd
    //   113: fadd
    //   114: aload_0
    //   115: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   118: getfield 153	com/tencent/mm/plugin/finder/live/view/span/e$c:DWA	I
    //   121: i2f
    //   122: fadd
    //   123: fstore 12
    //   125: aload_0
    //   126: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   129: getfield 156	com/tencent/mm/plugin/finder/live/view/span/e$c:pQi	I
    //   132: i2f
    //   133: fconst_2
    //   134: fdiv
    //   135: fstore 14
    //   137: iload 8
    //   139: i2f
    //   140: iload 6
    //   142: i2f
    //   143: fsub
    //   144: fconst_2
    //   145: fdiv
    //   146: fstore 15
    //   148: fload 15
    //   150: fload 14
    //   152: fsub
    //   153: fstore 13
    //   155: fload 14
    //   157: fload 15
    //   159: fadd
    //   160: fstore 14
    //   162: aload_0
    //   163: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   166: getfield 159	com/tencent/mm/plugin/finder/live/view/span/e$c:bgColor	I
    //   169: ifne +13 -> 182
    //   172: aload_0
    //   173: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   176: getfield 162	com/tencent/mm/plugin/finder/live/view/span/e$c:DWC	I
    //   179: ifne +133 -> 312
    //   182: aload 9
    //   184: aload_0
    //   185: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   188: getfield 159	com/tencent/mm/plugin/finder/live/view/span/e$c:bgColor	I
    //   191: invokevirtual 165	android/graphics/Paint:setColor	(I)V
    //   194: aload_1
    //   195: new 167	android/graphics/RectF
    //   198: dup
    //   199: fload 11
    //   201: fload 13
    //   203: fload 12
    //   205: fload 14
    //   207: invokespecial 170	android/graphics/RectF:<init>	(FFFF)V
    //   210: aload_0
    //   211: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   214: getfield 173	com/tencent/mm/plugin/finder/live/view/span/e$c:bgRadius	I
    //   217: i2f
    //   218: aload_0
    //   219: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   222: getfield 173	com/tencent/mm/plugin/finder/live/view/span/e$c:bgRadius	I
    //   225: i2f
    //   226: aload 9
    //   228: invokevirtual 179	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   231: aload_0
    //   232: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   235: getfield 182	com/tencent/mm/plugin/finder/live/view/span/e$c:DWp	Landroid/graphics/drawable/Drawable;
    //   238: astore_2
    //   239: aload_2
    //   240: ifnonnull +186 -> 426
    //   243: aconst_null
    //   244: astore_2
    //   245: aload_2
    //   246: ifnonnull +10 -> 256
    //   249: ldc 184
    //   251: ldc 186
    //   253: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_0
    //   257: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   260: getfield 128	com/tencent/mm/plugin/finder/live/view/span/e$c:bba	Ljava/lang/CharSequence;
    //   263: invokeinterface 197 1 0
    //   268: ifne +443 -> 711
    //   271: iconst_1
    //   272: istore_3
    //   273: iload_3
    //   274: ifeq +286 -> 560
    //   277: ldc 184
    //   279: ldc 199
    //   281: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 9
    //   286: iload 4
    //   288: invokevirtual 165	android/graphics/Paint:setColor	(I)V
    //   291: aload 9
    //   293: fload 10
    //   295: invokevirtual 124	android/graphics/Paint:setTextSize	(F)V
    //   298: aload 9
    //   300: aload 17
    //   302: invokevirtual 203	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   305: pop
    //   306: ldc 100
    //   308: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   315: invokevirtual 215	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   318: aload_0
    //   319: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   322: getfield 162	com/tencent/mm/plugin/finder/live/view/span/e$c:DWC	I
    //   325: aconst_null
    //   326: invokevirtual 221	android/content/res/Resources:getDrawable	(ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;
    //   329: astore_2
    //   330: aload_2
    //   331: new 223	android/graphics/Rect
    //   334: dup
    //   335: fload 11
    //   337: f2i
    //   338: fload 13
    //   340: f2i
    //   341: fload 12
    //   343: f2i
    //   344: fload 14
    //   346: f2i
    //   347: invokespecial 226	android/graphics/Rect:<init>	(IIII)V
    //   350: invokevirtual 232	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   353: aload_2
    //   354: aload_1
    //   355: invokevirtual 235	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   358: goto -127 -> 231
    //   361: astore_2
    //   362: ldc 184
    //   364: aload_2
    //   365: ldc 237
    //   367: aload_0
    //   368: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   371: getfield 162	com/tencent/mm/plugin/finder/live/view/span/e$c:DWC	I
    //   374: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: invokestatic 247	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   380: iconst_0
    //   381: anewarray 130	java/lang/Object
    //   384: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: goto -156 -> 231
    //   390: astore_1
    //   391: getstatic 257	com/tencent/mm/plugin/findersdk/b:HbT	Lcom/tencent/mm/plugin/findersdk/b;
    //   394: checkcast 259	com/tencent/mm/ae/e
    //   397: ldc_w 261
    //   400: iconst_0
    //   401: aconst_null
    //   402: iconst_0
    //   403: aconst_null
    //   404: bipush 60
    //   406: invokestatic 266	com/tencent/mm/ae/e$a:a	(Lcom/tencent/mm/ae/e;Ljava/lang/String;ZLcom/tencent/mm/ae/e$b;ZLkotlin/g/a/a;I)V
    //   409: getstatic 272	com/tencent/mm/plugin/finder/utils/aw:Gjk	Lcom/tencent/mm/plugin/finder/utils/aw;
    //   412: astore_2
    //   413: aload_1
    //   414: ldc_w 274
    //   417: invokestatic 277	com/tencent/mm/plugin/finder/utils/aw:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   420: ldc 100
    //   422: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: return
    //   426: aload_2
    //   427: new 279	android/graphics/PorterDuffColorFilter
    //   430: dup
    //   431: aload_0
    //   432: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   435: getfield 282	com/tencent/mm/plugin/finder/live/view/span/e$c:DWE	I
    //   438: getstatic 288	android/graphics/PorterDuff$Mode:SRC_ATOP	Landroid/graphics/PorterDuff$Mode;
    //   441: invokespecial 291	android/graphics/PorterDuffColorFilter:<init>	(ILandroid/graphics/PorterDuff$Mode;)V
    //   444: checkcast 293	android/graphics/ColorFilter
    //   447: invokevirtual 297	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   450: aload_0
    //   451: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   454: getfield 141	com/tencent/mm/plugin/finder/live/view/span/e$c:bmt	I
    //   457: i2f
    //   458: fload 5
    //   460: fadd
    //   461: aload_0
    //   462: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   465: getfield 144	com/tencent/mm/plugin/finder/live/view/span/e$c:DWz	I
    //   468: i2f
    //   469: fadd
    //   470: fstore 11
    //   472: aload_0
    //   473: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   476: getfield 147	com/tencent/mm/plugin/finder/live/view/span/e$c:DWq	I
    //   479: i2f
    //   480: fstore 12
    //   482: iload 8
    //   484: iload 6
    //   486: isub
    //   487: aload_0
    //   488: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   491: getfield 300	com/tencent/mm/plugin/finder/live/view/span/e$c:DWr	I
    //   494: isub
    //   495: iconst_2
    //   496: idiv
    //   497: istore_3
    //   498: aload_0
    //   499: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   502: getfield 300	com/tencent/mm/plugin/finder/live/view/span/e$c:DWr	I
    //   505: istore 7
    //   507: aload_2
    //   508: new 223	android/graphics/Rect
    //   511: dup
    //   512: fload 11
    //   514: f2i
    //   515: iload_3
    //   516: fload 12
    //   518: fload 11
    //   520: fadd
    //   521: f2i
    //   522: iload 7
    //   524: iload_3
    //   525: iadd
    //   526: invokespecial 226	android/graphics/Rect:<init>	(IIII)V
    //   529: invokevirtual 232	android/graphics/drawable/Drawable:setBounds	(Landroid/graphics/Rect;)V
    //   532: aload_1
    //   533: new 302	android/graphics/PaintFlagsDrawFilter
    //   536: dup
    //   537: iconst_0
    //   538: iconst_3
    //   539: invokespecial 305	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   542: checkcast 307	android/graphics/DrawFilter
    //   545: invokevirtual 311	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   548: aload_2
    //   549: aload_1
    //   550: invokevirtual 235	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   553: getstatic 317	kotlin/ah:aiuX	Lkotlin/ah;
    //   556: astore_2
    //   557: goto -312 -> 245
    //   560: aload_0
    //   561: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   564: getfield 321	com/tencent/mm/plugin/finder/live/view/span/e$c:DWD	Z
    //   567: ifeq +11 -> 578
    //   570: aload 9
    //   572: ldc_w 322
    //   575: invokestatic 327	com/tencent/mm/ui/aw:a	(Landroid/graphics/Paint;F)V
    //   578: aload 9
    //   580: aload_0
    //   581: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   584: getfield 330	com/tencent/mm/plugin/finder/live/view/span/e$c:textColor	I
    //   587: invokevirtual 165	android/graphics/Paint:setColor	(I)V
    //   590: aload 9
    //   592: invokevirtual 333	android/graphics/Paint:ascent	()F
    //   595: aload 9
    //   597: invokevirtual 336	android/graphics/Paint:descent	()F
    //   600: fadd
    //   601: invokestatic 342	java/lang/Math:abs	(F)F
    //   604: fconst_2
    //   605: fdiv
    //   606: fstore 11
    //   608: iload 8
    //   610: iload 6
    //   612: isub
    //   613: iconst_2
    //   614: idiv
    //   615: i2f
    //   616: fstore 12
    //   618: aload_0
    //   619: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   622: getfield 141	com/tencent/mm/plugin/finder/live/view/span/e$c:bmt	I
    //   625: i2f
    //   626: fstore 13
    //   628: aload_0
    //   629: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   632: getfield 144	com/tencent/mm/plugin/finder/live/view/span/e$c:DWz	I
    //   635: i2f
    //   636: fstore 14
    //   638: aload_0
    //   639: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   642: getfield 147	com/tencent/mm/plugin/finder/live/view/span/e$c:DWq	I
    //   645: i2f
    //   646: fstore 15
    //   648: aload_0
    //   649: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   652: getfield 150	com/tencent/mm/plugin/finder/live/view/span/e$c:DWB	I
    //   655: i2f
    //   656: fstore 16
    //   658: aload_1
    //   659: aload_0
    //   660: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   663: getfield 128	com/tencent/mm/plugin/finder/live/view/span/e$c:bba	Ljava/lang/CharSequence;
    //   666: invokevirtual 134	java/lang/Object:toString	()Ljava/lang/String;
    //   669: fload 13
    //   671: fload 5
    //   673: fadd
    //   674: fload 14
    //   676: fadd
    //   677: fload 15
    //   679: fadd
    //   680: fload 16
    //   682: fadd
    //   683: fload 11
    //   685: fload 12
    //   687: fadd
    //   688: aload 9
    //   690: invokevirtual 346	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   693: aload_0
    //   694: getfield 96	com/tencent/mm/plugin/finder/live/view/span/e:DWx	Lcom/tencent/mm/plugin/finder/live/view/span/e$c;
    //   697: getfield 321	com/tencent/mm/plugin/finder/live/view/span/e$c:DWD	Z
    //   700: ifeq -416 -> 284
    //   703: aload 9
    //   705: invokestatic 349	com/tencent/mm/ui/aw:e	(Landroid/graphics/Paint;)V
    //   708: goto -424 -> 284
    //   711: iconst_0
    //   712: istore_3
    //   713: goto -440 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	e
    //   0	716	1	paramCanvas	android.graphics.Canvas
    //   0	716	2	paramCharSequence	CharSequence
    //   0	716	3	paramInt1	int
    //   0	716	4	paramInt2	int
    //   0	716	5	paramFloat	float
    //   0	716	6	paramInt3	int
    //   0	716	7	paramInt4	int
    //   0	716	8	paramInt5	int
    //   0	716	9	paramPaint	android.graphics.Paint
    //   30	264	10	f1	float
    //   80	604	11	f2	float
    //   67	619	12	f3	float
    //   153	517	13	f4	float
    //   135	540	14	f5	float
    //   146	532	15	f6	float
    //   656	25	16	f7	float
    //   37	264	17	localTypeface	android.graphics.Typeface
    // Exception table:
    //   from	to	target	type
    //   312	358	361	finally
    //   18	148	390	java/lang/Exception
    //   162	182	390	java/lang/Exception
    //   182	231	390	java/lang/Exception
    //   231	239	390	java/lang/Exception
    //   249	256	390	java/lang/Exception
    //   256	271	390	java/lang/Exception
    //   277	284	390	java/lang/Exception
    //   284	306	390	java/lang/Exception
    //   362	387	390	java/lang/Exception
    //   426	557	390	java/lang/Exception
    //   560	578	390	java/lang/Exception
    //   578	708	390	java/lang/Exception
  }
  
  public final int ewo()
  {
    return this.DWx.DWF;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$Builder;", "", "()V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;)V", "build", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan;", "setBgHeight", "bgHeight", "", "setBgRadius", "bgRadius", "setItemPadding", "itemPadding", "setLeftIcon", "leftIcon", "Landroid/graphics/drawable/Drawable;", "setLeftIconColor", "leftIconColor", "setLeftIconRes", "leftIconId", "setLeftIconWidth", "leftIconWidth", "setLeftMargin", "leftMargin", "setLeftPadding", "leftPadding", "setLevel", "userLevel", "textContent", "", "config", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpanConfig;", "setRightMargin", "rightMargin", "setRightPadding", "rightPadding", "setServerBgColor", "serverColorStr", "setText", "text", "", "setTextBold", "bold", "", "setTextColor", "textColor", "setTextSize", "textSize", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a DWy;
    private e.c DWx;
    
    static
    {
      AppMethodBeat.i(358338);
      DWy = new a((byte)0);
      AppMethodBeat.o(358338);
    }
    
    public a()
    {
      AppMethodBeat.i(358332);
      this.DWx = new e.c();
      AppMethodBeat.o(358332);
    }
    
    public final a O(Drawable paramDrawable)
    {
      AppMethodBeat.i(358378);
      s.u(paramDrawable, "leftIcon");
      this.DWx.DWp = paramDrawable;
      AppMethodBeat.o(358378);
      return this;
    }
    
    public final a PL(int paramInt)
    {
      this.DWx.bmt = 0;
      return this;
    }
    
    public final a PM(int paramInt)
    {
      this.DWx.DWz = paramInt;
      return this;
    }
    
    public final a PN(int paramInt)
    {
      this.DWx.DWA = paramInt;
      return this;
    }
    
    public final a PO(int paramInt)
    {
      this.DWx.DWB = paramInt;
      return this;
    }
    
    public final a a(int paramInt, String paramString, l<Integer> paraml)
    {
      AppMethodBeat.i(358351);
      s.u(paramString, "textContent");
      s.u(paraml, "config");
      this.DWx.DWC = paraml.fr(Integer.valueOf(paramInt));
      this.DWx.pQi = paraml.fl(Integer.valueOf(paramInt));
      this.DWx.textColor = paraml.fm(Integer.valueOf(paramInt));
      this.DWx.textSize = paraml.fn(Integer.valueOf(paramInt));
      Object localObject1 = this.DWx;
      boolean bool;
      Object localObject2;
      float f;
      if (paraml.fo(Integer.valueOf(paramInt)) == 1)
      {
        bool = true;
        ((e.c)localObject1).DWD = bool;
        localObject1 = paraml.fp(Integer.valueOf(paramInt));
        if (localObject1.length == 2)
        {
          this.DWx.DWq = localObject1[0];
          this.DWx.DWr = localObject1[1];
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveLevelImageSpan", "setLevel iconSize:" + localObject1[0] + '-' + localObject1[1]);
        }
        f = 2.0F * this.DWx.DWr / 30.0F;
        localObject1 = this.DWx;
        localObject2 = MMApplicationContext.getResources();
        paramInt = paraml.fq(Integer.valueOf(paramInt));
        if (f <= 1.0F) {
          break label288;
        }
      }
      for (;;)
      {
        ((e.c)localObject1).DWp = com.tencent.mm.svg.a.a.a((Resources)localObject2, paramInt, f);
        paraml = this.DWx;
        paramString = (CharSequence)paramString;
        s.u(paramString, "<set-?>");
        paraml.bba = paramString;
        AppMethodBeat.o(358351);
        return this;
        bool = false;
        break;
        label288:
        f = 1.0F;
      }
    }
    
    public final a ayf(String paramString)
    {
      AppMethodBeat.i(358371);
      CharSequence localCharSequence = (CharSequence)paramString;
      int i;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {}
        try
        {
          this.DWx.bgColor = Color.parseColor(paramString);
          AppMethodBeat.o(358371);
          return this;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.DWx.bgColor = 0;
            Log.e("FinderLiveLevelImageSpan", localException + ",serverColor:" + paramString);
          }
        }
      }
    }
    
    public final e ews()
    {
      AppMethodBeat.i(358415);
      Object localObject1 = this.DWx;
      float f = this.DWx.bmt + this.DWx.DWz + this.DWx.DWq + this.DWx.DWB;
      Object localObject2 = h.DWP;
      ((e.c)localObject1).DWF = ((int)(f + h.f(this.DWx.bba.toString(), this.DWx.textSize) + this.DWx.DWA + this.DWx.bmu));
      localObject1 = h.DWP;
      localObject1 = new e(h.PP(this.DWx.DWF));
      localObject2 = this.DWx;
      s.u(localObject2, "<set-?>");
      ((e)localObject1).DWx = ((e.c)localObject2);
      AppMethodBeat.o(358415);
      return localObject1;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$Builder$Companion;", "", "()V", "DESIGN_ICON_HEIGH", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$Companion;", "", "()V", "TAG", "", "createBuilder", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$Builder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.e
 * JD-Core Version:    0.7.0.1
 */