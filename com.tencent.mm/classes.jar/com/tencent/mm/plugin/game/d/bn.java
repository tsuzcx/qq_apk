package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import f.a.a.b;
import java.util.LinkedList;

public final class bn
  extends ckq
{
  public String ijV;
  public String sbA;
  public int scF;
  public int scG;
  public int scx;
  public int scy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41781);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41781);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.scx);
      paramVarArgs.aR(3, this.scy);
      if (this.sbA != null) {
        paramVarArgs.d(4, this.sbA);
      }
      paramVarArgs.aR(5, this.scF);
      paramVarArgs.aR(6, this.scG);
      if (this.ijV != null) {
        paramVarArgs.d(7, this.ijV);
      }
      AppMethodBeat.o(41781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.scx) + f.a.a.b.b.a.bA(3, this.scy);
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbA);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.scF) + f.a.a.b.b.a.bA(6, this.scG);
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ijV);
      }
      AppMethodBeat.o(41781);
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
          AppMethodBeat.o(41781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bn localbn = (bn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41781);
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
            localbn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41781);
          return 0;
        case 2: 
          localbn.scx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41781);
          return 0;
        case 3: 
          localbn.scy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41781);
          return 0;
        case 4: 
          localbn.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41781);
          return 0;
        case 5: 
          localbn.scF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41781);
          return 0;
        case 6: 
          localbn.scG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41781);
          return 0;
        }
        localbn.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41781);
        return 0;
      }
      AppMethodBeat.o(41781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bn
 * JD-Core Version:    0.7.0.1
 */