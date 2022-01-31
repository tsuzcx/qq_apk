package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class c$e
  extends a
{
  private List<bi> kzj = new ArrayList();
  private StringBuffer kzk;
  
  public c$e(List<bi> paramList)
  {
    Collection localCollection;
    this.kzj.addAll(localCollection);
    this.kzk = new StringBuffer();
  }
  
  public final String afJ()
  {
    return this.kzk.toString();
  }
  
  public final boolean execute()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.kzj.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bi)((Iterator)localObject2).next();
      c.f localf = new c.f(this.kze, (byte)0);
      localf.bIt = ((cs)localObject3).field_msgId;
      localf.talker = ((cs)localObject3).field_talker;
      localf.createTime = ((cs)localObject3).field_createTime;
      localf.content = ((cs)localObject3).field_content;
      localf.msgType = ((bi)localObject3).getType();
      localf.kzm = ((cs)localObject3).field_isSend;
      if (c.a(localf))
      {
        localf.aVN();
        if (localf.isAvailable()) {
          ((List)localObject1).add(localf);
        }
      }
    }
    this.kzk.append("{MsgId: ");
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c.f)((Iterator)localObject2).next();
      this.kzk.append(((c.f)localObject3).bIt);
      this.kzk.append(",");
      this.kzk.append(((c.f)localObject3).talker);
      this.kzk.append(",");
      this.kzk.append(((c.f)localObject3).createTime);
      this.kzk.append(" ");
    }
    this.kzk.append("count: ");
    this.kzk.append(((List)localObject1).size());
    this.kzk.append("}");
    if (((List)localObject1).size() > 0)
    {
      this.kze.kyW.beginTransaction();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c.f)((Iterator)localObject1).next();
        this.kze.kyW.a(((c.f)localObject2).kzl, ((c.f)localObject2).bIt, ((c.f)localObject2).talker, ((c.f)localObject2).createTime, ((c.f)localObject2).kzn, ((c.f)localObject2).kzo);
      }
      this.kze.kyW.commit();
    }
    return true;
  }
  
  public final String getName()
  {
    return "InsertMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.e
 * JD-Core Version:    0.7.0.1
 */