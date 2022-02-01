package com.tencent.mm.plugin.car_license_plate.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback$Request;", "", "(Ljava/lang/String;I)V", "FETCH_DATA_NO_CACHE", "FETCH_DATA_WITH_CACHE", "SYNC_DATA_MODIFICATION", "plugin-car-license-plate_release"})
public enum CarLicensePlateListViewContract$b$a
{
  static
  {
    AppMethodBeat.i(186932);
    a locala1 = new a("FETCH_DATA_NO_CACHE", 0);
    sYT = locala1;
    a locala2 = new a("FETCH_DATA_WITH_CACHE", 1);
    sYU = locala2;
    a locala3 = new a("SYNC_DATA_MODIFICATION", 2);
    sYV = locala3;
    sYW = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(186932);
  }
  
  private CarLicensePlateListViewContract$b$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b.a
 * JD-Core Version:    0.7.0.1
 */