package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bg
  extends com.tencent.mm.bx.a
{
  public LinkedList<aj> IHH;
  public String IIV;
  public String IJy;
  public String hAP;
  
  public bg()
  {
    AppMethodBeat.i(41752);
    this.IHH = new LinkedList();
    AppMethodBeat.o(41752);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41753);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.IHH);
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.IIV != null) {
        paramVarArgs.g(3, this.IIV);
      }
      if (this.IJy != null) {
        paramVarArgs.g(4, this.IJy);
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.IHH) + 0;
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.IIV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IIV);
      }
      paramInt = i;
      if (this.IJy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IJy);
      }
      AppMethodBeat.o(41753);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IHH.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bg localbg = (bg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41753);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aj localaj = new aj();
          if ((localObject != null) && (localObject.length > 0)) {
            localaj.parseFrom((byte[])localObject);
          }
          localbg.IHH.add(localaj);
          paramInt += 1;
        }
        AppMethodBeat.o(41753);
        return 0;
      case 2: 
        localbg.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41753);
        return 0;
      case 3: 
        localbg.IIV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41753);
        return 0;
      }
      localbg.IJy = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(41753);
      return 0;
    }
    AppMethodBeat.o(41753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */