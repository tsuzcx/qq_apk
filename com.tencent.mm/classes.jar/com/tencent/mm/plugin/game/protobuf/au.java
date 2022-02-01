package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class au
  extends com.tencent.mm.bx.a
{
  public String IHI;
  public String IHJ;
  public LinkedList<dt> IIU;
  public String IIV;
  public String IIW;
  
  public au()
  {
    AppMethodBeat.i(41738);
    this.IIU = new LinkedList();
    AppMethodBeat.o(41738);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41739);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHJ != null) {
        paramVarArgs.g(1, this.IHJ);
      }
      paramVarArgs.e(2, 8, this.IIU);
      if (this.IIV != null) {
        paramVarArgs.g(3, this.IIV);
      }
      if (this.IIW != null) {
        paramVarArgs.g(4, this.IIW);
      }
      if (this.IHI != null) {
        paramVarArgs.g(5, this.IHI);
      }
      AppMethodBeat.o(41739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHJ == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = i.a.a.b.b.a.h(1, this.IHJ) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.IIU);
      paramInt = i;
      if (this.IIV != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IIV);
      }
      i = paramInt;
      if (this.IIW != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IIW);
      }
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IHI);
      }
      AppMethodBeat.o(41739);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IIU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41739);
          return -1;
        case 1: 
          localau.IHJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dt localdt = new dt();
            if ((localObject != null) && (localObject.length > 0)) {
              localdt.parseFrom((byte[])localObject);
            }
            localau.IIU.add(localdt);
            paramInt += 1;
          }
          AppMethodBeat.o(41739);
          return 0;
        case 3: 
          localau.IIV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41739);
          return 0;
        case 4: 
          localau.IIW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41739);
          return 0;
        }
        localau.IHI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41739);
        return 0;
      }
      AppMethodBeat.o(41739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.au
 * JD-Core Version:    0.7.0.1
 */