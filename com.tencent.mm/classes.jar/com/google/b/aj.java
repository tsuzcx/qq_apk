package com.google.b;

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

public final class aj
{
  private static final Logger logger = Logger.getLogger(aj.class.getName());
  
  public static final class a
    extends aj.h
  {
    k.a bUp;
    final aj.g bUq;
    private final a bUr;
    private final a[] bUs;
    private final aj.d[] bUt;
    private final aj.f[] bUu;
    private final aj.f[] bUv;
    private final aj.j[] bUw;
    final String fullName;
    private final int index;
    
    private a(k.a parama, aj.g paramg, a parama1, int paramInt)
    {
      this.index = paramInt;
      this.bUp = parama;
      this.fullName = aj.a(paramg, parama1, parama.getName());
      this.bUq = paramg;
      this.bUr = parama1;
      this.bUw = new aj.j[parama.Ci()];
      paramInt = 0;
      while (paramInt < parama.Ci())
      {
        this.bUw[paramInt] = new aj.j(parama.gW(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      this.bUs = new a[parama.Cf()];
      paramInt = 0;
      while (paramInt < parama.Cf())
      {
        this.bUs[paramInt] = new a(parama.gU(paramInt), paramg, this, paramInt);
        paramInt += 1;
      }
      this.bUt = new aj.d[parama.Cg()];
      paramInt = 0;
      while (paramInt < parama.Cg())
      {
        this.bUt[paramInt] = new aj.d(parama.gV(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      this.bUu = new aj.f[parama.Cd()];
      paramInt = 0;
      while (paramInt < parama.Cd())
      {
        this.bUu[paramInt] = new aj.f(parama.gS(paramInt), paramg, this, paramInt, false, 0);
        paramInt += 1;
      }
      this.bUv = new aj.f[parama.Ce()];
      paramInt = 0;
      while (paramInt < parama.Ce())
      {
        this.bUv[paramInt] = new aj.f(parama.gT(paramInt), paramg, this, paramInt, true, 0);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < parama.Ci())
      {
        this.bUw[paramInt].bUu = new aj.f[this.bUw[paramInt].bVQ];
        this.bUw[paramInt].bVQ = 0;
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < parama.Cd())
      {
        parama1 = this.bUu[paramInt].bUT;
        if (parama1 != null) {
          parama1.bUu[aj.j.c(parama1)] = this.bUu[paramInt];
        }
        paramInt += 1;
      }
      paramg.bVG.c(this);
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
        this.bUp = k.a.Cl().cy(str2).a(k.a.b.CV().gX(1).gY(536870912).CY()).Cw();
        this.fullName = paramString;
        this.bUr = null;
        this.bUs = new a[0];
        this.bUt = new aj.d[0];
        this.bUu = new aj.f[0];
        this.bUv = new aj.f[0];
        this.bUw = new aj.j[0];
        this.bUq = new aj.g(str1, this);
        return;
        str2 = paramString;
      }
    }
    
    public final String Hc()
    {
      return this.fullName;
    }
    
    public final aj.g Hd()
    {
      return this.bUq;
    }
    
    public final List<aj.j> He()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bUw));
    }
    
    public final List<a> Hf()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bUs));
    }
    
    public final boolean Hg()
    {
      return this.bUp.bQY.size() != 0;
    }
    
    final void Hh()
    {
      int j = 0;
      Object localObject = this.bUs;
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        localObject[i].Hh();
        i += 1;
      }
      localObject = this.bUu;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        aj.f.d(localObject[i]);
        i += 1;
      }
      localObject = this.bUv;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        aj.f.d(localObject[i]);
        i += 1;
      }
    }
    
    public final aj.f cC(String paramString)
    {
      paramString = this.bUq.bVG.cD(this.fullName + '.' + paramString);
      if ((paramString != null) && ((paramString instanceof aj.f))) {
        return (aj.f)paramString;
      }
      return null;
    }
    
    public final List<aj.f> getFields()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bUu));
    }
    
    public final String getName()
    {
      return this.bUp.getName();
    }
    
    public final boolean hq(int paramInt)
    {
      Iterator localIterator = this.bUp.bQY.iterator();
      while (localIterator.hasNext())
      {
        k.a.b localb = (k.a.b)localIterator.next();
        if ((localb.bRo <= paramInt) && (paramInt < localb.bRp)) {
          return true;
        }
      }
      return false;
    }
    
    public final aj.f hr(int paramInt)
    {
      return (aj.f)this.bUq.bVG.bUA.get(new aj.b.a(this, paramInt));
    }
  }
  
  static final class b
  {
    final Map<a, aj.f> bUA = new HashMap();
    final Map<a, aj.e> bUB = new HashMap();
    private final Set<aj.g> bUx = new HashSet();
    private boolean bUy = true;
    private final Map<String, aj.h> bUz = new HashMap();
    
    b(aj.g[] paramArrayOfg)
    {
      int i = 0;
      while (i < paramArrayOfg.length)
      {
        this.bUx.add(paramArrayOfg[i]);
        a(paramArrayOfg[i]);
        i += 1;
      }
      paramArrayOfg = this.bUx.iterator();
      while (paramArrayOfg.hasNext())
      {
        aj.g localg = (aj.g)paramArrayOfg.next();
        try
        {
          a(localg.bVB.getPackage(), localg);
        }
        catch (aj.c paramArrayOfg)
        {
          throw new AssertionError(paramArrayOfg);
        }
      }
    }
    
    private aj.h a(String paramString, aj.b.c paramc)
    {
      aj.h localh2 = (aj.h)this.bUz.get(paramString);
      aj.h localh1;
      if (localh2 != null)
      {
        localh1 = localh2;
        if (paramc != aj.b.c.bUF) {
          if (paramc == aj.b.c.bUD)
          {
            localh1 = localh2;
            if (a(localh2)) {}
          }
          else
          {
            if ((paramc != aj.b.c.bUE) || (!b(localh2))) {
              break label68;
            }
            localh1 = localh2;
          }
        }
        return localh1;
      }
      label68:
      Iterator localIterator = this.bUx.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localh2 = (aj.h)((aj.g)localIterator.next()).bVG.bUz.get(paramString);
          if (localh2 != null)
          {
            localh1 = localh2;
            if (paramc == aj.b.c.bUF) {
              break;
            }
            if (paramc == aj.b.c.bUD)
            {
              localh1 = localh2;
              if (a(localh2)) {
                break;
              }
            }
            if ((paramc == aj.b.c.bUE) && (b(localh2))) {
              return localh2;
            }
          }
        }
      }
      return null;
    }
    
    private void a(aj.g paramg)
    {
      paramg = Collections.unmodifiableList(Arrays.asList(paramg.bVF)).iterator();
      while (paramg.hasNext())
      {
        aj.g localg = (aj.g)paramg.next();
        if (this.bUx.add(localg)) {
          a(localg);
        }
      }
    }
    
    private static boolean a(aj.h paramh)
    {
      return ((paramh instanceof aj.a)) || ((paramh instanceof aj.d));
    }
    
    private static boolean b(aj.h paramh)
    {
      return ((paramh instanceof aj.a)) || ((paramh instanceof aj.d)) || ((paramh instanceof b)) || ((paramh instanceof aj.k));
    }
    
    private static void d(aj.h paramh)
    {
      String str = paramh.getName();
      if (str.length() == 0) {
        throw new aj.c(paramh, "Missing name.", (byte)0);
      }
      int i = 0;
      while (i < str.length())
      {
        int j = str.charAt(i);
        if (((97 > j) || (j > 122)) && ((65 > j) || (j > 90)) && (j != 95) && ((48 > j) || (j > 57) || (i <= 0))) {
          throw new aj.c(paramh, "\"" + str + "\" is not a valid identifier.", (byte)0);
        }
        i += 1;
      }
    }
    
    final aj.h a(String paramString, aj.h paramh, aj.b.c paramc)
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
          if ((this.bUy) && (paramc == aj.b.c.bUD))
          {
            aj.Hb().warning("The descriptor for message type \"" + paramString + "\" can not be found and a placeholder is created for it");
            localObject3 = new aj.a((String)localObject2);
            this.bUx.add(((aj.h)localObject3).Hd());
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
          localObject3 = new StringBuilder(paramh.Hc());
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
        localObject2 = a(((StringBuilder)localObject3).toString(), aj.b.c.bUE);
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
        throw new aj.c(paramh, "\"" + paramString + "\" is not defined.", (byte)0);
      }
    }
    
    final void a(String paramString, aj.g paramg)
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1) {}
      for (String str = paramString;; str = paramString.substring(i + 1))
      {
        aj.h localh = (aj.h)this.bUz.put(paramString, new b(str, paramString, paramg));
        if (localh == null) {
          break;
        }
        this.bUz.put(paramString, localh);
        if ((localh instanceof b)) {
          break;
        }
        throw new aj.c(paramg, "\"" + str + "\" is already defined (as something other than a package) in file \"" + localh.Hd().bVB.getName() + "\".", (byte)0);
        a(paramString.substring(0, i), paramg);
      }
    }
    
    final void c(aj.h paramh)
    {
      d(paramh);
      String str = paramh.Hc();
      aj.h localh = (aj.h)this.bUz.put(str, paramh);
      if (localh != null)
      {
        this.bUz.put(str, localh);
        if (paramh.Hd() == localh.Hd())
        {
          int i = str.lastIndexOf('.');
          if (i == -1) {
            throw new aj.c(paramh, "\"" + str + "\" is already defined.", (byte)0);
          }
          throw new aj.c(paramh, "\"" + str.substring(i + 1) + "\" is already defined in \"" + str.substring(0, i) + "\".", (byte)0);
        }
        throw new aj.c(paramh, "\"" + str + "\" is already defined in file \"" + localh.Hd().bVB.getName() + "\".", (byte)0);
      }
    }
    
    final aj.h cD(String paramString)
    {
      return a(paramString, aj.b.c.bUF);
    }
    
    static final class a
    {
      private final aj.h bUC;
      private final int number;
      
      a(aj.h paramh, int paramInt)
      {
        this.bUC = paramh;
        this.number = paramInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a)) {}
        do
        {
          return false;
          paramObject = (a)paramObject;
        } while ((this.bUC != paramObject.bUC) || (this.number != paramObject.number));
        return true;
      }
      
      public final int hashCode()
      {
        return this.bUC.hashCode() * 65535 + this.number;
      }
    }
    
    static final class b
      extends aj.h
    {
      private final aj.g bUq;
      private final String fullName;
      private final String name;
      
      b(String paramString1, String paramString2, aj.g paramg)
      {
        this.bUq = paramg;
        this.fullName = paramString2;
        this.name = paramString1;
      }
      
      public final String Hc()
      {
        return this.fullName;
      }
      
      public final aj.g Hd()
      {
        return this.bUq;
      }
      
      public final bt Hi()
      {
        return this.bUq.bVB;
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
    private final bt bUH;
    private final String description;
    private final String name;
    
    private c(aj.g paramg, String paramString)
    {
      super();
      this.name = paramg.bVB.getName();
      this.bUH = paramg.bVB;
      this.description = paramString;
    }
    
    private c(aj.h paramh, String paramString)
    {
      super();
      this.name = paramh.Hc();
      this.bUH = paramh.Hi();
      this.description = paramString;
    }
    
    private c(aj.h paramh, String paramString, Throwable paramThrowable)
    {
      this(paramh, paramString);
      initCause(paramThrowable);
    }
  }
  
  public static final class d
    extends aj.h
    implements be.b<aj.e>
  {
    k.b bUI;
    aj.e[] bUJ;
    private final WeakHashMap<Integer, WeakReference<aj.e>> bUK = new WeakHashMap();
    final aj.g bUq;
    private final aj.a bUr;
    final String fullName;
    private final int index;
    
    private d(k.b paramb, aj.g paramg, aj.a parama, int paramInt)
    {
      this.index = paramInt;
      this.bUI = paramb;
      this.fullName = aj.a(paramg, parama, paramb.getName());
      this.bUq = paramg;
      this.bUr = parama;
      if (paramb.De() == 0) {
        throw new aj.c(this, "Enums must contain at least one value.", (byte)0);
      }
      this.bUJ = new aj.e[paramb.De()];
      paramInt = 0;
      while (paramInt < paramb.De())
      {
        this.bUJ[paramInt] = new aj.e(paramb.hb(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      paramg.bVG.c(this);
    }
    
    public final String Hc()
    {
      return this.fullName;
    }
    
    public final aj.g Hd()
    {
      return this.bUq;
    }
    
    public final String getName()
    {
      return this.bUI.getName();
    }
    
    public final aj.e hs(int paramInt)
    {
      return (aj.e)this.bUq.bVG.bUB.get(new aj.b.a(this, paramInt));
    }
    
    public final aj.e ht(int paramInt)
    {
      aj.e locale = hs(paramInt);
      if (locale != null) {
        return locale;
      }
      for (;;)
      {
        try
        {
          Integer localInteger = Integer.valueOf(paramInt);
          Object localObject2 = (WeakReference)this.bUK.get(localInteger);
          if (localObject2 != null)
          {
            locale = (aj.e)((WeakReference)localObject2).get();
            localObject2 = locale;
            if (locale == null)
            {
              localObject2 = new aj.e(this.bUq, this, localInteger, (byte)0);
              this.bUK.put(localInteger, new WeakReference(localObject2));
            }
            return localObject2;
          }
        }
        finally {}
      }
    }
  }
  
  public static final class e
    extends aj.h
    implements be.a
  {
    k.d bUL;
    final aj.d bUM;
    private final aj.g bUq;
    private final String fullName;
    private final int index;
    
    private e(aj.g paramg, aj.d paramd, Integer paramInteger)
    {
      String str = "UNKNOWN_ENUM_VALUE_" + paramd.bUI.getName() + "_" + paramInteger;
      paramInteger = k.d.DB().cz(str).he(paramInteger.intValue()).DE();
      this.index = -1;
      this.bUL = paramInteger;
      this.bUq = paramg;
      this.bUM = paramd;
      this.fullName = (paramd.fullName + '.' + paramInteger.getName());
    }
    
    private e(k.d paramd, aj.g paramg, aj.d paramd1, int paramInt)
    {
      this.index = paramInt;
      this.bUL = paramd;
      this.bUq = paramg;
      this.bUM = paramd1;
      this.fullName = (paramd1.fullName + '.' + paramd.getName());
      paramg.bVG.c(this);
      paramd = paramg.bVG;
      paramg = new aj.b.a(this.bUM, this.bUL.bRD);
      paramd1 = (e)paramd.bUB.put(paramg, this);
      if (paramd1 != null) {
        paramd.bUB.put(paramg, paramd1);
      }
    }
    
    public final String Hc()
    {
      return this.fullName;
    }
    
    public final aj.g Hd()
    {
      return this.bUq;
    }
    
    public final String getName()
    {
      return this.bUL.getName();
    }
    
    public final int getNumber()
    {
      return this.bUL.bRD;
    }
    
    public final String toString()
    {
      return this.bUL.getName();
    }
  }
  
  public static final class f
    extends aj.h
    implements av.a<f>, Comparable<f>
  {
    private static final dh.a[] bUN = ;
    k.g bUO;
    private final String bUP;
    private final aj.a bUQ;
    b bUR;
    private aj.a bUS;
    aj.j bUT;
    private aj.d bUU;
    private Object bUV;
    final aj.g bUq;
    aj.a bUr;
    final String fullName;
    final int index;
    
    static
    {
      if (b.values().length != k.g.c.values().length) {
        throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
      }
    }
    
    private f(k.g paramg, aj.g paramg1, aj.a parama, int paramInt, boolean paramBoolean)
    {
      this.index = paramInt;
      this.bUO = paramg;
      this.fullName = aj.a(paramg1, parama, paramg.getName());
      this.bUq = paramg1;
      if (paramg.DY()) {}
      StringBuilder localStringBuilder;
      for (this.bUP = paramg.DZ();; this.bUP = localStringBuilder.toString())
      {
        if (paramg.DQ()) {
          this.bUR = b.b(paramg.DR());
        }
        if (this.bUO.bRD > 0) {
          break;
        }
        throw new aj.c(this, "Field numbers must be positive integers.", (byte)0);
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
        if (!paramg.DU()) {
          throw new aj.c(this, "FieldDescriptorProto.extendee not set for extension field.", (byte)0);
        }
        this.bUr = null;
        if (parama != null) {}
        for (this.bUQ = parama; paramg.DX(); this.bUQ = null) {
          throw new aj.c(this, "FieldDescriptorProto.oneof_index set for extension field.", (byte)0);
        }
        this.bUT = null;
        paramg1.bVG.c(this);
        return;
      }
      if (paramg.DU()) {
        throw new aj.c(this, "FieldDescriptorProto.extendee set for non-extension field.", (byte)0);
      }
      this.bUr = parama;
      if (paramg.DX())
      {
        if ((paramg.bRM < 0) || (paramg.bRM >= parama.bUp.Ci())) {
          throw new aj.c(this, "FieldDescriptorProto.oneof_index is out of range for type " + parama.bUp.getName(), (byte)0);
        }
        this.bUT = ((aj.j)parama.He().get(paramg.bRM));
        aj.j.c(this.bUT);
      }
      for (;;)
      {
        this.bUQ = null;
        break;
        this.bUT = null;
      }
    }
    
    public final String Hc()
    {
      return this.fullName;
    }
    
    public final aj.g Hd()
    {
      return this.bUq;
    }
    
    public final dh.b Hj()
    {
      return Hk().ccx;
    }
    
    public final dh.a Hk()
    {
      return bUN[this.bUR.ordinal()];
    }
    
    public final boolean Hl()
    {
      boolean bool2 = true;
      boolean bool1;
      if (this.bUR != b.bVp) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.bUr.bUp.Ck().bTu);
        bool1 = bool2;
      } while (this.bUq.Hx() == aj.g.a.bVJ);
      return this.bUq.bVB.Ev().bSX;
    }
    
    public final boolean Hm()
    {
      return (this.bUR == b.bVr) && (Hp()) && (Hu().bUp.Ck().bTu);
    }
    
    public final boolean Hn()
    {
      return this.bUO.DP() == k.g.b.bRR;
    }
    
    public final boolean Ho()
    {
      return this.bUO.DP() == k.g.b.bRQ;
    }
    
    public final boolean Hp()
    {
      return this.bUO.DP() == k.g.b.bRS;
    }
    
    public final boolean Hq()
    {
      if (!Hr()) {}
      do
      {
        return false;
        if (this.bUq.Hx() == aj.g.a.bVI) {
          return this.bUO.Ea().bSr;
        }
      } while ((this.bUO.Ea().Eh()) && (!this.bUO.Ea().bSr));
      return true;
    }
    
    public final boolean Hr()
    {
      return (Hp()) && (Hk().Hr());
    }
    
    public final Object Hs()
    {
      if (this.bUR.bVz == a.bVe) {
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
      }
      return this.bUV;
    }
    
    public final aj.a Ht()
    {
      if (!this.bUO.DU()) {
        throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", new Object[] { this.fullName }));
      }
      return this.bUQ;
    }
    
    public final aj.a Hu()
    {
      if (this.bUR.bVz != a.bVe) {
        throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", new Object[] { this.fullName }));
      }
      return this.bUS;
    }
    
    public final aj.d Hv()
    {
      if (this.bUR.bVz != a.bVd) {
        throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", new Object[] { this.fullName }));
      }
      return this.bUU;
    }
    
    public final bw.a a(bw.a parama, bw parambw)
    {
      return ((bt.a)parama).c((bt)parambw);
    }
    
    public final String getName()
    {
      return this.bUO.getName();
    }
    
    public final int getNumber()
    {
      return this.bUO.bRD;
    }
    
    public final String toString()
    {
      return this.fullName;
    }
    
    public static enum a
    {
      private final Object bVf;
      
      private a(Object paramObject)
      {
        this.bVf = paramObject;
      }
    }
    
    public static enum b
    {
      aj.f.a bVz;
      
      private b(aj.f.a parama)
      {
        this.bVz = parama;
      }
      
      public static b b(k.g.c paramc)
      {
        return values()[(paramc.value - 1)];
      }
    }
  }
  
  public static final class g
    extends aj.h
  {
    private final aj.d[] bUt;
    private final aj.f[] bUv;
    k.i bVB;
    private final aj.a[] bVC;
    private final aj.k[] bVD;
    private final g[] bVE;
    final g[] bVF;
    final aj.b bVG;
    
    private g(k.i parami, g[] paramArrayOfg, aj.b paramb)
    {
      this.bVG = paramb;
      this.bVB = parami;
      this.bVE = ((g[])paramArrayOfg.clone());
      HashMap localHashMap = new HashMap();
      int j = paramArrayOfg.length;
      int i = 0;
      g localg;
      while (i < j)
      {
        localg = paramArrayOfg[i];
        localHashMap.put(localg.bVB.getName(), localg);
        i += 1;
      }
      paramArrayOfg = new ArrayList();
      i = 0;
      while (i < parami.Es())
      {
        j = parami.bSI.getInt(i);
        if ((j < 0) || (j >= parami.Er())) {
          throw new aj.c(this, "Invalid public dependency index.", (byte)0);
        }
        localg = (g)localHashMap.get((String)parami.bSH.get(j));
        if (localg != null) {
          paramArrayOfg.add(localg);
        }
        i += 1;
      }
      this.bVF = new g[paramArrayOfg.size()];
      paramArrayOfg.toArray(this.bVF);
      paramb.a(this.bVB.getPackage(), this);
      this.bVC = new aj.a[parami.Et()];
      i = 0;
      while (i < parami.Et())
      {
        this.bVC[i] = new aj.a(parami.hl(i), this, i);
        i += 1;
      }
      this.bUt = new aj.d[parami.Cg()];
      i = 0;
      while (i < parami.Cg())
      {
        this.bUt[i] = new aj.d(parami.gV(i), this, null, i, 0);
        i += 1;
      }
      this.bVD = new aj.k[parami.Eu()];
      i = 0;
      while (i < parami.Eu())
      {
        this.bVD[i] = new aj.k(parami.hm(i), this, i, 0);
        i += 1;
      }
      this.bUv = new aj.f[parami.Ce()];
      i = 0;
      while (i < parami.Ce())
      {
        this.bUv[i] = new aj.f(parami.gT(i), this, null, i, true, 0);
        i += 1;
      }
    }
    
    g(String paramString, aj.a parama)
    {
      this.bVG = new aj.b(new g[0]);
      this.bVB = k.i.EA().cA(parama.fullName + ".placeholder.proto").cB(paramString).k(parama.bUp).ED();
      this.bVE = new g[0];
      this.bVF = new g[0];
      this.bVC = new aj.a[] { parama };
      this.bUt = new aj.d[0];
      this.bVD = new aj.k[0];
      this.bUv = new aj.f[0];
      this.bVG.a(paramString, this);
      this.bVG.c(parama);
    }
    
    private static g a(k.i parami, g[] paramArrayOfg)
    {
      parami = new g(parami, paramArrayOfg, new aj.b(paramArrayOfg));
      paramArrayOfg = parami.bVC;
      int j = paramArrayOfg.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfg[i].Hh();
        i += 1;
      }
      paramArrayOfg = parami.bVD;
      int k = paramArrayOfg.length;
      i = 0;
      while (i < k)
      {
        aj.i[] arrayOfi = paramArrayOfg[i].bVS;
        int m = arrayOfi.length;
        j = 0;
        while (j < m)
        {
          aj.i locali = arrayOfi[j];
          aj.h localh = locali.bUq.bVG.a(locali.bVL.FD(), locali, aj.b.c.bUD);
          if (!(localh instanceof aj.a)) {
            throw new aj.c(locali, "\"" + locali.bVL.FD() + "\" is not a message type.", (byte)0);
          }
          locali.bVN = ((aj.a)localh);
          localh = locali.bUq.bVG.a(locali.bVL.FF(), locali, aj.b.c.bUD);
          if (!(localh instanceof aj.a)) {
            throw new aj.c(locali, "\"" + locali.bVL.FF() + "\" is not a message type.", (byte)0);
          }
          locali.bVO = ((aj.a)localh);
          j += 1;
        }
        i += 1;
      }
      paramArrayOfg = parami.bUv;
      j = paramArrayOfg.length;
      i = 0;
      while (i < j)
      {
        aj.f.d(paramArrayOfg[i]);
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
      //   3: getstatic 292	com/google/b/be:ISO_8859_1	Ljava/nio/charset/Charset;
      //   6: invokevirtual 296	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   9: astore_0
      //   10: aload_0
      //   11: invokestatic 300	com/google/b/k$i:C	([B)Lcom/google/b/k$i;
      //   14: astore_0
      //   15: aload_0
      //   16: aload_1
      //   17: invokestatic 302	com/google/b/aj$g:a	(Lcom/google/b/k$i;[Lcom/google/b/aj$g;)Lcom/google/b/aj$g;
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
      //   52: invokevirtual 50	com/google/b/k$i:getName	()Ljava/lang/String;
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
      //   10	15	23	com/google/b/bf
      //   15	21	36	com/google/b/aj$c
    }
    
    public final String Hc()
    {
      return this.bVB.getName();
    }
    
    public final g Hd()
    {
      return this;
    }
    
    public final List<aj.a> Hw()
    {
      return Collections.unmodifiableList(Arrays.asList(this.bVC));
    }
    
    public final a Hx()
    {
      if (a.a(a.bVJ).equals(this.bVB.Ez())) {
        return a.bVJ;
      }
      return a.bVI;
    }
    
    final boolean Hy()
    {
      return Hx() == a.bVJ;
    }
    
    public final String getName()
    {
      return this.bVB.getName();
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
    public abstract String Hc();
    
    public abstract aj.g Hd();
    
    public abstract bt Hi();
    
    public abstract String getName();
  }
  
  public static final class i
    extends aj.h
  {
    final aj.g bUq;
    k.l bVL;
    private final aj.k bVM;
    aj.a bVN;
    aj.a bVO;
    private final String fullName;
    private final int index;
    
    private i(k.l paraml, aj.g paramg, aj.k paramk, int paramInt)
    {
      this.index = paramInt;
      this.bVL = paraml;
      this.bUq = paramg;
      this.bVM = paramk;
      this.fullName = (paramk.fullName + '.' + paraml.getName());
      paramg.bVG.c(this);
    }
    
    public final String Hc()
    {
      return this.fullName;
    }
    
    public final aj.g Hd()
    {
      return this.bUq;
    }
    
    public final String getName()
    {
      return this.bVL.getName();
    }
  }
  
  public static final class j
  {
    private final aj.g bUq;
    aj.a bUr;
    aj.f[] bUu;
    k.n bVP;
    int bVQ;
    private final String fullName;
    final int index;
    
    private j(k.n paramn, aj.g paramg, aj.a parama, int paramInt)
    {
      this.bVP = paramn;
      this.fullName = aj.a(paramg, parama, paramn.getName());
      this.bUq = paramg;
      this.index = paramInt;
      this.bUr = parama;
      this.bVQ = 0;
    }
  }
  
  public static final class k
    extends aj.h
  {
    private final aj.g bUq;
    private k.p bVR;
    aj.i[] bVS;
    final String fullName;
    private final int index;
    
    private k(k.p paramp, aj.g paramg, int paramInt)
    {
      this.index = paramInt;
      this.bVR = paramp;
      this.fullName = aj.a(paramg, null, paramp.getName());
      this.bUq = paramg;
      this.bVS = new aj.i[paramp.Gc()];
      paramInt = 0;
      while (paramInt < paramp.Gc())
      {
        this.bVS[paramInt] = new aj.i(paramp.hp(paramInt), paramg, this, paramInt, 0);
        paramInt += 1;
      }
      paramg.bVG.c(this);
    }
    
    public final String Hc()
    {
      return this.fullName;
    }
    
    public final aj.g Hd()
    {
      return this.bUq;
    }
    
    public final String getName()
    {
      return this.bVR.getName();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.aj
 * JD-Core Version:    0.7.0.1
 */