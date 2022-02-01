package com.tencent.tmassistantsdk.internal.c;

import com.tencent.tmassistant.common.a;
import com.tencent.tmassistant.common.a.b;
import com.tencent.tmassistant.common.jce.ReportLogRequest;
import com.tencent.tmassistant.common.jce.ReportLogResponse;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistantbase.a.f;
import com.tencent.tmassistantbase.a.k;

public class d
  extends com.tencent.tmassistantbase.network.d
{
  protected c b = null;
  
  public void a(c paramc)
  {
    this.b = paramc;
  }
  
  protected void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2 == null) {
      if (this.b != null) {
        this.b.a(this, false);
      }
    }
    do
    {
      return;
      if (this.b == null) {
        break label177;
      }
      if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 4) || (paramInt != 0)) {
        break;
      }
      paramArrayOfByte2 = a.a(paramArrayOfByte2);
      paramArrayOfByte1 = a.a(((Request)a.a(paramArrayOfByte1, Request.class)).body, ReportLogRequest.class);
    } while ((paramArrayOfByte2 == null) || (paramArrayOfByte2.body == null));
    paramArrayOfByte1 = a.a(paramArrayOfByte1, paramArrayOfByte2.body);
    if ((paramArrayOfByte1 instanceof ReportLogResponse))
    {
      paramArrayOfByte1 = (ReportLogResponse)paramArrayOfByte1;
      if (paramArrayOfByte1.ret == 0)
      {
        this.b.a(this, true);
        return;
      }
      this.b.a(this, false);
      k.c("LogReportHttpRequest", "response ret:" + paramArrayOfByte1.ret);
      return;
    }
    k.c("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
    return;
    this.b.a(this, false);
    return;
    label177:
    k.c("LogReportHttpRequest", "mListener is null !");
  }
  
  public boolean a(byte paramByte, b paramb)
  {
    k.c("LogReportHttpRequest", "sendLogDataToServer logType:" + paramByte + " logDataWrapper:" + paramb);
    if (paramb == null) {
      return false;
    }
    String str = f.b(f.a().b());
    int i = f.c(f.a().b());
    return super.a(a.a(a.b((ReportLogRequest)a.a(paramByte, paramb.b, str, i, ""))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.c.d
 * JD-Core Version:    0.7.0.1
 */