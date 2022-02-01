package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String dnz;
  private ProgressDialog fts = null;
  private String fwd = null;
  private String iHJ = "";
  private int iHK = 2;
  private List<String[]> iHO = null;
  private aj iHP;
  private Button iIg;
  private TextView iIh;
  private com.tencent.mm.ak.g onSceneEndCallback = null;
  
  private void aOO()
  {
    AppMethodBeat.i(110062);
    hideVKB();
    ZA(1);
    AppMethodBeat.o(110062);
  }
  
  private void aOU()
  {
    AppMethodBeat.i(110060);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ac.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
    if (!bool)
    {
      AppMethodBeat.o(110060);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.agi();
    com.tencent.mm.ak.g local3 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(110048);
        if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
        {
          FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
          FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
        }
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          com.tencent.mm.kernel.g.agi().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousn).aPU();
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            bpw localbpw = (bpw)paramAnonymousn.next();
            if (localbpw != null)
            {
              if (localbpw.ndj != 1) {
                break label389;
              }
              paramAnonymousInt1 += 1;
            }
          }
          if (paramAnonymousInt1 > 0) {
            paramAnonymousInt2 = 1;
          }
        }
        for (;;)
        {
          if (paramAnonymousString == null) {}
          for (int i = 0;; i = paramAnonymousString.size())
          {
            ac.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this) == null) || (!FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.IL("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.aj(FindMContactLearmMoreUI.this, paramAnonymousString);
            AppMethodBeat.o(110048);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          AppMethodBeat.o(110048);
          return;
          Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(2131755733, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
          AppMethodBeat.o(110048);
          return;
          label389:
          break;
          label392:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local3;
    ((q)localObject).a(431, local3);
    localObject = getContext();
    getString(2131755906);
    this.fts = h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110049);
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          com.tencent.mm.kernel.g.agi().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        AppMethodBeat.o(110049);
      }
    });
    com.tencent.mm.kernel.g.agU().a(new ap.a()
    {
      public final boolean aBj()
      {
        AppMethodBeat.i(110051);
        for (;;)
        {
          try
          {
            FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, com.tencent.mm.pluginsdk.a.dt(FindMContactLearmMoreUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) {
              continue;
            }
            i = 0;
            ac.d("MicroMsg.FindMContactLearmMoreUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ac.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110051);
          return true;
          i = FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size();
        }
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(110050);
        if ((FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) && (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size() != 0))
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, new aj(FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this), FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this)));
          com.tencent.mm.kernel.g.agi().a(FindMContactLearmMoreUI.k(FindMContactLearmMoreUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(110050);
          return false;
          if (FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this) != null)
          {
            FindMContactLearmMoreUI.c(FindMContactLearmMoreUI.this).dismiss();
            FindMContactLearmMoreUI.d(FindMContactLearmMoreUI.this);
          }
          FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(110052);
        String str = super.toString() + "|doUpload";
        AppMethodBeat.o(110052);
        return str;
      }
    });
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    AppMethodBeat.o(110060);
  }
  
  public int getLayoutId()
  {
    return 2131494130;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110059);
    setMMTitle(2131759142);
    this.iIg = ((Button)findViewById(2131302999));
    this.iIh = ((TextView)findViewById(2131297690));
    this.iIg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110046);
        l.fn(true);
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
        AppMethodBeat.o(110046);
      }
    });
    this.iIh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110047);
        l.fn(false);
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        AppMethodBeat.o(110047);
      }
    });
    com.tencent.mm.kernel.g.agR().agA().set(12323, Boolean.TRUE);
    this.dnz = ((String)com.tencent.mm.kernel.g.agR().agA().get(6, null));
    if ((this.dnz == null) || (this.dnz.equals(""))) {
      this.dnz = ((String)com.tencent.mm.kernel.g.agR().agA().get(4097, null));
    }
    AppMethodBeat.o(110059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110055);
    super.onCreate(paramBundle);
    this.fwd = getIntent().getStringExtra("regsetinfo_ticket");
    this.iHJ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.iHK = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    initView();
    AppMethodBeat.o(110055);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110056);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.agi().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(110056);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110061);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aOO();
      AppMethodBeat.o(110061);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(110061);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110058);
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE300_600,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("RE300_600") + ",2");
    AppMethodBeat.o(110058);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110063);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110063);
      return;
    }
    ac.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110063);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aOU();
        AppMethodBeat.o(110063);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactLearmMoreUI.6(this), new FindMContactLearmMoreUI.7(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110057);
    super.onResume();
    com.tencent.mm.plugin.b.a.IK("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE300_600,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("RE300_600") + ",1");
    AppMethodBeat.o(110057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI
 * JD-Core Version:    0.7.0.1
 */