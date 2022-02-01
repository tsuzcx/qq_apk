package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cz
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String iht;
  public String ueX;
  public f ueZ;
  public String ugq;
  public String uht;
  public LinkedList<aa> ujw;
  
  public cz()
  {
    AppMethodBeat.i(41823);
    this.ujw = new LinkedList();
    AppMethodBeat.o(41823);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.ueX != null) {
        paramVarArgs.d(3, this.ueX);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.uht != null) {
        paramVarArgs.d(5, this.uht);
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(6, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.ujw);
      if (this.ugq != null) {
        paramVarArgs.d(8, this.ugq);
      }
      AppMethodBeat.o(41824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label818;
      }
    }
    label818:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.ueX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ueX);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.uht != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uht);
      }
      paramInt = i;
      if (this.ueZ != null) {
        paramInt = i + f.a.a.a.lB(6, this.ueZ.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.ujw);
      paramInt = i;
      if (this.ugq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ugq);
      }
      AppMethodBeat.o(41824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ujw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cz localcz = (cz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41824);
          return -1;
        case 1: 
          localcz.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 2: 
          localcz.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 3: 
          localcz.ueX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 4: 
          localcz.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 5: 
          localcz.uht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41824);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcz.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcz.ujw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41824);
          return 0;
        }
        localcz.ugq = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41824);
        return 0;
      }
      AppMethodBeat.o(41824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cz
 * JD-Core Version:    0.7.0.1
 */