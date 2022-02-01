package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b vhv;
  public b vhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23490);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhJ != null)
      {
        paramVarArgs.oE(1, this.vhJ.computeSize());
        this.vhJ.writeFields(paramVarArgs);
      }
      if (this.vhv != null) {
        paramVarArgs.c(2, this.vhv);
      }
      if (this.vhw != null) {
        paramVarArgs.c(3, this.vhw);
      }
      AppMethodBeat.o(23490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhJ == null) {
        break label417;
      }
    }
    label417:
    for (int i = g.a.a.a.oD(1, this.vhJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhv != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.vhv);
      }
      i = paramInt;
      if (this.vhw != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.vhw);
      }
      AppMethodBeat.o(23490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(23490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23490);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            d locald = new d();
            if ((localObject != null) && (localObject.length > 0)) {
              locald.parseFrom((byte[])localObject);
            }
            localf.vhJ = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(23490);
          return 0;
        case 2: 
          localf.vhv = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(23490);
          return 0;
        }
        localf.vhw = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(23490);
        return 0;
      }
      AppMethodBeat.o(23490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.f
 * JD-Core Version:    0.7.0.1
 */