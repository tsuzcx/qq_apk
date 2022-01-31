package com.tencent.mm.plugin.backup.backupui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI
  extends MMPreference
{
  private int avS = 0;
  private f dnn;
  private long endTime = 0L;
  private int hFq;
  private long hHt = 0L;
  private int hJk = 0;
  private SimpleDateFormat hJl = new SimpleDateFormat("yyyy.MM.dd");
  private RadioCheckPreference hNh;
  private RadioCheckPreference hNi;
  private RadioCheckPreference hNj;
  private RadioCheckPreference hNk;
  private Preference hNl;
  private Preference hNm;
  private boolean hNn = false;
  private long startTime = 0L;
  
  private void aZ()
  {
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.backup_select_ext_preference);
    this.hNh = ((RadioCheckPreference)this.dnn.add("backup_select_ext_time_all"));
    this.hNi = ((RadioCheckPreference)this.dnn.add("backup_select_ext_time_some"));
    this.hNm = this.dnn.add("backup_select_begin_time");
    this.hNl = this.dnn.add("backup_select_end_time");
    this.hNj = ((RadioCheckPreference)this.dnn.add("backup_select_ext_content_all_msg"));
    this.hNk = ((RadioCheckPreference)this.dnn.add("backup_select_ext_content_text_only"));
    if (!this.hNn)
    {
      this.dnn.c(this.dnn.add("backup_select_ext_content_title"));
      this.dnn.c(this.hNj);
      this.dnn.c(this.hNk);
    }
    if (this.hFq == 1)
    {
      this.dnn.add("backup_select_ext_time_title").setTitle(R.l.backup_pc_select_ext_time_title);
      if (this.hNn) {
        this.dnn.add("backup_select_ext_content_title").setTitle(R.l.backup_pc_select_ext_content_title);
      }
    }
    label228:
    switch (this.hJk)
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.hNn) {}
        switch (this.avS)
        {
        default: 
          this.dnn.notifyDataSetChanged();
          return;
          if (this.hFq != 2) {
            break label228;
          }
          this.dnn.add("backup_select_ext_time_title").setTitle(R.l.backup_move_select_ext_time_title);
          if (!this.hNn) {
            break label228;
          }
          this.dnn.add("backup_select_ext_content_title").setTitle(R.l.backup_move_select_ext_content_title);
          break label228;
          this.hNh.nd(true);
          this.hNi.nd(false);
          this.hNm.setEnabled(false);
          this.hNl.setEnabled(false);
          this.dnn.c(this.hNm);
          this.dnn.c(this.hNl);
          enableOptionMenu(true);
        }
      }
    }
    label288:
    if ((this.startTime == 0L) || (this.endTime == 0L))
    {
      this.hNm.setSummary(R.l.backup_select_time_choose_date);
      this.hNl.setSummary(R.l.backup_select_time_choose_date);
    }
    label613:
    for (;;)
    {
      for (boolean bool = false;; bool = true)
      {
        enableOptionMenu(bool);
        this.hNh.nd(false);
        this.hNi.nd(true);
        this.hNm.setEnabled(true);
        this.hNl.setEnabled(true);
        break;
        this.hNm.setSummary(this.hJl.format(new Date(this.startTime)));
        this.hNl.setSummary(this.hJl.format(new Date(this.endTime - 86400000L)));
        if ((this.startTime == 0L) || (this.endTime == 0L)) {
          break label613;
        }
      }
      this.hNj.nd(true);
      this.hNk.nd(false);
      break label288;
      this.hNj.nd(false);
      this.hNk.nd(true);
      break label288;
    }
  }
  
  private void avm()
  {
    switch (this.hJk)
    {
    default: 
      return;
    case 0: 
      this.hNh.nd(true);
      this.hNi.nd(false);
      this.dnn.c(this.hNm);
      this.dnn.c(this.hNl);
      enableOptionMenu(true);
      this.dnn.notifyDataSetChanged();
      return;
    }
    aZ();
  }
  
  private void avn()
  {
    switch (this.avS)
    {
    default: 
      return;
    case 0: 
      this.hNj.nd(true);
      this.hNk.nd(false);
      this.dnn.notifyDataSetChanged();
      return;
    }
    this.hNj.nd(false);
    this.hNk.nd(true);
    this.dnn.notifyDataSetChanged();
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("backup_select_ext_time_all"))
    {
      this.hJk = 0;
      avm();
      return true;
    }
    if (paramf.equals("backup_select_ext_time_some"))
    {
      this.hJk = 1;
      avm();
      return true;
    }
    if (paramf.equals("backup_select_ext_content_all_msg"))
    {
      if (this.hNn)
      {
        this.avS = 0;
        avn();
        return true;
      }
      y.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
      return true;
    }
    if (paramf.equals("backup_select_ext_content_text_only"))
    {
      if (this.hNn)
      {
        this.avS = 1;
        avn();
        return true;
      }
      y.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
      return true;
    }
    if (paramf.equals("backup_select_begin_time"))
    {
      showDialog(1);
      return true;
    }
    if (paramf.equals("backup_select_end_time"))
    {
      showDialog(2);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    this.hFq = getIntent().getIntExtra("BACKUP_MODE", 0);
    setMMTitle(R.l.backup_select_ext_more_choose);
    this.hJk = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
    this.hNn = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
    this.avS = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
    this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    this.hHt = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0L);
    aZ();
    setBackBtn(new BackupSelectExtUI.2(this));
    a(0, getString(R.l.bak_chat_choose_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if ((BackupSelectExtUI.g(BackupSelectExtUI.this) == 1) && (BackupSelectExtUI.d(BackupSelectExtUI.this) >= BackupSelectExtUI.e(BackupSelectExtUI.this)))
        {
          if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 1) {
            h.b(BackupSelectExtUI.this.mController.uMN, BackupSelectExtUI.this.getString(R.l.backup_pc_choose_time_finish_date_error), "", true);
          }
          while (BackupSelectExtUI.h(BackupSelectExtUI.this) != 2) {
            return true;
          }
          h.b(BackupSelectExtUI.this.mController.uMN, BackupSelectExtUI.this.getString(R.l.backup_move_choose_time_finish_date_error), "", true);
          return true;
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.g(BackupSelectExtUI.this));
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.i(BackupSelectExtUI.this));
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.d(BackupSelectExtUI.this));
        paramAnonymousMenuItem.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.e(BackupSelectExtUI.this));
        BackupSelectExtUI.this.setResult(-1, paramAnonymousMenuItem);
        BackupSelectExtUI.this.finish();
        return true;
      }
    }, s.b.uNx);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = Calendar.getInstance();
    switch (paramInt)
    {
    default: 
      int i = ((Calendar)localObject).get(1);
      int j = ((Calendar)localObject).get(2);
      localObject = new d(this.mController.uMN, new BackupSelectExtUI.1(this, paramInt), i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis(), (byte)0);
      ((d)localObject).setCanceledOnTouchOutside(false);
      l = bk.UY() / 86400000L * 86400000L + 57600000L - 1L;
      if (l > this.hHt)
      {
        ((d)localObject).ih(l);
        ((d)localObject).ii(this.hHt);
      }
      return localObject;
    case 1: 
      if (this.startTime == 0L) {}
      for (l = bk.UY();; l = this.startTime)
      {
        ((Calendar)localObject).setTimeInMillis(l);
        break;
      }
    }
    if (this.endTime == 0L) {}
    for (long l = bk.UY();; l = this.endTime - 86400000L)
    {
      ((Calendar)localObject).setTimeInMillis(l);
      break;
    }
  }
  
  public final int xj()
  {
    return R.o.backup_select_ext_preference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI
 * JD-Core Version:    0.7.0.1
 */