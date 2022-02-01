package com.tencent.mm.plugin.car_license_plate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "ReqScene_HalfPage", "ReqScene_MyPlateInfo", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum e$a
{
  final int qDL;
  
  static
  {
    AppMethodBeat.i(277593);
    wbZ = new a("ReqScene_HalfPage", 0, 1);
    wca = new a("ReqScene_MyPlateInfo", 1, 2);
    wcb = new a[] { wbZ, wca };
    AppMethodBeat.o(277593);
  }
  
  private e$a(int paramInt)
  {
    this.qDL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.a.e.a
 * JD-Core Version:    0.7.0.1
 */