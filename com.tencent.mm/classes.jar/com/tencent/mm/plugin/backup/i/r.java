package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bx.a
{
  public String vgy;
  public LinkedList<t> vhA;
  public LinkedList<t> vhB;
  public long vhj;
  public int vhm;
  public int vhn;
  public int vho;
  public long vhp;
  public long vhq;
  
  public r()
  {
    AppMethodBeat.i(22122);
    this.vhA = new LinkedList();
    this.vhB = new LinkedList();
    AppMethodBeat.o(22122);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22123);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22123);
        throw paramVarArgs;
      }
      if (this.vgy != null) {
        paramVarArgs.g(1, this.vgy);
      }
      paramVarArgs.bS(2, this.vhm);
      paramVarArgs.bS(3, this.vhn);
      paramVarArgs.bS(4, this.vho);
      paramVarArgs.bv(5, this.vhj);
      paramVarArgs.bv(6, this.vhp);
      paramVarArgs.bv(7, this.vhq);
      paramVarArgs.e(8, 8, this.vhA);
      paramVarArgs.e(9, 8, this.vhB);
      AppMethodBeat.o(22123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgy == null) {
        break label801;
      }
    }
    label801:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgy) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhm);
      int j = i.a.a.b.b.a.cJ(3, this.vhn);
      int k = i.a.a.b.b.a.cJ(4, this.vho);
      int m = i.a.a.b.b.a.q(5, this.vhj);
      int n = i.a.a.b.b.a.q(6, this.vhp);
      int i1 = i.a.a.b.b.a.q(7, this.vhq);
      int i2 = i.a.a.a.c(8, 8, this.vhA);
      int i3 = i.a.a.a.c(9, 8, this.vhB);
      AppMethodBeat.o(22123);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vhA.clear();
        this.vhB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgy == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        t localt;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(22123);
          return -1;
        case 1: 
          localr.vgy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(22123);
          return 0;
        case 2: 
          localr.vhm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22123);
          return 0;
        case 3: 
          localr.vhn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22123);
          return 0;
        case 4: 
          localr.vho = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(22123);
          return 0;
        case 5: 
          localr.vhj = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22123);
          return 0;
        case 6: 
          localr.vhp = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22123);
          return 0;
        case 7: 
          localr.vhq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(22123);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localt = new t();
            if ((localObject != null) && (localObject.length > 0)) {
              localt.parseFrom((byte[])localObject);
            }
            localr.vhA.add(localt);
            paramInt += 1;
          }
          AppMethodBeat.o(22123);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localt = new t();
          if ((localObject != null) && (localObject.length > 0)) {
            localt.parseFrom((byte[])localObject);
          }
          localr.vhB.add(localt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */