package android.support.e;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static final String TAG_APERTURE_VALUE = "ApertureValue";
  public static final String TAG_ARTIST = "Artist";
  public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
  public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
  public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
  public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
  public static final String TAG_CFA_PATTERN = "CFAPattern";
  public static final String TAG_COLOR_SPACE = "ColorSpace";
  public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
  public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
  public static final String TAG_COMPRESSION = "Compression";
  public static final String TAG_CONTRAST = "Contrast";
  public static final String TAG_COPYRIGHT = "Copyright";
  public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
  public static final String TAG_DATETIME = "DateTime";
  public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
  public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
  public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
  public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
  public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
  public static final String TAG_DNG_VERSION = "DNGVersion";
  private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
  public static final String TAG_EXIF_VERSION = "ExifVersion";
  public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
  public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
  public static final String TAG_EXPOSURE_MODE = "ExposureMode";
  public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
  public static final String TAG_EXPOSURE_TIME = "ExposureTime";
  public static final String TAG_FILE_SOURCE = "FileSource";
  public static final String TAG_FLASH = "Flash";
  public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
  public static final String TAG_FLASH_ENERGY = "FlashEnergy";
  public static final String TAG_FOCAL_LENGTH = "FocalLength";
  public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
  public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
  public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
  public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
  public static final String TAG_F_NUMBER = "FNumber";
  public static final String TAG_GAIN_CONTROL = "GainControl";
  public static final String TAG_GAMMA = "Gamma";
  public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
  public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
  public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
  public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
  public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
  public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
  public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
  public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
  public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
  public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
  public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
  public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
  public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
  public static final String TAG_GPS_DOP = "GPSDOP";
  public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
  public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
  public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
  private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
  public static final String TAG_GPS_LATITUDE = "GPSLatitude";
  public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
  public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
  public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
  public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
  public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
  public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
  public static final String TAG_GPS_SATELLITES = "GPSSatellites";
  public static final String TAG_GPS_SPEED = "GPSSpeed";
  public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
  public static final String TAG_GPS_STATUS = "GPSStatus";
  public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
  public static final String TAG_GPS_TRACK = "GPSTrack";
  public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
  public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
  private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
  public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
  public static final String TAG_IMAGE_LENGTH = "ImageLength";
  public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
  public static final String TAG_IMAGE_WIDTH = "ImageWidth";
  private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
  public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
  public static final String TAG_ISO_SPEED = "ISOSpeed";
  public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
  public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
  @Deprecated
  public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
  public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
  public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
  public static final String TAG_LENS_MAKE = "LensMake";
  public static final String TAG_LENS_MODEL = "LensModel";
  public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
  public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
  public static final String TAG_LIGHT_SOURCE = "LightSource";
  public static final String TAG_MAKE = "Make";
  public static final String TAG_MAKER_NOTE = "MakerNote";
  public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
  public static final String TAG_METERING_MODE = "MeteringMode";
  public static final String TAG_MODEL = "Model";
  public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
  public static final String TAG_OECF = "OECF";
  public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
  private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
  private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
  public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
  public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
  public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
  public static final String TAG_ORIENTATION = "Orientation";
  public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
  public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
  public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
  public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
  public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
  public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
  private static final d TAG_RAF_IMAGE_SIZE;
  public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
  public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
  public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
  public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
  public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
  public static final String TAG_RW2_ISO = "ISO";
  public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
  public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
  public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
  public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
  public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
  public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
  public static final String TAG_SATURATION = "Saturation";
  public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
  public static final String TAG_SCENE_TYPE = "SceneType";
  public static final String TAG_SENSING_METHOD = "SensingMethod";
  public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
  public static final String TAG_SHARPNESS = "Sharpness";
  public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
  public static final String TAG_SOFTWARE = "Software";
  public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
  public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
  public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
  public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
  public static final String TAG_STRIP_OFFSETS = "StripOffsets";
  public static final String TAG_SUBFILE_TYPE = "SubfileType";
  public static final String TAG_SUBJECT_AREA = "SubjectArea";
  public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
  public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
  public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
  public static final String TAG_SUBSEC_TIME = "SubSecTime";
  public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
  public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
  private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
  private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
  public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
  public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
  private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
  private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
  public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
  public static final String TAG_USER_COMMENT = "UserComment";
  public static final String TAG_WHITE_BALANCE = "WhiteBalance";
  public static final String TAG_WHITE_POINT = "WhitePoint";
  public static final String TAG_X_RESOLUTION = "XResolution";
  public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
  public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
  public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
  public static final String TAG_Y_RESOLUTION = "YResolution";
  private static final byte[] yA;
  private static final byte[] yB;
  private static SimpleDateFormat yC;
  static final String[] yD;
  static final int[] yE;
  static final byte[] yF;
  private static final d[] yG;
  private static final d[] yH;
  private static final d[] yI;
  private static final d[] yJ;
  private static final d[] yK;
  private static final d[] yL;
  private static final d[] yM;
  private static final d[] yN;
  private static final d[] yO;
  static final d[][] yP;
  private static final d[] yQ;
  private static final d yR;
  private static final d yS;
  private static final HashMap<Integer, d>[] yT;
  private static final HashMap<String, d>[] yU;
  private static final HashSet<String> yV;
  private static final HashMap<Integer, Integer> yW;
  static final Charset yX;
  static final byte[] yY;
  private static final List<Integer> yu = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8) });
  private static final List<Integer> yv = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5) });
  public static final int[] yw = { 8, 8, 8 };
  public static final int[] yx = { 4 };
  public static final int[] yy = { 8 };
  static final byte[] yz = { -1, -40, -1 };
  private static final Pattern zr = Pattern.compile(".*[1-9].*");
  private static final Pattern zt = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
  private final String yZ;
  private final AssetManager.AssetInputStream za;
  private int zb;
  private final HashMap<String, c>[] zc = new HashMap[yP.length];
  private Set<Integer> zd = new HashSet(yP.length);
  private ByteOrder ze = ByteOrder.BIG_ENDIAN;
  private boolean zf;
  private int zg;
  private int zi;
  private byte[] zj;
  private int zk;
  private int zl;
  private int zm;
  private int zn;
  private int zo;
  private int zp;
  private boolean zq;
  
  static
  {
    yA = new byte[] { 79, 76, 89, 77, 80, 0 };
    yB = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
    yD = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE" };
    yE = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
    yF = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
    yG = new d[] { new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256), new d("ImageLength", 257), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278), new d("StripByteCounts", 279), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7) };
    yH = new d[] { new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962), new d("PixelYDimension", 40963), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720) };
    yI = new d[] { new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3) };
    yJ = new d[] { new d("InteroperabilityIndex", 1, 2) };
    yK = new d[] { new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256), new d("ThumbnailImageLength", 257), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278), new d("StripByteCounts", 279), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720) };
    TAG_RAF_IMAGE_SIZE = new d("StripOffsets", 273, 3);
    yL = new d[] { new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4) };
    yM = new d[] { new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4) };
    yN = new d[] { new d("AspectFrame", 4371, 3) };
    yO = new d[] { new d("ColorSpace", 55, 3) };
    yP = new d[][] { yG, yH, yI, yJ, yK, yG, yL, yM, yN, yO };
    yQ = new d[] { new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1) };
    yR = new d("JPEGInterchangeFormat", 513, 4);
    yS = new d("JPEGInterchangeFormatLength", 514, 4);
    yT = new HashMap[yP.length];
    yU = new HashMap[yP.length];
    yV = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    yW = new HashMap();
    yX = Charset.forName("US-ASCII");
    yY = "".getBytes(yX);
    Object localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    yC = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    int i = 0;
    while (i < yP.length)
    {
      yT[i] = new HashMap();
      yU[i] = new HashMap();
      localObject1 = yP[i];
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
    yW.put(Integer.valueOf(yQ[0].number), Integer.valueOf(5));
    yW.put(Integer.valueOf(yQ[1].number), Integer.valueOf(1));
    yW.put(Integer.valueOf(yQ[2].number), Integer.valueOf(2));
    yW.put(Integer.valueOf(yQ[3].number), Integer.valueOf(3));
    yW.put(Integer.valueOf(yQ[4].number), Integer.valueOf(7));
    yW.put(Integer.valueOf(yQ[5].number), Integer.valueOf(8));
  }
  
  public a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("inputStream cannot be null");
    }
    this.yZ = null;
    if ((paramInputStream instanceof AssetManager.AssetInputStream)) {}
    for (this.za = ((AssetManager.AssetInputStream)paramInputStream);; this.za = null)
    {
      b(paramInputStream);
      return;
    }
  }
  
  public a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("filename cannot be null");
    }
    this.za = null;
    this.yZ = paramString;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      closeQuietly(localFileInputStream);
    }
    finally
    {
      try
      {
        b(localFileInputStream);
        closeQuietly(localFileInputStream);
        return;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    throw paramString;
  }
  
  private int a(b paramb)
  {
    int[] arrayOfInt = new int[yP.length];
    Object localObject1 = new int[yP.length];
    Object localObject2 = yQ;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      removeAttribute(localObject2[i].name);
      i += 1;
    }
    removeAttribute(yR.name);
    removeAttribute(yS.name);
    i = 0;
    int k;
    while (i < yP.length)
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
      this.zc[0].put(yQ[1].name, c.a(0L, this.ze));
    }
    if (!this.zc[2].isEmpty()) {
      this.zc[0].put(yQ[2].name, c.a(0L, this.ze));
    }
    if (!this.zc[3].isEmpty()) {
      this.zc[1].put(yQ[3].name, c.a(0L, this.ze));
    }
    if (this.zf)
    {
      this.zc[4].put(yR.name, c.a(0L, this.ze));
      this.zc[4].put(yS.name, c.a(this.zi, this.ze));
    }
    j = 0;
    if (j < yP.length)
    {
      localObject2 = this.zc[j].entrySet().iterator();
      i = 0;
      label370:
      if (((Iterator)localObject2).hasNext())
      {
        k = ((c)((Map.Entry)((Iterator)localObject2).next()).getValue()).size();
        if (k <= 4) {
          break label1131;
        }
        i = k + i;
      }
    }
    label990:
    label1131:
    for (;;)
    {
      break label370;
      localObject1[j] += i;
      j += 1;
      break;
      i = 8;
      j = 0;
      while (j < yP.length)
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
        this.zc[4].put(yR.name, c.a(i, this.ze));
        this.zg = (i + 6);
        j = i + this.zi;
      }
      int m = j + 8;
      if (!this.zc[1].isEmpty()) {
        this.zc[0].put(yQ[1].name, c.a(arrayOfInt[1], this.ze));
      }
      if (!this.zc[2].isEmpty()) {
        this.zc[0].put(yQ[2].name, c.a(arrayOfInt[2], this.ze));
      }
      if (!this.zc[3].isEmpty()) {
        this.zc[1].put(yQ[3].name, c.a(arrayOfInt[3], this.ze));
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
        if (i >= yP.length) {
          break label1106;
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
              break label990;
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
      return m;
    }
  }
  
  private void a(a parama)
  {
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
  }
  
  private void a(a parama, int paramInt)
  {
    this.ze = c(parama);
    parama.zv = this.ze;
    int i = parama.readUnsignedShort();
    if ((this.zb != 7) && (this.zb != 10) && (i != 42)) {
      throw new IOException("Invalid start code: " + Integer.toHexString(i));
    }
    i = parama.readInt();
    if ((i < 8) || (i >= paramInt)) {
      throw new IOException("Invalid first Ifd offset: ".concat(String.valueOf(i)));
    }
    paramInt = i - 8;
    if ((paramInt > 0) && (parama.skipBytes(paramInt) != paramInt)) {
      throw new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(paramInt)));
    }
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    parama.zv = ByteOrder.BIG_ENDIAN;
    parama.seek(paramInt1);
    int i = parama.readByte();
    if (i != -1) {
      throw new IOException("Invalid marker: " + Integer.toHexString(i & 0xFF));
    }
    if (parama.readByte() != -40) {
      throw new IOException("Invalid marker: " + Integer.toHexString(i & 0xFF));
    }
    paramInt1 = paramInt1 + 1 + 1;
    i = parama.readByte();
    if (i != -1) {
      throw new IOException("Invalid marker:" + Integer.toHexString(i & 0xFF));
    }
    i = parama.readByte();
    int k;
    int j;
    if ((i != -39) && (i != -38))
    {
      k = parama.readUnsignedShort() - 2;
      j = paramInt1 + 1 + 1 + 2;
      if (k < 0) {
        throw new IOException("Invalid length");
      }
      switch (i)
      {
      default: 
        i = j;
        paramInt1 = k;
      }
    }
    for (;;)
    {
      if (paramInt1 < 0)
      {
        throw new IOException("Invalid length");
        paramInt1 = k;
        i = j;
        if (k < 6) {
          continue;
        }
        byte[] arrayOfByte = new byte[6];
        if (parama.read(arrayOfByte) != 6) {
          throw new IOException("Invalid exif");
        }
        j += 6;
        k -= 6;
        paramInt1 = k;
        i = j;
        if (!Arrays.equals(arrayOfByte, yY)) {
          continue;
        }
        if (k <= 0) {
          throw new IOException("Invalid exif");
        }
        this.zl = j;
        arrayOfByte = new byte[k];
        if (parama.read(arrayOfByte) != k) {
          throw new IOException("Invalid exif");
        }
        i = j + k;
        a locala = new a(arrayOfByte);
        a(locala, arrayOfByte.length);
        b(locala, paramInt2);
        paramInt1 = 0;
        continue;
        arrayOfByte = new byte[k];
        if (parama.read(arrayOfByte) != k) {
          throw new IOException("Invalid exif");
        }
        if (getAttribute("UserComment") == null)
        {
          this.zc[1].put("UserComment", c.n(new String(arrayOfByte, yX)));
          paramInt1 = 0;
          i = j;
          continue;
          if (parama.skipBytes(1) != 1) {
            throw new IOException("Invalid SOFx");
          }
          this.zc[paramInt2].put("ImageLength", c.a(parama.readUnsignedShort(), this.ze));
          this.zc[paramInt2].put("ImageWidth", c.a(parama.readUnsignedShort(), this.ze));
          paramInt1 = k - 5;
          i = j;
        }
      }
      else
      {
        if (parama.skipBytes(paramInt1) != paramInt1) {
          throw new IOException("Invalid JPEG segment");
        }
        paramInt1 += i;
        break;
        parama.zv = this.ze;
        return;
      }
      paramInt1 = 0;
      i = j;
    }
  }
  
  private void a(a parama, HashMap paramHashMap)
  {
    c localc = (c)paramHashMap.get("JPEGInterchangeFormat");
    paramHashMap = (c)paramHashMap.get("JPEGInterchangeFormatLength");
    int j;
    int k;
    int i;
    if ((localc != null) && (paramHashMap != null))
    {
      j = localc.b(this.ze);
      k = Math.min(paramHashMap.b(this.ze), parama.available() - j);
      if ((this.zb != 4) && (this.zb != 9) && (this.zb != 10)) {
        break label158;
      }
      i = j + this.zl;
    }
    for (;;)
    {
      if ((i > 0) && (k > 0))
      {
        this.zf = true;
        this.zg = i;
        this.zi = k;
        if ((this.yZ == null) && (this.za == null))
        {
          paramHashMap = new byte[k];
          parama.seek(i);
          parama.readFully(paramHashMap);
          this.zj = paramHashMap;
        }
      }
      return;
      label158:
      i = j;
      if (this.zb == 7) {
        i = j + this.zm;
      }
    }
  }
  
  private boolean a(HashMap paramHashMap)
  {
    c localc = (c)paramHashMap.get("ImageLength");
    paramHashMap = (c)paramHashMap.get("ImageWidth");
    if ((localc != null) && (paramHashMap != null))
    {
      int i = localc.b(this.ze);
      int j = paramHashMap.b(this.ze);
      if ((i <= 512) && (j <= 512)) {
        return true;
      }
    }
    return false;
  }
  
  public static String b(double paramDouble)
  {
    long l1 = paramDouble;
    long l2 = ((paramDouble - l1) * 60.0D);
    long l3 = Math.round((paramDouble - l1 - l2 / 60.0D) * 3600.0D * 10000000.0D);
    return l1 + "/1," + l2 + "/1," + l3 + "/10000000";
  }
  
  private void b(a parama)
  {
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
    for (;;)
    {
      int m;
      if (i < j)
      {
        int k = parama.readUnsignedShort();
        m = parama.readUnsignedShort();
        if (k == TAG_RAF_IMAGE_SIZE.number)
        {
          i = parama.readShort();
          j = parama.readShort();
          parama = c.a(i, this.ze);
          localObject = c.a(j, this.ze);
          this.zc[0].put("ImageLength", parama);
          this.zc[0].put("ImageWidth", localObject);
        }
      }
      else
      {
        return;
      }
      parama.skipBytes(m);
      i += 1;
    }
  }
  
  private void b(a parama, int paramInt)
  {
    int j = paramInt;
    this.zd.add(Integer.valueOf(parama.mPosition));
    if (parama.mPosition + 2 > parama.mLength) {}
    label33:
    int n;
    do
    {
      return;
      n = parama.readShort();
    } while ((parama.mPosition + n * 12 > parama.mLength) || (n <= 0));
    int k = 0;
    int i1;
    int i;
    int i2;
    long l3;
    d locald;
    long l1;
    int m;
    if (k < n)
    {
      i1 = parama.readUnsignedShort();
      i = parama.readUnsignedShort();
      i2 = parama.readInt();
      l3 = 4L + parama.mPosition;
      locald = (d)yT[j].get(Integer.valueOf(i1));
      l1 = 0L;
      m = 0;
      if (locald == null) {
        break label972;
      }
      if ((i <= 0) || (i >= yE.length))
      {
        paramInt = i;
        i = m;
      }
    }
    for (;;)
    {
      label147:
      if (i == 0) {
        parama.seek(l3);
      }
      for (;;)
      {
        k = (short)(k + 1);
        break;
        if (!locald.am(i))
        {
          new StringBuilder("Skip the tag entry since data format (").append(yD[i]).append(") is unexpected for tag: ").append(locald.name);
          paramInt = i;
          i = m;
          break label147;
        }
        paramInt = i;
        if (i == 7) {
          paramInt = locald.zz;
        }
        l1 = i2 * yE[paramInt];
        if ((l1 < 0L) || (l1 > 2147483647L))
        {
          i = m;
          break label147;
        }
        i = 1;
        break label147;
        if (l1 > 4L)
        {
          i = parama.readInt();
          if (this.zb != 7) {
            break label603;
          }
          if ("MakerNote".equals(locald.name))
          {
            this.zm = i;
            label312:
            if (i + l1 > parama.mLength) {
              break label634;
            }
            parama.seek(i);
          }
        }
        else
        {
          localObject = (Integer)yW.get(Integer.valueOf(i1));
          if (localObject == null) {
            break label718;
          }
          long l2 = -1L;
          l1 = l2;
          switch (paramInt)
          {
          default: 
            l1 = l2;
          case 5: 
          case 6: 
          case 7: 
          case 10: 
          case 11: 
          case 12: 
            label424:
            if ((l1 > 0L) && (l1 < parama.mLength))
            {
              if (this.zd.contains(Integer.valueOf((int)l1))) {
                break label682;
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
          if ((j != 6) || (!"ThumbnailImage".equals(locald.name))) {
            break label312;
          }
          this.zn = i;
          this.zo = i2;
          localObject = c.a(6, this.ze);
          c localc1 = c.a(this.zn, this.ze);
          c localc2 = c.a(this.zo, this.ze);
          this.zc[4].put("Compression", localObject);
          this.zc[4].put("JPEGInterchangeFormat", localc1);
          this.zc[4].put("JPEGInterchangeFormatLength", localc2);
          break label312;
          label603:
          if ((this.zb != 10) || (!"JpgFromRaw".equals(locald.name))) {
            break label312;
          }
          this.zp = i;
          break label312;
          label634:
          parama.seek(l3);
          break;
          l1 = parama.readUnsignedShort();
          break label424;
          l1 = parama.readShort();
          break label424;
          l1 = parama.dE();
          break label424;
          l1 = parama.readInt();
          break label424;
          label682:
          new StringBuilder("Skip jump into the IFD since it has already been read: IfdType ").append(localObject).append(" (at ").append(l1).append(")");
        }
        label718:
        Object localObject = new byte[(int)l1];
        parama.readFully((byte[])localObject);
        localObject = new c(paramInt, i2, (byte[])localObject);
        this.zc[j].put(locald.name, localObject);
        if ("DNGVersion".equals(locald.name)) {
          this.zb = 3;
        }
        if (((!"Make".equals(locald.name)) && (!"Model".equals(locald.name))) || ((((c)localObject).c(this.ze).contains("PENTAX")) || (("Compression".equals(locald.name)) && (((c)localObject).b(this.ze) == 65535)))) {
          this.zb = 8;
        }
        if (parama.mPosition != l3) {
          parama.seek(l3);
        }
      }
      if (parama.mPosition + 4 > parama.mLength) {
        break label33;
      }
      paramInt = parama.readInt();
      if ((paramInt <= 0L) || (paramInt >= parama.mLength) || (this.zd.contains(Integer.valueOf(paramInt)))) {
        break label33;
      }
      parama.seek(paramInt);
      if (this.zc[4].isEmpty())
      {
        j = 4;
        break;
      }
      if (!this.zc[5].isEmpty()) {
        break label33;
      }
      j = 5;
      break;
      label972:
      paramInt = i;
      i = m;
    }
  }
  
  private void b(a parama, HashMap paramHashMap)
  {
    Object localObject1 = (c)paramHashMap.get("StripOffsets");
    Object localObject2 = (c)paramHashMap.get("StripByteCounts");
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramHashMap = h(((c)localObject1).a(this.ze));
      localObject1 = h(((c)localObject2).a(this.ze));
      if (paramHashMap != null) {
        break label66;
      }
    }
    label66:
    while (localObject1 == null) {
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
  
  private void b(InputStream paramInputStream)
  {
    int i = 0;
    try
    {
      while (i < yP.length)
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
        break label254;
      }
      i = 4;
      this.zb = i;
      paramInputStream = new a(paramInputStream);
      switch (this.zb)
      {
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        label168:
        this.zq = false;
        return;
        b(paramInputStream);
      }
    }
    finally
    {
      dC();
    }
    Object localObject1 = this.zc[4];
    Object localObject2 = (c)((HashMap)localObject1).get("Compression");
    label244:
    label254:
    Object localObject3;
    label325:
    int j;
    if (localObject2 != null)
    {
      this.zk = ((c)localObject2).b(this.ze);
      switch (this.zk)
      {
      case 6: 
        for (;;)
        {
          this.zq = true;
          dC();
          return;
          if (g((byte[])localObject1))
          {
            i = 9;
            break;
          }
          localObject2 = new a((byte[])localObject1);
          this.ze = c((a)localObject2);
          ((a)localObject2).zv = this.ze;
          i = ((a)localObject2).readShort();
          ((a)localObject2).close();
          if (i == 20306) {
            break label1016;
          }
          if (i != 21330) {
            break label1028;
          }
          break label1016;
          localObject1 = new a((byte[])localObject1);
          this.ze = c((a)localObject1);
          ((a)localObject1).zv = this.ze;
          i = ((a)localObject1).readShort();
          ((a)localObject1).close();
          if (i != 85) {
            break label1043;
          }
          i = 1;
          break label1033;
          a(paramInputStream, 0, 0);
          break label168;
          a(paramInputStream);
          localObject1 = (c)this.zc[1].get("MakerNote");
          if (localObject1 == null) {
            break label168;
          }
          localObject1 = new a(((c)localObject1).zy);
          ((a)localObject1).zv = this.ze;
          localObject2 = new byte[yA.length];
          ((a)localObject1).readFully((byte[])localObject2);
          ((a)localObject1).seek(0L);
          localObject3 = new byte[yB.length];
          ((a)localObject1).readFully((byte[])localObject3);
          if (Arrays.equals((byte[])localObject2, yA)) {
            ((a)localObject1).seek(8L);
          }
          for (;;)
          {
            b((a)localObject1, 6);
            localObject1 = (c)this.zc[7].get("PreviewImageStart");
            localObject2 = (c)this.zc[7].get("PreviewImageLength");
            if ((localObject1 != null) && (localObject2 != null))
            {
              this.zc[5].put("JPEGInterchangeFormat", localObject1);
              this.zc[5].put("JPEGInterchangeFormatLength", localObject2);
            }
            localObject1 = (c)this.zc[8].get("AspectFrame");
            if (localObject1 == null) {
              break;
            }
            localObject1 = (int[])((c)localObject1).a(this.ze);
            if ((localObject1 != null) && (localObject1.length == 4)) {
              break label1053;
            }
            new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString((int[])localObject1));
            break;
            if (Arrays.equals((byte[])localObject3, yB)) {
              ((a)localObject1).seek(12L);
            }
          }
          localObject1 = c.a(j, this.ze);
          localObject2 = c.a(i, this.ze);
          this.zc[0].put("ImageWidth", localObject1);
          this.zc[0].put("ImageLength", localObject2);
          break label168;
          a(paramInputStream);
          if ((c)this.zc[0].get("JpgFromRaw") != null) {
            a(paramInputStream, this.zp, 5);
          }
          localObject1 = (c)this.zc[0].get("ISO");
          localObject2 = (c)this.zc[1].get("PhotographicSensitivity");
          if ((localObject1 == null) || (localObject2 != null)) {
            break label168;
          }
          this.zc[1].put("PhotographicSensitivity", localObject1);
          break label168;
          a(paramInputStream);
          break label168;
          a(paramInputStream, (HashMap)localObject1);
        }
      case 1: 
      case 7: 
        label697:
        localObject2 = (c)((HashMap)localObject1).get("BitsPerSample");
        if (localObject2 != null)
        {
          localObject2 = (int[])((c)localObject2).a(this.ze);
          if (Arrays.equals(yw, (int[])localObject2)) {
            i = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label244;
      }
      b(paramInputStream, (HashMap)localObject1);
      break label244;
      if (this.zb == 3)
      {
        localObject3 = (c)((HashMap)localObject1).get("PhotometricInterpretation");
        if (localObject3 != null)
        {
          i = ((c)localObject3).b(this.ze);
          if ((i != 1) || (!Arrays.equals((int[])localObject2, yy)))
          {
            if ((i != 6) || (!Arrays.equals((int[])localObject2, yw))) {
              break label1137;
            }
            break label1132;
            this.zk = 6;
            a(paramInputStream, (HashMap)localObject1);
            break label244;
            break label168;
            break label244;
            label1016:
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label1031;
              }
              i = 7;
              break;
            }
            label1028:
            label1031:
            break label325;
            for (;;)
            {
              label1033:
              if (i == 0) {
                break label1048;
              }
              i = 10;
              break;
              label1043:
              i = 0;
            }
            label1048:
            i = 0;
            break;
            label1053:
            if ((localObject1[2] <= localObject1[0]) || (localObject1[3] <= localObject1[1])) {
              break label168;
            }
            int m = localObject1[2] - localObject1[0] + 1;
            int k = localObject1[3] - localObject1[1] + 1;
            i = k;
            j = m;
            if (m >= k) {
              break label697;
            }
            j = m + k;
            i = j - k;
            j -= i;
            break label697;
          }
          label1132:
          i = 1;
          continue;
        }
      }
      label1137:
      i = 0;
    }
  }
  
  private void b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    paramInputStream = new DataInputStream(paramInputStream);
    paramOutputStream = new b(paramOutputStream, ByteOrder.BIG_ENDIAN);
    if (paramInputStream.readByte() != -1) {
      throw new IOException("Invalid marker");
    }
    paramOutputStream.writeByte(-1);
    if (paramInputStream.readByte() != -40) {
      throw new IOException("Invalid marker");
    }
    paramOutputStream.writeByte(-40);
    paramOutputStream.writeByte(-1);
    paramOutputStream.writeByte(-31);
    a(paramOutputStream);
    byte[] arrayOfByte1 = new byte[4096];
    label439:
    for (;;)
    {
      if (paramInputStream.readByte() != -1) {
        throw new IOException("Invalid marker");
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
        if (j < 0) {
          throw new IOException("Invalid length");
        }
      case -31: 
        j = paramInputStream.readUnsignedShort() - 2;
        if (j < 0) {
          throw new IOException("Invalid length");
        }
        byte[] arrayOfByte2 = new byte[6];
        if (j >= 6)
        {
          if (paramInputStream.read(arrayOfByte2) != 6) {
            throw new IOException("Invalid exif");
          }
          if (Arrays.equals(arrayOfByte2, yY))
          {
            if (paramInputStream.skipBytes(j - 6) == j - 6) {
              continue;
            }
            throw new IOException("Invalid length");
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
        return;
        for (;;)
        {
          if (i <= 0) {
            break label439;
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
  
  private static ByteOrder c(a parama)
  {
    int i = parama.readShort();
    switch (i)
    {
    default: 
      throw new IOException("Invalid byte order: " + Integer.toHexString(i));
    case 18761: 
      return ByteOrder.LITTLE_ENDIAN;
    }
    return ByteOrder.BIG_ENDIAN;
  }
  
  private void c(a parama, int paramInt)
  {
    c localc1 = (c)this.zc[paramInt].get("ImageLength");
    c localc2 = (c)this.zc[paramInt].get("ImageWidth");
    if ((localc1 == null) || (localc2 == null))
    {
      localc1 = (c)this.zc[paramInt].get("JPEGInterchangeFormat");
      if (localc1 != null) {
        a(parama, localc1.b(this.ze), paramInt);
      }
    }
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  private static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
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
    return i;
  }
  
  private void d(a parama, int paramInt)
  {
    c localc1 = (c)this.zc[paramInt].get("DefaultCropSize");
    c localc2 = (c)this.zc[paramInt].get("SensorTopBorder");
    c localc3 = (c)this.zc[paramInt].get("SensorLeftBorder");
    c localc4 = (c)this.zc[paramInt].get("SensorBottomBorder");
    c localc5 = (c)this.zc[paramInt].get("SensorRightBorder");
    if (localc1 != null) {
      if (localc1.format == 5)
      {
        parama = (e[])localc1.a(this.ze);
        if ((parama == null) || (parama.length != 2)) {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(parama));
        }
      }
    }
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      localc1 = c.a(parama[0], this.ze);
      for (parama = c.a(parama[1], this.ze);; parama = c.a(parama[1], this.ze))
      {
        this.zc[paramInt].put("ImageWidth", localc1);
        this.zc[paramInt].put("ImageLength", parama);
        return;
        parama = (int[])localc1.a(this.ze);
        if ((parama == null) || (parama.length != 2))
        {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(parama));
          return;
        }
        localc1 = c.a(parama[0], this.ze);
      }
      if ((localc2 == null) || (localc3 == null) || (localc4 == null) || (localc5 == null)) {
        break;
      }
      i = localc2.b(this.ze);
      j = localc4.b(this.ze);
      k = localc5.b(this.ze);
      m = localc3.b(this.ze);
    } while ((j <= i) || (k <= m));
    parama = c.a(j - i, this.ze);
    localc1 = c.a(k - m, this.ze);
    this.zc[paramInt].put("ImageLength", parama);
    this.zc[paramInt].put("ImageWidth", localc1);
    return;
    c(parama, paramInt);
  }
  
  private void dC()
  {
    String str = getAttribute("DateTimeOriginal");
    if ((str != null) && (getAttribute("DateTime") == null)) {
      this.zc[0].put("DateTime", c.n(str));
    }
    if (getAttribute("ImageWidth") == null) {
      this.zc[0].put("ImageWidth", c.a(0L, this.ze));
    }
    if (getAttribute("ImageLength") == null) {
      this.zc[0].put("ImageLength", c.a(0L, this.ze));
    }
    if (getAttribute("Orientation") == null) {
      this.zc[0].put("Orientation", c.a(0L, this.ze));
    }
    if (getAttribute("LightSource") == null) {
      this.zc[1].put("LightSource", c.a(0L, this.ze));
    }
  }
  
  private void dD()
  {
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
    byte[] arrayOfByte = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
    int i = 0;
    while (i < arrayOfByte.length)
    {
      if (paramArrayOfByte[i] != arrayOfByte[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  /* Error */
  private byte[] getThumbnailBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 904	android/support/e/a:zf	Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 1081	android/support/e/a:zj	[B
    //   13: ifnull +8 -> 21
    //   16: aload_0
    //   17: getfield 1081	android/support/e/a:zj	[B
    //   20: areturn
    //   21: aload_0
    //   22: getfield 857	android/support/e/a:za	Landroid/content/res/AssetManager$AssetInputStream;
    //   25: ifnull +44 -> 69
    //   28: aload_0
    //   29: getfield 857	android/support/e/a:za	Landroid/content/res/AssetManager$AssetInputStream;
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 1319	java/io/InputStream:markSupported	()Z
    //   37: ifeq +26 -> 63
    //   40: aload_1
    //   41: invokevirtual 1320	java/io/InputStream:reset	()V
    //   44: aload_1
    //   45: ifnonnull +52 -> 97
    //   48: new 1322	java/io/FileNotFoundException
    //   51: dup
    //   52: invokespecial 1323	java/io/FileNotFoundException:<init>	()V
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   61: aconst_null
    //   62: areturn
    //   63: aload_1
    //   64: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_0
    //   70: getfield 853	android/support/e/a:yZ	Ljava/lang/String;
    //   73: ifnull +115 -> 188
    //   76: new 863	java/io/FileInputStream
    //   79: dup
    //   80: aload_0
    //   81: getfield 853	android/support/e/a:yZ	Ljava/lang/String;
    //   84: invokespecial 864	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   87: astore_1
    //   88: goto -44 -> 44
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -37 -> 57
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 925	android/support/e/a:zg	I
    //   102: i2l
    //   103: invokevirtual 1327	java/io/InputStream:skip	(J)J
    //   106: aload_0
    //   107: getfield 925	android/support/e/a:zg	I
    //   110: i2l
    //   111: lcmp
    //   112: ifeq +21 -> 133
    //   115: new 994	java/io/IOException
    //   118: dup
    //   119: ldc_w 1329
    //   122: invokespecial 1012	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: astore_2
    //   127: aload_1
    //   128: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   131: aload_2
    //   132: athrow
    //   133: aload_0
    //   134: getfield 906	android/support/e/a:zi	I
    //   137: newarray byte
    //   139: astore_2
    //   140: aload_1
    //   141: aload_2
    //   142: invokevirtual 1289	java/io/InputStream:read	([B)I
    //   145: aload_0
    //   146: getfield 906	android/support/e/a:zi	I
    //   149: if_icmpeq +14 -> 163
    //   152: new 994	java/io/IOException
    //   155: dup
    //   156: ldc_w 1329
    //   159: invokespecial 1012	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: aload_0
    //   164: aload_2
    //   165: putfield 1081	android/support/e/a:zj	[B
    //   168: aload_1
    //   169: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   172: aload_2
    //   173: areturn
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -50 -> 127
    //   180: astore_2
    //   181: goto -54 -> 127
    //   184: astore_2
    //   185: goto -128 -> 57
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -146 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	a
    //   32	56	1	localObject1	Object
    //   91	1	1	localIOException1	IOException
    //   93	97	1	localCloseable	Closeable
    //   56	1	2	localIOException2	IOException
    //   126	6	2	localObject2	Object
    //   139	34	2	arrayOfByte	byte[]
    //   174	1	2	localObject3	Object
    //   180	1	2	localObject4	Object
    //   184	1	2	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   48	56	56	java/io/IOException
    //   97	126	56	java/io/IOException
    //   133	163	56	java/io/IOException
    //   163	168	56	java/io/IOException
    //   21	33	91	java/io/IOException
    //   69	88	91	java/io/IOException
    //   48	56	126	finally
    //   97	126	126	finally
    //   133	163	126	finally
    //   163	168	126	finally
    //   21	33	174	finally
    //   69	88	174	finally
    //   33	44	180	finally
    //   33	44	184	java/io/IOException
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
  
  private c k(String paramString)
  {
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString)) {
      str = "PhotographicSensitivity";
    }
    int i = 0;
    while (i < yP.length)
    {
      paramString = (c)this.zc[i].get(str);
      if (paramString != null) {
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  private static Pair<Integer, Integer> m(String paramString)
  {
    Object localObject;
    int i;
    if (paramString.contains(","))
    {
      String[] arrayOfString = paramString.split(",", -1);
      paramString = m(arrayOfString[0]);
      if (((Integer)paramString.first).intValue() == 2) {
        localObject = paramString;
      }
      do
      {
        return localObject;
        i = 1;
        localObject = paramString;
      } while (i >= arrayOfString.length);
      localObject = m(arrayOfString[i]);
      if ((!((Integer)((Pair)localObject).first).equals(paramString.first)) && (!((Integer)((Pair)localObject).second).equals(paramString.first))) {
        break label550;
      }
    }
    label550:
    for (int j = ((Integer)paramString.first).intValue();; j = -1)
    {
      if ((((Integer)paramString.second).intValue() != -1) && ((((Integer)((Pair)localObject).first).equals(paramString.second)) || (((Integer)((Pair)localObject).second).equals(paramString.second)))) {}
      for (int k = ((Integer)paramString.second).intValue();; k = -1)
      {
        if ((j == -1) && (k == -1)) {
          return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
        }
        if (j == -1) {
          paramString = new Pair(Integer.valueOf(k), Integer.valueOf(-1));
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == -1)
          {
            paramString = new Pair(Integer.valueOf(j), Integer.valueOf(-1));
            continue;
            if (paramString.contains("/"))
            {
              paramString = paramString.split("/", -1);
              long l1;
              long l2;
              if (paramString.length == 2) {
                try
                {
                  l1 = Double.parseDouble(paramString[0]);
                  l2 = Double.parseDouble(paramString[1]);
                  if ((l1 >= 0L) && (l2 >= 0L)) {
                    break label348;
                  }
                  paramString = new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                  return paramString;
                }
                catch (NumberFormatException paramString) {}
              } else {
                return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
              }
              label348:
              if ((l1 > 2147483647L) || (l2 > 2147483647L)) {
                return new Pair(Integer.valueOf(5), Integer.valueOf(-1));
              }
              paramString = new Pair(Integer.valueOf(10), Integer.valueOf(5));
              return paramString;
            }
            try
            {
              localObject = Long.valueOf(Long.parseLong(paramString));
              if ((((Long)localObject).longValue() >= 0L) && (((Long)localObject).longValue() <= 65535L))
              {
                localObject = new Pair(Integer.valueOf(3), Integer.valueOf(4));
                return localObject;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              try
              {
                Double.parseDouble(paramString);
                paramString = new Pair(Integer.valueOf(12), Integer.valueOf(-1));
                return paramString;
              }
              catch (NumberFormatException paramString)
              {
                return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
              }
              if (localNumberFormatException.longValue() < 0L) {
                return new Pair(Integer.valueOf(9), Integer.valueOf(-1));
              }
              Pair localPair = new Pair(Integer.valueOf(4), Integer.valueOf(-1));
              return localPair;
            }
          }
        }
      }
    }
  }
  
  private void removeAttribute(String paramString)
  {
    int i = 0;
    while (i < yP.length)
    {
      this.zc[i].remove(paramString);
      i += 1;
    }
  }
  
  private void t(int paramInt1, int paramInt2)
  {
    if ((this.zc[paramInt1].isEmpty()) || (this.zc[paramInt2].isEmpty())) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      c localc1;
      c localc2;
      do
      {
        return;
        localObject1 = (c)this.zc[paramInt1].get("ImageLength");
        localObject2 = (c)this.zc[paramInt1].get("ImageWidth");
        localc1 = (c)this.zc[paramInt2].get("ImageLength");
        localc2 = (c)this.zc[paramInt2].get("ImageWidth");
      } while ((localObject1 == null) || (localObject2 == null) || (localc1 == null) || (localc2 == null));
      i = ((c)localObject1).b(this.ze);
      j = ((c)localObject2).b(this.ze);
      k = localc1.b(this.ze);
      m = localc2.b(this.ze);
    } while ((i >= k) || (j >= m));
    Object localObject1 = this.zc[paramInt1];
    Object localObject2 = this.zc;
    localObject2[paramInt1] = localObject2[paramInt2];
    this.zc[paramInt2] = localObject1;
  }
  
  public final String getAttribute(String paramString)
  {
    c localc = k(paramString);
    if (localc != null)
    {
      if (!yV.contains(paramString)) {
        return localc.c(this.ze);
      }
      if (paramString.equals("GPSTimeStamp"))
      {
        if ((localc.format != 5) && (localc.format != 10))
        {
          new StringBuilder("GPS Timestamp format is not rational. format=").append(localc.format);
          return null;
        }
        paramString = (e[])localc.a(this.ze);
        if ((paramString == null) || (paramString.length != 3))
        {
          new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(paramString));
          return null;
        }
        return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)paramString[0].zB / (float)paramString[0].zC)), Integer.valueOf((int)((float)paramString[1].zB / (float)paramString[1].zC)), Integer.valueOf((int)((float)paramString[2].zB / (float)paramString[2].zC)) });
      }
    }
    try
    {
      paramString = localc.a(this.ze);
      if (paramString == null) {
        throw new NumberFormatException("NULL can't be converted to a double value");
      }
      double d;
      if ((paramString instanceof String)) {
        d = Double.parseDouble((String)paramString);
      }
      for (;;)
      {
        return Double.toString(d);
        if ((paramString instanceof long[]))
        {
          paramString = (long[])paramString;
          if (paramString.length == 1) {
            d = paramString[0];
          } else {
            throw new NumberFormatException("There are more than one component");
          }
        }
        else if ((paramString instanceof int[]))
        {
          paramString = (int[])paramString;
          if (paramString.length == 1) {
            d = paramString[0];
          } else {
            throw new NumberFormatException("There are more than one component");
          }
        }
        else if ((paramString instanceof double[]))
        {
          paramString = (double[])paramString;
          if (paramString.length == 1) {
            d = paramString[0];
          } else {
            throw new NumberFormatException("There are more than one component");
          }
        }
        else
        {
          if (!(paramString instanceof e[])) {
            break label419;
          }
          paramString = (e[])paramString;
          if (paramString.length != 1) {
            break;
          }
          paramString = paramString[0];
          d = paramString.zB / paramString.zC;
        }
      }
      throw new NumberFormatException("There are more than one component");
      label419:
      throw new NumberFormatException("Couldn't find a double value");
    }
    catch (NumberFormatException paramString) {}
    return null;
    return null;
  }
  
  public final int l(String paramString)
  {
    paramString = k(paramString);
    if (paramString == null) {
      return 1;
    }
    try
    {
      int i = paramString.b(this.ze);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  /* Error */
  public final void saveAttributes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1222	android/support/e/a:zq	Z
    //   4: ifeq +11 -> 15
    //   7: aload_0
    //   8: getfield 977	android/support/e/a:zb	I
    //   11: iconst_4
    //   12: if_icmpeq +14 -> 26
    //   15: new 994	java/io/IOException
    //   18: dup
    //   19: ldc_w 1419
    //   22: invokespecial 1012	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: aload_0
    //   27: getfield 853	android/support/e/a:yZ	Ljava/lang/String;
    //   30: ifnonnull +14 -> 44
    //   33: new 994	java/io/IOException
    //   36: dup
    //   37: ldc_w 1421
    //   40: invokespecial 1012	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: aload_0
    //   45: getfield 1220	android/support/e/a:zk	I
    //   48: bipush 6
    //   50: if_icmpeq +12 -> 62
    //   53: aload_0
    //   54: getfield 1220	android/support/e/a:zk	I
    //   57: bipush 7
    //   59: if_icmpne +93 -> 152
    //   62: aload_0
    //   63: invokespecial 961	android/support/e/a:getThumbnailBytes	()[B
    //   66: astore_1
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 1081	android/support/e/a:zj	[B
    //   72: new 1423	java/io/File
    //   75: dup
    //   76: new 996	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 1096	java/lang/StringBuilder:<init>	()V
    //   83: aload_0
    //   84: getfield 853	android/support/e/a:yZ	Ljava/lang/String;
    //   87: invokevirtual 1007	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1425
    //   93: invokevirtual 1007	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 1011	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 1426	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 4
    //   104: new 1423	java/io/File
    //   107: dup
    //   108: aload_0
    //   109: getfield 853	android/support/e/a:yZ	Ljava/lang/String;
    //   112: invokespecial 1426	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: aload 4
    //   117: invokevirtual 1430	java/io/File:renameTo	(Ljava/io/File;)Z
    //   120: ifne +37 -> 157
    //   123: new 994	java/io/IOException
    //   126: dup
    //   127: new 996	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 1432
    //   134: invokespecial 999	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload 4
    //   139: invokevirtual 1435	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: invokevirtual 1007	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 1011	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokespecial 1012	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   151: athrow
    //   152: aconst_null
    //   153: astore_1
    //   154: goto -87 -> 67
    //   157: new 863	java/io/FileInputStream
    //   160: dup
    //   161: aload 4
    //   163: invokespecial 1438	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   166: astore_3
    //   167: new 1440	java/io/FileOutputStream
    //   170: dup
    //   171: aload_0
    //   172: getfield 853	android/support/e/a:yZ	Ljava/lang/String;
    //   175: invokespecial 1441	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   178: astore_2
    //   179: aload_0
    //   180: aload_3
    //   181: aload_2
    //   182: invokespecial 1443	android/support/e/a:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   185: aload_3
    //   186: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   189: aload_2
    //   190: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   193: aload 4
    //   195: invokevirtual 1446	java/io/File:delete	()Z
    //   198: pop
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield 1081	android/support/e/a:zj	[B
    //   204: return
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_3
    //   210: aload_3
    //   211: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   214: aload_2
    //   215: invokestatic 868	android/support/e/a:closeQuietly	(Ljava/io/Closeable;)V
    //   218: aload 4
    //   220: invokevirtual 1446	java/io/File:delete	()Z
    //   223: pop
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_2
    //   229: goto -19 -> 210
    //   232: astore_1
    //   233: goto -23 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	a
    //   66	88	1	arrayOfByte	byte[]
    //   205	20	1	localObject1	Object
    //   226	1	1	localObject2	Object
    //   232	1	1	localObject3	Object
    //   178	51	2	localFileOutputStream	java.io.FileOutputStream
    //   166	45	3	localFileInputStream	FileInputStream
    //   102	117	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   157	167	205	finally
    //   167	179	226	finally
    //   179	185	232	finally
  }
  
  public final void setAttribute(String paramString1, String paramString2)
  {
    String str = paramString1;
    if ("ISOSpeedRatings".equals(paramString1)) {
      str = "PhotographicSensitivity";
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (yV.contains(str))
      {
        if (!str.equals("GPSTimeStamp")) {
          break label221;
        }
        paramString1 = zt.matcher(paramString2);
        if (!paramString1.find())
        {
          new StringBuilder("Invalid value for ").append(str).append(" : ").append(paramString2);
          return;
        }
        paramString1 = Integer.parseInt(paramString1.group(1)) + "/1," + Integer.parseInt(paramString1.group(2)) + "/1," + Integer.parseInt(paramString1.group(3)) + "/1";
      }
    }
    int j = 0;
    label154:
    if (j < yP.length) {
      if ((j != 4) || (this.zf))
      {
        paramString2 = (d)yU[j].get(str);
        if (paramString2 != null)
        {
          if (paramString1 != null) {
            break label267;
          }
          this.zc[j].remove(str);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        j += 1;
        break label154;
        break;
        try
        {
          label221:
          paramString1 = new e(Double.parseDouble(paramString2)).toString();
        }
        catch (NumberFormatException paramString1)
        {
          new StringBuilder("Invalid value for ").append(str).append(" : ").append(paramString2);
          return;
        }
      }
      label267:
      Object localObject1 = m(paramString1);
      int i;
      if ((paramString2.zz == ((Integer)((Pair)localObject1).first).intValue()) || (paramString2.zz == ((Integer)((Pair)localObject1).second).intValue())) {
        i = paramString2.zz;
      }
      label314:
      Object localObject2;
      switch (i)
      {
      case 6: 
      case 8: 
      case 11: 
      default: 
        break;
      case 1: 
        localObject1 = this.zc[j];
        if ((paramString1.length() == 1) && (paramString1.charAt(0) >= '0') && (paramString1.charAt(0) <= '1')) {}
        for (paramString2 = new c(1, 1, new byte[] { (byte)(paramString1.charAt(0) - '0') });; paramString2 = new c(1, paramString2.length, paramString2))
        {
          ((HashMap)localObject1).put(str, paramString2);
          break;
          if ((paramString2.zA != -1) && ((paramString2.zA == ((Integer)((Pair)localObject1).first).intValue()) || (paramString2.zA == ((Integer)((Pair)localObject1).second).intValue())))
          {
            i = paramString2.zA;
            break label314;
          }
          if ((paramString2.zz == 1) || (paramString2.zz == 7) || (paramString2.zz == 2))
          {
            i = paramString2.zz;
            break label314;
          }
          localObject2 = new StringBuilder("Given tag (").append(str).append(") value didn't match with one of expected formats: ").append(yD[paramString2.zz]);
          if (paramString2.zA == -1)
          {
            paramString2 = "";
            localObject2 = ((StringBuilder)localObject2).append(paramString2).append(" (guess: ").append(yD[((Integer)localObject1.first).intValue()]);
            if (((Integer)((Pair)localObject1).second).intValue() != -1) {
              break label679;
            }
          }
          for (paramString2 = "";; paramString2 = ", " + yD[((Integer)localObject1.second).intValue()])
          {
            ((StringBuilder)localObject2).append(paramString2).append(")");
            break;
            paramString2 = ", " + yD[paramString2.zA];
            break label584;
          }
          paramString2 = paramString1.getBytes(yX);
        }
      case 2: 
      case 7: 
        this.zc[j].put(str, c.n(paramString1));
        break;
      case 3: 
        paramString2 = paramString1.split(",", -1);
        localObject1 = new int[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Integer.parseInt(paramString2[i]);
          i += 1;
        }
        this.zc[j].put(str, c.a((int[])localObject1, this.ze));
        break;
      case 9: 
        paramString2 = paramString1.split(",", -1);
        localObject1 = new int[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Integer.parseInt(paramString2[i]);
          i += 1;
        }
        this.zc[j].put(str, c.b((int[])localObject1, this.ze));
        break;
      case 4: 
        paramString2 = paramString1.split(",", -1);
        localObject1 = new long[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Long.parseLong(paramString2[i]);
          i += 1;
        }
        this.zc[j].put(str, c.a((long[])localObject1, this.ze));
        break;
      case 5: 
        paramString2 = paramString1.split(",", -1);
        localObject1 = new e[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject2 = paramString2[i].split("/", -1);
          localObject1[i] = new e(Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]));
          i += 1;
        }
        this.zc[j].put(str, c.a((e[])localObject1, this.ze));
        break;
      case 10: 
        paramString2 = paramString1.split(",", -1);
        localObject1 = new e[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject2 = paramString2[i].split("/", -1);
          localObject1[i] = new e(Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]));
          i += 1;
        }
        this.zc[j].put(str, c.b((e[])localObject1, this.ze));
        break;
      case 12: 
        label584:
        paramString2 = paramString1.split(",", -1);
        label679:
        localObject1 = new double[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Double.parseDouble(paramString2[i]);
          i += 1;
        }
        this.zc[j].put(str, c.a((double[])localObject1, this.ze));
      }
    }
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
    ByteOrder zv = ByteOrder.BIG_ENDIAN;
    
    public a(InputStream paramInputStream)
    {
      this.zu = new DataInputStream(paramInputStream);
      this.mLength = this.zu.available();
      this.mPosition = 0;
      this.zu.mark(this.mLength);
    }
    
    public a(byte[] paramArrayOfByte)
    {
      this(new ByteArrayInputStream(paramArrayOfByte));
    }
    
    public final int available()
    {
      return this.zu.available();
    }
    
    public final long dE()
    {
      return readInt() & 0xFFFFFFFF;
    }
    
    public final int read()
    {
      this.mPosition += 1;
      return this.zu.read();
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = this.zu.read(paramArrayOfByte, paramInt1, paramInt2);
      this.mPosition += paramInt1;
      return paramInt1;
    }
    
    public final boolean readBoolean()
    {
      this.mPosition += 1;
      return this.zu.readBoolean();
    }
    
    public final byte readByte()
    {
      this.mPosition += 1;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.zu.read();
      if (i < 0) {
        throw new EOFException();
      }
      return (byte)i;
    }
    
    public final char readChar()
    {
      this.mPosition += 2;
      return this.zu.readChar();
    }
    
    public final double readDouble()
    {
      return Double.longBitsToDouble(readLong());
    }
    
    public final float readFloat()
    {
      return Float.intBitsToFloat(readInt());
    }
    
    public final void readFully(byte[] paramArrayOfByte)
    {
      this.mPosition += paramArrayOfByte.length;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      if (this.zu.read(paramArrayOfByte, 0, paramArrayOfByte.length) != paramArrayOfByte.length) {
        throw new IOException("Couldn't read up to the length of buffer");
      }
    }
    
    public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.mPosition += paramInt2;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      if (this.zu.read(paramArrayOfByte, paramInt1, paramInt2) != paramInt2) {
        throw new IOException("Couldn't read up to the length of buffer");
      }
    }
    
    public final int readInt()
    {
      this.mPosition += 4;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.zu.read();
      int j = this.zu.read();
      int k = this.zu.read();
      int m = this.zu.read();
      if ((i | j | k | m) < 0) {
        throw new EOFException();
      }
      if (this.zv == LITTLE_ENDIAN) {
        return i + ((j << 8) + ((k << 16) + (m << 24)));
      }
      if (this.zv == BIG_ENDIAN) {
        return (i << 24) + (j << 16) + (k << 8) + m;
      }
      throw new IOException("Invalid byte order: " + this.zv);
    }
    
    public final String readLine()
    {
      return null;
    }
    
    public final long readLong()
    {
      this.mPosition += 8;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.zu.read();
      int j = this.zu.read();
      int k = this.zu.read();
      int m = this.zu.read();
      int n = this.zu.read();
      int i1 = this.zu.read();
      int i2 = this.zu.read();
      int i3 = this.zu.read();
      if ((i | j | k | m | n | i1 | i2 | i3) < 0) {
        throw new EOFException();
      }
      long l1;
      if (this.zv == LITTLE_ENDIAN)
      {
        l1 = i3;
        long l2 = i2;
        long l3 = i1;
        long l4 = n;
        long l5 = m;
        long l6 = k;
        long l7 = j;
        return i + ((l6 << 16) + ((l4 << 32) + ((l2 << 48) + (l1 << 56) + (l3 << 40)) + (l5 << 24)) + (l7 << 8));
      }
      if (this.zv == BIG_ENDIAN)
      {
        l1 = i;
        return (j << 48) + (l1 << 56) + (k << 40) + (m << 32) + (n << 24) + (i1 << 16) + (i2 << 8) + i3;
      }
      throw new IOException("Invalid byte order: " + this.zv);
    }
    
    public final short readShort()
    {
      this.mPosition += 2;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.zu.read();
      int j = this.zu.read();
      if ((i | j) < 0) {
        throw new EOFException();
      }
      if (this.zv == LITTLE_ENDIAN) {
        return (short)(i + (j << 8));
      }
      if (this.zv == BIG_ENDIAN) {
        return (short)((i << 8) + j);
      }
      throw new IOException("Invalid byte order: " + this.zv);
    }
    
    public final String readUTF()
    {
      this.mPosition += 2;
      return this.zu.readUTF();
    }
    
    public final int readUnsignedByte()
    {
      this.mPosition += 1;
      return this.zu.readUnsignedByte();
    }
    
    public final int readUnsignedShort()
    {
      this.mPosition += 2;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.zu.read();
      int j = this.zu.read();
      if ((i | j) < 0) {
        throw new EOFException();
      }
      if (this.zv == LITTLE_ENDIAN) {
        return i + (j << 8);
      }
      if (this.zv == BIG_ENDIAN) {
        return (i << 8) + j;
      }
      throw new IOException("Invalid byte order: " + this.zv);
    }
    
    public final void seek(long paramLong)
    {
      if (this.mPosition > paramLong)
      {
        this.mPosition = 0;
        this.zu.reset();
        this.zu.mark(this.mLength);
      }
      while (skipBytes((int)paramLong) != (int)paramLong)
      {
        throw new IOException("Couldn't seek up to the byteCount");
        paramLong -= this.mPosition;
      }
    }
    
    public final int skipBytes(int paramInt)
    {
      int i = Math.min(paramInt, this.mLength - this.mPosition);
      paramInt = 0;
      while (paramInt < i) {
        paramInt += this.zu.skipBytes(i - paramInt);
      }
      this.mPosition += paramInt;
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
      this.zw.write(paramArrayOfByte);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.zw.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void writeByte(int paramInt)
    {
      this.zw.write(paramInt);
    }
    
    public final void writeInt(int paramInt)
    {
      if (this.zv == ByteOrder.LITTLE_ENDIAN)
      {
        this.zw.write(paramInt >>> 0 & 0xFF);
        this.zw.write(paramInt >>> 8 & 0xFF);
        this.zw.write(paramInt >>> 16 & 0xFF);
        this.zw.write(paramInt >>> 24 & 0xFF);
      }
      while (this.zv != ByteOrder.BIG_ENDIAN) {
        return;
      }
      this.zw.write(paramInt >>> 24 & 0xFF);
      this.zw.write(paramInt >>> 16 & 0xFF);
      this.zw.write(paramInt >>> 8 & 0xFF);
      this.zw.write(paramInt >>> 0 & 0xFF);
    }
    
    public final void writeShort(short paramShort)
    {
      if (this.zv == ByteOrder.LITTLE_ENDIAN)
      {
        this.zw.write(paramShort >>> 0 & 0xFF);
        this.zw.write(paramShort >>> 8 & 0xFF);
      }
      while (this.zv != ByteOrder.BIG_ENDIAN) {
        return;
      }
      this.zw.write(paramShort >>> 8 & 0xFF);
      this.zw.write(paramShort >>> 0 & 0xFF);
    }
  }
  
  static final class c
  {
    public final int format;
    public final int zx;
    public final byte[] zy;
    
    c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this.format = paramInt1;
      this.zx = paramInt2;
      this.zy = paramArrayOfByte;
    }
    
    public static c a(int paramInt, ByteOrder paramByteOrder)
    {
      return a(new int[] { paramInt }, paramByteOrder);
    }
    
    public static c a(long paramLong, ByteOrder paramByteOrder)
    {
      return a(new long[] { paramLong }, paramByteOrder);
    }
    
    public static c a(a.e parame, ByteOrder paramByteOrder)
    {
      return a(new a.e[] { parame }, paramByteOrder);
    }
    
    public static c a(double[] paramArrayOfDouble, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[12] * paramArrayOfDouble.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfDouble.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putDouble(paramArrayOfDouble[i]);
        i += 1;
      }
      return new c(12, paramArrayOfDouble.length, localByteBuffer.array());
    }
    
    public static c a(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[3] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putShort((short)paramArrayOfInt[i]);
        i += 1;
      }
      return new c(3, paramArrayOfInt.length, localByteBuffer.array());
    }
    
    public static c a(long[] paramArrayOfLong, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[4] * paramArrayOfLong.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putInt((int)paramArrayOfLong[i]);
        i += 1;
      }
      return new c(4, paramArrayOfLong.length, localByteBuffer.array());
    }
    
    public static c a(a.e[] paramArrayOfe, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[5] * paramArrayOfe.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfe.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOfe[i];
        localByteBuffer.putInt((int)paramByteOrder.zB);
        localByteBuffer.putInt((int)paramByteOrder.zC);
        i += 1;
      }
      return new c(5, paramArrayOfe.length, localByteBuffer.array());
    }
    
    public static c b(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[9] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putInt(paramArrayOfInt[i]);
        i += 1;
      }
      return new c(9, paramArrayOfInt.length, localByteBuffer.array());
    }
    
    public static c b(a.e[] paramArrayOfe, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.yE[10] * paramArrayOfe.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfe.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOfe[i];
        localByteBuffer.putInt((int)paramByteOrder.zB);
        localByteBuffer.putInt((int)paramByteOrder.zC);
        i += 1;
      }
      return new c(10, paramArrayOfe.length, localByteBuffer.array());
    }
    
    public static c n(String paramString)
    {
      paramString = (paramString + '\000').getBytes(a.yX);
      return new c(2, paramString.length, paramString);
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
      //   25: new 111	android/support/e/a$a
      //   28: dup
      //   29: aload_0
      //   30: getfield 23	android/support/e/a$c:zy	[B
      //   33: invokespecial 114	android/support/e/a$a:<init>	([B)V
      //   36: astore 12
      //   38: aload 12
      //   40: aload_1
      //   41: putfield 118	android/support/e/a$a:zv	Ljava/nio/ByteOrder;
      //   44: aload_0
      //   45: getfield 19	android/support/e/a$c:format	I
      //   48: istore 11
      //   50: iload 11
      //   52: tableswitch	default:+64 -> 116, 1:+71->123, 2:+160->212, 3:+291->343, 4:+332->384, 5:+375->427, 6:+71->123, 7:+160->212, 8:+432->484, 9:+476->528, 10:+520->572, 11:+579->631, 12:+624->676
      //   117: fconst_1
      //   118: invokevirtual 121	android/support/e/a$a:close	()V
      //   121: aconst_null
      //   122: areturn
      //   123: aload_0
      //   124: getfield 23	android/support/e/a$c:zy	[B
      //   127: arraylength
      //   128: iconst_1
      //   129: if_icmpne +57 -> 186
      //   132: aload_0
      //   133: getfield 23	android/support/e/a$c:zy	[B
      //   136: iconst_0
      //   137: baload
      //   138: iflt +48 -> 186
      //   141: aload_0
      //   142: getfield 23	android/support/e/a$c:zy	[B
      //   145: iconst_0
      //   146: baload
      //   147: iconst_1
      //   148: if_icmpgt +38 -> 186
      //   151: new 102	java/lang/String
      //   154: dup
      //   155: iconst_1
      //   156: newarray char
      //   158: dup
      //   159: iconst_0
      //   160: aload_0
      //   161: getfield 23	android/support/e/a$c:zy	[B
      //   164: iconst_0
      //   165: baload
      //   166: bipush 48
      //   168: iadd
      //   169: i2c
      //   170: castore
      //   171: invokespecial 124	java/lang/String:<init>	([C)V
      //   174: astore_1
      //   175: aload 12
      //   177: invokevirtual 121	android/support/e/a$a:close	()V
      //   180: aload_1
      //   181: areturn
      //   182: astore 12
      //   184: aload_1
      //   185: areturn
      //   186: new 102	java/lang/String
      //   189: dup
      //   190: aload_0
      //   191: getfield 23	android/support/e/a$c:zy	[B
      //   194: getstatic 100	android/support/e/a:yX	Ljava/nio/charset/Charset;
      //   197: invokespecial 127	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   200: astore_1
      //   201: aload 12
      //   203: invokevirtual 121	android/support/e/a$a:close	()V
      //   206: aload_1
      //   207: areturn
      //   208: astore 12
      //   210: aload_1
      //   211: areturn
      //   212: aload_0
      //   213: getfield 21	android/support/e/a$c:zx	I
      //   216: getstatic 130	android/support/e/a:yF	[B
      //   219: arraylength
      //   220: if_icmplt +540 -> 760
      //   223: iconst_0
      //   224: istore_2
      //   225: iload 4
      //   227: istore_3
      //   228: iload_2
      //   229: getstatic 130	android/support/e/a:yF	[B
      //   232: arraylength
      //   233: if_icmpge +19 -> 252
      //   236: aload_0
      //   237: getfield 23	android/support/e/a$c:zy	[B
      //   240: iload_2
      //   241: baload
      //   242: getstatic 130	android/support/e/a:yF	[B
      //   245: iload_2
      //   246: baload
      //   247: if_icmpeq +525 -> 772
      //   250: iconst_0
      //   251: istore_3
      //   252: iload_3
      //   253: ifeq +507 -> 760
      //   256: getstatic 130	android/support/e/a:yF	[B
      //   259: arraylength
      //   260: istore_2
      //   261: new 84	java/lang/StringBuilder
      //   264: dup
      //   265: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   268: astore_1
      //   269: iload_2
      //   270: aload_0
      //   271: getfield 21	android/support/e/a$c:zx	I
      //   274: if_icmpge +53 -> 327
      //   277: aload_0
      //   278: getfield 23	android/support/e/a$c:zy	[B
      //   281: iload_2
      //   282: baload
      //   283: istore_3
      //   284: iload_3
      //   285: ifeq +42 -> 327
      //   288: iload_3
      //   289: bipush 32
      //   291: if_icmplt +13 -> 304
      //   294: aload_1
      //   295: iload_3
      //   296: i2c
      //   297: invokevirtual 92	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   300: pop
      //   301: goto +464 -> 765
      //   304: aload_1
      //   305: bipush 63
      //   307: invokevirtual 92	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   310: pop
      //   311: goto +454 -> 765
      //   314: astore_1
      //   315: aload 12
      //   317: ifnull +8 -> 325
      //   320: aload 12
      //   322: invokevirtual 121	android/support/e/a$a:close	()V
      //   325: aconst_null
      //   326: areturn
      //   327: aload_1
      //   328: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   331: astore_1
      //   332: aload 12
      //   334: invokevirtual 121	android/support/e/a$a:close	()V
      //   337: aload_1
      //   338: areturn
      //   339: astore 12
      //   341: aload_1
      //   342: areturn
      //   343: aload_0
      //   344: getfield 21	android/support/e/a$c:zx	I
      //   347: newarray int
      //   349: astore_1
      //   350: iload_2
      //   351: aload_0
      //   352: getfield 21	android/support/e/a$c:zx	I
      //   355: if_icmpge +18 -> 373
      //   358: aload_1
      //   359: iload_2
      //   360: aload 12
      //   362: invokevirtual 134	android/support/e/a$a:readUnsignedShort	()I
      //   365: iastore
      //   366: iload_2
      //   367: iconst_1
      //   368: iadd
      //   369: istore_2
      //   370: goto -20 -> 350
      //   373: aload 12
      //   375: invokevirtual 121	android/support/e/a$a:close	()V
      //   378: aload_1
      //   379: areturn
      //   380: astore 12
      //   382: aload_1
      //   383: areturn
      //   384: aload_0
      //   385: getfield 21	android/support/e/a$c:zx	I
      //   388: newarray long
      //   390: astore_1
      //   391: iload_3
      //   392: istore_2
      //   393: iload_2
      //   394: aload_0
      //   395: getfield 21	android/support/e/a$c:zx	I
      //   398: if_icmpge +18 -> 416
      //   401: aload_1
      //   402: iload_2
      //   403: aload 12
      //   405: invokevirtual 138	android/support/e/a$a:dE	()J
      //   408: lastore
      //   409: iload_2
      //   410: iconst_1
      //   411: iadd
      //   412: istore_2
      //   413: goto -20 -> 393
      //   416: aload 12
      //   418: invokevirtual 121	android/support/e/a$a:close	()V
      //   421: aload_1
      //   422: areturn
      //   423: astore 12
      //   425: aload_1
      //   426: areturn
      //   427: aload_0
      //   428: getfield 21	android/support/e/a$c:zx	I
      //   431: anewarray 36	android/support/e/a$e
      //   434: astore_1
      //   435: iload 5
      //   437: istore_2
      //   438: iload_2
      //   439: aload_0
      //   440: getfield 21	android/support/e/a$c:zx	I
      //   443: if_icmpge +30 -> 473
      //   446: aload_1
      //   447: iload_2
      //   448: new 36	android/support/e/a$e
      //   451: dup
      //   452: aload 12
      //   454: invokevirtual 138	android/support/e/a$a:dE	()J
      //   457: aload 12
      //   459: invokevirtual 138	android/support/e/a$a:dE	()J
      //   462: invokespecial 141	android/support/e/a$e:<init>	(JJ)V
      //   465: aastore
      //   466: iload_2
      //   467: iconst_1
      //   468: iadd
      //   469: istore_2
      //   470: goto -32 -> 438
      //   473: aload 12
      //   475: invokevirtual 121	android/support/e/a$a:close	()V
      //   478: aload_1
      //   479: areturn
      //   480: astore 12
      //   482: aload_1
      //   483: areturn
      //   484: aload_0
      //   485: getfield 21	android/support/e/a$c:zx	I
      //   488: newarray int
      //   490: astore_1
      //   491: iload 6
      //   493: istore_2
      //   494: iload_2
      //   495: aload_0
      //   496: getfield 21	android/support/e/a$c:zx	I
      //   499: if_icmpge +18 -> 517
      //   502: aload_1
      //   503: iload_2
      //   504: aload 12
      //   506: invokevirtual 145	android/support/e/a$a:readShort	()S
      //   509: iastore
      //   510: iload_2
      //   511: iconst_1
      //   512: iadd
      //   513: istore_2
      //   514: goto -20 -> 494
      //   517: aload 12
      //   519: invokevirtual 121	android/support/e/a$a:close	()V
      //   522: aload_1
      //   523: areturn
      //   524: astore 12
      //   526: aload_1
      //   527: areturn
      //   528: aload_0
      //   529: getfield 21	android/support/e/a$c:zx	I
      //   532: newarray int
      //   534: astore_1
      //   535: iload 7
      //   537: istore_2
      //   538: iload_2
      //   539: aload_0
      //   540: getfield 21	android/support/e/a$c:zx	I
      //   543: if_icmpge +18 -> 561
      //   546: aload_1
      //   547: iload_2
      //   548: aload 12
      //   550: invokevirtual 148	android/support/e/a$a:readInt	()I
      //   553: iastore
      //   554: iload_2
      //   555: iconst_1
      //   556: iadd
      //   557: istore_2
      //   558: goto -20 -> 538
      //   561: aload 12
      //   563: invokevirtual 121	android/support/e/a$a:close	()V
      //   566: aload_1
      //   567: areturn
      //   568: astore 12
      //   570: aload_1
      //   571: areturn
      //   572: aload_0
      //   573: getfield 21	android/support/e/a$c:zx	I
      //   576: anewarray 36	android/support/e/a$e
      //   579: astore_1
      //   580: iload 8
      //   582: istore_2
      //   583: iload_2
      //   584: aload_0
      //   585: getfield 21	android/support/e/a$c:zx	I
      //   588: if_icmpge +32 -> 620
      //   591: aload_1
      //   592: iload_2
      //   593: new 36	android/support/e/a$e
      //   596: dup
      //   597: aload 12
      //   599: invokevirtual 148	android/support/e/a$a:readInt	()I
      //   602: i2l
      //   603: aload 12
      //   605: invokevirtual 148	android/support/e/a$a:readInt	()I
      //   608: i2l
      //   609: invokespecial 141	android/support/e/a$e:<init>	(JJ)V
      //   612: aastore
      //   613: iload_2
      //   614: iconst_1
      //   615: iadd
      //   616: istore_2
      //   617: goto -34 -> 583
      //   620: aload 12
      //   622: invokevirtual 121	android/support/e/a$a:close	()V
      //   625: aload_1
      //   626: areturn
      //   627: astore 12
      //   629: aload_1
      //   630: areturn
      //   631: aload_0
      //   632: getfield 21	android/support/e/a$c:zx	I
      //   635: newarray double
      //   637: astore_1
      //   638: iload 9
      //   640: istore_2
      //   641: iload_2
      //   642: aload_0
      //   643: getfield 21	android/support/e/a$c:zx	I
      //   646: if_icmpge +19 -> 665
      //   649: aload_1
      //   650: iload_2
      //   651: aload 12
      //   653: invokevirtual 152	android/support/e/a$a:readFloat	()F
      //   656: f2d
      //   657: dastore
      //   658: iload_2
      //   659: iconst_1
      //   660: iadd
      //   661: istore_2
      //   662: goto -21 -> 641
      //   665: aload 12
      //   667: invokevirtual 121	android/support/e/a$a:close	()V
      //   670: aload_1
      //   671: areturn
      //   672: astore 12
      //   674: aload_1
      //   675: areturn
      //   676: aload_0
      //   677: getfield 21	android/support/e/a$c:zx	I
      //   680: newarray double
      //   682: astore_1
      //   683: iload 10
      //   685: istore_2
      //   686: iload_2
      //   687: aload_0
      //   688: getfield 21	android/support/e/a$c:zx	I
      //   691: if_icmpge +18 -> 709
      //   694: aload_1
      //   695: iload_2
      //   696: aload 12
      //   698: invokevirtual 156	android/support/e/a$a:readDouble	()D
      //   701: dastore
      //   702: iload_2
      //   703: iconst_1
      //   704: iadd
      //   705: istore_2
      //   706: goto -20 -> 686
      //   709: aload 12
      //   711: invokevirtual 121	android/support/e/a$a:close	()V
      //   714: aload_1
      //   715: areturn
      //   716: astore 12
      //   718: aload_1
      //   719: areturn
      //   720: astore_1
      //   721: aconst_null
      //   722: astore 12
      //   724: aload 12
      //   726: ifnull +8 -> 734
      //   729: aload 12
      //   731: invokevirtual 121	android/support/e/a$a:close	()V
      //   734: aload_1
      //   735: athrow
      //   736: astore_1
      //   737: goto -616 -> 121
      //   740: astore_1
      //   741: goto -416 -> 325
      //   744: astore 12
      //   746: goto -12 -> 734
      //   749: astore_1
      //   750: goto -26 -> 724
      //   753: astore_1
      //   754: aconst_null
      //   755: astore 12
      //   757: goto -442 -> 315
      //   760: iconst_0
      //   761: istore_2
      //   762: goto -501 -> 261
      //   765: iload_2
      //   766: iconst_1
      //   767: iadd
      //   768: istore_2
      //   769: goto -500 -> 269
      //   772: iload_2
      //   773: iconst_1
      //   774: iadd
      //   775: istore_2
      //   776: goto -551 -> 225
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	779	0	this	c
      //   0	779	1	paramByteOrder	ByteOrder
      //   24	752	2	i	int
      //   4	388	3	j	int
      //   1	225	4	k	int
      //   6	430	5	m	int
      //   9	483	6	n	int
      //   12	524	7	i1	int
      //   15	566	8	i2	int
      //   18	621	9	i3	int
      //   21	663	10	i4	int
      //   48	3	11	i5	int
      //   36	140	12	locala	a.a
      //   182	20	12	localIOException1	IOException
      //   208	125	12	localIOException2	IOException
      //   339	35	12	localIOException3	IOException
      //   380	37	12	localIOException4	IOException
      //   423	51	12	localIOException5	IOException
      //   480	38	12	localIOException6	IOException
      //   524	38	12	localIOException7	IOException
      //   568	53	12	localIOException8	IOException
      //   627	39	12	localIOException9	IOException
      //   672	38	12	localIOException10	IOException
      //   716	1	12	localIOException11	IOException
      //   722	8	12	localObject1	Object
      //   744	1	12	localIOException12	IOException
      //   755	1	12	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   175	180	182	java/io/IOException
      //   201	206	208	java/io/IOException
      //   38	50	314	java/io/IOException
      //   123	175	314	java/io/IOException
      //   186	201	314	java/io/IOException
      //   212	223	314	java/io/IOException
      //   228	250	314	java/io/IOException
      //   256	261	314	java/io/IOException
      //   261	269	314	java/io/IOException
      //   269	284	314	java/io/IOException
      //   294	301	314	java/io/IOException
      //   304	311	314	java/io/IOException
      //   327	332	314	java/io/IOException
      //   343	350	314	java/io/IOException
      //   350	366	314	java/io/IOException
      //   384	391	314	java/io/IOException
      //   393	409	314	java/io/IOException
      //   427	435	314	java/io/IOException
      //   438	466	314	java/io/IOException
      //   484	491	314	java/io/IOException
      //   494	510	314	java/io/IOException
      //   528	535	314	java/io/IOException
      //   538	554	314	java/io/IOException
      //   572	580	314	java/io/IOException
      //   583	613	314	java/io/IOException
      //   631	638	314	java/io/IOException
      //   641	658	314	java/io/IOException
      //   676	683	314	java/io/IOException
      //   686	702	314	java/io/IOException
      //   332	337	339	java/io/IOException
      //   373	378	380	java/io/IOException
      //   416	421	423	java/io/IOException
      //   473	478	480	java/io/IOException
      //   517	522	524	java/io/IOException
      //   561	566	568	java/io/IOException
      //   620	625	627	java/io/IOException
      //   665	670	672	java/io/IOException
      //   709	714	716	java/io/IOException
      //   25	38	720	finally
      //   116	121	736	java/io/IOException
      //   320	325	740	java/io/IOException
      //   729	734	744	java/io/IOException
      //   38	50	749	finally
      //   123	175	749	finally
      //   186	201	749	finally
      //   212	223	749	finally
      //   228	250	749	finally
      //   256	261	749	finally
      //   261	269	749	finally
      //   269	284	749	finally
      //   294	301	749	finally
      //   304	311	749	finally
      //   327	332	749	finally
      //   343	350	749	finally
      //   350	366	749	finally
      //   384	391	749	finally
      //   393	409	749	finally
      //   427	435	749	finally
      //   438	466	749	finally
      //   484	491	749	finally
      //   494	510	749	finally
      //   528	535	749	finally
      //   538	554	749	finally
      //   572	580	749	finally
      //   583	613	749	finally
      //   631	638	749	finally
      //   641	658	749	finally
      //   676	683	749	finally
      //   686	702	749	finally
      //   25	38	753	java/io/IOException
    }
    
    public final int b(ByteOrder paramByteOrder)
    {
      paramByteOrder = a(paramByteOrder);
      if (paramByteOrder == null) {
        throw new NumberFormatException("NULL can't be converted to a integer value");
      }
      if ((paramByteOrder instanceof String)) {
        return Integer.parseInt((String)paramByteOrder);
      }
      if ((paramByteOrder instanceof long[]))
      {
        paramByteOrder = (long[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return (int)paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      if ((paramByteOrder instanceof int[]))
      {
        paramByteOrder = (int[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      throw new NumberFormatException("Couldn't find a integer value");
    }
    
    public final String c(ByteOrder paramByteOrder)
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      Object localObject = a(paramByteOrder);
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof String)) {
        return (String)localObject;
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
        return paramByteOrder.toString();
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
        return paramByteOrder.toString();
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
        return paramByteOrder.toString();
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
        return paramByteOrder.toString();
      }
      return null;
    }
    
    public final int size()
    {
      return a.yE[this.format] * this.zx;
    }
    
    public final String toString()
    {
      return "(" + a.yD[this.format] + ", data length:" + this.zy.length + ")";
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
    
    e(double paramDouble)
    {
      this((10000.0D * paramDouble), 10000L);
    }
    
    e(long paramLong1, long paramLong2)
    {
      if (paramLong2 == 0L)
      {
        this.zB = 0L;
        this.zC = 1L;
        return;
      }
      this.zB = paramLong1;
      this.zC = paramLong2;
    }
    
    public final String toString()
    {
      return this.zB + "/" + this.zC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.e.a
 * JD-Core Version:    0.7.0.1
 */