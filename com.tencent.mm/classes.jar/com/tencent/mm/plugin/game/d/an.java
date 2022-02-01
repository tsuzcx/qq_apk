package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
  extends com.tencent.mm.bw.a
{
  public String ikm;
  public String uqf;
  public cn urX;
  public el urY;
  public cy urZ;
  public String ura;
  public int urc;
  public int urf;
  public cz usa;
  public bf usb;
  public dh usc;
  public bd usd;
  public t use;
  public dc usf;
  public dp usg;
  public s ush;
  public s usi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.urf);
      paramVarArgs.aS(2, this.urc);
      if (this.ura != null) {
        paramVarArgs.d(3, this.ura);
      }
      if (this.ikm != null) {
        paramVarArgs.d(4, this.ikm);
      }
      if (this.uqf != null) {
        paramVarArgs.d(17, this.uqf);
      }
      if (this.urX != null)
      {
        paramVarArgs.lJ(5, this.urX.computeSize());
        this.urX.writeFields(paramVarArgs);
      }
      if (this.urY != null)
      {
        paramVarArgs.lJ(6, this.urY.computeSize());
        this.urY.writeFields(paramVarArgs);
      }
      if (this.urZ != null)
      {
        paramVarArgs.lJ(7, this.urZ.computeSize());
        this.urZ.writeFields(paramVarArgs);
      }
      if (this.usa != null)
      {
        paramVarArgs.lJ(8, this.usa.computeSize());
        this.usa.writeFields(paramVarArgs);
      }
      if (this.usb != null)
      {
        paramVarArgs.lJ(9, this.usb.computeSize());
        this.usb.writeFields(paramVarArgs);
      }
      if (this.usc != null)
      {
        paramVarArgs.lJ(10, this.usc.computeSize());
        this.usc.writeFields(paramVarArgs);
      }
      if (this.usd != null)
      {
        paramVarArgs.lJ(11, this.usd.computeSize());
        this.usd.writeFields(paramVarArgs);
      }
      if (this.use != null)
      {
        paramVarArgs.lJ(12, this.use.computeSize());
        this.use.writeFields(paramVarArgs);
      }
      if (this.usf != null)
      {
        paramVarArgs.lJ(13, this.usf.computeSize());
        this.usf.writeFields(paramVarArgs);
      }
      if (this.usg != null)
      {
        paramVarArgs.lJ(14, this.usg.computeSize());
        this.usg.writeFields(paramVarArgs);
      }
      if (this.ush != null)
      {
        paramVarArgs.lJ(15, this.ush.computeSize());
        this.ush.writeFields(paramVarArgs);
      }
      if (this.usi != null)
      {
        paramVarArgs.lJ(16, this.usi.computeSize());
        this.usi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.urf) + 0 + f.a.a.b.b.a.bz(2, this.urc);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ura);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ikm);
      }
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.uqf);
      }
      i = paramInt;
      if (this.urX != null) {
        i = paramInt + f.a.a.a.lI(5, this.urX.computeSize());
      }
      paramInt = i;
      if (this.urY != null) {
        paramInt = i + f.a.a.a.lI(6, this.urY.computeSize());
      }
      i = paramInt;
      if (this.urZ != null) {
        i = paramInt + f.a.a.a.lI(7, this.urZ.computeSize());
      }
      paramInt = i;
      if (this.usa != null) {
        paramInt = i + f.a.a.a.lI(8, this.usa.computeSize());
      }
      i = paramInt;
      if (this.usb != null) {
        i = paramInt + f.a.a.a.lI(9, this.usb.computeSize());
      }
      paramInt = i;
      if (this.usc != null) {
        paramInt = i + f.a.a.a.lI(10, this.usc.computeSize());
      }
      i = paramInt;
      if (this.usd != null) {
        i = paramInt + f.a.a.a.lI(11, this.usd.computeSize());
      }
      paramInt = i;
      if (this.use != null) {
        paramInt = i + f.a.a.a.lI(12, this.use.computeSize());
      }
      i = paramInt;
      if (this.usf != null) {
        i = paramInt + f.a.a.a.lI(13, this.usf.computeSize());
      }
      paramInt = i;
      if (this.usg != null) {
        paramInt = i + f.a.a.a.lI(14, this.usg.computeSize());
      }
      i = paramInt;
      if (this.ush != null) {
        i = paramInt + f.a.a.a.lI(15, this.ush.computeSize());
      }
      paramInt = i;
      if (this.usi != null) {
        paramInt = i + f.a.a.a.lI(16, this.usi.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      an localan = (an)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localan.urf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localan.urc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localan.ura = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localan.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localan.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.urX = ((cn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new el();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((el)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.urY = ((el)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.urZ = ((cy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.usa = ((cz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.usb = ((bf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.usc = ((dh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.usd = ((bd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.use = ((t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.usf = ((dc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.usg = ((dp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new s();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.ush = ((s)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localan.usi = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.an
 * JD-Core Version:    0.7.0.1
 */