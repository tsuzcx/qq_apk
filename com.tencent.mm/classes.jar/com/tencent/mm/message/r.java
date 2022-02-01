package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class r
  extends com.tencent.mm.bx.a
{
  public String iaa;
  public String iab;
  public String kLg;
  public LinkedList<v> nUC;
  public int nUD;
  public String name;
  public int type;
  
  public r()
  {
    AppMethodBeat.i(116413);
    this.nUC = new LinkedList();
    AppMethodBeat.o(116413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116414);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.iaa != null) {
        paramVarArgs.g(3, this.iaa);
      }
      if (this.iab != null) {
        paramVarArgs.g(4, this.iab);
      }
      if (this.kLg != null) {
        paramVarArgs.g(5, this.kLg);
      }
      paramVarArgs.e(6, 8, this.nUC);
      paramVarArgs.bS(7, this.nUD);
      AppMethodBeat.o(116414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.iaa != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.iaa);
      }
      paramInt = i;
      if (this.iab != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.iab);
      }
      i = paramInt;
      if (this.kLg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.kLg);
      }
      paramInt = i.a.a.a.c(6, 8, this.nUC);
      int j = i.a.a.b.b.a.cJ(7, this.nUD);
      AppMethodBeat.o(116414);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nUC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(116414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116414);
        return -1;
      case 1: 
        localr.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(116414);
        return 0;
      case 2: 
        localr.name = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 3: 
        localr.iaa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 4: 
        localr.iab = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 5: 
        localr.kLg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116414);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          v localv = new v();
          if ((localObject != null) && (localObject.length > 0)) {
            localv.parseFrom((byte[])localObject);
          }
          localr.nUC.add(localv);
          paramInt += 1;
        }
        AppMethodBeat.o(116414);
        return 0;
      }
      localr.nUD = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(116414);
      return 0;
    }
    AppMethodBeat.o(116414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.message.r
 * JD-Core Version:    0.7.0.1
 */