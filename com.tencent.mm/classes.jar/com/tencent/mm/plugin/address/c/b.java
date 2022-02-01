package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements h
{
  private Context mContext;
  private a qhW;
  private HashSet<p> qhX;
  private HashSet<p> qhY;
  private Set<Integer> qhZ;
  private Dialog tipDialog;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(20820);
    this.qhW = null;
    this.qhX = new HashSet();
    this.qhY = new HashSet();
    this.tipDialog = null;
    this.qhZ = new HashSet();
    this.mContext = paramContext;
    this.qhW = parama;
    AppMethodBeat.o(20820);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(20822);
    this.qhZ.add(Integer.valueOf(paramInt));
    bh.aZW().a(paramInt, this);
    AppMethodBeat.o(20822);
  }
  
  public final void doSceneProgress(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(267136);
    Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    this.qhY.add(paramp);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = k.a(this.mContext, "", true, new DialogInterface.OnCancelListener()
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
              p localp = (p)paramAnonymousDialogInterface.next();
              bh.aZW().a(localp);
            }
            b.c(b.this).clear();
          }
          AppMethodBeat.o(20819);
        }
      });
    }
    bh.aZW().a(paramp, 0);
    AppMethodBeat.o(267136);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(20824);
    if (this.qhY.contains(paramp))
    {
      this.qhY.remove(paramp);
      Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.qhY.isEmpty()) && (this.qhX.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((i != 0) && (this.qhW != null)) {
        this.qhW.b(paramInt1, paramInt2, paramString, paramp);
      }
      AppMethodBeat.o(20824);
      return;
      if (this.qhX.contains(paramp))
      {
        this.qhX.remove(paramp);
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
    bh.aZW().b(paramInt, this);
    this.qhZ.remove(Integer.valueOf(paramInt));
    if (this.qhZ.isEmpty())
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      Iterator localIterator = this.qhX.iterator();
      p localp;
      while (localIterator.hasNext())
      {
        localp = (p)localIterator.next();
        bh.aZW().a(localp);
      }
      localIterator = this.qhY.iterator();
      while (localIterator.hasNext())
      {
        localp = (p)localIterator.next();
        bh.aZW().a(localp);
      }
      this.qhX.clear();
      this.qhY.clear();
      this.qhW = null;
      this.mContext = null;
    }
    AppMethodBeat.o(20823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */