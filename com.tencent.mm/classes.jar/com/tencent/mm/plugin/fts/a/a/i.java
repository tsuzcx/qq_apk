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
  private WeakReference<l> trw;
  public j tuY;
  public k tuZ;
  
  public i(j paramj)
  {
    this.tuY = paramj;
    this.trw = new WeakReference(paramj.tvj);
    this.tuY.tvj = null;
  }
  
  protected void a(k paramk)
  {
    paramk.tun = h.bn(this.tuY.query, false);
    paramk.bZU = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.tuY;
    if (!bt.isNullOrNil(((j)localObject1).query)) {}
    try
    {
      ((j)localObject1).query = new String(((j)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.tuZ = new k(this.tuY);
      try
      {
        this.tuZ.tvk = this;
        a(this.tuZ);
        this.tuZ.bZU = 0;
        if (this.tuY.handler == null)
        {
          localObject1 = (l)this.trw.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.tuZ);
          }
          return true;
        }
        this.tuY.handler.post(new Runnable()
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
          this.tuZ.bZU = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.tuY.handler == null)
        {
          l locall = (l)this.trw.get();
          if (locall != null) {
            locall.b(this.tuZ);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.tuZ.bZU = -1;
          break;
          this.tuY.handler.post(new Runnable()
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