package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class n
  extends com.tencent.mm.bw.a
{
  public String Name;
  public int thY;
  public String thk;
  public String thp;
  
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
      if (this.thp == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.thY);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.thp != null) {
        paramVarArgs.d(3, this.thp);
      }
      if (this.thk != null) {
        paramVarArgs.d(4, this.thk);
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.thY) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.thp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thp);
      }
      paramInt = i;
      if (this.thk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thk);
      }
      AppMethodBeat.o(41717);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.thp == null)
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
        localn.thY = locala.LVo.xF();
        AppMethodBeat.o(41717);
        return 0;
      case 2: 
        localn.Name = locala.LVo.readString();
        AppMethodBeat.o(41717);
        return 0;
      case 3: 
        localn.thp = locala.LVo.readString();
        AppMethodBeat.o(41717);
        return 0;
      }
      localn.thk = locala.LVo.readString();
      AppMethodBeat.o(41717);
      return 0;
    }
    AppMethodBeat.o(41717);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.n
 * JD-Core Version:    0.7.0.1
 */