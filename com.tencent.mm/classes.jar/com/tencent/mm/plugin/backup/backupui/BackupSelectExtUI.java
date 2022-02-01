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
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.w.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI
  extends MMPreference
{
  private int aOl;
  private long endTime;
  private int rKO;
  private long rMU;
  private int rOU;
  private SimpleDateFormat rOV;
  private RadioCheckPreference rSS;
  private RadioCheckPreference rST;
  private RadioCheckPreference rSU;
  private RadioCheckPreference rSV;
  private Preference rSW;
  private Preference rSX;
  private boolean rSY;
  private f screen;
  private long startTime;
  
  public BackupSelectExtUI()
  {
    AppMethodBeat.i(21786);
    this.rOU = 0;
    this.rSY = false;
    this.aOl = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.rMU = 0L;
    this.rOV = new SimpleDateFormat("yyyy.MM.dd");
    AppMethodBeat.o(21786);
  }
  
  private void cue()
  {
    AppMethodBeat.i(21791);
    switch (this.rOU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21791);
      return;
      this.rSS.BT(true);
      this.rST.BT(false);
      this.screen.d(this.rSX);
      this.screen.d(this.rSW);
      enableOptionMenu(true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21791);
      return;
      updateView();
    }
  }
  
  private void cuf()
  {
    AppMethodBeat.i(21792);
    switch (this.aOl)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21792);
      return;
      this.rSU.BT(true);
      this.rSV.BT(false);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21792);
      return;
      this.rSU.BT(false);
      this.rSV.BT(true);
      this.screen.notifyDataSetChanged();
    }
  }
  
  private void cug()
  {
    AppMethodBeat.i(21794);
    if ((this.startTime == 0L) || (this.endTime == 0L))
    {
      this.rSX.auI(R.l.erU);
      this.rSW.auI(R.l.erU);
    }
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(21794);
      return;
      this.rSX.aF(this.rOV.format(new Date(this.startTime)));
      this.rSW.aF(this.rOV.format(new Date(this.endTime - 86400000L)));
      if ((this.startTime == 0L) || (this.endTime == 0L)) {
        break;
      }
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(21793);
    this.screen.removeAll();
    this.screen.auC(R.o.eXg);
    this.rSS = ((RadioCheckPreference)this.screen.byG("backup_select_ext_time_all"));
    this.rST = ((RadioCheckPreference)this.screen.byG("backup_select_ext_time_some"));
    this.rSX = this.screen.byG("backup_select_begin_time");
    this.rSW = this.screen.byG("backup_select_end_time");
    this.rSU = ((RadioCheckPreference)this.screen.byG("backup_select_ext_content_all_msg"));
    this.rSV = ((RadioCheckPreference)this.screen.byG("backup_select_ext_content_text_only"));
    if (!this.rSY)
    {
      this.screen.d(this.screen.byG("backup_select_ext_content_title"));
      this.screen.d(this.rSU);
      this.screen.d(this.rSV);
    }
    if (this.rKO == 1)
    {
      this.screen.byG("backup_select_ext_time_title").setTitle(R.l.erF);
      if (this.rSY) {
        this.screen.byG("backup_select_ext_content_title").setTitle(R.l.erE);
      }
      switch (this.rOU)
      {
      default: 
        label260:
        if (this.rSY) {
          switch (this.aOl)
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
      if (this.rKO != 2) {
        break;
      }
      this.screen.byG("backup_select_ext_time_title").setTitle(R.l.eqC);
      if (!this.rSY) {
        break;
      }
      this.screen.byG("backup_select_ext_content_title").setTitle(R.l.eqB);
      break;
      this.rSS.BT(true);
      this.rST.BT(false);
      this.rSX.setEnabled(false);
      this.rSW.setEnabled(false);
      this.screen.d(this.rSX);
      this.screen.d(this.rSW);
      enableOptionMenu(true);
      break label260;
      cug();
      this.rSS.BT(false);
      this.rST.BT(true);
      this.rSX.setEnabled(true);
      this.rSW.setEnabled(true);
      break label260;
      this.rSU.BT(true);
      this.rSV.BT(false);
      continue;
      this.rSU.BT(false);
      this.rSV.BT(true);
    }
  }
  
  public int getResourceId()
  {
    return R.o.eXg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21790);
    this.rKO = getIntent().getIntExtra("BACKUP_MODE", 0);
    setMMTitle(R.l.erT);
    this.rOU = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
    this.rSY = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
    this.aOl = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
    this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    this.rMU = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0L);
    updateView();
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
    addTextOptionMenu(0, getString(R.l.esg), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21785);
        if ((BackupSelectExtUI.g(BackupSelectExtUI.this) == 1) && (BackupSelectExtUI.d(BackupSelectExtUI.this) >= BackupSelectExtUI.e(BackupSelectExtUI.this)))
        {
          if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 1) {
            h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(R.l.eqQ), "", true);
          }
          for (;;)
          {
            AppMethodBeat.o(21785);
            return true;
            if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 2) {
              h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(R.l.epw), "", true);
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
    }, null, w.b.Wao);
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
      localObject = new com.tencent.mm.ui.widget.g(getContext(), new DatePickerDialog.OnDateSetListener()
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
            l = com.tencent.mm.plugin.backup.b.g.aoh("000000");
            BackupSelectExtUI.a(BackupSelectExtUI.this, l / 1000L * 1000L);
            BackupSelectExtUI.b(BackupSelectExtUI.this).aF(BackupSelectExtUI.a(BackupSelectExtUI.this).format(new Date(l)));
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
          long l = com.tencent.mm.plugin.backup.b.g.aoh("000000");
          BackupSelectExtUI.b(BackupSelectExtUI.this, l / 1000L * 1000L + 86400000L);
          BackupSelectExtUI.f(BackupSelectExtUI.this).aF(BackupSelectExtUI.a(BackupSelectExtUI.this).format(new Date(l)));
          BackupSelectExtUI.c(BackupSelectExtUI.this).notifyDataSetChanged();
          paramAnonymousDatePicker = BackupSelectExtUI.this;
          if ((BackupSelectExtUI.d(BackupSelectExtUI.this) != 0L) && (BackupSelectExtUI.e(BackupSelectExtUI.this) != 0L)) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousDatePicker.enableOptionMenu(bool);
            break;
          }
        }
      }, i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis());
      ((com.tencent.mm.ui.widget.g)localObject).setCanceledOnTouchOutside(false);
      long l1 = Util.nowMilliSecond() / 86400000L * 86400000L + 57600000L - 1L;
      long l2 = this.rMU / 86400000L * 86400000L + 57600000L - 86400000L;
      if (l1 > l2) {}
      try
      {
        ((com.tencent.mm.ui.widget.g)localObject).Wn(l2);
        ((com.tencent.mm.ui.widget.g)localObject).Wm(l1);
        AppMethodBeat.o(21789);
        return localObject;
        if (this.startTime == 0L) {}
        for (l1 = Util.nowMilliSecond();; l1 = this.startTime)
        {
          ((Calendar)localObject).setTimeInMillis(l1);
          break;
        }
        if (this.endTime == 0L) {}
        for (l1 = Util.nowMilliSecond();; l1 = this.endTime - 86400000L)
        {
          ((Calendar)localObject).setTimeInMillis(l1);
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.BackupSelectExtUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), localException });
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
      this.rOU = 0;
      cue();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_time_some"))
    {
      this.rOU = 1;
      cue();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_content_all_msg"))
    {
      if (this.rSY)
      {
        this.aOl = 0;
        cuf();
      }
      for (;;)
      {
        AppMethodBeat.o(21788);
        return true;
        Log.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
      }
    }
    if (paramf.equals("backup_select_ext_content_text_only"))
    {
      if (this.rSY)
      {
        this.aOl = 1;
        cuf();
      }
      for (;;)
      {
        AppMethodBeat.o(21788);
        return true;
        Log.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI
 * JD-Core Version:    0.7.0.1
 */