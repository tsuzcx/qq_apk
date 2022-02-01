package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class du
  extends com.tencent.mm.bx.a
{
  public LinkedList<ba> IHH;
  public String IIV;
  public String IJy;
  public String hAP;
  
  public du()
  {
    AppMethodBeat.i(41830);
    this.IHH = new LinkedList();
    AppMethodBeat.o(41830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41831);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.IHH);
      if (this.IIV != null) {
        paramVarArgs.g(3, this.IIV);
      }
      if (this.IJy != null) {
        paramVarArgs.g(4, this.IJy);
      }
      AppMethodBeat.o(41831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.IHH);
      paramInt = i;
      if (this.IIV != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IIV);
      }
      i = paramInt;
      if (this.IJy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IJy);
      }
      AppMethodBeat.o(41831);
      return i;
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
        AppMethodBeat.o(41831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        du localdu = (du)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41831);
          return -1;
        case 1: 
          localdu.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41831);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ba localba = new ba();
            if ((localObject != null) && (localObject.length > 0)) {
              localba.parseFrom((byte[])localObject);
            }
            localdu.IHH.add(localba);
            paramInt += 1;
          }
          AppMethodBeat.o(41831);
          return 0;
        case 3: 
          localdu.IIV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41831);
          return 0;
        }
        localdu.IJy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41831);
        return 0;
      }
      AppMethodBeat.o(41831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.du
 * JD-Core Version:    0.7.0.1
 */