package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements f
{
  HashSet<n> juA;
  private a juO;
  private Set<Integer> juP;
  HashSet<n> juz;
  private Context mContext;
  Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.juO = null;
    this.juz = new HashSet();
    this.juA = new HashSet();
    this.tipDialog = null;
    this.juP = new HashSet();
    this.mContext = paramContext;
    this.juO = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.juP.add(Integer.valueOf(paramInt));
    bc.ajj().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void doSceneProgress(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(186388);
    ae.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    this.juA.add(paramn);
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
          if ((b.this.tipDialog != null) && (b.this.juz.isEmpty()))
          {
            b.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = b.this.juA.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              bc.ajj().a(localn);
            }
            b.this.juA.clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    bc.ajj().a(paramn, 0);
    AppMethodBeat.o(186388);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.juA.contains(paramn))
    {
      this.juA.remove(paramn);
      ae.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.juA.isEmpty()) && (this.juz.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.juO != null)) {
        this.juO.c(paramInt1, paramInt2, paramString, paramn);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.juz.contains(paramn))
      {
        this.juz.remove(paramn);
        ae.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
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
    bc.ajj().b(paramInt, this);
    this.juP.remove(Integer.valueOf(paramInt));
    if (this.juP.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.juz.iterator();
      n localn;
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        bc.ajj().a(localn);
      }
      localIterator = this.juA.iterator();
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        bc.ajj().a(localn);
      }
      this.juz.clear();
      this.juA.clear();
      this.juO = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */