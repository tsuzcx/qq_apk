package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.plugin.clean.c.i;
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
  ArrayList<i> iRT;
  boolean isStop;
  HashSet<Integer> jCr;
  AdapterView.OnItemClickListener jUz;
  private CleanChattingDetailUI kHH;
  GridHeadersGridView.c kHJ;
  private ak kHK;
  AbsListView.OnScrollListener kHL;
  private String username;
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, String paramString)
  {
    AppMethodBeat.i(18754);
    this.isStop = false;
    this.kHJ = new b.3(this);
    this.jUz = new b.4(this);
    this.kHK = new b.5(this);
    this.kHL = new b.6(this);
    this.kHH = paramCleanChattingDetailUI;
    this.jCr = new HashSet();
    this.iRT = new ArrayList();
    this.username = paramString;
    AppMethodBeat.o(18754);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18759);
    if (paramView == null)
    {
      ab.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.kHH.getLayoutInflater().inflate(2130969159, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.kHN = ((TextView)paramView.findViewById(2131822836));
      paramViewGroup.kHO = ((TextView)paramView.findViewById(2131822837));
      paramViewGroup.kHP = ((CheckBox)paramView.findViewById(2131822838));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = tB(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.kHN.setText(h.formatTime(this.kHH.getString(2131300112), ((i)localObject).fXv / 1000L));
      long l = ((i)localObject).bgF();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.iRT.size())
      {
        if (((i)this.iRT.get(paramInt)).bgF() == l) {
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
        break label295;
      }
      paramInt = 0;
    }
    label295:
    for (;;)
    {
      break;
      if (paramInt != 0) {
        paramViewGroup.kHP.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(18759);
        return paramView;
        paramViewGroup.kHP.setChecked(false);
      }
    }
  }
  
  public final void bhf()
  {
    AppMethodBeat.i(18761);
    this.jCr.clear();
    bhg();
    AppMethodBeat.o(18761);
  }
  
  final void bhg()
  {
    AppMethodBeat.i(18760);
    this.kHH.tD(this.jCr.size());
    Object localObject = this.kHH;
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
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((i)this.iRT.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label118:
      ((CleanChattingDetailUI)localObject).kHX.setChecked(false);
    }
    localObject = this.kHH;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).kHY.setText(((CleanChattingDetailUI)localObject).getString(2131298949, new Object[] { bo.hk(l) }));
      AppMethodBeat.o(18760);
      return;
    }
    ((CleanChattingDetailUI)localObject).kHY.setText("");
    AppMethodBeat.o(18760);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(18755);
    int i = this.iRT.size();
    AppMethodBeat.o(18755);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(18757);
    long l = System.currentTimeMillis();
    i locali;
    if (paramView == null)
    {
      paramView = this.kHH.getLayoutInflater().inflate(2130969158, paramViewGroup, false);
      paramViewGroup = new b.c(this);
      paramViewGroup.kHQ = ((MMImageView)paramView.findViewById(2131822832));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131821631));
      paramViewGroup.kHS = paramView.findViewById(2131822835);
      paramViewGroup.kHT = paramView.findViewById(2131822834);
      paramViewGroup.kHR = ((ImageView)paramView.findViewById(2131822833));
      paramViewGroup.gzk = ((TextView)paramView.findViewById(2131821254));
      paramView.setTag(paramViewGroup);
      locali = tB(paramInt);
      paramViewGroup.kHQ.setTag(locali.filePath);
      paramViewGroup.kHS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(18747);
          b.a(b.this, paramInt);
          b.this.notifyDataSetChanged();
          AppMethodBeat.o(18747);
        }
      });
      if (!this.jCr.contains(Integer.valueOf(paramInt))) {
        break label320;
      }
      paramViewGroup.gpN.setChecked(true);
      paramViewGroup.kHT.setVisibility(0);
      label188:
      if (locali.type != 3) {
        break label340;
      }
      paramViewGroup.kHR.setVisibility(0);
      label205:
      if (locali.type != 4) {
        break label352;
      }
      com.tencent.mm.at.o.ahG().b(locali.thumbPath, paramViewGroup.kHQ);
      paramViewGroup.kHQ.setImageResource(com.tencent.mm.pluginsdk.model.o.alm(com.tencent.mm.vfs.e.cP(locali.filePath)));
      paramViewGroup.gzk.setText(new com.tencent.mm.vfs.b(locali.filePath).getName());
      paramViewGroup.gzk.setVisibility(0);
    }
    for (;;)
    {
      ab.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(18757);
      return paramView;
      paramViewGroup = (b.c)paramView.getTag();
      break;
      label320:
      paramViewGroup.gpN.setChecked(false);
      paramViewGroup.kHT.setVisibility(8);
      break label188;
      label340:
      paramViewGroup.kHR.setVisibility(8);
      break label205;
      label352:
      if (kHI == 0) {
        kHI = paramView.getMeasuredWidth();
      }
      Object localObject = new c.a();
      ((c.a)localObject).fHt = 1;
      ((c.a)localObject).eNN = false;
      ((c.a)localObject).eNT = kHI;
      ((c.a)localObject).eNS = kHI;
      ((c.a)localObject).eNO = locali.thumbPath;
      localObject = ((c.a)localObject).ahY();
      com.tencent.mm.at.o.ahG().a(locali.thumbPath, paramViewGroup.kHQ, (c)localObject);
      paramViewGroup.gzk.setVisibility(8);
    }
  }
  
  public final i tB(int paramInt)
  {
    AppMethodBeat.i(18756);
    i locali = (i)this.iRT.get(paramInt);
    AppMethodBeat.o(18756);
    return locali;
  }
  
  public final long tC(int paramInt)
  {
    AppMethodBeat.i(18758);
    long l = ((i)this.iRT.get(paramInt)).bgF();
    AppMethodBeat.o(18758);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b
 * JD-Core Version:    0.7.0.1
 */