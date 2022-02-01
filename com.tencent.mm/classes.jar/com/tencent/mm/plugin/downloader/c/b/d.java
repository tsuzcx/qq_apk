package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String dlB;
  public String odn;
  public String odo;
  public String odp;
  public int odq;
  public h odr;
  public String ods;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153062);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.odn == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_name");
        AppMethodBeat.o(153062);
        throw paramVarArgs;
      }
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.odn != null) {
        paramVarArgs.d(2, this.odn);
      }
      if (this.odo != null) {
        paramVarArgs.d(3, this.odo);
      }
      if (this.odp != null) {
        paramVarArgs.d(4, this.odp);
      }
      paramVarArgs.aR(5, this.odq);
      paramVarArgs.aR(6, this.status);
      if (this.odr != null)
      {
        paramVarArgs.kX(7, this.odr.computeSize());
        this.odr.writeFields(paramVarArgs);
      }
      if (this.ods != null) {
        paramVarArgs.d(8, this.ods);
      }
      AppMethodBeat.o(153062);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.dlB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.odn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.odn);
      }
      i = paramInt;
      if (this.odo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.odo);
      }
      paramInt = i;
      if (this.odp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.odp);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.odq) + f.a.a.b.b.a.bA(6, this.status);
      paramInt = i;
      if (this.odr != null) {
        paramInt = i + f.a.a.a.kW(7, this.odr.computeSize());
      }
      i = paramInt;
      if (this.ods != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ods);
      }
      AppMethodBeat.o(153062);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.dlB == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        if (this.odn == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_name");
          AppMethodBeat.o(153062);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153062);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153062);
          return -1;
        case 1: 
          locald.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 2: 
          locald.odn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 3: 
          locald.odo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 4: 
          locald.odp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153062);
          return 0;
        case 5: 
          locald.odq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153062);
          return 0;
        case 6: 
          locald.status = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153062);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.odr = ((h)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153062);
          return 0;
        }
        locald.ods = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153062);
        return 0;
      }
      AppMethodBeat.o(153062);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.d
 * JD-Core Version:    0.7.0.1
 */