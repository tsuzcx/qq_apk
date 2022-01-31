package com.tencent.mm.cd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.SmileyInfo;
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
  private static volatile f yuJ;
  public static Pattern yuU;
  private static final Comparator<f.a> yuV;
  public String[] yuK;
  public String[] yuL;
  public String[] yuM;
  public String[] yuN;
  public String[] yuO;
  public String[] yuP;
  public ArrayList<SmileyInfo> yuQ;
  private final List<f.a> yuR;
  private HashMap<String, SmileyInfo> yuS;
  private SparseArray<String> yuT;
  
  static
  {
    AppMethodBeat.i(62690);
    yuJ = null;
    yuV = new f.1();
    AppMethodBeat.o(62690);
  }
  
  private f(Context paramContext)
  {
    AppMethodBeat.i(62676);
    this.yuK = null;
    this.yuL = null;
    this.yuM = null;
    this.yuN = null;
    this.yuO = null;
    this.yuP = null;
    this.yuR = Collections.synchronizedList(new LinkedList());
    this.yuS = new HashMap();
    this.yuT = new SparseArray();
    long l = System.currentTimeMillis();
    this.yuK = paramContext.getResources().getStringArray(2131755053);
    this.yuL = paramContext.getResources().getStringArray(2131755056);
    this.yuM = paramContext.getResources().getStringArray(2131755054);
    this.yuN = paramContext.getResources().getStringArray(2131755058);
    this.yuO = paramContext.getResources().getStringArray(2131755055);
    this.yuP = paramContext.getResources().getStringArray(2131755057);
    dvh();
    ab.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(62676);
  }
  
  private static Drawable a(f.a parama)
  {
    AppMethodBeat.i(62686);
    int i = parama.pos;
    if (i >= 0) {}
    for (parama = b.duW().qA(i);; parama = aqF(parama.name))
    {
      AppMethodBeat.o(62686);
      return parama;
    }
  }
  
  private boolean a(int paramInt1, SpannableString paramSpannableString, int paramInt2)
  {
    AppMethodBeat.i(62685);
    f.a locala = aqE(paramSpannableString.subSequence(paramInt1, paramSpannableString.length()));
    if (locala != null)
    {
      Drawable localDrawable = a(locala);
      if ((localDrawable != null) && (paramInt1 <= paramSpannableString.length()) && (locala.text.length() + paramInt1 <= paramSpannableString.length()))
      {
        b.duW().a(paramSpannableString, localDrawable, paramInt1, paramInt1 + locala.text.length(), paramInt2);
        AppMethodBeat.o(62685);
        return true;
      }
      ab.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[] { locala.toString() });
    }
    AppMethodBeat.o(62685);
    return false;
  }
  
  /* Error */
  static Drawable aqF(String paramString)
  {
    // Byte code:
    //   0: ldc 205
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 163	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   12: invokestatic 210	com/tencent/mm/ao/a:agm	()Ljava/lang/String;
    //   15: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore_1
    //   26: aload_1
    //   27: invokestatic 219	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   30: ifeq +81 -> 111
    //   33: aload_1
    //   34: invokestatic 223	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: new 225	android/graphics/BitmapFactory$Options
    //   43: dup
    //   44: invokespecial 226	android/graphics/BitmapFactory$Options:<init>	()V
    //   47: astore_2
    //   48: aload_0
    //   49: astore_1
    //   50: aload_2
    //   51: getstatic 232	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   54: putfield 235	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: aconst_null
    //   61: aload_2
    //   62: invokestatic 241	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: astore_2
    //   66: aload_2
    //   67: ifnonnull +12 -> 79
    //   70: aload_0
    //   71: astore_1
    //   72: ldc 120
    //   74: ldc 243
    //   76: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: astore_1
    //   81: new 248	android/graphics/drawable/BitmapDrawable
    //   84: dup
    //   85: invokestatic 254	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   88: invokevirtual 102	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   91: aload_2
    //   92: invokespecial 257	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   95: astore_2
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 262	java/io/InputStream:close	()V
    //   104: ldc 205
    //   106: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: areturn
    //   111: ldc 120
    //   113: ldc_w 264
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_1
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_0
    //   127: aastore
    //   128: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: invokestatic 254	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   134: invokevirtual 271	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   137: ldc_w 273
    //   140: aload_0
    //   141: invokestatic 276	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: invokevirtual 280	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 285	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   150: astore_0
    //   151: goto -113 -> 38
    //   154: astore_0
    //   155: ldc 120
    //   157: aload_0
    //   158: invokestatic 291	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   161: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: goto -60 -> 104
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_0
    //   170: aload_0
    //   171: astore_1
    //   172: ldc 120
    //   174: aload_2
    //   175: invokestatic 291	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   178: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 262	java/io/InputStream:close	()V
    //   189: ldc 205
    //   191: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_0
    //   197: ldc 120
    //   199: aload_0
    //   200: invokestatic 291	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   203: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: goto -17 -> 189
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 262	java/io/InputStream:close	()V
    //   220: ldc 205
    //   222: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_0
    //   226: athrow
    //   227: astore_1
    //   228: ldc 120
    //   230: aload_1
    //   231: invokestatic 291	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   234: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -17 -> 220
    //   240: astore_0
    //   241: goto -29 -> 212
    //   244: astore_2
    //   245: goto -75 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString	String
    //   25	192	1	str	String
    //   227	4	1	localIOException1	java.io.IOException
    //   47	63	2	localObject	Object
    //   167	8	2	localIOException2	java.io.IOException
    //   244	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   100	104	154	java/io/IOException
    //   26	38	167	java/io/IOException
    //   111	151	167	java/io/IOException
    //   185	189	196	java/io/IOException
    //   26	38	209	finally
    //   111	151	209	finally
    //   216	220	227	java/io/IOException
    //   40	48	240	finally
    //   50	57	240	finally
    //   59	66	240	finally
    //   72	79	240	finally
    //   81	96	240	finally
    //   172	181	240	finally
    //   40	48	244	java/io/IOException
    //   50	57	244	java/io/IOException
    //   59	66	244	java/io/IOException
    //   72	79	244	java/io/IOException
    //   81	96	244	java/io/IOException
  }
  
  public static f dvf()
  {
    AppMethodBeat.i(62677);
    if (yuJ == null) {}
    try
    {
      if (yuJ == null) {
        yuJ = new f(ah.getContext());
      }
      f localf = yuJ;
      AppMethodBeat.o(62677);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(62677);
    }
  }
  
  private int dvg()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(62678);
        this.yuR.clear();
        if ((this.yuK != null) && (this.yuM != null) && (this.yuK.length == this.yuM.length))
        {
          j = this.yuK.length;
          i = 0;
          if (i >= j) {
            break label448;
          }
          String str6 = this.yuK[i];
          String str7 = this.yuM[i];
          if ((this.yuL != null) && (this.yuL.length > i))
          {
            String str1 = this.yuL[i];
            if ((this.yuN == null) || (this.yuN.length <= i)) {
              break label424;
            }
            str3 = this.yuN[i];
            if ((this.yuO == null) || (this.yuO.length <= i)) {
              break label432;
            }
            str4 = this.yuO[i];
            if ((this.yuP == null) || (this.yuP.length <= i)) {
              break label440;
            }
            str5 = this.yuP[i];
            SmileyInfo localSmileyInfo = new SmileyInfo(str6, str1, str7, str3, str4, str5, i);
            this.yuR.add(new f.a(i, str6, ""));
            this.yuR.add(new f.a(i, str7, ""));
            this.yuR.add(new f.a(i, str1, ""));
            this.yuR.add(new f.a(i, str3, ""));
            this.yuR.add(new f.a(i, str4, ""));
            this.yuR.add(new f.a(i, str5, ""));
            this.yuS.put(str6, localSmileyInfo);
            this.yuT.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
            i += 1;
            continue;
            if ((this.yuQ == null) || (this.yuQ.isEmpty())) {
              Collections.sort(this.yuR, yuV);
            }
            AppMethodBeat.o(62678);
            return i;
          }
        }
        else
        {
          ab.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
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
  
  private static void eu(List<SmileyInfo> paramList)
  {
    AppMethodBeat.i(62680);
    paramList = paramList.iterator();
    SmileyInfo localSmileyInfo;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localSmileyInfo = (SmileyInfo)paramList.next();
    } while (com.tencent.mm.vfs.e.cN(com.tencent.mm.ao.a.agm() + localSmileyInfo.field_fileName));
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.QQSmileyManager", "checkFile %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        ((d)g.G(d.class)).getProvider().bkZ();
      }
      AppMethodBeat.o(62680);
      return;
    }
  }
  
  public final boolean aqD(String paramString)
  {
    AppMethodBeat.i(62682);
    if (aqE(paramString) != null)
    {
      AppMethodBeat.o(62682);
      return true;
    }
    AppMethodBeat.o(62682);
    return false;
  }
  
  public final f.a aqE(String paramString)
  {
    AppMethodBeat.i(62683);
    for (;;)
    {
      synchronized (this.yuR)
      {
        f.a locala = new f.a(0, paramString, "");
        int i = Collections.binarySearch(this.yuR, locala, yuV);
        if (i < 0)
        {
          i = -i - 2;
          if ((i >= 0) && (i < this.yuR.size()))
          {
            locala = (f.a)this.yuR.get(i);
            if ((locala != null) && (paramString != null) && (paramString.startsWith(locala.text)))
            {
              paramString = (f.a)this.yuR.get(i);
              AppMethodBeat.o(62683);
              return paramString;
            }
          }
          AppMethodBeat.o(62683);
          return null;
        }
      }
    }
  }
  
  public final SmileyInfo aqG(String paramString)
  {
    AppMethodBeat.i(62688);
    if ((this.yuS != null) && (this.yuS.containsKey(paramString)))
    {
      paramString = (SmileyInfo)this.yuS.get(paramString);
      AppMethodBeat.o(62688);
      return paramString;
    }
    ab.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[] { paramString.replace("\\", "\\\\") });
    AppMethodBeat.o(62688);
    return null;
  }
  
  public final SpannableString b(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62684);
    if ((paramSpannableString == null) || (paramSpannableString.length() == 0))
    {
      AppMethodBeat.o(62684);
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
    AppMethodBeat.o(62684);
    return paramSpannableString;
  }
  
  public final boolean dvh()
  {
    AppMethodBeat.i(62679);
    ab.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
    ArrayList localArrayList = ((d)g.G(d.class)).getProvider().bkU();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      dvi();
      AppMethodBeat.o(62679);
      return true;
    }
    eu(localArrayList);
    dvi();
    AppMethodBeat.o(62679);
    return false;
  }
  
  public final void dvi()
  {
    long l;
    for (;;)
    {
      SmileyInfo localSmileyInfo;
      try
      {
        AppMethodBeat.i(62681);
        ab.i("MicroMsg.QQSmileyManager", "updateSmiley " + bo.dtY());
        l = System.currentTimeMillis();
        this.yuS.clear();
        this.yuT.clear();
        dvg();
        this.yuQ = ((PluginEmoji)g.G(PluginEmoji.class)).getProvider().bkU();
        if ((this.yuQ == null) || (this.yuQ.isEmpty())) {
          this.yuQ = com.tencent.mm.emoji.e.a.a(new com.tencent.mm.vfs.b("assets:///newemoji/newemoji-config.xml"));
        }
        if ((this.yuQ == null) || (this.yuQ.isEmpty())) {
          break;
        }
        Iterator localIterator = this.yuQ.iterator();
        if (!localIterator.hasNext()) {
          break label651;
        }
        localSmileyInfo = (SmileyInfo)localIterator.next();
        this.yuS.put(localSmileyInfo.field_key, localSmileyInfo);
        this.yuT.put(localSmileyInfo.field_eggIndex, localSmileyInfo.field_key);
        this.yuR.add(new f.a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
        if ((bo.isNullOrNil(localSmileyInfo.field_cnValue)) || ("null".equalsIgnoreCase(localSmileyInfo.field_cnValue)))
        {
          this.yuR.add(new f.a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bo.isNullOrNil(localSmileyInfo.field_qqValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_qqValue))) {
            break label519;
          }
          this.yuR.add(new f.a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bo.isNullOrNil(localSmileyInfo.field_twValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_twValue))) {
            break label550;
          }
          this.yuR.add(new f.a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bo.isNullOrNil(localSmileyInfo.field_enValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_enValue))) {
            break label581;
          }
          this.yuR.add(new f.a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          if ((!bo.isNullOrNil(localSmileyInfo.field_thValue)) && (!"null".equalsIgnoreCase(localSmileyInfo.field_thValue))) {
            break label612;
          }
          this.yuR.add(new f.a(-1, localSmileyInfo.field_key, localSmileyInfo.field_fileName));
          continue;
        }
        this.yuR.add(new f.a(-1, localSmileyInfo.field_cnValue, localSmileyInfo.field_fileName));
      }
      finally {}
      continue;
      label519:
      this.yuR.add(new f.a(-1, localSmileyInfo.field_qqValue, localSmileyInfo.field_fileName));
      continue;
      label550:
      this.yuR.add(new f.a(-1, localSmileyInfo.field_twValue, localSmileyInfo.field_fileName));
      continue;
      label581:
      this.yuR.add(new f.a(-1, localSmileyInfo.field_enValue, localSmileyInfo.field_fileName));
      continue;
      label612:
      this.yuR.add(new f.a(-1, localSmileyInfo.field_thValue, localSmileyInfo.field_fileName));
    }
    ab.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
    label651:
    Collections.sort(this.yuR, yuV);
    ab.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(62681);
  }
  
  public final ArrayList<String> dvj()
  {
    AppMethodBeat.i(62689);
    ArrayList localArrayList = new ArrayList();
    if (this.yuQ != null)
    {
      Iterator localIterator = this.yuQ.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((SmileyInfo)localIterator.next()).field_key);
      }
    }
    AppMethodBeat.o(62689);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cd.f
 * JD-Core Version:    0.7.0.1
 */