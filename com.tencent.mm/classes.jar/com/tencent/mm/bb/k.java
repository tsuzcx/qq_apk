package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public String appId;
  public String brandName;
  public String jgX;
  public String jgY;
  public String jgZ;
  public String jha;
  public String jhb;
  public String jhc;
  public String jhd;
  public String jhe;
  public String jhf;
  public String jhg;
  public String jhh;
  public String jhi;
  public String jhj;
  public String jhk;
  public String jhl;
  public l jhm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.jgX != null) {
        paramVarArgs.e(2, this.jgX);
      }
      if (this.jgY != null) {
        paramVarArgs.e(3, this.jgY);
      }
      if (this.jgZ != null) {
        paramVarArgs.e(4, this.jgZ);
      }
      if (this.jha != null) {
        paramVarArgs.e(5, this.jha);
      }
      if (this.jhb != null) {
        paramVarArgs.e(6, this.jhb);
      }
      if (this.brandName != null) {
        paramVarArgs.e(7, this.brandName);
      }
      if (this.jhc != null) {
        paramVarArgs.e(8, this.jhc);
      }
      if (this.jhd != null) {
        paramVarArgs.e(9, this.jhd);
      }
      if (this.jhe != null) {
        paramVarArgs.e(10, this.jhe);
      }
      if (this.jhf != null) {
        paramVarArgs.e(11, this.jhf);
      }
      if (this.jhg != null) {
        paramVarArgs.e(12, this.jhg);
      }
      if (this.jhh != null) {
        paramVarArgs.e(13, this.jhh);
      }
      if (this.jhi != null) {
        paramVarArgs.e(14, this.jhi);
      }
      if (this.jhj != null) {
        paramVarArgs.e(16, this.jhj);
      }
      if (this.jhk != null) {
        paramVarArgs.e(17, this.jhk);
      }
      if (this.jhl != null) {
        paramVarArgs.e(18, this.jhl);
      }
      if (this.jhm != null)
      {
        paramVarArgs.ni(19, this.jhm.computeSize());
        this.jhm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(150806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label1362;
      }
    }
    label1362:
    for (int i = g.a.a.b.b.a.f(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jgX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jgX);
      }
      i = paramInt;
      if (this.jgY != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jgY);
      }
      paramInt = i;
      if (this.jgZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.jgZ);
      }
      i = paramInt;
      if (this.jha != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.jha);
      }
      paramInt = i;
      if (this.jhb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.jhb);
      }
      i = paramInt;
      if (this.brandName != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.brandName);
      }
      paramInt = i;
      if (this.jhc != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.jhc);
      }
      i = paramInt;
      if (this.jhd != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.jhd);
      }
      paramInt = i;
      if (this.jhe != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.jhe);
      }
      i = paramInt;
      if (this.jhf != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.jhf);
      }
      paramInt = i;
      if (this.jhg != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.jhg);
      }
      i = paramInt;
      if (this.jhh != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.jhh);
      }
      paramInt = i;
      if (this.jhi != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.jhi);
      }
      i = paramInt;
      if (this.jhj != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.jhj);
      }
      paramInt = i;
      if (this.jhk != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.jhk);
      }
      i = paramInt;
      if (this.jhl != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.jhl);
      }
      paramInt = i;
      if (this.jhm != null) {
        paramInt = i + g.a.a.a.nh(19, this.jhm.computeSize());
      }
      AppMethodBeat.o(150806);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(150806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        default: 
          AppMethodBeat.o(150806);
          return -1;
        case 1: 
          localk.appId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          localk.jgX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          localk.jgY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          localk.jgZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          localk.jha = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          localk.jhb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          localk.brandName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          localk.jhc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          localk.jhd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          localk.jhe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          localk.jhf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          localk.jhg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 13: 
          localk.jhh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 14: 
          localk.jhi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 16: 
          localk.jhj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 17: 
          localk.jhk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 18: 
          localk.jhl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(150806);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localk.jhm = ((l)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bb.k
 * JD-Core Version:    0.7.0.1
 */