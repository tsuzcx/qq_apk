package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements g
{
  private a iyJ;
  private Set<Integer> iyK;
  HashSet<n> iyu;
  HashSet<n> iyv;
  private Context mContext;
  Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.iyJ = null;
    this.iyu = new HashSet();
    this.iyv = new HashSet();
    this.tipDialog = null;
    this.iyK = new HashSet();
    this.mContext = paramContext;
    this.iyJ = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.iyK.add(Integer.valueOf(paramInt));
    az.aeS().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void e(n paramn)
  {
    AppMethodBeat.i(20821);
    ad.d("MicroMsg.WalletNetSceneMgr", "isShowProgress true");
    this.iyv.add(paramn);
    if ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing())))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.b(this.mContext, "", true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(20819);
          if ((b.this.tipDialog != null) && (b.this.iyu.isEmpty()))
          {
            b.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = b.this.iyv.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              az.aeS().a(localn);
            }
            b.this.iyv.clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    az.aeS().a(paramn, 0);
    AppMethodBeat.o(20821);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.iyv.contains(paramn))
    {
      this.iyv.remove(paramn);
      ad.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.iyv.isEmpty()) && (this.iyu.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.iyJ != null)) {
        this.iyJ.c(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.iyu.contains(paramn))
      {
        this.iyu.remove(paramn);
        ad.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20823);
    az.aeS().b(paramInt, this);
    this.iyK.remove(Integer.valueOf(paramInt));
    if (this.iyK.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.iyu.iterator();
      n localn;
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        az.aeS().a(localn);
      }
      localIterator = this.iyv.iterator();
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        az.aeS().a(localn);
      }
      this.iyu.clear();
      this.iyv.clear();
      this.iyJ = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */