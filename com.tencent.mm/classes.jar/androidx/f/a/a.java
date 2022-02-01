package androidx.f.a;

import android.content.res.AssetManager.AssetInputStream;
import android.media.MediaDataSource;
import android.os.Build.VERSION;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
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
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class a
{
  private static final boolean DEBUG;
  private static final Pattern OB;
  private static final Pattern OC;
  private static final Pattern OD;
  static final byte[] OM;
  static final Charset Oj;
  static final String[] Ok;
  static final int[] Ol;
  static final byte[] Om;
  private static final HashSet<String> Ox;
  public static final String TAG_APERTURE_VALUE = "ApertureValue";
  public static final String TAG_ARTIST = "Artist";
  public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
  public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
  public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
  @Deprecated
  public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
  public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
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
  public static final String TAG_OFFSET_TIME = "OffsetTime";
  public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
  public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
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
  public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
  public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
  public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
  public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
  public static final String TAG_USER_COMMENT = "UserComment";
  public static final String TAG_WHITE_BALANCE = "WhiteBalance";
  public static final String TAG_WHITE_POINT = "WhitePoint";
  public static final String TAG_XMP = "Xmp";
  public static final String TAG_X_RESOLUTION = "XResolution";
  public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
  public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
  public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
  public static final String TAG_Y_RESOLUTION = "YResolution";
  private static final Pattern bAU;
  private static final byte[] bAa;
  private static final byte[] bAb;
  private static final byte[] bAc;
  private static final byte[] bAd;
  private static final byte[] bAe;
  private static final byte[] bAf;
  private static final byte[] bAg;
  private static final byte[] bAh;
  private static SimpleDateFormat bAi;
  private static SimpleDateFormat bAj;
  private static final d[] bAk;
  private static final d[] bAl;
  private static final d[] bAm;
  private static final d[] bAn;
  private static final d[] bAo;
  private static final d[] bAp;
  private static final d[] bAq;
  private static final d[] bAr;
  private static final d[] bAs;
  static final d[][] bAt;
  private static final d[] bAu;
  private static final HashMap<Integer, d>[] bAv;
  private static final HashMap<String, d>[] bAw;
  private static final HashMap<Integer, Integer> bAx;
  private static final byte[] bAy;
  private static final List<Integer> bzK;
  private static final List<Integer> bzL;
  public static final int[] bzM;
  public static final int[] bzN;
  public static final int[] bzO;
  static final byte[] bzP;
  private static final byte[] bzQ;
  private static final byte[] bzR;
  private static final byte[] bzS;
  private static final byte[] bzT;
  private static final byte[] bzU;
  private static final byte[] bzV;
  private static final byte[] bzW;
  private static final byte[] bzX;
  private static final byte[] bzY;
  private static final byte[] bzZ;
  private FileDescriptor bAA;
  private AssetManager.AssetInputStream bAB;
  private int bAC;
  private boolean bAD;
  private final HashMap<String, c>[] bAE;
  private Set<Integer> bAF;
  private ByteOrder bAG;
  private boolean bAH;
  private boolean bAI;
  private boolean bAJ;
  private int bAK;
  private int bAL;
  private byte[] bAM;
  private int bAN;
  private int bAO;
  private int bAP;
  private int bAQ;
  private int bAR;
  private boolean bAS;
  private boolean bAT;
  private String bAz;
  
  static
  {
    AppMethodBeat.i(178752);
    DEBUG = Log.isLoggable("ExifInterface", 3);
    bzK = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8) });
    bzL = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5) });
    bzM = new int[] { 8, 8, 8 };
    bzN = new int[] { 4 };
    bzO = new int[] { 8 };
    bzP = new byte[] { -1, -40, -1 };
    bzQ = new byte[] { 102, 116, 121, 112 };
    bzR = new byte[] { 109, 105, 102, 49 };
    bzS = new byte[] { 104, 101, 105, 99 };
    bzT = new byte[] { 79, 76, 89, 77, 80, 0 };
    bzU = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
    bzV = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
    bzW = new byte[] { 101, 88, 73, 102 };
    bzX = new byte[] { 73, 72, 68, 82 };
    bzY = new byte[] { 73, 69, 78, 68 };
    bzZ = new byte[] { 82, 73, 70, 70 };
    bAa = new byte[] { 87, 69, 66, 80 };
    bAb = new byte[] { 69, 88, 73, 70 };
    bAc = new byte[] { -99, 1, 42 };
    bAd = "VP8X".getBytes(Charset.defaultCharset());
    bAe = "VP8L".getBytes(Charset.defaultCharset());
    bAf = "VP8 ".getBytes(Charset.defaultCharset());
    bAg = "ANIM".getBytes(Charset.defaultCharset());
    bAh = "ANMF".getBytes(Charset.defaultCharset());
    Ok = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
    Ol = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
    Om = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
    bAk = new d[] { new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1) };
    bAl = new d[] { new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4) };
    bAm = new d[] { new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5) };
    bAn = new d[] { new d("InteroperabilityIndex", 1, 2) };
    bAo = new d[] { new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Xmp", 700, 1), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4) };
    TAG_RAF_IMAGE_SIZE = new d("StripOffsets", 273, 3);
    bAp = new d[] { new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4) };
    bAq = new d[] { new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4) };
    bAr = new d[] { new d("AspectFrame", 4371, 3) };
    bAs = new d[] { new d("ColorSpace", 55, 3) };
    bAt = new d[][] { bAk, bAl, bAm, bAn, bAo, bAk, bAp, bAq, bAr, bAs };
    bAu = new d[] { new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1) };
    bAv = new HashMap[bAt.length];
    bAw = new HashMap[bAt.length];
    Ox = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    bAx = new HashMap();
    Oj = Charset.forName("US-ASCII");
    OM = "".getBytes(Oj);
    bAy = "".getBytes(Oj);
    Object localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
    bAi = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    bAj = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    int i = 0;
    while (i < bAt.length)
    {
      bAv[i] = new HashMap();
      bAw[i] = new HashMap();
      localObject1 = bAt[i];
      int k = localObject1.length;
      int j = 0;
      while (j < k)
      {
        Object localObject2 = localObject1[j];
        bAv[i].put(Integer.valueOf(localObject2.number), localObject2);
        bAw[i].put(localObject2.name, localObject2);
        j += 1;
      }
      i += 1;
    }
    bAx.put(Integer.valueOf(bAu[0].number), Integer.valueOf(5));
    bAx.put(Integer.valueOf(bAu[1].number), Integer.valueOf(1));
    bAx.put(Integer.valueOf(bAu[2].number), Integer.valueOf(2));
    bAx.put(Integer.valueOf(bAu[3].number), Integer.valueOf(3));
    bAx.put(Integer.valueOf(bAu[4].number), Integer.valueOf(7));
    bAx.put(Integer.valueOf(bAu[5].number), Integer.valueOf(8));
    bAU = Pattern.compile(".*[1-9].*");
    OB = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    OC = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    OD = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    AppMethodBeat.o(178752);
  }
  
  public a(InputStream paramInputStream)
  {
    this(paramInputStream, (byte)0);
    AppMethodBeat.i(178714);
    AppMethodBeat.o(178714);
  }
  
  private a(InputStream paramInputStream, byte paramByte)
  {
    AppMethodBeat.i(192888);
    this.bAE = new HashMap[bAt.length];
    this.bAF = new HashSet(bAt.length);
    this.bAG = ByteOrder.BIG_ENDIAN;
    if (paramInputStream == null)
    {
      paramInputStream = new NullPointerException("inputStream cannot be null");
      AppMethodBeat.o(192888);
      throw paramInputStream;
    }
    this.bAz = null;
    if ((paramInputStream instanceof AssetManager.AssetInputStream))
    {
      this.bAB = ((AssetManager.AssetInputStream)paramInputStream);
      this.bAA = null;
    }
    for (;;)
    {
      i(paramInputStream);
      AppMethodBeat.o(192888);
      return;
      if (((paramInputStream instanceof FileInputStream)) && (a(((FileInputStream)paramInputStream).getFD())))
      {
        this.bAB = null;
        this.bAA = ((FileInputStream)paramInputStream).getFD();
      }
      else
      {
        this.bAB = null;
        this.bAA = null;
      }
    }
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(178713);
    this.bAE = new HashMap[bAt.length];
    this.bAF = new HashSet(bAt.length);
    this.bAG = ByteOrder.BIG_ENDIAN;
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
    this.bAB = null;
    this.bAz = paramString;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      try
      {
        if (a(localFileInputStream.getFD())) {}
        for (this.bAA = localFileInputStream.getFD();; this.bAA = null)
        {
          i(localFileInputStream);
          b.closeQuietly(localFileInputStream);
          AppMethodBeat.o(178713);
          return;
        }
        b.closeQuietly(localFileInputStream);
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
  
  private void FL()
  {
    AppMethodBeat.i(178723);
    int i = 0;
    while (i < this.bAE.length)
    {
      new StringBuilder("The size of tag group[").append(i).append("]: ").append(this.bAE[i].size());
      Iterator localIterator = this.bAE[i].entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        c localc = (c)localEntry.getValue();
        new StringBuilder("tagName: ").append((String)localEntry.getKey()).append(", tagType: ").append(localc.toString()).append(", tagValue: '").append(localc.d(this.bAG)).append("'");
      }
      i += 1;
    }
    AppMethodBeat.o(178723);
  }
  
  /* Error */
  private byte[] FO()
  {
    // Byte code:
    //   0: ldc_w 1115
    //   3: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 1117	androidx/f/a/a:bAH	Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 1115
    //   16: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_0
    //   22: getfield 1119	androidx/f/a/a:bAM	[B
    //   25: ifnull +16 -> 41
    //   28: aload_0
    //   29: getfield 1119	androidx/f/a/a:bAM	[B
    //   32: astore_1
    //   33: ldc_w 1115
    //   36: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: getfield 1024	androidx/f/a/a:bAB	Landroid/content/res/AssetManager$AssetInputStream;
    //   45: ifnull +84 -> 129
    //   48: aload_0
    //   49: getfield 1024	androidx/f/a/a:bAB	Landroid/content/res/AssetManager$AssetInputStream;
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 1124	java/io/InputStream:markSupported	()Z
    //   57: ifeq +60 -> 117
    //   60: aload_2
    //   61: invokevirtual 1127	java/io/InputStream:reset	()V
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: astore_2
    //   70: aload_1
    //   71: ifnonnull +123 -> 194
    //   74: new 1129	java/io/FileNotFoundException
    //   77: dup
    //   78: invokespecial 1130	java/io/FileNotFoundException:<init>	()V
    //   81: astore_3
    //   82: ldc_w 1115
    //   85: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   98: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokestatic 1133	androidx/f/a/b:b	(Ljava/io/FileDescriptor;)V
    //   109: ldc_w 1115
    //   112: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aconst_null
    //   116: areturn
    //   117: aload_2
    //   118: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   121: ldc_w 1115
    //   124: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: aload_0
    //   130: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   133: ifnull +20 -> 153
    //   136: new 1030	java/io/FileInputStream
    //   139: dup
    //   140: aload_0
    //   141: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   144: invokespecial 1041	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -80 -> 70
    //   153: getstatic 1138	android/os/Build$VERSION:SDK_INT	I
    //   156: bipush 21
    //   158: if_icmplt +223 -> 381
    //   161: aload_0
    //   162: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   165: invokestatic 1143	androidx/f/a/b$a:c	(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;
    //   168: astore_1
    //   169: aload_1
    //   170: lconst_0
    //   171: getstatic 1148	android/system/OsConstants:SEEK_SET	I
    //   174: invokestatic 1151	androidx/f/a/b$a:a	(Ljava/io/FileDescriptor;JI)J
    //   177: pop2
    //   178: new 1030	java/io/FileInputStream
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 1153	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   186: astore_3
    //   187: aload_1
    //   188: astore_2
    //   189: aload_3
    //   190: astore_1
    //   191: goto -121 -> 70
    //   194: aload_1
    //   195: aload_0
    //   196: getfield 1155	androidx/f/a/a:bAK	I
    //   199: aload_0
    //   200: getfield 1157	androidx/f/a/a:bAO	I
    //   203: iadd
    //   204: i2l
    //   205: invokevirtual 1161	java/io/InputStream:skip	(J)J
    //   208: aload_0
    //   209: getfield 1155	androidx/f/a/a:bAK	I
    //   212: aload_0
    //   213: getfield 1157	androidx/f/a/a:bAO	I
    //   216: iadd
    //   217: i2l
    //   218: lcmp
    //   219: ifeq +49 -> 268
    //   222: new 1163	java/io/IOException
    //   225: dup
    //   226: ldc_w 1165
    //   229: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   232: astore_3
    //   233: ldc_w 1115
    //   236: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_3
    //   240: athrow
    //   241: astore 4
    //   243: aload_2
    //   244: astore_3
    //   245: aload 4
    //   247: astore_2
    //   248: aload_1
    //   249: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   252: aload_3
    //   253: ifnull +7 -> 260
    //   256: aload_3
    //   257: invokestatic 1133	androidx/f/a/b:b	(Ljava/io/FileDescriptor;)V
    //   260: ldc_w 1115
    //   263: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_2
    //   267: athrow
    //   268: aload_0
    //   269: getfield 1168	androidx/f/a/a:bAL	I
    //   272: newarray byte
    //   274: astore_3
    //   275: aload_1
    //   276: aload_3
    //   277: invokevirtual 1172	java/io/InputStream:read	([B)I
    //   280: aload_0
    //   281: getfield 1168	androidx/f/a/a:bAL	I
    //   284: if_icmpeq +22 -> 306
    //   287: new 1163	java/io/IOException
    //   290: dup
    //   291: ldc_w 1165
    //   294: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   297: astore_3
    //   298: ldc_w 1115
    //   301: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_3
    //   305: athrow
    //   306: aload_0
    //   307: aload_3
    //   308: putfield 1119	androidx/f/a/a:bAM	[B
    //   311: aload_1
    //   312: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   315: aload_2
    //   316: ifnull +7 -> 323
    //   319: aload_2
    //   320: invokestatic 1133	androidx/f/a/b:b	(Ljava/io/FileDescriptor;)V
    //   323: ldc_w 1115
    //   326: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload_3
    //   330: areturn
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_3
    //   334: aconst_null
    //   335: astore_1
    //   336: goto -88 -> 248
    //   339: astore_3
    //   340: aconst_null
    //   341: astore 4
    //   343: aload_2
    //   344: astore_1
    //   345: aload_3
    //   346: astore_2
    //   347: aload 4
    //   349: astore_3
    //   350: goto -102 -> 248
    //   353: astore_2
    //   354: aload_1
    //   355: astore_3
    //   356: aconst_null
    //   357: astore_1
    //   358: goto -110 -> 248
    //   361: astore_1
    //   362: aconst_null
    //   363: astore_1
    //   364: aconst_null
    //   365: astore_2
    //   366: goto -269 -> 97
    //   369: astore_1
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -275 -> 97
    //   375: astore_2
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -281 -> 97
    //   381: aconst_null
    //   382: astore_2
    //   383: aconst_null
    //   384: astore_1
    //   385: goto -315 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	a
    //   32	326	1	localObject1	Object
    //   361	1	1	localException1	Exception
    //   363	1	1	localObject2	Object
    //   369	1	1	localException2	Exception
    //   371	14	1	localObject3	Object
    //   52	268	2	localObject4	Object
    //   331	13	2	localObject5	Object
    //   346	1	2	localObject6	Object
    //   353	1	2	localObject7	Object
    //   365	1	2	localObject8	Object
    //   375	1	2	localException3	Exception
    //   377	6	2	localObject9	Object
    //   65	24	3	localFileNotFoundException	java.io.FileNotFoundException
    //   90	1	3	localException4	Exception
    //   92	242	3	localObject10	Object
    //   339	7	3	localObject11	Object
    //   349	7	3	localObject12	Object
    //   241	5	4	localObject13	Object
    //   341	7	4	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   74	90	90	java/lang/Exception
    //   194	241	90	java/lang/Exception
    //   268	306	90	java/lang/Exception
    //   306	311	90	java/lang/Exception
    //   74	90	241	finally
    //   194	241	241	finally
    //   268	306	241	finally
    //   306	311	241	finally
    //   41	53	331	finally
    //   129	148	331	finally
    //   153	169	331	finally
    //   53	64	339	finally
    //   169	187	353	finally
    //   41	53	361	java/lang/Exception
    //   129	148	361	java/lang/Exception
    //   153	169	361	java/lang/Exception
    //   53	64	369	java/lang/Exception
    //   169	187	375	java/lang/Exception
  }
  
  private void FR()
  {
    AppMethodBeat.i(178736);
    String str = aC("DateTimeOriginal");
    if ((str != null) && (aC("DateTime") == null)) {
      this.bAE[0].put("DateTime", c.aE(str));
    }
    if (aC("ImageWidth") == null) {
      this.bAE[0].put("ImageWidth", c.b(0L, this.bAG));
    }
    if (aC("ImageLength") == null) {
      this.bAE[0].put("ImageLength", c.b(0L, this.bAG));
    }
    if (aC("Orientation") == null) {
      this.bAE[0].put("Orientation", c.b(0L, this.bAG));
    }
    if (aC("LightSource") == null) {
      this.bAE[1].put("LightSource", c.b(0L, this.bAG));
    }
    AppMethodBeat.o(178736);
  }
  
  private void FS()
  {
    AppMethodBeat.i(193229);
    aI(0, 5);
    aI(0, 4);
    aI(5, 4);
    c localc1 = (c)this.bAE[1].get("PixelXDimension");
    c localc2 = (c)this.bAE[1].get("PixelYDimension");
    if ((localc1 != null) && (localc2 != null))
    {
      this.bAE[0].put("ImageWidth", localc1);
      this.bAE[0].put("ImageLength", localc2);
    }
    if ((this.bAE[4].isEmpty()) && (b(this.bAE[5])))
    {
      this.bAE[4] = this.bAE[5];
      this.bAE[5] = new HashMap();
    }
    b(this.bAE[4]);
    b(0, "ThumbnailOrientation", "Orientation");
    b(0, "ThumbnailImageLength", "ImageLength");
    b(0, "ThumbnailImageWidth", "ImageWidth");
    b(5, "ThumbnailOrientation", "Orientation");
    b(5, "ThumbnailImageLength", "ImageLength");
    b(5, "ThumbnailImageWidth", "ImageWidth");
    b(4, "Orientation", "ThumbnailOrientation");
    b(4, "ImageLength", "ThumbnailImageLength");
    b(4, "ImageWidth", "ThumbnailImageWidth");
    AppMethodBeat.o(193229);
  }
  
  private int a(b paramb)
  {
    AppMethodBeat.i(193266);
    int[] arrayOfInt = new int[bAt.length];
    Object localObject1 = new int[bAt.length];
    Object localObject2 = bAu;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      aD(localObject2[i].name);
      i += 1;
    }
    if (this.bAH)
    {
      if (this.bAI)
      {
        aD("StripOffsets");
        aD("StripByteCounts");
      }
    }
    else {
      i = 0;
    }
    int k;
    for (;;)
    {
      if (i >= bAt.length) {
        break label197;
      }
      localObject2 = this.bAE[i].entrySet().toArray();
      k = localObject2.length;
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          Map.Entry localEntry = (Map.Entry)localObject2[j];
          if (localEntry.getValue() == null) {
            this.bAE[i].remove(localEntry.getKey());
          }
          j += 1;
          continue;
          aD("JPEGInterchangeFormat");
          aD("JPEGInterchangeFormatLength");
          break;
        }
      }
      i += 1;
    }
    label197:
    if (!this.bAE[1].isEmpty()) {
      this.bAE[0].put(bAu[1].name, c.b(0L, this.bAG));
    }
    if (!this.bAE[2].isEmpty()) {
      this.bAE[0].put(bAu[2].name, c.b(0L, this.bAG));
    }
    if (!this.bAE[3].isEmpty()) {
      this.bAE[1].put(bAu[3].name, c.b(0L, this.bAG));
    }
    if (this.bAH)
    {
      if (this.bAI)
      {
        this.bAE[4].put("StripOffsets", c.a(0, this.bAG));
        this.bAE[4].put("StripByteCounts", c.a(this.bAL, this.bAG));
      }
    }
    else
    {
      j = 0;
      label373:
      if (j >= bAt.length) {
        break label518;
      }
      localObject2 = this.bAE[j].entrySet().iterator();
      i = 0;
      label401:
      if (!((Iterator)localObject2).hasNext()) {
        break label497;
      }
      k = ((c)((Map.Entry)((Iterator)localObject2).next()).getValue()).size();
      if (k <= 4) {
        break label1449;
      }
      i = k + i;
    }
    label518:
    label1443:
    label1449:
    for (;;)
    {
      break label401;
      this.bAE[4].put("JPEGInterchangeFormat", c.b(0L, this.bAG));
      this.bAE[4].put("JPEGInterchangeFormatLength", c.b(this.bAL, this.bAG));
      break;
      label497:
      localObject1[j] += i;
      j += 1;
      break label373;
      i = 8;
      j = 0;
      while (j < bAt.length)
      {
        k = i;
        if (!this.bAE[j].isEmpty())
        {
          arrayOfInt[j] = i;
          k = i + (this.bAE[j].size() * 12 + 2 + 4 + localObject1[j]);
        }
        j += 1;
        i = k;
      }
      j = i;
      if (this.bAH)
      {
        if (this.bAI)
        {
          this.bAE[4].put("StripOffsets", c.a(i, this.bAG));
          this.bAK = i;
          j = i + this.bAL;
        }
      }
      else {
        if (this.bAC != 4) {
          break label1443;
        }
      }
      for (i = j + 8;; i = j)
      {
        if (DEBUG)
        {
          j = 0;
          for (;;)
          {
            if (j < bAt.length)
            {
              String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(arrayOfInt[j]), Integer.valueOf(this.bAE[j].size()), Integer.valueOf(localObject1[j]), Integer.valueOf(i) });
              j += 1;
              continue;
              this.bAE[4].put("JPEGInterchangeFormat", c.b(i, this.bAG));
              break;
            }
          }
        }
        if (!this.bAE[1].isEmpty()) {
          this.bAE[0].put(bAu[1].name, c.b(arrayOfInt[1], this.bAG));
        }
        if (!this.bAE[2].isEmpty()) {
          this.bAE[0].put(bAu[2].name, c.b(arrayOfInt[2], this.bAG));
        }
        if (!this.bAE[3].isEmpty()) {
          this.bAE[1].put(bAu[3].name, c.b(arrayOfInt[3], this.bAG));
        }
        short s;
        switch (this.bAC)
        {
        default: 
          if (this.bAG == ByteOrder.BIG_ENDIAN)
          {
            s = 19789;
            label954:
            paramb.b(s);
            paramb.NZ = this.bAG;
            paramb.b((short)42);
            paramb.aX(8);
            j = 0;
          }
          break;
        }
        for (;;)
        {
          if (j >= bAt.length) {
            break label1392;
          }
          if (!this.bAE[j].isEmpty())
          {
            paramb.b((short)this.bAE[j].size());
            k = arrayOfInt[j];
            int m = this.bAE[j].size();
            localObject1 = this.bAE[j].entrySet().iterator();
            k = k + 2 + m * 12 + 4;
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1272;
              }
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              int n = ((d)bAw[j].get(((Map.Entry)localObject2).getKey())).number;
              localObject2 = (c)((Map.Entry)localObject2).getValue();
              m = ((c)localObject2).size();
              paramb.b((short)n);
              paramb.b((short)((c)localObject2).format);
              paramb.aX(((c)localObject2).On);
              if (m > 4)
              {
                paramb.aX((int)k);
                k += m;
                continue;
                paramb.b((short)i);
                paramb.write(OM);
                break;
                paramb.aX(i);
                paramb.write(bzW);
                break;
                paramb.write(bAb);
                paramb.aX(i);
                break;
                s = 18761;
                break label954;
              }
              paramb.write(((c)localObject2).Op);
              if (m < 4) {
                while (m < 4)
                {
                  paramb.eQ(0);
                  m += 1;
                }
              }
            }
            label1272:
            if ((j == 0) && (!this.bAE[4].isEmpty())) {
              paramb.aX((int)arrayOfInt[4]);
            }
            for (;;)
            {
              localObject1 = this.bAE[j].entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (c)((Map.Entry)((Iterator)localObject1).next()).getValue();
                if (((c)localObject2).Op.length > 4) {
                  paramb.write(((c)localObject2).Op, 0, ((c)localObject2).Op.length);
                }
              }
              paramb.aX(0);
            }
          }
          j += 1;
        }
        label1392:
        if (this.bAH) {
          paramb.write(FO());
        }
        if ((this.bAC == 14) && (i % 2 == 1)) {
          paramb.eQ(0);
        }
        paramb.NZ = ByteOrder.BIG_ENDIAN;
        AppMethodBeat.o(193266);
        return i;
      }
    }
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(193063);
    if (DEBUG) {
      new StringBuilder("getRafAttributes starting with: ").append(parama);
    }
    parama.eP(84);
    Object localObject = new byte[4];
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[4];
    parama.read((byte[])localObject);
    parama.read(arrayOfByte1);
    parama.read(arrayOfByte2);
    int i = ByteBuffer.wrap((byte[])localObject).getInt();
    int j = ByteBuffer.wrap(arrayOfByte1).getInt();
    int k = ByteBuffer.wrap(arrayOfByte2).getInt();
    localObject = new byte[j];
    parama.eP(i - parama.mPosition);
    parama.read((byte[])localObject);
    a(new a((byte[])localObject), i, 5);
    parama.eP(k - parama.mPosition);
    parama.NZ = ByteOrder.BIG_ENDIAN;
    j = parama.readInt();
    i = 0;
    while (i < j)
    {
      k = parama.readUnsignedShort();
      int m = parama.readUnsignedShort();
      if (k == TAG_RAF_IMAGE_SIZE.number)
      {
        i = parama.readShort();
        j = parama.readShort();
        parama = c.a(i, this.bAG);
        localObject = c.a(j, this.bAG);
        this.bAE[0].put("ImageLength", parama);
        this.bAE[0].put("ImageWidth", localObject);
        if (DEBUG) {
          new StringBuilder("Updated to length: ").append(i).append(", width: ").append(j);
        }
        AppMethodBeat.o(193063);
        return;
      }
      parama.eP(m);
      i += 1;
    }
    AppMethodBeat.o(193063);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178731);
    if (DEBUG) {
      new StringBuilder("getJpegAttributes starting with: ").append(parama);
    }
    parama.NZ = ByteOrder.BIG_ENDIAN;
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
    i = 2;
    int j = parama.readByte();
    if (j != -1)
    {
      parama = new IOException("Invalid marker:" + Integer.toHexString(j & 0xFF));
      AppMethodBeat.o(178731);
      throw parama;
    }
    int m = parama.readByte();
    if (DEBUG) {
      new StringBuilder("Found JPEG segment indicator: ").append(Integer.toHexString(m & 0xFF));
    }
    int k;
    if ((m != -39) && (m != -38))
    {
      j = parama.readUnsignedShort() - 2;
      k = i + 1 + 1 + 2;
      if (DEBUG) {
        new StringBuilder("JPEG segment: ").append(Integer.toHexString(m & 0xFF)).append(" (length: ").append(j + 2).append(")");
      }
      if (j < 0)
      {
        parama = new IOException("Invalid length");
        AppMethodBeat.o(178731);
        throw parama;
      }
      switch (m)
      {
      default: 
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        parama = new IOException("Invalid length");
        AppMethodBeat.o(178731);
        throw parama;
        Object localObject = new byte[j];
        parama.readFully((byte[])localObject);
        i = k + j;
        m = 0;
        if (b.c((byte[])localObject, OM))
        {
          localObject = Arrays.copyOfRange((byte[])localObject, OM.length, localObject.length);
          this.bAO = (k + paramInt1 + OM.length);
          b((byte[])localObject, paramInt2);
          f(new a((byte[])localObject));
          j = i;
          i = m;
          continue;
        }
        if (b.c((byte[])localObject, bAy))
        {
          j = bAy.length;
          localObject = Arrays.copyOfRange((byte[])localObject, bAy.length, localObject.length);
          if (aC("Xmp") == null)
          {
            this.bAE[0].put("Xmp", new c(1, localObject.length, k + j, (byte[])localObject));
            this.bAT = true;
          }
          j = i;
          i = m;
          continue;
          localObject = new byte[j];
          if (parama.read((byte[])localObject) != j)
          {
            parama = new IOException("Invalid exif");
            AppMethodBeat.o(178731);
            throw parama;
          }
          m = 0;
          i = m;
          j = k;
          if (aC("UserComment") != null) {
            continue;
          }
          this.bAE[1].put("UserComment", c.aE(new String((byte[])localObject, Oj)));
          i = m;
          j = k;
          continue;
          parama.eP(1);
          HashMap localHashMap = this.bAE[paramInt2];
          if (paramInt2 != 4)
          {
            localObject = "ImageLength";
            label795:
            localHashMap.put(localObject, c.b(parama.readUnsignedShort(), this.bAG));
            localHashMap = this.bAE[paramInt2];
            if (paramInt2 == 4) {
              break label874;
            }
          }
          label874:
          for (localObject = "ImageWidth";; localObject = "ThumbnailImageWidth")
          {
            localHashMap.put(localObject, c.b(parama.readUnsignedShort(), this.bAG));
            i = j - 5;
            j = k;
            break;
            localObject = "ThumbnailImageLength";
            break label795;
          }
        }
      }
      else
      {
        parama.eP(i);
        i += j;
        break;
        parama.NZ = this.bAG;
        AppMethodBeat.o(178731);
        return;
      }
      j = i;
      i = m;
    }
  }
  
  private static void a(a parama, b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193136);
    int j = parama.readInt();
    paramb.write(paramArrayOfByte);
    paramb.aX(j);
    int i = j;
    if (j % 2 == 1) {
      i = j + 1;
    }
    b.a(parama, paramb, i);
    AppMethodBeat.o(193136);
  }
  
  private static void a(a parama, b paramb, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(193129);
    byte[] arrayOfByte;
    do
    {
      arrayOfByte = new byte[4];
      if (parama.read(arrayOfByte) != 4)
      {
        paramb = new StringBuilder("Encountered invalid length while copying WebP chunks up tochunk type ").append(new String(paramArrayOfByte1, Oj));
        if (paramArrayOfByte2 == null) {}
        for (parama = "";; parama = " or " + new String(paramArrayOfByte2, Oj))
        {
          parama = new IOException(parama);
          AppMethodBeat.o(193129);
          throw parama;
        }
      }
      a(parama, paramb, arrayOfByte);
    } while ((!Arrays.equals(arrayOfByte, paramArrayOfByte1)) && ((paramArrayOfByte2 == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte2))));
    AppMethodBeat.o(193129);
  }
  
  private void a(a parama, HashMap paramHashMap)
  {
    AppMethodBeat.i(178741);
    c localc = (c)paramHashMap.get("JPEGInterchangeFormat");
    paramHashMap = (c)paramHashMap.get("JPEGInterchangeFormatLength");
    if ((localc != null) && (paramHashMap != null))
    {
      int j = localc.c(this.bAG);
      int k = paramHashMap.c(this.bAG);
      int i = j;
      if (this.bAC == 7) {
        i = j + this.bAP;
      }
      if ((i > 0) && (k > 0))
      {
        this.bAH = true;
        if ((this.bAz == null) && (this.bAB == null) && (this.bAA == null))
        {
          paramHashMap = new byte[k];
          parama.skip(i);
          parama.read(paramHashMap);
          this.bAM = paramHashMap;
        }
        this.bAK = i;
        this.bAL = k;
      }
      if (DEBUG) {
        new StringBuilder("Setting thumbnail attributes with offset: ").append(i).append(", length: ").append(k);
      }
    }
    AppMethodBeat.o(178741);
  }
  
  private void a(f paramf)
  {
    AppMethodBeat.i(193054);
    e(paramf);
    a(paramf, 0);
    c(paramf, 0);
    c(paramf, 5);
    c(paramf, 4);
    FS();
    if (this.bAC == 8)
    {
      paramf = (c)this.bAE[1].get("MakerNote");
      if (paramf != null)
      {
        paramf = new f(paramf.Op);
        paramf.NZ = this.bAG;
        paramf.eP(6);
        a(paramf, 9);
        paramf = (c)this.bAE[9].get("ColorSpace");
        if (paramf != null) {
          this.bAE[1].put("ColorSpace", paramf);
        }
      }
    }
    AppMethodBeat.o(193054);
  }
  
  private void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(193174);
    int i = paramInt;
    this.bAF.add(Integer.valueOf(paramf.mPosition));
    int i1 = paramf.readShort();
    if (i1 <= 0)
    {
      AppMethodBeat.o(193174);
      return;
    }
    int j = 0;
    int i3;
    int k;
    int i2;
    long l3;
    d locald;
    Object localObject;
    label118:
    int n;
    int m;
    long l1;
    if (j < i1)
    {
      i3 = paramf.readUnsignedShort();
      k = paramf.readUnsignedShort();
      i2 = paramf.readInt();
      l3 = paramf.mPosition + 4L;
      locald = (d)bAv[i].get(Integer.valueOf(i3));
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
          break label220;
        }
        paramInt = k;
        m = n;
        l1 = l2;
        if (!DEBUG) {}
      }
      for (;;)
      {
        label193:
        if (m == 0)
        {
          paramf.seek(l3);
          label204:
          j = (short)(j + 1);
          break;
          localObject = null;
          break label118;
          label220:
          if ((k <= 0) || (k >= Ol.length))
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
          else if (!locald.eR(k))
          {
            paramInt = k;
            m = n;
            l1 = l2;
            if (DEBUG)
            {
              new StringBuilder("Skip the tag entry since data format (").append(Ok[k]).append(") is unexpected for tag: ").append(locald.name);
              paramInt = k;
              m = n;
              l1 = l2;
            }
          }
          else
          {
            if (k != 7) {
              break label1150;
            }
          }
        }
      }
    }
    label444:
    label851:
    label1136:
    label1143:
    label1150:
    for (paramInt = locald.OU;; paramInt = k)
    {
      l1 = i2 * Ol[paramInt];
      if ((l1 < 0L) || (l1 > 2147483647L))
      {
        if (!DEBUG) {
          break label1143;
        }
        m = n;
        break label193;
      }
      m = 1;
      break label193;
      if (l1 > 4L)
      {
        k = paramf.readInt();
        if (this.bAC == 7)
        {
          if ("MakerNote".equals(locald.name)) {
            this.bAP = k;
          }
        }
        else {
          paramf.seek(k);
        }
      }
      else
      {
        localObject = (Integer)bAx.get(Integer.valueOf(i3));
        if (DEBUG) {
          new StringBuilder("nextIfdType: ").append(localObject).append(" byteCount: ").append(l1);
        }
        if (localObject == null) {
          break label851;
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
          if (l1 > 0L)
          {
            if (this.bAF.contains(Integer.valueOf((int)l1))) {
              break label809;
            }
            paramf.seek(l1);
            a(paramf, ((Integer)localObject).intValue());
          }
          break;
        }
      }
      for (;;)
      {
        paramf.seek(l3);
        break;
        if ((i != 6) || (!"ThumbnailImage".equals(locald.name))) {
          break label444;
        }
        this.bAQ = k;
        this.bAR = i2;
        localObject = c.a(6, this.bAG);
        c localc1 = c.b(this.bAQ, this.bAG);
        c localc2 = c.b(this.bAR, this.bAG);
        this.bAE[4].put("Compression", localObject);
        this.bAE[4].put("JPEGInterchangeFormat", localc1);
        this.bAE[4].put("JPEGInterchangeFormatLength", localc2);
        break label444;
        l1 = paramf.readUnsignedShort();
        break label569;
        l1 = paramf.readShort();
        break label569;
        l1 = paramf.FT();
        break label569;
        l1 = paramf.readInt();
        break label569;
        if (DEBUG) {
          new StringBuilder("Skip jump into the IFD since it has already been read: IfdType ").append(localObject).append(" (at ").append(l1).append(")");
        }
      }
      k = paramf.mPosition;
      m = this.bAO;
      localObject = new byte[(int)l1];
      paramf.readFully((byte[])localObject);
      localObject = new c(paramInt, i2, m + k, (byte[])localObject);
      this.bAE[i].put(locald.name, localObject);
      if ("DNGVersion".equals(locald.name)) {
        this.bAC = 3;
      }
      if (((!"Make".equals(locald.name)) && (!"Model".equals(locald.name))) || ((((c)localObject).d(this.bAG).contains("PENTAX")) || (("Compression".equals(locald.name)) && (((c)localObject).c(this.bAG) == 65535)))) {
        this.bAC = 8;
      }
      if (paramf.mPosition == l3) {
        break label204;
      }
      paramf.seek(l3);
      break label204;
      paramInt = paramf.readInt();
      if (DEBUG) {
        String.format("nextIfdOffset: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      if (paramInt > 0L)
      {
        if (!this.bAF.contains(Integer.valueOf(paramInt)))
        {
          paramf.seek(paramInt);
          if (this.bAE[4].isEmpty())
          {
            i = 4;
            break;
          }
          if (!this.bAE[5].isEmpty()) {
            break label1136;
          }
          i = 5;
          break;
        }
        if (DEBUG)
        {
          AppMethodBeat.o(193174);
          return;
        }
      }
      AppMethodBeat.o(193174);
      return;
      m = n;
      break label193;
    }
  }
  
  private static boolean a(FileDescriptor paramFileDescriptor)
  {
    AppMethodBeat.i(178722);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        b.a.a(paramFileDescriptor, 0L, OsConstants.SEEK_CUR);
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
    AppMethodBeat.i(193211);
    Object localObject = (c)paramHashMap.get("BitsPerSample");
    if (localObject != null)
    {
      localObject = (int[])((c)localObject).a(this.bAG);
      if (Arrays.equals(bzM, (int[])localObject))
      {
        AppMethodBeat.o(193211);
        return true;
      }
      if (this.bAC == 3)
      {
        paramHashMap = (c)paramHashMap.get("PhotometricInterpretation");
        if (paramHashMap != null)
        {
          int i = paramHashMap.c(this.bAG);
          if (((i == 1) && (Arrays.equals((int[])localObject, bzO))) || ((i == 6) && (Arrays.equals((int[])localObject, bzM))))
          {
            AppMethodBeat.o(193211);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(193211);
    return false;
  }
  
  private c aB(String paramString)
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
    while (i < bAt.length)
    {
      paramString = (c)this.bAE[i].get(str);
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
  
  private void aD(String paramString)
  {
    AppMethodBeat.i(178720);
    int i = 0;
    while (i < bAt.length)
    {
      this.bAE[i].remove(paramString);
      i += 1;
    }
    AppMethodBeat.o(178720);
  }
  
  private void aI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178748);
    if ((this.bAE[paramInt1].isEmpty()) || (this.bAE[paramInt2].isEmpty()))
    {
      AppMethodBeat.o(178748);
      return;
    }
    Object localObject1 = (c)this.bAE[paramInt1].get("ImageLength");
    Object localObject2 = (c)this.bAE[paramInt1].get("ImageWidth");
    c localc1 = (c)this.bAE[paramInt2].get("ImageLength");
    c localc2 = (c)this.bAE[paramInt2].get("ImageWidth");
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
      int i = ((c)localObject1).c(this.bAG);
      int j = ((c)localObject2).c(this.bAG);
      int k = localc1.c(this.bAG);
      int m = localc2.c(this.bAG);
      if ((i < k) && (j < m))
      {
        localObject1 = this.bAE[paramInt1];
        localObject2 = this.bAE;
        localObject2[paramInt1] = localObject2[paramInt2];
        this.bAE[paramInt2] = localObject1;
      }
    }
    AppMethodBeat.o(178748);
  }
  
  private static Pair<Integer, Integer> af(String paramString)
  {
    AppMethodBeat.i(178747);
    Object localObject;
    int i;
    Pair localPair;
    if (paramString.contains(","))
    {
      localObject = paramString.split(",", -1);
      paramString = af(localObject[0]);
      if (((Integer)paramString.first).intValue() == 2)
      {
        AppMethodBeat.o(178747);
        return paramString;
      }
      i = 1;
      if (i < localObject.length)
      {
        localPair = af(localObject[i]);
        if ((!((Integer)localPair.first).equals(paramString.first)) && (!((Integer)localPair.second).equals(paramString.first))) {
          break label635;
        }
      }
    }
    label635:
    for (int j = ((Integer)paramString.first).intValue();; j = -1)
    {
      if ((((Integer)paramString.second).intValue() != -1) && ((((Integer)localPair.first).equals(paramString.second)) || (((Integer)localPair.second).equals(paramString.second)))) {}
      for (int k = ((Integer)paramString.second).intValue();; k = -1)
      {
        if ((j == -1) && (k == -1))
        {
          paramString = new Pair(Integer.valueOf(2), Integer.valueOf(-1));
          AppMethodBeat.o(178747);
          return paramString;
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
            AppMethodBeat.o(178747);
            return paramString;
            if (paramString.contains("/"))
            {
              paramString = paramString.split("/", -1);
              if (paramString.length == 2) {
                try
                {
                  long l1 = Double.parseDouble(paramString[0]);
                  long l2 = Double.parseDouble(paramString[1]);
                  if ((l1 < 0L) || (l2 < 0L))
                  {
                    paramString = new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                    AppMethodBeat.o(178747);
                    return paramString;
                  }
                  if ((l1 > 2147483647L) || (l2 > 2147483647L))
                  {
                    paramString = new Pair(Integer.valueOf(5), Integer.valueOf(-1));
                    AppMethodBeat.o(178747);
                    return paramString;
                  }
                  paramString = new Pair(Integer.valueOf(10), Integer.valueOf(5));
                  AppMethodBeat.o(178747);
                  return paramString;
                }
                catch (NumberFormatException paramString) {}
              }
              paramString = new Pair(Integer.valueOf(2), Integer.valueOf(-1));
              AppMethodBeat.o(178747);
              return paramString;
            }
            try
            {
              localObject = Long.valueOf(Long.parseLong(paramString));
              if ((((Long)localObject).longValue() >= 0L) && (((Long)localObject).longValue() <= 65535L))
              {
                localObject = new Pair(Integer.valueOf(3), Integer.valueOf(4));
                AppMethodBeat.o(178747);
                return localObject;
              }
              if (((Long)localObject).longValue() < 0L)
              {
                localObject = new Pair(Integer.valueOf(9), Integer.valueOf(-1));
                AppMethodBeat.o(178747);
                return localObject;
              }
              localObject = new Pair(Integer.valueOf(4), Integer.valueOf(-1));
              AppMethodBeat.o(178747);
              return localObject;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              try
              {
                Double.parseDouble(paramString);
                paramString = new Pair(Integer.valueOf(12), Integer.valueOf(-1));
                AppMethodBeat.o(178747);
                return paramString;
              }
              catch (NumberFormatException paramString)
              {
                paramString = new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                AppMethodBeat.o(178747);
                return paramString;
              }
            }
          }
        }
      }
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193292);
    if ((!this.bAE[paramInt].isEmpty()) && (this.bAE[paramInt].get(paramString1) != null))
    {
      this.bAE[paramInt].put(paramString2, this.bAE[paramInt].get(paramString1));
      this.bAE[paramInt].remove(paramString1);
    }
    AppMethodBeat.o(193292);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(193077);
    if (DEBUG) {
      new StringBuilder("getPngAttributes starting with: ").append(parama);
    }
    parama.NZ = ByteOrder.BIG_ENDIAN;
    parama.eP(bzV.length);
    int i = bzV.length + 0;
    for (;;)
    {
      int j;
      byte[] arrayOfByte1;
      try
      {
        j = parama.readInt();
        arrayOfByte1 = new byte[4];
        if (parama.read(arrayOfByte1) != 4)
        {
          parama = new IOException("Encountered invalid length while parsing PNG chunktype");
          AppMethodBeat.o(193077);
          throw parama;
        }
      }
      catch (EOFException parama)
      {
        parama = new IOException("Encountered corrupt PNG file.");
        AppMethodBeat.o(193077);
        throw parama;
      }
      i = i + 4 + 4;
      if ((i == 16) && (!Arrays.equals(arrayOfByte1, bzX)))
      {
        parama = new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
        AppMethodBeat.o(193077);
        throw parama;
      }
      if (Arrays.equals(arrayOfByte1, bzY)) {
        break;
      }
      if (Arrays.equals(arrayOfByte1, bzW))
      {
        byte[] arrayOfByte2 = new byte[j];
        if (parama.read(arrayOfByte2) != j)
        {
          parama = new IOException("Failed to read given length for given PNG chunk type: " + b.byteArrayToHexString(arrayOfByte1));
          AppMethodBeat.o(193077);
          throw parama;
        }
        j = parama.readInt();
        parama = new CRC32();
        parama.update(arrayOfByte1);
        parama.update(arrayOfByte2);
        if ((int)parama.getValue() != j)
        {
          parama = new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + j + ", calculated CRC value: " + parama.getValue());
          AppMethodBeat.o(193077);
          throw parama;
        }
        this.bAO = i;
        b(arrayOfByte2, 0);
        FS();
        f(new a(arrayOfByte2));
        AppMethodBeat.o(193077);
        return;
      }
      parama.eP(j + 4);
      i += j + 4;
    }
    AppMethodBeat.o(193077);
  }
  
  private void b(a parama, HashMap paramHashMap)
  {
    AppMethodBeat.i(178742);
    Object localObject1 = (c)paramHashMap.get("StripOffsets");
    Object localObject2 = (c)paramHashMap.get("StripByteCounts");
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramHashMap = b.aF(((c)localObject1).a(this.bAG));
      localObject1 = b.aF(((c)localObject2).a(this.bAG));
      if ((paramHashMap == null) || (paramHashMap.length == 0))
      {
        AppMethodBeat.o(178742);
        return;
      }
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        AppMethodBeat.o(178742);
        return;
      }
      if (paramHashMap.length != localObject1.length)
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
      int k = 0;
      j = 0;
      this.bAJ = true;
      this.bAI = true;
      this.bAH = true;
      i = 0;
      while (i < paramHashMap.length)
      {
        int n = (int)paramHashMap[i];
        int m = (int)localObject1[i];
        if ((i < paramHashMap.length - 1) && (n + m != paramHashMap[(i + 1)])) {
          this.bAJ = false;
        }
        n -= k;
        if (n < 0)
        {
          AppMethodBeat.o(178742);
          return;
        }
        if (parama.skip(n) != n)
        {
          new StringBuilder("Failed to skip ").append(n).append(" bytes.");
          AppMethodBeat.o(178742);
          return;
        }
        byte[] arrayOfByte = new byte[m];
        if (parama.read(arrayOfByte) != m)
        {
          new StringBuilder("Failed to read ").append(m).append(" bytes.");
          AppMethodBeat.o(178742);
          return;
        }
        k = k + n + m;
        System.arraycopy(arrayOfByte, 0, localObject2, j, arrayOfByte.length);
        j += arrayOfByte.length;
        i += 1;
      }
      this.bAM = ((byte[])localObject2);
      if (this.bAJ)
      {
        this.bAK = ((int)paramHashMap[0]);
        this.bAL = localObject2.length;
      }
    }
    AppMethodBeat.o(178742);
  }
  
  private void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(193179);
    Object localObject = (c)this.bAE[paramInt].get("ImageLength");
    c localc = (c)this.bAE[paramInt].get("ImageWidth");
    if ((localObject == null) || (localc == null))
    {
      localObject = (c)this.bAE[paramInt].get("JPEGInterchangeFormat");
      localc = (c)this.bAE[paramInt].get("JPEGInterchangeFormatLength");
      if ((localObject != null) && (localc != null))
      {
        int i = ((c)localObject).c(this.bAG);
        int j = ((c)localObject).c(this.bAG);
        paramf.seek(i);
        localObject = new byte[j];
        paramf.read((byte[])localObject);
        a(new a((byte[])localObject), i, paramInt);
      }
    }
    AppMethodBeat.o(193179);
  }
  
  private void b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(178734);
    if (DEBUG) {
      new StringBuilder("saveJpegAttributes starting with (inputStream: ").append(paramInputStream).append(", outputStream: ").append(paramOutputStream).append(")");
    }
    a locala = new a(paramInputStream);
    b localb = new b(paramOutputStream, ByteOrder.BIG_ENDIAN);
    if (locala.readByte() != -1)
    {
      paramInputStream = new IOException("Invalid marker");
      AppMethodBeat.o(178734);
      throw paramInputStream;
    }
    localb.eQ(-1);
    if (locala.readByte() != -40)
    {
      paramInputStream = new IOException("Invalid marker");
      AppMethodBeat.o(178734);
      throw paramInputStream;
    }
    localb.eQ(-40);
    paramOutputStream = null;
    paramInputStream = paramOutputStream;
    if (aC("Xmp") != null)
    {
      paramInputStream = paramOutputStream;
      if (this.bAT) {
        paramInputStream = (c)this.bAE[0].remove("Xmp");
      }
    }
    localb.eQ(-1);
    localb.eQ(-31);
    a(localb);
    if (paramInputStream != null) {
      this.bAE[0].put("Xmp", paramInputStream);
    }
    paramInputStream = new byte[4096];
    label596:
    for (;;)
    {
      if (locala.readByte() != -1)
      {
        paramInputStream = new IOException("Invalid marker");
        AppMethodBeat.o(178734);
        throw paramInputStream;
      }
      int i = locala.readByte();
      int j;
      switch (i)
      {
      default: 
        localb.eQ(-1);
        localb.eQ(i);
        i = locala.readUnsignedShort();
        localb.b((short)i);
        j = i - 2;
        i = j;
        if (j < 0)
        {
          paramInputStream = new IOException("Invalid length");
          AppMethodBeat.o(178734);
          throw paramInputStream;
        }
      case -31: 
        j = locala.readUnsignedShort() - 2;
        if (j < 0)
        {
          paramInputStream = new IOException("Invalid length");
          AppMethodBeat.o(178734);
          throw paramInputStream;
        }
        paramOutputStream = new byte[6];
        if (j >= 6)
        {
          if (locala.read(paramOutputStream) != 6)
          {
            paramInputStream = new IOException("Invalid exif");
            AppMethodBeat.o(178734);
            throw paramInputStream;
          }
          if (Arrays.equals(paramOutputStream, OM))
          {
            locala.eP(j - 6);
            continue;
          }
        }
        localb.eQ(-1);
        localb.eQ(i);
        localb.b((short)(j + 2));
        i = j;
        if (j >= 6)
        {
          i = j - 6;
          localb.write(paramOutputStream);
        }
        while (i > 0)
        {
          j = locala.read(paramInputStream, 0, Math.min(i, 4096));
          if (j < 0) {
            break;
          }
          localb.write(paramInputStream, 0, j);
          i -= j;
        }
      case -39: 
      case -38: 
        localb.eQ(-1);
        localb.eQ(i);
        b.copy(locala, localb);
        AppMethodBeat.o(178734);
        return;
        for (;;)
        {
          if (i <= 0) {
            break label596;
          }
          j = locala.read(paramInputStream, 0, Math.min(i, 4096));
          if (j < 0) {
            break;
          }
          localb.write(paramInputStream, 0, j);
          i -= j;
        }
      }
    }
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(178735);
    paramArrayOfByte = new f(paramArrayOfByte);
    e(paramArrayOfByte);
    a(paramArrayOfByte, paramInt);
    AppMethodBeat.o(178735);
  }
  
  private boolean b(HashMap paramHashMap)
  {
    AppMethodBeat.i(178743);
    c localc = (c)paramHashMap.get("ImageLength");
    paramHashMap = (c)paramHashMap.get("ImageWidth");
    if ((localc != null) && (paramHashMap != null))
    {
      int i = localc.c(this.bAG);
      int j = paramHashMap.c(this.bAG);
      if ((i <= 512) && (j <= 512))
      {
        AppMethodBeat.o(178743);
        return true;
      }
    }
    AppMethodBeat.o(178743);
    return false;
  }
  
  private void c(a parama)
  {
    AppMethodBeat.i(193088);
    if (DEBUG) {
      new StringBuilder("getWebpAttributes starting with: ").append(parama);
    }
    parama.NZ = ByteOrder.LITTLE_ENDIAN;
    parama.eP(bzZ.length);
    int k = parama.readInt() + 8;
    parama.eP(bAa.length);
    int i = bAa.length + 8;
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte1 = new byte[4];
      if (parama.read(arrayOfByte1) != 4)
      {
        parama = new IOException("Encountered invalid length while parsing WebP chunktype");
        AppMethodBeat.o(193088);
        throw parama;
      }
    }
    catch (EOFException parama)
    {
      parama = new IOException("Encountered corrupt WebP file.");
      AppMethodBeat.o(193088);
      throw parama;
    }
    int j = parama.readInt();
    int m = i + 4 + 4;
    if (Arrays.equals(bAb, arrayOfByte1))
    {
      byte[] arrayOfByte2 = new byte[j];
      if (parama.read(arrayOfByte2) != j)
      {
        parama = new IOException("Failed to read given length for given PNG chunk type: " + b.byteArrayToHexString(arrayOfByte1));
        AppMethodBeat.o(193088);
        throw parama;
      }
      this.bAO = m;
      b(arrayOfByte2, 0);
      f(new a(arrayOfByte2));
      AppMethodBeat.o(193088);
      return;
    }
    for (;;)
    {
      if (m + i != k)
      {
        if (m + i > k)
        {
          parama = new IOException("Encountered WebP file with invalid chunk size");
          AppMethodBeat.o(193088);
          throw parama;
        }
        parama.eP(i);
        i += m;
        break;
      }
      AppMethodBeat.o(193088);
      return;
      i = j;
      if (j % 2 == 1) {
        i = j + 1;
      }
    }
  }
  
  private void c(f paramf, int paramInt)
  {
    AppMethodBeat.i(193241);
    c localc1 = (c)this.bAE[paramInt].get("DefaultCropSize");
    c localc2 = (c)this.bAE[paramInt].get("SensorTopBorder");
    c localc3 = (c)this.bAE[paramInt].get("SensorLeftBorder");
    c localc4 = (c)this.bAE[paramInt].get("SensorBottomBorder");
    c localc5 = (c)this.bAE[paramInt].get("SensorRightBorder");
    if (localc1 != null)
    {
      if (localc1.format == 5)
      {
        paramf = (e[])localc1.a(this.bAG);
        if ((paramf == null) || (paramf.length != 2))
        {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(paramf));
          AppMethodBeat.o(193241);
          return;
        }
        localc1 = c.a(paramf[0], this.bAG);
      }
      for (paramf = c.a(paramf[1], this.bAG);; paramf = c.a(paramf[1], this.bAG))
      {
        this.bAE[paramInt].put("ImageWidth", localc1);
        this.bAE[paramInt].put("ImageLength", paramf);
        AppMethodBeat.o(193241);
        return;
        paramf = (int[])localc1.a(this.bAG);
        if ((paramf == null) || (paramf.length != 2))
        {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(paramf));
          AppMethodBeat.o(193241);
          return;
        }
        localc1 = c.a(paramf[0], this.bAG);
      }
    }
    if ((localc2 != null) && (localc3 != null) && (localc4 != null) && (localc5 != null))
    {
      int i = localc2.c(this.bAG);
      int j = localc4.c(this.bAG);
      int k = localc5.c(this.bAG);
      int m = localc3.c(this.bAG);
      if ((j > i) && (k > m))
      {
        paramf = c.a(j - i, this.bAG);
        localc1 = c.a(k - m, this.bAG);
        this.bAE[paramInt].put("ImageLength", paramf);
        this.bAE[paramInt].put("ImageWidth", localc1);
      }
      AppMethodBeat.o(193241);
      return;
    }
    b(paramf, paramInt);
    AppMethodBeat.o(193241);
  }
  
  /* Error */
  private void c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: ldc_w 1642
    //   3: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   9: ifeq +34 -> 43
    //   12: new 1051	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1644
    //   19: invokespecial 1054	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 1266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: ldc_w 1589
    //   29: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 1266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   36: ldc_w 1326
    //   39: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 8	androidx/f/a/a$a
    //   46: dup
    //   47: aload_1
    //   48: getstatic 1619	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   51: invokespecial 1647	androidx/f/a/a$a:<init>	(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V
    //   54: astore 11
    //   56: new 11	androidx/f/a/a$b
    //   59: dup
    //   60: aload_2
    //   61: getstatic 1619	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   64: invokespecial 1594	androidx/f/a/a$b:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   67: astore 12
    //   69: aload 11
    //   71: aload 12
    //   73: getstatic 703	androidx/f/a/a:bzZ	[B
    //   76: arraylength
    //   77: invokestatic 1358	androidx/f/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   80: aload 11
    //   82: getstatic 707	androidx/f/a/a:bAa	[B
    //   85: arraylength
    //   86: iconst_4
    //   87: iadd
    //   88: invokevirtual 1269	androidx/f/a/a$a:eP	(I)V
    //   91: new 1649	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 1650	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 10
    //   100: aload 10
    //   102: astore_2
    //   103: new 11	androidx/f/a/a$b
    //   106: dup
    //   107: aload 10
    //   109: getstatic 1619	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   112: invokespecial 1594	androidx/f/a/a$b:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   115: astore 13
    //   117: aload 10
    //   119: astore_2
    //   120: aload_0
    //   121: getfield 1157	androidx/f/a/a:bAO	I
    //   124: ifeq +139 -> 263
    //   127: aload 10
    //   129: astore_2
    //   130: getstatic 703	androidx/f/a/a:bzZ	[B
    //   133: arraylength
    //   134: istore_3
    //   135: aload 10
    //   137: astore_2
    //   138: getstatic 707	androidx/f/a/a:bAa	[B
    //   141: arraylength
    //   142: istore 4
    //   144: aload 10
    //   146: astore_2
    //   147: aload 11
    //   149: aload 13
    //   151: aload_0
    //   152: getfield 1157	androidx/f/a/a:bAO	I
    //   155: iload_3
    //   156: iconst_4
    //   157: iadd
    //   158: iload 4
    //   160: iadd
    //   161: isub
    //   162: iconst_4
    //   163: isub
    //   164: iconst_4
    //   165: isub
    //   166: invokestatic 1358	androidx/f/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   169: aload 10
    //   171: astore_2
    //   172: aload 11
    //   174: iconst_4
    //   175: invokevirtual 1269	androidx/f/a/a$a:eP	(I)V
    //   178: aload 10
    //   180: astore_2
    //   181: aload 11
    //   183: aload 11
    //   185: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   188: invokevirtual 1269	androidx/f/a/a$a:eP	(I)V
    //   191: aload 10
    //   193: astore_2
    //   194: aload_0
    //   195: aload 13
    //   197: invokespecial 1598	androidx/f/a/a:a	(Landroidx/f/a/a$b;)I
    //   200: pop
    //   201: aload 10
    //   203: astore_2
    //   204: aload 11
    //   206: aload 13
    //   208: invokestatic 1611	androidx/f/a/b:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   211: pop
    //   212: aload 10
    //   214: astore_2
    //   215: aload 12
    //   217: aload 10
    //   219: invokevirtual 1651	java/io/ByteArrayOutputStream:size	()I
    //   222: getstatic 707	androidx/f/a/a:bAa	[B
    //   225: arraylength
    //   226: iadd
    //   227: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   230: aload 10
    //   232: astore_2
    //   233: aload 12
    //   235: getstatic 707	androidx/f/a/a:bAa	[B
    //   238: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   241: aload 10
    //   243: astore_2
    //   244: aload 10
    //   246: aload 12
    //   248: invokevirtual 1655	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   251: aload 10
    //   253: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   256: ldc_w 1642
    //   259: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: return
    //   263: aload 10
    //   265: astore_2
    //   266: iconst_4
    //   267: newarray byte
    //   269: astore 14
    //   271: aload 10
    //   273: astore_2
    //   274: aload 11
    //   276: aload 14
    //   278: invokevirtual 1270	androidx/f/a/a$a:read	([B)I
    //   281: iconst_4
    //   282: if_icmpeq +80 -> 362
    //   285: aload 10
    //   287: astore_2
    //   288: new 1163	java/io/IOException
    //   291: dup
    //   292: ldc_w 1657
    //   295: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   298: astore_1
    //   299: aload 10
    //   301: astore_2
    //   302: ldc_w 1642
    //   305: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 10
    //   310: astore_2
    //   311: aload_1
    //   312: athrow
    //   313: astore_2
    //   314: aload 10
    //   316: astore_1
    //   317: aload_2
    //   318: astore 10
    //   320: aload_1
    //   321: astore_2
    //   322: new 1163	java/io/IOException
    //   325: dup
    //   326: ldc_w 1659
    //   329: aload 10
    //   331: invokespecial 1662	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   334: astore 10
    //   336: aload_1
    //   337: astore_2
    //   338: ldc_w 1642
    //   341: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_1
    //   345: astore_2
    //   346: aload 10
    //   348: athrow
    //   349: astore_1
    //   350: aload_2
    //   351: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   354: ldc_w 1642
    //   357: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: aload_1
    //   361: athrow
    //   362: aload 10
    //   364: astore_2
    //   365: aload 14
    //   367: getstatic 730	androidx/f/a/a:bAd	[B
    //   370: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   373: ifeq +209 -> 582
    //   376: aload 10
    //   378: astore_2
    //   379: aload 11
    //   381: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   384: istore 4
    //   386: iload 4
    //   388: iconst_2
    //   389: irem
    //   390: iconst_1
    //   391: if_icmpne +767 -> 1158
    //   394: iload 4
    //   396: iconst_1
    //   397: iadd
    //   398: istore_3
    //   399: aload 10
    //   401: astore_2
    //   402: iload_3
    //   403: newarray byte
    //   405: astore 14
    //   407: aload 10
    //   409: astore_2
    //   410: aload 11
    //   412: aload 14
    //   414: invokevirtual 1270	androidx/f/a/a$a:read	([B)I
    //   417: pop
    //   418: aload 14
    //   420: iconst_0
    //   421: aload 14
    //   423: iconst_0
    //   424: baload
    //   425: bipush 8
    //   427: ior
    //   428: i2b
    //   429: bastore
    //   430: aload 14
    //   432: iconst_0
    //   433: baload
    //   434: iconst_1
    //   435: ishr
    //   436: iconst_1
    //   437: iand
    //   438: iconst_1
    //   439: if_icmpne +725 -> 1164
    //   442: iconst_1
    //   443: istore_3
    //   444: aload 10
    //   446: astore_2
    //   447: aload 13
    //   449: getstatic 730	androidx/f/a/a:bAd	[B
    //   452: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   455: aload 10
    //   457: astore_2
    //   458: aload 13
    //   460: iload 4
    //   462: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   465: aload 10
    //   467: astore_2
    //   468: aload 13
    //   470: aload 14
    //   472: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   475: iload_3
    //   476: ifeq +77 -> 553
    //   479: aload 10
    //   481: astore_2
    //   482: aload 11
    //   484: aload 13
    //   486: getstatic 742	androidx/f/a/a:bAg	[B
    //   489: aconst_null
    //   490: invokestatic 1664	androidx/f/a/a:a	(Landroidx/f/a/a$a;Landroidx/f/a/a$b;[B[B)V
    //   493: aload 10
    //   495: astore_2
    //   496: iconst_4
    //   497: newarray byte
    //   499: astore 14
    //   501: aload 10
    //   503: astore_2
    //   504: aload_1
    //   505: aload 14
    //   507: invokevirtual 1172	java/io/InputStream:read	([B)I
    //   510: pop
    //   511: aload 10
    //   513: astore_2
    //   514: aload 14
    //   516: getstatic 746	androidx/f/a/a:bAh	[B
    //   519: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   522: ifne +16 -> 538
    //   525: aload 10
    //   527: astore_2
    //   528: aload_0
    //   529: aload 13
    //   531: invokespecial 1598	androidx/f/a/a:a	(Landroidx/f/a/a$b;)I
    //   534: pop
    //   535: goto -334 -> 201
    //   538: aload 10
    //   540: astore_2
    //   541: aload 11
    //   543: aload 13
    //   545: aload 14
    //   547: invokestatic 1366	androidx/f/a/a:a	(Landroidx/f/a/a$a;Landroidx/f/a/a$b;[B)V
    //   550: goto -57 -> 493
    //   553: aload 10
    //   555: astore_2
    //   556: aload 11
    //   558: aload 13
    //   560: getstatic 738	androidx/f/a/a:bAf	[B
    //   563: getstatic 734	androidx/f/a/a:bAe	[B
    //   566: invokestatic 1664	androidx/f/a/a:a	(Landroidx/f/a/a$a;Landroidx/f/a/a$b;[B[B)V
    //   569: aload 10
    //   571: astore_2
    //   572: aload_0
    //   573: aload 13
    //   575: invokespecial 1598	androidx/f/a/a:a	(Landroidx/f/a/a$b;)I
    //   578: pop
    //   579: goto -378 -> 201
    //   582: aload 10
    //   584: astore_2
    //   585: aload 14
    //   587: getstatic 738	androidx/f/a/a:bAf	[B
    //   590: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   593: ifne +17 -> 610
    //   596: aload 10
    //   598: astore_2
    //   599: aload 14
    //   601: getstatic 734	androidx/f/a/a:bAe	[B
    //   604: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   607: ifeq -406 -> 201
    //   610: aload 10
    //   612: astore_2
    //   613: aload 11
    //   615: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   618: istore 9
    //   620: iload 9
    //   622: iconst_2
    //   623: irem
    //   624: iconst_1
    //   625: if_icmpne +527 -> 1152
    //   628: iload 9
    //   630: iconst_1
    //   631: iadd
    //   632: istore_3
    //   633: iconst_0
    //   634: istore 4
    //   636: iconst_0
    //   637: istore 6
    //   639: iconst_0
    //   640: istore 7
    //   642: iconst_0
    //   643: istore 8
    //   645: aload 10
    //   647: astore_2
    //   648: iconst_3
    //   649: newarray byte
    //   651: astore_1
    //   652: aload 10
    //   654: astore_2
    //   655: aload 14
    //   657: getstatic 738	androidx/f/a/a:bAf	[B
    //   660: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   663: ifeq +333 -> 996
    //   666: aload 10
    //   668: astore_2
    //   669: aload 11
    //   671: aload_1
    //   672: invokevirtual 1270	androidx/f/a/a$a:read	([B)I
    //   675: pop
    //   676: aload 10
    //   678: astore_2
    //   679: iconst_3
    //   680: newarray byte
    //   682: astore 15
    //   684: aload 10
    //   686: astore_2
    //   687: aload 11
    //   689: aload 15
    //   691: invokevirtual 1270	androidx/f/a/a$a:read	([B)I
    //   694: iconst_3
    //   695: if_icmpne +17 -> 712
    //   698: aload 10
    //   700: astore_2
    //   701: getstatic 714	androidx/f/a/a:bAc	[B
    //   704: aload 15
    //   706: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   709: ifne +31 -> 740
    //   712: aload 10
    //   714: astore_2
    //   715: new 1163	java/io/IOException
    //   718: dup
    //   719: ldc_w 1666
    //   722: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   725: astore_1
    //   726: aload 10
    //   728: astore_2
    //   729: ldc_w 1642
    //   732: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   735: aload 10
    //   737: astore_2
    //   738: aload_1
    //   739: athrow
    //   740: aload 10
    //   742: astore_2
    //   743: aload 11
    //   745: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   748: istore 4
    //   750: iload 4
    //   752: bipush 18
    //   754: ishl
    //   755: bipush 18
    //   757: ishr
    //   758: istore 6
    //   760: iload 4
    //   762: iconst_2
    //   763: ishl
    //   764: bipush 18
    //   766: ishr
    //   767: istore 7
    //   769: iload_3
    //   770: bipush 10
    //   772: isub
    //   773: istore 5
    //   775: aload 10
    //   777: astore_2
    //   778: aload 13
    //   780: getstatic 730	androidx/f/a/a:bAd	[B
    //   783: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   786: aload 10
    //   788: astore_2
    //   789: aload 13
    //   791: bipush 10
    //   793: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   796: aload 10
    //   798: astore_2
    //   799: bipush 10
    //   801: newarray byte
    //   803: astore 15
    //   805: aload 15
    //   807: iconst_0
    //   808: aload 15
    //   810: iconst_0
    //   811: baload
    //   812: bipush 8
    //   814: ior
    //   815: i2b
    //   816: bastore
    //   817: aload 15
    //   819: iconst_0
    //   820: iload 8
    //   822: iconst_4
    //   823: ishl
    //   824: aload 15
    //   826: iconst_0
    //   827: baload
    //   828: ior
    //   829: i2b
    //   830: bastore
    //   831: iload 6
    //   833: iconst_1
    //   834: isub
    //   835: istore_3
    //   836: iload 7
    //   838: iconst_1
    //   839: isub
    //   840: istore 6
    //   842: aload 15
    //   844: iconst_4
    //   845: iload_3
    //   846: i2b
    //   847: bastore
    //   848: aload 15
    //   850: iconst_5
    //   851: iload_3
    //   852: bipush 8
    //   854: ishr
    //   855: i2b
    //   856: bastore
    //   857: aload 15
    //   859: bipush 6
    //   861: iload_3
    //   862: bipush 16
    //   864: ishr
    //   865: i2b
    //   866: bastore
    //   867: aload 15
    //   869: bipush 7
    //   871: iload 6
    //   873: i2b
    //   874: bastore
    //   875: aload 15
    //   877: bipush 8
    //   879: iload 6
    //   881: bipush 8
    //   883: ishr
    //   884: i2b
    //   885: bastore
    //   886: aload 15
    //   888: bipush 9
    //   890: iload 6
    //   892: bipush 16
    //   894: ishr
    //   895: i2b
    //   896: bastore
    //   897: aload 10
    //   899: astore_2
    //   900: aload 13
    //   902: aload 15
    //   904: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   907: aload 10
    //   909: astore_2
    //   910: aload 13
    //   912: aload 14
    //   914: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   917: aload 10
    //   919: astore_2
    //   920: aload 13
    //   922: iload 9
    //   924: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   927: aload 10
    //   929: astore_2
    //   930: aload 14
    //   932: getstatic 738	androidx/f/a/a:bAf	[B
    //   935: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   938: ifeq +164 -> 1102
    //   941: aload 10
    //   943: astore_2
    //   944: aload 13
    //   946: aload_1
    //   947: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   950: aload 10
    //   952: astore_2
    //   953: aload 13
    //   955: getstatic 714	androidx/f/a/a:bAc	[B
    //   958: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   961: aload 10
    //   963: astore_2
    //   964: aload 13
    //   966: iload 4
    //   968: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   971: aload 10
    //   973: astore_2
    //   974: aload 11
    //   976: aload 13
    //   978: iload 5
    //   980: invokestatic 1358	androidx/f/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   983: aload 10
    //   985: astore_2
    //   986: aload_0
    //   987: aload 13
    //   989: invokespecial 1598	androidx/f/a/a:a	(Landroidx/f/a/a$b;)I
    //   992: pop
    //   993: goto -792 -> 201
    //   996: aload 10
    //   998: astore_2
    //   999: iload_3
    //   1000: istore 5
    //   1002: aload 14
    //   1004: getstatic 734	androidx/f/a/a:bAe	[B
    //   1007: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   1010: ifeq -235 -> 775
    //   1013: aload 10
    //   1015: astore_2
    //   1016: aload 11
    //   1018: invokevirtual 1309	androidx/f/a/a$a:readByte	()B
    //   1021: bipush 47
    //   1023: if_icmpeq +31 -> 1054
    //   1026: aload 10
    //   1028: astore_2
    //   1029: new 1163	java/io/IOException
    //   1032: dup
    //   1033: ldc_w 1668
    //   1036: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1039: astore_1
    //   1040: aload 10
    //   1042: astore_2
    //   1043: ldc_w 1642
    //   1046: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1049: aload 10
    //   1051: astore_2
    //   1052: aload_1
    //   1053: athrow
    //   1054: aload 10
    //   1056: astore_2
    //   1057: aload 11
    //   1059: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   1062: istore 4
    //   1064: iload 4
    //   1066: bipush 18
    //   1068: ishl
    //   1069: bipush 18
    //   1071: ishr
    //   1072: iconst_1
    //   1073: iadd
    //   1074: istore 6
    //   1076: iload 4
    //   1078: iconst_4
    //   1079: ishl
    //   1080: bipush 18
    //   1082: ishr
    //   1083: iconst_1
    //   1084: iadd
    //   1085: istore 7
    //   1087: iload 4
    //   1089: bipush 8
    //   1091: iand
    //   1092: istore 8
    //   1094: iload_3
    //   1095: iconst_5
    //   1096: isub
    //   1097: istore 5
    //   1099: goto -324 -> 775
    //   1102: aload 10
    //   1104: astore_2
    //   1105: aload 14
    //   1107: getstatic 734	androidx/f/a/a:bAe	[B
    //   1110: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   1113: ifeq -142 -> 971
    //   1116: aload 10
    //   1118: astore_2
    //   1119: aload 13
    //   1121: bipush 47
    //   1123: invokevirtual 1670	androidx/f/a/a$b:write	(I)V
    //   1126: aload 10
    //   1128: astore_2
    //   1129: aload 13
    //   1131: iload 4
    //   1133: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   1136: goto -165 -> 971
    //   1139: astore_1
    //   1140: aconst_null
    //   1141: astore_2
    //   1142: goto -792 -> 350
    //   1145: astore 10
    //   1147: aconst_null
    //   1148: astore_1
    //   1149: goto -829 -> 320
    //   1152: iload 9
    //   1154: istore_3
    //   1155: goto -522 -> 633
    //   1158: iload 4
    //   1160: istore_3
    //   1161: goto -762 -> 399
    //   1164: iconst_0
    //   1165: istore_3
    //   1166: goto -722 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	this	a
    //   0	1169	1	paramInputStream	InputStream
    //   0	1169	2	paramOutputStream	OutputStream
    //   134	1032	3	i	int
    //   142	1017	4	j	int
    //   773	325	5	k	int
    //   637	438	6	m	int
    //   640	446	7	n	int
    //   643	450	8	i1	int
    //   618	535	9	i2	int
    //   98	1029	10	localObject	Object
    //   1145	1	10	localException	Exception
    //   54	1004	11	locala	a
    //   67	180	12	localb1	b
    //   115	1015	13	localb2	b
    //   269	837	14	arrayOfByte1	byte[]
    //   682	221	15	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   103	117	313	java/lang/Exception
    //   120	127	313	java/lang/Exception
    //   130	135	313	java/lang/Exception
    //   138	144	313	java/lang/Exception
    //   147	169	313	java/lang/Exception
    //   172	178	313	java/lang/Exception
    //   181	191	313	java/lang/Exception
    //   194	201	313	java/lang/Exception
    //   204	212	313	java/lang/Exception
    //   215	230	313	java/lang/Exception
    //   233	241	313	java/lang/Exception
    //   244	251	313	java/lang/Exception
    //   266	271	313	java/lang/Exception
    //   274	285	313	java/lang/Exception
    //   288	299	313	java/lang/Exception
    //   302	308	313	java/lang/Exception
    //   311	313	313	java/lang/Exception
    //   365	376	313	java/lang/Exception
    //   379	386	313	java/lang/Exception
    //   402	407	313	java/lang/Exception
    //   410	418	313	java/lang/Exception
    //   447	455	313	java/lang/Exception
    //   458	465	313	java/lang/Exception
    //   468	475	313	java/lang/Exception
    //   482	493	313	java/lang/Exception
    //   496	501	313	java/lang/Exception
    //   504	511	313	java/lang/Exception
    //   514	525	313	java/lang/Exception
    //   528	535	313	java/lang/Exception
    //   541	550	313	java/lang/Exception
    //   556	569	313	java/lang/Exception
    //   572	579	313	java/lang/Exception
    //   585	596	313	java/lang/Exception
    //   599	610	313	java/lang/Exception
    //   613	620	313	java/lang/Exception
    //   648	652	313	java/lang/Exception
    //   655	666	313	java/lang/Exception
    //   669	676	313	java/lang/Exception
    //   679	684	313	java/lang/Exception
    //   687	698	313	java/lang/Exception
    //   701	712	313	java/lang/Exception
    //   715	726	313	java/lang/Exception
    //   729	735	313	java/lang/Exception
    //   738	740	313	java/lang/Exception
    //   743	750	313	java/lang/Exception
    //   778	786	313	java/lang/Exception
    //   789	796	313	java/lang/Exception
    //   799	805	313	java/lang/Exception
    //   900	907	313	java/lang/Exception
    //   910	917	313	java/lang/Exception
    //   920	927	313	java/lang/Exception
    //   930	941	313	java/lang/Exception
    //   944	950	313	java/lang/Exception
    //   953	961	313	java/lang/Exception
    //   964	971	313	java/lang/Exception
    //   974	983	313	java/lang/Exception
    //   986	993	313	java/lang/Exception
    //   1002	1013	313	java/lang/Exception
    //   1016	1026	313	java/lang/Exception
    //   1029	1040	313	java/lang/Exception
    //   1043	1049	313	java/lang/Exception
    //   1052	1054	313	java/lang/Exception
    //   1057	1064	313	java/lang/Exception
    //   1105	1116	313	java/lang/Exception
    //   1119	1126	313	java/lang/Exception
    //   1129	1136	313	java/lang/Exception
    //   103	117	349	finally
    //   120	127	349	finally
    //   130	135	349	finally
    //   138	144	349	finally
    //   147	169	349	finally
    //   172	178	349	finally
    //   181	191	349	finally
    //   194	201	349	finally
    //   204	212	349	finally
    //   215	230	349	finally
    //   233	241	349	finally
    //   244	251	349	finally
    //   266	271	349	finally
    //   274	285	349	finally
    //   288	299	349	finally
    //   302	308	349	finally
    //   311	313	349	finally
    //   322	336	349	finally
    //   338	344	349	finally
    //   346	349	349	finally
    //   365	376	349	finally
    //   379	386	349	finally
    //   402	407	349	finally
    //   410	418	349	finally
    //   447	455	349	finally
    //   458	465	349	finally
    //   468	475	349	finally
    //   482	493	349	finally
    //   496	501	349	finally
    //   504	511	349	finally
    //   514	525	349	finally
    //   528	535	349	finally
    //   541	550	349	finally
    //   556	569	349	finally
    //   572	579	349	finally
    //   585	596	349	finally
    //   599	610	349	finally
    //   613	620	349	finally
    //   648	652	349	finally
    //   655	666	349	finally
    //   669	676	349	finally
    //   679	684	349	finally
    //   687	698	349	finally
    //   701	712	349	finally
    //   715	726	349	finally
    //   729	735	349	finally
    //   738	740	349	finally
    //   743	750	349	finally
    //   778	786	349	finally
    //   789	796	349	finally
    //   799	805	349	finally
    //   900	907	349	finally
    //   910	917	349	finally
    //   920	927	349	finally
    //   930	941	349	finally
    //   944	950	349	finally
    //   953	961	349	finally
    //   964	971	349	finally
    //   974	983	349	finally
    //   986	993	349	finally
    //   1002	1013	349	finally
    //   1016	1026	349	finally
    //   1029	1040	349	finally
    //   1043	1049	349	finally
    //   1052	1054	349	finally
    //   1057	1064	349	finally
    //   1105	1116	349	finally
    //   1119	1126	349	finally
    //   1129	1136	349	finally
    //   91	100	1139	finally
    //   91	100	1145	java/lang/Exception
  }
  
  private static ByteOrder d(a parama)
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
  
  private void e(a parama)
  {
    AppMethodBeat.i(193156);
    this.bAG = d(parama);
    parama.NZ = this.bAG;
    int i = parama.readUnsignedShort();
    if ((this.bAC != 7) && (this.bAC != 10) && (i != 42))
    {
      parama = new IOException("Invalid start code: " + Integer.toHexString(i));
      AppMethodBeat.o(193156);
      throw parama;
    }
    i = parama.readInt();
    if (i < 8)
    {
      parama = new IOException("Invalid first Ifd offset: ".concat(String.valueOf(i)));
      AppMethodBeat.o(193156);
      throw parama;
    }
    i -= 8;
    if (i > 0) {
      parama.eP(i);
    }
    AppMethodBeat.o(193156);
  }
  
  private void f(a parama)
  {
    AppMethodBeat.i(193188);
    HashMap localHashMap = this.bAE[4];
    c localc = (c)localHashMap.get("Compression");
    if (localc != null)
    {
      this.bAN = localc.c(this.bAG);
      switch (this.bAN)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(193188);
        return;
        a(parama, localHashMap);
        AppMethodBeat.o(193188);
        return;
        if (a(localHashMap)) {
          b(parama, localHashMap);
        }
      }
    }
    this.bAN = 6;
    a(parama, localHashMap);
    AppMethodBeat.o(193188);
  }
  
  private static boolean h(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < bzP.length)
    {
      if (paramArrayOfByte[i] != bzP[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  /* Error */
  private void i(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc_w 1702
    //   3: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +22 -> 29
    //   10: new 1013	java/lang/NullPointerException
    //   13: dup
    //   14: ldc_w 1704
    //   17: invokespecial 1018	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: ldc_w 1702
    //   24: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: iconst_0
    //   30: istore_2
    //   31: iload_2
    //   32: getstatic 889	androidx/f/a/a:bAt	[[Landroidx/f/a/a$d;
    //   35: arraylength
    //   36: if_icmpge +23 -> 59
    //   39: aload_0
    //   40: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   43: iload_2
    //   44: new 893	java/util/HashMap
    //   47: dup
    //   48: invokespecial 906	java/util/HashMap:<init>	()V
    //   51: aastore
    //   52: iload_2
    //   53: iconst_1
    //   54: iadd
    //   55: istore_2
    //   56: goto -25 -> 31
    //   59: aload_0
    //   60: getfield 1706	androidx/f/a/a:bAD	Z
    //   63: ifne +1441 -> 1504
    //   66: new 1708	java/io/BufferedInputStream
    //   69: dup
    //   70: aload_1
    //   71: sipush 5000
    //   74: invokespecial 1711	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   77: astore_1
    //   78: aload_1
    //   79: checkcast 1708	java/io/BufferedInputStream
    //   82: astore 6
    //   84: aload 6
    //   86: sipush 5000
    //   89: invokevirtual 1714	java/io/BufferedInputStream:mark	(I)V
    //   92: sipush 5000
    //   95: newarray byte
    //   97: astore 7
    //   99: aload 6
    //   101: aload 7
    //   103: invokevirtual 1715	java/io/BufferedInputStream:read	([B)I
    //   106: pop
    //   107: aload 6
    //   109: invokevirtual 1716	java/io/BufferedInputStream:reset	()V
    //   112: aload 7
    //   114: invokestatic 1718	androidx/f/a/a:h	([B)Z
    //   117: ifeq +136 -> 253
    //   120: iconst_4
    //   121: istore_2
    //   122: aload_0
    //   123: iload_2
    //   124: putfield 1224	androidx/f/a/a:bAC	I
    //   127: aload_0
    //   128: getfield 1224	androidx/f/a/a:bAC	I
    //   131: istore_2
    //   132: iload_2
    //   133: iconst_4
    //   134: if_icmpeq +1373 -> 1507
    //   137: iload_2
    //   138: bipush 9
    //   140: if_icmpeq +1367 -> 1507
    //   143: iload_2
    //   144: bipush 13
    //   146: if_icmpeq +1361 -> 1507
    //   149: iload_2
    //   150: bipush 14
    //   152: if_icmpne +1365 -> 1517
    //   155: goto +1352 -> 1507
    //   158: iload_2
    //   159: ifeq +1255 -> 1414
    //   162: new 23	androidx/f/a/a$f
    //   165: dup
    //   166: aload_1
    //   167: invokespecial 1719	androidx/f/a/a$f:<init>	(Ljava/io/InputStream;)V
    //   170: astore 8
    //   172: aload_0
    //   173: getfield 1706	androidx/f/a/a:bAD	Z
    //   176: ifeq +163 -> 339
    //   179: aload 8
    //   181: getstatic 920	androidx/f/a/a:OM	[B
    //   184: arraylength
    //   185: invokevirtual 1394	androidx/f/a/a$f:eP	(I)V
    //   188: aload 8
    //   190: invokevirtual 1722	androidx/f/a/a$f:available	()I
    //   193: newarray byte
    //   195: astore_1
    //   196: aload 8
    //   198: aload_1
    //   199: invokevirtual 1461	androidx/f/a/a$f:readFully	([B)V
    //   202: aload_0
    //   203: getstatic 920	androidx/f/a/a:OM	[B
    //   206: arraylength
    //   207: putfield 1157	androidx/f/a/a:bAO	I
    //   210: aload_0
    //   211: aload_1
    //   212: iconst_0
    //   213: invokespecial 1341	androidx/f/a/a:b	([BI)V
    //   216: aload 8
    //   218: aload_0
    //   219: getfield 1157	androidx/f/a/a:bAO	I
    //   222: i2l
    //   223: invokevirtual 1411	androidx/f/a/a$f:seek	(J)V
    //   226: aload_0
    //   227: aload 8
    //   229: invokespecial 1343	androidx/f/a/a:f	(Landroidx/f/a/a$a;)V
    //   232: aload_0
    //   233: invokespecial 1724	androidx/f/a/a:FR	()V
    //   236: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   239: ifeq +1253 -> 1492
    //   242: aload_0
    //   243: invokespecial 1726	androidx/f/a/a:FL	()V
    //   246: ldc_w 1702
    //   249: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: aload 7
    //   255: invokestatic 1728	androidx/f/a/a:i	([B)Z
    //   258: ifeq +9 -> 267
    //   261: bipush 9
    //   263: istore_2
    //   264: goto -142 -> 122
    //   267: aload 7
    //   269: invokestatic 1731	androidx/f/a/a:j	([B)Z
    //   272: ifeq +9 -> 281
    //   275: bipush 12
    //   277: istore_2
    //   278: goto -156 -> 122
    //   281: aload_0
    //   282: aload 7
    //   284: invokespecial 1734	androidx/f/a/a:k	([B)Z
    //   287: ifeq +9 -> 296
    //   290: bipush 7
    //   292: istore_2
    //   293: goto -171 -> 122
    //   296: aload_0
    //   297: aload 7
    //   299: invokespecial 1737	androidx/f/a/a:l	([B)Z
    //   302: ifeq +9 -> 311
    //   305: bipush 10
    //   307: istore_2
    //   308: goto -186 -> 122
    //   311: aload 7
    //   313: invokestatic 1740	androidx/f/a/a:m	([B)Z
    //   316: ifeq +9 -> 325
    //   319: bipush 13
    //   321: istore_2
    //   322: goto -200 -> 122
    //   325: aload 7
    //   327: invokestatic 1743	androidx/f/a/a:n	([B)Z
    //   330: ifeq +1182 -> 1512
    //   333: bipush 14
    //   335: istore_2
    //   336: goto -214 -> 122
    //   339: aload_0
    //   340: getfield 1224	androidx/f/a/a:bAC	I
    //   343: bipush 12
    //   345: if_icmpne +601 -> 946
    //   348: getstatic 1138	android/os/Build$VERSION:SDK_INT	I
    //   351: bipush 28
    //   353: if_icmplt +551 -> 904
    //   356: new 1745	android/media/MediaMetadataRetriever
    //   359: dup
    //   360: invokespecial 1746	android/media/MediaMetadataRetriever:<init>	()V
    //   363: astore 9
    //   365: aload 9
    //   367: new 6	androidx/f/a/a$1
    //   370: dup
    //   371: aload_0
    //   372: aload 8
    //   374: invokespecial 1749	androidx/f/a/a$1:<init>	(Landroidx/f/a/a;Landroidx/f/a/a$f;)V
    //   377: invokestatic 1754	androidx/f/a/b$b:a	(Landroid/media/MediaMetadataRetriever;Landroid/media/MediaDataSource;)V
    //   380: aload 9
    //   382: bipush 33
    //   384: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   387: astore 10
    //   389: aload 9
    //   391: bipush 34
    //   393: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   396: astore 11
    //   398: aload 9
    //   400: bipush 26
    //   402: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   405: astore_1
    //   406: aload 9
    //   408: bipush 17
    //   410: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   413: astore 12
    //   415: aconst_null
    //   416: astore 7
    //   418: aconst_null
    //   419: astore 6
    //   421: ldc_w 1759
    //   424: aload_1
    //   425: invokevirtual 1426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   428: ifeq +256 -> 684
    //   431: aload 9
    //   433: bipush 29
    //   435: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   438: astore 7
    //   440: aload 9
    //   442: bipush 30
    //   444: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   447: astore 6
    //   449: aload 9
    //   451: bipush 31
    //   453: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   456: astore_1
    //   457: aload 7
    //   459: ifnull +28 -> 487
    //   462: aload_0
    //   463: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   466: iconst_0
    //   467: aaload
    //   468: ldc_w 276
    //   471: aload 7
    //   473: invokestatic 1763	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   476: aload_0
    //   477: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   480: invokestatic 1221	androidx/f/a/a$c:a	(ILjava/nio/ByteOrder;)Landroidx/f/a/a$c;
    //   483: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: pop
    //   487: aload 6
    //   489: ifnull +28 -> 517
    //   492: aload_0
    //   493: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   496: iconst_0
    //   497: aaload
    //   498: ldc_w 270
    //   501: aload 6
    //   503: invokestatic 1763	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   506: aload_0
    //   507: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   510: invokestatic 1221	androidx/f/a/a$c:a	(ILjava/nio/ByteOrder;)Landroidx/f/a/a$c;
    //   513: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: aload_1
    //   518: ifnull +63 -> 581
    //   521: aload_1
    //   522: invokestatic 1763	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   525: lookupswitch	default:+997->1522, 90:+1002->1527, 180:+1008->1533, 270:+1013->1538
    //   561: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   564: iconst_0
    //   565: aaload
    //   566: ldc_w 366
    //   569: iload_2
    //   570: aload_0
    //   571: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   574: invokestatic 1221	androidx/f/a/a$c:a	(ILjava/nio/ByteOrder;)Landroidx/f/a/a$c;
    //   577: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   580: pop
    //   581: aload 10
    //   583: ifnull +270 -> 853
    //   586: aload 11
    //   588: ifnull +265 -> 853
    //   591: aload 10
    //   593: invokestatic 1763	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   596: istore_2
    //   597: aload 11
    //   599: invokestatic 1763	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   602: istore_3
    //   603: iload_3
    //   604: bipush 6
    //   606: if_icmpgt +118 -> 724
    //   609: new 1163	java/io/IOException
    //   612: dup
    //   613: ldc_w 1765
    //   616: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   619: astore_1
    //   620: ldc_w 1702
    //   623: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   626: aload_1
    //   627: athrow
    //   628: astore_1
    //   629: new 1699	java/lang/UnsupportedOperationException
    //   632: dup
    //   633: ldc_w 1767
    //   636: invokespecial 1768	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   639: astore_1
    //   640: ldc_w 1702
    //   643: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   646: aload_1
    //   647: athrow
    //   648: astore_1
    //   649: aload 9
    //   651: invokevirtual 1771	android/media/MediaMetadataRetriever:release	()V
    //   654: ldc_w 1702
    //   657: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   660: aload_1
    //   661: athrow
    //   662: astore_1
    //   663: aload_0
    //   664: invokespecial 1724	androidx/f/a/a:FR	()V
    //   667: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   670: ifeq +822 -> 1492
    //   673: aload_0
    //   674: invokespecial 1726	androidx/f/a/a:FL	()V
    //   677: ldc_w 1702
    //   680: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   683: return
    //   684: ldc_w 1759
    //   687: aload 12
    //   689: invokevirtual 1426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifeq +807 -> 1499
    //   695: aload 9
    //   697: bipush 18
    //   699: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   702: astore 7
    //   704: aload 9
    //   706: bipush 19
    //   708: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   711: astore 6
    //   713: aload 9
    //   715: bipush 24
    //   717: invokevirtual 1757	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   720: astore_1
    //   721: goto -264 -> 457
    //   724: aload 8
    //   726: iload_2
    //   727: i2l
    //   728: invokevirtual 1411	androidx/f/a/a$f:seek	(J)V
    //   731: bipush 6
    //   733: newarray byte
    //   735: astore 10
    //   737: aload 8
    //   739: aload 10
    //   741: invokevirtual 1583	androidx/f/a/a$f:read	([B)I
    //   744: bipush 6
    //   746: if_icmpeq +22 -> 768
    //   749: new 1163	java/io/IOException
    //   752: dup
    //   753: ldc_w 1773
    //   756: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   759: astore_1
    //   760: ldc_w 1702
    //   763: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   766: aload_1
    //   767: athrow
    //   768: iload_3
    //   769: bipush 6
    //   771: isub
    //   772: istore_3
    //   773: aload 10
    //   775: getstatic 920	androidx/f/a/a:OM	[B
    //   778: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   781: ifne +22 -> 803
    //   784: new 1163	java/io/IOException
    //   787: dup
    //   788: ldc_w 1775
    //   791: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   794: astore_1
    //   795: ldc_w 1702
    //   798: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   801: aload_1
    //   802: athrow
    //   803: iload_3
    //   804: newarray byte
    //   806: astore 10
    //   808: aload 8
    //   810: aload 10
    //   812: invokevirtual 1583	androidx/f/a/a$f:read	([B)I
    //   815: iload_3
    //   816: if_icmpeq +22 -> 838
    //   819: new 1163	java/io/IOException
    //   822: dup
    //   823: ldc_w 1777
    //   826: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   829: astore_1
    //   830: ldc_w 1702
    //   833: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   836: aload_1
    //   837: athrow
    //   838: aload_0
    //   839: iload_2
    //   840: bipush 6
    //   842: iadd
    //   843: putfield 1157	androidx/f/a/a:bAO	I
    //   846: aload_0
    //   847: aload 10
    //   849: iconst_0
    //   850: invokespecial 1341	androidx/f/a/a:b	([BI)V
    //   853: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   856: ifeq +40 -> 896
    //   859: new 1051	java/lang/StringBuilder
    //   862: dup
    //   863: ldc_w 1779
    //   866: invokespecial 1054	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   869: aload 7
    //   871: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc_w 1781
    //   877: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload 6
    //   882: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: ldc_w 1783
    //   888: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: aload_1
    //   892: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 9
    //   898: invokevirtual 1771	android/media/MediaMetadataRetriever:release	()V
    //   901: goto -685 -> 216
    //   904: new 1699	java/lang/UnsupportedOperationException
    //   907: dup
    //   908: ldc_w 1785
    //   911: invokespecial 1768	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   914: astore_1
    //   915: ldc_w 1702
    //   918: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   921: aload_1
    //   922: athrow
    //   923: astore_1
    //   924: aload_0
    //   925: invokespecial 1724	androidx/f/a/a:FR	()V
    //   928: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   931: ifeq +7 -> 938
    //   934: aload_0
    //   935: invokespecial 1726	androidx/f/a/a:FL	()V
    //   938: ldc_w 1702
    //   941: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: aload_1
    //   945: athrow
    //   946: aload_0
    //   947: getfield 1224	androidx/f/a/a:bAC	I
    //   950: bipush 7
    //   952: if_icmpne +316 -> 1268
    //   955: aload_0
    //   956: aload 8
    //   958: invokespecial 1787	androidx/f/a/a:a	(Landroidx/f/a/a$f;)V
    //   961: aload_0
    //   962: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   965: iconst_1
    //   966: aaload
    //   967: ldc_w 321
    //   970: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   973: checkcast 14	androidx/f/a/a$c
    //   976: astore_1
    //   977: aload_1
    //   978: ifnull -762 -> 216
    //   981: new 23	androidx/f/a/a$f
    //   984: dup
    //   985: aload_1
    //   986: getfield 1251	androidx/f/a/a$c:Op	[B
    //   989: invokespecial 1393	androidx/f/a/a$f:<init>	([B)V
    //   992: astore_1
    //   993: aload_1
    //   994: aload_0
    //   995: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   998: putfield 1288	androidx/f/a/a$a:NZ	Ljava/nio/ByteOrder;
    //   1001: getstatic 676	androidx/f/a/a:bzT	[B
    //   1004: arraylength
    //   1005: newarray byte
    //   1007: astore 6
    //   1009: aload_1
    //   1010: aload 6
    //   1012: invokevirtual 1461	androidx/f/a/a$f:readFully	([B)V
    //   1015: aload_1
    //   1016: lconst_0
    //   1017: invokevirtual 1411	androidx/f/a/a$f:seek	(J)V
    //   1020: getstatic 681	androidx/f/a/a:bzU	[B
    //   1023: arraylength
    //   1024: newarray byte
    //   1026: astore 7
    //   1028: aload_1
    //   1029: aload 7
    //   1031: invokevirtual 1461	androidx/f/a/a$f:readFully	([B)V
    //   1034: aload 6
    //   1036: getstatic 676	androidx/f/a/a:bzT	[B
    //   1039: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   1042: ifeq +154 -> 1196
    //   1045: aload_1
    //   1046: ldc2_w 1788
    //   1049: invokevirtual 1411	androidx/f/a/a$f:seek	(J)V
    //   1052: aload_0
    //   1053: aload_1
    //   1054: bipush 6
    //   1056: invokespecial 1388	androidx/f/a/a:a	(Landroidx/f/a/a$f;I)V
    //   1059: aload_0
    //   1060: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1063: bipush 7
    //   1065: aaload
    //   1066: ldc_w 360
    //   1069: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1072: checkcast 14	androidx/f/a/a$c
    //   1075: astore_1
    //   1076: aload_0
    //   1077: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1080: bipush 7
    //   1082: aaload
    //   1083: ldc_w 357
    //   1086: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1089: checkcast 14	androidx/f/a/a$c
    //   1092: astore 6
    //   1094: aload_1
    //   1095: ifnull +37 -> 1132
    //   1098: aload 6
    //   1100: ifnull +32 -> 1132
    //   1103: aload_0
    //   1104: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1107: iconst_5
    //   1108: aaload
    //   1109: ldc_w 297
    //   1112: aload_1
    //   1113: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1116: pop
    //   1117: aload_0
    //   1118: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1121: iconst_5
    //   1122: aaload
    //   1123: ldc_w 300
    //   1126: aload 6
    //   1128: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1131: pop
    //   1132: aload_0
    //   1133: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1136: bipush 8
    //   1138: aaload
    //   1139: ldc_w 348
    //   1142: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1145: checkcast 14	androidx/f/a/a$c
    //   1148: astore_1
    //   1149: aload_1
    //   1150: ifnull -934 -> 216
    //   1153: aload_1
    //   1154: aload_0
    //   1155: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   1158: invokevirtual 1477	androidx/f/a/a$c:a	(Ljava/nio/ByteOrder;)Ljava/lang/Object;
    //   1161: checkcast 1478	[I
    //   1164: astore_1
    //   1165: aload_1
    //   1166: ifnull +9 -> 1175
    //   1169: aload_1
    //   1170: arraylength
    //   1171: iconst_4
    //   1172: if_icmpeq +376 -> 1548
    //   1175: new 1051	java/lang/StringBuilder
    //   1178: dup
    //   1179: ldc_w 1791
    //   1182: invokespecial 1054	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1185: aload_1
    //   1186: invokestatic 1639	java/util/Arrays:toString	([I)Ljava/lang/String;
    //   1189: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: goto -977 -> 216
    //   1196: aload 7
    //   1198: getstatic 681	androidx/f/a/a:bzU	[B
    //   1201: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   1204: ifeq -152 -> 1052
    //   1207: aload_1
    //   1208: ldc2_w 1792
    //   1211: invokevirtual 1411	androidx/f/a/a$f:seek	(J)V
    //   1214: goto -162 -> 1052
    //   1217: iload_3
    //   1218: aload_0
    //   1219: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   1222: invokestatic 1221	androidx/f/a/a$c:a	(ILjava/nio/ByteOrder;)Landroidx/f/a/a$c;
    //   1225: astore_1
    //   1226: iload_2
    //   1227: aload_0
    //   1228: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   1231: invokestatic 1221	androidx/f/a/a$c:a	(ILjava/nio/ByteOrder;)Landroidx/f/a/a$c;
    //   1234: astore 6
    //   1236: aload_0
    //   1237: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1240: iconst_0
    //   1241: aaload
    //   1242: ldc_w 276
    //   1245: aload_1
    //   1246: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1249: pop
    //   1250: aload_0
    //   1251: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1254: iconst_0
    //   1255: aaload
    //   1256: ldc_w 270
    //   1259: aload 6
    //   1261: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1264: pop
    //   1265: goto -1049 -> 216
    //   1268: aload_0
    //   1269: getfield 1224	androidx/f/a/a:bAC	I
    //   1272: bipush 10
    //   1274: if_icmpne +131 -> 1405
    //   1277: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   1280: ifeq +19 -> 1299
    //   1283: new 1051	java/lang/StringBuilder
    //   1286: dup
    //   1287: ldc_w 1795
    //   1290: invokespecial 1054	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1293: aload 8
    //   1295: invokevirtual 1266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload_0
    //   1300: aload 8
    //   1302: invokespecial 1787	androidx/f/a/a:a	(Landroidx/f/a/a$f;)V
    //   1305: aload_0
    //   1306: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1309: iconst_0
    //   1310: aaload
    //   1311: ldc_w 407
    //   1314: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1317: checkcast 14	androidx/f/a/a$c
    //   1320: astore_1
    //   1321: aload_1
    //   1322: ifnull +24 -> 1346
    //   1325: aload_0
    //   1326: new 8	androidx/f/a/a$a
    //   1329: dup
    //   1330: aload_1
    //   1331: getfield 1251	androidx/f/a/a$c:Op	[B
    //   1334: invokespecial 1284	androidx/f/a/a$a:<init>	([B)V
    //   1337: aload_1
    //   1338: getfield 1799	androidx/f/a/a$c:Oo	J
    //   1341: l2i
    //   1342: iconst_5
    //   1343: invokespecial 1287	androidx/f/a/a:a	(Landroidx/f/a/a$a;II)V
    //   1346: aload_0
    //   1347: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1350: iconst_0
    //   1351: aaload
    //   1352: ldc_w 404
    //   1355: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1358: checkcast 14	androidx/f/a/a$c
    //   1361: astore_1
    //   1362: aload_0
    //   1363: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1366: iconst_1
    //   1367: aaload
    //   1368: ldc_w 369
    //   1371: invokevirtual 1195	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1374: checkcast 14	androidx/f/a/a$c
    //   1377: astore 6
    //   1379: aload_1
    //   1380: ifnull -1164 -> 216
    //   1383: aload 6
    //   1385: ifnonnull -1169 -> 216
    //   1388: aload_0
    //   1389: getfield 1000	androidx/f/a/a:bAE	[Ljava/util/HashMap;
    //   1392: iconst_1
    //   1393: aaload
    //   1394: ldc_w 369
    //   1397: aload_1
    //   1398: invokevirtual 962	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1401: pop
    //   1402: goto -1186 -> 216
    //   1405: aload_0
    //   1406: aload 8
    //   1408: invokespecial 1787	androidx/f/a/a:a	(Landroidx/f/a/a$f;)V
    //   1411: goto -1195 -> 216
    //   1414: new 8	androidx/f/a/a$a
    //   1417: dup
    //   1418: aload_1
    //   1419: invokespecial 1591	androidx/f/a/a$a:<init>	(Ljava/io/InputStream;)V
    //   1422: astore_1
    //   1423: aload_0
    //   1424: getfield 1224	androidx/f/a/a:bAC	I
    //   1427: iconst_4
    //   1428: if_icmpne +13 -> 1441
    //   1431: aload_0
    //   1432: aload_1
    //   1433: iconst_0
    //   1434: iconst_0
    //   1435: invokespecial 1287	androidx/f/a/a:a	(Landroidx/f/a/a$a;II)V
    //   1438: goto -1206 -> 232
    //   1441: aload_0
    //   1442: getfield 1224	androidx/f/a/a:bAC	I
    //   1445: bipush 13
    //   1447: if_icmpne +11 -> 1458
    //   1450: aload_0
    //   1451: aload_1
    //   1452: invokespecial 1801	androidx/f/a/a:b	(Landroidx/f/a/a$a;)V
    //   1455: goto -1223 -> 232
    //   1458: aload_0
    //   1459: getfield 1224	androidx/f/a/a:bAC	I
    //   1462: bipush 9
    //   1464: if_icmpne +11 -> 1475
    //   1467: aload_0
    //   1468: aload_1
    //   1469: invokespecial 1803	androidx/f/a/a:a	(Landroidx/f/a/a$a;)V
    //   1472: goto -1240 -> 232
    //   1475: aload_0
    //   1476: getfield 1224	androidx/f/a/a:bAC	I
    //   1479: bipush 14
    //   1481: if_icmpne -1249 -> 232
    //   1484: aload_0
    //   1485: aload_1
    //   1486: invokespecial 1805	androidx/f/a/a:c	(Landroidx/f/a/a$a;)V
    //   1489: goto -1257 -> 232
    //   1492: ldc_w 1702
    //   1495: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1498: return
    //   1499: aconst_null
    //   1500: astore_1
    //   1501: goto -1044 -> 457
    //   1504: goto -1377 -> 127
    //   1507: iconst_0
    //   1508: istore_2
    //   1509: goto -1351 -> 158
    //   1512: iconst_0
    //   1513: istore_2
    //   1514: goto -1392 -> 122
    //   1517: iconst_1
    //   1518: istore_2
    //   1519: goto -1361 -> 158
    //   1522: iconst_1
    //   1523: istore_2
    //   1524: goto -964 -> 560
    //   1527: bipush 6
    //   1529: istore_2
    //   1530: goto -970 -> 560
    //   1533: iconst_3
    //   1534: istore_2
    //   1535: goto -975 -> 560
    //   1538: bipush 8
    //   1540: istore_2
    //   1541: goto -981 -> 560
    //   1544: astore_1
    //   1545: goto -882 -> 663
    //   1548: aload_1
    //   1549: iconst_2
    //   1550: iaload
    //   1551: aload_1
    //   1552: iconst_0
    //   1553: iaload
    //   1554: if_icmple -1338 -> 216
    //   1557: aload_1
    //   1558: iconst_3
    //   1559: iaload
    //   1560: aload_1
    //   1561: iconst_1
    //   1562: iaload
    //   1563: if_icmple -1347 -> 216
    //   1566: aload_1
    //   1567: iconst_2
    //   1568: iaload
    //   1569: aload_1
    //   1570: iconst_0
    //   1571: iaload
    //   1572: isub
    //   1573: iconst_1
    //   1574: iadd
    //   1575: istore 5
    //   1577: aload_1
    //   1578: iconst_3
    //   1579: iaload
    //   1580: aload_1
    //   1581: iconst_1
    //   1582: iaload
    //   1583: isub
    //   1584: iconst_1
    //   1585: iadd
    //   1586: istore 4
    //   1588: iload 4
    //   1590: istore_2
    //   1591: iload 5
    //   1593: istore_3
    //   1594: iload 5
    //   1596: iload 4
    //   1598: if_icmpge -381 -> 1217
    //   1601: iload 5
    //   1603: iload 4
    //   1605: iadd
    //   1606: istore_3
    //   1607: iload_3
    //   1608: iload 4
    //   1610: isub
    //   1611: istore_2
    //   1612: iload_3
    //   1613: iload_2
    //   1614: isub
    //   1615: istore_3
    //   1616: goto -399 -> 1217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1619	0	this	a
    //   0	1619	1	paramInputStream	InputStream
    //   30	1585	2	i	int
    //   602	1014	3	j	int
    //   1586	25	4	k	int
    //   1575	31	5	m	int
    //   82	1302	6	localObject1	Object
    //   97	1100	7	localObject2	Object
    //   170	1237	8	localf	f
    //   363	534	9	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   387	461	10	localObject3	Object
    //   396	202	11	str1	String
    //   413	275	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   365	415	628	java/lang/RuntimeException
    //   421	457	628	java/lang/RuntimeException
    //   462	487	628	java/lang/RuntimeException
    //   492	517	628	java/lang/RuntimeException
    //   521	560	628	java/lang/RuntimeException
    //   560	581	628	java/lang/RuntimeException
    //   591	603	628	java/lang/RuntimeException
    //   609	628	628	java/lang/RuntimeException
    //   684	721	628	java/lang/RuntimeException
    //   724	768	628	java/lang/RuntimeException
    //   773	803	628	java/lang/RuntimeException
    //   803	838	628	java/lang/RuntimeException
    //   838	853	628	java/lang/RuntimeException
    //   853	896	628	java/lang/RuntimeException
    //   365	415	648	finally
    //   421	457	648	finally
    //   462	487	648	finally
    //   492	517	648	finally
    //   521	560	648	finally
    //   560	581	648	finally
    //   591	603	648	finally
    //   609	628	648	finally
    //   629	648	648	finally
    //   684	721	648	finally
    //   724	768	648	finally
    //   773	803	648	finally
    //   803	838	648	finally
    //   838	853	648	finally
    //   853	896	648	finally
    //   31	52	662	java/io/IOException
    //   59	120	662	java/io/IOException
    //   122	127	662	java/io/IOException
    //   127	132	662	java/io/IOException
    //   162	216	662	java/io/IOException
    //   216	232	662	java/io/IOException
    //   253	261	662	java/io/IOException
    //   267	275	662	java/io/IOException
    //   281	290	662	java/io/IOException
    //   296	305	662	java/io/IOException
    //   311	319	662	java/io/IOException
    //   325	333	662	java/io/IOException
    //   339	365	662	java/io/IOException
    //   649	662	662	java/io/IOException
    //   896	901	662	java/io/IOException
    //   904	923	662	java/io/IOException
    //   946	977	662	java/io/IOException
    //   981	1052	662	java/io/IOException
    //   1052	1094	662	java/io/IOException
    //   1103	1132	662	java/io/IOException
    //   1132	1149	662	java/io/IOException
    //   1153	1165	662	java/io/IOException
    //   1169	1175	662	java/io/IOException
    //   1175	1193	662	java/io/IOException
    //   1196	1214	662	java/io/IOException
    //   1217	1265	662	java/io/IOException
    //   1268	1299	662	java/io/IOException
    //   1299	1321	662	java/io/IOException
    //   1325	1346	662	java/io/IOException
    //   1346	1379	662	java/io/IOException
    //   1388	1402	662	java/io/IOException
    //   1405	1411	662	java/io/IOException
    //   1414	1438	662	java/io/IOException
    //   1441	1455	662	java/io/IOException
    //   1458	1472	662	java/io/IOException
    //   1475	1489	662	java/io/IOException
    //   31	52	923	finally
    //   59	120	923	finally
    //   122	127	923	finally
    //   127	132	923	finally
    //   162	216	923	finally
    //   216	232	923	finally
    //   253	261	923	finally
    //   267	275	923	finally
    //   281	290	923	finally
    //   296	305	923	finally
    //   311	319	923	finally
    //   325	333	923	finally
    //   339	365	923	finally
    //   649	662	923	finally
    //   896	901	923	finally
    //   904	923	923	finally
    //   946	977	923	finally
    //   981	1052	923	finally
    //   1052	1094	923	finally
    //   1103	1132	923	finally
    //   1132	1149	923	finally
    //   1153	1165	923	finally
    //   1169	1175	923	finally
    //   1175	1193	923	finally
    //   1196	1214	923	finally
    //   1217	1265	923	finally
    //   1268	1299	923	finally
    //   1299	1321	923	finally
    //   1325	1346	923	finally
    //   1346	1379	923	finally
    //   1388	1402	923	finally
    //   1405	1411	923	finally
    //   1414	1438	923	finally
    //   1441	1455	923	finally
    //   1458	1472	923	finally
    //   1475	1489	923	finally
    //   31	52	1544	java/lang/UnsupportedOperationException
    //   59	120	1544	java/lang/UnsupportedOperationException
    //   122	127	1544	java/lang/UnsupportedOperationException
    //   127	132	1544	java/lang/UnsupportedOperationException
    //   162	216	1544	java/lang/UnsupportedOperationException
    //   216	232	1544	java/lang/UnsupportedOperationException
    //   253	261	1544	java/lang/UnsupportedOperationException
    //   267	275	1544	java/lang/UnsupportedOperationException
    //   281	290	1544	java/lang/UnsupportedOperationException
    //   296	305	1544	java/lang/UnsupportedOperationException
    //   311	319	1544	java/lang/UnsupportedOperationException
    //   325	333	1544	java/lang/UnsupportedOperationException
    //   339	365	1544	java/lang/UnsupportedOperationException
    //   649	662	1544	java/lang/UnsupportedOperationException
    //   896	901	1544	java/lang/UnsupportedOperationException
    //   904	923	1544	java/lang/UnsupportedOperationException
    //   946	977	1544	java/lang/UnsupportedOperationException
    //   981	1052	1544	java/lang/UnsupportedOperationException
    //   1052	1094	1544	java/lang/UnsupportedOperationException
    //   1103	1132	1544	java/lang/UnsupportedOperationException
    //   1132	1149	1544	java/lang/UnsupportedOperationException
    //   1153	1165	1544	java/lang/UnsupportedOperationException
    //   1169	1175	1544	java/lang/UnsupportedOperationException
    //   1175	1193	1544	java/lang/UnsupportedOperationException
    //   1196	1214	1544	java/lang/UnsupportedOperationException
    //   1217	1265	1544	java/lang/UnsupportedOperationException
    //   1268	1299	1544	java/lang/UnsupportedOperationException
    //   1299	1321	1544	java/lang/UnsupportedOperationException
    //   1325	1346	1544	java/lang/UnsupportedOperationException
    //   1346	1379	1544	java/lang/UnsupportedOperationException
    //   1388	1402	1544	java/lang/UnsupportedOperationException
    //   1405	1411	1544	java/lang/UnsupportedOperationException
    //   1414	1438	1544	java/lang/UnsupportedOperationException
    //   1441	1455	1544	java/lang/UnsupportedOperationException
    //   1458	1472	1544	java/lang/UnsupportedOperationException
    //   1475	1489	1544	java/lang/UnsupportedOperationException
  }
  
  private static boolean i(byte[] paramArrayOfByte)
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
  private static boolean j(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 1809
    //   3: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 13
    //   9: new 8	androidx/f/a/a$a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 1284	androidx/f/a/a$a:<init>	([B)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   22: i2l
    //   23: lstore 10
    //   25: iconst_4
    //   26: newarray byte
    //   28: astore 13
    //   30: aload_0
    //   31: aload 13
    //   33: invokevirtual 1270	androidx/f/a/a$a:read	([B)I
    //   36: pop
    //   37: aload 13
    //   39: getstatic 658	androidx/f/a/a:bzQ	[B
    //   42: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   45: istore 12
    //   47: iload 12
    //   49: ifne +15 -> 64
    //   52: aload_0
    //   53: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   56: ldc_w 1809
    //   59: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iconst_0
    //   63: ireturn
    //   64: ldc2_w 1788
    //   67: lstore 8
    //   69: lload 10
    //   71: lstore 6
    //   73: lload 10
    //   75: lconst_1
    //   76: lcmp
    //   77: ifne +35 -> 112
    //   80: aload_0
    //   81: invokevirtual 1815	androidx/f/a/a$a:readLong	()J
    //   84: lstore 6
    //   86: lload 6
    //   88: ldc2_w 1816
    //   91: lcmp
    //   92: ifge +15 -> 107
    //   95: aload_0
    //   96: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   99: ldc_w 1809
    //   102: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: iconst_0
    //   106: ireturn
    //   107: ldc2_w 1816
    //   110: lstore 8
    //   112: lload 6
    //   114: lstore 10
    //   116: lload 6
    //   118: ldc2_w 1818
    //   121: lcmp
    //   122: ifle +8 -> 130
    //   125: ldc2_w 1818
    //   128: lstore 10
    //   130: lload 10
    //   132: lload 8
    //   134: lsub
    //   135: lstore 8
    //   137: lload 8
    //   139: ldc2_w 1788
    //   142: lcmp
    //   143: ifge +15 -> 158
    //   146: aload_0
    //   147: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   150: ldc_w 1809
    //   153: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_0
    //   157: ireturn
    //   158: iconst_4
    //   159: newarray byte
    //   161: astore 13
    //   163: iconst_0
    //   164: istore_1
    //   165: iconst_0
    //   166: istore_2
    //   167: lconst_0
    //   168: lstore 6
    //   170: lload 6
    //   172: lload 8
    //   174: ldc2_w 1404
    //   177: ldiv
    //   178: lcmp
    //   179: ifge +128 -> 307
    //   182: aload_0
    //   183: aload 13
    //   185: invokevirtual 1270	androidx/f/a/a$a:read	([B)I
    //   188: istore_3
    //   189: iload_3
    //   190: iconst_4
    //   191: if_icmpeq +15 -> 206
    //   194: aload_0
    //   195: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   198: ldc_w 1809
    //   201: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: iconst_0
    //   205: ireturn
    //   206: iload_2
    //   207: istore 4
    //   209: iload_1
    //   210: istore 5
    //   212: lload 6
    //   214: lconst_1
    //   215: lcmp
    //   216: ifeq +76 -> 292
    //   219: aload 13
    //   221: getstatic 663	androidx/f/a/a:bzR	[B
    //   224: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   227: istore 12
    //   229: iload 12
    //   231: ifeq +37 -> 268
    //   234: iconst_1
    //   235: istore_3
    //   236: iload_2
    //   237: istore 4
    //   239: iload_3
    //   240: istore 5
    //   242: iload_3
    //   243: ifeq +49 -> 292
    //   246: iload_2
    //   247: istore 4
    //   249: iload_3
    //   250: istore 5
    //   252: iload_2
    //   253: ifeq +39 -> 292
    //   256: aload_0
    //   257: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   260: ldc_w 1809
    //   263: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: iconst_1
    //   267: ireturn
    //   268: aload 13
    //   270: getstatic 668	androidx/f/a/a:bzS	[B
    //   273: invokestatic 1369	java/util/Arrays:equals	([B[B)Z
    //   276: istore 12
    //   278: iload_1
    //   279: istore_3
    //   280: iload 12
    //   282: ifeq -46 -> 236
    //   285: iconst_1
    //   286: istore_2
    //   287: iload_1
    //   288: istore_3
    //   289: goto -53 -> 236
    //   292: lload 6
    //   294: lconst_1
    //   295: ladd
    //   296: lstore 6
    //   298: iload 4
    //   300: istore_2
    //   301: iload 5
    //   303: istore_1
    //   304: goto -134 -> 170
    //   307: aload_0
    //   308: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   311: ldc_w 1809
    //   314: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: aload 13
    //   322: astore_0
    //   323: aload_0
    //   324: ifnull -13 -> 311
    //   327: aload_0
    //   328: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   331: goto -20 -> 311
    //   334: astore 13
    //   336: aconst_null
    //   337: astore_0
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   346: ldc_w 1809
    //   349: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload 13
    //   354: athrow
    //   355: astore 13
    //   357: goto -19 -> 338
    //   360: astore 13
    //   362: goto -39 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramArrayOfByte	byte[]
    //   164	140	1	i	int
    //   166	135	2	j	int
    //   188	101	3	k	int
    //   207	92	4	m	int
    //   210	92	5	n	int
    //   71	226	6	l1	long
    //   67	106	8	l2	long
    //   23	108	10	l3	long
    //   45	236	12	bool	boolean
    //   7	314	13	arrayOfByte	byte[]
    //   334	19	13	localObject1	Object
    //   355	1	13	localObject2	Object
    //   360	1	13	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	18	319	java/lang/Exception
    //   9	18	334	finally
    //   18	47	355	finally
    //   80	86	355	finally
    //   158	163	355	finally
    //   170	189	355	finally
    //   219	229	355	finally
    //   268	278	355	finally
    //   18	47	360	java/lang/Exception
    //   80	86	360	java/lang/Exception
    //   158	163	360	java/lang/Exception
    //   170	189	360	java/lang/Exception
    //   219	229	360	java/lang/Exception
    //   268	278	360	java/lang/Exception
  }
  
  /* Error */
  private boolean k(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 1820
    //   5: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 8	androidx/f/a/a$a
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 1284	androidx/f/a/a$a:<init>	([B)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 1677	androidx/f/a/a:d	(Landroidx/f/a/a$a;)Ljava/nio/ByteOrder;
    //   22: putfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   30: putfield 1288	androidx/f/a/a$a:NZ	Ljava/nio/ByteOrder;
    //   33: aload_1
    //   34: invokevirtual 1298	androidx/f/a/a$a:readShort	()S
    //   37: istore_2
    //   38: iload_2
    //   39: sipush 20306
    //   42: if_icmpeq +10 -> 52
    //   45: iload_2
    //   46: sipush 21330
    //   49: if_icmpne +5 -> 54
    //   52: iconst_1
    //   53: istore_3
    //   54: aload_1
    //   55: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   58: ldc_w 1820
    //   61: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iload_3
    //   65: ireturn
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   77: ldc_w 1820
    //   80: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   97: ldc_w 1820
    //   100: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload 4
    //   105: athrow
    //   106: astore 4
    //   108: goto -19 -> 89
    //   111: astore 4
    //   113: goto -44 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	a
    //   0	116	1	paramArrayOfByte	byte[]
    //   37	13	2	i	int
    //   1	64	3	bool	boolean
    //   85	19	4	localObject1	Object
    //   106	1	4	localObject2	Object
    //   111	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   8	17	66	java/lang/Exception
    //   8	17	85	finally
    //   17	38	106	finally
    //   17	38	111	java/lang/Exception
  }
  
  /* Error */
  private boolean l(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 1821
    //   5: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 8	androidx/f/a/a$a
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 1284	androidx/f/a/a$a:<init>	([B)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 1677	androidx/f/a/a:d	(Landroidx/f/a/a$a;)Ljava/nio/ByteOrder;
    //   22: putfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 1011	androidx/f/a/a:bAG	Ljava/nio/ByteOrder;
    //   30: putfield 1288	androidx/f/a/a$a:NZ	Ljava/nio/ByteOrder;
    //   33: aload_1
    //   34: invokevirtual 1298	androidx/f/a/a$a:readShort	()S
    //   37: istore_2
    //   38: iload_2
    //   39: bipush 85
    //   41: if_icmpne +5 -> 46
    //   44: iconst_1
    //   45: istore_3
    //   46: aload_1
    //   47: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   50: ldc_w 1821
    //   53: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iload_3
    //   57: ireturn
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   69: ldc_w 1821
    //   72: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iconst_0
    //   76: ireturn
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 1812	androidx/f/a/a$a:close	()V
    //   89: ldc_w 1821
    //   92: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload 4
    //   97: athrow
    //   98: astore 4
    //   100: goto -19 -> 81
    //   103: astore 4
    //   105: goto -44 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	a
    //   0	108	1	paramArrayOfByte	byte[]
    //   37	5	2	i	int
    //   1	56	3	bool	boolean
    //   77	19	4	localObject1	Object
    //   98	1	4	localObject2	Object
    //   103	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   8	17	58	java/lang/Exception
    //   8	17	77	finally
    //   17	38	98	finally
    //   17	38	103	java/lang/Exception
  }
  
  private static boolean m(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < bzV.length)
    {
      if (paramArrayOfByte[i] != bzV[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static double n(String paramString1, String paramString2)
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
  
  private static boolean n(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < bzZ.length)
    {
      if (paramArrayOfByte[i] != bzZ[i]) {
        return false;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      if (i >= bAa.length) {
        break label65;
      }
      if (paramArrayOfByte[(bzZ.length + i + 4)] != bAa[i]) {
        break;
      }
      i += 1;
    }
    label65:
    return true;
  }
  
  public final boolean FK()
  {
    AppMethodBeat.i(193389);
    switch (k("Orientation", 1))
    {
    case 3: 
    case 6: 
    default: 
      AppMethodBeat.o(193389);
      return false;
    }
    AppMethodBeat.o(193389);
    return true;
  }
  
  /* Error */
  public final void FM()
  {
    // Byte code:
    //   0: ldc_w 1850
    //   3: invokestatic 616	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 1224	androidx/f/a/a:bAC	I
    //   10: istore_1
    //   11: iload_1
    //   12: iconst_4
    //   13: if_icmpeq +24 -> 37
    //   16: iload_1
    //   17: bipush 13
    //   19: if_icmpeq +18 -> 37
    //   22: iload_1
    //   23: bipush 14
    //   25: if_icmpeq +12 -> 37
    //   28: iload_1
    //   29: iconst_3
    //   30: if_icmpeq +7 -> 37
    //   33: iload_1
    //   34: ifne +28 -> 62
    //   37: iconst_1
    //   38: istore_1
    //   39: iload_1
    //   40: ifne +27 -> 67
    //   43: new 1163	java/io/IOException
    //   46: dup
    //   47: ldc_w 1852
    //   50: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: ldc_w 1850
    //   57: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_3
    //   61: athrow
    //   62: iconst_0
    //   63: istore_1
    //   64: goto -25 -> 39
    //   67: aload_0
    //   68: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   71: ifnonnull +29 -> 100
    //   74: aload_0
    //   75: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   78: ifnonnull +22 -> 100
    //   81: new 1163	java/io/IOException
    //   84: dup
    //   85: ldc_w 1854
    //   88: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   91: astore_3
    //   92: ldc_w 1850
    //   95: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_3
    //   99: athrow
    //   100: aload_0
    //   101: getfield 1117	androidx/f/a/a:bAH	Z
    //   104: ifeq +36 -> 140
    //   107: aload_0
    //   108: getfield 1211	androidx/f/a/a:bAI	Z
    //   111: ifeq +29 -> 140
    //   114: aload_0
    //   115: getfield 1569	androidx/f/a/a:bAJ	Z
    //   118: ifne +22 -> 140
    //   121: new 1163	java/io/IOException
    //   124: dup
    //   125: ldc_w 1856
    //   128: invokespecial 1166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   131: astore_3
    //   132: ldc_w 1850
    //   135: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_3
    //   139: athrow
    //   140: aload_0
    //   141: iconst_1
    //   142: putfield 1858	androidx/f/a/a:bAS	Z
    //   145: aload_0
    //   146: aload_0
    //   147: invokevirtual 1861	androidx/f/a/a:FN	()[B
    //   150: putfield 1119	androidx/f/a/a:bAM	[B
    //   153: aconst_null
    //   154: astore 4
    //   156: aconst_null
    //   157: astore 5
    //   159: aconst_null
    //   160: astore 7
    //   162: ldc_w 1863
    //   165: ldc_w 1865
    //   168: invokestatic 1871	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   171: astore 11
    //   173: aload_0
    //   174: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   177: ifnull +151 -> 328
    //   180: new 1030	java/io/FileInputStream
    //   183: dup
    //   184: aload_0
    //   185: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   188: invokespecial 1041	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   191: astore_3
    //   192: aload_3
    //   193: astore 5
    //   195: new 1873	java/io/FileOutputStream
    //   198: dup
    //   199: aload 11
    //   201: invokespecial 1876	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   204: astore 6
    //   206: aload_3
    //   207: aload 6
    //   209: invokestatic 1611	androidx/f/a/b:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   212: pop
    //   213: aload_3
    //   214: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   217: aload 6
    //   219: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   222: aconst_null
    //   223: astore 5
    //   225: aconst_null
    //   226: astore 6
    //   228: aconst_null
    //   229: astore 7
    //   231: iconst_0
    //   232: istore_1
    //   233: new 1030	java/io/FileInputStream
    //   236: dup
    //   237: aload 11
    //   239: invokespecial 1877	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore 8
    //   244: aload_0
    //   245: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   248: ifnull +194 -> 442
    //   251: new 1873	java/io/FileOutputStream
    //   254: dup
    //   255: aload_0
    //   256: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   259: invokespecial 1878	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   262: astore_3
    //   263: new 1708	java/io/BufferedInputStream
    //   266: dup
    //   267: aload 8
    //   269: invokespecial 1879	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   272: astore 4
    //   274: new 1881	java/io/BufferedOutputStream
    //   277: dup
    //   278: aload_3
    //   279: invokespecial 1883	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   282: astore 5
    //   284: aload_0
    //   285: getfield 1224	androidx/f/a/a:bAC	I
    //   288: iconst_4
    //   289: if_icmpne +319 -> 608
    //   292: aload_0
    //   293: aload 4
    //   295: aload 5
    //   297: invokespecial 1885	androidx/f/a/a:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   300: aload 4
    //   302: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   305: aload 5
    //   307: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   310: aload 11
    //   312: invokevirtual 1888	java/io/File:delete	()Z
    //   315: pop
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 1119	androidx/f/a/a:bAM	[B
    //   321: ldc_w 1850
    //   324: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: return
    //   328: getstatic 1138	android/os/Build$VERSION:SDK_INT	I
    //   331: bipush 21
    //   333: if_icmplt +864 -> 1197
    //   336: aload_0
    //   337: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   340: lconst_0
    //   341: getstatic 1148	android/system/OsConstants:SEEK_SET	I
    //   344: invokestatic 1151	androidx/f/a/b$a:a	(Ljava/io/FileDescriptor;JI)J
    //   347: pop2
    //   348: new 1030	java/io/FileInputStream
    //   351: dup
    //   352: aload_0
    //   353: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   356: invokespecial 1153	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   359: astore_3
    //   360: goto -168 -> 192
    //   363: astore 6
    //   365: aconst_null
    //   366: astore_3
    //   367: aload 7
    //   369: astore 4
    //   371: aload_3
    //   372: astore 5
    //   374: new 1163	java/io/IOException
    //   377: dup
    //   378: ldc_w 1890
    //   381: aload 6
    //   383: invokespecial 1662	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   386: astore 6
    //   388: aload 7
    //   390: astore 4
    //   392: aload_3
    //   393: astore 5
    //   395: ldc_w 1850
    //   398: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload 7
    //   403: astore 4
    //   405: aload_3
    //   406: astore 5
    //   408: aload 6
    //   410: athrow
    //   411: astore 6
    //   413: aload 5
    //   415: astore_3
    //   416: aload 4
    //   418: astore 5
    //   420: aload 6
    //   422: astore 4
    //   424: aload_3
    //   425: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   428: aload 5
    //   430: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   433: ldc_w 1850
    //   436: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   439: aload 4
    //   441: athrow
    //   442: getstatic 1138	android/os/Build$VERSION:SDK_INT	I
    //   445: bipush 21
    //   447: if_icmplt +745 -> 1192
    //   450: aload_0
    //   451: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   454: lconst_0
    //   455: getstatic 1148	android/system/OsConstants:SEEK_SET	I
    //   458: invokestatic 1151	androidx/f/a/b$a:a	(Ljava/io/FileDescriptor;JI)J
    //   461: pop2
    //   462: new 1873	java/io/FileOutputStream
    //   465: dup
    //   466: aload_0
    //   467: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   470: invokespecial 1891	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   473: astore_3
    //   474: goto -211 -> 263
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_3
    //   481: aload 8
    //   483: astore 5
    //   485: new 1030	java/io/FileInputStream
    //   488: dup
    //   489: aload 11
    //   491: invokespecial 1877	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   494: astore 10
    //   496: aload_3
    //   497: astore 8
    //   499: aload_3
    //   500: astore 9
    //   502: aload_0
    //   503: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   506: ifnull +422 -> 928
    //   509: aload_3
    //   510: astore 8
    //   512: aload_3
    //   513: astore 9
    //   515: new 1873	java/io/FileOutputStream
    //   518: dup
    //   519: aload_0
    //   520: getfield 1020	androidx/f/a/a:bAz	Ljava/lang/String;
    //   523: invokespecial 1878	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   526: astore 5
    //   528: aload 5
    //   530: astore 8
    //   532: aload 5
    //   534: astore 9
    //   536: aload 10
    //   538: aload 5
    //   540: invokestatic 1611	androidx/f/a/b:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   543: pop
    //   544: aload 10
    //   546: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   549: aload 5
    //   551: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   554: new 1163	java/io/IOException
    //   557: dup
    //   558: ldc_w 1893
    //   561: aload 4
    //   563: invokespecial 1662	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   566: astore_3
    //   567: ldc_w 1850
    //   570: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   573: aload_3
    //   574: athrow
    //   575: astore_3
    //   576: aload 7
    //   578: astore 4
    //   580: aload 6
    //   582: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   585: aload 4
    //   587: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   590: iload_1
    //   591: ifne +9 -> 600
    //   594: aload 11
    //   596: invokevirtual 1888	java/io/File:delete	()Z
    //   599: pop
    //   600: ldc_w 1850
    //   603: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: aload_3
    //   607: athrow
    //   608: aload_0
    //   609: getfield 1224	androidx/f/a/a:bAC	I
    //   612: bipush 13
    //   614: if_icmpne +259 -> 873
    //   617: getstatic 626	androidx/f/a/a:DEBUG	Z
    //   620: ifeq +36 -> 656
    //   623: new 1051	java/lang/StringBuilder
    //   626: dup
    //   627: ldc_w 1895
    //   630: invokespecial 1054	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   633: aload 4
    //   635: invokevirtual 1266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   638: ldc_w 1589
    //   641: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 5
    //   646: invokevirtual 1266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   649: ldc_w 1326
    //   652: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: new 8	androidx/f/a/a$a
    //   659: dup
    //   660: aload 4
    //   662: invokespecial 1591	androidx/f/a/a$a:<init>	(Ljava/io/InputStream;)V
    //   665: astore 6
    //   667: new 11	androidx/f/a/a$b
    //   670: dup
    //   671: aload 5
    //   673: getstatic 1009	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   676: invokespecial 1594	androidx/f/a/a$b:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   679: astore 9
    //   681: aload 6
    //   683: aload 9
    //   685: getstatic 689	androidx/f/a/a:bzV	[B
    //   688: arraylength
    //   689: invokestatic 1358	androidx/f/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   692: aload_0
    //   693: getfield 1157	androidx/f/a/a:bAO	I
    //   696: ifne +126 -> 822
    //   699: aload 6
    //   701: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   704: istore_2
    //   705: aload 9
    //   707: iload_2
    //   708: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   711: aload 6
    //   713: aload 9
    //   715: iload_2
    //   716: iconst_4
    //   717: iadd
    //   718: iconst_4
    //   719: iadd
    //   720: invokestatic 1358	androidx/f/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   723: new 1649	java/io/ByteArrayOutputStream
    //   726: dup
    //   727: invokespecial 1650	java/io/ByteArrayOutputStream:<init>	()V
    //   730: astore 7
    //   732: new 11	androidx/f/a/a$b
    //   735: dup
    //   736: aload 7
    //   738: getstatic 1009	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   741: invokespecial 1594	androidx/f/a/a$b:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   744: astore 10
    //   746: aload_0
    //   747: aload 10
    //   749: invokespecial 1598	androidx/f/a/a:a	(Landroidx/f/a/a$b;)I
    //   752: pop
    //   753: aload 10
    //   755: getfield 1899	androidx/f/a/a$b:NY	Ljava/io/OutputStream;
    //   758: checkcast 1649	java/io/ByteArrayOutputStream
    //   761: invokevirtual 1902	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   764: astore 10
    //   766: aload 9
    //   768: aload 10
    //   770: invokevirtual 1248	androidx/f/a/a$b:write	([B)V
    //   773: new 1552	java/util/zip/CRC32
    //   776: dup
    //   777: invokespecial 1553	java/util/zip/CRC32:<init>	()V
    //   780: astore 12
    //   782: aload 12
    //   784: aload 10
    //   786: iconst_4
    //   787: aload 10
    //   789: arraylength
    //   790: iconst_4
    //   791: isub
    //   792: invokevirtual 1904	java/util/zip/CRC32:update	([BII)V
    //   795: aload 9
    //   797: aload 12
    //   799: invokevirtual 1558	java/util/zip/CRC32:getValue	()J
    //   802: l2i
    //   803: invokevirtual 1239	androidx/f/a/a$b:aX	(I)V
    //   806: aload 7
    //   808: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   811: aload 6
    //   813: aload 9
    //   815: invokestatic 1611	androidx/f/a/b:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   818: pop
    //   819: goto -519 -> 300
    //   822: aload 6
    //   824: aload 9
    //   826: aload_0
    //   827: getfield 1157	androidx/f/a/a:bAO	I
    //   830: getstatic 689	androidx/f/a/a:bzV	[B
    //   833: arraylength
    //   834: isub
    //   835: iconst_4
    //   836: isub
    //   837: iconst_4
    //   838: isub
    //   839: invokestatic 1358	androidx/f/a/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   842: aload 6
    //   844: aload 6
    //   846: invokevirtual 1291	androidx/f/a/a$a:readInt	()I
    //   849: iconst_4
    //   850: iadd
    //   851: iconst_4
    //   852: iadd
    //   853: invokevirtual 1269	androidx/f/a/a$a:eP	(I)V
    //   856: goto -133 -> 723
    //   859: aload 7
    //   861: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   864: ldc_w 1850
    //   867: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   870: aload 6
    //   872: athrow
    //   873: aload_0
    //   874: getfield 1224	androidx/f/a/a:bAC	I
    //   877: bipush 14
    //   879: if_icmpne +14 -> 893
    //   882: aload_0
    //   883: aload 4
    //   885: aload 5
    //   887: invokespecial 1906	androidx/f/a/a:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   890: goto -590 -> 300
    //   893: aload_0
    //   894: getfield 1224	androidx/f/a/a:bAC	I
    //   897: iconst_3
    //   898: if_icmpeq +10 -> 908
    //   901: aload_0
    //   902: getfield 1224	androidx/f/a/a:bAC	I
    //   905: ifne -605 -> 300
    //   908: aload_0
    //   909: new 11	androidx/f/a/a$b
    //   912: dup
    //   913: aload 5
    //   915: getstatic 1009	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   918: invokespecial 1594	androidx/f/a/a$b:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   921: invokespecial 1598	androidx/f/a/a:a	(Landroidx/f/a/a$b;)I
    //   924: pop
    //   925: goto -625 -> 300
    //   928: aload_3
    //   929: astore 5
    //   931: aload_3
    //   932: astore 8
    //   934: aload_3
    //   935: astore 9
    //   937: getstatic 1138	android/os/Build$VERSION:SDK_INT	I
    //   940: bipush 21
    //   942: if_icmplt -414 -> 528
    //   945: aload_3
    //   946: astore 8
    //   948: aload_3
    //   949: astore 9
    //   951: aload_0
    //   952: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   955: lconst_0
    //   956: getstatic 1148	android/system/OsConstants:SEEK_SET	I
    //   959: invokestatic 1151	androidx/f/a/b$a:a	(Ljava/io/FileDescriptor;JI)J
    //   962: pop2
    //   963: aload_3
    //   964: astore 8
    //   966: aload_3
    //   967: astore 9
    //   969: new 1873	java/io/FileOutputStream
    //   972: dup
    //   973: aload_0
    //   974: getfield 1026	androidx/f/a/a:bAA	Ljava/io/FileDescriptor;
    //   977: invokespecial 1891	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   980: astore 5
    //   982: goto -454 -> 528
    //   985: astore 4
    //   987: new 1163	java/io/IOException
    //   990: dup
    //   991: new 1051	java/lang/StringBuilder
    //   994: dup
    //   995: ldc_w 1908
    //   998: invokespecial 1054	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1001: aload 11
    //   1003: invokevirtual 1911	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1006: invokevirtual 1063	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 1316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: aload 4
    //   1014: invokespecial 1662	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1017: astore 4
    //   1019: ldc_w 1850
    //   1022: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1025: aload 4
    //   1027: athrow
    //   1028: astore 4
    //   1030: iconst_1
    //   1031: istore_1
    //   1032: aload 5
    //   1034: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   1037: aload_3
    //   1038: invokestatic 1047	androidx/f/a/b:closeQuietly	(Ljava/io/Closeable;)V
    //   1041: ldc_w 1850
    //   1044: invokestatic 990	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1047: aload 4
    //   1049: athrow
    //   1050: astore_3
    //   1051: aload 7
    //   1053: astore 4
    //   1055: goto -475 -> 580
    //   1058: astore_3
    //   1059: aconst_null
    //   1060: astore 4
    //   1062: aload 5
    //   1064: astore 6
    //   1066: goto -486 -> 580
    //   1069: astore_3
    //   1070: aconst_null
    //   1071: astore 5
    //   1073: aload 4
    //   1075: astore 6
    //   1077: aload 5
    //   1079: astore 4
    //   1081: goto -501 -> 580
    //   1084: astore 4
    //   1086: iconst_0
    //   1087: istore_1
    //   1088: goto -56 -> 1032
    //   1091: astore 4
    //   1093: iconst_0
    //   1094: istore_1
    //   1095: aload 10
    //   1097: astore 5
    //   1099: aload 8
    //   1101: astore_3
    //   1102: goto -70 -> 1032
    //   1105: astore 4
    //   1107: aload 10
    //   1109: astore 5
    //   1111: aload 9
    //   1113: astore_3
    //   1114: goto -127 -> 987
    //   1117: astore 4
    //   1119: aconst_null
    //   1120: astore_3
    //   1121: aconst_null
    //   1122: astore 5
    //   1124: goto -639 -> 485
    //   1127: astore 4
    //   1129: aload 8
    //   1131: astore 5
    //   1133: goto -648 -> 485
    //   1136: astore 5
    //   1138: aload 4
    //   1140: astore 6
    //   1142: aload 5
    //   1144: astore 4
    //   1146: aload 8
    //   1148: astore 5
    //   1150: goto -665 -> 485
    //   1153: astore 6
    //   1155: goto -296 -> 859
    //   1158: astore 4
    //   1160: aconst_null
    //   1161: astore_3
    //   1162: goto -738 -> 424
    //   1165: astore 4
    //   1167: aload 6
    //   1169: astore 5
    //   1171: goto -747 -> 424
    //   1174: astore 6
    //   1176: goto -809 -> 367
    //   1179: astore 4
    //   1181: aload 6
    //   1183: astore 7
    //   1185: aload 4
    //   1187: astore 6
    //   1189: goto -822 -> 367
    //   1192: aconst_null
    //   1193: astore_3
    //   1194: goto -931 -> 263
    //   1197: aconst_null
    //   1198: astore_3
    //   1199: goto -1007 -> 192
    //   1202: astore 7
    //   1204: aload 4
    //   1206: astore 6
    //   1208: aload 7
    //   1210: astore 4
    //   1212: aload 5
    //   1214: astore 7
    //   1216: aload 8
    //   1218: astore 5
    //   1220: goto -735 -> 485
    //   1223: astore_3
    //   1224: aload 4
    //   1226: astore 6
    //   1228: aload 5
    //   1230: astore 4
    //   1232: goto -652 -> 580
    //   1235: astore 6
    //   1237: aconst_null
    //   1238: astore 7
    //   1240: goto -381 -> 859
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1243	0	this	a
    //   10	1085	1	i	int
    //   704	14	2	j	int
    //   53	521	3	localObject1	Object
    //   575	463	3	localCloseable1	java.io.Closeable
    //   1050	1	3	localObject2	Object
    //   1058	1	3	localObject3	Object
    //   1069	1	3	localObject4	Object
    //   1101	98	3	localObject5	Object
    //   1223	1	3	localObject6	Object
    //   154	286	4	localObject7	Object
    //   477	85	4	localException1	Exception
    //   578	306	4	localObject8	Object
    //   985	28	4	localException2	Exception
    //   1017	9	4	localIOException1	IOException
    //   1028	20	4	localObject9	Object
    //   1053	27	4	localObject10	Object
    //   1084	1	4	localObject11	Object
    //   1091	1	4	localObject12	Object
    //   1105	1	4	localException3	Exception
    //   1117	1	4	localException4	Exception
    //   1127	12	4	localException5	Exception
    //   1144	1	4	localObject13	Object
    //   1158	1	4	localObject14	Object
    //   1165	1	4	localObject15	Object
    //   1179	26	4	localException6	Exception
    //   1210	21	4	localObject16	Object
    //   157	975	5	localObject17	Object
    //   1136	7	5	localException7	Exception
    //   1148	81	5	localObject18	Object
    //   204	23	6	localFileOutputStream	java.io.FileOutputStream
    //   363	19	6	localException8	Exception
    //   386	23	6	localIOException2	IOException
    //   411	170	6	localCloseable2	java.io.Closeable
    //   665	476	6	localObject19	Object
    //   1153	15	6	localObject20	Object
    //   1174	8	6	localException9	Exception
    //   1187	40	6	localObject21	Object
    //   1235	1	6	localObject22	Object
    //   160	1024	7	localObject23	Object
    //   1202	7	7	localException10	Exception
    //   1214	25	7	localObject24	Object
    //   242	975	8	localObject25	Object
    //   500	612	9	localObject26	Object
    //   494	614	10	localObject27	Object
    //   171	831	11	localFile	java.io.File
    //   780	18	12	localCRC32	CRC32
    // Exception table:
    //   from	to	target	type
    //   162	192	363	java/lang/Exception
    //   328	360	363	java/lang/Exception
    //   195	206	411	finally
    //   374	388	411	finally
    //   395	401	411	finally
    //   408	411	411	finally
    //   244	263	477	java/lang/Exception
    //   442	474	477	java/lang/Exception
    //   544	575	575	finally
    //   485	496	985	java/lang/Exception
    //   987	1028	1028	finally
    //   1032	1050	1050	finally
    //   233	244	1058	finally
    //   244	263	1058	finally
    //   263	274	1058	finally
    //   442	474	1058	finally
    //   274	284	1069	finally
    //   485	496	1084	finally
    //   502	509	1091	finally
    //   515	528	1091	finally
    //   536	544	1091	finally
    //   937	945	1091	finally
    //   951	963	1091	finally
    //   969	982	1091	finally
    //   502	509	1105	java/lang/Exception
    //   515	528	1105	java/lang/Exception
    //   536	544	1105	java/lang/Exception
    //   937	945	1105	java/lang/Exception
    //   951	963	1105	java/lang/Exception
    //   969	982	1105	java/lang/Exception
    //   233	244	1117	java/lang/Exception
    //   263	274	1127	java/lang/Exception
    //   274	284	1136	java/lang/Exception
    //   732	806	1153	finally
    //   162	192	1158	finally
    //   328	360	1158	finally
    //   206	213	1165	finally
    //   195	206	1174	java/lang/Exception
    //   206	213	1179	java/lang/Exception
    //   284	300	1202	java/lang/Exception
    //   608	656	1202	java/lang/Exception
    //   656	723	1202	java/lang/Exception
    //   806	819	1202	java/lang/Exception
    //   822	856	1202	java/lang/Exception
    //   859	873	1202	java/lang/Exception
    //   873	890	1202	java/lang/Exception
    //   893	908	1202	java/lang/Exception
    //   908	925	1202	java/lang/Exception
    //   284	300	1223	finally
    //   608	656	1223	finally
    //   656	723	1223	finally
    //   806	819	1223	finally
    //   822	856	1223	finally
    //   859	873	1223	finally
    //   873	890	1223	finally
    //   893	908	1223	finally
    //   908	925	1223	finally
    //   723	732	1235	finally
  }
  
  public final byte[] FN()
  {
    AppMethodBeat.i(178725);
    if ((this.bAN == 6) || (this.bAN == 7))
    {
      byte[] arrayOfByte = FO();
      AppMethodBeat.o(178725);
      return arrayOfByte;
    }
    AppMethodBeat.o(178725);
    return null;
  }
  
  public final double[] FP()
  {
    AppMethodBeat.i(178727);
    String str1 = aC("GPSLatitude");
    String str2 = aC("GPSLatitudeRef");
    String str3 = aC("GPSLongitude");
    String str4 = aC("GPSLongitudeRef");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null)) {
      try
      {
        double d1 = n(str1, str2);
        double d2 = n(str3, str4);
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
  
  public final double FQ()
  {
    int i = -1;
    AppMethodBeat.i(193439);
    double d1 = a("GPSAltitude", -1.0D);
    int j = k("GPSAltitudeRef", -1);
    if ((d1 >= 0.0D) && (j >= 0))
    {
      if (j == 1) {}
      for (;;)
      {
        double d2 = i;
        AppMethodBeat.o(193439);
        return d2 * d1;
        i = 1;
      }
    }
    AppMethodBeat.o(193439);
    return 0.0D;
  }
  
  public final double a(String paramString, double paramDouble)
  {
    AppMethodBeat.i(178718);
    paramString = aB(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178718);
      return paramDouble;
    }
    try
    {
      double d = paramString.b(this.bAG);
      AppMethodBeat.o(178718);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(178718);
    }
    return paramDouble;
  }
  
  public final String aC(String paramString)
  {
    AppMethodBeat.i(178716);
    if (paramString == null)
    {
      paramString = new NullPointerException("tag shouldn't be null");
      AppMethodBeat.o(178716);
      throw paramString;
    }
    c localc = aB(paramString);
    if (localc != null)
    {
      if (!Ox.contains(paramString))
      {
        paramString = localc.d(this.bAG);
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
        paramString = (e[])localc.a(this.bAG);
        if ((paramString == null) || (paramString.length != 3))
        {
          new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(paramString));
          AppMethodBeat.o(178716);
          return null;
        }
        paramString = String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)paramString[0].bBb / (float)paramString[0].bBc)), Integer.valueOf((int)((float)paramString[1].bBb / (float)paramString[1].bBc)), Integer.valueOf((int)((float)paramString[2].bBb / (float)paramString[2].bBc)) });
        AppMethodBeat.o(178716);
        return paramString;
      }
      try
      {
        paramString = Double.toString(localc.b(this.bAG));
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
  
  public final int iB()
  {
    AppMethodBeat.i(193399);
    switch (k("Orientation", 1))
    {
    default: 
      AppMethodBeat.o(193399);
      return 0;
    case 6: 
    case 7: 
      AppMethodBeat.o(193399);
      return 90;
    case 3: 
    case 4: 
      AppMethodBeat.o(193399);
      return 180;
    }
    AppMethodBeat.o(193399);
    return 270;
  }
  
  public final int k(String paramString, int paramInt)
  {
    AppMethodBeat.i(178717);
    paramString = aB(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178717);
      return paramInt;
    }
    try
    {
      int i = paramString.c(this.bAG);
      AppMethodBeat.o(178717);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(178717);
    }
    return paramInt;
  }
  
  public final void m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(178719);
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("tag shouldn't be null");
      AppMethodBeat.o(178719);
      throw paramString1;
    }
    Object localObject1;
    if ((!"DateTime".equals(paramString1)) && (!"DateTimeOriginal".equals(paramString1)))
    {
      localObject1 = paramString2;
      if (!"DateTimeDigitized".equals(paramString1)) {}
    }
    else
    {
      localObject1 = paramString2;
      if (paramString2 != null)
      {
        boolean bool1 = OC.matcher(paramString2).find();
        boolean bool2 = OD.matcher(paramString2).find();
        if ((paramString2.length() != 19) || ((!bool1) && (!bool2)))
        {
          new StringBuilder("Invalid value for ").append(paramString1).append(" : ").append(paramString2);
          AppMethodBeat.o(178719);
          return;
        }
        localObject1 = paramString2;
        if (bool2) {
          localObject1 = paramString2.replaceAll("-", ":");
        }
      }
    }
    paramString2 = paramString1;
    if ("ISOSpeedRatings".equals(paramString1)) {
      paramString2 = "PhotographicSensitivity";
    }
    paramString1 = (String)localObject1;
    if (localObject1 != null)
    {
      paramString1 = (String)localObject1;
      if (Ox.contains(paramString2))
      {
        if (!paramString2.equals("GPSTimeStamp")) {
          break label388;
        }
        paramString1 = OB.matcher((CharSequence)localObject1);
        if (!paramString1.find())
        {
          new StringBuilder("Invalid value for ").append(paramString2).append(" : ").append((String)localObject1);
          AppMethodBeat.o(178719);
          return;
        }
        paramString1 = Integer.parseInt(paramString1.group(1)) + "/1," + Integer.parseInt(paramString1.group(2)) + "/1," + Integer.parseInt(paramString1.group(3)) + "/1";
      }
    }
    int j = 0;
    if (j < bAt.length)
    {
      if ((j != 4) || (this.bAH))
      {
        localObject1 = (d)bAw[j].get(paramString2);
        if (localObject1 != null)
        {
          if (paramString1 != null) {
            break label441;
          }
          this.bAE[j].remove(paramString2);
        }
      }
      for (;;)
      {
        for (;;)
        {
          j += 1;
          break;
          try
          {
            label388:
            paramString1 = new e(Double.parseDouble((String)localObject1)).toString();
          }
          catch (NumberFormatException paramString1)
          {
            new StringBuilder("Invalid value for ").append(paramString2).append(" : ").append((String)localObject1);
            AppMethodBeat.o(178719);
            return;
          }
        }
        label441:
        Object localObject2 = af(paramString1);
        int i;
        if ((((d)localObject1).OU == ((Integer)((Pair)localObject2).first).intValue()) || (((d)localObject1).OU == ((Integer)((Pair)localObject2).second).intValue())) {
          i = ((d)localObject1).OU;
        }
        label491:
        Object localObject3;
        switch (i)
        {
        case 6: 
        case 8: 
        case 11: 
        default: 
          break;
        case 1: 
          localObject2 = this.bAE[j];
          if ((paramString1.length() == 1) && (paramString1.charAt(0) >= '0') && (paramString1.charAt(0) <= '1')) {}
          for (localObject1 = new c(1, 1, new byte[] { (byte)(paramString1.charAt(0) - '0') });; localObject1 = new c(1, localObject1.length, (byte[])localObject1))
          {
            ((HashMap)localObject2).put(paramString2, localObject1);
            break;
            if ((((d)localObject1).OV != -1) && ((((d)localObject1).OV == ((Integer)((Pair)localObject2).first).intValue()) || (((d)localObject1).OV == ((Integer)((Pair)localObject2).second).intValue())))
            {
              i = ((d)localObject1).OV;
              break label491;
            }
            if ((((d)localObject1).OU == 1) || (((d)localObject1).OU == 7) || (((d)localObject1).OU == 2))
            {
              i = ((d)localObject1).OU;
              break label491;
            }
            if (!DEBUG) {
              break;
            }
            localObject3 = new StringBuilder("Given tag (").append(paramString2).append(") value didn't match with one of expected formats: ").append(Ok[localObject1.OU]);
            if (((d)localObject1).OV == -1)
            {
              localObject1 = "";
              localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(" (guess: ").append(Ok[((Integer)localObject2.first).intValue()]);
              if (((Integer)((Pair)localObject2).second).intValue() != -1) {
                break label881;
              }
            }
            for (localObject1 = "";; localObject1 = ", " + Ok[((Integer)localObject2.second).intValue()])
            {
              ((StringBuilder)localObject3).append((String)localObject1).append(")");
              break;
              localObject1 = ", " + Ok[localObject1.OV];
              break label781;
            }
            localObject1 = paramString1.getBytes(Oj);
          }
        case 2: 
        case 7: 
          this.bAE[j].put(paramString2, c.aE(paramString1));
          break;
        case 3: 
          localObject1 = paramString1.split(",", -1);
          localObject2 = new int[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Integer.parseInt(localObject1[i]);
            i += 1;
          }
          this.bAE[j].put(paramString2, c.c((int[])localObject2, this.bAG));
          break;
        case 9: 
          localObject1 = paramString1.split(",", -1);
          localObject2 = new int[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Integer.parseInt(localObject1[i]);
            i += 1;
          }
          this.bAE[j].put(paramString2, c.d((int[])localObject2, this.bAG));
          break;
        case 4: 
          localObject1 = paramString1.split(",", -1);
          localObject2 = new long[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Long.parseLong(localObject1[i]);
            i += 1;
          }
          this.bAE[j].put(paramString2, c.b((long[])localObject2, this.bAG));
          break;
        case 5: 
          localObject1 = paramString1.split(",", -1);
          localObject2 = new e[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject3 = localObject1[i].split("/", -1);
            localObject2[i] = new e(Double.parseDouble(localObject3[0]), Double.parseDouble(localObject3[1]));
            i += 1;
          }
          this.bAE[j].put(paramString2, c.a((e[])localObject2, this.bAG));
          break;
        case 10: 
          localObject1 = paramString1.split(",", -1);
          localObject2 = new e[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject3 = localObject1[i].split("/", -1);
            localObject2[i] = new e(Double.parseDouble(localObject3[0]), Double.parseDouble(localObject3[1]));
            i += 1;
          }
          this.bAE[j].put(paramString2, c.b((e[])localObject2, this.bAG));
          break;
        case 12: 
          label781:
          label881:
          localObject1 = paramString1.split(",", -1);
          localObject2 = new double[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Double.parseDouble(localObject1[i]);
            i += 1;
          }
          this.bAE[j].put(paramString2, c.b((double[])localObject2, this.bAG));
        }
      }
    }
    AppMethodBeat.o(178719);
  }
  
  static class a
    extends InputStream
    implements DataInput
  {
    private static final ByteOrder bAX = ByteOrder.LITTLE_ENDIAN;
    private static final ByteOrder bAY = ByteOrder.BIG_ENDIAN;
    ByteOrder NZ;
    final DataInputStream bAZ;
    private byte[] bBa;
    int mPosition;
    
    a(InputStream paramInputStream)
    {
      this(paramInputStream, ByteOrder.BIG_ENDIAN);
      AppMethodBeat.i(178669);
      AppMethodBeat.o(178669);
    }
    
    a(InputStream paramInputStream, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(192850);
      this.NZ = ByteOrder.BIG_ENDIAN;
      this.bAZ = new DataInputStream(paramInputStream);
      this.bAZ.mark(0);
      this.mPosition = 0;
      this.NZ = paramByteOrder;
      AppMethodBeat.o(192850);
    }
    
    a(byte[] paramArrayOfByte)
    {
      this(new ByteArrayInputStream(paramArrayOfByte), ByteOrder.BIG_ENDIAN);
      AppMethodBeat.i(178670);
      AppMethodBeat.o(178670);
    }
    
    public final long FT()
    {
      AppMethodBeat.i(178686);
      long l = readInt();
      AppMethodBeat.o(178686);
      return l & 0xFFFFFFFF;
    }
    
    public int available()
    {
      AppMethodBeat.i(178672);
      int i = this.bAZ.available();
      AppMethodBeat.o(178672);
      return i;
    }
    
    public final void eP(int paramInt)
    {
      AppMethodBeat.i(192964);
      int j;
      for (int i = 0; i < paramInt; i = j + i)
      {
        int k = (int)this.bAZ.skip(paramInt - i);
        j = k;
        if (k <= 0)
        {
          if (this.bBa == null) {
            this.bBa = new byte[8192];
          }
          j = Math.min(8192, paramInt - i);
          k = this.bAZ.read(this.bBa, 0, j);
          j = k;
          if (k == -1)
          {
            EOFException localEOFException = new EOFException("Reached EOF while skipping " + paramInt + " bytes.");
            AppMethodBeat.o(192964);
            throw localEOFException;
          }
        }
      }
      this.mPosition += i;
      AppMethodBeat.o(192964);
    }
    
    public void mark(int paramInt)
    {
      AppMethodBeat.i(193009);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Mark is currently unsupported");
      AppMethodBeat.o(193009);
      throw localUnsupportedOperationException;
    }
    
    public int read()
    {
      AppMethodBeat.i(178673);
      this.mPosition += 1;
      int i = this.bAZ.read();
      AppMethodBeat.o(178673);
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(178674);
      paramInt1 = this.bAZ.read(paramArrayOfByte, paramInt1, paramInt2);
      this.mPosition += paramInt1;
      AppMethodBeat.o(178674);
      return paramInt1;
    }
    
    public boolean readBoolean()
    {
      AppMethodBeat.i(178676);
      this.mPosition += 1;
      boolean bool = this.bAZ.readBoolean();
      AppMethodBeat.o(178676);
      return bool;
    }
    
    public byte readByte()
    {
      AppMethodBeat.i(178681);
      this.mPosition += 1;
      int i = this.bAZ.read();
      if (i < 0)
      {
        EOFException localEOFException = new EOFException();
        AppMethodBeat.o(178681);
        throw localEOFException;
      }
      byte b = (byte)i;
      AppMethodBeat.o(178681);
      return b;
    }
    
    public char readChar()
    {
      AppMethodBeat.i(178677);
      this.mPosition += 2;
      char c = this.bAZ.readChar();
      AppMethodBeat.o(178677);
      return c;
    }
    
    public double readDouble()
    {
      AppMethodBeat.i(178689);
      double d = Double.longBitsToDouble(readLong());
      AppMethodBeat.o(178689);
      return d;
    }
    
    public float readFloat()
    {
      AppMethodBeat.i(178688);
      float f = Float.intBitsToFloat(readInt());
      AppMethodBeat.o(178688);
      return f;
    }
    
    public void readFully(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(178680);
      this.mPosition += paramArrayOfByte.length;
      this.bAZ.readFully(paramArrayOfByte);
      AppMethodBeat.o(178680);
    }
    
    public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(178679);
      this.mPosition += paramInt2;
      this.bAZ.readFully(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(178679);
    }
    
    public int readInt()
    {
      AppMethodBeat.i(178683);
      this.mPosition += 4;
      int i = this.bAZ.read();
      int j = this.bAZ.read();
      int k = this.bAZ.read();
      int m = this.bAZ.read();
      if ((i | j | k | m) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178683);
        throw ((Throwable)localObject);
      }
      if (this.NZ == bAX)
      {
        AppMethodBeat.o(178683);
        return i + ((j << 8) + ((k << 16) + (m << 24)));
      }
      if (this.NZ == bAY)
      {
        AppMethodBeat.o(178683);
        return (i << 24) + (j << 16) + (k << 8) + m;
      }
      Object localObject = new IOException("Invalid byte order: " + this.NZ);
      AppMethodBeat.o(178683);
      throw ((Throwable)localObject);
    }
    
    public String readLine()
    {
      return null;
    }
    
    public long readLong()
    {
      AppMethodBeat.i(178687);
      this.mPosition += 8;
      int i = this.bAZ.read();
      int j = this.bAZ.read();
      int k = this.bAZ.read();
      int m = this.bAZ.read();
      int n = this.bAZ.read();
      int i1 = this.bAZ.read();
      int i2 = this.bAZ.read();
      int i3 = this.bAZ.read();
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
      if (this.NZ == bAX)
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
      if (this.NZ == bAY)
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
      Object localObject = new IOException("Invalid byte order: " + this.NZ);
      AppMethodBeat.o(178687);
      throw ((Throwable)localObject);
    }
    
    public short readShort()
    {
      AppMethodBeat.i(178682);
      this.mPosition += 2;
      int i = this.bAZ.read();
      int j = this.bAZ.read();
      if ((i | j) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178682);
        throw ((Throwable)localObject);
      }
      short s;
      if (this.NZ == bAX)
      {
        s = (short)(i + (j << 8));
        AppMethodBeat.o(178682);
        return s;
      }
      if (this.NZ == bAY)
      {
        s = (short)((i << 8) + j);
        AppMethodBeat.o(178682);
        return s;
      }
      Object localObject = new IOException("Invalid byte order: " + this.NZ);
      AppMethodBeat.o(178682);
      throw ((Throwable)localObject);
    }
    
    public String readUTF()
    {
      AppMethodBeat.i(178678);
      this.mPosition += 2;
      String str = this.bAZ.readUTF();
      AppMethodBeat.o(178678);
      return str;
    }
    
    public int readUnsignedByte()
    {
      AppMethodBeat.i(178675);
      this.mPosition += 1;
      int i = this.bAZ.readUnsignedByte();
      AppMethodBeat.o(178675);
      return i;
    }
    
    public int readUnsignedShort()
    {
      AppMethodBeat.i(178685);
      this.mPosition += 2;
      int i = this.bAZ.read();
      int j = this.bAZ.read();
      if ((i | j) < 0)
      {
        localObject = new EOFException();
        AppMethodBeat.o(178685);
        throw ((Throwable)localObject);
      }
      if (this.NZ == bAX)
      {
        AppMethodBeat.o(178685);
        return i + (j << 8);
      }
      if (this.NZ == bAY)
      {
        AppMethodBeat.o(178685);
        return (i << 8) + j;
      }
      Object localObject = new IOException("Invalid byte order: " + this.NZ);
      AppMethodBeat.o(178685);
      throw ((Throwable)localObject);
    }
    
    public void reset()
    {
      AppMethodBeat.i(193036);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Reset is currently unsupported");
      AppMethodBeat.o(193036);
      throw localUnsupportedOperationException;
    }
    
    public int skipBytes(int paramInt)
    {
      AppMethodBeat.i(178684);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("skipBytes is currently unsupported");
      AppMethodBeat.o(178684);
      throw localUnsupportedOperationException;
    }
  }
  
  static final class b
    extends FilterOutputStream
  {
    final OutputStream NY;
    ByteOrder NZ;
    
    public b(OutputStream paramOutputStream, ByteOrder paramByteOrder)
    {
      super();
      this.NY = paramOutputStream;
      this.NZ = paramByteOrder;
    }
    
    public final void aX(int paramInt)
    {
      AppMethodBeat.i(178694);
      if (this.NZ == ByteOrder.LITTLE_ENDIAN)
      {
        this.NY.write(paramInt >>> 0 & 0xFF);
        this.NY.write(paramInt >>> 8 & 0xFF);
        this.NY.write(paramInt >>> 16 & 0xFF);
        this.NY.write(paramInt >>> 24 & 0xFF);
        AppMethodBeat.o(178694);
        return;
      }
      if (this.NZ == ByteOrder.BIG_ENDIAN)
      {
        this.NY.write(paramInt >>> 24 & 0xFF);
        this.NY.write(paramInt >>> 16 & 0xFF);
        this.NY.write(paramInt >>> 8 & 0xFF);
        this.NY.write(paramInt >>> 0 & 0xFF);
      }
      AppMethodBeat.o(178694);
    }
    
    public final void b(short paramShort)
    {
      AppMethodBeat.i(178693);
      if (this.NZ == ByteOrder.LITTLE_ENDIAN)
      {
        this.NY.write(paramShort >>> 0 & 0xFF);
        this.NY.write(paramShort >>> 8 & 0xFF);
        AppMethodBeat.o(178693);
        return;
      }
      if (this.NZ == ByteOrder.BIG_ENDIAN)
      {
        this.NY.write(paramShort >>> 8 & 0xFF);
        this.NY.write(paramShort >>> 0 & 0xFF);
      }
      AppMethodBeat.o(178693);
    }
    
    public final void eQ(int paramInt)
    {
      AppMethodBeat.i(178692);
      this.NY.write(paramInt);
      AppMethodBeat.o(178692);
    }
    
    public final void write(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(178690);
      this.NY.write(paramArrayOfByte);
      AppMethodBeat.o(178690);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(178691);
      this.NY.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(178691);
    }
  }
  
  static final class c
  {
    public final int On;
    public final long Oo;
    public final byte[] Op;
    public final int format;
    
    c(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
    {
      this.format = paramInt1;
      this.On = paramInt2;
      this.Oo = paramLong;
      this.Op = paramArrayOfByte;
    }
    
    c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this(paramInt1, paramInt2, -1L, paramArrayOfByte);
    }
    
    public static c a(int paramInt, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178696);
      paramByteOrder = c(new int[] { paramInt }, paramByteOrder);
      AppMethodBeat.o(178696);
      return paramByteOrder;
    }
    
    public static c a(a.e parame, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178702);
      parame = a(new a.e[] { parame }, paramByteOrder);
      AppMethodBeat.o(178702);
      return parame;
    }
    
    public static c a(a.e[] paramArrayOfe, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178701);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.Ol[5] * paramArrayOfe.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfe.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOfe[i];
        localByteBuffer.putInt((int)paramByteOrder.bBb);
        localByteBuffer.putInt((int)paramByteOrder.bBc);
        i += 1;
      }
      paramArrayOfe = new c(5, paramArrayOfe.length, localByteBuffer.array());
      AppMethodBeat.o(178701);
      return paramArrayOfe;
    }
    
    public static c aE(String paramString)
    {
      AppMethodBeat.i(178700);
      paramString = (paramString + '\000').getBytes(a.Oj);
      paramString = new c(2, paramString.length, paramString);
      AppMethodBeat.o(178700);
      return paramString;
    }
    
    public static c b(long paramLong, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178698);
      paramByteOrder = b(new long[] { paramLong }, paramByteOrder);
      AppMethodBeat.o(178698);
      return paramByteOrder;
    }
    
    public static c b(double[] paramArrayOfDouble, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178704);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.Ol[12] * paramArrayOfDouble.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfDouble.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putDouble(paramArrayOfDouble[i]);
        i += 1;
      }
      paramArrayOfDouble = new c(12, paramArrayOfDouble.length, localByteBuffer.array());
      AppMethodBeat.o(178704);
      return paramArrayOfDouble;
    }
    
    public static c b(long[] paramArrayOfLong, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178697);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.Ol[4] * paramArrayOfLong.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putInt((int)paramArrayOfLong[i]);
        i += 1;
      }
      paramArrayOfLong = new c(4, paramArrayOfLong.length, localByteBuffer.array());
      AppMethodBeat.o(178697);
      return paramArrayOfLong;
    }
    
    public static c b(a.e[] paramArrayOfe, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178703);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.Ol[10] * paramArrayOfe.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfe.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOfe[i];
        localByteBuffer.putInt((int)paramByteOrder.bBb);
        localByteBuffer.putInt((int)paramByteOrder.bBc);
        i += 1;
      }
      paramArrayOfe = new c(10, paramArrayOfe.length, localByteBuffer.array());
      AppMethodBeat.o(178703);
      return paramArrayOfe;
    }
    
    public static c c(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178695);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.Ol[3] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putShort((short)paramArrayOfInt[i]);
        i += 1;
      }
      paramArrayOfInt = new c(3, paramArrayOfInt.length, localByteBuffer.array());
      AppMethodBeat.o(178695);
      return paramArrayOfInt;
    }
    
    public static c d(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(178699);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.Ol[9] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.putInt(paramArrayOfInt[i]);
        i += 1;
      }
      paramArrayOfInt = new c(9, paramArrayOfInt.length, localByteBuffer.array());
      AppMethodBeat.o(178699);
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
      //   25: ldc 138
      //   27: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   30: new 140	androidx/f/a/a$a
      //   33: dup
      //   34: aload_0
      //   35: getfield 27	androidx/f/a/a$c:Op	[B
      //   38: invokespecial 143	androidx/f/a/a$a:<init>	([B)V
      //   41: astore 12
      //   43: aload 12
      //   45: aload_1
      //   46: putfield 147	androidx/f/a/a$a:NZ	Ljava/nio/ByteOrder;
      //   49: aload_0
      //   50: getfield 21	androidx/f/a/a$c:format	I
      //   53: istore 11
      //   55: iload 11
      //   57: tableswitch	default:+63 -> 120, 1:+75->132, 2:+166->223, 3:+303->360, 4:+345->402, 5:+389->446, 6:+75->132, 7:+166->223, 8:+447->504, 9:+492->549, 10:+537->594, 11:+597->654, 12:+643->700
      //   121: fconst_1
      //   122: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   125: ldc 138
      //   127: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aconst_null
      //   131: areturn
      //   132: aload_0
      //   133: getfield 27	androidx/f/a/a$c:Op	[B
      //   136: arraylength
      //   137: iconst_1
      //   138: if_icmpne +58 -> 196
      //   141: aload_0
      //   142: getfield 27	androidx/f/a/a$c:Op	[B
      //   145: iconst_0
      //   146: baload
      //   147: iflt +49 -> 196
      //   150: aload_0
      //   151: getfield 27	androidx/f/a/a$c:Op	[B
      //   154: iconst_0
      //   155: baload
      //   156: iconst_1
      //   157: if_icmpgt +39 -> 196
      //   160: new 109	java/lang/String
      //   163: dup
      //   164: iconst_1
      //   165: newarray char
      //   167: dup
      //   168: iconst_0
      //   169: aload_0
      //   170: getfield 27	androidx/f/a/a$c:Op	[B
      //   173: iconst_0
      //   174: baload
      //   175: bipush 48
      //   177: iadd
      //   178: i2c
      //   179: castore
      //   180: invokespecial 153	java/lang/String:<init>	([C)V
      //   183: astore_1
      //   184: aload 12
      //   186: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   189: ldc 138
      //   191: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   194: aload_1
      //   195: areturn
      //   196: new 109	java/lang/String
      //   199: dup
      //   200: aload_0
      //   201: getfield 27	androidx/f/a/a$c:Op	[B
      //   204: getstatic 107	androidx/f/a/a:Oj	Ljava/nio/charset/Charset;
      //   207: invokespecial 156	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   210: astore_1
      //   211: aload 12
      //   213: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   216: ldc 138
      //   218: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: aload_1
      //   222: areturn
      //   223: aload_0
      //   224: getfield 23	androidx/f/a/a$c:On	I
      //   227: getstatic 159	androidx/f/a/a:Om	[B
      //   230: arraylength
      //   231: if_icmplt +614 -> 845
      //   234: iconst_0
      //   235: istore_2
      //   236: iload 4
      //   238: istore_3
      //   239: iload_2
      //   240: getstatic 159	androidx/f/a/a:Om	[B
      //   243: arraylength
      //   244: if_icmpge +19 -> 263
      //   247: aload_0
      //   248: getfield 27	androidx/f/a/a$c:Op	[B
      //   251: iload_2
      //   252: baload
      //   253: getstatic 159	androidx/f/a/a:Om	[B
      //   256: iload_2
      //   257: baload
      //   258: if_icmpeq +599 -> 857
      //   261: iconst_0
      //   262: istore_3
      //   263: iload_3
      //   264: ifeq +581 -> 845
      //   267: getstatic 159	androidx/f/a/a:Om	[B
      //   270: arraylength
      //   271: istore_2
      //   272: new 91	java/lang/StringBuilder
      //   275: dup
      //   276: invokespecial 92	java/lang/StringBuilder:<init>	()V
      //   279: astore_1
      //   280: iload_2
      //   281: aload_0
      //   282: getfield 23	androidx/f/a/a$c:On	I
      //   285: if_icmpge +58 -> 343
      //   288: aload_0
      //   289: getfield 27	androidx/f/a/a$c:Op	[B
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
      //   308: invokevirtual 99	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   311: pop
      //   312: goto +538 -> 850
      //   315: aload_1
      //   316: bipush 63
      //   318: invokevirtual 99	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   321: pop
      //   322: goto +528 -> 850
      //   325: astore_1
      //   326: aload 12
      //   328: ifnull +8 -> 336
      //   331: aload 12
      //   333: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   336: ldc 138
      //   338: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   341: aconst_null
      //   342: areturn
      //   343: aload_1
      //   344: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   347: astore_1
      //   348: aload 12
      //   350: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   353: ldc 138
      //   355: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   358: aload_1
      //   359: areturn
      //   360: aload_0
      //   361: getfield 23	androidx/f/a/a$c:On	I
      //   364: newarray int
      //   366: astore_1
      //   367: iload_2
      //   368: aload_0
      //   369: getfield 23	androidx/f/a/a$c:On	I
      //   372: if_icmpge +18 -> 390
      //   375: aload_1
      //   376: iload_2
      //   377: aload 12
      //   379: invokevirtual 163	androidx/f/a/a$a:readUnsignedShort	()I
      //   382: iastore
      //   383: iload_2
      //   384: iconst_1
      //   385: iadd
      //   386: istore_2
      //   387: goto -20 -> 367
      //   390: aload 12
      //   392: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   395: ldc 138
      //   397: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   400: aload_1
      //   401: areturn
      //   402: aload_0
      //   403: getfield 23	androidx/f/a/a$c:On	I
      //   406: newarray long
      //   408: astore_1
      //   409: iload_3
      //   410: istore_2
      //   411: iload_2
      //   412: aload_0
      //   413: getfield 23	androidx/f/a/a$c:On	I
      //   416: if_icmpge +18 -> 434
      //   419: aload_1
      //   420: iload_2
      //   421: aload 12
      //   423: invokevirtual 167	androidx/f/a/a$a:FT	()J
      //   426: lastore
      //   427: iload_2
      //   428: iconst_1
      //   429: iadd
      //   430: istore_2
      //   431: goto -20 -> 411
      //   434: aload 12
      //   436: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   439: ldc 138
      //   441: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   444: aload_1
      //   445: areturn
      //   446: aload_0
      //   447: getfield 23	androidx/f/a/a$c:On	I
      //   450: anewarray 52	androidx/f/a/a$e
      //   453: astore_1
      //   454: iload 5
      //   456: istore_2
      //   457: iload_2
      //   458: aload_0
      //   459: getfield 23	androidx/f/a/a$c:On	I
      //   462: if_icmpge +30 -> 492
      //   465: aload_1
      //   466: iload_2
      //   467: new 52	androidx/f/a/a$e
      //   470: dup
      //   471: aload 12
      //   473: invokevirtual 167	androidx/f/a/a$a:FT	()J
      //   476: aload 12
      //   478: invokevirtual 167	androidx/f/a/a$a:FT	()J
      //   481: invokespecial 170	androidx/f/a/a$e:<init>	(JJ)V
      //   484: aastore
      //   485: iload_2
      //   486: iconst_1
      //   487: iadd
      //   488: istore_2
      //   489: goto -32 -> 457
      //   492: aload 12
      //   494: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   497: ldc 138
      //   499: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   502: aload_1
      //   503: areturn
      //   504: aload_0
      //   505: getfield 23	androidx/f/a/a$c:On	I
      //   508: newarray int
      //   510: astore_1
      //   511: iload 6
      //   513: istore_2
      //   514: iload_2
      //   515: aload_0
      //   516: getfield 23	androidx/f/a/a$c:On	I
      //   519: if_icmpge +18 -> 537
      //   522: aload_1
      //   523: iload_2
      //   524: aload 12
      //   526: invokevirtual 174	androidx/f/a/a$a:readShort	()S
      //   529: iastore
      //   530: iload_2
      //   531: iconst_1
      //   532: iadd
      //   533: istore_2
      //   534: goto -20 -> 514
      //   537: aload 12
      //   539: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   542: ldc 138
      //   544: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   547: aload_1
      //   548: areturn
      //   549: aload_0
      //   550: getfield 23	androidx/f/a/a$c:On	I
      //   553: newarray int
      //   555: astore_1
      //   556: iload 7
      //   558: istore_2
      //   559: iload_2
      //   560: aload_0
      //   561: getfield 23	androidx/f/a/a$c:On	I
      //   564: if_icmpge +18 -> 582
      //   567: aload_1
      //   568: iload_2
      //   569: aload 12
      //   571: invokevirtual 177	androidx/f/a/a$a:readInt	()I
      //   574: iastore
      //   575: iload_2
      //   576: iconst_1
      //   577: iadd
      //   578: istore_2
      //   579: goto -20 -> 559
      //   582: aload 12
      //   584: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   587: ldc 138
      //   589: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   592: aload_1
      //   593: areturn
      //   594: aload_0
      //   595: getfield 23	androidx/f/a/a$c:On	I
      //   598: anewarray 52	androidx/f/a/a$e
      //   601: astore_1
      //   602: iload 8
      //   604: istore_2
      //   605: iload_2
      //   606: aload_0
      //   607: getfield 23	androidx/f/a/a$c:On	I
      //   610: if_icmpge +32 -> 642
      //   613: aload_1
      //   614: iload_2
      //   615: new 52	androidx/f/a/a$e
      //   618: dup
      //   619: aload 12
      //   621: invokevirtual 177	androidx/f/a/a$a:readInt	()I
      //   624: i2l
      //   625: aload 12
      //   627: invokevirtual 177	androidx/f/a/a$a:readInt	()I
      //   630: i2l
      //   631: invokespecial 170	androidx/f/a/a$e:<init>	(JJ)V
      //   634: aastore
      //   635: iload_2
      //   636: iconst_1
      //   637: iadd
      //   638: istore_2
      //   639: goto -34 -> 605
      //   642: aload 12
      //   644: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   647: ldc 138
      //   649: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   652: aload_1
      //   653: areturn
      //   654: aload_0
      //   655: getfield 23	androidx/f/a/a$c:On	I
      //   658: newarray double
      //   660: astore_1
      //   661: iload 9
      //   663: istore_2
      //   664: iload_2
      //   665: aload_0
      //   666: getfield 23	androidx/f/a/a$c:On	I
      //   669: if_icmpge +19 -> 688
      //   672: aload_1
      //   673: iload_2
      //   674: aload 12
      //   676: invokevirtual 181	androidx/f/a/a$a:readFloat	()F
      //   679: f2d
      //   680: dastore
      //   681: iload_2
      //   682: iconst_1
      //   683: iadd
      //   684: istore_2
      //   685: goto -21 -> 664
      //   688: aload 12
      //   690: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   693: ldc 138
      //   695: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   698: aload_1
      //   699: areturn
      //   700: aload_0
      //   701: getfield 23	androidx/f/a/a$c:On	I
      //   704: newarray double
      //   706: astore_1
      //   707: iload 10
      //   709: istore_2
      //   710: iload_2
      //   711: aload_0
      //   712: getfield 23	androidx/f/a/a$c:On	I
      //   715: if_icmpge +18 -> 733
      //   718: aload_1
      //   719: iload_2
      //   720: aload 12
      //   722: invokevirtual 185	androidx/f/a/a$a:readDouble	()D
      //   725: dastore
      //   726: iload_2
      //   727: iconst_1
      //   728: iadd
      //   729: istore_2
      //   730: goto -20 -> 710
      //   733: aload 12
      //   735: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   738: ldc 138
      //   740: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   743: aload_1
      //   744: areturn
      //   745: astore_1
      //   746: aconst_null
      //   747: astore 12
      //   749: aload 12
      //   751: ifnull +8 -> 759
      //   754: aload 12
      //   756: invokevirtual 150	androidx/f/a/a$a:close	()V
      //   759: ldc 138
      //   761: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final double b(ByteOrder paramByteOrder)
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
          d = paramByteOrder[0].FU();
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
    
    public final int c(ByteOrder paramByteOrder)
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
    
    public final String d(ByteOrder paramByteOrder)
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
          paramByteOrder.append(localObject[i].bBb);
          paramByteOrder.append('/');
          paramByteOrder.append(localObject[i].bBc);
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
    
    public final int size()
    {
      return a.Ol[this.format] * this.On;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(178705);
      String str = "(" + a.Ok[this.format] + ", data length:" + this.Op.length + ")";
      AppMethodBeat.o(178705);
      return str;
    }
  }
  
  static class d
  {
    public final int OU;
    public final int OV;
    public final String name;
    public final int number;
    
    d(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.number = paramInt1;
      this.OU = paramInt2;
      this.OV = -1;
    }
    
    d(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      this.name = paramString;
      this.number = paramInt1;
      this.OU = paramInt2;
      this.OV = paramInt3;
    }
    
    final boolean eR(int paramInt)
    {
      if ((this.OU == 7) || (paramInt == 7)) {}
      while ((this.OU == paramInt) || (this.OV == paramInt) || (((this.OU == 4) || (this.OV == 4)) && ((paramInt == 3) || (((this.OU == 9) || (this.OV == 9)) && ((paramInt == 8) || (((this.OU == 12) || (this.OV == 12)) && (paramInt == 11))))))) {
        return true;
      }
      return false;
    }
  }
  
  static final class e
  {
    public final long bBb;
    public final long bBc;
    
    e(double paramDouble)
    {
      this((10000.0D * paramDouble), 10000L);
      AppMethodBeat.i(178710);
      AppMethodBeat.o(178710);
    }
    
    e(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(178711);
      if (paramLong2 == 0L)
      {
        this.bBb = 0L;
        this.bBc = 1L;
        AppMethodBeat.o(178711);
        return;
      }
      this.bBb = paramLong1;
      this.bBc = paramLong2;
      AppMethodBeat.o(178711);
    }
    
    public final double FU()
    {
      return this.bBb / this.bBc;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(178712);
      String str = this.bBb + "/" + this.bBc;
      AppMethodBeat.o(178712);
      return str;
    }
  }
  
  static final class f
    extends a.a
  {
    f(InputStream paramInputStream)
    {
      super();
      AppMethodBeat.i(192853);
      if (!paramInputStream.markSupported())
      {
        paramInputStream = new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        AppMethodBeat.o(192853);
        throw paramInputStream;
      }
      this.bAZ.mark(2147483647);
      AppMethodBeat.o(192853);
    }
    
    f(byte[] paramArrayOfByte)
    {
      super();
      AppMethodBeat.i(192846);
      this.bAZ.mark(2147483647);
      AppMethodBeat.o(192846);
    }
    
    public final void seek(long paramLong)
    {
      AppMethodBeat.i(192859);
      if (this.mPosition > paramLong)
      {
        this.mPosition = 0;
        this.bAZ.reset();
      }
      for (;;)
      {
        eP((int)paramLong);
        AppMethodBeat.o(192859);
        return;
        paramLong -= this.mPosition;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.f.a.a
 * JD-Core Version:    0.7.0.1
 */