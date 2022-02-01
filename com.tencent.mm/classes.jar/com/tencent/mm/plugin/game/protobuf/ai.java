package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ai
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public g CME;
  public LinkedList<String> COl;
  public String COm;
  
  public ai()
  {
    AppMethodBeat.i(41727);
    this.COl = new LinkedList();
    AppMethodBeat.o(41727);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41728);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CME != null)
      {
        paramVarArgs.oE(1, this.CME.computeSize());
        this.CME.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.COl);
      if (this.COm != null) {
        paramVarArgs.f(3, this.COm);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      AppMethodBeat.o(41728);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CME == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = g.a.a.a.oD(1, this.CME.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.COl);
      paramInt = i;
      if (this.COm != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.COm);
      }
      i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CMB);
      }
      AppMethodBeat.o(41728);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.COl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41728);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41728);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            g localg = new g();
            if ((localObject != null) && (localObject.length > 0)) {
              localg.parseFrom((byte[])localObject);
            }
            localai.CME = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(41728);
          return 0;
        case 2: 
          localai.COl.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(41728);
          return 0;
        case 3: 
          localai.COm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(41728);
          return 0;
        }
        localai.CMB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(41728);
        return 0;
      }
      AppMethodBeat.o(41728);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */