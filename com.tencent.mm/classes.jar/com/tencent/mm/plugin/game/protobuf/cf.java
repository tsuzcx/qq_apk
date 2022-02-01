package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cf
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public cy IHm;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276908);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      if (this.IHm != null)
      {
        paramVarArgs.qD(3, this.IHm.computeSize());
        this.IHm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(276908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGI);
      }
      i = paramInt;
      if (this.IHm != null) {
        i = paramInt + i.a.a.a.qC(3, this.IHm.computeSize());
      }
      AppMethodBeat.o(276908);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cf localcf = (cf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276908);
        return -1;
      case 1: 
        localcf.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(276908);
        return 0;
      case 2: 
        localcf.IGI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(276908);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cy localcy = new cy();
        if ((localObject != null) && (localObject.length > 0)) {
          localcy.parseFrom((byte[])localObject);
        }
        localcf.IHm = localcy;
        paramInt += 1;
      }
      AppMethodBeat.o(276908);
      return 0;
    }
    AppMethodBeat.o(276908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cf
 * JD-Core Version:    0.7.0.1
 */