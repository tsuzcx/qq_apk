package androidx.camera.core.impl.a;

import android.location.Location;
import androidx.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class e
{
  private static final ThreadLocal<SimpleDateFormat> Ob;
  private static final ThreadLocal<SimpleDateFormat> Oc;
  private static final ThreadLocal<SimpleDateFormat> Od;
  private static final List<String> Oe;
  private static final List<String> Of;
  private static final String TAG;
  private final a Og;
  private boolean Oh = false;
  
  static
  {
    AppMethodBeat.i(199058);
    TAG = e.class.getSimpleName();
    Ob = new e.1();
    Oc = new e.2();
    Od = new e.3();
    Oe = Arrays.asList(new String[] { "ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType" });
    Of = Arrays.asList(new String[] { "ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation" });
    AppMethodBeat.o(199058);
  }
  
  private e(a parama)
  {
    this.Og = parama;
  }
  
  private static long ac(String paramString)
  {
    AppMethodBeat.i(199041);
    if (paramString == null)
    {
      AppMethodBeat.o(199041);
      return -1L;
    }
    try
    {
      long l = ((SimpleDateFormat)Od.get()).parse(paramString).getTime();
      AppMethodBeat.o(199041);
      return l;
    }
    catch (ParseException paramString)
    {
      AppMethodBeat.o(199041);
    }
    return -1L;
  }
  
  private int getOrientation()
  {
    AppMethodBeat.i(199006);
    int i = this.Og.k("Orientation", 0);
    AppMethodBeat.o(199006);
    return i;
  }
  
  private long getTimestamp()
  {
    AppMethodBeat.i(199014);
    l2 = ac(this.Og.aC("DateTimeOriginal"));
    if (l2 == -1L)
    {
      AppMethodBeat.o(199014);
      return -1L;
    }
    String str = this.Og.aC("SubSecTimeOriginal");
    l1 = l2;
    if (str != null) {}
    try
    {
      for (l1 = Long.parseLong(str); l1 > 1000L; l1 /= 10L) {}
      l1 = l2 + l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    AppMethodBeat.o(199014);
    return l1;
  }
  
  public static e h(InputStream paramInputStream)
  {
    AppMethodBeat.i(199001);
    paramInputStream = new e(new a(paramInputStream));
    AppMethodBeat.o(199001);
    return paramInputStream;
  }
  
  private static long k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199030);
    if ((paramString1 == null) && (paramString2 == null))
    {
      AppMethodBeat.o(199030);
      return -1L;
    }
    if (paramString2 == null) {
      try
      {
        l = ((SimpleDateFormat)Ob.get()).parse(paramString1).getTime();
        AppMethodBeat.o(199030);
        return l;
      }
      catch (ParseException paramString1)
      {
        AppMethodBeat.o(199030);
        return -1L;
      }
    }
    if (paramString1 == null) {
      try
      {
        l = ((SimpleDateFormat)Oc.get()).parse(paramString2).getTime();
        AppMethodBeat.o(199030);
        return l;
      }
      catch (ParseException paramString1)
      {
        AppMethodBeat.o(199030);
        return -1L;
      }
    }
    long l = ac(paramString1 + " " + paramString2);
    AppMethodBeat.o(199030);
    return l;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(199086);
    int i = this.Og.k("ImageLength", 0);
    AppMethodBeat.o(199086);
    return i;
  }
  
  public final int getRotation()
  {
    AppMethodBeat.i(199094);
    switch (getOrientation())
    {
    default: 
      AppMethodBeat.o(199094);
      return 0;
    case 2: 
      AppMethodBeat.o(199094);
      return 0;
    case 3: 
      AppMethodBeat.o(199094);
      return 180;
    case 4: 
      AppMethodBeat.o(199094);
      return 180;
    case 5: 
      AppMethodBeat.o(199094);
      return 270;
    case 6: 
      AppMethodBeat.o(199094);
      return 90;
    case 7: 
      AppMethodBeat.o(199094);
      return 90;
    }
    AppMethodBeat.o(199094);
    return 270;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(199078);
    int i = this.Og.k("ImageWidth", 0);
    AppMethodBeat.o(199078);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199072);
    Locale localLocale = Locale.ENGLISH;
    int j = getWidth();
    int k = getHeight();
    int m = getRotation();
    boolean bool1;
    boolean bool2;
    switch (getOrientation())
    {
    default: 
      bool1 = false;
      switch (getOrientation())
      {
      default: 
        bool2 = false;
      }
      break;
    }
    String str;
    double[] arrayOfDouble;
    double d1;
    double d2;
    Object localObject1;
    long l;
    for (;;)
    {
      str = this.Og.aC("GPSProcessingMethod");
      arrayOfDouble = this.Og.FP();
      d1 = this.Og.FQ();
      d2 = this.Og.a("GPSSpeed", 0.0D);
      localObject2 = this.Og.aC("GPSSpeedRef");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "K";
      }
      l = k(this.Og.aC("GPSDateStamp"), this.Og.aC("GPSTimeStamp"));
      if (arrayOfDouble != null) {
        break label404;
      }
      localObject1 = null;
      localObject1 = String.format(localLocale, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject1, Long.valueOf(getTimestamp()), this.Og.aC("ImageDescription") });
      AppMethodBeat.o(199072);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
      break;
      bool1 = true;
      break;
      bool1 = true;
      break;
      bool1 = false;
      break;
      bool1 = true;
      break;
      bool1 = false;
      break;
      bool2 = true;
      continue;
      bool2 = false;
      continue;
      bool2 = false;
      continue;
      bool2 = false;
      continue;
      bool2 = false;
      continue;
      bool2 = false;
      continue;
      bool2 = false;
    }
    label404:
    Object localObject2 = str;
    if (str == null) {
      localObject2 = TAG;
    }
    localObject2 = new Location((String)localObject2);
    ((Location)localObject2).setLatitude(arrayOfDouble[0]);
    ((Location)localObject2).setLongitude(arrayOfDouble[1]);
    if (d1 != 0.0D) {
      ((Location)localObject2).setAltitude(d1);
    }
    label500:
    int i;
    if (d2 != 0.0D) {
      switch (((String)localObject1).hashCode())
      {
      case 76: 
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label503:
          d1 = new a.a(0.621371D * d2).kL();
        }
        break;
      }
    }
    for (;;)
    {
      ((Location)localObject2).setSpeed((float)d1);
      if (l != -1L) {
        ((Location)localObject2).setTime(l);
      }
      localObject1 = localObject2;
      break;
      if (!((String)localObject1).equals("M")) {
        break label500;
      }
      i = 0;
      break label503;
      if (!((String)localObject1).equals("N")) {
        break label500;
      }
      i = 1;
      break label503;
      if (!((String)localObject1).equals("K")) {
        break label500;
      }
      i = 2;
      break label503;
      d1 = new a.a(d2).kL();
      continue;
      d1 = new a.a(1.15078D * d2).kL();
    }
  }
  
  static final class a$a
  {
    final double Oi;
    
    a$a(double paramDouble)
    {
      this.Oi = paramDouble;
    }
    
    final double kL()
    {
      return this.Oi / 2.23694D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.e
 * JD-Core Version:    0.7.0.1
 */