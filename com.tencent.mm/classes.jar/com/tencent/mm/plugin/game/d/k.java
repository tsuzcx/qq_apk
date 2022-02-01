package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public String rZW;
  public String rZX;
  public int rZY;
  public b rZZ;
  public dc saa;
  public int sab;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZX != null) {
        paramVarArgs.d(1, this.rZX);
      }
      paramVarArgs.aR(2, this.rZY);
      if (this.rZZ != null)
      {
        paramVarArgs.kX(3, this.rZZ.computeSize());
        this.rZZ.writeFields(paramVarArgs);
      }
      if (this.saa != null)
      {
        paramVarArgs.kX(4, this.saa.computeSize());
        this.saa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.sab);
      if (this.rZW != null) {
        paramVarArgs.d(6, this.rZW);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZX == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.rZX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rZY);
      paramInt = i;
      if (this.rZZ != null) {
        paramInt = i + f.a.a.a.kW(3, this.rZZ.computeSize());
      }
      i = paramInt;
      if (this.saa != null) {
        i = paramInt + f.a.a.a.kW(4, this.saa.computeSize());
      }
      i += f.a.a.b.b.a.bA(5, this.sab);
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rZW);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41714);
          return -1;
        case 1: 
          localk.rZX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localk.rZY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.rZZ = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.saa = ((dc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localk.sab = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41714);
          return 0;
        }
        localk.rZW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.k
 * JD-Core Version:    0.7.0.1
 */