package com.tencent.d.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.d.e.a.b.e;
import com.tencent.d.e.a.b.g;
import com.tencent.d.f.d;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private static final int[] wNo = { 1, 5, 4, 8, 9, 2 };
  private static int wNp = -1;
  
  public static com.tencent.d.e.a.b.a a(int paramInt1, int paramInt2, Context paramContext, int paramInt3, SparseArray<i> paramSparseArray, List<k> paramList)
  {
    com.tencent.d.e.a.b.a locala = new com.tencent.d.e.a.b.a();
    locala.wNK = 0L;
    locala.wNL = "";
    locala.qUT = com.tencent.d.f.i.bN(paramContext, paramContext.getPackageName()).versionCode;
    locala.wLC = "14D6ACDE3C2F2F48";
    locala.bUR = 500000;
    locala.requestType = paramInt3;
    locala.wNN = afC(paramContext.getPackageName());
    ArrayList localArrayList = new ArrayList();
    paramInt3 = 0;
    while (paramInt3 < paramSparseArray.size())
    {
      localArrayList.addAll(((i)paramSparseArray.valueAt(paramInt3)).ex(paramList));
      paramInt3 += 1;
    }
    if ((localArrayList.size() <= 0) || (localArrayList.get(0) == null)) {
      throw new IllegalArgumentException("invalid stateUnits");
    }
    paramSparseArray = new e();
    paramSparseArray.wNV = ((g)localArrayList.get(0)).wOa;
    paramSparseArray.wNW = localArrayList;
    paramSparseArray.wMX = paramInt1;
    paramSparseArray.action = paramInt2;
    paramList = new ArrayList();
    paramList.add(paramSparseArray);
    locala.wNM = paramList;
    locala.imei = afC(d.getIMEI(paramContext));
    locala.imsi = afC(d.hA(paramContext));
    locala.egI = afC(Build.BRAND);
    locala.model = afC(Build.MODEL);
    locala.wNO = afC(Build.FINGERPRINT);
    locala.wNP = hy(paramContext);
    locala.sdkVer = Build.VERSION.SDK_INT;
    locala.platform = 2;
    return locala;
  }
  
  private static String afC(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static int hy(Context paramContext)
  {
    if (wNp == -1)
    {
      paramContext = (SensorManager)paramContext.getSystemService("sensor");
      if (paramContext == null) {
        return wNp;
      }
      int i = 0;
      int j = 1;
      if (i < wNo.length)
      {
        if (paramContext.getDefaultSensor(wNo[i]) == null) {}
        for (int k = 0;; k = 1)
        {
          j |= k << i;
          i += 1;
          break;
        }
      }
      wNp = j;
    }
    return wNp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */