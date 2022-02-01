package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dp
  extends com.tencent.mm.bw.a
{
  public String Title;
  public LinkedList<ax> uqZ;
  public String usN;
  public String usm;
  
  public dp()
  {
    AppMethodBeat.i(41830);
    this.uqZ = new LinkedList();
    AppMethodBeat.o(41830);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.uqZ);
      if (this.usm != null) {
        paramVarArgs.d(3, this.usm);
      }
      if (this.usN != null) {
        paramVarArgs.d(4, this.usN);
      }
      AppMethodBeat.o(41831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.uqZ);
      paramInt = i;
      if (this.usm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.usm);
      }
      i = paramInt;
      if (this.usN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.usN);
      }
      AppMethodBeat.o(41831);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uqZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dp localdp = (dp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41831);
          return -1;
        case 1: 
          localdp.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41831);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ax();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ax)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdp.uqZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41831);
          return 0;
        case 3: 
          localdp.usm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41831);
          return 0;
        }
        localdp.usN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41831);
        return 0;
      }
      AppMethodBeat.o(41831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dp
 * JD-Core Version:    0.7.0.1
 */