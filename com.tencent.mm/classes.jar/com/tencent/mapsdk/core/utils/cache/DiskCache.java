package com.tencent.mapsdk.core.utils.cache;

import android.text.TextUtils;
import com.tencent.mapsdk.internal.jg.b;
import com.tencent.mapsdk.internal.jh;
import com.tencent.mapsdk.internal.ji.a;
import com.tencent.mapsdk.internal.jm;
import com.tencent.mapsdk.internal.jm.a;
import com.tencent.mapsdk.internal.jm.b;
import com.tencent.mapsdk.internal.jm.c;
import com.tencent.mapsdk.internal.ka;
import com.tencent.mapsdk.internal.kl;
import com.tencent.mapsdk.internal.kl.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DiskCache<D extends jh>
  extends jm<D>
{
  private static final String a = "DiskCache";
  private static final String b = ".disk_idx";
  private static final String c = ".disk_idx_root";
  private static final a k;
  private ji.a<DiskCache.b> d;
  private c e;
  private File f;
  private File g;
  private Map<String, String> h;
  private List<String> i;
  private boolean j;
  
  static
  {
    AppMethodBeat.i(221193);
    k = new DiskCache.1();
    AppMethodBeat.o(221193);
  }
  
  public DiskCache(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(221136);
    this.e = paramc;
    if (this.e != null)
    {
      this.f = ka.a(this.e.c, this.e.d);
      if (this.e.j == -1) {}
      for (boolean bool = true;; bool = false)
      {
        this.j = bool;
        if (!this.j) {
          this.d = new ji.a(this.e.j, this.e.g);
        }
        this.g = ka.b(this.f, ".disk_idx_root");
        this.i = new ArrayList();
        this.h = new HashMap();
        paramc = ka.d(this.g);
        if (paramc == null) {
          break;
        }
        paramc = paramc.iterator();
        while (paramc.hasNext())
        {
          Object localObject = (String)paramc.next();
          if (((String)localObject).length() > 0)
          {
            localObject = ((String)localObject).split("#");
            if (localObject.length > 1)
            {
              String[] arrayOfString = localObject[1].split(",");
              int n = arrayOfString.length;
              int m = 0;
              while (m < n)
              {
                String str = arrayOfString[m];
                this.h.put(str, localObject[0]);
                m += 1;
              }
            }
          }
        }
      }
      kl.a(new Object[] { "loadRootIndex count:" + this.h.size(), "disk_cache_dir:" + this.f });
    }
    AppMethodBeat.o(221136);
  }
  
  private void a(String paramString, DiskCache.b paramb)
  {
    AppMethodBeat.i(221162);
    if (paramb.a == null)
    {
      AppMethodBeat.o(221162);
      return;
    }
    File localFile = paramb.a.getParentFile();
    Object localObject = ka.b(localFile, ".disk_idx");
    paramb = paramString + "#" + paramb.toString();
    if (ka.d((File)localObject, paramb) == -1)
    {
      kl.f("DiskCache").a(new Object[] { "index writeLine data:".concat(String.valueOf(paramb)) });
      ka.c((File)localObject, paramb);
    }
    int m = ka.d(this.g, localFile.getAbsolutePath());
    if (m != -1)
    {
      paramb = ",".concat(String.valueOf(paramString));
      localObject = ka.a(this.g, m);
      if ((localObject != null) && (!((String)localObject).contains(paramString)))
      {
        kl.f("DiskCache").a(new Object[] { "root writeAppend data:".concat(String.valueOf(paramb)) });
        ka.a(this.g, m, ",".concat(String.valueOf(paramString)));
      }
    }
    for (;;)
    {
      this.h.put(paramString, localFile.getAbsolutePath());
      AppMethodBeat.o(221162);
      return;
      paramb = localFile.getAbsolutePath() + "#" + paramString;
      kl.f("DiskCache").a(new Object[] { "root writeLine data:".concat(String.valueOf(paramb)) });
      ka.c(this.g, paramb);
    }
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(221174);
    String str1 = (String)this.h.get(paramString);
    if ((str1 != null) && (!this.i.contains(str1)))
    {
      kl.f("DiskCache").a(new Object[] { "key：".concat(String.valueOf(paramString)), "dir : ".concat(String.valueOf(str1)) });
      paramString = ka.d(ka.b(new File(str1), ".disk_idx"));
      if ((paramString == null) || (paramString.isEmpty()))
      {
        AppMethodBeat.o(221174);
        return;
      }
      kl.f("DiskCache").a(paramString.toArray());
      if (this.d != null)
      {
        Iterator localIterator = paramString.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = ((String)localIterator.next()).split("#");
          String[] arrayOfString = localObject[1].split(",");
          localObject = localObject[0];
          String str2 = arrayOfString[0];
          int m = Integer.parseInt(arrayOfString[1]);
          this.d.a(localObject, new DiskCache.b(new File(str1, str2), m));
        }
      }
      if (paramString.size() > 0) {
        this.i.add(str1);
      }
    }
    AppMethodBeat.o(221174);
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(221182);
    String str = (String)this.h.get(paramString);
    if (str != null)
    {
      kl.f("DiskCache").a(new Object[] { "key：".concat(String.valueOf(paramString)), "dir : ".concat(String.valueOf(str)) });
      File localFile = new File(new File(str), ".disk_idx");
      int m = ka.d(localFile, paramString);
      if (m != -1) {
        ka.b(localFile, m);
      }
      m = ka.d(this.g, str);
      if (m != -1)
      {
        str = ka.a(this.g, m);
        if ((str != null) && (str.contains(paramString)))
        {
          paramString = str.replaceAll(paramString + ",", "");
          ka.b(this.g, m, paramString);
        }
      }
    }
    AppMethodBeat.o(221182);
  }
  
  private c n()
  {
    return this.e;
  }
  
  private void o()
  {
    AppMethodBeat.i(221150);
    this.g = ka.b(this.f, ".disk_idx_root");
    this.i = new ArrayList();
    this.h = new HashMap();
    Object localObject1 = ka.d(this.g);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).length() > 0)
        {
          localObject2 = ((String)localObject2).split("#");
          if (localObject2.length > 1)
          {
            String[] arrayOfString = localObject2[1].split(",");
            int n = arrayOfString.length;
            int m = 0;
            while (m < n)
            {
              String str = arrayOfString[m];
              this.h.put(str, localObject2[0]);
              m += 1;
            }
          }
        }
      }
    }
    kl.a(new Object[] { "loadRootIndex count:" + this.h.size(), "disk_cache_dir:" + this.f });
    AppMethodBeat.o(221150);
  }
  
  public final D a(String paramString, Class<D> paramClass)
  {
    AppMethodBeat.i(221213);
    Object localObject2 = this.e.k.a(paramString);
    if ((!this.j) || (this.e.f != -1L))
    {
      c((String)localObject2);
      if (!this.j)
      {
        localObject1 = (DiskCache.b)this.d.b(localObject2);
        if (localObject1 == null) {}
      }
    }
    for (Object localObject1 = ((DiskCache.b)localObject1).a;; localObject1 = null)
    {
      localObject2 = this.e.e.a((String)localObject2, (File)localObject1);
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          localObject1 = (jh)paramClass.newInstance();
          ((jh)localObject1).a((byte[])localObject2);
          paramClass = (Class<D>)localObject1;
          if (localObject2 == null)
          {
            m = 0;
            kl.a("DC", paramString, "get data length", Integer.valueOf(m));
            kl.f("DC", paramString);
            AppMethodBeat.o(221213);
            return paramClass;
          }
        }
        catch (IllegalAccessException paramString)
        {
          paramString = new Error("The " + paramClass.getSimpleName() + " must have a empty construct. #" + paramString.getMessage(), paramString);
          AppMethodBeat.o(221213);
          throw paramString;
        }
        catch (InstantiationException paramString)
        {
          paramString = new Error("The " + paramClass.getSimpleName() + " must have a empty construct. #" + paramString.getMessage(), paramString);
          AppMethodBeat.o(221213);
          throw paramString;
        }
        int m = localObject2.length;
        continue;
        paramClass = null;
      }
    }
  }
  
  public final void a(String paramString, D paramD)
  {
    int m = 0;
    AppMethodBeat.i(221205);
    if ((TextUtils.isEmpty(paramString)) || (paramD == null))
    {
      AppMethodBeat.o(221205);
      return;
    }
    kl.b("DC", paramString);
    String str = this.e.k.a(paramString);
    paramD = paramD.b();
    File localFile;
    Object localObject1;
    if (paramD != null)
    {
      localFile = this.e.e.a(str, this.f.getAbsolutePath(), paramD);
      if ((!this.j) || (this.e.f != -1L))
      {
        Object localObject2 = new DiskCache.b(localFile, paramD.length);
        if (!this.j) {
          this.d.a(str, localObject2);
        }
        if (((DiskCache.b)localObject2).a != null)
        {
          localFile = ((DiskCache.b)localObject2).a.getParentFile();
          localObject1 = ka.b(localFile, ".disk_idx");
          localObject2 = str + "#" + ((DiskCache.b)localObject2).toString();
          if (ka.d((File)localObject1, (String)localObject2) == -1)
          {
            kl.f("DiskCache").a(new Object[] { "index writeLine data:".concat(String.valueOf(localObject2)) });
            ka.c((File)localObject1, (String)localObject2);
          }
          int n = ka.d(this.g, localFile.getAbsolutePath());
          if (n == -1) {
            break label378;
          }
          localObject1 = ",".concat(String.valueOf(str));
          localObject2 = ka.a(this.g, n);
          if ((localObject2 != null) && (!((String)localObject2).contains(str)))
          {
            kl.f("DiskCache").a(new Object[] { "root writeAppend data:".concat(String.valueOf(localObject1)) });
            ka.a(this.g, n, ",".concat(String.valueOf(str)));
          }
          this.h.put(str, localFile.getAbsolutePath());
        }
      }
    }
    if (paramD == null) {}
    for (;;)
    {
      kl.a("DC", paramString, "put data length", Integer.valueOf(m));
      AppMethodBeat.o(221205);
      return;
      label378:
      localObject1 = localFile.getAbsolutePath() + "#" + str;
      kl.f("DiskCache").a(new Object[] { "root writeLine data:".concat(String.valueOf(localObject1)) });
      ka.c(this.g, (String)localObject1);
      break;
      m = paramD.length;
    }
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(221222);
    String str = this.e.k.a(paramString);
    paramString = null;
    Object localObject = null;
    if ((!this.j) || (this.e.f != -1L))
    {
      c(str);
      if (!this.j)
      {
        paramString = (DiskCache.b)this.d.b(str);
        if (paramString != null) {
          localObject = paramString.a;
        }
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((File)localObject).exists())
          {
            this.d.c(str);
            paramString = (String)localObject;
          }
        }
      }
      if ((paramString != null) && (paramString.exists()))
      {
        localObject = (String)this.h.get(str);
        if (localObject != null)
        {
          kl.f("DiskCache").a(new Object[] { "key：".concat(String.valueOf(str)), "dir : ".concat(String.valueOf(localObject)) });
          File localFile = new File(new File((String)localObject), ".disk_idx");
          int m = ka.d(localFile, str);
          if (m != -1) {
            ka.b(localFile, m);
          }
          m = ka.d(this.g, (String)localObject);
          if (m != -1)
          {
            localObject = ka.a(this.g, m);
            if ((localObject != null) && (((String)localObject).contains(str)))
            {
              localObject = ((String)localObject).replaceAll(str + ",", "");
              ka.b(this.g, m, (String)localObject);
            }
          }
        }
      }
    }
    for (;;)
    {
      boolean bool = this.e.e.a(paramString);
      AppMethodBeat.o(221222);
      return bool;
      paramString = null;
    }
  }
  
  public final void b()
  {
    AppMethodBeat.i(221229);
    if (this.f != null)
    {
      if (this.j)
      {
        this.e.e.a(this.f);
        AppMethodBeat.o(221229);
        return;
      }
      this.d.a();
      this.e.e.a(this.f);
    }
    AppMethodBeat.o(221229);
  }
  
  public final long c()
  {
    AppMethodBeat.i(221247);
    if (this.j)
    {
      if ((this.e != null) && (this.e.f != -1L))
      {
        l = this.h.size();
        AppMethodBeat.o(221247);
        return l;
      }
      AppMethodBeat.o(221247);
      return -1L;
    }
    long l = this.d.d().size();
    AppMethodBeat.o(221247);
    return l;
  }
  
  public final long d()
  {
    AppMethodBeat.i(221253);
    if (this.j)
    {
      AppMethodBeat.o(221253);
      return -1L;
    }
    long l = this.d.b();
    AppMethodBeat.o(221253);
    return l;
  }
  
  public final long e()
  {
    AppMethodBeat.i(221259);
    if (this.j)
    {
      AppMethodBeat.o(221259);
      return -1L;
    }
    long l = this.d.c();
    AppMethodBeat.o(221259);
    return l;
  }
  
  public final void f()
  {
    AppMethodBeat.i(221236);
    if ((this.e != null) && (this.e.f != -1L) && (this.h.size() > this.e.f))
    {
      kl.a(new Object[] { "cached tile count:" + this.h.size() });
      new StringBuilder("cached tile count:").append(this.h.size());
      b();
    }
    AppMethodBeat.o(221236);
  }
  
  public static abstract interface a
  {
    public abstract File a(String paramString1, String paramString2, byte[] paramArrayOfByte);
    
    public abstract boolean a(File paramFile);
    
    public abstract byte[] a(String paramString, File paramFile);
  }
  
  public static final class c
    extends jm.c
  {
    static final long b = -1L;
    public File c;
    public String d;
    public DiskCache.a e;
    long f;
    final jg.b<DiskCache.b> g;
    jg.b<File> h;
    
    public c()
    {
      super();
      AppMethodBeat.i(221133);
      this.c = ka.d;
      this.d = "tmp";
      this.e = DiskCache.h();
      this.f = -1L;
      this.g = new jg.b()
      {
        private boolean a(DiskCache.b paramAnonymousb)
        {
          AppMethodBeat.i(221132);
          boolean bool1 = false;
          boolean bool2 = false;
          if (paramAnonymousb != null)
          {
            if (DiskCache.c.this.h != null) {
              bool2 = DiskCache.c.this.h.a(paramAnonymousb.a);
            }
            bool1 = bool2;
            if (!bool2)
            {
              ka.b(paramAnonymousb.a);
              bool1 = true;
            }
          }
          AppMethodBeat.o(221132);
          return bool1;
        }
      };
      AppMethodBeat.o(221133);
    }
    
    private c(String paramString)
    {
      super();
      AppMethodBeat.i(221142);
      this.c = ka.d;
      this.d = "tmp";
      this.e = DiskCache.h();
      this.f = -1L;
      this.g = new jg.b()
      {
        private boolean a(DiskCache.b paramAnonymousb)
        {
          AppMethodBeat.i(221132);
          boolean bool1 = false;
          boolean bool2 = false;
          if (paramAnonymousb != null)
          {
            if (DiskCache.c.this.h != null) {
              bool2 = DiskCache.c.this.h.a(paramAnonymousb.a);
            }
            bool1 = bool2;
            if (!bool2)
            {
              ka.b(paramAnonymousb.a);
              bool1 = true;
            }
          }
          AppMethodBeat.o(221132);
          return bool1;
        }
      };
      this.d = paramString;
      AppMethodBeat.o(221142);
    }
    
    private c a(DiskCache.a parama)
    {
      this.e = parama;
      return this;
    }
    
    private c a(jg.b<File> paramb)
    {
      this.h = paramb;
      return this;
    }
    
    private c a(File paramFile)
    {
      this.c = paramFile;
      return this;
    }
    
    private c a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    private File c()
    {
      AppMethodBeat.i(221175);
      File localFile = new File(this.c, this.d);
      AppMethodBeat.o(221175);
      return localFile;
    }
    
    public final c b()
    {
      this.f = 1024L;
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221221);
      String str = "Options{mCacheDirectory=" + this.c + ", mCacheName='" + this.d + '\'' + ", fileAccessStrategy=" + this.e + "} " + super.toString();
      AppMethodBeat.o(221221);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.utils.cache.DiskCache
 * JD-Core Version:    0.7.0.1
 */