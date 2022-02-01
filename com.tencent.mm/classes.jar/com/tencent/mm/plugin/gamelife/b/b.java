package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int fuA;
  public String nickname;
  public String tag;
  public String uNR;
  public String username;
  public l yaZ;
  public int yba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225885);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: username");
        AppMethodBeat.o(225885);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.uNR != null) {
        paramVarArgs.e(3, this.uNR);
      }
      paramVarArgs.aM(4, this.fuA);
      if (this.tag != null) {
        paramVarArgs.e(5, this.tag);
      }
      if (this.yaZ != null)
      {
        paramVarArgs.ni(6, this.yaZ.computeSize());
        this.yaZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.yba);
      AppMethodBeat.o(225885);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label690;
      }
    }
    label690:
    for (int i = g.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.uNR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.uNR);
      }
      i += g.a.a.b.b.a.bu(4, this.fuA);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.tag);
      }
      i = paramInt;
      if (this.yaZ != null) {
        i = paramInt + g.a.a.a.nh(6, this.yaZ.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(7, this.yba);
      AppMethodBeat.o(225885);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: username");
          AppMethodBeat.o(225885);
          throw paramVarArgs;
        }
        AppMethodBeat.o(225885);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225885);
          return -1;
        case 1: 
          localb.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225885);
          return 0;
        case 2: 
          localb.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225885);
          return 0;
        case 3: 
          localb.uNR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225885);
          return 0;
        case 4: 
          localb.fuA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(225885);
          return 0;
        case 5: 
          localb.tag = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(225885);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.yaZ = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225885);
          return 0;
        }
        localb.yba = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(225885);
        return 0;
      }
      AppMethodBeat.o(225885);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.b
 * JD-Core Version:    0.7.0.1
 */