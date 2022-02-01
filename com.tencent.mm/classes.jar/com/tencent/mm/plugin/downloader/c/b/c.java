package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String fnK;
  public String odc;
  public long odd;
  public String ode;
  public int odf;
  public int odg;
  public String odh;
  public o odi;
  public String odj;
  public String odk;
  public boolean odl;
  public LinkedList<a> odm;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.odm = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fnK != null) {
        paramVarArgs.d(1, this.fnK);
      }
      if (this.odc != null) {
        paramVarArgs.d(2, this.odc);
      }
      paramVarArgs.aG(3, this.odd);
      if (this.ode != null) {
        paramVarArgs.d(4, this.ode);
      }
      paramVarArgs.aR(6, this.odf);
      paramVarArgs.aR(7, this.odg);
      if (this.odh != null) {
        paramVarArgs.d(8, this.odh);
      }
      if (this.odi != null)
      {
        paramVarArgs.kX(9, this.odi.computeSize());
        this.odi.writeFields(paramVarArgs);
      }
      if (this.odj != null) {
        paramVarArgs.d(10, this.odj);
      }
      if (this.odk != null) {
        paramVarArgs.d(11, this.odk);
      }
      paramVarArgs.bg(12, this.odl);
      paramVarArgs.e(13, 8, this.odm);
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fnK == null) {
        break label1006;
      }
    }
    label1006:
    for (paramInt = f.a.a.b.b.a.e(1, this.fnK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.odc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.odc);
      }
      i += f.a.a.b.b.a.q(3, this.odd);
      paramInt = i;
      if (this.ode != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ode);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.odf) + f.a.a.b.b.a.bA(7, this.odg);
      paramInt = i;
      if (this.odh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.odh);
      }
      i = paramInt;
      if (this.odi != null) {
        i = paramInt + f.a.a.a.kW(9, this.odi.computeSize());
      }
      paramInt = i;
      if (this.odj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.odj);
      }
      i = paramInt;
      if (this.odk != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.odk);
      }
      paramInt = f.a.a.b.b.a.fY(12);
      int j = f.a.a.a.c(13, 8, this.odm);
      AppMethodBeat.o(153061);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.odm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(153061);
          return -1;
        case 1: 
          localc.fnK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.odc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.odd = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.ode = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.odf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.odg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.odh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.odi = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.odj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.odk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.odl = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153061);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.odm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      AppMethodBeat.o(153061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.c
 * JD-Core Version:    0.7.0.1
 */