package com.tencent.mm.ao;

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
  private static int oyN = 0;
  private static int oyO = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(Util.nullAsNil(parama.oyX));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(Util.nullAsNil(parama.oyV));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(Util.nullAsNil(parama.oyS));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!z.Iy(parama.hQQ))
    {
      localStringBuilder.append(parama.oyP);
      localStringBuilder.append(": ");
    }
    if (Util.isNullOrNil(parama.oyX)) {
      if (Util.isNullOrNil(parama.oyV)) {
        parama = parama.oyS;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.oyV;
      continue;
      parama = parama.oyX;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> lNS;
    public String hQQ;
    public String oyP;
    public String oyQ;
    public String oyR;
    public String oyS;
    public String oyT;
    public String oyU;
    public String oyV;
    public String oyW;
    public String oyX;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      lNS = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a No(String paramString)
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
      paramString = (a)lNS.get(Integer.valueOf(i));
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
        ((a)localObject).hQQ = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).oyP = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).oyQ = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).oyR = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).oyS = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).oyT = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).oyU = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).oyV = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).oyT = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).oyW = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).oyX = ((String)paramString.get(".qamsg.answer1.content"));
        lNS.B(Integer.valueOf(i), localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.a
 * JD-Core Version:    0.7.0.1
 */