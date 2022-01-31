package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.ah.m;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI
  extends MMActivity
  implements com.tencent.mm.ah.f, j.a
{
  private ListView Nn;
  private String app_id;
  LinkedList<a> dBw = new LinkedList();
  private com.tencent.mm.ui.base.p dpF = null;
  private int drX = 0;
  private View hrf;
  private String iln;
  com.tencent.mm.bv.b inP = null;
  boolean inQ = true;
  private BaseAdapter iqN;
  private boolean iqy = false;
  private String irI = "";
  private String irJ;
  private boolean ivA;
  private boolean ivB;
  private int ivC;
  private String ivD;
  private String ivE;
  private String ivF;
  private String ivG;
  private int ivH;
  public String ivI;
  private boolean ivJ = false;
  private a ivK;
  private TextView ivt;
  private RelativeLayout ivu;
  private TextView ivv;
  private TextView ivw;
  boolean ivx = false;
  HashMap<Integer, Boolean> ivy = new HashMap();
  private boolean ivz;
  private int time_stamp;
  
  private void W(int paramInt, String paramString)
  {
    if (this.drX != 8)
    {
      y.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.drX);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("_wxapi_choose_card_from_wx_card_list", paramString);
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.by(this.app_id, true);
    ChooseCardFromWXCardPackage.Resp localResp = new ChooseCardFromWXCardPackage.Resp(localBundle);
    if (localObject != null) {
      localResp.openId = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_openId;
    }
    localResp.transaction = this.irJ;
    String str2 = this.app_id;
    String str1;
    if (localObject == null)
    {
      str1 = "null appinfo";
      if (localObject != null) {
        break label261;
      }
      localObject = "null appinfo";
      label119:
      y.i("MicroMsg.CardListSelectedUI", "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s", new Object[] { str2, str1, localObject, this.irJ });
      localResp.toBundle(localBundle);
      y.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:" + paramInt);
      y.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:" + paramString);
      if (paramInt != -1) {
        break label271;
      }
    }
    label261:
    label271:
    for (localResp.errCode = 0;; localResp.errCode = -2)
    {
      paramString = new MMessageActV2.Args();
      paramString.targetPkgName = this.irI;
      paramString.bundle = localBundle;
      com.tencent.mm.pluginsdk.model.app.p.ak(localBundle);
      com.tencent.mm.pluginsdk.model.app.p.al(localBundle);
      MMessageActV2.send(ae.getContext(), paramString);
      return;
      str1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_appName;
      break;
      localObject = ((com.tencent.mm.pluginsdk.model.app.f)localObject).field_openId;
      break label119;
    }
  }
  
  private void aBB()
  {
    Intent localIntent = new Intent();
    String str = aCa();
    if (this.ivJ) {
      localIntent.putExtra("choose_invoice_info", str);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      W(-1, str);
      finish();
      return;
      localIntent.putExtra("choose_card_info", str);
    }
  }
  
  private void aBZ()
  {
    if (this.iqy) {
      y.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
    }
    do
    {
      return;
      if (this.inP == null)
      {
        this.ivz = false;
        this.ivA = false;
        this.ivB = false;
      }
      com.tencent.mm.kernel.g.DO().dJT.a(664, this);
      aj localaj = new aj(this.app_id, this.ivC, this.ivD, this.ivE, this.time_stamp, this.ivF, this.iln, this.ivG, this.inP);
      com.tencent.mm.kernel.g.DO().dJT.a(localaj, 0);
      ew(true);
      this.iqy = true;
    } while (this.ivH != 1);
    this.ivx = true;
  }
  
  private String aCa()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.dBw.size())
    {
      localObject = (Boolean)this.ivy.get(Integer.valueOf(i));
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localArrayList.add(this.dBw.get(i));
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    i = j;
    while (i < localArrayList.size())
    {
      if (i != 0) {
        ((StringBuilder)localObject).append(",");
      }
      a locala = (a)localArrayList.get(i);
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append("\"card_id\":");
      ((StringBuilder)localObject).append("\"" + locala.iln + "\"");
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append("\"encrypt_code\":");
      ((StringBuilder)localObject).append("\"" + locala.ils + "\"");
      if (this.ivJ)
      {
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("\"app_id\":");
        ((StringBuilder)localObject).append("\"" + locala.app_id + "\"");
      }
      ((StringBuilder)localObject).append("}");
      i += 1;
    }
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
  
  private static String yG(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("rule_url");
      return paramString;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.CardListSelectedUI", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public final void b(String paramString, j.b paramb)
  {
    ew(false);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.ivK.ilt)))
    {
      y.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
      return;
    }
    y.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
    y.i("MicroMsg.CardListSelectedUI", "markSucc:" + paramb.ilb + " markCardId: " + paramb.ilc);
    if (paramb.ilb == 1)
    {
      int i;
      if ((!TextUtils.isEmpty(paramb.ilc)) && (!paramString.equals(paramb.ilc)))
      {
        y.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
        i = 0;
        if (i < this.dBw.size())
        {
          if (((a)this.dBw.get(i)).ilt != paramb.ilc) {
            break label214;
          }
          int j = 0;
          while (j < this.dBw.size())
          {
            this.ivy.put(Integer.valueOf(j), Boolean.valueOf(false));
            j += 1;
          }
          this.ivy.put(Integer.valueOf(i), Boolean.valueOf(true));
        }
      }
      for (;;)
      {
        aBB();
        return;
        label214:
        i += 1;
        break;
        y.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
      }
    }
    d.b(this, getString(a.g.card_mark_used));
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    ew(false);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.ivK.ilt)))
    {
      y.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
      return;
    }
    y.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(a.g.card_mark_failed_tips);
    }
    d.b(this, paramString1);
  }
  
  protected final void ew(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(a.g.loading_tips), false, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  protected final int getLayoutId()
  {
    return a.e.card_list_select_card_ui;
  }
  
  protected final void initView()
  {
    if (this.ivJ)
    {
      setMMTitle(a.g.card_list_select_card_ui_title_invoice);
      setBackBtn(new CardListSelectedUI.1(this));
      if (!this.ivJ)
      {
        addTextOptionMenu(0, getString(a.g.app_finish), new CardListSelectedUI.2(this));
        enableOptionMenu(false);
      }
      this.Nn = ((ListView)findViewById(a.d.card_list));
      if (!this.ivJ) {
        break label276;
      }
    }
    label276:
    for (this.iqN = new CardListSelectedUI.b(this);; this.iqN = new CardListSelectedUI.a(this))
    {
      this.Nn.setAdapter(this.iqN);
      this.Nn.setOnItemClickListener(new CardListSelectedUI.3(this));
      this.Nn.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if ((paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (!CardListSelectedUI.this.inQ))
          {
            y.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
            CardListSelectedUI.e(CardListSelectedUI.this);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.hrf = findViewById(a.d.content_no_data);
      this.ivt = ((TextView)findViewById(a.d.no_card_tip_text));
      if (this.ivJ) {
        this.ivt.setText(getString(a.g.card_select_list_no_invoice_tips));
      }
      this.ivu = ((RelativeLayout)findViewById(a.d.invoice_bottom));
      this.ivv = ((TextView)findViewById(a.d.invoice_url));
      this.ivw = ((TextView)findViewById(a.d.invoice_sure_btn));
      if (!this.ivJ) {
        break label291;
      }
      this.ivu.setVisibility(0);
      this.ivv.setOnClickListener(new CardListSelectedUI.5(this));
      this.ivw.setOnClickListener(new CardListSelectedUI.6(this));
      return;
      setMMTitle(a.g.card_list_select_card_ui_title);
      break;
    }
    label291:
    this.ivu.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    am.aAE().a(this);
    paramBundle = getIntent();
    y.i("MicroMsg.CardListSelectedUI", "initData()");
    if (paramBundle == null)
    {
      y.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
      setResult(1);
      W(1, "");
      finish();
    }
    for (;;)
    {
      aBZ();
      initView();
      return;
      this.drX = paramBundle.getIntExtra("key_from_scene", 0);
      y.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.drX);
      this.app_id = paramBundle.getStringExtra("app_id");
      this.ivC = paramBundle.getIntExtra("shop_id", 0);
      this.ivD = paramBundle.getStringExtra("sign_type");
      this.ivE = paramBundle.getStringExtra("card_sign");
      this.time_stamp = paramBundle.getIntExtra("time_stamp", 0);
      this.ivF = paramBundle.getStringExtra("nonce_str");
      this.iln = paramBundle.getStringExtra("card_tp_id");
      this.ivG = paramBundle.getStringExtra("card_type");
      this.ivH = paramBundle.getIntExtra("can_multi_select", 0);
      this.irI = paramBundle.getStringExtra("key_package_name");
      this.irJ = paramBundle.getStringExtra("key_transaction");
      y.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.ivC + " sign_type:" + this.ivD + " time_stamp:" + this.time_stamp);
      y.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.ivF + " card_tp_id:" + this.iln + " card_type:" + this.ivG + " canMultiSelect:" + this.ivH + " packateName:" + this.irI);
      if ("INVOICE".equalsIgnoreCase(this.ivG)) {
        this.ivJ = true;
      }
      if (TextUtils.isEmpty(this.app_id))
      {
        y.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
        setResult(1);
        W(1, "app_id  or card_sign is empty!");
        finish();
      }
    }
  }
  
  protected void onDestroy()
  {
    am.aAE().b(this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0);
      W(0, "");
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof aj))
    {
      com.tencent.mm.kernel.g.DO().dJT.b(664, this);
      ew(false);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label385;
      }
      paramString = ((aj)paramm).inn;
      y.d("MicroMsg.CardListSelectedUI", paramString);
      LinkedList localLinkedList1 = a.yg(paramString);
      LinkedList localLinkedList2 = a.yh(paramString);
      this.ivI = yG(paramString);
      if ((this.inP == null) && ((localLinkedList1 != null) || (localLinkedList2 != null)))
      {
        this.ivy.clear();
        this.dBw.clear();
      }
      if (localLinkedList1 != null)
      {
        if ((localLinkedList1.size() > 0) && (!this.ivz))
        {
          this.ivz = true;
          if (!this.ivJ) {
            break label203;
          }
        }
        label203:
        for (((a)localLinkedList1.get(0)).ics = getString(a.g.card_share_card_list_my_invoice_title);; ((a)localLinkedList1.get(0)).ics = getString(a.g.card_share_card_list_my_card_title))
        {
          paramInt1 = this.dBw.size();
          this.dBw.addAll(localLinkedList1);
          while (paramInt1 < this.dBw.size())
          {
            this.ivy.put(Integer.valueOf(paramInt1), Boolean.valueOf(false));
            paramInt1 += 1;
          }
        }
      }
      if (localLinkedList2 != null)
      {
        if ((localLinkedList2.size() > 0) && (!this.ivA))
        {
          this.ivA = true;
          ((a)localLinkedList2.get(0)).ics = getString(a.g.card_coupon);
        }
        paramInt1 = this.dBw.size();
        this.dBw.addAll(localLinkedList2);
        while (paramInt1 < this.dBw.size())
        {
          this.ivy.put(Integer.valueOf(paramInt1), Boolean.valueOf(false));
          paramInt1 += 1;
        }
      }
      this.inQ = ((aj)paramm).inQ;
      this.inP = ((aj)paramm).inP;
      this.iqN.notifyDataSetChanged();
      if (this.dBw.size() == 0) {
        break label394;
      }
      this.hrf.setVisibility(8);
      this.Nn.setVisibility(0);
    }
    for (;;)
    {
      this.iqy = false;
      return;
      label385:
      d.b(this, paramString, paramInt2);
      break;
      label394:
      this.hrf.setVisibility(0);
      this.Nn.setVisibility(8);
    }
  }
  
  public final void yd(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI
 * JD-Core Version:    0.7.0.1
 */