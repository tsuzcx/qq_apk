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
  private static int hTa = 0;
  private static int hTb = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(bt.nullAsNil(parama.hTk));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bt.nullAsNil(parama.hTi));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bt.nullAsNil(parama.hTf));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!u.za(parama.dyU))
    {
      localStringBuilder.append(parama.hTc);
      localStringBuilder.append(": ");
    }
    if (bt.isNullOrNil(parama.hTk)) {
      if (bt.isNullOrNil(parama.hTi)) {
        parama = parama.hTf;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.hTi;
      continue;
      parama = parama.hTk;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> fTI;
    public String dyU;
    public String hTc;
    public String hTd;
    public String hTe;
    public String hTf;
    public String hTg;
    public String hTh;
    public String hTi;
    public String hTj;
    public String hTk;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      fTI = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a EG(String paramString)
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
      paramString = (a)fTI.get(Integer.valueOf(i));
      if (paramString != null)
      {
        AppMethodBeat.o(20471);
        return paramString;
      }
      paramString = bw.M((String)localObject, "qamsg");
      if (paramString == null)
      {
        ad.e("MicroMsg.BrandQALogic", "parse msg failed");
        AppMethodBeat.o(20471);
        return null;
      }
      try
      {
        localObject = new a();
        ((a)localObject).dyU = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).hTc = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).hTd = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).hTe = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).hTf = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).hTg = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).hTh = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).hTi = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).hTg = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).hTj = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).hTk = ((String)paramString.get(".qamsg.answer1.content"));
        fTI.q(Integer.valueOf(i), localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */