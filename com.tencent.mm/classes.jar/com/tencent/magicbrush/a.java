package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/magicbrush/FpsInfo;", "", "()V", "fps", "", "exceedFps", "jank", "", "bigJank", "stutter", "jank_frame_time", "total_frame_time", "(FFIIFII)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-magicbrush-nano_release"})
public final class a
{
  public float cLa = 0.0F;
  public float cLb = 0.0F;
  public int cLc = 0;
  public int cLd = 0;
  public float cLe = 0.0F;
  public int cLf = 0;
  public int cLg = 0;
  
  private a() {}
  
  public a(byte paramByte)
  {
    this();
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(140079);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.cLa, paramObject.cLa) != 0) || (Float.compare(this.cLb, paramObject.cLb) != 0) || (this.cLc != paramObject.cLc) || (this.cLd != paramObject.cLd) || (Float.compare(this.cLe, paramObject.cLe) != 0) || (this.cLf != paramObject.cLf) || (this.cLg != paramObject.cLg)) {}
      }
    }
    else
    {
      AppMethodBeat.o(140079);
      return true;
    }
    AppMethodBeat.o(140079);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(140078);
    int i = Float.floatToIntBits(this.cLa);
    int j = Float.floatToIntBits(this.cLb);
    int k = this.cLc;
    int m = this.cLd;
    int n = Float.floatToIntBits(this.cLe);
    int i1 = this.cLf;
    int i2 = this.cLg;
    AppMethodBeat.o(140078);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140077);
    Object localObject = Locale.ENGLISH;
    p.j(localObject, "Locale.ENGLISH");
    localObject = String.format((Locale)localObject, "fps(%.2f, %.2f, %d, %d, %.2f%%)", Arrays.copyOf(new Object[] { Float.valueOf(this.cLa), Float.valueOf(this.cLb), Integer.valueOf(this.cLc), Integer.valueOf(this.cLd), Float.valueOf(this.cLe * 100.0F) }, 5));
    p.j(localObject, "java.lang.String.format(locale, this, *args)");
    AppMethodBeat.o(140077);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.a
 * JD-Core Version:    0.7.0.1
 */