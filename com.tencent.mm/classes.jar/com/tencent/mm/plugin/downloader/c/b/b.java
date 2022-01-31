package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public String eds;
  public String kWn;
  public long kWo;
  public String kWp;
  public int kWq;
  public int kWr;
  public String kWs;
  public n kWt;
  public String kWu;
  public String kWv;
  public boolean kWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35526);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eds != null) {
        paramVarArgs.e(1, this.eds);
      }
      if (this.kWn != null) {
        paramVarArgs.e(2, this.kWn);
      }
      paramVarArgs.am(3, this.kWo);
      if (this.kWp != null) {
        paramVarArgs.e(4, this.kWp);
      }
      paramVarArgs.aO(6, this.kWq);
      paramVarArgs.aO(7, this.kWr);
      if (this.kWs != null) {
        paramVarArgs.e(8, this.kWs);
      }
      if (this.kWt != null)
      {
        paramVarArgs.iQ(9, this.kWt.computeSize());
        this.kWt.writeFields(paramVarArgs);
      }
      if (this.kWu != null) {
        paramVarArgs.e(10, this.kWu);
      }
      if (this.kWv != null) {
        paramVarArgs.e(11, this.kWv);
      }
      paramVarArgs.aS(12, this.kWw);
      AppMethodBeat.o(35526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eds == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = e.a.a.b.b.a.f(1, this.eds) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWn != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kWn);
      }
      i += e.a.a.b.b.a.p(3, this.kWo);
      paramInt = i;
      if (this.kWp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kWp);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.kWq) + e.a.a.b.b.a.bl(7, this.kWr);
      paramInt = i;
      if (this.kWs != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.kWs);
      }
      i = paramInt;
      if (this.kWt != null) {
        i = paramInt + e.a.a.a.iP(9, this.kWt.computeSize());
      }
      paramInt = i;
      if (this.kWu != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.kWu);
      }
      i = paramInt;
      if (this.kWv != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.kWv);
      }
      paramInt = e.a.a.b.b.a.eW(12);
      AppMethodBeat.o(35526);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(35526);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(35526);
          return -1;
        case 1: 
          localb.eds = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35526);
          return 0;
        case 2: 
          localb.kWn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35526);
          return 0;
        case 3: 
          localb.kWo = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(35526);
          return 0;
        case 4: 
          localb.kWp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35526);
          return 0;
        case 6: 
          localb.kWq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35526);
          return 0;
        case 7: 
          localb.kWr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35526);
          return 0;
        case 8: 
          localb.kWs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35526);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new n();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.kWt = ((n)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35526);
          return 0;
        case 10: 
          localb.kWu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35526);
          return 0;
        case 11: 
          localb.kWv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35526);
          return 0;
        }
        localb.kWw = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(35526);
        return 0;
      }
      AppMethodBeat.o(35526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.b
 * JD-Core Version:    0.7.0.1
 */