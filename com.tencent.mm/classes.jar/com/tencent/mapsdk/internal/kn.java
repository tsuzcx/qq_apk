package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class kn
{
  private static double a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    return (1.0D - paramFloat) * (1.0D - paramFloat) * paramInt1 + 2.0F * paramFloat * (1.0D - paramFloat) * paramInt2 + paramFloat * paramFloat * paramInt3;
  }
  
  private static double a(fl paramfl1, fl paramfl2)
  {
    AppMethodBeat.i(222484);
    double d1 = paramfl2.a - paramfl1.a;
    double d2 = paramfl2.b - paramfl1.b;
    d1 = Math.sqrt(d1 * d1 + d2 * d2);
    AppMethodBeat.o(222484);
    return d1;
  }
  
  private static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    float f1 = (paramInt2 - paramInt1) * 3.0F;
    float f2 = (paramInt3 - paramInt2) * 3.0F - f1;
    float f3 = paramInt4 - paramInt1;
    float f4 = paramFloat * paramFloat;
    return f1 * paramFloat + (f2 * f4 + (f3 - f1 - f2) * (f4 * paramFloat)) + paramInt1;
  }
  
  private static int a(List<GeoPoint> paramList, int[] paramArrayOfInt, ep paramep)
  {
    AppMethodBeat.i(222433);
    if (paramList == null)
    {
      AppMethodBeat.o(222433);
      return 0;
    }
    int k = paramList.size();
    if (k < 2)
    {
      AppMethodBeat.o(222433);
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < k - 1)
    {
      Object localObject2 = (GeoPoint)paramList.get(i);
      Object localObject1 = (GeoPoint)paramList.get(i + 1);
      localObject2 = paramep.a((GeoPoint)localObject2);
      localObject1 = paramep.a((GeoPoint)localObject1);
      double d1 = ((fl)localObject1).a - ((fl)localObject2).a;
      double d2 = ((fl)localObject1).b - ((fl)localObject2).b;
      d1 = Math.sqrt(d2 * d2 + d1 * d1);
      int m = (int)d1 / 500;
      m = (int)d1 / Math.max(4, m * 4);
      paramArrayOfInt[i] = m;
      j += m;
      i += 1;
    }
    AppMethodBeat.o(222433);
    return j;
  }
  
  private static GeoPoint a(List<GeoPoint> paramList, float paramFloat)
  {
    AppMethodBeat.i(222454);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(222454);
      return null;
    }
    int i = paramList.size();
    if ((i != 3) && (i != 4))
    {
      AppMethodBeat.o(222454);
      return null;
    }
    if (i == 3)
    {
      localGeoPoint1 = (GeoPoint)paramList.get(0);
      localGeoPoint2 = (GeoPoint)paramList.get(1);
      paramList = (GeoPoint)paramList.get(2);
      if ((localGeoPoint1 == null) || (localGeoPoint2 == null) || (paramList == null))
      {
        AppMethodBeat.o(222454);
        return null;
      }
      i = (int)a(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6(), paramList.getLongitudeE6(), paramFloat);
      paramList = new GeoPoint((int)a(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6(), paramList.getLatitudeE6(), paramFloat), i);
      AppMethodBeat.o(222454);
      return paramList;
    }
    GeoPoint localGeoPoint1 = (GeoPoint)paramList.get(0);
    GeoPoint localGeoPoint2 = (GeoPoint)paramList.get(1);
    GeoPoint localGeoPoint3 = (GeoPoint)paramList.get(2);
    paramList = (GeoPoint)paramList.get(3);
    if ((localGeoPoint1 == null) || (localGeoPoint2 == null) || (localGeoPoint3 == null) || (paramList == null))
    {
      AppMethodBeat.o(222454);
      return null;
    }
    i = (int)a(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6(), localGeoPoint3.getLongitudeE6(), paramList.getLongitudeE6(), paramFloat);
    paramList = new GeoPoint((int)a(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6(), localGeoPoint3.getLatitudeE6(), paramList.getLatitudeE6(), paramFloat), i);
    AppMethodBeat.o(222454);
    return paramList;
  }
  
  private static List<GeoPoint> a(List<GeoPoint> paramList, int paramInt)
  {
    AppMethodBeat.i(222446);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(222446);
      return null;
    }
    int m = paramList.size();
    ArrayList localArrayList = new ArrayList(paramInt);
    GeoPoint localGeoPoint1 = (GeoPoint)paramList.get(0);
    GeoPoint localGeoPoint2 = (GeoPoint)paramList.get(m - 1);
    int j = (localGeoPoint1.getLongitudeE6() + localGeoPoint2.getLongitudeE6()) / 2;
    int k = (localGeoPoint1.getLatitudeE6() + localGeoPoint2.getLatitudeE6()) / 2;
    int i = 0;
    while (i < m)
    {
      localGeoPoint1 = (GeoPoint)paramList.get(i);
      localGeoPoint1.setLongitudeE6(localGeoPoint1.getLongitudeE6() - j);
      localGeoPoint1.setLatitudeE6(localGeoPoint1.getLatitudeE6() - k);
      i += 1;
    }
    float f2 = 1.0F / (paramInt + 1);
    i = 0;
    float f1 = f2;
    if (i < paramInt) {
      if ((paramList == null) || (paramList.isEmpty()))
      {
        localGeoPoint1 = null;
        label192:
        if (localGeoPoint1 == null) {
          break label539;
        }
        localGeoPoint1.setLongitudeE6(localGeoPoint1.getLongitudeE6() + j);
        localGeoPoint1.setLatitudeE6(localGeoPoint1.getLatitudeE6() + k);
        localArrayList.add(localGeoPoint1);
        f1 += f2;
      }
    }
    label539:
    for (;;)
    {
      i += 1;
      break;
      m = paramList.size();
      if ((m != 3) && (m != 4))
      {
        localGeoPoint1 = null;
        break label192;
      }
      if (m == 3)
      {
        localGeoPoint1 = (GeoPoint)paramList.get(0);
        localGeoPoint2 = (GeoPoint)paramList.get(1);
        localGeoPoint3 = (GeoPoint)paramList.get(2);
        if ((localGeoPoint1 == null) || (localGeoPoint2 == null) || (localGeoPoint3 == null))
        {
          localGeoPoint1 = null;
          break label192;
        }
        m = (int)a(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6(), localGeoPoint3.getLongitudeE6(), f1);
        localGeoPoint1 = new GeoPoint((int)a(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6(), localGeoPoint3.getLatitudeE6(), f1), m);
        break label192;
      }
      localGeoPoint1 = (GeoPoint)paramList.get(0);
      localGeoPoint2 = (GeoPoint)paramList.get(1);
      GeoPoint localGeoPoint3 = (GeoPoint)paramList.get(2);
      GeoPoint localGeoPoint4 = (GeoPoint)paramList.get(3);
      if ((localGeoPoint1 == null) || (localGeoPoint2 == null) || (localGeoPoint3 == null) || (localGeoPoint4 == null))
      {
        localGeoPoint1 = null;
        break label192;
      }
      m = (int)a(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6(), localGeoPoint3.getLongitudeE6(), localGeoPoint4.getLongitudeE6(), f1);
      localGeoPoint1 = new GeoPoint((int)a(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6(), localGeoPoint3.getLatitudeE6(), localGeoPoint4.getLatitudeE6(), f1), m);
      break label192;
      AppMethodBeat.o(222446);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kn
 * JD-Core Version:    0.7.0.1
 */