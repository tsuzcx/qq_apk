package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class bt
  extends dop
{
  public String keh;
  public LinkedList<String> xLF;
  public ac xLG;
  public int xLH;
  public boolean xLI;
  public String xLl;
  public int xLm;
  
  public bt()
  {
    AppMethodBeat.i(41774);
    this.xLF = new LinkedList();
    AppMethodBeat.o(41774);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41775);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41775);
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
      paramVarArgs.e(3, 1, this.xLF);
      if (this.keh != null) {
        paramVarArgs.e(4, this.keh);
      }
      if (this.xLG != null)
      {
        paramVarArgs.ni(5, this.xLG.computeSize());
        this.xLG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.xLH);
      paramVarArgs.cc(7, this.xLI);
      paramVarArgs.aM(8, this.xLm);
      AppMethodBeat.o(41775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xLl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xLl);
      }
      i += g.a.a.a.c(3, 1, this.xLF);
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.keh);
      }
      i = paramInt;
      if (this.xLG != null) {
        i = paramInt + g.a.a.a.nh(5, this.xLG.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(6, this.xLH);
      int j = g.a.a.b.b.a.fS(7);
      int k = g.a.a.b.b.a.bu(8, this.xLm);
      AppMethodBeat.o(41775);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xLl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(41775);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41775);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bt localbt = (bt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41775);
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
            localbt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41775);
          return 0;
        case 2: 
          localbt.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41775);
          return 0;
        case 3: 
          localbt.xLF.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(41775);
          return 0;
        case 4: 
          localbt.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41775);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ac();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ac)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbt.xLG = ((ac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41775);
          return 0;
        case 6: 
          localbt.xLH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41775);
          return 0;
        case 7: 
          localbt.xLI = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41775);
          return 0;
        }
        localbt.xLm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(41775);
        return 0;
      }
      AppMethodBeat.o(41775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bt
 * JD-Core Version:    0.7.0.1
 */