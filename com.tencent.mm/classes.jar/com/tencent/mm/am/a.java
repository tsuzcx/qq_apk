package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class a
{
  private static int hVS = 0;
  private static int hVT = 0;
  
  public static String a(a parama)
  {
    AppMethodBeat.i(20473);
    if (parama == null)
    {
      AppMethodBeat.o(20473);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(bu.nullAsNil(parama.hWc));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bu.nullAsNil(parama.hWa));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bu.nullAsNil(parama.hVX));
    parama = localStringBuilder.toString();
    AppMethodBeat.o(20473);
    return parama;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(20474);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!v.zK(parama.dzZ))
    {
      localStringBuilder.append(parama.hVU);
      localStringBuilder.append(": ");
    }
    if (bu.isNullOrNil(parama.hWc)) {
      if (bu.isNullOrNil(parama.hWa)) {
        parama = parama.hVX;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(20474);
      return parama;
      parama = parama.hWa;
      continue;
      parama = parama.hWc;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> fVO;
    public String dzZ;
    public String hVU;
    public String hVV;
    public String hVW;
    public String hVX;
    public String hVY;
    public String hVZ;
    public String hWa;
    public String hWb;
    public String hWc;
    public String toUser;
    
    static
    {
      AppMethodBeat.i(20472);
      fVO = new c(100);
      AppMethodBeat.o(20472);
    }
    
    public static final a Fi(String paramString)
    {
      AppMethodBeat.i(20471);
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.BrandQALogic", "empty xml to parse");
        AppMethodBeat.o(20471);
        return null;
      }
      int i = paramString.indexOf("<qamsg");
      Object localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      paramString = (a)fVO.get(Integer.valueOf(i));
      if (paramString != null)
      {
        AppMethodBeat.o(20471);
        return paramString;
      }
      paramString = bx.M((String)localObject, "qamsg");
      if (paramString == null)
      {
        ae.e("MicroMsg.BrandQALogic", "parse msg failed");
        AppMethodBeat.o(20471);
        return null;
      }
      try
      {
        localObject = new a();
        ((a)localObject).dzZ = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).hVU = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).hVV = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).hVW = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).hVX = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).hVY = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).hVZ = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).hWa = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).hVY = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).hWb = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).hWc = ((String)paramString.get(".qamsg.answer1.content"));
        fVO.q(Integer.valueOf(i), localObject);
        AppMethodBeat.o(20471);
        return localObject;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
        ae.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
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