package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.b
{
  private List<c> dataList;
  private TextView lNm;
  private ProgressDialog lzP;
  private Button pYm;
  private TextView uZV;
  private a wSE;
  private ListView wSF;
  private TextView wSG;
  private boolean wSH;
  private View wSx;
  private CheckBox wSy;
  
  public CleanChattingUI()
  {
    AppMethodBeat.i(22898);
    this.wSH = false;
    this.dataList = new ArrayList();
    AppMethodBeat.o(22898);
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(22900);
    if (this.wSE == null)
    {
      Log.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
      AppMethodBeat.o(22900);
      return;
    }
    Object localObject = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      c localc = this.wSE.IY(i);
      if (localc != null) {
        l = localc.size + l;
      } else {
        ((HashSet)localObject).add(Integer.valueOf(i));
      }
    }
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashSet.remove((Integer)((Iterator)localObject).next());
    }
    if ((paramHashSet.size() != 0) || (l > 0L))
    {
      this.wSG.setText(getString(R.l.gEf, new Object[] { Util.getSizeKB(l) }));
      this.pYm.setEnabled(true);
      if (paramHashSet.size() == this.wSE.getCount())
      {
        this.wSy.setChecked(true);
        AppMethodBeat.o(22900);
        return;
      }
      this.wSy.setChecked(false);
      AppMethodBeat.o(22900);
      return;
    }
    this.wSG.setText("");
    this.pYm.setEnabled(false);
    this.wSy.setChecked(false);
    AppMethodBeat.o(22900);
  }
  
  public final void gC(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22903);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22896);
        CleanChattingUI.g(CleanChattingUI.this).setMessage(CleanChattingUI.this.getString(R.l.gAm, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
        AppMethodBeat.o(22896);
      }
    });
    AppMethodBeat.o(22903);
  }
  
  public int getLayoutId()
  {
    return R.i.ghG;
  }
  
  public final void kF(final long paramLong)
  {
    AppMethodBeat.i(22904);
    Log.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.dqN().wRt -= paramLong;
    d.dqN().wRJ -= paramLong;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22897);
        CleanChattingUI.g(CleanChattingUI.this).dismiss();
        k.c(CleanChattingUI.this, CleanChattingUI.this.getString(R.l.gAi, new Object[] { Util.getSizeKB(paramLong) }), "", true);
        CleanChattingUI.e(CleanChattingUI.this).setText(CleanChattingUI.this.getString(R.l.grl, new Object[] { " " }));
        AppMethodBeat.o(22897);
      }
    });
    AppMethodBeat.o(22904);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22905);
    long l;
    c localc;
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("key_pos", -1);
      l = paramIntent.getLongExtra("key_delete_size", 0L);
      if ((i >= 0) && (i < this.dataList.size()))
      {
        localc = (c)this.dataList.get(i);
        if (localc != null)
        {
          if (localc.size != l) {
            break label121;
          }
          this.dataList.remove(i);
          this.wSE.dqT();
        }
      }
    }
    for (;;)
    {
      this.wSE.notifyDataSetChanged();
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(22905);
      return;
      label121:
      localc.size -= l;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22899);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.CleanChattingUI", "Create!!");
    setMMTitle(R.l.gAl);
    this.wSF = ((ListView)findViewById(R.h.fBo));
    this.wSE = new a(this, this.dataList);
    this.wSF.setAdapter(this.wSE);
    this.wSF.setEmptyView(findViewById(R.h.empty_view));
    this.lNm = ((TextView)$(R.h.empty_tip));
    this.wSx = findViewById(R.h.frh);
    this.wSG = ((TextView)findViewById(R.h.fEW));
    this.wSy = ((CheckBox)findViewById(R.h.frg));
    this.uZV = ((TextView)findViewById(R.h.frf));
    if (!LocaleUtil.isChineseAppLang())
    {
      this.wSG.setTextSize(1, 14.0F);
      this.uZV.setTextSize(1, 14.0F);
    }
    this.pYm = ((Button)findViewById(R.h.del_btn));
    this.pYm.setEnabled(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22888);
        CleanChattingUI.this.finish();
        AppMethodBeat.o(22888);
        return false;
      }
    });
    this.wSF.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22889);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = CleanChattingUI.a(CleanChattingUI.this).IY(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
          paramAnonymousView.putExtra("key_username", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_pos", paramAnonymousInt);
          CleanChattingUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 21L, 1L, false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(22889);
      }
    });
    this.pYm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22891);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(CleanChattingUI.this, CleanChattingUI.this.getString(R.l.gAw), "", CleanChattingUI.this.getString(R.l.fEU), CleanChattingUI.this.getString(R.l.cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(22890);
            CleanChattingUI.b(CleanChattingUI.this);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 22L, 1L, false);
            AppMethodBeat.o(22890);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }, R.e.alert_btn_color_warn);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22891);
      }
    });
    this.wSx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22892);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = CleanChattingUI.a(CleanChattingUI.this);
        if (paramAnonymousView.uZQ.size() == paramAnonymousView.getCount()) {
          paramAnonymousView.uZQ.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.wSg.a(paramAnonymousView.uZQ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22892);
          return;
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.uZQ.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    getString(R.l.app_tip);
    this.lzP = k.a(this, getString(R.l.gAh), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.lzP.dismiss();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 20L, 1L, false);
    AppMethodBeat.o(22899);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22901);
    if (this.lzP.isShowing()) {
      this.lzP.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(22901);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22902);
    super.onResume();
    if ((this.wSE != null) && (this.dataList.isEmpty())) {
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22895);
          if (!CleanChattingUI.c(CleanChattingUI.this))
          {
            Log.i("MicroMsg.CleanChattingUI", "load contact cursor now");
            CleanChattingUI.d(CleanChattingUI.this);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22893);
                CleanChattingUI.e(CleanChattingUI.this).setText(CleanChattingUI.this.getString(R.l.grl, new Object[] { " " }));
                AppMethodBeat.o(22893);
              }
            });
            try
            {
              Cursor localCursor = com.tencent.mm.plugin.calcwx.a.diz().diA().diL();
              if (localCursor != null) {
                while (localCursor.moveToNext())
                {
                  c localc = new c();
                  localc.username = localCursor.getString(0);
                  localc.size = localCursor.getLong(1);
                  CleanChattingUI.f(CleanChattingUI.this).add(localc);
                }
              }
              AppMethodBeat.o(22895);
            }
            catch (NullPointerException localNullPointerException)
            {
              Log.printErrStackTrace("MicroMsg.CleanChattingUI", localNullPointerException, "", new Object[0]);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(22894);
                  CleanChattingUI.a(CleanChattingUI.this).notifyDataSetChanged();
                  CleanChattingUI.e(CleanChattingUI.this).setText(R.l.gAg);
                  AppMethodBeat.o(22894);
                }
              });
            }
          }
        }
      });
    }
    AppMethodBeat.o(22902);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */