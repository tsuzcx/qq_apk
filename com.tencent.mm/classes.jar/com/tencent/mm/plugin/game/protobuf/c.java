package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public g IGJ;
  public String IGK;
  public String IGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41708);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGK == null)
      {
        paramVarArgs = new b("Not all required fields were included: AdURL");
        AppMethodBeat.o(41708);
        throw paramVarArgs;
      }
      if (this.IGJ != null)
      {
        paramVarArgs.qD(1, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      if (this.IGK != null) {
        paramVarArgs.g(2, this.IGK);
      }
      if (this.IGL != null) {
        paramVarArgs.g(3, this.IGL);
      }
      AppMethodBeat.o(41708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGJ == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.a.qC(1, this.IGJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGK);
      }
      i = paramInt;
      if (this.IGL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGL);
      }
      AppMethodBeat.o(41708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IGK == null)
        {
          paramVarArgs = new b("Not all required fields were included: AdURL");
          AppMethodBeat.o(41708);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41708);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            g localg = new g();
            if ((localObject != null) && (localObject.length > 0)) {
              localg.parseFrom((byte[])localObject);
            }
            localc.IGJ = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41708);
          return 0;
        case 2: 
          localc.IGK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41708);
          return 0;
        }
        localc.IGL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41708);
        return 0;
      }
      AppMethodBeat.o(41708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.c
 * JD-Core Version:    0.7.0.1
 */