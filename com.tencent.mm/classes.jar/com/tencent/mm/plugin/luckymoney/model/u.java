package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class u
  implements com.tencent.mm.ak.g, e
{
  private Set<Integer> iYN;
  HashSet<n> iYx;
  HashSet<n> iYy;
  private Context mContext;
  private String mProcessName;
  p tipDialog;
  private f umN;
  
  public u(Context paramContext, f paramf)
  {
    AppMethodBeat.i(65230);
    this.umN = null;
    this.iYx = new HashSet();
    this.iYy = new HashSet();
    this.tipDialog = null;
    this.iYN = new HashSet();
    this.mContext = paramContext;
    this.umN = paramf;
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
    this.iYN.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramInt, this);
    AppMethodBeat.o(65234);
  }
  
  public final void b(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(65231);
    i(paramn);
    this.iYx.add(paramn);
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramn, 0);
    AppMethodBeat.o(65231);
  }
  
  public final void cZd()
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
    ac.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    i(paramn);
    this.iYy.add(paramn);
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
          if ((u.this.tipDialog != null) && (u.this.iYx.isEmpty()))
          {
            u.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = u.this.iYy.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              n localn = (n)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(localn);
            }
            u.this.iYy.clear();
          }
          AppMethodBeat.o(65229);
        }
      });
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramn, 0);
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
    Iterator localIterator = this.iYx.iterator();
    n localn;
    while (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(localn);
    }
    localIterator = this.iYy.iterator();
    while (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(localn);
    }
    this.iYx.clear();
    this.iYy.clear();
    AppMethodBeat.o(65233);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(65237);
    if ((this.iYy.isEmpty()) && (this.iYx.isEmpty()))
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
    if (this.iYy.contains(paramn))
    {
      this.iYy.remove(paramn);
      ac.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.iYy.isEmpty()) && (this.iYx.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.umN != null)) {
          this.umN.onSceneEnd(paramInt1, paramInt2, paramString, paramn, bool);
        }
        AppMethodBeat.o(65236);
        return;
        if (!this.iYx.contains(paramn)) {
          break label154;
        }
        this.iYx.remove(paramn);
        ac.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(paramInt, this);
    this.iYN.remove(Integer.valueOf(paramInt));
    if (this.iYN.isEmpty())
    {
      forceCancel();
      this.umN = null;
      this.mContext = null;
    }
    AppMethodBeat.o(65235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.u
 * JD-Core Version:    0.7.0.1
 */