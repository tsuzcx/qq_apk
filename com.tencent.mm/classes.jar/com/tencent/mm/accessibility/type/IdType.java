package com.tencent.mm.accessibility.type;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/type/IdType;", "", "(Ljava/lang/String;I)V", "Layout", "Id", "String", "Unknow", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum IdType
{
  static
  {
    AppMethodBeat.i(234109);
    Layout = new IdType("Layout", 0);
    Id = new IdType("Id", 1);
    String = new IdType("String", 2);
    Unknow = new IdType("Unknow", 3);
    $VALUES = $values();
    AppMethodBeat.o(234109);
  }
  
  private IdType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.type.IdType
 * JD-Core Version:    0.7.0.1
 */