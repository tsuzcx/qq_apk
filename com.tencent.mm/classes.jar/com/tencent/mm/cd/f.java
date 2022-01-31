package com.tencent.mm.cd;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.l.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class f
{
  private static volatile f ulf = null;
  public static Pattern ulq;
  private static final Comparator<f.a> ulr = new f.1();
  public String[] ulg = null;
  public String[] ulh = null;
  public String[] uli = null;
  public String[] ulj = null;
  public String[] ulk = null;
  public String[] ull = null;
  public ArrayList<q> ulm;
  private ArrayList<f.a> uln = new ArrayList();
  private HashMap<String, q> ulo = new HashMap();
  private SparseArray<String> ulp = new SparseArray();
  
  private f(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.ulg = paramContext.getResources().getStringArray(a.a.smiley_values);
    this.ulh = paramContext.getResources().getStringArray(a.a.smiley_values_old);
    this.uli = paramContext.getResources().getStringArray(a.a.smiley_values_ch);
    this.ulj = paramContext.getResources().getStringArray(a.a.smiley_values_tw);
    this.ulk = paramContext.getResources().getStringArray(a.a.smiley_values_en);
    this.ull = paramContext.getResources().getStringArray(a.a.smiley_values_th);
    csJ();
    y.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private boolean a(int paramInt1, SpannableString paramSpannableString, int paramInt2)
  {
    boolean bool = false;
    f.a locala = aau(paramSpannableString.subSequence(paramInt1, paramSpannableString.length()));
    int i;
    if (locala != null)
    {
      i = locala.pos;
      if (i < 0) {
        break label115;
      }
    }
    label115:
    for (Drawable localDrawable = b.csC().mW(i); (localDrawable != null) && (paramInt1 <= paramSpannableString.length()) && (locala.text.length() + paramInt1 <= paramSpannableString.length()); localDrawable = aav(locala.name))
    {
      b.csC().a(paramSpannableString, localDrawable, paramInt1, paramInt1 + locala.text.length(), paramInt2);
      bool = true;
      return bool;
    }
    y.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", new Object[] { locala.toString() });
    return false;
  }
  
  /* Error */
  static Drawable aav(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 135	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   9: invokestatic 200	com/tencent/mm/an/a:Nz	()Ljava/lang/String;
    //   12: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 209	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   27: ifeq +76 -> 103
    //   30: aload_2
    //   31: invokestatic 213	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_0
    //   35: aload_0
    //   36: astore_1
    //   37: new 215	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 216	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore_2
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: getstatic 222	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   51: putfield 225	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   54: aload_0
    //   55: astore_1
    //   56: aload_0
    //   57: aconst_null
    //   58: aload_2
    //   59: invokestatic 231	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnonnull +12 -> 76
    //   67: aload_0
    //   68: astore_1
    //   69: ldc 117
    //   71: ldc 233
    //   73: invokestatic 236	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: astore_1
    //   78: new 238	android/graphics/drawable/BitmapDrawable
    //   81: dup
    //   82: invokestatic 244	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   85: invokevirtual 84	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   88: aload_2
    //   89: invokespecial 247	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   92: astore_2
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 252	java/io/InputStream:close	()V
    //   101: aload_2
    //   102: areturn
    //   103: ldc 117
    //   105: ldc 254
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_2
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_0
    //   118: aastore
    //   119: invokestatic 257	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: invokestatic 244	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   125: invokevirtual 261	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   128: new 135	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 263
    //   135: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 271	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   148: astore_0
    //   149: goto -114 -> 35
    //   152: astore_0
    //   153: ldc 117
    //   155: aload_0
    //   156: invokestatic 277	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: invokestatic 236	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: areturn
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_0
    //   167: aload_0
    //   168: astore_1
    //   169: ldc 117
    //   171: aload_2
    //   172: invokestatic 277	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   175: invokestatic 236	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 252	java/io/InputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: ldc 117
    //   191: aload_0
    //   192: invokestatic 277	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   195: invokestatic 236	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -12 -> 186
    //   201: astore_0
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 252	java/io/InputStream:close	()V
    //   210: aload_0
    //   211: athrow
    //   212: astore_1
    //   213: ldc 117
    //   215: aload_1
    //   216: invokestatic 277	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   219: invokestatic 236	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: goto -12 -> 210
    //   225: astore_0
    //   226: goto -24 -> 202
    //   229: astore_2
    //   230: goto -63 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramString	String
    //   1	206	1	str	String
    //   212	4	1	localIOException1	java.io.IOException
    //   22	141	2	localObject	Object
    //   164	8	2	localIOException2	java.io.IOException
    //   229	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   97	101	152	java/io/IOException
    //   23	35	164	java/io/IOException
    //   103	149	164	java/io/IOException
    //   182	186	188	java/io/IOException
    //   23	35	201	finally
    //   103	149	201	finally
    //   206	210	212	java/io/IOException
    //   37	45	225	finally
    //   47	54	225	finally
    //   56	63	225	finally
    //   69	76	225	finally
    //   78	93	225	finally
    //   169	178	225	finally
    //   37	45	229	java/io/IOException
    //   47	54	229	java/io/IOException
    //   56	63	229	java/io/IOException
    //   69	76	229	java/io/IOException
    //   78	93	229	java/io/IOException
  }
  
  public static f csI()
  {
    if (ulf == null) {}
    try
    {
      if (ulf == null) {
        ulf = new f(ae.getContext());
      }
      return ulf;
    }
    finally {}
  }
  
  private int csJ()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        this.uln.clear();
        if ((this.ulg != null) && (this.uli != null) && (this.ulg.length == this.uli.length))
        {
          j = this.ulg.length;
          i = 0;
          if (i >= j) {
            break label422;
          }
          String str6 = this.ulg[i];
          String str7 = this.uli[i];
          if ((this.ulh != null) && (this.ulh.length > i))
          {
            String str1 = this.ulh[i];
            if ((this.ulj == null) || (this.ulj.length <= i)) {
              break label398;
            }
            str3 = this.ulj[i];
            if ((this.ulk == null) || (this.ulk.length <= i)) {
              break label406;
            }
            str4 = this.ulk[i];
            if ((this.ull == null) || (this.ull.length <= i)) {
              break label414;
            }
            str5 = this.ull[i];
            q localq = new q(str6, str1, str7, str3, str4, str5, i);
            this.uln.add(new f.a(i, str6, ""));
            this.uln.add(new f.a(i, str7, ""));
            this.uln.add(new f.a(i, str1, ""));
            this.uln.add(new f.a(i, str3, ""));
            this.uln.add(new f.a(i, str4, ""));
            this.uln.add(new f.a(i, str5, ""));
            this.ulo.put(str6, localq);
            this.ulp.put(localq.field_eggIndex, localq.field_key);
            i += 1;
            continue;
            if ((this.ulm == null) || (this.ulm.isEmpty())) {
              Collections.sort(this.uln, ulr);
            }
            return i;
          }
        }
        else
        {
          y.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
          continue;
        }
        String str2 = "";
      }
      finally {}
      continue;
      label398:
      String str3 = "";
      continue;
      label406:
      String str4 = "";
      continue;
      label414:
      String str5 = "";
      continue;
      label422:
      i = j;
    }
  }
  
  public static void dm(List<q> paramList)
  {
    paramList = paramList.iterator();
    q localq;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localq = (q)paramList.next();
    } while (e.bK(com.tencent.mm.an.a.Nz() + localq.field_fileName));
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.QQSmileyManager", "checkFile %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHl();
      }
      return;
    }
  }
  
  public final f.a aau(String paramString)
  {
    int i;
    if (this.uln != null)
    {
      f.a locala = new f.a(0, paramString, "");
      i = Collections.binarySearch(this.uln, locala, ulr);
      if (i >= 0) {
        break label80;
      }
      i = -i - 2;
    }
    label80:
    for (;;)
    {
      if ((i >= 0) && (paramString.startsWith(((f.a)this.uln.get(i)).text))) {
        return (f.a)this.uln.get(i);
      }
      return null;
    }
  }
  
  public final q aaw(String paramString)
  {
    if ((this.ulo != null) && (this.ulo.containsKey(paramString))) {
      return (q)this.ulo.get(paramString);
    }
    y.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[] { paramString.replace("\\", "\\\\") });
    return null;
  }
  
  public final SpannableString b(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    if ((paramSpannableString == null) || (paramSpannableString.length() == 0)) {
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
  }
  
  public final void csK()
  {
    y.i("MicroMsg.QQSmileyManager", "updateSmiley " + bk.csb());
    long l = System.currentTimeMillis();
    this.ulo.clear();
    this.ulp.clear();
    csJ();
    this.ulm = ((PluginEmoji)g.t(PluginEmoji.class)).getEmojiMgr().aHh();
    if ((this.ulm == null) || (this.ulm.isEmpty())) {
      this.ulm = com.tencent.mm.u.b.a.a(new com.tencent.mm.vfs.b("assets:///newemoji/newemoji-config.xml"));
    }
    Iterator localIterator;
    if ((this.ulm != null) && (!this.ulm.isEmpty())) {
      localIterator = this.ulm.iterator();
    }
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      this.ulo.put(localq.field_key, localq);
      this.ulp.put(localq.field_eggIndex, localq.field_key);
      this.uln.add(new f.a(-1, localq.field_key, localq.field_fileName));
      if ((bk.bl(localq.field_cnValue)) || ("null".equalsIgnoreCase(localq.field_cnValue)))
      {
        this.uln.add(new f.a(-1, localq.field_key, localq.field_fileName));
        label256:
        if ((!bk.bl(localq.field_qqValue)) && (!"null".equalsIgnoreCase(localq.field_qqValue))) {
          break label492;
        }
        this.uln.add(new f.a(-1, localq.field_key, localq.field_fileName));
        label307:
        if ((!bk.bl(localq.field_twValue)) && (!"null".equalsIgnoreCase(localq.field_twValue))) {
          break label521;
        }
        this.uln.add(new f.a(-1, localq.field_key, localq.field_fileName));
        label358:
        if ((!bk.bl(localq.field_enValue)) && (!"null".equalsIgnoreCase(localq.field_enValue))) {
          break label550;
        }
        this.uln.add(new f.a(-1, localq.field_key, localq.field_fileName));
      }
      for (;;)
      {
        if ((!bk.bl(localq.field_thValue)) && (!"null".equalsIgnoreCase(localq.field_thValue))) {
          break label579;
        }
        this.uln.add(new f.a(-1, localq.field_key, localq.field_fileName));
        break;
        this.uln.add(new f.a(-1, localq.field_cnValue, localq.field_fileName));
        break label256;
        label492:
        this.uln.add(new f.a(-1, localq.field_qqValue, localq.field_fileName));
        break label307;
        label521:
        this.uln.add(new f.a(-1, localq.field_twValue, localq.field_fileName));
        break label358;
        label550:
        this.uln.add(new f.a(-1, localq.field_enValue, localq.field_fileName));
      }
      label579:
      this.uln.add(new f.a(-1, localq.field_thValue, localq.field_fileName));
      continue;
      y.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
    }
    Collections.sort(this.uln, ulr);
    y.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final ArrayList<String> csL()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.ulm != null)
    {
      Iterator localIterator = this.ulm.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((q)localIterator.next()).field_key);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cd.f
 * JD-Core Version:    0.7.0.1
 */