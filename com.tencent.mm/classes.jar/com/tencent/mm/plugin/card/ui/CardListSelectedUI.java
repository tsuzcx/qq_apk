package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.mgr.i;
import com.tencent.mm.plugin.card.mgr.i.a;
import com.tencent.mm.plugin.card.mgr.i.b;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements com.tencent.mm.am.h, i.a
{
  private String app_id;
  private View bEx;
  private int lCR;
  private w lKp;
  private ListView mListView;
  LinkedList<com.tencent.mm.plugin.card.model.a> mpS;
  boolean nxG;
  private int time_stamp;
  private TextView wCU;
  private RelativeLayout wCV;
  private TextView wCW;
  private TextView wCX;
  boolean wCY;
  HashMap<Integer, Boolean> wCZ;
  private boolean wDa;
  private boolean wDb;
  private boolean wDc;
  private int wDd;
  private String wDe;
  private String wDf;
  private String wDg;
  private String wDh;
  private int wDi;
  public String wDj;
  private boolean wDk;
  private com.tencent.mm.plugin.card.model.a wDl;
  private String wsy;
  com.tencent.mm.bx.b wuZ;
  private boolean wyc;
  private BaseAdapter wyr;
  private String wzl;
  private String wzm;
  
  public CardListSelectedUI()
  {
    AppMethodBeat.i(113496);
    this.lKp = null;
    this.wCY = false;
    this.mpS = new LinkedList();
    this.wCZ = new HashMap();
    this.nxG = true;
    this.wuZ = null;
    this.wyc = false;
    this.wzl = "";
    this.wDk = false;
    this.lCR = 0;
    AppMethodBeat.o(113496);
  }
  
  private void aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(113509);
    if (this.lCR != 8)
    {
      Log.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.lCR);
      AppMethodBeat.o(113509);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(this.app_id, true, false);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((g)localObject).field_openId;
    }
    localResp.transaction = this.wzm;
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
      Log.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.wzm });
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
      paramString.targetPkgName = this.wzl;
      paramString.bundle = localBundle;
      u.bS(localBundle);
      u.bT(localBundle);
      MMessageActV2.send(MMApplicationContext.getContext(), paramString);
      AppMethodBeat.o(113509);
      return;
      str1 = ((g)localObject).field_appName;
      break;
      localObject = ((g)localObject).field_openId;
      break label130;
    }
  }
  
  private static String alb(String paramString)
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
  
  private void dmV()
  {
    AppMethodBeat.i(113498);
    if (this.wyc)
    {
      Log.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
      AppMethodBeat.o(113498);
      return;
    }
    if (this.wuZ == null)
    {
      this.wDa = false;
      this.wDb = false;
      this.wDc = false;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(1059, this);
    aj localaj = new aj(this.app_id, this.wDd, this.wDe, this.wDf, this.time_stamp, this.wDg, this.wsy, this.wDh, this.wuZ);
    com.tencent.mm.kernel.h.baD().mCm.a(localaj, 0);
    na(true);
    this.wyc = true;
    if (this.wDi == 1) {
      this.wCY = true;
    }
    AppMethodBeat.o(113498);
  }
  
  private String dmW()
  {
    int j = 0;
    AppMethodBeat.i(113507);
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < this.mpS.size())
    {
      localObject2 = (Boolean)this.wCZ.get(Integer.valueOf(i));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        ((ArrayList)localObject1).add((com.tencent.mm.plugin.card.model.a)this.mpS.get(i));
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
      ((StringBuilder)localObject2).append("\"" + locala.wsy + "\"");
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append("\"encrypt_code\":");
      ((StringBuilder)localObject2).append("\"" + locala.wsB + "\"");
      if (this.wDk)
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
  
  private void dmh()
  {
    AppMethodBeat.i(113506);
    Intent localIntent = new Intent();
    String str = dmW();
    if (this.wDk) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      aZ(-1, str);
      finish();
      AppMethodBeat.o(113506);
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  public final void akx(String paramString) {}
  
  public final void b(String paramString, i.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(113502);
    na(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.wDl.wsC)))
    {
      Log.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113502);
      return;
    }
    Log.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    Log.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.wsm + " markCardId: " + paramb.wsn);
    if (paramb.wsm == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.wsn)) && (!paramString.equals(paramb.wsn)))
      {
        Log.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.mpS.size())
        {
          if (((com.tencent.mm.plugin.card.model.a)this.mpS.get(i)).wsC != paramb.wsn) {
            break label230;
          }
          while (j < this.mpS.size())
          {
            this.wCZ.put(Integer.valueOf(j), Boolean.FALSE);
            j += 1;
          }
          this.wCZ.put(Integer.valueOf(i), Boolean.TRUE);
        }
      }
      for (;;)
      {
        dmh();
        AppMethodBeat.o(113502);
        return;
        label230:
        i += 1;
        break;
        Log.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.b(this, getString(a.g.wpt));
    AppMethodBeat.o(113502);
  }
  
  public final void gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113503);
    na(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.wDl.wsC)))
    {
      Log.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113503);
      return;
    }
    Log.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(a.g.wps);
    }
    d.b(this, paramString1);
    AppMethodBeat.o(113503);
  }
  
  public int getLayoutId()
  {
    return a.e.wnp;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113499);
    if (this.wDk)
    {
      setMMTitle(a.g.wpn);
      setMMSubTitle(a.g.wpl);
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
      if (!this.wDk)
      {
        addTextOptionMenu(0, getString(a.g.app_finish), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(113483);
            if ((!CardListSelectedUI.this.wCY) && (CardListSelectedUI.b(CardListSelectedUI.this).wsH))
            {
              CardListSelectedUI.this.na(true);
              am.dkV().ab(CardListSelectedUI.b(CardListSelectedUI.this).wsC, l.alB(CardListSelectedUI.b(CardListSelectedUI.this).userName), 3);
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
      this.mListView = ((ListView)findViewById(a.d.wgS));
      if (!this.wDk) {
        break label295;
      }
    }
    label295:
    for (this.wyr = new b();; this.wyr = new a())
    {
      this.mListView.setAdapter(this.wyr);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 0;
          AppMethodBeat.i(113484);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (paramAnonymousView.getAlpha() != 1.0F)
          {
            Log.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(113484);
            return;
          }
          boolean bool;
          if (CardListSelectedUI.this.wCY)
          {
            bool = ((Boolean)CardListSelectedUI.this.wCZ.get(Integer.valueOf(paramAnonymousInt))).booleanValue();
            paramAnonymousAdapterView = CardListSelectedUI.this.wCZ;
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
            while (i < CardListSelectedUI.this.mpS.size())
            {
              CardListSelectedUI.this.wCZ.put(Integer.valueOf(i), Boolean.FALSE);
              i += 1;
            }
            CardListSelectedUI.this.wCZ.put(Integer.valueOf(paramAnonymousInt), Boolean.TRUE);
            CardListSelectedUI.a(CardListSelectedUI.this, (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.mpS.get(paramAnonymousInt));
          }
        }
      });
      this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(113485);
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.nxG))
          {
            Log.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
          AppMethodBeat.o(113485);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.bEx = findViewById(a.d.wjH);
      this.wCU = ((TextView)findViewById(a.d.wkG));
      if (this.wDk) {
        this.wCU.setText(getString(a.g.wpP));
      }
      this.wCV = ((RelativeLayout)findViewById(a.d.wkm));
      this.wCW = ((TextView)findViewById(a.d.wkq));
      this.wCX = ((TextView)findViewById(a.d.wkp));
      if (!this.wDk) {
        break label310;
      }
      this.wCV.setVisibility(0);
      this.wCW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113486);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!Util.isNullOrNil(CardListSelectedUI.this.wDj)) {
            com.tencent.mm.plugin.card.c.b.a(CardListSelectedUI.this, CardListSelectedUI.this.wDj, CardListSelectedUI.this.getString(a.g.wpg));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113486);
        }
      });
      this.wCX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113487);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          CardListSelectedUI.a(CardListSelectedUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListSelectedUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113487);
        }
      });
      AppMethodBeat.o(113499);
      return;
      setMMTitle(a.g.wpm);
      break;
    }
    label310:
    this.wCV.setVisibility(8);
    AppMethodBeat.o(113499);
  }
  
  protected final void na(boolean paramBoolean)
  {
    AppMethodBeat.i(113505);
    if (paramBoolean)
    {
      this.lKp = w.a(this, getString(a.g.loading_tips), false, 0, null);
      AppMethodBeat.o(113505);
      return;
    }
    if ((this.lKp != null) && (this.lKp.isShowing()))
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(113505);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113497);
    super.onCreate(paramBundle);
    am.dkV().a(this);
    paramBundle = getIntent();
    Log.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      aZ(1, "");
      finish();
    }
    for (;;)
    {
      dmV();
      initView();
      AppMethodBeat.o(113497);
      return;
      this.lCR = paramBundle.getIntExtra("key_from_scene", 0);
      Log.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.lCR);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.wDd = paramBundle.getIntExtra("shop_id", 0);
      this.wDe = paramBundle.getStringExtra("sign_type");
      this.wDf = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.wDg = paramBundle.getStringExtra("nonce_str");
      this.wsy = paramBundle.getStringExtra("card_tp_id");
      this.wDh = paramBundle.getStringExtra("card_type");
      this.wDi = paramBundle.getIntExtra("can_multi_select", 0);
      this.wzl = paramBundle.getStringExtra("key_package_name");
      this.wzm = paramBundle.getStringExtra("key_transaction");
      Log.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.wDd + " sign_type:" + this.wDe + " time_stamp:" + this.time_stamp);
      Log.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.wDg + " card_tp_id:" + this.wsy + " card_type:" + this.wDh + " canMultiSelect:" + this.wDi + " packateName:" + this.wzl);
      if ("INVOICE".equalsIgnoreCase(this.wDh)) {
        this.wDk = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        Log.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        aZ(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113504);
    am.dkV().b(this);
    super.onDestroy();
    AppMethodBeat.o(113504);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113508);
    if (paramInt == 4)
    {
      setResult(0);
      aZ(0, "");
      finish();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113508);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(113500);
    if ((paramp instanceof aj))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(1059, this);
      na(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label395;
      }
      paramString = ((aj)paramp).wuy;
      Log.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = com.tencent.mm.plugin.card.model.a.akA(paramString);
      LinkedList localLinkedList2 = com.tencent.mm.plugin.card.model.a.akB(paramString);
      this.wDj = alb(paramString);
      if ((this.wuZ == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.wCZ.clear();
        this.mpS.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.wDa))
        {
          this.wDa = true;
          if (!this.wDk) {
            break label208;
          }
        }
        label208:
        for (((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).vCD = getString(a.g.wpV);; ((com.tencent.mm.plugin.card.model.a)localLinkedList1.get(0)).vCD = getString(a.g.wpU))
        {
          paramInt1 = this.mpS.size();
          this.mpS.addAll(localLinkedList1);
          while (paramInt1 < this.mpS.size())
          {
            this.wCZ.put(Integer.valueOf(paramInt1), Boolean.FALSE);
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.wDb))
        {
          this.wDb = true;
          ((com.tencent.mm.plugin.card.model.a)localLinkedList2.get(0)).vCD = getString(a.g.wou);
        }
        paramInt1 = this.mpS.size();
        this.mpS.addAll(localLinkedList2);
        while (paramInt1 < this.mpS.size())
        {
          this.wCZ.put(Integer.valueOf(paramInt1), Boolean.FALSE);
          paramInt1 += 1;
        }
      }
      this.nxG = ((aj)paramp).nxG;
      this.wuZ = ((aj)paramp).wuZ;
      this.wyr.notifyDataSetChanged();
      if (this.mpS.size() == 0) {
        break label404;
      }
      this.bEx.setVisibility(8);
      this.mListView.setVisibility(0);
    }
    for (;;)
    {
      this.wyc = false;
      AppMethodBeat.o(113500);
      return;
      label395:
      d.b(this, paramString, paramInt2);
      break;
      label404:
      this.bEx.setVisibility(0);
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
    
    private com.tencent.mm.plugin.card.model.a Ix(int paramInt)
    {
      AppMethodBeat.i(113489);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.mpS.get(paramInt);
      AppMethodBeat.o(113489);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113488);
      int i = CardListSelectedUI.this.mpS.size();
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
      Object localObject = Ix(paramInt);
      label194:
      label225:
      int i;
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, a.e.wnA, null);
        paramViewGroup = new CardListSelectedUI.d(CardListSelectedUI.this);
        paramViewGroup.wDt = ((ImageView)paramView.findViewById(a.d.logo));
        paramViewGroup.mll = ((TextView)paramView.findViewById(a.d.title));
        paramViewGroup.wDp = ((TextView)paramView.findViewById(a.d.sub_title));
        paramViewGroup.wDu = ((TextView)paramView.findViewById(a.d.weS));
        paramViewGroup.vCw = ((TextView)paramView.findViewById(a.d.catalogTV));
        paramViewGroup.wDv = paramView.findViewById(a.d.weY);
        paramViewGroup.wDw = ((ImageView)paramView.findViewById(a.d.whH));
        paramView.setTag(paramViewGroup);
        if (!l.Ii(((com.tencent.mm.plugin.card.model.a)localObject).tNW)) {
          break label400;
        }
        paramViewGroup.mll.setText(((com.tencent.mm.plugin.card.model.a)localObject).wsz);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).title)) {
          break label357;
        }
        paramViewGroup.wDp.setVisibility(0);
        paramViewGroup.wDp.setText(((com.tencent.mm.plugin.card.model.a)localObject).title);
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.model.a)localObject).wsA)) {
          break label369;
        }
        paramViewGroup.wDu.setVisibility(0);
        paramViewGroup.wDu.setText(((com.tencent.mm.plugin.card.model.a)localObject).wsA);
        TextView localTextView = paramViewGroup.vCw;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.card.model.a)localObject).vCD)) {
          break label381;
        }
        i = 8;
        label246:
        localTextView.setVisibility(i);
        paramViewGroup.vCw.setText(((com.tencent.mm.plugin.card.model.a)localObject).vCD);
        i = CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(a.b.weg);
        CardListSelectedUI.a(paramViewGroup.wDt, ((com.tencent.mm.plugin.card.model.a)localObject).nQG, i);
        localObject = (Boolean)CardListSelectedUI.this.wCZ.get(Integer.valueOf(paramInt));
        if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
          break label387;
        }
        paramViewGroup.wDw.setImageResource(a.c.wei);
      }
      for (;;)
      {
        AppMethodBeat.o(113490);
        return paramView;
        paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
        break;
        label357:
        paramViewGroup.wDp.setVisibility(8);
        break label194;
        label369:
        paramViewGroup.wDu.setVisibility(8);
        break label225;
        label381:
        i = 0;
        break label246;
        label387:
        paramViewGroup.wDw.setImageResource(a.c.wej);
        continue;
        label400:
        Log.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    private com.tencent.mm.plugin.card.model.a Ix(int paramInt)
    {
      AppMethodBeat.i(113493);
      com.tencent.mm.plugin.card.model.a locala = (com.tencent.mm.plugin.card.model.a)CardListSelectedUI.this.mpS.get(paramInt);
      AppMethodBeat.o(113493);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113492);
      int i = CardListSelectedUI.this.mpS.size();
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
      com.tencent.mm.plugin.card.model.a locala = Ix(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(CardListSelectedUI.this, a.e.wnz, null);
        paramViewGroup = new CardListSelectedUI.c(CardListSelectedUI.this);
        paramViewGroup.wDn = ((ImageView)paramView.findViewById(a.d.whH));
        paramViewGroup.wDo = ((TextView)paramView.findViewById(a.d.wko));
        paramViewGroup.mll = ((TextView)paramView.findViewById(a.d.title));
        paramViewGroup.wDp = ((TextView)paramView.findViewById(a.d.sub_title));
        paramViewGroup.wDq = paramView.findViewById(a.d.v_line);
        paramViewGroup.wDr = ((TextView)paramView.findViewById(a.d.fKX));
        paramViewGroup.wDs = ((TextView)paramView.findViewById(a.d.wkn));
        paramView.setTag(paramViewGroup);
        if (!l.Ii(locala.tNW)) {
          break label559;
        }
        if (TextUtils.isEmpty(locala.title)) {
          break label396;
        }
        paramViewGroup.mll.setVisibility(0);
        paramViewGroup.mll.setText(locala.title);
        label182:
        if (TextUtils.isEmpty(locala.wsz)) {
          break label408;
        }
        paramViewGroup.wDp.setVisibility(0);
        paramViewGroup.wDp.setText(locala.wsz);
        label213:
        if (locala.wsD != 0) {
          break label433;
        }
        paramView.setAlpha(1.0F);
        paramViewGroup.wDn.setVisibility(0);
        paramViewGroup.wDo.setVisibility(8);
        Boolean localBoolean = (Boolean)CardListSelectedUI.this.wCZ.get(Integer.valueOf(paramInt));
        if ((localBoolean == null) || (!localBoolean.booleanValue())) {
          break label420;
        }
        paramViewGroup.wDn.setImageResource(a.c.wei);
        label285:
        if (Util.isNullOrNil(locala.wsE)) {
          break label524;
        }
        paramViewGroup.wDr.setVisibility(0);
        paramViewGroup.wDr.setText(locala.wsE);
        label316:
        if (Util.isNullOrNil(locala.wsF)) {
          break label536;
        }
        paramViewGroup.wDs.setVisibility(0);
        paramViewGroup.wDs.setText(locala.wsF);
        label347:
        if ((!Util.isNullOrNil(locala.wsE)) || (!Util.isNullOrNil(locala.wsF))) {
          break label548;
        }
        paramViewGroup.wDq.setVisibility(8);
      }
      for (;;)
      {
        AppMethodBeat.o(113494);
        return paramView;
        paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
        break;
        label396:
        paramViewGroup.mll.setVisibility(8);
        break label182;
        label408:
        paramViewGroup.wDp.setVisibility(8);
        break label213;
        label420:
        paramViewGroup.wDn.setImageResource(a.c.wej);
        break label285;
        label433:
        if (locala.wsD == 1)
        {
          paramView.setAlpha(0.2F);
          paramViewGroup.wDn.setVisibility(8);
          if (!Util.isNullOrNil(locala.wsG))
          {
            paramViewGroup.wDo.setVisibility(0);
            paramViewGroup.wDo.setText(locala.wsG);
            break label285;
          }
          paramViewGroup.wDo.setVisibility(8);
          break label285;
        }
        paramViewGroup.wDn.setVisibility(8);
        paramViewGroup.wDo.setVisibility(8);
        break label285;
        label524:
        paramViewGroup.wDr.setVisibility(8);
        break label316;
        label536:
        paramViewGroup.wDs.setVisibility(8);
        break label347;
        label548:
        paramViewGroup.wDq.setVisibility(0);
        continue;
        label559:
        Log.i("MicroMsg.CardListSelectedUI", "not support type");
      }
    }
  }
  
  final class c
  {
    public TextView mll;
    public ImageView wDn;
    public TextView wDo;
    public TextView wDp;
    public View wDq;
    public TextView wDr;
    public TextView wDs;
    
    c() {}
  }
  
  final class d
  {
    public TextView mll;
    public TextView vCw;
    public TextView wDp;
    public ImageView wDt;
    public TextView wDu;
    public View wDv;
    public ImageView wDw;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */