package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class bi
  extends dop
{
  public int Scene;
  public String keh;
  public String xLl;
  public int xLm;
  public f xLn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(149415);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xLl != null) {
        paramVarArgs.e(2, this.xLl);
      }
      if (this.keh != null) {
        paramVarArgs.e(3, this.keh);
      }
      paramVarArgs.aM(4, this.xLm);
      if (this.xLn != null)
      {
        paramVarArgs.ni(5, this.xLn.computeSize());
        this.xLn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.Scene);
      AppMethodBeat.o(149415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xLl);
      }
      i = paramInt;
      if (this.keh != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.keh);
      }
      i += g.a.a.b.b.a.bu(4, this.xLm);
      paramInt = i;
      if (this.xLn != null) {
        paramInt = i + g.a.a.a.nh(5, this.xLn.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.Scene);
      AppMethodBeat.o(149415);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xLl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(149415);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(149415);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbi.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        case 2: 
          localbi.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 3: 
          localbi.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 4: 
          localbi.xLm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(149415);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbi.xLn = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        }
        localbi.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(149415);
        return 0;
      }
      AppMethodBeat.o(149415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bi
 * JD-Core Version:    0.7.0.1
 */