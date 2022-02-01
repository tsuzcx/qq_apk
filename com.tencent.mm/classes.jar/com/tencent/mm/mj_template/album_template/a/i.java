package com.tencent.mm.mj_template.album_template.a;

import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.h.ae;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.h.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"WaveAnimation", "", "waveColor", "Landroidx/compose/ui/graphics/Color;", "animating", "", "modifier", "Landroidx/compose/ui/Modifier;", "waveNum", "", "WaveAnimation-euL9pac", "(JZLandroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final void a(final long paramLong, final boolean paramBoolean, final f paramf, final int paramInt1, h paramh, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(240577);
    s.u(paramf, "modifier");
    h localh = paramh.by(-2016891181);
    int i;
    if ((paramInt3 & 0x1) != 0) {
      i = 6;
    }
    label51:
    label58:
    label70:
    label77:
    label90:
    int m;
    label665:
    label668:
    label675:
    for (int j = paramInt2 | i;; m = paramInt2)
    {
      if ((paramInt3 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt3 & 0x4) == 0) {
          break label447;
        }
        j = 384;
        j = i | j;
        if ((paramInt3 & 0x8) == 0) {
          break label487;
        }
        i = 3072;
      }
      for (i = j | i;; i = m)
      {
        if (((i & 0x16DB ^ 0x492) != 0) || (!localh.nZ()))
        {
          if ((paramInt3 & 0x8) == 0) {
            break label665;
          }
          paramInt1 = 20;
        }
        for (;;)
        {
          localh.bx(-3687241);
          Object localObject = localh.or();
          paramh = h.alD;
          paramh = localObject;
          if (localObject == h.a.ox())
          {
            paramh = bj.T(Integer.valueOf(0));
            localh.F(paramh);
          }
          localh.od();
          final an localan = (an)paramh;
          localh.bx(-3686930);
          boolean bool = localh.G(localan);
          localObject = localh.or();
          if (!bool)
          {
            paramh = h.alD;
            paramh = localObject;
            if (localObject != h.a.ox()) {}
          }
          else
          {
            paramh = (m)new a(localan, null);
            localh.F(paramh);
          }
          localh.od();
          aa.a(Boolean.valueOf(paramBoolean), (m)paramh, localh);
          paramh = z.ad(paramLong);
          localh.bx(-3685570);
          int n = 0;
          j = 0;
          for (;;)
          {
            if (n < 4)
            {
              localObject = new Object[] { Integer.valueOf(paramInt1), localan, Boolean.valueOf(paramBoolean), paramh }[n];
              n += 1;
              int k = localh.G(localObject) | j;
              continue;
              if ((paramInt2 & 0xE) != 0) {
                break label675;
              }
              if (localh.y(paramLong))
              {
                i = 4;
                break;
              }
              i = 2;
              break;
              i = k;
              if ((paramInt2 & 0x70) != 0) {
                break label58;
              }
              if (localh.am(paramBoolean))
              {
                i = 32;
                break label51;
              }
              i = 16;
              break label51;
              label447:
              m = i;
              if ((paramInt2 & 0x380) != 0) {
                break label77;
              }
              if (localh.G(paramf))
              {
                m = 256;
                break label70;
              }
              m = 128;
              break label70;
              label487:
              if ((paramInt2 & 0x1C00) != 0) {
                break label668;
              }
              if (localh.bz(paramInt1))
              {
                i = 2048;
                break label90;
              }
              i = 1024;
              break label90;
            }
          }
          localObject = localh.or();
          if (m == 0)
          {
            paramh = h.alD;
            paramh = localObject;
            if (localObject != h.a.ox()) {}
          }
          else
          {
            paramh = (m)new b(paramInt1, localan, paramBoolean, paramLong);
            localh.F(paramh);
          }
          localh.od();
          ae.a(paramf, (m)paramh, localh, i >> 6 & 0xE, 0);
          for (;;)
          {
            paramh = localh.oh();
            if (paramh != null) {
              paramh.b((m)new c(paramLong, paramBoolean, paramf, paramInt1, paramInt2, paramInt3));
            }
            AppMethodBeat.o(240577);
            return;
            localh.oi();
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(an<Integer> paraman, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(240620);
      paramObject = (d)new a(this.nZe, paramd);
      AppMethodBeat.o(240620);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240612);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240612);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        int i = i.f(this.nZe);
        this.nZe.setValue(Integer.valueOf(i + 1));
        paramObject = (d)this;
        this.label = 1;
        if (bb.e(100L, paramObject) == locala)
        {
          AppMethodBeat.o(240612);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<ag, androidx.compose.ui.n.b, q>
  {
    b(int paramInt, an<Integer> paraman, boolean paramBoolean, long paramLong)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<h, Integer, ah>
    {
      a(an<Integer> paraman, int paramInt, boolean paramBoolean, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3)
      {
        super();
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.b<e, ah>
      {
        a(int paramInt, boolean paramBoolean, float paramFloat1, float paramFloat2, long paramLong, float paramFloat3, float paramFloat4, an<Integer> paraman)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<h, Integer, ah>
  {
    c(long paramLong, boolean paramBoolean, f paramf, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.i
 * JD-Core Version:    0.7.0.1
 */