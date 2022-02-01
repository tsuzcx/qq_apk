package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;

public final class sg
  implements TencentMap.OnIndoorStateChangeListener
{
  private sj a;
  
  public sg(sj paramsj)
  {
    this.a = paramsj;
  }
  
  private boolean a()
  {
    return this.a == null;
  }
  
  public final boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(224295);
    if (this.a == null)
    {
      AppMethodBeat.o(224295);
      return false;
    }
    this.a.onIndoorBuildingDeactivated();
    if (this.a.x != null) {
      this.a.x.onIndoorBuildingDeactivated();
    }
    AppMethodBeat.o(224295);
    return true;
  }
  
  public final boolean onIndoorBuildingFocused()
  {
    AppMethodBeat.i(224273);
    if (this.a == null)
    {
      AppMethodBeat.o(224273);
      return false;
    }
    this.a.onIndoorBuildingFocused();
    if (this.a.x != null) {
      this.a.x.onIndoorBuildingFocused();
    }
    AppMethodBeat.o(224273);
    return true;
  }
  
  public final boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(224285);
    if (this.a == null)
    {
      AppMethodBeat.o(224285);
      return false;
    }
    this.a.onIndoorLevelActivated(paramIndoorBuilding);
    if (this.a.x != null) {
      this.a.x.onIndoorLevelActivated(paramIndoorBuilding);
    }
    AppMethodBeat.o(224285);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sg
 * JD-Core Version:    0.7.0.1
 */