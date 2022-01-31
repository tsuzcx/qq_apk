package com.tencent.mm.plugin.dbbackup;

import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;

final class d$4$1
  implements DBDumpUtil.ExecuteSqlCallback
{
  d$4$1(d.4 param4, int[] paramArrayOfInt) {}
  
  public final String preExecute(String paramString)
  {
    paramString = this.kUt;
    paramString[0] += 1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.4.1
 * JD-Core Version:    0.7.0.1
 */