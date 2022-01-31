package com.tencent.mm.plugin.brandservice.ui.timeline.a.a;

import com.tencent.mm.h.c.x;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends x
{
  public static c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appMsgContextId";
    locala.ujN.put("appMsgContextId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appMsgContextId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appMsgContextId";
    locala.columns[1] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.ujN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "invalidTime";
    locala.ujN.put("invalidTime", "LONG");
    localStringBuilder.append(" invalidTime LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "forceUrl";
    locala.ujN.put("forceUrl", "TEXT");
    localStringBuilder.append(" forceUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "lastModifyTime";
    locala.ujN.put("lastModifyTime", "INTEGER");
    localStringBuilder.append(" lastModifyTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "tmplVersion";
    locala.ujN.put("tmplVersion", "INTEGER");
    localStringBuilder.append(" tmplVersion INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  public a() {}
  
  public a(do paramdo)
  {
    this.field_appMsgContextId = paramdo.kSC.hashCode();
    this.field_url = paramdo.kSC;
    this.field_content = paramdo.kVs;
    this.field_invalidTime = (System.nanoTime() + paramdo.swX * 1000);
    this.field_forceUrl = paramdo.swY;
    this.field_lastModifyTime = paramdo.swZ;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
  
  public final String toString()
  {
    return "BizAppMsgContext{field_appMsgContextId=" + this.field_appMsgContextId + ", field_url='" + this.field_url + '\'' + ", field_content='" + this.field_content + '\'' + ", field_invalidTime=" + this.field_invalidTime + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a
 * JD-Core Version:    0.7.0.1
 */