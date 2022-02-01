package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class rb
  implements ra
{
  public final BaseOverlayProvider a(ec paramec)
  {
    AppMethodBeat.i(223400);
    if ((!(paramec instanceof ed)) || (!paramec.c()))
    {
      AppMethodBeat.o(223400);
      return null;
    }
    paramec = (ed)paramec;
    GradientVectorOverlayProvider localGradientVectorOverlayProvider = new GradientVectorOverlayProvider();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramec.a.c.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ec.a.a.a locala = (ec.a.a.a)((Iterator)localObject2).next();
      if ((locala instanceof ec.a.a.d)) {
        ((List)localObject1).addAll(((ec.a.a.d)locala).b);
      }
    }
    localGradientVectorOverlayProvider.weightedData((List)localObject1);
    localObject1 = new int[paramec.a.a.a.a.a.b.b.size()];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject1[i] = ((Integer)paramec.a.a.a.a.a.b.b.get(i)).intValue();
      i += 1;
    }
    localObject2 = new float[paramec.a.a.a.a.a.b.a.size()];
    i = 0;
    while (i < localObject1.length)
    {
      localObject2[i] = ((Double)paramec.a.a.a.a.a.b.a.get(i)).floatValue();
      i += 1;
    }
    localGradientVectorOverlayProvider.gradient((int[])localObject1, (float[])localObject2);
    localGradientVectorOverlayProvider.radius(paramec.a.a.a.a.a.a);
    localGradientVectorOverlayProvider.setMaxHeight(((Double)paramec.a.a.b.d.get(1)).floatValue());
    localGradientVectorOverlayProvider.setIntensityRange((float)paramec.a.a.b.b, (float)paramec.a.a.b.a);
    localGradientVectorOverlayProvider.zoomRange(paramec.a.a.b.k, paramec.a.a.b.j);
    localGradientVectorOverlayProvider.zIndex(paramec.a.a.b.g);
    localGradientVectorOverlayProvider.displayLevel(paramec.a.a.b.f);
    localGradientVectorOverlayProvider.enable3D(paramec.a.a.b.c);
    localGradientVectorOverlayProvider.opacity((float)paramec.a.a.b.i);
    boolean bool;
    if (!paramec.a.a.b.h)
    {
      bool = true;
      localGradientVectorOverlayProvider.visibility(bool);
      if ((!paramec.a.a.b.e) || (paramec.a.a.a.a.a.c == null)) {
        break label611;
      }
      localGradientVectorOverlayProvider.setAnimateDuration((int)(paramec.a.a.a.a.a.c.c * 1000.0D));
    }
    for (;;)
    {
      AppMethodBeat.o(223400);
      return localGradientVectorOverlayProvider;
      bool = false;
      break;
      label611:
      localGradientVectorOverlayProvider.setAnimateDuration(0);
    }
  }
  
  public final ec a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223379);
    paramArrayOfByte = (ec)JsonUtils.parseToModel(new String(paramArrayOfByte), ed.class, new Object[0]);
    AppMethodBeat.o(223379);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rb
 * JD-Core Version:    0.7.0.1
 */