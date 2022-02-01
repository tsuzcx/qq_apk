package com.tencent.mm.plugin.backup.backupui;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.DatePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI
  extends MMPreference
{
  private int aTB;
  private long endTime;
  private int mqf;
  private long msm;
  private int muf;
  private SimpleDateFormat mug;
  private RadioCheckPreference myd;
  private RadioCheckPreference mye;
  private RadioCheckPreference myf;
  private RadioCheckPreference myg;
  private Preference myh;
  private Preference myi;
  private boolean myj;
  private f screen;
  private long startTime;
  
  public BackupSelectExtUI()
  {
    AppMethodBeat.i(21786);
    this.muf = 0;
    this.myj = false;
    this.aTB = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.msm = 0L;
    this.mug = new SimpleDateFormat("yyyy.MM.dd");
    AppMethodBeat.o(21786);
  }
  
  private void bxX()
  {
    AppMethodBeat.i(21791);
    switch (this.muf)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21791);
      return;
      this.myd.vP(true);
      this.mye.vP(false);
      this.screen.d(this.myi);
      this.screen.d(this.myh);
      enableOptionMenu(true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21791);
      return;
      cE();
    }
  }
  
  private void bxY()
  {
    AppMethodBeat.i(21792);
    switch (this.aTB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21792);
      return;
      this.myf.vP(true);
      this.myg.vP(false);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21792);
      return;
      this.myf.vP(false);
      this.myg.vP(true);
      this.screen.notifyDataSetChanged();
    }
  }
  
  private void bxZ()
  {
    AppMethodBeat.i(21794);
    if ((this.startTime == 0L) || (this.endTime == 0L))
    {
      this.myi.setSummary(2131756262);
      this.myh.setSummary(2131756262);
    }
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(21794);
      return;
      this.myi.setSummary(this.mug.format(new Date(this.startTime)));
      this.myh.setSummary(this.mug.format(new Date(this.endTime - 86400000L)));
      if ((this.startTime == 0L) || (this.endTime == 0L)) {
        break;
      }
    }
  }
  
  private void cE()
  {
    AppMethodBeat.i(21793);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951629);
    this.myd = ((RadioCheckPreference)this.screen.aKk("backup_select_ext_time_all"));
    this.mye = ((RadioCheckPreference)this.screen.aKk("backup_select_ext_time_some"));
    this.myi = this.screen.aKk("backup_select_begin_time");
    this.myh = this.screen.aKk("backup_select_end_time");
    this.myf = ((RadioCheckPreference)this.screen.aKk("backup_select_ext_content_all_msg"));
    this.myg = ((RadioCheckPreference)this.screen.aKk("backup_select_ext_content_text_only"));
    if (!this.myj)
    {
      this.screen.d(this.screen.aKk("backup_select_ext_content_title"));
      this.screen.d(this.myf);
      this.screen.d(this.myg);
    }
    if (this.mqf == 1)
    {
      this.screen.aKk("backup_select_ext_time_title").setTitle(2131756240);
      if (this.myj) {
        this.screen.aKk("backup_select_ext_content_title").setTitle(2131756238);
      }
      switch (this.muf)
      {
      default: 
        label256:
        if (this.myj) {
          switch (this.aTB)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21793);
      return;
      if (this.mqf != 2) {
        break;
      }
      this.screen.aKk("backup_select_ext_time_title").setTitle(2131756168);
      if (!this.myj) {
        break;
      }
      this.screen.aKk("backup_select_ext_content_title").setTitle(2131756166);
      break;
      this.myd.vP(true);
      this.mye.vP(false);
      this.myi.setEnabled(false);
      this.myh.setEnabled(false);
      this.screen.d(this.myi);
      this.screen.d(this.myh);
      enableOptionMenu(true);
      break label256;
      bxZ();
      this.myd.vP(false);
      this.mye.vP(true);
      this.myi.setEnabled(true);
      this.myh.setEnabled(true);
      break label256;
      this.myf.vP(true);
      this.myg.vP(false);
      continue;
      this.myf.vP(false);
      this.myg.vP(true);
    }
  }
  
  public int getResourceId()
  {
    return 2131951629;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21790);
    this.mqf = getIntent().getIntExtra("BACKUP_MODE", 0);
    setMMTitle(2131756258);
    this.muf = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
    this.myj = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
    this.aTB = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
    this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    this.msm = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0L);
    cE();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21784);
        BackupSelectExtUI.this.finish();
        AppMethodBeat.o(21784);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131756283), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21785);
        if ((BackupSelectExtUI.g(BackupSelectExtUI.this) == 1) && (BackupSelectExtUI.d(BackupSelectExtUI.this) >= BackupSelectExtUI.e(BackupSelectExtUI.this)))
        {
          if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 1) {
            h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(2131756188), "", true);
          }
          for (;;)
          {
            AppMethodBeat.o(21785);
            return true;
            if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 2) {
              h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(2131756105), "", true);
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
        AppMethodBeat.o(21785);
        return true;
      }
    }, null, r.b.FOB);
    AppMethodBeat.o(21790);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21787);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(21787);
  }
  
  protected Dialog onCreateDialog(final int paramInt)
  {
    AppMethodBeat.i(21789);
    Object localObject = Calendar.getInstance();
    switch (paramInt)
    {
    }
    for (;;)
    {
      int i = ((Calendar)localObject).get(1);
      int j = ((Calendar)localObject).get(2);
      localObject = new e(getContext(), new DatePickerDialog.OnDateSetListener()
      {
        public final void onDateSet(DatePicker paramAnonymousDatePicker, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(21783);
          paramAnonymousDatePicker = new StringBuffer().append(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt1) })).append(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt2 + 1) })).append(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt3) }));
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(21783);
            return;
          case 1: 
            l = g.On("000000");
            BackupSelectExtUI.a(BackupSelectExtUI.this, l / 1000L * 1000L);
            BackupSelectExtUI.b(BackupSelectExtUI.this).setSummary(BackupSelectExtUI.a(BackupSelectExtUI.this).format(new Date(l)));
            BackupSelectExtUI.c(BackupSelectExtUI.this).notifyDataSetChanged();
            paramAnonymousDatePicker = BackupSelectExtUI.this;
            if ((BackupSelectExtUI.d(BackupSelectExtUI.this) != 0L) && (BackupSelectExtUI.e(BackupSelectExtUI.this) != 0L)) {}
            for (bool = true;; bool = false)
            {
              paramAnonymousDatePicker.enableOptionMenu(bool);
              AppMethodBeat.o(21783);
              return;
            }
          }
          long l = g.On("000000");
          BackupSelectExtUI.b(BackupSelectExtUI.this, l / 1000L * 1000L + 86400000L);
          BackupSelectExtUI.f(BackupSelectExtUI.this).setSummary(BackupSelectExtUI.a(BackupSelectExtUI.this).format(new Date(l)));
          BackupSelectExtUI.c(BackupSelectExtUI.this).notifyDataSetChanged();
          paramAnonymousDatePicker = BackupSelectExtUI.this;
          if ((BackupSelectExtUI.d(BackupSelectExtUI.this) != 0L) && (BackupSelectExtUI.e(BackupSelectExtUI.this) != 0L)) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDatePicker.enableOptionMenu(bool);
            break;
          }
        }
      }, i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis(), (byte)0);
      ((e)localObject).setCanceledOnTouchOutside(false);
      long l1 = bt.eGO() / 86400000L * 86400000L + 57600000L - 1L;
      long l2 = this.msm / 86400000L * 86400000L + 57600000L - 86400000L;
      if (l1 > l2) {}
      try
      {
        ((e)localObject).wX(l2);
        ((e)localObject).wW(l1);
        AppMethodBeat.o(21789);
        return localObject;
        if (this.startTime == 0L) {}
        for (l1 = bt.eGO();; l1 = this.startTime)
        {
          ((Calendar)localObject).setTimeInMillis(l1);
          break;
        }
        if (this.endTime == 0L) {}
        for (l1 = bt.eGO();; l1 = this.endTime - 86400000L)
        {
          ((Calendar)localObject).setTimeInMillis(l1);
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.BackupSelectExtUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), localException });
        }
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(21788);
    paramf = paramPreference.mKey;
    if (paramf.equals("backup_select_ext_time_all"))
    {
      this.muf = 0;
      bxX();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_time_some"))
    {
      this.muf = 1;
      bxX();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_content_all_msg"))
    {
      if (this.myj)
      {
        this.aTB = 0;
        bxY();
      }
      for (;;)
      {
        AppMethodBeat.o(21788);
        return true;
        ad.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
      }
    }
    if (paramf.equals("backup_select_ext_content_text_only"))
    {
      if (this.myj)
      {
        this.aTB = 1;
        bxY();
      }
      for (;;)
      {
        AppMethodBeat.o(21788);
        return true;
        ad.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
      }
    }
    if (paramf.equals("backup_select_begin_time"))
    {
      showDialog(1);
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_end_time"))
    {
      showDialog(2);
      AppMethodBeat.o(21788);
      return true;
    }
    AppMethodBeat.o(21788);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI
 * JD-Core Version:    0.7.0.1
 */