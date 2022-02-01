package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public final class r
  extends dyl
{
  public boolean DgG;
  public long DgX;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203935);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.session_id == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_id");
        AppMethodBeat.o(203935);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.f(2, this.session_id);
      }
      paramVarArgs.bm(3, this.DgX);
      paramVarArgs.co(4, this.DgG);
      AppMethodBeat.o(203935);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.session_id);
      }
      paramInt = g.a.a.b.b.a.p(3, this.DgX);
      int j = g.a.a.b.b.a.gL(4);
      AppMethodBeat.o(203935);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.session_id == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_id");
          AppMethodBeat.o(203935);
          throw paramVarArgs;
        }
        AppMethodBeat.o(203935);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203935);
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
            localr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(203935);
          return 0;
        case 2: 
          localr.session_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203935);
          return 0;
        case 3: 
          localr.DgX = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(203935);
          return 0;
        }
        localr.DgG = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(203935);
        return 0;
      }
      AppMethodBeat.o(203935);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.r
 * JD-Core Version:    0.7.0.1
 */