package midas.x;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class h0
{
  public static h0 i;
  public static int j = 300;
  public Context a = null;
  public SQLiteDatabase b = null;
  public i0 c = null;
  public Handler d = null;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  
  public h0()
  {
    j0 localj0 = new j0("APDatabaseThread");
    localj0.start();
    this.d = new Handler(localj0.getLooper());
    this.h = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
  }
  
  public static h0 a(Context paramContext)
  {
    try
    {
      if (i == null) {
        i = new h0();
      }
      if ((paramContext != null) && (i.a == null)) {
        i.a = paramContext.getApplicationContext();
      }
      paramContext = i;
      return paramContext;
    }
    finally {}
  }
  
  public final void a()
  {
    try
    {
      if ((this.c == null) || (this.b == null)) {
        b();
      }
      if ((this.b != null) && (!this.b.isOpen()) && (this.c != null))
      {
        this.b = this.c.getWritableDatabase();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDBOpen() e = ");
      localStringBuilder.append(localException.toString());
      APLog.w("APDatabase", localStringBuilder.toString());
    }
  }
  
  public void a(final ArrayList<l0> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() > 0)
        {
          if (this.d != null) {
            this.d.post(new b(paramArrayList));
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(final l0 paraml0)
  {
    try
    {
      if (this.d != null) {
        this.d.post(new a(paraml0));
      }
      return;
    }
    finally
    {
      paraml0 = finally;
      throw paraml0;
    }
  }
  
  public void a(final o6 paramo6)
  {
    paramo6 = new g(new c(paramo6));
    this.d.post(new d(paramo6));
  }
  
  public void b()
    throws Exception
  {
    Object localObject;
    try
    {
      if ((this.c == null) && (this.a != null))
      {
        if (APLogUtil.IS_IN_NEW_PROCESS)
        {
          this.c = new i0(this.a, "Sub");
          APLog.d("APDatabase", "create DB in new process");
        }
        else
        {
          this.c = new i0(this.a, "");
          APLog.d("APDatabase", "create DB in normal process");
        }
        if (((this.b != null) && (!this.b.isOpen())) || (this.b == null))
        {
          this.b = this.c.getWritableDatabase();
          return;
        }
      }
    }
    catch (Exception localException1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open() e = ");
      ((StringBuilder)localObject).append(localException1.toString());
      APLog.w("APDatabase", ((StringBuilder)localObject).toString());
    }
    try
    {
      if (this.h == 0)
      {
        localObject = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dbvalid_");
        localStringBuilder.append(this.b.isDatabaseIntegrityOk());
        localStringBuilder.append("|");
        localStringBuilder.append(APTools.d(localException1));
        ((APDataReportManager)localObject).a("sdk.database.err", "open", localStringBuilder.toString());
      }
      label207:
      this.h += 1;
      return;
    }
    catch (Exception localException2)
    {
      break label207;
    }
  }
  
  /* Error */
  public void b(l0 paraml0)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 90	midas/x/h0:a	()V
    //   6: ldc 180
    //   8: astore 6
    //   10: iconst_0
    //   11: istore_3
    //   12: aload 6
    //   14: astore 4
    //   16: aload 6
    //   18: astore 5
    //   20: iload_3
    //   21: istore_2
    //   22: aload_1
    //   23: getfield 218	midas/x/l0:d	Ljava/lang/String;
    //   26: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +79 -> 108
    //   32: aload 6
    //   34: astore 4
    //   36: aload_1
    //   37: getfield 218	midas/x/l0:d	Ljava/lang/String;
    //   40: ldc 226
    //   42: invokestatic 231	midas/x/l6:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aload_1
    //   52: getfield 218	midas/x/l0:d	Ljava/lang/String;
    //   55: invokevirtual 236	java/lang/String:length	()I
    //   58: istore_2
    //   59: goto +49 -> 108
    //   62: astore 5
    //   64: new 113	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   71: astore 6
    //   73: aload 6
    //   75: ldc 238
    //   77: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 6
    //   83: aload 5
    //   85: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 126
    //   94: aload 6
    //   96: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 133	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: iload_3
    //   103: istore_2
    //   104: aload 4
    //   106: astore 5
    //   108: new 240	android/content/ContentValues
    //   111: dup
    //   112: invokespecial 241	android/content/ContentValues:<init>	()V
    //   115: astore 4
    //   117: aload 4
    //   119: ldc 243
    //   121: aload_1
    //   122: getfield 245	midas/x/l0:a	I
    //   125: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: invokevirtual 255	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   131: aload 4
    //   133: ldc_w 257
    //   136: aload_1
    //   137: getfield 259	midas/x/l0:b	Ljava/lang/String;
    //   140: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 4
    //   145: ldc_w 263
    //   148: aload_1
    //   149: getfield 265	midas/x/l0:c	Ljava/lang/String;
    //   152: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 4
    //   157: ldc_w 267
    //   160: aload_1
    //   161: getfield 269	midas/x/l0:e	Ljava/lang/String;
    //   164: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 4
    //   169: ldc_w 271
    //   172: aload_1
    //   173: getfield 273	midas/x/l0:f	Ljava/lang/String;
    //   176: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 4
    //   181: ldc_w 275
    //   184: aload_1
    //   185: getfield 277	midas/x/l0:g	Ljava/lang/String;
    //   188: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 4
    //   193: ldc_w 279
    //   196: aload_1
    //   197: getfield 281	midas/x/l0:h	Ljava/lang/String;
    //   200: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload 4
    //   205: ldc_w 283
    //   208: aload_1
    //   209: getfield 285	midas/x/l0:i	Ljava/lang/String;
    //   212: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 4
    //   217: ldc_w 287
    //   220: aload 5
    //   222: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 4
    //   227: ldc_w 289
    //   230: iload_2
    //   231: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: invokevirtual 255	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   237: aload 4
    //   239: ldc_w 291
    //   242: aload_1
    //   243: getfield 293	midas/x/l0:j	Ljava/lang/String;
    //   246: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload 4
    //   251: ldc_w 295
    //   254: aload_1
    //   255: getfield 298	midas/x/l0:k	Ljava/lang/String;
    //   258: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 4
    //   263: ldc_w 300
    //   266: aload_1
    //   267: getfield 303	midas/x/l0:l	Ljava/lang/String;
    //   270: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload 4
    //   275: ldc_w 305
    //   278: aload_1
    //   279: getfield 308	midas/x/l0:m	Ljava/lang/String;
    //   282: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 4
    //   287: ldc_w 310
    //   290: aload_1
    //   291: getfield 313	midas/x/l0:n	Ljava/lang/String;
    //   294: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload 4
    //   299: ldc_w 315
    //   302: aload_1
    //   303: getfield 318	midas/x/l0:o	Ljava/lang/String;
    //   306: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload 4
    //   311: ldc_w 320
    //   314: aload_1
    //   315: getfield 323	midas/x/l0:p	Ljava/lang/String;
    //   318: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 4
    //   323: ldc_w 325
    //   326: aload_1
    //   327: getfield 328	midas/x/l0:r	Ljava/lang/String;
    //   330: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 4
    //   335: ldc_w 330
    //   338: aload_1
    //   339: getfield 333	midas/x/l0:q	Ljava/lang/String;
    //   342: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload 4
    //   347: ldc_w 335
    //   350: aload_1
    //   351: getfield 338	midas/x/l0:s	Ljava/lang/String;
    //   354: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 4
    //   359: ldc_w 340
    //   362: aload_1
    //   363: getfield 343	midas/x/l0:t	Ljava/lang/String;
    //   366: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 4
    //   371: ldc_w 345
    //   374: aload_1
    //   375: getfield 348	midas/x/l0:u	Ljava/lang/String;
    //   378: invokevirtual 261	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_0
    //   382: getfield 43	midas/x/h0:b	Landroid/database/sqlite/SQLiteDatabase;
    //   385: ldc_w 350
    //   388: ldc_w 352
    //   391: aload 4
    //   393: invokevirtual 356	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   396: pop2
    //   397: goto +192 -> 589
    //   400: astore_1
    //   401: goto +191 -> 592
    //   404: astore_1
    //   405: new 113	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   412: astore 4
    //   414: aload 4
    //   416: ldc_w 358
    //   419: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 4
    //   425: aload_1
    //   426: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 4
    //   435: ldc_w 360
    //   438: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 4
    //   444: aload_0
    //   445: getfield 49	midas/x/h0:e	I
    //   448: invokevirtual 363	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc 126
    //   454: aload 4
    //   456: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 133	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_0
    //   463: getfield 49	midas/x/h0:e	I
    //   466: ifne +113 -> 579
    //   469: invokestatic 190	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   472: astore 4
    //   474: new 113	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   481: astore 5
    //   483: aload 5
    //   485: ldc 192
    //   487: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 5
    //   493: aload_0
    //   494: getfield 43	midas/x/h0:b	Landroid/database/sqlite/SQLiteDatabase;
    //   497: invokevirtual 195	android/database/sqlite/SQLiteDatabase:isDatabaseIntegrityOk	()Z
    //   500: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 5
    //   506: ldc 200
    //   508: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload 5
    //   514: aload_1
    //   515: invokestatic 205	com/pay/tool/APTools:d	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   518: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload 4
    //   524: ldc 207
    //   526: ldc_w 364
    //   529: aload 5
    //   531: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokevirtual 212	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   537: goto +42 -> 579
    //   540: astore_1
    //   541: new 113	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   548: astore 4
    //   550: aload 4
    //   552: ldc_w 366
    //   555: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 4
    //   561: aload_1
    //   562: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   565: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: ldc 126
    //   571: aload 4
    //   573: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 133	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 49	midas/x/h0:e	I
    //   584: iconst_1
    //   585: iadd
    //   586: putfield 49	midas/x/h0:e	I
    //   589: aload_0
    //   590: monitorexit
    //   591: return
    //   592: aload_0
    //   593: monitorexit
    //   594: aload_1
    //   595: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	h0
    //   0	596	1	paraml0	l0
    //   21	210	2	k	int
    //   11	92	3	m	int
    //   14	558	4	localObject1	Object
    //   18	30	5	localObject2	Object
    //   62	22	5	localException	Exception
    //   106	424	5	localObject3	Object
    //   8	87	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   22	32	62	java/lang/Exception
    //   36	47	62	java/lang/Exception
    //   51	59	62	java/lang/Exception
    //   2	6	400	finally
    //   22	32	400	finally
    //   36	47	400	finally
    //   51	59	400	finally
    //   64	102	400	finally
    //   108	397	400	finally
    //   405	462	400	finally
    //   462	537	400	finally
    //   541	579	400	finally
    //   579	589	400	finally
    //   2	6	404	java/lang/Exception
    //   64	102	404	java/lang/Exception
    //   108	397	404	java/lang/Exception
    //   462	537	540	java/lang/Exception
  }
  
  public void b(final o6 paramo6)
  {
    paramo6 = new g(new e(paramo6));
    this.d.post(new f(paramo6));
  }
  
  public class a
    implements Runnable
  {
    public a(l0 paraml0) {}
    
    public void run()
    {
      h0.this.b(paraml0);
    }
  }
  
  public class b
    implements Runnable
  {
    public b(ArrayList paramArrayList) {}
    
    public void run()
    {
      Object localObject1 = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject3 = (l0)paramArrayList.get(i);
        if ((localObject3 != null) && (!TextUtils.isEmpty(((l0)localObject3).u)))
        {
          ((StringBuilder)localObject1).append("'");
          ((StringBuilder)localObject1).append(((l0)localObject3).u);
          ((StringBuilder)localObject1).append("'");
          ((StringBuilder)localObject1).append(",");
        }
        if (i % 500 != 499)
        {
          localObject3 = localObject1;
          if (i != paramArrayList.size() - 1) {}
        }
        else
        {
          if (((StringBuilder)localObject1).length() > 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Amount in ( ");
            ((StringBuilder)localObject3).append(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));
            ((StringBuilder)localObject3).append(" ) ");
            localObject1 = ((StringBuilder)localObject3).toString();
            h0.a(h0.this);
            try
            {
              h0.b(h0.this).delete("APClickStreamTable", (String)localObject1, null);
            }
            catch (Exception localException1)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("deleteData() e = ");
              ((StringBuilder)localObject3).append(localException1.toString());
              APLog.w("APDatabase", ((StringBuilder)localObject3).toString());
              try
              {
                if (h0.c(h0.this) == 0)
                {
                  localObject3 = APDataReportManager.getInstance();
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("dbvalid_");
                  localStringBuilder.append(h0.b(h0.this).isDatabaseIntegrityOk());
                  localStringBuilder.append("|");
                  localStringBuilder.append(APTools.d(localException1));
                  ((APDataReportManager)localObject3).a("sdk.database.err", "delete", localStringBuilder.toString());
                }
              }
              catch (Exception localException2)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("deleteData() report e = ");
                ((StringBuilder)localObject3).append(localException2.toString());
                APLog.w("APDatabase", ((StringBuilder)localObject3).toString());
              }
              h0.d(h0.this);
            }
          }
          else
          {
            APLog.w("APDatabase", "deleteData() whereBuilder.length <= 0");
          }
          localObject3 = new StringBuilder();
        }
        i += 1;
        Object localObject2 = localObject3;
      }
    }
  }
  
  public class c
    implements o6
  {
    public c(o6 paramo6) {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      paramo6.a(paramInt1, paramInt2, paramInt3, paramObject, paramBundle);
    }
  }
  
  public class d
    implements Runnable
  {
    public d(h0.g paramg) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 18	midas/x/h0$d:b	Lmidas/x/h0;
      //   4: invokestatic 30	midas/x/h0:a	(Lmidas/x/h0;)V
      //   7: iconst_0
      //   8: istore_3
      //   9: iconst_0
      //   10: istore_1
      //   11: aconst_null
      //   12: astore 6
      //   14: aconst_null
      //   15: astore 8
      //   17: aconst_null
      //   18: astore 7
      //   20: aload 6
      //   22: astore 4
      //   24: iload_3
      //   25: istore_2
      //   26: aload 8
      //   28: astore 5
      //   30: aload_0
      //   31: getfield 18	midas/x/h0$d:b	Lmidas/x/h0;
      //   34: invokestatic 33	midas/x/h0:b	(Lmidas/x/h0;)Landroid/database/sqlite/SQLiteDatabase;
      //   37: ifnull +92 -> 129
      //   40: aload 6
      //   42: astore 4
      //   44: iload_3
      //   45: istore_2
      //   46: aload 8
      //   48: astore 5
      //   50: aload_0
      //   51: getfield 18	midas/x/h0$d:b	Lmidas/x/h0;
      //   54: invokestatic 33	midas/x/h0:b	(Lmidas/x/h0;)Landroid/database/sqlite/SQLiteDatabase;
      //   57: ldc 35
      //   59: aconst_null
      //   60: aconst_null
      //   61: aconst_null
      //   62: aconst_null
      //   63: aconst_null
      //   64: aconst_null
      //   65: invokevirtual 41	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   68: astore 6
      //   70: aload 6
      //   72: astore 4
      //   74: iload_3
      //   75: istore_2
      //   76: aload 6
      //   78: astore 5
      //   80: aload 6
      //   82: invokeinterface 47 1 0
      //   87: istore_3
      //   88: iload_3
      //   89: istore_1
      //   90: aload 6
      //   92: astore 7
      //   94: aload 6
      //   96: astore 4
      //   98: iload_3
      //   99: istore_2
      //   100: aload 6
      //   102: astore 5
      //   104: iload_3
      //   105: invokestatic 50	midas/x/h0:c	()I
      //   108: if_icmple +21 -> 129
      //   111: aload 6
      //   113: astore 4
      //   115: iload_3
      //   116: istore_2
      //   117: aload 6
      //   119: astore 5
      //   121: invokestatic 50	midas/x/h0:c	()I
      //   124: istore_1
      //   125: aload 6
      //   127: astore 7
      //   129: iload_1
      //   130: istore_3
      //   131: aload 7
      //   133: ifnull +156 -> 289
      //   136: aload 7
      //   138: invokeinterface 53 1 0
      //   143: iload_1
      //   144: istore_3
      //   145: goto +144 -> 289
      //   148: astore 4
      //   150: new 55	java/lang/StringBuilder
      //   153: dup
      //   154: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   157: astore 5
      //   159: aload 5
      //   161: ldc 58
      //   163: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: pop
      //   167: aload 5
      //   169: aload 4
      //   171: invokevirtual 66	java/lang/Exception:toString	()Ljava/lang/String;
      //   174: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   177: pop
      //   178: ldc 68
      //   180: aload 5
      //   182: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   185: invokestatic 75	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   188: iload_1
      //   189: istore_3
      //   190: goto +99 -> 289
      //   193: astore 5
      //   195: goto +120 -> 315
      //   198: astore 6
      //   200: aload 5
      //   202: astore 4
      //   204: new 55	java/lang/StringBuilder
      //   207: dup
      //   208: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   211: astore 7
      //   213: aload 5
      //   215: astore 4
      //   217: aload 7
      //   219: ldc 77
      //   221: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   224: pop
      //   225: aload 5
      //   227: astore 4
      //   229: aload 7
      //   231: aload 6
      //   233: invokevirtual 66	java/lang/Exception:toString	()Ljava/lang/String;
      //   236: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   239: pop
      //   240: aload 5
      //   242: astore 4
      //   244: ldc 68
      //   246: aload 7
      //   248: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   251: invokestatic 75	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   254: iload_2
      //   255: istore_3
      //   256: aload 5
      //   258: ifnull +31 -> 289
      //   261: aload 5
      //   263: invokeinterface 53 1 0
      //   268: iload_2
      //   269: istore_3
      //   270: goto +19 -> 289
      //   273: astore 4
      //   275: new 55	java/lang/StringBuilder
      //   278: dup
      //   279: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   282: astore 5
      //   284: iload_2
      //   285: istore_1
      //   286: goto -127 -> 159
      //   289: new 79	android/os/Message
      //   292: dup
      //   293: invokespecial 80	android/os/Message:<init>	()V
      //   296: astore 4
      //   298: aload 4
      //   300: iload_3
      //   301: putfield 84	android/os/Message:what	I
      //   304: aload_0
      //   305: getfield 20	midas/x/h0$d:a	Lmidas/x/h0$g;
      //   308: aload 4
      //   310: invokevirtual 90	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   313: pop
      //   314: return
      //   315: aload 4
      //   317: ifnull +53 -> 370
      //   320: aload 4
      //   322: invokeinterface 53 1 0
      //   327: goto +43 -> 370
      //   330: astore 4
      //   332: new 55	java/lang/StringBuilder
      //   335: dup
      //   336: invokespecial 56	java/lang/StringBuilder:<init>	()V
      //   339: astore 6
      //   341: aload 6
      //   343: ldc 58
      //   345: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: pop
      //   349: aload 6
      //   351: aload 4
      //   353: invokevirtual 66	java/lang/Exception:toString	()Ljava/lang/String;
      //   356: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   359: pop
      //   360: ldc 68
      //   362: aload 6
      //   364: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   367: invokestatic 75	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   370: goto +6 -> 376
      //   373: aload 5
      //   375: athrow
      //   376: goto -3 -> 373
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	379	0	this	d
      //   10	276	1	i	int
      //   25	260	2	j	int
      //   8	293	3	k	int
      //   22	92	4	localCursor1	android.database.Cursor
      //   148	22	4	localException1	Exception
      //   202	41	4	localObject1	Object
      //   273	1	4	localException2	Exception
      //   296	25	4	localMessage	Message
      //   330	22	4	localException3	Exception
      //   28	153	5	localObject2	Object
      //   193	69	5	localObject3	Object
      //   282	92	5	localStringBuilder1	StringBuilder
      //   12	114	6	localCursor2	android.database.Cursor
      //   198	34	6	localException4	Exception
      //   339	24	6	localStringBuilder2	StringBuilder
      //   18	229	7	localObject4	Object
      //   15	32	8	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   136	143	148	java/lang/Exception
      //   30	40	193	finally
      //   50	70	193	finally
      //   80	88	193	finally
      //   104	111	193	finally
      //   121	125	193	finally
      //   204	213	193	finally
      //   217	225	193	finally
      //   229	240	193	finally
      //   244	254	193	finally
      //   30	40	198	java/lang/Exception
      //   50	70	198	java/lang/Exception
      //   80	88	198	java/lang/Exception
      //   104	111	198	java/lang/Exception
      //   121	125	198	java/lang/Exception
      //   261	268	273	java/lang/Exception
      //   320	327	330	java/lang/Exception
    }
  }
  
  public class e
    implements o6
  {
    public e(o6 paramo6) {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      paramo6.a(paramInt1, paramInt2, paramInt3, paramObject, paramBundle);
    }
  }
  
  public class f
    implements Runnable
  {
    public f(h0.g paramg) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 29
      //   2: astore 9
      //   4: ldc 31
      //   6: astore 8
      //   8: ldc 33
      //   10: astore 7
      //   12: ldc 35
      //   14: astore 10
      //   16: aload_0
      //   17: getfield 18	midas/x/h0$f:b	Lmidas/x/h0;
      //   20: invokestatic 38	midas/x/h0:a	(Lmidas/x/h0;)V
      //   23: new 40	java/util/ArrayList
      //   26: dup
      //   27: invokespecial 41	java/util/ArrayList:<init>	()V
      //   30: astore 4
      //   32: aconst_null
      //   33: astore 11
      //   35: aconst_null
      //   36: astore 6
      //   38: aload_0
      //   39: getfield 18	midas/x/h0$f:b	Lmidas/x/h0;
      //   42: invokestatic 44	midas/x/h0:b	(Lmidas/x/h0;)Landroid/database/sqlite/SQLiteDatabase;
      //   45: iconst_1
      //   46: ldc 46
      //   48: bipush 23
      //   50: anewarray 48	java/lang/String
      //   53: dup
      //   54: iconst_0
      //   55: ldc 50
      //   57: aastore
      //   58: dup
      //   59: iconst_1
      //   60: ldc 52
      //   62: aastore
      //   63: dup
      //   64: iconst_2
      //   65: ldc 54
      //   67: aastore
      //   68: dup
      //   69: iconst_3
      //   70: ldc 56
      //   72: aastore
      //   73: dup
      //   74: iconst_4
      //   75: ldc 58
      //   77: aastore
      //   78: dup
      //   79: iconst_5
      //   80: ldc 60
      //   82: aastore
      //   83: dup
      //   84: bipush 6
      //   86: ldc 35
      //   88: aastore
      //   89: dup
      //   90: bipush 7
      //   92: ldc 33
      //   94: aastore
      //   95: dup
      //   96: bipush 8
      //   98: ldc 31
      //   100: aastore
      //   101: dup
      //   102: bipush 9
      //   104: ldc 29
      //   106: aastore
      //   107: dup
      //   108: bipush 10
      //   110: ldc 62
      //   112: aastore
      //   113: dup
      //   114: bipush 11
      //   116: ldc 64
      //   118: aastore
      //   119: dup
      //   120: bipush 12
      //   122: ldc 66
      //   124: aastore
      //   125: dup
      //   126: bipush 13
      //   128: ldc 68
      //   130: aastore
      //   131: dup
      //   132: bipush 14
      //   134: ldc 70
      //   136: aastore
      //   137: dup
      //   138: bipush 15
      //   140: ldc 72
      //   142: aastore
      //   143: dup
      //   144: bipush 16
      //   146: ldc 74
      //   148: aastore
      //   149: dup
      //   150: bipush 17
      //   152: ldc 76
      //   154: aastore
      //   155: dup
      //   156: bipush 18
      //   158: ldc 78
      //   160: aastore
      //   161: dup
      //   162: bipush 19
      //   164: ldc 80
      //   166: aastore
      //   167: dup
      //   168: bipush 20
      //   170: ldc 82
      //   172: aastore
      //   173: dup
      //   174: bipush 21
      //   176: ldc 84
      //   178: aastore
      //   179: dup
      //   180: bipush 22
      //   182: ldc 86
      //   184: aastore
      //   185: aconst_null
      //   186: aconst_null
      //   187: aconst_null
      //   188: aconst_null
      //   189: aconst_null
      //   190: aconst_null
      //   191: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   194: astore 5
      //   196: aload 5
      //   198: ifnull +32 -> 230
      //   201: aload 5
      //   203: invokeinterface 98 1 0
      //   208: pop
      //   209: goto +21 -> 230
      //   212: astore 4
      //   214: goto +1219 -> 1433
      //   217: astore 7
      //   219: aload 5
      //   221: astore 6
      //   223: aload 7
      //   225: astore 5
      //   227: goto +927 -> 1154
      //   230: aload 5
      //   232: invokeinterface 102 1 0
      //   237: istore_2
      //   238: invokestatic 105	midas/x/h0:c	()I
      //   241: istore_3
      //   242: iload_2
      //   243: istore_1
      //   244: iload_2
      //   245: iload_3
      //   246: if_icmple +15 -> 261
      //   249: invokestatic 105	midas/x/h0:c	()I
      //   252: istore_1
      //   253: goto +8 -> 261
      //   256: astore 4
      //   258: goto -44 -> 214
      //   261: new 107	java/lang/StringBuilder
      //   264: dup
      //   265: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   268: astore 11
      //   270: aload 4
      //   272: astore 6
      //   274: aload 11
      //   276: ldc 110
      //   278: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   281: pop
      //   282: aload 11
      //   284: iload_1
      //   285: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   288: pop
      //   289: ldc 119
      //   291: aload 11
      //   293: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   296: invokestatic 129	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   299: iconst_0
      //   300: istore_2
      //   301: aload 6
      //   303: astore 4
      //   305: aload 10
      //   307: astore 6
      //   309: iload_2
      //   310: iload_1
      //   311: if_icmpge +727 -> 1038
      //   314: new 131	midas/x/l0
      //   317: dup
      //   318: invokespecial 132	midas/x/l0:<init>	()V
      //   321: astore 11
      //   323: aload 5
      //   325: aload 5
      //   327: ldc 50
      //   329: invokeinterface 136 2 0
      //   334: invokeinterface 140 2 0
      //   339: pop
      //   340: aload 11
      //   342: aload 5
      //   344: aload 5
      //   346: ldc 52
      //   348: invokeinterface 136 2 0
      //   353: invokeinterface 140 2 0
      //   358: putfield 143	midas/x/l0:a	I
      //   361: aload 11
      //   363: aload 5
      //   365: aload 5
      //   367: ldc 54
      //   369: invokeinterface 136 2 0
      //   374: invokeinterface 147 2 0
      //   379: putfield 150	midas/x/l0:b	Ljava/lang/String;
      //   382: aload 11
      //   384: aload 5
      //   386: aload 5
      //   388: ldc 56
      //   390: invokeinterface 136 2 0
      //   395: invokeinterface 147 2 0
      //   400: putfield 152	midas/x/l0:c	Ljava/lang/String;
      //   403: aload 11
      //   405: aload 5
      //   407: aload 5
      //   409: ldc 58
      //   411: invokeinterface 136 2 0
      //   416: invokeinterface 147 2 0
      //   421: putfield 155	midas/x/l0:e	Ljava/lang/String;
      //   424: aload 11
      //   426: aload 5
      //   428: aload 5
      //   430: ldc 60
      //   432: invokeinterface 136 2 0
      //   437: invokeinterface 147 2 0
      //   442: putfield 158	midas/x/l0:f	Ljava/lang/String;
      //   445: aload 11
      //   447: aload 5
      //   449: aload 5
      //   451: aload 6
      //   453: invokeinterface 136 2 0
      //   458: invokeinterface 147 2 0
      //   463: putfield 161	midas/x/l0:g	Ljava/lang/String;
      //   466: aload 11
      //   468: aload 5
      //   470: aload 5
      //   472: aload 7
      //   474: invokeinterface 136 2 0
      //   479: invokeinterface 147 2 0
      //   484: putfield 164	midas/x/l0:h	Ljava/lang/String;
      //   487: aload 11
      //   489: aload 5
      //   491: aload 5
      //   493: aload 8
      //   495: invokeinterface 136 2 0
      //   500: invokeinterface 147 2 0
      //   505: putfield 166	midas/x/l0:i	Ljava/lang/String;
      //   508: aload 11
      //   510: aload 5
      //   512: aload 5
      //   514: ldc 62
      //   516: invokeinterface 136 2 0
      //   521: invokeinterface 147 2 0
      //   526: putfield 169	midas/x/l0:d	Ljava/lang/String;
      //   529: aload 11
      //   531: aload 5
      //   533: aload 5
      //   535: aload 9
      //   537: invokeinterface 136 2 0
      //   542: invokeinterface 147 2 0
      //   547: putfield 172	midas/x/l0:j	Ljava/lang/String;
      //   550: aload 11
      //   552: aload 5
      //   554: aload 5
      //   556: ldc 64
      //   558: invokeinterface 136 2 0
      //   563: invokeinterface 147 2 0
      //   568: putfield 175	midas/x/l0:k	Ljava/lang/String;
      //   571: aload 11
      //   573: aload 5
      //   575: aload 5
      //   577: ldc 66
      //   579: invokeinterface 136 2 0
      //   584: invokeinterface 147 2 0
      //   589: putfield 178	midas/x/l0:l	Ljava/lang/String;
      //   592: aload 11
      //   594: aload 5
      //   596: aload 5
      //   598: ldc 68
      //   600: invokeinterface 136 2 0
      //   605: invokeinterface 147 2 0
      //   610: putfield 181	midas/x/l0:m	Ljava/lang/String;
      //   613: aload 11
      //   615: aload 5
      //   617: aload 5
      //   619: ldc 70
      //   621: invokeinterface 136 2 0
      //   626: invokeinterface 147 2 0
      //   631: putfield 184	midas/x/l0:n	Ljava/lang/String;
      //   634: aload 11
      //   636: aload 5
      //   638: aload 5
      //   640: ldc 72
      //   642: invokeinterface 136 2 0
      //   647: invokeinterface 147 2 0
      //   652: putfield 187	midas/x/l0:o	Ljava/lang/String;
      //   655: aload 11
      //   657: aload 5
      //   659: aload 5
      //   661: ldc 74
      //   663: invokeinterface 136 2 0
      //   668: invokeinterface 147 2 0
      //   673: putfield 190	midas/x/l0:p	Ljava/lang/String;
      //   676: aload 11
      //   678: aload 5
      //   680: aload 5
      //   682: ldc 76
      //   684: invokeinterface 136 2 0
      //   689: invokeinterface 147 2 0
      //   694: putfield 193	midas/x/l0:s	Ljava/lang/String;
      //   697: aload 11
      //   699: aload 5
      //   701: aload 5
      //   703: ldc 78
      //   705: invokeinterface 136 2 0
      //   710: invokeinterface 147 2 0
      //   715: putfield 196	midas/x/l0:t	Ljava/lang/String;
      //   718: aload 11
      //   720: aload 5
      //   722: aload 5
      //   724: ldc 80
      //   726: invokeinterface 136 2 0
      //   731: invokeinterface 147 2 0
      //   736: putfield 199	midas/x/l0:r	Ljava/lang/String;
      //   739: aload 11
      //   741: aload 5
      //   743: aload 5
      //   745: ldc 82
      //   747: invokeinterface 136 2 0
      //   752: invokeinterface 147 2 0
      //   757: putfield 202	midas/x/l0:q	Ljava/lang/String;
      //   760: aload 11
      //   762: aload 5
      //   764: aload 5
      //   766: ldc 84
      //   768: invokeinterface 136 2 0
      //   773: invokeinterface 147 2 0
      //   778: putfield 205	midas/x/l0:u	Ljava/lang/String;
      //   781: aload 11
      //   783: getfield 169	midas/x/l0:d	Ljava/lang/String;
      //   786: astore 12
      //   788: aload 5
      //   790: aload 5
      //   792: ldc 86
      //   794: invokeinterface 136 2 0
      //   799: invokeinterface 140 2 0
      //   804: istore_3
      //   805: aload 12
      //   807: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   810: ifne +67 -> 877
      //   813: aload 12
      //   815: ldc 213
      //   817: invokestatic 218	midas/x/l6:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   820: astore 10
      //   822: aload 11
      //   824: aload 10
      //   826: iconst_0
      //   827: iload_3
      //   828: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
      //   831: putfield 169	midas/x/l0:d	Ljava/lang/String;
      //   834: aload 11
      //   836: getfield 169	midas/x/l0:d	Ljava/lang/String;
      //   839: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   842: ifeq +35 -> 877
      //   845: ldc 119
      //   847: ldc 224
      //   849: invokestatic 226	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   852: aload 11
      //   854: aload 12
      //   856: ldc 213
      //   858: invokestatic 228	midas/x/l6:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   861: iconst_0
      //   862: iload_3
      //   863: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
      //   866: putfield 169	midas/x/l0:d	Ljava/lang/String;
      //   869: goto +8 -> 877
      //   872: astore 10
      //   874: goto +12 -> 886
      //   877: aload 4
      //   879: astore 10
      //   881: goto +112 -> 993
      //   884: astore 10
      //   886: new 107	java/lang/StringBuilder
      //   889: dup
      //   890: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   893: astore 13
      //   895: aload 13
      //   897: ldc 230
      //   899: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   902: pop
      //   903: aload 13
      //   905: aload 10
      //   907: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   910: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   913: pop
      //   914: ldc 119
      //   916: aload 13
      //   918: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   921: invokestatic 226	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   924: aload 12
      //   926: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   929: ifne -52 -> 877
      //   932: aload 11
      //   934: aload 12
      //   936: ldc 213
      //   938: invokestatic 228	midas/x/l6:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   941: iconst_0
      //   942: iload_3
      //   943: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
      //   946: putfield 169	midas/x/l0:d	Ljava/lang/String;
      //   949: goto -72 -> 877
      //   952: new 107	java/lang/StringBuilder
      //   955: dup
      //   956: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   959: astore 12
      //   961: aload 12
      //   963: ldc 233
      //   965: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   968: pop
      //   969: aload 12
      //   971: aload 10
      //   973: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   976: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   979: pop
      //   980: ldc 119
      //   982: aload 12
      //   984: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   987: invokestatic 226	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   990: goto -113 -> 877
      //   993: aload 10
      //   995: aload 11
      //   997: invokevirtual 237	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   1000: pop
      //   1001: aload 5
      //   1003: invokeinterface 240 1 0
      //   1008: pop
      //   1009: iload_2
      //   1010: iconst_1
      //   1011: iadd
      //   1012: istore_2
      //   1013: aload 10
      //   1015: astore 4
      //   1017: goto -708 -> 309
      //   1020: astore 6
      //   1022: goto +5 -> 1027
      //   1025: astore 6
      //   1027: aload 4
      //   1029: astore 7
      //   1031: aload 5
      //   1033: astore 4
      //   1035: goto +131 -> 1166
      //   1038: aload 5
      //   1040: ifnull +53 -> 1093
      //   1043: aload 5
      //   1045: invokeinterface 243 1 0
      //   1050: goto +43 -> 1093
      //   1053: astore 5
      //   1055: new 107	java/lang/StringBuilder
      //   1058: dup
      //   1059: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   1062: astore 6
      //   1064: aload 6
      //   1066: ldc 245
      //   1068: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1071: pop
      //   1072: aload 6
      //   1074: aload 5
      //   1076: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   1079: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1082: pop
      //   1083: ldc 119
      //   1085: aload 6
      //   1087: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1090: invokestatic 248	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   1093: aload 4
      //   1095: astore 6
      //   1097: goto +298 -> 1395
      //   1100: astore 6
      //   1102: goto +10 -> 1112
      //   1105: astore 4
      //   1107: goto +326 -> 1433
      //   1110: astore 6
      //   1112: aload 5
      //   1114: astore 7
      //   1116: aload 4
      //   1118: astore 5
      //   1120: aload 7
      //   1122: astore 4
      //   1124: goto +46 -> 1170
      //   1127: astore 5
      //   1129: aload 6
      //   1131: astore 4
      //   1133: aload 4
      //   1135: astore 6
      //   1137: aload 5
      //   1139: astore 4
      //   1141: aload 6
      //   1143: astore 5
      //   1145: goto +288 -> 1433
      //   1148: astore 5
      //   1150: aload 11
      //   1152: astore 6
      //   1154: aload 4
      //   1156: astore 7
      //   1158: aload 6
      //   1160: astore 4
      //   1162: aload 5
      //   1164: astore 6
      //   1166: aload 7
      //   1168: astore 5
      //   1170: ldc 250
      //   1172: aload 6
      //   1174: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   1177: invokestatic 248	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   1180: aload_0
      //   1181: astore 7
      //   1183: aload 7
      //   1185: getfield 18	midas/x/h0$f:b	Lmidas/x/h0;
      //   1188: invokestatic 253	midas/x/h0:e	(Lmidas/x/h0;)I
      //   1191: ifne +128 -> 1319
      //   1194: invokestatic 259	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
      //   1197: astore 8
      //   1199: new 107	java/lang/StringBuilder
      //   1202: dup
      //   1203: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   1206: astore 9
      //   1208: aload 9
      //   1210: ldc_w 261
      //   1213: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1216: pop
      //   1217: aload 9
      //   1219: aload 7
      //   1221: getfield 18	midas/x/h0$f:b	Lmidas/x/h0;
      //   1224: invokestatic 44	midas/x/h0:b	(Lmidas/x/h0;)Landroid/database/sqlite/SQLiteDatabase;
      //   1227: invokevirtual 264	android/database/sqlite/SQLiteDatabase:isDatabaseIntegrityOk	()Z
      //   1230: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1233: pop
      //   1234: aload 9
      //   1236: ldc_w 269
      //   1239: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1242: pop
      //   1243: aload 9
      //   1245: aload 6
      //   1247: invokestatic 274	com/pay/tool/APTools:d	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1250: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1253: pop
      //   1254: aload 8
      //   1256: ldc_w 276
      //   1259: ldc_w 278
      //   1262: aload 9
      //   1264: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1267: invokevirtual 281	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   1270: goto +49 -> 1319
      //   1273: astore 5
      //   1275: goto -142 -> 1133
      //   1278: astore 6
      //   1280: new 107	java/lang/StringBuilder
      //   1283: dup
      //   1284: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   1287: astore 8
      //   1289: aload 8
      //   1291: ldc_w 283
      //   1294: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1297: pop
      //   1298: aload 8
      //   1300: aload 6
      //   1302: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   1305: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1308: pop
      //   1309: ldc 119
      //   1311: aload 8
      //   1313: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1316: invokestatic 248	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   1319: aload 7
      //   1321: getfield 18	midas/x/h0$f:b	Lmidas/x/h0;
      //   1324: invokestatic 285	midas/x/h0:f	(Lmidas/x/h0;)I
      //   1327: pop
      //   1328: aload 5
      //   1330: astore 6
      //   1332: aload 4
      //   1334: ifnull +61 -> 1395
      //   1337: aload 4
      //   1339: invokeinterface 243 1 0
      //   1344: aload 5
      //   1346: astore 6
      //   1348: goto +47 -> 1395
      //   1351: astore 4
      //   1353: new 107	java/lang/StringBuilder
      //   1356: dup
      //   1357: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   1360: astore 6
      //   1362: aload 6
      //   1364: ldc 245
      //   1366: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1369: pop
      //   1370: aload 6
      //   1372: aload 4
      //   1374: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   1377: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1380: pop
      //   1381: ldc 119
      //   1383: aload 6
      //   1385: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1388: invokestatic 248	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   1391: aload 5
      //   1393: astore 6
      //   1395: new 287	android/os/Message
      //   1398: dup
      //   1399: invokespecial 288	android/os/Message:<init>	()V
      //   1402: astore 4
      //   1404: aload 4
      //   1406: iconst_0
      //   1407: putfield 291	android/os/Message:what	I
      //   1410: aload 4
      //   1412: aload 6
      //   1414: putfield 295	android/os/Message:obj	Ljava/lang/Object;
      //   1417: aload_0
      //   1418: getfield 20	midas/x/h0$f:a	Lmidas/x/h0$g;
      //   1421: aload 4
      //   1423: invokevirtual 301	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
      //   1426: pop
      //   1427: return
      //   1428: astore 5
      //   1430: goto -297 -> 1133
      //   1433: aload 5
      //   1435: ifnull +53 -> 1488
      //   1438: aload 5
      //   1440: invokeinterface 243 1 0
      //   1445: goto +43 -> 1488
      //   1448: astore 5
      //   1450: new 107	java/lang/StringBuilder
      //   1453: dup
      //   1454: invokespecial 108	java/lang/StringBuilder:<init>	()V
      //   1457: astore 6
      //   1459: aload 6
      //   1461: ldc 245
      //   1463: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1466: pop
      //   1467: aload 6
      //   1469: aload 5
      //   1471: invokevirtual 231	java/lang/Exception:toString	()Ljava/lang/String;
      //   1474: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1477: pop
      //   1478: ldc 119
      //   1480: aload 6
      //   1482: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1485: invokestatic 248	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   1488: goto +6 -> 1494
      //   1491: aload 4
      //   1493: athrow
      //   1494: goto -3 -> 1491
      //   1497: astore 12
      //   1499: goto -547 -> 952
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1502	0	this	f
      //   243	69	1	i	int
      //   237	776	2	j	int
      //   241	702	3	k	int
      //   30	1	4	localArrayList	ArrayList
      //   212	1	4	localObject1	Object
      //   256	15	4	localObject2	Object
      //   303	791	4	localObject3	Object
      //   1105	12	4	localObject4	Object
      //   1122	216	4	localObject5	Object
      //   1351	22	4	localException1	Exception
      //   1402	90	4	localMessage	Message
      //   194	850	5	localObject6	Object
      //   1053	60	5	localException2	Exception
      //   1118	1	5	localObject7	Object
      //   1127	11	5	localObject8	Object
      //   1143	1	5	localObject9	Object
      //   1148	15	5	localException3	Exception
      //   1168	1	5	localObject10	Object
      //   1273	119	5	localObject11	Object
      //   1428	11	5	localObject12	Object
      //   1448	22	5	localException4	Exception
      //   36	416	6	localObject13	Object
      //   1020	1	6	localException5	Exception
      //   1025	1	6	localException6	Exception
      //   1062	34	6	localObject14	Object
      //   1100	1	6	localException7	Exception
      //   1110	20	6	localException8	Exception
      //   1135	111	6	localObject15	Object
      //   1278	23	6	localException9	Exception
      //   1330	151	6	localObject16	Object
      //   10	1	7	str1	String
      //   217	256	7	localException10	Exception
      //   1029	291	7	localObject17	Object
      //   6	1306	8	localObject18	Object
      //   2	1261	9	localObject19	Object
      //   14	811	10	str2	String
      //   872	1	10	localException11	Exception
      //   879	1	10	localObject20	Object
      //   884	130	10	localException12	Exception
      //   33	1118	11	localObject21	Object
      //   786	197	12	localObject22	Object
      //   1497	1	12	localException13	Exception
      //   893	24	13	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   201	209	212	finally
      //   201	209	217	java/lang/Exception
      //   249	253	217	java/lang/Exception
      //   249	253	256	finally
      //   314	805	256	finally
      //   805	822	256	finally
      //   822	869	256	finally
      //   886	924	256	finally
      //   924	949	256	finally
      //   952	990	256	finally
      //   993	1009	256	finally
      //   822	869	872	java/lang/Exception
      //   805	822	884	java/lang/Exception
      //   993	1009	1020	java/lang/Exception
      //   314	805	1025	java/lang/Exception
      //   886	924	1025	java/lang/Exception
      //   952	990	1025	java/lang/Exception
      //   1043	1050	1053	java/lang/Exception
      //   274	299	1100	java/lang/Exception
      //   230	242	1105	finally
      //   261	270	1105	finally
      //   274	299	1105	finally
      //   230	242	1110	java/lang/Exception
      //   261	270	1110	java/lang/Exception
      //   38	196	1127	finally
      //   38	196	1148	java/lang/Exception
      //   1183	1270	1273	finally
      //   1280	1319	1273	finally
      //   1319	1328	1273	finally
      //   1183	1270	1278	java/lang/Exception
      //   1337	1344	1351	java/lang/Exception
      //   1170	1180	1428	finally
      //   1438	1445	1448	java/lang/Exception
      //   924	949	1497	java/lang/Exception
    }
  }
  
  public static class g
    extends Handler
  {
    public WeakReference<o6> a;
    
    public g(o6 paramo6)
    {
      super();
      this.a = new WeakReference(paramo6);
    }
    
    public void handleMessage(Message paramMessage)
    {
      o6 localo6 = (o6)this.a.get();
      if (localo6 != null) {
        localo6.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.obj, paramMessage.getData());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h0
 * JD-Core Version:    0.7.0.1
 */