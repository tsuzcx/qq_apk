package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class aj
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public g IGJ;
  public LinkedList<String> IIv;
  public String IIw;
  
  public aj()
  {
    AppMethodBeat.i(41727);
    this.IIv = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGJ != null)
      {
        paramVarArgs.qD(1, this.IGJ.computeSize());
        this.IGJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.IIv);
      if (this.IIw != null) {
        paramVarArgs.g(3, this.IIw);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGJ == null) {
        break label464;
      }
    }
    label464:
    for (paramInt = i.a.a.a.qC(1, this.IGJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.IIv);
      paramInt = i;
      if (this.IIw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IIw);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IGG);
      }
      AppMethodBeat.o(41728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IIv.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41728);
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
            localaj.IGJ = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localaj.IIv.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localaj.IIw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localaj.IGG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aj
 * JD-Core Version:    0.7.0.1
 */