package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorSpaces;", "", "()V", "Aces", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "getAces", "()Landroidx/compose/ui/graphics/colorspace/Rgb;", "Acescg", "getAcescg", "AdobeRgb", "getAdobeRgb", "Bt2020", "getBt2020", "Bt709", "getBt709", "CieLab", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getCieLab", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "CieXyz", "getCieXyz", "ColorSpacesArray", "", "getColorSpacesArray$ui_graphics_release", "()[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "DciP3", "getDciP3", "DisplayP3", "getDisplayP3", "ExtendedSrgb", "getExtendedSrgb", "LinearExtendedSrgb", "getLinearExtendedSrgb", "LinearSrgb", "getLinearSrgb", "NoneTransferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Ntsc1953", "getNtsc1953", "Ntsc1953Primaries", "", "getNtsc1953Primaries$ui_graphics_release", "()[F", "Oklab", "getOklab$ui_graphics_release", "ProPhotoRgb", "getProPhotoRgb", "SmpteC", "getSmpteC", "Srgb", "getSrgb", "SrgbPrimaries", "getSrgbPrimaries$ui_graphics_release", "SrgbTransferParameters", "getSrgbTransferParameters$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Unspecified", "getUnspecified$ui_graphics_release", "getColorSpace", "id", "", "getColorSpace$ui_graphics_release", "match", "toXYZD50", "function", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e ayQ;
  private static final float[] ayR;
  private static final float[] ayS;
  private static final l ayT;
  private static final l ayU;
  private static final k ayV;
  private static final k ayW;
  private static final k ayX;
  private static final k ayY;
  private static final k ayZ;
  private static final k aza;
  private static final k azb;
  private static final k azc;
  private static final k azd;
  private static final k aze;
  private static final k azf;
  private static final k azg;
  private static final k azh;
  private static final k azi;
  private static final c azj;
  private static final c azk;
  private static final k azl;
  private static final c azm;
  private static final c[] azn;
  
  static
  {
    AppMethodBeat.i(206278);
    ayQ = new e();
    ayR = new float[] { 0.64F, 0.33F, 0.3F, 0.6F, 0.15F, 0.06F };
    ayS = new float[] { 0.67F, 0.33F, 0.21F, 0.71F, 0.14F, 0.08F };
    ayT = new l(2.4D, 0.9478672985781991D, 0.05213270142180095D, 0.07739938080495357D, 0.04045D, (byte)0);
    ayU = new l(2.2D, 0.9478672985781991D, 0.05213270142180095D, 0.07739938080495357D, 0.04045D, (byte)0);
    Object localObject1 = ayR;
    Object localObject2 = g.azA;
    ayV = new k("sRGB IEC61966-2.1", (float[])localObject1, g.uA(), ayT, 0);
    localObject1 = ayR;
    localObject2 = g.azA;
    ayW = new k("sRGB IEC61966-2.1 (Linear)", (float[])localObject1, g.uA(), 1.0D, 0.0F, 1.0F, 1);
    localObject1 = ayR;
    localObject2 = g.azA;
    ayX = new k("scRGB-nl IEC 61966-2-2:2003", (float[])localObject1, g.uA(), null, (b)a.azo, (b)b.azp, -0.799F, 2.399F, ayT, 2);
    localObject1 = ayR;
    localObject2 = g.azA;
    ayY = new k("scRGB IEC 61966-2-2:2003", (float[])localObject1, g.uA(), 1.0D, -0.5F, 7.499F, 3);
    localObject1 = g.azA;
    localObject1 = g.uA();
    localObject2 = new l(2.222222222222222D, 0.9099181073703367D, 0.09008189262966333D, 0.2222222222222222D, 0.081D, (byte)0);
    ayZ = new k("Rec. ITU-R BT.709-5", new float[] { 0.64F, 0.33F, 0.3F, 0.6F, 0.15F, 0.06F }, (m)localObject1, (l)localObject2, 4);
    localObject1 = g.azA;
    localObject1 = g.uA();
    localObject2 = new l(2.222222222222222D, 0.9096697898662786D, 0.09033021013372146D, 0.2222222222222222D, 0.08145D, (byte)0);
    aza = new k("Rec. ITU-R BT.2020-1", new float[] { 0.708F, 0.292F, 0.17F, 0.797F, 0.131F, 0.046F }, (m)localObject1, (l)localObject2, 5);
    localObject1 = new m(0.314F, 0.351F);
    azb = new k("SMPTE RP 431-2-2007 DCI (P3)", new float[] { 0.68F, 0.32F, 0.265F, 0.69F, 0.15F, 0.06F }, (m)localObject1, 2.6D, 0.0F, 1.0F, 6);
    localObject1 = g.azA;
    localObject1 = g.uA();
    localObject2 = ayT;
    azc = new k("Display P3", new float[] { 0.68F, 0.32F, 0.265F, 0.69F, 0.15F, 0.06F }, (m)localObject1, (l)localObject2, 7);
    localObject1 = ayS;
    localObject2 = g.azA;
    azd = new k("NTSC (1953)", (float[])localObject1, g.ux(), new l(2.222222222222222D, 0.9099181073703367D, 0.09008189262966333D, 0.2222222222222222D, 0.081D, (byte)0), 8);
    localObject1 = g.azA;
    localObject1 = g.uA();
    localObject2 = new l(2.222222222222222D, 0.9099181073703367D, 0.09008189262966333D, 0.2222222222222222D, 0.081D, (byte)0);
    aze = new k("SMPTE-C RGB", new float[] { 0.63F, 0.34F, 0.31F, 0.595F, 0.155F, 0.07F }, (m)localObject1, (l)localObject2, 9);
    localObject1 = g.azA;
    localObject1 = g.uA();
    azf = new k("Adobe RGB (1998)", new float[] { 0.64F, 0.33F, 0.21F, 0.71F, 0.15F, 0.06F }, (m)localObject1, 2.2D, 0.0F, 1.0F, 10);
    localObject1 = g.azA;
    localObject1 = g.uy();
    localObject2 = new l(1.8D, 1.0D, 0.0D, 0.0625D, 0.031248D, (byte)0);
    azg = new k("ROMM RGB ISO 22028-2:2013", new float[] { 0.7347F, 0.2653F, 0.1596F, 0.8404F, 0.0366F, 1.0E-004F }, (m)localObject1, (l)localObject2, 11);
    localObject1 = g.azA;
    localObject1 = g.uz();
    azh = new k("SMPTE ST 2065-1:2012 ACES", new float[] { 0.7347F, 0.2653F, 0.0F, 1.0F, 1.0E-004F, -0.077F }, (m)localObject1, 1.0D, -65504.0F, 65504.0F, 12);
    localObject1 = g.azA;
    localObject1 = g.uz();
    azi = new k("Academy S-2014-004 ACEScg", new float[] { 0.713F, 0.293F, 0.165F, 0.83F, 0.128F, 0.044F }, (m)localObject1, 1.0D, -65504.0F, 65504.0F, 13);
    azj = (c)new n("Generic XYZ");
    azk = (c)new h("Generic L*a*b*");
    localObject1 = ayR;
    localObject2 = g.azA;
    azl = new k("None", (float[])localObject1, g.uA(), ayU, 16);
    azm = (c)new i("Oklab");
    azn = new c[] { (c)ayV, (c)ayW, (c)ayX, (c)ayY, (c)ayZ, (c)aza, (c)azb, (c)azc, (c)azd, (c)aze, (c)azf, (c)azg, (c)azh, (c)azi, azj, azk, (c)azl, azm };
    AppMethodBeat.o(206278);
  }
  
  public static float[] ud()
  {
    return ayR;
  }
  
  public static float[] ue()
  {
    return ayS;
  }
  
  public static k uf()
  {
    return ayV;
  }
  
  public static k ug()
  {
    return ayW;
  }
  
  public static k uh()
  {
    return ayX;
  }
  
  public static k ui()
  {
    return ayY;
  }
  
  public static k uj()
  {
    return ayZ;
  }
  
  public static k uk()
  {
    return aza;
  }
  
  public static k ul()
  {
    return azb;
  }
  
  public static k um()
  {
    return azc;
  }
  
  public static k un()
  {
    return azd;
  }
  
  public static k uo()
  {
    return aze;
  }
  
  public static k up()
  {
    return azf;
  }
  
  public static k uq()
  {
    return azg;
  }
  
  public static k ur()
  {
    return azh;
  }
  
  public static k us()
  {
    return azi;
  }
  
  public static c ut()
  {
    return azj;
  }
  
  public static c uu()
  {
    return azk;
  }
  
  public static k uv()
  {
    return azl;
  }
  
  public static c[] uw()
  {
    return azn;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Double, Double>
  {
    public static final a azo;
    
    static
    {
      AppMethodBeat.i(206247);
      azo = new a();
      AppMethodBeat.o(206247);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Double, Double>
  {
    public static final b azp;
    
    static
    {
      AppMethodBeat.i(206252);
      azp = new b();
      AppMethodBeat.o(206252);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.e
 * JD-Core Version:    0.7.0.1
 */