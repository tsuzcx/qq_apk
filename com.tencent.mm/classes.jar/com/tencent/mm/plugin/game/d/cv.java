package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cv
  extends com.tencent.mm.bx.a
{
  public String ugn;
  public cw ujp;
  public cw ujq;
  public cw ujr;
  public cw ujs;
  public cw ujt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ujp != null)
      {
        paramVarArgs.lC(1, this.ujp.computeSize());
        this.ujp.writeFields(paramVarArgs);
      }
      if (this.ujq != null)
      {
        paramVarArgs.lC(2, this.ujq.computeSize());
        this.ujq.writeFields(paramVarArgs);
      }
      if (this.ujr != null)
      {
        paramVarArgs.lC(3, this.ujr.computeSize());
        this.ujr.writeFields(paramVarArgs);
      }
      if (this.ujs != null)
      {
        paramVarArgs.lC(4, this.ujs.computeSize());
        this.ujs.writeFields(paramVarArgs);
      }
      if (this.ujt != null)
      {
        paramVarArgs.lC(6, this.ujt.computeSize());
        this.ujt.writeFields(paramVarArgs);
      }
      if (this.ugn != null) {
        paramVarArgs.d(5, this.ugn);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ujp == null) {
        break label990;
      }
    }
    label990:
    for (int i = f.a.a.a.lB(1, this.ujp.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ujq != null) {
        paramInt = i + f.a.a.a.lB(2, this.ujq.computeSize());
      }
      i = paramInt;
      if (this.ujr != null) {
        i = paramInt + f.a.a.a.lB(3, this.ujr.computeSize());
      }
      paramInt = i;
      if (this.ujs != null) {
        paramInt = i + f.a.a.a.lB(4, this.ujs.computeSize());
      }
      i = paramInt;
      if (this.ujt != null) {
        i = paramInt + f.a.a.a.lB(6, this.ujt.computeSize());
      }
      paramInt = i;
      if (this.ugn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ugn);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41817);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.ujp = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.ujq = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.ujr = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.ujs = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcv.ujt = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localcv.ugn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cv
 * JD-Core Version:    0.7.0.1
 */