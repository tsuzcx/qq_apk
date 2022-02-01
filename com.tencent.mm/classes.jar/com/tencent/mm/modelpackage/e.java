package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class e
  extends com.tencent.mm.bx.a
{
  public int hYb;
  public d mhD;
  public h mhJ;
  public i mhK;
  public m mij;
  public String name;
  public LinkedList<f> oQp;
  public int oQq;
  public int oQr;
  public int oQs;
  public String oQt;
  public int oQu;
  public LinkedList<q> oQv;
  public int oQw;
  public String oQx;
  public int type;
  
  public e()
  {
    AppMethodBeat.i(150794);
    this.oQp = new LinkedList();
    this.oQv = new LinkedList();
    AppMethodBeat.o(150794);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150795);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.oQp);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.bS(3, this.oQq);
      paramVarArgs.bS(4, this.hYb);
      paramVarArgs.bS(5, this.oQr);
      paramVarArgs.bS(6, this.oQs);
      if (this.oQt != null) {
        paramVarArgs.g(7, this.oQt);
      }
      paramVarArgs.bS(8, this.oQu);
      if (this.mij != null)
      {
        paramVarArgs.qD(9, this.mij.computeSize());
        this.mij.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.oQv);
      paramVarArgs.bS(11, this.type);
      if (this.mhD != null)
      {
        paramVarArgs.qD(12, this.mhD.computeSize());
        this.mhD.writeFields(paramVarArgs);
      }
      if (this.mhK != null)
      {
        paramVarArgs.qD(13, this.mhK.computeSize());
        this.mhK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.oQw);
      if (this.oQx != null) {
        paramVarArgs.g(15, this.oQx);
      }
      if (this.mhJ != null)
      {
        paramVarArgs.qD(16, this.mhJ.computeSize());
        this.mhJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.oQp) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.oQq) + i.a.a.b.b.a.cJ(4, this.hYb) + i.a.a.b.b.a.cJ(5, this.oQr) + i.a.a.b.b.a.cJ(6, this.oQs);
      paramInt = i;
      if (this.oQt != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.oQt);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.oQu);
      paramInt = i;
      if (this.mij != null) {
        paramInt = i + i.a.a.a.qC(9, this.mij.computeSize());
      }
      i = paramInt + i.a.a.a.c(10, 8, this.oQv) + i.a.a.b.b.a.cJ(11, this.type);
      paramInt = i;
      if (this.mhD != null) {
        paramInt = i + i.a.a.a.qC(12, this.mhD.computeSize());
      }
      i = paramInt;
      if (this.mhK != null) {
        i = paramInt + i.a.a.a.qC(13, this.mhK.computeSize());
      }
      i += i.a.a.b.b.a.cJ(14, this.oQw);
      paramInt = i;
      if (this.oQx != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.oQx);
      }
      i = paramInt;
      if (this.mhJ != null) {
        i = paramInt + i.a.a.a.qC(16, this.mhJ.computeSize());
      }
      AppMethodBeat.o(150795);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oQp.clear();
      this.oQv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150795);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          locale.oQp.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 2: 
        locale.name = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 3: 
        locale.oQq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 4: 
        locale.hYb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 5: 
        locale.oQr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 6: 
        locale.oQs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 7: 
        locale.oQt = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(150795);
        return 0;
      case 8: 
        locale.oQu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new m();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((m)localObject2).parseFrom((byte[])localObject1);
          }
          locale.mij = ((m)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          locale.oQv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 11: 
        locale.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          locale.mhD = ((d)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 13: 
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
          locale.mhK = ((i)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(150795);
        return 0;
      case 14: 
        locale.oQw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(150795);
        return 0;
      case 15: 
        locale.oQx = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(150795);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new h();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((h)localObject2).parseFrom((byte[])localObject1);
        }
        locale.mhJ = ((h)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(150795);
      return 0;
    }
    AppMethodBeat.o(150795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelpackage.e
 * JD-Core Version:    0.7.0.1
 */