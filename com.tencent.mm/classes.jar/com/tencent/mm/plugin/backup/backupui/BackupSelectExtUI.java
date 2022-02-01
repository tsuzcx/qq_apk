package com.tencent.mm.plugin.backup.backupui;

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
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI
  extends MMPreference
{
  private int cIh;
  private long endTime;
  private f screen;
  private long startTime;
  private int uWc;
  private long uYi;
  private int vai;
  private SimpleDateFormat vaj;
  private RadioCheckPreference veh;
  private RadioCheckPreference vei;
  private RadioCheckPreference vej;
  private RadioCheckPreference vek;
  private Preference vel;
  private Preference vem;
  private boolean ven;
  
  public BackupSelectExtUI()
  {
    AppMethodBeat.i(21786);
    this.vai = 0;
    this.ven = false;
    this.cIh = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.uYi = 0L;
    this.vaj = new SimpleDateFormat("yyyy.MM.dd");
    AppMethodBeat.o(21786);
  }
  
  private void cWO()
  {
    AppMethodBeat.i(21791);
    switch (this.vai)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21791);
      return;
      this.veh.Hy(true);
      this.vei.Hy(false);
      this.screen.e(this.vem);
      this.screen.e(this.vel);
      enableOptionMenu(true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21791);
      return;
      updateView();
    }
  }
  
  private void cWP()
  {
    AppMethodBeat.i(21792);
    switch (this.cIh)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21792);
      return;
      this.vej.Hy(true);
      this.vek.Hy(false);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21792);
      return;
      this.vej.Hy(false);
      this.vek.Hy(true);
      this.screen.notifyDataSetChanged();
    }
  }
  
  private void cWQ()
  {
    AppMethodBeat.i(21794);
    if ((this.startTime == 0L) || (this.endTime == 0L))
    {
      this.vem.aBk(R.l.guV);
      this.vel.aBk(R.l.guV);
    }
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(21794);
      return;
      this.vem.aS(this.vaj.format(new Date(this.startTime)));
      this.vel.aS(this.vaj.format(new Date(this.endTime - 86400000L)));
      if ((this.startTime == 0L) || (this.endTime == 0L)) {
        break;
      }
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(21793);
    this.screen.removeAll();
    this.screen.aBe(R.o.haJ);
    this.veh = ((RadioCheckPreference)this.screen.bAi("backup_select_ext_time_all"));
    this.vei = ((RadioCheckPreference)this.screen.bAi("backup_select_ext_time_some"));
    this.vem = this.screen.bAi("backup_select_begin_time");
    this.vel = this.screen.bAi("backup_select_end_time");
    this.vej = ((RadioCheckPreference)this.screen.bAi("backup_select_ext_content_all_msg"));
    this.vek = ((RadioCheckPreference)this.screen.bAi("backup_select_ext_content_text_only"));
    if (!this.ven)
    {
      this.screen.e(this.screen.bAi("backup_select_ext_content_title"));
      this.screen.e(this.vej);
      this.screen.e(this.vek);
    }
    if (this.uWc == 1)
    {
      this.screen.bAi("backup_select_ext_time_title").setTitle(R.l.guG);
      if (this.ven) {
        this.screen.bAi("backup_select_ext_content_title").setTitle(R.l.guF);
      }
      switch (this.vai)
      {
      default: 
        label260:
        if (this.ven) {
          switch (this.cIh)
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
      if (this.uWc != 2) {
        break;
      }
      this.screen.bAi("backup_select_ext_time_title").setTitle(R.l.gtD);
      if (!this.ven) {
        break;
      }
      this.screen.bAi("backup_select_ext_content_title").setTitle(R.l.gtC);
      break;
      this.veh.Hy(true);
      this.vei.Hy(false);
      this.vem.setEnabled(false);
      this.vel.setEnabled(false);
      this.screen.e(this.vem);
      this.screen.e(this.vel);
      enableOptionMenu(true);
      break label260;
      cWQ();
      this.veh.Hy(false);
      this.vei.Hy(true);
      this.vem.setEnabled(true);
      this.vel.setEnabled(true);
      break label260;
      this.vej.Hy(true);
      this.vek.Hy(false);
      continue;
      this.vej.Hy(false);
      this.vek.Hy(true);
    }
  }
  
  public int getResourceId()
  {
    return R.o.haJ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21790);
    this.uWc = getIntent().getIntExtra("BACKUP_MODE", 0);
    setMMTitle(R.l.guU);
    this.vai = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
    this.ven = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
    this.cIh = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
    this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    this.uYi = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0L);
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
    addTextOptionMenu(0, getString(R.l.gvh), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21785);
        if ((BackupSelectExtUI.g(BackupSelectExtUI.this) == 1) && (BackupSelectExtUI.d(BackupSelectExtUI.this) >= BackupSelectExtUI.e(BackupSelectExtUI.this)))
        {
          if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 1) {
            k.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(R.l.gtR), "", true);
          }
          for (;;)
          {
            AppMethodBeat.o(21785);
            return true;
            if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 2) {
              k.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(R.l.gsx), "", true);
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
    }, null, y.b.adEJ);
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
            l = com.tencent.mm.plugin.backup.b.g.ahE("000000");
            BackupSelectExtUI.a(BackupSelectExtUI.this, l / 1000L * 1000L);
            BackupSelectExtUI.b(BackupSelectExtUI.this).aS(BackupSelectExtUI.a(BackupSelectExtUI.this).format(new Date(l)));
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
          long l = com.tencent.mm.plugin.backup.b.g.ahE("000000");
          BackupSelectExtUI.b(BackupSelectExtUI.this, l / 1000L * 1000L + 86400000L);
          BackupSelectExtUI.f(BackupSelectExtUI.this).aS(BackupSelectExtUI.a(BackupSelectExtUI.this).format(new Date(l)));
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
      long l2 = this.uYi / 86400000L * 86400000L + 57600000L - 86400000L;
      if (l1 > l2) {}
      try
      {
        ((com.tencent.mm.ui.widget.g)localObject).Az(l2);
        ((com.tencent.mm.ui.widget.g)localObject).Ay(l1);
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
      this.vai = 0;
      cWO();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_time_some"))
    {
      this.vai = 1;
      cWO();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_content_all_msg"))
    {
      if (this.ven)
      {
        this.cIh = 0;
        cWP();
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
      if (this.ven)
      {
        this.cIh = 1;
        cWP();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI
 * JD-Core Version:    0.7.0.1
 */