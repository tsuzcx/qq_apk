package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.e;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.chp;
import com.tencent.mm.protocal.c.chr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private ListView lwX = null;
  private TextView lwY = null;
  private ProgressDialog lwZ = null;
  private ProgressDialog lxa = null;
  private IPCallPackageUI.a lxb = null;
  private e lxc = null;
  private j lxd = null;
  private com.tencent.mm.plugin.ipcall.a.e.f lxe = new com.tencent.mm.plugin.ipcall.a.e.f();
  
  private void bdd()
  {
    y.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.lxb != null)
    {
      this.lxb.kZk = null;
      this.lxb.notifyDataSetChanged();
    }
    if (this.lwX != null) {
      this.lwX.setVisibility(8);
    }
    if (this.lwY != null) {
      this.lwY.setVisibility(8);
    }
    if (this.lwZ == null)
    {
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      getString(R.l.app_tip);
      this.lwZ = h.b(localAppCompatActivity, getString(R.l.ip_call_loading_tip), true, new IPCallPackageUI.2(this));
    }
    for (;;)
    {
      this.lxc = new e();
      au.Dk().a(this.lxc, 0);
      return;
      this.lwZ.show();
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ipcall_package_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(831, this);
    au.Dk().a(277, this);
    this.lxe.start();
    paramBundle = this.lxe;
    paramBundle.lsa += 1;
    this.lxe.finish();
    setMMTitle(R.l.ipcall_purchase_package);
    setBackBtn(new IPCallPackageUI.1(this));
    this.lwX = ((ListView)findViewById(R.h.package_lv));
    this.lxb = new IPCallPackageUI.a(this);
    this.lwX.setAdapter(this.lxb);
    this.lwY = ((TextView)findViewById(R.h.no_package_tv));
    bdd();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(831, this);
    au.Dk().b(277, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.lwZ != null) && (this.lwZ.isShowing())) {
      this.lwZ.dismiss();
    }
    if ((this.lxa != null) && (this.lxa.isShowing())) {
      this.lxa.dismiss();
    }
    if ((paramm instanceof e))
    {
      y.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramm).lrx;
        if ((paramString != null) && (paramString.tir != null) && (paramString.tir.size() > 0))
        {
          this.lxb.kZk = paramString.tir;
          this.lxb.notifyDataSetChanged();
          this.lwX.setVisibility(0);
          return;
        }
        this.lxb.kZk = null;
        this.lxb.notifyDataSetChanged();
        this.lwY.setVisibility(0);
        return;
      }
      Toast.makeText(this.mController.uMN, getString(R.l.ip_call_load_error_desc), 0).show();
      finish();
      return;
    }
    if ((paramm instanceof j))
    {
      y.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.lxe.lse = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lxe.finish();
        Toast.makeText(this.mController.uMN, getString(R.l.ipcall_purchase_success), 0).show();
        bdd();
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.lxb;
        paramString = (j)paramm;
        if (paramString.lrH != null)
        {
          paramString = paramString.lrH.syc;
          if ((bk.bl(paramString)) || (((IPCallPackageUI.a)localObject).kZk == null)) {
            break label422;
          }
          localObject = ((IPCallPackageUI.a)localObject).kZk.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramm = (chp)((Iterator)localObject).next();
          } while ((paramm == null) || (!paramm.syc.equals(paramString)));
        }
        label422:
        for (paramString = paramm;; paramString = null)
        {
          if (paramString != null) {
            break label427;
          }
          y.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.lxe.finish();
          Toast.makeText(this.mController.uMN, getString(R.l.ipcall_purchase_fail), 0).show();
          return;
          paramString = "";
          break;
        }
        label427:
        h.a(this.mController.uMN, this.mController.uMN.getString(R.l.ipcall_purchase_not_enough_desc, new Object[] { paramString.tAh, paramString.bGw }), this.mController.uMN.getString(R.l.ipcall_purchase_not_enough_title), this.mController.uMN.getString(R.l.ip_call_recharge), this.mController.uMN.getString(R.l.ipcall_purchase_cancel), false, new IPCallPackageUI.4(this), new IPCallPackageUI.5(this));
        return;
      }
      this.lxe.finish();
      Toast.makeText(this.mController.uMN, getString(R.l.ipcall_purchase_fail), 0).show();
      bdd();
      return;
    }
    y.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */