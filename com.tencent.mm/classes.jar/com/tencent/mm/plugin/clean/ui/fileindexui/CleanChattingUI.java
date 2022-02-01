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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private ProgressDialog fpP;
  private Button ipd;
  private TextView mtS;
  private CheckBox nOA;
  private a nOG;
  private ListView nOH;
  private TextView nOI;
  private TextView nOJ;
  private boolean nOK;
  private View nOz;
  
  public CleanChattingUI()
  {
    AppMethodBeat.i(22898);
    this.nOK = false;
    this.dataList = new ArrayList();
    AppMethodBeat.o(22898);
  }
  
  public final void b(HashSet<Integer> paramHashSet)
  {
    AppMethodBeat.i(22900);
    if (this.nOG == null)
    {
      ad.w("MicroMsg.CleanChattingUI", "on click check box but adapter is null");
      AppMethodBeat.o(22900);
      return;
    }
    Object localObject = new HashSet();
    Iterator localIterator = paramHashSet.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      c localc = this.nOG.zu(i);
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
      this.nOI.setText(getString(2131758037, new Object[] { bt.mK(l) }));
      this.ipd.setEnabled(true);
      if (paramHashSet.size() == this.nOG.getCount())
      {
        this.nOA.setChecked(true);
        AppMethodBeat.o(22900);
        return;
      }
      this.nOA.setChecked(false);
      AppMethodBeat.o(22900);
      return;
    }
    this.nOI.setText("");
    this.ipd.setEnabled(false);
    this.nOA.setChecked(false);
    AppMethodBeat.o(22900);
  }
  
  public final void eT(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(22903);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22896);
        CleanChattingUI.g(CleanChattingUI.this).setMessage(CleanChattingUI.this.getString(2131757404, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
        AppMethodBeat.o(22896);
      }
    });
    AppMethodBeat.o(22903);
  }
  
  public int getLayoutId()
  {
    return 2131493545;
  }
  
  public final void nX(final long paramLong)
  {
    AppMethodBeat.i(22904);
    ad.i("MicroMsg.CleanChattingUI", "%s onDeleteEnd [%d] ", new Object[] { hashCode(), Long.valueOf(paramLong) });
    d.bNS().nNx -= paramLong;
    d.bNS().nNw -= paramLong;
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22897);
        CleanChattingUI.g(CleanChattingUI.this).dismiss();
        com.tencent.mm.ui.base.h.c(CleanChattingUI.this, CleanChattingUI.this.getString(2131757385, new Object[] { bt.mK(paramLong) }), "", true);
        CleanChattingUI.e(CleanChattingUI.this).setText(CleanChattingUI.this.getString(2131755268, new Object[] { " " }));
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
          this.nOG.bNY();
        }
      }
    }
    for (;;)
    {
      this.nOG.notifyDataSetChanged();
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
    ad.i("MicroMsg.CleanChattingUI", "Create!!");
    setMMTitle(2131757397);
    this.nOH = ((ListView)findViewById(2131298341));
    this.nOG = new a(this, this.dataList);
    this.nOH.setAdapter(this.nOG);
    this.nOH.setEmptyView(findViewById(2131299478));
    this.nOJ = ((TextView)$(2131299472));
    this.nOz = findViewById(2131296648);
    this.nOI = ((TextView)findViewById(2131298988));
    this.nOA = ((CheckBox)findViewById(2131296647));
    this.mtS = ((TextView)findViewById(2131296646));
    if (!ac.eFq())
    {
      this.nOI.setTextSize(1, 14.0F);
      this.mtS.setTextSize(1, 14.0F);
    }
    this.ipd = ((Button)findViewById(2131298954));
    this.ipd.setEnabled(false);
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
    this.nOH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22889);
        paramAnonymousAdapterView = CleanChattingUI.a(CleanChattingUI.this).zu(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousView = new Intent(CleanChattingUI.this, CleanChattingDetailUI.class);
          paramAnonymousView.putExtra("key_username", paramAnonymousAdapterView.username);
          paramAnonymousView.putExtra("key_pos", paramAnonymousInt);
          CleanChattingUI.this.startActivityForResult(paramAnonymousView, 0);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 21L, 1L, false);
        }
        AppMethodBeat.o(22889);
      }
    });
    this.ipd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22891);
        com.tencent.mm.ui.base.h.d(CleanChattingUI.this, CleanChattingUI.this.getString(2131757554), "", CleanChattingUI.this.getString(2131758029), CleanChattingUI.this.getString(2131756766), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(22890);
            CleanChattingUI.b(CleanChattingUI.this);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 22L, 1L, false);
            AppMethodBeat.o(22890);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(22891);
      }
    });
    this.nOz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22892);
        paramAnonymousView = CleanChattingUI.a(CleanChattingUI.this);
        if (paramAnonymousView.mtN.size() == paramAnonymousView.getCount()) {
          paramAnonymousView.mtN.clear();
        }
        for (;;)
        {
          paramAnonymousView.notifyDataSetChanged();
          paramAnonymousView.nOi.b(paramAnonymousView.mtN);
          AppMethodBeat.o(22892);
          return;
          int i = 0;
          while (i < paramAnonymousView.getCount())
          {
            paramAnonymousView.mtN.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    });
    getString(2131755906);
    this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131757384), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.fpP.dismiss();
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(714L, 20L, 1L, false);
    AppMethodBeat.o(22899);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22901);
    if (this.fpP.isShowing()) {
      this.fpP.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(22901);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22902);
    super.onResume();
    if ((this.nOG != null) && (this.dataList.isEmpty())) {
      g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22895);
          if (!CleanChattingUI.c(CleanChattingUI.this))
          {
            ad.i("MicroMsg.CleanChattingUI", "load contact cursor now");
            CleanChattingUI.d(CleanChattingUI.this);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22893);
                CleanChattingUI.e(CleanChattingUI.this).setText(CleanChattingUI.this.getString(2131755268, new Object[] { " " }));
                AppMethodBeat.o(22893);
              }
            });
            try
            {
              Cursor localCursor = com.tencent.mm.plugin.f.b.bHc().bHd().bHm();
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
              ad.printErrStackTrace("MicroMsg.CleanChattingUI", localNullPointerException, "", new Object[0]);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(22894);
                  CleanChattingUI.a(CleanChattingUI.this).notifyDataSetChanged();
                  CleanChattingUI.e(CleanChattingUI.this).setText(2131757383);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI
 * JD-Core Version:    0.7.0.1
 */