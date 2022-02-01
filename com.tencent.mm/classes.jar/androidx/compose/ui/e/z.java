package androidx.compose.ui.e;

import androidx.compose.ui.e.a.c;
import androidx.compose.ui.e.a.d;
import androidx.compose.ui.e.a.e;
import androidx.compose.ui.e.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.aj;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "alpha", "", "getAlpha$annotations", "()V", "getAlpha-impl", "(J)F", "blue", "getBlue$annotations", "getBlue-impl", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "green", "getGreen$annotations", "getGreen-impl", "red", "getRed$annotations", "getRed-impl", "getValue-s-VKNKU", "()J", "J", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "copy", "copy-wmQWz5c", "(JFFFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  private static final long avr;
  public static final a awK;
  private static final long awL;
  private static final long awM;
  private static final long awN;
  private static final long awO;
  private static final long awP;
  private static final long awQ;
  private static final long awR;
  private static final long awS;
  private static final long awT;
  private static final long awU;
  private static final long awV;
  private static final long awW;
  public final long value;
  
  static
  {
    AppMethodBeat.i(205989);
    awK = new a((byte)0);
    awL = ab.af(4278190080L);
    awM = ab.af(4282664004L);
    awN = ab.af(4287137928L);
    awO = ab.af(4291611852L);
    awP = ab.af(4294967295L);
    awQ = ab.af(4294901760L);
    awR = ab.af(4278255360L);
    awS = ab.af(4278190335L);
    awT = ab.af(4294967040L);
    awU = ab.af(4278255615L);
    awV = ab.af(4294902015L);
    awW = ab.cH(0);
    e locale = e.ayQ;
    avr = ab.a(0.0F, 0.0F, 0.0F, 0.0F, (c)e.uv());
    AppMethodBeat.o(205989);
  }
  
  public static String H(long paramLong)
  {
    AppMethodBeat.i(205959);
    String str = "Color(" + Z(paramLong) + ", " + aa(paramLong) + ", " + ab(paramLong) + ", " + ac(paramLong) + ", " + Y(paramLong).name + ')';
    AppMethodBeat.o(205959);
    return str;
  }
  
  public static int I(long paramLong)
  {
    AppMethodBeat.i(205962);
    int i = kotlin.ab.I(paramLong);
    AppMethodBeat.o(205962);
    return i;
  }
  
  public static long J(long paramLong)
  {
    return paramLong;
  }
  
  public static final c Y(long paramLong)
  {
    AppMethodBeat.i(205936);
    Object localObject = e.ayQ;
    int i = (int)kotlin.ab.J(0x3F & paramLong);
    localObject = e.uw()[i];
    AppMethodBeat.o(205936);
    return localObject;
  }
  
  public static final float Z(long paramLong)
  {
    AppMethodBeat.i(205942);
    if (kotlin.ab.J(0x3F & paramLong) == 0L)
    {
      f = (float)aj.BE(kotlin.ab.J(kotlin.ab.J(paramLong >>> 48) & 0xFF)) / 255.0F;
      AppMethodBeat.o(205942);
      return f;
    }
    float f = ac.c(ac.d((short)(int)kotlin.ab.J(kotlin.ab.J(paramLong >>> 48) & 0xFFFF)));
    AppMethodBeat.o(205942);
    return f;
  }
  
  public static final long a(long paramLong, c paramc)
  {
    AppMethodBeat.i(205939);
    s.u(paramc, "colorSpace");
    if (s.p(paramc, Y(paramLong)))
    {
      AppMethodBeat.o(205939);
      return paramLong;
    }
    f localf = d.a(Y(paramLong), paramc, 0, 2);
    float[] arrayOfFloat = ab.ag(paramLong);
    localf.i(arrayOfFloat);
    paramLong = ab.a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], paramc);
    AppMethodBeat.o(205939);
    return paramLong;
  }
  
  public static final float aa(long paramLong)
  {
    AppMethodBeat.i(205947);
    if (kotlin.ab.J(0x3F & paramLong) == 0L)
    {
      f = (float)aj.BE(kotlin.ab.J(kotlin.ab.J(paramLong >>> 40) & 0xFF)) / 255.0F;
      AppMethodBeat.o(205947);
      return f;
    }
    float f = ac.c(ac.d((short)(int)kotlin.ab.J(kotlin.ab.J(paramLong >>> 32) & 0xFFFF)));
    AppMethodBeat.o(205947);
    return f;
  }
  
  public static final float ab(long paramLong)
  {
    AppMethodBeat.i(205950);
    if (kotlin.ab.J(0x3F & paramLong) == 0L)
    {
      f = (float)aj.BE(kotlin.ab.J(kotlin.ab.J(paramLong >>> 32) & 0xFF)) / 255.0F;
      AppMethodBeat.o(205950);
      return f;
    }
    float f = ac.c(ac.d((short)(int)kotlin.ab.J(kotlin.ab.J(paramLong >>> 16) & 0xFFFF)));
    AppMethodBeat.o(205950);
    return f;
  }
  
  public static final float ac(long paramLong)
  {
    AppMethodBeat.i(205953);
    if (kotlin.ab.J(0x3F & paramLong) == 0L)
    {
      f = (float)aj.BE(kotlin.ab.J(kotlin.ab.J(paramLong >>> 56) & 0xFF)) / 255.0F;
      AppMethodBeat.o(205953);
      return f;
    }
    float f = (float)aj.BE(kotlin.ab.J(kotlin.ab.J(paramLong >>> 6) & 0x3FF)) / 1023.0F;
    AppMethodBeat.o(205953);
    return f;
  }
  
  public static final boolean e(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    long l = this.value;
    if (!(paramObject instanceof z)) {}
    while (l != ((z)paramObject).value) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205994);
    int i = kotlin.ab.I(this.value);
    AppMethodBeat.o(205994);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205991);
    String str = H(this.value);
    AppMethodBeat.o(205991);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Color$Companion;", "", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "hsl", "hue", "", "saturation", "lightness", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsl-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hslToRgbComponent", "n", "", "h", "s", "l", "hsv", "value", "hsv-JlNiLsg", "hsvToRgbComponent", "v", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.z
 * JD-Core Version:    0.7.0.1
 */