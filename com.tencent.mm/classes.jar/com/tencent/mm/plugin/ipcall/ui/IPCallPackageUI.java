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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.plugin.ipcall.model.f.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.duu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements g
{
  private ListView tPL;
  private TextView tPM;
  private ProgressDialog tPN;
  private ProgressDialog tPO;
  private a tPP;
  private e tPQ;
  private j tPR;
  private f tPS;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.tPL = null;
    this.tPM = null;
    this.tPN = null;
    this.tPO = null;
    this.tPP = null;
    this.tPQ = null;
    this.tPR = null;
    this.tPS = new f();
    AppMethodBeat.o(25849);
  }
  
  private void cVt()
  {
    AppMethodBeat.i(25852);
    ac.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.tPP != null)
    {
      this.tPP.bYM = null;
      this.tPP.notifyDataSetChanged();
    }
    if (this.tPL != null) {
      this.tPL.setVisibility(8);
    }
    if (this.tPM != null) {
      this.tPM.setVisibility(8);
    }
    cVu();
    this.tPQ = new e();
    az.agi().a(this.tPQ, 0);
    AppMethodBeat.o(25852);
  }
  
  private void cVu()
  {
    AppMethodBeat.i(25853);
    if (this.tPN == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.tPN = h.b(localAppCompatActivity, getString(2131760457), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              az.agi().a(IPCallPackageUI.a(IPCallPackageUI.this));
            }
            IPCallPackageUI.this.finish();
            AppMethodBeat.o(25840);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            ac.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
            AppMethodBeat.o(25840);
          }
        }
      });
      AppMethodBeat.o(25853);
      return;
    }
    this.tPN.show();
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
    az.agi().a(831, this);
    az.agi().a(277, this);
    this.tPS.start();
    paramBundle = this.tPS;
    paramBundle.tKZ += 1;
    this.tPS.finish();
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
    this.tPL = ((ListView)findViewById(2131303125));
    this.tPP = new a(this);
    this.tPL.setAdapter(this.tPP);
    this.tPM = ((TextView)findViewById(2131302879));
    cVt();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    az.agi().b(831, this);
    az.agi().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25854);
    if ((this.tPN != null) && (this.tPN.isShowing())) {
      this.tPN.dismiss();
    }
    if ((this.tPO != null) && (this.tPO.isShowing())) {
      this.tPO.dismiss();
    }
    if ((paramn instanceof e))
    {
      ac.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramn).tKw;
        if ((paramString != null) && (paramString.EVB != null) && (paramString.EVB.size() > 0))
        {
          this.tPP.bYM = paramString.EVB;
          this.tPP.notifyDataSetChanged();
          this.tPL.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.tPP.bYM = null;
        this.tPP.notifyDataSetChanged();
        this.tPM.setVisibility(0);
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
      ac.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.tPS.tLd = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tPS.finish();
        Toast.makeText(getContext(), getString(2131760543), 0).show();
        cVt();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.tPP;
        paramString = (j)paramn;
        if (paramString.tKG != null)
        {
          paramString = paramString.tKG.ProductID;
          if ((bs.isNullOrNil(paramString)) || (((a)localObject).bYM == null)) {
            break label447;
          }
          localObject = ((a)localObject).bYM.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramn = (dus)((Iterator)localObject).next();
          } while ((paramn == null) || (!paramn.ProductID.equals(paramString)));
        }
        label447:
        for (paramString = paramn;; paramString = null)
        {
          if (paramString != null) {
            break label452;
          }
          ac.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.tPS.finish();
          Toast.makeText(getContext(), getString(2131760537), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label452:
        h.a(getContext(), getContext().getString(2131760539, new Object[] { paramString.Fvl, paramString.Title }), getContext().getString(2131760540), getContext().getString(2131760475), getContext().getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.tLf += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
            paramAnonymousDialogInterface.tLg += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.tPS.finish();
      Toast.makeText(getContext(), getString(2131760537), 0).show();
      cVt();
      AppMethodBeat.o(25854);
      return;
    }
    ac.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
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
    List<dus> bYM = null;
    private IPCallPackageUI tPU = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.tPU = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.bYM == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.bYM.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.bYM != null)
      {
        Object localObject = this.bYM.get(paramInt);
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
        paramView = ((LayoutInflater)this.tPU.getSystemService("layout_inflater")).inflate(2131494520, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.tPY = ((CdnImageView)paramView.findViewById(2131303122));
        paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131303126));
        paramViewGroup.tPZ = ((TextView)paramView.findViewById(2131303127));
        paramViewGroup.gIx = ((TextView)paramView.findViewById(2131303117));
        paramViewGroup.gAI = ((TextView)paramView.findViewById(2131303118));
        paramViewGroup.tQa = ((Button)paramView.findViewById(2131303116));
        paramView.setTag(paramViewGroup);
      }
      dus localdus;
      for (;;)
      {
        localdus = (dus)getItem(paramInt);
        if (localdus != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.fwQ.setText(localdus.Title);
      paramViewGroup.tPZ.setText(localdus.Fvl);
      paramViewGroup.gAI.setText(localdus.Desc);
      paramViewGroup.gIx.setText(localdus.tLG);
      paramViewGroup.tPY.setVisibility(0);
      paramViewGroup.tPY.setUrl(localdus.GcC);
      if (localdus.DPI == 0) {
        paramViewGroup.tQa.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.tQa.setTag(Integer.valueOf(paramInt));
        paramViewGroup.tQa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            paramAnonymousView = (dus)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (bs.isNullOrNil(paramAnonymousView.ProductID)))
            {
              ac.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            f localf = IPCallPackageUI.b(IPCallPackageUI.this);
            localf.tLa += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).tLe = paramAnonymousView.ProductID;
            h.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(2131760535, new Object[] { paramAnonymousView.Fvl, paramAnonymousView.Title }), IPCallPackageUI.this.getString(2131760536), IPCallPackageUI.this.getString(2131760533), IPCallPackageUI.this.getString(2131760534), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.tLb += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.tLc += 1;
                IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this)).finish();
                AppMethodBeat.o(25844);
              }
            });
            AppMethodBeat.o(25845);
          }
        });
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup.tQa.setEnabled(false);
      }
    }
    
    final class a
    {
      TextView fwQ;
      TextView gAI;
      TextView gIx;
      CdnImageView tPY;
      TextView tPZ;
      Button tQa;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */