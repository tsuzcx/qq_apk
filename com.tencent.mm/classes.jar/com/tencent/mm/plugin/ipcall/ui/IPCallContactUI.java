package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.q;
import java.util.ArrayList;
import java.util.HashMap;

public class IPCallContactUI
  extends MMActivity
{
  private q eiV;
  private ak faV;
  private String gvZ;
  private ListView nRL;
  private Runnable nRS;
  private ProgressDialog nSa;
  private c nSb;
  private RelativeLayout nSc;
  private LinearLayout nSd;
  private IPCallAddressCountView nSe;
  private VerticalScrollBar nSf;
  private LinearLayout nSg;
  private int nSh;
  private int nSi;
  private a.a nSj;
  private Runnable nSk;
  private boolean nSl;
  
  public IPCallContactUI()
  {
    AppMethodBeat.i(22088);
    this.eiV = new q((byte)0);
    this.nSa = null;
    this.nSe = null;
    this.nSh = -1;
    this.nSi = -1;
    this.nSj = new IPCallContactUI.7(this);
    this.nRS = new IPCallContactUI.8(this);
    this.nSk = new IPCallContactUI.10(this);
    this.nSl = true;
    this.faV = new IPCallContactUI.2(this, Looper.getMainLooper());
    AppMethodBeat.o(22088);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969923;
  }
  
  public final void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(22091);
    this.nSl = paramBoolean;
    if (this.nSl) {
      this.nSb.notifyDataSetChanged();
    }
    AppMethodBeat.o(22091);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(22095);
    super.onBackPressed();
    AppMethodBeat.o(22095);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22089);
    super.onCreate(paramBundle);
    setMMTitle(2131300825);
    setBackBtn(new IPCallContactUI.1(this));
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ab.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (bool)
    {
      this.nSc = ((RelativeLayout)findViewById(2131824370));
      this.nSd = ((LinearLayout)findViewById(2131825167));
      this.nRL = ((ListView)findViewById(2131825168));
      this.nSf = ((VerticalScrollBar)findViewById(2131821077));
      this.nSg = ((LinearLayout)findViewById(2131825169));
      this.eiV.Axg = new IPCallContactUI.5(this);
      this.eiV.Axl = 2131297065;
      addSearchMenu(true, this.eiV);
      this.nSb = new c(getContext());
      c.nQb = com.tencent.mm.plugin.ipcall.a.g.b.bJS();
      this.nSe = new IPCallAddressCountView(getContext(), this.nSb.bKa());
      this.nRL.addFooterView(this.nSe, null, false);
      this.nRL.setAdapter(this.nSb);
      this.nRL.setOnItemClickListener(new IPCallContactUI.6(this));
      this.nSf.setVisibility(0);
      this.nRL.setOnScrollListener(new IPCallContactUI.11(this));
      this.nSf.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void lf(String paramAnonymousString)
        {
          AppMethodBeat.i(22087);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
            AppMethodBeat.o(22087);
            return;
          }
          c localc = IPCallContactUI.d(IPCallContactUI.this);
          if (localc.ejN.containsKey(paramAnonymousString)) {}
          for (int i = ((Integer)localc.ejN.get(paramAnonymousString)).intValue();; i = -1)
          {
            if (i != -1) {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
            }
            AppMethodBeat.o(22087);
            return;
          }
        }
      });
      if (this.nSb.bKa() <= 0)
      {
        this.nSc.setVisibility(8);
        paramBundle = getContext();
        getContext().getString(2131297087);
        this.nSa = h.b(paramBundle, getContext().getString(2131300846), true, new IPCallContactUI.9(this));
        d.post(this.nRS, "IPCall_LoadSystemAddressBook");
        AppMethodBeat.o(22089);
        return;
      }
      com.tencent.mm.plugin.ipcall.a.bID().bIE();
    }
    AppMethodBeat.o(22089);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(22094);
    ab.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(22094);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22092);
    super.onDestroy();
    com.tencent.mm.plugin.ipcall.a.a locala = com.tencent.mm.plugin.ipcall.a.a.bIY();
    a.a locala1 = this.nSj;
    if (locala.nLP.contains(locala1)) {
      locala.nLP.remove(locala1);
    }
    this.faV.removeMessages(1);
    AppMethodBeat.o(22092);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(22096);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(22096);
      return;
    }
    ab.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22096);
      return;
      if (paramArrayOfInt[0] != 0) {
        h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131297837), false, new IPCallContactUI.3(this), new IPCallContactUI.4(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22093);
    super.onResume();
    supportInvalidateOptionsMenu();
    AppMethodBeat.o(22093);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(22090);
    this.gvZ = paramString;
    this.faV.removeCallbacks(this.nSk);
    this.faV.postDelayed(this.nSk, 200L);
    AppMethodBeat.o(22090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI
 * JD-Core Version:    0.7.0.1
 */