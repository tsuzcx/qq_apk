package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.collect.b.d;
import com.tencent.mm.plugin.collect.b.d.a;
import com.tencent.mm.plugin.collect.b.f.a;
import com.tencent.mm.plugin.collect.b.l;
import com.tencent.mm.plugin.collect.b.t;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.d;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(0)
public class CollectMainUI
  extends WalletPreferenceUI
  implements d.a, ay.a
{
  private static int iLL = -1;
  private static int iLM = -1;
  private static int iLN = -1;
  private static int iLO = -1;
  private static int iLs;
  private int ccS;
  private com.tencent.mm.ui.base.preference.f hcp = null;
  private Vibrator hpm;
  protected ScrollView iIZ = null;
  private long iKA;
  private ImageView iKO = null;
  private TextView iKP = null;
  private WalletTextView iKQ = null;
  private TextView iKR = null;
  private TextView iKS = null;
  private TextView iKT = null;
  private View iKU = null;
  private TextView iKV = null;
  private Dialog iKW = null;
  private View iKX = null;
  private View iKY = null;
  private boolean iKZ = false;
  private String iLA;
  private String iLB;
  protected CdnImageView iLC;
  protected TextView iLD;
  protected TextView iLE;
  protected ImageView iLF;
  protected ViewGroup iLG;
  protected View iLH;
  private int iLI = 0;
  private aws iLJ;
  private x.a iLK = new CollectMainUI.12(this);
  private View iLa = null;
  private ImageView iLb;
  private TextView iLc;
  private TextView iLd;
  private TextView iLe;
  protected TextView iLf;
  private RelativeLayout iLg;
  private Bitmap iLh = null;
  protected String iLi = null;
  protected String iLj = null;
  protected String iLk = null;
  private String iLl = null;
  private List<CollectMainUI.a> iLm = new LinkedList();
  private double iLn;
  private String iLo = null;
  private String iLp = null;
  protected boolean iLq = false;
  private long iLr;
  private View iLt;
  private CollectMainUI.b iLu = new CollectMainUI.b(this, (byte)0);
  private SpannableStringBuilder iLv;
  private SpannableStringBuilder iLw;
  private com.tencent.mm.plugin.collect.b.f iLx;
  private int iLy = 0;
  private String iLz;
  
  private static awl O(JSONObject paramJSONObject)
  {
    awl localawl = new awl();
    localawl.type = paramJSONObject.optInt("type", -1);
    localawl.url = paramJSONObject.optString("url", "");
    localawl.bQZ = paramJSONObject.optString("wording", "");
    localawl.ttb = paramJSONObject.optString("waapp_username", "");
    localawl.ttc = paramJSONObject.optString("waapp_path", "");
    return localawl;
  }
  
  private void aFe()
  {
    getWindow().getDecorView().post(new CollectMainUI.3(this));
  }
  
  private void aFf()
  {
    double d;
    if ((this.iLm != null) && (this.iLm.size() > 0))
    {
      this.iKX.setBackgroundResource(a.e.collect_header_top_corner);
      this.hcp.removeAll();
      int i = 0;
      d = 0.0D;
      if (i < this.iLm.size())
      {
        CollectMainUI.a locala = (CollectMainUI.a)this.iLm.get(i);
        c localc;
        if (i == this.iLm.size() - 1)
        {
          localc = new c(this, a.g.collect_pay_info_bottom_corner_preference);
          label98:
          localc.setKey(String.valueOf(i));
          String str2 = locala.dtK;
          String str1 = str2;
          if (bk.bl(str2))
          {
            str1 = str2;
            if (!bk.bl(locala.username)) {
              str1 = com.tencent.mm.wallet_core.ui.e.gV(locala.username);
            }
          }
          localc.mTitle = str1;
          localc.djD = locala.username;
          if (locala.status != 0) {
            break label215;
          }
          localc.setSummary(a.i.collect_main_paying);
        }
        for (;;)
        {
          this.hcp.a(localc);
          i += 1;
          break;
          localc = new c(this);
          break label98;
          label215:
          if (locala.status == 1)
          {
            if (locala.itz)
            {
              d += locala.iHP;
              localc.setSummary(com.tencent.mm.wallet_core.ui.e.d(locala.iHP, locala.bHY));
            }
            for (;;)
            {
              this.hcp.a(localc);
              break;
              localc.setSummary(a.i.collect_main_pay_suc);
            }
          }
          if (locala.status == 2) {
            localc.setSummary(a.i.collect_main_pay_cancel);
          }
        }
      }
      this.hcp.notifyDataSetChanged();
      this.iKS.setText(com.tencent.mm.wallet_core.ui.e.d(d, ((CollectMainUI.a)this.iLm.get(0)).bHY));
      this.iKS.setVisibility(0);
    }
    for (;;)
    {
      if ((this.iLm != null) && (this.iLm.size() > 0))
      {
        this.iLG.setBackgroundResource(a.e.collect_main_assist_bg);
        this.iKU.setVisibility(0);
        if ((d > 0.0D) && (this.iLm.size() > 0))
        {
          this.iLH.setVisibility(0);
          this.iKY.setVisibility(0);
        }
        return;
      }
      this.iKS.setVisibility(8);
      this.iKU.setVisibility(8);
      this.iKY.setVisibility(8);
      return;
      d = 0.0D;
    }
  }
  
  private static awl aFg()
  {
    try
    {
      g.DQ();
      awl localawl = O(new JSONObject((String)g.DP().Dz().get(ac.a.uxD, "")));
      return localawl;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
    }
    return null;
  }
  
  private static List<awl> aFh()
  {
    localArrayList = new ArrayList();
    try
    {
      g.DQ();
      Object localObject = (String)g.DP().Dz().get(ac.a.uxF, "");
      if (!bk.bl((String)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(O(((JSONArray)localObject).getJSONObject(i)));
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.CollectMainUI", localJSONException, "", new Object[0]);
    }
  }
  
  private void eM(boolean paramBoolean)
  {
    Object localObject;
    if ((this.iLh != null) && (!this.iLh.isRecycled()))
    {
      i = BackwardSupportUtil.b.b(this, 197.0F);
      localObject = com.tencent.mm.plugin.collect.b.b.a(this, this.iLi, q.Gj(), this.iLy, this.iLB, i, this.iLK, false);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        if (this.iLq)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11343, new Object[] { Integer.valueOf(1), Integer.valueOf((int)Math.round(this.iLn * 100.0D)) });
          if (this.iKZ) {
            break label621;
          }
          this.iIZ = ((ScrollView)((ViewStub)findViewById(a.f.collect_main_save_view_stub)).inflate());
          aFb();
          this.iKZ = true;
        }
      }
    }
    label393:
    label425:
    label452:
    label470:
    label621:
    for (int i = 250;; i = 0)
    {
      this.iIZ.setVisibility(4);
      ((ImageView)this.iIZ.findViewById(a.f.collect_main_save_ftf_pay_qrcode)).setImageBitmap(this.iLh);
      TextView localTextView1 = (TextView)this.iIZ.findViewById(a.f.collect_main_save_receiver_1);
      TextView localTextView2 = (TextView)this.iIZ.findViewById(a.f.collect_main_save_receiver_2);
      LinearLayout localLinearLayout1 = (LinearLayout)this.iIZ.findViewById(a.f.collect_save_root_layout);
      LinearLayout localLinearLayout2 = (LinearLayout)this.iIZ.findViewById(a.f.collect_main_save_fixed_ll);
      TextView localTextView3 = (TextView)this.iIZ.findViewById(a.f.collect_main_save_fixed_currency);
      TextView localTextView4 = (TextView)this.iIZ.findViewById(a.f.collect_main_save_fixed_desc);
      TextView localTextView5 = (TextView)this.iIZ.findViewById(a.f.collect_main_save_fixed_fee);
      String str1 = com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(q.Gj()), 10);
      String str2 = aEZ();
      localObject = str1;
      if (!bk.bl(str2)) {
        localObject = str1 + getString(a.i.collect_main_save_bottom_tips2, new Object[] { str2 });
      }
      if (this.iLy == 1) {
        if (!bk.bl(this.iLA))
        {
          localTextView1.setText(this.iLA);
          localTextView2.setText(j.a(this, (CharSequence)localObject, localTextView2.getTextSize()));
          localTextView2.setVisibility(0);
          if (!this.iLq) {
            break label574;
          }
          if (bk.bl(this.iLp)) {
            break label564;
          }
          localTextView4.setText(this.iLp);
          localTextView4.setVisibility(0);
          localTextView3.setText(aFa());
          localTextView5.setText(com.tencent.mm.wallet_core.ui.e.A(this.iLn));
          localLinearLayout2.setVisibility(0);
          ai.l(new CollectMainUI.5(this, localLinearLayout1, paramBoolean), i);
          i = 1;
          if (i == 0) {
            Toast.makeText(this.mController.uMN, getString(a.i.collect_qrcode_save_failed), 1).show();
          }
        }
      }
      for (;;)
      {
        this.vdd.notifyDataSetChanged();
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.f(11343, new Object[] { Integer.valueOf(0) });
        break;
        localTextView1.setText(j.a(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label393;
        localTextView1.setText(j.a(this, (CharSequence)localObject, localTextView1.getTextSize()));
        break label393;
        localTextView4.setVisibility(8);
        break label425;
        localLinearLayout2.setVisibility(8);
        break label452;
        i = 0;
        break label470;
        y.w("MicroMsg.CollectMainUI", "save ftf pay qrcode failed: bmp null");
        Toast.makeText(this.mController.uMN, getString(a.i.collect_qrcode_save_failed), 1).show();
      }
    }
  }
  
  private Bitmap zz(String paramString)
  {
    return com.tencent.mm.plugin.collect.b.b.a(this, paramString, q.Gj(), this.iLy, this.iLB, this.iLK, false);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  protected void aEY()
  {
    if (com.tencent.mm.plugin.collect.b.f.iGP == null) {
      com.tencent.mm.plugin.collect.b.f.iGP = new com.tencent.mm.plugin.collect.b.f();
    }
    this.iLx = com.tencent.mm.plugin.collect.b.f.iGP;
    Object localObject = this.iLx;
    g.DQ();
    g.DO().dJT.a(1588, (com.tencent.mm.ah.f)localObject);
    com.tencent.mm.plugin.collect.b.f localf = this.iLx;
    CollectMainUI.10 local10 = new CollectMainUI.10(this);
    g.DQ();
    String str1 = (String)g.DP().Dz().get(ac.a.uxB, "");
    g.DQ();
    String str2 = (String)g.DP().Dz().get(ac.a.uxC, "");
    localObject = str1;
    if (bk.bl(str1))
    {
      y.i("MicroMsg.F2fGetPayUrlManager", "use old payurl");
      localObject = o.bVs().bVQ();
    }
    local10.cD((String)localObject, str2);
    localObject = new l();
    localf.hLB.put(localObject, local10);
    g.DQ();
    g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
  }
  
  protected String aEZ()
  {
    if (bk.bl(this.iLj))
    {
      this.iLj = o.bVs().aEZ();
      this.iLj = com.tencent.mm.wallet_core.ui.e.afj(this.iLj);
    }
    return this.iLj;
  }
  
  protected String aFa()
  {
    return com.tencent.mm.wallet_core.ui.e.afg(this.iLo);
  }
  
  protected void aFb() {}
  
  protected void aFc()
  {
    this.iKO.setImageBitmap(null);
    if (this.iLq)
    {
      if (bk.bl(this.iLl))
      {
        y.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mFixedPayUrl null");
        return;
      }
      this.iLh = zz(this.iLl);
      if ((this.iLh == null) || (this.iLh.isRecycled())) {
        break label206;
      }
      this.iKO.setImageBitmap(this.iLh);
      label74:
      if (!this.iLq) {
        break label249;
      }
      this.iKQ.setPrefix(aFa());
      this.iKQ.setText(com.tencent.mm.wallet_core.ui.e.A(this.iLn));
      this.iKQ.setVisibility(0);
      if (bk.bl(this.iLp)) {
        break label237;
      }
      this.iKP.setText(j.a(this.mController.uMN, this.iLp, this.iKP.getTextSize()));
      this.iKP.setVisibility(0);
    }
    for (;;)
    {
      findViewById(a.f.collect_main_fixed_layout).setVisibility(0);
      return;
      if (bk.bl(this.iLi))
      {
        y.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : mPayUrl null");
        return;
      }
      this.iLh = zz(this.iLi);
      break;
      label206:
      y.w("MicroMsg.CollectMainUI", "func[refreshQRCodeArea] : bmp null ,mFixedPayUrl=" + bk.pm(this.iLl));
      break label74;
      label237:
      this.iKP.setVisibility(8);
    }
    label249:
    this.iKR.setVisibility(8);
    this.iKQ.setVisibility(8);
    this.iKP.setVisibility(8);
    findViewById(a.f.collect_main_fixed_layout).setVisibility(8);
  }
  
  protected final void aFd()
  {
    ta(getResources().getColor(a.c.CollectMainBgColor));
  }
  
  protected final void aY(List<awl> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        awl localawl = (awl)localIterator.next();
        if (localawl.type == 1) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(1), localawl.bQZ, "", "", "", Integer.valueOf(1) });
        } else if (localawl.type == 2) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(2), localawl.bQZ, "", "", localawl.url, Integer.valueOf(1) });
        } else if (localawl.type == 3) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14526, new Object[] { Integer.valueOf(2), Integer.valueOf(3), localawl.bQZ, localawl.ttb, localawl.ttc, "", Integer.valueOf(1) });
        }
      }
    }
    this.iLg.setOnClickListener(new CollectMainUI.13(this, paramList));
  }
  
  protected final void aqU()
  {
    if (bk.bl(this.iLi)) {
      y.w("MicroMsg.CollectMainUI", "func[refreshView], mPayUrl null.");
    }
    for (;;)
    {
      return;
      if (this.iLy == 1)
      {
        if (!bk.bl(this.iLz)) {
          this.iKV.setText(this.iLz);
        }
        if (!bk.bl(this.iLA))
        {
          localObject = (TextView)findViewById(a.f.collect_main_hk_tips);
          ((TextView)localObject).setText(this.iLA);
          ((TextView)localObject).setVisibility(0);
        }
      }
      aFc();
      aFf();
      Object localObject = i.bVj();
      if (this.iLq) {}
      for (int i = 33; localObject != null; i = 32)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13447, new Object[] { Integer.valueOf(i), ((aw)localObject).sun, ((aw)localObject).suo, this.iLi, Double.valueOf(this.iLn), Long.valueOf(bk.UX()), Long.valueOf(((aw)localObject).sum), ((aw)localObject).sup, ((aw)localObject).suq });
        return;
      }
    }
  }
  
  public final void aqt()
  {
    y.i("MicroMsg.CollectMainUI", "do screen shot");
    com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(9) });
    if (this.iLI == 1)
    {
      e.a locala1 = new e.a(this.mController.uMN);
      e.a locala2 = locala1.aeG(getString(a.i.collect_material_guide_screen_shot_text));
      locala2.scn.wmT.wlJ = true;
      locala2.wnx = true;
      locala2.wnw = getString(a.i.collect_material_guide_apply_text);
      locala2.wnv = getString(a.i.collect_material_guide_save_text);
      locala2.Iv(getResources().getColor(a.c.normal_text_color)).nY(true).a(new CollectMainUI.6(this), new e.d()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          CollectMainUI.e(CollectMainUI.this);
        }
      });
      locala1.show();
      return;
    }
    com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.collect_main_screen_shot_tips), "", getString(a.i.collect_main_screen_shot_save_btn_text), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new CollectMainUI.9
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        CollectMainUI.e(CollectMainUI.this);
        com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(10) });
      }
    }, new CollectMainUI.9(this));
  }
  
  public final int axE()
  {
    return a.g.collect_main_header;
  }
  
  public final void b(t paramt)
  {
    int k = 0;
    y.d("MicroMsg.CollectMainUI", "func[onRecv]:Recv payerMsg");
    if (((this.ccS != 1) && (this.ccS != 0)) || ((paramt.msgType == 9) || ((this.ccS == 8) && (paramt.msgType == 26))))
    {
      if (this.hpm != null) {
        this.hpm.vibrate(50L);
      }
      if (paramt.timestamp < this.iLr) {
        y.d("MicroMsg.CollectMainUI", "Recieve but time out ");
      }
    }
    else
    {
      return;
    }
    int i = 0;
    if (i < this.iLm.size()) {
      if ((paramt.status == 0) && (bk.pm(paramt.username).equals(((CollectMainUI.a)this.iLm.get(i)).username)) && (((CollectMainUI.a)this.iLm.get(i)).status == 2))
      {
        this.iLm.remove(i);
        this.iLm.add(i, new CollectMainUI.a(this, paramt));
        i = 1;
      }
    }
    for (;;)
    {
      label195:
      if (i == 0) {
        i = 0;
      }
      for (;;)
      {
        int j = k;
        Object localObject;
        if (i < this.iLm.size())
        {
          localObject = (t)this.iLm.get(i);
          if (paramt.timestamp > ((t)localObject).timestamp)
          {
            this.iLm.add(i, new CollectMainUI.a(this, paramt));
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            this.iLm.add(new CollectMainUI.a(this, paramt));
          }
          ai.d(new CollectMainUI.4(this));
          return;
          if (paramt.bMY.equals(((CollectMainUI.a)this.iLm.get(i)).bMY))
          {
            y.v("MicroMsg.CollectMainUI", "func[onRecv] Duplicated msg, transId=" + paramt.bMY);
            if (((CollectMainUI.a)this.iLm.get(i)).status == 0)
            {
              ((CollectMainUI.a)this.iLm.get(i)).status = paramt.status;
              ((CollectMainUI.a)this.iLm.get(i)).iHP = paramt.iHP;
              ((CollectMainUI.a)this.iLm.get(i)).bHY = paramt.bHY;
              if (paramt.status == 1)
              {
                localObject = this.iLu;
                CollectMainUI.a locala = (CollectMainUI.a)this.iLm.get(i);
                ((CollectMainUI.b)localObject).iMa.add(locala);
              }
            }
            i = 1;
            break label195;
          }
          i += 1;
          break;
        }
        i += 1;
      }
      i = 0;
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.slide_left_in, com.tencent.mm.plugin.wxpay.a.a.slide_right_out);
  }
  
  public boolean g(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.collect_main;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.offline_collect_btn_text);
    setBackBtn(new CollectMainUI.14(this));
    this.hcp = this.vdd;
    this.iKU = findViewById(a.f.collect_main_receive_area);
    this.iLH = findViewById(a.f.collect_main_receive_area_1);
    this.iKQ = ((WalletTextView)findViewById(a.f.collect_main_fixed_fee));
    this.iKP = ((TextView)findViewById(a.f.collect_main_fixed_desc));
    this.iKR = ((TextView)findViewById(a.f.collect_main_fixed_fee_currency));
    this.iKS = ((TextView)findViewById(a.f.collect_main_receice_amount));
    this.iLf = ((TextView)findViewById(a.f.banner_tips));
    this.iKX = ((RelativeLayout)findViewById(a.f.collect_main_qrcode_area));
    this.iKY = findViewById(a.f.collect_main_header_divider);
    this.iLt = LayoutInflater.from(this).inflate(a.g.collect_main_footer, null, false);
    this.iKT = ((TextView)findViewById(a.f.collect_main_save_qrcode));
    Object localObject = new SpannableStringBuilder(getString(a.i.collect_main_save_qrcode));
    ((SpannableStringBuilder)localObject).setSpan(new com.tencent.mm.plugin.wallet_core.ui.m(new CollectMainUI.15(this)), 0, ((SpannableStringBuilder)localObject).length(), 18);
    this.iKT.setText((CharSequence)localObject);
    this.iKT.setClickable(true);
    this.iKT.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.lwE.addFooterView(this.iLt, null, false);
    this.lwE.setFooterDividersEnabled(false);
    this.iKO = ((ImageView)findViewById(a.f.collect_main_ftf_pay_qrcode));
    this.iKV = ((TextView)findViewById(a.f.collect_main_tips));
    this.iLe = ((TextView)findViewById(a.f.collect_set_money_tv));
    this.iLe.setClickable(true);
    this.iLe.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.iLv = new SpannableStringBuilder(getString(a.i.collect_main_fixed));
    this.iLw = new SpannableStringBuilder(getString(a.i.collect_main_fixed_cancel));
    localObject = new com.tencent.mm.plugin.wallet_core.ui.m(new CollectMainUI.16(this));
    com.tencent.mm.plugin.wallet_core.ui.m localm = new com.tencent.mm.plugin.wallet_core.ui.m(new CollectMainUI.17(this));
    this.iLv.setSpan(localObject, 0, this.iLv.length(), 18);
    if (com.tencent.mm.ui.a.a.a.cAj().cAi()) {
      this.iLe.setOnClickListener(new CollectMainUI.18(this, (com.tencent.mm.plugin.wallet_core.ui.m)localObject, localm));
    }
    this.iLw.setSpan(localm, 0, this.iLw.length(), 18);
    this.iLe.setText(this.iLv);
    this.iLg = ((RelativeLayout)findViewById(a.f.collect_menu_more_btn_layout));
    this.iKO.setOnLongClickListener(new CollectMainUI.19(this));
    this.iLa = findViewById(a.f.collect_main_receive_toast);
    this.iLb = ((ImageView)findViewById(a.f.collect_receive_toast_avatar));
    this.iLc = ((TextView)findViewById(a.f.collect_receive_toast_name));
    this.iLd = ((TextView)findViewById(a.f.collect_receive_toast_fee));
    this.iLC = ((CdnImageView)findViewById(a.f.collect_assist_icon));
    this.iLD = ((TextView)findViewById(a.f.collect_assist_title));
    this.iLE = ((TextView)findViewById(a.f.collect_assist_wording));
    this.iLF = ((ImageView)findViewById(a.f.collect_assist_red_dot));
    this.iLG = ((ViewGroup)findViewById(a.f.collect_assist_layout));
    this.iKX.postDelayed(new CollectMainUI.20(this), 300L);
    localObject = new ti();
    ((ti)localObject).ccU.bso = "8";
    ((ti)localObject).bFJ = new CollectMainUI.2(this, (ti)localObject);
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    case 4096: 
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.iLl = paramIntent.getStringExtra("ftf_pay_url");
        this.iLn = paramIntent.getDoubleExtra("ftf_fixed_fee", 0.0D);
        this.iLo = paramIntent.getStringExtra("ftf_fixed_fee_type");
        this.iLp = paramIntent.getStringExtra("ftf_fixed_desc");
        this.iLk = paramIntent.getStringExtra("key_currency_unit");
        this.iLe.setText(this.iLw);
      }
      for (this.iLq = true;; this.iLq = false)
      {
        aqU();
        aFe();
        return;
      }
    }
    this.iKA = q.Go();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    if (paramBundle.screenBrightness < 0.85F)
    {
      paramBundle.screenBrightness = 0.85F;
      getWindow().setAttributes(paramBundle);
    }
    mS(true);
    czo();
    g.DQ();
    this.ccS = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
    this.iKA = q.Go();
    int i = getIntent().getIntExtra("key_from_scene", 1);
    com.tencent.mm.plugin.report.service.h.nFQ.f(14021, new Object[] { Integer.valueOf(2), Integer.valueOf(i) });
    g.DQ();
    boolean bool = ((String)g.DP().Dz().get(327731, "0")).equals("0");
    overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.slide_right_in, com.tencent.mm.plugin.wxpay.a.a.slide_left_out);
    if (bool)
    {
      paramBundle = this.mController.uMN;
      if (!q.Gw()) {
        break label420;
      }
    }
    label420:
    for (i = a.i.collect_main_first_enter_tips_payu;; i = a.i.collect_main_first_enter_tips)
    {
      com.tencent.mm.ui.base.h.a(paramBundle, i, a.i.collect_main_first_enter_tips_title, new CollectMainUI.1(this));
      g.DQ();
      g.DP().Dz().o(327731, "1");
      g.DQ();
      g.DP().Dz().mC(true);
      com.tencent.mm.plugin.collect.a.a.aEp();
      paramBundle = com.tencent.mm.plugin.collect.a.a.aEq();
      if (!paramBundle.fKm.contains(this)) {
        paramBundle.fKm.add(this);
      }
      initView();
      aEY();
      aqU();
      this.hpm = ((Vibrator)getSystemService("vibrator"));
      this.iLr = bk.UX();
      if (iLL < 0)
      {
        paramBundle = new DisplayMetrics();
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
        iLL = paramBundle.widthPixels / 2 - BackwardSupportUtil.b.b(this.mController.uMN, 20.0F);
        iLM = BackwardSupportUtil.b.b(this.mController.uMN, 60.0F);
        iLN = BackwardSupportUtil.b.b(this.mController.uMN, 40.0F);
        iLO = BackwardSupportUtil.b.b(this.mController.uMN, 70.0F);
      }
      aFe();
      w.fT(16, 0);
      return;
    }
  }
  
  protected void onDestroy()
  {
    if (this.iKO != null) {
      this.iKO.setImageBitmap(null);
    }
    Object localObject = this.iLh;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      y.i("MicroMsg.CollectMainUI", "bitmap recycle %s", new Object[] { localObject });
      ((Bitmap)localObject).recycle();
    }
    if (this.iKW != null) {
      this.iKW.dismiss();
    }
    com.tencent.mm.plugin.collect.a.a.aEp();
    com.tencent.mm.plugin.collect.a.a.aEq().fKm.remove(this);
    this.hpm.cancel();
    if (this.iLx != null)
    {
      localObject = this.iLx;
      Iterator localIterator = ((com.tencent.mm.plugin.collect.b.f)localObject).hLB.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        y.i("MicroMsg.F2fGetPayUrlManager", "uninit, do cancel netscene");
        g.DQ();
        g.DO().dJT.c((com.tencent.mm.ah.m)localEntry.getKey());
      }
      ((com.tencent.mm.plugin.collect.b.f)localObject).hLB.clear();
      g.DQ();
      g.DO().dJT.b(1588, (com.tencent.mm.ah.f)localObject);
    }
    x.c(this.iLK);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    ay.a(this, null);
  }
  
  protected void onResume()
  {
    super.onResume();
    ay.a(this, this);
  }
  
  public final int xj()
  {
    return a.l.collect_main_preference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI
 * JD-Core Version:    0.7.0.1
 */