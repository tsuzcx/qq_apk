package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.h;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
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
  private int bZe = 8;
  private String irI = "";
  private String irJ;
  private int irK = 0;
  LinkedList<lw> irx = new LinkedList();
  
  private void W(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_add_card_to_wx_card_list", paramString);
    Object localObject = g.by(this.appId, true);
    AddCardToWXCardPackage.Resp localResp = new AddCardToWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((f)localObject).field_openId;
    }
    localResp.transaction = this.irJ;
    String str = this.appId;
    if (localObject == null)
    {
      paramString = "null appinfo";
      if (localObject != null) {
        break label198;
      }
      localObject = "null appinfo";
      label79:
      y.i("MicroMsg.CardAddEntranceUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str, paramString, localObject, this.irJ });
      localResp.toBundle(localBundle);
      y.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:" + paramInt);
      if (paramInt != -1) {
        break label206;
      }
    }
    label198:
    label206:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.irI;
      paramString.bundle = localBundle;
      p.ak(localBundle);
      p.al(localBundle);
      MMessageActV2.send(ae.getContext(), paramString);
      return;
      paramString = ((f)localObject).field_appName;
      break;
      localObject = ((f)localObject).field_openId;
      break label79;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_add_entrance_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
    if (paramInt2 == -1) {
      y.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
    }
    LinkedList localLinkedList;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localLinkedList = new LinkedList();
      localObject1 = this.irx.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (lw)((Iterator)localObject1).next();
        e locale = new e();
        locale.iln = ((lw)localObject2).iln;
        locale.bZd = ((lw)localObject2).bZd;
        localLinkedList.add(locale);
      }
      y.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
    }
    if (paramInt1 == 1)
    {
      y.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
      if ((this.bZe == 7) || (this.bZe == 16))
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
      return;
      if ((paramIntent != null) && (localLinkedList.size() > 0)) {
        ((e)localLinkedList.get(0)).code = paramIntent.getStringExtra("key_code");
      }
      ((Intent)localObject1).putExtra("card_list", h.a(localLinkedList, true, this.bZe));
      setResult(-1, (Intent)localObject1);
      continue;
      ((Intent)localObject1).putExtra("card_list", h.a(localLinkedList, false, this.bZe));
      setResult(0, (Intent)localObject1);
      continue;
      if (this.bZe == 26)
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
          ((Intent)localObject1).putExtra("card_list", h.a(localLinkedList, true, this.bZe));
          setResult(-1, (Intent)localObject1);
          break;
        case 0: 
          ((Intent)localObject1).putExtra("card_list", h.a(localLinkedList, false, this.bZe));
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
          W(-1, h.a(localLinkedList, true, this.bZe));
          break;
        case 0: 
          W(0, h.a(localLinkedList, false, this.bZe));
          continue;
          if (paramInt1 == 2)
          {
            y.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
            localObject1 = "";
            if (paramIntent != null) {
              localObject1 = paramIntent.getStringExtra("card_list");
            }
            if ((this.bZe == 7) || (this.bZe == 16)) {
              localObject2 = new Intent();
            }
            switch (paramInt2)
            {
            default: 
              break;
            case -1: 
              if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                paramIntent.putExtra("card_list", h.bo((String)localObject1, this.bZe));
                setResult(-1, paramIntent);
              }
              else
              {
                ((Intent)localObject2).putExtra("card_list", h.a(localLinkedList, true, this.bZe));
                setResult(-1, (Intent)localObject2);
              }
              break;
            case 0: 
              if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                paramIntent.putExtra("card_list", h.bo((String)localObject1, this.bZe));
                setResult(0, paramIntent);
              }
              else
              {
                ((Intent)localObject2).putExtra("card_list", h.a(localLinkedList, false, this.bZe));
                ((Intent)localObject2).putExtra("result_code", 1);
                setResult(0, (Intent)localObject2);
                continue;
                if (this.bZe == 26)
                {
                  localObject2 = new Intent();
                  switch (paramInt2)
                  {
                  default: 
                    break;
                  case -1: 
                    if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                    {
                      paramIntent.putExtra("card_list", h.bo((String)localObject1, this.bZe));
                      setResult(-1, paramIntent);
                      continue;
                    }
                    ((Intent)localObject2).putExtra("card_list", h.a(localLinkedList, true, this.bZe));
                    setResult(-1, (Intent)localObject2);
                    break;
                  case 0: 
                    if ((paramIntent != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                    {
                      paramIntent.putExtra("card_list", h.bo((String)localObject1, this.bZe));
                      setResult(0, paramIntent);
                      continue;
                    }
                    ((Intent)localObject2).putExtra("card_list", h.a(localLinkedList, false, this.bZe));
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
                      W(-1, (String)localObject1);
                    } else {
                      W(-1, h.a(localLinkedList, true, this.bZe));
                    }
                    break;
                  case 0: 
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      W(0, (String)localObject1);
                    } else {
                      W(0, h.a(localLinkedList, false, this.bZe));
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
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      y.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
      setResult(0);
      finish();
      return;
    }
    y.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
    Object localObject = paramBundle.getStringExtra("key_in_card_list");
    this.bZe = paramBundle.getIntExtra("key_from_scene", 8);
    this.irK = paramBundle.getIntExtra("key_stastic_scene", 0);
    y.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.bZe + "  from_origin_scene:" + this.irK);
    this.irI = paramBundle.getStringExtra("key_package_name");
    String str5 = paramBundle.getStringExtra("key_sign");
    String str1 = getIntent().getStringExtra("src_username");
    y.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:" + str1);
    String str2 = getIntent().getStringExtra("js_url");
    this.appId = getIntent().getStringExtra("key_app_id");
    this.irJ = getIntent().getStringExtra("key_transaction");
    String str3 = getIntent().getStringExtra("key_consumed_card_id");
    y.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:" + str3);
    String str4 = getIntent().getStringExtra("key_template_id");
    ArrayList localArrayList = h.bn((String)localObject, this.bZe);
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      y.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
      setResult(0);
      finish();
      return;
    }
    this.irx.clear();
    this.irx.addAll(localArrayList);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", this.bZe);
    localIntent.putExtra("key_stastic_scene", this.irK);
    if (localArrayList.size() == 1)
    {
      localObject = (lw)localArrayList.get(0);
      localIntent.putExtra("key_card_id", ((lw)localObject).iln);
      localIntent.putExtra("key_card_ext", ((lw)localObject).bZd);
      localIntent.putExtra("src_username", str1);
      localIntent.putExtra("js_url", str2);
      localIntent.putExtra("key_consumed_card_id", str3);
      localIntent.putExtra("key_template_id", str4);
      localIntent.putExtra("key_from_appbrand_type", paramBundle.getIntExtra("key_from_appbrand_type", 0));
      localIntent.setClass(this, CardDetailUI.class);
      startActivityForResult(localIntent, 1);
      return;
    }
    localIntent.putExtra("key_in_card_list", (String)localObject);
    localIntent.putExtra("key_package_name", this.irI);
    localIntent.putExtra("key_sign", str5);
    localIntent.putExtra("src_username", str1);
    localIntent.putExtra("js_url", str2);
    localIntent.putExtra("key_consumed_card_id", str3);
    localIntent.putExtra("key_template_id", str4);
    localIntent.setClass(this, CardAcceptCardListUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAddEntranceUI
 * JD-Core Version:    0.7.0.1
 */