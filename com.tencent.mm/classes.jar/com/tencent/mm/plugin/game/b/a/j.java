package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class j
  extends dop
{
  public int errorCode;
  public String oTJ;
  public int oTW;
  public String oUj;
  public String xuB;
  public String xuC;
  public String xuk;
  public String xun;
  public String xuo;
  public String xup;
  public String xuq;
  public String xur;
  public int xus;
  public String xuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204105);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xuk != null) {
        paramVarArgs.e(2, this.xuk);
      }
      paramVarArgs.aM(3, this.xus);
      paramVarArgs.aM(4, this.oTW);
      if (this.xuz != null) {
        paramVarArgs.e(5, this.xuz);
      }
      if (this.xuB != null) {
        paramVarArgs.e(6, this.xuB);
      }
      if (this.xuC != null) {
        paramVarArgs.e(7, this.xuC);
      }
      paramVarArgs.aM(8, this.errorCode);
      if (this.xup != null) {
        paramVarArgs.e(9, this.xup);
      }
      if (this.xuo != null) {
        paramVarArgs.e(10, this.xuo);
      }
      if (this.xun != null) {
        paramVarArgs.e(11, this.xun);
      }
      if (this.xuq != null) {
        paramVarArgs.e(12, this.xuq);
      }
      if (this.xur != null) {
        paramVarArgs.e(13, this.xur);
      }
      if (this.oTJ != null) {
        paramVarArgs.e(14, this.oTJ);
      }
      if (this.oUj != null) {
        paramVarArgs.e(15, this.oUj);
      }
      AppMethodBeat.o(204105);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1122;
      }
    }
    label1122:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xuk != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xuk);
      }
      i = i + g.a.a.b.b.a.bu(3, this.xus) + g.a.a.b.b.a.bu(4, this.oTW);
      paramInt = i;
      if (this.xuz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xuz);
      }
      i = paramInt;
      if (this.xuB != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.xuB);
      }
      paramInt = i;
      if (this.xuC != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xuC);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.errorCode);
      paramInt = i;
      if (this.xup != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.xup);
      }
      i = paramInt;
      if (this.xuo != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.xuo);
      }
      paramInt = i;
      if (this.xun != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.xun);
      }
      i = paramInt;
      if (this.xuq != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.xuq);
      }
      paramInt = i;
      if (this.xur != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.xur);
      }
      i = paramInt;
      if (this.oTJ != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.oTJ);
      }
      paramInt = i;
      if (this.oUj != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.oUj);
      }
      AppMethodBeat.o(204105);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(204105);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204105);
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
            localj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(204105);
          return 0;
        case 2: 
          localj.xuk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 3: 
          localj.xus = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(204105);
          return 0;
        case 4: 
          localj.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(204105);
          return 0;
        case 5: 
          localj.xuz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 6: 
          localj.xuB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 7: 
          localj.xuC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 8: 
          localj.errorCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(204105);
          return 0;
        case 9: 
          localj.xup = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 10: 
          localj.xuo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 11: 
          localj.xun = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 12: 
          localj.xuq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 13: 
          localj.xur = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        case 14: 
          localj.oTJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204105);
          return 0;
        }
        localj.oUj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(204105);
        return 0;
      }
      AppMethodBeat.o(204105);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.j
 * JD-Core Version:    0.7.0.1
 */