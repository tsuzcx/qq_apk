package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactAddUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog fts;
  private String fwd;
  private String iHJ;
  private int iHK;
  private String iHQ;
  private ListView iIZ;
  private i iMh;
  private View iMi;
  private TextView iMj;
  private TextView iMk;
  private TextView iMl;
  private TextView iMm;
  private Button iMn;
  private int iMo;
  private List<String[]> iMp;
  private boolean iMq;
  private i.a iMr;
  private com.tencent.mm.ak.g onSceneEndCallback;
  
  public FindMContactAddUI()
  {
    AppMethodBeat.i(131187);
    this.fts = null;
    this.emptyTipTv = null;
    this.iMj = null;
    this.iMk = null;
    this.iMl = null;
    this.iMm = null;
    this.iMn = null;
    this.fwd = null;
    this.onSceneEndCallback = null;
    this.iHJ = "";
    this.iHK = 2;
    this.iMq = true;
    this.iMr = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131181);
        if ((FindMContactAddUI.e(FindMContactAddUI.this) != 2) && (FindMContactAddUI.e(FindMContactAddUI.this) == 1))
        {
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759111));
          if (!FindMContactAddUI.c(FindMContactAddUI.this).aPy()) {
            break label240;
          }
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 0) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount() <= 0) || (FindMContactAddUI.e(FindMContactAddUI.this) == 1)) {
            break label302;
          }
          FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(2131623941, FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getSelectCount()) }));
          AppMethodBeat.o(131181);
          return;
          FindMContactAddUI.f(FindMContactAddUI.this).setText(FindMContactAddUI.this.getString(2131759110, new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
          break;
          label240:
          if ((FindMContactAddUI.e(FindMContactAddUI.this) != 1) && (FindMContactAddUI.f(FindMContactAddUI.this).getVisibility() == 8) && (FindMContactAddUI.g(FindMContactAddUI.this) != null))
          {
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
          }
        }
        label302:
        FindMContactAddUI.h(FindMContactAddUI.this).setText(FindMContactAddUI.this.getResources().getQuantityString(2131623944, FindMContactAddUI.c(FindMContactAddUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactAddUI.c(FindMContactAddUI.this).getCount()) }));
        AppMethodBeat.o(131181);
      }
    };
    AppMethodBeat.o(131187);
  }
  
  private void aOO()
  {
    AppMethodBeat.i(131191);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    hideVKB();
    ZA(1);
    AppMethodBeat.o(131191);
  }
  
  private void aQk()
  {
    AppMethodBeat.i(131189);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755906);
    this.fts = h.b(localAppCompatActivity, getString(2131761251), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    com.tencent.mm.kernel.g.agU().a(new ap.a()
    {
      public final boolean aBj()
      {
        AppMethodBeat.i(131179);
        try
        {
          FindMContactAddUI.a(FindMContactAddUI.this, com.tencent.mm.pluginsdk.a.dt(FindMContactAddUI.this));
          FindMContactAddUI.c(FindMContactAddUI.this).iHO = FindMContactAddUI.d(FindMContactAddUI.this);
          FindMContactAddUI.c(FindMContactAddUI.this).s(((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131179);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.FindMContactAddUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(131178);
        if (FindMContactAddUI.a(FindMContactAddUI.this) != null)
        {
          FindMContactAddUI.a(FindMContactAddUI.this).dismiss();
          FindMContactAddUI.b(FindMContactAddUI.this);
        }
        FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
        AppMethodBeat.o(131178);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(131180);
        String str = super.toString() + "|listMFriendData";
        AppMethodBeat.o(131180);
        return str;
      }
    });
    AppMethodBeat.o(131189);
  }
  
  public int getLayoutId()
  {
    return 2131494008;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131195);
    this.emptyTipTv = ((TextView)findViewById(2131302350));
    this.emptyTipTv.setText(2131761249);
    this.iIZ = ((ListView)findViewById(2131302352));
    if ((this.iHK != 2) && (this.iHK == 1))
    {
      this.iMi = LayoutInflater.from(this).inflate(2131494010, null);
      this.iMj = ((TextView)this.iMi.findViewById(2131300082));
      this.iMk = ((TextView)this.iMi.findViewById(2131300085));
      this.iMl = ((TextView)this.iMi.findViewById(2131299970));
      this.iMn = ((Button)this.iMi.findViewById(2131299969));
      this.iMk.setText(getString(2131759143));
      this.iMl.setText(getString(2131759144));
      this.iMn.setText(getString(2131759111));
    }
    for (;;)
    {
      this.iMh = new i(this, this.iMr, 1);
      this.iMn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131182);
          paramAnonymousView = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.agc()).append(",").append(FindMContactAddUI.this.getClass().getName()).append(",R300_300_AddAllButton,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R300_300_AddAllButton") + ",3");
          if (FindMContactAddUI.e(FindMContactAddUI.this) == 2)
          {
            FindMContactAddUI.c(FindMContactAddUI.this).fm(true);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            if (FindMContactAddUI.g(FindMContactAddUI.this) != null)
            {
              FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
              AppMethodBeat.o(131182);
            }
          }
          else
          {
            if (FindMContactAddUI.e(FindMContactAddUI.this) == 1)
            {
              FindMContactAddUI.c(FindMContactAddUI.this).fm(true);
              FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
              FindMContactAddUI.i(FindMContactAddUI.this);
              AppMethodBeat.o(131182);
              return;
            }
            FindMContactAddUI.c(FindMContactAddUI.this).fm(true);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(8);
            if (FindMContactAddUI.g(FindMContactAddUI.this) != null) {
              FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(0);
            }
          }
          AppMethodBeat.o(131182);
        }
      });
      if (this.iMm != null)
      {
        this.iMm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131183);
            FindMContactAddUI.f(FindMContactAddUI.this).setVisibility(0);
            FindMContactAddUI.g(FindMContactAddUI.this).setVisibility(8);
            FindMContactAddUI.c(FindMContactAddUI.this).fm(false);
            FindMContactAddUI.c(FindMContactAddUI.this).notifyDataSetChanged();
            AppMethodBeat.o(131183);
          }
        });
        this.iMm.setVisibility(8);
      }
      this.iIZ.addHeaderView(this.iMi);
      this.iIZ.setAdapter(this.iMh);
      addTextOptionMenu(0, getString(2131755830), new FindMContactAddUI.10(this));
      setToTop(new FindMContactAddUI.11(this));
      AppMethodBeat.o(131195);
      return;
      this.iMi = LayoutInflater.from(this).inflate(2131494009, null);
      this.iMj = ((TextView)this.iMi.findViewById(2131300082));
      this.iMk = ((TextView)this.iMi.findViewById(2131300085));
      this.iMl = ((TextView)this.iMi.findViewById(2131299970));
      this.iMn = ((Button)this.iMi.findViewById(2131299969));
      this.iMk.setText(getString(2131759143));
      this.iMl.setText(getString(2131759144));
      this.iMn.setText(getString(2131759110, new Object[] { Integer.valueOf(0) }));
      this.iMm = ((TextView)this.iMi.findViewById(2131302345));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131188);
    super.onCreate(paramBundle);
    setMMTitle(2131759115);
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.fwd = getIntent().getStringExtra("regsetinfo_ticket");
    this.iHJ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.iHK = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.iMo = getIntent().getIntExtra("login_type", 0);
    this.iHQ = com.tencent.mm.plugin.b.a.EL();
    initView();
    AppMethodBeat.o(131188);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131194);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.agi().b(30, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(131194);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131190);
    if (paramInt == 4)
    {
      aOO();
      AppMethodBeat.o(131190);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131190);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131193);
    super.onPause();
    if (this.iMo == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R300_300_QQ") + ",2");
      AppMethodBeat.o(131193);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_300_phone,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R300_300_phone") + ",2");
    AppMethodBeat.o(131193);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131196);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131196);
      return;
    }
    ac.i("MicroMsg.FindMContactAddUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131196);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aQk();
        AppMethodBeat.o(131196);
        return;
      }
      this.iMq = false;
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactAddUI.4(this), new FindMContactAddUI.5(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131192);
    super.onResume();
    this.iMh.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.iMo == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_300_QQ,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R300_300_QQ") + ",1");
      com.tencent.mm.plugin.b.a.IK("R300_300_QQ");
    }
    while (this.iMq)
    {
      boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ac.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
      if (!bool)
      {
        AppMethodBeat.o(131192);
        return;
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_300_phone,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R300_300_phone") + ",1");
        com.tencent.mm.plugin.b.a.IK("R300_300_phone");
      }
      else
      {
        aQk();
      }
    }
    AppMethodBeat.o(131192);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI
 * JD-Core Version:    0.7.0.1
 */