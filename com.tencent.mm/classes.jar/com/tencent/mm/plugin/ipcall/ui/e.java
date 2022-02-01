package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;

public final class e
{
  ListView DUc;
  h DUd;
  View DUe;
  IPCallAddressUI DUf;
  boolean DUg = false;
  TextView DUh = null;
  TextView DUi = null;
  LinearLayout DUj = null;
  TextView DUk = null;
  ImageView DUl = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.DUc = paramListView;
    this.DUf = paramIPCallAddressUI;
    this.DUe = paramView;
  }
  
  public final void eKf()
  {
    AppMethodBeat.i(25658);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        bh.beI();
        if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vjh, Boolean.FALSE)).booleanValue()) {
          e.this.DUl.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          bh.beI();
          String str1 = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vjj, "");
          bh.beI();
          str2 = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vjk, "");
          if (Util.isNullOrNil(str1)) {
            break;
          }
          e.this.DUk.setText(str1);
          e.this.DUj.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.DUl.setVisibility(8);
        }
        if (!Util.isNullOrNil(str2))
        {
          e.this.DUk.setText(str2);
          e.this.DUj.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.DUk.setText("");
        e.this.DUj.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void eKg()
  {
    AppMethodBeat.i(25659);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        cfz localcfz = com.tencent.mm.plugin.ipcall.a.c.eKP();
        if (localcfz != null)
        {
          e.this.DUh.setText(localcfz.Tnk);
          if (!Util.isNullOrNil(localcfz.Tns))
          {
            e.this.DUi.setText(localcfz.Tns);
            e.this.DUi.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.DUi.setText("");
          e.this.DUi.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.DUh.setText("");
        e.this.DUi.setText("");
        e.this.DUi.setVisibility(8);
        AppMethodBeat.o(25655);
      }
    });
    AppMethodBeat.o(25659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */