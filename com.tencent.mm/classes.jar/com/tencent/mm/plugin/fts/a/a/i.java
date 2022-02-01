package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class i
  extends a
{
  private WeakReference<l> wTo;
  public j wWO;
  public k wWP;
  
  public i(j paramj)
  {
    this.wWO = paramj;
    this.wTo = new WeakReference(paramj.wWZ);
    this.wWO.wWZ = null;
  }
  
  protected void a(k paramk)
  {
    paramk.wWd = h.bE(this.wWO.query, false);
    paramk.resultCode = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.wWO;
    if (!Util.isNullOrNil(((j)localObject1).query)) {}
    try
    {
      ((j)localObject1).query = new String(((j)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.wWP = new k(this.wWO);
      try
      {
        this.wWP.wXa = this;
        a(this.wWP);
        this.wWP.resultCode = 0;
        if (this.wWO.handler == null)
        {
          localObject1 = (l)this.wTo.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.wWP);
          }
          return true;
        }
        this.wWO.handler.post(new Runnable()
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
          this.wWP.resultCode = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.wWO.handler == null)
        {
          l locall = (l)this.wTo.get();
          if (locall != null) {
            locall.b(this.wWP);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.wWP.resultCode = -1;
          break;
          this.wWO.handler.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.i
 * JD-Core Version:    0.7.0.1
 */