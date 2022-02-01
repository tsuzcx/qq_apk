package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class r
  extends dop
{
  public String session_id;
  public boolean yaY;
  public long ybs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225905);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.session_id == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_id");
        AppMethodBeat.o(225905);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.e(2, this.session_id);
      }
      paramVarArgs.bb(3, this.ybs);
      paramVarArgs.cc(4, this.yaY);
      AppMethodBeat.o(225905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.session_id);
      }
      paramInt = g.a.a.b.b.a.r(3, this.ybs);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(225905);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.session_id == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_id");
          AppMethodBeat.o(225905);
          throw paramVarArgs;
        }
        AppMethodBeat.o(225905);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225905);
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
            localr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225905);
          return 0;
        case 2: 
          localr.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225905);
          return 0;
        case 3: 
          localr.ybs = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(225905);
          return 0;
        }
        localr.yaY = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(225905);
        return 0;
      }
      AppMethodBeat.o(225905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.r
 * JD-Core Version:    0.7.0.1
 */