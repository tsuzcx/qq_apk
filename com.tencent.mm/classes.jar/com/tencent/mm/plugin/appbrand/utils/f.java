package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.luggage.sdk.config.d;
import com.tencent.luggage.sdk.config.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "generateInstanceId", "", "uin", "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f uqu;
  
  static
  {
    AppMethodBeat.i(51400);
    uqu = new f();
    AppMethodBeat.o(51400);
  }
  
  public static final String DI(int paramInt)
  {
    AppMethodBeat.i(51399);
    Object localObject = d.a.eqo;
    if (localObject != null)
    {
      localObject = ((d)localObject).aqP();
      s.s(localObject, "factory.createInstanceId()");
      AppMethodBeat.o(51399);
      return localObject;
    }
    localObject = com.tencent.mm.b.p.getString(paramInt);
    s.s(localObject, "getString(uin)");
    localObject = kotlin.a.p.a((Iterable)kotlin.a.p.listOf(new String[] { localObject, String.valueOf(Util.nowMilliSecond()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(51399);
    return localObject;
  }
  
  public static final boolean agB(String paramString)
  {
    AppMethodBeat.i(317311);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(317311);
      return true;
    }
    AppMethodBeat.o(317311);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.f
 * JD-Core Version:    0.7.0.1
 */