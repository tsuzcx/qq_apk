package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class c
  extends DataSetObservable
{
  static final String LOG_TAG;
  private static final Object qx;
  private static final Map<String, c> qy;
  final Context mContext;
  private Intent mIntent;
  final List<a> qA;
  private final List<c> qB;
  final String qC;
  private b qD;
  private int qE;
  boolean qF;
  private boolean qG;
  private boolean qH;
  private boolean qI;
  private d qJ;
  final Object qz;
  
  static
  {
    AppMethodBeat.i(200081);
    LOG_TAG = c.class.getSimpleName();
    qx = new Object();
    qy = new HashMap();
    AppMethodBeat.o(200081);
  }
  
  private void dR()
  {
    AppMethodBeat.i(199988);
    if (!this.qG)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("No preceding call to #readHistoricalData");
      AppMethodBeat.o(199988);
      throw localIllegalStateException;
    }
    if (!this.qH)
    {
      AppMethodBeat.o(199988);
      return;
    }
    this.qH = false;
    if (!TextUtils.isEmpty(this.qC)) {
      new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.qB), this.qC });
    }
    AppMethodBeat.o(199988);
  }
  
  private boolean dU()
  {
    AppMethodBeat.i(200003);
    if ((this.qD != null) && (this.mIntent != null) && (!this.qA.isEmpty()) && (!this.qB.isEmpty()))
    {
      Collections.unmodifiableList(this.qB);
      AppMethodBeat.o(200003);
      return true;
    }
    AppMethodBeat.o(200003);
    return false;
  }
  
  private boolean dV()
  {
    AppMethodBeat.i(200018);
    if ((this.qI) && (this.mIntent != null))
    {
      this.qI = false;
      this.qA.clear();
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        this.qA.add(new a(localResolveInfo));
        i += 1;
      }
      AppMethodBeat.o(200018);
      return true;
    }
    AppMethodBeat.o(200018);
    return false;
  }
  
  private boolean dW()
  {
    AppMethodBeat.i(200028);
    if ((this.qF) && (this.qH) && (!TextUtils.isEmpty(this.qC)))
    {
      this.qF = false;
      this.qG = true;
      dY();
      AppMethodBeat.o(200028);
      return true;
    }
    AppMethodBeat.o(200028);
    return false;
  }
  
  private void dX()
  {
    AppMethodBeat.i(200041);
    int j = this.qB.size() - this.qE;
    if (j <= 0)
    {
      AppMethodBeat.o(200041);
      return;
    }
    this.qH = true;
    int i = 0;
    while (i < j)
    {
      this.qB.remove(0);
      i += 1;
    }
    AppMethodBeat.o(200041);
  }
  
  /* Error */
  private void dY()
  {
    // Byte code:
    //   0: ldc 200
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 150	androidx/appcompat/widget/c:mContext	Landroid/content/Context;
    //   9: aload_0
    //   10: getfield 96	androidx/appcompat/widget/c:qC	Ljava/lang/String;
    //   13: invokevirtual 204	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   16: astore_2
    //   17: invokestatic 210	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   20: astore_3
    //   21: aload_3
    //   22: aload_2
    //   23: ldc 212
    //   25: invokeinterface 218 3 0
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_1
    //   34: if_icmpeq +25 -> 59
    //   37: iload_1
    //   38: iconst_2
    //   39: if_icmpeq +20 -> 59
    //   42: aload_3
    //   43: invokeinterface 221 1 0
    //   48: istore_1
    //   49: goto -17 -> 32
    //   52: astore_2
    //   53: ldc 200
    //   55: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: ldc 223
    //   61: aload_3
    //   62: invokeinterface 226 1 0
    //   67: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +52 -> 122
    //   73: new 197	org/xmlpull/v1/XmlPullParserException
    //   76: dup
    //   77: ldc 233
    //   79: invokespecial 234	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   82: astore_3
    //   83: ldc 200
    //   85: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_3
    //   89: athrow
    //   90: astore_3
    //   91: new 236	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 238
    //   97: invokespecial 239	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 96	androidx/appcompat/widget/c:qC	Ljava/lang/String;
    //   104: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_2
    //   109: ifnull +215 -> 324
    //   112: aload_2
    //   113: invokevirtual 248	java/io/FileInputStream:close	()V
    //   116: ldc 200
    //   118: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: aload_0
    //   123: getfield 115	androidx/appcompat/widget/c:qB	Ljava/util/List;
    //   126: astore 4
    //   128: aload 4
    //   130: invokeinterface 148 1 0
    //   135: aload_3
    //   136: invokeinterface 221 1 0
    //   141: istore_1
    //   142: iload_1
    //   143: iconst_1
    //   144: if_icmpeq +145 -> 289
    //   147: iload_1
    //   148: iconst_3
    //   149: if_icmpeq -14 -> 135
    //   152: iload_1
    //   153: iconst_4
    //   154: if_icmpeq -19 -> 135
    //   157: ldc 250
    //   159: aload_3
    //   160: invokeinterface 226 1 0
    //   165: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifne +52 -> 220
    //   171: new 197	org/xmlpull/v1/XmlPullParserException
    //   174: dup
    //   175: ldc 252
    //   177: invokespecial 234	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   180: astore_3
    //   181: ldc 200
    //   183: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_3
    //   187: athrow
    //   188: astore_3
    //   189: new 236	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 238
    //   195: invokespecial 239	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 96	androidx/appcompat/widget/c:qC	Ljava/lang/String;
    //   202: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: ifnull +117 -> 324
    //   210: aload_2
    //   211: invokevirtual 248	java/io/FileInputStream:close	()V
    //   214: ldc 200
    //   216: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: return
    //   220: aload 4
    //   222: new 12	androidx/appcompat/widget/c$c
    //   225: dup
    //   226: aload_3
    //   227: aconst_null
    //   228: ldc 254
    //   230: invokeinterface 258 3 0
    //   235: aload_3
    //   236: aconst_null
    //   237: ldc_w 260
    //   240: invokeinterface 258 3 0
    //   245: invokestatic 266	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   248: aload_3
    //   249: aconst_null
    //   250: ldc_w 268
    //   253: invokeinterface 258 3 0
    //   258: invokestatic 274	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   261: invokespecial 277	androidx/appcompat/widget/c$c:<init>	(Ljava/lang/String;JF)V
    //   264: invokeinterface 179 2 0
    //   269: pop
    //   270: goto -135 -> 135
    //   273: astore_3
    //   274: aload_2
    //   275: ifnull +7 -> 282
    //   278: aload_2
    //   279: invokevirtual 248	java/io/FileInputStream:close	()V
    //   282: ldc 200
    //   284: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload_3
    //   288: athrow
    //   289: aload_2
    //   290: ifnull +34 -> 324
    //   293: aload_2
    //   294: invokevirtual 248	java/io/FileInputStream:close	()V
    //   297: ldc 200
    //   299: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_2
    //   304: ldc 200
    //   306: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: return
    //   310: astore_2
    //   311: ldc 200
    //   313: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: return
    //   317: astore_2
    //   318: ldc 200
    //   320: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: return
    //   324: ldc 200
    //   326: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: astore_2
    //   331: goto -49 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	c
    //   31	124	1	i	int
    //   16	7	2	localFileInputStream	java.io.FileInputStream
    //   52	242	2	localFileNotFoundException	java.io.FileNotFoundException
    //   303	1	2	localIOException1	java.io.IOException
    //   310	1	2	localIOException2	java.io.IOException
    //   317	1	2	localIOException3	java.io.IOException
    //   330	1	2	localIOException4	java.io.IOException
    //   20	69	3	localObject1	Object
    //   90	70	3	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   180	7	3	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   188	61	3	localIOException5	java.io.IOException
    //   273	15	3	localObject2	Object
    //   126	95	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   5	17	52	java/io/FileNotFoundException
    //   17	30	90	org/xmlpull/v1/XmlPullParserException
    //   42	49	90	org/xmlpull/v1/XmlPullParserException
    //   59	90	90	org/xmlpull/v1/XmlPullParserException
    //   122	135	90	org/xmlpull/v1/XmlPullParserException
    //   135	142	90	org/xmlpull/v1/XmlPullParserException
    //   157	188	90	org/xmlpull/v1/XmlPullParserException
    //   220	270	90	org/xmlpull/v1/XmlPullParserException
    //   17	30	188	java/io/IOException
    //   42	49	188	java/io/IOException
    //   59	90	188	java/io/IOException
    //   122	135	188	java/io/IOException
    //   135	142	188	java/io/IOException
    //   157	188	188	java/io/IOException
    //   220	270	188	java/io/IOException
    //   17	30	273	finally
    //   42	49	273	finally
    //   59	90	273	finally
    //   91	108	273	finally
    //   122	135	273	finally
    //   135	142	273	finally
    //   157	188	273	finally
    //   189	206	273	finally
    //   220	270	273	finally
    //   293	297	303	java/io/IOException
    //   112	116	310	java/io/IOException
    //   210	214	317	java/io/IOException
    //   278	282	330	java/io/IOException
  }
  
  public final int a(ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(200127);
    synchronized (this.qz)
    {
      dT();
      List localList = this.qA;
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        if (((a)localList.get(i)).qK == paramResolveInfo)
        {
          AppMethodBeat.o(200127);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(200127);
      return -1;
    }
  }
  
  final boolean a(c paramc)
  {
    AppMethodBeat.i(200196);
    boolean bool = this.qB.add(paramc);
    if (bool)
    {
      this.qH = true;
      dX();
      dR();
      dU();
      notifyChanged();
    }
    AppMethodBeat.o(200196);
    return bool;
  }
  
  public final ResolveInfo al(int paramInt)
  {
    AppMethodBeat.i(200111);
    synchronized (this.qz)
    {
      dT();
      ResolveInfo localResolveInfo = ((a)this.qA.get(paramInt)).qK;
      AppMethodBeat.o(200111);
      return localResolveInfo;
    }
  }
  
  public final Intent am(int paramInt)
  {
    AppMethodBeat.i(200142);
    synchronized (this.qz)
    {
      if (this.mIntent == null)
      {
        AppMethodBeat.o(200142);
        return null;
      }
      dT();
      Object localObject2 = (a)this.qA.get(paramInt);
      localObject2 = new ComponentName(((a)localObject2).qK.activityInfo.packageName, ((a)localObject2).qK.activityInfo.name);
      Intent localIntent = new Intent(this.mIntent);
      localIntent.setComponent((ComponentName)localObject2);
      if (this.qJ != null)
      {
        new Intent(localIntent);
        if (this.qJ.dZ())
        {
          AppMethodBeat.o(200142);
          return null;
        }
      }
      a(new c((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      AppMethodBeat.o(200142);
      return localIntent;
    }
  }
  
  public final int dP()
  {
    AppMethodBeat.i(200096);
    synchronized (this.qz)
    {
      dT();
      int i = this.qA.size();
      AppMethodBeat.o(200096);
      return i;
    }
  }
  
  public final ResolveInfo dQ()
  {
    AppMethodBeat.i(200158);
    synchronized (this.qz)
    {
      dT();
      if (!this.qA.isEmpty())
      {
        ResolveInfo localResolveInfo = ((a)this.qA.get(0)).qK;
        AppMethodBeat.o(200158);
        return localResolveInfo;
      }
      AppMethodBeat.o(200158);
      return null;
    }
  }
  
  public final int dS()
  {
    AppMethodBeat.i(200171);
    synchronized (this.qz)
    {
      dT();
      int i = this.qB.size();
      AppMethodBeat.o(200171);
      return i;
    }
  }
  
  final void dT()
  {
    AppMethodBeat.i(200183);
    boolean bool1 = dV();
    boolean bool2 = dW();
    dX();
    if ((bool1 | bool2))
    {
      dU();
      notifyChanged();
    }
    AppMethodBeat.o(200183);
  }
  
  public static final class a
    implements Comparable<a>
  {
    public final ResolveInfo qK;
    public float qL;
    
    public a(ResolveInfo paramResolveInfo)
    {
      this.qK = paramResolveInfo;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199383);
      if (this == paramObject)
      {
        AppMethodBeat.o(199383);
        return true;
      }
      if (paramObject == null)
      {
        AppMethodBeat.o(199383);
        return false;
      }
      if (getClass() != paramObject.getClass())
      {
        AppMethodBeat.o(199383);
        return false;
      }
      paramObject = (a)paramObject;
      if (Float.floatToIntBits(this.qL) != Float.floatToIntBits(paramObject.qL))
      {
        AppMethodBeat.o(199383);
        return false;
      }
      AppMethodBeat.o(199383);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(199372);
      int i = Float.floatToIntBits(this.qL);
      AppMethodBeat.o(199372);
      return i + 31;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199390);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append("resolveInfo:").append(this.qK.toString());
      ((StringBuilder)localObject).append("; weight:").append(new BigDecimal(this.qL));
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(199390);
      return localObject;
    }
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public final float qL;
    public final ComponentName qM;
    public final long time;
    
    public c(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.qM = paramComponentName;
      this.time = paramLong;
      this.qL = paramFloat;
    }
    
    public c(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
      AppMethodBeat.i(199348);
      AppMethodBeat.o(199348);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199371);
      if (this == paramObject)
      {
        AppMethodBeat.o(199371);
        return true;
      }
      if (paramObject == null)
      {
        AppMethodBeat.o(199371);
        return false;
      }
      if (getClass() != paramObject.getClass())
      {
        AppMethodBeat.o(199371);
        return false;
      }
      paramObject = (c)paramObject;
      if (this.qM == null)
      {
        if (paramObject.qM != null)
        {
          AppMethodBeat.o(199371);
          return false;
        }
      }
      else if (!this.qM.equals(paramObject.qM))
      {
        AppMethodBeat.o(199371);
        return false;
      }
      if (this.time != paramObject.time)
      {
        AppMethodBeat.o(199371);
        return false;
      }
      if (Float.floatToIntBits(this.qL) != Float.floatToIntBits(paramObject.qL))
      {
        AppMethodBeat.o(199371);
        return false;
      }
      AppMethodBeat.o(199371);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(199364);
      if (this.qM == null) {}
      for (int i = 0;; i = this.qM.hashCode())
      {
        int j = (int)(this.time ^ this.time >>> 32);
        int k = Float.floatToIntBits(this.qL);
        AppMethodBeat.o(199364);
        return ((i + 31) * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199382);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append("; activity:").append(this.qM);
      ((StringBuilder)localObject).append("; time:").append(this.time);
      ((StringBuilder)localObject).append("; weight:").append(new BigDecimal(this.qL));
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(199382);
      return localObject;
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean dZ();
  }
  
  final class e
    extends AsyncTask<Object, Void, Void>
  {
    e() {}
    
    /* Error */
    private Void b(Object... paramVarArgs)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: ldc 29
      //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_1
      //   8: iconst_0
      //   9: aaload
      //   10: checkcast 37	java/util/List
      //   13: astore 4
      //   15: aload_1
      //   16: iconst_1
      //   17: aaload
      //   18: checkcast 39	java/lang/String
      //   21: astore_1
      //   22: aload_0
      //   23: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   26: getfield 43	androidx/appcompat/widget/c:mContext	Landroid/content/Context;
      //   29: aload_1
      //   30: iconst_0
      //   31: invokevirtual 49	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   34: astore_1
      //   35: invokestatic 55	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   38: astore 5
      //   40: aload 5
      //   42: aload_1
      //   43: aconst_null
      //   44: invokeinterface 61 3 0
      //   49: aload 5
      //   51: ldc 63
      //   53: getstatic 69	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   56: invokeinterface 73 3 0
      //   61: aload 5
      //   63: aconst_null
      //   64: ldc 75
      //   66: invokeinterface 79 3 0
      //   71: pop
      //   72: aload 4
      //   74: invokeinterface 83 1 0
      //   79: istore_3
      //   80: iload_2
      //   81: iload_3
      //   82: if_icmpge +114 -> 196
      //   85: aload 4
      //   87: iconst_0
      //   88: invokeinterface 87 2 0
      //   93: checkcast 89	androidx/appcompat/widget/c$c
      //   96: astore 6
      //   98: aload 5
      //   100: aconst_null
      //   101: ldc 91
      //   103: invokeinterface 79 3 0
      //   108: pop
      //   109: aload 5
      //   111: aconst_null
      //   112: ldc 93
      //   114: aload 6
      //   116: getfield 97	androidx/appcompat/widget/c$c:qM	Landroid/content/ComponentName;
      //   119: invokevirtual 103	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   122: invokeinterface 107 4 0
      //   127: pop
      //   128: aload 5
      //   130: aconst_null
      //   131: ldc 109
      //   133: aload 6
      //   135: getfield 112	androidx/appcompat/widget/c$c:time	J
      //   138: invokestatic 116	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   141: invokeinterface 107 4 0
      //   146: pop
      //   147: aload 5
      //   149: aconst_null
      //   150: ldc 118
      //   152: aload 6
      //   154: getfield 122	androidx/appcompat/widget/c$c:qL	F
      //   157: invokestatic 125	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   160: invokeinterface 107 4 0
      //   165: pop
      //   166: aload 5
      //   168: aconst_null
      //   169: ldc 91
      //   171: invokeinterface 128 3 0
      //   176: pop
      //   177: iload_2
      //   178: iconst_1
      //   179: iadd
      //   180: istore_2
      //   181: goto -101 -> 80
      //   184: astore_1
      //   185: getstatic 132	androidx/appcompat/widget/c:LOG_TAG	Ljava/lang/String;
      //   188: astore_1
      //   189: ldc 29
      //   191: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   194: aconst_null
      //   195: areturn
      //   196: aload 5
      //   198: aconst_null
      //   199: ldc 75
      //   201: invokeinterface 128 3 0
      //   206: pop
      //   207: aload 5
      //   209: invokeinterface 138 1 0
      //   214: aload_0
      //   215: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   218: iconst_1
      //   219: putfield 142	androidx/appcompat/widget/c:qF	Z
      //   222: aload_1
      //   223: ifnull +7 -> 230
      //   226: aload_1
      //   227: invokevirtual 147	java/io/FileOutputStream:close	()V
      //   230: ldc 29
      //   232: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   235: aconst_null
      //   236: areturn
      //   237: astore 4
      //   239: getstatic 132	androidx/appcompat/widget/c:LOG_TAG	Ljava/lang/String;
      //   242: astore 4
      //   244: new 149	java/lang/StringBuilder
      //   247: dup
      //   248: ldc 151
      //   250: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   253: aload_0
      //   254: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   257: getfield 157	androidx/appcompat/widget/c:qC	Ljava/lang/String;
      //   260: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   263: pop
      //   264: aload_0
      //   265: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   268: iconst_1
      //   269: putfield 142	androidx/appcompat/widget/c:qF	Z
      //   272: aload_1
      //   273: ifnull -43 -> 230
      //   276: aload_1
      //   277: invokevirtual 147	java/io/FileOutputStream:close	()V
      //   280: goto -50 -> 230
      //   283: astore_1
      //   284: goto -54 -> 230
      //   287: astore 4
      //   289: getstatic 132	androidx/appcompat/widget/c:LOG_TAG	Ljava/lang/String;
      //   292: astore 4
      //   294: new 149	java/lang/StringBuilder
      //   297: dup
      //   298: ldc 151
      //   300: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   303: aload_0
      //   304: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   307: getfield 157	androidx/appcompat/widget/c:qC	Ljava/lang/String;
      //   310: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   313: pop
      //   314: aload_0
      //   315: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   318: iconst_1
      //   319: putfield 142	androidx/appcompat/widget/c:qF	Z
      //   322: aload_1
      //   323: ifnull -93 -> 230
      //   326: aload_1
      //   327: invokevirtual 147	java/io/FileOutputStream:close	()V
      //   330: goto -100 -> 230
      //   333: astore_1
      //   334: goto -104 -> 230
      //   337: astore 4
      //   339: getstatic 132	androidx/appcompat/widget/c:LOG_TAG	Ljava/lang/String;
      //   342: astore 4
      //   344: new 149	java/lang/StringBuilder
      //   347: dup
      //   348: ldc 151
      //   350: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   353: aload_0
      //   354: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   357: getfield 157	androidx/appcompat/widget/c:qC	Ljava/lang/String;
      //   360: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   363: pop
      //   364: aload_0
      //   365: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   368: iconst_1
      //   369: putfield 142	androidx/appcompat/widget/c:qF	Z
      //   372: aload_1
      //   373: ifnull -143 -> 230
      //   376: aload_1
      //   377: invokevirtual 147	java/io/FileOutputStream:close	()V
      //   380: goto -150 -> 230
      //   383: astore_1
      //   384: goto -154 -> 230
      //   387: astore 4
      //   389: aload_0
      //   390: getfield 14	androidx/appcompat/widget/c$e:qN	Landroidx/appcompat/widget/c;
      //   393: iconst_1
      //   394: putfield 142	androidx/appcompat/widget/c:qF	Z
      //   397: aload_1
      //   398: ifnull +7 -> 405
      //   401: aload_1
      //   402: invokevirtual 147	java/io/FileOutputStream:close	()V
      //   405: ldc 29
      //   407: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   410: aload 4
      //   412: athrow
      //   413: astore_1
      //   414: goto -184 -> 230
      //   417: astore_1
      //   418: goto -13 -> 405
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	421	0	this	e
      //   0	421	1	paramVarArgs	Object[]
      //   1	180	2	i	int
      //   79	4	3	j	int
      //   13	73	4	localList	List
      //   237	1	4	localIllegalArgumentException	java.lang.IllegalArgumentException
      //   242	1	4	str1	String
      //   287	1	4	localIllegalStateException	IllegalStateException
      //   292	1	4	str2	String
      //   337	1	4	localIOException	java.io.IOException
      //   342	1	4	str3	String
      //   387	24	4	localObject	Object
      //   38	170	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
      //   96	57	6	localc	c.c
      // Exception table:
      //   from	to	target	type
      //   22	35	184	java/io/FileNotFoundException
      //   40	80	237	java/lang/IllegalArgumentException
      //   85	177	237	java/lang/IllegalArgumentException
      //   196	214	237	java/lang/IllegalArgumentException
      //   276	280	283	java/io/IOException
      //   40	80	287	java/lang/IllegalStateException
      //   85	177	287	java/lang/IllegalStateException
      //   196	214	287	java/lang/IllegalStateException
      //   326	330	333	java/io/IOException
      //   40	80	337	java/io/IOException
      //   85	177	337	java/io/IOException
      //   196	214	337	java/io/IOException
      //   376	380	383	java/io/IOException
      //   40	80	387	finally
      //   85	177	387	finally
      //   196	214	387	finally
      //   239	264	387	finally
      //   289	314	387	finally
      //   339	364	387	finally
      //   226	230	413	java/io/IOException
      //   401	405	417	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.c
 * JD-Core Version:    0.7.0.1
 */