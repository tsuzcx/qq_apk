package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import java.util.LinkedList;

public final class j
  extends ckq
{
  public int rNz;
  public LinkedList<i> rOa;
  public String rOb;
  public String rOc;
  
  public j()
  {
    AppMethodBeat.i(40876);
    this.rOa = new LinkedList();
    AppMethodBeat.o(40876);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.rNz);
      paramVarArgs.e(3, 8, this.rOa);
      if (this.rOb != null) {
        paramVarArgs.d(4, this.rOb);
      }
      if (this.rOc != null) {
        paramVarArgs.d(5, this.rOc);
      }
      AppMethodBeat.o(40877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rNz) + f.a.a.a.c(3, 8, this.rOa);
      paramInt = i;
      if (this.rOb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rOb);
      }
      i = paramInt;
      if (this.rOc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rOc);
      }
      AppMethodBeat.o(40877);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rOa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(40877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40877);
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
            localj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 2: 
          localj.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(40877);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.rOa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 4: 
          localj.rOb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40877);
          return 0;
        }
        localj.rOc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(40877);
        return 0;
      }
      AppMethodBeat.o(40877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.j
 * JD-Core Version:    0.7.0.1
 */