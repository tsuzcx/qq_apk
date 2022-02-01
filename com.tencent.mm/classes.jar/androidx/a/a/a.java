package androidx.a.a;

import android.content.res.AssetManager.AssetInputStream;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

public final class a
{
  private static final boolean DEBUG;
  private static final byte[] aAV;
  private static final byte[] aAW;
  private static final byte[] aAX;
  private static final d[] aAY;
  private static final d[] aAZ;
  private static final d[] aBa;
  private static final d[] aBb;
  private static final d[] aBc;
  private static final d aBd;
  private static final d[] aBe;
  private static final d[] aBf;
  private static final d[] aBg;
  private static final d[] aBh;
  static final d[][] aBi;
  private static final d[] aBj;
  private static final d aBk;
  private static final d aBl;
  private static final byte[] aBm;
  private static final byte[] yA;
  private static final byte[] yB;
  private static SimpleDateFormat yC;
  static final String[] yD;
  static final int[] yE;
  static final byte[] yF;
  private static final HashMap<Integer, d>[] yT;
  private static final HashMap<String, d>[] yU;
  private static final HashSet<String> yV;
  private static final HashMap<Integer, Integer> yW;
  static final Charset yX;
  static final byte[] yY;
  private static final List<Integer> yu;
  private static final List<Integer> yv;
  public static final int[] yw;
  public static final int[] yx;
  public static final int[] yy;
  static final byte[] yz;
  private static final Pattern zr;
  private static final Pattern zt;
  public FileDescriptor aBn;
  public boolean aBo;
  public String yZ;
  private AssetManager.AssetInputStream za;
  public int zb;
  private final HashMap<String, c>[] zc;
  private Set<Integer> zd;
  private ByteOrder ze;
  private boolean zf;
  private int zg;
  private int zi;
  public byte[] zj;
  private int zk;
  private int zl;
  private int zm;
  private int zn;
  private int zo;
  private int zp;
  public boolean zq;
  
  static
  {
    AppMethodBeat.i(178752);
    DEBUG = Log.isLoggable("ExifInterface", 3);
    yu = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8) });
    yv = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5) });
    yw = new int[] { 8, 8, 8 };
    yx = new int[] { 4 };
    yy = new int[] { 8 };
    yz = new byte[] { -1, -40, -1 };
    aAV = new byte[] { 102, 116, 121, 112 };
    aAW = new byte[] { 109, 105, 102, 49 };
    aAX = new byte[] { 104, 101, 105, 99 };
    yA = new byte[] { 79, 76, 89, 77, 80, 0 };
    yB = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
    yD = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
    yE = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
    yF = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
    aAY = new d[] { new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256), new d("ImageLength", 257), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278), new d("StripByteCounts", 279), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1) };
    aAZ = new d[] { new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962), new d("PixelYDimension", 40963), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720) };
    aBa = new d[] { new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3) };
    aBb = new d[] { new d("InteroperabilityIndex", 1, 2) };
    aBc = new d[] { new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256), new d("ThumbnailImageLength", 257), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278), new d("StripByteCounts", 279), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720) };
    aBd = new d("StripOffsets", 273, 3);
    aBe = new d[] { new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4) };
    aBf = new d[] { new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4) };
    aBg = new d[] { new d("AspectFrame", 4371, 3) };
    aBh = new d[] { new d("ColorSpace", 55, 3) };
    aBi = new d[][] { aAY, aAZ, aBa, aBb, aBc, aAY, aBe, aBf, aBg, aBh };
    aBj = new d[] { new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1) };
    aBk = new d("JPEGInterchangeFormat", 513, 4);
    aBl = new d("JPEGInterchangeFormatLength", 514, 4);
    yT = new HashMap[aBi.length];
    yU = new HashMap[aBi.length];
    yV = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    yW = new HashMap();
    yX = Charset.forName("US-ASCII");
    yY = "".getBytes(yX);
    aBm = "".getBytes(yX);
    Object localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    yC = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    int i = 0;
    while (i < aBi.length)
    {
      yT[i] = new HashMap();
      yU[i] = new HashMap();
      localObject1 = aBi[i];
      int k = localObject1.length;
      int j = 0;
      while (j < k)
      {
        Object localObject2 = localObject1[j];
        yT[i].put(Integer.valueOf(localObject2.number), localObject2);
        yU[i].put(localObject2.name, localObject2);
        j += 1;
      }
      i += 1;
    }
    yW.put(Integer.valueOf(aBj[0].number), Integer.valueOf(5));
    yW.put(Integer.valueOf(aBj[1].number), Integer.valueOf(1));
    yW.put(Integer.valueOf(aBj[2].number), Integer.valueOf(2));
    yW.put(Integer.valueOf(aBj[3].number), Integer.valueOf(3));
    yW.put(Integer.valueOf(aBj[4].number), Integer.valueOf(7));
    yW.put(Integer.valueOf(aBj[5].number), Integer.valueOf(8));
    zr = Pattern.compile(".*[1-9].*");
    zt = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    AppMethodBeat.o(178752);
  }
  
  public a(InputStream paramInputStream)
  {
    AppMethodBeat.i(178714);
    this.zc = new HashMap[aBi.length];
    this.zd = new HashSet(aBi.length);
    this.ze = ByteOrder.BIG_ENDIAN;
    if (paramInputStream == null)
    {
      paramInputStream = new NullPointerException("inputStream cannot be null");
      AppMethodBeat.o(178714);
      throw paramInputStream;
    }
    this.yZ = null;
    if ((paramInputStream instanceof AssetManager.AssetInputStream))
    {
      this.za = ((AssetManager.AssetInputStream)paramInputStream);
      this.aBn = null;
    }
    for (;;)
    {
      b(paramInputStream);
      AppMethodBeat.o(178714);
      return;
      if (((paramInputStream instanceof FileInputStream)) && (a(((FileInputStream)paramInputStream).getFD())))
      {
        this.za = null;
        this.aBn = ((FileInputStream)paramInputStream).getFD();
      }
      else
      {
        this.za = null;
        this.aBn = null;
      }
    }
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(178713);
    this.zc = new HashMap[aBi.length];
    this.zd = new HashSet(aBi.length);
    this.ze = ByteOrder.BIG_ENDIAN;
    if (paramString == null)
    {
      paramString = new NullPointerException("filename cannot be null");
      AppMethodBeat.o(178713);
      throw paramString;
    }
    if (paramString == null)
    {
      paramString = new NullPointerException("filename cannot be null");
      AppMethodBeat.o(178713);
      throw paramString;
    }
    this.za = null;
    this.yZ = paramString;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      try
      {
        if (a(localFileInputStream.getFD())) {}
        for (this.aBn = localFileInputStream.getFD();; this.aBn = null)
        {
          b(localFileInputStream);
          closeQuietly(localFileInputStream);
          AppMethodBeat.o(178713);
          return;
        }
        closeQuietly(localFileInputStream);
      }
      finally {}
    }
    finally
    {
      FileInputStream localFileInputStream = null;
    }
    AppMethodBeat.o(178713);
    throw paramString;
  }
  
  private c J(String paramString)
  {
    AppMethodBeat.i(178715);
    if (paramString == null)
    {
      paramString = new NullPointerException("tag shouldn't be null");
      AppMethodBeat.o(178715);
      throw paramString;
    }
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString)) {
      str = "PhotographicSensitivity";
    }
    int i = 0;
    while (i < aBi.length)
    {
      paramString = (c)this.zc[i].get(str);
      if (paramString != null)
      {
        AppMethodBeat.o(178715);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(178715);
    return null;
  }
  
  private int a(b paramb)
  {
    AppMethodBeat.i(178746);
    int[] arrayOfInt = new int[aBi.length];
    Object localObject1 = new int[aBi.length];
    Object localObject2 = aBj;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      removeAttribute(localObject2[i].name);
      i += 1;
    }
    removeAttribute(aBk.name);
    removeAttribute(aBl.name);
    i = 0;
    int k;
    while (i < aBi.length)
    {
      localObject2 = this.zc[i].entrySet().toArray();
      k = localObject2.length;
      j = 0;
      while (j < k)
      {
        Map.Entry localEntry = (Map.Entry)localObject2[j];
        if (localEntry.getValue() == null) {
          this.zc[i].remove(localEntry.getKey());
        }
        j += 1;
      }
      i += 1;
    }
    if (!this.zc[1].isEmpty()) {
      this.zc[0].put(aBj[1].name, c.b(0L, this.ze));
    }
    if (!this.zc[2].isEmpty()) {
      this.zc[0].put(aBj[2].name, c.b(0L, this.ze));
    }
    if (!this.zc[3].isEmpty()) {
      this.zc[1].put(aBj[3].name, c.b(0L, this.ze));
    }
    if (this.zf)
    {
      this.zc[4].put(aBk.name, c.b(0L, this.ze));
      this.zc[4].put(aBl.name, c.b(this.zi, this.ze));
    }
    j = 0;
    if (j < aBi.length)
    {
      localObject2 = this.zc[j].entrySet().iterator();
      i = 0;
      label376:
      if (((Iterator)localObject2).hasNext())
      {
        k = ((c)((Map.Entry)((Iterator)localObject2).next()).getValue()).size();
        if (k <= 4) {
          break label1219;
        }
        i = k + i;
      }
    }
    label1072:
    label1219:
    for (;;)
    {
      break label376;
      localObject1[j] += i;
      j += 1;
      break;
      i = 8;
      j = 0;
      while (j < aBi.length)
      {
        k = i;
        if (!this.zc[j].isEmpty())
        {
          arrayOfInt[j] = i;
          k = i + (this.zc[j].size() * 12 + 2 + 4 + localObject1[j]);
        }
        j += 1;
        i = k;
      }
      j = i;
      if (this.zf)
      {
        this.zc[4].put(aBk.name, c.b(i, this.ze));
        this.zg = (i + 6);
        j = i + this.zi;
      }
      int m = j + 8;
      if (DEBUG)
      {
        i = 0;
        while (i < aBi.length)
        {
          String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(arrayOfInt[i]), Integer.valueOf(this.zc[i].size()), Integer.valueOf(localObject1[i]) });
          i += 1;
        }
      }
      if (!this.zc[1].isEmpty()) {
        this.zc[0].put(aBj[1].name, c.b(arrayOfInt[1], this.ze));
      }
      if (!this.zc[2].isEmpty()) {
        this.zc[0].put(aBj[2].name, c.b(arrayOfInt[2], this.ze));
      }
      if (!this.zc[3].isEmpty()) {
        this.zc[1].put(aBj[3].name, c.b(arrayOfInt[3], this.ze));
      }
      paramb.writeShort((short)m);
      paramb.write(yY);
      short s;
      if (this.ze == ByteOrder.BIG_ENDIAN)
      {
        s = 19789;
        paramb.writeShort(s);
        paramb.zv = this.ze;
        paramb.writeShort((short)42);
        paramb.writeInt(8);
        i = 0;
      }
      for (;;)
      {
        if (i >= aBi.length) {
          break label1188;
        }
        if (!this.zc[i].isEmpty())
        {
          paramb.writeShort((short)this.zc[i].size());
          j = arrayOfInt[i];
          k = this.zc[i].size();
          localObject1 = this.zc[i].entrySet().iterator();
          j = j + 2 + k * 12 + 4;
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1072;
            }
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            int n = ((d)yU[i].get(((Map.Entry)localObject2).getKey())).number;
            localObject2 = (c)((Map.Entry)localObject2).getValue();
            k = ((c)localObject2).size();
            paramb.writeShort((short)n);
            paramb.writeShort((short)((c)localObject2).format);
            paramb.writeInt(((c)localObject2).zx);
            if (k > 4)
            {
              paramb.writeInt((int)j);
              j += k;
              continue;
              s = 18761;
              break;
            }
            paramb.write(((c)localObject2).zy);
            if (k < 4) {
              while (k < 4)
              {
                paramb.writeByte(0);
                k += 1;
              }
            }
          }
          if ((i == 0) && (!this.zc[4].isEmpty())) {
            paramb.writeInt((int)arrayOfInt[4]);
          }
          for (;;)
          {
            localObject1 = this.zc[i].entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (c)((Map.Entry)((Iterator)localObject1).next()).getValue();
              if (((c)localObject2).zy.length > 4) {
                paramb.write(((c)localObject2).zy, 0, ((c)localObject2).zy.length);
              }
            }
            paramb.writeInt(0);
          }
        }
        i += 1;
      }
      if (this.zf) {
        paramb.write(getThumbnailBytes());
      }
      paramb.zv = ByteOrder.BIG_ENDIAN;
      AppMethodBeat.o(178746);
      return m;
    }
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(178732);
    a(parama, parama.available());
    b(parama, 0);
    d(parama, 0);
    d(parama, 5);
    d(parama, 4);
    dD();
    if (this.zb == 8)
    {
      parama = (c)this.zc[1].get("MakerNote");
      if (parama != null)
      {
        parama = new a(parama.zy);
        parama.zv = this.ze;
        parama.seek(6L);
        b(parama, 9);
        parama = (c)this.zc[9].get("ColorSpace");
        if (parama != null) {
          this.zc[1].put("ColorSpace", parama);
        }
      }
    }
    AppMethodBeat.o(178732);
  }
  
  private void a(a parama, int paramInt)
  {
    AppMethodBeat.i(178738);
    this.ze = c(parama);
    parama.zv = this.ze;
    int i = parama.readUnsignedShort();
    if ((this.zb != 7) && (this.zb != 10) && (i != 42))
    {
      parama = new IOException("Invalid start code: " + Integer.toHexString(i));
      AppMethodBeat.o(178738);
      throw parama;
    }
    i = parama.readInt();
    if ((i < 8) || (i >= paramInt))
    {
      parama = new IOException("Invalid first Ifd offset: ".concat(String.valueOf(i)));
      AppMethodBeat.o(178738);
      throw parama;
    }
    paramInt = i - 8;
    if ((paramInt > 0) && (parama.skipBytes(paramInt) != paramInt))
    {
      parama = new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(178738);
      throw parama;
    }
    AppMethodBeat.o(178738);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178731);
    if (DEBUG) {
      new StringBuilder("getJpegAttributes starting with: ").append(parama);
    }
    parama.zv = ByteOrder.BIG_ENDIAN;
    parama.seek(paramInt1);
    int i = parama.readByte();
    if (i != -1)
    {
      parama = new IOException("Invalid marker: " + Integer.toHexString(i & 0xFF));
      AppMethodBeat.o(178731);
      throw parama;
    }
    if (parama.readByte() != -40)
    {
      parama = new IOException("Invalid marker: " + Integer.toHexString(i & 0xFF));
      AppMethodBeat.o(178731);
      throw parama;
    }
    paramInt1 = paramInt1 + 1 + 1;
    i = parama.readByte();
    if (i != -1)
    {
      parama = new IOException("Invalid marker:" + Integer.toHexString(i & 0xFF));
      AppMethodBeat.o(178731);
      throw parama;
    }
    int m = parama.readByte();
    if (DEBUG) {
      new StringBuilder("Found JPEG segment indicator: ").append(Integer.toHexString(m & 0xFF));
    }
    int k;
    int j;
    if ((m != -39) && (m != -38))
    {
      k = parama.readUnsignedShort() - 2;
      j = paramInt1 + 1 + 1 + 2;
      if (DEBUG) {
        new StringBuilder("JPEG segment: ").append(Integer.toHexString(m & 0xFF)).append(" (length: ").append(k + 2).append(")");
      }
      if (k < 0)
      {
        parama = new IOException("Invalid length");
        AppMethodBeat.o(178731);
        throw parama;
      }
      i = k;
      paramInt1 = j;
      switch (m)
      {
      default: 
        paramInt1 = j;
        i = k;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        parama = new IOException("Invalid length");
        AppMethodBeat.o(178731);
        throw parama;
        byte[] arrayOfByte = new byte[k];
        parama.readFully(arrayOfByte);
        paramInt1 = j + k;
        long l;
        if (c(arrayOfByte, yY))
        {
          l = yY.length + j;
          b(Arrays.copyOfRange(arrayOfByte, yY.length, arrayOfByte.length), paramInt2);
          this.zl = ((int)l);
        }
        for (i = 0;; i = 0)
        {
          arrayOfByte = new byte[i];
          if (parama.read(arrayOfByte) == i) {
            break;
          }
          parama = new IOException("Invalid exif");
          AppMethodBeat.o(178731);
          throw parama;
          if (c(arrayOfByte, aBm))
          {
            l = aBm.length + j;
            arrayOfByte = Arrays.copyOfRange(arrayOfByte, aBm.length, arrayOfByte.length);
            if (getAttribute("Xmp") == null) {
              this.zc[0].put("Xmp", new c(1, arrayOfByte.length, l, arrayOfByte));
            }
          }
        }
        if (getAttribute("UserComment") == null)
        {
          this.zc[1].put("UserComment", c.L(new String(arrayOfByte, yX)));
          i = 0;
          continue;
          if (parama.skipBytes(1) != 1)
          {
            parama = new IOException("Invalid SOFx");
            AppMethodBeat.o(178731);
            throw parama;
          }
          this.zc[paramInt2].put("ImageLength", c.b(parama.readUnsignedShort(), this.ze));
          this.zc[paramInt2].put("ImageWidth", c.b(parama.readUnsignedShort(), this.ze));
          i = k - 5;
          paramInt1 = j;
        }
      }
      else
      {
        if (parama.skipBytes(i) != i)
        {
          parama = new IOException("Invalid JPEG segment");
          AppMethodBeat.o(178731);
          throw parama;
        }
        paramInt1 = i + paramInt1;
        break;
        parama.zv = this.ze;
        AppMethodBeat.o(178731);
        return;
      }
      i = 0;
    }
  }
  
  private void a(a parama, HashMap paramHashMap)
  {
    AppMethodBeat.i(178741);
    c localc = (c)paramHashMap.get("JPEGInterchangeFormat");
    paramHashMap = (c)paramHashMap.get("JPEGInterchangeFormatLength");
    int j;
    int k;
    int i;
    if ((localc != null) && (paramHashMap != null))
    {
      j = localc.b(this.ze);
      k = Math.min(paramHashMap.b(this.ze), parama.mLength - j);
      if ((this.zb != 4) && (this.zb != 9) && (this.zb != 10)) {
        break label209;
      }
      i = j + this.zl;
    }
    for (;;)
    {
      if (DEBUG) {
        new StringBuilder("Setting thumbnail attributes with offset: ").append(i).append(", length: ").append(k);
      }
      if ((i > 0) && (k > 0))
      {
        this.zf = true;
        this.zg = i;
        this.zi = k;
        if ((this.yZ == null) && (this.za == null) && (this.aBn == null))
        {
          paramHashMap = new byte[k];
          parama.seek(i);
          parama.readFully(paramHashMap);
          this.zj = paramHashMap;
        }
      }
      AppMethodBeat.o(178741);
      return;
      label209:
      i = j;
      if (this.zb == 7) {
        i = j + this.zm;
      }
    }
  }
  
  private static boolean a(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(178722);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        Os.lseek(paramFileDescriptor, 0L, OsConstants.SEEK_CUR);
        AppMethodBeat.o(178722);
        return true;
      }
      catch (Exception paramFileDescriptor)
      {
        AppMethodBeat.o(178722);
        return false;
      }
    }
    AppMethodBeat.o(178722);
    return false;
  }
  
  private boolean a(HashMap paramHashMap)
  {
    AppMethodBeat.i(178743);
    c localc = (c)paramHashMap.get("ImageLength");
    paramHashMap = (c)paramHashMap.get("ImageWidth");
    if ((localc != null) && (paramHashMap != null))
    {
      int i = localc.b(this.ze);
      int j = paramHashMap.b(this.ze);
      if ((i <= 512) && (j <= 512))
      {
        AppMethodBeat.o(178743);
        return true;
      }
    }
    AppMethodBeat.o(178743);
    return false;
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(178733);
    parama.skipBytes(84);
    Object localObject = new byte[4];
    byte[] arrayOfByte = new byte[4];
    parama.read((byte[])localObject);
    parama.skipBytes(4);
    parama.read(arrayOfByte);
    int i = ByteBuffer.wrap((byte[])localObject).getInt();
    int j = ByteBuffer.wrap(arrayOfByte).getInt();
    a(parama, i, 5);
    parama.seek(j);
    parama.zv = ByteOrder.BIG_ENDIAN;
    j = parama.readInt();
    i = 0;
    while (i < j)
    {
      int k = parama.readUnsignedShort();
      int m = parama.readUnsignedShort();
      if (k == aBd.number)
      {
        i = parama.readShort();
        j = parama.readShort();
        parama = c.b(i, this.ze);
        localObject = c.b(j, this.ze);
        this.zc[0].put("ImageLength", parama);
        this.zc[0].put("ImageWidth", localObject);
        if (DEBUG) {
          new StringBuilder("Updated to length: ").append(i).append(", width: ").append(j);
        }
        AppMethodBeat.o(178733);
        return;
      }
      parama.skipBytes(m);
      i += 1;
    }
    AppMethodBeat.o(178733);
  }
  
  private void b(a parama, int paramInt)
  {
    AppMethodBeat.i(178739);
    int i = paramInt;
    this.zd.add(Integer.valueOf(parama.mPosition));
    if (parama.mPosition + 2 > parama.mLength)
    {
      AppMethodBeat.o(178739);
      return;
    }
    int i1 = parama.readShort();
    if ((parama.mPosition + i1 * 12 > parama.mLength) || (i1 <= 0))
    {
      AppMethodBeat.o(178739);
      return;
    }
    int j = 0;
    int i3;
    int k;
    int i2;
    long l3;
    d locald;
    Object localObject;
    label155:
    int n;
    int m;
    long l1;
    if (j < i1)
    {
      i3 = parama.readUnsignedShort();
      k = parama.readUnsignedShort();
      i2 = parama.readInt();
      l3 = parama.mPosition + 4L;
      locald = (d)yT[i].get(Integer.valueOf(i3));
      long l2;
      if (DEBUG)
      {
        if (locald != null)
        {
          localObject = locald.name;
          String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i3), localObject, Integer.valueOf(k), Integer.valueOf(i2) });
        }
      }
      else
      {
        l2 = 0L;
        n = 0;
        if (locald != null) {
          break label257;
        }
        paramInt = k;
        m = n;
        l1 = l2;
        if (!DEBUG) {}
      }
      label257:
      for (;;)
      {
        label230:
        if (m == 0)
        {
          parama.seek(l3);
          label241:
          j = (short)(j + 1);
          break;
          localObject = null;
          break label155;
          if ((k <= 0) || (k >= yE.length))
          {
            paramInt = k;
            m = n;
            l1 = l2;
            if (DEBUG)
            {
              paramInt = k;
              m = n;
              l1 = l2;
            }
          }
          else if (!locald.am(k))
          {
            paramInt = k;
            m = n;
            l1 = l2;
            if (DEBUG)
            {
              new StringBuilder("Skip the tag entry since data format (").append(yD[k]).append(") is unexpected for tag: ").append(locald.name);
              paramInt = k;
              m = n;
              l1 = l2;
            }
          }
          else
          {
            if (k != 7) {
              break label1265;
            }
          }
        }
      }
    }
    label481:
    label621:
    label1265:
    for (paramInt = locald.zz;; paramInt = k)
    {
      l1 = i2 * yE[paramInt];
      if ((l1 < 0L) || (l1 > 2147483647L))
      {
        if (!DEBUG) {
          break label1258;
        }
        m = n;
        break label230;
      }
      m = 1;
      break label230;
      if (l1 > 4L)
      {
        k = parama.readInt();
        if (this.zb != 7) {
          break label833;
        }
        if ("MakerNote".equals(locald.name))
        {
          this.zm = k;
          if (k + l1 > parama.mLength) {
            break label865;
          }
          parama.seek(k);
        }
      }
      else
      {
        localObject = (Integer)yW.get(Integer.valueOf(i3));
        if (DEBUG) {
          new StringBuilder("nextIfdType: ").append(localObject).append(" byteCount: ").append(l1);
        }
        if (localObject == null) {
          break label955;
        }
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          l1 = -1L;
          if (DEBUG) {
            String.format("Offset: %d, tagName: %s", new Object[] { Long.valueOf(l1), locald.name });
          }
          if ((l1 > 0L) && (l1 < parama.mLength))
          {
            if (this.zd.contains(Integer.valueOf((int)l1))) {
              break label913;
            }
            parama.seek(l1);
            b(parama, ((Integer)localObject).intValue());
          }
          break;
        }
      }
      for (;;)
      {
        parama.seek(l3);
        break;
        if ((i != 6) || (!"ThumbnailImage".equals(locald.name))) {
          break label481;
        }
        this.zn = k;
        this.zo = i2;
        localObject = c.b(6, this.ze);
        c localc1 = c.b(this.zn, this.ze);
        c localc2 = c.b(this.zo, this.ze);
        this.zc[4].put("Compression", localObject);
        this.zc[4].put("JPEGInterchangeFormat", localc1);
        this.zc[4].put("JPEGInterchangeFormatLength", localc2);
        break label481;
        if ((this.zb != 10) || (!"JpgFromRaw".equals(locald.name))) {
          break label481;
        }
        this.zp = k;
        break label481;
        parama.seek(l3);
        break;
        l1 = parama.readUnsignedShort();
        break label621;
        l1 = parama.readShort();
        break label621;
        l1 = parama.dE();
        break label621;
        l1 = parama.readInt();
        break label621;
        if (DEBUG) {
          new StringBuilder("Skip jump into the IFD since it has already been read: IfdType ").append(localObject).append(" (at ").append(l1).append(")");
        }
      }
      k = parama.mPosition;
      localObject = new byte[(int)l1];
      parama.readFully((byte[])localObject);
      localObject = new c(paramInt, i2, k, (byte[])localObject);
      this.zc[i].put(locald.name, localObject);
      if ("DNGVersion".equals(locald.name)) {
        this.zb = 3;
      }
      if (((!"Make".equals(locald.name)) && (!"Model".equals(locald.name))) || ((((c)localObject).c(this.ze).contains("PENTAX")) || (("Compression".equals(locald.name)) && (((c)localObject).b(this.ze) == 65535)))) {
        this.zb = 8;
      }
      if (parama.mPosition == l3) {
        break label241;
      }
      parama.seek(l3);
      break label241;
      if (parama.mPosition + 4 <= parama.mLength)
      {
        paramInt = parama.readInt();
        if (DEBUG) {
          String.format("nextIfdOffset: %d", new Object[] { Integer.valueOf(paramInt) });
        }
        if ((paramInt > 0L) && (paramInt < parama.mLength))
        {
          if (!this.zd.contains(Integer.valueOf(paramInt)))
          {
            parama.seek(paramInt);
            if (this.zc[4].isEmpty())
            {
              i = 4;
              break;
            }
            if (!this.zc[5].isEmpty()) {
              break label1251;
            }
            i = 5;
            break;
          }
          if (DEBUG)
          {
            AppMethodBeat.o(178739);
            return;
          }
        }
      }
      AppMethodBeat.o(178739);
      return;
      m = n;
      break label230;
    }
  }
  
  private void b(a parama, HashMap paramHashMap)
  {
    AppMethodBeat.i(178742);
    Object localObject1 = (c)paramHashMap.get("StripOffsets");
    Object localObject2 = (c)paramHashMap.get("StripByteCounts");
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramHashMap = h(((c)localObject1).a(this.ze));
      localObject1 = h(((c)localObject2).a(this.ze));
      if (paramHashMap == null)
      {
        AppMethodBeat.o(178742);
        return;
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(178742);
        return;
      }
      long l = 0L;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        l += localObject1[i];
        i += 1;
      }
      localObject2 = new byte[(int)l];
      i = 0;
      j = 0;
      int k = 0;
      while (i < paramHashMap.length)
      {
        int n = (int)paramHashMap[i];
        int m = (int)localObject1[i];
        n -= k;
        parama.seek(n);
        byte[] arrayOfByte = new byte[m];
        parama.read(arrayOfByte);
        k = k + n + m;
        System.arraycopy(arrayOfByte, 0, localObject2, j, arrayOfByte.length);
        j += arrayOfByte.length;
        i += 1;
      }
      this.zf = true;
      this.zj = ((byte[])localObject2);
      this.zi = localObject2.length;
    }
    AppMethodBeat.o(178742);
  }
  
  private static void b(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(178750);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        Os.close(paramFileDescriptor);
        AppMethodBeat.o(178750);
        return;
      }
      catch (Exception paramFileDescriptor) {}
    }
    AppMethodBeat.o(178750);
  }
  
  private void b(InputStream paramInputStream)
  {
    AppMethodBeat.i(178721);
    if (paramInputStream == null)
    {
      paramInputStream = new NullPointerException("inputstream shouldn't be null");
      AppMethodBeat.o(178721);
      throw paramInputStream;
    }
    int i = 0;
    Object localObject2;
    final a locala;
    try
    {
      while (i < aBi.length)
      {
        this.zc[i] = new HashMap();
        i += 1;
      }
      paramInputStream = new BufferedInputStream(paramInputStream, 5000);
      localObject2 = (BufferedInputStream)paramInputStream;
      ((BufferedInputStream)localObject2).mark(5000);
      localObject1 = new byte[5000];
      ((BufferedInputStream)localObject2).read((byte[])localObject1);
      ((BufferedInputStream)localObject2).reset();
      if (!f((byte[])localObject1)) {
        break label302;
      }
      i = 4;
      this.zb = i;
      locala = new a(paramInputStream);
      switch (this.zb)
      {
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        label200:
        this.zq = false;
        label276:
        label302:
        return;
        label387:
        b(locala);
      }
    }
    finally
    {
      dC();
      if (!DEBUG) {
        break label500;
      }
      nt();
      label500:
      AppMethodBeat.o(178721);
    }
    paramInputStream = this.zc[4];
    Object localObject1 = (c)paramInputStream.get("Compression");
    label617:
    int j;
    if (localObject1 != null)
    {
      this.zk = ((c)localObject1).b(this.ze);
      switch (this.zk)
      {
      case 6: 
        for (;;)
        {
          this.zq = true;
          dC();
          if (!DEBUG) {
            break label1632;
          }
          nt();
          AppMethodBeat.o(178721);
          return;
          if (g((byte[])localObject1))
          {
            i = 9;
            break;
          }
          if (h((byte[])localObject1))
          {
            i = 12;
            break;
          }
          localObject2 = new a((byte[])localObject1);
          this.ze = c((a)localObject2);
          ((a)localObject2).zv = this.ze;
          i = ((a)localObject2).readShort();
          ((a)localObject2).close();
          if (i == 20306) {
            break label1650;
          }
          if (i != 21330) {
            break label1662;
          }
          break label1650;
          localObject1 = new a((byte[])localObject1);
          this.ze = c((a)localObject1);
          ((a)localObject1).zv = this.ze;
          i = ((a)localObject1).readShort();
          ((a)localObject1).close();
          if (i != 85) {
            break label1677;
          }
          i = 1;
          break label1667;
          a(locala, 0, 0);
          break label200;
          MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
          for (;;)
          {
            String str2;
            try
            {
              if (Build.VERSION.SDK_INT >= 23)
              {
                localMediaMetadataRetriever.setDataSource(new MediaDataSource()
                {
                  long mPosition;
                  
                  public final void close() {}
                  
                  public final long getSize()
                  {
                    return -1L;
                  }
                  
                  public final int readAt(long paramAnonymousLong, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
                  {
                    AppMethodBeat.i(178668);
                    if (paramAnonymousInt2 == 0)
                    {
                      AppMethodBeat.o(178668);
                      return 0;
                    }
                    if (paramAnonymousLong < 0L)
                    {
                      AppMethodBeat.o(178668);
                      return -1;
                    }
                    try
                    {
                      if (this.mPosition != paramAnonymousLong)
                      {
                        if (this.mPosition >= 0L)
                        {
                          long l = this.mPosition;
                          i = locala.available();
                          if (paramAnonymousLong >= l + i)
                          {
                            AppMethodBeat.o(178668);
                            return -1;
                          }
                        }
                        locala.seek(paramAnonymousLong);
                        this.mPosition = paramAnonymousLong;
                      }
                      int i = paramAnonymousInt2;
                      if (paramAnonymousInt2 > locala.available()) {
                        i = locala.available();
                      }
                      paramAnonymousInt1 = locala.read(paramAnonymousArrayOfByte, paramAnonymousInt1, i);
                      if (paramAnonymousInt1 >= 0)
                      {
                        this.mPosition += paramAnonymousInt1;
                        AppMethodBeat.o(178668);
                        return paramAnonymousInt1;
                      }
                    }
                    catch (IOException paramAnonymousArrayOfByte)
                    {
                      this.mPosition = -1L;
                      AppMethodBeat.o(178668);
                    }
                    return -1;
                  }
                });
                localObject3 = localMediaMetadataRetriever.extractMetadata(33);
                String str1 = localMediaMetadataRetriever.extractMetadata(34);
                paramInputStream = localMediaMetadataRetriever.extractMetadata(26);
                str2 = localMediaMetadataRetriever.extractMetadata(17);
                localObject2 = null;
                localObject1 = null;
                if (!"yes".equals(paramInputStream)) {
                  break label847;
                }
                localObject2 = localMediaMetadataRetriever.extractMetadata(29);
                localObject1 = localMediaMetadataRetriever.extractMetadata(30);
                paramInputStream = localMediaMetadataRetriever.extractMetadata(31);
                if (localObject2 != null) {
                  this.zc[0].put("ImageWidth", c.b(Integer.parseInt((String)localObject2), this.ze));
                }
                if (localObject1 != null) {
                  this.zc[0].put("ImageLength", c.b(Integer.parseInt((String)localObject1), this.ze));
                }
                if (paramInputStream != null) {
                  i = 1;
                }
                switch (Integer.parseInt(paramInputStream))
                {
                default: 
                  this.zc[0].put("Orientation", c.b(i, this.ze));
                  if ((localObject3 == null) || (str1 == null)) {
                    break label1008;
                  }
                  i = Integer.parseInt((String)localObject3);
                  j = Integer.parseInt(str1);
                  if (j > 6) {
                    break label887;
                  }
                  paramInputStream = new IOException("Invalid exif length");
                  AppMethodBeat.o(178721);
                  throw paramInputStream;
                }
              }
            }
            finally
            {
              localMediaMetadataRetriever.release();
              AppMethodBeat.o(178721);
            }
            if (this.aBn != null)
            {
              localMediaMetadataRetriever.setDataSource(this.aBn);
            }
            else if (this.yZ != null)
            {
              localMediaMetadataRetriever.setDataSource(this.yZ);
            }
            else
            {
              localMediaMetadataRetriever.release();
              break;
              if (!"yes".equals(str2)) {
                break label1639;
              }
              localObject2 = localMediaMetadataRetriever.extractMetadata(18);
              localObject1 = localMediaMetadataRetriever.extractMetadata(19);
              paramInputStream = localMediaMetadataRetriever.extractMetadata(24);
            }
          }
          locala.seek(i);
          Object localObject3 = new byte[6];
          if (locala.read((byte[])localObject3) != 6)
          {
            paramInputStream = new IOException("Can't read identifier");
            AppMethodBeat.o(178721);
            throw paramInputStream;
          }
          i = j - 6;
          if (!Arrays.equals((byte[])localObject3, yY))
          {
            paramInputStream = new IOException("Invalid identifier");
            AppMethodBeat.o(178721);
            throw paramInputStream;
          }
          localObject3 = new byte[i];
          if (locala.read((byte[])localObject3) != i)
          {
            paramInputStream = new IOException("Can't read exif");
            AppMethodBeat.o(178721);
            throw paramInputStream;
          }
          b((byte[])localObject3, 0);
          if (DEBUG) {
            new StringBuilder("Heif meta: ").append((String)localObject2).append("x").append((String)localObject1).append(", rotation ").append(paramInputStream);
          }
          localMediaMetadataRetriever.release();
          break label200;
          a(locala);
          paramInputStream = (c)this.zc[1].get("MakerNote");
          if (paramInputStream == null) {
            break label200;
          }
          paramInputStream = new a(paramInputStream.zy);
          paramInputStream.zv = this.ze;
          localObject1 = new byte[yA.length];
          paramInputStream.readFully((byte[])localObject1);
          paramInputStream.seek(0L);
          localObject2 = new byte[yB.length];
          paramInputStream.readFully((byte[])localObject2);
          if (Arrays.equals((byte[])localObject1, yA)) {
            paramInputStream.seek(8L);
          }
          for (;;)
          {
            b(paramInputStream, 6);
            paramInputStream = (c)this.zc[7].get("PreviewImageStart");
            localObject1 = (c)this.zc[7].get("PreviewImageLength");
            if ((paramInputStream != null) && (localObject1 != null))
            {
              this.zc[5].put("JPEGInterchangeFormat", paramInputStream);
              this.zc[5].put("JPEGInterchangeFormatLength", localObject1);
            }
            paramInputStream = (c)this.zc[8].get("AspectFrame");
            if (paramInputStream == null) {
              break;
            }
            paramInputStream = (int[])paramInputStream.a(this.ze);
            if ((paramInputStream != null) && (paramInputStream.length == 4)) {
              break label1707;
            }
            new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString(paramInputStream));
            break;
            if (Arrays.equals((byte[])localObject2, yB)) {
              paramInputStream.seek(12L);
            }
          }
          paramInputStream = c.b(j, this.ze);
          localObject1 = c.b(i, this.ze);
          this.zc[0].put("ImageWidth", paramInputStream);
          this.zc[0].put("ImageLength", localObject1);
          break label200;
          a(locala);
          if ((c)this.zc[0].get("JpgFromRaw") != null) {
            a(locala, this.zp, 5);
          }
          paramInputStream = (c)this.zc[0].get("ISO");
          localObject1 = (c)this.zc[1].get("PhotographicSensitivity");
          if ((paramInputStream == null) || (localObject1 != null)) {
            break label200;
          }
          this.zc[1].put("PhotographicSensitivity", paramInputStream);
          break label200;
          a(locala);
          break label200;
          a(locala, paramInputStream);
        }
      case 1: 
      case 7: 
        label720:
        label887:
        localObject1 = (c)paramInputStream.get("BitsPerSample");
        label847:
        label1008:
        if (localObject1 != null)
        {
          localObject1 = (int[])((c)localObject1).a(this.ze);
          if (Arrays.equals(yw, (int[])localObject1)) {
            i = 1;
          }
        }
        label1324:
        break;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label276;
      }
      b(locala, paramInputStream);
      break label276;
      if (this.zb == 3)
      {
        localObject2 = (c)paramInputStream.get("PhotometricInterpretation");
        if (localObject2 != null)
        {
          i = ((c)localObject2).b(this.ze);
          if ((i != 1) || (!Arrays.equals((int[])localObject1, yy)))
          {
            if ((i != 6) || (!Arrays.equals((int[])localObject1, yw))) {
              break label1783;
            }
            break label1778;
            this.zk = 6;
            a(locala, paramInputStream);
            break label276;
            label1632:
            AppMethodBeat.o(178721);
            return;
            label1639:
            paramInputStream = null;
            break label617;
            break label200;
            break label276;
            label1650:
            label1662:
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1665;
              }
              i = 7;
              break;
            }
            label1665:
            break label387;
            for (;;)
            {
              label1667:
              if (i == 0) {
                break label1682;
              }
              i = 10;
              break;
              label1677:
              i = 0;
            }
            label1682:
            i = 0;
            break;
            break label720;
            i = 6;
            break label720;
            i = 3;
            break label720;
            i = 8;
            break label720;
            label1707:
            if ((paramInputStream[2] <= paramInputStream[0]) || (paramInputStream[3] <= paramInputStream[1])) {
              break label200;
            }
            int m = paramInputStream[2] - paramInputStream[0] + 1;
            int k = paramInputStream[3] - paramInputStream[1] + 1;
            i = k;
            j = m;
            if (m >= k) {
              break label1324;
            }
            j = m + k;
            i = j - k;
            j -= i;
            break label1324;
          }
          label1778:
          i = 1;
          continue;
        }
      }
      label1783:
      i = 0;
    }
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(178735);
    a locala = new a(paramArrayOfByte);
    a(locala, paramArrayOfByte.length);
    b(locala, paramInt);
    AppMethodBeat.o(178735);
  }
  
  private static double c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178728);
    try
    {
      paramString1 = paramString1.split(",", -1);
      String[] arrayOfString = paramString1[0].split("/", -1);
      double d1 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      arrayOfString = paramString1[1].split("/", -1);
      double d3 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      paramString1 = paramString1[2].split("/", -1);
      double d2 = Double.parseDouble(paramString1[0].trim()) / Double.parseDouble(paramString1[1].trim());
      d3 /= 60.0D;
      d1 = d2 / 3600.0D + (d1 + d3);
      boolean bool;
      if (!paramString2.equals("S"))
      {
        bool = paramString2.equals("W");
        if (!bool) {}
      }
      else
      {
        d1 = -d1;
        AppMethodBeat.o(178728);
        return d1;
      }
      if (!paramString2.equals("N"))
      {
        bool = paramString2.equals("E");
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(178728);
        return d1;
      }
      paramString1 = new IllegalArgumentException();
      AppMethodBeat.o(178728);
      throw paramString1;
    }
    catch (NumberFormatException paramString1)
    {
      paramString1 = new IllegalArgumentException();
      AppMethodBeat.o(178728);
      throw paramString1;
    }
    catch (ArrayIndexOutOfBoundsException paramString1)
    {
      label220:
      break label220;
    }
  }
  
  private static ByteOrder c(a parama)
  {
    AppMethodBeat.i(178737);
    int i = parama.readShort();
    switch (i)
    {
    default: 
      parama = new IOException("Invalid byte order: " + Integer.toHexString(i));
      AppMethodBeat.o(178737);
      throw parama;
    case 18761: 
      parama = ByteOrder.LITTLE_ENDIAN;
      AppMethodBeat.o(178737);
      return parama;
    }
    parama = ByteOrder.BIG_ENDIAN;
    AppMethodBeat.o(178737);
    return parama;
  }
  
  private void c(a parama, int paramInt)
  {
    AppMethodBeat.i(178740);
    c localc1 = (c)this.zc[paramInt].get("ImageLength");
    c localc2 = (c)this.zc[paramInt].get("ImageWidth");
    if ((localc1 == null) || (localc2 == null))
    {
      localc1 = (c)this.zc[paramInt].get("JPEGInterchangeFormat");
      if (localc1 != null) {
        a(parama, localc1.b(this.ze), paramInt);
      }
    }
    AppMethodBeat.o(178740);
  }
  
  private static boolean c(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {}
    while (paramArrayOfByte1.length < paramArrayOfByte2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label37;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label37:
    return true;
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(178749);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(178749);
        return;
      }
      catch (RuntimeException paramCloseable)
      {
        AppMethodBeat.o(178749);
        throw paramCloseable;
      }
      catch (Exception paramCloseable) {}
    }
    AppMethodBeat.o(178749);
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(178751);
    byte[] arrayOfByte = new byte[8192];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      i += j;
      paramOutputStream.write(arrayOfByte, 0, j);
    }
    AppMethodBeat.o(178751);
    return i;
  }
  
  private void d(a parama, int paramInt)
  {
    AppMethodBeat.i(178745);
    c localc1 = (c)this.zc[paramInt].get("DefaultCropSize");
    c localc2 = (c)this.zc[paramInt].get("SensorTopBorder");
    c localc3 = (c)this.zc[paramInt].get("SensorLeftBorder");
    c localc4 = (c)this.zc[paramInt].get("SensorBottomBorder");
    c localc5 = (c)this.zc[paramInt].get("SensorRightBorder");
    if (localc1 != null)
    {
      if (localc1.format == 5)
      {
        parama = (e[])localc1.a(this.ze);
        if ((parama == null) || (parama.length != 2))
        {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(parama));
          AppMethodBeat.o(178745);
          return;
        }
        localc1 = c.a(parama[0], this.ze);
      }
      for (parama = c.a(parama[1], this.ze);; parama = c.b(parama[1], this.ze))
      {
        this.zc[paramInt].put("ImageWidth", localc1);
        this.zc[paramInt].put("ImageLength", parama);
        AppMethodBeat.o(178745);
        return;
        parama = (int[])localc1.a(this.ze);
        if ((parama == null) || (parama.length != 2))
        {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(parama));
          AppMethodBeat.o(178745);
          return;
        }
        localc1 = c.b(parama[0], this.ze);
      }
    }
    if ((localc2 != null) && (localc3 != null) && (localc4 != null) && (localc5 != null))
    {
      int i = localc2.b(this.ze);
      int j = localc4.b(this.ze);
      int k = localc5.b(this.ze);
      int m = localc3.b(this.ze);
      if ((j > i) && (k > m))
      {
        parama = c.b(j - i, this.ze);
        localc1 = c.b(k - m, this.ze);
        this.zc[paramInt].put("ImageLength", parama);
        this.zc[paramInt].put("ImageWidth", localc1);
      }
      AppMethodBeat.o(178745);
      return;
    }
    c(parama, paramInt);
    AppMethodBeat.o(178745);
  }
  
  private void dC()
  {
    AppMethodBeat.i(178736);
    String str = getAttribute("DateTimeOriginal");
    if ((str != null) && (getAttribute("DateTime") == null)) {
      this.zc[0].put("DateTime", c.L(str));
    }
    if (getAttribute("ImageWidth") == null) {
      this.zc[0].put("ImageWidth", c.b(0L, this.ze));
    }
    if (getAttribute("ImageLength") == null) {
      this.zc[0].put("ImageLength", c.b(0L, this.ze));
    }
    if (getAttribute("Orientation") == null) {
      this.zc[0].put("Orientation", c.b(0L, this.ze));
    }
    if (getAttribute("LightSource") == null) {
      this.zc[1].put("LightSource", c.b(0L, this.ze));
    }
    AppMethodBeat.o(178736);
  }
  
  private void dD()
  {
    AppMethodBeat.i(178744);
    t(0, 5);
    t(0, 4);
    t(5, 4);
    c localc1 = (c)this.zc[1].get("PixelXDimension");
    c localc2 = (c)this.zc[1].get("PixelYDimension");
    if ((localc1 != null) && (localc2 != null))
    {
      this.zc[0].put("ImageWidth", localc1);
      this.zc[0].put("ImageLength", localc2);
    }
    if ((this.zc[4].isEmpty()) && (a(this.zc[5])))
    {
      this.zc[4] = this.zc[5];
      this.zc[5] = new HashMap();
    }
    a(this.zc[4]);
    AppMethodBeat.o(178744);
  }
  
  private static boolean f(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < yz.length)
    {
      if (paramArrayOfByte[i] != yz[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(178729);
    byte[] arrayOfByte = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
    int i = 0;
    while (i < arrayOfByte.length)
    {
      if (paramArrayOfByte[i] != arrayOfByte[i])
      {
        AppMethodBeat.o(178729);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(178729);
    return true;
  }
  
  /* Error */
  private byte[] getThumbnailBytes()
  {
    // Byte code:
    //   0: ldc_w 1328
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 787	androidx/a/a/a:zf	Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 1328
    //   16: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: getfield 1001	androidx/a/a/a:zj	[B
    //   25: ifnull +16 -> 41
    //   28: aload_0
    //   29: getfield 1001	androidx/a/a/a:zj	[B
    //   32: astore_1
    //   33: ldc_w 1328
    //   36: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield 715	androidx/a/a/a:za	Landroid/content/res/AssetManager$AssetInputStream;
    //   45: ifnull +84 -> 129
    //   48: aload_0
    //   49: getfield 715	androidx/a/a/a:za	Landroid/content/res/AssetManager$AssetInputStream;
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 1331	java/io/InputStream:markSupported	()Z
    //   57: ifeq +60 -> 117
    //   60: aload_2
    //   61: invokevirtual 1332	java/io/InputStream:reset	()V
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: astore_2
    //   70: aload_1
    //   71: ifnonnull +130 -> 201
    //   74: new 1334	java/io/FileNotFoundException
    //   77: dup
    //   78: invokespecial 1335	java/io/FileNotFoundException:<init>	()V
    //   81: astore_3
    //   82: ldc_w 1328
    //   85: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_3
    //   89: athrow
    //   90: astore_3
    //   91: aload_2
    //   92: astore_3
    //   93: aload_1
    //   94: astore_2
    //   95: aload_3
    //   96: astore_1
    //   97: aload_2
    //   98: invokestatic 736	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokestatic 1337	androidx/a/a/a:b	(Ljava/io/FileDescriptor;)V
    //   109: ldc_w 1328
    //   112: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aconst_null
    //   116: areturn
    //   117: aload_2
    //   118: invokestatic 736	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   121: ldc_w 1328
    //   124: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: aload_0
    //   130: getfield 711	androidx/a/a/a:yZ	Ljava/lang/String;
    //   133: ifnull +20 -> 153
    //   136: new 721	java/io/FileInputStream
    //   139: dup
    //   140: aload_0
    //   141: getfield 711	androidx/a/a/a:yZ	Ljava/lang/String;
    //   144: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -80 -> 70
    //   153: getstatic 1011	android/os/Build$VERSION:SDK_INT	I
    //   156: bipush 21
    //   158: if_icmplt +220 -> 378
    //   161: aload_0
    //   162: getfield 717	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   165: ifnull +213 -> 378
    //   168: aload_0
    //   169: getfield 717	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   172: invokestatic 1341	android/system/Os:dup	(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;
    //   175: astore_1
    //   176: aload_1
    //   177: lconst_0
    //   178: getstatic 1344	android/system/OsConstants:SEEK_SET	I
    //   181: invokestatic 1022	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   184: pop2
    //   185: new 721	java/io/FileInputStream
    //   188: dup
    //   189: aload_1
    //   190: invokespecial 1346	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   193: astore_3
    //   194: aload_1
    //   195: astore_2
    //   196: aload_3
    //   197: astore_1
    //   198: goto -128 -> 70
    //   201: aload_1
    //   202: aload_0
    //   203: getfield 808	androidx/a/a/a:zg	I
    //   206: i2l
    //   207: invokevirtual 1350	java/io/InputStream:skip	(J)J
    //   210: aload_0
    //   211: getfield 808	androidx/a/a/a:zg	I
    //   214: i2l
    //   215: lcmp
    //   216: ifeq +49 -> 265
    //   219: new 881	java/io/IOException
    //   222: dup
    //   223: ldc_w 1352
    //   226: invokespecial 899	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   229: astore_3
    //   230: ldc_w 1328
    //   233: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_3
    //   237: athrow
    //   238: astore 4
    //   240: aload_2
    //   241: astore_3
    //   242: aload 4
    //   244: astore_2
    //   245: aload_1
    //   246: invokestatic 736	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   249: aload_3
    //   250: ifnull +7 -> 257
    //   253: aload_3
    //   254: invokestatic 1337	androidx/a/a/a:b	(Ljava/io/FileDescriptor;)V
    //   257: ldc_w 1328
    //   260: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_2
    //   264: athrow
    //   265: aload_0
    //   266: getfield 789	androidx/a/a/a:zi	I
    //   269: newarray byte
    //   271: astore_3
    //   272: aload_1
    //   273: aload_3
    //   274: invokevirtual 1296	java/io/InputStream:read	([B)I
    //   277: aload_0
    //   278: getfield 789	androidx/a/a/a:zi	I
    //   281: if_icmpeq +22 -> 303
    //   284: new 881	java/io/IOException
    //   287: dup
    //   288: ldc_w 1352
    //   291: invokespecial 899	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   294: astore_3
    //   295: ldc_w 1328
    //   298: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_3
    //   302: athrow
    //   303: aload_0
    //   304: aload_3
    //   305: putfield 1001	androidx/a/a/a:zj	[B
    //   308: aload_1
    //   309: invokestatic 736	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   312: aload_2
    //   313: ifnull +7 -> 320
    //   316: aload_2
    //   317: invokestatic 1337	androidx/a/a/a:b	(Ljava/io/FileDescriptor;)V
    //   320: ldc_w 1328
    //   323: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_3
    //   327: areturn
    //   328: astore_2
    //   329: aconst_null
    //   330: astore_3
    //   331: aconst_null
    //   332: astore_1
    //   333: goto -88 -> 245
    //   336: astore_3
    //   337: aconst_null
    //   338: astore 4
    //   340: aload_2
    //   341: astore_1
    //   342: aload_3
    //   343: astore_2
    //   344: aload 4
    //   346: astore_3
    //   347: goto -102 -> 245
    //   350: astore_2
    //   351: aload_1
    //   352: astore_3
    //   353: aconst_null
    //   354: astore_1
    //   355: goto -110 -> 245
    //   358: astore_1
    //   359: aconst_null
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_2
    //   363: goto -266 -> 97
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_1
    //   369: goto -272 -> 97
    //   372: astore_2
    //   373: aconst_null
    //   374: astore_2
    //   375: goto -278 -> 97
    //   378: aconst_null
    //   379: astore_2
    //   380: aconst_null
    //   381: astore_1
    //   382: goto -312 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	a
    //   32	323	1	localObject1	Object
    //   358	1	1	localException1	Exception
    //   360	1	1	localObject2	Object
    //   366	1	1	localException2	Exception
    //   368	14	1	localObject3	Object
    //   52	265	2	localObject4	Object
    //   328	13	2	localObject5	Object
    //   343	1	2	localObject6	Object
    //   350	1	2	localObject7	Object
    //   362	1	2	localObject8	Object
    //   372	1	2	localException3	Exception
    //   374	6	2	localObject9	Object
    //   65	24	3	localFileNotFoundException	java.io.FileNotFoundException
    //   90	1	3	localException4	Exception
    //   92	239	3	localObject10	Object
    //   336	7	3	localObject11	Object
    //   346	7	3	localObject12	Object
    //   238	5	4	localObject13	Object
    //   338	7	4	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   74	90	90	java/lang/Exception
    //   201	238	90	java/lang/Exception
    //   265	303	90	java/lang/Exception
    //   303	308	90	java/lang/Exception
    //   74	90	238	finally
    //   201	238	238	finally
    //   265	303	238	finally
    //   303	308	238	finally
    //   41	53	328	finally
    //   129	148	328	finally
    //   153	176	328	finally
    //   53	64	336	finally
    //   176	194	350	finally
    //   41	53	358	java/lang/Exception
    //   129	148	358	java/lang/Exception
    //   153	176	358	java/lang/Exception
    //   53	64	366	java/lang/Exception
    //   176	194	372	java/lang/Exception
  }
  
  /* Error */
  private static boolean h(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 1353
    //   3: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: new 8	androidx/a/a/a$a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 865	androidx/a/a/a$a:<init>	([B)V
    //   17: astore_0
    //   18: aload_0
    //   19: getstatic 702	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   22: putfield 866	androidx/a/a/a$a:zv	Ljava/nio/ByteOrder;
    //   25: aload_0
    //   26: invokevirtual 902	androidx/a/a/a$a:readInt	()I
    //   29: i2l
    //   30: lstore 10
    //   32: iconst_4
    //   33: newarray byte
    //   35: astore 13
    //   37: aload_0
    //   38: aload 13
    //   40: invokevirtual 963	androidx/a/a/a$a:read	([B)I
    //   43: pop
    //   44: aload 13
    //   46: getstatic 157	androidx/a/a/a:aAV	[B
    //   49: invokestatic 1209	java/util/Arrays:equals	([B[B)Z
    //   52: istore 12
    //   54: iload 12
    //   56: ifne +15 -> 71
    //   59: aload_0
    //   60: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   63: ldc_w 1353
    //   66: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: ldc2_w 1222
    //   74: lstore 8
    //   76: lload 10
    //   78: lstore 6
    //   80: lload 10
    //   82: lconst_1
    //   83: lcmp
    //   84: ifne +35 -> 119
    //   87: aload_0
    //   88: invokevirtual 1356	androidx/a/a/a$a:readLong	()J
    //   91: lstore 6
    //   93: lload 6
    //   95: ldc2_w 1357
    //   98: lcmp
    //   99: ifge +15 -> 114
    //   102: aload_0
    //   103: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   106: ldc_w 1353
    //   109: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: ldc2_w 1357
    //   117: lstore 8
    //   119: lload 6
    //   121: lstore 10
    //   123: lload 6
    //   125: ldc2_w 1359
    //   128: lcmp
    //   129: ifle +8 -> 137
    //   132: ldc2_w 1359
    //   135: lstore 10
    //   137: lload 10
    //   139: lload 8
    //   141: lsub
    //   142: lstore 8
    //   144: lload 8
    //   146: ldc2_w 1222
    //   149: lcmp
    //   150: ifge +15 -> 165
    //   153: aload_0
    //   154: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   157: ldc_w 1353
    //   160: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_0
    //   164: ireturn
    //   165: iconst_4
    //   166: newarray byte
    //   168: astore 13
    //   170: iconst_0
    //   171: istore_1
    //   172: iconst_0
    //   173: istore_2
    //   174: lconst_0
    //   175: lstore 6
    //   177: lload 6
    //   179: lload 8
    //   181: ldc2_w 1055
    //   184: ldiv
    //   185: lcmp
    //   186: ifge +128 -> 314
    //   189: aload_0
    //   190: aload 13
    //   192: invokevirtual 963	androidx/a/a/a$a:read	([B)I
    //   195: istore_3
    //   196: iload_3
    //   197: iconst_4
    //   198: if_icmpeq +15 -> 213
    //   201: aload_0
    //   202: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   205: ldc_w 1353
    //   208: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: iload_2
    //   214: istore 4
    //   216: iload_1
    //   217: istore 5
    //   219: lload 6
    //   221: lconst_1
    //   222: lcmp
    //   223: ifeq +76 -> 299
    //   226: aload 13
    //   228: getstatic 162	androidx/a/a/a:aAW	[B
    //   231: invokestatic 1209	java/util/Arrays:equals	([B[B)Z
    //   234: istore 12
    //   236: iload 12
    //   238: ifeq +37 -> 275
    //   241: iconst_1
    //   242: istore_3
    //   243: iload_2
    //   244: istore 4
    //   246: iload_3
    //   247: istore 5
    //   249: iload_3
    //   250: ifeq +49 -> 299
    //   253: iload_2
    //   254: istore 4
    //   256: iload_3
    //   257: istore 5
    //   259: iload_2
    //   260: ifeq +39 -> 299
    //   263: aload_0
    //   264: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   267: ldc_w 1353
    //   270: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: iconst_1
    //   274: ireturn
    //   275: aload 13
    //   277: getstatic 167	androidx/a/a/a:aAX	[B
    //   280: invokestatic 1209	java/util/Arrays:equals	([B[B)Z
    //   283: istore 12
    //   285: iload_1
    //   286: istore_3
    //   287: iload 12
    //   289: ifeq -46 -> 243
    //   292: iconst_1
    //   293: istore_2
    //   294: iload_1
    //   295: istore_3
    //   296: goto -53 -> 243
    //   299: lload 6
    //   301: lconst_1
    //   302: ladd
    //   303: lstore 6
    //   305: iload 4
    //   307: istore_2
    //   308: iload 5
    //   310: istore_1
    //   311: goto -134 -> 177
    //   314: aload_0
    //   315: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   318: ldc_w 1353
    //   321: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iconst_0
    //   325: ireturn
    //   326: astore_0
    //   327: aload 13
    //   329: astore_0
    //   330: aload_0
    //   331: ifnull -13 -> 318
    //   334: aload_0
    //   335: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   338: goto -20 -> 318
    //   341: astore 13
    //   343: aconst_null
    //   344: astore_0
    //   345: aload_0
    //   346: ifnull +7 -> 353
    //   349: aload_0
    //   350: invokevirtual 1175	androidx/a/a/a$a:close	()V
    //   353: ldc_w 1353
    //   356: invokestatic 687	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aload 13
    //   361: athrow
    //   362: astore 13
    //   364: goto -19 -> 345
    //   367: astore 13
    //   369: goto -39 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramArrayOfByte	byte[]
    //   171	140	1	i	int
    //   173	135	2	j	int
    //   195	101	3	k	int
    //   214	92	4	m	int
    //   217	92	5	n	int
    //   78	226	6	l1	long
    //   74	106	8	l2	long
    //   30	108	10	l3	long
    //   52	236	12	bool	boolean
    //   7	321	13	arrayOfByte	byte[]
    //   341	19	13	localObject1	Object
    //   362	1	13	localObject2	Object
    //   367	1	13	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	18	326	java/lang/Exception
    //   9	18	341	finally
    //   18	54	362	finally
    //   87	93	362	finally
    //   165	170	362	finally
    //   177	196	362	finally
    //   226	236	362	finally
    //   275	285	362	finally
    //   18	54	367	java/lang/Exception
    //   87	93	367	java/lang/Exception
    //   165	170	367	java/lang/Exception
    //   177	196	367	java/lang/Exception
    //   226	236	367	java/lang/Exception
    //   275	285	367	java/lang/Exception
  }
  
  private static long[] h(Object paramObject)
  {
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      long[] arrayOfLong = new long[paramObject.length];
      int i = 0;
      while (i < paramObject.length)
      {
        arrayOfLong[i] = paramObject[i];
        i += 1;
      }
      return arrayOfLong;
    }
    if ((paramObject instanceof long[])) {
      return (long[])paramObject;
    }
    return null;
  }
  
  private void nt()
  {
    AppMethodBeat.i(178723);
    int i = 0;
    while (i < this.zc.length)
    {
      new StringBuilder("The size of tag group[").append(i).append("]: ").append(this.zc[i].size());
      Iterator localIterator = this.zc[i].entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        c localc = (c)localEntry.getValue();
        new StringBuilder("tagName: ").append((String)localEntry.getKey()).append(", tagType: ").append(localc.toString()).append(", tagValue: '").append(localc.c(this.ze)).append("'");
      }
      i += 1;
    }
    AppMethodBeat.o(178723);
  }
  
  private void removeAttribute(String paramString)
  {
    AppMethodBeat.i(178720);
    int i = 0;
    while (i < aBi.length)
    {
      this.zc[i].remove(paramString);
      i += 1;
    }
    AppMethodBeat.o(178720);
  }
  
  private void t(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178748);
    if ((this.zc[paramInt1].isEmpty()) || (this.zc[paramInt2].isEmpty()))
    {
      AppMethodBeat.o(178748);
      return;
    }
    Object localObject1 = (c)this.zc[paramInt1].get("ImageLength");
    Object localObject2 = (c)this.zc[paramInt1].get("ImageWidth");
    c localc1 = (c)this.zc[paramInt2].get("ImageLength");
    c localc2 = (c)this.zc[paramInt2].get("ImageWidth");
    if ((localObject1 == null) || (localObject2 == null))
    {
      if (DEBUG) {
        AppMethodBeat.o(178748);
      }
    }
    else if ((localc1 == null) || (localc2 == null))
    {
      if (DEBUG) {
        AppMethodBeat.o(178748);
      }
    }
    else
    {
      int i = ((c)localObject1).b(this.ze);
      int j = ((c)localObject2).b(this.ze);
      int k = localc1.b(this.ze);
      int m = localc2.b(this.ze);
      if ((i < k) && (j < m))
      {
        localObject1 = this.zc[paramInt1];
        localObject2 = this.zc;
        localObject2[paramInt1] = localObject2[paramInt2];
        this.zc[paramInt2] = localObject1;
      }
    }
    AppMethodBeat.o(178748);
  }
  
  public final void K(String paramString)
  {
    AppMethodBeat.i(188601);
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString)) {
      str = "PhotographicSensitivity";
    }
    int i = 0;
    while (i < aBi.length)
    {
      if (((i != 4) || (this.zf)) && ((d)yU[i].get(str) != null)) {
        this.zc[i].remove(str);
      }
      i += 1;
    }
    AppMethodBeat.o(188601);
  }
  
  public final void b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(178734);
    if (DEBUG) {
      new StringBuilder("saveJpegAttributes starting with (inputStream: ").append(paramInputStream).append(", outputStream: ").append(paramOutputStream).append(")");
    }
    paramInputStream = new DataInputStream(paramInputStream);
    paramOutputStream = new b(paramOutputStream, ByteOrder.BIG_ENDIAN);
    if (paramInputStream.readByte() != -1)
    {
      paramInputStream = new IOException("Invalid marker");
      AppMethodBeat.o(178734);
      throw paramInputStream;
    }
    paramOutputStream.writeByte(-1);
    if (paramInputStream.readByte() != -40)
    {
      paramInputStream = new IOException("Invalid marker");
      AppMethodBeat.o(178734);
      throw paramInputStream;
    }
    paramOutputStream.writeByte(-40);
    paramOutputStream.writeByte(-1);
    paramOutputStream.writeByte(-31);
    a(paramOutputStream);
    byte[] arrayOfByte1 = new byte[4096];
    label541:
    for (;;)
    {
      if (paramInputStream.readByte() != -1)
      {
        paramInputStream = new IOException("Invalid marker");
        AppMethodBeat.o(178734);
        throw paramInputStream;
      }
      int i = paramInputStream.readByte();
      int j;
      switch (i)
      {
      default: 
        paramOutputStream.writeByte(-1);
        paramOutputStream.writeByte(i);
        i = paramInputStream.readUnsignedShort();
        paramOutputStream.writeShort((short)i);
        j = i - 2;
        i = j;
        if (j < 0)
        {
          paramInputStream = new IOException("Invalid length");
          AppMethodBeat.o(178734);
          throw paramInputStream;
        }
      case -31: 
        j = paramInputStream.readUnsignedShort() - 2;
        if (j < 0)
        {
          paramInputStream = new IOException("Invalid length");
          AppMethodBeat.o(178734);
          throw paramInputStream;
        }
        byte[] arrayOfByte2 = new byte[6];
        if (j >= 6)
        {
          if (paramInputStream.read(arrayOfByte2) != 6)
          {
            paramInputStream = new IOException("Invalid exif");
            AppMethodBeat.o(178734);
            throw paramInputStream;
          }
          if (Arrays.equals(arrayOfByte2, yY))
          {
            if (paramInputStream.skipBytes(j - 6) == j - 6) {
              continue;
            }
            paramInputStream = new IOException("Invalid length");
            AppMethodBeat.o(178734);
            throw paramInputStream;
          }
        }
        paramOutputStream.writeByte(-1);
        paramOutputStream.writeByte(i);
        paramOutputStream.writeShort((short)(j + 2));
        i = j;
        if (j >= 6)
        {
          i = j - 6;
          paramOutputStream.write(arrayOfByte2);
        }
        while (i > 0)
        {
          j = paramInputStream.read(arrayOfByte1, 0, Math.min(i, 4096));
          if (j < 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte1, 0, j);
          i -= j;
        }
      case -39: 
      case -38: 
        paramOutputStream.writeByte(-1);
        paramOutputStream.writeByte(i);
        copy(paramInputStream, paramOutputStream);
        AppMethodBeat.o(178734);
        return;
        for (;;)
        {
          if (i <= 0) {
            break label541;
          }
          j = paramInputStream.read(arrayOfByte1, 0, Math.min(i, 4096));
          if (j < 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte1, 0, j);
          i -= j;
        }
      }
    }
  }
  
  public final String getAttribute(String paramString)
  {
    AppMethodBeat.i(178716);
    c localc = J(paramString);
    if (localc != null)
    {
      if (!yV.contains(paramString))
      {
        paramString = localc.c(this.ze);
        AppMethodBeat.o(178716);
        return paramString;
      }
      if (paramString.equals("GPSTimeStamp"))
      {
        if ((localc.format != 5) && (localc.format != 10))
        {
          new StringBuilder("GPS Timestamp format is not rational. format=").append(localc.format);
          AppMethodBeat.o(178716);
          return null;
        }
        paramString = (e[])localc.a(this.ze);
        if ((paramString == null) || (paramString.length != 3))
        {
          new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(paramString));
          AppMethodBeat.o(178716);
          return null;
        }
        paramString = String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)paramString[0].zB / (float)paramString[0].zC)), Integer.valueOf((int)((float)paramString[1].zB / (float)paramString[1].zC)), Integer.valueOf((int)((float)paramString[2].zB / (float)paramString[2].zC)) });
        AppMethodBeat.o(178716);
        return paramString;
      }
      try
      {
        paramString = Double.toString(localc.d(this.ze));
        AppMethodBeat.o(178716);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        AppMethodBeat.o(178716);
        return null;
      }
    }
    AppMethodBeat.o(178716);
    return null;
  }
  
  public final double getAttributeDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(178718);
    paramString = J(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178718);
      return paramDouble;
    }
    try
    {
      double d = paramString.d(this.ze);
      AppMethodBeat.o(178718);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(178718);
    }
    return paramDouble;
  }
  
  public final int getAttributeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(178717);
    paramString = J(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178717);
      return paramInt;
    }
    try
    {
      int i = paramString.b(this.ze);
      AppMethodBeat.o(178717);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(178717);
    }
    return paramInt;
  }
  
  public final byte[] getThumbnail()
  {
    AppMethodBeat.i(178725);
    if ((this.zk == 6) || (this.zk == 7))
    {
      byte[] arrayOfByte = getThumbnailBytes();
      AppMethodBeat.o(178725);
      return arrayOfByte;
    }
    AppMethodBeat.o(178725);
    return null;
  }
  
  public final double[] nu()
  {
    AppMethodBeat.i(178727);
    String str1 = getAttribute("GPSLatitude");
    String str2 = getAttribute("GPSLatitudeRef");
    String str3 = getAttribute("GPSLongitude");
    String str4 = getAttribute("GPSLongitudeRef");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null)) {
      try
      {
        double d1 = c(str1, str2);
        double d2 = c(str3, str4);
        AppMethodBeat.o(178727);
        return new double[] { d1, d2 };
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        new StringBuilder("Latitude/longitude values are not parsable. ").append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[] { str1, str2, str3, str4 }));
      }
    }
    AppMethodBeat.o(178727);
    return null;
  }
  
  static final class a
    extends InputStream
    implements DataInput
  {
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    final int mLength;
    int mPosition;
    private DataInputStream zu;
    ByteOrder zv;
    
    public a(InputStream paramInputStream)
    {
      AppMethodBeat.i(178669);
      this.zv = ByteOrder.BIG_ENDIAN;
      this.zu = new DataInputStream(paramInputStream);
      this.mLength = this.zu.available();
      this.mPosition = 0;
      this.zu.mark(this.mLength);
      AppMethodBeat.o(178669);
    }
    
    public a(byte[] paramArrayOfByte)
    {
      this(new ByteArrayInputStream(paramArrayOfByte));
      AppMethodBeat.i(178670);
      AppMethodBeat.o(178670);
    }
    
    public final int available()
    {
      AppMethodBeat.i(178672);
      int i = this.zu.available();
      AppMethodBeat.o(178672);
      return i;
    }
    
    public final long dE()
    {
      AppMethodBeat.i(178686);
      long l = readInt();
      AppMethodBeat.o(178686);
      return l & 0xFFFFFFFF;
    }
    
    public final int read()
    {
      AppMethodBeat.i(178673);
      this.mPosition += 1;
      int i = this.zu.read();
      AppMethodBeat.o(178673);
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(178674);
      paramInt1 = this.zu.read(paramArrayOfByte, paramInt1, paramInt2);
      this.mPosition += paramInt1;
      AppMethodBeat.o(178674);
      return paramInt1;
    }
    
    public final boolean readBoolean()
    {
      AppMethodBeat.i(178676);
      this.mPosition += 1;
      boolean bool = this.zu.readBoolean();
      AppMethodBeat.o(178676);
      return bool;
    }
    
    public final byte readByte()
    {
      AppMethodBeat.i(178681);
      this.mPosition += 1;
      EOFException localEOFException;
      if (this.mPosition > this.mLength)
      {
        localEOFException = new EOFException();
        AppMethodBeat.o(178681);
        throw localEOFException;
      }
      int i = this.zu.read();
      if (i < 0)
      {
        localEOFException = new EOFException();
        AppMethodBeat.o(178681);
        throw localEOFException;
      }
      byte b = (byte)i;
      AppMethodBeat.o(178681);
      return b;
    }
    
    public final char readChar()
    {
      AppMethodBeat.i(178677);
      this.mPosition += 2;
      char c = this.zu.readChar();
      AppMethodBeat.o(178677);
      return c;
    }
    
    public final double readDouble()
    {
      AppMethodBeat.i(178689);
      double d = Double.longBitsToDouble(readLong());
      AppMethodBeat.o(178689);
      return d;
    }
    
    public final float readFloat()
    {
      AppMethodBeat.i(178688);
      float f = Float.intBitsToFloat(readInt());
      AppMethodBeat.o(178688);
      return f;
    }
    
    public final void readFully(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(178680);
      this.mPosition += paramArrayOfByte.length;
      if (this.mPosition > this.mLength)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(178680);
        throw paramArrayOfByte;
      }
      if (this.zu.read(paramArrayOfByte, 0, paramArrayOfByte.length) != paramArrayOfByte.length)
      {
        paramArrayOfByte = new IOException("Couldn't read up to the length of buffer");
        AppMethodBeat.o(178680);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(178680);
    }
    
    public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(178679);
      this.mPosition += paramInt2;
      if (this.mPosition > this.mLength)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(178679);
        throw paramArrayOfByte;
      }
      if (this.zu.read(paramArrayOfByte, paramInt1, paramInt2) != paramInt2)
      {
        paramArrayOfByte = new IOException("Couldn't read up to the length of buffer");
        AppMethodBeat.o(178679);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(178679);
    }
    
    public final int readInt()
    {
      AppMethodBeat.i(178683);
      this.mPosition += 4;
      if (this.mPosition > this.mLength)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178683);
        throw ((Throwable)localObject);
      }
      int i = this.zu.read();
      int j = this.zu.read();
      int k = this.zu.read();
      int m = this.zu.read();
      if ((i | j | k | m) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178683);
        throw ((Throwable)localObject);
      }
      if (this.zv == LITTLE_ENDIAN)
      {
        AppMethodBeat.o(178683);
        return i + ((j << 8) + ((k << 16) + (m << 24)));
      }
      if (this.zv == BIG_ENDIAN)
      {
        AppMethodBeat.o(178683);
        return (i << 24) + (j << 16) + (k << 8) + m;
      }
      Object localObject = new IOException("Invalid byte order: " + this.zv);
      AppMethodBeat.o(178683);
      throw ((Throwable)localObject);
    }
    
    public final String readLine()
    {
      return null;
    }
    
    public final long readLong()
    {
      AppMethodBeat.i(178687);
      this.mPosition += 8;
      if (this.mPosition > this.mLength)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178687);
        throw ((Throwable)localObject);
      }
      int i = this.zu.read();
      int j = this.zu.read();
      int k = this.zu.read();
      int m = this.zu.read();
      int n = this.zu.read();
      int i1 = this.zu.read();
      int i2 = this.zu.read();
      int i3 = this.zu.read();
      if ((i | j | k | m | n | i1 | i2 | i3) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178687);
        throw ((Throwable)localObject);
      }
      long l1;
      long l2;
      long l3;
      long l4;
      long l5;
      long l6;
      long l7;
      long l8;
      if (this.zv == LITTLE_ENDIAN)
      {
        l1 = i3;
        l2 = i2;
        l3 = i1;
        l4 = n;
        l5 = m;
        l6 = k;
        l7 = j;
        l8 = i;
        AppMethodBeat.o(178687);
        return l8 + ((l6 << 16) + ((l4 << 32) + ((l2 << 48) + (l1 << 56) + (l3 << 40)) + (l5 << 24)) + (l7 << 8));
      }
      if (this.zv == BIG_ENDIAN)
      {
        l1 = i;
        l2 = j;
        l3 = k;
        l4 = m;
        l5 = n;
        l6 = i1;
        l7 = i2;
        l8 = i3;
        AppMethodBeat.o(178687);
        return (l2 << 48) + (l1 << 56) + (l3 << 40) + (l4 << 32) + (l5 << 24) + (l6 << 16) + (l7 << 8) + l8;
      }
      Object localObject = new IOException("Invalid byte order: " + this.zv);
      AppMethodBeat.o(178687);
      throw ((Throwable)localObject);
    }
    
    public final short readShort()
    {
      AppMethodBeat.i(178682);
      this.mPosition += 2;
      if (this.mPosition > this.mLength)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178682);
        throw ((Throwable)localObject);
      }
      int i = this.zu.read();
      int j = this.zu.read();
      if ((i | j) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178682);
        throw ((Throwable)localObject);
      }
      short s;
      if (this.zv == LITTLE_ENDIAN)
      {
        s = (short)(i + (j << 8));
        AppMethodBeat.o(178682);
        return s;
      }
      if (this.zv == BIG_ENDIAN)
      {
        s = (short)((i << 8) + j);
        AppMethodBeat.o(178682);
        return s;
      }
      Object localObject = new IOException("Invalid byte order: " + this.zv);
      AppMethodBeat.o(178682);
      throw ((Throwable)localObject);
    }
    
    public final String readUTF()
    {
      AppMethodBeat.i(178678);
      this.mPosition += 2;
      String str = this.zu.readUTF();
      AppMethodBeat.o(178678);
      return str;
    }
    
    public final int readUnsignedByte()
    {
      AppMethodBeat.i(178675);
      this.mPosition += 1;
      int i = this.zu.readUnsignedByte();
      AppMethodBeat.o(178675);
      return i;
    }
    
    public final int readUnsignedShort()
    {
      AppMethodBeat.i(178685);
      this.mPosition += 2;
      if (this.mPosition > this.mLength)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178685);
        throw ((Throwable)localObject);
      }
      int i = this.zu.read();
      int j = this.zu.read();
      if ((i | j) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178685);
        throw ((Throwable)localObject);
      }
      if (this.zv == LITTLE_ENDIAN)
      {
        AppMethodBeat.o(178685);
        return i + (j << 8);
      }
      if (this.zv == BIG_ENDIAN)
      {
        AppMethodBeat.o(178685);
        return (i << 8) + j;
      }
      Object localObject = new IOException("Invalid byte order: " + this.zv);
      AppMethodBeat.o(178685);
      throw ((Throwable)localObject);
    }
    
    public final void seek(long paramLong)
    {
      AppMethodBeat.i(178671);
      if (this.mPosition > paramLong)
      {
        this.mPosition = 0;
        this.zu.reset();
        this.zu.mark(this.mLength);
      }
      while (skipBytes((int)paramLong) != (int)paramLong)
      {
        IOException localIOException = new IOException("Couldn't seek up to the byteCount");
        AppMethodBeat.o(178671);
        throw localIOException;
        paramLong -= this.mPosition;
      }
      AppMethodBeat.o(178671);
    }
    
    public final int skipBytes(int paramInt)
    {
      AppMethodBeat.i(178684);
      int i = Math.min(paramInt, this.mLength - this.mPosition);
      paramInt = 0;
      while (paramInt < i) {
        paramInt += this.zu.skipBytes(i - paramInt);
      }
      this.mPosition += paramInt;
      AppMethodBeat.o(178684);
      return paramInt;
    }
  }
  
  static final class b
    extends FilterOutputStream
  {
    ByteOrder zv;
    private final OutputStream zw;
    
    public b(OutputStream paramOutputStream, ByteOrder paramByteOrder)
    {
      super();
      this.zw = paramOutputStream;
      this.zv = paramByteOrder;
    }
    
    public final void write(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(178690);
      this.zw.write(paramArrayOfByte);
      AppMethodBeat.o(178690);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(178691);
      this.zw.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(178691);
    }
    
    public final void writeByte(int paramInt)
    {
      AppMethodBeat.i(178692);
      this.zw.write(paramInt);
      AppMethodBeat.o(178692);
    }
    
    public final void writeInt(int paramInt)
    {
      AppMethodBeat.i(178694);
      if (this.zv == ByteOrder.LITTLE_ENDIAN)
      {
        this.zw.write(paramInt >>> 0 & 0xFF);
        this.zw.write(paramInt >>> 8 & 0xFF);
        this.zw.write(paramInt >>> 16 & 0xFF);
        this.zw.write(paramInt >>> 24 & 0xFF);
        AppMethodBeat.o(178694);
        return;
      }
      if (this.zv == ByteOrder.BIG_ENDIAN)
      {
        this.zw.write(paramInt >>> 24 & 0xFF);
        this.zw.write(paramInt >>> 16 & 0xFF);
        this.zw.write(paramInt >>> 8 & 0xFF);
        this.zw.write(paramInt >>> 0 & 0xFF);
      }
      AppMethodBeat.o(178694);
    }
    
    public final void writeShort(short paramShort)
    {
      AppMethodBeat.i(178693);
      if (this.zv == ByteOrder.LITTLE_ENDIAN)
      {
        this.zw.write(paramShort >>> 0 & 0xFF);
        this.zw.write(paramShort >>> 8 & 0xFF);
        AppMethodBeat.o(178693);
        return;
      }
      if (this.zv == ByteOrder.BIG_ENDIAN)
      {
        this.zw.write(paramShort >>> 8 & 0xFF);
        this.zw.write(paramShort >>> 0 & 0xFF);
      }
      AppMethodBeat.o(178693);
    }
  }
  
  static final class c
  {
    public final long aBr;
    public final int format;
    public final int zx;
    public final byte[] zy;
    
    c(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
    {
      this.format = paramInt1;
      this.zx = paramInt2;
      this.aBr = paramLong;
      this.zy = paramArrayOfByte;
    }
    
    private c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this(paramInt1, paramInt2, -1L, paramArrayOfByte);
    }
    
    public static c L(String paramString)
    {
      AppMethodBeat.i(178700);
      paramString = (paramString + '\000').getBytes(a.yX);
      paramString = new c(2, paramString.length, paramString);
      AppMethodBeat.o(178700);
      return paramString;
    }
    
    public static c a(a.e parame, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178702);
      parame = a(new a.e[] { parame }, paramByteOrder);
      AppMethodBeat.o(178702);
      return parame;
    }
    
    private static c a(a.e[] paramArrayOfe, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178701);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[5] * 1]);
      localByteBuffer.order(paramByteOrder);
      int i = 0;
      while (i <= 0)
      {
        paramByteOrder = paramArrayOfe[0];
        localByteBuffer.putInt((int)paramByteOrder.zB);
        localByteBuffer.putInt((int)paramByteOrder.zC);
        i += 1;
      }
      paramArrayOfe = new c(5, 1, localByteBuffer.array());
      AppMethodBeat.o(178701);
      return paramArrayOfe;
    }
    
    public static c b(int paramInt, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178696);
      paramByteOrder = c(new int[] { paramInt }, paramByteOrder);
      AppMethodBeat.o(178696);
      return paramByteOrder;
    }
    
    public static c b(long paramLong, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178698);
      paramByteOrder = b(new long[] { paramLong }, paramByteOrder);
      AppMethodBeat.o(178698);
      return paramByteOrder;
    }
    
    private static c b(long[] paramArrayOfLong, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178697);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[4] * 1]);
      localByteBuffer.order(paramByteOrder);
      int i = 0;
      while (i <= 0)
      {
        localByteBuffer.putInt((int)paramArrayOfLong[0]);
        i += 1;
      }
      paramArrayOfLong = new c(4, 1, localByteBuffer.array());
      AppMethodBeat.o(178697);
      return paramArrayOfLong;
    }
    
    private static c c(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178695);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[3] * 1]);
      localByteBuffer.order(paramByteOrder);
      int i = 0;
      while (i <= 0)
      {
        localByteBuffer.putShort((short)paramArrayOfInt[0]);
        i += 1;
      }
      paramArrayOfInt = new c(3, 1, localByteBuffer.array());
      AppMethodBeat.o(178695);
      return paramArrayOfInt;
    }
    
    /* Error */
    final Object a(ByteOrder paramByteOrder)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: iconst_0
      //   4: istore_3
      //   5: iconst_0
      //   6: istore 5
      //   8: iconst_0
      //   9: istore 6
      //   11: iconst_0
      //   12: istore 7
      //   14: iconst_0
      //   15: istore 8
      //   17: iconst_0
      //   18: istore 9
      //   20: iconst_0
      //   21: istore 10
      //   23: iconst_0
      //   24: istore_2
      //   25: ldc 129
      //   27: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   30: new 131	androidx/a/a/a$a
      //   33: dup
      //   34: aload_0
      //   35: getfield 27	androidx/a/a/a$c:zy	[B
      //   38: invokespecial 134	androidx/a/a/a$a:<init>	([B)V
      //   41: astore 12
      //   43: aload 12
      //   45: aload_1
      //   46: putfield 138	androidx/a/a/a$a:zv	Ljava/nio/ByteOrder;
      //   49: aload_0
      //   50: getfield 21	androidx/a/a/a$c:format	I
      //   53: istore 11
      //   55: iload 11
      //   57: tableswitch	default:+63 -> 120, 1:+75->132, 2:+166->223, 3:+303->360, 4:+345->402, 5:+389->446, 6:+75->132, 7:+166->223, 8:+447->504, 9:+492->549, 10:+537->594, 11:+597->654, 12:+643->700
      //   121: fconst_1
      //   122: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   125: ldc 129
      //   127: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aconst_null
      //   131: areturn
      //   132: aload_0
      //   133: getfield 27	androidx/a/a/a$c:zy	[B
      //   136: arraylength
      //   137: iconst_1
      //   138: if_icmpne +58 -> 196
      //   141: aload_0
      //   142: getfield 27	androidx/a/a/a$c:zy	[B
      //   145: iconst_0
      //   146: baload
      //   147: iflt +49 -> 196
      //   150: aload_0
      //   151: getfield 27	androidx/a/a/a$c:zy	[B
      //   154: iconst_0
      //   155: baload
      //   156: iconst_1
      //   157: if_icmpgt +39 -> 196
      //   160: new 62	java/lang/String
      //   163: dup
      //   164: iconst_1
      //   165: newarray char
      //   167: dup
      //   168: iconst_0
      //   169: aload_0
      //   170: getfield 27	androidx/a/a/a$c:zy	[B
      //   173: iconst_0
      //   174: baload
      //   175: bipush 48
      //   177: iadd
      //   178: i2c
      //   179: castore
      //   180: invokespecial 144	java/lang/String:<init>	([C)V
      //   183: astore_1
      //   184: aload 12
      //   186: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   189: ldc 129
      //   191: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   194: aload_1
      //   195: areturn
      //   196: new 62	java/lang/String
      //   199: dup
      //   200: aload_0
      //   201: getfield 27	androidx/a/a/a$c:zy	[B
      //   204: getstatic 60	androidx/a/a/a:yX	Ljava/nio/charset/Charset;
      //   207: invokespecial 147	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   210: astore_1
      //   211: aload 12
      //   213: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   216: ldc 129
      //   218: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: aload_1
      //   222: areturn
      //   223: aload_0
      //   224: getfield 23	androidx/a/a/a$c:zx	I
      //   227: getstatic 150	androidx/a/a/a:yF	[B
      //   230: arraylength
      //   231: if_icmplt +614 -> 845
      //   234: iconst_0
      //   235: istore_2
      //   236: iload 4
      //   238: istore_3
      //   239: iload_2
      //   240: getstatic 150	androidx/a/a/a:yF	[B
      //   243: arraylength
      //   244: if_icmpge +19 -> 263
      //   247: aload_0
      //   248: getfield 27	androidx/a/a/a$c:zy	[B
      //   251: iload_2
      //   252: baload
      //   253: getstatic 150	androidx/a/a/a:yF	[B
      //   256: iload_2
      //   257: baload
      //   258: if_icmpeq +599 -> 857
      //   261: iconst_0
      //   262: istore_3
      //   263: iload_3
      //   264: ifeq +581 -> 845
      //   267: getstatic 150	androidx/a/a/a:yF	[B
      //   270: arraylength
      //   271: istore_2
      //   272: new 44	java/lang/StringBuilder
      //   275: dup
      //   276: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   279: astore_1
      //   280: iload_2
      //   281: aload_0
      //   282: getfield 23	androidx/a/a/a$c:zx	I
      //   285: if_icmpge +58 -> 343
      //   288: aload_0
      //   289: getfield 27	androidx/a/a/a$c:zy	[B
      //   292: iload_2
      //   293: baload
      //   294: istore_3
      //   295: iload_3
      //   296: ifeq +47 -> 343
      //   299: iload_3
      //   300: bipush 32
      //   302: if_icmplt +13 -> 315
      //   305: aload_1
      //   306: iload_3
      //   307: i2c
      //   308: invokevirtual 52	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   311: pop
      //   312: goto +538 -> 850
      //   315: aload_1
      //   316: bipush 63
      //   318: invokevirtual 52	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   321: pop
      //   322: goto +528 -> 850
      //   325: astore_1
      //   326: aload 12
      //   328: ifnull +8 -> 336
      //   331: aload 12
      //   333: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   336: ldc 129
      //   338: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   341: aconst_null
      //   342: areturn
      //   343: aload_1
      //   344: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   347: astore_1
      //   348: aload 12
      //   350: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   353: ldc 129
      //   355: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   358: aload_1
      //   359: areturn
      //   360: aload_0
      //   361: getfield 23	androidx/a/a/a$c:zx	I
      //   364: newarray int
      //   366: astore_1
      //   367: iload_2
      //   368: aload_0
      //   369: getfield 23	androidx/a/a/a$c:zx	I
      //   372: if_icmpge +18 -> 390
      //   375: aload_1
      //   376: iload_2
      //   377: aload 12
      //   379: invokevirtual 154	androidx/a/a/a$a:readUnsignedShort	()I
      //   382: iastore
      //   383: iload_2
      //   384: iconst_1
      //   385: iadd
      //   386: istore_2
      //   387: goto -20 -> 367
      //   390: aload 12
      //   392: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   395: ldc 129
      //   397: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   400: aload_1
      //   401: areturn
      //   402: aload_0
      //   403: getfield 23	androidx/a/a/a$c:zx	I
      //   406: newarray long
      //   408: astore_1
      //   409: iload_3
      //   410: istore_2
      //   411: iload_2
      //   412: aload_0
      //   413: getfield 23	androidx/a/a/a$c:zx	I
      //   416: if_icmpge +18 -> 434
      //   419: aload_1
      //   420: iload_2
      //   421: aload 12
      //   423: invokevirtual 158	androidx/a/a/a$a:dE	()J
      //   426: lastore
      //   427: iload_2
      //   428: iconst_1
      //   429: iadd
      //   430: istore_2
      //   431: goto -20 -> 411
      //   434: aload 12
      //   436: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   439: ldc 129
      //   441: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   444: aload_1
      //   445: areturn
      //   446: aload_0
      //   447: getfield 23	androidx/a/a/a$c:zx	I
      //   450: anewarray 76	androidx/a/a/a$e
      //   453: astore_1
      //   454: iload 5
      //   456: istore_2
      //   457: iload_2
      //   458: aload_0
      //   459: getfield 23	androidx/a/a/a$c:zx	I
      //   462: if_icmpge +30 -> 492
      //   465: aload_1
      //   466: iload_2
      //   467: new 76	androidx/a/a/a$e
      //   470: dup
      //   471: aload 12
      //   473: invokevirtual 158	androidx/a/a/a$a:dE	()J
      //   476: aload 12
      //   478: invokevirtual 158	androidx/a/a/a$a:dE	()J
      //   481: invokespecial 161	androidx/a/a/a$e:<init>	(JJ)V
      //   484: aastore
      //   485: iload_2
      //   486: iconst_1
      //   487: iadd
      //   488: istore_2
      //   489: goto -32 -> 457
      //   492: aload 12
      //   494: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   497: ldc 129
      //   499: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   502: aload_1
      //   503: areturn
      //   504: aload_0
      //   505: getfield 23	androidx/a/a/a$c:zx	I
      //   508: newarray int
      //   510: astore_1
      //   511: iload 6
      //   513: istore_2
      //   514: iload_2
      //   515: aload_0
      //   516: getfield 23	androidx/a/a/a$c:zx	I
      //   519: if_icmpge +18 -> 537
      //   522: aload_1
      //   523: iload_2
      //   524: aload 12
      //   526: invokevirtual 165	androidx/a/a/a$a:readShort	()S
      //   529: iastore
      //   530: iload_2
      //   531: iconst_1
      //   532: iadd
      //   533: istore_2
      //   534: goto -20 -> 514
      //   537: aload 12
      //   539: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   542: ldc 129
      //   544: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   547: aload_1
      //   548: areturn
      //   549: aload_0
      //   550: getfield 23	androidx/a/a/a$c:zx	I
      //   553: newarray int
      //   555: astore_1
      //   556: iload 7
      //   558: istore_2
      //   559: iload_2
      //   560: aload_0
      //   561: getfield 23	androidx/a/a/a$c:zx	I
      //   564: if_icmpge +18 -> 582
      //   567: aload_1
      //   568: iload_2
      //   569: aload 12
      //   571: invokevirtual 168	androidx/a/a/a$a:readInt	()I
      //   574: iastore
      //   575: iload_2
      //   576: iconst_1
      //   577: iadd
      //   578: istore_2
      //   579: goto -20 -> 559
      //   582: aload 12
      //   584: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   587: ldc 129
      //   589: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   592: aload_1
      //   593: areturn
      //   594: aload_0
      //   595: getfield 23	androidx/a/a/a$c:zx	I
      //   598: anewarray 76	androidx/a/a/a$e
      //   601: astore_1
      //   602: iload 8
      //   604: istore_2
      //   605: iload_2
      //   606: aload_0
      //   607: getfield 23	androidx/a/a/a$c:zx	I
      //   610: if_icmpge +32 -> 642
      //   613: aload_1
      //   614: iload_2
      //   615: new 76	androidx/a/a/a$e
      //   618: dup
      //   619: aload 12
      //   621: invokevirtual 168	androidx/a/a/a$a:readInt	()I
      //   624: i2l
      //   625: aload 12
      //   627: invokevirtual 168	androidx/a/a/a$a:readInt	()I
      //   630: i2l
      //   631: invokespecial 161	androidx/a/a/a$e:<init>	(JJ)V
      //   634: aastore
      //   635: iload_2
      //   636: iconst_1
      //   637: iadd
      //   638: istore_2
      //   639: goto -34 -> 605
      //   642: aload 12
      //   644: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   647: ldc 129
      //   649: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   652: aload_1
      //   653: areturn
      //   654: aload_0
      //   655: getfield 23	androidx/a/a/a$c:zx	I
      //   658: newarray double
      //   660: astore_1
      //   661: iload 9
      //   663: istore_2
      //   664: iload_2
      //   665: aload_0
      //   666: getfield 23	androidx/a/a/a$c:zx	I
      //   669: if_icmpge +19 -> 688
      //   672: aload_1
      //   673: iload_2
      //   674: aload 12
      //   676: invokevirtual 172	androidx/a/a/a$a:readFloat	()F
      //   679: f2d
      //   680: dastore
      //   681: iload_2
      //   682: iconst_1
      //   683: iadd
      //   684: istore_2
      //   685: goto -21 -> 664
      //   688: aload 12
      //   690: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   693: ldc 129
      //   695: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   698: aload_1
      //   699: areturn
      //   700: aload_0
      //   701: getfield 23	androidx/a/a/a$c:zx	I
      //   704: newarray double
      //   706: astore_1
      //   707: iload 10
      //   709: istore_2
      //   710: iload_2
      //   711: aload_0
      //   712: getfield 23	androidx/a/a/a$c:zx	I
      //   715: if_icmpge +18 -> 733
      //   718: aload_1
      //   719: iload_2
      //   720: aload 12
      //   722: invokevirtual 176	androidx/a/a/a$a:readDouble	()D
      //   725: dastore
      //   726: iload_2
      //   727: iconst_1
      //   728: iadd
      //   729: istore_2
      //   730: goto -20 -> 710
      //   733: aload 12
      //   735: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   738: ldc 129
      //   740: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   743: aload_1
      //   744: areturn
      //   745: astore_1
      //   746: aconst_null
      //   747: astore 12
      //   749: aload 12
      //   751: ifnull +8 -> 759
      //   754: aload 12
      //   756: invokevirtual 141	androidx/a/a/a$a:close	()V
      //   759: ldc 129
      //   761: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   764: aload_1
      //   765: athrow
      //   766: astore 12
      //   768: goto -579 -> 189
      //   771: astore 12
      //   773: goto -557 -> 216
      //   776: astore 12
      //   778: goto -425 -> 353
      //   781: astore 12
      //   783: goto -388 -> 395
      //   786: astore 12
      //   788: goto -349 -> 439
      //   791: astore 12
      //   793: goto -296 -> 497
      //   796: astore 12
      //   798: goto -256 -> 542
      //   801: astore 12
      //   803: goto -216 -> 587
      //   806: astore 12
      //   808: goto -161 -> 647
      //   811: astore 12
      //   813: goto -120 -> 693
      //   816: astore 12
      //   818: goto -80 -> 738
      //   821: astore_1
      //   822: goto -697 -> 125
      //   825: astore_1
      //   826: goto -490 -> 336
      //   829: astore 12
      //   831: goto -72 -> 759
      //   834: astore_1
      //   835: goto -86 -> 749
      //   838: astore_1
      //   839: aconst_null
      //   840: astore 12
      //   842: goto -516 -> 326
      //   845: iconst_0
      //   846: istore_2
      //   847: goto -575 -> 272
      //   850: iload_2
      //   851: iconst_1
      //   852: iadd
      //   853: istore_2
      //   854: goto -574 -> 280
      //   857: iload_2
      //   858: iconst_1
      //   859: iadd
      //   860: istore_2
      //   861: goto -625 -> 236
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	864	0	this	c
      //   0	864	1	paramByteOrder	ByteOrder
      //   24	837	2	i	int
      //   4	406	3	j	int
      //   1	236	4	k	int
      //   6	449	5	m	int
      //   9	503	6	n	int
      //   12	545	7	i1	int
      //   15	588	8	i2	int
      //   18	644	9	i3	int
      //   21	687	10	i4	int
      //   53	3	11	i5	int
      //   41	714	12	locala	a.a
      //   766	1	12	localIOException1	IOException
      //   771	1	12	localIOException2	IOException
      //   776	1	12	localIOException3	IOException
      //   781	1	12	localIOException4	IOException
      //   786	1	12	localIOException5	IOException
      //   791	1	12	localIOException6	IOException
      //   796	1	12	localIOException7	IOException
      //   801	1	12	localIOException8	IOException
      //   806	1	12	localIOException9	IOException
      //   811	1	12	localIOException10	IOException
      //   816	1	12	localIOException11	IOException
      //   829	1	12	localIOException12	IOException
      //   840	1	12	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   43	55	325	java/io/IOException
      //   132	184	325	java/io/IOException
      //   196	211	325	java/io/IOException
      //   223	234	325	java/io/IOException
      //   239	261	325	java/io/IOException
      //   267	272	325	java/io/IOException
      //   272	280	325	java/io/IOException
      //   280	295	325	java/io/IOException
      //   305	312	325	java/io/IOException
      //   315	322	325	java/io/IOException
      //   343	348	325	java/io/IOException
      //   360	367	325	java/io/IOException
      //   367	383	325	java/io/IOException
      //   402	409	325	java/io/IOException
      //   411	427	325	java/io/IOException
      //   446	454	325	java/io/IOException
      //   457	485	325	java/io/IOException
      //   504	511	325	java/io/IOException
      //   514	530	325	java/io/IOException
      //   549	556	325	java/io/IOException
      //   559	575	325	java/io/IOException
      //   594	602	325	java/io/IOException
      //   605	635	325	java/io/IOException
      //   654	661	325	java/io/IOException
      //   664	681	325	java/io/IOException
      //   700	707	325	java/io/IOException
      //   710	726	325	java/io/IOException
      //   30	43	745	finally
      //   184	189	766	java/io/IOException
      //   211	216	771	java/io/IOException
      //   348	353	776	java/io/IOException
      //   390	395	781	java/io/IOException
      //   434	439	786	java/io/IOException
      //   492	497	791	java/io/IOException
      //   537	542	796	java/io/IOException
      //   582	587	801	java/io/IOException
      //   642	647	806	java/io/IOException
      //   688	693	811	java/io/IOException
      //   733	738	816	java/io/IOException
      //   120	125	821	java/io/IOException
      //   331	336	825	java/io/IOException
      //   754	759	829	java/io/IOException
      //   43	55	834	finally
      //   132	184	834	finally
      //   196	211	834	finally
      //   223	234	834	finally
      //   239	261	834	finally
      //   267	272	834	finally
      //   272	280	834	finally
      //   280	295	834	finally
      //   305	312	834	finally
      //   315	322	834	finally
      //   343	348	834	finally
      //   360	367	834	finally
      //   367	383	834	finally
      //   402	409	834	finally
      //   411	427	834	finally
      //   446	454	834	finally
      //   457	485	834	finally
      //   504	511	834	finally
      //   514	530	834	finally
      //   549	556	834	finally
      //   559	575	834	finally
      //   594	602	834	finally
      //   605	635	834	finally
      //   654	661	834	finally
      //   664	681	834	finally
      //   700	707	834	finally
      //   710	726	834	finally
      //   30	43	838	java/io/IOException
    }
    
    public final int b(ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178708);
      paramByteOrder = a(paramByteOrder);
      if (paramByteOrder == null)
      {
        paramByteOrder = new NumberFormatException("NULL can't be converted to a integer value");
        AppMethodBeat.o(178708);
        throw paramByteOrder;
      }
      int i;
      if ((paramByteOrder instanceof String))
      {
        i = Integer.parseInt((String)paramByteOrder);
        AppMethodBeat.o(178708);
        return i;
      }
      if ((paramByteOrder instanceof long[]))
      {
        paramByteOrder = (long[])paramByteOrder;
        if (paramByteOrder.length == 1)
        {
          i = (int)paramByteOrder[0];
          AppMethodBeat.o(178708);
          return i;
        }
        paramByteOrder = new NumberFormatException("There are more than one component");
        AppMethodBeat.o(178708);
        throw paramByteOrder;
      }
      if ((paramByteOrder instanceof int[]))
      {
        paramByteOrder = (int[])paramByteOrder;
        if (paramByteOrder.length == 1)
        {
          i = paramByteOrder[0];
          AppMethodBeat.o(178708);
          return i;
        }
        paramByteOrder = new NumberFormatException("There are more than one component");
        AppMethodBeat.o(178708);
        throw paramByteOrder;
      }
      paramByteOrder = new NumberFormatException("Couldn't find a integer value");
      AppMethodBeat.o(178708);
      throw paramByteOrder;
    }
    
    public final String c(ByteOrder paramByteOrder)
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      AppMethodBeat.i(178709);
      Object localObject = a(paramByteOrder);
      if (localObject == null)
      {
        AppMethodBeat.o(178709);
        return null;
      }
      if ((localObject instanceof String))
      {
        paramByteOrder = (String)localObject;
        AppMethodBeat.o(178709);
        return paramByteOrder;
      }
      paramByteOrder = new StringBuilder();
      if ((localObject instanceof long[]))
      {
        localObject = (long[])localObject;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i]);
          if (i + 1 != localObject.length) {
            paramByteOrder.append(",");
          }
          i += 1;
        }
        paramByteOrder = paramByteOrder.toString();
        AppMethodBeat.o(178709);
        return paramByteOrder;
      }
      if ((localObject instanceof int[]))
      {
        localObject = (int[])localObject;
        i = j;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i]);
          if (i + 1 != localObject.length) {
            paramByteOrder.append(",");
          }
          i += 1;
        }
        paramByteOrder = paramByteOrder.toString();
        AppMethodBeat.o(178709);
        return paramByteOrder;
      }
      if ((localObject instanceof double[]))
      {
        localObject = (double[])localObject;
        i = k;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i]);
          if (i + 1 != localObject.length) {
            paramByteOrder.append(",");
          }
          i += 1;
        }
        paramByteOrder = paramByteOrder.toString();
        AppMethodBeat.o(178709);
        return paramByteOrder;
      }
      if ((localObject instanceof a.e[]))
      {
        localObject = (a.e[])localObject;
        i = m;
        while (i < localObject.length)
        {
          paramByteOrder.append(localObject[i].zB);
          paramByteOrder.append('/');
          paramByteOrder.append(localObject[i].zC);
          if (i + 1 != localObject.length) {
            paramByteOrder.append(",");
          }
          i += 1;
        }
        paramByteOrder = paramByteOrder.toString();
        AppMethodBeat.o(178709);
        return paramByteOrder;
      }
      AppMethodBeat.o(178709);
      return null;
    }
    
    public final double d(ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178707);
      paramByteOrder = a(paramByteOrder);
      if (paramByteOrder == null)
      {
        paramByteOrder = new NumberFormatException("NULL can't be converted to a double value");
        AppMethodBeat.o(178707);
        throw paramByteOrder;
      }
      double d;
      if ((paramByteOrder instanceof String))
      {
        d = Double.parseDouble((String)paramByteOrder);
        AppMethodBeat.o(178707);
        return d;
      }
      if ((paramByteOrder instanceof long[]))
      {
        paramByteOrder = (long[])paramByteOrder;
        if (paramByteOrder.length == 1)
        {
          d = paramByteOrder[0];
          AppMethodBeat.o(178707);
          return d;
        }
        paramByteOrder = new NumberFormatException("There are more than one component");
        AppMethodBeat.o(178707);
        throw paramByteOrder;
      }
      if ((paramByteOrder instanceof int[]))
      {
        paramByteOrder = (int[])paramByteOrder;
        if (paramByteOrder.length == 1)
        {
          d = paramByteOrder[0];
          AppMethodBeat.o(178707);
          return d;
        }
        paramByteOrder = new NumberFormatException("There are more than one component");
        AppMethodBeat.o(178707);
        throw paramByteOrder;
      }
      if ((paramByteOrder instanceof double[]))
      {
        paramByteOrder = (double[])paramByteOrder;
        if (paramByteOrder.length == 1)
        {
          d = paramByteOrder[0];
          AppMethodBeat.o(178707);
          return d;
        }
        paramByteOrder = new NumberFormatException("There are more than one component");
        AppMethodBeat.o(178707);
        throw paramByteOrder;
      }
      if ((paramByteOrder instanceof a.e[]))
      {
        paramByteOrder = (a.e[])paramByteOrder;
        if (paramByteOrder.length == 1)
        {
          d = paramByteOrder[0].nv();
          AppMethodBeat.o(178707);
          return d;
        }
        paramByteOrder = new NumberFormatException("There are more than one component");
        AppMethodBeat.o(178707);
        throw paramByteOrder;
      }
      paramByteOrder = new NumberFormatException("Couldn't find a double value");
      AppMethodBeat.o(178707);
      throw paramByteOrder;
    }
    
    public final int size()
    {
      return a.yE[this.format] * this.zx;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(178705);
      String str = "(" + a.yD[this.format] + ", data length:" + this.zy.length + ")";
      AppMethodBeat.o(178705);
      return str;
    }
  }
  
  static final class d
  {
    public final String name;
    public final int number;
    public final int zA;
    public final int zz;
    
    d(String paramString, int paramInt)
    {
      this.name = paramString;
      this.number = paramInt;
      this.zz = 3;
      this.zA = 4;
    }
    
    d(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.number = paramInt1;
      this.zz = paramInt2;
      this.zA = -1;
    }
    
    final boolean am(int paramInt)
    {
      if ((this.zz == 7) || (paramInt == 7)) {}
      while ((this.zz == paramInt) || (this.zA == paramInt) || (((this.zz == 4) || (this.zA == 4)) && ((paramInt == 3) || (((this.zz == 9) || (this.zA == 9)) && ((paramInt == 8) || (((this.zz == 12) || (this.zA == 12)) && (paramInt == 11))))))) {
        return true;
      }
      return false;
    }
  }
  
  static final class e
  {
    public final long zB;
    public final long zC;
    
    e(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(178711);
      if (paramLong2 == 0L)
      {
        this.zB = 0L;
        this.zC = 1L;
        AppMethodBeat.o(178711);
        return;
      }
      this.zB = paramLong1;
      this.zC = paramLong2;
      AppMethodBeat.o(178711);
    }
    
    public final double nv()
    {
      return this.zB / this.zC;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(178712);
      String str = this.zB + "/" + this.zC;
      AppMethodBeat.o(178712);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.a.a.a
 * JD-Core Version:    0.7.0.1
 */