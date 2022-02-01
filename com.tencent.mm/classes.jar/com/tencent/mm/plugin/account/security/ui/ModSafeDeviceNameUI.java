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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.security.a.c;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.e;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.ui.widget.MMEditText.c;

public class ModSafeDeviceNameUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private long createTime;
  private String dda;
  private ProgressDialog fts = null;
  private EditText iOR;
  private String iOS;
  private String iOT;
  private String iOU;
  
  public int getLayoutId()
  {
    return 2131494940;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125552);
    this.iOS = getIntent().getStringExtra("safe_device_name");
    this.iOU = getIntent().getStringExtra("safe_device_uid");
    this.dda = getIntent().getStringExtra("safe_device_type");
    setMMTitle(com.tencent.mm.cc.a.aw(this, 2131762759));
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
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125546);
        ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this, ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this).getText().toString());
        if (bs.isNullOrNil(ModSafeDeviceNameUI.b(ModSafeDeviceNameUI.this)))
        {
          AppMethodBeat.o(125546);
          return true;
        }
        ModSafeDeviceNameUI.this.hideVKB();
        paramAnonymousMenuItem = new c(ModSafeDeviceNameUI.c(ModSafeDeviceNameUI.this), ModSafeDeviceNameUI.b(ModSafeDeviceNameUI.this), ModSafeDeviceNameUI.d(ModSafeDeviceNameUI.this));
        com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem, 0);
        ModSafeDeviceNameUI.a(ModSafeDeviceNameUI.this, h.b(ModSafeDeviceNameUI.this, com.tencent.mm.cc.a.aw(ModSafeDeviceNameUI.this, 2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125545);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem);
            AppMethodBeat.o(125545);
          }
        }));
        AppMethodBeat.o(125546);
        return true;
      }
    });
    MMEditText.b local3 = new MMEditText.b()
    {
      public final void aQv()
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
    this.iOR = ((EditText)findViewById(2131302423));
    MMEditText.c localc = new MMEditText.c(this.iOR, null, 32);
    localc.IZW = local3;
    this.iOR.addTextChangedListener(localc);
    if (!bs.isNullOrNil(this.iOS))
    {
      this.iOR.setText(this.iOS);
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
    com.tencent.mm.kernel.g.agi().b(361, this);
    super.onPause();
    AppMethodBeat.o(125551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125550);
    com.tencent.mm.kernel.g.agi().a(361, this);
    super.onResume();
    AppMethodBeat.o(125550);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125553);
    if ((this.fts != null) && (this.fts.isShowing()))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = new d();
      paramString.field_devicetype = this.dda;
      paramString.field_name = this.iOT;
      paramString.field_uid = this.iOU;
      paramString.field_createtime = this.createTime;
      com.tencent.mm.plugin.account.security.a.g.aQu().update(paramString, new String[0]);
      h.cg(this, com.tencent.mm.cc.a.aw(this, 2131762763));
      new ao().postDelayed(new Runnable()
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
    if (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.ModSafeDeviceNameUI
 * JD-Core Version:    0.7.0.1
 */