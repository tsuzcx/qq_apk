package com.tencent.mm.plugin.clean.ui.newui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  extends BaseAdapter
  implements com.tencent.mm.ui.gridviewheaders.e
{
  private static int iCB = 0;
  private boolean aDS;
  HashSet<Integer> hIR;
  ArrayList<com.tencent.mm.plugin.clean.c.a> hgv;
  GridHeadersGridView.c iCC = new b.2(this);
  private ah iCD = new b.4(this);
  AbsListView.OnScrollListener iCE = new b.5(this);
  private CleanChattingDetailUI iDW;
  AdapterView.OnItemClickListener idL = new b.3(this);
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, ArrayList<com.tencent.mm.plugin.clean.c.a> paramArrayList)
  {
    this.iDW = paramCleanChattingDetailUI;
    this.hgv = paramArrayList;
    this.hIR = new HashSet();
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      y.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.iDW.getLayoutInflater().inflate(R.i.clean_chatting_detail_item_header, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.iCG = ((TextView)paramView.findViewById(R.h.header_tv));
      paramViewGroup.iCH = ((TextView)paramView.findViewById(R.h.header_select_tv));
      paramViewGroup.iCI = ((CheckBox)paramView.findViewById(R.h.header_select_cb));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = pp(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.iCG.setText(h.g(this.iDW.getString(R.l.fmt_year_month), ((com.tencent.mm.plugin.clean.c.a)localObject).eHF / 1000L));
      long l = ((com.tencent.mm.plugin.clean.c.a)localObject).aDF();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.hgv.size())
      {
        if (((com.tencent.mm.plugin.clean.c.a)this.hgv.get(paramInt)).aDF() == l) {
          ((HashSet)localObject).add(Integer.valueOf(paramInt));
        }
        paramInt += 1;
      }
      y.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
      paramViewGroup = (b.a)paramView.getTag();
    }
    Object localObject = ((HashSet)localObject).iterator();
    paramInt = 1;
    if (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (this.hIR.contains(Integer.valueOf(i))) {
        break label286;
      }
      paramInt = 0;
    }
    label286:
    for (;;)
    {
      break;
      if (paramInt != 0)
      {
        paramViewGroup.iCI.setChecked(true);
        return paramView;
      }
      paramViewGroup.iCI.setChecked(false);
      return paramView;
    }
  }
  
  public final void aEe()
  {
    this.hIR.clear();
    aEf();
  }
  
  final void aEf()
  {
    this.iDW.pn(this.hIR.size());
    Object localObject = this.iDW;
    int i;
    if (this.hIR.size() == this.hgv.size())
    {
      i = 1;
      if (i == 0) {
        break label112;
      }
      ((CleanChattingDetailUI)localObject).iCQ.setChecked(true);
    }
    long l;
    for (;;)
    {
      localObject = this.hIR.iterator();
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((com.tencent.mm.plugin.clean.c.a)this.hgv.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label112:
      ((CleanChattingDetailUI)localObject).iCQ.setChecked(false);
    }
    localObject = this.iDW;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).iCR.setText(((CleanChattingDetailUI)localObject).getString(R.l.delete_info, new Object[] { bk.cm(l) }));
      return;
    }
    ((CleanChattingDetailUI)localObject).iCR.setText("");
  }
  
  public final int getCount()
  {
    return this.hgv.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.clean.c.a locala;
    if (paramView == null)
    {
      paramView = this.iDW.getLayoutInflater().inflate(R.i.clean_chatting_detail_item, paramViewGroup, false);
      paramViewGroup = new b.b(this);
      paramViewGroup.iCJ = ((MMImageView)paramView.findViewById(R.h.content_iv));
      paramViewGroup.eXQ = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.iCL = paramView.findViewById(R.h.select_cb_clickarea);
      paramViewGroup.iCM = paramView.findViewById(R.h.selected_item_mask);
      paramViewGroup.iCK = ((ImageView)paramView.findViewById(R.h.play_iv));
      paramViewGroup.fhD = ((TextView)paramView.findViewById(R.h.name_tv));
      paramView.setTag(paramViewGroup);
      locala = pp(paramInt);
      paramViewGroup.iCJ.setTag(locala.filePath);
      paramViewGroup.iCL.setOnClickListener(new b.1(this, paramInt));
      if (!this.hIR.contains(Integer.valueOf(paramInt))) {
        break label293;
      }
      paramViewGroup.eXQ.setChecked(true);
      paramViewGroup.iCM.setVisibility(0);
      label182:
      if (locala.type != 3) {
        break label313;
      }
      paramViewGroup.iCK.setVisibility(0);
    }
    for (;;)
    {
      if (locala.type != 4) {
        break label325;
      }
      paramViewGroup.iCJ.setImageResource(com.tencent.mm.pluginsdk.model.o.VP(com.tencent.mm.vfs.e.bM(locala.filePath)));
      paramViewGroup.fhD.setText(new com.tencent.mm.vfs.b(locala.filePath).getName());
      paramViewGroup.fhD.setVisibility(0);
      y.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return paramView;
      paramViewGroup = (b.b)paramView.getTag();
      break;
      label293:
      paramViewGroup.eXQ.setChecked(false);
      paramViewGroup.iCM.setVisibility(8);
      break label182;
      label313:
      paramViewGroup.iCK.setVisibility(8);
    }
    label325:
    if (iCB == 0) {
      iCB = paramView.getMeasuredWidth();
    }
    Object localObject = new c.a();
    ((c.a)localObject).erk = 1;
    ((c.a)localObject).erg = false;
    ((c.a)localObject).erm = iCB;
    ((c.a)localObject).erl = iCB;
    if (locala.type == 1)
    {
      ((c.a)localObject).erh = locala.filePath;
      localObject = ((c.a)localObject).OV();
      com.tencent.mm.as.o.ON().a(locala.filePath, paramViewGroup.iCJ, (c)localObject);
    }
    for (;;)
    {
      paramViewGroup.fhD.setVisibility(8);
      break;
      ((c.a)localObject).erh = locala.thumbPath;
      localObject = ((c.a)localObject).OV();
      com.tencent.mm.as.o.ON().a(locala.thumbPath, paramViewGroup.iCJ, (c)localObject);
    }
  }
  
  public final long pm(int paramInt)
  {
    return ((com.tencent.mm.plugin.clean.c.a)this.hgv.get(paramInt)).aDF();
  }
  
  public final com.tencent.mm.plugin.clean.c.a pp(int paramInt)
  {
    return (com.tencent.mm.plugin.clean.c.a)this.hgv.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b
 * JD-Core Version:    0.7.0.1
 */