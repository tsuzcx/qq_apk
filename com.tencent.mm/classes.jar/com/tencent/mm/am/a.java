package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class a
{
  private static int hAF = 0;
  private static int hAG = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(bs.nullAsNil(parama.hAP));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bs.nullAsNil(parama.hAN));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bs.nullAsNil(parama.hAK));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!u.wh(parama.dng))
    {
      localStringBuilder.append(parama.hAH);
      localStringBuilder.append(": ");
    }
    if (bs.isNullOrNil(parama.hAP)) {
      if (bs.isNullOrNil(parama.hAN)) {
        parama = parama.hAK;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.hAN;
      continue;
      parama = parama.hAP;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> fAs;
    public String dng;
    public String hAH;
    public String hAI;
    public String hAJ;
    public String hAK;
    public String hAL;
    public String hAM;
    public String hAN;
    public String hAO;
    public String hAP;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      fAs = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a BH(String paramString)
    {
      AppMethodBeat.i(20471);
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.BrandQALogic", "empty xml to parse");
        AppMethodBeat.o(20471);
        return null;
      }
      int i = paramString.indexOf("<qamsg");
      Object localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      paramString = (a)fAs.get(Integer.valueOf(i));
      if (paramString != null)
      {
        AppMethodBeat.o(20471);
        return paramString;
      }
      paramString = bv.L((String)localObject, "qamsg");
      if (paramString == null)
      {
        ac.e("MicroMsg.BrandQALogic", "parse msg failed");
        AppMethodBeat.o(20471);
        return null;
      }
      try
      {
        localObject = new a();
        ((a)localObject).dng = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).hAH = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).hAI = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).hAJ = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).hAK = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).hAL = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).hAM = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).hAN = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).hAL = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).hAO = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).hAP = ((String)paramString.get(".qamsg.answer1.content"));
        fAs.o(Integer.valueOf(i), localObject);
        AppMethodBeat.o(20471);
        return localObject;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
        ac.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
        AppMethodBeat.o(20471);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */