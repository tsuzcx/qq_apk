package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  extends BaseAdapter
  implements e
{
  private static int wSj = 0;
  private boolean cUu;
  boolean isStop;
  ArrayList<com.tencent.mm.plugin.clean.c.c> pUj;
  HashSet<Integer> uZQ;
  private String username;
  AdapterView.OnItemClickListener vEc;
  private CleanChattingDetailUI wSi;
  GridHeadersGridView.c wSk;
  private MMHandler wSl;
  AbsListView.OnScrollListener wSm;
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, String paramString)
  {
    AppMethodBeat.i(22864);
    this.isStop = false;
    this.wSk = new GridHeadersGridView.c()
    {
      public final void eR(View paramAnonymousView)
      {
        AppMethodBeat.i(22858);
        paramAnonymousView = (b.a)paramAnonymousView.getTag();
        b.a(b.this, paramAnonymousView);
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(22858);
      }
    };
    this.vEc = new b.4(this);
    this.wSl = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(22860);
        if (!b.f(b.this)) {
          b.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(22860);
      }
    };
    this.wSm = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(22861);
        r.bKe().onScrollStateChanged(paramAnonymousInt);
        if (paramAnonymousInt != 2)
        {
          b.a(b.this, false);
          b.g(b.this).removeCallbacksAndMessages(null);
          b.g(b.this).sendEmptyMessageDelayed(0, 200L);
          AppMethodBeat.o(22861);
          return;
        }
        b.a(b.this, true);
        AppMethodBeat.o(22861);
      }
    };
    this.wSi = paramCleanChattingDetailUI;
    this.uZQ = new HashSet();
    this.pUj = new ArrayList();
    this.username = paramString;
    AppMethodBeat.o(22864);
  }
  
  public final com.tencent.mm.plugin.clean.c.c IZ(int paramInt)
  {
    AppMethodBeat.i(22866);
    com.tencent.mm.plugin.clean.c.c localc = (com.tencent.mm.plugin.clean.c.c)this.pUj.get(paramInt);
    AppMethodBeat.o(22866);
    return localc;
  }
  
  public final long Ja(int paramInt)
  {
    AppMethodBeat.i(22868);
    long l = ((com.tencent.mm.plugin.clean.c.c)this.pUj.get(paramInt)).dqM();
    AppMethodBeat.o(22868);
    return l;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22869);
    if (paramView == null)
    {
      Log.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.wSi.getLayoutInflater().inflate(R.i.ghD, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.wSo = ((TextView)paramView.findViewById(R.h.header_tv));
      paramViewGroup.wSp = ((TextView)paramView.findViewById(R.h.fJI));
      paramViewGroup.wSq = ((CheckBox)paramView.findViewById(R.h.fJH));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = IZ(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.wSo.setText(f.formatTime(this.wSi.getString(R.l.fmt_year_month), ((com.tencent.mm.plugin.clean.c.c)localObject).pba / 1000L));
      long l = ((com.tencent.mm.plugin.clean.c.c)localObject).dqM();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.pUj.size())
      {
        if (((com.tencent.mm.plugin.clean.c.c)this.pUj.get(paramInt)).dqM() == l) {
          ((HashSet)localObject).add(Integer.valueOf(paramInt));
        }
        paramInt += 1;
      }
      Log.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject = ((HashSet)localObject).iterator();
    paramInt = 1;
    if (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (this.uZQ.contains(Integer.valueOf(i))) {
        break label300;
      }
      paramInt = 0;
    }
    label300:
    for (;;)
    {
      break;
      if (paramInt != 0) {
        paramViewGroup.wSq.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(22869);
        return paramView;
        paramViewGroup.wSq.setChecked(false);
      }
    }
  }
  
  public final void dqT()
  {
    AppMethodBeat.i(22871);
    this.uZQ.clear();
    dqU();
    AppMethodBeat.o(22871);
  }
  
  final void dqU()
  {
    AppMethodBeat.i(22870);
    this.wSi.Jb(this.uZQ.size());
    Object localObject = this.wSi;
    int i;
    if (this.uZQ.size() == this.pUj.size())
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      ((CleanChattingDetailUI)localObject).wSy.setChecked(true);
    }
    long l;
    for (;;)
    {
      localObject = this.uZQ.iterator();
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((com.tencent.mm.plugin.clean.c.c)this.pUj.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label118:
      ((CleanChattingDetailUI)localObject).wSy.setChecked(false);
    }
    localObject = this.wSi;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).wSz.setText(((CleanChattingDetailUI)localObject).getString(R.l.gEf, new Object[] { Util.getSizeKB(l) }));
      AppMethodBeat.o(22870);
      return;
    }
    ((CleanChattingDetailUI)localObject).wSz.setText("");
    AppMethodBeat.o(22870);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22865);
    int i = this.pUj.size();
    AppMethodBeat.o(22865);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22867);
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.clean.c.c localc;
    if (paramView == null)
    {
      paramView = this.wSi.getLayoutInflater().inflate(R.i.ghC, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.wSr = ((MMImageView)paramView.findViewById(R.h.content_iv));
      paramViewGroup.pJL = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.wSt = paramView.findViewById(R.h.fVH);
      paramViewGroup.wSu = paramView.findViewById(R.h.fVN);
      paramViewGroup.wSs = ((ImageView)paramView.findViewById(R.h.fTl));
      paramViewGroup.pUL = ((TextView)paramView.findViewById(R.h.name_tv));
      paramView.setTag(paramViewGroup);
      localc = IZ(paramInt);
      paramViewGroup.wSr.setTag(localc.filePath);
      paramViewGroup.wSt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22857);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          b.a(b.this, paramInt);
          b.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22857);
        }
      });
      if (!this.uZQ.contains(Integer.valueOf(paramInt))) {
        break label328;
      }
      paramViewGroup.pJL.setChecked(true);
      paramViewGroup.wSu.setVisibility(0);
      label188:
      if (localc.type != 3) {
        break label348;
      }
      paramViewGroup.wSs.setVisibility(0);
    }
    for (;;)
    {
      if (localc.type != 4) {
        break label360;
      }
      r.bKe().a(localc.thumbPath, paramViewGroup.wSr);
      paramViewGroup.wSr.setImageResource(x.bpA(com.tencent.mm.vfs.y.alV(localc.filePath)));
      if (localc.filePath != null)
      {
        paramViewGroup.pUL.setText(new u(localc.filePath).getName());
        paramViewGroup.pUL.setVisibility(0);
      }
      Log.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(22867);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label328:
      paramViewGroup.pJL.setChecked(false);
      paramViewGroup.wSu.setVisibility(8);
      break label188;
      label348:
      paramViewGroup.wSs.setVisibility(8);
    }
    label360:
    if (wSj == 0) {
      wSj = paramView.getMeasuredWidth();
    }
    Object localObject = new c.a();
    ((c.a)localObject).oKs = 1;
    ((c.a)localObject).oKq = false;
    ((c.a)localObject).npV = wSj;
    ((c.a)localObject).npU = wSj;
    if ((localc.type != 1) && (localc.msgType == 486539313))
    {
      ((c.a)localObject).fullPath = com.tencent.mm.pluginsdk.model.y.bpF(localc.thumbPath);
      ((c.a)localObject).oKs = 5;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(localc.thumbPath, paramViewGroup.wSr, (com.tencent.mm.modelimage.loader.a.c)localObject);
    }
    for (;;)
    {
      paramViewGroup.pUL.setVisibility(8);
      break;
      ((c.a)localObject).fullPath = localc.thumbPath;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(localc.thumbPath, paramViewGroup.wSr, (com.tencent.mm.modelimage.loader.a.c)localObject);
    }
  }
  
  final class a
  {
    int position;
    TextView wSo;
    TextView wSp;
    CheckBox wSq;
    
    a() {}
  }
  
  final class c
  {
    CheckBox pJL;
    TextView pUL;
    MMImageView wSr;
    ImageView wSs;
    View wSt;
    View wSu;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b
 * JD-Core Version:    0.7.0.1
 */