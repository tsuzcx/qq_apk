package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener$CreateUserAction;", "", "reportAction", "", "(Ljava/lang/String;II)V", "getReportAction", "()I", "NO_ACTION", "CREATE_FAIL", "CREATE_SUCCESS", "plugin-appbrand-integration_release"})
public enum b$c$a
{
  public final int oEk;
  
  static
  {
    AppMethodBeat.i(273077);
    a locala1 = new a("NO_ACTION", 0, 1);
    oEg = locala1;
    a locala2 = new a("CREATE_FAIL", 1, 2);
    oEh = locala2;
    a locala3 = new a("CREATE_SUCCESS", 2, 3);
    oEi = locala3;
    oEj = new a[] { locala1, locala2, locala3 };
    AppMethodBeat.o(273077);
  }
  
  private b$c$a(int paramInt)
  {
    this.oEk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c.a
 * JD-Core Version:    0.7.0.1
 */