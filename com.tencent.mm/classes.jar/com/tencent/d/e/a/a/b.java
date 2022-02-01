package com.tencent.d.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.d.e.a.b.e;
import com.tencent.d.e.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] Zpv = { 1, 5, 4, 8, 9, 2 };
  private static int Zpw = -1;
  
  public static com.tencent.d.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(138393);
    com.tencent.d.e.a.b.a locala = new com.tencent.d.e.a.b.a();
    locala.ZpS = 0L;
    locala.fND = "";
    locala.PzG = com.tencent.d.f.i.df(paramContext, paramContext.getPackageName()).versionCode;
    locala.ZnN = "14D6ACDE3C2F2F48";
    locala.channel = 500000;
    locala.requestType = paramInt3;
    locala.ZpU = bCQ(paramContext.getPackageName());
    paramContext = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      paramContext.addAll(((i)paramSparseArray.valueAt(paramInt3)).kX(paramList));
      paramInt3 += 1;
    }
    if ((paramContext.size() <= 0) || (paramContext.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(138393);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.Zqc = ((g)paramContext.get(0)).Zqh;
    paramSparseArray.Zqd = paramContext;
    paramSparseArray.Zpg = paramInt1;
    paramSparseArray.action = paramInt2;
    paramContext = new ArrayList();
    paramContext.add(paramSparseArray);
    locala.ZpT = paramContext;
    locala.imei = "1234567890ABCDEF";
    locala.imsi = "";
    locala.brand = bCQ(Build.BRAND);
    locala.model = bCQ(Build.MODEL);
    locala.ZpV = bCQ(Build.FINGERPRINT);
    locala.ZpW = iod();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(138393);
    return locala;
  }
  
  private static String bCQ(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int iod()
  {
    AppMethodBeat.i(138394);
    if (Zpw == -1)
    {
      SensorManager localSensorManager = (SensorManager)MMApplicationContext.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = Zpw;
        AppMethodBeat.o(138394);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < Zpv.length)
      {
        if (localSensorManager.getDefaultSensor(Zpv[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      Zpw = j;
    }
    int i = Zpw;
    AppMethodBeat.o(138394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */