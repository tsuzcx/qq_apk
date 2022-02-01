package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements i
{
  HashSet<q> ksO;
  HashSet<q> ksP;
  private a ktc;
  private Set<Integer> ktd;
  private Context mContext;
  Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.ktc = null;
    this.ksO = new HashSet();
    this.ksP = new HashSet();
    this.tipDialog = null;
    this.ktd = new HashSet();
    this.mContext = paramContext;
    this.ktc = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.ktd.add(Integer.valueOf(paramInt));
    bg.azz().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void doSceneProgress(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(231573);
    Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    this.ksP.add(paramq);
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
          if ((b.this.tipDialog != null) && (b.this.ksO.isEmpty()))
          {
            b.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = b.this.ksP.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              q localq = (q)paramAnonymousDialogInterface.next();
              bg.azz().a(localq);
            }
            b.this.ksP.clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    bg.azz().a(paramq, 0);
    AppMethodBeat.o(231573);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.ksP.contains(paramq))
    {
      this.ksP.remove(paramq);
      Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.ksP.isEmpty()) && (this.ksO.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.ktc != null)) {
        this.ktc.c(paramInt1, paramInt2, paramString, paramq);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.ksO.contains(paramq))
      {
        this.ksO.remove(paramq);
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
    bg.azz().b(paramInt, this);
    this.ktd.remove(Integer.valueOf(paramInt));
    if (this.ktd.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.ksO.iterator();
      q localq;
      while (localIterator.hasNext())
      {
        localq = (q)localIterator.next();
        bg.azz().a(localq);
      }
      localIterator = this.ksP.iterator();
      while (localIterator.hasNext())
      {
        localq = (q)localIterator.next();
        bg.azz().a(localq);
      }
      this.ksO.clear();
      this.ksP.clear();
      this.ktc = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */