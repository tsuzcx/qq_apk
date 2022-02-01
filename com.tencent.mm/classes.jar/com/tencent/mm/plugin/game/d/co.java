package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.bx.a
{
  public String saA;
  public cp sdm;
  public cp sdn;
  public cp sdo;
  public cp sdp;
  public cp sdq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdm != null)
      {
        paramVarArgs.kX(1, this.sdm.computeSize());
        this.sdm.writeFields(paramVarArgs);
      }
      if (this.sdn != null)
      {
        paramVarArgs.kX(2, this.sdn.computeSize());
        this.sdn.writeFields(paramVarArgs);
      }
      if (this.sdo != null)
      {
        paramVarArgs.kX(3, this.sdo.computeSize());
        this.sdo.writeFields(paramVarArgs);
      }
      if (this.sdp != null)
      {
        paramVarArgs.kX(4, this.sdp.computeSize());
        this.sdp.writeFields(paramVarArgs);
      }
      if (this.sdq != null)
      {
        paramVarArgs.kX(6, this.sdq.computeSize());
        this.sdq.writeFields(paramVarArgs);
      }
      if (this.saA != null) {
        paramVarArgs.d(5, this.saA);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdm == null) {
        break label990;
      }
    }
    label990:
    for (int i = f.a.a.a.kW(1, this.sdm.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sdn != null) {
        paramInt = i + f.a.a.a.kW(2, this.sdn.computeSize());
      }
      i = paramInt;
      if (this.sdo != null) {
        i = paramInt + f.a.a.a.kW(3, this.sdo.computeSize());
      }
      paramInt = i;
      if (this.sdp != null) {
        paramInt = i + f.a.a.a.kW(4, this.sdp.computeSize());
      }
      i = paramInt;
      if (this.sdq != null) {
        i = paramInt + f.a.a.a.kW(6, this.sdq.computeSize());
      }
      paramInt = i;
      if (this.saA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.saA);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41817);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.sdm = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.sdn = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.sdo = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.sdp = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.sdq = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localco.saA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.co
 * JD-Core Version:    0.7.0.1
 */