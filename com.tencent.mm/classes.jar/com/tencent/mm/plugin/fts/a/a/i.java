package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class i
  extends a
{
  private WeakReference<l> rmb;
  public j rpD;
  public k rpE;
  
  public i(j paramj)
  {
    this.rpD = paramj;
    this.rmb = new WeakReference(paramj.rpO);
    this.rpD.rpO = null;
  }
  
  protected void a(k paramk)
  {
    paramk.roS = h.bc(this.rpD.query, false);
    paramk.bRZ = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.rpD;
    if (!bt.isNullOrNil(((j)localObject1).query)) {}
    try
    {
      ((j)localObject1).query = new String(((j)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.rpE = new k(this.rpD);
      try
      {
        this.rpE.rpP = this;
        a(this.rpE);
        this.rpE.bRZ = 0;
        if (this.rpD.handler == null)
        {
          localObject1 = (l)this.rmb.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.rpE);
          }
          return true;
        }
        this.rpD.handler.post(new Runnable()
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
          this.rpE.bRZ = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.rpD.handler == null)
        {
          l locall = (l)this.rmb.get();
          if (locall != null) {
            locall.b(this.rpE);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.rpE.bRZ = -1;
          break;
          this.rpD.handler.post(new Runnable()
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