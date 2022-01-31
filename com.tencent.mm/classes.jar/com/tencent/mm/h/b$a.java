package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a
{
  String ecc;
  long ecd;
  String ece;
  Map<Integer, tz> ecf;
  
  b$a()
  {
    AppMethodBeat.i(16064);
    this.ecc = null;
    this.ecd = 0L;
    this.ece = null;
    this.ecf = new HashMap();
    AppMethodBeat.o(16064);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(16065);
    Object localObject = this.ecf.keySet().iterator();
    Integer localInteger;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
      localInteger = (Integer)((Iterator)localObject).next();
    }
    localObject = str;
    if (str.length() > 0) {
      localObject = str.substring(0, str.length() - 1);
    }
    str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.ecc, Long.valueOf(this.ecd), this.ece, localObject });
    AppMethodBeat.o(16065);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.b.a
 * JD-Core Version:    0.7.0.1
 */