package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dl
  extends com.tencent.mm.bx.a
{
  public g IGJ;
  public String IGQ;
  public boolean IGZ;
  public LinkedList<String> IHa;
  
  public dl()
  {
    AppMethodBeat.i(41821);
    this.IHa = new LinkedList();
    AppMethodBeat.o(41821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41822);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41822);
        throw paramVarArgs;
      }
      if (this.IGJ != null)
      {
        paramVarArgs.qD(1, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      if (this.IGQ != null) {
        paramVarArgs.g(2, this.IGQ);
      }
      paramVarArgs.di(3, this.IGZ);
      paramVarArgs.e(4, 1, this.IHa);
      AppMethodBeat.o(41822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGJ == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.IGJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGQ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGQ);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.a.c(4, 1, this.IHa);
      AppMethodBeat.o(41822);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IHa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IGJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41822);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dl localdl = (dl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41822);
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
            localdl.IGJ = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41822);
          return 0;
        case 2: 
          localdl.IGQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41822);
          return 0;
        case 3: 
          localdl.IGZ = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(41822);
          return 0;
        }
        localdl.IHa.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(41822);
        return 0;
      }
      AppMethodBeat.o(41822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dl
 * JD-Core Version:    0.7.0.1
 */