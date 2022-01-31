package com.tencent.mm.aj;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class a$a
{
  private static final f<Integer, a> dss = new f(100);
  public String bRO;
  public String eig;
  public String eih;
  public String eii;
  public String eij;
  public String eik;
  public String eil;
  public String eim;
  public String ein;
  public String eio;
  public String toUser;
  
  public static final a lC(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.BrandQALogic", "empty xml to parse");
      paramString = null;
    }
    int i;
    Object localObject;
    a locala;
    do
    {
      return paramString;
      i = paramString.indexOf("<qamsg");
      localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      locala = (a)dss.get(Integer.valueOf(i));
      paramString = locala;
    } while (locala != null);
    paramString = bn.s((String)localObject, "qamsg");
    if (paramString == null)
    {
      y.e("MicroMsg.BrandQALogic", "parse msg failed");
      return null;
    }
    try
    {
      localObject = new a();
      ((a)localObject).bRO = ((String)paramString.get(".qamsg.$fromUser"));
      ((a)localObject).eig = ((String)paramString.get(".qamsg.$fromNickname"));
      ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
      ((a)localObject).eih = ((String)paramString.get(".qamsg.question.$id"));
      ((a)localObject).eii = ((String)paramString.get(".qamsg.question.$fromUser"));
      ((a)localObject).eij = ((String)paramString.get(".qamsg.question.content"));
      ((a)localObject).eik = ((String)paramString.get(".qamsg.answer.$id"));
      ((a)localObject).eil = ((String)paramString.get(".qamsg.answer.$fromUser"));
      ((a)localObject).eim = ((String)paramString.get(".qamsg.answer.content"));
      ((a)localObject).eik = ((String)paramString.get(".qamsg.answer1.$id"));
      ((a)localObject).ein = ((String)paramString.get(".qamsg.answer1.$fromUser"));
      ((a)localObject).eio = ((String)paramString.get(".qamsg.answer1.content"));
      dss.f(Integer.valueOf(i), localObject);
      return localObject;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
      y.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a.a
 * JD-Core Version:    0.7.0.1
 */