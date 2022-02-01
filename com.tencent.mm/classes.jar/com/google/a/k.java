package com.google.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k
{
  private static final l.a bNQ;
  private static final ac.f bNR;
  private static final l.a bNS;
  private static final ac.f bNT;
  private static final l.a bNU;
  private static final ac.f bNV;
  private static final l.a bNW;
  private static final ac.f bNX;
  private static final l.a bNY;
  private static final ac.f bNZ;
  private static final l.a bOA = (l.a)bOS.FP().get(15);
  private static final ac.f bOB = new ac.f(bOA, new String[] { "Deprecated", "UninterpretedOption" });
  private static final l.a bOC = (l.a)bOS.FP().get(16);
  private static final ac.f bOD = new ac.f(bOC, new String[] { "Deprecated", "UninterpretedOption" });
  private static final l.a bOE = (l.a)bOS.FP().get(17);
  private static final ac.f bOF = new ac.f(bOE, new String[] { "Deprecated", "IdempotencyLevel", "UninterpretedOption" });
  private static final l.a bOG = (l.a)bOS.FP().get(18);
  private static final ac.f bOH = new ac.f(bOG, new String[] { "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue" });
  private static final l.a bOI = (l.a)bOG.Fz().get(0);
  private static final ac.f bOJ = new ac.f(bOI, new String[] { "NamePart", "IsExtension" });
  private static final l.a bOK = (l.a)bOS.FP().get(19);
  private static final ac.f bOL = new ac.f(bOK, new String[] { "Location" });
  private static final l.a bOM = (l.a)bOK.Fz().get(0);
  private static final ac.f bON = new ac.f(bOM, new String[] { "Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments" });
  private static final l.a bOO = (l.a)bOS.FP().get(20);
  private static final ac.f bOP = new ac.f(bOO, new String[] { "Annotation" });
  private static final l.a bOQ = (l.a)bOO.Fz().get(0);
  private static final ac.f bOR = new ac.f(bOQ, new String[] { "Path", "SourceFile", "Begin", "End" });
  private static l.g bOS;
  private static final l.a bOa;
  private static final ac.f bOb;
  private static final l.a bOc;
  private static final ac.f bOd;
  private static final l.a bOe;
  private static final ac.f bOf;
  private static final l.a bOg;
  private static final ac.f bOh;
  private static final l.a bOi;
  private static final ac.f bOj;
  private static final l.a bOk;
  private static final ac.f bOl;
  private static final l.a bOm;
  private static final ac.f bOn;
  private static final l.a bOo;
  private static final ac.f bOp;
  private static final l.a bOq;
  private static final ac.f bOr;
  private static final l.a bOs;
  private static final ac.f bOt;
  private static final l.a bOu;
  private static final ac.f bOv;
  private static final l.a bOw;
  private static final ac.f bOx;
  private static final l.a bOy;
  private static final ac.f bOz;
  
  static
  {
    l.g localg = l.g.a(new String[] { "" }, new l.g[0]);
    bOS = localg;
    bNQ = (l.a)localg.FP().get(0);
    bNR = new ac.f(bNQ, new String[] { "File" });
    bNS = (l.a)bOS.FP().get(1);
    bNT = new ac.f(bNS, new String[] { "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax" });
    bNU = (l.a)bOS.FP().get(2);
    bNV = new ac.f(bNU, new String[] { "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName" });
    bNW = (l.a)bNU.Fz().get(0);
    bNX = new ac.f(bNW, new String[] { "Start", "End", "Options" });
    bNY = (l.a)bNU.Fz().get(1);
    bNZ = new ac.f(bNY, new String[] { "Start", "End" });
    bOa = (l.a)bOS.FP().get(3);
    bOb = new ac.f(bOa, new String[] { "UninterpretedOption" });
    bOc = (l.a)bOS.FP().get(4);
    bOd = new ac.f(bOc, new String[] { "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options" });
    bOe = (l.a)bOS.FP().get(5);
    bOf = new ac.f(bOe, new String[] { "Name", "Options" });
    bOg = (l.a)bOS.FP().get(6);
    bOh = new ac.f(bOg, new String[] { "Name", "Value", "Options", "ReservedRange", "ReservedName" });
    bOi = (l.a)bOg.Fz().get(0);
    bOj = new ac.f(bOi, new String[] { "Start", "End" });
    bOk = (l.a)bOS.FP().get(7);
    bOl = new ac.f(bOk, new String[] { "Name", "Number", "Options" });
    bOm = (l.a)bOS.FP().get(8);
    bOn = new ac.f(bOm, new String[] { "Name", "Method", "Options" });
    bOo = (l.a)bOS.FP().get(9);
    bOp = new ac.f(bOo, new String[] { "Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming" });
    bOq = (l.a)bOS.FP().get(10);
    bOr = new ac.f(bOq, new String[] { "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption" });
    bOs = (l.a)bOS.FP().get(11);
    bOt = new ac.f(bOs, new String[] { "MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption" });
    bOu = (l.a)bOS.FP().get(12);
    bOv = new ac.f(bOu, new String[] { "Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption" });
    bOw = (l.a)bOS.FP().get(13);
    bOx = new ac.f(bOw, new String[] { "UninterpretedOption" });
    bOy = (l.a)bOS.FP().get(14);
    bOz = new ac.f(bOy, new String[] { "AllowAlias", "Deprecated", "UninterpretedOption" });
  }
  
  public static final class a
    extends ac
    implements k.b
  {
    private static final a bPf = new a();
    @Deprecated
    public static final bj<a> bPg = new c() {};
    private int bOT;
    private volatile Object bOU;
    private List<k.m> bOV;
    private List<k.m> bOW;
    private List<a> bOX;
    private List<k.c> bOY;
    List<b> bOZ;
    private List<k.aa> bPa;
    private k.u bPb;
    private List<d> bPc;
    private ak bPd;
    private byte bPe = -1;
    
    private a()
    {
      this.bOU = "";
      this.bOV = Collections.emptyList();
      this.bOW = Collections.emptyList();
      this.bOX = Collections.emptyList();
      this.bOY = Collections.emptyList();
      this.bOZ = Collections.emptyList();
      this.bPa = Collections.emptyList();
      this.bPc = Collections.emptyList();
      this.bPd = aj.bXM;
    }
    
    private a(ac.a<?> parama)
    {
      super();
    }
    
    private a(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int i1 = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int k;
        int m;
        int j;
        if (i1 == 0)
        {
          k = i;
          m = i;
          j = i;
        }
        for (;;)
        {
          try
          {
            n = paramh.yT();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (a(paramh, locala, paramr, n)) {
                break label1311;
              }
              j = 1;
              break label1327;
              k = i;
              m = i;
              j = i;
              localObject = paramh.zb();
              k = i;
              m = i;
              j = i;
              this.bOT |= 0x1;
              k = i;
              m = i;
              j = i;
              this.bOU = localObject;
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              j = k;
              if ((j & 0x2) != 0) {
                this.bOV = Collections.unmodifiableList(this.bOV);
              }
              if ((j & 0x8) != 0) {
                this.bOX = Collections.unmodifiableList(this.bOX);
              }
              if ((j & 0x10) != 0) {
                this.bOY = Collections.unmodifiableList(this.bOY);
              }
              if ((j & 0x20) != 0) {
                this.bOZ = Collections.unmodifiableList(this.bOZ);
              }
              if ((j & 0x4) != 0) {
                this.bOW = Collections.unmodifiableList(this.bOW);
              }
              if ((j & 0x40) != 0) {
                this.bPa = Collections.unmodifiableList(this.bPa);
              }
              if ((j & 0x100) != 0) {
                this.bPc = Collections.unmodifiableList(this.bPc);
              }
              if ((j & 0x200) != 0) {
                this.bPd = this.bPd.GR();
              }
              this.bTW = locala.HM();
              Gw();
            }
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bOV = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.bOV.add(paramh.a(k.m.bPg, paramr));
            i = n;
            break;
          }
          catch (IOException paramh)
          {
            j = m;
            paramh = new af(paramh);
            j = m;
            paramh.bXr = this;
            j = m;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            if ((i & 0x8) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bOX = new ArrayList();
              n = i | 0x8;
            }
            k = n;
            m = n;
            j = n;
            this.bOX.add(paramh.a(bPg, paramr));
            i = n;
          }
          break;
          int n = i;
          if ((i & 0x10) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bOY = new ArrayList();
            n = i | 0x10;
          }
          k = n;
          m = n;
          j = n;
          this.bOY.add(paramh.a(k.c.bPg, paramr));
          i = n;
          break;
          n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bOZ = new ArrayList();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.bOZ.add(paramh.a(b.bPg, paramr));
          i = n;
          break;
          n = i;
          if ((i & 0x4) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bOW = new ArrayList();
            n = i | 0x4;
          }
          k = n;
          m = n;
          j = n;
          this.bOW.add(paramh.a(k.m.bPg, paramr));
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          if ((this.bOT & 0x2) != 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (Object localObject = this.bPb.DT();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.bPb = ((k.u)paramh.a(k.u.bPg, paramr));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((k.u.a)localObject).d(this.bPb);
              k = i;
              m = i;
              j = i;
              this.bPb = ((k.u.a)localObject).DW();
            }
            k = i;
            m = i;
            j = i;
            this.bOT |= 0x2;
            break;
            n = i;
            if ((i & 0x40) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bPa = new ArrayList();
              n = i | 0x40;
            }
            k = n;
            m = n;
            j = n;
            this.bPa.add(paramh.a(k.aa.bPg, paramr));
            i = n;
            break;
            n = i;
            if ((i & 0x100) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bPc = new ArrayList();
              n = i | 0x100;
            }
            k = n;
            m = n;
            j = n;
            this.bPc.add(paramh.a(d.bPg, paramr));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            localObject = paramh.zb();
            n = i;
            if ((i & 0x200) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bPd = new aj();
              n = i | 0x200;
            }
            k = n;
            m = n;
            j = n;
            this.bPd.d((g)localObject);
            i = n;
            break;
            if ((i & 0x2) != 0) {
              this.bOV = Collections.unmodifiableList(this.bOV);
            }
            if ((i & 0x8) != 0) {
              this.bOX = Collections.unmodifiableList(this.bOX);
            }
            if ((i & 0x10) != 0) {
              this.bOY = Collections.unmodifiableList(this.bOY);
            }
            if ((i & 0x20) != 0) {
              this.bOZ = Collections.unmodifiableList(this.bOZ);
            }
            if ((i & 0x4) != 0) {
              this.bOW = Collections.unmodifiableList(this.bOW);
            }
            if ((i & 0x40) != 0) {
              this.bPa = Collections.unmodifiableList(this.bPa);
            }
            if ((i & 0x100) != 0) {
              this.bPc = Collections.unmodifiableList(this.bPc);
            }
            if ((i & 0x200) != 0) {
              this.bPd = this.bPd.GR();
            }
            this.bTW = locala.HM();
            Gw();
            return;
            label1311:
            j = i1;
            break label1327;
          }
        }
        label1327:
        i1 = j;
        continue;
        i1 = 1;
      }
    }
    
    private int AD()
    {
      return this.bOZ.size();
    }
    
    public static a AH()
    {
      return bPf.AI();
    }
    
    private a AI()
    {
      if (this == bPf) {
        return new a((byte)0);
      }
      return new a((byte)0).j(this);
    }
    
    public static a AJ()
    {
      return bPf;
    }
    
    public final int AA()
    {
      return this.bOW.size();
    }
    
    public final int AB()
    {
      return this.bOX.size();
    }
    
    public final int AC()
    {
      return this.bOY.size();
    }
    
    public final int AE()
    {
      return this.bPa.size();
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final k.u AG()
    {
      if (this.bPb == null) {
        return k.u.DU();
      }
      return this.bPb;
    }
    
    public final bj<a> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zE().h(a.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final void a(i parami)
    {
      int k = 0;
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      int i = 0;
      while (i < this.bOV.size())
      {
        parami.a(2, (aw)this.bOV.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bOX.size())
      {
        parami.a(3, (aw)this.bOX.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bOY.size())
      {
        parami.a(4, (aw)this.bOY.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bOZ.size())
      {
        parami.a(5, (aw)this.bOZ.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bOW.size())
      {
        parami.a(6, (aw)this.bOW.get(i));
        i += 1;
      }
      if ((this.bOT & 0x2) != 0) {
        parami.a(7, AG());
      }
      i = 0;
      while (i < this.bPa.size())
      {
        parami.a(8, (aw)this.bPa.get(i));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.bPc.size()) {
          break;
        }
        parami.a(9, (aw)this.bPc.get(i));
        i += 1;
      }
      while (j < this.bPd.size())
      {
        ac.a(parami, 10, this.bPd.getRaw(j));
        j += 1;
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return super.equals(paramObject);
        }
        paramObject = (a)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.bOV.equals(paramObject.bOV)) {
          return false;
        }
        if (!this.bOW.equals(paramObject.bOW)) {
          return false;
        }
        if (!this.bOX.equals(paramObject.bOX)) {
          return false;
        }
        if (!this.bOY.equals(paramObject.bOY)) {
          return false;
        }
        if (!this.bOZ.equals(paramObject.bOZ)) {
          return false;
        }
        if (!this.bPa.equals(paramObject.bPa)) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!AG().equals(paramObject.AG()))) {
          return false;
        }
        if (!this.bPc.equals(paramObject.bPc)) {
          return false;
        }
        if (!this.bPd.equals(paramObject.bPd)) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final k.m ga(int paramInt)
    {
      return (k.m)this.bOV.get(paramInt);
    }
    
    public final k.m gb(int paramInt)
    {
      return (k.m)this.bOW.get(paramInt);
    }
    
    public final a gc(int paramInt)
    {
      return (a)this.bOX.get(paramInt);
    }
    
    public final k.c gd(int paramInt)
    {
      return (k.c)this.bOY.get(paramInt);
    }
    
    public final k.aa ge(int paramInt)
    {
      return (k.aa)this.bPa.get(paramInt);
    }
    
    public final int getFieldCount()
    {
      return this.bOV.size();
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zD().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (getFieldCount() > 0) {
        j = (i * 37 + 2) * 53 + this.bOV.hashCode();
      }
      i = j;
      if (AA() > 0) {
        i = (j * 37 + 6) * 53 + this.bOW.hashCode();
      }
      j = i;
      if (AB() > 0) {
        j = (i * 37 + 3) * 53 + this.bOX.hashCode();
      }
      i = j;
      if (AC() > 0) {
        i = (j * 37 + 4) * 53 + this.bOY.hashCode();
      }
      j = i;
      if (AD() > 0) {
        j = (i * 37 + 5) * 53 + this.bOZ.hashCode();
      }
      i = j;
      if (AE() > 0) {
        i = (j * 37 + 8) * 53 + this.bPa.hashCode();
      }
      j = i;
      if (AF()) {
        j = (i * 37 + 7) * 53 + AG().hashCode();
      }
      i = j;
      if (this.bPc.size() > 0) {
        i = (j * 37 + 9) * 53 + this.bPc.hashCode();
      }
      j = i;
      if (this.bPd.size() > 0) {
        j = (i * 37 + 10) * 53 + this.bPd.hashCode();
      }
      i = j * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < getFieldCount())
      {
        if (!ga(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AA())
      {
        if (!gb(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AB())
      {
        if (!gc(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AC())
      {
        if (!gd(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AD())
      {
        if (!((b)this.bOZ.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AE())
      {
        if (!ge(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if ((AF()) && (!AG().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (i = ac.d(1, this.bOU) + 0;; i = 0)
      {
        int j = 0;
        while (j < this.bOV.size())
        {
          i += i.c(2, (aw)this.bOV.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bOX.size())
        {
          i += i.c(3, (aw)this.bOX.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bOY.size())
        {
          i += i.c(4, (aw)this.bOY.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bOZ.size())
        {
          i += i.c(5, (aw)this.bOZ.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bOW.size())
        {
          i += i.c(6, (aw)this.bOW.get(j));
          j += 1;
        }
        j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.c(7, AG());
        }
        int k = 0;
        i = j;
        j = k;
        while (j < this.bPa.size())
        {
          i += i.c(8, (aw)this.bPa.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bPc.size())
        {
          i += i.c(9, (aw)this.bPc.get(j));
          j += 1;
        }
        j = 0;
        k = 0;
        while (j < this.bPd.size())
        {
          k += ar(this.bPd.getRaw(j));
          j += 1;
        }
        i = i + k + this.bPd.size() * 1 + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.a<a>
      implements k.b
    {
      private int bOT;
      private Object bOU = "";
      private List<k.m> bOV = Collections.emptyList();
      private List<k.m> bOW = Collections.emptyList();
      private List<k.a> bOX = Collections.emptyList();
      private List<k.c> bOY = Collections.emptyList();
      private List<k.a.b> bOZ = Collections.emptyList();
      private List<k.aa> bPa = Collections.emptyList();
      private k.u bPb;
      private List<k.a.d> bPc = Collections.emptyList();
      private ak bPd = aj.bXM;
      private bq<k.m, k.m.a, k.n> bPh;
      private bq<k.m, k.m.a, k.n> bPi;
      private bq<k.a, a, k.b> bPj;
      private bq<k.c, k.c.a, k.d> bPk;
      private bq<k.a.b, k.a.b.a, k.a.c> bPl;
      private bq<k.aa, k.aa.a, k.ab> bPm;
      private bu<k.u, k.u.a, k.v> bPn;
      private bq<k.a.d, k.a.d.a, k.a.e> bPo;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private k.u AG()
      {
        if (this.bPn == null)
        {
          if (this.bPb == null) {
            return k.u.DU();
          }
          return this.bPb;
        }
        return (k.u)this.bPn.Hu();
      }
      
      private void AR()
      {
        if (ac.bVU)
        {
          AW();
          AY();
          Ba();
          Bc();
          Be();
          Bg();
          Bh();
          Bj();
        }
      }
      
      private k.a AU()
      {
        k.a locala = new k.a(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          k.a.a(locala, this.bOU);
          label130:
          label179:
          label228:
          int j;
          if (this.bPh == null)
          {
            if ((this.bOT & 0x2) != 0)
            {
              this.bOV = Collections.unmodifiableList(this.bOV);
              this.bOT &= 0xFFFFFFFD;
            }
            k.a.a(locala, this.bOV);
            if (this.bPi != null) {
              break label484;
            }
            if ((this.bOT & 0x4) != 0)
            {
              this.bOW = Collections.unmodifiableList(this.bOW);
              this.bOT &= 0xFFFFFFFB;
            }
            k.a.b(locala, this.bOW);
            if (this.bPj != null) {
              break label500;
            }
            if ((this.bOT & 0x8) != 0)
            {
              this.bOX = Collections.unmodifiableList(this.bOX);
              this.bOT &= 0xFFFFFFF7;
            }
            k.a.c(locala, this.bOX);
            if (this.bPk != null) {
              break label516;
            }
            if ((this.bOT & 0x10) != 0)
            {
              this.bOY = Collections.unmodifiableList(this.bOY);
              this.bOT &= 0xFFFFFFEF;
            }
            k.a.d(locala, this.bOY);
            if (this.bPl != null) {
              break label532;
            }
            if ((this.bOT & 0x20) != 0)
            {
              this.bOZ = Collections.unmodifiableList(this.bOZ);
              this.bOT &= 0xFFFFFFDF;
            }
            k.a.e(locala, this.bOZ);
            label277:
            if (this.bPm != null) {
              break label548;
            }
            if ((this.bOT & 0x40) != 0)
            {
              this.bPa = Collections.unmodifiableList(this.bPa);
              this.bOT &= 0xFFFFFFBF;
            }
            k.a.f(locala, this.bPa);
            label326:
            j = i;
            if ((k & 0x80) != 0)
            {
              if (this.bPn != null) {
                break label564;
              }
              k.a.a(locala, this.bPb);
              label353:
              j = i | 0x2;
            }
            if (this.bPo != null) {
              break label583;
            }
            if ((this.bOT & 0x100) != 0)
            {
              this.bPc = Collections.unmodifiableList(this.bPc);
              this.bOT &= 0xFFFFFEFF;
            }
            k.a.g(locala, this.bPc);
          }
          for (;;)
          {
            if ((this.bOT & 0x200) != 0)
            {
              this.bPd = this.bPd.GR();
              this.bOT &= 0xFFFFFDFF;
            }
            k.a.a(locala, this.bPd);
            k.a.a(locala, j);
            Gy();
            return locala;
            k.a.a(locala, this.bPh.build());
            break;
            label484:
            k.a.b(locala, this.bPi.build());
            break label130;
            label500:
            k.a.c(locala, this.bPj.build());
            break label179;
            label516:
            k.a.d(locala, this.bPk.build());
            break label228;
            label532:
            k.a.e(locala, this.bPl.build());
            break label277;
            label548:
            k.a.f(locala, this.bPm.build());
            break label326;
            label564:
            k.a.a(locala, (k.u)this.bPn.Hv());
            break label353;
            label583:
            k.a.g(locala, this.bPo.build());
          }
        }
      }
      
      private void AV()
      {
        if ((this.bOT & 0x2) == 0)
        {
          this.bOV = new ArrayList(this.bOV);
          this.bOT |= 0x2;
        }
      }
      
      private bq<k.m, k.m.a, k.n> AW()
      {
        List localList;
        if (this.bPh == null)
        {
          localList = this.bOV;
          if ((this.bOT & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPh = new bq(localList, bool, GA(), this.bWv);
          this.bOV = null;
          return this.bPh;
        }
      }
      
      private void AX()
      {
        if ((this.bOT & 0x4) == 0)
        {
          this.bOW = new ArrayList(this.bOW);
          this.bOT |= 0x4;
        }
      }
      
      private bq<k.m, k.m.a, k.n> AY()
      {
        List localList;
        if (this.bPi == null)
        {
          localList = this.bOW;
          if ((this.bOT & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPi = new bq(localList, bool, GA(), this.bWv);
          this.bOW = null;
          return this.bPi;
        }
      }
      
      private void AZ()
      {
        if ((this.bOT & 0x8) == 0)
        {
          this.bOX = new ArrayList(this.bOX);
          this.bOT |= 0x8;
        }
      }
      
      private bq<k.a, a, k.b> Ba()
      {
        List localList;
        if (this.bPj == null)
        {
          localList = this.bOX;
          if ((this.bOT & 0x8) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPj = new bq(localList, bool, GA(), this.bWv);
          this.bOX = null;
          return this.bPj;
        }
      }
      
      private void Bb()
      {
        if ((this.bOT & 0x10) == 0)
        {
          this.bOY = new ArrayList(this.bOY);
          this.bOT |= 0x10;
        }
      }
      
      private bq<k.c, k.c.a, k.d> Bc()
      {
        List localList;
        if (this.bPk == null)
        {
          localList = this.bOY;
          if ((this.bOT & 0x10) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPk = new bq(localList, bool, GA(), this.bWv);
          this.bOY = null;
          return this.bPk;
        }
      }
      
      private void Bd()
      {
        if ((this.bOT & 0x20) == 0)
        {
          this.bOZ = new ArrayList(this.bOZ);
          this.bOT |= 0x20;
        }
      }
      
      private bq<k.a.b, k.a.b.a, k.a.c> Be()
      {
        List localList;
        if (this.bPl == null)
        {
          localList = this.bOZ;
          if ((this.bOT & 0x20) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPl = new bq(localList, bool, GA(), this.bWv);
          this.bOZ = null;
          return this.bPl;
        }
      }
      
      private void Bf()
      {
        if ((this.bOT & 0x40) == 0)
        {
          this.bPa = new ArrayList(this.bPa);
          this.bOT |= 0x40;
        }
      }
      
      private bq<k.aa, k.aa.a, k.ab> Bg()
      {
        List localList;
        if (this.bPm == null)
        {
          localList = this.bPa;
          if ((this.bOT & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPm = new bq(localList, bool, GA(), this.bWv);
          this.bPa = null;
          return this.bPm;
        }
      }
      
      private bu<k.u, k.u.a, k.v> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(AG(), GA(), this.bWv);
          this.bPb = null;
        }
        return this.bPn;
      }
      
      private void Bi()
      {
        if ((this.bOT & 0x100) == 0)
        {
          this.bPc = new ArrayList(this.bPc);
          this.bOT |= 0x100;
        }
      }
      
      private bq<k.a.d, k.a.d.a, k.a.e> Bj()
      {
        List localList;
        if (this.bPo == null)
        {
          localList = this.bPc;
          if ((this.bOT & 0x100) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.bPo = new bq(localList, bool, GA(), this.bWv);
          this.bPc = null;
          return this.bPo;
        }
      }
      
      private void Bk()
      {
        if ((this.bOT & 0x200) == 0)
        {
          this.bPd = new aj(this.bPd);
          this.bOT |= 0x200;
        }
      }
      
      private a a(k.u paramu)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x80) != 0) && (this.bPb != null) && (this.bPb != k.u.DU()))
          {
            this.bPb = k.u.b(this.bPb).d(paramu).DW();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x80;
          return this;
          this.bPb = paramu;
          break;
          this.bPn.b(paramu);
        }
      }
      
      private a a(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a b(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a b(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a c(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a d(at paramat)
      {
        if ((paramat instanceof k.a)) {
          return j((k.a)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a e(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 304	com/google/a/k$a:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 309 3 0
        //   12: checkcast 9	com/google/a/k$a
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 294	com/google/a/k$a$a:j	(Lcom/google/a/k$a;)Lcom/google/a/k$a$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 313	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$a
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 317	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 294	com/google/a/k$a$a:j	(Lcom/google/a/k$a;)Lcom/google/a/k$a$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.zD();
      }
      
      public final k.a AT()
      {
        k.a locala = AU();
        if (!locala.isInitialized()) {
          throw b(locala);
        }
        return locala;
      }
      
      protected final ac.f Ay()
      {
        return k.zE().h(k.a.class, a.class);
      }
      
      public final a a(k.a.b paramb)
      {
        if (this.bPl == null)
        {
          if (paramb == null) {
            throw new NullPointerException();
          }
          Bd();
          this.bOZ.add(paramb);
          onChanged();
          return this;
        }
        this.bPl.a(paramb);
        return this;
      }
      
      public final a ce(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x1;
        this.bOU = paramString;
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        Object localObject;
        if (this.bPh == null)
        {
          j = this.bOV.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPh != null) {
            break label65;
          }
          localObject = (k.m)this.bOV.get(i);
          label45:
          if (((k.m)localObject).isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bPh.getCount();
          break label19;
          label65:
          localObject = (k.m)this.bPh.s(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          i = 0;
          if (this.bPi == null)
          {
            j = this.bOW.size();
            label107:
            if (i >= j) {
              break label174;
            }
            if (this.bPi != null) {
              break label158;
            }
          }
          label158:
          for (localObject = (k.m)this.bOW.get(i);; localObject = (k.m)this.bPi.s(i, false))
          {
            if (!((k.m)localObject).isInitialized()) {
              break label172;
            }
            i += 1;
            break;
            j = this.bPi.getCount();
            break label107;
          }
          label172:
          continue;
          label174:
          i = 0;
          if (this.bPj == null)
          {
            j = this.bOX.size();
            label193:
            if (i >= j) {
              break label260;
            }
            if (this.bPj != null) {
              break label244;
            }
          }
          label244:
          for (localObject = (k.a)this.bOX.get(i);; localObject = (k.a)this.bPj.s(i, false))
          {
            if (!((k.a)localObject).isInitialized()) {
              break label258;
            }
            i += 1;
            break;
            j = this.bPj.getCount();
            break label193;
          }
          label258:
          continue;
          label260:
          i = 0;
          if (this.bPk == null)
          {
            j = this.bOY.size();
            label279:
            if (i >= j) {
              break label346;
            }
            if (this.bPk != null) {
              break label330;
            }
          }
          label330:
          for (localObject = (k.c)this.bOY.get(i);; localObject = (k.c)this.bPk.s(i, false))
          {
            if (!((k.c)localObject).isInitialized()) {
              break label344;
            }
            i += 1;
            break;
            j = this.bPk.getCount();
            break label279;
          }
          label344:
          continue;
          label346:
          i = 0;
          if (this.bPl == null)
          {
            j = this.bOZ.size();
            label365:
            if (i >= j) {
              break label432;
            }
            if (this.bPl != null) {
              break label416;
            }
          }
          label416:
          for (localObject = (k.a.b)this.bOZ.get(i);; localObject = (k.a.b)this.bPl.s(i, false))
          {
            if (!((k.a.b)localObject).isInitialized()) {
              break label430;
            }
            i += 1;
            break;
            j = this.bPl.getCount();
            break label365;
          }
          label430:
          continue;
          label432:
          i = 0;
          if (this.bPm == null)
          {
            j = this.bPa.size();
            label451:
            if (i >= j) {
              break label518;
            }
            if (this.bPm != null) {
              break label502;
            }
          }
          label502:
          for (localObject = (k.aa)this.bPa.get(i);; localObject = (k.aa)this.bPm.s(i, false))
          {
            if (!((k.aa)localObject).isInitialized()) {
              break label516;
            }
            i += 1;
            break;
            j = this.bPm.getCount();
            break label451;
          }
          label516:
          continue;
          label518:
          if ((this.bOT & 0x80) != 0) {}
          for (i = 1; (i == 0) || (AG().isInitialized()); i = 0) {
            return true;
          }
        }
      }
      
      public final a j(k.a parama)
      {
        Object localObject2 = null;
        if (parama == k.a.AJ()) {
          return this;
        }
        if (parama.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.a.a(parama);
          onChanged();
        }
        if (this.bPh == null) {
          if (!k.a.b(parama).isEmpty())
          {
            if (this.bOV.isEmpty())
            {
              this.bOV = k.a.b(parama);
              this.bOT &= 0xFFFFFFFD;
              onChanged();
            }
          }
          else
          {
            label94:
            if (this.bPi != null) {
              break label633;
            }
            if (!k.a.c(parama).isEmpty())
            {
              if (!this.bOW.isEmpty()) {
                break label612;
              }
              this.bOW = k.a.c(parama);
              this.bOT &= 0xFFFFFFFB;
              label144:
              onChanged();
            }
            label148:
            if (this.bPj != null) {
              break label747;
            }
            if (!k.a.d(parama).isEmpty())
            {
              if (!this.bOX.isEmpty()) {
                break label726;
              }
              this.bOX = k.a.d(parama);
              this.bOT &= 0xFFFFFFF7;
              label198:
              onChanged();
            }
            label202:
            if (this.bPk != null) {
              break label861;
            }
            if (!k.a.e(parama).isEmpty())
            {
              if (!this.bOY.isEmpty()) {
                break label840;
              }
              this.bOY = k.a.e(parama);
              this.bOT &= 0xFFFFFFEF;
              label252:
              onChanged();
            }
            label256:
            if (this.bPl != null) {
              break label975;
            }
            if (!k.a.f(parama).isEmpty())
            {
              if (!this.bOZ.isEmpty()) {
                break label954;
              }
              this.bOZ = k.a.f(parama);
              this.bOT &= 0xFFFFFFDF;
              label306:
              onChanged();
            }
            label310:
            if (this.bPm != null) {
              break label1089;
            }
            if (!k.a.g(parama).isEmpty())
            {
              if (!this.bPa.isEmpty()) {
                break label1068;
              }
              this.bPa = k.a.g(parama);
              this.bOT &= 0xFFFFFFBF;
              label360:
              onChanged();
            }
            label364:
            if (parama.AF()) {
              a(parama.AG());
            }
            if (this.bPo != null) {
              break label1203;
            }
            if (!k.a.h(parama).isEmpty())
            {
              if (!this.bPc.isEmpty()) {
                break label1182;
              }
              this.bPc = k.a.h(parama);
              this.bOT &= 0xFFFFFEFF;
              label431:
              onChanged();
            }
            label435:
            if (!k.a.i(parama).isEmpty())
            {
              if (!this.bPd.isEmpty()) {
                break label1294;
              }
              this.bPd = k.a.i(parama);
              this.bOT &= 0xFFFFFDFF;
            }
          }
        }
        for (;;)
        {
          onChanged();
          c(parama.bTW);
          onChanged();
          return this;
          AV();
          this.bOV.addAll(k.a.b(parama));
          break;
          if (k.a.b(parama).isEmpty()) {
            break label94;
          }
          Object localObject1;
          if (this.bPh.isEmpty())
          {
            this.bPh.bYP = null;
            this.bPh = null;
            this.bOV = k.a.b(parama);
            this.bOT &= 0xFFFFFFFD;
            if (ac.bVU) {}
            for (localObject1 = AW();; localObject1 = null)
            {
              this.bPh = ((bq)localObject1);
              break;
            }
          }
          this.bPh.a(k.a.b(parama));
          break label94;
          label612:
          AX();
          this.bOW.addAll(k.a.c(parama));
          break label144;
          label633:
          if (k.a.c(parama).isEmpty()) {
            break label148;
          }
          if (this.bPi.isEmpty())
          {
            this.bPi.bYP = null;
            this.bPi = null;
            this.bOW = k.a.c(parama);
            this.bOT &= 0xFFFFFFFB;
            if (ac.bVU) {}
            for (localObject1 = AY();; localObject1 = null)
            {
              this.bPi = ((bq)localObject1);
              break;
            }
          }
          this.bPi.a(k.a.c(parama));
          break label148;
          label726:
          AZ();
          this.bOX.addAll(k.a.d(parama));
          break label198;
          label747:
          if (k.a.d(parama).isEmpty()) {
            break label202;
          }
          if (this.bPj.isEmpty())
          {
            this.bPj.bYP = null;
            this.bPj = null;
            this.bOX = k.a.d(parama);
            this.bOT &= 0xFFFFFFF7;
            if (ac.bVU) {}
            for (localObject1 = Ba();; localObject1 = null)
            {
              this.bPj = ((bq)localObject1);
              break;
            }
          }
          this.bPj.a(k.a.d(parama));
          break label202;
          label840:
          Bb();
          this.bOY.addAll(k.a.e(parama));
          break label252;
          label861:
          if (k.a.e(parama).isEmpty()) {
            break label256;
          }
          if (this.bPk.isEmpty())
          {
            this.bPk.bYP = null;
            this.bPk = null;
            this.bOY = k.a.e(parama);
            this.bOT &= 0xFFFFFFEF;
            if (ac.bVU) {}
            for (localObject1 = Bc();; localObject1 = null)
            {
              this.bPk = ((bq)localObject1);
              break;
            }
          }
          this.bPk.a(k.a.e(parama));
          break label256;
          label954:
          Bd();
          this.bOZ.addAll(k.a.f(parama));
          break label306;
          label975:
          if (k.a.f(parama).isEmpty()) {
            break label310;
          }
          if (this.bPl.isEmpty())
          {
            this.bPl.bYP = null;
            this.bPl = null;
            this.bOZ = k.a.f(parama);
            this.bOT &= 0xFFFFFFDF;
            if (ac.bVU) {}
            for (localObject1 = Be();; localObject1 = null)
            {
              this.bPl = ((bq)localObject1);
              break;
            }
          }
          this.bPl.a(k.a.f(parama));
          break label310;
          label1068:
          Bf();
          this.bPa.addAll(k.a.g(parama));
          break label360;
          label1089:
          if (k.a.g(parama).isEmpty()) {
            break label364;
          }
          if (this.bPm.isEmpty())
          {
            this.bPm.bYP = null;
            this.bPm = null;
            this.bPa = k.a.g(parama);
            this.bOT &= 0xFFFFFFBF;
            if (ac.bVU) {}
            for (localObject1 = Bg();; localObject1 = null)
            {
              this.bPm = ((bq)localObject1);
              break;
            }
          }
          this.bPm.a(k.a.g(parama));
          break label364;
          label1182:
          Bi();
          this.bPc.addAll(k.a.h(parama));
          break label431;
          label1203:
          if (k.a.h(parama).isEmpty()) {
            break label435;
          }
          if (this.bPo.isEmpty())
          {
            this.bPo.bYP = null;
            this.bPo = null;
            this.bPc = k.a.h(parama);
            this.bOT &= 0xFFFFFEFF;
            localObject1 = localObject2;
            if (ac.bVU) {
              localObject1 = Bj();
            }
            this.bPo = ((bq)localObject1);
            break label435;
          }
          this.bPo.a(k.a.h(parama));
          break label435;
          label1294:
          Bk();
          this.bPd.addAll(k.a.i(parama));
        }
      }
    }
    
    public static final class b
      extends ac
      implements k.a.c
    {
      @Deprecated
      public static final bj<b> bPg = new c() {};
      private static final b bPs = new b();
      private int bOT;
      private byte bPe = -1;
      int bPp;
      int bPq;
      private k.k bPr;
      
      private b() {}
      
      private b(ac.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(h paramh, r paramr)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 35	com/google/a/k$a$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 58	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 59	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 65	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
        //   19: astore 6
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +223 -> 247
        //   27: aload_1
        //   28: invokevirtual 71	com/google/a/h:yT	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+235->270, 0:+241->276, 8:+59->94, 16:+104->139, 26:+142->177
        //   77: aload_1
        //   78: aload 6
        //   80: aload_2
        //   81: iload 4
        //   83: invokevirtual 74	com/google/a/k$a$b:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
        //   86: ifne +175 -> 261
        //   89: iconst_1
        //   90: istore_3
        //   91: goto +182 -> 273
        //   94: aload_0
        //   95: aload_0
        //   96: getfield 76	com/google/a/k$a$b:bOT	I
        //   99: iconst_1
        //   100: ior
        //   101: putfield 76	com/google/a/k$a$b:bOT	I
        //   104: aload_0
        //   105: aload_1
        //   106: invokevirtual 79	com/google/a/h:yW	()I
        //   109: putfield 81	com/google/a/k$a$b:bPp	I
        //   112: goto -89 -> 23
        //   115: astore_1
        //   116: aload_1
        //   117: aload_0
        //   118: putfield 85	com/google/a/af:bXr	Lcom/google/a/aw;
        //   121: aload_1
        //   122: athrow
        //   123: astore_1
        //   124: aload_0
        //   125: aload 6
        //   127: invokevirtual 91	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   130: putfield 95	com/google/a/k$a$b:bTW	Lcom/google/a/cc;
        //   133: aload_0
        //   134: invokevirtual 98	com/google/a/k$a$b:Gw	()V
        //   137: aload_1
        //   138: athrow
        //   139: aload_0
        //   140: aload_0
        //   141: getfield 76	com/google/a/k$a$b:bOT	I
        //   144: iconst_2
        //   145: ior
        //   146: putfield 76	com/google/a/k$a$b:bOT	I
        //   149: aload_0
        //   150: aload_1
        //   151: invokevirtual 79	com/google/a/h:yW	()I
        //   154: putfield 100	com/google/a/k$a$b:bPq	I
        //   157: goto -134 -> 23
        //   160: astore_1
        //   161: new 54	com/google/a/af
        //   164: dup
        //   165: aload_1
        //   166: invokespecial 103	com/google/a/af:<init>	(Ljava/io/IOException;)V
        //   169: astore_1
        //   170: aload_1
        //   171: aload_0
        //   172: putfield 85	com/google/a/af:bXr	Lcom/google/a/aw;
        //   175: aload_1
        //   176: athrow
        //   177: aload_0
        //   178: getfield 76	com/google/a/k$a$b:bOT	I
        //   181: iconst_4
        //   182: iand
        //   183: ifeq +81 -> 264
        //   186: aload_0
        //   187: getfield 105	com/google/a/k$a$b:bPr	Lcom/google/a/k$k;
        //   190: invokevirtual 111	com/google/a/k$k:Cg	()Lcom/google/a/k$k$a;
        //   193: astore 5
        //   195: aload_0
        //   196: aload_1
        //   197: getstatic 112	com/google/a/k$k:bPg	Lcom/google/a/bj;
        //   200: aload_2
        //   201: invokevirtual 115	com/google/a/h:a	(Lcom/google/a/bj;Lcom/google/a/r;)Lcom/google/a/aw;
        //   204: checkcast 107	com/google/a/k$k
        //   207: putfield 105	com/google/a/k$a$b:bPr	Lcom/google/a/k$k;
        //   210: aload 5
        //   212: ifnull +22 -> 234
        //   215: aload 5
        //   217: aload_0
        //   218: getfield 105	com/google/a/k$a$b:bPr	Lcom/google/a/k$k;
        //   221: invokevirtual 121	com/google/a/k$k$a:d	(Lcom/google/a/k$k;)Lcom/google/a/k$k$a;
        //   224: pop
        //   225: aload_0
        //   226: aload 5
        //   228: invokevirtual 125	com/google/a/k$k$a:Cj	()Lcom/google/a/k$k;
        //   231: putfield 105	com/google/a/k$a$b:bPr	Lcom/google/a/k$k;
        //   234: aload_0
        //   235: aload_0
        //   236: getfield 76	com/google/a/k$a$b:bOT	I
        //   239: iconst_4
        //   240: ior
        //   241: putfield 76	com/google/a/k$a$b:bOT	I
        //   244: goto -221 -> 23
        //   247: aload_0
        //   248: aload 6
        //   250: invokevirtual 91	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   253: putfield 95	com/google/a/k$a$b:bTW	Lcom/google/a/cc;
        //   256: aload_0
        //   257: invokevirtual 98	com/google/a/k$a$b:Gw	()V
        //   260: return
        //   261: goto +12 -> 273
        //   264: aconst_null
        //   265: astore 5
        //   267: goto -72 -> 195
        //   270: goto -194 -> 76
        //   273: goto -250 -> 23
        //   276: iconst_1
        //   277: istore_3
        //   278: goto -255 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	281	0	this	b
        //   0	281	1	paramh	h
        //   0	281	2	paramr	r
        //   22	256	3	i	int
        //   31	51	4	j	int
        //   193	73	5	locala	k.k.a
        //   19	230	6	locala1	cc.a
        // Exception table:
        //   from	to	target	type
        //   27	33	115	com/google/a/af
        //   76	89	115	com/google/a/af
        //   94	112	115	com/google/a/af
        //   139	157	115	com/google/a/af
        //   177	195	115	com/google/a/af
        //   195	210	115	com/google/a/af
        //   215	234	115	com/google/a/af
        //   234	244	115	com/google/a/af
        //   27	33	123	finally
        //   76	89	123	finally
        //   94	112	123	finally
        //   116	123	123	finally
        //   139	157	123	finally
        //   161	177	123	finally
        //   177	195	123	finally
        //   195	210	123	finally
        //   215	234	123	finally
        //   234	244	123	finally
        //   27	33	160	java/io/IOException
        //   76	89	160	java/io/IOException
        //   94	112	160	java/io/IOException
        //   139	157	160	java/io/IOException
        //   177	195	160	java/io/IOException
        //   195	210	160	java/io/IOException
        //   215	234	160	java/io/IOException
        //   234	244	160	java/io/IOException
      }
      
      public static a Bs()
      {
        return bPs.Bt();
      }
      
      private a Bt()
      {
        if (this == bPs) {
          return new a((byte)0);
        }
        return new a((byte)0).b(this);
      }
      
      public static b Bu()
      {
        return bPs;
      }
      
      public final boolean AF()
      {
        return (this.bOT & 0x4) != 0;
      }
      
      public final bj<b> AK()
      {
        return bPg;
      }
      
      public final cc Ax()
      {
        return this.bTW;
      }
      
      protected final ac.f Ay()
      {
        return k.zG().h(b.class, a.class);
      }
      
      public final boolean Bq()
      {
        return (this.bOT & 0x1) != 0;
      }
      
      public final k.k Br()
      {
        if (this.bPr == null) {
          return k.k.Ch();
        }
        return this.bPr;
      }
      
      public final void a(i parami)
      {
        if ((this.bOT & 0x1) != 0) {
          parami.bs(1, this.bPp);
        }
        if ((this.bOT & 0x2) != 0) {
          parami.bs(2, this.bPq);
        }
        if ((this.bOT & 0x4) != 0) {
          parami.a(3, Br());
        }
        this.bTW.a(parami);
      }
      
      public final boolean equals(Object paramObject)
      {
        if (paramObject == this) {}
        do
        {
          return true;
          if (!(paramObject instanceof b)) {
            return super.equals(paramObject);
          }
          paramObject = (b)paramObject;
          if (Bq() != paramObject.Bq()) {
            return false;
          }
          if ((Bq()) && (this.bPp != paramObject.bPp)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.bPq != paramObject.bPq)) {
            return false;
          }
          if (AF() != paramObject.AF()) {
            return false;
          }
          if ((AF()) && (!Br().equals(paramObject.Br()))) {
            return false;
          }
        } while (this.bTW.equals(paramObject.bTW));
        return false;
      }
      
      public final boolean hasEnd()
      {
        return (this.bOT & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.bNb != 0) {
          return this.bNb;
        }
        int j = k.zF().hashCode() + 779;
        int i = j;
        if (Bq()) {
          i = (j * 37 + 1) * 53 + this.bPp;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.bPq;
        }
        i = j;
        if (AF()) {
          i = (j * 37 + 3) * 53 + Br().hashCode();
        }
        i = i * 29 + this.bTW.hashCode();
        this.bNb = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bPe;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        if ((AF()) && (!Br().isInitialized()))
        {
          this.bPe = 0;
          return false;
        }
        this.bPe = 1;
        return true;
      }
      
      public final int yC()
      {
        int i = this.bNa;
        if (i != -1) {
          return i;
        }
        int j = 0;
        if ((this.bOT & 0x1) != 0) {
          j = i.bu(1, this.bPp) + 0;
        }
        i = j;
        if ((this.bOT & 0x2) != 0) {
          i = j + i.bu(2, this.bPq);
        }
        j = i;
        if ((this.bOT & 0x4) != 0) {
          j = i + i.c(3, Br());
        }
        i = j + this.bTW.yC();
        this.bNa = i;
        return i;
      }
      
      public static final class a
        extends ac.a<a>
        implements k.a.c
      {
        private int bOT;
        private bu<k.k, k.k.a, k.l> bPn;
        private int bPp;
        private int bPq;
        private k.k bPr;
        
        private a()
        {
          AR();
        }
        
        private a(ac.b paramb)
        {
          super();
          AR();
        }
        
        private void AR()
        {
          if (ac.bVU) {
            Bh();
          }
        }
        
        private bu<k.k, k.k.a, k.l> Bh()
        {
          if (this.bPn == null)
          {
            this.bPn = new bu(Br(), GA(), this.bWv);
            this.bPr = null;
          }
          return this.bPn;
        }
        
        private k.k Br()
        {
          if (this.bPn == null)
          {
            if (this.bPr == null) {
              return k.k.Ch();
            }
            return this.bPr;
          }
          return (k.k)this.bPn.Hu();
        }
        
        private k.a.b Bw()
        {
          int i = 0;
          k.a.b localb = new k.a.b(this, (byte)0);
          int k = this.bOT;
          if ((k & 0x1) != 0)
          {
            k.a.b.a(localb, this.bPp);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            k.a.b.b(localb, this.bPq);
            j = i | 0x2;
          }
          if ((k & 0x4) != 0) {
            if (this.bPn == null) {
              k.a.b.a(localb, this.bPr);
            }
          }
          for (i = j | 0x4;; i = j)
          {
            k.a.b.c(localb, i);
            Gy();
            return localb;
            k.a.b.a(localb, (k.k)this.bPn.Hv());
            break;
          }
        }
        
        private a a(k.k paramk)
        {
          if (this.bPn == null) {
            if (((this.bOT & 0x4) != 0) && (this.bPr != null) && (this.bPr != k.k.Ch()))
            {
              this.bPr = k.k.b(this.bPr).d(paramk).Cj();
              onChanged();
            }
          }
          for (;;)
          {
            this.bOT |= 0x4;
            return this;
            this.bPr = paramk;
            break;
            this.bPn.b(paramk);
          }
        }
        
        private a e(at paramat)
        {
          if ((paramat instanceof k.a.b)) {
            return b((k.a.b)paramat);
          }
          super.a(paramat);
          return this;
        }
        
        /* Error */
        private a f(h paramh, r paramr)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 142	com/google/a/k$a$b:bPg	Lcom/google/a/bj;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 147 3 0
          //   12: checkcast 14	com/google/a/k$a$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 131	com/google/a/k$a$b$a:b	(Lcom/google/a/k$a$b;)Lcom/google/a/k$a$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 151	com/google/a/af:bXr	Lcom/google/a/aw;
          //   33: checkcast 14	com/google/a/k$a$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 155	com/google/a/af:GF	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 131	com/google/a/k$a$b$a:b	(Lcom/google/a/k$a$b;)Lcom/google/a/k$a$b$a;
          //   52: pop
          //   53: aload_1
          //   54: athrow
          //   55: astore_1
          //   56: aload_3
          //   57: astore_2
          //   58: goto -15 -> 43
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	61	0	this	a
          //   0	61	1	paramh	h
          //   0	61	2	paramr	r
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/a/af
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a g(cc paramcc)
        {
          return (a)super.e(paramcc);
        }
        
        private a g(l.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a h(cc paramcc)
        {
          return (a)super.d(paramcc);
        }
        
        private a h(l.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        public final l.a AS()
        {
          return k.zF();
        }
        
        protected final ac.f Ay()
        {
          return k.zG().h(k.a.b.class, a.class);
        }
        
        public final k.a.b Bv()
        {
          k.a.b localb = Bw();
          if (!localb.isInitialized()) {
            throw b(localb);
          }
          return localb;
        }
        
        public final a b(k.a.b paramb)
        {
          if (paramb == k.a.b.Bu()) {
            return this;
          }
          if (paramb.Bq()) {
            gf(paramb.bPp);
          }
          if (paramb.hasEnd()) {
            gg(paramb.bPq);
          }
          if (paramb.AF()) {
            a(paramb.Br());
          }
          h(paramb.bTW);
          onChanged();
          return this;
        }
        
        public final a gf(int paramInt)
        {
          this.bOT |= 0x1;
          this.bPp = paramInt;
          onChanged();
          return this;
        }
        
        public final a gg(int paramInt)
        {
          this.bOT |= 0x2;
          this.bPq = paramInt;
          onChanged();
          return this;
        }
        
        public final boolean isInitialized()
        {
          if ((this.bOT & 0x4) != 0) {}
          for (int i = 1; (i != 0) && (!Br().isInitialized()); i = 0) {
            return false;
          }
          return true;
        }
      }
    }
    
    public static abstract interface c
      extends az
    {}
    
    public static final class d
      extends ac
      implements k.a.e
    {
      @Deprecated
      public static final bj<d> bPg = new c() {};
      private static final d bPt = new d();
      private int bOT;
      private byte bPe = -1;
      int bPp;
      int bPq;
      
      private d() {}
      
      private d(ac.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private d(h paramh, r paramr)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 33	com/google/a/k$a$d:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 56	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 57	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 63	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
        //   19: astore 5
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +145 -> 169
        //   27: aload_1
        //   28: invokevirtual 69	com/google/a/h:yT	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+148->183, 0:+151->186, 8:+51->86, 16:+96->131
        //   69: aload_1
        //   70: aload 5
        //   72: aload_2
        //   73: iload 4
        //   75: invokevirtual 72	com/google/a/k$a$d:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
        //   78: ifne -55 -> 23
        //   81: iconst_1
        //   82: istore_3
        //   83: goto -60 -> 23
        //   86: aload_0
        //   87: aload_0
        //   88: getfield 74	com/google/a/k$a$d:bOT	I
        //   91: iconst_1
        //   92: ior
        //   93: putfield 74	com/google/a/k$a$d:bOT	I
        //   96: aload_0
        //   97: aload_1
        //   98: invokevirtual 77	com/google/a/h:yW	()I
        //   101: putfield 79	com/google/a/k$a$d:bPp	I
        //   104: goto -81 -> 23
        //   107: astore_1
        //   108: aload_1
        //   109: aload_0
        //   110: putfield 83	com/google/a/af:bXr	Lcom/google/a/aw;
        //   113: aload_1
        //   114: athrow
        //   115: astore_1
        //   116: aload_0
        //   117: aload 5
        //   119: invokevirtual 89	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   122: putfield 93	com/google/a/k$a$d:bTW	Lcom/google/a/cc;
        //   125: aload_0
        //   126: invokevirtual 96	com/google/a/k$a$d:Gw	()V
        //   129: aload_1
        //   130: athrow
        //   131: aload_0
        //   132: aload_0
        //   133: getfield 74	com/google/a/k$a$d:bOT	I
        //   136: iconst_2
        //   137: ior
        //   138: putfield 74	com/google/a/k$a$d:bOT	I
        //   141: aload_0
        //   142: aload_1
        //   143: invokevirtual 77	com/google/a/h:yW	()I
        //   146: putfield 98	com/google/a/k$a$d:bPq	I
        //   149: goto -126 -> 23
        //   152: astore_1
        //   153: new 52	com/google/a/af
        //   156: dup
        //   157: aload_1
        //   158: invokespecial 101	com/google/a/af:<init>	(Ljava/io/IOException;)V
        //   161: astore_1
        //   162: aload_1
        //   163: aload_0
        //   164: putfield 83	com/google/a/af:bXr	Lcom/google/a/aw;
        //   167: aload_1
        //   168: athrow
        //   169: aload_0
        //   170: aload 5
        //   172: invokevirtual 89	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   175: putfield 93	com/google/a/k$a$d:bTW	Lcom/google/a/cc;
        //   178: aload_0
        //   179: invokevirtual 96	com/google/a/k$a$d:Gw	()V
        //   182: return
        //   183: goto -115 -> 68
        //   186: iconst_1
        //   187: istore_3
        //   188: goto -165 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	191	0	this	d
        //   0	191	1	paramh	h
        //   0	191	2	paramr	r
        //   22	166	3	i	int
        //   31	43	4	j	int
        //   19	152	5	locala	cc.a
        // Exception table:
        //   from	to	target	type
        //   27	33	107	com/google/a/af
        //   68	81	107	com/google/a/af
        //   86	104	107	com/google/a/af
        //   131	149	107	com/google/a/af
        //   27	33	115	finally
        //   68	81	115	finally
        //   86	104	115	finally
        //   108	115	115	finally
        //   131	149	115	finally
        //   153	169	115	finally
        //   27	33	152	java/io/IOException
        //   68	81	152	java/io/IOException
        //   86	104	152	java/io/IOException
        //   131	149	152	java/io/IOException
      }
      
      private a Bx()
      {
        if (this == bPt) {
          return new a((byte)0);
        }
        return new a((byte)0).a(this);
      }
      
      public static d By()
      {
        return bPt;
      }
      
      public final bj<d> AK()
      {
        return bPg;
      }
      
      public final cc Ax()
      {
        return this.bTW;
      }
      
      protected final ac.f Ay()
      {
        return k.zI().h(d.class, a.class);
      }
      
      public final boolean Bq()
      {
        return (this.bOT & 0x1) != 0;
      }
      
      public final void a(i parami)
      {
        if ((this.bOT & 0x1) != 0) {
          parami.bs(1, this.bPp);
        }
        if ((this.bOT & 0x2) != 0) {
          parami.bs(2, this.bPq);
        }
        this.bTW.a(parami);
      }
      
      public final boolean equals(Object paramObject)
      {
        if (paramObject == this) {}
        do
        {
          return true;
          if (!(paramObject instanceof d)) {
            return super.equals(paramObject);
          }
          paramObject = (d)paramObject;
          if (Bq() != paramObject.Bq()) {
            return false;
          }
          if ((Bq()) && (this.bPp != paramObject.bPp)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.bPq != paramObject.bPq)) {
            return false;
          }
        } while (this.bTW.equals(paramObject.bTW));
        return false;
      }
      
      public final boolean hasEnd()
      {
        return (this.bOT & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.bNb != 0) {
          return this.bNb;
        }
        int j = k.zH().hashCode() + 779;
        int i = j;
        if (Bq()) {
          i = (j * 37 + 1) * 53 + this.bPp;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.bPq;
        }
        i = j * 29 + this.bTW.hashCode();
        this.bNb = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bPe;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.bPe = 1;
        return true;
      }
      
      public final int yC()
      {
        int i = this.bNa;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bOT & 0x1) != 0) {
          i = i.bu(1, this.bPp) + 0;
        }
        int j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.bu(2, this.bPq);
        }
        i = j + this.bTW.yC();
        this.bNa = i;
        return i;
      }
      
      public static final class a
        extends ac.a<a>
        implements k.a.e
      {
        private int bOT;
        private int bPp;
        private int bPq;
        
        private a()
        {
          boolean bool = ac.bVU;
        }
        
        private a(ac.b paramb)
        {
          super();
          boolean bool = ac.bVU;
        }
        
        private k.a.d BA()
        {
          int i = 0;
          k.a.d locald = new k.a.d(this, (byte)0);
          int k = this.bOT;
          if ((k & 0x1) != 0)
          {
            k.a.d.a(locald, this.bPp);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            k.a.d.b(locald, this.bPq);
            j = i | 0x2;
          }
          k.a.d.c(locald, j);
          Gy();
          return locald;
        }
        
        private k.a.d Bz()
        {
          k.a.d locald = BA();
          if (!locald.isInitialized()) {
            throw b(locald);
          }
          return locald;
        }
        
        private a f(at paramat)
        {
          if ((paramat instanceof k.a.d)) {
            return a((k.a.d)paramat);
          }
          super.a(paramat);
          return this;
        }
        
        /* Error */
        private a g(h paramh, r paramr)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 86	com/google/a/k$a$d:bPg	Lcom/google/a/bj;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 91 3 0
          //   12: checkcast 14	com/google/a/k$a$d
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 75	com/google/a/k$a$d$a:a	(Lcom/google/a/k$a$d;)Lcom/google/a/k$a$d$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 95	com/google/a/af:bXr	Lcom/google/a/aw;
          //   33: checkcast 14	com/google/a/k$a$d
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 99	com/google/a/af:GF	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 75	com/google/a/k$a$d$a:a	(Lcom/google/a/k$a$d;)Lcom/google/a/k$a$d$a;
          //   52: pop
          //   53: aload_1
          //   54: athrow
          //   55: astore_1
          //   56: aload_3
          //   57: astore_2
          //   58: goto -15 -> 43
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	61	0	this	a
          //   0	61	1	paramh	h
          //   0	61	2	paramr	r
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/a/af
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a gh(int paramInt)
        {
          this.bOT |= 0x1;
          this.bPp = paramInt;
          onChanged();
          return this;
        }
        
        private a gi(int paramInt)
        {
          this.bOT |= 0x2;
          this.bPq = paramInt;
          onChanged();
          return this;
        }
        
        private a i(cc paramcc)
        {
          return (a)super.e(paramcc);
        }
        
        private a i(l.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a j(cc paramcc)
        {
          return (a)super.d(paramcc);
        }
        
        private a j(l.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        public final l.a AS()
        {
          return k.zH();
        }
        
        protected final ac.f Ay()
        {
          return k.zI().h(k.a.d.class, a.class);
        }
        
        public final a a(k.a.d paramd)
        {
          if (paramd == k.a.d.By()) {
            return this;
          }
          if (paramd.Bq()) {
            gh(paramd.bPp);
          }
          if (paramd.hasEnd()) {
            gi(paramd.bPq);
          }
          j(paramd.bTW);
          onChanged();
          return this;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
    
    public static abstract interface e
      extends az
    {}
  }
  
  public static final class aa
    extends ac
    implements k.ab
  {
    @Deprecated
    public static final bj<aa> bPg = new c() {};
    private static final aa bRL = new aa();
    private int bOT;
    private volatile Object bOU;
    private byte bPe = -1;
    private k.ac bRK;
    
    private aa()
    {
      this.bOU = "";
    }
    
    private aa(ac.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private aa(h paramh, r paramr)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 33	com/google/a/k$aa:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 60	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 61	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 67	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +198 -> 222
      //   27: aload_1
      //   28: invokevirtual 73	com/google/a/h:yT	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+210->245, 0:+216->251, 10:+51->86, 18:+100->135
      //   69: aload_1
      //   70: aload 6
      //   72: aload_2
      //   73: iload 4
      //   75: invokevirtual 76	com/google/a/k$aa:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
      //   78: ifne +158 -> 236
      //   81: iconst_1
      //   82: istore_3
      //   83: goto +165 -> 248
      //   86: aload_1
      //   87: invokevirtual 80	com/google/a/h:zb	()Lcom/google/a/g;
      //   90: astore 5
      //   92: aload_0
      //   93: aload_0
      //   94: getfield 82	com/google/a/k$aa:bOT	I
      //   97: iconst_1
      //   98: ior
      //   99: putfield 82	com/google/a/k$aa:bOT	I
      //   102: aload_0
      //   103: aload 5
      //   105: putfield 46	com/google/a/k$aa:bOU	Ljava/lang/Object;
      //   108: goto -85 -> 23
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 86	com/google/a/af:bXr	Lcom/google/a/aw;
      //   117: aload_1
      //   118: athrow
      //   119: astore_1
      //   120: aload_0
      //   121: aload 6
      //   123: invokevirtual 92	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   126: putfield 96	com/google/a/k$aa:bTW	Lcom/google/a/cc;
      //   129: aload_0
      //   130: invokevirtual 99	com/google/a/k$aa:Gw	()V
      //   133: aload_1
      //   134: athrow
      //   135: aload_0
      //   136: getfield 82	com/google/a/k$aa:bOT	I
      //   139: iconst_2
      //   140: iand
      //   141: ifeq +98 -> 239
      //   144: aload_0
      //   145: getfield 101	com/google/a/k$aa:bRK	Lcom/google/a/k$ac;
      //   148: invokevirtual 107	com/google/a/k$ac:Et	()Lcom/google/a/k$ac$a;
      //   151: astore 5
      //   153: aload_0
      //   154: aload_1
      //   155: getstatic 108	com/google/a/k$ac:bPg	Lcom/google/a/bj;
      //   158: aload_2
      //   159: invokevirtual 111	com/google/a/h:a	(Lcom/google/a/bj;Lcom/google/a/r;)Lcom/google/a/aw;
      //   162: checkcast 103	com/google/a/k$ac
      //   165: putfield 101	com/google/a/k$aa:bRK	Lcom/google/a/k$ac;
      //   168: aload 5
      //   170: ifnull +22 -> 192
      //   173: aload 5
      //   175: aload_0
      //   176: getfield 101	com/google/a/k$aa:bRK	Lcom/google/a/k$ac;
      //   179: invokevirtual 117	com/google/a/k$ac$a:d	(Lcom/google/a/k$ac;)Lcom/google/a/k$ac$a;
      //   182: pop
      //   183: aload_0
      //   184: aload 5
      //   186: invokevirtual 121	com/google/a/k$ac$a:Ew	()Lcom/google/a/k$ac;
      //   189: putfield 101	com/google/a/k$aa:bRK	Lcom/google/a/k$ac;
      //   192: aload_0
      //   193: aload_0
      //   194: getfield 82	com/google/a/k$aa:bOT	I
      //   197: iconst_2
      //   198: ior
      //   199: putfield 82	com/google/a/k$aa:bOT	I
      //   202: goto -179 -> 23
      //   205: astore_1
      //   206: new 56	com/google/a/af
      //   209: dup
      //   210: aload_1
      //   211: invokespecial 124	com/google/a/af:<init>	(Ljava/io/IOException;)V
      //   214: astore_1
      //   215: aload_1
      //   216: aload_0
      //   217: putfield 86	com/google/a/af:bXr	Lcom/google/a/aw;
      //   220: aload_1
      //   221: athrow
      //   222: aload_0
      //   223: aload 6
      //   225: invokevirtual 92	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   228: putfield 96	com/google/a/k$aa:bTW	Lcom/google/a/cc;
      //   231: aload_0
      //   232: invokevirtual 99	com/google/a/k$aa:Gw	()V
      //   235: return
      //   236: goto +12 -> 248
      //   239: aconst_null
      //   240: astore 5
      //   242: goto -89 -> 153
      //   245: goto -177 -> 68
      //   248: goto -225 -> 23
      //   251: iconst_1
      //   252: istore_3
      //   253: goto -230 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	256	0	this	aa
      //   0	256	1	paramh	h
      //   0	256	2	paramr	r
      //   22	231	3	i	int
      //   31	43	4	j	int
      //   90	151	5	localObject	Object
      //   19	205	6	locala	cc.a
      // Exception table:
      //   from	to	target	type
      //   27	33	111	com/google/a/af
      //   68	81	111	com/google/a/af
      //   86	108	111	com/google/a/af
      //   135	153	111	com/google/a/af
      //   153	168	111	com/google/a/af
      //   173	192	111	com/google/a/af
      //   192	202	111	com/google/a/af
      //   27	33	119	finally
      //   68	81	119	finally
      //   86	108	119	finally
      //   112	119	119	finally
      //   135	153	119	finally
      //   153	168	119	finally
      //   173	192	119	finally
      //   192	202	119	finally
      //   206	222	119	finally
      //   27	33	205	java/io/IOException
      //   68	81	205	java/io/IOException
      //   86	108	205	java/io/IOException
      //   135	153	205	java/io/IOException
      //   153	168	205	java/io/IOException
      //   173	192	205	java/io/IOException
      //   192	202	205	java/io/IOException
    }
    
    private a Ep()
    {
      if (this == bRL) {
        return new a((byte)0);
      }
      return new a((byte)0).b(this);
    }
    
    public static aa Eq()
    {
      return bRL;
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final bj<aa> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zO().h(aa.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final k.ac Eo()
    {
      if (this.bRK == null) {
        return k.ac.Eu();
      }
      return this.bRK;
    }
    
    public final void a(i parami)
    {
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.a(2, Eo());
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof aa)) {
          return super.equals(paramObject);
        }
        paramObject = (aa)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!Eo().equals(paramObject.Eo()))) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zN().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (AF()) {
        j = (i * 37 + 2) * 53 + Eo().hashCode();
      }
      i = j * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bPe;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((AF()) && (!Eo().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bOT & 0x1) != 0) {
        i = ac.d(1, this.bOU) + 0;
      }
      int j = i;
      if ((this.bOT & 0x2) != 0) {
        j = i + i.c(2, Eo());
      }
      i = j + this.bTW.yC();
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.a<a>
      implements k.ab
    {
      private int bOT;
      private Object bOU = "";
      private bu<k.ac, k.ac.a, k.ad> bPn;
      private k.ac bRK;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          Bh();
        }
      }
      
      private bu<k.ac, k.ac.a, k.ad> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(Eo(), GA(), this.bWv);
          this.bRK = null;
        }
        return this.bPn;
      }
      
      private k.ac Eo()
      {
        if (this.bPn == null)
        {
          if (this.bRK == null) {
            return k.ac.Eu();
          }
          return this.bRK;
        }
        return (k.ac)this.bPn.Hu();
      }
      
      private k.aa Er()
      {
        k.aa localaa = Es();
        if (!localaa.isInitialized()) {
          throw b(localaa);
        }
        return localaa;
      }
      
      private k.aa Es()
      {
        k.aa localaa = new k.aa(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          k.aa.a(localaa, this.bOU);
          int j = i;
          if ((k & 0x2) != 0)
          {
            if (this.bPn != null) {
              break label77;
            }
            k.aa.a(localaa, this.bRK);
          }
          for (;;)
          {
            j = i | 0x2;
            k.aa.a(localaa, j);
            Gy();
            return localaa;
            label77:
            k.aa.a(localaa, (k.ac)this.bPn.Hv());
          }
        }
      }
      
      private a K(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a L(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a M(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a N(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a a(k.ac paramac)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x2) != 0) && (this.bRK != null) && (this.bRK != k.ac.Eu()))
          {
            this.bRK = k.ac.b(this.bRK).d(paramac).Ew();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x2;
          return this;
          this.bRK = paramac;
          break;
          this.bPn.b(paramac);
        }
      }
      
      private a t(at paramat)
      {
        if ((paramat instanceof k.aa)) {
          return b((k.aa)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a u(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 167	com/google/a/k$aa:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 172 3 0
        //   12: checkcast 9	com/google/a/k$aa
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 156	com/google/a/k$aa$a:b	(Lcom/google/a/k$aa;)Lcom/google/a/k$aa$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 176	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$aa
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 180	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 156	com/google/a/k$aa$a:b	(Lcom/google/a/k$aa;)Lcom/google/a/k$aa$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.zN();
      }
      
      protected final ac.f Ay()
      {
        return k.zO().h(k.aa.class, a.class);
      }
      
      public final a b(k.aa paramaa)
      {
        if (paramaa == k.aa.Eq()) {
          return this;
        }
        if (paramaa.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.aa.a(paramaa);
          onChanged();
        }
        if (paramaa.AF()) {
          a(paramaa.Eo());
        }
        L(paramaa.bTW);
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bOT & 0x2) != 0) {}
        for (int i = 1; (i != 0) && (!Eo().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
  }
  
  public static abstract interface ab
    extends az
  {}
  
  public static final class ac
    extends ac.d<ac>
    implements k.ad
  {
    @Deprecated
    public static final bj<ac> bPg = new c() {};
    private static final ac bRM = new ac();
    private List<k.ak> bPB;
    private byte bPe = -1;
    
    private ac()
    {
      this.bPB = Collections.emptyList();
    }
    
    private ac(ac.c<ac, ?> paramc)
    {
      super();
    }
    
    private ac(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      int n;
      int i1;
      int k;
      label205:
      label240:
      for (;;)
      {
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        try
        {
          j = paramh.yT();
          switch (j)
          {
          }
        }
        catch (af paramh)
        {
          try
          {
            int j;
            paramh.bXr = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.bPB = Collections.unmodifiableList(this.bPB);
          this.bTW = locala.HM();
          this.bWd.yK();
          throw paramh;
          if ((i & 0x1) == 0) {
            break label240;
          }
          this.bPB = Collections.unmodifiableList(this.bPB);
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new af(paramh);
          k = i1;
          paramh.bXr = this;
          k = i1;
          throw paramh;
        }
        finally
        {
          for (;;) {}
          m = 1;
        }
        n = i;
        i1 = i;
        k = i;
        if (!a(paramh, locala, paramr, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bPB = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.bPB.add(paramh.a(k.ak.bPg, paramr));
          i = j;
        }
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static ac Eu()
    {
      return bRM;
    }
    
    public static a b(ac paramac)
    {
      return bRM.Et().d(paramac);
    }
    
    public final bj<ac> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Ag().h(ac.class, a.class);
    }
    
    public final a Et()
    {
      if (this == bRM) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof ac)) {
          return super.equals(paramObject);
        }
        paramObject = (ac)paramObject;
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Af().hashCode() + 779;
      int i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.bPB.size())
      {
        j += i.c(999, (aw)this.bPB.get(i));
        i += 1;
      }
      i = this.bWd.yC() + j + this.bTW.yC();
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.c<k.ac, a>
      implements k.ad
    {
      private int bOT;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x1) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x1;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.ac Ev()
      {
        k.ac localac = Ew();
        if (!localac.isInitialized()) {
          throw b(localac);
        }
        return localac;
      }
      
      private a M(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a N(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a O(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a P(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a u(at paramat)
      {
        if ((paramat instanceof k.ac)) {
          return d((k.ac)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a v(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 129	com/google/a/k$ac:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 134 3 0
        //   12: checkcast 9	com/google/a/k$ac
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 118	com/google/a/k$ac$a:d	(Lcom/google/a/k$ac;)Lcom/google/a/k$ac$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 138	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$ac
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 142	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 118	com/google/a/k$ac$a:d	(Lcom/google/a/k$ac;)Lcom/google/a/k$ac$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.Af();
      }
      
      protected final ac.f Ay()
      {
        return k.Ag().h(k.ac.class, a.class);
      }
      
      public final k.ac Ew()
      {
        k.ac localac = new k.ac(this, (byte)0);
        if (this.bPD == null)
        {
          if ((this.bOT & 0x1) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFFE;
          }
          k.ac.a(localac, this.bPB);
        }
        for (;;)
        {
          Gy();
          return localac;
          k.ac.a(localac, this.bPD.build());
        }
      }
      
      public final a d(k.ac paramac)
      {
        bq localbq = null;
        if (paramac == k.ac.Eu()) {
          return this;
        }
        if (this.bPD == null) {
          if (!k.ac.c(paramac).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label85;
            }
            this.bPB = k.ac.c(paramac);
            this.bOT &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramac);
          N(paramac.bTW);
          onChanged();
          return this;
          label85:
          BT();
          this.bPB.addAll(k.ac.c(paramac));
          break;
          if (!k.ac.c(paramac).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.ac.c(paramac);
              this.bOT &= 0xFFFFFFFE;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.ac.c(paramac));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static abstract interface ad
    extends ac.e
  {}
  
  public static final class ae
    extends ac
    implements k.af
  {
    @Deprecated
    public static final bj<ae> bPg = new c() {};
    private static final ae bRP = new ae();
    private int bOT;
    private volatile Object bOU;
    private byte bPe = -1;
    private List<k.w> bRN;
    private k.ag bRO;
    
    private ae()
    {
      this.bOU = "";
      this.bRN = Collections.emptyList();
    }
    
    private ae(ac.a<?> parama)
    {
      super();
    }
    
    private ae(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int k = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int m;
        if (k == 0)
        {
          n = i;
          i1 = i;
          m = i;
        }
        int j;
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 10: 
              n = i;
              i1 = i;
              m = i;
              if (a(paramh, locala, paramr, j)) {
                break label476;
              }
              j = 1;
              break label492;
              n = i;
              i1 = i;
              m = i;
              localObject = paramh.zb();
              n = i;
              i1 = i;
              m = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              m = i;
              this.bOU = localObject;
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              m = n;
              if ((m & 0x2) != 0) {
                this.bRN = Collections.unmodifiableList(this.bRN);
              }
              this.bTW = locala.HM();
              Gw();
            }
            j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              m = i;
              this.bRN = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            m = j;
            this.bRN.add(paramh.a(k.w.bPg, paramr));
            i = j;
            break;
          }
          catch (IOException paramh)
          {
            m = i1;
            paramh = new af(paramh);
            m = i1;
            paramh.bXr = this;
            m = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            m = i;
            if ((this.bOT & 0x2) == 0) {
              break label483;
            }
          }
          n = i;
          i1 = i;
          m = i;
          label476:
          label483:
          for (Object localObject = this.bRO.EF();; localObject = null)
          {
            n = i;
            i1 = i;
            m = i;
            this.bRO = ((k.ag)paramh.a(k.ag.bPg, paramr));
            if (localObject != null)
            {
              n = i;
              i1 = i;
              m = i;
              ((k.ag.a)localObject).d(this.bRO);
              n = i;
              i1 = i;
              m = i;
              this.bRO = ((k.ag.a)localObject).EI();
            }
            n = i;
            i1 = i;
            m = i;
            this.bOT |= 0x2;
            break;
            if ((i & 0x2) != 0) {
              this.bRN = Collections.unmodifiableList(this.bRN);
            }
            this.bTW = locala.HM();
            Gw();
            return;
            j = k;
            break label492;
          }
        }
        label492:
        k = j;
        continue;
        k = 1;
      }
    }
    
    public static ae EA()
    {
      return bRP;
    }
    
    private a Ez()
    {
      if (this == bRP) {
        return new a((byte)0);
      }
      return new a((byte)0).c(this);
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final bj<ae> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zW().h(ae.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final int Ex()
    {
      return this.bRN.size();
    }
    
    public final k.ag Ey()
    {
      if (this.bRO == null) {
        return k.ag.EG();
      }
      return this.bRO;
    }
    
    public final void a(i parami)
    {
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      int i = 0;
      while (i < this.bRN.size())
      {
        parami.a(2, (aw)this.bRN.get(i));
        i += 1;
      }
      if ((this.bOT & 0x2) != 0) {
        parami.a(3, Ey());
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof ae)) {
          return super.equals(paramObject);
        }
        paramObject = (ae)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.bRN.equals(paramObject.bRN)) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!Ey().equals(paramObject.Ey()))) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final k.w gx(int paramInt)
    {
      return (k.w)this.bRN.get(paramInt);
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zV().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (Ex() > 0) {
        j = (i * 37 + 2) * 53 + this.bRN.hashCode();
      }
      i = j;
      if (AF()) {
        i = (j * 37 + 3) * 53 + Ey().hashCode();
      }
      i = i * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ex())
      {
        if (!gx(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if ((AF()) && (!Ey().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int j = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {
        i = ac.d(1, this.bOU) + 0;
      }
      for (;;)
      {
        if (j < this.bRN.size())
        {
          int k = i.c(2, (aw)this.bRN.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          j = i;
          if ((this.bOT & 0x2) != 0) {
            j = i + i.c(3, Ey());
          }
          i = this.bTW.yC() + j;
          this.bNa = i;
          return i;
          i = 0;
        }
      }
    }
    
    public static final class a
      extends ac.a<a>
      implements k.af
    {
      private int bOT;
      private Object bOU = "";
      private bu<k.ag, k.ag.a, k.ah> bPn;
      private List<k.w> bRN = Collections.emptyList();
      private k.ag bRO;
      private bq<k.w, k.w.a, k.x> bRQ;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU)
        {
          EE();
          Bh();
        }
      }
      
      private bu<k.ag, k.ag.a, k.ah> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(Ey(), GA(), this.bWv);
          this.bRO = null;
        }
        return this.bPn;
      }
      
      private k.ae EB()
      {
        k.ae localae = EC();
        if (!localae.isInitialized()) {
          throw b(localae);
        }
        return localae;
      }
      
      private k.ae EC()
      {
        k.ae localae = new k.ae(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          k.ae.a(localae, this.bOU);
          int j;
          if (this.bRQ == null)
          {
            if ((this.bOT & 0x2) != 0)
            {
              this.bRN = Collections.unmodifiableList(this.bRN);
              this.bOT &= 0xFFFFFFFD;
            }
            k.ae.a(localae, this.bRN);
            j = i;
            if ((k & 0x4) != 0)
            {
              if (this.bPn != null) {
                break label141;
              }
              k.ae.a(localae, this.bRO);
            }
          }
          for (;;)
          {
            j = i | 0x2;
            k.ae.a(localae, j);
            Gy();
            return localae;
            k.ae.a(localae, this.bRQ.build());
            break;
            label141:
            k.ae.a(localae, (k.ag)this.bPn.Hv());
          }
        }
      }
      
      private void ED()
      {
        if ((this.bOT & 0x2) == 0)
        {
          this.bRN = new ArrayList(this.bRN);
          this.bOT |= 0x2;
        }
      }
      
      private bq<k.w, k.w.a, k.x> EE()
      {
        List localList;
        if (this.bRQ == null)
        {
          localList = this.bRN;
          if ((this.bOT & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRQ = new bq(localList, bool, GA(), this.bWv);
          this.bRN = null;
          return this.bRQ;
        }
      }
      
      private k.ag Ey()
      {
        if (this.bPn == null)
        {
          if (this.bRO == null) {
            return k.ag.EG();
          }
          return this.bRO;
        }
        return (k.ag)this.bPn.Hu();
      }
      
      private a O(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a P(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a Q(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a R(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a a(k.ag paramag)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x4) != 0) && (this.bRO != null) && (this.bRO != k.ag.EG()))
          {
            this.bRO = k.ag.b(this.bRO).d(paramag).EI();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x4;
          return this;
          this.bRO = paramag;
          break;
          this.bPn.b(paramag);
        }
      }
      
      private a v(at paramat)
      {
        if ((paramat instanceof k.ae)) {
          return c((k.ae)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a w(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 209	com/google/a/k$ae:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 214 3 0
        //   12: checkcast 9	com/google/a/k$ae
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 198	com/google/a/k$ae$a:c	(Lcom/google/a/k$ae;)Lcom/google/a/k$ae$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 218	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$ae
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 222	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 198	com/google/a/k$ae$a:c	(Lcom/google/a/k$ae;)Lcom/google/a/k$ae$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.zV();
      }
      
      protected final ac.f Ay()
      {
        return k.zW().h(k.ae.class, a.class);
      }
      
      public final a c(k.ae paramae)
      {
        bq localbq = null;
        if (paramae == k.ae.EA()) {
          return this;
        }
        if (paramae.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.ae.a(paramae);
          onChanged();
        }
        if (this.bRQ == null) {
          if (!k.ae.b(paramae).isEmpty())
          {
            if (!this.bRN.isEmpty()) {
              break label125;
            }
            this.bRN = k.ae.b(paramae);
            this.bOT &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          if (paramae.AF()) {
            a(paramae.Ey());
          }
          P(paramae.bTW);
          onChanged();
          return this;
          label125:
          ED();
          this.bRN.addAll(k.ae.b(paramae));
          break;
          if (!k.ae.b(paramae).isEmpty()) {
            if (this.bRQ.isEmpty())
            {
              this.bRQ.bYP = null;
              this.bRQ = null;
              this.bRN = k.ae.b(paramae);
              this.bOT &= 0xFFFFFFFD;
              if (ac.bVU) {
                localbq = EE();
              }
              this.bRQ = localbq;
            }
            else
            {
              this.bRQ.a(k.ae.b(paramae));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        k.w localw;
        if (this.bRQ == null)
        {
          j = this.bRN.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRQ != null) {
            break label65;
          }
          localw = (k.w)this.bRN.get(i);
          label45:
          if (localw.isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bRQ.getCount();
          break label19;
          label65:
          localw = (k.w)this.bRQ.s(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          if ((this.bOT & 0x4) != 0) {}
          for (i = 1; (i == 0) || (Ey().isInitialized()); i = 0) {
            return true;
          }
        }
      }
    }
  }
  
  public static abstract interface af
    extends az
  {}
  
  public static final class ag
    extends ac.d<ag>
    implements k.ah
  {
    @Deprecated
    public static final bj<ag> bPg = new c() {};
    private static final ag bRR = new ag();
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    
    private ag()
    {
      this.bPB = Collections.emptyList();
    }
    
    private ag(ac.c<ag, ?> paramc)
    {
      super();
    }
    
    private ag(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 264: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bPA = paramh.yZ();
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally {}
            if ((k & 0x2) != 0) {
              this.bPB = Collections.unmodifiableList(this.bPB);
            }
            this.bTW = locala.HM();
            this.bWd.yK();
            throw paramh;
            int j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.bPB = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            k = j;
            this.bPB.add(paramh.a(k.ak.bPg, paramr));
            i = j;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
          }
          if ((i & 0x2) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static ag EG()
    {
      return bRR;
    }
    
    public static a b(ag paramag)
    {
      return bRR.EF().d(paramag);
    }
    
    public final bj<ag> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Am().h(ag.class, a.class);
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final a EF()
    {
      if (this == bRR) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        parami.r(33, this.bPA);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof ag)) {
          return super.equals(paramObject);
        }
        paramObject = (ag)paramObject;
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Al().hashCode() + 779;
      int i = j;
      if (BN()) {
        i = (j * 37 + 33) * 53 + ae.bF(this.bPA);
      }
      j = i;
      if (BO() > 0) {
        j = (i * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(j, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int j = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {
        i = i.fR(33) + 0;
      }
      for (;;)
      {
        if (j < this.bPB.size())
        {
          int k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          i = this.bWd.yC() + i + this.bTW.yC();
          this.bNa = i;
          return i;
          i = 0;
        }
      }
    }
    
    public static final class a
      extends ac.c<k.ag, a>
      implements k.ah
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x2) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x2;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.ag EH()
      {
        k.ag localag = EI();
        if (!localag.isInitialized()) {
          throw b(localag);
        }
        return localag;
      }
      
      private a Q(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a R(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a S(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a T(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a bC(boolean paramBoolean)
      {
        this.bOT |= 0x1;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a w(at paramat)
      {
        if ((paramat instanceof k.ag)) {
          return d((k.ag)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a x(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 137	com/google/a/k$ag:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 142 3 0
        //   12: checkcast 9	com/google/a/k$ag
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 126	com/google/a/k$ag$a:d	(Lcom/google/a/k$ag;)Lcom/google/a/k$ag$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 146	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$ag
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 150	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 126	com/google/a/k$ag$a:d	(Lcom/google/a/k$ag;)Lcom/google/a/k$ag$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.Al();
      }
      
      protected final ac.f Ay()
      {
        return k.Am().h(k.ag.class, a.class);
      }
      
      public final k.ag EI()
      {
        int i = 0;
        k.ag localag = new k.ag(this, (byte)0);
        if ((this.bOT & 0x1) != 0)
        {
          k.ag.a(localag, this.bPA);
          i = 1;
        }
        if (this.bPD == null)
        {
          if ((this.bOT & 0x2) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFFD;
          }
          k.ag.a(localag, this.bPB);
        }
        for (;;)
        {
          k.ag.a(localag, i);
          Gy();
          return localag;
          k.ag.a(localag, this.bPD.build());
        }
      }
      
      public final a d(k.ag paramag)
      {
        bq localbq = null;
        if (paramag == k.ag.EG()) {
          return this;
        }
        if (paramag.BN()) {
          bC(paramag.bPA);
        }
        if (this.bPD == null) {
          if (!k.ag.c(paramag).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label101;
            }
            this.bPB = k.ag.c(paramag);
            this.bOT &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramag);
          R(paramag.bTW);
          onChanged();
          return this;
          label101:
          BT();
          this.bPB.addAll(k.ag.c(paramag));
          break;
          if (!k.ag.c(paramag).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.ag.c(paramag);
              this.bOT &= 0xFFFFFFFD;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.ag.c(paramag));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static abstract interface ah
    extends ac.e
  {}
  
  public static final class ai
    extends ac
    implements k.aj
  {
    @Deprecated
    public static final bj<ai> bPg = new c() {};
    private static final ai bRT = new ai();
    private byte bPe = -1;
    private List<b> bRS;
    
    private ai()
    {
      this.bRS = Collections.emptyList();
    }
    
    private ai(ac.a<?> parama)
    {
      super();
    }
    
    private ai(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      int n;
      int i1;
      int k;
      label205:
      label237:
      for (;;)
      {
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        try
        {
          j = paramh.yT();
          switch (j)
          {
          }
        }
        catch (af paramh)
        {
          try
          {
            int j;
            paramh.bXr = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.bRS = Collections.unmodifiableList(this.bRS);
          this.bTW = locala.HM();
          Gw();
          throw paramh;
          if ((i & 0x1) == 0) {
            break label237;
          }
          this.bRS = Collections.unmodifiableList(this.bRS);
          this.bTW = locala.HM();
          Gw();
          return;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new af(paramh);
          k = i1;
          paramh.bXr = this;
          k = i1;
          throw paramh;
        }
        finally
        {
          for (;;) {}
          m = 1;
        }
        n = i;
        i1 = i;
        k = i;
        if (!a(paramh, locala, paramr, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bRS = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.bRS.add(paramh.a(b.bPg, paramr));
          i = j;
        }
      }
    }
    
    public static ai EK()
    {
      return bRT;
    }
    
    public static a b(ai paramai)
    {
      return bRT.EJ().d(paramai);
    }
    
    public final bj<ai> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Au().h(ai.class, a.class);
    }
    
    public final a EJ()
    {
      if (this == bRT) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      int i = 0;
      while (i < this.bRS.size())
      {
        parami.a(1, (aw)this.bRS.get(i));
        i += 1;
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof ai)) {
          return super.equals(paramObject);
        }
        paramObject = (ai)paramObject;
        if (!this.bRS.equals(paramObject.bRS)) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.At().hashCode() + 779;
      int i = j;
      if (this.bRS.size() > 0) {
        i = (j * 37 + 1) * 53 + this.bRS.hashCode();
      }
      i = i * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bPe;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.bRS.size())
      {
        j += i.c(1, (aw)this.bRS.get(i));
        i += 1;
      }
      i = this.bTW.yC() + j;
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.a<a>
      implements k.aj
    {
      private int bOT;
      private List<k.ai.b> bRS = Collections.emptyList();
      private bq<k.ai.b, k.ai.b.a, k.ai.c> bRU;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          EO();
        }
      }
      
      private k.ai EL()
      {
        k.ai localai = EM();
        if (!localai.isInitialized()) {
          throw b(localai);
        }
        return localai;
      }
      
      private void EN()
      {
        if ((this.bOT & 0x1) == 0)
        {
          this.bRS = new ArrayList(this.bRS);
          this.bOT |= 0x1;
        }
      }
      
      private bq<k.ai.b, k.ai.b.a, k.ai.c> EO()
      {
        List localList;
        if (this.bRU == null)
        {
          localList = this.bRS;
          if ((this.bOT & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRU = new bq(localList, bool, GA(), this.bWv);
          this.bRS = null;
          return this.bRU;
        }
      }
      
      private a S(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a T(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a U(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a V(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a x(at paramat)
      {
        if ((paramat instanceof k.ai)) {
          return d((k.ai)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a y(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 126	com/google/a/k$ai:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 131 3 0
        //   12: checkcast 9	com/google/a/k$ai
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 115	com/google/a/k$ai$a:d	(Lcom/google/a/k$ai;)Lcom/google/a/k$ai$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 135	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$ai
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 139	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 115	com/google/a/k$ai$a:d	(Lcom/google/a/k$ai;)Lcom/google/a/k$ai$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.At();
      }
      
      protected final ac.f Ay()
      {
        return k.Au().h(k.ai.class, a.class);
      }
      
      public final k.ai EM()
      {
        k.ai localai = new k.ai(this, (byte)0);
        if (this.bRU == null)
        {
          if ((this.bOT & 0x1) != 0)
          {
            this.bRS = Collections.unmodifiableList(this.bRS);
            this.bOT &= 0xFFFFFFFE;
          }
          k.ai.a(localai, this.bRS);
        }
        for (;;)
        {
          Gy();
          return localai;
          k.ai.a(localai, this.bRU.build());
        }
      }
      
      public final a d(k.ai paramai)
      {
        bq localbq = null;
        if (paramai == k.ai.EK()) {
          return this;
        }
        if (this.bRU == null) {
          if (!k.ai.c(paramai).isEmpty())
          {
            if (!this.bRS.isEmpty()) {
              break label80;
            }
            this.bRS = k.ai.c(paramai);
            this.bOT &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          T(paramai.bTW);
          onChanged();
          return this;
          label80:
          EN();
          this.bRS.addAll(k.ai.c(paramai));
          break;
          if (!k.ai.c(paramai).isEmpty()) {
            if (this.bRU.isEmpty())
            {
              this.bRU.bYP = null;
              this.bRU = null;
              this.bRS = k.ai.c(paramai);
              this.bOT &= 0xFFFFFFFE;
              if (ac.bVU) {
                localbq = EO();
              }
              this.bRU = localbq;
            }
            else
            {
              this.bRU.a(k.ai.c(paramai));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
    
    public static final class b
      extends ac
      implements k.ai.c
    {
      @Deprecated
      public static final bj<b> bPg = new c() {};
      private static final b bSc = new b();
      private int bOT;
      private byte bPe = -1;
      private ae.d bRV;
      private int bRW = -1;
      private ae.d bRX;
      private int bRY = -1;
      private volatile Object bRZ;
      private volatile Object bSa;
      private ak bSb;
      
      private b()
      {
        this.bRV = ad.GE();
        this.bRX = ad.GE();
        this.bRZ = "";
        this.bSa = "";
        this.bSb = aj.bXM;
      }
      
      private b(ac.a<?> parama)
      {
        super();
      }
      
      private b(h paramh, r paramr)
      {
        this();
        if (paramr == null) {
          throw new NullPointerException();
        }
        cc.a locala = cc.HJ();
        int i1 = 0;
        int i = 0;
        for (;;)
        {
          label26:
          int k;
          int m;
          int j;
          if (i1 == 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (;;)
          {
            try
            {
              n = paramh.yT();
              switch (n)
              {
              case 8: 
                k = i;
                m = i;
                j = i;
                if (a(paramh, locala, paramr, n)) {
                  break label26;
                }
                i1 = 1;
                break label26;
              }
            }
            catch (af paramh)
            {
              try
              {
                paramh.bXr = this;
                throw paramh;
              }
              finally
              {
                j = k;
                if ((j & 0x1) != 0) {
                  this.bRV.yK();
                }
                if ((j & 0x2) != 0) {
                  this.bRX.yK();
                }
                if ((j & 0x10) != 0) {
                  this.bSb = this.bSb.GR();
                }
                this.bTW = locala.HM();
                Gw();
              }
              k = i;
              m = i;
              j = i;
              i2 = paramh.fH(paramh.zi());
              n = i;
              if ((i & 0x1) != 0) {
                continue;
              }
              k = i;
              n = i;
              m = i;
              j = i;
              if (paramh.zk() <= 0) {
                continue;
              }
              k = i;
              m = i;
              j = i;
              this.bRV = new ad();
              n = i | 0x1;
              k = n;
              m = n;
              j = n;
              if (paramh.zk() <= 0) {
                continue;
              }
              k = n;
              m = n;
              j = n;
              this.bRV.gF(paramh.yW());
              continue;
            }
            catch (IOException paramh)
            {
              j = m;
              paramh = new af(paramh);
              j = m;
              paramh.bXr = this;
              j = m;
              throw paramh;
            }
            finally
            {
              continue;
              k = n;
              m = n;
              j = n;
              paramh.fI(i2);
              i = n;
            }
            int n = i;
            if ((i & 0x1) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRV = new ad();
              n = i | 0x1;
            }
            k = n;
            m = n;
            j = n;
            this.bRV.gF(paramh.yW());
            i = n;
            break;
            break;
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRX = new ad();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.bRX.gF(paramh.yW());
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            int i2 = paramh.fH(paramh.zi());
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              n = i;
              if (paramh.zk() > 0)
              {
                k = i;
                m = i;
                j = i;
                this.bRX = new ad();
                n = i | 0x2;
              }
            }
            for (;;)
            {
              k = n;
              m = n;
              j = n;
              if (paramh.zk() <= 0) {
                break;
              }
              k = n;
              m = n;
              j = n;
              this.bRX.gF(paramh.yW());
            }
            k = n;
            m = n;
            j = n;
            paramh.fI(i2);
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            g localg = paramh.zb();
            k = i;
            m = i;
            j = i;
            this.bOT |= 0x1;
            k = i;
            m = i;
            j = i;
            this.bRZ = localg;
            break;
            k = i;
            m = i;
            j = i;
            localg = paramh.zb();
            k = i;
            m = i;
            j = i;
            this.bOT |= 0x2;
            k = i;
            m = i;
            j = i;
            this.bSa = localg;
            break;
            k = i;
            m = i;
            j = i;
            localg = paramh.zb();
            n = i;
            if ((i & 0x10) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bSb = new aj();
              n = i | 0x10;
            }
            k = n;
            m = n;
            j = n;
            this.bSb.d(localg);
            i = n;
            break;
            if ((i & 0x1) != 0) {
              this.bRV.yK();
            }
            if ((i & 0x2) != 0) {
              this.bRX.yK();
            }
            if ((i & 0x10) != 0) {
              this.bSb = this.bSb.GR();
            }
            this.bTW = locala.HM();
            Gw();
            return;
          }
          i1 = 1;
        }
      }
      
      private String EQ()
      {
        Object localObject = this.bRZ;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (g)localObject;
        String str = ((g)localObject).yO();
        if (((g)localObject).yP()) {
          this.bRZ = str;
        }
        return str;
      }
      
      private String ES()
      {
        Object localObject = this.bSa;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (g)localObject;
        String str = ((g)localObject).yO();
        if (((g)localObject).yP()) {
          this.bSa = str;
        }
        return str;
      }
      
      private a ET()
      {
        if (this == bSc) {
          return new a((byte)0);
        }
        return new a((byte)0).f(this);
      }
      
      public static b EU()
      {
        return bSc;
      }
      
      public final bj<b> AK()
      {
        return bPg;
      }
      
      public final cc Ax()
      {
        return this.bTW;
      }
      
      protected final ac.f Ay()
      {
        return k.Aw().h(b.class, a.class);
      }
      
      public final boolean EP()
      {
        return (this.bOT & 0x1) != 0;
      }
      
      public final boolean ER()
      {
        return (this.bOT & 0x2) != 0;
      }
      
      public final void a(i parami)
      {
        int j = 0;
        yC();
        if (this.bRV.size() > 0)
        {
          parami.fL(10);
          parami.fL(this.bRW);
        }
        int i = 0;
        while (i < this.bRV.size())
        {
          parami.fK(this.bRV.getInt(i));
          i += 1;
        }
        if (this.bRX.size() > 0)
        {
          parami.fL(18);
          parami.fL(this.bRY);
        }
        i = 0;
        while (i < this.bRX.size())
        {
          parami.fK(this.bRX.getInt(i));
          i += 1;
        }
        if ((this.bOT & 0x1) != 0) {
          ac.a(parami, 3, this.bRZ);
        }
        i = j;
        if ((this.bOT & 0x2) != 0)
        {
          ac.a(parami, 4, this.bSa);
          i = j;
        }
        while (i < this.bSb.size())
        {
          ac.a(parami, 6, this.bSb.getRaw(i));
          i += 1;
        }
        this.bTW.a(parami);
      }
      
      public final boolean equals(Object paramObject)
      {
        if (paramObject == this) {}
        do
        {
          return true;
          if (!(paramObject instanceof b)) {
            return super.equals(paramObject);
          }
          paramObject = (b)paramObject;
          if (!this.bRV.equals(paramObject.bRV)) {
            return false;
          }
          if (!this.bRX.equals(paramObject.bRX)) {
            return false;
          }
          if (EP() != paramObject.EP()) {
            return false;
          }
          if ((EP()) && (!EQ().equals(paramObject.EQ()))) {
            return false;
          }
          if (ER() != paramObject.ER()) {
            return false;
          }
          if ((ER()) && (!ES().equals(paramObject.ES()))) {
            return false;
          }
          if (!this.bSb.equals(paramObject.bSb)) {
            return false;
          }
        } while (this.bTW.equals(paramObject.bTW));
        return false;
      }
      
      public final int hashCode()
      {
        if (this.bNb != 0) {
          return this.bNb;
        }
        int j = k.Av().hashCode() + 779;
        int i = j;
        if (this.bRV.size() > 0) {
          i = (j * 37 + 1) * 53 + this.bRV.hashCode();
        }
        j = i;
        if (this.bRX.size() > 0) {
          j = (i * 37 + 2) * 53 + this.bRX.hashCode();
        }
        i = j;
        if (EP()) {
          i = (j * 37 + 3) * 53 + EQ().hashCode();
        }
        j = i;
        if (ER()) {
          j = (i * 37 + 4) * 53 + ES().hashCode();
        }
        i = j;
        if (this.bSb.size() > 0) {
          i = (j * 37 + 6) * 53 + this.bSb.hashCode();
        }
        i = i * 29 + this.bTW.hashCode();
        this.bNb = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bPe;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.bPe = 1;
        return true;
      }
      
      public final int yC()
      {
        int i = this.bNa;
        if (i != -1) {
          return i;
        }
        i = 0;
        int j = 0;
        while (i < this.bRV.size())
        {
          j += i.fT(this.bRV.getInt(i));
          i += 1;
        }
        int k = j + 0;
        i = k;
        if (!this.bRV.isEmpty()) {
          i = k + 1 + i.fT(j);
        }
        this.bRW = j;
        k = 0;
        j = 0;
        while (k < this.bRX.size())
        {
          j += i.fT(this.bRX.getInt(k));
          k += 1;
        }
        k = i + j;
        i = k;
        if (!this.bRX.isEmpty()) {
          i = k + 1 + i.fT(j);
        }
        this.bRY = j;
        j = i;
        if ((this.bOT & 0x1) != 0) {
          j = i + ac.d(3, this.bRZ);
        }
        i = j;
        if ((this.bOT & 0x2) != 0) {
          i = j + ac.d(4, this.bSa);
        }
        j = 0;
        k = 0;
        while (j < this.bSb.size())
        {
          k += ar(this.bSb.getRaw(j));
          j += 1;
        }
        i = i + k + this.bSb.size() * 1 + this.bTW.yC();
        this.bNa = i;
        return i;
      }
      
      public static final class a
        extends ac.a<a>
        implements k.ai.c
      {
        private int bOT;
        private ae.d bRV = ac.Gv();
        private ae.d bRX = ac.Gv();
        private Object bRZ = "";
        private Object bSa = "";
        private ak bSb = aj.bXM;
        
        private a()
        {
          boolean bool = ac.bVU;
        }
        
        private a(ac.b paramb)
        {
          super();
          boolean bool = ac.bVU;
        }
        
        private k.ai.b EV()
        {
          k.ai.b localb = EW();
          if (!localb.isInitialized()) {
            throw b(localb);
          }
          return localb;
        }
        
        private k.ai.b EW()
        {
          int i = 0;
          k.ai.b localb = new k.ai.b(this, (byte)0);
          int k = this.bOT;
          if ((this.bOT & 0x1) != 0)
          {
            this.bRV.yK();
            this.bOT &= 0xFFFFFFFE;
          }
          k.ai.b.a(localb, this.bRV);
          if ((this.bOT & 0x2) != 0)
          {
            this.bRX.yK();
            this.bOT &= 0xFFFFFFFD;
          }
          k.ai.b.b(localb, this.bRX);
          if ((k & 0x4) != 0) {
            i = 1;
          }
          k.ai.b.a(localb, this.bRZ);
          int j = i;
          if ((k & 0x8) != 0) {
            j = i | 0x2;
          }
          k.ai.b.b(localb, this.bSa);
          if ((this.bOT & 0x10) != 0)
          {
            this.bSb = this.bSb.GR();
            this.bOT &= 0xFFFFFFEF;
          }
          k.ai.b.a(localb, this.bSb);
          k.ai.b.a(localb, j);
          Gy();
          return localb;
        }
        
        private void EX()
        {
          if ((this.bOT & 0x1) == 0)
          {
            this.bRV = ac.a(this.bRV);
            this.bOT |= 0x1;
          }
        }
        
        private void EY()
        {
          if ((this.bOT & 0x2) == 0)
          {
            this.bRX = ac.a(this.bRX);
            this.bOT |= 0x2;
          }
        }
        
        private void EZ()
        {
          if ((this.bOT & 0x10) == 0)
          {
            this.bSb = new aj(this.bSb);
            this.bOT |= 0x10;
          }
        }
        
        private a U(cc paramcc)
        {
          return (a)super.e(paramcc);
        }
        
        private a V(cc paramcc)
        {
          return (a)super.d(paramcc);
        }
        
        private a W(l.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a X(l.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        private a y(at paramat)
        {
          if ((paramat instanceof k.ai.b)) {
            return f((k.ai.b)paramat);
          }
          super.a(paramat);
          return this;
        }
        
        /* Error */
        private a z(h paramh, r paramr)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 157	com/google/a/k$ai$b:bPg	Lcom/google/a/bj;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 162 3 0
          //   12: checkcast 14	com/google/a/k$ai$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 146	com/google/a/k$ai$b$a:f	(Lcom/google/a/k$ai$b;)Lcom/google/a/k$ai$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 166	com/google/a/af:bXr	Lcom/google/a/aw;
          //   33: checkcast 14	com/google/a/k$ai$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 170	com/google/a/af:GF	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 146	com/google/a/k$ai$b$a:f	(Lcom/google/a/k$ai$b;)Lcom/google/a/k$ai$b$a;
          //   52: pop
          //   53: aload_1
          //   54: athrow
          //   55: astore_1
          //   56: aload_3
          //   57: astore_2
          //   58: goto -15 -> 43
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	61	0	this	a
          //   0	61	1	paramh	h
          //   0	61	2	paramr	r
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/a/af
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        public final l.a AS()
        {
          return k.Av();
        }
        
        protected final ac.f Ay()
        {
          return k.Aw().h(k.ai.b.class, a.class);
        }
        
        public final a f(k.ai.b paramb)
        {
          if (paramb == k.ai.b.EU()) {
            return this;
          }
          if (!k.ai.b.a(paramb).isEmpty())
          {
            if (this.bRV.isEmpty())
            {
              this.bRV = k.ai.b.a(paramb);
              this.bOT &= 0xFFFFFFFE;
              onChanged();
            }
          }
          else
          {
            if (!k.ai.b.b(paramb).isEmpty())
            {
              if (!this.bRX.isEmpty()) {
                break label245;
              }
              this.bRX = k.ai.b.b(paramb);
              this.bOT &= 0xFFFFFFFD;
              label99:
              onChanged();
            }
            if (paramb.EP())
            {
              this.bOT |= 0x4;
              this.bRZ = k.ai.b.c(paramb);
              onChanged();
            }
            if (paramb.ER())
            {
              this.bOT |= 0x8;
              this.bSa = k.ai.b.d(paramb);
              onChanged();
            }
            if (!k.ai.b.e(paramb).isEmpty())
            {
              if (!this.bSb.isEmpty()) {
                break label266;
              }
              this.bSb = k.ai.b.e(paramb);
              this.bOT &= 0xFFFFFFEF;
            }
          }
          for (;;)
          {
            onChanged();
            V(paramb.bTW);
            onChanged();
            return this;
            EX();
            this.bRV.addAll(k.ai.b.a(paramb));
            break;
            label245:
            EY();
            this.bRX.addAll(k.ai.b.b(paramb));
            break label99;
            label266:
            EZ();
            this.bSb.addAll(k.ai.b.e(paramb));
          }
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
    
    public static abstract interface c
      extends az
    {}
  }
  
  public static abstract interface aj
    extends az
  {}
  
  public static final class ak
    extends ac
    implements k.al
  {
    @Deprecated
    public static final bj<ak> bPg = new c() {};
    private static final ak bSk = new ak();
    private int bOT;
    private byte bPe = -1;
    private List<b> bSd;
    private volatile Object bSe;
    long bSf;
    long bSg;
    double bSh;
    g bSi;
    private volatile Object bSj;
    
    private ak()
    {
      this.bSd = Collections.emptyList();
      this.bSe = "";
      this.bSi = g.bNg;
      this.bSj = "";
    }
    
    private ak(ac.a<?> parama)
    {
      super();
    }
    
    private ak(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            int j = paramh.yT();
            switch (j)
            {
            case 18: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              j = i;
              if ((i & 0x1) == 0)
              {
                n = i;
                i1 = i;
                k = i;
                this.bSd = new ArrayList();
                j = i | 0x1;
              }
              n = j;
              i1 = j;
              k = j;
              this.bSd.add(paramh.a(b.bPg, paramr));
              i = j;
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x1) != 0) {
                this.bSd = Collections.unmodifiableList(this.bSd);
              }
              this.bTW = locala.HM();
              Gw();
            }
            n = i;
            i1 = i;
            k = i;
            localg = paramh.zb();
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.bSe = localg;
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bSf = paramh.yU();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.bSg = paramh.yV();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.bSh = paramh.readDouble();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.bSi = paramh.zb();
          break;
          n = i;
          i1 = i;
          k = i;
          g localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x20;
          n = i;
          i1 = i;
          k = i;
          this.bSj = localg;
          break;
          if ((i & 0x1) != 0) {
            this.bSd = Collections.unmodifiableList(this.bSd);
          }
          this.bTW = locala.HM();
          Gw();
          return;
        }
        m = 1;
      }
    }
    
    private String Fb()
    {
      Object localObject = this.bSe;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bSe = str;
      }
      return str;
    }
    
    private String Fh()
    {
      Object localObject = this.bSj;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bSj = str;
      }
      return str;
    }
    
    private a Fi()
    {
      if (this == bSk) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public static ak Fj()
    {
      return bSk;
    }
    
    private int getNameCount()
    {
      return this.bSd.size();
    }
    
    public final bj<ak> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Aq().h(ak.class, a.class);
    }
    
    public final boolean Fa()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean Fc()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final boolean Fd()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final boolean Fe()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final boolean Ff()
    {
      return (this.bOT & 0x10) != 0;
    }
    
    public final boolean Fg()
    {
      return (this.bOT & 0x20) != 0;
    }
    
    public final void a(i parami)
    {
      int i = 0;
      while (i < this.bSd.size())
      {
        parami.a(2, (aw)this.bSd.get(i));
        i += 1;
      }
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 3, this.bSe);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.n(4, this.bSf);
      }
      if ((this.bOT & 0x4) != 0) {
        parami.n(5, this.bSg);
      }
      if ((this.bOT & 0x8) != 0) {
        parami.o(6, Double.doubleToRawLongBits(this.bSh));
      }
      if ((this.bOT & 0x10) != 0) {
        parami.a(7, this.bSi);
      }
      if ((this.bOT & 0x20) != 0) {
        ac.a(parami, 8, this.bSj);
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof ak)) {
          return super.equals(paramObject);
        }
        paramObject = (ak)paramObject;
        if (!this.bSd.equals(paramObject.bSd)) {
          return false;
        }
        if (Fa() != paramObject.Fa()) {
          return false;
        }
        if ((Fa()) && (!Fb().equals(paramObject.Fb()))) {
          return false;
        }
        if (Fc() != paramObject.Fc()) {
          return false;
        }
        if ((Fc()) && (this.bSf != paramObject.bSf)) {
          return false;
        }
        if (Fd() != paramObject.Fd()) {
          return false;
        }
        if ((Fd()) && (this.bSg != paramObject.bSg)) {
          return false;
        }
        if (Fe() != paramObject.Fe()) {
          return false;
        }
        if ((Fe()) && (Double.doubleToLongBits(this.bSh) != Double.doubleToLongBits(paramObject.bSh))) {
          return false;
        }
        if (Ff() != paramObject.Ff()) {
          return false;
        }
        if ((Ff()) && (!this.bSi.equals(paramObject.bSi))) {
          return false;
        }
        if (Fg() != paramObject.Fg()) {
          return false;
        }
        if ((Fg()) && (!Fh().equals(paramObject.Fh()))) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Ap().hashCode() + 779;
      int i = j;
      if (getNameCount() > 0) {
        i = (j * 37 + 2) * 53 + this.bSd.hashCode();
      }
      j = i;
      if (Fa()) {
        j = (i * 37 + 3) * 53 + Fb().hashCode();
      }
      i = j;
      if (Fc()) {
        i = (j * 37 + 4) * 53 + ae.aF(this.bSf);
      }
      j = i;
      if (Fd()) {
        j = (i * 37 + 5) * 53 + ae.aF(this.bSg);
      }
      i = j;
      if (Fe()) {
        i = (j * 37 + 6) * 53 + ae.aF(Double.doubleToLongBits(this.bSh));
      }
      j = i;
      if (Ff()) {
        j = (i * 37 + 7) * 53 + this.bSi.hashCode();
      }
      i = j;
      if (Fg()) {
        i = (j * 37 + 8) * 53 + Fh().hashCode();
      }
      i = i * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < getNameCount())
      {
        if (!((b)this.bSd.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (j < this.bSd.size())
      {
        i += i.c(2, (aw)this.bSd.get(j));
        j += 1;
      }
      j = i;
      if ((this.bOT & 0x1) != 0) {
        j = i + ac.d(3, this.bSe);
      }
      i = j;
      if ((this.bOT & 0x2) != 0) {
        i = j + i.p(4, this.bSf);
      }
      j = i;
      if ((this.bOT & 0x4) != 0) {
        j = i + i.ay(this.bSg);
      }
      i = j;
      if ((this.bOT & 0x8) != 0) {
        i = j + i.zr();
      }
      j = i;
      if ((this.bOT & 0x10) != 0) {
        j = i + i.c(7, this.bSi);
      }
      i = j;
      if ((this.bOT & 0x20) != 0) {
        i = j + ac.d(8, this.bSj);
      }
      i = this.bTW.yC() + i;
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.a<a>
      implements k.al
    {
      private int bOT;
      private List<k.ak.b> bSd = Collections.emptyList();
      private Object bSe = "";
      private long bSf;
      private long bSg;
      private double bSh;
      private g bSi = g.bNg;
      private Object bSj = "";
      private bq<k.ak.b, k.ak.b.a, k.ak.c> bSl;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      /* Error */
      private a A(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 75	com/google/a/k$ak:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 81 3 0
        //   12: checkcast 9	com/google/a/k$ak
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 84	com/google/a/k$ak$a:d	(Lcom/google/a/k$ak;)Lcom/google/a/k$ak$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 88	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$ak
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 92	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 84	com/google/a/k$ak$a:d	(Lcom/google/a/k$ak;)Lcom/google/a/k$ak$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private void AR()
      {
        if (ac.bVU) {
          Fn();
        }
      }
      
      private k.ak Fk()
      {
        k.ak localak = Fl();
        if (!localak.isInitialized()) {
          throw b(localak);
        }
        return localak;
      }
      
      private k.ak Fl()
      {
        int j = 0;
        k.ak localak = new k.ak(this, (byte)0);
        int k = this.bOT;
        if (this.bSl == null)
        {
          if ((this.bOT & 0x1) != 0)
          {
            this.bSd = Collections.unmodifiableList(this.bSd);
            this.bOT &= 0xFFFFFFFE;
          }
          k.ak.a(localak, this.bSd);
        }
        for (;;)
        {
          if ((k & 0x2) != 0) {
            j = 1;
          }
          k.ak.a(localak, this.bSe);
          int i = j;
          if ((k & 0x4) != 0)
          {
            k.ak.a(localak, this.bSf);
            i = j | 0x2;
          }
          j = i;
          if ((k & 0x8) != 0)
          {
            k.ak.b(localak, this.bSg);
            j = i | 0x4;
          }
          i = j;
          if ((k & 0x10) != 0)
          {
            k.ak.a(localak, this.bSh);
            i = j | 0x8;
          }
          j = i;
          if ((k & 0x20) != 0) {
            j = i | 0x10;
          }
          k.ak.a(localak, this.bSi);
          i = j;
          if ((k & 0x40) != 0) {
            i = j | 0x20;
          }
          k.ak.b(localak, this.bSj);
          k.ak.a(localak, i);
          Gy();
          return localak;
          k.ak.a(localak, this.bSl.build());
        }
      }
      
      private void Fm()
      {
        if ((this.bOT & 0x1) == 0)
        {
          this.bSd = new ArrayList(this.bSd);
          this.bOT |= 0x1;
        }
      }
      
      private bq<k.ak.b, k.ak.b.a, k.ak.c> Fn()
      {
        List localList;
        if (this.bSl == null)
        {
          localList = this.bSd;
          if ((this.bOT & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bSl = new bq(localList, bool, GA(), this.bWv);
          this.bSd = null;
          return this.bSl;
        }
      }
      
      private a W(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a X(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a Y(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a Z(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a aD(long paramLong)
      {
        this.bOT |= 0x4;
        this.bSf = paramLong;
        onChanged();
        return this;
      }
      
      private a aE(long paramLong)
      {
        this.bOT |= 0x8;
        this.bSg = paramLong;
        onChanged();
        return this;
      }
      
      private a c(g paramg)
      {
        if (paramg == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x20;
        this.bSi = paramg;
        onChanged();
        return this;
      }
      
      private a g(double paramDouble)
      {
        this.bOT |= 0x10;
        this.bSh = paramDouble;
        onChanged();
        return this;
      }
      
      private a z(at paramat)
      {
        if ((paramat instanceof k.ak)) {
          return d((k.ak)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      public final l.a AS()
      {
        return k.Ap();
      }
      
      protected final ac.f Ay()
      {
        return k.Aq().h(k.ak.class, a.class);
      }
      
      public final a d(k.ak paramak)
      {
        bq localbq = null;
        if (paramak == k.ak.Fj()) {
          return this;
        }
        if (this.bSl == null) {
          if (!k.ak.a(paramak).isEmpty())
          {
            if (!this.bSd.isEmpty()) {
              break label203;
            }
            this.bSd = k.ak.a(paramak);
            this.bOT &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          if (paramak.Fa())
          {
            this.bOT |= 0x2;
            this.bSe = k.ak.b(paramak);
            onChanged();
          }
          if (paramak.Fc()) {
            aD(paramak.bSf);
          }
          if (paramak.Fd()) {
            aE(paramak.bSg);
          }
          if (paramak.Fe()) {
            g(paramak.bSh);
          }
          if (paramak.Ff()) {
            c(paramak.bSi);
          }
          if (paramak.Fg())
          {
            this.bOT |= 0x40;
            this.bSj = k.ak.c(paramak);
            onChanged();
          }
          X(paramak.bTW);
          onChanged();
          return this;
          label203:
          Fm();
          this.bSd.addAll(k.ak.a(paramak));
          break;
          if (!k.ak.a(paramak).isEmpty()) {
            if (this.bSl.isEmpty())
            {
              this.bSl.bYP = null;
              this.bSl = null;
              this.bSd = k.ak.a(paramak);
              this.bOT &= 0xFFFFFFFE;
              if (ac.bVU) {
                localbq = Fn();
              }
              this.bSl = localbq;
            }
            else
            {
              this.bSl.a(k.ak.a(paramak));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        for (;;)
        {
          int j;
          if (this.bSl == null)
          {
            j = this.bSd.size();
            if (i >= j) {
              break;
            }
            if (this.bSl != null) {
              break label65;
            }
          }
          label65:
          for (k.ak.b localb = (k.ak.b)this.bSd.get(i);; localb = (k.ak.b)this.bSl.s(i, false))
          {
            if (localb.isInitialized()) {
              break label81;
            }
            return false;
            j = this.bSl.getCount();
            break;
          }
          label81:
          i += 1;
        }
        return true;
      }
    }
    
    public static final class b
      extends ac
      implements k.ak.c
    {
      @Deprecated
      public static final bj<b> bPg = new c() {};
      private static final b bSo = new b();
      private int bOT;
      private byte bPe = -1;
      private volatile Object bSm;
      boolean bSn;
      
      private b()
      {
        this.bSm = "";
      }
      
      private b(ac.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(h paramh, r paramr)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 36	com/google/a/k$ak$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 63	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 64	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 70	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
        //   19: astore 5
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +149 -> 173
        //   27: aload_1
        //   28: invokevirtual 76	com/google/a/h:yT	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+152->187, 0:+155->190, 10:+51->86, 16:+100->135
        //   69: aload_1
        //   70: aload 5
        //   72: aload_2
        //   73: iload 4
        //   75: invokevirtual 79	com/google/a/k$ak$b:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
        //   78: ifne -55 -> 23
        //   81: iconst_1
        //   82: istore_3
        //   83: goto -60 -> 23
        //   86: aload_1
        //   87: invokevirtual 83	com/google/a/h:zb	()Lcom/google/a/g;
        //   90: astore 6
        //   92: aload_0
        //   93: aload_0
        //   94: getfield 85	com/google/a/k$ak$b:bOT	I
        //   97: iconst_1
        //   98: ior
        //   99: putfield 85	com/google/a/k$ak$b:bOT	I
        //   102: aload_0
        //   103: aload 6
        //   105: putfield 49	com/google/a/k$ak$b:bSm	Ljava/lang/Object;
        //   108: goto -85 -> 23
        //   111: astore_1
        //   112: aload_1
        //   113: aload_0
        //   114: putfield 89	com/google/a/af:bXr	Lcom/google/a/aw;
        //   117: aload_1
        //   118: athrow
        //   119: astore_1
        //   120: aload_0
        //   121: aload 5
        //   123: invokevirtual 95	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   126: putfield 99	com/google/a/k$ak$b:bTW	Lcom/google/a/cc;
        //   129: aload_0
        //   130: invokevirtual 102	com/google/a/k$ak$b:Gw	()V
        //   133: aload_1
        //   134: athrow
        //   135: aload_0
        //   136: aload_0
        //   137: getfield 85	com/google/a/k$ak$b:bOT	I
        //   140: iconst_2
        //   141: ior
        //   142: putfield 85	com/google/a/k$ak$b:bOT	I
        //   145: aload_0
        //   146: aload_1
        //   147: invokevirtual 106	com/google/a/h:yZ	()Z
        //   150: putfield 108	com/google/a/k$ak$b:bSn	Z
        //   153: goto -130 -> 23
        //   156: astore_1
        //   157: new 59	com/google/a/af
        //   160: dup
        //   161: aload_1
        //   162: invokespecial 111	com/google/a/af:<init>	(Ljava/io/IOException;)V
        //   165: astore_1
        //   166: aload_1
        //   167: aload_0
        //   168: putfield 89	com/google/a/af:bXr	Lcom/google/a/aw;
        //   171: aload_1
        //   172: athrow
        //   173: aload_0
        //   174: aload 5
        //   176: invokevirtual 95	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   179: putfield 99	com/google/a/k$ak$b:bTW	Lcom/google/a/cc;
        //   182: aload_0
        //   183: invokevirtual 102	com/google/a/k$ak$b:Gw	()V
        //   186: return
        //   187: goto -119 -> 68
        //   190: iconst_1
        //   191: istore_3
        //   192: goto -169 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	195	0	this	b
        //   0	195	1	paramh	h
        //   0	195	2	paramr	r
        //   22	170	3	i	int
        //   31	43	4	j	int
        //   19	156	5	locala	cc.a
        //   90	14	6	localg	g
        // Exception table:
        //   from	to	target	type
        //   27	33	111	com/google/a/af
        //   68	81	111	com/google/a/af
        //   86	108	111	com/google/a/af
        //   135	153	111	com/google/a/af
        //   27	33	119	finally
        //   68	81	119	finally
        //   86	108	119	finally
        //   112	119	119	finally
        //   135	153	119	finally
        //   157	173	119	finally
        //   27	33	156	java/io/IOException
        //   68	81	156	java/io/IOException
        //   86	108	156	java/io/IOException
        //   135	153	156	java/io/IOException
      }
      
      private String Fp()
      {
        Object localObject = this.bSm;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (g)localObject;
        String str = ((g)localObject).yO();
        if (((g)localObject).yP()) {
          this.bSm = str;
        }
        return str;
      }
      
      private a Fr()
      {
        if (this == bSo) {
          return new a((byte)0);
        }
        return new a((byte)0).b(this);
      }
      
      public static b Fs()
      {
        return bSo;
      }
      
      public final bj<b> AK()
      {
        return bPg;
      }
      
      public final cc Ax()
      {
        return this.bTW;
      }
      
      protected final ac.f Ay()
      {
        return k.As().h(b.class, a.class);
      }
      
      public final boolean Fo()
      {
        return (this.bOT & 0x1) != 0;
      }
      
      public final boolean Fq()
      {
        return (this.bOT & 0x2) != 0;
      }
      
      public final void a(i parami)
      {
        if ((this.bOT & 0x1) != 0) {
          ac.a(parami, 1, this.bSm);
        }
        if ((this.bOT & 0x2) != 0) {
          parami.r(2, this.bSn);
        }
        this.bTW.a(parami);
      }
      
      public final boolean equals(Object paramObject)
      {
        if (paramObject == this) {}
        do
        {
          return true;
          if (!(paramObject instanceof b)) {
            return super.equals(paramObject);
          }
          paramObject = (b)paramObject;
          if (Fo() != paramObject.Fo()) {
            return false;
          }
          if ((Fo()) && (!Fp().equals(paramObject.Fp()))) {
            return false;
          }
          if (Fq() != paramObject.Fq()) {
            return false;
          }
          if ((Fq()) && (this.bSn != paramObject.bSn)) {
            return false;
          }
        } while (this.bTW.equals(paramObject.bTW));
        return false;
      }
      
      public final int hashCode()
      {
        if (this.bNb != 0) {
          return this.bNb;
        }
        int j = k.Ar().hashCode() + 779;
        int i = j;
        if (Fo()) {
          i = (j * 37 + 1) * 53 + Fp().hashCode();
        }
        j = i;
        if (Fq()) {
          j = (i * 37 + 2) * 53 + ae.bF(this.bSn);
        }
        i = j * 29 + this.bTW.hashCode();
        this.bNb = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bPe;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        if (!Fo())
        {
          this.bPe = 0;
          return false;
        }
        if (!Fq())
        {
          this.bPe = 0;
          return false;
        }
        this.bPe = 1;
        return true;
      }
      
      public final int yC()
      {
        int i = this.bNa;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bOT & 0x1) != 0) {
          i = ac.d(1, this.bSm) + 0;
        }
        int j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.fR(2);
        }
        i = j + this.bTW.yC();
        this.bNa = i;
        return i;
      }
      
      public static final class a
        extends ac.a<a>
        implements k.ak.c
      {
        private int bOT;
        private Object bSm = "";
        private boolean bSn;
        
        private a()
        {
          boolean bool = ac.bVU;
        }
        
        private a(ac.b paramb)
        {
          super();
          boolean bool = ac.bVU;
        }
        
        private a A(at paramat)
        {
          if ((paramat instanceof k.ak.b)) {
            return b((k.ak.b)paramat);
          }
          super.a(paramat);
          return this;
        }
        
        /* Error */
        private a B(h paramh, r paramr)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 59	com/google/a/k$ak$b:bPg	Lcom/google/a/bj;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 65 3 0
          //   12: checkcast 14	com/google/a/k$ak$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 48	com/google/a/k$ak$b$a:b	(Lcom/google/a/k$ak$b;)Lcom/google/a/k$ak$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 69	com/google/a/af:bXr	Lcom/google/a/aw;
          //   33: checkcast 14	com/google/a/k$ak$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 73	com/google/a/af:GF	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 48	com/google/a/k$ak$b$a:b	(Lcom/google/a/k$ak$b;)Lcom/google/a/k$ak$b$a;
          //   52: pop
          //   53: aload_1
          //   54: athrow
          //   55: astore_1
          //   56: aload_3
          //   57: astore_2
          //   58: goto -15 -> 43
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	61	0	this	a
          //   0	61	1	paramh	h
          //   0	61	2	paramr	r
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/a/af
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private k.ak.b Ft()
        {
          k.ak.b localb = Fu();
          if (!localb.isInitialized()) {
            throw b(localb);
          }
          return localb;
        }
        
        private k.ak.b Fu()
        {
          int i = 0;
          k.ak.b localb = new k.ak.b(this, (byte)0);
          int k = this.bOT;
          if ((k & 0x1) != 0) {
            i = 1;
          }
          k.ak.b.a(localb, this.bSm);
          int j = i;
          if ((k & 0x2) != 0)
          {
            k.ak.b.a(localb, this.bSn);
            j = i | 0x2;
          }
          k.ak.b.a(localb, j);
          Gy();
          return localb;
        }
        
        private a Y(cc paramcc)
        {
          return (a)super.e(paramcc);
        }
        
        private a Z(cc paramcc)
        {
          return (a)super.d(paramcc);
        }
        
        private a aa(l.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a ab(l.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        private a bD(boolean paramBoolean)
        {
          this.bOT |= 0x2;
          this.bSn = paramBoolean;
          onChanged();
          return this;
        }
        
        public final l.a AS()
        {
          return k.Ar();
        }
        
        protected final ac.f Ay()
        {
          return k.As().h(k.ak.b.class, a.class);
        }
        
        public final a b(k.ak.b paramb)
        {
          if (paramb == k.ak.b.Fs()) {
            return this;
          }
          if (paramb.Fo())
          {
            this.bOT |= 0x1;
            this.bSm = k.ak.b.a(paramb);
            onChanged();
          }
          if (paramb.Fq()) {
            bD(paramb.bSn);
          }
          Z(paramb.bTW);
          onChanged();
          return this;
        }
        
        public final boolean isInitialized()
        {
          int i;
          if ((this.bOT & 0x1) != 0)
          {
            i = 1;
            if (i != 0) {
              break label22;
            }
          }
          for (;;)
          {
            return false;
            i = 0;
            break;
            label22:
            if ((this.bOT & 0x2) != 0) {}
            for (i = 1; i != 0; i = 0) {
              return true;
            }
          }
        }
      }
    }
    
    public static abstract interface c
      extends az
    {}
  }
  
  public static abstract interface al
    extends az
  {}
  
  public static abstract interface b
    extends az
  {}
  
  public static final class c
    extends ac
    implements k.d
  {
    @Deprecated
    public static final bj<c> bPg = new c() {};
    private static final c bPw = new c();
    private int bOT;
    private volatile Object bOU;
    private List<b> bPc;
    private ak bPd;
    private byte bPe = -1;
    private List<k.g> bPu;
    private k.e bPv;
    
    private c()
    {
      this.bOU = "";
      this.bPu = Collections.emptyList();
      this.bPc = Collections.emptyList();
      this.bPd = aj.bXM;
    }
    
    private c(ac.a<?> parama)
    {
      super();
    }
    
    private c(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int i1 = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int k;
        int m;
        int j;
        if (i1 == 0)
        {
          k = i;
          m = i;
          j = i;
        }
        for (;;)
        {
          int n;
          try
          {
            n = paramh.yT();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (a(paramh, locala, paramr, n)) {
                break label722;
              }
              j = 1;
              break label738;
              k = i;
              m = i;
              j = i;
              localObject = paramh.zb();
              k = i;
              m = i;
              j = i;
              this.bOT |= 0x1;
              k = i;
              m = i;
              j = i;
              this.bOU = localObject;
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              j = k;
              if ((j & 0x2) != 0) {
                this.bPu = Collections.unmodifiableList(this.bPu);
              }
              if ((j & 0x8) != 0) {
                this.bPc = Collections.unmodifiableList(this.bPc);
              }
              if ((j & 0x10) != 0) {
                this.bPd = this.bPd.GR();
              }
              this.bTW = locala.HM();
              Gw();
            }
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bPu = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.bPu.add(paramh.a(k.g.bPg, paramr));
            i = n;
            break;
          }
          catch (IOException paramh)
          {
            j = m;
            paramh = new af(paramh);
            j = m;
            paramh.bXr = this;
            j = m;
            throw paramh;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            if ((this.bOT & 0x2) == 0) {
              break label729;
            }
          }
          k = i;
          m = i;
          j = i;
          label722:
          label729:
          for (Object localObject = this.bPv.BP();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.bPv = ((k.e)paramh.a(k.e.bPg, paramr));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((k.e.a)localObject).d(this.bPv);
              k = i;
              m = i;
              j = i;
              this.bPv = ((k.e.a)localObject).BS();
            }
            k = i;
            m = i;
            j = i;
            this.bOT |= 0x2;
            break;
            n = i;
            if ((i & 0x8) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bPc = new ArrayList();
              n = i | 0x8;
            }
            k = n;
            m = n;
            j = n;
            this.bPc.add(paramh.a(b.bPg, paramr));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            localObject = paramh.zb();
            n = i;
            if ((i & 0x10) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bPd = new aj();
              n = i | 0x10;
            }
            k = n;
            m = n;
            j = n;
            this.bPd.d((g)localObject);
            i = n;
            break;
            if ((i & 0x2) != 0) {
              this.bPu = Collections.unmodifiableList(this.bPu);
            }
            if ((i & 0x8) != 0) {
              this.bPc = Collections.unmodifiableList(this.bPc);
            }
            if ((i & 0x10) != 0) {
              this.bPd = this.bPd.GR();
            }
            this.bTW = locala.HM();
            Gw();
            return;
            j = i1;
            break label738;
          }
        }
        label738:
        i1 = j;
        continue;
        i1 = 1;
      }
    }
    
    private a BC()
    {
      if (this == bPw) {
        return new a((byte)0);
      }
      return new a((byte)0).e(this);
    }
    
    public static c BD()
    {
      return bPw;
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final bj<c> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zQ().h(c.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final k.e BB()
    {
      if (this.bPv == null) {
        return k.e.BQ();
      }
      return this.bPv;
    }
    
    public final void a(i parami)
    {
      int k = 0;
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      int i = 0;
      while (i < this.bPu.size())
      {
        parami.a(2, (aw)this.bPu.get(i));
        i += 1;
      }
      if ((this.bOT & 0x2) != 0) {
        parami.a(3, BB());
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.bPc.size()) {
          break;
        }
        parami.a(4, (aw)this.bPc.get(i));
        i += 1;
      }
      while (j < this.bPd.size())
      {
        ac.a(parami, 5, this.bPd.getRaw(j));
        j += 1;
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return super.equals(paramObject);
        }
        paramObject = (c)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.bPu.equals(paramObject.bPu)) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!BB().equals(paramObject.BB()))) {
          return false;
        }
        if (!this.bPc.equals(paramObject.bPc)) {
          return false;
        }
        if (!this.bPd.equals(paramObject.bPd)) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final int getValueCount()
    {
      return this.bPu.size();
    }
    
    public final k.g gj(int paramInt)
    {
      return (k.g)this.bPu.get(paramInt);
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zP().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (getValueCount() > 0) {
        j = (i * 37 + 2) * 53 + this.bPu.hashCode();
      }
      i = j;
      if (AF()) {
        i = (j * 37 + 3) * 53 + BB().hashCode();
      }
      j = i;
      if (this.bPc.size() > 0) {
        j = (i * 37 + 4) * 53 + this.bPc.hashCode();
      }
      i = j;
      if (this.bPd.size() > 0) {
        i = (j * 37 + 5) * 53 + this.bPd.hashCode();
      }
      i = i * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < getValueCount())
      {
        if (!gj(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if ((AF()) && (!BB().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (i = ac.d(1, this.bOU) + 0;; i = 0)
      {
        int j = 0;
        while (j < this.bPu.size())
        {
          i += i.c(2, (aw)this.bPu.get(j));
          j += 1;
        }
        j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.c(3, BB());
        }
        i = 0;
        while (i < this.bPc.size())
        {
          j += i.c(4, (aw)this.bPc.get(i));
          i += 1;
        }
        i = 0;
        int k = 0;
        while (i < this.bPd.size())
        {
          k += ar(this.bPd.getRaw(i));
          i += 1;
        }
        i = j + k + this.bPd.size() * 1 + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.a<a>
      implements k.d
    {
      private int bOT;
      private Object bOU = "";
      private List<k.c.b> bPc = Collections.emptyList();
      private ak bPd = aj.bXM;
      private bu<k.e, k.e.a, k.f> bPn;
      private bq<k.c.b, k.c.b.a, k.c.c> bPo;
      private List<k.g> bPu = Collections.emptyList();
      private k.e bPv;
      private bq<k.g, k.g.a, k.h> bPx;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU)
        {
          BH();
          Bh();
          Bj();
        }
      }
      
      private k.e BB()
      {
        if (this.bPn == null)
        {
          if (this.bPv == null) {
            return k.e.BQ();
          }
          return this.bPv;
        }
        return (k.e)this.bPn.Hu();
      }
      
      private k.c BE()
      {
        k.c localc = BF();
        if (!localc.isInitialized()) {
          throw b(localc);
        }
        return localc;
      }
      
      private k.c BF()
      {
        k.c localc = new k.c(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          k.c.a(localc, this.bOU);
          int j;
          if (this.bPx == null)
          {
            if ((this.bOT & 0x2) != 0)
            {
              this.bPu = Collections.unmodifiableList(this.bPu);
              this.bOT &= 0xFFFFFFFD;
            }
            k.c.a(localc, this.bPu);
            j = i;
            if ((k & 0x4) != 0)
            {
              if (this.bPn != null) {
                break label234;
              }
              k.c.a(localc, this.bPv);
              label107:
              j = i | 0x2;
            }
            if (this.bPo != null) {
              break label253;
            }
            if ((this.bOT & 0x8) != 0)
            {
              this.bPc = Collections.unmodifiableList(this.bPc);
              this.bOT &= 0xFFFFFFF7;
            }
            k.c.b(localc, this.bPc);
          }
          for (;;)
          {
            if ((this.bOT & 0x10) != 0)
            {
              this.bPd = this.bPd.GR();
              this.bOT &= 0xFFFFFFEF;
            }
            k.c.a(localc, this.bPd);
            k.c.a(localc, j);
            Gy();
            return localc;
            k.c.a(localc, this.bPx.build());
            break;
            label234:
            k.c.a(localc, (k.e)this.bPn.Hv());
            break label107;
            label253:
            k.c.b(localc, this.bPo.build());
          }
        }
      }
      
      private void BG()
      {
        if ((this.bOT & 0x2) == 0)
        {
          this.bPu = new ArrayList(this.bPu);
          this.bOT |= 0x2;
        }
      }
      
      private bq<k.g, k.g.a, k.h> BH()
      {
        List localList;
        if (this.bPx == null)
        {
          localList = this.bPu;
          if ((this.bOT & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPx = new bq(localList, bool, GA(), this.bWv);
          this.bPu = null;
          return this.bPx;
        }
      }
      
      private bu<k.e, k.e.a, k.f> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(BB(), GA(), this.bWv);
          this.bPv = null;
        }
        return this.bPn;
      }
      
      private void Bi()
      {
        if ((this.bOT & 0x8) == 0)
        {
          this.bPc = new ArrayList(this.bPc);
          this.bOT |= 0x8;
        }
      }
      
      private bq<k.c.b, k.c.b.a, k.c.c> Bj()
      {
        List localList;
        if (this.bPo == null)
        {
          localList = this.bPc;
          if ((this.bOT & 0x8) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPo = new bq(localList, bool, GA(), this.bWv);
          this.bPc = null;
          return this.bPo;
        }
      }
      
      private void Bk()
      {
        if ((this.bOT & 0x10) == 0)
        {
          this.bPd = new aj(this.bPd);
          this.bOT |= 0x10;
        }
      }
      
      private a a(k.e parame)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x4) != 0) && (this.bPv != null) && (this.bPv != k.e.BQ()))
          {
            this.bPv = k.e.b(this.bPv).d(parame).BS();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x4;
          return this;
          this.bPv = parame;
          break;
          this.bPn.b(parame);
        }
      }
      
      private a g(at paramat)
      {
        if ((paramat instanceof k.c)) {
          return e((k.c)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a h(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 229	com/google/a/k$c:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 234 3 0
        //   12: checkcast 9	com/google/a/k$c
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 218	com/google/a/k$c$a:e	(Lcom/google/a/k$c;)Lcom/google/a/k$c$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 238	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$c
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 242	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 218	com/google/a/k$c$a:e	(Lcom/google/a/k$c;)Lcom/google/a/k$c$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a k(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a k(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a l(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a l(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      public final l.a AS()
      {
        return k.zP();
      }
      
      protected final ac.f Ay()
      {
        return k.zQ().h(k.c.class, a.class);
      }
      
      public final a e(k.c paramc)
      {
        Object localObject2 = null;
        if (paramc == k.c.BD()) {
          return this;
        }
        if (paramc.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.c.a(paramc);
          onChanged();
        }
        if (this.bPx == null) {
          if (!k.c.b(paramc).isEmpty())
          {
            if (this.bPu.isEmpty())
            {
              this.bPu = k.c.b(paramc);
              this.bOT &= 0xFFFFFFFD;
              onChanged();
            }
          }
          else
          {
            label94:
            if (paramc.AF()) {
              a(paramc.BB());
            }
            if (this.bPo != null) {
              break label361;
            }
            if (!k.c.c(paramc).isEmpty())
            {
              if (!this.bPc.isEmpty()) {
                break label340;
              }
              this.bPc = k.c.c(paramc);
              this.bOT &= 0xFFFFFFF7;
              label160:
              onChanged();
            }
            label164:
            if (!k.c.d(paramc).isEmpty())
            {
              if (!this.bPd.isEmpty()) {
                break label451;
              }
              this.bPd = k.c.d(paramc);
              this.bOT &= 0xFFFFFFEF;
            }
          }
        }
        for (;;)
        {
          onChanged();
          l(paramc.bTW);
          onChanged();
          return this;
          BG();
          this.bPu.addAll(k.c.b(paramc));
          break;
          if (k.c.b(paramc).isEmpty()) {
            break label94;
          }
          Object localObject1;
          if (this.bPx.isEmpty())
          {
            this.bPx.bYP = null;
            this.bPx = null;
            this.bPu = k.c.b(paramc);
            this.bOT &= 0xFFFFFFFD;
            if (ac.bVU) {}
            for (localObject1 = BH();; localObject1 = null)
            {
              this.bPx = ((bq)localObject1);
              break;
            }
          }
          this.bPx.a(k.c.b(paramc));
          break label94;
          label340:
          Bi();
          this.bPc.addAll(k.c.c(paramc));
          break label160;
          label361:
          if (k.c.c(paramc).isEmpty()) {
            break label164;
          }
          if (this.bPo.isEmpty())
          {
            this.bPo.bYP = null;
            this.bPo = null;
            this.bPc = k.c.c(paramc);
            this.bOT &= 0xFFFFFFF7;
            localObject1 = localObject2;
            if (ac.bVU) {
              localObject1 = Bj();
            }
            this.bPo = ((bq)localObject1);
            break label164;
          }
          this.bPo.a(k.c.c(paramc));
          break label164;
          label451:
          Bk();
          this.bPd.addAll(k.c.d(paramc));
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        k.g localg;
        if (this.bPx == null)
        {
          j = this.bPu.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPx != null) {
            break label65;
          }
          localg = (k.g)this.bPu.get(i);
          label45:
          if (localg.isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bPx.getCount();
          break label19;
          label65:
          localg = (k.g)this.bPx.s(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          if ((this.bOT & 0x4) != 0) {}
          for (i = 1; (i == 0) || (BB().isInitialized()); i = 0) {
            return true;
          }
        }
      }
    }
    
    public static final class b
      extends ac
      implements k.c.c
    {
      @Deprecated
      public static final bj<b> bPg = new c() {};
      private static final b bPy = new b();
      private int bOT;
      private byte bPe = -1;
      int bPp;
      int bPq;
      
      private b() {}
      
      private b(ac.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(h paramh, r paramr)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 34	com/google/a/k$c$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 57	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 58	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 64	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
        //   19: astore 5
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +145 -> 169
        //   27: aload_1
        //   28: invokevirtual 70	com/google/a/h:yT	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+148->183, 0:+151->186, 8:+51->86, 16:+96->131
        //   69: aload_1
        //   70: aload 5
        //   72: aload_2
        //   73: iload 4
        //   75: invokevirtual 73	com/google/a/k$c$b:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
        //   78: ifne -55 -> 23
        //   81: iconst_1
        //   82: istore_3
        //   83: goto -60 -> 23
        //   86: aload_0
        //   87: aload_0
        //   88: getfield 75	com/google/a/k$c$b:bOT	I
        //   91: iconst_1
        //   92: ior
        //   93: putfield 75	com/google/a/k$c$b:bOT	I
        //   96: aload_0
        //   97: aload_1
        //   98: invokevirtual 78	com/google/a/h:yW	()I
        //   101: putfield 80	com/google/a/k$c$b:bPp	I
        //   104: goto -81 -> 23
        //   107: astore_1
        //   108: aload_1
        //   109: aload_0
        //   110: putfield 84	com/google/a/af:bXr	Lcom/google/a/aw;
        //   113: aload_1
        //   114: athrow
        //   115: astore_1
        //   116: aload_0
        //   117: aload 5
        //   119: invokevirtual 90	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   122: putfield 94	com/google/a/k$c$b:bTW	Lcom/google/a/cc;
        //   125: aload_0
        //   126: invokevirtual 97	com/google/a/k$c$b:Gw	()V
        //   129: aload_1
        //   130: athrow
        //   131: aload_0
        //   132: aload_0
        //   133: getfield 75	com/google/a/k$c$b:bOT	I
        //   136: iconst_2
        //   137: ior
        //   138: putfield 75	com/google/a/k$c$b:bOT	I
        //   141: aload_0
        //   142: aload_1
        //   143: invokevirtual 78	com/google/a/h:yW	()I
        //   146: putfield 99	com/google/a/k$c$b:bPq	I
        //   149: goto -126 -> 23
        //   152: astore_1
        //   153: new 53	com/google/a/af
        //   156: dup
        //   157: aload_1
        //   158: invokespecial 102	com/google/a/af:<init>	(Ljava/io/IOException;)V
        //   161: astore_1
        //   162: aload_1
        //   163: aload_0
        //   164: putfield 84	com/google/a/af:bXr	Lcom/google/a/aw;
        //   167: aload_1
        //   168: athrow
        //   169: aload_0
        //   170: aload 5
        //   172: invokevirtual 90	com/google/a/cc$a:HM	()Lcom/google/a/cc;
        //   175: putfield 94	com/google/a/k$c$b:bTW	Lcom/google/a/cc;
        //   178: aload_0
        //   179: invokevirtual 97	com/google/a/k$c$b:Gw	()V
        //   182: return
        //   183: goto -115 -> 68
        //   186: iconst_1
        //   187: istore_3
        //   188: goto -165 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	191	0	this	b
        //   0	191	1	paramh	h
        //   0	191	2	paramr	r
        //   22	166	3	i	int
        //   31	43	4	j	int
        //   19	152	5	locala	cc.a
        // Exception table:
        //   from	to	target	type
        //   27	33	107	com/google/a/af
        //   68	81	107	com/google/a/af
        //   86	104	107	com/google/a/af
        //   131	149	107	com/google/a/af
        //   27	33	115	finally
        //   68	81	115	finally
        //   86	104	115	finally
        //   108	115	115	finally
        //   131	149	115	finally
        //   153	169	115	finally
        //   27	33	152	java/io/IOException
        //   68	81	152	java/io/IOException
        //   86	104	152	java/io/IOException
        //   131	149	152	java/io/IOException
      }
      
      private a BI()
      {
        if (this == bPy) {
          return new a((byte)0);
        }
        return new a((byte)0).a(this);
      }
      
      public static b BJ()
      {
        return bPy;
      }
      
      public final bj<b> AK()
      {
        return bPg;
      }
      
      public final cc Ax()
      {
        return this.bTW;
      }
      
      protected final ac.f Ay()
      {
        return k.zS().h(b.class, a.class);
      }
      
      public final boolean Bq()
      {
        return (this.bOT & 0x1) != 0;
      }
      
      public final void a(i parami)
      {
        if ((this.bOT & 0x1) != 0) {
          parami.bs(1, this.bPp);
        }
        if ((this.bOT & 0x2) != 0) {
          parami.bs(2, this.bPq);
        }
        this.bTW.a(parami);
      }
      
      public final boolean equals(Object paramObject)
      {
        if (paramObject == this) {}
        do
        {
          return true;
          if (!(paramObject instanceof b)) {
            return super.equals(paramObject);
          }
          paramObject = (b)paramObject;
          if (Bq() != paramObject.Bq()) {
            return false;
          }
          if ((Bq()) && (this.bPp != paramObject.bPp)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.bPq != paramObject.bPq)) {
            return false;
          }
        } while (this.bTW.equals(paramObject.bTW));
        return false;
      }
      
      public final boolean hasEnd()
      {
        return (this.bOT & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.bNb != 0) {
          return this.bNb;
        }
        int j = k.zR().hashCode() + 779;
        int i = j;
        if (Bq()) {
          i = (j * 37 + 1) * 53 + this.bPp;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.bPq;
        }
        i = j * 29 + this.bTW.hashCode();
        this.bNb = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bPe;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.bPe = 1;
        return true;
      }
      
      public final int yC()
      {
        int i = this.bNa;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bOT & 0x1) != 0) {
          i = i.bu(1, this.bPp) + 0;
        }
        int j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.bu(2, this.bPq);
        }
        i = j + this.bTW.yC();
        this.bNa = i;
        return i;
      }
      
      public static final class a
        extends ac.a<a>
        implements k.c.c
      {
        private int bOT;
        private int bPp;
        private int bPq;
        
        private a()
        {
          boolean bool = ac.bVU;
        }
        
        private a(ac.b paramb)
        {
          super();
          boolean bool = ac.bVU;
        }
        
        private k.c.b BK()
        {
          k.c.b localb = BL();
          if (!localb.isInitialized()) {
            throw b(localb);
          }
          return localb;
        }
        
        private k.c.b BL()
        {
          int i = 0;
          k.c.b localb = new k.c.b(this, (byte)0);
          int k = this.bOT;
          if ((k & 0x1) != 0)
          {
            k.c.b.a(localb, this.bPp);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            k.c.b.b(localb, this.bPq);
            j = i | 0x2;
          }
          k.c.b.c(localb, j);
          Gy();
          return localb;
        }
        
        private a gk(int paramInt)
        {
          this.bOT |= 0x1;
          this.bPp = paramInt;
          onChanged();
          return this;
        }
        
        private a gl(int paramInt)
        {
          this.bOT |= 0x2;
          this.bPq = paramInt;
          onChanged();
          return this;
        }
        
        private a h(at paramat)
        {
          if ((paramat instanceof k.c.b)) {
            return a((k.c.b)paramat);
          }
          super.a(paramat);
          return this;
        }
        
        /* Error */
        private a i(h paramh, r paramr)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 91	com/google/a/k$c$b:bPg	Lcom/google/a/bj;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 97 3 0
          //   12: checkcast 14	com/google/a/k$c$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 80	com/google/a/k$c$b$a:a	(Lcom/google/a/k$c$b;)Lcom/google/a/k$c$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 101	com/google/a/af:bXr	Lcom/google/a/aw;
          //   33: checkcast 14	com/google/a/k$c$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 105	com/google/a/af:GF	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 80	com/google/a/k$c$b$a:a	(Lcom/google/a/k$c$b;)Lcom/google/a/k$c$b$a;
          //   52: pop
          //   53: aload_1
          //   54: athrow
          //   55: astore_1
          //   56: aload_3
          //   57: astore_2
          //   58: goto -15 -> 43
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	61	0	this	a
          //   0	61	1	paramh	h
          //   0	61	2	paramr	r
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/a/af
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a m(cc paramcc)
        {
          return (a)super.e(paramcc);
        }
        
        private a m(l.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a n(cc paramcc)
        {
          return (a)super.d(paramcc);
        }
        
        private a n(l.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        public final l.a AS()
        {
          return k.zR();
        }
        
        protected final ac.f Ay()
        {
          return k.zS().h(k.c.b.class, a.class);
        }
        
        public final a a(k.c.b paramb)
        {
          if (paramb == k.c.b.BJ()) {
            return this;
          }
          if (paramb.Bq()) {
            gk(paramb.bPp);
          }
          if (paramb.hasEnd()) {
            gl(paramb.bPq);
          }
          n(paramb.bTW);
          onChanged();
          return this;
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
    
    public static abstract interface c
      extends az
    {}
  }
  
  public static abstract interface d
    extends az
  {}
  
  public static final class e
    extends ac.d<e>
    implements k.f
  {
    private static final e bPC = new e();
    @Deprecated
    public static final bj<e> bPg = new c() {};
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    boolean bPz;
    
    private e()
    {
      this.bPB = Collections.emptyList();
    }
    
    private e(ac.c<e, ?> paramc)
    {
      super();
    }
    
    private e(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 16: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bPz = paramh.yZ();
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x4) != 0) {
                this.bPB = Collections.unmodifiableList(this.bPB);
              }
              this.bTW = locala.HM();
              this.bWd.yK();
            }
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bPA = paramh.yZ();
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            int j = i;
            if ((i & 0x4) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.bPB = new ArrayList();
              j = i | 0x4;
            }
            n = j;
            i1 = j;
            k = j;
            this.bPB.add(paramh.a(k.ak.bPg, paramr));
            i = j;
          }
          break;
          if ((i & 0x4) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static e BQ()
    {
      return bPC;
    }
    
    public static a b(e parame)
    {
      return bPC.BP().d(parame);
    }
    
    public final bj<e> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Ai().h(e.class, a.class);
    }
    
    public final boolean BM()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final a BP()
    {
      if (this == bPC) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        parami.r(2, this.bPz);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.r(3, this.bPA);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof e)) {
          return super.equals(paramObject);
        }
        paramObject = (e)paramObject;
        if (BM() != paramObject.BM()) {
          return false;
        }
        if ((BM()) && (this.bPz != paramObject.bPz)) {
          return false;
        }
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Ah().hashCode() + 779;
      int i = j;
      if (BM()) {
        i = (j * 37 + 2) * 53 + ae.bF(this.bPz);
      }
      j = i;
      if (BN()) {
        j = (i * 37 + 3) * 53 + ae.bF(this.bPA);
      }
      i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int k = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (i = i.fR(2) + 0;; i = 0)
      {
        int j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.fR(3);
        }
        i = j;
        j = k;
        while (j < this.bPB.size())
        {
          k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        i = this.bWd.yC() + i + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.c<k.e, a>
      implements k.f
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      private boolean bPz;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private k.e BR()
      {
        k.e locale = BS();
        if (!locale.isInitialized()) {
          throw b(locale);
        }
        return locale;
      }
      
      private void BT()
      {
        if ((this.bOT & 0x4) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x4;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private a bf(boolean paramBoolean)
      {
        this.bOT |= 0x1;
        this.bPz = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bg(boolean paramBoolean)
      {
        this.bOT |= 0x2;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a i(at paramat)
      {
        if ((paramat instanceof k.e)) {
          return d((k.e)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a j(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 122	com/google/a/k$e:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 127 3 0
        //   12: checkcast 9	com/google/a/k$e
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 111	com/google/a/k$e$a:d	(Lcom/google/a/k$e;)Lcom/google/a/k$e$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 131	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$e
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 135	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 111	com/google/a/k$e$a:d	(Lcom/google/a/k$e;)Lcom/google/a/k$e$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a o(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a o(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a p(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a p(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      public final l.a AS()
      {
        return k.Ah();
      }
      
      protected final ac.f Ay()
      {
        return k.Ai().h(k.e.class, a.class);
      }
      
      public final k.e BS()
      {
        int i = 0;
        k.e locale = new k.e(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0)
        {
          k.e.a(locale, this.bPz);
          i = 1;
        }
        int j = i;
        if ((k & 0x2) != 0)
        {
          k.e.b(locale, this.bPA);
          j = i | 0x2;
        }
        if (this.bPD == null)
        {
          if ((this.bOT & 0x4) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFFB;
          }
          k.e.a(locale, this.bPB);
        }
        for (;;)
        {
          k.e.a(locale, j);
          Gy();
          return locale;
          k.e.a(locale, this.bPD.build());
        }
      }
      
      public final a d(k.e parame)
      {
        bq localbq = null;
        if (parame == k.e.BQ()) {
          return this;
        }
        if (parame.BM()) {
          bf(parame.bPz);
        }
        if (parame.BN()) {
          bg(parame.bPA);
        }
        if (this.bPD == null) {
          if (!k.e.c(parame).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label117;
            }
            this.bPB = k.e.c(parame);
            this.bOT &= 0xFFFFFFFB;
            onChanged();
          }
        }
        for (;;)
        {
          a(parame);
          p(parame.bTW);
          onChanged();
          return this;
          label117:
          BT();
          this.bPB.addAll(k.e.c(parame));
          break;
          if (!k.e.c(parame).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.e.c(parame);
              this.bOT &= 0xFFFFFFFB;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.e.c(parame));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static abstract interface f
    extends ac.e
  {}
  
  public static final class g
    extends ac
    implements k.h
  {
    private static final g bPG = new g();
    @Deprecated
    public static final bj<g> bPg = new c() {};
    private int bOT;
    private volatile Object bOU;
    int bPE;
    private k.i bPF;
    private byte bPe = -1;
    
    private g()
    {
      this.bOU = "";
    }
    
    private g(ac.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private g(h paramh, r paramr)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 34	com/google/a/k$g:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 61	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 62	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 68	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +227 -> 251
      //   27: aload_1
      //   28: invokevirtual 74	com/google/a/h:yT	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+239->274, 0:+245->280, 10:+59->94, 16:+108->143, 26:+146->181
      //   77: aload_1
      //   78: aload 6
      //   80: aload_2
      //   81: iload 4
      //   83: invokevirtual 77	com/google/a/k$g:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
      //   86: ifne +179 -> 265
      //   89: iconst_1
      //   90: istore_3
      //   91: goto +186 -> 277
      //   94: aload_1
      //   95: invokevirtual 81	com/google/a/h:zb	()Lcom/google/a/g;
      //   98: astore 5
      //   100: aload_0
      //   101: aload_0
      //   102: getfield 83	com/google/a/k$g:bOT	I
      //   105: iconst_1
      //   106: ior
      //   107: putfield 83	com/google/a/k$g:bOT	I
      //   110: aload_0
      //   111: aload 5
      //   113: putfield 47	com/google/a/k$g:bOU	Ljava/lang/Object;
      //   116: goto -93 -> 23
      //   119: astore_1
      //   120: aload_1
      //   121: aload_0
      //   122: putfield 87	com/google/a/af:bXr	Lcom/google/a/aw;
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: aload_0
      //   129: aload 6
      //   131: invokevirtual 93	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   134: putfield 97	com/google/a/k$g:bTW	Lcom/google/a/cc;
      //   137: aload_0
      //   138: invokevirtual 100	com/google/a/k$g:Gw	()V
      //   141: aload_1
      //   142: athrow
      //   143: aload_0
      //   144: aload_0
      //   145: getfield 83	com/google/a/k$g:bOT	I
      //   148: iconst_2
      //   149: ior
      //   150: putfield 83	com/google/a/k$g:bOT	I
      //   153: aload_0
      //   154: aload_1
      //   155: invokevirtual 103	com/google/a/h:yW	()I
      //   158: putfield 105	com/google/a/k$g:bPE	I
      //   161: goto -138 -> 23
      //   164: astore_1
      //   165: new 57	com/google/a/af
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 108	com/google/a/af:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 87	com/google/a/af:bXr	Lcom/google/a/aw;
      //   179: aload_1
      //   180: athrow
      //   181: aload_0
      //   182: getfield 83	com/google/a/k$g:bOT	I
      //   185: iconst_4
      //   186: iand
      //   187: ifeq +81 -> 268
      //   190: aload_0
      //   191: getfield 110	com/google/a/k$g:bPF	Lcom/google/a/k$i;
      //   194: invokevirtual 116	com/google/a/k$i:Cc	()Lcom/google/a/k$i$a;
      //   197: astore 5
      //   199: aload_0
      //   200: aload_1
      //   201: getstatic 117	com/google/a/k$i:bPg	Lcom/google/a/bj;
      //   204: aload_2
      //   205: invokevirtual 120	com/google/a/h:a	(Lcom/google/a/bj;Lcom/google/a/r;)Lcom/google/a/aw;
      //   208: checkcast 112	com/google/a/k$i
      //   211: putfield 110	com/google/a/k$g:bPF	Lcom/google/a/k$i;
      //   214: aload 5
      //   216: ifnull +22 -> 238
      //   219: aload 5
      //   221: aload_0
      //   222: getfield 110	com/google/a/k$g:bPF	Lcom/google/a/k$i;
      //   225: invokevirtual 126	com/google/a/k$i$a:d	(Lcom/google/a/k$i;)Lcom/google/a/k$i$a;
      //   228: pop
      //   229: aload_0
      //   230: aload 5
      //   232: invokevirtual 130	com/google/a/k$i$a:Cf	()Lcom/google/a/k$i;
      //   235: putfield 110	com/google/a/k$g:bPF	Lcom/google/a/k$i;
      //   238: aload_0
      //   239: aload_0
      //   240: getfield 83	com/google/a/k$g:bOT	I
      //   243: iconst_4
      //   244: ior
      //   245: putfield 83	com/google/a/k$g:bOT	I
      //   248: goto -225 -> 23
      //   251: aload_0
      //   252: aload 6
      //   254: invokevirtual 93	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   257: putfield 97	com/google/a/k$g:bTW	Lcom/google/a/cc;
      //   260: aload_0
      //   261: invokevirtual 100	com/google/a/k$g:Gw	()V
      //   264: return
      //   265: goto +12 -> 277
      //   268: aconst_null
      //   269: astore 5
      //   271: goto -72 -> 199
      //   274: goto -198 -> 76
      //   277: goto -254 -> 23
      //   280: iconst_1
      //   281: istore_3
      //   282: goto -259 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	285	0	this	g
      //   0	285	1	paramh	h
      //   0	285	2	paramr	r
      //   22	260	3	i	int
      //   31	51	4	j	int
      //   98	172	5	localObject	Object
      //   19	234	6	locala	cc.a
      // Exception table:
      //   from	to	target	type
      //   27	33	119	com/google/a/af
      //   76	89	119	com/google/a/af
      //   94	116	119	com/google/a/af
      //   143	161	119	com/google/a/af
      //   181	199	119	com/google/a/af
      //   199	214	119	com/google/a/af
      //   219	238	119	com/google/a/af
      //   238	248	119	com/google/a/af
      //   27	33	127	finally
      //   76	89	127	finally
      //   94	116	127	finally
      //   120	127	127	finally
      //   143	161	127	finally
      //   165	181	127	finally
      //   181	199	127	finally
      //   199	214	127	finally
      //   219	238	127	finally
      //   238	248	127	finally
      //   27	33	164	java/io/IOException
      //   76	89	164	java/io/IOException
      //   94	116	164	java/io/IOException
      //   143	161	164	java/io/IOException
      //   181	199	164	java/io/IOException
      //   199	214	164	java/io/IOException
      //   219	238	164	java/io/IOException
      //   238	248	164	java/io/IOException
    }
    
    public static a BX()
    {
      return bPG.BY();
    }
    
    private a BY()
    {
      if (this == bPG) {
        return new a((byte)0);
      }
      return new a((byte)0).b(this);
    }
    
    public static g BZ()
    {
      return bPG;
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final bj<g> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zU().h(g.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean BV()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final k.i BW()
    {
      if (this.bPF == null) {
        return k.i.Cd();
      }
      return this.bPF;
    }
    
    public final void a(i parami)
    {
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.bs(2, this.bPE);
      }
      if ((this.bOT & 0x4) != 0) {
        parami.a(3, BW());
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof g)) {
          return super.equals(paramObject);
        }
        paramObject = (g)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (BV() != paramObject.BV()) {
          return false;
        }
        if ((BV()) && (this.bPE != paramObject.bPE)) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!BW().equals(paramObject.BW()))) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zT().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (BV()) {
        j = (i * 37 + 2) * 53 + this.bPE;
      }
      i = j;
      if (AF()) {
        i = (j * 37 + 3) * 53 + BW().hashCode();
      }
      i = i * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bPe;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((AF()) && (!BW().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bOT & 0x1) != 0) {
        j = ac.d(1, this.bOU) + 0;
      }
      i = j;
      if ((this.bOT & 0x2) != 0) {
        i = j + i.bu(2, this.bPE);
      }
      j = i;
      if ((this.bOT & 0x4) != 0) {
        j = i + i.c(3, BW());
      }
      i = j + this.bTW.yC();
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.a<a>
      implements k.h
    {
      private int bOT;
      private Object bOU = "";
      private int bPE;
      private k.i bPF;
      private bu<k.i, k.i.a, k.j> bPn;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          Bh();
        }
      }
      
      private k.i BW()
      {
        if (this.bPn == null)
        {
          if (this.bPF == null) {
            return k.i.Cd();
          }
          return this.bPF;
        }
        return (k.i)this.bPn.Hu();
      }
      
      private bu<k.i, k.i.a, k.j> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(BW(), GA(), this.bWv);
          this.bPF = null;
        }
        return this.bPn;
      }
      
      private k.g Cb()
      {
        int i = 0;
        k.g localg = new k.g(this, (byte)0);
        int j = this.bOT;
        if ((j & 0x1) != 0) {
          i = 1;
        }
        k.g.a(localg, this.bOU);
        if ((j & 0x2) != 0)
        {
          k.g.a(localg, this.bPE);
          i |= 0x2;
        }
        for (;;)
        {
          if ((j & 0x4) != 0) {
            if (this.bPn == null)
            {
              k.g.a(localg, this.bPF);
              i |= 0x4;
            }
          }
          for (;;)
          {
            k.g.b(localg, i);
            Gy();
            return localg;
            k.g.a(localg, (k.i)this.bPn.Hv());
            break;
          }
        }
      }
      
      private a a(k.i parami)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x4) != 0) && (this.bPF != null) && (this.bPF != k.i.Cd()))
          {
            this.bPF = k.i.b(this.bPF).d(parami).Cf();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x4;
          return this;
          this.bPF = parami;
          break;
          this.bPn.b(parami);
        }
      }
      
      private a j(at paramat)
      {
        if ((paramat instanceof k.g)) {
          return b((k.g)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a k(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 144	com/google/a/k$g:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 149 3 0
        //   12: checkcast 9	com/google/a/k$g
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 133	com/google/a/k$g$a:b	(Lcom/google/a/k$g;)Lcom/google/a/k$g$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 153	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$g
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 157	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 133	com/google/a/k$g$a:b	(Lcom/google/a/k$g;)Lcom/google/a/k$g$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a q(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a r(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a s(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a t(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      public final l.a AS()
      {
        return k.zT();
      }
      
      protected final ac.f Ay()
      {
        return k.zU().h(k.g.class, a.class);
      }
      
      public final k.g Ca()
      {
        k.g localg = Cb();
        if (!localg.isInitialized()) {
          throw b(localg);
        }
        return localg;
      }
      
      public final a b(k.g paramg)
      {
        if (paramg == k.g.BZ()) {
          return this;
        }
        if (paramg.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.g.a(paramg);
          onChanged();
        }
        if (paramg.BV()) {
          gm(paramg.bPE);
        }
        if (paramg.AF()) {
          a(paramg.BW());
        }
        r(paramg.bTW);
        onChanged();
        return this;
      }
      
      public final a cf(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x1;
        this.bOU = paramString;
        onChanged();
        return this;
      }
      
      public final a gm(int paramInt)
      {
        this.bOT |= 0x2;
        this.bPE = paramInt;
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bOT & 0x4) != 0) {}
        for (int i = 1; (i != 0) && (!BW().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
  }
  
  public static abstract interface h
    extends az
  {}
  
  public static final class i
    extends ac.d<i>
    implements k.j
  {
    private static final i bPH = new i();
    @Deprecated
    public static final bj<i> bPg = new c() {};
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    
    private i()
    {
      this.bPB = Collections.emptyList();
    }
    
    private i(ac.c<i, ?> paramc)
    {
      super();
    }
    
    private i(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bPA = paramh.yZ();
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally {}
            if ((k & 0x2) != 0) {
              this.bPB = Collections.unmodifiableList(this.bPB);
            }
            this.bTW = locala.HM();
            this.bWd.yK();
            throw paramh;
            int j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.bPB = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            k = j;
            this.bPB.add(paramh.a(k.ak.bPg, paramr));
            i = j;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
          }
          if ((i & 0x2) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static i Cd()
    {
      return bPH;
    }
    
    public static a b(i parami)
    {
      return bPH.Cc().d(parami);
    }
    
    public final bj<i> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Ak().h(i.class, a.class);
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final a Cc()
    {
      if (this == bPH) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        parami.r(1, this.bPA);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof i)) {
          return super.equals(paramObject);
        }
        paramObject = (i)paramObject;
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Aj().hashCode() + 779;
      int i = j;
      if (BN()) {
        i = (j * 37 + 1) * 53 + ae.bF(this.bPA);
      }
      j = i;
      if (BO() > 0) {
        j = (i * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(j, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int j = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {
        i = i.fR(1) + 0;
      }
      for (;;)
      {
        if (j < this.bPB.size())
        {
          int k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          i = this.bWd.yC() + i + this.bTW.yC();
          this.bNa = i;
          return i;
          i = 0;
        }
      }
    }
    
    public static final class a
      extends ac.c<k.i, a>
      implements k.j
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x2) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x2;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.i Ce()
      {
        k.i locali = Cf();
        if (!locali.isInitialized()) {
          throw b(locali);
        }
        return locali;
      }
      
      private a bh(boolean paramBoolean)
      {
        this.bOT |= 0x1;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a k(at paramat)
      {
        if ((paramat instanceof k.i)) {
          return d((k.i)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a l(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 118	com/google/a/k$i:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 123 3 0
        //   12: checkcast 9	com/google/a/k$i
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 107	com/google/a/k$i$a:d	(Lcom/google/a/k$i;)Lcom/google/a/k$i$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 127	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$i
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 131	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 107	com/google/a/k$i$a:d	(Lcom/google/a/k$i;)Lcom/google/a/k$i$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a s(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a t(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a u(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a v(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      public final l.a AS()
      {
        return k.Aj();
      }
      
      protected final ac.f Ay()
      {
        return k.Ak().h(k.i.class, a.class);
      }
      
      public final k.i Cf()
      {
        int i = 0;
        k.i locali = new k.i(this, (byte)0);
        if ((this.bOT & 0x1) != 0)
        {
          k.i.a(locali, this.bPA);
          i = 1;
        }
        if (this.bPD == null)
        {
          if ((this.bOT & 0x2) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFFD;
          }
          k.i.a(locali, this.bPB);
        }
        for (;;)
        {
          k.i.a(locali, i);
          Gy();
          return locali;
          k.i.a(locali, this.bPD.build());
        }
      }
      
      public final a d(k.i parami)
      {
        bq localbq = null;
        if (parami == k.i.Cd()) {
          return this;
        }
        if (parami.BN()) {
          bh(parami.bPA);
        }
        if (this.bPD == null) {
          if (!k.i.c(parami).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label101;
            }
            this.bPB = k.i.c(parami);
            this.bOT &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          a(parami);
          t(parami.bTW);
          onChanged();
          return this;
          label101:
          BT();
          this.bPB.addAll(k.i.c(parami));
          break;
          if (!k.i.c(parami).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.i.c(parami);
              this.bOT &= 0xFFFFFFFD;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.i.c(parami));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static abstract interface j
    extends ac.e
  {}
  
  public static final class k
    extends ac.d<k>
    implements k.l
  {
    private static final k bPI = new k();
    @Deprecated
    public static final bj<k> bPg = new c() {};
    private List<k.ak> bPB;
    private byte bPe = -1;
    
    private k()
    {
      this.bPB = Collections.emptyList();
    }
    
    private k(ac.c<k, ?> paramc)
    {
      super();
    }
    
    private k(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      int n;
      int i1;
      int k;
      label205:
      label240:
      for (;;)
      {
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        try
        {
          j = paramh.yT();
          switch (j)
          {
          }
        }
        catch (af paramh)
        {
          try
          {
            int j;
            paramh.bXr = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.bPB = Collections.unmodifiableList(this.bPB);
          this.bTW = locala.HM();
          this.bWd.yK();
          throw paramh;
          if ((i & 0x1) == 0) {
            break label240;
          }
          this.bPB = Collections.unmodifiableList(this.bPB);
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new af(paramh);
          k = i1;
          paramh.bXr = this;
          k = i1;
          throw paramh;
        }
        finally
        {
          for (;;) {}
          m = 1;
        }
        n = i;
        i1 = i;
        k = i;
        if (!a(paramh, locala, paramr, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bPB = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.bPB.add(paramh.a(k.ak.bPg, paramr));
          i = j;
        }
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static k Ch()
    {
      return bPI;
    }
    
    public static a b(k paramk)
    {
      return bPI.Cg().d(paramk);
    }
    
    public final bj<k> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zK().h(k.class, a.class);
    }
    
    public final a Cg()
    {
      if (this == bPI) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof k)) {
          return super.equals(paramObject);
        }
        paramObject = (k)paramObject;
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zJ().hashCode() + 779;
      int i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.bPB.size())
      {
        j += i.c(999, (aw)this.bPB.get(i));
        i += 1;
      }
      i = this.bWd.yC() + j + this.bTW.yC();
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.c<k.k, a>
      implements k.l
    {
      private int bOT;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x1) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x1;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.k Ci()
      {
        k.k localk = Cj();
        if (!localk.isInitialized()) {
          throw b(localk);
        }
        return localk;
      }
      
      private a l(at paramat)
      {
        if ((paramat instanceof k.k)) {
          return d((k.k)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a m(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 110	com/google/a/k$k:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 115 3 0
        //   12: checkcast 9	com/google/a/k$k
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 99	com/google/a/k$k$a:d	(Lcom/google/a/k$k;)Lcom/google/a/k$k$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 119	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$k
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 123	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 99	com/google/a/k$k$a:d	(Lcom/google/a/k$k;)Lcom/google/a/k$k$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a u(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a v(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a w(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a x(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      public final l.a AS()
      {
        return k.zJ();
      }
      
      protected final ac.f Ay()
      {
        return k.zK().h(k.k.class, a.class);
      }
      
      public final k.k Cj()
      {
        k.k localk = new k.k(this, (byte)0);
        if (this.bPD == null)
        {
          if ((this.bOT & 0x1) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFFE;
          }
          k.k.a(localk, this.bPB);
        }
        for (;;)
        {
          Gy();
          return localk;
          k.k.a(localk, this.bPD.build());
        }
      }
      
      public final a d(k.k paramk)
      {
        bq localbq = null;
        if (paramk == k.k.Ch()) {
          return this;
        }
        if (this.bPD == null) {
          if (!k.k.c(paramk).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label85;
            }
            this.bPB = k.k.c(paramk);
            this.bOT &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramk);
          v(paramk.bTW);
          onChanged();
          return this;
          label85:
          BT();
          this.bPB.addAll(k.k.c(paramk));
          break;
          if (!k.k.c(paramk).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.k.c(paramk);
              this.bOT &= 0xFFFFFFFE;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.k.c(paramk));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static abstract interface l
    extends ac.e
  {}
  
  public static final class m
    extends ac
    implements k.n
  {
    private static final m bPQ = new m();
    @Deprecated
    public static final bj<m> bPg = new c() {};
    private int bOT;
    private volatile Object bOU;
    int bPE;
    private int bPJ;
    private volatile Object bPK;
    private volatile Object bPL;
    private volatile Object bPM;
    int bPN;
    private volatile Object bPO;
    private k.o bPP;
    private byte bPe = -1;
    private int type_;
    
    private m()
    {
      this.bOU = "";
      this.bPJ = 1;
      this.type_ = 1;
      this.bPK = "";
      this.bPL = "";
      this.bPM = "";
      this.bPO = "";
    }
    
    private m(ac.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private m(h paramh, r paramr)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 48	com/google/a/k$m:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 87	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 88	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 94	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +506 -> 530
      //   27: aload_1
      //   28: invokevirtual 100	com/google/a/h:yT	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+518->553, 0:+524->559, 10:+115->150, 18:+164->199, 24:+207->242, 32:+228->263, 40:+273->308, 50:+319->354, 58:+345->380, 66:+371->406, 72:+445->480, 82:+468->503
      //   133: aload_1
      //   134: aload 6
      //   136: aload_2
      //   137: iload 4
      //   139: invokevirtual 103	com/google/a/k$m:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
      //   142: ifne +402 -> 544
      //   145: iconst_1
      //   146: istore_3
      //   147: goto +409 -> 556
      //   150: aload_1
      //   151: invokevirtual 107	com/google/a/h:zb	()Lcom/google/a/g;
      //   154: astore 5
      //   156: aload_0
      //   157: aload_0
      //   158: getfield 109	com/google/a/k$m:bOT	I
      //   161: iconst_1
      //   162: ior
      //   163: putfield 109	com/google/a/k$m:bOT	I
      //   166: aload_0
      //   167: aload 5
      //   169: putfield 61	com/google/a/k$m:bOU	Ljava/lang/Object;
      //   172: goto -149 -> 23
      //   175: astore_1
      //   176: aload_1
      //   177: aload_0
      //   178: putfield 113	com/google/a/af:bXr	Lcom/google/a/aw;
      //   181: aload_1
      //   182: athrow
      //   183: astore_1
      //   184: aload_0
      //   185: aload 6
      //   187: invokevirtual 119	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   190: putfield 123	com/google/a/k$m:bTW	Lcom/google/a/cc;
      //   193: aload_0
      //   194: invokevirtual 126	com/google/a/k$m:Gw	()V
      //   197: aload_1
      //   198: athrow
      //   199: aload_1
      //   200: invokevirtual 107	com/google/a/h:zb	()Lcom/google/a/g;
      //   203: astore 5
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 109	com/google/a/k$m:bOT	I
      //   210: bipush 32
      //   212: ior
      //   213: putfield 109	com/google/a/k$m:bOT	I
      //   216: aload_0
      //   217: aload 5
      //   219: putfield 69	com/google/a/k$m:bPL	Ljava/lang/Object;
      //   222: goto -199 -> 23
      //   225: astore_1
      //   226: new 83	com/google/a/af
      //   229: dup
      //   230: aload_1
      //   231: invokespecial 129	com/google/a/af:<init>	(Ljava/io/IOException;)V
      //   234: astore_1
      //   235: aload_1
      //   236: aload_0
      //   237: putfield 113	com/google/a/af:bXr	Lcom/google/a/aw;
      //   240: aload_1
      //   241: athrow
      //   242: aload_0
      //   243: aload_0
      //   244: getfield 109	com/google/a/k$m:bOT	I
      //   247: iconst_2
      //   248: ior
      //   249: putfield 109	com/google/a/k$m:bOT	I
      //   252: aload_0
      //   253: aload_1
      //   254: invokevirtual 132	com/google/a/h:yW	()I
      //   257: putfield 134	com/google/a/k$m:bPE	I
      //   260: goto -237 -> 23
      //   263: aload_1
      //   264: invokevirtual 137	com/google/a/h:zd	()I
      //   267: istore 4
      //   269: iload 4
      //   271: invokestatic 141	com/google/a/k$m$b:gp	(I)Lcom/google/a/k$m$b;
      //   274: ifnonnull +15 -> 289
      //   277: aload 6
      //   279: iconst_4
      //   280: iload 4
      //   282: invokevirtual 145	com/google/a/cc$a:bx	(II)Lcom/google/a/cc$a;
      //   285: pop
      //   286: goto -263 -> 23
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 109	com/google/a/k$m:bOT	I
      //   294: iconst_4
      //   295: ior
      //   296: putfield 109	com/google/a/k$m:bOT	I
      //   299: aload_0
      //   300: iload 4
      //   302: putfield 63	com/google/a/k$m:bPJ	I
      //   305: goto -282 -> 23
      //   308: aload_1
      //   309: invokevirtual 137	com/google/a/h:zd	()I
      //   312: istore 4
      //   314: iload 4
      //   316: invokestatic 149	com/google/a/k$m$c:gq	(I)Lcom/google/a/k$m$c;
      //   319: ifnonnull +15 -> 334
      //   322: aload 6
      //   324: iconst_5
      //   325: iload 4
      //   327: invokevirtual 145	com/google/a/cc$a:bx	(II)Lcom/google/a/cc$a;
      //   330: pop
      //   331: goto -308 -> 23
      //   334: aload_0
      //   335: aload_0
      //   336: getfield 109	com/google/a/k$m:bOT	I
      //   339: bipush 8
      //   341: ior
      //   342: putfield 109	com/google/a/k$m:bOT	I
      //   345: aload_0
      //   346: iload 4
      //   348: putfield 65	com/google/a/k$m:type_	I
      //   351: goto -328 -> 23
      //   354: aload_1
      //   355: invokevirtual 107	com/google/a/h:zb	()Lcom/google/a/g;
      //   358: astore 5
      //   360: aload_0
      //   361: aload_0
      //   362: getfield 109	com/google/a/k$m:bOT	I
      //   365: bipush 16
      //   367: ior
      //   368: putfield 109	com/google/a/k$m:bOT	I
      //   371: aload_0
      //   372: aload 5
      //   374: putfield 67	com/google/a/k$m:bPK	Ljava/lang/Object;
      //   377: goto -354 -> 23
      //   380: aload_1
      //   381: invokevirtual 107	com/google/a/h:zb	()Lcom/google/a/g;
      //   384: astore 5
      //   386: aload_0
      //   387: aload_0
      //   388: getfield 109	com/google/a/k$m:bOT	I
      //   391: bipush 64
      //   393: ior
      //   394: putfield 109	com/google/a/k$m:bOT	I
      //   397: aload_0
      //   398: aload 5
      //   400: putfield 71	com/google/a/k$m:bPM	Ljava/lang/Object;
      //   403: goto -380 -> 23
      //   406: aload_0
      //   407: getfield 109	com/google/a/k$m:bOT	I
      //   410: sipush 512
      //   413: iand
      //   414: ifeq +133 -> 547
      //   417: aload_0
      //   418: getfield 151	com/google/a/k$m:bPP	Lcom/google/a/k$o;
      //   421: invokevirtual 157	com/google/a/k$o:CH	()Lcom/google/a/k$o$a;
      //   424: astore 5
      //   426: aload_0
      //   427: aload_1
      //   428: getstatic 158	com/google/a/k$o:bPg	Lcom/google/a/bj;
      //   431: aload_2
      //   432: invokevirtual 161	com/google/a/h:a	(Lcom/google/a/bj;Lcom/google/a/r;)Lcom/google/a/aw;
      //   435: checkcast 153	com/google/a/k$o
      //   438: putfield 151	com/google/a/k$m:bPP	Lcom/google/a/k$o;
      //   441: aload 5
      //   443: ifnull +22 -> 465
      //   446: aload 5
      //   448: aload_0
      //   449: getfield 151	com/google/a/k$m:bPP	Lcom/google/a/k$o;
      //   452: invokevirtual 167	com/google/a/k$o$a:d	(Lcom/google/a/k$o;)Lcom/google/a/k$o$a;
      //   455: pop
      //   456: aload_0
      //   457: aload 5
      //   459: invokevirtual 171	com/google/a/k$o$a:CK	()Lcom/google/a/k$o;
      //   462: putfield 151	com/google/a/k$m:bPP	Lcom/google/a/k$o;
      //   465: aload_0
      //   466: aload_0
      //   467: getfield 109	com/google/a/k$m:bOT	I
      //   470: sipush 512
      //   473: ior
      //   474: putfield 109	com/google/a/k$m:bOT	I
      //   477: goto -454 -> 23
      //   480: aload_0
      //   481: aload_0
      //   482: getfield 109	com/google/a/k$m:bOT	I
      //   485: sipush 128
      //   488: ior
      //   489: putfield 109	com/google/a/k$m:bOT	I
      //   492: aload_0
      //   493: aload_1
      //   494: invokevirtual 132	com/google/a/h:yW	()I
      //   497: putfield 173	com/google/a/k$m:bPN	I
      //   500: goto -477 -> 23
      //   503: aload_1
      //   504: invokevirtual 107	com/google/a/h:zb	()Lcom/google/a/g;
      //   507: astore 5
      //   509: aload_0
      //   510: aload_0
      //   511: getfield 109	com/google/a/k$m:bOT	I
      //   514: sipush 256
      //   517: ior
      //   518: putfield 109	com/google/a/k$m:bOT	I
      //   521: aload_0
      //   522: aload 5
      //   524: putfield 73	com/google/a/k$m:bPO	Ljava/lang/Object;
      //   527: goto -504 -> 23
      //   530: aload_0
      //   531: aload 6
      //   533: invokevirtual 119	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   536: putfield 123	com/google/a/k$m:bTW	Lcom/google/a/cc;
      //   539: aload_0
      //   540: invokevirtual 126	com/google/a/k$m:Gw	()V
      //   543: return
      //   544: goto +12 -> 556
      //   547: aconst_null
      //   548: astore 5
      //   550: goto -124 -> 426
      //   553: goto -421 -> 132
      //   556: goto -533 -> 23
      //   559: iconst_1
      //   560: istore_3
      //   561: goto -538 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	564	0	this	m
      //   0	564	1	paramh	h
      //   0	564	2	paramr	r
      //   22	539	3	i	int
      //   31	316	4	j	int
      //   154	395	5	localObject	Object
      //   19	513	6	locala	cc.a
      // Exception table:
      //   from	to	target	type
      //   27	33	175	com/google/a/af
      //   132	145	175	com/google/a/af
      //   150	172	175	com/google/a/af
      //   199	222	175	com/google/a/af
      //   242	260	175	com/google/a/af
      //   263	286	175	com/google/a/af
      //   289	305	175	com/google/a/af
      //   308	331	175	com/google/a/af
      //   334	351	175	com/google/a/af
      //   354	377	175	com/google/a/af
      //   380	403	175	com/google/a/af
      //   406	426	175	com/google/a/af
      //   426	441	175	com/google/a/af
      //   446	465	175	com/google/a/af
      //   465	477	175	com/google/a/af
      //   480	500	175	com/google/a/af
      //   503	527	175	com/google/a/af
      //   27	33	183	finally
      //   132	145	183	finally
      //   150	172	183	finally
      //   176	183	183	finally
      //   199	222	183	finally
      //   226	242	183	finally
      //   242	260	183	finally
      //   263	286	183	finally
      //   289	305	183	finally
      //   308	331	183	finally
      //   334	351	183	finally
      //   354	377	183	finally
      //   380	403	183	finally
      //   406	426	183	finally
      //   426	441	183	finally
      //   446	465	183	finally
      //   465	477	183	finally
      //   480	500	183	finally
      //   503	527	183	finally
      //   27	33	225	java/io/IOException
      //   132	145	225	java/io/IOException
      //   150	172	225	java/io/IOException
      //   199	222	225	java/io/IOException
      //   242	260	225	java/io/IOException
      //   263	286	225	java/io/IOException
      //   289	305	225	java/io/IOException
      //   308	331	225	java/io/IOException
      //   334	351	225	java/io/IOException
      //   354	377	225	java/io/IOException
      //   380	403	225	java/io/IOException
      //   406	426	225	java/io/IOException
      //   426	441	225	java/io/IOException
      //   446	465	225	java/io/IOException
      //   465	477	225	java/io/IOException
      //   480	500	225	java/io/IOException
      //   503	527	225	java/io/IOException
    }
    
    private a Cw()
    {
      if (this == bPQ) {
        return new a((byte)0);
      }
      return new a((byte)0).f(this);
    }
    
    public static m Cx()
    {
      return bPQ;
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x200) != 0;
    }
    
    public final bj<m> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zM().h(m.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean BV()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final boolean Ck()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final b Cl()
    {
      b localb2 = b.gp(this.bPJ);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.bPR;
      }
      return localb1;
    }
    
    public final boolean Cm()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final k.m.c Cn()
    {
      k.m.c localc2 = k.m.c.gq(this.type_);
      k.m.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = k.m.c.bPX;
      }
      return localc1;
    }
    
    public final boolean Co()
    {
      return (this.bOT & 0x10) != 0;
    }
    
    public final boolean Cp()
    {
      return (this.bOT & 0x20) != 0;
    }
    
    public final String Cq()
    {
      Object localObject = this.bPL;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bPL = str;
      }
      return str;
    }
    
    public final boolean Cr()
    {
      return (this.bOT & 0x40) != 0;
    }
    
    public final boolean Cs()
    {
      return (this.bOT & 0x80) != 0;
    }
    
    public final boolean Ct()
    {
      return (this.bOT & 0x100) != 0;
    }
    
    public final String Cu()
    {
      Object localObject = this.bPO;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bPO = str;
      }
      return str;
    }
    
    public final k.o Cv()
    {
      if (this.bPP == null) {
        return k.o.CI();
      }
      return this.bPP;
    }
    
    public final void a(i parami)
    {
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      if ((this.bOT & 0x20) != 0) {
        ac.a(parami, 2, this.bPL);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.bs(3, this.bPE);
      }
      if ((this.bOT & 0x4) != 0) {
        parami.bs(4, this.bPJ);
      }
      if ((this.bOT & 0x8) != 0) {
        parami.bs(5, this.type_);
      }
      if ((this.bOT & 0x10) != 0) {
        ac.a(parami, 6, this.bPK);
      }
      if ((this.bOT & 0x40) != 0) {
        ac.a(parami, 7, this.bPM);
      }
      if ((this.bOT & 0x200) != 0) {
        parami.a(8, Cv());
      }
      if ((this.bOT & 0x80) != 0) {
        parami.bs(9, this.bPN);
      }
      if ((this.bOT & 0x100) != 0) {
        ac.a(parami, 10, this.bPO);
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof m)) {
          return super.equals(paramObject);
        }
        paramObject = (m)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (BV() != paramObject.BV()) {
          return false;
        }
        if ((BV()) && (this.bPE != paramObject.bPE)) {
          return false;
        }
        if (Ck() != paramObject.Ck()) {
          return false;
        }
        if ((Ck()) && (this.bPJ != paramObject.bPJ)) {
          return false;
        }
        if (Cm() != paramObject.Cm()) {
          return false;
        }
        if ((Cm()) && (this.type_ != paramObject.type_)) {
          return false;
        }
        if (Co() != paramObject.Co()) {
          return false;
        }
        if ((Co()) && (!getTypeName().equals(paramObject.getTypeName()))) {
          return false;
        }
        if (Cp() != paramObject.Cp()) {
          return false;
        }
        if ((Cp()) && (!Cq().equals(paramObject.Cq()))) {
          return false;
        }
        if (Cr() != paramObject.Cr()) {
          return false;
        }
        if ((Cr()) && (!getDefaultValue().equals(paramObject.getDefaultValue()))) {
          return false;
        }
        if (Cs() != paramObject.Cs()) {
          return false;
        }
        if ((Cs()) && (this.bPN != paramObject.bPN)) {
          return false;
        }
        if (Ct() != paramObject.Ct()) {
          return false;
        }
        if ((Ct()) && (!Cu().equals(paramObject.Cu()))) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!Cv().equals(paramObject.Cv()))) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final String getDefaultValue()
    {
      Object localObject = this.bPM;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bPM = str;
      }
      return str;
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final String getTypeName()
    {
      Object localObject = this.bPK;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bPK = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zL().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (BV()) {
        j = (i * 37 + 3) * 53 + this.bPE;
      }
      i = j;
      if (Ck()) {
        i = (j * 37 + 4) * 53 + this.bPJ;
      }
      j = i;
      if (Cm()) {
        j = (i * 37 + 5) * 53 + this.type_;
      }
      i = j;
      if (Co()) {
        i = (j * 37 + 6) * 53 + getTypeName().hashCode();
      }
      j = i;
      if (Cp()) {
        j = (i * 37 + 2) * 53 + Cq().hashCode();
      }
      i = j;
      if (Cr()) {
        i = (j * 37 + 7) * 53 + getDefaultValue().hashCode();
      }
      j = i;
      if (Cs()) {
        j = (i * 37 + 9) * 53 + this.bPN;
      }
      i = j;
      if (Ct()) {
        i = (j * 37 + 10) * 53 + Cu().hashCode();
      }
      j = i;
      if (AF()) {
        j = (i * 37 + 8) * 53 + Cv().hashCode();
      }
      i = j * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bPe;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((AF()) && (!Cv().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bOT & 0x1) != 0) {
        j = ac.d(1, this.bOU) + 0;
      }
      i = j;
      if ((this.bOT & 0x20) != 0) {
        i = j + ac.d(2, this.bPL);
      }
      j = i;
      if ((this.bOT & 0x2) != 0) {
        j = i + i.bu(3, this.bPE);
      }
      i = j;
      if ((this.bOT & 0x4) != 0) {
        i = j + i.bv(4, this.bPJ);
      }
      j = i;
      if ((this.bOT & 0x8) != 0) {
        j = i + i.bv(5, this.type_);
      }
      i = j;
      if ((this.bOT & 0x10) != 0) {
        i = j + ac.d(6, this.bPK);
      }
      j = i;
      if ((this.bOT & 0x40) != 0) {
        j = i + ac.d(7, this.bPM);
      }
      i = j;
      if ((this.bOT & 0x200) != 0) {
        i = j + i.c(8, Cv());
      }
      j = i;
      if ((this.bOT & 0x80) != 0) {
        j = i + i.bu(9, this.bPN);
      }
      i = j;
      if ((this.bOT & 0x100) != 0) {
        i = j + ac.d(10, this.bPO);
      }
      i += this.bTW.yC();
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.a<a>
      implements k.n
    {
      private int bOT;
      private Object bOU = "";
      private int bPE;
      private int bPJ = 1;
      private Object bPK = "";
      private Object bPL = "";
      private Object bPM = "";
      private int bPN;
      private Object bPO = "";
      private k.o bPP;
      private bu<k.o, k.o.a, k.p> bPn;
      private int type_ = 1;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          Bh();
        }
      }
      
      private bu<k.o, k.o.a, k.p> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(Cv(), GA(), this.bWv);
          this.bPP = null;
        }
        return this.bPn;
      }
      
      private k.o Cv()
      {
        if (this.bPn == null)
        {
          if (this.bPP == null) {
            return k.o.CI();
          }
          return this.bPP;
        }
        return (k.o)this.bPn.Hu();
      }
      
      private k.m Cy()
      {
        k.m localm = Cz();
        if (!localm.isInitialized()) {
          throw b(localm);
        }
        return localm;
      }
      
      private k.m Cz()
      {
        int j = 0;
        k.m localm = new k.m(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        k.m.a(localm, this.bOU);
        int i = j;
        if ((k & 0x2) != 0)
        {
          k.m.a(localm, this.bPE);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        k.m.b(localm, this.bPJ);
        i = j;
        if ((k & 0x8) != 0) {
          i = j | 0x8;
        }
        k.m.c(localm, this.type_);
        j = i;
        if ((k & 0x10) != 0) {
          j = i | 0x10;
        }
        k.m.b(localm, this.bPK);
        i = j;
        if ((k & 0x20) != 0) {
          i = j | 0x20;
        }
        k.m.c(localm, this.bPL);
        j = i;
        if ((k & 0x40) != 0) {
          j = i | 0x40;
        }
        k.m.d(localm, this.bPM);
        i = j;
        if ((k & 0x80) != 0)
        {
          k.m.d(localm, this.bPN);
          i = j | 0x80;
        }
        if ((k & 0x100) != 0) {
          i |= 0x100;
        }
        for (;;)
        {
          k.m.e(localm, this.bPO);
          j = i;
          if ((k & 0x200) != 0)
          {
            if (this.bPn != null) {
              break label273;
            }
            k.m.a(localm, this.bPP);
          }
          for (;;)
          {
            j = i | 0x200;
            k.m.e(localm, j);
            Gy();
            return localm;
            label273:
            k.m.a(localm, (k.o)this.bPn.Hv());
          }
        }
      }
      
      private a a(k.m.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x4;
        this.bPJ = paramb.value;
        onChanged();
        return this;
      }
      
      private a a(k.m.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x8;
        this.type_ = paramc.value;
        onChanged();
        return this;
      }
      
      private a a(k.o paramo)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x200) != 0) && (this.bPP != null) && (this.bPP != k.o.CI()))
          {
            this.bPP = k.o.b(this.bPP).d(paramo).CK();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x200;
          return this;
          this.bPP = paramo;
          break;
          this.bPn.b(paramo);
        }
      }
      
      private a gn(int paramInt)
      {
        this.bOT |= 0x2;
        this.bPE = paramInt;
        onChanged();
        return this;
      }
      
      private a go(int paramInt)
      {
        this.bOT |= 0x80;
        this.bPN = paramInt;
        onChanged();
        return this;
      }
      
      private a m(at paramat)
      {
        if ((paramat instanceof k.m)) {
          return f((k.m)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a n(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 207	com/google/a/k$m:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 212 3 0
        //   12: checkcast 9	com/google/a/k$m
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 196	com/google/a/k$m$a:f	(Lcom/google/a/k$m;)Lcom/google/a/k$m$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 216	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$m
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 220	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 196	com/google/a/k$m$a:f	(Lcom/google/a/k$m;)Lcom/google/a/k$m$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a w(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a x(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a y(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a z(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      public final l.a AS()
      {
        return k.zL();
      }
      
      protected final ac.f Ay()
      {
        return k.zM().h(k.m.class, a.class);
      }
      
      public final a f(k.m paramm)
      {
        if (paramm == k.m.Cx()) {
          return this;
        }
        if (paramm.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.m.a(paramm);
          onChanged();
        }
        if (paramm.BV()) {
          gn(paramm.bPE);
        }
        if (paramm.Ck()) {
          a(paramm.Cl());
        }
        if (paramm.Cm()) {
          a(paramm.Cn());
        }
        if (paramm.Co())
        {
          this.bOT |= 0x10;
          this.bPK = k.m.b(paramm);
          onChanged();
        }
        if (paramm.Cp())
        {
          this.bOT |= 0x20;
          this.bPL = k.m.c(paramm);
          onChanged();
        }
        if (paramm.Cr())
        {
          this.bOT |= 0x40;
          this.bPM = k.m.d(paramm);
          onChanged();
        }
        if (paramm.Cs()) {
          go(paramm.bPN);
        }
        if (paramm.Ct())
        {
          this.bOT |= 0x100;
          this.bPO = k.m.e(paramm);
          onChanged();
        }
        if (paramm.AF()) {
          a(paramm.Cv());
        }
        x(paramm.bTW);
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bOT & 0x200) != 0) {}
        for (int i = 1; (i != 0) && (!Cv().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
    
    public static enum b
      implements bn
    {
      private static final ae.b<b> bPU = new ae.b() {};
      private static final b[] bPV = values();
      final int value;
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b gp(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return bPR;
        case 2: 
          return bPS;
        }
        return bPT;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static abstract interface n
    extends az
  {}
  
  public static final class o
    extends ac.d<o>
    implements k.p
  {
    @Deprecated
    public static final bj<o> bPg = new c() {};
    private static final o bQw = new o();
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    private int bQr;
    boolean bQs;
    private int bQt;
    boolean bQu;
    boolean bQv;
    
    private o()
    {
      this.bQr = 0;
      this.bQt = 0;
      this.bPB = Collections.emptyList();
    }
    
    private o(ac.c<o, ?> paramc)
    {
      super();
    }
    
    private o(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              j = paramh.zd();
              n = i;
              i1 = i;
              k = i;
              if (b.gr(j) == null)
              {
                n = i;
                i1 = i;
                k = i;
                locala.bx(1, j);
                break label26;
              }
              break;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally {}
            if ((k & 0x40) != 0) {
              this.bPB = Collections.unmodifiableList(this.bPB);
            }
            this.bTW = locala.HM();
            this.bWd.yK();
            throw paramh;
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.bQr = j;
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bQs = paramh.yZ();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.bPA = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.bQu = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          int j = paramh.zd();
          n = i;
          i1 = i;
          k = i;
          if (c.gs(j) == null)
          {
            n = i;
            i1 = i;
            k = i;
            locala.bx(6, j);
            break;
          }
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.bQt = j;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x20;
          n = i;
          i1 = i;
          k = i;
          this.bQv = paramh.yZ();
          break;
          j = i;
          if ((i & 0x40) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bPB = new ArrayList();
            j = i | 0x40;
          }
          n = j;
          i1 = j;
          k = j;
          this.bPB.add(paramh.a(k.ak.bPg, paramr));
          i = j;
          break;
          if ((i & 0x40) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static o CI()
    {
      return bQw;
    }
    
    public static a b(o paramo)
    {
      return bQw.CH().d(paramo);
    }
    
    public final bj<o> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Ae().h(o.class, a.class);
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x10) != 0;
    }
    
    public final boolean CA()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final b CB()
    {
      b localb2 = b.gr(this.bQr);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.bQx;
      }
      return localb1;
    }
    
    public final boolean CC()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final boolean CD()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final c CE()
    {
      c localc2 = c.gs(this.bQt);
      c localc1 = localc2;
      if (localc2 == null) {
        localc1 = c.bQC;
      }
      return localc1;
    }
    
    public final boolean CF()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final boolean CG()
    {
      return (this.bOT & 0x20) != 0;
    }
    
    public final a CH()
    {
      if (this == bQw) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        parami.bs(1, this.bQr);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.r(2, this.bQs);
      }
      if ((this.bOT & 0x10) != 0) {
        parami.r(3, this.bPA);
      }
      if ((this.bOT & 0x8) != 0) {
        parami.r(5, this.bQu);
      }
      if ((this.bOT & 0x4) != 0) {
        parami.bs(6, this.bQt);
      }
      if ((this.bOT & 0x20) != 0) {
        parami.r(10, this.bQv);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof o)) {
          return super.equals(paramObject);
        }
        paramObject = (o)paramObject;
        if (CA() != paramObject.CA()) {
          return false;
        }
        if ((CA()) && (this.bQr != paramObject.bQr)) {
          return false;
        }
        if (CC() != paramObject.CC()) {
          return false;
        }
        if ((CC()) && (this.bQs != paramObject.bQs)) {
          return false;
        }
        if (CD() != paramObject.CD()) {
          return false;
        }
        if ((CD()) && (this.bQt != paramObject.bQt)) {
          return false;
        }
        if (CF() != paramObject.CF()) {
          return false;
        }
        if ((CF()) && (this.bQu != paramObject.bQu)) {
          return false;
        }
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (CG() != paramObject.CG()) {
          return false;
        }
        if ((CG()) && (this.bQv != paramObject.bQv)) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Ad().hashCode() + 779;
      int i = j;
      if (CA()) {
        i = (j * 37 + 1) * 53 + this.bQr;
      }
      j = i;
      if (CC()) {
        j = (i * 37 + 2) * 53 + ae.bF(this.bQs);
      }
      i = j;
      if (CD()) {
        i = (j * 37 + 6) * 53 + this.bQt;
      }
      j = i;
      if (CF()) {
        j = (i * 37 + 5) * 53 + ae.bF(this.bQu);
      }
      i = j;
      if (BN()) {
        i = (j * 37 + 3) * 53 + ae.bF(this.bPA);
      }
      j = i;
      if (CG()) {
        j = (i * 37 + 10) * 53 + ae.bF(this.bQv);
      }
      i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int k = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (int j = i.bv(1, this.bQr) + 0;; j = 0)
      {
        i = j;
        if ((this.bOT & 0x2) != 0) {
          i = j + i.fR(2);
        }
        j = i;
        if ((this.bOT & 0x10) != 0) {
          j = i + i.fR(3);
        }
        i = j;
        if ((this.bOT & 0x8) != 0) {
          i = j + i.fR(5);
        }
        j = i;
        if ((this.bOT & 0x4) != 0) {
          j = i + i.bv(6, this.bQt);
        }
        i = j;
        if ((this.bOT & 0x20) != 0) {
          i = j + i.fR(10);
        }
        j = k;
        while (j < this.bPB.size())
        {
          k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        i = this.bWd.yC() + i + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.c<k.o, a>
      implements k.p
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      private int bQr = 0;
      private boolean bQs;
      private int bQt = 0;
      private boolean bQu;
      private boolean bQv;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private a A(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private a B(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private void BT()
      {
        if ((this.bOT & 0x40) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x40;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.o CJ()
      {
        k.o localo = CK();
        if (!localo.isInitialized()) {
          throw b(localo);
        }
        return localo;
      }
      
      private a a(k.o.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x1;
        this.bQr = paramb.value;
        onChanged();
        return this;
      }
      
      private a a(k.o.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x4;
        this.bQt = paramc.value;
        onChanged();
        return this;
      }
      
      private a bi(boolean paramBoolean)
      {
        this.bOT |= 0x2;
        this.bQs = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bj(boolean paramBoolean)
      {
        this.bOT |= 0x8;
        this.bQu = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bk(boolean paramBoolean)
      {
        this.bOT |= 0x10;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bl(boolean paramBoolean)
      {
        this.bOT |= 0x20;
        this.bQv = paramBoolean;
        onChanged();
        return this;
      }
      
      private a n(at paramat)
      {
        if ((paramat instanceof k.o)) {
          return d((k.o)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a o(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 158	com/google/a/k$o:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 163 3 0
        //   12: checkcast 9	com/google/a/k$o
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 148	com/google/a/k$o$a:d	(Lcom/google/a/k$o;)Lcom/google/a/k$o$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 167	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$o
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 171	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 148	com/google/a/k$o$a:d	(Lcom/google/a/k$o;)Lcom/google/a/k$o$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a y(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a z(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      public final l.a AS()
      {
        return k.Ad();
      }
      
      protected final ac.f Ay()
      {
        return k.Ae().h(k.o.class, a.class);
      }
      
      public final k.o CK()
      {
        int j = 0;
        k.o localo = new k.o(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        k.o.a(localo, this.bQr);
        int i = j;
        if ((k & 0x2) != 0)
        {
          k.o.a(localo, this.bQs);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        k.o.b(localo, this.bQt);
        i = j;
        if ((k & 0x8) != 0)
        {
          k.o.b(localo, this.bQu);
          i = j | 0x8;
        }
        j = i;
        if ((k & 0x10) != 0)
        {
          k.o.c(localo, this.bPA);
          j = i | 0x10;
        }
        i = j;
        if ((k & 0x20) != 0)
        {
          k.o.d(localo, this.bQv);
          i = j | 0x20;
        }
        if (this.bPD == null)
        {
          if ((this.bOT & 0x40) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFBF;
          }
          k.o.a(localo, this.bPB);
        }
        for (;;)
        {
          k.o.c(localo, i);
          Gy();
          return localo;
          k.o.a(localo, this.bPD.build());
        }
      }
      
      public final a d(k.o paramo)
      {
        bq localbq = null;
        if (paramo == k.o.CI()) {
          return this;
        }
        if (paramo.CA()) {
          a(paramo.CB());
        }
        if (paramo.CC()) {
          bi(paramo.bQs);
        }
        if (paramo.CD()) {
          a(paramo.CE());
        }
        if (paramo.CF()) {
          bj(paramo.bQu);
        }
        if (paramo.BN()) {
          bk(paramo.bPA);
        }
        if (paramo.CG()) {
          bl(paramo.bQv);
        }
        if (this.bPD == null) {
          if (!k.o.c(paramo).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label181;
            }
            this.bPB = k.o.c(paramo);
            this.bOT &= 0xFFFFFFBF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramo);
          z(paramo.bTW);
          onChanged();
          return this;
          label181:
          BT();
          this.bPB.addAll(k.o.c(paramo));
          break;
          if (!k.o.c(paramo).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.o.c(paramo);
              this.bOT &= 0xFFFFFFBF;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.o.c(paramo));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
    
    public static enum b
      implements bn
    {
      private static final ae.b<b> bPU = new ae.b() {};
      private static final b[] bQA = values();
      final int value;
      
      static
      {
        bQB = new b[] { bQx, bQy, bQz };
      }
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b gr(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return bQx;
        case 1: 
          return bQy;
        }
        return bQz;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
    
    public static enum c
      implements bn
    {
      private static final ae.b<c> bPU = new ae.b() {};
      private static final c[] bQF = values();
      final int value;
      
      private c(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static c gs(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return bQC;
        case 1: 
          return bQD;
        }
        return bQE;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static abstract interface p
    extends ac.e
  {}
  
  public static final class q
    extends ac
    implements k.r
  {
    @Deprecated
    public static final bj<q> bPg = new c() {};
    private static final q bQQ = new q();
    private int bOT;
    private volatile Object bOU;
    private List<k.m> bOW;
    private List<k.c> bOY;
    private byte bPe = -1;
    private volatile Object bQH;
    ak bQI;
    ae.d bQJ;
    private ae.d bQK;
    private List<k.a> bQL;
    private List<k.ae> bQM;
    private k.s bQN;
    private k.ai bQO;
    private volatile Object bQP;
    
    private q()
    {
      this.bOU = "";
      this.bQH = "";
      this.bQI = aj.bXM;
      this.bQJ = ad.GE();
      this.bQK = ad.GE();
      this.bQL = Collections.emptyList();
      this.bOY = Collections.emptyList();
      this.bQM = Collections.emptyList();
      this.bOW = Collections.emptyList();
      this.bQP = "";
    }
    
    private q(ac.a<?> parama)
    {
      super();
    }
    
    private q(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int i1 = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int k;
        int m;
        int j;
        if (i1 == 0)
        {
          k = i;
          m = i;
          j = i;
        }
        for (;;)
        {
          try
          {
            n = paramh.yT();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (a(paramh, locala, paramr, n)) {
                break label1741;
              }
              j = 1;
              break label1763;
              k = i;
              m = i;
              j = i;
              localObject = paramh.zb();
              k = i;
              m = i;
              j = i;
              this.bOT |= 0x1;
              k = i;
              m = i;
              j = i;
              this.bOU = localObject;
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              j = k;
              if ((j & 0x4) != 0) {
                this.bQI = this.bQI.GR();
              }
              if ((j & 0x20) != 0) {
                this.bQL = Collections.unmodifiableList(this.bQL);
              }
              if ((j & 0x40) != 0) {
                this.bOY = Collections.unmodifiableList(this.bOY);
              }
              if ((j & 0x80) != 0) {
                this.bQM = Collections.unmodifiableList(this.bQM);
              }
              if ((j & 0x100) != 0) {
                this.bOW = Collections.unmodifiableList(this.bOW);
              }
              if ((j & 0x8) != 0) {
                this.bQJ.yK();
              }
              if ((j & 0x10) != 0) {
                this.bQK.yK();
              }
              this.bTW = locala.HM();
              Gw();
            }
            k = i;
            m = i;
            j = i;
            localObject = paramh.zb();
            k = i;
            m = i;
            j = i;
            this.bOT |= 0x2;
            k = i;
            m = i;
            j = i;
            this.bQH = localObject;
            break;
          }
          catch (IOException paramh)
          {
            j = m;
            paramh = new af(paramh);
            j = m;
            paramh.bXr = this;
            j = m;
            throw paramh;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            localObject = paramh.zb();
            n = i;
            if ((i & 0x4) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bQI = new aj();
              n = i | 0x4;
            }
            k = n;
            m = n;
            j = n;
            this.bQI.d((g)localObject);
            i = n;
          }
          break;
          int n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQL = new ArrayList();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.bQL.add(paramh.a(k.a.bPg, paramr));
          i = n;
          break;
          n = i;
          if ((i & 0x40) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bOY = new ArrayList();
            n = i | 0x40;
          }
          k = n;
          m = n;
          j = n;
          this.bOY.add(paramh.a(k.c.bPg, paramr));
          i = n;
          break;
          n = i;
          if ((i & 0x80) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQM = new ArrayList();
            n = i | 0x80;
          }
          k = n;
          m = n;
          j = n;
          this.bQM.add(paramh.a(k.ae.bPg, paramr));
          i = n;
          break;
          n = i;
          if ((i & 0x100) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bOW = new ArrayList();
            n = i | 0x100;
          }
          k = n;
          m = n;
          j = n;
          this.bOW.add(paramh.a(k.m.bPg, paramr));
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          if ((this.bOT & 0x4) != 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (Object localObject = this.bQN.DM();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.bQN = ((k.s)paramh.a(k.s.bPg, paramr));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((k.s.a)localObject).n(this.bQN);
              k = i;
              m = i;
              j = i;
              this.bQN = ((k.s.a)localObject).DP();
            }
            k = i;
            m = i;
            j = i;
            this.bOT |= 0x4;
            break;
            k = i;
            m = i;
            j = i;
            if ((this.bOT & 0x8) != 0)
            {
              k = i;
              m = i;
              j = i;
            }
            for (localObject = this.bQO.EJ();; localObject = null)
            {
              k = i;
              m = i;
              j = i;
              this.bQO = ((k.ai)paramh.a(k.ai.bPg, paramr));
              if (localObject != null)
              {
                k = i;
                m = i;
                j = i;
                ((k.ai.a)localObject).d(this.bQO);
                k = i;
                m = i;
                j = i;
                this.bQO = ((k.ai.a)localObject).EM();
              }
              k = i;
              m = i;
              j = i;
              this.bOT |= 0x8;
              break;
              n = i;
              if ((i & 0x8) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.bQJ = new ad();
                n = i | 0x8;
              }
              k = n;
              m = n;
              j = n;
              this.bQJ.gF(paramh.yW());
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              int i2 = paramh.fH(paramh.zi());
              n = i;
              if ((i & 0x8) == 0)
              {
                k = i;
                m = i;
                j = i;
                n = i;
                if (paramh.zk() > 0)
                {
                  k = i;
                  m = i;
                  j = i;
                  this.bQJ = new ad();
                  n = i | 0x8;
                }
              }
              for (;;)
              {
                k = n;
                m = n;
                j = n;
                if (paramh.zk() <= 0) {
                  break;
                }
                k = n;
                m = n;
                j = n;
                this.bQJ.gF(paramh.yW());
              }
              k = n;
              m = n;
              j = n;
              paramh.fI(i2);
              i = n;
              break;
              n = i;
              if ((i & 0x10) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.bQK = new ad();
                n = i | 0x10;
              }
              k = n;
              m = n;
              j = n;
              this.bQK.gF(paramh.yW());
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              i2 = paramh.fH(paramh.zi());
              n = i;
              if ((i & 0x10) == 0)
              {
                k = i;
                m = i;
                j = i;
                n = i;
                if (paramh.zk() > 0)
                {
                  k = i;
                  m = i;
                  j = i;
                  this.bQK = new ad();
                  n = i | 0x10;
                }
              }
              for (;;)
              {
                k = n;
                m = n;
                j = n;
                if (paramh.zk() <= 0) {
                  break;
                }
                k = n;
                m = n;
                j = n;
                this.bQK.gF(paramh.yW());
              }
              k = n;
              m = n;
              j = n;
              paramh.fI(i2);
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              localObject = paramh.zb();
              k = i;
              m = i;
              j = i;
              this.bOT |= 0x10;
              k = i;
              m = i;
              j = i;
              this.bQP = localObject;
              break;
              if ((i & 0x4) != 0) {
                this.bQI = this.bQI.GR();
              }
              if ((i & 0x20) != 0) {
                this.bQL = Collections.unmodifiableList(this.bQL);
              }
              if ((i & 0x40) != 0) {
                this.bOY = Collections.unmodifiableList(this.bOY);
              }
              if ((i & 0x80) != 0) {
                this.bQM = Collections.unmodifiableList(this.bQM);
              }
              if ((i & 0x100) != 0) {
                this.bOW = Collections.unmodifiableList(this.bOW);
              }
              if ((i & 0x8) != 0) {
                this.bQJ.yK();
              }
              if ((i & 0x10) != 0) {
                this.bQK.yK();
              }
              this.bTW = locala.HM();
              Gw();
              return;
              label1741:
              j = i1;
              break label1763;
            }
          }
        }
        label1763:
        i1 = j;
        continue;
        i1 = 1;
      }
    }
    
    public static a CV()
    {
      return bQQ.CW();
    }
    
    private a CW()
    {
      if (this == bQQ) {
        return new a((byte)0);
      }
      return new a((byte)0).k(this);
    }
    
    public static q CX()
    {
      return bQQ;
    }
    
    public static q E(byte[] paramArrayOfByte)
    {
      return (q)bPg.y(paramArrayOfByte);
    }
    
    public final int AA()
    {
      return this.bOW.size();
    }
    
    public final int AC()
    {
      return this.bOY.size();
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final bj<q> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zC().h(q.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean CL()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final int CM()
    {
      return this.bQI.size();
    }
    
    public final int CN()
    {
      return this.bQJ.size();
    }
    
    public final int CO()
    {
      return this.bQL.size();
    }
    
    public final int CP()
    {
      return this.bQM.size();
    }
    
    public final k.s CQ()
    {
      if (this.bQN == null) {
        return k.s.DN();
      }
      return this.bQN;
    }
    
    public final boolean CR()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final k.ai CS()
    {
      if (this.bQO == null) {
        return k.ai.EK();
      }
      return this.bQO;
    }
    
    public final boolean CT()
    {
      return (this.bOT & 0x10) != 0;
    }
    
    public final String CU()
    {
      Object localObject = this.bQP;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bQP = str;
      }
      return str;
    }
    
    public final void a(i parami)
    {
      int k = 0;
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      if ((this.bOT & 0x2) != 0) {
        ac.a(parami, 2, this.bQH);
      }
      int i = 0;
      while (i < this.bQI.size())
      {
        ac.a(parami, 3, this.bQI.getRaw(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQL.size())
      {
        parami.a(4, (aw)this.bQL.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bOY.size())
      {
        parami.a(5, (aw)this.bOY.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQM.size())
      {
        parami.a(6, (aw)this.bQM.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bOW.size())
      {
        parami.a(7, (aw)this.bOW.get(i));
        i += 1;
      }
      if ((this.bOT & 0x4) != 0) {
        parami.a(8, CQ());
      }
      if ((this.bOT & 0x8) != 0) {
        parami.a(9, CS());
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.bQJ.size()) {
          break;
        }
        parami.bs(10, this.bQJ.getInt(i));
        i += 1;
      }
      while (j < this.bQK.size())
      {
        parami.bs(11, this.bQK.getInt(j));
        j += 1;
      }
      if ((this.bOT & 0x10) != 0) {
        ac.a(parami, 12, this.bQP);
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof q)) {
          return super.equals(paramObject);
        }
        paramObject = (q)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (CL() != paramObject.CL()) {
          return false;
        }
        if ((CL()) && (!getPackage().equals(paramObject.getPackage()))) {
          return false;
        }
        if (!this.bQI.equals(paramObject.bQI)) {
          return false;
        }
        if (!this.bQJ.equals(paramObject.bQJ)) {
          return false;
        }
        if (!this.bQK.equals(paramObject.bQK)) {
          return false;
        }
        if (!this.bQL.equals(paramObject.bQL)) {
          return false;
        }
        if (!this.bOY.equals(paramObject.bOY)) {
          return false;
        }
        if (!this.bQM.equals(paramObject.bQM)) {
          return false;
        }
        if (!this.bOW.equals(paramObject.bOW)) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!CQ().equals(paramObject.CQ()))) {
          return false;
        }
        if (CR() != paramObject.CR()) {
          return false;
        }
        if ((CR()) && (!CS().equals(paramObject.CS()))) {
          return false;
        }
        if (CT() != paramObject.CT()) {
          return false;
        }
        if ((CT()) && (!CU().equals(paramObject.CU()))) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final k.m gb(int paramInt)
    {
      return (k.m)this.bOW.get(paramInt);
    }
    
    public final k.c gd(int paramInt)
    {
      return (k.c)this.bOY.get(paramInt);
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final String getPackage()
    {
      Object localObject = this.bQH;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bQH = str;
      }
      return str;
    }
    
    public final k.a gt(int paramInt)
    {
      return (k.a)this.bQL.get(paramInt);
    }
    
    public final k.ae gu(int paramInt)
    {
      return (k.ae)this.bQM.get(paramInt);
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zB().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (CL()) {
        j = (i * 37 + 2) * 53 + getPackage().hashCode();
      }
      i = j;
      if (CM() > 0) {
        i = (j * 37 + 3) * 53 + this.bQI.hashCode();
      }
      j = i;
      if (CN() > 0) {
        j = (i * 37 + 10) * 53 + this.bQJ.hashCode();
      }
      i = j;
      if (this.bQK.size() > 0) {
        i = (j * 37 + 11) * 53 + this.bQK.hashCode();
      }
      j = i;
      if (CO() > 0) {
        j = (i * 37 + 4) * 53 + this.bQL.hashCode();
      }
      i = j;
      if (AC() > 0) {
        i = (j * 37 + 5) * 53 + this.bOY.hashCode();
      }
      j = i;
      if (CP() > 0) {
        j = (i * 37 + 6) * 53 + this.bQM.hashCode();
      }
      i = j;
      if (AA() > 0) {
        i = (j * 37 + 7) * 53 + this.bOW.hashCode();
      }
      j = i;
      if (AF()) {
        j = (i * 37 + 8) * 53 + CQ().hashCode();
      }
      i = j;
      if (CR()) {
        i = (j * 37 + 9) * 53 + CS().hashCode();
      }
      j = i;
      if (CT()) {
        j = (i * 37 + 12) * 53 + CU().hashCode();
      }
      i = j * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < CO())
      {
        if (!gt(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AC())
      {
        if (!gd(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < CP())
      {
        if (!gu(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < AA())
      {
        if (!gb(i).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if ((AF()) && (!CQ().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (i = ac.d(1, this.bOU) + 0;; i = 0)
      {
        int j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + ac.d(2, this.bQH);
        }
        int k = 0;
        i = 0;
        while (k < this.bQI.size())
        {
          i += ar(this.bQI.getRaw(k));
          k += 1;
        }
        int m = this.bQI.size();
        k = 0;
        i = j + i + m * 1;
        j = k;
        while (j < this.bQL.size())
        {
          i += i.c(4, (aw)this.bQL.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bOY.size())
        {
          i += i.c(5, (aw)this.bOY.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQM.size())
        {
          i += i.c(6, (aw)this.bQM.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bOW.size())
        {
          i += i.c(7, (aw)this.bOW.get(j));
          j += 1;
        }
        j = i;
        if ((this.bOT & 0x4) != 0) {
          j = i + i.c(8, CQ());
        }
        i = j;
        if ((this.bOT & 0x8) != 0) {
          i = j + i.c(9, CS());
        }
        k = 0;
        j = 0;
        while (k < this.bQJ.size())
        {
          j += i.fT(this.bQJ.getInt(k));
          k += 1;
        }
        int n = this.bQJ.size();
        k = 0;
        m = 0;
        while (k < this.bQK.size())
        {
          m += i.fT(this.bQK.getInt(k));
          k += 1;
        }
        j = i + j + n * 1 + m + this.bQK.size() * 1;
        i = j;
        if ((this.bOT & 0x10) != 0) {
          i = j + ac.d(12, this.bQP);
        }
        i += this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.a<a>
      implements k.r
    {
      private int bOT;
      private Object bOU = "";
      private List<k.m> bOW = Collections.emptyList();
      private List<k.c> bOY = Collections.emptyList();
      private bq<k.m, k.m.a, k.n> bPi;
      private bq<k.c, k.c.a, k.d> bPk;
      private bu<k.s, k.s.a, k.t> bPn;
      private Object bQH = "";
      private ak bQI = aj.bXM;
      private ae.d bQJ = ac.Gv();
      private ae.d bQK = ac.Gv();
      private List<k.a> bQL = Collections.emptyList();
      private List<k.ae> bQM = Collections.emptyList();
      private k.s bQN;
      private k.ai bQO;
      private Object bQP = "";
      private bq<k.a, k.a.a, k.b> bQR;
      private bq<k.ae, k.ae.a, k.af> bQS;
      private bu<k.ai, k.ai.a, k.aj> bQT;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private a A(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private void AR()
      {
        if (ac.bVU)
        {
          De();
          Bc();
          Dg();
          AY();
          Bh();
          Dh();
        }
      }
      
      private void AX()
      {
        if ((this.bOT & 0x100) == 0)
        {
          this.bOW = new ArrayList(this.bOW);
          this.bOT |= 0x100;
        }
      }
      
      private bq<k.m, k.m.a, k.n> AY()
      {
        List localList;
        if (this.bPi == null)
        {
          localList = this.bOW;
          if ((this.bOT & 0x100) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.bPi = new bq(localList, bool, GA(), this.bWv);
          this.bOW = null;
          return this.bPi;
        }
      }
      
      private a B(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private void Bb()
      {
        if ((this.bOT & 0x40) == 0)
        {
          this.bOY = new ArrayList(this.bOY);
          this.bOT |= 0x40;
        }
      }
      
      private bq<k.c, k.c.a, k.d> Bc()
      {
        List localList;
        if (this.bPk == null)
        {
          localList = this.bOY;
          if ((this.bOT & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPk = new bq(localList, bool, GA(), this.bWv);
          this.bOY = null;
          return this.bPk;
        }
      }
      
      private bu<k.s, k.s.a, k.t> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(CQ(), GA(), this.bWv);
          this.bQN = null;
        }
        return this.bPn;
      }
      
      private a C(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private k.s CQ()
      {
        if (this.bPn == null)
        {
          if (this.bQN == null) {
            return k.s.DN();
          }
          return this.bQN;
        }
        return (k.s)this.bPn.Hu();
      }
      
      private k.ai CS()
      {
        if (this.bQT == null)
        {
          if (this.bQO == null) {
            return k.ai.EK();
          }
          return this.bQO;
        }
        return (k.ai)this.bQT.Hu();
      }
      
      private k.q CZ()
      {
        int i = 0;
        k.q localq = new k.q(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        k.q.a(localq, this.bOU);
        if ((k & 0x2) != 0) {
          i |= 0x2;
        }
        label277:
        label406:
        label543:
        label562:
        for (;;)
        {
          k.q.b(localq, this.bQH);
          if ((this.bOT & 0x4) != 0)
          {
            this.bQI = this.bQI.GR();
            this.bOT &= 0xFFFFFFFB;
          }
          k.q.a(localq, this.bQI);
          if ((this.bOT & 0x8) != 0)
          {
            this.bQJ.yK();
            this.bOT &= 0xFFFFFFF7;
          }
          k.q.a(localq, this.bQJ);
          if ((this.bOT & 0x10) != 0)
          {
            this.bQK.yK();
            this.bOT &= 0xFFFFFFEF;
          }
          k.q.b(localq, this.bQK);
          label328:
          label379:
          int j;
          if (this.bQR == null)
          {
            if ((this.bOT & 0x20) != 0)
            {
              this.bQL = Collections.unmodifiableList(this.bQL);
              this.bOT &= 0xFFFFFFDF;
            }
            k.q.a(localq, this.bQL);
            if (this.bPk != null) {
              break label495;
            }
            if ((this.bOT & 0x40) != 0)
            {
              this.bOY = Collections.unmodifiableList(this.bOY);
              this.bOT &= 0xFFFFFFBF;
            }
            k.q.b(localq, this.bOY);
            if (this.bQS != null) {
              break label511;
            }
            if ((this.bOT & 0x80) != 0)
            {
              this.bQM = Collections.unmodifiableList(this.bQM);
              this.bOT &= 0xFFFFFF7F;
            }
            k.q.c(localq, this.bQM);
            if (this.bPi != null) {
              break label527;
            }
            if ((this.bOT & 0x100) != 0)
            {
              this.bOW = Collections.unmodifiableList(this.bOW);
              this.bOT &= 0xFFFFFEFF;
            }
            k.q.d(localq, this.bOW);
            j = i;
            if ((k & 0x200) != 0)
            {
              if (this.bPn != null) {
                break label543;
              }
              k.q.a(localq, this.bQN);
              j = i | 0x4;
            }
            if ((k & 0x400) == 0) {
              break label581;
            }
            if (this.bQT != null) {
              break label562;
            }
            k.q.a(localq, this.bQO);
          }
          label435:
          label581:
          for (i = j | 0x8;; i = j)
          {
            j = i;
            if ((k & 0x800) != 0) {
              j = i | 0x10;
            }
            k.q.c(localq, this.bQP);
            k.q.a(localq, j);
            Gy();
            return localq;
            k.q.a(localq, this.bQR.build());
            break;
            label495:
            k.q.b(localq, this.bPk.build());
            break label277;
            label511:
            k.q.c(localq, this.bQS.build());
            break label328;
            k.q.d(localq, this.bPi.build());
            break label379;
            k.q.a(localq, (k.s)this.bPn.Hv());
            break label406;
            k.q.a(localq, (k.ai)this.bQT.Hv());
            break label435;
          }
        }
      }
      
      private a D(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private void Da()
      {
        if ((this.bOT & 0x4) == 0)
        {
          this.bQI = new aj(this.bQI);
          this.bOT |= 0x4;
        }
      }
      
      private void Db()
      {
        if ((this.bOT & 0x8) == 0)
        {
          this.bQJ = ac.a(this.bQJ);
          this.bOT |= 0x8;
        }
      }
      
      private void Dc()
      {
        if ((this.bOT & 0x10) == 0)
        {
          this.bQK = ac.a(this.bQK);
          this.bOT |= 0x10;
        }
      }
      
      private void Dd()
      {
        if ((this.bOT & 0x20) == 0)
        {
          this.bQL = new ArrayList(this.bQL);
          this.bOT |= 0x20;
        }
      }
      
      private bq<k.a, k.a.a, k.b> De()
      {
        List localList;
        if (this.bQR == null)
        {
          localList = this.bQL;
          if ((this.bOT & 0x20) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bQR = new bq(localList, bool, GA(), this.bWv);
          this.bQL = null;
          return this.bQR;
        }
      }
      
      private void Df()
      {
        if ((this.bOT & 0x80) == 0)
        {
          this.bQM = new ArrayList(this.bQM);
          this.bOT |= 0x80;
        }
      }
      
      private bq<k.ae, k.ae.a, k.af> Dg()
      {
        List localList;
        if (this.bQS == null)
        {
          localList = this.bQM;
          if ((this.bOT & 0x80) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.bQS = new bq(localList, bool, GA(), this.bWv);
          this.bQM = null;
          return this.bQS;
        }
      }
      
      private bu<k.ai, k.ai.a, k.aj> Dh()
      {
        if (this.bQT == null)
        {
          this.bQT = new bu(CS(), GA(), this.bWv);
          this.bQO = null;
        }
        return this.bQT;
      }
      
      private a a(k.ai paramai)
      {
        if (this.bQT == null) {
          if (((this.bOT & 0x400) != 0) && (this.bQO != null) && (this.bQO != k.ai.EK()))
          {
            this.bQO = k.ai.b(this.bQO).d(paramai).EM();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x400;
          return this;
          this.bQO = paramai;
          break;
          this.bQT.b(paramai);
        }
      }
      
      private a a(k.s params)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x200) != 0) && (this.bQN != null) && (this.bQN != k.s.DN()))
          {
            this.bQN = k.s.b(this.bQN).n(params).DP();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x200;
          return this;
          this.bQN = params;
          break;
          this.bPn.b(params);
        }
      }
      
      private a o(at paramat)
      {
        if ((paramat instanceof k.q)) {
          return k((k.q)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a p(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 339	com/google/a/k$q:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 344 3 0
        //   12: checkcast 9	com/google/a/k$q
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 328	com/google/a/k$q$a:k	(Lcom/google/a/k$q;)Lcom/google/a/k$q$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 348	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$q
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 352	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 328	com/google/a/k$q$a:k	(Lcom/google/a/k$q;)Lcom/google/a/k$q$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.zB();
      }
      
      protected final ac.f Ay()
      {
        return k.zC().h(k.q.class, a.class);
      }
      
      public final k.q CY()
      {
        k.q localq = CZ();
        if (!localq.isInitialized()) {
          throw b(localq);
        }
        return localq;
      }
      
      public final a cg(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x1;
        this.bOU = paramString;
        onChanged();
        return this;
      }
      
      public final a ch(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x2;
        this.bQH = paramString;
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        Object localObject;
        if (this.bQR == null)
        {
          j = this.bQL.size();
          if (i >= j) {
            break label88;
          }
          if (this.bQR != null) {
            break label65;
          }
          localObject = (k.a)this.bQL.get(i);
          label45:
          if (((k.a)localObject).isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bQR.getCount();
          break label19;
          label65:
          localObject = (k.a)this.bQR.s(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          i = 0;
          if (this.bPk == null)
          {
            j = this.bOY.size();
            label107:
            if (i >= j) {
              break label174;
            }
            if (this.bPk != null) {
              break label158;
            }
          }
          label158:
          for (localObject = (k.c)this.bOY.get(i);; localObject = (k.c)this.bPk.s(i, false))
          {
            if (!((k.c)localObject).isInitialized()) {
              break label172;
            }
            i += 1;
            break;
            j = this.bPk.getCount();
            break label107;
          }
          label172:
          continue;
          label174:
          i = 0;
          if (this.bQS == null)
          {
            j = this.bQM.size();
            label193:
            if (i >= j) {
              break label260;
            }
            if (this.bQS != null) {
              break label244;
            }
          }
          label244:
          for (localObject = (k.ae)this.bQM.get(i);; localObject = (k.ae)this.bQS.s(i, false))
          {
            if (!((k.ae)localObject).isInitialized()) {
              break label258;
            }
            i += 1;
            break;
            j = this.bQS.getCount();
            break label193;
          }
          label258:
          continue;
          label260:
          i = 0;
          if (this.bPi == null)
          {
            j = this.bOW.size();
            label279:
            if (i >= j) {
              break label346;
            }
            if (this.bPi != null) {
              break label330;
            }
          }
          label330:
          for (localObject = (k.m)this.bOW.get(i);; localObject = (k.m)this.bPi.s(i, false))
          {
            if (!((k.m)localObject).isInitialized()) {
              break label344;
            }
            i += 1;
            break;
            j = this.bPi.getCount();
            break label279;
          }
          label344:
          continue;
          label346:
          if ((this.bOT & 0x200) != 0) {}
          for (i = 1; (i == 0) || (CQ().isInitialized()); i = 0) {
            return true;
          }
        }
      }
      
      public final a k(k.a parama)
      {
        if (this.bQR == null)
        {
          if (parama == null) {
            throw new NullPointerException();
          }
          Dd();
          this.bQL.add(parama);
          onChanged();
          return this;
        }
        this.bQR.a(parama);
        return this;
      }
      
      public final a k(k.q paramq)
      {
        Object localObject2 = null;
        if (paramq == k.q.CX()) {
          return this;
        }
        if (paramq.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.q.a(paramq);
          onChanged();
        }
        if (paramq.CL())
        {
          this.bOT |= 0x2;
          this.bQH = k.q.b(paramq);
          onChanged();
        }
        if (!k.q.c(paramq).isEmpty())
        {
          if (this.bQI.isEmpty())
          {
            this.bQI = k.q.c(paramq);
            this.bOT &= 0xFFFFFFFB;
            onChanged();
          }
        }
        else
        {
          if (!k.q.d(paramq).isEmpty())
          {
            if (!this.bQJ.isEmpty()) {
              break label527;
            }
            this.bQJ = k.q.d(paramq);
            this.bOT &= 0xFFFFFFF7;
            label159:
            onChanged();
          }
          if (!k.q.e(paramq).isEmpty())
          {
            if (!this.bQK.isEmpty()) {
              break label548;
            }
            this.bQK = k.q.e(paramq);
            this.bOT &= 0xFFFFFFEF;
            label206:
            onChanged();
          }
          if (this.bQR != null) {
            break label590;
          }
          if (!k.q.f(paramq).isEmpty())
          {
            if (!this.bQL.isEmpty()) {
              break label569;
            }
            this.bQL = k.q.f(paramq);
            this.bOT &= 0xFFFFFFDF;
            label260:
            onChanged();
          }
          label264:
          if (this.bPk != null) {
            break label704;
          }
          if (!k.q.g(paramq).isEmpty())
          {
            if (!this.bOY.isEmpty()) {
              break label683;
            }
            this.bOY = k.q.g(paramq);
            this.bOT &= 0xFFFFFFBF;
            label314:
            onChanged();
          }
          label318:
          if (this.bQS != null) {
            break label818;
          }
          if (!k.q.h(paramq).isEmpty())
          {
            if (!this.bQM.isEmpty()) {
              break label797;
            }
            this.bQM = k.q.h(paramq);
            this.bOT &= 0xFFFFFF7F;
            label369:
            onChanged();
          }
          label373:
          if (this.bPi != null) {
            break label933;
          }
          if (!k.q.i(paramq).isEmpty())
          {
            if (!this.bOW.isEmpty()) {
              break label912;
            }
            this.bOW = k.q.i(paramq);
            this.bOT &= 0xFFFFFEFF;
            label424:
            onChanged();
          }
        }
        for (;;)
        {
          if (paramq.AF()) {
            a(paramq.CQ());
          }
          if (paramq.CR()) {
            a(paramq.CS());
          }
          if (paramq.CT())
          {
            this.bOT |= 0x800;
            this.bQP = k.q.j(paramq);
            onChanged();
          }
          B(paramq.bTW);
          onChanged();
          return this;
          Da();
          this.bQI.addAll(k.q.c(paramq));
          break;
          label527:
          Db();
          this.bQJ.addAll(k.q.d(paramq));
          break label159;
          label548:
          Dc();
          this.bQK.addAll(k.q.e(paramq));
          break label206;
          label569:
          Dd();
          this.bQL.addAll(k.q.f(paramq));
          break label260;
          label590:
          if (k.q.f(paramq).isEmpty()) {
            break label264;
          }
          Object localObject1;
          if (this.bQR.isEmpty())
          {
            this.bQR.bYP = null;
            this.bQR = null;
            this.bQL = k.q.f(paramq);
            this.bOT &= 0xFFFFFFDF;
            if (ac.bVU) {}
            for (localObject1 = De();; localObject1 = null)
            {
              this.bQR = ((bq)localObject1);
              break;
            }
          }
          this.bQR.a(k.q.f(paramq));
          break label264;
          label683:
          Bb();
          this.bOY.addAll(k.q.g(paramq));
          break label314;
          label704:
          if (k.q.g(paramq).isEmpty()) {
            break label318;
          }
          if (this.bPk.isEmpty())
          {
            this.bPk.bYP = null;
            this.bPk = null;
            this.bOY = k.q.g(paramq);
            this.bOT &= 0xFFFFFFBF;
            if (ac.bVU) {}
            for (localObject1 = Bc();; localObject1 = null)
            {
              this.bPk = ((bq)localObject1);
              break;
            }
          }
          this.bPk.a(k.q.g(paramq));
          break label318;
          label797:
          Df();
          this.bQM.addAll(k.q.h(paramq));
          break label369;
          label818:
          if (k.q.h(paramq).isEmpty()) {
            break label373;
          }
          if (this.bQS.isEmpty())
          {
            this.bQS.bYP = null;
            this.bQS = null;
            this.bQM = k.q.h(paramq);
            this.bOT &= 0xFFFFFF7F;
            if (ac.bVU) {}
            for (localObject1 = Dg();; localObject1 = null)
            {
              this.bQS = ((bq)localObject1);
              break;
            }
          }
          this.bQS.a(k.q.h(paramq));
          break label373;
          label912:
          AX();
          this.bOW.addAll(k.q.i(paramq));
          break label424;
          label933:
          if (!k.q.i(paramq).isEmpty()) {
            if (this.bPi.isEmpty())
            {
              this.bPi.bYP = null;
              this.bPi = null;
              this.bOW = k.q.i(paramq);
              this.bOT &= 0xFFFFFEFF;
              localObject1 = localObject2;
              if (ac.bVU) {
                localObject1 = AY();
              }
              this.bPi = ((bq)localObject1);
            }
            else
            {
              this.bPi.a(k.q.i(paramq));
            }
          }
        }
      }
    }
  }
  
  public static abstract interface r
    extends az
  {}
  
  public static final class s
    extends ac.d<s>
    implements k.t
  {
    @Deprecated
    public static final bj<s> bPg = new c() {};
    private static final s bRn = new s();
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    private volatile Object bQU;
    private volatile Object bQV;
    boolean bQW;
    boolean bQX;
    boolean bQY;
    private int bQZ;
    private volatile Object bRa;
    boolean bRb;
    boolean bRc;
    boolean bRd;
    boolean bRe;
    boolean bRf;
    private volatile Object bRg;
    private volatile Object bRh;
    private volatile Object bRi;
    private volatile Object bRj;
    private volatile Object bRk;
    private volatile Object bRl;
    private volatile Object bRm;
    
    private s()
    {
      this.bQU = "";
      this.bQV = "";
      this.bQZ = 1;
      this.bRa = "";
      this.bRg = "";
      this.bRh = "";
      this.bRi = "";
      this.bRj = "";
      this.bRk = "";
      this.bRl = "";
      this.bRm = "";
      this.bPB = Collections.emptyList();
    }
    
    private s(ac.c<s, ?> paramc)
    {
      super();
    }
    
    private s(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 10: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              localg = paramh.zb();
              n = i;
              i1 = i;
              k = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bQU = localg;
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x100000) != 0) {
                this.bPB = Collections.unmodifiableList(this.bPB);
              }
              this.bTW = locala.HM();
              this.bWd.yK();
            }
            n = i;
            i1 = i;
            k = i;
            localg = paramh.zb();
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bQV = localg;
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            j = paramh.zd();
            n = i;
            i1 = i;
            k = i;
            if (b.gv(j) == null)
            {
              n = i;
              i1 = i;
              k = i;
              locala.bx(9, j);
              break;
            }
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x20;
            n = i;
            i1 = i;
            k = i;
            this.bQZ = j;
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.bQW = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          g localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x40;
          n = i;
          i1 = i;
          k = i;
          this.bRa = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x80;
          n = i;
          i1 = i;
          k = i;
          this.bRb = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x100;
          n = i;
          i1 = i;
          k = i;
          this.bRc = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x200;
          n = i;
          i1 = i;
          k = i;
          this.bRd = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.bQX = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x800;
          n = i;
          i1 = i;
          k = i;
          this.bPA = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.bQY = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x1000;
          n = i;
          i1 = i;
          k = i;
          this.bRf = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x2000;
          n = i;
          i1 = i;
          k = i;
          this.bRg = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x4000;
          n = i;
          i1 = i;
          k = i;
          this.bRh = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x8000;
          n = i;
          i1 = i;
          k = i;
          this.bRi = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x10000;
          n = i;
          i1 = i;
          k = i;
          this.bRj = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x20000;
          n = i;
          i1 = i;
          k = i;
          this.bRk = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x400;
          n = i;
          i1 = i;
          k = i;
          this.bRe = paramh.yZ();
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x40000;
          n = i;
          i1 = i;
          k = i;
          this.bRl = localg;
          break;
          n = i;
          i1 = i;
          k = i;
          localg = paramh.zb();
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x80000;
          n = i;
          i1 = i;
          k = i;
          this.bRm = localg;
          break;
          int j = i;
          if ((i & 0x100000) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bPB = new ArrayList();
            j = i | 0x100000;
          }
          n = j;
          i1 = j;
          k = j;
          this.bPB.add(paramh.a(k.ak.bPg, paramr));
          i = j;
          break;
          if ((i & 0x100000) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    private String DB()
    {
      Object localObject = this.bRh;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRh = str;
      }
      return str;
    }
    
    private String DD()
    {
      Object localObject = this.bRi;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRi = str;
      }
      return str;
    }
    
    private String DF()
    {
      Object localObject = this.bRj;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRj = str;
      }
      return str;
    }
    
    private String DH()
    {
      Object localObject = this.bRk;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRk = str;
      }
      return str;
    }
    
    private String DJ()
    {
      Object localObject = this.bRl;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRl = str;
      }
      return str;
    }
    
    private String DL()
    {
      Object localObject = this.bRm;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRm = str;
      }
      return str;
    }
    
    public static s DN()
    {
      return bRn;
    }
    
    private String Dj()
    {
      Object localObject = this.bQU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bQU = str;
      }
      return str;
    }
    
    private String Dl()
    {
      Object localObject = this.bQV;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bQV = str;
      }
      return str;
    }
    
    private String Ds()
    {
      Object localObject = this.bRa;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRa = str;
      }
      return str;
    }
    
    private String Dz()
    {
      Object localObject = this.bRg;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRg = str;
      }
      return str;
    }
    
    public static a b(s params)
    {
      return bRn.DM().n(params);
    }
    
    public final bj<s> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Aa().h(s.class, a.class);
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x800) != 0;
    }
    
    public final boolean DA()
    {
      return (this.bOT & 0x4000) != 0;
    }
    
    public final boolean DC()
    {
      return (this.bOT & 0x8000) != 0;
    }
    
    public final boolean DE()
    {
      return (this.bOT & 0x10000) != 0;
    }
    
    public final boolean DG()
    {
      return (this.bOT & 0x20000) != 0;
    }
    
    public final boolean DI()
    {
      return (this.bOT & 0x40000) != 0;
    }
    
    public final boolean DK()
    {
      return (this.bOT & 0x80000) != 0;
    }
    
    public final a DM()
    {
      if (this == bRn) {
        return new a((byte)0);
      }
      return new a((byte)0).n(this);
    }
    
    public final boolean Di()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean Dk()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final boolean Dm()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    @Deprecated
    public final boolean Dn()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final boolean Do()
    {
      return (this.bOT & 0x10) != 0;
    }
    
    public final boolean Dp()
    {
      return (this.bOT & 0x20) != 0;
    }
    
    public final b Dq()
    {
      b localb2 = b.gv(this.bQZ);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.bRo;
      }
      return localb1;
    }
    
    public final boolean Dr()
    {
      return (this.bOT & 0x40) != 0;
    }
    
    public final boolean Dt()
    {
      return (this.bOT & 0x80) != 0;
    }
    
    public final boolean Du()
    {
      return (this.bOT & 0x100) != 0;
    }
    
    public final boolean Dv()
    {
      return (this.bOT & 0x200) != 0;
    }
    
    public final boolean Dw()
    {
      return (this.bOT & 0x400) != 0;
    }
    
    public final boolean Dx()
    {
      return (this.bOT & 0x1000) != 0;
    }
    
    public final boolean Dy()
    {
      return (this.bOT & 0x2000) != 0;
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bQU);
      }
      if ((this.bOT & 0x2) != 0) {
        ac.a(parami, 8, this.bQV);
      }
      if ((this.bOT & 0x20) != 0) {
        parami.bs(9, this.bQZ);
      }
      if ((this.bOT & 0x4) != 0) {
        parami.r(10, this.bQW);
      }
      if ((this.bOT & 0x40) != 0) {
        ac.a(parami, 11, this.bRa);
      }
      if ((this.bOT & 0x80) != 0) {
        parami.r(16, this.bRb);
      }
      if ((this.bOT & 0x100) != 0) {
        parami.r(17, this.bRc);
      }
      if ((this.bOT & 0x200) != 0) {
        parami.r(18, this.bRd);
      }
      if ((this.bOT & 0x8) != 0) {
        parami.r(20, this.bQX);
      }
      if ((this.bOT & 0x800) != 0) {
        parami.r(23, this.bPA);
      }
      if ((this.bOT & 0x10) != 0) {
        parami.r(27, this.bQY);
      }
      if ((this.bOT & 0x1000) != 0) {
        parami.r(31, this.bRf);
      }
      if ((this.bOT & 0x2000) != 0) {
        ac.a(parami, 36, this.bRg);
      }
      if ((this.bOT & 0x4000) != 0) {
        ac.a(parami, 37, this.bRh);
      }
      if ((this.bOT & 0x8000) != 0) {
        ac.a(parami, 39, this.bRi);
      }
      if ((this.bOT & 0x10000) != 0) {
        ac.a(parami, 40, this.bRj);
      }
      if ((this.bOT & 0x20000) != 0) {
        ac.a(parami, 41, this.bRk);
      }
      if ((this.bOT & 0x400) != 0) {
        parami.r(42, this.bRe);
      }
      if ((this.bOT & 0x40000) != 0) {
        ac.a(parami, 44, this.bRl);
      }
      if ((this.bOT & 0x80000) != 0) {
        ac.a(parami, 45, this.bRm);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof s)) {
          return super.equals(paramObject);
        }
        paramObject = (s)paramObject;
        if (Di() != paramObject.Di()) {
          return false;
        }
        if ((Di()) && (!Dj().equals(paramObject.Dj()))) {
          return false;
        }
        if (Dk() != paramObject.Dk()) {
          return false;
        }
        if ((Dk()) && (!Dl().equals(paramObject.Dl()))) {
          return false;
        }
        if (Dm() != paramObject.Dm()) {
          return false;
        }
        if ((Dm()) && (this.bQW != paramObject.bQW)) {
          return false;
        }
        if (Dn() != paramObject.Dn()) {
          return false;
        }
        if ((Dn()) && (this.bQX != paramObject.bQX)) {
          return false;
        }
        if (Do() != paramObject.Do()) {
          return false;
        }
        if ((Do()) && (this.bQY != paramObject.bQY)) {
          return false;
        }
        if (Dp() != paramObject.Dp()) {
          return false;
        }
        if ((Dp()) && (this.bQZ != paramObject.bQZ)) {
          return false;
        }
        if (Dr() != paramObject.Dr()) {
          return false;
        }
        if ((Dr()) && (!Ds().equals(paramObject.Ds()))) {
          return false;
        }
        if (Dt() != paramObject.Dt()) {
          return false;
        }
        if ((Dt()) && (this.bRb != paramObject.bRb)) {
          return false;
        }
        if (Du() != paramObject.Du()) {
          return false;
        }
        if ((Du()) && (this.bRc != paramObject.bRc)) {
          return false;
        }
        if (Dv() != paramObject.Dv()) {
          return false;
        }
        if ((Dv()) && (this.bRd != paramObject.bRd)) {
          return false;
        }
        if (Dw() != paramObject.Dw()) {
          return false;
        }
        if ((Dw()) && (this.bRe != paramObject.bRe)) {
          return false;
        }
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (Dx() != paramObject.Dx()) {
          return false;
        }
        if ((Dx()) && (this.bRf != paramObject.bRf)) {
          return false;
        }
        if (Dy() != paramObject.Dy()) {
          return false;
        }
        if ((Dy()) && (!Dz().equals(paramObject.Dz()))) {
          return false;
        }
        if (DA() != paramObject.DA()) {
          return false;
        }
        if ((DA()) && (!DB().equals(paramObject.DB()))) {
          return false;
        }
        if (DC() != paramObject.DC()) {
          return false;
        }
        if ((DC()) && (!DD().equals(paramObject.DD()))) {
          return false;
        }
        if (DE() != paramObject.DE()) {
          return false;
        }
        if ((DE()) && (!DF().equals(paramObject.DF()))) {
          return false;
        }
        if (DG() != paramObject.DG()) {
          return false;
        }
        if ((DG()) && (!DH().equals(paramObject.DH()))) {
          return false;
        }
        if (DI() != paramObject.DI()) {
          return false;
        }
        if ((DI()) && (!DJ().equals(paramObject.DJ()))) {
          return false;
        }
        if (DK() != paramObject.DK()) {
          return false;
        }
        if ((DK()) && (!DL().equals(paramObject.DL()))) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zZ().hashCode() + 779;
      int i = j;
      if (Di()) {
        i = (j * 37 + 1) * 53 + Dj().hashCode();
      }
      j = i;
      if (Dk()) {
        j = (i * 37 + 8) * 53 + Dl().hashCode();
      }
      i = j;
      if (Dm()) {
        i = (j * 37 + 10) * 53 + ae.bF(this.bQW);
      }
      j = i;
      if (Dn()) {
        j = (i * 37 + 20) * 53 + ae.bF(this.bQX);
      }
      i = j;
      if (Do()) {
        i = (j * 37 + 27) * 53 + ae.bF(this.bQY);
      }
      j = i;
      if (Dp()) {
        j = (i * 37 + 9) * 53 + this.bQZ;
      }
      i = j;
      if (Dr()) {
        i = (j * 37 + 11) * 53 + Ds().hashCode();
      }
      j = i;
      if (Dt()) {
        j = (i * 37 + 16) * 53 + ae.bF(this.bRb);
      }
      i = j;
      if (Du()) {
        i = (j * 37 + 17) * 53 + ae.bF(this.bRc);
      }
      j = i;
      if (Dv()) {
        j = (i * 37 + 18) * 53 + ae.bF(this.bRd);
      }
      i = j;
      if (Dw()) {
        i = (j * 37 + 42) * 53 + ae.bF(this.bRe);
      }
      j = i;
      if (BN()) {
        j = (i * 37 + 23) * 53 + ae.bF(this.bPA);
      }
      i = j;
      if (Dx()) {
        i = (j * 37 + 31) * 53 + ae.bF(this.bRf);
      }
      j = i;
      if (Dy()) {
        j = (i * 37 + 36) * 53 + Dz().hashCode();
      }
      i = j;
      if (DA()) {
        i = (j * 37 + 37) * 53 + DB().hashCode();
      }
      j = i;
      if (DC()) {
        j = (i * 37 + 39) * 53 + DD().hashCode();
      }
      i = j;
      if (DE()) {
        i = (j * 37 + 40) * 53 + DF().hashCode();
      }
      j = i;
      if (DG()) {
        j = (i * 37 + 41) * 53 + DH().hashCode();
      }
      i = j;
      if (DI()) {
        i = (j * 37 + 44) * 53 + DJ().hashCode();
      }
      j = i;
      if (DK()) {
        j = (i * 37 + 45) * 53 + DL().hashCode();
      }
      i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int k = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (int j = ac.d(1, this.bQU) + 0;; j = 0)
      {
        i = j;
        if ((this.bOT & 0x2) != 0) {
          i = j + ac.d(8, this.bQV);
        }
        j = i;
        if ((this.bOT & 0x20) != 0) {
          j = i + i.bv(9, this.bQZ);
        }
        i = j;
        if ((this.bOT & 0x4) != 0) {
          i = j + i.fR(10);
        }
        j = i;
        if ((this.bOT & 0x40) != 0) {
          j = i + ac.d(11, this.bRa);
        }
        i = j;
        if ((this.bOT & 0x80) != 0) {
          i = j + i.fR(16);
        }
        j = i;
        if ((this.bOT & 0x100) != 0) {
          j = i + i.fR(17);
        }
        i = j;
        if ((this.bOT & 0x200) != 0) {
          i = j + i.fR(18);
        }
        j = i;
        if ((this.bOT & 0x8) != 0) {
          j = i + i.fR(20);
        }
        i = j;
        if ((this.bOT & 0x800) != 0) {
          i = j + i.fR(23);
        }
        j = i;
        if ((this.bOT & 0x10) != 0) {
          j = i + i.fR(27);
        }
        i = j;
        if ((this.bOT & 0x1000) != 0) {
          i = j + i.fR(31);
        }
        j = i;
        if ((this.bOT & 0x2000) != 0) {
          j = i + ac.d(36, this.bRg);
        }
        i = j;
        if ((this.bOT & 0x4000) != 0) {
          i = j + ac.d(37, this.bRh);
        }
        j = i;
        if ((this.bOT & 0x8000) != 0) {
          j = i + ac.d(39, this.bRi);
        }
        i = j;
        if ((this.bOT & 0x10000) != 0) {
          i = j + ac.d(40, this.bRj);
        }
        j = i;
        if ((this.bOT & 0x20000) != 0) {
          j = i + ac.d(41, this.bRk);
        }
        i = j;
        if ((this.bOT & 0x400) != 0) {
          i = j + i.fR(42);
        }
        j = i;
        if ((this.bOT & 0x40000) != 0) {
          j = i + ac.d(44, this.bRl);
        }
        i = j;
        if ((this.bOT & 0x80000) != 0) {
          i = j + ac.d(45, this.bRm);
        }
        j = k;
        while (j < this.bPB.size())
        {
          k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        i = this.bWd.yC() + i + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.c<k.s, a>
      implements k.t
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      private Object bQU = "";
      private Object bQV = "";
      private boolean bQW;
      private boolean bQX;
      private boolean bQY;
      private int bQZ = 1;
      private Object bRa = "";
      private boolean bRb;
      private boolean bRc;
      private boolean bRd;
      private boolean bRe;
      private boolean bRf;
      private Object bRg = "";
      private Object bRh = "";
      private Object bRi = "";
      private Object bRj = "";
      private Object bRk = "";
      private Object bRl = "";
      private Object bRm = "";
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x100000) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x100000;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x100000) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private a C(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a D(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private k.s DO()
      {
        k.s locals = DP();
        if (!locals.isInitialized()) {
          throw b(locals);
        }
        return locals;
      }
      
      private a E(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a F(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a a(k.s.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x20;
        this.bQZ = paramb.value;
        onChanged();
        return this;
      }
      
      private a bm(boolean paramBoolean)
      {
        this.bOT |= 0x4;
        this.bQW = paramBoolean;
        onChanged();
        return this;
      }
      
      @Deprecated
      private a bn(boolean paramBoolean)
      {
        this.bOT |= 0x8;
        this.bQX = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bo(boolean paramBoolean)
      {
        this.bOT |= 0x10;
        this.bQY = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bp(boolean paramBoolean)
      {
        this.bOT |= 0x80;
        this.bRb = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bq(boolean paramBoolean)
      {
        this.bOT |= 0x100;
        this.bRc = paramBoolean;
        onChanged();
        return this;
      }
      
      private a br(boolean paramBoolean)
      {
        this.bOT |= 0x200;
        this.bRd = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bs(boolean paramBoolean)
      {
        this.bOT |= 0x400;
        this.bRe = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bt(boolean paramBoolean)
      {
        this.bOT |= 0x800;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bu(boolean paramBoolean)
      {
        this.bOT |= 0x1000;
        this.bRf = paramBoolean;
        onChanged();
        return this;
      }
      
      private a p(at paramat)
      {
        if ((paramat instanceof k.s)) {
          return n((k.s)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a q(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 217	com/google/a/k$s:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 222 3 0
        //   12: checkcast 9	com/google/a/k$s
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 207	com/google/a/k$s$a:n	(Lcom/google/a/k$s;)Lcom/google/a/k$s$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 226	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$s
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 230	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 207	com/google/a/k$s$a:n	(Lcom/google/a/k$s;)Lcom/google/a/k$s$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.zZ();
      }
      
      protected final ac.f Ay()
      {
        return k.Aa().h(k.s.class, a.class);
      }
      
      public final k.s DP()
      {
        int j = 0;
        k.s locals = new k.s(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        k.s.a(locals, this.bQU);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        k.s.b(locals, this.bQV);
        j = i;
        if ((k & 0x4) != 0)
        {
          k.s.a(locals, this.bQW);
          j = i | 0x4;
        }
        i = j;
        if ((k & 0x8) != 0)
        {
          k.s.b(locals, this.bQX);
          i = j | 0x8;
        }
        j = i;
        if ((k & 0x10) != 0)
        {
          k.s.c(locals, this.bQY);
          j = i | 0x10;
        }
        i = j;
        if ((k & 0x20) != 0) {
          i = j | 0x20;
        }
        k.s.a(locals, this.bQZ);
        j = i;
        if ((k & 0x40) != 0) {
          j = i | 0x40;
        }
        k.s.c(locals, this.bRa);
        i = j;
        if ((k & 0x80) != 0)
        {
          k.s.d(locals, this.bRb);
          i = j | 0x80;
        }
        j = i;
        if ((k & 0x100) != 0)
        {
          k.s.e(locals, this.bRc);
          j = i | 0x100;
        }
        i = j;
        if ((k & 0x200) != 0)
        {
          k.s.f(locals, this.bRd);
          i = j | 0x200;
        }
        j = i;
        if ((k & 0x400) != 0)
        {
          k.s.g(locals, this.bRe);
          j = i | 0x400;
        }
        i = j;
        if ((k & 0x800) != 0)
        {
          k.s.h(locals, this.bPA);
          i = j | 0x800;
        }
        j = i;
        if ((k & 0x1000) != 0)
        {
          k.s.i(locals, this.bRf);
          j = i | 0x1000;
        }
        i = j;
        if ((k & 0x2000) != 0) {
          i = j | 0x2000;
        }
        k.s.d(locals, this.bRg);
        j = i;
        if ((k & 0x4000) != 0) {
          j = i | 0x4000;
        }
        k.s.e(locals, this.bRh);
        i = j;
        if ((k & 0x8000) != 0) {
          i = j | 0x8000;
        }
        k.s.f(locals, this.bRi);
        j = i;
        if ((k & 0x10000) != 0) {
          j = i | 0x10000;
        }
        k.s.g(locals, this.bRj);
        i = j;
        if ((k & 0x20000) != 0) {
          i = j | 0x20000;
        }
        k.s.h(locals, this.bRk);
        j = i;
        if ((k & 0x40000) != 0) {
          j = i | 0x40000;
        }
        k.s.i(locals, this.bRl);
        i = j;
        if ((k & 0x80000) != 0) {
          i = j | 0x80000;
        }
        k.s.j(locals, this.bRm);
        if (this.bPD == null)
        {
          if ((this.bOT & 0x100000) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFEFFFFF;
          }
          k.s.a(locals, this.bPB);
        }
        for (;;)
        {
          k.s.b(locals, i);
          Gy();
          return locals;
          k.s.a(locals, this.bPD.build());
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
      
      public final a n(k.s params)
      {
        bq localbq = null;
        if (params == k.s.DN()) {
          return this;
        }
        if (params.Di())
        {
          this.bOT |= 0x1;
          this.bQU = k.s.c(params);
          onChanged();
        }
        if (params.Dk())
        {
          this.bOT |= 0x2;
          this.bQV = k.s.d(params);
          onChanged();
        }
        if (params.Dm()) {
          bm(params.bQW);
        }
        if (params.Dn()) {
          bn(params.bQX);
        }
        if (params.Do()) {
          bo(params.bQY);
        }
        if (params.Dp()) {
          a(params.Dq());
        }
        if (params.Dr())
        {
          this.bOT |= 0x40;
          this.bRa = k.s.e(params);
          onChanged();
        }
        if (params.Dt()) {
          bp(params.bRb);
        }
        if (params.Du()) {
          bq(params.bRc);
        }
        if (params.Dv()) {
          br(params.bRd);
        }
        if (params.Dw()) {
          bs(params.bRe);
        }
        if (params.BN()) {
          bt(params.bPA);
        }
        if (params.Dx()) {
          bu(params.bRf);
        }
        if (params.Dy())
        {
          this.bOT |= 0x2000;
          this.bRg = k.s.f(params);
          onChanged();
        }
        if (params.DA())
        {
          this.bOT |= 0x4000;
          this.bRh = k.s.g(params);
          onChanged();
        }
        if (params.DC())
        {
          this.bOT |= 0x8000;
          this.bRi = k.s.h(params);
          onChanged();
        }
        if (params.DE())
        {
          this.bOT |= 0x10000;
          this.bRj = k.s.i(params);
          onChanged();
        }
        if (params.DG())
        {
          this.bOT |= 0x20000;
          this.bRk = k.s.j(params);
          onChanged();
        }
        if (params.DI())
        {
          this.bOT |= 0x40000;
          this.bRl = k.s.k(params);
          onChanged();
        }
        if (params.DK())
        {
          this.bOT |= 0x80000;
          this.bRm = k.s.l(params);
          onChanged();
        }
        if (this.bPD == null) {
          if (!k.s.m(params).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label551;
            }
            this.bPB = k.s.m(params);
            this.bOT &= 0xFFEFFFFF;
            onChanged();
          }
        }
        for (;;)
        {
          a(params);
          D(params.bTW);
          onChanged();
          return this;
          label551:
          BT();
          this.bPB.addAll(k.s.m(params));
          break;
          if (!k.s.m(params).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.s.m(params);
              this.bOT &= 0xFFEFFFFF;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.s.m(params));
            }
          }
        }
      }
    }
    
    public static enum b
      implements bn
    {
      private static final ae.b<b> bPU = new ae.b() {};
      private static final b[] bRr = values();
      final int value;
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b gv(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return bRo;
        case 2: 
          return bRp;
        }
        return bRq;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static abstract interface t
    extends ac.e
  {}
  
  public static final class u
    extends ac.d<u>
    implements k.v
  {
    @Deprecated
    public static final bj<u> bPg = new c() {};
    private static final u bRw = new u();
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    boolean bRt;
    boolean bRu;
    boolean bRv;
    
    private u()
    {
      this.bPB = Collections.emptyList();
    }
    
    private u(ac.c<u, ?> paramc)
    {
      super();
    }
    
    private u(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bRt = paramh.yZ();
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x10) != 0) {
                this.bPB = Collections.unmodifiableList(this.bPB);
              }
              this.bTW = locala.HM();
              this.bWd.yK();
            }
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bRu = paramh.yZ();
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x4;
            n = i;
            i1 = i;
            k = i;
            this.bPA = paramh.yZ();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bOT |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.bRv = paramh.yZ();
          break;
          int j = i;
          if ((i & 0x10) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bPB = new ArrayList();
            j = i | 0x10;
          }
          n = j;
          i1 = j;
          k = j;
          this.bPB.add(paramh.a(k.ak.bPg, paramr));
          i = j;
          break;
          if ((i & 0x10) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static u DU()
    {
      return bRw;
    }
    
    public static a b(u paramu)
    {
      return bRw.DT().d(paramu);
    }
    
    public final bj<u> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Ac().h(u.class, a.class);
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final boolean DQ()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean DR()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final boolean DS()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final a DT()
    {
      if (this == bRw) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        parami.r(1, this.bRt);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.r(2, this.bRu);
      }
      if ((this.bOT & 0x4) != 0) {
        parami.r(3, this.bPA);
      }
      if ((this.bOT & 0x8) != 0) {
        parami.r(7, this.bRv);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof u)) {
          return super.equals(paramObject);
        }
        paramObject = (u)paramObject;
        if (DQ() != paramObject.DQ()) {
          return false;
        }
        if ((DQ()) && (this.bRt != paramObject.bRt)) {
          return false;
        }
        if (DR() != paramObject.DR()) {
          return false;
        }
        if ((DR()) && (this.bRu != paramObject.bRu)) {
          return false;
        }
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (DS() != paramObject.DS()) {
          return false;
        }
        if ((DS()) && (this.bRv != paramObject.bRv)) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.Ab().hashCode() + 779;
      int i = j;
      if (DQ()) {
        i = (j * 37 + 1) * 53 + ae.bF(this.bRt);
      }
      j = i;
      if (DR()) {
        j = (i * 37 + 2) * 53 + ae.bF(this.bRu);
      }
      i = j;
      if (BN()) {
        i = (j * 37 + 3) * 53 + ae.bF(this.bPA);
      }
      j = i;
      if (DS()) {
        j = (i * 37 + 7) * 53 + ae.bF(this.bRv);
      }
      i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int k = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (int j = i.fR(1) + 0;; j = 0)
      {
        i = j;
        if ((this.bOT & 0x2) != 0) {
          i = j + i.fR(2);
        }
        j = i;
        if ((this.bOT & 0x4) != 0) {
          j = i + i.fR(3);
        }
        i = j;
        if ((this.bOT & 0x8) != 0) {
          i = j + i.fR(7);
        }
        j = k;
        while (j < this.bPB.size())
        {
          k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        i = this.bWd.yC() + i + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.c<k.u, a>
      implements k.v
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      private boolean bRt;
      private boolean bRu;
      private boolean bRv;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x10) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x10;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x10) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.u DV()
      {
        k.u localu = DW();
        if (!localu.isInitialized()) {
          throw b(localu);
        }
        return localu;
      }
      
      private a E(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a F(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a G(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a H(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a bv(boolean paramBoolean)
      {
        this.bOT |= 0x1;
        this.bRt = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bw(boolean paramBoolean)
      {
        this.bOT |= 0x2;
        this.bRu = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bx(boolean paramBoolean)
      {
        this.bOT |= 0x4;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a by(boolean paramBoolean)
      {
        this.bOT |= 0x8;
        this.bRv = paramBoolean;
        onChanged();
        return this;
      }
      
      private a q(at paramat)
      {
        if ((paramat instanceof k.u)) {
          return d((k.u)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a r(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 147	com/google/a/k$u:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 152 3 0
        //   12: checkcast 9	com/google/a/k$u
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 137	com/google/a/k$u$a:d	(Lcom/google/a/k$u;)Lcom/google/a/k$u$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 156	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$u
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 160	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 137	com/google/a/k$u$a:d	(Lcom/google/a/k$u;)Lcom/google/a/k$u$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.Ab();
      }
      
      protected final ac.f Ay()
      {
        return k.Ac().h(k.u.class, a.class);
      }
      
      public final k.u DW()
      {
        int j = 0;
        k.u localu = new k.u(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0)
        {
          k.u.a(localu, this.bRt);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0)
        {
          k.u.b(localu, this.bRu);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0)
        {
          k.u.c(localu, this.bPA);
          j = i | 0x4;
        }
        i = j;
        if ((k & 0x8) != 0)
        {
          k.u.d(localu, this.bRv);
          i = j | 0x8;
        }
        if (this.bPD == null)
        {
          if ((this.bOT & 0x10) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFEF;
          }
          k.u.a(localu, this.bPB);
        }
        for (;;)
        {
          k.u.a(localu, i);
          Gy();
          return localu;
          k.u.a(localu, this.bPD.build());
        }
      }
      
      public final a d(k.u paramu)
      {
        bq localbq = null;
        if (paramu == k.u.DU()) {
          return this;
        }
        if (paramu.DQ()) {
          bv(paramu.bRt);
        }
        if (paramu.DR()) {
          bw(paramu.bRu);
        }
        if (paramu.BN()) {
          bx(paramu.bPA);
        }
        if (paramu.DS()) {
          by(paramu.bRv);
        }
        if (this.bPD == null) {
          if (!k.u.c(paramu).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label149;
            }
            this.bPB = k.u.c(paramu);
            this.bOT &= 0xFFFFFFEF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramu);
          F(paramu.bTW);
          onChanged();
          return this;
          label149:
          BT();
          this.bPB.addAll(k.u.c(paramu));
          break;
          if (!k.u.c(paramu).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.u.c(paramu);
              this.bOT &= 0xFFFFFFEF;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.u.c(paramu));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static abstract interface v
    extends ac.e
  {}
  
  public static final class w
    extends ac
    implements k.x
  {
    @Deprecated
    public static final bj<w> bPg = new c() {};
    private static final w bRC = new w();
    private int bOT;
    private volatile Object bOU;
    private byte bPe = -1;
    boolean bRA;
    boolean bRB;
    private volatile Object bRx;
    private volatile Object bRy;
    private k.y bRz;
    
    private w()
    {
      this.bOU = "";
      this.bRx = "";
      this.bRy = "";
    }
    
    private w(ac.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private w(h paramh, r paramr)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 38	com/google/a/k$w:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 69	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 70	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 76	com/google/a/cc:HJ	()Lcom/google/a/cc$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +326 -> 350
      //   27: aload_1
      //   28: invokevirtual 82	com/google/a/h:yT	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+338->373, 0:+344->379, 10:+83->118, 18:+132->167, 26:+174->209, 34:+199->234, 40:+271->306, 48:+293->328
      //   101: aload_1
      //   102: aload 6
      //   104: aload_2
      //   105: iload 4
      //   107: invokevirtual 85	com/google/a/k$w:a	(Lcom/google/a/h;Lcom/google/a/cc$a;Lcom/google/a/r;I)Z
      //   110: ifne +254 -> 364
      //   113: iconst_1
      //   114: istore_3
      //   115: goto +261 -> 376
      //   118: aload_1
      //   119: invokevirtual 89	com/google/a/h:zb	()Lcom/google/a/g;
      //   122: astore 5
      //   124: aload_0
      //   125: aload_0
      //   126: getfield 91	com/google/a/k$w:bOT	I
      //   129: iconst_1
      //   130: ior
      //   131: putfield 91	com/google/a/k$w:bOT	I
      //   134: aload_0
      //   135: aload 5
      //   137: putfield 51	com/google/a/k$w:bOU	Ljava/lang/Object;
      //   140: goto -117 -> 23
      //   143: astore_1
      //   144: aload_1
      //   145: aload_0
      //   146: putfield 95	com/google/a/af:bXr	Lcom/google/a/aw;
      //   149: aload_1
      //   150: athrow
      //   151: astore_1
      //   152: aload_0
      //   153: aload 6
      //   155: invokevirtual 101	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   158: putfield 105	com/google/a/k$w:bTW	Lcom/google/a/cc;
      //   161: aload_0
      //   162: invokevirtual 108	com/google/a/k$w:Gw	()V
      //   165: aload_1
      //   166: athrow
      //   167: aload_1
      //   168: invokevirtual 89	com/google/a/h:zb	()Lcom/google/a/g;
      //   171: astore 5
      //   173: aload_0
      //   174: aload_0
      //   175: getfield 91	com/google/a/k$w:bOT	I
      //   178: iconst_2
      //   179: ior
      //   180: putfield 91	com/google/a/k$w:bOT	I
      //   183: aload_0
      //   184: aload 5
      //   186: putfield 53	com/google/a/k$w:bRx	Ljava/lang/Object;
      //   189: goto -166 -> 23
      //   192: astore_1
      //   193: new 65	com/google/a/af
      //   196: dup
      //   197: aload_1
      //   198: invokespecial 111	com/google/a/af:<init>	(Ljava/io/IOException;)V
      //   201: astore_1
      //   202: aload_1
      //   203: aload_0
      //   204: putfield 95	com/google/a/af:bXr	Lcom/google/a/aw;
      //   207: aload_1
      //   208: athrow
      //   209: aload_1
      //   210: invokevirtual 89	com/google/a/h:zb	()Lcom/google/a/g;
      //   213: astore 5
      //   215: aload_0
      //   216: aload_0
      //   217: getfield 91	com/google/a/k$w:bOT	I
      //   220: iconst_4
      //   221: ior
      //   222: putfield 91	com/google/a/k$w:bOT	I
      //   225: aload_0
      //   226: aload 5
      //   228: putfield 55	com/google/a/k$w:bRy	Ljava/lang/Object;
      //   231: goto -208 -> 23
      //   234: aload_0
      //   235: getfield 91	com/google/a/k$w:bOT	I
      //   238: bipush 8
      //   240: iand
      //   241: ifeq +126 -> 367
      //   244: aload_0
      //   245: getfield 113	com/google/a/k$w:bRz	Lcom/google/a/k$y;
      //   248: invokevirtual 119	com/google/a/k$y:Ek	()Lcom/google/a/k$y$a;
      //   251: astore 5
      //   253: aload_0
      //   254: aload_1
      //   255: getstatic 120	com/google/a/k$y:bPg	Lcom/google/a/bj;
      //   258: aload_2
      //   259: invokevirtual 123	com/google/a/h:a	(Lcom/google/a/bj;Lcom/google/a/r;)Lcom/google/a/aw;
      //   262: checkcast 115	com/google/a/k$y
      //   265: putfield 113	com/google/a/k$w:bRz	Lcom/google/a/k$y;
      //   268: aload 5
      //   270: ifnull +22 -> 292
      //   273: aload 5
      //   275: aload_0
      //   276: getfield 113	com/google/a/k$w:bRz	Lcom/google/a/k$y;
      //   279: invokevirtual 129	com/google/a/k$y$a:d	(Lcom/google/a/k$y;)Lcom/google/a/k$y$a;
      //   282: pop
      //   283: aload_0
      //   284: aload 5
      //   286: invokevirtual 133	com/google/a/k$y$a:En	()Lcom/google/a/k$y;
      //   289: putfield 113	com/google/a/k$w:bRz	Lcom/google/a/k$y;
      //   292: aload_0
      //   293: aload_0
      //   294: getfield 91	com/google/a/k$w:bOT	I
      //   297: bipush 8
      //   299: ior
      //   300: putfield 91	com/google/a/k$w:bOT	I
      //   303: goto -280 -> 23
      //   306: aload_0
      //   307: aload_0
      //   308: getfield 91	com/google/a/k$w:bOT	I
      //   311: bipush 16
      //   313: ior
      //   314: putfield 91	com/google/a/k$w:bOT	I
      //   317: aload_0
      //   318: aload_1
      //   319: invokevirtual 137	com/google/a/h:yZ	()Z
      //   322: putfield 139	com/google/a/k$w:bRA	Z
      //   325: goto -302 -> 23
      //   328: aload_0
      //   329: aload_0
      //   330: getfield 91	com/google/a/k$w:bOT	I
      //   333: bipush 32
      //   335: ior
      //   336: putfield 91	com/google/a/k$w:bOT	I
      //   339: aload_0
      //   340: aload_1
      //   341: invokevirtual 137	com/google/a/h:yZ	()Z
      //   344: putfield 141	com/google/a/k$w:bRB	Z
      //   347: goto -324 -> 23
      //   350: aload_0
      //   351: aload 6
      //   353: invokevirtual 101	com/google/a/cc$a:HM	()Lcom/google/a/cc;
      //   356: putfield 105	com/google/a/k$w:bTW	Lcom/google/a/cc;
      //   359: aload_0
      //   360: invokevirtual 108	com/google/a/k$w:Gw	()V
      //   363: return
      //   364: goto +12 -> 376
      //   367: aconst_null
      //   368: astore 5
      //   370: goto -117 -> 253
      //   373: goto -273 -> 100
      //   376: goto -353 -> 23
      //   379: iconst_1
      //   380: istore_3
      //   381: goto -358 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	384	0	this	w
      //   0	384	1	paramh	h
      //   0	384	2	paramr	r
      //   22	359	3	i	int
      //   31	75	4	j	int
      //   122	247	5	localObject	Object
      //   19	333	6	locala	cc.a
      // Exception table:
      //   from	to	target	type
      //   27	33	143	com/google/a/af
      //   100	113	143	com/google/a/af
      //   118	140	143	com/google/a/af
      //   167	189	143	com/google/a/af
      //   209	231	143	com/google/a/af
      //   234	253	143	com/google/a/af
      //   253	268	143	com/google/a/af
      //   273	292	143	com/google/a/af
      //   292	303	143	com/google/a/af
      //   306	325	143	com/google/a/af
      //   328	347	143	com/google/a/af
      //   27	33	151	finally
      //   100	113	151	finally
      //   118	140	151	finally
      //   144	151	151	finally
      //   167	189	151	finally
      //   193	209	151	finally
      //   209	231	151	finally
      //   234	253	151	finally
      //   253	268	151	finally
      //   273	292	151	finally
      //   292	303	151	finally
      //   306	325	151	finally
      //   328	347	151	finally
      //   27	33	192	java/io/IOException
      //   100	113	192	java/io/IOException
      //   118	140	192	java/io/IOException
      //   167	189	192	java/io/IOException
      //   209	231	192	java/io/IOException
      //   234	253	192	java/io/IOException
      //   253	268	192	java/io/IOException
      //   273	292	192	java/io/IOException
      //   292	303	192	java/io/IOException
      //   306	325	192	java/io/IOException
      //   328	347	192	java/io/IOException
    }
    
    private a Ee()
    {
      if (this == bRC) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public static w Ef()
    {
      return bRC;
    }
    
    public final boolean AF()
    {
      return (this.bOT & 0x8) != 0;
    }
    
    public final bj<w> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.zY().h(w.class, a.class);
    }
    
    public final boolean Az()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean DX()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final String DY()
    {
      Object localObject = this.bRx;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRx = str;
      }
      return str;
    }
    
    public final boolean DZ()
    {
      return (this.bOT & 0x4) != 0;
    }
    
    public final String Ea()
    {
      Object localObject = this.bRy;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bRy = str;
      }
      return str;
    }
    
    public final k.y Eb()
    {
      if (this.bRz == null) {
        return k.y.El();
      }
      return this.bRz;
    }
    
    public final boolean Ec()
    {
      return (this.bOT & 0x10) != 0;
    }
    
    public final boolean Ed()
    {
      return (this.bOT & 0x20) != 0;
    }
    
    public final void a(i parami)
    {
      if ((this.bOT & 0x1) != 0) {
        ac.a(parami, 1, this.bOU);
      }
      if ((this.bOT & 0x2) != 0) {
        ac.a(parami, 2, this.bRx);
      }
      if ((this.bOT & 0x4) != 0) {
        ac.a(parami, 3, this.bRy);
      }
      if ((this.bOT & 0x8) != 0) {
        parami.a(4, Eb());
      }
      if ((this.bOT & 0x10) != 0) {
        parami.r(5, this.bRA);
      }
      if ((this.bOT & 0x20) != 0) {
        parami.r(6, this.bRB);
      }
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof w)) {
          return super.equals(paramObject);
        }
        paramObject = (w)paramObject;
        if (Az() != paramObject.Az()) {
          return false;
        }
        if ((Az()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (DX() != paramObject.DX()) {
          return false;
        }
        if ((DX()) && (!DY().equals(paramObject.DY()))) {
          return false;
        }
        if (DZ() != paramObject.DZ()) {
          return false;
        }
        if ((DZ()) && (!Ea().equals(paramObject.Ea()))) {
          return false;
        }
        if (AF() != paramObject.AF()) {
          return false;
        }
        if ((AF()) && (!Eb().equals(paramObject.Eb()))) {
          return false;
        }
        if (Ec() != paramObject.Ec()) {
          return false;
        }
        if ((Ec()) && (this.bRA != paramObject.bRA)) {
          return false;
        }
        if (Ed() != paramObject.Ed()) {
          return false;
        }
        if ((Ed()) && (this.bRB != paramObject.bRB)) {
          return false;
        }
      } while (this.bTW.equals(paramObject.bTW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bOU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).yO();
      if (((g)localObject).yP()) {
        this.bOU = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.zX().hashCode() + 779;
      int i = j;
      if (Az()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (DX()) {
        j = (i * 37 + 2) * 53 + DY().hashCode();
      }
      i = j;
      if (DZ()) {
        i = (j * 37 + 3) * 53 + Ea().hashCode();
      }
      j = i;
      if (AF()) {
        j = (i * 37 + 4) * 53 + Eb().hashCode();
      }
      i = j;
      if (Ec()) {
        i = (j * 37 + 5) * 53 + ae.bF(this.bRA);
      }
      j = i;
      if (Ed()) {
        j = (i * 37 + 6) * 53 + ae.bF(this.bRB);
      }
      i = j * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bPe;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((AF()) && (!Eb().isInitialized()))
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bOT & 0x1) != 0) {
        j = ac.d(1, this.bOU) + 0;
      }
      i = j;
      if ((this.bOT & 0x2) != 0) {
        i = j + ac.d(2, this.bRx);
      }
      j = i;
      if ((this.bOT & 0x4) != 0) {
        j = i + ac.d(3, this.bRy);
      }
      i = j;
      if ((this.bOT & 0x8) != 0) {
        i = j + i.c(4, Eb());
      }
      j = i;
      if ((this.bOT & 0x10) != 0) {
        j = i + i.fR(5);
      }
      i = j;
      if ((this.bOT & 0x20) != 0) {
        i = j + i.fR(6);
      }
      i += this.bTW.yC();
      this.bNa = i;
      return i;
    }
    
    public static final class a
      extends ac.a<a>
      implements k.x
    {
      private int bOT;
      private Object bOU = "";
      private bu<k.y, k.y.a, k.z> bPn;
      private boolean bRA;
      private boolean bRB;
      private Object bRx = "";
      private Object bRy = "";
      private k.y bRz;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          Bh();
        }
      }
      
      private bu<k.y, k.y.a, k.z> Bh()
      {
        if (this.bPn == null)
        {
          this.bPn = new bu(Eb(), GA(), this.bWv);
          this.bRz = null;
        }
        return this.bPn;
      }
      
      private k.y Eb()
      {
        if (this.bPn == null)
        {
          if (this.bRz == null) {
            return k.y.El();
          }
          return this.bRz;
        }
        return (k.y)this.bPn.Hu();
      }
      
      private k.w Eg()
      {
        k.w localw = Eh();
        if (!localw.isInitialized()) {
          throw b(localw);
        }
        return localw;
      }
      
      private k.w Eh()
      {
        int i = 0;
        k.w localw = new k.w(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        k.w.a(localw, this.bOU);
        int j = i;
        if ((k & 0x2) != 0) {
          j = i | 0x2;
        }
        k.w.b(localw, this.bRx);
        if ((k & 0x4) != 0) {}
        for (i = j | 0x4;; i = j)
        {
          k.w.c(localw, this.bRy);
          if ((k & 0x8) != 0) {
            if (this.bPn == null) {
              k.w.a(localw, this.bRz);
            }
          }
          for (j = i | 0x8;; j = i)
          {
            i = j;
            if ((k & 0x10) != 0)
            {
              k.w.a(localw, this.bRA);
              i = j | 0x10;
            }
            j = i;
            if ((k & 0x20) != 0)
            {
              k.w.b(localw, this.bRB);
              j = i | 0x20;
            }
            k.w.a(localw, j);
            Gy();
            return localw;
            k.w.a(localw, (k.y)this.bPn.Hv());
            break;
          }
        }
      }
      
      private a G(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a H(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a I(l.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a J(l.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a a(k.y paramy)
      {
        if (this.bPn == null) {
          if (((this.bOT & 0x8) != 0) && (this.bRz != null) && (this.bRz != k.y.El()))
          {
            this.bRz = k.y.b(this.bRz).d(paramy).En();
            onChanged();
          }
        }
        for (;;)
        {
          this.bOT |= 0x8;
          return this;
          this.bRz = paramy;
          break;
          this.bPn.b(paramy);
        }
      }
      
      private a bA(boolean paramBoolean)
      {
        this.bOT |= 0x20;
        this.bRB = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bz(boolean paramBoolean)
      {
        this.bOT |= 0x10;
        this.bRA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a r(at paramat)
      {
        if ((paramat instanceof k.w)) {
          return d((k.w)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a s(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 190	com/google/a/k$w:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 195 3 0
        //   12: checkcast 9	com/google/a/k$w
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 179	com/google/a/k$w$a:d	(Lcom/google/a/k$w;)Lcom/google/a/k$w$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 199	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$w
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 203	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 179	com/google/a/k$w$a:d	(Lcom/google/a/k$w;)Lcom/google/a/k$w$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.zX();
      }
      
      protected final ac.f Ay()
      {
        return k.zY().h(k.w.class, a.class);
      }
      
      public final a d(k.w paramw)
      {
        if (paramw == k.w.Ef()) {
          return this;
        }
        if (paramw.Az())
        {
          this.bOT |= 0x1;
          this.bOU = k.w.a(paramw);
          onChanged();
        }
        if (paramw.DX())
        {
          this.bOT |= 0x2;
          this.bRx = k.w.b(paramw);
          onChanged();
        }
        if (paramw.DZ())
        {
          this.bOT |= 0x4;
          this.bRy = k.w.c(paramw);
          onChanged();
        }
        if (paramw.AF()) {
          a(paramw.Eb());
        }
        if (paramw.Ec()) {
          bz(paramw.bRA);
        }
        if (paramw.Ed()) {
          bA(paramw.bRB);
        }
        H(paramw.bTW);
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bOT & 0x8) != 0) {}
        for (int i = 1; (i != 0) && (!Eb().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
  }
  
  public static abstract interface x
    extends az
  {}
  
  public static final class y
    extends ac.d<y>
    implements k.z
  {
    @Deprecated
    public static final bj<y> bPg = new c() {};
    private static final y bRE = new y();
    private int bOT;
    boolean bPA;
    private List<k.ak> bPB;
    private byte bPe = -1;
    private int bRD;
    
    private y()
    {
      this.bRD = 0;
      this.bPB = Collections.emptyList();
    }
    
    private y(ac.c<y, ?> paramc)
    {
      super();
    }
    
    private y(h paramh, r paramr)
    {
      this();
      if (paramr == null) {
        throw new NullPointerException();
      }
      cc.a locala = cc.HJ();
      int m = 0;
      int i = 0;
      for (;;)
      {
        label26:
        int n;
        int i1;
        int k;
        if (m == 0)
        {
          n = i;
          i1 = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            j = paramh.yT();
            switch (j)
            {
            case 264: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramr, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bOT |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bPA = paramh.yZ();
              break label26;
            }
          }
          catch (af paramh)
          {
            try
            {
              paramh.bXr = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x4) != 0) {
                this.bPB = Collections.unmodifiableList(this.bPB);
              }
              this.bTW = locala.HM();
              this.bWd.yK();
            }
            n = i;
            i1 = i;
            k = i;
            j = paramh.zd();
            n = i;
            i1 = i;
            k = i;
            if (b.gw(j) == null)
            {
              n = i;
              i1 = i;
              k = i;
              locala.bx(34, j);
              break;
            }
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new af(paramh);
            k = i1;
            paramh.bXr = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bOT |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bRD = j;
          }
          break;
          int j = i;
          if ((i & 0x4) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bPB = new ArrayList();
            j = i | 0x4;
          }
          n = j;
          i1 = j;
          k = j;
          this.bPB.add(paramh.a(k.ak.bPg, paramr));
          i = j;
          break;
          if ((i & 0x4) != 0) {
            this.bPB = Collections.unmodifiableList(this.bPB);
          }
          this.bTW = locala.HM();
          this.bWd.yK();
          return;
        }
        m = 1;
      }
    }
    
    private int BO()
    {
      return this.bPB.size();
    }
    
    public static y El()
    {
      return bRE;
    }
    
    public static a b(y paramy)
    {
      return bRE.Ek().d(paramy);
    }
    
    public final bj<y> AK()
    {
      return bPg;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    protected final ac.f Ay()
    {
      return k.Ao().h(y.class, a.class);
    }
    
    public final boolean BN()
    {
      return (this.bOT & 0x1) != 0;
    }
    
    public final boolean Ei()
    {
      return (this.bOT & 0x2) != 0;
    }
    
    public final b Ej()
    {
      b localb2 = b.gw(this.bRD);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.bRF;
      }
      return localb1;
    }
    
    public final a Ek()
    {
      if (this == bRE) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      ac.d.a locala = GC();
      if ((this.bOT & 0x1) != 0) {
        parami.r(33, this.bPA);
      }
      if ((this.bOT & 0x2) != 0) {
        parami.bs(34, this.bRD);
      }
      int i = 0;
      while (i < this.bPB.size())
      {
        parami.a(999, (aw)this.bPB.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bTW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof y)) {
          return super.equals(paramObject);
        }
        paramObject = (y)paramObject;
        if (BN() != paramObject.BN()) {
          return false;
        }
        if ((BN()) && (this.bPA != paramObject.bPA)) {
          return false;
        }
        if (Ei() != paramObject.Ei()) {
          return false;
        }
        if ((Ei()) && (this.bRD != paramObject.bRD)) {
          return false;
        }
        if (!this.bPB.equals(paramObject.bPB)) {
          return false;
        }
        if (!this.bTW.equals(paramObject.bTW)) {
          return false;
        }
      } while (this.bWd.FS().equals(paramObject.bWd.FS()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bNb != 0) {
        return this.bNb;
      }
      int j = k.An().hashCode() + 779;
      int i = j;
      if (BN()) {
        i = (j * 37 + 33) * 53 + ae.bF(this.bPA);
      }
      j = i;
      if (Ei()) {
        j = (i * 37 + 34) * 53 + this.bRD;
      }
      i = j;
      if (BO() > 0) {
        i = (j * 37 + 999) * 53 + this.bPB.hashCode();
      }
      i = b(i, this.bWd.FS()) * 29 + this.bTW.hashCode();
      this.bNb = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bPe;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < BO())
      {
        if (!((k.ak)this.bPB.get(i)).isInitialized())
        {
          this.bPe = 0;
          return false;
        }
        i += 1;
      }
      if (!this.bWd.isInitialized())
      {
        this.bPe = 0;
        return false;
      }
      this.bPe = 1;
      return true;
    }
    
    public final int yC()
    {
      int k = 0;
      int i = this.bNa;
      if (i != -1) {
        return i;
      }
      if ((this.bOT & 0x1) != 0) {}
      for (i = i.fR(33) + 0;; i = 0)
      {
        int j = i;
        if ((this.bOT & 0x2) != 0) {
          j = i + i.bv(34, this.bRD);
        }
        i = j;
        j = k;
        while (j < this.bPB.size())
        {
          k = i.c(999, (aw)this.bPB.get(j));
          j += 1;
          i = k + i;
        }
        i = this.bWd.yC() + i + this.bTW.yC();
        this.bNa = i;
        return i;
      }
    }
    
    public static final class a
      extends ac.c<k.y, a>
      implements k.z
    {
      private int bOT;
      private boolean bPA;
      private List<k.ak> bPB = Collections.emptyList();
      private bq<k.ak, k.ak.a, k.al> bPD;
      private int bRD = 0;
      
      private a()
      {
        AR();
      }
      
      private a(ac.b paramb)
      {
        super();
        AR();
      }
      
      private void AR()
      {
        if (ac.bVU) {
          BU();
        }
      }
      
      private void BT()
      {
        if ((this.bOT & 0x4) == 0)
        {
          this.bPB = new ArrayList(this.bPB);
          this.bOT |= 0x4;
        }
      }
      
      private bq<k.ak, k.ak.a, k.al> BU()
      {
        List localList;
        if (this.bPD == null)
        {
          localList = this.bPB;
          if ((this.bOT & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bPD = new bq(localList, bool, GA(), this.bWv);
          this.bPB = null;
          return this.bPD;
        }
      }
      
      private k.y Em()
      {
        k.y localy = En();
        if (!localy.isInitialized()) {
          throw b(localy);
        }
        return localy;
      }
      
      private a I(cc paramcc)
      {
        return (a)super.e(paramcc);
      }
      
      private a J(cc paramcc)
      {
        return (a)super.d(paramcc);
      }
      
      private a K(l.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a L(l.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a a(k.y.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bOT |= 0x2;
        this.bRD = paramb.value;
        onChanged();
        return this;
      }
      
      private a bB(boolean paramBoolean)
      {
        this.bOT |= 0x1;
        this.bPA = paramBoolean;
        onChanged();
        return this;
      }
      
      private a s(at paramat)
      {
        if ((paramat instanceof k.y)) {
          return d((k.y)paramat);
        }
        super.a(paramat);
        return this;
      }
      
      /* Error */
      private a t(h paramh, r paramr)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 148	com/google/a/k$y:bPg	Lcom/google/a/bj;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 153 3 0
        //   12: checkcast 9	com/google/a/k$y
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 137	com/google/a/k$y$a:d	(Lcom/google/a/k$y;)Lcom/google/a/k$y$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 157	com/google/a/af:bXr	Lcom/google/a/aw;
        //   33: checkcast 9	com/google/a/k$y
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 161	com/google/a/af:GF	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 137	com/google/a/k$y$a:d	(Lcom/google/a/k$y;)Lcom/google/a/k$y$a;
        //   52: pop
        //   53: aload_1
        //   54: athrow
        //   55: astore_1
        //   56: aload_3
        //   57: astore_2
        //   58: goto -15 -> 43
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	a
        //   0	61	1	paramh	h
        //   0	61	2	paramr	r
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/a/af
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      public final l.a AS()
      {
        return k.An();
      }
      
      protected final ac.f Ay()
      {
        return k.Ao().h(k.y.class, a.class);
      }
      
      public final k.y En()
      {
        int i = 0;
        k.y localy = new k.y(this, (byte)0);
        int k = this.bOT;
        if ((k & 0x1) != 0)
        {
          k.y.a(localy, this.bPA);
          i = 1;
        }
        int j = i;
        if ((k & 0x2) != 0) {
          j = i | 0x2;
        }
        k.y.a(localy, this.bRD);
        if (this.bPD == null)
        {
          if ((this.bOT & 0x4) != 0)
          {
            this.bPB = Collections.unmodifiableList(this.bPB);
            this.bOT &= 0xFFFFFFFB;
          }
          k.y.a(localy, this.bPB);
        }
        for (;;)
        {
          k.y.b(localy, j);
          Gy();
          return localy;
          k.y.a(localy, this.bPD.build());
        }
      }
      
      public final a d(k.y paramy)
      {
        bq localbq = null;
        if (paramy == k.y.El()) {
          return this;
        }
        if (paramy.BN()) {
          bB(paramy.bPA);
        }
        if (paramy.Ei()) {
          a(paramy.Ej());
        }
        if (this.bPD == null) {
          if (!k.y.c(paramy).isEmpty())
          {
            if (!this.bPB.isEmpty()) {
              break label117;
            }
            this.bPB = k.y.c(paramy);
            this.bOT &= 0xFFFFFFFB;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramy);
          J(paramy.bTW);
          onChanged();
          return this;
          label117:
          BT();
          this.bPB.addAll(k.y.c(paramy));
          break;
          if (!k.y.c(paramy).isEmpty()) {
            if (this.bPD.isEmpty())
            {
              this.bPD.bYP = null;
              this.bPD = null;
              this.bPB = k.y.c(paramy);
              this.bOT &= 0xFFFFFFFB;
              if (ac.bVU) {
                localbq = BU();
              }
              this.bPD = localbq;
            }
            else
            {
              this.bPD.a(k.y.c(paramy));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bPD == null)
        {
          j = this.bPB.size();
          if (i >= j) {
            break label88;
          }
          if (this.bPD != null) {
            break label65;
          }
          localak = (k.ak)this.bPB.get(i);
          if (localak.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!this.bWd.isInitialized())
        {
          for (;;)
          {
            return false;
            j = this.bPD.getCount();
            break;
            k.ak localak = (k.ak)this.bPD.s(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
    
    public static enum b
      implements bn
    {
      private static final ae.b<b> bPU = new ae.b() {};
      private static final b[] bRI = values();
      final int value;
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b gw(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return bRF;
        case 1: 
          return bRG;
        }
        return bRH;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static abstract interface z
    extends ac.e
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.k
 * JD-Core Version:    0.7.0.1
 */