package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public String ovm;
  public String session_id;
  public a uxn;
  public l uxv;
  public String uxw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211170);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.session_id != null) {
        paramVarArgs.d(1, this.session_id);
      }
      if (this.uxv != null)
      {
        paramVarArgs.lC(2, this.uxv.computeSize());
        this.uxv.writeFields(paramVarArgs);
      }
      if (this.uxw != null) {
        paramVarArgs.d(3, this.uxw);
      }
      if (this.ovm != null) {
        paramVarArgs.d(4, this.ovm);
      }
      if (this.uxn != null)
      {
        paramVarArgs.lC(5, this.uxn.computeSize());
        this.uxn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(211170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.session_id == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.b.b.a.e(1, this.session_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uxv != null) {
        paramInt = i + f.a.a.a.lB(2, this.uxv.computeSize());
      }
      i = paramInt;
      if (this.uxw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uxw);
      }
      paramInt = i;
      if (this.ovm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ovm);
      }
      i = paramInt;
      if (this.uxn != null) {
        i = paramInt + f.a.a.a.lB(5, this.uxn.computeSize());
      }
      AppMethodBeat.o(211170);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211170);
          return -1;
        case 1: 
          localm.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211170);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.uxv = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211170);
          return 0;
        case 3: 
          localm.uxw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211170);
          return 0;
        case 4: 
          localm.ovm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211170);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localm.uxn = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(211170);
        return 0;
      }
      AppMethodBeat.o(211170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.m
 * JD-Core Version:    0.7.0.1
 */