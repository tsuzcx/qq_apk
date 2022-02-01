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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements f, j.a
{
  private View GG;
  private String app_id;
  private int fPp;
  private p fQJ;
  LinkedList<com.tencent.mm.plugin.card.model.a> gqI;
  boolean hhJ;
  private ListView mListView;
  com.tencent.mm.bx.b oAr;
  private BaseAdapter oDI;
  private boolean oDt;
  private String oEC;
  private String oED;
  private boolean oIA;
  private com.tencent.mm.plugin.card.model.a oIB;
  private TextView oIk;
  private RelativeLayout oIl;
  private TextView oIm;
  private TextView oIn;
  boolean oIo;
  HashMap<Integer, Boolean> oIp;
  private boolean oIq;
  private boolean oIr;
  private boolean oIs;
  private int oIt;
  private String oIu;
  private String oIv;
  private String oIw;
  private String oIx;
  private int oIy;
  public String oIz;
  private String oxM;
  private int time_stamp;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.fQJ = null;
    this.oIo = false;
    this.gqI = new LinkedList();
    this.oIp = new HashMap();
    this.hhJ = true;
    this.oAr = null;
    this.oDt = false;
    this.oEC = "";
    this.oIA = false;
    this.fPp = 0;
    AppMethodBeat.o(113496);
  }
  
  private static String YN(String paramString)
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
      ad.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
      AppMethodBeat.o(113501);
    }
    return null;
  }
  
  private void aJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.fPp != 8)
    {
      ad.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.fPp);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = h.m(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
    }
    localResp.transaction = this.oED;
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
      ad.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.oED });
      localResp.toBundle(localBundle);
      ad.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(paramInt)));
      ad.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(paramString)));
      if (paramInt != -1) {
        break label273;
      }
    }
    label263:
    label273:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.oEC;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.q.bb(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
      MMessageActV2.send(com.tencent.mm.sdk.platformtools.aj.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_openId;
      break label130;
    }
  }
  
  private void bWY()
  {
    AppMethodBeat.i(113498);
    if (this.oDt)
    {
      ad.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.oAr == null)
    {
      this.oIq = false;
      this.oIr = false;
      this.oIs = false;
    }
    com.tencent.mm.kernel.g.ajB().gAO.a(1059, this);
    com.tencent.mm.plugin.card.model.aj localaj = new com.tencent.mm.plugin.card.model.aj(this.app_id, this.oIt, this.oIu, this.oIv, this.time_stamp, this.oIw, this.oxM, this.oIx, this.oAr);
    com.tencent.mm.kernel.g.ajB().gAO.a(localaj, 0);
    jt(true);
    this.oDt = true;
    if (this.oIy == 1) {
      this.oIo = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String bWZ()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.gqI.size())
    {
      localObject2 = (Boolean)this.oIp.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add(this.gqI.get(i));
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
      ((StringBuilder)localObject2).append("\"" + locala.oxM + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.oxP + "\"");
      if (this.oIA)
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
  
  private void bWi()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = bWZ();
    if (this.oIA) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aJ(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  public final void Yj(String paramString) {}
  
  public final void b(String paramString, j.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    jt(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.oIB.oxR)))
    {
      ad.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    ad.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    ad.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.oxA + " markCardId: " + paramb.oxB);
    if (paramb.oxA == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.oxB)) && (!paramString.equals(paramb.oxB)))
      {
        ad.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.gqI.size())
        {
          if (((com.tencent.mm.plugin.card.model.a)this.gqI.get(i)).oxR != paramb.oxB) {
            break label230;
          }
          while (j < this.gqI.size())
          {
            this.oIp.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.oIp.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        bWi();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        ad.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.c(this, getString(2131756927));
    AppMethodBeat.o(113502);
  }
  
  public final void eV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    jt(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.oIB.oxR)))
    {
      ad.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    ad.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131756926);
    }
    d.c(this, paramString1);
    AppMethodBeat.o(113503);
  }
  
  public int getLayoutId()
  {
    return 2131493319;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113499);
    if (this.oIA)
    {
      setMMTitle(2131756921);
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
      if (!this.oIA)
      {
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.oIo) && (CardListSelectedUI.b(CardListSelectedUI.this).oxW))
            {
              CardListSelectedUI.this.jt(true);
              am.bUZ().U(CardListSelectedUI.b(CardListSelectedUI.this).oxR, l.Zn(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
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
      this.mListView = ((ListView)findViewById(2131297841));
      if (!this.oIA) {
        break label288;
      }
    }
    label288:
    for (this.oDI = new b();; this.oDI = new a())
    {
      this.mListView.setAdapter(this.oDI);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            ad.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.oIo)
          {
            bool = ((Boolean)CardListSelectedUI.this.oIp.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.oIp;
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
            while (i < CardListSelectedUI.this.gqI.size())
            {
              CardListSelectedUI.this.oIp.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.oIp.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.gqI.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.hhJ))
          {
            ad.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.GG = findViewById(2131298768);
      this.oIk = ((TextView)findViewById(2131302872));
      if (this.oIA) {
        this.oIk.setText(getString(2131756962));
      }
      this.oIl = ((RelativeLayout)findViewById(2131301082));
      this.oIm = ((TextView)findViewById(2131301099));
      this.oIn = ((TextView)findViewById(2131301094));
      if (!this.oIA) {
        break label303;
      }
      this.oIl.setVisibility(0);
      this.oIm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!bt.isNullOrNil(CardListSelectedUI.this.oIz)) {
            com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.oIz, CardListSelectedUI.this.getString(2131756909));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113486);
        }
      });
      this.oIn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113487);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          CardListSelectedUI.a(CardListSelectedUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113487);
        }
      });
      AppMethodBeat.o(113499);
      return;
      setMMTitle(2131756920);
      break;
    }
    label303:
    this.oIl.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  protected final void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.fQJ = p.a(this, getString(2131760709), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.fQJ != null) && (this.fQJ.isShowing()))
    {
      this.fQJ.dismiss();
      this.fQJ = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.bUZ().a(this);
    paramBundle = getIntent();
    ad.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      ad.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aJ(1, "");
      finish();
    }
    for (;;)
    {
      bWY();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.fPp = paramBundle.getIntExtra("key_from_scene", 0);
      ad.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.fPp);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.oIt = paramBundle.getIntExtra("shop_id", 0);
      this.oIu = paramBundle.getStringExtra("sign_type");
      this.oIv = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.oIw = paramBundle.getStringExtra("nonce_str");
      this.oxM = paramBundle.getStringExtra("card_tp_id");
      this.oIx = paramBundle.getStringExtra("card_type");
      this.oIy = paramBundle.getIntExtra("can_multi_select", 0);
      this.oEC = paramBundle.getStringExtra("key_package_name");
      this.oED = paramBundle.getStringExtra("key_transaction");
      ad.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.oIt + " sign_type:" + this.oIu + " time_stamp:" + this.time_stamp);
      ad.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.oIw + " card_tp_id:" + this.oxM + " card_type:" + this.oIx + " canMultiSelect:" + this.oIy + " packateName:" + this.oEC);
      if ("INVOICE".equalsIgnoreCase(this.oIx)) {
        this.oIA = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        ad.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aJ(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.bUZ().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aJ(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113508);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113500);
    if ((paramn instanceof com.tencent.mm.plugin.card.model.aj))
    {
      com.tencent.mm.kernel.g.ajB().gAO.b(1059, this);
      jt(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((com.tencent.mm.plugin.card.model.aj)paramn).ozQ;
      ad.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = com.tencent.mm.plugin.card.model.a.Ym(paramString);
      LinkedList localLinkedList2 = com.tencent.mm.plugin.card.model.a.Yn(paramString);
      this.oIz = YN(paramString);
      if ((this.oAr == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.oIp.clear();
        this.gqI.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.oIq))
        {
          this.oIq = true;
          if (!this.oIA) {
            break label208;
          }
        }
        label208:
        for (((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).nXq = getString(2131756973);; ((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).nXq = getString(2131756972))
        {
          paramInt1 = this.gqI.size();
          this.gqI.addAll(localLinkedList1);
          while (paramInt1 < this.gqI.size())
          {
            this.oIp.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.oIr))
        {
          this.oIr = true;
          ((com.tencent.mm.plugin.card.model.a)localLinkedList2.get(0)).nXq = getString(2131756824);
        }
        paramInt1 = this.gqI.size();
        this.gqI.addAll(localLinkedList2);
        while (paramInt1 < this.gqI.size())
        {
          this.oIp.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.hhJ = ((com.tencent.mm.plugin.card.model.aj)paramn).hhJ;
      this.oAr = ((com.tencent.mm.plugin.card.model.aj)paramn).oAr;
      this.oDI.notifyDataSetChanged();
      if (this.gqI.size() == 0) {
        break label404;
      }
      this.GG.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.oDt = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.GG.setVisibility(0);
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
    
    private com.tencent.mm.plugin.card.model.a AD(int paramInt)
    {
      AppMethodBeat.i(113489);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.gqI.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.gqI.size();
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
      Object localObject = AD(paramInt);
      label186:
      label217:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493340, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.oIJ = ((ImageView)paramView.findViewById(2131301584));
        paramViewGroup.gnM = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.oIF = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.oIK = ((TextView)paramView.findViewById(2131296994));
        paramViewGroup.nXj = ((TextView)paramView.findViewById(2131297925));
        paramViewGroup.oIL = paramView.findViewById(2131297424);
        paramViewGroup.oIM = ((ImageView)paramView.findViewById(2131297894));
        paramView.setTag(paramViewGroup);
        if (!l.Ap(((com.tencent.mm.plugin.card.model.a)localObject).mrl)) {
          break label389;
        }
        paramViewGroup.gnM.setText(((com.tencent.mm.plugin.card.model.a)localObject).oxN);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).title)) {
          break label347;
        }
        paramViewGroup.oIF.setVisibility(0);
        paramViewGroup.oIF.setText(((com.tencent.mm.plugin.card.model.a)localObject).title);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).oxO)) {
          break label359;
        }
        paramViewGroup.oIK.setVisibility(0);
        paramViewGroup.oIK.setText(((com.tencent.mm.plugin.card.model.a)localObject).oxO);
        TextView localTextView = paramViewGroup.nXj;
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.card.model.a)localObject).nXq)) {
          break label371;
        }
        i = 8;
        label238:
        localTextView.setVisibility(i);
        paramViewGroup.nXj.setText(((com.tencent.mm.plugin.card.model.a)localObject).nXq);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(2131165996);
        CardListSelectedUI.a(paramViewGroup.oIJ, ((com.tencent.mm.plugin.card.model.a)localObject).hzB, i);
        localObject = (Boolean)CardListSelectedUI.this.oIp.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label377;
        }
        paramViewGroup.oIM.setImageResource(2131231424);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label347:
        paramViewGroup.oIF.setVisibility(8);
        break label186;
        label359:
        paramViewGroup.oIK.setVisibility(8);
        break label217;
        label371:
        i = 0;
        break label238;
        label377:
        paramViewGroup.oIM.setImageResource(2131231425);
        continue;
        label389:
        ad.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.plugin.card.model.a AD(int paramInt)
    {
      AppMethodBeat.i(113493);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.gqI.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.gqI.size();
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
      com.tencent.mm.plugin.card.model.a locala = AD(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, 2131493339, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.oID = ((ImageView)paramView.findViewById(2131297894));
        paramViewGroup.oIE = ((TextView)paramView.findViewById(2131301093));
        paramViewGroup.gnM = ((TextView)paramView.findViewById(2131305902));
        paramViewGroup.oIF = ((TextView)paramView.findViewById(2131305508));
        paramViewGroup.oIG = paramView.findViewById(2131306261);
        paramViewGroup.oIH = ((TextView)paramView.findViewById(2131301097));
        paramViewGroup.oII = ((TextView)paramView.findViewById(2131301085));
        paramView.setTag(paramViewGroup);
        if (!l.Ap(locala.mrl)) {
          break label549;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label387;
        }
        paramViewGroup.gnM.setVisibility(0);
        paramViewGroup.gnM.setText(locala.title);
        label174:
        if (TextUtils.isEmpty(locala.oxN)) {
          break label399;
        }
        paramViewGroup.oIF.setVisibility(0);
        paramViewGroup.oIF.setText(locala.oxN);
        label205:
        if (locala.oxS != 0) {
          break label423;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.oID.setVisibility(0);
        paramViewGroup.oIE.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.oIp.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label411;
        }
        paramViewGroup.oID.setImageResource(2131231424);
        label276:
        if (bt.isNullOrNil(locala.oxT)) {
          break label514;
        }
        paramViewGroup.oIH.setVisibility(0);
        paramViewGroup.oIH.setText(locala.oxT);
        label307:
        if (bt.isNullOrNil(locala.oxU)) {
          break label526;
        }
        paramViewGroup.oII.setVisibility(0);
        paramViewGroup.oII.setText(locala.oxU);
        label338:
        if ((!bt.isNullOrNil(locala.oxT)) || (!bt.isNullOrNil(locala.oxU))) {
          break label538;
        }
        paramViewGroup.oIG.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label387:
        paramViewGroup.gnM.setVisibility(8);
        break label174;
        label399:
        paramViewGroup.oIF.setVisibility(8);
        break label205;
        label411:
        paramViewGroup.oID.setImageResource(2131231425);
        break label276;
        label423:
        if (locala.oxS == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.oID.setVisibility(8);
          if (!bt.isNullOrNil(locala.oxV))
          {
            paramViewGroup.oIE.setVisibility(0);
            paramViewGroup.oIE.setText(locala.oxV);
            break label276;
          }
          paramViewGroup.oIE.setVisibility(8);
          break label276;
        }
        paramViewGroup.oID.setVisibility(8);
        paramViewGroup.oIE.setVisibility(8);
        break label276;
        label514:
        paramViewGroup.oIH.setVisibility(8);
        break label307;
        label526:
        paramViewGroup.oII.setVisibility(8);
        break label338;
        label538:
        paramViewGroup.oIG.setVisibility(0);
        continue;
        label549:
        ad.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView gnM;
    public ImageView oID;
    public TextView oIE;
    public TextView oIF;
    public View oIG;
    public TextView oIH;
    public TextView oII;
    
    c() {}
  }
  
  final class d
  {
    public TextView gnM;
    public TextView nXj;
    public TextView oIF;
    public ImageView oIJ;
    public TextView oIK;
    public View oIL;
    public ImageView oIM;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */