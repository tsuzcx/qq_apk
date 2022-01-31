package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class c$c
  extends a
{
  private List<bi> mUZ;
  private StringBuffer mVa;
  
  public c$c(List<bi> paramList)
  {
    AppMethodBeat.i(136750);
    this.mUZ = new ArrayList();
    Collection localCollection;
    this.mUZ.addAll(localCollection);
    this.mVa = new StringBuffer();
    AppMethodBeat.o(136750);
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136752);
    String str = this.mVa.toString();
    AppMethodBeat.o(136752);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136751);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.mUZ.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bi)((Iterator)localObject2).next();
      c.d locald = new c.d(this.mUU, (byte)0);
      locald.cpO = ((dd)localObject3).field_msgId;
      locald.talker = ((dd)localObject3).field_talker;
      locald.createTime = ((dd)localObject3).field_createTime;
      locald.content = ((dd)localObject3).field_content;
      locald.msgType = ((bi)localObject3).getType();
      locald.mVc = ((dd)localObject3).field_isSend;
      if (c.a(locald))
      {
        locald.bCq();
        if (locald.isAvailable()) {
          ((List)localObject1).add(locald);
        }
      }
    }
    this.mVa.append("{MsgId: ");
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (c.d)((Iterator)localObject2).next();
      this.mVa.append(((c.d)localObject3).cpO);
      this.mVa.append(",");
      this.mVa.append(((c.d)localObject3).talker);
      this.mVa.append(",");
      this.mVa.append(((c.d)localObject3).createTime);
      this.mVa.append(" ");
    }
    this.mVa.append("count: ");
    this.mVa.append(((List)localObject1).size());
    this.mVa.append("}");
    if (((List)localObject1).size() > 0)
    {
      this.mUU.mUM.beginTransaction();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c.d)((Iterator)localObject1).next();
        this.mUU.mUM.a(((c.d)localObject2).mVb, ((c.d)localObject2).cpO, ((c.d)localObject2).talker, ((c.d)localObject2).createTime, ((c.d)localObject2).mVd, ((c.d)localObject2).mVe);
      }
      this.mUU.mUM.commit();
    }
    AppMethodBeat.o(136751);
    return true;
  }
  
  public final String getName()
  {
    return "InsertMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.c
 * JD-Core Version:    0.7.0.1
 */