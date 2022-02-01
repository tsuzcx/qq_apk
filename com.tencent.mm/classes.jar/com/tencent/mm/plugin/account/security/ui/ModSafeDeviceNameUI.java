package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.model.c;
import com.tencent.mm.plugin.account.security.model.d;
import com.tencent.mm.plugin.account.security.model.e;
import com.tencent.mm.plugin.account.security.model.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ModSafeDeviceNameUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private long createTime;
  private String hEr;
  private ProgressDialog lzP = null;
  private EditText pXU;
  private String pXV;
  private String pXW;
  private String pXX;
  
  public int getLayoutId()
  {
    return a.b.mod_safe_device_name;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125552);
    this.pXV = getIntent().getStringExtra("safe_device_name");
    this.pXX = getIntent().getStringExtra("safe_device_uid");
    this.hEr = getIntent().getStringExtra("safe_device_type");
    setMMTitle(com.tencent.mm.cd.a.bt(this, a.d.safe_device_edit_title));
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
    addTextOptionMenu(0, getString(a.d.app_save), new MenuItem.OnMenuItemClickListener()
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
        com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem, 0);
        ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this, k.a(ModSafeDeviceNameUI.this, com.tencent.mm.cd.a.bt(ModSafeDeviceNameUI.this, a.d.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125545);
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem);
            AppMethodBeat.o(125545);
          }
        }));
        AppMethodBeat.o(125546);
        return true;
      }
    });
    MMEditText.b local3 = new MMEditText.b()
    {
      public final void bXT()
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
    this.pXU = ((EditText)findViewById(a.a.mod_safe_device_name));
    MMEditText.c localc = new MMEditText.c(this.pXU, null, 32);
    localc.afTl = local3;
    this.pXU.addTextChangedListener(localc);
    if (!Util.isNullOrNil(this.pXV))
    {
      this.pXU.setText(this.pXV);
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
    com.tencent.mm.kernel.h.aZW().b(361, this);
    super.onPause();
    AppMethodBeat.o(125551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125550);
    com.tencent.mm.kernel.h.aZW().a(361, this);
    super.onResume();
    AppMethodBeat.o(125550);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(125553);
    if ((this.lzP != null) && (this.lzP.isShowing()))
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new d();
      paramString.field_devicetype = this.hEr;
      paramString.field_name = this.pXW;
      paramString.field_uid = this.pXX;
      paramString.field_createtime = this.createTime;
      g.bXS().update(paramString, new String[0]);
      k.cZ(this, com.tencent.mm.cd.a.bt(this, a.d.safe_device_mod_name_ok));
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
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI
 * JD-Core Version:    0.7.0.1
 */