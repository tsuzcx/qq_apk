package com.tencent.h.a.c.c.a;

import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.h.a.a.c;
import com.tencent.h.a.b.c.b.a;
import com.tencent.h.a.b.c.b.b;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class a
  implements b.b
{
  private c ahWN;
  com.tencent.h.a.b.c.a.b ahYE;
  private Rect ahYF = new Rect();
  private Set<Integer> ahYG = new CopyOnWriteArraySet();
  protected b ahYH;
  
  public a(c paramc, com.tencent.h.a.b.c.a.b paramb)
  {
    this.ahWN = paramc;
    this.ahYE = paramb;
  }
  
  protected static com.tencent.h.a.c.b.i a(int paramInt, long paramLong, float paramFloat1, float paramFloat2)
  {
    com.tencent.h.a.c.b.i locali = new com.tencent.h.a.c.b.i();
    locali.ahYy = paramInt;
    locali.ahYz = paramLong;
    com.tencent.g.c.i.i("sensor_AbsTouch", "[method: buildTouchInfo ] touchTimestamp : " + locali.ahYz);
    locali.ahYA = paramFloat1;
    locali.ahYB = paramFloat2;
    return locali;
  }
  
  protected abstract void a(MotionEvent paramMotionEvent, b.a parama);
  
  /* Error */
  public final void a(MotionEvent paramMotionEvent, b.a parama, b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_1
    //   4: istore 10
    //   6: iconst_1
    //   7: istore 8
    //   9: aload_0
    //   10: aload_3
    //   11: putfield 84	com/tencent/h/a/c/c/a/a:ahYH	Lcom/tencent/h/a/c/c/a/b;
    //   14: aload_1
    //   15: ifnonnull +25 -> 40
    //   18: ldc 52
    //   20: ldc 86
    //   22: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iconst_0
    //   26: istore 8
    //   28: iload 8
    //   30: ifeq +9 -> 39
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: invokevirtual 88	com/tencent/h/a/c/c/a/a:a	(Landroid/view/MotionEvent;Lcom/tencent/h/a/b/c/b$a;)V
    //   39: return
    //   40: aload_0
    //   41: getfield 36	com/tencent/h/a/c/c/a/a:ahYE	Lcom/tencent/h/a/b/c/a/b;
    //   44: ifnull +15 -> 59
    //   47: aload_0
    //   48: getfield 36	com/tencent/h/a/c/c/a/a:ahYE	Lcom/tencent/h/a/b/c/a/b;
    //   51: invokeinterface 94 1 0
    //   56: ifnonnull +13 -> 69
    //   59: ldc 52
    //   61: ldc 96
    //   63: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: goto -38 -> 28
    //   69: aload_0
    //   70: getfield 36	com/tencent/h/a/c/c/a/a:ahYE	Lcom/tencent/h/a/b/c/a/b;
    //   73: invokeinterface 94 1 0
    //   78: getfield 102	com/tencent/h/a/h$a:ahWu	Landroid/view/View;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnonnull +13 -> 96
    //   86: ldc 52
    //   88: ldc 104
    //   90: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: goto -65 -> 28
    //   96: aload_1
    //   97: invokevirtual 110	android/view/MotionEvent:getActionIndex	()I
    //   100: istore 5
    //   102: aload_1
    //   103: iload 5
    //   105: invokevirtual 114	android/view/MotionEvent:getPointerId	(I)I
    //   108: istore 4
    //   110: aload_1
    //   111: invokevirtual 117	android/view/MotionEvent:getActionMasked	()I
    //   114: istore 6
    //   116: iload 6
    //   118: iconst_2
    //   119: if_icmpne +71 -> 190
    //   122: aload_0
    //   123: getfield 32	com/tencent/h/a/c/c/a/a:ahYG	Ljava/util/Set;
    //   126: invokeinterface 123 1 0
    //   131: ifne +510 -> 641
    //   134: aload_0
    //   135: getfield 32	com/tencent/h/a/c/c/a/a:ahYG	Ljava/util/Set;
    //   138: iload 4
    //   140: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokeinterface 133 2 0
    //   148: ifeq +493 -> 641
    //   151: iload 10
    //   153: istore 8
    //   155: ldc 52
    //   157: new 54	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 135
    //   163: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: iload 8
    //   168: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: ldc 140
    //   173: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload 4
    //   178: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: goto -159 -> 28
    //   190: iload 6
    //   192: ifeq +9 -> 201
    //   195: iload 6
    //   197: iconst_5
    //   198: if_icmpne +335 -> 533
    //   201: aload_0
    //   202: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   205: getfield 149	android/graphics/Rect:right	I
    //   208: aload_0
    //   209: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   212: getfield 152	android/graphics/Rect:left	I
    //   215: isub
    //   216: ifle +21 -> 237
    //   219: aload_0
    //   220: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   223: getfield 155	android/graphics/Rect:bottom	I
    //   226: aload_0
    //   227: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   230: getfield 158	android/graphics/Rect:top	I
    //   233: isub
    //   234: ifgt +81 -> 315
    //   237: iconst_2
    //   238: newarray int
    //   240: astore 11
    //   242: aload_3
    //   243: aload 11
    //   245: invokevirtual 164	android/view/View:getLocationOnScreen	([I)V
    //   248: aload_0
    //   249: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   252: aload 11
    //   254: iconst_0
    //   255: iaload
    //   256: putfield 152	android/graphics/Rect:left	I
    //   259: aload_0
    //   260: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   263: aload 11
    //   265: iconst_1
    //   266: iaload
    //   267: putfield 158	android/graphics/Rect:top	I
    //   270: aload_0
    //   271: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   274: aload_0
    //   275: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   278: getfield 152	android/graphics/Rect:left	I
    //   281: aload_3
    //   282: invokevirtual 167	android/view/View:getWidth	()I
    //   285: iadd
    //   286: putfield 149	android/graphics/Rect:right	I
    //   289: aload_0
    //   290: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   293: aload_0
    //   294: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   297: getfield 158	android/graphics/Rect:top	I
    //   300: aload_3
    //   301: invokevirtual 170	android/view/View:getHeight	()I
    //   304: iadd
    //   305: putfield 155	android/graphics/Rect:bottom	I
    //   308: ldc 52
    //   310: ldc 172
    //   312: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_1
    //   316: invokevirtual 176	android/view/MotionEvent:getRawX	()F
    //   319: f2i
    //   320: istore 6
    //   322: aload_1
    //   323: invokevirtual 179	android/view/MotionEvent:getRawY	()F
    //   326: f2i
    //   327: istore 7
    //   329: ldc 52
    //   331: new 54	java/lang/StringBuilder
    //   334: dup
    //   335: ldc 181
    //   337: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: iload 6
    //   342: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc 183
    //   347: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload 7
    //   352: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: new 185	android/view/MotionEvent$PointerCoords
    //   364: dup
    //   365: invokespecial 186	android/view/MotionEvent$PointerCoords:<init>	()V
    //   368: astore_3
    //   369: aload_1
    //   370: iload 5
    //   372: aload_3
    //   373: invokevirtual 190	android/view/MotionEvent:getPointerCoords	(ILandroid/view/MotionEvent$PointerCoords;)V
    //   376: aload_3
    //   377: getfield 193	android/view/MotionEvent$PointerCoords:x	F
    //   380: f2i
    //   381: istore 5
    //   383: aload_3
    //   384: getfield 196	android/view/MotionEvent$PointerCoords:y	F
    //   387: f2i
    //   388: istore 6
    //   390: ldc 52
    //   392: new 54	java/lang/StringBuilder
    //   395: dup
    //   396: ldc 198
    //   398: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: aload_3
    //   402: getfield 193	android/view/MotionEvent$PointerCoords:x	F
    //   405: invokevirtual 201	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   408: ldc 203
    //   410: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_3
    //   414: getfield 196	android/view/MotionEvent$PointerCoords:y	F
    //   417: invokevirtual 201	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   420: ldc 205
    //   422: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   435: iload 5
    //   437: iload 6
    //   439: invokevirtual 208	android/graphics/Rect:contains	(II)Z
    //   442: istore 8
    //   444: ldc 52
    //   446: new 54	java/lang/StringBuilder
    //   449: dup
    //   450: ldc 210
    //   452: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   455: aload_0
    //   456: getfield 27	com/tencent/h/a/c/c/a/a:ahYF	Landroid/graphics/Rect;
    //   459: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: ldc 215
    //   464: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: iload 8
    //   469: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   472: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: iload 8
    //   480: ifeq +18 -> 498
    //   483: aload_0
    //   484: getfield 32	com/tencent/h/a/c/c/a/a:ahYG	Ljava/util/Set;
    //   487: iload 4
    //   489: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: invokeinterface 218 2 0
    //   497: pop
    //   498: ldc 52
    //   500: new 54	java/lang/StringBuilder
    //   503: dup
    //   504: ldc 220
    //   506: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   509: iload 8
    //   511: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc 140
    //   516: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: iload 4
    //   521: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: goto -502 -> 28
    //   533: iload 9
    //   535: istore 8
    //   537: aload_0
    //   538: getfield 32	com/tencent/h/a/c/c/a/a:ahYG	Ljava/util/Set;
    //   541: invokeinterface 123 1 0
    //   546: ifne +42 -> 588
    //   549: iload 9
    //   551: istore 8
    //   553: aload_0
    //   554: getfield 32	com/tencent/h/a/c/c/a/a:ahYG	Ljava/util/Set;
    //   557: iload 4
    //   559: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   562: invokeinterface 133 2 0
    //   567: ifeq +21 -> 588
    //   570: aload_0
    //   571: getfield 32	com/tencent/h/a/c/c/a/a:ahYG	Ljava/util/Set;
    //   574: iload 4
    //   576: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   579: invokeinterface 223 2 0
    //   584: pop
    //   585: iconst_1
    //   586: istore 8
    //   588: ldc 52
    //   590: new 54	java/lang/StringBuilder
    //   593: dup
    //   594: ldc 225
    //   596: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   599: iload 8
    //   601: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: ldc 140
    //   606: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: iload 4
    //   611: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   614: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 73	com/tencent/g/c/i:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: goto -592 -> 28
    //   623: astore_1
    //   624: aload_0
    //   625: getfield 34	com/tencent/h/a/c/c/a/a:ahWN	Lcom/tencent/h/a/a/c;
    //   628: getfield 231	com/tencent/h/a/a/c:ahWQ	Lcom/tencent/g/a/b;
    //   631: aload_1
    //   632: ldc 233
    //   634: invokeinterface 239 3 0
    //   639: pop
    //   640: return
    //   641: iconst_0
    //   642: istore 8
    //   644: goto -489 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	a
    //   0	647	1	paramMotionEvent	MotionEvent
    //   0	647	2	parama	b.a
    //   0	647	3	paramb	b
    //   108	502	4	i	int
    //   100	336	5	j	int
    //   114	324	6	k	int
    //   327	24	7	m	int
    //   7	636	8	bool1	boolean
    //   1	549	9	bool2	boolean
    //   4	148	10	bool3	boolean
    //   240	24	11	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   33	39	623	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */