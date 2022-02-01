package com.tencent.e.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.e.e.a.b.e;
import com.tencent.e.e.a.b.g;
import com.tencent.e.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] RMP = { 1, 5, 4, 8, 9, 2 };
  private static int RMQ = -1;
  
  public static com.tencent.e.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(138393);
    com.tencent.e.e.a.b.a locala = new com.tencent.e.e.a.b.a();
    locala.RNm = 0L;
    locala.dUb = "";
    locala.IFo = com.tencent.e.f.i.cU(paramContext, paramContext.getPackageName()).versionCode;
    locala.RLg = "14D6ACDE3C2F2F48";
    locala.channel = 500000;
    locala.requestType = paramInt3;
    locala.RNo = bpY(paramContext.getPackageName());
    ArrayList localArrayList = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      localArrayList.addAll(((i)paramSparseArray.valueAt(paramInt3)).kd(paramList));
      paramInt3 += 1;
    }
    if ((localArrayList.size() <= 0) || (localArrayList.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(138393);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.RNw = ((g)localArrayList.get(0)).RNB;
    paramSparseArray.RNx = localArrayList;
    paramSparseArray.RMA = paramInt1;
    paramSparseArray.action = paramInt2;
    paramList = new ArrayList();
    paramList.add(paramSparseArray);
    locala.RNn = paramList;
    locala.imei = bpY(d.getIMEI(paramContext));
    locala.imsi = bpY(d.kY(paramContext));
    locala.brand = bpY(Build.BRAND);
    locala.model = bpY(Build.MODEL);
    locala.RNp = bpY(Build.FINGERPRINT);
    locala.RNq = hkF();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(138393);
    return locala;
  }
  
  private static String bpY(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int hkF()
  {
    AppMethodBeat.i(138394);
    if (RMQ == -1)
    {
      SensorManager localSensorManager = (SensorManager)MMApplicationContext.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = RMQ;
        AppMethodBeat.o(138394);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < RMP.length)
      {
        if (localSensorManager.getDefaultSensor(RMP[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      RMQ = j;
    }
    int i = RMQ;
    AppMethodBeat.o(138394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */