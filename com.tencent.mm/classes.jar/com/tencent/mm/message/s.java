package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class s
  extends com.tencent.mm.bx.a
{
  public String hEE;
  public String hES;
  public long hTh;
  public long msgId;
  public String mso;
  public int nQq;
  public int nUE;
  public String nUF;
  public v nUG;
  public LinkedList<String> nUH;
  public int type;
  public String userName;
  
  public s()
  {
    AppMethodBeat.i(116415);
    this.nUH = new LinkedList();
    AppMethodBeat.o(116415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.msgId);
      paramVarArgs.bv(2, this.hTh);
      if (this.hES != null) {
        paramVarArgs.g(3, this.hES);
      }
      paramVarArgs.bS(4, this.nUE);
      paramVarArgs.bS(5, this.type);
      if (this.userName != null) {
        paramVarArgs.g(6, this.userName);
      }
      if (this.hEE != null) {
        paramVarArgs.g(7, this.hEE);
      }
      if (this.nUF != null) {
        paramVarArgs.g(8, this.nUF);
      }
      if (this.mso != null) {
        paramVarArgs.g(9, this.mso);
      }
      paramVarArgs.bS(10, this.nQq);
      if (this.nUG != null)
      {
        paramVarArgs.qD(11, this.nUG.computeSize());
        this.nUG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(12, 1, this.nUH);
      AppMethodBeat.o(116416);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.msgId) + 0 + i.a.a.b.b.a.q(2, this.hTh);
      paramInt = i;
      if (this.hES != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hES);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.nUE) + i.a.a.b.b.a.cJ(5, this.type);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.userName);
      }
      i = paramInt;
      if (this.hEE != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hEE);
      }
      paramInt = i;
      if (this.nUF != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.nUF);
      }
      i = paramInt;
      if (this.mso != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.mso);
      }
      i += i.a.a.b.b.a.cJ(10, this.nQq);
      paramInt = i;
      if (this.nUG != null) {
        paramInt = i + i.a.a.a.qC(11, this.nUG.computeSize());
      }
      i = i.a.a.a.c(12, 1, this.nUH);
      AppMethodBeat.o(116416);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nUH.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(116416);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(116416);
        return -1;
      case 1: 
        locals.msgId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(116416);
        return 0;
      case 2: 
        locals.hTh = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(116416);
        return 0;
      case 3: 
        locals.hES = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 4: 
        locals.nUE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(116416);
        return 0;
      case 5: 
        locals.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(116416);
        return 0;
      case 6: 
        locals.userName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 7: 
        locals.hEE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 8: 
        locals.nUF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 9: 
        locals.mso = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116416);
        return 0;
      case 10: 
        locals.nQq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(116416);
        return 0;
      case 11: 
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
          locals.nUG = localv;
          paramInt += 1;
        }
        AppMethodBeat.o(116416);
        return 0;
      }
      locals.nUH.add(((i.a.a.a.a)localObject).ajGk.readString());
      AppMethodBeat.o(116416);
      return 0;
    }
    AppMethodBeat.o(116416);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.message.s
 * JD-Core Version:    0.7.0.1
 */