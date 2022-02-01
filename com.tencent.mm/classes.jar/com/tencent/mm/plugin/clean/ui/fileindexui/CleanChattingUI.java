package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanChattingUI
  extends MMActivity
  implements com.tencent.mm.plugin.clean.c.b
{
  private List<c> dataList;
  private ProgressDialog gtM;
  private Button kjo;
  private TextView oML;
  private CheckBox qqA;
  private a qqG;
  private ListView qqH;
  private TextView qqI;
  private TextView qqJ;
  private boolean qqK;
  private View qqz;
  
  public CleanChattingUI()
  {
    AppMethodBeat.i(22898);
    this.qqK = false;
    this.dataList = new ArrayList();
    AppMethodBeat.o(22898);
  }
  
  public final void Ce(final long paramLong)
  {
    AppMethodBeat.i(22904);
    Log.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.cyM().qpu -= paramLong;
    d.cyM().qpK -= paramLong;
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22897);
        CleanChattingUI.g(CleanChattingUI.this).dismiss();
        com.tencent.mm.ui.base.h.c(CleanChattingUI.this, CleanChattingUI.this.getString(2131757602, new Object[] { Util.getSizeKB(paramLong) }), "", true);
        CleanChattingUI.e(CleanChattingUI.this).setText(CleanChattingUI.this.getString(2131755303, new Object[] { " " }));
        AppMethodBeat.o(22897);
      }
    });
    AppMethodBeat.o(22904);
  }
  
  public final void a(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(22900);
    if (this.qqG == null)
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
      c localc = this.qqG.EO(i);
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
      this.qqI.setText(getString(2131758289, new Object[] { Util.getSizeKB(l) }));
      this.kjo.setEnabled(true);
      if (paramHashSet.size() == this.qqG.getCount())
      {
        this.qqA.setChecked(true);
        AppMethodBeat.o(22900);
        return;
      }
      this.qqA.setChecked(false);
      AppMethodBeat.o(22900);
      return;
    }
    this.qqI.setText("");
    this.kjo.setEnabled(false);
    this.qqA.setChecked(false);
    AppMethodBeat.o(22900);
  }
  
  public final void fo(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22903);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22896);
        CleanChattingUI.g(CleanChattingUI.this).setMessage(CleanChattingUI.this.getString(2131757621, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
        AppMethodBeat.o(22896);
      }
    });
    AppMethodBeat.o(22903);
  }
  
  public int getLayoutId()
  {
    return 2131493657;
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
          this.qqG.cyS();
        }
      }
    }
    for (;;)
    {
      this.qqG.notifyDataSetChanged();
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
    setMMTitle(2131757614);
    this.qqH = ((ListView)findViewById(2131298736));
    this.qqG = new a(this, this.dataList);
    this.qqH.setAdapter(this.qqG);
    this.qqH.setEmptyView(findViewById(2131300111));
    this.qqJ = ((TextView)$(2131300101));
    this.qqz = findViewById(2131296725);
    this.qqI = ((TextView)findViewById(2131299484));
    this.qqA = ((CheckBox)findViewById(2131296724));
    this.oML = ((TextView)findViewById(2131296723));
    if (!LocaleUtil.isChineseAppLang())
    {
      this.qqI.setTextSize(1, 14.0F);
      this.oML.setTextSize(1, 14.0F);
    }
    this.kjo = ((Button)findViewById(2131299448));
    this.kjo.setEnabled(false);
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
    this.qqH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22889);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = CleanChattingUI.a(CleanChattingUI.this).EO(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
          paramAnonymousView.putExtra("key_username", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_pos", paramAnonymousInt);
          CleanChattingUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 21L, 1L, false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(22889);
      }
    });
    this.kjo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22891);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.ui.base.h.a(CleanChattingUI.this, CleanChattingUI.this.getString(2131757781), "", CleanChattingUI.this.getString(2131758281), CleanChattingUI.this.getString(2131756929), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(22890);
            CleanChattingUI.b(CleanChattingUI.this);
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 22L, 1L, false);
            AppMethodBeat.o(22890);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }, 2131099922);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22891);
      }
    });
    this.qqz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22892);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = CleanChattingUI.a(CleanChattingUI.this);
        if (paramAnonymousView.oMG.size() == paramAnonymousView.getCount()) {
          paramAnonymousView.oMG.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.qqi.a(paramAnonymousView.oMG);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22892);
          return;
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.oMG.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131757601), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.gtM.dismiss();
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 20L, 1L, false);
    AppMethodBeat.o(22899);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22901);
    if (this.gtM.isShowing()) {
      this.gtM.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(22901);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22902);
    super.onResume();
    if ((this.qqG != null) && (this.dataList.isEmpty())) {
      g.aAk().postToWorker(new Runnable()
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
                CleanChattingUI.e(CleanChattingUI.this).setText(CleanChattingUI.this.getString(2131755303, new Object[] { " " }));
                AppMethodBeat.o(22893);
              }
            });
            try
            {
              Cursor localCursor = com.tencent.mm.plugin.f.b.crW().crX().csh();
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
                  CleanChattingUI.e(CleanChattingUI.this).setText(2131757600);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */