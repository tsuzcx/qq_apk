package com.google.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k$j
  extends bb.d<j>
  implements x
{
  @Deprecated
  public static final ci<j> bRf = new c() {};
  private static final j bTm = new j();
  private int bQS;
  private List<k.s> bRA;
  private byte bRd = -1;
  boolean bRz;
  private volatile Object bST;
  private volatile Object bSU;
  boolean bSV;
  boolean bSW;
  boolean bSX;
  private int bSY;
  private volatile Object bSZ;
  boolean bTa;
  boolean bTb;
  boolean bTc;
  boolean bTd;
  boolean bTe;
  private volatile Object bTf;
  private volatile Object bTg;
  private volatile Object bTh;
  private volatile Object bTi;
  private volatile Object bTj;
  private volatile Object bTk;
  private volatile Object bTl;
  
  private k$j()
  {
    this.bST = "";
    this.bSU = "";
    this.bSY = 1;
    this.bSZ = "";
    this.bTf = "";
    this.bTg = "";
    this.bTh = "";
    this.bTi = "";
    this.bTj = "";
    this.bTk = "";
    this.bTl = "";
    this.bRA = Collections.emptyList();
  }
  
  private k$j(bb.c<j, ?> paramc)
  {
    super(paramc);
  }
  
  private k$j(h paramh, ap paramap)
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
          case 10: 
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
            localg = paramh.AD();
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.bST = localg;
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
            if ((k & 0x100000) != 0) {
              this.bRA = Collections.unmodifiableList(this.bRA);
            }
            this.bVW = locala.Jm();
            this.bXY.Al();
          }
          n = i;
          i1 = i;
          k = i;
          localg = paramh.AD();
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x2;
          n = i;
          i1 = i;
          k = i;
          this.bSU = localg;
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
          j = paramh.AF();
          n = i;
          i1 = i;
          k = i;
          if (k.j.b.hn(j) == null)
          {
            n = i;
            i1 = i;
            k = i;
            locala.bQ(9, j);
            break;
          }
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x20;
          n = i;
          i1 = i;
          k = i;
          this.bSY = j;
        }
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x4;
        n = i;
        i1 = i;
        k = i;
        this.bSV = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        g localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x40;
        n = i;
        i1 = i;
        k = i;
        this.bSZ = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x80;
        n = i;
        i1 = i;
        k = i;
        this.bTa = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x100;
        n = i;
        i1 = i;
        k = i;
        this.bTb = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x200;
        n = i;
        i1 = i;
        k = i;
        this.bTc = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x8;
        n = i;
        i1 = i;
        k = i;
        this.bSW = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x800;
        n = i;
        i1 = i;
        k = i;
        this.bRz = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x10;
        n = i;
        i1 = i;
        k = i;
        this.bSX = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x1000;
        n = i;
        i1 = i;
        k = i;
        this.bTe = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x2000;
        n = i;
        i1 = i;
        k = i;
        this.bTf = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x4000;
        n = i;
        i1 = i;
        k = i;
        this.bTg = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x8000;
        n = i;
        i1 = i;
        k = i;
        this.bTh = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x10000;
        n = i;
        i1 = i;
        k = i;
        this.bTi = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x20000;
        n = i;
        i1 = i;
        k = i;
        this.bTj = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x400;
        n = i;
        i1 = i;
        k = i;
        this.bTd = paramh.AB();
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x40000;
        n = i;
        i1 = i;
        k = i;
        this.bTk = localg;
        break;
        n = i;
        i1 = i;
        k = i;
        localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x80000;
        n = i;
        i1 = i;
        k = i;
        this.bTl = localg;
        break;
        int j = i;
        if ((i & 0x100000) == 0)
        {
          n = i;
          i1 = i;
          k = i;
          this.bRA = new ArrayList();
          j = i | 0x100000;
        }
        n = j;
        i1 = j;
        k = j;
        this.bRA.add(paramh.a(k.s.bRf, paramap));
        i = j;
        break;
        if ((i & 0x100000) != 0) {
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
  
  private String EO()
  {
    Object localObject = this.bST;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bST = str;
    }
    return str;
  }
  
  private String EQ()
  {
    Object localObject = this.bSU;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bSU = str;
    }
    return str;
  }
  
  private String EX()
  {
    Object localObject = this.bSZ;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bSZ = str;
    }
    return str;
  }
  
  private String Fe()
  {
    Object localObject = this.bTf;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTf = str;
    }
    return str;
  }
  
  private String Fg()
  {
    Object localObject = this.bTg;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTg = str;
    }
    return str;
  }
  
  private String Fi()
  {
    Object localObject = this.bTh;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTh = str;
    }
    return str;
  }
  
  private String Fk()
  {
    Object localObject = this.bTi;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTi = str;
    }
    return str;
  }
  
  private String Fm()
  {
    Object localObject = this.bTj;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTj = str;
    }
    return str;
  }
  
  private String Fo()
  {
    Object localObject = this.bTk;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTk = str;
    }
    return str;
  }
  
  private String Fq()
  {
    Object localObject = this.bTl;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTl = str;
    }
    return str;
  }
  
  public static j Fs()
  {
    return bTm;
  }
  
  public static a b(j paramj)
  {
    return bTm.Fr().n(paramj);
  }
  
  public final int Ad()
  {
    int k = 0;
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    if ((this.bQS & 0x1) != 0) {}
    for (int j = bb.f(1, this.bST) + 0;; j = 0)
    {
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + bb.f(8, this.bSU);
      }
      j = i;
      if ((this.bQS & 0x20) != 0) {
        j = i + i.bO(9, this.bSY);
      }
      i = j;
      if ((this.bQS & 0x4) != 0) {
        i = j + i.gK(10);
      }
      j = i;
      if ((this.bQS & 0x40) != 0) {
        j = i + bb.f(11, this.bSZ);
      }
      i = j;
      if ((this.bQS & 0x80) != 0) {
        i = j + i.gK(16);
      }
      j = i;
      if ((this.bQS & 0x100) != 0) {
        j = i + i.gK(17);
      }
      i = j;
      if ((this.bQS & 0x200) != 0) {
        i = j + i.gK(18);
      }
      j = i;
      if ((this.bQS & 0x8) != 0) {
        j = i + i.gK(20);
      }
      i = j;
      if ((this.bQS & 0x800) != 0) {
        i = j + i.gK(23);
      }
      j = i;
      if ((this.bQS & 0x10) != 0) {
        j = i + i.gK(27);
      }
      i = j;
      if ((this.bQS & 0x1000) != 0) {
        i = j + i.gK(31);
      }
      j = i;
      if ((this.bQS & 0x2000) != 0) {
        j = i + bb.f(36, this.bTf);
      }
      i = j;
      if ((this.bQS & 0x4000) != 0) {
        i = j + bb.f(37, this.bTg);
      }
      j = i;
      if ((this.bQS & 0x8000) != 0) {
        j = i + bb.f(39, this.bTh);
      }
      i = j;
      if ((this.bQS & 0x10000) != 0) {
        i = j + bb.f(40, this.bTi);
      }
      j = i;
      if ((this.bQS & 0x20000) != 0) {
        j = i + bb.f(41, this.bTj);
      }
      i = j;
      if ((this.bQS & 0x400) != 0) {
        i = j + i.gK(42);
      }
      j = i;
      if ((this.bQS & 0x40000) != 0) {
        j = i + bb.f(44, this.bTk);
      }
      i = j;
      if ((this.bQS & 0x80000) != 0) {
        i = j + bb.f(45, this.bTl);
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
    return k.BD().b(j.class, a.class);
  }
  
  public final ci<j> Co()
  {
    return bRf;
  }
  
  public final boolean Dr()
  {
    return (this.bQS & 0x800) != 0;
  }
  
  public final boolean EN()
  {
    return (this.bQS & 0x1) != 0;
  }
  
  public final boolean EP()
  {
    return (this.bQS & 0x2) != 0;
  }
  
  public final boolean ER()
  {
    return (this.bQS & 0x4) != 0;
  }
  
  @Deprecated
  public final boolean ES()
  {
    return (this.bQS & 0x8) != 0;
  }
  
  public final boolean ET()
  {
    return (this.bQS & 0x10) != 0;
  }
  
  public final boolean EU()
  {
    return (this.bQS & 0x20) != 0;
  }
  
  public final k.j.b EV()
  {
    k.j.b localb2 = k.j.b.hn(this.bSY);
    k.j.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = k.j.b.bTn;
    }
    return localb1;
  }
  
  public final boolean EW()
  {
    return (this.bQS & 0x40) != 0;
  }
  
  public final boolean EY()
  {
    return (this.bQS & 0x80) != 0;
  }
  
  public final boolean EZ()
  {
    return (this.bQS & 0x100) != 0;
  }
  
  public final boolean Fa()
  {
    return (this.bQS & 0x200) != 0;
  }
  
  public final boolean Fb()
  {
    return (this.bQS & 0x400) != 0;
  }
  
  public final boolean Fc()
  {
    return (this.bQS & 0x1000) != 0;
  }
  
  public final boolean Fd()
  {
    return (this.bQS & 0x2000) != 0;
  }
  
  public final boolean Ff()
  {
    return (this.bQS & 0x4000) != 0;
  }
  
  public final boolean Fh()
  {
    return (this.bQS & 0x8000) != 0;
  }
  
  public final boolean Fj()
  {
    return (this.bQS & 0x10000) != 0;
  }
  
  public final boolean Fl()
  {
    return (this.bQS & 0x20000) != 0;
  }
  
  public final boolean Fn()
  {
    return (this.bQS & 0x40000) != 0;
  }
  
  public final boolean Fp()
  {
    return (this.bQS & 0x80000) != 0;
  }
  
  public final a Fr()
  {
    if (this == bTm) {
      return new a((byte)0);
    }
    return new a((byte)0).n(this);
  }
  
  public final void a(i parami)
  {
    bb.d.a locala = Ih();
    if ((this.bQS & 0x1) != 0) {
      bb.a(parami, 1, this.bST);
    }
    if ((this.bQS & 0x2) != 0) {
      bb.a(parami, 8, this.bSU);
    }
    if ((this.bQS & 0x20) != 0) {
      parami.bJ(9, this.bSY);
    }
    if ((this.bQS & 0x4) != 0) {
      parami.t(10, this.bSV);
    }
    if ((this.bQS & 0x40) != 0) {
      bb.a(parami, 11, this.bSZ);
    }
    if ((this.bQS & 0x80) != 0) {
      parami.t(16, this.bTa);
    }
    if ((this.bQS & 0x100) != 0) {
      parami.t(17, this.bTb);
    }
    if ((this.bQS & 0x200) != 0) {
      parami.t(18, this.bTc);
    }
    if ((this.bQS & 0x8) != 0) {
      parami.t(20, this.bSW);
    }
    if ((this.bQS & 0x800) != 0) {
      parami.t(23, this.bRz);
    }
    if ((this.bQS & 0x10) != 0) {
      parami.t(27, this.bSX);
    }
    if ((this.bQS & 0x1000) != 0) {
      parami.t(31, this.bTe);
    }
    if ((this.bQS & 0x2000) != 0) {
      bb.a(parami, 36, this.bTf);
    }
    if ((this.bQS & 0x4000) != 0) {
      bb.a(parami, 37, this.bTg);
    }
    if ((this.bQS & 0x8000) != 0) {
      bb.a(parami, 39, this.bTh);
    }
    if ((this.bQS & 0x10000) != 0) {
      bb.a(parami, 40, this.bTi);
    }
    if ((this.bQS & 0x20000) != 0) {
      bb.a(parami, 41, this.bTj);
    }
    if ((this.bQS & 0x400) != 0) {
      parami.t(42, this.bTd);
    }
    if ((this.bQS & 0x40000) != 0) {
      bb.a(parami, 44, this.bTk);
    }
    if ((this.bQS & 0x80000) != 0) {
      bb.a(parami, 45, this.bTl);
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
      if (!(paramObject instanceof j)) {
        return super.equals(paramObject);
      }
      paramObject = (j)paramObject;
      if (EN() != paramObject.EN()) {
        return false;
      }
      if ((EN()) && (!EO().equals(paramObject.EO()))) {
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
      if ((ER()) && (this.bSV != paramObject.bSV)) {
        return false;
      }
      if (ES() != paramObject.ES()) {
        return false;
      }
      if ((ES()) && (this.bSW != paramObject.bSW)) {
        return false;
      }
      if (ET() != paramObject.ET()) {
        return false;
      }
      if ((ET()) && (this.bSX != paramObject.bSX)) {
        return false;
      }
      if (EU() != paramObject.EU()) {
        return false;
      }
      if ((EU()) && (this.bSY != paramObject.bSY)) {
        return false;
      }
      if (EW() != paramObject.EW()) {
        return false;
      }
      if ((EW()) && (!EX().equals(paramObject.EX()))) {
        return false;
      }
      if (EY() != paramObject.EY()) {
        return false;
      }
      if ((EY()) && (this.bTa != paramObject.bTa)) {
        return false;
      }
      if (EZ() != paramObject.EZ()) {
        return false;
      }
      if ((EZ()) && (this.bTb != paramObject.bTb)) {
        return false;
      }
      if (Fa() != paramObject.Fa()) {
        return false;
      }
      if ((Fa()) && (this.bTc != paramObject.bTc)) {
        return false;
      }
      if (Fb() != paramObject.Fb()) {
        return false;
      }
      if ((Fb()) && (this.bTd != paramObject.bTd)) {
        return false;
      }
      if (Dr() != paramObject.Dr()) {
        return false;
      }
      if ((Dr()) && (this.bRz != paramObject.bRz)) {
        return false;
      }
      if (Fc() != paramObject.Fc()) {
        return false;
      }
      if ((Fc()) && (this.bTe != paramObject.bTe)) {
        return false;
      }
      if (Fd() != paramObject.Fd()) {
        return false;
      }
      if ((Fd()) && (!Fe().equals(paramObject.Fe()))) {
        return false;
      }
      if (Ff() != paramObject.Ff()) {
        return false;
      }
      if ((Ff()) && (!Fg().equals(paramObject.Fg()))) {
        return false;
      }
      if (Fh() != paramObject.Fh()) {
        return false;
      }
      if ((Fh()) && (!Fi().equals(paramObject.Fi()))) {
        return false;
      }
      if (Fj() != paramObject.Fj()) {
        return false;
      }
      if ((Fj()) && (!Fk().equals(paramObject.Fk()))) {
        return false;
      }
      if (Fl() != paramObject.Fl()) {
        return false;
      }
      if ((Fl()) && (!Fm().equals(paramObject.Fm()))) {
        return false;
      }
      if (Fn() != paramObject.Fn()) {
        return false;
      }
      if ((Fn()) && (!Fo().equals(paramObject.Fo()))) {
        return false;
      }
      if (Fp() != paramObject.Fp()) {
        return false;
      }
      if ((Fp()) && (!Fq().equals(paramObject.Fq()))) {
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
    int j = k.BC().hashCode() + 779;
    int i = j;
    if (EN()) {
      i = (j * 37 + 1) * 53 + EO().hashCode();
    }
    j = i;
    if (EP()) {
      j = (i * 37 + 8) * 53 + EQ().hashCode();
    }
    i = j;
    if (ER()) {
      i = (j * 37 + 10) * 53 + be.bS(this.bSV);
    }
    j = i;
    if (ES()) {
      j = (i * 37 + 20) * 53 + be.bS(this.bSW);
    }
    i = j;
    if (ET()) {
      i = (j * 37 + 27) * 53 + be.bS(this.bSX);
    }
    j = i;
    if (EU()) {
      j = (i * 37 + 9) * 53 + this.bSY;
    }
    i = j;
    if (EW()) {
      i = (j * 37 + 11) * 53 + EX().hashCode();
    }
    j = i;
    if (EY()) {
      j = (i * 37 + 16) * 53 + be.bS(this.bTa);
    }
    i = j;
    if (EZ()) {
      i = (j * 37 + 17) * 53 + be.bS(this.bTb);
    }
    j = i;
    if (Fa()) {
      j = (i * 37 + 18) * 53 + be.bS(this.bTc);
    }
    i = j;
    if (Fb()) {
      i = (j * 37 + 42) * 53 + be.bS(this.bTd);
    }
    j = i;
    if (Dr()) {
      j = (i * 37 + 23) * 53 + be.bS(this.bRz);
    }
    i = j;
    if (Fc()) {
      i = (j * 37 + 31) * 53 + be.bS(this.bTe);
    }
    j = i;
    if (Fd()) {
      j = (i * 37 + 36) * 53 + Fe().hashCode();
    }
    i = j;
    if (Ff()) {
      i = (j * 37 + 37) * 53 + Fg().hashCode();
    }
    j = i;
    if (Fh()) {
      j = (i * 37 + 39) * 53 + Fi().hashCode();
    }
    i = j;
    if (Fj()) {
      i = (j * 37 + 40) * 53 + Fk().hashCode();
    }
    j = i;
    if (Fl()) {
      j = (i * 37 + 41) * 53 + Fm().hashCode();
    }
    i = j;
    if (Fn()) {
      i = (j * 37 + 44) * 53 + Fo().hashCode();
    }
    j = i;
    if (Fp()) {
      j = (i * 37 + 45) * 53 + Fq().hashCode();
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
    extends bb.c<k.j, a>
    implements x
  {
    private int bQS;
    private List<k.s> bRA = Collections.emptyList();
    private co<k.s, k.s.a, ai> bRC;
    private boolean bRz;
    private Object bST = "";
    private Object bSU = "";
    private boolean bSV;
    private boolean bSW;
    private boolean bSX;
    private int bSY = 1;
    private Object bSZ = "";
    private boolean bTa;
    private boolean bTb;
    private boolean bTc;
    private boolean bTd;
    private boolean bTe;
    private Object bTf = "";
    private Object bTg = "";
    private Object bTh = "";
    private Object bTi = "";
    private Object bTj = "";
    private Object bTk = "";
    private Object bTl = "";
    
    private a()
    {
      Cu();
    }
    
    private a(bb.b paramb)
    {
      super();
      Cu();
    }
    
    private a C(da paramda)
    {
      return (a)super.e(paramda);
    }
    
    private void Cu()
    {
      if (bb.bXS) {
        Dy();
      }
    }
    
    private a D(da paramda)
    {
      return (a)super.d(paramda);
    }
    
    private void Dx()
    {
      if ((this.bQS & 0x100000) == 0)
      {
        this.bRA = new ArrayList(this.bRA);
        this.bQS |= 0x100000;
      }
    }
    
    private co<k.s, k.s.a, ai> Dy()
    {
      List localList;
      if (this.bRC == null)
      {
        localList = this.bRA;
        if ((this.bQS & 0x100000) == 0) {
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
    
    private a E(aj.f paramf, Object paramObject)
    {
      return (a)super.r(paramf, paramObject);
    }
    
    private a F(aj.f paramf, Object paramObject)
    {
      return (a)super.q(paramf, paramObject);
    }
    
    private k.j Ft()
    {
      k.j localj = Fu();
      if (!localj.isInitialized()) {
        throw b(localj);
      }
      return localj;
    }
    
    private a a(k.j.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException();
      }
      this.bQS |= 0x20;
      this.bSY = paramb.value;
      onChanged();
      return this;
    }
    
    @Deprecated
    private a bA(boolean paramBoolean)
    {
      this.bQS |= 0x8;
      this.bSW = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bB(boolean paramBoolean)
    {
      this.bQS |= 0x10;
      this.bSX = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bC(boolean paramBoolean)
    {
      this.bQS |= 0x80;
      this.bTa = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bD(boolean paramBoolean)
    {
      this.bQS |= 0x100;
      this.bTb = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bE(boolean paramBoolean)
    {
      this.bQS |= 0x200;
      this.bTc = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bF(boolean paramBoolean)
    {
      this.bQS |= 0x400;
      this.bTd = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bG(boolean paramBoolean)
    {
      this.bQS |= 0x800;
      this.bRz = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bH(boolean paramBoolean)
    {
      this.bQS |= 0x1000;
      this.bTe = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bz(boolean paramBoolean)
    {
      this.bQS |= 0x4;
      this.bSV = paramBoolean;
      onChanged();
      return this;
    }
    
    private a p(bt parambt)
    {
      if ((parambt instanceof k.j)) {
        return n((k.j)parambt);
      }
      super.a(parambt);
      return this;
    }
    
    /* Error */
    private a q(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 215	com/google/b/k$j:bRf	Lcom/google/b/ci;
      //   5: aload_1
      //   6: aload_2
      //   7: invokeinterface 220 3 0
      //   12: checkcast 9	com/google/b/k$j
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_0
      //   21: aload_1
      //   22: invokevirtual 205	com/google/b/k$j$a:n	(Lcom/google/b/k$j;)Lcom/google/b/k$j$a;
      //   25: pop
      //   26: aload_0
      //   27: areturn
      //   28: astore_1
      //   29: aload_1
      //   30: getfield 224	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   33: checkcast 9	com/google/b/k$j
      //   36: astore_2
      //   37: aload_1
      //   38: invokevirtual 228	com/google/b/bf:Im	()Ljava/io/IOException;
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: ifnull +9 -> 53
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual 205	com/google/b/k$j$a:n	(Lcom/google/b/k$j;)Lcom/google/b/k$j$a;
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
      return k.BD().b(k.j.class, a.class);
    }
    
    public final aj.a Cv()
    {
      return k.BC();
    }
    
    public final k.j Fu()
    {
      int j = 0;
      k.j localj = new k.j(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) != 0) {
        j = 1;
      }
      k.j.a(localj, this.bST);
      int i = j;
      if ((k & 0x2) != 0) {
        i = j | 0x2;
      }
      k.j.b(localj, this.bSU);
      j = i;
      if ((k & 0x4) != 0)
      {
        k.j.a(localj, this.bSV);
        j = i | 0x4;
      }
      i = j;
      if ((k & 0x8) != 0)
      {
        k.j.b(localj, this.bSW);
        i = j | 0x8;
      }
      j = i;
      if ((k & 0x10) != 0)
      {
        k.j.c(localj, this.bSX);
        j = i | 0x10;
      }
      i = j;
      if ((k & 0x20) != 0) {
        i = j | 0x20;
      }
      k.j.a(localj, this.bSY);
      j = i;
      if ((k & 0x40) != 0) {
        j = i | 0x40;
      }
      k.j.c(localj, this.bSZ);
      i = j;
      if ((k & 0x80) != 0)
      {
        k.j.d(localj, this.bTa);
        i = j | 0x80;
      }
      j = i;
      if ((k & 0x100) != 0)
      {
        k.j.e(localj, this.bTb);
        j = i | 0x100;
      }
      i = j;
      if ((k & 0x200) != 0)
      {
        k.j.f(localj, this.bTc);
        i = j | 0x200;
      }
      j = i;
      if ((k & 0x400) != 0)
      {
        k.j.g(localj, this.bTd);
        j = i | 0x400;
      }
      i = j;
      if ((k & 0x800) != 0)
      {
        k.j.h(localj, this.bRz);
        i = j | 0x800;
      }
      j = i;
      if ((k & 0x1000) != 0)
      {
        k.j.i(localj, this.bTe);
        j = i | 0x1000;
      }
      i = j;
      if ((k & 0x2000) != 0) {
        i = j | 0x2000;
      }
      k.j.d(localj, this.bTf);
      j = i;
      if ((k & 0x4000) != 0) {
        j = i | 0x4000;
      }
      k.j.e(localj, this.bTg);
      i = j;
      if ((k & 0x8000) != 0) {
        i = j | 0x8000;
      }
      k.j.f(localj, this.bTh);
      j = i;
      if ((k & 0x10000) != 0) {
        j = i | 0x10000;
      }
      k.j.g(localj, this.bTi);
      i = j;
      if ((k & 0x20000) != 0) {
        i = j | 0x20000;
      }
      k.j.h(localj, this.bTj);
      j = i;
      if ((k & 0x40000) != 0) {
        j = i | 0x40000;
      }
      k.j.i(localj, this.bTk);
      i = j;
      if ((k & 0x80000) != 0) {
        i = j | 0x80000;
      }
      k.j.j(localj, this.bTl);
      if (this.bRC == null)
      {
        if ((this.bQS & 0x100000) != 0)
        {
          this.bRA = Collections.unmodifiableList(this.bRA);
          this.bQS &= 0xFFEFFFFF;
        }
        k.j.a(localj, this.bRA);
      }
      for (;;)
      {
        k.j.b(localj, i);
        Ib();
        return localj;
        k.j.a(localj, this.bRC.build());
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
    
    public final a n(k.j paramj)
    {
      co localco = null;
      if (paramj == k.j.Fs()) {
        return this;
      }
      if (paramj.EN())
      {
        this.bQS |= 0x1;
        this.bST = k.j.c(paramj);
        onChanged();
      }
      if (paramj.EP())
      {
        this.bQS |= 0x2;
        this.bSU = k.j.d(paramj);
        onChanged();
      }
      if (paramj.ER()) {
        bz(paramj.bSV);
      }
      if (paramj.ES()) {
        bA(paramj.bSW);
      }
      if (paramj.ET()) {
        bB(paramj.bSX);
      }
      if (paramj.EU()) {
        a(paramj.EV());
      }
      if (paramj.EW())
      {
        this.bQS |= 0x40;
        this.bSZ = k.j.e(paramj);
        onChanged();
      }
      if (paramj.EY()) {
        bC(paramj.bTa);
      }
      if (paramj.EZ()) {
        bD(paramj.bTb);
      }
      if (paramj.Fa()) {
        bE(paramj.bTc);
      }
      if (paramj.Fb()) {
        bF(paramj.bTd);
      }
      if (paramj.Dr()) {
        bG(paramj.bRz);
      }
      if (paramj.Fc()) {
        bH(paramj.bTe);
      }
      if (paramj.Fd())
      {
        this.bQS |= 0x2000;
        this.bTf = k.j.f(paramj);
        onChanged();
      }
      if (paramj.Ff())
      {
        this.bQS |= 0x4000;
        this.bTg = k.j.g(paramj);
        onChanged();
      }
      if (paramj.Fh())
      {
        this.bQS |= 0x8000;
        this.bTh = k.j.h(paramj);
        onChanged();
      }
      if (paramj.Fj())
      {
        this.bQS |= 0x10000;
        this.bTi = k.j.i(paramj);
        onChanged();
      }
      if (paramj.Fl())
      {
        this.bQS |= 0x20000;
        this.bTj = k.j.j(paramj);
        onChanged();
      }
      if (paramj.Fn())
      {
        this.bQS |= 0x40000;
        this.bTk = k.j.k(paramj);
        onChanged();
      }
      if (paramj.Fp())
      {
        this.bQS |= 0x80000;
        this.bTl = k.j.l(paramj);
        onChanged();
      }
      if (this.bRC == null) {
        if (!k.j.m(paramj).isEmpty())
        {
          if (!this.bRA.isEmpty()) {
            break label551;
          }
          this.bRA = k.j.m(paramj);
          this.bQS &= 0xFFEFFFFF;
          onChanged();
        }
      }
      for (;;)
      {
        a(paramj);
        D(paramj.bVW);
        onChanged();
        return this;
        label551:
        Dx();
        this.bRA.addAll(k.j.m(paramj));
        break;
        if (!k.j.m(paramj).isEmpty()) {
          if (this.bRC.isEmpty())
          {
            this.bRC.cat = null;
            this.bRC = null;
            this.bRA = k.j.m(paramj);
            this.bQS &= 0xFFEFFFFF;
            if (bb.bXS) {
              localco = Dy();
            }
            this.bRC = localco;
          }
          else
          {
            this.bRC.a(k.j.m(paramj));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.j
 * JD-Core Version:    0.7.0.1
 */