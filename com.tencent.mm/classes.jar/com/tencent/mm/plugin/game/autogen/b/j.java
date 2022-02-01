package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class j
  extends erp
{
  public int IcB;
  public String IdA;
  public LinkedList<i> Idy;
  public String Idz;
  
  public j()
  {
    AppMethodBeat.i(40876);
    this.Idy = new LinkedList();
    AppMethodBeat.o(40876);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40877);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IcB);
      paramVarArgs.e(3, 8, this.Idy);
      if (this.Idz != null) {
        paramVarArgs.g(4, this.Idz);
      }
      if (this.IdA != null) {
        paramVarArgs.g(5, this.IdA);
      }
      AppMethodBeat.o(40877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IcB) + i.a.a.a.c(3, 8, this.Idy);
      paramInt = i;
      if (this.Idz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Idz);
      }
      i = paramInt;
      if (this.IdA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IdA);
      }
      AppMethodBeat.o(40877);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Idy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(40877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40877);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 2: 
          localj.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(40877);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new i();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((i)localObject2).parseFrom((byte[])localObject1);
            }
            localj.Idy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(40877);
          return 0;
        case 4: 
          localj.Idz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(40877);
          return 0;
        }
        localj.IdA = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(40877);
        return 0;
      }
      AppMethodBeat.o(40877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.j
 * JD-Core Version:    0.7.0.1
 */