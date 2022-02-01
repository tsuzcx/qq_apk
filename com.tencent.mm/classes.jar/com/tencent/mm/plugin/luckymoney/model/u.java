package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class u
  implements com.tencent.mm.al.g, e
{
  private Set<Integer> iyK;
  HashSet<n> iyu;
  HashSet<n> iyv;
  private Context mContext;
  private String mProcessName;
  private f tey;
  p tipDialog;
  
  public u(Context paramContext, f paramf)
  {
    AppMethodBeat.i(65230);
    this.tey = null;
    this.iyu = new HashSet();
    this.iyv = new HashSet();
    this.tipDialog = null;
    this.iyK = new HashSet();
    this.mContext = paramContext;
    this.tey = paramf;
    AppMethodBeat.o(65230);
  }
  
  private void j(n paramn)
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
    this.iyK.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramInt, this);
    AppMethodBeat.o(65234);
  }
  
  public final void b(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(65231);
    j(paramn);
    this.iyu.add(paramn);
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramn, 0);
    AppMethodBeat.o(65231);
  }
  
  public final void cLx()
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
    j(paramn);
    this.iyv.add(paramn);
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
          if ((u.this.tipDialog != null) && (u.this.iyu.isEmpty()))
          {
            u.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = u.this.iyv.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a(localn);
            }
            u.this.iyv.clear();
          }
          AppMethodBeat.o(65229);
        }
      });
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramn, 0);
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
    Iterator localIterator = this.iyu.iterator();
    n localn;
    while (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(localn);
    }
    localIterator = this.iyv.iterator();
    while (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(localn);
    }
    this.iyu.clear();
    this.iyv.clear();
    AppMethodBeat.o(65233);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(65237);
    if ((this.iyv.isEmpty()) && (this.iyu.isEmpty()))
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
    if (this.iyv.contains(paramn))
    {
      this.iyv.remove(paramn);
      ad.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.iyv.isEmpty()) && (this.iyu.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.tey != null)) {
          this.tey.onSceneEnd(paramInt1, paramInt2, paramString, paramn, bool);
        }
        AppMethodBeat.o(65236);
        return;
        if (!this.iyu.contains(paramn)) {
          break label154;
        }
        this.iyu.remove(paramn);
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(paramInt, this);
    this.iyK.remove(Integer.valueOf(paramInt));
    if (this.iyK.isEmpty())
    {
      forceCancel();
      this.tey = null;
      this.mContext = null;
    }
    AppMethodBeat.o(65235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.u
 * JD-Core Version:    0.7.0.1
 */