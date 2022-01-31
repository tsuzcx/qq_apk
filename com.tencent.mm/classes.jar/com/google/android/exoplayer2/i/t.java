package com.google.android.exoplayer2.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.o;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t
{
  public static final String DEVICE;
  public static final String MANUFACTURER;
  public static final String MODEL;
  public static final int SDK_INT;
  public static final String aSS;
  private static final Pattern aST;
  private static final Pattern aSU;
  private static final Pattern aSV;
  private static final int[] aSW;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      DEVICE = Build.DEVICE;
      MANUFACTURER = Build.MANUFACTURER;
      MODEL = Build.MODEL;
      aSS = DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT;
      aST = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
      aSU = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
      aSV = Pattern.compile("%([A-Fa-f0-9]{2})");
      aSW = new int[] { 0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108 };
      return;
    }
  }
  
  public static <T> int a(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean)
  {
    int j = Collections.binarySearch(paramList, paramT);
    int i = j;
    if (j < 0) {
      i = -(j + 2);
    }
    for (;;)
    {
      j = i;
      if (paramBoolean) {
        j = Math.max(0, i);
      }
      return j;
      do
      {
        i -= 1;
      } while ((i >= 0) && (((Comparable)paramList.get(i)).compareTo(paramT) == 0));
      i += 1;
    }
  }
  
  public static int a(long[] paramArrayOfLong, long paramLong)
  {
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i = j;
    if (j < 0)
    {
      i = j ^ 0xFFFFFFFF;
      return i;
    }
    do
    {
      j = i + 1;
      i = j;
      if (j >= paramArrayOfLong.length) {
        break;
      }
      i = j;
    } while (paramArrayOfLong[j] == paramLong);
    return j;
  }
  
  public static int a(long[] paramArrayOfLong, long paramLong, boolean paramBoolean)
  {
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i = j;
    if (j < 0) {}
    for (i = -(j + 2);; i = j + 1)
    {
      j = i;
      if (paramBoolean) {
        j = Math.max(0, i);
      }
      return j;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (paramArrayOfLong[j] == paramLong);
    }
  }
  
  public static void a(f paramf)
  {
    if (paramf != null) {}
    try
    {
      paramf.close();
      return;
    }
    catch (IOException paramf) {}
  }
  
  public static ExecutorService aC(String paramString)
  {
    return Executors.newSingleThreadExecutor(new t.1(paramString));
  }
  
  public static String aD(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new Locale(paramString).getLanguage();
  }
  
  public static String aE(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase(Locale.US);
  }
  
  public static long aF(String paramString)
  {
    Matcher localMatcher = aST.matcher(paramString);
    if (!localMatcher.matches()) {
      throw new o("Invalid date/time format: " + paramString);
    }
    int i;
    if (localMatcher.group(9) == null) {
      i = 0;
    }
    for (;;)
    {
      paramString = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
      paramString.clear();
      paramString.set(Integer.parseInt(localMatcher.group(1)), Integer.parseInt(localMatcher.group(2)) - 1, Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)), Integer.parseInt(localMatcher.group(5)), Integer.parseInt(localMatcher.group(6)));
      if (!TextUtils.isEmpty(localMatcher.group(8))) {
        paramString.set(14, new BigDecimal("0." + localMatcher.group(8)).movePointRight(3).intValue());
      }
      long l2 = paramString.getTimeInMillis();
      long l1 = l2;
      if (i != 0) {
        l1 = l2 - 60000 * i;
      }
      return l1;
      if (localMatcher.group(9).equalsIgnoreCase("Z"))
      {
        i = 0;
      }
      else
      {
        i = Integer.parseInt(localMatcher.group(12)) * 60 + Integer.parseInt(localMatcher.group(13));
        if (localMatcher.group(11).equals("-")) {
          i *= -1;
        }
      }
    }
  }
  
  public static int aG(String paramString)
  {
    int k = paramString.length();
    if (k <= 4) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      a.aB(bool);
      int i = 0;
      j = 0;
      while (i < k)
      {
        j = paramString.charAt(i) | j << 8;
        i += 1;
      }
    }
    return j;
  }
  
  public static byte[] aH(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = i * 2;
      int k = Character.digit(paramString.charAt(j), 16);
      arrayOfByte[i] = ((byte)(Character.digit(paramString.charAt(j + 1), 16) + (k << 4)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int aJ(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  public static int aK(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException();
    case 2: 
      i = paramInt2 * 2;
    case 3: 
      return i;
    case -2147483648: 
      return paramInt2 * 3;
    }
    return paramInt2 * 4;
  }
  
  public static long b(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 >= paramLong2) && (paramLong3 % paramLong2 == 0L)) {
      return paramLong1 / (paramLong3 / paramLong2);
    }
    if ((paramLong3 < paramLong2) && (paramLong2 % paramLong3 == 0L)) {
      return paramLong2 / paramLong3 * paramLong1;
    }
    return (paramLong2 / paramLong3 * paramLong1);
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean dE(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 13);
  }
  
  public static int dF(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 11: 
    case 12: 
    case 14: 
    default: 
      return 3;
    case 13: 
      return 1;
    case 2: 
      return 0;
    case 3: 
      return 8;
    case 4: 
      return 4;
    case 6: 
      return 2;
    }
    return 5;
  }
  
  public static int dG(int paramInt)
  {
    int i = 131072;
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      i = 16777216;
    case 3: 
    case 4: 
      return i;
    case 1: 
      return 3538944;
    }
    return 13107200;
  }
  
  public static boolean e(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean f(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return (TextUtils.isEmpty(paramUri)) || (paramUri.equals("file"));
  }
  
  public static float h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
  }
  
  public static String i(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramString + "/" + paramContext + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.5.4";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = "?";
      }
    }
  }
  
  public static int l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      i = i << 8 ^ aSW[((i >>> 24 ^ paramArrayOfByte[paramInt2] & 0xFF) & 0xFF)];
      paramInt2 += 1;
    }
    return i;
  }
  
  public static int t(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt1, paramInt3));
  }
  
  public static int[] v(List<Integer> paramList)
  {
    if (paramList == null) {
      return null;
    }
    int j = paramList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.t
 * JD-Core Version:    0.7.0.1
 */