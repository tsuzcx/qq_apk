package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/FpsInfo;", "", "()V", "fps", "", "exceedFps", "jank", "", "bigJank", "stutter", "jank_frame_time", "total_frame_time", "(FFIIFII)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public float eGA = 0.0F;
  public int eGB = 0;
  public int eGC = 0;
  public float eGw = 0.0F;
  public float eGx = 0.0F;
  public int eGy = 0;
  public int eGz = 0;
  
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
        if ((Float.compare(this.eGw, paramObject.eGw) != 0) || (Float.compare(this.eGx, paramObject.eGx) != 0) || (this.eGy != paramObject.eGy) || (this.eGz != paramObject.eGz) || (Float.compare(this.eGA, paramObject.eGA) != 0) || (this.eGB != paramObject.eGB) || (this.eGC != paramObject.eGC)) {}
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
    int i = Float.floatToIntBits(this.eGw);
    int j = Float.floatToIntBits(this.eGx);
    int k = this.eGy;
    int m = this.eGz;
    int n = Float.floatToIntBits(this.eGA);
    int i1 = this.eGB;
    int i2 = this.eGC;
    AppMethodBeat.o(140078);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140077);
    Object localObject = Locale.ENGLISH;
    s.r(localObject, "Locale.ENGLISH");
    localObject = String.format((Locale)localObject, "fps(%.2f, %.2f, %d, %d, %.2f%%)", Arrays.copyOf(new Object[] { Float.valueOf(this.eGw), Float.valueOf(this.eGx), Integer.valueOf(this.eGy), Integer.valueOf(this.eGz), Float.valueOf(this.eGA * 100.0F) }, 5));
    s.r(localObject, "java.lang.String.format(locale, this, *args)");
    AppMethodBeat.o(140077);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.a
 * JD-Core Version:    0.7.0.1
 */