package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class j
  extends cvc
{
  public int tRT;
  public LinkedList<i> tSw;
  public String tSx;
  public String tSy;
  
  public j()
  {
    AppMethodBeat.i(40876);
    this.tSw = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.tRT);
      paramVarArgs.e(3, 8, this.tSw);
      if (this.tSx != null) {
        paramVarArgs.d(4, this.tSx);
      }
      if (this.tSy != null) {
        paramVarArgs.d(5, this.tSy);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.tRT) + f.a.a.a.c(3, 8, this.tSw);
      paramInt = i;
      if (this.tSx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tSx);
      }
      i = paramInt;
      if (this.tSy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tSy);
      }
      AppMethodBeat.o(40877);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tSw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 2: 
          localj.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40877);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.tSw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 4: 
          localj.tSx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40877);
          return 0;
        }
        localj.tSy = ((f.a.a.a.a)localObject1).NPN.readString();
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