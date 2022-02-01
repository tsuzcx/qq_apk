package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public String backgroundId;
  public String iconId;
  public String iconUrl;
  public String id;
  public String jumpType;
  public String mediaThumbUrl;
  public int mediaType;
  public String mediaUrl;
  public long msd;
  public String mse;
  public String msp;
  public b msq;
  public boolean msr;
  public String mss;
  public String sourceName;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233314);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: id");
        AppMethodBeat.o(233314);
        throw paramVarArgs;
      }
      if (this.iconUrl == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: iconUrl");
        AppMethodBeat.o(233314);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bv(2, this.msd);
      paramVarArgs.bS(3, this.mediaType);
      if (this.iconUrl != null) {
        paramVarArgs.g(4, this.iconUrl);
      }
      if (this.msp != null) {
        paramVarArgs.g(5, this.msp);
      }
      if (this.iconId != null) {
        paramVarArgs.g(6, this.iconId);
      }
      if (this.text != null) {
        paramVarArgs.g(7, this.text);
      }
      if (this.mediaUrl != null) {
        paramVarArgs.g(8, this.mediaUrl);
      }
      if (this.mediaThumbUrl != null) {
        paramVarArgs.g(9, this.mediaThumbUrl);
      }
      if (this.mse != null) {
        paramVarArgs.g(10, this.mse);
      }
      if (this.backgroundId != null) {
        paramVarArgs.g(11, this.backgroundId);
      }
      if (this.msq != null)
      {
        paramVarArgs.qD(12, this.msq.computeSize());
        this.msq.writeFields(paramVarArgs);
      }
      paramVarArgs.di(13, this.msr);
      if (this.mss != null) {
        paramVarArgs.g(14, this.mss);
      }
      if (this.sourceName != null) {
        paramVarArgs.g(15, this.sourceName);
      }
      if (this.jumpType != null) {
        paramVarArgs.g(16, this.jumpType);
      }
      AppMethodBeat.o(233314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1252;
      }
    }
    label1252:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.msd) + i.a.a.b.b.a.cJ(3, this.mediaType);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.iconUrl);
      }
      i = paramInt;
      if (this.msp != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.msp);
      }
      paramInt = i;
      if (this.iconId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.iconId);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.text);
      }
      paramInt = i;
      if (this.mediaUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.mediaUrl);
      }
      i = paramInt;
      if (this.mediaThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.mediaThumbUrl);
      }
      paramInt = i;
      if (this.mse != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.mse);
      }
      i = paramInt;
      if (this.backgroundId != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.backgroundId);
      }
      paramInt = i;
      if (this.msq != null) {
        paramInt = i + i.a.a.a.qC(12, this.msq.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(13) + 1);
      paramInt = i;
      if (this.mss != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.mss);
      }
      i = paramInt;
      if (this.sourceName != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.sourceName);
      }
      paramInt = i;
      if (this.jumpType != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.jumpType);
      }
      AppMethodBeat.o(233314);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: id");
          AppMethodBeat.o(233314);
          throw paramVarArgs;
        }
        if (this.iconUrl == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: iconUrl");
          AppMethodBeat.o(233314);
          throw paramVarArgs;
        }
        AppMethodBeat.o(233314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(233314);
          return -1;
        case 1: 
          locali.id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 2: 
          locali.msd = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(233314);
          return 0;
        case 3: 
          locali.mediaType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(233314);
          return 0;
        case 4: 
          locali.iconUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 5: 
          locali.msp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 6: 
          locali.iconId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 7: 
          locali.text = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 8: 
          locali.mediaUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 9: 
          locali.mediaThumbUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 10: 
          locali.mse = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 11: 
          locali.backgroundId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            b localb = new b();
            if ((localObject != null) && (localObject.length > 0)) {
              localb.parseFrom((byte[])localObject);
            }
            locali.msq = localb;
            paramInt += 1;
          }
          AppMethodBeat.o(233314);
          return 0;
        case 13: 
          locali.msr = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(233314);
          return 0;
        case 14: 
          locali.mss = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        case 15: 
          locali.sourceName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(233314);
          return 0;
        }
        locali.jumpType = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(233314);
        return 0;
      }
      AppMethodBeat.o(233314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.i
 * JD-Core Version:    0.7.0.1
 */