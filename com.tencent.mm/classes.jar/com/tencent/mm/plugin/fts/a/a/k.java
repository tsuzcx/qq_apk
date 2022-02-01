package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class k
  extends c
{
  private WeakReference<com.tencent.mm.plugin.fts.a.l> HpN;
  public l Htr;
  public m Hts;
  
  public k(l paraml)
  {
    this.Htr = paraml;
    this.HpN = new WeakReference(paraml.HtC);
    this.Htr.HtC = null;
  }
  
  protected void a(m paramm)
  {
    paramm.FWt = j.cc(this.Htr.query, false);
    paramm.resultCode = -5;
  }
  
  public final boolean aXz()
  {
    Object localObject1 = this.Htr;
    if (!Util.isNullOrNil(((l)localObject1).query)) {}
    try
    {
      ((l)localObject1).query = new String(((l)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.Hts = new m(this.Htr);
      try
      {
        this.Hts.HtE = this;
        a(this.Hts);
        this.Hts.resultCode = 0;
        if (this.Htr.handler == null)
        {
          localObject1 = (com.tencent.mm.plugin.fts.a.l)this.HpN.get();
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.fts.a.l)localObject1).b(this.Hts);
          }
          return true;
        }
        this.Htr.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131702);
            com.tencent.mm.plugin.fts.a.l locall = (com.tencent.mm.plugin.fts.a.l)k.a(k.this).get();
            if (locall != null) {
              locall.b(k.b(k.this));
            }
            AppMethodBeat.o(131702);
          }
        });
        return true;
      }
      catch (Exception localException)
      {
        if ((localException instanceof InterruptedException))
        {
          this.Hts.resultCode = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.Htr.handler == null)
        {
          com.tencent.mm.plugin.fts.a.l locall = (com.tencent.mm.plugin.fts.a.l)this.HpN.get();
          if (locall != null) {
            locall.b(this.Hts);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.Hts.resultCode = -1;
          break;
          this.Htr.handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131702);
              com.tencent.mm.plugin.fts.a.l locall = (com.tencent.mm.plugin.fts.a.l)k.a(k.this).get();
              if (locall != null) {
                locall.b(k.b(k.this));
              }
              AppMethodBeat.o(131702);
            }
          });
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.k
 * JD-Core Version:    0.7.0.1
 */