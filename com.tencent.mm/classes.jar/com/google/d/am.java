package com.google.d;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

public final class am
{
  private static final Logger logger = Logger.getLogger(am.class.getName());
  
  public static final class a
    extends am.h
  {
    n.a dOc;
    final am.g dOd;
    private final a dOe;
    private final a[] dOf;
    private final am.d[] dOg;
    private final am.f[] dOh;
    private final am.f[] dOi;
    private final am.j[] dOj;
    final String fullName;
    private final int index;
    
    private a(n.a parama, am.g paramg, a parama1, int paramInt)
    {
      this.index = paramInt;
      this.dOc = parama;
      this.fullName = am.a(paramg, parama1, parama.getName());
      this.dOd = paramg;
      this.dOe = parama1;
      this.dOj = new am.j[parama.abS()];
      paramInt = 0;
      while (paramInt < parama.abS())
      {
        this.dOj[paramInt] = new am.j(parama.kG(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      this.dOf = new a[parama.abP()];
      paramInt = 0;
      while (paramInt < parama.abP())
      {
        this.dOf[paramInt] = new a(parama.kE(paramInt), paramg, this, paramInt);
        paramInt += 1;
      }
      this.dOg = new am.d[parama.abQ()];
      paramInt = 0;
      while (paramInt < parama.abQ())
      {
        this.dOg[paramInt] = new am.d(parama.kF(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      this.dOh = new am.f[parama.abN()];
      paramInt = 0;
      while (paramInt < parama.abN())
      {
        this.dOh[paramInt] = new am.f(parama.kC(paramInt), paramg, this, paramInt, false, 0);
        paramInt += 1;
      }
      this.dOi = new am.f[parama.abO()];
      paramInt = 0;
      while (paramInt < parama.abO())
      {
        this.dOi[paramInt] = new am.f(parama.kD(paramInt), paramg, this, paramInt, true, 0);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < parama.abS())
      {
        am.j.a(this.dOj[paramInt], new am.f[this.dOj[paramInt].dPD]);
        am.j.y(this.dOj[paramInt]);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < parama.abN())
      {
        parama1 = this.dOh[paramInt].dOG;
        if (parama1 != null) {
          am.j.z(parama1)[am.j.A(parama1)] = this.dOh[paramInt];
        }
        paramInt += 1;
      }
      am.g.b(paramg).c(this);
    }
    
    a(String paramString)
    {
      String str1 = "";
      int i = paramString.lastIndexOf('.');
      String str2;
      if (i != -1)
      {
        str2 = paramString.substring(i + 1);
        str1 = paramString.substring(0, i);
      }
      for (;;)
      {
        this.index = 0;
        this.dOc = n.a.abV().dX(str2).a(n.a.b.act().kH(1).kI(536870912).acx()).abZ();
        this.fullName = paramString;
        this.dOe = null;
        this.dOf = new a[0];
        this.dOg = new am.d[0];
        this.dOh = new am.f[0];
        this.dOi = new am.f[0];
        this.dOj = new am.j[0];
        this.dOd = new am.g(str1, this);
        return;
        str2 = paramString;
      }
    }
    
    private void ahd()
    {
      int j = 0;
      Object localObject = this.dOf;
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        localObject[i].ahd();
        i += 1;
      }
      localObject = this.dOh;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        am.f.C(localObject[i]);
        i += 1;
      }
      localObject = this.dOi;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        am.f.C(localObject[i]);
        i += 1;
      }
    }
    
    public final String agY()
    {
      return this.fullName;
    }
    
    public final am.g agZ()
    {
      return this.dOd;
    }
    
    public final List<am.j> aha()
    {
      return Collections.unmodifiableList(Arrays.asList(this.dOj));
    }
    
    public final List<a> ahb()
    {
      return Collections.unmodifiableList(Arrays.asList(this.dOf));
    }
    
    public final boolean ahc()
    {
      return this.dOc.dKN.size() != 0;
    }
    
    public final am.f eb(String paramString)
    {
      paramString = am.g.b(this.dOd).ec(this.fullName + '.' + paramString);
      if ((paramString != null) && ((paramString instanceof am.f))) {
        return (am.f)paramString;
      }
      return null;
    }
    
    public final List<am.f> getFields()
    {
      return Collections.unmodifiableList(Arrays.asList(this.dOh));
    }
    
    public final String getName()
    {
      return this.dOc.getName();
    }
    
    public final boolean la(int paramInt)
    {
      Iterator localIterator = this.dOc.dKN.iterator();
      while (localIterator.hasNext())
      {
        n.a.b localb = (n.a.b)localIterator.next();
        if ((localb.dLb <= paramInt) && (paramInt < localb.dLc)) {
          return true;
        }
      }
      return false;
    }
    
    public final am.f lb(int paramInt)
    {
      return (am.f)am.g.b(this.dOd).dOn.get(new am.b.a(this, paramInt));
    }
  }
  
  static final class b
  {
    private final Set<am.g> dOk = new HashSet();
    private boolean dOl = true;
    private final Map<String, am.h> dOm = new HashMap();
    final Map<a, am.f> dOn = new HashMap();
    final Map<a, am.e> dOo = new HashMap();
    
    b(am.g[] paramArrayOfg)
    {
      int i = 0;
      while (i < paramArrayOfg.length)
      {
        this.dOk.add(paramArrayOfg[i]);
        a(paramArrayOfg[i]);
        i += 1;
      }
      paramArrayOfg = this.dOk.iterator();
      while (paramArrayOfg.hasNext())
      {
        am.g localg = (am.g)paramArrayOfg.next();
        try
        {
          a(localg.dPo.getPackage(), localg);
        }
        catch (am.c paramArrayOfg)
        {
          throw new AssertionError(paramArrayOfg);
        }
      }
    }
    
    private am.h a(String paramString, c paramc)
    {
      am.h localh2 = (am.h)this.dOm.get(paramString);
      am.h localh1;
      if (localh2 != null)
      {
        localh1 = localh2;
        if (paramc != c.dOs) {
          if (paramc == c.dOq)
          {
            localh1 = localh2;
            if (a(localh2)) {}
          }
          else
          {
            if ((paramc != c.dOr) || (!b(localh2))) {
              break label68;
            }
            localh1 = localh2;
          }
        }
        return localh1;
      }
      label68:
      Iterator localIterator = this.dOk.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localh2 = (am.h)am.g.b((am.g)localIterator.next()).dOm.get(paramString);
          if (localh2 != null)
          {
            localh1 = localh2;
            if (paramc == c.dOs) {
              break;
            }
            if (paramc == c.dOq)
            {
              localh1 = localh2;
              if (a(localh2)) {
                break;
              }
            }
            if ((paramc == c.dOr) && (b(localh2))) {
              return localh2;
            }
          }
        }
      }
      return null;
    }
    
    private void a(am.g paramg)
    {
      paramg = Collections.unmodifiableList(Arrays.asList(paramg.dPs)).iterator();
      while (paramg.hasNext())
      {
        am.g localg = (am.g)paramg.next();
        if (this.dOk.add(localg)) {
          a(localg);
        }
      }
    }
    
    private static boolean a(am.h paramh)
    {
      return ((paramh instanceof am.a)) || ((paramh instanceof am.d));
    }
    
    private static boolean b(am.h paramh)
    {
      return ((paramh instanceof am.a)) || ((paramh instanceof am.d)) || ((paramh instanceof b)) || ((paramh instanceof am.k));
    }
    
    private static void d(am.h paramh)
    {
      String str = paramh.getName();
      if (str.length() == 0) {
        throw new am.c(paramh, "Missing name.", (byte)0);
      }
      int i = 0;
      while (i < str.length())
      {
        int j = str.charAt(i);
        if (((97 > j) || (j > 122)) && ((65 > j) || (j > 90)) && (j != 95) && ((48 > j) || (j > 57) || (i <= 0))) {
          throw new am.c(paramh, "\"" + str + "\" is not a valid identifier.", (byte)0);
        }
        i += 1;
      }
    }
    
    final am.h a(String paramString, am.h paramh, c paramc)
    {
      Object localObject2;
      Object localObject3;
      label134:
      int j;
      if (paramString.startsWith("."))
      {
        localObject2 = paramString.substring(1);
        localObject1 = a((String)localObject2, paramc);
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          if ((this.dOl) && (paramc == c.dOq))
          {
            am.agX().warning("The descriptor for message type \"" + paramString + "\" can not be found and a placeholder is created for it");
            localObject3 = new am.a((String)localObject2);
            this.dOk.add(((am.h)localObject3).agZ());
          }
        }
        else {
          return localObject3;
        }
      }
      else
      {
        int i = paramString.indexOf('.');
        if (i == -1) {}
        for (localObject1 = paramString;; localObject1 = paramString.substring(0, i))
        {
          localObject3 = new StringBuilder(paramh.agY());
          j = ((StringBuilder)localObject3).lastIndexOf(".");
          if (j != -1) {
            break label175;
          }
          localObject1 = a(paramString, paramc);
          localObject2 = paramString;
          break;
        }
        label175:
        ((StringBuilder)localObject3).setLength(j + 1);
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject2 = a(((StringBuilder)localObject3).toString(), c.dOr);
        if (localObject2 != null)
        {
          if (i == -1) {
            break label296;
          }
          ((StringBuilder)localObject3).setLength(j + 1);
          ((StringBuilder)localObject3).append(paramString);
        }
      }
      label296:
      for (Object localObject1 = a(((StringBuilder)localObject3).toString(), paramc);; localObject1 = localObject2)
      {
        localObject2 = ((StringBuilder)localObject3).toString();
        break;
        ((StringBuilder)localObject3).setLength(j);
        break label134;
        throw new am.c(paramh, "\"" + paramString + "\" is not defined.", (byte)0);
      }
    }
    
    final void a(String paramString, am.g paramg)
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1) {}
      for (String str = paramString;; str = paramString.substring(i + 1))
      {
        am.h localh = (am.h)this.dOm.put(paramString, new b(str, paramString, paramg));
        if (localh == null) {
          break;
        }
        this.dOm.put(paramString, localh);
        if ((localh instanceof b)) {
          break;
        }
        throw new am.c(paramg, "\"" + str + "\" is already defined (as something other than a package) in file \"" + localh.agZ().dPo.getName() + "\".", (byte)0);
        a(paramString.substring(0, i), paramg);
      }
    }
    
    final void c(am.h paramh)
    {
      d(paramh);
      String str = paramh.agY();
      am.h localh = (am.h)this.dOm.put(str, paramh);
      if (localh != null)
      {
        this.dOm.put(str, localh);
        if (paramh.agZ() == localh.agZ())
        {
          int i = str.lastIndexOf('.');
          if (i == -1) {
            throw new am.c(paramh, "\"" + str + "\" is already defined.", (byte)0);
          }
          throw new am.c(paramh, "\"" + str.substring(i + 1) + "\" is already defined in \"" + str.substring(0, i) + "\".", (byte)0);
        }
        throw new am.c(paramh, "\"" + str + "\" is already defined in file \"" + localh.agZ().dPo.getName() + "\".", (byte)0);
      }
    }
    
    final am.h ec(String paramString)
    {
      return a(paramString, c.dOs);
    }
    
    static final class a
    {
      private final am.h dOp;
      private final int number;
      
      a(am.h paramh, int paramInt)
      {
        this.dOp = paramh;
        this.number = paramInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a)) {}
        do
        {
          return false;
          paramObject = (a)paramObject;
        } while ((this.dOp != paramObject.dOp) || (this.number != paramObject.number));
        return true;
      }
      
      public final int hashCode()
      {
        return this.dOp.hashCode() * 65535 + this.number;
      }
    }
    
    static final class b
      extends am.h
    {
      private final am.g dOd;
      private final String fullName;
      private final String name;
      
      b(String paramString1, String paramString2, am.g paramg)
      {
        this.dOd = paramg;
        this.fullName = paramString2;
        this.name = paramString1;
      }
      
      public final String agY()
      {
        return this.fullName;
      }
      
      public final am.g agZ()
      {
        return this.dOd;
      }
      
      public final cb ahe()
      {
        return this.dOd.dPo;
      }
      
      public final String getName()
      {
        return this.name;
      }
    }
    
    static enum c
    {
      private c() {}
    }
  }
  
  public static final class c
    extends Exception
  {
    private final cb dOu;
    private final String description;
    private final String name;
    
    private c(am.g paramg, String paramString)
    {
      super();
      this.name = paramg.dPo.getName();
      this.dOu = paramg.dPo;
      this.description = paramString;
    }
    
    private c(am.h paramh, String paramString)
    {
      super();
      this.name = paramh.agY();
      this.dOu = paramh.ahe();
      this.description = paramString;
    }
    
    private c(am.h paramh, String paramString, Throwable paramThrowable)
    {
      this(paramh, paramString);
      initCause(paramThrowable);
    }
  }
  
  public static final class d
    extends am.h
    implements bj.d<am.e>
  {
    final am.g dOd;
    private final am.a dOe;
    n.b dOv;
    am.e[] dOw;
    private final WeakHashMap<Integer, WeakReference<am.e>> dOx = new WeakHashMap();
    final String fullName;
    private final int index;
    
    private d(n.b paramb, am.g paramg, am.a parama, int paramInt)
    {
      this.index = paramInt;
      this.dOv = paramb;
      this.fullName = am.a(paramg, parama, paramb.getName());
      this.dOd = paramg;
      this.dOe = parama;
      if (paramb.acE() == 0) {
        throw new am.c(this, "Enums must contain at least one value.", (byte)0);
      }
      this.dOw = new am.e[paramb.acE()];
      paramInt = 0;
      while (paramInt < paramb.acE())
      {
        this.dOw[paramInt] = new am.e(paramb.kL(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      am.g.b(paramg).c(this);
    }
    
    public final String agY()
    {
      return this.fullName;
    }
    
    public final am.g agZ()
    {
      return this.dOd;
    }
    
    public final String getName()
    {
      return this.dOv.getName();
    }
    
    public final am.e lc(int paramInt)
    {
      return (am.e)am.g.b(this.dOd).dOo.get(new am.b.a(this, paramInt));
    }
    
    public final am.e ld(int paramInt)
    {
      am.e locale = lc(paramInt);
      if (locale != null) {
        return locale;
      }
      for (;;)
      {
        try
        {
          Integer localInteger = Integer.valueOf(paramInt);
          Object localObject2 = (WeakReference)this.dOx.get(localInteger);
          if (localObject2 != null)
          {
            locale = (am.e)((WeakReference)localObject2).get();
            localObject2 = locale;
            if (locale == null)
            {
              localObject2 = new am.e(this.dOd, this, localInteger, (byte)0);
              this.dOx.put(localInteger, new WeakReference(localObject2));
            }
            return localObject2;
          }
        }
        finally {}
      }
    }
  }
  
  public static final class e
    extends am.h
    implements bj.c
  {
    private final am.g dOd;
    n.d dOy;
    final am.d dOz;
    private final String fullName;
    private final int index;
    
    private e(am.g paramg, am.d paramd, Integer paramInteger)
    {
      String str = "UNKNOWN_ENUM_VALUE_" + paramd.dOv.getName() + "_" + paramInteger;
      paramInteger = n.d.adg().dY(str).kO(paramInteger.intValue()).adk();
      this.index = -1;
      this.dOy = paramInteger;
      this.dOd = paramg;
      this.dOz = paramd;
      this.fullName = (paramd.fullName + '.' + paramInteger.getName());
    }
    
    private e(n.d paramd, am.g paramg, am.d paramd1, int paramInt)
    {
      this.index = paramInt;
      this.dOy = paramd;
      this.dOd = paramg;
      this.dOz = paramd1;
      this.fullName = (paramd1.fullName + '.' + paramd.getName());
      am.g.b(paramg).c(this);
      paramd = am.g.b(paramg);
      paramg = new am.b.a(this.dOz, this.dOy.dLq);
      paramd1 = (e)paramd.dOo.put(paramg, this);
      if (paramd1 != null) {
        paramd.dOo.put(paramg, paramd1);
      }
    }
    
    public final String agY()
    {
      return this.fullName;
    }
    
    public final am.g agZ()
    {
      return this.dOd;
    }
    
    public final String getName()
    {
      return this.dOy.getName();
    }
    
    public final int getNumber()
    {
      return this.dOy.dLq;
    }
    
    public final String toString()
    {
      return this.dOy.getName();
    }
  }
  
  public static final class f
    extends am.h
    implements az.a<f>, Comparable<f>
  {
    private static final du.a[] dOA = ;
    n.g dOB;
    private final String dOC;
    private final am.a dOD;
    b dOE;
    private am.a dOF;
    am.j dOG;
    private am.d dOH;
    private Object dOI;
    final am.g dOd;
    am.a dOe;
    final String fullName;
    final int index;
    
    static
    {
      if (b.values().length != n.g.c.values().length) {
        throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
      }
    }
    
    private f(n.g paramg, am.g paramg1, am.a parama, int paramInt, boolean paramBoolean)
    {
      this.index = paramInt;
      this.dOB = paramg;
      this.fullName = am.a(paramg1, parama, paramg.getName());
      this.dOd = paramg1;
      if (paramg.adF()) {}
      StringBuilder localStringBuilder;
      for (this.dOC = paramg.adG();; this.dOC = localStringBuilder.toString())
      {
        if (paramg.ady()) {
          this.dOE = b.b(paramg.adz());
        }
        if (this.dOB.dLq > 0) {
          break;
        }
        throw new am.c(this, "Field numbers must be positive integers.", (byte)0);
        String str = paramg.getName();
        int j = str.length();
        localStringBuilder = new StringBuilder(j);
        int i = 0;
        paramInt = 0;
        if (i < j)
        {
          char c2 = str.charAt(i);
          if (c2 == '_') {
            paramInt = 1;
          }
          for (;;)
          {
            i += 1;
            break;
            if (paramInt != 0)
            {
              char c1 = c2;
              if ('a' <= c2)
              {
                c1 = c2;
                if (c2 <= 'z') {
                  c1 = (char)(c2 - 'a' + 65);
                }
              }
              localStringBuilder.append(c1);
              paramInt = 0;
            }
            else
            {
              localStringBuilder.append(c2);
            }
          }
        }
      }
      if (paramBoolean)
      {
        if (!paramg.adB()) {
          throw new am.c(this, "FieldDescriptorProto.extendee not set for extension field.", (byte)0);
        }
        this.dOe = null;
        if (parama != null) {}
        for (this.dOD = parama; paramg.adE(); this.dOD = null) {
          throw new am.c(this, "FieldDescriptorProto.oneof_index set for extension field.", (byte)0);
        }
        this.dOG = null;
        am.g.b(paramg1).c(this);
        return;
      }
      if (paramg.adB()) {
        throw new am.c(this, "FieldDescriptorProto.extendee set for non-extension field.", (byte)0);
      }
      this.dOe = parama;
      if (paramg.adE())
      {
        if ((paramg.dLz < 0) || (paramg.dLz >= parama.dOc.abS())) {
          throw new am.c(this, "FieldDescriptorProto.oneof_index is out of range for type " + parama.dOc.getName(), (byte)0);
        }
        this.dOG = ((am.j)parama.aha().get(paramg.dLz));
        am.j.A(this.dOG);
      }
      for (;;)
      {
        this.dOD = null;
        break;
        this.dOG = null;
      }
    }
    
    public final ce.a a(ce.a parama, ce paramce)
    {
      return ((cb.a)parama).mergeFrom((cb)paramce);
    }
    
    public final String agY()
    {
      return this.fullName;
    }
    
    public final am.g agZ()
    {
      return this.dOd;
    }
    
    public final du.b ahf()
    {
      return ahg().dWY;
    }
    
    public final du.a ahg()
    {
      return dOA[this.dOE.ordinal()];
    }
    
    public final boolean ahh()
    {
      boolean bool2 = true;
      boolean bool1;
      if (this.dOE != b.dPc) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.dOe.dOc.abU().dNh);
        bool1 = bool2;
      } while (this.dOd.aht() == am.g.a.dPw);
      return this.dOd.dPo.aee().dMK;
    }
    
    public final boolean ahi()
    {
      return (this.dOE == b.dPe) && (ahl()) && (ahq().dOc.abU().dNh);
    }
    
    public final boolean ahj()
    {
      return this.dOB.adx() == n.g.b.dLE;
    }
    
    public final boolean ahk()
    {
      return this.dOB.adx() == n.g.b.dLD;
    }
    
    public final boolean ahl()
    {
      return this.dOB.adx() == n.g.b.dLF;
    }
    
    public final boolean ahm()
    {
      if (!ahn()) {}
      do
      {
        return false;
        if (this.dOd.aht() == am.g.a.dPv) {
          return this.dOB.adH().dMe;
        }
      } while ((this.dOB.adH().adP()) && (!this.dOB.adH().dMe));
      return true;
    }
    
    public final boolean ahn()
    {
      return (ahl()) && (ahg().ahn());
    }
    
    public final Object aho()
    {
      if (this.dOE.dPm == a.dOR) {
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
      }
      return this.dOI;
    }
    
    public final am.a ahp()
    {
      if (!this.dOB.adB()) {
        throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[] { this.fullName }));
      }
      return this.dOD;
    }
    
    public final am.a ahq()
    {
      if (this.dOE.dPm != a.dOR) {
        throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", new Object[] { this.fullName }));
      }
      return this.dOF;
    }
    
    public final am.d ahr()
    {
      if (this.dOE.dPm != a.dOQ) {
        throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[] { this.fullName }));
      }
      return this.dOH;
    }
    
    public final String getName()
    {
      return this.dOB.getName();
    }
    
    public final int getNumber()
    {
      return this.dOB.dLq;
    }
    
    public final String toString()
    {
      return this.fullName;
    }
    
    public static enum a
    {
      private final Object dOS;
      
      private a(Object paramObject)
      {
        this.dOS = paramObject;
      }
    }
    
    public static enum b
    {
      am.f.a dPm;
      
      private b(am.f.a parama)
      {
        this.dPm = parama;
      }
      
      public static b b(n.g.c paramc)
      {
        return values()[(paramc.value - 1)];
      }
    }
  }
  
  public static final class g
    extends am.h
  {
    private final am.d[] dOg;
    private final am.f[] dOi;
    n.i dPo;
    private final am.a[] dPp;
    private final am.k[] dPq;
    private final g[] dPr;
    final g[] dPs;
    private final am.b dPt;
    
    private g(n.i parami, g[] paramArrayOfg, am.b paramb)
    {
      this.dPt = paramb;
      this.dPo = parami;
      this.dPr = ((g[])paramArrayOfg.clone());
      HashMap localHashMap = new HashMap();
      int j = paramArrayOfg.length;
      int i = 0;
      g localg;
      while (i < j)
      {
        localg = paramArrayOfg[i];
        localHashMap.put(localg.dPo.getName(), localg);
        i += 1;
      }
      paramArrayOfg = new ArrayList();
      i = 0;
      while (i < parami.aeb())
      {
        j = parami.dMv.getInt(i);
        if ((j < 0) || (j >= parami.aea())) {
          throw new am.c(this, "Invalid public dependency index.", (byte)0);
        }
        localg = (g)localHashMap.get((String)parami.dMu.get(j));
        if (localg != null) {
          paramArrayOfg.add(localg);
        }
        i += 1;
      }
      this.dPs = new g[paramArrayOfg.size()];
      paramArrayOfg.toArray(this.dPs);
      paramb.a(this.dPo.getPackage(), this);
      this.dPp = new am.a[parami.aec()];
      i = 0;
      while (i < parami.aec())
      {
        this.dPp[i] = new am.a(parami.kV(i), this, i);
        i += 1;
      }
      this.dOg = new am.d[parami.abQ()];
      i = 0;
      while (i < parami.abQ())
      {
        this.dOg[i] = new am.d(parami.kF(i), this, null, i, 0);
        i += 1;
      }
      this.dPq = new am.k[parami.aed()];
      i = 0;
      while (i < parami.aed())
      {
        this.dPq[i] = new am.k(parami.kW(i), this, i, 0);
        i += 1;
      }
      this.dOi = new am.f[parami.abO()];
      i = 0;
      while (i < parami.abO())
      {
        this.dOi[i] = new am.f(parami.kD(i), this, null, i, true, 0);
        i += 1;
      }
    }
    
    g(String paramString, am.a parama)
    {
      this.dPt = new am.b(new g[0]);
      this.dPo = n.i.aej().dZ(parama.fullName + ".placeholder.proto").ea(paramString).k(parama.dOc).aen();
      this.dPr = new g[0];
      this.dPs = new g[0];
      this.dPp = new am.a[] { parama };
      this.dOg = new am.d[0];
      this.dPq = new am.k[0];
      this.dOi = new am.f[0];
      this.dPt.a(paramString, this);
      this.dPt.c(parama);
    }
    
    private static g a(n.i parami, g[] paramArrayOfg)
    {
      parami = new g(parami, paramArrayOfg, new am.b(paramArrayOfg));
      paramArrayOfg = parami.dPp;
      int j = paramArrayOfg.length;
      int i = 0;
      while (i < j)
      {
        am.a.c(paramArrayOfg[i]);
        i += 1;
      }
      paramArrayOfg = parami.dPq;
      int k = paramArrayOfg.length;
      i = 0;
      while (i < k)
      {
        am.i[] arrayOfi = paramArrayOfg[i].dPF;
        int m = arrayOfi.length;
        j = 0;
        while (j < m)
        {
          am.i locali = arrayOfi[j];
          am.h localh = locali.dOd.dPt.a(locali.dPy.afp(), locali, am.b.c.dOq);
          if (!(localh instanceof am.a)) {
            throw new am.c(locali, "\"" + locali.dPy.afp() + "\" is not a message type.", (byte)0);
          }
          locali.dPA = ((am.a)localh);
          localh = locali.dOd.dPt.a(locali.dPy.afr(), locali, am.b.c.dOq);
          if (!(localh instanceof am.a)) {
            throw new am.c(locali, "\"" + locali.dPy.afr() + "\" is not a message type.", (byte)0);
          }
          locali.dPB = ((am.a)localh);
          j += 1;
        }
        i += 1;
      }
      paramArrayOfg = parami.dOi;
      j = paramArrayOfg.length;
      i = 0;
      while (i < j)
      {
        am.f.C(paramArrayOfg[i]);
        i += 1;
      }
      return parami;
    }
    
    /* Error */
    public static g a(String[] paramArrayOfString, g[] paramArrayOfg)
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: aaload
      //   3: getstatic 292	com/google/d/bj:ISO_8859_1	Ljava/nio/charset/Charset;
      //   6: invokevirtual 296	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   9: astore_0
      //   10: aload_0
      //   11: invokestatic 300	com/google/d/n$i:E	([B)Lcom/google/d/n$i;
      //   14: astore_0
      //   15: aload_0
      //   16: aload_1
      //   17: invokestatic 302	com/google/d/am$g:a	(Lcom/google/d/n$i;[Lcom/google/d/am$g;)Lcom/google/d/am$g;
      //   20: astore_1
      //   21: aload_1
      //   22: areturn
      //   23: astore_0
      //   24: new 304	java/lang/IllegalArgumentException
      //   27: dup
      //   28: ldc_w 306
      //   31: aload_0
      //   32: invokespecial 309	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   35: athrow
      //   36: astore_1
      //   37: new 304	java/lang/IllegalArgumentException
      //   40: dup
      //   41: new 186	java/lang/StringBuilder
      //   44: dup
      //   45: ldc_w 311
      //   48: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   51: aload_0
      //   52: invokevirtual 50	com/google/d/n$i:getName	()Ljava/lang/String;
      //   55: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: ldc_w 313
      //   61: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   64: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   67: aload_1
      //   68: invokespecial 309	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   71: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	72	0	paramArrayOfString	String[]
      //   0	72	1	paramArrayOfg	g[]
      // Exception table:
      //   from	to	target	type
      //   10	15	23	com/google/d/bk
      //   15	21	36	com/google/d/am$c
    }
    
    public final String agY()
    {
      return this.dPo.getName();
    }
    
    public final g agZ()
    {
      return this;
    }
    
    public final List<am.a> ahs()
    {
      return Collections.unmodifiableList(Arrays.asList(this.dPp));
    }
    
    public final a aht()
    {
      if (a.a(a.dPw).equals(this.dPo.aei())) {
        return a.dPw;
      }
      return a.dPv;
    }
    
    final boolean ahu()
    {
      return aht() == a.dPw;
    }
    
    public final String getName()
    {
      return this.dPo.getName();
    }
    
    public static enum a
    {
      private final String name;
      
      private a(String paramString)
      {
        this.name = paramString;
      }
    }
  }
  
  public static abstract class h
  {
    public abstract String agY();
    
    public abstract am.g agZ();
    
    public abstract cb ahe();
    
    public abstract String getName();
  }
  
  public static final class i
    extends am.h
  {
    final am.g dOd;
    am.a dPA;
    am.a dPB;
    n.l dPy;
    private final am.k dPz;
    private final String fullName;
    private final int index;
    
    private i(n.l paraml, am.g paramg, am.k paramk, int paramInt)
    {
      this.index = paramInt;
      this.dPy = paraml;
      this.dOd = paramg;
      this.dPz = paramk;
      this.fullName = (paramk.fullName + '.' + paraml.getName());
      am.g.b(paramg).c(this);
    }
    
    public final String agY()
    {
      return this.fullName;
    }
    
    public final am.g agZ()
    {
      return this.dOd;
    }
    
    public final String getName()
    {
      return this.dPy.getName();
    }
  }
  
  public static final class j
  {
    private final am.g dOd;
    am.a dOe;
    private am.f[] dOh;
    n.n dPC;
    int dPD;
    private final String fullName;
    final int index;
    
    private j(n.n paramn, am.g paramg, am.a parama, int paramInt)
    {
      this.dPC = paramn;
      this.fullName = am.a(paramg, parama, paramn.getName());
      this.dOd = paramg;
      this.index = paramInt;
      this.dOe = parama;
      this.dPD = 0;
    }
  }
  
  public static final class k
    extends am.h
  {
    private final am.g dOd;
    private n.p dPE;
    am.i[] dPF;
    final String fullName;
    private final int index;
    
    private k(n.p paramp, am.g paramg, int paramInt)
    {
      this.index = paramInt;
      this.dPE = paramp;
      this.fullName = am.a(paramg, null, paramp.getName());
      this.dOd = paramg;
      this.dPF = new am.i[paramp.afS()];
      paramInt = 0;
      while (paramInt < paramp.afS())
      {
        this.dPF[paramInt] = new am.i(paramp.kZ(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      am.g.b(paramg).c(this);
    }
    
    public final String agY()
    {
      return this.fullName;
    }
    
    public final am.g agZ()
    {
      return this.dOd;
    }
    
    public final String getName()
    {
      return this.dPE.getName();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.am
 * JD-Core Version:    0.7.0.1
 */