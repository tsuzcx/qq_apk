package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GCLocationInfo
  extends com.tencent.mm.bx.a
{
  public String ad_code;
  public String city;
  public String country;
  public String province;
  public String region;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275470);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.province != null) {
        paramVarArgs.g(1, this.province);
      }
      if (this.country != null) {
        paramVarArgs.g(2, this.country);
      }
      if (this.city != null) {
        paramVarArgs.g(3, this.city);
      }
      if (this.ad_code != null) {
        paramVarArgs.g(4, this.ad_code);
      }
      if (this.region != null) {
        paramVarArgs.g(5, this.region);
      }
      AppMethodBeat.o(275470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.province == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.province) + 0;; i = 0)
    {
      paramInt = i;
      if (this.country != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.country);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.city);
      }
      paramInt = i;
      if (this.ad_code != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ad_code);
      }
      i = paramInt;
      if (this.region != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.region);
      }
      AppMethodBeat.o(275470);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275470);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        GCLocationInfo localGCLocationInfo = (GCLocationInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275470);
          return -1;
        case 1: 
          localGCLocationInfo.province = locala.ajGk.readString();
          AppMethodBeat.o(275470);
          return 0;
        case 2: 
          localGCLocationInfo.country = locala.ajGk.readString();
          AppMethodBeat.o(275470);
          return 0;
        case 3: 
          localGCLocationInfo.city = locala.ajGk.readString();
          AppMethodBeat.o(275470);
          return 0;
        case 4: 
          localGCLocationInfo.ad_code = locala.ajGk.readString();
          AppMethodBeat.o(275470);
          return 0;
        }
        localGCLocationInfo.region = locala.ajGk.readString();
        AppMethodBeat.o(275470);
        return 0;
      }
      AppMethodBeat.o(275470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GCLocationInfo
 * JD-Core Version:    0.7.0.1
 */