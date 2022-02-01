package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$42
  implements TencentMap.OnIndoorStateChangeListener
{
  a$42(a parama) {}
  
  public final boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(146483);
    Log.v("MicroMsg.Map.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
    if (a.n(this.scU) != null)
    {
      b.f localf = a.csZ();
      a.a(this.scU, localf);
      a.n(this.scU).a(localf);
    }
    AppMethodBeat.o(146483);
    return true;
  }
  
  public final boolean onIndoorBuildingFocused()
  {
    AppMethodBeat.i(146481);
    Log.v("MicroMsg.Map.DefaultTencentMapView", "[onIndoorBuildingFocused]");
    AppMethodBeat.o(146481);
    return true;
  }
  
  public final boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(146482);
    Log.v("MicroMsg.Map.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", new Object[] { paramIndoorBuilding });
    if (a.n(this.scU) != null)
    {
      b.f localf = new b.f();
      localf.buildingId = paramIndoorBuilding.getBuidlingId();
      localf.buildingName = paramIndoorBuilding.getBuildingName();
      localf.sdQ = new LinkedList();
      Iterator localIterator = paramIndoorBuilding.getLevels().iterator();
      while (localIterator.hasNext())
      {
        IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
        b.g localg = new b.g();
        localg.floorName = localIndoorLevel.getName();
        localf.sdQ.add(localg);
      }
      localf.sdR = paramIndoorBuilding.getActiveLevelIndex();
      a.a(this.scU, localf);
      a.n(this.scU).a(localf);
    }
    AppMethodBeat.o(146482);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.42
 * JD-Core Version:    0.7.0.1
 */