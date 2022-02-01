package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public String appId;
  public q oQo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230996);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.oQo != null)
      {
        paramVarArgs.qD(2, this.oQo.computeSize());
        this.oQo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230996);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oQo != null) {
        i = paramInt + i.a.a.a.qC(2, this.oQo.computeSize());
      }
      AppMethodBeat.o(230996);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(230996);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230996);
          return -1;
        case 1: 
          locali.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(230996);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          q localq = new q();
          if ((localObject != null) && (localObject.length > 0)) {
            localq.parseFrom((byte[])localObject);
          }
          locali.oQo = localq;
          paramInt += 1;
        }
        AppMethodBeat.o(230996);
        return 0;
      }
      AppMethodBeat.o(230996);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelpackage.i
 * JD-Core Version:    0.7.0.1
 */