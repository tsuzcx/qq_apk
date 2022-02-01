package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class be
  extends com.tencent.mm.bx.a
{
  public g IGJ;
  public String IGQ;
  public String IHI;
  public LinkedList<bf> IJw;
  
  public be()
  {
    AppMethodBeat.i(41748);
    this.IJw = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
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
      paramVarArgs.e(3, 8, this.IJw);
      if (this.IHI != null) {
        paramVarArgs.g(4, this.IHI);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGJ == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = i.a.a.a.qC(1, this.IGJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGQ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGQ);
      }
      i += i.a.a.a.c(3, 8, this.IJw);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IHI);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IJw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IGJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41749);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41749);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        be localbe = (be)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new g();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((g)localObject2).parseFrom((byte[])localObject1);
            }
            localbe.IGJ = ((g)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localbe.IGQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bf)localObject2).parseFrom((byte[])localObject1);
            }
            localbe.IJw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localbe.IHI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.be
 * JD-Core Version:    0.7.0.1
 */