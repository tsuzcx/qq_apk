package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bf
  extends com.tencent.mm.cd.a
{
  public LinkedList<ai> CNz;
  public String COL;
  public String CPo;
  public String fwr;
  
  public bf()
  {
    AppMethodBeat.i(41752);
    this.CNz = new LinkedList();
    AppMethodBeat.o(41752);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41753);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CNz);
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.COL != null) {
        paramVarArgs.f(3, this.COL);
      }
      if (this.CPo != null) {
        paramVarArgs.f(4, this.CPo);
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.CNz) + 0;
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.COL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.COL);
      }
      paramInt = i;
      if (this.CPo != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CPo);
      }
      AppMethodBeat.o(41753);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(41753);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bf localbf = (bf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41753);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ai localai = new ai();
          if ((localObject != null) && (localObject.length > 0)) {
            localai.parseFrom((byte[])localObject);
          }
          localbf.CNz.add(localai);
          paramInt += 1;
        }
        AppMethodBeat.o(41753);
        return 0;
      case 2: 
        localbf.fwr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41753);
        return 0;
      case 3: 
        localbf.COL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41753);
        return 0;
      }
      localbf.CPo = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(41753);
      return 0;
    }
    AppMethodBeat.o(41753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bf
 * JD-Core Version:    0.7.0.1
 */