package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import java.util.LinkedList;

public final class bv
  extends dop
{
  public String keh;
  public LinkedList<String> xLF;
  public int xLV;
  public int xLW;
  public int xLX;
  public boolean xLY;
  public String xLl;
  
  public bv()
  {
    AppMethodBeat.i(41777);
    this.xLF = new LinkedList();
    AppMethodBeat.o(41777);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41778);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xLl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(41778);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xLV);
      paramVarArgs.aM(3, this.xLW);
      if (this.xLl != null) {
        paramVarArgs.e(4, this.xLl);
      }
      paramVarArgs.e(5, 1, this.xLF);
      if (this.keh != null) {
        paramVarArgs.e(6, this.keh);
      }
      paramVarArgs.aM(7, this.xLX);
      paramVarArgs.cc(8, this.xLY);
      AppMethodBeat.o(41778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xLV) + g.a.a.b.b.a.bu(3, this.xLW);
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xLl);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.xLF);
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.keh);
      }
      i = g.a.a.b.b.a.bu(7, this.xLX);
      int j = g.a.a.b.b.a.fS(8);
      AppMethodBeat.o(41778);
      return paramInt + i + (j + 1);
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
          AppMethodBeat.o(41778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41778);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41778);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41778);
          return 0;
        case 2: 
          localbv.xLV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41778);
          return 0;
        case 3: 
          localbv.xLW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41778);
          return 0;
        case 4: 
          localbv.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 5: 
          localbv.xLF.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(41778);
          return 0;
        case 6: 
          localbv.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41778);
          return 0;
        case 7: 
          localbv.xLX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41778);
          return 0;
        }
        localbv.xLY = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(41778);
        return 0;
      }
      AppMethodBeat.o(41778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bv
 * JD-Core Version:    0.7.0.1
 */