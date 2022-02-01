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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI
  extends MMPreference
{
  private int beK;
  private long endTime;
  private int oIY;
  private long oLe;
  private int oMY;
  private SimpleDateFormat oMZ;
  private RadioCheckPreference oQT;
  private RadioCheckPreference oQU;
  private RadioCheckPreference oQV;
  private RadioCheckPreference oQW;
  private Preference oQX;
  private Preference oQY;
  private boolean oQZ;
  private f screen;
  private long startTime;
  
  public BackupSelectExtUI()
  {
    AppMethodBeat.i(21786);
    this.oMY = 0;
    this.oQZ = false;
    this.beK = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.oLe = 0L;
    this.oMZ = new SimpleDateFormat("yyyy.MM.dd");
    AppMethodBeat.o(21786);
  }
  
  private void cgT()
  {
    AppMethodBeat.i(21791);
    switch (this.oMY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21791);
      return;
      this.oQT.xZ(true);
      this.oQU.xZ(false);
      this.screen.e(this.oQY);
      this.screen.e(this.oQX);
      enableOptionMenu(true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21791);
      return;
      updateView();
    }
  }
  
  private void cgU()
  {
    AppMethodBeat.i(21792);
    switch (this.beK)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21792);
      return;
      this.oQV.xZ(true);
      this.oQW.xZ(false);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(21792);
      return;
      this.oQV.xZ(false);
      this.oQW.xZ(true);
      this.screen.notifyDataSetChanged();
    }
  }
  
  private void cgV()
  {
    AppMethodBeat.i(21794);
    if ((this.startTime == 0L) || (this.endTime == 0L))
    {
      this.oQY.setSummary(2131756396);
      this.oQX.setSummary(2131756396);
    }
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(21794);
      return;
      this.oQY.setSummary(this.oMZ.format(new Date(this.startTime)));
      this.oQX.setSummary(this.oMZ.format(new Date(this.endTime - 86400000L)));
      if ((this.startTime == 0L) || (this.endTime == 0L)) {
        break;
      }
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(21793);
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017166);
    this.oQT = ((RadioCheckPreference)this.screen.bmg("backup_select_ext_time_all"));
    this.oQU = ((RadioCheckPreference)this.screen.bmg("backup_select_ext_time_some"));
    this.oQY = this.screen.bmg("backup_select_begin_time");
    this.oQX = this.screen.bmg("backup_select_end_time");
    this.oQV = ((RadioCheckPreference)this.screen.bmg("backup_select_ext_content_all_msg"));
    this.oQW = ((RadioCheckPreference)this.screen.bmg("backup_select_ext_content_text_only"));
    if (!this.oQZ)
    {
      this.screen.e(this.screen.bmg("backup_select_ext_content_title"));
      this.screen.e(this.oQV);
      this.screen.e(this.oQW);
    }
    if (this.oIY == 1)
    {
      this.screen.bmg("backup_select_ext_time_title").setTitle(2131756374);
      if (this.oQZ) {
        this.screen.bmg("backup_select_ext_content_title").setTitle(2131756372);
      }
      switch (this.oMY)
      {
      default: 
        label256:
        if (this.oQZ) {
          switch (this.beK)
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
      if (this.oIY != 2) {
        break;
      }
      this.screen.bmg("backup_select_ext_time_title").setTitle(2131756302);
      if (!this.oQZ) {
        break;
      }
      this.screen.bmg("backup_select_ext_content_title").setTitle(2131756300);
      break;
      this.oQT.xZ(true);
      this.oQU.xZ(false);
      this.oQY.setEnabled(false);
      this.oQX.setEnabled(false);
      this.screen.e(this.oQY);
      this.screen.e(this.oQX);
      enableOptionMenu(true);
      break label256;
      cgV();
      this.oQT.xZ(false);
      this.oQU.xZ(true);
      this.oQY.setEnabled(true);
      this.oQX.setEnabled(true);
      break label256;
      this.oQV.xZ(true);
      this.oQW.xZ(false);
      continue;
      this.oQV.xZ(false);
      this.oQW.xZ(true);
    }
  }
  
  public int getResourceId()
  {
    return 2132017166;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21790);
    this.oIY = getIntent().getIntExtra("BACKUP_MODE", 0);
    setMMTitle(2131756392);
    this.oMY = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
    this.oQZ = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
    this.beK = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
    this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0L);
    this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0L);
    this.oLe = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0L);
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
    addTextOptionMenu(0, getString(2131756418), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21785);
        if ((BackupSelectExtUI.g(BackupSelectExtUI.this) == 1) && (BackupSelectExtUI.d(BackupSelectExtUI.this) >= BackupSelectExtUI.e(BackupSelectExtUI.this)))
        {
          if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 1) {
            h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(2131756322), "", true);
          }
          for (;;)
          {
            AppMethodBeat.o(21785);
            return true;
            if (BackupSelectExtUI.h(BackupSelectExtUI.this) == 2) {
              h.c(BackupSelectExtUI.this.getContext(), BackupSelectExtUI.this.getString(2131756239), "", true);
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
    }, null, t.b.OGU);
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
            l = g.agD("000000");
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
          long l = g.agD("000000");
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
      long l1 = Util.nowMilliSecond() / 86400000L * 86400000L + 57600000L - 1L;
      long l2 = this.oLe / 86400000L * 86400000L + 57600000L - 86400000L;
      if (l1 > l2) {}
      try
      {
        ((e)localObject).Ob(l2);
        ((e)localObject).Oa(l1);
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
      this.oMY = 0;
      cgT();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_time_some"))
    {
      this.oMY = 1;
      cgT();
      AppMethodBeat.o(21788);
      return true;
    }
    if (paramf.equals("backup_select_ext_content_all_msg"))
    {
      if (this.oQZ)
      {
        this.beK = 0;
        cgU();
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
      if (this.oQZ)
      {
        this.beK = 1;
        cgU();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI
 * JD-Core Version:    0.7.0.1
 */