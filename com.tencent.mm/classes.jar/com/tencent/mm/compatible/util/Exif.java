package com.tencent.mm.compatible.util;

import androidx.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
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
    AppMethodBeat.i(155896);
    if (this.mExif == null)
    {
      AppMethodBeat.o(155896);
      return;
    }
    this.imageDescription = this.mExif.aC("ImageDescription");
    this.make = this.mExif.aC("Make");
    this.model = this.mExif.aC("Model");
    this.orientation = ((short)this.mExif.k("Orientation", 0));
    this.bitsPerSample = ((short)this.mExif.k("BitsPerSample", 0));
    this.software = this.mExif.aC("Software");
    this.dateTime = this.mExif.aC("DateTime");
    this.dateTimeOriginal = this.mExif.aC("DateTimeOriginal");
    this.dateTimeDigitized = this.mExif.aC("DateTimeDigitized");
    this.subSecTimeOriginal = this.mExif.aC("SubSecTimeOriginal");
    this.copyright = this.mExif.aC("Copyright");
    this.exposureTime = this.mExif.a("ExposureTime", 0.0D);
    this.fNumber = this.mExif.a("FNumber", 0.0D);
    this.isoSpeedRatings = ((short)this.mExif.k("ISOSpeedRatings", 0));
    this.flash = ((byte)this.mExif.k("Flash", 0));
    this.imageWidth = this.mExif.k("ImageWidth", 0);
    this.imageHeight = this.mExif.k("ImageLength", 0);
    this.fileSource = this.mExif.k("FileSource", 0);
    this.sceneType = this.mExif.k("SceneType", 0);
    double[] arrayOfDouble = this.mExif.FP();
    if (arrayOfDouble != null)
    {
      this.latitude = arrayOfDouble[0];
      this.longitude = arrayOfDouble[1];
    }
    this.altitude = this.mExif.FQ();
    AppMethodBeat.o(155896);
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
      int i = this.mExif.iB();
      AppMethodBeat.o(155897);
      return i;
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
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      InputStream localInputStream = y.Lh(paramString);
      localObject2 = localInputStream;
      localObject3 = localInputStream;
      localObject1 = localInputStream;
      this.mExif = new a(localInputStream);
      localObject2 = localInputStream;
      localObject3 = localInputStream;
      localObject1 = localInputStream;
      readExifFromInterface();
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(155892);
      return 0;
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      Log.w("MicroMsg.Exif", "Cannot read EXIF from file '%s': %s", new Object[] { paramString, localException.getMessage() });
      Util.qualityClose(localObject2);
      AppMethodBeat.o(155892);
      return -1;
    }
    catch (OutOfMemoryError paramString)
    {
      localObject1 = localException;
      Log.printErrStackTrace("MicroMsg.Exif", paramString, "parseFromFile", new Object[0]);
      Util.qualityClose(localException);
      AppMethodBeat.o(155892);
      return 0;
    }
    finally
    {
      Util.qualityClose((Closeable)localObject1);
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
  
  public static class a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.util.Exif
 * JD-Core Version:    0.7.0.1
 */