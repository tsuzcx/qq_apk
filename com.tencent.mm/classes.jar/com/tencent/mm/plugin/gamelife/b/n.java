package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public String oBN;
  public String session_id;
  public a uIP;
  public m uIY;
  public String uIZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.session_id != null) {
        paramVarArgs.d(1, this.session_id);
      }
      if (this.uIY != null)
      {
        paramVarArgs.lJ(2, this.uIY.computeSize());
        this.uIY.writeFields(paramVarArgs);
      }
      if (this.uIZ != null) {
        paramVarArgs.d(3, this.uIZ);
      }
      if (this.oBN != null) {
        paramVarArgs.d(4, this.oBN);
      }
      if (this.uIP != null)
      {
        paramVarArgs.lJ(5, this.uIP.computeSize());
        this.uIP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(218213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.session_id == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.b.b.a.e(1, this.session_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uIY != null) {
        paramInt = i + f.a.a.a.lI(2, this.uIY.computeSize());
      }
      i = paramInt;
      if (this.uIZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uIZ);
      }
      paramInt = i;
      if (this.oBN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oBN);
      }
      i = paramInt;
      if (this.uIP != null) {
        i = paramInt + f.a.a.a.lI(5, this.uIP.computeSize());
      }
      AppMethodBeat.o(218213);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218213);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218213);
          return -1;
        case 1: 
          localn.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218213);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.uIY = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218213);
          return 0;
        case 3: 
          localn.uIZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218213);
          return 0;
        case 4: 
          localn.oBN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218213);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localn.uIP = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(218213);
        return 0;
      }
      AppMethodBeat.o(218213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.n
 * JD-Core Version:    0.7.0.1
 */