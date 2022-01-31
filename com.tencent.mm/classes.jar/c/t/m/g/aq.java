package c.t.m.g;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public final class aq
  extends aw
{
  public final boolean a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, aw.a parama)
  {
    long l = SystemClock.elapsedRealtime();
    this.b = parama;
    this.a = paramObject;
    parama = new HashMap();
    parama.put("B-Length", String.valueOf(paramInt));
    if (paramBoolean) {}
    for (paramObject = "realtime_speed";; paramObject = "hllog")
    {
      parama.put("HLReportCmd", paramObject);
      paramArrayOfByte = ak.a("https://up-hl.3g.qq.com/upreport", parama, paramArrayOfByte, 20000, cm.d());
      paramArrayOfByte.p = "event";
      paramArrayOfByte = new ar(this, paramArrayOfByte, l);
      try
      {
        aa.a.a().a.execute(paramArrayOfByte);
        return true;
      }
      catch (Throwable paramArrayOfByte)
      {
        this.b.a(false, this.a);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.aq
 * JD-Core Version:    0.7.0.1
 */