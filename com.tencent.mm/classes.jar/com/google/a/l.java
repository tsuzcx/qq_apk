package com.google.a;

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

public final class l
{
  private static final Logger logger = Logger.getLogger(l.class.getName());
  
  public static final class a
    extends l.h
  {
    k.a bSq;
    final l.g bSr;
    private final a bSs;
    private final a[] bSt;
    private final l.d[] bSu;
    private final l.f[] bSv;
    private final l.f[] bSw;
    private final l.j[] bSx;
    final String fullName;
    private final int index;
    
    private a(k.a parama, l.g paramg, a parama1, int paramInt)
    {
      this.index = paramInt;
      this.bSq = parama;
      this.fullName = l.a(paramg, parama1, parama.getName());
      this.bSr = paramg;
      this.bSs = parama1;
      this.bSx = new l.j[parama.AE()];
      paramInt = 0;
      while (paramInt < parama.AE())
      {
        this.bSx[paramInt] = new l.j(parama.ge(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      this.bSt = new a[parama.AB()];
      paramInt = 0;
      while (paramInt < parama.AB())
      {
        this.bSt[paramInt] = new a(parama.gc(paramInt), paramg, this, paramInt);
        paramInt += 1;
      }
      this.bSu = new l.d[parama.AC()];
      paramInt = 0;
      while (paramInt < parama.AC())
      {
        this.bSu[paramInt] = new l.d(parama.gd(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      this.bSv = new l.f[parama.getFieldCount()];
      paramInt = 0;
      while (paramInt < parama.getFieldCount())
      {
        this.bSv[paramInt] = new l.f(parama.ga(paramInt), paramg, this, paramInt, false, 0);
        paramInt += 1;
      }
      this.bSw = new l.f[parama.AA()];
      paramInt = 0;
      while (paramInt < parama.AA())
      {
        this.bSw[paramInt] = new l.f(parama.gb(paramInt), paramg, this, paramInt, true, 0);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < parama.AE())
      {
        this.bSx[paramInt].bSv = new l.f[this.bSx[paramInt].bTQ];
        this.bSx[paramInt].bTQ = 0;
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < parama.getFieldCount())
      {
        parama1 = this.bSv[paramInt].bSU;
        if (parama1 != null) {
          parama1.bSv[l.j.c(parama1)] = this.bSv[paramInt];
        }
        paramInt += 1;
      }
      paramg.bTG.c(this);
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
        this.bSq = k.a.AH().ce(str2).a(k.a.b.Bs().gf(1).gg(536870912).Bv()).AT();
        this.fullName = paramString;
        this.bSs = null;
        this.bSt = new a[0];
        this.bSu = new l.d[0];
        this.bSv = new l.f[0];
        this.bSw = new l.f[0];
        this.bSx = new l.j[0];
        this.bSr = new l.g(str1, this);
        return;
        str2 = paramString;
      }
    }
    
    public final boolean FA()
    {
      return this.bSq.bOZ.size() != 0;
    }
    
    final void FB()
    {
      int j = 0;
      Object localObject = this.bSt;
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        localObject[i].FB();
        i += 1;
      }
      localObject = this.bSv;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        l.f.d(localObject[i]);
        i += 1;
      }
      localObject = this.bSw;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        l.f.d(localObject[i]);
        i += 1;
      }
    }
    
    public final String Fw()
    {
      return this.fullName;
    }
    
    public final l.g Fx()
    {
      return this.bSr;
    }
    
    public final List<l.j> Fy()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bSx));
    }
    
    public final List<a> Fz()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bSt));
    }
    
    public final l.f ci(String paramString)
    {
      paramString = this.bSr.bTG.cj(this.fullName + '.' + paramString);
      if ((paramString != null) && ((paramString instanceof l.f))) {
        return (l.f)paramString;
      }
      return null;
    }
    
    public final List<l.f> getFields()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bSv));
    }
    
    public final String getName()
    {
      return this.bSq.getName();
    }
    
    public final boolean gy(int paramInt)
    {
      Iterator localIterator = this.bSq.bOZ.iterator();
      while (localIterator.hasNext())
      {
        k.a.b localb = (k.a.b)localIterator.next();
        if ((localb.bPp <= paramInt) && (paramInt < localb.bPq)) {
          return true;
        }
      }
      return false;
    }
    
    public final l.f gz(int paramInt)
    {
      return (l.f)this.bSr.bTG.bSB.get(new l.b.a(this, paramInt));
    }
  }
  
  static final class b
  {
    private final Map<String, l.h> bSA = new HashMap();
    final Map<a, l.f> bSB = new HashMap();
    final Map<a, l.e> bSC = new HashMap();
    private final Set<l.g> bSy = new HashSet();
    private boolean bSz = true;
    
    b(l.g[] paramArrayOfg)
    {
      int i = 0;
      while (i < paramArrayOfg.length)
      {
        this.bSy.add(paramArrayOfg[i]);
        a(paramArrayOfg[i]);
        i += 1;
      }
      paramArrayOfg = this.bSy.iterator();
      while (paramArrayOfg.hasNext())
      {
        l.g localg = (l.g)paramArrayOfg.next();
        try
        {
          a(localg.bTB.getPackage(), localg);
        }
        catch (l.c paramArrayOfg)
        {
          throw new AssertionError(paramArrayOfg);
        }
      }
    }
    
    private l.h a(String paramString, l.b.c paramc)
    {
      l.h localh2 = (l.h)this.bSA.get(paramString);
      l.h localh1;
      if (localh2 != null)
      {
        localh1 = localh2;
        if (paramc != l.b.c.bSG) {
          if (paramc == l.b.c.bSE)
          {
            localh1 = localh2;
            if (a(localh2)) {}
          }
          else
          {
            if ((paramc != l.b.c.bSF) || (!b(localh2))) {
              break label68;
            }
            localh1 = localh2;
          }
        }
        return localh1;
      }
      label68:
      Iterator localIterator = this.bSy.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localh2 = (l.h)((l.g)localIterator.next()).bTG.bSA.get(paramString);
          if (localh2 != null)
          {
            localh1 = localh2;
            if (paramc == l.b.c.bSG) {
              break;
            }
            if (paramc == l.b.c.bSE)
            {
              localh1 = localh2;
              if (a(localh2)) {
                break;
              }
            }
            if ((paramc == l.b.c.bSF) && (b(localh2))) {
              return localh2;
            }
          }
        }
      }
      return null;
    }
    
    private void a(l.g paramg)
    {
      paramg = Collections.unmodifiableList(Arrays.asList(paramg.bTF)).iterator();
      while (paramg.hasNext())
      {
        l.g localg = (l.g)paramg.next();
        if (this.bSy.add(localg)) {
          a(localg);
        }
      }
    }
    
    private static boolean a(l.h paramh)
    {
      return ((paramh instanceof l.a)) || ((paramh instanceof l.d));
    }
    
    private static boolean b(l.h paramh)
    {
      return ((paramh instanceof l.a)) || ((paramh instanceof l.d)) || ((paramh instanceof b)) || ((paramh instanceof l.k));
    }
    
    private static void d(l.h paramh)
    {
      String str = paramh.getName();
      if (str.length() == 0) {
        throw new l.c(paramh, "Missing name.", (byte)0);
      }
      int i = 0;
      while (i < str.length())
      {
        int j = str.charAt(i);
        if (((97 > j) || (j > 122)) && ((65 > j) || (j > 90)) && (j != 95) && ((48 > j) || (j > 57) || (i <= 0))) {
          throw new l.c(paramh, "\"" + str + "\" is not a valid identifier.", (byte)0);
        }
        i += 1;
      }
    }
    
    final l.h a(String paramString, l.h paramh, l.b.c paramc)
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
          if ((this.bSz) && (paramc == l.b.c.bSE))
          {
            l.Fv().warning("The descriptor for message type \"" + paramString + "\" can not be found and a placeholder is created for it");
            localObject3 = new l.a((String)localObject2);
            this.bSy.add(((l.h)localObject3).Fx());
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
          localObject3 = new StringBuilder(paramh.Fw());
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
        localObject2 = a(((StringBuilder)localObject3).toString(), l.b.c.bSF);
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
        throw new l.c(paramh, "\"" + paramString + "\" is not defined.", (byte)0);
      }
    }
    
    final void a(String paramString, l.g paramg)
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1) {}
      for (String str = paramString;; str = paramString.substring(i + 1))
      {
        l.h localh = (l.h)this.bSA.put(paramString, new b(str, paramString, paramg));
        if (localh == null) {
          break;
        }
        this.bSA.put(paramString, localh);
        if ((localh instanceof b)) {
          break;
        }
        throw new l.c(paramg, "\"" + str + "\" is already defined (as something other than a package) in file \"" + localh.Fx().bTB.getName() + "\".", (byte)0);
        a(paramString.substring(0, i), paramg);
      }
    }
    
    final void c(l.h paramh)
    {
      d(paramh);
      String str = paramh.Fw();
      l.h localh = (l.h)this.bSA.put(str, paramh);
      if (localh != null)
      {
        this.bSA.put(str, localh);
        if (paramh.Fx() == localh.Fx())
        {
          int i = str.lastIndexOf('.');
          if (i == -1) {
            throw new l.c(paramh, "\"" + str + "\" is already defined.", (byte)0);
          }
          throw new l.c(paramh, "\"" + str.substring(i + 1) + "\" is already defined in \"" + str.substring(0, i) + "\".", (byte)0);
        }
        throw new l.c(paramh, "\"" + str + "\" is already defined in file \"" + localh.Fx().bTB.getName() + "\".", (byte)0);
      }
    }
    
    final l.h cj(String paramString)
    {
      return a(paramString, l.b.c.bSG);
    }
    
    static final class a
    {
      private final l.h bSD;
      private final int number;
      
      a(l.h paramh, int paramInt)
      {
        this.bSD = paramh;
        this.number = paramInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a)) {}
        do
        {
          return false;
          paramObject = (a)paramObject;
        } while ((this.bSD != paramObject.bSD) || (this.number != paramObject.number));
        return true;
      }
      
      public final int hashCode()
      {
        return this.bSD.hashCode() * 65535 + this.number;
      }
    }
    
    static final class b
      extends l.h
    {
      private final l.g bSr;
      private final String fullName;
      private final String name;
      
      b(String paramString1, String paramString2, l.g paramg)
      {
        this.bSr = paramg;
        this.fullName = paramString2;
        this.name = paramString1;
      }
      
      public final at FC()
      {
        return this.bSr.bTB;
      }
      
      public final String Fw()
      {
        return this.fullName;
      }
      
      public final l.g Fx()
      {
        return this.bSr;
      }
      
      public final String getName()
      {
        return this.name;
      }
    }
  }
  
  public static final class c
    extends Exception
  {
    private final at bSI;
    private final String description;
    private final String name;
    
    private c(l.g paramg, String paramString)
    {
      super();
      this.name = paramg.bTB.getName();
      this.bSI = paramg.bTB;
      this.description = paramString;
    }
    
    private c(l.h paramh, String paramString)
    {
      super();
      this.name = paramh.Fw();
      this.bSI = paramh.FC();
      this.description = paramString;
    }
    
    private c(l.h paramh, String paramString, Throwable paramThrowable)
    {
      this(paramh, paramString);
      initCause(paramThrowable);
    }
  }
  
  public static final class d
    extends l.h
    implements ae.b<l.e>
  {
    k.c bSJ;
    l.e[] bSK;
    private final WeakHashMap<Integer, WeakReference<l.e>> bSL = new WeakHashMap();
    final l.g bSr;
    private final l.a bSs;
    final String fullName;
    private final int index;
    
    private d(k.c paramc, l.g paramg, l.a parama, int paramInt)
    {
      this.index = paramInt;
      this.bSJ = paramc;
      this.fullName = l.a(paramg, parama, paramc.getName());
      this.bSr = paramg;
      this.bSs = parama;
      if (paramc.getValueCount() == 0) {
        throw new l.c(this, "Enums must contain at least one value.", (byte)0);
      }
      this.bSK = new l.e[paramc.getValueCount()];
      paramInt = 0;
      while (paramInt < paramc.getValueCount())
      {
        this.bSK[paramInt] = new l.e(paramc.gj(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      paramg.bTG.c(this);
    }
    
    public final String Fw()
    {
      return this.fullName;
    }
    
    public final l.g Fx()
    {
      return this.bSr;
    }
    
    public final l.e gA(int paramInt)
    {
      return (l.e)this.bSr.bTG.bSC.get(new l.b.a(this, paramInt));
    }
    
    public final l.e gB(int paramInt)
    {
      l.e locale = gA(paramInt);
      if (locale != null) {
        return locale;
      }
      for (;;)
      {
        try
        {
          Integer localInteger = Integer.valueOf(paramInt);
          Object localObject2 = (WeakReference)this.bSL.get(localInteger);
          if (localObject2 != null)
          {
            locale = (l.e)((WeakReference)localObject2).get();
            localObject2 = locale;
            if (locale == null)
            {
              localObject2 = new l.e(this.bSr, this, localInteger, (byte)0);
              this.bSL.put(localInteger, new WeakReference(localObject2));
            }
            return localObject2;
          }
        }
        finally {}
      }
    }
    
    public final String getName()
    {
      return this.bSJ.getName();
    }
  }
  
  public static final class e
    extends l.h
    implements ae.a
  {
    k.g bSM;
    final l.d bSN;
    private final l.g bSr;
    private final String fullName;
    private final int index;
    
    private e(k.g paramg, l.g paramg1, l.d paramd, int paramInt)
    {
      this.index = paramInt;
      this.bSM = paramg;
      this.bSr = paramg1;
      this.bSN = paramd;
      this.fullName = (paramd.fullName + '.' + paramg.getName());
      paramg1.bTG.c(this);
      paramg = paramg1.bTG;
      paramg1 = new l.b.a(this.bSN, this.bSM.bPE);
      paramd = (e)paramg.bSC.put(paramg1, this);
      if (paramd != null) {
        paramg.bSC.put(paramg1, paramd);
      }
    }
    
    private e(l.g paramg, l.d paramd, Integer paramInteger)
    {
      String str = "UNKNOWN_ENUM_VALUE_" + paramd.bSJ.getName() + "_" + paramInteger;
      paramInteger = k.g.BX().cf(str).gm(paramInteger.intValue()).Ca();
      this.index = -1;
      this.bSM = paramInteger;
      this.bSr = paramg;
      this.bSN = paramd;
      this.fullName = (paramd.fullName + '.' + paramInteger.getName());
    }
    
    public final String Fw()
    {
      return this.fullName;
    }
    
    public final l.g Fx()
    {
      return this.bSr;
    }
    
    public final String getName()
    {
      return this.bSM.getName();
    }
    
    public final int getNumber()
    {
      return this.bSM.bPE;
    }
    
    public final String toString()
    {
      return this.bSM.getName();
    }
  }
  
  public static final class f
    extends l.h
    implements x.a<f>, Comparable<f>
  {
    private static final cj.a[] bSO = ;
    private Object aEX;
    k.m bSP;
    private final String bSQ;
    private final l.a bSR;
    b bSS;
    private l.a bST;
    l.j bSU;
    private l.d bSV;
    final l.g bSr;
    l.a bSs;
    final String fullName;
    final int index;
    
    static
    {
      if (b.values().length != k.m.c.values().length) {
        throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
      }
    }
    
    private f(k.m paramm, l.g paramg, l.a parama, int paramInt, boolean paramBoolean)
    {
      this.index = paramInt;
      this.bSP = paramm;
      this.fullName = l.a(paramg, parama, paramm.getName());
      this.bSr = paramg;
      if (paramm.Ct()) {}
      StringBuilder localStringBuilder;
      for (this.bSQ = paramm.Cu();; this.bSQ = localStringBuilder.toString())
      {
        if (paramm.Cm()) {
          this.bSS = b.b(paramm.Cn());
        }
        if (this.bSP.bPE > 0) {
          break;
        }
        throw new l.c(this, "Field numbers must be positive integers.", (byte)0);
        String str = paramm.getName();
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
        if (!paramm.Cp()) {
          throw new l.c(this, "FieldDescriptorProto.extendee not set for extension field.", (byte)0);
        }
        this.bSs = null;
        if (parama != null) {}
        for (this.bSR = parama; paramm.Cs(); this.bSR = null) {
          throw new l.c(this, "FieldDescriptorProto.oneof_index set for extension field.", (byte)0);
        }
        this.bSU = null;
        paramg.bTG.c(this);
        return;
      }
      if (paramm.Cp()) {
        throw new l.c(this, "FieldDescriptorProto.extendee set for non-extension field.", (byte)0);
      }
      this.bSs = parama;
      if (paramm.Cs())
      {
        if ((paramm.bPN < 0) || (paramm.bPN >= parama.bSq.AE())) {
          throw new l.c(this, "FieldDescriptorProto.oneof_index is out of range for type " + parama.bSq.getName(), (byte)0);
        }
        this.bSU = ((l.j)parama.Fy().get(paramm.bPN));
        l.j.c(this.bSU);
      }
      for (;;)
      {
        this.bSR = null;
        break;
        this.bSU = null;
      }
    }
    
    public final cj.b FD()
    {
      return FE().caU;
    }
    
    public final cj.a FE()
    {
      return bSO[this.bSS.ordinal()];
    }
    
    public final boolean FF()
    {
      boolean bool2 = true;
      boolean bool1;
      if (this.bSS != b.bTp) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.bSs.bSq.AG().bRv);
        bool1 = bool2;
      } while (this.bSr.FQ() == l.g.a.bTJ);
      return this.bSr.bTB.CQ().bQY;
    }
    
    public final boolean FG()
    {
      return (this.bSS == b.bTr) && (FJ()) && (FN().bSq.AG().bRv);
    }
    
    public final boolean FH()
    {
      return this.bSP.Cl() == k.m.b.bPS;
    }
    
    public final boolean FI()
    {
      return this.bSP.Cl() == k.m.b.bPR;
    }
    
    public final boolean FJ()
    {
      return this.bSP.Cl() == k.m.b.bPT;
    }
    
    public final boolean FK()
    {
      if (!FL()) {}
      do
      {
        return false;
        if (this.bSr.FQ() == l.g.a.bTI) {
          return this.bSP.Cv().bQs;
        }
      } while ((this.bSP.Cv().CC()) && (!this.bSP.Cv().bQs));
      return true;
    }
    
    public final boolean FL()
    {
      return (FJ()) && (FE().FL());
    }
    
    public final l.a FM()
    {
      if (!this.bSP.Cp()) {
        throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[] { this.fullName }));
      }
      return this.bSR;
    }
    
    public final l.a FN()
    {
      if (this.bSS.bTz != a.bTe) {
        throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", new Object[] { this.fullName }));
      }
      return this.bST;
    }
    
    public final l.d FO()
    {
      if (this.bSS.bTz != a.bTd) {
        throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[] { this.fullName }));
      }
      return this.bSV;
    }
    
    public final String Fw()
    {
      return this.fullName;
    }
    
    public final l.g Fx()
    {
      return this.bSr;
    }
    
    public final aw.a a(aw.a parama, aw paramaw)
    {
      return ((at.a)parama).c((at)paramaw);
    }
    
    public final Object getDefaultValue()
    {
      if (this.bSS.bTz == a.bTe) {
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
      }
      return this.aEX;
    }
    
    public final String getName()
    {
      return this.bSP.getName();
    }
    
    public final int getNumber()
    {
      return this.bSP.bPE;
    }
    
    public final String toString()
    {
      return this.fullName;
    }
    
    public static enum a
    {
      private final Object bTf;
      
      private a(Object paramObject)
      {
        this.bTf = paramObject;
      }
    }
    
    public static enum b
    {
      l.f.a bTz;
      
      private b(l.f.a parama)
      {
        this.bTz = parama;
      }
      
      public static b b(k.m.c paramc)
      {
        return values()[(paramc.value - 1)];
      }
    }
  }
  
  public static final class g
    extends l.h
  {
    private final l.d[] bSu;
    private final l.f[] bSw;
    k.q bTB;
    private final l.a[] bTC;
    private final l.k[] bTD;
    private final g[] bTE;
    final g[] bTF;
    final l.b bTG;
    
    private g(k.q paramq, g[] paramArrayOfg, l.b paramb)
    {
      this.bTG = paramb;
      this.bTB = paramq;
      this.bTE = ((g[])paramArrayOfg.clone());
      HashMap localHashMap = new HashMap();
      int j = paramArrayOfg.length;
      int i = 0;
      g localg;
      while (i < j)
      {
        localg = paramArrayOfg[i];
        localHashMap.put(localg.bTB.getName(), localg);
        i += 1;
      }
      paramArrayOfg = new ArrayList();
      i = 0;
      while (i < paramq.CN())
      {
        j = paramq.bQJ.getInt(i);
        if ((j < 0) || (j >= paramq.CM())) {
          throw new l.c(this, "Invalid public dependency index.", (byte)0);
        }
        localg = (g)localHashMap.get((String)paramq.bQI.get(j));
        if (localg != null) {
          paramArrayOfg.add(localg);
        }
        i += 1;
      }
      this.bTF = new g[paramArrayOfg.size()];
      paramArrayOfg.toArray(this.bTF);
      paramb.a(this.bTB.getPackage(), this);
      this.bTC = new l.a[paramq.CO()];
      i = 0;
      while (i < paramq.CO())
      {
        this.bTC[i] = new l.a(paramq.gt(i), this, i);
        i += 1;
      }
      this.bSu = new l.d[paramq.AC()];
      i = 0;
      while (i < paramq.AC())
      {
        this.bSu[i] = new l.d(paramq.gd(i), this, null, i, 0);
        i += 1;
      }
      this.bTD = new l.k[paramq.CP()];
      i = 0;
      while (i < paramq.CP())
      {
        this.bTD[i] = new l.k(paramq.gu(i), this, i, 0);
        i += 1;
      }
      this.bSw = new l.f[paramq.AA()];
      i = 0;
      while (i < paramq.AA())
      {
        this.bSw[i] = new l.f(paramq.gb(i), this, null, i, true, 0);
        i += 1;
      }
    }
    
    g(String paramString, l.a parama)
    {
      this.bTG = new l.b(new g[0]);
      this.bTB = k.q.CV().cg(parama.fullName + ".placeholder.proto").ch(paramString).k(parama.bSq).CY();
      this.bTE = new g[0];
      this.bTF = new g[0];
      this.bTC = new l.a[] { parama };
      this.bSu = new l.d[0];
      this.bTD = new l.k[0];
      this.bSw = new l.f[0];
      this.bTG.a(paramString, this);
      this.bTG.c(parama);
    }
    
    private static g a(k.q paramq, g[] paramArrayOfg)
    {
      paramq = new g(paramq, paramArrayOfg, new l.b(paramArrayOfg));
      paramArrayOfg = paramq.bTC;
      int j = paramArrayOfg.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfg[i].FB();
        i += 1;
      }
      paramArrayOfg = paramq.bTD;
      int k = paramArrayOfg.length;
      i = 0;
      while (i < k)
      {
        l.i[] arrayOfi = paramArrayOfg[i].bTS;
        int m = arrayOfi.length;
        j = 0;
        while (j < m)
        {
          l.i locali = arrayOfi[j];
          l.h localh = locali.bSr.bTG.a(locali.bTL.DY(), locali, l.b.c.bSE);
          if (!(localh instanceof l.a)) {
            throw new l.c(locali, "\"" + locali.bTL.DY() + "\" is not a message type.", (byte)0);
          }
          locali.bTN = ((l.a)localh);
          localh = locali.bSr.bTG.a(locali.bTL.Ea(), locali, l.b.c.bSE);
          if (!(localh instanceof l.a)) {
            throw new l.c(locali, "\"" + locali.bTL.Ea() + "\" is not a message type.", (byte)0);
          }
          locali.bTO = ((l.a)localh);
          j += 1;
        }
        i += 1;
      }
      paramArrayOfg = paramq.bSw;
      j = paramArrayOfg.length;
      i = 0;
      while (i < j)
      {
        l.f.d(paramArrayOfg[i]);
        i += 1;
      }
      return paramq;
    }
    
    /* Error */
    public static g a(String[] paramArrayOfString, g[] paramArrayOfg)
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: aaload
      //   3: getstatic 292	com/google/a/ae:ISO_8859_1	Ljava/nio/charset/Charset;
      //   6: invokevirtual 296	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   9: astore_0
      //   10: aload_0
      //   11: invokestatic 300	com/google/a/k$q:E	([B)Lcom/google/a/k$q;
      //   14: astore_0
      //   15: aload_0
      //   16: aload_1
      //   17: invokestatic 302	com/google/a/l$g:a	(Lcom/google/a/k$q;[Lcom/google/a/l$g;)Lcom/google/a/l$g;
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
      //   52: invokevirtual 50	com/google/a/k$q:getName	()Ljava/lang/String;
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
      //   10	15	23	com/google/a/af
      //   15	21	36	com/google/a/l$c
    }
    
    public final List<l.a> FP()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bTC));
    }
    
    public final a FQ()
    {
      if (a.a(a.bTJ).equals(this.bTB.CU())) {
        return a.bTJ;
      }
      return a.bTI;
    }
    
    final boolean FR()
    {
      return FQ() == a.bTJ;
    }
    
    public final String Fw()
    {
      return this.bTB.getName();
    }
    
    public final g Fx()
    {
      return this;
    }
    
    public final String getName()
    {
      return this.bTB.getName();
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
    public abstract at FC();
    
    public abstract String Fw();
    
    public abstract l.g Fx();
    
    public abstract String getName();
  }
  
  public static final class i
    extends l.h
  {
    final l.g bSr;
    k.w bTL;
    private final l.k bTM;
    l.a bTN;
    l.a bTO;
    private final String fullName;
    private final int index;
    
    private i(k.w paramw, l.g paramg, l.k paramk, int paramInt)
    {
      this.index = paramInt;
      this.bTL = paramw;
      this.bSr = paramg;
      this.bTM = paramk;
      this.fullName = (paramk.fullName + '.' + paramw.getName());
      paramg.bTG.c(this);
    }
    
    public final String Fw()
    {
      return this.fullName;
    }
    
    public final l.g Fx()
    {
      return this.bSr;
    }
    
    public final String getName()
    {
      return this.bTL.getName();
    }
  }
  
  public static final class j
  {
    private final l.g bSr;
    l.a bSs;
    l.f[] bSv;
    k.aa bTP;
    int bTQ;
    private final String fullName;
    final int index;
    
    private j(k.aa paramaa, l.g paramg, l.a parama, int paramInt)
    {
      this.bTP = paramaa;
      this.fullName = l.a(paramg, parama, paramaa.getName());
      this.bSr = paramg;
      this.index = paramInt;
      this.bSs = parama;
      this.bTQ = 0;
    }
  }
  
  public static final class k
    extends l.h
  {
    private final l.g bSr;
    private k.ae bTR;
    l.i[] bTS;
    final String fullName;
    private final int index;
    
    private k(k.ae paramae, l.g paramg, int paramInt)
    {
      this.index = paramInt;
      this.bTR = paramae;
      this.fullName = l.a(paramg, null, paramae.getName());
      this.bSr = paramg;
      this.bTS = new l.i[paramae.Ex()];
      paramInt = 0;
      while (paramInt < paramae.Ex())
      {
        this.bTS[paramInt] = new l.i(paramae.gx(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      paramg.bTG.c(this);
    }
    
    public final String Fw()
    {
      return this.fullName;
    }
    
    public final l.g Fx()
    {
      return this.bSr;
    }
    
    public final String getName()
    {
      return this.bTR.getName();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.l
 * JD-Core Version:    0.7.0.1
 */