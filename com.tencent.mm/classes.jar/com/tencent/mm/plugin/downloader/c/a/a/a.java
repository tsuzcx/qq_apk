package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class a
  extends dop
{
  public LinkedList<String> qFI;
  public boolean qFJ;
  public boolean qFK;
  public boolean qFL;
  
  public a()
  {
    AppMethodBeat.i(153039);
    this.qFI = new LinkedList();
    AppMethodBeat.o(153039);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153040);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.qFI);
      paramVarArgs.cc(3, this.qFJ);
      paramVarArgs.cc(4, this.qFK);
      paramVarArgs.cc(5, this.qFL);
      AppMethodBeat.o(153040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.qFI);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(153040);
      return paramInt + i + (j + 1) + (k + 1) + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qFI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153040);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153040);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locala.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153040);
          return 0;
        case 2: 
          locala.qFI.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(153040);
          return 0;
        case 3: 
          locala.qFJ = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153040);
          return 0;
        case 4: 
          locala.qFK = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153040);
          return 0;
        }
        locala.qFL = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(153040);
        return 0;
      }
      AppMethodBeat.o(153040);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */