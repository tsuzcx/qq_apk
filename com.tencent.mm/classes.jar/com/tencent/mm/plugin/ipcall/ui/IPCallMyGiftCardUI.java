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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.e.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.ewi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI
  extends MMActivity
  implements i
{
  private View GQ;
  private ProgressDialog jZH;
  private ListView mListView;
  private d ywA;
  private a ywz;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495111;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25835);
    super.onCreate(paramBundle);
    bg.azz().a(288, this);
    setMMTitle(2131761973);
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
    addTextOptionMenu(0, getContext().getString(2131761971), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25829);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("rawUrl", IPCallMyGiftCardUI.this.getString(2131761890));
        paramAnonymousMenuItem.putExtra("showShare", false);
        c.b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem);
        AppMethodBeat.o(25829);
        return true;
      }
    });
    this.GQ = findViewById(2131302782);
    this.mListView = ((ListView)findViewById(2131302783));
    this.ywz = new a(this);
    this.mListView.setAdapter(this.ywz);
    paramBundle = getContext();
    getString(2131755998);
    this.jZH = h.a(paramBundle, getString(2131761902), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(25830);
        try
        {
          if (IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this) != null) {
            bg.azz().a(IPCallMyGiftCardUI.a(IPCallMyGiftCardUI.this));
          }
          IPCallMyGiftCardUI.this.finish();
          AppMethodBeat.o(25830);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          Log.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[] { paramAnonymousDialogInterface.getMessage() });
          AppMethodBeat.o(25830);
        }
      }
    });
    this.ywA = new d();
    bg.azz().a(this.ywA, 0);
    AppMethodBeat.o(25835);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25837);
    super.onDestroy();
    bg.azz().b(288, this);
    AppMethodBeat.o(25837);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25836);
    super.onResume();
    AppMethodBeat.o(25836);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25838);
    Log.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((d)paramq).yru;
        if ((this.jZH != null) && (this.jZH.isShowing())) {
          this.jZH.dismiss();
        }
        this.ywz.cvc = paramString.Mdt;
        this.ywz.ywD = paramString;
        this.ywz.notifyDataSetChanged();
        if (paramString.Mdt.size() == 0) {
          this.GQ.setVisibility(0);
        }
        AppMethodBeat.o(25838);
        return;
      }
      if ((this.jZH != null) && (this.jZH.isShowing())) {
        this.jZH.dismiss();
      }
      this.GQ.setVisibility(0);
      Toast.makeText(getContext(), getString(2131761899), 0).show();
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
    List<ewi> cvc;
    private IPCallMyGiftCardUI ywC;
    bxv ywD;
    
    public a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
    {
      AppMethodBeat.i(25831);
      this.cvc = null;
      this.ywC = null;
      this.ywD = null;
      Assert.assertTrue(true);
      this.ywC = paramIPCallMyGiftCardUI;
      AppMethodBeat.o(25831);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(25832);
      if (this.cvc == null)
      {
        AppMethodBeat.o(25832);
        return 0;
      }
      int i = this.cvc.size();
      AppMethodBeat.o(25832);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(25833);
      if (this.cvc != null)
      {
        Object localObject = this.cvc.get(paramInt);
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
        paramView = ((LayoutInflater)this.ywC.getSystemService("layout_inflater")).inflate(2131495110, paramViewGroup, false);
        paramViewGroup = new a((byte)0);
        paramViewGroup.ywE = ((TextView)paramView.findViewById(2131299274));
        paramViewGroup.ywF = ((TextView)paramView.findViewById(2131299411));
        paramViewGroup.ywG = ((TextView)paramView.findViewById(2131300236));
        paramViewGroup.ywH = ((CdnImageView)paramView.findViewById(2131302292));
        paramViewGroup.ywI = ((ImageView)paramView.findViewById(2131299443));
        paramView.setTag(paramViewGroup);
      }
      ewi localewi;
      for (;;)
      {
        localewi = (ewi)getItem(paramInt);
        if (localewi != null) {
          break;
        }
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      if (Util.isNullOrNil(localewi.Nuf))
      {
        paramViewGroup.ywE.setVisibility(0);
        paramViewGroup.ywF.setVisibility(0);
        paramViewGroup.ywG.setVisibility(8);
        paramViewGroup.ywE.setText(localewi.MJz);
        paramViewGroup.ywF.setText(localewi.Nue);
        a.b.a(paramViewGroup.ywI, "", 0.5F, false);
        if (Util.isNullOrNil(localewi.xJE)) {
          break label304;
        }
        paramViewGroup.ywH.setVisibility(0);
        paramViewGroup.ywH.setUrl(localewi.xJE);
        paramViewGroup.ywI.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(25834);
        return paramView;
        paramViewGroup.ywE.setVisibility(8);
        paramViewGroup.ywF.setVisibility(8);
        paramViewGroup.ywG.setVisibility(0);
        paramViewGroup.ywG.setText(localewi.Nuf);
        break;
        label304:
        paramViewGroup.ywI.setVisibility(0);
        paramViewGroup.ywH.setVisibility(4);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    final class a
    {
      TextView ywE;
      TextView ywF;
      TextView ywG;
      CdnImageView ywH;
      ImageView ywI;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI
 * JD-Core Version:    0.7.0.1
 */