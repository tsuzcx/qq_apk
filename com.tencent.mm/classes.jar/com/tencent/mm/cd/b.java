package com.tencent.mm.cd;

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
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends com.tencent.mm.api.c
{
  public static final String ukB = com.tencent.mm.compatible.util.e.dOO + "app_font";
  public static final String ukC = ukB + "/color_emoji";
  private static final boolean ukD;
  private static b ukE;
  private LinkedList<c> hnK;
  private Context mContext = ae.getContext();
  private int ukF = 0;
  private int ukG;
  private int ukH;
  private int ukI;
  public long ukJ = 0L;
  private a ukK = new a();
  private SparseArray<c> ukL = new SparseArray();
  public SparseArray<c> ukM = new SparseArray();
  private SparseArray<c> ukN = new SparseArray();
  private SparseArray<SparseArray<c>> ukO = new SparseArray();
  private SparseArray<String> ukP = null;
  private ab<Integer, Bitmap> ukQ = new ab(200);
  private boolean ukR = false;
  private LinkedList<d> ukS;
  private final Spannable.Factory ukT = new b.1(this);
  
  static
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (boolean bool = true;; bool = false)
    {
      ukD = bool;
      return;
    }
  }
  
  private b()
  {
    if (!com.tencent.mm.vfs.e.bK(ukC))
    {
      long l = System.currentTimeMillis();
      csD();
      com.tencent.mm.vfs.e.r("assets:///color_emoji", ukC);
      y.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    for (;;)
    {
      init();
      if (!com.tencent.mm.cb.a.fh(this.mContext)) {
        break;
      }
      this.ukF = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4);
      return;
      y.i("MicroMsg.EmojiHelper", "emoji color file exist.");
    }
    this.ukF = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
  }
  
  /* Error */
  public static long aaq(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 193	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore 4
    //   6: new 195	java/io/DataInputStream
    //   9: dup
    //   10: aload 4
    //   12: invokespecial 198	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   20: pop
    //   21: aload_0
    //   22: invokevirtual 205	java/io/DataInputStream:readLong	()J
    //   25: lstore_1
    //   26: aload_0
    //   27: invokevirtual 208	java/io/DataInputStream:close	()V
    //   30: aload 4
    //   32: ifnull +8 -> 40
    //   35: aload 4
    //   37: invokevirtual 211	java/io/InputStream:close	()V
    //   40: lload_1
    //   41: lreturn
    //   42: astore_0
    //   43: ldc 150
    //   45: aload_0
    //   46: ldc 213
    //   48: iconst_0
    //   49: anewarray 154	java/lang/Object
    //   52: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: lload_1
    //   56: lreturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_3
    //   60: aconst_null
    //   61: astore 4
    //   63: ldc 150
    //   65: aload_0
    //   66: ldc 213
    //   68: iconst_0
    //   69: anewarray 154	java/lang/Object
    //   72: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 208	java/io/DataInputStream:close	()V
    //   83: aload 4
    //   85: ifnull +8 -> 93
    //   88: aload 4
    //   90: invokevirtual 211	java/io/InputStream:close	()V
    //   93: lconst_0
    //   94: lreturn
    //   95: astore_0
    //   96: ldc 150
    //   98: aload_0
    //   99: ldc 213
    //   101: iconst_0
    //   102: anewarray 154	java/lang/Object
    //   105: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -15 -> 93
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_3
    //   114: aconst_null
    //   115: astore 4
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 208	java/io/DataInputStream:close	()V
    //   125: aload 4
    //   127: ifnull +8 -> 135
    //   130: aload 4
    //   132: invokevirtual 211	java/io/InputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_3
    //   138: ldc 150
    //   140: aload_3
    //   141: ldc 213
    //   143: iconst_0
    //   144: anewarray 154	java/lang/Object
    //   147: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: goto -15 -> 135
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: goto -39 -> 117
    //   159: astore 5
    //   161: aload_0
    //   162: astore_3
    //   163: aload 5
    //   165: astore_0
    //   166: goto -49 -> 117
    //   169: astore_0
    //   170: goto -53 -> 117
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_3
    //   176: goto -113 -> 63
    //   179: astore 5
    //   181: aload_0
    //   182: astore_3
    //   183: aload 5
    //   185: astore_0
    //   186: goto -123 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   25	31	1	l	long
    //   59	63	3	localObject1	Object
    //   137	4	3	localIOException1	java.io.IOException
    //   155	28	3	str	String
    //   4	127	4	localInputStream	java.io.InputStream
    //   159	5	5	localObject2	Object
    //   179	5	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	30	42	java/io/IOException
    //   35	40	42	java/io/IOException
    //   0	6	57	java/io/IOException
    //   79	83	95	java/io/IOException
    //   88	93	95	java/io/IOException
    //   0	6	111	finally
    //   121	125	137	java/io/IOException
    //   130	135	137	java/io/IOException
    //   6	16	153	finally
    //   16	26	159	finally
    //   63	75	169	finally
    //   6	16	173	java/io/IOException
    //   16	26	179	java/io/IOException
  }
  
  /* Error */
  public static int aar(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 193	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore_0
    //   5: new 195	java/io/DataInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 198	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   13: astore_2
    //   14: aload_2
    //   15: astore 4
    //   17: aload_0
    //   18: astore_3
    //   19: aload_2
    //   20: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   23: istore_1
    //   24: aload_2
    //   25: invokevirtual 208	java/io/DataInputStream:close	()V
    //   28: aload_0
    //   29: ifnull +7 -> 36
    //   32: aload_0
    //   33: invokevirtual 211	java/io/InputStream:close	()V
    //   36: iload_1
    //   37: ireturn
    //   38: astore_0
    //   39: ldc 150
    //   41: aload_0
    //   42: ldc 213
    //   44: iconst_0
    //   45: anewarray 154	java/lang/Object
    //   48: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: iload_1
    //   52: ireturn
    //   53: astore 5
    //   55: aconst_null
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_0
    //   59: aload_2
    //   60: astore 4
    //   62: aload_0
    //   63: astore_3
    //   64: ldc 150
    //   66: aload 5
    //   68: ldc 213
    //   70: iconst_0
    //   71: anewarray 154	java/lang/Object
    //   74: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 208	java/io/DataInputStream:close	()V
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 211	java/io/InputStream:close	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_0
    //   96: ldc 150
    //   98: aload_0
    //   99: ldc 213
    //   101: iconst_0
    //   102: anewarray 154	java/lang/Object
    //   105: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -15 -> 93
    //   111: astore_2
    //   112: aconst_null
    //   113: astore 4
    //   115: aconst_null
    //   116: astore_0
    //   117: aload 4
    //   119: ifnull +8 -> 127
    //   122: aload 4
    //   124: invokevirtual 208	java/io/DataInputStream:close	()V
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 211	java/io/InputStream:close	()V
    //   135: aload_2
    //   136: athrow
    //   137: astore_0
    //   138: ldc 150
    //   140: aload_0
    //   141: ldc 213
    //   143: iconst_0
    //   144: anewarray 154	java/lang/Object
    //   147: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: goto -15 -> 135
    //   153: astore_2
    //   154: aconst_null
    //   155: astore 4
    //   157: goto -40 -> 117
    //   160: astore_2
    //   161: aload_3
    //   162: astore_0
    //   163: goto -46 -> 117
    //   166: astore 5
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -111 -> 59
    //   173: astore 5
    //   175: goto -116 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString	String
    //   23	29	1	i	int
    //   13	69	2	localDataInputStream1	java.io.DataInputStream
    //   111	25	2	localObject1	Object
    //   153	1	2	localObject2	Object
    //   160	1	2	localObject3	Object
    //   169	1	2	localObject4	Object
    //   18	144	3	str	String
    //   15	141	4	localDataInputStream2	java.io.DataInputStream
    //   53	14	5	localIOException1	java.io.IOException
    //   166	1	5	localIOException2	java.io.IOException
    //   173	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   24	28	38	java/io/IOException
    //   32	36	38	java/io/IOException
    //   0	5	53	java/io/IOException
    //   81	85	95	java/io/IOException
    //   89	93	95	java/io/IOException
    //   0	5	111	finally
    //   122	127	137	java/io/IOException
    //   131	135	137	java/io/IOException
    //   5	14	153	finally
    //   19	24	160	finally
    //   64	77	160	finally
    //   5	14	166	java/io/IOException
    //   19	24	173	java/io/IOException
  }
  
  public static boolean aas(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return false;
      paramString = paramString.toString();
      int k = paramString.length();
      int j;
      for (int i = 0; i < k; i = j)
      {
        int m = paramString.codePointAt(i);
        j = Character.charCount(m) + i;
        if (j < k) {}
        for (i = paramString.codePointAt(j); csC().Fi(m) != null; i = 0) {
          return true;
        }
        if (csC().fg(m, i) != null) {
          return true;
        }
      }
    }
  }
  
  public static b csC()
  {
    if (ukE == null) {}
    try
    {
      ukE = new b();
      return ukE;
    }
    finally {}
  }
  
  public static void csD()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(ukB);
    if (localb.isFile()) {
      localb.delete();
    }
    if (!localb.exists()) {
      localb.mkdirs();
    }
  }
  
  private void csE()
  {
    this.hnK = new LinkedList(this.ukK.ukA);
    if ((this.hnK == null) || (this.hnK.isEmpty())) {
      y.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.hnK.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hxt != 0)
        {
          SparseArray localSparseArray2 = (SparseArray)this.ukO.get(localc.hxt);
          SparseArray localSparseArray1 = localSparseArray2;
          if (localSparseArray2 == null)
          {
            localSparseArray1 = new SparseArray();
            this.ukO.append(localc.hxt, localSparseArray1);
          }
          localSparseArray1.put(localc.hxu, localc);
          if (localc.hxv != 0) {
            this.ukL.append(localc.hxv, localc);
          }
          if (localc.ukX != -1) {
            this.ukM.append(localc.ukX, localc);
          }
        }
        else
        {
          this.ukN.append(localc.ukY, localc);
        }
      }
    }
  }
  
  public static int csF()
  {
    return 1;
  }
  
  public final c Fi(int paramInt)
  {
    if ((paramInt >= 57345) && (paramInt <= 58679)) {
      return (c)this.ukL.get(paramInt);
    }
    return null;
  }
  
  public final Drawable a(c paramc, boolean paramBoolean)
  {
    if (paramc == null)
    {
      y.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
      return null;
    }
    Object localObject1;
    try
    {
      localObject1 = (Bitmap)this.ukQ.get(Integer.valueOf(paramc.ebL));
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
        return new BitmapDrawable(ae.getContext().getResources(), (Bitmap)localObject1);
      }
      localObject1 = com.tencent.mm.vfs.e.c(ukC, paramc.ebL + this.ukH, paramc.size);
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      if (localObject2 == null) {
        break label176;
      }
      ((Bitmap)localObject2).setDensity(240);
      this.ukQ.put(Integer.valueOf(paramc.ebL), localObject2);
      paramc = new BitmapDrawable(ae.getContext().getResources(), (Bitmap)localObject2);
      return paramc;
    }
    catch (Exception paramc)
    {
      y.printErrStackTrace("MicroMsg.EmojiHelper", paramc, "", new Object[0]);
    }
    return null;
    label176:
    int j = paramc.size;
    if (localObject1 == null) {}
    for (int i = 0;; i = localObject1.length)
    {
      y.i("MicroMsg.EmojiHelper", "bitmap is null. decode byte array failed. size:%d data length:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (!paramBoolean) {
        break;
      }
      csC();
      i = aar(ukC);
      csC();
      long l = aaq(ukC);
      y.i("MicroMsg.EmojiHelper", "emoji error currentSupportVersion:%d currentVersion:%d supportVersion:%d Version:%d", new Object[] { Integer.valueOf(this.ukI), Long.valueOf(this.ukJ), Integer.valueOf(i), Long.valueOf(l) });
      if ((i != this.ukI) || (l <= this.ukJ)) {
        break;
      }
      init();
      return a(paramc, false);
    }
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt, PInt paramPInt, Spannable.Factory paramFactory)
  {
    if ((paramSpannable == null) || (paramSpannable.length() == 0)) {
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
        break label261;
      }
      m = ((String)localObject1).codePointAt(k);
      localObject2 = csC().Fi(i);
      if (localObject2 == null) {
        break label267;
      }
      localLinkedList.add(new b.a(this, (c)localObject2, j, j + 1, true));
      i = k;
    }
    label175:
    for (;;)
    {
      label126:
      if (localLinkedList.size() >= paramPInt.value)
      {
        if (localLinkedList.size() == 0) {
          break;
        }
        if (ukD)
        {
          paramSpannable = new StringBuilder((String)localObject1);
          localObject1 = localLinkedList.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b.a)((Iterator)localObject1).next();
              if (!((b.a)localObject2).ukW) {
                if ((((b.a)localObject2).ukV.hxv != 0) && (((b.a)localObject2).end - ((b.a)localObject2).start == 1))
                {
                  paramSpannable.replace(((b.a)localObject2).start, ((b.a)localObject2).end, String.valueOf((char)((b.a)localObject2).ukV.hxv));
                  continue;
                  m = 0;
                  break;
                  localObject2 = csC().fg(i, m);
                  i = k;
                  if (localObject2 == null) {
                    break label126;
                  }
                  if ((((c)localObject2).hxu == 0) && ((127995 > m) || (m > 127999))) {
                    break label484;
                  }
                }
              }
            }
          }
        }
      }
    }
    label261:
    label267:
    label484:
    for (int i = k + Character.charCount(m);; i = k)
    {
      localLinkedList.add(new b.a(this, (c)localObject2, j, i, false));
      break label126;
      paramSpannable.replace(((b.a)localObject2).start, ((b.a)localObject2).end, "....".substring(0, ((b.a)localObject2).end - ((b.a)localObject2).start));
      break label175;
      paramSpannable = paramFactory.newSpannable(paramSpannable.toString());
      for (;;)
      {
        paramFactory = localLinkedList.iterator();
        while (paramFactory.hasNext())
        {
          localObject1 = (b.a)paramFactory.next();
          a(paramSpannable, csC().a(((b.a)localObject1).ukV, true), ((b.a)localObject1).start, ((b.a)localObject1).end, paramInt);
        }
        paramPInt.value -= localLinkedList.size();
        return paramSpannable;
      }
      j = i;
      break;
    }
  }
  
  public final SpannableString a(SpannableString paramSpannableString, int paramInt, PInt paramPInt)
  {
    return (SpannableString)a(paramSpannableString, paramInt, paramPInt, this.ukT);
  }
  
  public final void a(Spannable paramSpannable, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)(paramInt3 * 1.3F);
    paramInt3 = (int)(paramInt3 * 1.3F);
    try
    {
      paramDrawable.setBounds(0, 0, i, paramInt3);
      paramDrawable = new com.tencent.mm.ui.widget.a(paramDrawable);
      paramDrawable.wjc = this.ukF;
      paramSpannable.setSpan(paramDrawable, paramInt1, paramInt2, 33);
      return;
    }
    catch (Exception paramSpannable)
    {
      y.printErrStackTrace("MicroMsg.EmojiHelper", paramSpannable, "", new Object[0]);
    }
  }
  
  public final String aat(String paramString)
  {
    if (bk.bl(paramString)) {
      return paramString;
    }
    Object localObject2;
    if (this.ukP == null)
    {
      localObject2 = ae.getContext();
      localObject1 = x.d(((Context)localObject2).getSharedPreferences(ae.cqR(), 0));
      if (((String)localObject1).equals("zh_CN")) {
        localObject1 = ((Context)localObject2).getResources().getStringArray(a.a.emoji_name_ch);
      }
      for (;;)
      {
        localObject2 = ((Context)localObject2).getResources().getStringArray(a.a.emoji_code);
        this.ukP = new SparseArray();
        i = 0;
        while ((i < localObject2.length) && (i < localObject1.length))
        {
          this.ukP.put(localObject2[i].charAt(0), localObject1[i]);
          i += 1;
        }
        if ((((String)localObject1).equals("zh_TW")) || (((String)localObject1).equals("zh_HK"))) {
          localObject1 = ((Context)localObject2).getResources().getStringArray(a.a.emoji_name_tw);
        } else {
          localObject1 = ((Context)localObject2).getResources().getStringArray(a.a.emoji_name_en);
        }
      }
    }
    Object localObject1 = new StringBuilder();
    int m = paramString.length();
    int i = 0;
    while (i < m)
    {
      int n = paramString.codePointAt(i);
      int j = i + Character.charCount(n);
      if (j < m) {}
      for (int k = paramString.codePointAt(j);; k = 0)
      {
        localObject2 = csC().Fi(n);
        if (localObject2 == null) {
          break label307;
        }
        localObject2 = (String)this.ukP.get(((c)localObject2).hxv);
        if (localObject2 == null) {
          break label286;
        }
        ((StringBuilder)localObject1).append((String)localObject2);
        i = j;
        break;
      }
      label286:
      ((StringBuilder)localObject1).append(this.mContext.getString(a.h.app_emoji2));
      i = j;
      continue;
      label307:
      localObject2 = csC().fg(n, k);
      if (localObject2 != null)
      {
        i = j;
        if (((c)localObject2).hxu != 0) {
          i = Character.charCount(k) + j;
        }
        localObject2 = (String)this.ukP.get(((c)localObject2).hxv);
        if (localObject2 != null) {
          ((StringBuilder)localObject1).append((String)localObject2);
        } else {
          ((StringBuilder)localObject1).append(this.mContext.getString(a.h.app_emoji2));
        }
      }
      else
      {
        ((StringBuilder)localObject1).appendCodePoint(n);
        i = j;
      }
    }
    return ((StringBuilder)localObject1).toString();
  }
  
  public final c fg(int paramInt1, int paramInt2)
  {
    if ((this.ukS == null) || (this.ukS.isEmpty()) || (this.ukR))
    {
      this.ukS = new LinkedList(this.ukK.ukz);
      this.ukR = false;
    }
    if ((this.ukS == null) || (this.ukS.isEmpty())) {
      return null;
    }
    Object localObject = this.ukS.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      if ((paramInt1 < locald.min) || (paramInt1 > locald.max)) {
        break label186;
      }
      i = 1;
    }
    label186:
    for (;;)
    {
      break;
      if (i == 0) {
        return null;
      }
      localObject = (SparseArray)this.ukO.get(paramInt1);
      if (localObject != null)
      {
        if ((((SparseArray)localObject).size() == 1) && (((SparseArray)localObject).get(0) != null)) {
          return (c)((SparseArray)localObject).get(0);
        }
        return (c)((SparseArray)localObject).get(paramInt2);
      }
      return null;
    }
  }
  
  /* Error */
  public final void init()
  {
    // Byte code:
    //   0: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: getstatic 72	com/tencent/mm/cd/b:ukC	Ljava/lang/String;
    //   7: invokestatic 193	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_3
    //   11: new 195	java/io/DataInputStream
    //   14: dup
    //   15: aload_3
    //   16: invokespecial 198	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore 6
    //   25: aload_3
    //   26: astore 5
    //   28: aload_0
    //   29: aload 4
    //   31: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   34: putfield 405	com/tencent/mm/cd/b:ukI	I
    //   37: aload 4
    //   39: astore 6
    //   41: aload_3
    //   42: astore 5
    //   44: aload_0
    //   45: aload 4
    //   47: invokevirtual 205	java/io/DataInputStream:readLong	()J
    //   50: putfield 85	com/tencent/mm/cd/b:ukJ	J
    //   53: aload 4
    //   55: astore 6
    //   57: aload_3
    //   58: astore 5
    //   60: aload_0
    //   61: aload 4
    //   63: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   66: putfield 573	com/tencent/mm/cd/b:ukG	I
    //   69: aload 4
    //   71: astore 6
    //   73: aload_3
    //   74: astore 5
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 573	com/tencent/mm/cd/b:ukG	I
    //   81: iconst_4
    //   82: iadd
    //   83: bipush 8
    //   85: iadd
    //   86: iconst_4
    //   87: iadd
    //   88: putfield 362	com/tencent/mm/cd/b:ukH	I
    //   91: aload 4
    //   93: astore 6
    //   95: aload_3
    //   96: astore 5
    //   98: aload_0
    //   99: getfield 573	com/tencent/mm/cd/b:ukG	I
    //   102: newarray byte
    //   104: astore 7
    //   106: aload 4
    //   108: astore 6
    //   110: aload_3
    //   111: astore 5
    //   113: aload 4
    //   115: aload 7
    //   117: invokevirtual 577	java/io/DataInputStream:read	([B)I
    //   120: pop
    //   121: aload 4
    //   123: astore 6
    //   125: aload_3
    //   126: astore 5
    //   128: aload_0
    //   129: getfield 90	com/tencent/mm/cd/b:ukK	Lcom/tencent/mm/cd/a;
    //   132: aload 7
    //   134: invokevirtual 581	com/tencent/mm/cd/a:aH	([B)Lcom/tencent/mm/bv/a;
    //   137: pop
    //   138: aload 4
    //   140: astore 6
    //   142: aload_3
    //   143: astore 5
    //   145: aload_0
    //   146: invokespecial 583	com/tencent/mm/cd/b:csE	()V
    //   149: aload 4
    //   151: astore 6
    //   153: aload_3
    //   154: astore 5
    //   156: aload_0
    //   157: iconst_1
    //   158: putfield 112	com/tencent/mm/cd/b:ukR	Z
    //   161: aload 4
    //   163: astore 6
    //   165: aload_3
    //   166: astore 5
    //   168: ldc 150
    //   170: ldc_w 585
    //   173: iconst_1
    //   174: anewarray 154	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   182: lload_1
    //   183: lsub
    //   184: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aastore
    //   188: invokestatic 397	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload 4
    //   193: invokevirtual 208	java/io/DataInputStream:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 211	java/io/InputStream:close	()V
    //   204: return
    //   205: astore_3
    //   206: ldc 150
    //   208: aload_3
    //   209: ldc 213
    //   211: iconst_0
    //   212: anewarray 154	java/lang/Object
    //   215: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: return
    //   219: astore 7
    //   221: aconst_null
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: aload 4
    //   228: astore 6
    //   230: aload_3
    //   231: astore 5
    //   233: ldc 150
    //   235: aload 7
    //   237: ldc 213
    //   239: iconst_0
    //   240: anewarray 154	java/lang/Object
    //   243: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload 4
    //   248: ifnull +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 208	java/io/DataInputStream:close	()V
    //   256: aload_3
    //   257: ifnull -53 -> 204
    //   260: aload_3
    //   261: invokevirtual 211	java/io/InputStream:close	()V
    //   264: return
    //   265: astore_3
    //   266: ldc 150
    //   268: aload_3
    //   269: ldc 213
    //   271: iconst_0
    //   272: anewarray 154	java/lang/Object
    //   275: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: return
    //   279: astore 4
    //   281: aconst_null
    //   282: astore 6
    //   284: aconst_null
    //   285: astore_3
    //   286: aload 6
    //   288: ifnull +8 -> 296
    //   291: aload 6
    //   293: invokevirtual 208	java/io/DataInputStream:close	()V
    //   296: aload_3
    //   297: ifnull +7 -> 304
    //   300: aload_3
    //   301: invokevirtual 211	java/io/InputStream:close	()V
    //   304: aload 4
    //   306: athrow
    //   307: astore_3
    //   308: ldc 150
    //   310: aload_3
    //   311: ldc 213
    //   313: iconst_0
    //   314: anewarray 154	java/lang/Object
    //   317: invokestatic 217	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: goto -16 -> 304
    //   323: astore 4
    //   325: aconst_null
    //   326: astore 6
    //   328: goto -42 -> 286
    //   331: astore 4
    //   333: aload 5
    //   335: astore_3
    //   336: goto -50 -> 286
    //   339: astore 7
    //   341: aconst_null
    //   342: astore 4
    //   344: goto -118 -> 226
    //   347: astore 7
    //   349: goto -123 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	b
    //   3	180	1	l	long
    //   10	191	3	localInputStream	java.io.InputStream
    //   205	4	3	localIOException1	java.io.IOException
    //   225	36	3	localObject1	Object
    //   265	4	3	localIOException2	java.io.IOException
    //   285	16	3	localObject2	Object
    //   307	4	3	localIOException3	java.io.IOException
    //   335	1	3	localObject3	Object
    //   19	233	4	localDataInputStream1	java.io.DataInputStream
    //   279	26	4	localObject4	Object
    //   323	1	4	localObject5	Object
    //   331	1	4	localObject6	Object
    //   342	1	4	localObject7	Object
    //   26	308	5	localObject8	Object
    //   23	304	6	localDataInputStream2	java.io.DataInputStream
    //   104	29	7	arrayOfByte	byte[]
    //   219	17	7	localException1	Exception
    //   339	1	7	localException2	Exception
    //   347	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   191	196	205	java/io/IOException
    //   200	204	205	java/io/IOException
    //   0	11	219	java/lang/Exception
    //   251	256	265	java/io/IOException
    //   260	264	265	java/io/IOException
    //   0	11	279	finally
    //   291	296	307	java/io/IOException
    //   300	304	307	java/io/IOException
    //   11	21	323	finally
    //   28	37	331	finally
    //   44	53	331	finally
    //   60	69	331	finally
    //   76	91	331	finally
    //   98	106	331	finally
    //   113	121	331	finally
    //   128	138	331	finally
    //   145	149	331	finally
    //   156	161	331	finally
    //   168	191	331	finally
    //   233	246	331	finally
    //   11	21	339	java/lang/Exception
    //   28	37	347	java/lang/Exception
    //   44	53	347	java/lang/Exception
    //   60	69	347	java/lang/Exception
    //   76	91	347	java/lang/Exception
    //   98	106	347	java/lang/Exception
    //   113	121	347	java/lang/Exception
    //   128	138	347	java/lang/Exception
    //   145	149	347	java/lang/Exception
    //   156	161	347	java/lang/Exception
    //   168	191	347	java/lang/Exception
  }
  
  public final Drawable mW(int paramInt)
  {
    return a((c)this.ukN.get(paramInt), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cd.b
 * JD-Core Version:    0.7.0.1
 */