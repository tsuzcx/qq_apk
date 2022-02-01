package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class i
  extends a
{
  private WeakReference<l> suV;
  public j syx;
  public k syy;
  
  public i(j paramj)
  {
    this.syx = paramj;
    this.suV = new WeakReference(paramj.syI);
    this.syx.syI = null;
  }
  
  protected void a(k paramk)
  {
    paramk.sxM = h.bi(this.syx.query, false);
    paramk.bPH = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.syx;
    if (!bs.isNullOrNil(((j)localObject1).query)) {}
    try
    {
      ((j)localObject1).query = new String(((j)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.syy = new k(this.syx);
      try
      {
        this.syy.syJ = this;
        a(this.syy);
        this.syy.bPH = 0;
        if (this.syx.handler == null)
        {
          localObject1 = (l)this.suV.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.syy);
          }
          return true;
        }
        this.syx.handler.post(new Runnable()
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
          this.syy.bPH = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.syx.handler == null)
        {
          l locall = (l)this.suV.get();
          if (locall != null) {
            locall.b(this.syy);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.syy.bPH = -1;
          break;
          this.syx.handler.post(new Runnable()
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