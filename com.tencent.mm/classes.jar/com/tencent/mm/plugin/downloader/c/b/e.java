package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String odt;
  public LinkedList<String> odu;
  public String odv;
  public String odw;
  public LinkedList<String> odx;
  public n ody;
  public f odz;
  
  public e()
  {
    AppMethodBeat.i(153063);
    this.odu = new LinkedList();
    this.odx = new LinkedList();
    AppMethodBeat.o(153063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.odt != null) {
        paramVarArgs.d(1, this.odt);
      }
      paramVarArgs.e(2, 1, this.odu);
      if (this.odv != null) {
        paramVarArgs.d(3, this.odv);
      }
      if (this.odw != null) {
        paramVarArgs.d(4, this.odw);
      }
      paramVarArgs.e(5, 1, this.odx);
      if (this.ody != null)
      {
        paramVarArgs.kX(6, this.ody.computeSize());
        this.ody.writeFields(paramVarArgs);
      }
      if (this.odz != null)
      {
        paramVarArgs.kX(7, this.odz.computeSize());
        this.odz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.odt == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.b.b.a.e(1, this.odt) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.odu);
      paramInt = i;
      if (this.odv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.odv);
      }
      i = paramInt;
      if (this.odw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.odw);
      }
      i += f.a.a.a.c(5, 1, this.odx);
      paramInt = i;
      if (this.ody != null) {
        paramInt = i + f.a.a.a.kW(6, this.ody.computeSize());
      }
      i = paramInt;
      if (this.odz != null) {
        i = paramInt + f.a.a.a.kW(7, this.odz.computeSize());
      }
      AppMethodBeat.o(153064);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.odu.clear();
        this.odx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153064);
          return -1;
        case 1: 
          locale.odt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 2: 
          locale.odu.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 3: 
          locale.odv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 4: 
          locale.odw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153064);
          return 0;
        case 5: 
          locale.odx.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(153064);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locale.ody = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153064);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.odz = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153064);
        return 0;
      }
      AppMethodBeat.o(153064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.e
 * JD-Core Version:    0.7.0.1
 */