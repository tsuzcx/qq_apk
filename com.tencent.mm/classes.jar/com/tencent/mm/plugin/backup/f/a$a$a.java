package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

final class a$a$a
{
  Map<String, String> hJO = null;
  boolean hJP = true;
  
  public a$a$a(String paramString)
  {
    this.hJO = ba.Zx(paramString);
    if (this.hJO == null)
    {
      this.hJP = false;
      this.hJO = new HashMap();
    }
  }
  
  final int getInt(String paramString)
  {
    if (!this.hJO.containsKey(paramString)) {
      return 0;
    }
    return bk.getInt((String)this.hJO.get(paramString), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a.a
 * JD-Core Version:    0.7.0.1
 */