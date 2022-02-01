package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class c
  extends com.tencent.mm.bx.a
{
  public String decodeKey;
  public int mediaType;
  public String msf;
  public String msh;
  public String thumbUrl;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233281);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.msf == null)
      {
        paramVarArgs = new b("Not all required fields were included: urlToken");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.thumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: thumbUrl");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.msh == null)
      {
        paramVarArgs = new b("Not all required fields were included: thumbUrlToken");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.decodeKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: decodeKey");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.mediaType);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.msf != null) {
        paramVarArgs.g(3, this.msf);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(4, this.thumbUrl);
      }
      if (this.msh != null) {
        paramVarArgs.g(5, this.msh);
      }
      if (this.decodeKey != null) {
        paramVarArgs.g(6, this.decodeKey);
      }
      AppMethodBeat.o(233281);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.mediaType) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.msf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.msf);
      }
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.thumbUrl);
      }
      i = paramInt;
      if (this.msh != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.msh);
      }
      paramInt = i;
      if (this.decodeKey != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.decodeKey);
      }
      AppMethodBeat.o(233281);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.msf == null)
      {
        paramVarArgs = new b("Not all required fields were included: urlToken");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.thumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: thumbUrl");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.msh == null)
      {
        paramVarArgs = new b("Not all required fields were included: thumbUrlToken");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      if (this.decodeKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: decodeKey");
        AppMethodBeat.o(233281);
        throw paramVarArgs;
      }
      AppMethodBeat.o(233281);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(233281);
        return -1;
      case 1: 
        localc.mediaType = locala.ajGk.aar();
        AppMethodBeat.o(233281);
        return 0;
      case 2: 
        localc.url = locala.ajGk.readString();
        AppMethodBeat.o(233281);
        return 0;
      case 3: 
        localc.msf = locala.ajGk.readString();
        AppMethodBeat.o(233281);
        return 0;
      case 4: 
        localc.thumbUrl = locala.ajGk.readString();
        AppMethodBeat.o(233281);
        return 0;
      case 5: 
        localc.msh = locala.ajGk.readString();
        AppMethodBeat.o(233281);
        return 0;
      }
      localc.decodeKey = locala.ajGk.readString();
      AppMethodBeat.o(233281);
      return 0;
    }
    AppMethodBeat.o(233281);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.c
 * JD-Core Version:    0.7.0.1
 */