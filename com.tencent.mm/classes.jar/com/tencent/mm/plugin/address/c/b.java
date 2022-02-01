package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements f
{
  HashSet<n> jrG;
  HashSet<n> jrH;
  private a jrV;
  private Set<Integer> jrW;
  private Context mContext;
  Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.jrV = null;
    this.jrG = new HashSet();
    this.jrH = new HashSet();
    this.tipDialog = null;
    this.jrW = new HashSet();
    this.mContext = paramContext;
    this.jrV = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.jrW.add(Integer.valueOf(paramInt));
    ba.aiU().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void doSceneProgress(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(193139);
    ad.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    this.jrH.add(paramn);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.b(this.mContext, "", true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(20819);
          if ((b.this.tipDialog != null) && (b.this.jrG.isEmpty()))
          {
            b.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = b.this.jrH.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              ba.aiU().a(localn);
            }
            b.this.jrH.clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    ba.aiU().a(paramn, 0);
    AppMethodBeat.o(193139);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.jrH.contains(paramn))
    {
      this.jrH.remove(paramn);
      ad.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.jrH.isEmpty()) && (this.jrG.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.jrV != null)) {
        this.jrV.c(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.jrG.contains(paramn))
      {
        this.jrG.remove(paramn);
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
    ba.aiU().b(paramInt, this);
    this.jrW.remove(Integer.valueOf(paramInt));
    if (this.jrW.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.jrG.iterator();
      n localn;
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        ba.aiU().a(localn);
      }
      localIterator = this.jrH.iterator();
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        ba.aiU().a(localn);
      }
      this.jrG.clear();
      this.jrH.clear();
      this.jrV = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */