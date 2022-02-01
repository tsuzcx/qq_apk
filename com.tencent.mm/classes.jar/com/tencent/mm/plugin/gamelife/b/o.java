package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bx.a
{
  public a JaG;
  public n JaO;
  public String JaP;
  public String session_id;
  public String waL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267794);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.session_id != null) {
        paramVarArgs.g(1, this.session_id);
      }
      if (this.JaO != null)
      {
        paramVarArgs.qD(2, this.JaO.computeSize());
        this.JaO.writeFields(paramVarArgs);
      }
      if (this.JaP != null) {
        paramVarArgs.g(3, this.JaP);
      }
      if (this.waL != null) {
        paramVarArgs.g(4, this.waL);
      }
      if (this.JaG != null)
      {
        paramVarArgs.qD(5, this.JaG.computeSize());
        this.JaG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(267794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.session_id == null) {
        break label598;
      }
    }
    label598:
    for (int i = i.a.a.b.b.a.h(1, this.session_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.JaO != null) {
        paramInt = i + i.a.a.a.qC(2, this.JaO.computeSize());
      }
      i = paramInt;
      if (this.JaP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.JaP);
      }
      paramInt = i;
      if (this.waL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.waL);
      }
      i = paramInt;
      if (this.JaG != null) {
        i = paramInt + i.a.a.a.qC(5, this.JaG.computeSize());
      }
      AppMethodBeat.o(267794);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267794);
          return -1;
        case 1: 
          localo.session_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(267794);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new n();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((n)localObject2).parseFrom((byte[])localObject1);
            }
            localo.JaO = ((n)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267794);
          return 0;
        case 3: 
          localo.JaP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(267794);
          return 0;
        case 4: 
          localo.waL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(267794);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localo.JaG = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267794);
        return 0;
      }
      AppMethodBeat.o(267794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.o
 * JD-Core Version:    0.7.0.1
 */