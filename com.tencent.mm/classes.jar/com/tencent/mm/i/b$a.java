package com.tencent.mm.i;

import com.tencent.mm.h.a.sh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b$a
{
  String dkI = null;
  long dkJ = 0L;
  String dkK = null;
  Map<Integer, sh> dkL = new HashMap();
  
  public final String toString()
  {
    Object localObject = this.dkL.keySet().iterator();
    Integer localInteger;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
      localInteger = (Integer)((Iterator)localObject).next();
    }
    localObject = str;
    if (str.length() > 0) {
      localObject = str.substring(0, str.length() - 1);
    }
    return String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.dkI, Long.valueOf(this.dkJ), this.dkK, localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.i.b.a
 * JD-Core Version:    0.7.0.1
 */