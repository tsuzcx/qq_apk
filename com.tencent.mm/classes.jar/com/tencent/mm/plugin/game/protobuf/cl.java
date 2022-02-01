package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cl
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public cz IHf;
  public String IKI;
  public String IKJ;
  public String IKK;
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41796);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      if (this.IKI != null) {
        paramVarArgs.g(2, this.IKI);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(3, this.IKJ);
      }
      if (this.IKK != null) {
        paramVarArgs.g(4, this.IKK);
      }
      if (this.IHf != null)
      {
        paramVarArgs.qD(5, this.IHf.computeSize());
        this.IHf.writeFields(paramVarArgs);
      }
      if (this.IGI != null) {
        paramVarArgs.g(6, this.IGI);
      }
      AppMethodBeat.o(41796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label588;
      }
    }
    label588:
    for (int i = i.a.a.b.b.a.h(1, this.muA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IKI);
      }
      i = paramInt;
      if (this.IKJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IKJ);
      }
      paramInt = i;
      if (this.IKK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKK);
      }
      i = paramInt;
      if (this.IHf != null) {
        i = paramInt + i.a.a.a.qC(5, this.IHf.computeSize());
      }
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IGI);
      }
      AppMethodBeat.o(41796);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cl localcl = (cl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41796);
          return -1;
        case 1: 
          localcl.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 2: 
          localcl.IKI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 3: 
          localcl.IKJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 4: 
          localcl.IKK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41796);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cz localcz = new cz();
            if ((localObject != null) && (localObject.length > 0)) {
              localcz.parseFrom((byte[])localObject);
            }
            localcl.IHf = localcz;
            paramInt += 1;
          }
          AppMethodBeat.o(41796);
          return 0;
        }
        localcl.IGI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41796);
        return 0;
      }
      AppMethodBeat.o(41796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cl
 * JD-Core Version:    0.7.0.1
 */