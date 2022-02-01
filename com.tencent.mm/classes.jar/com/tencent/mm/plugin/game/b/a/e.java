package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class e
  extends dop
{
  public String jfi;
  public String oTJ;
  public String oUj;
  public String xuk;
  public String xun;
  public String xuo;
  public String xup;
  public String xuq;
  public String xur;
  public int xus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204101);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oTJ != null) {
        paramVarArgs.e(2, this.oTJ);
      }
      if (this.oUj != null) {
        paramVarArgs.e(3, this.oUj);
      }
      if (this.xun != null) {
        paramVarArgs.e(4, this.xun);
      }
      if (this.xuo != null) {
        paramVarArgs.e(5, this.xuo);
      }
      if (this.xup != null) {
        paramVarArgs.e(6, this.xup);
      }
      if (this.xuk != null) {
        paramVarArgs.e(7, this.xuk);
      }
      if (this.jfi != null) {
        paramVarArgs.e(8, this.jfi);
      }
      if (this.xuq != null) {
        paramVarArgs.e(9, this.xuq);
      }
      if (this.xur != null) {
        paramVarArgs.e(10, this.xur);
      }
      paramVarArgs.aM(11, this.xus);
      AppMethodBeat.o(204101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oTJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oTJ);
      }
      i = paramInt;
      if (this.oUj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUj);
      }
      paramInt = i;
      if (this.xun != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xun);
      }
      i = paramInt;
      if (this.xuo != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xuo);
      }
      paramInt = i;
      if (this.xup != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xup);
      }
      i = paramInt;
      if (this.xuk != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.xuk);
      }
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.jfi);
      }
      i = paramInt;
      if (this.xuq != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xuq);
      }
      paramInt = i;
      if (this.xur != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.xur);
      }
      i = g.a.a.b.b.a.bu(11, this.xus);
      AppMethodBeat.o(204101);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(204101);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204101);
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
            locale.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(204101);
          return 0;
        case 2: 
          locale.oTJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 3: 
          locale.oUj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 4: 
          locale.xun = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 5: 
          locale.xuo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 6: 
          locale.xup = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 7: 
          locale.xuk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 8: 
          locale.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 9: 
          locale.xuq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        case 10: 
          locale.xur = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(204101);
          return 0;
        }
        locale.xus = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(204101);
        return 0;
      }
      AppMethodBeat.o(204101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.e
 * JD-Core Version:    0.7.0.1
 */