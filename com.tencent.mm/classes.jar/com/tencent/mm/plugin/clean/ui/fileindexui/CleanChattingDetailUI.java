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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.HashSet;

public class CleanChattingDetailUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.b
{
  private ProgressDialog gtM;
  private Button kjo;
  private int pos;
  private long qpE;
  CheckBox qqA;
  MMAutoAdjustTextView qqB;
  private com.tencent.mm.plugin.clean.b.b qqC;
  private GridHeadersGridView qqx;
  private b qqy;
  private View qqz;
  private String username;
  
  public final void Ce(final long paramLong)
  {
    AppMethodBeat.i(22886);
    Log.i("MicroMsg.CleanChattingDetailUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.cyM().qpu -= paramLong;
    d.cyM().qpK -= paramLong;
    this.qpE += paramLong;
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
        com.tencent.mm.ui.base.h.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(2131757602, new Object[] { Util.getSizeKB(paramLong) }), "", true);
        AppMethodBeat.o(22881);
      }
    });
    AppMethodBeat.o(22886);
  }
  
  public final void ER(int paramInt)
  {
    AppMethodBeat.i(22883);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kjo.setEnabled(bool);
      AppMethodBeat.o(22883);
      return;
    }
  }
  
  public final void fo(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22885);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22880);
        CleanChattingDetailUI.c(CleanChattingDetailUI.this).setMessage(CleanChattingDetailUI.this.getString(2131757621, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
        AppMethodBeat.o(22880);
      }
    });
    AppMethodBeat.o(22885);
  }
  
  public int getLayoutId()
  {
    return 2131493655;
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
    this.qqz = ((View)$(2131296725));
    this.qqA = ((CheckBox)$(2131296724));
    this.qqB = ((MMAutoAdjustTextView)$(2131299484));
    this.kjo = ((Button)$(2131299448));
    ER(0);
    if (ab.Eq(this.username)) {
      setMMTitle(aa.getDisplayName(this.username, this.username));
    }
    for (;;)
    {
      this.qqx = ((GridHeadersGridView)findViewById(2131298735));
      this.qqx.setNumColumns(3);
      this.qqy = new b(this, this.username);
      this.qqx.setOnHeaderClickListener(this.qqy.qqm);
      this.qqx.setOnItemClickListener(this.qqy.ppw);
      this.qqx.setOnScrollListener(this.qqy.qqo);
      this.qqx.setAdapter(this.qqy);
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
      this.qqz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = CleanChattingDetailUI.a(CleanChattingDetailUI.this);
          if (paramAnonymousView.oMG.size() == paramAnonymousView.kgc.size()) {
            paramAnonymousView.oMG.clear();
          }
          for (;;)
          {
            paramAnonymousView.cyT();
            CleanChattingDetailUI.a(CleanChattingDetailUI.this).notifyDataSetChanged();
            a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(22877);
            return;
            int i = 0;
            while (i < paramAnonymousView.kgc.size())
            {
              paramAnonymousView.oMG.add(Integer.valueOf(i));
              i += 1;
            }
          }
        }
      });
      this.kjo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22879);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.ui.base.h.c(CleanChattingDetailUI.this, CleanChattingDetailUI.this.getString(2131757782), "", CleanChattingDetailUI.this.getString(2131758281), CleanChattingDetailUI.this.getString(2131756929), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(22878);
              CleanChattingDetailUI.b(CleanChattingDetailUI.this);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 31L, 1L, false);
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
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131757601), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      this.gtM.dismiss();
      if (this.qqy != null) {
        ThreadPool.post(new b.b(this.qqy, (byte)0), "load_clean_detail");
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 30L, 1L, false);
      AppMethodBeat.o(22882);
      return;
      setMMTitle(aa.getDisplayName(this.username));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22884);
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    if (this.qqy != null) {
      this.qqy.isStop = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI
 * JD-Core Version:    0.7.0.1
 */