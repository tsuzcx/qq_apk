package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mapsdk.raster.model.IndoorBuilding;
import com.tencent.mapsdk.raster.model.IndoorLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$30
  implements TencentMap.OnIndoorStateChangeListener
{
  a$30(a parama) {}
  
  public final boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(146483);
    ac.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingDeactivated]");
    if (a.k(this.kuZ) != null)
    {
      b.e locale = a.bhv();
      a.a(this.kuZ, locale);
      a.k(this.kuZ).a(locale);
    }
    AppMethodBeat.o(146483);
    return true;
  }
  
  public final boolean onIndoorBuildingFocused()
  {
    AppMethodBeat.i(146481);
    ac.v("MicroMsg.DefaultTencentMapView", "[onIndoorBuildingFocused]");
    AppMethodBeat.o(146481);
    return true;
  }
  
  public final boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(146482);
    ac.v("MicroMsg.DefaultTencentMapView", "[onIndoorLevelActivated]indoorBuilding:%s", new Object[] { paramIndoorBuilding });
    if (a.k(this.kuZ) != null)
    {
      b.e locale = new b.e();
      locale.buildingId = paramIndoorBuilding.getBuidlingId();
      locale.buildingName = paramIndoorBuilding.getBuildingName();
      locale.kvE = new LinkedList();
      Iterator localIterator = paramIndoorBuilding.getLevels().iterator();
      while (localIterator.hasNext())
      {
        IndoorLevel localIndoorLevel = (IndoorLevel)localIterator.next();
        b.f localf = new b.f();
        localf.floorName = localIndoorLevel.getName();
        locale.kvE.add(localf);
      }
      locale.kvF = paramIndoorBuilding.getActiveLevelIndex();
      a.a(this.kuZ, locale);
      a.k(this.kuZ).a(locale);
    }
    AppMethodBeat.o(146482);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.a.30
 * JD-Core Version:    0.7.0.1
 */