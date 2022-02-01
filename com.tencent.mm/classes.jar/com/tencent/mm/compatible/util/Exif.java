package com.tencent.mm.compatible.util;

import androidx.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exif
{
  public static final int PARSE_EXIF_ERROR_CORRUPT = 1985;
  public static final int PARSE_EXIF_ERROR_NO_EXIF = 1983;
  public static final int PARSE_EXIF_ERROR_NO_JPEG = 1982;
  public static final int PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN = 1984;
  public static final int PARSE_EXIF_SUCCESS = 0;
  private static final String TAG = "MicroMsg.Exif";
  public double altitude = 0.0D;
  public short bitsPerSample;
  public String copyright;
  public String dateTime;
  public String dateTimeDigitized;
  public String dateTimeOriginal;
  public double exposureBiasValue;
  public double exposureTime;
  public double fNumber;
  public int fileSource;
  public byte flash;
  public double focalLength;
  public short focalLengthIn35mm;
  public String imageDescription;
  public int imageHeight;
  public int imageWidth;
  public short isoSpeedRatings;
  public double latitude = -1.0D;
  public double longitude = -1.0D;
  private a mExif;
  public String make;
  public short meteringMode;
  public String model;
  public short orientation;
  public int sceneType;
  public double shutterSpeedValue;
  public String software;
  public String subSecTimeOriginal;
  public double subjectDistance;
  public String yCbCrSubSampling;
  
  public static Exif fromFile(String paramString)
  {
    AppMethodBeat.i(155900);
    Exif localExif = new Exif();
    localExif.parseFromFile(paramString);
    AppMethodBeat.o(155900);
    return localExif;
  }
  
  public static Exif fromStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(155901);
    Exif localExif = new Exif();
    localExif.parseFromStream(paramInputStream);
    AppMethodBeat.o(155901);
    return localExif;
  }
  
  private void readExifFromInterface()
  {
    int i = -1;
    AppMethodBeat.i(155896);
    if (this.mExif == null)
    {
      AppMethodBeat.o(155896);
      return;
    }
    this.imageDescription = this.mExif.getAttribute("ImageDescription");
    this.make = this.mExif.getAttribute("Make");
    this.model = this.mExif.getAttribute("Model");
    this.orientation = ((short)this.mExif.getAttributeInt("Orientation", 0));
    this.bitsPerSample = ((short)this.mExif.getAttributeInt("BitsPerSample", 0));
    this.software = this.mExif.getAttribute("Software");
    this.dateTime = this.mExif.getAttribute("DateTime");
    this.dateTimeOriginal = this.mExif.getAttribute("DateTimeOriginal");
    this.dateTimeDigitized = this.mExif.getAttribute("DateTimeDigitized");
    this.subSecTimeOriginal = this.mExif.getAttribute("SubSecTimeOriginal");
    this.copyright = this.mExif.getAttribute("Copyright");
    this.exposureTime = this.mExif.getAttributeDouble("ExposureTime", 0.0D);
    this.fNumber = this.mExif.getAttributeDouble("FNumber", 0.0D);
    this.isoSpeedRatings = ((short)this.mExif.getAttributeInt("ISOSpeedRatings", 0));
    this.flash = ((byte)this.mExif.getAttributeInt("Flash", 0));
    this.imageWidth = this.mExif.getAttributeInt("ImageWidth", 0);
    this.imageHeight = this.mExif.getAttributeInt("ImageLength", 0);
    this.fileSource = this.mExif.getAttributeInt("FileSource", 0);
    this.sceneType = this.mExif.getAttributeInt("SceneType", 0);
    Object localObject = this.mExif.nu();
    if (localObject != null)
    {
      this.latitude = localObject[0];
      this.longitude = localObject[1];
    }
    localObject = this.mExif;
    double d = ((a)localObject).getAttributeDouble("GPSAltitude", -1.0D);
    int j = ((a)localObject).getAttributeInt("GPSAltitudeRef", -1);
    if ((d >= 0.0D) && (j >= 0)) {
      if (j != 1) {}
    }
    for (d = i * d;; d = 0.0D)
    {
      this.altitude = d;
      AppMethodBeat.o(155896);
      return;
      i = 1;
      break;
    }
  }
  
  public a getLocation()
  {
    AppMethodBeat.i(155898);
    if ((this.latitude < 0.0D) || (this.longitude < 0.0D))
    {
      AppMethodBeat.o(155898);
      return null;
    }
    a locala = new a(this.latitude, this.longitude, this.altitude);
    AppMethodBeat.o(155898);
    return locala;
  }
  
  public int getOrientationInDegree()
  {
    AppMethodBeat.i(155897);
    if (this.mExif != null)
    {
      switch (this.mExif.getAttributeInt("Orientation", 1))
      {
      default: 
        AppMethodBeat.o(155897);
        return 0;
      case 6: 
      case 7: 
        AppMethodBeat.o(155897);
        return 90;
      case 3: 
      case 4: 
        AppMethodBeat.o(155897);
        return 180;
      }
      AppMethodBeat.o(155897);
      return 270;
    }
    switch (this.orientation)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      AppMethodBeat.o(155897);
      return 0;
    case 6: 
      AppMethodBeat.o(155897);
      return 90;
    case 3: 
      AppMethodBeat.o(155897);
      return 180;
    }
    AppMethodBeat.o(155897);
    return 270;
  }
  
  public long getUxtimeDatatimeOriginal()
  {
    AppMethodBeat.i(155899);
    try
    {
      String str = this.dateTimeOriginal;
      if (str == null)
      {
        AppMethodBeat.o(155899);
        return 0L;
      }
      long l = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(this.dateTimeOriginal).getTime() / 1000L;
      AppMethodBeat.o(155899);
      return l;
    }
    catch (ParseException localParseException)
    {
      Log.printErrStackTrace("MicroMsg.Exif", localParseException, "", new Object[0]);
      AppMethodBeat.o(155899);
    }
    return 0L;
  }
  
  public int parseFrom(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(155894);
    int i = parseFromStream(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(155894);
    return i;
  }
  
  public int parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155895);
    paramInt1 = parseFromStream(new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
    AppMethodBeat.o(155895);
    return paramInt1;
  }
  
  public int parseFromFile(String paramString)
  {
    AppMethodBeat.i(155892);
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      InputStream localInputStream = s.openRead(paramString);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      this.mExif = new a(localInputStream);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      readExifFromInterface();
      return 0;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      Log.w("MicroMsg.Exif", "Cannot read EXIF from file '%s': %s", new Object[] { paramString, localException.getMessage() });
      return -1;
    }
    finally
    {
      Util.qualityClose(localObject2);
      AppMethodBeat.o(155892);
    }
  }
  
  public int parseFromStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(155893);
    try
    {
      this.mExif = new a(paramInputStream);
      readExifFromInterface();
      AppMethodBeat.o(155893);
      return 0;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.Exif", "Cannot read EXIF from stream '%s': %s", new Object[] { paramInputStream, localException.getMessage() });
      AppMethodBeat.o(155893);
    }
    return -1;
  }
  
  public static final class a
  {
    public double altitude;
    public double latitude;
    public double longitude;
    
    public a(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
      this.altitude = paramDouble3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.Exif
 * JD-Core Version:    0.7.0.1
 */