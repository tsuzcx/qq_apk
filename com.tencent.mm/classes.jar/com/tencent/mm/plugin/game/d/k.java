package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public String thP;
  public String thQ;
  public int thR;
  public b thS;
  public dc thT;
  public int thU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thQ != null) {
        paramVarArgs.d(1, this.thQ);
      }
      paramVarArgs.aR(2, this.thR);
      if (this.thS != null)
      {
        paramVarArgs.ln(3, this.thS.computeSize());
        this.thS.writeFields(paramVarArgs);
      }
      if (this.thT != null)
      {
        paramVarArgs.ln(4, this.thT.computeSize());
        this.thT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.thU);
      if (this.thP != null) {
        paramVarArgs.d(6, this.thP);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thQ == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.thQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.thR);
      paramInt = i;
      if (this.thS != null) {
        paramInt = i + f.a.a.a.lm(3, this.thS.computeSize());
      }
      i = paramInt;
      if (this.thT != null) {
        i = paramInt + f.a.a.a.lm(4, this.thT.computeSize());
      }
      i += f.a.a.b.b.a.bx(5, this.thU);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thP);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localk.thQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localk.thR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.thS = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.thT = ((dc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localk.thU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(41714);
          return 0;
        }
        localk.thP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.k
 * JD-Core Version:    0.7.0.1
 */