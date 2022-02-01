package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
{
  private final String name;
  private final Class<? extends Object>[] smO;
  
  public b$b(String paramString, Class<? extends Object>[] paramArrayOfClass)
  {
    AppMethodBeat.i(328121);
    this.name = paramString;
    this.smO = paramArrayOfClass;
    AppMethodBeat.o(328121);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(328126);
    if (this == paramObject)
    {
      AppMethodBeat.o(328126);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(328126);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
      AppMethodBeat.o(328126);
      throw paramObject;
    }
    if (!s.p(this.name, ((b)paramObject).name))
    {
      AppMethodBeat.o(328126);
      return false;
    }
    if (!Arrays.equals(this.smO, ((b)paramObject).smO))
    {
      AppMethodBeat.o(328126);
      return false;
    }
    AppMethodBeat.o(328126);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(328129);
    int i = this.name.hashCode();
    int j = Arrays.hashCode(this.smO);
    AppMethodBeat.o(328129);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(328135);
    String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.smO) + ')';
    AppMethodBeat.o(328135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b.b
 * JD-Core Version:    0.7.0.1
 */