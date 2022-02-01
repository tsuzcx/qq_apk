package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/IConfigItem;", "defaultValue", "name", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "getItemName", "notifyValueChanged", "toString", "updateValueFromSvr", "Companion", "plugin-finder_release"})
public class a<T>
  implements d
{
  public static final a vFK;
  final T aEX;
  public final String name;
  private kotlin.g.a.a<x> vFJ;
  T value;
  
  static
  {
    AppMethodBeat.i(251931);
    vFK = new a((byte)0);
    AppMethodBeat.o(251931);
  }
  
  public a(T paramT, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(251930);
    this.aEX = paramT;
    this.name = paramString;
    this.vFJ = parama;
    AppMethodBeat.o(251930);
  }
  
  public void dys() {}
  
  public final void dyt()
  {
    AppMethodBeat.i(251929);
    kotlin.g.a.a locala = this.vFJ;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(251929);
      return;
    }
    AppMethodBeat.o(251929);
  }
  
  public String toString()
  {
    AppMethodBeat.i(251928);
    String str = "name " + this.name + " value " + this.value + " dummyValue " + this.aEX;
    AppMethodBeat.o(251928);
    return str;
  }
  
  public T value()
  {
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.aEX;
    }
    return localObject1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.a
 * JD-Core Version:    0.7.0.1
 */