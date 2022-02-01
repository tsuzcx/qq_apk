package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class i
  extends a
{
  private WeakReference<l> tCn;
  public j tFP;
  public k tFQ;
  
  public i(j paramj)
  {
    this.tFP = paramj;
    this.tCn = new WeakReference(paramj.tGa);
    this.tFP.tGa = null;
  }
  
  protected void a(k paramk)
  {
    paramk.tFe = h.bq(this.tFP.query, false);
    paramk.bZU = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.tFP;
    if (!bu.isNullOrNil(((j)localObject1).query)) {}
    try
    {
      ((j)localObject1).query = new String(((j)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.tFQ = new k(this.tFP);
      try
      {
        this.tFQ.tGb = this;
        a(this.tFQ);
        this.tFQ.bZU = 0;
        if (this.tFP.handler == null)
        {
          localObject1 = (l)this.tCn.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.tFQ);
          }
          return true;
        }
        this.tFP.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131702);
            l locall = (l)i.a(i.this).get();
            if (locall != null) {
              locall.b(i.b(i.this));
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
          this.tFQ.bZU = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.tFP.handler == null)
        {
          l locall = (l)this.tCn.get();
          if (locall != null) {
            locall.b(this.tFQ);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.tFQ.bZU = -1;
          break;
          this.tFP.handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131702);
              l locall = (l)i.a(i.this).get();
              if (locall != null) {
                locall.b(i.b(i.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.i
 * JD-Core Version:    0.7.0.1
 */