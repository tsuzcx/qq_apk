package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class Gradient
{
  private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
  public final int mColorMapSize;
  public int[] mColors;
  public float[] mStartPoints;
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this(paramArrayOfInt, paramArrayOfFloat, 1000);
  }
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt)
  {
    AppMethodBeat.i(84369);
    if (paramArrayOfInt.length != paramArrayOfFloat.length)
    {
      paramArrayOfInt = new IllegalArgumentException("colors and startPoints should be same length");
      AppMethodBeat.o(84369);
      throw paramArrayOfInt;
    }
    if (paramArrayOfInt.length == 0)
    {
      paramArrayOfInt = new IllegalArgumentException("No colors have been defined");
      AppMethodBeat.o(84369);
      throw paramArrayOfInt;
    }
    int i = 1;
    while (i < paramArrayOfFloat.length)
    {
      if (paramArrayOfFloat[i] <= paramArrayOfFloat[(i - 1)])
      {
        paramArrayOfInt = new IllegalArgumentException("startPoints should be in increasing order");
        AppMethodBeat.o(84369);
        throw paramArrayOfInt;
      }
      i += 1;
    }
    this.mColorMapSize = paramInt;
    this.mColors = new int[paramArrayOfInt.length];
    this.mStartPoints = new float[paramArrayOfFloat.length];
    System.arraycopy(paramArrayOfInt, 0, this.mColors, 0, paramArrayOfInt.length);
    System.arraycopy(paramArrayOfFloat, 0, this.mStartPoints, 0, paramArrayOfFloat.length);
    AppMethodBeat.o(84369);
  }
  
  private HashMap<Integer, a> generateColorIntervals()
  {
    AppMethodBeat.i(180750);
    HashMap localHashMap = new HashMap();
    int j;
    float f;
    if (this.mStartPoints[0] != 0.0F)
    {
      i = Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0]));
      j = this.mColors[0];
      f = this.mColorMapSize;
      localHashMap.put(Integer.valueOf(0), new a(i, j, this.mStartPoints[0] * f, (byte)0));
    }
    int i = 1;
    while (i < this.mColors.length)
    {
      j = (int)(this.mColorMapSize * this.mStartPoints[(i - 1)]);
      int k = this.mColors[(i - 1)];
      int m = this.mColors[i];
      f = this.mColorMapSize;
      localHashMap.put(Integer.valueOf(j), new a(k, m, (this.mStartPoints[i] - this.mStartPoints[(i - 1)]) * f, (byte)0));
      i += 1;
    }
    if (this.mStartPoints[(this.mStartPoints.length - 1)] != 1.0F)
    {
      i = this.mStartPoints.length - 1;
      localHashMap.put(Integer.valueOf((int)(this.mColorMapSize * this.mStartPoints[i])), new a(this.mColors[i], this.mColors[i], this.mColorMapSize * (1.0F - this.mStartPoints[i]), (byte)0));
    }
    AppMethodBeat.o(180750);
    return localHashMap;
  }
  
  static int interpolateColor(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = 0;
    AppMethodBeat.i(180751);
    int j = (int)((Color.alpha(paramInt2) - Color.alpha(paramInt1)) * paramFloat + Color.alpha(paramInt1));
    float[] arrayOfFloat1 = new float[3];
    Color.RGBToHSV(Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1), arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    Color.RGBToHSV(Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2), arrayOfFloat2);
    if (arrayOfFloat1[0] - arrayOfFloat2[0] > 180.0F) {
      arrayOfFloat2[0] += 360.0F;
    }
    float[] arrayOfFloat3;
    for (;;)
    {
      arrayOfFloat3 = new float[3];
      paramInt1 = i;
      while (paramInt1 < 3)
      {
        arrayOfFloat3[paramInt1] = ((arrayOfFloat2[paramInt1] - arrayOfFloat1[paramInt1]) * paramFloat + arrayOfFloat1[paramInt1]);
        paramInt1 += 1;
      }
      if (arrayOfFloat2[0] - arrayOfFloat1[0] > 180.0F) {
        arrayOfFloat1[0] += 360.0F;
      }
    }
    paramInt1 = Color.HSVToColor(j, arrayOfFloat3);
    AppMethodBeat.o(180751);
    return paramInt1;
  }
  
  public final int[] generateColorMap(double paramDouble)
  {
    int k = 0;
    AppMethodBeat.i(84371);
    HashMap localHashMap = generateColorIntervals();
    int[] arrayOfInt = new int[this.mColorMapSize];
    a locala = (a)localHashMap.get(Integer.valueOf(0));
    int i = 0;
    int j = 0;
    while (i < this.mColorMapSize)
    {
      if (localHashMap.containsKey(Integer.valueOf(i)))
      {
        locala = (a)localHashMap.get(Integer.valueOf(i));
        j = i;
      }
      float f = (i - j) / locala.c;
      arrayOfInt[i] = interpolateColor(locala.a, locala.b, f);
      i += 1;
    }
    if (paramDouble != 1.0D)
    {
      i = k;
      while (i < this.mColorMapSize)
      {
        j = arrayOfInt[i];
        arrayOfInt[i] = Color.argb((int)(Color.alpha(j) * paramDouble), Color.red(j), Color.green(j), Color.blue(j));
        i += 1;
      }
    }
    AppMethodBeat.o(84371);
    return arrayOfInt;
  }
  
  final class a
  {
    final int a;
    final int b;
    final float c;
    
    private a(int paramInt1, int paramInt2, float paramFloat)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.Gradient
 * JD-Core Version:    0.7.0.1
 */