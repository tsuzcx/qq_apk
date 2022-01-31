package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;

public abstract class h
  extends a
{
  private WeakReference<l> mPj;
  public i mSJ;
  public j mSK;
  
  public h(i parami)
  {
    this.mSJ = parami;
    this.mPj = new WeakReference(parami.mSU);
    this.mSJ.mSU = null;
  }
  
  protected void a(j paramj)
  {
    paramj.mRX = g.aU(this.mSJ.query, false);
    paramj.bpE = -5;
  }
  
  public final boolean execute()
  {
    Object localObject1 = this.mSJ;
    if (!bo.isNullOrNil(((i)localObject1).query)) {}
    try
    {
      ((i)localObject1).query = new String(((i)localObject1).query.getBytes("UTF8"), "UTF8");
      label37:
      this.mSK = new j(this.mSJ);
      try
      {
        this.mSK.mSV = this;
        a(this.mSK);
        this.mSK.bpE = 0;
        if (this.mSJ.handler == null)
        {
          localObject1 = (l)this.mPj.get();
          if (localObject1 != null) {
            ((l)localObject1).b(this.mSK);
          }
          return true;
        }
        this.mSJ.handler.post(new h.1(this));
        return true;
      }
      catch (Exception localException)
      {
        if ((localException instanceof InterruptedException))
        {
          this.mSK.bpE = 1;
          throw localException;
        }
      }
      finally
      {
        if (this.mSJ.handler == null)
        {
          l locall = (l)this.mPj.get();
          if (locall != null) {
            locall.b(this.mSK);
          }
        }
        for (;;)
        {
          throw localObject2;
          this.mSK.bpE = -1;
          break;
          this.mSJ.handler.post(new h.1(this));
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