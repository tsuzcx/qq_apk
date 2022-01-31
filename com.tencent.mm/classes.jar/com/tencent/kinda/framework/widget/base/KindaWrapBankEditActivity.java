package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KindaWrapBankEditActivity
  extends WalletBankCardSelectUI
{
  public static final String FLAG_ACTIVITY_CLOSE = "flag_activity_close_KindaWrapBankEditActivity";
  String TAG;
  private List<d> mSortEntities;
  
  public KindaWrapBankEditActivity()
  {
    AppMethodBeat.i(144831);
    this.TAG = "KindaBank.KindaWrapBankEditActivity";
    this.mSortEntities = new ArrayList();
    AppMethodBeat.o(144831);
  }
  
  public void fetchData()
  {
    AppMethodBeat.i(144833);
    Object localObject = new hf();
    try
    {
      ((hf)localObject).parseFrom(getIntent().getByteArrayExtra("bank_list"));
      this.bankcardList = new ArrayList();
      localObject = ((hf)localObject).wtT.iterator();
      while (((Iterator)localObject).hasNext())
      {
        he localhe = (he)((Iterator)localObject).next();
        ElementQuery localElementQuery = new ElementQuery();
        localElementQuery.nLq = localhe.nLq;
        localElementQuery.poq = localhe.poq;
        this.bankcardList.add(localElementQuery);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e(this.TAG, "bank list parse failed");
      }
      runOnUiThread(new KindaWrapBankEditActivity.1(this));
      AppMethodBeat.o(144833);
    }
  }
  
  public void onItemSelect(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(144834);
    paramObject = (BankCardSelectSortView.a)paramObject;
    if (paramObject != null)
    {
      hideVKB();
      ac localac = new ac();
      localac.cni.cnj = paramObject.ppn;
      a.ymk.l(localac);
      ab.i(this.TAG, "KindaWrapBankEditActivity.onItemSelect，发送事件，当前线程：" + Thread.currentThread().getId());
      finish();
    }
    AppMethodBeat.o(144834);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(144832);
    super.onPause();
    if (isFinishing())
    {
      ac localac = new ac();
      localac.cni.cnj = "flag_activity_close_KindaWrapBankEditActivity";
      a.ymk.l(localac);
    }
    AppMethodBeat.o(144832);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaWrapBankEditActivity
 * JD-Core Version:    0.7.0.1
 */