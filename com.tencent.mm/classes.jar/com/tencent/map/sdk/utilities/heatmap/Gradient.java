package com.tencent.map.sdk.utilities.heatmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Gradient
  extends com.tencent.map.sdk.utilities.visualization.Gradient
{
  public Gradient(com.tencent.map.sdk.utilities.visualization.Gradient paramGradient)
  {
    super(paramGradient.mColors, paramGradient.mStartPoints, paramGradient.mColorMapSize);
  }
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    super(paramArrayOfInt, paramArrayOfFloat);
  }
  
  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt)
  {
    super(paramArrayOfInt, paramArrayOfFloat, paramInt);
    AppMethodBeat.i(84369);
    AppMethodBeat.o(84369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.Gradient
 * JD-Core Version:    0.7.0.1
 */