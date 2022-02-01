package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/IConfigItem;", "defaultValue", "name", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "value", "getItemName", "toString", "plugin-finder_release"})
public class a<T>
{
  final T aFh;
  public final String name;
  private T value;
  
  public a(T paramT, String paramString)
  {
    AppMethodBeat.i(204352);
    this.aFh = paramT;
    this.name = paramString;
    AppMethodBeat.o(204352);
  }
  
  public String toString()
  {
    AppMethodBeat.i(204351);
    String str = "name " + this.name + " value " + this.value + " dummyValue " + this.aFh;
    AppMethodBeat.o(204351);
    return str;
  }
  
  public T value()
  {
    Object localObject2 = this.value;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.aFh;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.config.item.a
 * JD-Core Version:    0.7.0.1
 */