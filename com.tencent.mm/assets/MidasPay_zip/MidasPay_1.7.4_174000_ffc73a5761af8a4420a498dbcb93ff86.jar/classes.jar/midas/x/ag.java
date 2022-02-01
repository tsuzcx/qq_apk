package midas.x;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ag
{
  private static ag b;
  private static int c = 300;
  public int a = 50000;
  private Context d = null;
  private SQLiteDatabase e = null;
  private ah f = null;
  private Handler g = null;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  
  public ag()
  {
    ai localai = new ai("APDatabaseThread");
    localai.start();
    this.g = new Handler(localai.getLooper());
    this.k = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
  }
  
  public static ag a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new ag();
      }
      if ((paramContext != null) && (b.d == null)) {
        b.d = paramContext.getApplicationContext();
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      if ((this.f == null) || (this.e == null)) {
        a();
      }
      if ((this.e != null) && (!this.e.isOpen()) && (this.f != null))
      {
        this.e = this.f.getWritableDatabase();
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
  
  public void a()
    throws Exception
  {
    Object localObject;
    try
    {
      if ((this.f == null) && (this.d != null))
      {
        this.f = new ah(this.d);
        if (((this.e != null) && (!this.e.isOpen())) || (this.e == null))
        {
          this.e = this.f.getWritableDatabase();
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
      if (this.k == 0)
      {
        localObject = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dbvalid_");
        localStringBuilder.append(this.e.isDatabaseIntegrityOk());
        localStringBuilder.append("|");
        localStringBuilder.append(APTools.d(localException1));
        ((APDataReportManager)localObject).a("sdk.database.err", "open", localStringBuilder.toString());
      }
      label165:
      this.k += 1;
      return;
    }
    catch (Exception localException2)
    {
      break label165;
    }
  }
  
  public void a(final ArrayList<ak> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() > 0)
        {
          if (this.g != null) {
            this.g.post(new Runnable()
            {
              public void run()
              {
                Object localObject1 = new StringBuilder();
                int i = 0;
                while (i < paramArrayList.size())
                {
                  Object localObject3 = (ak)paramArrayList.get(i);
                  if ((localObject3 != null) && (!TextUtils.isEmpty(((ak)localObject3).v)))
                  {
                    ((StringBuilder)localObject1).append("'");
                    ((StringBuilder)localObject1).append(((ak)localObject3).v);
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
                      ag.a(ag.this);
                      try
                      {
                        ag.b(ag.this).delete("APClickStreamTable", (String)localObject1, null);
                      }
                      catch (Exception localException1)
                      {
                        localObject3 = new StringBuilder();
                        ((StringBuilder)localObject3).append("deleteData() e = ");
                        ((StringBuilder)localObject3).append(localException1.toString());
                        APLog.w("APDatabase", ((StringBuilder)localObject3).toString());
                        try
                        {
                          if (ag.c(ag.this) == 0)
                          {
                            localObject3 = APDataReportManager.getInstance();
                            StringBuilder localStringBuilder = new StringBuilder();
                            localStringBuilder.append("dbvalid_");
                            localStringBuilder.append(ag.b(ag.this).isDatabaseIntegrityOk());
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
                        ag.d(ag.this);
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
            });
          }
          return;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(ak paramak)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 93	midas/x/ag:c	()V
    //   6: ldc 188
    //   8: astore 5
    //   10: iconst_0
    //   11: istore_3
    //   12: aload 5
    //   14: astore 4
    //   16: iload_3
    //   17: istore_2
    //   18: aload_1
    //   19: getfield 193	midas/x/ak:e	Ljava/lang/String;
    //   22: invokestatic 199	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +80 -> 105
    //   28: aload_1
    //   29: getfield 193	midas/x/ak:e	Ljava/lang/String;
    //   32: ldc 201
    //   34: invokestatic 206	midas/x/gh:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 4
    //   39: aload_1
    //   40: getfield 193	midas/x/ak:e	Ljava/lang/String;
    //   43: invokevirtual 211	java/lang/String:length	()I
    //   46: istore_2
    //   47: goto +58 -> 105
    //   50: astore 5
    //   52: aload 5
    //   54: astore 6
    //   56: goto +9 -> 65
    //   59: astore 6
    //   61: aload 5
    //   63: astore 4
    //   65: new 116	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   72: astore 5
    //   74: aload 5
    //   76: ldc 213
    //   78: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 5
    //   84: aload 6
    //   86: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   89: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 129
    //   95: aload 5
    //   97: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 136	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: iload_3
    //   104: istore_2
    //   105: new 215	android/content/ContentValues
    //   108: dup
    //   109: invokespecial 216	android/content/ContentValues:<init>	()V
    //   112: astore 5
    //   114: aload 5
    //   116: ldc 218
    //   118: aload_1
    //   119: getfield 220	midas/x/ak:b	I
    //   122: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 230	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   128: aload 5
    //   130: ldc 232
    //   132: aload_1
    //   133: getfield 234	midas/x/ak:c	Ljava/lang/String;
    //   136: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload 5
    //   141: ldc 238
    //   143: aload_1
    //   144: getfield 240	midas/x/ak:d	Ljava/lang/String;
    //   147: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload 5
    //   152: ldc 242
    //   154: aload_1
    //   155: getfield 244	midas/x/ak:f	Ljava/lang/String;
    //   158: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: ldc 246
    //   165: aload_1
    //   166: getfield 248	midas/x/ak:g	Ljava/lang/String;
    //   169: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 5
    //   174: ldc 250
    //   176: aload_1
    //   177: getfield 252	midas/x/ak:h	Ljava/lang/String;
    //   180: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload 5
    //   185: ldc 254
    //   187: aload_1
    //   188: getfield 256	midas/x/ak:i	Ljava/lang/String;
    //   191: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 5
    //   196: ldc_w 258
    //   199: aload_1
    //   200: getfield 260	midas/x/ak:j	Ljava/lang/String;
    //   203: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload 5
    //   208: ldc_w 262
    //   211: aload 4
    //   213: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 5
    //   218: ldc_w 264
    //   221: iload_2
    //   222: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: invokevirtual 230	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   228: aload 5
    //   230: ldc_w 266
    //   233: aload_1
    //   234: getfield 268	midas/x/ak:k	Ljava/lang/String;
    //   237: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload 5
    //   242: ldc_w 270
    //   245: aload_1
    //   246: getfield 273	midas/x/ak:l	Ljava/lang/String;
    //   249: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 5
    //   254: ldc_w 275
    //   257: aload_1
    //   258: getfield 278	midas/x/ak:m	Ljava/lang/String;
    //   261: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 5
    //   266: ldc_w 280
    //   269: aload_1
    //   270: getfield 283	midas/x/ak:n	Ljava/lang/String;
    //   273: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 5
    //   278: ldc_w 285
    //   281: aload_1
    //   282: getfield 288	midas/x/ak:o	Ljava/lang/String;
    //   285: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 5
    //   290: ldc_w 290
    //   293: aload_1
    //   294: getfield 293	midas/x/ak:p	Ljava/lang/String;
    //   297: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 5
    //   302: ldc_w 295
    //   305: aload_1
    //   306: getfield 298	midas/x/ak:q	Ljava/lang/String;
    //   309: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload 5
    //   314: ldc_w 300
    //   317: aload_1
    //   318: getfield 303	midas/x/ak:s	Ljava/lang/String;
    //   321: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload 5
    //   326: ldc_w 305
    //   329: aload_1
    //   330: getfield 308	midas/x/ak:r	Ljava/lang/String;
    //   333: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload 5
    //   338: ldc_w 310
    //   341: aload_1
    //   342: getfield 313	midas/x/ak:t	Ljava/lang/String;
    //   345: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload 5
    //   350: ldc_w 315
    //   353: aload_1
    //   354: getfield 318	midas/x/ak:u	Ljava/lang/String;
    //   357: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload 5
    //   362: ldc_w 320
    //   365: aload_1
    //   366: getfield 323	midas/x/ak:v	Ljava/lang/String;
    //   369: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: getfield 46	midas/x/ag:e	Landroid/database/sqlite/SQLiteDatabase;
    //   376: ldc_w 325
    //   379: ldc_w 327
    //   382: aload 5
    //   384: invokevirtual 331	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   387: pop2
    //   388: goto +192 -> 580
    //   391: astore_1
    //   392: goto +191 -> 583
    //   395: astore_1
    //   396: new 116	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   403: astore 4
    //   405: aload 4
    //   407: ldc_w 333
    //   410: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 4
    //   416: aload_1
    //   417: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   420: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 4
    //   426: ldc_w 335
    //   429: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 4
    //   435: aload_0
    //   436: getfield 55	midas/x/ag:h	I
    //   439: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 129
    //   445: aload 4
    //   447: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 136	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 55	midas/x/ag:h	I
    //   457: ifne +113 -> 570
    //   460: invokestatic 147	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
    //   463: astore 4
    //   465: new 116	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   472: astore 5
    //   474: aload 5
    //   476: ldc 149
    //   478: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 5
    //   484: aload_0
    //   485: getfield 46	midas/x/ag:e	Landroid/database/sqlite/SQLiteDatabase;
    //   488: invokevirtual 152	android/database/sqlite/SQLiteDatabase:isDatabaseIntegrityOk	()Z
    //   491: invokevirtual 155	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 5
    //   497: ldc 157
    //   499: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 5
    //   505: aload_1
    //   506: invokestatic 162	com/pay/tool/APTools:d	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   509: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 4
    //   515: ldc 164
    //   517: ldc_w 339
    //   520: aload 5
    //   522: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokevirtual 169	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   528: goto +42 -> 570
    //   531: astore_1
    //   532: new 116	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   539: astore 4
    //   541: aload 4
    //   543: ldc_w 341
    //   546: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 4
    //   552: aload_1
    //   553: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   556: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: ldc 129
    //   562: aload 4
    //   564: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 136	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload_0
    //   571: aload_0
    //   572: getfield 55	midas/x/ag:h	I
    //   575: iconst_1
    //   576: iadd
    //   577: putfield 55	midas/x/ag:h	I
    //   580: aload_0
    //   581: monitorexit
    //   582: return
    //   583: aload_0
    //   584: monitorexit
    //   585: aload_1
    //   586: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	ag
    //   0	587	1	paramak	ak
    //   17	205	2	m	int
    //   11	93	3	n	int
    //   14	549	4	localObject1	Object
    //   8	5	5	str	String
    //   50	12	5	localException1	Exception
    //   72	449	5	localObject2	Object
    //   54	1	6	localException2	Exception
    //   59	26	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   39	47	50	java/lang/Exception
    //   18	39	59	java/lang/Exception
    //   2	6	391	finally
    //   18	39	391	finally
    //   39	47	391	finally
    //   65	103	391	finally
    //   105	388	391	finally
    //   396	453	391	finally
    //   453	528	391	finally
    //   532	570	391	finally
    //   570	580	391	finally
    //   2	6	395	java/lang/Exception
    //   65	103	395	java/lang/Exception
    //   105	388	395	java/lang/Exception
    //   453	528	531	java/lang/Exception
  }
  
  public void a(final gk paramgk)
  {
    paramgk = new a(new gk()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject, Bundle paramAnonymousBundle)
      {
        paramgk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousObject, paramAnonymousBundle);
      }
    });
    this.g.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	midas/x/ag$4:b	Lmidas/x/ag;
        //   4: invokestatic 30	midas/x/ag:a	(Lmidas/x/ag;)V
        //   7: iconst_0
        //   8: istore_1
        //   9: iconst_0
        //   10: istore_3
        //   11: iconst_0
        //   12: istore_2
        //   13: aconst_null
        //   14: astore 7
        //   16: aconst_null
        //   17: astore 5
        //   19: aload 5
        //   21: astore 4
        //   23: aload_0
        //   24: getfield 18	midas/x/ag$4:b	Lmidas/x/ag;
        //   27: invokestatic 33	midas/x/ag:b	(Lmidas/x/ag;)Landroid/database/sqlite/SQLiteDatabase;
        //   30: ifnull +79 -> 109
        //   33: aload 5
        //   35: astore 4
        //   37: aload_0
        //   38: getfield 18	midas/x/ag$4:b	Lmidas/x/ag;
        //   41: invokestatic 33	midas/x/ag:b	(Lmidas/x/ag;)Landroid/database/sqlite/SQLiteDatabase;
        //   44: ldc 35
        //   46: aconst_null
        //   47: aconst_null
        //   48: aconst_null
        //   49: aconst_null
        //   50: aconst_null
        //   51: aconst_null
        //   52: invokevirtual 41	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   55: astore 5
        //   57: aload 5
        //   59: astore 4
        //   61: aload 4
        //   63: invokeinterface 47 1 0
        //   68: istore_1
        //   69: iload_1
        //   70: invokestatic 49	midas/x/ag:b	()I
        //   73: if_icmple +12 -> 85
        //   76: invokestatic 49	midas/x/ag:b	()I
        //   79: istore_2
        //   80: iload_2
        //   81: istore_1
        //   82: goto +30 -> 112
        //   85: goto +27 -> 112
        //   88: astore 4
        //   90: goto +12 -> 102
        //   93: astore 5
        //   95: goto +207 -> 302
        //   98: astore 4
        //   100: iload_2
        //   101: istore_1
        //   102: aload 4
        //   104: astore 6
        //   106: goto +83 -> 189
        //   109: aconst_null
        //   110: astore 4
        //   112: iload_1
        //   113: istore_2
        //   114: aload 4
        //   116: ifnull +160 -> 276
        //   119: aload 4
        //   121: invokeinterface 52 1 0
        //   126: iload_1
        //   127: istore_2
        //   128: goto +148 -> 276
        //   131: astore 4
        //   133: new 54	java/lang/StringBuilder
        //   136: dup
        //   137: invokespecial 55	java/lang/StringBuilder:<init>	()V
        //   140: astore 5
        //   142: aload 5
        //   144: ldc 57
        //   146: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   149: pop
        //   150: aload 5
        //   152: aload 4
        //   154: invokevirtual 65	java/lang/Exception:toString	()Ljava/lang/String;
        //   157: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   160: pop
        //   161: ldc 67
        //   163: aload 5
        //   165: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   168: invokestatic 74	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   171: iload_1
        //   172: istore_2
        //   173: goto +103 -> 276
        //   176: astore 5
        //   178: goto +124 -> 302
        //   181: astore 6
        //   183: aload 7
        //   185: astore 5
        //   187: iload_3
        //   188: istore_1
        //   189: aload 5
        //   191: astore 4
        //   193: new 54	java/lang/StringBuilder
        //   196: dup
        //   197: invokespecial 55	java/lang/StringBuilder:<init>	()V
        //   200: astore 7
        //   202: aload 5
        //   204: astore 4
        //   206: aload 7
        //   208: ldc 76
        //   210: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: pop
        //   214: aload 5
        //   216: astore 4
        //   218: aload 7
        //   220: aload 6
        //   222: invokevirtual 65	java/lang/Exception:toString	()Ljava/lang/String;
        //   225: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: pop
        //   229: aload 5
        //   231: astore 4
        //   233: ldc 67
        //   235: aload 7
        //   237: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   240: invokestatic 74	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   243: iload_1
        //   244: istore_2
        //   245: aload 5
        //   247: ifnull +29 -> 276
        //   250: aload 5
        //   252: invokeinterface 52 1 0
        //   257: iload_1
        //   258: istore_2
        //   259: goto +17 -> 276
        //   262: astore 4
        //   264: new 54	java/lang/StringBuilder
        //   267: dup
        //   268: invokespecial 55	java/lang/StringBuilder:<init>	()V
        //   271: astore 5
        //   273: goto -131 -> 142
        //   276: new 78	android/os/Message
        //   279: dup
        //   280: invokespecial 79	android/os/Message:<init>	()V
        //   283: astore 4
        //   285: aload 4
        //   287: iload_2
        //   288: putfield 83	android/os/Message:what	I
        //   291: aload_0
        //   292: getfield 20	midas/x/ag$4:a	Lmidas/x/ag$a;
        //   295: aload 4
        //   297: invokevirtual 89	midas/x/ag$a:sendMessage	(Landroid/os/Message;)Z
        //   300: pop
        //   301: return
        //   302: aload 4
        //   304: ifnull +53 -> 357
        //   307: aload 4
        //   309: invokeinterface 52 1 0
        //   314: goto +43 -> 357
        //   317: astore 4
        //   319: new 54	java/lang/StringBuilder
        //   322: dup
        //   323: invokespecial 55	java/lang/StringBuilder:<init>	()V
        //   326: astore 6
        //   328: aload 6
        //   330: ldc 57
        //   332: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   335: pop
        //   336: aload 6
        //   338: aload 4
        //   340: invokevirtual 65	java/lang/Exception:toString	()Ljava/lang/String;
        //   343: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   346: pop
        //   347: ldc 67
        //   349: aload 6
        //   351: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   354: invokestatic 74	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   357: aload 5
        //   359: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	360	0	this	4
        //   8	250	1	i	int
        //   12	276	2	j	int
        //   10	178	3	k	int
        //   21	41	4	localCursor1	android.database.Cursor
        //   88	1	4	localException1	Exception
        //   98	5	4	localException2	Exception
        //   110	10	4	localObject1	Object
        //   131	22	4	localException3	Exception
        //   191	41	4	localStringBuilder1	StringBuilder
        //   262	1	4	localException4	Exception
        //   283	25	4	localMessage	Message
        //   317	22	4	localException5	Exception
        //   17	41	5	localCursor2	android.database.Cursor
        //   93	1	5	localObject2	Object
        //   140	24	5	localStringBuilder2	StringBuilder
        //   176	1	5	localObject3	Object
        //   185	173	5	localStringBuilder3	StringBuilder
        //   104	1	6	localException6	Exception
        //   181	40	6	localException7	Exception
        //   326	24	6	localStringBuilder4	StringBuilder
        //   14	222	7	localStringBuilder5	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   69	80	88	java/lang/Exception
        //   61	69	93	finally
        //   69	80	93	finally
        //   61	69	98	java/lang/Exception
        //   119	126	131	java/lang/Exception
        //   23	33	176	finally
        //   37	57	176	finally
        //   193	202	176	finally
        //   206	214	176	finally
        //   218	229	176	finally
        //   233	243	176	finally
        //   23	33	181	java/lang/Exception
        //   37	57	181	java/lang/Exception
        //   250	257	262	java/lang/Exception
        //   307	314	317	java/lang/Exception
      }
    });
  }
  
  public void b(final ak paramak)
  {
    try
    {
      if (this.g != null) {
        this.g.post(new Runnable()
        {
          public void run()
          {
            ag.this.a(paramak);
          }
        });
      }
      return;
    }
    finally
    {
      paramak = finally;
      throw paramak;
    }
  }
  
  public void b(final gk paramgk)
  {
    paramgk = new a(new gk()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject, Bundle paramAnonymousBundle)
      {
        paramgk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousObject, paramAnonymousBundle);
      }
    });
    this.g.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	midas/x/ag$6:b	Lmidas/x/ag;
        //   4: invokestatic 30	midas/x/ag:a	(Lmidas/x/ag;)V
        //   7: new 32	java/util/ArrayList
        //   10: dup
        //   11: invokespecial 33	java/util/ArrayList:<init>	()V
        //   14: astore 7
        //   16: aload_0
        //   17: getfield 18	midas/x/ag$6:b	Lmidas/x/ag;
        //   20: invokestatic 36	midas/x/ag:b	(Lmidas/x/ag;)Landroid/database/sqlite/SQLiteDatabase;
        //   23: iconst_1
        //   24: ldc 38
        //   26: bipush 23
        //   28: anewarray 40	java/lang/String
        //   31: dup
        //   32: iconst_0
        //   33: ldc 42
        //   35: aastore
        //   36: dup
        //   37: iconst_1
        //   38: ldc 44
        //   40: aastore
        //   41: dup
        //   42: iconst_2
        //   43: ldc 46
        //   45: aastore
        //   46: dup
        //   47: iconst_3
        //   48: ldc 48
        //   50: aastore
        //   51: dup
        //   52: iconst_4
        //   53: ldc 50
        //   55: aastore
        //   56: dup
        //   57: iconst_5
        //   58: ldc 52
        //   60: aastore
        //   61: dup
        //   62: bipush 6
        //   64: ldc 54
        //   66: aastore
        //   67: dup
        //   68: bipush 7
        //   70: ldc 56
        //   72: aastore
        //   73: dup
        //   74: bipush 8
        //   76: ldc 58
        //   78: aastore
        //   79: dup
        //   80: bipush 9
        //   82: ldc 60
        //   84: aastore
        //   85: dup
        //   86: bipush 10
        //   88: ldc 62
        //   90: aastore
        //   91: dup
        //   92: bipush 11
        //   94: ldc 64
        //   96: aastore
        //   97: dup
        //   98: bipush 12
        //   100: ldc 66
        //   102: aastore
        //   103: dup
        //   104: bipush 13
        //   106: ldc 68
        //   108: aastore
        //   109: dup
        //   110: bipush 14
        //   112: ldc 70
        //   114: aastore
        //   115: dup
        //   116: bipush 15
        //   118: ldc 72
        //   120: aastore
        //   121: dup
        //   122: bipush 16
        //   124: ldc 74
        //   126: aastore
        //   127: dup
        //   128: bipush 17
        //   130: ldc 76
        //   132: aastore
        //   133: dup
        //   134: bipush 18
        //   136: ldc 78
        //   138: aastore
        //   139: dup
        //   140: bipush 19
        //   142: ldc 80
        //   144: aastore
        //   145: dup
        //   146: bipush 20
        //   148: ldc 82
        //   150: aastore
        //   151: dup
        //   152: bipush 21
        //   154: ldc 84
        //   156: aastore
        //   157: dup
        //   158: bipush 22
        //   160: ldc 86
        //   162: aastore
        //   163: aconst_null
        //   164: aconst_null
        //   165: aconst_null
        //   166: aconst_null
        //   167: aconst_null
        //   168: aconst_null
        //   169: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   172: astore 5
        //   174: aload 5
        //   176: ifnull +18 -> 194
        //   179: aload 5
        //   181: astore 4
        //   183: aload 5
        //   185: invokeinterface 98 1 0
        //   190: pop
        //   191: goto +3 -> 194
        //   194: aload 5
        //   196: astore 4
        //   198: aload 5
        //   200: invokeinterface 102 1 0
        //   205: istore_2
        //   206: iload_2
        //   207: istore_1
        //   208: aload 5
        //   210: astore 4
        //   212: iload_2
        //   213: invokestatic 104	midas/x/ag:b	()I
        //   216: if_icmple +11 -> 227
        //   219: aload 5
        //   221: astore 4
        //   223: invokestatic 104	midas/x/ag:b	()I
        //   226: istore_1
        //   227: aload 5
        //   229: astore 4
        //   231: new 106	java/lang/StringBuilder
        //   234: dup
        //   235: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   238: astore 6
        //   240: aload 5
        //   242: astore 4
        //   244: aload 6
        //   246: ldc 109
        //   248: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   251: pop
        //   252: aload 5
        //   254: astore 4
        //   256: aload 6
        //   258: iload_1
        //   259: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   262: pop
        //   263: aload 5
        //   265: astore 4
        //   267: ldc 118
        //   269: aload 6
        //   271: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   274: invokestatic 128	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   277: iconst_0
        //   278: istore_2
        //   279: iload_2
        //   280: iload_1
        //   281: if_icmpge +858 -> 1139
        //   284: aload 5
        //   286: astore 4
        //   288: new 130	midas/x/ak
        //   291: dup
        //   292: invokespecial 131	midas/x/ak:<init>	()V
        //   295: astore 6
        //   297: aload 5
        //   299: astore 4
        //   301: aload 6
        //   303: aload 5
        //   305: aload 5
        //   307: ldc 42
        //   309: invokeinterface 135 2 0
        //   314: invokeinterface 139 2 0
        //   319: putfield 142	midas/x/ak:a	I
        //   322: aload 5
        //   324: astore 4
        //   326: aload 6
        //   328: aload 5
        //   330: aload 5
        //   332: ldc 44
        //   334: invokeinterface 135 2 0
        //   339: invokeinterface 139 2 0
        //   344: putfield 144	midas/x/ak:b	I
        //   347: aload 5
        //   349: astore 4
        //   351: aload 6
        //   353: aload 5
        //   355: aload 5
        //   357: ldc 46
        //   359: invokeinterface 135 2 0
        //   364: invokeinterface 148 2 0
        //   369: putfield 152	midas/x/ak:c	Ljava/lang/String;
        //   372: aload 5
        //   374: astore 4
        //   376: aload 6
        //   378: aload 5
        //   380: aload 5
        //   382: ldc 48
        //   384: invokeinterface 135 2 0
        //   389: invokeinterface 148 2 0
        //   394: putfield 155	midas/x/ak:d	Ljava/lang/String;
        //   397: aload 5
        //   399: astore 4
        //   401: aload 6
        //   403: aload 5
        //   405: aload 5
        //   407: ldc 50
        //   409: invokeinterface 135 2 0
        //   414: invokeinterface 148 2 0
        //   419: putfield 158	midas/x/ak:f	Ljava/lang/String;
        //   422: aload 5
        //   424: astore 4
        //   426: aload 6
        //   428: aload 5
        //   430: aload 5
        //   432: ldc 52
        //   434: invokeinterface 135 2 0
        //   439: invokeinterface 148 2 0
        //   444: putfield 161	midas/x/ak:g	Ljava/lang/String;
        //   447: aload 5
        //   449: astore 4
        //   451: aload 6
        //   453: aload 5
        //   455: aload 5
        //   457: ldc 54
        //   459: invokeinterface 135 2 0
        //   464: invokeinterface 148 2 0
        //   469: putfield 164	midas/x/ak:h	Ljava/lang/String;
        //   472: aload 5
        //   474: astore 4
        //   476: aload 6
        //   478: aload 5
        //   480: aload 5
        //   482: ldc 56
        //   484: invokeinterface 135 2 0
        //   489: invokeinterface 148 2 0
        //   494: putfield 166	midas/x/ak:i	Ljava/lang/String;
        //   497: aload 5
        //   499: astore 4
        //   501: aload 6
        //   503: aload 5
        //   505: aload 5
        //   507: ldc 58
        //   509: invokeinterface 135 2 0
        //   514: invokeinterface 148 2 0
        //   519: putfield 169	midas/x/ak:j	Ljava/lang/String;
        //   522: aload 5
        //   524: astore 4
        //   526: aload 6
        //   528: aload 5
        //   530: aload 5
        //   532: ldc 62
        //   534: invokeinterface 135 2 0
        //   539: invokeinterface 148 2 0
        //   544: putfield 172	midas/x/ak:e	Ljava/lang/String;
        //   547: aload 5
        //   549: astore 4
        //   551: aload 6
        //   553: aload 5
        //   555: aload 5
        //   557: ldc 60
        //   559: invokeinterface 135 2 0
        //   564: invokeinterface 148 2 0
        //   569: putfield 175	midas/x/ak:k	Ljava/lang/String;
        //   572: aload 5
        //   574: astore 4
        //   576: aload 6
        //   578: aload 5
        //   580: aload 5
        //   582: ldc 64
        //   584: invokeinterface 135 2 0
        //   589: invokeinterface 148 2 0
        //   594: putfield 178	midas/x/ak:l	Ljava/lang/String;
        //   597: aload 5
        //   599: astore 4
        //   601: aload 6
        //   603: aload 5
        //   605: aload 5
        //   607: ldc 66
        //   609: invokeinterface 135 2 0
        //   614: invokeinterface 148 2 0
        //   619: putfield 181	midas/x/ak:m	Ljava/lang/String;
        //   622: aload 5
        //   624: astore 4
        //   626: aload 6
        //   628: aload 5
        //   630: aload 5
        //   632: ldc 68
        //   634: invokeinterface 135 2 0
        //   639: invokeinterface 148 2 0
        //   644: putfield 184	midas/x/ak:n	Ljava/lang/String;
        //   647: aload 5
        //   649: astore 4
        //   651: aload 6
        //   653: aload 5
        //   655: aload 5
        //   657: ldc 70
        //   659: invokeinterface 135 2 0
        //   664: invokeinterface 148 2 0
        //   669: putfield 187	midas/x/ak:o	Ljava/lang/String;
        //   672: aload 5
        //   674: astore 4
        //   676: aload 6
        //   678: aload 5
        //   680: aload 5
        //   682: ldc 72
        //   684: invokeinterface 135 2 0
        //   689: invokeinterface 148 2 0
        //   694: putfield 190	midas/x/ak:p	Ljava/lang/String;
        //   697: aload 5
        //   699: astore 4
        //   701: aload 6
        //   703: aload 5
        //   705: aload 5
        //   707: ldc 74
        //   709: invokeinterface 135 2 0
        //   714: invokeinterface 148 2 0
        //   719: putfield 193	midas/x/ak:q	Ljava/lang/String;
        //   722: aload 5
        //   724: astore 4
        //   726: aload 6
        //   728: aload 5
        //   730: aload 5
        //   732: ldc 76
        //   734: invokeinterface 135 2 0
        //   739: invokeinterface 148 2 0
        //   744: putfield 196	midas/x/ak:t	Ljava/lang/String;
        //   747: aload 5
        //   749: astore 4
        //   751: aload 6
        //   753: aload 5
        //   755: aload 5
        //   757: ldc 78
        //   759: invokeinterface 135 2 0
        //   764: invokeinterface 148 2 0
        //   769: putfield 199	midas/x/ak:u	Ljava/lang/String;
        //   772: aload 5
        //   774: astore 4
        //   776: aload 6
        //   778: aload 5
        //   780: aload 5
        //   782: ldc 80
        //   784: invokeinterface 135 2 0
        //   789: invokeinterface 148 2 0
        //   794: putfield 202	midas/x/ak:s	Ljava/lang/String;
        //   797: aload 5
        //   799: astore 4
        //   801: aload 6
        //   803: aload 5
        //   805: aload 5
        //   807: ldc 82
        //   809: invokeinterface 135 2 0
        //   814: invokeinterface 148 2 0
        //   819: putfield 205	midas/x/ak:r	Ljava/lang/String;
        //   822: aload 5
        //   824: astore 4
        //   826: aload 6
        //   828: aload 5
        //   830: aload 5
        //   832: ldc 84
        //   834: invokeinterface 135 2 0
        //   839: invokeinterface 148 2 0
        //   844: putfield 208	midas/x/ak:v	Ljava/lang/String;
        //   847: aload 5
        //   849: astore 4
        //   851: aload 6
        //   853: getfield 172	midas/x/ak:e	Ljava/lang/String;
        //   856: astore 9
        //   858: aload 5
        //   860: astore 4
        //   862: aload 5
        //   864: aload 5
        //   866: ldc 86
        //   868: invokeinterface 135 2 0
        //   873: invokeinterface 139 2 0
        //   878: istore_3
        //   879: aload 5
        //   881: astore 4
        //   883: aload 9
        //   885: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   888: ifne +220 -> 1108
        //   891: aload 5
        //   893: astore 4
        //   895: aload 6
        //   897: aload 9
        //   899: ldc 216
        //   901: invokestatic 221	midas/x/gh:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   904: iconst_0
        //   905: iload_3
        //   906: invokevirtual 225	java/lang/String:substring	(II)Ljava/lang/String;
        //   909: putfield 172	midas/x/ak:e	Ljava/lang/String;
        //   912: aload 5
        //   914: astore 4
        //   916: aload 6
        //   918: getfield 172	midas/x/ak:e	Ljava/lang/String;
        //   921: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   924: ifeq +184 -> 1108
        //   927: aload 5
        //   929: astore 4
        //   931: ldc 118
        //   933: ldc 227
        //   935: invokestatic 229	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   938: aload 5
        //   940: astore 4
        //   942: aload 6
        //   944: aload 9
        //   946: ldc 216
        //   948: invokestatic 231	midas/x/gh:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   951: iconst_0
        //   952: iload_3
        //   953: invokevirtual 225	java/lang/String:substring	(II)Ljava/lang/String;
        //   956: putfield 172	midas/x/ak:e	Ljava/lang/String;
        //   959: goto +149 -> 1108
        //   962: astore 8
        //   964: aload 5
        //   966: astore 4
        //   968: new 106	java/lang/StringBuilder
        //   971: dup
        //   972: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   975: astore 10
        //   977: aload 5
        //   979: astore 4
        //   981: aload 10
        //   983: ldc 233
        //   985: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   988: pop
        //   989: aload 5
        //   991: astore 4
        //   993: aload 10
        //   995: aload 8
        //   997: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
        //   1000: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1003: pop
        //   1004: aload 5
        //   1006: astore 4
        //   1008: ldc 118
        //   1010: aload 10
        //   1012: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1015: invokestatic 229	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1018: aload 5
        //   1020: astore 4
        //   1022: aload 9
        //   1024: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   1027: ifne +81 -> 1108
        //   1030: aload 5
        //   1032: astore 4
        //   1034: aload 6
        //   1036: aload 9
        //   1038: ldc 216
        //   1040: invokestatic 231	midas/x/gh:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   1043: iconst_0
        //   1044: iload_3
        //   1045: invokevirtual 225	java/lang/String:substring	(II)Ljava/lang/String;
        //   1048: putfield 172	midas/x/ak:e	Ljava/lang/String;
        //   1051: goto +57 -> 1108
        //   1054: aload 5
        //   1056: astore 4
        //   1058: new 106	java/lang/StringBuilder
        //   1061: dup
        //   1062: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   1065: astore 9
        //   1067: aload 5
        //   1069: astore 4
        //   1071: aload 9
        //   1073: ldc 236
        //   1075: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1078: pop
        //   1079: aload 5
        //   1081: astore 4
        //   1083: aload 9
        //   1085: aload 8
        //   1087: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
        //   1090: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1093: pop
        //   1094: aload 5
        //   1096: astore 4
        //   1098: ldc 118
        //   1100: aload 9
        //   1102: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1105: invokestatic 229	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1108: aload 5
        //   1110: astore 4
        //   1112: aload 7
        //   1114: aload 6
        //   1116: invokevirtual 240	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   1119: pop
        //   1120: aload 5
        //   1122: astore 4
        //   1124: aload 5
        //   1126: invokeinterface 243 1 0
        //   1131: pop
        //   1132: iload_2
        //   1133: iconst_1
        //   1134: iadd
        //   1135: istore_2
        //   1136: goto -857 -> 279
        //   1139: aload 5
        //   1141: ifnull +299 -> 1440
        //   1144: aload 5
        //   1146: invokeinterface 246 1 0
        //   1151: goto +289 -> 1440
        //   1154: astore 4
        //   1156: new 106	java/lang/StringBuilder
        //   1159: dup
        //   1160: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   1163: astore 5
        //   1165: goto +245 -> 1410
        //   1168: astore 4
        //   1170: aconst_null
        //   1171: astore 5
        //   1173: goto +310 -> 1483
        //   1176: astore 6
        //   1178: aconst_null
        //   1179: astore 5
        //   1181: aload 5
        //   1183: astore 4
        //   1185: ldc 248
        //   1187: aload 6
        //   1189: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
        //   1192: invokestatic 251	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1195: aload 5
        //   1197: astore 4
        //   1199: aload_0
        //   1200: getfield 18	midas/x/ag$6:b	Lmidas/x/ag;
        //   1203: invokestatic 254	midas/x/ag:e	(Lmidas/x/ag;)I
        //   1206: ifne +166 -> 1372
        //   1209: aload 5
        //   1211: astore 4
        //   1213: invokestatic 260	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
        //   1216: astore 8
        //   1218: aload 5
        //   1220: astore 4
        //   1222: new 106	java/lang/StringBuilder
        //   1225: dup
        //   1226: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   1229: astore 9
        //   1231: aload 5
        //   1233: astore 4
        //   1235: aload 9
        //   1237: ldc_w 262
        //   1240: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1243: pop
        //   1244: aload 5
        //   1246: astore 4
        //   1248: aload 9
        //   1250: aload_0
        //   1251: getfield 18	midas/x/ag$6:b	Lmidas/x/ag;
        //   1254: invokestatic 36	midas/x/ag:b	(Lmidas/x/ag;)Landroid/database/sqlite/SQLiteDatabase;
        //   1257: invokevirtual 265	android/database/sqlite/SQLiteDatabase:isDatabaseIntegrityOk	()Z
        //   1260: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
        //   1263: pop
        //   1264: aload 5
        //   1266: astore 4
        //   1268: aload 9
        //   1270: ldc_w 270
        //   1273: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1276: pop
        //   1277: aload 5
        //   1279: astore 4
        //   1281: aload 9
        //   1283: aload 6
        //   1285: invokestatic 275	com/pay/tool/APTools:d	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   1288: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1291: pop
        //   1292: aload 5
        //   1294: astore 4
        //   1296: aload 8
        //   1298: ldc_w 277
        //   1301: ldc_w 279
        //   1304: aload 9
        //   1306: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1309: invokevirtual 282	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   1312: goto +60 -> 1372
        //   1315: astore 6
        //   1317: aload 5
        //   1319: astore 4
        //   1321: new 106	java/lang/StringBuilder
        //   1324: dup
        //   1325: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   1328: astore 8
        //   1330: aload 5
        //   1332: astore 4
        //   1334: aload 8
        //   1336: ldc_w 284
        //   1339: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1342: pop
        //   1343: aload 5
        //   1345: astore 4
        //   1347: aload 8
        //   1349: aload 6
        //   1351: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
        //   1354: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1357: pop
        //   1358: aload 5
        //   1360: astore 4
        //   1362: ldc 118
        //   1364: aload 8
        //   1366: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1369: invokestatic 251	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1372: aload 5
        //   1374: astore 4
        //   1376: aload_0
        //   1377: getfield 18	midas/x/ag$6:b	Lmidas/x/ag;
        //   1380: invokestatic 286	midas/x/ag:f	(Lmidas/x/ag;)I
        //   1383: pop
        //   1384: aload 5
        //   1386: ifnull +54 -> 1440
        //   1389: aload 5
        //   1391: invokeinterface 246 1 0
        //   1396: goto +44 -> 1440
        //   1399: astore 4
        //   1401: new 106	java/lang/StringBuilder
        //   1404: dup
        //   1405: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   1408: astore 5
        //   1410: aload 5
        //   1412: ldc_w 288
        //   1415: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1418: pop
        //   1419: aload 5
        //   1421: aload 4
        //   1423: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
        //   1426: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1429: pop
        //   1430: ldc 118
        //   1432: aload 5
        //   1434: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1437: invokestatic 251	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1440: new 290	android/os/Message
        //   1443: dup
        //   1444: invokespecial 291	android/os/Message:<init>	()V
        //   1447: astore 4
        //   1449: aload 4
        //   1451: iconst_0
        //   1452: putfield 294	android/os/Message:what	I
        //   1455: aload 4
        //   1457: aload 7
        //   1459: putfield 298	android/os/Message:obj	Ljava/lang/Object;
        //   1462: aload_0
        //   1463: getfield 20	midas/x/ag$6:a	Lmidas/x/ag$a;
        //   1466: aload 4
        //   1468: invokevirtual 304	midas/x/ag$a:sendMessage	(Landroid/os/Message;)Z
        //   1471: pop
        //   1472: return
        //   1473: astore 6
        //   1475: aload 4
        //   1477: astore 5
        //   1479: aload 6
        //   1481: astore 4
        //   1483: aload 5
        //   1485: ifnull +54 -> 1539
        //   1488: aload 5
        //   1490: invokeinterface 246 1 0
        //   1495: goto +44 -> 1539
        //   1498: astore 5
        //   1500: new 106	java/lang/StringBuilder
        //   1503: dup
        //   1504: invokespecial 107	java/lang/StringBuilder:<init>	()V
        //   1507: astore 6
        //   1509: aload 6
        //   1511: ldc_w 288
        //   1514: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1517: pop
        //   1518: aload 6
        //   1520: aload 5
        //   1522: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
        //   1525: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1528: pop
        //   1529: ldc 118
        //   1531: aload 6
        //   1533: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1536: invokestatic 251	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   1539: aload 4
        //   1541: athrow
        //   1542: astore 4
        //   1544: goto -490 -> 1054
        //   1547: astore 6
        //   1549: goto -368 -> 1181
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1552	0	this	6
        //   207	75	1	i	int
        //   205	931	2	j	int
        //   878	167	3	k	int
        //   181	942	4	localObject1	Object
        //   1154	1	4	localException1	Exception
        //   1168	1	4	localObject2	Object
        //   1183	192	4	localObject3	Object
        //   1399	23	4	localException2	Exception
        //   1447	93	4	localObject4	Object
        //   1542	1	4	localException3	Exception
        //   172	1317	5	localObject5	Object
        //   1498	23	5	localException4	Exception
        //   238	877	6	localObject6	Object
        //   1176	108	6	localException5	Exception
        //   1315	35	6	localException6	Exception
        //   1473	7	6	localObject7	Object
        //   1507	25	6	localStringBuilder1	StringBuilder
        //   1547	1	6	localException7	Exception
        //   14	1444	7	localArrayList	ArrayList
        //   962	124	8	localException8	Exception
        //   1216	149	8	localObject8	Object
        //   856	449	9	localObject9	Object
        //   975	36	10	localStringBuilder2	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   883	891	962	java/lang/Exception
        //   895	912	962	java/lang/Exception
        //   916	927	962	java/lang/Exception
        //   931	938	962	java/lang/Exception
        //   942	959	962	java/lang/Exception
        //   1144	1151	1154	java/lang/Exception
        //   16	174	1168	finally
        //   16	174	1176	java/lang/Exception
        //   1199	1209	1315	java/lang/Exception
        //   1213	1218	1315	java/lang/Exception
        //   1222	1231	1315	java/lang/Exception
        //   1235	1244	1315	java/lang/Exception
        //   1248	1264	1315	java/lang/Exception
        //   1268	1277	1315	java/lang/Exception
        //   1281	1292	1315	java/lang/Exception
        //   1296	1312	1315	java/lang/Exception
        //   1389	1396	1399	java/lang/Exception
        //   183	191	1473	finally
        //   198	206	1473	finally
        //   212	219	1473	finally
        //   223	227	1473	finally
        //   231	240	1473	finally
        //   244	252	1473	finally
        //   256	263	1473	finally
        //   267	277	1473	finally
        //   288	297	1473	finally
        //   301	322	1473	finally
        //   326	347	1473	finally
        //   351	372	1473	finally
        //   376	397	1473	finally
        //   401	422	1473	finally
        //   426	447	1473	finally
        //   451	472	1473	finally
        //   476	497	1473	finally
        //   501	522	1473	finally
        //   526	547	1473	finally
        //   551	572	1473	finally
        //   576	597	1473	finally
        //   601	622	1473	finally
        //   626	647	1473	finally
        //   651	672	1473	finally
        //   676	697	1473	finally
        //   701	722	1473	finally
        //   726	747	1473	finally
        //   751	772	1473	finally
        //   776	797	1473	finally
        //   801	822	1473	finally
        //   826	847	1473	finally
        //   851	858	1473	finally
        //   862	879	1473	finally
        //   883	891	1473	finally
        //   895	912	1473	finally
        //   916	927	1473	finally
        //   931	938	1473	finally
        //   942	959	1473	finally
        //   968	977	1473	finally
        //   981	989	1473	finally
        //   993	1004	1473	finally
        //   1008	1018	1473	finally
        //   1022	1030	1473	finally
        //   1034	1051	1473	finally
        //   1058	1067	1473	finally
        //   1071	1079	1473	finally
        //   1083	1094	1473	finally
        //   1098	1108	1473	finally
        //   1112	1120	1473	finally
        //   1124	1132	1473	finally
        //   1185	1195	1473	finally
        //   1199	1209	1473	finally
        //   1213	1218	1473	finally
        //   1222	1231	1473	finally
        //   1235	1244	1473	finally
        //   1248	1264	1473	finally
        //   1268	1277	1473	finally
        //   1281	1292	1473	finally
        //   1296	1312	1473	finally
        //   1321	1330	1473	finally
        //   1334	1343	1473	finally
        //   1347	1358	1473	finally
        //   1362	1372	1473	finally
        //   1376	1384	1473	finally
        //   1488	1495	1498	java/lang/Exception
        //   1022	1030	1542	java/lang/Exception
        //   1034	1051	1542	java/lang/Exception
        //   183	191	1547	java/lang/Exception
        //   198	206	1547	java/lang/Exception
        //   212	219	1547	java/lang/Exception
        //   223	227	1547	java/lang/Exception
        //   231	240	1547	java/lang/Exception
        //   244	252	1547	java/lang/Exception
        //   256	263	1547	java/lang/Exception
        //   267	277	1547	java/lang/Exception
        //   288	297	1547	java/lang/Exception
        //   301	322	1547	java/lang/Exception
        //   326	347	1547	java/lang/Exception
        //   351	372	1547	java/lang/Exception
        //   376	397	1547	java/lang/Exception
        //   401	422	1547	java/lang/Exception
        //   426	447	1547	java/lang/Exception
        //   451	472	1547	java/lang/Exception
        //   476	497	1547	java/lang/Exception
        //   501	522	1547	java/lang/Exception
        //   526	547	1547	java/lang/Exception
        //   551	572	1547	java/lang/Exception
        //   576	597	1547	java/lang/Exception
        //   601	622	1547	java/lang/Exception
        //   626	647	1547	java/lang/Exception
        //   651	672	1547	java/lang/Exception
        //   676	697	1547	java/lang/Exception
        //   701	722	1547	java/lang/Exception
        //   726	747	1547	java/lang/Exception
        //   751	772	1547	java/lang/Exception
        //   776	797	1547	java/lang/Exception
        //   801	822	1547	java/lang/Exception
        //   826	847	1547	java/lang/Exception
        //   851	858	1547	java/lang/Exception
        //   862	879	1547	java/lang/Exception
        //   968	977	1547	java/lang/Exception
        //   981	989	1547	java/lang/Exception
        //   993	1004	1547	java/lang/Exception
        //   1008	1018	1547	java/lang/Exception
        //   1058	1067	1547	java/lang/Exception
        //   1071	1079	1547	java/lang/Exception
        //   1083	1094	1547	java/lang/Exception
        //   1098	1108	1547	java/lang/Exception
        //   1112	1120	1547	java/lang/Exception
        //   1124	1132	1547	java/lang/Exception
      }
    });
  }
  
  static class a
    extends Handler
  {
    private WeakReference<gk> a;
    
    public a(gk paramgk)
    {
      super();
      this.a = new WeakReference(paramgk);
    }
    
    public void handleMessage(Message paramMessage)
    {
      gk localgk = (gk)this.a.get();
      if (localgk != null) {
        localgk.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.obj, paramMessage.getData());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ag
 * JD-Core Version:    0.7.0.1
 */