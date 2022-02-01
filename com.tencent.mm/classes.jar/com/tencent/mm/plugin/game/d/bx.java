package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bx
  extends com.tencent.mm.bw.a
{
  public String fZx;
  public cg thB;
  public String thh;
  public String tkK;
  public String tkL;
  public String tkM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx != null) {
        paramVarArgs.d(1, this.fZx);
      }
      if (this.tkK != null) {
        paramVarArgs.d(2, this.tkK);
      }
      if (this.tkL != null) {
        paramVarArgs.d(3, this.tkL);
      }
      if (this.tkM != null) {
        paramVarArgs.d(4, this.tkM);
      }
      if (this.thB != null)
      {
        paramVarArgs.ln(5, this.thB.computeSize());
        this.thB.writeFields(paramVarArgs);
      }
      if (this.thh != null) {
        paramVarArgs.d(6, this.thh);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZx == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.fZx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tkK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tkK);
      }
      i = paramInt;
      if (this.tkL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tkL);
      }
      paramInt = i;
      if (this.tkM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tkM);
      }
      i = paramInt;
      if (this.thB != null) {
        i = paramInt + f.a.a.a.lm(5, this.thB.computeSize());
      }
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thh);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localbx.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localbx.tkK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localbx.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localbx.tkM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbx.thB = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localbx.thh = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bx
 * JD-Core Version:    0.7.0.1
 */