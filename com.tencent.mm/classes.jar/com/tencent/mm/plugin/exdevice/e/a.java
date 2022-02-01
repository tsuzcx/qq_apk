package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public int qdX;
  public String qdY;
  public String qdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.qdX);
      if (this.qdY != null) {
        paramVarArgs.d(2, this.qdY);
      }
      if (this.qdZ != null) {
        paramVarArgs.d(3, this.qdZ);
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.qdX) + 0;
      paramInt = i;
      if (this.qdY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qdY);
      }
      i = paramInt;
      if (this.qdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qdZ);
      }
      AppMethodBeat.o(23482);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(23482);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(23482);
        return -1;
      case 1: 
        locala1.qdX = locala.NPN.zc();
        AppMethodBeat.o(23482);
        return 0;
      case 2: 
        locala1.qdY = locala.NPN.readString();
        AppMethodBeat.o(23482);
        return 0;
      }
      locala1.qdZ = locala.NPN.readString();
      AppMethodBeat.o(23482);
      return 0;
    }
    AppMethodBeat.o(23482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.a
 * JD-Core Version:    0.7.0.1
 */