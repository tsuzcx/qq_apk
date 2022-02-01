package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dr
  extends com.tencent.mm.bx.a
{
  public String IKC;
  public String IKD;
  public String ILA;
  public LinkedList<ds> ILy;
  public String ILz;
  public String hAP;
  
  public dr()
  {
    AppMethodBeat.i(41826);
    this.ILy = new LinkedList();
    AppMethodBeat.o(41826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41827);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41827);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.ILy);
      if (this.IKC != null) {
        paramVarArgs.g(3, this.IKC);
      }
      if (this.IKD != null) {
        paramVarArgs.g(4, this.IKD);
      }
      if (this.ILz != null) {
        paramVarArgs.g(5, this.ILz);
      }
      if (this.ILA != null) {
        paramVarArgs.g(6, this.ILA);
      }
      AppMethodBeat.o(41827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ILy);
      paramInt = i;
      if (this.IKC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IKC);
      }
      i = paramInt;
      if (this.IKD != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IKD);
      }
      paramInt = i;
      if (this.ILz != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ILz);
      }
      i = paramInt;
      if (this.ILA != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ILA);
      }
      AppMethodBeat.o(41827);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ILy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41827);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41827);
          return -1;
        case 1: 
          localdr.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ds localds = new ds();
            if ((localObject != null) && (localObject.length > 0)) {
              localds.parseFrom((byte[])localObject);
            }
            localdr.ILy.add(localds);
            paramInt += 1;
          }
          AppMethodBeat.o(41827);
          return 0;
        case 3: 
          localdr.IKC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 4: 
          localdr.IKD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41827);
          return 0;
        case 5: 
          localdr.ILz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41827);
          return 0;
        }
        localdr.ILA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41827);
        return 0;
      }
      AppMethodBeat.o(41827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */