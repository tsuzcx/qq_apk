package com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "", "name", "", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/String;[Ljava/lang/Class;)V", "getName", "()Ljava/lang/String;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech$MethodSignature;", "equals", "", "other", "hashCode", "", "toString", "luggage-commons-jsapi-nfc-ext_release"})
public final class b$b
{
  private final Class<? extends Object>[] ldW;
  private final String name;
  
  public b$b(String paramString, Class<? extends Object>[] paramArrayOfClass)
  {
    AppMethodBeat.i(208230);
    this.name = paramString;
    this.ldW = paramArrayOfClass;
    AppMethodBeat.o(208230);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208228);
    if ((b)this == paramObject)
    {
      AppMethodBeat.o(208228);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.i(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(208228);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.model.NFCTech.MethodSignature");
      AppMethodBeat.o(208228);
      throw paramObject;
    }
    if ((p.i(this.name, ((b)paramObject).name) ^ true))
    {
      AppMethodBeat.o(208228);
      return false;
    }
    if (!Arrays.equals(this.ldW, ((b)paramObject).ldW))
    {
      AppMethodBeat.o(208228);
      return false;
    }
    AppMethodBeat.o(208228);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(208229);
    int i = this.name.hashCode();
    int j = Arrays.hashCode(this.ldW);
    AppMethodBeat.o(208229);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208231);
    String str = "MethodSignature(name=" + this.name + ", parameterTypes=" + Arrays.toString(this.ldW) + ")";
    AppMethodBeat.o(208231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */