package androidx.compose.a;

import androidx.compose.a.a.aa;
import androidx.compose.ui.a;
import androidx.compose.ui.n.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/ChangeSize;", "", "alignment", "Landroidx/compose/ui/Alignment;", "size", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "clip", "", "(Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getClip", "()Z", "getSize", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  final a SF;
  final b<l, l> SG;
  final aa<l> SH;
  final boolean SI;
  
  public e(a parama, b<? super l, l> paramb, aa<l> paramaa)
  {
    AppMethodBeat.i(203043);
    this.SF = parama;
    this.SG = paramb;
    this.SH = paramaa;
    this.SI = true;
    AppMethodBeat.o(203043);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203073);
    if (this == paramObject)
    {
      AppMethodBeat.o(203073);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(203073);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.SF, paramObject.SF))
    {
      AppMethodBeat.o(203073);
      return false;
    }
    if (!s.p(this.SG, paramObject.SG))
    {
      AppMethodBeat.o(203073);
      return false;
    }
    if (!s.p(this.SH, paramObject.SH))
    {
      AppMethodBeat.o(203073);
      return false;
    }
    if (this.SI != paramObject.SI)
    {
      AppMethodBeat.o(203073);
      return false;
    }
    AppMethodBeat.o(203073);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203053);
    String str = "ChangeSize(alignment=" + this.SF + ", size=" + this.SG + ", animationSpec=" + this.SH + ", clip=" + this.SI + ')';
    AppMethodBeat.o(203053);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.e
 * JD-Core Version:    0.7.0.1
 */