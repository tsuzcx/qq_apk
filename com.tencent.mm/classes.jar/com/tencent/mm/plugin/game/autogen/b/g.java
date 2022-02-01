package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class g
  extends dyl
{
  public String CqU;
  public int limit = 20;
  public long offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40872);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.offset);
      paramVarArgs.aY(3, this.limit);
      if (this.CqU != null) {
        paramVarArgs.f(4, this.CqU);
      }
      AppMethodBeat.o(40872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.offset) + g.a.a.b.b.a.bM(3, this.limit);
      paramInt = i;
      if (this.CqU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CqU);
      }
      AppMethodBeat.o(40872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(40872);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40872);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localg.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(40872);
          return 0;
        case 2: 
          localg.offset = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(40872);
          return 0;
        case 3: 
          localg.limit = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(40872);
          return 0;
        }
        localg.CqU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(40872);
        return 0;
      }
      AppMethodBeat.o(40872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.g
 * JD-Core Version:    0.7.0.1
 */