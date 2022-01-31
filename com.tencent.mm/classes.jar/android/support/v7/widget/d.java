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

class d
  extends DataSetObservable
{
  static final String LT = d.class.getSimpleName();
  private static final Object Ys = new Object();
  private static final Map<String, d> Yt = new HashMap();
  boolean YA;
  private boolean YB;
  private boolean YC;
  private boolean YD;
  private d.d YE;
  final Object Yu;
  final List<d.a> Yv;
  private final List<d.c> Yw;
  final String Yx;
  private d.b Yy;
  private int Yz;
  final Context mContext;
  private Intent mIntent;
  
  private boolean fR()
  {
    if ((this.Yy != null) && (this.mIntent != null) && (!this.Yv.isEmpty()) && (!this.Yw.isEmpty()))
    {
      Collections.unmodifiableList(this.Yw);
      return true;
    }
    return false;
  }
  
  private void fS()
  {
    int j = this.Yw.size() - this.Yz;
    if (j <= 0) {}
    for (;;)
    {
      return;
      this.YC = true;
      int i = 0;
      while (i < j)
      {
        this.Yw.remove(0);
        i += 1;
      }
    }
  }
  
  /* Error */
  private void fT()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	android/support/v7/widget/d:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 111	android/support/v7/widget/d:Yx	Ljava/lang/String;
    //   8: invokevirtual 117	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 123	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc 125
    //   20: invokeinterface 131 3 0
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq +18 -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +13 -> 47
    //   37: aload_3
    //   38: invokeinterface 134 1 0
    //   43: istore_1
    //   44: goto -17 -> 27
    //   47: ldc 136
    //   49: aload_3
    //   50: invokeinterface 139 1 0
    //   55: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +40 -> 98
    //   61: new 105	org/xmlpull/v1/XmlPullParserException
    //   64: dup
    //   65: ldc 147
    //   67: invokespecial 150	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: new 152	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 154
    //   78: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 111	android/support/v7/widget/d:Yx	Ljava/lang/String;
    //   85: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 164	java/io/FileInputStream:close	()V
    //   97: return
    //   98: aload_0
    //   99: getfield 81	android/support/v7/widget/d:Yw	Ljava/util/List;
    //   102: astore 4
    //   104: aload 4
    //   106: invokeinterface 167 1 0
    //   111: aload_3
    //   112: invokeinterface 134 1 0
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
    //   133: ldc 169
    //   135: aload_3
    //   136: invokeinterface 139 1 0
    //   141: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +42 -> 186
    //   147: new 105	org/xmlpull/v1/XmlPullParserException
    //   150: dup
    //   151: ldc 171
    //   153: invokespecial 150	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_3
    //   158: new 152	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 154
    //   164: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 111	android/support/v7/widget/d:Yx	Ljava/lang/String;
    //   171: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: ifnull -79 -> 97
    //   179: aload_2
    //   180: invokevirtual 164	java/io/FileInputStream:close	()V
    //   183: return
    //   184: astore_2
    //   185: return
    //   186: aload 4
    //   188: new 10	android/support/v7/widget/d$c
    //   191: dup
    //   192: aload_3
    //   193: aconst_null
    //   194: ldc 173
    //   196: invokeinterface 177 3 0
    //   201: aload_3
    //   202: aconst_null
    //   203: ldc 179
    //   205: invokeinterface 177 3 0
    //   210: invokestatic 185	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: aload_3
    //   214: aconst_null
    //   215: ldc 187
    //   217: invokeinterface 177 3 0
    //   222: invokestatic 193	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   225: invokespecial 196	android/support/v7/widget/d$c:<init>	(Ljava/lang/String;JF)V
    //   228: invokeinterface 199 2 0
    //   233: pop
    //   234: goto -123 -> 111
    //   237: astore_3
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 164	java/io/FileInputStream:close	()V
    //   246: aload_3
    //   247: athrow
    //   248: aload_2
    //   249: ifnull -152 -> 97
    //   252: aload_2
    //   253: invokevirtual 164	java/io/FileInputStream:close	()V
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
    //   0	267	0	this	d
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
      synchronized (this.Yu)
      {
        fQ();
        List localList = this.Yv;
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (((d.a)localList.get(i)).resolveInfo == paramResolveInfo) {
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
  
  final boolean a(d.c paramc)
  {
    boolean bool = this.Yw.add(paramc);
    if (bool)
    {
      this.YC = true;
      fS();
      if (!this.YB) {
        throw new IllegalStateException("No preceding call to #readHistoricalData");
      }
      if (this.YC)
      {
        this.YC = false;
        if (!TextUtils.isEmpty(this.Yx)) {
          new d.e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.Yw), this.Yx });
        }
      }
      fR();
      notifyChanged();
    }
    return bool;
  }
  
  public final ResolveInfo bh(int paramInt)
  {
    synchronized (this.Yu)
    {
      fQ();
      ResolveInfo localResolveInfo = ((d.a)this.Yv.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public final Intent bi(int paramInt)
  {
    synchronized (this.Yu)
    {
      if (this.mIntent == null) {
        return null;
      }
      fQ();
      Object localObject2 = (d.a)this.Yv.get(paramInt);
      localObject2 = new ComponentName(((d.a)localObject2).resolveInfo.activityInfo.packageName, ((d.a)localObject2).resolveInfo.activityInfo.name);
      Intent localIntent = new Intent(this.mIntent);
      localIntent.setComponent((ComponentName)localObject2);
      if (this.YE != null)
      {
        new Intent(localIntent);
        if (this.YE.fU()) {
          return null;
        }
      }
      a(new d.c((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent;
    }
  }
  
  public final int fO()
  {
    synchronized (this.Yu)
    {
      fQ();
      int i = this.Yv.size();
      return i;
    }
  }
  
  public final ResolveInfo fP()
  {
    synchronized (this.Yu)
    {
      fQ();
      if (!this.Yv.isEmpty())
      {
        ResolveInfo localResolveInfo = ((d.a)this.Yv.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  final void fQ()
  {
    int j = 1;
    int i;
    if ((this.YD) && (this.mIntent != null))
    {
      this.YD = false;
      this.Yv.clear();
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int k = localList.size();
      i = 0;
      while (i < k)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        this.Yv.add(new d.a(localResolveInfo));
        i += 1;
      }
      i = 1;
      if ((!this.YA) || (!this.YC) || (TextUtils.isEmpty(this.Yx))) {
        break label166;
      }
      this.YA = false;
      this.YB = true;
      fT();
    }
    for (;;)
    {
      fS();
      if ((i | j) != 0)
      {
        fR();
        notifyChanged();
      }
      return;
      i = 0;
      break;
      label166:
      j = 0;
    }
  }
  
  public final int getHistorySize()
  {
    synchronized (this.Yu)
    {
      fQ();
      int i = this.Yw.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.d
 * JD-Core Version:    0.7.0.1
 */