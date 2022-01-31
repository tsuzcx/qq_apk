package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class e
{
  IPCallAddressUI nRA;
  boolean nRB = false;
  TextView nRC = null;
  TextView nRD = null;
  LinearLayout nRE = null;
  TextView nRF = null;
  ImageView nRG = null;
  ListView nRx;
  h nRy;
  View nRz;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.nRx = paramListView;
    this.nRA = paramIPCallAddressUI;
    this.nRz = paramView;
  }
  
  public final void bKd()
  {
    AppMethodBeat.i(22042);
    al.d(new e.6(this));
    AppMethodBeat.o(22042);
  }
  
  public final void bKe()
  {
    AppMethodBeat.i(22043);
    al.d(new e.7(this));
    AppMethodBeat.o(22043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */