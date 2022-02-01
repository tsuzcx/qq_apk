package com.tencent.mm.cl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends com.tencent.mm.api.f
{
  public static final String UXU;
  public static final String UXV;
  private static final boolean UXW;
  private static b UXX;
  private static b UYm;
  private int UXY;
  private int UXZ;
  private int UYa;
  private int UYb;
  public long UYc;
  private a UYd;
  private SparseArray<c> UYe;
  public SparseArray<c> UYf;
  private SparseArray<c> UYg;
  private SparseArray<SparseArray<c>> UYh;
  private SparseArray<String> UYi;
  private com.tencent.mm.b.f<String, Bitmap> UYj;
  private boolean UYk;
  private LinkedList<d> UYl;
  private final Spannable.Factory UYn;
  private Context mContext;
  private LinkedList<c> rGq;
  
  static
  {
    AppMethodBeat.i(104917);
    UXU = com.tencent.mm.loader.j.b.aSC() + "app_font";
    UXV = UXU + "/color_emoji";
    if (Build.VERSION.SDK_INT < 19) {}
    for (boolean bool = true;; bool = false)
    {
      UXW = bool;
      UYm = null;
      AppMethodBeat.o(104917);
      return;
    }
  }
  
  private b()
  {
    AppMethodBeat.i(104897);
    this.UXY = 0;
    this.UYc = 0L;
    this.UYd = new a();
    this.UYe = new SparseArray();
    this.UYf = new SparseArray();
    this.UYg = new SparseArray();
    this.UYh = new SparseArray();
    this.UYi = null;
    this.UYj = new com.tencent.mm.memory.a.b(200, getClass());
    this.UYk = false;
    if (UYm != null) {
      UYm.dead();
    }
    b localb = new b(this);
    UYm = localb;
    localb.alive();
    this.UYn = new Spannable.Factory()
    {
      public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(104896);
        paramAnonymousCharSequence = new SpannableString(paramAnonymousCharSequence);
        AppMethodBeat.o(104896);
        return paramAnonymousCharSequence;
      }
    };
    this.mContext = MMApplicationContext.getContext();
    if (!u.agG(UXV)) {
      htI();
    }
    for (;;)
    {
      init();
      if (!com.tencent.mm.ci.a.ko(this.mContext)) {
        break;
      }
      this.UXY = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 4);
      AppMethodBeat.o(104897);
      return;
      Log.i("MicroMsg.EmojiHelper", "emoji color file exist.");
    }
    this.UXY = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 2);
    AppMethodBeat.o(104897);
  }
  
  public static void a(Spannable paramSpannable, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(232949);
    int i = (int)(paramInt3 * 1.3F);
    paramInt3 = (int)(paramInt3 * 1.3F);
    try
    {
      paramDrawable.setBounds(0, 0, i, paramInt3);
      paramSpannable.setSpan(new e(paramDrawable, paramBoolean, paramInt1, paramInt2), paramInt1, paramInt2, 33);
      AppMethodBeat.o(232949);
      return;
    }
    catch (Exception paramSpannable)
    {
      Log.printErrStackTrace("MicroMsg.EmojiHelper", paramSpannable, "", new Object[0]);
      AppMethodBeat.o(232949);
    }
  }
  
  public static String atQ(String paramString)
  {
    AppMethodBeat.i(104908);
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length();
    int i = 0;
    label175:
    for (;;)
    {
      if (i < k)
      {
        int m = paramString.codePointAt(i);
        i = Character.charCount(m) + i;
        if (i < k) {}
        for (int j = paramString.codePointAt(i);; j = 0)
        {
          localc = htF().asg(m);
          if (localc == null) {
            break label105;
          }
          localStringBuilder.appendCodePoint(localc.rzB);
          if (localc.rzC == 0) {
            break label175;
          }
          localStringBuilder.appendCodePoint(localc.rzC);
          break;
        }
        label105:
        c localc = htF().mc(m, j);
        localStringBuilder.appendCodePoint(m);
        if ((localc != null) && (localc.rzC != 0))
        {
          i = Character.charCount(localc.rzC) + i;
          localStringBuilder.appendCodePoint(localc.rzC);
        }
      }
      else
      {
        paramString = localStringBuilder.toString();
        AppMethodBeat.o(104908);
        return paramString;
      }
    }
  }
  
  public static void buq(String paramString)
  {
    AppMethodBeat.i(232929);
    htH();
    u.on(paramString, UXV);
    AppMethodBeat.o(232929);
  }
  
  /* Error */
  public static long bur(String paramString)
  {
    // Byte code:
    //   0: ldc_w 278
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 282	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore 4
    //   12: new 284	java/io/DataInputStream
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 287	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 290	java/io/DataInputStream:readInt	()I
    //   26: pop
    //   27: aload_0
    //   28: invokevirtual 294	java/io/DataInputStream:readLong	()J
    //   31: lstore_1
    //   32: aload_0
    //   33: invokevirtual 297	java/io/DataInputStream:close	()V
    //   36: aload 4
    //   38: ifnull +8 -> 46
    //   41: aload 4
    //   43: invokevirtual 300	java/io/InputStream:close	()V
    //   46: ldc_w 278
    //   49: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: lload_1
    //   53: lreturn
    //   54: astore_0
    //   55: ldc 185
    //   57: aload_0
    //   58: ldc 217
    //   60: iconst_0
    //   61: anewarray 128	java/lang/Object
    //   64: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: goto -21 -> 46
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_3
    //   73: aconst_null
    //   74: astore 4
    //   76: ldc 185
    //   78: aload_0
    //   79: ldc 217
    //   81: iconst_0
    //   82: anewarray 128	java/lang/Object
    //   85: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 297	java/io/DataInputStream:close	()V
    //   96: aload 4
    //   98: ifnull +8 -> 106
    //   101: aload 4
    //   103: invokevirtual 300	java/io/InputStream:close	()V
    //   106: ldc_w 278
    //   109: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: lconst_0
    //   113: lreturn
    //   114: astore_0
    //   115: ldc 185
    //   117: aload_0
    //   118: ldc 217
    //   120: iconst_0
    //   121: anewarray 128	java/lang/Object
    //   124: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: goto -21 -> 106
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_3
    //   133: aconst_null
    //   134: astore 4
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 297	java/io/DataInputStream:close	()V
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 300	java/io/InputStream:close	()V
    //   154: ldc_w 278
    //   157: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: astore_3
    //   163: ldc 185
    //   165: aload_3
    //   166: ldc 217
    //   168: iconst_0
    //   169: anewarray 128	java/lang/Object
    //   172: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: goto -21 -> 154
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_3
    //   181: goto -45 -> 136
    //   184: astore 5
    //   186: aload_0
    //   187: astore_3
    //   188: aload 5
    //   190: astore_0
    //   191: goto -55 -> 136
    //   194: astore_0
    //   195: goto -59 -> 136
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_3
    //   201: goto -125 -> 76
    //   204: astore 5
    //   206: aload_0
    //   207: astore_3
    //   208: aload 5
    //   210: astore_0
    //   211: goto -135 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramString	String
    //   31	22	1	l	long
    //   72	69	3	localObject1	Object
    //   162	4	3	localIOException1	java.io.IOException
    //   180	28	3	str	String
    //   10	140	4	localInputStream	java.io.InputStream
    //   184	5	5	localObject2	Object
    //   204	5	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	36	54	java/io/IOException
    //   41	46	54	java/io/IOException
    //   6	12	70	java/io/IOException
    //   92	96	114	java/io/IOException
    //   101	106	114	java/io/IOException
    //   6	12	130	finally
    //   140	144	162	java/io/IOException
    //   149	154	162	java/io/IOException
    //   12	22	178	finally
    //   22	32	184	finally
    //   76	88	194	finally
    //   12	22	198	java/io/IOException
    //   22	32	204	java/io/IOException
  }
  
  /* Error */
  public static int bus(String paramString)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 282	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: new 284	java/io/DataInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 287	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore 4
    //   23: aload_0
    //   24: astore_3
    //   25: aload_2
    //   26: invokevirtual 290	java/io/DataInputStream:readInt	()I
    //   29: istore_1
    //   30: aload_2
    //   31: invokevirtual 297	java/io/DataInputStream:close	()V
    //   34: aload_0
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 300	java/io/InputStream:close	()V
    //   42: ldc_w 303
    //   45: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iload_1
    //   49: ireturn
    //   50: astore_0
    //   51: ldc 185
    //   53: aload_0
    //   54: ldc 217
    //   56: iconst_0
    //   57: anewarray 128	java/lang/Object
    //   60: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: goto -21 -> 42
    //   66: astore 5
    //   68: aconst_null
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_2
    //   73: astore 4
    //   75: aload_0
    //   76: astore_3
    //   77: ldc 185
    //   79: aload 5
    //   81: ldc 217
    //   83: iconst_0
    //   84: anewarray 128	java/lang/Object
    //   87: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 297	java/io/DataInputStream:close	()V
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 300	java/io/InputStream:close	()V
    //   106: ldc_w 303
    //   109: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: ldc 185
    //   117: aload_0
    //   118: ldc 217
    //   120: iconst_0
    //   121: anewarray 128	java/lang/Object
    //   124: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: goto -21 -> 106
    //   130: astore_2
    //   131: aconst_null
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_0
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 297	java/io/DataInputStream:close	()V
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 300	java/io/InputStream:close	()V
    //   154: ldc_w 303
    //   157: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_2
    //   161: athrow
    //   162: astore_0
    //   163: ldc 185
    //   165: aload_0
    //   166: ldc 217
    //   168: iconst_0
    //   169: anewarray 128	java/lang/Object
    //   172: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: goto -21 -> 154
    //   178: astore_2
    //   179: aconst_null
    //   180: astore 4
    //   182: goto -46 -> 136
    //   185: astore_2
    //   186: aload_3
    //   187: astore_0
    //   188: goto -52 -> 136
    //   191: astore 5
    //   193: aconst_null
    //   194: astore_2
    //   195: goto -123 -> 72
    //   198: astore 5
    //   200: goto -128 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   29	20	1	i	int
    //   19	76	2	localDataInputStream1	java.io.DataInputStream
    //   130	31	2	localObject1	Object
    //   178	1	2	localObject2	Object
    //   185	1	2	localObject3	Object
    //   194	1	2	localObject4	Object
    //   24	163	3	str	String
    //   21	160	4	localDataInputStream2	java.io.DataInputStream
    //   66	14	5	localIOException1	java.io.IOException
    //   191	1	5	localIOException2	java.io.IOException
    //   198	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   30	34	50	java/io/IOException
    //   38	42	50	java/io/IOException
    //   6	11	66	java/io/IOException
    //   94	98	114	java/io/IOException
    //   102	106	114	java/io/IOException
    //   6	11	130	finally
    //   141	146	162	java/io/IOException
    //   150	154	162	java/io/IOException
    //   11	20	178	finally
    //   25	30	185	finally
    //   77	90	185	finally
    //   11	20	191	java/io/IOException
    //   25	30	198	java/io/IOException
  }
  
  public static boolean but(String paramString)
  {
    AppMethodBeat.i(104906);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(104906);
      return false;
    }
    paramString = paramString.toString();
    int k = paramString.length();
    int j;
    for (int i = 0; i < k; i = j)
    {
      int m = paramString.codePointAt(i);
      j = Character.charCount(m) + i;
      if (j < k) {}
      for (i = paramString.codePointAt(j); htF().asg(m) != null; i = 0)
      {
        AppMethodBeat.o(104906);
        return true;
      }
      if (htF().mc(m, i) != null)
      {
        AppMethodBeat.o(104906);
        return true;
      }
    }
    AppMethodBeat.o(104906);
    return false;
  }
  
  public static b htF()
  {
    AppMethodBeat.i(104898);
    if (UXX == null) {}
    try
    {
      UXX = new b();
      b localb = UXX;
      AppMethodBeat.o(104898);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104898);
    }
  }
  
  private static void htH()
  {
    AppMethodBeat.i(104899);
    q localq = new q(UXU);
    if (localq.ifH()) {
      localq.cFq();
    }
    if (!localq.ifE()) {
      localq.ifL();
    }
    AppMethodBeat.o(104899);
  }
  
  private static void htI()
  {
    AppMethodBeat.i(104900);
    long l = System.currentTimeMillis();
    htH();
    u.on("assets:///color_emoji", UXV);
    Log.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104900);
  }
  
  private void htJ()
  {
    AppMethodBeat.i(104909);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = LocaleUtil.loadApplicationLanguage(((Context)localObject2).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), (Context)localObject2);
    if (((String)localObject1).equals("zh_CN")) {
      localObject1 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_name_ch);
    }
    for (;;)
    {
      localObject2 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_code);
      this.UYi = new SparseArray();
      int i = 0;
      while ((i < localObject2.length) && (i < localObject1.length))
      {
        this.UYi.put(localObject2[i].charAt(0), localObject1[i]);
        i += 1;
      }
      if ((((String)localObject1).equals("zh_TW")) || (((String)localObject1).equals("zh_HK"))) {
        localObject1 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_name_tw);
      } else {
        localObject1 = ((Context)localObject2).getResources().getStringArray(a.b.emoji_name_en);
      }
    }
    AppMethodBeat.o(104909);
  }
  
  private void htK()
  {
    AppMethodBeat.i(104915);
    if ((MMApplicationContext.isMainProcess()) && (com.tencent.mm.kernel.h.aHB()))
    {
      u.deleteFile(UXV);
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      String str = com.tencent.mm.pluginsdk.k.a.a.b.lV(37, 4);
      if (!u.agG(str)) {
        break label59;
      }
      buq(str);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(104915);
      return;
      label59:
      htI();
      com.tencent.mm.pluginsdk.k.a.a.b.hii().g(37, 4, -1, false);
    }
  }
  
  private void htL()
  {
    AppMethodBeat.i(104916);
    this.rGq = new LinkedList(this.UYd.UXT);
    if ((this.rGq == null) || (this.rGq.isEmpty()))
    {
      Log.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
      AppMethodBeat.o(104916);
      return;
    }
    Iterator localIterator = this.rGq.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.rzB != 0)
      {
        SparseArray localSparseArray2 = (SparseArray)this.UYh.get(localc.rzB);
        SparseArray localSparseArray1 = localSparseArray2;
        if (localSparseArray2 == null)
        {
          localSparseArray1 = new SparseArray();
          this.UYh.append(localc.rzB, localSparseArray1);
        }
        localSparseArray1.put(localc.rzC, localc);
        if (localc.rzD != 0) {
          this.UYe.append(localc.rzD, localc);
        }
        if (localc.UYr != -1) {
          this.UYf.append(localc.UYr, localc);
        }
      }
      else
      {
        this.UYg.append(localc.UYs, localc);
      }
    }
    AppMethodBeat.o(104916);
  }
  
  public final Drawable a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(104914);
    if (paramc == null)
    {
      Log.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
      AppMethodBeat.o(104914);
      return null;
    }
    label478:
    label484:
    for (;;)
    {
      try
      {
        localBitmap = (Bitmap)this.UYj.get(paramc.bPt);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          paramc = new BitmapDrawable(MMApplicationContext.getContext().getResources(), localBitmap);
          AppMethodBeat.o(104914);
          return paramc;
        }
        if ((paramc.rzB != 0) || (this.UYc >= 1480413778780L)) {
          break label478;
        }
        arrayOfByte = u.aY("assets:///emoji/qqemoji/" + paramc.UYs + ".wxam", 0, -1);
        localBitmap = MMGIFJNIFactory.Companion.decodeThumb(arrayOfByte);
        if (localBitmap != null) {
          break label484;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(711, 20);
      }
      catch (Exception paramc)
      {
        Bitmap localBitmap;
        int j;
        int i;
        long l;
        Log.printErrStackTrace("MicroMsg.EmojiHelper", paramc, "", new Object[0]);
        AppMethodBeat.o(104914);
        return null;
      }
      if (localBitmap == null)
      {
        arrayOfByte = u.aY(UXV, paramc.bPt + this.UYa, paramc.size);
        localBitmap = MMGIFJNIFactory.Companion.decodeThumb(arrayOfByte);
        if (localBitmap != null)
        {
          localBitmap.setDensity(240);
          this.UYj.put(paramc.bPt, localBitmap);
          paramc = new BitmapDrawable(MMApplicationContext.getContext().getResources(), localBitmap);
          AppMethodBeat.o(104914);
          return paramc;
        }
        j = paramc.size;
        if (arrayOfByte == null)
        {
          i = 0;
          Log.i("MicroMsg.EmojiHelper", "bitmap is null. decode byte array failed. size:%d data length:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if (!paramBoolean) {
            continue;
          }
          htF();
          i = bus(UXV);
          htF();
          l = bur(UXV);
          Log.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", new Object[] { Integer.valueOf(this.UYb), Long.valueOf(this.UYc), Integer.valueOf(i), Long.valueOf(l) });
          if ((i == this.UYb) && (l > this.UYc))
          {
            init();
            paramc = a(paramc, false);
            AppMethodBeat.o(104914);
            return paramc;
          }
        }
        else
        {
          i = arrayOfByte.length;
          continue;
        }
        htK();
        paramc = a(paramc, false);
        AppMethodBeat.o(104914);
        return paramc;
      }
      continue;
      byte[] arrayOfByte = null;
    }
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt)
  {
    AppMethodBeat.i(232934);
    paramSpannable = b(paramSpannable, paramInt, paramPInt);
    AppMethodBeat.o(232934);
    return paramSpannable;
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt1, PInt paramPInt, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(232941);
    if ((paramSpannable == null) || (paramSpannable.length() == 0))
    {
      AppMethodBeat.o(232941);
      return paramSpannable;
    }
    Object localObject1 = paramSpannable.toString();
    LinkedList localLinkedList = new LinkedList();
    int k = Math.min(((String)localObject1).length(), paramInt3);
    paramInt3 = paramInt2;
    int i;
    int j;
    Object localObject2;
    if (paramInt3 < k)
    {
      paramInt2 = ((String)localObject1).codePointAt(paramInt3);
      i = paramInt3 + Character.charCount(paramInt2);
      if (i >= k) {
        break label176;
      }
      j = ((String)localObject1).codePointAt(i);
      localObject2 = htF().asg(paramInt2);
      if (localObject2 == null) {
        break label182;
      }
      localLinkedList.add(new a((c)localObject2, paramInt3, paramInt3 + 1, true));
      paramInt2 = i;
    }
    for (;;)
    {
      label144:
      if (localLinkedList.size() >= paramPInt.value) {
        if (localLinkedList.size() == 0)
        {
          AppMethodBeat.o(232941);
          return paramSpannable;
          label176:
          j = 0;
          break;
          label182:
          localObject2 = htF().mc(paramInt2, j);
          paramInt2 = i;
          if (localObject2 == null) {
            continue;
          }
          if ((((c)localObject2).rzC == 0) && ((127995 > j) || (j > 127999))) {
            break label356;
          }
        }
      }
    }
    label356:
    for (paramInt2 = i + Character.charCount(j);; paramInt2 = i)
    {
      localLinkedList.add(new a((c)localObject2, paramInt3, paramInt2, false));
      break label144;
      localObject1 = localLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        a(paramSpannable, htF().a(((a)localObject2).UYp, true), ((a)localObject2).start, ((a)localObject2).end, paramInt1, false);
      }
      paramPInt.value -= localLinkedList.size();
      AppMethodBeat.o(232941);
      return paramSpannable;
      paramInt3 = paramInt2;
      break;
    }
  }
  
  public final c asg(int paramInt)
  {
    AppMethodBeat.i(104912);
    if ((paramInt >= 57345) && (paramInt <= 58679))
    {
      c localc = (c)this.UYe.get(paramInt);
      AppMethodBeat.o(104912);
      return localc;
    }
    AppMethodBeat.o(104912);
    return null;
  }
  
  public final Drawable ash(int paramInt)
  {
    AppMethodBeat.i(104913);
    Drawable localDrawable = a((c)this.UYg.get(paramInt), true);
    AppMethodBeat.o(104913);
    return localDrawable;
  }
  
  public final Spannable b(Spannable paramSpannable, int paramInt, PInt paramPInt)
  {
    AppMethodBeat.i(232937);
    if (paramSpannable == null) {}
    for (int i = 0;; i = paramSpannable.toString().length())
    {
      paramSpannable = a(paramSpannable, paramInt, paramPInt, 0, i);
      AppMethodBeat.o(232937);
      return paramSpannable;
    }
  }
  
  public final String buu(String paramString)
  {
    AppMethodBeat.i(104907);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104907);
      return paramString;
    }
    if (this.UYi == null) {
      htJ();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramString.length();
    int i = 0;
    while (i < m)
    {
      int n = paramString.codePointAt(i);
      int j = i + Character.charCount(n);
      if (j < m) {}
      for (int k = paramString.codePointAt(j);; k = 0)
      {
        localObject = htF().asg(n);
        if (localObject == null) {
          break label160;
        }
        localObject = (String)this.UYi.get(((c)localObject).rzD);
        if (localObject == null) {
          break label139;
        }
        localStringBuilder.append((String)localObject);
        i = j;
        break;
      }
      label139:
      localStringBuilder.append(this.mContext.getString(a.j.app_emoji2));
      i = j;
      continue;
      label160:
      Object localObject = htF().mc(n, k);
      if (localObject != null)
      {
        i = j;
        if (((c)localObject).rzC != 0) {
          i = Character.charCount(k) + j;
        }
        localObject = (String)this.UYi.get(((c)localObject).rzD);
        if (localObject != null) {
          localStringBuilder.append((String)localObject);
        } else {
          localStringBuilder.append(this.mContext.getString(a.j.app_emoji2));
        }
      }
      else
      {
        localStringBuilder.appendCodePoint(n);
        i = j;
      }
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(104907);
    return paramString;
  }
  
  public final int getOffset()
  {
    return this.UYa;
  }
  
  public final a htG()
  {
    return this.UYd;
  }
  
  /* Error */
  public final boolean init()
  {
    // Byte code:
    //   0: ldc_w 647
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 333	java/lang/System:currentTimeMillis	()J
    //   9: lstore_1
    //   10: getstatic 87	com/tencent/mm/cl/b:UXV	Ljava/lang/String;
    //   13: invokestatic 282	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore 5
    //   18: new 284	java/io/DataInputStream
    //   21: dup
    //   22: aload 5
    //   24: invokespecial 287	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore 7
    //   29: aload 7
    //   31: astore 9
    //   33: aload 5
    //   35: astore 8
    //   37: aload_0
    //   38: aload 7
    //   40: invokevirtual 290	java/io/DataInputStream:readInt	()I
    //   43: putfield 567	com/tencent/mm/cl/b:UYb	I
    //   46: aload 7
    //   48: astore 9
    //   50: aload 5
    //   52: astore 8
    //   54: aload_0
    //   55: aload 7
    //   57: invokevirtual 294	java/io/DataInputStream:readLong	()J
    //   60: putfield 106	com/tencent/mm/cl/b:UYc	J
    //   63: aload 7
    //   65: astore 9
    //   67: aload 5
    //   69: astore 8
    //   71: aload_0
    //   72: aload 7
    //   74: invokevirtual 290	java/io/DataInputStream:readInt	()I
    //   77: putfield 649	com/tencent/mm/cl/b:UXZ	I
    //   80: aload 7
    //   82: astore 9
    //   84: aload 5
    //   86: astore 8
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 649	com/tencent/mm/cl/b:UXZ	I
    //   93: iconst_4
    //   94: iadd
    //   95: bipush 8
    //   97: iadd
    //   98: iconst_4
    //   99: iadd
    //   100: putfield 541	com/tencent/mm/cl/b:UYa	I
    //   103: aload 7
    //   105: astore 9
    //   107: aload 5
    //   109: astore 8
    //   111: aload_0
    //   112: getfield 649	com/tencent/mm/cl/b:UXZ	I
    //   115: ifle +23 -> 138
    //   118: aload 7
    //   120: astore 9
    //   122: aload 5
    //   124: astore 8
    //   126: aload_0
    //   127: getfield 649	com/tencent/mm/cl/b:UXZ	I
    //   130: aload 7
    //   132: invokevirtual 652	java/io/DataInputStream:available	()I
    //   135: if_icmple +148 -> 283
    //   138: aload 7
    //   140: astore 9
    //   142: aload 5
    //   144: astore 8
    //   146: ldc 185
    //   148: ldc_w 654
    //   151: iconst_1
    //   152: anewarray 128	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_0
    //   158: getfield 649	com/tencent/mm/cl/b:UXZ	I
    //   161: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: invokestatic 657	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 7
    //   170: astore 9
    //   172: aload 5
    //   174: astore 8
    //   176: aload_0
    //   177: invokespecial 571	com/tencent/mm/cl/b:htK	()V
    //   180: iconst_0
    //   181: istore_3
    //   182: aload 7
    //   184: astore 9
    //   186: aload 5
    //   188: astore 8
    //   190: ldc 185
    //   192: ldc_w 659
    //   195: iconst_1
    //   196: anewarray 128	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: invokestatic 333	java/lang/System:currentTimeMillis	()J
    //   204: lload_1
    //   205: lsub
    //   206: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   209: aastore
    //   210: invokestatic 559	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload 7
    //   215: invokevirtual 297	java/io/DataInputStream:close	()V
    //   218: iload_3
    //   219: istore 4
    //   221: aload 5
    //   223: ifnull +11 -> 234
    //   226: aload 5
    //   228: invokevirtual 300	java/io/InputStream:close	()V
    //   231: iload_3
    //   232: istore 4
    //   234: ldc 185
    //   236: ldc_w 661
    //   239: iconst_3
    //   240: anewarray 128	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_0
    //   246: getfield 567	com/tencent/mm/cl/b:UYb	I
    //   249: invokestatic 557	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: aload_0
    //   256: getfield 106	com/tencent/mm/cl/b:UYc	J
    //   259: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: iload 4
    //   267: invokestatic 666	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   270: aastore
    //   271: invokestatic 559	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: ldc_w 647
    //   277: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 4
    //   282: ireturn
    //   283: aload 7
    //   285: astore 9
    //   287: aload 5
    //   289: astore 8
    //   291: aload_0
    //   292: getfield 649	com/tencent/mm/cl/b:UXZ	I
    //   295: newarray byte
    //   297: astore 6
    //   299: aload 7
    //   301: astore 9
    //   303: aload 5
    //   305: astore 8
    //   307: aload 7
    //   309: aload 6
    //   311: invokevirtual 670	java/io/DataInputStream:read	([B)I
    //   314: pop
    //   315: aload 7
    //   317: astore 9
    //   319: aload 5
    //   321: astore 8
    //   323: aload_0
    //   324: getfield 111	com/tencent/mm/cl/b:UYd	Lcom/tencent/mm/cl/a;
    //   327: aload 6
    //   329: invokevirtual 674	com/tencent/mm/cl/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   332: pop
    //   333: aload 7
    //   335: astore 9
    //   337: aload 5
    //   339: astore 8
    //   341: aload_0
    //   342: invokespecial 676	com/tencent/mm/cl/b:htL	()V
    //   345: aload 7
    //   347: astore 9
    //   349: aload 5
    //   351: astore 8
    //   353: aload_0
    //   354: iconst_1
    //   355: putfield 139	com/tencent/mm/cl/b:UYk	Z
    //   358: iconst_1
    //   359: istore_3
    //   360: goto -178 -> 182
    //   363: astore 5
    //   365: ldc 185
    //   367: aload 5
    //   369: ldc 217
    //   371: iconst_0
    //   372: anewarray 128	java/lang/Object
    //   375: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: iload_3
    //   379: istore 4
    //   381: goto -147 -> 234
    //   384: astore 6
    //   386: iconst_0
    //   387: istore_3
    //   388: aconst_null
    //   389: astore 7
    //   391: aconst_null
    //   392: astore 5
    //   394: aload 7
    //   396: astore 9
    //   398: aload 5
    //   400: astore 8
    //   402: ldc 185
    //   404: aload 6
    //   406: ldc 217
    //   408: iconst_0
    //   409: anewarray 128	java/lang/Object
    //   412: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: aload 7
    //   417: ifnull +8 -> 425
    //   420: aload 7
    //   422: invokevirtual 297	java/io/DataInputStream:close	()V
    //   425: iload_3
    //   426: istore 4
    //   428: aload 5
    //   430: ifnull -196 -> 234
    //   433: aload 5
    //   435: invokevirtual 300	java/io/InputStream:close	()V
    //   438: iload_3
    //   439: istore 4
    //   441: goto -207 -> 234
    //   444: astore 5
    //   446: ldc 185
    //   448: aload 5
    //   450: ldc 217
    //   452: iconst_0
    //   453: anewarray 128	java/lang/Object
    //   456: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: iload_3
    //   460: istore 4
    //   462: goto -228 -> 234
    //   465: astore 6
    //   467: aconst_null
    //   468: astore 9
    //   470: aconst_null
    //   471: astore 5
    //   473: aload 9
    //   475: ifnull +8 -> 483
    //   478: aload 9
    //   480: invokevirtual 297	java/io/DataInputStream:close	()V
    //   483: aload 5
    //   485: ifnull +8 -> 493
    //   488: aload 5
    //   490: invokevirtual 300	java/io/InputStream:close	()V
    //   493: ldc_w 647
    //   496: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   499: aload 6
    //   501: athrow
    //   502: astore 5
    //   504: ldc 185
    //   506: aload 5
    //   508: ldc 217
    //   510: iconst_0
    //   511: anewarray 128	java/lang/Object
    //   514: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   517: goto -24 -> 493
    //   520: astore 6
    //   522: aconst_null
    //   523: astore 9
    //   525: goto -52 -> 473
    //   528: astore 6
    //   530: aload 8
    //   532: astore 5
    //   534: goto -61 -> 473
    //   537: astore 6
    //   539: iconst_0
    //   540: istore_3
    //   541: aconst_null
    //   542: astore 7
    //   544: goto -150 -> 394
    //   547: astore 6
    //   549: iconst_0
    //   550: istore_3
    //   551: goto -157 -> 394
    //   554: astore 6
    //   556: goto -162 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	b
    //   9	196	1	l	long
    //   181	370	3	bool1	boolean
    //   219	242	4	bool2	boolean
    //   16	334	5	localInputStream	java.io.InputStream
    //   363	5	5	localIOException1	java.io.IOException
    //   392	42	5	localObject1	Object
    //   444	5	5	localIOException2	java.io.IOException
    //   471	18	5	localObject2	Object
    //   502	5	5	localIOException3	java.io.IOException
    //   532	1	5	localObject3	Object
    //   297	31	6	arrayOfByte	byte[]
    //   384	21	6	localException1	Exception
    //   465	35	6	localObject4	Object
    //   520	1	6	localObject5	Object
    //   528	1	6	localObject6	Object
    //   537	1	6	localException2	Exception
    //   547	1	6	localException3	Exception
    //   554	1	6	localException4	Exception
    //   27	516	7	localDataInputStream1	java.io.DataInputStream
    //   35	496	8	localObject7	Object
    //   31	493	9	localDataInputStream2	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   213	218	363	java/io/IOException
    //   226	231	363	java/io/IOException
    //   6	18	384	java/lang/Exception
    //   420	425	444	java/io/IOException
    //   433	438	444	java/io/IOException
    //   6	18	465	finally
    //   478	483	502	java/io/IOException
    //   488	493	502	java/io/IOException
    //   18	29	520	finally
    //   37	46	528	finally
    //   54	63	528	finally
    //   71	80	528	finally
    //   88	103	528	finally
    //   111	118	528	finally
    //   126	138	528	finally
    //   146	168	528	finally
    //   176	180	528	finally
    //   190	213	528	finally
    //   291	299	528	finally
    //   307	315	528	finally
    //   323	333	528	finally
    //   341	345	528	finally
    //   353	358	528	finally
    //   402	415	528	finally
    //   18	29	537	java/lang/Exception
    //   37	46	547	java/lang/Exception
    //   54	63	547	java/lang/Exception
    //   71	80	547	java/lang/Exception
    //   88	103	547	java/lang/Exception
    //   111	118	547	java/lang/Exception
    //   126	138	547	java/lang/Exception
    //   146	168	547	java/lang/Exception
    //   176	180	547	java/lang/Exception
    //   291	299	547	java/lang/Exception
    //   307	315	547	java/lang/Exception
    //   323	333	547	java/lang/Exception
    //   341	345	547	java/lang/Exception
    //   353	358	547	java/lang/Exception
    //   190	213	554	java/lang/Exception
  }
  
  public final c mc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104911);
    if ((this.UYl == null) || (this.UYl.isEmpty()) || (this.UYk))
    {
      this.UYl = new LinkedList(this.UYd.UXS);
      this.UYk = false;
    }
    if ((this.UYl == null) || (this.UYl.isEmpty()))
    {
      AppMethodBeat.o(104911);
      return null;
    }
    Object localObject = this.UYl.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((paramInt1 < locald.min) || (paramInt1 > locald.max)) {
        break label230;
      }
      i = 1;
    }
    label230:
    for (;;)
    {
      break;
      if (i == 0)
      {
        AppMethodBeat.o(104911);
        return null;
      }
      localObject = (SparseArray)this.UYh.get(paramInt1);
      if (localObject != null)
      {
        if ((((SparseArray)localObject).size() == 1) && (((SparseArray)localObject).get(0) != null))
        {
          localObject = (c)((SparseArray)localObject).get(0);
          AppMethodBeat.o(104911);
          return localObject;
        }
        localObject = (c)((SparseArray)localObject).get(paramInt2);
        AppMethodBeat.o(104911);
        return localObject;
      }
      AppMethodBeat.o(104911);
      return null;
    }
  }
  
  final class a
  {
    c UYp;
    boolean UYq = false;
    int end;
    int start;
    
    public a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.UYp = paramc;
      this.start = paramInt1;
      this.end = paramInt2;
      this.UYq = paramBoolean;
    }
  }
  
  static final class b
    extends IListener<mv>
  {
    private final WeakReference<b> kNt;
    
    public b(b paramb)
    {
      AppMethodBeat.i(228403);
      this.kNt = new WeakReference(paramb);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(228403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cl.b
 * JD-Core Version:    0.7.0.1
 */