package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.HashSet;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.b
{
  private ProgressDialog lzP;
  private Button pYm;
  private int pos;
  private String username;
  private long wRD;
  private com.tencent.mm.plugin.clean.b.b wSA;
  private GridHeadersGridView wSv;
  private b wSw;
  private View wSx;
  CheckBox wSy;
  MMAutoAdjustTextView wSz;
  
  public final void Jb(int paramInt)
  {
    AppMethodBeat.i(22883);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.pYm.setEnabled(bool);
      AppMethodBeat.o(22883);
      return;
    }
  }
  
  public final void gC(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22885);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22880);
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).setMessage(CleanChattingDetailUI.this.getString(R.l.gAm, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
        AppMethodBeat.o(22880);
      }
    });
    AppMethodBeat.o(22885);
  }
  
  public int getLayoutId()
  {
    return R.i.ghE;
  }
  
  public final void kF(final long paramLong)
  {
    AppMethodBeat.i(22886);
    Log.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.dqN().wRt -= paramLong;
    d.dqN().wRJ -= paramLong;
    this.wRD += paramLong;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22881);
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).dismiss();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_pos", CleanChattingDetailUI.d(CleanChattingDetailUI.this));
        localIntent.putExtra("key_delete_size", CleanChattingDetailUI.e(CleanChattingDetailUI.this));
        CleanChattingDetailUI.this.setResult(1000, localIntent);
        k.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.l.gAi, new Object[] { Util.getSizeKB(paramLong) }), "", true);
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
    if (Util.isNullOrNil(this.username))
    {
      Log.w("MicroMsg.CleanChattingDetailUI", "username is null");
      finish();
      AppMethodBeat.o(22882);
      return;
    }
    this.wSx = ((View)$(R.h.frh));
    this.wSy = ((CheckBox)$(R.h.frg));
    this.wSz = ((MMAutoAdjustTextView)$(R.h.fEW));
    this.pYm = ((Button)$(R.h.del_btn));
    Jb(0);
    if (au.bwE(this.username)) {
      setMMTitle(aa.aV(this.username, this.username));
    }
    for (;;)
    {
      this.wSv = ((GridHeadersGridView)findViewById(R.h.fBn));
      this.wSv.setNumColumns(3);
      this.wSw = new b(this, this.username);
      this.wSv.setOnHeaderClickListener(this.wSw.wSk);
      this.wSv.setOnItemClickListener(this.wSw.vEc);
      this.wSv.setOnScrollListener(this.wSw.wSm);
      this.wSv.setAdapter(this.wSw);
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
      this.wSx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = CleanChattingDetailUI.a(CleanChattingDetailUI.this);
          if (paramAnonymousView.uZQ.size() == paramAnonymousView.pUj.size()) {
            paramAnonymousView.uZQ.clear();
          }
          for (;;)
          {
            paramAnonymousView.dqU();
            CleanChattingDetailUI.a(CleanChattingDetailUI.this).notifyDataSetChanged();
            a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(22877);
            return;
            int i = 0;
            while (i < paramAnonymousView.pUj.size())
            {
              paramAnonymousView.uZQ.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      this.pYm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22879);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          k.b(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(R.l.gAx), "", CleanChattingDetailUI.this.getString(R.l.fEU), CleanChattingDetailUI.this.getString(R.l.cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(22878);
              CleanChattingDetailUI.b(CleanChattingDetailUI.this);
              h.OAn.idkeyStat(714L, 31L, 1L, false);
              AppMethodBeat.o(22878);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22879);
        }
      });
      getString(R.l.app_tip);
      this.lzP = k.a(this, getString(R.l.gAh), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      this.lzP.dismiss();
      if (this.wSw != null) {
        ThreadPool.post(new b.b(this.wSw, (byte)0), "load_clean_detail");
      }
      h.OAn.idkeyStat(714L, 30L, 1L, false);
      AppMethodBeat.o(22882);
      return;
      setMMTitle(aa.getDisplayName(this.username));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22884);
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    if (this.wSw != null) {
      this.wSw.isStop = true;
    }
    super.onDestroy();
    AppMethodBeat.o(22884);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */