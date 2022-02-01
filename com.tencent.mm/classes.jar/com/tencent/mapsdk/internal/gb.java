package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class gb
{
  private static final String h = "stData";
  public int a;
  public List<gq> b;
  String c;
  String d;
  String e;
  File f;
  volatile boolean g;
  private String i;
  private File j;
  private boolean k;
  private gb.d l;
  
  public gb(bm parambm)
  {
    this(parambm, (byte)0);
  }
  
  private gb(bm parambm, byte paramByte)
  {
    AppMethodBeat.i(225602);
    this.k = true;
    this.b = new ArrayList();
    this.c = parambm.u().a;
    this.d = "";
    this.e = "";
    if (parambm.a != null)
    {
      this.d = parambm.a.getSubKey();
      this.e = parambm.a.getSubId();
    }
    this.i = (parambm.getContext().getFilesDir().getAbsolutePath() + File.separator + "stData_" + Util.getMD5String(this.c));
    ka.a(this.i);
    this.f = new File(this.i);
    this.j = new File(this.i + ".temp");
    AppMethodBeat.o(225602);
  }
  
  public static gq a(long paramLong)
  {
    AppMethodBeat.i(225701);
    e.a(c.a).e = Long.valueOf(paramLong);
    gq localgq = new gq(paramLong);
    AppMethodBeat.o(225701);
    return localgq;
  }
  
  private String a()
  {
    return this.i;
  }
  
  private static List<gq> a(File paramFile)
  {
    AppMethodBeat.i(225628);
    ArrayList localArrayList = new ArrayList();
    paramFile = ka.d(paramFile);
    if ((paramFile != null) && (!paramFile.isEmpty()))
    {
      Iterator localIterator = paramFile.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramFile = (String)localIterator.next();
          try
          {
            paramFile = JsonUtils.parseToList(new JSONArray(paramFile), gq.class, new Object[0]);
            if (paramFile != null) {
              localArrayList.addAll(paramFile);
            }
          }
          catch (JSONException paramFile)
          {
            for (;;)
            {
              paramFile = null;
            }
          }
        }
      }
    }
    AppMethodBeat.o(225628);
    return localArrayList;
  }
  
  private void a(final a<byte[]> parama)
  {
    AppMethodBeat.i(225619);
    a(new Runnable()
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(222681);
        Object localObject = gb.e.a(gb.c.b);
        ((gb.e)localObject).a = gb.b.a;
        ((gb.e)localObject).e = gb.this.f;
        if (!gb.this.f.exists())
        {
          localObject = gb.e.a(gb.c.b);
          ((gb.e)localObject).a = gb.b.c;
          ((gb.e)localObject).e = gb.this.f;
          ((gb.e)localObject).c = false;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(222681);
          return;
        }
        localObject = gb.e.a(gb.c.b);
        ((gb.e)localObject).a = gb.b.b;
        ((gb.e)localObject).e = gb.this.f;
        localObject = ka.c(gb.this.f);
        gb.e locale = gb.e.a(gb.c.b);
        locale.a = gb.b.c;
        locale.e = gb.this.f;
        if (localObject != null) {
          bool = true;
        }
        locale.c = bool;
        if (parama != null) {
          parama.a(localObject);
        }
        AppMethodBeat.o(222681);
      }
    });
    AppMethodBeat.o(225619);
  }
  
  private void a(gb.d paramd)
  {
    this.l = paramd;
  }
  
  private void a(gq paramgq)
  {
    AppMethodBeat.i(225686);
    this.a -= 1;
    if (paramgq != null) {}
    try
    {
      this.b.add(paramgq);
      if (this.a != 0)
      {
        AppMethodBeat.o(225686);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(225686);
    }
    if (this.b.isEmpty())
    {
      AppMethodBeat.o(225686);
      return;
    }
    a(a(this.b, null), new a()
    {
      private void a(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(222624);
        gb.a(gb.this, paramAnonymousBoolean.booleanValue());
        if (paramAnonymousBoolean.booleanValue()) {
          gb.this.b.clear();
        }
        AppMethodBeat.o(222624);
      }
    });
    AppMethodBeat.o(225686);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225663);
    e.a(c.d).a = gb.b.a;
    Object localObject1 = ka.c(this.j);
    e locale = e.a(c.d);
    locale.a = gb.b.b;
    locale.c = paramBoolean;
    locale.d = ((byte[])localObject1);
    locale.e = this.j;
    if (paramBoolean)
    {
      ka.b(this.f);
      if ((localObject1 != null) && (localObject1.length > 0)) {
        ka.a(this.j, this.f);
      }
    }
    for (;;)
    {
      e.a(c.d).a = gb.b.c;
      AppMethodBeat.o(225663);
      return;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = new ArrayList();
        Object localObject2 = a(this.f);
        List localList = a(this.j);
        ((List)localObject1).addAll((Collection)localObject2);
        ((List)localObject1).addAll(localList);
        ka.b(this.f);
        ka.b(this.j);
        localObject1 = a((List)localObject1, locale);
        localObject2 = e.a(c.e);
        ((e)localObject2).a = gb.b.a;
        ((e)localObject2).b = locale;
        ((e)localObject2).d = ((byte[])localObject1);
        ((e)localObject2).e = this.f;
        paramBoolean = ka.a(this.f, (byte[])localObject1);
        localObject1 = e.a(c.e);
        ((e)localObject1).a = gb.b.c;
        ((e)localObject1).b = locale;
        ((e)localObject1).c = paramBoolean;
      }
    }
  }
  
  public static byte[] a(List<gq> paramList, e parame)
  {
    e locale = null;
    boolean bool = false;
    AppMethodBeat.i(225640);
    Object localObject = e.a(c.f);
    ((e)localObject).a = gb.b.a;
    ((e)localObject).b = parame;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = e.a(c.f);
      paramList.a = gb.b.c;
      paramList.b = parame;
      paramList.c = false;
      AppMethodBeat.o(225640);
      return null;
    }
    localObject = e.a(c.f);
    ((e)localObject).a = gb.b.b;
    ((e)localObject).e = paramList;
    ((e)localObject).b = parame;
    localObject = JsonUtils.collectionToJson(new ArrayList(paramList));
    paramList = locale;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      paramList = ((String)localObject).getBytes("UTF-8");
      locale = e.a(c.f);
      locale.a = gb.b.c;
      locale.d = paramList;
      locale.e = localObject;
      locale.b = parame;
      if (paramList != null) {
        bool = true;
      }
      locale.c = bool;
      AppMethodBeat.o(225640);
      return paramList;
    }
    catch (UnsupportedEncodingException paramList)
    {
      for (;;)
      {
        paramList = ((String)localObject).getBytes();
      }
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(225650);
    a(new Runnable()
    {
      private void a(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(222662);
        if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
          gb.this.a(paramAnonymousArrayOfByte, new gb.a()
          {
            private void a(Boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(223552);
              gb.a(gb.this, paramAnonymous2Boolean.booleanValue());
              AppMethodBeat.o(223552);
            }
          });
        }
        AppMethodBeat.o(222662);
      }
    }
    {
      public final void run()
      {
        boolean bool = false;
        AppMethodBeat.i(222681);
        Object localObject = gb.e.a(gb.c.b);
        ((gb.e)localObject).a = gb.b.a;
        ((gb.e)localObject).e = gb.this.f;
        if (!gb.this.f.exists())
        {
          localObject = gb.e.a(gb.c.b);
          ((gb.e)localObject).a = gb.b.c;
          ((gb.e)localObject).e = gb.this.f;
          ((gb.e)localObject).c = false;
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(222681);
          return;
        }
        localObject = gb.e.a(gb.c.b);
        ((gb.e)localObject).a = gb.b.b;
        ((gb.e)localObject).e = gb.this.f;
        localObject = ka.c(gb.this.f);
        gb.e locale = gb.e.a(gb.c.b);
        locale.a = gb.b.c;
        locale.e = gb.this.f;
        if (localObject != null) {
          bool = true;
        }
        locale.c = bool;
        if (parama != null) {
          parama.a(localObject);
        }
        AppMethodBeat.o(222681);
      }
    });
    AppMethodBeat.o(225650);
  }
  
  private void c()
  {
    AppMethodBeat.i(225671);
    if (this.a == 0) {
      a(new Runnable()
      {
        private void a(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(222662);
          if ((paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0)) {
            gb.this.a(paramAnonymousArrayOfByte, new gb.a()
            {
              private void a(Boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(223552);
                gb.a(gb.this, paramAnonymous2Boolean.booleanValue());
                AppMethodBeat.o(223552);
              }
            });
          }
          AppMethodBeat.o(222662);
        }
      }
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(222681);
          Object localObject = gb.e.a(gb.c.b);
          ((gb.e)localObject).a = gb.b.a;
          ((gb.e)localObject).e = gb.this.f;
          if (!gb.this.f.exists())
          {
            localObject = gb.e.a(gb.c.b);
            ((gb.e)localObject).a = gb.b.c;
            ((gb.e)localObject).e = gb.this.f;
            ((gb.e)localObject).c = false;
            if (parama != null) {
              parama.a(null);
            }
            AppMethodBeat.o(222681);
            return;
          }
          localObject = gb.e.a(gb.c.b);
          ((gb.e)localObject).a = gb.b.b;
          ((gb.e)localObject).e = gb.this.f;
          localObject = ka.c(gb.this.f);
          gb.e locale = gb.e.a(gb.c.b);
          locale.a = gb.b.c;
          locale.e = gb.this.f;
          if (localObject != null) {
            bool = true;
          }
          locale.c = bool;
          if (parama != null) {
            parama.a(localObject);
          }
          AppMethodBeat.o(222681);
        }
      });
    }
    this.a += 1;
    AppMethodBeat.o(225671);
  }
  
  private static gq d()
  {
    AppMethodBeat.i(225695);
    gq localgq = a(System.currentTimeMillis());
    AppMethodBeat.o(225695);
    return localgq;
  }
  
  public final void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(225775);
    if (this.g)
    {
      AppMethodBeat.o(225775);
      return;
    }
    if (this.k)
    {
      new Thread(paramRunnable).start();
      AppMethodBeat.o(225775);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(225775);
  }
  
  public final void a(final byte[] paramArrayOfByte, final a<Boolean> parama)
  {
    AppMethodBeat.i(225784);
    a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222668);
        Object localObject = gb.e.a(gb.c.c);
        ((gb.e)localObject).d = paramArrayOfByte;
        ((gb.e)localObject).a = gb.b.a;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          if (parama != null) {
            parama.a(Boolean.FALSE);
          }
          localObject = gb.e.a(gb.c.c);
          ((gb.e)localObject).d = null;
          ((gb.e)localObject).c = false;
          ((gb.e)localObject).a = gb.b.c;
          AppMethodBeat.o(222668);
          return;
        }
        gb.this.g = true;
        try
        {
          gb.e.a(gb.c.c).a = gb.b.b;
          localObject = ((da)((do)cj.a(do.class)).h()).report(gb.this.c, gb.this.d, gw.k(), gb.this.e, gw.g(), gw.d(), gw.i(), gw.j(), gw.l(), gw.c(), gw.f(), paramArrayOfByte);
          if (localObject == null) {
            break label303;
          }
          kh.a("Post statistic data with response:" + new String(((NetResponse)localObject).data, ((NetResponse)localObject).charset));
          bool = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            kh.c("err:" + localException.getMessage());
            boolean bool = false;
          }
        }
        localObject = gb.e.a(gb.c.c);
        ((gb.e)localObject).d = paramArrayOfByte;
        ((gb.e)localObject).a = gb.b.c;
        ((gb.e)localObject).c = bool;
        if (parama != null) {
          parama.a(Boolean.valueOf(bool));
        }
        gb.this.g = false;
        AppMethodBeat.o(222668);
      }
    });
    AppMethodBeat.o(225784);
  }
  
  static abstract interface a<T>
  {
    public abstract void a(T paramT);
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(221783);
      a = new c("CREATE", 0);
      b = new c("READ", 1);
      c = new c("UPLOAD", 2);
      d = new c("UPLOAD_END", 3);
      e = new c("WRITE", 4);
      f = new c("TRANSLATE_BYTE", 5);
      g = new c[] { a, b, c, d, e, f };
      AppMethodBeat.o(221783);
    }
    
    private c() {}
  }
  
  public static final class e
  {
    gb.b a;
    e b;
    boolean c;
    byte[] d;
    public Object e;
    private gb.c f;
    
    private e a()
    {
      return this;
    }
    
    private e a(gb.b paramb)
    {
      this.a = paramb;
      return this;
    }
    
    public static e a(gb.c paramc)
    {
      AppMethodBeat.i(221762);
      e locale = new e();
      locale.f = paramc;
      AppMethodBeat.o(221762);
      return locale;
    }
    
    private e a(e parame)
    {
      this.b = parame;
      return this;
    }
    
    private e a(Object paramObject)
    {
      this.e = paramObject;
      return this;
    }
    
    private e a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }
    
    private e a(byte[] paramArrayOfByte)
    {
      this.d = paramArrayOfByte;
      return this;
    }
    
    private boolean a(gb.c paramc, gb.b paramb)
    {
      return (paramb == this.a) && (paramc == this.f);
    }
    
    private gb.c b()
    {
      return this.f;
    }
    
    private boolean b(gb.c paramc)
    {
      return paramc == this.f;
    }
    
    private boolean b(gb.c paramc, gb.b paramb)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.b != null)
      {
        e locale = this.b;
        bool1 = bool2;
        if (paramb == locale.a)
        {
          bool1 = bool2;
          if (paramc == locale.f) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    private boolean c(gb.c paramc)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.b != null)
      {
        bool1 = bool2;
        if (paramc == this.b.f) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    private byte[] c()
    {
      return this.d;
    }
    
    private boolean d()
    {
      return this.c;
    }
    
    private Object e()
    {
      return this.e;
    }
    
    private gb.b f()
    {
      return this.a;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221866);
      StringBuffer localStringBuffer = new StringBuffer("StatisticState{");
      localStringBuffer.append("mState=").append(this.f);
      localStringBuffer.append(", mStage=").append(this.a);
      localStringBuffer.append(", mParentState=").append(this.b);
      localStringBuffer.append(", mResult=").append(this.c);
      localStringBuffer.append(", mData=");
      if (this.d == null) {
        localStringBuffer.append("null");
      }
      for (;;)
      {
        localStringBuffer.append(", mTag=").append(this.e);
        localStringBuffer.append('}');
        String str = localStringBuffer.toString();
        AppMethodBeat.o(221866);
        return str;
        localStringBuffer.append('[');
        int i = 0;
        if (i < this.d.length)
        {
          if (i == 0) {}
          for (str = "";; str = ", ")
          {
            localStringBuffer.append(str).append(this.d[i]);
            i += 1;
            break;
          }
        }
        localStringBuffer.append(']');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gb
 * JD-Core Version:    0.7.0.1
 */