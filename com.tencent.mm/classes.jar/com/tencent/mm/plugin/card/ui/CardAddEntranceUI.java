package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class CardAddEntranceUI
  extends MMActivity
{
  private String appId;
  private int dJd;
  LinkedList<th> oKT;
  private String oLe;
  private String oLf;
  private int oLg;
  
  public CardAddEntranceUI()
  {
    AppMethodBeat.i(113180);
    this.oKT = new LinkedList();
    this.oLe = "";
    this.dJd = 8;
    this.oLg = 0;
    AppMethodBeat.o(113180);
  }
  
  private void aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(113184);
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_add_card_to_wx_card_list", paramString);
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(this.appId, true, false);
    AddCardToWXCardPackage.Resp localResp = new AddCardToWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((g)localObject).field_openId;
    }
    localResp.transaction = this.oLf;
    String str = this.appId;
    if (localObject == null)
    {
      paramString = "null appinfo";
      if (localObject != null) {
        break label202;
      }
      localObject = "null appinfo";
      label85:
      ae.i("MicroMsg.CardAddEntranceUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str, paramString, localObject, this.oLf });
      localResp.toBundle(localBundle);
      ae.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      if (paramInt != -1) {
        break label210;
      }
    }
    label202:
    label210:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.oLe;
      paramString.bundle = localBundle;
      q.bc(localBundle);
      q.bd(localBundle);
      MMessageActV2.send(ak.getContext(), paramString);
      AppMethodBeat.o(113184);
      return;
      paramString = ((g)localObject).field_appName;
      break;
      localObject = ((g)localObject).field_openId;
      break label85;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493252;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113183);
    ae.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
    if (paramInt2 == -1) {
      ae.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
    }
    LinkedList localLinkedList;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.oKT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (th)((Iterator)localObject1).next();
        e locale = new e();
        locale.oEo = ((th)localObject2).oEo;
        locale.dJc = ((th)localObject2).dJc;
        localLinkedList.add(locale);
      }
      ae.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
    }
    if (paramInt1 == 1)
    {
      ae.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
      if ((this.dJd == 7) || (this.dJd == 16))
      {
        localObject1 = new Intent();
        switch (paramInt2)
        {
        }
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(113183);
      return;
      if ((paramIntent != null) && (localLinkedList.size() > 0)) {
        ((e)localLinkedList.get(0)).code = paramIntent.getStringExtra("key_code");
      }
      ((Intent)localObject1).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.dJd));
      setResult(-1, (Intent)localObject1);
      continue;
      ((Intent)localObject1).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.dJd));
      setResult(0, (Intent)localObject1);
      continue;
      if (this.dJd == 26)
      {
        localObject1 = new Intent();
        switch (paramInt2)
        {
        default: 
          break;
        case -1: 
          if ((paramIntent != null) && (localLinkedList.size() > 0)) {
            ((e)localLinkedList.get(0)).code = paramIntent.getStringExtra("key_code");
          }
          ((Intent)localObject1).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.dJd));
          setResult(-1, (Intent)localObject1);
          break;
        case 0: 
          ((Intent)localObject1).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.dJd));
          setResult(0, (Intent)localObject1);
          break;
        }
      }
      else
      {
        switch (paramInt2)
        {
        default: 
          break;
        case -1: 
          if ((paramIntent != null) && (localLinkedList.size() > 0)) {
            ((e)localLinkedList.get(0)).code = paramIntent.getStringExtra("key_code");
          }
          aI(-1, com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.dJd));
          break;
        case 0: 
          aI(0, com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.dJd));
          continue;
          if (paramInt1 == 2)
          {
            ae.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
            localObject1 = "";
            if (paramIntent != null) {
              localObject1 = paramIntent.getStringExtra("card_list");
            }
            if ((this.dJd == 7) || (this.dJd == 16)) {
              localObject2 = new Intent();
            }
            switch (paramInt2)
            {
            default: 
              break;
            case -1: 
              if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                paramIntent.putExtra("card_list", com.tencent.mm.plugin.card.d.h.cM((String)localObject1, this.dJd));
                setResult(-1, paramIntent);
              }
              else
              {
                ((Intent)localObject2).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.dJd));
                setResult(-1, (Intent)localObject2);
              }
              break;
            case 0: 
              if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                paramIntent.putExtra("card_list", com.tencent.mm.plugin.card.d.h.cM((String)localObject1, this.dJd));
                setResult(0, paramIntent);
              }
              else
              {
                ((Intent)localObject2).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.dJd));
                ((Intent)localObject2).putExtra("result_code", 1);
                setResult(0, (Intent)localObject2);
                continue;
                if (this.dJd == 26)
                {
                  localObject2 = new Intent();
                  switch (paramInt2)
                  {
                  default: 
                    break;
                  case -1: 
                    if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                    {
                      paramIntent.putExtra("card_list", com.tencent.mm.plugin.card.d.h.cM((String)localObject1, this.dJd));
                      setResult(-1, paramIntent);
                      continue;
                    }
                    ((Intent)localObject2).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.dJd));
                    setResult(-1, (Intent)localObject2);
                    break;
                  case 0: 
                    if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                    {
                      paramIntent.putExtra("card_list", com.tencent.mm.plugin.card.d.h.cM((String)localObject1, this.dJd));
                      setResult(0, paramIntent);
                      continue;
                    }
                    ((Intent)localObject2).putExtra("card_list", com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.dJd));
                    ((Intent)localObject2).putExtra("result_code", 1);
                    setResult(0, (Intent)localObject2);
                    break;
                  }
                }
                else
                {
                  switch (paramInt2)
                  {
                  default: 
                    break;
                  case -1: 
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      aI(-1, (String)localObject1);
                    } else {
                      aI(-1, com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.dJd));
                    }
                    break;
                  case 0: 
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      aI(0, (String)localObject1);
                    } else {
                      aI(0, com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.dJd));
                    }
                    break;
                  }
                }
              }
              break;
            }
          }
          break;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113181);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      ae.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
      setResult(0);
      finish();
      AppMethodBeat.o(113181);
      return;
    }
    ae.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
    Object localObject = paramBundle.getStringExtra("key_in_card_list");
    this.dJd = paramBundle.getIntExtra("key_from_scene", 8);
    this.oLg = paramBundle.getIntExtra("key_stastic_scene", 0);
    ae.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.dJd + "  from_origin_scene:" + this.oLg);
    this.oLe = paramBundle.getStringExtra("key_package_name");
    String str5 = paramBundle.getStringExtra("key_sign");
    String str1 = getIntent().getStringExtra("src_username");
    ae.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:".concat(String.valueOf(str1)));
    String str2 = getIntent().getStringExtra("js_url");
    this.appId = getIntent().getStringExtra("key_app_id");
    this.oLf = getIntent().getStringExtra("key_transaction");
    String str3 = getIntent().getStringExtra("key_consumed_card_id");
    ae.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:".concat(String.valueOf(str3)));
    String str4 = getIntent().getStringExtra("key_template_id");
    ArrayList localArrayList = com.tencent.mm.plugin.card.d.h.cL((String)localObject, this.dJd);
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      ae.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
      setResult(0);
      finish();
      AppMethodBeat.o(113181);
      return;
    }
    this.oKT.clear();
    this.oKT.addAll(localArrayList);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", this.dJd);
    localIntent.putExtra("key_stastic_scene", this.oLg);
    if (localArrayList.size() == 1)
    {
      localObject = (th)localArrayList.get(0);
      localIntent.putExtra("key_card_id", ((th)localObject).oEo);
      localIntent.putExtra("key_card_ext", ((th)localObject).dJc);
      localIntent.putExtra("src_username", str1);
      localIntent.putExtra("js_url", str2);
      localIntent.putExtra("key_consumed_card_id", str3);
      localIntent.putExtra("key_template_id", str4);
      localIntent.putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      localIntent.setClass(this, CardDetailUI.class);
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(113181);
      return;
    }
    localIntent.putExtra("key_in_card_list", (String)localObject);
    localIntent.putExtra("key_package_name", this.oLe);
    localIntent.putExtra("key_sign", str5);
    localIntent.putExtra("src_username", str1);
    localIntent.putExtra("js_url", str2);
    localIntent.putExtra("key_consumed_card_id", str3);
    localIntent.putExtra("key_template_id", str4);
    localIntent.setClass(this, CardAcceptCardListUI.class);
    startActivityForResult(localIntent, 2);
    AppMethodBeat.o(113181);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113182);
    super.onDestroy();
    AppMethodBeat.o(113182);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAddEntranceUI
 * JD-Core Version:    0.7.0.1
 */