package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class al
  extends dyl
{
  public String COq;
  public com.tencent.mm.cd.b COr;
  public com.tencent.mm.cd.b COs;
  public String jUi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41729);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUi == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.COq == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jUi != null) {
        paramVarArgs.f(2, this.jUi);
      }
      if (this.COq != null) {
        paramVarArgs.f(3, this.COq);
      }
      if (this.COr != null) {
        paramVarArgs.c(4, this.COr);
      }
      if (this.COs != null) {
        paramVarArgs.c(5, this.COs);
      }
      AppMethodBeat.o(41729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jUi != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jUi);
      }
      i = paramInt;
      if (this.COq != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.COq);
      }
      paramInt = i;
      if (this.COr != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.COr);
      }
      i = paramInt;
      if (this.COs != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.COs);
      }
      AppMethodBeat.o(41729);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.jUi == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        if (this.COq == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41729);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41729);
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
            localal.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(41729);
          return 0;
        case 2: 
          localal.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 3: 
          localal.COq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 4: 
          localal.COr = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(41729);
          return 0;
        }
        localal.COs = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(41729);
        return 0;
      }
      AppMethodBeat.o(41729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.al
 * JD-Core Version:    0.7.0.1
 */