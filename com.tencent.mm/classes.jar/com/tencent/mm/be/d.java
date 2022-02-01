package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.cd.a
{
  public String appId;
  public String lXk;
  public String lXl;
  public p lXm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.lXk != null) {
        paramVarArgs.f(2, this.lXk);
      }
      if (this.lXl != null) {
        paramVarArgs.f(3, this.lXl);
      }
      if (this.lXm != null)
      {
        paramVarArgs.oE(4, this.lXm.computeSize());
        this.lXm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.b.b.a.g(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lXk != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lXk);
      }
      i = paramInt;
      if (this.lXl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lXl);
      }
      paramInt = i;
      if (this.lXm != null) {
        paramInt = i + g.a.a.a.oD(4, this.lXm.computeSize());
      }
      AppMethodBeat.o(195358);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195358);
          return -1;
        case 1: 
          locald.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195358);
          return 0;
        case 2: 
          locald.lXk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195358);
          return 0;
        case 3: 
          locald.lXl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195358);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          p localp = new p();
          if ((localObject != null) && (localObject.length > 0)) {
            localp.parseFrom((byte[])localObject);
          }
          locald.lXm = localp;
          paramInt += 1;
        }
        AppMethodBeat.o(195358);
        return 0;
      }
      AppMethodBeat.o(195358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.d
 * JD-Core Version:    0.7.0.1
 */