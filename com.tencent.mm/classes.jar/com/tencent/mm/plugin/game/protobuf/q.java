package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class q
  extends com.tencent.mm.bw.a
{
  public String Name;
  public String xIB;
  public String xIJ;
  public int xJC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.xIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.xJC);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.xIJ != null) {
        paramVarArgs.e(3, this.xIJ);
      }
      if (this.xIB != null) {
        paramVarArgs.e(4, this.xIB);
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xJC) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.xIJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIJ);
      }
      paramInt = i;
      if (this.xIB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIB);
      }
      AppMethodBeat.o(41717);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.xIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41717);
        return -1;
      case 1: 
        localq.xJC = locala.UbS.zi();
        AppMethodBeat.o(41717);
        return 0;
      case 2: 
        localq.Name = locala.UbS.readString();
        AppMethodBeat.o(41717);
        return 0;
      case 3: 
        localq.xIJ = locala.UbS.readString();
        AppMethodBeat.o(41717);
        return 0;
      }
      localq.xIB = locala.UbS.readString();
      AppMethodBeat.o(41717);
      return 0;
    }
    AppMethodBeat.o(41717);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.q
 * JD-Core Version:    0.7.0.1
 */