package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements i, j.a
{
  private View GQ;
  private String app_id;
  private int gwE;
  private com.tencent.mm.ui.base.q gxX;
  LinkedList<com.tencent.mm.plugin.card.model.a> heS;
  boolean idt;
  private ListView mListView;
  private String pRX;
  com.tencent.mm.bw.b pUz;
  private boolean pXJ;
  private BaseAdapter pXY;
  private String pYS;
  private String pYT;
  private TextView qcA;
  private RelativeLayout qcB;
  private TextView qcC;
  private TextView qcD;
  boolean qcE;
  HashMap<Integer, Boolean> qcF;
  private boolean qcG;
  private boolean qcH;
  private boolean qcI;
  private int qcJ;
  private String qcK;
  private String qcL;
  private String qcM;
  private String qcN;
  private int qcO;
  public String qcP;
  private boolean qcQ;
  private com.tencent.mm.plugin.card.model.a qcR;
  private int time_stamp;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.gxX = null;
    this.qcE = false;
    this.heS = new LinkedList();
    this.qcF = new HashMap();
    this.idt = true;
    this.pUz = null;
    this.pXJ = false;
    this.pYS = "";
    this.qcQ = false;
    this.gwE = 0;
    AppMethodBeat.o(113496);
  }
  
  private void aN(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.gwE != 8)
    {
      Log.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.gwE);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = h.o(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
    }
    localResp.transaction = this.pYT;
    String str2 = this.app_id;
    String str1;
    if (localObject == null)
    {
      str1 = "null appinfo";
      if (localObject != null) {
        break label263;
      }
      localObject = "null appinfo";
      label130:
      Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.pYT });
      localResp.toBundle(localBundle);
      Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      Log.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label273;
      }
    }
    label263:
    label273:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.pYS;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bo(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bp(localBundle);
      MMessageActV2.send(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
      break label130;
    }
  }
  
  private static String ajJ(String paramString)
  {
    AppMethodBeat.i(113501);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(113501);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("rule_url");
      AppMethodBeat.o(113501);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(113501);
    }
    return null;
  }
  
  private void cvn()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = cwe();
    if (this.qcQ) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aN(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void cwd()
  {
    AppMethodBeat.i(113498);
    if (this.pXJ)
    {
      Log.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.pUz == null)
    {
      this.qcG = false;
      this.qcH = false;
      this.qcI = false;
    }
    com.tencent.mm.kernel.g.aAg().hqi.a(1059, this);
    aj localaj = new aj(this.app_id, this.qcJ, this.qcK, this.qcL, this.time_stamp, this.qcM, this.pRX, this.qcN, this.pUz);
    com.tencent.mm.kernel.g.aAg().hqi.a(localaj, 0);
    ku(true);
    this.pXJ = true;
    if (this.qcO == 1) {
      this.qcE = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String cwe()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.heS.size())
    {
      localObject2 = (Boolean)this.qcF.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.heS.get(i));
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
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)((ArrayList)localObject1).get(i);
      ((StringBuilder)localObject2).append("{");
      ((StringBuilder)localObject2).append("\"card_id\":");
      ((StringBuilder)localObject2).append("\"" + locala.pRX + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.pSa + "\"");
      if (this.qcQ)
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
    AppMethodBeat.o(113507);
    return localObject1;
  }
  
  public final void ajf(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    ku(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.qcR.pSc)))
    {
      Log.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    Log.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    Log.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.pRL + " markCardId: " + paramb.pRM);
    if (paramb.pRL == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.pRM)) && (!paramString.equals(paramb.pRM)))
      {
        Log.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.heS.size())
        {
          if (((com.tencent.mm.plugin.card.model.a)this.heS.get(i)).pSc != paramb.pRM) {
            break label230;
          }
          while (j < this.heS.size())
          {
            this.qcF.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.qcF.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        cvn();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        Log.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(2131757097));
    AppMethodBeat.o(113502);
  }
  
  public final void fq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    ku(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.qcR.pSc)))
    {
      Log.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    Log.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131757096);
    }
    d.c(this, paramString1);
    AppMethodBeat.o(113503);
  }
  
  public int getLayoutId()
  {
    return 2131493410;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113499);
    if (this.qcQ)
    {
      setMMTitle(2131757091);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(113482);
          CardListSelectedUI.this.setResult(0);
          CardListSelectedUI.a(CardListSelectedUI.this, "");
          CardListSelectedUI.this.finish();
          AppMethodBeat.o(113482);
          return true;
        }
      });
      if (!this.qcQ)
      {
        addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.qcE) && (CardListSelectedUI.b(CardListSelectedUI.this).pSh))
            {
              CardListSelectedUI.this.ku(true);
              am.cuc().V(CardListSelectedUI.b(CardListSelectedUI.this).pSc, l.akk(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
            }
            for (;;)
            {
              AppMethodBeat.o(113483);
              return true;
              CardListSelectedUI.a(CardListSelectedUI.this);
            }
          }
        });
        enableOptionMenu(false);
      }
      this.mListView = ((ListView)findViewById(2131298157));
      if (!this.qcQ) {
        break label288;
      }
    }
    label288:
    for (this.pXY = new b();; this.pXY = new a())
    {
      this.mListView.setAdapter(this.pXY);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            Log.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.qcE)
          {
            bool = ((Boolean)CardListSelectedUI.this.qcF.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.qcF;
            if (!bool)
            {
              bool = true;
              paramAnonymousAdapterView.put(Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool));
            }
          }
          for (;;)
          {
            CardListSelectedUI.c(CardListSelectedUI.this).notifyDataSetChanged();
            CardListSelectedUI.d(CardListSelectedUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
            bool = false;
            break;
            while (i < CardListSelectedUI.this.heS.size())
            {
              CardListSelectedUI.this.qcF.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.qcF.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.heS.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.idt))
          {
            Log.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.GQ = findViewById(2131299212);
      this.qcA = ((TextView)findViewById(2131305445));
      if (this.qcQ) {
        this.qcA.setText(getString(2131757132));
      }
      this.qcB = ((RelativeLayout)findViewById(2131302736));
      this.qcC = ((TextView)findViewById(2131302753));
      this.qcD = ((TextView)findViewById(2131302748));
      if (!this.qcQ) {
        break label303;
      }
      this.qcB.setVisibility(0);
      this.qcC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!Util.isNullOrNil(CardListSelectedUI.this.qcP)) {
            com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.qcP, CardListSelectedUI.this.getString(2131757079));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113486);
        }
      });
      this.qcD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113487);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          CardListSelectedUI.a(CardListSelectedUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113487);
        }
      });
      AppMethodBeat.o(113499);
      return;
      setMMTitle(2131757090);
      break;
    }
    label303:
    this.qcB.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  protected final void ku(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.gxX = com.tencent.mm.ui.base.q.a(this, getString(2131762446), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.gxX != null) && (this.gxX.isShowing()))
    {
      this.gxX.dismiss();
      this.gxX = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.cuc().a(this);
    paramBundle = getIntent();
    Log.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aN(1, "");
      finish();
    }
    for (;;)
    {
      cwd();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.gwE = paramBundle.getIntExtra("key_from_scene", 0);
      Log.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.gwE);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.qcJ = paramBundle.getIntExtra("shop_id", 0);
      this.qcK = paramBundle.getStringExtra("sign_type");
      this.qcL = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.qcM = paramBundle.getStringExtra("nonce_str");
      this.pRX = paramBundle.getStringExtra("card_tp_id");
      this.qcN = paramBundle.getStringExtra("card_type");
      this.qcO = paramBundle.getIntExtra("can_multi_select", 0);
      this.pYS = paramBundle.getStringExtra("key_package_name");
      this.pYT = paramBundle.getStringExtra("key_transaction");
      Log.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.qcJ + " sign_type:" + this.qcK + " time_stamp:" + this.time_stamp);
      Log.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.qcM + " card_tp_id:" + this.pRX + " card_type:" + this.qcN + " canMultiSelect:" + this.qcO + " packateName:" + this.pYS);
      if ("INVOICE".equalsIgnoreCase(this.qcN)) {
        this.qcQ = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aN(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.cuc().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aN(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113508);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(113500);
    if ((paramq instanceof aj))
    {
      com.tencent.mm.kernel.g.aAg().hqi.b(1059, this);
      ku(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((aj)paramq).pTY;
      Log.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = com.tencent.mm.plugin.card.model.a.aji(paramString);
      LinkedList localLinkedList2 = com.tencent.mm.plugin.card.model.a.ajj(paramString);
      this.qcP = ajJ(paramString);
      if ((this.pUz == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.qcF.clear();
        this.heS.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.qcG))
        {
          this.qcG = true;
          if (!this.qcQ) {
            break label208;
          }
        }
        label208:
        for (((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).pnW = getString(2131757143);; ((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).pnW = getString(2131757142))
        {
          paramInt1 = this.heS.size();
          this.heS.addAll(localLinkedList1);
          while (paramInt1 < this.heS.size())
          {
            this.qcF.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.qcH))
        {
          this.qcH = true;
          ((com.tencent.mm.plugin.card.model.a)localLinkedList2.get(0)).pnW = getString(2131756989);
        }
        paramInt1 = this.heS.size();
        this.heS.addAll(localLinkedList2);
        while (paramInt1 < this.heS.size())
        {
          this.qcF.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.idt = ((aj)paramq).idt;
      this.pUz = ((aj)paramq).pUz;
      this.pXY.notifyDataSetChanged();
      if (this.heS.size() == 0) {
        break label404;
      }
      this.GQ.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.pXJ = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.GQ.setVisibility(0);
      this.mListView.setVisibility(8);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    private com.tencent.mm.plugin.card.model.a Eu(int paramInt)
    {
      AppMethodBeat.i(113489);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.heS.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.heS.size();
      AppMethodBeat.o(113488);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113490);
      Object localObject = Eu(paramInt);
      label186:
      label217:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493431, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.qcZ = ((ImageView)paramView.findViewById(2131303814));
        paramViewGroup.hbb = ((TextView)paramView.findViewById(2131309195));
        paramViewGroup.qcV = ((TextView)paramView.findViewById(2131308717));
        paramViewGroup.qda = ((TextView)paramView.findViewById(2131297117));
        paramViewGroup.pnP = ((TextView)paramView.findViewById(2131298244));
        paramViewGroup.qdb = paramView.findViewById(2131297649);
        paramViewGroup.qdc = ((ImageView)paramView.findViewById(2131298212));
        paramView.setTag(paramViewGroup);
        if (!l.Eg(((com.tencent.mm.plugin.card.model.a)localObject).nHh)) {
          break label389;
        }
        paramViewGroup.hbb.setText(((com.tencent.mm.plugin.card.model.a)localObject).pRY);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).title)) {
          break label347;
        }
        paramViewGroup.qcV.setVisibility(0);
        paramViewGroup.qcV.setText(((com.tencent.mm.plugin.card.model.a)localObject).title);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).pRZ)) {
          break label359;
        }
        paramViewGroup.qda.setVisibility(0);
        paramViewGroup.qda.setText(((com.tencent.mm.plugin.card.model.a)localObject).pRZ);
        TextView localTextView = paramViewGroup.pnP;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.card.model.a)localObject).pnW)) {
          break label371;
        }
        i = 8;
        label238:
        localTextView.setVisibility(i);
        paramViewGroup.pnP.setText(((com.tencent.mm.plugin.card.model.a)localObject).pnW);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(2131166028);
        CardListSelectedUI.a(paramViewGroup.qcZ, ((com.tencent.mm.plugin.card.model.a)localObject).iwv, i);
        localObject = (Boolean)CardListSelectedUI.this.qcF.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label377;
        }
        paramViewGroup.qdc.setImageResource(2131231488);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label347:
        paramViewGroup.qcV.setVisibility(8);
        break label186;
        label359:
        paramViewGroup.qda.setVisibility(8);
        break label217;
        label371:
        i = 0;
        break label238;
        label377:
        paramViewGroup.qdc.setImageResource(2131231489);
        continue;
        label389:
        Log.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.plugin.card.model.a Eu(int paramInt)
    {
      AppMethodBeat.i(113493);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.heS.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.heS.size();
      AppMethodBeat.o(113492);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113494);
      com.tencent.mm.plugin.card.model.a locala = Eu(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493430, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.qcT = ((ImageView)paramView.findViewById(2131298212));
        paramViewGroup.qcU = ((TextView)paramView.findViewById(2131302747));
        paramViewGroup.hbb = ((TextView)paramView.findViewById(2131309195));
        paramViewGroup.qcV = ((TextView)paramView.findViewById(2131308717));
        paramViewGroup.qcW = paramView.findViewById(2131309665);
        paramViewGroup.qcX = ((TextView)paramView.findViewById(2131302751));
        paramViewGroup.qcY = ((TextView)paramView.findViewById(2131302739));
        paramView.setTag(paramViewGroup);
        if (!l.Eg(locala.nHh)) {
          break label549;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label387;
        }
        paramViewGroup.hbb.setVisibility(0);
        paramViewGroup.hbb.setText(locala.title);
        label174:
        if (TextUtils.isEmpty(locala.pRY)) {
          break label399;
        }
        paramViewGroup.qcV.setVisibility(0);
        paramViewGroup.qcV.setText(locala.pRY);
        label205:
        if (locala.pSd != 0) {
          break label423;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.qcT.setVisibility(0);
        paramViewGroup.qcU.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.qcF.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label411;
        }
        paramViewGroup.qcT.setImageResource(2131231488);
        label276:
        if (Util.isNullOrNil(locala.pSe)) {
          break label514;
        }
        paramViewGroup.qcX.setVisibility(0);
        paramViewGroup.qcX.setText(locala.pSe);
        label307:
        if (Util.isNullOrNil(locala.pSf)) {
          break label526;
        }
        paramViewGroup.qcY.setVisibility(0);
        paramViewGroup.qcY.setText(locala.pSf);
        label338:
        if ((!Util.isNullOrNil(locala.pSe)) || (!Util.isNullOrNil(locala.pSf))) {
          break label538;
        }
        paramViewGroup.qcW.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label387:
        paramViewGroup.hbb.setVisibility(8);
        break label174;
        label399:
        paramViewGroup.qcV.setVisibility(8);
        break label205;
        label411:
        paramViewGroup.qcT.setImageResource(2131231489);
        break label276;
        label423:
        if (locala.pSd == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.qcT.setVisibility(8);
          if (!Util.isNullOrNil(locala.pSg))
          {
            paramViewGroup.qcU.setVisibility(0);
            paramViewGroup.qcU.setText(locala.pSg);
            break label276;
          }
          paramViewGroup.qcU.setVisibility(8);
          break label276;
        }
        paramViewGroup.qcT.setVisibility(8);
        paramViewGroup.qcU.setVisibility(8);
        break label276;
        label514:
        paramViewGroup.qcX.setVisibility(8);
        break label307;
        label526:
        paramViewGroup.qcY.setVisibility(8);
        break label338;
        label538:
        paramViewGroup.qcW.setVisibility(0);
        continue;
        label549:
        Log.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView hbb;
    public ImageView qcT;
    public TextView qcU;
    public TextView qcV;
    public View qcW;
    public TextView qcX;
    public TextView qcY;
    
    c() {}
  }
  
  final class d
  {
    public TextView hbb;
    public TextView pnP;
    public TextView qcV;
    public ImageView qcZ;
    public TextView qda;
    public View qdb;
    public ImageView qdc;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */