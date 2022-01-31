package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public String eds;
  public l kWT;
  public String kWU;
  public long kWo;
  public String kWs;
  public String kWv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35535);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eds == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(35535);
        throw paramVarArgs;
      }
      if (this.eds != null) {
        paramVarArgs.e(1, this.eds);
      }
      paramVarArgs.am(2, this.kWo);
      if (this.kWT != null)
      {
        paramVarArgs.iQ(3, this.kWT.computeSize());
        this.kWT.writeFields(paramVarArgs);
      }
      if (this.kWU != null) {
        paramVarArgs.e(4, this.kWU);
      }
      if (this.kWv != null) {
        paramVarArgs.e(5, this.kWv);
      }
      if (this.kWs != null) {
        paramVarArgs.e(6, this.kWs);
      }
      AppMethodBeat.o(35535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eds == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = e.a.a.b.b.a.f(1, this.eds) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.kWo);
      paramInt = i;
      if (this.kWT != null) {
        paramInt = i + e.a.a.a.iP(3, this.kWT.computeSize());
      }
      i = paramInt;
      if (this.kWU != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.kWU);
      }
      paramInt = i;
      if (this.kWv != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kWv);
      }
      i = paramInt;
      if (this.kWs != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.kWs);
      }
      AppMethodBeat.o(35535);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.eds == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(35535);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35535);
          return -1;
        case 1: 
          locali.eds = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35535);
          return 0;
        case 2: 
          locali.kWo = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(35535);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locali.kWT = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35535);
          return 0;
        case 4: 
          locali.kWU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35535);
          return 0;
        case 5: 
          locali.kWv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35535);
          return 0;
        }
        locali.kWs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(35535);
        return 0;
      }
      AppMethodBeat.o(35535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.i
 * JD-Core Version:    0.7.0.1
 */