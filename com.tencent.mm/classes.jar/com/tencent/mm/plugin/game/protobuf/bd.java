package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bd
  extends com.tencent.mm.cd.a
{
  public g CME;
  public String CML;
  public String CNA;
  public LinkedList<be> CPm;
  
  public bd()
  {
    AppMethodBeat.i(41748);
    this.CPm = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CME == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
        throw paramVarArgs;
      }
      if (this.CME != null)
      {
        paramVarArgs.oE(1, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      if (this.CML != null) {
        paramVarArgs.f(2, this.CML);
      }
      paramVarArgs.e(3, 8, this.CPm);
      if (this.CNA != null) {
        paramVarArgs.f(4, this.CNA);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CME == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = g.a.a.a.oD(1, this.CME.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CML != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CML);
      }
      i += g.a.a.a.c(3, 8, this.CPm);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNA);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CPm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CME == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41749);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41749);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.CME = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localbd.CML = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new be();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((be)localObject2).parseFrom((byte[])localObject1);
            }
            localbd.CPm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localbd.CNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */