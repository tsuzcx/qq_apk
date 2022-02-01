package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI
  extends MMActivity
  implements f
{
  private View GG;
  private ProgressDialog jbE;
  private ListView mListView;
  private a vdZ;
  private com.tencent.mm.plugin.ipcall.model.e.d vea;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494519;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25835);
    super.onCreate(paramBundle);
    bc.ajj().a(288, this);
    setMMTitle(2131760528);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25828);
        IPCallMyGiftCardUI.this.finish();
        AppMethodBeat.o(25828);
        return true;
      }
    });
    addTextOptionMenu(0, getContext().getString(2131760526), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25829);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("rawUrl", IPCallMyGiftCardUI.this.getString(2131760445));
        paramAnonymousMenuItem.putExtra("showShare", false);
        com.tencent.mm.br.d.b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        AppMethodBeat.o(25829);
        return true;
      }
    });
    this.GG = findViewById(2131301128);
    this.mListView = ((ListView)findViewById(2131301129));
    this.vdZ = new a(this);
    this.mListView.setAdapter(this.vdZ);
    paramBundle = getContext();
    getString(2131755906);
    this.jbE = h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25830);
        try
        {
          if (IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this) != null) {
            bc.ajj().a(IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this));
          }
          IPCallMyGiftCardUI.this.finish();
          AppMethodBeat.o(25830);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          ae.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
          AppMethodBeat.o(25830);
        }
      }
    });
    this.vea = new com.tencent.mm.plugin.ipcall.model.e.d();
    bc.ajj().a(this.vea, 0);
    AppMethodBeat.o(25835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25837);
    super.onDestroy();
    bc.ajj().b(288, this);
    AppMethodBeat.o(25837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25836);
    super.onResume();
    AppMethodBeat.o(25836);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25838);
    ae.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.ipcall.model.e.d)paramn).uYU;
        if ((this.jbE != null) && (this.jbE.isShowing())) {
          this.jbE.dismiss();
        }
        this.vdZ.cjg = paramString.GYD;
        this.vdZ.ved = paramString;
        this.vdZ.notifyDataSetChanged();
        if (paramString.GYD.size() == 0) {
          this.GG.setVisibility(0);
        }
        AppMethodBeat.o(25838);
        return;
      }
      if ((this.jbE != null) && (this.jbE.isShowing())) {
        this.jbE.dismiss();
      }
      this.GG.setVisibility(0);
      Toast.makeText(getContext(), getString(2131760454), 0).show();
    }
    AppMethodBeat.o(25838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    List<ecb> cjg;
    private IPCallMyGiftCardUI vec;
    blm ved;
    
    public a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
    {
      AppMethodBeat.i(25831);
      this.cjg = null;
      this.vec = null;
      this.ved = null;
      Assert.assertTrue(true);
      this.vec = paramIPCallMyGiftCardUI;
      AppMethodBeat.o(25831);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25832);
      if (this.cjg == null)
      {
        AppMethodBeat.o(25832);
        return 0;
      }
      int i = this.cjg.size();
      AppMethodBeat.o(25832);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25833);
      if (this.cjg != null)
      {
        Object localObject = this.cjg.get(paramInt);
        AppMethodBeat.o(25833);
        return localObject;
      }
      AppMethodBeat.o(25833);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25834);
      if (paramView == null)
      {
        paramView = ((LayoutInflater)this.vec.getSystemService("layout_inflater")).inflate(2131494518, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.vee = ((TextView)paramView.findViewById(2131298810));
        paramViewGroup.vef = ((TextView)paramView.findViewById(2131298927));
        paramViewGroup.veg = ((TextView)paramView.findViewById(2131299604));
        paramViewGroup.veh = ((CdnImageView)paramView.findViewById(2131300718));
        paramViewGroup.vei = ((ImageView)paramView.findViewById(2131298951));
        paramView.setTag(paramViewGroup);
      }
      ecb localecb;
      for (;;)
      {
        localecb = (ecb)getItem(paramInt);
        if (localecb != null) {
          break;
        }
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      if (bu.isNullOrNil(localecb.IhE))
      {
        paramViewGroup.vee.setVisibility(0);
        paramViewGroup.vef.setVisibility(0);
        paramViewGroup.veg.setVisibility(8);
        paramViewGroup.vee.setText(localecb.HyQ);
        paramViewGroup.vef.setText(localecb.IhD);
        a.b.a(paramViewGroup.vei, "", 0.5F, false);
        if (bu.isNullOrNil(localecb.urn)) {
          break label304;
        }
        paramViewGroup.veh.setVisibility(0);
        paramViewGroup.veh.setUrl(localecb.urn);
        paramViewGroup.vei.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup.vee.setVisibility(8);
        paramViewGroup.vef.setVisibility(8);
        paramViewGroup.veg.setVisibility(0);
        paramViewGroup.veg.setText(localecb.IhE);
        break;
        label304:
        paramViewGroup.vei.setVisibility(0);
        paramViewGroup.veh.setVisibility(4);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView vee;
      TextView vef;
      TextView veg;
      CdnImageView veh;
      ImageView vei;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI
 * JD-Core Version:    0.7.0.1
 */