package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class u
  implements com.tencent.mm.al.f, e
{
  HashSet<n> jrG;
  HashSet<n> jrH;
  private Set<Integer> jrW;
  private Context mContext;
  private String mProcessName;
  p tipDialog;
  private com.tencent.mm.wallet_core.d.f vpt;
  
  public u(Context paramContext, com.tencent.mm.wallet_core.d.f paramf)
  {
    AppMethodBeat.i(65230);
    this.vpt = null;
    this.jrG = new HashSet();
    this.jrH = new HashSet();
    this.tipDialog = null;
    this.jrW = new HashSet();
    this.mContext = paramContext;
    this.vpt = paramf;
    AppMethodBeat.o(65230);
  }
  
  private void i(n paramn)
  {
    AppMethodBeat.i(65238);
    if ((paramn != null) && ((paramn instanceof w))) {
      ((w)paramn).setProcessName(this.mProcessName);
    }
    AppMethodBeat.o(65238);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(65234);
    this.jrW.add(Integer.valueOf(paramInt));
    g.ajD();
    g.ajB().gAO.a(paramInt, this);
    AppMethodBeat.o(65234);
  }
  
  public final void b(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(65231);
    i(paramn);
    this.jrG.add(paramn);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.b(this.mContext, this.mContext.getString(2131760709), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65228);
          u.this.forceCancel();
          AppMethodBeat.o(65228);
        }
      });
    }
    g.ajD();
    g.ajB().gAO.a(paramn, 0);
    AppMethodBeat.o(65231);
  }
  
  public final void dip()
  {
    AppMethodBeat.i(65239);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(65239);
  }
  
  public final void doSceneProgress(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(65232);
    ad.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    i(paramn);
    this.jrH.add(paramn);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(this.mContext, 3, this.mContext.getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65229);
          if ((u.this.tipDialog != null) && (u.this.jrG.isEmpty()))
          {
            u.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = u.this.jrH.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              g.ajD();
              g.ajB().gAO.a(localn);
            }
            u.this.jrH.clear();
          }
          AppMethodBeat.o(65229);
        }
      });
    }
    g.ajD();
    g.ajB().gAO.a(paramn, 0);
    AppMethodBeat.o(65232);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(65233);
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
      g.ajD();
      g.ajB().gAO.a(localn);
    }
    localIterator = this.jrH.iterator();
    while (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      g.ajD();
      g.ajB().gAO.a(localn);
    }
    this.jrG.clear();
    this.jrH.clear();
    AppMethodBeat.o(65233);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(65237);
    if ((this.jrH.isEmpty()) && (this.jrG.isEmpty()))
    {
      AppMethodBeat.o(65237);
      return false;
    }
    AppMethodBeat.o(65237);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65236);
    int i;
    if (this.jrH.contains(paramn))
    {
      this.jrH.remove(paramn);
      ad.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.jrH.isEmpty()) && (this.jrG.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.vpt != null)) {
          this.vpt.onSceneEnd(paramInt1, paramInt2, paramString, paramn, bool);
        }
        AppMethodBeat.o(65236);
        return;
        if (!this.jrG.contains(paramn)) {
          break label154;
        }
        this.jrG.remove(paramn);
        ad.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        i = 1;
        break;
      }
      label154:
      i = 0;
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(65235);
    g.ajD();
    g.ajB().gAO.b(paramInt, this);
    this.jrW.remove(Integer.valueOf(paramInt));
    if (this.jrW.isEmpty())
    {
      forceCancel();
      this.vpt = null;
      this.mContext = null;
    }
    AppMethodBeat.o(65235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.u
 * JD-Core Version:    0.7.0.1
 */