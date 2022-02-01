package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements g
{
  private a iYM;
  private Set<Integer> iYN;
  HashSet<n> iYx;
  HashSet<n> iYy;
  private Context mContext;
  Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.iYM = null;
    this.iYx = new HashSet();
    this.iYy = new HashSet();
    this.tipDialog = null;
    this.iYN = new HashSet();
    this.mContext = paramContext;
    this.iYM = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.iYN.add(Integer.valueOf(paramInt));
    az.agi().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void doSceneProgress(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(195956);
    ac.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    this.iYy.add(paramn);
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
          if ((b.this.tipDialog != null) && (b.this.iYx.isEmpty()))
          {
            b.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = b.this.iYy.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              az.agi().a(localn);
            }
            b.this.iYy.clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    az.agi().a(paramn, 0);
    AppMethodBeat.o(195956);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.iYy.contains(paramn))
    {
      this.iYy.remove(paramn);
      ac.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.iYy.isEmpty()) && (this.iYx.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.iYM != null)) {
        this.iYM.c(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.iYx.contains(paramn))
      {
        this.iYx.remove(paramn);
        ac.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
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
    az.agi().b(paramInt, this);
    this.iYN.remove(Integer.valueOf(paramInt));
    if (this.iYN.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.iYx.iterator();
      n localn;
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        az.agi().a(localn);
      }
      localIterator = this.iYy.iterator();
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        az.agi().a(localn);
      }
      this.iYx.clear();
      this.iYy.clear();
      this.iYM = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */