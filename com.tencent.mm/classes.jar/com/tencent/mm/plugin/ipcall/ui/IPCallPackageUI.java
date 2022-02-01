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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private ProgressDialog uSA;
  private ProgressDialog uSB;
  private a uSC;
  private e uSD;
  private j uSE;
  private com.tencent.mm.plugin.ipcall.model.f.f uSF;
  private ListView uSy;
  private TextView uSz;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.uSy = null;
    this.uSz = null;
    this.uSA = null;
    this.uSB = null;
    this.uSC = null;
    this.uSD = null;
    this.uSE = null;
    this.uSF = new com.tencent.mm.plugin.ipcall.model.f.f();
    AppMethodBeat.o(25849);
  }
  
  private void deE()
  {
    AppMethodBeat.i(25852);
    ad.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.uSC != null)
    {
      this.uSC.cje = null;
      this.uSC.notifyDataSetChanged();
    }
    if (this.uSy != null) {
      this.uSy.setVisibility(8);
    }
    if (this.uSz != null) {
      this.uSz.setVisibility(8);
    }
    deF();
    this.uSD = new e();
    ba.aiU().a(this.uSD, 0);
    AppMethodBeat.o(25852);
  }
  
  private void deF()
  {
    AppMethodBeat.i(25853);
    if (this.uSA == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.uSA = h.b(localAppCompatActivity, getString(2131760457), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              ba.aiU().a(IPCallPackageUI.a(IPCallPackageUI.this));
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
    this.uSA.show();
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
    ba.aiU().a(831, this);
    ba.aiU().a(277, this);
    this.uSF.start();
    paramBundle = this.uSF;
    paramBundle.uNM += 1;
    this.uSF.finish();
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
    this.uSy = ((ListView)findViewById(2131303125));
    this.uSC = new a(this);
    this.uSy.setAdapter(this.uSC);
    this.uSz = ((TextView)findViewById(2131302879));
    deE();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    ba.aiU().b(831, this);
    ba.aiU().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25854);
    if ((this.uSA != null) && (this.uSA.isShowing())) {
      this.uSA.dismiss();
    }
    if ((this.uSB != null) && (this.uSB.isShowing())) {
      this.uSB.dismiss();
    }
    if ((paramn instanceof e))
    {
      ad.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramn).uNj;
        if ((paramString != null) && (paramString.GEZ != null) && (paramString.GEZ.size() > 0))
        {
          this.uSC.cje = paramString.GEZ;
          this.uSC.notifyDataSetChanged();
          this.uSy.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.uSC.cje = null;
        this.uSC.notifyDataSetChanged();
        this.uSz.setVisibility(0);
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
      this.uSF.uNQ = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uSF.finish();
        Toast.makeText(getContext(), getString(2131760543), 0).show();
        deE();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.uSC;
        paramString = (j)paramn;
        if (paramString.uNt != null)
        {
          paramString = paramString.uNt.ProductID;
          if ((bt.isNullOrNil(paramString)) || (((a)localObject).cje == null)) {
            break label447;
          }
          localObject = ((a)localObject).cje.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramn = (eam)((Iterator)localObject).next();
          } while ((paramn == null) || (!paramn.ProductID.equals(paramString)));
        }
        label447:
        for (paramString = paramn;; paramString = null)
        {
          if (paramString != null) {
            break label452;
          }
          ad.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.uSF.finish();
          Toast.makeText(getContext(), getString(2131760537), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label452:
        h.a(getContext(), getContext().getString(2131760539, new Object[] { paramString.Hfq, paramString.Title }), getContext().getString(2131760540), getContext().getString(2131760475), getContext().getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.uNS += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
            paramAnonymousDialogInterface.uNT += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.uSF.finish();
      Toast.makeText(getContext(), getString(2131760537), 0).show();
      deE();
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
    List<eam> cje = null;
    private IPCallPackageUI uSH = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.uSH = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.cje == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.cje.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.cje != null)
      {
        Object localObject = this.cje.get(paramInt);
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
        paramView = ((LayoutInflater)this.uSH.getSystemService("layout_inflater")).inflate(2131494520, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.uSL = ((CdnImageView)paramView.findViewById(2131303122));
        paramViewGroup.fQd = ((TextView)paramView.findViewById(2131303126));
        paramViewGroup.uSM = ((TextView)paramView.findViewById(2131303127));
        paramViewGroup.hch = ((TextView)paramView.findViewById(2131303117));
        paramViewGroup.gUs = ((TextView)paramView.findViewById(2131303118));
        paramViewGroup.uSN = ((Button)paramView.findViewById(2131303116));
        paramView.setTag(paramViewGroup);
      }
      eam localeam;
      for (;;)
      {
        localeam = (eam)getItem(paramInt);
        if (localeam != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.fQd.setText(localeam.Title);
      paramViewGroup.uSM.setText(localeam.Hfq);
      paramViewGroup.gUs.setText(localeam.Desc);
      paramViewGroup.hch.setText(localeam.uOt);
      paramViewGroup.uSL.setVisibility(0);
      paramViewGroup.uSL.setUrl(localeam.HNz);
      if (localeam.FuX == 0) {
        paramViewGroup.uSN.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.uSN.setTag(Integer.valueOf(paramInt));
        paramViewGroup.uSN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
            paramAnonymousView = (eam)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (bt.isNullOrNil(paramAnonymousView.ProductID)))
            {
              ad.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            localObject = IPCallPackageUI.b(IPCallPackageUI.this);
            ((com.tencent.mm.plugin.ipcall.model.f.f)localObject).uNN += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).uNR = paramAnonymousView.ProductID;
            h.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(2131760535, new Object[] { paramAnonymousView.Hfq, paramAnonymousView.Title }), IPCallPackageUI.this.getString(2131760536), IPCallPackageUI.this.getString(2131760533), IPCallPackageUI.this.getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.uNO += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.uNP += 1;
                IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this)).finish();
                AppMethodBeat.o(25844);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25845);
          }
        });
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup.uSN.setEnabled(false);
      }
    }
    
    final class a
    {
      TextView fQd;
      TextView gUs;
      TextView hch;
      CdnImageView uSL;
      TextView uSM;
      Button uSN;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */