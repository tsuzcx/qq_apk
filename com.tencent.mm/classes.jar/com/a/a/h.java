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
  private static j aQd = null;
  private static boolean aQe = true;
  af aQf;
  private float aQg;
  b.q aQh;
  private Map<String, al> aQi;
  String desc;
  String title;
  
  h()
  {
    AppMethodBeat.i(206538);
    this.aQf = null;
    this.title = "";
    this.desc = "";
    this.aQg = 96.0F;
    this.aQh = new b.q();
    this.aQi = new HashMap();
    AppMethodBeat.o(206538);
  }
  
  private b R(float paramFloat)
  {
    AppMethodBeat.i(206545);
    Object localObject = this.aQf.aQJ;
    p localp = this.aQf.aQK;
    if ((localObject == null) || (((p)localObject).isZero()) || (((p)localObject).aQL == bd.aTg) || (((p)localObject).aQL == bd.aSZ) || (((p)localObject).aQL == bd.aTa))
    {
      localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
      AppMethodBeat.o(206545);
      return localObject;
    }
    float f = ((p)localObject).S(paramFloat);
    if (localp != null)
    {
      if ((localp.isZero()) || (localp.aQL == bd.aTg) || (localp.aQL == bd.aSZ) || (localp.aQL == bd.aTa))
      {
        localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
        AppMethodBeat.o(206545);
        return localObject;
      }
      paramFloat = localp.S(paramFloat);
    }
    for (;;)
    {
      localObject = new b(0.0F, 0.0F, f, paramFloat);
      AppMethodBeat.o(206545);
      return localObject;
      if (this.aQf.aQb != null) {
        paramFloat = this.aQf.aQb.height * f / this.aQf.aQb.width;
      } else {
        paramFloat = f;
      }
    }
  }
  
  private al a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(206550);
    Object localObject = (al)paramaj;
    if (paramString.equals(((al)localObject).id))
    {
      AppMethodBeat.o(206550);
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
          AppMethodBeat.o(206550);
          return localal;
        }
        if ((localObject instanceof aj))
        {
          localObject = a((aj)localObject, paramString);
          if (localObject != null)
          {
            AppMethodBeat.o(206550);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(206550);
    return null;
  }
  
  private Picture aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206541);
    Picture localPicture = new Picture();
    Canvas localCanvas = localPicture.beginRecording(paramInt1, paramInt2);
    g localg = new g();
    localg.p(paramInt1, paramInt2);
    new i(localCanvas, this.aQg).a(this, localg);
    localPicture.endRecording();
    AppMethodBeat.o(206541);
    return localPicture;
  }
  
  public static h f(InputStream paramInputStream)
  {
    AppMethodBeat.i(206539);
    paramInputStream = new l().a(paramInputStream, aQe);
    AppMethodBeat.o(206539);
    return paramInputStream;
  }
  
  static j qQ()
  {
    return aQd;
  }
  
  final an Z(String paramString)
  {
    AppMethodBeat.i(206544);
    if (paramString == null)
    {
      AppMethodBeat.o(206544);
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
      paramString = aa(paramString.substring(1));
      AppMethodBeat.o(206544);
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
    AppMethodBeat.o(206544);
    return null;
  }
  
  final al aa(String paramString)
  {
    AppMethodBeat.i(206549);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(206549);
      return null;
    }
    if (paramString.equals(this.aQf.id))
    {
      paramString = this.aQf;
      AppMethodBeat.o(206549);
      return paramString;
    }
    if (this.aQi.containsKey(paramString))
    {
      paramString = (al)this.aQi.get(paramString);
      AppMethodBeat.o(206549);
      return paramString;
    }
    al localal = a(this.aQf, paramString);
    this.aQi.put(paramString, localal);
    AppMethodBeat.o(206549);
    return localal;
  }
  
  final void b(b.q paramq)
  {
    AppMethodBeat.i(206546);
    this.aQh.a(paramq);
    AppMethodBeat.o(206546);
  }
  
  public final Picture qL()
  {
    AppMethodBeat.i(206540);
    Object localObject = this.aQf.aQb;
    float f1;
    float f2;
    if ((this.aQf.aQJ != null) && (this.aQf.aQJ.aQL != bd.aTg) && (this.aQf.aQK != null) && (this.aQf.aQK.aQL != bd.aTg))
    {
      f1 = this.aQf.aQJ.S(this.aQg);
      f2 = this.aQf.aQK.S(this.aQg);
      localObject = aU((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(206540);
      return localObject;
    }
    if ((this.aQf.aQJ != null) && (localObject != null))
    {
      f1 = this.aQf.aQJ.S(this.aQg);
      f2 = ((b)localObject).height * f1 / ((b)localObject).width;
      localObject = aU((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(206540);
      return localObject;
    }
    if ((this.aQf.aQK != null) && (localObject != null))
    {
      f1 = this.aQf.aQK.S(this.aQg);
      localObject = aU((int)Math.ceil(((b)localObject).width * f1 / ((b)localObject).height), (int)Math.ceil(f1));
      AppMethodBeat.o(206540);
      return localObject;
    }
    localObject = aU(512, 512);
    AppMethodBeat.o(206540);
    return localObject;
  }
  
  public final float qM()
  {
    AppMethodBeat.i(206542);
    if (this.aQf == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(206542);
      throw localIllegalArgumentException;
    }
    float f = R(this.aQg).width;
    AppMethodBeat.o(206542);
    return f;
  }
  
  public final float qN()
  {
    AppMethodBeat.i(206543);
    if (this.aQf == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(206543);
      throw localIllegalArgumentException;
    }
    float f = R(this.aQg).height;
    AppMethodBeat.o(206543);
    return f;
  }
  
  final boolean qO()
  {
    AppMethodBeat.i(206547);
    b.q localq = this.aQh;
    if ((localq.aPm == null) || (localq.aPm.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206547);
      return true;
    }
    AppMethodBeat.o(206547);
    return false;
  }
  
  final void qP()
  {
    AppMethodBeat.i(206548);
    Object localObject = this.aQh;
    b.t localt = b.t.aPt;
    if (((b.q)localObject).aPm != null)
    {
      localObject = ((b.q)localObject).aPm.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((b.o)((Iterator)localObject).next()).aOe == localt) {
          ((Iterator)localObject).remove();
        }
      }
    }
    AppMethodBeat.o(206548);
  }
  
  static final class a
    extends h.m
  {
    String aQk;
    
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
    h.p aQH;
    h.p aQI;
    h.p aQJ;
    h.p aQK;
    h.p aQx;
    h.p aQy;
    
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
      AppMethodBeat.i(206502);
      List localList = Collections.emptyList();
      AppMethodBeat.o(206502);
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
    Float aRi;
    
    public final void a(h.an paraman) {}
    
    public final List<h.an> getChildren()
    {
      AppMethodBeat.i(206503);
      List localList = Collections.emptyList();
      AppMethodBeat.o(206503);
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
    h.ae.b aRA;
    g aRB;
    h.ae.h aRC;
    f aRD;
    Boolean aRE;
    h.c aRF;
    String aRG;
    String aRH;
    String aRI;
    Boolean aRJ;
    Boolean aRK;
    h.ao aRL;
    Float aRM;
    String aRN;
    h.ae.a aRO;
    String aRP;
    h.ao aRQ;
    Float aRR;
    h.ao aRS;
    Float aRT;
    h.ae.i aRU;
    e aRV;
    long aRj = 0L;
    h.ao aRk;
    h.ae.a aRl;
    Float aRm;
    h.ao aRn;
    Float aRo;
    h.p aRp;
    c aRq;
    d aRr;
    Float aRs;
    h.p[] aRt;
    h.p aRu;
    Float aRv;
    h.f aRw;
    List<String> aRx;
    h.p aRy;
    Integer aRz;
    
    static ae qU()
    {
      AppMethodBeat.i(206531);
      ae localae = new ae();
      localae.aRj = -1L;
      localae.aRk = h.f.aQu;
      localae.aRl = h.ae.a.aRW;
      localae.aRm = Float.valueOf(1.0F);
      localae.aRn = null;
      localae.aRo = Float.valueOf(1.0F);
      localae.aRp = new h.p(1.0F);
      localae.aRq = c.aSd;
      localae.aRr = d.aSh;
      localae.aRs = Float.valueOf(4.0F);
      localae.aRt = null;
      localae.aRu = new h.p(0.0F);
      localae.aRv = Float.valueOf(1.0F);
      localae.aRw = h.f.aQu;
      localae.aRx = null;
      localae.aRy = new h.p(12.0F, h.bd.aTe);
      localae.aRz = Integer.valueOf(400);
      localae.aRA = h.ae.b.aRZ;
      localae.aRB = g.aSt;
      localae.aRC = h.ae.h.aSz;
      localae.aRD = f.aSp;
      localae.aRE = Boolean.TRUE;
      localae.aRF = null;
      localae.aRG = null;
      localae.aRH = null;
      localae.aRI = null;
      localae.aRJ = Boolean.TRUE;
      localae.aRK = Boolean.TRUE;
      localae.aRL = h.f.aQu;
      localae.aRM = Float.valueOf(1.0F);
      localae.aRN = null;
      localae.aRO = h.ae.a.aRW;
      localae.aRP = null;
      localae.aRQ = null;
      localae.aRR = Float.valueOf(1.0F);
      localae.aRS = null;
      localae.aRT = Float.valueOf(1.0F);
      localae.aRU = h.ae.i.aSC;
      localae.aRV = e.aSl;
      AppMethodBeat.o(206531);
      return localae;
    }
    
    final void aI(boolean paramBoolean)
    {
      AppMethodBeat.i(206532);
      this.aRJ = Boolean.TRUE;
      if (paramBoolean) {}
      for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
      {
        this.aRE = localBoolean;
        this.aRF = null;
        this.aRN = null;
        this.aRv = Float.valueOf(1.0F);
        this.aRL = h.f.aQu;
        this.aRM = Float.valueOf(1.0F);
        this.aRP = null;
        this.aRQ = null;
        this.aRR = Float.valueOf(1.0F);
        this.aRS = null;
        this.aRT = Float.valueOf(1.0F);
        this.aRU = h.ae.i.aSC;
        AppMethodBeat.o(206532);
        return;
      }
    }
    
    protected final Object clone()
    {
      AppMethodBeat.i(206533);
      ae localae = (ae)super.clone();
      if (this.aRt != null) {
        localae.aRt = ((h.p[])this.aRt.clone());
      }
      AppMethodBeat.o(206533);
      return localae;
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(206512);
        aSd = new c("Butt", 0);
        aSe = new c("Round", 1);
        aSf = new c("Square", 2);
        aSg = new c[] { aSd, aSe, aSf };
        AppMethodBeat.o(206512);
      }
      
      private c() {}
    }
    
    public static enum d
    {
      static
      {
        AppMethodBeat.i(206515);
        aSh = new d("Miter", 0);
        aSi = new d("Round", 1);
        aSj = new d("Bevel", 2);
        aSk = new d[] { aSh, aSi, aSj };
        AppMethodBeat.o(206515);
      }
      
      private d() {}
    }
    
    public static enum e
    {
      static
      {
        AppMethodBeat.i(206518);
        aSl = new e("auto", 0);
        aSm = new e("optimizeQuality", 1);
        aSn = new e("optimizeSpeed", 2);
        aSo = new e[] { aSl, aSm, aSn };
        AppMethodBeat.o(206518);
      }
      
      private e() {}
    }
    
    public static enum f
    {
      static
      {
        AppMethodBeat.i(206521);
        aSp = new f("Start", 0);
        aSq = new f("Middle", 1);
        aSr = new f("End", 2);
        aSs = new f[] { aSp, aSq, aSr };
        AppMethodBeat.o(206521);
      }
      
      private f() {}
    }
    
    public static enum g
    {
      static
      {
        AppMethodBeat.i(206524);
        aSt = new g("None", 0);
        aSu = new g("Underline", 1);
        aSv = new g("Overline", 2);
        aSw = new g("LineThrough", 3);
        aSx = new g("Blink", 4);
        aSy = new g[] { aSt, aSu, aSv, aSw, aSx };
        AppMethodBeat.o(206524);
      }
      
      private g() {}
    }
  }
  
  static final class af
    extends h.ar
  {
    h.p aQH;
    h.p aQI;
    h.p aQJ;
    h.p aQK;
    public String version;
    
    final String getNodeName()
    {
      return "svg";
    }
  }
  
  static abstract interface ag
  {
    public abstract void ab(String paramString);
    
    public abstract void b(Set<String> paramSet);
    
    public abstract void c(Set<String> paramSet);
    
    public abstract void d(Set<String> paramSet);
    
    public abstract void e(Set<String> paramSet);
    
    public abstract Set<String> qV();
    
    public abstract String qW();
    
    public abstract Set<String> qX();
    
    public abstract Set<String> qY();
    
    public abstract Set<String> qZ();
  }
  
  static abstract class ah
    extends h.ak
    implements h.ag, h.aj
  {
    List<h.an> aQz = new ArrayList();
    Set<String> aSF = null;
    String aSG = null;
    Set<String> aSH = null;
    Set<String> aSI = null;
    Set<String> aSJ = null;
    
    public void a(h.an paraman)
    {
      this.aQz.add(paraman);
    }
    
    public final void ab(String paramString)
    {
      this.aSG = paramString;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.aSF = paramSet;
    }
    
    public final void c(Set<String> paramSet)
    {
      this.aSH = paramSet;
    }
    
    public final void d(Set<String> paramSet)
    {
      this.aSI = paramSet;
    }
    
    public final void e(Set<String> paramSet)
    {
      this.aSJ = paramSet;
    }
    
    public final List<h.an> getChildren()
    {
      return this.aQz;
    }
    
    public final Set<String> qV()
    {
      return this.aSF;
    }
    
    public final String qW()
    {
      return this.aSG;
    }
    
    public final Set<String> qX()
    {
      return null;
    }
    
    public final Set<String> qY()
    {
      return this.aSI;
    }
    
    public final Set<String> qZ()
    {
      return this.aSJ;
    }
  }
  
  static abstract class ai
    extends h.ak
    implements h.ag
  {
    Set<String> aSF = null;
    String aSG = null;
    Set<String> aSH = null;
    Set<String> aSI = null;
    Set<String> aSJ = null;
    
    public final void ab(String paramString)
    {
      this.aSG = paramString;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.aSF = paramSet;
    }
    
    public final void c(Set<String> paramSet)
    {
      this.aSH = paramSet;
    }
    
    public final void d(Set<String> paramSet)
    {
      this.aSI = paramSet;
    }
    
    public final void e(Set<String> paramSet)
    {
      this.aSJ = paramSet;
    }
    
    public final Set<String> qV()
    {
      return this.aSF;
    }
    
    public final String qW()
    {
      return this.aSG;
    }
    
    public final Set<String> qX()
    {
      return this.aSH;
    }
    
    public final Set<String> qY()
    {
      return this.aSI;
    }
    
    public final Set<String> qZ()
    {
      return this.aSJ;
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
    h.b aSK = null;
  }
  
  static abstract class al
    extends h.an
  {
    h.ae aPk = null;
    Boolean aSL = null;
    h.ae aSM = null;
    List<String> aSN = null;
    String id = null;
    
    public String toString()
    {
      return getNodeName();
    }
  }
  
  static final class am
    extends h.j
  {
    h.p aQM;
    h.p aQN;
    h.p aQO;
    h.p aQP;
    
    final String getNodeName()
    {
      return "linearGradient";
    }
  }
  
  static class an
  {
    h aSO;
    h.aj aSP;
    
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
    f aPZ = null;
  }
  
  static final class aq
    extends h.j
  {
    h.p aQp;
    h.p aQq;
    h.p aQr;
    h.p aSQ;
    h.p aSR;
    
    final String getNodeName()
    {
      return "radialGradient";
    }
  }
  
  static abstract class ar
    extends h.ap
  {
    h.b aQb;
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
    String aQk;
    h.bb aSS;
    
    final String getNodeName()
    {
      return "tref";
    }
    
    public final h.bb ra()
    {
      return this.aSS;
    }
  }
  
  static final class av
    extends h.ba
    implements h.ax
  {
    h.bb aSS;
    
    final String getNodeName()
    {
      return "tspan";
    }
    
    public final h.bb ra()
    {
      return this.aSS;
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
    public abstract h.bb ra();
  }
  
  static abstract class ay
    extends h.ah
  {
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ax))
      {
        this.aQz.add(paraman);
        return;
      }
      throw new k("Text content elements cannot contain " + paraman + " elements.");
    }
  }
  
  static final class az
    extends h.ay
    implements h.ax
  {
    String aQk;
    h.bb aSS;
    h.p aST;
    
    final String getNodeName()
    {
      return "textPath";
    }
    
    public final h.bb ra()
    {
      return this.aSS;
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
      AppMethodBeat.i(206476);
      b localb = new b(paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      AppMethodBeat.o(206476);
      return localb;
    }
    
    final void a(b paramb)
    {
      AppMethodBeat.i(206477);
      if (paramb.minX < this.minX) {
        this.minX = paramb.minX;
      }
      if (paramb.minY < this.minY) {
        this.minY = paramb.minY;
      }
      if (paramb.qR() > qR()) {
        this.width = (paramb.qR() - this.minX);
      }
      if (paramb.qS() > qS()) {
        this.height = (paramb.qS() - this.minY);
      }
      AppMethodBeat.o(206477);
    }
    
    final float qR()
    {
      return this.minX + this.width;
    }
    
    final float qS()
    {
      return this.minY + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206478);
      String str = "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
      AppMethodBeat.o(206478);
      return str;
    }
  }
  
  static abstract class ba
    extends h.ay
  {
    List<h.p> aSU;
    List<h.p> aSV;
    List<h.p> aSW;
    List<h.p> aSX;
  }
  
  static abstract interface bb {}
  
  static final class bc
    extends h.an
    implements h.ax
  {
    private h.bb aSS;
    String text;
    
    bc(String paramString)
    {
      this.text = paramString;
    }
    
    public final h.bb ra()
    {
      return this.aSS;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206534);
      String str = "TextChild: '" + this.text + "'";
      AppMethodBeat.o(206534);
      return str;
    }
  }
  
  static enum bd
  {
    static
    {
      AppMethodBeat.i(206537);
      aSY = new bd("px", 0);
      aSZ = new bd("em", 1);
      aTa = new bd("ex", 2);
      aTb = new bd("in", 3);
      aTc = new bd("cm", 4);
      aTd = new bd("mm", 5);
      aTe = new bd("pt", 6);
      aTf = new bd("pc", 7);
      aTg = new bd("percent", 8);
      aTh = new bd[] { aSY, aSZ, aTa, aTb, aTc, aTd, aTe, aTf, aTg };
      AppMethodBeat.o(206537);
    }
    
    private bd() {}
  }
  
  static final class be
    extends h.m
  {
    h.p aQH;
    h.p aQI;
    h.p aQJ;
    h.p aQK;
    String aQk;
    
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
    h.p aQl;
    h.p aQm;
    h.p aQn;
    h.p aQo;
    
    c(h.p paramp1, h.p paramp2, h.p paramp3, h.p paramp4)
    {
      this.aQl = paramp1;
      this.aQm = paramp2;
      this.aQn = paramp3;
      this.aQo = paramp4;
    }
  }
  
  static final class d
    extends h.l
  {
    h.p aQp;
    h.p aQq;
    h.p aQr;
    
    final String getNodeName()
    {
      return "circle";
    }
  }
  
  static final class e
    extends h.m
    implements h.t
  {
    Boolean aQs;
    
    final String getNodeName()
    {
      return "clipPath";
    }
  }
  
  static final class f
    extends h.ao
  {
    static final f aQu;
    static final f aQv;
    int aQt;
    
    static
    {
      AppMethodBeat.i(206480);
      aQu = new f(-16777216);
      aQv = new f(0);
      AppMethodBeat.o(206480);
    }
    
    f(int paramInt)
    {
      this.aQt = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206479);
      String str = String.format("#%08x", new Object[] { Integer.valueOf(this.aQt) });
      AppMethodBeat.o(206479);
      return str;
    }
  }
  
  static final class g
    extends h.ao
  {
    private static g aQw;
    
    static
    {
      AppMethodBeat.i(206481);
      aQw = new g();
      AppMethodBeat.o(206481);
    }
    
    static g qT()
    {
      return aQw;
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
    h.p aQp;
    h.p aQq;
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
    Boolean aQA;
    Matrix aQB;
    h.k aQC;
    String aQk;
    List<h.an> aQz = new ArrayList();
    
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ad))
      {
        this.aQz.add(paraman);
        return;
      }
      throw new k("Gradient elements cannot contain " + paraman + " elements.");
    }
    
    public final List<h.an> getChildren()
    {
      return this.aQz;
    }
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
    h.p aQH;
    h.p aQI;
    h.p aQJ;
    h.p aQK;
    String aQk;
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
    h.bd aQL;
    float value;
    
    p(float paramFloat)
    {
      this.value = paramFloat;
      this.aQL = h.bd.aSY;
    }
    
    p(float paramFloat, h.bd parambd)
    {
      this.value = paramFloat;
      this.aQL = parambd;
    }
    
    final float S(float paramFloat)
    {
      AppMethodBeat.i(206489);
      switch (h.1.aQj[this.aQL.ordinal()])
      {
      case 2: 
      case 3: 
      default: 
        paramFloat = this.value;
        AppMethodBeat.o(206489);
        return paramFloat;
      case 1: 
        paramFloat = this.value;
        AppMethodBeat.o(206489);
        return paramFloat;
      case 4: 
        float f = this.value;
        AppMethodBeat.o(206489);
        return f * paramFloat;
      case 5: 
        paramFloat = this.value * paramFloat / 2.54F;
        AppMethodBeat.o(206489);
        return paramFloat;
      case 6: 
        paramFloat = this.value * paramFloat / 25.4F;
        AppMethodBeat.o(206489);
        return paramFloat;
      case 7: 
        paramFloat = this.value * paramFloat / 72.0F;
        AppMethodBeat.o(206489);
        return paramFloat;
      }
      paramFloat = this.value * paramFloat / 6.0F;
      AppMethodBeat.o(206489);
      return paramFloat;
    }
    
    final float a(i parami)
    {
      AppMethodBeat.i(206485);
      float f2;
      switch (h.1.aQj[this.aQL.ordinal()])
      {
      default: 
        f1 = this.value;
        AppMethodBeat.o(206485);
        return f1;
      case 1: 
        f1 = this.value;
        AppMethodBeat.o(206485);
        return f1;
      case 2: 
        f1 = this.value;
        f2 = parami.rc();
        AppMethodBeat.o(206485);
        return f1 * f2;
      case 3: 
        f1 = this.value;
        f2 = parami.aTk.aTI.getTextSize() / 2.0F;
        AppMethodBeat.o(206485);
        return f1 * f2;
      case 4: 
        f1 = this.value;
        f2 = parami.aTj;
        AppMethodBeat.o(206485);
        return f1 * f2;
      case 5: 
        f1 = this.value * parami.aTj / 2.54F;
        AppMethodBeat.o(206485);
        return f1;
      case 6: 
        f1 = this.value * parami.aTj / 25.4F;
        AppMethodBeat.o(206485);
        return f1;
      case 7: 
        f1 = this.value * parami.aTj / 72.0F;
        AppMethodBeat.o(206485);
        return f1;
      case 8: 
        f1 = this.value * parami.aTj / 6.0F;
        AppMethodBeat.o(206485);
        return f1;
      }
      parami = parami.rd();
      if (parami == null)
      {
        f1 = this.value;
        AppMethodBeat.o(206485);
        return f1;
      }
      float f1 = this.value;
      f1 = parami.width * f1 / 100.0F;
      AppMethodBeat.o(206485);
      return f1;
    }
    
    final float a(i parami, float paramFloat)
    {
      AppMethodBeat.i(206488);
      if (this.aQL == h.bd.aTg)
      {
        paramFloat = this.value * paramFloat / 100.0F;
        AppMethodBeat.o(206488);
        return paramFloat;
      }
      paramFloat = a(parami);
      AppMethodBeat.o(206488);
      return paramFloat;
    }
    
    final float b(i parami)
    {
      AppMethodBeat.i(206486);
      if (this.aQL == h.bd.aTg)
      {
        parami = parami.rd();
        if (parami == null)
        {
          f = this.value;
          AppMethodBeat.o(206486);
          return f;
        }
        f = this.value;
        f = parami.height * f / 100.0F;
        AppMethodBeat.o(206486);
        return f;
      }
      float f = a(parami);
      AppMethodBeat.o(206486);
      return f;
    }
    
    final float c(i parami)
    {
      AppMethodBeat.i(206487);
      if (this.aQL == h.bd.aTg)
      {
        parami = parami.rd();
        if (parami == null)
        {
          f1 = this.value;
          AppMethodBeat.o(206487);
          return f1;
        }
        f1 = parami.width;
        float f2 = parami.height;
        if (f1 == f2)
        {
          f1 = this.value * f1 / 100.0F;
          AppMethodBeat.o(206487);
          return f1;
        }
        f1 = (float)(Math.sqrt(f2 * f2 + f1 * f1) / 1.414213562373095D) * this.value / 100.0F;
        AppMethodBeat.o(206487);
        return f1;
      }
      float f1 = a(parami);
      AppMethodBeat.o(206487);
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
      AppMethodBeat.i(206490);
      String str = String.valueOf(this.value) + this.aQL;
      AppMethodBeat.o(206490);
      return str;
    }
  }
  
  static final class q
    extends h.l
  {
    h.p aQM;
    h.p aQN;
    h.p aQO;
    h.p aQP;
    
    final String getNodeName()
    {
      return "line";
    }
  }
  
  static final class r
    extends h.ar
    implements h.t
  {
    boolean aQQ;
    h.p aQR;
    h.p aQS;
    h.p aQT;
    h.p aQU;
    Float aQV;
    
    final String getNodeName()
    {
      return "marker";
    }
  }
  
  static final class s
    extends h.ah
    implements h.t
  {
    h.p aQH;
    h.p aQI;
    h.p aQJ;
    h.p aQK;
    Boolean aQW;
    Boolean aQX;
    
    final String getNodeName()
    {
      return "mask";
    }
  }
  
  static abstract interface t {}
  
  static final class u
    extends h.ao
  {
    h.ao aQY;
    String aQk;
    
    u(String paramString, h.ao paramao)
    {
      this.aQk = paramString;
      this.aQY = paramao;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206491);
      String str = this.aQk + " " + this.aQY;
      AppMethodBeat.o(206491);
      return str;
    }
  }
  
  static final class v
    extends h.l
  {
    h.w aQZ;
    Float aRa;
    
    final String getNodeName()
    {
      return "path";
    }
  }
  
  static final class w
    implements h.x
  {
    private byte[] aRb;
    private int aRc;
    private float[] aRd;
    private int aRe;
    
    w()
    {
      AppMethodBeat.i(206492);
      this.aRc = 0;
      this.aRe = 0;
      this.aRb = new byte[8];
      this.aRd = new float[16];
      AppMethodBeat.o(206492);
    }
    
    private void dv(int paramInt)
    {
      AppMethodBeat.i(206494);
      if (this.aRd.length < this.aRe + paramInt)
      {
        float[] arrayOfFloat = new float[this.aRd.length * 2];
        System.arraycopy(this.aRd, 0, arrayOfFloat, 0, this.aRd.length);
        this.aRd = arrayOfFloat;
      }
      AppMethodBeat.o(206494);
    }
    
    final void a(byte paramByte)
    {
      AppMethodBeat.i(206493);
      if (this.aRc == this.aRb.length)
      {
        arrayOfByte = new byte[this.aRb.length * 2];
        System.arraycopy(this.aRb, 0, arrayOfByte, 0, this.aRb.length);
        this.aRb = arrayOfByte;
      }
      byte[] arrayOfByte = this.aRb;
      int i = this.aRc;
      this.aRc = (i + 1);
      arrayOfByte[i] = paramByte;
      AppMethodBeat.o(206493);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      int j = 0;
      AppMethodBeat.i(206499);
      if (paramBoolean1) {}
      for (int i = 2;; i = 0)
      {
        if (paramBoolean2) {
          j = 1;
        }
        a((byte)(j | i | 0x4));
        dv(5);
        float[] arrayOfFloat = this.aRd;
        i = this.aRe;
        this.aRe = (i + 1);
        arrayOfFloat[i] = paramFloat1;
        arrayOfFloat = this.aRd;
        i = this.aRe;
        this.aRe = (i + 1);
        arrayOfFloat[i] = paramFloat2;
        arrayOfFloat = this.aRd;
        i = this.aRe;
        this.aRe = (i + 1);
        arrayOfFloat[i] = paramFloat3;
        arrayOfFloat = this.aRd;
        i = this.aRe;
        this.aRe = (i + 1);
        arrayOfFloat[i] = paramFloat4;
        arrayOfFloat = this.aRd;
        i = this.aRe;
        this.aRe = (i + 1);
        arrayOfFloat[i] = paramFloat5;
        AppMethodBeat.o(206499);
        return;
      }
    }
    
    final void a(h.x paramx)
    {
      AppMethodBeat.i(206501);
      int j = 0;
      int i = 0;
      if (j < this.aRc)
      {
        int k = this.aRb[j];
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
          float[] arrayOfFloat = this.aRd;
          k = i + 1;
          float f1 = arrayOfFloat[i];
          arrayOfFloat = this.aRd;
          i = k + 1;
          float f2 = arrayOfFloat[k];
          arrayOfFloat = this.aRd;
          k = i + 1;
          float f3 = arrayOfFloat[i];
          arrayOfFloat = this.aRd;
          i = k + 1;
          paramx.a(f1, f2, f3, bool1, bool2, arrayOfFloat[k], this.aRd[i]);
          i += 1;
          for (;;)
          {
            j += 1;
            break;
            arrayOfFloat = this.aRd;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRd;
            i = k + 1;
            paramx.moveTo(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.aRd;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRd;
            i = k + 1;
            paramx.lineTo(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.aRd;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRd;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.aRd;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.aRd;
            i = k + 1;
            float f4 = arrayOfFloat[k];
            arrayOfFloat = this.aRd;
            k = i + 1;
            paramx.cubicTo(f1, f2, f3, f4, arrayOfFloat[i], this.aRd[k]);
            i = k + 1;
            continue;
            arrayOfFloat = this.aRd;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.aRd;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.aRd;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.aRd;
            i = k + 1;
            paramx.quadTo(f1, f2, f3, arrayOfFloat[k]);
            continue;
            paramx.close();
          }
          bool1 = false;
          break label90;
        }
      }
      AppMethodBeat.o(206501);
    }
    
    public final void close()
    {
      AppMethodBeat.i(206500);
      a((byte)8);
      AppMethodBeat.o(206500);
    }
    
    public final void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(206497);
      a((byte)2);
      dv(6);
      float[] arrayOfFloat = this.aRd;
      int i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat5;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat6;
      AppMethodBeat.o(206497);
    }
    
    final boolean isEmpty()
    {
      return this.aRc == 0;
    }
    
    public final void lineTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206496);
      a((byte)1);
      dv(2);
      float[] arrayOfFloat = this.aRd;
      int i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(206496);
    }
    
    public final void moveTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206495);
      a((byte)0);
      dv(2);
      float[] arrayOfFloat = this.aRd;
      int i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(206495);
    }
    
    public final void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(206498);
      a((byte)3);
      dv(4);
      float[] arrayOfFloat = this.aRd;
      int i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.aRd;
      i = this.aRe;
      this.aRe = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      AppMethodBeat.o(206498);
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
    h.p aQH;
    h.p aQI;
    h.p aQJ;
    h.p aQK;
    String aQk;
    Boolean aRf;
    Boolean aRg;
    Matrix aRh;
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.h
 * JD-Core Version:    0.7.0.1
 */