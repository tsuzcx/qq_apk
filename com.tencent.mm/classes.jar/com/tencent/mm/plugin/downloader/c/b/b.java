package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.cd.a
{
  public String icon;
  public r ufn;
  public r ufo;
  public String ufp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153059);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.icon != null) {
        paramVarArgs.f(1, this.icon);
      }
      if (this.ufn != null)
      {
        paramVarArgs.oE(2, this.ufn.computeSize());
        this.ufn.writeFields(paramVarArgs);
      }
      if (this.ufo != null)
      {
        paramVarArgs.oE(3, this.ufo.computeSize());
        this.ufo.writeFields(paramVarArgs);
      }
      if (this.ufp != null) {
        paramVarArgs.f(4, this.ufp);
      }
      AppMethodBeat.o(153059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.b.b.a.g(1, this.icon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufn != null) {
        paramInt = i + g.a.a.a.oD(2, this.ufn.computeSize());
      }
      i = paramInt;
      if (this.ufo != null) {
        i = paramInt + g.a.a.a.oD(3, this.ufo.computeSize());
      }
      paramInt = i;
      if (this.ufp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufp);
      }
      AppMethodBeat.o(153059);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153059);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        r localr;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153059);
          return -1;
        case 1: 
          localb.icon = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153059);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localr = new r();
            if ((localObject != null) && (localObject.length > 0)) {
              localr.parseFrom((byte[])localObject);
            }
            localb.ufn = localr;
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localr = new r();
            if ((localObject != null) && (localObject.length > 0)) {
              localr.parseFrom((byte[])localObject);
            }
            localb.ufo = localr;
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        }
        localb.ufp = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153059);
        return 0;
      }
      AppMethodBeat.o(153059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.b
 * JD-Core Version:    0.7.0.1
 */