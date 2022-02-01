package com.eclipsesource.mmv8.debug.mirror;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ObjectMirror$PropertyKind
{
  int index;
  
  static
  {
    AppMethodBeat.i(61512);
    Named = new PropertyKind("Named", 0, 1);
    Indexed = new PropertyKind("Indexed", 1, 2);
    $VALUES = new PropertyKind[] { Named, Indexed };
    AppMethodBeat.o(61512);
  }
  
  private ObjectMirror$PropertyKind(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.ObjectMirror.PropertyKind
 * JD-Core Version:    0.7.0.1
 */