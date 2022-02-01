package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import java.util.LinkedList;

public final class j
  extends cpx
{
  public LinkedList<i> sVR;
  public String sVS;
  public String sVT;
  public int sVo;
  
  public j()
  {
    AppMethodBeat.i(40876);
    this.sVR = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.sVo);
      paramVarArgs.e(3, 8, this.sVR);
      if (this.sVS != null) {
        paramVarArgs.d(4, this.sVS);
      }
      if (this.sVT != null) {
        paramVarArgs.d(5, this.sVT);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.sVo) + f.a.a.a.c(3, 8, this.sVR);
      paramInt = i;
      if (this.sVS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sVS);
      }
      i = paramInt;
      if (this.sVT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sVT);
      }
      AppMethodBeat.o(40877);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sVR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 2: 
          localj.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(40877);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.sVR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 4: 
          localj.sVS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40877);
          return 0;
        }
        localj.sVT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(40877);
        return 0;
      }
      AppMethodBeat.o(40877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.j
 * JD-Core Version:    0.7.0.1
 */