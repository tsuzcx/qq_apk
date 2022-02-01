package coil.e;

import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Size;
import coil.size.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import j.i;
import j.i.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;
import kotlin.k.k;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcoil/decode/DecodeUtils;", "", "()V", "GIF_HEADER_87A", "Lokio/ByteString;", "GIF_HEADER_89A", "HEIF_HEADER_FTYP", "HEIF_HEADER_HEVC", "HEIF_HEADER_HEVX", "HEIF_HEADER_MSF1", "WEBP_HEADER_RIFF", "WEBP_HEADER_VPX8", "WEBP_HEADER_WEBP", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil/size/Scale;", "computePixelSize", "Lcoil/size/PixelSize;", "dstSize", "Lcoil/size/Size;", "computeSizeMultiplier", "", "", "isAnimatedHeif", "", "source", "Lokio/BufferedSource;", "isAnimatedWebP", "isGif", "isHeif", "isWebP", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d cna;
  private static final i cnb;
  private static final i cnc;
  private static final i cnd;
  private static final i cne;
  private static final i cnf;
  private static final i cng;
  private static final i cnh;
  private static final i cni;
  private static final i cnj;
  
  static
  {
    AppMethodBeat.i(187866);
    cna = new d();
    i.a locala = i.ajTf;
    cnb = i.a.bKT("GIF87a");
    locala = i.ajTf;
    cnc = i.a.bKT("GIF89a");
    locala = i.ajTf;
    cnd = i.a.bKT("RIFF");
    locala = i.ajTf;
    cne = i.a.bKT("WEBP");
    locala = i.ajTf;
    cnf = i.a.bKT("VP8X");
    locala = i.ajTf;
    cng = i.a.bKT("ftyp");
    locala = i.ajTf;
    cnh = i.a.bKT("msf1");
    locala = i.ajTf;
    cni = i.a.bKT("hevc");
    locala = i.ajTf;
    cnj = i.a.bKT("hevx");
    AppMethodBeat.o(187866);
  }
  
  public static final double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, e parame)
  {
    AppMethodBeat.i(187852);
    s.u(parame, "scale");
    paramDouble1 = paramDouble3 / paramDouble1;
    paramDouble2 = paramDouble4 / paramDouble2;
    switch (d.a.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      parame = new p();
      AppMethodBeat.o(187852);
      throw parame;
    case 1: 
      paramDouble1 = Math.max(paramDouble1, paramDouble2);
      AppMethodBeat.o(187852);
      return paramDouble1;
    }
    paramDouble1 = Math.min(paramDouble1, paramDouble2);
    AppMethodBeat.o(187852);
    return paramDouble1;
  }
  
  public static final float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, e parame)
  {
    AppMethodBeat.i(187843);
    s.u(parame, "scale");
    paramFloat1 = paramFloat3 / paramFloat1;
    paramFloat2 = paramFloat4 / paramFloat2;
    switch (d.a.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      parame = new p();
      AppMethodBeat.o(187843);
      throw parame;
    case 1: 
      paramFloat1 = Math.max(paramFloat1, paramFloat2);
      AppMethodBeat.o(187843);
      return paramFloat1;
    }
    paramFloat1 = Math.min(paramFloat1, paramFloat2);
    AppMethodBeat.o(187843);
    return paramFloat1;
  }
  
  public static final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, e parame)
  {
    AppMethodBeat.i(187832);
    s.u(parame, "scale");
    paramInt1 = k.qu(Integer.highestOneBit(paramInt1 / paramInt3), 1);
    paramInt2 = k.qu(Integer.highestOneBit(paramInt2 / paramInt4), 1);
    switch (d.a.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      parame = new p();
      AppMethodBeat.o(187832);
      throw parame;
    case 1: 
      paramInt1 = Math.min(paramInt1, paramInt2);
      AppMethodBeat.o(187832);
      return paramInt1;
    }
    paramInt1 = Math.max(paramInt1, paramInt2);
    AppMethodBeat.o(187832);
    return paramInt1;
  }
  
  public static final PixelSize a(int paramInt1, int paramInt2, Size paramSize, e parame)
  {
    AppMethodBeat.i(187858);
    s.u(paramSize, "dstSize");
    s.u(parame, "scale");
    if ((paramSize instanceof OriginalSize))
    {
      paramSize = new PixelSize(paramInt1, paramInt2);
      AppMethodBeat.o(187858);
      return paramSize;
    }
    if ((paramSize instanceof PixelSize))
    {
      double d = b(paramInt1, paramInt2, ((PixelSize)paramSize).width, ((PixelSize)paramSize).height, parame);
      paramSize = new PixelSize(a.ah(paramInt1 * d), a.ah(d * paramInt2));
      AppMethodBeat.o(187858);
      return paramSize;
    }
    paramSize = new p();
    AppMethodBeat.o(187858);
    throw paramSize;
  }
  
  public static final double b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, e parame)
  {
    AppMethodBeat.i(187836);
    s.u(parame, "scale");
    double d1 = paramInt3 / paramInt1;
    double d2 = paramInt4 / paramInt2;
    switch (d.a.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      parame = new p();
      AppMethodBeat.o(187836);
      throw parame;
    case 1: 
      d1 = Math.max(d1, d2);
      AppMethodBeat.o(187836);
      return d1;
    }
    d1 = Math.min(d1, d2);
    AppMethodBeat.o(187836);
    return d1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.e.d
 * JD-Core Version:    0.7.0.1
 */