package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends d
  implements Runnable
{
  private final int fCb;
  private final String fCc;
  private final c fCd = new k.1(this);
  private final c fCe = new k.2(this);
  final c fCf = new k.3(this);
  
  public k(int paramInt, String paramString)
  {
    super("LibIncrementalTestCase", Looper.getMainLooper());
    this.fCb = paramInt;
    this.fCc = paramString;
  }
  
  protected final void abD()
  {
    super.abD();
    y.i("MicroMsg.LibIncrementalTestCase[incremental]", "TestCase onQuitting");
  }
  
  public final void run()
  {
    a(this.fCd);
    a(this.fCe);
    a(this.fCf);
    b(this.fCd);
    start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k
 * JD-Core Version:    0.7.0.1
 */