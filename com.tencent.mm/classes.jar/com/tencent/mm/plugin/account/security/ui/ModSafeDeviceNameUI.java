package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ModSafeDeviceNameUI
  extends MMActivity
  implements i
{
  private long createTime;
  private String dGP;
  private ProgressDialog gtM = null;
  private EditText kiW;
  private String kiX;
  private String kiY;
  private String kiZ;
  
  public int getLayoutId()
  {
    return 2131495682;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125552);
    this.kiX = getIntent().getStringExtra("safe_device_name");
    this.kiZ = getIntent().getStringExtra("safe_device_uid");
    this.dGP = getIntent().getStringExtra("safe_device_type");
    setMMTitle(com.tencent.mm.cb.a.aI(this, 2131764844));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125544);
        ModSafeDeviceNameUI.this.finish();
        AppMethodBeat.o(125544);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125546);
        ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this, ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this).getText().toString());
        if (Util.isNullOrNil(ModSafeDeviceNameUI.b(ModSafeDeviceNameUI.this)))
        {
          AppMethodBeat.o(125546);
          return true;
        }
        ModSafeDeviceNameUI.this.hideVKB();
        paramAnonymousMenuItem = new c(ModSafeDeviceNameUI.c(ModSafeDeviceNameUI.this), ModSafeDeviceNameUI.b(ModSafeDeviceNameUI.this), ModSafeDeviceNameUI.d(ModSafeDeviceNameUI.this));
        com.tencent.mm.kernel.g.azz().a(paramAnonymousMenuItem, 0);
        ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this, h.a(ModSafeDeviceNameUI.this, com.tencent.mm.cb.a.aI(ModSafeDeviceNameUI.this, 2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125545);
            com.tencent.mm.kernel.g.azz().a(paramAnonymousMenuItem);
            AppMethodBeat.o(125545);
          }
        }));
        AppMethodBeat.o(125546);
        return true;
      }
    });
    MMEditText.b local3 = new MMEditText.b()
    {
      public final void boS()
      {
        AppMethodBeat.i(125547);
        if (ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this).getText().toString().trim().length() > 0)
        {
          ModSafeDeviceNameUI.this.enableOptionMenu(true);
          AppMethodBeat.o(125547);
          return;
        }
        ModSafeDeviceNameUI.this.enableOptionMenu(false);
        AppMethodBeat.o(125547);
      }
    };
    this.kiW = ((EditText)findViewById(2131304820));
    MMEditText.c localc = new MMEditText.c(this.kiW, null, 32);
    localc.QCQ = local3;
    this.kiW.addTextChangedListener(localc);
    if (!Util.isNullOrNil(this.kiX))
    {
      this.kiW.setText(this.kiX);
      AppMethodBeat.o(125552);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(125552);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125549);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(125549);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125551);
    com.tencent.mm.kernel.g.azz().b(361, this);
    super.onPause();
    AppMethodBeat.o(125551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125550);
    com.tencent.mm.kernel.g.azz().a(361, this);
    super.onResume();
    AppMethodBeat.o(125550);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125553);
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new d();
      paramString.field_devicetype = this.dGP;
      paramString.field_name = this.kiY;
      paramString.field_uid = this.kiZ;
      paramString.field_createtime = this.createTime;
      com.tencent.mm.plugin.account.security.a.g.boR().update(paramString, new String[0]);
      h.cD(this, com.tencent.mm.cb.a.aI(this, 2131764848));
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(125548);
          ModSafeDeviceNameUI.this.finish();
          AppMethodBeat.o(125548);
        }
      }, 1000L);
      AppMethodBeat.o(125553);
      return;
    }
    if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125553);
      return;
    }
    AppMethodBeat.o(125553);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI
 * JD-Core Version:    0.7.0.1
 */