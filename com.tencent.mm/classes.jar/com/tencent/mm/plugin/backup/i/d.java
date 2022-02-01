package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String ID;
  public h oTn;
  public int oTo;
  public int oTp;
  public int oTq;
  public int oTr;
  public int oTs;
  public int oTt;
  public int oTu;
  public int oTv;
  public int oTw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22104);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      if (this.oTn != null)
      {
        paramVarArgs.ni(2, this.oTn.computeSize());
        this.oTn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.oTo);
      paramVarArgs.aM(4, this.oTp);
      paramVarArgs.aM(5, this.oTq);
      paramVarArgs.aM(6, this.oTr);
      paramVarArgs.aM(7, this.oTs);
      paramVarArgs.aM(8, this.oTt);
      paramVarArgs.aM(9, this.oTu);
      paramVarArgs.aM(10, this.oTv);
      paramVarArgs.aM(11, this.oTw);
      AppMethodBeat.o(22104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label863;
      }
    }
    label863:
    for (paramInt = g.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oTn != null) {
        i = paramInt + g.a.a.a.nh(2, this.oTn.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.oTo);
      int j = g.a.a.b.b.a.bu(4, this.oTp);
      int k = g.a.a.b.b.a.bu(5, this.oTq);
      int m = g.a.a.b.b.a.bu(6, this.oTr);
      int n = g.a.a.b.b.a.bu(7, this.oTs);
      int i1 = g.a.a.b.b.a.bu(8, this.oTt);
      int i2 = g.a.a.b.b.a.bu(9, this.oTu);
      int i3 = g.a.a.b.b.a.bu(10, this.oTv);
      int i4 = g.a.a.b.b.a.bu(11, this.oTw);
      AppMethodBeat.o(22104);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22104);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22104);
          return -1;
        case 1: 
          locald.ID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(22104);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locald.oTn = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22104);
          return 0;
        case 3: 
          locald.oTo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 4: 
          locald.oTp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 5: 
          locald.oTq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 6: 
          locald.oTr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 7: 
          locald.oTs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 8: 
          locald.oTt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 9: 
          locald.oTu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        case 10: 
          locald.oTv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(22104);
          return 0;
        }
        locald.oTw = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(22104);
        return 0;
      }
      AppMethodBeat.o(22104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */