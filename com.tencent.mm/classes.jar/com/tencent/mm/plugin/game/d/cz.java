package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cz
  extends com.tencent.mm.bx.a
{
  public String Title;
  public LinkedList<ap> rZV;
  public String sba;
  public String sbv;
  
  public cz()
  {
    AppMethodBeat.i(41830);
    this.rZV = new LinkedList();
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
      paramVarArgs.e(2, 8, this.rZV);
      if (this.sba != null) {
        paramVarArgs.d(3, this.sba);
      }
      if (this.sbv != null) {
        paramVarArgs.d(4, this.sbv);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.rZV);
      paramInt = i;
      if (this.sba != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sba);
      }
      i = paramInt;
      if (this.sbv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sbv);
      }
      AppMethodBeat.o(41831);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rZV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41831);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cz localcz = (cz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41831);
          return -1;
        case 1: 
          localcz.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41831);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ap();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ap)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcz.rZV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41831);
          return 0;
        case 3: 
          localcz.sba = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41831);
          return 0;
        }
        localcz.sbv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41831);
        return 0;
      }
      AppMethodBeat.o(41831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cz
 * JD-Core Version:    0.7.0.1
 */