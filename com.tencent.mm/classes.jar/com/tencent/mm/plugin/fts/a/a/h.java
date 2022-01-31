package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class h
  extends a
{
  private WeakReference<l> ktv;
  public i kwT;
  public j kwU;
  
  public h(i parami)
  {
    this.kwT = parami;
    this.ktv = new WeakReference(parami.kxf);
    this.kwT.kxf = null;
  }
  
  public void a(j paramj)
  {
    paramj.kwi = g.aF(this.kwT.bVk, false);
    paramj.aYY = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.kwT;
    if (!bk.bl(((i)localObject1).bVk)) {}
    try
    {
      ((i)localObject1).bVk = new String(((i)localObject1).bVk.getBytes("UTF8"), "UTF8");
      label37:
      this.kwU = new j(this.kwT);
      try
      {
        this.kwU.kxg = this;
        a(this.kwU);
        this.kwU.aYY = 0;
        if (this.kwT.handler == null)
        {
          localObject1 = (l)this.ktv.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.kwU);
          }
          return true;
        }
        this.kwT.handler.post(new h.1(this));
        return true;
      }
      catch (Exception localException)
      {
        if ((localException instanceof InterruptedException))
        {
          this.kwU.aYY = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.kwT.handler == null)
        {
          l locall = (l)this.ktv.get();
          if (locall != null) {
            locall.b(this.kwU);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.kwU.aYY = -1;
          break;
          this.kwT.handler.post(new h.1(this));
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.h
 * JD-Core Version:    0.7.0.1
 */