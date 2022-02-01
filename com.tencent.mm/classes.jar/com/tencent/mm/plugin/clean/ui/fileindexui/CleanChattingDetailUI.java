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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.HashSet;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.b
{
  private ProgressDialog fpP;
  private Button ipd;
  private long nNG;
  CheckBox nOA;
  MMAutoAdjustTextView nOB;
  private com.tencent.mm.plugin.clean.b.b nOC;
  private GridHeadersGridView nOx;
  private b nOy;
  private View nOz;
  private int pos;
  private String username;
  
  public final void eT(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22885);
    aq.f(new Runnable()
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
  
  public final void nX(final long paramLong)
  {
    AppMethodBeat.i(22886);
    ad.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.bNS().nNx -= paramLong;
    d.bNS().nNw -= paramLong;
    this.nNG += paramLong;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22881);
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).dismiss();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_pos", CleanChattingDetailUI.d(CleanChattingDetailUI.this));
        localIntent.putExtra("key_delete_size", CleanChattingDetailUI.e(CleanChattingDetailUI.this));
        CleanChattingDetailUI.this.setResult(1000, localIntent);
        com.tencent.mm.ui.base.h.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(2131757385, new Object[] { bt.mK(paramLong) }), "", true);
        AppMethodBeat.o(22881);
      }
    });
    AppMethodBeat.o(22886);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22882);
    super.onCreate(paramBundle);
    this.username = getIntent().getStringExtra("key_username");
    this.pos = getIntent().getIntExtra("key_pos", 0);
    if (bt.isNullOrNil(this.username))
    {
      ad.w("MicroMsg.CleanChattingDetailUI", "username is null");
      finish();
      AppMethodBeat.o(22882);
      return;
    }
    this.nOz = ((View)$(2131296648));
    this.nOA = ((CheckBox)$(2131296647));
    this.nOB = ((MMAutoAdjustTextView)$(2131298988));
    this.ipd = ((Button)$(2131298954));
    zx(0);
    if (w.pF(this.username)) {
      setMMTitle(v.getDisplayName(this.username, this.username));
    }
    for (;;)
    {
      this.nOx = ((GridHeadersGridView)findViewById(2131298340));
      this.nOx.setNumColumns(3);
      this.nOy = new b(this, this.username);
      this.nOx.setOnHeaderClickListener(this.nOy.nOm);
      this.nOx.setOnItemClickListener(this.nOy.mUR);
      this.nOx.setOnScrollListener(this.nOy.nOo);
      this.nOx.setAdapter(this.nOy);
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
      this.nOz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22877);
          paramAnonymousView = CleanChattingDetailUI.a(CleanChattingDetailUI.this);
          if (paramAnonymousView.mtN.size() == paramAnonymousView.dataList.size()) {
            paramAnonymousView.mtN.clear();
          }
          for (;;)
          {
            paramAnonymousView.bNZ();
            CleanChattingDetailUI.a(CleanChattingDetailUI.this).notifyDataSetChanged();
            AppMethodBeat.o(22877);
            return;
            int i = 0;
            while (i < paramAnonymousView.dataList.size())
            {
              paramAnonymousView.mtN.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      this.ipd.setOnClickListener(new View.OnClickListener()
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
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 31L, 1L, false);
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
      this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131757384), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      this.fpP.dismiss();
      if (this.nOy != null) {
        com.tencent.mm.sdk.g.b.c(new b.b(this.nOy, (byte)0), "load_clean_detail");
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 30L, 1L, false);
      AppMethodBeat.o(22882);
      return;
      setMMTitle(v.sh(this.username));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22884);
    if ((this.fpP != null) && (this.fpP.isShowing())) {
      this.fpP.dismiss();
    }
    if (this.nOy != null) {
      this.nOy.isStop = true;
    }
    super.onDestroy();
    AppMethodBeat.o(22884);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void zx(int paramInt)
  {
    AppMethodBeat.i(22883);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ipd.setEnabled(bool);
      AppMethodBeat.o(22883);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */