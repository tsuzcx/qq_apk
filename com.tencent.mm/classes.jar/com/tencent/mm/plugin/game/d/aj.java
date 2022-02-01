package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aj
  extends com.tencent.mm.bx.a
{
  public String rZW;
  public String rZX;
  public LinkedList<cy> saZ;
  public String sba;
  public String sbb;
  
  public aj()
  {
    AppMethodBeat.i(41738);
    this.saZ = new LinkedList();
    AppMethodBeat.o(41738);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZX != null) {
        paramVarArgs.d(1, this.rZX);
      }
      paramVarArgs.e(2, 8, this.saZ);
      if (this.sba != null) {
        paramVarArgs.d(3, this.sba);
      }
      if (this.sbb != null) {
        paramVarArgs.d(4, this.sbb);
      }
      if (this.rZW != null) {
        paramVarArgs.d(5, this.rZW);
      }
      AppMethodBeat.o(41739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZX == null) {
        break label538;
      }
    }
    label538:
    for (paramInt = f.a.a.b.b.a.e(1, this.rZX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.saZ);
      paramInt = i;
      if (this.sba != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sba);
      }
      i = paramInt;
      if (this.sbb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sbb);
      }
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.rZW);
      }
      AppMethodBeat.o(41739);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.saZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41739);
          return -1;
        case 1: 
          localaj.rZX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaj.saZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41739);
          return 0;
        case 3: 
          localaj.sba = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 4: 
          localaj.sbb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41739);
          return 0;
        }
        localaj.rZW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41739);
        return 0;
      }
      AppMethodBeat.o(41739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aj
 * JD-Core Version:    0.7.0.1
 */