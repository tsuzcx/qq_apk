package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dk
  extends com.tencent.mm.bx.a
{
  public String IKD;
  public LinkedList<dl> ILs;
  public String ILt;
  
  public dk()
  {
    AppMethodBeat.i(41819);
    this.ILs = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ILs);
      if (this.IKD != null) {
        paramVarArgs.g(2, this.IKD);
      }
      if (this.ILt != null) {
        paramVarArgs.g(3, this.ILt);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ILs) + 0;
      paramInt = i;
      if (this.IKD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IKD);
      }
      i = paramInt;
      if (this.ILt != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ILt);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ILs.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dk localdk = (dk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41820);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dl localdl = new dl();
          if ((localObject != null) && (localObject.length > 0)) {
            localdl.parseFrom((byte[])localObject);
          }
          localdk.ILs.add(localdl);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localdk.IKD = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localdk.ILt = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dk
 * JD-Core Version:    0.7.0.1
 */