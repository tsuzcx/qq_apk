package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a$a
{
  private static final f<Integer, a> eka;
  public String czp;
  public String fyk;
  public String fyl;
  public String fym;
  public String fyn;
  public String fyo;
  public String fyp;
  public String fyq;
  public String fyr;
  public String fys;
  public String toUser;
  
  static
  {
    AppMethodBeat.i(16426);
    eka = new c(100);
    AppMethodBeat.o(16426);
  }
  
  public static final a sz(String paramString)
  {
    AppMethodBeat.i(16425);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.BrandQALogic", "empty xml to parse");
      AppMethodBeat.o(16425);
      return null;
    }
    int i = paramString.indexOf("<qamsg");
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = ((String)localObject).hashCode();
    paramString = (a)eka.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(16425);
      return paramString;
    }
    paramString = br.F((String)localObject, "qamsg");
    if (paramString == null)
    {
      ab.e("MicroMsg.BrandQALogic", "parse msg failed");
      AppMethodBeat.o(16425);
      return null;
    }
    try
    {
      localObject = new a();
      ((a)localObject).czp = ((String)paramString.get(".qamsg.$fromUser"));
      ((a)localObject).fyk = ((String)paramString.get(".qamsg.$fromNickname"));
      ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
      ((a)localObject).fyl = ((String)paramString.get(".qamsg.question.$id"));
      ((a)localObject).fym = ((String)paramString.get(".qamsg.question.$fromUser"));
      ((a)localObject).fyn = ((String)paramString.get(".qamsg.question.content"));
      ((a)localObject).fyo = ((String)paramString.get(".qamsg.answer.$id"));
      ((a)localObject).fyp = ((String)paramString.get(".qamsg.answer.$fromUser"));
      ((a)localObject).fyq = ((String)paramString.get(".qamsg.answer.content"));
      ((a)localObject).fyo = ((String)paramString.get(".qamsg.answer1.$id"));
      ((a)localObject).fyr = ((String)paramString.get(".qamsg.answer1.$fromUser"));
      ((a)localObject).fys = ((String)paramString.get(".qamsg.answer1.content"));
      eka.f(Integer.valueOf(i), localObject);
      AppMethodBeat.o(16425);
      return localObject;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
      ab.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
      AppMethodBeat.o(16425);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.a.a
 * JD-Core Version:    0.7.0.1
 */