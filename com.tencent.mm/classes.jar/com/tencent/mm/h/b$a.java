package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a
{
  String iTs;
  long iTt;
  String iTu;
  Map<Integer, zn> iTv;
  
  b$a()
  {
    AppMethodBeat.i(20097);
    this.iTs = null;
    this.iTt = 0L;
    this.iTu = null;
    this.iTv = new HashMap();
    AppMethodBeat.o(20097);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20098);
    Object localObject = this.iTv.keySet().iterator();
    Integer localInteger;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
      localInteger = (Integer)((Iterator)localObject).next();
    }
    localObject = str;
    if (str.length() > 0) {
      localObject = str.substring(0, str.length() - 1);
    }
    str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.iTs, Long.valueOf(this.iTt), this.iTu, localObject });
    AppMethodBeat.o(20098);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.b.a
 * JD-Core Version:    0.7.0.1
 */