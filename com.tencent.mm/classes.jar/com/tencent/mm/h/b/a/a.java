package com.tencent.mm.h.b.a;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public String cfA = "";
  public long cfv = 0L;
  public int cfw = 0;
  public long cfx = 0L;
  private int cfy = 0;
  private String cfz = "";
  
  public final int getId()
  {
    return 15894;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cfv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfA);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("action:").append(this.cfv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("action_result:").append(this.cfw);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("action_code:").append(this.cfx);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("session:").append(this.cfy);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("action_ext:").append(this.cfz);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("session2:").append(this.cfA);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.a
 * JD-Core Version:    0.7.0.1
 */