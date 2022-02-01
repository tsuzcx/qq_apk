package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public boolean aqS;
  public a msi;
  public LinkedList<b> msj;
  
  public d()
  {
    AppMethodBeat.i(233267);
    this.msj = new LinkedList();
    AppMethodBeat.o(233267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233277);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aqS);
      if (this.msi != null)
      {
        paramVarArgs.qD(2, this.msi.computeSize());
        this.msi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.msj);
      AppMethodBeat.o(233277);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.msi != null) {
        paramInt = i + i.a.a.a.qC(2, this.msi.computeSize());
      }
      i = i.a.a.a.c(3, 8, this.msj);
      AppMethodBeat.o(233277);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.msj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(233277);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(233277);
        return -1;
      case 1: 
        locald.aqS = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(233277);
        return 0;
      case 2: 
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
          locald.msi = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(233277);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new b();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((b)localObject2).parseFrom((byte[])localObject1);
        }
        locald.msj.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(233277);
      return 0;
    }
    AppMethodBeat.o(233277);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */