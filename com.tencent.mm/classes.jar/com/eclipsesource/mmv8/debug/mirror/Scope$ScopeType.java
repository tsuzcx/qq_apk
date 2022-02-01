package com.eclipsesource.mmv8.debug.mirror;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Scope$ScopeType
{
  int index;
  
  static
  {
    AppMethodBeat.i(61524);
    Global = new ScopeType("Global", 0, 0);
    Local = new ScopeType("Local", 1, 1);
    With = new ScopeType("With", 2, 2);
    Closure = new ScopeType("Closure", 3, 3);
    Catch = new ScopeType("Catch", 4, 4);
    Block = new ScopeType("Block", 5, 5);
    Script = new ScopeType("Script", 6, 6);
    $VALUES = new ScopeType[] { Global, Local, With, Closure, Catch, Block, Script };
    AppMethodBeat.o(61524);
  }
  
  private Scope$ScopeType(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.mmv8.debug.mirror.Scope.ScopeType
 * JD-Core Version:    0.7.0.1
 */