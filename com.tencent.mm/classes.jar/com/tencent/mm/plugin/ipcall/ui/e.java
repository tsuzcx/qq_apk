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
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.h.d;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

public final class e
{
  TextView sFA = null;
  ImageView sFB = null;
  ListView sFs;
  h sFt;
  View sFu;
  IPCallAddressUI sFv;
  boolean sFw = false;
  TextView sFx = null;
  TextView sFy = null;
  LinearLayout sFz = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.sFs = paramListView;
    this.sFv = paramIPCallAddressUI;
    this.sFu = paramView;
  }
  
  public final void cHZ()
  {
    AppMethodBeat.i(25658);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25654);
        az.arV();
        if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiB, Boolean.FALSE)).booleanValue()) {
          e.this.sFB.setVisibility(0);
        }
        String str2;
        for (;;)
        {
          az.arV();
          String str1 = (String)com.tencent.mm.model.c.afk().get(ae.a.FiD, "");
          az.arV();
          str2 = (String)com.tencent.mm.model.c.afk().get(ae.a.FiE, "");
          if (bt.isNullOrNil(str1)) {
            break;
          }
          e.this.sFA.setText(str1);
          e.this.sFz.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
          e.this.sFB.setVisibility(8);
        }
        if (!bt.isNullOrNil(str2))
        {
          e.this.sFA.setText(str2);
          e.this.sFz.setVisibility(0);
          AppMethodBeat.o(25654);
          return;
        }
        e.this.sFA.setText("");
        e.this.sFz.setVisibility(8);
        AppMethodBeat.o(25654);
      }
    });
    AppMethodBeat.o(25658);
  }
  
  public final void cIa()
  {
    AppMethodBeat.i(25659);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25655);
        bdc localbdc = com.tencent.mm.plugin.ipcall.a.c.cIM();
        if (localbdc != null)
        {
          e.this.sFx.setText(localbdc.DAw);
          if (!bt.isNullOrNil(localbdc.DAE))
          {
            e.this.sFy.setText(localbdc.DAE);
            e.this.sFy.setVisibility(0);
            AppMethodBeat.o(25655);
            return;
          }
          e.this.sFy.setText("");
          e.this.sFy.setVisibility(8);
          AppMethodBeat.o(25655);
          return;
        }
        e.this.sFx.setText("");
        e.this.sFy.setText("");
        e.this.sFy.setVisibility(8);
        AppMethodBeat.o(25655);
      }
    });
    AppMethodBeat.o(25659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */