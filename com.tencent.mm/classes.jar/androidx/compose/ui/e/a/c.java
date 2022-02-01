package androidx.compose.ui.e.a;

import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "name", "", "model", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "id", "", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "componentCount", "getComponentCount", "()I", "getId$ui_graphics_release", "isSrgb", "", "()Z", "isWideGamut", "getModel-xdoWZVw", "()J", "J", "getName", "()Ljava/lang/String;", "equals", "other", "fromXyz", "", "x", "", "y", "z", "v", "getMaxValue", "component", "getMinValue", "hashCode", "toString", "toXyz", "r", "g", "b", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
{
  public static final c.a ayO = new c.a((byte)0);
  public final long ayP;
  public final int id;
  public final String name;
  
  private c(String paramString, long paramLong, int paramInt)
  {
    this.name = paramString;
    this.ayP = paramLong;
    this.id = paramInt;
    if (((CharSequence)this.name).length() == 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0) {
      throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
    }
    if ((this.id < -1) || (this.id > 63)) {
      throw new IllegalArgumentException("The id must be between -1 and 63");
    }
  }
  
  public abstract float cM(int paramInt);
  
  public abstract float cN(int paramInt);
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (!s.p(ai.cz(getClass()), ai.cz(paramObject.getClass())));
        paramObject = (c)paramObject;
        bool1 = bool2;
      } while (this.id != paramObject.id);
      bool1 = bool2;
    } while (!s.p(this.name, paramObject.name));
    return b.e(this.ayP, paramObject.ayP);
  }
  
  public abstract float[] f(float[] paramArrayOfFloat);
  
  public abstract float[] g(float[] paramArrayOfFloat);
  
  public int hashCode()
  {
    return (this.name.hashCode() * 31 + b.I(this.ayP)) * 31 + this.id;
  }
  
  public String toString()
  {
    return this.name + " (id=" + this.id + ", model=" + b.H(this.ayP) + ')';
  }
  
  public boolean uc()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.c
 * JD-Core Version:    0.7.0.1
 */