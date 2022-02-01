package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.bugly.crashreport.biz.UserInfoBean;>;

public final class a
{
  private Context a;
  private long b;
  private int c;
  private boolean d = true;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean)
  {
    if (paramUserInfoBean == null) {}
    do
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramUserInfoBean.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramUserInfoBean.a));
        }
        localContentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
        localContentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
        localContentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
        localContentValues.put("_pc", paramUserInfoBean.c);
        localContentValues.put("_dt", z.a(paramUserInfoBean));
        return localContentValues;
      }
      catch (Throwable paramUserInfoBean) {}
    } while (x.a(paramUserInfoBean));
    paramUserInfoBean.printStackTrace();
    return null;
  }
  
  private static UserInfoBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      paramCursor = null;
    }
    for (;;)
    {
      return paramCursor;
      try
      {
        Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        if (localObject == null) {
          return null;
        }
        long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localObject = (UserInfoBean)z.a((byte[])localObject, UserInfoBean.CREATOR);
        paramCursor = (Cursor)localObject;
        if (localObject != null)
        {
          ((UserInfoBean)localObject).a = l;
          return localObject;
        }
      }
      catch (Throwable paramCursor)
      {
        if (!x.a(paramCursor)) {
          paramCursor.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private static void a(List<UserInfoBean> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while ((i < paramList.size()) && (i < 50))
      {
        localObject = (UserInfoBean)paramList.get(i);
        localStringBuilder.append(" or _id").append(" = ").append(((UserInfoBean)localObject).a);
        i += 1;
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<UserInfoBean>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        x.c("[Database] deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(p.a().a("t_ui", paramList, null, null, true)) });
        return;
      }
      catch (Throwable paramList) {}
    } while (x.a(paramList));
    paramList.printStackTrace();
  }
  
  private void c()
  {
    boolean bool1 = false;
    Object localObject4;
    Object localObject5;
    label109:
    int j;
    label126:
    Object localObject6;
    label213:
    label252:
    Object localObject7;
    label390:
    label440:
    Object localObject3;
    for (;;)
    {
      Object localObject1;
      try
      {
        boolean bool2 = this.d;
        if (!bool2) {
          return;
        }
        localObject4 = u.a();
        if (localObject4 == null) {
          continue;
        }
        localObject1 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if ((localObject1 == null) || ((((com.tencent.bugly.crashreport.common.strategy.a)localObject1).b()) && (!((u)localObject4).b(1001)))) {
          continue;
        }
        localObject1 = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
        localObject5 = new ArrayList();
        localObject1 = a((String)localObject1);
        if (localObject1 == null) {
          break label440;
        }
        int k = ((List)localObject1).size() - 20;
        if (k > 0)
        {
          i = 0;
          if (i >= ((List)localObject1).size() - 1) {
            break label709;
          }
          j = i + 1;
          if (j >= ((List)localObject1).size()) {
            break label702;
          }
          if (((UserInfoBean)((List)localObject1).get(i)).e <= ((UserInfoBean)((List)localObject1).get(j)).e) {
            break label695;
          }
          localObject6 = (UserInfoBean)((List)localObject1).get(i);
          ((List)localObject1).set(i, ((List)localObject1).get(j));
          ((List)localObject1).set(j, localObject6);
          break label695;
          if (i < k)
          {
            ((List)localObject5).add(((List)localObject1).get(i));
            i += 1;
            continue;
          }
        }
        localObject6 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject6).hasNext())
        {
          localObject7 = (UserInfoBean)((Iterator)localObject6).next();
          if (((UserInfoBean)localObject7).f != -1L)
          {
            ((Iterator)localObject6).remove();
            if (((UserInfoBean)localObject7).e < z.b()) {
              ((List)localObject5).add(localObject7);
            }
          }
          if (((UserInfoBean)localObject7).e <= System.currentTimeMillis() - 600000L) {
            break label692;
          }
          if ((((UserInfoBean)localObject7).b == 1) || (((UserInfoBean)localObject7).b == 4)) {
            break label714;
          }
          if (((UserInfoBean)localObject7).b != 3) {
            break label692;
          }
          break label714;
        }
        if (i <= 15) {
          break;
        }
        x.d("[UserInfo] Upload user info too many times in 10 min: %d", new Object[] { Integer.valueOf(i) });
        i = 0;
      }
      finally {}
      if (((List)localObject5).size() > 0) {
        a((List)localObject5);
      }
      if ((i == 0) || (((List)localObject1).size() == 0))
      {
        x.c("[UserInfo] There is no user info in local database.", new Object[0]);
        continue;
        localObject3 = new ArrayList();
        i = 1;
      }
      else
      {
        x.c("[UserInfo] Upload user info(size: %d)", new Object[] { Integer.valueOf(((List)localObject3).size()) });
        if (this.c != 1) {
          break label724;
        }
        i = 1;
        label488:
        localObject5 = com.tencent.bugly.proguard.a.a((List)localObject3, i);
        if (localObject5 == null)
        {
          x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
        }
        else
        {
          localObject5 = com.tencent.bugly.proguard.a.a((k)localObject5);
          if (localObject5 == null) {
            x.d("[UserInfo] Failed to encode data.", new Object[0]);
          } else {
            if (!((u)localObject4).b) {
              break label729;
            }
          }
        }
      }
    }
    label679:
    label692:
    label695:
    label702:
    label709:
    label714:
    label718:
    label721:
    label724:
    label729:
    for (int i = 840;; i = 640)
    {
      localObject5 = com.tencent.bugly.proguard.a.a(this.a, i, (byte[])localObject5);
      if (localObject5 == null)
      {
        x.d("[UserInfo] Request package is null.", new Object[0]);
        break;
      }
      localObject6 = new t()
      {
        public final void a(int paramAnonymousInt) {}
        
        public final void a(int paramAnonymousInt, an paramAnonymousan, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          if (paramAnonymousBoolean)
          {
            x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
            paramAnonymousLong1 = System.currentTimeMillis();
            paramAnonymousan = this.a.iterator();
            while (paramAnonymousan.hasNext())
            {
              paramAnonymousString = (UserInfoBean)paramAnonymousan.next();
              paramAnonymousString.f = paramAnonymousLong1;
              a.a(a.this, paramAnonymousString, true);
            }
          }
        }
      };
      localObject3 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
      if (((u)localObject4).b)
      {
        localObject3 = ((StrategyBean)localObject3).q;
        label619:
        if (!((u)localObject4).b) {
          break label679;
        }
      }
      for (localObject4 = StrategyBean.b;; localObject4 = StrategyBean.a)
      {
        localObject7 = u.a();
        if (this.c == 1) {
          bool1 = true;
        }
        ((u)localObject7).a(1001, (am)localObject5, (String)localObject3, (String)localObject4, (t)localObject6, bool1);
        break;
        localObject3 = ((StrategyBean)localObject3).s;
        break label619;
      }
      i = 1;
      break label721;
      break label718;
      j += 1;
      break label126;
      i += 1;
      break label109;
      i = 0;
      break label213;
      i += 1;
      break label252;
      break label390;
      i = 2;
      break label488;
    }
  }
  
  /* Error */
  public final List<UserInfoBean> a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 321	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   4: ifeq +35 -> 39
    //   7: aconst_null
    //   8: astore_1
    //   9: invokestatic 156	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   12: ldc 158
    //   14: aconst_null
    //   15: aload_1
    //   16: aconst_null
    //   17: aconst_null
    //   18: iconst_1
    //   19: invokevirtual 324	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +42 -> 66
    //   27: aload_1
    //   28: ifnull +9 -> 37
    //   31: aload_1
    //   32: invokeinterface 327 1 0
    //   37: aconst_null
    //   38: areturn
    //   39: new 168	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 329
    //   46: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 334
    //   56: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: goto -54 -> 9
    //   66: new 168	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   73: astore 5
    //   75: new 229	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 230	java/util/ArrayList:<init>	()V
    //   82: astore 4
    //   84: aload_1
    //   85: invokeinterface 337 1 0
    //   90: ifeq +127 -> 217
    //   93: aload_1
    //   94: invokestatic 339	com/tencent/bugly/crashreport/biz/a:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/biz/UserInfoBean;
    //   97: astore 6
    //   99: aload 6
    //   101: ifnull +43 -> 144
    //   104: aload 4
    //   106: aload 6
    //   108: invokeinterface 238 2 0
    //   113: pop
    //   114: goto -30 -> 84
    //   117: astore 4
    //   119: aload 4
    //   121: invokestatic 99	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   124: ifne +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 102	java/lang/Throwable:printStackTrace	()V
    //   132: aload_1
    //   133: ifnull +9 -> 142
    //   136: aload_1
    //   137: invokeinterface 327 1 0
    //   142: aconst_null
    //   143: areturn
    //   144: aload_1
    //   145: aload_1
    //   146: ldc 44
    //   148: invokeinterface 109 2 0
    //   153: invokeinterface 117 2 0
    //   158: lstore_2
    //   159: aload 5
    //   161: ldc 175
    //   163: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 181
    //   168: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: lload_2
    //   172: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: goto -92 -> 84
    //   179: astore 6
    //   181: ldc_w 341
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 270	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   191: pop
    //   192: goto -108 -> 84
    //   195: astore 5
    //   197: aload_1
    //   198: astore 4
    //   200: aload 5
    //   202: astore_1
    //   203: aload 4
    //   205: ifnull +10 -> 215
    //   208: aload 4
    //   210: invokeinterface 327 1 0
    //   215: aload_1
    //   216: athrow
    //   217: aload 5
    //   219: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 193	java/lang/String:length	()I
    //   229: ifle +46 -> 275
    //   232: aload 5
    //   234: iconst_4
    //   235: invokevirtual 197	java/lang/String:substring	(I)Ljava/lang/String;
    //   238: astore 5
    //   240: ldc_w 343
    //   243: iconst_2
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: ldc 158
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: invokestatic 156	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   257: ldc 158
    //   259: aload 5
    //   261: aconst_null
    //   262: aconst_null
    //   263: iconst_1
    //   264: invokevirtual 206	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   267: invokestatic 73	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: invokestatic 270	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   274: pop
    //   275: aload_1
    //   276: ifnull +9 -> 285
    //   279: aload_1
    //   280: invokeinterface 327 1 0
    //   285: aload 4
    //   287: areturn
    //   288: astore_1
    //   289: aconst_null
    //   290: astore 4
    //   292: goto -89 -> 203
    //   295: astore 5
    //   297: aload_1
    //   298: astore 4
    //   300: aload 5
    //   302: astore_1
    //   303: goto -100 -> 203
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_1
    //   310: goto -191 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	a
    //   0	313	1	paramString	String
    //   158	14	2	l	long
    //   82	23	4	localArrayList	ArrayList
    //   117	11	4	localThrowable1	Throwable
    //   198	101	4	str1	String
    //   306	1	4	localThrowable2	Throwable
    //   73	87	5	localStringBuilder	StringBuilder
    //   195	23	5	localObject1	Object
    //   222	38	5	str2	String
    //   295	6	5	localObject2	Object
    //   97	10	6	localUserInfoBean	UserInfoBean
    //   179	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   66	84	117	java/lang/Throwable
    //   84	99	117	java/lang/Throwable
    //   104	114	117	java/lang/Throwable
    //   181	192	117	java/lang/Throwable
    //   217	275	117	java/lang/Throwable
    //   144	176	179	java/lang/Throwable
    //   66	84	195	finally
    //   84	99	195	finally
    //   104	114	195	finally
    //   144	176	195	finally
    //   181	192	195	finally
    //   217	275	195	finally
    //   0	7	288	finally
    //   9	23	288	finally
    //   39	63	288	finally
    //   119	132	295	finally
    //   0	7	306	java/lang/Throwable
    //   9	23	306	java/lang/Throwable
    //   39	63	306	java/lang/Throwable
  }
  
  public final void a()
  {
    this.b = (z.b() + 86400000L);
    w.a().a(new b(), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    Object localObject = com.tencent.bugly.crashreport.common.strategy.a.a();
    if ((localObject != null) && (!((com.tencent.bugly.crashreport.common.strategy.a)localObject).c().h) && (paramInt != 1) && (paramInt != 3))
    {
      x.e("UserInfo is disable", new Object[0]);
      return;
    }
    if ((paramInt == 1) || (paramInt == 3)) {
      this.c += 1;
    }
    localObject = com.tencent.bugly.crashreport.common.info.a.a(this.a);
    UserInfoBean localUserInfoBean = new UserInfoBean();
    localUserInfoBean.b = paramInt;
    localUserInfoBean.c = ((com.tencent.bugly.crashreport.common.info.a)localObject).d;
    localUserInfoBean.d = ((com.tencent.bugly.crashreport.common.info.a)localObject).f();
    localUserInfoBean.e = System.currentTimeMillis();
    localUserInfoBean.f = -1L;
    localUserInfoBean.n = ((com.tencent.bugly.crashreport.common.info.a)localObject).l;
    if (paramInt == 1) {}
    for (paramInt = i;; paramInt = 0)
    {
      localUserInfoBean.o = paramInt;
      localUserInfoBean.l = ((com.tencent.bugly.crashreport.common.info.a)localObject).a();
      localUserInfoBean.m = ((com.tencent.bugly.crashreport.common.info.a)localObject).r;
      localUserInfoBean.g = ((com.tencent.bugly.crashreport.common.info.a)localObject).s;
      localUserInfoBean.h = ((com.tencent.bugly.crashreport.common.info.a)localObject).t;
      localUserInfoBean.i = ((com.tencent.bugly.crashreport.common.info.a)localObject).u;
      localUserInfoBean.k = ((com.tencent.bugly.crashreport.common.info.a)localObject).v;
      localUserInfoBean.r = ((com.tencent.bugly.crashreport.common.info.a)localObject).A();
      localUserInfoBean.s = ((com.tencent.bugly.crashreport.common.info.a)localObject).F();
      localUserInfoBean.p = ((com.tencent.bugly.crashreport.common.info.a)localObject).G();
      localUserInfoBean.q = ((com.tencent.bugly.crashreport.common.info.a)localObject).H();
      w.a().a(new a(localUserInfoBean, paramBoolean), 0L);
      return;
    }
  }
  
  public final void b()
  {
    w localw = w.a();
    if (localw != null) {
      localw.a(new Runnable()
      {
        public final void run()
        {
          try
          {
            a.a(a.this);
            return;
          }
          catch (Throwable localThrowable)
          {
            x.a(localThrowable);
          }
        }
      });
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean a;
    private UserInfoBean b;
    
    public a(UserInfoBean paramUserInfoBean, boolean paramBoolean)
    {
      this.b = paramUserInfoBean;
      this.a = paramBoolean;
    }
    
    public final void run()
    {
      try
      {
        Object localObject1;
        Object localObject2;
        if (this.b != null)
        {
          localObject1 = this.b;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.bugly.crashreport.common.info.a.b();
            if (localObject2 != null) {
              ((UserInfoBean)localObject1).j = ((com.tencent.bugly.crashreport.common.info.a)localObject2).d();
            }
          }
          x.c("[UserInfo] Record user info.", new Object[0]);
          a.a(a.this, this.b, false);
        }
        if (this.a)
        {
          localObject1 = a.this;
          localObject2 = w.a();
          if (localObject2 != null) {
            ((w)localObject2).a(new a.2((a)localObject1));
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        while (x.a(localThrowable)) {}
        localThrowable.printStackTrace();
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      if (l < a.b(a.this))
      {
        w.a().a(new b(a.this), a.b(a.this) - l + 5000L);
        return;
      }
      a.this.a(3, false, 0L);
      a.this.a();
    }
  }
  
  final class c
    implements Runnable
  {
    private long a = 21600000L;
    
    public c(long paramLong)
    {
      this.a = paramLong;
    }
    
    public final void run()
    {
      a locala = a.this;
      w localw = w.a();
      if (localw != null) {
        localw.a(new a.2(locala));
      }
      locala = a.this;
      long l = this.a;
      w.a().a(new c(locala, l), l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.a
 * JD-Core Version:    0.7.0.1
 */