package com.tencent.mm.aa.c;

import com.tencent.mm.aa.b.d;
import com.tencent.mm.aa.d.a;
import java.util.HashMap;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f
{
  public a dIP;
  public d dJa;
  public g dJd;
  
  public f(d paramd, g paramg, a parama)
  {
    Assert.assertNotNull(paramd);
    Assert.assertNotNull(paramg);
    Assert.assertNotNull(parama);
    this.dJa = paramd;
    this.dJd = paramg;
    this.dIP = parama;
  }
  
  public static String CG()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aa.c.f
 * JD-Core Version:    0.7.0.1
 */