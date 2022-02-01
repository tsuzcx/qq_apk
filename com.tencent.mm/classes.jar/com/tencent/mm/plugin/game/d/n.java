package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class n
  extends com.tencent.mm.bx.a
{
  public String Name;
  public int ufP;
  public String ufb;
  public String ufg;
  
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
      if (this.ufg == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ufP);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.ufg != null) {
        paramVarArgs.d(3, this.ufg);
      }
      if (this.ufb != null) {
        paramVarArgs.d(4, this.ufb);
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ufP) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.ufg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufg);
      }
      paramInt = i;
      if (this.ufb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufb);
      }
      AppMethodBeat.o(41717);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.ufg == null)
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
        localn.ufP = locala.NPN.zc();
        AppMethodBeat.o(41717);
        return 0;
      case 2: 
        localn.Name = locala.NPN.readString();
        AppMethodBeat.o(41717);
        return 0;
      case 3: 
        localn.ufg = locala.NPN.readString();
        AppMethodBeat.o(41717);
        return 0;
      }
      localn.ufb = locala.NPN.readString();
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