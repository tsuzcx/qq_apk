package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public String dub;
  public r ocZ;
  public r oda;
  public String odb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153059);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dub != null) {
        paramVarArgs.d(1, this.dub);
      }
      if (this.ocZ != null)
      {
        paramVarArgs.kX(2, this.ocZ.computeSize());
        this.ocZ.writeFields(paramVarArgs);
      }
      if (this.oda != null)
      {
        paramVarArgs.kX(3, this.oda.computeSize());
        this.oda.writeFields(paramVarArgs);
      }
      if (this.odb != null) {
        paramVarArgs.d(4, this.odb);
      }
      AppMethodBeat.o(153059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dub == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.dub) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ocZ != null) {
        paramInt = i + f.a.a.a.kW(2, this.ocZ.computeSize());
      }
      i = paramInt;
      if (this.oda != null) {
        i = paramInt + f.a.a.a.kW(3, this.oda.computeSize());
      }
      paramInt = i;
      if (this.odb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.odb);
      }
      AppMethodBeat.o(153059);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153059);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153059);
          return -1;
        case 1: 
          localb.dub = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153059);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.ocZ = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new r();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.oda = ((r)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153059);
          return 0;
        }
        localb.odb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153059);
        return 0;
      }
      AppMethodBeat.o(153059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.b
 * JD-Core Version:    0.7.0.1
 */