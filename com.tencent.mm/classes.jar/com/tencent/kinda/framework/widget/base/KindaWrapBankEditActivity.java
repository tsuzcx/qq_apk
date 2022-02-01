package com.tencent.kinda.framework.widget.base;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.am;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankCardTypeSelectUI;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KindaWrapBankEditActivity
  extends WalletBankCardSelectUI
{
  public static final String FLAG_ACTIVITY_BACK = "flag_activity_back_KindaWrapBankEditActivity";
  public static final String FLAG_ACTIVITY_CLOSE = "flag_activity_close_KindaWrapBankEditActivity";
  public static final int REQ_SELECT_BANKCARD_TYPE = 1;
  public static final String TAG = "KindaBank.KindaWrapBankEditActivity";
  private String mSelectBankName;
  private List<d> mSortEntities;
  
  public KindaWrapBankEditActivity()
  {
    AppMethodBeat.i(18980);
    this.mSortEntities = new ArrayList();
    AppMethodBeat.o(18980);
  }
  
  private void sendDatatoKinda(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18985);
    Object localObject1 = "";
    Iterator localIterator = this.bankcardTypeList.iterator();
    while (localIterator.hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)localIterator.next();
      localObject2 = localObject1;
      if (localElementQuery.JFk.equals(paramString1))
      {
        localObject2 = localObject1;
        if (localElementQuery.VFg.equals(paramString2))
        {
          localObject2 = localElementQuery.hAk;
          Log.i("KindaBank.KindaWrapBankEditActivity", "Ktemp.bank_type：" + localElementQuery.hAk);
        }
      }
      localObject1 = localObject2;
    }
    Object localObject2 = new am();
    ((am)localObject2).hAi.hAj = paramString1;
    ((am)localObject2).hAi.hAl = paramString2;
    ((am)localObject2).hAi.hAk = ((String)localObject1);
    ((am)localObject2).publish();
    Log.i("KindaBank.KindaWrapBankEditActivity", "sendDataToKinda：bankName：" + paramString1 + "  bankAccName：" + paramString2 + "  BankType：" + (String)localObject1);
    Log.i("KindaBank.KindaWrapBankEditActivity", "KindaWrapBankEditActivity.onItemSelect，发送事件，当前线程：" + Thread.currentThread().getId());
    finish();
    if (isFinishing())
    {
      paramString1 = new am();
      paramString1.hAi.hAj = "flag_activity_close_KindaWrapBankEditActivity";
      paramString1.publish();
    }
    AppMethodBeat.o(18985);
  }
  
  public void fetchData()
  {
    AppMethodBeat.i(18982);
    Object localObject = new jo();
    try
    {
      ((jo)localObject).parseFrom(getIntent().getByteArrayExtra("bank_list"));
      this.bankcardList = new ArrayList();
      localObject = ((jo)localObject).YLO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        jn localjn1 = (jn)((Iterator)localObject).next();
        localElementQuery = new ElementQuery();
        localElementQuery.JFk = localjn1.JFk;
        localElementQuery.hAk = localjn1.hAk;
        this.bankcardList.add(localElementQuery);
      }
    }
    catch (Exception localException1)
    {
      ElementQuery localElementQuery;
      for (;;)
      {
        Log.e("KindaBank.KindaWrapBankEditActivity", "bank list parse failed");
      }
      localObject = new jo();
      try
      {
        ((jo)localObject).parseFrom(getIntent().getByteArrayExtra("bank_type_list"));
        this.bankcardTypeList = new ArrayList();
        localObject = ((jo)localObject).YLO.iterator();
        while (((Iterator)localObject).hasNext())
        {
          jn localjn2 = (jn)((Iterator)localObject).next();
          localElementQuery = new ElementQuery();
          localElementQuery.JFk = localjn2.JFk;
          localElementQuery.hAk = localjn2.hAk;
          localElementQuery.VFg = localjn2.YLC;
          this.bankcardTypeList.add(localElementQuery);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("KindaBank.KindaWrapBankEditActivity", "bank type list parse failed");
        }
        runOnUiThread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(18979);
            KindaWrapBankEditActivity.access$001(KindaWrapBankEditActivity.this);
            AppMethodBeat.o(18979);
          }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(170118);
            KindaWrapBankEditActivity.access$102(KindaWrapBankEditActivity.this, 4);
            if (KindaWrapBankEditActivity.access$200(KindaWrapBankEditActivity.this))
            {
              KindaWrapBankEditActivity.this.hideVKB();
              KindaWrapBankEditActivity.this.showDialog(1000);
            }
            for (;;)
            {
              AppMethodBeat.o(170118);
              return true;
              if (!Util.isNullOrNil(KindaWrapBankEditActivity.this.bankcardTypeList))
              {
                paramAnonymousMenuItem = new am();
                paramAnonymousMenuItem.hAi.hAj = "flag_activity_back_KindaWrapBankEditActivity";
                paramAnonymousMenuItem.publish();
              }
              KindaWrapBankEditActivity.this.finish();
            }
          }
        });
        AppMethodBeat.o(18982);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(18984);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramIntent != null)) {
      sendDatatoKinda(this.mSelectBankName, paramIntent.getStringExtra("bank_card_acc_name"));
    }
    AppMethodBeat.o(18984);
  }
  
  public void onItemSelect(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(18983);
    Object localObject = (BankCardSelectSortView.a)paramObject;
    paramObject = new ArrayList();
    if (localObject == null)
    {
      AppMethodBeat.o(18983);
      return;
    }
    hideVKB();
    this.mSelectBankName = ((BankCardSelectSortView.a)localObject).MEo;
    if (this.bankcardTypeList.size() == 0)
    {
      sendDatatoKinda(this.mSelectBankName, "");
      AppMethodBeat.o(18983);
      return;
    }
    localObject = this.bankcardTypeList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ElementQuery localElementQuery = (ElementQuery)((Iterator)localObject).next();
      if (localElementQuery.JFk.equals(this.mSelectBankName)) {
        paramObject.add(localElementQuery.VFg);
      }
    }
    if (paramObject.size() == 1)
    {
      sendDatatoKinda(this.mSelectBankName, (String)paramObject.get(0));
      AppMethodBeat.o(18983);
      return;
    }
    localObject = new Intent(this, WalletBankCardTypeSelectUI.class);
    ((Intent)localObject).putStringArrayListExtra("bank_type_show_list", paramObject);
    startActivityForResult((Intent)localObject, 1);
    AppMethodBeat.o(18983);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(18981);
    super.onPause();
    if (isFinishing())
    {
      am localam = new am();
      localam.hAi.hAj = "flag_activity_close_KindaWrapBankEditActivity";
      localam.publish();
    }
    AppMethodBeat.o(18981);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaWrapBankEditActivity
 * JD-Core Version:    0.7.0.1
 */