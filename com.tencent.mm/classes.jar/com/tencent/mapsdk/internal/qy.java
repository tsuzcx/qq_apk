package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class qy
  implements ra
{
  public final BaseOverlayProvider a(ec paramec)
  {
    AppMethodBeat.i(226141);
    if ((!(paramec instanceof dy)) || (!paramec.c()))
    {
      AppMethodBeat.o(226141);
      return null;
    }
    paramec = (dy)paramec;
    ArcLineOverlayProvider localArcLineOverlayProvider = new ArcLineOverlayProvider();
    Object localObject1;
    if (paramec.a.c.b != null)
    {
      localObject1 = new ArrayList();
      Iterator localIterator = paramec.a.c.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (ec.a.a.a)localIterator.next();
        if ((localObject2 instanceof ec.a.a.b))
        {
          localObject2 = (ec.a.a.b)localObject2;
          ((List)localObject1).add(new FromToLatLng((LatLng)((ec.a.a.b)localObject2).b.get(0), (LatLng)((ec.a.a.b)localObject2).b.get(1)));
        }
      }
      localArcLineOverlayProvider.data((List)localObject1);
    }
    if (paramec.a.a.a.a.a.c != null)
    {
      localObject1 = new int[paramec.a.a.a.a.a.c.b.size()];
      int i = 0;
      while (i < localObject1.length)
      {
        localObject1[i] = ((Integer)paramec.a.a.a.a.a.c.b.get(i)).intValue();
        i += 1;
      }
      localArcLineOverlayProvider.gradient((int[])localObject1);
    }
    localArcLineOverlayProvider.width(paramec.a.a.a.a.a.a);
    localArcLineOverlayProvider.radian((float)(paramec.a.a.a.a.a.b * 90.0D));
    localArcLineOverlayProvider.zoomRange(paramec.a.a.b.k, paramec.a.a.b.j);
    localArcLineOverlayProvider.zIndex(paramec.a.a.b.g);
    localArcLineOverlayProvider.displayLevel(paramec.a.a.b.f);
    localArcLineOverlayProvider.enable3D(paramec.a.a.b.a);
    localArcLineOverlayProvider.opacity((float)paramec.a.a.b.i);
    boolean bool;
    if (!paramec.a.a.b.h)
    {
      bool = true;
      localArcLineOverlayProvider.visibility(bool);
      if (!paramec.a.a.b.b) {
        break label580;
      }
      localArcLineOverlayProvider.setAnimateDuration((int)(paramec.a.a.b.c.c * 1000.0D));
      localArcLineOverlayProvider.setHighlightDuration((int)(paramec.a.a.b.c.a * 1000.0D));
      localArcLineOverlayProvider.animateColor(paramec.a.a.b.c.b);
    }
    for (;;)
    {
      AppMethodBeat.o(226141);
      return localArcLineOverlayProvider;
      bool = false;
      break;
      label580:
      localArcLineOverlayProvider.setAnimateDuration(0);
    }
  }
  
  public final ec a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226127);
    paramArrayOfByte = (ec)JsonUtils.parseToModel(new String(paramArrayOfByte), dy.class, new Object[0]);
    AppMethodBeat.o(226127);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qy
 * JD-Core Version:    0.7.0.1
 */