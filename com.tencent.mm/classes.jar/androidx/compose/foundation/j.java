package androidx.compose.foundation;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.af;
import androidx.compose.ui.e.c.c;
import androidx.compose.ui.f;
import androidx.compose.ui.h.d.a;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final void a(af paramaf, final String paramString, final f paramf, final androidx.compose.ui.a parama, final androidx.compose.ui.h.d paramd, final float paramFloat, final aa paramaa, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(203547);
    s.u(paramaf, "bitmap");
    h localh = paramh.by(-816802257);
    if ((paramInt2 & 0x4) != 0) {
      paramf = (f)f.aud;
    }
    for (;;)
    {
      if ((paramInt2 & 0x8) != 0)
      {
        parama = androidx.compose.ui.a.atD;
        parama = androidx.compose.ui.a.a.rW();
      }
      for (int i = paramInt1 & 0xFFFFE3FF;; i = paramInt1)
      {
        if ((paramInt2 & 0x10) != 0)
        {
          paramd = androidx.compose.ui.h.d.aMF;
          paramd = d.a.wG();
          i &= 0xFFFF1FFF;
        }
        for (;;)
        {
          if ((paramInt2 & 0x20) != 0) {
            paramFloat = 1.0F;
          }
          for (;;)
          {
            if ((paramInt2 & 0x40) != 0) {
              paramaa = null;
            }
            for (;;)
            {
              localh.bx(-3686930);
              boolean bool = localh.G(paramaf);
              Object localObject = localh.or();
              if (!bool)
              {
                paramh = h.alD;
                paramh = localObject;
                if (localObject != h.a.ox()) {}
              }
              else
              {
                paramh = new androidx.compose.ui.e.c.a(paramaf);
                localh.F(paramh);
              }
              localh.od();
              a((c)paramh, paramString, paramf, parama, paramd, paramFloat, paramaa, localh, i & 0x70 | 0x8 | i & 0x380 | i & 0x1C00 | 0xE000 & i | 0x70000 & i | i & 0x380000, 0);
              paramh = localh.oh();
              if (paramh != null) {
                paramh.b((kotlin.g.a.m)new a(paramaf, paramString, paramf, parama, paramd, paramFloat, paramaa, paramInt1, paramInt2));
              }
              AppMethodBeat.o(203547);
              return;
            }
          }
        }
      }
    }
  }
  
  public static final void a(c paramc, final String paramString, final f paramf, final androidx.compose.ui.a parama, final androidx.compose.ui.h.d paramd, final float paramFloat, final aa paramaa, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(203563);
    s.u(paramc, "painter");
    h localh = paramh.by(-816797925);
    if ((paramInt2 & 0x4) != 0) {
      paramf = (f)f.aud;
    }
    for (;;)
    {
      if ((paramInt2 & 0x8) != 0)
      {
        parama = androidx.compose.ui.a.atD;
        parama = androidx.compose.ui.a.a.rW();
      }
      for (;;)
      {
        if ((paramInt2 & 0x10) != 0)
        {
          paramd = androidx.compose.ui.h.d.aMF;
          paramd = d.a.wG();
        }
        for (;;)
        {
          if ((paramInt2 & 0x20) != 0) {
            paramFloat = 1.0F;
          }
          for (;;)
          {
            if ((paramInt2 & 0x40) != 0) {
              paramaa = null;
            }
            for (;;)
            {
              Object localObject1;
              Object localObject2;
              label208:
              Object localObject3;
              Object localObject4;
              if (paramString != null)
              {
                localh.bx(-816797602);
                localObject1 = (f)f.aud;
                localh.bx(-3686930);
                boolean bool = localh.G(paramString);
                paramh = localh.or();
                if (!bool)
                {
                  localObject2 = h.alD;
                  if (paramh != h.a.ox()) {}
                }
                else
                {
                  paramh = (kotlin.g.a.b)new j.d(paramString);
                  localh.F(paramh);
                  localh.od();
                  paramh = androidx.compose.ui.k.n.a((f)localObject1, false, (kotlin.g.a.b)paramh);
                  localh.od();
                  localObject3 = androidx.compose.ui.b.m.a(androidx.compose.ui.b.d.h(paramf.a(paramh)), paramc, false, parama, paramd, paramFloat, paramaa, 2);
                  localObject2 = (androidx.compose.ui.h.p)b.YR;
                  localh.bx(1376089335);
                  localObject1 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
                  paramh = (androidx.compose.ui.n.n)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
                  localObject4 = androidx.compose.ui.i.a.aNC;
                  localObject4 = androidx.compose.ui.i.a.a.xb();
                  localObject3 = androidx.compose.ui.h.m.i((f)localObject3);
                  if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
                    g.nW();
                  }
                  localh.ol();
                  if (!localh.nY()) {
                    break label570;
                  }
                  localh.a((kotlin.g.a.a)localObject4);
                }
              }
              for (;;)
              {
                localh.op();
                s.u(localh, "composer");
                localObject4 = androidx.compose.ui.i.a.aNC;
                br.a(localh, localObject2, androidx.compose.ui.i.a.a.xe());
                localObject2 = androidx.compose.ui.i.a.aNC;
                br.a(localh, localObject1, androidx.compose.ui.i.a.a.xd());
                localObject1 = androidx.compose.ui.i.a.aNC;
                br.a(localh, paramh, androidx.compose.ui.i.a.a.xf());
                localh.oq();
                s.u(localh, "composer");
                ((kotlin.g.a.q)localObject3).invoke(bc.p(localh), localh, Integer.valueOf(0));
                localh.bx(2058660585);
                localh.bx(-820202187);
                localh.od();
                localh.od();
                localh.on();
                localh.od();
                paramh = localh.oh();
                if (paramh != null) {
                  paramh.b((kotlin.g.a.m)new c(paramc, paramString, paramf, parama, paramd, paramFloat, paramaa, paramInt1, paramInt2));
                }
                AppMethodBeat.o(203563);
                return;
                break;
                localh.bx(-816797458);
                localh.od();
                paramh = (f)f.aud;
                break label208;
                label570:
                localh.om();
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(af paramaf, String paramString, f paramf, androidx.compose.ui.a parama, androidx.compose.ui.h.d paramd, float paramFloat, aa paramaa, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements androidx.compose.ui.h.p
  {
    public static final b YR;
    
    static
    {
      AppMethodBeat.i(203502);
      YR = new b();
      AppMethodBeat.o(203502);
    }
    
    public final androidx.compose.ui.h.q a(r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(203507);
      s.u(paramr, "$this$Layout");
      s.u(paramList, "$noName_0");
      paramr = r.a.a(paramr, androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aV(paramLong), (kotlin.g.a.b)j.b.a.YS);
      AppMethodBeat.o(203507);
      return paramr;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    c(c paramc, String paramString, f paramf, androidx.compose.ui.a parama, androidx.compose.ui.h.d paramd, float paramFloat, aa paramaa, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.j
 * JD-Core Version:    0.7.0.1
 */