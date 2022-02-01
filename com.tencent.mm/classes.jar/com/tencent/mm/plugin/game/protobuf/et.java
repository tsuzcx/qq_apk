package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class et
  extends com.tencent.mm.bx.a
{
  public boolean IMl;
  public LinkedList<do> IMm;
  public LinkedList<do> IMn;
  
  public et()
  {
    AppMethodBeat.i(149421);
    this.IMm = new LinkedList();
    this.IMn = new LinkedList();
    AppMethodBeat.o(149421);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149422);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.IMl);
      paramVarArgs.e(3, 8, this.IMm);
      paramVarArgs.e(4, 8, this.IMn);
      AppMethodBeat.o(149422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      i = i.a.a.a.c(3, 8, this.IMm);
      int j = i.a.a.a.c(4, 8, this.IMn);
      AppMethodBeat.o(149422);
      return paramInt + 1 + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IMm.clear();
      this.IMn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(149422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      et localet = (et)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      do localdo;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(149422);
        return -1;
      case 1: 
        localet.IMl = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(149422);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdo = new do();
          if ((localObject != null) && (localObject.length > 0)) {
            localdo.parseFrom((byte[])localObject);
          }
          localet.IMm.add(localdo);
          paramInt += 1;
        }
        AppMethodBeat.o(149422);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localdo = new do();
        if ((localObject != null) && (localObject.length > 0)) {
          localdo.parseFrom((byte[])localObject);
        }
        localet.IMn.add(localdo);
        paramInt += 1;
      }
      AppMethodBeat.o(149422);
      return 0;
    }
    AppMethodBeat.o(149422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.et
 * JD-Core Version:    0.7.0.1
 */