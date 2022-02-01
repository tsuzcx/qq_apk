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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.ecd;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private ListView vek;
  private TextView vel;
  private ProgressDialog vem;
  private ProgressDialog ven;
  private a veo;
  private e vep;
  private j veq;
  private com.tencent.mm.plugin.ipcall.model.f.f ves;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.vek = null;
    this.vel = null;
    this.vem = null;
    this.ven = null;
    this.veo = null;
    this.vep = null;
    this.veq = null;
    this.ves = new com.tencent.mm.plugin.ipcall.model.f.f();
    AppMethodBeat.o(25849);
  }
  
  private void dhw()
  {
    AppMethodBeat.i(25852);
    ae.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.veo != null)
    {
      this.veo.cjg = null;
      this.veo.notifyDataSetChanged();
    }
    if (this.vek != null) {
      this.vek.setVisibility(8);
    }
    if (this.vel != null) {
      this.vel.setVisibility(8);
    }
    dhx();
    this.vep = new e();
    bc.ajj().a(this.vep, 0);
    AppMethodBeat.o(25852);
  }
  
  private void dhx()
  {
    AppMethodBeat.i(25853);
    if (this.vem == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.vem = h.b(localAppCompatActivity, getString(2131760457), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              bc.ajj().a(IPCallPackageUI.a(IPCallPackageUI.this));
            }
            IPCallPackageUI.this.finish();
            AppMethodBeat.o(25840);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            ae.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25840);
          }
        }
      });
      AppMethodBeat.o(25853);
      return;
    }
    this.vem.show();
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
    bc.ajj().a(831, this);
    bc.ajj().a(277, this);
    this.ves.start();
    paramBundle = this.ves;
    paramBundle.uZz += 1;
    this.ves.finish();
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
    this.vek = ((ListView)findViewById(2131303125));
    this.veo = new a(this);
    this.vek.setAdapter(this.veo);
    this.vel = ((TextView)findViewById(2131302879));
    dhw();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    bc.ajj().b(831, this);
    bc.ajj().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25854);
    if ((this.vem != null) && (this.vem.isShowing())) {
      this.vem.dismiss();
    }
    if ((this.ven != null) && (this.ven.isShowing())) {
      this.ven.dismiss();
    }
    if ((paramn instanceof e))
    {
      ae.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramn).uYW;
        if ((paramString != null) && (paramString.GYB != null) && (paramString.GYB.size() > 0))
        {
          this.veo.cjg = paramString.GYB;
          this.veo.notifyDataSetChanged();
          this.vek.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.veo.cjg = null;
        this.veo.notifyDataSetChanged();
        this.vel.setVisibility(0);
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
      ae.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.ves.uZD = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.ves.finish();
        Toast.makeText(getContext(), getString(2131760543), 0).show();
        dhw();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.veo;
        paramString = (j)paramn;
        if (paramString.uZg != null)
        {
          paramString = paramString.uZg.ProductID;
          if ((bu.isNullOrNil(paramString)) || (((a)localObject).cjg == null)) {
            break label447;
          }
          localObject = ((a)localObject).cjg.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramn = (ecd)((Iterator)localObject).next();
          } while ((paramn == null) || (!paramn.ProductID.equals(paramString)));
        }
        label447:
        for (paramString = paramn;; paramString = null)
        {
          if (paramString != null) {
            break label452;
          }
          ae.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.ves.finish();
          Toast.makeText(getContext(), getString(2131760537), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label452:
        h.a(getContext(), getContext().getString(2131760539, new Object[] { paramString.HyQ, paramString.Title }), getContext().getString(2131760540), getContext().getString(2131760475), getContext().getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.uZF += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
            paramAnonymousDialogInterface.uZG += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.ves.finish();
      Toast.makeText(getContext(), getString(2131760537), 0).show();
      dhw();
      AppMethodBeat.o(25854);
      return;
    }
    ae.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
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
    List<ecd> cjg = null;
    private IPCallPackageUI veu = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.veu = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.cjg == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.cjg.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.cjg != null)
      {
        Object localObject = this.cjg.get(paramInt);
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
        paramView = ((LayoutInflater)this.veu.getSystemService("layout_inflater")).inflate(2131494520, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.vey = ((CdnImageView)paramView.findViewById(2131303122));
        paramViewGroup.fSj = ((TextView)paramView.findViewById(2131303126));
        paramViewGroup.vez = ((TextView)paramView.findViewById(2131303127));
        paramViewGroup.heV = ((TextView)paramView.findViewById(2131303117));
        paramViewGroup.gXb = ((TextView)paramView.findViewById(2131303118));
        paramViewGroup.veA = ((Button)paramView.findViewById(2131303116));
        paramView.setTag(paramViewGroup);
      }
      ecd localecd;
      for (;;)
      {
        localecd = (ecd)getItem(paramInt);
        if (localecd != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.fSj.setText(localecd.Title);
      paramViewGroup.vez.setText(localecd.HyQ);
      paramViewGroup.gXb.setText(localecd.Desc);
      paramViewGroup.heV.setText(localecd.urq);
      paramViewGroup.vey.setVisibility(0);
      paramViewGroup.vey.setUrl(localecd.IhG);
      if (localecd.FNv == 0) {
        paramViewGroup.veA.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.veA.setTag(Integer.valueOf(paramInt));
        paramViewGroup.veA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
            paramAnonymousView = (ecd)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (bu.isNullOrNil(paramAnonymousView.ProductID)))
            {
              ae.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            localObject = IPCallPackageUI.b(IPCallPackageUI.this);
            ((com.tencent.mm.plugin.ipcall.model.f.f)localObject).uZA += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).uZE = paramAnonymousView.ProductID;
            h.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(2131760535, new Object[] { paramAnonymousView.HyQ, paramAnonymousView.Title }), IPCallPackageUI.this.getString(2131760536), IPCallPackageUI.this.getString(2131760533), IPCallPackageUI.this.getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.uZB += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.uZC += 1;
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
        paramViewGroup.veA.setEnabled(false);
      }
    }
    
    final class a
    {
      TextView fSj;
      TextView gXb;
      TextView heV;
      Button veA;
      CdnImageView vey;
      TextView vez;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */