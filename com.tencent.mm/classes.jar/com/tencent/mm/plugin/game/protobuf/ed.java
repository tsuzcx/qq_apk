package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ed
  extends com.tencent.mm.bx.a
{
  public LinkedList<eh> ILQ;
  public ee ILR;
  public String ILS;
  public String ILT;
  
  public ed()
  {
    AppMethodBeat.i(276896);
    this.ILQ = new LinkedList();
    AppMethodBeat.o(276896);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276898);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ILQ);
      if (this.ILR != null)
      {
        paramVarArgs.qD(2, this.ILR.computeSize());
        this.ILR.writeFields(paramVarArgs);
      }
      if (this.ILS != null) {
        paramVarArgs.g(3, this.ILS);
      }
      if (this.ILT != null) {
        paramVarArgs.g(4, this.ILT);
      }
      AppMethodBeat.o(276898);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ILQ) + 0;
      paramInt = i;
      if (this.ILR != null) {
        paramInt = i + i.a.a.a.qC(2, this.ILR.computeSize());
      }
      i = paramInt;
      if (this.ILS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ILS);
      }
      paramInt = i;
      if (this.ILT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ILT);
      }
      AppMethodBeat.o(276898);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ILQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276898);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ed localed = (ed)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276898);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eh)localObject2).parseFrom((byte[])localObject1);
          }
          localed.ILQ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276898);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ee();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ee)localObject2).parseFrom((byte[])localObject1);
          }
          localed.ILR = ((ee)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276898);
        return 0;
      case 3: 
        localed.ILS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(276898);
        return 0;
      }
      localed.ILT = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(276898);
      return 0;
    }
    AppMethodBeat.o(276898);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ed
 * JD-Core Version:    0.7.0.1
 */