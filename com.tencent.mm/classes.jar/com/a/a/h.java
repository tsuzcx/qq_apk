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
  private static j ayw = null;
  private static boolean ayx = true;
  b.q ayA;
  private Map<String, al> ayB;
  af ayy;
  private float ayz;
  String desc;
  String title;
  
  h()
  {
    AppMethodBeat.i(202134);
    this.ayy = null;
    this.title = "";
    this.desc = "";
    this.ayz = 96.0F;
    this.ayA = new b.q();
    this.ayB = new HashMap();
    AppMethodBeat.o(202134);
  }
  
  private b D(float paramFloat)
  {
    AppMethodBeat.i(202168);
    Object localObject = this.ayy.azc;
    p localp = this.ayy.azd;
    if ((localObject == null) || (((p)localObject).or()) || (((p)localObject).aze == bd.aBA) || (((p)localObject).aze == bd.aBt) || (((p)localObject).aze == bd.aBu))
    {
      localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
      AppMethodBeat.o(202168);
      return localObject;
    }
    float f = ((p)localObject).E(paramFloat);
    if (localp != null)
    {
      if ((localp.or()) || (localp.aze == bd.aBA) || (localp.aze == bd.aBt) || (localp.aze == bd.aBu))
      {
        localObject = new b(-1.0F, -1.0F, -1.0F, -1.0F);
        AppMethodBeat.o(202168);
        return localObject;
      }
      paramFloat = localp.E(paramFloat);
    }
    for (;;)
    {
      localObject = new b(0.0F, 0.0F, f, paramFloat);
      AppMethodBeat.o(202168);
      return localObject;
      if (this.ayy.ayu != null) {
        paramFloat = this.ayy.ayu.height * f / this.ayy.ayu.width;
      } else {
        paramFloat = f;
      }
    }
  }
  
  private al a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(202190);
    Object localObject = (al)paramaj;
    if (paramString.equals(((al)localObject).id))
    {
      AppMethodBeat.o(202190);
      return localObject;
    }
    paramaj = paramaj.oq().iterator();
    while (paramaj.hasNext())
    {
      localObject = (an)paramaj.next();
      if ((localObject instanceof al))
      {
        al localal = (al)localObject;
        if (paramString.equals(localal.id))
        {
          AppMethodBeat.o(202190);
          return localal;
        }
        if ((localObject instanceof aj))
        {
          localObject = a((aj)localObject, paramString);
          if (localObject != null)
          {
            AppMethodBeat.o(202190);
            return localObject;
          }
        }
      }
    }
    AppMethodBeat.o(202190);
    return null;
  }
  
  private Picture ba(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202149);
    Picture localPicture = new Picture();
    Canvas localCanvas = localPicture.beginRecording(paramInt1, paramInt2);
    g localg = new g();
    localg.k(paramInt1, paramInt2);
    new i(localCanvas, this.ayz).a(this, localg);
    localPicture.endRecording();
    AppMethodBeat.o(202149);
    return localPicture;
  }
  
  public static h c(InputStream paramInputStream)
  {
    AppMethodBeat.i(202135);
    paramInputStream = new l().a(paramInputStream, ayx);
    AppMethodBeat.o(202135);
    return paramInputStream;
  }
  
  static j ol()
  {
    return ayw;
  }
  
  final an Z(String paramString)
  {
    AppMethodBeat.i(202155);
    if (paramString == null)
    {
      AppMethodBeat.o(202155);
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
      AppMethodBeat.o(202155);
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
    AppMethodBeat.o(202155);
    return null;
  }
  
  final al aa(String paramString)
  {
    AppMethodBeat.i(202186);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(202186);
      return null;
    }
    if (paramString.equals(this.ayy.id))
    {
      paramString = this.ayy;
      AppMethodBeat.o(202186);
      return paramString;
    }
    if (this.ayB.containsKey(paramString))
    {
      paramString = (al)this.ayB.get(paramString);
      AppMethodBeat.o(202186);
      return paramString;
    }
    al localal = a(this.ayy, paramString);
    this.ayB.put(paramString, localal);
    AppMethodBeat.o(202186);
    return localal;
  }
  
  final void b(b.q paramq)
  {
    AppMethodBeat.i(202169);
    this.ayA.a(paramq);
    AppMethodBeat.o(202169);
  }
  
  public final Picture og()
  {
    AppMethodBeat.i(202144);
    Object localObject = this.ayy.ayu;
    float f1;
    float f2;
    if ((this.ayy.azc != null) && (this.ayy.azc.aze != bd.aBA) && (this.ayy.azd != null) && (this.ayy.azd.aze != bd.aBA))
    {
      f1 = this.ayy.azc.E(this.ayz);
      f2 = this.ayy.azd.E(this.ayz);
      localObject = ba((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(202144);
      return localObject;
    }
    if ((this.ayy.azc != null) && (localObject != null))
    {
      f1 = this.ayy.azc.E(this.ayz);
      f2 = ((b)localObject).height * f1 / ((b)localObject).width;
      localObject = ba((int)Math.ceil(f1), (int)Math.ceil(f2));
      AppMethodBeat.o(202144);
      return localObject;
    }
    if ((this.ayy.azd != null) && (localObject != null))
    {
      f1 = this.ayy.azd.E(this.ayz);
      localObject = ba((int)Math.ceil(((b)localObject).width * f1 / ((b)localObject).height), (int)Math.ceil(f1));
      AppMethodBeat.o(202144);
      return localObject;
    }
    localObject = ba(512, 512);
    AppMethodBeat.o(202144);
    return localObject;
  }
  
  public final float oh()
  {
    AppMethodBeat.i(202151);
    if (this.ayy == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(202151);
      throw localIllegalArgumentException;
    }
    float f = D(this.ayz).width;
    AppMethodBeat.o(202151);
    return f;
  }
  
  public final float oi()
  {
    AppMethodBeat.i(202152);
    if (this.ayy == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("SVG document is empty");
      AppMethodBeat.o(202152);
      throw localIllegalArgumentException;
    }
    float f = D(this.ayz).height;
    AppMethodBeat.o(202152);
    return f;
  }
  
  final boolean oj()
  {
    AppMethodBeat.i(202174);
    b.q localq = this.ayA;
    if ((localq.axF == null) || (localq.axF.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(202174);
      return true;
    }
    AppMethodBeat.o(202174);
    return false;
  }
  
  final void ok()
  {
    AppMethodBeat.i(202178);
    Object localObject = this.ayA;
    b.t localt = b.t.axM;
    if (((b.q)localObject).axF != null)
    {
      localObject = ((b.q)localObject).axF.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((b.o)((Iterator)localObject).next()).aww == localt) {
          ((Iterator)localObject).remove();
        }
      }
    }
    AppMethodBeat.o(202178);
  }
  
  static final class a
    extends h.m
  {
    String ayD;
    
    final String om()
    {
      return "a";
    }
  }
  
  static final class aa
    extends h.z
  {
    final String om()
    {
      return "polygon";
    }
  }
  
  static final class ab
    extends h.l
  {
    h.p ayQ;
    h.p ayR;
    h.p aza;
    h.p azb;
    h.p azc;
    h.p azd;
    
    final String om()
    {
      return "rect";
    }
  }
  
  static final class ac
    extends h.al
    implements h.aj
  {
    public final void a(h.an paraman) {}
    
    final String om()
    {
      return "solidColor";
    }
    
    public final List<h.an> oq()
    {
      AppMethodBeat.i(201972);
      List localList = Collections.emptyList();
      AppMethodBeat.o(201972);
      return localList;
    }
  }
  
  static final class ad
    extends h.al
    implements h.aj
  {
    Float azC;
    
    public final void a(h.an paraman) {}
    
    final String om()
    {
      return "stop";
    }
    
    public final List<h.an> oq()
    {
      AppMethodBeat.i(201976);
      List localList = Collections.emptyList();
      AppMethodBeat.o(201976);
      return localList;
    }
  }
  
  static final class ae
    implements Cloneable
  {
    String aAa;
    String aAb;
    String aAc;
    Boolean aAd;
    Boolean aAe;
    h.ao aAf;
    Float aAg;
    String aAh;
    h.ae.a aAi;
    String aAj;
    h.ao aAk;
    Float aAl;
    h.ao aAm;
    Float aAn;
    h.ae.i aAo;
    h.ae.e aAp;
    long azD = 0L;
    h.ao azE;
    h.ae.a azF;
    Float azG;
    h.ao azH;
    Float azI;
    h.p azJ;
    c azK;
    d azL;
    Float azM;
    h.p[] azN;
    h.p azO;
    Float azP;
    h.f azQ;
    List<String> azR;
    h.p azS;
    Integer azT;
    h.ae.b azU;
    h.ae.g azV;
    h.ae.h azW;
    h.ae.f azX;
    Boolean azY;
    h.c azZ;
    
    static ae ot()
    {
      AppMethodBeat.i(202066);
      ae localae = new ae();
      localae.azD = -1L;
      localae.azE = h.f.ayN;
      localae.azF = h.ae.a.aAq;
      localae.azG = Float.valueOf(1.0F);
      localae.azH = null;
      localae.azI = Float.valueOf(1.0F);
      localae.azJ = new h.p(1.0F);
      localae.azK = c.aAx;
      localae.azL = d.aAB;
      localae.azM = Float.valueOf(4.0F);
      localae.azN = null;
      localae.azO = new h.p(0.0F);
      localae.azP = Float.valueOf(1.0F);
      localae.azQ = h.f.ayN;
      localae.azR = null;
      localae.azS = new h.p(12.0F, h.bd.aBy);
      localae.azT = Integer.valueOf(400);
      localae.azU = h.ae.b.aAt;
      localae.azV = h.ae.g.aAN;
      localae.azW = h.ae.h.aAT;
      localae.azX = h.ae.f.aAJ;
      localae.azY = Boolean.TRUE;
      localae.azZ = null;
      localae.aAa = null;
      localae.aAb = null;
      localae.aAc = null;
      localae.aAd = Boolean.TRUE;
      localae.aAe = Boolean.TRUE;
      localae.aAf = h.f.ayN;
      localae.aAg = Float.valueOf(1.0F);
      localae.aAh = null;
      localae.aAi = h.ae.a.aAq;
      localae.aAj = null;
      localae.aAk = null;
      localae.aAl = Float.valueOf(1.0F);
      localae.aAm = null;
      localae.aAn = Float.valueOf(1.0F);
      localae.aAo = h.ae.i.aAW;
      localae.aAp = h.ae.e.aAF;
      AppMethodBeat.o(202066);
      return localae;
    }
    
    final void aG(boolean paramBoolean)
    {
      AppMethodBeat.i(202070);
      this.aAd = Boolean.TRUE;
      if (paramBoolean) {}
      for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
      {
        this.azY = localBoolean;
        this.azZ = null;
        this.aAh = null;
        this.azP = Float.valueOf(1.0F);
        this.aAf = h.f.ayN;
        this.aAg = Float.valueOf(1.0F);
        this.aAj = null;
        this.aAk = null;
        this.aAl = Float.valueOf(1.0F);
        this.aAm = null;
        this.aAn = Float.valueOf(1.0F);
        this.aAo = h.ae.i.aAW;
        AppMethodBeat.o(202070);
        return;
      }
    }
    
    protected final Object clone()
    {
      AppMethodBeat.i(202072);
      ae localae = (ae)super.clone();
      if (this.azN != null) {
        localae.azN = ((h.p[])this.azN.clone());
      }
      AppMethodBeat.o(202072);
      return localae;
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(202000);
        aAx = new c("Butt", 0);
        aAy = new c("Round", 1);
        aAz = new c("Square", 2);
        aAA = new c[] { aAx, aAy, aAz };
        AppMethodBeat.o(202000);
      }
      
      private c() {}
    }
    
    public static enum d
    {
      static
      {
        AppMethodBeat.i(202005);
        aAB = new d("Miter", 0);
        aAC = new d("Round", 1);
        aAD = new d("Bevel", 2);
        aAE = new d[] { aAB, aAC, aAD };
        AppMethodBeat.o(202005);
      }
      
      private d() {}
    }
  }
  
  static final class af
    extends h.ar
  {
    h.p aza;
    h.p azb;
    h.p azc;
    h.p azd;
    public String version;
    
    final String om()
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
    
    public abstract Set<String> ou();
    
    public abstract String ov();
    
    public abstract Set<String> ow();
    
    public abstract Set<String> ox();
    
    public abstract Set<String> oy();
  }
  
  static abstract class ah
    extends h.ak
    implements h.ag, h.aj
  {
    Set<String> aAZ = null;
    String aBa = null;
    Set<String> aBb = null;
    Set<String> aBc = null;
    Set<String> aBd = null;
    List<h.an> ayS = new ArrayList();
    
    public void a(h.an paraman)
    {
      this.ayS.add(paraman);
    }
    
    public final void ab(String paramString)
    {
      this.aBa = paramString;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.aAZ = paramSet;
    }
    
    public final void c(Set<String> paramSet)
    {
      this.aBb = paramSet;
    }
    
    public final void d(Set<String> paramSet)
    {
      this.aBc = paramSet;
    }
    
    public final void e(Set<String> paramSet)
    {
      this.aBd = paramSet;
    }
    
    public final List<h.an> oq()
    {
      return this.ayS;
    }
    
    public final Set<String> ou()
    {
      return this.aAZ;
    }
    
    public final String ov()
    {
      return this.aBa;
    }
    
    public final Set<String> ow()
    {
      return null;
    }
    
    public final Set<String> ox()
    {
      return this.aBc;
    }
    
    public final Set<String> oy()
    {
      return this.aBd;
    }
  }
  
  static abstract class ai
    extends h.ak
    implements h.ag
  {
    Set<String> aAZ = null;
    String aBa = null;
    Set<String> aBb = null;
    Set<String> aBc = null;
    Set<String> aBd = null;
    
    public final void ab(String paramString)
    {
      this.aBa = paramString;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.aAZ = paramSet;
    }
    
    public final void c(Set<String> paramSet)
    {
      this.aBb = paramSet;
    }
    
    public final void d(Set<String> paramSet)
    {
      this.aBc = paramSet;
    }
    
    public final void e(Set<String> paramSet)
    {
      this.aBd = paramSet;
    }
    
    public final Set<String> ou()
    {
      return this.aAZ;
    }
    
    public final String ov()
    {
      return this.aBa;
    }
    
    public final Set<String> ow()
    {
      return this.aBb;
    }
    
    public final Set<String> ox()
    {
      return this.aBc;
    }
    
    public final Set<String> oy()
    {
      return this.aBd;
    }
  }
  
  static abstract interface aj
  {
    public abstract void a(h.an paraman);
    
    public abstract List<h.an> oq();
  }
  
  static abstract class ak
    extends h.al
  {
    h.b aBe = null;
  }
  
  static abstract class al
    extends h.an
  {
    Boolean aBf = null;
    h.ae aBg = null;
    List<String> aBh = null;
    h.ae axD = null;
    String id = null;
    
    public String toString()
    {
      return om();
    }
  }
  
  static final class am
    extends h.j
  {
    h.p azf;
    h.p azg;
    h.p azh;
    h.p azi;
    
    final String om()
    {
      return "linearGradient";
    }
  }
  
  static class an
  {
    h aBi;
    h.aj aBj;
    
    String om()
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
    f ays = null;
  }
  
  static final class aq
    extends h.j
  {
    h.p aBk;
    h.p aBl;
    h.p ayI;
    h.p ayJ;
    h.p ayK;
    
    final String om()
    {
      return "radialGradient";
    }
  }
  
  static abstract class ar
    extends h.ap
  {
    h.b ayu;
  }
  
  static final class as
    extends h.m
  {
    final String om()
    {
      return "switch";
    }
  }
  
  static final class at
    extends h.ar
    implements h.t
  {
    final String om()
    {
      return "symbol";
    }
  }
  
  static final class au
    extends h.ay
    implements h.ax
  {
    h.bb aBm;
    String ayD;
    
    final String om()
    {
      return "tref";
    }
    
    public final h.bb oz()
    {
      return this.aBm;
    }
  }
  
  static final class av
    extends h.ba
    implements h.ax
  {
    h.bb aBm;
    
    final String om()
    {
      return "tspan";
    }
    
    public final h.bb oz()
    {
      return this.aBm;
    }
  }
  
  static final class aw
    extends h.ba
    implements h.bb, h.n
  {
    Matrix transform;
    
    final String om()
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
    public abstract h.bb oz();
  }
  
  static abstract class ay
    extends h.ah
  {
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ax))
      {
        this.ayS.add(paraman);
        return;
      }
      throw new k("Text content elements cannot contain " + paraman + " elements.");
    }
  }
  
  static final class az
    extends h.ay
    implements h.ax
  {
    h.bb aBm;
    h.p aBn;
    String ayD;
    
    final String om()
    {
      return "textPath";
    }
    
    public final h.bb oz()
    {
      return this.aBm;
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
    
    static b e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(201817);
      b localb = new b(paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      AppMethodBeat.o(201817);
      return localb;
    }
    
    final void a(b paramb)
    {
      AppMethodBeat.i(201821);
      if (paramb.minX < this.minX) {
        this.minX = paramb.minX;
      }
      if (paramb.minY < this.minY) {
        this.minY = paramb.minY;
      }
      if (paramb.on() > on()) {
        this.width = (paramb.on() - this.minX);
      }
      if (paramb.oo() > oo()) {
        this.height = (paramb.oo() - this.minY);
      }
      AppMethodBeat.o(201821);
    }
    
    final float on()
    {
      return this.minX + this.width;
    }
    
    final float oo()
    {
      return this.minY + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201823);
      String str = "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
      AppMethodBeat.o(201823);
      return str;
    }
  }
  
  static abstract class ba
    extends h.ay
  {
    List<h.p> aBo;
    List<h.p> aBp;
    List<h.p> aBq;
    List<h.p> aBr;
  }
  
  static abstract interface bb {}
  
  static final class bc
    extends h.an
    implements h.ax
  {
    private h.bb aBm;
    String text;
    
    bc(String paramString)
    {
      this.text = paramString;
    }
    
    public final h.bb oz()
    {
      return this.aBm;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202113);
      String str = "TextChild: '" + this.text + "'";
      AppMethodBeat.o(202113);
      return str;
    }
  }
  
  static enum bd
  {
    static
    {
      AppMethodBeat.i(202126);
      aBs = new bd("px", 0);
      aBt = new bd("em", 1);
      aBu = new bd("ex", 2);
      aBv = new bd("in", 3);
      aBw = new bd("cm", 4);
      aBx = new bd("mm", 5);
      aBy = new bd("pt", 6);
      aBz = new bd("pc", 7);
      aBA = new bd("percent", 8);
      aBB = new bd[] { aBs, aBt, aBu, aBv, aBw, aBx, aBy, aBz, aBA };
      AppMethodBeat.o(202126);
    }
    
    private bd() {}
  }
  
  static final class be
    extends h.m
  {
    String ayD;
    h.p aza;
    h.p azb;
    h.p azc;
    h.p azd;
    
    final String om()
    {
      return "use";
    }
  }
  
  static final class bf
    extends h.ar
    implements h.t
  {
    final String om()
    {
      return "view";
    }
  }
  
  static final class c
  {
    h.p ayE;
    h.p ayF;
    h.p ayG;
    h.p ayH;
    
    c(h.p paramp1, h.p paramp2, h.p paramp3, h.p paramp4)
    {
      this.ayE = paramp1;
      this.ayF = paramp2;
      this.ayG = paramp3;
      this.ayH = paramp4;
    }
  }
  
  static final class d
    extends h.l
  {
    h.p ayI;
    h.p ayJ;
    h.p ayK;
    
    final String om()
    {
      return "circle";
    }
  }
  
  static final class e
    extends h.m
    implements h.t
  {
    Boolean ayL;
    
    final String om()
    {
      return "clipPath";
    }
  }
  
  static final class f
    extends h.ao
  {
    static final f ayN;
    static final f ayO;
    int ayM;
    
    static
    {
      AppMethodBeat.i(201841);
      ayN = new f(-16777216);
      ayO = new f(0);
      AppMethodBeat.o(201841);
    }
    
    f(int paramInt)
    {
      this.ayM = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201838);
      String str = String.format("#%08x", new Object[] { Integer.valueOf(this.ayM) });
      AppMethodBeat.o(201838);
      return str;
    }
  }
  
  static final class g
    extends h.ao
  {
    private static g ayP;
    
    static
    {
      AppMethodBeat.i(201844);
      ayP = new g();
      AppMethodBeat.o(201844);
    }
    
    static g op()
    {
      return ayP;
    }
  }
  
  static final class h
    extends h.m
    implements h.t
  {
    final String om()
    {
      return "defs";
    }
  }
  
  static final class i
    extends h.l
  {
    h.p ayI;
    h.p ayJ;
    h.p ayQ;
    h.p ayR;
    
    final String om()
    {
      return "ellipse";
    }
  }
  
  static abstract class j
    extends h.al
    implements h.aj
  {
    String ayD;
    List<h.an> ayS = new ArrayList();
    Boolean ayT;
    Matrix ayU;
    h.k ayV;
    
    public final void a(h.an paraman)
    {
      if ((paraman instanceof h.ad))
      {
        this.ayS.add(paraman);
        return;
      }
      throw new k("Gradient elements cannot contain " + paraman + " elements.");
    }
    
    public final List<h.an> oq()
    {
      return this.ayS;
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
    
    String om()
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
    String ayD;
    h.p aza;
    h.p azb;
    h.p azc;
    h.p azd;
    Matrix transform;
    
    final String om()
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
    h.bd aze;
    float value;
    
    p(float paramFloat)
    {
      this.value = paramFloat;
      this.aze = h.bd.aBs;
    }
    
    p(float paramFloat, h.bd parambd)
    {
      this.value = paramFloat;
      this.aze = parambd;
    }
    
    final float E(float paramFloat)
    {
      AppMethodBeat.i(201890);
      switch (h.1.ayC[this.aze.ordinal()])
      {
      case 2: 
      case 3: 
      default: 
        paramFloat = this.value;
        AppMethodBeat.o(201890);
        return paramFloat;
      case 1: 
        paramFloat = this.value;
        AppMethodBeat.o(201890);
        return paramFloat;
      case 4: 
        float f = this.value;
        AppMethodBeat.o(201890);
        return f * paramFloat;
      case 5: 
        paramFloat = this.value * paramFloat / 2.54F;
        AppMethodBeat.o(201890);
        return paramFloat;
      case 6: 
        paramFloat = this.value * paramFloat / 25.4F;
        AppMethodBeat.o(201890);
        return paramFloat;
      case 7: 
        paramFloat = this.value * paramFloat / 72.0F;
        AppMethodBeat.o(201890);
        return paramFloat;
      }
      paramFloat = this.value * paramFloat / 6.0F;
      AppMethodBeat.o(201890);
      return paramFloat;
    }
    
    final float a(i parami)
    {
      AppMethodBeat.i(201880);
      float f2;
      switch (h.1.ayC[this.aze.ordinal()])
      {
      default: 
        f1 = this.value;
        AppMethodBeat.o(201880);
        return f1;
      case 1: 
        f1 = this.value;
        AppMethodBeat.o(201880);
        return f1;
      case 2: 
        f1 = this.value;
        f2 = parami.oB();
        AppMethodBeat.o(201880);
        return f1 * f2;
      case 3: 
        f1 = this.value;
        f2 = parami.aBE.aCf.getTextSize() / 2.0F;
        AppMethodBeat.o(201880);
        return f1 * f2;
      case 4: 
        f1 = this.value;
        f2 = parami.aBD;
        AppMethodBeat.o(201880);
        return f1 * f2;
      case 5: 
        f1 = this.value * parami.aBD / 2.54F;
        AppMethodBeat.o(201880);
        return f1;
      case 6: 
        f1 = this.value * parami.aBD / 25.4F;
        AppMethodBeat.o(201880);
        return f1;
      case 7: 
        f1 = this.value * parami.aBD / 72.0F;
        AppMethodBeat.o(201880);
        return f1;
      case 8: 
        f1 = this.value * parami.aBD / 6.0F;
        AppMethodBeat.o(201880);
        return f1;
      }
      parami = parami.oC();
      if (parami == null)
      {
        f1 = this.value;
        AppMethodBeat.o(201880);
        return f1;
      }
      float f1 = this.value;
      f1 = parami.width * f1 / 100.0F;
      AppMethodBeat.o(201880);
      return f1;
    }
    
    final float a(i parami, float paramFloat)
    {
      AppMethodBeat.i(201888);
      if (this.aze == h.bd.aBA)
      {
        paramFloat = this.value * paramFloat / 100.0F;
        AppMethodBeat.o(201888);
        return paramFloat;
      }
      paramFloat = a(parami);
      AppMethodBeat.o(201888);
      return paramFloat;
    }
    
    final float b(i parami)
    {
      AppMethodBeat.i(201882);
      if (this.aze == h.bd.aBA)
      {
        parami = parami.oC();
        if (parami == null)
        {
          f = this.value;
          AppMethodBeat.o(201882);
          return f;
        }
        f = this.value;
        f = parami.height * f / 100.0F;
        AppMethodBeat.o(201882);
        return f;
      }
      float f = a(parami);
      AppMethodBeat.o(201882);
      return f;
    }
    
    final float c(i parami)
    {
      AppMethodBeat.i(201887);
      if (this.aze == h.bd.aBA)
      {
        parami = parami.oC();
        if (parami == null)
        {
          f1 = this.value;
          AppMethodBeat.o(201887);
          return f1;
        }
        f1 = parami.width;
        float f2 = parami.height;
        if (f1 == f2)
        {
          f1 = this.value * f1 / 100.0F;
          AppMethodBeat.o(201887);
          return f1;
        }
        f1 = (float)(Math.sqrt(f2 * f2 + f1 * f1) / 1.414213562373095D) * this.value / 100.0F;
        AppMethodBeat.o(201887);
        return f1;
      }
      float f1 = a(parami);
      AppMethodBeat.o(201887);
      return f1;
    }
    
    final boolean or()
    {
      return this.value == 0.0F;
    }
    
    final boolean os()
    {
      return this.value < 0.0F;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201894);
      String str = String.valueOf(this.value) + this.aze;
      AppMethodBeat.o(201894);
      return str;
    }
  }
  
  static final class q
    extends h.l
  {
    h.p azf;
    h.p azg;
    h.p azh;
    h.p azi;
    
    final String om()
    {
      return "line";
    }
  }
  
  static final class r
    extends h.ar
    implements h.t
  {
    boolean azj;
    h.p azk;
    h.p azl;
    h.p azm;
    h.p azn;
    Float azo;
    
    final String om()
    {
      return "marker";
    }
  }
  
  static final class s
    extends h.ah
    implements h.t
  {
    h.p aza;
    h.p azb;
    h.p azc;
    h.p azd;
    Boolean azp;
    Boolean azq;
    
    final String om()
    {
      return "mask";
    }
  }
  
  static abstract interface t {}
  
  static final class u
    extends h.ao
  {
    String ayD;
    h.ao azr;
    
    u(String paramString, h.ao paramao)
    {
      this.ayD = paramString;
      this.azr = paramao;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201906);
      String str = this.ayD + " " + this.azr;
      AppMethodBeat.o(201906);
      return str;
    }
  }
  
  static final class v
    extends h.l
  {
    h.w azs;
    Float azt;
    
    final String om()
    {
      return "path";
    }
  }
  
  static final class w
    implements h.x
  {
    private byte[] azu;
    private int azv;
    private float[] azw;
    private int azx;
    
    w()
    {
      AppMethodBeat.i(201915);
      this.azv = 0;
      this.azx = 0;
      this.azu = new byte[8];
      this.azw = new float[16];
      AppMethodBeat.o(201915);
    }
    
    private void dG(int paramInt)
    {
      AppMethodBeat.i(201928);
      if (this.azw.length < this.azx + paramInt)
      {
        float[] arrayOfFloat = new float[this.azw.length * 2];
        System.arraycopy(this.azw, 0, arrayOfFloat, 0, this.azw.length);
        this.azw = arrayOfFloat;
      }
      AppMethodBeat.o(201928);
    }
    
    final void a(byte paramByte)
    {
      AppMethodBeat.i(201921);
      if (this.azv == this.azu.length)
      {
        arrayOfByte = new byte[this.azu.length * 2];
        System.arraycopy(this.azu, 0, arrayOfByte, 0, this.azu.length);
        this.azu = arrayOfByte;
      }
      byte[] arrayOfByte = this.azu;
      int i = this.azv;
      this.azv = (i + 1);
      arrayOfByte[i] = paramByte;
      AppMethodBeat.o(201921);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(201944);
      a((byte)2);
      dG(6);
      float[] arrayOfFloat = this.azw;
      int i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat5;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat6;
      AppMethodBeat.o(201944);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      int j = 0;
      AppMethodBeat.i(201957);
      if (paramBoolean1) {}
      for (int i = 2;; i = 0)
      {
        if (paramBoolean2) {
          j = 1;
        }
        a((byte)(j | i | 0x4));
        dG(5);
        float[] arrayOfFloat = this.azw;
        i = this.azx;
        this.azx = (i + 1);
        arrayOfFloat[i] = paramFloat1;
        arrayOfFloat = this.azw;
        i = this.azx;
        this.azx = (i + 1);
        arrayOfFloat[i] = paramFloat2;
        arrayOfFloat = this.azw;
        i = this.azx;
        this.azx = (i + 1);
        arrayOfFloat[i] = paramFloat3;
        arrayOfFloat = this.azw;
        i = this.azx;
        this.azx = (i + 1);
        arrayOfFloat[i] = paramFloat4;
        arrayOfFloat = this.azw;
        i = this.azx;
        this.azx = (i + 1);
        arrayOfFloat[i] = paramFloat5;
        AppMethodBeat.o(201957);
        return;
      }
    }
    
    final void a(h.x paramx)
    {
      AppMethodBeat.i(201966);
      int j = 0;
      int i = 0;
      if (j < this.azv)
      {
        int k = this.azu[j];
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
          float[] arrayOfFloat = this.azw;
          k = i + 1;
          float f1 = arrayOfFloat[i];
          arrayOfFloat = this.azw;
          i = k + 1;
          float f2 = arrayOfFloat[k];
          arrayOfFloat = this.azw;
          k = i + 1;
          float f3 = arrayOfFloat[i];
          arrayOfFloat = this.azw;
          i = k + 1;
          paramx.a(f1, f2, f3, bool1, bool2, arrayOfFloat[k], this.azw[i]);
          i += 1;
          for (;;)
          {
            j += 1;
            break;
            arrayOfFloat = this.azw;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.azw;
            i = k + 1;
            paramx.l(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.azw;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.azw;
            i = k + 1;
            paramx.m(f1, arrayOfFloat[k]);
            continue;
            arrayOfFloat = this.azw;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.azw;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.azw;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.azw;
            i = k + 1;
            float f4 = arrayOfFloat[k];
            arrayOfFloat = this.azw;
            k = i + 1;
            paramx.a(f1, f2, f3, f4, arrayOfFloat[i], this.azw[k]);
            i = k + 1;
            continue;
            arrayOfFloat = this.azw;
            k = i + 1;
            f1 = arrayOfFloat[i];
            arrayOfFloat = this.azw;
            i = k + 1;
            f2 = arrayOfFloat[k];
            arrayOfFloat = this.azw;
            k = i + 1;
            f3 = arrayOfFloat[i];
            arrayOfFloat = this.azw;
            i = k + 1;
            paramx.f(f1, f2, f3, arrayOfFloat[k]);
            continue;
            paramx.close();
          }
          bool1 = false;
          break label90;
        }
      }
      AppMethodBeat.o(201966);
    }
    
    public final void close()
    {
      AppMethodBeat.i(201959);
      a((byte)8);
      AppMethodBeat.o(201959);
    }
    
    public final void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(201949);
      a((byte)3);
      dG(4);
      float[] arrayOfFloat = this.azw;
      int i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat3;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat4;
      AppMethodBeat.o(201949);
    }
    
    final boolean isEmpty()
    {
      return this.azv == 0;
    }
    
    public final void l(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(201933);
      a((byte)0);
      dG(2);
      float[] arrayOfFloat = this.azw;
      int i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(201933);
    }
    
    public final void m(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(201937);
      a((byte)1);
      dG(2);
      float[] arrayOfFloat = this.azw;
      int i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat1;
      arrayOfFloat = this.azw;
      i = this.azx;
      this.azx = (i + 1);
      arrayOfFloat[i] = paramFloat2;
      AppMethodBeat.o(201937);
    }
  }
  
  static abstract interface x
  {
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
    
    public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5);
    
    public abstract void close();
    
    public abstract void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
    
    public abstract void l(float paramFloat1, float paramFloat2);
    
    public abstract void m(float paramFloat1, float paramFloat2);
  }
  
  static final class y
    extends h.ar
    implements h.t
  {
    String ayD;
    Matrix azA;
    h.p aza;
    h.p azb;
    h.p azc;
    h.p azd;
    Boolean azy;
    Boolean azz;
    
    final String om()
    {
      return "pattern";
    }
  }
  
  static class z
    extends h.l
  {
    float[] azB;
    
    String om()
    {
      return "polyline";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.a.a.h
 * JD-Core Version:    0.7.0.1
 */