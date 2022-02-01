package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.bx.a
{
  public String ufX;
  public String ufY;
  public String ufZ;
  public ei uga;
  public int ugb;
  public int ugc;
  public String ugd;
  public int uge;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufX == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadURL");
        AppMethodBeat.o(41721);
        throw paramVarArgs;
      }
      if (this.ufX != null) {
        paramVarArgs.d(1, this.ufX);
      }
      if (this.ufY != null) {
        paramVarArgs.d(2, this.ufY);
      }
      if (this.ufZ != null) {
        paramVarArgs.d(4, this.ufZ);
      }
      if (this.uga != null)
      {
        paramVarArgs.lC(5, this.uga.computeSize());
        this.uga.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.ugb);
      paramVarArgs.aS(7, this.ugc);
      if (this.ugd != null) {
        paramVarArgs.d(8, this.ugd);
      }
      paramVarArgs.aS(9, this.uge);
      AppMethodBeat.o(41721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufX == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.b.b.a.e(1, this.ufX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufY);
      }
      i = paramInt;
      if (this.ufZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ufZ);
      }
      paramInt = i;
      if (this.uga != null) {
        paramInt = i + f.a.a.a.lB(5, this.uga.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.ugb) + f.a.a.b.b.a.bz(7, this.ugc);
      paramInt = i;
      if (this.ugd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ugd);
      }
      i = f.a.a.b.b.a.bz(9, this.uge);
      AppMethodBeat.o(41721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ufX == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadURL");
          AppMethodBeat.o(41721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        s locals = (s)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(41721);
          return -1;
        case 1: 
          locals.ufX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 2: 
          locals.ufY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 4: 
          locals.ufZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41721);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ei();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locals.uga = ((ei)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41721);
          return 0;
        case 6: 
          locals.ugb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41721);
          return 0;
        case 7: 
          locals.ugc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41721);
          return 0;
        case 8: 
          locals.ugd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41721);
          return 0;
        }
        locals.uge = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(41721);
        return 0;
      }
      AppMethodBeat.o(41721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.s
 * JD-Core Version:    0.7.0.1
 */