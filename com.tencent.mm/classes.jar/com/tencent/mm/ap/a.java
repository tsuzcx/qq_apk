package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a
{
  private static int lHg = 0;
  private static int lHh = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(Util.nullAsNil(parama.lHq));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(Util.nullAsNil(parama.lHo));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(Util.nullAsNil(parama.lHl));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!z.PD(parama.fLi))
    {
      localStringBuilder.append(parama.lHi);
      localStringBuilder.append(": ");
    }
    if (Util.isNullOrNil(parama.lHq)) {
      if (Util.isNullOrNil(parama.lHo)) {
        parama = parama.lHl;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.lHo;
      continue;
      parama = parama.lHq;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> jla;
    public String fLi;
    public String lHi;
    public String lHj;
    public String lHk;
    public String lHl;
    public String lHm;
    public String lHn;
    public String lHo;
    public String lHp;
    public String lHq;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      jla = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a Vp(String paramString)
    {
      AppMethodBeat.i(20471);
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.BrandQALogic", "empty xml to parse");
        AppMethodBeat.o(20471);
        return null;
      }
      int i = paramString.indexOf("<qamsg");
      Object localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      paramString = (a)jla.get(Integer.valueOf(i));
      if (paramString != null)
      {
        AppMethodBeat.o(20471);
        return paramString;
      }
      paramString = XmlParser.parseXml((String)localObject, "qamsg", null);
      if (paramString == null)
      {
        Log.e("MicroMsg.BrandQALogic", "parse msg failed");
        AppMethodBeat.o(20471);
        return null;
      }
      try
      {
        localObject = new a();
        ((a)localObject).fLi = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).lHi = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).lHj = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).lHk = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).lHl = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).lHm = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).lHn = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).lHo = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).lHm = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).lHp = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).lHq = ((String)paramString.get(".qamsg.answer1.content"));
        jla.q(Integer.valueOf(i), localObject);
        AppMethodBeat.o(20471);
        return localObject;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
        Log.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
        AppMethodBeat.o(20471);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ap.a
 * JD-Core Version:    0.7.0.1
 */