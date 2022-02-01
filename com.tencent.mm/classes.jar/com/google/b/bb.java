package com.google.b;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class bb
  extends a
  implements Serializable
{
  public static boolean bXS = false;
  public da bVW;
  
  protected bb()
  {
    this.bVW = da.Jk();
  }
  
  protected bb(a<?> parama)
  {
    this.bVW = parama.bVW;
  }
  
  protected static be.d HY()
  {
    return bd.Il();
  }
  
  protected static be.d a(be.d paramd)
  {
    int i = paramd.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramd.hw(i);
      i *= 2;
    }
  }
  
  private static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  protected static void a(i parami, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      parami.f(paramInt, (String)paramObject);
      return;
    }
    parami.a(paramInt, (g)paramObject);
  }
  
  protected static int ao(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return i.cv((String)paramObject);
    }
    return i.b((g)paramObject);
  }
  
  private static Method b(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      throw new RuntimeException("Generated message class \"" + paramClass.getName() + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  private Map<aj.f, Object> bR(boolean paramBoolean)
  {
    TreeMap localTreeMap = new TreeMap();
    List localList = Cb().bPJ.getFields();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject1 = (aj.f)localList.get(i);
      Object localObject2 = ((aj.f)localObject1).bUT;
      int k;
      label103:
      int j;
      if (localObject2 != null)
      {
        i += ((aj.j)localObject2).bVQ - 1;
        if (((be.a)a(Cb().e((aj.j)localObject2).bYy, this, new Object[0])).getNumber() == 0)
        {
          k = 0;
          j = i;
          if (k != 0)
          {
            localObject1 = Cb().e((aj.j)localObject2);
            j = ((be.a)a(((bb.e.c)localObject1).bYy, this, new Object[0])).getNumber();
            if (j <= 0) {
              break label214;
            }
            localObject1 = ((bb.e.c)localObject1).bPJ.hr(j);
            label158:
            if ((!paramBoolean) || (((aj.f)localObject1).bUR.bVz != aj.f.a.bVb)) {
              break label280;
            }
            localTreeMap.put(localObject1, Cb().i((aj.f)localObject1).c(this));
            j = i;
          }
        }
      }
      for (;;)
      {
        i = j + 1;
        break;
        k = 1;
        break label103;
        label214:
        localObject1 = null;
        break label158;
        if (((aj.f)localObject1).Hp())
        {
          localObject2 = (List)f((aj.f)localObject1);
          j = i;
          if (!((List)localObject2).isEmpty())
          {
            localTreeMap.put(localObject1, localObject2);
            j = i;
          }
        }
        else
        {
          j = i;
          if (e((aj.f)localObject1))
          {
            break label158;
            label280:
            localTreeMap.put(localObject1, f((aj.f)localObject1));
            j = i;
          }
        }
      }
    }
    return localTreeMap;
  }
  
  protected static int f(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return i.g(paramInt, (String)paramObject);
    }
    return i.c(paramInt, (g)paramObject);
  }
  
  public int Ad()
  {
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    this.bOZ = ca.a(this, HX());
    return this.bOZ;
  }
  
  public da Ca()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected abstract e Cb();
  
  public ci<? extends bb> Co()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public final aj.a Cv()
  {
    return Cb().bPJ;
  }
  
  Map<aj.f, Object> HX()
  {
    return Collections.unmodifiableMap(bR(true));
  }
  
  protected void HZ() {}
  
  public Map<aj.f, Object> Hz()
  {
    return Collections.unmodifiableMap(bR(false));
  }
  
  protected final bn Ia()
  {
    throw new RuntimeException("No map fields found in " + getClass().getName());
  }
  
  protected final bt.a a(final a.b paramb)
  {
    a(new b()
    {
      public final void Ai()
      {
        paramb.Ai();
      }
    });
  }
  
  protected abstract bt.a a(b paramb);
  
  public void a(i parami)
  {
    ca.a(this, HX(), parami);
  }
  
  protected boolean a(h paramh, da.a parama, ap paramap, int paramInt)
  {
    if (paramh.bPq) {
      return paramh.gz(paramInt);
    }
    return parama.a(paramInt, paramh);
  }
  
  public boolean e(aj.f paramf)
  {
    return Cb().i(paramf).d(this);
  }
  
  public Object f(aj.f paramf)
  {
    return Cb().i(paramf).b(this);
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = Cb().bPJ.getFields().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (aj.f)localIterator.next();
        if ((((aj.f)localObject).Hn()) && (!e((aj.f)localObject))) {
          return false;
        }
        if (((aj.f)localObject).bUR.bVz == aj.f.a.bVe)
        {
          if (((aj.f)localObject).Hp())
          {
            localObject = ((List)f((aj.f)localObject)).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((bt)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if ((e((aj.f)localObject)) && (!((bt)f((aj.f)localObject)).isInitialized())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  protected Object writeReplace()
  {
    return new az.c(this);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends a.a<BuilderType>
  {
    da bVW = da.Jk();
    private bb.b bYl;
    private a<BuilderType>.a bYm;
    private boolean bYn;
    
    protected a()
    {
      this(null);
    }
    
    protected a(bb.b paramb)
    {
      this.bYl = paramb;
    }
    
    private Map<aj.f, Object> Id()
    {
      TreeMap localTreeMap = new TreeMap();
      List localList = Cb().bPJ.getFields();
      int i = 0;
      if (i < localList.size())
      {
        aj.f localf = (aj.f)localList.get(i);
        Object localObject = localf.bUT;
        int j;
        if (localObject != null)
        {
          i += ((aj.j)localObject).bVQ - 1;
          j = i;
          if (a((aj.j)localObject)) {
            localf = b((aj.j)localObject);
          }
        }
        for (;;)
        {
          localTreeMap.put(localf, f(localf));
          j = i;
          label149:
          do
          {
            for (;;)
            {
              i = j + 1;
              break;
              if (!localf.Hp()) {
                break label149;
              }
              localObject = (List)f(localf);
              j = i;
              if (!((List)localObject).isEmpty())
              {
                localTreeMap.put(localf, localObject);
                j = i;
              }
            }
            j = i;
          } while (!e(localf));
        }
      }
      return localTreeMap;
    }
    
    protected final void Ag()
    {
      this.bYn = true;
    }
    
    public BuilderType CO()
    {
      a locala = (a)Ct().Cp();
      locala.a(CP());
      return locala;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected abstract bb.e Cb();
    
    public aj.a Cv()
    {
      return Cb().bPJ;
    }
    
    public Map<aj.f, Object> Hz()
    {
      return Collections.unmodifiableMap(Id());
    }
    
    protected final void Ib()
    {
      if (this.bYl != null) {
        this.bYn = true;
      }
    }
    
    protected final boolean Ic()
    {
      return this.bYn;
    }
    
    protected final bb.b Ie()
    {
      if (this.bYm == null) {
        this.bYm = new a((byte)0);
      }
      return this.bYm;
    }
    
    public final boolean a(aj.j paramj)
    {
      return Cb().e(paramj).c(this);
    }
    
    public final aj.f b(aj.j paramj)
    {
      return Cb().e(paramj).e(this);
    }
    
    public BuilderType c(aj.f paramf, Object paramObject)
    {
      Cb().i(paramf).b(this, paramObject);
      return this;
    }
    
    public BuilderType d(aj.f paramf, Object paramObject)
    {
      Cb().i(paramf).a(this, paramObject);
      return this;
    }
    
    public BuilderType d(da paramda)
    {
      return e(da.ac(this.bVW).ae(paramda).Jm());
    }
    
    final void dispose()
    {
      this.bYl = null;
    }
    
    public BuilderType e(da paramda)
    {
      this.bVW = paramda;
      onChanged();
      return this;
    }
    
    public boolean e(aj.f paramf)
    {
      return Cb().i(paramf).c(this);
    }
    
    public Object f(aj.f paramf)
    {
      Object localObject2 = Cb().i(paramf).b(this);
      Object localObject1 = localObject2;
      if (paramf.Hp()) {
        localObject1 = Collections.unmodifiableList((List)localObject2);
      }
      return localObject1;
    }
    
    public bt.a h(aj.f paramf)
    {
      return Cb().i(paramf).Ik();
    }
    
    public boolean isInitialized()
    {
      Iterator localIterator = Cv().getFields().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (aj.f)localIterator.next();
          if ((((aj.f)localObject).Hn()) && (!e((aj.f)localObject))) {
            return false;
          }
          if (((aj.f)localObject).bUR.bVz == aj.f.a.bVe)
          {
            if (((aj.f)localObject).Hp())
            {
              localObject = ((List)f((aj.f)localObject)).iterator();
              if (!((Iterator)localObject).hasNext()) {
                continue;
              }
              if (((bt)((Iterator)localObject).next()).isInitialized()) {
                break;
              }
              return false;
            }
            if ((e((aj.f)localObject)) && (!((bt)f((aj.f)localObject)).isInitialized())) {
              return false;
            }
          }
        }
      }
      return true;
    }
    
    protected final void onChanged()
    {
      if ((this.bYn) && (this.bYl != null))
      {
        this.bYl.Ai();
        this.bYn = false;
      }
    }
    
    final class a
      implements bb.b
    {
      private a() {}
      
      public final void Ai()
      {
        bb.a.this.onChanged();
      }
    }
  }
  
  public static abstract interface b
    extends a.b
  {}
  
  public static abstract class c<MessageType extends bb.d, BuilderType extends c<MessageType, BuilderType>>
    extends bb.a<BuilderType>
    implements bc<MessageType>
  {
    private av<aj.f> bXY = av.HP();
    
    protected c() {}
    
    protected c(bb.b paramb)
    {
      super();
    }
    
    private void If()
    {
      if (this.bXY.bWA) {
        this.bXY = this.bXY.HQ();
      }
    }
    
    private void g(aj.f paramf)
    {
      if (paramf.bUr != Cv()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    public final Map<aj.f, Object> Hz()
    {
      Map localMap = bb.a.a(this);
      localMap.putAll(this.bXY.Hz());
      return Collections.unmodifiableMap(localMap);
    }
    
    protected final boolean Ig()
    {
      return this.bXY.isInitialized();
    }
    
    protected final void a(bb.d paramd)
    {
      If();
      this.bXY.a(bb.d.b(paramd));
      onChanged();
    }
    
    public final boolean e(aj.f paramf)
    {
      if (paramf.bUO.DU())
      {
        g(paramf);
        return this.bXY.a(paramf);
      }
      return super.e(paramf);
    }
    
    public final Object f(aj.f paramf)
    {
      if (paramf.bUO.DU())
      {
        g(paramf);
        Object localObject2 = this.bXY.b(paramf);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramf.bUR.bVz == aj.f.a.bVe) {
            localObject1 = ak.c(paramf.Hu());
          }
        }
        else {
          return localObject1;
        }
        return paramf.Hs();
      }
      return super.f(paramf);
    }
    
    public final bt.a h(aj.f paramf)
    {
      if (paramf.bUO.DU()) {
        return ak.d(paramf.Hu());
      }
      return super.h(paramf);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (this.bXY.isInitialized());
    }
    
    public BuilderType q(aj.f paramf, Object paramObject)
    {
      if (paramf.bUO.DU())
      {
        g(paramf);
        If();
        this.bXY.b(paramf, paramObject);
        onChanged();
        return this;
      }
      return (c)super.c(paramf, paramObject);
    }
    
    public BuilderType r(aj.f paramf, Object paramObject)
    {
      if (paramf.bUO.DU())
      {
        g(paramf);
        If();
        this.bXY.a(paramf, paramObject);
        onChanged();
        return this;
      }
      return (c)super.d(paramf, paramObject);
    }
  }
  
  public static abstract class d<MessageType extends d>
    extends bb
    implements bc<MessageType>
  {
    final av<aj.f> bXY;
    
    protected d()
    {
      this.bXY = av.HO();
    }
    
    protected d(bb.c<MessageType, ?> paramc)
    {
      super();
      this.bXY = bb.c.a(paramc);
    }
    
    private void g(aj.f paramf)
    {
      if (paramf.bUr != Cv()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    public final Map<aj.f, Object> HX()
    {
      Map localMap = bb.a(this);
      localMap.putAll(this.bXY.Hz());
      return Collections.unmodifiableMap(localMap);
    }
    
    protected final void HZ()
    {
      this.bXY.Al();
    }
    
    public final Map<aj.f, Object> Hz()
    {
      Map localMap = bb.a(this);
      localMap.putAll(this.bXY.Hz());
      return Collections.unmodifiableMap(localMap);
    }
    
    protected final boolean Ig()
    {
      return this.bXY.isInitialized();
    }
    
    protected final d<MessageType>.a Ih()
    {
      return new a((byte)0);
    }
    
    protected final int Ii()
    {
      return this.bXY.Ad();
    }
    
    protected final Map<aj.f, Object> Ij()
    {
      return this.bXY.Hz();
    }
    
    protected final boolean a(h paramh, da.a parama, ap paramap, int paramInt)
    {
      if (paramh.bPq) {
        parama = null;
      }
      for (;;)
      {
        return ca.a(paramh, parama, paramap, Cv(), new ca.b(this.bXY), paramInt);
      }
    }
    
    public final boolean e(aj.f paramf)
    {
      if (paramf.bUO.DU())
      {
        g(paramf);
        return this.bXY.a(paramf);
      }
      return super.e(paramf);
    }
    
    public final Object f(aj.f paramf)
    {
      if (paramf.bUO.DU())
      {
        g(paramf);
        Object localObject2 = this.bXY.b(paramf);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramf.Hp()) {
            localObject1 = Collections.emptyList();
          }
        }
        else {
          return localObject1;
        }
        if (paramf.bUR.bVz == aj.f.a.bVe) {
          return ak.c(paramf.Hu());
        }
        return paramf.Hs();
      }
      return super.f(paramf);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (this.bXY.isInitialized());
    }
    
    protected final class a
    {
      private final Iterator<Map.Entry<aj.f, Object>> bYp = bb.d.b(bb.d.this).iterator();
      private Map.Entry<aj.f, Object> bYq;
      private final boolean bYr;
      
      private a()
      {
        if (this.bYp.hasNext()) {
          this.bYq = ((Map.Entry)this.bYp.next());
        }
        this.bYr = false;
      }
      
      public final void b(i parami)
      {
        while ((this.bYq != null) && (((aj.f)this.bYq.getKey()).bUO.bRD < 536870912))
        {
          aj.f localf = (aj.f)this.bYq.getKey();
          if ((this.bYr) && (localf.Hk().ccx == dh.b.ccI) && (!localf.Hp())) {
            if ((this.bYq instanceof bh.a)) {
              parami.b(localf.bUO.bRD, ((bh.a)this.bYq).Iv().Aj());
            }
          }
          for (;;)
          {
            if (!this.bYp.hasNext()) {
              break label178;
            }
            this.bYq = ((Map.Entry)this.bYp.next());
            break;
            parami.b(localf.bUO.bRD, (bt)this.bYq.getValue());
            continue;
            av.a(localf, this.bYq.getValue(), parami);
          }
          label178:
          this.bYq = null;
        }
      }
    }
  }
  
  public static final class e
  {
    final aj.a bPJ;
    private final a[] bYt;
    private String[] bYu;
    private final c[] bYv;
    private volatile boolean initialized;
    
    public e(aj.a parama, String[] paramArrayOfString)
    {
      this.bPJ = parama;
      this.bYu = paramArrayOfString;
      this.bYt = new a[parama.getFields().size()];
      this.bYv = new c[parama.He().size()];
      this.initialized = false;
    }
    
    public final e b(Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1)
    {
      if (this.initialized) {
        return this;
      }
      try
      {
        if (this.initialized) {
          return this;
        }
      }
      finally {}
      int j = this.bYt.length;
      int i = 0;
      for (;;)
      {
        aj.f localf;
        if (i < j)
        {
          localf = (aj.f)this.bPJ.getFields().get(i);
          if (localf.bUT == null) {
            break label441;
          }
        }
        label441:
        for (String str = this.bYu[(localf.bUT.index + j)];; str = null)
        {
          if (localf.Hp())
          {
            if (localf.bUR.bVz == aj.f.a.bVe)
            {
              if (localf.Hm())
              {
                this.bYt[i] = new b(localf, paramClass);
                break;
              }
              this.bYt[i] = new f(this.bYu[i], paramClass, paramClass1);
              break;
            }
            if (localf.bUR.bVz == aj.f.a.bVd)
            {
              this.bYt[i] = new d(localf, this.bYu[i], paramClass, paramClass1);
              break;
            }
            this.bYt[i] = new e(this.bYu[i], paramClass, paramClass1);
            break;
          }
          if (localf.bUR.bVz == aj.f.a.bVe)
          {
            this.bYt[i] = new i(localf, this.bYu[i], paramClass, paramClass1, str);
            break;
          }
          if (localf.bUR.bVz == aj.f.a.bVd)
          {
            this.bYt[i] = new g(localf, this.bYu[i], paramClass, paramClass1, str);
            break;
          }
          if (localf.bUR.bVz == aj.f.a.bVb)
          {
            this.bYt[i] = new j(localf, this.bYu[i], paramClass, paramClass1, str);
            break;
          }
          this.bYt[i] = new h(localf, this.bYu[i], paramClass, paramClass1, str);
          break;
          int k = this.bYv.length;
          i = 0;
          while (i < k)
          {
            this.bYv[i] = new c(this.bPJ, this.bYu[(i + j)], paramClass, paramClass1);
            i += 1;
          }
          this.initialized = true;
          this.bYu = null;
          return this;
        }
        i += 1;
      }
    }
    
    final c e(aj.j paramj)
    {
      if (paramj.bUr != this.bPJ) {
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
      return this.bYv[paramj.index];
    }
    
    final a i(aj.f paramf)
    {
      if (paramf.bUr != this.bPJ) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
      if (paramf.bUO.DU()) {
        throw new IllegalArgumentException("This type does not have extensions.");
      }
      return this.bYt[paramf.index];
    }
    
    static abstract interface a
    {
      public abstract bt.a Ik();
      
      public abstract void a(bb.a parama, Object paramObject);
      
      public abstract Object b(bb.a parama);
      
      public abstract Object b(bb parambb);
      
      public abstract void b(bb.a parama, Object paramObject);
      
      public abstract Object c(bb parambb);
      
      public abstract boolean c(bb.a parama);
      
      public abstract boolean d(bb parambb);
    }
    
    static final class b
      implements bb.e.a
    {
      private final aj.f bYw;
      private final bt bYx;
      
      b(aj.f paramf, Class<? extends bb> paramClass)
      {
        this.bYw = paramf;
        ((bb)bb.b(bb.c(paramClass, "getDefaultInstance", new Class[0]), null, new Object[0])).Ia();
        throw null;
      }
      
      private bn<?, ?> d(bb.a parama)
      {
        throw new RuntimeException("No map fields found in " + parama.getClass().getName());
      }
      
      public final bt.a Ik()
      {
        return this.bYx.Cp();
      }
      
      public final void a(bb.a parama, Object paramObject)
      {
        d(parama);
        throw null;
      }
      
      public final Object b(bb.a parama)
      {
        new ArrayList();
        throw new RuntimeException("No map fields found in " + parama.getClass().getName());
      }
      
      public final Object b(bb parambb)
      {
        new ArrayList();
        parambb.Ia();
        throw null;
      }
      
      public final void b(bb.a parama, Object paramObject)
      {
        d(parama);
        throw null;
      }
      
      public final Object c(bb parambb)
      {
        return b(parambb);
      }
      
      public final boolean c(bb.a parama)
      {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
      
      public final boolean d(bb parambb)
      {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
    }
    
    static final class c
    {
      final aj.a bPJ;
      private final Method bYA;
      final Method bYy;
      private final Method bYz;
      
      c(aj.a parama, String paramString, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1)
      {
        this.bPJ = parama;
        this.bYy = bb.c(paramClass, "get" + paramString + "Case", new Class[0]);
        this.bYz = bb.c(paramClass1, "get" + paramString + "Case", new Class[0]);
        this.bYA = bb.c(paramClass1, "clear".concat(String.valueOf(paramString)), new Class[0]);
      }
      
      public final boolean c(bb.a parama)
      {
        return ((be.a)bb.b(this.bYz, parama, new Object[0])).getNumber() != 0;
      }
      
      public final aj.f e(bb.a parama)
      {
        int i = ((be.a)bb.b(this.bYz, parama, new Object[0])).getNumber();
        if (i > 0) {
          return this.bPJ.hr(i);
        }
        return null;
      }
    }
    
    static final class d
      extends bb.e.e
    {
      private aj.d bYB;
      private final Method bYC;
      private final Method bYD;
      private boolean bYE;
      private Method bYF;
      private Method bYG;
      private Method bYH;
      private Method bYI;
      
      d(aj.f paramf, String paramString, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1)
      {
        super(paramClass, paramClass1);
        this.bYB = paramf.Hv();
        this.bYC = bb.c(this.bYJ, "valueOf", new Class[] { aj.e.class });
        this.bYD = bb.c(this.bYJ, "getValueDescriptor", new Class[0]);
        this.bYE = paramf.bUq.Hy();
        if (this.bYE)
        {
          this.bYF = bb.c(paramClass, "get" + paramString + "Value", new Class[] { Integer.TYPE });
          this.bYG = bb.c(paramClass1, "get" + paramString + "Value", new Class[] { Integer.TYPE });
          this.bYH = bb.c(paramClass1, "set" + paramString + "Value", new Class[] { Integer.TYPE, Integer.TYPE });
          this.bYI = bb.c(paramClass1, "add" + paramString + "Value", new Class[] { Integer.TYPE });
        }
      }
      
      public final Object a(bb.a parama, int paramInt)
      {
        if (this.bYE)
        {
          paramInt = ((Integer)bb.b(this.bYG, parama, new Object[] { Integer.valueOf(paramInt) })).intValue();
          return this.bYB.ht(paramInt);
        }
        return bb.b(this.bYD, super.a(parama, paramInt), new Object[0]);
      }
      
      public final Object a(bb parambb, int paramInt)
      {
        if (this.bYE)
        {
          paramInt = ((Integer)bb.b(this.bYF, parambb, new Object[] { Integer.valueOf(paramInt) })).intValue();
          return this.bYB.ht(paramInt);
        }
        return bb.b(this.bYD, super.a(parambb, paramInt), new Object[0]);
      }
      
      public final Object b(bb.a parama)
      {
        ArrayList localArrayList = new ArrayList();
        int j = f(parama);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(parama, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object b(bb parambb)
      {
        ArrayList localArrayList = new ArrayList();
        int j = e(parambb);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(parambb, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final void b(bb.a parama, Object paramObject)
      {
        if (this.bYE)
        {
          bb.b(this.bYI, parama, new Object[] { Integer.valueOf(((aj.e)paramObject).bUL.bRD) });
          return;
        }
        super.b(parama, bb.b(this.bYC, null, new Object[] { paramObject }));
      }
    }
    
    static class e
      implements bb.e.a
    {
      protected final Method bYA;
      protected final Class bYJ;
      protected final Method bYK;
      protected final Method bYL;
      protected final Method bYM;
      protected final Method bYN;
      protected final Method bYO;
      protected final Method bYP;
      protected final Method bYQ;
      protected final Method bYR;
      
      e(String paramString, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1)
      {
        this.bYK = bb.c(paramClass, "get" + paramString + "List", new Class[0]);
        this.bYL = bb.c(paramClass1, "get" + paramString + "List", new Class[0]);
        this.bYM = bb.c(paramClass, "get".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE });
        this.bYN = bb.c(paramClass1, "get".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE });
        this.bYJ = this.bYM.getReturnType();
        this.bYO = bb.c(paramClass1, "set".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE, this.bYJ });
        this.bYP = bb.c(paramClass1, "add".concat(String.valueOf(paramString)), new Class[] { this.bYJ });
        this.bYQ = bb.c(paramClass, "get" + paramString + "Count", new Class[0]);
        this.bYR = bb.c(paramClass1, "get" + paramString + "Count", new Class[0]);
        this.bYA = bb.c(paramClass1, "clear".concat(String.valueOf(paramString)), new Class[0]);
      }
      
      public bt.a Ik()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public Object a(bb.a parama, int paramInt)
      {
        return bb.b(this.bYN, parama, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public Object a(bb parambb, int paramInt)
      {
        return bb.b(this.bYM, parambb, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public final void a(bb.a parama, Object paramObject)
      {
        bb.b(this.bYA, parama, new Object[0]);
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          b(parama, paramObject.next());
        }
      }
      
      public Object b(bb.a parama)
      {
        return bb.b(this.bYL, parama, new Object[0]);
      }
      
      public Object b(bb parambb)
      {
        return bb.b(this.bYK, parambb, new Object[0]);
      }
      
      public void b(bb.a parama, Object paramObject)
      {
        bb.b(this.bYP, parama, new Object[] { paramObject });
      }
      
      public final Object c(bb parambb)
      {
        return b(parambb);
      }
      
      public final boolean c(bb.a parama)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public final boolean d(bb parambb)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public final int e(bb parambb)
      {
        return ((Integer)bb.b(this.bYQ, parambb, new Object[0])).intValue();
      }
      
      public final int f(bb.a parama)
      {
        return ((Integer)bb.b(this.bYR, parama, new Object[0])).intValue();
      }
    }
    
    static final class f
      extends bb.e.e
    {
      private final Method bYS = bb.c(this.bYJ, "newBuilder", new Class[0]);
      private final Method bYT;
      
      f(String paramString, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1)
      {
        super(paramClass, paramClass1);
        this.bYT = bb.c(paramClass1, "get" + paramString + "Builder", new Class[] { Integer.TYPE });
      }
      
      public final bt.a Ik()
      {
        return (bt.a)bb.b(this.bYS, null, new Object[0]);
      }
      
      public final void b(bb.a parama, Object paramObject)
      {
        if (this.bYJ.isInstance(paramObject)) {}
        for (;;)
        {
          super.b(parama, paramObject);
          return;
          paramObject = ((bt.a)bb.b(this.bYS, null, new Object[0])).c((bt)paramObject).CQ();
        }
      }
    }
    
    static final class g
      extends bb.e.h
    {
      private aj.d bYB;
      private Method bYC;
      private Method bYD;
      private boolean bYE;
      private Method bYU;
      private Method bYV;
      private Method bYW;
      
      g(aj.f paramf, String paramString1, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.bYB = paramf.Hv();
        this.bYC = bb.c(this.bYJ, "valueOf", new Class[] { aj.e.class });
        this.bYD = bb.c(this.bYJ, "getValueDescriptor", new Class[0]);
        this.bYE = paramf.bUq.Hy();
        if (this.bYE)
        {
          this.bYU = bb.c(paramClass, "get" + paramString1 + "Value", new Class[0]);
          this.bYV = bb.c(paramClass1, "get" + paramString1 + "Value", new Class[0]);
          this.bYW = bb.c(paramClass1, "set" + paramString1 + "Value", new Class[] { Integer.TYPE });
        }
      }
      
      public final void a(bb.a parama, Object paramObject)
      {
        if (this.bYE)
        {
          bb.b(this.bYW, parama, new Object[] { Integer.valueOf(((aj.e)paramObject).bUL.bRD) });
          return;
        }
        super.a(parama, bb.b(this.bYC, null, new Object[] { paramObject }));
      }
      
      public final Object b(bb.a parama)
      {
        if (this.bYE)
        {
          int i = ((Integer)bb.b(this.bYV, parama, new Object[0])).intValue();
          return this.bYB.ht(i);
        }
        return bb.b(this.bYD, super.b(parama), new Object[0]);
      }
      
      public final Object b(bb parambb)
      {
        if (this.bYE)
        {
          int i = ((Integer)bb.b(this.bYU, parambb, new Object[0])).intValue();
          return this.bYB.ht(i);
        }
        return bb.b(this.bYD, super.b(parambb), new Object[0]);
      }
    }
    
    static class h
      implements bb.e.a
    {
      protected final Method bYA;
      protected final Class<?> bYJ;
      protected final Method bYK;
      protected final Method bYL;
      protected final Method bYX;
      protected final Method bYY;
      protected final Method bYZ;
      protected final aj.f bYw;
      protected final Method bYy;
      protected final Method bYz;
      protected final boolean bZa;
      protected final boolean bZb;
      
      h(aj.f paramf, String paramString1, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1, String paramString2)
      {
        this.bYw = paramf;
        boolean bool;
        int i;
        if (paramf.bUT != null)
        {
          bool = true;
          this.bZa = bool;
          if (paramf.bUq.Hx() != aj.g.a.bVI) {
            break label341;
          }
          i = 1;
          label44:
          if ((i == 0) && ((this.bZa) || (paramf.bUR.bVz != aj.f.a.bVe))) {
            break label347;
          }
          bool = true;
          label72:
          this.bZb = bool;
          this.bYK = bb.c(paramClass, "get".concat(String.valueOf(paramString1)), new Class[0]);
          this.bYL = bb.c(paramClass1, "get".concat(String.valueOf(paramString1)), new Class[0]);
          this.bYJ = this.bYK.getReturnType();
          this.bYX = bb.c(paramClass1, "set".concat(String.valueOf(paramString1)), new Class[] { this.bYJ });
          if (!this.bZb) {
            break label353;
          }
          paramf = bb.c(paramClass, "has".concat(String.valueOf(paramString1)), new Class[0]);
          label186:
          this.bYY = paramf;
          if (!this.bZb) {
            break label358;
          }
          paramf = bb.c(paramClass1, "has".concat(String.valueOf(paramString1)), new Class[0]);
          label217:
          this.bYZ = paramf;
          this.bYA = bb.c(paramClass1, "clear".concat(String.valueOf(paramString1)), new Class[0]);
          if (!this.bZa) {
            break label363;
          }
        }
        label341:
        label347:
        label353:
        label358:
        label363:
        for (paramf = bb.c(paramClass, "get" + paramString2 + "Case", new Class[0]);; paramf = null)
        {
          this.bYy = paramf;
          paramf = localObject;
          if (this.bZa) {
            paramf = bb.c(paramClass1, "get" + paramString2 + "Case", new Class[0]);
          }
          this.bYz = paramf;
          return;
          bool = false;
          break;
          i = 0;
          break label44;
          bool = false;
          break label72;
          paramf = null;
          break label186;
          paramf = null;
          break label217;
        }
      }
      
      public bt.a Ik()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public void a(bb.a parama, Object paramObject)
      {
        bb.b(this.bYX, parama, new Object[] { paramObject });
      }
      
      public Object b(bb.a parama)
      {
        return bb.b(this.bYL, parama, new Object[0]);
      }
      
      public Object b(bb parambb)
      {
        return bb.b(this.bYK, parambb, new Object[0]);
      }
      
      public final void b(bb.a parama, Object paramObject)
      {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }
      
      public Object c(bb parambb)
      {
        return b(parambb);
      }
      
      public final boolean c(bb.a parama)
      {
        if (!this.bZb)
        {
          if (this.bZa) {
            return ((be.a)bb.b(this.bYz, parama, new Object[0])).getNumber() == this.bYw.bUO.bRD;
          }
          return !b(parama).equals(this.bYw.Hs());
        }
        return ((Boolean)bb.b(this.bYZ, parama, new Object[0])).booleanValue();
      }
      
      public final boolean d(bb parambb)
      {
        if (!this.bZb)
        {
          if (this.bZa) {
            return ((be.a)bb.b(this.bYy, parambb, new Object[0])).getNumber() == this.bYw.bUO.bRD;
          }
          return !b(parambb).equals(this.bYw.Hs());
        }
        return ((Boolean)bb.b(this.bYY, parambb, new Object[0])).booleanValue();
      }
    }
    
    static final class i
      extends bb.e.h
    {
      private final Method bYS = bb.c(this.bYJ, "newBuilder", new Class[0]);
      private final Method bYT;
      
      i(aj.f paramf, String paramString1, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.bYT = bb.c(paramClass1, "get" + paramString1 + "Builder", new Class[0]);
      }
      
      public final bt.a Ik()
      {
        return (bt.a)bb.b(this.bYS, null, new Object[0]);
      }
      
      public final void a(bb.a parama, Object paramObject)
      {
        if (this.bYJ.isInstance(paramObject)) {}
        for (;;)
        {
          super.a(parama, paramObject);
          return;
          paramObject = ((bt.a)bb.b(this.bYS, null, new Object[0])).c((bt)paramObject).CP();
        }
      }
    }
    
    static final class j
      extends bb.e.h
    {
      private final Method bZc;
      private final Method bZd;
      private final Method bZe;
      
      j(aj.f paramf, String paramString1, Class<? extends bb> paramClass, Class<? extends bb.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.bZc = bb.c(paramClass, "get" + paramString1 + "Bytes", new Class[0]);
        this.bZd = bb.c(paramClass1, "get" + paramString1 + "Bytes", new Class[0]);
        this.bZe = bb.c(paramClass1, "set" + paramString1 + "Bytes", new Class[] { g.class });
      }
      
      public final void a(bb.a parama, Object paramObject)
      {
        if ((paramObject instanceof g))
        {
          bb.b(this.bZe, parama, new Object[] { paramObject });
          return;
        }
        super.a(parama, paramObject);
      }
      
      public final Object c(bb parambb)
      {
        return bb.b(this.bZc, parambb, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bb
 * JD-Core Version:    0.7.0.1
 */