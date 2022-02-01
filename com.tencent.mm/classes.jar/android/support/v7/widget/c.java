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
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

class c
  extends DataSetObservable
{
  static final String LOG_TAG = c.class.getSimpleName();
  private static final Object ajg = new Object();
  private static final Map<String, c> ajh = new HashMap();
  final Object aji;
  final List<a> ajj;
  private final List<c> ajk;
  final String ajl;
  private b ajm;
  private int ajn;
  boolean ajo;
  private boolean ajp;
  private boolean ajq;
  private boolean ajr;
  private d ajs;
  final Context mContext;
  private Intent mIntent;
  
  private void iO()
  {
    if (!this.ajp) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.ajq) {}
    do
    {
      return;
      this.ajq = false;
    } while (TextUtils.isEmpty(this.ajl));
    new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.ajk), this.ajl });
  }
  
  private boolean iQ()
  {
    if ((this.ajm != null) && (this.mIntent != null) && (!this.ajj.isEmpty()) && (!this.ajk.isEmpty()))
    {
      Collections.unmodifiableList(this.ajk);
      return true;
    }
    return false;
  }
  
  private boolean iR()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ajr)
    {
      bool1 = bool2;
      if (this.mIntent != null)
      {
        this.ajr = false;
        this.ajj.clear();
        List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
          this.ajj.add(new a(localResolveInfo));
          i += 1;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean iS()
  {
    if ((this.ajo) && (this.ajq) && (!TextUtils.isEmpty(this.ajl)))
    {
      this.ajo = false;
      this.ajp = true;
      iU();
      return true;
    }
    return false;
  }
  
  private void iT()
  {
    int j = this.ajk.size() - this.ajn;
    if (j <= 0) {}
    for (;;)
    {
      return;
      this.ajq = true;
      int i = 0;
      while (i < j)
      {
        this.ajk.remove(0);
        i += 1;
      }
    }
  }
  
  /* Error */
  private void iU()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	android/support/v7/widget/c:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 85	android/support/v7/widget/c:ajl	Ljava/lang/String;
    //   8: invokevirtual 188	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 194	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc 196
    //   20: invokeinterface 202 3 0
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq +18 -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq +13 -> 47
    //   37: aload_3
    //   38: invokeinterface 205 1 0
    //   43: istore_1
    //   44: goto -17 -> 27
    //   47: ldc 207
    //   49: aload_3
    //   50: invokeinterface 210 1 0
    //   55: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +40 -> 98
    //   61: new 182	org/xmlpull/v1/XmlPullParserException
    //   64: dup
    //   65: ldc 217
    //   67: invokespecial 218	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_3
    //   72: new 220	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 222
    //   78: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 85	android/support/v7/widget/c:ajl	Ljava/lang/String;
    //   85: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 232	java/io/FileInputStream:close	()V
    //   97: return
    //   98: aload_0
    //   99: getfield 104	android/support/v7/widget/c:ajk	Ljava/util/List;
    //   102: astore 4
    //   104: aload 4
    //   106: invokeinterface 135 1 0
    //   111: aload_3
    //   112: invokeinterface 205 1 0
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
    //   133: ldc 234
    //   135: aload_3
    //   136: invokeinterface 210 1 0
    //   141: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +42 -> 186
    //   147: new 182	org/xmlpull/v1/XmlPullParserException
    //   150: dup
    //   151: ldc 236
    //   153: invokespecial 218	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_3
    //   158: new 220	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 222
    //   164: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 85	android/support/v7/widget/c:ajl	Ljava/lang/String;
    //   171: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: ifnull -79 -> 97
    //   179: aload_2
    //   180: invokevirtual 232	java/io/FileInputStream:close	()V
    //   183: return
    //   184: astore_2
    //   185: return
    //   186: aload 4
    //   188: new 12	android/support/v7/widget/c$c
    //   191: dup
    //   192: aload_3
    //   193: aconst_null
    //   194: ldc 238
    //   196: invokeinterface 242 3 0
    //   201: aload_3
    //   202: aconst_null
    //   203: ldc 244
    //   205: invokeinterface 242 3 0
    //   210: invokestatic 250	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   213: aload_3
    //   214: aconst_null
    //   215: ldc 252
    //   217: invokeinterface 242 3 0
    //   222: invokestatic 258	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   225: invokespecial 261	android/support/v7/widget/c$c:<init>	(Ljava/lang/String;JF)V
    //   228: invokeinterface 166 2 0
    //   233: pop
    //   234: goto -123 -> 111
    //   237: astore_3
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 232	java/io/FileInputStream:close	()V
    //   246: aload_3
    //   247: athrow
    //   248: aload_2
    //   249: ifnull -152 -> 97
    //   252: aload_2
    //   253: invokevirtual 232	java/io/FileInputStream:close	()V
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
    //   184	69	2	localIOException1	IOException
    //   257	1	2	localIOException2	IOException
    //   259	1	2	localIOException3	IOException
    //   261	1	2	localIOException4	IOException
    //   265	1	2	localFileNotFoundException	FileNotFoundException
    //   15	35	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   71	65	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   157	57	3	localIOException5	IOException
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
      synchronized (this.aji)
      {
        iP();
        List localList = this.ajj;
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (((a)localList.get(i)).resolveInfo == paramResolveInfo) {
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
  
  final boolean a(c paramc)
  {
    boolean bool = this.ajk.add(paramc);
    if (bool)
    {
      this.ajq = true;
      iT();
      iO();
      iQ();
      notifyChanged();
    }
    return bool;
  }
  
  public final ResolveInfo by(int paramInt)
  {
    synchronized (this.aji)
    {
      iP();
      ResolveInfo localResolveInfo = ((a)this.ajj.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public final Intent bz(int paramInt)
  {
    synchronized (this.aji)
    {
      if (this.mIntent == null) {
        return null;
      }
      iP();
      Object localObject2 = (a)this.ajj.get(paramInt);
      localObject2 = new ComponentName(((a)localObject2).resolveInfo.activityInfo.packageName, ((a)localObject2).resolveInfo.activityInfo.name);
      Intent localIntent = new Intent(this.mIntent);
      localIntent.setComponent((ComponentName)localObject2);
      if (this.ajs != null)
      {
        new Intent(localIntent);
        if (this.ajs.iV()) {
          return null;
        }
      }
      a(new c((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent;
    }
  }
  
  public final int getHistorySize()
  {
    synchronized (this.aji)
    {
      iP();
      int i = this.ajk.size();
      return i;
    }
  }
  
  public final int iM()
  {
    synchronized (this.aji)
    {
      iP();
      int i = this.ajj.size();
      return i;
    }
  }
  
  public final ResolveInfo iN()
  {
    synchronized (this.aji)
    {
      iP();
      if (!this.ajj.isEmpty())
      {
        ResolveInfo localResolveInfo = ((a)this.ajj.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  final void iP()
  {
    boolean bool1 = iR();
    boolean bool2 = iS();
    iT();
    if ((bool1 | bool2))
    {
      iQ();
      notifyChanged();
    }
  }
  
  public static final class a
    implements Comparable<a>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public a(ResolveInfo paramResolveInfo)
    {
      this.resolveInfo = paramResolveInfo;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (a)paramObject;
      } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight));
      return false;
    }
    
    public final int hashCode()
    {
      return Float.floatToIntBits(this.weight) + 31;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public final ComponentName ajt;
    public final long time;
    public final float weight;
    
    public c(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.ajt = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }
    
    public c(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.ajt == null)
        {
          if (paramObject.ajt != null) {
            return false;
          }
        }
        else if (!this.ajt.equals(paramObject.ajt)) {
          return false;
        }
        if (this.time != paramObject.time) {
          return false;
        }
      } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.ajt == null) {}
      for (int i = 0;; i = this.ajt.hashCode()) {
        return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.ajt);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean iV();
  }
  
  final class e
    extends AsyncTask<Object, Void, Void>
  {
    e() {}
    
    private Void b(Object... paramVarArgs)
    {
      int i = 0;
      List localList = (List)paramVarArgs[0];
      paramVarArgs = (String)paramVarArgs[1];
      for (;;)
      {
        try
        {
          paramVarArgs = c.this.mContext.openFileOutput(paramVarArgs, 0);
          localXmlSerializer = Xml.newSerializer();
          int j;
          c.c localc;
          localXmlSerializer.endTag(null, "historical-records");
        }
        catch (FileNotFoundException paramVarArgs)
        {
          try
          {
            localXmlSerializer.setOutput(paramVarArgs, null);
            localXmlSerializer.startDocument("UTF-8", Boolean.TRUE);
            localXmlSerializer.startTag(null, "historical-records");
            j = localList.size();
            if (i >= j) {
              break label186;
            }
            localc = (c.c)localList.remove(0);
            localXmlSerializer.startTag(null, "historical-record");
            localXmlSerializer.attribute(null, "activity", localc.ajt.flattenToString());
            localXmlSerializer.attribute(null, "time", String.valueOf(localc.time));
            localXmlSerializer.attribute(null, "weight", String.valueOf(localc.weight));
            localXmlSerializer.endTag(null, "historical-record");
            i += 1;
            continue;
            paramVarArgs = paramVarArgs;
            paramVarArgs = c.LOG_TAG;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            XmlSerializer localXmlSerializer;
            String str1 = c.LOG_TAG;
            new StringBuilder("Error writing historical record file: ").append(c.this.ajl);
            c.this.ajo = true;
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IllegalStateException localIllegalStateException)
          {
            String str2 = c.LOG_TAG;
            new StringBuilder("Error writing historical record file: ").append(c.this.ajl);
            c.this.ajo = true;
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          catch (IOException localIOException)
          {
            String str3 = c.LOG_TAG;
            new StringBuilder("Error writing historical record file: ").append(c.this.ajl);
            c.this.ajo = true;
            if (paramVarArgs == null) {
              continue;
            }
            try
            {
              paramVarArgs.close();
              return null;
            }
            catch (IOException paramVarArgs)
            {
              return null;
            }
          }
          finally
          {
            c.this.ajo = true;
            if (paramVarArgs == null) {
              break label387;
            }
          }
          return null;
        }
        label186:
        localXmlSerializer.endDocument();
        c.this.ajo = true;
        if (paramVarArgs != null) {
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
      }
      try
      {
        paramVarArgs.close();
        label387:
        throw localObject;
      }
      catch (IOException paramVarArgs)
      {
        break label387;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.c
 * JD-Core Version:    0.7.0.1
 */