package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cg
  extends com.tencent.mm.bx.a
{
  public LinkedList<ch> IKB;
  public String IKC;
  public String IKD;
  public String hAP;
  
  public cg()
  {
    AppMethodBeat.i(41789);
    this.IKB = new LinkedList();
    AppMethodBeat.o(41789);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41790);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41790);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.IKB);
      if (this.IKC != null) {
        paramVarArgs.g(3, this.IKC);
      }
      if (this.IKD != null) {
        paramVarArgs.g(4, this.IKD);
      }
      AppMethodBeat.o(41790);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.IKB);
      paramInt = i;
      if (this.IKC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IKC);
      }
      i = paramInt;
      if (this.IKD != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IKD);
      }
      AppMethodBeat.o(41790);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IKB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41790);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41790);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41790);
          return -1;
        case 1: 
          localcg.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41790);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ch localch = new ch();
            if ((localObject != null) && (localObject.length > 0)) {
              localch.parseFrom((byte[])localObject);
            }
            localcg.IKB.add(localch);
            paramInt += 1;
          }
          AppMethodBeat.o(41790);
          return 0;
        case 3: 
          localcg.IKC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(41790);
          return 0;
        }
        localcg.IKD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41790);
        return 0;
      }
      AppMethodBeat.o(41790);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */