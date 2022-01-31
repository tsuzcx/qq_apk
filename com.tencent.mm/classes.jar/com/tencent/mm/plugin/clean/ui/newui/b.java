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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static int kHI = 0;
  private boolean aKD;
  ArrayList<com.tencent.mm.plugin.clean.c.a> iRT;
  HashSet<Integer> jCr;
  AdapterView.OnItemClickListener jUz;
  GridHeadersGridView.c kHJ;
  private ak kHK;
  AbsListView.OnScrollListener kHL;
  private CleanChattingDetailUI kJd;
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, ArrayList<com.tencent.mm.plugin.clean.c.a> paramArrayList)
  {
    AppMethodBeat.i(18852);
    this.kHJ = new b.2(this);
    this.jUz = new b.3(this);
    this.kHK = new b.4(this);
    this.kHL = new b.5(this);
    this.kJd = paramCleanChattingDetailUI;
    this.iRT = paramArrayList;
    this.jCr = new HashSet();
    AppMethodBeat.o(18852);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18857);
    if (paramView == null)
    {
      ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.kJd.getLayoutInflater().inflate(2130969159, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.kHN = ((TextView)paramView.findViewById(2131822836));
      paramViewGroup.kHO = ((TextView)paramView.findViewById(2131822837));
      paramViewGroup.kHP = ((CheckBox)paramView.findViewById(2131822838));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = tF(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.kHN.setText(h.formatTime(this.kJd.getString(2131300112), ((com.tencent.mm.plugin.clean.c.a)localObject).fXv / 1000L));
      long l = ((com.tencent.mm.plugin.clean.c.a)localObject).bgF();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.iRT.size())
      {
        if (((com.tencent.mm.plugin.clean.c.a)this.iRT.get(paramInt)).bgF() == l) {
          ((HashSet)localObject).add(Integer.valueOf(paramInt));
        }
        paramInt += 1;
      }
      ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
      paramViewGroup = (b.a)paramView.getTag();
    }
    Object localObject = ((HashSet)localObject).iterator();
    paramInt = 1;
    if (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (this.jCr.contains(Integer.valueOf(i))) {
        break label294;
      }
      paramInt = 0;
    }
    label294:
    for (;;)
    {
      break;
      if (paramInt != 0) {
        paramViewGroup.kHP.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(18857);
        return paramView;
        paramViewGroup.kHP.setChecked(false);
      }
    }
  }
  
  public final void bhf()
  {
    AppMethodBeat.i(18859);
    this.jCr.clear();
    bhg();
    AppMethodBeat.o(18859);
  }
  
  final void bhg()
  {
    AppMethodBeat.i(18858);
    this.kJd.tD(this.jCr.size());
    Object localObject = this.kJd;
    int i;
    if (this.jCr.size() == this.iRT.size())
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      ((CleanChattingDetailUI)localObject).kHX.setChecked(true);
    }
    long l;
    for (;;)
    {
      localObject = this.jCr.iterator();
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((com.tencent.mm.plugin.clean.c.a)this.iRT.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label118:
      ((CleanChattingDetailUI)localObject).kHX.setChecked(false);
    }
    localObject = this.kJd;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).kHY.setText(((CleanChattingDetailUI)localObject).getString(2131298949, new Object[] { bo.hk(l) }));
      AppMethodBeat.o(18858);
      return;
    }
    ((CleanChattingDetailUI)localObject).kHY.setText("");
    AppMethodBeat.o(18858);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(18853);
    int i = this.iRT.size();
    AppMethodBeat.o(18853);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18855);
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.clean.c.a locala;
    if (paramView == null)
    {
      paramView = this.kJd.getLayoutInflater().inflate(2130969158, paramViewGroup, false);
      paramViewGroup = new b.b(this);
      paramViewGroup.kHQ = ((MMImageView)paramView.findViewById(2131822832));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821631));
      paramViewGroup.kHS = paramView.findViewById(2131822835);
      paramViewGroup.kHT = paramView.findViewById(2131822834);
      paramViewGroup.kHR = ((ImageView)paramView.findViewById(2131822833));
      paramViewGroup.gzk = ((TextView)paramView.findViewById(2131821254));
      paramView.setTag(paramViewGroup);
      locala = tF(paramInt);
      paramViewGroup.kHQ.setTag(locala.filePath);
      paramViewGroup.kHS.setOnClickListener(new b.1(this, paramInt));
      if (!this.jCr.contains(Integer.valueOf(paramInt))) {
        break label305;
      }
      paramViewGroup.gpN.setChecked(true);
      paramViewGroup.kHT.setVisibility(0);
      label188:
      if (locala.type != 3) {
        break label325;
      }
      paramViewGroup.kHR.setVisibility(0);
    }
    for (;;)
    {
      if (locala.type != 4) {
        break label337;
      }
      paramViewGroup.kHQ.setImageResource(com.tencent.mm.pluginsdk.model.o.alm(com.tencent.mm.vfs.e.cP(locala.filePath)));
      paramViewGroup.gzk.setText(new com.tencent.mm.vfs.b(locala.filePath).getName());
      paramViewGroup.gzk.setVisibility(0);
      ab.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(18855);
      return paramView;
      paramViewGroup = (b.b)paramView.getTag();
      break;
      label305:
      paramViewGroup.gpN.setChecked(false);
      paramViewGroup.kHT.setVisibility(8);
      break label188;
      label325:
      paramViewGroup.kHR.setVisibility(8);
    }
    label337:
    if (kHI == 0) {
      kHI = paramView.getMeasuredWidth();
    }
    Object localObject = new c.a();
    ((c.a)localObject).fHt = 1;
    ((c.a)localObject).eNN = false;
    ((c.a)localObject).eNT = kHI;
    ((c.a)localObject).eNS = kHI;
    if (locala.type == 1)
    {
      ((c.a)localObject).eNO = locala.filePath;
      localObject = ((c.a)localObject).ahY();
      com.tencent.mm.at.o.ahG().a(locala.filePath, paramViewGroup.kHQ, (c)localObject);
    }
    for (;;)
    {
      paramViewGroup.gzk.setVisibility(8);
      break;
      ((c.a)localObject).eNO = locala.thumbPath;
      localObject = ((c.a)localObject).ahY();
      com.tencent.mm.at.o.ahG().a(locala.thumbPath, paramViewGroup.kHQ, (c)localObject);
    }
  }
  
  public final long tC(int paramInt)
  {
    AppMethodBeat.i(18856);
    long l = ((com.tencent.mm.plugin.clean.c.a)this.iRT.get(paramInt)).bgF();
    AppMethodBeat.o(18856);
    return l;
  }
  
  public final com.tencent.mm.plugin.clean.c.a tF(int paramInt)
  {
    AppMethodBeat.i(18854);
    com.tencent.mm.plugin.clean.c.a locala = (com.tencent.mm.plugin.clean.c.a)this.iRT.get(paramInt);
    AppMethodBeat.o(18854);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.b
 * JD-Core Version:    0.7.0.1
 */