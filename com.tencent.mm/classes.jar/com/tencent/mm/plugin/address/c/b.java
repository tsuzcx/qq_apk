package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements i
{
  private Context mContext;
  private a nkN;
  private HashSet<q> nkO;
  private HashSet<q> nkP;
  private Set<Integer> nkQ;
  private Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.nkN = null;
    this.nkO = new HashSet();
    this.nkP = new HashSet();
    this.tipDialog = null;
    this.nkQ = new HashSet();
    this.mContext = paramContext;
    this.nkN = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.nkQ.add(Integer.valueOf(paramInt));
    bh.aGY().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void doSceneProgress(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(205906);
    Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    this.nkP.add(paramq);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(this.mContext, "", true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(20819);
          if ((b.a(b.this) != null) && (b.b(b.this).isEmpty()))
          {
            b.a(b.this).dismiss();
            paramAnonymousDialogInterface = b.c(b.this).iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              q localq = (q)paramAnonymousDialogInterface.next();
              bh.aGY().a(localq);
            }
            b.c(b.this).clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    bh.aGY().a(paramq, 0);
    AppMethodBeat.o(205906);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.nkP.contains(paramq))
    {
      this.nkP.remove(paramq);
      Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.nkP.isEmpty()) && (this.nkO.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.nkN != null)) {
        this.nkN.d(paramInt1, paramInt2, paramString, paramq);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.nkO.contains(paramq))
      {
        this.nkO.remove(paramq);
        Log.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
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
    bh.aGY().b(paramInt, this);
    this.nkQ.remove(Integer.valueOf(paramInt));
    if (this.nkQ.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.nkO.iterator();
      q localq;
      while (localIterator.hasNext())
      {
        localq = (q)localIterator.next();
        bh.aGY().a(localq);
      }
      localIterator = this.nkP.iterator();
      while (localIterator.hasNext())
      {
        localq = (q)localIterator.next();
        bh.aGY().a(localq);
      }
      this.nkO.clear();
      this.nkP.clear();
      this.nkN = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */