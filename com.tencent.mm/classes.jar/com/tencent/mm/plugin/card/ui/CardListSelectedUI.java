package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements com.tencent.mm.ai.f, j.a
{
  private String app_id;
  boolean eRq;
  private com.tencent.mm.ui.base.p ehb;
  private int ejF;
  LinkedList<a> eyN;
  private String kml;
  com.tencent.mm.bv.b koK;
  private boolean krG;
  private BaseAdapter krV;
  private String ksP;
  private String ksQ;
  private TextView kwA;
  boolean kwB;
  HashMap<Integer, Boolean> kwC;
  private boolean kwD;
  private boolean kwE;
  private boolean kwF;
  private int kwG;
  private String kwH;
  private String kwI;
  private String kwJ;
  private String kwK;
  private int kwL;
  public String kwM;
  private boolean kwN;
  private a kwO;
  private TextView kwx;
  private RelativeLayout kwy;
  private TextView kwz;
  private ListView mListView;
  private int time_stamp;
  private View xy;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(88569);
    this.ehb = null;
    this.kwB = false;
    this.eyN = new LinkedList();
    this.kwC = new HashMap();
    this.eRq = true;
    this.koK = null;
    this.krG = false;
    this.ksP = "";
    this.kwN = false;
    this.ejF = 0;
    AppMethodBeat.o(88569);
  }
  
  private static String Ii(String paramString)
  {
    AppMethodBeat.i(88574);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(88574);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("rule_url");
      AppMethodBeat.o(88574);
      return paramString;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(88574);
    }
    return null;
  }
  
  private void aq(int paramInt, String paramString)
  {
    AppMethodBeat.i(88582);
    if (this.ejF != 8)
    {
      ab.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.ejF);
      AppMethodBeat.o(88582);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.ca(this.app_id, true);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_openId;
    }
    localResp.transaction = this.ksQ;
    String str2 = this.app_id;
    String str1;
    if (localObject == null)
    {
      str1 = "null appinfo";
      if (localObject != null) {
        break label262;
      }
      localObject = "null appinfo";
      label129:
      ab.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.ksQ });
      localResp.toBundle(localBundle);
      ab.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      ab.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label272;
      }
    }
    label262:
    label272:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.ksP;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.p.aC(localBundle);
      com.tencent.mm.pluginsdk.model.app.p.aD(localBundle);
      MMessageActV2.send(ah.getContext(), paramString);
      AppMethodBeat.o(88582);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_openId;
      break label129;
    }
  }
  
  private void bds()
  {
    AppMethodBeat.i(88579);
    Intent localIntent = new Intent();
    String str = bek();
    if (this.kwN) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aq(-1, str);
      finish();
      AppMethodBeat.o(88579);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void bej()
  {
    AppMethodBeat.i(88571);
    if (this.krG)
    {
      ab.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(88571);
      return;
    }
    if (this.koK == null)
    {
      this.kwD = false;
      this.kwE = false;
      this.kwF = false;
    }
    com.tencent.mm.kernel.g.RK().eHt.a(664, this);
    aj localaj = new aj(this.app_id, this.kwG, this.kwH, this.kwI, this.time_stamp, this.kwJ, this.kml, this.kwK, this.koK);
    com.tencent.mm.kernel.g.RK().eHt.a(localaj, 0);
    fV(true);
    this.krG = true;
    if (this.kwL == 1) {
      this.kwB = true;
    }
    AppMethodBeat.o(88571);
  }
  
  private String bek()
  {
    int j = 0;
    AppMethodBeat.i(88580);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.eyN.size())
    {
      localObject2 = (Boolean)this.kwC.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.eyN.get(i));
      }
      i += 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[");
    i = j;
    while (i < ((ArrayList)localObject1).size())
    {
      if (i != 0) {
        ((StringBuilder)localObject2).append(",");
      }
      a locala = (a)((ArrayList)localObject1).get(i);
      ((StringBuilder)localObject2).append("{");
      ((StringBuilder)localObject2).append("\"card_id\":");
      ((StringBuilder)localObject2).append("\"" + locala.kml + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.kmp + "\"");
      if (this.kwN)
      {
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append("\"app_id\":");
        ((StringBuilder)localObject2).append("\"" + locala.app_id + "\"");
      }
      ((StringBuilder)localObject2).append("}");
      i += 1;
    }
    ((StringBuilder)localObject2).append("]");
    localObject1 = ((StringBuilder)localObject2).toString();
    AppMethodBeat.o(88580);
    return localObject1;
  }
  
  public final void HE(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(88575);
    fV(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.kwO.kmr)))
    {
      ab.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(88575);
      return;
    }
    ab.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    ab.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.klZ + " markCardId: " + paramb.kma);
    if (paramb.klZ == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.kma)) && (!paramString.equals(paramb.kma)))
      {
        ab.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.eyN.size())
        {
          if (((a)this.eyN.get(i)).kmr != paramb.kma) {
            break label230;
          }
          while (j < this.eyN.size())
          {
            this.kwC.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.kwC.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        bds();
        AppMethodBeat.o(88575);
        return;
        label230:
        i += 1;
        break;
        ab.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(2131297985));
    AppMethodBeat.o(88575);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88576);
    fV(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.kwO.kmr)))
    {
      ab.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(88576);
      return;
    }
    ab.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131297984);
    }
    d.c(this, paramString1);
    AppMethodBeat.o(88576);
  }
  
  protected final void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(88578);
    if (paramBoolean)
    {
      this.ehb = com.tencent.mm.ui.base.p.b(this, getString(2131301086), false, null);
      AppMethodBeat.o(88578);
      return;
    }
    if ((this.ehb != null) && (this.ehb.isShowing()))
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(88578);
  }
  
  public int getLayoutId()
  {
    return 2130968968;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88572);
    if (this.kwN)
    {
      setMMTitle(2131297979);
      setBackBtn(new CardListSelectedUI.1(this));
      if (!this.kwN)
      {
        addTextOptionMenu(0, getString(2131296964), new CardListSelectedUI.2(this));
        enableOptionMenu(false);
      }
      this.mListView = ((ListView)findViewById(2131822284));
      if (!this.kwN) {
        break label288;
      }
    }
    label288:
    for (this.krV = new CardListSelectedUI.b(this);; this.krV = new CardListSelectedUI.a(this))
    {
      this.mListView.setAdapter(this.krV);
      this.mListView.setOnItemClickListener(new CardListSelectedUI.3(this));
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(88558);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.eRq))
          {
            ab.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(88558);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.xy = findViewById(2131821981);
      this.kwx = ((TextView)findViewById(2131821982));
      if (this.kwN) {
        this.kwx.setText(getString(2131298020));
      }
      this.kwy = ((RelativeLayout)findViewById(2131822279));
      this.kwz = ((TextView)findViewById(2131822282));
      this.kwA = ((TextView)findViewById(2131822283));
      if (!this.kwN) {
        break label303;
      }
      this.kwy.setVisibility(0);
      this.kwz.setOnClickListener(new CardListSelectedUI.5(this));
      this.kwA.setOnClickListener(new CardListSelectedUI.6(this));
      AppMethodBeat.o(88572);
      return;
      setMMTitle(2131297978);
      break;
    }
    label303:
    this.kwy.setVisibility(8);
    AppMethodBeat.o(88572);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88570);
    super.onCreate(paramBundle);
    am.bcp().a(this);
    paramBundle = getIntent();
    ab.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      ab.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aq(1, "");
      finish();
    }
    for (;;)
    {
      bej();
      initView();
      AppMethodBeat.o(88570);
      return;
      this.ejF = paramBundle.getIntExtra("key_from_scene", 0);
      ab.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.ejF);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.kwG = paramBundle.getIntExtra("shop_id", 0);
      this.kwH = paramBundle.getStringExtra("sign_type");
      this.kwI = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.kwJ = paramBundle.getStringExtra("nonce_str");
      this.kml = paramBundle.getStringExtra("card_tp_id");
      this.kwK = paramBundle.getStringExtra("card_type");
      this.kwL = paramBundle.getIntExtra("can_multi_select", 0);
      this.ksP = paramBundle.getStringExtra("key_package_name");
      this.ksQ = paramBundle.getStringExtra("key_transaction");
      ab.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.kwG + " sign_type:" + this.kwH + " time_stamp:" + this.time_stamp);
      ab.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.kwJ + " card_tp_id:" + this.kml + " card_type:" + this.kwK + " canMultiSelect:" + this.kwL + " packateName:" + this.ksP);
      if ("INVOICE".equalsIgnoreCase(this.kwK)) {
        this.kwN = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        ab.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aq(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88577);
    am.bcp().b(this);
    super.onDestroy();
    AppMethodBeat.o(88577);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(88581);
    if (paramInt == 4)
    {
      setResult(0);
      aq(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(88581);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(88573);
    if ((paramm instanceof aj))
    {
      com.tencent.mm.kernel.g.RK().eHt.b(664, this);
      fV(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((aj)paramm).koi;
      ab.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = a.HH(paramString);
      LinkedList localLinkedList2 = a.HI(paramString);
      this.kwM = Ii(paramString);
      if ((this.koK == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.kwC.clear();
        this.eyN.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.kwD))
        {
          this.kwD = true;
          if (!this.kwN) {
            break label208;
          }
        }
        label208:
        for (((a)localLinkedList1.get(0)).jTi = getString(2131298031);; ((a)localLinkedList1.get(0)).jTi = getString(2131298030))
        {
          paramInt1 = this.eyN.size();
          this.eyN.addAll(localLinkedList1);
          while (paramInt1 < this.eyN.size())
          {
            this.kwC.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.kwE))
        {
          this.kwE = true;
          ((a)localLinkedList2.get(0)).jTi = getString(2131297892);
        }
        paramInt1 = this.eyN.size();
        this.eyN.addAll(localLinkedList2);
        while (paramInt1 < this.eyN.size())
        {
          this.kwC.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.eRq = ((aj)paramm).eRq;
      this.koK = ((aj)paramm).koK;
      this.krV.notifyDataSetChanged();
      if (this.eyN.size() == 0) {
        break label404;
      }
      this.xy.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.krG = false;
      AppMethodBeat.o(88573);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.xy.setVisibility(0);
      this.mListView.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */