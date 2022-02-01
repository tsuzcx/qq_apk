package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class n
  extends com.tencent.mm.bx.a
{
  public String Name;
  public String rZr;
  public String rZw;
  public int saf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41717);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.rZw == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.saf);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.rZw != null) {
        paramVarArgs.d(3, this.rZw);
      }
      if (this.rZr != null) {
        paramVarArgs.d(4, this.rZr);
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.saf) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.rZw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZw);
      }
      paramInt = i;
      if (this.rZr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZr);
      }
      AppMethodBeat.o(41717);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.rZw == null)
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
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41717);
        return -1;
      case 1: 
        localn.saf = locala.KhF.xS();
        AppMethodBeat.o(41717);
        return 0;
      case 2: 
        localn.Name = locala.KhF.readString();
        AppMethodBeat.o(41717);
        return 0;
      case 3: 
        localn.rZw = locala.KhF.readString();
        AppMethodBeat.o(41717);
        return 0;
      }
      localn.rZr = locala.KhF.readString();
      AppMethodBeat.o(41717);
      return 0;
    }
    AppMethodBeat.o(41717);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.n
 * JD-Core Version:    0.7.0.1
 */