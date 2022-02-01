package coil.d;

import android.os.SystemClock;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.ui.d.k.a;
import androidx.compose.ui.d.l;
import androidx.compose.ui.e.aa;
import androidx.compose.ui.e.b.g;
import androidx.compose.ui.e.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/compose/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "scale", "Lcoil/size/Scale;", "durationMillis", "", "fadeStart", "", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lcoil/size/Scale;IZ)V", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "isDone", "", "maxAlpha", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha$delegate", "startTimeMillis", "", "applyAlpha", "alpha", "applyColorFilter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "painter", "onDraw", "coil-compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  extends c
{
  private final int WN;
  private final an ajX;
  private c cmg;
  private final c cmh;
  private final coil.size.e cmi;
  private final boolean cmj;
  private long cmk;
  private boolean cml;
  private final an cmm;
  private final an cmn;
  
  public a(c paramc1, c paramc2, coil.size.e parame, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(188011);
    this.cmg = paramc1;
    this.cmh = paramc2;
    this.cmi = parame;
    this.WN = paramInt;
    this.cmj = paramBoolean;
    this.ajX = bj.T(Integer.valueOf(0));
    this.cmk = -1L;
    this.cmm = bj.T(Float.valueOf(1.0F));
    this.cmn = bj.T(null);
    AppMethodBeat.o(188011);
  }
  
  private final float MK()
  {
    AppMethodBeat.i(188024);
    float f = ((Number)((bm)this.cmm).getValue()).floatValue();
    AppMethodBeat.o(188024);
    return f;
  }
  
  private final void a(androidx.compose.ui.e.b.e parame, c paramc, float paramFloat)
  {
    AppMethodBeat.i(188045);
    if ((paramc == null) || (paramFloat <= 0.0F))
    {
      AppMethodBeat.o(188045);
      return;
    }
    long l1 = parame.sf();
    long l2 = w(paramc.uM(), l1);
    k.a locala = androidx.compose.ui.d.k.avA;
    if (l1 == androidx.compose.ui.d.k.sw()) {}
    for (int i = 1; (i != 0) || (androidx.compose.ui.d.k.S(l1)); i = 0)
    {
      paramc.a(parame, l2, paramFloat, sL());
      AppMethodBeat.o(188045);
      return;
    }
    float f1 = (androidx.compose.ui.d.k.Q(l1) - androidx.compose.ui.d.k.Q(l2)) / 2.0F;
    float f2 = (androidx.compose.ui.d.k.R(l1) - androidx.compose.ui.d.k.R(l2)) / 2.0F;
    parame.uG().uI().d(f1, f2, f1, f2);
    paramc.a(parame, l2, paramFloat, sL());
    parame.uG().uI().d(-f1, -f2, -f1, -f2);
    AppMethodBeat.o(188045);
  }
  
  private final aa sL()
  {
    AppMethodBeat.i(188032);
    aa localaa = (aa)((bm)this.cmn).getValue();
    AppMethodBeat.o(188032);
    return localaa;
  }
  
  private final long w(long paramLong1, long paramLong2)
  {
    int j = 1;
    AppMethodBeat.i(188053);
    k.a locala = androidx.compose.ui.d.k.avA;
    if (paramLong1 == androidx.compose.ui.d.k.sw()) {}
    for (int i = 1; (i != 0) || (androidx.compose.ui.d.k.S(paramLong1)); i = 0)
    {
      AppMethodBeat.o(188053);
      return paramLong2;
    }
    locala = androidx.compose.ui.d.k.avA;
    if (paramLong2 == androidx.compose.ui.d.k.sw()) {}
    for (i = j; (i != 0) || (androidx.compose.ui.d.k.S(paramLong2)); i = 0)
    {
      AppMethodBeat.o(188053);
      return paramLong2;
    }
    float f1 = androidx.compose.ui.d.k.Q(paramLong1);
    float f2 = androidx.compose.ui.d.k.R(paramLong1);
    float f3 = coil.e.d.a(f1, f2, androidx.compose.ui.d.k.Q(paramLong2), androidx.compose.ui.d.k.R(paramLong2), this.cmi);
    paramLong1 = l.z(f1 * f3, f2 * f3);
    AppMethodBeat.o(188053);
    return paramLong1;
  }
  
  public final boolean S(float paramFloat)
  {
    AppMethodBeat.i(188077);
    this.cmm.setValue(Float.valueOf(paramFloat));
    AppMethodBeat.o(188077);
    return true;
  }
  
  public final void b(androidx.compose.ui.e.b.e parame)
  {
    AppMethodBeat.i(188069);
    s.u(parame, "<this>");
    if (this.cml)
    {
      a(parame, this.cmh, MK());
      AppMethodBeat.o(188069);
      return;
    }
    long l = SystemClock.uptimeMillis();
    if (this.cmk == -1L) {
      this.cmk = l;
    }
    float f2 = (float)(l - this.cmk) / this.WN;
    float f3 = kotlin.k.k.C(f2, 0.0F, 1.0F) * MK();
    float f1;
    if (this.cmj)
    {
      f1 = MK() - f3;
      if (f2 < 1.0D) {
        break label165;
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      this.cml = bool;
      a(parame, this.cmg, f1);
      a(parame, this.cmh, f3);
      if (!this.cml) {
        break label171;
      }
      this.cmg = null;
      AppMethodBeat.o(188069);
      return;
      f1 = MK();
      break;
    }
    label171:
    int i = ((Number)((bm)this.ajX).getValue()).intValue();
    this.ajX.setValue(Integer.valueOf(i + 1));
    AppMethodBeat.o(188069);
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(188083);
    this.cmn.setValue(paramaa);
    AppMethodBeat.o(188083);
    return true;
  }
  
  public final long uM()
  {
    Object localObject2 = null;
    int j = 1;
    AppMethodBeat.i(188059);
    Object localObject1 = this.cmg;
    label39:
    label54:
    long l2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label157;
      }
      localObject1 = androidx.compose.ui.d.k.avA;
      l1 = androidx.compose.ui.d.k.su();
      localObject1 = this.cmh;
      if (localObject1 != null) {
        break label166;
      }
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label179;
      }
      localObject1 = androidx.compose.ui.d.k.avA;
      l2 = androidx.compose.ui.d.k.su();
      label69:
      localObject1 = androidx.compose.ui.d.k.avA;
      if (l1 == androidx.compose.ui.d.k.sw()) {
        break label189;
      }
      i = 1;
      label84:
      if (i == 0) {
        break label199;
      }
      localObject1 = androidx.compose.ui.d.k.avA;
      if (l2 == androidx.compose.ui.d.k.sw()) {
        break label194;
      }
    }
    label157:
    label166:
    label179:
    label189:
    label194:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label199;
      }
      l1 = l.z(Math.max(androidx.compose.ui.d.k.Q(l1), androidx.compose.ui.d.k.Q(l2)), Math.max(androidx.compose.ui.d.k.R(l1), androidx.compose.ui.d.k.R(l2)));
      AppMethodBeat.o(188059);
      return l1;
      localObject1 = androidx.compose.ui.d.k.U(((c)localObject1).uM());
      break;
      l1 = ((androidx.compose.ui.d.k)localObject1).avp;
      break label39;
      localObject1 = androidx.compose.ui.d.k.U(((c)localObject1).uM());
      break label54;
      l2 = ((androidx.compose.ui.d.k)localObject1).avp;
      break label69;
      i = 0;
      break label84;
    }
    label199:
    localObject1 = androidx.compose.ui.d.k.avA;
    long l1 = androidx.compose.ui.d.k.sw();
    AppMethodBeat.o(188059);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.d.a
 * JD-Core Version:    0.7.0.1
 */