package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ec
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Title;
  public int oUv;
  public String xIy;
  public String xJd;
  public String xMX;
  public String xNA;
  public ea xNB;
  public eb xNC;
  public boolean xND;
  public int xNE;
  public String xNv;
  public String xNw;
  public String xNx;
  public String xNy;
  public String xNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMX == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(256653);
        throw paramVarArgs;
      }
      if (this.xMX != null) {
        paramVarArgs.e(1, this.xMX);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.xNv != null) {
        paramVarArgs.e(11, this.xNv);
      }
      if (this.xNw != null) {
        paramVarArgs.e(12, this.xNw);
      }
      if (this.xNx != null) {
        paramVarArgs.e(13, this.xNx);
      }
      if (this.xNy != null) {
        paramVarArgs.e(14, this.xNy);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(3, this.IconUrl);
      }
      if (this.xNz != null) {
        paramVarArgs.e(4, this.xNz);
      }
      if (this.xJd != null) {
        paramVarArgs.e(9, this.xJd);
      }
      if (this.xNA != null) {
        paramVarArgs.e(10, this.xNA);
      }
      paramVarArgs.aM(5, this.oUv);
      if (this.xIy != null) {
        paramVarArgs.e(6, this.xIy);
      }
      if (this.xNB != null)
      {
        paramVarArgs.ni(7, this.xNB.computeSize());
        this.xNB.writeFields(paramVarArgs);
      }
      if (this.xNC != null)
      {
        paramVarArgs.ni(8, this.xNC.computeSize());
        this.xNC.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(15, this.xND);
      paramVarArgs.aM(16, this.xNE);
      AppMethodBeat.o(256653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMX == null) {
        break label1326;
      }
    }
    label1326:
    for (int i = g.a.a.b.b.a.f(1, this.xMX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.xNv != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.xNv);
      }
      paramInt = i;
      if (this.xNw != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.xNw);
      }
      i = paramInt;
      if (this.xNx != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.xNx);
      }
      paramInt = i;
      if (this.xNy != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.xNy);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.IconUrl);
      }
      paramInt = i;
      if (this.xNz != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNz);
      }
      i = paramInt;
      if (this.xJd != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.xJd);
      }
      paramInt = i;
      if (this.xNA != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.xNA);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.oUv);
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xIy);
      }
      i = paramInt;
      if (this.xNB != null) {
        i = paramInt + g.a.a.a.nh(7, this.xNB.computeSize());
      }
      paramInt = i;
      if (this.xNC != null) {
        paramInt = i + g.a.a.a.nh(8, this.xNC.computeSize());
      }
      i = g.a.a.b.b.a.fS(15);
      int j = g.a.a.b.b.a.bu(16, this.xNE);
      AppMethodBeat.o(256653);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xMX == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(256653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ec localec = (ec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256653);
          return -1;
        case 1: 
          localec.xMX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 2: 
          localec.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 11: 
          localec.xNv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 12: 
          localec.xNw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 13: 
          localec.xNx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 14: 
          localec.xNy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 3: 
          localec.IconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 4: 
          localec.xNz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 9: 
          localec.xJd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 10: 
          localec.xNA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 5: 
          localec.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(256653);
          return 0;
        case 6: 
          localec.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256653);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ea();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localec.xNB = ((ea)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256653);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localec.xNC = ((eb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256653);
          return 0;
        case 15: 
          localec.xND = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(256653);
          return 0;
        }
        localec.xNE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(256653);
        return 0;
      }
      AppMethodBeat.o(256653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ec
 * JD-Core Version:    0.7.0.1
 */