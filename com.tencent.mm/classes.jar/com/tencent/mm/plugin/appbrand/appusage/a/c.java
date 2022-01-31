package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public class c
  extends i<b>
{
  public static final String[] dUb = { i.a(b.buS, "AppBrandRecommendWxa") };
  public e dXw;
  
  public c(e parame)
  {
    super(parame, b.buS, "AppBrandRecommendWxa", null);
    this.dXw = parame;
  }
  
  public final void t(LinkedList<bjt> paramLinkedList)
  {
    y.i("MicroMsg.AppBrandRecommendWxaStorage", "addRecommendWxaList()");
    Object localObject = new LinkedList();
    ((LinkedList)localObject).addAll(paramLinkedList);
    paramLinkedList = ((LinkedList)localObject).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject = (bjt)paramLinkedList.next();
      b localb = new b();
      localb.field_appId = ((bjt)localObject).bOL;
      localb.field_userName = ((bjt)localObject).username;
      localb.field_nickName = ((bjt)localObject).nickname;
      localb.field_logo = ((bjt)localObject).mTc;
      localb.field_sessionId = ((bjt)localObject).bah;
      localb.field_descInfo = ((bjt)localObject).tDy;
      localb.field_evaluateScore = ((bjt)localObject).tDz;
      localb.field_words = ((bjt)localObject).tDB;
      localb.field_recommendWxa = ((bjt)localObject);
      b(localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.c
 * JD-Core Version:    0.7.0.1
 */