package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public int IHj;
  public boolean IHk;
  public int IHl;
  public cy IHm;
  public LinkedList<ac> IHn;
  public String IHo;
  public String IHp;
  public LinkedList<w> IHq;
  public int IHr;
  public String vYl;
  
  public h()
  {
    AppMethodBeat.i(276885);
    this.IHn = new LinkedList();
    this.IHq = new LinkedList();
    AppMethodBeat.o(276885);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276889);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IHj);
      if (this.vYl != null) {
        paramVarArgs.g(2, this.vYl);
      }
      paramVarArgs.di(3, this.IHk);
      paramVarArgs.bS(4, this.IHl);
      if (this.IHm != null)
      {
        paramVarArgs.qD(5, this.IHm.computeSize());
        this.IHm.writeFields(paramVarArgs);
      }
      if (this.IGI != null) {
        paramVarArgs.g(6, this.IGI);
      }
      paramVarArgs.e(7, 8, this.IHn);
      if (this.IHo != null) {
        paramVarArgs.g(8, this.IHo);
      }
      if (this.IHp != null) {
        paramVarArgs.g(9, this.IHp);
      }
      paramVarArgs.e(10, 8, this.IHq);
      paramVarArgs.bS(11, this.IHr);
      AppMethodBeat.o(276889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.IHj) + 0;
      paramInt = i;
      if (this.vYl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vYl);
      }
      i = paramInt + (i.a.a.b.b.a.ko(3) + 1) + i.a.a.b.b.a.cJ(4, this.IHl);
      paramInt = i;
      if (this.IHm != null) {
        paramInt = i + i.a.a.a.qC(5, this.IHm.computeSize());
      }
      i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.IGI);
      }
      i += i.a.a.a.c(7, 8, this.IHn);
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.IHo);
      }
      i = paramInt;
      if (this.IHp != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.IHp);
      }
      paramInt = i.a.a.a.c(10, 8, this.IHq);
      int j = i.a.a.b.b.a.cJ(11, this.IHr);
      AppMethodBeat.o(276889);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IHn.clear();
      this.IHq.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(276889);
        return -1;
      case 1: 
        localh.IHj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(276889);
        return 0;
      case 2: 
        localh.vYl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(276889);
        return 0;
      case 3: 
        localh.IHk = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(276889);
        return 0;
      case 4: 
        localh.IHl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(276889);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cy)localObject2).parseFrom((byte[])localObject1);
          }
          localh.IHm = ((cy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276889);
        return 0;
      case 6: 
        localh.IGI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(276889);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ac();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ac)localObject2).parseFrom((byte[])localObject1);
          }
          localh.IHn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276889);
        return 0;
      case 8: 
        localh.IHo = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(276889);
        return 0;
      case 9: 
        localh.IHp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(276889);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new w();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((w)localObject2).parseFrom((byte[])localObject1);
          }
          localh.IHq.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(276889);
        return 0;
      }
      localh.IHr = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(276889);
      return 0;
    }
    AppMethodBeat.o(276889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.h
 * JD-Core Version:    0.7.0.1
 */