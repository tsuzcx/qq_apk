package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.plugin.ipcall.model.f.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements g
{
  private ListView sIe;
  private TextView sIf;
  private ProgressDialog sIg;
  private ProgressDialog sIh;
  private a sIi;
  private e sIj;
  private j sIk;
  private f sIl;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.sIe = null;
    this.sIf = null;
    this.sIg = null;
    this.sIh = null;
    this.sIi = null;
    this.sIj = null;
    this.sIk = null;
    this.sIl = new f();
    AppMethodBeat.o(25849);
  }
  
  private void cIi()
  {
    AppMethodBeat.i(25852);
    ad.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.sIi != null)
    {
      this.sIi.cbP = null;
      this.sIi.notifyDataSetChanged();
    }
    if (this.sIe != null) {
      this.sIe.setVisibility(8);
    }
    if (this.sIf != null) {
      this.sIf.setVisibility(8);
    }
    cIj();
    this.sIj = new e();
    az.aeS().a(this.sIj, 0);
    AppMethodBeat.o(25852);
  }
  
  private void cIj()
  {
    AppMethodBeat.i(25853);
    if (this.sIg == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.sIg = h.b(localAppCompatActivity, getString(2131760457), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              az.aeS().a(IPCallPackageUI.a(IPCallPackageUI.this));
            }
            IPCallPackageUI.this.finish();
            AppMethodBeat.o(25840);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            ad.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25840);
          }
        }
      });
      AppMethodBeat.o(25853);
      return;
    }
    this.sIg.show();
    AppMethodBeat.o(25853);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494521;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25850);
    super.onCreate(paramBundle);
    az.aeS().a(831, this);
    az.aeS().a(277, this);
    this.sIl.start();
    paramBundle = this.sIl;
    paramBundle.sDr += 1;
    this.sIl.finish();
    setMMTitle(2131760541);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25839);
        IPCallPackageUI.this.finish();
        AppMethodBeat.o(25839);
        return true;
      }
    });
    this.sIe = ((ListView)findViewById(2131303125));
    this.sIi = new a(this);
    this.sIe.setAdapter(this.sIi);
    this.sIf = ((TextView)findViewById(2131302879));
    cIi();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    az.aeS().b(831, this);
    az.aeS().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25854);
    if ((this.sIg != null) && (this.sIg.isShowing())) {
      this.sIg.dismiss();
    }
    if ((this.sIh != null) && (this.sIh.isShowing())) {
      this.sIh.dismiss();
    }
    if ((paramn instanceof e))
    {
      ad.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramn).sCO;
        if ((paramString != null) && (paramString.DAf != null) && (paramString.DAf.size() > 0))
        {
          this.sIi.cbP = paramString.DAf;
          this.sIi.notifyDataSetChanged();
          this.sIe.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.sIi.cbP = null;
        this.sIi.notifyDataSetChanged();
        this.sIf.setVisibility(0);
        AppMethodBeat.o(25854);
        return;
      }
      Toast.makeText(getContext(), getString(2131760454), 0).show();
      finish();
      AppMethodBeat.o(25854);
      return;
    }
    if ((paramn instanceof j))
    {
      ad.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.sIl.sDv = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.sIl.finish();
        Toast.makeText(getContext(), getString(2131760543), 0).show();
        cIi();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.sIi;
        paramString = (j)paramn;
        if (paramString.sCY != null)
        {
          paramString = paramString.sCY.ProductID;
          if ((bt.isNullOrNil(paramString)) || (((a)localObject).cbP == null)) {
            break label447;
          }
          localObject = ((a)localObject).cbP.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramn = (dpb)((Iterator)localObject).next();
          } while ((paramn == null) || (!paramn.ProductID.equals(paramString)));
        }
        label447:
        for (paramString = paramn;; paramString = null)
        {
          if (paramString != null) {
            break label452;
          }
          ad.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.sIl.finish();
          Toast.makeText(getContext(), getString(2131760537), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label452:
        h.a(getContext(), getContext().getString(2131760539, new Object[] { paramString.DYr, paramString.Title }), getContext().getString(2131760540), getContext().getString(2131760475), getContext().getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.sDx += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            IPCallPackageUI.this.finish();
            AppMethodBeat.o(25841);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25842);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.sDy += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.sIl.finish();
      Toast.makeText(getContext(), getString(2131760537), 0).show();
      cIi();
      AppMethodBeat.o(25854);
      return;
    }
    ad.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(25854);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    List<dpb> cbP = null;
    private IPCallPackageUI sIn = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.sIn = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.cbP == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.cbP.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.cbP != null)
      {
        Object localObject = this.cbP.get(paramInt);
        AppMethodBeat.o(25847);
        return localObject;
      }
      AppMethodBeat.o(25847);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25848);
      if (paramView == null)
      {
        paramView = ((LayoutInflater)this.sIn.getSystemService("layout_inflater")).inflate(2131494520, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.sIr = ((CdnImageView)paramView.findViewById(2131303122));
        paramViewGroup.ftj = ((TextView)paramView.findViewById(2131303126));
        paramViewGroup.sIs = ((TextView)paramView.findViewById(2131303127));
        paramViewGroup.sIt = ((TextView)paramView.findViewById(2131303117));
        paramViewGroup.lEA = ((TextView)paramView.findViewById(2131303118));
        paramViewGroup.sIu = ((Button)paramView.findViewById(2131303116));
        paramView.setTag(paramViewGroup);
      }
      dpb localdpb;
      for (;;)
      {
        localdpb = (dpb)getItem(paramInt);
        if (localdpb != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.ftj.setText(localdpb.Title);
      paramViewGroup.sIs.setText(localdpb.DYr);
      paramViewGroup.lEA.setText(localdpb.Desc);
      paramViewGroup.sIt.setText(localdpb.sDZ);
      paramViewGroup.sIr.setVisibility(0);
      paramViewGroup.sIr.setUrl(localdpb.EFq);
      if (localdpb.Cxm == 0) {
        paramViewGroup.sIu.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.sIu.setTag(Integer.valueOf(paramInt));
        paramViewGroup.sIu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            paramAnonymousView = (dpb)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (bt.isNullOrNil(paramAnonymousView.ProductID)))
            {
              ad.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            f localf = IPCallPackageUI.b(IPCallPackageUI.this);
            localf.sDs += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).sDw = paramAnonymousView.ProductID;
            h.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(2131760535, new Object[] { paramAnonymousView.DYr, paramAnonymousView.Title }), IPCallPackageUI.this.getString(2131760536), IPCallPackageUI.this.getString(2131760533), IPCallPackageUI.this.getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.sDt += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.sDu += 1;
                IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this)).finish();
                AppMethodBeat.o(25844);
              }
            });
            AppMethodBeat.o(25845);
          }
        });
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup.sIu.setEnabled(false);
      }
    }
    
    final class a
    {
      TextView ftj;
      TextView lEA;
      CdnImageView sIr;
      TextView sIs;
      TextView sIt;
      Button sIu;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */