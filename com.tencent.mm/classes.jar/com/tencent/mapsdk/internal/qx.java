package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.HoneyCombVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.SquareVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class qx
  implements ra
{
  public final BaseOverlayProvider a(ec paramec)
  {
    AppMethodBeat.i(226165);
    if ((!(paramec instanceof dx)) || (!paramec.c()))
    {
      AppMethodBeat.o(226165);
      return null;
    }
    dx localdx = (dx)paramec;
    if (localdx.a.a.a.a.a.c.equals("hexagon")) {
      paramec = new HoneyCombVectorOverlayProvider();
    }
    for (;;)
    {
      if (paramec == null)
      {
        AppMethodBeat.o(226165);
        return null;
        if (localdx.a.a.a.a.a.c.equals("grid")) {
          paramec = new SquareVectorOverlayProvider();
        }
      }
      else
      {
        Object localObject1 = new ArrayList();
        Object localObject2 = localdx.a.c.b.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ec.a.a.a locala = (ec.a.a.a)((Iterator)localObject2).next();
          if ((locala instanceof ec.a.a.d)) {
            ((List)localObject1).addAll(((ec.a.a.d)locala).b);
          }
        }
        paramec = paramec.nodes((WeightedLatLng[])((List)localObject1).toArray(new WeightedLatLng[0]));
        localObject1 = new int[localdx.a.a.a.a.a.d.b.size()];
        int i = 0;
        while (i < localObject1.length)
        {
          localObject1[i] = ((Integer)localdx.a.a.a.a.a.d.b.get(i)).intValue();
          i += 1;
        }
        localObject2 = new double[localdx.a.a.a.a.a.d.a.size()];
        i = 0;
        while (i < localObject1.length)
        {
          localObject2[i] = ((Double)localdx.a.a.a.a.a.d.a.get(i)).doubleValue();
          i += 1;
        }
        paramec.colors((int[])localObject1, (double[])localObject2);
        paramec.size(localdx.a.a.a.a.a.b);
        paramec.gap(localdx.a.a.a.a.a.a);
        paramec.setHeightRange(((Double)localdx.a.a.b.d.get(0)).doubleValue(), ((Double)localdx.a.a.b.d.get(1)).doubleValue());
        paramec.setIntensityRange(localdx.a.a.b.b, localdx.a.a.b.a);
        paramec.zoomRange(localdx.a.a.b.k, localdx.a.a.b.j);
        paramec.zIndex(localdx.a.a.b.g);
        paramec.displayLevel(localdx.a.a.b.f);
        paramec.enable3D(localdx.a.a.b.c);
        paramec.opacity((float)localdx.a.a.b.i);
        boolean bool;
        if (!localdx.a.a.b.h)
        {
          bool = true;
          paramec.visibility(bool);
          if ((!localdx.a.a.b.e) || (localdx.a.a.a.a.a.e == null)) {
            break label758;
          }
          paramec.setAnimateDuration((int)(localdx.a.a.a.a.a.e.c * 1000.0D));
        }
        for (;;)
        {
          AppMethodBeat.o(226165);
          return paramec;
          bool = false;
          break;
          label758:
          paramec.setAnimateDuration(0);
        }
      }
      paramec = null;
    }
  }
  
  public final ec a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226143);
    paramArrayOfByte = (ec)JsonUtils.parseToModel(new String(paramArrayOfByte), dx.class, new Object[0]);
    AppMethodBeat.o(226143);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qx
 * JD-Core Version:    0.7.0.1
 */