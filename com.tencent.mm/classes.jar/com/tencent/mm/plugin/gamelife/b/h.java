package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class h
  extends dyl
{
  public com.tencent.mm.cd.b DgQ;
  public String from_username;
  public String sWA;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203922);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sWA == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: to_username");
        AppMethodBeat.o(203922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.from_username != null) {
        paramVarArgs.f(2, this.from_username);
      }
      if (this.sWA != null) {
        paramVarArgs.f(3, this.sWA);
      }
      paramVarArgs.aY(4, this.scene);
      if (this.DgQ != null) {
        paramVarArgs.c(5, this.DgQ);
      }
      AppMethodBeat.o(203922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label560;
      }
    }
    label560:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.from_username);
      }
      i = paramInt;
      if (this.sWA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.sWA);
      }
      i += g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.DgQ != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.DgQ);
      }
      AppMethodBeat.o(203922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.sWA == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: to_username");
          AppMethodBeat.o(203922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(203922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203922);
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
            localh.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(203922);
          return 0;
        case 2: 
          localh.from_username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203922);
          return 0;
        case 3: 
          localh.sWA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(203922);
          return 0;
        case 4: 
          localh.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(203922);
          return 0;
        }
        localh.DgQ = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(203922);
        return 0;
      }
      AppMethodBeat.o(203922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.h
 * JD-Core Version:    0.7.0.1
 */