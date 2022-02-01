package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class ax
  extends ckq
{
  public String ijV;
  public String sbA;
  public int sbB;
  public e sbC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(149415);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sbA != null) {
        paramVarArgs.d(2, this.sbA);
      }
      if (this.ijV != null) {
        paramVarArgs.d(3, this.ijV);
      }
      paramVarArgs.aR(4, this.sbB);
      if (this.sbC != null)
      {
        paramVarArgs.kX(5, this.sbC.computeSize());
        this.sbC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sbA);
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ijV);
      }
      i += f.a.a.b.b.a.bA(4, this.sbB);
      paramInt = i;
      if (this.sbC != null) {
        paramInt = i + f.a.a.a.kW(5, this.sbC.computeSize());
      }
      AppMethodBeat.o(149415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sbA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(149415);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(149415);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localax.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        case 2: 
          localax.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 3: 
          localax.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 4: 
          localax.sbB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(149415);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localax.sbC = ((e)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      AppMethodBeat.o(149415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ax
 * JD-Core Version:    0.7.0.1
 */