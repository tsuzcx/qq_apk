package com.tencent.mm.plugin.findersdk.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem;", "T", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/IConfigItem;", "defaultValue", "name", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "getItemName", "notifyValueChanged", "toString", "updateValueFromSvr", "Companion", "finder-sdk_release"})
public class a<T>
  implements d
{
  public static final a BwC;
  private kotlin.g.a.a<x> BwB;
  private final T bUV;
  public final String name;
  private T value;
  
  static
  {
    AppMethodBeat.i(208132);
    BwC = new a((byte)0);
    AppMethodBeat.o(208132);
  }
  
  public a(T paramT, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(208130);
    this.bUV = paramT;
    this.name = paramString;
    this.BwB = parama;
    AppMethodBeat.o(208130);
  }
  
  protected final T Hs()
  {
    return this.bUV;
  }
  
  public T aSr()
  {
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.bUV;
    }
    return localObject1;
  }
  
  public void enB() {}
  
  public final void enC()
  {
    AppMethodBeat.i(208126);
    kotlin.g.a.a locala = this.BwB;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(208126);
      return;
    }
    AppMethodBeat.o(208126);
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
    AppMethodBeat.i(208125);
    String str = "name " + this.name + " value " + this.value + " dummyValue " + this.bUV;
    AppMethodBeat.o(208125);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/item/ConfigItem$Companion;", "", "()V", "TAG", "", "finder-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */