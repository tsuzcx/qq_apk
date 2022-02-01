package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dh
  extends com.tencent.mm.bx.a
{
  public String ILl;
  public cx ILm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276880);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILl != null) {
        paramVarArgs.g(1, this.ILl);
      }
      if (this.ILm != null)
      {
        paramVarArgs.qD(2, this.ILm.computeSize());
        this.ILm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(276880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILl == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.ILl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ILm != null) {
        i = paramInt + i.a.a.a.qC(2, this.ILm.computeSize());
      }
      AppMethodBeat.o(276880);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(276880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276880);
          return -1;
        case 1: 
          localdh.ILl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(276880);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cx localcx = new cx();
          if ((localObject != null) && (localObject.length > 0)) {
            localcx.parseFrom((byte[])localObject);
          }
          localdh.ILm = localcx;
          paramInt += 1;
        }
        AppMethodBeat.o(276880);
        return 0;
      }
      AppMethodBeat.o(276880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dh
 * JD-Core Version:    0.7.0.1
 */