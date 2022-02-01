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
  private WeakReference<l> BFl;
  public j BIJ;
  public k BIK;
  
  public i(j paramj)
  {
    this.BIJ = paramj;
    this.BFl = new WeakReference(paramj.BIU);
    this.BIJ.BIU = null;
  }
  
  protected void a(k paramk)
  {
    paramk.BHY = h.bJ(this.BIJ.query, false);
    paramk.resultCode = -5;
  }
  
  public final boolean aEv()
  {
    Object localObject1 = this.BIJ;
    if (!Util.isNullOrNil(((j)localObject1).query)) {}
    try
    {
      ((j)localObject1).query = new String(((j)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.BIK = new k(this.BIJ);
      try
      {
        this.BIK.BIV = this;
        a(this.BIK);
        this.BIK.resultCode = 0;
        if (this.BIJ.handler == null)
        {
          localObject1 = (l)this.BFl.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.BIK);
          }
          return true;
        }
        this.BIJ.handler.post(new Runnable()
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
          this.BIK.resultCode = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.BIJ.handler == null)
        {
          l locall = (l)this.BFl.get();
          if (locall != null) {
            locall.b(this.BIK);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.BIK.resultCode = -1;
          break;
          this.BIJ.handler.post(new Runnable()
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