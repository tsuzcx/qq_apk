package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public int kWA;
  public g kWB;
  public String kWC;
  public String kWx;
  public String kWy;
  public String kWz;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35527);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(35527);
        throw paramVarArgs;
      }
      if (this.kWx == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(35527);
        throw paramVarArgs;
      }
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.kWx != null) {
        paramVarArgs.e(2, this.kWx);
      }
      if (this.kWy != null) {
        paramVarArgs.e(3, this.kWy);
      }
      if (this.kWz != null) {
        paramVarArgs.e(4, this.kWz);
      }
      paramVarArgs.aO(5, this.kWA);
      paramVarArgs.aO(6, this.status);
      if (this.kWB != null)
      {
        paramVarArgs.iQ(7, this.kWB.computeSize());
        this.kWB.writeFields(paramVarArgs);
      }
      if (this.kWC != null) {
        paramVarArgs.e(8, this.kWC);
      }
      AppMethodBeat.o(35527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label798;
      }
    }
    label798:
    for (int i = e.a.a.b.b.a.f(1, this.cwc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kWx);
      }
      i = paramInt;
      if (this.kWy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kWy);
      }
      paramInt = i;
      if (this.kWz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kWz);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.kWA) + e.a.a.b.b.a.bl(6, this.status);
      paramInt = i;
      if (this.kWB != null) {
        paramInt = i + e.a.a.a.iP(7, this.kWB.computeSize());
      }
      i = paramInt;
      if (this.kWC != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.kWC);
      }
      AppMethodBeat.o(35527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.cwc == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(35527);
          throw paramVarArgs;
        }
        if (this.kWx == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_name");
          AppMethodBeat.o(35527);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35527);
          return -1;
        case 1: 
          localc.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35527);
          return 0;
        case 2: 
          localc.kWx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35527);
          return 0;
        case 3: 
          localc.kWy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35527);
          return 0;
        case 4: 
          localc.kWz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35527);
          return 0;
        case 5: 
          localc.kWA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35527);
          return 0;
        case 6: 
          localc.status = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35527);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.kWB = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35527);
          return 0;
        }
        localc.kWC = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(35527);
        return 0;
      }
      AppMethodBeat.o(35527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.c
 * JD-Core Version:    0.7.0.1
 */