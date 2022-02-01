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
  private static j cul = null;
  private static boolean cum = true;
  af cun;
  private float cuo;
  b.q cup;
  private Map<String, al> cuq;
  String desc;
  String title;
  
  h()
  {
    AppMethodBeat.i(207764);
    this.cun = null;
    this.title = "";
    this.desc = "";
    this.cuo = 96.0F;
    this.cup = new b.q();
    this.cuq = new HashMap();
    AppMethodBeat.o(207764);
  }
  
  static j NU()
  {
    return cul;
  }
  
  private al a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(207798);
    Object localObject = (al)paramaj;
    if (paramString.equals(((al)localObject).id))
    {
      AppMethodBeat.o(207798);
      return localObject;
    }
    paramaj = paramaj.NZ().iterator();
    while (paramaj.hasNext())
    {
      localObject = (an)paramaj.next();
      if ((localObject instanceof al))
      {
        al localal = (al)localObject;
        if (paramString.equals(localal.id))
        {
          AppMethodBeat.o(207798);
          return localal;
        }
        if ((localObject instanceof aj))
        {
          localObject = a((aj)localObject, paramString);
          if (localObject != null)
          {
            AppMethodBeat.o(207798);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(207798);
    return null;
  }
  
  private b aK(float paramFloat)
  {
    AppMethodBeat.i(207789);
    Object localObject = this.cun.cuR;
    p localp = this.cun.cuS;
    if ((localObject == null) || (((p)localObject).Oa()) || (((p)localObject).cuT == bd.cxp) || (((p)localObject).cuT == bd.cxi) || (((p)localObject).cuT == bd.cxj))
    {
      localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
      AppMethodBeat.o(207789);
      return localObject;
    }
    float f = ((p)localObject).aL(paramFloat);
    if (localp != null)
    {
      if ((localp.Oa()) || (localp.cuT == bd.cxp) || (localp.cuT == bd.cxi) || (localp.cuT == bd.cxj))
      {
        localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
        AppMethodBeat.o(207789);
        return localObject;
      }
      paramFloat = localp.aL(paramFloat);
    }
    for (;;)
    {
      localObject = new b(0.0F, 0.0F, f, paramFloat);
      AppMethodBeat.o(207789);
      return localObject;
      if (this.cun.cuj != null) {
        paramFloat = this.cun.cuj.height * f / this.cun.cuj.width;
      } else {
        paramFloat = f;
      }
    }
  }
  
  private Picture bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207783);
    Picture localPicture = new Picture();
    Canvas localCanvas = localPicture.beginRecording(paramInt1, paramInt2);
    g localg = new g();
    localg.T(paramInt1, paramInt2);
    new i(localCanvas, this.cuo).a(this, localg);
    localPicture.endRecording();
    AppMethodBeat.o(207783);
    return localPicture;
  }
  
  public static h m(InputStream paramInputStream)
  {
    AppMethodBeat.i(207772);
    paramInputStream = new l().a(paramInputStream, cum);
    AppMethodBeat.o(207772);
    return paramInputStream;
  }
  
  public final Picture NP()
  {
    AppMethodBeat.i(207810);
    Object localObject = this.cun.cuj;
    float f1;
    float f2;
    if ((this.cun.cuR != null) && (this.cun.cuR.cuT != bd.cxp) && (this.cun.cuS != null) && (this.cun.cuS.cuT != bd.cxp))
    {
      f1 = this.cun.cuR.aL(this.cuo);
      f2 = this.cun.cuS.aL(this.cuo);
      localObject = bV((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(207810);
      return localObject;
    }
    if ((this.cun.cuR != null) && (localObject != null))
    {
      f1 = this.cun.cuR.aL(this.cuo);
      f2 = ((b)localObject).height * f1 / ((b)localObject).width;
      localObject = bV((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(207810);
      return localObject;
    }
    if ((this.cun.cuS != null) && (localObject != null))
    {
      f1 = this.cun.cuS.aL(this.cuo);
      localObject = bV((int)Math.ceil(((b)localObject).width * f1 / ((b)localObject).height), (int)Math.ceil(f1));
      AppMethodBeat.o(207810);
      return localObject;
    }
    localObject = bV(512, 512);
    AppMethodBeat.o(207810);
    return localObject;
  }
  
  public final float NQ()
  {
    AppMethodBeat.i(207813);
    if (this.cun == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(207813);
      throw localIllegalArgumentException;
    }
    float f = aK(this.cuo).width;
    AppMethodBeat.o(207813);
    return f;
  }
  
  public final float NR()
  {
    AppMethodBeat.i(207821);
    if (this.cun == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(207821);
      throw localIllegalArgumentException;
    }
    float f = aK(this.cuo).height;
    AppMethodBeat.o(207821);
    return f;
  }
  
  final boolean NS()
  {
    AppMethodBeat.i(207846);
    b.q localq = this.cup;
    if ((localq.ctt == null) || (localq.ctt.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(207846);
      return true;
    }
    AppMethodBeat.o(207846);
    return false;
  }
  
  final void NT()
  {
    AppMethodBeat.i(207854);
    Object localObject = this.cup;
    b.t localt = b.t.ctB;
    if (((b.q)localObject).ctt != null)
    {
      localObject = ((b.q)localObject).ctt.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((b.o)((Iterator)localObject).next()).csk == localt) {
          ((Iterator)localObject).remove();
        }
      }
    }
    AppMethodBeat.o(207854);
  }
  
  final void b(b.q paramq)
  {
    AppMethodBeat.i(207836);
    this.cup.a(paramq);
    AppMethodBeat.o(207836);
  }
  
  final an bm(String paramString)
  {
    AppMethodBeat.i(207831);
    if (paramString == null)
    {
      AppMethodBeat.o(207831);
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
      paramString = bn(paramString.substring(1));
      AppMethodBeat.o(207831);
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
    AppMethodBeat.o(207831);
    return null;
  }
  
  final al bn(String paramString)
  {
    AppMethodBeat.i(207861);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(207861);
      return null;
    }
    if (paramString.equals(this.cun.id))
    {
      paramString = this.cun;
      AppMethodBeat.o(207861);
      return paramString;
    }
    if (this.cuq.containsKey(paramString))
    {
      paramString = (al)this.cuq.get(paramString);
      AppMethodBeat.o(207861);
      return paramString;
    }
    al localal = a(this.cun, paramString);
    this.cuq.put(paramString, localal);
    AppMethodBeat.o(207861);
    return localal;
  }
  
  static final class a
    extends h.m
  {
    String cut;
    
    final String NV()
    {
      return "a";
    }
  }
  
  static final class aa
    extends h.z
  {
    final String NV()
    {
      return "polygon";
    }
  }
  
  static final class ab
    extends h.l
  {
    h.p cuG;
    h.p cuH;
    h.p cuP;
    h.p cuQ;
    h.p cuR;
    h.p cuS;
    
    final String NV()
    {
      return "rect";
    }
  }
  
  static final class ac
    extends h.al
    implements h.aj
  {
    final String NV()
    {
      return "solidColor";
    }
    
    public final List<h.an> NZ()
    {
      AppMethodBeat.i(207741);
      List localList = Collections.emptyList();
      AppMethodBeat.o(207741);
      return localList;
    }
    
    public final void a(h.an paraman) {}
  }
  
  static final class ad
    extends h.al
    implements h.aj
  {
    Float cvr;
    
    final String NV()
    {
      return "stop";
    }
    
    public final List<h.an> NZ()
    {
      AppMethodBeat.i(207746);
      List localList = Collections.emptyList();
      AppMethodBeat.o(207746);
      return localList;
    }
    
    public final void a(h.an paraman) {}
  }
  
  static final class ae
    implements Cloneable
  {
    c cvA;
    d cvB;
    Float cvC;
    h.p[] cvD;
    h.p cvE;
    Float cvF;
    h.f cvG;
    List<String> cvH;
    h.p cvI;
    Integer cvJ;
    h.ae.b cvK;
    g cvL;
    h.ae.h cvM;
    f cvN;
    Boolean cvO;
    h.c cvP;
    String cvQ;
    String cvR;
    String cvS;
    Boolean cvT;
    Boolean cvU;
    h.ao cvV;
    Float cvW;
    String cvX;
    h.ae.a cvY;
    String cvZ;
    long cvs = 0L;
    h.ao cvt;
    h.ae.a cvu;
    Float cvw;
    h.ao cvx;
    Float cvy;
    h.p cvz;
    h.ao cwa;
    Float cwb;
    h.ao cwc;
    Float cwd;
    h.ae.i cwe;
    h.ae.e cwf;
    
    static ae Ob()
    {
      AppMethodBeat.i(207751);
      ae localae = new ae();
      localae.cvs = -1L;
      localae.cvt = h.f.cuD;
      localae.cvu = h.ae.a.cwg;
      localae.cvw = Float.valueOf(1.0F);
      localae.cvx = null;
      localae.cvy = Float.valueOf(1.0F);
      localae.cvz = new h.p(1.0F);
      localae.cvA = c.cwn;
      localae.cvB = d.cwr;
      localae.cvC = Float.valueOf(4.0F);
      localae.cvD = null;
      localae.cvE = new h.p(0.0F);
      localae.cvF = Float.valueOf(1.0F);
      localae.cvG = h.f.cuD;
      localae.cvH = null;
      localae.cvI = new h.p(12.0F, h.bd.cxn);
      localae.cvJ = Integer.valueOf(400);
      localae.cvK = h.ae.b.cwj;
      localae.cvL = g.cwD;
      localae.cvM = h.ae.h.cwJ;
      localae.cvN = f.cwz;
      localae.cvO = Boolean.TRUE;
      localae.cvP = null;
      localae.cvQ = null;
      localae.cvR = null;
      localae.cvS = null;
      localae.cvT = Boolean.TRUE;
      localae.cvU = Boolean.TRUE;
      localae.cvV = h.f.cuD;
      localae.cvW = Float.valueOf(1.0F);
      localae.cvX = null;
      localae.cvY = h.ae.a.cwg;
      localae.cvZ = null;
      localae.cwa = null;
      localae.cwb = Float.valueOf(1.0F);
      localae.cwc = null;
      localae.cwd = Float.valueOf(1.0F);
      localae.cwe = h.ae.i.cwM;
      localae.cwf = h.ae.e.cwv;
      AppMethodBeat.o(207751);
      return localae;
    }
    
    final void br(boolean paramBoolean)
    {
      AppMethodBeat.i(207756);
      this.cvT = Boolean.TRUE;
      if (paramBoolean) {}
      for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
      {
        this.cvO = localBoolean;
        this.cvP = null;
        this.cvX = null;
        this.cvF = Float.valueOf(1.0F);
        this.cvV = h.f.cuD;
        this.cvW = Float.valueOf(1.0F);
        this.cvZ = null;
        this.cwa = null;
        this.cwb = Float.valueOf(1.0F);
        this.cwc = null;
        this.cwd = Float.valueOf(1.0F);
        this.cwe = h.ae.i.cwM;
        AppMethodBeat.o(207756);
        return;
      }
    }
    
    protected final Object clone()
    {
      AppMethodBeat.i(207762);
      ae localae = (ae)super.clone();
      if (this.cvD != null) {
        localae.cvD = ((h.p[])this.cvD.clone());
      }
      AppMethodBeat.o(207762);
      return localae;
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(207645);
        cwn = new c("Butt", 0);
        cwo = new c("Round", 1);
        cwp = new c("Square", 2);
        cwq = new c[] { cwn, cwo, cwp };
        AppMethodBeat.o(207645);
      }
      
      private c() {}
    }
    
    public static enum d
    {
      static
      {
        AppMethodBeat.i(207674);
        cwr = new d("Miter", 0);
        cws = new d("Round", 1);
        cwt = new d("Bevel", 2);
        cwu = new d[] { cwr, cws, cwt };
        AppMethodBeat.o(207674);
      }
      
      private d() {}
    }
    
    public static enum f
    {
      static
      {
        AppMethodBeat.i(207667);
        cwz = new f("Start", 0);
        cwA = new f("Middle", 1);
        cwB = new f("End", 2);
        cwC = new f[] { cwz, cwA, cwB };
        AppMethodBeat.o(207667);
      }
      
      private f() {}
    }
    
    public static enum g
    {
      static
      {
        AppMethodBeat.i(207664);
        cwD = new g("None", 0);
        cwE = new g("Underline", 1);
        cwF = new g("Overline", 2);
        cwG = new g("LineThrough", 3);
        cwH = new g("Blink", 4);
        cwI = new g[] { cwD, cwE, cwF, cwG, cwH };
        AppMethodBeat.o(207664);
      }
      
      private g() {}
    }
  }
  
  static final class af
    extends h.ar
  {
    h.p cuP;
    h.p cuQ;
    h.p cuR;
    h.p cuS;
    public String version;
    
    final String NV()
    {
      return "svg";
    }
  }
  
  static abstract interface ag
  {
    public abstract Set<String> Oc();
    
    public abstract String Od();
    
    public abstract Set<String> Oe();
    
    public abstract Set<String> Of();
    
    public abstract Set<String> Og();
    
    public abstract void bo(String paramString);
    
    public abstract void i(Set<String> paramSet);
    
    public abstract void j(Set<String> paramSet);
    
    public abstract void k(Set<String> paramSet);
    
    public abstract void l(Set<String> paramSet);
  }
  
  static abstract class ah
    extends h.ak
    implements h.ag, h.aj
  {
    List<h.an> aAO = new ArrayList();
    Set<String> cwP = null;
    String cwQ = null;
    Set<String> cwR = null;
    Set<String> cwS = null;
    Set<String> cwT = null;
    
    public final List<h.an> NZ()
    {
      return this.aAO;
    }
    
    public final Set<String> Oc()
    {
      return this.cwP;
    }
    
    public final String Od()
    {
      return this.cwQ;
    }
    
    public final Set<String> Oe()
    {
      return null;
    }
    
    public final Set<String> Of()
    {
      return this.cwS;
    }
    
    public final Set<String> Og()
    {
      return this.cwT;
    }
    
    public void a(h.an paraman)
    {
      this.aAO.add(paraman);
    }
    
    public final void bo(String paramString)
    {
      this.cwQ = paramString;
    }
    
    public final void i(Set<String> paramSet)
    {
      this.cwP = paramSet;
    }
    
    public final void j(Set<String> paramSet)
    {
      this.cwR = paramSet;
    }
    
    public final void k(Set<String> paramSet)
    {
      this.cwS = paramSet;
    }
    
    public final void l(Set<String> paramSet)
    {
      this.cwT = paramSet;
    }
  }
  
  static abstract class ai
    extends h.ak
    implements h.ag
  {
    Set<String> cwP = null;
    String cwQ = null;
    Set<String> cwR = null;
    Set<String> cwS = null;
    Set<String> cwT = null;
    
    public final Set<String> Oc()
    {
      return this.cwP;
    }
    
    public final String Od()
    {
      return this.cwQ;
    }
    
    public final Set<String> Oe()
    {
      return this.cwR;
    }
    
    public final Set<String> Of()
    {
      return this.cwS;
    }
    
    public final Set<String> Og()
    {
      return this.cwT;
    }
    
    public final void bo(String paramString)
    {
      this.cwQ = paramString;
    }
    
    public final void i(Set<String> paramSet)
    {
      this.cwP = paramSet;
    }
    
    public final void j(Set<String> paramSet)
    {
      this.cwR = paramSet;
    }
    
    public final void k(Set<String> paramSet)
    {
      this.cwS = paramSet;
    }
    
    public final void l(Set<String> paramSet)
    {
      this.cwT = paramSet;
    }
  }
  
  static abstract interface aj
  {
    public abstract List<h.an> NZ();
    
    public abstract void a(h.an paraman);
  }
  
  static abstract class ak
    extends h.al
  {
    h.b cwU = null;
  }
  
  static abstract class al
    extends h.an
  {
    h.ae ctr = null;
    Boolean cwV = null;
    h.ae cwW = null;
    List<String> cwX = null;
    String id = null;
    
    public String toString()
    {
      return NV();
    }
  }
  
  static final class am
    extends h.j
  {
    h.p cuU;
    h.p cuV;
    h.p cuW;
    h.p cuX;
    
    final String NV()
    {
      return "linearGradient";
    }
  }
  
  static class an
  {
    h cwY;
    h.aj cwZ;
    
    String NV()
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
    f cuh = null;
  }
  
  static final class aq
    extends h.j
  {
    h.p cuA;
    h.p cuy;
    h.p cuz;
    h.p cxa;
    h.p cxb;
    
    final String NV()
    {
      return "radialGradient";
    }
  }
  
  static abstract class ar
    extends h.ap
  {
    h.b cuj;
  }
  
  static final class as
    extends h.m
  {
    final String NV()
    {
      return "switch";
    }
  }
  
  static final class at
    extends h.ar
    implements h.t
  {
    final String NV()
    {
      return "symbol";
    }
  }
  
  static final class au
    extends h.ay
    implements h.ax
  {
    String cut;
    h.bb cxc;
    
    final String NV()
    {
      return "tref";
    }
    
    public final h.bb Oh()
    {
      return this.cxc;
    }
  }
  
  static final class av
    extends h.ba
    implements h.ax
  {
    h.bb cxc;
    
    final String NV()
    {
      return "tspan";
    }
    
    public final h.bb Oh()
    {
      return this.cxc;
    }
  }
  
  static final class aw
    extends h.ba
    implements h.bb, h.n
  {
    Matrix transform;
    
    final String NV()
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
    public abstract h.bb Oh();
  }
  
  static abstract class ay
    extends h.ah
  {
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ax))
      {
        this.aAO.add(paraman);
        return;
      }
      throw new k("Text content elements cannot contain " + paraman + " elements.");
    }
  }
  
  static final class az
    extends h.ay
    implements h.ax
  {
    String cut;
    h.bb cxc;
    h.p cxd;
    
    final String NV()
    {
      return "textPath";
    }
    
    public final h.bb Oh()
    {
      return this.cxc;
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
    
    static b h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(207695);
      b localb = new b(paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      AppMethodBeat.o(207695);
      return localb;
    }
    
    final float NW()
    {
      return this.minX + this.width;
    }
    
    final float NX()
    {
      return this.minY + this.height;
    }
    
    final void a(b paramb)
    {
      AppMethodBeat.i(207706);
      if (paramb.minX < this.minX) {
        this.minX = paramb.minX;
      }
      if (paramb.minY < this.minY) {
        this.minY = paramb.minY;
      }
      if (paramb.NW() > NW()) {
        this.width = (paramb.NW() - this.minX);
      }
      if (paramb.NX() > NX()) {
        this.height = (paramb.NX() - this.minY);
      }
      AppMethodBeat.o(207706);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207712);
      String str = "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
      AppMethodBeat.o(207712);
      return str;
    }
  }
  
  static abstract class ba
    extends h.ay
  {
    List<h.p> cxe;
    List<h.p> cxf;
    List<h.p> cxg;
    List<h.p> x;
  }
  
  static abstract interface bb {}
  
  static final class bc
    extends h.an
    implements h.ax
  {
    private h.bb cxc;
    String text;
    
    bc(String paramString)
    {
      this.text = paramString;
    }
    
    public final h.bb Oh()
    {
      return this.cxc;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207690);
      String str = "TextChild: '" + this.text + "'";
      AppMethodBeat.o(207690);
      return str;
    }
  }
  
  static enum bd
  {
    static
    {
      AppMethodBeat.i(207696);
      cxh = new bd("px", 0);
      cxi = new bd("em", 1);
      cxj = new bd("ex", 2);
      cxk = new bd("in", 3);
      cxl = new bd("cm", 4);
      cxm = new bd("mm", 5);
      cxn = new bd("pt", 6);
      cxo = new bd("pc", 7);
      cxp = new bd("percent", 8);
      cxq = new bd[] { cxh, cxi, cxj, cxk, cxl, cxm, cxn, cxo, cxp };
      AppMethodBeat.o(207696);
    }
    
    private bd() {}
  }
  
  static final class be
    extends h.m
  {
    h.p cuP;
    h.p cuQ;
    h.p cuR;
    h.p cuS;
    String cut;
    
    final String NV()
    {
      return "use";
    }
  }
  
  static final class bf
    extends h.ar
    implements h.t
  {
    final String NV()
    {
      return "view";
    }
  }
  
  static final class c
  {
    h.p cuu;
    h.p cuv;
    h.p cuw;
    h.p cux;
    
    c(h.p paramp1, h.p paramp2, h.p paramp3, h.p paramp4)
    {
      this.cuu = paramp1;
      this.cuv = paramp2;
      this.cuw = paramp3;
      this.cux = paramp4;
    }
  }
  
  static final class d
    extends h.l
  {
    h.p cuA;
    h.p cuy;
    h.p cuz;
    
    final String NV()
    {
      return "circle";
    }
  }
  
  static final class e
    extends h.m
    implements h.t
  {
    Boolean cuB;
    
    final String NV()
    {
      return "clipPath";
    }
  }
  
  static final class f
    extends h.ao
  {
    static final f cuD;
    static final f cuE;
    int cuC;
    
    static
    {
      AppMethodBeat.i(207700);
      cuD = new f(-16777216);
      cuE = new f(0);
      AppMethodBeat.o(207700);
    }
    
    f(int paramInt)
    {
      this.cuC = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207707);
      String str = String.format("#%08x", new Object[] { Integer.valueOf(this.cuC) });
      AppMethodBeat.o(207707);
      return str;
    }
  }
  
  static final class g
    extends h.ao
  {
    private static g cuF;
    
    static
    {
      AppMethodBeat.i(207699);
      cuF = new g();
      AppMethodBeat.o(207699);
    }
    
    static g NY()
    {
      return cuF;
    }
  }
  
  static final class h
    extends h.m
    implements h.t
  {
    final String NV()
    {
      return "defs";
    }
  }
  
  static final class i
    extends h.l
  {
    h.p cuG;
    h.p cuH;
    h.p cuy;
    h.p cuz;
    
    final String NV()
    {
      return "ellipse";
    }
  }
  
  static abstract class j
    extends h.al
    implements h.aj
  {
    List<h.an> aAO = new ArrayList();
    Boolean cuI;
    Matrix cuJ;
    h.k cuK;
    String cut;
    
    public final List<h.an> NZ()
    {
      return this.aAO;
    }
    
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ad))
      {
        this.aAO.add(paraman);
        return;
      }
      throw new k("Gradient elements cannot contain " + paraman + " elements.");
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
    
    String NV()
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
    h.p cuP;
    h.p cuQ;
    h.p cuR;
    h.p cuS;
    String cut;
    Matrix transform;
    
    final String NV()
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
    h.bd cuT;
    float value;
    
    p(float paramFloat)
    {
      this.value = paramFloat;
      this.cuT = h.bd.cxh;
    }
    
    p(float paramFloat, h.bd parambd)
    {
      this.value = paramFloat;
      this.cuT = parambd;
    }
    
    final boolean Oa()
    {
      return this.value == 0.0F;
    }
    
    final float a(i parami)
    {
      AppMethodBeat.i(207692);
      float f2;
      switch (h.1.cus[this.cuT.ordinal()])
      {
      default: 
        f1 = this.value;
        AppMethodBeat.o(207692);
        return f1;
      case 1: 
        f1 = this.value;
        AppMethodBeat.o(207692);
        return f1;
      case 2: 
        f1 = this.value;
        f2 = parami.Oj();
        AppMethodBeat.o(207692);
        return f1 * f2;
      case 3: 
        f1 = this.value;
        f2 = parami.cxt.cxR.getTextSize() / 2.0F;
        AppMethodBeat.o(207692);
        return f1 * f2;
      case 4: 
        f1 = this.value;
        f2 = parami.cxs;
        AppMethodBeat.o(207692);
        return f1 * f2;
      case 5: 
        f1 = this.value * parami.cxs / 2.54F;
        AppMethodBeat.o(207692);
        return f1;
      case 6: 
        f1 = this.value * parami.cxs / 25.4F;
        AppMethodBeat.o(207692);
        return f1;
      case 7: 
        f1 = this.value * parami.cxs / 72.0F;
        AppMethodBeat.o(207692);
        return f1;
      case 8: 
        f1 = this.value * parami.cxs / 6.0F;
        AppMethodBeat.o(207692);
        return f1;
      }
      parami = parami.Ok();
      if (parami == null)
      {
        f1 = this.value;
        AppMethodBeat.o(207692);
        return f1;
      }
      float f1 = this.value;
      f1 = parami.width * f1 / 100.0F;
      AppMethodBeat.o(207692);
      return f1;
    }
    
    final float a(i parami, float paramFloat)
    {
      AppMethodBeat.i(207704);
      if (this.cuT == h.bd.cxp)
      {
        paramFloat = this.value * paramFloat / 100.0F;
        AppMethodBeat.o(207704);
        return paramFloat;
      }
      paramFloat = a(parami);
      AppMethodBeat.o(207704);
      return paramFloat;
    }
    
    final float aL(float paramFloat)
    {
      AppMethodBeat.i(207711);
      switch (h.1.cus[this.cuT.ordinal()])
      {
      case 2: 
      case 3: 
      default: 
        paramFloat = this.value;
        AppMethodBeat.o(207711);
        return paramFloat;
      case 1: 
        paramFloat = this.value;
        AppMethodBeat.o(207711);
        return paramFloat;
      case 4: 
        float f = this.value;
        AppMethodBeat.o(207711);
        return f * paramFloat;
      case 5: 
        paramFloat = this.value * paramFloat / 2.54F;
        AppMethodBeat.o(207711);
        return paramFloat;
      case 6: 
        paramFloat = this.value * paramFloat / 25.4F;
        AppMethodBeat.o(207711);
        return paramFloat;
      case 7: 
        paramFloat = this.value * paramFloat / 72.0F;
        AppMethodBeat.o(207711);
        return paramFloat;
      }
      paramFloat = this.value * paramFloat / 6.0F;
      AppMethodBeat.o(207711);
      return paramFloat;
    }
    
    final float b(i parami)
    {
      AppMethodBeat.i(207697);
      if (this.cuT == h.bd.cxp)
      {
        parami = parami.Ok();
        if (parami == null)
        {
          f = this.value;
          AppMethodBeat.o(207697);
          return f;
        }
        f = this.value;
        f = parami.height * f / 100.0F;
        AppMethodBeat.o(207697);
        return f;
      }
      float f = a(parami);
      AppMethodBeat.o(207697);
      return f;
    }
    
    final float c(i parami)
    {
      AppMethodBeat.i(207698);
      if (this.cuT == h.bd.cxp)
      {
        parami = parami.Ok();
        if (parami == null)
        {
          f1 = this.value;
          AppMethodBeat.o(207698);
          return f1;
        }
        f1 = parami.width;
        float f2 = parami.height;
        if (f1 == f2)
        {
          f1 = this.value * f1 / 100.0F;
          AppMethodBeat.o(207698);
          return f1;
        }
        f1 = (float)(Math.sqrt(f2 * f2 + f1 * f1) / 1.414213562373095D) * this.value / 100.0F;
        AppMethodBeat.o(207698);
        return f1;
      }
      float f1 = a(parami);
      AppMethodBeat.o(207698);
      return f1;
    }
    
    final boolean isNegative()
    {
      return this.value < 0.0F;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207728);
      String str = String.valueOf(this.value) + this.cuT;
      AppMethodBeat.o(207728);
      return str;
    }
  }
  
  static final class q
    extends h.l
  {
    h.p cuU;
    h.p cuV;
    h.p cuW;
    h.p cuX;
    
    final String NV()
    {
      return "line";
    }
  }
  
  static final class r
    extends h.ar
    implements h.t
  {
    boolean cuY;
    h.p cuZ;
    h.p cva;
    h.p cvb;
    h.p cvc;
    Float cvd;
    
    final String NV()
    {
      return "marker";
    }
  }
  
  static final class s
    extends h.ah
    implements h.t
  {
    h.p cuP;
    h.p cuQ;
    h.p cuR;
    h.p cuS;
    Boolean cve;
    Boolean cvf;
    
    final String NV()
    {
      return "mask";
    }
  }
  
  static abstract interface t {}
  
  static final class u
    extends h.ao
  {
    String cut;
    h.ao cvg;
    
    u(String paramString, h.ao paramao)
    {
      this.cut = paramString;
      this.cvg = paramao;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207721);
      String str = this.cut + " " + this.cvg;
      AppMethodBeat.o(207721);
      return str;
    }
  }
  
  static final class v
    extends h.l
  {
    h.w cvh;
    Float cvi;
    
    final String NV()
    {
      return "path";
    }
  }
  
  static final class w
    implements h.x
  {
    private byte[] cvj;
    private int cvk;
    private float[] cvl;
    private int cvm;
    
    w()
    {
      AppMethodBeat.i(207727);
      this.cvk = 0;
      this.cvm = 0;
      this.cvj = new byte[8];
      this.cvl = new float[16];
      AppMethodBeat.o(207727);
    }
    
    private void ha(int paramInt)
    {
      AppMethodBeat.i(207734);
      if (this.cvl.length < this.cvm + paramInt)
      {
        float[] arrayOfFloat = new float[this.cvl.length * 2];
        System.arraycopy(this.cvl, 0, arrayOfFloat, 0, this.cvl.length);
        this.cvl = arrayOfFloat;
      }
      AppMethodBeat.o(207734);
    }
    
    public final void B(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207747);
      b((byte)0);
      ha(2);
      float[] arrayOfFloat = this.cvl;
      int i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(207747);
    }
    
    public final void D(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207753);
      b((byte)1);
      ha(2);
      float[] arrayOfFloat = this.cvl;
      int i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(207753);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      int j = 0;
      AppMethodBeat.i(207768);
      if (paramBoolean1) {}
      for (int i = 2;; i = 0)
      {
        if (paramBoolean2) {
          j = 1;
        }
        b((byte)(j | i | 0x4));
        ha(5);
        float[] arrayOfFloat = this.cvl;
        i = this.cvm;
        this.cvm = (i + 1);
        arrayOfFloat[i] = paramFloat1;
        arrayOfFloat = this.cvl;
        i = this.cvm;
        this.cvm = (i + 1);
        arrayOfFloat[i] = paramFloat2;
        arrayOfFloat = this.cvl;
        i = this.cvm;
        this.cvm = (i + 1);
        arrayOfFloat[i] = paramFloat3;
        arrayOfFloat = this.cvl;
        i = this.cvm;
        this.cvm = (i + 1);
        arrayOfFloat[i] = paramFloat4;
        arrayOfFloat = this.cvl;
        i = this.cvm;
        this.cvm = (i + 1);
        arrayOfFloat[i] = paramFloat5;
        AppMethodBeat.o(207768);
        return;
      }
    }
    
    final void a(h.x paramx)
    {
      AppMethodBeat.i(207784);
      int j = 0;
      int i = 0;
      if (j < this.cvk)
      {
        int k = this.cvj[j];
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
          float[] arrayOfFloat = this.cvl;
          k = i + 1;
          float f1 = arrayOfFloat[i];
          arrayOfFloat = this.cvl;
          i = k + 1;
          float f2 = arrayOfFloat[k];
          arrayOfFloat = this.cvl;
          k = i + 1;
          float f3 = arrayOfFloat[i];
          arrayOfFloat = this.cvl;
          i = k + 1;
          paramx.a(f1, f2, f3, bool1, bool2, arrayOfFloat[k], this.cvl[i]);
          i += 1;
          for (;;)
          {
            j += 1;
            break;
            arrayOfFloat = this.cvl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.cvl;
            i = k + 1;
            paramx.B(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.cvl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.cvl;
            i = k + 1;
            paramx.D(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.cvl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.cvl;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.cvl;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.cvl;
            i = k + 1;
            float f4 = arrayOfFloat[k];
            arrayOfFloat = this.cvl;
            k = i + 1;
            paramx.b(f1, f2, f3, f4, arrayOfFloat[i], this.cvl[k]);
            i = k + 1;
            continue;
            arrayOfFloat = this.cvl;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.cvl;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.cvl;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.cvl;
            i = k + 1;
            paramx.i(f1, f2, f3, arrayOfFloat[k]);
            continue;
            paramx.close();
          }
          bool1 = false;
          break label90;
        }
      }
      AppMethodBeat.o(207784);
    }
    
    final void b(byte paramByte)
    {
      AppMethodBeat.i(207742);
      if (this.cvk == this.cvj.length)
      {
        arrayOfByte = new byte[this.cvj.length * 2];
        System.arraycopy(this.cvj, 0, arrayOfByte, 0, this.cvj.length);
        this.cvj = arrayOfByte;
      }
      byte[] arrayOfByte = this.cvj;
      int i = this.cvk;
      this.cvk = (i + 1);
      arrayOfByte[i] = paramByte;
      AppMethodBeat.o(207742);
    }
    
    public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(207759);
      b((byte)2);
      ha(6);
      float[] arrayOfFloat = this.cvl;
      int i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat5;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat6;
      AppMethodBeat.o(207759);
    }
    
    public final void close()
    {
      AppMethodBeat.i(207774);
      b((byte)8);
      AppMethodBeat.o(207774);
    }
    
    public final void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(207763);
      b((byte)3);
      ha(4);
      float[] arrayOfFloat = this.cvl;
      int i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.cvl;
      i = this.cvm;
      this.cvm = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      AppMethodBeat.o(207763);
    }
    
    final boolean isEmpty()
    {
      return this.cvk == 0;
    }
  }
  
  static abstract interface x
  {
    public abstract void B(float paramFloat1, float paramFloat2);
    
    public abstract void D(float paramFloat1, float paramFloat2);
    
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5);
    
    public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
    
    public abstract void close();
    
    public abstract void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }
  
  static final class y
    extends h.ar
    implements h.t
  {
    h.p cuP;
    h.p cuQ;
    h.p cuR;
    h.p cuS;
    String cut;
    Boolean cvn;
    Boolean cvo;
    Matrix cvp;
    
    final String NV()
    {
      return "pattern";
    }
  }
  
  static class z
    extends h.l
  {
    float[] cvq;
    
    String NV()
    {
      return "polyline";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.a.a.h
 * JD-Core Version:    0.7.0.1
 */