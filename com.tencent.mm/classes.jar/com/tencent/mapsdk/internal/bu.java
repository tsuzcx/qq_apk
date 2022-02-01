package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import com.tencent.map.sdk.utilities.heatmap.Gradient;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider.Builder;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider.HeatTileGenerator;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider.OnHeatMapReadyListener;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class bu
  extends HeatMapTileProvider
{
  static final double a = 1.0D;
  private static final boolean b = false;
  private static final int c = 256;
  private static final int d = 1280;
  private static final int e = 5;
  private static final int f = 11;
  private static final int g = 22;
  private final HeatMapTileProvider.OnHeatMapReadyListener h;
  private HeatMapTileProvider.HeatTileGenerator i;
  private fu<bv> j;
  private Collection<bv> k;
  private fk l;
  private int m;
  private Gradient n;
  private int[] o;
  private double[] p;
  private double q;
  private double[] r;
  private boolean s;
  
  public bu(HeatMapTileProvider.Builder paramBuilder)
  {
    AppMethodBeat.i(222441);
    this.k = d(paramBuilder.getData());
    this.m = paramBuilder.getRadius();
    this.n = paramBuilder.getGradient();
    this.q = paramBuilder.getOpacity();
    this.h = paramBuilder.getReadyListener();
    this.i = paramBuilder.getHeatTileGenerator();
    if (this.k != null) {
      jw.a(new jw.g()
      {
        private Boolean a()
        {
          AppMethodBeat.i(222209);
          Boolean localBoolean;
          if (bu.a(bu.this))
          {
            localBoolean = Boolean.FALSE;
            AppMethodBeat.o(222209);
            return localBoolean;
          }
          if (bu.b(bu.this) != null) {
            bu.a(bu.this, bu.b(bu.this).generateKernel(bu.c(bu.this)));
          }
          for (;;)
          {
            bu.this.setGradient(bu.d(bu.this));
            bu.this.a(bu.e(bu.this));
            bu.f(bu.this);
            if (bu.g(bu.this) != null) {
              bu.g(bu.this).onHeatMapReady();
            }
            localBoolean = Boolean.TRUE;
            AppMethodBeat.o(222209);
            return localBoolean;
            bu.a(bu.this, bu.a(bu.c(bu.this), bu.c(bu.this) / 3.0D));
          }
        }
      }).a(Boolean.FALSE);
    }
    AppMethodBeat.o(222441);
  }
  
  private static double a(Collection<bv> paramCollection, fk paramfk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222527);
    double d2 = paramfk.a;
    double d1 = paramfk.c;
    double d3 = paramfk.b;
    double d4 = paramfk.d;
    label87:
    bv localbv;
    double d5;
    if (d1 - d2 > d4 - d3)
    {
      d1 -= d2;
      d4 = (int)(paramInt2 / (paramInt1 * 2) + 0.5D) / d1;
      HashMap localHashMap = new HashMap();
      d1 = 0.0D;
      Iterator localIterator = paramCollection.iterator();
      if (!localIterator.hasNext()) {
        break label276;
      }
      localbv = (bv)localIterator.next();
      d5 = localbv.b.a;
      double d6 = localbv.b.b;
      paramInt1 = (int)((d5 - d2) * d4);
      paramInt2 = (int)((d6 - d3) * d4);
      paramCollection = (Map)localHashMap.get(Integer.valueOf(paramInt1));
      if (paramCollection != null) {
        break label287;
      }
      paramCollection = new HashMap();
      localHashMap.put(Integer.valueOf(paramInt1), paramCollection);
    }
    label276:
    label287:
    for (;;)
    {
      Double localDouble = (Double)paramCollection.get(Integer.valueOf(paramInt2));
      paramfk = localDouble;
      if (localDouble == null) {
        paramfk = Double.valueOf(0.0D);
      }
      d5 = paramfk.doubleValue();
      paramfk = Double.valueOf(localbv.c + d5);
      paramCollection.put(Integer.valueOf(paramInt2), paramfk);
      if (paramfk.doubleValue() > d1) {
        d1 = paramfk.doubleValue();
      }
      for (;;)
      {
        break label87;
        d1 = d4 - d3;
        break;
        AppMethodBeat.o(222527);
        return d1;
      }
    }
  }
  
  private static Bitmap a(double[][] paramArrayOfDouble, int[] paramArrayOfInt, double paramDouble)
  {
    AppMethodBeat.i(222514);
    int i3 = paramArrayOfInt[(paramArrayOfInt.length - 1)];
    paramDouble = (paramArrayOfInt.length - 1) / paramDouble;
    int i4 = paramArrayOfDouble.length;
    int[] arrayOfInt = new int[i4 * i4];
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      if (i2 < i4)
      {
        double d1 = paramArrayOfDouble[i2][i1];
        int i5 = i1 * i4 + i2;
        int i6 = (int)(d1 * paramDouble);
        if (d1 != 0.0D) {
          if (i6 < paramArrayOfInt.length) {
            arrayOfInt[i5] = paramArrayOfInt[i6];
          }
        }
        for (;;)
        {
          i2 += 1;
          break;
          arrayOfInt[i5] = i3;
          continue;
          arrayOfInt[i5] = 0;
        }
      }
      i1 += 1;
    }
    paramArrayOfDouble = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
    paramArrayOfDouble.setPixels(arrayOfInt, 0, i4, 0, 0, i4, i4);
    AppMethodBeat.o(222514);
    return paramArrayOfDouble;
  }
  
  private static Tile a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222466);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = new Tile(256, 256, localByteArrayOutputStream.toByteArray());
    AppMethodBeat.o(222466);
    return paramBitmap;
  }
  
  private void a()
  {
    AppMethodBeat.i(222447);
    if (this.k != null) {
      jw.a(new jw.g()
      {
        private Boolean a()
        {
          AppMethodBeat.i(222209);
          Boolean localBoolean;
          if (bu.a(bu.this))
          {
            localBoolean = Boolean.FALSE;
            AppMethodBeat.o(222209);
            return localBoolean;
          }
          if (bu.b(bu.this) != null) {
            bu.a(bu.this, bu.b(bu.this).generateKernel(bu.c(bu.this)));
          }
          for (;;)
          {
            bu.this.setGradient(bu.d(bu.this));
            bu.this.a(bu.e(bu.this));
            bu.f(bu.this);
            if (bu.g(bu.this) != null) {
              bu.g(bu.this).onHeatMapReady();
            }
            localBoolean = Boolean.TRUE;
            AppMethodBeat.o(222209);
            return localBoolean;
            bu.a(bu.this, bu.a(bu.c(bu.this), bu.c(bu.this) / 3.0D));
          }
        }
      }).a(Boolean.FALSE);
    }
    AppMethodBeat.o(222447);
  }
  
  private double[] a(int paramInt)
  {
    int i3 = 11;
    AppMethodBeat.i(222456);
    double[] arrayOfDouble = new double[22];
    int i1 = 5;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 11) {
        break;
      }
      arrayOfDouble[i1] = a(this.k, this.l, paramInt, (int)(1280.0D * Math.pow(2.0D, i1 - 3)));
      if (i1 == 5)
      {
        i2 = 0;
        while (i2 < i1)
        {
          arrayOfDouble[i2] = arrayOfDouble[i1];
          i2 += 1;
        }
      }
      i1 += 1;
    }
    while (i2 < 22)
    {
      arrayOfDouble[i2] = arrayOfDouble[10];
      i2 += 1;
    }
    AppMethodBeat.o(222456);
    return arrayOfDouble;
  }
  
  static double[] a(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(222488);
    double[] arrayOfDouble = new double[paramInt * 2 + 1];
    int i1 = -paramInt;
    while (i1 <= paramInt)
    {
      arrayOfDouble[(i1 + paramInt)] = Math.exp(-i1 * i1 / (2.0D * paramDouble * paramDouble));
      i1 += 1;
    }
    AppMethodBeat.o(222488);
    return arrayOfDouble;
  }
  
  private static double[][] a(double[][] paramArrayOfDouble, double[] paramArrayOfDouble1)
  {
    AppMethodBeat.i(222502);
    int i1 = (int)Math.floor(paramArrayOfDouble1.length / 2.0D);
    int i7 = paramArrayOfDouble.length;
    int i8 = i7 - i1 * 2;
    int i3 = i1 + i8 - 1;
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i7, i7 });
    int i4 = 0;
    int i5;
    double d1;
    int i6;
    int i2;
    double[] arrayOfDouble1;
    while (i4 < i7)
    {
      i5 = 0;
      while (i5 < i7)
      {
        d1 = paramArrayOfDouble[i4][i5];
        if (d1 != 0.0D)
        {
          if (i3 < i4 + i1)
          {
            i6 = i3;
            if (i1 <= i4 - i1) {
              break label185;
            }
            i2 = i1;
          }
          for (;;)
          {
            if (i2 >= i6 + 1) {
              break label195;
            }
            arrayOfDouble1 = arrayOfDouble[i2];
            arrayOfDouble1[i5] += paramArrayOfDouble1[(i2 - (i4 - i1))] * d1;
            i2 += 1;
            continue;
            i6 = i4 + i1;
            break;
            label185:
            i2 = i4 - i1;
          }
        }
        label195:
        i5 += 1;
      }
      i4 += 1;
    }
    paramArrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { i8, i8 });
    i4 = i1;
    while (i4 < i3 + 1)
    {
      i5 = 0;
      while (i5 < i7)
      {
        d1 = arrayOfDouble[i4][i5];
        if (d1 != 0.0D)
        {
          if (i3 < i5 + i1)
          {
            i6 = i3;
            if (i1 <= i5 - i1) {
              break label369;
            }
            i2 = i1;
          }
          for (;;)
          {
            if (i2 >= i6 + 1) {
              break label379;
            }
            arrayOfDouble1 = paramArrayOfDouble[(i4 - i1)];
            i8 = i2 - i1;
            arrayOfDouble1[i8] += paramArrayOfDouble1[(i2 - (i5 - i1))] * d1;
            i2 += 1;
            continue;
            i6 = i5 + i1;
            break;
            label369:
            i2 = i5 - i1;
          }
        }
        label379:
        i5 += 1;
      }
      i4 += 1;
    }
    AppMethodBeat.o(222502);
    return paramArrayOfDouble;
  }
  
  private static fk b(Collection<bv> paramCollection)
  {
    AppMethodBeat.i(222479);
    paramCollection = paramCollection.iterator();
    bv localbv = (bv)paramCollection.next();
    double d7 = localbv.b.a;
    double d3 = localbv.b.a;
    double d2 = localbv.b.b;
    double d1 = localbv.b.b;
    while (paramCollection.hasNext())
    {
      localbv = (bv)paramCollection.next();
      double d8 = localbv.b.a;
      double d4 = localbv.b.b;
      double d5 = d7;
      if (d8 < d7) {
        d5 = d8;
      }
      double d6 = d3;
      if (d8 > d3) {
        d6 = d8;
      }
      d8 = d2;
      if (d4 < d2) {
        d8 = d4;
      }
      d7 = d5;
      d3 = d6;
      d2 = d8;
      if (d4 > d1)
      {
        d1 = d4;
        d7 = d5;
        d3 = d6;
        d2 = d8;
      }
    }
    paramCollection = new fk(d7, d3, d2, d1);
    AppMethodBeat.o(222479);
    return paramCollection;
  }
  
  private static Collection<bv> c(Collection<LatLng> paramCollection)
  {
    AppMethodBeat.i(222537);
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new bv((LatLng)paramCollection.next()));
    }
    AppMethodBeat.o(222537);
    return localArrayList;
  }
  
  private static <T extends WeightedLatLng> Collection<bv> d(Collection<T> paramCollection)
  {
    AppMethodBeat.i(222548);
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      WeightedLatLng localWeightedLatLng = (WeightedLatLng)paramCollection.next();
      localArrayList.add(new bv(localWeightedLatLng.getPoint(), localWeightedLatLng.getIntensity()));
    }
    AppMethodBeat.o(222548);
    return localArrayList;
  }
  
  public final void a(Collection<bv> paramCollection)
  {
    AppMethodBeat.i(222648);
    this.k = paramCollection;
    if (this.k.isEmpty())
    {
      paramCollection = new IllegalArgumentException("No input points.");
      AppMethodBeat.o(222648);
      throw paramCollection;
    }
    this.l = b(this.k);
    this.j = new fu(this.l);
    paramCollection = this.k.iterator();
    while (paramCollection.hasNext())
    {
      bv localbv = (bv)paramCollection.next();
      this.j.a(localbv);
    }
    this.r = a(this.m);
    AppMethodBeat.o(222648);
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222626);
    if (!this.s)
    {
      kh.d("TileOverlay", "热力图未初始化完成，返回空瓦块");
      localObject1 = TileProvider.NO_TILE;
      AppMethodBeat.o(222626);
      return localObject1;
    }
    double d1 = 1.0D / Math.pow(2.0D, paramInt3);
    double d2 = this.m * d1 / 256.0D;
    double d3 = (2.0D * d2 + d1) / (this.m * 2 + 256);
    double d4 = paramInt1 * d1 - d2;
    double d5 = (paramInt1 + 1) * d1 + d2;
    double d6 = paramInt2 * d1 - d2;
    double d7 = d1 * (paramInt2 + 1) + d2;
    Object localObject1 = new ArrayList();
    if (d4 < 0.0D)
    {
      localObject1 = new fk(1.0D + d4, 1.0D, d6, d7);
      localObject1 = this.j.a((fk)localObject1);
      d1 = -1.0D;
    }
    for (;;)
    {
      Object localObject2 = new fk(d4, d5, d6, d7);
      if (!((fk)localObject2).a(new fk(this.l.a - d2, this.l.c + d2, this.l.b - d2, d2 + this.l.d)))
      {
        kh.d("TileOverlay", "热力图超出有效边界，返回空瓦块-" + paramInt1 + ":" + paramInt2 + ":" + paramInt3);
        localObject1 = TileProvider.NO_TILE;
        AppMethodBeat.o(222626);
        return localObject1;
        if (d5 > 1.0D)
        {
          localObject1 = new fk(0.0D, d5 - 1.0D, d6, d7);
          localObject1 = this.j.a((fk)localObject1);
          d1 = 1.0D;
        }
      }
      else
      {
        Object localObject3 = this.j.a((fk)localObject2);
        if (((Collection)localObject3).isEmpty())
        {
          kh.d("TileOverlay", "热力图没有热力数据，返回空瓦块-" + paramInt1 + ":" + paramInt2 + ":" + paramInt3);
          localObject1 = TileProvider.NO_TILE;
          AppMethodBeat.o(222626);
          return localObject1;
        }
        paramInt1 = this.m;
        paramInt2 = this.m;
        localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { paramInt1 * 2 + 256, paramInt2 * 2 + 256 });
        localObject3 = ((Collection)localObject3).iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bv)((Iterator)localObject3).next();
          fl localfl = ((bv)localObject4).b;
          paramInt1 = (int)((localfl.a - d4) / d3);
          paramInt2 = (int)((localfl.b - d6) / d3);
          localfl = localObject2[paramInt1];
          localfl[paramInt2] += ((bv)localObject4).c;
        }
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (bv)((Iterator)localObject1).next();
          localObject4 = ((bv)localObject3).b;
          paramInt1 = (int)((((fl)localObject4).a + d1 - d4) / d3);
          paramInt2 = (int)((((fl)localObject4).b - d6) / d3);
          localObject4 = localObject2[paramInt1];
          localObject4[paramInt2] += ((bv)localObject3).c;
        }
        localObject1 = a(a((double[][])localObject2, this.p), this.o, this.r[paramInt3]);
        localObject2 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
        localObject1 = new Tile(256, 256, ((ByteArrayOutputStream)localObject2).toByteArray());
        AppMethodBeat.o(222626);
        return localObject1;
      }
      d1 = 0.0D;
    }
  }
  
  public final void setData(Collection<LatLng> paramCollection)
  {
    AppMethodBeat.i(222656);
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new bv((LatLng)paramCollection.next()));
    }
    a(localArrayList);
    AppMethodBeat.o(222656);
  }
  
  public final void setGradient(Gradient paramGradient)
  {
    AppMethodBeat.i(222666);
    this.n = paramGradient;
    if (this.i != null)
    {
      this.o = this.i.generateColorMap(this.q);
      AppMethodBeat.o(222666);
      return;
    }
    this.o = this.n.generateColorMap(this.q);
    AppMethodBeat.o(222666);
  }
  
  public final void setHeatTileGenerator(HeatMapTileProvider.HeatTileGenerator paramHeatTileGenerator)
  {
    AppMethodBeat.i(222687);
    this.i = paramHeatTileGenerator;
    if (this.i != null)
    {
      this.p = this.i.generateKernel(this.m);
      this.o = this.i.generateColorMap(this.q);
    }
    AppMethodBeat.o(222687);
  }
  
  public final void setOpacity(double paramDouble)
  {
    AppMethodBeat.i(222680);
    this.q = paramDouble;
    setGradient(this.n);
    AppMethodBeat.o(222680);
  }
  
  public final void setRadius(int paramInt)
  {
    AppMethodBeat.i(222674);
    this.m = paramInt;
    if (this.i != null) {}
    for (this.p = this.i.generateKernel(this.m);; this.p = a(this.m, this.m / 3.0D))
    {
      this.r = a(this.m);
      AppMethodBeat.o(222674);
      return;
    }
  }
  
  public final <T extends WeightedLatLng> void setWeightedData(Collection<T> paramCollection)
  {
    AppMethodBeat.i(222639);
    a(d(paramCollection));
    AppMethodBeat.o(222639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bu
 * JD-Core Version:    0.7.0.1
 */