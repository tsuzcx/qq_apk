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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.plugin.ipcall.model.f.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.ewk;
import com.tencent.mm.protocal.protobuf.ewm;
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
  private ListView ywK;
  private TextView ywL;
  private ProgressDialog ywM;
  private ProgressDialog ywN;
  private a ywO;
  private e ywP;
  private j ywQ;
  private f ywR;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.ywK = null;
    this.ywL = null;
    this.ywM = null;
    this.ywN = null;
    this.ywO = null;
    this.ywP = null;
    this.ywQ = null;
    this.ywR = new f();
    AppMethodBeat.o(25849);
  }
  
  private void ebq()
  {
    AppMethodBeat.i(25852);
    Log.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.ywO != null)
    {
      this.ywO.cvc = null;
      this.ywO.notifyDataSetChanged();
    }
    if (this.ywK != null) {
      this.ywK.setVisibility(8);
    }
    if (this.ywL != null) {
      this.ywL.setVisibility(8);
    }
    ebr();
    this.ywP = new e();
    bg.azz().a(this.ywP, 0);
    AppMethodBeat.o(25852);
  }
  
  private void ebr()
  {
    AppMethodBeat.i(25853);
    if (this.ywM == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.ywM = h.a(localAppCompatActivity, getString(2131761902), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              bg.azz().a(IPCallPackageUI.a(IPCallPackageUI.this));
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
    this.ywM.show();
    AppMethodBeat.o(25853);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495113;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25850);
    super.onCreate(paramBundle);
    bg.azz().a(831, this);
    bg.azz().a(277, this);
    this.ywR.start();
    paramBundle = this.ywR;
    paramBundle.yrZ += 1;
    this.ywR.finish();
    setMMTitle(2131761986);
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
    this.ywK = ((ListView)findViewById(2131305762));
    this.ywO = new a(this);
    this.ywK.setAdapter(this.ywO);
    this.ywL = ((TextView)findViewById(2131305455));
    ebq();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    bg.azz().b(831, this);
    bg.azz().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25854);
    if ((this.ywM != null) && (this.ywM.isShowing())) {
      this.ywM.dismiss();
    }
    if ((this.ywN != null) && (this.ywN.isShowing())) {
      this.ywN.dismiss();
    }
    if ((paramq instanceof e))
    {
      Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramq).yrw;
        if ((paramString != null) && (paramString.Mdr != null) && (paramString.Mdr.size() > 0))
        {
          this.ywO.cvc = paramString.Mdr;
          this.ywO.notifyDataSetChanged();
          this.ywK.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.ywO.cvc = null;
        this.ywO.notifyDataSetChanged();
        this.ywL.setVisibility(0);
        AppMethodBeat.o(25854);
        return;
      }
      Toast.makeText(getContext(), getString(2131761899), 0).show();
      finish();
      AppMethodBeat.o(25854);
      return;
    }
    if ((paramq instanceof j))
    {
      Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.ywR.ysd = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.ywR.finish();
        Toast.makeText(getContext(), getString(2131761988), 0).show();
        ebq();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.ywO;
        paramString = (j)paramq;
        if (paramString.yrG != null)
        {
          paramString = paramString.yrG.ProductID;
          if ((Util.isNullOrNil(paramString)) || (((a)localObject).cvc == null)) {
            break label447;
          }
          localObject = ((a)localObject).cvc.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramq = (ewk)((Iterator)localObject).next();
          } while ((paramq == null) || (!paramq.ProductID.equals(paramString)));
        }
        label447:
        for (paramString = paramq;; paramString = null)
        {
          if (paramString != null) {
            break label452;
          }
          Log.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.ywR.finish();
          Toast.makeText(getContext(), getString(2131761982), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label452:
        h.a(getContext(), getContext().getString(2131761984, new Object[] { paramString.MJz, paramString.Title }), getContext().getString(2131761985), getContext().getString(2131761920), getContext().getString(2131761979), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.ysf += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
            paramAnonymousDialogInterface.ysg += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.ywR.finish();
      Toast.makeText(getContext(), getString(2131761982), 0).show();
      ebq();
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
    List<ewk> cvc = null;
    private IPCallPackageUI ywT = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.ywT = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.cvc == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.cvc.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.cvc != null)
      {
        Object localObject = this.cvc.get(paramInt);
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
        paramView = ((LayoutInflater)this.ywT.getSystemService("layout_inflater")).inflate(2131495112, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.ywX = ((CdnImageView)paramView.findViewById(2131305759));
        paramViewGroup.gxs = ((TextView)paramView.findViewById(2131305763));
        paramViewGroup.ywY = ((TextView)paramView.findViewById(2131305764));
        paramViewGroup.hXK = ((TextView)paramView.findViewById(2131305754));
        paramViewGroup.hPW = ((TextView)paramView.findViewById(2131305755));
        paramViewGroup.ywZ = ((Button)paramView.findViewById(2131305753));
        paramView.setTag(paramViewGroup);
      }
      ewk localewk;
      for (;;)
      {
        localewk = (ewk)getItem(paramInt);
        if (localewk != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.gxs.setText(localewk.Title);
      paramViewGroup.ywY.setText(localewk.MJz);
      paramViewGroup.hPW.setText(localewk.Desc);
      paramViewGroup.hXK.setText(localewk.xJH);
      paramViewGroup.ywX.setVisibility(0);
      paramViewGroup.ywX.setUrl(localewk.Nuh);
      if (localewk.KHa == 0) {
        paramViewGroup.ywZ.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.ywZ.setTag(Integer.valueOf(paramInt));
        paramViewGroup.ywZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
            paramAnonymousView = (ewk)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (Util.isNullOrNil(paramAnonymousView.ProductID)))
            {
              Log.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            localObject = IPCallPackageUI.b(IPCallPackageUI.this);
            ((f)localObject).ysa += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).yse = paramAnonymousView.ProductID;
            h.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(2131761980, new Object[] { paramAnonymousView.MJz, paramAnonymousView.Title }), IPCallPackageUI.this.getString(2131761981), IPCallPackageUI.this.getString(2131761978), IPCallPackageUI.this.getString(2131761979), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.ysb += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.ysc += 1;
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
        paramViewGroup.ywZ.setEnabled(false);
      }
    }
    
    final class a
    {
      TextView gxs;
      TextView hPW;
      TextView hXK;
      CdnImageView ywX;
      TextView ywY;
      Button ywZ;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */