package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.HashSet;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.b
{
  private ProgressDialog fts;
  private Button iPj;
  private long oqI;
  private b orA;
  private View orB;
  CheckBox orC;
  MMAutoAdjustTextView orD;
  private com.tencent.mm.plugin.clean.b.b orE;
  private GridHeadersGridView orz;
  private int pos;
  private String username;
  
  public final void Ao(int paramInt)
  {
    AppMethodBeat.i(22883);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.iPj.setEnabled(bool);
      AppMethodBeat.o(22883);
      return;
    }
  }
  
  public final void eW(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22885);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22880);
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).setMessage(CleanChattingDetailUI.this.getString(2131757404, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
        AppMethodBeat.o(22880);
      }
    });
    AppMethodBeat.o(22885);
  }
  
  public int getLayoutId()
  {
    return 2131493543;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22882);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("key_username");
    this.pos = getIntent().getIntExtra("key_pos", 0);
    if (bs.isNullOrNil(this.username))
    {
      ac.w("MicroMsg.CleanChattingDetailUI", "username is null");
      finish();
      AppMethodBeat.o(22882);
      return;
    }
    this.orB = ((View)$(2131296648));
    this.orC = ((CheckBox)$(2131296647));
    this.orD = ((MMAutoAdjustTextView)$(2131298988));
    this.iPj = ((Button)$(2131298954));
    Ao(0);
    if (w.sQ(this.username)) {
      setMMTitle(v.getDisplayName(this.username, this.username));
    }
    for (;;)
    {
      this.orz = ((GridHeadersGridView)findViewById(2131298340));
      this.orz.setNumColumns(3);
      this.orA = new b(this, this.username);
      this.orz.setOnHeaderClickListener(this.orA.oro);
      this.orz.setOnItemClickListener(this.orA.nxr);
      this.orz.setOnScrollListener(this.orA.orq);
      this.orz.setAdapter(this.orA);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(22876);
          CleanChattingDetailUI.this.finish();
          AppMethodBeat.o(22876);
          return false;
        }
      });
      this.orB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22877);
          paramAnonymousView = CleanChattingDetailUI.a(CleanChattingDetailUI.this);
          if (paramAnonymousView.mVP.size() == paramAnonymousView.dataList.size()) {
            paramAnonymousView.mVP.clear();
          }
          for (;;)
          {
            paramAnonymousView.bVk();
            CleanChattingDetailUI.a(CleanChattingDetailUI.this).notifyDataSetChanged();
            AppMethodBeat.o(22877);
            return;
            int i = 0;
            while (i < paramAnonymousView.dataList.size())
            {
              paramAnonymousView.mVP.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      this.iPj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22879);
          com.tencent.mm.ui.base.h.d(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(2131757555), "", CleanChattingDetailUI.this.getString(2131758029), CleanChattingDetailUI.this.getString(2131756766), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(22878);
              CleanChattingDetailUI.b(CleanChattingDetailUI.this);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 31L, 1L, false);
              AppMethodBeat.o(22878);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(22879);
        }
      });
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131757384), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      this.fts.dismiss();
      if (this.orA != null) {
        com.tencent.mm.sdk.g.b.c(new b.b(this.orA, (byte)0), "load_clean_detail");
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(714L, 30L, 1L, false);
      AppMethodBeat.o(22882);
      return;
      setMMTitle(v.wk(this.username));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22884);
    if ((this.fts != null) && (this.fts.isShowing())) {
      this.fts.dismiss();
    }
    if (this.orA != null) {
      this.orA.isStop = true;
    }
    super.onDestroy();
    AppMethodBeat.o(22884);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rJ(final long paramLong)
  {
    AppMethodBeat.i(22886);
    ac.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.bVd().oqz -= paramLong;
    d.bVd().oqy -= paramLong;
    this.oqI += paramLong;
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22881);
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).dismiss();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_pos", CleanChattingDetailUI.d(CleanChattingDetailUI.this));
        localIntent.putExtra("key_delete_size", CleanChattingDetailUI.e(CleanChattingDetailUI.this));
        CleanChattingDetailUI.this.setResult(1000, localIntent);
        com.tencent.mm.ui.base.h.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(2131757385, new Object[] { bs.qz(paramLong) }), "", true);
        AppMethodBeat.o(22881);
      }
    });
    AppMethodBeat.o(22886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */