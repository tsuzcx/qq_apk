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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI
  extends MMActivity
  implements g
{
  private View EP;
  private ProgressDialog iFC;
  private ListView mListView;
  private a tPA;
  private com.tencent.mm.plugin.ipcall.model.e.d tPB;
  
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
    az.agi().a(288, this);
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
    this.EP = findViewById(2131301128);
    this.mListView = ((ListView)findViewById(2131301129));
    this.tPA = new a(this);
    this.mListView.setAdapter(this.tPA);
    paramBundle = getContext();
    getString(2131755906);
    this.iFC = h.b(paramBundle, getString(2131760457), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25830);
        try
        {
          if (IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this) != null) {
            az.agi().a(IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this));
          }
          IPCallMyGiftCardUI.this.finish();
          AppMethodBeat.o(25830);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          ac.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
          AppMethodBeat.o(25830);
        }
      }
    });
    this.tPB = new com.tencent.mm.plugin.ipcall.model.e.d();
    az.agi().a(this.tPB, 0);
    AppMethodBeat.o(25835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25837);
    super.onDestroy();
    az.agi().b(288, this);
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
    ac.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.ipcall.model.e.d)paramn).tKu;
        if ((this.iFC != null) && (this.iFC.isShowing())) {
          this.iFC.dismiss();
        }
        this.tPA.bYM = paramString.EVD;
        this.tPA.tPE = paramString;
        this.tPA.notifyDataSetChanged();
        if (paramString.EVD.size() == 0) {
          this.EP.setVisibility(0);
        }
        AppMethodBeat.o(25838);
        return;
      }
      if ((this.iFC != null) && (this.iFC.isShowing())) {
        this.iFC.dismiss();
      }
      this.EP.setVisibility(0);
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
    List<duq> bYM;
    private IPCallMyGiftCardUI tPD;
    bgm tPE;
    
    public a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
    {
      AppMethodBeat.i(25831);
      this.bYM = null;
      this.tPD = null;
      this.tPE = null;
      Assert.assertTrue(true);
      this.tPD = paramIPCallMyGiftCardUI;
      AppMethodBeat.o(25831);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25832);
      if (this.bYM == null)
      {
        AppMethodBeat.o(25832);
        return 0;
      }
      int i = this.bYM.size();
      AppMethodBeat.o(25832);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25833);
      if (this.bYM != null)
      {
        Object localObject = this.bYM.get(paramInt);
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
        paramView = ((LayoutInflater)this.tPD.getSystemService("layout_inflater")).inflate(2131494518, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.tPF = ((TextView)paramView.findViewById(2131298810));
        paramViewGroup.tPG = ((TextView)paramView.findViewById(2131298927));
        paramViewGroup.tPH = ((TextView)paramView.findViewById(2131299604));
        paramViewGroup.tPI = ((CdnImageView)paramView.findViewById(2131300718));
        paramViewGroup.tPJ = ((ImageView)paramView.findViewById(2131298951));
        paramView.setTag(paramViewGroup);
      }
      duq localduq;
      for (;;)
      {
        localduq = (duq)getItem(paramInt);
        if (localduq != null) {
          break;
        }
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      if (bs.isNullOrNil(localduq.GcA))
      {
        paramViewGroup.tPF.setVisibility(0);
        paramViewGroup.tPG.setVisibility(0);
        paramViewGroup.tPH.setVisibility(8);
        paramViewGroup.tPF.setText(localduq.Fvl);
        paramViewGroup.tPG.setText(localduq.Gcz);
        a.b.a(paramViewGroup.tPJ, "", 0.5F, false);
        if (bs.isNullOrNil(localduq.tia)) {
          break label304;
        }
        paramViewGroup.tPI.setVisibility(0);
        paramViewGroup.tPI.setUrl(localduq.tia);
        paramViewGroup.tPJ.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup.tPF.setVisibility(8);
        paramViewGroup.tPG.setVisibility(8);
        paramViewGroup.tPH.setVisibility(0);
        paramViewGroup.tPH.setText(localduq.GcA);
        break;
        label304:
        paramViewGroup.tPJ.setVisibility(0);
        paramViewGroup.tPI.setVisibility(4);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView tPF;
      TextView tPG;
      TextView tPH;
      CdnImageView tPI;
      ImageView tPJ;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI
 * JD-Core Version:    0.7.0.1
 */