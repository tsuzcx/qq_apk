package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.luggage.sdk.config.c;
import com.tencent.luggage.sdk.config.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "generateInstanceId", "", "uin", "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d riq;
  
  static
  {
    AppMethodBeat.i(51400);
    riq = new d();
    AppMethodBeat.o(51400);
  }
  
  public static final String Do(int paramInt)
  {
    AppMethodBeat.i(51399);
    Object localObject = c.a.cxT;
    if (localObject != null)
    {
      localObject = ((c)localObject).QD();
      kotlin.g.b.p.j(localObject, "factory.createInstanceId()");
      AppMethodBeat.o(51399);
      return localObject;
    }
    localObject = com.tencent.mm.b.p.getString(paramInt);
    kotlin.g.b.p.j(localObject, "UIN.getString(uin)");
    localObject = j.a((Iterable)j.listOf(new String[] { localObject, String.valueOf(Util.nowMilliSecond()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(51399);
    return localObject;
  }
  
  public static final boolean anh(String paramString)
  {
    AppMethodBeat.i(279941);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(279941);
      return true;
    }
    AppMethodBeat.o(279941);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.d
 * JD-Core Version:    0.7.0.1
 */