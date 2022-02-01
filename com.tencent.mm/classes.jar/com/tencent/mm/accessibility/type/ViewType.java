package com.tencent.mm.accessibility.type;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/type/ViewType;", "", "(Ljava/lang/String;I)V", "Button", "TextView", "CheckBox", "SeekBar", "EditText", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ViewType
{
  static
  {
    AppMethodBeat.i(234110);
    Button = new ViewType("Button", 0);
    TextView = new ViewType("TextView", 1);
    CheckBox = new ViewType("CheckBox", 2);
    SeekBar = new ViewType("SeekBar", 3);
    EditText = new ViewType("EditText", 4);
    $VALUES = $values();
    AppMethodBeat.o(234110);
  }
  
  private ViewType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.type.ViewType
 * JD-Core Version:    0.7.0.1
 */