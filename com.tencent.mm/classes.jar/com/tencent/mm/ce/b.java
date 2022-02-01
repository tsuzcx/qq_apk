package com.tencent.mm.ce;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends com.tencent.mm.api.f
{
  public static final String NKt;
  public static final String NKu;
  private static final boolean NKv;
  private static b NKw;
  private int NKA;
  public long NKB;
  private a NKC;
  private SparseArray<c> NKD;
  public SparseArray<c> NKE;
  private SparseArray<c> NKF;
  private SparseArray<SparseArray<c>> NKG;
  private SparseArray<String> NKH;
  private com.tencent.mm.b.f<String, Bitmap> NKI;
  private boolean NKJ;
  private LinkedList<d> NKK;
  private final Spannable.Factory NKL;
  private int NKx;
  private int NKy;
  private int NKz;
  private Context mContext;
  private LinkedList<c> oEG;
  
  static
  {
    AppMethodBeat.i(104917);
    NKt = com.tencent.mm.loader.j.b.aKA() + "app_font";
    NKu = NKt + "/color_emoji";
    if (Build.VERSION.SDK_INT < 19) {}
    for (boolean bool = true;; bool = false)
    {
      NKv = bool;
      AppMethodBeat.o(104917);
      return;
    }
  }
  
  private b()
  {
    AppMethodBeat.i(104897);
    this.NKx = 0;
    this.NKB = 0L;
    this.NKC = new a();
    this.NKD = new SparseArray();
    this.NKE = new SparseArray();
    this.NKF = new SparseArray();
    this.NKG = new SparseArray();
    this.NKH = null;
    this.NKI = new com.tencent.mm.memory.a.b(200, getClass());
    this.NKJ = false;
    this.NKL = new Spannable.Factory()
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
    if (!s.YS(NKu)) {
      gxL();
    }
    for (;;)
    {
      init();
      if (!com.tencent.mm.cb.a.jk(this.mContext)) {
        break;
      }
      this.NKx = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4);
      AppMethodBeat.o(104897);
      return;
      Log.i("MicroMsg.EmojiHelper", "emoji color file exist.");
    }
    this.NKx = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
    AppMethodBeat.o(104897);
  }
  
  public static String alW(String paramString)
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
          localc = gxI().ajN(m);
          if (localc == null) {
            break label105;
          }
          localStringBuilder.appendCodePoint(localc.owH);
          if (localc.owI == 0) {
            break label175;
          }
          localStringBuilder.appendCodePoint(localc.owI);
          break;
        }
        label105:
        c localc = gxI().kK(m, j);
        localStringBuilder.appendCodePoint(m);
        if ((localc != null) && (localc.owI != 0))
        {
          i = Character.charCount(localc.owI) + i;
          localStringBuilder.appendCodePoint(localc.owI);
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
  
  public static void bhX(String paramString)
  {
    AppMethodBeat.i(199814);
    gxK();
    s.nw(paramString, NKu);
    AppMethodBeat.o(199814);
  }
  
  /* Error */
  public static long bhY(String paramString)
  {
    // Byte code:
    //   0: ldc 234
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 238	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore 4
    //   11: new 240	java/io/DataInputStream
    //   14: dup
    //   15: aload 4
    //   17: invokespecial 243	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 246	java/io/DataInputStream:readInt	()I
    //   25: pop
    //   26: aload_0
    //   27: invokevirtual 250	java/io/DataInputStream:readLong	()J
    //   30: lstore_1
    //   31: aload_0
    //   32: invokevirtual 253	java/io/DataInputStream:close	()V
    //   35: aload 4
    //   37: ifnull +8 -> 45
    //   40: aload 4
    //   42: invokevirtual 256	java/io/InputStream:close	()V
    //   45: ldc 234
    //   47: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: lload_1
    //   51: lreturn
    //   52: astore_0
    //   53: ldc 170
    //   55: aload_0
    //   56: ldc_w 258
    //   59: iconst_0
    //   60: anewarray 121	java/lang/Object
    //   63: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: goto -21 -> 45
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_3
    //   72: aconst_null
    //   73: astore 4
    //   75: ldc 170
    //   77: aload_0
    //   78: ldc_w 258
    //   81: iconst_0
    //   82: anewarray 121	java/lang/Object
    //   85: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 253	java/io/DataInputStream:close	()V
    //   96: aload 4
    //   98: ifnull +8 -> 106
    //   101: aload 4
    //   103: invokevirtual 256	java/io/InputStream:close	()V
    //   106: ldc 234
    //   108: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: lconst_0
    //   112: lreturn
    //   113: astore_0
    //   114: ldc 170
    //   116: aload_0
    //   117: ldc_w 258
    //   120: iconst_0
    //   121: anewarray 121	java/lang/Object
    //   124: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: goto -21 -> 106
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_3
    //   133: aconst_null
    //   134: astore 4
    //   136: aload_3
    //   137: ifnull +7 -> 144
    //   140: aload_3
    //   141: invokevirtual 253	java/io/DataInputStream:close	()V
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 256	java/io/InputStream:close	()V
    //   154: ldc 234
    //   156: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_0
    //   160: athrow
    //   161: astore_3
    //   162: ldc 170
    //   164: aload_3
    //   165: ldc_w 258
    //   168: iconst_0
    //   169: anewarray 121	java/lang/Object
    //   172: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   201: goto -126 -> 75
    //   204: astore 5
    //   206: aload_0
    //   207: astore_3
    //   208: aload 5
    //   210: astore_0
    //   211: goto -136 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramString	String
    //   30	21	1	l	long
    //   71	70	3	localObject1	Object
    //   161	4	3	localIOException1	java.io.IOException
    //   180	28	3	str	String
    //   9	141	4	localInputStream	java.io.InputStream
    //   184	5	5	localObject2	Object
    //   204	5	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	35	52	java/io/IOException
    //   40	45	52	java/io/IOException
    //   5	11	69	java/io/IOException
    //   92	96	113	java/io/IOException
    //   101	106	113	java/io/IOException
    //   5	11	130	finally
    //   140	144	161	java/io/IOException
    //   149	154	161	java/io/IOException
    //   11	21	178	finally
    //   21	31	184	finally
    //   75	88	194	finally
    //   11	21	198	java/io/IOException
    //   21	31	204	java/io/IOException
  }
  
  /* Error */
  public static int bhZ(String paramString)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 238	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: new 240	java/io/DataInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 243	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore 4
    //   23: aload_0
    //   24: astore_3
    //   25: aload_2
    //   26: invokevirtual 246	java/io/DataInputStream:readInt	()I
    //   29: istore_1
    //   30: aload_2
    //   31: invokevirtual 253	java/io/DataInputStream:close	()V
    //   34: aload_0
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 256	java/io/InputStream:close	()V
    //   42: ldc_w 265
    //   45: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iload_1
    //   49: ireturn
    //   50: astore_0
    //   51: ldc 170
    //   53: aload_0
    //   54: ldc_w 258
    //   57: iconst_0
    //   58: anewarray 121	java/lang/Object
    //   61: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -22 -> 42
    //   67: astore 5
    //   69: aconst_null
    //   70: astore_2
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_2
    //   74: astore 4
    //   76: aload_0
    //   77: astore_3
    //   78: ldc 170
    //   80: aload 5
    //   82: ldc_w 258
    //   85: iconst_0
    //   86: anewarray 121	java/lang/Object
    //   89: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 253	java/io/DataInputStream:close	()V
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 256	java/io/InputStream:close	()V
    //   108: ldc_w 265
    //   111: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: ldc 170
    //   119: aload_0
    //   120: ldc_w 258
    //   123: iconst_0
    //   124: anewarray 121	java/lang/Object
    //   127: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: goto -22 -> 108
    //   133: astore_2
    //   134: aconst_null
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_0
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 253	java/io/DataInputStream:close	()V
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 256	java/io/InputStream:close	()V
    //   157: ldc_w 265
    //   160: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore_0
    //   166: ldc 170
    //   168: aload_0
    //   169: ldc_w 258
    //   172: iconst_0
    //   173: anewarray 121	java/lang/Object
    //   176: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: goto -22 -> 157
    //   182: astore_2
    //   183: aconst_null
    //   184: astore 4
    //   186: goto -47 -> 139
    //   189: astore_2
    //   190: aload_3
    //   191: astore_0
    //   192: goto -53 -> 139
    //   195: astore 5
    //   197: aconst_null
    //   198: astore_2
    //   199: goto -126 -> 73
    //   202: astore 5
    //   204: goto -131 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString	String
    //   29	20	1	i	int
    //   19	78	2	localDataInputStream1	java.io.DataInputStream
    //   133	31	2	localObject1	Object
    //   182	1	2	localObject2	Object
    //   189	1	2	localObject3	Object
    //   198	1	2	localObject4	Object
    //   24	167	3	str	String
    //   21	164	4	localDataInputStream2	java.io.DataInputStream
    //   67	14	5	localIOException1	java.io.IOException
    //   195	1	5	localIOException2	java.io.IOException
    //   202	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   30	34	50	java/io/IOException
    //   38	42	50	java/io/IOException
    //   6	11	67	java/io/IOException
    //   96	100	116	java/io/IOException
    //   104	108	116	java/io/IOException
    //   6	11	133	finally
    //   144	149	165	java/io/IOException
    //   153	157	165	java/io/IOException
    //   11	20	182	finally
    //   25	30	189	finally
    //   78	92	189	finally
    //   11	20	195	java/io/IOException
    //   25	30	202	java/io/IOException
  }
  
  public static boolean bia(String paramString)
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
      for (i = paramString.codePointAt(j); gxI().ajN(m) != null; i = 0)
      {
        AppMethodBeat.o(104906);
        return true;
      }
      if (gxI().kK(m, i) != null)
      {
        AppMethodBeat.o(104906);
        return true;
      }
    }
    AppMethodBeat.o(104906);
    return false;
  }
  
  public static b gxI()
  {
    AppMethodBeat.i(104898);
    if (NKw == null) {}
    try
    {
      NKw = new b();
      b localb = NKw;
      AppMethodBeat.o(104898);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104898);
    }
  }
  
  private static void gxK()
  {
    AppMethodBeat.i(104899);
    o localo = new o(NKt);
    if (localo.isFile()) {
      localo.delete();
    }
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(104899);
  }
  
  private static void gxL()
  {
    AppMethodBeat.i(104900);
    long l = System.currentTimeMillis();
    gxK();
    s.nw("assets:///color_emoji", NKu);
    Log.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104900);
  }
  
  private void gxM()
  {
    AppMethodBeat.i(104909);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = LocaleUtil.loadApplicationLanguage(((Context)localObject2).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), (Context)localObject2);
    if (((String)localObject1).equals("zh_CN")) {
      localObject1 = ((Context)localObject2).getResources().getStringArray(2130903048);
    }
    for (;;)
    {
      localObject2 = ((Context)localObject2).getResources().getStringArray(2130903047);
      this.NKH = new SparseArray();
      int i = 0;
      while ((i < localObject2.length) && (i < localObject1.length))
      {
        this.NKH.put(localObject2[i].charAt(0), localObject1[i]);
        i += 1;
      }
      if ((((String)localObject1).equals("zh_TW")) || (((String)localObject1).equals("zh_HK"))) {
        localObject1 = ((Context)localObject2).getResources().getStringArray(2130903050);
      } else {
        localObject1 = ((Context)localObject2).getResources().getStringArray(2130903049);
      }
    }
    AppMethodBeat.o(104909);
  }
  
  private void gxN()
  {
    AppMethodBeat.i(104915);
    if ((MMApplicationContext.isMainProcess()) && (g.aAc()))
    {
      s.deleteFile(NKu);
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      String str = com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 4);
      if (!s.YS(str)) {
        break label59;
      }
      bhX(str);
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(104915);
      return;
      label59:
      gxL();
      com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(37, 4, -1, false);
    }
  }
  
  private void gxO()
  {
    AppMethodBeat.i(104916);
    this.oEG = new LinkedList(this.NKC.NKs);
    if ((this.oEG == null) || (this.oEG.isEmpty()))
    {
      Log.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
      AppMethodBeat.o(104916);
      return;
    }
    Iterator localIterator = this.oEG.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.owH != 0)
      {
        SparseArray localSparseArray2 = (SparseArray)this.NKG.get(localc.owH);
        SparseArray localSparseArray1 = localSparseArray2;
        if (localSparseArray2 == null)
        {
          localSparseArray1 = new SparseArray();
          this.NKG.append(localc.owH, localSparseArray1);
        }
        localSparseArray1.put(localc.owI, localc);
        if (localc.owJ != 0) {
          this.NKD.append(localc.owJ, localc);
        }
        if (localc.NKP != -1) {
          this.NKE.append(localc.NKP, localc);
        }
      }
      else
      {
        this.NKF.append(localc.NKQ, localc);
      }
    }
    AppMethodBeat.o(104916);
  }
  
  public final Drawable Al(int paramInt)
  {
    AppMethodBeat.i(104913);
    Drawable localDrawable = a((c)this.NKF.get(paramInt), true);
    AppMethodBeat.o(104913);
    return localDrawable;
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
    label499:
    label505:
    for (;;)
    {
      try
      {
        localObject = (Bitmap)this.NKI.get(paramc.bNu);
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
        {
          paramc = new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject);
          AppMethodBeat.o(104914);
          return paramc;
        }
        if ((paramc.owH != 0) || (this.NKB >= 1480413778780L)) {
          break label499;
        }
        arrayOfByte = s.aW("assets:///emoji/qqemoji/" + paramc.NKQ + ".wxam", 0, -1);
        localObject = MMGIFJNIFactory.Companion.decodeThumb(arrayOfByte);
        if (localObject != null) {
          break label505;
        }
        h.CyF.dN(711, 20);
      }
      catch (Exception paramc)
      {
        Object localObject;
        int j;
        int i;
        long l;
        Log.printErrStackTrace("MicroMsg.EmojiHelper", paramc, "", new Object[0]);
        AppMethodBeat.o(104914);
        return null;
      }
      if (localObject == null)
      {
        arrayOfByte = s.aW(NKu, paramc.bNu + this.NKz, paramc.size);
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
        localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, (BitmapFactory.Options)localObject);
        if (localObject != null)
        {
          ((Bitmap)localObject).setDensity(240);
          this.NKI.put(paramc.bNu, localObject);
          paramc = new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject);
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
          gxI();
          i = bhZ(NKu);
          gxI();
          l = bhY(NKu);
          Log.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", new Object[] { Integer.valueOf(this.NKA), Long.valueOf(this.NKB), Integer.valueOf(i), Long.valueOf(l) });
          if ((i == this.NKA) && (l > this.NKB))
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
        gxN();
        paramc = a(paramc, false);
        AppMethodBeat.o(104914);
        return paramc;
      }
      continue;
      byte[] arrayOfByte = null;
    }
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(104905);
    if ((paramSpannable == null) || (paramSpannable.length() == 0))
    {
      AppMethodBeat.o(104905);
      return paramSpannable;
    }
    Object localObject1 = paramSpannable.toString();
    LinkedList localLinkedList = new LinkedList();
    int j = 0;
    int n = ((String)localObject1).length();
    int k;
    int m;
    Object localObject2;
    if (j < n)
    {
      i = ((String)localObject1).codePointAt(j);
      k = j + Character.charCount(i);
      if (k >= n) {
        break label170;
      }
      m = ((String)localObject1).codePointAt(k);
      localObject2 = gxI().ajN(i);
      if (localObject2 == null) {
        break label176;
      }
      localLinkedList.add(new a((c)localObject2, j, j + 1, true));
      i = k;
    }
    for (;;)
    {
      label138:
      if (localLinkedList.size() >= paramPInt.value) {
        if (localLinkedList.size() == 0)
        {
          AppMethodBeat.o(104905);
          return paramSpannable;
          label170:
          m = 0;
          break;
          label176:
          localObject2 = gxI().kK(i, m);
          i = k;
          if (localObject2 == null) {
            continue;
          }
          if ((((c)localObject2).owI == 0) && ((127995 > m) || (m > 127999))) {
            break label510;
          }
        }
      }
    }
    label510:
    for (int i = k + Character.charCount(m);; i = k)
    {
      localLinkedList.add(new a((c)localObject2, j, i, false));
      break label138;
      if (NKv)
      {
        paramSpannable = new StringBuilder((String)localObject1);
        localObject1 = localLinkedList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (!((a)localObject2).NKO) {
            if ((((a)localObject2).NKN.owJ != 0) && (((a)localObject2).end - ((a)localObject2).start == 1)) {
              paramSpannable.replace(((a)localObject2).start, ((a)localObject2).end, String.valueOf((char)((a)localObject2).NKN.owJ));
            } else {
              paramSpannable.replace(((a)localObject2).start, ((a)localObject2).end, "....".substring(0, ((a)localObject2).end - ((a)localObject2).start));
            }
          }
        }
        paramSpannable = paramFactory.newSpannable(paramSpannable.toString());
      }
      for (;;)
      {
        paramFactory = localLinkedList.iterator();
        while (paramFactory.hasNext())
        {
          localObject1 = (a)paramFactory.next();
          a(paramSpannable, gxI().a(((a)localObject1).NKN, true), ((a)localObject1).start, ((a)localObject1).end, paramInt);
        }
        paramPInt.value -= localLinkedList.size();
        AppMethodBeat.o(104905);
        return paramSpannable;
      }
      j = i;
      break;
    }
  }
  
  public final SpannableString a(SpannableString paramSpannableString, int paramInt, PInt paramPInt)
  {
    AppMethodBeat.i(104904);
    paramSpannableString = (SpannableString)a(paramSpannableString, paramInt, paramPInt, this.NKL);
    AppMethodBeat.o(104904);
    return paramSpannableString;
  }
  
  public final void a(Spannable paramSpannable, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104910);
    int i = (int)(paramInt3 * 1.3F);
    paramInt3 = (int)(paramInt3 * 1.3F);
    try
    {
      paramDrawable.setBounds(0, 0, i, paramInt3);
      paramDrawable = new com.tencent.mm.ui.widget.a(paramDrawable);
      paramDrawable.QBM = this.NKx;
      paramSpannable.setSpan(paramDrawable, paramInt1, paramInt2, 33);
      AppMethodBeat.o(104910);
      return;
    }
    catch (Exception paramSpannable)
    {
      Log.printErrStackTrace("MicroMsg.EmojiHelper", paramSpannable, "", new Object[0]);
      AppMethodBeat.o(104910);
    }
  }
  
  public final c ajN(int paramInt)
  {
    AppMethodBeat.i(104912);
    if ((paramInt >= 57345) && (paramInt <= 58679))
    {
      c localc = (c)this.NKD.get(paramInt);
      AppMethodBeat.o(104912);
      return localc;
    }
    AppMethodBeat.o(104912);
    return null;
  }
  
  public final String bib(String paramString)
  {
    AppMethodBeat.i(104907);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104907);
      return paramString;
    }
    if (this.NKH == null) {
      gxM();
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
        localObject = gxI().ajN(n);
        if (localObject == null) {
          break label160;
        }
        localObject = (String)this.NKH.get(((c)localObject).owJ);
        if (localObject == null) {
          break label139;
        }
        localStringBuilder.append((String)localObject);
        i = j;
        break;
      }
      label139:
      localStringBuilder.append(this.mContext.getString(2131755794));
      i = j;
      continue;
      label160:
      Object localObject = gxI().kK(n, k);
      if (localObject != null)
      {
        i = j;
        if (((c)localObject).owI != 0) {
          i = Character.charCount(k) + j;
        }
        localObject = (String)this.NKH.get(((c)localObject).owJ);
        if (localObject != null) {
          localStringBuilder.append((String)localObject);
        } else {
          localStringBuilder.append(this.mContext.getString(2131755794));
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
  
  public final c bic(String paramString)
  {
    AppMethodBeat.i(177034);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
      AppMethodBeat.o(177034);
      return null;
    }
    int i = paramString.codePointAt(0);
    if (ajN(i) != null)
    {
      paramString = ajN(i);
      AppMethodBeat.o(177034);
      return paramString;
    }
    paramString = kK(i, 0);
    AppMethodBeat.o(177034);
    return paramString;
  }
  
  public final int getOffset()
  {
    return this.NKz;
  }
  
  public final a gxJ()
  {
    return this.NKC;
  }
  
  /* Error */
  public final boolean init()
  {
    // Byte code:
    //   0: ldc_w 655
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   9: lstore_1
    //   10: getstatic 82	com/tencent/mm/ce/b:NKu	Ljava/lang/String;
    //   13: invokestatic 238	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore 5
    //   18: new 240	java/io/DataInputStream
    //   21: dup
    //   22: aload 5
    //   24: invokespecial 243	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore 7
    //   29: aload 7
    //   31: astore 9
    //   33: aload 5
    //   35: astore 8
    //   37: aload_0
    //   38: aload 7
    //   40: invokevirtual 246	java/io/DataInputStream:readInt	()I
    //   43: putfield 542	com/tencent/mm/ce/b:NKA	I
    //   46: aload 7
    //   48: astore 9
    //   50: aload 5
    //   52: astore 8
    //   54: aload_0
    //   55: aload 7
    //   57: invokevirtual 250	java/io/DataInputStream:readLong	()J
    //   60: putfield 99	com/tencent/mm/ce/b:NKB	J
    //   63: aload 7
    //   65: astore 9
    //   67: aload 5
    //   69: astore 8
    //   71: aload_0
    //   72: aload 7
    //   74: invokevirtual 246	java/io/DataInputStream:readInt	()I
    //   77: putfield 657	com/tencent/mm/ce/b:NKy	I
    //   80: aload 7
    //   82: astore 9
    //   84: aload 5
    //   86: astore 8
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 657	com/tencent/mm/ce/b:NKy	I
    //   93: iconst_4
    //   94: iadd
    //   95: bipush 8
    //   97: iadd
    //   98: iconst_4
    //   99: iadd
    //   100: putfield 498	com/tencent/mm/ce/b:NKz	I
    //   103: aload 7
    //   105: astore 9
    //   107: aload 5
    //   109: astore 8
    //   111: aload_0
    //   112: getfield 657	com/tencent/mm/ce/b:NKy	I
    //   115: ifle +23 -> 138
    //   118: aload 7
    //   120: astore 9
    //   122: aload 5
    //   124: astore 8
    //   126: aload_0
    //   127: getfield 657	com/tencent/mm/ce/b:NKy	I
    //   130: aload 7
    //   132: invokevirtual 660	java/io/DataInputStream:available	()I
    //   135: if_icmple +148 -> 283
    //   138: aload 7
    //   140: astore 9
    //   142: aload 5
    //   144: astore 8
    //   146: ldc 170
    //   148: ldc_w 662
    //   151: iconst_1
    //   152: anewarray 121	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_0
    //   158: getfield 657	com/tencent/mm/ce/b:NKy	I
    //   161: invokestatic 532	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: invokestatic 665	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 7
    //   170: astore 9
    //   172: aload 5
    //   174: astore 8
    //   176: aload_0
    //   177: invokespecial 544	com/tencent/mm/ce/b:gxN	()V
    //   180: iconst_0
    //   181: istore_3
    //   182: aload 7
    //   184: astore 9
    //   186: aload 5
    //   188: astore 8
    //   190: ldc 170
    //   192: ldc_w 667
    //   195: iconst_1
    //   196: anewarray 121	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   204: lload_1
    //   205: lsub
    //   206: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   209: aastore
    //   210: invokestatic 534	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload 7
    //   215: invokevirtual 253	java/io/DataInputStream:close	()V
    //   218: iload_3
    //   219: istore 4
    //   221: aload 5
    //   223: ifnull +11 -> 234
    //   226: aload 5
    //   228: invokevirtual 256	java/io/InputStream:close	()V
    //   231: iload_3
    //   232: istore 4
    //   234: ldc 170
    //   236: ldc_w 669
    //   239: iconst_3
    //   240: anewarray 121	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_0
    //   246: getfield 542	com/tencent/mm/ce/b:NKA	I
    //   249: invokestatic 532	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: aload_0
    //   256: getfield 99	com/tencent/mm/ce/b:NKB	J
    //   259: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: iload 4
    //   267: invokestatic 674	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   270: aastore
    //   271: invokestatic 534	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: ldc_w 655
    //   277: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 4
    //   282: ireturn
    //   283: aload 7
    //   285: astore 9
    //   287: aload 5
    //   289: astore 8
    //   291: aload_0
    //   292: getfield 657	com/tencent/mm/ce/b:NKy	I
    //   295: newarray byte
    //   297: astore 6
    //   299: aload 7
    //   301: astore 9
    //   303: aload 5
    //   305: astore 8
    //   307: aload 7
    //   309: aload 6
    //   311: invokevirtual 678	java/io/DataInputStream:read	([B)I
    //   314: pop
    //   315: aload 7
    //   317: astore 9
    //   319: aload 5
    //   321: astore 8
    //   323: aload_0
    //   324: getfield 104	com/tencent/mm/ce/b:NKC	Lcom/tencent/mm/ce/a;
    //   327: aload 6
    //   329: invokevirtual 682	com/tencent/mm/ce/a:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   332: pop
    //   333: aload 7
    //   335: astore 9
    //   337: aload 5
    //   339: astore 8
    //   341: aload_0
    //   342: invokespecial 684	com/tencent/mm/ce/b:gxO	()V
    //   345: aload 7
    //   347: astore 9
    //   349: aload 5
    //   351: astore 8
    //   353: aload_0
    //   354: iconst_1
    //   355: putfield 132	com/tencent/mm/ce/b:NKJ	Z
    //   358: iconst_1
    //   359: istore_3
    //   360: goto -178 -> 182
    //   363: astore 5
    //   365: ldc 170
    //   367: aload 5
    //   369: ldc_w 258
    //   372: iconst_0
    //   373: anewarray 121	java/lang/Object
    //   376: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: iload_3
    //   380: istore 4
    //   382: goto -148 -> 234
    //   385: astore 6
    //   387: iconst_0
    //   388: istore_3
    //   389: aconst_null
    //   390: astore 7
    //   392: aconst_null
    //   393: astore 5
    //   395: aload 7
    //   397: astore 9
    //   399: aload 5
    //   401: astore 8
    //   403: ldc 170
    //   405: aload 6
    //   407: ldc_w 258
    //   410: iconst_0
    //   411: anewarray 121	java/lang/Object
    //   414: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: aload 7
    //   419: ifnull +8 -> 427
    //   422: aload 7
    //   424: invokevirtual 253	java/io/DataInputStream:close	()V
    //   427: iload_3
    //   428: istore 4
    //   430: aload 5
    //   432: ifnull -198 -> 234
    //   435: aload 5
    //   437: invokevirtual 256	java/io/InputStream:close	()V
    //   440: iload_3
    //   441: istore 4
    //   443: goto -209 -> 234
    //   446: astore 5
    //   448: ldc 170
    //   450: aload 5
    //   452: ldc_w 258
    //   455: iconst_0
    //   456: anewarray 121	java/lang/Object
    //   459: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: iload_3
    //   463: istore 4
    //   465: goto -231 -> 234
    //   468: astore 6
    //   470: aconst_null
    //   471: astore 9
    //   473: aconst_null
    //   474: astore 5
    //   476: aload 9
    //   478: ifnull +8 -> 486
    //   481: aload 9
    //   483: invokevirtual 253	java/io/DataInputStream:close	()V
    //   486: aload 5
    //   488: ifnull +8 -> 496
    //   491: aload 5
    //   493: invokevirtual 256	java/io/InputStream:close	()V
    //   496: ldc_w 655
    //   499: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   502: aload 6
    //   504: athrow
    //   505: astore 5
    //   507: ldc 170
    //   509: aload 5
    //   511: ldc_w 258
    //   514: iconst_0
    //   515: anewarray 121	java/lang/Object
    //   518: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: goto -25 -> 496
    //   524: astore 6
    //   526: aconst_null
    //   527: astore 9
    //   529: goto -53 -> 476
    //   532: astore 6
    //   534: aload 8
    //   536: astore 5
    //   538: goto -62 -> 476
    //   541: astore 6
    //   543: iconst_0
    //   544: istore_3
    //   545: aconst_null
    //   546: astore 7
    //   548: goto -153 -> 395
    //   551: astore 6
    //   553: iconst_0
    //   554: istore_3
    //   555: goto -160 -> 395
    //   558: astore 6
    //   560: goto -165 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	b
    //   9	196	1	l	long
    //   181	374	3	bool1	boolean
    //   219	245	4	bool2	boolean
    //   16	334	5	localInputStream	java.io.InputStream
    //   363	5	5	localIOException1	java.io.IOException
    //   393	43	5	localObject1	Object
    //   446	5	5	localIOException2	java.io.IOException
    //   474	18	5	localObject2	Object
    //   505	5	5	localIOException3	java.io.IOException
    //   536	1	5	localObject3	Object
    //   297	31	6	arrayOfByte	byte[]
    //   385	21	6	localException1	Exception
    //   468	35	6	localObject4	Object
    //   524	1	6	localObject5	Object
    //   532	1	6	localObject6	Object
    //   541	1	6	localException2	Exception
    //   551	1	6	localException3	Exception
    //   558	1	6	localException4	Exception
    //   27	520	7	localDataInputStream1	java.io.DataInputStream
    //   35	500	8	localObject7	Object
    //   31	497	9	localDataInputStream2	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   213	218	363	java/io/IOException
    //   226	231	363	java/io/IOException
    //   6	18	385	java/lang/Exception
    //   422	427	446	java/io/IOException
    //   435	440	446	java/io/IOException
    //   6	18	468	finally
    //   481	486	505	java/io/IOException
    //   491	496	505	java/io/IOException
    //   18	29	524	finally
    //   37	46	532	finally
    //   54	63	532	finally
    //   71	80	532	finally
    //   88	103	532	finally
    //   111	118	532	finally
    //   126	138	532	finally
    //   146	168	532	finally
    //   176	180	532	finally
    //   190	213	532	finally
    //   291	299	532	finally
    //   307	315	532	finally
    //   323	333	532	finally
    //   341	345	532	finally
    //   353	358	532	finally
    //   403	417	532	finally
    //   18	29	541	java/lang/Exception
    //   37	46	551	java/lang/Exception
    //   54	63	551	java/lang/Exception
    //   71	80	551	java/lang/Exception
    //   88	103	551	java/lang/Exception
    //   111	118	551	java/lang/Exception
    //   126	138	551	java/lang/Exception
    //   146	168	551	java/lang/Exception
    //   176	180	551	java/lang/Exception
    //   291	299	551	java/lang/Exception
    //   307	315	551	java/lang/Exception
    //   323	333	551	java/lang/Exception
    //   341	345	551	java/lang/Exception
    //   353	358	551	java/lang/Exception
    //   190	213	558	java/lang/Exception
  }
  
  public final c kK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104911);
    if ((this.NKK == null) || (this.NKK.isEmpty()) || (this.NKJ))
    {
      this.NKK = new LinkedList(this.NKC.NKr);
      this.NKJ = false;
    }
    if ((this.NKK == null) || (this.NKK.isEmpty()))
    {
      AppMethodBeat.o(104911);
      return null;
    }
    Object localObject = this.NKK.iterator();
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
      localObject = (SparseArray)this.NKG.get(paramInt1);
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
    c NKN;
    boolean NKO = false;
    int end;
    int start;
    
    public a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.NKN = paramc;
      this.start = paramInt1;
      this.end = paramInt2;
      this.NKO = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.b
 * JD-Core Version:    0.7.0.1
 */