package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.plugin.ipcall.model.f.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.fgw;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements i
{
  private ListView DWO;
  private TextView DWP;
  private ProgressDialog DWQ;
  private ProgressDialog DWR;
  private a DWS;
  private e DWT;
  private j DWU;
  private f DWV;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.DWO = null;
    this.DWP = null;
    this.DWQ = null;
    this.DWR = null;
    this.DWS = null;
    this.DWT = null;
    this.DWU = null;
    this.DWV = new f();
    AppMethodBeat.o(25849);
  }
  
  private void eKo()
  {
    AppMethodBeat.i(25852);
    Log.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.DWS != null)
    {
      this.DWS.ctq = null;
      this.DWS.notifyDataSetChanged();
    }
    if (this.DWO != null) {
      this.DWO.setVisibility(8);
    }
    if (this.DWP != null) {
      this.DWP.setVisibility(8);
    }
    eKp();
    this.DWT = new e();
    bh.aGY().a(this.DWT, 0);
    AppMethodBeat.o(25852);
  }
  
  private void eKp()
  {
    AppMethodBeat.i(25853);
    if (this.DWQ == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(R.l.app_tip);
      this.DWQ = h.a(localAppCompatActivity, getString(R.l.eIQ), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              bh.aGY().a(IPCallPackageUI.a(IPCallPackageUI.this));
            }
            IPCallPackageUI.this.finish();
            AppMethodBeat.o(25840);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            Log.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25840);
          }
        }
      });
      AppMethodBeat.o(25853);
      return;
    }
    this.DWQ.show();
    AppMethodBeat.o(25853);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.eif;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25850);
    super.onCreate(paramBundle);
    bh.aGY().a(831, this);
    bh.aGY().a(277, this);
    this.DWV.start();
    paramBundle = this.DWV;
    paramBundle.DSb += 1;
    this.DWV.finish();
    setMMTitle(R.l.eJU);
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
    this.DWO = ((ListView)findViewById(R.h.dQQ));
    this.DWS = new a(this);
    this.DWO.setAdapter(this.DWS);
    this.DWP = ((TextView)findViewById(R.h.dPr));
    eKo();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    bh.aGY().b(831, this);
    bh.aGY().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25854);
    if ((this.DWQ != null) && (this.DWQ.isShowing())) {
      this.DWQ.dismiss();
    }
    if ((this.DWR != null) && (this.DWR.isShowing())) {
      this.DWR.dismiss();
    }
    if ((paramq instanceof e))
    {
      Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramq).DRy;
        if ((paramString != null) && (paramString.TmS != null) && (paramString.TmS.size() > 0))
        {
          this.DWS.ctq = paramString.TmS;
          this.DWS.notifyDataSetChanged();
          this.DWO.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.DWS.ctq = null;
        this.DWS.notifyDataSetChanged();
        this.DWP.setVisibility(0);
        AppMethodBeat.o(25854);
        return;
      }
      Toast.makeText(getContext(), getString(R.l.eIN), 0).show();
      finish();
      AppMethodBeat.o(25854);
      return;
    }
    if ((paramq instanceof j))
    {
      Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.DWV.DSf = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.DWV.finish();
        Toast.makeText(getContext(), getString(R.l.eJW), 0).show();
        eKo();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.DWS;
        paramString = (j)paramq;
        if (paramString.DRI != null)
        {
          paramString = paramString.DRI.ProductID;
          if ((Util.isNullOrNil(paramString)) || (((a)localObject).ctq == null)) {
            break label450;
          }
          localObject = ((a)localObject).ctq.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramq = (fgw)((Iterator)localObject).next();
          } while ((paramq == null) || (!paramq.ProductID.equals(paramString)));
        }
        label450:
        for (paramString = paramq;; paramString = null)
        {
          if (paramString != null) {
            break label455;
          }
          Log.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.DWV.finish();
          Toast.makeText(getContext(), getString(R.l.eJR), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label455:
        h.a(getContext(), getContext().getString(R.l.eJS, new Object[] { paramString.TVo, paramString.fwr }), getContext().getString(R.l.eJT), getContext().getString(R.l.eJa), getContext().getString(R.l.eJO), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.DSh += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            IPCallPackageUI.this.finish();
            AppMethodBeat.o(25841);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25842);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.DSi += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.DWV.finish();
      Toast.makeText(getContext(), getString(R.l.eJR), 0).show();
      eKo();
      AppMethodBeat.o(25854);
      return;
    }
    Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
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
    private IPCallPackageUI DWX = null;
    List<fgw> ctq = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.DWX = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.ctq == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.ctq.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.ctq != null)
      {
        Object localObject = this.ctq.get(paramInt);
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
        paramView = ((LayoutInflater)this.DWX.getSystemService("layout_inflater")).inflate(R.i.eie, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.DXb = ((CdnImageView)paramView.findViewById(R.h.dQO));
        paramViewGroup.jbF = ((TextView)paramView.findViewById(R.h.dQR));
        paramViewGroup.DXc = ((TextView)paramView.findViewById(R.h.dQS));
        paramViewGroup.kMp = ((TextView)paramView.findViewById(R.h.dQL));
        paramViewGroup.kEs = ((TextView)paramView.findViewById(R.h.dQM));
        paramViewGroup.DXd = ((Button)paramView.findViewById(R.h.dQK));
        paramView.setTag(paramViewGroup);
      }
      fgw localfgw;
      for (;;)
      {
        localfgw = (fgw)getItem(paramInt);
        if (localfgw != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.jbF.setText(localfgw.fwr);
      paramViewGroup.DXc.setText(localfgw.TVo);
      paramViewGroup.kEs.setText(localfgw.CMB);
      paramViewGroup.kMp.setText(localfgw.CNP);
      paramViewGroup.DXb.setVisibility(0);
      paramViewGroup.DXb.setUrl(localfgw.UHh);
      if (localfgw.RIs == 0) {
        paramViewGroup.DXd.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.DXd.setTag(Integer.valueOf(paramInt));
        paramViewGroup.DXd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            Object localObject = new b();
            ((b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
            paramAnonymousView = (fgw)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (Util.isNullOrNil(paramAnonymousView.ProductID)))
            {
              Log.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            localObject = IPCallPackageUI.b(IPCallPackageUI.this);
            ((f)localObject).DSc += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).DSg = paramAnonymousView.ProductID;
            h.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(R.l.eJP, new Object[] { paramAnonymousView.TVo, paramAnonymousView.fwr }), IPCallPackageUI.this.getString(R.l.eJQ), IPCallPackageUI.this.getString(R.l.eJN), IPCallPackageUI.this.getString(R.l.eJO), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.DSd += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.DSe += 1;
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
        paramViewGroup.DXd.setEnabled(false);
      }
    }
    
    final class a
    {
      CdnImageView DXb;
      TextView DXc;
      Button DXd;
      TextView jbF;
      TextView kEs;
      TextView kMp;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */