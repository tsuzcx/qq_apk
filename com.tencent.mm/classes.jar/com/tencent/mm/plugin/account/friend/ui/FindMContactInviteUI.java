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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.i;
import com.tencent.mm.plugin.account.friend.a.i.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactInviteUI
  extends MMWizardActivity
{
  private TextView emptyTipTv;
  private ProgressDialog fts;
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
  private String iMt;
  private com.tencent.mm.ak.g onSceneEndCallback;
  
  public FindMContactInviteUI()
  {
    AppMethodBeat.i(131212);
    this.fts = null;
    this.emptyTipTv = null;
    this.iMj = null;
    this.iMk = null;
    this.iMl = null;
    this.iMm = null;
    this.iMn = null;
    this.iMt = null;
    this.onSceneEndCallback = null;
    this.iHK = 2;
    this.iMq = true;
    this.iMr = new i.a()
    {
      public final void notifyDataSetChanged()
      {
        AppMethodBeat.i(131204);
        if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 2) && (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1))
        {
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759120));
          if (!FindMContactInviteUI.b(FindMContactInviteUI.this).aPy()) {
            break label240;
          }
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 0) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
          }
        }
        for (;;)
        {
          if ((FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount() <= 0) || (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1)) {
            break label302;
          }
          FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(2131623942, FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getSelectCount()) }));
          AppMethodBeat.o(131204);
          return;
          FindMContactInviteUI.e(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getString(2131759119, new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
          break;
          label240:
          if ((FindMContactInviteUI.d(FindMContactInviteUI.this) != 1) && (FindMContactInviteUI.e(FindMContactInviteUI.this).getVisibility() == 8) && (FindMContactInviteUI.f(FindMContactInviteUI.this) != null))
          {
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
          }
        }
        label302:
        FindMContactInviteUI.g(FindMContactInviteUI.this).setText(FindMContactInviteUI.this.getResources().getQuantityString(2131623943, FindMContactInviteUI.b(FindMContactInviteUI.this).getCount(), new Object[] { Integer.valueOf(FindMContactInviteUI.b(FindMContactInviteUI.this).getCount()) }));
        AppMethodBeat.o(131204);
      }
    };
    AppMethodBeat.o(131212);
  }
  
  private void aOO()
  {
    AppMethodBeat.i(131215);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    hideVKB();
    ZA(1);
    AppMethodBeat.o(131215);
  }
  
  private void aQk()
  {
    AppMethodBeat.i(131217);
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
        AppMethodBeat.i(131202);
        try
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this, com.tencent.mm.pluginsdk.a.dt(FindMContactInviteUI.this));
          FindMContactInviteUI.b(FindMContactInviteUI.this).iHO = FindMContactInviteUI.c(FindMContactInviteUI.this);
          FindMContactInviteUI.b(FindMContactInviteUI.this).s(((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFriendData());
          AppMethodBeat.o(131202);
          return true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.FindMContactInviteUI", localException, "", new Object[0]);
          }
        }
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(131201);
        if (FindMContactInviteUI.a(FindMContactInviteUI.this) != null)
        {
          FindMContactInviteUI.a(FindMContactInviteUI.this).dismiss();
          FindMContactInviteUI.a(FindMContactInviteUI.this, null);
        }
        FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
        AppMethodBeat.o(131201);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(131203);
        String str = super.toString() + "|listMFriendData";
        AppMethodBeat.o(131203);
        return str;
      }
    });
    AppMethodBeat.o(131217);
  }
  
  public int getLayoutId()
  {
    return 2131494008;
  }
  
  public void initView()
  {
    AppMethodBeat.i(131220);
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
      this.iMk.setText(getString(2131759121));
      this.iMl.setText(getString(2131759121));
      this.iMn.setText(getString(2131759120));
    }
    for (;;)
    {
      this.iMh = new i(this, this.iMr, 2);
      this.iMn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(131205);
          paramAnonymousView = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.agc()).append(",").append(FindMContactInviteUI.this.getClass().getName()).append(",R300_400_AddAllButton,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R300_300_AddAllButton") + ",3");
          if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 2)
          {
            FindMContactInviteUI.b(FindMContactInviteUI.this).fm(true);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null)
            {
              FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
              AppMethodBeat.o(131205);
            }
          }
          else
          {
            if (FindMContactInviteUI.d(FindMContactInviteUI.this) == 1)
            {
              FindMContactInviteUI.b(FindMContactInviteUI.this).fm(true);
              FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
              FindMContactInviteUI.h(FindMContactInviteUI.this);
              AppMethodBeat.o(131205);
              return;
            }
            FindMContactInviteUI.b(FindMContactInviteUI.this).fm(true);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(8);
            if (FindMContactInviteUI.f(FindMContactInviteUI.this) != null) {
              FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(0);
            }
          }
          AppMethodBeat.o(131205);
        }
      });
      if (this.iMm != null)
      {
        this.iMm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(131206);
            FindMContactInviteUI.e(FindMContactInviteUI.this).setVisibility(0);
            FindMContactInviteUI.f(FindMContactInviteUI.this).setVisibility(8);
            FindMContactInviteUI.b(FindMContactInviteUI.this).fm(false);
            FindMContactInviteUI.b(FindMContactInviteUI.this).notifyDataSetChanged();
            AppMethodBeat.o(131206);
          }
        });
        this.iMm.setVisibility(8);
      }
      this.iIZ.addHeaderView(this.iMi);
      this.iIZ.setAdapter(this.iMh);
      this.iIZ.setOnScrollListener(new com.tencent.mm.ui.applet.a());
      this.iIZ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(131207);
          if (FindMContactInviteUI.b(FindMContactInviteUI.this) != null)
          {
            paramAnonymousView = FindMContactInviteUI.b(FindMContactInviteUI.this);
            if (paramAnonymousView.iKs != null) {
              paramAnonymousView.iKs.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(131207);
          return false;
        }
      });
      addTextOptionMenu(0, getString(2131755779), new FindMContactInviteUI.10(this));
      setToTop(new FindMContactInviteUI.11(this));
      AppMethodBeat.o(131220);
      return;
      this.iMi = LayoutInflater.from(this).inflate(2131494009, null);
      this.iMj = ((TextView)this.iMi.findViewById(2131300082));
      this.iMk = ((TextView)this.iMi.findViewById(2131300085));
      this.iMl = ((TextView)this.iMi.findViewById(2131299970));
      this.iMn = ((Button)this.iMi.findViewById(2131299969));
      this.iMk.setText(getString(2131759124));
      this.iMl.setText(getString(2131759121));
      this.iMn.setText(getString(2131759119, new Object[] { Integer.valueOf(0) }));
      this.iMm = ((TextView)this.iMi.findViewById(2131302345));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131213);
    super.onCreate(paramBundle);
    setMMTitle(2131759123);
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.iMt = getIntent().getStringExtra("regsetinfo_ticket");
    this.iMo = getIntent().getIntExtra("login_type", 0);
    this.iHK = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    this.iHQ = com.tencent.mm.plugin.b.a.EL();
    initView();
    AppMethodBeat.o(131213);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(131219);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.agi().b(432, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    if (this.iMh != null)
    {
      i locali = this.iMh;
      if (locali.iKs != null)
      {
        locali.iKs.detach();
        locali.iKs = null;
      }
    }
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).clearFriendData();
    super.onDestroy();
    AppMethodBeat.o(131219);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(131214);
    if (paramInt == 4)
    {
      aOO();
      AppMethodBeat.o(131214);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(131214);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(131218);
    super.onPause();
    if (this.iMo == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R300_400_QQ") + ",2");
      AppMethodBeat.o(131218);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_400_phone,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R300_400_phone") + ",2");
    AppMethodBeat.o(131218);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131221);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(131221);
      return;
    }
    ac.i("MicroMsg.FindMContactInviteUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(131221);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aQk();
        AppMethodBeat.o(131221);
        return;
      }
      this.iMq = false;
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactInviteUI.3(this), new FindMContactInviteUI.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(131216);
    super.onResume();
    this.iMh.notifyDataSetChanged();
    StringBuilder localStringBuilder;
    if (this.iMo == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_400_QQ,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R300_400_QQ") + ",1");
    }
    while (this.iMq)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
      ac.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
      if (!bool)
      {
        AppMethodBeat.o(131216);
        return;
        localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R300_400_phone,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R300_400_phone") + ",1");
      }
      else
      {
        aQk();
      }
    }
    AppMethodBeat.o(131216);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI
 * JD-Core Version:    0.7.0.1
 */