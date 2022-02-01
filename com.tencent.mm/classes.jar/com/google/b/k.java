package com.google.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k
{
  private static final aj.a bPP;
  private static final bb.e bPQ;
  private static final aj.a bPR;
  private static final bb.e bPS;
  private static final aj.a bPT;
  private static final bb.e bPU;
  private static final aj.a bPV;
  private static final bb.e bPW;
  private static final aj.a bPX;
  private static final bb.e bPY;
  private static final aj.a bPZ;
  private static final bb.e bQA = new bb.e(bQz, new String[] { "Deprecated", "UninterpretedOption" });
  private static final aj.a bQB = (aj.a)bQR.Hw().get(16);
  private static final bb.e bQC = new bb.e(bQB, new String[] { "Deprecated", "UninterpretedOption" });
  private static final aj.a bQD = (aj.a)bQR.Hw().get(17);
  private static final bb.e bQE = new bb.e(bQD, new String[] { "Deprecated", "IdempotencyLevel", "UninterpretedOption" });
  private static final aj.a bQF = (aj.a)bQR.Hw().get(18);
  private static final bb.e bQG = new bb.e(bQF, new String[] { "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue" });
  private static final aj.a bQH = (aj.a)bQF.Hf().get(0);
  private static final bb.e bQI = new bb.e(bQH, new String[] { "NamePart", "IsExtension" });
  private static final aj.a bQJ = (aj.a)bQR.Hw().get(19);
  private static final bb.e bQK = new bb.e(bQJ, new String[] { "Location" });
  private static final aj.a bQL = (aj.a)bQJ.Hf().get(0);
  private static final bb.e bQM = new bb.e(bQL, new String[] { "Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments" });
  private static final aj.a bQN = (aj.a)bQR.Hw().get(20);
  private static final bb.e bQO = new bb.e(bQN, new String[] { "Annotation" });
  private static final aj.a bQP = (aj.a)bQN.Hf().get(0);
  private static final bb.e bQQ = new bb.e(bQP, new String[] { "Path", "SourceFile", "Begin", "End" });
  private static aj.g bQR;
  private static final bb.e bQa;
  private static final aj.a bQb;
  private static final bb.e bQc;
  private static final aj.a bQd;
  private static final bb.e bQe;
  private static final aj.a bQf;
  private static final bb.e bQg;
  private static final aj.a bQh;
  private static final bb.e bQi;
  private static final aj.a bQj;
  private static final bb.e bQk;
  private static final aj.a bQl;
  private static final bb.e bQm;
  private static final aj.a bQn;
  private static final bb.e bQo;
  private static final aj.a bQp;
  private static final bb.e bQq;
  private static final aj.a bQr;
  private static final bb.e bQs;
  private static final aj.a bQt;
  private static final bb.e bQu;
  private static final aj.a bQv;
  private static final bb.e bQw;
  private static final aj.a bQx;
  private static final bb.e bQy;
  private static final aj.a bQz;
  
  static
  {
    aj.g localg = aj.g.a(new String[] { "" }, new aj.g[0]);
    bQR = localg;
    bPP = (aj.a)localg.Hw().get(0);
    bPQ = new bb.e(bPP, new String[] { "File" });
    bPR = (aj.a)bQR.Hw().get(1);
    bPS = new bb.e(bPR, new String[] { "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax" });
    bPT = (aj.a)bQR.Hw().get(2);
    bPU = new bb.e(bPT, new String[] { "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName" });
    bPV = (aj.a)bPT.Hf().get(0);
    bPW = new bb.e(bPV, new String[] { "Start", "End", "Options" });
    bPX = (aj.a)bPT.Hf().get(1);
    bPY = new bb.e(bPX, new String[] { "Start", "End" });
    bPZ = (aj.a)bQR.Hw().get(3);
    bQa = new bb.e(bPZ, new String[] { "UninterpretedOption" });
    bQb = (aj.a)bQR.Hw().get(4);
    bQc = new bb.e(bQb, new String[] { "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options" });
    bQd = (aj.a)bQR.Hw().get(5);
    bQe = new bb.e(bQd, new String[] { "Name", "Options" });
    bQf = (aj.a)bQR.Hw().get(6);
    bQg = new bb.e(bQf, new String[] { "Name", "Value", "Options", "ReservedRange", "ReservedName" });
    bQh = (aj.a)bQf.Hf().get(0);
    bQi = new bb.e(bQh, new String[] { "Start", "End" });
    bQj = (aj.a)bQR.Hw().get(7);
    bQk = new bb.e(bQj, new String[] { "Name", "Number", "Options" });
    bQl = (aj.a)bQR.Hw().get(8);
    bQm = new bb.e(bQl, new String[] { "Name", "Method", "Options" });
    bQn = (aj.a)bQR.Hw().get(9);
    bQo = new bb.e(bQn, new String[] { "Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming" });
    bQp = (aj.a)bQR.Hw().get(10);
    bQq = new bb.e(bQp, new String[] { "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption" });
    bQr = (aj.a)bQR.Hw().get(11);
    bQs = new bb.e(bQr, new String[] { "MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption" });
    bQt = (aj.a)bQR.Hw().get(12);
    bQu = new bb.e(bQt, new String[] { "Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption" });
    bQv = (aj.a)bQR.Hw().get(13);
    bQw = new bb.e(bQv, new String[] { "UninterpretedOption" });
    bQx = (aj.a)bQR.Hw().get(14);
    bQy = new bb.e(bQx, new String[] { "AllowAlias", "Deprecated", "UninterpretedOption" });
    bQz = (aj.a)bQR.Hw().get(15);
  }
  
  public static final class a
    extends bb
    implements n
  {
    private static final a bRe = new a();
    @Deprecated
    public static final ci<a> bRf = new c() {};
    private int bQS;
    private volatile Object bQT;
    private List<k.g> bQU;
    private List<k.g> bQV;
    private List<a> bQW;
    private List<k.b> bQX;
    List<b> bQY;
    private List<k.n> bQZ;
    private k.k bRa;
    private List<k.a.c> bRb;
    private bk bRc;
    private byte bRd = -1;
    
    private a()
    {
      this.bQT = "";
      this.bQU = Collections.emptyList();
      this.bQV = Collections.emptyList();
      this.bQW = Collections.emptyList();
      this.bQX = Collections.emptyList();
      this.bQY = Collections.emptyList();
      this.bQZ = Collections.emptyList();
      this.bRb = Collections.emptyList();
      this.bRc = bj.bZD;
    }
    
    private a(bb.a<?> parama)
    {
      super();
    }
    
    private a(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            n = paramh.Av();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (a(paramh, locala, paramap, n)) {
                break label1311;
              }
              j = 1;
              break label1327;
              k = i;
              m = i;
              j = i;
              localObject = paramh.AD();
              k = i;
              m = i;
              j = i;
              this.bQS |= 0x1;
              k = i;
              m = i;
              j = i;
              this.bQT = localObject;
              break label26;
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally
            {
              j = k;
              if ((j & 0x2) != 0) {
                this.bQU = Collections.unmodifiableList(this.bQU);
              }
              if ((j & 0x8) != 0) {
                this.bQW = Collections.unmodifiableList(this.bQW);
              }
              if ((j & 0x10) != 0) {
                this.bQX = Collections.unmodifiableList(this.bQX);
              }
              if ((j & 0x20) != 0) {
                this.bQY = Collections.unmodifiableList(this.bQY);
              }
              if ((j & 0x4) != 0) {
                this.bQV = Collections.unmodifiableList(this.bQV);
              }
              if ((j & 0x40) != 0) {
                this.bQZ = Collections.unmodifiableList(this.bQZ);
              }
              if ((j & 0x100) != 0) {
                this.bRb = Collections.unmodifiableList(this.bRb);
              }
              if ((j & 0x200) != 0) {
                this.bRc = this.bRc.Ix();
              }
              this.bVW = locala.Jm();
              HZ();
            }
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bQU = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.bQU.add(paramh.a(k.g.bRf, paramap));
            i = n;
            break;
          }
          catch (IOException paramh)
          {
            j = m;
            paramh = new bf(paramh);
            j = m;
            paramh.bZj = this;
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
              this.bQW = new ArrayList();
              n = i | 0x8;
            }
            k = n;
            m = n;
            j = n;
            this.bQW.add(paramh.a(bRf, paramap));
            i = n;
          }
          break;
          int n = i;
          if ((i & 0x10) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQX = new ArrayList();
            n = i | 0x10;
          }
          k = n;
          m = n;
          j = n;
          this.bQX.add(paramh.a(k.b.bRf, paramap));
          i = n;
          break;
          n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQY = new ArrayList();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.bQY.add(paramh.a(b.bRf, paramap));
          i = n;
          break;
          n = i;
          if ((i & 0x4) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQV = new ArrayList();
            n = i | 0x4;
          }
          k = n;
          m = n;
          j = n;
          this.bQV.add(paramh.a(k.g.bRf, paramap));
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          if ((this.bQS & 0x2) != 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (Object localObject = this.bRa.Fy();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.bRa = ((k.k)paramh.a(k.k.bRf, paramap));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((k.k.a)localObject).d(this.bRa);
              k = i;
              m = i;
              j = i;
              this.bRa = ((k.k.a)localObject).FB();
            }
            k = i;
            m = i;
            j = i;
            this.bQS |= 0x2;
            break;
            n = i;
            if ((i & 0x40) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bQZ = new ArrayList();
              n = i | 0x40;
            }
            k = n;
            m = n;
            j = n;
            this.bQZ.add(paramh.a(k.n.bRf, paramap));
            i = n;
            break;
            n = i;
            if ((i & 0x100) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRb = new ArrayList();
              n = i | 0x100;
            }
            k = n;
            m = n;
            j = n;
            this.bRb.add(paramh.a(k.a.c.bRf, paramap));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            localObject = paramh.AD();
            n = i;
            if ((i & 0x200) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRc = new bj();
              n = i | 0x200;
            }
            k = n;
            m = n;
            j = n;
            this.bRc.d((g)localObject);
            i = n;
            break;
            if ((i & 0x2) != 0) {
              this.bQU = Collections.unmodifiableList(this.bQU);
            }
            if ((i & 0x8) != 0) {
              this.bQW = Collections.unmodifiableList(this.bQW);
            }
            if ((i & 0x10) != 0) {
              this.bQX = Collections.unmodifiableList(this.bQX);
            }
            if ((i & 0x20) != 0) {
              this.bQY = Collections.unmodifiableList(this.bQY);
            }
            if ((i & 0x4) != 0) {
              this.bQV = Collections.unmodifiableList(this.bQV);
            }
            if ((i & 0x40) != 0) {
              this.bQZ = Collections.unmodifiableList(this.bQZ);
            }
            if ((i & 0x100) != 0) {
              this.bRb = Collections.unmodifiableList(this.bRb);
            }
            if ((i & 0x200) != 0) {
              this.bRc = this.bRc.Ix();
            }
            this.bVW = locala.Jm();
            HZ();
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
    
    private int Ch()
    {
      return this.bQY.size();
    }
    
    public static a Cl()
    {
      return bRe.Cm();
    }
    
    private a Cm()
    {
      if (this == bRe) {
        return new a((byte)0);
      }
      return new a((byte)0).j(this);
    }
    
    public static a Cn()
    {
      return bRe;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {}
      for (i = bb.f(1, this.bQT) + 0;; i = 0)
      {
        int j = 0;
        while (j < this.bQU.size())
        {
          i += i.c(2, (bw)this.bQU.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQW.size())
        {
          i += i.c(3, (bw)this.bQW.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQX.size())
        {
          i += i.c(4, (bw)this.bQX.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQY.size())
        {
          i += i.c(5, (bw)this.bQY.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQV.size())
        {
          i += i.c(6, (bw)this.bQV.get(j));
          j += 1;
        }
        j = i;
        if ((this.bQS & 0x2) != 0) {
          j = i + i.c(7, Ck());
        }
        int k = 0;
        i = j;
        j = k;
        while (j < this.bQZ.size())
        {
          i += i.c(8, (bw)this.bQZ.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bRb.size())
        {
          i += i.c(9, (bw)this.bRb.get(j));
          j += 1;
        }
        j = 0;
        k = 0;
        while (j < this.bRc.size())
        {
          k += ao(this.bRc.getRaw(j));
          j += 1;
        }
        i = i + k + this.bRc.size() * 1 + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Bh().b(a.class, a.class);
    }
    
    public final boolean Cc()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final int Cd()
    {
      return this.bQU.size();
    }
    
    public final int Ce()
    {
      return this.bQV.size();
    }
    
    public final int Cf()
    {
      return this.bQW.size();
    }
    
    public final int Cg()
    {
      return this.bQX.size();
    }
    
    public final int Ci()
    {
      return this.bQZ.size();
    }
    
    public final boolean Cj()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final k.k Ck()
    {
      if (this.bRa == null) {
        return k.k.Fz();
      }
      return this.bRa;
    }
    
    public final ci<a> Co()
    {
      return bRf;
    }
    
    public final void a(i parami)
    {
      int k = 0;
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bQT);
      }
      int i = 0;
      while (i < this.bQU.size())
      {
        parami.a(2, (bw)this.bQU.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQW.size())
      {
        parami.a(3, (bw)this.bQW.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQX.size())
      {
        parami.a(4, (bw)this.bQX.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQY.size())
      {
        parami.a(5, (bw)this.bQY.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQV.size())
      {
        parami.a(6, (bw)this.bQV.get(i));
        i += 1;
      }
      if ((this.bQS & 0x2) != 0) {
        parami.a(7, Ck());
      }
      i = 0;
      while (i < this.bQZ.size())
      {
        parami.a(8, (bw)this.bQZ.get(i));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.bRb.size()) {
          break;
        }
        parami.a(9, (bw)this.bRb.get(i));
        i += 1;
      }
      while (j < this.bRc.size())
      {
        bb.a(parami, 10, this.bRc.getRaw(j));
        j += 1;
      }
      this.bVW.a(parami);
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
        if (Cc() != paramObject.Cc()) {
          return false;
        }
        if ((Cc()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.bQU.equals(paramObject.bQU)) {
          return false;
        }
        if (!this.bQV.equals(paramObject.bQV)) {
          return false;
        }
        if (!this.bQW.equals(paramObject.bQW)) {
          return false;
        }
        if (!this.bQX.equals(paramObject.bQX)) {
          return false;
        }
        if (!this.bQY.equals(paramObject.bQY)) {
          return false;
        }
        if (!this.bQZ.equals(paramObject.bQZ)) {
          return false;
        }
        if (Cj() != paramObject.Cj()) {
          return false;
        }
        if ((Cj()) && (!Ck().equals(paramObject.Ck()))) {
          return false;
        }
        if (!this.bRb.equals(paramObject.bRb)) {
          return false;
        }
        if (!this.bRc.equals(paramObject.bRc)) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final k.g gS(int paramInt)
    {
      return (k.g)this.bQU.get(paramInt);
    }
    
    public final k.g gT(int paramInt)
    {
      return (k.g)this.bQV.get(paramInt);
    }
    
    public final a gU(int paramInt)
    {
      return (a)this.bQW.get(paramInt);
    }
    
    public final k.b gV(int paramInt)
    {
      return (k.b)this.bQX.get(paramInt);
    }
    
    public final k.n gW(int paramInt)
    {
      return (k.n)this.bQZ.get(paramInt);
    }
    
    public final String getName()
    {
      Object localObject = this.bQT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bQT = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Bg().hashCode() + 779;
      int i = j;
      if (Cc()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (Cd() > 0) {
        j = (i * 37 + 2) * 53 + this.bQU.hashCode();
      }
      i = j;
      if (Ce() > 0) {
        i = (j * 37 + 6) * 53 + this.bQV.hashCode();
      }
      j = i;
      if (Cf() > 0) {
        j = (i * 37 + 3) * 53 + this.bQW.hashCode();
      }
      i = j;
      if (Cg() > 0) {
        i = (j * 37 + 4) * 53 + this.bQX.hashCode();
      }
      j = i;
      if (Ch() > 0) {
        j = (i * 37 + 5) * 53 + this.bQY.hashCode();
      }
      i = j;
      if (Ci() > 0) {
        i = (j * 37 + 8) * 53 + this.bQZ.hashCode();
      }
      j = i;
      if (Cj()) {
        j = (i * 37 + 7) * 53 + Ck().hashCode();
      }
      i = j;
      if (this.bRb.size() > 0) {
        i = (j * 37 + 9) * 53 + this.bRb.hashCode();
      }
      j = i;
      if (this.bRc.size() > 0) {
        j = (i * 37 + 10) * 53 + this.bRc.hashCode();
      }
      i = j * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Cd())
      {
        if (!gS(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Ce())
      {
        if (!gT(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Cf())
      {
        if (!gU(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Cg())
      {
        if (!gV(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Ch())
      {
        if (!((b)this.bQY.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Ci())
      {
        if (!gW(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if ((Cj()) && (!Ck().isInitialized()))
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements n
    {
      private int bQS;
      private Object bQT = "";
      private List<k.g> bQU = Collections.emptyList();
      private List<k.g> bQV = Collections.emptyList();
      private List<k.a> bQW = Collections.emptyList();
      private List<k.b> bQX = Collections.emptyList();
      private List<k.a.b> bQY = Collections.emptyList();
      private List<k.n> bQZ = Collections.emptyList();
      private k.k bRa;
      private List<k.a.c> bRb = Collections.emptyList();
      private bk bRc = bj.bZD;
      private co<k.g, k.g.a, u> bRg;
      private co<k.g, k.g.a, u> bRh;
      private co<k.a, a, n> bRi;
      private co<k.b, k.b.a, p> bRj;
      private co<k.a.b, k.a.b.a, l> bRk;
      private co<k.n, k.n.a, ab> bRl;
      private cs<k.k, k.k.a, y> bRm;
      private co<k.a.c, k.a.c.a, m> bRn;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void CA()
      {
        if ((this.bQS & 0x4) == 0)
        {
          this.bQV = new ArrayList(this.bQV);
          this.bQS |= 0x4;
        }
      }
      
      private co<k.g, k.g.a, u> CB()
      {
        List localList;
        if (this.bRh == null)
        {
          localList = this.bQV;
          if ((this.bQS & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRh = new co(localList, bool, Ie(), Ic());
          this.bQV = null;
          return this.bRh;
        }
      }
      
      private void CC()
      {
        if ((this.bQS & 0x8) == 0)
        {
          this.bQW = new ArrayList(this.bQW);
          this.bQS |= 0x8;
        }
      }
      
      private co<k.a, a, n> CD()
      {
        List localList;
        if (this.bRi == null)
        {
          localList = this.bQW;
          if ((this.bQS & 0x8) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRi = new co(localList, bool, Ie(), Ic());
          this.bQW = null;
          return this.bRi;
        }
      }
      
      private void CE()
      {
        if ((this.bQS & 0x10) == 0)
        {
          this.bQX = new ArrayList(this.bQX);
          this.bQS |= 0x10;
        }
      }
      
      private co<k.b, k.b.a, p> CF()
      {
        List localList;
        if (this.bRj == null)
        {
          localList = this.bQX;
          if ((this.bQS & 0x10) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRj = new co(localList, bool, Ie(), Ic());
          this.bQX = null;
          return this.bRj;
        }
      }
      
      private void CG()
      {
        if ((this.bQS & 0x20) == 0)
        {
          this.bQY = new ArrayList(this.bQY);
          this.bQS |= 0x20;
        }
      }
      
      private co<k.a.b, k.a.b.a, l> CH()
      {
        List localList;
        if (this.bRk == null)
        {
          localList = this.bQY;
          if ((this.bQS & 0x20) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRk = new co(localList, bool, Ie(), Ic());
          this.bQY = null;
          return this.bRk;
        }
      }
      
      private void CI()
      {
        if ((this.bQS & 0x40) == 0)
        {
          this.bQZ = new ArrayList(this.bQZ);
          this.bQS |= 0x40;
        }
      }
      
      private co<k.n, k.n.a, ab> CJ()
      {
        List localList;
        if (this.bRl == null)
        {
          localList = this.bQZ;
          if ((this.bQS & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRl = new co(localList, bool, Ie(), Ic());
          this.bQZ = null;
          return this.bRl;
        }
      }
      
      private cs<k.k, k.k.a, y> CK()
      {
        if (this.bRm == null)
        {
          this.bRm = new cs(Ck(), Ie(), Ic());
          this.bRa = null;
        }
        return this.bRm;
      }
      
      private void CL()
      {
        if ((this.bQS & 0x100) == 0)
        {
          this.bRb = new ArrayList(this.bRb);
          this.bQS |= 0x100;
        }
      }
      
      private co<k.a.c, k.a.c.a, m> CM()
      {
        List localList;
        if (this.bRn == null)
        {
          localList = this.bRb;
          if ((this.bQS & 0x100) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.bRn = new co(localList, bool, Ie(), Ic());
          this.bRb = null;
          return this.bRn;
        }
      }
      
      private void CN()
      {
        if ((this.bQS & 0x200) == 0)
        {
          this.bRc = new bj(this.bRc);
          this.bQS |= 0x200;
        }
      }
      
      private k.k Ck()
      {
        if (this.bRm == null)
        {
          if (this.bRa == null) {
            return k.k.Fz();
          }
          return this.bRa;
        }
        return (k.k)this.bRm.IU();
      }
      
      private void Cu()
      {
        if (bb.bXS)
        {
          Cz();
          CB();
          CD();
          CF();
          CH();
          CJ();
          CK();
          CM();
        }
      }
      
      private k.a Cx()
      {
        k.a locala = new k.a(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          k.a.a(locala, this.bQT);
          label130:
          label179:
          label228:
          int j;
          if (this.bRg == null)
          {
            if ((this.bQS & 0x2) != 0)
            {
              this.bQU = Collections.unmodifiableList(this.bQU);
              this.bQS &= 0xFFFFFFFD;
            }
            k.a.a(locala, this.bQU);
            if (this.bRh != null) {
              break label484;
            }
            if ((this.bQS & 0x4) != 0)
            {
              this.bQV = Collections.unmodifiableList(this.bQV);
              this.bQS &= 0xFFFFFFFB;
            }
            k.a.b(locala, this.bQV);
            if (this.bRi != null) {
              break label500;
            }
            if ((this.bQS & 0x8) != 0)
            {
              this.bQW = Collections.unmodifiableList(this.bQW);
              this.bQS &= 0xFFFFFFF7;
            }
            k.a.c(locala, this.bQW);
            if (this.bRj != null) {
              break label516;
            }
            if ((this.bQS & 0x10) != 0)
            {
              this.bQX = Collections.unmodifiableList(this.bQX);
              this.bQS &= 0xFFFFFFEF;
            }
            k.a.d(locala, this.bQX);
            if (this.bRk != null) {
              break label532;
            }
            if ((this.bQS & 0x20) != 0)
            {
              this.bQY = Collections.unmodifiableList(this.bQY);
              this.bQS &= 0xFFFFFFDF;
            }
            k.a.e(locala, this.bQY);
            label277:
            if (this.bRl != null) {
              break label548;
            }
            if ((this.bQS & 0x40) != 0)
            {
              this.bQZ = Collections.unmodifiableList(this.bQZ);
              this.bQS &= 0xFFFFFFBF;
            }
            k.a.f(locala, this.bQZ);
            label326:
            j = i;
            if ((k & 0x80) != 0)
            {
              if (this.bRm != null) {
                break label564;
              }
              k.a.a(locala, this.bRa);
              label353:
              j = i | 0x2;
            }
            if (this.bRn != null) {
              break label583;
            }
            if ((this.bQS & 0x100) != 0)
            {
              this.bRb = Collections.unmodifiableList(this.bRb);
              this.bQS &= 0xFFFFFEFF;
            }
            k.a.g(locala, this.bRb);
          }
          for (;;)
          {
            if ((this.bQS & 0x200) != 0)
            {
              this.bRc = this.bRc.Ix();
              this.bQS &= 0xFFFFFDFF;
            }
            k.a.a(locala, this.bRc);
            k.a.a(locala, j);
            Ib();
            return locala;
            k.a.a(locala, this.bRg.build());
            break;
            label484:
            k.a.b(locala, this.bRh.build());
            break label130;
            label500:
            k.a.c(locala, this.bRi.build());
            break label179;
            label516:
            k.a.d(locala, this.bRj.build());
            break label228;
            label532:
            k.a.e(locala, this.bRk.build());
            break label277;
            label548:
            k.a.f(locala, this.bRl.build());
            break label326;
            label564:
            k.a.a(locala, (k.k)this.bRm.IV());
            break label353;
            label583:
            k.a.g(locala, this.bRn.build());
          }
        }
      }
      
      private void Cy()
      {
        if ((this.bQS & 0x2) == 0)
        {
          this.bQU = new ArrayList(this.bQU);
          this.bQS |= 0x2;
        }
      }
      
      private co<k.g, k.g.a, u> Cz()
      {
        List localList;
        if (this.bRg == null)
        {
          localList = this.bQU;
          if ((this.bQS & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRg = new co(localList, bool, Ie(), Ic());
          this.bQU = null;
          return this.bRg;
        }
      }
      
      private a a(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a a(k.k paramk)
      {
        if (this.bRm == null) {
          if (((this.bQS & 0x80) != 0) && (this.bRa != null) && (this.bRa != k.k.Fz()))
          {
            this.bRa = k.k.b(this.bRa).d(paramk).FB();
            onChanged();
          }
        }
        for (;;)
        {
          this.bQS |= 0x80;
          return this;
          this.bRa = paramk;
          break;
          this.bRm.c(paramk);
        }
      }
      
      private a b(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a b(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a c(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a d(bt parambt)
      {
        if ((parambt instanceof k.a)) {
          return j((k.a)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a e(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 305	com/google/b/k$a:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 310 3 0
        //   12: checkcast 9	com/google/b/k$a
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 295	com/google/b/k$a$a:j	(Lcom/google/b/k$a;)Lcom/google/b/k$a$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 314	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$a
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 318	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 295	com/google/b/k$a$a:j	(Lcom/google/b/k$a;)Lcom/google/b/k$a$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      protected final bb.e Cb()
      {
        return k.Bh().b(k.a.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.Bg();
      }
      
      public final k.a Cw()
      {
        k.a locala = Cx();
        if (!locala.isInitialized()) {
          throw b(locala);
        }
        return locala;
      }
      
      public final a a(k.a.b paramb)
      {
        if (this.bRk == null)
        {
          if (paramb == null) {
            throw new NullPointerException();
          }
          CG();
          this.bQY.add(paramb);
          onChanged();
          return this;
        }
        this.bRk.a(paramb);
        return this;
      }
      
      public final a cy(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x1;
        this.bQT = paramString;
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        Object localObject;
        if (this.bRg == null)
        {
          j = this.bQU.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRg != null) {
            break label65;
          }
          localObject = (k.g)this.bQU.get(i);
          label45:
          if (((k.g)localObject).isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bRg.getCount();
          break label19;
          label65:
          localObject = (k.g)this.bRg.u(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          i = 0;
          if (this.bRh == null)
          {
            j = this.bQV.size();
            label107:
            if (i >= j) {
              break label174;
            }
            if (this.bRh != null) {
              break label158;
            }
          }
          label158:
          for (localObject = (k.g)this.bQV.get(i);; localObject = (k.g)this.bRh.u(i, false))
          {
            if (!((k.g)localObject).isInitialized()) {
              break label172;
            }
            i += 1;
            break;
            j = this.bRh.getCount();
            break label107;
          }
          label172:
          continue;
          label174:
          i = 0;
          if (this.bRi == null)
          {
            j = this.bQW.size();
            label193:
            if (i >= j) {
              break label260;
            }
            if (this.bRi != null) {
              break label244;
            }
          }
          label244:
          for (localObject = (k.a)this.bQW.get(i);; localObject = (k.a)this.bRi.u(i, false))
          {
            if (!((k.a)localObject).isInitialized()) {
              break label258;
            }
            i += 1;
            break;
            j = this.bRi.getCount();
            break label193;
          }
          label258:
          continue;
          label260:
          i = 0;
          if (this.bRj == null)
          {
            j = this.bQX.size();
            label279:
            if (i >= j) {
              break label346;
            }
            if (this.bRj != null) {
              break label330;
            }
          }
          label330:
          for (localObject = (k.b)this.bQX.get(i);; localObject = (k.b)this.bRj.u(i, false))
          {
            if (!((k.b)localObject).isInitialized()) {
              break label344;
            }
            i += 1;
            break;
            j = this.bRj.getCount();
            break label279;
          }
          label344:
          continue;
          label346:
          i = 0;
          if (this.bRk == null)
          {
            j = this.bQY.size();
            label365:
            if (i >= j) {
              break label432;
            }
            if (this.bRk != null) {
              break label416;
            }
          }
          label416:
          for (localObject = (k.a.b)this.bQY.get(i);; localObject = (k.a.b)this.bRk.u(i, false))
          {
            if (!((k.a.b)localObject).isInitialized()) {
              break label430;
            }
            i += 1;
            break;
            j = this.bRk.getCount();
            break label365;
          }
          label430:
          continue;
          label432:
          i = 0;
          if (this.bRl == null)
          {
            j = this.bQZ.size();
            label451:
            if (i >= j) {
              break label518;
            }
            if (this.bRl != null) {
              break label502;
            }
          }
          label502:
          for (localObject = (k.n)this.bQZ.get(i);; localObject = (k.n)this.bRl.u(i, false))
          {
            if (!((k.n)localObject).isInitialized()) {
              break label516;
            }
            i += 1;
            break;
            j = this.bRl.getCount();
            break label451;
          }
          label516:
          continue;
          label518:
          if ((this.bQS & 0x80) != 0) {}
          for (i = 1; (i == 0) || (Ck().isInitialized()); i = 0) {
            return true;
          }
        }
      }
      
      public final a j(k.a parama)
      {
        Object localObject2 = null;
        if (parama == k.a.Cn()) {
          return this;
        }
        if (parama.Cc())
        {
          this.bQS |= 0x1;
          this.bQT = k.a.a(parama);
          onChanged();
        }
        if (this.bRg == null) {
          if (!k.a.b(parama).isEmpty())
          {
            if (this.bQU.isEmpty())
            {
              this.bQU = k.a.b(parama);
              this.bQS &= 0xFFFFFFFD;
              onChanged();
            }
          }
          else
          {
            label94:
            if (this.bRh != null) {
              break label633;
            }
            if (!k.a.c(parama).isEmpty())
            {
              if (!this.bQV.isEmpty()) {
                break label612;
              }
              this.bQV = k.a.c(parama);
              this.bQS &= 0xFFFFFFFB;
              label144:
              onChanged();
            }
            label148:
            if (this.bRi != null) {
              break label747;
            }
            if (!k.a.d(parama).isEmpty())
            {
              if (!this.bQW.isEmpty()) {
                break label726;
              }
              this.bQW = k.a.d(parama);
              this.bQS &= 0xFFFFFFF7;
              label198:
              onChanged();
            }
            label202:
            if (this.bRj != null) {
              break label861;
            }
            if (!k.a.e(parama).isEmpty())
            {
              if (!this.bQX.isEmpty()) {
                break label840;
              }
              this.bQX = k.a.e(parama);
              this.bQS &= 0xFFFFFFEF;
              label252:
              onChanged();
            }
            label256:
            if (this.bRk != null) {
              break label975;
            }
            if (!k.a.f(parama).isEmpty())
            {
              if (!this.bQY.isEmpty()) {
                break label954;
              }
              this.bQY = k.a.f(parama);
              this.bQS &= 0xFFFFFFDF;
              label306:
              onChanged();
            }
            label310:
            if (this.bRl != null) {
              break label1089;
            }
            if (!k.a.g(parama).isEmpty())
            {
              if (!this.bQZ.isEmpty()) {
                break label1068;
              }
              this.bQZ = k.a.g(parama);
              this.bQS &= 0xFFFFFFBF;
              label360:
              onChanged();
            }
            label364:
            if (parama.Cj()) {
              a(parama.Ck());
            }
            if (this.bRn != null) {
              break label1203;
            }
            if (!k.a.h(parama).isEmpty())
            {
              if (!this.bRb.isEmpty()) {
                break label1182;
              }
              this.bRb = k.a.h(parama);
              this.bQS &= 0xFFFFFEFF;
              label431:
              onChanged();
            }
            label435:
            if (!k.a.i(parama).isEmpty())
            {
              if (!this.bRc.isEmpty()) {
                break label1294;
              }
              this.bRc = k.a.i(parama);
              this.bQS &= 0xFFFFFDFF;
            }
          }
        }
        for (;;)
        {
          onChanged();
          c(parama.bVW);
          onChanged();
          return this;
          Cy();
          this.bQU.addAll(k.a.b(parama));
          break;
          if (k.a.b(parama).isEmpty()) {
            break label94;
          }
          Object localObject1;
          if (this.bRg.isEmpty())
          {
            this.bRg.cat = null;
            this.bRg = null;
            this.bQU = k.a.b(parama);
            this.bQS &= 0xFFFFFFFD;
            if (bb.bXS) {}
            for (localObject1 = Cz();; localObject1 = null)
            {
              this.bRg = ((co)localObject1);
              break;
            }
          }
          this.bRg.a(k.a.b(parama));
          break label94;
          label612:
          CA();
          this.bQV.addAll(k.a.c(parama));
          break label144;
          label633:
          if (k.a.c(parama).isEmpty()) {
            break label148;
          }
          if (this.bRh.isEmpty())
          {
            this.bRh.cat = null;
            this.bRh = null;
            this.bQV = k.a.c(parama);
            this.bQS &= 0xFFFFFFFB;
            if (bb.bXS) {}
            for (localObject1 = CB();; localObject1 = null)
            {
              this.bRh = ((co)localObject1);
              break;
            }
          }
          this.bRh.a(k.a.c(parama));
          break label148;
          label726:
          CC();
          this.bQW.addAll(k.a.d(parama));
          break label198;
          label747:
          if (k.a.d(parama).isEmpty()) {
            break label202;
          }
          if (this.bRi.isEmpty())
          {
            this.bRi.cat = null;
            this.bRi = null;
            this.bQW = k.a.d(parama);
            this.bQS &= 0xFFFFFFF7;
            if (bb.bXS) {}
            for (localObject1 = CD();; localObject1 = null)
            {
              this.bRi = ((co)localObject1);
              break;
            }
          }
          this.bRi.a(k.a.d(parama));
          break label202;
          label840:
          CE();
          this.bQX.addAll(k.a.e(parama));
          break label252;
          label861:
          if (k.a.e(parama).isEmpty()) {
            break label256;
          }
          if (this.bRj.isEmpty())
          {
            this.bRj.cat = null;
            this.bRj = null;
            this.bQX = k.a.e(parama);
            this.bQS &= 0xFFFFFFEF;
            if (bb.bXS) {}
            for (localObject1 = CF();; localObject1 = null)
            {
              this.bRj = ((co)localObject1);
              break;
            }
          }
          this.bRj.a(k.a.e(parama));
          break label256;
          label954:
          CG();
          this.bQY.addAll(k.a.f(parama));
          break label306;
          label975:
          if (k.a.f(parama).isEmpty()) {
            break label310;
          }
          if (this.bRk.isEmpty())
          {
            this.bRk.cat = null;
            this.bRk = null;
            this.bQY = k.a.f(parama);
            this.bQS &= 0xFFFFFFDF;
            if (bb.bXS) {}
            for (localObject1 = CH();; localObject1 = null)
            {
              this.bRk = ((co)localObject1);
              break;
            }
          }
          this.bRk.a(k.a.f(parama));
          break label310;
          label1068:
          CI();
          this.bQZ.addAll(k.a.g(parama));
          break label360;
          label1089:
          if (k.a.g(parama).isEmpty()) {
            break label364;
          }
          if (this.bRl.isEmpty())
          {
            this.bRl.cat = null;
            this.bRl = null;
            this.bQZ = k.a.g(parama);
            this.bQS &= 0xFFFFFFBF;
            if (bb.bXS) {}
            for (localObject1 = CJ();; localObject1 = null)
            {
              this.bRl = ((co)localObject1);
              break;
            }
          }
          this.bRl.a(k.a.g(parama));
          break label364;
          label1182:
          CL();
          this.bRb.addAll(k.a.h(parama));
          break label431;
          label1203:
          if (k.a.h(parama).isEmpty()) {
            break label435;
          }
          if (this.bRn.isEmpty())
          {
            this.bRn.cat = null;
            this.bRn = null;
            this.bRb = k.a.h(parama);
            this.bQS &= 0xFFFFFEFF;
            localObject1 = localObject2;
            if (bb.bXS) {
              localObject1 = CM();
            }
            this.bRn = ((co)localObject1);
            break label435;
          }
          this.bRn.a(k.a.h(parama));
          break label435;
          label1294:
          CN();
          this.bRc.addAll(k.a.i(parama));
        }
      }
    }
    
    public static final class b
      extends bb
      implements l
    {
      @Deprecated
      public static final ci<b> bRf = new c() {};
      private static final b bRr = new b();
      private int bQS;
      private byte bRd = -1;
      int bRo;
      int bRp;
      private k.f bRq;
      
      private b() {}
      
      private b(bb.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 35	com/google/b/k$a$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 58	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 59	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 65	com/google/b/da:Jj	()Lcom/google/b/da$a;
        //   19: astore 6
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +223 -> 247
        //   27: aload_1
        //   28: invokevirtual 71	com/google/b/h:Av	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+235->270, 0:+241->276, 8:+59->94, 16:+104->139, 26:+142->177
        //   77: aload_1
        //   78: aload 6
        //   80: aload_2
        //   81: iload 4
        //   83: invokevirtual 74	com/google/b/k$a$b:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
        //   86: ifne +175 -> 261
        //   89: iconst_1
        //   90: istore_3
        //   91: goto +182 -> 273
        //   94: aload_0
        //   95: aload_0
        //   96: getfield 76	com/google/b/k$a$b:bQS	I
        //   99: iconst_1
        //   100: ior
        //   101: putfield 76	com/google/b/k$a$b:bQS	I
        //   104: aload_0
        //   105: aload_1
        //   106: invokevirtual 79	com/google/b/h:Ay	()I
        //   109: putfield 81	com/google/b/k$a$b:bRo	I
        //   112: goto -89 -> 23
        //   115: astore_1
        //   116: aload_1
        //   117: aload_0
        //   118: putfield 85	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   121: aload_1
        //   122: athrow
        //   123: astore_1
        //   124: aload_0
        //   125: aload 6
        //   127: invokevirtual 91	com/google/b/da$a:Jm	()Lcom/google/b/da;
        //   130: putfield 95	com/google/b/k$a$b:bVW	Lcom/google/b/da;
        //   133: aload_0
        //   134: invokevirtual 98	com/google/b/k$a$b:HZ	()V
        //   137: aload_1
        //   138: athrow
        //   139: aload_0
        //   140: aload_0
        //   141: getfield 76	com/google/b/k$a$b:bQS	I
        //   144: iconst_2
        //   145: ior
        //   146: putfield 76	com/google/b/k$a$b:bQS	I
        //   149: aload_0
        //   150: aload_1
        //   151: invokevirtual 79	com/google/b/h:Ay	()I
        //   154: putfield 100	com/google/b/k$a$b:bRp	I
        //   157: goto -134 -> 23
        //   160: astore_1
        //   161: new 54	com/google/b/bf
        //   164: dup
        //   165: aload_1
        //   166: invokespecial 103	com/google/b/bf:<init>	(Ljava/io/IOException;)V
        //   169: astore_1
        //   170: aload_1
        //   171: aload_0
        //   172: putfield 85	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   175: aload_1
        //   176: athrow
        //   177: aload_0
        //   178: getfield 76	com/google/b/k$a$b:bQS	I
        //   181: iconst_4
        //   182: iand
        //   183: ifeq +81 -> 264
        //   186: aload_0
        //   187: getfield 105	com/google/b/k$a$b:bRq	Lcom/google/b/k$f;
        //   190: invokevirtual 111	com/google/b/k$f:DK	()Lcom/google/b/k$f$a;
        //   193: astore 5
        //   195: aload_0
        //   196: aload_1
        //   197: getstatic 112	com/google/b/k$f:bRf	Lcom/google/b/ci;
        //   200: aload_2
        //   201: invokevirtual 115	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
        //   204: checkcast 107	com/google/b/k$f
        //   207: putfield 105	com/google/b/k$a$b:bRq	Lcom/google/b/k$f;
        //   210: aload 5
        //   212: ifnull +22 -> 234
        //   215: aload 5
        //   217: aload_0
        //   218: getfield 105	com/google/b/k$a$b:bRq	Lcom/google/b/k$f;
        //   221: invokevirtual 121	com/google/b/k$f$a:d	(Lcom/google/b/k$f;)Lcom/google/b/k$f$a;
        //   224: pop
        //   225: aload_0
        //   226: aload 5
        //   228: invokevirtual 125	com/google/b/k$f$a:DN	()Lcom/google/b/k$f;
        //   231: putfield 105	com/google/b/k$a$b:bRq	Lcom/google/b/k$f;
        //   234: aload_0
        //   235: aload_0
        //   236: getfield 76	com/google/b/k$a$b:bQS	I
        //   239: iconst_4
        //   240: ior
        //   241: putfield 76	com/google/b/k$a$b:bQS	I
        //   244: goto -221 -> 23
        //   247: aload_0
        //   248: aload 6
        //   250: invokevirtual 91	com/google/b/da$a:Jm	()Lcom/google/b/da;
        //   253: putfield 95	com/google/b/k$a$b:bVW	Lcom/google/b/da;
        //   256: aload_0
        //   257: invokevirtual 98	com/google/b/k$a$b:HZ	()V
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
        //   0	281	2	paramap	ap
        //   22	256	3	i	int
        //   31	51	4	j	int
        //   193	73	5	locala	k.f.a
        //   19	230	6	locala1	da.a
        // Exception table:
        //   from	to	target	type
        //   27	33	115	com/google/b/bf
        //   76	89	115	com/google/b/bf
        //   94	112	115	com/google/b/bf
        //   139	157	115	com/google/b/bf
        //   177	195	115	com/google/b/bf
        //   195	210	115	com/google/b/bf
        //   215	234	115	com/google/b/bf
        //   234	244	115	com/google/b/bf
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
      
      public static a CV()
      {
        return bRr.CW();
      }
      
      private a CW()
      {
        if (this == bRr) {
          return new a((byte)0);
        }
        return new a((byte)0).b(this);
      }
      
      public static b CX()
      {
        return bRr;
      }
      
      public final int Ad()
      {
        int i = this.bOZ;
        if (i != -1) {
          return i;
        }
        int j = 0;
        if ((this.bQS & 0x1) != 0) {
          j = i.bM(1, this.bRo) + 0;
        }
        i = j;
        if ((this.bQS & 0x2) != 0) {
          i = j + i.bM(2, this.bRp);
        }
        j = i;
        if ((this.bQS & 0x4) != 0) {
          j = i + i.c(3, CU());
        }
        i = j + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
      
      public final boolean CT()
      {
        return (this.bQS & 0x1) != 0;
      }
      
      public final k.f CU()
      {
        if (this.bRq == null) {
          return k.f.DL();
        }
        return this.bRq;
      }
      
      public final da Ca()
      {
        return this.bVW;
      }
      
      protected final bb.e Cb()
      {
        return k.Bj().b(b.class, a.class);
      }
      
      public final boolean Cj()
      {
        return (this.bQS & 0x4) != 0;
      }
      
      public final ci<b> Co()
      {
        return bRf;
      }
      
      public final void a(i parami)
      {
        if ((this.bQS & 0x1) != 0) {
          parami.bJ(1, this.bRo);
        }
        if ((this.bQS & 0x2) != 0) {
          parami.bJ(2, this.bRp);
        }
        if ((this.bQS & 0x4) != 0) {
          parami.a(3, CU());
        }
        this.bVW.a(parami);
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
          if (CT() != paramObject.CT()) {
            return false;
          }
          if ((CT()) && (this.bRo != paramObject.bRo)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.bRp != paramObject.bRp)) {
            return false;
          }
          if (Cj() != paramObject.Cj()) {
            return false;
          }
          if ((Cj()) && (!CU().equals(paramObject.CU()))) {
            return false;
          }
        } while (this.bVW.equals(paramObject.bVW));
        return false;
      }
      
      public final boolean hasEnd()
      {
        return (this.bQS & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.bPa != 0) {
          return this.bPa;
        }
        int j = k.Bi().hashCode() + 779;
        int i = j;
        if (CT()) {
          i = (j * 37 + 1) * 53 + this.bRo;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.bRp;
        }
        i = j;
        if (Cj()) {
          i = (j * 37 + 3) * 53 + CU().hashCode();
        }
        i = i * 29 + this.bVW.hashCode();
        this.bPa = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bRd;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        if ((Cj()) && (!CU().isInitialized()))
        {
          this.bRd = 0;
          return false;
        }
        this.bRd = 1;
        return true;
      }
      
      public static final class a
        extends bb.a<a>
        implements l
      {
        private int bQS;
        private cs<k.f, k.f.a, t> bRm;
        private int bRo;
        private int bRp;
        private k.f bRq;
        
        private a()
        {
          Cu();
        }
        
        private a(bb.b paramb)
        {
          super();
          Cu();
        }
        
        private cs<k.f, k.f.a, t> CK()
        {
          if (this.bRm == null)
          {
            this.bRm = new cs(CU(), Ie(), Ic());
            this.bRq = null;
          }
          return this.bRm;
        }
        
        private k.f CU()
        {
          if (this.bRm == null)
          {
            if (this.bRq == null) {
              return k.f.DL();
            }
            return this.bRq;
          }
          return (k.f)this.bRm.IU();
        }
        
        private k.a.b CZ()
        {
          int i = 0;
          k.a.b localb = new k.a.b(this, (byte)0);
          int k = this.bQS;
          if ((k & 0x1) != 0)
          {
            k.a.b.a(localb, this.bRo);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            k.a.b.b(localb, this.bRp);
            j = i | 0x2;
          }
          if ((k & 0x4) != 0) {
            if (this.bRm == null) {
              k.a.b.a(localb, this.bRq);
            }
          }
          for (i = j | 0x4;; i = j)
          {
            k.a.b.c(localb, i);
            Ib();
            return localb;
            k.a.b.a(localb, (k.f)this.bRm.IV());
            break;
          }
        }
        
        private void Cu()
        {
          if (bb.bXS) {
            CK();
          }
        }
        
        private a a(k.f paramf)
        {
          if (this.bRm == null) {
            if (((this.bQS & 0x4) != 0) && (this.bRq != null) && (this.bRq != k.f.DL()))
            {
              this.bRq = k.f.b(this.bRq).d(paramf).DN();
              onChanged();
            }
          }
          for (;;)
          {
            this.bQS |= 0x4;
            return this;
            this.bRq = paramf;
            break;
            this.bRm.c(paramf);
          }
        }
        
        private a e(bt parambt)
        {
          if ((parambt instanceof k.a.b)) {
            return b((k.a.b)parambt);
          }
          super.a(parambt);
          return this;
        }
        
        /* Error */
        private a f(h paramh, ap paramap)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 143	com/google/b/k$a$b:bRf	Lcom/google/b/ci;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 148 3 0
          //   12: checkcast 14	com/google/b/k$a$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 132	com/google/b/k$a$b$a:b	(Lcom/google/b/k$a$b;)Lcom/google/b/k$a$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 152	com/google/b/bf:bZj	Lcom/google/b/bw;
          //   33: checkcast 14	com/google/b/k$a$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 156	com/google/b/bf:Im	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 132	com/google/b/k$a$b$a:b	(Lcom/google/b/k$a$b;)Lcom/google/b/k$a$b$a;
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
          //   0	61	2	paramap	ap
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/b/bf
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a g(aj.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a g(da paramda)
        {
          return (a)super.e(paramda);
        }
        
        private a h(aj.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        private a h(da paramda)
        {
          return (a)super.d(paramda);
        }
        
        public final k.a.b CY()
        {
          k.a.b localb = CZ();
          if (!localb.isInitialized()) {
            throw b(localb);
          }
          return localb;
        }
        
        protected final bb.e Cb()
        {
          return k.Bj().b(k.a.b.class, a.class);
        }
        
        public final aj.a Cv()
        {
          return k.Bi();
        }
        
        public final a b(k.a.b paramb)
        {
          if (paramb == k.a.b.CX()) {
            return this;
          }
          if (paramb.CT()) {
            gX(paramb.bRo);
          }
          if (paramb.hasEnd()) {
            gY(paramb.bRp);
          }
          if (paramb.Cj()) {
            a(paramb.CU());
          }
          h(paramb.bVW);
          onChanged();
          return this;
        }
        
        public final a gX(int paramInt)
        {
          this.bQS |= 0x1;
          this.bRo = paramInt;
          onChanged();
          return this;
        }
        
        public final a gY(int paramInt)
        {
          this.bQS |= 0x2;
          this.bRp = paramInt;
          onChanged();
          return this;
        }
        
        public final boolean isInitialized()
        {
          if ((this.bQS & 0x4) != 0) {}
          for (int i = 1; (i != 0) && (!CU().isInitialized()); i = 0) {
            return false;
          }
          return true;
        }
      }
    }
  }
  
  public static final class b
    extends bb
    implements p
  {
    @Deprecated
    public static final ci<b> bRf = new c() {};
    private static final b bRv = new b();
    private int bQS;
    private volatile Object bQT;
    private List<k.b.b> bRb;
    private bk bRc;
    private byte bRd = -1;
    private List<k.d> bRt;
    private k.c bRu;
    
    private b()
    {
      this.bQT = "";
      this.bRt = Collections.emptyList();
      this.bRb = Collections.emptyList();
      this.bRc = bj.bZD;
    }
    
    private b(bb.a<?> parama)
    {
      super();
    }
    
    private b(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            n = paramh.Av();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (a(paramh, locala, paramap, n)) {
                break label722;
              }
              j = 1;
              break label738;
              k = i;
              m = i;
              j = i;
              localObject = paramh.AD();
              k = i;
              m = i;
              j = i;
              this.bQS |= 0x1;
              k = i;
              m = i;
              j = i;
              this.bQT = localObject;
              break label26;
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally
            {
              j = k;
              if ((j & 0x2) != 0) {
                this.bRt = Collections.unmodifiableList(this.bRt);
              }
              if ((j & 0x8) != 0) {
                this.bRb = Collections.unmodifiableList(this.bRb);
              }
              if ((j & 0x10) != 0) {
                this.bRc = this.bRc.Ix();
              }
              this.bVW = locala.Jm();
              HZ();
            }
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRt = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.bRt.add(paramh.a(k.d.bRf, paramap));
            i = n;
            break;
          }
          catch (IOException paramh)
          {
            j = m;
            paramh = new bf(paramh);
            j = m;
            paramh.bZj = this;
            j = m;
            throw paramh;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            if ((this.bQS & 0x2) == 0) {
              break label729;
            }
          }
          k = i;
          m = i;
          j = i;
          label722:
          label729:
          for (Object localObject = this.bRu.Dt();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.bRu = ((k.c)paramh.a(k.c.bRf, paramap));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((k.c.a)localObject).d(this.bRu);
              k = i;
              m = i;
              j = i;
              this.bRu = ((k.c.a)localObject).Dw();
            }
            k = i;
            m = i;
            j = i;
            this.bQS |= 0x2;
            break;
            n = i;
            if ((i & 0x8) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRb = new ArrayList();
              n = i | 0x8;
            }
            k = n;
            m = n;
            j = n;
            this.bRb.add(paramh.a(k.b.b.bRf, paramap));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            localObject = paramh.AD();
            n = i;
            if ((i & 0x10) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bRc = new bj();
              n = i | 0x10;
            }
            k = n;
            m = n;
            j = n;
            this.bRc.d((g)localObject);
            i = n;
            break;
            if ((i & 0x2) != 0) {
              this.bRt = Collections.unmodifiableList(this.bRt);
            }
            if ((i & 0x8) != 0) {
              this.bRb = Collections.unmodifiableList(this.bRb);
            }
            if ((i & 0x10) != 0) {
              this.bRc = this.bRc.Ix();
            }
            this.bVW = locala.Jm();
            HZ();
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
    
    private a Dg()
    {
      if (this == bRv) {
        return new a((byte)0);
      }
      return new a((byte)0).e(this);
    }
    
    public static b Dh()
    {
      return bRv;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {}
      for (i = bb.f(1, this.bQT) + 0;; i = 0)
      {
        int j = 0;
        while (j < this.bRt.size())
        {
          i += i.c(2, (bw)this.bRt.get(j));
          j += 1;
        }
        j = i;
        if ((this.bQS & 0x2) != 0) {
          j = i + i.c(3, Df());
        }
        i = 0;
        while (i < this.bRb.size())
        {
          j += i.c(4, (bw)this.bRb.get(i));
          i += 1;
        }
        i = 0;
        int k = 0;
        while (i < this.bRc.size())
        {
          k += ao(this.bRc.getRaw(i));
          i += 1;
        }
        i = j + k + this.bRc.size() * 1 + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Bt().b(b.class, a.class);
    }
    
    public final boolean Cc()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Cj()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final ci<b> Co()
    {
      return bRf;
    }
    
    public final int De()
    {
      return this.bRt.size();
    }
    
    public final k.c Df()
    {
      if (this.bRu == null) {
        return k.c.Du();
      }
      return this.bRu;
    }
    
    public final void a(i parami)
    {
      int k = 0;
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bQT);
      }
      int i = 0;
      while (i < this.bRt.size())
      {
        parami.a(2, (bw)this.bRt.get(i));
        i += 1;
      }
      if ((this.bQS & 0x2) != 0) {
        parami.a(3, Df());
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.bRb.size()) {
          break;
        }
        parami.a(4, (bw)this.bRb.get(i));
        i += 1;
      }
      while (j < this.bRc.size())
      {
        bb.a(parami, 5, this.bRc.getRaw(j));
        j += 1;
      }
      this.bVW.a(parami);
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
        if (Cc() != paramObject.Cc()) {
          return false;
        }
        if ((Cc()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.bRt.equals(paramObject.bRt)) {
          return false;
        }
        if (Cj() != paramObject.Cj()) {
          return false;
        }
        if ((Cj()) && (!Df().equals(paramObject.Df()))) {
          return false;
        }
        if (!this.bRb.equals(paramObject.bRb)) {
          return false;
        }
        if (!this.bRc.equals(paramObject.bRc)) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bQT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bQT = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Bs().hashCode() + 779;
      int i = j;
      if (Cc()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (De() > 0) {
        j = (i * 37 + 2) * 53 + this.bRt.hashCode();
      }
      i = j;
      if (Cj()) {
        i = (j * 37 + 3) * 53 + Df().hashCode();
      }
      j = i;
      if (this.bRb.size() > 0) {
        j = (i * 37 + 4) * 53 + this.bRb.hashCode();
      }
      i = j;
      if (this.bRc.size() > 0) {
        i = (j * 37 + 5) * 53 + this.bRc.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final k.d hb(int paramInt)
    {
      return (k.d)this.bRt.get(paramInt);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < De())
      {
        if (!hb(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if ((Cj()) && (!Df().isInitialized()))
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements p
    {
      private int bQS;
      private Object bQT = "";
      private List<k.b.b> bRb = Collections.emptyList();
      private bk bRc = bj.bZD;
      private cs<k.c, k.c.a, q> bRm;
      private co<k.b.b, k.b.b.a, o> bRn;
      private List<k.d> bRt = Collections.emptyList();
      private k.c bRu;
      private co<k.d, k.d.a, r> bRw;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private cs<k.c, k.c.a, q> CK()
      {
        if (this.bRm == null)
        {
          this.bRm = new cs(Df(), Ie(), Ic());
          this.bRu = null;
        }
        return this.bRm;
      }
      
      private void CL()
      {
        if ((this.bQS & 0x8) == 0)
        {
          this.bRb = new ArrayList(this.bRb);
          this.bQS |= 0x8;
        }
      }
      
      private co<k.b.b, k.b.b.a, o> CM()
      {
        List localList;
        if (this.bRn == null)
        {
          localList = this.bRb;
          if ((this.bQS & 0x8) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRn = new co(localList, bool, Ie(), Ic());
          this.bRb = null;
          return this.bRn;
        }
      }
      
      private void CN()
      {
        if ((this.bQS & 0x10) == 0)
        {
          this.bRc = new bj(this.bRc);
          this.bQS |= 0x10;
        }
      }
      
      private void Cu()
      {
        if (bb.bXS)
        {
          Dl();
          CK();
          CM();
        }
      }
      
      private k.c Df()
      {
        if (this.bRm == null)
        {
          if (this.bRu == null) {
            return k.c.Du();
          }
          return this.bRu;
        }
        return (k.c)this.bRm.IU();
      }
      
      private k.b Di()
      {
        k.b localb = Dj();
        if (!localb.isInitialized()) {
          throw b(localb);
        }
        return localb;
      }
      
      private k.b Dj()
      {
        k.b localb = new k.b(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          k.b.a(localb, this.bQT);
          int j;
          if (this.bRw == null)
          {
            if ((this.bQS & 0x2) != 0)
            {
              this.bRt = Collections.unmodifiableList(this.bRt);
              this.bQS &= 0xFFFFFFFD;
            }
            k.b.a(localb, this.bRt);
            j = i;
            if ((k & 0x4) != 0)
            {
              if (this.bRm != null) {
                break label234;
              }
              k.b.a(localb, this.bRu);
              label107:
              j = i | 0x2;
            }
            if (this.bRn != null) {
              break label253;
            }
            if ((this.bQS & 0x8) != 0)
            {
              this.bRb = Collections.unmodifiableList(this.bRb);
              this.bQS &= 0xFFFFFFF7;
            }
            k.b.b(localb, this.bRb);
          }
          for (;;)
          {
            if ((this.bQS & 0x10) != 0)
            {
              this.bRc = this.bRc.Ix();
              this.bQS &= 0xFFFFFFEF;
            }
            k.b.a(localb, this.bRc);
            k.b.a(localb, j);
            Ib();
            return localb;
            k.b.a(localb, this.bRw.build());
            break;
            label234:
            k.b.a(localb, (k.c)this.bRm.IV());
            break label107;
            label253:
            k.b.b(localb, this.bRn.build());
          }
        }
      }
      
      private void Dk()
      {
        if ((this.bQS & 0x2) == 0)
        {
          this.bRt = new ArrayList(this.bRt);
          this.bQS |= 0x2;
        }
      }
      
      private co<k.d, k.d.a, r> Dl()
      {
        List localList;
        if (this.bRw == null)
        {
          localList = this.bRt;
          if ((this.bQS & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRw = new co(localList, bool, Ie(), Ic());
          this.bRt = null;
          return this.bRw;
        }
      }
      
      private a a(k.c paramc)
      {
        if (this.bRm == null) {
          if (((this.bQS & 0x4) != 0) && (this.bRu != null) && (this.bRu != k.c.Du()))
          {
            this.bRu = k.c.b(this.bRu).d(paramc).Dw();
            onChanged();
          }
        }
        for (;;)
        {
          this.bQS |= 0x4;
          return this;
          this.bRu = paramc;
          break;
          this.bRm.c(paramc);
        }
      }
      
      private a g(bt parambt)
      {
        if ((parambt instanceof k.b)) {
          return e((k.b)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a h(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 229	com/google/b/k$b:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 234 3 0
        //   12: checkcast 9	com/google/b/k$b
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 218	com/google/b/k$b$a:e	(Lcom/google/b/k$b;)Lcom/google/b/k$b$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 238	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$b
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 242	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 218	com/google/b/k$b$a:e	(Lcom/google/b/k$b;)Lcom/google/b/k$b$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a k(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a k(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a l(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a l(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      protected final bb.e Cb()
      {
        return k.Bt().b(k.b.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.Bs();
      }
      
      public final a e(k.b paramb)
      {
        Object localObject2 = null;
        if (paramb == k.b.Dh()) {
          return this;
        }
        if (paramb.Cc())
        {
          this.bQS |= 0x1;
          this.bQT = k.b.a(paramb);
          onChanged();
        }
        if (this.bRw == null) {
          if (!k.b.b(paramb).isEmpty())
          {
            if (this.bRt.isEmpty())
            {
              this.bRt = k.b.b(paramb);
              this.bQS &= 0xFFFFFFFD;
              onChanged();
            }
          }
          else
          {
            label94:
            if (paramb.Cj()) {
              a(paramb.Df());
            }
            if (this.bRn != null) {
              break label361;
            }
            if (!k.b.c(paramb).isEmpty())
            {
              if (!this.bRb.isEmpty()) {
                break label340;
              }
              this.bRb = k.b.c(paramb);
              this.bQS &= 0xFFFFFFF7;
              label160:
              onChanged();
            }
            label164:
            if (!k.b.d(paramb).isEmpty())
            {
              if (!this.bRc.isEmpty()) {
                break label451;
              }
              this.bRc = k.b.d(paramb);
              this.bQS &= 0xFFFFFFEF;
            }
          }
        }
        for (;;)
        {
          onChanged();
          l(paramb.bVW);
          onChanged();
          return this;
          Dk();
          this.bRt.addAll(k.b.b(paramb));
          break;
          if (k.b.b(paramb).isEmpty()) {
            break label94;
          }
          Object localObject1;
          if (this.bRw.isEmpty())
          {
            this.bRw.cat = null;
            this.bRw = null;
            this.bRt = k.b.b(paramb);
            this.bQS &= 0xFFFFFFFD;
            if (bb.bXS) {}
            for (localObject1 = Dl();; localObject1 = null)
            {
              this.bRw = ((co)localObject1);
              break;
            }
          }
          this.bRw.a(k.b.b(paramb));
          break label94;
          label340:
          CL();
          this.bRb.addAll(k.b.c(paramb));
          break label160;
          label361:
          if (k.b.c(paramb).isEmpty()) {
            break label164;
          }
          if (this.bRn.isEmpty())
          {
            this.bRn.cat = null;
            this.bRn = null;
            this.bRb = k.b.c(paramb);
            this.bQS &= 0xFFFFFFF7;
            localObject1 = localObject2;
            if (bb.bXS) {
              localObject1 = CM();
            }
            this.bRn = ((co)localObject1);
            break label164;
          }
          this.bRn.a(k.b.c(paramb));
          break label164;
          label451:
          CN();
          this.bRc.addAll(k.b.d(paramb));
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        k.d locald;
        if (this.bRw == null)
        {
          j = this.bRt.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRw != null) {
            break label65;
          }
          locald = (k.d)this.bRt.get(i);
          label45:
          if (locald.isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bRw.getCount();
          break label19;
          label65:
          locald = (k.d)this.bRw.u(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          if ((this.bQS & 0x4) != 0) {}
          for (i = 1; (i == 0) || (Df().isInitialized()); i = 0) {
            return true;
          }
        }
      }
    }
  }
  
  public static final class c
    extends bb.d<c>
    implements q
  {
    private static final c bRB = new c();
    @Deprecated
    public static final ci<c> bRf = new c() {};
    private int bQS;
    private List<k.s> bRA;
    private byte bRd = -1;
    boolean bRy;
    boolean bRz;
    
    private c()
    {
      this.bRA = Collections.emptyList();
    }
    
    private c(bb.c<c, ?> paramc)
    {
      super();
    }
    
    private c(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            j = paramh.Av();
            switch (j)
            {
            case 16: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramap, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bQS |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bRy = paramh.AB();
              break label26;
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x4) != 0) {
                this.bRA = Collections.unmodifiableList(this.bRA);
              }
              this.bVW = locala.Jm();
              this.bXY.Al();
            }
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bRz = paramh.AB();
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new bf(paramh);
            k = i1;
            paramh.bZj = this;
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
              this.bRA = new ArrayList();
              j = i | 0x4;
            }
            n = j;
            i1 = j;
            k = j;
            this.bRA.add(paramh.a(k.s.bRf, paramap));
            i = j;
          }
          break;
          if ((i & 0x4) != 0) {
            this.bRA = Collections.unmodifiableList(this.bRA);
          }
          this.bVW = locala.Jm();
          this.bXY.Al();
          return;
        }
        m = 1;
      }
    }
    
    private int Ds()
    {
      return this.bRA.size();
    }
    
    public static c Du()
    {
      return bRB;
    }
    
    public static a b(c paramc)
    {
      return bRB.Dt().d(paramc);
    }
    
    public final int Ad()
    {
      int k = 0;
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {}
      for (i = i.gK(2) + 0;; i = 0)
      {
        int j = i;
        if ((this.bQS & 0x2) != 0) {
          j = i + i.gK(3);
        }
        i = j;
        j = k;
        while (j < this.bRA.size())
        {
          k = i.c(999, (bw)this.bRA.get(j));
          j += 1;
          i = k + i;
        }
        i = Ii() + i + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BL().b(c.class, a.class);
    }
    
    public final ci<c> Co()
    {
      return bRf;
    }
    
    public final boolean Dq()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Dr()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final a Dt()
    {
      if (this == bRB) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      bb.d.a locala = Ih();
      if ((this.bQS & 0x1) != 0) {
        parami.t(2, this.bRy);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.t(3, this.bRz);
      }
      int i = 0;
      while (i < this.bRA.size())
      {
        parami.a(999, (bw)this.bRA.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bVW.a(parami);
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
        if (Dq() != paramObject.Dq()) {
          return false;
        }
        if ((Dq()) && (this.bRy != paramObject.bRy)) {
          return false;
        }
        if (Dr() != paramObject.Dr()) {
          return false;
        }
        if ((Dr()) && (this.bRz != paramObject.bRz)) {
          return false;
        }
        if (!this.bRA.equals(paramObject.bRA)) {
          return false;
        }
        if (!this.bVW.equals(paramObject.bVW)) {
          return false;
        }
      } while (Ij().equals(paramObject.Ij()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BK().hashCode() + 779;
      int i = j;
      if (Dq()) {
        i = (j * 37 + 2) * 53 + be.bS(this.bRy);
      }
      j = i;
      if (Dr()) {
        j = (i * 37 + 3) * 53 + be.bS(this.bRz);
      }
      i = j;
      if (Ds() > 0) {
        i = (j * 37 + 999) * 53 + this.bRA.hashCode();
      }
      i = a(i, Ij()) * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ds())
      {
        if (!((k.s)this.bRA.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.c<k.c, a>
      implements q
    {
      private int bQS;
      private List<k.s> bRA = Collections.emptyList();
      private co<k.s, k.s.a, ai> bRC;
      private boolean bRy;
      private boolean bRz;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Dy();
        }
      }
      
      private k.c Dv()
      {
        k.c localc = Dw();
        if (!localc.isInitialized()) {
          throw b(localc);
        }
        return localc;
      }
      
      private void Dx()
      {
        if ((this.bQS & 0x4) == 0)
        {
          this.bRA = new ArrayList(this.bRA);
          this.bQS |= 0x4;
        }
      }
      
      private co<k.s, k.s.a, ai> Dy()
      {
        List localList;
        if (this.bRC == null)
        {
          localList = this.bRA;
          if ((this.bQS & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRC = new co(localList, bool, Ie(), Ic());
          this.bRA = null;
          return this.bRC;
        }
      }
      
      private a bs(boolean paramBoolean)
      {
        this.bQS |= 0x1;
        this.bRy = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bt(boolean paramBoolean)
      {
        this.bQS |= 0x2;
        this.bRz = paramBoolean;
        onChanged();
        return this;
      }
      
      private a i(bt parambt)
      {
        if ((parambt instanceof k.c)) {
          return d((k.c)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a j(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 120	com/google/b/k$c:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 125 3 0
        //   12: checkcast 9	com/google/b/k$c
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 109	com/google/b/k$c$a:d	(Lcom/google/b/k$c;)Lcom/google/b/k$c$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 129	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$c
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 133	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 109	com/google/b/k$c$a:d	(Lcom/google/b/k$c;)Lcom/google/b/k$c$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a o(aj.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a o(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a p(aj.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a p(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      protected final bb.e Cb()
      {
        return k.BL().b(k.c.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BK();
      }
      
      public final k.c Dw()
      {
        int i = 0;
        k.c localc = new k.c(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0)
        {
          k.c.a(localc, this.bRy);
          i = 1;
        }
        int j = i;
        if ((k & 0x2) != 0)
        {
          k.c.b(localc, this.bRz);
          j = i | 0x2;
        }
        if (this.bRC == null)
        {
          if ((this.bQS & 0x4) != 0)
          {
            this.bRA = Collections.unmodifiableList(this.bRA);
            this.bQS &= 0xFFFFFFFB;
          }
          k.c.a(localc, this.bRA);
        }
        for (;;)
        {
          k.c.a(localc, j);
          Ib();
          return localc;
          k.c.a(localc, this.bRC.build());
        }
      }
      
      public final a d(k.c paramc)
      {
        co localco = null;
        if (paramc == k.c.Du()) {
          return this;
        }
        if (paramc.Dq()) {
          bs(paramc.bRy);
        }
        if (paramc.Dr()) {
          bt(paramc.bRz);
        }
        if (this.bRC == null) {
          if (!k.c.c(paramc).isEmpty())
          {
            if (!this.bRA.isEmpty()) {
              break label117;
            }
            this.bRA = k.c.c(paramc);
            this.bQS &= 0xFFFFFFFB;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramc);
          p(paramc.bVW);
          onChanged();
          return this;
          label117:
          Dx();
          this.bRA.addAll(k.c.c(paramc));
          break;
          if (!k.c.c(paramc).isEmpty()) {
            if (this.bRC.isEmpty())
            {
              this.bRC.cat = null;
              this.bRC = null;
              this.bRA = k.c.c(paramc);
              this.bQS &= 0xFFFFFFFB;
              if (bb.bXS) {
                localco = Dy();
              }
              this.bRC = localco;
            }
            else
            {
              this.bRC.a(k.c.c(paramc));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bRC == null)
        {
          j = this.bRA.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRC != null) {
            break label65;
          }
          locals = (k.s)this.bRA.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!Ig())
        {
          for (;;)
          {
            return false;
            j = this.bRC.getCount();
            break;
            k.s locals = (k.s)this.bRC.u(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class d
    extends bb
    implements r
  {
    private static final d bRF = new d();
    @Deprecated
    public static final ci<d> bRf = new c() {};
    private int bQS;
    private volatile Object bQT;
    int bRD;
    private k.e bRE;
    private byte bRd = -1;
    
    private d()
    {
      this.bQT = "";
    }
    
    private d(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private d(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 34	com/google/b/k$d:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 61	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 62	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 68	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +227 -> 251
      //   27: aload_1
      //   28: invokevirtual 74	com/google/b/h:Av	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+239->274, 0:+245->280, 10:+59->94, 16:+108->143, 26:+146->181
      //   77: aload_1
      //   78: aload 6
      //   80: aload_2
      //   81: iload 4
      //   83: invokevirtual 77	com/google/b/k$d:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   86: ifne +179 -> 265
      //   89: iconst_1
      //   90: istore_3
      //   91: goto +186 -> 277
      //   94: aload_1
      //   95: invokevirtual 81	com/google/b/h:AD	()Lcom/google/b/g;
      //   98: astore 5
      //   100: aload_0
      //   101: aload_0
      //   102: getfield 83	com/google/b/k$d:bQS	I
      //   105: iconst_1
      //   106: ior
      //   107: putfield 83	com/google/b/k$d:bQS	I
      //   110: aload_0
      //   111: aload 5
      //   113: putfield 47	com/google/b/k$d:bQT	Ljava/lang/Object;
      //   116: goto -93 -> 23
      //   119: astore_1
      //   120: aload_1
      //   121: aload_0
      //   122: putfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: aload_0
      //   129: aload 6
      //   131: invokevirtual 93	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   134: putfield 97	com/google/b/k$d:bVW	Lcom/google/b/da;
      //   137: aload_0
      //   138: invokevirtual 100	com/google/b/k$d:HZ	()V
      //   141: aload_1
      //   142: athrow
      //   143: aload_0
      //   144: aload_0
      //   145: getfield 83	com/google/b/k$d:bQS	I
      //   148: iconst_2
      //   149: ior
      //   150: putfield 83	com/google/b/k$d:bQS	I
      //   153: aload_0
      //   154: aload_1
      //   155: invokevirtual 103	com/google/b/h:Ay	()I
      //   158: putfield 105	com/google/b/k$d:bRD	I
      //   161: goto -138 -> 23
      //   164: astore_1
      //   165: new 57	com/google/b/bf
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 108	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 87	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   179: aload_1
      //   180: athrow
      //   181: aload_0
      //   182: getfield 83	com/google/b/k$d:bQS	I
      //   185: iconst_4
      //   186: iand
      //   187: ifeq +81 -> 268
      //   190: aload_0
      //   191: getfield 110	com/google/b/k$d:bRE	Lcom/google/b/k$e;
      //   194: invokevirtual 116	com/google/b/k$e:DG	()Lcom/google/b/k$e$a;
      //   197: astore 5
      //   199: aload_0
      //   200: aload_1
      //   201: getstatic 117	com/google/b/k$e:bRf	Lcom/google/b/ci;
      //   204: aload_2
      //   205: invokevirtual 120	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
      //   208: checkcast 112	com/google/b/k$e
      //   211: putfield 110	com/google/b/k$d:bRE	Lcom/google/b/k$e;
      //   214: aload 5
      //   216: ifnull +22 -> 238
      //   219: aload 5
      //   221: aload_0
      //   222: getfield 110	com/google/b/k$d:bRE	Lcom/google/b/k$e;
      //   225: invokevirtual 125	com/google/b/k$e$a:d	(Lcom/google/b/k$e;)Lcom/google/b/k$e$a;
      //   228: pop
      //   229: aload_0
      //   230: aload 5
      //   232: invokevirtual 129	com/google/b/k$e$a:DJ	()Lcom/google/b/k$e;
      //   235: putfield 110	com/google/b/k$d:bRE	Lcom/google/b/k$e;
      //   238: aload_0
      //   239: aload_0
      //   240: getfield 83	com/google/b/k$d:bQS	I
      //   243: iconst_4
      //   244: ior
      //   245: putfield 83	com/google/b/k$d:bQS	I
      //   248: goto -225 -> 23
      //   251: aload_0
      //   252: aload 6
      //   254: invokevirtual 93	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   257: putfield 97	com/google/b/k$d:bVW	Lcom/google/b/da;
      //   260: aload_0
      //   261: invokevirtual 100	com/google/b/k$d:HZ	()V
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
      //   0	285	0	this	d
      //   0	285	1	paramh	h
      //   0	285	2	paramap	ap
      //   22	260	3	i	int
      //   31	51	4	j	int
      //   98	172	5	localObject	Object
      //   19	234	6	locala	da.a
      // Exception table:
      //   from	to	target	type
      //   27	33	119	com/google/b/bf
      //   76	89	119	com/google/b/bf
      //   94	116	119	com/google/b/bf
      //   143	161	119	com/google/b/bf
      //   181	199	119	com/google/b/bf
      //   199	214	119	com/google/b/bf
      //   219	238	119	com/google/b/bf
      //   238	248	119	com/google/b/bf
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
    
    public static a DB()
    {
      return bRF.DC();
    }
    
    private a DC()
    {
      if (this == bRF) {
        return new a((byte)0);
      }
      return new a((byte)0).b(this);
    }
    
    public static d DD()
    {
      return bRF;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = bb.f(1, this.bQT) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + i.bM(2, this.bRD);
      }
      j = i;
      if ((this.bQS & 0x4) != 0) {
        j = i + i.c(3, DA());
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Bx().b(d.class, a.class);
    }
    
    public final boolean Cc()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Cj()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final ci<d> Co()
    {
      return bRf;
    }
    
    public final k.e DA()
    {
      if (this.bRE == null) {
        return k.e.DH();
      }
      return this.bRE;
    }
    
    public final boolean Dz()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final void a(i parami)
    {
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bQT);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.bJ(2, this.bRD);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.a(3, DA());
      }
      this.bVW.a(parami);
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
        if (Cc() != paramObject.Cc()) {
          return false;
        }
        if ((Cc()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (Dz() != paramObject.Dz()) {
          return false;
        }
        if ((Dz()) && (this.bRD != paramObject.bRD)) {
          return false;
        }
        if (Cj() != paramObject.Cj()) {
          return false;
        }
        if ((Cj()) && (!DA().equals(paramObject.DA()))) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bQT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bQT = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Bw().hashCode() + 779;
      int i = j;
      if (Cc()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (Dz()) {
        j = (i * 37 + 2) * 53 + this.bRD;
      }
      i = j;
      if (Cj()) {
        i = (j * 37 + 3) * 53 + DA().hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bRd;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((Cj()) && (!DA().isInitialized()))
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements r
    {
      private int bQS;
      private Object bQT = "";
      private int bRD;
      private k.e bRE;
      private cs<k.e, k.e.a, s> bRm;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private cs<k.e, k.e.a, s> CK()
      {
        if (this.bRm == null)
        {
          this.bRm = new cs(DA(), Ie(), Ic());
          this.bRE = null;
        }
        return this.bRm;
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          CK();
        }
      }
      
      private k.e DA()
      {
        if (this.bRm == null)
        {
          if (this.bRE == null) {
            return k.e.DH();
          }
          return this.bRE;
        }
        return (k.e)this.bRm.IU();
      }
      
      private k.d DF()
      {
        int i = 0;
        k.d locald = new k.d(this, (byte)0);
        int j = this.bQS;
        if ((j & 0x1) != 0) {
          i = 1;
        }
        k.d.a(locald, this.bQT);
        if ((j & 0x2) != 0)
        {
          k.d.a(locald, this.bRD);
          i |= 0x2;
        }
        for (;;)
        {
          if ((j & 0x4) != 0) {
            if (this.bRm == null)
            {
              k.d.a(locald, this.bRE);
              i |= 0x4;
            }
          }
          for (;;)
          {
            k.d.b(locald, i);
            Ib();
            return locald;
            k.d.a(locald, (k.e)this.bRm.IV());
            break;
          }
        }
      }
      
      private a a(k.e parame)
      {
        if (this.bRm == null) {
          if (((this.bQS & 0x4) != 0) && (this.bRE != null) && (this.bRE != k.e.DH()))
          {
            this.bRE = k.e.b(this.bRE).d(parame).DJ();
            onChanged();
          }
        }
        for (;;)
        {
          this.bQS |= 0x4;
          return this;
          this.bRE = parame;
          break;
          this.bRm.c(parame);
        }
      }
      
      private a j(bt parambt)
      {
        if ((parambt instanceof k.d)) {
          return b((k.d)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a k(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 145	com/google/b/k$d:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 150 3 0
        //   12: checkcast 9	com/google/b/k$d
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 134	com/google/b/k$d$a:b	(Lcom/google/b/k$d;)Lcom/google/b/k$d$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 154	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$d
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 158	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 134	com/google/b/k$d$a:b	(Lcom/google/b/k$d;)Lcom/google/b/k$d$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a q(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a r(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a s(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a t(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      protected final bb.e Cb()
      {
        return k.Bx().b(k.d.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.Bw();
      }
      
      public final k.d DE()
      {
        k.d locald = DF();
        if (!locald.isInitialized()) {
          throw b(locald);
        }
        return locald;
      }
      
      public final a b(k.d paramd)
      {
        if (paramd == k.d.DD()) {
          return this;
        }
        if (paramd.Cc())
        {
          this.bQS |= 0x1;
          this.bQT = k.d.a(paramd);
          onChanged();
        }
        if (paramd.Dz()) {
          he(paramd.bRD);
        }
        if (paramd.Cj()) {
          a(paramd.DA());
        }
        r(paramd.bVW);
        onChanged();
        return this;
      }
      
      public final a cz(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x1;
        this.bQT = paramString;
        onChanged();
        return this;
      }
      
      public final a he(int paramInt)
      {
        this.bQS |= 0x2;
        this.bRD = paramInt;
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bQS & 0x4) != 0) {}
        for (int i = 1; (i != 0) && (!DA().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
  }
  
  public static final class e
    extends bb.d<e>
    implements s
  {
    private static final e bRG = new e();
    @Deprecated
    public static final ci<e> bRf = new c() {};
    private int bQS;
    private List<k.s> bRA;
    private byte bRd = -1;
    boolean bRz;
    
    private e()
    {
      this.bRA = Collections.emptyList();
    }
    
    private e(bb.c<e, ?> paramc)
    {
      super();
    }
    
    private e(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            j = paramh.Av();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramap, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bQS |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bRz = paramh.AB();
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally {}
            if ((k & 0x2) != 0) {
              this.bRA = Collections.unmodifiableList(this.bRA);
            }
            this.bVW = locala.Jm();
            this.bXY.Al();
            throw paramh;
            int j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.bRA = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            k = j;
            this.bRA.add(paramh.a(k.s.bRf, paramap));
            i = j;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new bf(paramh);
            k = i1;
            paramh.bZj = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
          }
          if ((i & 0x2) != 0) {
            this.bRA = Collections.unmodifiableList(this.bRA);
          }
          this.bVW = locala.Jm();
          this.bXY.Al();
          return;
        }
        m = 1;
      }
    }
    
    public static e DH()
    {
      return bRG;
    }
    
    private int Ds()
    {
      return this.bRA.size();
    }
    
    public static a b(e parame)
    {
      return bRG.DG().d(parame);
    }
    
    public final int Ad()
    {
      int j = 0;
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {
        i = i.gK(1) + 0;
      }
      for (;;)
      {
        if (j < this.bRA.size())
        {
          int k = i.c(999, (bw)this.bRA.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          i = Ii() + i + this.bVW.Ad();
          this.bOZ = i;
          return i;
          i = 0;
        }
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BN().b(e.class, a.class);
    }
    
    public final ci<e> Co()
    {
      return bRf;
    }
    
    public final a DG()
    {
      if (this == bRG) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final boolean Dr()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final void a(i parami)
    {
      bb.d.a locala = Ih();
      if ((this.bQS & 0x1) != 0) {
        parami.t(1, this.bRz);
      }
      int i = 0;
      while (i < this.bRA.size())
      {
        parami.a(999, (bw)this.bRA.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bVW.a(parami);
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
        if (Dr() != paramObject.Dr()) {
          return false;
        }
        if ((Dr()) && (this.bRz != paramObject.bRz)) {
          return false;
        }
        if (!this.bRA.equals(paramObject.bRA)) {
          return false;
        }
        if (!this.bVW.equals(paramObject.bVW)) {
          return false;
        }
      } while (Ij().equals(paramObject.Ij()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BM().hashCode() + 779;
      int i = j;
      if (Dr()) {
        i = (j * 37 + 1) * 53 + be.bS(this.bRz);
      }
      j = i;
      if (Ds() > 0) {
        j = (i * 37 + 999) * 53 + this.bRA.hashCode();
      }
      i = a(j, Ij()) * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ds())
      {
        if (!((k.s)this.bRA.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.c<k.e, a>
      implements s
    {
      private int bQS;
      private List<k.s> bRA = Collections.emptyList();
      private co<k.s, k.s.a, ai> bRC;
      private boolean bRz;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Dy();
        }
      }
      
      private k.e DI()
      {
        k.e locale = DJ();
        if (!locale.isInitialized()) {
          throw b(locale);
        }
        return locale;
      }
      
      private void Dx()
      {
        if ((this.bQS & 0x2) == 0)
        {
          this.bRA = new ArrayList(this.bRA);
          this.bQS |= 0x2;
        }
      }
      
      private co<k.s, k.s.a, ai> Dy()
      {
        List localList;
        if (this.bRC == null)
        {
          localList = this.bRA;
          if ((this.bQS & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRC = new co(localList, bool, Ie(), Ic());
          this.bRA = null;
          return this.bRC;
        }
      }
      
      private a bu(boolean paramBoolean)
      {
        this.bQS |= 0x1;
        this.bRz = paramBoolean;
        onChanged();
        return this;
      }
      
      private a k(bt parambt)
      {
        if ((parambt instanceof k.e)) {
          return d((k.e)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a l(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 116	com/google/b/k$e:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 121 3 0
        //   12: checkcast 9	com/google/b/k$e
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 105	com/google/b/k$e$a:d	(Lcom/google/b/k$e;)Lcom/google/b/k$e$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 125	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$e
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 129	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 105	com/google/b/k$e$a:d	(Lcom/google/b/k$e;)Lcom/google/b/k$e$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a s(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a t(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a u(aj.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a v(aj.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      protected final bb.e Cb()
      {
        return k.BN().b(k.e.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BM();
      }
      
      public final k.e DJ()
      {
        int i = 0;
        k.e locale = new k.e(this, (byte)0);
        if ((this.bQS & 0x1) != 0)
        {
          k.e.a(locale, this.bRz);
          i = 1;
        }
        if (this.bRC == null)
        {
          if ((this.bQS & 0x2) != 0)
          {
            this.bRA = Collections.unmodifiableList(this.bRA);
            this.bQS &= 0xFFFFFFFD;
          }
          k.e.a(locale, this.bRA);
        }
        for (;;)
        {
          k.e.a(locale, i);
          Ib();
          return locale;
          k.e.a(locale, this.bRC.build());
        }
      }
      
      public final a d(k.e parame)
      {
        co localco = null;
        if (parame == k.e.DH()) {
          return this;
        }
        if (parame.Dr()) {
          bu(parame.bRz);
        }
        if (this.bRC == null) {
          if (!k.e.c(parame).isEmpty())
          {
            if (!this.bRA.isEmpty()) {
              break label101;
            }
            this.bRA = k.e.c(parame);
            this.bQS &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          a(parame);
          t(parame.bVW);
          onChanged();
          return this;
          label101:
          Dx();
          this.bRA.addAll(k.e.c(parame));
          break;
          if (!k.e.c(parame).isEmpty()) {
            if (this.bRC.isEmpty())
            {
              this.bRC.cat = null;
              this.bRC = null;
              this.bRA = k.e.c(parame);
              this.bQS &= 0xFFFFFFFD;
              if (bb.bXS) {
                localco = Dy();
              }
              this.bRC = localco;
            }
            else
            {
              this.bRC.a(k.e.c(parame));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bRC == null)
        {
          j = this.bRA.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRC != null) {
            break label65;
          }
          locals = (k.s)this.bRA.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!Ig())
        {
          for (;;)
          {
            return false;
            j = this.bRC.getCount();
            break;
            k.s locals = (k.s)this.bRC.u(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class f
    extends bb.d<f>
    implements t
  {
    private static final f bRH = new f();
    @Deprecated
    public static final ci<f> bRf = new c() {};
    private List<k.s> bRA;
    private byte bRd = -1;
    
    private f()
    {
      this.bRA = Collections.emptyList();
    }
    
    private f(bb.c<f, ?> paramc)
    {
      super();
    }
    
    private f(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
          j = paramh.Av();
          switch (j)
          {
          }
        }
        catch (bf paramh)
        {
          try
          {
            int j;
            paramh.bZj = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.bRA = Collections.unmodifiableList(this.bRA);
          this.bVW = locala.Jm();
          this.bXY.Al();
          throw paramh;
          if ((i & 0x1) == 0) {
            break label240;
          }
          this.bRA = Collections.unmodifiableList(this.bRA);
          this.bVW = locala.Jm();
          this.bXY.Al();
          return;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new bf(paramh);
          k = i1;
          paramh.bZj = this;
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
        if (!a(paramh, locala, paramap, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bRA = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.bRA.add(paramh.a(k.s.bRf, paramap));
          i = j;
        }
      }
    }
    
    public static f DL()
    {
      return bRH;
    }
    
    private int Ds()
    {
      return this.bRA.size();
    }
    
    public static a b(f paramf)
    {
      return bRH.DK().d(paramf);
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.bRA.size())
      {
        j += i.c(999, (bw)this.bRA.get(i));
        i += 1;
      }
      i = Ii() + j + this.bVW.Ad();
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Bn().b(f.class, a.class);
    }
    
    public final ci<f> Co()
    {
      return bRf;
    }
    
    public final a DK()
    {
      if (this == bRH) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      bb.d.a locala = Ih();
      int i = 0;
      while (i < this.bRA.size())
      {
        parami.a(999, (bw)this.bRA.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bVW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof f)) {
          return super.equals(paramObject);
        }
        paramObject = (f)paramObject;
        if (!this.bRA.equals(paramObject.bRA)) {
          return false;
        }
        if (!this.bVW.equals(paramObject.bVW)) {
          return false;
        }
      } while (Ij().equals(paramObject.Ij()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Bm().hashCode() + 779;
      int i = j;
      if (Ds() > 0) {
        i = (j * 37 + 999) * 53 + this.bRA.hashCode();
      }
      i = a(i, Ij()) * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ds())
      {
        if (!((k.s)this.bRA.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.c<k.f, a>
      implements t
    {
      private int bQS;
      private List<k.s> bRA = Collections.emptyList();
      private co<k.s, k.s.a, ai> bRC;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Dy();
        }
      }
      
      private k.f DM()
      {
        k.f localf = DN();
        if (!localf.isInitialized()) {
          throw b(localf);
        }
        return localf;
      }
      
      private void Dx()
      {
        if ((this.bQS & 0x1) == 0)
        {
          this.bRA = new ArrayList(this.bRA);
          this.bQS |= 0x1;
        }
      }
      
      private co<k.s, k.s.a, ai> Dy()
      {
        List localList;
        if (this.bRC == null)
        {
          localList = this.bRA;
          if ((this.bQS & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRC = new co(localList, bool, Ie(), Ic());
          this.bRA = null;
          return this.bRC;
        }
      }
      
      private a l(bt parambt)
      {
        if ((parambt instanceof k.f)) {
          return d((k.f)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a m(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 108	com/google/b/k$f:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 113 3 0
        //   12: checkcast 9	com/google/b/k$f
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 97	com/google/b/k$f$a:d	(Lcom/google/b/k$f;)Lcom/google/b/k$f$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 117	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$f
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 121	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 97	com/google/b/k$f$a:d	(Lcom/google/b/k$f;)Lcom/google/b/k$f$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a u(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a v(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a w(aj.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a x(aj.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      protected final bb.e Cb()
      {
        return k.Bn().b(k.f.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.Bm();
      }
      
      public final k.f DN()
      {
        k.f localf = new k.f(this, (byte)0);
        if (this.bRC == null)
        {
          if ((this.bQS & 0x1) != 0)
          {
            this.bRA = Collections.unmodifiableList(this.bRA);
            this.bQS &= 0xFFFFFFFE;
          }
          k.f.a(localf, this.bRA);
        }
        for (;;)
        {
          Ib();
          return localf;
          k.f.a(localf, this.bRC.build());
        }
      }
      
      public final a d(k.f paramf)
      {
        co localco = null;
        if (paramf == k.f.DL()) {
          return this;
        }
        if (this.bRC == null) {
          if (!k.f.c(paramf).isEmpty())
          {
            if (!this.bRA.isEmpty()) {
              break label85;
            }
            this.bRA = k.f.c(paramf);
            this.bQS &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramf);
          v(paramf.bVW);
          onChanged();
          return this;
          label85:
          Dx();
          this.bRA.addAll(k.f.c(paramf));
          break;
          if (!k.f.c(paramf).isEmpty()) {
            if (this.bRC.isEmpty())
            {
              this.bRC.cat = null;
              this.bRC = null;
              this.bRA = k.f.c(paramf);
              this.bQS &= 0xFFFFFFFE;
              if (bb.bXS) {
                localco = Dy();
              }
              this.bRC = localco;
            }
            else
            {
              this.bRC.a(k.f.c(paramf));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bRC == null)
        {
          j = this.bRA.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRC != null) {
            break label65;
          }
          locals = (k.s)this.bRA.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!Ig())
        {
          for (;;)
          {
            return false;
            j = this.bRC.getCount();
            break;
            k.s locals = (k.s)this.bRC.u(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class g
    extends bb
    implements u
  {
    private static final g bRP = new g();
    @Deprecated
    public static final ci<g> bRf = new c() {};
    private int bQS;
    private volatile Object bQT;
    int bRD;
    private int bRI;
    private volatile Object bRJ;
    private volatile Object bRK;
    private volatile Object bRL;
    int bRM;
    private volatile Object bRN;
    private k.h bRO;
    private byte bRd = -1;
    private int type_;
    
    private g()
    {
      this.bQT = "";
      this.bRI = 1;
      this.type_ = 1;
      this.bRJ = "";
      this.bRK = "";
      this.bRL = "";
      this.bRN = "";
    }
    
    private g(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private g(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 48	com/google/b/k$g:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 87	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 88	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 94	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +506 -> 530
      //   27: aload_1
      //   28: invokevirtual 100	com/google/b/h:Av	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+518->553, 0:+524->559, 10:+115->150, 18:+164->199, 24:+207->242, 32:+228->263, 40:+273->308, 50:+319->354, 58:+345->380, 66:+371->406, 72:+445->480, 82:+468->503
      //   133: aload_1
      //   134: aload 6
      //   136: aload_2
      //   137: iload 4
      //   139: invokevirtual 103	com/google/b/k$g:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   142: ifne +402 -> 544
      //   145: iconst_1
      //   146: istore_3
      //   147: goto +409 -> 556
      //   150: aload_1
      //   151: invokevirtual 107	com/google/b/h:AD	()Lcom/google/b/g;
      //   154: astore 5
      //   156: aload_0
      //   157: aload_0
      //   158: getfield 109	com/google/b/k$g:bQS	I
      //   161: iconst_1
      //   162: ior
      //   163: putfield 109	com/google/b/k$g:bQS	I
      //   166: aload_0
      //   167: aload 5
      //   169: putfield 61	com/google/b/k$g:bQT	Ljava/lang/Object;
      //   172: goto -149 -> 23
      //   175: astore_1
      //   176: aload_1
      //   177: aload_0
      //   178: putfield 113	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   181: aload_1
      //   182: athrow
      //   183: astore_1
      //   184: aload_0
      //   185: aload 6
      //   187: invokevirtual 119	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   190: putfield 123	com/google/b/k$g:bVW	Lcom/google/b/da;
      //   193: aload_0
      //   194: invokevirtual 126	com/google/b/k$g:HZ	()V
      //   197: aload_1
      //   198: athrow
      //   199: aload_1
      //   200: invokevirtual 107	com/google/b/h:AD	()Lcom/google/b/g;
      //   203: astore 5
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 109	com/google/b/k$g:bQS	I
      //   210: bipush 32
      //   212: ior
      //   213: putfield 109	com/google/b/k$g:bQS	I
      //   216: aload_0
      //   217: aload 5
      //   219: putfield 69	com/google/b/k$g:bRK	Ljava/lang/Object;
      //   222: goto -199 -> 23
      //   225: astore_1
      //   226: new 83	com/google/b/bf
      //   229: dup
      //   230: aload_1
      //   231: invokespecial 129	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   234: astore_1
      //   235: aload_1
      //   236: aload_0
      //   237: putfield 113	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   240: aload_1
      //   241: athrow
      //   242: aload_0
      //   243: aload_0
      //   244: getfield 109	com/google/b/k$g:bQS	I
      //   247: iconst_2
      //   248: ior
      //   249: putfield 109	com/google/b/k$g:bQS	I
      //   252: aload_0
      //   253: aload_1
      //   254: invokevirtual 132	com/google/b/h:Ay	()I
      //   257: putfield 134	com/google/b/k$g:bRD	I
      //   260: goto -237 -> 23
      //   263: aload_1
      //   264: invokevirtual 137	com/google/b/h:AF	()I
      //   267: istore 4
      //   269: iload 4
      //   271: invokestatic 141	com/google/b/k$g$b:hh	(I)Lcom/google/b/k$g$b;
      //   274: ifnonnull +15 -> 289
      //   277: aload 6
      //   279: iconst_4
      //   280: iload 4
      //   282: invokevirtual 145	com/google/b/da$a:bQ	(II)Lcom/google/b/da$a;
      //   285: pop
      //   286: goto -263 -> 23
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 109	com/google/b/k$g:bQS	I
      //   294: iconst_4
      //   295: ior
      //   296: putfield 109	com/google/b/k$g:bQS	I
      //   299: aload_0
      //   300: iload 4
      //   302: putfield 63	com/google/b/k$g:bRI	I
      //   305: goto -282 -> 23
      //   308: aload_1
      //   309: invokevirtual 137	com/google/b/h:AF	()I
      //   312: istore 4
      //   314: iload 4
      //   316: invokestatic 149	com/google/b/k$g$c:hi	(I)Lcom/google/b/k$g$c;
      //   319: ifnonnull +15 -> 334
      //   322: aload 6
      //   324: iconst_5
      //   325: iload 4
      //   327: invokevirtual 145	com/google/b/da$a:bQ	(II)Lcom/google/b/da$a;
      //   330: pop
      //   331: goto -308 -> 23
      //   334: aload_0
      //   335: aload_0
      //   336: getfield 109	com/google/b/k$g:bQS	I
      //   339: bipush 8
      //   341: ior
      //   342: putfield 109	com/google/b/k$g:bQS	I
      //   345: aload_0
      //   346: iload 4
      //   348: putfield 65	com/google/b/k$g:type_	I
      //   351: goto -328 -> 23
      //   354: aload_1
      //   355: invokevirtual 107	com/google/b/h:AD	()Lcom/google/b/g;
      //   358: astore 5
      //   360: aload_0
      //   361: aload_0
      //   362: getfield 109	com/google/b/k$g:bQS	I
      //   365: bipush 16
      //   367: ior
      //   368: putfield 109	com/google/b/k$g:bQS	I
      //   371: aload_0
      //   372: aload 5
      //   374: putfield 67	com/google/b/k$g:bRJ	Ljava/lang/Object;
      //   377: goto -354 -> 23
      //   380: aload_1
      //   381: invokevirtual 107	com/google/b/h:AD	()Lcom/google/b/g;
      //   384: astore 5
      //   386: aload_0
      //   387: aload_0
      //   388: getfield 109	com/google/b/k$g:bQS	I
      //   391: bipush 64
      //   393: ior
      //   394: putfield 109	com/google/b/k$g:bQS	I
      //   397: aload_0
      //   398: aload 5
      //   400: putfield 71	com/google/b/k$g:bRL	Ljava/lang/Object;
      //   403: goto -380 -> 23
      //   406: aload_0
      //   407: getfield 109	com/google/b/k$g:bQS	I
      //   410: sipush 512
      //   413: iand
      //   414: ifeq +133 -> 547
      //   417: aload_0
      //   418: getfield 151	com/google/b/k$g:bRO	Lcom/google/b/k$h;
      //   421: invokevirtual 157	com/google/b/k$h:Em	()Lcom/google/b/k$h$a;
      //   424: astore 5
      //   426: aload_0
      //   427: aload_1
      //   428: getstatic 158	com/google/b/k$h:bRf	Lcom/google/b/ci;
      //   431: aload_2
      //   432: invokevirtual 161	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
      //   435: checkcast 153	com/google/b/k$h
      //   438: putfield 151	com/google/b/k$g:bRO	Lcom/google/b/k$h;
      //   441: aload 5
      //   443: ifnull +22 -> 465
      //   446: aload 5
      //   448: aload_0
      //   449: getfield 151	com/google/b/k$g:bRO	Lcom/google/b/k$h;
      //   452: invokevirtual 167	com/google/b/k$h$a:d	(Lcom/google/b/k$h;)Lcom/google/b/k$h$a;
      //   455: pop
      //   456: aload_0
      //   457: aload 5
      //   459: invokevirtual 171	com/google/b/k$h$a:Ep	()Lcom/google/b/k$h;
      //   462: putfield 151	com/google/b/k$g:bRO	Lcom/google/b/k$h;
      //   465: aload_0
      //   466: aload_0
      //   467: getfield 109	com/google/b/k$g:bQS	I
      //   470: sipush 512
      //   473: ior
      //   474: putfield 109	com/google/b/k$g:bQS	I
      //   477: goto -454 -> 23
      //   480: aload_0
      //   481: aload_0
      //   482: getfield 109	com/google/b/k$g:bQS	I
      //   485: sipush 128
      //   488: ior
      //   489: putfield 109	com/google/b/k$g:bQS	I
      //   492: aload_0
      //   493: aload_1
      //   494: invokevirtual 132	com/google/b/h:Ay	()I
      //   497: putfield 173	com/google/b/k$g:bRM	I
      //   500: goto -477 -> 23
      //   503: aload_1
      //   504: invokevirtual 107	com/google/b/h:AD	()Lcom/google/b/g;
      //   507: astore 5
      //   509: aload_0
      //   510: aload_0
      //   511: getfield 109	com/google/b/k$g:bQS	I
      //   514: sipush 256
      //   517: ior
      //   518: putfield 109	com/google/b/k$g:bQS	I
      //   521: aload_0
      //   522: aload 5
      //   524: putfield 73	com/google/b/k$g:bRN	Ljava/lang/Object;
      //   527: goto -504 -> 23
      //   530: aload_0
      //   531: aload 6
      //   533: invokevirtual 119	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   536: putfield 123	com/google/b/k$g:bVW	Lcom/google/b/da;
      //   539: aload_0
      //   540: invokevirtual 126	com/google/b/k$g:HZ	()V
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
      //   0	564	0	this	g
      //   0	564	1	paramh	h
      //   0	564	2	paramap	ap
      //   22	539	3	i	int
      //   31	316	4	j	int
      //   154	395	5	localObject	Object
      //   19	513	6	locala	da.a
      // Exception table:
      //   from	to	target	type
      //   27	33	175	com/google/b/bf
      //   132	145	175	com/google/b/bf
      //   150	172	175	com/google/b/bf
      //   199	222	175	com/google/b/bf
      //   242	260	175	com/google/b/bf
      //   263	286	175	com/google/b/bf
      //   289	305	175	com/google/b/bf
      //   308	331	175	com/google/b/bf
      //   334	351	175	com/google/b/bf
      //   354	377	175	com/google/b/bf
      //   380	403	175	com/google/b/bf
      //   406	426	175	com/google/b/bf
      //   426	441	175	com/google/b/bf
      //   446	465	175	com/google/b/bf
      //   465	477	175	com/google/b/bf
      //   480	500	175	com/google/b/bf
      //   503	527	175	com/google/b/bf
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
    
    private a Eb()
    {
      if (this == bRP) {
        return new a((byte)0);
      }
      return new a((byte)0).f(this);
    }
    
    public static g Ec()
    {
      return bRP;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = bb.f(1, this.bQT) + 0;
      }
      i = j;
      if ((this.bQS & 0x20) != 0) {
        i = j + bb.f(2, this.bRK);
      }
      j = i;
      if ((this.bQS & 0x2) != 0) {
        j = i + i.bM(3, this.bRD);
      }
      i = j;
      if ((this.bQS & 0x4) != 0) {
        i = j + i.bO(4, this.bRI);
      }
      j = i;
      if ((this.bQS & 0x8) != 0) {
        j = i + i.bO(5, this.type_);
      }
      i = j;
      if ((this.bQS & 0x10) != 0) {
        i = j + bb.f(6, this.bRJ);
      }
      j = i;
      if ((this.bQS & 0x40) != 0) {
        j = i + bb.f(7, this.bRL);
      }
      i = j;
      if ((this.bQS & 0x200) != 0) {
        i = j + i.c(8, Ea());
      }
      j = i;
      if ((this.bQS & 0x80) != 0) {
        j = i + i.bM(9, this.bRM);
      }
      i = j;
      if ((this.bQS & 0x100) != 0) {
        i = j + bb.f(10, this.bRN);
      }
      i += this.bVW.Ad();
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Bp().b(g.class, a.class);
    }
    
    public final boolean Cc()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Cj()
    {
      return (this.bQS & 0x200) != 0;
    }
    
    public final ci<g> Co()
    {
      return bRf;
    }
    
    public final boolean DO()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final b DP()
    {
      b localb2 = b.hh(this.bRI);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.bRQ;
      }
      return localb1;
    }
    
    public final boolean DQ()
    {
      return (this.bQS & 0x8) != 0;
    }
    
    public final k.g.c DR()
    {
      k.g.c localc2 = k.g.c.hi(this.type_);
      k.g.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = k.g.c.bRW;
      }
      return localc1;
    }
    
    public final boolean DS()
    {
      return (this.bQS & 0x10) != 0;
    }
    
    public final String DT()
    {
      Object localObject = this.bRJ;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bRJ = str;
      }
      return str;
    }
    
    public final boolean DU()
    {
      return (this.bQS & 0x20) != 0;
    }
    
    public final String DV()
    {
      Object localObject = this.bRK;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bRK = str;
      }
      return str;
    }
    
    public final boolean DW()
    {
      return (this.bQS & 0x40) != 0;
    }
    
    public final boolean DX()
    {
      return (this.bQS & 0x80) != 0;
    }
    
    public final boolean DY()
    {
      return (this.bQS & 0x100) != 0;
    }
    
    public final String DZ()
    {
      Object localObject = this.bRN;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bRN = str;
      }
      return str;
    }
    
    public final boolean Dz()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final k.h Ea()
    {
      if (this.bRO == null) {
        return k.h.En();
      }
      return this.bRO;
    }
    
    public final void a(i parami)
    {
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bQT);
      }
      if ((this.bQS & 0x20) != 0) {
        bb.a(parami, 2, this.bRK);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.bJ(3, this.bRD);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.bJ(4, this.bRI);
      }
      if ((this.bQS & 0x8) != 0) {
        parami.bJ(5, this.type_);
      }
      if ((this.bQS & 0x10) != 0) {
        bb.a(parami, 6, this.bRJ);
      }
      if ((this.bQS & 0x40) != 0) {
        bb.a(parami, 7, this.bRL);
      }
      if ((this.bQS & 0x200) != 0) {
        parami.a(8, Ea());
      }
      if ((this.bQS & 0x80) != 0) {
        parami.bJ(9, this.bRM);
      }
      if ((this.bQS & 0x100) != 0) {
        bb.a(parami, 10, this.bRN);
      }
      this.bVW.a(parami);
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
        if (Cc() != paramObject.Cc()) {
          return false;
        }
        if ((Cc()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (Dz() != paramObject.Dz()) {
          return false;
        }
        if ((Dz()) && (this.bRD != paramObject.bRD)) {
          return false;
        }
        if (DO() != paramObject.DO()) {
          return false;
        }
        if ((DO()) && (this.bRI != paramObject.bRI)) {
          return false;
        }
        if (DQ() != paramObject.DQ()) {
          return false;
        }
        if ((DQ()) && (this.type_ != paramObject.type_)) {
          return false;
        }
        if (DS() != paramObject.DS()) {
          return false;
        }
        if ((DS()) && (!DT().equals(paramObject.DT()))) {
          return false;
        }
        if (DU() != paramObject.DU()) {
          return false;
        }
        if ((DU()) && (!DV().equals(paramObject.DV()))) {
          return false;
        }
        if (DW() != paramObject.DW()) {
          return false;
        }
        if ((DW()) && (!getDefaultValue().equals(paramObject.getDefaultValue()))) {
          return false;
        }
        if (DX() != paramObject.DX()) {
          return false;
        }
        if ((DX()) && (this.bRM != paramObject.bRM)) {
          return false;
        }
        if (DY() != paramObject.DY()) {
          return false;
        }
        if ((DY()) && (!DZ().equals(paramObject.DZ()))) {
          return false;
        }
        if (Cj() != paramObject.Cj()) {
          return false;
        }
        if ((Cj()) && (!Ea().equals(paramObject.Ea()))) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final String getDefaultValue()
    {
      Object localObject = this.bRL;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bRL = str;
      }
      return str;
    }
    
    public final String getName()
    {
      Object localObject = this.bQT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bQT = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Bo().hashCode() + 779;
      int i = j;
      if (Cc()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (Dz()) {
        j = (i * 37 + 3) * 53 + this.bRD;
      }
      i = j;
      if (DO()) {
        i = (j * 37 + 4) * 53 + this.bRI;
      }
      j = i;
      if (DQ()) {
        j = (i * 37 + 5) * 53 + this.type_;
      }
      i = j;
      if (DS()) {
        i = (j * 37 + 6) * 53 + DT().hashCode();
      }
      j = i;
      if (DU()) {
        j = (i * 37 + 2) * 53 + DV().hashCode();
      }
      i = j;
      if (DW()) {
        i = (j * 37 + 7) * 53 + getDefaultValue().hashCode();
      }
      j = i;
      if (DX()) {
        j = (i * 37 + 9) * 53 + this.bRM;
      }
      i = j;
      if (DY()) {
        i = (j * 37 + 10) * 53 + DZ().hashCode();
      }
      j = i;
      if (Cj()) {
        j = (i * 37 + 8) * 53 + Ea().hashCode();
      }
      i = j * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bRd;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((Cj()) && (!Ea().isInitialized()))
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements u
    {
      private int bQS;
      private Object bQT = "";
      private int bRD;
      private int bRI = 1;
      private Object bRJ = "";
      private Object bRK = "";
      private Object bRL = "";
      private int bRM;
      private Object bRN = "";
      private k.h bRO;
      private cs<k.h, k.h.a, v> bRm;
      private int type_ = 1;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private cs<k.h, k.h.a, v> CK()
      {
        if (this.bRm == null)
        {
          this.bRm = new cs(Ea(), Ie(), Ic());
          this.bRO = null;
        }
        return this.bRm;
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          CK();
        }
      }
      
      private k.h Ea()
      {
        if (this.bRm == null)
        {
          if (this.bRO == null) {
            return k.h.En();
          }
          return this.bRO;
        }
        return (k.h)this.bRm.IU();
      }
      
      private k.g Ed()
      {
        k.g localg = Ee();
        if (!localg.isInitialized()) {
          throw b(localg);
        }
        return localg;
      }
      
      private k.g Ee()
      {
        int j = 0;
        k.g localg = new k.g(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        k.g.a(localg, this.bQT);
        int i = j;
        if ((k & 0x2) != 0)
        {
          k.g.a(localg, this.bRD);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        k.g.b(localg, this.bRI);
        i = j;
        if ((k & 0x8) != 0) {
          i = j | 0x8;
        }
        k.g.c(localg, this.type_);
        j = i;
        if ((k & 0x10) != 0) {
          j = i | 0x10;
        }
        k.g.b(localg, this.bRJ);
        i = j;
        if ((k & 0x20) != 0) {
          i = j | 0x20;
        }
        k.g.c(localg, this.bRK);
        j = i;
        if ((k & 0x40) != 0) {
          j = i | 0x40;
        }
        k.g.d(localg, this.bRL);
        i = j;
        if ((k & 0x80) != 0)
        {
          k.g.d(localg, this.bRM);
          i = j | 0x80;
        }
        if ((k & 0x100) != 0) {
          i |= 0x100;
        }
        for (;;)
        {
          k.g.e(localg, this.bRN);
          j = i;
          if ((k & 0x200) != 0)
          {
            if (this.bRm != null) {
              break label273;
            }
            k.g.a(localg, this.bRO);
          }
          for (;;)
          {
            j = i | 0x200;
            k.g.e(localg, j);
            Ib();
            return localg;
            label273:
            k.g.a(localg, (k.h)this.bRm.IV());
          }
        }
      }
      
      private a a(k.g.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x4;
        this.bRI = paramb.value;
        onChanged();
        return this;
      }
      
      private a a(k.g.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x8;
        this.type_ = paramc.value;
        onChanged();
        return this;
      }
      
      private a a(k.h paramh)
      {
        if (this.bRm == null) {
          if (((this.bQS & 0x200) != 0) && (this.bRO != null) && (this.bRO != k.h.En()))
          {
            this.bRO = k.h.b(this.bRO).d(paramh).Ep();
            onChanged();
          }
        }
        for (;;)
        {
          this.bQS |= 0x200;
          return this;
          this.bRO = paramh;
          break;
          this.bRm.c(paramh);
        }
      }
      
      private a hf(int paramInt)
      {
        this.bQS |= 0x2;
        this.bRD = paramInt;
        onChanged();
        return this;
      }
      
      private a hg(int paramInt)
      {
        this.bQS |= 0x80;
        this.bRM = paramInt;
        onChanged();
        return this;
      }
      
      private a m(bt parambt)
      {
        if ((parambt instanceof k.g)) {
          return f((k.g)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a n(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 208	com/google/b/k$g:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 213 3 0
        //   12: checkcast 9	com/google/b/k$g
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 197	com/google/b/k$g$a:f	(Lcom/google/b/k$g;)Lcom/google/b/k$g$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 217	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$g
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 221	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 197	com/google/b/k$g$a:f	(Lcom/google/b/k$g;)Lcom/google/b/k$g$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a w(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a x(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a y(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a z(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      protected final bb.e Cb()
      {
        return k.Bp().b(k.g.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.Bo();
      }
      
      public final a f(k.g paramg)
      {
        if (paramg == k.g.Ec()) {
          return this;
        }
        if (paramg.Cc())
        {
          this.bQS |= 0x1;
          this.bQT = k.g.a(paramg);
          onChanged();
        }
        if (paramg.Dz()) {
          hf(paramg.bRD);
        }
        if (paramg.DO()) {
          a(paramg.DP());
        }
        if (paramg.DQ()) {
          a(paramg.DR());
        }
        if (paramg.DS())
        {
          this.bQS |= 0x10;
          this.bRJ = k.g.b(paramg);
          onChanged();
        }
        if (paramg.DU())
        {
          this.bQS |= 0x20;
          this.bRK = k.g.c(paramg);
          onChanged();
        }
        if (paramg.DW())
        {
          this.bQS |= 0x40;
          this.bRL = k.g.d(paramg);
          onChanged();
        }
        if (paramg.DX()) {
          hg(paramg.bRM);
        }
        if (paramg.DY())
        {
          this.bQS |= 0x100;
          this.bRN = k.g.e(paramg);
          onChanged();
        }
        if (paramg.Cj()) {
          a(paramg.Ea());
        }
        x(paramg.bVW);
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        if ((this.bQS & 0x200) != 0) {}
        for (int i = 1; (i != 0) && (!Ea().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
    
    public static enum b
      implements cl
    {
      private static final be.b<b> bRT = new be.b() {};
      private static final b[] bRU = values();
      final int value;
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b hh(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return bRQ;
        case 2: 
          return bRR;
        }
        return bRS;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static final class h
    extends bb.d<h>
    implements v
  {
    @Deprecated
    public static final ci<h> bRf = new c() {};
    private static final h bSv = new h();
    private int bQS;
    private List<k.s> bRA;
    private byte bRd = -1;
    boolean bRz;
    private int bSq;
    boolean bSr;
    private int bSs;
    boolean bSt;
    boolean bSu;
    
    private h()
    {
      this.bSq = 0;
      this.bSs = 0;
      this.bRA = Collections.emptyList();
    }
    
    private h(bb.c<h, ?> paramc)
    {
      super();
    }
    
    private h(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            j = paramh.Av();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramap, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              j = paramh.AF();
              n = i;
              i1 = i;
              k = i;
              if (k.h.b.hj(j) == null)
              {
                n = i;
                i1 = i;
                k = i;
                locala.bQ(1, j);
                break label26;
              }
              break;
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally {}
            if ((k & 0x40) != 0) {
              this.bRA = Collections.unmodifiableList(this.bRA);
            }
            this.bVW = locala.Jm();
            this.bXY.Al();
            throw paramh;
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.bSq = j;
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new bf(paramh);
            k = i1;
            paramh.bZj = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bSr = paramh.AB();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.bRz = paramh.AB();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.bSt = paramh.AB();
          break;
          n = i;
          i1 = i;
          k = i;
          int j = paramh.AF();
          n = i;
          i1 = i;
          k = i;
          if (k.h.c.hk(j) == null)
          {
            n = i;
            i1 = i;
            k = i;
            locala.bQ(6, j);
            break;
          }
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.bSs = j;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x20;
          n = i;
          i1 = i;
          k = i;
          this.bSu = paramh.AB();
          break;
          j = i;
          if ((i & 0x40) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bRA = new ArrayList();
            j = i | 0x40;
          }
          n = j;
          i1 = j;
          k = j;
          this.bRA.add(paramh.a(k.s.bRf, paramap));
          i = j;
          break;
          if ((i & 0x40) != 0) {
            this.bRA = Collections.unmodifiableList(this.bRA);
          }
          this.bVW = locala.Jm();
          this.bXY.Al();
          return;
        }
        m = 1;
      }
    }
    
    private int Ds()
    {
      return this.bRA.size();
    }
    
    public static h En()
    {
      return bSv;
    }
    
    public static a b(h paramh)
    {
      return bSv.Em().d(paramh);
    }
    
    public final int Ad()
    {
      int k = 0;
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {}
      for (int j = i.bO(1, this.bSq) + 0;; j = 0)
      {
        i = j;
        if ((this.bQS & 0x2) != 0) {
          i = j + i.gK(2);
        }
        j = i;
        if ((this.bQS & 0x10) != 0) {
          j = i + i.gK(3);
        }
        i = j;
        if ((this.bQS & 0x8) != 0) {
          i = j + i.gK(5);
        }
        j = i;
        if ((this.bQS & 0x4) != 0) {
          j = i + i.bO(6, this.bSs);
        }
        i = j;
        if ((this.bQS & 0x20) != 0) {
          i = j + i.gK(10);
        }
        j = k;
        while (j < this.bRA.size())
        {
          k = i.c(999, (bw)this.bRA.get(j));
          j += 1;
          i = k + i;
        }
        i = Ii() + i + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BH().b(h.class, a.class);
    }
    
    public final ci<h> Co()
    {
      return bRf;
    }
    
    public final boolean Dr()
    {
      return (this.bQS & 0x10) != 0;
    }
    
    public final boolean Ef()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final k.h.b Eg()
    {
      k.h.b localb2 = k.h.b.hj(this.bSq);
      k.h.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = k.h.b.bSw;
      }
      return localb1;
    }
    
    public final boolean Eh()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final boolean Ei()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final k.h.c Ej()
    {
      k.h.c localc2 = k.h.c.hk(this.bSs);
      k.h.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = k.h.c.bSB;
      }
      return localc1;
    }
    
    public final boolean Ek()
    {
      return (this.bQS & 0x8) != 0;
    }
    
    public final boolean El()
    {
      return (this.bQS & 0x20) != 0;
    }
    
    public final a Em()
    {
      if (this == bSv) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      bb.d.a locala = Ih();
      if ((this.bQS & 0x1) != 0) {
        parami.bJ(1, this.bSq);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.t(2, this.bSr);
      }
      if ((this.bQS & 0x10) != 0) {
        parami.t(3, this.bRz);
      }
      if ((this.bQS & 0x8) != 0) {
        parami.t(5, this.bSt);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.bJ(6, this.bSs);
      }
      if ((this.bQS & 0x20) != 0) {
        parami.t(10, this.bSu);
      }
      int i = 0;
      while (i < this.bRA.size())
      {
        parami.a(999, (bw)this.bRA.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bVW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof h)) {
          return super.equals(paramObject);
        }
        paramObject = (h)paramObject;
        if (Ef() != paramObject.Ef()) {
          return false;
        }
        if ((Ef()) && (this.bSq != paramObject.bSq)) {
          return false;
        }
        if (Eh() != paramObject.Eh()) {
          return false;
        }
        if ((Eh()) && (this.bSr != paramObject.bSr)) {
          return false;
        }
        if (Ei() != paramObject.Ei()) {
          return false;
        }
        if ((Ei()) && (this.bSs != paramObject.bSs)) {
          return false;
        }
        if (Ek() != paramObject.Ek()) {
          return false;
        }
        if ((Ek()) && (this.bSt != paramObject.bSt)) {
          return false;
        }
        if (Dr() != paramObject.Dr()) {
          return false;
        }
        if ((Dr()) && (this.bRz != paramObject.bRz)) {
          return false;
        }
        if (El() != paramObject.El()) {
          return false;
        }
        if ((El()) && (this.bSu != paramObject.bSu)) {
          return false;
        }
        if (!this.bRA.equals(paramObject.bRA)) {
          return false;
        }
        if (!this.bVW.equals(paramObject.bVW)) {
          return false;
        }
      } while (Ij().equals(paramObject.Ij()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BG().hashCode() + 779;
      int i = j;
      if (Ef()) {
        i = (j * 37 + 1) * 53 + this.bSq;
      }
      j = i;
      if (Eh()) {
        j = (i * 37 + 2) * 53 + be.bS(this.bSr);
      }
      i = j;
      if (Ei()) {
        i = (j * 37 + 6) * 53 + this.bSs;
      }
      j = i;
      if (Ek()) {
        j = (i * 37 + 5) * 53 + be.bS(this.bSt);
      }
      i = j;
      if (Dr()) {
        i = (j * 37 + 3) * 53 + be.bS(this.bRz);
      }
      j = i;
      if (El()) {
        j = (i * 37 + 10) * 53 + be.bS(this.bSu);
      }
      i = j;
      if (Ds() > 0) {
        i = (j * 37 + 999) * 53 + this.bRA.hashCode();
      }
      i = a(i, Ij()) * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ds())
      {
        if (!((k.s)this.bRA.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.c<k.h, a>
      implements v
    {
      private int bQS;
      private List<k.s> bRA = Collections.emptyList();
      private co<k.s, k.s.a, ai> bRC;
      private boolean bRz;
      private int bSq = 0;
      private boolean bSr;
      private int bSs = 0;
      private boolean bSt;
      private boolean bSu;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private a A(aj.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a B(aj.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Dy();
        }
      }
      
      private void Dx()
      {
        if ((this.bQS & 0x40) == 0)
        {
          this.bRA = new ArrayList(this.bRA);
          this.bQS |= 0x40;
        }
      }
      
      private co<k.s, k.s.a, ai> Dy()
      {
        List localList;
        if (this.bRC == null)
        {
          localList = this.bRA;
          if ((this.bQS & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRC = new co(localList, bool, Ie(), Ic());
          this.bRA = null;
          return this.bRC;
        }
      }
      
      private k.h Eo()
      {
        k.h localh = Ep();
        if (!localh.isInitialized()) {
          throw b(localh);
        }
        return localh;
      }
      
      private a a(k.h.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x1;
        this.bSq = paramb.value;
        onChanged();
        return this;
      }
      
      private a a(k.h.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x4;
        this.bSs = paramc.value;
        onChanged();
        return this;
      }
      
      private a bv(boolean paramBoolean)
      {
        this.bQS |= 0x2;
        this.bSr = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bw(boolean paramBoolean)
      {
        this.bQS |= 0x8;
        this.bSt = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bx(boolean paramBoolean)
      {
        this.bQS |= 0x10;
        this.bRz = paramBoolean;
        onChanged();
        return this;
      }
      
      private a by(boolean paramBoolean)
      {
        this.bQS |= 0x20;
        this.bSu = paramBoolean;
        onChanged();
        return this;
      }
      
      private a n(bt parambt)
      {
        if ((parambt instanceof k.h)) {
          return d((k.h)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a o(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 157	com/google/b/k$h:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 162 3 0
        //   12: checkcast 9	com/google/b/k$h
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 146	com/google/b/k$h$a:d	(Lcom/google/b/k$h;)Lcom/google/b/k$h$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 166	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$h
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 170	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 146	com/google/b/k$h$a:d	(Lcom/google/b/k$h;)Lcom/google/b/k$h$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a y(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a z(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      protected final bb.e Cb()
      {
        return k.BH().b(k.h.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BG();
      }
      
      public final k.h Ep()
      {
        int j = 0;
        k.h localh = new k.h(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        k.h.a(localh, this.bSq);
        int i = j;
        if ((k & 0x2) != 0)
        {
          k.h.a(localh, this.bSr);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        k.h.b(localh, this.bSs);
        i = j;
        if ((k & 0x8) != 0)
        {
          k.h.b(localh, this.bSt);
          i = j | 0x8;
        }
        j = i;
        if ((k & 0x10) != 0)
        {
          k.h.c(localh, this.bRz);
          j = i | 0x10;
        }
        i = j;
        if ((k & 0x20) != 0)
        {
          k.h.d(localh, this.bSu);
          i = j | 0x20;
        }
        if (this.bRC == null)
        {
          if ((this.bQS & 0x40) != 0)
          {
            this.bRA = Collections.unmodifiableList(this.bRA);
            this.bQS &= 0xFFFFFFBF;
          }
          k.h.a(localh, this.bRA);
        }
        for (;;)
        {
          k.h.c(localh, i);
          Ib();
          return localh;
          k.h.a(localh, this.bRC.build());
        }
      }
      
      public final a d(k.h paramh)
      {
        co localco = null;
        if (paramh == k.h.En()) {
          return this;
        }
        if (paramh.Ef()) {
          a(paramh.Eg());
        }
        if (paramh.Eh()) {
          bv(paramh.bSr);
        }
        if (paramh.Ei()) {
          a(paramh.Ej());
        }
        if (paramh.Ek()) {
          bw(paramh.bSt);
        }
        if (paramh.Dr()) {
          bx(paramh.bRz);
        }
        if (paramh.El()) {
          by(paramh.bSu);
        }
        if (this.bRC == null) {
          if (!k.h.c(paramh).isEmpty())
          {
            if (!this.bRA.isEmpty()) {
              break label181;
            }
            this.bRA = k.h.c(paramh);
            this.bQS &= 0xFFFFFFBF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramh);
          z(paramh.bVW);
          onChanged();
          return this;
          label181:
          Dx();
          this.bRA.addAll(k.h.c(paramh));
          break;
          if (!k.h.c(paramh).isEmpty()) {
            if (this.bRC.isEmpty())
            {
              this.bRC.cat = null;
              this.bRC = null;
              this.bRA = k.h.c(paramh);
              this.bQS &= 0xFFFFFFBF;
              if (bb.bXS) {
                localco = Dy();
              }
              this.bRC = localco;
            }
            else
            {
              this.bRC.a(k.h.c(paramh));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bRC == null)
        {
          j = this.bRA.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRC != null) {
            break label65;
          }
          locals = (k.s)this.bRA.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!Ig())
        {
          for (;;)
          {
            return false;
            j = this.bRC.getCount();
            break;
            k.s locals = (k.s)this.bRC.u(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class i
    extends bb
    implements w
  {
    @Deprecated
    public static final ci<i> bRf = new c() {};
    private static final i bSP = new i();
    private int bQS;
    private volatile Object bQT;
    private List<k.g> bQV;
    private List<k.b> bQX;
    private byte bRd = -1;
    private volatile Object bSG;
    bk bSH;
    be.d bSI;
    private be.d bSJ;
    private List<k.a> bSK;
    private List<k.p> bSL;
    private k.j bSM;
    private k.r bSN;
    private volatile Object bSO;
    
    private i()
    {
      this.bQT = "";
      this.bSG = "";
      this.bSH = bj.bZD;
      this.bSI = bd.Il();
      this.bSJ = bd.Il();
      this.bSK = Collections.emptyList();
      this.bQX = Collections.emptyList();
      this.bSL = Collections.emptyList();
      this.bQV = Collections.emptyList();
      this.bSO = "";
    }
    
    private i(bb.a<?> parama)
    {
      super();
    }
    
    private i(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            n = paramh.Av();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (a(paramh, locala, paramap, n)) {
                break label1741;
              }
              j = 1;
              break label1763;
              k = i;
              m = i;
              j = i;
              localObject = paramh.AD();
              k = i;
              m = i;
              j = i;
              this.bQS |= 0x1;
              k = i;
              m = i;
              j = i;
              this.bQT = localObject;
              break label26;
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally
            {
              j = k;
              if ((j & 0x4) != 0) {
                this.bSH = this.bSH.Ix();
              }
              if ((j & 0x20) != 0) {
                this.bSK = Collections.unmodifiableList(this.bSK);
              }
              if ((j & 0x40) != 0) {
                this.bQX = Collections.unmodifiableList(this.bQX);
              }
              if ((j & 0x80) != 0) {
                this.bSL = Collections.unmodifiableList(this.bSL);
              }
              if ((j & 0x100) != 0) {
                this.bQV = Collections.unmodifiableList(this.bQV);
              }
              if ((j & 0x8) != 0) {
                this.bSI.Al();
              }
              if ((j & 0x10) != 0) {
                this.bSJ.Al();
              }
              this.bVW = locala.Jm();
              HZ();
            }
            k = i;
            m = i;
            j = i;
            localObject = paramh.AD();
            k = i;
            m = i;
            j = i;
            this.bQS |= 0x2;
            k = i;
            m = i;
            j = i;
            this.bSG = localObject;
            break;
          }
          catch (IOException paramh)
          {
            j = m;
            paramh = new bf(paramh);
            j = m;
            paramh.bZj = this;
            j = m;
            throw paramh;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            localObject = paramh.AD();
            n = i;
            if ((i & 0x4) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bSH = new bj();
              n = i | 0x4;
            }
            k = n;
            m = n;
            j = n;
            this.bSH.d((g)localObject);
            i = n;
          }
          break;
          int n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bSK = new ArrayList();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.bSK.add(paramh.a(k.a.bRf, paramap));
          i = n;
          break;
          n = i;
          if ((i & 0x40) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQX = new ArrayList();
            n = i | 0x40;
          }
          k = n;
          m = n;
          j = n;
          this.bQX.add(paramh.a(k.b.bRf, paramap));
          i = n;
          break;
          n = i;
          if ((i & 0x80) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bSL = new ArrayList();
            n = i | 0x80;
          }
          k = n;
          m = n;
          j = n;
          this.bSL.add(paramh.a(k.p.bRf, paramap));
          i = n;
          break;
          n = i;
          if ((i & 0x100) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.bQV = new ArrayList();
            n = i | 0x100;
          }
          k = n;
          m = n;
          j = n;
          this.bQV.add(paramh.a(k.g.bRf, paramap));
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          if ((this.bQS & 0x4) != 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (Object localObject = this.bSM.Fr();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.bSM = ((k.j)paramh.a(k.j.bRf, paramap));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((k.j.a)localObject).n(this.bSM);
              k = i;
              m = i;
              j = i;
              this.bSM = ((k.j.a)localObject).Fu();
            }
            k = i;
            m = i;
            j = i;
            this.bQS |= 0x4;
            break;
            k = i;
            m = i;
            j = i;
            if ((this.bQS & 0x8) != 0)
            {
              k = i;
              m = i;
              j = i;
            }
            for (localObject = this.bSN.Go();; localObject = null)
            {
              k = i;
              m = i;
              j = i;
              this.bSN = ((k.r)paramh.a(k.r.bRf, paramap));
              if (localObject != null)
              {
                k = i;
                m = i;
                j = i;
                ((k.r.a)localObject).d(this.bSN);
                k = i;
                m = i;
                j = i;
                this.bSN = ((k.r.a)localObject).Gr();
              }
              k = i;
              m = i;
              j = i;
              this.bQS |= 0x8;
              break;
              n = i;
              if ((i & 0x8) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.bSI = new bd();
                n = i | 0x8;
              }
              k = n;
              m = n;
              j = n;
              this.bSI.hx(paramh.Ay());
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              int i2 = paramh.gA(paramh.AK());
              n = i;
              if ((i & 0x8) == 0)
              {
                k = i;
                m = i;
                j = i;
                n = i;
                if (paramh.AM() > 0)
                {
                  k = i;
                  m = i;
                  j = i;
                  this.bSI = new bd();
                  n = i | 0x8;
                }
              }
              for (;;)
              {
                k = n;
                m = n;
                j = n;
                if (paramh.AM() <= 0) {
                  break;
                }
                k = n;
                m = n;
                j = n;
                this.bSI.hx(paramh.Ay());
              }
              k = n;
              m = n;
              j = n;
              paramh.gB(i2);
              i = n;
              break;
              n = i;
              if ((i & 0x10) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.bSJ = new bd();
                n = i | 0x10;
              }
              k = n;
              m = n;
              j = n;
              this.bSJ.hx(paramh.Ay());
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              i2 = paramh.gA(paramh.AK());
              n = i;
              if ((i & 0x10) == 0)
              {
                k = i;
                m = i;
                j = i;
                n = i;
                if (paramh.AM() > 0)
                {
                  k = i;
                  m = i;
                  j = i;
                  this.bSJ = new bd();
                  n = i | 0x10;
                }
              }
              for (;;)
              {
                k = n;
                m = n;
                j = n;
                if (paramh.AM() <= 0) {
                  break;
                }
                k = n;
                m = n;
                j = n;
                this.bSJ.hx(paramh.Ay());
              }
              k = n;
              m = n;
              j = n;
              paramh.gB(i2);
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              localObject = paramh.AD();
              k = i;
              m = i;
              j = i;
              this.bQS |= 0x10;
              k = i;
              m = i;
              j = i;
              this.bSO = localObject;
              break;
              if ((i & 0x4) != 0) {
                this.bSH = this.bSH.Ix();
              }
              if ((i & 0x20) != 0) {
                this.bSK = Collections.unmodifiableList(this.bSK);
              }
              if ((i & 0x40) != 0) {
                this.bQX = Collections.unmodifiableList(this.bQX);
              }
              if ((i & 0x80) != 0) {
                this.bSL = Collections.unmodifiableList(this.bSL);
              }
              if ((i & 0x100) != 0) {
                this.bQV = Collections.unmodifiableList(this.bQV);
              }
              if ((i & 0x8) != 0) {
                this.bSI.Al();
              }
              if ((i & 0x10) != 0) {
                this.bSJ.Al();
              }
              this.bVW = locala.Jm();
              HZ();
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
    
    public static i C(byte[] paramArrayOfByte)
    {
      return (i)bRf.w(paramArrayOfByte);
    }
    
    public static a EA()
    {
      return bSP.EB();
    }
    
    private a EB()
    {
      if (this == bSP) {
        return new a((byte)0);
      }
      return new a((byte)0).k(this);
    }
    
    public static i EC()
    {
      return bSP;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {}
      for (i = bb.f(1, this.bQT) + 0;; i = 0)
      {
        int j = i;
        if ((this.bQS & 0x2) != 0) {
          j = i + bb.f(2, this.bSG);
        }
        int k = 0;
        i = 0;
        while (k < this.bSH.size())
        {
          i += ao(this.bSH.getRaw(k));
          k += 1;
        }
        int m = this.bSH.size();
        k = 0;
        i = j + i + m * 1;
        j = k;
        while (j < this.bSK.size())
        {
          i += i.c(4, (bw)this.bSK.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQX.size())
        {
          i += i.c(5, (bw)this.bQX.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bSL.size())
        {
          i += i.c(6, (bw)this.bSL.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.bQV.size())
        {
          i += i.c(7, (bw)this.bQV.get(j));
          j += 1;
        }
        j = i;
        if ((this.bQS & 0x4) != 0) {
          j = i + i.c(8, Ev());
        }
        i = j;
        if ((this.bQS & 0x8) != 0) {
          i = j + i.c(9, Ex());
        }
        k = 0;
        j = 0;
        while (k < this.bSI.size())
        {
          j += i.gM(this.bSI.getInt(k));
          k += 1;
        }
        int n = this.bSI.size();
        k = 0;
        m = 0;
        while (k < this.bSJ.size())
        {
          m += i.gM(this.bSJ.getInt(k));
          k += 1;
        }
        j = i + j + n * 1 + m + this.bSJ.size() * 1;
        i = j;
        if ((this.bQS & 0x10) != 0) {
          i = j + bb.f(12, this.bSO);
        }
        i += this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Bf().b(i.class, a.class);
    }
    
    public final boolean Cc()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final int Ce()
    {
      return this.bQV.size();
    }
    
    public final int Cg()
    {
      return this.bQX.size();
    }
    
    public final boolean Cj()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final ci<i> Co()
    {
      return bRf;
    }
    
    public final boolean Eq()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final int Er()
    {
      return this.bSH.size();
    }
    
    public final int Es()
    {
      return this.bSI.size();
    }
    
    public final int Et()
    {
      return this.bSK.size();
    }
    
    public final int Eu()
    {
      return this.bSL.size();
    }
    
    public final k.j Ev()
    {
      if (this.bSM == null) {
        return k.j.Fs();
      }
      return this.bSM;
    }
    
    public final boolean Ew()
    {
      return (this.bQS & 0x8) != 0;
    }
    
    public final k.r Ex()
    {
      if (this.bSN == null) {
        return k.r.Gp();
      }
      return this.bSN;
    }
    
    public final boolean Ey()
    {
      return (this.bQS & 0x10) != 0;
    }
    
    public final String Ez()
    {
      Object localObject = this.bSO;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bSO = str;
      }
      return str;
    }
    
    public final void a(i parami)
    {
      int k = 0;
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bQT);
      }
      if ((this.bQS & 0x2) != 0) {
        bb.a(parami, 2, this.bSG);
      }
      int i = 0;
      while (i < this.bSH.size())
      {
        bb.a(parami, 3, this.bSH.getRaw(i));
        i += 1;
      }
      i = 0;
      while (i < this.bSK.size())
      {
        parami.a(4, (bw)this.bSK.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQX.size())
      {
        parami.a(5, (bw)this.bQX.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bSL.size())
      {
        parami.a(6, (bw)this.bSL.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.bQV.size())
      {
        parami.a(7, (bw)this.bQV.get(i));
        i += 1;
      }
      if ((this.bQS & 0x4) != 0) {
        parami.a(8, Ev());
      }
      if ((this.bQS & 0x8) != 0) {
        parami.a(9, Ex());
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.bSI.size()) {
          break;
        }
        parami.bJ(10, this.bSI.getInt(i));
        i += 1;
      }
      while (j < this.bSJ.size())
      {
        parami.bJ(11, this.bSJ.getInt(j));
        j += 1;
      }
      if ((this.bQS & 0x10) != 0) {
        bb.a(parami, 12, this.bSO);
      }
      this.bVW.a(parami);
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
        if (Cc() != paramObject.Cc()) {
          return false;
        }
        if ((Cc()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (Eq() != paramObject.Eq()) {
          return false;
        }
        if ((Eq()) && (!getPackage().equals(paramObject.getPackage()))) {
          return false;
        }
        if (!this.bSH.equals(paramObject.bSH)) {
          return false;
        }
        if (!this.bSI.equals(paramObject.bSI)) {
          return false;
        }
        if (!this.bSJ.equals(paramObject.bSJ)) {
          return false;
        }
        if (!this.bSK.equals(paramObject.bSK)) {
          return false;
        }
        if (!this.bQX.equals(paramObject.bQX)) {
          return false;
        }
        if (!this.bSL.equals(paramObject.bSL)) {
          return false;
        }
        if (!this.bQV.equals(paramObject.bQV)) {
          return false;
        }
        if (Cj() != paramObject.Cj()) {
          return false;
        }
        if ((Cj()) && (!Ev().equals(paramObject.Ev()))) {
          return false;
        }
        if (Ew() != paramObject.Ew()) {
          return false;
        }
        if ((Ew()) && (!Ex().equals(paramObject.Ex()))) {
          return false;
        }
        if (Ey() != paramObject.Ey()) {
          return false;
        }
        if ((Ey()) && (!Ez().equals(paramObject.Ez()))) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final k.g gT(int paramInt)
    {
      return (k.g)this.bQV.get(paramInt);
    }
    
    public final k.b gV(int paramInt)
    {
      return (k.b)this.bQX.get(paramInt);
    }
    
    public final String getName()
    {
      Object localObject = this.bQT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bQT = str;
      }
      return str;
    }
    
    public final String getPackage()
    {
      Object localObject = this.bSG;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bSG = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Be().hashCode() + 779;
      int i = j;
      if (Cc()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (Eq()) {
        j = (i * 37 + 2) * 53 + getPackage().hashCode();
      }
      i = j;
      if (Er() > 0) {
        i = (j * 37 + 3) * 53 + this.bSH.hashCode();
      }
      j = i;
      if (Es() > 0) {
        j = (i * 37 + 10) * 53 + this.bSI.hashCode();
      }
      i = j;
      if (this.bSJ.size() > 0) {
        i = (j * 37 + 11) * 53 + this.bSJ.hashCode();
      }
      j = i;
      if (Et() > 0) {
        j = (i * 37 + 4) * 53 + this.bSK.hashCode();
      }
      i = j;
      if (Cg() > 0) {
        i = (j * 37 + 5) * 53 + this.bQX.hashCode();
      }
      j = i;
      if (Eu() > 0) {
        j = (i * 37 + 6) * 53 + this.bSL.hashCode();
      }
      i = j;
      if (Ce() > 0) {
        i = (j * 37 + 7) * 53 + this.bQV.hashCode();
      }
      j = i;
      if (Cj()) {
        j = (i * 37 + 8) * 53 + Ev().hashCode();
      }
      i = j;
      if (Ew()) {
        i = (j * 37 + 9) * 53 + Ex().hashCode();
      }
      j = i;
      if (Ey()) {
        j = (i * 37 + 12) * 53 + Ez().hashCode();
      }
      i = j * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final k.a hl(int paramInt)
    {
      return (k.a)this.bSK.get(paramInt);
    }
    
    public final k.p hm(int paramInt)
    {
      return (k.p)this.bSL.get(paramInt);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Et())
      {
        if (!hl(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Cg())
      {
        if (!gV(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Eu())
      {
        if (!hm(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < Ce())
      {
        if (!gT(i).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if ((Cj()) && (!Ev().isInitialized()))
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements w
    {
      private int bQS;
      private Object bQT = "";
      private List<k.g> bQV = Collections.emptyList();
      private List<k.b> bQX = Collections.emptyList();
      private co<k.g, k.g.a, u> bRh;
      private co<k.b, k.b.a, p> bRj;
      private cs<k.j, k.j.a, x> bRm;
      private Object bSG = "";
      private bk bSH = bj.bZD;
      private be.d bSI = bb.HY();
      private be.d bSJ = bb.HY();
      private List<k.a> bSK = Collections.emptyList();
      private List<k.p> bSL = Collections.emptyList();
      private k.j bSM;
      private k.r bSN;
      private Object bSO = "";
      private co<k.a, k.a.a, n> bSQ;
      private co<k.p, k.p.a, ad> bSR;
      private cs<k.r, k.r.a, ag> bSS;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private a A(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a B(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a C(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private void CA()
      {
        if ((this.bQS & 0x100) == 0)
        {
          this.bQV = new ArrayList(this.bQV);
          this.bQS |= 0x100;
        }
      }
      
      private co<k.g, k.g.a, u> CB()
      {
        List localList;
        if (this.bRh == null)
        {
          localList = this.bQV;
          if ((this.bQS & 0x100) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.bRh = new co(localList, bool, Ie(), Ic());
          this.bQV = null;
          return this.bRh;
        }
      }
      
      private void CE()
      {
        if ((this.bQS & 0x40) == 0)
        {
          this.bQX = new ArrayList(this.bQX);
          this.bQS |= 0x40;
        }
      }
      
      private co<k.b, k.b.a, p> CF()
      {
        List localList;
        if (this.bRj == null)
        {
          localList = this.bQX;
          if ((this.bQS & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRj = new co(localList, bool, Ie(), Ic());
          this.bQX = null;
          return this.bRj;
        }
      }
      
      private cs<k.j, k.j.a, x> CK()
      {
        if (this.bRm == null)
        {
          this.bRm = new cs(Ev(), Ie(), Ic());
          this.bSM = null;
        }
        return this.bRm;
      }
      
      private void Cu()
      {
        if (bb.bXS)
        {
          EJ();
          CF();
          EL();
          CB();
          CK();
          EM();
        }
      }
      
      private a D(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private k.i EE()
      {
        int i = 0;
        k.i locali = new k.i(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        k.i.a(locali, this.bQT);
        if ((k & 0x2) != 0) {
          i |= 0x2;
        }
        label277:
        label406:
        label543:
        label562:
        for (;;)
        {
          k.i.b(locali, this.bSG);
          if ((this.bQS & 0x4) != 0)
          {
            this.bSH = this.bSH.Ix();
            this.bQS &= 0xFFFFFFFB;
          }
          k.i.a(locali, this.bSH);
          if ((this.bQS & 0x8) != 0)
          {
            this.bSI.Al();
            this.bQS &= 0xFFFFFFF7;
          }
          k.i.a(locali, this.bSI);
          if ((this.bQS & 0x10) != 0)
          {
            this.bSJ.Al();
            this.bQS &= 0xFFFFFFEF;
          }
          k.i.b(locali, this.bSJ);
          label328:
          label379:
          int j;
          if (this.bSQ == null)
          {
            if ((this.bQS & 0x20) != 0)
            {
              this.bSK = Collections.unmodifiableList(this.bSK);
              this.bQS &= 0xFFFFFFDF;
            }
            k.i.a(locali, this.bSK);
            if (this.bRj != null) {
              break label495;
            }
            if ((this.bQS & 0x40) != 0)
            {
              this.bQX = Collections.unmodifiableList(this.bQX);
              this.bQS &= 0xFFFFFFBF;
            }
            k.i.b(locali, this.bQX);
            if (this.bSR != null) {
              break label511;
            }
            if ((this.bQS & 0x80) != 0)
            {
              this.bSL = Collections.unmodifiableList(this.bSL);
              this.bQS &= 0xFFFFFF7F;
            }
            k.i.c(locali, this.bSL);
            if (this.bRh != null) {
              break label527;
            }
            if ((this.bQS & 0x100) != 0)
            {
              this.bQV = Collections.unmodifiableList(this.bQV);
              this.bQS &= 0xFFFFFEFF;
            }
            k.i.d(locali, this.bQV);
            j = i;
            if ((k & 0x200) != 0)
            {
              if (this.bRm != null) {
                break label543;
              }
              k.i.a(locali, this.bSM);
              j = i | 0x4;
            }
            if ((k & 0x400) == 0) {
              break label581;
            }
            if (this.bSS != null) {
              break label562;
            }
            k.i.a(locali, this.bSN);
          }
          label435:
          label581:
          for (i = j | 0x8;; i = j)
          {
            j = i;
            if ((k & 0x800) != 0) {
              j = i | 0x10;
            }
            k.i.c(locali, this.bSO);
            k.i.a(locali, j);
            Ib();
            return locali;
            k.i.a(locali, this.bSQ.build());
            break;
            label495:
            k.i.b(locali, this.bRj.build());
            break label277;
            label511:
            k.i.c(locali, this.bSR.build());
            break label328;
            k.i.d(locali, this.bRh.build());
            break label379;
            k.i.a(locali, (k.j)this.bRm.IV());
            break label406;
            k.i.a(locali, (k.r)this.bSS.IV());
            break label435;
          }
        }
      }
      
      private void EF()
      {
        if ((this.bQS & 0x4) == 0)
        {
          this.bSH = new bj(this.bSH);
          this.bQS |= 0x4;
        }
      }
      
      private void EG()
      {
        if ((this.bQS & 0x8) == 0)
        {
          this.bSI = bb.a(this.bSI);
          this.bQS |= 0x8;
        }
      }
      
      private void EH()
      {
        if ((this.bQS & 0x10) == 0)
        {
          this.bSJ = bb.a(this.bSJ);
          this.bQS |= 0x10;
        }
      }
      
      private void EI()
      {
        if ((this.bQS & 0x20) == 0)
        {
          this.bSK = new ArrayList(this.bSK);
          this.bQS |= 0x20;
        }
      }
      
      private co<k.a, k.a.a, n> EJ()
      {
        List localList;
        if (this.bSQ == null)
        {
          localList = this.bSK;
          if ((this.bQS & 0x20) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bSQ = new co(localList, bool, Ie(), Ic());
          this.bSK = null;
          return this.bSQ;
        }
      }
      
      private void EK()
      {
        if ((this.bQS & 0x80) == 0)
        {
          this.bSL = new ArrayList(this.bSL);
          this.bQS |= 0x80;
        }
      }
      
      private co<k.p, k.p.a, ad> EL()
      {
        List localList;
        if (this.bSR == null)
        {
          localList = this.bSL;
          if ((this.bQS & 0x80) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.bSR = new co(localList, bool, Ie(), Ic());
          this.bSL = null;
          return this.bSR;
        }
      }
      
      private cs<k.r, k.r.a, ag> EM()
      {
        if (this.bSS == null)
        {
          this.bSS = new cs(Ex(), Ie(), Ic());
          this.bSN = null;
        }
        return this.bSS;
      }
      
      private k.j Ev()
      {
        if (this.bRm == null)
        {
          if (this.bSM == null) {
            return k.j.Fs();
          }
          return this.bSM;
        }
        return (k.j)this.bRm.IU();
      }
      
      private k.r Ex()
      {
        if (this.bSS == null)
        {
          if (this.bSN == null) {
            return k.r.Gp();
          }
          return this.bSN;
        }
        return (k.r)this.bSS.IU();
      }
      
      private a a(k.j paramj)
      {
        if (this.bRm == null) {
          if (((this.bQS & 0x200) != 0) && (this.bSM != null) && (this.bSM != k.j.Fs()))
          {
            this.bSM = k.j.b(this.bSM).n(paramj).Fu();
            onChanged();
          }
        }
        for (;;)
        {
          this.bQS |= 0x200;
          return this;
          this.bSM = paramj;
          break;
          this.bRm.c(paramj);
        }
      }
      
      private a a(k.r paramr)
      {
        if (this.bSS == null) {
          if (((this.bQS & 0x400) != 0) && (this.bSN != null) && (this.bSN != k.r.Gp()))
          {
            this.bSN = k.r.b(this.bSN).d(paramr).Gr();
            onChanged();
          }
        }
        for (;;)
        {
          this.bQS |= 0x400;
          return this;
          this.bSN = paramr;
          break;
          this.bSS.c(paramr);
        }
      }
      
      private a o(bt parambt)
      {
        if ((parambt instanceof k.i)) {
          return k((k.i)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a p(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 340	com/google/b/k$i:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 345 3 0
        //   12: checkcast 9	com/google/b/k$i
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 329	com/google/b/k$i$a:k	(Lcom/google/b/k$i;)Lcom/google/b/k$i$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 349	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$i
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 353	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 329	com/google/b/k$i$a:k	(Lcom/google/b/k$i;)Lcom/google/b/k$i$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      protected final bb.e Cb()
      {
        return k.Bf().b(k.i.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.Be();
      }
      
      public final k.i ED()
      {
        k.i locali = EE();
        if (!locali.isInitialized()) {
          throw b(locali);
        }
        return locali;
      }
      
      public final a cA(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x1;
        this.bQT = paramString;
        onChanged();
        return this;
      }
      
      public final a cB(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bQS |= 0x2;
        this.bSG = paramString;
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        Object localObject;
        if (this.bSQ == null)
        {
          j = this.bSK.size();
          if (i >= j) {
            break label88;
          }
          if (this.bSQ != null) {
            break label65;
          }
          localObject = (k.a)this.bSK.get(i);
          label45:
          if (((k.a)localObject).isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.bSQ.getCount();
          break label19;
          label65:
          localObject = (k.a)this.bSQ.u(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          i = 0;
          if (this.bRj == null)
          {
            j = this.bQX.size();
            label107:
            if (i >= j) {
              break label174;
            }
            if (this.bRj != null) {
              break label158;
            }
          }
          label158:
          for (localObject = (k.b)this.bQX.get(i);; localObject = (k.b)this.bRj.u(i, false))
          {
            if (!((k.b)localObject).isInitialized()) {
              break label172;
            }
            i += 1;
            break;
            j = this.bRj.getCount();
            break label107;
          }
          label172:
          continue;
          label174:
          i = 0;
          if (this.bSR == null)
          {
            j = this.bSL.size();
            label193:
            if (i >= j) {
              break label260;
            }
            if (this.bSR != null) {
              break label244;
            }
          }
          label244:
          for (localObject = (k.p)this.bSL.get(i);; localObject = (k.p)this.bSR.u(i, false))
          {
            if (!((k.p)localObject).isInitialized()) {
              break label258;
            }
            i += 1;
            break;
            j = this.bSR.getCount();
            break label193;
          }
          label258:
          continue;
          label260:
          i = 0;
          if (this.bRh == null)
          {
            j = this.bQV.size();
            label279:
            if (i >= j) {
              break label346;
            }
            if (this.bRh != null) {
              break label330;
            }
          }
          label330:
          for (localObject = (k.g)this.bQV.get(i);; localObject = (k.g)this.bRh.u(i, false))
          {
            if (!((k.g)localObject).isInitialized()) {
              break label344;
            }
            i += 1;
            break;
            j = this.bRh.getCount();
            break label279;
          }
          label344:
          continue;
          label346:
          if ((this.bQS & 0x200) != 0) {}
          for (i = 1; (i == 0) || (Ev().isInitialized()); i = 0) {
            return true;
          }
        }
      }
      
      public final a k(k.a parama)
      {
        if (this.bSQ == null)
        {
          if (parama == null) {
            throw new NullPointerException();
          }
          EI();
          this.bSK.add(parama);
          onChanged();
          return this;
        }
        this.bSQ.a(parama);
        return this;
      }
      
      public final a k(k.i parami)
      {
        Object localObject2 = null;
        if (parami == k.i.EC()) {
          return this;
        }
        if (parami.Cc())
        {
          this.bQS |= 0x1;
          this.bQT = k.i.a(parami);
          onChanged();
        }
        if (parami.Eq())
        {
          this.bQS |= 0x2;
          this.bSG = k.i.b(parami);
          onChanged();
        }
        if (!k.i.c(parami).isEmpty())
        {
          if (this.bSH.isEmpty())
          {
            this.bSH = k.i.c(parami);
            this.bQS &= 0xFFFFFFFB;
            onChanged();
          }
        }
        else
        {
          if (!k.i.d(parami).isEmpty())
          {
            if (!this.bSI.isEmpty()) {
              break label527;
            }
            this.bSI = k.i.d(parami);
            this.bQS &= 0xFFFFFFF7;
            label159:
            onChanged();
          }
          if (!k.i.e(parami).isEmpty())
          {
            if (!this.bSJ.isEmpty()) {
              break label548;
            }
            this.bSJ = k.i.e(parami);
            this.bQS &= 0xFFFFFFEF;
            label206:
            onChanged();
          }
          if (this.bSQ != null) {
            break label590;
          }
          if (!k.i.f(parami).isEmpty())
          {
            if (!this.bSK.isEmpty()) {
              break label569;
            }
            this.bSK = k.i.f(parami);
            this.bQS &= 0xFFFFFFDF;
            label260:
            onChanged();
          }
          label264:
          if (this.bRj != null) {
            break label704;
          }
          if (!k.i.g(parami).isEmpty())
          {
            if (!this.bQX.isEmpty()) {
              break label683;
            }
            this.bQX = k.i.g(parami);
            this.bQS &= 0xFFFFFFBF;
            label314:
            onChanged();
          }
          label318:
          if (this.bSR != null) {
            break label818;
          }
          if (!k.i.h(parami).isEmpty())
          {
            if (!this.bSL.isEmpty()) {
              break label797;
            }
            this.bSL = k.i.h(parami);
            this.bQS &= 0xFFFFFF7F;
            label369:
            onChanged();
          }
          label373:
          if (this.bRh != null) {
            break label933;
          }
          if (!k.i.i(parami).isEmpty())
          {
            if (!this.bQV.isEmpty()) {
              break label912;
            }
            this.bQV = k.i.i(parami);
            this.bQS &= 0xFFFFFEFF;
            label424:
            onChanged();
          }
        }
        for (;;)
        {
          if (parami.Cj()) {
            a(parami.Ev());
          }
          if (parami.Ew()) {
            a(parami.Ex());
          }
          if (parami.Ey())
          {
            this.bQS |= 0x800;
            this.bSO = k.i.j(parami);
            onChanged();
          }
          B(parami.bVW);
          onChanged();
          return this;
          EF();
          this.bSH.addAll(k.i.c(parami));
          break;
          label527:
          EG();
          this.bSI.addAll(k.i.d(parami));
          break label159;
          label548:
          EH();
          this.bSJ.addAll(k.i.e(parami));
          break label206;
          label569:
          EI();
          this.bSK.addAll(k.i.f(parami));
          break label260;
          label590:
          if (k.i.f(parami).isEmpty()) {
            break label264;
          }
          Object localObject1;
          if (this.bSQ.isEmpty())
          {
            this.bSQ.cat = null;
            this.bSQ = null;
            this.bSK = k.i.f(parami);
            this.bQS &= 0xFFFFFFDF;
            if (bb.bXS) {}
            for (localObject1 = EJ();; localObject1 = null)
            {
              this.bSQ = ((co)localObject1);
              break;
            }
          }
          this.bSQ.a(k.i.f(parami));
          break label264;
          label683:
          CE();
          this.bQX.addAll(k.i.g(parami));
          break label314;
          label704:
          if (k.i.g(parami).isEmpty()) {
            break label318;
          }
          if (this.bRj.isEmpty())
          {
            this.bRj.cat = null;
            this.bRj = null;
            this.bQX = k.i.g(parami);
            this.bQS &= 0xFFFFFFBF;
            if (bb.bXS) {}
            for (localObject1 = CF();; localObject1 = null)
            {
              this.bRj = ((co)localObject1);
              break;
            }
          }
          this.bRj.a(k.i.g(parami));
          break label318;
          label797:
          EK();
          this.bSL.addAll(k.i.h(parami));
          break label369;
          label818:
          if (k.i.h(parami).isEmpty()) {
            break label373;
          }
          if (this.bSR.isEmpty())
          {
            this.bSR.cat = null;
            this.bSR = null;
            this.bSL = k.i.h(parami);
            this.bQS &= 0xFFFFFF7F;
            if (bb.bXS) {}
            for (localObject1 = EL();; localObject1 = null)
            {
              this.bSR = ((co)localObject1);
              break;
            }
          }
          this.bSR.a(k.i.h(parami));
          break label373;
          label912:
          CA();
          this.bQV.addAll(k.i.i(parami));
          break label424;
          label933:
          if (!k.i.i(parami).isEmpty()) {
            if (this.bRh.isEmpty())
            {
              this.bRh.cat = null;
              this.bRh = null;
              this.bQV = k.i.i(parami);
              this.bQS &= 0xFFFFFEFF;
              localObject1 = localObject2;
              if (bb.bXS) {
                localObject1 = CB();
              }
              this.bRh = ((co)localObject1);
            }
            else
            {
              this.bRh.a(k.i.i(parami));
            }
          }
        }
      }
    }
  }
  
  public static final class k
    extends bb.d<k>
    implements y
  {
    @Deprecated
    public static final ci<k> bRf = new c() {};
    private static final k bTv = new k();
    private int bQS;
    private List<k.s> bRA;
    private byte bRd = -1;
    boolean bRz;
    boolean bTs;
    boolean bTt;
    boolean bTu;
    
    private k()
    {
      this.bRA = Collections.emptyList();
    }
    
    private k(bb.c<k, ?> paramc)
    {
      super();
    }
    
    private k(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
            j = paramh.Av();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (a(paramh, locala, paramap, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bQS |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.bTs = paramh.AB();
              break label26;
            }
          }
          catch (bf paramh)
          {
            try
            {
              paramh.bZj = this;
              throw paramh;
            }
            finally
            {
              k = n;
              if ((k & 0x10) != 0) {
                this.bRA = Collections.unmodifiableList(this.bRA);
              }
              this.bVW = locala.Jm();
              this.bXY.Al();
            }
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.bTt = paramh.AB();
            break;
          }
          catch (IOException paramh)
          {
            k = i1;
            paramh = new bf(paramh);
            k = i1;
            paramh.bZj = this;
            k = i1;
            throw paramh;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x4;
            n = i;
            i1 = i;
            k = i;
            this.bRz = paramh.AB();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.bTu = paramh.AB();
          break;
          int j = i;
          if ((i & 0x10) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bRA = new ArrayList();
            j = i | 0x10;
          }
          n = j;
          i1 = j;
          k = j;
          this.bRA.add(paramh.a(k.s.bRf, paramap));
          i = j;
          break;
          if ((i & 0x10) != 0) {
            this.bRA = Collections.unmodifiableList(this.bRA);
          }
          this.bVW = locala.Jm();
          this.bXY.Al();
          return;
        }
        m = 1;
      }
    }
    
    private int Ds()
    {
      return this.bRA.size();
    }
    
    public static k Fz()
    {
      return bTv;
    }
    
    public static a b(k paramk)
    {
      return bTv.Fy().d(paramk);
    }
    
    public final int Ad()
    {
      int k = 0;
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      if ((this.bQS & 0x1) != 0) {}
      for (int j = i.gK(1) + 0;; j = 0)
      {
        i = j;
        if ((this.bQS & 0x2) != 0) {
          i = j + i.gK(2);
        }
        j = i;
        if ((this.bQS & 0x4) != 0) {
          j = i + i.gK(3);
        }
        i = j;
        if ((this.bQS & 0x8) != 0) {
          i = j + i.gK(7);
        }
        j = k;
        while (j < this.bRA.size())
        {
          k = i.c(999, (bw)this.bRA.get(j));
          j += 1;
          i = k + i;
        }
        i = Ii() + i + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BF().b(k.class, a.class);
    }
    
    public final ci<k> Co()
    {
      return bRf;
    }
    
    public final boolean Dr()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final boolean Fv()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Fw()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final boolean Fx()
    {
      return (this.bQS & 0x8) != 0;
    }
    
    public final a Fy()
    {
      if (this == bTv) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      bb.d.a locala = Ih();
      if ((this.bQS & 0x1) != 0) {
        parami.t(1, this.bTs);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.t(2, this.bTt);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.t(3, this.bRz);
      }
      if ((this.bQS & 0x8) != 0) {
        parami.t(7, this.bTu);
      }
      int i = 0;
      while (i < this.bRA.size())
      {
        parami.a(999, (bw)this.bRA.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bVW.a(parami);
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
        if (Fv() != paramObject.Fv()) {
          return false;
        }
        if ((Fv()) && (this.bTs != paramObject.bTs)) {
          return false;
        }
        if (Fw() != paramObject.Fw()) {
          return false;
        }
        if ((Fw()) && (this.bTt != paramObject.bTt)) {
          return false;
        }
        if (Dr() != paramObject.Dr()) {
          return false;
        }
        if ((Dr()) && (this.bRz != paramObject.bRz)) {
          return false;
        }
        if (Fx() != paramObject.Fx()) {
          return false;
        }
        if ((Fx()) && (this.bTu != paramObject.bTu)) {
          return false;
        }
        if (!this.bRA.equals(paramObject.bRA)) {
          return false;
        }
        if (!this.bVW.equals(paramObject.bVW)) {
          return false;
        }
      } while (Ij().equals(paramObject.Ij()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BE().hashCode() + 779;
      int i = j;
      if (Fv()) {
        i = (j * 37 + 1) * 53 + be.bS(this.bTs);
      }
      j = i;
      if (Fw()) {
        j = (i * 37 + 2) * 53 + be.bS(this.bTt);
      }
      i = j;
      if (Dr()) {
        i = (j * 37 + 3) * 53 + be.bS(this.bRz);
      }
      j = i;
      if (Fx()) {
        j = (i * 37 + 7) * 53 + be.bS(this.bTu);
      }
      i = j;
      if (Ds() > 0) {
        i = (j * 37 + 999) * 53 + this.bRA.hashCode();
      }
      i = a(i, Ij()) * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ds())
      {
        if (!((k.s)this.bRA.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.c<k.k, a>
      implements y
    {
      private int bQS;
      private List<k.s> bRA = Collections.emptyList();
      private co<k.s, k.s.a, ai> bRC;
      private boolean bRz;
      private boolean bTs;
      private boolean bTt;
      private boolean bTu;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Dy();
        }
      }
      
      private void Dx()
      {
        if ((this.bQS & 0x10) == 0)
        {
          this.bRA = new ArrayList(this.bRA);
          this.bQS |= 0x10;
        }
      }
      
      private co<k.s, k.s.a, ai> Dy()
      {
        List localList;
        if (this.bRC == null)
        {
          localList = this.bRA;
          if ((this.bQS & 0x10) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.bRC = new co(localList, bool, Ie(), Ic());
          this.bRA = null;
          return this.bRC;
        }
      }
      
      private a E(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a F(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private k.k FA()
      {
        k.k localk = FB();
        if (!localk.isInitialized()) {
          throw b(localk);
        }
        return localk;
      }
      
      private a G(aj.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a H(aj.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a bI(boolean paramBoolean)
      {
        this.bQS |= 0x1;
        this.bTs = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bJ(boolean paramBoolean)
      {
        this.bQS |= 0x2;
        this.bTt = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bK(boolean paramBoolean)
      {
        this.bQS |= 0x4;
        this.bRz = paramBoolean;
        onChanged();
        return this;
      }
      
      private a bL(boolean paramBoolean)
      {
        this.bQS |= 0x8;
        this.bTu = paramBoolean;
        onChanged();
        return this;
      }
      
      private a q(bt parambt)
      {
        if ((parambt instanceof k.k)) {
          return d((k.k)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a r(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 145	com/google/b/k$k:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 150 3 0
        //   12: checkcast 9	com/google/b/k$k
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 135	com/google/b/k$k$a:d	(Lcom/google/b/k$k;)Lcom/google/b/k$k$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 154	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$k
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 158	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 135	com/google/b/k$k$a:d	(Lcom/google/b/k$k;)Lcom/google/b/k$k$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      protected final bb.e Cb()
      {
        return k.BF().b(k.k.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BE();
      }
      
      public final k.k FB()
      {
        int j = 0;
        k.k localk = new k.k(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0)
        {
          k.k.a(localk, this.bTs);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0)
        {
          k.k.b(localk, this.bTt);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0)
        {
          k.k.c(localk, this.bRz);
          j = i | 0x4;
        }
        i = j;
        if ((k & 0x8) != 0)
        {
          k.k.d(localk, this.bTu);
          i = j | 0x8;
        }
        if (this.bRC == null)
        {
          if ((this.bQS & 0x10) != 0)
          {
            this.bRA = Collections.unmodifiableList(this.bRA);
            this.bQS &= 0xFFFFFFEF;
          }
          k.k.a(localk, this.bRA);
        }
        for (;;)
        {
          k.k.a(localk, i);
          Ib();
          return localk;
          k.k.a(localk, this.bRC.build());
        }
      }
      
      public final a d(k.k paramk)
      {
        co localco = null;
        if (paramk == k.k.Fz()) {
          return this;
        }
        if (paramk.Fv()) {
          bI(paramk.bTs);
        }
        if (paramk.Fw()) {
          bJ(paramk.bTt);
        }
        if (paramk.Dr()) {
          bK(paramk.bRz);
        }
        if (paramk.Fx()) {
          bL(paramk.bTu);
        }
        if (this.bRC == null) {
          if (!k.k.c(paramk).isEmpty())
          {
            if (!this.bRA.isEmpty()) {
              break label149;
            }
            this.bRA = k.k.c(paramk);
            this.bQS &= 0xFFFFFFEF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramk);
          F(paramk.bVW);
          onChanged();
          return this;
          label149:
          Dx();
          this.bRA.addAll(k.k.c(paramk));
          break;
          if (!k.k.c(paramk).isEmpty()) {
            if (this.bRC.isEmpty())
            {
              this.bRC.cat = null;
              this.bRC = null;
              this.bRA = k.k.c(paramk);
              this.bQS &= 0xFFFFFFEF;
              if (bb.bXS) {
                localco = Dy();
              }
              this.bRC = localco;
            }
            else
            {
              this.bRC.a(k.k.c(paramk));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bRC == null)
        {
          j = this.bRA.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRC != null) {
            break label65;
          }
          locals = (k.s)this.bRA.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!Ig())
        {
          for (;;)
          {
            return false;
            j = this.bRC.getCount();
            break;
            k.s locals = (k.s)this.bRC.u(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static enum m$b
    implements cl
  {
    private static final be.b<b> bRT = new be.b() {};
    private static final b[] bTH = values();
    final int value;
    
    private m$b(int paramInt)
    {
      this.value = paramInt;
    }
    
    @Deprecated
    public static b ho(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return bTE;
      case 1: 
        return bTF;
      }
      return bTG;
    }
    
    public final int getNumber()
    {
      return this.value;
    }
  }
  
  public static final class n
    extends bb
    implements ab
  {
    @Deprecated
    public static final ci<n> bRf = new k.n.1();
    private static final n bTK = new n();
    private int bQS;
    private volatile Object bQT;
    private byte bRd = -1;
    private k.o bTJ;
    
    private n()
    {
      this.bQT = "";
    }
    
    private n(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private n(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 30	com/google/b/k$n:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 59	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 60	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 66	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +198 -> 222
      //   27: aload_1
      //   28: invokevirtual 72	com/google/b/h:Av	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+210->245, 0:+216->251, 10:+51->86, 18:+100->135
      //   69: aload_1
      //   70: aload 6
      //   72: aload_2
      //   73: iload 4
      //   75: invokevirtual 76	com/google/b/k$n:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   78: ifne +158 -> 236
      //   81: iconst_1
      //   82: istore_3
      //   83: goto +165 -> 248
      //   86: aload_1
      //   87: invokevirtual 80	com/google/b/h:AD	()Lcom/google/b/g;
      //   90: astore 5
      //   92: aload_0
      //   93: aload_0
      //   94: getfield 82	com/google/b/k$n:bQS	I
      //   97: iconst_1
      //   98: ior
      //   99: putfield 82	com/google/b/k$n:bQS	I
      //   102: aload_0
      //   103: aload 5
      //   105: putfield 45	com/google/b/k$n:bQT	Ljava/lang/Object;
      //   108: goto -85 -> 23
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   117: aload_1
      //   118: athrow
      //   119: astore_1
      //   120: aload_0
      //   121: aload 6
      //   123: invokevirtual 92	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   126: putfield 96	com/google/b/k$n:bVW	Lcom/google/b/da;
      //   129: aload_0
      //   130: invokevirtual 99	com/google/b/k$n:HZ	()V
      //   133: aload_1
      //   134: athrow
      //   135: aload_0
      //   136: getfield 82	com/google/b/k$n:bQS	I
      //   139: iconst_2
      //   140: iand
      //   141: ifeq +98 -> 239
      //   144: aload_0
      //   145: getfield 101	com/google/b/k$n:bTJ	Lcom/google/b/k$o;
      //   148: invokevirtual 107	com/google/b/k$o:FY	()Lcom/google/b/k$o$a;
      //   151: astore 5
      //   153: aload_0
      //   154: aload_1
      //   155: getstatic 108	com/google/b/k$o:bRf	Lcom/google/b/ci;
      //   158: aload_2
      //   159: invokevirtual 111	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
      //   162: checkcast 103	com/google/b/k$o
      //   165: putfield 101	com/google/b/k$n:bTJ	Lcom/google/b/k$o;
      //   168: aload 5
      //   170: ifnull +22 -> 192
      //   173: aload 5
      //   175: aload_0
      //   176: getfield 101	com/google/b/k$n:bTJ	Lcom/google/b/k$o;
      //   179: invokevirtual 117	com/google/b/k$o$a:d	(Lcom/google/b/k$o;)Lcom/google/b/k$o$a;
      //   182: pop
      //   183: aload_0
      //   184: aload 5
      //   186: invokevirtual 121	com/google/b/k$o$a:Gb	()Lcom/google/b/k$o;
      //   189: putfield 101	com/google/b/k$n:bTJ	Lcom/google/b/k$o;
      //   192: aload_0
      //   193: aload_0
      //   194: getfield 82	com/google/b/k$n:bQS	I
      //   197: iconst_2
      //   198: ior
      //   199: putfield 82	com/google/b/k$n:bQS	I
      //   202: goto -179 -> 23
      //   205: astore_1
      //   206: new 55	com/google/b/bf
      //   209: dup
      //   210: aload_1
      //   211: invokespecial 124	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   214: astore_1
      //   215: aload_1
      //   216: aload_0
      //   217: putfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   220: aload_1
      //   221: athrow
      //   222: aload_0
      //   223: aload 6
      //   225: invokevirtual 92	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   228: putfield 96	com/google/b/k$n:bVW	Lcom/google/b/da;
      //   231: aload_0
      //   232: invokevirtual 99	com/google/b/k$n:HZ	()V
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
      //   0	256	0	this	n
      //   0	256	1	paramh	h
      //   0	256	2	paramap	ap
      //   22	231	3	i	int
      //   31	43	4	j	int
      //   90	151	5	localObject	Object
      //   19	205	6	locala	da.a
      // Exception table:
      //   from	to	target	type
      //   27	33	111	com/google/b/bf
      //   68	81	111	com/google/b/bf
      //   86	108	111	com/google/b/bf
      //   135	153	111	com/google/b/bf
      //   153	168	111	com/google/b/bf
      //   173	192	111	com/google/b/bf
      //   192	202	111	com/google/b/bf
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
    
    private k.n.a FU()
    {
      if (this == bTK) {
        return new k.n.a((byte)0);
      }
      return new k.n.a((byte)0).b(this);
    }
    
    public static n FV()
    {
      return bTK;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = bb.f(1, this.bQT) + 0;
      }
      int j = i;
      if ((this.bQS & 0x2) != 0) {
        j = i + i.c(2, FT());
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.Br().b(n.class, k.n.a.class);
    }
    
    public final boolean Cc()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Cj()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final ci<n> Co()
    {
      return bRf;
    }
    
    public final k.o FT()
    {
      if (this.bTJ == null) {
        return k.o.FZ();
      }
      return this.bTJ;
    }
    
    public final void a(i parami)
    {
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bQT);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.a(2, FT());
      }
      this.bVW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof n)) {
          return super.equals(paramObject);
        }
        paramObject = (n)paramObject;
        if (Cc() != paramObject.Cc()) {
          return false;
        }
        if ((Cc()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (Cj() != paramObject.Cj()) {
          return false;
        }
        if ((Cj()) && (!FT().equals(paramObject.FT()))) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.bQT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bQT = str;
      }
      return str;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.Bq().hashCode() + 779;
      int i = j;
      if (Cc()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (Cj()) {
        j = (i * 37 + 2) * 53 + FT().hashCode();
      }
      i = j * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bRd;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((Cj()) && (!FT().isInitialized()))
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
  }
  
  public static final class o
    extends bb.d<o>
    implements ac
  {
    @Deprecated
    public static final ci<o> bRf = new k.o.1();
    private static final o bTL = new o();
    private List<k.s> bRA;
    private byte bRd = -1;
    
    private o()
    {
      this.bRA = Collections.emptyList();
    }
    
    private o(bb.c<o, ?> paramc)
    {
      super();
    }
    
    private o(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
          j = paramh.Av();
          switch (j)
          {
          }
        }
        catch (bf paramh)
        {
          try
          {
            int j;
            paramh.bZj = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.bRA = Collections.unmodifiableList(this.bRA);
          this.bVW = locala.Jm();
          this.bXY.Al();
          throw paramh;
          if ((i & 0x1) == 0) {
            break label240;
          }
          this.bRA = Collections.unmodifiableList(this.bRA);
          this.bVW = locala.Jm();
          this.bXY.Al();
          return;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new bf(paramh);
          k = i1;
          paramh.bZj = this;
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
        if (!a(paramh, locala, paramap, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bRA = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.bRA.add(paramh.a(k.s.bRf, paramap));
          i = j;
        }
      }
    }
    
    private int Ds()
    {
      return this.bRA.size();
    }
    
    public static o FZ()
    {
      return bTL;
    }
    
    public static a b(o paramo)
    {
      return bTL.FY().d(paramo);
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.bRA.size())
      {
        j += i.c(999, (bw)this.bRA.get(i));
        i += 1;
      }
      i = Ii() + j + this.bVW.Ad();
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BJ().b(o.class, a.class);
    }
    
    public final ci<o> Co()
    {
      return bRf;
    }
    
    public final a FY()
    {
      if (this == bTL) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      bb.d.a locala = Ih();
      int i = 0;
      while (i < this.bRA.size())
      {
        parami.a(999, (bw)this.bRA.get(i));
        i += 1;
      }
      locala.b(parami);
      this.bVW.a(parami);
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
        if (!this.bRA.equals(paramObject.bRA)) {
          return false;
        }
        if (!this.bVW.equals(paramObject.bVW)) {
          return false;
        }
      } while (Ij().equals(paramObject.Ij()));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BI().hashCode() + 779;
      int i = j;
      if (Ds() > 0) {
        i = (j * 37 + 999) * 53 + this.bRA.hashCode();
      }
      i = a(i, Ij()) * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.bRd;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < Ds())
      {
        if (!((k.s)this.bRA.get(i)).isInitialized())
        {
          this.bRd = 0;
          return false;
        }
        i += 1;
      }
      if (!Ig())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.c<k.o, a>
      implements ac
    {
      private int bQS;
      private List<k.s> bRA = Collections.emptyList();
      private co<k.s, k.s.a, ai> bRC;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Dy();
        }
      }
      
      private void Dx()
      {
        if ((this.bQS & 0x1) == 0)
        {
          this.bRA = new ArrayList(this.bRA);
          this.bQS |= 0x1;
        }
      }
      
      private co<k.s, k.s.a, ai> Dy()
      {
        List localList;
        if (this.bRC == null)
        {
          localList = this.bRA;
          if ((this.bQS & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bRC = new co(localList, bool, Ie(), Ic());
          this.bRA = null;
          return this.bRC;
        }
      }
      
      private k.o Ga()
      {
        k.o localo = Gb();
        if (!localo.isInitialized()) {
          throw b(localo);
        }
        return localo;
      }
      
      private a M(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a N(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a O(aj.f paramf, Object paramObject)
      {
        return (a)super.r(paramf, paramObject);
      }
      
      private a P(aj.f paramf, Object paramObject)
      {
        return (a)super.q(paramf, paramObject);
      }
      
      private a u(bt parambt)
      {
        if ((parambt instanceof k.o)) {
          return d((k.o)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a v(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 127	com/google/b/k$o:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 132 3 0
        //   12: checkcast 9	com/google/b/k$o
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 116	com/google/b/k$o$a:d	(Lcom/google/b/k$o;)Lcom/google/b/k$o$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 136	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$o
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 140	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 116	com/google/b/k$o$a:d	(Lcom/google/b/k$o;)Lcom/google/b/k$o$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      protected final bb.e Cb()
      {
        return k.BJ().b(k.o.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BI();
      }
      
      public final k.o Gb()
      {
        k.o localo = new k.o(this, (byte)0);
        if (this.bRC == null)
        {
          if ((this.bQS & 0x1) != 0)
          {
            this.bRA = Collections.unmodifiableList(this.bRA);
            this.bQS &= 0xFFFFFFFE;
          }
          k.o.a(localo, this.bRA);
        }
        for (;;)
        {
          Ib();
          return localo;
          k.o.a(localo, this.bRC.build());
        }
      }
      
      public final a d(k.o paramo)
      {
        co localco = null;
        if (paramo == k.o.FZ()) {
          return this;
        }
        if (this.bRC == null) {
          if (!k.o.c(paramo).isEmpty())
          {
            if (!this.bRA.isEmpty()) {
              break label85;
            }
            this.bRA = k.o.c(paramo);
            this.bQS &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramo);
          N(paramo.bVW);
          onChanged();
          return this;
          label85:
          Dx();
          this.bRA.addAll(k.o.c(paramo));
          break;
          if (!k.o.c(paramo).isEmpty()) {
            if (this.bRC.isEmpty())
            {
              this.bRC.cat = null;
              this.bRC = null;
              this.bRA = k.o.c(paramo);
              this.bQS &= 0xFFFFFFFE;
              if (bb.bXS) {
                localco = Dy();
              }
              this.bRC = localco;
            }
            else
            {
              this.bRC.a(k.o.c(paramo));
            }
          }
        }
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.bRC == null)
        {
          j = this.bRA.size();
          if (i >= j) {
            break label88;
          }
          if (this.bRC != null) {
            break label65;
          }
          locals = (k.s)this.bRA.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!Ig())
        {
          for (;;)
          {
            return false;
            j = this.bRC.getCount();
            break;
            k.s locals = (k.s)this.bRC.u(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class r
    extends bb
    implements ag
  {
    @Deprecated
    public static final ci<r> bRf = new c() {};
    private static final r bTS = new r();
    private byte bRd = -1;
    private List<b> bTR;
    
    private r()
    {
      this.bTR = Collections.emptyList();
    }
    
    private r(bb.a<?> parama)
    {
      super();
    }
    
    private r(h paramh, ap paramap)
    {
      this();
      if (paramap == null) {
        throw new NullPointerException();
      }
      da.a locala = da.Jj();
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
          j = paramh.Av();
          switch (j)
          {
          }
        }
        catch (bf paramh)
        {
          try
          {
            int j;
            paramh.bZj = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.bTR = Collections.unmodifiableList(this.bTR);
          this.bVW = locala.Jm();
          HZ();
          throw paramh;
          if ((i & 0x1) == 0) {
            break label237;
          }
          this.bTR = Collections.unmodifiableList(this.bTR);
          this.bVW = locala.Jm();
          HZ();
          return;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new bf(paramh);
          k = i1;
          paramh.bZj = this;
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
        if (!a(paramh, locala, paramap, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bTR = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.bTR.add(paramh.a(b.bRf, paramap));
          i = j;
        }
      }
    }
    
    public static r Gp()
    {
      return bTS;
    }
    
    public static a b(r paramr)
    {
      return bTS.Go().d(paramr);
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.bTR.size())
      {
        j += i.c(1, (bw)this.bTR.get(i));
        i += 1;
      }
      i = this.bVW.Ad() + j;
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BX().b(r.class, a.class);
    }
    
    public final ci<r> Co()
    {
      return bRf;
    }
    
    public final a Go()
    {
      if (this == bTS) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public final void a(i parami)
    {
      int i = 0;
      while (i < this.bTR.size())
      {
        parami.a(1, (bw)this.bTR.get(i));
        i += 1;
      }
      this.bVW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof r)) {
          return super.equals(paramObject);
        }
        paramObject = (r)paramObject;
        if (!this.bTR.equals(paramObject.bTR)) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BW().hashCode() + 779;
      int i = j;
      if (this.bTR.size() > 0) {
        i = (j * 37 + 1) * 53 + this.bTR.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bRd;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements ag
    {
      private int bQS;
      private List<k.r.b> bTR = Collections.emptyList();
      private co<k.r.b, k.r.b.a, af> bTT;
      
      private a()
      {
        Cu();
      }
      
      private a(bb.b paramb)
      {
        super();
        Cu();
      }
      
      private void Cu()
      {
        if (bb.bXS) {
          Gt();
        }
      }
      
      private k.r Gq()
      {
        k.r localr = Gr();
        if (!localr.isInitialized()) {
          throw b(localr);
        }
        return localr;
      }
      
      private void Gs()
      {
        if ((this.bQS & 0x1) == 0)
        {
          this.bTR = new ArrayList(this.bTR);
          this.bQS |= 0x1;
        }
      }
      
      private co<k.r.b, k.r.b.a, af> Gt()
      {
        List localList;
        if (this.bTT == null)
        {
          localList = this.bTR;
          if ((this.bQS & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.bTT = new co(localList, bool, Ie(), Ic());
          this.bTR = null;
          return this.bTT;
        }
      }
      
      private a S(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a T(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a U(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a V(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a x(bt parambt)
      {
        if ((parambt instanceof k.r)) {
          return d((k.r)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a y(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 126	com/google/b/k$r:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 131 3 0
        //   12: checkcast 9	com/google/b/k$r
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 115	com/google/b/k$r$a:d	(Lcom/google/b/k$r;)Lcom/google/b/k$r$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 135	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 9	com/google/b/k$r
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 139	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 115	com/google/b/k$r$a:d	(Lcom/google/b/k$r;)Lcom/google/b/k$r$a;
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
        //   0	61	2	paramap	ap
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/b/bf
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      protected final bb.e Cb()
      {
        return k.BX().b(k.r.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BW();
      }
      
      public final k.r Gr()
      {
        k.r localr = new k.r(this, (byte)0);
        if (this.bTT == null)
        {
          if ((this.bQS & 0x1) != 0)
          {
            this.bTR = Collections.unmodifiableList(this.bTR);
            this.bQS &= 0xFFFFFFFE;
          }
          k.r.a(localr, this.bTR);
        }
        for (;;)
        {
          Ib();
          return localr;
          k.r.a(localr, this.bTT.build());
        }
      }
      
      public final a d(k.r paramr)
      {
        co localco = null;
        if (paramr == k.r.Gp()) {
          return this;
        }
        if (this.bTT == null) {
          if (!k.r.c(paramr).isEmpty())
          {
            if (!this.bTR.isEmpty()) {
              break label80;
            }
            this.bTR = k.r.c(paramr);
            this.bQS &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          T(paramr.bVW);
          onChanged();
          return this;
          label80:
          Gs();
          this.bTR.addAll(k.r.c(paramr));
          break;
          if (!k.r.c(paramr).isEmpty()) {
            if (this.bTT.isEmpty())
            {
              this.bTT.cat = null;
              this.bTT = null;
              this.bTR = k.r.c(paramr);
              this.bQS &= 0xFFFFFFFE;
              if (bb.bXS) {
                localco = Gt();
              }
              this.bTT = localco;
            }
            else
            {
              this.bTT.a(k.r.c(paramr));
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
      extends bb
      implements af
    {
      @Deprecated
      public static final ci<b> bRf = new c() {};
      private static final b bUb = new b();
      private int bQS;
      private byte bRd = -1;
      private be.d bTU;
      private int bTV = -1;
      private be.d bTW;
      private int bTX = -1;
      private volatile Object bTY;
      private volatile Object bTZ;
      private bk bUa;
      
      private b()
      {
        this.bTU = bd.Il();
        this.bTW = bd.Il();
        this.bTY = "";
        this.bTZ = "";
        this.bUa = bj.bZD;
      }
      
      private b(bb.a<?> parama)
      {
        super();
      }
      
      private b(h paramh, ap paramap)
      {
        this();
        if (paramap == null) {
          throw new NullPointerException();
        }
        da.a locala = da.Jj();
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
              n = paramh.Av();
              switch (n)
              {
              case 8: 
                k = i;
                m = i;
                j = i;
                if (a(paramh, locala, paramap, n)) {
                  break label26;
                }
                i1 = 1;
                break label26;
              }
            }
            catch (bf paramh)
            {
              try
              {
                paramh.bZj = this;
                throw paramh;
              }
              finally
              {
                j = k;
                if ((j & 0x1) != 0) {
                  this.bTU.Al();
                }
                if ((j & 0x2) != 0) {
                  this.bTW.Al();
                }
                if ((j & 0x10) != 0) {
                  this.bUa = this.bUa.Ix();
                }
                this.bVW = locala.Jm();
                HZ();
              }
              k = i;
              m = i;
              j = i;
              i2 = paramh.gA(paramh.AK());
              n = i;
              if ((i & 0x1) != 0) {
                continue;
              }
              k = i;
              n = i;
              m = i;
              j = i;
              if (paramh.AM() <= 0) {
                continue;
              }
              k = i;
              m = i;
              j = i;
              this.bTU = new bd();
              n = i | 0x1;
              k = n;
              m = n;
              j = n;
              if (paramh.AM() <= 0) {
                continue;
              }
              k = n;
              m = n;
              j = n;
              this.bTU.hx(paramh.Ay());
              continue;
            }
            catch (IOException paramh)
            {
              j = m;
              paramh = new bf(paramh);
              j = m;
              paramh.bZj = this;
              j = m;
              throw paramh;
            }
            finally
            {
              continue;
              k = n;
              m = n;
              j = n;
              paramh.gB(i2);
              i = n;
            }
            int n = i;
            if ((i & 0x1) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bTU = new bd();
              n = i | 0x1;
            }
            k = n;
            m = n;
            j = n;
            this.bTU.hx(paramh.Ay());
            i = n;
            break;
            break;
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bTW = new bd();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.bTW.hx(paramh.Ay());
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            int i2 = paramh.gA(paramh.AK());
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              n = i;
              if (paramh.AM() > 0)
              {
                k = i;
                m = i;
                j = i;
                this.bTW = new bd();
                n = i | 0x2;
              }
            }
            for (;;)
            {
              k = n;
              m = n;
              j = n;
              if (paramh.AM() <= 0) {
                break;
              }
              k = n;
              m = n;
              j = n;
              this.bTW.hx(paramh.Ay());
            }
            k = n;
            m = n;
            j = n;
            paramh.gB(i2);
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            g localg = paramh.AD();
            k = i;
            m = i;
            j = i;
            this.bQS |= 0x1;
            k = i;
            m = i;
            j = i;
            this.bTY = localg;
            break;
            k = i;
            m = i;
            j = i;
            localg = paramh.AD();
            k = i;
            m = i;
            j = i;
            this.bQS |= 0x2;
            k = i;
            m = i;
            j = i;
            this.bTZ = localg;
            break;
            k = i;
            m = i;
            j = i;
            localg = paramh.AD();
            n = i;
            if ((i & 0x10) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.bUa = new bj();
              n = i | 0x10;
            }
            k = n;
            m = n;
            j = n;
            this.bUa.d(localg);
            i = n;
            break;
            if ((i & 0x1) != 0) {
              this.bTU.Al();
            }
            if ((i & 0x2) != 0) {
              this.bTW.Al();
            }
            if ((i & 0x10) != 0) {
              this.bUa = this.bUa.Ix();
            }
            this.bVW = locala.Jm();
            HZ();
            return;
          }
          i1 = 1;
        }
      }
      
      private String Gv()
      {
        Object localObject = this.bTY;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (g)localObject;
        String str = ((g)localObject).Ap();
        if (((g)localObject).Aq()) {
          this.bTY = str;
        }
        return str;
      }
      
      private String Gx()
      {
        Object localObject = this.bTZ;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (g)localObject;
        String str = ((g)localObject).Ap();
        if (((g)localObject).Aq()) {
          this.bTZ = str;
        }
        return str;
      }
      
      private a Gy()
      {
        if (this == bUb) {
          return new a((byte)0);
        }
        return new a((byte)0).f(this);
      }
      
      public static b Gz()
      {
        return bUb;
      }
      
      public final int Ad()
      {
        int i = this.bOZ;
        if (i != -1) {
          return i;
        }
        i = 0;
        int j = 0;
        while (i < this.bTU.size())
        {
          j += i.gM(this.bTU.getInt(i));
          i += 1;
        }
        int k = j + 0;
        i = k;
        if (!this.bTU.isEmpty()) {
          i = k + 1 + i.gM(j);
        }
        this.bTV = j;
        k = 0;
        j = 0;
        while (k < this.bTW.size())
        {
          j += i.gM(this.bTW.getInt(k));
          k += 1;
        }
        k = i + j;
        i = k;
        if (!this.bTW.isEmpty()) {
          i = k + 1 + i.gM(j);
        }
        this.bTX = j;
        j = i;
        if ((this.bQS & 0x1) != 0) {
          j = i + bb.f(3, this.bTY);
        }
        i = j;
        if ((this.bQS & 0x2) != 0) {
          i = j + bb.f(4, this.bTZ);
        }
        j = 0;
        k = 0;
        while (j < this.bUa.size())
        {
          k += ao(this.bUa.getRaw(j));
          j += 1;
        }
        i = i + k + this.bUa.size() * 1 + this.bVW.Ad();
        this.bOZ = i;
        return i;
      }
      
      public final da Ca()
      {
        return this.bVW;
      }
      
      protected final bb.e Cb()
      {
        return k.BZ().b(b.class, a.class);
      }
      
      public final ci<b> Co()
      {
        return bRf;
      }
      
      public final boolean Gu()
      {
        return (this.bQS & 0x1) != 0;
      }
      
      public final boolean Gw()
      {
        return (this.bQS & 0x2) != 0;
      }
      
      public final void a(i parami)
      {
        int j = 0;
        Ad();
        if (this.bTU.size() > 0)
        {
          parami.gE(10);
          parami.gE(this.bTV);
        }
        int i = 0;
        while (i < this.bTU.size())
        {
          parami.gD(this.bTU.getInt(i));
          i += 1;
        }
        if (this.bTW.size() > 0)
        {
          parami.gE(18);
          parami.gE(this.bTX);
        }
        i = 0;
        while (i < this.bTW.size())
        {
          parami.gD(this.bTW.getInt(i));
          i += 1;
        }
        if ((this.bQS & 0x1) != 0) {
          bb.a(parami, 3, this.bTY);
        }
        i = j;
        if ((this.bQS & 0x2) != 0)
        {
          bb.a(parami, 4, this.bTZ);
          i = j;
        }
        while (i < this.bUa.size())
        {
          bb.a(parami, 6, this.bUa.getRaw(i));
          i += 1;
        }
        this.bVW.a(parami);
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
          if (!this.bTU.equals(paramObject.bTU)) {
            return false;
          }
          if (!this.bTW.equals(paramObject.bTW)) {
            return false;
          }
          if (Gu() != paramObject.Gu()) {
            return false;
          }
          if ((Gu()) && (!Gv().equals(paramObject.Gv()))) {
            return false;
          }
          if (Gw() != paramObject.Gw()) {
            return false;
          }
          if ((Gw()) && (!Gx().equals(paramObject.Gx()))) {
            return false;
          }
          if (!this.bUa.equals(paramObject.bUa)) {
            return false;
          }
        } while (this.bVW.equals(paramObject.bVW));
        return false;
      }
      
      public final int hashCode()
      {
        if (this.bPa != 0) {
          return this.bPa;
        }
        int j = k.BY().hashCode() + 779;
        int i = j;
        if (this.bTU.size() > 0) {
          i = (j * 37 + 1) * 53 + this.bTU.hashCode();
        }
        j = i;
        if (this.bTW.size() > 0) {
          j = (i * 37 + 2) * 53 + this.bTW.hashCode();
        }
        i = j;
        if (Gu()) {
          i = (j * 37 + 3) * 53 + Gv().hashCode();
        }
        j = i;
        if (Gw()) {
          j = (i * 37 + 4) * 53 + Gx().hashCode();
        }
        i = j;
        if (this.bUa.size() > 0) {
          i = (j * 37 + 6) * 53 + this.bUa.hashCode();
        }
        i = i * 29 + this.bVW.hashCode();
        this.bPa = i;
        return i;
      }
      
      public final boolean isInitialized()
      {
        int i = this.bRd;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.bRd = 1;
        return true;
      }
      
      public static final class a
        extends bb.a<a>
        implements af
      {
        private int bQS;
        private be.d bTU = bb.HY();
        private be.d bTW = bb.HY();
        private Object bTY = "";
        private Object bTZ = "";
        private bk bUa = bj.bZD;
        
        private a()
        {
          boolean bool = bb.bXS;
        }
        
        private a(bb.b paramb)
        {
          super();
          boolean bool = bb.bXS;
        }
        
        private k.r.b GA()
        {
          k.r.b localb = GB();
          if (!localb.isInitialized()) {
            throw b(localb);
          }
          return localb;
        }
        
        private k.r.b GB()
        {
          int i = 0;
          k.r.b localb = new k.r.b(this, (byte)0);
          int k = this.bQS;
          if ((this.bQS & 0x1) != 0)
          {
            this.bTU.Al();
            this.bQS &= 0xFFFFFFFE;
          }
          k.r.b.a(localb, this.bTU);
          if ((this.bQS & 0x2) != 0)
          {
            this.bTW.Al();
            this.bQS &= 0xFFFFFFFD;
          }
          k.r.b.b(localb, this.bTW);
          if ((k & 0x4) != 0) {
            i = 1;
          }
          k.r.b.a(localb, this.bTY);
          int j = i;
          if ((k & 0x8) != 0) {
            j = i | 0x2;
          }
          k.r.b.b(localb, this.bTZ);
          if ((this.bQS & 0x10) != 0)
          {
            this.bUa = this.bUa.Ix();
            this.bQS &= 0xFFFFFFEF;
          }
          k.r.b.a(localb, this.bUa);
          k.r.b.a(localb, j);
          Ib();
          return localb;
        }
        
        private void GC()
        {
          if ((this.bQS & 0x1) == 0)
          {
            this.bTU = bb.a(this.bTU);
            this.bQS |= 0x1;
          }
        }
        
        private void GD()
        {
          if ((this.bQS & 0x2) == 0)
          {
            this.bTW = bb.a(this.bTW);
            this.bQS |= 0x2;
          }
        }
        
        private void GE()
        {
          if ((this.bQS & 0x10) == 0)
          {
            this.bUa = new bj(this.bUa);
            this.bQS |= 0x10;
          }
        }
        
        private a U(da paramda)
        {
          return (a)super.e(paramda);
        }
        
        private a V(da paramda)
        {
          return (a)super.d(paramda);
        }
        
        private a W(aj.f paramf, Object paramObject)
        {
          return (a)super.d(paramf, paramObject);
        }
        
        private a X(aj.f paramf, Object paramObject)
        {
          return (a)super.c(paramf, paramObject);
        }
        
        private a y(bt parambt)
        {
          if ((parambt instanceof k.r.b)) {
            return f((k.r.b)parambt);
          }
          super.a(parambt);
          return this;
        }
        
        /* Error */
        private a z(h paramh, ap paramap)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 157	com/google/b/k$r$b:bRf	Lcom/google/b/ci;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 162 3 0
          //   12: checkcast 14	com/google/b/k$r$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 146	com/google/b/k$r$b$a:f	(Lcom/google/b/k$r$b;)Lcom/google/b/k$r$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 166	com/google/b/bf:bZj	Lcom/google/b/bw;
          //   33: checkcast 14	com/google/b/k$r$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 170	com/google/b/bf:Im	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 146	com/google/b/k$r$b$a:f	(Lcom/google/b/k$r$b;)Lcom/google/b/k$r$b$a;
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
          //   0	61	2	paramap	ap
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/b/bf
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        protected final bb.e Cb()
        {
          return k.BZ().b(k.r.b.class, a.class);
        }
        
        public final aj.a Cv()
        {
          return k.BY();
        }
        
        public final a f(k.r.b paramb)
        {
          if (paramb == k.r.b.Gz()) {
            return this;
          }
          if (!k.r.b.a(paramb).isEmpty())
          {
            if (this.bTU.isEmpty())
            {
              this.bTU = k.r.b.a(paramb);
              this.bQS &= 0xFFFFFFFE;
              onChanged();
            }
          }
          else
          {
            if (!k.r.b.b(paramb).isEmpty())
            {
              if (!this.bTW.isEmpty()) {
                break label245;
              }
              this.bTW = k.r.b.b(paramb);
              this.bQS &= 0xFFFFFFFD;
              label99:
              onChanged();
            }
            if (paramb.Gu())
            {
              this.bQS |= 0x4;
              this.bTY = k.r.b.c(paramb);
              onChanged();
            }
            if (paramb.Gw())
            {
              this.bQS |= 0x8;
              this.bTZ = k.r.b.d(paramb);
              onChanged();
            }
            if (!k.r.b.e(paramb).isEmpty())
            {
              if (!this.bUa.isEmpty()) {
                break label266;
              }
              this.bUa = k.r.b.e(paramb);
              this.bQS &= 0xFFFFFFEF;
            }
          }
          for (;;)
          {
            onChanged();
            V(paramb.bVW);
            onChanged();
            return this;
            GC();
            this.bTU.addAll(k.r.b.a(paramb));
            break;
            label245:
            GD();
            this.bTW.addAll(k.r.b.b(paramb));
            break label99;
            label266:
            GE();
            this.bUa.addAll(k.r.b.e(paramb));
          }
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.k
 * JD-Core Version:    0.7.0.1
 */