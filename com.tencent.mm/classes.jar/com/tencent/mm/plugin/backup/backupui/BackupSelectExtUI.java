package com.tencent.mm.plugin.backup.backupui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI
  extends MMPreference
{
  private int ayi;
  private long endTime;
  private long jAP;
  private int jCK;
  private SimpleDateFormat jCL;
  private RadioCheckPreference jGK;
  private RadioCheckPreference jGL;
  private RadioCheckPreference jGM;
  private RadioCheckPreference jGN;
  private Preference jGO;
  private Preference jGP;
  private boolean jGQ;
  private int jyJ;
  private f screen;
  private long startTime;
  
  public BackupSelectExtUI()
  {
    AppMethodBeat.i(17729);
    this.jCK = 0;
    this.jGQ = false;
    this.ayi = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.jAP = 0L;
    this.jCL = new SimpleDateFormat("yyyy.MM.dd");
    AppMethodBeat.o(17729);
  }
  
  private void aUO()
  {
    AppMethodBeat.i(17734);
    switch (this.jCK)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17734);
      return;
      this.jGK.qH(true);
      this.jGL.qH(false);
      this.screen.d(this.jGP);
      this.screen.d(this.jGO);
      enableOptionMenu(true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(17734);
      return;
      bJ();
    }
  }
  
  private void aUP()
  {
    AppMethodBeat.i(17735);
    switch (this.ayi)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17735);
      return;
      this.jGM.qH(true);
      this.jGN.qH(false);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(17735);
      return;
      this.jGM.qH(false);
      this.jGN.qH(true);
      this.screen.notifyDataSetChanged();
    }
  }
  
  private void aUQ()
  {
    AppMethodBeat.i(17737);
    if ((this.startTime == 0L) || (this.endTime == 0L))
    {
      this.jGP.setSummary(2131297386);
      this.jGO.setSummary(2131297386);
    }
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(17737);
      return;
      this.jGP.setSummary(this.jCL.format(new Date(this.startTime)));
      this.jGO.setSummary(this.jCL.format(new Date(this.endTime - 86400000L)));
      if ((this.startTime == 0L) || (this.endTime == 0L)) {
        break;
      }
    }
  }
  
  private void bJ()
  {
    AppMethodBeat.i(17736);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165196);
    this.jGK = ((RadioCheckPreference)this.screen.atx("backup_select_ext_time_all"));
    this.jGL = ((RadioCheckPreference)this.screen.atx("backup_select_ext_time_some"));
    this.jGP = this.screen.atx("backup_select_begin_time");
    this.jGO = this.screen.atx("backup_select_end_time");
    this.jGM = ((RadioCheckPreference)this.screen.atx("backup_select_ext_content_all_msg"));
    this.jGN = ((RadioCheckPreference)this.screen.atx("backup_select_ext_content_text_only"));
    if (!this.jGQ)
    {
      this.screen.d(this.screen.atx("backup_select_ext_content_title"));
      this.screen.d(this.jGM);
      this.screen.d(this.jGN);
    }
    if (this.jyJ == 1)
    {
      this.screen.atx("backup_select_ext_time_title").setTitle(2131297365);
      if (this.jGQ) {
        this.screen.atx("backup_select_ext_content_title").setTitle(2131297363);
      }
      switch (this.jCK)
      {
      default: 
        label256:
        if (this.jGQ) {
          switch (this.ayi)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(17736);
      return;
      if (this.jyJ != 2) {
        break;
      }
      this.screen.atx("backup_select_ext_time_title").setTitle(2131297295);
      if (!this.jGQ) {
        break;
      }
      this.screen.atx("backup_select_ext_content_title").setTitle(2131297293);
      break;
      this.jGK.qH(true);
      this.jGL.qH(false);
      this.jGP.setEnabled(false);
      this.jGO.setEnabled(false);
      this.screen.d(this.jGP);
      this.screen.d(this.jGO);
      enableOptionMenu(true);
      break label256;
      aUQ();
      this.jGK.qH(false);
      this.jGL.qH(true);
      this.jGP.setEnabled(true);
      this.jGO.setEnabled(true);
      break label256;
      this.jGM.qH(true);
      this.jGN.qH(false);
      continue;
      this.jGM.qH(false);
      this.jGN.qH(true);
    }
  }
  
  public int getResourceId()
  {
    return 2131165196;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17733);
    this.jyJ = getIntent().getIntExtra("BACKUP_MODE", 0);
    setMMTitle(2131297382);
    this.jCK = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
    this.jGQ = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
    this.ayi = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
    this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    this.jAP = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0L);
    bJ();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(17727);
        BackupSelectExtUI.this.finish();
        AppMethodBeat.o(17727);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131297407), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(17728);
        if ((BackupSelectExtUI.g(BackupSelectExtUI.this) == 1) && (BackupSelectExtUI.d(BackupSelectExtUI.this) >= BackupSelectExtUI.e(BackupSelectExtUI.this)))
        {
          if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 1) {
            h.b(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(2131297314), "", true);
          }
          for (;;)
          {
            AppMethodBeat.o(17728);
            return true;
            if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 2) {
              h.b(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(2131297235), "", true);
            }
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.g(BackupSelectExtUI.this));
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.i(BackupSelectExtUI.this));
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.d(BackupSelectExtUI.this));
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.e(BackupSelectExtUI.this));
        BackupSelectExtUI.this.setResult(-1, paramAnonymousMenuItem);
        BackupSelectExtUI.this.finish();
        AppMethodBeat.o(17728);
        return true;
      }
    }, null, q.b.zby);
    AppMethodBeat.o(17733);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17730);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(17730);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(17732);
    Object localObject = Calendar.getInstance();
    switch (paramInt)
    {
    }
    for (;;)
    {
      int i = ((Calendar)localObject).get(1);
      int j = ((Calendar)localObject).get(2);
      localObject = new e(getContext(), new BackupSelectExtUI.1(this, paramInt), i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis(), (byte)0);
      ((e)localObject).setCanceledOnTouchOutside(false);
      long l1 = bo.aoy() / 86400000L * 86400000L + 57600000L - 1L;
      long l2 = this.jAP / 86400000L * 86400000L + 57600000L - 86400000L;
      if (l1 > l2) {}
      try
      {
        ((e)localObject).oU(l2);
        ((e)localObject).oT(l1);
        AppMethodBeat.o(17732);
        return localObject;
        if (this.startTime == 0L) {}
        for (l1 = bo.aoy();; l1 = this.startTime)
        {
          ((Calendar)localObject).setTimeInMillis(l1);
          break;
        }
        if (this.endTime == 0L) {}
        for (l1 = bo.aoy();; l1 = this.endTime - 86400000L)
        {
          ((Calendar)localObject).setTimeInMillis(l1);
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.BackupSelectExtUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), localException });
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(17731);
    paramf = paramPreference.mKey;
    if (paramf.equals("backup_select_ext_time_all"))
    {
      this.jCK = 0;
      aUO();
      AppMethodBeat.o(17731);
      return true;
    }
    if (paramf.equals("backup_select_ext_time_some"))
    {
      this.jCK = 1;
      aUO();
      AppMethodBeat.o(17731);
      return true;
    }
    if (paramf.equals("backup_select_ext_content_all_msg"))
    {
      if (this.jGQ)
      {
        this.ayi = 0;
        aUP();
      }
      for (;;)
      {
        AppMethodBeat.o(17731);
        return true;
        ab.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
      }
    }
    if (paramf.equals("backup_select_ext_content_text_only"))
    {
      if (this.jGQ)
      {
        this.ayi = 1;
        aUP();
      }
      for (;;)
      {
        AppMethodBeat.o(17731);
        return true;
        ab.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
      }
    }
    if (paramf.equals("backup_select_begin_time"))
    {
      showDialog(1);
      AppMethodBeat.o(17731);
      return true;
    }
    if (paramf.equals("backup_select_end_time"))
    {
      showDialog(2);
      AppMethodBeat.o(17731);
      return true;
    }
    AppMethodBeat.o(17731);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI
 * JD-Core Version:    0.7.0.1
 */