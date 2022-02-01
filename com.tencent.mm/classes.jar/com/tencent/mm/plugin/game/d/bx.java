package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bx
  extends com.tencent.mm.bx.a
{
  public String fVC;
  public cg rZI;
  public String rZo;
  public String scQ;
  public String scR;
  public String scS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVC != null) {
        paramVarArgs.d(1, this.fVC);
      }
      if (this.scQ != null) {
        paramVarArgs.d(2, this.scQ);
      }
      if (this.scR != null) {
        paramVarArgs.d(3, this.scR);
      }
      if (this.scS != null) {
        paramVarArgs.d(4, this.scS);
      }
      if (this.rZI != null)
      {
        paramVarArgs.kX(5, this.rZI.computeSize());
        this.rZI.writeFields(paramVarArgs);
      }
      if (this.rZo != null) {
        paramVarArgs.d(6, this.rZo);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVC == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.fVC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.scQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.scQ);
      }
      i = paramInt;
      if (this.scR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.scR);
      }
      paramInt = i;
      if (this.scS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.scS);
      }
      i = paramInt;
      if (this.rZI != null) {
        i = paramInt + f.a.a.a.kW(5, this.rZI.computeSize());
      }
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rZo);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41796);
          return -1;
        case 1: 
          localbx.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localbx.scQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localbx.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localbx.scS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbx.rZI = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localbx.rZo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bx
 * JD-Core Version:    0.7.0.1
 */