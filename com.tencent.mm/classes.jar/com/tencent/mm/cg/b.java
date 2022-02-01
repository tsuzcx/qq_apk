package com.tencent.mm.cg;

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
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends com.tencent.mm.api.f
{
  public static final String Fag;
  public static final String Fah;
  private static final boolean Fai;
  private static b Faj;
  private int Fak;
  private int Fal;
  private int Fam;
  private int Fan;
  public long Fao;
  private a Fap;
  private SparseArray<c> Faq;
  public SparseArray<c> Far;
  private SparseArray<c> Fas;
  private SparseArray<SparseArray<c>> Fat;
  private SparseArray<String> Fau;
  private com.tencent.mm.b.f<String, Bitmap> Fav;
  private boolean Faw;
  private LinkedList<d> Fax;
  private final Spannable.Factory Fay;
  private Context mContext;
  private LinkedList<c> mmU;
  
  static
  {
    AppMethodBeat.i(104917);
    Fag = com.tencent.mm.loader.j.b.ahY() + "app_font";
    Fah = Fag + "/color_emoji";
    if (Build.VERSION.SDK_INT < 19) {}
    for (boolean bool = true;; bool = false)
    {
      Fai = bool;
      AppMethodBeat.o(104917);
      return;
    }
  }
  
  private b()
  {
    AppMethodBeat.i(104897);
    this.Fak = 0;
    this.Fao = 0L;
    this.Fap = new a();
    this.Faq = new SparseArray();
    this.Far = new SparseArray();
    this.Fas = new SparseArray();
    this.Fat = new SparseArray();
    this.Fau = null;
    this.Fav = new com.tencent.mm.memory.a.b(200, getClass());
    this.Faw = false;
    this.Fay = new Spannable.Factory()
    {
      public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(104896);
        paramAnonymousCharSequence = new SpannableString(paramAnonymousCharSequence);
        AppMethodBeat.o(104896);
        return paramAnonymousCharSequence;
      }
    };
    this.mContext = aj.getContext();
    if (!i.eK(Fah)) {
      eHN();
    }
    for (;;)
    {
      init();
      if (!com.tencent.mm.cd.a.hS(this.mContext)) {
        break;
      }
      this.Fak = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 4);
      AppMethodBeat.o(104897);
      return;
      ad.i("MicroMsg.EmojiHelper", "emoji color file exist.");
    }
    this.Fak = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 2);
    AppMethodBeat.o(104897);
  }
  
  public static String Tk(String paramString)
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
          localc = eHL().Wo(m);
          if (localc == null) {
            break label105;
          }
          localStringBuilder.appendCodePoint(localc.mfv);
          if (localc.mfw == 0) {
            break label175;
          }
          localStringBuilder.appendCodePoint(localc.mfw);
          break;
        }
        label105:
        c localc = eHL().iZ(m, j);
        localStringBuilder.appendCodePoint(m);
        if ((localc != null) && (localc.mfw != 0))
        {
          i = Character.charCount(localc.mfw) + i;
          localStringBuilder.appendCodePoint(localc.mfw);
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
  
  /* Error */
  public static long aGI(String paramString)
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 227	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore 4
    //   11: new 229	java/io/DataInputStream
    //   14: dup
    //   15: aload 4
    //   17: invokespecial 232	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 235	java/io/DataInputStream:readInt	()I
    //   25: pop
    //   26: aload_0
    //   27: invokevirtual 239	java/io/DataInputStream:readLong	()J
    //   30: lstore_1
    //   31: aload_0
    //   32: invokevirtual 242	java/io/DataInputStream:close	()V
    //   35: aload 4
    //   37: ifnull +8 -> 45
    //   40: aload 4
    //   42: invokevirtual 245	java/io/InputStream:close	()V
    //   45: ldc 223
    //   47: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: lload_1
    //   51: lreturn
    //   52: astore_0
    //   53: ldc 169
    //   55: aload_0
    //   56: ldc 247
    //   58: iconst_0
    //   59: anewarray 121	java/lang/Object
    //   62: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: goto -20 -> 45
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aconst_null
    //   72: astore 4
    //   74: ldc 169
    //   76: aload_0
    //   77: ldc 247
    //   79: iconst_0
    //   80: anewarray 121	java/lang/Object
    //   83: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 242	java/io/DataInputStream:close	()V
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 245	java/io/InputStream:close	()V
    //   104: ldc 223
    //   106: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: lconst_0
    //   110: lreturn
    //   111: astore_0
    //   112: ldc 169
    //   114: aload_0
    //   115: ldc 247
    //   117: iconst_0
    //   118: anewarray 121	java/lang/Object
    //   121: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -20 -> 104
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_3
    //   130: aconst_null
    //   131: astore 4
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 242	java/io/DataInputStream:close	()V
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 245	java/io/InputStream:close	()V
    //   151: ldc 223
    //   153: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_3
    //   159: ldc 169
    //   161: aload_3
    //   162: ldc 247
    //   164: iconst_0
    //   165: anewarray 121	java/lang/Object
    //   168: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -20 -> 151
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_3
    //   177: goto -44 -> 133
    //   180: astore 5
    //   182: aload_0
    //   183: astore_3
    //   184: aload 5
    //   186: astore_0
    //   187: goto -54 -> 133
    //   190: astore_0
    //   191: goto -58 -> 133
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_3
    //   197: goto -123 -> 74
    //   200: astore 5
    //   202: aload_0
    //   203: astore_3
    //   204: aload 5
    //   206: astore_0
    //   207: goto -133 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   30	21	1	l	long
    //   70	68	3	localObject1	Object
    //   158	4	3	localIOException1	java.io.IOException
    //   176	28	3	str	String
    //   9	138	4	localInputStream	java.io.InputStream
    //   180	5	5	localObject2	Object
    //   200	5	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	35	52	java/io/IOException
    //   40	45	52	java/io/IOException
    //   5	11	68	java/io/IOException
    //   90	94	111	java/io/IOException
    //   99	104	111	java/io/IOException
    //   5	11	127	finally
    //   137	141	158	java/io/IOException
    //   146	151	158	java/io/IOException
    //   11	21	174	finally
    //   21	31	180	finally
    //   74	86	190	finally
    //   11	21	194	java/io/IOException
    //   21	31	200	java/io/IOException
  }
  
  /* Error */
  public static int aGJ(String paramString)
  {
    // Byte code:
    //   0: ldc 254
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 227	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 229	java/io/DataInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 232	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore 4
    //   22: aload_0
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 235	java/io/DataInputStream:readInt	()I
    //   28: istore_1
    //   29: aload_2
    //   30: invokevirtual 242	java/io/DataInputStream:close	()V
    //   33: aload_0
    //   34: ifnull +7 -> 41
    //   37: aload_0
    //   38: invokevirtual 245	java/io/InputStream:close	()V
    //   41: ldc 254
    //   43: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iload_1
    //   47: ireturn
    //   48: astore_0
    //   49: ldc 169
    //   51: aload_0
    //   52: ldc 247
    //   54: iconst_0
    //   55: anewarray 121	java/lang/Object
    //   58: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: goto -20 -> 41
    //   64: astore 5
    //   66: aconst_null
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_2
    //   71: astore 4
    //   73: aload_0
    //   74: astore_3
    //   75: ldc 169
    //   77: aload 5
    //   79: ldc 247
    //   81: iconst_0
    //   82: anewarray 121	java/lang/Object
    //   85: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 242	java/io/DataInputStream:close	()V
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 245	java/io/InputStream:close	()V
    //   104: ldc 254
    //   106: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: ldc 169
    //   114: aload_0
    //   115: ldc 247
    //   117: iconst_0
    //   118: anewarray 121	java/lang/Object
    //   121: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -20 -> 104
    //   127: astore_2
    //   128: aconst_null
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 4
    //   135: ifnull +8 -> 143
    //   138: aload 4
    //   140: invokevirtual 242	java/io/DataInputStream:close	()V
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 245	java/io/InputStream:close	()V
    //   151: ldc 254
    //   153: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_2
    //   157: athrow
    //   158: astore_0
    //   159: ldc 169
    //   161: aload_0
    //   162: ldc 247
    //   164: iconst_0
    //   165: anewarray 121	java/lang/Object
    //   168: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -20 -> 151
    //   174: astore_2
    //   175: aconst_null
    //   176: astore 4
    //   178: goto -45 -> 133
    //   181: astore_2
    //   182: aload_3
    //   183: astore_0
    //   184: goto -51 -> 133
    //   187: astore 5
    //   189: aconst_null
    //   190: astore_2
    //   191: goto -121 -> 70
    //   194: astore 5
    //   196: goto -126 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramString	String
    //   28	19	1	i	int
    //   18	75	2	localDataInputStream1	java.io.DataInputStream
    //   127	30	2	localObject1	Object
    //   174	1	2	localObject2	Object
    //   181	1	2	localObject3	Object
    //   190	1	2	localObject4	Object
    //   23	160	3	str	String
    //   20	157	4	localDataInputStream2	java.io.DataInputStream
    //   64	14	5	localIOException1	java.io.IOException
    //   187	1	5	localIOException2	java.io.IOException
    //   194	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   29	33	48	java/io/IOException
    //   37	41	48	java/io/IOException
    //   5	10	64	java/io/IOException
    //   92	96	111	java/io/IOException
    //   100	104	111	java/io/IOException
    //   5	10	127	finally
    //   138	143	158	java/io/IOException
    //   147	151	158	java/io/IOException
    //   10	19	174	finally
    //   24	29	181	finally
    //   75	88	181	finally
    //   10	19	187	java/io/IOException
    //   24	29	194	java/io/IOException
  }
  
  public static boolean aGK(String paramString)
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
      for (i = paramString.codePointAt(j); eHL().Wo(m) != null; i = 0)
      {
        AppMethodBeat.o(104906);
        return true;
      }
      if (eHL().iZ(m, i) != null)
      {
        AppMethodBeat.o(104906);
        return true;
      }
    }
    AppMethodBeat.o(104906);
    return false;
  }
  
  public static b eHL()
  {
    AppMethodBeat.i(104898);
    if (Faj == null) {}
    try
    {
      Faj = new b();
      b localb = Faj;
      AppMethodBeat.o(104898);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(104898);
    }
  }
  
  public static void eHM()
  {
    AppMethodBeat.i(104899);
    e locale = new e(Fag);
    if (locale.isFile()) {
      locale.delete();
    }
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(104899);
  }
  
  private static void eHN()
  {
    AppMethodBeat.i(104900);
    long l = System.currentTimeMillis();
    eHM();
    i.lC("assets:///color_emoji", Fah);
    ad.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104900);
  }
  
  private void eHO()
  {
    AppMethodBeat.i(104909);
    Object localObject2 = aj.getContext();
    Object localObject1 = ac.f(((Context)localObject2).getSharedPreferences(aj.eFD(), 0));
    if (((String)localObject1).equals("zh_CN")) {
      localObject1 = ((Context)localObject2).getResources().getStringArray(2130903048);
    }
    for (;;)
    {
      localObject2 = ((Context)localObject2).getResources().getStringArray(2130903047);
      this.Fau = new SparseArray();
      int i = 0;
      while ((i < localObject2.length) && (i < localObject1.length))
      {
        this.Fau.put(localObject2[i].charAt(0), localObject1[i]);
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
  
  private void eHP()
  {
    AppMethodBeat.i(104915);
    if (aj.cbv())
    {
      i.deleteFile(Fah);
      eHN();
      com.tencent.mm.pluginsdk.h.a.a.b.ewn().e(37, 4, -1, false);
      init();
    }
    AppMethodBeat.o(104915);
  }
  
  private void eHQ()
  {
    AppMethodBeat.i(104916);
    this.mmU = new LinkedList(this.Fap.Faf);
    if ((this.mmU == null) || (this.mmU.isEmpty()))
    {
      ad.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
      AppMethodBeat.o(104916);
      return;
    }
    Iterator localIterator = this.mmU.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.mfv != 0)
      {
        SparseArray localSparseArray2 = (SparseArray)this.Fat.get(localc.mfv);
        SparseArray localSparseArray1 = localSparseArray2;
        if (localSparseArray2 == null)
        {
          localSparseArray1 = new SparseArray();
          this.Fat.append(localc.mfv, localSparseArray1);
        }
        localSparseArray1.put(localc.mfw, localc);
        if (localc.mfx != 0) {
          this.Faq.append(localc.mfx, localc);
        }
        if (localc.FaC != -1) {
          this.Far.append(localc.FaC, localc);
        }
      }
      else
      {
        this.Fas.append(localc.FaD, localc);
      }
    }
    AppMethodBeat.o(104916);
  }
  
  public final c Wo(int paramInt)
  {
    AppMethodBeat.i(104912);
    if ((paramInt >= 57345) && (paramInt <= 58679))
    {
      c localc = (c)this.Faq.get(paramInt);
      AppMethodBeat.o(104912);
      return localc;
    }
    AppMethodBeat.o(104912);
    return null;
  }
  
  public final Drawable a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(104914);
    if (paramc == null)
    {
      ad.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
      AppMethodBeat.o(104914);
      return null;
    }
    try
    {
      Object localObject1 = (Bitmap)this.Fav.get(paramc.cWU);
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        paramc = new BitmapDrawable(aj.getContext().getResources(), (Bitmap)localObject1);
        AppMethodBeat.o(104914);
        return paramc;
      }
      localObject1 = i.aR(Fah, paramc.cWU + this.Fam, paramc.size);
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      if (localObject2 != null)
      {
        ((Bitmap)localObject2).setDensity(240);
        this.Fav.put(paramc.cWU, localObject2);
        paramc = new BitmapDrawable(aj.getContext().getResources(), (Bitmap)localObject2);
        AppMethodBeat.o(104914);
        return paramc;
      }
      int j = paramc.size;
      if (localObject1 == null) {}
      for (int i = 0;; i = localObject1.length)
      {
        ad.i("MicroMsg.EmojiHelper", "bitmap is null. decode byte array failed. size:%d data length:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if (!paramBoolean) {
          break label401;
        }
        eHL();
        i = aGJ(Fah);
        eHL();
        long l = aGI(Fah);
        ad.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", new Object[] { Integer.valueOf(this.Fan), Long.valueOf(this.Fao), Integer.valueOf(i), Long.valueOf(l) });
        if ((i != this.Fan) || (l <= this.Fao)) {
          break;
        }
        init();
        paramc = a(paramc, false);
        AppMethodBeat.o(104914);
        return paramc;
      }
      eHP();
      paramc = a(paramc, false);
      AppMethodBeat.o(104914);
      return paramc;
    }
    catch (Exception paramc)
    {
      ad.printErrStackTrace("MicroMsg.EmojiHelper", paramc, "", new Object[0]);
      label401:
      AppMethodBeat.o(104914);
    }
    return null;
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
      localObject2 = eHL().Wo(i);
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
          localObject2 = eHL().iZ(i, m);
          i = k;
          if (localObject2 == null) {
            continue;
          }
          if ((((c)localObject2).mfw == 0) && ((127995 > m) || (m > 127999))) {
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
      if (Fai)
      {
        paramSpannable = new StringBuilder((String)localObject1);
        localObject1 = localLinkedList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (!((a)localObject2).FaB) {
            if ((((a)localObject2).FaA.mfx != 0) && (((a)localObject2).end - ((a)localObject2).start == 1)) {
              paramSpannable.replace(((a)localObject2).start, ((a)localObject2).end, String.valueOf((char)((a)localObject2).FaA.mfx));
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
          a(paramSpannable, eHL().a(((a)localObject1).FaA, true), ((a)localObject1).start, ((a)localObject1).end, paramInt);
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
    paramSpannableString = (SpannableString)a(paramSpannableString, paramInt, paramPInt, this.Fay);
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
      paramDrawable.HyD = this.Fak;
      paramSpannable.setSpan(paramDrawable, paramInt1, paramInt2, 33);
      AppMethodBeat.o(104910);
      return;
    }
    catch (Exception paramSpannable)
    {
      ad.printErrStackTrace("MicroMsg.EmojiHelper", paramSpannable, "", new Object[0]);
      AppMethodBeat.o(104910);
    }
  }
  
  public final String aGL(String paramString)
  {
    AppMethodBeat.i(104907);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104907);
      return paramString;
    }
    if (this.Fau == null) {
      eHO();
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
        localObject = eHL().Wo(n);
        if (localObject == null) {
          break label160;
        }
        localObject = (String)this.Fau.get(((c)localObject).mfx);
        if (localObject == null) {
          break label139;
        }
        localStringBuilder.append((String)localObject);
        i = j;
        break;
      }
      label139:
      localStringBuilder.append(this.mContext.getString(2131755723));
      i = j;
      continue;
      label160:
      Object localObject = eHL().iZ(n, k);
      if (localObject != null)
      {
        i = j;
        if (((c)localObject).mfw != 0) {
          i = Character.charCount(k) + j;
        }
        localObject = (String)this.Fau.get(((c)localObject).mfx);
        if (localObject != null) {
          localStringBuilder.append((String)localObject);
        } else {
          localStringBuilder.append(this.mContext.getString(2131755723));
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
  
  public final c aGM(String paramString)
  {
    AppMethodBeat.i(177034);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
      AppMethodBeat.o(177034);
      return null;
    }
    int i = paramString.codePointAt(0);
    if (Wo(i) != null)
    {
      paramString = Wo(i);
      AppMethodBeat.o(177034);
      return paramString;
    }
    paramString = iZ(i, 0);
    AppMethodBeat.o(177034);
    return paramString;
  }
  
  public final c iZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104911);
    if ((this.Fax == null) || (this.Fax.isEmpty()) || (this.Faw))
    {
      this.Fax = new LinkedList(this.Fap.Fae);
      this.Faw = false;
    }
    if ((this.Fax == null) || (this.Fax.isEmpty()))
    {
      AppMethodBeat.o(104911);
      return null;
    }
    Object localObject = this.Fax.iterator();
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
      localObject = (SparseArray)this.Fat.get(paramInt1);
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
  
  /* Error */
  public final void init()
  {
    // Byte code:
    //   0: ldc_w 624
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   9: lstore_1
    //   10: getstatic 82	com/tencent/mm/cg/b:Fah	Ljava/lang/String;
    //   13: invokestatic 227	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_3
    //   17: new 229	java/io/DataInputStream
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 232	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore 6
    //   31: aload_3
    //   32: astore 5
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 235	java/io/DataInputStream:readInt	()I
    //   40: putfield 498	com/tencent/mm/cg/b:Fan	I
    //   43: aload 4
    //   45: astore 6
    //   47: aload_3
    //   48: astore 5
    //   50: aload_0
    //   51: aload 4
    //   53: invokevirtual 239	java/io/DataInputStream:readLong	()J
    //   56: putfield 99	com/tencent/mm/cg/b:Fao	J
    //   59: aload 4
    //   61: astore 6
    //   63: aload_3
    //   64: astore 5
    //   66: aload_0
    //   67: aload 4
    //   69: invokevirtual 235	java/io/DataInputStream:readInt	()I
    //   72: putfield 626	com/tencent/mm/cg/b:Fal	I
    //   75: aload 4
    //   77: astore 6
    //   79: aload_3
    //   80: astore 5
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 626	com/tencent/mm/cg/b:Fal	I
    //   87: iconst_4
    //   88: iadd
    //   89: bipush 8
    //   91: iadd
    //   92: iconst_4
    //   93: iadd
    //   94: putfield 450	com/tencent/mm/cg/b:Fam	I
    //   97: aload 4
    //   99: astore 6
    //   101: aload_3
    //   102: astore 5
    //   104: aload_0
    //   105: getfield 626	com/tencent/mm/cg/b:Fal	I
    //   108: ifle +22 -> 130
    //   111: aload 4
    //   113: astore 6
    //   115: aload_3
    //   116: astore 5
    //   118: aload_0
    //   119: getfield 626	com/tencent/mm/cg/b:Fal	I
    //   122: aload 4
    //   124: invokevirtual 629	java/io/DataInputStream:available	()I
    //   127: if_icmple +93 -> 220
    //   130: aload 4
    //   132: astore 6
    //   134: aload_3
    //   135: astore 5
    //   137: ldc 169
    //   139: ldc_w 631
    //   142: iconst_1
    //   143: anewarray 121	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: getfield 626	com/tencent/mm/cg/b:Fal	I
    //   152: invokestatic 488	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: invokestatic 634	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aload 4
    //   161: astore 6
    //   163: aload_3
    //   164: astore 5
    //   166: aload_0
    //   167: invokespecial 502	com/tencent/mm/cg/b:eHP	()V
    //   170: aload 4
    //   172: astore 6
    //   174: aload_3
    //   175: astore 5
    //   177: ldc 169
    //   179: ldc_w 636
    //   182: iconst_1
    //   183: anewarray 121	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   191: lload_1
    //   192: lsub
    //   193: invokestatic 303	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   196: aastore
    //   197: invokestatic 490	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 4
    //   202: invokevirtual 242	java/io/DataInputStream:close	()V
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 245	java/io/InputStream:close	()V
    //   213: ldc_w 624
    //   216: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: return
    //   220: aload 4
    //   222: astore 6
    //   224: aload_3
    //   225: astore 5
    //   227: aload_0
    //   228: getfield 626	com/tencent/mm/cg/b:Fal	I
    //   231: newarray byte
    //   233: astore 7
    //   235: aload 4
    //   237: astore 6
    //   239: aload_3
    //   240: astore 5
    //   242: aload 4
    //   244: aload 7
    //   246: invokevirtual 640	java/io/DataInputStream:read	([B)I
    //   249: pop
    //   250: aload 4
    //   252: astore 6
    //   254: aload_3
    //   255: astore 5
    //   257: aload_0
    //   258: getfield 104	com/tencent/mm/cg/b:Fap	Lcom/tencent/mm/cg/a;
    //   261: aload 7
    //   263: invokevirtual 644	com/tencent/mm/cg/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   266: pop
    //   267: aload 4
    //   269: astore 6
    //   271: aload_3
    //   272: astore 5
    //   274: aload_0
    //   275: invokespecial 646	com/tencent/mm/cg/b:eHQ	()V
    //   278: aload 4
    //   280: astore 6
    //   282: aload_3
    //   283: astore 5
    //   285: aload_0
    //   286: iconst_1
    //   287: putfield 132	com/tencent/mm/cg/b:Faw	Z
    //   290: goto -120 -> 170
    //   293: astore 7
    //   295: aload 4
    //   297: astore 6
    //   299: aload_3
    //   300: astore 5
    //   302: ldc 169
    //   304: aload 7
    //   306: ldc 247
    //   308: iconst_0
    //   309: anewarray 121	java/lang/Object
    //   312: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: aload 4
    //   317: ifnull +8 -> 325
    //   320: aload 4
    //   322: invokevirtual 242	java/io/DataInputStream:close	()V
    //   325: aload_3
    //   326: ifnull +7 -> 333
    //   329: aload_3
    //   330: invokevirtual 245	java/io/InputStream:close	()V
    //   333: ldc_w 624
    //   336: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: return
    //   340: astore_3
    //   341: ldc 169
    //   343: aload_3
    //   344: ldc 247
    //   346: iconst_0
    //   347: anewarray 121	java/lang/Object
    //   350: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: ldc_w 624
    //   356: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: return
    //   360: astore_3
    //   361: ldc 169
    //   363: aload_3
    //   364: ldc 247
    //   366: iconst_0
    //   367: anewarray 121	java/lang/Object
    //   370: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: ldc_w 624
    //   376: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: return
    //   380: astore 4
    //   382: aconst_null
    //   383: astore 6
    //   385: aconst_null
    //   386: astore_3
    //   387: aload 6
    //   389: ifnull +8 -> 397
    //   392: aload 6
    //   394: invokevirtual 242	java/io/DataInputStream:close	()V
    //   397: aload_3
    //   398: ifnull +7 -> 405
    //   401: aload_3
    //   402: invokevirtual 245	java/io/InputStream:close	()V
    //   405: ldc_w 624
    //   408: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload 4
    //   413: athrow
    //   414: astore_3
    //   415: ldc 169
    //   417: aload_3
    //   418: ldc 247
    //   420: iconst_0
    //   421: anewarray 121	java/lang/Object
    //   424: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   427: goto -22 -> 405
    //   430: astore 4
    //   432: aconst_null
    //   433: astore 6
    //   435: goto -48 -> 387
    //   438: astore 4
    //   440: aload 5
    //   442: astore_3
    //   443: goto -56 -> 387
    //   446: astore 7
    //   448: aconst_null
    //   449: astore 4
    //   451: aconst_null
    //   452: astore_3
    //   453: goto -158 -> 295
    //   456: astore 7
    //   458: aconst_null
    //   459: astore 4
    //   461: goto -166 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	b
    //   9	183	1	l	long
    //   16	314	3	localInputStream1	java.io.InputStream
    //   340	4	3	localIOException1	java.io.IOException
    //   360	4	3	localIOException2	java.io.IOException
    //   386	16	3	localObject1	Object
    //   414	4	3	localIOException3	java.io.IOException
    //   442	11	3	localObject2	Object
    //   25	296	4	localDataInputStream1	java.io.DataInputStream
    //   380	32	4	localObject3	Object
    //   430	1	4	localObject4	Object
    //   438	1	4	localObject5	Object
    //   449	11	4	localObject6	Object
    //   32	409	5	localInputStream2	java.io.InputStream
    //   29	405	6	localDataInputStream2	java.io.DataInputStream
    //   233	29	7	arrayOfByte	byte[]
    //   293	12	7	localException1	Exception
    //   446	1	7	localException2	Exception
    //   456	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   34	43	293	java/lang/Exception
    //   50	59	293	java/lang/Exception
    //   66	75	293	java/lang/Exception
    //   82	97	293	java/lang/Exception
    //   104	111	293	java/lang/Exception
    //   118	130	293	java/lang/Exception
    //   137	159	293	java/lang/Exception
    //   166	170	293	java/lang/Exception
    //   177	200	293	java/lang/Exception
    //   227	235	293	java/lang/Exception
    //   242	250	293	java/lang/Exception
    //   257	267	293	java/lang/Exception
    //   274	278	293	java/lang/Exception
    //   285	290	293	java/lang/Exception
    //   200	205	340	java/io/IOException
    //   209	213	340	java/io/IOException
    //   320	325	360	java/io/IOException
    //   329	333	360	java/io/IOException
    //   6	17	380	finally
    //   392	397	414	java/io/IOException
    //   401	405	414	java/io/IOException
    //   17	27	430	finally
    //   34	43	438	finally
    //   50	59	438	finally
    //   66	75	438	finally
    //   82	97	438	finally
    //   104	111	438	finally
    //   118	130	438	finally
    //   137	159	438	finally
    //   166	170	438	finally
    //   177	200	438	finally
    //   227	235	438	finally
    //   242	250	438	finally
    //   257	267	438	finally
    //   274	278	438	finally
    //   285	290	438	finally
    //   302	315	438	finally
    //   6	17	446	java/lang/Exception
    //   17	27	456	java/lang/Exception
  }
  
  public final Drawable vc(int paramInt)
  {
    AppMethodBeat.i(104913);
    Drawable localDrawable = a((c)this.Fas.get(paramInt), true);
    AppMethodBeat.o(104913);
    return localDrawable;
  }
  
  final class a
  {
    c FaA;
    boolean FaB = false;
    int end;
    int start;
    
    public a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.FaA = paramc;
      this.start = paramInt1;
      this.end = paramInt2;
      this.FaB = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.b
 * JD-Core Version:    0.7.0.1
 */