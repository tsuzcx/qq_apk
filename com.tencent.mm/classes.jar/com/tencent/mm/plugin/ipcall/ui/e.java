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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;

public final class e
{
  ListView ytY;
  h ytZ;
  View yua;
  IPCallAddressUI yub;
  boolean yuc = false;
  TextView yud = null;
  TextView yue = null;
  LinearLayout yuf = null;
  TextView yug = null;
  ImageView yuh = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.ytY = paramListView;
    this.yub = paramIPCallAddressUI;
    this.yua = paramView;
  }
  
  public final void ebh()
  {
    AppMethodBeat.i(25658);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        bg.aVF();
        if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVh, Boolean.FALSE)).booleanValue()) {
          e.this.yuh.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          bg.aVF();
          String str1 = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVj, "");
          bg.aVF();
          str2 = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVk, "");
          if (Util.isNullOrNil(str1)) {
            break;
          }
          e.this.yug.setText(str1);
          e.this.yuf.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.yuh.setVisibility(8);
        }
        if (!Util.isNullOrNil(str2))
        {
          e.this.yug.setText(str2);
          e.this.yuf.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.yug.setText("");
        e.this.yuf.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(25659);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        byf localbyf = com.tencent.mm.plugin.ipcall.a.c.ebR();
        if (localbyf != null)
        {
          e.this.yud.setText(localbyf.MdJ);
          if (!Util.isNullOrNil(localbyf.MdR))
          {
            e.this.yue.setText(localbyf.MdR);
            e.this.yue.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.yue.setText("");
          e.this.yue.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.yud.setText("");
        e.this.yue.setText("");
        e.this.yue.setVisibility(8);
        AppMethodBeat.o(25655);
      }
    });
    AppMethodBeat.o(25659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */