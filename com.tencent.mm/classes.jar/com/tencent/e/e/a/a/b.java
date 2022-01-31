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
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] BkN = { 1, 5, 4, 8, 9, 2 };
  private static int BkO = -1;
  
  public static com.tencent.e.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(114552);
    com.tencent.e.e.a.b.a locala = new com.tencent.e.e.a.b.a();
    locala.Blj = 0L;
    locala.feA = "";
    locala.uKe = com.tencent.e.f.i.cc(paramContext, paramContext.getPackageName()).versionCode;
    locala.Bjb = "14D6ACDE3C2F2F48";
    locala.cCy = 500000;
    locala.requestType = paramInt3;
    locala.Bll = awy(paramContext.getPackageName());
    ArrayList localArrayList = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      localArrayList.addAll(((i)paramSparseArray.valueAt(paramInt3)).fJ(paramList));
      paramInt3 += 1;
    }
    if ((localArrayList.size() <= 0) || (localArrayList.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(114552);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.Blt = ((g)localArrayList.get(0)).Bly;
    paramSparseArray.Blu = localArrayList;
    paramSparseArray.Bkw = paramInt1;
    paramSparseArray.action = paramInt2;
    paramList = new ArrayList();
    paramList.add(paramSparseArray);
    locala.Blk = paramList;
    locala.imei = awy(d.getIMEI(paramContext));
    locala.imsi = awy(d.jb(paramContext));
    locala.fwM = awy(Build.BRAND);
    locala.model = awy(Build.MODEL);
    locala.Blm = awy(Build.FINGERPRINT);
    locala.Bln = dUH();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(114552);
    return locala;
  }
  
  private static String awy(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int dUH()
  {
    AppMethodBeat.i(145986);
    if (BkO == -1)
    {
      SensorManager localSensorManager = (SensorManager)ah.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = BkO;
        AppMethodBeat.o(145986);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < BkN.length)
      {
        if (localSensorManager.getDefaultSensor(BkN[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      BkO = j;
    }
    int i = BkO;
    AppMethodBeat.o(145986);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.e.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */