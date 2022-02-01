package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ad
  extends com.tencent.mm.bx.a
{
  public eu IIn;
  public boolean IIo;
  public boolean IIp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276917);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IIn != null)
      {
        paramVarArgs.qD(1, this.IIn.computeSize());
        this.IIn.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.IIo);
      paramVarArgs.di(4, this.IIp);
      AppMethodBeat.o(276917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IIn == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.IIn.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(276917);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(276917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(276917);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eu localeu = new eu();
            if ((localObject != null) && (localObject.length > 0)) {
              localeu.parseFrom((byte[])localObject);
            }
            localad.IIn = localeu;
            paramInt += 1;
          }
          AppMethodBeat.o(276917);
          return 0;
        case 2: 
          localad.IIo = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(276917);
          return 0;
        }
        localad.IIp = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(276917);
        return 0;
      }
      AppMethodBeat.o(276917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */