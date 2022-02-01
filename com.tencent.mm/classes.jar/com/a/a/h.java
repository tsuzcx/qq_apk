package com.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
{
  private static j aQl = null;
  private static boolean aQm = true;
  af aQn;
  private float aQo;
  b.q aQp;
  private Map<String, al> aQq;
  String desc;
  String title;
  
  h()
  {
    AppMethodBeat.i(214811);
    this.aQn = null;
    this.title = "";
    this.desc = "";
    this.aQo = 96.0F;
    this.aQp = new b.q();
    this.aQq = new HashMap();
    AppMethodBeat.o(214811);
  }
  
  private b R(float paramFloat)
  {
    AppMethodBeat.i(214818);
    Object localObject = this.aQn.aQR;
    p localp = this.aQn.aQS;
    if ((localObject == null) || (((p)localObject).isZero()) || (((p)localObject).aQT == bd.aTo) || (((p)localObject).aQT == bd.aTh) || (((p)localObject).aQT == bd.aTi))
    {
      localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
      AppMethodBeat.o(214818);
      return localObject;
    }
    float f = ((p)localObject).S(paramFloat);
    if (localp != null)
    {
      if ((localp.isZero()) || (localp.aQT == bd.aTo) || (localp.aQT == bd.aTh) || (localp.aQT == bd.aTi))
      {
        localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
        AppMethodBeat.o(214818);
        return localObject;
      }
      paramFloat = localp.S(paramFloat);
    }
    for (;;)
    {
      localObject = new b(0.0F, 0.0F, f, paramFloat);
      AppMethodBeat.o(214818);
      return localObject;
      if (this.aQn.aQi != null) {
        paramFloat = this.aQn.aQi.height * f / this.aQn.aQi.width;
      } else {
        paramFloat = f;
      }
    }
  }
  
  private al a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(214823);
    Object localObject = (al)paramaj;
    if (paramString.equals(((al)localObject).id))
    {
      AppMethodBeat.o(214823);
      return localObject;
    }
    paramaj = paramaj.getChildren().iterator();
    while (paramaj.hasNext())
    {
      localObject = (an)paramaj.next();
      if ((localObject instanceof al))
      {
        al localal = (al)localObject;
        if (paramString.equals(localal.id))
        {
          AppMethodBeat.o(214823);
          return localal;
        }
        if ((localObject instanceof aj))
        {
          localObject = a((aj)localObject, paramString);
          if (localObject != null)
          {
            AppMethodBeat.o(214823);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(214823);
    return null;
  }
  
  private Picture ba(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214814);
    Picture localPicture = new Picture();
    Canvas localCanvas = localPicture.beginRecording(paramInt1, paramInt2);
    g localg = new g();
    localg.p(paramInt1, paramInt2);
    new i(localCanvas, this.aQo).a(this, localg);
    localPicture.endRecording();
    AppMethodBeat.o(214814);
    return localPicture;
  }
  
  public static h f(InputStream paramInputStream)
  {
    AppMethodBeat.i(214812);
    paramInputStream = new l().a(paramInputStream, aQm);
    AppMethodBeat.o(214812);
    return paramInputStream;
  }
  
  static j qN()
  {
    return aQl;
  }
  
  final an Y(String paramString)
  {
    AppMethodBeat.i(214817);
    if (paramString == null)
    {
      AppMethodBeat.o(214817);
      return null;
    }
    String str;
    if ((paramString.startsWith("\"")) && (paramString.endsWith("\""))) {
      str = paramString.substring(1, paramString.length() - 1).replace("\\\"", "\"");
    }
    for (;;)
    {
      paramString = str.replace("\\\n", "").replace("\\A", "\n");
      if ((paramString.length() <= 1) || (!paramString.startsWith("#"))) {
        break;
      }
      paramString = Z(paramString.substring(1));
      AppMethodBeat.o(214817);
      return paramString;
      str = paramString;
      if (paramString.startsWith("'"))
      {
        str = paramString;
        if (paramString.endsWith("'")) {
          str = paramString.substring(1, paramString.length() - 1).replace("\\'", "'");
        }
      }
    }
    AppMethodBeat.o(214817);
    return null;
  }
  
  final al Z(String paramString)
  {
    AppMethodBeat.i(214822);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(214822);
      return null;
    }
    if (paramString.equals(this.aQn.id))
    {
      paramString = this.aQn;
      AppMethodBeat.o(214822);
      return paramString;
    }
    if (this.aQq.containsKey(paramString))
    {
      paramString = (al)this.aQq.get(paramString);
      AppMethodBeat.o(214822);
      return paramString;
    }
    al localal = a(this.aQn, paramString);
    this.aQq.put(paramString, localal);
    AppMethodBeat.o(214822);
    return localal;
  }
  
  final void b(b.q paramq)
  {
    AppMethodBeat.i(214819);
    this.aQp.a(paramq);
    AppMethodBeat.o(214819);
  }
  
  public final Picture qI()
  {
    AppMethodBeat.i(214813);
    Object localObject = this.aQn.aQi;
    float f1;
    float f2;
    if ((this.aQn.aQR != null) && (this.aQn.aQR.aQT != bd.aTo) && (this.aQn.aQS != null) && (this.aQn.aQS.aQT != bd.aTo))
    {
      f1 = this.aQn.aQR.S(this.aQo);
      f2 = this.aQn.aQS.S(this.aQo);
      localObject = ba((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(214813);
      return localObject;
    }
    if ((this.aQn.aQR != null) && (localObject != null))
    {
      f1 = this.aQn.aQR.S(this.aQo);
      f2 = ((b)localObject).height * f1 / ((b)localObject).width;
      localObject = ba((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(214813);
      return localObject;
    }
    if ((this.aQn.aQS != null) && (localObject != null))
    {
      f1 = this.aQn.aQS.S(this.aQo);
      localObject = ba((int)Math.ceil(((b)localObject).width * f1 / ((b)localObject).height), (int)Math.ceil(f1));
      AppMethodBeat.o(214813);
      return localObject;
    }
    localObject = ba(512, 512);
    AppMethodBeat.o(214813);
    return localObject;
  }
  
  public final float qJ()
  {
    AppMethodBeat.i(214815);
    if (this.aQn == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(214815);
      throw localIllegalArgumentException;
    }
    float f = R(this.aQo).width;
    AppMethodBeat.o(214815);
    return f;
  }
  
  public final float qK()
  {
    AppMethodBeat.i(214816);
    if (this.aQn == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(214816);
      throw localIllegalArgumentException;
    }
    float f = R(this.aQo).height;
    AppMethodBeat.o(214816);
    return f;
  }
  
  final boolean qL()
  {
    AppMethodBeat.i(214820);
    b.q localq = this.aQp;
    if ((localq.aPt == null) || (localq.aPt.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(214820);
      return true;
    }
    AppMethodBeat.o(214820);
    return false;
  }
  
  final void qM()
  {
    AppMethodBeat.i(214821);
    Object localObject = this.aQp;
    b.t localt = b.t.aPA;
    if (((b.q)localObject).aPt != null)
    {
      localObject = ((b.q)localObject).aPt.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((b.o)((Iterator)localObject).next()).aOl == localt) {
          ((Iterator)localObject).remove();
        }
      }
    }
    AppMethodBeat.o(214821);
  }
  
  static final class a
    extends h.m
  {
    String aQs;
    
    final String getNodeName()
    {
      return "a";
    }
  }
  
  static final class aa
    extends h.z
  {
    final String getNodeName()
    {
      return "polygon";
    }
  }
  
  static final class ab
    extends h.l
  {
    h.p aQF;
    h.p aQG;
    h.p aQP;
    h.p aQQ;
    h.p aQR;
    h.p aQS;
    
    final String getNodeName()
    {
      return "rect";
    }
  }
  
  static final class ac
    extends h.al
    implements h.aj
  {
    public final void a(h.an paraman) {}
    
    public final List<h.an> getChildren()
    {
      AppMethodBeat.i(214775);
      List localList = Collections.emptyList();
      AppMethodBeat.o(214775);
      return localList;
    }
    
    final String getNodeName()
    {
      return "solidColor";
    }
  }
  
  static final class ad
    extends h.al
    implements h.aj
  {
    Float aRq;
    
    public final void a(h.an paraman) {}
    
    public final List<h.an> getChildren()
    {
      AppMethodBeat.i(214776);
      List localList = Collections.emptyList();
      AppMethodBeat.o(214776);
      return localList;
    }
    
    final String getNodeName()
    {
      return "stop";
    }
  }
  
  static final class ae
    implements Cloneable
  {
    Float aRA;
    h.p[] aRB;
    h.p aRC;
    Float aRD;
    h.f aRE;
    List<String> aRF;
    h.p aRG;
    Integer aRH;
    b aRI;
    g aRJ;
    h.ae.h aRK;
    f aRL;
    Boolean aRM;
    h.c aRN;
    String aRO;
    String aRP;
    String aRQ;
    Boolean aRR;
    Boolean aRS;
    h.ao aRT;
    Float aRU;
    String aRV;
    h.ae.a aRW;
    String aRX;
    h.ao aRY;
    Float aRZ;
    long aRr = 0L;
    h.ao aRs;
    h.ae.a aRt;
    Float aRu;
    h.ao aRv;
    Float aRw;
    h.p aRx;
    c aRy;
    d aRz;
    h.ao aSa;
    Float aSb;
    h.ae.i aSc;
    e aSd;
    
    static ae qR()
    {
      AppMethodBeat.i(214804);
      ae localae = new ae();
      localae.aRr = -1L;
      localae.aRs = h.f.aQC;
      localae.aRt = h.ae.a.aSe;
      localae.aRu = Float.valueOf(1.0F);
      localae.aRv = null;
      localae.aRw = Float.valueOf(1.0F);
      localae.aRx = new h.p(1.0F);
      localae.aRy = c.aSl;
      localae.aRz = d.aSp;
      localae.aRA = Float.valueOf(4.0F);
      localae.aRB = null;
      localae.aRC = new h.p(0.0F);
      localae.aRD = Float.valueOf(1.0F);
      localae.aRE = h.f.aQC;
      localae.aRF = null;
      localae.aRG = new h.p(12.0F, h.bd.aTm);
      localae.aRH = Integer.valueOf(400);
      localae.aRI = b.aSh;
      localae.aRJ = g.aSB;
      localae.aRK = h.ae.h.aSH;
      localae.aRL = f.aSx;
      localae.aRM = Boolean.TRUE;
      localae.aRN = null;
      localae.aRO = null;
      localae.aRP = null;
      localae.aRQ = null;
      localae.aRR = Boolean.TRUE;
      localae.aRS = Boolean.TRUE;
      localae.aRT = h.f.aQC;
      localae.aRU = Float.valueOf(1.0F);
      localae.aRV = null;
      localae.aRW = h.ae.a.aSe;
      localae.aRX = null;
      localae.aRY = null;
      localae.aRZ = Float.valueOf(1.0F);
      localae.aSa = null;
      localae.aSb = Float.valueOf(1.0F);
      localae.aSc = h.ae.i.aSK;
      localae.aSd = e.aSt;
      AppMethodBeat.o(214804);
      return localae;
    }
    
    final void aJ(boolean paramBoolean)
    {
      AppMethodBeat.i(214805);
      this.aRR = Boolean.TRUE;
      if (paramBoolean) {}
      for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
      {
        this.aRM = localBoolean;
        this.aRN = null;
        this.aRV = null;
        this.aRD = Float.valueOf(1.0F);
        this.aRT = h.f.aQC;
        this.aRU = Float.valueOf(1.0F);
        this.aRX = null;
        this.aRY = null;
        this.aRZ = Float.valueOf(1.0F);
        this.aSa = null;
        this.aSb = Float.valueOf(1.0F);
        this.aSc = h.ae.i.aSK;
        AppMethodBeat.o(214805);
        return;
      }
    }
    
    protected final Object clone()
    {
      AppMethodBeat.i(214806);
      ae localae = (ae)super.clone();
      if (this.aRB != null) {
        localae.aRB = ((h.p[])this.aRB.clone());
      }
      AppMethodBeat.o(214806);
      return localae;
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(214782);
        aSh = new b("Normal", 0);
        aSi = new b("Italic", 1);
        aSj = new b("Oblique", 2);
        aSk = new b[] { aSh, aSi, aSj };
        AppMethodBeat.o(214782);
      }
      
      private b() {}
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(214785);
        aSl = new c("Butt", 0);
        aSm = new c("Round", 1);
        aSn = new c("Square", 2);
        aSo = new c[] { aSl, aSm, aSn };
        AppMethodBeat.o(214785);
      }
      
      private c() {}
    }
    
    public static enum d
    {
      static
      {
        AppMethodBeat.i(214788);
        aSp = new d("Miter", 0);
        aSq = new d("Round", 1);
        aSr = new d("Bevel", 2);
        aSs = new d[] { aSp, aSq, aSr };
        AppMethodBeat.o(214788);
      }
      
      private d() {}
    }
    
    public static enum e
    {
      static
      {
        AppMethodBeat.i(214791);
        aSt = new e("auto", 0);
        aSu = new e("optimizeQuality", 1);
        aSv = new e("optimizeSpeed", 2);
        aSw = new e[] { aSt, aSu, aSv };
        AppMethodBeat.o(214791);
      }
      
      private e() {}
    }
    
    public static enum f
    {
      static
      {
        AppMethodBeat.i(214794);
        aSx = new f("Start", 0);
        aSy = new f("Middle", 1);
        aSz = new f("End", 2);
        aSA = new f[] { aSx, aSy, aSz };
        AppMethodBeat.o(214794);
      }
      
      private f() {}
    }
    
    public static enum g
    {
      static
      {
        AppMethodBeat.i(214797);
        aSB = new g("None", 0);
        aSC = new g("Underline", 1);
        aSD = new g("Overline", 2);
        aSE = new g("LineThrough", 3);
        aSF = new g("Blink", 4);
        aSG = new g[] { aSB, aSC, aSD, aSE, aSF };
        AppMethodBeat.o(214797);
      }
      
      private g() {}
    }
  }
  
  static final class af
    extends h.ar
  {
    h.p aQP;
    h.p aQQ;
    h.p aQR;
    h.p aQS;
    public String version;
    
    final String getNodeName()
    {
      return "svg";
    }
  }
  
  static abstract interface ag
  {
    public abstract void aa(String paramString);
    
    public abstract void b(Set<String> paramSet);
    
    public abstract void c(Set<String> paramSet);
    
    public abstract void d(Set<String> paramSet);
    
    public abstract void e(Set<String> paramSet);
    
    public abstract Set<String> qS();
    
    public abstract String qT();
    
    public abstract Set<String> qU();
    
    public abstract Set<String> qV();
    
    public abstract Set<String> qW();
  }
  
  static abstract class ah
    extends h.ak
    implements h.ag, h.aj
  {
    List<h.an> aQH = new ArrayList();
    Set<String> aSN = null;
    String aSO = null;
    Set<String> aSP = null;
    Set<String> aSQ = null;
    Set<String> aSR = null;
    
    public void a(h.an paraman)
    {
      this.aQH.add(paraman);
    }
    
    public final void aa(String paramString)
    {
      this.aSO = paramString;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.aSN = paramSet;
    }
    
    public final void c(Set<String> paramSet)
    {
      this.aSP = paramSet;
    }
    
    public final void d(Set<String> paramSet)
    {
      this.aSQ = paramSet;
    }
    
    public final void e(Set<String> paramSet)
    {
      this.aSR = paramSet;
    }
    
    public final List<h.an> getChildren()
    {
      return this.aQH;
    }
    
    public final Set<String> qS()
    {
      return this.aSN;
    }
    
    public final String qT()
    {
      return this.aSO;
    }
    
    public final Set<String> qU()
    {
      return null;
    }
    
    public final Set<String> qV()
    {
      return this.aSQ;
    }
    
    public final Set<String> qW()
    {
      return this.aSR;
    }
  }
  
  static abstract class ai
    extends h.ak
    implements h.ag
  {
    Set<String> aSN = null;
    String aSO = null;
    Set<String> aSP = null;
    Set<String> aSQ = null;
    Set<String> aSR = null;
    
    public final void aa(String paramString)
    {
      this.aSO = paramString;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.aSN = paramSet;
    }
    
    public final void c(Set<String> paramSet)
    {
      this.aSP = paramSet;
    }
    
    public final void d(Set<String> paramSet)
    {
      this.aSQ = paramSet;
    }
    
    public final void e(Set<String> paramSet)
    {
      this.aSR = paramSet;
    }
    
    public final Set<String> qS()
    {
      return this.aSN;
    }
    
    public final String qT()
    {
      return this.aSO;
    }
    
    public final Set<String> qU()
    {
      return this.aSP;
    }
    
    public final Set<String> qV()
    {
      return this.aSQ;
    }
    
    public final Set<String> qW()
    {
      return this.aSR;
    }
  }
  
  static abstract interface aj
  {
    public abstract void a(h.an paraman);
    
    public abstract List<h.an> getChildren();
  }
  
  static abstract class ak
    extends h.al
  {
    h.b aSS = null;
  }
  
  static abstract class al
    extends h.an
  {
    h.ae aPr = null;
    Boolean aST = null;
    h.ae aSU = null;
    List<String> aSV = null;
    String id = null;
    
    public String toString()
    {
      return getNodeName();
    }
  }
  
  static final class am
    extends h.j
  {
    h.p aQU;
    h.p aQV;
    h.p aQW;
    h.p aQX;
    
    final String getNodeName()
    {
      return "linearGradient";
    }
  }
  
  static class an
  {
    h aSW;
    h.aj aSX;
    
    String getNodeName()
    {
      return "";
    }
  }
  
  static abstract class ao
    implements Cloneable
  {}
  
  static abstract class ap
    extends h.ah
  {
    f aQg = null;
  }
  
  static final class aq
    extends h.j
  {
    h.p aQx;
    h.p aQy;
    h.p aQz;
    h.p aSY;
    h.p aSZ;
    
    final String getNodeName()
    {
      return "radialGradient";
    }
  }
  
  static abstract class ar
    extends h.ap
  {
    h.b aQi;
  }
  
  static final class as
    extends h.m
  {
    final String getNodeName()
    {
      return "switch";
    }
  }
  
  static final class at
    extends h.ar
    implements h.t
  {
    final String getNodeName()
    {
      return "symbol";
    }
  }
  
  static final class au
    extends h.ay
    implements h.ax
  {
    String aQs;
    h.bb aTa;
    
    final String getNodeName()
    {
      return "tref";
    }
    
    public final h.bb qX()
    {
      return this.aTa;
    }
  }
  
  static final class av
    extends h.ba
    implements h.ax
  {
    h.bb aTa;
    
    final String getNodeName()
    {
      return "tspan";
    }
    
    public final h.bb qX()
    {
      return this.aTa;
    }
  }
  
  static final class aw
    extends h.ba
    implements h.bb, h.n
  {
    Matrix transform;
    
    final String getNodeName()
    {
      return "text";
    }
    
    public final void setTransform(Matrix paramMatrix)
    {
      this.transform = paramMatrix;
    }
  }
  
  static abstract interface ax
  {
    public abstract h.bb qX();
  }
  
  static abstract class ay
    extends h.ah
  {
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ax))
      {
        this.aQH.add(paraman);
        return;
      }
      throw new k("Text content elements cannot contain " + paraman + " elements.");
    }
  }
  
  static final class az
    extends h.ay
    implements h.ax
  {
    String aQs;
    h.bb aTa;
    h.p aTb;
    
    final String getNodeName()
    {
      return "textPath";
    }
    
    public final h.bb qX()
    {
      return this.aTa;
    }
  }
  
  static final class b
  {
    float height;
    float minX;
    float minY;
    float width;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.minX = paramFloat1;
      this.minY = paramFloat2;
      this.width = paramFloat3;
      this.height = paramFloat4;
    }
    
    b(b paramb)
    {
      this.minX = paramb.minX;
      this.minY = paramb.minY;
      this.width = paramb.width;
      this.height = paramb.height;
    }
    
    static b i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(214749);
      b localb = new b(paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      AppMethodBeat.o(214749);
      return localb;
    }
    
    final void a(b paramb)
    {
      AppMethodBeat.i(214750);
      if (paramb.minX < this.minX) {
        this.minX = paramb.minX;
      }
      if (paramb.minY < this.minY) {
        this.minY = paramb.minY;
      }
      if (paramb.qO() > qO()) {
        this.width = (paramb.qO() - this.minX);
      }
      if (paramb.qP() > qP()) {
        this.height = (paramb.qP() - this.minY);
      }
      AppMethodBeat.o(214750);
    }
    
    final float qO()
    {
      return this.minX + this.width;
    }
    
    final float qP()
    {
      return this.minY + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214751);
      String str = "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
      AppMethodBeat.o(214751);
      return str;
    }
  }
  
  static abstract class ba
    extends h.ay
  {
    List<h.p> aTc;
    List<h.p> aTd;
    List<h.p> aTe;
    List<h.p> aTf;
  }
  
  static abstract interface bb {}
  
  static final class bc
    extends h.an
    implements h.ax
  {
    private h.bb aTa;
    String text;
    
    bc(String paramString)
    {
      this.text = paramString;
    }
    
    public final h.bb qX()
    {
      return this.aTa;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214807);
      String str = "TextChild: '" + this.text + "'";
      AppMethodBeat.o(214807);
      return str;
    }
  }
  
  static enum bd
  {
    static
    {
      AppMethodBeat.i(214810);
      aTg = new bd("px", 0);
      aTh = new bd("em", 1);
      aTi = new bd("ex", 2);
      aTj = new bd("in", 3);
      aTk = new bd("cm", 4);
      aTl = new bd("mm", 5);
      aTm = new bd("pt", 6);
      aTn = new bd("pc", 7);
      aTo = new bd("percent", 8);
      aTp = new bd[] { aTg, aTh, aTi, aTj, aTk, aTl, aTm, aTn, aTo };
      AppMethodBeat.o(214810);
    }
    
    private bd() {}
  }
  
  static final class be
    extends h.m
  {
    h.p aQP;
    h.p aQQ;
    h.p aQR;
    h.p aQS;
    String aQs;
    
    final String getNodeName()
    {
      return "use";
    }
  }
  
  static final class bf
    extends h.ar
    implements h.t
  {
    final String getNodeName()
    {
      return "view";
    }
  }
  
  static final class c
  {
    h.p aQt;
    h.p aQu;
    h.p aQv;
    h.p aQw;
    
    c(h.p paramp1, h.p paramp2, h.p paramp3, h.p paramp4)
    {
      this.aQt = paramp1;
      this.aQu = paramp2;
      this.aQv = paramp3;
      this.aQw = paramp4;
    }
  }
  
  static final class d
    extends h.l
  {
    h.p aQx;
    h.p aQy;
    h.p aQz;
    
    final String getNodeName()
    {
      return "circle";
    }
  }
  
  static final class e
    extends h.m
    implements h.t
  {
    Boolean aQA;
    
    final String getNodeName()
    {
      return "clipPath";
    }
  }
  
  static final class f
    extends h.ao
  {
    static final f aQC;
    static final f aQD;
    int aQB;
    
    static
    {
      AppMethodBeat.i(214753);
      aQC = new f(-16777216);
      aQD = new f(0);
      AppMethodBeat.o(214753);
    }
    
    f(int paramInt)
    {
      this.aQB = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214752);
      String str = String.format("#%08x", new Object[] { Integer.valueOf(this.aQB) });
      AppMethodBeat.o(214752);
      return str;
    }
  }
  
  static final class g
    extends h.ao
  {
    private static g aQE;
    
    static
    {
      AppMethodBeat.i(214754);
      aQE = new g();
      AppMethodBeat.o(214754);
    }
    
    static g qQ()
    {
      return aQE;
    }
  }
  
  static final class h
    extends h.m
    implements h.t
  {
    final String getNodeName()
    {
      return "defs";
    }
  }
  
  static final class i
    extends h.l
  {
    h.p aQF;
    h.p aQG;
    h.p aQx;
    h.p aQy;
    
    final String getNodeName()
    {
      return "ellipse";
    }
  }
  
  static abstract class j
    extends h.al
    implements h.aj
  {
    List<h.an> aQH = new ArrayList();
    Boolean aQI;
    Matrix aQJ;
    h.k aQK;
    String aQs;
    
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ad))
      {
        this.aQH.add(paraman);
        return;
      }
      throw new k("Gradient elements cannot contain " + paraman + " elements.");
    }
    
    public final List<h.an> getChildren()
    {
      return this.aQH;
    }
  }
  
  static enum k
  {
    static
    {
      AppMethodBeat.i(214757);
      aQL = new k("pad", 0);
      aQM = new k("reflect", 1);
      aQN = new k("repeat", 2);
      aQO = new k[] { aQL, aQM, aQN };
      AppMethodBeat.o(214757);
    }
    
    private k() {}
  }
  
  static abstract class l
    extends h.ai
    implements h.n
  {
    Matrix transform;
    
    public final void setTransform(Matrix paramMatrix)
    {
      this.transform = paramMatrix;
    }
  }
  
  static class m
    extends h.ah
    implements h.n
  {
    Matrix transform;
    
    String getNodeName()
    {
      return "group";
    }
    
    public final void setTransform(Matrix paramMatrix)
    {
      this.transform = paramMatrix;
    }
  }
  
  static abstract interface n
  {
    public abstract void setTransform(Matrix paramMatrix);
  }
  
  static final class o
    extends h.ap
    implements h.n
  {
    h.p aQP;
    h.p aQQ;
    h.p aQR;
    h.p aQS;
    String aQs;
    Matrix transform;
    
    final String getNodeName()
    {
      return "image";
    }
    
    public final void setTransform(Matrix paramMatrix)
    {
      this.transform = paramMatrix;
    }
  }
  
  static final class p
    implements Cloneable
  {
    h.bd aQT;
    float value;
    
    p(float paramFloat)
    {
      this.value = paramFloat;
      this.aQT = h.bd.aTg;
    }
    
    p(float paramFloat, h.bd parambd)
    {
      this.value = paramFloat;
      this.aQT = parambd;
    }
    
    final float S(float paramFloat)
    {
      AppMethodBeat.i(214762);
      switch (h.1.aQr[this.aQT.ordinal()])
      {
      case 2: 
      case 3: 
      default: 
        paramFloat = this.value;
        AppMethodBeat.o(214762);
        return paramFloat;
      case 1: 
        paramFloat = this.value;
        AppMethodBeat.o(214762);
        return paramFloat;
      case 4: 
        float f = this.value;
        AppMethodBeat.o(214762);
        return f * paramFloat;
      case 5: 
        paramFloat = this.value * paramFloat / 2.54F;
        AppMethodBeat.o(214762);
        return paramFloat;
      case 6: 
        paramFloat = this.value * paramFloat / 25.4F;
        AppMethodBeat.o(214762);
        return paramFloat;
      case 7: 
        paramFloat = this.value * paramFloat / 72.0F;
        AppMethodBeat.o(214762);
        return paramFloat;
      }
      paramFloat = this.value * paramFloat / 6.0F;
      AppMethodBeat.o(214762);
      return paramFloat;
    }
    
    final float a(i parami)
    {
      AppMethodBeat.i(214758);
      float f2;
      switch (h.1.aQr[this.aQT.ordinal()])
      {
      default: 
        f1 = this.value;
        AppMethodBeat.o(214758);
        return f1;
      case 1: 
        f1 = this.value;
        AppMethodBeat.o(214758);
        return f1;
      case 2: 
        f1 = this.value;
        f2 = parami.qZ();
        AppMethodBeat.o(214758);
        return f1 * f2;
      case 3: 
        f1 = this.value;
        f2 = parami.aTs.aTQ.getTextSize() / 2.0F;
        AppMethodBeat.o(214758);
        return f1 * f2;
      case 4: 
        f1 = this.value;
        f2 = parami.aTr;
        AppMethodBeat.o(214758);
        return f1 * f2;
      case 5: 
        f1 = this.value * parami.aTr / 2.54F;
        AppMethodBeat.o(214758);
        return f1;
      case 6: 
        f1 = this.value * parami.aTr / 25.4F;
        AppMethodBeat.o(214758);
        return f1;
      case 7: 
        f1 = this.value * parami.aTr / 72.0F;
        AppMethodBeat.o(214758);
        return f1;
      case 8: 
        f1 = this.value * parami.aTr / 6.0F;
        AppMethodBeat.o(214758);
        return f1;
      }
      parami = parami.ra();
      if (parami == null)
      {
        f1 = this.value;
        AppMethodBeat.o(214758);
        return f1;
      }
      float f1 = this.value;
      f1 = parami.width * f1 / 100.0F;
      AppMethodBeat.o(214758);
      return f1;
    }
    
    final float a(i parami, float paramFloat)
    {
      AppMethodBeat.i(214761);
      if (this.aQT == h.bd.aTo)
      {
        paramFloat = this.value * paramFloat / 100.0F;
        AppMethodBeat.o(214761);
        return paramFloat;
      }
      paramFloat = a(parami);
      AppMethodBeat.o(214761);
      return paramFloat;
    }
    
    final float b(i parami)
    {
      AppMethodBeat.i(214759);
      if (this.aQT == h.bd.aTo)
      {
        parami = parami.ra();
        if (parami == null)
        {
          f = this.value;
          AppMethodBeat.o(214759);
          return f;
        }
        f = this.value;
        f = parami.height * f / 100.0F;
        AppMethodBeat.o(214759);
        return f;
      }
      float f = a(parami);
      AppMethodBeat.o(214759);
      return f;
    }
    
    final float c(i parami)
    {
      AppMethodBeat.i(214760);
      if (this.aQT == h.bd.aTo)
      {
        parami = parami.ra();
        if (parami == null)
        {
          f1 = this.value;
          AppMethodBeat.o(214760);
          return f1;
        }
        f1 = parami.width;
        float f2 = parami.height;
        if (f1 == f2)
        {
          f1 = this.value * f1 / 100.0F;
          AppMethodBeat.o(214760);
          return f1;
        }
        f1 = (float)(Math.sqrt(f2 * f2 + f1 * f1) / 1.414213562373095D) * this.value / 100.0F;
        AppMethodBeat.o(214760);
        return f1;
      }
      float f1 = a(parami);
      AppMethodBeat.o(214760);
      return f1;
    }
    
    final boolean isNegative()
    {
      return this.value < 0.0F;
    }
    
    final boolean isZero()
    {
      return this.value == 0.0F;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214763);
      String str = String.valueOf(this.value) + this.aQT;
      AppMethodBeat.o(214763);
      return str;
    }
  }
  
  static final class q
    extends h.l
  {
    h.p aQU;
    h.p aQV;
    h.p aQW;
    h.p aQX;
    
    final String getNodeName()
    {
      return "line";
    }
  }
  
  static final class r
    extends h.ar
    implements h.t
  {
    boolean aQY;
    h.p aQZ;
    h.p aRa;
    h.p aRb;
    h.p aRc;
    Float aRd;
    
    final String getNodeName()
    {
      return "marker";
    }
  }
  
  static final class s
    extends h.ah
    implements h.t
  {
    h.p aQP;
    h.p aQQ;
    h.p aQR;
    h.p aQS;
    Boolean aRe;
    Boolean aRf;
    
    final String getNodeName()
    {
      return "mask";
    }
  }
  
  static abstract interface t {}
  
  static final class u
    extends h.ao
  {
    String aQs;
    h.ao aRg;
    
    u(String paramString, h.ao paramao)
    {
      this.aQs = paramString;
      this.aRg = paramao;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214764);
      String str = this.aQs + " " + this.aRg;
      AppMethodBeat.o(214764);
      return str;
    }
  }
  
  static final class v
    extends h.l
  {
    h.w aRh;
    Float aRi;
    
    final String getNodeName()
    {
      return "path";
    }
  }
  
  static final class w
    implements h.x
  {
    private byte[] aRj;
    private int aRk;
    private float[] aRl;
    private int aRm;
    
    w()
    {
      AppMethodBeat.i(214765);
      this.aRk = 0;
      this.aRm = 0;
      this.aRj = new byte[8];
      this.aRl = new float[16];
      AppMethodBeat.o(214765);
    }
    
    private void dA(int paramInt)
    {
      AppMethodBeat.i(214767);
      if (this.aRl.length < this.aRm + paramInt)
      {
        float[] arrayOfFloat = new float[this.aRl.length * 2];
        System.arraycopy(this.aRl, 0, arrayOfFloat, 0, this.aRl.length);
        this.aRl = arrayOfFloat;
      }
      AppMethodBeat.o(214767);
    }
    
    final void a(byte paramByte)
    {
      AppMethodBeat.i(214766);
      if (this.aRk == this.aRj.length)
      {
        arrayOfByte = new byte[this.aRj.length * 2];
        System.arraycopy(this.aRj, 0, arrayOfByte, 0, this.aRj.length);
        this.aRj = arrayOfByte;
      }
      byte[] arrayOfByte = this.aRj;
      int i = this.aRk;
      this.aRk = (i + 1);
      arrayOfByte[i] = paramByte;
      AppMethodBeat.o(214766);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      int j = 0;
      AppMethodBeat.i(214772);
      if (paramBoolean1) {}
      for (int i = 2;; i = 0)
      {
        if (paramBoolean2) {
          j = 1;
        }
        a((byte)(j | i | 0x4));
        dA(5);
        float[] arrayOfFloat = this.aRl;
        i = this.aRm;
        this.aRm = (i + 1);
        arrayOfFloat[i] = paramFloat1;
        arrayOfFloat = this.aRl;
        i = this.aRm;
        this.aRm = (i + 1);
        arrayOfFloat[i] = paramFloat2;
        arrayOfFloat = this.aRl;
        i = this.aRm;
        this.aRm = (i + 1);
        arrayOfFloat[i] = paramFloat3;
        arrayOfFloat = this.aRl;
        i = this.aRm;
        this.aRm = (i + 1);
        arrayOfFloat[i] = paramFloat4;
        arrayOfFloat = this.aRl;
        i = this.aRm;
        this.aRm = (i + 1);
        arrayOfFloat[i] = paramFloat5;
        AppMethodBeat.o(214772);
        return;
      }
    }
    
    final void a(h.x paramx)
    {
      AppMethodBeat.i(214774);
      int j = 0;
      int i = 0;
      if (j < this.aRk)
      {
        int k = this.aRj[j];
        boolean bool1;
        switch (k)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          if ((k & 0x2) != 0)
          {
            bool1 = true;
            label90:
            if ((k & 0x1) == 0) {
              break label517;
            }
          }
          break;
        }
        label517:
        for (boolean bool2 = true;; bool2 = false)
        {
          float[] arrayOfFloat = this.aRl;
          k = i + 1;
          float f1 = arrayOfFloat[i];
          arrayOfFloat = this.aRl;
          i = k + 1;
          float f2 = arrayOfFloat[k];
          arrayOfFloat = this.aRl;
          k = i + 1;
          float f3 = arrayOfFloat[i];
          arrayOfFloat = this.aRl;
          i = k + 1;
          paramx.a(f1, f2, f3, bool1, bool2, arrayOfFloat[k], this.aRl[i]);
          i += 1;
          for (;;)
          {
            j += 1;
            break;
            arrayOfFloat = this.aRl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRl;
            i = k + 1;
            paramx.moveTo(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.aRl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRl;
            i = k + 1;
            paramx.lineTo(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.aRl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRl;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.aRl;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.aRl;
            i = k + 1;
            float f4 = arrayOfFloat[k];
            arrayOfFloat = this.aRl;
            k = i + 1;
            paramx.cubicTo(f1, f2, f3, f4, arrayOfFloat[i], this.aRl[k]);
            i = k + 1;
            continue;
            arrayOfFloat = this.aRl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRl;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.aRl;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.aRl;
            i = k + 1;
            paramx.quadTo(f1, f2, f3, arrayOfFloat[k]);
            continue;
            paramx.close();
          }
          bool1 = false;
          break label90;
        }
      }
      AppMethodBeat.o(214774);
    }
    
    public final void close()
    {
      AppMethodBeat.i(214773);
      a((byte)8);
      AppMethodBeat.o(214773);
    }
    
    public final void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(214770);
      a((byte)2);
      dA(6);
      float[] arrayOfFloat = this.aRl;
      int i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat5;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat6;
      AppMethodBeat.o(214770);
    }
    
    final boolean isEmpty()
    {
      return this.aRk == 0;
    }
    
    public final void lineTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(214769);
      a((byte)1);
      dA(2);
      float[] arrayOfFloat = this.aRl;
      int i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(214769);
    }
    
    public final void moveTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(214768);
      a((byte)0);
      dA(2);
      float[] arrayOfFloat = this.aRl;
      int i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(214768);
    }
    
    public final void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(214771);
      a((byte)3);
      dA(4);
      float[] arrayOfFloat = this.aRl;
      int i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.aRl;
      i = this.aRm;
      this.aRm = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      AppMethodBeat.o(214771);
    }
  }
  
  static abstract interface x
  {
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5);
    
    public abstract void close();
    
    public abstract void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
    
    public abstract void lineTo(float paramFloat1, float paramFloat2);
    
    public abstract void moveTo(float paramFloat1, float paramFloat2);
    
    public abstract void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
  
  static final class y
    extends h.ar
    implements h.t
  {
    h.p aQP;
    h.p aQQ;
    h.p aQR;
    h.p aQS;
    String aQs;
    Boolean aRn;
    Boolean aRo;
    Matrix aRp;
    
    final String getNodeName()
    {
      return "pattern";
    }
  }
  
  static class z
    extends h.l
  {
    float[] points;
    
    String getNodeName()
    {
      return "polyline";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.h
 * JD-Core Version:    0.7.0.1
 */