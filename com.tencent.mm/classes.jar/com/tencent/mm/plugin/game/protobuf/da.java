package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class da
  extends com.tencent.mm.bx.a
{
  public LinkedList<c> ILb;
  public dk ILc;
  public LinkedList<s> ILd;
  public df ILe;
  public LinkedList<dy> ILf;
  
  public da()
  {
    AppMethodBeat.i(41809);
    this.ILb = new LinkedList();
    this.ILd = new LinkedList();
    this.ILf = new LinkedList();
    AppMethodBeat.o(41809);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41810);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ILb);
      if (this.ILc != null)
      {
        paramVarArgs.qD(2, this.ILc.computeSize());
        this.ILc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.ILd);
      if (this.ILe != null)
      {
        paramVarArgs.qD(4, this.ILe.computeSize());
        this.ILe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.ILf);
      AppMethodBeat.o(41810);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ILb) + 0;
      paramInt = i;
      if (this.ILc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ILc.computeSize());
      }
      i = paramInt + i.a.a.a.c(3, 8, this.ILd);
      paramInt = i;
      if (this.ILe != null) {
        paramInt = i + i.a.a.a.qC(4, this.ILe.computeSize());
      }
      i = i.a.a.a.c(5, 8, this.ILf);
      AppMethodBeat.o(41810);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ILb.clear();
      this.ILd.clear();
      this.ILf.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(41810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      da localda = (da)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41810);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          localda.ILb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dk)localObject2).parseFrom((byte[])localObject1);
          }
          localda.ILc = ((dk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new s();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((s)localObject2).parseFrom((byte[])localObject1);
          }
          localda.ILd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new df();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((df)localObject2).parseFrom((byte[])localObject1);
          }
          localda.ILe = ((df)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dy();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dy)localObject2).parseFrom((byte[])localObject1);
        }
        localda.ILf.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(41810);
      return 0;
    }
    AppMethodBeat.o(41810);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.da
 * JD-Core Version:    0.7.0.1
 */