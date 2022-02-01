package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ct
  extends com.tencent.mm.cd.a
{
  public String COk;
  public LinkedList<db> Crs;
  public String fwr;
  
  public ct()
  {
    AppMethodBeat.i(41806);
    this.Crs = new LinkedList();
    AppMethodBeat.o(41806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41807);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.COk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41807);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.e(2, 8, this.Crs);
      if (this.COk != null) {
        paramVarArgs.f(3, this.COk);
      }
      AppMethodBeat.o(41807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Crs);
      paramInt = i;
      if (this.COk != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.COk);
      }
      AppMethodBeat.o(41807);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Crs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        if (this.COk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41807);
          return -1;
        case 1: 
          localct.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41807);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            db localdb = new db();
            if ((localObject != null) && (localObject.length > 0)) {
              localdb.parseFrom((byte[])localObject);
            }
            localct.Crs.add(localdb);
            paramInt += 1;
          }
          AppMethodBeat.o(41807);
          return 0;
        }
        localct.COk = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41807);
        return 0;
      }
      AppMethodBeat.o(41807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ct
 * JD-Core Version:    0.7.0.1
 */