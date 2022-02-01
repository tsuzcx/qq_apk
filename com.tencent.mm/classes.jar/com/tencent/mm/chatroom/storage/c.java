package com.tencent.mm.chatroom.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.eb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends eb
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public List<Long> lzA;
  
  static
  {
    AppMethodBeat.i(182138);
    info = eb.aJm();
    AppMethodBeat.o(182138);
  }
  
  public c()
  {
    AppMethodBeat.i(182132);
    this.lzA = new ArrayList();
    AppMethodBeat.o(182132);
  }
  
  public final long aMf()
  {
    AppMethodBeat.i(182135);
    if (this.lzA.size() > 0)
    {
      long l = ((Long)this.lzA.get(0)).longValue();
      AppMethodBeat.o(182135);
      return l;
    }
    AppMethodBeat.o(182135);
    return 0L;
  }
  
  public final boolean aMg()
  {
    AppMethodBeat.i(182136);
    boolean bool = Util.isEqual("roomannouncement@app.origin", this.field_username);
    AppMethodBeat.o(182136);
    return bool;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(182133);
    super.convertFrom(paramCursor);
    this.lzA.clear();
    if (!Util.isNullOrNil(this.field_related_msgids))
    {
      paramCursor = this.field_related_msgids.split(",");
      int j = paramCursor.length;
      int i = 0;
      while (i < j)
      {
        String str = paramCursor[i];
        this.lzA.add(Long.valueOf(Long.parseLong(str)));
        i += 1;
      }
    }
    AppMethodBeat.o(182133);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(182134);
    paramObject = (c)paramObject;
    if ((Util.isEqual(paramObject.field_todoid, this.field_todoid)) && (Util.isEqual(paramObject.field_roomname, this.field_roomname)))
    {
      AppMethodBeat.o(182134);
      return true;
    }
    AppMethodBeat.o(182134);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final void hk(long paramLong)
  {
    AppMethodBeat.i(241398);
    if (!this.lzA.contains(Long.valueOf(paramLong)))
    {
      this.lzA.add(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.lzA.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    AppMethodBeat.o(241398);
  }
  
  public final boolean hl(long paramLong)
  {
    AppMethodBeat.i(182137);
    if (this.lzA.contains(Long.valueOf(paramLong)))
    {
      this.lzA.remove(Long.valueOf(paramLong));
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.lzA.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((Long)localIterator.next()).longValue()).append(",");
      }
      if (localStringBuilder.length() - 1 >= 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      this.field_related_msgids = localStringBuilder.toString();
    }
    if (this.lzA.size() == 0)
    {
      AppMethodBeat.o(182137);
      return true;
    }
    AppMethodBeat.o(182137);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.storage.c
 * JD-Core Version:    0.7.0.1
 */