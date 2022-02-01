package com.tencent.magicbrush;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.Locale;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/FpsInfo;", "", "()V", "fps", "", "exceedFps", "(FF)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class a
{
  public float cvL = 0.0F;
  public float cvM = 0.0F;
  
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
        if ((Float.compare(this.cvL, paramObject.cvL) != 0) || (Float.compare(this.cvM, paramObject.cvM) != 0)) {}
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
    int i = Float.floatToIntBits(this.cvL);
    int j = Float.floatToIntBits(this.cvM);
    AppMethodBeat.o(140078);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140077);
    Object localObject = Locale.ENGLISH;
    p.g(localObject, "Locale.ENGLISH");
    localObject = String.format((Locale)localObject, "fps(%.2f, %.2f)", Arrays.copyOf(new Object[] { Float.valueOf(this.cvL), Float.valueOf(this.cvM) }, 2));
    p.g(localObject, "java.lang.String.format(locale, this, *args)");
    AppMethodBeat.o(140077);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.a
 * JD-Core Version:    0.7.0.1
 */