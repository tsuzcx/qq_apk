package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class HeatMapTileProvider
  implements TileProvider
{
  public static final Gradient DEFAULT_GRADIENT = new Gradient(DEFAULT_GRADIENT_COLORS, DEFAULT_GRADIENT_START_POINTS);
  private static final int[] DEFAULT_GRADIENT_COLORS = { Color.argb(0, 25, 0, 255), Color.argb(170, 30, 0, 255), Color.rgb(0, 191, 255), Color.rgb(0, 255, 0), Color.rgb(255, 255, 0), Color.rgb(255, 0, 0) };
  private static final float[] DEFAULT_GRADIENT_START_POINTS = { 0.0F, 0.4F, 0.6F, 0.75F, 0.8F, 1.0F };
  public static final double DEFAULT_OPACITY = 0.6D;
  public static final int DEFAULT_RADIUS = 40;
  private static final int MAX_RADIUS = 50;
  private static final int MIN_RADIUS = 10;
  static final double WORLD_WIDTH = 1.0D;
  
  private static Collection<WeightedLatLng> wrapData(Collection<LatLng> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new WeightedLatLng((LatLng)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public abstract void setData(Collection<LatLng> paramCollection);
  
  public abstract void setGradient(Gradient paramGradient);
  
  public abstract void setHeatTileGenerator(HeatTileGenerator paramHeatTileGenerator);
  
  public abstract void setOpacity(double paramDouble);
  
  public abstract void setRadius(int paramInt);
  
  public abstract void setWeightedData(Collection<WeightedLatLng> paramCollection);
  
  public static class Builder
  {
    private Collection<WeightedLatLng> data;
    private Gradient gradient = HeatMapTileProvider.DEFAULT_GRADIENT;
    private HeatMapTileProvider.HeatTileGenerator heatTileGenerator;
    private double opacity = 0.6D;
    private int radius = 40;
    private HeatMapTileProvider.OnHeatMapReadyListener readyListener;
    
    public HeatMapTileProvider build(TencentMap paramTencentMap)
    {
      AppMethodBeat.i(180752);
      if (paramTencentMap != null)
      {
        paramTencentMap = paramTencentMap.getMapContext().createHeatMapTileProvider(this);
        AppMethodBeat.o(180752);
        return paramTencentMap;
      }
      AppMethodBeat.o(180752);
      return null;
    }
    
    public Builder data(Collection<LatLng> paramCollection)
    {
      AppMethodBeat.i(84375);
      paramCollection = weightedData(HeatMapTileProvider.wrapData(paramCollection));
      AppMethodBeat.o(84375);
      return paramCollection;
    }
    
    public Collection<WeightedLatLng> getData()
    {
      return this.data;
    }
    
    public Gradient getGradient()
    {
      return this.gradient;
    }
    
    public HeatMapTileProvider.HeatTileGenerator getHeatTileGenerator()
    {
      return this.heatTileGenerator;
    }
    
    public double getOpacity()
    {
      return this.opacity;
    }
    
    public int getRadius()
    {
      return this.radius;
    }
    
    public HeatMapTileProvider.OnHeatMapReadyListener getReadyListener()
    {
      return this.readyListener;
    }
    
    public Builder gradient(Gradient paramGradient)
    {
      this.gradient = paramGradient;
      return this;
    }
    
    public Builder opacity(double paramDouble)
    {
      AppMethodBeat.i(84377);
      if ((paramDouble < 0.0D) || (paramDouble > 1.0D))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Opacity must be in range [0, 1]");
        AppMethodBeat.o(84377);
        throw localIllegalArgumentException;
      }
      this.opacity = paramDouble;
      AppMethodBeat.o(84377);
      return this;
    }
    
    public Builder radius(int paramInt)
    {
      AppMethodBeat.i(84378);
      if ((paramInt < 10) || (paramInt > 50))
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Radius not within bounds.");
        AppMethodBeat.o(84378);
        throw localIllegalArgumentException;
      }
      this.radius = paramInt;
      AppMethodBeat.o(84378);
      return this;
    }
    
    public Builder readyListener(HeatMapTileProvider.OnHeatMapReadyListener paramOnHeatMapReadyListener)
    {
      this.readyListener = paramOnHeatMapReadyListener;
      return this;
    }
    
    public Builder tileGenerator(HeatMapTileProvider.HeatTileGenerator paramHeatTileGenerator)
    {
      this.heatTileGenerator = paramHeatTileGenerator;
      return this;
    }
    
    public Builder weightedData(Collection<WeightedLatLng> paramCollection)
    {
      AppMethodBeat.i(84376);
      if (paramCollection.isEmpty())
      {
        paramCollection = new IllegalArgumentException("No input points.");
        AppMethodBeat.o(84376);
        throw paramCollection;
      }
      this.data = paramCollection;
      AppMethodBeat.o(84376);
      return this;
    }
  }
  
  public static abstract interface HeatTileGenerator
  {
    public abstract int[] generateColorMap(double paramDouble);
    
    public abstract double[] generateKernel(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider
 * JD-Core Version:    0.7.0.1
 */