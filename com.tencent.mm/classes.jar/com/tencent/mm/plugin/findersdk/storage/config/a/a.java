package com.tencent.mm.plugin.findersdk.storage.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/IConfigItem;", "defaultValue", "name", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "getItemName", "notifyValueChanged", "toString", "updateValueFromSvr", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a<T>
  implements d
{
  public static final a HdM;
  private kotlin.g.a.a<ah> HdN;
  private final T dOI;
  public final String name;
  private T value;
  
  static
  {
    AppMethodBeat.i(273834);
    HdM = new a((byte)0);
    AppMethodBeat.o(273834);
  }
  
  public a(T paramT, String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(273821);
    this.dOI = paramT;
    this.name = paramString;
    this.HdN = parama;
    AppMethodBeat.o(273821);
  }
  
  protected final T aho()
  {
    return this.dOI;
  }
  
  public T bmg()
  {
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.dOI;
    }
    return localObject1;
  }
  
  public void fsn() {}
  
  public final void fso()
  {
    AppMethodBeat.i(273874);
    kotlin.g.a.a locala = this.HdN;
    if (locala != null) {
      locala.invoke();
    }
    AppMethodBeat.o(273874);
  }
  
  public final T getValue()
  {
    return this.value;
  }
  
  public final void setValue(T paramT)
  {
    this.value = paramT;
  }
  
  public String toString()
  {
    AppMethodBeat.i(273856);
    String str = "name " + this.name + " value " + this.value + " dummyValue " + this.dOI;
    AppMethodBeat.o(273856);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem$Companion;", "", "()V", "TAG", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.a.a
 * JD-Core Version:    0.7.0.1
 */