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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String dpO;
  private ProgressDialog fpP = null;
  private String fsw = null;
  private String ihB = "";
  private int ihC = 2;
  private List<String[]> ihG = null;
  private aj ihH;
  private Button ihY;
  private TextView ihZ;
  private com.tencent.mm.al.g onSceneEndCallback = null;
  
  private void aHX()
  {
    AppMethodBeat.i(110062);
    hideVKB();
    Xo(1);
    AppMethodBeat.o(110062);
  }
  
  private void aId()
  {
    AppMethodBeat.i(110060);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
    if (!bool)
    {
      AppMethodBeat.o(110060);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.aeS();
    com.tencent.mm.al.g local3 = new com.tencent.mm.al.g()
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
          com.tencent.mm.kernel.g.aeS().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousn).aJd();
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label392;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            bly localbly = (bly)paramAnonymousn.next();
            if (localbly != null)
            {
              if (localbly.mBi != 1) {
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
            ad.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this) == null) || (!FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.aUz("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.g(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.i(FindMContactLearmMoreUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.V(FindMContactLearmMoreUI.this, paramAnonymousString);
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
    this.fpP = h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110049);
        if (FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this) != null)
        {
          com.tencent.mm.kernel.g.aeS().b(431, FindMContactLearmMoreUI.e(FindMContactLearmMoreUI.this));
          FindMContactLearmMoreUI.f(FindMContactLearmMoreUI.this);
        }
        AppMethodBeat.o(110049);
      }
    });
    com.tencent.mm.kernel.g.afE().a(new aq.a()
    {
      public final boolean aus()
      {
        AppMethodBeat.i(110051);
        for (;;)
        {
          try
          {
            FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, com.tencent.mm.pluginsdk.a.dk(FindMContactLearmMoreUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) {
              continue;
            }
            i = 0;
            ad.d("MicroMsg.FindMContactLearmMoreUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ad.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110051);
          return true;
          i = FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size();
        }
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(110050);
        if ((FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this) != null) && (FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this).size() != 0))
        {
          FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this, new aj(FindMContactLearmMoreUI.h(FindMContactLearmMoreUI.this), FindMContactLearmMoreUI.j(FindMContactLearmMoreUI.this)));
          com.tencent.mm.kernel.g.aeS().a(FindMContactLearmMoreUI.k(FindMContactLearmMoreUI.this), 0);
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
    this.ihY = ((Button)findViewById(2131302999));
    this.ihZ = ((TextView)findViewById(2131297690));
    this.ihY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110046);
        l.eT(true);
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.a(FindMContactLearmMoreUI.this);
        AppMethodBeat.o(110046);
      }
    });
    this.ihZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110047);
        l.eT(false);
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
        FindMContactLearmMoreUI.b(FindMContactLearmMoreUI.this);
        AppMethodBeat.o(110047);
      }
    });
    com.tencent.mm.kernel.g.afB().afk().set(12323, Boolean.TRUE);
    this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(6, null));
    if ((this.dpO == null) || (this.dpO.equals(""))) {
      this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(4097, null));
    }
    AppMethodBeat.o(110059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110055);
    super.onCreate(paramBundle);
    this.fsw = getIntent().getStringExtra("regsetinfo_ticket");
    this.ihB = getIntent().getStringExtra("regsetinfo_NextStep");
    this.ihC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    initView();
    AppMethodBeat.o(110055);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110056);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.aeS().b(431, this.onSceneEndCallback);
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
      aHX();
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
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",RE300_600,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("RE300_600") + ",2");
    AppMethodBeat.o(110058);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110063);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110063);
      return;
    }
    ad.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110063);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aId();
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
    com.tencent.mm.plugin.b.a.aUy("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",RE300_600,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("RE300_600") + ",1");
    AppMethodBeat.o(110057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI
 * JD-Core Version:    0.7.0.1
 */