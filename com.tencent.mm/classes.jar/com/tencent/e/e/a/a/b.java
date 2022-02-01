package com.tencent.e.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.e.e.a.b.e;
import com.tencent.e.e.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] ahud = { 1, 5, 4, 8, 9, 2 };
  private static int ahue = -1;
  
  public static com.tencent.e.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(138393);
    com.tencent.e.e.a.b.a locala = new com.tencent.e.e.a.b.a();
    locala.ahuA = 0L;
    locala.hTs = "";
    locala.WpO = com.tencent.e.f.i.jdMethod_do(paramContext, paramContext.getPackageName()).versionCode;
    locala.ahsv = "14D6ACDE3C2F2F48";
    locala.channel = 500000;
    locala.requestType = paramInt3;
    locala.ahuC = bFv(paramContext.getPackageName());
    paramContext = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      paramContext.addAll(((i)paramSparseArray.valueAt(paramInt3)).ou(paramList));
      paramInt3 += 1;
    }
    if ((paramContext.size() <= 0) || (paramContext.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(138393);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.ahuJ = ((g)paramContext.get(0)).ahuO;
    paramSparseArray.ahuK = paramContext;
    paramSparseArray.ahtO = paramInt1;
    paramSparseArray.action = paramInt2;
    paramContext = new ArrayList();
    paramContext.add(paramSparseArray);
    locala.ahuB = paramContext;
    locala.imei = "1234567890ABCDEF";
    locala.imsi = "";
    locala.brand = bFv(Build.BRAND);
    locala.model = bFv(q.aPo());
    locala.hyE = bFv(Build.FINGERPRINT);
    locala.ahuD = jXo();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(138393);
    return locala;
  }
  
  private static String bFv(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int jXo()
  {
    AppMethodBeat.i(138394);
    if (ahue == -1)
    {
      SensorManager localSensorManager = (SensorManager)MMApplicationContext.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = ahue;
        AppMethodBeat.o(138394);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < ahud.length)
      {
        if (localSensorManager.getDefaultSensor(ahud[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      ahue = j;
    }
    int i = ahue;
    AppMethodBeat.o(138394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */