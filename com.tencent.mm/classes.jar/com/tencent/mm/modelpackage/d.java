package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String oQm;
  public String oQn;
  public q oQo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231006);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.oQm != null) {
        paramVarArgs.g(2, this.oQm);
      }
      if (this.oQn != null) {
        paramVarArgs.g(3, this.oQn);
      }
      if (this.oQo != null)
      {
        paramVarArgs.qD(4, this.oQo.computeSize());
        this.oQo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(231006);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.b.b.a.h(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oQm != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oQm);
      }
      i = paramInt;
      if (this.oQn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oQn);
      }
      paramInt = i;
      if (this.oQo != null) {
        paramInt = i + i.a.a.a.qC(4, this.oQo.computeSize());
      }
      AppMethodBeat.o(231006);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(231006);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231006);
          return -1;
        case 1: 
          locald.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231006);
          return 0;
        case 2: 
          locald.oQm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231006);
          return 0;
        case 3: 
          locald.oQn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231006);
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
          locald.oQo = localq;
          paramInt += 1;
        }
        AppMethodBeat.o(231006);
        return 0;
      }
      AppMethodBeat.o(231006);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelpackage.d
 * JD-Core Version:    0.7.0.1
 */