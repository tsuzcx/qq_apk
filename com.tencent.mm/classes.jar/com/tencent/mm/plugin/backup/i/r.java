package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long mBh;
  public int mBk;
  public int mBl;
  public int mBm;
  public long mBn;
  public long mBo;
  public LinkedList<t> mBy;
  public LinkedList<t> mBz;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.mBy = new LinkedList();
    this.mBz = new LinkedList();
    AppMethodBeat.o(22122);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22123);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aR(2, this.mBk);
      paramVarArgs.aR(3, this.mBl);
      paramVarArgs.aR(4, this.mBm);
      paramVarArgs.aG(5, this.mBh);
      paramVarArgs.aG(6, this.mBn);
      paramVarArgs.aG(7, this.mBo);
      paramVarArgs.e(8, 8, this.mBy);
      paramVarArgs.e(9, 8, this.mBz);
      AppMethodBeat.o(22123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label849;
      }
    }
    label849:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.mBk);
      int j = f.a.a.b.b.a.bA(3, this.mBl);
      int k = f.a.a.b.b.a.bA(4, this.mBm);
      int m = f.a.a.b.b.a.q(5, this.mBh);
      int n = f.a.a.b.b.a.q(6, this.mBn);
      int i1 = f.a.a.b.b.a.q(7, this.mBo);
      int i2 = f.a.a.a.c(8, 8, this.mBy);
      int i3 = f.a.a.a.c(9, 8, this.mBz);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mBy.clear();
        this.mBz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22123);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22123);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22123);
          return -1;
        case 1: 
          localr.ID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.mBk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.mBl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.mBm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.mBh = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.mBn = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.mBo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localr.mBy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localr.mBz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22123);
        return 0;
      }
      AppMethodBeat.o(22123);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */