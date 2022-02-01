package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ao
  extends com.tencent.mm.bw.a
{
  public String jfi;
  public String xIy;
  public String xJt;
  public int xJv;
  public int xJy;
  public s xKA;
  public cn xKp;
  public el xKq;
  public cy xKr;
  public cz xKs;
  public bg xKt;
  public dh xKu;
  public be xKv;
  public t xKw;
  public dc xKx;
  public dp xKy;
  public s xKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xJy);
      paramVarArgs.aM(2, this.xJv);
      if (this.xJt != null) {
        paramVarArgs.e(3, this.xJt);
      }
      if (this.jfi != null) {
        paramVarArgs.e(4, this.jfi);
      }
      if (this.xIy != null) {
        paramVarArgs.e(17, this.xIy);
      }
      if (this.xKp != null)
      {
        paramVarArgs.ni(5, this.xKp.computeSize());
        this.xKp.writeFields(paramVarArgs);
      }
      if (this.xKq != null)
      {
        paramVarArgs.ni(6, this.xKq.computeSize());
        this.xKq.writeFields(paramVarArgs);
      }
      if (this.xKr != null)
      {
        paramVarArgs.ni(7, this.xKr.computeSize());
        this.xKr.writeFields(paramVarArgs);
      }
      if (this.xKs != null)
      {
        paramVarArgs.ni(8, this.xKs.computeSize());
        this.xKs.writeFields(paramVarArgs);
      }
      if (this.xKt != null)
      {
        paramVarArgs.ni(9, this.xKt.computeSize());
        this.xKt.writeFields(paramVarArgs);
      }
      if (this.xKu != null)
      {
        paramVarArgs.ni(10, this.xKu.computeSize());
        this.xKu.writeFields(paramVarArgs);
      }
      if (this.xKv != null)
      {
        paramVarArgs.ni(11, this.xKv.computeSize());
        this.xKv.writeFields(paramVarArgs);
      }
      if (this.xKw != null)
      {
        paramVarArgs.ni(12, this.xKw.computeSize());
        this.xKw.writeFields(paramVarArgs);
      }
      if (this.xKx != null)
      {
        paramVarArgs.ni(13, this.xKx.computeSize());
        this.xKx.writeFields(paramVarArgs);
      }
      if (this.xKy != null)
      {
        paramVarArgs.ni(14, this.xKy.computeSize());
        this.xKy.writeFields(paramVarArgs);
      }
      if (this.xKz != null)
      {
        paramVarArgs.ni(15, this.xKz.computeSize());
        this.xKz.writeFields(paramVarArgs);
      }
      if (this.xKA != null)
      {
        paramVarArgs.ni(16, this.xKA.computeSize());
        this.xKA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.xJy) + 0 + g.a.a.b.b.a.bu(2, this.xJv);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xJt);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.jfi);
      }
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.xIy);
      }
      i = paramInt;
      if (this.xKp != null) {
        i = paramInt + g.a.a.a.nh(5, this.xKp.computeSize());
      }
      paramInt = i;
      if (this.xKq != null) {
        paramInt = i + g.a.a.a.nh(6, this.xKq.computeSize());
      }
      i = paramInt;
      if (this.xKr != null) {
        i = paramInt + g.a.a.a.nh(7, this.xKr.computeSize());
      }
      paramInt = i;
      if (this.xKs != null) {
        paramInt = i + g.a.a.a.nh(8, this.xKs.computeSize());
      }
      i = paramInt;
      if (this.xKt != null) {
        i = paramInt + g.a.a.a.nh(9, this.xKt.computeSize());
      }
      paramInt = i;
      if (this.xKu != null) {
        paramInt = i + g.a.a.a.nh(10, this.xKu.computeSize());
      }
      i = paramInt;
      if (this.xKv != null) {
        i = paramInt + g.a.a.a.nh(11, this.xKv.computeSize());
      }
      paramInt = i;
      if (this.xKw != null) {
        paramInt = i + g.a.a.a.nh(12, this.xKw.computeSize());
      }
      i = paramInt;
      if (this.xKx != null) {
        i = paramInt + g.a.a.a.nh(13, this.xKx.computeSize());
      }
      paramInt = i;
      if (this.xKy != null) {
        paramInt = i + g.a.a.a.nh(14, this.xKy.computeSize());
      }
      i = paramInt;
      if (this.xKz != null) {
        i = paramInt + g.a.a.a.nh(15, this.xKz.computeSize());
      }
      paramInt = i;
      if (this.xKA != null) {
        paramInt = i + g.a.a.a.nh(16, this.xKA.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localao.xJy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localao.xJv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localao.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localao.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localao.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKp = ((cn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new el();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((el)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKq = ((el)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKr = ((cy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKs = ((cz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKt = ((bg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKu = ((dh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new be();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((be)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKv = ((be)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKw = ((t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKx = ((dc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKy = ((dp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new s();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localao.xKz = ((s)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localao.xKA = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ao
 * JD-Core Version:    0.7.0.1
 */