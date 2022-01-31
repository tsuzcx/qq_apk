package android.support.d;

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
  private static final List<Integer> oV = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8) });
  private static final List<Integer> oW = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5) });
  public static final int[] oX = { 8, 8, 8 };
  public static final int[] oY = { 4 };
  public static final int[] oZ = { 8 };
  static final byte[] pA;
  private static final Pattern pQ = Pattern.compile(".*[1-9].*");
  private static final Pattern pR = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
  static final byte[] pa = { -1, -40, -1 };
  private static final byte[] pb = { 79, 76, 89, 77, 80, 0 };
  private static final byte[] pc = { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
  private static SimpleDateFormat pd;
  static final String[] pe = { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE" };
  static final int[] pg = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
  private static final byte[] ph = { 65, 83, 67, 73, 73, 0, 0, 0 };
  private static final d[] pi = { new d("NewSubfileType", 254, 4, 0), new d("SubfileType", 255, 4, 0), new d("ImageWidth", 256, 0), new d("ImageLength", 257, 0), new d("BitsPerSample", 258, 3, 0), new d("Compression", 259, 3, 0), new d("PhotometricInterpretation", 262, 3, 0), new d("ImageDescription", 270, 2, 0), new d("Make", 271, 2, 0), new d("Model", 272, 2, 0), new d("StripOffsets", 273, 0), new d("Orientation", 274, 3, 0), new d("SamplesPerPixel", 277, 3, 0), new d("RowsPerStrip", 278, 0), new d("StripByteCounts", 279, 0), new d("XResolution", 282, 5, 0), new d("YResolution", 283, 5, 0), new d("PlanarConfiguration", 284, 3, 0), new d("ResolutionUnit", 296, 3, 0), new d("TransferFunction", 301, 3, 0), new d("Software", 305, 2, 0), new d("DateTime", 306, 2, 0), new d("Artist", 315, 2, 0), new d("WhitePoint", 318, 5, 0), new d("PrimaryChromaticities", 319, 5, 0), new d("SubIFDPointer", 330, 4, 0), new d("JPEGInterchangeFormat", 513, 4, 0), new d("JPEGInterchangeFormatLength", 514, 4, 0), new d("YCbCrCoefficients", 529, 5, 0), new d("YCbCrSubSampling", 530, 3, 0), new d("YCbCrPositioning", 531, 3, 0), new d("ReferenceBlackWhite", 532, 5, 0), new d("Copyright", 33432, 2, 0), new d("ExifIFDPointer", 34665, 4, 0), new d("GPSInfoIFDPointer", 34853, 4, 0), new d("SensorTopBorder", 4, 4, 0), new d("SensorLeftBorder", 5, 4, 0), new d("SensorBottomBorder", 6, 4, 0), new d("SensorRightBorder", 7, 4, 0), new d("ISO", 23, 3, 0), new d("JpgFromRaw", 46, 7, 0) };
  private static final d[] pj = { new d("ExposureTime", 33434, 5, 0), new d("FNumber", 33437, 5, 0), new d("ExposureProgram", 34850, 3, 0), new d("SpectralSensitivity", 34852, 2, 0), new d("PhotographicSensitivity", 34855, 3, 0), new d("OECF", 34856, 7, 0), new d("ExifVersion", 36864, 2, 0), new d("DateTimeOriginal", 36867, 2, 0), new d("DateTimeDigitized", 36868, 2, 0), new d("ComponentsConfiguration", 37121, 7, 0), new d("CompressedBitsPerPixel", 37122, 5, 0), new d("ShutterSpeedValue", 37377, 10, 0), new d("ApertureValue", 37378, 5, 0), new d("BrightnessValue", 37379, 10, 0), new d("ExposureBiasValue", 37380, 10, 0), new d("MaxApertureValue", 37381, 5, 0), new d("SubjectDistance", 37382, 5, 0), new d("MeteringMode", 37383, 3, 0), new d("LightSource", 37384, 3, 0), new d("Flash", 37385, 3, 0), new d("FocalLength", 37386, 5, 0), new d("SubjectArea", 37396, 3, 0), new d("MakerNote", 37500, 7, 0), new d("UserComment", 37510, 7, 0), new d("SubSecTime", 37520, 2, 0), new d("SubSecTimeOriginal", 37521, 2, 0), new d("SubSecTimeDigitized", 37522, 2, 0), new d("FlashpixVersion", 40960, 7, 0), new d("ColorSpace", 40961, 3, 0), new d("PixelXDimension", 40962, 0), new d("PixelYDimension", 40963, 0), new d("RelatedSoundFile", 40964, 2, 0), new d("InteroperabilityIFDPointer", 40965, 4, 0), new d("FlashEnergy", 41483, 5, 0), new d("SpatialFrequencyResponse", 41484, 7, 0), new d("FocalPlaneXResolution", 41486, 5, 0), new d("FocalPlaneYResolution", 41487, 5, 0), new d("FocalPlaneResolutionUnit", 41488, 3, 0), new d("SubjectLocation", 41492, 3, 0), new d("ExposureIndex", 41493, 5, 0), new d("SensingMethod", 41495, 3, 0), new d("FileSource", 41728, 7, 0), new d("SceneType", 41729, 7, 0), new d("CFAPattern", 41730, 7, 0), new d("CustomRendered", 41985, 3, 0), new d("ExposureMode", 41986, 3, 0), new d("WhiteBalance", 41987, 3, 0), new d("DigitalZoomRatio", 41988, 5, 0), new d("FocalLengthIn35mmFilm", 41989, 3, 0), new d("SceneCaptureType", 41990, 3, 0), new d("GainControl", 41991, 3, 0), new d("Contrast", 41992, 3, 0), new d("Saturation", 41993, 3, 0), new d("Sharpness", 41994, 3, 0), new d("DeviceSettingDescription", 41995, 7, 0), new d("SubjectDistanceRange", 41996, 3, 0), new d("ImageUniqueID", 42016, 2, 0), new d("DNGVersion", 50706, 1, 0), new d("DefaultCropSize", 50720, 0) };
  private static final d[] pk = { new d("GPSVersionID", 0, 1, 0), new d("GPSLatitudeRef", 1, 2, 0), new d("GPSLatitude", 2, 5, 0), new d("GPSLongitudeRef", 3, 2, 0), new d("GPSLongitude", 4, 5, 0), new d("GPSAltitudeRef", 5, 1, 0), new d("GPSAltitude", 6, 5, 0), new d("GPSTimeStamp", 7, 5, 0), new d("GPSSatellites", 8, 2, 0), new d("GPSStatus", 9, 2, 0), new d("GPSMeasureMode", 10, 2, 0), new d("GPSDOP", 11, 5, 0), new d("GPSSpeedRef", 12, 2, 0), new d("GPSSpeed", 13, 5, 0), new d("GPSTrackRef", 14, 2, 0), new d("GPSTrack", 15, 5, 0), new d("GPSImgDirectionRef", 16, 2, 0), new d("GPSImgDirection", 17, 5, 0), new d("GPSMapDatum", 18, 2, 0), new d("GPSDestLatitudeRef", 19, 2, 0), new d("GPSDestLatitude", 20, 5, 0), new d("GPSDestLongitudeRef", 21, 2, 0), new d("GPSDestLongitude", 22, 5, 0), new d("GPSDestBearingRef", 23, 2, 0), new d("GPSDestBearing", 24, 5, 0), new d("GPSDestDistanceRef", 25, 2, 0), new d("GPSDestDistance", 26, 5, 0), new d("GPSProcessingMethod", 27, 7, 0), new d("GPSAreaInformation", 28, 7, 0), new d("GPSDateStamp", 29, 2, 0), new d("GPSDifferential", 30, 3, 0) };
  private static final d[] pl = { new d("InteroperabilityIndex", 1, 2, 0) };
  private static final d[] pm = { new d("NewSubfileType", 254, 4, 0), new d("SubfileType", 255, 4, 0), new d("ThumbnailImageWidth", 256, 0), new d("ThumbnailImageLength", 257, 0), new d("BitsPerSample", 258, 3, 0), new d("Compression", 259, 3, 0), new d("PhotometricInterpretation", 262, 3, 0), new d("ImageDescription", 270, 2, 0), new d("Make", 271, 2, 0), new d("Model", 272, 2, 0), new d("StripOffsets", 273, 0), new d("Orientation", 274, 3, 0), new d("SamplesPerPixel", 277, 3, 0), new d("RowsPerStrip", 278, 0), new d("StripByteCounts", 279, 0), new d("XResolution", 282, 5, 0), new d("YResolution", 283, 5, 0), new d("PlanarConfiguration", 284, 3, 0), new d("ResolutionUnit", 296, 3, 0), new d("TransferFunction", 301, 3, 0), new d("Software", 305, 2, 0), new d("DateTime", 306, 2, 0), new d("Artist", 315, 2, 0), new d("WhitePoint", 318, 5, 0), new d("PrimaryChromaticities", 319, 5, 0), new d("SubIFDPointer", 330, 4, 0), new d("JPEGInterchangeFormat", 513, 4, 0), new d("JPEGInterchangeFormatLength", 514, 4, 0), new d("YCbCrCoefficients", 529, 5, 0), new d("YCbCrSubSampling", 530, 3, 0), new d("YCbCrPositioning", 531, 3, 0), new d("ReferenceBlackWhite", 532, 5, 0), new d("Copyright", 33432, 2, 0), new d("ExifIFDPointer", 34665, 4, 0), new d("GPSInfoIFDPointer", 34853, 4, 0), new d("DNGVersion", 50706, 1, 0), new d("DefaultCropSize", 50720, 0) };
  private static final d[] pn;
  private static final d[] po;
  private static final d[] pp;
  private static final d[] pq;
  static final d[][] pr;
  private static final d[] ps;
  private static final d pt;
  private static final d pu;
  private static final HashMap<Integer, d>[] pv;
  private static final HashMap<String, d>[] pw;
  private static final HashSet<String> px;
  private static final HashMap<Integer, Integer> py;
  private static final Charset pz;
  private final String mFilename;
  private final AssetManager.AssetInputStream pB;
  private int pC;
  private final HashMap<String, c>[] pD = new HashMap[pr.length];
  private ByteOrder pE = ByteOrder.BIG_ENDIAN;
  private boolean pF;
  private int pG;
  private int pH;
  private byte[] pI;
  private int pJ;
  private int pK;
  private int pL;
  private int pM;
  private int pN;
  private int pO;
  private boolean pP;
  
  static
  {
    TAG_RAF_IMAGE_SIZE = new d("StripOffsets", 273, 3, (byte)0);
    pn = new d[] { new d("ThumbnailImage", 256, 7, 0), new d("CameraSettingsIFDPointer", 8224, 4, 0), new d("ImageProcessingIFDPointer", 8256, 4, 0) };
    po = new d[] { new d("PreviewImageStart", 257, 4, 0), new d("PreviewImageLength", 258, 4, 0) };
    pp = new d[] { new d("AspectFrame", 4371, 3, 0) };
    pq = new d[] { new d("ColorSpace", 55, 3, 0) };
    pr = new d[][] { pi, pj, pk, pl, pm, pi, pn, po, pp, pq };
    ps = new d[] { new d("SubIFDPointer", 330, 4, 0), new d("ExifIFDPointer", 34665, 4, 0), new d("GPSInfoIFDPointer", 34853, 4, 0), new d("InteroperabilityIFDPointer", 40965, 4, 0), new d("CameraSettingsIFDPointer", 8224, 1, 0), new d("ImageProcessingIFDPointer", 8256, 1, 0) };
    pt = new d("JPEGInterchangeFormat", 513, 4, (byte)0);
    pu = new d("JPEGInterchangeFormatLength", 514, 4, (byte)0);
    pv = new HashMap[pr.length];
    pw = new HashMap[pr.length];
    px = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    py = new HashMap();
    pz = Charset.forName("US-ASCII");
    pA = "".getBytes(pz);
    Object localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    pd = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    int i = 0;
    while (i < pr.length)
    {
      pv[i] = new HashMap();
      pw[i] = new HashMap();
      localObject1 = pr[i];
      int k = localObject1.length;
      int j = 0;
      while (j < k)
      {
        Object localObject2 = localObject1[j];
        pv[i].put(Integer.valueOf(localObject2.number), localObject2);
        pw[i].put(localObject2.name, localObject2);
        j += 1;
      }
      i += 1;
    }
    py.put(Integer.valueOf(ps[0].number), Integer.valueOf(5));
    py.put(Integer.valueOf(ps[1].number), Integer.valueOf(1));
    py.put(Integer.valueOf(ps[2].number), Integer.valueOf(2));
    py.put(Integer.valueOf(ps[3].number), Integer.valueOf(3));
    py.put(Integer.valueOf(ps[4].number), Integer.valueOf(7));
    py.put(Integer.valueOf(ps[5].number), Integer.valueOf(8));
  }
  
  public a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("inputStream cannot be null");
    }
    this.mFilename = null;
    if ((paramInputStream instanceof AssetManager.AssetInputStream)) {}
    for (this.pB = ((AssetManager.AssetInputStream)paramInputStream);; this.pB = null)
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
    this.pB = null;
    this.mFilename = paramString;
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
  
  private c A(String paramString)
  {
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString)) {
      str = "PhotographicSensitivity";
    }
    int i = 0;
    while (i < pr.length)
    {
      paramString = (c)this.pD[i].get(str);
      if (paramString != null) {
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  private static Pair<Integer, Integer> B(String paramString)
  {
    Object localObject;
    int i;
    if (paramString.contains(","))
    {
      String[] arrayOfString = paramString.split(",");
      paramString = B(arrayOfString[0]);
      if (((Integer)paramString.first).intValue() == 2) {
        localObject = paramString;
      }
      do
      {
        return localObject;
        i = 1;
        localObject = paramString;
      } while (i >= arrayOfString.length);
      localObject = B(arrayOfString[i]);
      if ((!((Integer)((Pair)localObject).first).equals(paramString.first)) && (!((Integer)((Pair)localObject).second).equals(paramString.first))) {
        break label548;
      }
    }
    label548:
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
              paramString = paramString.split("/");
              long l1;
              long l2;
              if (paramString.length == 2) {
                try
                {
                  l1 = Double.parseDouble(paramString[0]);
                  l2 = Double.parseDouble(paramString[1]);
                  if ((l1 >= 0L) && (l2 >= 0L)) {
                    break label346;
                  }
                  paramString = new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                  return paramString;
                }
                catch (NumberFormatException paramString) {}
              } else {
                return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
              }
              label346:
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
  
  private int a(b paramb)
  {
    int[] arrayOfInt = new int[pr.length];
    Object localObject1 = new int[pr.length];
    Object localObject2 = ps;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      removeAttribute(localObject2[i].name);
      i += 1;
    }
    removeAttribute(pt.name);
    removeAttribute(pu.name);
    i = 0;
    int k;
    while (i < pr.length)
    {
      localObject2 = this.pD[i].entrySet().toArray();
      k = localObject2.length;
      j = 0;
      while (j < k)
      {
        Map.Entry localEntry = (Map.Entry)localObject2[j];
        if (localEntry.getValue() == null) {
          this.pD[i].remove(localEntry.getKey());
        }
        j += 1;
      }
      i += 1;
    }
    if (!this.pD[1].isEmpty()) {
      this.pD[0].put(ps[1].name, c.a(0L, this.pE));
    }
    if (!this.pD[2].isEmpty()) {
      this.pD[0].put(ps[2].name, c.a(0L, this.pE));
    }
    if (!this.pD[3].isEmpty()) {
      this.pD[1].put(ps[3].name, c.a(0L, this.pE));
    }
    if (this.pF)
    {
      this.pD[4].put(pt.name, c.a(0L, this.pE));
      this.pD[4].put(pu.name, c.a(this.pH, this.pE));
    }
    j = 0;
    if (j < pr.length)
    {
      localObject2 = this.pD[j].entrySet().iterator();
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
      while (j < pr.length)
      {
        k = i;
        if (!this.pD[j].isEmpty())
        {
          arrayOfInt[j] = i;
          k = i + (this.pD[j].size() * 12 + 2 + 4 + localObject1[j]);
        }
        j += 1;
        i = k;
      }
      j = i;
      if (this.pF)
      {
        this.pD[4].put(pt.name, c.a(i, this.pE));
        this.pG = (i + 6);
        j = i + this.pH;
      }
      int m = j + 8;
      if (!this.pD[1].isEmpty()) {
        this.pD[0].put(ps[1].name, c.a(arrayOfInt[1], this.pE));
      }
      if (!this.pD[2].isEmpty()) {
        this.pD[0].put(ps[2].name, c.a(arrayOfInt[2], this.pE));
      }
      if (!this.pD[3].isEmpty()) {
        this.pD[1].put(ps[3].name, c.a(arrayOfInt[3], this.pE));
      }
      paramb.writeShort((short)m);
      paramb.write(pA);
      short s;
      if (this.pE == ByteOrder.BIG_ENDIAN)
      {
        s = 19789;
        paramb.writeShort(s);
        paramb.pT = this.pE;
        paramb.writeShort((short)42);
        paramb.writeInt(8);
        i = 0;
      }
      for (;;)
      {
        if (i >= pr.length) {
          break label1106;
        }
        if (!this.pD[i].isEmpty())
        {
          paramb.writeShort((short)this.pD[i].size());
          j = arrayOfInt[i];
          k = this.pD[i].size();
          localObject1 = this.pD[i].entrySet().iterator();
          j = j + 2 + k * 12 + 4;
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label990;
            }
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            int n = ((d)pw[i].get(((Map.Entry)localObject2).getKey())).number;
            localObject2 = (c)((Map.Entry)localObject2).getValue();
            k = ((c)localObject2).size();
            paramb.writeShort((short)n);
            paramb.writeShort((short)((c)localObject2).format);
            paramb.writeInt(((c)localObject2).pV);
            if (k > 4)
            {
              paramb.writeInt((int)j);
              j += k;
              continue;
              s = 18761;
              break;
            }
            paramb.write(((c)localObject2).pW);
            if (k < 4) {
              while (k < 4)
              {
                paramb.writeByte(0);
                k += 1;
              }
            }
          }
          if ((i == 0) && (!this.pD[4].isEmpty())) {
            paramb.writeInt((int)arrayOfInt[4]);
          }
          for (;;)
          {
            localObject1 = this.pD[i].entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (c)((Map.Entry)((Iterator)localObject1).next()).getValue();
              if (((c)localObject2).pW.length > 4) {
                paramb.write(((c)localObject2).pW, 0, ((c)localObject2).pW.length);
              }
            }
            paramb.writeInt(0);
          }
        }
        i += 1;
      }
      if (this.pF) {
        paramb.write(getThumbnailBytes());
      }
      paramb.pT = ByteOrder.BIG_ENDIAN;
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
    bZ();
    if (this.pC == 8)
    {
      parama = (c)this.pD[1].get("MakerNote");
      if (parama != null)
      {
        parama = new a(parama.pW);
        parama.pT = this.pE;
        parama.seek(6L);
        b(parama, 9);
        parama = (c)this.pD[9].get("ColorSpace");
        if (parama != null) {
          this.pD[1].put("ColorSpace", parama);
        }
      }
    }
  }
  
  private void a(a parama, int paramInt)
  {
    this.pE = c(parama);
    parama.pT = this.pE;
    int i = parama.readUnsignedShort();
    if ((this.pC != 7) && (this.pC != 10) && (i != 42)) {
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
    parama.pT = ByteOrder.BIG_ENDIAN;
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
        if (!Arrays.equals(arrayOfByte, pA)) {
          continue;
        }
        if (k <= 0) {
          throw new IOException("Invalid exif");
        }
        this.pK = j;
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
          this.pD[1].put("UserComment", c.C(new String(arrayOfByte, pz)));
          paramInt1 = 0;
          i = j;
          continue;
          if (parama.skipBytes(1) != 1) {
            throw new IOException("Invalid SOFx");
          }
          this.pD[paramInt2].put("ImageLength", c.a(parama.readUnsignedShort(), this.pE));
          this.pD[paramInt2].put("ImageWidth", c.a(parama.readUnsignedShort(), this.pE));
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
        parama.pT = this.pE;
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
      j = localc.c(this.pE);
      k = Math.min(paramHashMap.c(this.pE), parama.available() - j);
      if ((this.pC != 4) && (this.pC != 9) && (this.pC != 10)) {
        break label158;
      }
      i = j + this.pK;
    }
    for (;;)
    {
      if ((i > 0) && (k > 0))
      {
        this.pF = true;
        this.pG = i;
        this.pH = k;
        if ((this.mFilename == null) && (this.pB == null))
        {
          paramHashMap = new byte[k];
          parama.seek(i);
          parama.readFully(paramHashMap);
          this.pI = paramHashMap;
        }
      }
      return;
      label158:
      i = j;
      if (this.pC == 7) {
        i = j + this.pL;
      }
    }
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
    parama.pT = ByteOrder.BIG_ENDIAN;
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
          parama = c.a(i, this.pE);
          localObject = c.a(j, this.pE);
          this.pD[0].put("ImageLength", parama);
          this.pD[0].put("ImageWidth", localObject);
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
    if (a.d(parama) + 2 > a.e(parama)) {}
    label16:
    int n;
    do
    {
      return;
      n = parama.readShort();
    } while (a.d(parama) + n * 12 > a.e(parama));
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
      locald = (d)pv[j].get(Integer.valueOf(i1));
      l1 = 0L;
      m = 0;
      if (locald == null) {
        break label882;
      }
      if ((i <= 0) || (i >= pg.length))
      {
        paramInt = i;
        i = m;
      }
    }
    for (;;)
    {
      label125:
      if (i == 0) {
        parama.seek(l3);
      }
      for (;;)
      {
        k = (short)(k + 1);
        break;
        if (!locald.T(i))
        {
          new StringBuilder("Skip the tag entry since data format (").append(pe[i]).append(") is unexpected for tag: ").append(locald.name);
          paramInt = i;
          i = m;
          break label125;
        }
        paramInt = i;
        if (i == 7) {
          paramInt = locald.pX;
        }
        l1 = i2 * pg[paramInt];
        if ((l1 < 0L) || (l1 > 2147483647L))
        {
          i = m;
          break label125;
        }
        i = 1;
        break label125;
        if (l1 > 4L)
        {
          i = parama.readInt();
          if (this.pC != 7) {
            break label565;
          }
          if ("MakerNote".equals(locald.name))
          {
            this.pL = i;
            label290:
            if (i + l1 > a.e(parama)) {
              break label596;
            }
            parama.seek(i);
          }
        }
        else
        {
          localObject = (Integer)py.get(Integer.valueOf(i1));
          if (localObject == null) {
            break label644;
          }
          long l2 = -1L;
          l1 = l2;
          switch (paramInt)
          {
          default: 
            l1 = l2;
          }
        }
        for (;;)
        {
          if ((l1 > 0L) && (l1 < a.e(parama)))
          {
            parama.seek(l1);
            b(parama, ((Integer)localObject).intValue());
          }
          parama.seek(l3);
          break;
          if ((j != 6) || (!"ThumbnailImage".equals(locald.name))) {
            break label290;
          }
          this.pM = i;
          this.pN = i2;
          localObject = c.a(6, this.pE);
          c localc1 = c.a(this.pM, this.pE);
          c localc2 = c.a(this.pN, this.pE);
          this.pD[4].put("Compression", localObject);
          this.pD[4].put("JPEGInterchangeFormat", localc1);
          this.pD[4].put("JPEGInterchangeFormatLength", localc2);
          break label290;
          label565:
          if ((this.pC != 10) || (!"JpgFromRaw".equals(locald.name))) {
            break label290;
          }
          this.pO = i;
          break label290;
          label596:
          parama.seek(l3);
          break;
          l1 = parama.readUnsignedShort();
          continue;
          l1 = parama.readShort();
          continue;
          l1 = parama.cc();
          continue;
          l1 = parama.readInt();
        }
        label644:
        Object localObject = new byte[(int)l1];
        parama.readFully((byte[])localObject);
        localObject = new c(paramInt, i2, (byte[])localObject, (byte)0);
        this.pD[j].put(locald.name, localObject);
        if ("DNGVersion".equals(locald.name)) {
          this.pC = 3;
        }
        if (((!"Make".equals(locald.name)) && (!"Model".equals(locald.name))) || ((((c)localObject).d(this.pE).contains("PENTAX")) || (("Compression".equals(locald.name)) && (((c)localObject).c(this.pE) == 65535)))) {
          this.pC = 8;
        }
        if (parama.mPosition != l3) {
          parama.seek(l3);
        }
      }
      if (parama.mPosition + 4 > a.e(parama)) {
        break label16;
      }
      paramInt = parama.readInt();
      if ((paramInt <= 8) || (paramInt >= a.e(parama))) {
        break label16;
      }
      parama.seek(paramInt);
      if (this.pD[4].isEmpty())
      {
        j = 4;
        break;
      }
      if (!this.pD[5].isEmpty()) {
        break label16;
      }
      j = 5;
      break;
      label882:
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
      paramHashMap = f(((c)localObject1).a(this.pE));
      localObject1 = f(((c)localObject2).a(this.pE));
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
    this.pF = true;
    this.pI = ((byte[])localObject2);
    this.pH = localObject2.length;
  }
  
  private void b(InputStream paramInputStream)
  {
    int i = 0;
    try
    {
      while (i < pr.length)
      {
        this.pD[i] = new HashMap();
        i += 1;
      }
      paramInputStream = new BufferedInputStream(paramInputStream, 5000);
      localObject2 = (BufferedInputStream)paramInputStream;
      ((BufferedInputStream)localObject2).mark(5000);
      localObject1 = new byte[5000];
      ((BufferedInputStream)localObject2).read((byte[])localObject1);
      ((BufferedInputStream)localObject2).reset();
      if (!e((byte[])localObject1)) {
        break label254;
      }
      i = 4;
      this.pC = i;
      paramInputStream = new a(paramInputStream);
      switch (this.pC)
      {
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        label168:
        this.pP = false;
        return;
        b(paramInputStream);
      }
    }
    finally
    {
      bY();
    }
    Object localObject1 = this.pD[4];
    Object localObject2 = (c)((HashMap)localObject1).get("Compression");
    label244:
    label254:
    Object localObject3;
    label325:
    int j;
    if (localObject2 != null)
    {
      this.pJ = ((c)localObject2).c(this.pE);
      switch (this.pJ)
      {
      case 6: 
        for (;;)
        {
          this.pP = true;
          bY();
          return;
          if (f((byte[])localObject1))
          {
            i = 9;
            break;
          }
          localObject2 = new a((byte[])localObject1);
          this.pE = c((a)localObject2);
          ((a)localObject2).pT = this.pE;
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
          this.pE = c((a)localObject1);
          ((a)localObject1).pT = this.pE;
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
          localObject1 = (c)this.pD[1].get("MakerNote");
          if (localObject1 == null) {
            break label168;
          }
          localObject1 = new a(((c)localObject1).pW);
          ((a)localObject1).pT = this.pE;
          localObject2 = new byte[pb.length];
          ((a)localObject1).readFully((byte[])localObject2);
          ((a)localObject1).seek(0L);
          localObject3 = new byte[pc.length];
          ((a)localObject1).readFully((byte[])localObject3);
          if (Arrays.equals((byte[])localObject2, pb)) {
            ((a)localObject1).seek(8L);
          }
          for (;;)
          {
            b((a)localObject1, 6);
            localObject1 = (c)this.pD[7].get("PreviewImageStart");
            localObject2 = (c)this.pD[7].get("PreviewImageLength");
            if ((localObject1 != null) && (localObject2 != null))
            {
              this.pD[5].put("JPEGInterchangeFormat", localObject1);
              this.pD[5].put("JPEGInterchangeFormatLength", localObject2);
            }
            localObject1 = (c)this.pD[8].get("AspectFrame");
            if (localObject1 == null) {
              break;
            }
            localObject1 = (int[])((c)localObject1).a(this.pE);
            if ((localObject1 != null) && (localObject1.length == 4)) {
              break label1053;
            }
            new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString((int[])localObject1));
            break;
            if (Arrays.equals((byte[])localObject3, pc)) {
              ((a)localObject1).seek(12L);
            }
          }
          localObject1 = c.a(j, this.pE);
          localObject2 = c.a(i, this.pE);
          this.pD[0].put("ImageWidth", localObject1);
          this.pD[0].put("ImageLength", localObject2);
          break label168;
          a(paramInputStream);
          if ((c)this.pD[0].get("JpgFromRaw") != null) {
            a(paramInputStream, this.pO, 5);
          }
          localObject1 = (c)this.pD[0].get("ISO");
          localObject2 = (c)this.pD[1].get("PhotographicSensitivity");
          if ((localObject1 == null) || (localObject2 != null)) {
            break label168;
          }
          this.pD[1].put("PhotographicSensitivity", localObject1);
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
          localObject2 = (int[])((c)localObject2).a(this.pE);
          if (Arrays.equals(oX, (int[])localObject2)) {
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
      if (this.pC == 3)
      {
        localObject3 = (c)((HashMap)localObject1).get("PhotometricInterpretation");
        if (localObject3 != null)
        {
          i = ((c)localObject3).c(this.pE);
          if ((i != 1) || (!Arrays.equals((int[])localObject2, oZ)))
          {
            if ((i != 6) || (!Arrays.equals((int[])localObject2, oX))) {
              break label1137;
            }
            break label1132;
            this.pJ = 6;
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
          if (Arrays.equals(arrayOfByte2, pA))
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
  
  private void bY()
  {
    String str = getAttribute("DateTimeOriginal");
    if ((str != null) && (getAttribute("DateTime") == null)) {
      this.pD[0].put("DateTime", c.C(str));
    }
    if (getAttribute("ImageWidth") == null) {
      this.pD[0].put("ImageWidth", c.a(0L, this.pE));
    }
    if (getAttribute("ImageLength") == null) {
      this.pD[0].put("ImageLength", c.a(0L, this.pE));
    }
    if (getAttribute("Orientation") == null) {
      this.pD[0].put("Orientation", c.a(0L, this.pE));
    }
    if (getAttribute("LightSource") == null) {
      this.pD[1].put("LightSource", c.a(0L, this.pE));
    }
  }
  
  private void bZ()
  {
    l(0, 5);
    l(0, 4);
    l(5, 4);
    c localc1 = (c)this.pD[1].get("PixelXDimension");
    c localc2 = (c)this.pD[1].get("PixelYDimension");
    if ((localc1 != null) && (localc2 != null))
    {
      this.pD[0].put("ImageWidth", localc1);
      this.pD[0].put("ImageLength", localc2);
    }
    if ((this.pD[4].isEmpty()) && (h(this.pD[5])))
    {
      this.pD[4] = this.pD[5];
      this.pD[5] = new HashMap();
    }
    h(this.pD[4]);
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
    c localc1 = (c)this.pD[paramInt].get("ImageLength");
    c localc2 = (c)this.pD[paramInt].get("ImageWidth");
    if ((localc1 == null) || (localc2 == null))
    {
      localc1 = (c)this.pD[paramInt].get("JPEGInterchangeFormat");
      if (localc1 != null) {
        a(parama, localc1.c(this.pE), paramInt);
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
    c localc1 = (c)this.pD[paramInt].get("DefaultCropSize");
    c localc2 = (c)this.pD[paramInt].get("SensorTopBorder");
    c localc3 = (c)this.pD[paramInt].get("SensorLeftBorder");
    c localc4 = (c)this.pD[paramInt].get("SensorBottomBorder");
    c localc5 = (c)this.pD[paramInt].get("SensorRightBorder");
    if (localc1 != null) {
      if (localc1.format == 5)
      {
        parama = (e[])localc1.a(this.pE);
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
      localc1 = c.a(parama[0], this.pE);
      for (parama = c.a(parama[1], this.pE);; parama = c.a(parama[1], this.pE))
      {
        this.pD[paramInt].put("ImageWidth", localc1);
        this.pD[paramInt].put("ImageLength", parama);
        return;
        parama = (int[])localc1.a(this.pE);
        if ((parama == null) || (parama.length != 2))
        {
          new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(parama));
          return;
        }
        localc1 = c.a(parama[0], this.pE);
      }
      if ((localc2 == null) || (localc3 == null) || (localc4 == null) || (localc5 == null)) {
        break;
      }
      i = localc2.c(this.pE);
      j = localc4.c(this.pE);
      k = localc5.c(this.pE);
      m = localc3.c(this.pE);
    } while ((j <= i) || (k <= m));
    parama = c.a(j - i, this.pE);
    localc1 = c.a(k - m, this.pE);
    this.pD[paramInt].put("ImageLength", parama);
    this.pD[paramInt].put("ImageWidth", localc1);
    return;
    c(parama, paramInt);
  }
  
  private static boolean e(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < pa.length)
    {
      if (paramArrayOfByte[i] != pa[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean f(byte[] paramArrayOfByte)
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
  
  private static long[] f(Object paramObject)
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
  
  private static double g(String paramString1, String paramString2)
  {
    double d1;
    try
    {
      paramString1 = paramString1.split(",");
      String[] arrayOfString = paramString1[0].split("/");
      d1 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      arrayOfString = paramString1[1].split("/");
      double d3 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      paramString1 = paramString1[2].split("/");
      d2 = Double.parseDouble(paramString1[0].trim()) / Double.parseDouble(paramString1[1].trim());
      d3 /= 60.0D;
      d2 = d2 / 3600.0D + (d1 + d3);
      if ((!paramString2.equals("S")) && (!paramString2.equals("W")))
      {
        d1 = d2;
        if (paramString2.equals("N")) {
          return d1;
        }
        d1 = d2;
        if (paramString2.equals("E")) {
          return d1;
        }
        throw new IllegalArgumentException();
      }
    }
    catch (NumberFormatException paramString1)
    {
      throw new IllegalArgumentException();
    }
    catch (ArrayIndexOutOfBoundsException paramString1)
    {
      double d2;
      label185:
      break label185;
      d1 = -d2;
    }
    return d1;
  }
  
  /* Error */
  private byte[] getThumbnailBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 965	android/support/d/a:pF	Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 1137	android/support/d/a:pI	[B
    //   13: ifnull +8 -> 21
    //   16: aload_0
    //   17: getfield 1137	android/support/d/a:pI	[B
    //   20: areturn
    //   21: aload_0
    //   22: getfield 849	android/support/d/a:pB	Landroid/content/res/AssetManager$AssetInputStream;
    //   25: ifnull +44 -> 69
    //   28: aload_0
    //   29: getfield 849	android/support/d/a:pB	Landroid/content/res/AssetManager$AssetInputStream;
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 1354	java/io/InputStream:markSupported	()Z
    //   37: ifeq +26 -> 63
    //   40: aload_1
    //   41: invokevirtual 1355	java/io/InputStream:reset	()V
    //   44: aload_1
    //   45: ifnonnull +52 -> 97
    //   48: new 1357	java/io/FileNotFoundException
    //   51: dup
    //   52: invokespecial 1358	java/io/FileNotFoundException:<init>	()V
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   61: aconst_null
    //   62: areturn
    //   63: aload_1
    //   64: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload_0
    //   70: getfield 845	android/support/d/a:mFilename	Ljava/lang/String;
    //   73: ifnull +115 -> 188
    //   76: new 855	java/io/FileInputStream
    //   79: dup
    //   80: aload_0
    //   81: getfield 845	android/support/d/a:mFilename	Ljava/lang/String;
    //   84: invokespecial 856	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   87: astore_1
    //   88: goto -44 -> 44
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -37 -> 57
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 985	android/support/d/a:pG	I
    //   102: i2l
    //   103: invokevirtual 1362	java/io/InputStream:skip	(J)J
    //   106: aload_0
    //   107: getfield 985	android/support/d/a:pG	I
    //   110: i2l
    //   111: lcmp
    //   112: ifeq +21 -> 133
    //   115: new 1052	java/io/IOException
    //   118: dup
    //   119: ldc_w 1364
    //   122: invokespecial 1070	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: astore_2
    //   127: aload_1
    //   128: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   131: aload_2
    //   132: athrow
    //   133: aload_0
    //   134: getfield 967	android/support/d/a:pH	I
    //   137: newarray byte
    //   139: astore_2
    //   140: aload_1
    //   141: aload_2
    //   142: invokevirtual 1309	java/io/InputStream:read	([B)I
    //   145: aload_0
    //   146: getfield 967	android/support/d/a:pH	I
    //   149: if_icmpeq +14 -> 163
    //   152: new 1052	java/io/IOException
    //   155: dup
    //   156: ldc_w 1364
    //   159: invokespecial 1070	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: aload_0
    //   164: aload_2
    //   165: putfield 1137	android/support/d/a:pI	[B
    //   168: aload_1
    //   169: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
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
  
  private boolean h(HashMap paramHashMap)
  {
    c localc = (c)paramHashMap.get("ImageLength");
    paramHashMap = (c)paramHashMap.get("ImageWidth");
    if ((localc != null) && (paramHashMap != null))
    {
      int i = localc.c(this.pE);
      int j = paramHashMap.c(this.pE);
      if ((i <= 512) && (j <= 512)) {
        return true;
      }
    }
    return false;
  }
  
  private void l(int paramInt1, int paramInt2)
  {
    if ((this.pD[paramInt1].isEmpty()) || (this.pD[paramInt2].isEmpty())) {}
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
        localObject1 = (c)this.pD[paramInt1].get("ImageLength");
        localObject2 = (c)this.pD[paramInt1].get("ImageWidth");
        localc1 = (c)this.pD[paramInt2].get("ImageLength");
        localc2 = (c)this.pD[paramInt2].get("ImageWidth");
      } while ((localObject1 == null) || (localObject2 == null) || (localc1 == null) || (localc2 == null));
      i = ((c)localObject1).c(this.pE);
      j = ((c)localObject2).c(this.pE);
      k = localc1.c(this.pE);
      m = localc2.c(this.pE);
    } while ((i >= k) || (j >= m));
    Object localObject1 = this.pD[paramInt1];
    Object localObject2 = this.pD;
    localObject2[paramInt1] = localObject2[paramInt2];
    this.pD[paramInt2] = localObject1;
  }
  
  private void removeAttribute(String paramString)
  {
    int i = 0;
    while (i < pr.length)
    {
      this.pD[i].remove(paramString);
      i += 1;
    }
  }
  
  public final double[] bX()
  {
    String str1 = getAttribute("GPSLatitude");
    String str2 = getAttribute("GPSLatitudeRef");
    String str3 = getAttribute("GPSLongitude");
    String str4 = getAttribute("GPSLongitudeRef");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null)) {
      try
      {
        double d1 = g(str1, str2);
        double d2 = g(str3, str4);
        return new double[] { d1, d2 };
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        new StringBuilder("Latitude/longitude values are not parseable. ").append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[] { str1, str2, str3, str4 }));
      }
    }
    return null;
  }
  
  public final String getAttribute(String paramString)
  {
    c localc = A(paramString);
    if (localc != null)
    {
      if (!px.contains(paramString)) {
        return localc.d(this.pE);
      }
      if (paramString.equals("GPSTimeStamp"))
      {
        if ((localc.format != 5) && (localc.format != 10))
        {
          new StringBuilder("GPS Timestamp format is not rational. format=").append(localc.format);
          return null;
        }
        paramString = (e[])localc.a(this.pE);
        if ((paramString == null) || (paramString.length != 3))
        {
          new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(paramString));
          return null;
        }
        return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)paramString[0].pZ / (float)paramString[0].qa)), Integer.valueOf((int)((float)paramString[1].pZ / (float)paramString[1].qa)), Integer.valueOf((int)((float)paramString[2].pZ / (float)paramString[2].qa)) });
      }
      try
      {
        paramString = Double.toString(localc.b(this.pE));
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        return null;
      }
    }
    return null;
  }
  
  public final double getAttributeDouble(String paramString, double paramDouble)
  {
    paramString = A(paramString);
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d = paramString.b(this.pE);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public final int getAttributeInt(String paramString, int paramInt)
  {
    paramString = A(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = paramString.c(this.pE);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  /* Error */
  public final void saveAttributes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1232	android/support/d/a:pP	Z
    //   4: ifeq +11 -> 15
    //   7: aload_0
    //   8: getfield 1035	android/support/d/a:pC	I
    //   11: iconst_4
    //   12: if_icmpeq +14 -> 26
    //   15: new 1052	java/io/IOException
    //   18: dup
    //   19: ldc_w 1408
    //   22: invokespecial 1070	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   25: athrow
    //   26: aload_0
    //   27: getfield 845	android/support/d/a:mFilename	Ljava/lang/String;
    //   30: ifnonnull +14 -> 44
    //   33: new 1052	java/io/IOException
    //   36: dup
    //   37: ldc_w 1410
    //   40: invokespecial 1070	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    //   44: aload_0
    //   45: getfield 1230	android/support/d/a:pJ	I
    //   48: bipush 6
    //   50: if_icmpeq +12 -> 62
    //   53: aload_0
    //   54: getfield 1230	android/support/d/a:pJ	I
    //   57: bipush 7
    //   59: if_icmpne +93 -> 152
    //   62: aload_0
    //   63: invokespecial 1019	android/support/d/a:getThumbnailBytes	()[B
    //   66: astore_1
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 1137	android/support/d/a:pI	[B
    //   72: new 1412	java/io/File
    //   75: dup
    //   76: new 1054	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 1413	java/lang/StringBuilder:<init>	()V
    //   83: aload_0
    //   84: getfield 845	android/support/d/a:mFilename	Ljava/lang/String;
    //   87: invokevirtual 1065	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 1415
    //   93: invokevirtual 1065	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 1069	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 1416	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 4
    //   104: new 1412	java/io/File
    //   107: dup
    //   108: aload_0
    //   109: getfield 845	android/support/d/a:mFilename	Ljava/lang/String;
    //   112: invokespecial 1416	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: aload 4
    //   117: invokevirtual 1420	java/io/File:renameTo	(Ljava/io/File;)Z
    //   120: ifne +37 -> 157
    //   123: new 1052	java/io/IOException
    //   126: dup
    //   127: new 1054	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 1422
    //   134: invokespecial 1057	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload 4
    //   139: invokevirtual 1425	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: invokevirtual 1065	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 1069	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokespecial 1070	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   151: athrow
    //   152: aconst_null
    //   153: astore_1
    //   154: goto -87 -> 67
    //   157: new 855	java/io/FileInputStream
    //   160: dup
    //   161: aload 4
    //   163: invokespecial 1428	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   166: astore_3
    //   167: new 1430	java/io/FileOutputStream
    //   170: dup
    //   171: aload_0
    //   172: getfield 845	android/support/d/a:mFilename	Ljava/lang/String;
    //   175: invokespecial 1431	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   178: astore_2
    //   179: aload_0
    //   180: aload_3
    //   181: aload_2
    //   182: invokespecial 1433	android/support/d/a:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   185: aload_3
    //   186: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   189: aload_2
    //   190: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   193: aload 4
    //   195: invokevirtual 1436	java/io/File:delete	()Z
    //   198: pop
    //   199: aload_0
    //   200: aconst_null
    //   201: putfield 1137	android/support/d/a:pI	[B
    //   204: return
    //   205: astore_1
    //   206: aconst_null
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_3
    //   210: aload_3
    //   211: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   214: aload_2
    //   215: invokestatic 860	android/support/d/a:closeQuietly	(Ljava/io/Closeable;)V
    //   218: aload 4
    //   220: invokevirtual 1436	java/io/File:delete	()Z
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
      if (px.contains(str))
      {
        if (!str.equals("GPSTimeStamp")) {
          break label221;
        }
        paramString1 = pR.matcher(paramString2);
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
    if (j < pr.length) {
      if ((j != 4) || (this.pF))
      {
        paramString2 = (d)pw[j].get(str);
        if (paramString2 != null)
        {
          if (paramString1 != null) {
            break label268;
          }
          this.pD[j].remove(str);
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
          paramString1 = new e(Double.parseDouble(paramString2), (byte)0).toString();
        }
        catch (NumberFormatException paramString1)
        {
          new StringBuilder("Invalid value for ").append(str).append(" : ").append(paramString2);
          return;
        }
      }
      label268:
      Object localObject1 = B(paramString1);
      int i;
      if ((paramString2.pX == ((Integer)((Pair)localObject1).first).intValue()) || (paramString2.pX == ((Integer)((Pair)localObject1).second).intValue())) {
        i = paramString2.pX;
      }
      label315:
      Object localObject2;
      switch (i)
      {
      case 6: 
      case 8: 
      case 11: 
      default: 
        break;
      case 1: 
        localObject1 = this.pD[j];
        if ((paramString1.length() == 1) && (paramString1.charAt(0) >= '0') && (paramString1.charAt(0) <= '1')) {}
        for (paramString2 = new c(1, 1, new byte[] { (byte)(paramString1.charAt(0) - '0') });; paramString2 = new c(1, paramString2.length, paramString2))
        {
          ((HashMap)localObject1).put(str, paramString2);
          break;
          if ((paramString2.pY != -1) && ((paramString2.pY == ((Integer)((Pair)localObject1).first).intValue()) || (paramString2.pY == ((Integer)((Pair)localObject1).second).intValue())))
          {
            i = paramString2.pY;
            break label315;
          }
          if ((paramString2.pX == 1) || (paramString2.pX == 7) || (paramString2.pX == 2))
          {
            i = paramString2.pX;
            break label315;
          }
          localObject2 = new StringBuilder("Given tag (").append(str).append(") value didn't match with one of expected formats: ").append(pe[paramString2.pX]);
          if (paramString2.pY == -1)
          {
            paramString2 = "";
            localObject2 = ((StringBuilder)localObject2).append(paramString2).append(" (guess: ").append(pe[((Integer)localObject1.first).intValue()]);
            if (((Integer)((Pair)localObject1).second).intValue() != -1) {
              break label683;
            }
          }
          for (paramString2 = "";; paramString2 = ", " + pe[((Integer)localObject1.second).intValue()])
          {
            ((StringBuilder)localObject2).append(paramString2).append(")");
            break;
            paramString2 = ", " + pe[paramString2.pY];
            break label588;
          }
          paramString2 = paramString1.getBytes(pz);
        }
      case 2: 
      case 7: 
        this.pD[j].put(str, c.C(paramString1));
        break;
      case 3: 
        paramString2 = paramString1.split(",");
        localObject1 = new int[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Integer.parseInt(paramString2[i]);
          i += 1;
        }
        this.pD[j].put(str, c.a((int[])localObject1, this.pE));
        break;
      case 9: 
        paramString2 = paramString1.split(",");
        localObject1 = new int[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Integer.parseInt(paramString2[i]);
          i += 1;
        }
        this.pD[j].put(str, c.b((int[])localObject1, this.pE));
        break;
      case 4: 
        paramString2 = paramString1.split(",");
        localObject1 = new long[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Long.parseLong(paramString2[i]);
          i += 1;
        }
        this.pD[j].put(str, c.a((long[])localObject1, this.pE));
        break;
      case 5: 
        paramString2 = paramString1.split(",");
        localObject1 = new e[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject2 = paramString2[i].split("/");
          localObject1[i] = new e(Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]), 0);
          i += 1;
        }
        this.pD[j].put(str, c.a((e[])localObject1, this.pE));
        break;
      case 10: 
        paramString2 = paramString1.split(",");
        localObject1 = new e[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject2 = paramString2[i].split("/");
          localObject1[i] = new e(Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]), 0);
          i += 1;
        }
        this.pD[j].put(str, c.b((e[])localObject1, this.pE));
        break;
      case 12: 
        label588:
        paramString2 = paramString1.split(",");
        label683:
        localObject1 = new double[paramString2.length];
        i = 0;
        while (i < paramString2.length)
        {
          localObject1[i] = Double.parseDouble(paramString2[i]);
          i += 1;
        }
        this.pD[j].put(str, c.a((double[])localObject1, this.pE));
      }
    }
  }
  
  static final class a
    extends InputStream
    implements DataInput
  {
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private final int mLength;
    int mPosition;
    private DataInputStream pS;
    ByteOrder pT = ByteOrder.BIG_ENDIAN;
    
    public a(InputStream paramInputStream)
    {
      this.pS = new DataInputStream(paramInputStream);
      this.mLength = this.pS.available();
      this.mPosition = 0;
      this.pS.mark(this.mLength);
    }
    
    public a(byte[] paramArrayOfByte)
    {
      this(new ByteArrayInputStream(paramArrayOfByte));
    }
    
    public final int available()
    {
      return this.pS.available();
    }
    
    public final long cc()
    {
      return readInt() & 0xFFFFFFFF;
    }
    
    public final int read()
    {
      this.mPosition += 1;
      return this.pS.read();
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = this.pS.read(paramArrayOfByte, paramInt1, paramInt2);
      this.mPosition += paramInt1;
      return paramInt1;
    }
    
    public final boolean readBoolean()
    {
      this.mPosition += 1;
      return this.pS.readBoolean();
    }
    
    public final byte readByte()
    {
      this.mPosition += 1;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.pS.read();
      if (i < 0) {
        throw new EOFException();
      }
      return (byte)i;
    }
    
    public final char readChar()
    {
      this.mPosition += 2;
      return this.pS.readChar();
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
      if (this.pS.read(paramArrayOfByte, 0, paramArrayOfByte.length) != paramArrayOfByte.length) {
        throw new IOException("Couldn't read up to the length of buffer");
      }
    }
    
    public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.mPosition += paramInt2;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      if (this.pS.read(paramArrayOfByte, paramInt1, paramInt2) != paramInt2) {
        throw new IOException("Couldn't read up to the length of buffer");
      }
    }
    
    public final int readInt()
    {
      this.mPosition += 4;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.pS.read();
      int j = this.pS.read();
      int k = this.pS.read();
      int m = this.pS.read();
      if ((i | j | k | m) < 0) {
        throw new EOFException();
      }
      if (this.pT == LITTLE_ENDIAN) {
        return i + ((j << 8) + ((k << 16) + (m << 24)));
      }
      if (this.pT == BIG_ENDIAN) {
        return (i << 24) + (j << 16) + (k << 8) + m;
      }
      throw new IOException("Invalid byte order: " + this.pT);
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
      int i = this.pS.read();
      int j = this.pS.read();
      int k = this.pS.read();
      int m = this.pS.read();
      int n = this.pS.read();
      int i1 = this.pS.read();
      int i2 = this.pS.read();
      int i3 = this.pS.read();
      if ((i | j | k | m | n | i1 | i2 | i3) < 0) {
        throw new EOFException();
      }
      long l1;
      if (this.pT == LITTLE_ENDIAN)
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
      if (this.pT == BIG_ENDIAN)
      {
        l1 = i;
        return (j << 48) + (l1 << 56) + (k << 40) + (m << 32) + (n << 24) + (i1 << 16) + (i2 << 8) + i3;
      }
      throw new IOException("Invalid byte order: " + this.pT);
    }
    
    public final short readShort()
    {
      this.mPosition += 2;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.pS.read();
      int j = this.pS.read();
      if ((i | j) < 0) {
        throw new EOFException();
      }
      if (this.pT == LITTLE_ENDIAN) {
        return (short)(i + (j << 8));
      }
      if (this.pT == BIG_ENDIAN) {
        return (short)((i << 8) + j);
      }
      throw new IOException("Invalid byte order: " + this.pT);
    }
    
    public final String readUTF()
    {
      this.mPosition += 2;
      return this.pS.readUTF();
    }
    
    public final int readUnsignedByte()
    {
      this.mPosition += 1;
      return this.pS.readUnsignedByte();
    }
    
    public final int readUnsignedShort()
    {
      this.mPosition += 2;
      if (this.mPosition > this.mLength) {
        throw new EOFException();
      }
      int i = this.pS.read();
      int j = this.pS.read();
      if ((i | j) < 0) {
        throw new EOFException();
      }
      if (this.pT == LITTLE_ENDIAN) {
        return i + (j << 8);
      }
      if (this.pT == BIG_ENDIAN) {
        return (i << 8) + j;
      }
      throw new IOException("Invalid byte order: " + this.pT);
    }
    
    public final void seek(long paramLong)
    {
      if (this.mPosition > paramLong)
      {
        this.mPosition = 0;
        this.pS.reset();
        this.pS.mark(this.mLength);
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
        paramInt += this.pS.skipBytes(i - paramInt);
      }
      this.mPosition += paramInt;
      return paramInt;
    }
  }
  
  static final class b
    extends FilterOutputStream
  {
    ByteOrder pT;
    private final OutputStream pU;
    
    public b(OutputStream paramOutputStream, ByteOrder paramByteOrder)
    {
      super();
      this.pU = paramOutputStream;
      this.pT = paramByteOrder;
    }
    
    public final void write(byte[] paramArrayOfByte)
    {
      this.pU.write(paramArrayOfByte);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.pU.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void writeByte(int paramInt)
    {
      this.pU.write(paramInt);
    }
    
    public final void writeInt(int paramInt)
    {
      if (this.pT == ByteOrder.LITTLE_ENDIAN)
      {
        this.pU.write(paramInt >>> 0 & 0xFF);
        this.pU.write(paramInt >>> 8 & 0xFF);
        this.pU.write(paramInt >>> 16 & 0xFF);
        this.pU.write(paramInt >>> 24 & 0xFF);
      }
      while (this.pT != ByteOrder.BIG_ENDIAN) {
        return;
      }
      this.pU.write(paramInt >>> 24 & 0xFF);
      this.pU.write(paramInt >>> 16 & 0xFF);
      this.pU.write(paramInt >>> 8 & 0xFF);
      this.pU.write(paramInt >>> 0 & 0xFF);
    }
    
    public final void writeShort(short paramShort)
    {
      if (this.pT == ByteOrder.LITTLE_ENDIAN)
      {
        this.pU.write(paramShort >>> 0 & 0xFF);
        this.pU.write(paramShort >>> 8 & 0xFF);
      }
      while (this.pT != ByteOrder.BIG_ENDIAN) {
        return;
      }
      this.pU.write(paramShort >>> 8 & 0xFF);
      this.pU.write(paramShort >>> 0 & 0xFF);
    }
  }
  
  static final class c
  {
    public final int format;
    public final int pV;
    public final byte[] pW;
    
    c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this.format = paramInt1;
      this.pV = paramInt2;
      this.pW = paramArrayOfByte;
    }
    
    public static c C(String paramString)
    {
      paramString = (paramString + '\000').getBytes(a.ca());
      return new c(2, paramString.length, paramString);
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
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.pg[12] * paramArrayOfDouble.length]);
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
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.pg[3] * paramArrayOfInt.length]);
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
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.pg[4] * paramArrayOfLong.length]);
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
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.pg[5] * paramArrayOfe.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfe.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOfe[i];
        localByteBuffer.putInt((int)paramByteOrder.pZ);
        localByteBuffer.putInt((int)paramByteOrder.qa);
        i += 1;
      }
      return new c(5, paramArrayOfe.length, localByteBuffer.array());
    }
    
    public static c b(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.pg[9] * paramArrayOfInt.length]);
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
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[a.pg[10] * paramArrayOfe.length]);
      localByteBuffer.order(paramByteOrder);
      int j = paramArrayOfe.length;
      int i = 0;
      while (i < j)
      {
        paramByteOrder = paramArrayOfe[i];
        localByteBuffer.putInt((int)paramByteOrder.pZ);
        localByteBuffer.putInt((int)paramByteOrder.qa);
        i += 1;
      }
      return new c(10, paramArrayOfe.length, localByteBuffer.array());
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
      //   18: istore_2
      //   19: new 112	android/support/d/a$a
      //   22: dup
      //   23: aload_0
      //   24: getfield 23	android/support/d/a$c:pW	[B
      //   27: invokespecial 115	android/support/d/a$a:<init>	([B)V
      //   30: astore 10
      //   32: aload 10
      //   34: aload_1
      //   35: putfield 119	android/support/d/a$a:pT	Ljava/nio/ByteOrder;
      //   38: aload_0
      //   39: getfield 19	android/support/d/a$c:format	I
      //   42: istore 9
      //   44: iload 9
      //   46: tableswitch	default:+62 -> 108, 1:+69->115, 2:+158->204, 3:+289->335, 4:+330->376, 5:+373->419, 6:+69->115, 7:+158->204, 8:+430->476, 9:+474->520, 10:+518->564, 11:+577->623, 12:+622->668
      //   109: lconst_1
      //   110: invokevirtual 122	android/support/d/a$a:close	()V
      //   113: aconst_null
      //   114: areturn
      //   115: aload_0
      //   116: getfield 23	android/support/d/a$c:pW	[B
      //   119: arraylength
      //   120: iconst_1
      //   121: if_icmpne +57 -> 178
      //   124: aload_0
      //   125: getfield 23	android/support/d/a$c:pW	[B
      //   128: iconst_0
      //   129: baload
      //   130: iflt +48 -> 178
      //   133: aload_0
      //   134: getfield 23	android/support/d/a$c:pW	[B
      //   137: iconst_0
      //   138: baload
      //   139: iconst_1
      //   140: if_icmpgt +38 -> 178
      //   143: new 49	java/lang/String
      //   146: dup
      //   147: iconst_1
      //   148: newarray char
      //   150: dup
      //   151: iconst_0
      //   152: aload_0
      //   153: getfield 23	android/support/d/a$c:pW	[B
      //   156: iconst_0
      //   157: baload
      //   158: bipush 48
      //   160: iadd
      //   161: i2c
      //   162: castore
      //   163: invokespecial 125	java/lang/String:<init>	([C)V
      //   166: astore_1
      //   167: aload 10
      //   169: invokevirtual 122	android/support/d/a$a:close	()V
      //   172: aload_1
      //   173: areturn
      //   174: astore 10
      //   176: aload_1
      //   177: areturn
      //   178: new 49	java/lang/String
      //   181: dup
      //   182: aload_0
      //   183: getfield 23	android/support/d/a$c:pW	[B
      //   186: invokestatic 47	android/support/d/a:ca	()Ljava/nio/charset/Charset;
      //   189: invokespecial 128	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   192: astore_1
      //   193: aload 10
      //   195: invokevirtual 122	android/support/d/a$a:close	()V
      //   198: aload_1
      //   199: areturn
      //   200: astore 10
      //   202: aload_1
      //   203: areturn
      //   204: aload_0
      //   205: getfield 21	android/support/d/a$c:pV	I
      //   208: invokestatic 131	android/support/d/a:cb	()[B
      //   211: arraylength
      //   212: if_icmplt +540 -> 752
      //   215: iconst_0
      //   216: istore_2
      //   217: iload 4
      //   219: istore_3
      //   220: iload_2
      //   221: invokestatic 131	android/support/d/a:cb	()[B
      //   224: arraylength
      //   225: if_icmpge +19 -> 244
      //   228: aload_0
      //   229: getfield 23	android/support/d/a$c:pW	[B
      //   232: iload_2
      //   233: baload
      //   234: invokestatic 131	android/support/d/a:cb	()[B
      //   237: iload_2
      //   238: baload
      //   239: if_icmpeq +525 -> 764
      //   242: iconst_0
      //   243: istore_3
      //   244: iload_3
      //   245: ifeq +507 -> 752
      //   248: invokestatic 131	android/support/d/a:cb	()[B
      //   251: arraylength
      //   252: istore_2
      //   253: new 31	java/lang/StringBuilder
      //   256: dup
      //   257: invokespecial 32	java/lang/StringBuilder:<init>	()V
      //   260: astore_1
      //   261: iload_2
      //   262: aload_0
      //   263: getfield 21	android/support/d/a$c:pV	I
      //   266: if_icmpge +53 -> 319
      //   269: aload_0
      //   270: getfield 23	android/support/d/a$c:pW	[B
      //   273: iload_2
      //   274: baload
      //   275: istore_3
      //   276: iload_3
      //   277: ifeq +42 -> 319
      //   280: iload_3
      //   281: bipush 32
      //   283: if_icmplt +13 -> 296
      //   286: aload_1
      //   287: iload_3
      //   288: i2c
      //   289: invokevirtual 39	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   292: pop
      //   293: goto +464 -> 757
      //   296: aload_1
      //   297: bipush 63
      //   299: invokevirtual 39	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   302: pop
      //   303: goto +454 -> 757
      //   306: astore_1
      //   307: aload 10
      //   309: ifnull +8 -> 317
      //   312: aload 10
      //   314: invokevirtual 122	android/support/d/a$a:close	()V
      //   317: aconst_null
      //   318: areturn
      //   319: aload_1
      //   320: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   323: astore_1
      //   324: aload 10
      //   326: invokevirtual 122	android/support/d/a$a:close	()V
      //   329: aload_1
      //   330: areturn
      //   331: astore 10
      //   333: aload_1
      //   334: areturn
      //   335: aload_0
      //   336: getfield 21	android/support/d/a$c:pV	I
      //   339: newarray int
      //   341: astore_1
      //   342: iload_2
      //   343: aload_0
      //   344: getfield 21	android/support/d/a$c:pV	I
      //   347: if_icmpge +18 -> 365
      //   350: aload_1
      //   351: iload_2
      //   352: aload 10
      //   354: invokevirtual 135	android/support/d/a$a:readUnsignedShort	()I
      //   357: iastore
      //   358: iload_2
      //   359: iconst_1
      //   360: iadd
      //   361: istore_2
      //   362: goto -20 -> 342
      //   365: aload 10
      //   367: invokevirtual 122	android/support/d/a$a:close	()V
      //   370: aload_1
      //   371: areturn
      //   372: astore 10
      //   374: aload_1
      //   375: areturn
      //   376: aload_0
      //   377: getfield 21	android/support/d/a$c:pV	I
      //   380: newarray long
      //   382: astore_1
      //   383: iload_3
      //   384: istore_2
      //   385: iload_2
      //   386: aload_0
      //   387: getfield 21	android/support/d/a$c:pV	I
      //   390: if_icmpge +18 -> 408
      //   393: aload_1
      //   394: iload_2
      //   395: aload 10
      //   397: invokevirtual 139	android/support/d/a$a:cc	()J
      //   400: lastore
      //   401: iload_2
      //   402: iconst_1
      //   403: iadd
      //   404: istore_2
      //   405: goto -20 -> 385
      //   408: aload 10
      //   410: invokevirtual 122	android/support/d/a$a:close	()V
      //   413: aload_1
      //   414: areturn
      //   415: astore 10
      //   417: aload_1
      //   418: areturn
      //   419: aload_0
      //   420: getfield 21	android/support/d/a$c:pV	I
      //   423: anewarray 65	android/support/d/a$e
      //   426: astore_1
      //   427: iconst_0
      //   428: istore_2
      //   429: iload_2
      //   430: aload_0
      //   431: getfield 21	android/support/d/a$c:pV	I
      //   434: if_icmpge +31 -> 465
      //   437: aload_1
      //   438: iload_2
      //   439: new 65	android/support/d/a$e
      //   442: dup
      //   443: aload 10
      //   445: invokevirtual 139	android/support/d/a$a:cc	()J
      //   448: aload 10
      //   450: invokevirtual 139	android/support/d/a$a:cc	()J
      //   453: iconst_0
      //   454: invokespecial 142	android/support/d/a$e:<init>	(JJB)V
      //   457: aastore
      //   458: iload_2
      //   459: iconst_1
      //   460: iadd
      //   461: istore_2
      //   462: goto -33 -> 429
      //   465: aload 10
      //   467: invokevirtual 122	android/support/d/a$a:close	()V
      //   470: aload_1
      //   471: areturn
      //   472: astore 10
      //   474: aload_1
      //   475: areturn
      //   476: aload_0
      //   477: getfield 21	android/support/d/a$c:pV	I
      //   480: newarray int
      //   482: astore_1
      //   483: iload 5
      //   485: istore_2
      //   486: iload_2
      //   487: aload_0
      //   488: getfield 21	android/support/d/a$c:pV	I
      //   491: if_icmpge +18 -> 509
      //   494: aload_1
      //   495: iload_2
      //   496: aload 10
      //   498: invokevirtual 146	android/support/d/a$a:readShort	()S
      //   501: iastore
      //   502: iload_2
      //   503: iconst_1
      //   504: iadd
      //   505: istore_2
      //   506: goto -20 -> 486
      //   509: aload 10
      //   511: invokevirtual 122	android/support/d/a$a:close	()V
      //   514: aload_1
      //   515: areturn
      //   516: astore 10
      //   518: aload_1
      //   519: areturn
      //   520: aload_0
      //   521: getfield 21	android/support/d/a$c:pV	I
      //   524: newarray int
      //   526: astore_1
      //   527: iload 6
      //   529: istore_2
      //   530: iload_2
      //   531: aload_0
      //   532: getfield 21	android/support/d/a$c:pV	I
      //   535: if_icmpge +18 -> 553
      //   538: aload_1
      //   539: iload_2
      //   540: aload 10
      //   542: invokevirtual 149	android/support/d/a$a:readInt	()I
      //   545: iastore
      //   546: iload_2
      //   547: iconst_1
      //   548: iadd
      //   549: istore_2
      //   550: goto -20 -> 530
      //   553: aload 10
      //   555: invokevirtual 122	android/support/d/a$a:close	()V
      //   558: aload_1
      //   559: areturn
      //   560: astore 10
      //   562: aload_1
      //   563: areturn
      //   564: aload_0
      //   565: getfield 21	android/support/d/a$c:pV	I
      //   568: anewarray 65	android/support/d/a$e
      //   571: astore_1
      //   572: iconst_0
      //   573: istore_2
      //   574: iload_2
      //   575: aload_0
      //   576: getfield 21	android/support/d/a$c:pV	I
      //   579: if_icmpge +33 -> 612
      //   582: aload_1
      //   583: iload_2
      //   584: new 65	android/support/d/a$e
      //   587: dup
      //   588: aload 10
      //   590: invokevirtual 149	android/support/d/a$a:readInt	()I
      //   593: i2l
      //   594: aload 10
      //   596: invokevirtual 149	android/support/d/a$a:readInt	()I
      //   599: i2l
      //   600: iconst_0
      //   601: invokespecial 142	android/support/d/a$e:<init>	(JJB)V
      //   604: aastore
      //   605: iload_2
      //   606: iconst_1
      //   607: iadd
      //   608: istore_2
      //   609: goto -35 -> 574
      //   612: aload 10
      //   614: invokevirtual 122	android/support/d/a$a:close	()V
      //   617: aload_1
      //   618: areturn
      //   619: astore 10
      //   621: aload_1
      //   622: areturn
      //   623: aload_0
      //   624: getfield 21	android/support/d/a$c:pV	I
      //   627: newarray double
      //   629: astore_1
      //   630: iload 7
      //   632: istore_2
      //   633: iload_2
      //   634: aload_0
      //   635: getfield 21	android/support/d/a$c:pV	I
      //   638: if_icmpge +19 -> 657
      //   641: aload_1
      //   642: iload_2
      //   643: aload 10
      //   645: invokevirtual 153	android/support/d/a$a:readFloat	()F
      //   648: f2d
      //   649: dastore
      //   650: iload_2
      //   651: iconst_1
      //   652: iadd
      //   653: istore_2
      //   654: goto -21 -> 633
      //   657: aload 10
      //   659: invokevirtual 122	android/support/d/a$a:close	()V
      //   662: aload_1
      //   663: areturn
      //   664: astore 10
      //   666: aload_1
      //   667: areturn
      //   668: aload_0
      //   669: getfield 21	android/support/d/a$c:pV	I
      //   672: newarray double
      //   674: astore_1
      //   675: iload 8
      //   677: istore_2
      //   678: iload_2
      //   679: aload_0
      //   680: getfield 21	android/support/d/a$c:pV	I
      //   683: if_icmpge +18 -> 701
      //   686: aload_1
      //   687: iload_2
      //   688: aload 10
      //   690: invokevirtual 157	android/support/d/a$a:readDouble	()D
      //   693: dastore
      //   694: iload_2
      //   695: iconst_1
      //   696: iadd
      //   697: istore_2
      //   698: goto -20 -> 678
      //   701: aload 10
      //   703: invokevirtual 122	android/support/d/a$a:close	()V
      //   706: aload_1
      //   707: areturn
      //   708: astore 10
      //   710: aload_1
      //   711: areturn
      //   712: astore_1
      //   713: aconst_null
      //   714: astore 10
      //   716: aload 10
      //   718: ifnull +8 -> 726
      //   721: aload 10
      //   723: invokevirtual 122	android/support/d/a$a:close	()V
      //   726: aload_1
      //   727: athrow
      //   728: astore_1
      //   729: goto -616 -> 113
      //   732: astore_1
      //   733: goto -416 -> 317
      //   736: astore 10
      //   738: goto -12 -> 726
      //   741: astore_1
      //   742: goto -26 -> 716
      //   745: astore_1
      //   746: aconst_null
      //   747: astore 10
      //   749: goto -442 -> 307
      //   752: iconst_0
      //   753: istore_2
      //   754: goto -501 -> 253
      //   757: iload_2
      //   758: iconst_1
      //   759: iadd
      //   760: istore_2
      //   761: goto -500 -> 261
      //   764: iload_2
      //   765: iconst_1
      //   766: iadd
      //   767: istore_2
      //   768: goto -551 -> 217
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	771	0	this	c
      //   0	771	1	paramByteOrder	ByteOrder
      //   18	750	2	i	int
      //   4	380	3	j	int
      //   1	217	4	k	int
      //   6	478	5	m	int
      //   9	519	6	n	int
      //   12	619	7	i1	int
      //   15	661	8	i2	int
      //   42	3	9	i3	int
      //   30	138	10	locala	a.a
      //   174	20	10	localIOException1	IOException
      //   200	125	10	localIOException2	IOException
      //   331	35	10	localIOException3	IOException
      //   372	37	10	localIOException4	IOException
      //   415	51	10	localIOException5	IOException
      //   472	38	10	localIOException6	IOException
      //   516	38	10	localIOException7	IOException
      //   560	53	10	localIOException8	IOException
      //   619	39	10	localIOException9	IOException
      //   664	38	10	localIOException10	IOException
      //   708	1	10	localIOException11	IOException
      //   714	8	10	localObject1	Object
      //   736	1	10	localIOException12	IOException
      //   747	1	10	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   167	172	174	java/io/IOException
      //   193	198	200	java/io/IOException
      //   32	44	306	java/io/IOException
      //   115	167	306	java/io/IOException
      //   178	193	306	java/io/IOException
      //   204	215	306	java/io/IOException
      //   220	242	306	java/io/IOException
      //   248	253	306	java/io/IOException
      //   253	261	306	java/io/IOException
      //   261	276	306	java/io/IOException
      //   286	293	306	java/io/IOException
      //   296	303	306	java/io/IOException
      //   319	324	306	java/io/IOException
      //   335	342	306	java/io/IOException
      //   342	358	306	java/io/IOException
      //   376	383	306	java/io/IOException
      //   385	401	306	java/io/IOException
      //   419	427	306	java/io/IOException
      //   429	458	306	java/io/IOException
      //   476	483	306	java/io/IOException
      //   486	502	306	java/io/IOException
      //   520	527	306	java/io/IOException
      //   530	546	306	java/io/IOException
      //   564	572	306	java/io/IOException
      //   574	605	306	java/io/IOException
      //   623	630	306	java/io/IOException
      //   633	650	306	java/io/IOException
      //   668	675	306	java/io/IOException
      //   678	694	306	java/io/IOException
      //   324	329	331	java/io/IOException
      //   365	370	372	java/io/IOException
      //   408	413	415	java/io/IOException
      //   465	470	472	java/io/IOException
      //   509	514	516	java/io/IOException
      //   553	558	560	java/io/IOException
      //   612	617	619	java/io/IOException
      //   657	662	664	java/io/IOException
      //   701	706	708	java/io/IOException
      //   19	32	712	finally
      //   108	113	728	java/io/IOException
      //   312	317	732	java/io/IOException
      //   721	726	736	java/io/IOException
      //   32	44	741	finally
      //   115	167	741	finally
      //   178	193	741	finally
      //   204	215	741	finally
      //   220	242	741	finally
      //   248	253	741	finally
      //   253	261	741	finally
      //   261	276	741	finally
      //   286	293	741	finally
      //   296	303	741	finally
      //   319	324	741	finally
      //   335	342	741	finally
      //   342	358	741	finally
      //   376	383	741	finally
      //   385	401	741	finally
      //   419	427	741	finally
      //   429	458	741	finally
      //   476	483	741	finally
      //   486	502	741	finally
      //   520	527	741	finally
      //   530	546	741	finally
      //   564	572	741	finally
      //   574	605	741	finally
      //   623	630	741	finally
      //   633	650	741	finally
      //   668	675	741	finally
      //   678	694	741	finally
      //   19	32	745	java/io/IOException
    }
    
    public final double b(ByteOrder paramByteOrder)
    {
      paramByteOrder = a(paramByteOrder);
      if (paramByteOrder == null) {
        throw new NumberFormatException("NULL can't be converted to a double value");
      }
      if ((paramByteOrder instanceof String)) {
        return Double.parseDouble((String)paramByteOrder);
      }
      if ((paramByteOrder instanceof long[]))
      {
        paramByteOrder = (long[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
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
      if ((paramByteOrder instanceof double[]))
      {
        paramByteOrder = (double[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      if ((paramByteOrder instanceof a.e[]))
      {
        paramByteOrder = (a.e[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0].cd();
        }
        throw new NumberFormatException("There are more than one component");
      }
      throw new NumberFormatException("Couldn't find a double value");
    }
    
    public final int c(ByteOrder paramByteOrder)
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
    
    public final String d(ByteOrder paramByteOrder)
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
          paramByteOrder.append(localObject[i].pZ);
          paramByteOrder.append('/');
          paramByteOrder.append(localObject[i].qa);
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
      return a.pg[this.format] * this.pV;
    }
    
    public final String toString()
    {
      return "(" + a.pe[this.format] + ", data length:" + this.pW.length + ")";
    }
  }
  
  static final class d
  {
    public final String name;
    public final int number;
    public final int pX;
    public final int pY;
    
    private d(String paramString, int paramInt)
    {
      this.name = paramString;
      this.number = paramInt;
      this.pX = 3;
      this.pY = 4;
    }
    
    private d(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.number = paramInt1;
      this.pX = paramInt2;
      this.pY = -1;
    }
    
    final boolean T(int paramInt)
    {
      if ((this.pX == 7) || (paramInt == 7)) {}
      while ((this.pX == paramInt) || (this.pY == paramInt) || (((this.pX == 4) || (this.pY == 4)) && ((paramInt == 3) || (((this.pX == 9) || (this.pY == 9)) && ((paramInt == 8) || (((this.pX == 12) || (this.pY == 12)) && (paramInt == 11))))))) {
        return true;
      }
      return false;
    }
  }
  
  static final class e
  {
    public final long pZ;
    public final long qa;
    
    private e(double paramDouble)
    {
      this((10000.0D * paramDouble), 10000L);
    }
    
    private e(long paramLong1, long paramLong2)
    {
      if (paramLong2 == 0L)
      {
        this.pZ = 0L;
        this.qa = 1L;
        return;
      }
      this.pZ = paramLong1;
      this.qa = paramLong2;
    }
    
    public final double cd()
    {
      return this.pZ / this.qa;
    }
    
    public final String toString()
    {
      return this.pZ + "/" + this.qa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.d.a
 * JD-Core Version:    0.7.0.1
 */