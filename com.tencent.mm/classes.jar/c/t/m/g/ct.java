package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ct
  extends cs
{
  private static final String n = "fc4." + cz.b(ct.class.getName()).substring(0, 8);
  public co c = null;
  public boolean d = false;
  public boolean e = false;
  public long f = 102400L;
  public long g = 1800000L;
  public int h = 1;
  public int i = 25600;
  public long j = 104857600L;
  public long k = 10485760L;
  public long l = 259200000L;
  public long m = 2592000000L;
  private Context o = null;
  private final File p;
  private boolean q;
  private Handler r;
  private long s = 0L;
  private volatile List<cp> t;
  private volatile List<ScanResult> u;
  private volatile Location v;
  private BroadcastReceiver w = new ct.1(this);
  
  private ct(Context paramContext, File paramFile)
  {
    this.o = paramContext;
    this.p = paramFile;
    this.d = false;
    this.e = false;
    this.q = false;
  }
  
  public ct(Context paramContext, String paramString)
  {
    this(paramContext, new File(paramString + "/f_c"));
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  private static void a(Handler paramHandler, int paramInt, long paramLong)
  {
    if (paramHandler == null) {}
    for (Looper localLooper = null;; localLooper = paramHandler.getLooper())
    {
      if ((localLooper != null) && (localLooper.getThread().isAlive())) {
        paramHandler.sendMessageDelayed(paramHandler.obtainMessage(paramInt), paramLong);
      }
      return;
    }
  }
  
  public final void a(Location paramLocation, List<ScanResult> paramList, List<cp> paramList1)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramLocation != null)
        {
          long l2 = paramLocation.getTime();
          if (l1 - l2 <= 10000L) {}
        }
        else
        {
          return;
        }
        this.v = paramLocation;
        this.u = paramList;
        this.t = paramList1;
        if (!this.q) {
          continue;
        }
        if (paramList == null)
        {
          if (j.a(paramList1)) {
            continue;
          }
          a(this.r, 2, 0L);
          continue;
        }
        if (j.a(paramList)) {
          continue;
        }
      }
      finally {}
      a(this.r, 1, 0L);
    }
  }
  
  public final void a(Looper paramLooper)
  {
    this.t = null;
    this.u = null;
    this.v = null;
    this.s = 0L;
    if ((this.p != null) && ((this.p.exists()) || (this.p.mkdirs()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      cq.a("DC_Pro", "startup! prepared:" + this.q);
      if (this.q)
      {
        this.r = new a(paramLooper);
        this.s = (System.currentTimeMillis() - 10000L);
        a(this.r, 7, 300000L);
      }
      try
      {
        paramLooper = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.o.registerReceiver(this.w, paramLooper);
        return;
      }
      catch (Throwable paramLooper)
      {
        cq.a("DC_Pro", "listenNetworkState: failed", paramLooper);
      }
    }
  }
  
  public final void b()
  {
    try
    {
      this.o.unregisterReceiver(this.w);
      label11:
      if (this.q)
      {
        a(this.r, 4, 0L);
        a(this.r, 6, 0L);
        this.s = 0L;
        a(this.r, 7, 0L);
        a(this.r, 5, 0L);
        this.r = null;
      }
      cq.a("DC_Pro", "shutdown!");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }
  
  final class a
    extends Handler
  {
    private SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");
    private Object[] b = new Object[0];
    private File c;
    private BufferedOutputStream d;
    private StringBuffer e;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private long a()
    {
      if (ct.b(ct.this)) {}
      for (long l = 51200L; ct.c(ct.this) > l; l = 512000L) {
        return l;
      }
      return ct.c(ct.this);
    }
    
    private static void a(int paramInt, File paramFile)
    {
      for (;;)
      {
        try
        {
          if (!paramFile.isFile()) {
            return;
          }
          long l = System.currentTimeMillis();
          File localFile = new File(paramFile.getAbsolutePath() + "." + l + ".enc");
          if (paramInt == 4)
          {
            byte[] arrayOfByte = j.a(paramFile);
            if (!j.a(arrayOfByte))
            {
              arrayOfByte = cz.a(arrayOfByte);
              if (!j.a(arrayOfByte))
              {
                FileOutputStream localFileOutputStream = new FileOutputStream(localFile, true);
                localFileOutputStream.write(arrayOfByte);
                localFileOutputStream.close();
                paramFile.delete();
              }
            }
            cq.a("DC_Pro", "rename:" + paramFile.getName() + " to " + localFile.getName());
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          cq.a("DC_Pro", "rename:" + paramFile.getName() + " error.", localThrowable);
          return;
        }
        paramFile.renameTo(localThrowable);
      }
    }
    
    private void a(long paramLong1, long paramLong2)
    {
      File[] arrayOfFile;
      if (ct.e(ct.this) == null)
      {
        arrayOfFile = null;
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label40;
        }
      }
      label40:
      long l2;
      Object localObject1;
      label206:
      do
      {
        return;
        arrayOfFile = ct.e(ct.this).listFiles();
        break;
        long l3 = System.currentTimeMillis();
        l2 = 0L;
        localObject1 = null;
        int j = arrayOfFile.length;
        int i = 0;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          Object localObject2 = localObject1;
          long l1 = l2;
          if (localFile.exists())
          {
            localObject2 = localObject1;
            l1 = l2;
            if (localFile.isFile())
            {
              localObject2 = localObject1;
              l1 = l2;
              if (!ct.c().equals(localFile.getName()))
              {
                if ((l3 - localFile.lastModified() <= paramLong1) && (localFile.length() != 0L)) {
                  break label206;
                }
                cq.a("DC_Pro", "delete expired file:" + localFile.getName());
                localFile.delete();
                l1 = l2;
                localObject2 = localObject1;
              }
            }
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            l2 = l1;
            break;
            localObject2 = localFile.getName();
            if ((l3 - localFile.lastModified() > 172800000L) && (!((String)localObject2).endsWith(".enc")) && (((String)localObject2).startsWith("fc4.")))
            {
              a(j.f((String)localObject2), localFile);
              localObject2 = localObject1;
              l1 = l2;
            }
            else
            {
              l2 += localFile.length();
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                l1 = l2;
                if (localObject1.lastModified() <= localFile.lastModified()) {}
              }
              else
              {
                localObject2 = localFile;
                l1 = l2;
              }
            }
          }
        }
      } while ((l2 < paramLong2) || (localObject1 == null));
      cq.a("DC_Pro", "too big folder size:" + l2 + ", delete " + localObject1.getName() + ",size:" + localObject1.length());
      localObject1.delete();
    }
    
    private boolean a(long paramLong)
    {
      try
      {
        Object localObject = PreferenceManager.getDefaultSharedPreferences(ct.p(ct.this));
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        String str = ((SharedPreferences)localObject).getString("log_up_fc_date", "");
        long l = ((SharedPreferences)localObject).getLong("log_up_fc_size", 0L);
        localObject = this.a.format(new Date());
        if (((String)localObject).equals(str))
        {
          if (l > ct.q(ct.this)) {
            return false;
          }
          localEditor.putLong("log_up_fc_size", paramLong + l);
        }
        for (;;)
        {
          localEditor.apply();
          break;
          localEditor.putString("log_up_fc_date", (String)localObject);
          localEditor.putLong("log_up_fc_size", paramLong);
        }
        return true;
      }
      catch (Throwable localThrowable) {}
    }
    
    private boolean a(String paramString)
    {
      Object localObject;
      File[] arrayOfFile;
      if (TextUtils.isEmpty(paramString))
      {
        localObject = null;
        if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory())) {
          break label80;
        }
        arrayOfFile = null;
        label34:
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label90;
        }
        if ((arrayOfFile != null) && (paramString.endsWith("d_c"))) {
          ((File)localObject).delete();
        }
      }
      label80:
      label90:
      int m;
      label152:
      label246:
      do
      {
        return false;
        localObject = new File(paramString);
        break;
        arrayOfFile = ((File)localObject).listFiles();
        break label34;
        long l = System.currentTimeMillis();
        m = ct.j(ct.this);
        int k = 0;
        if ((k < arrayOfFile.length) && (m > 0))
        {
          File localFile = arrayOfFile[k];
          int j;
          if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile()))
          {
            localObject = "";
            if (!((String)localObject).startsWith("dc"))
            {
              j = m;
              if (!((String)localObject).startsWith("fc")) {}
            }
            else
            {
              if ((!paramString.endsWith("d_c")) || ((localFile.length() != 0L) && (l - localFile.lastModified() <= ct.f(ct.this)))) {
                break label246;
              }
              localFile.delete();
              j = m;
            }
          }
          int i;
          do
          {
            do
            {
              do
              {
                k += 1;
                m = j;
                break;
                localObject = localFile.getName();
                break label152;
                if ((!((String)localObject).startsWith("fc2")) && (!((String)localObject).startsWith("fc3"))) {
                  break label534;
                }
                i = 1;
                if (((!((String)localObject).startsWith("fc4.")) || (!((String)localObject).endsWith(".enc"))) && (i == 0)) {
                  break label539;
                }
                j = 1;
                i = j;
                if (j == 0)
                {
                  cq.a("DC_Pro", paramString + ",has no fc4.***.enc files!!!");
                  if ((!((String)localObject).startsWith("dc")) || (System.currentTimeMillis() - localFile.lastModified() <= 172800000L)) {
                    break label544;
                  }
                  i = 1;
                }
                j = m;
              } while (i == 0);
              j = m;
            } while (!a(localFile.length()));
            cq.a("DC_Pro", "upload:" + localFile.getName() + ",len=" + localFile.length());
            i = j.f((String)localObject);
            j = m;
          } while (i <= 0);
          localObject = "http://analytics.map.qq.com/?sf";
          if (i > 1) {
            localObject = "http://analytics.map.qq.com/?sf" + i;
          }
          for (;;)
          {
            j = m;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            localObject = new cu(localFile.getAbsolutePath(), (String)localObject);
            if (!((cu)localObject).c)
            {
              ((cu)localObject).c = true;
              new Thread(new cu.1((cu)localObject), "th_upload_fc").start();
            }
            j = m - 1;
            break;
            i = 0;
            break label270;
            j = 0;
            break label296;
            i = 0;
            break label356;
            if (i != 1) {
              localObject = "";
            }
          }
        }
      } while (m == ct.j(ct.this));
      label270:
      label296:
      label356:
      return true;
    }
    
    private void b()
    {
      if ((this.e == null) || (this.e.length() == 0) || (this.d == null)) {
        return;
      }
      byte[] arrayOfByte = cz.a(this.e.toString());
      StringBuilder localStringBuilder = new StringBuilder("write buf to file:buf:").append(this.e.length()).append(",enc:");
      if (arrayOfByte == null) {}
      for (int i = 0;; i = arrayOfByte.length)
      {
        cq.a("DC_Pro", i);
        this.e.setLength(0);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
          break;
        }
        cq.a("DC_Pro", "enc result is null or len = 0");
        return;
      }
      try
      {
        this.d.write(arrayOfByte);
        this.d.write(36);
        return;
      }
      catch (Throwable localThrowable)
      {
        cq.a("DC_Pro", "write file failed.", localThrowable);
        this.c = null;
        j.a(this.d);
      }
    }
    
    private void b(long paramLong)
    {
      try
      {
        PreferenceManager.getDefaultSharedPreferences(ct.p(ct.this)).edit().putLong("log_fc_create", paramLong).apply();
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    private void c()
    {
      try
      {
        if (this.d != null) {
          this.d.flush();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        this.c = null;
        j.a(this.d);
      }
    }
    
    private void d()
    {
      if ((this.c == null) || (!this.c.exists()) || (this.d == null) || (!ct.c().equals(this.c.getName())))
      {
        File localFile = ct.e(ct.this);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        this.c = new File(localFile, ct.c());
      }
      try
      {
        boolean bool = this.c.exists();
        this.d = new BufferedOutputStream(new FileOutputStream(this.c, true), 1024);
        if (!bool) {
          b(System.currentTimeMillis());
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        cq.a("DC_Pro", "open file error", localThrowable);
      }
    }
    
    private long e()
    {
      try
      {
        long l = PreferenceManager.getDefaultSharedPreferences(ct.p(ct.this)).getLong("log_fc_create", 0L);
        return l;
      }
      catch (Throwable localThrowable) {}
      return 0L;
    }
    
    /* Error */
    public final void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 365	android/os/Message:what	I
      //   4: tableswitch	default:+776 -> 780, 1:+44->48, 2:+44->48, 3:+354->358, 4:+406->410, 5:+427->431, 6:+568->572, 7:+750->754
      //   49: getfield 38	c/t/m/g/ct$a:b	[Ljava/lang/Object;
      //   52: astore 5
      //   54: aload 5
      //   56: monitorenter
      //   57: aload_1
      //   58: getfield 365	android/os/Message:what	I
      //   61: istore_2
      //   62: aload_0
      //   63: invokespecial 367	c/t/m/g/ct$a:d	()V
      //   66: ldc 210
      //   68: astore 4
      //   70: iload_2
      //   71: iconst_2
      //   72: if_icmpne +66 -> 138
      //   75: aload_0
      //   76: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   79: invokestatic 371	c/t/m/g/ct:k	(Lc/t/m/g/ct;)Lc/t/m/g/co;
      //   82: aload_0
      //   83: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   86: invokestatic 375	c/t/m/g/ct:l	(Lc/t/m/g/ct;)Landroid/location/Location;
      //   89: aconst_null
      //   90: aload_0
      //   91: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   94: invokestatic 379	c/t/m/g/ct:m	(Lc/t/m/g/ct;)Ljava/util/List;
      //   97: invokestatic 384	c/t/m/g/cv:a	(Lc/t/m/g/co;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
      //   100: astore_1
      //   101: aload_0
      //   102: getfield 312	c/t/m/g/ct$a:d	Ljava/io/BufferedOutputStream;
      //   105: ifnull +12 -> 117
      //   108: aload_1
      //   109: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   112: istore_3
      //   113: iload_3
      //   114: ifeq +82 -> 196
      //   117: aload 5
      //   119: monitorexit
      //   120: return
      //   121: astore_1
      //   122: aload 5
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: ldc 118
      //   130: ldc_w 386
      //   133: aload_1
      //   134: invokestatic 136	c/t/m/g/cq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   137: return
      //   138: aload 4
      //   140: astore_1
      //   141: iload_2
      //   142: iconst_1
      //   143: if_icmpne -42 -> 101
      //   146: aload_0
      //   147: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   150: invokestatic 389	c/t/m/g/ct:n	(Lc/t/m/g/ct;)Ljava/util/List;
      //   153: astore 6
      //   155: aload 4
      //   157: astore_1
      //   158: aload 6
      //   160: invokestatic 392	c/t/m/g/j:a	(Ljava/util/List;)Z
      //   163: ifne -62 -> 101
      //   166: aload_0
      //   167: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   170: invokestatic 371	c/t/m/g/ct:k	(Lc/t/m/g/ct;)Lc/t/m/g/co;
      //   173: aload_0
      //   174: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   177: invokestatic 375	c/t/m/g/ct:l	(Lc/t/m/g/ct;)Landroid/location/Location;
      //   180: aload 6
      //   182: aload_0
      //   183: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   186: invokestatic 379	c/t/m/g/ct:m	(Lc/t/m/g/ct;)Ljava/util/List;
      //   189: invokestatic 384	c/t/m/g/cv:a	(Lc/t/m/g/co;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
      //   192: astore_1
      //   193: goto -92 -> 101
      //   196: aload_0
      //   197: getfield 305	c/t/m/g/ct$a:e	Ljava/lang/StringBuffer;
      //   200: ifnonnull +21 -> 221
      //   203: aload_0
      //   204: new 307	java/lang/StringBuffer
      //   207: dup
      //   208: aload_0
      //   209: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   212: invokestatic 395	c/t/m/g/ct:o	(Lc/t/m/g/ct;)I
      //   215: invokespecial 397	java/lang/StringBuffer:<init>	(I)V
      //   218: putfield 305	c/t/m/g/ct$a:e	Ljava/lang/StringBuffer;
      //   221: aload_0
      //   222: getfield 305	c/t/m/g/ct$a:e	Ljava/lang/StringBuffer;
      //   225: aload_1
      //   226: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   229: ldc_w 402
      //   232: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   235: pop
      //   236: aload_0
      //   237: getfield 305	c/t/m/g/ct$a:e	Ljava/lang/StringBuffer;
      //   240: invokevirtual 310	java/lang/StringBuffer:length	()I
      //   243: aload_0
      //   244: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   247: invokestatic 395	c/t/m/g/ct:o	(Lc/t/m/g/ct;)I
      //   250: if_icmpgt +22 -> 272
      //   253: aload_0
      //   254: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   257: ifnull +44 -> 301
      //   260: aload_0
      //   261: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   264: invokevirtual 165	java/io/File:length	()J
      //   267: lconst_0
      //   268: lcmp
      //   269: ifne +32 -> 301
      //   272: aload_0
      //   273: invokespecial 404	c/t/m/g/ct$a:b	()V
      //   276: aload_0
      //   277: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   280: invokevirtual 165	java/io/File:length	()J
      //   283: aload_0
      //   284: invokespecial 406	c/t/m/g/ct$a:a	()J
      //   287: lcmp
      //   288: ifle +13 -> 301
      //   291: aload_0
      //   292: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   295: invokestatic 409	c/t/m/g/ct:a	(Lc/t/m/g/ct;)Landroid/os/Handler;
      //   298: invokestatic 412	c/t/m/g/ct:a	(Landroid/os/Handler;)V
      //   301: ldc 118
      //   303: new 66	java/lang/StringBuilder
      //   306: dup
      //   307: ldc_w 414
      //   310: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   313: aload_1
      //   314: iconst_0
      //   315: bipush 60
      //   317: invokevirtual 418	java/lang/String:substring	(II)Ljava/lang/String;
      //   320: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   323: ldc_w 420
      //   326: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   329: aload_1
      //   330: invokevirtual 421	java/lang/String:length	()I
      //   333: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   336: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   339: invokestatic 131	c/t/m/g/cq:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   342: goto -225 -> 117
      //   345: astore_1
      //   346: ldc 118
      //   348: ldc_w 423
      //   351: aload_1
      //   352: invokestatic 136	c/t/m/g/cq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   355: goto -238 -> 117
      //   358: ldc 118
      //   360: ldc_w 425
      //   363: invokestatic 131	c/t/m/g/cq:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   366: aload_0
      //   367: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   370: invokestatic 427	c/t/m/g/ct:d	(Lc/t/m/g/ct;)Z
      //   373: ifeq +407 -> 780
      //   376: aload_0
      //   377: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   380: invokestatic 144	c/t/m/g/ct:e	(Lc/t/m/g/ct;)Ljava/io/File;
      //   383: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   386: astore_1
      //   387: aload_0
      //   388: aload_1
      //   389: invokespecial 429	c/t/m/g/ct$a:a	(Ljava/lang/String;)Z
      //   392: ifne +388 -> 780
      //   395: aload_0
      //   396: aload_1
      //   397: ldc_w 431
      //   400: ldc 254
      //   402: invokevirtual 434	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   405: invokespecial 429	c/t/m/g/ct$a:a	(Ljava/lang/String;)Z
      //   408: pop
      //   409: return
      //   410: aload_0
      //   411: getfield 38	c/t/m/g/ct$a:b	[Ljava/lang/Object;
      //   414: astore_1
      //   415: aload_1
      //   416: monitorenter
      //   417: aload_0
      //   418: invokespecial 436	c/t/m/g/ct$a:c	()V
      //   421: aload_1
      //   422: monitorexit
      //   423: return
      //   424: astore 4
      //   426: aload_1
      //   427: monitorexit
      //   428: aload 4
      //   430: athrow
      //   431: aload_0
      //   432: getfield 38	c/t/m/g/ct$a:b	[Ljava/lang/Object;
      //   435: astore_1
      //   436: aload_1
      //   437: monitorenter
      //   438: aload_0
      //   439: invokespecial 404	c/t/m/g/ct$a:b	()V
      //   442: aload_0
      //   443: getfield 305	c/t/m/g/ct$a:e	Ljava/lang/StringBuffer;
      //   446: ifnull +11 -> 457
      //   449: aload_0
      //   450: getfield 305	c/t/m/g/ct$a:e	Ljava/lang/StringBuffer;
      //   453: iconst_0
      //   454: invokevirtual 324	java/lang/StringBuffer:setLength	(I)V
      //   457: aload_0
      //   458: aconst_null
      //   459: putfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   462: aload_0
      //   463: getfield 312	c/t/m/g/ct$a:d	Ljava/io/BufferedOutputStream;
      //   466: invokestatic 338	c/t/m/g/j:a	(Ljava/io/Closeable;)V
      //   469: aload_0
      //   470: aload_0
      //   471: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   474: invokestatic 264	c/t/m/g/ct:f	(Lc/t/m/g/ct;)J
      //   477: aload_0
      //   478: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   481: invokestatic 439	c/t/m/g/ct:g	(Lc/t/m/g/ct;)J
      //   484: invokespecial 441	c/t/m/g/ct$a:a	(JJ)V
      //   487: aload_1
      //   488: monitorexit
      //   489: aload_0
      //   490: aconst_null
      //   491: invokevirtual 445	c/t/m/g/ct$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
      //   494: return
      //   495: astore 4
      //   497: aload_0
      //   498: aconst_null
      //   499: putfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   502: aload_0
      //   503: getfield 312	c/t/m/g/ct$a:d	Ljava/io/BufferedOutputStream;
      //   506: invokestatic 338	c/t/m/g/j:a	(Ljava/io/Closeable;)V
      //   509: aload_0
      //   510: aload_0
      //   511: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   514: invokestatic 264	c/t/m/g/ct:f	(Lc/t/m/g/ct;)J
      //   517: aload_0
      //   518: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   521: invokestatic 439	c/t/m/g/ct:g	(Lc/t/m/g/ct;)J
      //   524: invokespecial 441	c/t/m/g/ct$a:a	(JJ)V
      //   527: goto -40 -> 487
      //   530: astore 4
      //   532: aload_1
      //   533: monitorexit
      //   534: aload 4
      //   536: athrow
      //   537: astore 4
      //   539: aload_0
      //   540: aconst_null
      //   541: putfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   544: aload_0
      //   545: getfield 312	c/t/m/g/ct$a:d	Ljava/io/BufferedOutputStream;
      //   548: invokestatic 338	c/t/m/g/j:a	(Ljava/io/Closeable;)V
      //   551: aload_0
      //   552: aload_0
      //   553: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   556: invokestatic 264	c/t/m/g/ct:f	(Lc/t/m/g/ct;)J
      //   559: aload_0
      //   560: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   563: invokestatic 439	c/t/m/g/ct:g	(Lc/t/m/g/ct;)J
      //   566: invokespecial 441	c/t/m/g/ct$a:a	(JJ)V
      //   569: aload 4
      //   571: athrow
      //   572: aload_0
      //   573: getfield 38	c/t/m/g/ct$a:b	[Ljava/lang/Object;
      //   576: astore_1
      //   577: aload_1
      //   578: monitorenter
      //   579: aload_0
      //   580: invokespecial 367	c/t/m/g/ct$a:d	()V
      //   583: aload_0
      //   584: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   587: invokestatic 144	c/t/m/g/ct:e	(Lc/t/m/g/ct;)Ljava/io/File;
      //   590: ifnull +20 -> 610
      //   593: aload_0
      //   594: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   597: ifnull +13 -> 610
      //   600: aload_0
      //   601: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   604: invokevirtual 151	java/io/File:exists	()Z
      //   607: ifne +13 -> 620
      //   610: aload_1
      //   611: monitorexit
      //   612: return
      //   613: astore 4
      //   615: aload_1
      //   616: monitorexit
      //   617: aload 4
      //   619: athrow
      //   620: aload_0
      //   621: invokespecial 404	c/t/m/g/ct$a:b	()V
      //   624: aload_0
      //   625: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   628: invokevirtual 165	java/io/File:length	()J
      //   631: aload_0
      //   632: invokespecial 406	c/t/m/g/ct$a:a	()J
      //   635: lcmp
      //   636: ifgt +22 -> 658
      //   639: invokestatic 64	java/lang/System:currentTimeMillis	()J
      //   642: aload_0
      //   643: invokespecial 447	c/t/m/g/ct$a:e	()J
      //   646: lsub
      //   647: aload_0
      //   648: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   651: invokestatic 450	c/t/m/g/ct:h	(Lc/t/m/g/ct;)J
      //   654: lcmp
      //   655: ifle +63 -> 718
      //   658: aload_0
      //   659: invokespecial 436	c/t/m/g/ct$a:c	()V
      //   662: aload_0
      //   663: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   666: ifnull +17 -> 683
      //   669: aload_0
      //   670: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   673: invokevirtual 165	java/io/File:length	()J
      //   676: ldc2_w 451
      //   679: lcmp
      //   680: ifge +41 -> 721
      //   683: aload_0
      //   684: aload_0
      //   685: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   688: invokestatic 264	c/t/m/g/ct:f	(Lc/t/m/g/ct;)J
      //   691: aload_0
      //   692: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   695: invokestatic 439	c/t/m/g/ct:g	(Lc/t/m/g/ct;)J
      //   698: invokespecial 441	c/t/m/g/ct$a:a	(JJ)V
      //   701: aload_0
      //   702: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   705: getfield 454	c/t/m/g/ct:d	Z
      //   708: ifeq +10 -> 718
      //   711: aload_0
      //   712: bipush 7
      //   714: invokevirtual 458	c/t/m/g/ct$a:sendEmptyMessage	(I)Z
      //   717: pop
      //   718: aload_1
      //   719: monitorexit
      //   720: return
      //   721: aload_0
      //   722: getfield 312	c/t/m/g/ct$a:d	Ljava/io/BufferedOutputStream;
      //   725: invokestatic 338	c/t/m/g/j:a	(Ljava/io/Closeable;)V
      //   728: aload_0
      //   729: aconst_null
      //   730: putfield 312	c/t/m/g/ct$a:d	Ljava/io/BufferedOutputStream;
      //   733: iconst_4
      //   734: aload_0
      //   735: getfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   738: invokestatic 183	c/t/m/g/ct$a:a	(ILjava/io/File;)V
      //   741: aload_0
      //   742: aconst_null
      //   743: putfield 335	c/t/m/g/ct$a:c	Ljava/io/File;
      //   746: aload_0
      //   747: lconst_0
      //   748: invokespecial 355	c/t/m/g/ct$a:b	(J)V
      //   751: goto -68 -> 683
      //   754: aload_0
      //   755: bipush 7
      //   757: invokevirtual 461	c/t/m/g/ct$a:removeMessages	(I)V
      //   760: aload_0
      //   761: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   764: aload_0
      //   765: invokestatic 464	c/t/m/g/ct:a	(Lc/t/m/g/ct;Landroid/os/Handler;)V
      //   768: aload_0
      //   769: aload_0
      //   770: getfield 22	c/t/m/g/ct$a:f	Lc/t/m/g/ct;
      //   773: invokestatic 467	c/t/m/g/ct:i	(Lc/t/m/g/ct;)J
      //   776: invokestatic 470	c/t/m/g/ct:a	(Landroid/os/Handler;J)V
      //   779: return
      //   780: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	781	0	this	a
      //   0	781	1	paramMessage	android.os.Message
      //   61	83	2	i	int
      //   112	2	3	bool	boolean
      //   68	88	4	str	String
      //   424	5	4	localObject1	Object
      //   495	1	4	localThrowable	Throwable
      //   530	5	4	localObject2	Object
      //   537	33	4	localObject3	Object
      //   613	5	4	localObject4	Object
      //   52	71	5	arrayOfObject	Object[]
      //   153	28	6	localList	List
      // Exception table:
      //   from	to	target	type
      //   57	66	121	finally
      //   75	101	121	finally
      //   101	113	121	finally
      //   117	120	121	finally
      //   122	125	121	finally
      //   146	155	121	finally
      //   158	193	121	finally
      //   196	221	121	finally
      //   221	272	121	finally
      //   272	301	121	finally
      //   301	342	121	finally
      //   346	355	121	finally
      //   0	48	127	java/lang/Throwable
      //   48	57	127	java/lang/Throwable
      //   125	127	127	java/lang/Throwable
      //   358	409	127	java/lang/Throwable
      //   410	417	127	java/lang/Throwable
      //   428	431	127	java/lang/Throwable
      //   431	438	127	java/lang/Throwable
      //   489	494	127	java/lang/Throwable
      //   534	537	127	java/lang/Throwable
      //   572	579	127	java/lang/Throwable
      //   617	620	127	java/lang/Throwable
      //   754	779	127	java/lang/Throwable
      //   57	66	345	java/lang/Throwable
      //   75	101	345	java/lang/Throwable
      //   101	113	345	java/lang/Throwable
      //   146	155	345	java/lang/Throwable
      //   158	193	345	java/lang/Throwable
      //   196	221	345	java/lang/Throwable
      //   221	272	345	java/lang/Throwable
      //   272	301	345	java/lang/Throwable
      //   301	342	345	java/lang/Throwable
      //   417	423	424	finally
      //   426	428	424	finally
      //   438	457	495	java/lang/Throwable
      //   457	487	530	finally
      //   487	489	530	finally
      //   497	527	530	finally
      //   532	534	530	finally
      //   539	572	530	finally
      //   438	457	537	finally
      //   579	610	613	finally
      //   610	612	613	finally
      //   615	617	613	finally
      //   620	658	613	finally
      //   658	683	613	finally
      //   683	718	613	finally
      //   718	720	613	finally
      //   721	751	613	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.ct
 * JD-Core Version:    0.7.0.1
 */