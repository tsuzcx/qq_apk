package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  private n eRh;
  private o eRi;
  private p eRj;
  private l eRk;
  private m eRl;
  private k eRm;
  
  private static void a(d paramd)
  {
    if (paramd != null)
    {
      Iterator localIterator = paramd.eRn.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        g.Dk().b(localInteger.intValue(), paramd);
      }
      paramd.activity = null;
    }
  }
  
  public final boolean a(Activity paramActivity, ag paramag)
  {
    if ((paramag.type == 0) || (paramag.action == 0)) {
      return false;
    }
    if (this.eRm == null) {
      this.eRm = new k(paramActivity);
    }
    if (this.eRm.a(paramag)) {
      return true;
    }
    switch (paramag.type)
    {
    default: 
      y.e("MicroMsg.BaseErrorHelper", "Unkown error type");
      return false;
    case 1: 
      if (this.eRh == null) {
        this.eRh = new n(paramActivity);
      }
      this.eRh.a(paramag);
      return false;
    case 2: 
      if (this.eRi == null) {
        this.eRi = new o(paramActivity);
      }
      this.eRi.a(paramag);
      return false;
    case 3: 
      if (this.eRj == null) {
        this.eRj = new p(paramActivity);
      }
      this.eRj.a(paramag);
      return false;
    case 4: 
      if (this.eRk == null) {
        this.eRk = new l(paramActivity);
      }
      this.eRk.a(paramag);
      return false;
    case 5: 
      if (this.eRl == null) {
        this.eRl = new m(paramActivity);
      }
      this.eRl.a(paramag);
      return false;
    }
    if (this.eRm == null) {
      this.eRm = new k(paramActivity);
    }
    this.eRm.a(paramag);
    return false;
  }
  
  public final void close()
  {
    a(this.eRh);
    a(this.eRi);
    a(this.eRj);
    a(this.eRk);
    a(this.eRl);
    a(this.eRm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.platformtools.c
 * JD-Core Version:    0.7.0.1
 */