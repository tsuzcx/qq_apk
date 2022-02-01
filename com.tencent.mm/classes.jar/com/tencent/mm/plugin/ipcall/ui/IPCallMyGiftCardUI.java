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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI
  extends MMActivity
  implements g
{
  private View DR;
  private ProgressDialog ift;
  private ListView mListView;
  private a sHT;
  private com.tencent.mm.plugin.ipcall.model.e.d sHU;
  
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
    az.aeS().a(288, this);
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
        com.tencent.mm.bs.d.b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        AppMethodBeat.o(25829);
        return true;
      }
    });
    this.DR = findViewById(2131301128);
    this.mListView = ((ListView)findViewById(2131301129));
    this.sHT = new a(this);
    this.mListView.setAdapter(this.sHT);
    paramBundle = getContext();
    getString(2131755906);
    this.ift = h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25830);
        try
        {
          if (IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this) != null) {
            az.aeS().a(IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this));
          }
          IPCallMyGiftCardUI.this.finish();
          AppMethodBeat.o(25830);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          ad.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
          AppMethodBeat.o(25830);
        }
      }
    });
    this.sHU = new com.tencent.mm.plugin.ipcall.model.e.d();
    az.aeS().a(this.sHU, 0);
    AppMethodBeat.o(25835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25837);
    super.onDestroy();
    az.aeS().b(288, this);
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
    ad.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.ipcall.model.e.d)paramn).sCM;
        if ((this.ift != null) && (this.ift.isShowing())) {
          this.ift.dismiss();
        }
        this.sHT.cbP = paramString.DAh;
        this.sHT.sHX = paramString;
        this.sHT.notifyDataSetChanged();
        if (paramString.DAh.size() == 0) {
          this.DR.setVisibility(0);
        }
        AppMethodBeat.o(25838);
        return;
      }
      if ((this.ift != null) && (this.ift.isShowing())) {
        this.ift.dismiss();
      }
      this.DR.setVisibility(0);
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
    List<doz> cbP;
    private IPCallMyGiftCardUI sHW;
    bcu sHX;
    
    public a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
    {
      AppMethodBeat.i(25831);
      this.cbP = null;
      this.sHW = null;
      this.sHX = null;
      Assert.assertTrue(true);
      this.sHW = paramIPCallMyGiftCardUI;
      AppMethodBeat.o(25831);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25832);
      if (this.cbP == null)
      {
        AppMethodBeat.o(25832);
        return 0;
      }
      int i = this.cbP.size();
      AppMethodBeat.o(25832);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25833);
      if (this.cbP != null)
      {
        Object localObject = this.cbP.get(paramInt);
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
        paramView = ((LayoutInflater)this.sHW.getSystemService("layout_inflater")).inflate(2131494518, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.sHY = ((TextView)paramView.findViewById(2131298810));
        paramViewGroup.sHZ = ((TextView)paramView.findViewById(2131298927));
        paramViewGroup.sIa = ((TextView)paramView.findViewById(2131299604));
        paramViewGroup.sIb = ((CdnImageView)paramView.findViewById(2131300718));
        paramViewGroup.sIc = ((ImageView)paramView.findViewById(2131298951));
        paramView.setTag(paramViewGroup);
      }
      doz localdoz;
      for (;;)
      {
        localdoz = (doz)getItem(paramInt);
        if (localdoz != null) {
          break;
        }
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      if (bt.isNullOrNil(localdoz.EFo))
      {
        paramViewGroup.sHY.setVisibility(0);
        paramViewGroup.sHZ.setVisibility(0);
        paramViewGroup.sIa.setVisibility(8);
        paramViewGroup.sHY.setText(localdoz.DYr);
        paramViewGroup.sHZ.setText(localdoz.EFn);
        a.b.a(paramViewGroup.sIc, "", 0.5F, false);
        if (bt.isNullOrNil(localdoz.sah)) {
          break label304;
        }
        paramViewGroup.sIb.setVisibility(0);
        paramViewGroup.sIb.setUrl(localdoz.sah);
        paramViewGroup.sIc.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup.sHY.setVisibility(8);
        paramViewGroup.sHZ.setVisibility(8);
        paramViewGroup.sIa.setVisibility(0);
        paramViewGroup.sIa.setText(localdoz.EFo);
        break;
        label304:
        paramViewGroup.sIc.setVisibility(0);
        paramViewGroup.sIb.setVisibility(4);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView sHY;
      TextView sHZ;
      TextView sIa;
      CdnImageView sIb;
      ImageView sIc;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI
 * JD-Core Version:    0.7.0.1
 */