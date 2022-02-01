package com.appaac.haptic.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends d
{
  public static AtomicInteger cqS;
  private final boolean DEBUG;
  private final Vibrator cqQ;
  private Class<?> cqR;
  
  static
  {
    AppMethodBeat.i(208430);
    cqS = new AtomicInteger();
    AppMethodBeat.o(208430);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(208386);
    this.DEBUG = false;
    this.cqQ = ((Vibrator)paramContext.getSystemService("vibrator"));
    try
    {
      this.cqR = Class.forName("android.os.RichTapVibrationEffect");
      label39:
      if (this.cqR == null) {
        try
        {
          this.cqR = Class.forName("android.os.VibrationEffect");
          AppMethodBeat.o(208386);
          return;
        }
        catch (ClassNotFoundException paramContext) {}
      }
      AppMethodBeat.o(208386);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      break label39;
    }
  }
  
  private static boolean B(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  private static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, c[] paramArrayOfc)
  {
    AppMethodBeat.i(208422);
    int j = 0;
    int k = 5;
    int i = 0;
    while (i < paramInt2)
    {
      j += paramArrayOfc[i].Nt();
      i += 1;
    }
    int[] arrayOfInt1 = new int[j + 5];
    Arrays.fill(arrayOfInt1, 0);
    arrayOfInt1[0] = 2;
    arrayOfInt1[1] = paramInt1;
    arrayOfInt1[2] = paramInt3;
    arrayOfInt1[3] = paramInt4;
    arrayOfInt1[4] |= 0xFFFF & paramInt2;
    arrayOfInt1[4] = (paramArrayOfc.length << 16 & 0xFFFF0000 | arrayOfInt1[4]);
    paramInt1 = 0;
    paramInt3 = k;
    while (paramInt1 < paramInt2)
    {
      Object localObject = paramArrayOfc[paramInt1];
      int[] arrayOfInt2 = new int[((c)localObject).Nt()];
      Arrays.fill(arrayOfInt2, 0);
      arrayOfInt2[0] = paramInt5;
      arrayOfInt2[1] = ((c)localObject).cqY;
      arrayOfInt2[2] = ((c)localObject).cra.length;
      i = 3;
      localObject = ((c)localObject).cra;
      j = localObject.length;
      paramInt4 = 0;
      while (paramInt4 < j)
      {
        int[] arrayOfInt3 = localObject[paramInt4].Nr();
        System.arraycopy(arrayOfInt3, 0, arrayOfInt2, i, arrayOfInt3.length);
        i += arrayOfInt3.length;
        paramInt4 += 1;
      }
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, paramInt3, arrayOfInt2.length);
      paramInt3 += arrayOfInt2.length;
      paramInt5 += 1;
      paramInt1 += 1;
    }
    AppMethodBeat.o(208422);
    return arrayOfInt1;
  }
  
  private static int[] aX(String paramString)
  {
    AppMethodBeat.i(208397);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("Pattern");
        localObject1 = localObject2;
        int n = Math.min(localJSONArray.length(), 16);
        localObject1 = localObject2;
        paramString = new int[n * 17];
        int m = 1;
        int j = 0;
        i = m;
        Object localObject3;
        int k;
        if (j < n)
        {
          localObject1 = paramString;
          localObject2 = localJSONArray.getJSONObject(j).getJSONObject("Event");
          localObject1 = paramString;
          localObject3 = ((JSONObject)localObject2).getString("Type");
          localObject1 = paramString;
          if (TextUtils.equals("continuous", (CharSequence)localObject3))
          {
            i = 4096;
            localObject1 = paramString;
            if (((JSONObject)localObject2).has("RelativeTime")) {
              continue;
            }
            localObject1 = paramString;
            new StringBuilder("event:").append(j).append(" don't have relativeTime parameters,set default:").append(j * 400);
            k = j * 400;
            if (k >= 0) {
              continue;
            }
            i = 0;
          }
        }
        else
        {
          if (i != 0) {
            continue;
          }
          AppMethodBeat.o(208397);
          return null;
        }
        localObject1 = paramString;
        if (TextUtils.equals("transient", (CharSequence)localObject3))
        {
          i = 4097;
          continue;
          localObject1 = paramString;
          k = ((JSONObject)localObject2).getInt("RelativeTime");
          continue;
          localObject1 = paramString;
          localObject3 = ((JSONObject)localObject2).getJSONObject("Parameters");
          localObject1 = paramString;
          int i1 = ((JSONObject)localObject3).getInt("Intensity");
          localObject1 = paramString;
          int i2 = ((JSONObject)localObject3).getInt("Frequency");
          if (i == 4096)
          {
            localObject1 = paramString;
            if (!B(i1, 0, 100)) {
              break label518;
            }
            localObject1 = paramString;
            if (!B(i2, 0, 100)) {
              break label518;
            }
          }
          else if (i == 4097)
          {
            localObject1 = paramString;
            if (!B(i1, 0, 100)) {
              break label523;
            }
            localObject1 = paramString;
            if (!B(i2, -50, 150)) {
              break label523;
            }
          }
          paramString[(j * 17 + 0)] = i;
          paramString[(j * 17 + 1)] = k;
          paramString[(j * 17 + 2)] = i1;
          paramString[(j * 17 + 3)] = i2;
          if (4096 == i)
          {
            localObject1 = paramString;
            if (!((JSONObject)localObject2).has("Duration"))
            {
              localObject1 = paramString;
              new StringBuilder("event:").append(j).append(" don't have duration parameters,set default:0");
              i = 0;
              localObject1 = paramString;
              if (!B(i, 0, 5000)) {
                i = 0;
              }
            }
            else
            {
              localObject1 = paramString;
              i = ((JSONObject)localObject2).getInt("Duration");
              continue;
            }
            paramString[(j * 17 + 4)] = i;
            localObject1 = paramString;
            localObject2 = d(((JSONObject)localObject3).getJSONArray("Curve"));
            if (localObject2 != null)
            {
              localObject1 = paramString;
              System.arraycopy(localObject2, 0, paramString, j * 17 + 5, 12);
            }
          }
          else
          {
            j += 1;
            continue;
          }
          i = 0;
          continue;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        paramString = (String)localObject1;
        AppMethodBeat.o(208397);
        return paramString;
      }
      continue;
      label518:
      int i = 0;
      continue;
      label523:
      i = 0;
    }
  }
  
  private static int[] aY(String paramString)
  {
    AppMethodBeat.i(208401);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("Pattern");
        localObject1 = localObject2;
        int n = Math.min(localJSONArray.length(), 16);
        localObject1 = localObject2;
        paramString = new int[n * 55];
        int m = 1;
        int j = 0;
        i = m;
        Object localObject3;
        int k;
        if (j < n)
        {
          localObject1 = paramString;
          localObject2 = localJSONArray.getJSONObject(j).getJSONObject("Event");
          localObject1 = paramString;
          localObject3 = ((JSONObject)localObject2).getString("Type");
          localObject1 = paramString;
          if (TextUtils.equals("continuous", (CharSequence)localObject3))
          {
            i = 4096;
            localObject1 = paramString;
            if (((JSONObject)localObject2).has("RelativeTime")) {
              continue;
            }
            localObject1 = paramString;
            new StringBuilder("event:").append(j).append(" don't have relativeTime parameters,set default:").append(j * 400);
            k = j * 400;
            if (k >= 0) {
              continue;
            }
            i = 0;
          }
        }
        else
        {
          if (i != 0) {
            continue;
          }
          AppMethodBeat.o(208401);
          return null;
        }
        localObject1 = paramString;
        if (TextUtils.equals("transient", (CharSequence)localObject3))
        {
          i = 4097;
          continue;
          localObject1 = paramString;
          k = ((JSONObject)localObject2).getInt("RelativeTime");
          continue;
          localObject1 = paramString;
          localObject3 = ((JSONObject)localObject2).getJSONObject("Parameters");
          localObject1 = paramString;
          int i1 = ((JSONObject)localObject3).getInt("Intensity");
          localObject1 = paramString;
          int i2 = ((JSONObject)localObject3).getInt("Frequency");
          if (i == 4096)
          {
            localObject1 = paramString;
            if (!B(i1, 0, 100)) {
              break label552;
            }
            localObject1 = paramString;
            if (!B(i2, 0, 100)) {
              break label552;
            }
          }
          else if (i == 4097)
          {
            localObject1 = paramString;
            if (!B(i1, 0, 100)) {
              break label557;
            }
            localObject1 = paramString;
            if (!B(i2, -50, 150)) {
              break label557;
            }
          }
          paramString[(j * 55 + 0)] = i;
          paramString[(j * 55 + 1)] = k;
          paramString[(j * 55 + 2)] = i1;
          paramString[(j * 55 + 3)] = i2;
          paramString[(j * 55 + 5)] = 0;
          if (4096 == i)
          {
            localObject1 = paramString;
            if (!((JSONObject)localObject2).has("Duration"))
            {
              localObject1 = paramString;
              new StringBuilder("event:").append(j).append(" don't have duration parameters,set default:0");
              i = 0;
              localObject1 = paramString;
              if (!B(i, 0, 5000)) {
                i = 0;
              }
            }
            else
            {
              localObject1 = paramString;
              i = ((JSONObject)localObject2).getInt("Duration");
              continue;
            }
            paramString[(j * 55 + 4)] = i;
            localObject1 = paramString;
            localObject2 = ((JSONObject)localObject3).getJSONArray("Curve");
            localObject1 = paramString;
            paramString[(j * 55 + 6)] = ((JSONArray)localObject2).length();
            localObject1 = paramString;
            localObject2 = e((JSONArray)localObject2);
            if (localObject2 != null)
            {
              localObject1 = paramString;
              System.arraycopy(localObject2, 0, paramString, j * 55 + 7, 48);
            }
          }
          else
          {
            j += 1;
            continue;
          }
          i = 0;
          continue;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        paramString = (String)localObject1;
        AppMethodBeat.o(208401);
        return paramString;
      }
      continue;
      label552:
      int i = 0;
      continue;
      label557:
      i = 0;
    }
  }
  
  private c[] aZ(String paramString)
  {
    AppMethodBeat.i(208413);
    int j = 0;
    int m = 0;
    int i;
    int n;
    int i2;
    int k;
    label355:
    int i5;
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("PatternList");
        int i7 = localJSONArray.length();
        i = 1;
        paramString = new c[i7];
        i1 = 0;
        if (i1 >= i7) {
          continue;
        }
        try
        {
          localc = new c();
          Object localObject1 = localJSONArray.getJSONObject(i1);
          i4 = ((JSONObject)localObject1).getInt("AbsoluteTime");
          localc.cqY = i4;
          if ((i1 > 0) && (i4 < m + j))
          {
            new StringBuilder("Bad pattern relative time in int:").append(i1).append(",last patternDuration:").append(m).append(", absTimeLast:").append(j);
            AppMethodBeat.o(208413);
            return null;
          }
          j = 0;
          localObject1 = ((JSONObject)localObject1).getJSONArray("Pattern");
          int i8 = Math.min(16, ((JSONArray)localObject1).length());
          localc.cra = new b[i8];
          n = -1;
          i2 = 0;
          k = i;
          i = k;
          m = j;
          if (i2 >= i8) {
            continue;
          }
          localObject2 = ((JSONArray)localObject1).getJSONObject(i2).getJSONObject("Event");
          localObject3 = ((JSONObject)localObject2).getString("Type");
          if (TextUtils.equals("continuous", (CharSequence)localObject3))
          {
            i = 4096;
            localc.cra[i2] = new a();
            m = ((JSONObject)localObject2).getInt("Index");
            localc.cra[i2].cqX = ((byte)m);
            if (((JSONObject)localObject2).has("RelativeTime")) {
              continue;
            }
            new StringBuilder("event:").append(i1).append(" don't have relativeTime parameters,BAD he!");
            AppMethodBeat.o(208413);
            return null;
          }
          if (!TextUtils.equals("transient", (CharSequence)localObject3)) {
            continue;
          }
          i = 4097;
          localc.cra[i2] = new e();
          continue;
          AppMethodBeat.o(208413);
        }
        catch (Exception localException) {}
      }
      catch (Exception paramString)
      {
        int i1;
        c localc;
        int i4;
        Object localObject2;
        Object localObject3;
        int i3;
        JSONObject localJSONObject;
        int i6;
        int i9;
        paramString = null;
        continue;
        if (i5 >= 0) {
          continue;
        }
        i = 0;
        m = j;
        continue;
        i = 0;
        m = j;
        continue;
        i = 0;
        m = j;
        continue;
      }
      return paramString;
      i = 0;
      m = j;
      if (i == 0)
      {
        AppMethodBeat.o(208413);
        return null;
        i5 = ((JSONObject)localObject2).getInt("RelativeTime");
        if ((i2 <= 0) || (i5 >= n)) {
          continue;
        }
        new StringBuilder("pattern ind:").append(i1).append(" event:").append(i2).append(" relative time seems not right!");
        continue;
        localObject3 = ((JSONObject)localObject2).getJSONObject("Parameters");
        m = ((JSONObject)localObject3).getInt("Intensity");
        n = ((JSONObject)localObject3).getInt("Frequency");
        if (i == 4096)
        {
          if (!B(m, 0, 100)) {
            continue;
          }
          if (!B(n, 0, 100)) {
            continue;
          }
        }
        else
        {
          if ((i == 4097) && ((!B(m, 0, 100)) || (!B(n, -50, 150)))) {
            continue;
          }
        }
        localc.cra[i2].mType = i;
        localc.cra[i2].cqY = i5;
        localc.cra[i2].cqZ = m;
        localc.cra[i2].cqI = n;
        if (4096 != i) {
          break label1019;
        }
        if (!((JSONObject)localObject2).has("Duration"))
        {
          new StringBuilder("event:").append(i1).append(" don't have duration parameters");
          AppMethodBeat.o(208413);
          return null;
        }
        i = ((JSONObject)localObject2).getInt("Duration");
        if (!B(i, 0, 5000))
        {
          i = 0;
          m = j;
        }
        else
        {
          localc.cra[i2].cam = i;
          localObject2 = ((JSONObject)localObject3).getJSONArray("Curve");
          ((a)localc.cra[i2]).cqT = ((byte)((JSONArray)localObject2).length());
          localObject3 = new d[((JSONArray)localObject2).length()];
          n = -1;
          i3 = 0;
          m = 0;
          if (m < ((JSONArray)localObject2).length())
          {
            localJSONObject = ((JSONArray)localObject2).getJSONObject(m);
            localObject3[m] = new d();
            i3 = localJSONObject.getInt("Time");
            i6 = (int)(localJSONObject.getDouble("Intensity") * 100.0D);
            i9 = localJSONObject.getInt("Frequency");
            if ((m == 0) && (i3 != 0))
            {
              AppMethodBeat.o(208413);
              return null;
            }
            if ((m > 0) && (i3 < n))
            {
              AppMethodBeat.o(208413);
              return null;
            }
            localObject3[m].mTime = i3;
            localObject3[m].cqZ = i6;
            localObject3[m].cqI = i9;
            i6 = m + 1;
            m = i3;
            n = i3;
            i3 = m;
            m = i6;
          }
          else
          {
            if (i3 != i)
            {
              new StringBuilder("event:").append(i1).append(" point last time do not match duration parameter");
              AppMethodBeat.o(208413);
              return null;
            }
            if (localObject3.length <= 0) {
              break label1013;
            }
            ((a)localc.cra[i2]).cqU = ((d[])localObject3);
            break label966;
          }
        }
      }
      else
      {
        paramString[i1] = localc;
        i1 += 1;
        j = i4;
      }
    }
    for (;;)
    {
      label966:
      n = j;
      if (j < i5 + i) {
        n = i5 + i;
      }
      i = k;
      m = n;
      if (k == 0) {
        break label355;
      }
      i2 += 1;
      i = i5;
      j = n;
      n = i;
      break;
      label1013:
      k = 0;
      continue;
      label1019:
      i = 22;
    }
  }
  
  private static boolean bU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208391);
    if (paramInt1 < 22)
    {
      new StringBuilder("can not support he in richtap version:").append(String.format("%x02", new Object[] { Integer.valueOf(paramInt1) }));
      AppMethodBeat.o(208391);
      return false;
    }
    if (paramInt1 == 22)
    {
      if (paramInt2 != 1)
      {
        new StringBuilder("RichTap version is ").append(String.format("%x", new Object[] { Integer.valueOf(paramInt1) })).append(" can not support he version: ").append(paramInt2);
        AppMethodBeat.o(208391);
        return false;
      }
    }
    else if (paramInt1 == 23)
    {
      if (paramInt2 != 1)
      {
        new StringBuilder("RichTap version is ").append(String.format("%x", new Object[] { Integer.valueOf(paramInt1) })).append(" can not support he version: ").append(paramInt2);
        AppMethodBeat.o(208391);
        return false;
      }
    }
    else if ((paramInt1 == 24) && (paramInt2 != 1) && (paramInt2 != 2))
    {
      AppMethodBeat.o(208391);
      return false;
    }
    AppMethodBeat.o(208391);
    return true;
  }
  
  private static int[] d(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(208405);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(208405);
      return null;
    }
    int[] arrayOfInt = new int[12];
    for (;;)
    {
      int m;
      int i;
      int n;
      int i2;
      int i1;
      try
      {
        m = paramJSONArray.length();
        if (m != 4) {
          break label474;
        }
        i = 0;
        if (i >= m) {
          break label465;
        }
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        j = localJSONObject.getInt("Time");
        k = (int)(localJSONObject.getDouble("Intensity") * 100.0D);
        n = localJSONObject.getInt("Frequency");
        boolean bool;
        if ((B(j, 0, 5000)) && (B(k, 0, 100)))
        {
          bool = B(n, -100, 100);
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(208405);
          return null;
        }
        arrayOfInt[(i * 3)] = j;
        arrayOfInt[(i * 3 + 1)] = k;
        arrayOfInt[(i * 3 + 2)] = n;
        i += 1;
        continue;
        if (i >= m) {
          break label465;
        }
        localJSONObject = paramJSONArray.getJSONObject(i);
        i2 = localJSONObject.getInt("Time");
        i1 = (int)(localJSONObject.getDouble("Intensity") * 100.0D);
        n = localJSONObject.getInt("Frequency");
        if ((B(i2, 0, 5000)) && (B(i1, 0, 100)))
        {
          bool = B(n, -100, 100);
          if (bool) {}
        }
        else
        {
          AppMethodBeat.o(208405);
          return null;
        }
        if (i == 0)
        {
          arrayOfInt[(i * 3)] = i2;
          arrayOfInt[(i * 3 + 1)] = i1;
          arrayOfInt[(i * 3 + 2)] = n;
        }
        else if (i < m - 1)
        {
          if (i < Math.ceil(m / 2.0D))
          {
            k = 1;
            j = (int)(Math.ceil(m / 2.0D) - 1.0D);
            int i3 = k * 3;
            int i4 = arrayOfInt[i3];
            arrayOfInt[i3] = (i2 / j + i4);
            i2 = k * 3 + 1;
            i3 = arrayOfInt[i2];
            arrayOfInt[i2] = (i1 / j + i3);
            k = k * 3 + 2;
            i1 = arrayOfInt[k];
            arrayOfInt[k] = (n / j + i1);
          }
        }
      }
      catch (Exception paramJSONArray)
      {
        AppMethodBeat.o(208405);
        return null;
      }
      int k = 2;
      int j = m / 2 - 1;
      continue;
      if (i == m - 1)
      {
        arrayOfInt[9] = i2;
        arrayOfInt[10] = i1;
        arrayOfInt[11] = n;
        break label492;
        label465:
        label474:
        do
        {
          AppMethodBeat.o(208405);
          return null;
          AppMethodBeat.o(208405);
          return arrayOfInt;
        } while ((m <= 4) || (m > 16));
        i = 0;
        continue;
      }
      label492:
      i += 1;
    }
  }
  
  private static int[] e(JSONArray paramJSONArray)
  {
    int j = 0;
    AppMethodBeat.i(208408);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(208408);
      return null;
    }
    int[] arrayOfInt = new int[48];
    int i = 0;
    while (i < 48)
    {
      arrayOfInt[i] = -1;
      i += 1;
    }
    try
    {
      i = paramJSONArray.length();
      if (i >= 4)
      {
        int k = Math.min(i, 16);
        i = j;
        while (i < k)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          j = localJSONObject.getInt("Time");
          int m = (int)(localJSONObject.getDouble("Intensity") * 100.0D);
          int n = localJSONObject.getInt("Frequency");
          if ((B(j, 0, 5000)) && (B(m, 0, 100)))
          {
            boolean bool = B(n, -100, 100);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(208408);
            return null;
          }
          arrayOfInt[(i * 3 + 0)] = j;
          arrayOfInt[(i * 3 + 1)] = m;
          arrayOfInt[(i * 3 + 2)] = n;
          i += 1;
        }
      }
      AppMethodBeat.o(208408);
      return null;
      AppMethodBeat.o(208408);
      return arrayOfInt;
    }
    catch (Exception paramJSONArray)
    {
      AppMethodBeat.o(208408);
    }
    return null;
  }
  
  public final void Nq()
  {
    AppMethodBeat.i(208437);
    try
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        VibrationEffect localVibrationEffect = (VibrationEffect)this.cqR.getMethod("createPatternHeParameter", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.cqQ.vibrate(localVibrationEffect);
      }
      AppMethodBeat.o(208437);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(208437);
    }
  }
  
  public final int aW(String paramString)
  {
    AppMethodBeat.i(208445);
    for (;;)
    {
      int k;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("Pattern");
        int n = Math.min(paramString.length(), 16);
        int m = n * 2;
        long[] arrayOfLong = new long[m];
        int j = 0;
        k = 0;
        int i = 0;
        if (k < n)
        {
          JSONObject localJSONObject = paramString.getJSONObject(k).getJSONObject("Event");
          Object localObject = localJSONObject.getString("Type");
          if (TextUtils.equals("continuous", (CharSequence)localObject))
          {
            arrayOfLong[(k * 2)] = (localJSONObject.getInt("RelativeTime") - i - j);
            if (arrayOfLong[(k * 2)] < 0L) {
              arrayOfLong[(k * 2)] = 50L;
            }
            j = localJSONObject.getInt("Duration");
            arrayOfLong[(k * 2 + 1)] = j;
            i = localJSONObject.getInt("RelativeTime");
            break label305;
          }
          if (TextUtils.equals("transient", (CharSequence)localObject))
          {
            arrayOfLong[(k * 2)] = (localJSONObject.getInt("RelativeTime") - i - j);
            if (arrayOfLong[(k * 2)] < 0L) {
              arrayOfLong[(k * 2)] = 50L;
            }
            localObject = localJSONObject.getJSONObject("Parameters");
            ((JSONObject)localObject).getInt("Intensity");
            ((JSONObject)localObject).getInt("Frequency");
            arrayOfLong[(k * 2 + 1)] = 65L;
            i = localJSONObject.getInt("RelativeTime");
            j = 65;
            break label305;
          }
        }
        i = 0;
        j = 0;
        if (i < m)
        {
          j = (int)(arrayOfLong[i] + j);
          i += 1;
          continue;
        }
        AppMethodBeat.o(208445);
        return j;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(208445);
        return 0;
      }
      label305:
      k += 1;
    }
  }
  
  /* Error */
  public final void f(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc_w 351
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 67	com/appaac/haptic/a/e:cqQ	Landroid/os/Vibrator;
    //   13: ifnonnull +10 -> 23
    //   16: ldc_w 351
    //   19: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: return
    //   23: new 120	org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 8
    //   33: invokestatic 357	com/appaac/haptic/a/g:Nw	()Z
    //   36: istore 7
    //   38: iload 7
    //   40: ifne +88 -> 128
    //   43: aload 8
    //   45: ldc_w 359
    //   48: invokevirtual 149	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: ldc_w 361
    //   54: invokevirtual 189	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   57: istore 5
    //   59: invokestatic 364	com/appaac/haptic/a/g:getMajorVersion	()I
    //   62: istore 6
    //   64: invokestatic 367	com/appaac/haptic/a/g:getMinorVersion	()I
    //   67: pop
    //   68: iload 6
    //   70: iload 5
    //   72: invokestatic 369	com/appaac/haptic/a/e:bU	(II)Z
    //   75: ifne +53 -> 128
    //   78: new 171	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 371
    //   85: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: ldc_w 286
    //   91: iconst_1
    //   92: anewarray 288	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: iload 6
    //   99: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 300	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   106: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 373
    //   112: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload 5
    //   117: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: ldc_w 351
    //   124: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: invokestatic 364	com/appaac/haptic/a/g:getMajorVersion	()I
    //   131: bipush 24
    //   133: if_icmpge +19 -> 152
    //   136: aload_1
    //   137: invokestatic 375	com/appaac/haptic/a/e:aX	(Ljava/lang/String;)[I
    //   140: astore_1
    //   141: aload_1
    //   142: ifnonnull +18 -> 160
    //   145: ldc_w 351
    //   148: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: aload_1
    //   153: invokestatic 377	com/appaac/haptic/a/e:aY	(Ljava/lang/String;)[I
    //   156: astore_1
    //   157: goto -16 -> 141
    //   160: aload_1
    //   161: arraylength
    //   162: istore 5
    //   164: getstatic 321	android/os/Build$VERSION:SDK_INT	I
    //   167: bipush 26
    //   169: if_icmplt +143 -> 312
    //   172: aload_0
    //   173: getfield 77	com/appaac/haptic/a/e:cqR	Ljava/lang/Class;
    //   176: ldc_w 379
    //   179: iconst_5
    //   180: anewarray 71	java/lang/Class
    //   183: dup
    //   184: iconst_0
    //   185: ldc_w 381
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   206: aastore
    //   207: dup
    //   208: iconst_4
    //   209: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   212: aastore
    //   213: invokevirtual 330	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   216: astore 9
    //   218: iload 7
    //   220: ifne +113 -> 333
    //   223: iload 5
    //   225: iconst_1
    //   226: iadd
    //   227: newarray int
    //   229: astore 8
    //   231: invokestatic 364	com/appaac/haptic/a/g:getMajorVersion	()I
    //   234: bipush 24
    //   236: if_icmpge +91 -> 327
    //   239: aload 8
    //   241: iconst_0
    //   242: iload 4
    //   244: iastore
    //   245: aload_1
    //   246: iconst_0
    //   247: aload 8
    //   249: iconst_1
    //   250: aload_1
    //   251: arraylength
    //   252: invokestatic 113	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   255: aload 8
    //   257: astore_1
    //   258: aload 9
    //   260: aconst_null
    //   261: iconst_5
    //   262: anewarray 288	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_1
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: iconst_1
    //   272: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: dup
    //   277: iconst_2
    //   278: iconst_0
    //   279: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: dup
    //   284: iconst_3
    //   285: iload_2
    //   286: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: dup
    //   291: iconst_4
    //   292: iload_3
    //   293: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: invokevirtual 336	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   300: checkcast 338	android/os/VibrationEffect
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 67	com/appaac/haptic/a/e:cqQ	Landroid/os/Vibrator;
    //   308: aload_1
    //   309: invokevirtual 342	android/os/Vibrator:vibrate	(Landroid/os/VibrationEffect;)V
    //   312: ldc_w 351
    //   315: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: return
    //   319: astore_1
    //   320: ldc_w 351
    //   323: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: return
    //   327: iconst_3
    //   328: istore 4
    //   330: goto -91 -> 239
    //   333: goto -75 -> 258
    //   336: astore_1
    //   337: ldc_w 351
    //   340: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	e
    //   0	344	1	paramString	String
    //   0	344	2	paramInt1	int
    //   0	344	3	paramInt2	int
    //   1	328	4	i	int
    //   57	170	5	j	int
    //   62	36	6	k	int
    //   36	183	7	bool	boolean
    //   31	225	8	localObject	Object
    //   216	43	9	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   23	38	319	java/lang/Exception
    //   43	121	319	java/lang/Exception
    //   128	141	319	java/lang/Exception
    //   152	157	319	java/lang/Exception
    //   160	164	319	java/lang/Exception
    //   312	318	319	java/lang/Exception
    //   164	218	336	java/lang/Exception
    //   223	239	336	java/lang/Exception
    //   245	255	336	java/lang/Exception
    //   258	312	336	java/lang/Exception
  }
  
  /* Error */
  public final void g(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 383
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 67	com/appaac/haptic/a/e:cqQ	Landroid/os/Vibrator;
    //   10: ifnonnull +10 -> 20
    //   13: ldc_w 383
    //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: new 120	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 123	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore 11
    //   30: invokestatic 357	com/appaac/haptic/a/g:Nw	()Z
    //   33: istore 10
    //   35: iconst_0
    //   36: istore 5
    //   38: iload 10
    //   40: ifne +92 -> 132
    //   43: aload 11
    //   45: ldc_w 359
    //   48: invokevirtual 149	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: ldc_w 361
    //   54: invokevirtual 189	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   57: istore 4
    //   59: invokestatic 364	com/appaac/haptic/a/g:getMajorVersion	()I
    //   62: istore 6
    //   64: invokestatic 367	com/appaac/haptic/a/g:getMinorVersion	()I
    //   67: pop
    //   68: iload 4
    //   70: istore 5
    //   72: iload 6
    //   74: iload 4
    //   76: invokestatic 369	com/appaac/haptic/a/e:bU	(II)Z
    //   79: ifne +53 -> 132
    //   82: new 171	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 371
    //   89: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: ldc_w 286
    //   95: iconst_1
    //   96: anewarray 288	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: iload 6
    //   103: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: invokestatic 300	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 373
    //   116: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload 4
    //   121: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc_w 383
    //   128: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: aload_0
    //   133: aload_1
    //   134: invokespecial 385	com/appaac/haptic/a/e:aZ	(Ljava/lang/String;)[Lcom/appaac/haptic/a/e$c;
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull +12 -> 151
    //   142: aload_1
    //   143: arraylength
    //   144: istore 4
    //   146: iload 4
    //   148: ifne +10 -> 158
    //   151: ldc_w 383
    //   154: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: iconst_0
    //   159: istore 6
    //   161: getstatic 44	com/appaac/haptic/a/e:cqS	Ljava/util/concurrent/atomic/AtomicInteger;
    //   164: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   167: istore 8
    //   169: invokestatic 393	android/os/Process:myPid	()I
    //   172: istore 9
    //   174: iconst_0
    //   175: istore 7
    //   177: iload 7
    //   179: aload_1
    //   180: arraylength
    //   181: i2d
    //   182: ldc2_w 394
    //   185: ddiv
    //   186: invokestatic 313	java/lang/Math:ceil	(D)D
    //   189: d2i
    //   190: if_icmpge +189 -> 379
    //   193: aload_1
    //   194: arraylength
    //   195: iload 7
    //   197: iconst_1
    //   198: iadd
    //   199: iconst_4
    //   200: imul
    //   201: if_icmpge +172 -> 373
    //   204: aload_1
    //   205: arraylength
    //   206: iload 7
    //   208: iconst_4
    //   209: imul
    //   210: isub
    //   211: istore 4
    //   213: iload 4
    //   215: anewarray 12	com/appaac/haptic/a/e$c
    //   218: astore 11
    //   220: aload_1
    //   221: iload 7
    //   223: iconst_4
    //   224: imul
    //   225: aload 11
    //   227: iconst_0
    //   228: iload 4
    //   230: invokestatic 113	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   233: iload 5
    //   235: iload 4
    //   237: iload 9
    //   239: iload 8
    //   241: iload 6
    //   243: aload 11
    //   245: invokestatic 397	com/appaac/haptic/a/e:a	(IIIII[Lcom/appaac/haptic/a/e$c;)[I
    //   248: astore 11
    //   250: getstatic 321	android/os/Build$VERSION:SDK_INT	I
    //   253: bipush 26
    //   255: if_icmplt +105 -> 360
    //   258: aload_0
    //   259: getfield 77	com/appaac/haptic/a/e:cqR	Ljava/lang/Class;
    //   262: ldc_w 379
    //   265: iconst_5
    //   266: anewarray 71	java/lang/Class
    //   269: dup
    //   270: iconst_0
    //   271: ldc_w 381
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   280: aastore
    //   281: dup
    //   282: iconst_2
    //   283: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   286: aastore
    //   287: dup
    //   288: iconst_3
    //   289: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   292: aastore
    //   293: dup
    //   294: iconst_4
    //   295: getstatic 326	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   298: aastore
    //   299: invokevirtual 330	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   302: aconst_null
    //   303: iconst_5
    //   304: anewarray 288	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload 11
    //   311: checkcast 381	[I
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: iconst_1
    //   318: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aastore
    //   322: dup
    //   323: iconst_2
    //   324: iconst_0
    //   325: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: aastore
    //   329: dup
    //   330: iconst_3
    //   331: iload_2
    //   332: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: dup
    //   337: iconst_4
    //   338: iload_3
    //   339: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokevirtual 336	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   346: checkcast 338	android/os/VibrationEffect
    //   349: astore 11
    //   351: aload_0
    //   352: getfield 67	com/appaac/haptic/a/e:cqQ	Landroid/os/Vibrator;
    //   355: aload 11
    //   357: invokevirtual 342	android/os/Vibrator:vibrate	(Landroid/os/VibrationEffect;)V
    //   360: iload 7
    //   362: iconst_1
    //   363: iadd
    //   364: istore 7
    //   366: iload 4
    //   368: istore 6
    //   370: goto -193 -> 177
    //   373: iconst_4
    //   374: istore 4
    //   376: goto -163 -> 213
    //   379: ldc_w 383
    //   382: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: return
    //   386: astore_1
    //   387: ldc_w 383
    //   390: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   393: return
    //   394: astore 11
    //   396: goto -36 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	e
    //   0	399	1	paramString	String
    //   0	399	2	paramInt1	int
    //   0	399	3	paramInt2	int
    //   57	318	4	i	int
    //   36	198	5	j	int
    //   62	307	6	k	int
    //   175	190	7	m	int
    //   167	73	8	n	int
    //   172	66	9	i1	int
    //   33	6	10	bool	boolean
    //   28	328	11	localObject	Object
    //   394	1	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   20	35	386	java/lang/Exception
    //   43	68	386	java/lang/Exception
    //   72	125	386	java/lang/Exception
    //   132	138	386	java/lang/Exception
    //   142	146	386	java/lang/Exception
    //   161	174	386	java/lang/Exception
    //   177	213	386	java/lang/Exception
    //   213	250	386	java/lang/Exception
    //   250	360	394	java/lang/Exception
  }
  
  public final void h(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208460);
    if (this.cqQ == null)
    {
      AppMethodBeat.o(208460);
      return;
    }
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(208460);
      return;
    }
    for (;;)
    {
      long[] arrayOfLong;
      int j;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("Pattern");
        int k = Math.min(paramString.length(), 16);
        paramInt1 = k * 2;
        arrayOfLong = new long[paramInt1];
        int[] arrayOfInt1 = new int[paramInt1];
        int i = 0;
        Arrays.fill(arrayOfInt1, 0);
        j = 0;
        paramInt1 = 0;
        if (j < k)
        {
          JSONObject localJSONObject = paramString.getJSONObject(j).getJSONObject("Event");
          Object localObject = localJSONObject.getString("Type");
          if (TextUtils.equals("continuous", (CharSequence)localObject))
          {
            localObject = localJSONObject.getJSONObject("Parameters");
            int[] arrayOfInt2 = d(((JSONObject)localObject).getJSONArray("Curve"));
            arrayOfLong[(j * 2)] = (localJSONObject.getInt("RelativeTime") - paramInt1 - i);
            if (arrayOfLong[(j * 2)] < 0L) {
              arrayOfLong[(j * 2)] = 50L;
            }
            arrayOfInt1[(j * 2)] = 0;
            i = localJSONObject.getInt("Duration");
            arrayOfLong[(j * 2 + 1)] = i;
            paramInt1 = Math.max(Math.min(arrayOfInt2[4] * 255 / 100, 255), Math.min(arrayOfInt2[7] * 255 / 100, 255));
            int m = ((JSONObject)localObject).getInt("Intensity");
            ((JSONObject)localObject).getInt("Frequency");
            arrayOfInt1[(j * 2 + 1)] = Math.max(1, (int)(m / 100.0D * paramInt1 * paramInt2 / 255.0D));
            paramInt1 = localJSONObject.getInt("RelativeTime");
            break label531;
          }
          if (TextUtils.equals("transient", (CharSequence)localObject))
          {
            arrayOfLong[(j * 2)] = (localJSONObject.getInt("RelativeTime") - paramInt1 - i);
            if (arrayOfLong[(j * 2)] < 0L) {
              arrayOfLong[(j * 2)] = 50L;
            }
            arrayOfInt1[(j * 2)] = 0;
            localObject = localJSONObject.getJSONObject("Parameters");
            paramInt1 = ((JSONObject)localObject).getInt("Intensity");
            ((JSONObject)localObject).getInt("Frequency");
            arrayOfLong[(j * 2 + 1)] = 65L;
            arrayOfInt1[(j * 2 + 1)] = Math.max(1, Math.min((int)(paramInt2 * 1.0D * paramInt1 / 100.0D), 255));
            paramInt1 = localJSONObject.getInt("RelativeTime");
            i = 65;
            break label531;
          }
        }
        new StringBuilder("times:").append(Arrays.toString(arrayOfLong));
        if (Build.VERSION.SDK_INT >= 26)
        {
          this.cqQ.vibrate(VibrationEffect.createWaveform(arrayOfLong, arrayOfInt1, -1));
          AppMethodBeat.o(208460);
          return;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(208460);
        return;
      }
      this.cqQ.vibrate(arrayOfLong, -1);
      AppMethodBeat.o(208460);
      return;
      label531:
      j += 1;
    }
  }
  
  final class a
    extends e.b
  {
    int cqT;
    e.d[] cqU;
    
    a()
    {
      super();
    }
    
    final int[] Nr()
    {
      int i = 0;
      AppMethodBeat.i(208407);
      int[] arrayOfInt = new int[this.cqT * 3 + 8];
      Arrays.fill(arrayOfInt, 0);
      arrayOfInt[0] = this.mType;
      arrayOfInt[1] = (this.cqT * 3 + 8 - 2);
      arrayOfInt[2] = this.cqX;
      arrayOfInt[3] = this.cqY;
      arrayOfInt[4] = this.cqZ;
      arrayOfInt[5] = this.cqI;
      arrayOfInt[6] = this.cam;
      arrayOfInt[7] = this.cqT;
      int j = 8;
      while (i < this.cqT)
      {
        arrayOfInt[j] = this.cqU[i].mTime;
        j += 1;
        arrayOfInt[j] = this.cqU[i].cqZ;
        j += 1;
        arrayOfInt[j] = this.cqU[i].cqI;
        j += 1;
        i += 1;
      }
      AppMethodBeat.o(208407);
      return arrayOfInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(208411);
      String str = "Continuous{mPointNum=" + this.cqT + ", mPoint=" + Arrays.toString(this.cqU) + '}';
      AppMethodBeat.o(208411);
      return str;
    }
  }
  
  abstract class b
  {
    int cam;
    int cqI;
    int cqW;
    int cqX;
    int cqY;
    int cqZ;
    int mType;
    
    b() {}
    
    abstract int[] Nr();
    
    public String toString()
    {
      return "Event{mType=" + this.mType + ", mVibId=" + this.cqX + ", mRelativeTime=" + this.cqY + ", mIntensity=" + this.cqZ + ", mFreq=" + this.cqI + ", mDuration=" + this.cam + '}';
    }
  }
  
  final class c
  {
    int cqY;
    e.b[] cra;
    
    c() {}
    
    private int Ns()
    {
      e.b[] arrayOfb = this.cra;
      int k = arrayOfb.length;
      int j = 0;
      int i = 0;
      e.b localb;
      if (j < k)
      {
        localb = arrayOfb[j];
        if (localb.mType == 4096) {
          i = ((e.a)localb).cqT * 3 + 8 + i;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (localb.mType == 4097)
        {
          i += 7;
          continue;
          return i;
        }
      }
    }
    
    final int Nt()
    {
      AppMethodBeat.i(208403);
      int i = Ns();
      AppMethodBeat.o(208403);
      return i + 3;
    }
  }
  
  final class d
  {
    int cqI;
    int cqZ;
    int mTime;
    
    d() {}
  }
  
  final class e
    extends e.b
  {
    e()
    {
      super();
      this.cqW = 7;
    }
    
    final int[] Nr()
    {
      AppMethodBeat.i(208400);
      int[] arrayOfInt = new int[this.cqW];
      Arrays.fill(arrayOfInt, 0);
      arrayOfInt[0] = this.mType;
      arrayOfInt[1] = (this.cqW - 2);
      arrayOfInt[2] = this.cqX;
      arrayOfInt[3] = this.cqY;
      arrayOfInt[4] = this.cqZ;
      arrayOfInt[5] = this.cqI;
      arrayOfInt[6] = this.cam;
      AppMethodBeat.o(208400);
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.a.e
 * JD-Core Version:    0.7.0.1
 */