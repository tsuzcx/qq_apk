package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ei
  extends com.tencent.mm.bx.a
{
  public ed IIx;
  public long vhU;
  public long vhV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276894);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IIx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(276894);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.vhU);
      paramVarArgs.bv(2, this.vhV);
      if (this.IIx != null)
      {
        paramVarArgs.qD(3, this.IIx.computeSize());
        this.IIx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(276894);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.vhU) + 0 + i.a.a.b.b.a.q(2, this.vhV);
      paramInt = i;
      if (this.IIx != null) {
        paramInt = i + i.a.a.a.qC(3, this.IIx.computeSize());
      }
      AppMethodBeat.o(276894);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.IIx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(276894);
        throw paramVarArgs;
      }
      AppMethodBeat.o(276894);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ei localei = (ei)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276894);
        return -1;
      case 1: 
        localei.vhU = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(276894);
        return 0;
      case 2: 
        localei.vhV = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(276894);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ed localed = new ed();
        if ((localObject != null) && (localObject.length > 0)) {
          localed.parseFrom((byte[])localObject);
        }
        localei.IIx = localed;
        paramInt += 1;
      }
      AppMethodBeat.o(276894);
      return 0;
    }
    AppMethodBeat.o(276894);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */