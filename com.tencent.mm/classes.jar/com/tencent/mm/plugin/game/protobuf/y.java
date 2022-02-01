package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class y
  extends com.tencent.mm.bx.a
{
  public String IId;
  public String IIe;
  public String IIf;
  public ex IIg;
  public int IIh;
  public int IIi;
  public String IIj;
  public int IIk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IId == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.IId != null) {
        paramVarArgs.g(1, this.IId);
      }
      if (this.IIe != null) {
        paramVarArgs.g(2, this.IIe);
      }
      if (this.IIf != null) {
        paramVarArgs.g(4, this.IIf);
      }
      if (this.IIg != null)
      {
        paramVarArgs.qD(5, this.IIg.computeSize());
        this.IIg.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.IIh);
      paramVarArgs.bS(7, this.IIi);
      if (this.IIj != null) {
        paramVarArgs.g(8, this.IIj);
      }
      paramVarArgs.bS(9, this.IIk);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IId == null) {
        break label716;
      }
    }
    label716:
    for (int i = i.a.a.b.b.a.h(1, this.IId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IIe != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IIe);
      }
      i = paramInt;
      if (this.IIf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IIf);
      }
      paramInt = i;
      if (this.IIg != null) {
        paramInt = i + i.a.a.a.qC(5, this.IIg.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.IIh) + i.a.a.b.b.a.cJ(7, this.IIi);
      paramInt = i;
      if (this.IIj != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.IIj);
      }
      i = i.a.a.b.b.a.cJ(9, this.IIk);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IId == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadURL");
          AppMethodBeat.o(41721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(41721);
          return -1;
        case 1: 
          localy.IId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          localy.IIe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          localy.IIf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ex localex = new ex();
            if ((localObject != null) && (localObject.length > 0)) {
              localex.parseFrom((byte[])localObject);
            }
            localy.IIg = localex;
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          localy.IIh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          localy.IIi = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          localy.IIj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        localy.IIk = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.y
 * JD-Core Version:    0.7.0.1
 */