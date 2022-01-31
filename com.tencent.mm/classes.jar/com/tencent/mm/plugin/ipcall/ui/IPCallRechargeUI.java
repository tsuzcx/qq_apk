package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.m.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallRechargeUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  TextView iIV;
  private h.a jeJ = new IPCallRechargeUI.1(this);
  private int jeu = -1;
  private String[] jew;
  ProgressDialog luI;
  private com.tencent.mm.plugin.ipcall.a.e.h lxA = new com.tencent.mm.plugin.ipcall.a.e.h();
  private com.tencent.mm.plugin.ipcall.a.e.g lxB = new com.tencent.mm.plugin.ipcall.a.e.g();
  private j lxC = new j();
  RelativeLayout lxD;
  GridView lxE;
  ListView lxF;
  IPCallRechargeUI.a lxG;
  Button lxH;
  com.tencent.mm.plugin.ipcall.a.d.f lxI;
  private String[] lxr;
  private String[] lxs;
  private String lxt;
  private String lxu;
  private boolean lxv = false;
  private int lxw;
  private int lxx = -1;
  private String lxy;
  private String lxz;
  private ah mHandler = new IPCallRechargeUI.3(this);
  
  private void AR(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(R.l.ipcall_play_failed);
    }
    com.tencent.mm.ui.base.h.a(this, str, getString(R.l.ipcall_play_failed), new IPCallRechargeUI.12(this));
  }
  
  private void FP(String paramString)
  {
    Object localObject = com.tencent.mm.plugin.ipcall.a.c.bbS().bbV();
    if (((List)localObject).size() == 0) {}
    for (localObject = a.FZ(com.tencent.mm.plugin.ipcall.b.c.bdr());; localObject = a.FZ(((Integer)((List)localObject).get(0)).toString()))
    {
      this.lxI = new com.tencent.mm.plugin.ipcall.a.d.f((String)localObject, paramString);
      au.Dk().a(this.lxI, 0);
      return;
    }
  }
  
  private boolean FQ(String paramString)
  {
    if (com.tencent.mm.m.g.AA().getInt("WCOSecondPurchaseSwitch", 0) > 0)
    {
      i = 1;
      if (i == 0) {
        break label137;
      }
    }
    label137:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (this.lxx < 0)) {
        break label142;
      }
      Object localObject = this.lxG.getItem(this.lxx);
      if ((!(localObject instanceof chl)) || (bk.bl(((chl)localObject).tWo))) {
        break label142;
      }
      localObject = ((chl)localObject).tWo;
      y.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:" + (String)localObject);
      com.tencent.mm.ui.base.h.a(this, paramString, getString(R.l.ipcall_play_failed), getString(R.l.ip_call_webview_recharge_tips), getString(R.l.app_cancel), true, new IPCallRechargeUI.2(this, (String)localObject), null);
      return true;
      i = 0;
      break;
    }
    label142:
    return false;
  }
  
  public final void bde()
  {
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessage(1002);
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ipcall_recharge_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    boolean bool1;
    int j;
    Object localObject;
    int i;
    if (paramInt1 == 2001)
    {
      bool1 = false;
      if (paramIntent == null) {
        break label1118;
      }
      j = paramIntent.getIntExtra("key_err_code", 0);
      localObject = paramIntent.getStringExtra("key_err_msg");
      long l = paramIntent.getLongExtra("key_launch_ts", 0L);
      paramInt1 = paramIntent.getIntExtra("key_gw_error_code", 0);
      i = paramIntent.getIntExtra("key_response_position", 0);
      if (j == 100000001) {
        bool1 = true;
      }
      y.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(j), localObject, Integer.valueOf(paramInt1), Integer.valueOf(i), String.valueOf(bool1) });
      if ((j == 6) && (paramInt1 != 0))
      {
        this.lxB.lsn = paramInt1;
        if (i != 3) {
          break label343;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 9L, 1L, true);
        com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 11L, 1L, true);
        this.lxB.lsn = 0L;
        this.lxB.lso = 2L;
        localObject = getString(R.l.ipcall_verify_failed);
        label228:
        this.lxB.lsm = l;
        this.lxB.lrU = bk.UY();
        this.lxB.finish();
      }
    }
    for (;;)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (j != 0)) {
          break label472;
        }
        localObject = paramIntent.getStringArrayListExtra("key_response_product_ids");
        paramIntent.getStringArrayListExtra("key_response_series_ids");
        paramIntent = ((ArrayList)localObject).iterator();
        for (;;)
        {
          if (paramIntent.hasNext())
          {
            y.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[] { bk.pm((String)paramIntent.next()) });
            continue;
            this.lxB.lsn = j;
            break;
            label343:
            if (i != 1)
            {
              if ((paramInt2 == -1) && (j == 0))
              {
                com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 9L, 1L, true);
                break label228;
              }
              if (bool1)
              {
                com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 9L, 1L, true);
                com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 12L, 1L, true);
                this.lxB.lsn = 0L;
                this.lxB.lso = 1L;
              }
            }
            break label228;
          }
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 6L, 1L, true);
        com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 10L, 1L, true);
        Toast.makeText(this, R.l.ipcall_play_success, 0).show();
        finish();
      }
      label472:
      do
      {
        do
        {
          do
          {
            return;
            if ((paramIntent != null) && (j == 100000002))
            {
              com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 6L, 1L, true);
              AR((String)localObject);
              return;
            }
            if ((paramIntent != null) && (j == 109))
            {
              AR((String)localObject);
              return;
            }
            if ((paramIntent != null) && (j == 1))
            {
              paramIntent = getString(R.l.ipcall_play_cancelled);
              com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 8L, 1L, true);
              Toast.makeText(this, paramIntent, 0).show();
              return;
            }
            if ((paramIntent != null) && (j == 113))
            {
              com.tencent.mm.ui.base.h.a(this, getString(R.l.ipcall_discount_expired), getString(R.l.ipcall_play_failed), new IPCallRechargeUI.10(this));
              return;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 7L, 1L, true);
            if (i == 3)
            {
              AR((String)localObject);
              return;
            }
          } while ((j != 100000001) && (j != 6));
          if (paramInt1 == 0)
          {
            Toast.makeText(this, getString(R.l.ip_call_load_error_desc), 0).show();
            return;
          }
          paramIntent = getString(R.l.ip_call_load_google_wallet_error_desc);
        } while (FQ(paramIntent));
        Toast.makeText(this, paramIntent, 0).show();
        return;
      } while (paramInt1 != 2002);
      if ((this.luI != null) && (this.luI.isShowing())) {
        this.luI.dismiss();
      }
      localObject = "";
      i = 0;
      paramInt1 = 0;
      bool1 = false;
      boolean bool2 = false;
      if (paramIntent != null)
      {
        i = paramIntent.getIntExtra("key_err_code", 0);
        localObject = paramIntent.getStringExtra("key_err_msg");
        paramInt1 = paramIntent.getIntExtra("key_response_position", 0);
        bool1 = bool2;
        if (i == 100000001) {
          bool1 = true;
        }
        y.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[] { Integer.valueOf(i), localObject, Integer.valueOf(paramInt1), String.valueOf(bool1) });
      }
      this.lxC.lsw = i;
      this.lxC.lsu = 0L;
      if (paramInt2 == -1) {
        if ((paramIntent != null) && (i == 0))
        {
          paramIntent = paramIntent.getStringArrayListExtra("key_response_product_ids");
          if ((paramIntent != null) && (paramIntent.size() > 0))
          {
            this.lxC.lsv = 0L;
            com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 15L, 1L, true);
            y.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
            com.tencent.mm.ui.base.h.a(this, getString(R.l.ipcall_restore_success), getString(R.l.ipcall_restore_success_title), new IPCallRechargeUI.11(this));
          }
        }
      }
      for (;;)
      {
        this.lxC.lrU = bk.UY();
        this.lxC.finish();
        return;
        this.lxC.lsv = 3L;
        y.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
        Toast.makeText(this, R.l.ipcall_restore_no_product, 0).show();
        continue;
        if (bool1)
        {
          this.lxC.lsv = 1L;
          com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 17L, 1L, true);
          localObject = getString(R.l.ipcall_restore_no_product);
        }
        for (;;)
        {
          y.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
          Toast.makeText(this, (CharSequence)localObject, 0).show();
          break;
          if (paramInt1 == 3)
          {
            this.lxC.lsv = 2L;
            com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 16L, 1L, true);
          }
          else
          {
            this.lxC.lsv = 2L;
          }
        }
        this.lxC.lsv = 2L;
        y.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
        Toast.makeText(this, R.l.ipcall_restore_failed, 0).show();
      }
      label1118:
      paramInt1 = 0;
      i = 0;
      j = 0;
      localObject = "";
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(929, this);
    setMMTitle(R.l.ip_call_recharge);
    setBackBtn(new IPCallRechargeUI.5(this));
    addIconOptionMenu(0, R.g.mm_title_btn_menu, new IPCallRechargeUI.6(this));
    this.lxD = ((RelativeLayout)findViewById(R.h.layout));
    this.lxE = ((GridView)findViewById(R.h.recharge_gv));
    this.lxF = ((ListView)findViewById(R.h.recharge_lv));
    paramBundle = (ViewGroup)View.inflate(this.mController.uMN, R.i.ipcall_recharge_bottom_tip, null);
    this.lxF.addFooterView(paramBundle, null, false);
    this.lxG = new IPCallRechargeUI.a(this);
    this.lxF.setAdapter(this.lxG);
    this.iIV = ((TextView)paramBundle.findViewById(R.h.tip_tv));
    this.lxH = ((Button)findViewById(R.h.buy_btn));
    paramBundle = getString(R.l.ip_call_recharge_see_price_tip);
    Spannable localSpannable = Spannable.Factory.getInstance().newSpannable(paramBundle);
    localSpannable.setSpan(new IPCallRechargeUI.7(this), 0, paramBundle.length(), 33);
    this.iIV.setText(localSpannable);
    this.iIV.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = this.mController.uMN;
    getString(R.l.app_tip);
    this.luI = com.tencent.mm.ui.base.h.b(paramBundle, getString(R.l.ip_call_loading_tip), true, new IPCallRechargeUI.8(this));
    FP("");
    this.lxA.start();
    com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 4L, 1L, true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.lxA.lrU = bk.UY();
    this.lxA.finish();
    au.Dk().b(929, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    y.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.f))
    {
      paramString = this.lxA;
      paramString.lsr = bk.UY();
      paramString.lss = paramInt2;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label389;
      }
      paramString = ((com.tencent.mm.plugin.ipcall.a.d.f)paramm).lrz;
      this.lxG.kZk = paramString.tdf;
      this.lxG.lxM = paramString;
      this.lxG.notifyDataSetChanged();
      this.jew = new String[paramString.tdf.size()];
      Iterator localIterator = paramString.tdf.iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        chl localchl = (chl)localIterator.next();
        this.jew[paramInt1] = localchl.syc;
        paramInt1 += 1;
      }
      this.lxy = paramString.tiz;
      this.lxz = paramString.tiA;
      this.lxt = paramString.tiu;
      this.lxu = paramString.tiy;
      this.lxw = paramString.tix;
      if (this.lxv)
      {
        this.lxs = new String[paramString.tdf.size()];
        paramInt1 = 0;
        while (paramInt1 < this.lxs.length)
        {
          this.lxs[paramInt1] = paramString.tiy;
          paramInt1 += 1;
        }
        this.lxr = new String[paramString.tdf.size()];
        paramInt1 = i;
        while (paramInt1 < this.lxr.length)
        {
          this.lxr[paramInt1] = IPCallDynamicTextView.FO(((chl)paramString.tdf.get(paramInt1)).tAh);
          paramInt1 += 1;
        }
      }
      if (!((com.tencent.mm.plugin.ipcall.a.d.f)paramm).lrA) {
        break label360;
      }
      y.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
      if ((this.jew != null) && (this.jew.length > 0))
      {
        y.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
        com.tencent.mm.pluginsdk.model.h.a(this, this.jew, this.jeJ);
      }
    }
    return;
    label360:
    if ((this.luI != null) && (this.luI.isShowing())) {
      this.luI.dismiss();
    }
    bde();
    return;
    label389:
    if ((this.luI != null) && (this.luI.isShowing())) {
      this.luI.dismiss();
    }
    Toast.makeText(this.mController.uMN, getString(R.l.ip_call_load_error_desc), 0).show();
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI
 * JD-Core Version:    0.7.0.1
 */