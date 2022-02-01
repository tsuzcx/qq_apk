package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.e.e;
import com.tencent.mm.plugin.ipcall.model.e.j;
import com.tencent.mm.plugin.ipcall.model.f.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.gdi;
import com.tencent.mm.protocal.protobuf.gdk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallPackageUI
  extends MMActivity
  implements h
{
  private ListView JNX;
  private TextView JNY;
  private ProgressDialog JNZ;
  private ProgressDialog JOa;
  private a JOb;
  private e JOc;
  private j JOd;
  private f JOe;
  
  public IPCallPackageUI()
  {
    AppMethodBeat.i(25849);
    this.JNX = null;
    this.JNY = null;
    this.JNZ = null;
    this.JOa = null;
    this.JOb = null;
    this.JOc = null;
    this.JOd = null;
    this.JOe = new f();
    AppMethodBeat.o(25849);
  }
  
  private void fSo()
  {
    AppMethodBeat.i(25852);
    Log.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
    if (this.JOb != null)
    {
      this.JOb.ell = null;
      this.JOb.notifyDataSetChanged();
    }
    if (this.JNX != null) {
      this.JNX.setVisibility(8);
    }
    if (this.JNY != null) {
      this.JNY.setVisibility(8);
    }
    fSp();
    this.JOc = new e();
    bh.aZW().a(this.JOc, 0);
    AppMethodBeat.o(25852);
  }
  
  private void fSp()
  {
    AppMethodBeat.i(25853);
    if (this.JNZ == null)
    {
      AppCompatActivity localAppCompatActivity = getContext();
      getString(R.l.app_tip);
      this.JNZ = k.a(localAppCompatActivity, getString(R.l.gKx), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(25840);
          try
          {
            if (IPCallPackageUI.a(IPCallPackageUI.this) != null) {
              bh.aZW().a(IPCallPackageUI.a(IPCallPackageUI.this));
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
    this.JNZ.show();
    AppMethodBeat.o(25853);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gla;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25850);
    super.onCreate(paramBundle);
    bh.aZW().a(831, this);
    bh.aZW().a(277, this);
    this.JOe.start();
    paramBundle = this.JOe;
    paramBundle.JJl += 1;
    this.JOe.finish();
    setMMTitle(R.l.gLB);
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
    this.JNX = ((ListView)findViewById(R.h.fSW));
    this.JOb = new a(this);
    this.JNX.setAdapter(this.JOb);
    this.JNY = ((TextView)findViewById(R.h.fRs));
    fSo();
    AppMethodBeat.o(25850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25851);
    super.onDestroy();
    bh.aZW().b(831, this);
    bh.aZW().b(277, this);
    AppMethodBeat.o(25851);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(25854);
    if ((this.JNZ != null) && (this.JNZ.isShowing())) {
      this.JNZ.dismiss();
    }
    if ((this.JOa != null) && (this.JOa.isShowing())) {
      this.JOa.dismiss();
    }
    if ((paramp instanceof e))
    {
      Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramp).JII;
        if ((paramString != null) && (paramString.aaAY != null) && (paramString.aaAY.size() > 0))
        {
          this.JOb.ell = paramString.aaAY;
          this.JOb.notifyDataSetChanged();
          this.JNX.setVisibility(0);
          AppMethodBeat.o(25854);
          return;
        }
        this.JOb.ell = null;
        this.JOb.notifyDataSetChanged();
        this.JNY.setVisibility(0);
        AppMethodBeat.o(25854);
        return;
      }
      Toast.makeText(getContext(), getString(R.l.gKu), 0).show();
      finish();
      AppMethodBeat.o(25854);
      return;
    }
    if ((paramp instanceof j))
    {
      Log.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
      this.JOe.JJp = paramInt2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.JOe.finish();
        Toast.makeText(getContext(), getString(R.l.gLD), 0).show();
        fSo();
        AppMethodBeat.o(25854);
        return;
      }
      if (paramInt2 == 101)
      {
        Object localObject = this.JOb;
        paramString = (j)paramp;
        if (paramString.JIS != null)
        {
          paramString = paramString.JIS.ProductID;
          if ((Util.isNullOrNil(paramString)) || (((a)localObject).ell == null)) {
            break label450;
          }
          localObject = ((a)localObject).ell.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramp = (gdi)((Iterator)localObject).next();
          } while ((paramp == null) || (!paramp.ProductID.equals(paramString)));
        }
        label450:
        for (paramString = paramp;; paramString = null)
        {
          if (paramString != null) {
            break label455;
          }
          Log.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
          this.JOe.finish();
          Toast.makeText(getContext(), getString(R.l.gLy), 0).show();
          AppMethodBeat.o(25854);
          return;
          paramString = "";
          break;
        }
        label455:
        k.a(getContext(), getContext().getString(R.l.gLz, new Object[] { paramString.ablY, paramString.hAP }), getContext().getString(R.l.gLA), getContext().getString(R.l.gKH), getContext().getString(R.l.gLv), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25841);
            paramAnonymousDialogInterface = IPCallPackageUI.b(IPCallPackageUI.this);
            paramAnonymousDialogInterface.JJr += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            Object localObject = new Intent();
            ((Intent)localObject).setClass(IPCallPackageUI.this.getContext(), IPCallRechargeUI.class);
            paramAnonymousDialogInterface = IPCallPackageUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
            paramAnonymousDialogInterface.JJs += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).finish();
            AppMethodBeat.o(25842);
          }
        });
        AppMethodBeat.o(25854);
        return;
      }
      this.JOe.finish();
      Toast.makeText(getContext(), getString(R.l.gLy), 0).show();
      fSo();
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
    private IPCallPackageUI JOg = null;
    List<gdi> ell = null;
    
    public a(IPCallPackageUI paramIPCallPackageUI)
    {
      this.JOg = paramIPCallPackageUI;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25846);
      if (this.ell == null)
      {
        AppMethodBeat.o(25846);
        return 0;
      }
      int i = this.ell.size();
      AppMethodBeat.o(25846);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25847);
      if (this.ell != null)
      {
        Object localObject = this.ell.get(paramInt);
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
        paramView = ((LayoutInflater)this.JOg.getSystemService("layout_inflater")).inflate(R.i.gkZ, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.JOk = ((CdnImageView)paramView.findViewById(R.h.fSU));
        paramViewGroup.lDF = ((TextView)paramView.findViewById(R.h.fSX));
        paramViewGroup.JOl = ((TextView)paramView.findViewById(R.h.fSY));
        paramViewGroup.noi = ((TextView)paramView.findViewById(R.h.fSR));
        paramViewGroup.descTv = ((TextView)paramView.findViewById(R.h.fSS));
        paramViewGroup.JOm = ((Button)paramView.findViewById(R.h.fSQ));
        paramView.setTag(paramViewGroup);
      }
      gdi localgdi;
      for (;;)
      {
        localgdi = (gdi)getItem(paramInt);
        if (localgdi != null) {
          break;
        }
        AppMethodBeat.o(25848);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.lDF.setText(localgdi.hAP);
      paramViewGroup.JOl.setText(localgdi.ablY);
      paramViewGroup.descTv.setText(localgdi.IGG);
      paramViewGroup.noi.setText(localgdi.IHZ);
      paramViewGroup.JOk.setVisibility(0);
      paramViewGroup.JOk.setUrl(localgdi.acbr);
      if (localgdi.YFu == 0) {
        paramViewGroup.JOm.setEnabled(true);
      }
      for (;;)
      {
        paramViewGroup.JOm.setTag(Integer.valueOf(paramInt));
        paramViewGroup.JOm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(25845);
            Object localObject = new b();
            ((b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
            paramAnonymousView = (gdi)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
            if ((paramAnonymousView == null) || (Util.isNullOrNil(paramAnonymousView.ProductID)))
            {
              Log.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallPackageUI$PackageAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25845);
              return;
            }
            IPCallPackageUI.b(IPCallPackageUI.this).start();
            localObject = IPCallPackageUI.b(IPCallPackageUI.this);
            ((f)localObject).JJm += 1;
            IPCallPackageUI.b(IPCallPackageUI.this).JJq = paramAnonymousView.ProductID;
            k.a(IPCallPackageUI.this, IPCallPackageUI.this.getString(R.l.gLw, new Object[] { paramAnonymousView.ablY, paramAnonymousView.hAP }), IPCallPackageUI.this.getString(R.l.gLx), IPCallPackageUI.this.getString(R.l.gLu), IPCallPackageUI.this.getString(R.l.gLv), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25843);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.JJn += 1;
                IPCallPackageUI.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), paramAnonymousView.ProductID);
                AppMethodBeat.o(25843);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(25844);
                paramAnonymous2DialogInterface = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
                paramAnonymous2DialogInterface.JJo += 1;
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
        paramViewGroup.JOm.setEnabled(false);
      }
    }
    
    final class a
    {
      CdnImageView JOk;
      TextView JOl;
      Button JOm;
      TextView descTv;
      TextView lDF;
      TextView noi;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI
 * JD-Core Version:    0.7.0.1
 */