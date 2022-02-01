package com.tencent.mm.broadcast;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a
{
  Map<Integer, abh> lvA;
  String lvx;
  long lvy;
  String lvz;
  
  b$a()
  {
    AppMethodBeat.i(20097);
    this.lvx = null;
    this.lvy = 0L;
    this.lvz = null;
    this.lvA = new HashMap();
    AppMethodBeat.o(20097);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20098);
    Object localObject = this.lvA.keySet().iterator();
    Integer localInteger;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
      localInteger = (Integer)((Iterator)localObject).next();
    }
    localObject = str;
    if (str.length() > 0) {
      localObject = str.substring(0, str.length() - 1);
    }
    str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.lvx, Long.valueOf(this.lvy), this.lvz, localObject });
    AppMethodBeat.o(20098);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.broadcast.b.a
 * JD-Core Version:    0.7.0.1
 */