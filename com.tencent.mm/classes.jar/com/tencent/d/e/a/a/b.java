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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] Mkp = { 1, 5, 4, 8, 9, 2 };
  private static int Mkq = -1;
  
  public static com.tencent.d.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    AppMethodBeat.i(138393);
    com.tencent.d.e.a.b.a locala = new com.tencent.d.e.a.b.a();
    locala.MkM = 0L;
    locala.dCl = "";
    locala.DUt = com.tencent.d.f.i.cA(paramContext, paramContext.getPackageName()).versionCode;
    locala.MiF = "14D6ACDE3C2F2F48";
    locala.channel = 500000;
    locala.requestType = paramInt3;
    locala.MkO = baJ(paramContext.getPackageName());
    ArrayList localArrayList = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      localArrayList.addAll(((i)paramSparseArray.valueAt(paramInt3)).iZ(paramList));
      paramInt3 += 1;
    }
    if ((localArrayList.size() <= 0) || (localArrayList.get(0) == null))
    {
      paramContext = new IllegalArgumentException("invalid stateUnits");
      AppMethodBeat.o(138393);
      throw paramContext;
    }
    paramSparseArray = new e();
    paramSparseArray.MkW = ((g)localArrayList.get(0)).Mlb;
    paramSparseArray.MkX = localArrayList;
    paramSparseArray.MjZ = paramInt1;
    paramSparseArray.action = paramInt2;
    paramList = new ArrayList();
    paramList.add(paramSparseArray);
    locala.MkN = paramList;
    locala.imei = baJ(d.getIMEI(paramContext));
    locala.imsi = baJ(d.ld(paramContext));
    locala.hTy = baJ(Build.BRAND);
    locala.model = baJ(Build.MODEL);
    locala.MkP = baJ(Build.FINGERPRINT);
    locala.MkQ = fYt();
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    AppMethodBeat.o(138393);
    return locala;
  }
  
  private static String baJ(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int fYt()
  {
    AppMethodBeat.i(138394);
    if (Mkq == -1)
    {
      SensorManager localSensorManager = (SensorManager)ak.getContext().getSystemService("sensor");
      if (localSensorManager == null)
      {
        i = Mkq;
        AppMethodBeat.o(138394);
        return i;
      }
      i = 0;
      int j = 1;
      if (i < Mkp.length)
      {
        if (localSensorManager.getDefaultSensor(Mkp[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      Mkq = j;
    }
    int i = Mkq;
    AppMethodBeat.o(138394);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */