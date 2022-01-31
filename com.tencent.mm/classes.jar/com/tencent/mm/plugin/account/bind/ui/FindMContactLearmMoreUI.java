package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactLearmMoreUI
  extends MMWizardActivity
{
  private String czF;
  private ProgressDialog eeN = null;
  private String eiu = null;
  private String guB = "";
  private int guC = 2;
  private List<String[]> guG = null;
  private ag guH;
  private Button guZ;
  private TextView gva;
  private f onSceneEndCallback = null;
  
  private void apB()
  {
    AppMethodBeat.i(13638);
    hideVKB();
    Oi(1);
    AppMethodBeat.o(13638);
  }
  
  private void apH()
  {
    AppMethodBeat.i(13636);
    boolean bool = b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ab.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY() });
    if (!bool)
    {
      AppMethodBeat.o(13636);
      return;
    }
    Object localObject = g.Rc();
    FindMContactLearmMoreUI.3 local3 = new FindMContactLearmMoreUI.3(this);
    this.onSceneEndCallback = local3;
    ((p)localObject).a(431, local3);
    localObject = getContext();
    getString(2131297087);
    this.eeN = h.b((Context)localObject, getString(2131296987), true, new FindMContactLearmMoreUI.4(this));
    g.RO().a(new FindMContactLearmMoreUI.5(this));
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
    ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
    AppMethodBeat.o(13636);
  }
  
  public int getLayoutId()
  {
    return 2130969589;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13635);
    setMMTitle(2131299955);
    this.guZ = ((Button)findViewById(2131823301));
    this.gva = ((TextView)findViewById(2131822887));
    this.guZ.setOnClickListener(new FindMContactLearmMoreUI.1(this));
    this.gva.setOnClickListener(new FindMContactLearmMoreUI.2(this));
    g.RL().Ru().set(12323, Boolean.TRUE);
    this.czF = ((String)g.RL().Ru().get(6, null));
    if ((this.czF == null) || (this.czF.equals(""))) {
      this.czF = ((String)g.RL().Ru().get(4097, null));
    }
    AppMethodBeat.o(13635);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13631);
    super.onCreate(paramBundle);
    this.eiu = getIntent().getStringExtra("regsetinfo_ticket");
    this.guB = getIntent().getStringExtra("regsetinfo_NextStep");
    this.guC = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    initView();
    AppMethodBeat.o(13631);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13632);
    if (this.onSceneEndCallback != null)
    {
      g.Rc().b(431, this.onSceneEndCallback);
      this.onSceneEndCallback = null;
    }
    super.onDestroy();
    AppMethodBeat.o(13632);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13637);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(13637);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13637);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13634);
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE300_600,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("RE300_600") + ",2");
    AppMethodBeat.o(13634);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(13639);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(13639);
      return;
    }
    ab.i("MicroMsg.FindMContactLearmMoreUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13639);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        apH();
        AppMethodBeat.o(13639);
        return;
      }
      h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131296888), false, new FindMContactLearmMoreUI.6(this), new FindMContactLearmMoreUI.7(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13633);
    super.onResume();
    com.tencent.mm.plugin.b.a.xC("R300_100_phone");
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE300_600,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("RE300_600") + ",1");
    AppMethodBeat.o(13633);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI
 * JD-Core Version:    0.7.0.1
 */