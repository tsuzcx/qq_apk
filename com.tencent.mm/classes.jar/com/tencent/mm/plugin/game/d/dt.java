package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dt
  extends com.tencent.mm.bx.a
{
  public String IconUrl;
  public String Title;
  public int nEf;
  public String ueY;
  public String ujW;
  public String ujX;
  public String ujY;
  public String ujZ;
  public String ujy;
  public String uka;
  public String ukb;
  public String ukc;
  public dr ukd;
  public ds uke;
  public boolean ukf;
  public int ukg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ujy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(199590);
        throw paramVarArgs;
      }
      if (this.ujy != null) {
        paramVarArgs.d(1, this.ujy);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ujW != null) {
        paramVarArgs.d(11, this.ujW);
      }
      if (this.ujX != null) {
        paramVarArgs.d(12, this.ujX);
      }
      if (this.ujY != null) {
        paramVarArgs.d(13, this.ujY);
      }
      if (this.ujZ != null) {
        paramVarArgs.d(14, this.ujZ);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(3, this.IconUrl);
      }
      if (this.uka != null) {
        paramVarArgs.d(4, this.uka);
      }
      if (this.ukb != null) {
        paramVarArgs.d(9, this.ukb);
      }
      if (this.ukc != null) {
        paramVarArgs.d(10, this.ukc);
      }
      paramVarArgs.aS(5, this.nEf);
      if (this.ueY != null) {
        paramVarArgs.d(6, this.ueY);
      }
      if (this.ukd != null)
      {
        paramVarArgs.lC(7, this.ukd.computeSize());
        this.ukd.writeFields(paramVarArgs);
      }
      if (this.uke != null)
      {
        paramVarArgs.lC(8, this.uke.computeSize());
        this.uke.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(15, this.ukf);
      paramVarArgs.aS(16, this.ukg);
      AppMethodBeat.o(199590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ujy == null) {
        break label1326;
      }
    }
    label1326:
    for (int i = f.a.a.b.b.a.e(1, this.ujy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ujW != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ujW);
      }
      paramInt = i;
      if (this.ujX != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ujX);
      }
      i = paramInt;
      if (this.ujY != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ujY);
      }
      paramInt = i;
      if (this.ujZ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ujZ);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IconUrl);
      }
      paramInt = i;
      if (this.uka != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uka);
      }
      i = paramInt;
      if (this.ukb != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ukb);
      }
      paramInt = i;
      if (this.ukc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ukc);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nEf);
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ueY);
      }
      i = paramInt;
      if (this.ukd != null) {
        i = paramInt + f.a.a.a.lB(7, this.ukd.computeSize());
      }
      paramInt = i;
      if (this.uke != null) {
        paramInt = i + f.a.a.a.lB(8, this.uke.computeSize());
      }
      i = f.a.a.b.b.a.alV(15);
      int j = f.a.a.b.b.a.bz(16, this.ukg);
      AppMethodBeat.o(199590);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ujy == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(199590);
          throw paramVarArgs;
        }
        AppMethodBeat.o(199590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dt localdt = (dt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199590);
          return -1;
        case 1: 
          localdt.ujy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 2: 
          localdt.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 11: 
          localdt.ujW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 12: 
          localdt.ujX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 13: 
          localdt.ujY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 14: 
          localdt.ujZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 3: 
          localdt.IconUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 4: 
          localdt.uka = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 9: 
          localdt.ukb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 10: 
          localdt.ukc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 5: 
          localdt.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(199590);
          return 0;
        case 6: 
          localdt.ueY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(199590);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdt.ukd = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(199590);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdt.uke = ((ds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(199590);
          return 0;
        case 15: 
          localdt.ukf = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(199590);
          return 0;
        }
        localdt.ukg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(199590);
        return 0;
      }
      AppMethodBeat.o(199590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dt
 * JD-Core Version:    0.7.0.1
 */