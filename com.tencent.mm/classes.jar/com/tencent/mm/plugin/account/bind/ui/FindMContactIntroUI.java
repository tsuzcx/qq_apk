package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.k;
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

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String dpO;
  private ProgressDialog fpP = null;
  private String fsw = null;
  private String ihB = "";
  private int ihC = 2;
  private boolean ihF = false;
  private List<String[]> ihG = null;
  private aj ihH;
  private String ihI;
  private Button ihT;
  private TextView ihU;
  private TextView ihV;
  private com.tencent.mm.al.g onSceneEndCallback = null;
  
  private void aHX()
  {
    AppMethodBeat.i(110041);
    com.tencent.mm.plugin.b.a.aUz(this.ihI);
    hideVKB();
    Xo(1);
    AppMethodBeat.o(110041);
  }
  
  private void aId()
  {
    AppMethodBeat.i(110039);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
    if (!bool)
    {
      AppMethodBeat.o(110039);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.aeS();
    com.tencent.mm.al.g local9 = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(110029);
        if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
        {
          FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
          FindMContactIntroUI.h(FindMContactIntroUI.this);
        }
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          com.tencent.mm.kernel.g.aeS().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((aj)paramAnonymousn).aJd();
          ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(paramAnonymousString);
          if ((paramAnonymousString == null) || (paramAnonymousString.size() <= 0)) {
            break label385;
          }
          paramAnonymousn = paramAnonymousString.iterator();
          paramAnonymousInt1 = 0;
          while (paramAnonymousn.hasNext())
          {
            bly localbly = (bly)paramAnonymousn.next();
            if (localbly != null)
            {
              if (localbly.mBi != 1) {
                break label382;
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
            ad.d("MicroMsg.FindMContactIntroUI", "tigerreg data size=%d, addcount=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1) });
            if ((FindMContactIntroUI.d(FindMContactIntroUI.this) == null) || (!FindMContactIntroUI.d(FindMContactIntroUI.this).contains("1")) || (paramAnonymousInt2 == 0)) {
              break label325;
            }
            com.tencent.mm.plugin.b.a.aUz("R300_300_phone");
            paramAnonymousString = new Intent(FindMContactIntroUI.this, FindMContactAddUI.class);
            paramAnonymousString.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(FindMContactIntroUI.this));
            paramAnonymousString.putExtra("login_type", 0);
            MMWizardActivity.V(FindMContactIntroUI.this, paramAnonymousString);
            AppMethodBeat.o(110029);
            return;
            paramAnonymousInt2 = 0;
            break;
          }
          label325:
          FindMContactIntroUI.b(FindMContactIntroUI.this);
          AppMethodBeat.o(110029);
          return;
          Toast.makeText(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131755733, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }), 0).show();
          AppMethodBeat.o(110029);
          return;
          label382:
          break;
          label385:
          paramAnonymousInt2 = 0;
          paramAnonymousInt1 = 0;
        }
      }
    };
    this.onSceneEndCallback = local9;
    ((q)localObject).a(431, local9);
    localObject = getContext();
    getString(2131755906);
    this.fpP = h.b((Context)localObject, getString(2131755804), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(110030);
        if (FindMContactIntroUI.i(FindMContactIntroUI.this) != null)
        {
          com.tencent.mm.kernel.g.aeS().b(431, FindMContactIntroUI.i(FindMContactIntroUI.this));
          FindMContactIntroUI.j(FindMContactIntroUI.this);
        }
        AppMethodBeat.o(110030);
      }
    });
    com.tencent.mm.kernel.g.afE().a(new aq.a()
    {
      public final boolean aus()
      {
        AppMethodBeat.i(110032);
        for (;;)
        {
          try
          {
            FindMContactIntroUI.a(FindMContactIntroUI.this, com.tencent.mm.pluginsdk.a.dk(FindMContactIntroUI.this));
            StringBuilder localStringBuilder = new StringBuilder("tigerreg mobileList size ");
            if (FindMContactIntroUI.k(FindMContactIntroUI.this) != null) {
              continue;
            }
            i = 0;
            ad.d("MicroMsg.FindMContactIntroUI", i);
          }
          catch (Exception localException)
          {
            int i;
            ad.printErrStackTrace("MicroMsg.FindMContactIntroUI", localException, "", new Object[0]);
            continue;
          }
          AppMethodBeat.o(110032);
          return true;
          i = FindMContactIntroUI.k(FindMContactIntroUI.this).size();
        }
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(110031);
        if ((FindMContactIntroUI.k(FindMContactIntroUI.this) != null) && (FindMContactIntroUI.k(FindMContactIntroUI.this).size() != 0))
        {
          FindMContactIntroUI.a(FindMContactIntroUI.this, new aj(FindMContactIntroUI.c(FindMContactIntroUI.this), FindMContactIntroUI.k(FindMContactIntroUI.this)));
          com.tencent.mm.kernel.g.aeS().a(FindMContactIntroUI.l(FindMContactIntroUI.this), 0);
        }
        for (;;)
        {
          AppMethodBeat.o(110031);
          return false;
          if (FindMContactIntroUI.g(FindMContactIntroUI.this) != null)
          {
            FindMContactIntroUI.g(FindMContactIntroUI.this).dismiss();
            FindMContactIntroUI.h(FindMContactIntroUI.this);
          }
          FindMContactIntroUI.b(FindMContactIntroUI.this);
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(110033);
        String str = super.toString() + "|doUpload";
        AppMethodBeat.o(110033);
        return str;
      }
    });
    AppMethodBeat.o(110039);
  }
  
  public int getLayoutId()
  {
    return 2131494129;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110038);
    this.ihT = ((Button)findViewById(2131304623));
    this.ihV = ((TextView)findViewById(2131300084));
    this.ihU = ((TextView)findViewById(2131300083));
    if ((this.ihB != null) && (this.ihB.contains("2"))) {
      this.ihU.setText(getString(2131759113));
    }
    for (;;)
    {
      this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(6, null));
      if ((this.dpO == null) || (this.dpO.equals(""))) {
        this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(4097, null));
      }
      this.ihT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110020);
          FindMContactIntroUI.a(FindMContactIntroUI.this);
          AppMethodBeat.o(110020);
        }
      });
      this.ihV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(110024);
          h.d(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(2131759130), null, FindMContactIntroUI.this.getString(2131759131), FindMContactIntroUI.this.getString(2131759129), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110023);
              FindMContactIntroUI.b(FindMContactIntroUI.this);
              AppMethodBeat.o(110023);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(110024);
        }
      });
      AppMethodBeat.o(110038);
      return;
      this.ihU.setText(getString(2131759114));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110034);
    super.onCreate(paramBundle);
    setMMTitle(2131759133);
    com.tencent.mm.plugin.account.a.a.hYu.Lo();
    this.fsw = getIntent().getStringExtra("regsetinfo_ticket");
    this.ihB = getIntent().getStringExtra("regsetinfo_NextStep");
    this.ihC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (com.tencent.mm.plugin.account.friend.a.l.aIL() != l.a.iky) {}
    for (boolean bool = true;; bool = false)
    {
      this.ihF = bool;
      this.ihI = com.tencent.mm.plugin.b.a.fQQ();
      ad.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.ihB, Integer.valueOf(this.ihC) });
      AppMethodBeat.o(110034);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110035);
    if (this.onSceneEndCallback != null)
    {
      com.tencent.mm.kernel.g.aeS().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(110035);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110040);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aHX();
      AppMethodBeat.o(110040);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(110040);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110037);
    super.onPause();
    com.tencent.mm.plugin.b.a.aUz("RE900_100");
    if (this.ihF)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R300_100_QQ") + ",4");
      AppMethodBeat.o(110037);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R300_100_phone") + ",4");
    AppMethodBeat.o(110037);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110042);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(110042);
      return;
    }
    ad.i("MicroMsg.FindMContactIntroUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110042);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aId();
        AppMethodBeat.o(110042);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131755691), false, new FindMContactIntroUI.2(this), new FindMContactIntroUI.3(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110036);
    super.onResume();
    initView();
    if (this.ihF)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.aUy("R300_100_QQ");
      AppMethodBeat.o(110036);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.aUy("R300_100_phone");
    AppMethodBeat.o(110036);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */