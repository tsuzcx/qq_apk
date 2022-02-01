package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class a
{
  private static int hag = 0;
  private static int hah = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(bt.nullAsNil(parama.haq));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bt.nullAsNil(parama.hao));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bt.nullAsNil(parama.hal));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!u.se(parama.dpv))
    {
      localStringBuilder.append(parama.hai);
      localStringBuilder.append(": ");
    }
    if (bt.isNullOrNil(parama.haq)) {
      if (bt.isNullOrNil(parama.hao)) {
        parama = parama.hal;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.hao;
      continue;
      parama = parama.haq;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> fwL;
    public String dpv;
    public String hai;
    public String haj;
    public String hak;
    public String hal;
    public String ham;
    public String han;
    public String hao;
    public String hap;
    public String haq;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      fwL = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a xB(String paramString)
    {
      AppMethodBeat.i(20471);
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.BrandQALogic", "empty xml to parse");
        AppMethodBeat.o(20471);
        return null;
      }
      int i = paramString.indexOf("<qamsg");
      Object localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      paramString = (a)fwL.get(Integer.valueOf(i));
      if (paramString != null)
      {
        AppMethodBeat.o(20471);
        return paramString;
      }
      paramString = bw.K((String)localObject, "qamsg");
      if (paramString == null)
      {
        ad.e("MicroMsg.BrandQALogic", "parse msg failed");
        AppMethodBeat.o(20471);
        return null;
      }
      try
      {
        localObject = new a();
        ((a)localObject).dpv = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).hai = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).haj = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).hak = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).hal = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).ham = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).han = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).hao = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).ham = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).hap = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).haq = ((String)paramString.get(".qamsg.answer1.content"));
        fwL.o(Integer.valueOf(i), localObject);
        AppMethodBeat.o(20471);
        return localObject;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
        ad.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
        AppMethodBeat.o(20471);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */