package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.bx.a
{
  public ej IKO;
  public di IKP;
  public af IKQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41797);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IKO != null)
      {
        paramVarArgs.qD(1, this.IKO.computeSize());
        this.IKO.writeFields(paramVarArgs);
      }
      if (this.IKP != null)
      {
        paramVarArgs.qD(2, this.IKP.computeSize());
        this.IKP.writeFields(paramVarArgs);
      }
      if (this.IKQ != null)
      {
        paramVarArgs.qD(3, this.IKQ.computeSize());
        this.IKQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IKO == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.IKO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKP != null) {
        paramInt = i + i.a.a.a.qC(2, this.IKP.computeSize());
      }
      i = paramInt;
      if (this.IKQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.IKQ.computeSize());
      }
      AppMethodBeat.o(41797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41797);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ej();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ej)localObject2).parseFrom((byte[])localObject1);
            }
            localco.IKO = ((ej)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new di();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((di)localObject2).parseFrom((byte[])localObject1);
            }
            localco.IKP = ((di)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new af();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((af)localObject2).parseFrom((byte[])localObject1);
          }
          localco.IKQ = ((af)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      AppMethodBeat.o(41797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.co
 * JD-Core Version:    0.7.0.1
 */