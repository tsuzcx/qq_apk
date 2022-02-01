package com.tencent.mm.cf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ar.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class f
{
  private static volatile f IjV;
  public static Pattern Ikh;
  private static final Comparator<a> Iki;
  private static boolean Ikj;
  public String[] IjW;
  public String[] IjX;
  public String[] IjY;
  public String[] IjZ;
  public String[] Ika;
  public String[] Ikb;
  public ArrayList<SmileyInfo> Ikc;
  private final List<a> Ikd;
  private HashMap<String, SmileyInfo> Ike;
  private SparseArray<String> Ikf;
  private com.tencent.mm.b.f<String, Bitmap> Ikg;
  
  static
  {
    AppMethodBeat.i(104945);
    IjV = null;
    Iki = new f.1();
    Ikj = false;
    AppMethodBeat.o(104945);
  }
  
  private f(Context paramContext)
  {
    AppMethodBeat.i(104931);
    this.IjW = null;
    this.IjX = null;
    this.IjY = null;
    this.IjZ = null;
    this.Ika = null;
    this.Ikb = null;
    this.Ikd = Collections.synchronizedList(new LinkedList());
    this.Ike = new HashMap();
    this.Ikf = new SparseArray();
    this.Ikg = new com.tencent.mm.memory.a.b(100, getClass());
    long l = System.currentTimeMillis();
    this.IjW = paramContext.getResources().getStringArray(2130903086);
    this.IjX = paramContext.getResources().getStringArray(2130903089);
    this.IjY = paramContext.getResources().getStringArray(2130903087);
    this.IjZ = paramContext.getResources().getStringArray(2130903091);
    this.Ika = paramContext.getResources().getStringArray(2130903088);
    this.Ikb = paramContext.getResources().getStringArray(2130903090);
    fnd();
    ad.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104931);
  }
  
  private Drawable a(a parama)
  {
    AppMethodBeat.i(104941);
    int i = parama.pos;
    if (i >= 0) {}
    for (parama = b.fmR().wy(i);; parama = aRQ(parama.name))
    {
      AppMethodBeat.o(104941);
      return parama;
    }
  }
  
  private boolean a(int paramInt1, SpannableString paramSpannableString, int paramInt2)
  {
    AppMethodBeat.i(104940);
    a locala = aRP(paramSpannableString.subSequence(paramInt1, paramSpannableString.length()));
    if (locala != null)
    {
      Drawable localDrawable = a(locala);
      if ((localDrawable != null) && (paramInt1 <= paramSpannableString.length()) && (locala.text.length() + paramInt1 <= paramSpannableString.length()))
      {
        b.fmR().a(paramSpannableString, localDrawable, paramInt1, paramInt1 + locala.text.length(), paramInt2);
        AppMethodBeat.o(104940);
        return true;
      }
      ad.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[] { locala.toString() });
    }
    AppMethodBeat.o(104940);
    return false;
  }
  
  /* Error */
  private Drawable aRQ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 225
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 181	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   15: invokestatic 230	com/tencent/mm/ar/a:aHl	()Ljava/lang/String;
    //   18: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 7
    //   30: new 235	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 236	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore 6
    //   39: aload_0
    //   40: getfield 109	com/tencent/mm/cf/f:Ikg	Lcom/tencent/mm/b/f;
    //   43: aload_1
    //   44: invokeinterface 242 2 0
    //   49: checkcast 244	android/graphics/Bitmap
    //   52: astore_2
    //   53: aload_2
    //   54: astore_3
    //   55: aload_2
    //   56: ifnonnull +150 -> 206
    //   59: aload 7
    //   61: invokestatic 250	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   64: ifeq +422 -> 486
    //   67: aload 7
    //   69: invokestatic 254	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   72: astore 8
    //   74: aload 8
    //   76: aconst_null
    //   77: aload 6
    //   79: invokestatic 260	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   82: astore_3
    //   83: aload_3
    //   84: astore_2
    //   85: aload 8
    //   87: ifnull +211 -> 298
    //   90: aload 8
    //   92: invokevirtual 265	java/io/InputStream:close	()V
    //   95: aload_2
    //   96: astore_3
    //   97: aload_2
    //   98: ifnonnull +345 -> 443
    //   101: ldc 139
    //   103: ldc_w 267
    //   106: iconst_2
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 7
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_1
    //   118: aastore
    //   119: invokestatic 270	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: invokestatic 275	com/tencent/mm/sdk/platformtools/aj:cmR	()Z
    //   125: ifne +176 -> 301
    //   128: ldc 139
    //   130: ldc_w 277
    //   133: invokestatic 280	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_2
    //   137: astore_3
    //   138: invokestatic 284	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   141: invokevirtual 288	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   144: ldc_w 290
    //   147: aload_1
    //   148: invokestatic 293	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   151: invokevirtual 297	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 302	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   157: astore 7
    //   159: aload 5
    //   161: astore 4
    //   163: aload 7
    //   165: aconst_null
    //   166: aload 6
    //   168: invokestatic 260	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   171: astore_3
    //   172: aload_3
    //   173: astore_2
    //   174: aload 7
    //   176: ifnull +296 -> 472
    //   179: aload_2
    //   180: astore_3
    //   181: aload 7
    //   183: invokevirtual 265	java/io/InputStream:close	()V
    //   186: aload_2
    //   187: astore_3
    //   188: aload_2
    //   189: ifnull +17 -> 206
    //   192: aload_0
    //   193: getfield 109	com/tencent/mm/cf/f:Ikg	Lcom/tencent/mm/b/f;
    //   196: aload_1
    //   197: aload_2
    //   198: invokeinterface 306 3 0
    //   203: pop
    //   204: aload_2
    //   205: astore_3
    //   206: new 308	android/graphics/drawable/BitmapDrawable
    //   209: dup
    //   210: invokestatic 284	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   213: invokevirtual 121	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   216: aload_3
    //   217: invokespecial 311	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   220: astore_1
    //   221: ldc 225
    //   223: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: areturn
    //   228: astore 4
    //   230: ldc 225
    //   232: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload 4
    //   237: athrow
    //   238: astore_3
    //   239: aload 8
    //   241: ifnull +13 -> 254
    //   244: aload 4
    //   246: ifnull +44 -> 290
    //   249: aload 8
    //   251: invokevirtual 265	java/io/InputStream:close	()V
    //   254: ldc 225
    //   256: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_3
    //   260: athrow
    //   261: astore_3
    //   262: ldc 139
    //   264: aload_3
    //   265: ldc_w 313
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -180 -> 95
    //   278: astore 8
    //   280: aload 4
    //   282: aload 8
    //   284: invokevirtual 321	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   287: goto -33 -> 254
    //   290: aload 8
    //   292: invokevirtual 265	java/io/InputStream:close	()V
    //   295: goto -41 -> 254
    //   298: goto -203 -> 95
    //   301: ldc 139
    //   303: ldc_w 323
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: getstatic 58	com/tencent/mm/cf/f:Ikj	Z
    //   315: invokestatic 328	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   318: aastore
    //   319: invokestatic 270	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: getstatic 58	com/tencent/mm/cf/f:Ikj	Z
    //   325: ifne -189 -> 136
    //   328: iconst_1
    //   329: putstatic 58	com/tencent/mm/cf/f:Ikj	Z
    //   332: invokestatic 334	com/tencent/mm/pluginsdk/j/a/a/b:faE	()Lcom/tencent/mm/pluginsdk/j/a/a/b;
    //   335: bipush 37
    //   337: iconst_1
    //   338: iconst_m1
    //   339: iconst_0
    //   340: invokevirtual 338	com/tencent/mm/pluginsdk/j/a/a/b:f	(IIIZ)V
    //   343: invokestatic 344	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   346: invokevirtual 350	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   349: getstatic 356	com/tencent/mm/storage/al$a:IqH	Lcom/tencent/mm/storage/al$a;
    //   352: iconst_0
    //   353: invokestatic 361	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: invokevirtual 367	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   359: new 369	com/tencent/mm/pluginsdk/j/a/a/m
    //   362: dup
    //   363: bipush 37
    //   365: invokespecial 371	com/tencent/mm/pluginsdk/j/a/a/m:<init>	(I)V
    //   368: astore_3
    //   369: invokestatic 375	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   372: getfield 381	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   375: aload_3
    //   376: iconst_0
    //   377: invokevirtual 386	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   380: pop
    //   381: goto -245 -> 136
    //   384: astore_3
    //   385: aload_3
    //   386: astore 4
    //   388: ldc 225
    //   390: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: aload_3
    //   394: astore 4
    //   396: aload_3
    //   397: athrow
    //   398: astore 5
    //   400: aload 7
    //   402: ifnull +15 -> 417
    //   405: aload 4
    //   407: ifnull +55 -> 462
    //   410: aload_2
    //   411: astore_3
    //   412: aload 7
    //   414: invokevirtual 265	java/io/InputStream:close	()V
    //   417: aload_2
    //   418: astore_3
    //   419: ldc 225
    //   421: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: aload_2
    //   425: astore_3
    //   426: aload 5
    //   428: athrow
    //   429: astore_2
    //   430: ldc 139
    //   432: aload_2
    //   433: ldc_w 313
    //   436: iconst_0
    //   437: anewarray 4	java/lang/Object
    //   440: invokestatic 317	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: aload_3
    //   444: astore_2
    //   445: goto -259 -> 186
    //   448: astore 6
    //   450: aload_2
    //   451: astore_3
    //   452: aload 4
    //   454: aload 6
    //   456: invokevirtual 321	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   459: goto -42 -> 417
    //   462: aload_2
    //   463: astore_3
    //   464: aload 7
    //   466: invokevirtual 265	java/io/InputStream:close	()V
    //   469: goto -52 -> 417
    //   472: goto -286 -> 186
    //   475: astore_3
    //   476: goto -214 -> 262
    //   479: astore_3
    //   480: aconst_null
    //   481: astore 4
    //   483: goto -244 -> 239
    //   486: goto -391 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	f
    //   0	489	1	paramString	String
    //   52	373	2	localObject1	Object
    //   429	4	2	localException1	java.lang.Exception
    //   444	19	2	localObject2	Object
    //   54	163	3	localObject3	Object
    //   238	22	3	localObject4	Object
    //   261	4	3	localException2	java.lang.Exception
    //   368	8	3	localm	com.tencent.mm.pluginsdk.j.a.a.m
    //   384	13	3	localThrowable1	java.lang.Throwable
    //   411	53	3	localObject5	Object
    //   475	1	3	localException3	java.lang.Exception
    //   479	1	3	localObject6	Object
    //   161	1	4	localObject7	Object
    //   228	53	4	localThrowable2	java.lang.Throwable
    //   386	96	4	localThrowable3	java.lang.Throwable
    //   1	159	5	localObject8	Object
    //   398	29	5	localObject9	Object
    //   37	130	6	localOptions	android.graphics.BitmapFactory.Options
    //   448	7	6	localThrowable4	java.lang.Throwable
    //   28	437	7	localObject10	Object
    //   72	178	8	localInputStream	java.io.InputStream
    //   278	13	8	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   74	83	228	java/lang/Throwable
    //   230	238	238	finally
    //   67	74	261	java/lang/Exception
    //   249	254	261	java/lang/Exception
    //   254	261	261	java/lang/Exception
    //   280	287	261	java/lang/Exception
    //   290	295	261	java/lang/Exception
    //   249	254	278	java/lang/Throwable
    //   163	172	384	java/lang/Throwable
    //   163	172	398	finally
    //   388	393	398	finally
    //   396	398	398	finally
    //   138	159	429	java/lang/Exception
    //   181	186	429	java/lang/Exception
    //   412	417	429	java/lang/Exception
    //   419	424	429	java/lang/Exception
    //   426	429	429	java/lang/Exception
    //   452	459	429	java/lang/Exception
    //   464	469	429	java/lang/Exception
    //   412	417	448	java/lang/Throwable
    //   90	95	475	java/lang/Exception
    //   74	83	479	finally
  }
  
  public static f fnb()
  {
    AppMethodBeat.i(104932);
    if (IjV == null) {}
    try
    {
      if (IjV == null) {
        IjV = new f(aj.getContext());
      }
      f localf = IjV;
      AppMethodBeat.o(104932);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(104932);
    }
  }
  
  private int fnc()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(104933);
        this.Ikd.clear();
        if ((this.IjW != null) && (this.IjY != null) && (this.IjW.length == this.IjY.length))
        {
          j = this.IjW.length;
          i = 0;
          if (i >= j) {
            break label448;
          }
          String str6 = this.IjW[i];
          String str7 = this.IjY[i];
          if ((this.IjX != null) && (this.IjX.length > i))
          {
            String str1 = this.IjX[i];
            if ((this.IjZ == null) || (this.IjZ.length <= i)) {
              break label424;
            }
            str3 = this.IjZ[i];
            if ((this.Ika == null) || (this.Ika.length <= i)) {
              break label432;
            }
            str4 = this.Ika[i];
            if ((this.Ikb == null) || (this.Ikb.length <= i)) {
              break label440;
            }
            str5 = this.Ikb[i];
            SmileyInfo localSmileyInfo = new SmileyInfo(str6, str1, str7, str3, str4, str5, i);
            this.Ikd.add(new a(i, str6, ""));
            this.Ikd.add(new a(i, str7, ""));
            this.Ikd.add(new a(i, str1, ""));
            this.Ikd.add(new a(i, str3, ""));
            this.Ikd.add(new a(i, str4, ""));
            this.Ikd.add(new a(i, str5, ""));
            this.Ike.put(str6, localSmileyInfo);
            this.Ikf.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
            i += 1;
            continue;
            if ((this.Ikc == null) || (this.Ikc.isEmpty())) {
              Collections.sort(this.Ikd, Iki);
            }
            AppMethodBeat.o(104933);
            return i;
          }
        }
        else
        {
          ad.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
          continue;
        }
        String str2 = "";
      }
      finally {}
      continue;
      label424:
      String str3 = "";
      continue;
      label432:
      String str4 = "";
      continue;
      label440:
      String str5 = "";
      continue;
      label448:
      i = j;
    }
  }
  
  private static void hl(List<SmileyInfo> paramList)
  {
    AppMethodBeat.i(104935);
    paramList = paramList.iterator();
    SmileyInfo localSmileyInfo;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localSmileyInfo = (SmileyInfo)paramList.next();
    } while (i.fv(a.aHl() + localSmileyInfo.field_fileName));
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.QQSmileyManager", "checkFile %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        ((d)g.ad(d.class)).getProvider().cgA();
      }
      AppMethodBeat.o(104935);
      return;
    }
  }
  
  public final Drawable a(SmileyInfo paramSmileyInfo)
  {
    AppMethodBeat.i(177039);
    int i = paramSmileyInfo.field_position;
    if (i >= 0) {}
    for (paramSmileyInfo = b.fmR().wy(i);; paramSmileyInfo = aRQ(paramSmileyInfo.field_fileName))
    {
      AppMethodBeat.o(177039);
      return paramSmileyInfo;
    }
  }
  
  public final boolean aRO(String paramString)
  {
    AppMethodBeat.i(104937);
    if (aRP(paramString) != null)
    {
      AppMethodBeat.o(104937);
      return true;
    }
    AppMethodBeat.o(104937);
    return false;
  }
  
  public final a aRP(String paramString)
  {
    AppMethodBeat.i(104938);
    for (;;)
    {
      synchronized (this.Ikd)
      {
        a locala = new a(0, paramString, "");
        int i = Collections.binarySearch(this.Ikd, locala, Iki);
        if (i < 0)
        {
          i = -i - 2;
          if ((i >= 0) && (i < this.Ikd.size()))
          {
            locala = (a)this.Ikd.get(i);
            if ((locala != null) && (paramString != null) && (paramString.startsWith(locala.text)))
            {
              paramString = (a)this.Ikd.get(i);
              AppMethodBeat.o(104938);
              return paramString;
            }
          }
          AppMethodBeat.o(104938);
          return null;
        }
      }
    }
  }
  
  public final SmileyInfo aRR(String paramString)
  {
    AppMethodBeat.i(104943);
    if ((this.Ike != null) && (this.Ike.containsKey(paramString)))
    {
      paramString = (SmileyInfo)this.Ike.get(paramString);
      AppMethodBeat.o(104943);
      return paramString;
    }
    ad.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[] { paramString.replace("\\", "\\\\") });
    AppMethodBeat.o(104943);
    return null;
  }
  
  public final SpannableString b(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104939);
    if ((paramSpannableString == null) || (paramSpannableString.length() == 0))
    {
      AppMethodBeat.o(104939);
      return paramSpannableString;
    }
    String str = paramSpannableString.toString();
    int i = 0;
    int k = -1;
    int m;
    for (;;)
    {
      int j = str.indexOf('/', k + 1);
      k = j;
      m = i;
      if (j == -1) {
        break;
      }
      k = j;
      if (j < str.length() - 1)
      {
        k = j;
        m = i;
        if (i >= paramInt2) {
          break;
        }
        k = j;
        if (a(j, paramSpannableString, paramInt1))
        {
          i += 1;
          k = j;
        }
      }
    }
    for (;;)
    {
      i = str.indexOf('[', k + 1);
      if (i == -1) {
        break;
      }
      k = i;
      if (i < str.length() - 1)
      {
        if (m >= paramInt2) {
          break;
        }
        k = i;
        if (a(i, paramSpannableString, paramInt1))
        {
          m += 1;
          k = i;
        }
      }
    }
    AppMethodBeat.o(104939);
    return paramSpannableString;
  }
  
  public final boolean fnd()
  {
    AppMethodBeat.i(104934);
    ad.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
    ArrayList localArrayList = ((d)g.ad(d.class)).getProvider().cgv();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      fne();
      AppMethodBeat.o(104934);
      return true;
    }
    hl(localArrayList);
    fne();
    AppMethodBeat.o(104934);
    return false;
  }
  
  public final void fne()
  {
    long l;
    for (;;)
    {
      SmileyInfo localSmileyInfo;
      try
      {
        AppMethodBeat.i(104936);
        ad.i("MicroMsg.QQSmileyManager", "updateSmiley " + bt.flS());
        l = System.currentTimeMillis();
        this.Ike.clear();
        this.Ikf.clear();
        this.Ikg.clear();
        fnc();
        this.Ikc = ((PluginEmoji)g.ad(PluginEmoji.class)).getProvider().cgv();
        if ((this.Ikc == null) || (this.Ikc.isEmpty())) {
          this.Ikc = com.tencent.mm.emoji.d.b.e(new com.tencent.mm.vfs.e("assets:///newemoji/newemoji-config.xml"));
        }
        if ((this.Ikc == null) || (this.Ikc.isEmpty())) {
          break;
        }
        Iterator localIterator = this.Ikc.iterator();
        if (!localIterator.hasNext()) {
          break label660;
        }
        localSmileyInfo = (SmileyInfo)localIterator.next();
        this.Ike.put(localSmileyInfo.field_key, localSmileyInfo);
        this.Ikf.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
        this.Ikd.add(new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
        if ((bt.isNullOrNil(localSmileyInfo.field_cnValue)) || ("null".equalsIgnoreCase(localSmileyInfo.field_cnValue)))
        {
          this.Ikd.add(new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bt.isNullOrNil(localSmileyInfo.field_qqValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_qqValue))) {
            break label528;
          }
          this.Ikd.add(new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bt.isNullOrNil(localSmileyInfo.field_twValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_twValue))) {
            break label559;
          }
          this.Ikd.add(new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bt.isNullOrNil(localSmileyInfo.field_enValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_enValue))) {
            break label590;
          }
          this.Ikd.add(new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bt.isNullOrNil(localSmileyInfo.field_thValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_thValue))) {
            break label621;
          }
          this.Ikd.add(new a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          continue;
        }
        this.Ikd.add(new a(-1, localSmileyInfo.field_cnValue, localSmileyInfo.field_fileName));
      }
      finally {}
      continue;
      label528:
      this.Ikd.add(new a(-1, localSmileyInfo.field_qqValue, localSmileyInfo.field_fileName));
      continue;
      label559:
      this.Ikd.add(new a(-1, localSmileyInfo.field_twValue, localSmileyInfo.field_fileName));
      continue;
      label590:
      this.Ikd.add(new a(-1, localSmileyInfo.field_enValue, localSmileyInfo.field_fileName));
      continue;
      label621:
      this.Ikd.add(new a(-1, localSmileyInfo.field_thValue, localSmileyInfo.field_fileName));
    }
    ad.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
    label660:
    Collections.sort(this.Ikd, Iki);
    ad.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104936);
  }
  
  public static final class a
  {
    public String name;
    public int pos;
    public String text;
    
    a() {}
    
    a(int paramInt, String paramString1, String paramString2)
    {
      this.pos = paramInt;
      this.text = paramString1;
      this.name = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cf.f
 * JD-Core Version:    0.7.0.1
 */