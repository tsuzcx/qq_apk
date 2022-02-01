package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long ndb;
  public m nde;
  public int ndg;
  public long ndh;
  public long ndi;
  public int ndj;
  public int ndk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22119);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aO(2, this.ndh);
      paramVarArgs.aO(3, this.ndi);
      paramVarArgs.aR(4, this.ndj);
      paramVarArgs.aR(5, this.ndk);
      paramVarArgs.aO(6, this.ndb);
      if (this.nde != null)
      {
        paramVarArgs.ln(7, this.nde.computeSize());
        this.nde.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.ndg);
      AppMethodBeat.o(22119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.ndh) + f.a.a.b.b.a.p(3, this.ndi) + f.a.a.b.b.a.bx(4, this.ndj) + f.a.a.b.b.a.bx(5, this.ndk) + f.a.a.b.b.a.p(6, this.ndb);
      paramInt = i;
      if (this.nde != null) {
        paramInt = i + f.a.a.a.lm(7, this.nde.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.ndg);
      AppMethodBeat.o(22119);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22119);
          return -1;
        case 1: 
          localo.ID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(22119);
          return 0;
        case 2: 
          localo.ndh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22119);
          return 0;
        case 3: 
          localo.ndi = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22119);
          return 0;
        case 4: 
          localo.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22119);
          return 0;
        case 5: 
          localo.ndk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(22119);
          return 0;
        case 6: 
          localo.ndb = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(22119);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localo.nde = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22119);
          return 0;
        }
        localo.ndg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(22119);
        return 0;
      }
      AppMethodBeat.o(22119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */