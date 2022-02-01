package com.google.android.exoplayer2.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class x
{
  public static final String DEVICE;
  public static final String MANUFACTURER;
  public static final String MODEL;
  public static final int SDK_INT;
  public static final String bHH;
  private static final Pattern bHI;
  private static final Pattern bHJ;
  private static final Pattern bHK;
  private static final int[] bHL;
  
  static
  {
    AppMethodBeat.i(93244);
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      DEVICE = Build.DEVICE;
      MANUFACTURER = Build.MANUFACTURER;
      MODEL = Build.MODEL;
      bHH = DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT;
      bHI = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
      bHJ = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
      bHK = Pattern.compile("%([A-Fa-f0-9]{2})");
      bHL = new int[] { 0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108 };
      AppMethodBeat.o(93244);
      return;
    }
  }
  
  public static <T> int a(List<? extends Comparable<? super T>> paramList, T paramT, boolean paramBoolean)
  {
    AppMethodBeat.i(93230);
    int j = Collections.binarySearch(paramList, paramT);
    int i = j;
    if (j < 0) {
      i = -(j + 2);
    }
    while (paramBoolean)
    {
      i = Math.max(0, i);
      AppMethodBeat.o(93230);
      return i;
      do
      {
        i -= 1;
      } while ((i >= 0) && (((Comparable)paramList.get(i)).compareTo(paramT) == 0));
      i += 1;
    }
    AppMethodBeat.o(93230);
    return i;
  }
  
  public static int a(long[] paramArrayOfLong, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(93228);
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i = j;
    if (j < 0) {}
    for (i = -(j + 2); paramBoolean; i = j + 1)
    {
      i = Math.max(0, i);
      AppMethodBeat.o(93228);
      return i;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (paramArrayOfLong[j] == paramLong);
    }
    AppMethodBeat.o(93228);
    return i;
  }
  
  public static int a(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93229);
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i = j;
    if (j < 0) {
      i = j ^ 0xFFFFFFFF;
    }
    while (paramBoolean2)
    {
      i = Math.min(paramArrayOfLong.length - 1, i);
      AppMethodBeat.o(93229);
      return i;
      do
      {
        j = i + 1;
        if (j >= paramArrayOfLong.length) {
          break;
        }
        i = j;
      } while (paramArrayOfLong[j] == paramLong);
      i = j;
      if (paramBoolean1) {
        i = j - 1;
      }
    }
    AppMethodBeat.o(93229);
    return i;
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(93220);
    if (paramg != null) {}
    try
    {
      paramg.close();
      AppMethodBeat.o(93220);
      return;
    }
    catch (IOException paramg)
    {
      AppMethodBeat.o(93220);
    }
  }
  
  public static void a(long[] paramArrayOfLong, long paramLong)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramLong >= 1000000L) && (paramLong % 1000000L == 0L)) {
      paramLong /= 1000000L;
    }
    while (i < paramArrayOfLong.length)
    {
      paramArrayOfLong[i] /= paramLong;
      i += 1;
      continue;
      if ((paramLong < 1000000L) && (1000000L % paramLong == 0L))
      {
        paramLong = 1000000L / paramLong;
        i = j;
      }
      while (i < paramArrayOfLong.length)
      {
        paramArrayOfLong[i] *= paramLong;
        i += 1;
        continue;
        double d = 1000000.0D / paramLong;
        i = k;
        while (i < paramArrayOfLong.length)
        {
          paramArrayOfLong[i] = ((paramArrayOfLong[i] * d));
          i += 1;
        }
      }
    }
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
  
  public static ExecutorService bE(String paramString)
  {
    AppMethodBeat.i(93219);
    paramString = Executors.newSingleThreadExecutor(new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(93216);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, this.val$threadName);
        AppMethodBeat.o(93216);
        return paramAnonymousRunnable;
      }
    });
    AppMethodBeat.o(93219);
    return paramString;
  }
  
  public static String bF(String paramString)
  {
    AppMethodBeat.i(93222);
    if (paramString == null)
    {
      AppMethodBeat.o(93222);
      return null;
    }
    paramString = new Locale(paramString).getLanguage();
    AppMethodBeat.o(93222);
    return paramString;
  }
  
  public static byte[] bG(String paramString)
  {
    AppMethodBeat.i(93223);
    paramString = paramString.getBytes(Charset.forName("UTF-8"));
    AppMethodBeat.o(93223);
    return paramString;
  }
  
  public static String bH(String paramString)
  {
    AppMethodBeat.i(93224);
    if (paramString == null)
    {
      AppMethodBeat.o(93224);
      return null;
    }
    paramString = paramString.toLowerCase(Locale.US);
    AppMethodBeat.o(93224);
    return paramString;
  }
  
  public static long bI(String paramString)
  {
    AppMethodBeat.i(93232);
    Matcher localMatcher = bHI.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = new o("Invalid date/time format: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(93232);
      throw paramString;
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
      AppMethodBeat.o(93232);
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
  
  public static int bJ(String paramString)
  {
    AppMethodBeat.i(93235);
    int k = paramString.length();
    if (k <= 4) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      int i = 0;
      j = 0;
      while (i < k)
      {
        j = paramString.charAt(i) | j << 8;
        i += 1;
      }
    }
    AppMethodBeat.o(93235);
    return j;
  }
  
  public static byte[] bK(String paramString)
  {
    AppMethodBeat.i(93236);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = i * 2;
      int k = Character.digit(paramString.charAt(j), 16);
      arrayOfByte[i] = ((byte)(Character.digit(paramString.charAt(j + 1), 16) + (k << 4)));
      i += 1;
    }
    AppMethodBeat.o(93236);
    return arrayOfByte;
  }
  
  public static String bL(String paramString)
  {
    int m = 0;
    AppMethodBeat.i(93243);
    int n = paramString.length();
    int j = 0;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (paramString.charAt(j) == '%') {
        k = i + 1;
      }
      j += 1;
    }
    if (i == 0)
    {
      AppMethodBeat.o(93243);
      return paramString;
    }
    int k = n - i * 2;
    StringBuilder localStringBuilder = new StringBuilder(k);
    Matcher localMatcher = bHK.matcher(paramString);
    j = m;
    while ((i > 0) && (localMatcher.find()))
    {
      char c = (char)Integer.parseInt(localMatcher.group(1), 16);
      localStringBuilder.append(paramString, j, localMatcher.start()).append(c);
      j = localMatcher.end();
      i -= 1;
    }
    if (j < n) {
      localStringBuilder.append(paramString, j, n);
    }
    if (localStringBuilder.length() != k)
    {
      AppMethodBeat.o(93243);
      return null;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(93243);
    return paramString;
  }
  
  public static int bi(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  public static int bj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93239);
    switch (paramInt1)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(93239);
      throw localIllegalArgumentException;
    case 3: 
      AppMethodBeat.o(93239);
      return paramInt2;
    case 2: 
      AppMethodBeat.o(93239);
      return paramInt2 * 2;
    case -2147483648: 
      AppMethodBeat.o(93239);
      return paramInt2 * 3;
    }
    AppMethodBeat.o(93239);
    return paramInt2 * 4;
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(93221);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(93221);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(93221);
    }
  }
  
  public static String d(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(93237);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      localStringBuilder.append(paramArrayOfObject[i].getClass().getSimpleName());
      if (i < paramArrayOfObject.length - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    paramArrayOfObject = localStringBuilder.toString();
    AppMethodBeat.o(93237);
    return paramArrayOfObject;
  }
  
  public static void d(Throwable paramThrowable)
  {
    throw paramThrowable;
  }
  
  public static boolean fd(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 13);
  }
  
  public static int fg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8: 
      return 3;
    case 16: 
      return 2;
    case 24: 
      return -2147483648;
    }
    return 1073741824;
  }
  
  public static int fh(int paramInt)
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
  
  public static int fi(int paramInt)
  {
    AppMethodBeat.i(93242);
    switch (paramInt)
    {
    default: 
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(93242);
      throw localIllegalStateException;
    case 0: 
      AppMethodBeat.o(93242);
      return 16777216;
    case 1: 
      AppMethodBeat.o(93242);
      return 3538944;
    case 2: 
      AppMethodBeat.o(93242);
      return 13107200;
    case 3: 
      AppMethodBeat.o(93242);
      return 131072;
    }
    AppMethodBeat.o(93242);
    return 131072;
  }
  
  public static String h(Context paramContext, String paramString)
  {
    AppMethodBeat.i(93238);
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      paramContext = paramString + "/" + paramContext + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.5.4";
      AppMethodBeat.o(93238);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = "?";
      }
    }
  }
  
  public static boolean j(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(93218);
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
      {
        AppMethodBeat.o(93218);
        return true;
      }
      AppMethodBeat.o(93218);
      return false;
    }
    boolean bool = paramObject1.equals(paramObject2);
    AppMethodBeat.o(93218);
    return bool;
  }
  
  public static float k(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(93227);
    paramFloat1 = Math.max(paramFloat2, Math.min(paramFloat1, paramFloat3));
    AppMethodBeat.o(93227);
    return paramFloat1;
  }
  
  public static long l(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93226);
    paramLong1 = Math.max(0L, Math.min(paramLong1, paramLong2));
    AppMethodBeat.o(93226);
    return paramLong1;
  }
  
  public static int m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      i = i << 8 ^ bHL[((i >>> 24 ^ paramArrayOfByte[paramInt2] & 0xFF) & 0xFF)];
      paramInt2 += 1;
    }
    return i;
  }
  
  public static boolean o(Uri paramUri)
  {
    AppMethodBeat.i(93217);
    paramUri = paramUri.getScheme();
    if ((TextUtils.isEmpty(paramUri)) || (paramUri.equals("file")))
    {
      AppMethodBeat.o(93217);
      return true;
    }
    AppMethodBeat.o(93217);
    return false;
  }
  
  public static int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93225);
    paramInt1 = Math.max(paramInt2, Math.min(paramInt1, paramInt3));
    AppMethodBeat.o(93225);
    return paramInt1;
  }
  
  public static int[] y(List<Integer> paramList)
  {
    AppMethodBeat.i(93234);
    if (paramList == null)
    {
      AppMethodBeat.o(93234);
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
    AppMethodBeat.o(93234);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.i.x
 * JD-Core Version:    0.7.0.1
 */