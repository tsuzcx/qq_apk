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
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import java.util.ArrayList;

public final class e
{
  ListView JLm;
  h JLn;
  View JLo;
  IPCallAddressUI JLp;
  boolean JLq = false;
  TextView JLr = null;
  TextView JLs = null;
  LinearLayout JLt = null;
  TextView JLu = null;
  ImageView JLv = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.JLm = paramListView;
    this.JLp = paramIPCallAddressUI;
    this.JLo = paramView;
  }
  
  public final void fSf()
  {
    AppMethodBeat.i(25658);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        bh.bCz();
        if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKB, Boolean.FALSE)).booleanValue()) {
          e.this.JLv.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          bh.bCz();
          String str1 = (String)com.tencent.mm.model.c.ban().get(at.a.acKD, "");
          bh.bCz();
          str2 = (String)com.tencent.mm.model.c.ban().get(at.a.acKE, "");
          if (Util.isNullOrNil(str1)) {
            break;
          }
          e.this.JLu.setText(str1);
          e.this.JLt.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.JLv.setVisibility(8);
        }
        if (!Util.isNullOrNil(str2))
        {
          e.this.JLu.setText(str2);
          e.this.JLt.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.JLu.setText("");
        e.this.JLt.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void fSg()
  {
    AppMethodBeat.i(25659);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        cwc localcwc = com.tencent.mm.plugin.ipcall.a.c.fSO();
        if (localcwc != null)
        {
          e.this.JLr.setText(localcwc.aaBq);
          if (!Util.isNullOrNil(localcwc.aaBy))
          {
            e.this.JLs.setText(localcwc.aaBy);
            e.this.JLs.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.JLs.setText("");
          e.this.JLs.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.JLr.setText("");
        e.this.JLs.setText("");
        e.this.JLs.setVisibility(8);
        AppMethodBeat.o(25655);
      }
    });
    AppMethodBeat.o(25659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */