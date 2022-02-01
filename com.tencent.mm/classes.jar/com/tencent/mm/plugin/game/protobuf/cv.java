package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cv
  extends com.tencent.mm.bx.a
{
  public String IIu;
  public LinkedList<de> Idy;
  public String hAP;
  
  public cv()
  {
    AppMethodBeat.i(41806);
    this.Idy = new LinkedList();
    AppMethodBeat.o(41806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41807);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.IIu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.Idy);
      if (this.IIu != null) {
        paramVarArgs.g(3, this.IIu);
      }
      AppMethodBeat.o(41807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label488;
      }
    }
    label488:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.Idy);
      paramInt = i;
      if (this.IIu != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IIu);
      }
      AppMethodBeat.o(41807);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Idy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        if (this.IIu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41807);
          return -1;
        case 1: 
          localcv.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41807);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            de localde = new de();
            if ((localObject != null) && (localObject.length > 0)) {
              localde.parseFrom((byte[])localObject);
            }
            localcv.Idy.add(localde);
            paramInt += 1;
          }
          AppMethodBeat.o(41807);
          return 0;
        }
        localcv.IIu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41807);
        return 0;
      }
      AppMethodBeat.o(41807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */