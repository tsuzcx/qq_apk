package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dq
  extends com.tencent.mm.cd.a
{
  public LinkedList<az> CNz;
  public String COL;
  public String CPo;
  public String fwr;
  
  public dq()
  {
    AppMethodBeat.i(41830);
    this.CNz = new LinkedList();
    AppMethodBeat.o(41830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41831);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.e(2, 8, this.CNz);
      if (this.COL != null) {
        paramVarArgs.f(3, this.COL);
      }
      if (this.CPo != null) {
        paramVarArgs.f(4, this.CPo);
      }
      AppMethodBeat.o(41831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label456;
      }
    }
    label456:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.CNz);
      paramInt = i;
      if (this.COL != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.COL);
      }
      i = paramInt;
      if (this.CPo != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CPo);
      }
      AppMethodBeat.o(41831);
      return i;
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
        AppMethodBeat.o(41831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41831);
          return -1;
        case 1: 
          localdq.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41831);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            az localaz = new az();
            if ((localObject != null) && (localObject.length > 0)) {
              localaz.parseFrom((byte[])localObject);
            }
            localdq.CNz.add(localaz);
            paramInt += 1;
          }
          AppMethodBeat.o(41831);
          return 0;
        case 3: 
          localdq.COL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41831);
          return 0;
        }
        localdq.CPo = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41831);
        return 0;
      }
      AppMethodBeat.o(41831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dq
 * JD-Core Version:    0.7.0.1
 */