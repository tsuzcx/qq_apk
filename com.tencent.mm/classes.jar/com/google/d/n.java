package com.google.d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class n
{
  private static final am.a dJH;
  private static final bg.e dJI;
  private static final am.a dJJ;
  private static final bg.e dJK;
  private static final am.a dJL;
  private static final bg.e dJM;
  private static final am.a dJN;
  private static final bg.e dJO;
  private static final am.a dJP;
  private static final bg.e dJQ;
  private static final am.a dJR;
  private static final bg.e dJS;
  private static final am.a dJT;
  private static final bg.e dJU;
  private static final am.a dJV;
  private static final bg.e dJW;
  private static final am.a dJX;
  private static final bg.e dJY;
  private static final am.a dJZ;
  private static final bg.e dKA = new bg.e(dKz, new String[] { "NamePart", "IsExtension" });
  private static final am.a dKB = (am.a)descriptor.ahs().get(19);
  private static final bg.e dKC = new bg.e(dKB, new String[] { "Location" });
  private static final am.a dKD = (am.a)dKB.ahb().get(0);
  private static final bg.e dKE = new bg.e(dKD, new String[] { "Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments" });
  private static final am.a dKF = (am.a)descriptor.ahs().get(20);
  private static final bg.e dKG = new bg.e(dKF, new String[] { "Annotation" });
  private static final am.a dKH = (am.a)dKF.ahb().get(0);
  private static final bg.e dKI = new bg.e(dKH, new String[] { "Path", "SourceFile", "Begin", "End" });
  private static final bg.e dKa;
  private static final am.a dKb;
  private static final bg.e dKc;
  private static final am.a dKd;
  private static final bg.e dKe;
  private static final am.a dKf;
  private static final bg.e dKg;
  private static final am.a dKh;
  private static final bg.e dKi;
  private static final am.a dKj;
  private static final bg.e dKk;
  private static final am.a dKl;
  private static final bg.e dKm;
  private static final am.a dKn;
  private static final bg.e dKo;
  private static final am.a dKp;
  private static final bg.e dKq;
  private static final am.a dKr;
  private static final bg.e dKs;
  private static final am.a dKt;
  private static final bg.e dKu;
  private static final am.a dKv;
  private static final bg.e dKw;
  private static final am.a dKx;
  private static final bg.e dKy;
  private static final am.a dKz;
  private static am.g descriptor;
  
  static
  {
    am.g localg = am.g.a(new String[] { "" }, new am.g[0]);
    descriptor = localg;
    dJH = (am.a)localg.ahs().get(0);
    dJI = new bg.e(dJH, new String[] { "File" });
    dJJ = (am.a)descriptor.ahs().get(1);
    dJK = new bg.e(dJJ, new String[] { "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax" });
    dJL = (am.a)descriptor.ahs().get(2);
    dJM = new bg.e(dJL, new String[] { "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName" });
    dJN = (am.a)dJL.ahb().get(0);
    dJO = new bg.e(dJN, new String[] { "Start", "End", "Options" });
    dJP = (am.a)dJL.ahb().get(1);
    dJQ = new bg.e(dJP, new String[] { "Start", "End" });
    dJR = (am.a)descriptor.ahs().get(3);
    dJS = new bg.e(dJR, new String[] { "UninterpretedOption" });
    dJT = (am.a)descriptor.ahs().get(4);
    dJU = new bg.e(dJT, new String[] { "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options" });
    dJV = (am.a)descriptor.ahs().get(5);
    dJW = new bg.e(dJV, new String[] { "Name", "Options" });
    dJX = (am.a)descriptor.ahs().get(6);
    dJY = new bg.e(dJX, new String[] { "Name", "Value", "Options", "ReservedRange", "ReservedName" });
    dJZ = (am.a)dJX.ahb().get(0);
    dKa = new bg.e(dJZ, new String[] { "Start", "End" });
    dKb = (am.a)descriptor.ahs().get(7);
    dKc = new bg.e(dKb, new String[] { "Name", "Number", "Options" });
    dKd = (am.a)descriptor.ahs().get(8);
    dKe = new bg.e(dKd, new String[] { "Name", "Method", "Options" });
    dKf = (am.a)descriptor.ahs().get(9);
    dKg = new bg.e(dKf, new String[] { "Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming" });
    dKh = (am.a)descriptor.ahs().get(10);
    dKi = new bg.e(dKh, new String[] { "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption" });
    dKj = (am.a)descriptor.ahs().get(11);
    dKk = new bg.e(dKj, new String[] { "MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption" });
    dKl = (am.a)descriptor.ahs().get(12);
    dKm = new bg.e(dKl, new String[] { "Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption" });
    dKn = (am.a)descriptor.ahs().get(13);
    dKo = new bg.e(dKn, new String[] { "UninterpretedOption" });
    dKp = (am.a)descriptor.ahs().get(14);
    dKq = new bg.e(dKp, new String[] { "AllowAlias", "Deprecated", "UninterpretedOption" });
    dKr = (am.a)descriptor.ahs().get(15);
    dKs = new bg.e(dKr, new String[] { "Deprecated", "UninterpretedOption" });
    dKt = (am.a)descriptor.ahs().get(16);
    dKu = new bg.e(dKt, new String[] { "Deprecated", "UninterpretedOption" });
    dKv = (am.a)descriptor.ahs().get(17);
    dKw = new bg.e(dKv, new String[] { "Deprecated", "IdempotencyLevel", "UninterpretedOption" });
    dKx = (am.a)descriptor.ahs().get(18);
    dKy = new bg.e(dKx, new String[] { "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue" });
    dKz = (am.a)dKx.ahb().get(0);
  }
  
  public static final class a
    extends bg
    implements q
  {
    @Deprecated
    public static final cs<a> PARSER = new c() {};
    private static final a dKS = new a();
    private int bitField0_;
    private List<n.g> dKJ;
    private List<n.g> dKK;
    private List<a> dKL;
    private List<n.b> dKM;
    List<b> dKN;
    private List<n.n> dKO;
    private n.k dKP;
    private List<c> dKQ;
    private bp dKR;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private a()
    {
      this.name_ = "";
      this.dKJ = Collections.emptyList();
      this.dKK = Collections.emptyList();
      this.dKL = Collections.emptyList();
      this.dKM = Collections.emptyList();
      this.dKN = Collections.emptyList();
      this.dKO = Collections.emptyList();
      this.dKQ = Collections.emptyList();
      this.dKR = bo.dTm;
    }
    
    private a(bg.a<?> parama)
    {
      super();
    }
    
    private a(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            n = parami.aac();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (parseUnknownField(parami, locala, paramat, n)) {
                break label1311;
              }
              j = 1;
              break label1327;
              k = i;
              m = i;
              j = i;
              localObject = parami.aak();
              k = i;
              m = i;
              j = i;
              this.bitField0_ |= 0x1;
              k = i;
              m = i;
              j = i;
              this.name_ = localObject;
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              j = k;
              if ((j & 0x2) != 0) {
                this.dKJ = Collections.unmodifiableList(this.dKJ);
              }
              if ((j & 0x8) != 0) {
                this.dKL = Collections.unmodifiableList(this.dKL);
              }
              if ((j & 0x10) != 0) {
                this.dKM = Collections.unmodifiableList(this.dKM);
              }
              if ((j & 0x20) != 0) {
                this.dKN = Collections.unmodifiableList(this.dKN);
              }
              if ((j & 0x4) != 0) {
                this.dKK = Collections.unmodifiableList(this.dKK);
              }
              if ((j & 0x40) != 0) {
                this.dKO = Collections.unmodifiableList(this.dKO);
              }
              if ((j & 0x100) != 0) {
                this.dKQ = Collections.unmodifiableList(this.dKQ);
              }
              if ((j & 0x200) != 0) {
                this.dKR = this.dKR.aiv();
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dKJ = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.dKJ.add(parami.a(n.g.PARSER, paramat));
            i = n;
            break;
          }
          catch (IOException parami)
          {
            j = m;
            parami = new bk(parami);
            j = m;
            parami.dST = this;
            j = m;
            throw parami;
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
              this.dKL = new ArrayList();
              n = i | 0x8;
            }
            k = n;
            m = n;
            j = n;
            this.dKL.add(parami.a(PARSER, paramat));
            i = n;
          }
          break;
          int n = i;
          if ((i & 0x10) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dKM = new ArrayList();
            n = i | 0x10;
          }
          k = n;
          m = n;
          j = n;
          this.dKM.add(parami.a(n.b.PARSER, paramat));
          i = n;
          break;
          n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dKN = new ArrayList();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.dKN.add(parami.a(b.PARSER, paramat));
          i = n;
          break;
          n = i;
          if ((i & 0x4) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dKK = new ArrayList();
            n = i | 0x4;
          }
          k = n;
          m = n;
          j = n;
          this.dKK.add(parami.a(n.g.PARSER, paramat));
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          if ((this.bitField0_ & 0x2) != 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (Object localObject = this.dKP.afj();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.dKP = ((n.k)parami.a(n.k.PARSER, paramat));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((n.k.a)localObject).d(this.dKP);
              k = i;
              m = i;
              j = i;
              this.dKP = ((n.k.a)localObject).afn();
            }
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x2;
            break;
            n = i;
            if ((i & 0x40) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dKO = new ArrayList();
              n = i | 0x40;
            }
            k = n;
            m = n;
            j = n;
            this.dKO.add(parami.a(n.n.PARSER, paramat));
            i = n;
            break;
            n = i;
            if ((i & 0x100) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dKQ = new ArrayList();
              n = i | 0x100;
            }
            k = n;
            m = n;
            j = n;
            this.dKQ.add(parami.a(c.PARSER, paramat));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            localObject = parami.aak();
            n = i;
            if ((i & 0x200) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dKR = new bo();
              n = i | 0x200;
            }
            k = n;
            m = n;
            j = n;
            this.dKR.d((h)localObject);
            i = n;
            break;
            if ((i & 0x2) != 0) {
              this.dKJ = Collections.unmodifiableList(this.dKJ);
            }
            if ((i & 0x8) != 0) {
              this.dKL = Collections.unmodifiableList(this.dKL);
            }
            if ((i & 0x10) != 0) {
              this.dKM = Collections.unmodifiableList(this.dKM);
            }
            if ((i & 0x20) != 0) {
              this.dKN = Collections.unmodifiableList(this.dKN);
            }
            if ((i & 0x4) != 0) {
              this.dKK = Collections.unmodifiableList(this.dKK);
            }
            if ((i & 0x40) != 0) {
              this.dKO = Collections.unmodifiableList(this.dKO);
            }
            if ((i & 0x100) != 0) {
              this.dKQ = Collections.unmodifiableList(this.dKQ);
            }
            if ((i & 0x200) != 0) {
              this.dKR = this.dKR.aiv();
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
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
    
    private int abR()
    {
      return this.dKN.size();
    }
    
    public static a abV()
    {
      return dKS.abW();
    }
    
    private a abW()
    {
      if (this == dKS) {
        return new a((byte)0);
      }
      return new a((byte)0).j(this);
    }
    
    public static a abX()
    {
      return dKS;
    }
    
    public final int abN()
    {
      return this.dKJ.size();
    }
    
    public final int abO()
    {
      return this.dKK.size();
    }
    
    public final int abP()
    {
      return this.dKL.size();
    }
    
    public final int abQ()
    {
      return this.dKM.size();
    }
    
    public final int abS()
    {
      return this.dKO.size();
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final n.k abU()
    {
      if (this.dKP == null) {
        return n.k.afk();
      }
      return this.dKP;
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
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.dKJ.equals(paramObject.dKJ)) {
          return false;
        }
        if (!this.dKK.equals(paramObject.dKK)) {
          return false;
        }
        if (!this.dKL.equals(paramObject.dKL)) {
          return false;
        }
        if (!this.dKM.equals(paramObject.dKM)) {
          return false;
        }
        if (!this.dKN.equals(paramObject.dKN)) {
          return false;
        }
        if (!this.dKO.equals(paramObject.dKO)) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!abU().equals(paramObject.abU()))) {
          return false;
        }
        if (!this.dKQ.equals(paramObject.dKQ)) {
          return false;
        }
        if (!this.dKR.equals(paramObject.dKR)) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<a> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (i = bg.computeStringSize(1, this.name_) + 0;; i = 0)
      {
        int j = 0;
        while (j < this.dKJ.size())
        {
          i += k.c(2, (ce)this.dKJ.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKL.size())
        {
          i += k.c(3, (ce)this.dKL.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKM.size())
        {
          i += k.c(4, (ce)this.dKM.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKN.size())
        {
          i += k.c(5, (ce)this.dKN.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKK.size())
        {
          i += k.c(6, (ce)this.dKK.get(j));
          j += 1;
        }
        j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.c(7, abU());
        }
        int k = 0;
        i = j;
        j = k;
        while (j < this.dKO.size())
        {
          i += k.c(8, (ce)this.dKO.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKQ.size())
        {
          i += k.c(9, (ce)this.dKQ.get(j));
          j += 1;
        }
        j = 0;
        k = 0;
        while (j < this.dKR.size())
        {
          k += computeStringSizeNoTag(this.dKR.getRaw(j));
          j += 1;
        }
        i = i + k + this.dKR.size() * 1 + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.aaT().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (abN() > 0) {
        j = (i * 37 + 2) * 53 + this.dKJ.hashCode();
      }
      i = j;
      if (abO() > 0) {
        i = (j * 37 + 6) * 53 + this.dKK.hashCode();
      }
      j = i;
      if (abP() > 0) {
        j = (i * 37 + 3) * 53 + this.dKL.hashCode();
      }
      i = j;
      if (abQ() > 0) {
        i = (j * 37 + 4) * 53 + this.dKM.hashCode();
      }
      j = i;
      if (abR() > 0) {
        j = (i * 37 + 5) * 53 + this.dKN.hashCode();
      }
      i = j;
      if (abS() > 0) {
        i = (j * 37 + 8) * 53 + this.dKO.hashCode();
      }
      j = i;
      if (abT()) {
        j = (i * 37 + 7) * 53 + abU().hashCode();
      }
      i = j;
      if (this.dKQ.size() > 0) {
        i = (j * 37 + 9) * 53 + this.dKQ.hashCode();
      }
      j = i;
      if (this.dKR.size() > 0) {
        j = (i * 37 + 10) * 53 + this.dKR.hashCode();
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.aaU().b(a.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < abN())
      {
        if (!kC(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abO())
      {
        if (!kD(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abP())
      {
        if (!kE(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abQ())
      {
        if (!kF(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abR())
      {
        if (!((b)this.dKN.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abS())
      {
        if (!kG(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if ((abT()) && (!abU().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final n.g kC(int paramInt)
    {
      return (n.g)this.dKJ.get(paramInt);
    }
    
    public final n.g kD(int paramInt)
    {
      return (n.g)this.dKK.get(paramInt);
    }
    
    public final a kE(int paramInt)
    {
      return (a)this.dKL.get(paramInt);
    }
    
    public final n.b kF(int paramInt)
    {
      return (n.b)this.dKM.get(paramInt);
    }
    
    public final n.n kG(int paramInt)
    {
      return (n.n)this.dKO.get(paramInt);
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new a();
    }
    
    public final void writeTo(k paramk)
    {
      int k = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      int i = 0;
      while (i < this.dKJ.size())
      {
        paramk.a(2, (ce)this.dKJ.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dKL.size())
      {
        paramk.a(3, (ce)this.dKL.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dKM.size())
      {
        paramk.a(4, (ce)this.dKM.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dKN.size())
      {
        paramk.a(5, (ce)this.dKN.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dKK.size())
      {
        paramk.a(6, (ce)this.dKK.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.a(7, abU());
      }
      i = 0;
      while (i < this.dKO.size())
      {
        paramk.a(8, (ce)this.dKO.get(i));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.dKQ.size()) {
          break;
        }
        paramk.a(9, (ce)this.dKQ.get(i));
        i += 1;
      }
      while (j < this.dKR.size())
      {
        bg.writeString(paramk, 10, this.dKR.getRaw(j));
        j += 1;
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements q
    {
      private int bitField0_;
      private List<n.g> dKJ = Collections.emptyList();
      private List<n.g> dKK = Collections.emptyList();
      private List<n.a> dKL = Collections.emptyList();
      private List<n.b> dKM = Collections.emptyList();
      private List<n.a.b> dKN = Collections.emptyList();
      private List<n.n> dKO = Collections.emptyList();
      private n.k dKP;
      private List<n.a.c> dKQ = Collections.emptyList();
      private bp dKR = bo.dTm;
      private da<n.g, n.g.a, x> dKT;
      private da<n.g, n.g.a, x> dKU;
      private da<n.a, a, q> dKV;
      private da<n.b, n.b.a, s> dKW;
      private da<n.a.b, n.a.b.a, o> dKX;
      private da<n.n, n.n.a, ae> dKY;
      private df<n.k, n.k.a, ab> dKZ;
      private da<n.a.c, n.a.c.a, p> dLa;
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a a(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a a(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a a(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a a(cb paramcb)
      {
        if ((paramcb instanceof n.a)) {
          return j((n.a)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      private a a(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      /* Error */
      private a a(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 133	com/google/d/n$a:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 139 3 0
        //   12: checkcast 9	com/google/d/n$a
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 117	com/google/d/n$a$a:j	(Lcom/google/d/n$a;)Lcom/google/d/n$a$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 143	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$a
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 147	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 117	com/google/d/n$a$a:j	(Lcom/google/d/n$a;)Lcom/google/d/n$a$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a a(n.k paramk)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x80) != 0) && (this.dKP != null) && (this.dKP != n.k.afk()))
          {
            this.dKP = n.k.b(this.dKP).d(paramk).afn();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x80;
          return this;
          this.dKP = paramk;
          break;
          this.dKZ.c(paramk);
        }
      }
      
      private n.k abU()
      {
        if (this.dKZ == null)
        {
          if (this.dKP == null) {
            return n.k.afk();
          }
          return this.dKP;
        }
        return (n.k)this.dKZ.ajm();
      }
      
      private a abY()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.dKT == null)
        {
          this.dKJ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFD;
          if (this.dKU != null) {
            break label253;
          }
          this.dKK = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          label72:
          if (this.dKV != null) {
            break label263;
          }
          this.dKL = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFF7;
          label97:
          if (this.dKW != null) {
            break label273;
          }
          this.dKM = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFEF;
          label122:
          if (this.dKX != null) {
            break label283;
          }
          this.dKN = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFDF;
          label147:
          if (this.dKY != null) {
            break label293;
          }
          this.dKO = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFBF;
          label172:
          if (this.dKZ != null) {
            break label303;
          }
          this.dKP = null;
          label184:
          this.bitField0_ &= 0xFFFFFF7F;
          if (this.dLa != null) {
            break label314;
          }
          this.dKQ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFEFF;
        }
        for (;;)
        {
          this.dKR = bo.dTm;
          this.bitField0_ &= 0xFFFFFDFF;
          return this;
          this.dKT.clear();
          break;
          label253:
          this.dKU.clear();
          break label72;
          label263:
          this.dKV.clear();
          break label97;
          label273:
          this.dKW.clear();
          break label122;
          label283:
          this.dKX.clear();
          break label147;
          label293:
          this.dKY.clear();
          break label172;
          label303:
          this.dKZ.ajp();
          break label184;
          label314:
          this.dLa.clear();
        }
      }
      
      private n.a aca()
      {
        n.a locala = new n.a(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          n.a.a(locala, this.name_);
          label130:
          label179:
          label228:
          int j;
          if (this.dKT == null)
          {
            if ((this.bitField0_ & 0x2) != 0)
            {
              this.dKJ = Collections.unmodifiableList(this.dKJ);
              this.bitField0_ &= 0xFFFFFFFD;
            }
            n.a.a(locala, this.dKJ);
            if (this.dKU != null) {
              break label484;
            }
            if ((this.bitField0_ & 0x4) != 0)
            {
              this.dKK = Collections.unmodifiableList(this.dKK);
              this.bitField0_ &= 0xFFFFFFFB;
            }
            n.a.b(locala, this.dKK);
            if (this.dKV != null) {
              break label500;
            }
            if ((this.bitField0_ & 0x8) != 0)
            {
              this.dKL = Collections.unmodifiableList(this.dKL);
              this.bitField0_ &= 0xFFFFFFF7;
            }
            n.a.c(locala, this.dKL);
            if (this.dKW != null) {
              break label516;
            }
            if ((this.bitField0_ & 0x10) != 0)
            {
              this.dKM = Collections.unmodifiableList(this.dKM);
              this.bitField0_ &= 0xFFFFFFEF;
            }
            n.a.d(locala, this.dKM);
            if (this.dKX != null) {
              break label532;
            }
            if ((this.bitField0_ & 0x20) != 0)
            {
              this.dKN = Collections.unmodifiableList(this.dKN);
              this.bitField0_ &= 0xFFFFFFDF;
            }
            n.a.e(locala, this.dKN);
            label277:
            if (this.dKY != null) {
              break label548;
            }
            if ((this.bitField0_ & 0x40) != 0)
            {
              this.dKO = Collections.unmodifiableList(this.dKO);
              this.bitField0_ &= 0xFFFFFFBF;
            }
            n.a.f(locala, this.dKO);
            label326:
            j = i;
            if ((k & 0x80) != 0)
            {
              if (this.dKZ != null) {
                break label564;
              }
              n.a.a(locala, this.dKP);
              label353:
              j = i | 0x2;
            }
            if (this.dLa != null) {
              break label583;
            }
            if ((this.bitField0_ & 0x100) != 0)
            {
              this.dKQ = Collections.unmodifiableList(this.dKQ);
              this.bitField0_ &= 0xFFFFFEFF;
            }
            n.a.g(locala, this.dKQ);
          }
          for (;;)
          {
            if ((this.bitField0_ & 0x200) != 0)
            {
              this.dKR = this.dKR.aiv();
              this.bitField0_ &= 0xFFFFFDFF;
            }
            n.a.a(locala, this.dKR);
            n.a.a(locala, j);
            onBuilt();
            return locala;
            n.a.a(locala, this.dKT.build());
            break;
            label484:
            n.a.b(locala, this.dKU.build());
            break label130;
            label500:
            n.a.c(locala, this.dKV.build());
            break label179;
            label516:
            n.a.d(locala, this.dKW.build());
            break label228;
            label532:
            n.a.e(locala, this.dKX.build());
            break label277;
            label548:
            n.a.f(locala, this.dKY.build());
            break label326;
            label564:
            n.a.a(locala, (n.k)this.dKZ.ajn());
            break label353;
            label583:
            n.a.g(locala, this.dLa.build());
          }
        }
      }
      
      private void acb()
      {
        if ((this.bitField0_ & 0x2) == 0)
        {
          this.dKJ = new ArrayList(this.dKJ);
          this.bitField0_ |= 0x2;
        }
      }
      
      private da<n.g, n.g.a, x> acc()
      {
        List localList;
        if (this.dKT == null)
        {
          localList = this.dKJ;
          if ((this.bitField0_ & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dKT = new da(localList, bool, getParentForChildren(), isClean());
          this.dKJ = null;
          return this.dKT;
        }
      }
      
      private void acd()
      {
        if ((this.bitField0_ & 0x4) == 0)
        {
          this.dKK = new ArrayList(this.dKK);
          this.bitField0_ |= 0x4;
        }
      }
      
      private da<n.g, n.g.a, x> ace()
      {
        List localList;
        if (this.dKU == null)
        {
          localList = this.dKK;
          if ((this.bitField0_ & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dKU = new da(localList, bool, getParentForChildren(), isClean());
          this.dKK = null;
          return this.dKU;
        }
      }
      
      private void acf()
      {
        if ((this.bitField0_ & 0x8) == 0)
        {
          this.dKL = new ArrayList(this.dKL);
          this.bitField0_ |= 0x8;
        }
      }
      
      private da<n.a, a, q> acg()
      {
        List localList;
        if (this.dKV == null)
        {
          localList = this.dKL;
          if ((this.bitField0_ & 0x8) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dKV = new da(localList, bool, getParentForChildren(), isClean());
          this.dKL = null;
          return this.dKV;
        }
      }
      
      private void ach()
      {
        if ((this.bitField0_ & 0x10) == 0)
        {
          this.dKM = new ArrayList(this.dKM);
          this.bitField0_ |= 0x10;
        }
      }
      
      private da<n.b, n.b.a, s> aci()
      {
        List localList;
        if (this.dKW == null)
        {
          localList = this.dKM;
          if ((this.bitField0_ & 0x10) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dKW = new da(localList, bool, getParentForChildren(), isClean());
          this.dKM = null;
          return this.dKW;
        }
      }
      
      private void acj()
      {
        if ((this.bitField0_ & 0x20) == 0)
        {
          this.dKN = new ArrayList(this.dKN);
          this.bitField0_ |= 0x20;
        }
      }
      
      private da<n.a.b, n.a.b.a, o> ack()
      {
        List localList;
        if (this.dKX == null)
        {
          localList = this.dKN;
          if ((this.bitField0_ & 0x20) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dKX = new da(localList, bool, getParentForChildren(), isClean());
          this.dKN = null;
          return this.dKX;
        }
      }
      
      private void acl()
      {
        if ((this.bitField0_ & 0x40) == 0)
        {
          this.dKO = new ArrayList(this.dKO);
          this.bitField0_ |= 0x40;
        }
      }
      
      private da<n.n, n.n.a, ae> acm()
      {
        List localList;
        if (this.dKY == null)
        {
          localList = this.dKO;
          if ((this.bitField0_ & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dKY = new da(localList, bool, getParentForChildren(), isClean());
          this.dKO = null;
          return this.dKY;
        }
      }
      
      private df<n.k, n.k.a, ab> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(abU(), getParentForChildren(), isClean());
          this.dKP = null;
        }
        return this.dKZ;
      }
      
      private void aco()
      {
        if ((this.bitField0_ & 0x100) == 0)
        {
          this.dKQ = new ArrayList(this.dKQ);
          this.bitField0_ |= 0x100;
        }
      }
      
      private da<n.a.c, n.a.c.a, p> acp()
      {
        List localList;
        if (this.dLa == null)
        {
          localList = this.dKQ;
          if ((this.bitField0_ & 0x100) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.dLa = new da(localList, bool, getParentForChildren(), isClean());
          this.dKQ = null;
          return this.dLa;
        }
      }
      
      private void acq()
      {
        if ((this.bitField0_ & 0x200) == 0)
        {
          this.dKR = new bo(this.dKR);
          this.bitField0_ |= 0x200;
        }
      }
      
      private a b(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a b(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a d(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders)
        {
          acc();
          ace();
          acg();
          aci();
          ack();
          acm();
          acn();
          acp();
        }
      }
      
      public final a a(n.a.b paramb)
      {
        if (this.dKX == null)
        {
          if (paramb == null) {
            throw new NullPointerException();
          }
          acj();
          this.dKN.add(paramb);
          onChanged();
          return this;
        }
        this.dKX.a(paramb);
        return this;
      }
      
      public final n.a abZ()
      {
        n.a locala = aca();
        if (!locala.isInitialized()) {
          throw newUninitializedMessageException(locala);
        }
        return locala;
      }
      
      public final a dX(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramString;
        onChanged();
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        return n.aaT();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.aaU().b(n.a.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        Object localObject;
        if (this.dKT == null)
        {
          j = this.dKJ.size();
          if (i >= j) {
            break label88;
          }
          if (this.dKT != null) {
            break label65;
          }
          localObject = (n.g)this.dKJ.get(i);
          label45:
          if (((n.g)localObject).isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.dKT.getCount();
          break label19;
          label65:
          localObject = (n.g)this.dKT.J(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          i = 0;
          if (this.dKU == null)
          {
            j = this.dKK.size();
            label107:
            if (i >= j) {
              break label174;
            }
            if (this.dKU != null) {
              break label158;
            }
          }
          label158:
          for (localObject = (n.g)this.dKK.get(i);; localObject = (n.g)this.dKU.J(i, false))
          {
            if (!((n.g)localObject).isInitialized()) {
              break label172;
            }
            i += 1;
            break;
            j = this.dKU.getCount();
            break label107;
          }
          label172:
          continue;
          label174:
          i = 0;
          if (this.dKV == null)
          {
            j = this.dKL.size();
            label193:
            if (i >= j) {
              break label260;
            }
            if (this.dKV != null) {
              break label244;
            }
          }
          label244:
          for (localObject = (n.a)this.dKL.get(i);; localObject = (n.a)this.dKV.J(i, false))
          {
            if (!((n.a)localObject).isInitialized()) {
              break label258;
            }
            i += 1;
            break;
            j = this.dKV.getCount();
            break label193;
          }
          label258:
          continue;
          label260:
          i = 0;
          if (this.dKW == null)
          {
            j = this.dKM.size();
            label279:
            if (i >= j) {
              break label346;
            }
            if (this.dKW != null) {
              break label330;
            }
          }
          label330:
          for (localObject = (n.b)this.dKM.get(i);; localObject = (n.b)this.dKW.J(i, false))
          {
            if (!((n.b)localObject).isInitialized()) {
              break label344;
            }
            i += 1;
            break;
            j = this.dKW.getCount();
            break label279;
          }
          label344:
          continue;
          label346:
          i = 0;
          if (this.dKX == null)
          {
            j = this.dKN.size();
            label365:
            if (i >= j) {
              break label432;
            }
            if (this.dKX != null) {
              break label416;
            }
          }
          label416:
          for (localObject = (n.a.b)this.dKN.get(i);; localObject = (n.a.b)this.dKX.J(i, false))
          {
            if (!((n.a.b)localObject).isInitialized()) {
              break label430;
            }
            i += 1;
            break;
            j = this.dKX.getCount();
            break label365;
          }
          label430:
          continue;
          label432:
          i = 0;
          if (this.dKY == null)
          {
            j = this.dKO.size();
            label451:
            if (i >= j) {
              break label518;
            }
            if (this.dKY != null) {
              break label502;
            }
          }
          label502:
          for (localObject = (n.n)this.dKO.get(i);; localObject = (n.n)this.dKY.J(i, false))
          {
            if (!((n.n)localObject).isInitialized()) {
              break label516;
            }
            i += 1;
            break;
            j = this.dKY.getCount();
            break label451;
          }
          label516:
          continue;
          label518:
          if ((this.bitField0_ & 0x80) != 0) {}
          for (i = 1; (i == 0) || (abU().isInitialized()); i = 0) {
            return true;
          }
        }
      }
      
      public final a j(n.a parama)
      {
        Object localObject2 = null;
        if (parama == n.a.abX()) {
          return this;
        }
        if (parama.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.a.a(parama);
          onChanged();
        }
        if (this.dKT == null) {
          if (!n.a.b(parama).isEmpty())
          {
            if (this.dKJ.isEmpty())
            {
              this.dKJ = n.a.b(parama);
              this.bitField0_ &= 0xFFFFFFFD;
              onChanged();
            }
          }
          else
          {
            label94:
            if (this.dKU != null) {
              break label633;
            }
            if (!n.a.c(parama).isEmpty())
            {
              if (!this.dKK.isEmpty()) {
                break label612;
              }
              this.dKK = n.a.c(parama);
              this.bitField0_ &= 0xFFFFFFFB;
              label144:
              onChanged();
            }
            label148:
            if (this.dKV != null) {
              break label747;
            }
            if (!n.a.d(parama).isEmpty())
            {
              if (!this.dKL.isEmpty()) {
                break label726;
              }
              this.dKL = n.a.d(parama);
              this.bitField0_ &= 0xFFFFFFF7;
              label198:
              onChanged();
            }
            label202:
            if (this.dKW != null) {
              break label861;
            }
            if (!n.a.e(parama).isEmpty())
            {
              if (!this.dKM.isEmpty()) {
                break label840;
              }
              this.dKM = n.a.e(parama);
              this.bitField0_ &= 0xFFFFFFEF;
              label252:
              onChanged();
            }
            label256:
            if (this.dKX != null) {
              break label975;
            }
            if (!n.a.f(parama).isEmpty())
            {
              if (!this.dKN.isEmpty()) {
                break label954;
              }
              this.dKN = n.a.f(parama);
              this.bitField0_ &= 0xFFFFFFDF;
              label306:
              onChanged();
            }
            label310:
            if (this.dKY != null) {
              break label1089;
            }
            if (!n.a.g(parama).isEmpty())
            {
              if (!this.dKO.isEmpty()) {
                break label1068;
              }
              this.dKO = n.a.g(parama);
              this.bitField0_ &= 0xFFFFFFBF;
              label360:
              onChanged();
            }
            label364:
            if (parama.abT()) {
              a(parama.abU());
            }
            if (this.dLa != null) {
              break label1203;
            }
            if (!n.a.h(parama).isEmpty())
            {
              if (!this.dKQ.isEmpty()) {
                break label1182;
              }
              this.dKQ = n.a.h(parama);
              this.bitField0_ &= 0xFFFFFEFF;
              label431:
              onChanged();
            }
            label435:
            if (!n.a.i(parama).isEmpty())
            {
              if (!this.dKR.isEmpty()) {
                break label1294;
              }
              this.dKR = n.a.i(parama);
              this.bitField0_ &= 0xFFFFFDFF;
            }
          }
        }
        for (;;)
        {
          onChanged();
          b(parama.unknownFields);
          onChanged();
          return this;
          acb();
          this.dKJ.addAll(n.a.b(parama));
          break;
          if (n.a.b(parama).isEmpty()) {
            break label94;
          }
          Object localObject1;
          if (this.dKT.isEmpty())
          {
            this.dKT.dUC = null;
            this.dKT = null;
            this.dKJ = n.a.b(parama);
            this.bitField0_ &= 0xFFFFFFFD;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = acc();; localObject1 = null)
            {
              this.dKT = ((da)localObject1);
              break;
            }
          }
          this.dKT.a(n.a.b(parama));
          break label94;
          label612:
          acd();
          this.dKK.addAll(n.a.c(parama));
          break label144;
          label633:
          if (n.a.c(parama).isEmpty()) {
            break label148;
          }
          if (this.dKU.isEmpty())
          {
            this.dKU.dUC = null;
            this.dKU = null;
            this.dKK = n.a.c(parama);
            this.bitField0_ &= 0xFFFFFFFB;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = ace();; localObject1 = null)
            {
              this.dKU = ((da)localObject1);
              break;
            }
          }
          this.dKU.a(n.a.c(parama));
          break label148;
          label726:
          acf();
          this.dKL.addAll(n.a.d(parama));
          break label198;
          label747:
          if (n.a.d(parama).isEmpty()) {
            break label202;
          }
          if (this.dKV.isEmpty())
          {
            this.dKV.dUC = null;
            this.dKV = null;
            this.dKL = n.a.d(parama);
            this.bitField0_ &= 0xFFFFFFF7;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = acg();; localObject1 = null)
            {
              this.dKV = ((da)localObject1);
              break;
            }
          }
          this.dKV.a(n.a.d(parama));
          break label202;
          label840:
          ach();
          this.dKM.addAll(n.a.e(parama));
          break label252;
          label861:
          if (n.a.e(parama).isEmpty()) {
            break label256;
          }
          if (this.dKW.isEmpty())
          {
            this.dKW.dUC = null;
            this.dKW = null;
            this.dKM = n.a.e(parama);
            this.bitField0_ &= 0xFFFFFFEF;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = aci();; localObject1 = null)
            {
              this.dKW = ((da)localObject1);
              break;
            }
          }
          this.dKW.a(n.a.e(parama));
          break label256;
          label954:
          acj();
          this.dKN.addAll(n.a.f(parama));
          break label306;
          label975:
          if (n.a.f(parama).isEmpty()) {
            break label310;
          }
          if (this.dKX.isEmpty())
          {
            this.dKX.dUC = null;
            this.dKX = null;
            this.dKN = n.a.f(parama);
            this.bitField0_ &= 0xFFFFFFDF;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = ack();; localObject1 = null)
            {
              this.dKX = ((da)localObject1);
              break;
            }
          }
          this.dKX.a(n.a.f(parama));
          break label310;
          label1068:
          acl();
          this.dKO.addAll(n.a.g(parama));
          break label360;
          label1089:
          if (n.a.g(parama).isEmpty()) {
            break label364;
          }
          if (this.dKY.isEmpty())
          {
            this.dKY.dUC = null;
            this.dKY = null;
            this.dKO = n.a.g(parama);
            this.bitField0_ &= 0xFFFFFFBF;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = acm();; localObject1 = null)
            {
              this.dKY = ((da)localObject1);
              break;
            }
          }
          this.dKY.a(n.a.g(parama));
          break label364;
          label1182:
          aco();
          this.dKQ.addAll(n.a.h(parama));
          break label431;
          label1203:
          if (n.a.h(parama).isEmpty()) {
            break label435;
          }
          if (this.dLa.isEmpty())
          {
            this.dLa.dUC = null;
            this.dLa = null;
            this.dKQ = n.a.h(parama);
            this.bitField0_ &= 0xFFFFFEFF;
            localObject1 = localObject2;
            if (bg.alwaysUseFieldBuilders) {
              localObject1 = acp();
            }
            this.dLa = ((da)localObject1);
            break label435;
          }
          this.dLa.a(n.a.h(parama));
          break label435;
          label1294:
          acq();
          this.dKR.addAll(n.a.i(parama));
        }
      }
    }
    
    public static final class b
      extends bg
      implements o
    {
      @Deprecated
      public static final cs<b> PARSER = new c() {};
      private static final b dLe = new b();
      private int bitField0_;
      int dLb;
      int dLc;
      private n.f dLd;
      private byte memoizedIsInitialized = -1;
      
      private b() {}
      
      private b(bg.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(i parami, at paramat)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 35	com/google/d/n$a$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 58	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 59	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 65	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
        //   19: astore 6
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +223 -> 247
        //   27: aload_1
        //   28: invokevirtual 71	com/google/d/i:aac	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+235->270, 0:+241->276, 8:+59->94, 16:+104->139, 26:+142->177
        //   77: aload_1
        //   78: aload 6
        //   80: aload_2
        //   81: iload 4
        //   83: invokevirtual 75	com/google/d/n$a$b:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
        //   86: ifne +175 -> 261
        //   89: iconst_1
        //   90: istore_3
        //   91: goto +182 -> 273
        //   94: aload_0
        //   95: aload_0
        //   96: getfield 77	com/google/d/n$a$b:bitField0_	I
        //   99: iconst_1
        //   100: ior
        //   101: putfield 77	com/google/d/n$a$b:bitField0_	I
        //   104: aload_0
        //   105: aload_1
        //   106: invokevirtual 80	com/google/d/i:aaf	()I
        //   109: putfield 82	com/google/d/n$a$b:dLb	I
        //   112: goto -89 -> 23
        //   115: astore_1
        //   116: aload_1
        //   117: aload_0
        //   118: putfield 86	com/google/d/bk:dST	Lcom/google/d/ce;
        //   121: aload_1
        //   122: athrow
        //   123: astore_1
        //   124: aload_0
        //   125: aload 6
        //   127: invokevirtual 92	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   130: putfield 96	com/google/d/n$a$b:unknownFields	Lcom/google/d/dn;
        //   133: aload_0
        //   134: invokevirtual 99	com/google/d/n$a$b:makeExtensionsImmutable	()V
        //   137: aload_1
        //   138: athrow
        //   139: aload_0
        //   140: aload_0
        //   141: getfield 77	com/google/d/n$a$b:bitField0_	I
        //   144: iconst_2
        //   145: ior
        //   146: putfield 77	com/google/d/n$a$b:bitField0_	I
        //   149: aload_0
        //   150: aload_1
        //   151: invokevirtual 80	com/google/d/i:aaf	()I
        //   154: putfield 101	com/google/d/n$a$b:dLc	I
        //   157: goto -134 -> 23
        //   160: astore_1
        //   161: new 54	com/google/d/bk
        //   164: dup
        //   165: aload_1
        //   166: invokespecial 104	com/google/d/bk:<init>	(Ljava/io/IOException;)V
        //   169: astore_1
        //   170: aload_1
        //   171: aload_0
        //   172: putfield 86	com/google/d/bk:dST	Lcom/google/d/ce;
        //   175: aload_1
        //   176: athrow
        //   177: aload_0
        //   178: getfield 77	com/google/d/n$a$b:bitField0_	I
        //   181: iconst_4
        //   182: iand
        //   183: ifeq +81 -> 264
        //   186: aload_0
        //   187: getfield 106	com/google/d/n$a$b:dLd	Lcom/google/d/n$f;
        //   190: invokevirtual 112	com/google/d/n$f:adr	()Lcom/google/d/n$f$a;
        //   193: astore 5
        //   195: aload_0
        //   196: aload_1
        //   197: getstatic 113	com/google/d/n$f:PARSER	Lcom/google/d/cs;
        //   200: aload_2
        //   201: invokevirtual 116	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
        //   204: checkcast 108	com/google/d/n$f
        //   207: putfield 106	com/google/d/n$a$b:dLd	Lcom/google/d/n$f;
        //   210: aload 5
        //   212: ifnull +22 -> 234
        //   215: aload 5
        //   217: aload_0
        //   218: getfield 106	com/google/d/n$a$b:dLd	Lcom/google/d/n$f;
        //   221: invokevirtual 122	com/google/d/n$f$a:d	(Lcom/google/d/n$f;)Lcom/google/d/n$f$a;
        //   224: pop
        //   225: aload_0
        //   226: aload 5
        //   228: invokevirtual 126	com/google/d/n$f$a:adv	()Lcom/google/d/n$f;
        //   231: putfield 106	com/google/d/n$a$b:dLd	Lcom/google/d/n$f;
        //   234: aload_0
        //   235: aload_0
        //   236: getfield 77	com/google/d/n$a$b:bitField0_	I
        //   239: iconst_4
        //   240: ior
        //   241: putfield 77	com/google/d/n$a$b:bitField0_	I
        //   244: goto -221 -> 23
        //   247: aload_0
        //   248: aload 6
        //   250: invokevirtual 92	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   253: putfield 96	com/google/d/n$a$b:unknownFields	Lcom/google/d/dn;
        //   256: aload_0
        //   257: invokevirtual 99	com/google/d/n$a$b:makeExtensionsImmutable	()V
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
        //   0	281	1	parami	i
        //   0	281	2	paramat	at
        //   22	256	3	i	int
        //   31	51	4	j	int
        //   193	73	5	locala	n.f.a
        //   19	230	6	locala1	dn.a
        // Exception table:
        //   from	to	target	type
        //   27	33	115	com/google/d/bk
        //   76	89	115	com/google/d/bk
        //   94	112	115	com/google/d/bk
        //   139	157	115	com/google/d/bk
        //   177	195	115	com/google/d/bk
        //   195	210	115	com/google/d/bk
        //   215	234	115	com/google/d/bk
        //   234	244	115	com/google/d/bk
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
      
      public static a act()
      {
        return dLe.acu();
      }
      
      private a acu()
      {
        if (this == dLe) {
          return new a((byte)0);
        }
        return new a((byte)0).b(this);
      }
      
      public static b acv()
      {
        return dLe;
      }
      
      public final boolean abT()
      {
        return (this.bitField0_ & 0x4) != 0;
      }
      
      public final boolean acr()
      {
        return (this.bitField0_ & 0x1) != 0;
      }
      
      public final n.f acs()
      {
        if (this.dLd == null) {
          return n.f.ads();
        }
        return this.dLd;
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
          if (acr() != paramObject.acr()) {
            return false;
          }
          if ((acr()) && (this.dLb != paramObject.dLb)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.dLc != paramObject.dLc)) {
            return false;
          }
          if (abT() != paramObject.abT()) {
            return false;
          }
          if ((abT()) && (!acs().equals(paramObject.acs()))) {
            return false;
          }
        } while (this.unknownFields.equals(paramObject.unknownFields));
        return false;
      }
      
      public final cs<b> getParserForType()
      {
        return PARSER;
      }
      
      public final int getSerializedSize()
      {
        int i = this.memoizedSize;
        if (i != -1) {
          return i;
        }
        int j = 0;
        if ((this.bitField0_ & 0x1) != 0) {
          j = k.cJ(1, this.dLb) + 0;
        }
        i = j;
        if ((this.bitField0_ & 0x2) != 0) {
          i = j + k.cJ(2, this.dLc);
        }
        j = i;
        if ((this.bitField0_ & 0x4) != 0) {
          j = i + k.c(3, acs());
        }
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final dn getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasEnd()
      {
        return (this.bitField0_ & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.memoizedHashCode != 0) {
          return this.memoizedHashCode;
        }
        int j = n.aaV().hashCode() + 779;
        int i = j;
        if (acr()) {
          i = (j * 37 + 1) * 53 + this.dLb;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.dLc;
        }
        i = j;
        if (abT()) {
          i = (j * 37 + 3) * 53 + acs().hashCode();
        }
        i = i * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.aaW().b(b.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = this.memoizedIsInitialized;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        if ((abT()) && (!acs().isInitialized()))
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
      }
      
      protected final Object newInstance(bg.f paramf)
      {
        return new b();
      }
      
      public final void writeTo(k paramk)
      {
        if ((this.bitField0_ & 0x1) != 0) {
          paramk.cF(1, this.dLb);
        }
        if ((this.bitField0_ & 0x2) != 0) {
          paramk.cF(2, this.dLc);
        }
        if ((this.bitField0_ & 0x4) != 0) {
          paramk.a(3, acs());
        }
        this.unknownFields.writeTo(paramk);
      }
      
      public static final class a
        extends bg.a<a>
        implements o
      {
        private int bitField0_;
        private df<n.f, n.f.a, w> dKZ;
        private int dLb;
        private int dLc;
        private n.f dLd;
        
        private a()
        {
          maybeForceBuilderInitialization();
        }
        
        private a(bg.b paramb)
        {
          super();
          maybeForceBuilderInitialization();
        }
        
        private a a(n.f paramf)
        {
          if (this.dKZ == null) {
            if (((this.bitField0_ & 0x4) != 0) && (this.dLd != null) && (this.dLd != n.f.ads()))
            {
              this.dLd = n.f.b(this.dLd).d(paramf).adv();
              onChanged();
            }
          }
          for (;;)
          {
            this.bitField0_ |= 0x4;
            return this;
            this.dLd = paramf;
            break;
            this.dKZ.c(paramf);
          }
        }
        
        private df<n.f, n.f.a, w> acn()
        {
          if (this.dKZ == null)
          {
            this.dKZ = new df(acs(), getParentForChildren(), isClean());
            this.dLd = null;
          }
          return this.dKZ;
        }
        
        private n.f acs()
        {
          if (this.dKZ == null)
          {
            if (this.dLd == null) {
              return n.f.ads();
            }
            return this.dLd;
          }
          return (n.f)this.dKZ.ajm();
        }
        
        private a acw()
        {
          super.clear();
          this.dLb = 0;
          this.bitField0_ &= 0xFFFFFFFE;
          this.dLc = 0;
          this.bitField0_ &= 0xFFFFFFFD;
          if (this.dKZ == null) {
            this.dLd = null;
          }
          for (;;)
          {
            this.bitField0_ &= 0xFFFFFFFB;
            return this;
            this.dKZ.ajp();
          }
        }
        
        private n.a.b acy()
        {
          int i = 0;
          n.a.b localb = new n.a.b(this, (byte)0);
          int k = this.bitField0_;
          if ((k & 0x1) != 0)
          {
            n.a.b.a(localb, this.dLb);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            n.a.b.b(localb, this.dLc);
            j = i | 0x2;
          }
          if ((k & 0x4) != 0) {
            if (this.dKZ == null) {
              n.a.b.a(localb, this.dLd);
            }
          }
          for (i = j | 0x4;; i = j)
          {
            n.a.b.c(localb, i);
            onBuilt();
            return localb;
            n.a.b.a(localb, (n.f)this.dKZ.ajn());
            break;
          }
        }
        
        private a b(am.f paramf, int paramInt, Object paramObject)
        {
          return (a)super.setRepeatedField(paramf, paramInt, paramObject);
        }
        
        private a b(am.j paramj)
        {
          return (a)super.clearOneof(paramj);
        }
        
        private a b(cb paramcb)
        {
          if ((paramcb instanceof n.a.b)) {
            return b((n.a.b)paramcb);
          }
          super.mergeFrom(paramcb);
          return this;
        }
        
        /* Error */
        private a b(i parami, at paramat)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 153	com/google/d/n$a$b:PARSER	Lcom/google/d/cs;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 159 3 0
          //   12: checkcast 14	com/google/d/n$a$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 142	com/google/d/n$a$b$a:b	(Lcom/google/d/n$a$b;)Lcom/google/d/n$a$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 163	com/google/d/bk:dST	Lcom/google/d/ce;
          //   33: checkcast 14	com/google/d/n$a$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 167	com/google/d/bk:aii	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 142	com/google/d/n$a$b$a:b	(Lcom/google/d/n$a$b;)Lcom/google/d/n$a$b$a;
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
          //   0	61	1	parami	i
          //   0	61	2	paramat	at
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/d/bk
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a c(am.f paramf, Object paramObject)
        {
          return (a)super.setField(paramf, paramObject);
        }
        
        private a c(dn paramdn)
        {
          return (a)super.setUnknownFields(paramdn);
        }
        
        private a d(am.f paramf, Object paramObject)
        {
          return (a)super.addRepeatedField(paramf, paramObject);
        }
        
        private a d(dn paramdn)
        {
          return (a)super.mergeUnknownFields(paramdn);
        }
        
        private a e(am.f paramf)
        {
          return (a)super.clearField(paramf);
        }
        
        private void maybeForceBuilderInitialization()
        {
          if (bg.alwaysUseFieldBuilders) {
            acn();
          }
        }
        
        public final n.a.b acx()
        {
          n.a.b localb = acy();
          if (!localb.isInitialized()) {
            throw newUninitializedMessageException(localb);
          }
          return localb;
        }
        
        public final a b(n.a.b paramb)
        {
          if (paramb == n.a.b.acv()) {
            return this;
          }
          if (paramb.acr()) {
            kH(paramb.dLb);
          }
          if (paramb.hasEnd()) {
            kI(paramb.dLc);
          }
          if (paramb.abT()) {
            a(paramb.acs());
          }
          d(paramb.unknownFields);
          onChanged();
          return this;
        }
        
        public final am.a getDescriptorForType()
        {
          return n.aaV();
        }
        
        protected final bg.e internalGetFieldAccessorTable()
        {
          return n.aaW().b(n.a.b.class, a.class);
        }
        
        public final boolean isInitialized()
        {
          if ((this.bitField0_ & 0x4) != 0) {}
          for (int i = 1; (i != 0) && (!acs().isInitialized()); i = 0) {
            return false;
          }
          return true;
        }
        
        public final a kH(int paramInt)
        {
          this.bitField0_ |= 0x1;
          this.dLb = paramInt;
          onChanged();
          return this;
        }
        
        public final a kI(int paramInt)
        {
          this.bitField0_ |= 0x2;
          this.dLc = paramInt;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class c
      extends bg
      implements p
    {
      @Deprecated
      public static final cs<c> PARSER = new c() {};
      private static final c dLf = new c();
      private int bitField0_;
      int dLb;
      int dLc;
      private byte memoizedIsInitialized = -1;
      
      private c() {}
      
      private c(bg.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private c(i parami, at paramat)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 33	com/google/d/n$a$c:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 56	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 57	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 63	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
        //   19: astore 5
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +145 -> 169
        //   27: aload_1
        //   28: invokevirtual 69	com/google/d/i:aac	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+148->183, 0:+151->186, 8:+51->86, 16:+96->131
        //   69: aload_1
        //   70: aload 5
        //   72: aload_2
        //   73: iload 4
        //   75: invokevirtual 73	com/google/d/n$a$c:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
        //   78: ifne -55 -> 23
        //   81: iconst_1
        //   82: istore_3
        //   83: goto -60 -> 23
        //   86: aload_0
        //   87: aload_0
        //   88: getfield 75	com/google/d/n$a$c:bitField0_	I
        //   91: iconst_1
        //   92: ior
        //   93: putfield 75	com/google/d/n$a$c:bitField0_	I
        //   96: aload_0
        //   97: aload_1
        //   98: invokevirtual 78	com/google/d/i:aaf	()I
        //   101: putfield 80	com/google/d/n$a$c:dLb	I
        //   104: goto -81 -> 23
        //   107: astore_1
        //   108: aload_1
        //   109: aload_0
        //   110: putfield 84	com/google/d/bk:dST	Lcom/google/d/ce;
        //   113: aload_1
        //   114: athrow
        //   115: astore_1
        //   116: aload_0
        //   117: aload 5
        //   119: invokevirtual 90	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   122: putfield 94	com/google/d/n$a$c:unknownFields	Lcom/google/d/dn;
        //   125: aload_0
        //   126: invokevirtual 97	com/google/d/n$a$c:makeExtensionsImmutable	()V
        //   129: aload_1
        //   130: athrow
        //   131: aload_0
        //   132: aload_0
        //   133: getfield 75	com/google/d/n$a$c:bitField0_	I
        //   136: iconst_2
        //   137: ior
        //   138: putfield 75	com/google/d/n$a$c:bitField0_	I
        //   141: aload_0
        //   142: aload_1
        //   143: invokevirtual 78	com/google/d/i:aaf	()I
        //   146: putfield 99	com/google/d/n$a$c:dLc	I
        //   149: goto -126 -> 23
        //   152: astore_1
        //   153: new 52	com/google/d/bk
        //   156: dup
        //   157: aload_1
        //   158: invokespecial 102	com/google/d/bk:<init>	(Ljava/io/IOException;)V
        //   161: astore_1
        //   162: aload_1
        //   163: aload_0
        //   164: putfield 84	com/google/d/bk:dST	Lcom/google/d/ce;
        //   167: aload_1
        //   168: athrow
        //   169: aload_0
        //   170: aload 5
        //   172: invokevirtual 90	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   175: putfield 94	com/google/d/n$a$c:unknownFields	Lcom/google/d/dn;
        //   178: aload_0
        //   179: invokevirtual 97	com/google/d/n$a$c:makeExtensionsImmutable	()V
        //   182: return
        //   183: goto -115 -> 68
        //   186: iconst_1
        //   187: istore_3
        //   188: goto -165 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	191	0	this	c
        //   0	191	1	parami	i
        //   0	191	2	paramat	at
        //   22	166	3	i	int
        //   31	43	4	j	int
        //   19	152	5	locala	dn.a
        // Exception table:
        //   from	to	target	type
        //   27	33	107	com/google/d/bk
        //   68	81	107	com/google/d/bk
        //   86	104	107	com/google/d/bk
        //   131	149	107	com/google/d/bk
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
      
      public static c acA()
      {
        return dLf;
      }
      
      private a acz()
      {
        if (this == dLf) {
          return new a((byte)0);
        }
        return new a((byte)0).a(this);
      }
      
      public final boolean acr()
      {
        return (this.bitField0_ & 0x1) != 0;
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
          if (acr() != paramObject.acr()) {
            return false;
          }
          if ((acr()) && (this.dLb != paramObject.dLb)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.dLc != paramObject.dLc)) {
            return false;
          }
        } while (this.unknownFields.equals(paramObject.unknownFields));
        return false;
      }
      
      public final cs<c> getParserForType()
      {
        return PARSER;
      }
      
      public final int getSerializedSize()
      {
        int i = this.memoizedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bitField0_ & 0x1) != 0) {
          i = k.cJ(1, this.dLb) + 0;
        }
        int j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.cJ(2, this.dLc);
        }
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final dn getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasEnd()
      {
        return (this.bitField0_ & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.memoizedHashCode != 0) {
          return this.memoizedHashCode;
        }
        int j = n.aaX().hashCode() + 779;
        int i = j;
        if (acr()) {
          i = (j * 37 + 1) * 53 + this.dLb;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.dLc;
        }
        i = j * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.aaY().b(c.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = this.memoizedIsInitialized;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
      }
      
      protected final Object newInstance(bg.f paramf)
      {
        return new c();
      }
      
      public final void writeTo(k paramk)
      {
        if ((this.bitField0_ & 0x1) != 0) {
          paramk.cF(1, this.dLb);
        }
        if ((this.bitField0_ & 0x2) != 0) {
          paramk.cF(2, this.dLc);
        }
        this.unknownFields.writeTo(paramk);
      }
      
      public static final class a
        extends bg.a<a>
        implements p
      {
        private int bitField0_;
        private int dLb;
        private int dLc;
        
        private a()
        {
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a(bg.b paramb)
        {
          super();
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a acB()
        {
          super.clear();
          this.dLb = 0;
          this.bitField0_ &= 0xFFFFFFFE;
          this.dLc = 0;
          this.bitField0_ &= 0xFFFFFFFD;
          return this;
        }
        
        private n.a.c acC()
        {
          n.a.c localc = acD();
          if (!localc.isInitialized()) {
            throw newUninitializedMessageException(localc);
          }
          return localc;
        }
        
        private n.a.c acD()
        {
          int i = 0;
          n.a.c localc = new n.a.c(this, (byte)0);
          int k = this.bitField0_;
          if ((k & 0x1) != 0)
          {
            n.a.c.a(localc, this.dLb);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            n.a.c.b(localc, this.dLc);
            j = i | 0x2;
          }
          n.a.c.c(localc, j);
          onBuilt();
          return localc;
        }
        
        private a c(am.f paramf, int paramInt, Object paramObject)
        {
          return (a)super.setRepeatedField(paramf, paramInt, paramObject);
        }
        
        private a c(am.j paramj)
        {
          return (a)super.clearOneof(paramj);
        }
        
        private a c(cb paramcb)
        {
          if ((paramcb instanceof n.a.c)) {
            return a((n.a.c)paramcb);
          }
          super.mergeFrom(paramcb);
          return this;
        }
        
        /* Error */
        private a c(i parami, at paramat)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 101	com/google/d/n$a$c:PARSER	Lcom/google/d/cs;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 107 3 0
          //   12: checkcast 14	com/google/d/n$a$c
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 90	com/google/d/n$a$c$a:a	(Lcom/google/d/n$a$c;)Lcom/google/d/n$a$c$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 111	com/google/d/bk:dST	Lcom/google/d/ce;
          //   33: checkcast 14	com/google/d/n$a$c
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 115	com/google/d/bk:aii	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 90	com/google/d/n$a$c$a:a	(Lcom/google/d/n$a$c;)Lcom/google/d/n$a$c$a;
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
          //   0	61	1	parami	i
          //   0	61	2	paramat	at
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/d/bk
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a e(am.f paramf, Object paramObject)
        {
          return (a)super.setField(paramf, paramObject);
        }
        
        private a e(dn paramdn)
        {
          return (a)super.setUnknownFields(paramdn);
        }
        
        private a f(am.f paramf)
        {
          return (a)super.clearField(paramf);
        }
        
        private a f(am.f paramf, Object paramObject)
        {
          return (a)super.addRepeatedField(paramf, paramObject);
        }
        
        private a f(dn paramdn)
        {
          return (a)super.mergeUnknownFields(paramdn);
        }
        
        private a kJ(int paramInt)
        {
          this.bitField0_ |= 0x1;
          this.dLb = paramInt;
          onChanged();
          return this;
        }
        
        private a kK(int paramInt)
        {
          this.bitField0_ |= 0x2;
          this.dLc = paramInt;
          onChanged();
          return this;
        }
        
        public final a a(n.a.c paramc)
        {
          if (paramc == n.a.c.acA()) {
            return this;
          }
          if (paramc.acr()) {
            kJ(paramc.dLb);
          }
          if (paramc.hasEnd()) {
            kK(paramc.dLc);
          }
          f(paramc.unknownFields);
          onChanged();
          return this;
        }
        
        public final am.a getDescriptorForType()
        {
          return n.aaX();
        }
        
        protected final bg.e internalGetFieldAccessorTable()
        {
          return n.aaY().b(n.a.c.class, a.class);
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
  }
  
  public static final class b
    extends bg
    implements s
  {
    @Deprecated
    public static final cs<b> PARSER = new c() {};
    private static final b dLi = new b();
    private int bitField0_;
    private List<b> dKQ;
    private bp dKR;
    private List<n.d> dLg;
    private n.c dLh;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private b()
    {
      this.name_ = "";
      this.dLg = Collections.emptyList();
      this.dKQ = Collections.emptyList();
      this.dKR = bo.dTm;
    }
    
    private b(bg.a<?> parama)
    {
      super();
    }
    
    private b(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            n = parami.aac();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (parseUnknownField(parami, locala, paramat, n)) {
                break label722;
              }
              j = 1;
              break label738;
              k = i;
              m = i;
              j = i;
              localObject = parami.aak();
              k = i;
              m = i;
              j = i;
              this.bitField0_ |= 0x1;
              k = i;
              m = i;
              j = i;
              this.name_ = localObject;
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              j = k;
              if ((j & 0x2) != 0) {
                this.dLg = Collections.unmodifiableList(this.dLg);
              }
              if ((j & 0x8) != 0) {
                this.dKQ = Collections.unmodifiableList(this.dKQ);
              }
              if ((j & 0x10) != 0) {
                this.dKR = this.dKR.aiv();
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dLg = new ArrayList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.dLg.add(parami.a(n.d.PARSER, paramat));
            i = n;
            break;
          }
          catch (IOException parami)
          {
            j = m;
            parami = new bk(parami);
            j = m;
            parami.dST = this;
            j = m;
            throw parami;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            if ((this.bitField0_ & 0x2) == 0) {
              break label729;
            }
          }
          k = i;
          m = i;
          j = i;
          label722:
          label729:
          for (Object localObject = this.dLh.acV();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.dLh = ((n.c)parami.a(n.c.PARSER, paramat));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((n.c.a)localObject).d(this.dLh);
              k = i;
              m = i;
              j = i;
              this.dLh = ((n.c.a)localObject).acZ();
            }
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x2;
            break;
            n = i;
            if ((i & 0x8) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dKQ = new ArrayList();
              n = i | 0x8;
            }
            k = n;
            m = n;
            j = n;
            this.dKQ.add(parami.a(b.PARSER, paramat));
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            localObject = parami.aak();
            n = i;
            if ((i & 0x10) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dKR = new bo();
              n = i | 0x10;
            }
            k = n;
            m = n;
            j = n;
            this.dKR.d((h)localObject);
            i = n;
            break;
            if ((i & 0x2) != 0) {
              this.dLg = Collections.unmodifiableList(this.dLg);
            }
            if ((i & 0x8) != 0) {
              this.dKQ = Collections.unmodifiableList(this.dKQ);
            }
            if ((i & 0x10) != 0) {
              this.dKR = this.dKR.aiv();
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
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
    
    private a acG()
    {
      if (this == dLi) {
        return new a((byte)0);
      }
      return new a((byte)0).e(this);
    }
    
    public static b acH()
    {
      return dLi;
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final int acE()
    {
      return this.dLg.size();
    }
    
    public final n.c acF()
    {
      if (this.dLh == null) {
        return n.c.acW();
      }
      return this.dLh;
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
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.dLg.equals(paramObject.dLg)) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!acF().equals(paramObject.acF()))) {
          return false;
        }
        if (!this.dKQ.equals(paramObject.dKQ)) {
          return false;
        }
        if (!this.dKR.equals(paramObject.dKR)) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<b> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (i = bg.computeStringSize(1, this.name_) + 0;; i = 0)
      {
        int j = 0;
        while (j < this.dLg.size())
        {
          i += k.c(2, (ce)this.dLg.get(j));
          j += 1;
        }
        j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.c(3, acF());
        }
        i = 0;
        while (i < this.dKQ.size())
        {
          j += k.c(4, (ce)this.dKQ.get(i));
          i += 1;
        }
        i = 0;
        int k = 0;
        while (i < this.dKR.size())
        {
          k += computeStringSizeNoTag(this.dKR.getRaw(i));
          i += 1;
        }
        i = j + k + this.dKR.size() * 1 + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abf().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (acE() > 0) {
        j = (i * 37 + 2) * 53 + this.dLg.hashCode();
      }
      i = j;
      if (abT()) {
        i = (j * 37 + 3) * 53 + acF().hashCode();
      }
      j = i;
      if (this.dKQ.size() > 0) {
        j = (i * 37 + 4) * 53 + this.dKQ.hashCode();
      }
      i = j;
      if (this.dKR.size() > 0) {
        i = (j * 37 + 5) * 53 + this.dKR.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abg().b(b.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acE())
      {
        if (!kL(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if ((abT()) && (!acF().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final n.d kL(int paramInt)
    {
      return (n.d)this.dLg.get(paramInt);
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new b();
    }
    
    public final void writeTo(k paramk)
    {
      int k = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      int i = 0;
      while (i < this.dLg.size())
      {
        paramk.a(2, (ce)this.dLg.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.a(3, acF());
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.dKQ.size()) {
          break;
        }
        paramk.a(4, (ce)this.dKQ.get(i));
        i += 1;
      }
      while (j < this.dKR.size())
      {
        bg.writeString(paramk, 5, this.dKR.getRaw(j));
        j += 1;
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements s
    {
      private int bitField0_;
      private List<n.b.b> dKQ = Collections.emptyList();
      private bp dKR = bo.dTm;
      private df<n.c, n.c.a, t> dKZ;
      private da<n.b.b, n.b.b.a, r> dLa;
      private List<n.d> dLg = Collections.emptyList();
      private n.c dLh;
      private da<n.d, n.d.a, u> dLj;
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a a(n.c paramc)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x4) != 0) && (this.dLh != null) && (this.dLh != n.c.acW()))
          {
            this.dLh = n.c.b(this.dLh).d(paramc).acZ();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x4;
          return this;
          this.dLh = paramc;
          break;
          this.dKZ.c(paramc);
        }
      }
      
      private n.c acF()
      {
        if (this.dKZ == null)
        {
          if (this.dLh == null) {
            return n.c.acW();
          }
          return this.dLh;
        }
        return (n.c)this.dKZ.ajm();
      }
      
      private a acI()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.dLj == null)
        {
          this.dLg = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFD;
          if (this.dKZ != null) {
            break label125;
          }
          this.dLh = null;
          label59:
          this.bitField0_ &= 0xFFFFFFFB;
          if (this.dLa != null) {
            break label136;
          }
          this.dKQ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFF7;
        }
        for (;;)
        {
          this.dKR = bo.dTm;
          this.bitField0_ &= 0xFFFFFFEF;
          return this;
          this.dLj.clear();
          break;
          label125:
          this.dKZ.ajp();
          break label59;
          label136:
          this.dLa.clear();
        }
      }
      
      private n.b acJ()
      {
        n.b localb = acK();
        if (!localb.isInitialized()) {
          throw newUninitializedMessageException(localb);
        }
        return localb;
      }
      
      private n.b acK()
      {
        n.b localb = new n.b(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          n.b.a(localb, this.name_);
          int j;
          if (this.dLj == null)
          {
            if ((this.bitField0_ & 0x2) != 0)
            {
              this.dLg = Collections.unmodifiableList(this.dLg);
              this.bitField0_ &= 0xFFFFFFFD;
            }
            n.b.a(localb, this.dLg);
            j = i;
            if ((k & 0x4) != 0)
            {
              if (this.dKZ != null) {
                break label234;
              }
              n.b.a(localb, this.dLh);
              label107:
              j = i | 0x2;
            }
            if (this.dLa != null) {
              break label253;
            }
            if ((this.bitField0_ & 0x8) != 0)
            {
              this.dKQ = Collections.unmodifiableList(this.dKQ);
              this.bitField0_ &= 0xFFFFFFF7;
            }
            n.b.b(localb, this.dKQ);
          }
          for (;;)
          {
            if ((this.bitField0_ & 0x10) != 0)
            {
              this.dKR = this.dKR.aiv();
              this.bitField0_ &= 0xFFFFFFEF;
            }
            n.b.a(localb, this.dKR);
            n.b.a(localb, j);
            onBuilt();
            return localb;
            n.b.a(localb, this.dLj.build());
            break;
            label234:
            n.b.a(localb, (n.c)this.dKZ.ajn());
            break label107;
            label253:
            n.b.b(localb, this.dLa.build());
          }
        }
      }
      
      private void acL()
      {
        if ((this.bitField0_ & 0x2) == 0)
        {
          this.dLg = new ArrayList(this.dLg);
          this.bitField0_ |= 0x2;
        }
      }
      
      private da<n.d, n.d.a, u> acM()
      {
        List localList;
        if (this.dLj == null)
        {
          localList = this.dLg;
          if ((this.bitField0_ & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLj = new da(localList, bool, getParentForChildren(), isClean());
          this.dLg = null;
          return this.dLj;
        }
      }
      
      private df<n.c, n.c.a, t> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(acF(), getParentForChildren(), isClean());
          this.dLh = null;
        }
        return this.dKZ;
      }
      
      private void aco()
      {
        if ((this.bitField0_ & 0x8) == 0)
        {
          this.dKQ = new ArrayList(this.dKQ);
          this.bitField0_ |= 0x8;
        }
      }
      
      private da<n.b.b, n.b.b.a, r> acp()
      {
        List localList;
        if (this.dLa == null)
        {
          localList = this.dKQ;
          if ((this.bitField0_ & 0x8) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dLa = new da(localList, bool, getParentForChildren(), isClean());
          this.dKQ = null;
          return this.dLa;
        }
      }
      
      private void acq()
      {
        if ((this.bitField0_ & 0x10) == 0)
        {
          this.dKR = new bo(this.dKR);
          this.bitField0_ |= 0x10;
        }
      }
      
      private a d(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a d(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a d(cb paramcb)
      {
        if ((paramcb instanceof n.b)) {
          return e((n.b)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a d(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 238	com/google/d/n$b:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 244 3 0
        //   12: checkcast 9	com/google/d/n$b
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 227	com/google/d/n$b$a:e	(Lcom/google/d/n$b;)Lcom/google/d/n$b$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 248	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$b
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 252	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 227	com/google/d/n$b$a:e	(Lcom/google/d/n$b;)Lcom/google/d/n$b$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a g(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      private a g(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a g(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a h(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a h(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders)
        {
          acM();
          acn();
          acp();
        }
      }
      
      public final a e(n.b paramb)
      {
        Object localObject2 = null;
        if (paramb == n.b.acH()) {
          return this;
        }
        if (paramb.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.b.a(paramb);
          onChanged();
        }
        if (this.dLj == null) {
          if (!n.b.b(paramb).isEmpty())
          {
            if (this.dLg.isEmpty())
            {
              this.dLg = n.b.b(paramb);
              this.bitField0_ &= 0xFFFFFFFD;
              onChanged();
            }
          }
          else
          {
            label94:
            if (paramb.abT()) {
              a(paramb.acF());
            }
            if (this.dLa != null) {
              break label361;
            }
            if (!n.b.c(paramb).isEmpty())
            {
              if (!this.dKQ.isEmpty()) {
                break label340;
              }
              this.dKQ = n.b.c(paramb);
              this.bitField0_ &= 0xFFFFFFF7;
              label160:
              onChanged();
            }
            label164:
            if (!n.b.d(paramb).isEmpty())
            {
              if (!this.dKR.isEmpty()) {
                break label451;
              }
              this.dKR = n.b.d(paramb);
              this.bitField0_ &= 0xFFFFFFEF;
            }
          }
        }
        for (;;)
        {
          onChanged();
          h(paramb.unknownFields);
          onChanged();
          return this;
          acL();
          this.dLg.addAll(n.b.b(paramb));
          break;
          if (n.b.b(paramb).isEmpty()) {
            break label94;
          }
          Object localObject1;
          if (this.dLj.isEmpty())
          {
            this.dLj.dUC = null;
            this.dLj = null;
            this.dLg = n.b.b(paramb);
            this.bitField0_ &= 0xFFFFFFFD;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = acM();; localObject1 = null)
            {
              this.dLj = ((da)localObject1);
              break;
            }
          }
          this.dLj.a(n.b.b(paramb));
          break label94;
          label340:
          aco();
          this.dKQ.addAll(n.b.c(paramb));
          break label160;
          label361:
          if (n.b.c(paramb).isEmpty()) {
            break label164;
          }
          if (this.dLa.isEmpty())
          {
            this.dLa.dUC = null;
            this.dLa = null;
            this.dKQ = n.b.c(paramb);
            this.bitField0_ &= 0xFFFFFFF7;
            localObject1 = localObject2;
            if (bg.alwaysUseFieldBuilders) {
              localObject1 = acp();
            }
            this.dLa = ((da)localObject1);
            break label164;
          }
          this.dLa.a(n.b.c(paramb));
          break label164;
          label451:
          acq();
          this.dKR.addAll(n.b.d(paramb));
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abf();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abg().b(n.b.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        n.d locald;
        if (this.dLj == null)
        {
          j = this.dLg.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLj != null) {
            break label65;
          }
          locald = (n.d)this.dLg.get(i);
          label45:
          if (locald.isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.dLj.getCount();
          break label19;
          label65:
          locald = (n.d)this.dLj.J(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          if ((this.bitField0_ & 0x4) != 0) {}
          for (i = 1; (i == 0) || (acF().isInitialized()); i = 0) {
            return true;
          }
        }
      }
    }
    
    public static final class b
      extends bg
      implements r
    {
      @Deprecated
      public static final cs<b> PARSER = new c() {};
      private static final b dLk = new b();
      private int bitField0_;
      int dLb;
      int dLc;
      private byte memoizedIsInitialized = -1;
      
      private b() {}
      
      private b(bg.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(i parami, at paramat)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 33	com/google/d/n$b$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 56	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 57	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 63	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
        //   19: astore 5
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +145 -> 169
        //   27: aload_1
        //   28: invokevirtual 69	com/google/d/i:aac	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+148->183, 0:+151->186, 8:+51->86, 16:+96->131
        //   69: aload_1
        //   70: aload 5
        //   72: aload_2
        //   73: iload 4
        //   75: invokevirtual 73	com/google/d/n$b$b:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
        //   78: ifne -55 -> 23
        //   81: iconst_1
        //   82: istore_3
        //   83: goto -60 -> 23
        //   86: aload_0
        //   87: aload_0
        //   88: getfield 75	com/google/d/n$b$b:bitField0_	I
        //   91: iconst_1
        //   92: ior
        //   93: putfield 75	com/google/d/n$b$b:bitField0_	I
        //   96: aload_0
        //   97: aload_1
        //   98: invokevirtual 78	com/google/d/i:aaf	()I
        //   101: putfield 80	com/google/d/n$b$b:dLb	I
        //   104: goto -81 -> 23
        //   107: astore_1
        //   108: aload_1
        //   109: aload_0
        //   110: putfield 84	com/google/d/bk:dST	Lcom/google/d/ce;
        //   113: aload_1
        //   114: athrow
        //   115: astore_1
        //   116: aload_0
        //   117: aload 5
        //   119: invokevirtual 90	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   122: putfield 94	com/google/d/n$b$b:unknownFields	Lcom/google/d/dn;
        //   125: aload_0
        //   126: invokevirtual 97	com/google/d/n$b$b:makeExtensionsImmutable	()V
        //   129: aload_1
        //   130: athrow
        //   131: aload_0
        //   132: aload_0
        //   133: getfield 75	com/google/d/n$b$b:bitField0_	I
        //   136: iconst_2
        //   137: ior
        //   138: putfield 75	com/google/d/n$b$b:bitField0_	I
        //   141: aload_0
        //   142: aload_1
        //   143: invokevirtual 78	com/google/d/i:aaf	()I
        //   146: putfield 99	com/google/d/n$b$b:dLc	I
        //   149: goto -126 -> 23
        //   152: astore_1
        //   153: new 52	com/google/d/bk
        //   156: dup
        //   157: aload_1
        //   158: invokespecial 102	com/google/d/bk:<init>	(Ljava/io/IOException;)V
        //   161: astore_1
        //   162: aload_1
        //   163: aload_0
        //   164: putfield 84	com/google/d/bk:dST	Lcom/google/d/ce;
        //   167: aload_1
        //   168: athrow
        //   169: aload_0
        //   170: aload 5
        //   172: invokevirtual 90	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   175: putfield 94	com/google/d/n$b$b:unknownFields	Lcom/google/d/dn;
        //   178: aload_0
        //   179: invokevirtual 97	com/google/d/n$b$b:makeExtensionsImmutable	()V
        //   182: return
        //   183: goto -115 -> 68
        //   186: iconst_1
        //   187: istore_3
        //   188: goto -165 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	191	0	this	b
        //   0	191	1	parami	i
        //   0	191	2	paramat	at
        //   22	166	3	i	int
        //   31	43	4	j	int
        //   19	152	5	locala	dn.a
        // Exception table:
        //   from	to	target	type
        //   27	33	107	com/google/d/bk
        //   68	81	107	com/google/d/bk
        //   86	104	107	com/google/d/bk
        //   131	149	107	com/google/d/bk
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
      
      private a acN()
      {
        if (this == dLk) {
          return new a((byte)0);
        }
        return new a((byte)0).a(this);
      }
      
      public static b acO()
      {
        return dLk;
      }
      
      public final boolean acr()
      {
        return (this.bitField0_ & 0x1) != 0;
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
          if (acr() != paramObject.acr()) {
            return false;
          }
          if ((acr()) && (this.dLb != paramObject.dLb)) {
            return false;
          }
          if (hasEnd() != paramObject.hasEnd()) {
            return false;
          }
          if ((hasEnd()) && (this.dLc != paramObject.dLc)) {
            return false;
          }
        } while (this.unknownFields.equals(paramObject.unknownFields));
        return false;
      }
      
      public final cs<b> getParserForType()
      {
        return PARSER;
      }
      
      public final int getSerializedSize()
      {
        int i = this.memoizedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bitField0_ & 0x1) != 0) {
          i = k.cJ(1, this.dLb) + 0;
        }
        int j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.cJ(2, this.dLc);
        }
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final dn getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasEnd()
      {
        return (this.bitField0_ & 0x2) != 0;
      }
      
      public final int hashCode()
      {
        if (this.memoizedHashCode != 0) {
          return this.memoizedHashCode;
        }
        int j = n.abh().hashCode() + 779;
        int i = j;
        if (acr()) {
          i = (j * 37 + 1) * 53 + this.dLb;
        }
        j = i;
        if (hasEnd()) {
          j = (i * 37 + 2) * 53 + this.dLc;
        }
        i = j * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abi().b(b.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = this.memoizedIsInitialized;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
      }
      
      protected final Object newInstance(bg.f paramf)
      {
        return new b();
      }
      
      public final void writeTo(k paramk)
      {
        if ((this.bitField0_ & 0x1) != 0) {
          paramk.cF(1, this.dLb);
        }
        if ((this.bitField0_ & 0x2) != 0) {
          paramk.cF(2, this.dLc);
        }
        this.unknownFields.writeTo(paramk);
      }
      
      public static final class a
        extends bg.a<a>
        implements r
      {
        private int bitField0_;
        private int dLb;
        private int dLc;
        
        private a()
        {
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a(bg.b paramb)
        {
          super();
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a acP()
        {
          super.clear();
          this.dLb = 0;
          this.bitField0_ &= 0xFFFFFFFE;
          this.dLc = 0;
          this.bitField0_ &= 0xFFFFFFFD;
          return this;
        }
        
        private n.b.b acQ()
        {
          n.b.b localb = acR();
          if (!localb.isInitialized()) {
            throw newUninitializedMessageException(localb);
          }
          return localb;
        }
        
        private n.b.b acR()
        {
          int i = 0;
          n.b.b localb = new n.b.b(this, (byte)0);
          int k = this.bitField0_;
          if ((k & 0x1) != 0)
          {
            n.b.b.a(localb, this.dLb);
            i = 1;
          }
          int j = i;
          if ((k & 0x2) != 0)
          {
            n.b.b.b(localb, this.dLc);
            j = i | 0x2;
          }
          n.b.b.c(localb, j);
          onBuilt();
          return localb;
        }
        
        private a e(am.f paramf, int paramInt, Object paramObject)
        {
          return (a)super.setRepeatedField(paramf, paramInt, paramObject);
        }
        
        private a e(am.j paramj)
        {
          return (a)super.clearOneof(paramj);
        }
        
        private a e(cb paramcb)
        {
          if ((paramcb instanceof n.b.b)) {
            return a((n.b.b)paramcb);
          }
          super.mergeFrom(paramcb);
          return this;
        }
        
        /* Error */
        private a e(i parami, at paramat)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 102	com/google/d/n$b$b:PARSER	Lcom/google/d/cs;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 108 3 0
          //   12: checkcast 14	com/google/d/n$b$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 91	com/google/d/n$b$b$a:a	(Lcom/google/d/n$b$b;)Lcom/google/d/n$b$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 112	com/google/d/bk:dST	Lcom/google/d/ce;
          //   33: checkcast 14	com/google/d/n$b$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 116	com/google/d/bk:aii	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 91	com/google/d/n$b$b$a:a	(Lcom/google/d/n$b$b;)Lcom/google/d/n$b$b$a;
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
          //   0	61	1	parami	i
          //   0	61	2	paramat	at
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/d/bk
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a h(am.f paramf)
        {
          return (a)super.clearField(paramf);
        }
        
        private a i(am.f paramf, Object paramObject)
        {
          return (a)super.setField(paramf, paramObject);
        }
        
        private a i(dn paramdn)
        {
          return (a)super.setUnknownFields(paramdn);
        }
        
        private a j(am.f paramf, Object paramObject)
        {
          return (a)super.addRepeatedField(paramf, paramObject);
        }
        
        private a j(dn paramdn)
        {
          return (a)super.mergeUnknownFields(paramdn);
        }
        
        private a kM(int paramInt)
        {
          this.bitField0_ |= 0x1;
          this.dLb = paramInt;
          onChanged();
          return this;
        }
        
        private a kN(int paramInt)
        {
          this.bitField0_ |= 0x2;
          this.dLc = paramInt;
          onChanged();
          return this;
        }
        
        public final a a(n.b.b paramb)
        {
          if (paramb == n.b.b.acO()) {
            return this;
          }
          if (paramb.acr()) {
            kM(paramb.dLb);
          }
          if (paramb.hasEnd()) {
            kN(paramb.dLc);
          }
          j(paramb.unknownFields);
          onChanged();
          return this;
        }
        
        public final am.a getDescriptorForType()
        {
          return n.abh();
        }
        
        protected final bg.e internalGetFieldAccessorTable()
        {
          return n.abi().b(n.b.b.class, a.class);
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
  }
  
  public static final class c
    extends bg.d<c>
    implements t
  {
    @Deprecated
    public static final cs<c> PARSER = new c() {};
    private static final c dLo = new c();
    private int bitField0_;
    boolean dLl;
    boolean dLm;
    private List<n.s> dLn;
    private byte memoizedIsInitialized = -1;
    
    private c()
    {
      this.dLn = Collections.emptyList();
    }
    
    private c(bg.c<c, ?> paramc)
    {
      super();
    }
    
    private c(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 16: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.dLl = parami.aai();
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              k = n;
              if ((k & 0x4) != 0) {
                this.dLn = Collections.unmodifiableList(this.dLn);
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.dLm = parami.aai();
            break;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
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
              this.dLn = new ArrayList();
              j = i | 0x4;
            }
            n = j;
            i1 = j;
            k = j;
            this.dLn.add(parami.a(n.s.PARSER, paramat));
            i = j;
          }
          break;
          if ((i & 0x4) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static c acW()
    {
      return dLo;
    }
    
    public static a b(c paramc)
    {
      return dLo.acV().d(paramc);
    }
    
    public final boolean acS()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final a acV()
    {
      if (this == dLo) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (acS() != paramObject.acS()) {
          return false;
        }
        if ((acS()) && (this.dLl != paramObject.dLl)) {
          return false;
        }
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<c> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int k = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (i = k.kn(2) + 0;; i = 0)
      {
        int j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.kn(3);
        }
        i = j;
        j = k;
        while (j < this.dLn.size())
        {
          k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        i = aie() + i + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abx().hashCode() + 779;
      int i = j;
      if (acS()) {
        i = (j * 37 + 2) * 53 + bj.hashBoolean(this.dLl);
      }
      j = i;
      if (acT()) {
        j = (i * 37 + 3) * 53 + bj.hashBoolean(this.dLm);
      }
      i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.aby().b(c.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new c();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.I(2, this.dLl);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.I(3, this.dLm);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.c, a>
      implements t
    {
      private int bitField0_;
      private boolean dLl;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a acX()
      {
        super.adc();
        this.dLl = false;
        this.bitField0_ &= 0xFFFFFFFE;
        this.dLm = false;
        this.bitField0_ &= 0xFFFFFFFD;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.c acY()
      {
        n.c localc = acZ();
        if (!localc.isInitialized()) {
          throw newUninitializedMessageException(localc);
        }
        return localc;
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x4) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x4;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a ca(boolean paramBoolean)
      {
        this.bitField0_ |= 0x1;
        this.dLl = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cb(boolean paramBoolean)
      {
        this.bitField0_ |= 0x2;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private a f(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a f(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a f(cb paramcb)
      {
        if ((paramcb instanceof n.c)) {
          return d((n.c)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a f(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 132	com/google/d/n$c:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 138 3 0
        //   12: checkcast 9	com/google/d/n$c
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 121	com/google/d/n$c$a:d	(Lcom/google/d/n$c;)Lcom/google/d/n$c$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 142	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$c
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 146	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 121	com/google/d/n$c$a:d	(Lcom/google/d/n$c;)Lcom/google/d/n$c$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a i(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      private a k(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a k(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a l(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      private a l(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      public final n.c acZ()
      {
        int i = 0;
        n.c localc = new n.c(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0)
        {
          n.c.a(localc, this.dLl);
          i = 1;
        }
        int j = i;
        if ((k & 0x2) != 0)
        {
          n.c.b(localc, this.dLm);
          j = i | 0x2;
        }
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x4) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFFB;
          }
          n.c.a(localc, this.dLn);
        }
        for (;;)
        {
          n.c.a(localc, j);
          onBuilt();
          return localc;
          n.c.a(localc, this.dLp.build());
        }
      }
      
      public final a d(n.c paramc)
      {
        da localda = null;
        if (paramc == n.c.acW()) {
          return this;
        }
        if (paramc.acS()) {
          ca(paramc.dLl);
        }
        if (paramc.acT()) {
          cb(paramc.dLm);
        }
        if (this.dLp == null) {
          if (!n.c.c(paramc).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label117;
            }
            this.dLn = n.c.c(paramc);
            this.bitField0_ &= 0xFFFFFFFB;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramc);
          l(paramc.unknownFields);
          onChanged();
          return this;
          label117:
          ada();
          this.dLn.addAll(n.c.c(paramc));
          break;
          if (!n.c.c(paramc).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.c.c(paramc);
              this.bitField0_ &= 0xFFFFFFFB;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.c.c(paramc));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abx();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.aby().b(n.c.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class d
    extends bg
    implements u
  {
    @Deprecated
    public static final cs<d> PARSER = new c() {};
    private static final d dLs = new d();
    private int bitField0_;
    int dLq;
    private n.e dLr;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private d()
    {
      this.name_ = "";
    }
    
    private d(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private d(i parami, at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 34	com/google/d/n$d:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 61	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 62	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 68	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +227 -> 251
      //   27: aload_1
      //   28: invokevirtual 74	com/google/d/i:aac	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+239->274, 0:+245->280, 10:+59->94, 16:+108->143, 26:+146->181
      //   77: aload_1
      //   78: aload 6
      //   80: aload_2
      //   81: iload 4
      //   83: invokevirtual 78	com/google/d/n$d:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   86: ifne +179 -> 265
      //   89: iconst_1
      //   90: istore_3
      //   91: goto +186 -> 277
      //   94: aload_1
      //   95: invokevirtual 82	com/google/d/i:aak	()Lcom/google/d/h;
      //   98: astore 5
      //   100: aload_0
      //   101: aload_0
      //   102: getfield 84	com/google/d/n$d:bitField0_	I
      //   105: iconst_1
      //   106: ior
      //   107: putfield 84	com/google/d/n$d:bitField0_	I
      //   110: aload_0
      //   111: aload 5
      //   113: putfield 47	com/google/d/n$d:name_	Ljava/lang/Object;
      //   116: goto -93 -> 23
      //   119: astore_1
      //   120: aload_1
      //   121: aload_0
      //   122: putfield 88	com/google/d/bk:dST	Lcom/google/d/ce;
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: aload_0
      //   129: aload 6
      //   131: invokevirtual 94	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   134: putfield 98	com/google/d/n$d:unknownFields	Lcom/google/d/dn;
      //   137: aload_0
      //   138: invokevirtual 101	com/google/d/n$d:makeExtensionsImmutable	()V
      //   141: aload_1
      //   142: athrow
      //   143: aload_0
      //   144: aload_0
      //   145: getfield 84	com/google/d/n$d:bitField0_	I
      //   148: iconst_2
      //   149: ior
      //   150: putfield 84	com/google/d/n$d:bitField0_	I
      //   153: aload_0
      //   154: aload_1
      //   155: invokevirtual 104	com/google/d/i:aaf	()I
      //   158: putfield 106	com/google/d/n$d:dLq	I
      //   161: goto -138 -> 23
      //   164: astore_1
      //   165: new 57	com/google/d/bk
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 109	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 88	com/google/d/bk:dST	Lcom/google/d/ce;
      //   179: aload_1
      //   180: athrow
      //   181: aload_0
      //   182: getfield 84	com/google/d/n$d:bitField0_	I
      //   185: iconst_4
      //   186: iand
      //   187: ifeq +81 -> 268
      //   190: aload_0
      //   191: getfield 111	com/google/d/n$d:dLr	Lcom/google/d/n$e;
      //   194: invokevirtual 117	com/google/d/n$e:adm	()Lcom/google/d/n$e$a;
      //   197: astore 5
      //   199: aload_0
      //   200: aload_1
      //   201: getstatic 118	com/google/d/n$e:PARSER	Lcom/google/d/cs;
      //   204: aload_2
      //   205: invokevirtual 121	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
      //   208: checkcast 113	com/google/d/n$e
      //   211: putfield 111	com/google/d/n$d:dLr	Lcom/google/d/n$e;
      //   214: aload 5
      //   216: ifnull +22 -> 238
      //   219: aload 5
      //   221: aload_0
      //   222: getfield 111	com/google/d/n$d:dLr	Lcom/google/d/n$e;
      //   225: invokevirtual 126	com/google/d/n$e$a:d	(Lcom/google/d/n$e;)Lcom/google/d/n$e$a;
      //   228: pop
      //   229: aload_0
      //   230: aload 5
      //   232: invokevirtual 130	com/google/d/n$e$a:adq	()Lcom/google/d/n$e;
      //   235: putfield 111	com/google/d/n$d:dLr	Lcom/google/d/n$e;
      //   238: aload_0
      //   239: aload_0
      //   240: getfield 84	com/google/d/n$d:bitField0_	I
      //   243: iconst_4
      //   244: ior
      //   245: putfield 84	com/google/d/n$d:bitField0_	I
      //   248: goto -225 -> 23
      //   251: aload_0
      //   252: aload 6
      //   254: invokevirtual 94	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   257: putfield 98	com/google/d/n$d:unknownFields	Lcom/google/d/dn;
      //   260: aload_0
      //   261: invokevirtual 101	com/google/d/n$d:makeExtensionsImmutable	()V
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
      //   0	285	1	parami	i
      //   0	285	2	paramat	at
      //   22	260	3	i	int
      //   31	51	4	j	int
      //   98	172	5	localObject	Object
      //   19	234	6	locala	dn.a
      // Exception table:
      //   from	to	target	type
      //   27	33	119	com/google/d/bk
      //   76	89	119	com/google/d/bk
      //   94	116	119	com/google/d/bk
      //   143	161	119	com/google/d/bk
      //   181	199	119	com/google/d/bk
      //   199	214	119	com/google/d/bk
      //   219	238	119	com/google/d/bk
      //   238	248	119	com/google/d/bk
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
    
    public static a adg()
    {
      return dLs.adh();
    }
    
    private a adh()
    {
      if (this == dLs) {
        return new a((byte)0);
      }
      return new a((byte)0).b(this);
    }
    
    public static d adi()
    {
      return dLs;
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean ade()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final n.e adf()
    {
      if (this.dLr == null) {
        return n.e.adn();
      }
      return this.dLr;
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
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (ade() != paramObject.ade()) {
          return false;
        }
        if ((ade()) && (this.dLq != paramObject.dLq)) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!adf().equals(paramObject.adf()))) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<d> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = bg.computeStringSize(1, this.name_) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + k.cJ(2, this.dLq);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + k.c(3, adf());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abj().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (ade()) {
        j = (i * 37 + 2) * 53 + this.dLq;
      }
      i = j;
      if (abT()) {
        i = (j * 37 + 3) * 53 + adf().hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abk().b(d.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((abT()) && (!adf().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new d();
    }
    
    public final void writeTo(k paramk)
    {
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.cF(2, this.dLq);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.a(3, adf());
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements u
    {
      private int bitField0_;
      private df<n.e, n.e.a, v> dKZ;
      private int dLq;
      private n.e dLr;
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a a(n.e parame)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x4) != 0) && (this.dLr != null) && (this.dLr != n.e.adn()))
          {
            this.dLr = n.e.b(this.dLr).d(parame).adq();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x4;
          return this;
          this.dLr = parame;
          break;
          this.dKZ.c(parame);
        }
      }
      
      private df<n.e, n.e.a, v> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(adf(), getParentForChildren(), isClean());
          this.dLr = null;
        }
        return this.dKZ;
      }
      
      private n.e adf()
      {
        if (this.dKZ == null)
        {
          if (this.dLr == null) {
            return n.e.adn();
          }
          return this.dLr;
        }
        return (n.e)this.dKZ.ajm();
      }
      
      private a adj()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.dLq = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        if (this.dKZ == null) {
          this.dLr = null;
        }
        for (;;)
        {
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
          this.dKZ.ajp();
        }
      }
      
      private n.d adl()
      {
        int i = 0;
        n.d locald = new n.d(this, (byte)0);
        int j = this.bitField0_;
        if ((j & 0x1) != 0) {
          i = 1;
        }
        n.d.a(locald, this.name_);
        if ((j & 0x2) != 0)
        {
          n.d.a(locald, this.dLq);
          i |= 0x2;
        }
        for (;;)
        {
          if ((j & 0x4) != 0) {
            if (this.dKZ == null)
            {
              n.d.a(locald, this.dLr);
              i |= 0x4;
            }
          }
          for (;;)
          {
            n.d.b(locald, i);
            onBuilt();
            return locald;
            n.d.a(locald, (n.e)this.dKZ.ajn());
            break;
          }
        }
      }
      
      private a g(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a g(cb paramcb)
      {
        if ((paramcb instanceof n.d)) {
          return b((n.d)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a g(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 151	com/google/d/n$d:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 157 3 0
        //   12: checkcast 9	com/google/d/n$d
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 140	com/google/d/n$d$a:b	(Lcom/google/d/n$d;)Lcom/google/d/n$d$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 161	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$d
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 165	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 140	com/google/d/n$d$a:b	(Lcom/google/d/n$d;)Lcom/google/d/n$d$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a h(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a k(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      private a m(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          acn();
        }
      }
      
      private a n(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a o(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a p(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      public final n.d adk()
      {
        n.d locald = adl();
        if (!locald.isInitialized()) {
          throw newUninitializedMessageException(locald);
        }
        return locald;
      }
      
      public final a b(n.d paramd)
      {
        if (paramd == n.d.adi()) {
          return this;
        }
        if (paramd.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.d.a(paramd);
          onChanged();
        }
        if (paramd.ade()) {
          kO(paramd.dLq);
        }
        if (paramd.abT()) {
          a(paramd.adf());
        }
        n(paramd.unknownFields);
        onChanged();
        return this;
      }
      
      public final a dY(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramString;
        onChanged();
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abj();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abk().b(n.d.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        if ((this.bitField0_ & 0x4) != 0) {}
        for (int i = 1; (i != 0) && (!adf().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
      
      public final a kO(int paramInt)
      {
        this.bitField0_ |= 0x2;
        this.dLq = paramInt;
        onChanged();
        return this;
      }
    }
  }
  
  public static final class e
    extends bg.d<e>
    implements v
  {
    @Deprecated
    public static final cs<e> PARSER = new c() {};
    private static final e dLt = new e();
    private int bitField0_;
    boolean dLm;
    private List<n.s> dLn;
    private byte memoizedIsInitialized = -1;
    
    private e()
    {
      this.dLn = Collections.emptyList();
    }
    
    private e(bg.c<e, ?> paramc)
    {
      super();
    }
    
    private e(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.dLm = parami.aai();
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally {}
            if ((k & 0x2) != 0) {
              this.dLn = Collections.unmodifiableList(this.dLn);
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
            throw parami;
            int j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.dLn = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            k = j;
            this.dLn.add(parami.a(n.s.PARSER, paramat));
            i = j;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
          }
          if ((i & 0x2) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static e adn()
    {
      return dLt;
    }
    
    public static a b(e parame)
    {
      return dLt.adm().d(parame);
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final a adm()
    {
      if (this == dLt) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<e> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int j = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {
        i = k.kn(1) + 0;
      }
      for (;;)
      {
        if (j < this.dLn.size())
        {
          int k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          i = aie() + i + this.unknownFields.getSerializedSize();
          this.memoizedSize = i;
          return i;
          i = 0;
        }
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abz().hashCode() + 779;
      int i = j;
      if (acT()) {
        i = (j * 37 + 1) * 53 + bj.hashBoolean(this.dLm);
      }
      j = i;
      if (acU() > 0) {
        j = (i * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(j, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abA().b(e.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new e();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.I(1, this.dLm);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.e, a>
      implements v
    {
      private int bitField0_;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x2) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x2;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a ado()
      {
        super.adc();
        this.dLm = false;
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFD;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.e adp()
      {
        n.e locale = adq();
        if (!locale.isInitialized()) {
          throw newUninitializedMessageException(locale);
        }
        return locale;
      }
      
      private a cc(boolean paramBoolean)
      {
        this.bitField0_ |= 0x1;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private a h(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a h(cb paramcb)
      {
        if ((paramcb instanceof n.e)) {
          return d((n.e)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a h(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 123	com/google/d/n$e:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 129 3 0
        //   12: checkcast 9	com/google/d/n$e
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 112	com/google/d/n$e$a:d	(Lcom/google/d/n$e;)Lcom/google/d/n$e$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 133	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$e
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 137	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 112	com/google/d/n$e$a:d	(Lcom/google/d/n$e;)Lcom/google/d/n$e$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a i(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a l(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a o(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a p(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a q(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a r(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      public final n.e adq()
      {
        int i = 0;
        n.e locale = new n.e(this, (byte)0);
        if ((this.bitField0_ & 0x1) != 0)
        {
          n.e.a(locale, this.dLm);
          i = 1;
        }
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x2) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFFD;
          }
          n.e.a(locale, this.dLn);
        }
        for (;;)
        {
          n.e.a(locale, i);
          onBuilt();
          return locale;
          n.e.a(locale, this.dLp.build());
        }
      }
      
      public final a d(n.e parame)
      {
        da localda = null;
        if (parame == n.e.adn()) {
          return this;
        }
        if (parame.acT()) {
          cc(parame.dLm);
        }
        if (this.dLp == null) {
          if (!n.e.c(parame).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label101;
            }
            this.dLn = n.e.c(parame);
            this.bitField0_ &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          a(parame);
          p(parame.unknownFields);
          onChanged();
          return this;
          label101:
          ada();
          this.dLn.addAll(n.e.c(parame));
          break;
          if (!n.e.c(parame).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.e.c(parame);
              this.bitField0_ &= 0xFFFFFFFD;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.e.c(parame));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abz();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abA().b(n.e.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class f
    extends bg.d<f>
    implements w
  {
    @Deprecated
    public static final cs<f> PARSER = new c() {};
    private static final f dLu = new f();
    private List<n.s> dLn;
    private byte memoizedIsInitialized = -1;
    
    private f()
    {
      this.dLn = Collections.emptyList();
    }
    
    private f(bg.c<f, ?> paramc)
    {
      super();
    }
    
    private f(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
          j = parami.aac();
          switch (j)
          {
          }
        }
        catch (bk parami)
        {
          try
          {
            int j;
            parami.dST = this;
            throw parami;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.dLn = Collections.unmodifiableList(this.dLn);
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          throw parami;
          if ((i & 0x1) == 0) {
            break label237;
          }
          this.dLn = Collections.unmodifiableList(this.dLn);
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        catch (IOException parami)
        {
          k = i1;
          parami = new bk(parami);
          k = i1;
          parami.dST = this;
          k = i1;
          throw parami;
        }
        finally
        {
          for (;;) {}
          m = 1;
        }
        n = i;
        i1 = i;
        k = i;
        if (!parseUnknownField(parami, locala, paramat, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dLn = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.dLn.add(parami.a(n.s.PARSER, paramat));
          i = j;
        }
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static f ads()
    {
      return dLu;
    }
    
    public static a b(f paramf)
    {
      return dLu.adr().d(paramf);
    }
    
    public final a adr()
    {
      if (this == dLu) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<f> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.dLn.size())
      {
        j += k.c(999, (ce)this.dLn.get(i));
        i += 1;
      }
      i = aie() + j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.aaZ().hashCode() + 779;
      int i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.aba().b(f.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new f();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.f, a>
      implements w
    {
      private int bitField0_;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x1) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x1;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a adt()
      {
        super.adc();
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFE;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.f adu()
      {
        n.f localf = adv();
        if (!localf.isInitialized()) {
          throw newUninitializedMessageException(localf);
        }
        return localf;
      }
      
      private a i(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a i(cb paramcb)
      {
        if ((paramcb instanceof n.f)) {
          return d((n.f)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a i(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 114	com/google/d/n$f:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 120 3 0
        //   12: checkcast 9	com/google/d/n$f
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 103	com/google/d/n$f$a:d	(Lcom/google/d/n$f;)Lcom/google/d/n$f$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 124	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$f
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 128	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 103	com/google/d/n$f$a:d	(Lcom/google/d/n$f;)Lcom/google/d/n$f$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a j(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a m(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a q(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a r(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a s(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a t(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      public final n.f adv()
      {
        n.f localf = new n.f(this, (byte)0);
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x1) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFFE;
          }
          n.f.a(localf, this.dLn);
        }
        for (;;)
        {
          onBuilt();
          return localf;
          n.f.a(localf, this.dLp.build());
        }
      }
      
      public final a d(n.f paramf)
      {
        da localda = null;
        if (paramf == n.f.ads()) {
          return this;
        }
        if (this.dLp == null) {
          if (!n.f.c(paramf).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label85;
            }
            this.dLn = n.f.c(paramf);
            this.bitField0_ &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramf);
          r(paramf.unknownFields);
          onChanged();
          return this;
          label85:
          ada();
          this.dLn.addAll(n.f.c(paramf));
          break;
          if (!n.f.c(paramf).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.f.c(paramf);
              this.bitField0_ &= 0xFFFFFFFE;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.f.c(paramf));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.aaZ();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.aba().b(n.f.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class g
    extends bg
    implements x
  {
    @Deprecated
    public static final cs<g> PARSER = new c() {};
    private static final g dLC = new g();
    private int bitField0_;
    private volatile Object dLA;
    private n.h dLB;
    int dLq;
    private int dLv;
    private volatile Object dLw;
    private volatile Object dLx;
    private volatile Object dLy;
    int dLz;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    private int type_;
    
    private g()
    {
      this.name_ = "";
      this.dLv = 1;
      this.type_ = 1;
      this.dLw = "";
      this.dLx = "";
      this.dLy = "";
      this.dLA = "";
    }
    
    private g(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private g(i parami, at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 48	com/google/d/n$g:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 87	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 88	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 94	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +506 -> 530
      //   27: aload_1
      //   28: invokevirtual 100	com/google/d/i:aac	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+518->553, 0:+524->559, 10:+115->150, 18:+164->199, 24:+207->242, 32:+228->263, 40:+273->308, 50:+319->354, 58:+345->380, 66:+371->406, 72:+445->480, 82:+468->503
      //   133: aload_1
      //   134: aload 6
      //   136: aload_2
      //   137: iload 4
      //   139: invokevirtual 104	com/google/d/n$g:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   142: ifne +402 -> 544
      //   145: iconst_1
      //   146: istore_3
      //   147: goto +409 -> 556
      //   150: aload_1
      //   151: invokevirtual 108	com/google/d/i:aak	()Lcom/google/d/h;
      //   154: astore 5
      //   156: aload_0
      //   157: aload_0
      //   158: getfield 110	com/google/d/n$g:bitField0_	I
      //   161: iconst_1
      //   162: ior
      //   163: putfield 110	com/google/d/n$g:bitField0_	I
      //   166: aload_0
      //   167: aload 5
      //   169: putfield 61	com/google/d/n$g:name_	Ljava/lang/Object;
      //   172: goto -149 -> 23
      //   175: astore_1
      //   176: aload_1
      //   177: aload_0
      //   178: putfield 114	com/google/d/bk:dST	Lcom/google/d/ce;
      //   181: aload_1
      //   182: athrow
      //   183: astore_1
      //   184: aload_0
      //   185: aload 6
      //   187: invokevirtual 120	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   190: putfield 124	com/google/d/n$g:unknownFields	Lcom/google/d/dn;
      //   193: aload_0
      //   194: invokevirtual 127	com/google/d/n$g:makeExtensionsImmutable	()V
      //   197: aload_1
      //   198: athrow
      //   199: aload_1
      //   200: invokevirtual 108	com/google/d/i:aak	()Lcom/google/d/h;
      //   203: astore 5
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 110	com/google/d/n$g:bitField0_	I
      //   210: bipush 32
      //   212: ior
      //   213: putfield 110	com/google/d/n$g:bitField0_	I
      //   216: aload_0
      //   217: aload 5
      //   219: putfield 69	com/google/d/n$g:dLx	Ljava/lang/Object;
      //   222: goto -199 -> 23
      //   225: astore_1
      //   226: new 83	com/google/d/bk
      //   229: dup
      //   230: aload_1
      //   231: invokespecial 130	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   234: astore_1
      //   235: aload_1
      //   236: aload_0
      //   237: putfield 114	com/google/d/bk:dST	Lcom/google/d/ce;
      //   240: aload_1
      //   241: athrow
      //   242: aload_0
      //   243: aload_0
      //   244: getfield 110	com/google/d/n$g:bitField0_	I
      //   247: iconst_2
      //   248: ior
      //   249: putfield 110	com/google/d/n$g:bitField0_	I
      //   252: aload_0
      //   253: aload_1
      //   254: invokevirtual 133	com/google/d/i:aaf	()I
      //   257: putfield 135	com/google/d/n$g:dLq	I
      //   260: goto -237 -> 23
      //   263: aload_1
      //   264: invokevirtual 138	com/google/d/i:aam	()I
      //   267: istore 4
      //   269: iload 4
      //   271: invokestatic 142	com/google/d/n$g$b:kR	(I)Lcom/google/d/n$g$b;
      //   274: ifnonnull +15 -> 289
      //   277: aload 6
      //   279: iconst_4
      //   280: iload 4
      //   282: invokevirtual 146	com/google/d/dn$a:cR	(II)Lcom/google/d/dn$a;
      //   285: pop
      //   286: goto -263 -> 23
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 110	com/google/d/n$g:bitField0_	I
      //   294: iconst_4
      //   295: ior
      //   296: putfield 110	com/google/d/n$g:bitField0_	I
      //   299: aload_0
      //   300: iload 4
      //   302: putfield 63	com/google/d/n$g:dLv	I
      //   305: goto -282 -> 23
      //   308: aload_1
      //   309: invokevirtual 138	com/google/d/i:aam	()I
      //   312: istore 4
      //   314: iload 4
      //   316: invokestatic 150	com/google/d/n$g$c:kS	(I)Lcom/google/d/n$g$c;
      //   319: ifnonnull +15 -> 334
      //   322: aload 6
      //   324: iconst_5
      //   325: iload 4
      //   327: invokevirtual 146	com/google/d/dn$a:cR	(II)Lcom/google/d/dn$a;
      //   330: pop
      //   331: goto -308 -> 23
      //   334: aload_0
      //   335: aload_0
      //   336: getfield 110	com/google/d/n$g:bitField0_	I
      //   339: bipush 8
      //   341: ior
      //   342: putfield 110	com/google/d/n$g:bitField0_	I
      //   345: aload_0
      //   346: iload 4
      //   348: putfield 65	com/google/d/n$g:type_	I
      //   351: goto -328 -> 23
      //   354: aload_1
      //   355: invokevirtual 108	com/google/d/i:aak	()Lcom/google/d/h;
      //   358: astore 5
      //   360: aload_0
      //   361: aload_0
      //   362: getfield 110	com/google/d/n$g:bitField0_	I
      //   365: bipush 16
      //   367: ior
      //   368: putfield 110	com/google/d/n$g:bitField0_	I
      //   371: aload_0
      //   372: aload 5
      //   374: putfield 67	com/google/d/n$g:dLw	Ljava/lang/Object;
      //   377: goto -354 -> 23
      //   380: aload_1
      //   381: invokevirtual 108	com/google/d/i:aak	()Lcom/google/d/h;
      //   384: astore 5
      //   386: aload_0
      //   387: aload_0
      //   388: getfield 110	com/google/d/n$g:bitField0_	I
      //   391: bipush 64
      //   393: ior
      //   394: putfield 110	com/google/d/n$g:bitField0_	I
      //   397: aload_0
      //   398: aload 5
      //   400: putfield 71	com/google/d/n$g:dLy	Ljava/lang/Object;
      //   403: goto -380 -> 23
      //   406: aload_0
      //   407: getfield 110	com/google/d/n$g:bitField0_	I
      //   410: sipush 512
      //   413: iand
      //   414: ifeq +133 -> 547
      //   417: aload_0
      //   418: getfield 152	com/google/d/n$g:dLB	Lcom/google/d/n$h;
      //   421: invokevirtual 158	com/google/d/n$h:adU	()Lcom/google/d/n$h$a;
      //   424: astore 5
      //   426: aload_0
      //   427: aload_1
      //   428: getstatic 159	com/google/d/n$h:PARSER	Lcom/google/d/cs;
      //   431: aload_2
      //   432: invokevirtual 162	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
      //   435: checkcast 154	com/google/d/n$h
      //   438: putfield 152	com/google/d/n$g:dLB	Lcom/google/d/n$h;
      //   441: aload 5
      //   443: ifnull +22 -> 465
      //   446: aload 5
      //   448: aload_0
      //   449: getfield 152	com/google/d/n$g:dLB	Lcom/google/d/n$h;
      //   452: invokevirtual 168	com/google/d/n$h$a:d	(Lcom/google/d/n$h;)Lcom/google/d/n$h$a;
      //   455: pop
      //   456: aload_0
      //   457: aload 5
      //   459: invokevirtual 172	com/google/d/n$h$a:adY	()Lcom/google/d/n$h;
      //   462: putfield 152	com/google/d/n$g:dLB	Lcom/google/d/n$h;
      //   465: aload_0
      //   466: aload_0
      //   467: getfield 110	com/google/d/n$g:bitField0_	I
      //   470: sipush 512
      //   473: ior
      //   474: putfield 110	com/google/d/n$g:bitField0_	I
      //   477: goto -454 -> 23
      //   480: aload_0
      //   481: aload_0
      //   482: getfield 110	com/google/d/n$g:bitField0_	I
      //   485: sipush 128
      //   488: ior
      //   489: putfield 110	com/google/d/n$g:bitField0_	I
      //   492: aload_0
      //   493: aload_1
      //   494: invokevirtual 133	com/google/d/i:aaf	()I
      //   497: putfield 174	com/google/d/n$g:dLz	I
      //   500: goto -477 -> 23
      //   503: aload_1
      //   504: invokevirtual 108	com/google/d/i:aak	()Lcom/google/d/h;
      //   507: astore 5
      //   509: aload_0
      //   510: aload_0
      //   511: getfield 110	com/google/d/n$g:bitField0_	I
      //   514: sipush 256
      //   517: ior
      //   518: putfield 110	com/google/d/n$g:bitField0_	I
      //   521: aload_0
      //   522: aload 5
      //   524: putfield 73	com/google/d/n$g:dLA	Ljava/lang/Object;
      //   527: goto -504 -> 23
      //   530: aload_0
      //   531: aload 6
      //   533: invokevirtual 120	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   536: putfield 124	com/google/d/n$g:unknownFields	Lcom/google/d/dn;
      //   539: aload_0
      //   540: invokevirtual 127	com/google/d/n$g:makeExtensionsImmutable	()V
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
      //   0	564	1	parami	i
      //   0	564	2	paramat	at
      //   22	539	3	i	int
      //   31	316	4	j	int
      //   154	395	5	localObject	Object
      //   19	513	6	locala	dn.a
      // Exception table:
      //   from	to	target	type
      //   27	33	175	com/google/d/bk
      //   132	145	175	com/google/d/bk
      //   150	172	175	com/google/d/bk
      //   199	222	175	com/google/d/bk
      //   242	260	175	com/google/d/bk
      //   263	286	175	com/google/d/bk
      //   289	305	175	com/google/d/bk
      //   308	331	175	com/google/d/bk
      //   334	351	175	com/google/d/bk
      //   354	377	175	com/google/d/bk
      //   380	403	175	com/google/d/bk
      //   406	426	175	com/google/d/bk
      //   426	441	175	com/google/d/bk
      //   446	465	175	com/google/d/bk
      //   465	477	175	com/google/d/bk
      //   480	500	175	com/google/d/bk
      //   503	527	175	com/google/d/bk
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
    
    private a adI()
    {
      if (this == dLC) {
        return new a((byte)0);
      }
      return new a((byte)0).f(this);
    }
    
    public static g adJ()
    {
      return dLC;
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x200) != 0;
    }
    
    public final boolean adA()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final boolean adB()
    {
      return (this.bitField0_ & 0x20) != 0;
    }
    
    public final String adC()
    {
      Object localObject = this.dLx;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dLx = str;
      }
      return str;
    }
    
    public final boolean adD()
    {
      return (this.bitField0_ & 0x40) != 0;
    }
    
    public final boolean adE()
    {
      return (this.bitField0_ & 0x80) != 0;
    }
    
    public final boolean adF()
    {
      return (this.bitField0_ & 0x100) != 0;
    }
    
    public final String adG()
    {
      Object localObject = this.dLA;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dLA = str;
      }
      return str;
    }
    
    public final n.h adH()
    {
      if (this.dLB == null) {
        return n.h.adV();
      }
      return this.dLB;
    }
    
    public final boolean ade()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean adw()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final b adx()
    {
      b localb2 = b.kR(this.dLv);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.dLD;
      }
      return localb1;
    }
    
    public final boolean ady()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final n.g.c adz()
    {
      n.g.c localc2 = n.g.c.kS(this.type_);
      n.g.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = n.g.c.dLJ;
      }
      return localc1;
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
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (ade() != paramObject.ade()) {
          return false;
        }
        if ((ade()) && (this.dLq != paramObject.dLq)) {
          return false;
        }
        if (adw() != paramObject.adw()) {
          return false;
        }
        if ((adw()) && (this.dLv != paramObject.dLv)) {
          return false;
        }
        if (ady() != paramObject.ady()) {
          return false;
        }
        if ((ady()) && (this.type_ != paramObject.type_)) {
          return false;
        }
        if (adA() != paramObject.adA()) {
          return false;
        }
        if ((adA()) && (!getTypeName().equals(paramObject.getTypeName()))) {
          return false;
        }
        if (adB() != paramObject.adB()) {
          return false;
        }
        if ((adB()) && (!adC().equals(paramObject.adC()))) {
          return false;
        }
        if (adD() != paramObject.adD()) {
          return false;
        }
        if ((adD()) && (!getDefaultValue().equals(paramObject.getDefaultValue()))) {
          return false;
        }
        if (adE() != paramObject.adE()) {
          return false;
        }
        if ((adE()) && (this.dLz != paramObject.dLz)) {
          return false;
        }
        if (adF() != paramObject.adF()) {
          return false;
        }
        if ((adF()) && (!adG().equals(paramObject.adG()))) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!adH().equals(paramObject.adH()))) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getDefaultValue()
    {
      Object localObject = this.dLy;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dLy = str;
      }
      return str;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<g> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = bg.computeStringSize(1, this.name_) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x20) != 0) {
        i = j + bg.computeStringSize(2, this.dLx);
      }
      j = i;
      if ((this.bitField0_ & 0x2) != 0) {
        j = i + k.cJ(3, this.dLq);
      }
      i = j;
      if ((this.bitField0_ & 0x4) != 0) {
        i = j + k.cM(4, this.dLv);
      }
      j = i;
      if ((this.bitField0_ & 0x8) != 0) {
        j = i + k.cM(5, this.type_);
      }
      i = j;
      if ((this.bitField0_ & 0x10) != 0) {
        i = j + bg.computeStringSize(6, this.dLw);
      }
      j = i;
      if ((this.bitField0_ & 0x40) != 0) {
        j = i + bg.computeStringSize(7, this.dLy);
      }
      i = j;
      if ((this.bitField0_ & 0x200) != 0) {
        i = j + k.c(8, adH());
      }
      j = i;
      if ((this.bitField0_ & 0x80) != 0) {
        j = i + k.cJ(9, this.dLz);
      }
      i = j;
      if ((this.bitField0_ & 0x100) != 0) {
        i = j + bg.computeStringSize(10, this.dLA);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final String getTypeName()
    {
      Object localObject = this.dLw;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dLw = str;
      }
      return str;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abb().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (ade()) {
        j = (i * 37 + 3) * 53 + this.dLq;
      }
      i = j;
      if (adw()) {
        i = (j * 37 + 4) * 53 + this.dLv;
      }
      j = i;
      if (ady()) {
        j = (i * 37 + 5) * 53 + this.type_;
      }
      i = j;
      if (adA()) {
        i = (j * 37 + 6) * 53 + getTypeName().hashCode();
      }
      j = i;
      if (adB()) {
        j = (i * 37 + 2) * 53 + adC().hashCode();
      }
      i = j;
      if (adD()) {
        i = (j * 37 + 7) * 53 + getDefaultValue().hashCode();
      }
      j = i;
      if (adE()) {
        j = (i * 37 + 9) * 53 + this.dLz;
      }
      i = j;
      if (adF()) {
        i = (j * 37 + 10) * 53 + adG().hashCode();
      }
      j = i;
      if (abT()) {
        j = (i * 37 + 8) * 53 + adH().hashCode();
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abc().b(g.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((abT()) && (!adH().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new g();
    }
    
    public final void writeTo(k paramk)
    {
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      if ((this.bitField0_ & 0x20) != 0) {
        bg.writeString(paramk, 2, this.dLx);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.cF(3, this.dLq);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.cF(4, this.dLv);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.cF(5, this.type_);
      }
      if ((this.bitField0_ & 0x10) != 0) {
        bg.writeString(paramk, 6, this.dLw);
      }
      if ((this.bitField0_ & 0x40) != 0) {
        bg.writeString(paramk, 7, this.dLy);
      }
      if ((this.bitField0_ & 0x200) != 0) {
        paramk.a(8, adH());
      }
      if ((this.bitField0_ & 0x80) != 0) {
        paramk.cF(9, this.dLz);
      }
      if ((this.bitField0_ & 0x100) != 0) {
        bg.writeString(paramk, 10, this.dLA);
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements x
    {
      private int bitField0_;
      private df<n.h, n.h.a, y> dKZ;
      private Object dLA = "";
      private n.h dLB;
      private int dLq;
      private int dLv = 1;
      private Object dLw = "";
      private Object dLx = "";
      private Object dLy = "";
      private int dLz;
      private Object name_ = "";
      private int type_ = 1;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a a(n.g.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.dLv = paramb.value;
        onChanged();
        return this;
      }
      
      private a a(n.g.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x8;
        this.type_ = paramc.value;
        onChanged();
        return this;
      }
      
      private a a(n.h paramh)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x200) != 0) && (this.dLB != null) && (this.dLB != n.h.adV()))
          {
            this.dLB = n.h.b(this.dLB).d(paramh).adY();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x200;
          return this;
          this.dLB = paramh;
          break;
          this.dKZ.c(paramh);
        }
      }
      
      private df<n.h, n.h.a, y> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(adH(), getParentForChildren(), isClean());
          this.dLB = null;
        }
        return this.dKZ;
      }
      
      private n.h adH()
      {
        if (this.dKZ == null)
        {
          if (this.dLB == null) {
            return n.h.adV();
          }
          return this.dLB;
        }
        return (n.h)this.dKZ.ajm();
      }
      
      private a adK()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.dLq = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        this.dLv = 1;
        this.bitField0_ &= 0xFFFFFFFB;
        this.type_ = 1;
        this.bitField0_ &= 0xFFFFFFF7;
        this.dLw = "";
        this.bitField0_ &= 0xFFFFFFEF;
        this.dLx = "";
        this.bitField0_ &= 0xFFFFFFDF;
        this.dLy = "";
        this.bitField0_ &= 0xFFFFFFBF;
        this.dLz = 0;
        this.bitField0_ &= 0xFFFFFF7F;
        this.dLA = "";
        this.bitField0_ &= 0xFFFFFEFF;
        if (this.dKZ == null) {
          this.dLB = null;
        }
        for (;;)
        {
          this.bitField0_ &= 0xFFFFFDFF;
          return this;
          this.dKZ.ajp();
        }
      }
      
      private n.g adL()
      {
        n.g localg = adM();
        if (!localg.isInitialized()) {
          throw newUninitializedMessageException(localg);
        }
        return localg;
      }
      
      private n.g adM()
      {
        int j = 0;
        n.g localg = new n.g(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        n.g.a(localg, this.name_);
        int i = j;
        if ((k & 0x2) != 0)
        {
          n.g.a(localg, this.dLq);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        n.g.b(localg, this.dLv);
        i = j;
        if ((k & 0x8) != 0) {
          i = j | 0x8;
        }
        n.g.c(localg, this.type_);
        j = i;
        if ((k & 0x10) != 0) {
          j = i | 0x10;
        }
        n.g.b(localg, this.dLw);
        i = j;
        if ((k & 0x20) != 0) {
          i = j | 0x20;
        }
        n.g.c(localg, this.dLx);
        j = i;
        if ((k & 0x40) != 0) {
          j = i | 0x40;
        }
        n.g.d(localg, this.dLy);
        i = j;
        if ((k & 0x80) != 0)
        {
          n.g.d(localg, this.dLz);
          i = j | 0x80;
        }
        if ((k & 0x100) != 0) {
          i |= 0x100;
        }
        for (;;)
        {
          n.g.e(localg, this.dLA);
          j = i;
          if ((k & 0x200) != 0)
          {
            if (this.dKZ != null) {
              break label273;
            }
            n.g.a(localg, this.dLB);
          }
          for (;;)
          {
            j = i | 0x200;
            n.g.e(localg, j);
            onBuilt();
            return localg;
            label273:
            n.g.a(localg, (n.h)this.dKZ.ajn());
          }
        }
      }
      
      private a j(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a j(cb paramcb)
      {
        if ((paramcb instanceof n.g)) {
          return f((n.g)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a j(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 212	com/google/d/n$g:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 218 3 0
        //   12: checkcast 9	com/google/d/n$g
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 201	com/google/d/n$g$a:f	(Lcom/google/d/n$g;)Lcom/google/d/n$g$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 222	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$g
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 226	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 201	com/google/d/n$g$a:f	(Lcom/google/d/n$g;)Lcom/google/d/n$g$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a k(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a kP(int paramInt)
      {
        this.bitField0_ |= 0x2;
        this.dLq = paramInt;
        onChanged();
        return this;
      }
      
      private a kQ(int paramInt)
      {
        this.bitField0_ |= 0x80;
        this.dLz = paramInt;
        onChanged();
        return this;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          acn();
        }
      }
      
      private a n(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      private a s(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a t(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a u(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a v(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      public final a f(n.g paramg)
      {
        if (paramg == n.g.adJ()) {
          return this;
        }
        if (paramg.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.g.a(paramg);
          onChanged();
        }
        if (paramg.ade()) {
          kP(paramg.dLq);
        }
        if (paramg.adw()) {
          a(paramg.adx());
        }
        if (paramg.ady()) {
          a(paramg.adz());
        }
        if (paramg.adA())
        {
          this.bitField0_ |= 0x10;
          this.dLw = n.g.b(paramg);
          onChanged();
        }
        if (paramg.adB())
        {
          this.bitField0_ |= 0x20;
          this.dLx = n.g.c(paramg);
          onChanged();
        }
        if (paramg.adD())
        {
          this.bitField0_ |= 0x40;
          this.dLy = n.g.d(paramg);
          onChanged();
        }
        if (paramg.adE()) {
          kQ(paramg.dLz);
        }
        if (paramg.adF())
        {
          this.bitField0_ |= 0x100;
          this.dLA = n.g.e(paramg);
          onChanged();
        }
        if (paramg.abT()) {
          a(paramg.adH());
        }
        t(paramg.unknownFields);
        onChanged();
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abb();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abc().b(n.g.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        if ((this.bitField0_ & 0x200) != 0) {}
        for (int i = 1; (i != 0) && (!adH().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
    
    public static enum b
      implements cw
    {
      private static final bj.d<b> dLG = new bj.d() {};
      private static final b[] dLH = values();
      final int value;
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b kR(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return dLD;
        case 2: 
          return dLE;
        }
        return dLF;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static final class h
    extends bg.d<h>
    implements y
  {
    @Deprecated
    public static final cs<h> PARSER = new c() {};
    private static final h dMi = new h();
    private int bitField0_;
    boolean dLm;
    private List<n.s> dLn;
    private int dMd;
    boolean dMe;
    private int dMf;
    boolean dMg;
    boolean dMh;
    private byte memoizedIsInitialized = -1;
    
    private h()
    {
      this.dMd = 0;
      this.dMf = 0;
      this.dLn = Collections.emptyList();
    }
    
    private h(bg.c<h, ?> paramc)
    {
      super();
    }
    
    private h(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              j = parami.aam();
              n = i;
              i1 = i;
              k = i;
              if (n.h.b.kT(j) == null)
              {
                n = i;
                i1 = i;
                k = i;
                locala.cR(1, j);
                break label26;
              }
              break;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally {}
            if ((k & 0x40) != 0) {
              this.dLn = Collections.unmodifiableList(this.dLn);
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
            throw parami;
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.dMd = j;
            break;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.dMe = parami.aai();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.dLm = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.dMg = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          int j = parami.aam();
          n = i;
          i1 = i;
          k = i;
          if (n.h.c.kU(j) == null)
          {
            n = i;
            i1 = i;
            k = i;
            locala.cR(6, j);
            break;
          }
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.dMf = j;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x20;
          n = i;
          i1 = i;
          k = i;
          this.dMh = parami.aai();
          break;
          j = i;
          if ((i & 0x40) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dLn = new ArrayList();
            j = i | 0x40;
          }
          n = j;
          i1 = j;
          k = j;
          this.dLn.add(parami.a(n.s.PARSER, paramat));
          i = j;
          break;
          if ((i & 0x40) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static h adV()
    {
      return dMi;
    }
    
    public static a b(h paramh)
    {
      return dMi.adU().d(paramh);
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final boolean adN()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final n.h.b adO()
    {
      n.h.b localb2 = n.h.b.kT(this.dMd);
      n.h.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = n.h.b.dMj;
      }
      return localb1;
    }
    
    public final boolean adP()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean adQ()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final n.h.c adR()
    {
      n.h.c localc2 = n.h.c.kU(this.dMf);
      n.h.c localc1 = localc2;
      if (localc2 == null) {
        localc1 = n.h.c.dMo;
      }
      return localc1;
    }
    
    public final boolean adS()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final boolean adT()
    {
      return (this.bitField0_ & 0x20) != 0;
    }
    
    public final a adU()
    {
      if (this == dMi) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (adN() != paramObject.adN()) {
          return false;
        }
        if ((adN()) && (this.dMd != paramObject.dMd)) {
          return false;
        }
        if (adP() != paramObject.adP()) {
          return false;
        }
        if ((adP()) && (this.dMe != paramObject.dMe)) {
          return false;
        }
        if (adQ() != paramObject.adQ()) {
          return false;
        }
        if ((adQ()) && (this.dMf != paramObject.dMf)) {
          return false;
        }
        if (adS() != paramObject.adS()) {
          return false;
        }
        if ((adS()) && (this.dMg != paramObject.dMg)) {
          return false;
        }
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (adT() != paramObject.adT()) {
          return false;
        }
        if ((adT()) && (this.dMh != paramObject.dMh)) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<h> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int k = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (int j = k.cM(1, this.dMd) + 0;; j = 0)
      {
        i = j;
        if ((this.bitField0_ & 0x2) != 0) {
          i = j + k.kn(2);
        }
        j = i;
        if ((this.bitField0_ & 0x10) != 0) {
          j = i + k.kn(3);
        }
        i = j;
        if ((this.bitField0_ & 0x8) != 0) {
          i = j + k.kn(5);
        }
        j = i;
        if ((this.bitField0_ & 0x4) != 0) {
          j = i + k.cM(6, this.dMf);
        }
        i = j;
        if ((this.bitField0_ & 0x20) != 0) {
          i = j + k.kn(10);
        }
        j = k;
        while (j < this.dLn.size())
        {
          k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        i = aie() + i + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abt().hashCode() + 779;
      int i = j;
      if (adN()) {
        i = (j * 37 + 1) * 53 + this.dMd;
      }
      j = i;
      if (adP()) {
        j = (i * 37 + 2) * 53 + bj.hashBoolean(this.dMe);
      }
      i = j;
      if (adQ()) {
        i = (j * 37 + 6) * 53 + this.dMf;
      }
      j = i;
      if (adS()) {
        j = (i * 37 + 5) * 53 + bj.hashBoolean(this.dMg);
      }
      i = j;
      if (acT()) {
        i = (j * 37 + 3) * 53 + bj.hashBoolean(this.dLm);
      }
      j = i;
      if (adT()) {
        j = (i * 37 + 10) * 53 + bj.hashBoolean(this.dMh);
      }
      i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abu().b(h.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new h();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.cF(1, this.dMd);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.I(2, this.dMe);
      }
      if ((this.bitField0_ & 0x10) != 0) {
        paramk.I(3, this.dLm);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.I(5, this.dMg);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.cF(6, this.dMf);
      }
      if ((this.bitField0_ & 0x20) != 0) {
        paramk.I(10, this.dMh);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.h, a>
      implements y
    {
      private int bitField0_;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      private int dMd = 0;
      private boolean dMe;
      private int dMf = 0;
      private boolean dMg;
      private boolean dMh;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a a(n.h.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.dMd = paramb.value;
        onChanged();
        return this;
      }
      
      private a a(n.h.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x4;
        this.dMf = paramc.value;
        onChanged();
        return this;
      }
      
      private a adW()
      {
        super.adc();
        this.dMd = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.dMe = false;
        this.bitField0_ &= 0xFFFFFFFD;
        this.dMf = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        this.dMg = false;
        this.bitField0_ &= 0xFFFFFFF7;
        this.dLm = false;
        this.bitField0_ &= 0xFFFFFFEF;
        this.dMh = false;
        this.bitField0_ &= 0xFFFFFFDF;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFBF;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.h adX()
      {
        n.h localh = adY();
        if (!localh.isInitialized()) {
          throw newUninitializedMessageException(localh);
        }
        return localh;
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x40) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x40;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a cd(boolean paramBoolean)
      {
        this.bitField0_ |= 0x2;
        this.dMe = paramBoolean;
        onChanged();
        return this;
      }
      
      private a ce(boolean paramBoolean)
      {
        this.bitField0_ |= 0x8;
        this.dMg = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cf(boolean paramBoolean)
      {
        this.bitField0_ |= 0x10;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cg(boolean paramBoolean)
      {
        this.bitField0_ |= 0x20;
        this.dMh = paramBoolean;
        onChanged();
        return this;
      }
      
      private a k(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a k(cb paramcb)
      {
        if ((paramcb instanceof n.h)) {
          return d((n.h)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a k(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 154	com/google/d/n$h:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 160 3 0
        //   12: checkcast 9	com/google/d/n$h
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 143	com/google/d/n$h$a:d	(Lcom/google/d/n$h;)Lcom/google/d/n$h$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 164	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$h
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 168	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 143	com/google/d/n$h$a:d	(Lcom/google/d/n$h;)Lcom/google/d/n$h$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a l(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a o(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      private a u(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a v(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a w(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a x(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      public final n.h adY()
      {
        int j = 0;
        n.h localh = new n.h(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        n.h.a(localh, this.dMd);
        int i = j;
        if ((k & 0x2) != 0)
        {
          n.h.a(localh, this.dMe);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        n.h.b(localh, this.dMf);
        i = j;
        if ((k & 0x8) != 0)
        {
          n.h.b(localh, this.dMg);
          i = j | 0x8;
        }
        j = i;
        if ((k & 0x10) != 0)
        {
          n.h.c(localh, this.dLm);
          j = i | 0x10;
        }
        i = j;
        if ((k & 0x20) != 0)
        {
          n.h.d(localh, this.dMh);
          i = j | 0x20;
        }
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x40) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFBF;
          }
          n.h.a(localh, this.dLn);
        }
        for (;;)
        {
          n.h.c(localh, i);
          onBuilt();
          return localh;
          n.h.a(localh, this.dLp.build());
        }
      }
      
      public final a d(n.h paramh)
      {
        da localda = null;
        if (paramh == n.h.adV()) {
          return this;
        }
        if (paramh.adN()) {
          a(paramh.adO());
        }
        if (paramh.adP()) {
          cd(paramh.dMe);
        }
        if (paramh.adQ()) {
          a(paramh.adR());
        }
        if (paramh.adS()) {
          ce(paramh.dMg);
        }
        if (paramh.acT()) {
          cf(paramh.dLm);
        }
        if (paramh.adT()) {
          cg(paramh.dMh);
        }
        if (this.dLp == null) {
          if (!n.h.c(paramh).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label181;
            }
            this.dLn = n.h.c(paramh);
            this.bitField0_ &= 0xFFFFFFBF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramh);
          v(paramh.unknownFields);
          onChanged();
          return this;
          label181:
          ada();
          this.dLn.addAll(n.h.c(paramh));
          break;
          if (!n.h.c(paramh).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.h.c(paramh);
              this.bitField0_ &= 0xFFFFFFBF;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.h.c(paramh));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abt();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abu().b(n.h.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class i
    extends bg
    implements z
  {
    @Deprecated
    public static final cs<i> PARSER = new c() {};
    private static final i dMC = new i();
    private int bitField0_;
    private List<n.g> dKK;
    private List<n.b> dKM;
    private n.r dMA;
    private volatile Object dMB;
    private volatile Object dMt;
    bp dMu;
    bj.g dMv;
    private bj.g dMw;
    private List<n.a> dMx;
    private List<n.p> dMy;
    private n.j dMz;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private i()
    {
      this.name_ = "";
      this.dMt = "";
      this.dMu = bo.dTm;
      this.dMv = emptyIntList();
      this.dMw = emptyIntList();
      this.dMx = Collections.emptyList();
      this.dKM = Collections.emptyList();
      this.dMy = Collections.emptyList();
      this.dKK = Collections.emptyList();
      this.dMB = "";
    }
    
    private i(bg.a<?> parama)
    {
      super();
    }
    
    private i(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            n = parami.aac();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (parseUnknownField(parami, locala, paramat, n)) {
                break label1725;
              }
              j = 1;
              break label1747;
              k = i;
              m = i;
              j = i;
              localObject = parami.aak();
              k = i;
              m = i;
              j = i;
              this.bitField0_ |= 0x1;
              k = i;
              m = i;
              j = i;
              this.name_ = localObject;
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              j = k;
              if ((j & 0x4) != 0) {
                this.dMu = this.dMu.aiv();
              }
              if ((j & 0x20) != 0) {
                this.dMx = Collections.unmodifiableList(this.dMx);
              }
              if ((j & 0x40) != 0) {
                this.dKM = Collections.unmodifiableList(this.dKM);
              }
              if ((j & 0x80) != 0) {
                this.dMy = Collections.unmodifiableList(this.dMy);
              }
              if ((j & 0x100) != 0) {
                this.dKK = Collections.unmodifiableList(this.dKK);
              }
              if ((j & 0x8) != 0) {
                this.dMv.ZP();
              }
              if ((j & 0x10) != 0) {
                this.dMw.ZP();
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            k = i;
            m = i;
            j = i;
            localObject = parami.aak();
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x2;
            k = i;
            m = i;
            j = i;
            this.dMt = localObject;
            break;
          }
          catch (IOException parami)
          {
            j = m;
            parami = new bk(parami);
            j = m;
            parami.dST = this;
            j = m;
            throw parami;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            localObject = parami.aak();
            n = i;
            if ((i & 0x4) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dMu = new bo();
              n = i | 0x4;
            }
            k = n;
            m = n;
            j = n;
            this.dMu.d((h)localObject);
            i = n;
          }
          break;
          int n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dMx = new ArrayList();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.dMx.add(parami.a(n.a.PARSER, paramat));
          i = n;
          break;
          n = i;
          if ((i & 0x40) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dKM = new ArrayList();
            n = i | 0x40;
          }
          k = n;
          m = n;
          j = n;
          this.dKM.add(parami.a(n.b.PARSER, paramat));
          i = n;
          break;
          n = i;
          if ((i & 0x80) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dMy = new ArrayList();
            n = i | 0x80;
          }
          k = n;
          m = n;
          j = n;
          this.dMy.add(parami.a(n.p.PARSER, paramat));
          i = n;
          break;
          n = i;
          if ((i & 0x100) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.dKK = new ArrayList();
            n = i | 0x100;
          }
          k = n;
          m = n;
          j = n;
          this.dKK.add(parami.a(n.g.PARSER, paramat));
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          if ((this.bitField0_ & 0x4) != 0)
          {
            k = i;
            m = i;
            j = i;
          }
          for (Object localObject = this.dMz.afb();; localObject = null)
          {
            k = i;
            m = i;
            j = i;
            this.dMz = ((n.j)parami.a(n.j.PARSER, paramat));
            if (localObject != null)
            {
              k = i;
              m = i;
              j = i;
              ((n.j.a)localObject).n(this.dMz);
              k = i;
              m = i;
              j = i;
              this.dMz = ((n.j.a)localObject).aff();
            }
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x4;
            break;
            k = i;
            m = i;
            j = i;
            if ((this.bitField0_ & 0x8) != 0)
            {
              k = i;
              m = i;
              j = i;
            }
            for (localObject = this.dMA.agg();; localObject = null)
            {
              k = i;
              m = i;
              j = i;
              this.dMA = ((n.r)parami.a(n.r.PARSER, paramat));
              if (localObject != null)
              {
                k = i;
                m = i;
                j = i;
                ((n.r.a)localObject).d(this.dMA);
                k = i;
                m = i;
                j = i;
                this.dMA = ((n.r.a)localObject).agk();
              }
              k = i;
              m = i;
              j = i;
              this.bitField0_ |= 0x8;
              break;
              n = i;
              if ((i & 0x8) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.dMv = newIntList();
                n = i | 0x8;
              }
              k = n;
              m = n;
              j = n;
              this.dMv.lj(parami.aaf());
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              int i2 = parami.jO(parami.aar());
              n = i;
              if ((i & 0x8) == 0)
              {
                k = i;
                m = i;
                j = i;
                n = i;
                if (parami.aat() > 0)
                {
                  k = i;
                  m = i;
                  j = i;
                  this.dMv = newIntList();
                  n = i | 0x8;
                }
              }
              for (;;)
              {
                k = n;
                m = n;
                j = n;
                if (parami.aat() <= 0) {
                  break;
                }
                k = n;
                m = n;
                j = n;
                this.dMv.lj(parami.aaf());
              }
              k = n;
              m = n;
              j = n;
              parami.jP(i2);
              i = n;
              break;
              n = i;
              if ((i & 0x10) == 0)
              {
                k = i;
                m = i;
                j = i;
                this.dMw = newIntList();
                n = i | 0x10;
              }
              k = n;
              m = n;
              j = n;
              this.dMw.lj(parami.aaf());
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              i2 = parami.jO(parami.aar());
              n = i;
              if ((i & 0x10) == 0)
              {
                k = i;
                m = i;
                j = i;
                n = i;
                if (parami.aat() > 0)
                {
                  k = i;
                  m = i;
                  j = i;
                  this.dMw = newIntList();
                  n = i | 0x10;
                }
              }
              for (;;)
              {
                k = n;
                m = n;
                j = n;
                if (parami.aat() <= 0) {
                  break;
                }
                k = n;
                m = n;
                j = n;
                this.dMw.lj(parami.aaf());
              }
              k = n;
              m = n;
              j = n;
              parami.jP(i2);
              i = n;
              break;
              k = i;
              m = i;
              j = i;
              localObject = parami.aak();
              k = i;
              m = i;
              j = i;
              this.bitField0_ |= 0x10;
              k = i;
              m = i;
              j = i;
              this.dMB = localObject;
              break;
              if ((i & 0x4) != 0) {
                this.dMu = this.dMu.aiv();
              }
              if ((i & 0x20) != 0) {
                this.dMx = Collections.unmodifiableList(this.dMx);
              }
              if ((i & 0x40) != 0) {
                this.dKM = Collections.unmodifiableList(this.dKM);
              }
              if ((i & 0x80) != 0) {
                this.dMy = Collections.unmodifiableList(this.dMy);
              }
              if ((i & 0x100) != 0) {
                this.dKK = Collections.unmodifiableList(this.dKK);
              }
              if ((i & 0x8) != 0) {
                this.dMv.ZP();
              }
              if ((i & 0x10) != 0) {
                this.dMw.ZP();
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
              return;
              label1725:
              j = i1;
              break label1747;
            }
          }
        }
        label1747:
        i1 = j;
        continue;
        i1 = 1;
      }
    }
    
    public static i E(byte[] paramArrayOfByte)
    {
      return (i)PARSER.parseFrom(paramArrayOfByte);
    }
    
    public static a aej()
    {
      return dMC.aek();
    }
    
    private a aek()
    {
      if (this == dMC) {
        return new a((byte)0);
      }
      return new a((byte)0).k(this);
    }
    
    public static i ael()
    {
      return dMC;
    }
    
    public final int abO()
    {
      return this.dKK.size();
    }
    
    public final int abQ()
    {
      return this.dKM.size();
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean adZ()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final int aea()
    {
      return this.dMu.size();
    }
    
    public final int aeb()
    {
      return this.dMv.size();
    }
    
    public final int aec()
    {
      return this.dMx.size();
    }
    
    public final int aed()
    {
      return this.dMy.size();
    }
    
    public final n.j aee()
    {
      if (this.dMz == null) {
        return n.j.afc();
      }
      return this.dMz;
    }
    
    public final boolean aef()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final n.r aeg()
    {
      if (this.dMA == null) {
        return n.r.agh();
      }
      return this.dMA;
    }
    
    public final boolean aeh()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final String aei()
    {
      Object localObject = this.dMB;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMB = str;
      }
      return str;
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
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (adZ() != paramObject.adZ()) {
          return false;
        }
        if ((adZ()) && (!getPackage().equals(paramObject.getPackage()))) {
          return false;
        }
        if (!this.dMu.equals(paramObject.dMu)) {
          return false;
        }
        if (!this.dMv.equals(paramObject.dMv)) {
          return false;
        }
        if (!this.dMw.equals(paramObject.dMw)) {
          return false;
        }
        if (!this.dMx.equals(paramObject.dMx)) {
          return false;
        }
        if (!this.dKM.equals(paramObject.dKM)) {
          return false;
        }
        if (!this.dMy.equals(paramObject.dMy)) {
          return false;
        }
        if (!this.dKK.equals(paramObject.dKK)) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!aee().equals(paramObject.aee()))) {
          return false;
        }
        if (aef() != paramObject.aef()) {
          return false;
        }
        if ((aef()) && (!aeg().equals(paramObject.aeg()))) {
          return false;
        }
        if (aeh() != paramObject.aeh()) {
          return false;
        }
        if ((aeh()) && (!aei().equals(paramObject.aei()))) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final String getPackage()
    {
      Object localObject = this.dMt;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMt = str;
      }
      return str;
    }
    
    public final cs<i> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (i = bg.computeStringSize(1, this.name_) + 0;; i = 0)
      {
        int j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + bg.computeStringSize(2, this.dMt);
        }
        int k = 0;
        i = 0;
        while (k < this.dMu.size())
        {
          i += computeStringSizeNoTag(this.dMu.getRaw(k));
          k += 1;
        }
        int m = this.dMu.size();
        k = 0;
        i = j + i + m * 1;
        j = k;
        while (j < this.dMx.size())
        {
          i += k.c(4, (ce)this.dMx.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKM.size())
        {
          i += k.c(5, (ce)this.dKM.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dMy.size())
        {
          i += k.c(6, (ce)this.dMy.get(j));
          j += 1;
        }
        j = 0;
        while (j < this.dKK.size())
        {
          i += k.c(7, (ce)this.dKK.get(j));
          j += 1;
        }
        j = i;
        if ((this.bitField0_ & 0x4) != 0) {
          j = i + k.c(8, aee());
        }
        i = j;
        if ((this.bitField0_ & 0x8) != 0) {
          i = j + k.c(9, aeg());
        }
        k = 0;
        j = 0;
        while (k < this.dMv.size())
        {
          j += k.kp(this.dMv.getInt(k));
          k += 1;
        }
        int n = this.dMv.size();
        k = 0;
        m = 0;
        while (k < this.dMw.size())
        {
          m += k.kp(this.dMw.getInt(k));
          k += 1;
        }
        j = i + j + n * 1 + m + this.dMw.size() * 1;
        i = j;
        if ((this.bitField0_ & 0x10) != 0) {
          i = j + bg.computeStringSize(12, this.dMB);
        }
        i += this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.aaR().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (adZ()) {
        j = (i * 37 + 2) * 53 + getPackage().hashCode();
      }
      i = j;
      if (aea() > 0) {
        i = (j * 37 + 3) * 53 + this.dMu.hashCode();
      }
      j = i;
      if (aeb() > 0) {
        j = (i * 37 + 10) * 53 + this.dMv.hashCode();
      }
      i = j;
      if (this.dMw.size() > 0) {
        i = (j * 37 + 11) * 53 + this.dMw.hashCode();
      }
      j = i;
      if (aec() > 0) {
        j = (i * 37 + 4) * 53 + this.dMx.hashCode();
      }
      i = j;
      if (abQ() > 0) {
        i = (j * 37 + 5) * 53 + this.dKM.hashCode();
      }
      j = i;
      if (aed() > 0) {
        j = (i * 37 + 6) * 53 + this.dMy.hashCode();
      }
      i = j;
      if (abO() > 0) {
        i = (j * 37 + 7) * 53 + this.dKK.hashCode();
      }
      j = i;
      if (abT()) {
        j = (i * 37 + 8) * 53 + aee().hashCode();
      }
      i = j;
      if (aef()) {
        i = (j * 37 + 9) * 53 + aeg().hashCode();
      }
      j = i;
      if (aeh()) {
        j = (i * 37 + 12) * 53 + aei().hashCode();
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.aaS().b(i.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < aec())
      {
        if (!kV(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abQ())
      {
        if (!kF(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < aed())
      {
        if (!kW(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < abO())
      {
        if (!kD(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if ((abT()) && (!aee().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final n.g kD(int paramInt)
    {
      return (n.g)this.dKK.get(paramInt);
    }
    
    public final n.b kF(int paramInt)
    {
      return (n.b)this.dKM.get(paramInt);
    }
    
    public final n.a kV(int paramInt)
    {
      return (n.a)this.dMx.get(paramInt);
    }
    
    public final n.p kW(int paramInt)
    {
      return (n.p)this.dMy.get(paramInt);
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new i();
    }
    
    public final void writeTo(k paramk)
    {
      int k = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        bg.writeString(paramk, 2, this.dMt);
      }
      int i = 0;
      while (i < this.dMu.size())
      {
        bg.writeString(paramk, 3, this.dMu.getRaw(i));
        i += 1;
      }
      i = 0;
      while (i < this.dMx.size())
      {
        paramk.a(4, (ce)this.dMx.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dKM.size())
      {
        paramk.a(5, (ce)this.dKM.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dMy.size())
      {
        paramk.a(6, (ce)this.dMy.get(i));
        i += 1;
      }
      i = 0;
      while (i < this.dKK.size())
      {
        paramk.a(7, (ce)this.dKK.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.a(8, aee());
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.a(9, aeg());
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.dMv.size()) {
          break;
        }
        paramk.cF(10, this.dMv.getInt(i));
        i += 1;
      }
      while (j < this.dMw.size())
      {
        paramk.cF(11, this.dMw.getInt(j));
        j += 1;
      }
      if ((this.bitField0_ & 0x10) != 0) {
        bg.writeString(paramk, 12, this.dMB);
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements z
    {
      private int bitField0_;
      private List<n.g> dKK = Collections.emptyList();
      private List<n.b> dKM = Collections.emptyList();
      private da<n.g, n.g.a, x> dKU;
      private da<n.b, n.b.a, s> dKW;
      private df<n.j, n.j.a, aa> dKZ;
      private n.r dMA;
      private Object dMB = "";
      private da<n.a, n.a.a, q> dMD;
      private da<n.p, n.p.a, ag> dME;
      private df<n.r, n.r.a, aj> dMF;
      private Object dMt = "";
      private bp dMu = bo.dTm;
      private bj.g dMv = bg.emptyIntList();
      private bj.g dMw = bg.emptyIntList();
      private List<n.a> dMx = Collections.emptyList();
      private List<n.p> dMy = Collections.emptyList();
      private n.j dMz;
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a a(n.j paramj)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x200) != 0) && (this.dMz != null) && (this.dMz != n.j.afc()))
          {
            this.dMz = n.j.b(this.dMz).n(paramj).aff();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x200;
          return this;
          this.dMz = paramj;
          break;
          this.dKZ.c(paramj);
        }
      }
      
      private a a(n.r paramr)
      {
        if (this.dMF == null) {
          if (((this.bitField0_ & 0x400) != 0) && (this.dMA != null) && (this.dMA != n.r.agh()))
          {
            this.dMA = n.r.b(this.dMA).d(paramr).agk();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x400;
          return this;
          this.dMA = paramr;
          break;
          this.dMF.c(paramr);
        }
      }
      
      private void acd()
      {
        if ((this.bitField0_ & 0x100) == 0)
        {
          this.dKK = new ArrayList(this.dKK);
          this.bitField0_ |= 0x100;
        }
      }
      
      private da<n.g, n.g.a, x> ace()
      {
        List localList;
        if (this.dKU == null)
        {
          localList = this.dKK;
          if ((this.bitField0_ & 0x100) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.dKU = new da(localList, bool, getParentForChildren(), isClean());
          this.dKK = null;
          return this.dKU;
        }
      }
      
      private void ach()
      {
        if ((this.bitField0_ & 0x40) == 0)
        {
          this.dKM = new ArrayList(this.dKM);
          this.bitField0_ |= 0x40;
        }
      }
      
      private da<n.b, n.b.a, s> aci()
      {
        List localList;
        if (this.dKW == null)
        {
          localList = this.dKM;
          if ((this.bitField0_ & 0x40) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dKW = new da(localList, bool, getParentForChildren(), isClean());
          this.dKM = null;
          return this.dKW;
        }
      }
      
      private df<n.j, n.j.a, aa> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(aee(), getParentForChildren(), isClean());
          this.dMz = null;
        }
        return this.dKZ;
      }
      
      private n.j aee()
      {
        if (this.dKZ == null)
        {
          if (this.dMz == null) {
            return n.j.afc();
          }
          return this.dMz;
        }
        return (n.j)this.dKZ.ajm();
      }
      
      private n.r aeg()
      {
        if (this.dMF == null)
        {
          if (this.dMA == null) {
            return n.r.agh();
          }
          return this.dMA;
        }
        return (n.r)this.dMF.ajm();
      }
      
      private a aem()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.dMt = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.dMu = bo.dTm;
        this.bitField0_ &= 0xFFFFFFFB;
        this.dMv = bg.emptyIntList();
        this.bitField0_ &= 0xFFFFFFF7;
        this.dMw = bg.emptyIntList();
        this.bitField0_ &= 0xFFFFFFEF;
        if (this.dMD == null)
        {
          this.dMx = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFDF;
          if (this.dKW != null) {
            break label273;
          }
          this.dKM = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFBF;
          label143:
          if (this.dME != null) {
            break label283;
          }
          this.dMy = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFF7F;
          label169:
          if (this.dKU != null) {
            break label293;
          }
          this.dKK = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFEFF;
          label195:
          if (this.dKZ != null) {
            break label303;
          }
          this.dMz = null;
          label207:
          this.bitField0_ &= 0xFFFFFDFF;
          if (this.dMF != null) {
            break label314;
          }
          this.dMA = null;
        }
        for (;;)
        {
          this.bitField0_ &= 0xFFFFFBFF;
          this.dMB = "";
          this.bitField0_ &= 0xFFFFF7FF;
          return this;
          this.dMD.clear();
          break;
          label273:
          this.dKW.clear();
          break label143;
          label283:
          this.dME.clear();
          break label169;
          label293:
          this.dKU.clear();
          break label195;
          label303:
          this.dKZ.ajp();
          break label207;
          label314:
          this.dMF.ajp();
        }
      }
      
      private n.i aeo()
      {
        int i = 0;
        n.i locali = new n.i(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        n.i.a(locali, this.name_);
        if ((k & 0x2) != 0) {
          i |= 0x2;
        }
        label277:
        label406:
        label543:
        label562:
        for (;;)
        {
          n.i.b(locali, this.dMt);
          if ((this.bitField0_ & 0x4) != 0)
          {
            this.dMu = this.dMu.aiv();
            this.bitField0_ &= 0xFFFFFFFB;
          }
          n.i.a(locali, this.dMu);
          if ((this.bitField0_ & 0x8) != 0)
          {
            this.dMv.ZP();
            this.bitField0_ &= 0xFFFFFFF7;
          }
          n.i.a(locali, this.dMv);
          if ((this.bitField0_ & 0x10) != 0)
          {
            this.dMw.ZP();
            this.bitField0_ &= 0xFFFFFFEF;
          }
          n.i.b(locali, this.dMw);
          label328:
          label379:
          int j;
          if (this.dMD == null)
          {
            if ((this.bitField0_ & 0x20) != 0)
            {
              this.dMx = Collections.unmodifiableList(this.dMx);
              this.bitField0_ &= 0xFFFFFFDF;
            }
            n.i.a(locali, this.dMx);
            if (this.dKW != null) {
              break label495;
            }
            if ((this.bitField0_ & 0x40) != 0)
            {
              this.dKM = Collections.unmodifiableList(this.dKM);
              this.bitField0_ &= 0xFFFFFFBF;
            }
            n.i.b(locali, this.dKM);
            if (this.dME != null) {
              break label511;
            }
            if ((this.bitField0_ & 0x80) != 0)
            {
              this.dMy = Collections.unmodifiableList(this.dMy);
              this.bitField0_ &= 0xFFFFFF7F;
            }
            n.i.c(locali, this.dMy);
            if (this.dKU != null) {
              break label527;
            }
            if ((this.bitField0_ & 0x100) != 0)
            {
              this.dKK = Collections.unmodifiableList(this.dKK);
              this.bitField0_ &= 0xFFFFFEFF;
            }
            n.i.d(locali, this.dKK);
            j = i;
            if ((k & 0x200) != 0)
            {
              if (this.dKZ != null) {
                break label543;
              }
              n.i.a(locali, this.dMz);
              j = i | 0x4;
            }
            if ((k & 0x400) == 0) {
              break label581;
            }
            if (this.dMF != null) {
              break label562;
            }
            n.i.a(locali, this.dMA);
          }
          label435:
          label581:
          for (i = j | 0x8;; i = j)
          {
            j = i;
            if ((k & 0x800) != 0) {
              j = i | 0x10;
            }
            n.i.c(locali, this.dMB);
            n.i.a(locali, j);
            onBuilt();
            return locali;
            n.i.a(locali, this.dMD.build());
            break;
            label495:
            n.i.b(locali, this.dKW.build());
            break label277;
            label511:
            n.i.c(locali, this.dME.build());
            break label328;
            n.i.d(locali, this.dKU.build());
            break label379;
            n.i.a(locali, (n.j)this.dKZ.ajn());
            break label406;
            n.i.a(locali, (n.r)this.dMF.ajn());
            break label435;
          }
        }
      }
      
      private void aep()
      {
        if ((this.bitField0_ & 0x4) == 0)
        {
          this.dMu = new bo(this.dMu);
          this.bitField0_ |= 0x4;
        }
      }
      
      private void aeq()
      {
        if ((this.bitField0_ & 0x8) == 0)
        {
          this.dMv = bg.mutableCopy(this.dMv);
          this.bitField0_ |= 0x8;
        }
      }
      
      private void aer()
      {
        if ((this.bitField0_ & 0x10) == 0)
        {
          this.dMw = bg.mutableCopy(this.dMw);
          this.bitField0_ |= 0x10;
        }
      }
      
      private void aes()
      {
        if ((this.bitField0_ & 0x20) == 0)
        {
          this.dMx = new ArrayList(this.dMx);
          this.bitField0_ |= 0x20;
        }
      }
      
      private da<n.a, n.a.a, q> aet()
      {
        List localList;
        if (this.dMD == null)
        {
          localList = this.dMx;
          if ((this.bitField0_ & 0x20) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dMD = new da(localList, bool, getParentForChildren(), isClean());
          this.dMx = null;
          return this.dMD;
        }
      }
      
      private void aeu()
      {
        if ((this.bitField0_ & 0x80) == 0)
        {
          this.dMy = new ArrayList(this.dMy);
          this.bitField0_ |= 0x80;
        }
      }
      
      private da<n.p, n.p.a, ag> aev()
      {
        List localList;
        if (this.dME == null)
        {
          localList = this.dMy;
          if ((this.bitField0_ & 0x80) == 0) {
            break label56;
          }
        }
        label56:
        for (boolean bool = true;; bool = false)
        {
          this.dME = new da(localList, bool, getParentForChildren(), isClean());
          this.dMy = null;
          return this.dME;
        }
      }
      
      private df<n.r, n.r.a, aj> aew()
      {
        if (this.dMF == null)
        {
          this.dMF = new df(aeg(), getParentForChildren(), isClean());
          this.dMA = null;
        }
        return this.dMF;
      }
      
      private a l(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a l(cb paramcb)
      {
        if ((paramcb instanceof n.i)) {
          return k((n.i)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a l(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 324	com/google/d/n$i:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 330 3 0
        //   12: checkcast 9	com/google/d/n$i
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 313	com/google/d/n$i$a:k	(Lcom/google/d/n$i;)Lcom/google/d/n$i$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 334	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$i
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 338	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 313	com/google/d/n$i$a:k	(Lcom/google/d/n$i;)Lcom/google/d/n$i$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a m(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders)
        {
          aet();
          aci();
          aev();
          ace();
          acn();
          aew();
        }
      }
      
      private a p(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      private a w(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a x(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a y(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a z(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      public final n.i aen()
      {
        n.i locali = aeo();
        if (!locali.isInitialized()) {
          throw newUninitializedMessageException(locali);
        }
        return locali;
      }
      
      public final a dZ(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramString;
        onChanged();
        return this;
      }
      
      public final a ea(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.dMt = paramString;
        onChanged();
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        return n.aaR();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.aaS().b(n.i.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        Object localObject;
        if (this.dMD == null)
        {
          j = this.dMx.size();
          if (i >= j) {
            break label88;
          }
          if (this.dMD != null) {
            break label65;
          }
          localObject = (n.a)this.dMx.get(i);
          label45:
          if (((n.a)localObject).isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.dMD.getCount();
          break label19;
          label65:
          localObject = (n.a)this.dMD.J(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          i = 0;
          if (this.dKW == null)
          {
            j = this.dKM.size();
            label107:
            if (i >= j) {
              break label174;
            }
            if (this.dKW != null) {
              break label158;
            }
          }
          label158:
          for (localObject = (n.b)this.dKM.get(i);; localObject = (n.b)this.dKW.J(i, false))
          {
            if (!((n.b)localObject).isInitialized()) {
              break label172;
            }
            i += 1;
            break;
            j = this.dKW.getCount();
            break label107;
          }
          label172:
          continue;
          label174:
          i = 0;
          if (this.dME == null)
          {
            j = this.dMy.size();
            label193:
            if (i >= j) {
              break label260;
            }
            if (this.dME != null) {
              break label244;
            }
          }
          label244:
          for (localObject = (n.p)this.dMy.get(i);; localObject = (n.p)this.dME.J(i, false))
          {
            if (!((n.p)localObject).isInitialized()) {
              break label258;
            }
            i += 1;
            break;
            j = this.dME.getCount();
            break label193;
          }
          label258:
          continue;
          label260:
          i = 0;
          if (this.dKU == null)
          {
            j = this.dKK.size();
            label279:
            if (i >= j) {
              break label346;
            }
            if (this.dKU != null) {
              break label330;
            }
          }
          label330:
          for (localObject = (n.g)this.dKK.get(i);; localObject = (n.g)this.dKU.J(i, false))
          {
            if (!((n.g)localObject).isInitialized()) {
              break label344;
            }
            i += 1;
            break;
            j = this.dKU.getCount();
            break label279;
          }
          label344:
          continue;
          label346:
          if ((this.bitField0_ & 0x200) != 0) {}
          for (i = 1; (i == 0) || (aee().isInitialized()); i = 0) {
            return true;
          }
        }
      }
      
      public final a k(n.a parama)
      {
        if (this.dMD == null)
        {
          if (parama == null) {
            throw new NullPointerException();
          }
          aes();
          this.dMx.add(parama);
          onChanged();
          return this;
        }
        this.dMD.a(parama);
        return this;
      }
      
      public final a k(n.i parami)
      {
        Object localObject2 = null;
        if (parami == n.i.ael()) {
          return this;
        }
        if (parami.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.i.a(parami);
          onChanged();
        }
        if (parami.adZ())
        {
          this.bitField0_ |= 0x2;
          this.dMt = n.i.b(parami);
          onChanged();
        }
        if (!n.i.c(parami).isEmpty())
        {
          if (this.dMu.isEmpty())
          {
            this.dMu = n.i.c(parami);
            this.bitField0_ &= 0xFFFFFFFB;
            onChanged();
          }
        }
        else
        {
          if (!n.i.d(parami).isEmpty())
          {
            if (!this.dMv.isEmpty()) {
              break label527;
            }
            this.dMv = n.i.d(parami);
            this.bitField0_ &= 0xFFFFFFF7;
            label159:
            onChanged();
          }
          if (!n.i.e(parami).isEmpty())
          {
            if (!this.dMw.isEmpty()) {
              break label548;
            }
            this.dMw = n.i.e(parami);
            this.bitField0_ &= 0xFFFFFFEF;
            label206:
            onChanged();
          }
          if (this.dMD != null) {
            break label590;
          }
          if (!n.i.f(parami).isEmpty())
          {
            if (!this.dMx.isEmpty()) {
              break label569;
            }
            this.dMx = n.i.f(parami);
            this.bitField0_ &= 0xFFFFFFDF;
            label260:
            onChanged();
          }
          label264:
          if (this.dKW != null) {
            break label704;
          }
          if (!n.i.g(parami).isEmpty())
          {
            if (!this.dKM.isEmpty()) {
              break label683;
            }
            this.dKM = n.i.g(parami);
            this.bitField0_ &= 0xFFFFFFBF;
            label314:
            onChanged();
          }
          label318:
          if (this.dME != null) {
            break label818;
          }
          if (!n.i.h(parami).isEmpty())
          {
            if (!this.dMy.isEmpty()) {
              break label797;
            }
            this.dMy = n.i.h(parami);
            this.bitField0_ &= 0xFFFFFF7F;
            label369:
            onChanged();
          }
          label373:
          if (this.dKU != null) {
            break label933;
          }
          if (!n.i.i(parami).isEmpty())
          {
            if (!this.dKK.isEmpty()) {
              break label912;
            }
            this.dKK = n.i.i(parami);
            this.bitField0_ &= 0xFFFFFEFF;
            label424:
            onChanged();
          }
        }
        for (;;)
        {
          if (parami.abT()) {
            a(parami.aee());
          }
          if (parami.aef()) {
            a(parami.aeg());
          }
          if (parami.aeh())
          {
            this.bitField0_ |= 0x800;
            this.dMB = n.i.j(parami);
            onChanged();
          }
          x(parami.unknownFields);
          onChanged();
          return this;
          aep();
          this.dMu.addAll(n.i.c(parami));
          break;
          label527:
          aeq();
          this.dMv.addAll(n.i.d(parami));
          break label159;
          label548:
          aer();
          this.dMw.addAll(n.i.e(parami));
          break label206;
          label569:
          aes();
          this.dMx.addAll(n.i.f(parami));
          break label260;
          label590:
          if (n.i.f(parami).isEmpty()) {
            break label264;
          }
          Object localObject1;
          if (this.dMD.isEmpty())
          {
            this.dMD.dUC = null;
            this.dMD = null;
            this.dMx = n.i.f(parami);
            this.bitField0_ &= 0xFFFFFFDF;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = aet();; localObject1 = null)
            {
              this.dMD = ((da)localObject1);
              break;
            }
          }
          this.dMD.a(n.i.f(parami));
          break label264;
          label683:
          ach();
          this.dKM.addAll(n.i.g(parami));
          break label314;
          label704:
          if (n.i.g(parami).isEmpty()) {
            break label318;
          }
          if (this.dKW.isEmpty())
          {
            this.dKW.dUC = null;
            this.dKW = null;
            this.dKM = n.i.g(parami);
            this.bitField0_ &= 0xFFFFFFBF;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = aci();; localObject1 = null)
            {
              this.dKW = ((da)localObject1);
              break;
            }
          }
          this.dKW.a(n.i.g(parami));
          break label318;
          label797:
          aeu();
          this.dMy.addAll(n.i.h(parami));
          break label369;
          label818:
          if (n.i.h(parami).isEmpty()) {
            break label373;
          }
          if (this.dME.isEmpty())
          {
            this.dME.dUC = null;
            this.dME = null;
            this.dMy = n.i.h(parami);
            this.bitField0_ &= 0xFFFFFF7F;
            if (bg.alwaysUseFieldBuilders) {}
            for (localObject1 = aev();; localObject1 = null)
            {
              this.dME = ((da)localObject1);
              break;
            }
          }
          this.dME.a(n.i.h(parami));
          break label373;
          label912:
          acd();
          this.dKK.addAll(n.i.i(parami));
          break label424;
          label933:
          if (!n.i.i(parami).isEmpty()) {
            if (this.dKU.isEmpty())
            {
              this.dKU.dUC = null;
              this.dKU = null;
              this.dKK = n.i.i(parami);
              this.bitField0_ &= 0xFFFFFEFF;
              localObject1 = localObject2;
              if (bg.alwaysUseFieldBuilders) {
                localObject1 = ace();
              }
              this.dKU = ((da)localObject1);
            }
            else
            {
              this.dKU.a(n.i.i(parami));
            }
          }
        }
      }
    }
  }
  
  public static final class j
    extends bg.d<j>
    implements aa
  {
    @Deprecated
    public static final cs<j> PARSER = new c() {};
    private static final j dMZ = new j();
    private int bitField0_;
    boolean dLm;
    private List<n.s> dLn;
    private volatile Object dMG;
    private volatile Object dMH;
    boolean dMI;
    boolean dMJ;
    boolean dMK;
    private int dML;
    private volatile Object dMM;
    boolean dMN;
    boolean dMO;
    boolean dMP;
    boolean dMQ;
    boolean dMR;
    private volatile Object dMS;
    private volatile Object dMT;
    private volatile Object dMU;
    private volatile Object dMV;
    private volatile Object dMW;
    private volatile Object dMX;
    private volatile Object dMY;
    private byte memoizedIsInitialized = -1;
    
    private j()
    {
      this.dMG = "";
      this.dMH = "";
      this.dML = 1;
      this.dMM = "";
      this.dMS = "";
      this.dMT = "";
      this.dMU = "";
      this.dMV = "";
      this.dMW = "";
      this.dMX = "";
      this.dMY = "";
      this.dLn = Collections.emptyList();
    }
    
    private j(bg.c<j, ?> paramc)
    {
      super();
    }
    
    private j(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 10: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              localh = parami.aak();
              n = i;
              i1 = i;
              k = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.dMG = localh;
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              k = n;
              if ((k & 0x100000) != 0) {
                this.dLn = Collections.unmodifiableList(this.dLn);
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            i1 = i;
            k = i;
            localh = parami.aak();
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.dMH = localh;
            break;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            j = parami.aam();
            n = i;
            i1 = i;
            k = i;
            if (n.j.b.kX(j) == null)
            {
              n = i;
              i1 = i;
              k = i;
              locala.cR(9, j);
              break;
            }
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x20;
            n = i;
            i1 = i;
            k = i;
            this.dML = j;
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.dMI = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          h localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x40;
          n = i;
          i1 = i;
          k = i;
          this.dMM = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x80;
          n = i;
          i1 = i;
          k = i;
          this.dMN = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x100;
          n = i;
          i1 = i;
          k = i;
          this.dMO = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x200;
          n = i;
          i1 = i;
          k = i;
          this.dMP = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.dMJ = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x800;
          n = i;
          i1 = i;
          k = i;
          this.dLm = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.dMK = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x1000;
          n = i;
          i1 = i;
          k = i;
          this.dMR = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x2000;
          n = i;
          i1 = i;
          k = i;
          this.dMS = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x4000;
          n = i;
          i1 = i;
          k = i;
          this.dMT = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x8000;
          n = i;
          i1 = i;
          k = i;
          this.dMU = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x10000;
          n = i;
          i1 = i;
          k = i;
          this.dMV = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x20000;
          n = i;
          i1 = i;
          k = i;
          this.dMW = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x400;
          n = i;
          i1 = i;
          k = i;
          this.dMQ = parami.aai();
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x40000;
          n = i;
          i1 = i;
          k = i;
          this.dMX = localh;
          break;
          n = i;
          i1 = i;
          k = i;
          localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x80000;
          n = i;
          i1 = i;
          k = i;
          this.dMY = localh;
          break;
          int j = i;
          if ((i & 0x100000) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dLn = new ArrayList();
            j = i | 0x100000;
          }
          n = j;
          i1 = j;
          k = j;
          this.dLn.add(parami.a(n.s.PARSER, paramat));
          i = j;
          break;
          if ((i & 0x100000) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    private String aeA()
    {
      Object localObject = this.dMH;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMH = str;
      }
      return str;
    }
    
    private String aeH()
    {
      Object localObject = this.dMM;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMM = str;
      }
      return str;
    }
    
    private String aeO()
    {
      Object localObject = this.dMS;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMS = str;
      }
      return str;
    }
    
    private String aeQ()
    {
      Object localObject = this.dMT;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMT = str;
      }
      return str;
    }
    
    private String aeS()
    {
      Object localObject = this.dMU;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMU = str;
      }
      return str;
    }
    
    private String aeU()
    {
      Object localObject = this.dMV;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMV = str;
      }
      return str;
    }
    
    private String aeW()
    {
      Object localObject = this.dMW;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMW = str;
      }
      return str;
    }
    
    private String aeY()
    {
      Object localObject = this.dMX;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMX = str;
      }
      return str;
    }
    
    private String aey()
    {
      Object localObject = this.dMG;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMG = str;
      }
      return str;
    }
    
    private String afa()
    {
      Object localObject = this.dMY;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dMY = str;
      }
      return str;
    }
    
    public static j afc()
    {
      return dMZ;
    }
    
    public static a b(j paramj)
    {
      return dMZ.afb().n(paramj);
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x800) != 0;
    }
    
    public final boolean aeB()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    @Deprecated
    public final boolean aeC()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final boolean aeD()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final boolean aeE()
    {
      return (this.bitField0_ & 0x20) != 0;
    }
    
    public final n.j.b aeF()
    {
      n.j.b localb2 = n.j.b.kX(this.dML);
      n.j.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = n.j.b.dNa;
      }
      return localb1;
    }
    
    public final boolean aeG()
    {
      return (this.bitField0_ & 0x40) != 0;
    }
    
    public final boolean aeI()
    {
      return (this.bitField0_ & 0x80) != 0;
    }
    
    public final boolean aeJ()
    {
      return (this.bitField0_ & 0x100) != 0;
    }
    
    public final boolean aeK()
    {
      return (this.bitField0_ & 0x200) != 0;
    }
    
    public final boolean aeL()
    {
      return (this.bitField0_ & 0x400) != 0;
    }
    
    public final boolean aeM()
    {
      return (this.bitField0_ & 0x1000) != 0;
    }
    
    public final boolean aeN()
    {
      return (this.bitField0_ & 0x2000) != 0;
    }
    
    public final boolean aeP()
    {
      return (this.bitField0_ & 0x4000) != 0;
    }
    
    public final boolean aeR()
    {
      return (this.bitField0_ & 0x8000) != 0;
    }
    
    public final boolean aeT()
    {
      return (this.bitField0_ & 0x10000) != 0;
    }
    
    public final boolean aeV()
    {
      return (this.bitField0_ & 0x20000) != 0;
    }
    
    public final boolean aeX()
    {
      return (this.bitField0_ & 0x40000) != 0;
    }
    
    public final boolean aeZ()
    {
      return (this.bitField0_ & 0x80000) != 0;
    }
    
    public final boolean aex()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean aez()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final a afb()
    {
      if (this == dMZ) {
        return new a((byte)0);
      }
      return new a((byte)0).n(this);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof j)) {
          return super.equals(paramObject);
        }
        paramObject = (j)paramObject;
        if (aex() != paramObject.aex()) {
          return false;
        }
        if ((aex()) && (!aey().equals(paramObject.aey()))) {
          return false;
        }
        if (aez() != paramObject.aez()) {
          return false;
        }
        if ((aez()) && (!aeA().equals(paramObject.aeA()))) {
          return false;
        }
        if (aeB() != paramObject.aeB()) {
          return false;
        }
        if ((aeB()) && (this.dMI != paramObject.dMI)) {
          return false;
        }
        if (aeC() != paramObject.aeC()) {
          return false;
        }
        if ((aeC()) && (this.dMJ != paramObject.dMJ)) {
          return false;
        }
        if (aeD() != paramObject.aeD()) {
          return false;
        }
        if ((aeD()) && (this.dMK != paramObject.dMK)) {
          return false;
        }
        if (aeE() != paramObject.aeE()) {
          return false;
        }
        if ((aeE()) && (this.dML != paramObject.dML)) {
          return false;
        }
        if (aeG() != paramObject.aeG()) {
          return false;
        }
        if ((aeG()) && (!aeH().equals(paramObject.aeH()))) {
          return false;
        }
        if (aeI() != paramObject.aeI()) {
          return false;
        }
        if ((aeI()) && (this.dMN != paramObject.dMN)) {
          return false;
        }
        if (aeJ() != paramObject.aeJ()) {
          return false;
        }
        if ((aeJ()) && (this.dMO != paramObject.dMO)) {
          return false;
        }
        if (aeK() != paramObject.aeK()) {
          return false;
        }
        if ((aeK()) && (this.dMP != paramObject.dMP)) {
          return false;
        }
        if (aeL() != paramObject.aeL()) {
          return false;
        }
        if ((aeL()) && (this.dMQ != paramObject.dMQ)) {
          return false;
        }
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (aeM() != paramObject.aeM()) {
          return false;
        }
        if ((aeM()) && (this.dMR != paramObject.dMR)) {
          return false;
        }
        if (aeN() != paramObject.aeN()) {
          return false;
        }
        if ((aeN()) && (!aeO().equals(paramObject.aeO()))) {
          return false;
        }
        if (aeP() != paramObject.aeP()) {
          return false;
        }
        if ((aeP()) && (!aeQ().equals(paramObject.aeQ()))) {
          return false;
        }
        if (aeR() != paramObject.aeR()) {
          return false;
        }
        if ((aeR()) && (!aeS().equals(paramObject.aeS()))) {
          return false;
        }
        if (aeT() != paramObject.aeT()) {
          return false;
        }
        if ((aeT()) && (!aeU().equals(paramObject.aeU()))) {
          return false;
        }
        if (aeV() != paramObject.aeV()) {
          return false;
        }
        if ((aeV()) && (!aeW().equals(paramObject.aeW()))) {
          return false;
        }
        if (aeX() != paramObject.aeX()) {
          return false;
        }
        if ((aeX()) && (!aeY().equals(paramObject.aeY()))) {
          return false;
        }
        if (aeZ() != paramObject.aeZ()) {
          return false;
        }
        if ((aeZ()) && (!afa().equals(paramObject.afa()))) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<j> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int k = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (int j = bg.computeStringSize(1, this.dMG) + 0;; j = 0)
      {
        i = j;
        if ((this.bitField0_ & 0x2) != 0) {
          i = j + bg.computeStringSize(8, this.dMH);
        }
        j = i;
        if ((this.bitField0_ & 0x20) != 0) {
          j = i + k.cM(9, this.dML);
        }
        i = j;
        if ((this.bitField0_ & 0x4) != 0) {
          i = j + k.kn(10);
        }
        j = i;
        if ((this.bitField0_ & 0x40) != 0) {
          j = i + bg.computeStringSize(11, this.dMM);
        }
        i = j;
        if ((this.bitField0_ & 0x80) != 0) {
          i = j + k.kn(16);
        }
        j = i;
        if ((this.bitField0_ & 0x100) != 0) {
          j = i + k.kn(17);
        }
        i = j;
        if ((this.bitField0_ & 0x200) != 0) {
          i = j + k.kn(18);
        }
        j = i;
        if ((this.bitField0_ & 0x8) != 0) {
          j = i + k.kn(20);
        }
        i = j;
        if ((this.bitField0_ & 0x800) != 0) {
          i = j + k.kn(23);
        }
        j = i;
        if ((this.bitField0_ & 0x10) != 0) {
          j = i + k.kn(27);
        }
        i = j;
        if ((this.bitField0_ & 0x1000) != 0) {
          i = j + k.kn(31);
        }
        j = i;
        if ((this.bitField0_ & 0x2000) != 0) {
          j = i + bg.computeStringSize(36, this.dMS);
        }
        i = j;
        if ((this.bitField0_ & 0x4000) != 0) {
          i = j + bg.computeStringSize(37, this.dMT);
        }
        j = i;
        if ((this.bitField0_ & 0x8000) != 0) {
          j = i + bg.computeStringSize(39, this.dMU);
        }
        i = j;
        if ((this.bitField0_ & 0x10000) != 0) {
          i = j + bg.computeStringSize(40, this.dMV);
        }
        j = i;
        if ((this.bitField0_ & 0x20000) != 0) {
          j = i + bg.computeStringSize(41, this.dMW);
        }
        i = j;
        if ((this.bitField0_ & 0x400) != 0) {
          i = j + k.kn(42);
        }
        j = i;
        if ((this.bitField0_ & 0x40000) != 0) {
          j = i + bg.computeStringSize(44, this.dMX);
        }
        i = j;
        if ((this.bitField0_ & 0x80000) != 0) {
          i = j + bg.computeStringSize(45, this.dMY);
        }
        j = k;
        while (j < this.dLn.size())
        {
          k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        i = aie() + i + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abp().hashCode() + 779;
      int i = j;
      if (aex()) {
        i = (j * 37 + 1) * 53 + aey().hashCode();
      }
      j = i;
      if (aez()) {
        j = (i * 37 + 8) * 53 + aeA().hashCode();
      }
      i = j;
      if (aeB()) {
        i = (j * 37 + 10) * 53 + bj.hashBoolean(this.dMI);
      }
      j = i;
      if (aeC()) {
        j = (i * 37 + 20) * 53 + bj.hashBoolean(this.dMJ);
      }
      i = j;
      if (aeD()) {
        i = (j * 37 + 27) * 53 + bj.hashBoolean(this.dMK);
      }
      j = i;
      if (aeE()) {
        j = (i * 37 + 9) * 53 + this.dML;
      }
      i = j;
      if (aeG()) {
        i = (j * 37 + 11) * 53 + aeH().hashCode();
      }
      j = i;
      if (aeI()) {
        j = (i * 37 + 16) * 53 + bj.hashBoolean(this.dMN);
      }
      i = j;
      if (aeJ()) {
        i = (j * 37 + 17) * 53 + bj.hashBoolean(this.dMO);
      }
      j = i;
      if (aeK()) {
        j = (i * 37 + 18) * 53 + bj.hashBoolean(this.dMP);
      }
      i = j;
      if (aeL()) {
        i = (j * 37 + 42) * 53 + bj.hashBoolean(this.dMQ);
      }
      j = i;
      if (acT()) {
        j = (i * 37 + 23) * 53 + bj.hashBoolean(this.dLm);
      }
      i = j;
      if (aeM()) {
        i = (j * 37 + 31) * 53 + bj.hashBoolean(this.dMR);
      }
      j = i;
      if (aeN()) {
        j = (i * 37 + 36) * 53 + aeO().hashCode();
      }
      i = j;
      if (aeP()) {
        i = (j * 37 + 37) * 53 + aeQ().hashCode();
      }
      j = i;
      if (aeR()) {
        j = (i * 37 + 39) * 53 + aeS().hashCode();
      }
      i = j;
      if (aeT()) {
        i = (j * 37 + 40) * 53 + aeU().hashCode();
      }
      j = i;
      if (aeV()) {
        j = (i * 37 + 41) * 53 + aeW().hashCode();
      }
      i = j;
      if (aeX()) {
        i = (j * 37 + 44) * 53 + aeY().hashCode();
      }
      j = i;
      if (aeZ()) {
        j = (i * 37 + 45) * 53 + afa().hashCode();
      }
      i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abq().b(j.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new j();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.dMG);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        bg.writeString(paramk, 8, this.dMH);
      }
      if ((this.bitField0_ & 0x20) != 0) {
        paramk.cF(9, this.dML);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.I(10, this.dMI);
      }
      if ((this.bitField0_ & 0x40) != 0) {
        bg.writeString(paramk, 11, this.dMM);
      }
      if ((this.bitField0_ & 0x80) != 0) {
        paramk.I(16, this.dMN);
      }
      if ((this.bitField0_ & 0x100) != 0) {
        paramk.I(17, this.dMO);
      }
      if ((this.bitField0_ & 0x200) != 0) {
        paramk.I(18, this.dMP);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.I(20, this.dMJ);
      }
      if ((this.bitField0_ & 0x800) != 0) {
        paramk.I(23, this.dLm);
      }
      if ((this.bitField0_ & 0x10) != 0) {
        paramk.I(27, this.dMK);
      }
      if ((this.bitField0_ & 0x1000) != 0) {
        paramk.I(31, this.dMR);
      }
      if ((this.bitField0_ & 0x2000) != 0) {
        bg.writeString(paramk, 36, this.dMS);
      }
      if ((this.bitField0_ & 0x4000) != 0) {
        bg.writeString(paramk, 37, this.dMT);
      }
      if ((this.bitField0_ & 0x8000) != 0) {
        bg.writeString(paramk, 39, this.dMU);
      }
      if ((this.bitField0_ & 0x10000) != 0) {
        bg.writeString(paramk, 40, this.dMV);
      }
      if ((this.bitField0_ & 0x20000) != 0) {
        bg.writeString(paramk, 41, this.dMW);
      }
      if ((this.bitField0_ & 0x400) != 0) {
        paramk.I(42, this.dMQ);
      }
      if ((this.bitField0_ & 0x40000) != 0) {
        bg.writeString(paramk, 44, this.dMX);
      }
      if ((this.bitField0_ & 0x80000) != 0) {
        bg.writeString(paramk, 45, this.dMY);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.j, a>
      implements aa
    {
      private int bitField0_;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      private Object dMG = "";
      private Object dMH = "";
      private boolean dMI;
      private boolean dMJ;
      private boolean dMK;
      private int dML = 1;
      private Object dMM = "";
      private boolean dMN;
      private boolean dMO;
      private boolean dMP;
      private boolean dMQ;
      private boolean dMR;
      private Object dMS = "";
      private Object dMT = "";
      private Object dMU = "";
      private Object dMV = "";
      private Object dMW = "";
      private Object dMX = "";
      private Object dMY = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a A(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a B(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      private a a(n.j.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.dML = paramb.value;
        onChanged();
        return this;
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x100000) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x100000;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x100000) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a afd()
      {
        super.adc();
        this.dMG = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.dMH = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.dMI = false;
        this.bitField0_ &= 0xFFFFFFFB;
        this.dMJ = false;
        this.bitField0_ &= 0xFFFFFFF7;
        this.dMK = false;
        this.bitField0_ &= 0xFFFFFFEF;
        this.dML = 1;
        this.bitField0_ &= 0xFFFFFFDF;
        this.dMM = "";
        this.bitField0_ &= 0xFFFFFFBF;
        this.dMN = false;
        this.bitField0_ &= 0xFFFFFF7F;
        this.dMO = false;
        this.bitField0_ &= 0xFFFFFEFF;
        this.dMP = false;
        this.bitField0_ &= 0xFFFFFDFF;
        this.dMQ = false;
        this.bitField0_ &= 0xFFFFFBFF;
        this.dLm = false;
        this.bitField0_ &= 0xFFFFF7FF;
        this.dMR = false;
        this.bitField0_ &= 0xFFFFEFFF;
        this.dMS = "";
        this.bitField0_ &= 0xFFFFDFFF;
        this.dMT = "";
        this.bitField0_ &= 0xFFFFBFFF;
        this.dMU = "";
        this.bitField0_ &= 0xFFFF7FFF;
        this.dMV = "";
        this.bitField0_ &= 0xFFFEFFFF;
        this.dMW = "";
        this.bitField0_ &= 0xFFFDFFFF;
        this.dMX = "";
        this.bitField0_ &= 0xFFFBFFFF;
        this.dMY = "";
        this.bitField0_ &= 0xFFF7FFFF;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFEFFFFF;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.j afe()
      {
        n.j localj = aff();
        if (!localj.isInitialized()) {
          throw newUninitializedMessageException(localj);
        }
        return localj;
      }
      
      private a ch(boolean paramBoolean)
      {
        this.bitField0_ |= 0x4;
        this.dMI = paramBoolean;
        onChanged();
        return this;
      }
      
      @Deprecated
      private a ci(boolean paramBoolean)
      {
        this.bitField0_ |= 0x8;
        this.dMJ = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cj(boolean paramBoolean)
      {
        this.bitField0_ |= 0x10;
        this.dMK = paramBoolean;
        onChanged();
        return this;
      }
      
      private a ck(boolean paramBoolean)
      {
        this.bitField0_ |= 0x80;
        this.dMN = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cl(boolean paramBoolean)
      {
        this.bitField0_ |= 0x100;
        this.dMO = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cm(boolean paramBoolean)
      {
        this.bitField0_ |= 0x200;
        this.dMP = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cn(boolean paramBoolean)
      {
        this.bitField0_ |= 0x400;
        this.dMQ = paramBoolean;
        onChanged();
        return this;
      }
      
      private a co(boolean paramBoolean)
      {
        this.bitField0_ |= 0x800;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cp(boolean paramBoolean)
      {
        this.bitField0_ |= 0x1000;
        this.dMR = paramBoolean;
        onChanged();
        return this;
      }
      
      private a m(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a m(cb paramcb)
      {
        if ((paramcb instanceof n.j)) {
          return n((n.j)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a m(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 217	com/google/d/n$j:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 223 3 0
        //   12: checkcast 9	com/google/d/n$j
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 206	com/google/d/n$j$a:n	(Lcom/google/d/n$j;)Lcom/google/d/n$j$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 227	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$j
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 231	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 206	com/google/d/n$j$a:n	(Lcom/google/d/n$j;)Lcom/google/d/n$j$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a n(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a q(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      private a y(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a z(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      public final n.j aff()
      {
        int j = 0;
        n.j localj = new n.j(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        n.j.a(localj, this.dMG);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        n.j.b(localj, this.dMH);
        j = i;
        if ((k & 0x4) != 0)
        {
          n.j.a(localj, this.dMI);
          j = i | 0x4;
        }
        i = j;
        if ((k & 0x8) != 0)
        {
          n.j.b(localj, this.dMJ);
          i = j | 0x8;
        }
        j = i;
        if ((k & 0x10) != 0)
        {
          n.j.c(localj, this.dMK);
          j = i | 0x10;
        }
        i = j;
        if ((k & 0x20) != 0) {
          i = j | 0x20;
        }
        n.j.a(localj, this.dML);
        j = i;
        if ((k & 0x40) != 0) {
          j = i | 0x40;
        }
        n.j.c(localj, this.dMM);
        i = j;
        if ((k & 0x80) != 0)
        {
          n.j.d(localj, this.dMN);
          i = j | 0x80;
        }
        j = i;
        if ((k & 0x100) != 0)
        {
          n.j.e(localj, this.dMO);
          j = i | 0x100;
        }
        i = j;
        if ((k & 0x200) != 0)
        {
          n.j.f(localj, this.dMP);
          i = j | 0x200;
        }
        j = i;
        if ((k & 0x400) != 0)
        {
          n.j.g(localj, this.dMQ);
          j = i | 0x400;
        }
        i = j;
        if ((k & 0x800) != 0)
        {
          n.j.h(localj, this.dLm);
          i = j | 0x800;
        }
        j = i;
        if ((k & 0x1000) != 0)
        {
          n.j.i(localj, this.dMR);
          j = i | 0x1000;
        }
        i = j;
        if ((k & 0x2000) != 0) {
          i = j | 0x2000;
        }
        n.j.d(localj, this.dMS);
        j = i;
        if ((k & 0x4000) != 0) {
          j = i | 0x4000;
        }
        n.j.e(localj, this.dMT);
        i = j;
        if ((k & 0x8000) != 0) {
          i = j | 0x8000;
        }
        n.j.f(localj, this.dMU);
        j = i;
        if ((k & 0x10000) != 0) {
          j = i | 0x10000;
        }
        n.j.g(localj, this.dMV);
        i = j;
        if ((k & 0x20000) != 0) {
          i = j | 0x20000;
        }
        n.j.h(localj, this.dMW);
        j = i;
        if ((k & 0x40000) != 0) {
          j = i | 0x40000;
        }
        n.j.i(localj, this.dMX);
        i = j;
        if ((k & 0x80000) != 0) {
          i = j | 0x80000;
        }
        n.j.j(localj, this.dMY);
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x100000) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFEFFFFF;
          }
          n.j.a(localj, this.dLn);
        }
        for (;;)
        {
          n.j.b(localj, i);
          onBuilt();
          return localj;
          n.j.a(localj, this.dLp.build());
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abp();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abq().b(n.j.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
      
      public final a n(n.j paramj)
      {
        da localda = null;
        if (paramj == n.j.afc()) {
          return this;
        }
        if (paramj.aex())
        {
          this.bitField0_ |= 0x1;
          this.dMG = n.j.c(paramj);
          onChanged();
        }
        if (paramj.aez())
        {
          this.bitField0_ |= 0x2;
          this.dMH = n.j.d(paramj);
          onChanged();
        }
        if (paramj.aeB()) {
          ch(paramj.dMI);
        }
        if (paramj.aeC()) {
          ci(paramj.dMJ);
        }
        if (paramj.aeD()) {
          cj(paramj.dMK);
        }
        if (paramj.aeE()) {
          a(paramj.aeF());
        }
        if (paramj.aeG())
        {
          this.bitField0_ |= 0x40;
          this.dMM = n.j.e(paramj);
          onChanged();
        }
        if (paramj.aeI()) {
          ck(paramj.dMN);
        }
        if (paramj.aeJ()) {
          cl(paramj.dMO);
        }
        if (paramj.aeK()) {
          cm(paramj.dMP);
        }
        if (paramj.aeL()) {
          cn(paramj.dMQ);
        }
        if (paramj.acT()) {
          co(paramj.dLm);
        }
        if (paramj.aeM()) {
          cp(paramj.dMR);
        }
        if (paramj.aeN())
        {
          this.bitField0_ |= 0x2000;
          this.dMS = n.j.f(paramj);
          onChanged();
        }
        if (paramj.aeP())
        {
          this.bitField0_ |= 0x4000;
          this.dMT = n.j.g(paramj);
          onChanged();
        }
        if (paramj.aeR())
        {
          this.bitField0_ |= 0x8000;
          this.dMU = n.j.h(paramj);
          onChanged();
        }
        if (paramj.aeT())
        {
          this.bitField0_ |= 0x10000;
          this.dMV = n.j.i(paramj);
          onChanged();
        }
        if (paramj.aeV())
        {
          this.bitField0_ |= 0x20000;
          this.dMW = n.j.j(paramj);
          onChanged();
        }
        if (paramj.aeX())
        {
          this.bitField0_ |= 0x40000;
          this.dMX = n.j.k(paramj);
          onChanged();
        }
        if (paramj.aeZ())
        {
          this.bitField0_ |= 0x80000;
          this.dMY = n.j.l(paramj);
          onChanged();
        }
        if (this.dLp == null) {
          if (!n.j.m(paramj).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label550;
            }
            this.dLn = n.j.m(paramj);
            this.bitField0_ &= 0xFFEFFFFF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramj);
          z(paramj.unknownFields);
          onChanged();
          return this;
          label550:
          ada();
          this.dLn.addAll(n.j.m(paramj));
          break;
          if (!n.j.m(paramj).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.j.m(paramj);
              this.bitField0_ &= 0xFFEFFFFF;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.j.m(paramj));
            }
          }
        }
      }
    }
  }
  
  public static final class k
    extends bg.d<k>
    implements ab
  {
    @Deprecated
    public static final cs<k> PARSER = new c() {};
    private static final k dNi = new k();
    private int bitField0_;
    boolean dLm;
    private List<n.s> dLn;
    boolean dNf;
    boolean dNg;
    boolean dNh;
    private byte memoizedIsInitialized = -1;
    
    private k()
    {
      this.dLn = Collections.emptyList();
    }
    
    private k(bg.c<k, ?> paramc)
    {
      super();
    }
    
    private k(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 8: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.dNf = parami.aai();
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              k = n;
              if ((k & 0x10) != 0) {
                this.dLn = Collections.unmodifiableList(this.dLn);
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.dNg = parami.aai();
            break;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x4;
            n = i;
            i1 = i;
            k = i;
            this.dLm = parami.aai();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.dNh = parami.aai();
          break;
          int j = i;
          if ((i & 0x10) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dLn = new ArrayList();
            j = i | 0x10;
          }
          n = j;
          i1 = j;
          k = j;
          this.dLn.add(parami.a(n.s.PARSER, paramat));
          i = j;
          break;
          if ((i & 0x10) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static k afk()
    {
      return dNi;
    }
    
    public static a b(k paramk)
    {
      return dNi.afj().d(paramk);
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean afg()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean afh()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean afi()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final a afj()
    {
      if (this == dNi) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (afg() != paramObject.afg()) {
          return false;
        }
        if ((afg()) && (this.dNf != paramObject.dNf)) {
          return false;
        }
        if (afh() != paramObject.afh()) {
          return false;
        }
        if ((afh()) && (this.dNg != paramObject.dNg)) {
          return false;
        }
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (afi() != paramObject.afi()) {
          return false;
        }
        if ((afi()) && (this.dNh != paramObject.dNh)) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<k> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int k = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (int j = k.kn(1) + 0;; j = 0)
      {
        i = j;
        if ((this.bitField0_ & 0x2) != 0) {
          i = j + k.kn(2);
        }
        j = i;
        if ((this.bitField0_ & 0x4) != 0) {
          j = i + k.kn(3);
        }
        i = j;
        if ((this.bitField0_ & 0x8) != 0) {
          i = j + k.kn(7);
        }
        j = k;
        while (j < this.dLn.size())
        {
          k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        i = aie() + i + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abr().hashCode() + 779;
      int i = j;
      if (afg()) {
        i = (j * 37 + 1) * 53 + bj.hashBoolean(this.dNf);
      }
      j = i;
      if (afh()) {
        j = (i * 37 + 2) * 53 + bj.hashBoolean(this.dNg);
      }
      i = j;
      if (acT()) {
        i = (j * 37 + 3) * 53 + bj.hashBoolean(this.dLm);
      }
      j = i;
      if (afi()) {
        j = (i * 37 + 7) * 53 + bj.hashBoolean(this.dNh);
      }
      i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abs().b(k.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new k();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.I(1, this.dNf);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.I(2, this.dNg);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.I(3, this.dLm);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.I(7, this.dNh);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.k, a>
      implements ab
    {
      private int bitField0_;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      private boolean dNf;
      private boolean dNg;
      private boolean dNh;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a A(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a B(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a C(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a D(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x10) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x10;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x10) == 0) {
            break label55;
          }
        }
        label55:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a afl()
      {
        super.adc();
        this.dNf = false;
        this.bitField0_ &= 0xFFFFFFFE;
        this.dNg = false;
        this.bitField0_ &= 0xFFFFFFFD;
        this.dLm = false;
        this.bitField0_ &= 0xFFFFFFFB;
        this.dNh = false;
        this.bitField0_ &= 0xFFFFFFF7;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFEF;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.k afm()
      {
        n.k localk = afn();
        if (!localk.isInitialized()) {
          throw newUninitializedMessageException(localk);
        }
        return localk;
      }
      
      private a cq(boolean paramBoolean)
      {
        this.bitField0_ |= 0x1;
        this.dNf = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cr(boolean paramBoolean)
      {
        this.bitField0_ |= 0x2;
        this.dNg = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cs(boolean paramBoolean)
      {
        this.bitField0_ |= 0x4;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private a ct(boolean paramBoolean)
      {
        this.bitField0_ |= 0x8;
        this.dNh = paramBoolean;
        onChanged();
        return this;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a n(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a n(cb paramcb)
      {
        if ((paramcb instanceof n.k)) {
          return d((n.k)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a n(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 161	com/google/d/n$k:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 167 3 0
        //   12: checkcast 9	com/google/d/n$k
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 150	com/google/d/n$k$a:d	(Lcom/google/d/n$k;)Lcom/google/d/n$k$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 171	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$k
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 175	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 150	com/google/d/n$k$a:d	(Lcom/google/d/n$k;)Lcom/google/d/n$k$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a o(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a r(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      public final n.k afn()
      {
        int j = 0;
        n.k localk = new n.k(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0)
        {
          n.k.a(localk, this.dNf);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0)
        {
          n.k.b(localk, this.dNg);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0)
        {
          n.k.c(localk, this.dLm);
          j = i | 0x4;
        }
        i = j;
        if ((k & 0x8) != 0)
        {
          n.k.d(localk, this.dNh);
          i = j | 0x8;
        }
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x10) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFEF;
          }
          n.k.a(localk, this.dLn);
        }
        for (;;)
        {
          n.k.a(localk, i);
          onBuilt();
          return localk;
          n.k.a(localk, this.dLp.build());
        }
      }
      
      public final a d(n.k paramk)
      {
        da localda = null;
        if (paramk == n.k.afk()) {
          return this;
        }
        if (paramk.afg()) {
          cq(paramk.dNf);
        }
        if (paramk.afh()) {
          cr(paramk.dNg);
        }
        if (paramk.acT()) {
          cs(paramk.dLm);
        }
        if (paramk.afi()) {
          ct(paramk.dNh);
        }
        if (this.dLp == null) {
          if (!n.k.c(paramk).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label149;
            }
            this.dLn = n.k.c(paramk);
            this.bitField0_ &= 0xFFFFFFEF;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramk);
          B(paramk.unknownFields);
          onChanged();
          return this;
          label149:
          ada();
          this.dLn.addAll(n.k.c(paramk));
          break;
          if (!n.k.c(paramk).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.k.c(paramk);
              this.bitField0_ &= 0xFFFFFFEF;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.k.c(paramk));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abr();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abs().b(n.k.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class l
    extends bg
    implements ac
  {
    @Deprecated
    public static final cs<l> PARSER = new c() {};
    private static final l dNo = new l();
    private int bitField0_;
    private volatile Object dNj;
    private volatile Object dNk;
    private n.m dNl;
    boolean dNm;
    boolean dNn;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private l()
    {
      this.name_ = "";
      this.dNj = "";
      this.dNk = "";
    }
    
    private l(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private l(i parami, at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 38	com/google/d/n$l:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 69	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 70	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 76	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +326 -> 350
      //   27: aload_1
      //   28: invokevirtual 82	com/google/d/i:aac	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+338->373, 0:+344->379, 10:+83->118, 18:+132->167, 26:+174->209, 34:+199->234, 40:+271->306, 48:+293->328
      //   101: aload_1
      //   102: aload 6
      //   104: aload_2
      //   105: iload 4
      //   107: invokevirtual 86	com/google/d/n$l:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   110: ifne +254 -> 364
      //   113: iconst_1
      //   114: istore_3
      //   115: goto +261 -> 376
      //   118: aload_1
      //   119: invokevirtual 90	com/google/d/i:aak	()Lcom/google/d/h;
      //   122: astore 5
      //   124: aload_0
      //   125: aload_0
      //   126: getfield 92	com/google/d/n$l:bitField0_	I
      //   129: iconst_1
      //   130: ior
      //   131: putfield 92	com/google/d/n$l:bitField0_	I
      //   134: aload_0
      //   135: aload 5
      //   137: putfield 51	com/google/d/n$l:name_	Ljava/lang/Object;
      //   140: goto -117 -> 23
      //   143: astore_1
      //   144: aload_1
      //   145: aload_0
      //   146: putfield 96	com/google/d/bk:dST	Lcom/google/d/ce;
      //   149: aload_1
      //   150: athrow
      //   151: astore_1
      //   152: aload_0
      //   153: aload 6
      //   155: invokevirtual 102	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   158: putfield 106	com/google/d/n$l:unknownFields	Lcom/google/d/dn;
      //   161: aload_0
      //   162: invokevirtual 109	com/google/d/n$l:makeExtensionsImmutable	()V
      //   165: aload_1
      //   166: athrow
      //   167: aload_1
      //   168: invokevirtual 90	com/google/d/i:aak	()Lcom/google/d/h;
      //   171: astore 5
      //   173: aload_0
      //   174: aload_0
      //   175: getfield 92	com/google/d/n$l:bitField0_	I
      //   178: iconst_2
      //   179: ior
      //   180: putfield 92	com/google/d/n$l:bitField0_	I
      //   183: aload_0
      //   184: aload 5
      //   186: putfield 53	com/google/d/n$l:dNj	Ljava/lang/Object;
      //   189: goto -166 -> 23
      //   192: astore_1
      //   193: new 65	com/google/d/bk
      //   196: dup
      //   197: aload_1
      //   198: invokespecial 112	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   201: astore_1
      //   202: aload_1
      //   203: aload_0
      //   204: putfield 96	com/google/d/bk:dST	Lcom/google/d/ce;
      //   207: aload_1
      //   208: athrow
      //   209: aload_1
      //   210: invokevirtual 90	com/google/d/i:aak	()Lcom/google/d/h;
      //   213: astore 5
      //   215: aload_0
      //   216: aload_0
      //   217: getfield 92	com/google/d/n$l:bitField0_	I
      //   220: iconst_4
      //   221: ior
      //   222: putfield 92	com/google/d/n$l:bitField0_	I
      //   225: aload_0
      //   226: aload 5
      //   228: putfield 55	com/google/d/n$l:dNk	Ljava/lang/Object;
      //   231: goto -208 -> 23
      //   234: aload_0
      //   235: getfield 92	com/google/d/n$l:bitField0_	I
      //   238: bipush 8
      //   240: iand
      //   241: ifeq +126 -> 367
      //   244: aload_0
      //   245: getfield 114	com/google/d/n$l:dNl	Lcom/google/d/n$m;
      //   248: invokevirtual 120	com/google/d/n$m:afC	()Lcom/google/d/n$m$a;
      //   251: astore 5
      //   253: aload_0
      //   254: aload_1
      //   255: getstatic 121	com/google/d/n$m:PARSER	Lcom/google/d/cs;
      //   258: aload_2
      //   259: invokevirtual 124	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
      //   262: checkcast 116	com/google/d/n$m
      //   265: putfield 114	com/google/d/n$l:dNl	Lcom/google/d/n$m;
      //   268: aload 5
      //   270: ifnull +22 -> 292
      //   273: aload 5
      //   275: aload_0
      //   276: getfield 114	com/google/d/n$l:dNl	Lcom/google/d/n$m;
      //   279: invokevirtual 130	com/google/d/n$m$a:d	(Lcom/google/d/n$m;)Lcom/google/d/n$m$a;
      //   282: pop
      //   283: aload_0
      //   284: aload 5
      //   286: invokevirtual 134	com/google/d/n$m$a:afG	()Lcom/google/d/n$m;
      //   289: putfield 114	com/google/d/n$l:dNl	Lcom/google/d/n$m;
      //   292: aload_0
      //   293: aload_0
      //   294: getfield 92	com/google/d/n$l:bitField0_	I
      //   297: bipush 8
      //   299: ior
      //   300: putfield 92	com/google/d/n$l:bitField0_	I
      //   303: goto -280 -> 23
      //   306: aload_0
      //   307: aload_0
      //   308: getfield 92	com/google/d/n$l:bitField0_	I
      //   311: bipush 16
      //   313: ior
      //   314: putfield 92	com/google/d/n$l:bitField0_	I
      //   317: aload_0
      //   318: aload_1
      //   319: invokevirtual 138	com/google/d/i:aai	()Z
      //   322: putfield 140	com/google/d/n$l:dNm	Z
      //   325: goto -302 -> 23
      //   328: aload_0
      //   329: aload_0
      //   330: getfield 92	com/google/d/n$l:bitField0_	I
      //   333: bipush 32
      //   335: ior
      //   336: putfield 92	com/google/d/n$l:bitField0_	I
      //   339: aload_0
      //   340: aload_1
      //   341: invokevirtual 138	com/google/d/i:aai	()Z
      //   344: putfield 142	com/google/d/n$l:dNn	Z
      //   347: goto -324 -> 23
      //   350: aload_0
      //   351: aload 6
      //   353: invokevirtual 102	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   356: putfield 106	com/google/d/n$l:unknownFields	Lcom/google/d/dn;
      //   359: aload_0
      //   360: invokevirtual 109	com/google/d/n$l:makeExtensionsImmutable	()V
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
      //   0	384	0	this	l
      //   0	384	1	parami	i
      //   0	384	2	paramat	at
      //   22	359	3	i	int
      //   31	75	4	j	int
      //   122	247	5	localObject	Object
      //   19	333	6	locala	dn.a
      // Exception table:
      //   from	to	target	type
      //   27	33	143	com/google/d/bk
      //   100	113	143	com/google/d/bk
      //   118	140	143	com/google/d/bk
      //   167	189	143	com/google/d/bk
      //   209	231	143	com/google/d/bk
      //   234	253	143	com/google/d/bk
      //   253	268	143	com/google/d/bk
      //   273	292	143	com/google/d/bk
      //   292	303	143	com/google/d/bk
      //   306	325	143	com/google/d/bk
      //   328	347	143	com/google/d/bk
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
    
    private a afv()
    {
      if (this == dNo) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public static l afw()
    {
      return dNo;
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final boolean afo()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final String afp()
    {
      Object localObject = this.dNj;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dNj = str;
      }
      return str;
    }
    
    public final boolean afq()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final String afr()
    {
      Object localObject = this.dNk;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dNk = str;
      }
      return str;
    }
    
    public final n.m afs()
    {
      if (this.dNl == null) {
        return n.m.afD();
      }
      return this.dNl;
    }
    
    public final boolean aft()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final boolean afu()
    {
      return (this.bitField0_ & 0x20) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof l)) {
          return super.equals(paramObject);
        }
        paramObject = (l)paramObject;
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (afo() != paramObject.afo()) {
          return false;
        }
        if ((afo()) && (!afp().equals(paramObject.afp()))) {
          return false;
        }
        if (afq() != paramObject.afq()) {
          return false;
        }
        if ((afq()) && (!afr().equals(paramObject.afr()))) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!afs().equals(paramObject.afs()))) {
          return false;
        }
        if (aft() != paramObject.aft()) {
          return false;
        }
        if ((aft()) && (this.dNm != paramObject.dNm)) {
          return false;
        }
        if (afu() != paramObject.afu()) {
          return false;
        }
        if ((afu()) && (this.dNn != paramObject.dNn)) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<l> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = bg.computeStringSize(1, this.name_) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + bg.computeStringSize(2, this.dNj);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + bg.computeStringSize(3, this.dNk);
      }
      i = j;
      if ((this.bitField0_ & 0x8) != 0) {
        i = j + k.c(4, afs());
      }
      j = i;
      if ((this.bitField0_ & 0x10) != 0) {
        j = i + k.kn(5);
      }
      i = j;
      if ((this.bitField0_ & 0x20) != 0) {
        i = j + k.kn(6);
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abn().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (afo()) {
        j = (i * 37 + 2) * 53 + afp().hashCode();
      }
      i = j;
      if (afq()) {
        i = (j * 37 + 3) * 53 + afr().hashCode();
      }
      j = i;
      if (abT()) {
        j = (i * 37 + 4) * 53 + afs().hashCode();
      }
      i = j;
      if (aft()) {
        i = (j * 37 + 5) * 53 + bj.hashBoolean(this.dNm);
      }
      j = i;
      if (afu()) {
        j = (i * 37 + 6) * 53 + bj.hashBoolean(this.dNn);
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abo().b(l.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((abT()) && (!afs().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new l();
    }
    
    public final void writeTo(k paramk)
    {
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        bg.writeString(paramk, 2, this.dNj);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        bg.writeString(paramk, 3, this.dNk);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.a(4, afs());
      }
      if ((this.bitField0_ & 0x10) != 0) {
        paramk.I(5, this.dNm);
      }
      if ((this.bitField0_ & 0x20) != 0) {
        paramk.I(6, this.dNn);
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements ac
    {
      private int bitField0_;
      private df<n.m, n.m.a, ad> dKZ;
      private Object dNj = "";
      private Object dNk = "";
      private n.m dNl;
      private boolean dNm;
      private boolean dNn;
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a C(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a D(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a E(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a F(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a a(n.m paramm)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x8) != 0) && (this.dNl != null) && (this.dNl != n.m.afD()))
          {
            this.dNl = n.m.b(this.dNl).d(paramm).afG();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x8;
          return this;
          this.dNl = paramm;
          break;
          this.dKZ.c(paramm);
        }
      }
      
      private df<n.m, n.m.a, ad> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(afs(), getParentForChildren(), isClean());
          this.dNl = null;
        }
        return this.dKZ;
      }
      
      private n.m afs()
      {
        if (this.dKZ == null)
        {
          if (this.dNl == null) {
            return n.m.afD();
          }
          return this.dNl;
        }
        return (n.m)this.dKZ.ajm();
      }
      
      private a afx()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.dNj = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.dNk = "";
        this.bitField0_ &= 0xFFFFFFFB;
        if (this.dKZ == null) {
          this.dNl = null;
        }
        for (;;)
        {
          this.bitField0_ &= 0xFFFFFFF7;
          this.dNm = false;
          this.bitField0_ &= 0xFFFFFFEF;
          this.dNn = false;
          this.bitField0_ &= 0xFFFFFFDF;
          return this;
          this.dKZ.ajp();
        }
      }
      
      private n.l afy()
      {
        n.l locall = afz();
        if (!locall.isInitialized()) {
          throw newUninitializedMessageException(locall);
        }
        return locall;
      }
      
      private n.l afz()
      {
        int i = 0;
        n.l locall = new n.l(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        n.l.a(locall, this.name_);
        int j = i;
        if ((k & 0x2) != 0) {
          j = i | 0x2;
        }
        n.l.b(locall, this.dNj);
        if ((k & 0x4) != 0) {}
        for (i = j | 0x4;; i = j)
        {
          n.l.c(locall, this.dNk);
          if ((k & 0x8) != 0) {
            if (this.dKZ == null) {
              n.l.a(locall, this.dNl);
            }
          }
          for (j = i | 0x8;; j = i)
          {
            i = j;
            if ((k & 0x10) != 0)
            {
              n.l.a(locall, this.dNm);
              i = j | 0x10;
            }
            j = i;
            if ((k & 0x20) != 0)
            {
              n.l.b(locall, this.dNn);
              j = i | 0x20;
            }
            n.l.a(locall, j);
            onBuilt();
            return locall;
            n.l.a(locall, (n.m)this.dKZ.ajn());
            break;
          }
        }
      }
      
      private a cu(boolean paramBoolean)
      {
        this.bitField0_ |= 0x10;
        this.dNm = paramBoolean;
        onChanged();
        return this;
      }
      
      private a cv(boolean paramBoolean)
      {
        this.bitField0_ |= 0x20;
        this.dNn = paramBoolean;
        onChanged();
        return this;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          acn();
        }
      }
      
      private a o(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a o(cb paramcb)
      {
        if ((paramcb instanceof n.l)) {
          return d((n.l)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a o(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 209	com/google/d/n$l:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 215 3 0
        //   12: checkcast 9	com/google/d/n$l
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 198	com/google/d/n$l$a:d	(Lcom/google/d/n$l;)Lcom/google/d/n$l$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 219	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$l
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 223	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 198	com/google/d/n$l$a:d	(Lcom/google/d/n$l;)Lcom/google/d/n$l$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a p(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a s(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      public final a d(n.l paraml)
      {
        if (paraml == n.l.afw()) {
          return this;
        }
        if (paraml.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.l.a(paraml);
          onChanged();
        }
        if (paraml.afo())
        {
          this.bitField0_ |= 0x2;
          this.dNj = n.l.b(paraml);
          onChanged();
        }
        if (paraml.afq())
        {
          this.bitField0_ |= 0x4;
          this.dNk = n.l.c(paraml);
          onChanged();
        }
        if (paraml.abT()) {
          a(paraml.afs());
        }
        if (paraml.aft()) {
          cu(paraml.dNm);
        }
        if (paraml.afu()) {
          cv(paraml.dNn);
        }
        D(paraml.unknownFields);
        onChanged();
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abn();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abo().b(n.l.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        if ((this.bitField0_ & 0x8) != 0) {}
        for (int i = 1; (i != 0) && (!afs().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
  }
  
  public static final class m
    extends bg.d<m>
    implements ad
  {
    @Deprecated
    public static final cs<m> PARSER = new c() {};
    private static final m dNq = new m();
    private int bitField0_;
    boolean dLm;
    private List<n.s> dLn;
    private int dNp;
    private byte memoizedIsInitialized = -1;
    
    private m()
    {
      this.dNp = 0;
      this.dLn = Collections.emptyList();
    }
    
    private m(bg.c<m, ?> paramc)
    {
      super();
    }
    
    private m(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 264: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.dLm = parami.aai();
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              k = n;
              if ((k & 0x4) != 0) {
                this.dLn = Collections.unmodifiableList(this.dLn);
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            i1 = i;
            k = i;
            j = parami.aam();
            n = i;
            i1 = i;
            k = i;
            if (b.kY(j) == null)
            {
              n = i;
              i1 = i;
              k = i;
              locala.cR(34, j);
              break;
            }
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.dNp = j;
          }
          break;
          int j = i;
          if ((i & 0x4) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dLn = new ArrayList();
            j = i | 0x4;
          }
          n = j;
          i1 = j;
          k = j;
          this.dLn.add(parami.a(n.s.PARSER, paramat));
          i = j;
          break;
          if ((i & 0x4) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static m afD()
    {
      return dNq;
    }
    
    public static a b(m paramm)
    {
      return dNq.afC().d(paramm);
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean afA()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final b afB()
    {
      b localb2 = b.kY(this.dNp);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = b.dNr;
      }
      return localb1;
    }
    
    public final a afC()
    {
      if (this == dNq) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (afA() != paramObject.afA()) {
          return false;
        }
        if ((afA()) && (this.dNp != paramObject.dNp)) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<m> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int k = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (i = k.kn(33) + 0;; i = 0)
      {
        int j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.cM(34, this.dNp);
        }
        i = j;
        j = k;
        while (j < this.dLn.size())
        {
          k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        i = aie() + i + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abD().hashCode() + 779;
      int i = j;
      if (acT()) {
        i = (j * 37 + 33) * 53 + bj.hashBoolean(this.dLm);
      }
      j = i;
      if (afA()) {
        j = (i * 37 + 34) * 53 + this.dNp;
      }
      i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abE().b(m.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new m();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.I(33, this.dLm);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.cF(34, this.dNp);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.m, a>
      implements ad
    {
      private int bitField0_;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      private int dNp = 0;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a E(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a F(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a G(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a H(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      private a a(n.m.b paramb)
      {
        if (paramb == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x2;
        this.dNp = paramb.value;
        onChanged();
        return this;
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x4) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x4;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x4) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a afE()
      {
        super.adc();
        this.dLm = false;
        this.bitField0_ &= 0xFFFFFFFE;
        this.dNp = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.m afF()
      {
        n.m localm = afG();
        if (!localm.isInitialized()) {
          throw newUninitializedMessageException(localm);
        }
        return localm;
      }
      
      private a cw(boolean paramBoolean)
      {
        this.bitField0_ |= 0x1;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a p(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a p(cb paramcb)
      {
        if ((paramcb instanceof n.m)) {
          return d((n.m)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a p(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 161	com/google/d/n$m:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 167 3 0
        //   12: checkcast 9	com/google/d/n$m
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 150	com/google/d/n$m$a:d	(Lcom/google/d/n$m;)Lcom/google/d/n$m$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 171	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$m
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 175	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 150	com/google/d/n$m$a:d	(Lcom/google/d/n$m;)Lcom/google/d/n$m$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a q(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a t(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      public final n.m afG()
      {
        int i = 0;
        n.m localm = new n.m(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0)
        {
          n.m.a(localm, this.dLm);
          i = 1;
        }
        int j = i;
        if ((k & 0x2) != 0) {
          j = i | 0x2;
        }
        n.m.a(localm, this.dNp);
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x4) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFFB;
          }
          n.m.a(localm, this.dLn);
        }
        for (;;)
        {
          n.m.b(localm, j);
          onBuilt();
          return localm;
          n.m.a(localm, this.dLp.build());
        }
      }
      
      public final a d(n.m paramm)
      {
        da localda = null;
        if (paramm == n.m.afD()) {
          return this;
        }
        if (paramm.acT()) {
          cw(paramm.dLm);
        }
        if (paramm.afA()) {
          a(paramm.afB());
        }
        if (this.dLp == null) {
          if (!n.m.c(paramm).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label117;
            }
            this.dLn = n.m.c(paramm);
            this.bitField0_ &= 0xFFFFFFFB;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramm);
          F(paramm.unknownFields);
          onChanged();
          return this;
          label117:
          ada();
          this.dLn.addAll(n.m.c(paramm));
          break;
          if (!n.m.c(paramm).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.m.c(paramm);
              this.bitField0_ &= 0xFFFFFFFB;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.m.c(paramm));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abD();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abE().b(n.m.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
    
    public static enum b
      implements cw
    {
      private static final bj.d<b> dLG = new bj.d() {};
      private static final b[] dNu = values();
      final int value;
      
      private b(int paramInt)
      {
        this.value = paramInt;
      }
      
      @Deprecated
      public static b kY(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 0: 
          return dNr;
        case 1: 
          return dNs;
        }
        return dNt;
      }
      
      public final int getNumber()
      {
        return this.value;
      }
    }
  }
  
  public static final class n
    extends bg
    implements ae
  {
    @Deprecated
    public static final cs<n> PARSER = new c() {};
    private static final n dNx = new n();
    private int bitField0_;
    private n.o dNw;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private n()
    {
      this.name_ = "";
    }
    
    private n(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private n(i parami, at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 33	com/google/d/n$n:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 60	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 61	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 67	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   19: astore 6
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +198 -> 222
      //   27: aload_1
      //   28: invokevirtual 73	com/google/d/i:aac	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+210->245, 0:+216->251, 10:+51->86, 18:+100->135
      //   69: aload_1
      //   70: aload 6
      //   72: aload_2
      //   73: iload 4
      //   75: invokevirtual 77	com/google/d/n$n:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   78: ifne +158 -> 236
      //   81: iconst_1
      //   82: istore_3
      //   83: goto +165 -> 248
      //   86: aload_1
      //   87: invokevirtual 81	com/google/d/i:aak	()Lcom/google/d/h;
      //   90: astore 5
      //   92: aload_0
      //   93: aload_0
      //   94: getfield 83	com/google/d/n$n:bitField0_	I
      //   97: iconst_1
      //   98: ior
      //   99: putfield 83	com/google/d/n$n:bitField0_	I
      //   102: aload_0
      //   103: aload 5
      //   105: putfield 46	com/google/d/n$n:name_	Ljava/lang/Object;
      //   108: goto -85 -> 23
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
      //   117: aload_1
      //   118: athrow
      //   119: astore_1
      //   120: aload_0
      //   121: aload 6
      //   123: invokevirtual 93	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   126: putfield 97	com/google/d/n$n:unknownFields	Lcom/google/d/dn;
      //   129: aload_0
      //   130: invokevirtual 100	com/google/d/n$n:makeExtensionsImmutable	()V
      //   133: aload_1
      //   134: athrow
      //   135: aload_0
      //   136: getfield 83	com/google/d/n$n:bitField0_	I
      //   139: iconst_2
      //   140: iand
      //   141: ifeq +98 -> 239
      //   144: aload_0
      //   145: getfield 102	com/google/d/n$n:dNw	Lcom/google/d/n$o;
      //   148: invokevirtual 108	com/google/d/n$o:afN	()Lcom/google/d/n$o$a;
      //   151: astore 5
      //   153: aload_0
      //   154: aload_1
      //   155: getstatic 109	com/google/d/n$o:PARSER	Lcom/google/d/cs;
      //   158: aload_2
      //   159: invokevirtual 112	com/google/d/i:a	(Lcom/google/d/cs;Lcom/google/d/at;)Lcom/google/d/ce;
      //   162: checkcast 104	com/google/d/n$o
      //   165: putfield 102	com/google/d/n$n:dNw	Lcom/google/d/n$o;
      //   168: aload 5
      //   170: ifnull +22 -> 192
      //   173: aload 5
      //   175: aload_0
      //   176: getfield 102	com/google/d/n$n:dNw	Lcom/google/d/n$o;
      //   179: invokevirtual 118	com/google/d/n$o$a:d	(Lcom/google/d/n$o;)Lcom/google/d/n$o$a;
      //   182: pop
      //   183: aload_0
      //   184: aload 5
      //   186: invokevirtual 122	com/google/d/n$o$a:afR	()Lcom/google/d/n$o;
      //   189: putfield 102	com/google/d/n$n:dNw	Lcom/google/d/n$o;
      //   192: aload_0
      //   193: aload_0
      //   194: getfield 83	com/google/d/n$n:bitField0_	I
      //   197: iconst_2
      //   198: ior
      //   199: putfield 83	com/google/d/n$n:bitField0_	I
      //   202: goto -179 -> 23
      //   205: astore_1
      //   206: new 56	com/google/d/bk
      //   209: dup
      //   210: aload_1
      //   211: invokespecial 125	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   214: astore_1
      //   215: aload_1
      //   216: aload_0
      //   217: putfield 87	com/google/d/bk:dST	Lcom/google/d/ce;
      //   220: aload_1
      //   221: athrow
      //   222: aload_0
      //   223: aload 6
      //   225: invokevirtual 93	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   228: putfield 97	com/google/d/n$n:unknownFields	Lcom/google/d/dn;
      //   231: aload_0
      //   232: invokevirtual 100	com/google/d/n$n:makeExtensionsImmutable	()V
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
      //   0	256	1	parami	i
      //   0	256	2	paramat	at
      //   22	231	3	i	int
      //   31	43	4	j	int
      //   90	151	5	localObject	Object
      //   19	205	6	locala	dn.a
      // Exception table:
      //   from	to	target	type
      //   27	33	111	com/google/d/bk
      //   68	81	111	com/google/d/bk
      //   86	108	111	com/google/d/bk
      //   135	153	111	com/google/d/bk
      //   153	168	111	com/google/d/bk
      //   173	192	111	com/google/d/bk
      //   192	202	111	com/google/d/bk
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
    
    private a afI()
    {
      if (this == dNx) {
        return new a((byte)0);
      }
      return new a((byte)0).b(this);
    }
    
    public static n afJ()
    {
      return dNx;
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final n.o afH()
    {
      if (this.dNw == null) {
        return n.o.afO();
      }
      return this.dNw;
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
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!afH().equals(paramObject.afH()))) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<n> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        i = bg.computeStringSize(1, this.name_) + 0;
      }
      int j = i;
      if ((this.bitField0_ & 0x2) != 0) {
        j = i + k.c(2, afH());
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abd().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (abT()) {
        j = (i * 37 + 2) * 53 + afH().hashCode();
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abe().b(n.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if ((abT()) && (!afH().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new n();
    }
    
    public final void writeTo(k paramk)
    {
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.a(2, afH());
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements ae
    {
      private int bitField0_;
      private df<n.o, n.o.a, af> dKZ;
      private n.o dNw;
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a G(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a H(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a I(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a J(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a a(n.o paramo)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x2) != 0) && (this.dNw != null) && (this.dNw != n.o.afO()))
          {
            this.dNw = n.o.b(this.dNw).d(paramo).afR();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x2;
          return this;
          this.dNw = paramo;
          break;
          this.dKZ.c(paramo);
        }
      }
      
      private df<n.o, n.o.a, af> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(afH(), getParentForChildren(), isClean());
          this.dNw = null;
        }
        return this.dKZ;
      }
      
      private n.o afH()
      {
        if (this.dKZ == null)
        {
          if (this.dNw == null) {
            return n.o.afO();
          }
          return this.dNw;
        }
        return (n.o)this.dKZ.ajm();
      }
      
      private a afK()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.dKZ == null) {
          this.dNw = null;
        }
        for (;;)
        {
          this.bitField0_ &= 0xFFFFFFFD;
          return this;
          this.dKZ.ajp();
        }
      }
      
      private n.n afL()
      {
        n.n localn = afM();
        if (!localn.isInitialized()) {
          throw newUninitializedMessageException(localn);
        }
        return localn;
      }
      
      private n.n afM()
      {
        n.n localn = new n.n(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          n.n.a(localn, this.name_);
          int j = i;
          if ((k & 0x2) != 0)
          {
            if (this.dKZ != null) {
              break label77;
            }
            n.n.a(localn, this.dNw);
          }
          for (;;)
          {
            j = i | 0x2;
            n.n.a(localn, j);
            onBuilt();
            return localn;
            label77:
            n.n.a(localn, (n.o)this.dKZ.ajn());
          }
        }
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          acn();
        }
      }
      
      private a q(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a q(cb paramcb)
      {
        if ((paramcb instanceof n.n)) {
          return b((n.n)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a q(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 184	com/google/d/n$n:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 190 3 0
        //   12: checkcast 9	com/google/d/n$n
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 173	com/google/d/n$n$a:b	(Lcom/google/d/n$n;)Lcom/google/d/n$n$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 194	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$n
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 198	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 173	com/google/d/n$n$a:b	(Lcom/google/d/n$n;)Lcom/google/d/n$n$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a r(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a u(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      public final a b(n.n paramn)
      {
        if (paramn == n.n.afJ()) {
          return this;
        }
        if (paramn.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.n.a(paramn);
          onChanged();
        }
        if (paramn.abT()) {
          a(paramn.afH());
        }
        H(paramn.unknownFields);
        onChanged();
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abd();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abe().b(n.n.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        if ((this.bitField0_ & 0x2) != 0) {}
        for (int i = 1; (i != 0) && (!afH().isInitialized()); i = 0) {
          return false;
        }
        return true;
      }
    }
  }
  
  public static final class o
    extends bg.d<o>
    implements af
  {
    @Deprecated
    public static final cs<o> PARSER = new c() {};
    private static final o dNy = new o();
    private List<n.s> dLn;
    private byte memoizedIsInitialized = -1;
    
    private o()
    {
      this.dLn = Collections.emptyList();
    }
    
    private o(bg.c<o, ?> paramc)
    {
      super();
    }
    
    private o(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
          j = parami.aac();
          switch (j)
          {
          }
        }
        catch (bk parami)
        {
          try
          {
            int j;
            parami.dST = this;
            throw parami;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.dLn = Collections.unmodifiableList(this.dLn);
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          throw parami;
          if ((i & 0x1) == 0) {
            break label237;
          }
          this.dLn = Collections.unmodifiableList(this.dLn);
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        catch (IOException parami)
        {
          k = i1;
          parami = new bk(parami);
          k = i1;
          parami.dST = this;
          k = i1;
          throw parami;
        }
        finally
        {
          for (;;) {}
          m = 1;
        }
        n = i;
        i1 = i;
        k = i;
        if (!parseUnknownField(parami, locala, paramat, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dLn = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.dLn.add(parami.a(n.s.PARSER, paramat));
          i = j;
        }
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static o afO()
    {
      return dNy;
    }
    
    public static a b(o paramo)
    {
      return dNy.afN().d(paramo);
    }
    
    public final a afN()
    {
      if (this == dNy) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<o> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.dLn.size())
      {
        j += k.c(999, (ce)this.dLn.get(i));
        i += 1;
      }
      i = aie() + j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abv().hashCode() + 779;
      int i = j;
      if (acU() > 0) {
        i = (j * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(i, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abw().b(o.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new o();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.o, a>
      implements af
    {
      private int bitField0_;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a I(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a J(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a K(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a L(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x1) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x1;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a afP()
      {
        super.adc();
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFE;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.o afQ()
      {
        n.o localo = afR();
        if (!localo.isInitialized()) {
          throw newUninitializedMessageException(localo);
        }
        return localo;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a r(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a r(cb paramcb)
      {
        if ((paramcb instanceof n.o)) {
          return d((n.o)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a r(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 141	com/google/d/n$o:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 147 3 0
        //   12: checkcast 9	com/google/d/n$o
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 130	com/google/d/n$o$a:d	(Lcom/google/d/n$o;)Lcom/google/d/n$o$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 151	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$o
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 155	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 130	com/google/d/n$o$a:d	(Lcom/google/d/n$o;)Lcom/google/d/n$o$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a s(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a v(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      public final n.o afR()
      {
        n.o localo = new n.o(this, (byte)0);
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x1) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFFE;
          }
          n.o.a(localo, this.dLn);
        }
        for (;;)
        {
          onBuilt();
          return localo;
          n.o.a(localo, this.dLp.build());
        }
      }
      
      public final a d(n.o paramo)
      {
        da localda = null;
        if (paramo == n.o.afO()) {
          return this;
        }
        if (this.dLp == null) {
          if (!n.o.c(paramo).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label85;
            }
            this.dLn = n.o.c(paramo);
            this.bitField0_ &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramo);
          J(paramo.unknownFields);
          onChanged();
          return this;
          label85:
          ada();
          this.dLn.addAll(n.o.c(paramo));
          break;
          if (!n.o.c(paramo).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.o.c(paramo);
              this.bitField0_ &= 0xFFFFFFFE;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.o.c(paramo));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abv();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abw().b(n.o.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class p
    extends bg
    implements ag
  {
    @Deprecated
    public static final cs<p> PARSER = new c() {};
    private static final p dNB = new p();
    private int bitField0_;
    private n.q dNA;
    private List<n.l> dNz;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    
    private p()
    {
      this.name_ = "";
      this.dNz = Collections.emptyList();
    }
    
    private p(bg.a<?> parama)
    {
      super();
    }
    
    private p(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 10: 
              n = i;
              i1 = i;
              m = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label476;
              }
              j = 1;
              break label492;
              n = i;
              i1 = i;
              m = i;
              localObject = parami.aak();
              n = i;
              i1 = i;
              m = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              m = i;
              this.name_ = localObject;
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              m = n;
              if ((m & 0x2) != 0) {
                this.dNz = Collections.unmodifiableList(this.dNz);
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              m = i;
              this.dNz = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            m = j;
            this.dNz.add(parami.a(n.l.PARSER, paramat));
            i = j;
            break;
          }
          catch (IOException parami)
          {
            m = i1;
            parami = new bk(parami);
            m = i1;
            parami.dST = this;
            m = i1;
            throw parami;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            m = i;
            if ((this.bitField0_ & 0x2) == 0) {
              break label483;
            }
          }
          n = i;
          i1 = i;
          m = i;
          label476:
          label483:
          for (Object localObject = this.dNA.agb();; localObject = null)
          {
            n = i;
            i1 = i;
            m = i;
            this.dNA = ((n.q)parami.a(n.q.PARSER, paramat));
            if (localObject != null)
            {
              n = i;
              i1 = i;
              m = i;
              ((n.q.a)localObject).d(this.dNA);
              n = i;
              i1 = i;
              m = i;
              this.dNA = ((n.q.a)localObject).agf();
            }
            n = i;
            i1 = i;
            m = i;
            this.bitField0_ |= 0x2;
            break;
            if ((i & 0x2) != 0) {
              this.dNz = Collections.unmodifiableList(this.dNz);
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
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
    
    private a afU()
    {
      if (this == dNB) {
        return new a((byte)0);
      }
      return new a((byte)0).c(this);
    }
    
    public static p afV()
    {
      return dNB;
    }
    
    public final boolean abT()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final int afS()
    {
      return this.dNz.size();
    }
    
    public final n.q afT()
    {
      if (this.dNA == null) {
        return n.q.agc();
      }
      return this.dNA;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof p)) {
          return super.equals(paramObject);
        }
        paramObject = (p)paramObject;
        if (hasName() != paramObject.hasName()) {
          return false;
        }
        if ((hasName()) && (!getName().equals(paramObject.getName()))) {
          return false;
        }
        if (!this.dNz.equals(paramObject.dNz)) {
          return false;
        }
        if (abT() != paramObject.abT()) {
          return false;
        }
        if ((abT()) && (!afT().equals(paramObject.afT()))) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final String getName()
    {
      Object localObject = this.name_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      return str;
    }
    
    public final cs<p> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int j = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {
        i = bg.computeStringSize(1, this.name_) + 0;
      }
      for (;;)
      {
        if (j < this.dNz.size())
        {
          int k = k.c(2, (ce)this.dNz.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          j = i;
          if ((this.bitField0_ & 0x2) != 0) {
            j = i + k.c(3, afT());
          }
          i = this.unknownFields.getSerializedSize() + j;
          this.memoizedSize = i;
          return i;
          i = 0;
        }
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abl().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (afS() > 0) {
        j = (i * 37 + 2) * 53 + this.dNz.hashCode();
      }
      i = j;
      if (abT()) {
        i = (j * 37 + 3) * 53 + afT().hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abm().b(p.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < afS())
      {
        if (!kZ(i).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if ((abT()) && (!afT().isInitialized()))
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final n.l kZ(int paramInt)
    {
      return (n.l)this.dNz.get(paramInt);
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new p();
    }
    
    public final void writeTo(k paramk)
    {
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      int i = 0;
      while (i < this.dNz.size())
      {
        paramk.a(2, (ce)this.dNz.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.a(3, afT());
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements ag
    {
      private int bitField0_;
      private df<n.q, n.q.a, ah> dKZ;
      private n.q dNA;
      private da<n.l, n.l.a, ac> dNC;
      private List<n.l> dNz = Collections.emptyList();
      private Object name_ = "";
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a K(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a L(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a M(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a N(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a a(n.q paramq)
      {
        if (this.dKZ == null) {
          if (((this.bitField0_ & 0x4) != 0) && (this.dNA != null) && (this.dNA != n.q.agc()))
          {
            this.dNA = n.q.b(this.dNA).d(paramq).agf();
            onChanged();
          }
        }
        for (;;)
        {
          this.bitField0_ |= 0x4;
          return this;
          this.dNA = paramq;
          break;
          this.dKZ.c(paramq);
        }
      }
      
      private df<n.q, n.q.a, ah> acn()
      {
        if (this.dKZ == null)
        {
          this.dKZ = new df(afT(), getParentForChildren(), isClean());
          this.dNA = null;
        }
        return this.dKZ;
      }
      
      private n.q afT()
      {
        if (this.dKZ == null)
        {
          if (this.dNA == null) {
            return n.q.agc();
          }
          return this.dNA;
        }
        return (n.q)this.dKZ.ajm();
      }
      
      private a afW()
      {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.dNC == null)
        {
          this.dNz = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFD;
          if (this.dKZ != null) {
            break label82;
          }
          this.dNA = null;
        }
        for (;;)
        {
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
          this.dNC.clear();
          break;
          label82:
          this.dKZ.ajp();
        }
      }
      
      private n.p afX()
      {
        n.p localp = afY();
        if (!localp.isInitialized()) {
          throw newUninitializedMessageException(localp);
        }
        return localp;
      }
      
      private n.p afY()
      {
        n.p localp = new n.p(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {}
        for (int i = 1;; i = 0)
        {
          n.p.a(localp, this.name_);
          int j;
          if (this.dNC == null)
          {
            if ((this.bitField0_ & 0x2) != 0)
            {
              this.dNz = Collections.unmodifiableList(this.dNz);
              this.bitField0_ &= 0xFFFFFFFD;
            }
            n.p.a(localp, this.dNz);
            j = i;
            if ((k & 0x4) != 0)
            {
              if (this.dKZ != null) {
                break label141;
              }
              n.p.a(localp, this.dNA);
            }
          }
          for (;;)
          {
            j = i | 0x2;
            n.p.a(localp, j);
            onBuilt();
            return localp;
            n.p.a(localp, this.dNC.build());
            break;
            label141:
            n.p.a(localp, (n.q)this.dKZ.ajn());
          }
        }
      }
      
      private void afZ()
      {
        if ((this.bitField0_ & 0x2) == 0)
        {
          this.dNz = new ArrayList(this.dNz);
          this.bitField0_ |= 0x2;
        }
      }
      
      private da<n.l, n.l.a, ac> aga()
      {
        List localList;
        if (this.dNC == null)
        {
          localList = this.dNz;
          if ((this.bitField0_ & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dNC = new da(localList, bool, getParentForChildren(), isClean());
          this.dNz = null;
          return this.dNC;
        }
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders)
        {
          aga();
          acn();
        }
      }
      
      private a s(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a s(cb paramcb)
      {
        if ((paramcb instanceof n.p)) {
          return c((n.p)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a s(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 229	com/google/d/n$p:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 235 3 0
        //   12: checkcast 9	com/google/d/n$p
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 218	com/google/d/n$p$a:c	(Lcom/google/d/n$p;)Lcom/google/d/n$p$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 239	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$p
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 243	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 218	com/google/d/n$p$a:c	(Lcom/google/d/n$p;)Lcom/google/d/n$p$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a t(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a w(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      public final a c(n.p paramp)
      {
        da localda = null;
        if (paramp == n.p.afV()) {
          return this;
        }
        if (paramp.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = n.p.a(paramp);
          onChanged();
        }
        if (this.dNC == null) {
          if (!n.p.b(paramp).isEmpty())
          {
            if (!this.dNz.isEmpty()) {
              break label125;
            }
            this.dNz = n.p.b(paramp);
            this.bitField0_ &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          if (paramp.abT()) {
            a(paramp.afT());
          }
          L(paramp.unknownFields);
          onChanged();
          return this;
          label125:
          afZ();
          this.dNz.addAll(n.p.b(paramp));
          break;
          if (!n.p.b(paramp).isEmpty()) {
            if (this.dNC.isEmpty())
            {
              this.dNC.dUC = null;
              this.dNC = null;
              this.dNz = n.p.b(paramp);
              this.bitField0_ &= 0xFFFFFFFD;
              if (bg.alwaysUseFieldBuilders) {
                localda = aga();
              }
              this.dNC = localda;
            }
            else
            {
              this.dNC.a(n.p.b(paramp));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abl();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abm().b(n.p.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        label19:
        n.l locall;
        if (this.dNC == null)
        {
          j = this.dNz.size();
          if (i >= j) {
            break label88;
          }
          if (this.dNC != null) {
            break label65;
          }
          locall = (n.l)this.dNz.get(i);
          label45:
          if (locall.isInitialized()) {
            break label81;
          }
        }
        for (;;)
        {
          return false;
          j = this.dNC.getCount();
          break label19;
          label65:
          locall = (n.l)this.dNC.J(i, false);
          break label45;
          label81:
          i += 1;
          break;
          label88:
          if ((this.bitField0_ & 0x4) != 0) {}
          for (i = 1; (i == 0) || (afT().isInitialized()); i = 0) {
            return true;
          }
        }
      }
    }
  }
  
  public static final class q
    extends bg.d<q>
    implements ah
  {
    @Deprecated
    public static final cs<q> PARSER = new c() {};
    private static final q dND = new q();
    private int bitField0_;
    boolean dLm;
    private List<n.s> dLn;
    private byte memoizedIsInitialized = -1;
    
    private q()
    {
      this.dLn = Collections.emptyList();
    }
    
    private q(bg.c<q, ?> paramc)
    {
      super();
    }
    
    private q(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            j = parami.aac();
            switch (j)
            {
            case 264: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
                break label26;
              }
              m = 1;
              break label26;
              n = i;
              i1 = i;
              k = i;
              this.bitField0_ |= 0x1;
              n = i;
              i1 = i;
              k = i;
              this.dLm = parami.aai();
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally {}
            if ((k & 0x2) != 0) {
              this.dLn = Collections.unmodifiableList(this.dLn);
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
            throw parami;
            int j = i;
            if ((i & 0x2) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.dLn = new ArrayList();
              j = i | 0x2;
            }
            n = j;
            i1 = j;
            k = j;
            this.dLn.add(parami.a(n.s.PARSER, paramat));
            i = j;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
          }
          if ((i & 0x2) != 0) {
            this.dLn = Collections.unmodifiableList(this.dLn);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private int acU()
    {
      return this.dLn.size();
    }
    
    public static q agc()
    {
      return dND;
    }
    
    public static a b(q paramq)
    {
      return dND.agb().d(paramq);
    }
    
    public final boolean acT()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final a agb()
    {
      if (this == dND) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (acT() != paramObject.acT()) {
          return false;
        }
        if ((acT()) && (this.dLm != paramObject.dLm)) {
          return false;
        }
        if (!this.dLn.equals(paramObject.dLn)) {
          return false;
        }
        if (!this.unknownFields.equals(paramObject.unknownFields)) {
          return false;
        }
      } while (aif().equals(paramObject.aif()));
      return false;
    }
    
    public final cs<q> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int j = 0;
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {
        i = k.kn(33) + 0;
      }
      for (;;)
      {
        if (j < this.dLn.size())
        {
          int k = k.c(999, (ce)this.dLn.get(j));
          j += 1;
          i = k + i;
        }
        else
        {
          i = aie() + i + this.unknownFields.getSerializedSize();
          this.memoizedSize = i;
          return i;
          i = 0;
        }
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abB().hashCode() + 779;
      int i = j;
      if (acT()) {
        i = (j * 37 + 33) * 53 + bj.hashBoolean(this.dLm);
      }
      j = i;
      if (acU() > 0) {
        j = (i * 37 + 999) * 53 + this.dLn.hashCode();
      }
      i = hashFields(j, aif()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abC().b(q.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < acU())
      {
        if (!((n.s)this.dLn.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      if (!aic())
      {
        this.memoizedIsInitialized = 0;
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new q();
    }
    
    public final void writeTo(k paramk)
    {
      bg.d.a locala = aid();
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.I(33, this.dLm);
      }
      int i = 0;
      while (i < this.dLn.size())
      {
        paramk.a(999, (ce)this.dLn.get(i));
        i += 1;
      }
      locala.a(paramk);
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.c<n.q, a>
      implements ah
    {
      private int bitField0_;
      private boolean dLm;
      private List<n.s> dLn = Collections.emptyList();
      private da<n.s, n.s.a, al> dLp;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a M(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a N(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a O(am.f paramf, Object paramObject)
      {
        return (a)super.n(paramf, paramObject);
      }
      
      private a P(am.f paramf, Object paramObject)
      {
        return (a)super.m(paramf, paramObject);
      }
      
      private void ada()
      {
        if ((this.bitField0_ & 0x2) == 0)
        {
          this.dLn = new ArrayList(this.dLn);
          this.bitField0_ |= 0x2;
        }
      }
      
      private da<n.s, n.s.a, al> adb()
      {
        List localList;
        if (this.dLp == null)
        {
          localList = this.dLn;
          if ((this.bitField0_ & 0x2) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dLp = new da(localList, bool, getParentForChildren(), isClean());
          this.dLn = null;
          return this.dLp;
        }
      }
      
      private a agd()
      {
        super.adc();
        this.dLm = false;
        this.bitField0_ &= 0xFFFFFFFE;
        if (this.dLp == null)
        {
          this.dLn = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFD;
          return this;
        }
        this.dLp.clear();
        return this;
      }
      
      private n.q age()
      {
        n.q localq = agf();
        if (!localq.isInitialized()) {
          throw newUninitializedMessageException(localq);
        }
        return localq;
      }
      
      private a cx(boolean paramBoolean)
      {
        this.bitField0_ |= 0x1;
        this.dLm = paramBoolean;
        onChanged();
        return this;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          adb();
        }
      }
      
      private a t(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a t(cb paramcb)
      {
        if ((paramcb instanceof n.q)) {
          return d((n.q)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a t(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 150	com/google/d/n$q:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 156 3 0
        //   12: checkcast 9	com/google/d/n$q
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 139	com/google/d/n$q$a:d	(Lcom/google/d/n$q;)Lcom/google/d/n$q$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 160	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$q
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 164	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 139	com/google/d/n$q$a:d	(Lcom/google/d/n$q;)Lcom/google/d/n$q$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a u(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.g(paramf, paramInt, paramObject);
      }
      
      private a x(am.f paramf)
      {
        return (a)super.j(paramf);
      }
      
      public final n.q agf()
      {
        int i = 0;
        n.q localq = new n.q(this, (byte)0);
        if ((this.bitField0_ & 0x1) != 0)
        {
          n.q.a(localq, this.dLm);
          i = 1;
        }
        if (this.dLp == null)
        {
          if ((this.bitField0_ & 0x2) != 0)
          {
            this.dLn = Collections.unmodifiableList(this.dLn);
            this.bitField0_ &= 0xFFFFFFFD;
          }
          n.q.a(localq, this.dLn);
        }
        for (;;)
        {
          n.q.a(localq, i);
          onBuilt();
          return localq;
          n.q.a(localq, this.dLp.build());
        }
      }
      
      public final a d(n.q paramq)
      {
        da localda = null;
        if (paramq == n.q.agc()) {
          return this;
        }
        if (paramq.acT()) {
          cx(paramq.dLm);
        }
        if (this.dLp == null) {
          if (!n.q.c(paramq).isEmpty())
          {
            if (!this.dLn.isEmpty()) {
              break label101;
            }
            this.dLn = n.q.c(paramq);
            this.bitField0_ &= 0xFFFFFFFD;
            onChanged();
          }
        }
        for (;;)
        {
          a(paramq);
          N(paramq.unknownFields);
          onChanged();
          return this;
          label101:
          ada();
          this.dLn.addAll(n.q.c(paramq));
          break;
          if (!n.q.c(paramq).isEmpty()) {
            if (this.dLp.isEmpty())
            {
              this.dLp.dUC = null;
              this.dLp = null;
              this.dLn = n.q.c(paramq);
              this.bitField0_ &= 0xFFFFFFFD;
              if (bg.alwaysUseFieldBuilders) {
                localda = adb();
              }
              this.dLp = localda;
            }
            else
            {
              this.dLp.a(n.q.c(paramq));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abB();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abC().b(n.q.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        int j;
        if (this.dLp == null)
        {
          j = this.dLn.size();
          if (i >= j) {
            break label88;
          }
          if (this.dLp != null) {
            break label65;
          }
          locals = (n.s)this.dLn.get(i);
          if (locals.isInitialized()) {
            break label81;
          }
        }
        label65:
        label81:
        label88:
        while (!aic())
        {
          for (;;)
          {
            return false;
            j = this.dLp.getCount();
            break;
            n.s locals = (n.s)this.dLp.J(i, false);
          }
          i += 1;
          break;
        }
        return true;
      }
    }
  }
  
  public static final class r
    extends bg
    implements aj
  {
    @Deprecated
    public static final cs<r> PARSER = new c() {};
    private static final r dNF = new r();
    private List<b> dNE;
    private byte memoizedIsInitialized = -1;
    
    private r()
    {
      this.dNE = Collections.emptyList();
    }
    
    private r(bg.a<?> parama)
    {
      super();
    }
    
    private r(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
          j = parami.aac();
          switch (j)
          {
          }
        }
        catch (bk parami)
        {
          try
          {
            int j;
            parami.dST = this;
            throw parami;
          }
          finally {}
          if ((k & 0x1) == 0) {
            break label205;
          }
          this.dNE = Collections.unmodifiableList(this.dNE);
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          throw parami;
          if ((i & 0x1) == 0) {
            break label237;
          }
          this.dNE = Collections.unmodifiableList(this.dNE);
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        catch (IOException parami)
        {
          k = i1;
          parami = new bk(parami);
          k = i1;
          parami.dST = this;
          k = i1;
          throw parami;
        }
        finally
        {
          for (;;) {}
          m = 1;
        }
        n = i;
        i1 = i;
        k = i;
        if (!parseUnknownField(parami, locala, paramat, j))
        {
          m = 1;
          continue;
          j = i;
          if ((i & 0x1) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.dNE = new ArrayList();
            j = i | 0x1;
          }
          n = j;
          i1 = j;
          k = j;
          this.dNE.add(parami.a(b.PARSER, paramat));
          i = j;
        }
      }
    }
    
    public static r agh()
    {
      return dNF;
    }
    
    public static a b(r paramr)
    {
      return dNF.agg().d(paramr);
    }
    
    public final a agg()
    {
      if (this == dNF) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
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
        if (!this.dNE.equals(paramObject.dNE)) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final cs<r> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      int j = 0;
      while (i < this.dNE.size())
      {
        j += k.c(1, (ce)this.dNE.get(i));
        i += 1;
      }
      i = this.unknownFields.getSerializedSize() + j;
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abJ().hashCode() + 779;
      int i = j;
      if (this.dNE.size() > 0) {
        i = (j * 37 + 1) * 53 + this.dNE.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abK().b(r.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new r();
    }
    
    public final void writeTo(k paramk)
    {
      int i = 0;
      while (i < this.dNE.size())
      {
        paramk.a(1, (ce)this.dNE.get(i));
        i += 1;
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements aj
    {
      private int bitField0_;
      private List<n.r.b> dNE = Collections.emptyList();
      private da<n.r.b, n.r.b.a, ai> dNG;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a O(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a P(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a Q(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a R(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a agi()
      {
        super.clear();
        if (this.dNG == null)
        {
          this.dNE = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFE;
          return this;
        }
        this.dNG.clear();
        return this;
      }
      
      private n.r agj()
      {
        n.r localr = agk();
        if (!localr.isInitialized()) {
          throw newUninitializedMessageException(localr);
        }
        return localr;
      }
      
      private void agl()
      {
        if ((this.bitField0_ & 0x1) == 0)
        {
          this.dNE = new ArrayList(this.dNE);
          this.bitField0_ |= 0x1;
        }
      }
      
      private da<n.r.b, n.r.b.a, ai> agm()
      {
        List localList;
        if (this.dNG == null)
        {
          localList = this.dNE;
          if ((this.bitField0_ & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dNG = new da(localList, bool, getParentForChildren(), isClean());
          this.dNE = null;
          return this.dNG;
        }
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          agm();
        }
      }
      
      private a u(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a u(cb paramcb)
      {
        if ((paramcb instanceof n.r)) {
          return d((n.r)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a u(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 141	com/google/d/n$r:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 147 3 0
        //   12: checkcast 9	com/google/d/n$r
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 130	com/google/d/n$r$a:d	(Lcom/google/d/n$r;)Lcom/google/d/n$r$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 151	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$r
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 155	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 130	com/google/d/n$r$a:d	(Lcom/google/d/n$r;)Lcom/google/d/n$r$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a v(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      private a y(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      public final n.r agk()
      {
        n.r localr = new n.r(this, (byte)0);
        if (this.dNG == null)
        {
          if ((this.bitField0_ & 0x1) != 0)
          {
            this.dNE = Collections.unmodifiableList(this.dNE);
            this.bitField0_ &= 0xFFFFFFFE;
          }
          n.r.a(localr, this.dNE);
        }
        for (;;)
        {
          onBuilt();
          return localr;
          n.r.a(localr, this.dNG.build());
        }
      }
      
      public final a d(n.r paramr)
      {
        da localda = null;
        if (paramr == n.r.agh()) {
          return this;
        }
        if (this.dNG == null) {
          if (!n.r.c(paramr).isEmpty())
          {
            if (!this.dNE.isEmpty()) {
              break label80;
            }
            this.dNE = n.r.c(paramr);
            this.bitField0_ &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          P(paramr.unknownFields);
          onChanged();
          return this;
          label80:
          agl();
          this.dNE.addAll(n.r.c(paramr));
          break;
          if (!n.r.c(paramr).isEmpty()) {
            if (this.dNG.isEmpty())
            {
              this.dNG.dUC = null;
              this.dNG = null;
              this.dNE = n.r.c(paramr);
              this.bitField0_ &= 0xFFFFFFFE;
              if (bg.alwaysUseFieldBuilders) {
                localda = agm();
              }
              this.dNG = localda;
            }
            else
            {
              this.dNG.a(n.r.c(paramr));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abJ();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abK().b(n.r.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
    
    public static final class b
      extends bg
      implements ai
    {
      @Deprecated
      public static final cs<b> PARSER = new c() {};
      private static final b dNO = new b();
      private int bitField0_;
      private bj.g dNH;
      private int dNI = -1;
      private bj.g dNJ;
      private int dNK = -1;
      private volatile Object dNL;
      private volatile Object dNM;
      private bp dNN;
      private byte memoizedIsInitialized = -1;
      
      private b()
      {
        this.dNH = emptyIntList();
        this.dNJ = emptyIntList();
        this.dNL = "";
        this.dNM = "";
        this.dNN = bo.dTm;
      }
      
      private b(bg.a<?> parama)
      {
        super();
      }
      
      private b(i parami, at paramat)
      {
        this();
        if (paramat == null) {
          throw new NullPointerException();
        }
        dn.a locala = dn.ajE();
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
              n = parami.aac();
              switch (n)
              {
              case 8: 
                k = i;
                m = i;
                j = i;
                if (parseUnknownField(parami, locala, paramat, n)) {
                  break label26;
                }
                i1 = 1;
                break label26;
              }
            }
            catch (bk parami)
            {
              try
              {
                parami.dST = this;
                throw parami;
              }
              finally
              {
                j = k;
                if ((j & 0x1) != 0) {
                  this.dNH.ZP();
                }
                if ((j & 0x2) != 0) {
                  this.dNJ.ZP();
                }
                if ((j & 0x10) != 0) {
                  this.dNN = this.dNN.aiv();
                }
                this.unknownFields = locala.ajH();
                makeExtensionsImmutable();
              }
              k = i;
              m = i;
              j = i;
              i2 = parami.jO(parami.aar());
              n = i;
              if ((i & 0x1) != 0) {
                continue;
              }
              k = i;
              n = i;
              m = i;
              j = i;
              if (parami.aat() <= 0) {
                continue;
              }
              k = i;
              m = i;
              j = i;
              this.dNH = newIntList();
              n = i | 0x1;
              k = n;
              m = n;
              j = n;
              if (parami.aat() <= 0) {
                continue;
              }
              k = n;
              m = n;
              j = n;
              this.dNH.lj(parami.aaf());
              continue;
            }
            catch (IOException parami)
            {
              j = m;
              parami = new bk(parami);
              j = m;
              parami.dST = this;
              j = m;
              throw parami;
            }
            finally
            {
              continue;
              k = n;
              m = n;
              j = n;
              parami.jP(i2);
              i = n;
            }
            int n = i;
            if ((i & 0x1) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dNH = newIntList();
              n = i | 0x1;
            }
            k = n;
            m = n;
            j = n;
            this.dNH.lj(parami.aaf());
            i = n;
            break;
            break;
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dNJ = newIntList();
              n = i | 0x2;
            }
            k = n;
            m = n;
            j = n;
            this.dNJ.lj(parami.aaf());
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            int i2 = parami.jO(parami.aar());
            n = i;
            if ((i & 0x2) == 0)
            {
              k = i;
              m = i;
              j = i;
              n = i;
              if (parami.aat() > 0)
              {
                k = i;
                m = i;
                j = i;
                this.dNJ = newIntList();
                n = i | 0x2;
              }
            }
            for (;;)
            {
              k = n;
              m = n;
              j = n;
              if (parami.aat() <= 0) {
                break;
              }
              k = n;
              m = n;
              j = n;
              this.dNJ.lj(parami.aaf());
            }
            k = n;
            m = n;
            j = n;
            parami.jP(i2);
            i = n;
            break;
            k = i;
            m = i;
            j = i;
            h localh = parami.aak();
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x1;
            k = i;
            m = i;
            j = i;
            this.dNL = localh;
            break;
            k = i;
            m = i;
            j = i;
            localh = parami.aak();
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x2;
            k = i;
            m = i;
            j = i;
            this.dNM = localh;
            break;
            k = i;
            m = i;
            j = i;
            localh = parami.aak();
            n = i;
            if ((i & 0x10) == 0)
            {
              k = i;
              m = i;
              j = i;
              this.dNN = new bo();
              n = i | 0x10;
            }
            k = n;
            m = n;
            j = n;
            this.dNN.d(localh);
            i = n;
            break;
            if ((i & 0x1) != 0) {
              this.dNH.ZP();
            }
            if ((i & 0x2) != 0) {
              this.dNJ.ZP();
            }
            if ((i & 0x10) != 0) {
              this.dNN = this.dNN.aiv();
            }
            this.unknownFields = locala.ajH();
            makeExtensionsImmutable();
            return;
          }
          i1 = 1;
        }
      }
      
      private String ago()
      {
        Object localObject = this.dNL;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (h)localObject;
        String str = ((h)localObject).ZV();
        if (((h)localObject).ZW()) {
          this.dNL = str;
        }
        return str;
      }
      
      private String agq()
      {
        Object localObject = this.dNM;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (h)localObject;
        String str = ((h)localObject).ZV();
        if (((h)localObject).ZW()) {
          this.dNM = str;
        }
        return str;
      }
      
      private a agr()
      {
        if (this == dNO) {
          return new a((byte)0);
        }
        return new a((byte)0).f(this);
      }
      
      public static b ags()
      {
        return dNO;
      }
      
      public final boolean agn()
      {
        return (this.bitField0_ & 0x1) != 0;
      }
      
      public final boolean agp()
      {
        return (this.bitField0_ & 0x2) != 0;
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
          if (!this.dNH.equals(paramObject.dNH)) {
            return false;
          }
          if (!this.dNJ.equals(paramObject.dNJ)) {
            return false;
          }
          if (agn() != paramObject.agn()) {
            return false;
          }
          if ((agn()) && (!ago().equals(paramObject.ago()))) {
            return false;
          }
          if (agp() != paramObject.agp()) {
            return false;
          }
          if ((agp()) && (!agq().equals(paramObject.agq()))) {
            return false;
          }
          if (!this.dNN.equals(paramObject.dNN)) {
            return false;
          }
        } while (this.unknownFields.equals(paramObject.unknownFields));
        return false;
      }
      
      public final cs<b> getParserForType()
      {
        return PARSER;
      }
      
      public final int getSerializedSize()
      {
        int i = this.memoizedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        int j = 0;
        while (i < this.dNH.size())
        {
          j += k.kp(this.dNH.getInt(i));
          i += 1;
        }
        int k = j + 0;
        i = k;
        if (!this.dNH.isEmpty()) {
          i = k + 1 + k.kp(j);
        }
        this.dNI = j;
        k = 0;
        j = 0;
        while (k < this.dNJ.size())
        {
          j += k.kp(this.dNJ.getInt(k));
          k += 1;
        }
        k = i + j;
        i = k;
        if (!this.dNJ.isEmpty()) {
          i = k + 1 + k.kp(j);
        }
        this.dNK = j;
        j = i;
        if ((this.bitField0_ & 0x1) != 0) {
          j = i + bg.computeStringSize(3, this.dNL);
        }
        i = j;
        if ((this.bitField0_ & 0x2) != 0) {
          i = j + bg.computeStringSize(4, this.dNM);
        }
        j = 0;
        k = 0;
        while (j < this.dNN.size())
        {
          k += computeStringSizeNoTag(this.dNN.getRaw(j));
          j += 1;
        }
        i = i + k + this.dNN.size() * 1 + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final dn getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final int hashCode()
      {
        if (this.memoizedHashCode != 0) {
          return this.memoizedHashCode;
        }
        int j = n.abL().hashCode() + 779;
        int i = j;
        if (this.dNH.size() > 0) {
          i = (j * 37 + 1) * 53 + this.dNH.hashCode();
        }
        j = i;
        if (this.dNJ.size() > 0) {
          j = (i * 37 + 2) * 53 + this.dNJ.hashCode();
        }
        i = j;
        if (agn()) {
          i = (j * 37 + 3) * 53 + ago().hashCode();
        }
        j = i;
        if (agp()) {
          j = (i * 37 + 4) * 53 + agq().hashCode();
        }
        i = j;
        if (this.dNN.size() > 0) {
          i = (j * 37 + 6) * 53 + this.dNN.hashCode();
        }
        i = i * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abM().b(b.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = this.memoizedIsInitialized;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
      }
      
      protected final Object newInstance(bg.f paramf)
      {
        return new b();
      }
      
      public final void writeTo(k paramk)
      {
        int j = 0;
        getSerializedSize();
        if (this.dNH.size() > 0)
        {
          paramk.ke(10);
          paramk.ke(this.dNI);
        }
        int i = 0;
        while (i < this.dNH.size())
        {
          paramk.kd(this.dNH.getInt(i));
          i += 1;
        }
        if (this.dNJ.size() > 0)
        {
          paramk.ke(18);
          paramk.ke(this.dNK);
        }
        i = 0;
        while (i < this.dNJ.size())
        {
          paramk.kd(this.dNJ.getInt(i));
          i += 1;
        }
        if ((this.bitField0_ & 0x1) != 0) {
          bg.writeString(paramk, 3, this.dNL);
        }
        i = j;
        if ((this.bitField0_ & 0x2) != 0)
        {
          bg.writeString(paramk, 4, this.dNM);
          i = j;
        }
        while (i < this.dNN.size())
        {
          bg.writeString(paramk, 6, this.dNN.getRaw(i));
          i += 1;
        }
        this.unknownFields.writeTo(paramk);
      }
      
      public static final class a
        extends bg.a<a>
        implements ai
      {
        private int bitField0_;
        private bj.g dNH = bg.emptyIntList();
        private bj.g dNJ = bg.emptyIntList();
        private Object dNL = "";
        private Object dNM = "";
        private bp dNN = bo.dTm;
        
        private a()
        {
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a(bg.b paramb)
        {
          super();
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a Q(dn paramdn)
        {
          return (a)super.setUnknownFields(paramdn);
        }
        
        private a R(dn paramdn)
        {
          return (a)super.mergeUnknownFields(paramdn);
        }
        
        private a S(am.f paramf, Object paramObject)
        {
          return (a)super.setField(paramf, paramObject);
        }
        
        private a T(am.f paramf, Object paramObject)
        {
          return (a)super.addRepeatedField(paramf, paramObject);
        }
        
        private a agt()
        {
          super.clear();
          this.dNH = bg.emptyIntList();
          this.bitField0_ &= 0xFFFFFFFE;
          this.dNJ = bg.emptyIntList();
          this.bitField0_ &= 0xFFFFFFFD;
          this.dNL = "";
          this.bitField0_ &= 0xFFFFFFFB;
          this.dNM = "";
          this.bitField0_ &= 0xFFFFFFF7;
          this.dNN = bo.dTm;
          this.bitField0_ &= 0xFFFFFFEF;
          return this;
        }
        
        private n.r.b agu()
        {
          n.r.b localb = agv();
          if (!localb.isInitialized()) {
            throw newUninitializedMessageException(localb);
          }
          return localb;
        }
        
        private n.r.b agv()
        {
          int i = 0;
          n.r.b localb = new n.r.b(this, (byte)0);
          int k = this.bitField0_;
          if ((this.bitField0_ & 0x1) != 0)
          {
            this.dNH.ZP();
            this.bitField0_ &= 0xFFFFFFFE;
          }
          n.r.b.a(localb, this.dNH);
          if ((this.bitField0_ & 0x2) != 0)
          {
            this.dNJ.ZP();
            this.bitField0_ &= 0xFFFFFFFD;
          }
          n.r.b.b(localb, this.dNJ);
          if ((k & 0x4) != 0) {
            i = 1;
          }
          n.r.b.a(localb, this.dNL);
          int j = i;
          if ((k & 0x8) != 0) {
            j = i | 0x2;
          }
          n.r.b.b(localb, this.dNM);
          if ((this.bitField0_ & 0x10) != 0)
          {
            this.dNN = this.dNN.aiv();
            this.bitField0_ &= 0xFFFFFFEF;
          }
          n.r.b.a(localb, this.dNN);
          n.r.b.a(localb, j);
          onBuilt();
          return localb;
        }
        
        private void agw()
        {
          if ((this.bitField0_ & 0x1) == 0)
          {
            this.dNH = bg.mutableCopy(this.dNH);
            this.bitField0_ |= 0x1;
          }
        }
        
        private void agx()
        {
          if ((this.bitField0_ & 0x2) == 0)
          {
            this.dNJ = bg.mutableCopy(this.dNJ);
            this.bitField0_ |= 0x2;
          }
        }
        
        private void agy()
        {
          if ((this.bitField0_ & 0x10) == 0)
          {
            this.dNN = new bo(this.dNN);
            this.bitField0_ |= 0x10;
          }
        }
        
        private a v(am.j paramj)
        {
          return (a)super.clearOneof(paramj);
        }
        
        private a v(cb paramcb)
        {
          if ((paramcb instanceof n.r.b)) {
            return f((n.r.b)paramcb);
          }
          super.mergeFrom(paramcb);
          return this;
        }
        
        /* Error */
        private a v(i parami, at paramat)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 171	com/google/d/n$r$b:PARSER	Lcom/google/d/cs;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 177 3 0
          //   12: checkcast 14	com/google/d/n$r$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 160	com/google/d/n$r$b$a:f	(Lcom/google/d/n$r$b;)Lcom/google/d/n$r$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 181	com/google/d/bk:dST	Lcom/google/d/ce;
          //   33: checkcast 14	com/google/d/n$r$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 185	com/google/d/bk:aii	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 160	com/google/d/n$r$b$a:f	(Lcom/google/d/n$r$b;)Lcom/google/d/n$r$b$a;
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
          //   0	61	1	parami	i
          //   0	61	2	paramat	at
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/d/bk
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a w(am.f paramf, int paramInt, Object paramObject)
        {
          return (a)super.setRepeatedField(paramf, paramInt, paramObject);
        }
        
        private a z(am.f paramf)
        {
          return (a)super.clearField(paramf);
        }
        
        public final a f(n.r.b paramb)
        {
          if (paramb == n.r.b.ags()) {
            return this;
          }
          if (!n.r.b.a(paramb).isEmpty())
          {
            if (this.dNH.isEmpty())
            {
              this.dNH = n.r.b.a(paramb);
              this.bitField0_ &= 0xFFFFFFFE;
              onChanged();
            }
          }
          else
          {
            if (!n.r.b.b(paramb).isEmpty())
            {
              if (!this.dNJ.isEmpty()) {
                break label245;
              }
              this.dNJ = n.r.b.b(paramb);
              this.bitField0_ &= 0xFFFFFFFD;
              label99:
              onChanged();
            }
            if (paramb.agn())
            {
              this.bitField0_ |= 0x4;
              this.dNL = n.r.b.c(paramb);
              onChanged();
            }
            if (paramb.agp())
            {
              this.bitField0_ |= 0x8;
              this.dNM = n.r.b.d(paramb);
              onChanged();
            }
            if (!n.r.b.e(paramb).isEmpty())
            {
              if (!this.dNN.isEmpty()) {
                break label266;
              }
              this.dNN = n.r.b.e(paramb);
              this.bitField0_ &= 0xFFFFFFEF;
            }
          }
          for (;;)
          {
            onChanged();
            R(paramb.unknownFields);
            onChanged();
            return this;
            agw();
            this.dNH.addAll(n.r.b.a(paramb));
            break;
            label245:
            agx();
            this.dNJ.addAll(n.r.b.b(paramb));
            break label99;
            label266:
            agy();
            this.dNN.addAll(n.r.b.e(paramb));
          }
        }
        
        public final am.a getDescriptorForType()
        {
          return n.abL();
        }
        
        protected final bg.e internalGetFieldAccessorTable()
        {
          return n.abM().b(n.r.b.class, a.class);
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
  }
  
  public static final class s
    extends bg
    implements al
  {
    @Deprecated
    public static final cs<s> PARSER = new c() {};
    private static final s dNW = new s();
    private int bitField0_;
    private List<b> dNP;
    private volatile Object dNQ;
    long dNR;
    long dNS;
    double dNT;
    h dNU;
    private volatile Object dNV;
    private byte memoizedIsInitialized = -1;
    
    private s()
    {
      this.dNP = Collections.emptyList();
      this.dNQ = "";
      this.dNU = h.dIJ;
      this.dNV = "";
    }
    
    private s(bg.a<?> parama)
    {
      super();
    }
    
    private s(i parami, at paramat)
    {
      this();
      if (paramat == null) {
        throw new NullPointerException();
      }
      dn.a locala = dn.ajE();
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
            int j = parami.aac();
            switch (j)
            {
            case 18: 
              n = i;
              i1 = i;
              k = i;
              if (parseUnknownField(parami, locala, paramat, j)) {
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
                this.dNP = new ArrayList();
                j = i | 0x1;
              }
              n = j;
              i1 = j;
              k = j;
              this.dNP.add(parami.a(b.PARSER, paramat));
              i = j;
              break label26;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              throw parami;
            }
            finally
            {
              k = n;
              if ((k & 0x1) != 0) {
                this.dNP = Collections.unmodifiableList(this.dNP);
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
            }
            n = i;
            i1 = i;
            k = i;
            localh = parami.aak();
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.dNQ = localh;
            break;
          }
          catch (IOException parami)
          {
            k = i1;
            parami = new bk(parami);
            k = i1;
            parami.dST = this;
            k = i1;
            throw parami;
          }
          finally
          {
            continue;
            n = i;
            i1 = i;
            k = i;
            this.bitField0_ |= 0x2;
            n = i;
            i1 = i;
            k = i;
            this.dNR = parami.aad();
          }
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x4;
          n = i;
          i1 = i;
          k = i;
          this.dNS = parami.aae();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x8;
          n = i;
          i1 = i;
          k = i;
          this.dNT = parami.readDouble();
          break;
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x10;
          n = i;
          i1 = i;
          k = i;
          this.dNU = parami.aak();
          break;
          n = i;
          i1 = i;
          k = i;
          h localh = parami.aak();
          n = i;
          i1 = i;
          k = i;
          this.bitField0_ |= 0x20;
          n = i;
          i1 = i;
          k = i;
          this.dNV = localh;
          break;
          if ((i & 0x1) != 0) {
            this.dNP = Collections.unmodifiableList(this.dNP);
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          return;
        }
        m = 1;
      }
    }
    
    private String agB()
    {
      Object localObject = this.dNQ;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dNQ = str;
      }
      return str;
    }
    
    private String agH()
    {
      Object localObject = this.dNV;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.dNV = str;
      }
      return str;
    }
    
    private a agI()
    {
      if (this == dNW) {
        return new a((byte)0);
      }
      return new a((byte)0).d(this);
    }
    
    public static s agJ()
    {
      return dNW;
    }
    
    private int agz()
    {
      return this.dNP.size();
    }
    
    public final boolean agA()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean agC()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean agD()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean agE()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final boolean agF()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final boolean agG()
    {
      return (this.bitField0_ & 0x20) != 0;
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
        if (!this.dNP.equals(paramObject.dNP)) {
          return false;
        }
        if (agA() != paramObject.agA()) {
          return false;
        }
        if ((agA()) && (!agB().equals(paramObject.agB()))) {
          return false;
        }
        if (agC() != paramObject.agC()) {
          return false;
        }
        if ((agC()) && (this.dNR != paramObject.dNR)) {
          return false;
        }
        if (agD() != paramObject.agD()) {
          return false;
        }
        if ((agD()) && (this.dNS != paramObject.dNS)) {
          return false;
        }
        if (agE() != paramObject.agE()) {
          return false;
        }
        if ((agE()) && (Double.doubleToLongBits(this.dNT) != Double.doubleToLongBits(paramObject.dNT))) {
          return false;
        }
        if (agF() != paramObject.agF()) {
          return false;
        }
        if ((agF()) && (!this.dNU.equals(paramObject.dNU))) {
          return false;
        }
        if (agG() != paramObject.agG()) {
          return false;
        }
        if ((agG()) && (!agH().equals(paramObject.agH()))) {
          return false;
        }
      } while (this.unknownFields.equals(paramObject.unknownFields));
      return false;
    }
    
    public final cs<s> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      int i = this.memoizedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      i = 0;
      while (j < this.dNP.size())
      {
        i += k.c(2, (ce)this.dNP.get(j));
        j += 1;
      }
      j = i;
      if ((this.bitField0_ & 0x1) != 0) {
        j = i + bg.computeStringSize(3, this.dNQ);
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + k.r(4, this.dNR);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + k.q(5, this.dNS);
      }
      i = j;
      if ((this.bitField0_ & 0x8) != 0) {
        i = j + k.km(6);
      }
      j = i;
      if ((this.bitField0_ & 0x10) != 0) {
        j = i + k.c(7, this.dNU);
      }
      i = j;
      if ((this.bitField0_ & 0x20) != 0) {
        i = j + bg.computeStringSize(8, this.dNV);
      }
      i = this.unknownFields.getSerializedSize() + i;
      this.memoizedSize = i;
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      if (this.memoizedHashCode != 0) {
        return this.memoizedHashCode;
      }
      int j = n.abF().hashCode() + 779;
      int i = j;
      if (agz() > 0) {
        i = (j * 37 + 2) * 53 + this.dNP.hashCode();
      }
      j = i;
      if (agA()) {
        j = (i * 37 + 3) * 53 + agB().hashCode();
      }
      i = j;
      if (agC()) {
        i = (j * 37 + 4) * 53 + bj.hashLong(this.dNR);
      }
      j = i;
      if (agD()) {
        j = (i * 37 + 5) * 53 + bj.hashLong(this.dNS);
      }
      i = j;
      if (agE()) {
        i = (j * 37 + 6) * 53 + bj.hashLong(Double.doubleToLongBits(this.dNT));
      }
      j = i;
      if (agF()) {
        j = (i * 37 + 7) * 53 + this.dNU.hashCode();
      }
      i = j;
      if (agG()) {
        i = (j * 37 + 8) * 53 + agH().hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    protected final bg.e internalGetFieldAccessorTable()
    {
      return n.abG().b(s.class, a.class);
    }
    
    public final boolean isInitialized()
    {
      boolean bool = false;
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        bool = true;
      }
      while (i == 0) {
        return bool;
      }
      i = 0;
      while (i < agz())
      {
        if (!((b)this.dNP.get(i)).isInitialized())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        i += 1;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    protected final Object newInstance(bg.f paramf)
    {
      return new s();
    }
    
    public final void writeTo(k paramk)
    {
      int i = 0;
      while (i < this.dNP.size())
      {
        paramk.a(2, (ce)this.dNP.get(i));
        i += 1;
      }
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 3, this.dNQ);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.n(4, this.dNR);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.n(5, this.dNS);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        paramk.d(6, this.dNT);
      }
      if ((this.bitField0_ & 0x10) != 0) {
        paramk.a(7, this.dNU);
      }
      if ((this.bitField0_ & 0x20) != 0) {
        bg.writeString(paramk, 8, this.dNV);
      }
      this.unknownFields.writeTo(paramk);
    }
    
    public static final class a
      extends bg.a<a>
      implements al
    {
      private int bitField0_;
      private List<n.s.b> dNP = Collections.emptyList();
      private Object dNQ = "";
      private long dNR;
      private long dNS;
      private double dNT;
      private h dNU = h.dIJ;
      private Object dNV = "";
      private da<n.s.b, n.s.b.a, ak> dNX;
      
      private a()
      {
        maybeForceBuilderInitialization();
      }
      
      private a(bg.b paramb)
      {
        super();
        maybeForceBuilderInitialization();
      }
      
      private a A(am.f paramf)
      {
        return (a)super.clearField(paramf);
      }
      
      private a S(dn paramdn)
      {
        return (a)super.setUnknownFields(paramdn);
      }
      
      private a T(dn paramdn)
      {
        return (a)super.mergeUnknownFields(paramdn);
      }
      
      private a U(am.f paramf, Object paramObject)
      {
        return (a)super.setField(paramf, paramObject);
      }
      
      private a V(am.f paramf, Object paramObject)
      {
        return (a)super.addRepeatedField(paramf, paramObject);
      }
      
      private a agK()
      {
        super.clear();
        if (this.dNX == null)
        {
          this.dNP = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFE;
        }
        for (;;)
        {
          this.dNQ = "";
          this.bitField0_ &= 0xFFFFFFFD;
          this.dNR = 0L;
          this.bitField0_ &= 0xFFFFFFFB;
          this.dNS = 0L;
          this.bitField0_ &= 0xFFFFFFF7;
          this.dNT = 0.0D;
          this.bitField0_ &= 0xFFFFFFEF;
          this.dNU = h.dIJ;
          this.bitField0_ &= 0xFFFFFFDF;
          this.dNV = "";
          this.bitField0_ &= 0xFFFFFFBF;
          return this;
          this.dNX.clear();
        }
      }
      
      private n.s agL()
      {
        n.s locals = agM();
        if (!locals.isInitialized()) {
          throw newUninitializedMessageException(locals);
        }
        return locals;
      }
      
      private n.s agM()
      {
        int j = 0;
        n.s locals = new n.s(this, (byte)0);
        int k = this.bitField0_;
        if (this.dNX == null)
        {
          if ((this.bitField0_ & 0x1) != 0)
          {
            this.dNP = Collections.unmodifiableList(this.dNP);
            this.bitField0_ &= 0xFFFFFFFE;
          }
          n.s.a(locals, this.dNP);
        }
        for (;;)
        {
          if ((k & 0x2) != 0) {
            j = 1;
          }
          n.s.a(locals, this.dNQ);
          int i = j;
          if ((k & 0x4) != 0)
          {
            n.s.a(locals, this.dNR);
            i = j | 0x2;
          }
          j = i;
          if ((k & 0x8) != 0)
          {
            n.s.b(locals, this.dNS);
            j = i | 0x4;
          }
          i = j;
          if ((k & 0x10) != 0)
          {
            n.s.a(locals, this.dNT);
            i = j | 0x8;
          }
          j = i;
          if ((k & 0x20) != 0) {
            j = i | 0x10;
          }
          n.s.a(locals, this.dNU);
          i = j;
          if ((k & 0x40) != 0) {
            i = j | 0x20;
          }
          n.s.b(locals, this.dNV);
          n.s.a(locals, i);
          onBuilt();
          return locals;
          n.s.a(locals, this.dNX.build());
        }
      }
      
      private void agN()
      {
        if ((this.bitField0_ & 0x1) == 0)
        {
          this.dNP = new ArrayList(this.dNP);
          this.bitField0_ |= 0x1;
        }
      }
      
      private da<n.s.b, n.s.b.a, ak> agO()
      {
        List localList;
        if (this.dNX == null)
        {
          localList = this.dNP;
          if ((this.bitField0_ & 0x1) == 0) {
            break label54;
          }
        }
        label54:
        for (boolean bool = true;; bool = false)
        {
          this.dNX = new da(localList, bool, getParentForChildren(), isClean());
          this.dNP = null;
          return this.dNX;
        }
      }
      
      private a c(h paramh)
      {
        if (paramh == null) {
          throw new NullPointerException();
        }
        this.bitField0_ |= 0x20;
        this.dNU = paramh;
        onChanged();
        return this;
      }
      
      private a cY(long paramLong)
      {
        this.bitField0_ |= 0x4;
        this.dNR = paramLong;
        onChanged();
        return this;
      }
      
      private a cZ(long paramLong)
      {
        this.bitField0_ |= 0x8;
        this.dNS = paramLong;
        onChanged();
        return this;
      }
      
      private void maybeForceBuilderInitialization()
      {
        if (bg.alwaysUseFieldBuilders) {
          agO();
        }
      }
      
      private a v(double paramDouble)
      {
        this.bitField0_ |= 0x10;
        this.dNT = paramDouble;
        onChanged();
        return this;
      }
      
      private a w(am.j paramj)
      {
        return (a)super.clearOneof(paramj);
      }
      
      private a w(cb paramcb)
      {
        if ((paramcb instanceof n.s)) {
          return d((n.s)paramcb);
        }
        super.mergeFrom(paramcb);
        return this;
      }
      
      /* Error */
      private a w(i parami, at paramat)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 225	com/google/d/n$s:PARSER	Lcom/google/d/cs;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 231 3 0
        //   12: checkcast 9	com/google/d/n$s
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 214	com/google/d/n$s$a:d	(Lcom/google/d/n$s;)Lcom/google/d/n$s$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 235	com/google/d/bk:dST	Lcom/google/d/ce;
        //   33: checkcast 9	com/google/d/n$s
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 239	com/google/d/bk:aii	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 214	com/google/d/n$s$a:d	(Lcom/google/d/n$s;)Lcom/google/d/n$s$a;
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
        //   0	61	1	parami	i
        //   0	61	2	paramat	at
        //   1	56	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   2	16	28	com/google/d/bk
        //   37	42	42	finally
        //   2	16	55	finally
        //   29	37	55	finally
      }
      
      private a x(am.f paramf, int paramInt, Object paramObject)
      {
        return (a)super.setRepeatedField(paramf, paramInt, paramObject);
      }
      
      public final a d(n.s params)
      {
        da localda = null;
        if (params == n.s.agJ()) {
          return this;
        }
        if (this.dNX == null) {
          if (!n.s.a(params).isEmpty())
          {
            if (!this.dNP.isEmpty()) {
              break label203;
            }
            this.dNP = n.s.a(params);
            this.bitField0_ &= 0xFFFFFFFE;
            onChanged();
          }
        }
        for (;;)
        {
          if (params.agA())
          {
            this.bitField0_ |= 0x2;
            this.dNQ = n.s.b(params);
            onChanged();
          }
          if (params.agC()) {
            cY(params.dNR);
          }
          if (params.agD()) {
            cZ(params.dNS);
          }
          if (params.agE()) {
            v(params.dNT);
          }
          if (params.agF()) {
            c(params.dNU);
          }
          if (params.agG())
          {
            this.bitField0_ |= 0x40;
            this.dNV = n.s.c(params);
            onChanged();
          }
          T(params.unknownFields);
          onChanged();
          return this;
          label203:
          agN();
          this.dNP.addAll(n.s.a(params));
          break;
          if (!n.s.a(params).isEmpty()) {
            if (this.dNX.isEmpty())
            {
              this.dNX.dUC = null;
              this.dNX = null;
              this.dNP = n.s.a(params);
              this.bitField0_ &= 0xFFFFFFFE;
              if (bg.alwaysUseFieldBuilders) {
                localda = agO();
              }
              this.dNX = localda;
            }
            else
            {
              this.dNX.a(n.s.a(params));
            }
          }
        }
      }
      
      public final am.a getDescriptorForType()
      {
        return n.abF();
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abG().b(n.s.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = 0;
        for (;;)
        {
          int j;
          if (this.dNX == null)
          {
            j = this.dNP.size();
            if (i >= j) {
              break;
            }
            if (this.dNX != null) {
              break label65;
            }
          }
          label65:
          for (n.s.b localb = (n.s.b)this.dNP.get(i);; localb = (n.s.b)this.dNX.J(i, false))
          {
            if (localb.isInitialized()) {
              break label81;
            }
            return false;
            j = this.dNX.getCount();
            break;
          }
          label81:
          i += 1;
        }
        return true;
      }
    }
    
    public static final class b
      extends bg
      implements ak
    {
      @Deprecated
      public static final cs<b> PARSER = new c() {};
      private static final b dOa = new b();
      private int bitField0_;
      private volatile Object dNY;
      boolean dNZ;
      private byte memoizedIsInitialized = -1;
      
      private b()
      {
        this.dNY = "";
      }
      
      private b(bg.a<?> parama)
      {
        super();
      }
      
      /* Error */
      private b(i parami, at paramat)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 36	com/google/d/n$s$b:<init>	()V
        //   4: aload_2
        //   5: ifnonnull +11 -> 16
        //   8: new 63	java/lang/NullPointerException
        //   11: dup
        //   12: invokespecial 64	java/lang/NullPointerException:<init>	()V
        //   15: athrow
        //   16: invokestatic 70	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
        //   19: astore 5
        //   21: iconst_0
        //   22: istore_3
        //   23: iload_3
        //   24: ifne +149 -> 173
        //   27: aload_1
        //   28: invokevirtual 76	com/google/d/i:aac	()I
        //   31: istore 4
        //   33: iload 4
        //   35: lookupswitch	default:+152->187, 0:+155->190, 10:+51->86, 16:+100->135
        //   69: aload_1
        //   70: aload 5
        //   72: aload_2
        //   73: iload 4
        //   75: invokevirtual 80	com/google/d/n$s$b:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
        //   78: ifne -55 -> 23
        //   81: iconst_1
        //   82: istore_3
        //   83: goto -60 -> 23
        //   86: aload_1
        //   87: invokevirtual 84	com/google/d/i:aak	()Lcom/google/d/h;
        //   90: astore 6
        //   92: aload_0
        //   93: aload_0
        //   94: getfield 86	com/google/d/n$s$b:bitField0_	I
        //   97: iconst_1
        //   98: ior
        //   99: putfield 86	com/google/d/n$s$b:bitField0_	I
        //   102: aload_0
        //   103: aload 6
        //   105: putfield 49	com/google/d/n$s$b:dNY	Ljava/lang/Object;
        //   108: goto -85 -> 23
        //   111: astore_1
        //   112: aload_1
        //   113: aload_0
        //   114: putfield 90	com/google/d/bk:dST	Lcom/google/d/ce;
        //   117: aload_1
        //   118: athrow
        //   119: astore_1
        //   120: aload_0
        //   121: aload 5
        //   123: invokevirtual 96	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   126: putfield 100	com/google/d/n$s$b:unknownFields	Lcom/google/d/dn;
        //   129: aload_0
        //   130: invokevirtual 103	com/google/d/n$s$b:makeExtensionsImmutable	()V
        //   133: aload_1
        //   134: athrow
        //   135: aload_0
        //   136: aload_0
        //   137: getfield 86	com/google/d/n$s$b:bitField0_	I
        //   140: iconst_2
        //   141: ior
        //   142: putfield 86	com/google/d/n$s$b:bitField0_	I
        //   145: aload_0
        //   146: aload_1
        //   147: invokevirtual 107	com/google/d/i:aai	()Z
        //   150: putfield 109	com/google/d/n$s$b:dNZ	Z
        //   153: goto -130 -> 23
        //   156: astore_1
        //   157: new 59	com/google/d/bk
        //   160: dup
        //   161: aload_1
        //   162: invokespecial 112	com/google/d/bk:<init>	(Ljava/io/IOException;)V
        //   165: astore_1
        //   166: aload_1
        //   167: aload_0
        //   168: putfield 90	com/google/d/bk:dST	Lcom/google/d/ce;
        //   171: aload_1
        //   172: athrow
        //   173: aload_0
        //   174: aload 5
        //   176: invokevirtual 96	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
        //   179: putfield 100	com/google/d/n$s$b:unknownFields	Lcom/google/d/dn;
        //   182: aload_0
        //   183: invokevirtual 103	com/google/d/n$s$b:makeExtensionsImmutable	()V
        //   186: return
        //   187: goto -119 -> 68
        //   190: iconst_1
        //   191: istore_3
        //   192: goto -169 -> 23
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	195	0	this	b
        //   0	195	1	parami	i
        //   0	195	2	paramat	at
        //   22	170	3	i	int
        //   31	43	4	j	int
        //   19	156	5	locala	dn.a
        //   90	14	6	localh	h
        // Exception table:
        //   from	to	target	type
        //   27	33	111	com/google/d/bk
        //   68	81	111	com/google/d/bk
        //   86	108	111	com/google/d/bk
        //   135	153	111	com/google/d/bk
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
      
      private String agQ()
      {
        Object localObject = this.dNY;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (h)localObject;
        String str = ((h)localObject).ZV();
        if (((h)localObject).ZW()) {
          this.dNY = str;
        }
        return str;
      }
      
      private a agS()
      {
        if (this == dOa) {
          return new a((byte)0);
        }
        return new a((byte)0).b(this);
      }
      
      public static b agT()
      {
        return dOa;
      }
      
      public final boolean agP()
      {
        return (this.bitField0_ & 0x1) != 0;
      }
      
      public final boolean agR()
      {
        return (this.bitField0_ & 0x2) != 0;
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
          if (agP() != paramObject.agP()) {
            return false;
          }
          if ((agP()) && (!agQ().equals(paramObject.agQ()))) {
            return false;
          }
          if (agR() != paramObject.agR()) {
            return false;
          }
          if ((agR()) && (this.dNZ != paramObject.dNZ)) {
            return false;
          }
        } while (this.unknownFields.equals(paramObject.unknownFields));
        return false;
      }
      
      public final cs<b> getParserForType()
      {
        return PARSER;
      }
      
      public final int getSerializedSize()
      {
        int i = this.memoizedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        if ((this.bitField0_ & 0x1) != 0) {
          i = bg.computeStringSize(1, this.dNY) + 0;
        }
        int j = i;
        if ((this.bitField0_ & 0x2) != 0) {
          j = i + k.kn(2);
        }
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final dn getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final int hashCode()
      {
        if (this.memoizedHashCode != 0) {
          return this.memoizedHashCode;
        }
        int j = n.abH().hashCode() + 779;
        int i = j;
        if (agP()) {
          i = (j * 37 + 1) * 53 + agQ().hashCode();
        }
        j = i;
        if (agR()) {
          j = (i * 37 + 2) * 53 + bj.hashBoolean(this.dNZ);
        }
        i = j * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      protected final bg.e internalGetFieldAccessorTable()
      {
        return n.abI().b(b.class, a.class);
      }
      
      public final boolean isInitialized()
      {
        int i = this.memoizedIsInitialized;
        if (i == 1) {
          return true;
        }
        if (i == 0) {
          return false;
        }
        if (!agP())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        if (!agR())
        {
          this.memoizedIsInitialized = 0;
          return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
      }
      
      protected final Object newInstance(bg.f paramf)
      {
        return new b();
      }
      
      public final void writeTo(k paramk)
      {
        if ((this.bitField0_ & 0x1) != 0) {
          bg.writeString(paramk, 1, this.dNY);
        }
        if ((this.bitField0_ & 0x2) != 0) {
          paramk.I(2, this.dNZ);
        }
        this.unknownFields.writeTo(paramk);
      }
      
      public static final class a
        extends bg.a<a>
        implements ak
      {
        private int bitField0_;
        private Object dNY = "";
        private boolean dNZ;
        
        private a()
        {
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a(bg.b paramb)
        {
          super();
          boolean bool = bg.alwaysUseFieldBuilders;
        }
        
        private a B(am.f paramf)
        {
          return (a)super.clearField(paramf);
        }
        
        private a U(dn paramdn)
        {
          return (a)super.setUnknownFields(paramdn);
        }
        
        private a V(dn paramdn)
        {
          return (a)super.mergeUnknownFields(paramdn);
        }
        
        private a W(am.f paramf, Object paramObject)
        {
          return (a)super.setField(paramf, paramObject);
        }
        
        private a X(am.f paramf, Object paramObject)
        {
          return (a)super.addRepeatedField(paramf, paramObject);
        }
        
        private a agU()
        {
          super.clear();
          this.dNY = "";
          this.bitField0_ &= 0xFFFFFFFE;
          this.dNZ = false;
          this.bitField0_ &= 0xFFFFFFFD;
          return this;
        }
        
        private n.s.b agV()
        {
          n.s.b localb = agW();
          if (!localb.isInitialized()) {
            throw newUninitializedMessageException(localb);
          }
          return localb;
        }
        
        private n.s.b agW()
        {
          int i = 0;
          n.s.b localb = new n.s.b(this, (byte)0);
          int k = this.bitField0_;
          if ((k & 0x1) != 0) {
            i = 1;
          }
          n.s.b.a(localb, this.dNY);
          int j = i;
          if ((k & 0x2) != 0)
          {
            n.s.b.a(localb, this.dNZ);
            j = i | 0x2;
          }
          n.s.b.a(localb, j);
          onBuilt();
          return localb;
        }
        
        private a cy(boolean paramBoolean)
        {
          this.bitField0_ |= 0x2;
          this.dNZ = paramBoolean;
          onChanged();
          return this;
        }
        
        private a x(am.j paramj)
        {
          return (a)super.clearOneof(paramj);
        }
        
        private a x(cb paramcb)
        {
          if ((paramcb instanceof n.s.b)) {
            return b((n.s.b)paramcb);
          }
          super.mergeFrom(paramcb);
          return this;
        }
        
        /* Error */
        private a x(i parami, at paramat)
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: getstatic 133	com/google/d/n$s$b:PARSER	Lcom/google/d/cs;
          //   5: aload_1
          //   6: aload_2
          //   7: invokeinterface 139 3 0
          //   12: checkcast 14	com/google/d/n$s$b
          //   15: astore_1
          //   16: aload_1
          //   17: ifnull +9 -> 26
          //   20: aload_0
          //   21: aload_1
          //   22: invokevirtual 122	com/google/d/n$s$b$a:b	(Lcom/google/d/n$s$b;)Lcom/google/d/n$s$b$a;
          //   25: pop
          //   26: aload_0
          //   27: areturn
          //   28: astore_1
          //   29: aload_1
          //   30: getfield 143	com/google/d/bk:dST	Lcom/google/d/ce;
          //   33: checkcast 14	com/google/d/n$s$b
          //   36: astore_2
          //   37: aload_1
          //   38: invokevirtual 147	com/google/d/bk:aii	()Ljava/io/IOException;
          //   41: athrow
          //   42: astore_1
          //   43: aload_2
          //   44: ifnull +9 -> 53
          //   47: aload_0
          //   48: aload_2
          //   49: invokevirtual 122	com/google/d/n$s$b$a:b	(Lcom/google/d/n$s$b;)Lcom/google/d/n$s$b$a;
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
          //   0	61	1	parami	i
          //   0	61	2	paramat	at
          //   1	56	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   2	16	28	com/google/d/bk
          //   37	42	42	finally
          //   2	16	55	finally
          //   29	37	55	finally
        }
        
        private a y(am.f paramf, int paramInt, Object paramObject)
        {
          return (a)super.setRepeatedField(paramf, paramInt, paramObject);
        }
        
        public final a b(n.s.b paramb)
        {
          if (paramb == n.s.b.agT()) {
            return this;
          }
          if (paramb.agP())
          {
            this.bitField0_ |= 0x1;
            this.dNY = n.s.b.a(paramb);
            onChanged();
          }
          if (paramb.agR()) {
            cy(paramb.dNZ);
          }
          V(paramb.unknownFields);
          onChanged();
          return this;
        }
        
        public final am.a getDescriptorForType()
        {
          return n.abH();
        }
        
        protected final bg.e internalGetFieldAccessorTable()
        {
          return n.abI().b(n.s.b.class, a.class);
        }
        
        public final boolean isInitialized()
        {
          int i;
          if ((this.bitField0_ & 0x1) != 0)
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
            if ((this.bitField0_ & 0x2) != 0) {}
            for (i = 1; i != 0; i = 0) {
              return true;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.n
 * JD-Core Version:    0.7.0.1
 */