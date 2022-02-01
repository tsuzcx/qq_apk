package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"})
public final class b$b
{
  private final Class<? extends Object>[] mjp;
  private final String name;
  
  public b$b(String paramString, Class<? extends Object>[] paramArrayOfClass)
  {
    AppMethodBeat.i(207167);
    this.name = paramString;
    this.mjp = paramArrayOfClass;
    AppMethodBeat.o(207167);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207165);
    if ((b)this == paramObject)
    {
      AppMethodBeat.o(207165);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.j(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(207165);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
      AppMethodBeat.o(207165);
      throw paramObject;
    }
    if ((p.j(this.name, ((b)paramObject).name) ^ true))
    {
      AppMethodBeat.o(207165);
      return false;
    }
    if (!Arrays.equals(this.mjp, ((b)paramObject).mjp))
    {
      AppMethodBeat.o(207165);
      return false;
    }
    AppMethodBeat.o(207165);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(207166);
    int i = this.name.hashCode();
    int j = Arrays.hashCode(this.mjp);
    AppMethodBeat.o(207166);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207168);
    String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.mjp) + ")";
    AppMethodBeat.o(207168);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.b
 * JD-Core Version:    0.7.0.1
 */