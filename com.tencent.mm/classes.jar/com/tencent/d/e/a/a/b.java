package com.tencent.d.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.d.e.a.b.e;
import com.tencent.d.e.a.b.g;
import com.tencent.d.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] JTA = { 1, 5, 4, 8, 9, 2 };
  private static int JTB = -1;
  
  public static com.tencent.d.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(138393);
    com.tencent.d.e.a.b.a locala = new com.tencent.d.e.a.b.a();
    locala.JTX = 0L;
    locala.dpt = "";
    locala.BZA = com.tencent.d.f.i.cu(paramContext, paramContext.getPackageName()).versionCode;
    locala.JRO = "14D6ACDE3C2F2F48";
    locala.channel = 500000;
    locala.requestType = paramInt3;
    locala.JTZ = aTg(paramContext.getPackageName());
    ArrayList localArrayList = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      localArrayList.addAll(((i)paramSparseArray.valueAt(paramInt3)).iC(paramList));
      paramInt3 += 1;
    }
    if ((localArrayList.size() <= 0) || (localArrayList.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(138393);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.JUh = ((g)localArrayList.get(0)).JUm;
    paramSparseArray.JUi = localArrayList;
    paramSparseArray.JTj = paramInt1;
    paramSparseArray.action = paramInt2;
    paramList = new ArrayList();
    paramList.add(paramSparseArray);
    locala.JTY = paramList;
    locala.imei = aTg(d.getIMEI(paramContext));
    locala.imsi = aTg(d.kJ(paramContext));
    locala.hym = aTg(Build.BRAND);
    locala.model = aTg(Build.MODEL);
    locala.JUa = aTg(Build.FINGERPRINT);
    locala.JUb = fCD();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(138393);
    return locala;
  }
  
  private static String aTg(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int fCD()
  {
    AppMethodBeat.i(138394);
    if (JTB == -1)
    {
      SensorManager localSensorManager = (SensorManager)ai.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = JTB;
        AppMethodBeat.o(138394);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < JTA.length)
      {
        if (localSensorManager.getDefaultSensor(JTA[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      JTB = j;
    }
    int i = JTB;
    AppMethodBeat.o(138394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */