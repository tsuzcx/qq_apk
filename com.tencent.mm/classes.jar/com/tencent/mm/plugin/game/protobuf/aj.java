package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class aj
  extends com.tencent.mm.cd.a
{
  public dz COn;
  public LinkedList<ee> COo;
  
  public aj()
  {
    AppMethodBeat.i(207159);
    this.COo = new LinkedList();
    AppMethodBeat.o(207159);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207161);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.COn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(207161);
        throw paramVarArgs;
      }
      if (this.COn != null)
      {
        paramVarArgs.oE(1, this.COn.computeSize());
        this.COn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.COo);
      AppMethodBeat.o(207161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.COn == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = g.a.a.a.oD(1, this.COn.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.COo);
      AppMethodBeat.o(207161);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.COo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.COn == null)
        {
          paramVarArgs = new b("Not all required fields were included: Tab");
          AppMethodBeat.o(207161);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207161);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dz)localObject2).parseFrom((byte[])localObject1);
            }
            localaj.COn = ((dz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207161);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ee();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ee)localObject2).parseFrom((byte[])localObject1);
          }
          localaj.COo.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207161);
        return 0;
      }
      AppMethodBeat.o(207161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aj
 * JD-Core Version:    0.7.0.1
 */