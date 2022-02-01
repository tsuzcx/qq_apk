package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class h
  extends dop
{
  public String pPy;
  public String pPz;
  public int scene;
  public com.tencent.mm.bw.b ybi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225893);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pPz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: to_username");
        AppMethodBeat.o(225893);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pPy != null) {
        paramVarArgs.e(2, this.pPy);
      }
      if (this.pPz != null) {
        paramVarArgs.e(3, this.pPz);
      }
      paramVarArgs.aM(4, this.scene);
      if (this.ybi != null) {
        paramVarArgs.c(5, this.ybi);
      }
      AppMethodBeat.o(225893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pPy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pPy);
      }
      i = paramInt;
      if (this.pPz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pPz);
      }
      i += g.a.a.b.b.a.bu(4, this.scene);
      paramInt = i;
      if (this.ybi != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.ybi);
      }
      AppMethodBeat.o(225893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.pPz == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: to_username");
          AppMethodBeat.o(225893);
          throw paramVarArgs;
        }
        AppMethodBeat.o(225893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225893);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225893);
          return 0;
        case 2: 
          localh.pPy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225893);
          return 0;
        case 3: 
          localh.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225893);
          return 0;
        case 4: 
          localh.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(225893);
          return 0;
        }
        localh.ybi = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(225893);
        return 0;
      }
      AppMethodBeat.o(225893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.h
 * JD-Core Version:    0.7.0.1
 */