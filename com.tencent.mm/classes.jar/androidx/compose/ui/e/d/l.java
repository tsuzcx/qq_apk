package androidx.compose.ui.e.d;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.br;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h;
import androidx.compose.ui.e.aq;
import androidx.compose.ui.e.bb;
import androidx.compose.ui.e.bc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final void a(String paramString, final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4, final float paramFloat5, final float paramFloat6, final float paramFloat7, final List<? extends f> paramList, final m<? super h, ? super Integer, ah> paramm, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(206405);
    kotlin.g.b.s.u(paramm, "content");
    paramh = paramh.by(383574212);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label52:
    label59:
    label71:
    label970:
    label1100:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      label78:
      label91:
      label98:
      label111:
      label118:
      int k;
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label767;
        }
        j = 384;
        j = i | j;
        if ((paramInt2 & 0x8) == 0) {
          break label807;
        }
        i = 3072;
        i = j | i;
        if ((paramInt2 & 0x10) == 0) {
          break label847;
        }
        j = 24576;
        j = i | j;
        if ((paramInt2 & 0x20) == 0) {
          break label888;
        }
        i = 196608;
        i = j | i;
        if ((paramInt2 & 0x40) == 0) {
          break label929;
        }
        j = 1572864;
        j = i | j;
        if ((paramInt2 & 0x80) == 0) {
          break label970;
        }
        i = 12582912;
        k = j | i;
        i = k;
        if ((paramInt2 & 0x100) != 0) {
          i = k | 0x2000000;
        }
        if ((paramInt2 & 0x200) == 0) {
          break label1011;
        }
        j = 805306368;
        label209:
        i = j | i;
      }
      for (;;)
      {
        if ((((paramInt2 ^ 0xFFFFFFFF) & 0x100) != 0) || ((0x5B6DB6DB & i ^ 0x12492492) != 0) || (!paramh.nZ())) {
          if (((paramInt1 & 0x1) == 0) || (paramh.oa()))
          {
            paramh.of();
            if ((paramInt2 & 0x1) != 0) {
              paramString = "";
            }
            if ((paramInt2 & 0x2) != 0) {
              paramFloat1 = 0.0F;
            }
            if ((paramInt2 & 0x4) != 0) {
              paramFloat2 = 0.0F;
            }
            if ((paramInt2 & 0x8) != 0) {
              paramFloat3 = 0.0F;
            }
            if ((paramInt2 & 0x10) != 0) {
              paramFloat4 = 1.0F;
            }
            if ((paramInt2 & 0x20) != 0) {
              paramFloat5 = 1.0F;
            }
            if ((paramInt2 & 0x40) != 0) {
              paramFloat6 = 0.0F;
            }
            if ((paramInt2 & 0x80) != 0) {
              paramFloat7 = 0.0F;
            }
            j = i;
            if ((paramInt2 & 0x100) != 0)
            {
              paramList = n.uX();
              j = i & 0xF1FFFFFF;
            }
            paramh.og();
            i = j;
          }
        }
        for (;;)
        {
          a locala = (a)a.aCn;
          paramh.bx(-2103248778);
          if (!(paramh.nX() instanceof j)) {
            g.nW();
          }
          paramh.ok();
          if (paramh.nY())
          {
            paramh.a(locala);
            kotlin.g.b.s.u(paramh, "composer");
            br.a(paramh, paramString, (m)b.aCo);
            br.a(paramh, Float.valueOf(paramFloat1), (m)c.aCp);
            br.a(paramh, Float.valueOf(paramFloat2), (m)d.aCq);
            br.a(paramh, Float.valueOf(paramFloat3), (m)e.aCr);
            br.a(paramh, Float.valueOf(paramFloat4), (m)f.aCs);
            br.a(paramh, Float.valueOf(paramFloat5), (m)g.aCt);
            br.a(paramh, Float.valueOf(paramFloat6), (m)h.aCu);
            br.a(paramh, Float.valueOf(paramFloat7), (m)i.aCv);
            br.a(paramh, paramList, (m)j.aCw);
            paramh.bx(-1894407238);
            paramm.invoke(paramh, Integer.valueOf(i >> 27 & 0xE));
            paramh.od();
            paramh.on();
            paramh.od();
          }
          for (;;)
          {
            paramh = paramh.oh();
            if (paramh != null) {
              paramh.b((m)new k(paramString, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramList, paramm, paramInt1, paramInt2));
            }
            AppMethodBeat.o(206405);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label1100;
            }
            if (paramh.G(paramString))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            i = j;
            if ((paramInt1 & 0x70) != 0) {
              break label59;
            }
            if (paramh.H(paramFloat1))
            {
              i = 32;
              break label52;
            }
            i = 16;
            break label52;
            label767:
            j = i;
            if ((paramInt1 & 0x380) != 0) {
              break label78;
            }
            if (paramh.H(paramFloat2))
            {
              j = 256;
              break label71;
            }
            j = 128;
            break label71;
            i = j;
            if ((paramInt1 & 0x1C00) != 0) {
              break label98;
            }
            if (paramh.H(paramFloat3))
            {
              i = 2048;
              break label91;
            }
            i = 1024;
            break label91;
            label847:
            j = i;
            if ((0xE000 & paramInt1) != 0) {
              break label118;
            }
            if (paramh.H(paramFloat4))
            {
              j = 16384;
              break label111;
            }
            j = 8192;
            break label111;
            label888:
            i = j;
            if ((0x70000 & paramInt1) != 0) {
              break label137;
            }
            if (paramh.H(paramFloat5))
            {
              i = 131072;
              break label130;
            }
            i = 65536;
            break label130;
            j = i;
            if ((0x380000 & paramInt1) != 0) {
              break label156;
            }
            if (paramh.H(paramFloat6))
            {
              j = 1048576;
              break label149;
            }
            j = 524288;
            break label149;
            k = j;
            if ((0x1C00000 & paramInt1) != 0) {
              break label176;
            }
            if (paramh.H(paramFloat7))
            {
              i = 8388608;
              break label169;
            }
            i = 4194304;
            break label169;
            label1011:
            if ((0x70000000 & paramInt1) != 0) {
              break label1097;
            }
            if (paramh.G(paramm))
            {
              j = 536870912;
              break label209;
            }
            j = 268435456;
            break label209;
            paramh.oj();
            if ((paramInt2 & 0x100) == 0) {
              break label1094;
            }
            i &= 0xF1FFFFFF;
            break label391;
            paramh.om();
            break label450;
            paramh.oi();
          }
        }
      }
    }
  }
  
  public static final void a(List<? extends f> paramList, final int paramInt1, final String paramString, final androidx.compose.ui.e.s params1, final float paramFloat1, final androidx.compose.ui.e.s params2, final float paramFloat2, final float paramFloat3, final int paramInt2, final int paramInt3, final float paramFloat4, final float paramFloat5, final float paramFloat6, final float paramFloat7, h paramh, final int paramInt4, final int paramInt5, final int paramInt6)
  {
    AppMethodBeat.i(206421);
    kotlin.g.b.s.u(paramList, "pathData");
    paramh = paramh.by(435826864);
    if ((paramInt6 & 0x2) != 0) {
      paramInt1 = n.va();
    }
    for (;;)
    {
      if ((paramInt6 & 0x4) != 0) {
        paramString = "";
      }
      for (;;)
      {
        if ((paramInt6 & 0x8) != 0) {
          params1 = null;
        }
        for (;;)
        {
          if ((paramInt6 & 0x10) != 0) {
            paramFloat1 = 1.0F;
          }
          for (;;)
          {
            if ((paramInt6 & 0x20) != 0) {
              params2 = null;
            }
            for (;;)
            {
              if ((paramInt6 & 0x40) != 0) {
                paramFloat2 = 1.0F;
              }
              for (;;)
              {
                if ((paramInt6 & 0x80) != 0) {
                  paramFloat3 = 0.0F;
                }
                for (;;)
                {
                  if ((paramInt6 & 0x100) != 0) {
                    paramInt2 = n.uY();
                  }
                  for (;;)
                  {
                    if ((paramInt6 & 0x200) != 0) {
                      paramInt3 = n.uZ();
                    }
                    for (;;)
                    {
                      if ((paramInt6 & 0x400) != 0) {
                        paramFloat4 = 4.0F;
                      }
                      for (;;)
                      {
                        if ((paramInt6 & 0x800) != 0) {
                          paramFloat5 = 0.0F;
                        }
                        for (;;)
                        {
                          if ((paramInt6 & 0x1000) != 0) {
                            paramFloat6 = 1.0F;
                          }
                          for (;;)
                          {
                            if ((paramInt6 & 0x2000) != 0) {
                              paramFloat7 = 0.0F;
                            }
                            for (;;)
                            {
                              a locala = (a)l.aCG;
                              paramh.bx(-2103251527);
                              if (!(paramh.nX() instanceof j)) {
                                g.nW();
                              }
                              paramh.ok();
                              if (paramh.nY()) {
                                paramh.a((a)new l.ab(locala));
                              }
                              for (;;)
                              {
                                kotlin.g.b.s.u(paramh, "composer");
                                br.a(paramh, paramString, (m)m.aCH);
                                br.a(paramh, paramList, (m)s.aCN);
                                br.a(paramh, aq.cI(paramInt1), (m)t.aCO);
                                br.a(paramh, params1, (m)u.aCP);
                                br.a(paramh, Float.valueOf(paramFloat1), (m)v.aCQ);
                                br.a(paramh, params2, (m)w.aCR);
                                br.a(paramh, Float.valueOf(paramFloat2), (m)x.aCS);
                                br.a(paramh, Float.valueOf(paramFloat3), (m)y.aCT);
                                br.a(paramh, bc.cL(paramInt3), (m)z.aCU);
                                br.a(paramh, bb.cK(paramInt2), (m)n.aCI);
                                br.a(paramh, Float.valueOf(paramFloat4), (m)o.aCJ);
                                br.a(paramh, Float.valueOf(paramFloat5), (m)p.aCK);
                                br.a(paramh, Float.valueOf(paramFloat6), (m)q.aCL);
                                br.a(paramh, Float.valueOf(paramFloat7), (m)r.aCM);
                                paramh.on();
                                paramh.od();
                                paramh = paramh.oh();
                                if (paramh != null) {
                                  paramh.b((m)new aa(paramList, paramInt1, paramString, params1, paramFloat1, params2, paramFloat2, paramFloat3, paramInt2, paramInt3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramInt4, paramInt5, paramInt6));
                                }
                                AppMethodBeat.o(206421);
                                return;
                                paramh.om();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<c>
  {
    public static final a aCn;
    
    static
    {
      AppMethodBeat.i(206460);
      aCn = new a();
      AppMethodBeat.o(206460);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends u
    implements m<h, Integer, ah>
  {
    aa(List<? extends f> paramList, int paramInt1, String paramString, androidx.compose.ui.e.s params1, float paramFloat1, androidx.compose.ui.e.s params2, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, int paramInt4, int paramInt5, int paramInt6)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<c, String, ah>
  {
    public static final b aCo;
    
    static
    {
      AppMethodBeat.i(206475);
      aCo = new b();
      AppMethodBeat.o(206475);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<c, Float, ah>
  {
    public static final c aCp;
    
    static
    {
      AppMethodBeat.i(206473);
      aCp = new c();
      AppMethodBeat.o(206473);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<c, Float, ah>
  {
    public static final d aCq;
    
    static
    {
      AppMethodBeat.i(206467);
      aCq = new d();
      AppMethodBeat.o(206467);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<c, Float, ah>
  {
    public static final e aCr;
    
    static
    {
      AppMethodBeat.i(206469);
      aCr = new e();
      AppMethodBeat.o(206469);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<c, Float, ah>
  {
    public static final f aCs;
    
    static
    {
      AppMethodBeat.i(206466);
      aCs = new f();
      AppMethodBeat.o(206466);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements m<c, Float, ah>
  {
    public static final g aCt;
    
    static
    {
      AppMethodBeat.i(206465);
      aCt = new g();
      AppMethodBeat.o(206465);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<c, Float, ah>
  {
    public static final h aCu;
    
    static
    {
      AppMethodBeat.i(206471);
      aCu = new h();
      AppMethodBeat.o(206471);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements m<c, Float, ah>
  {
    public static final i aCv;
    
    static
    {
      AppMethodBeat.i(206476);
      aCv = new i();
      AppMethodBeat.o(206476);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements m<c, List<? extends f>, ah>
  {
    public static final j aCw;
    
    static
    {
      AppMethodBeat.i(206470);
      aCw = new j();
      AppMethodBeat.o(206470);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements m<h, Integer, ah>
  {
    k(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, List<? extends f> paramList, m<? super h, ? super Integer, ah> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements a<e>
  {
    public static final l aCG;
    
    static
    {
      AppMethodBeat.i(206498);
      aCG = new l();
      AppMethodBeat.o(206498);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements m<e, String, ah>
  {
    public static final m aCH;
    
    static
    {
      AppMethodBeat.i(206499);
      aCH = new m();
      AppMethodBeat.o(206499);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements m<e, bb, ah>
  {
    public static final n aCI;
    
    static
    {
      AppMethodBeat.i(206488);
      aCI = new n();
      AppMethodBeat.o(206488);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements m<e, Float, ah>
  {
    public static final o aCJ;
    
    static
    {
      AppMethodBeat.i(206495);
      aCJ = new o();
      AppMethodBeat.o(206495);
    }
    
    o()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements m<e, Float, ah>
  {
    public static final p aCK;
    
    static
    {
      AppMethodBeat.i(206516);
      aCK = new p();
      AppMethodBeat.o(206516);
    }
    
    p()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements m<e, Float, ah>
  {
    public static final q aCL;
    
    static
    {
      AppMethodBeat.i(206517);
      aCL = new q();
      AppMethodBeat.o(206517);
    }
    
    q()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements m<e, Float, ah>
  {
    public static final r aCM;
    
    static
    {
      AppMethodBeat.i(206501);
      aCM = new r();
      AppMethodBeat.o(206501);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements m<e, List<? extends f>, ah>
  {
    public static final s aCN;
    
    static
    {
      AppMethodBeat.i(206507);
      aCN = new s();
      AppMethodBeat.o(206507);
    }
    
    s()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements m<e, aq, ah>
  {
    public static final t aCO;
    
    static
    {
      AppMethodBeat.i(206502);
      aCO = new t();
      AppMethodBeat.o(206502);
    }
    
    t()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements m<e, androidx.compose.ui.e.s, ah>
  {
    public static final u aCP;
    
    static
    {
      AppMethodBeat.i(206514);
      aCP = new u();
      AppMethodBeat.o(206514);
    }
    
    u()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements m<e, Float, ah>
  {
    public static final v aCQ;
    
    static
    {
      AppMethodBeat.i(206523);
      aCQ = new v();
      AppMethodBeat.o(206523);
    }
    
    v()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements m<e, androidx.compose.ui.e.s, ah>
  {
    public static final w aCR;
    
    static
    {
      AppMethodBeat.i(206511);
      aCR = new w();
      AppMethodBeat.o(206511);
    }
    
    w()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements m<e, Float, ah>
  {
    public static final x aCS;
    
    static
    {
      AppMethodBeat.i(206515);
      aCS = new x();
      AppMethodBeat.o(206515);
    }
    
    x()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements m<e, Float, ah>
  {
    public static final y aCT;
    
    static
    {
      AppMethodBeat.i(206441);
      aCT = new y();
      AppMethodBeat.o(206441);
    }
    
    y()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements m<e, bc, ah>
  {
    public static final z aCU;
    
    static
    {
      AppMethodBeat.i(206448);
      aCU = new z();
      AppMethodBeat.o(206448);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.l
 * JD-Core Version:    0.7.0.1
 */