package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class c
  extends DataSetObservable
{
  static final String LOG_TAG = c.class.getSimpleName();
  private static final Object Zd = new Object();
  private static final Map<String, c> Ze = new HashMap();
  final Object Zf;
  final List<c.a> Zg;
  private final List<c.c> Zh;
  final String Zi;
  private b Zj;
  private int Zk;
  boolean Zl;
  private boolean Zm;
  private boolean Zn;
  private boolean Zo;
  private c.d Zp;
  final Context mContext;
  private Intent mIntent;
  
  private void gK()
  {
    if (!this.Zm) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.Zn) {}
    do
    {
      return;
      this.Zn = false;
    } while (TextUtils.isEmpty(this.Zi));
    new c.e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.Zh), this.Zi });
  }
  
  private boolean gM()
  {
    if ((this.Zj != null) && (this.mIntent != null) && (!this.Zg.isEmpty()) && (!this.Zh.isEmpty()))
    {
      Collections.unmodifiableList(this.Zh);
      return true;
    }
    return false;
  }
  
  private boolean gN()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Zo)
    {
      bool1 = bool2;
      if (this.mIntent != null)
      {
        this.Zo = false;
        this.Zg.clear();
        List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
          this.Zg.add(new c.a(localResolveInfo));
          i += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean gO()
  {
    if ((this.Zl) && (this.Zn) && (!TextUtils.isEmpty(this.Zi)))
    {
      this.Zl = false;
      this.Zm = true;
      gQ();
      return true;
    }
    return false;
  }
  
  private void gP()
  {
    int j = this.Zh.size() - this.Zk;
    if (j <= 0) {}
    for (;;)
    {
      return;
      this.Zn = true;
      int i = 0;
      while (i < j)
      {
        this.Zh.remove(0);
        i += 1;
      }
    }
  }
  
  /* Error */
  private void gQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	android/support/v7/widget/c:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 81	android/support/v7/widget/c:Zi	Ljava/lang/String;
    //   8: invokevirtual 184	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 190	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc 192
    //   20: invokeinterface 198 3 0
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq +18 -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +13 -> 47
    //   37: aload_3
    //   38: invokeinterface 201 1 0
    //   43: istore_1
    //   44: goto -17 -> 27
    //   47: ldc 203
    //   49: aload_3
    //   50: invokeinterface 206 1 0
    //   55: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +40 -> 98
    //   61: new 178	org/xmlpull/v1/XmlPullParserException
    //   64: dup
    //   65: ldc 213
    //   67: invokespecial 214	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: new 216	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 218
    //   78: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 81	android/support/v7/widget/c:Zi	Ljava/lang/String;
    //   85: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 228	java/io/FileInputStream:close	()V
    //   97: return
    //   98: aload_0
    //   99: getfield 100	android/support/v7/widget/c:Zh	Ljava/util/List;
    //   102: astore 4
    //   104: aload 4
    //   106: invokeinterface 131 1 0
    //   111: aload_3
    //   112: invokeinterface 201 1 0
    //   117: istore_1
    //   118: iload_1
    //   119: iconst_1
    //   120: if_icmpeq +128 -> 248
    //   123: iload_1
    //   124: iconst_3
    //   125: if_icmpeq -14 -> 111
    //   128: iload_1
    //   129: iconst_4
    //   130: if_icmpeq -19 -> 111
    //   133: ldc 230
    //   135: aload_3
    //   136: invokeinterface 206 1 0
    //   141: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +42 -> 186
    //   147: new 178	org/xmlpull/v1/XmlPullParserException
    //   150: dup
    //   151: ldc 232
    //   153: invokespecial 214	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_3
    //   158: new 216	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 218
    //   164: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 81	android/support/v7/widget/c:Zi	Ljava/lang/String;
    //   171: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: ifnull -79 -> 97
    //   179: aload_2
    //   180: invokevirtual 228	java/io/FileInputStream:close	()V
    //   183: return
    //   184: astore_2
    //   185: return
    //   186: aload 4
    //   188: new 11	android/support/v7/widget/c$c
    //   191: dup
    //   192: aload_3
    //   193: aconst_null
    //   194: ldc 234
    //   196: invokeinterface 238 3 0
    //   201: aload_3
    //   202: aconst_null
    //   203: ldc 240
    //   205: invokeinterface 238 3 0
    //   210: invokestatic 246	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: aload_3
    //   214: aconst_null
    //   215: ldc 248
    //   217: invokeinterface 238 3 0
    //   222: invokestatic 254	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   225: invokespecial 257	android/support/v7/widget/c$c:<init>	(Ljava/lang/String;JF)V
    //   228: invokeinterface 162 2 0
    //   233: pop
    //   234: goto -123 -> 111
    //   237: astore_3
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 228	java/io/FileInputStream:close	()V
    //   246: aload_3
    //   247: athrow
    //   248: aload_2
    //   249: ifnull -152 -> 97
    //   252: aload_2
    //   253: invokevirtual 228	java/io/FileInputStream:close	()V
    //   256: return
    //   257: astore_2
    //   258: return
    //   259: astore_2
    //   260: return
    //   261: astore_2
    //   262: goto -16 -> 246
    //   265: astore_2
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	c
    //   26	105	1	i	int
    //   11	169	2	localFileInputStream	java.io.FileInputStream
    //   184	69	2	localIOException1	java.io.IOException
    //   257	1	2	localIOException2	java.io.IOException
    //   259	1	2	localIOException3	java.io.IOException
    //   261	1	2	localIOException4	java.io.IOException
    //   265	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   15	35	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   71	65	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   157	57	3	localIOException5	java.io.IOException
    //   237	10	3	localObject	Object
    //   102	85	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   12	25	71	org/xmlpull/v1/XmlPullParserException
    //   37	44	71	org/xmlpull/v1/XmlPullParserException
    //   47	71	71	org/xmlpull/v1/XmlPullParserException
    //   98	111	71	org/xmlpull/v1/XmlPullParserException
    //   111	118	71	org/xmlpull/v1/XmlPullParserException
    //   133	157	71	org/xmlpull/v1/XmlPullParserException
    //   186	234	71	org/xmlpull/v1/XmlPullParserException
    //   12	25	157	java/io/IOException
    //   37	44	157	java/io/IOException
    //   47	71	157	java/io/IOException
    //   98	111	157	java/io/IOException
    //   111	118	157	java/io/IOException
    //   133	157	157	java/io/IOException
    //   186	234	157	java/io/IOException
    //   179	183	184	java/io/IOException
    //   12	25	237	finally
    //   37	44	237	finally
    //   47	71	237	finally
    //   72	89	237	finally
    //   98	111	237	finally
    //   111	118	237	finally
    //   133	157	237	finally
    //   158	175	237	finally
    //   186	234	237	finally
    //   252	256	257	java/io/IOException
    //   93	97	259	java/io/IOException
    //   242	246	261	java/io/IOException
    //   0	12	265	java/io/FileNotFoundException
  }
  
  public final int a(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int i;
      synchronized (this.Zf)
      {
        gL();
        List localList = this.Zg;
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (((c.a)localList.get(i)).resolveInfo == paramResolveInfo) {
            return i;
          }
        }
        else {
          return -1;
        }
      }
      i += 1;
    }
  }
  
  final boolean a(c.c paramc)
  {
    boolean bool = this.Zh.add(paramc);
    if (bool)
    {
      this.Zn = true;
      gP();
      gK();
      gM();
      notifyChanged();
    }
    return bool;
  }
  
  public final ResolveInfo be(int paramInt)
  {
    synchronized (this.Zf)
    {
      gL();
      ResolveInfo localResolveInfo = ((c.a)this.Zg.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public final Intent bg(int paramInt)
  {
    synchronized (this.Zf)
    {
      if (this.mIntent == null) {
        return null;
      }
      gL();
      Object localObject2 = (c.a)this.Zg.get(paramInt);
      localObject2 = new ComponentName(((c.a)localObject2).resolveInfo.activityInfo.packageName, ((c.a)localObject2).resolveInfo.activityInfo.name);
      Intent localIntent = new Intent(this.mIntent);
      localIntent.setComponent((ComponentName)localObject2);
      if (this.Zp != null)
      {
        new Intent(localIntent);
        if (this.Zp.gR()) {
          return null;
        }
      }
      a(new c.c((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent;
    }
  }
  
  public final int gI()
  {
    synchronized (this.Zf)
    {
      gL();
      int i = this.Zg.size();
      return i;
    }
  }
  
  public final ResolveInfo gJ()
  {
    synchronized (this.Zf)
    {
      gL();
      if (!this.Zg.isEmpty())
      {
        ResolveInfo localResolveInfo = ((c.a)this.Zg.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  final void gL()
  {
    boolean bool1 = gN();
    boolean bool2 = gO();
    gP();
    if ((bool1 | bool2))
    {
      gM();
      notifyChanged();
    }
  }
  
  public final int getHistorySize()
  {
    synchronized (this.Zf)
    {
      gL();
      int i = this.Zh.size();
      return i;
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.c
 * JD-Core Version:    0.7.0.1
 */