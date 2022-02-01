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
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] LNq = { 1, 5, 4, 8, 9, 2 };
  private static int LNr = -1;
  
  public static com.tencent.d.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(138393);
    com.tencent.d.e.a.b.a locala = new com.tencent.d.e.a.b.a();
    locala.LNN = 0L;
    locala.dBg = "";
    locala.DCw = com.tencent.d.f.i.cz(paramContext, paramContext.getPackageName()).versionCode;
    locala.LLG = "14D6ACDE3C2F2F48";
    locala.channel = 500000;
    locala.requestType = paramInt3;
    locala.LNP = aZg(paramContext.getPackageName());
    ArrayList localArrayList = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      localArrayList.addAll(((i)paramSparseArray.valueAt(paramInt3)).iQ(paramList));
      paramInt3 += 1;
    }
    if ((localArrayList.size() <= 0) || (localArrayList.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(138393);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.LNX = ((g)localArrayList.get(0)).LOc;
    paramSparseArray.LNY = localArrayList;
    paramSparseArray.LNa = paramInt1;
    paramSparseArray.action = paramInt2;
    paramList = new ArrayList();
    paramList.add(paramSparseArray);
    locala.LNO = paramList;
    locala.imei = aZg(d.getIMEI(paramContext));
    locala.imsi = aZg(d.kW(paramContext));
    locala.hQG = aZg(Build.BRAND);
    locala.model = aZg(Build.MODEL);
    locala.LNQ = aZg(Build.FINGERPRINT);
    locala.LNR = fTT();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(138393);
    return locala;
  }
  
  private static String aZg(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int fTT()
  {
    AppMethodBeat.i(138394);
    if (LNr == -1)
    {
      SensorManager localSensorManager = (SensorManager)aj.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = LNr;
        AppMethodBeat.o(138394);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < LNq.length)
      {
        if (localSensorManager.getDefaultSensor(LNq[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      LNr = j;
    }
    int i = LNr;
    AppMethodBeat.o(138394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */