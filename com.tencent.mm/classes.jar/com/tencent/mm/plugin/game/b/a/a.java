package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import java.util.LinkedList;

public final class a
  extends ckq
{
  public String hnC;
  public String rNA;
  public long rNB;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.rNz);
      if (this.rNA != null) {
        paramVarArgs.d(3, this.rNA);
      }
      if (this.hnC != null) {
        paramVarArgs.d(4, this.hnC);
      }
      paramVarArgs.aG(5, this.rNB);
      AppMethodBeat.o(40860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rNz);
      paramInt = i;
      if (this.rNA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.rNA);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hnC);
      }
      paramInt = f.a.a.b.b.a.q(5, this.rNB);
      AppMethodBeat.o(40860);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(40860);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40860);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40860);
          return 0;
        case 2: 
          locala.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(40860);
          return 0;
        case 3: 
          locala.rNA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40860);
          return 0;
        case 4: 
          locala.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40860);
          return 0;
        }
        locala.rNB = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(40860);
        return 0;
      }
      AppMethodBeat.o(40860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */