package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

public final class e
{
  ListView luf;
  h lug;
  View luh;
  IPCallAddressUI lui;
  boolean luj = false;
  TextView luk = null;
  TextView lul = null;
  LinearLayout lum = null;
  TextView lun = null;
  ImageView luo = null;
  
  public e(IPCallAddressUI paramIPCallAddressUI, ListView paramListView, View paramView)
  {
    this.luf = paramListView;
    this.lui = paramIPCallAddressUI;
    this.luh = paramView;
  }
  
  public final void bcT()
  {
    ai.d(new e.6(this));
  }
  
  public final void bcU()
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        ams localams = c.bdt();
        if (localams != null)
        {
          e.this.luk.setText(localams.tiG);
          if (!bk.bl(localams.tiO))
          {
            e.this.lul.setText(localams.tiO);
            e.this.lul.setVisibility(0);
            return;
          }
          e.this.lul.setText("");
          e.this.lul.setVisibility(8);
          return;
        }
        e.this.luk.setText("");
        e.this.lul.setText("");
        e.this.lul.setVisibility(8);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e
 * JD-Core Version:    0.7.0.1
 */