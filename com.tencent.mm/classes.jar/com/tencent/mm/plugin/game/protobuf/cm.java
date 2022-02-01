package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cm
  extends com.tencent.mm.cd.a
{
  public ef CQC;
  public de CQD;
  public ae CQE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41797);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CQC != null)
      {
        paramVarArgs.oE(1, this.CQC.computeSize());
        this.CQC.writeFields(paramVarArgs);
      }
      if (this.CQD != null)
      {
        paramVarArgs.oE(2, this.CQD.computeSize());
        this.CQD.writeFields(paramVarArgs);
      }
      if (this.CQE != null)
      {
        paramVarArgs.oE(3, this.CQE.computeSize());
        this.CQE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQC == null) {
        break label552;
      }
    }
    label552:
    for (int i = g.a.a.a.oD(1, this.CQC.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQD != null) {
        paramInt = i + g.a.a.a.oD(2, this.CQD.computeSize());
      }
      i = paramInt;
      if (this.CQE != null) {
        i = paramInt + g.a.a.a.oD(3, this.CQE.computeSize());
      }
      AppMethodBeat.o(41797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41797);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ef();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ef)localObject2).parseFrom((byte[])localObject1);
            }
            localcm.CQC = ((ef)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new de();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((de)localObject2).parseFrom((byte[])localObject1);
            }
            localcm.CQD = ((de)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ae)localObject2).parseFrom((byte[])localObject1);
          }
          localcm.CQE = ((ae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      AppMethodBeat.o(41797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cm
 * JD-Core Version:    0.7.0.1
 */