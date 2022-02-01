package com.google.a;

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

public abstract class ac
  extends a
  implements Serializable
{
  protected static boolean bVU = false;
  protected cc bTW;
  
  protected ac()
  {
    this.bTW = cc.HK();
  }
  
  protected ac(a<?> parama)
  {
    this.bTW = parama.Ax();
  }
  
  protected static ae.d Gv()
  {
    return ad.GE();
  }
  
  protected static ae.d a(ae.d paramd)
  {
    int i = paramd.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramd.gE(i);
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
      parami.e(paramInt, (String)paramObject);
      return;
    }
    parami.a(paramInt, (g)paramObject);
  }
  
  protected static int ar(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return i.cb((String)paramObject);
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
  
  private Map<l.f, Object> bE(boolean paramBoolean)
  {
    TreeMap localTreeMap = new TreeMap();
    List localList = Ay().bNK.getFields();
    int i = 0;
    if (i < localList.size())
    {
      Object localObject1 = (l.f)localList.get(i);
      Object localObject2 = ((l.f)localObject1).bSU;
      int k;
      label103:
      int j;
      if (localObject2 != null)
      {
        i += ((l.j)localObject2).bTQ - 1;
        if (((ae.a)a(Ay().e((l.j)localObject2).bWG, this, new Object[0])).getNumber() == 0)
        {
          k = 0;
          j = i;
          if (k != 0)
          {
            localObject1 = Ay().e((l.j)localObject2);
            j = ((ae.a)a(((ac.f.c)localObject1).bWG, this, new Object[0])).getNumber();
            if (j <= 0) {
              break label214;
            }
            localObject1 = ((ac.f.c)localObject1).bNK.gz(j);
            label158:
            if ((!paramBoolean) || (((l.f)localObject1).bSS.bTz != l.f.a.bTb)) {
              break label280;
            }
            localTreeMap.put(localObject1, Ay().i((l.f)localObject1).c(this));
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
        if (((l.f)localObject1).FJ())
        {
          localObject2 = (List)f((l.f)localObject1);
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
          if (e((l.f)localObject1))
          {
            break label158;
            label280:
            localTreeMap.put(localObject1, f((l.f)localObject1));
            j = i;
          }
        }
      }
    }
    return localTreeMap;
  }
  
  protected static int d(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return i.f(paramInt, (String)paramObject);
    }
    return i.c(paramInt, (g)paramObject);
  }
  
  public bj<? extends ac> AK()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public final l.a AS()
  {
    return Ay().bNK;
  }
  
  public cc Ax()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  protected abstract f Ay();
  
  public Map<l.f, Object> FS()
  {
    return Collections.unmodifiableMap(bE(false));
  }
  
  Map<l.f, Object> Gu()
  {
    return Collections.unmodifiableMap(bE(true));
  }
  
  protected void Gw() {}
  
  protected final an Gx()
  {
    throw new RuntimeException("No map fields found in " + getClass().getName());
  }
  
  protected final at.a a(final a.b paramb)
  {
    a(new b()
    {
      public final void yH()
      {
        paramb.yH();
      }
    });
  }
  
  protected abstract at.a a(b paramb);
  
  public void a(i parami)
  {
    ba.a(this, Gu(), parami);
  }
  
  protected boolean a(h paramh, cc.a parama, r paramr, int paramInt)
  {
    if (paramh.bNr) {
      return paramh.fG(paramInt);
    }
    return parama.a(paramInt, paramh);
  }
  
  public boolean e(l.f paramf)
  {
    return Ay().i(paramf).d(this);
  }
  
  public Object f(l.f paramf)
  {
    return Ay().i(paramf).b(this);
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = Ay().bNK.getFields().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (l.f)localIterator.next();
        if ((((l.f)localObject).FH()) && (!e((l.f)localObject))) {
          return false;
        }
        if (((l.f)localObject).bSS.bTz == l.f.a.bTe)
        {
          if (((l.f)localObject).FJ())
          {
            localObject = ((List)f((l.f)localObject)).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((at)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if ((e((l.f)localObject)) && (!((at)f((l.f)localObject)).isInitialized())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  protected Object writeReplace()
  {
    return new ab.f(this);
  }
  
  public int yC()
  {
    int i = this.bNa;
    if (i != -1) {
      return i;
    }
    this.bNa = ba.a(this, Gu());
    return this.bNa;
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends a.a<BuilderType>
  {
    private cc bTW = cc.HK();
    private ac.b bWt;
    private a<BuilderType>.a bWu;
    boolean bWv;
    
    protected a()
    {
      this(null);
    }
    
    protected a(ac.b paramb)
    {
      this.bWt = paramb;
    }
    
    private Map<l.f, Object> Gz()
    {
      TreeMap localTreeMap = new TreeMap();
      List localList = Ay().bNK.getFields();
      int i = 0;
      if (i < localList.size())
      {
        l.f localf = (l.f)localList.get(i);
        Object localObject = localf.bSU;
        int j;
        if (localObject != null)
        {
          i += ((l.j)localObject).bTQ - 1;
          j = i;
          if (a((l.j)localObject)) {
            localf = b((l.j)localObject);
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
              if (!localf.FJ()) {
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
    
    public l.a AS()
    {
      return Ay().bNK;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected abstract ac.f Ay();
    
    public BuilderType Bl()
    {
      a locala = (a)AQ().AM();
      locala.a(Bm());
      return locala;
    }
    
    public Map<l.f, Object> FS()
    {
      return Collections.unmodifiableMap(Gz());
    }
    
    protected final ac.b GA()
    {
      if (this.bWu == null) {
        this.bWu = new a((byte)0);
      }
      return this.bWu;
    }
    
    protected final void Gy()
    {
      if (this.bWt != null) {
        this.bWv = true;
      }
    }
    
    public final boolean a(l.j paramj)
    {
      return Ay().e(paramj).c(this);
    }
    
    public final l.f b(l.j paramj)
    {
      return Ay().e(paramj).f(this);
    }
    
    public BuilderType c(l.f paramf, Object paramObject)
    {
      Ay().i(paramf).b(this, paramObject);
      return this;
    }
    
    public BuilderType d(cc paramcc)
    {
      return e(cc.ac(this.bTW).ae(paramcc).HM());
    }
    
    public BuilderType d(l.f paramf, Object paramObject)
    {
      Ay().i(paramf).a(this, paramObject);
      return this;
    }
    
    public BuilderType e(cc paramcc)
    {
      this.bTW = paramcc;
      onChanged();
      return this;
    }
    
    public boolean e(l.f paramf)
    {
      return Ay().i(paramf).c(this);
    }
    
    public Object f(l.f paramf)
    {
      Object localObject2 = Ay().i(paramf).b(this);
      Object localObject1 = localObject2;
      if (paramf.FJ()) {
        localObject1 = Collections.unmodifiableList((List)localObject2);
      }
      return localObject1;
    }
    
    public at.a h(l.f paramf)
    {
      return Ay().i(paramf).GD();
    }
    
    public boolean isInitialized()
    {
      Iterator localIterator = AS().getFields().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (l.f)localIterator.next();
          if ((((l.f)localObject).FH()) && (!e((l.f)localObject))) {
            return false;
          }
          if (((l.f)localObject).bSS.bTz == l.f.a.bTe)
          {
            if (((l.f)localObject).FJ())
            {
              localObject = ((List)f((l.f)localObject)).iterator();
              if (!((Iterator)localObject).hasNext()) {
                continue;
              }
              if (((at)((Iterator)localObject).next()).isInitialized()) {
                break;
              }
              return false;
            }
            if ((e((l.f)localObject)) && (!((at)f((l.f)localObject)).isInitialized())) {
              return false;
            }
          }
        }
      }
      return true;
    }
    
    protected final void onChanged()
    {
      if ((this.bWv) && (this.bWt != null))
      {
        this.bWt.yH();
        this.bWv = false;
      }
    }
    
    protected final void yF()
    {
      this.bWv = true;
    }
    
    final class a
      implements ac.b
    {
      private a() {}
      
      public final void yH()
      {
        ac.a.this.onChanged();
      }
    }
  }
  
  protected static abstract interface b
    extends a.b
  {}
  
  public static abstract class c<MessageType extends ac.d, BuilderType extends c<MessageType, BuilderType>>
    extends ac.a<BuilderType>
    implements ac.e<MessageType>
  {
    x<l.f> bWd = x.Gj();
    
    protected c() {}
    
    protected c(ac.b paramb)
    {
      super();
    }
    
    private void GB()
    {
      if (this.bWd.bUC) {
        this.bWd = this.bWd.Gk();
      }
    }
    
    private void g(l.f paramf)
    {
      if (paramf.bSs != AS()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    public final Map<l.f, Object> FS()
    {
      Map localMap = ac.a.a(this);
      localMap.putAll(this.bWd.FS());
      return Collections.unmodifiableMap(localMap);
    }
    
    protected final void a(ac.d paramd)
    {
      GB();
      this.bWd.a(ac.d.b(paramd));
      onChanged();
    }
    
    public final boolean e(l.f paramf)
    {
      if (paramf.bSP.Cp())
      {
        g(paramf);
        return this.bWd.a(paramf);
      }
      return super.e(paramf);
    }
    
    public final Object f(l.f paramf)
    {
      if (paramf.bSP.Cp())
      {
        g(paramf);
        Object localObject2 = this.bWd.b(paramf);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramf.bSS.bTz == l.f.a.bTe) {
            localObject1 = m.c(paramf.FN());
          }
        }
        else {
          return localObject1;
        }
        return paramf.getDefaultValue();
      }
      return super.f(paramf);
    }
    
    public final at.a h(l.f paramf)
    {
      if (paramf.bSP.Cp()) {
        return m.d(paramf.FN());
      }
      return super.h(paramf);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (this.bWd.isInitialized());
    }
    
    public BuilderType q(l.f paramf, Object paramObject)
    {
      if (paramf.bSP.Cp())
      {
        g(paramf);
        GB();
        this.bWd.b(paramf, paramObject);
        onChanged();
        return this;
      }
      return (c)super.c(paramf, paramObject);
    }
    
    public BuilderType r(l.f paramf, Object paramObject)
    {
      if (paramf.bSP.Cp())
      {
        g(paramf);
        GB();
        this.bWd.a(paramf, paramObject);
        onChanged();
        return this;
      }
      return (c)super.d(paramf, paramObject);
    }
  }
  
  public static abstract class d<MessageType extends d>
    extends ac
    implements ac.e<MessageType>
  {
    final x<l.f> bWd;
    
    protected d()
    {
      this.bWd = x.Gi();
    }
    
    protected d(ac.c<MessageType, ?> paramc)
    {
      super();
      this.bWd = ac.c.a(paramc);
    }
    
    private void g(l.f paramf)
    {
      if (paramf.bSs != AS()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    public final Map<l.f, Object> FS()
    {
      Map localMap = ac.a(this);
      localMap.putAll(this.bWd.FS());
      return Collections.unmodifiableMap(localMap);
    }
    
    protected final d<MessageType>.a GC()
    {
      return new a((byte)0);
    }
    
    public final Map<l.f, Object> Gu()
    {
      Map localMap = ac.a(this);
      localMap.putAll(this.bWd.FS());
      return Collections.unmodifiableMap(localMap);
    }
    
    protected final void Gw()
    {
      this.bWd.yK();
    }
    
    protected final boolean a(h paramh, cc.a parama, r paramr, int paramInt)
    {
      if (paramh.bNr) {
        parama = null;
      }
      for (;;)
      {
        return ba.a(paramh, parama, paramr, AS(), new ba.b(this.bWd), paramInt);
      }
    }
    
    public final boolean e(l.f paramf)
    {
      if (paramf.bSP.Cp())
      {
        g(paramf);
        return this.bWd.a(paramf);
      }
      return super.e(paramf);
    }
    
    public final Object f(l.f paramf)
    {
      if (paramf.bSP.Cp())
      {
        g(paramf);
        Object localObject2 = this.bWd.b(paramf);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramf.FJ()) {
            localObject1 = Collections.emptyList();
          }
        }
        else {
          return localObject1;
        }
        if (paramf.bSS.bTz == l.f.a.bTe) {
          return m.c(paramf.FN());
        }
        return paramf.getDefaultValue();
      }
      return super.f(paramf);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (this.bWd.isInitialized());
    }
    
    protected final class a
    {
      private final Iterator<Map.Entry<l.f, Object>> bWx = ac.d.b(ac.d.this).iterator();
      private Map.Entry<l.f, Object> bWy;
      private final boolean bWz;
      
      private a()
      {
        if (this.bWx.hasNext()) {
          this.bWy = ((Map.Entry)this.bWx.next());
        }
        this.bWz = false;
      }
      
      public final void b(i parami)
      {
        while ((this.bWy != null) && (((l.f)this.bWy.getKey()).bSP.bPE < 536870912))
        {
          l.f localf = (l.f)this.bWy.getKey();
          if ((this.bWz) && (localf.FE().caU == cj.b.cbf) && (!localf.FJ())) {
            if ((this.bWy instanceof ah.a)) {
              parami.b(localf.bSP.bPE, ((ah.a)this.bWy).GP().yI());
            }
          }
          for (;;)
          {
            if (!this.bWx.hasNext()) {
              break label178;
            }
            this.bWy = ((Map.Entry)this.bWx.next());
            break;
            parami.b(localf.bSP.bPE, (at)this.bWy.getValue());
            continue;
            x.a(localf, this.bWy.getValue(), parami);
          }
          label178:
          this.bWy = null;
        }
      }
    }
  }
  
  public static abstract interface e
    extends az
  {}
  
  public static final class f
  {
    final l.a bNK;
    private final a[] bWB;
    private String[] bWC;
    private final c[] bWD;
    private volatile boolean initialized;
    
    public f(l.a parama, String[] paramArrayOfString)
    {
      this.bNK = parama;
      this.bWC = paramArrayOfString;
      this.bWB = new a[parama.getFields().size()];
      this.bWD = new c[parama.Fy().size()];
      this.initialized = false;
    }
    
    final c e(l.j paramj)
    {
      if (paramj.bSs != this.bNK) {
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
      return this.bWD[paramj.index];
    }
    
    public final f h(Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1)
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
      int j = this.bWB.length;
      int i = 0;
      for (;;)
      {
        l.f localf;
        if (i < j)
        {
          localf = (l.f)this.bNK.getFields().get(i);
          if (localf.bSU == null) {
            break label441;
          }
        }
        label441:
        for (String str = this.bWC[(localf.bSU.index + j)];; str = null)
        {
          if (localf.FJ())
          {
            if (localf.bSS.bTz == l.f.a.bTe)
            {
              if (localf.FG())
              {
                this.bWB[i] = new b(localf, paramClass);
                break;
              }
              this.bWB[i] = new f(this.bWC[i], paramClass, paramClass1);
              break;
            }
            if (localf.bSS.bTz == l.f.a.bTd)
            {
              this.bWB[i] = new d(localf, this.bWC[i], paramClass, paramClass1);
              break;
            }
            this.bWB[i] = new e(this.bWC[i], paramClass, paramClass1);
            break;
          }
          if (localf.bSS.bTz == l.f.a.bTe)
          {
            this.bWB[i] = new i(localf, this.bWC[i], paramClass, paramClass1, str);
            break;
          }
          if (localf.bSS.bTz == l.f.a.bTd)
          {
            this.bWB[i] = new g(localf, this.bWC[i], paramClass, paramClass1, str);
            break;
          }
          if (localf.bSS.bTz == l.f.a.bTb)
          {
            this.bWB[i] = new j(localf, this.bWC[i], paramClass, paramClass1, str);
            break;
          }
          this.bWB[i] = new h(localf, this.bWC[i], paramClass, paramClass1, str);
          break;
          int k = this.bWD.length;
          i = 0;
          while (i < k)
          {
            this.bWD[i] = new c(this.bNK, this.bWC[(i + j)], paramClass, paramClass1);
            i += 1;
          }
          this.initialized = true;
          this.bWC = null;
          return this;
        }
        i += 1;
      }
    }
    
    final a i(l.f paramf)
    {
      if (paramf.bSs != this.bNK) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
      if (paramf.bSP.Cp()) {
        throw new IllegalArgumentException("This type does not have extensions.");
      }
      return this.bWB[paramf.index];
    }
    
    static abstract interface a
    {
      public abstract at.a GD();
      
      public abstract void a(ac.a parama, Object paramObject);
      
      public abstract Object b(ac.a parama);
      
      public abstract Object b(ac paramac);
      
      public abstract void b(ac.a parama, Object paramObject);
      
      public abstract Object c(ac paramac);
      
      public abstract boolean c(ac.a parama);
      
      public abstract boolean d(ac paramac);
    }
    
    static final class b
      implements ac.f.a
    {
      private final l.f bWE;
      private final at bWF;
      
      b(l.f paramf, Class<? extends ac> paramClass)
      {
        this.bWE = paramf;
        this.bWF = ((ac)ac.b(ac.c(paramClass, "getDefaultInstance", new Class[0]), null, new Object[0])).Gx().bXW.Ha();
      }
      
      private at C(at paramat)
      {
        at localat;
        if (paramat == null) {
          localat = null;
        }
        do
        {
          return localat;
          localat = paramat;
        } while (this.bWF.getClass().isInstance(paramat));
        return this.bWF.AL().c(paramat).Bn();
      }
      
      private static an<?, ?> d(ac.a parama)
      {
        throw new RuntimeException("No map fields found in " + parama.getClass().getName());
      }
      
      private static an<?, ?> e(ac.a parama)
      {
        throw new RuntimeException("No map fields found in " + parama.getClass().getName());
      }
      
      public final at.a GD()
      {
        return this.bWF.AM();
      }
      
      public final void a(ac.a parama, Object paramObject)
      {
        e(parama).GX().clear();
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          b(parama, paramObject.next());
        }
      }
      
      public final Object b(ac.a parama)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < d(parama).GW().size())
        {
          localArrayList.add(d(parama).GW().get(i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object b(ac paramac)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramac.Gx().GW().size())
        {
          localArrayList.add(paramac.Gx().GW().get(i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final void b(ac.a parama, Object paramObject)
      {
        e(parama).GX().add(C((at)paramObject));
      }
      
      public final Object c(ac paramac)
      {
        return b(paramac);
      }
      
      public final boolean c(ac.a parama)
      {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
      
      public final boolean d(ac paramac)
      {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
    }
    
    static final class c
    {
      final l.a bNK;
      final Method bWG;
      private final Method bWH;
      private final Method bWI;
      
      c(l.a parama, String paramString, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1)
      {
        this.bNK = parama;
        this.bWG = ac.c(paramClass, "get" + paramString + "Case", new Class[0]);
        this.bWH = ac.c(paramClass1, "get" + paramString + "Case", new Class[0]);
        this.bWI = ac.c(paramClass1, "clear".concat(String.valueOf(paramString)), new Class[0]);
      }
      
      public final boolean c(ac.a parama)
      {
        return ((ae.a)ac.b(this.bWH, parama, new Object[0])).getNumber() != 0;
      }
      
      public final l.f f(ac.a parama)
      {
        int i = ((ae.a)ac.b(this.bWH, parama, new Object[0])).getNumber();
        if (i > 0) {
          return this.bNK.gz(i);
        }
        return null;
      }
    }
    
    static final class d
      extends ac.f.e
    {
      private l.d bWJ;
      private final Method bWK;
      private final Method bWL;
      private boolean bWM;
      private Method bWN;
      private Method bWO;
      private Method bWP;
      private Method bWQ;
      
      d(l.f paramf, String paramString, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1)
      {
        super(paramClass, paramClass1);
        this.bWJ = paramf.FO();
        this.bWK = ac.c(this.bWR, "valueOf", new Class[] { l.e.class });
        this.bWL = ac.c(this.bWR, "getValueDescriptor", new Class[0]);
        this.bWM = paramf.bSr.FR();
        if (this.bWM)
        {
          this.bWN = ac.c(paramClass, "get" + paramString + "Value", new Class[] { Integer.TYPE });
          this.bWO = ac.c(paramClass1, "get" + paramString + "Value", new Class[] { Integer.TYPE });
          this.bWP = ac.c(paramClass1, "set" + paramString + "Value", new Class[] { Integer.TYPE, Integer.TYPE });
          this.bWQ = ac.c(paramClass1, "add" + paramString + "Value", new Class[] { Integer.TYPE });
        }
      }
      
      public final Object a(ac.a parama, int paramInt)
      {
        if (this.bWM)
        {
          paramInt = ((Integer)ac.b(this.bWO, parama, new Object[] { Integer.valueOf(paramInt) })).intValue();
          return this.bWJ.gB(paramInt);
        }
        return ac.b(this.bWL, super.a(parama, paramInt), new Object[0]);
      }
      
      public final Object a(ac paramac, int paramInt)
      {
        if (this.bWM)
        {
          paramInt = ((Integer)ac.b(this.bWN, paramac, new Object[] { Integer.valueOf(paramInt) })).intValue();
          return this.bWJ.gB(paramInt);
        }
        return ac.b(this.bWL, super.a(paramac, paramInt), new Object[0]);
      }
      
      public final Object b(ac.a parama)
      {
        ArrayList localArrayList = new ArrayList();
        int j = g(parama);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(parama, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object b(ac paramac)
      {
        ArrayList localArrayList = new ArrayList();
        int j = e(paramac);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(paramac, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final void b(ac.a parama, Object paramObject)
      {
        if (this.bWM)
        {
          ac.b(this.bWQ, parama, new Object[] { Integer.valueOf(((l.e)paramObject).bSM.bPE) });
          return;
        }
        super.b(parama, ac.b(this.bWK, null, new Object[] { paramObject }));
      }
    }
    
    static class e
      implements ac.f.a
    {
      protected final Method bWI;
      protected final Class bWR;
      protected final Method bWS;
      protected final Method bWT;
      protected final Method bWU;
      protected final Method bWV;
      protected final Method bWW;
      protected final Method bWX;
      protected final Method bWY;
      protected final Method bWZ;
      
      e(String paramString, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1)
      {
        this.bWS = ac.c(paramClass, "get" + paramString + "List", new Class[0]);
        this.bWT = ac.c(paramClass1, "get" + paramString + "List", new Class[0]);
        this.bWU = ac.c(paramClass, "get".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE });
        this.bWV = ac.c(paramClass1, "get".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE });
        this.bWR = this.bWU.getReturnType();
        this.bWW = ac.c(paramClass1, "set".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE, this.bWR });
        this.bWX = ac.c(paramClass1, "add".concat(String.valueOf(paramString)), new Class[] { this.bWR });
        this.bWY = ac.c(paramClass, "get" + paramString + "Count", new Class[0]);
        this.bWZ = ac.c(paramClass1, "get" + paramString + "Count", new Class[0]);
        this.bWI = ac.c(paramClass1, "clear".concat(String.valueOf(paramString)), new Class[0]);
      }
      
      public at.a GD()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public Object a(ac.a parama, int paramInt)
      {
        return ac.b(this.bWV, parama, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public Object a(ac paramac, int paramInt)
      {
        return ac.b(this.bWU, paramac, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public final void a(ac.a parama, Object paramObject)
      {
        ac.b(this.bWI, parama, new Object[0]);
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          b(parama, paramObject.next());
        }
      }
      
      public Object b(ac.a parama)
      {
        return ac.b(this.bWT, parama, new Object[0]);
      }
      
      public Object b(ac paramac)
      {
        return ac.b(this.bWS, paramac, new Object[0]);
      }
      
      public void b(ac.a parama, Object paramObject)
      {
        ac.b(this.bWX, parama, new Object[] { paramObject });
      }
      
      public final Object c(ac paramac)
      {
        return b(paramac);
      }
      
      public final boolean c(ac.a parama)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public final boolean d(ac paramac)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public final int e(ac paramac)
      {
        return ((Integer)ac.b(this.bWY, paramac, new Object[0])).intValue();
      }
      
      public final int g(ac.a parama)
      {
        return ((Integer)ac.b(this.bWZ, parama, new Object[0])).intValue();
      }
    }
    
    static final class f
      extends ac.f.e
    {
      private final Method bXa = ac.c(this.bWR, "newBuilder", new Class[0]);
      private final Method bXb;
      
      f(String paramString, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1)
      {
        super(paramClass, paramClass1);
        this.bXb = ac.c(paramClass1, "get" + paramString + "Builder", new Class[] { Integer.TYPE });
      }
      
      public final at.a GD()
      {
        return (at.a)ac.b(this.bXa, null, new Object[0]);
      }
      
      public final void b(ac.a parama, Object paramObject)
      {
        if (this.bWR.isInstance(paramObject)) {}
        for (;;)
        {
          super.b(parama, paramObject);
          return;
          paramObject = ((at.a)ac.b(this.bXa, null, new Object[0])).c((at)paramObject).Bn();
        }
      }
    }
    
    static final class g
      extends ac.f.h
    {
      private l.d bWJ;
      private Method bWK;
      private Method bWL;
      private boolean bWM;
      private Method bXc;
      private Method bXd;
      private Method bXe;
      
      g(l.f paramf, String paramString1, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.bWJ = paramf.FO();
        this.bWK = ac.c(this.bWR, "valueOf", new Class[] { l.e.class });
        this.bWL = ac.c(this.bWR, "getValueDescriptor", new Class[0]);
        this.bWM = paramf.bSr.FR();
        if (this.bWM)
        {
          this.bXc = ac.c(paramClass, "get" + paramString1 + "Value", new Class[0]);
          this.bXd = ac.c(paramClass1, "get" + paramString1 + "Value", new Class[0]);
          this.bXe = ac.c(paramClass1, "set" + paramString1 + "Value", new Class[] { Integer.TYPE });
        }
      }
      
      public final void a(ac.a parama, Object paramObject)
      {
        if (this.bWM)
        {
          ac.b(this.bXe, parama, new Object[] { Integer.valueOf(((l.e)paramObject).bSM.bPE) });
          return;
        }
        super.a(parama, ac.b(this.bWK, null, new Object[] { paramObject }));
      }
      
      public final Object b(ac.a parama)
      {
        if (this.bWM)
        {
          int i = ((Integer)ac.b(this.bXd, parama, new Object[0])).intValue();
          return this.bWJ.gB(i);
        }
        return ac.b(this.bWL, super.b(parama), new Object[0]);
      }
      
      public final Object b(ac paramac)
      {
        if (this.bWM)
        {
          int i = ((Integer)ac.b(this.bXc, paramac, new Object[0])).intValue();
          return this.bWJ.gB(i);
        }
        return ac.b(this.bWL, super.b(paramac), new Object[0]);
      }
    }
    
    static class h
      implements ac.f.a
    {
      protected final l.f bWE;
      protected final Method bWG;
      protected final Method bWH;
      protected final Method bWI;
      protected final Class<?> bWR;
      protected final Method bWS;
      protected final Method bWT;
      protected final Method bXf;
      protected final Method bXg;
      protected final Method bXh;
      protected final boolean bXi;
      protected final boolean bXj;
      
      h(l.f paramf, String paramString1, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1, String paramString2)
      {
        this.bWE = paramf;
        boolean bool;
        int i;
        if (paramf.bSU != null)
        {
          bool = true;
          this.bXi = bool;
          if (paramf.bSr.FQ() != l.g.a.bTI) {
            break label341;
          }
          i = 1;
          label44:
          if ((i == 0) && ((this.bXi) || (paramf.bSS.bTz != l.f.a.bTe))) {
            break label347;
          }
          bool = true;
          label72:
          this.bXj = bool;
          this.bWS = ac.c(paramClass, "get".concat(String.valueOf(paramString1)), new Class[0]);
          this.bWT = ac.c(paramClass1, "get".concat(String.valueOf(paramString1)), new Class[0]);
          this.bWR = this.bWS.getReturnType();
          this.bXf = ac.c(paramClass1, "set".concat(String.valueOf(paramString1)), new Class[] { this.bWR });
          if (!this.bXj) {
            break label353;
          }
          paramf = ac.c(paramClass, "has".concat(String.valueOf(paramString1)), new Class[0]);
          label186:
          this.bXg = paramf;
          if (!this.bXj) {
            break label358;
          }
          paramf = ac.c(paramClass1, "has".concat(String.valueOf(paramString1)), new Class[0]);
          label217:
          this.bXh = paramf;
          this.bWI = ac.c(paramClass1, "clear".concat(String.valueOf(paramString1)), new Class[0]);
          if (!this.bXi) {
            break label363;
          }
        }
        label341:
        label347:
        label353:
        label358:
        label363:
        for (paramf = ac.c(paramClass, "get" + paramString2 + "Case", new Class[0]);; paramf = null)
        {
          this.bWG = paramf;
          paramf = localObject;
          if (this.bXi) {
            paramf = ac.c(paramClass1, "get" + paramString2 + "Case", new Class[0]);
          }
          this.bWH = paramf;
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
      
      public at.a GD()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public void a(ac.a parama, Object paramObject)
      {
        ac.b(this.bXf, parama, new Object[] { paramObject });
      }
      
      public Object b(ac.a parama)
      {
        return ac.b(this.bWT, parama, new Object[0]);
      }
      
      public Object b(ac paramac)
      {
        return ac.b(this.bWS, paramac, new Object[0]);
      }
      
      public final void b(ac.a parama, Object paramObject)
      {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }
      
      public Object c(ac paramac)
      {
        return b(paramac);
      }
      
      public final boolean c(ac.a parama)
      {
        if (!this.bXj)
        {
          if (this.bXi) {
            return ((ae.a)ac.b(this.bWH, parama, new Object[0])).getNumber() == this.bWE.bSP.bPE;
          }
          return !b(parama).equals(this.bWE.getDefaultValue());
        }
        return ((Boolean)ac.b(this.bXh, parama, new Object[0])).booleanValue();
      }
      
      public final boolean d(ac paramac)
      {
        if (!this.bXj)
        {
          if (this.bXi) {
            return ((ae.a)ac.b(this.bWG, paramac, new Object[0])).getNumber() == this.bWE.bSP.bPE;
          }
          return !b(paramac).equals(this.bWE.getDefaultValue());
        }
        return ((Boolean)ac.b(this.bXg, paramac, new Object[0])).booleanValue();
      }
    }
    
    static final class i
      extends ac.f.h
    {
      private final Method bXa = ac.c(this.bWR, "newBuilder", new Class[0]);
      private final Method bXb;
      
      i(l.f paramf, String paramString1, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.bXb = ac.c(paramClass1, "get" + paramString1 + "Builder", new Class[0]);
      }
      
      public final at.a GD()
      {
        return (at.a)ac.b(this.bXa, null, new Object[0]);
      }
      
      public final void a(ac.a parama, Object paramObject)
      {
        if (this.bWR.isInstance(paramObject)) {}
        for (;;)
        {
          super.a(parama, paramObject);
          return;
          paramObject = ((at.a)ac.b(this.bXa, null, new Object[0])).c((at)paramObject).Bm();
        }
      }
    }
    
    static final class j
      extends ac.f.h
    {
      private final Method bXk;
      private final Method bXl;
      private final Method bXm;
      
      j(l.f paramf, String paramString1, Class<? extends ac> paramClass, Class<? extends ac.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.bXk = ac.c(paramClass, "get" + paramString1 + "Bytes", new Class[0]);
        this.bXl = ac.c(paramClass1, "get" + paramString1 + "Bytes", new Class[0]);
        this.bXm = ac.c(paramClass1, "set" + paramString1 + "Bytes", new Class[] { g.class });
      }
      
      public final void a(ac.a parama, Object paramObject)
      {
        if ((paramObject instanceof g))
        {
          ac.b(this.bXm, parama, new Object[] { paramObject });
          return;
        }
        super.a(parama, paramObject);
      }
      
      public final Object c(ac paramac)
      {
        return ac.b(this.bXk, paramac, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.ac
 * JD-Core Version:    0.7.0.1
 */