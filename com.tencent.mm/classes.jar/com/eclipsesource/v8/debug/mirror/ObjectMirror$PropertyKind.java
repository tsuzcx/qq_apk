package com.eclipsesource.v8.debug.mirror;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ObjectMirror$PropertyKind
{
  int index;
  
  static
  {
    AppMethodBeat.i(74889);
    Named = new PropertyKind("Named", 0, 1);
    Indexed = new PropertyKind("Indexed", 1, 2);
    $VALUES = new PropertyKind[] { Named, Indexed };
    AppMethodBeat.o(74889);
  }
  
  private ObjectMirror$PropertyKind(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.ObjectMirror.PropertyKind
 * JD-Core Version:    0.7.0.1
 */