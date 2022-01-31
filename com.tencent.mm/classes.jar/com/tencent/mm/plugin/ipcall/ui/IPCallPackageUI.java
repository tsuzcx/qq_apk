package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.e;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private ListView nUk;
  private TextView nUl;
  private ProgressDialog nUm;
  private ProgressDialog nUn;
  private IPCallPackageUI.a nUo;
  private e nUp;
  private j nUq;
  private com.tencent.mm.plugin.ipcall.a.e.f nUr;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(22230);
    this.nUk = null;
    this.nUl = null;
    this.nUm = null;
    this.nUn = null;
    this.nUo = null;
    this.nUp = null;
    this.nUq = null;
    this.nUr = new com.tencent.mm.plugin.ipcall.a.e.f();
    AppMethodBeat.o(22230);
  }
  
  private void bKm()
  {
    AppMethodBeat.i(22233);
    ab.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.nUo != null)
    {
      this.nUo.nxh = null;
      this.nUo.notifyDataSetChanged();
    }
    if (this.nUk != null) {
      this.nUk.setVisibility(8);
    }
    if (this.nUl != null) {
      this.nUl.setVisibility(8);
    }
    bKn();
    this.nUp = new e();
    aw.Rc().a(this.nUp, 0);
    AppMethodBeat.o(22233);
  }
  
  private void bKn()
  {
    AppMethodBeat.i(22234);
    if (this.nUm == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131297087);
      this.nUm = h.b(localAppCompatActivity, getString(2131300856), true, new IPCallPackageUI.2(this));
      AppMethodBeat.o(22234);
      return;
    }
    this.nUm.show();
    AppMethodBeat.o(22234);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969943;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22231);
    super.onCreate(paramBundle);
    aw.Rc().a(831, this);
    aw.Rc().a(277, this);
    this.nUr.start();
    paramBundle = this.nUr;
    paramBundle.nPw += 1;
    this.nUr.finish();
    setMMTitle(2131300940);
    setBackBtn(new IPCallPackageUI.1(this));
    this.nUk = ((ListView)findViewById(2131825311));
    this.nUo = new IPCallPackageUI.a(this);
    this.nUk.setAdapter(this.nUo);
    this.nUl = ((TextView)findViewById(2131825312));
    bKm();
    AppMethodBeat.o(22231);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22232);
    super.onDestroy();
    aw.Rc().b(831, this);
    aw.Rc().b(277, this);
    AppMethodBeat.o(22232);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22235);
    if ((this.nUm != null) && (this.nUm.isShowing())) {
      this.nUm.dismiss();
    }
    if ((this.nUn != null) && (this.nUn.isShowing())) {
      this.nUn.dismiss();
    }
    if ((paramm instanceof e))
    {
      ab.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramm).nOT;
        if ((paramString != null) && (paramString.xhd != null) && (paramString.xhd.size() > 0))
        {
          this.nUo.nxh = paramString.xhd;
          this.nUo.notifyDataSetChanged();
          this.nUk.setVisibility(0);
          AppMethodBeat.o(22235);
          return;
        }
        this.nUo.nxh = null;
        this.nUo.notifyDataSetChanged();
        this.nUl.setVisibility(0);
        AppMethodBeat.o(22235);
        return;
      }
      Toast.makeText(getContext(), getString(2131300853), 0).show();
      finish();
      AppMethodBeat.o(22235);
      return;
    }
    if ((paramm instanceof j))
    {
      ab.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.nUr.nPA = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.nUr.finish();
        Toast.makeText(getContext(), getString(2131300942), 0).show();
        bKm();
        AppMethodBeat.o(22235);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.nUo;
        paramString = (j)paramm;
        if (paramString.nPd != null)
        {
          paramString = paramString.nPd.ProductID;
          if ((bo.isNullOrNil(paramString)) || (((IPCallPackageUI.a)localObject).nxh == null)) {
            break label447;
          }
          localObject = ((IPCallPackageUI.a)localObject).nxh.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramm = (cva)((Iterator)localObject).next();
          } while ((paramm == null) || (!paramm.ProductID.equals(paramString)));
        }
        label447:
        for (paramString = paramm;; paramString = null)
        {
          if (paramString != null) {
            break label452;
          }
          ab.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.nUr.finish();
          Toast.makeText(getContext(), getString(2131300936), 0).show();
          AppMethodBeat.o(22235);
          return;
          paramString = "";
          break;
        }
        label452:
        h.a(getContext(), getContext().getString(2131300938, new Object[] { paramString.xBK, paramString.Title }), getContext().getString(2131300939), getContext().getString(2131300874), getContext().getString(2131300933), false, new IPCallPackageUI.4(this), new IPCallPackageUI.5(this));
        AppMethodBeat.o(22235);
        return;
      }
      this.nUr.finish();
      Toast.makeText(getContext(), getString(2131300936), 0).show();
      bKm();
      AppMethodBeat.o(22235);
      return;
    }
    ab.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(22235);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */