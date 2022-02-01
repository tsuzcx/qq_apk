package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String vgW;
  public b ytl;
  public int ytm;
  public int ytn;
  public int yto;
  public b ytp;
  public b ytq;
  public String ytr;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytK != null)
      {
        paramVarArgs.qD(1, this.ytK.computeSize());
        this.ytK.writeFields(paramVarArgs);
      }
      if (this.ytl != null) {
        paramVarArgs.d(2, this.ytl);
      }
      paramVarArgs.bS(3, this.ytm);
      paramVarArgs.bS(4, this.ytn);
      paramVarArgs.bS(5, this.yto);
      if (this.ytp != null) {
        paramVarArgs.d(6, this.ytp);
      }
      if (this.ytq != null) {
        paramVarArgs.d(7, this.ytq);
      }
      if (this.ytr != null) {
        paramVarArgs.g(10, this.ytr);
      }
      if (this.yts != null) {
        paramVarArgs.g(11, this.yts);
      }
      if (this.vgW != null) {
        paramVarArgs.g(12, this.vgW);
      }
      AppMethodBeat.o(23485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytK == null) {
        break label808;
      }
    }
    label808:
    for (paramInt = i.a.a.a.qC(1, this.ytK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ytl != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ytl);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.ytm) + i.a.a.b.b.a.cJ(4, this.ytn) + i.a.a.b.b.a.cJ(5, this.yto);
      paramInt = i;
      if (this.ytp != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.ytp);
      }
      i = paramInt;
      if (this.ytq != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.ytq);
      }
      paramInt = i;
      if (this.ytr != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ytr);
      }
      i = paramInt;
      if (this.yts != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.yts);
      }
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.vgW);
      }
      AppMethodBeat.o(23485);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(23485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(23485);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            d locald = new d();
            if ((localObject != null) && (localObject.length > 0)) {
              locald.parseFrom((byte[])localObject);
            }
            locala.ytK = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(23485);
          return 0;
        case 2: 
          locala.ytl = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(23485);
          return 0;
        case 3: 
          locala.ytm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23485);
          return 0;
        case 4: 
          locala.ytn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23485);
          return 0;
        case 5: 
          locala.yto = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(23485);
          return 0;
        case 6: 
          locala.ytp = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(23485);
          return 0;
        case 7: 
          locala.ytq = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(23485);
          return 0;
        case 10: 
          locala.ytr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(23485);
          return 0;
        case 11: 
          locala.yts = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(23485);
          return 0;
        }
        locala.vgW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(23485);
        return 0;
      }
      AppMethodBeat.o(23485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a
 * JD-Core Version:    0.7.0.1
 */