package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bx.a
{
  public String IGQ;
  public int IIq;
  public int IIr;
  public int IIs;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IIq);
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.IIr);
      if (this.IGQ != null) {
        paramVarArgs.g(4, this.IGQ);
      }
      paramVarArgs.bS(5, this.IIs);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IIq) + 0;
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.IIr);
      paramInt = i;
      if (this.IGQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGQ);
      }
      i = i.a.a.b.b.a.cJ(5, this.IIs);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ae localae = (ae)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41722);
        return -1;
      case 1: 
        localae.IIq = locala.ajGk.aar();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localae.oOI = locala.ajGk.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localae.IIr = locala.ajGk.aar();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localae.IGQ = locala.ajGk.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localae.IIs = locala.ajGk.aar();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ae
 * JD-Core Version:    0.7.0.1
 */