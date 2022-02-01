package androidx.camera.core.impl.a;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.al;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
{
  static final String[] Ok;
  private static final i[] Oq;
  private static final i[] Os;
  private static final i[] Ot;
  static final i[] Ou;
  private static final i[] Ov;
  static final i[][] Ow;
  static final HashSet<String> Ox;
  final ByteOrder NZ;
  private final List<Map<String, f>> Oy;
  
  static
  {
    AppMethodBeat.i(199003);
    Ok = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
    Oq = new i[] { new i("ImageWidth", 256, 3, 4), new i("ImageLength", 257, 3, 4), new i("Make", 271, 2), new i("Model", 272, 2), new i("Orientation", 274, 3), new i("XResolution", 282, 5), new i("YResolution", 283, 5), new i("ResolutionUnit", 296, 3), new i("Software", 305, 2), new i("DateTime", 306, 2), new i("YCbCrPositioning", 531, 3), new i("SubIFDPointer", 330, 4), new i("ExifIFDPointer", 34665, 4), new i("GPSInfoIFDPointer", 34853, 4) };
    Os = new i[] { new i("ExposureTime", 33434, 5), new i("FNumber", 33437, 5), new i("ExposureProgram", 34850, 3), new i("PhotographicSensitivity", 34855, 3), new i("SensitivityType", 34864, 3), new i("ExifVersion", 36864, 2), new i("DateTimeOriginal", 36867, 2), new i("DateTimeDigitized", 36868, 2), new i("ComponentsConfiguration", 37121, 7), new i("ShutterSpeedValue", 37377, 10), new i("ApertureValue", 37378, 5), new i("BrightnessValue", 37379, 10), new i("ExposureBiasValue", 37380, 10), new i("MaxApertureValue", 37381, 5), new i("MeteringMode", 37383, 3), new i("LightSource", 37384, 3), new i("Flash", 37385, 3), new i("FocalLength", 37386, 5), new i("SubSecTime", 37520, 2), new i("SubSecTimeOriginal", 37521, 2), new i("SubSecTimeDigitized", 37522, 2), new i("FlashpixVersion", 40960, 7), new i("ColorSpace", 40961, 3), new i("PixelXDimension", 40962, 3, 4), new i("PixelYDimension", 40963, 3, 4), new i("InteroperabilityIFDPointer", 40965, 4), new i("FocalPlaneResolutionUnit", 41488, 3), new i("SensingMethod", 41495, 3), new i("FileSource", 41728, 7), new i("SceneType", 41729, 7), new i("CustomRendered", 41985, 3), new i("ExposureMode", 41986, 3), new i("WhiteBalance", 41987, 3), new i("SceneCaptureType", 41990, 3), new i("Contrast", 41992, 3), new i("Saturation", 41993, 3), new i("Sharpness", 41994, 3) };
    Ot = new i[] { new i("GPSVersionID", 0, 1), new i("GPSLatitudeRef", 1, 2), new i("GPSLatitude", 2, 5, 10), new i("GPSLongitudeRef", 3, 2), new i("GPSLongitude", 4, 5, 10), new i("GPSAltitudeRef", 5, 1), new i("GPSAltitude", 6, 5), new i("GPSTimeStamp", 7, 5), new i("GPSSpeedRef", 12, 2), new i("GPSTrackRef", 14, 2), new i("GPSImgDirectionRef", 16, 2), new i("GPSDestBearingRef", 23, 2), new i("GPSDestDistanceRef", 25, 2) };
    Ou = new i[] { new i("SubIFDPointer", 330, 4), new i("ExifIFDPointer", 34665, 4), new i("GPSInfoIFDPointer", 34853, 4), new i("InteroperabilityIFDPointer", 40965, 4) };
    Ov = new i[] { new i("InteroperabilityIndex", 1, 2) };
    Ow = new i[][] { Oq, Os, Ot, Ov };
    Ox = new HashSet(Arrays.asList(new String[] { "FNumber", "ExposureTime", "GPSTimeStamp" }));
    AppMethodBeat.o(199003);
  }
  
  g(ByteOrder paramByteOrder, List<Map<String, f>> paramList)
  {
    AppMethodBeat.i(198977);
    if (paramList.size() == Ow.length) {}
    for (boolean bool = true;; bool = false)
    {
      androidx.core.f.f.b(bool, "Malformed attributes list. Number of IFDs mismatch.");
      this.NZ = paramByteOrder;
      this.Oy = paramList;
      AppMethodBeat.o(198977);
      return;
    }
  }
  
  public static a kM()
  {
    AppMethodBeat.i(198985);
    a locala = new a(ByteOrder.BIG_ENDIAN).l("Orientation", "1").l("XResolution", "72/1").l("YResolution", "72/1").l("ResolutionUnit", "2").l("YCbCrPositioning", "1").l("Make", Build.MANUFACTURER).l("Model", Build.MODEL);
    AppMethodBeat.o(198985);
    return locala;
  }
  
  final Map<String, f> aZ(int paramInt)
  {
    AppMethodBeat.i(199010);
    androidx.core.f.f.b(paramInt, 0, Ow.length, "Invalid IFD index: " + paramInt + ". Index should be between [0, EXIF_TAGS.length] ");
    Map localMap = (Map)this.Oy.get(paramInt);
    AppMethodBeat.o(199010);
    return localMap;
  }
  
  public static final class a
  {
    private static final Pattern OB;
    private static final Pattern OC;
    private static final Pattern OD;
    static final List<HashMap<String, i>> OE;
    private final ByteOrder NZ;
    final List<Map<String, f>> Oy;
    
    static
    {
      AppMethodBeat.i(199154);
      OB = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
      OC = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
      OD = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
      OE = Collections.list(new Enumeration()
      {
        int OF = 0;
        
        public final boolean hasMoreElements()
        {
          return this.OF < g.Ow.length;
        }
      });
      AppMethodBeat.o(199154);
    }
    
    a(ByteOrder paramByteOrder)
    {
      AppMethodBeat.i(199115);
      this.Oy = Collections.list(new Enumeration()
      {
        int OF = 0;
        
        public final boolean hasMoreElements()
        {
          return this.OF < g.Ow.length;
        }
      });
      this.NZ = paramByteOrder;
      AppMethodBeat.o(199115);
    }
    
    private void a(String paramString1, String paramString2, List<Map<String, f>> paramList)
    {
      AppMethodBeat.i(199126);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((Map)localIterator.next()).containsKey(paramString1))
        {
          AppMethodBeat.o(199126);
          return;
        }
      }
      b(paramString1, paramString2, paramList);
      AppMethodBeat.o(199126);
    }
    
    private static Pair<Integer, Integer> af(String paramString)
    {
      AppMethodBeat.i(199149);
      Object localObject;
      int i;
      Pair localPair;
      if (paramString.contains(","))
      {
        localObject = paramString.split(",", -1);
        paramString = af(localObject[0]);
        if (((Integer)paramString.first).intValue() == 2)
        {
          AppMethodBeat.o(199149);
          return paramString;
        }
        i = 1;
        if (i < localObject.length)
        {
          localPair = af(localObject[i]);
          if ((!((Integer)localPair.first).equals(paramString.first)) && (!((Integer)localPair.second).equals(paramString.first))) {
            break label606;
          }
        }
      }
      label606:
      for (int j = ((Integer)paramString.first).intValue();; j = -1)
      {
        if ((((Integer)paramString.second).intValue() != -1) && ((((Integer)localPair.first).equals(paramString.second)) || (((Integer)localPair.second).equals(paramString.second)))) {}
        for (int k = ((Integer)paramString.second).intValue();; k = -1)
        {
          if ((j == -1) && (k == -1))
          {
            paramString = new Pair(Integer.valueOf(2), Integer.valueOf(-1));
            AppMethodBeat.o(199149);
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
              AppMethodBeat.o(199149);
              return paramString;
              long l1;
              if (paramString.contains("/"))
              {
                paramString = paramString.split("/", -1);
                if (paramString.length == 2) {
                  try
                  {
                    l1 = Double.parseDouble(paramString[0]);
                    long l2 = Double.parseDouble(paramString[1]);
                    if ((l1 < 0L) || (l2 < 0L))
                    {
                      paramString = new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                      AppMethodBeat.o(199149);
                      return paramString;
                    }
                    if ((l1 > 2147483647L) || (l2 > 2147483647L))
                    {
                      paramString = new Pair(Integer.valueOf(5), Integer.valueOf(-1));
                      AppMethodBeat.o(199149);
                      return paramString;
                    }
                    paramString = new Pair(Integer.valueOf(10), Integer.valueOf(5));
                    AppMethodBeat.o(199149);
                    return paramString;
                  }
                  catch (NumberFormatException paramString) {}
                }
                paramString = new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                AppMethodBeat.o(199149);
                return paramString;
              }
              try
              {
                l1 = Long.parseLong(paramString);
                if ((l1 >= 0L) && (l1 <= 65535L))
                {
                  localObject = new Pair(Integer.valueOf(3), Integer.valueOf(4));
                  AppMethodBeat.o(199149);
                  return localObject;
                }
                if (l1 < 0L)
                {
                  localObject = new Pair(Integer.valueOf(9), Integer.valueOf(-1));
                  AppMethodBeat.o(199149);
                  return localObject;
                }
                localObject = new Pair(Integer.valueOf(4), Integer.valueOf(-1));
                AppMethodBeat.o(199149);
                return localObject;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                try
                {
                  Double.parseDouble(paramString);
                  paramString = new Pair(Integer.valueOf(12), Integer.valueOf(-1));
                  AppMethodBeat.o(199149);
                  return paramString;
                }
                catch (NumberFormatException paramString)
                {
                  paramString = new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                  AppMethodBeat.o(199149);
                  return paramString;
                }
              }
            }
          }
        }
      }
    }
    
    private void b(String paramString1, String paramString2, List<Map<String, f>> paramList)
    {
      AppMethodBeat.i(199142);
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
            al.R("ExifData");
            AppMethodBeat.o(199142);
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
        if (g.Ox.contains(paramString2))
        {
          if (!paramString2.equals("GPSTimeStamp")) {
            break label379;
          }
          paramString1 = OB.matcher((CharSequence)localObject1);
          if (!paramString1.find())
          {
            new StringBuilder("Invalid value for ").append(paramString2).append(" : ").append((String)localObject1);
            al.R("ExifData");
            AppMethodBeat.o(199142);
            return;
          }
          paramString1 = Integer.parseInt((String)androidx.core.f.f.checkNotNull(paramString1.group(1))) + "/1," + Integer.parseInt((String)androidx.core.f.f.checkNotNull(paramString1.group(2))) + "/1," + Integer.parseInt((String)androidx.core.f.f.checkNotNull(paramString1.group(3))) + "/1";
        }
      }
      int j = 0;
      if (j < g.Ow.length)
      {
        localObject1 = (i)((HashMap)OE.get(j)).get(paramString2);
        if (localObject1 != null)
        {
          if (paramString1 != null) {
            break label434;
          }
          ((Map)paramList.get(j)).remove(paramString2);
        }
        for (;;)
        {
          for (;;)
          {
            j += 1;
            break;
            try
            {
              label379:
              paramString1 = new j(Double.parseDouble((String)localObject1)).toString();
            }
            catch (NumberFormatException paramString1)
            {
              new StringBuilder("Invalid value for ").append(paramString2).append(" : ").append((String)localObject1);
              al.S("ExifData");
              AppMethodBeat.o(199142);
              return;
            }
          }
          label434:
          Object localObject2 = af(paramString1);
          if ((((i)localObject1).OU == ((Integer)((Pair)localObject2).first).intValue()) || (((i)localObject1).OU == ((Integer)((Pair)localObject2).second).intValue())) {
            i = ((i)localObject1).OU;
          }
          for (;;)
          {
            switch (i)
            {
            case 6: 
            case 8: 
            case 11: 
            default: 
              break;
            case 1: 
              ((Map)paramList.get(j)).put(paramString2, f.ad(paramString1));
              break;
              if ((((i)localObject1).OV != -1) && ((((i)localObject1).OV == ((Integer)((Pair)localObject2).first).intValue()) || (((i)localObject1).OV == ((Integer)((Pair)localObject2).second).intValue())))
              {
                i = ((i)localObject1).OV;
              }
              else
              {
                if ((((i)localObject1).OU != 1) && (((i)localObject1).OU != 7) && (((i)localObject1).OU != 2)) {
                  break;
                }
                i = ((i)localObject1).OU;
              }
              break;
            }
          }
          ((Map)paramList.get(j)).put(paramString2, f.ae(paramString1));
          continue;
          localObject1 = paramString1.split(",", -1);
          localObject2 = new int[localObject1.length];
          int i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Integer.parseInt(localObject1[i]);
            i += 1;
          }
          ((Map)paramList.get(j)).put(paramString2, f.a((int[])localObject2, this.NZ));
          continue;
          localObject1 = paramString1.split(",", -1);
          localObject2 = new int[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Integer.parseInt(localObject1[i]);
            i += 1;
          }
          ((Map)paramList.get(j)).put(paramString2, f.b((int[])localObject2, this.NZ));
          continue;
          localObject1 = paramString1.split(",", -1);
          localObject2 = new long[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Long.parseLong(localObject1[i]);
            i += 1;
          }
          ((Map)paramList.get(j)).put(paramString2, f.a((long[])localObject2, this.NZ));
          continue;
          localObject1 = paramString1.split(",", -1);
          localObject2 = new j[localObject1.length];
          i = 0;
          String[] arrayOfString;
          while (i < localObject1.length)
          {
            arrayOfString = localObject1[i].split("/", -1);
            localObject2[i] = new j(Double.parseDouble(arrayOfString[0]), Double.parseDouble(arrayOfString[1]));
            i += 1;
          }
          ((Map)paramList.get(j)).put(paramString2, f.a((j[])localObject2, this.NZ));
          continue;
          localObject1 = paramString1.split(",", -1);
          localObject2 = new j[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            arrayOfString = localObject1[i].split("/", -1);
            localObject2[i] = new j(Double.parseDouble(arrayOfString[0]), Double.parseDouble(arrayOfString[1]));
            i += 1;
          }
          ((Map)paramList.get(j)).put(paramString2, f.b((j[])localObject2, this.NZ));
          continue;
          localObject1 = paramString1.split(",", -1);
          localObject2 = new double[localObject1.length];
          i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = Double.parseDouble(localObject1[i]);
            i += 1;
          }
          ((Map)paramList.get(j)).put(paramString2, f.a((double[])localObject2, this.NZ));
        }
      }
      AppMethodBeat.o(199142);
    }
    
    public final a bc(int paramInt)
    {
      AppMethodBeat.i(199159);
      a locala = l("ImageWidth", String.valueOf(paramInt));
      AppMethodBeat.o(199159);
      return locala;
    }
    
    public final a bd(int paramInt)
    {
      AppMethodBeat.i(199164);
      a locala = l("ImageLength", String.valueOf(paramInt));
      AppMethodBeat.o(199164);
      return locala;
    }
    
    public final a be(int paramInt)
    {
      AppMethodBeat.i(199169);
      switch (paramInt)
      {
      default: 
        new StringBuilder("Unexpected orientation value: ").append(paramInt).append(". Must be one of 0, 90, 180, 270.");
        al.R("ExifData");
        paramInt = 0;
      }
      for (;;)
      {
        a locala = l("Orientation", String.valueOf(paramInt));
        AppMethodBeat.o(199169);
        return locala;
        paramInt = 1;
        continue;
        paramInt = 6;
        continue;
        paramInt = 3;
        continue;
        paramInt = 8;
      }
    }
    
    public final g kN()
    {
      AppMethodBeat.i(199177);
      Object localObject = Collections.list(new Enumeration()
      {
        final Enumeration<Map<String, f>> OH;
        
        public final boolean hasMoreElements()
        {
          AppMethodBeat.i(198961);
          boolean bool = this.OH.hasMoreElements();
          AppMethodBeat.o(198961);
          return bool;
        }
      });
      if (!((Map)((List)localObject).get(1)).isEmpty())
      {
        a("ExposureProgram", "0", (List)localObject);
        a("ExifVersion", "0230", (List)localObject);
        a("ComponentsConfiguration", "1,2,3,0", (List)localObject);
        a("MeteringMode", "0", (List)localObject);
        a("LightSource", "0", (List)localObject);
        a("FlashpixVersion", "0100", (List)localObject);
        a("FocalPlaneResolutionUnit", "2", (List)localObject);
        a("FileSource", "3", (List)localObject);
        a("SceneType", "1", (List)localObject);
        a("CustomRendered", "0", (List)localObject);
        a("SceneCaptureType", "0", (List)localObject);
        a("Contrast", "0", (List)localObject);
        a("Saturation", "0", (List)localObject);
        a("Sharpness", "0", (List)localObject);
      }
      if (!((Map)((List)localObject).get(2)).isEmpty())
      {
        a("GPSVersionID", "2300", (List)localObject);
        a("GPSSpeedRef", "K", (List)localObject);
        a("GPSTrackRef", "T", (List)localObject);
        a("GPSImgDirectionRef", "T", (List)localObject);
        a("GPSDestBearingRef", "T", (List)localObject);
        a("GPSDestDistanceRef", "K", (List)localObject);
      }
      localObject = new g(this.NZ, (List)localObject);
      AppMethodBeat.o(199177);
      return localObject;
    }
    
    public final a l(String paramString1, String paramString2)
    {
      AppMethodBeat.i(199173);
      b(paramString1, paramString2, this.Oy);
      AppMethodBeat.o(199173);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.g
 * JD-Core Version:    0.7.0.1
 */