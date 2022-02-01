package com.tencent.mm.am;

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
  private static int iQQ = 0;
  private static int iQR = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(Util.nullAsNil(parama.iRa));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(Util.nullAsNil(parama.iQY));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(Util.nullAsNil(parama.iQV));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!z.Im(parama.dRL))
    {
      localStringBuilder.append(parama.iQS);
      localStringBuilder.append(": ");
    }
    if (Util.isNullOrNil(parama.iRa)) {
      if (Util.isNullOrNil(parama.iQY)) {
        parama = parama.iQV;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.iQY;
      continue;
      parama = parama.iRa;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> gAU;
    public String dRL;
    public String iQS;
    public String iQT;
    public String iQU;
    public String iQV;
    public String iQW;
    public String iQX;
    public String iQY;
    public String iQZ;
    public String iRa;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      gAU = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a NS(String paramString)
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
      paramString = (a)gAU.get(Integer.valueOf(i));
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
        ((a)localObject).dRL = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).iQS = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).iQT = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).iQU = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).iQV = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).iQW = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).iQX = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).iQY = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).iQW = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).iQZ = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).iRa = ((String)paramString.get(".qamsg.answer1.content"));
        gAU.x(Integer.valueOf(i), localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */