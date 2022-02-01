package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.os.Message;
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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  extends BaseAdapter
  implements e
{
  private static int qql = 0;
  private boolean bqX;
  boolean isStop;
  ArrayList<com.tencent.mm.plugin.clean.c.c> kgc;
  HashSet<Integer> oMG;
  AdapterView.OnItemClickListener ppw;
  private CleanChattingDetailUI qqk;
  GridHeadersGridView.c qqm;
  private MMHandler qqn;
  AbsListView.OnScrollListener qqo;
  private String username;
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, String paramString)
  {
    AppMethodBeat.i(22864);
    this.isStop = false;
    this.qqm = new GridHeadersGridView.c()
    {
      public final void dE(View paramAnonymousView)
      {
        AppMethodBeat.i(22858);
        paramAnonymousView = (b.a)paramAnonymousView.getTag();
        b.a(b.this, paramAnonymousView);
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(22858);
      }
    };
    this.ppw = new b.4(this);
    this.qqn = new MMHandler()
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
    this.qqo = new b.6(this);
    this.qqk = paramCleanChattingDetailUI;
    this.oMG = new HashSet();
    this.kgc = new ArrayList();
    this.username = paramString;
    AppMethodBeat.o(22864);
  }
  
  public final com.tencent.mm.plugin.clean.c.c EP(int paramInt)
  {
    AppMethodBeat.i(22866);
    com.tencent.mm.plugin.clean.c.c localc = (com.tencent.mm.plugin.clean.c.c)this.kgc.get(paramInt);
    AppMethodBeat.o(22866);
    return localc;
  }
  
  public final long EQ(int paramInt)
  {
    AppMethodBeat.i(22868);
    long l = ((com.tencent.mm.plugin.clean.c.c)this.kgc.get(paramInt)).cyL();
    AppMethodBeat.o(22868);
    return l;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22869);
    if (paramView == null)
    {
      Log.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.qqk.getLayoutInflater().inflate(2131493654, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.qqq = ((TextView)paramView.findViewById(2131302315));
      paramViewGroup.qqr = ((TextView)paramView.findViewById(2131302306));
      paramViewGroup.qqs = ((CheckBox)paramView.findViewById(2131302305));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = EP(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.qqq.setText(f.formatTime(this.qqk.getString(2131760896), ((com.tencent.mm.plugin.clean.c.c)localObject).jsm / 1000L));
      long l = ((com.tencent.mm.plugin.clean.c.c)localObject).cyL();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.kgc.size())
      {
        if (((com.tencent.mm.plugin.clean.c.c)this.kgc.get(paramInt)).cyL() == l) {
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
      if (this.oMG.contains(Integer.valueOf(i))) {
        break label295;
      }
      paramInt = 0;
    }
    label295:
    for (;;)
    {
      break;
      if (paramInt != 0) {
        paramViewGroup.qqs.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(22869);
        return paramView;
        paramViewGroup.qqs.setChecked(false);
      }
    }
  }
  
  public final void cyS()
  {
    AppMethodBeat.i(22871);
    this.oMG.clear();
    cyT();
    AppMethodBeat.o(22871);
  }
  
  final void cyT()
  {
    AppMethodBeat.i(22870);
    this.qqk.ER(this.oMG.size());
    Object localObject = this.qqk;
    int i;
    if (this.oMG.size() == this.kgc.size())
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      ((CleanChattingDetailUI)localObject).qqA.setChecked(true);
    }
    long l;
    for (;;)
    {
      localObject = this.oMG.iterator();
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((com.tencent.mm.plugin.clean.c.c)this.kgc.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label118:
      ((CleanChattingDetailUI)localObject).qqA.setChecked(false);
    }
    localObject = this.qqk;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).qqB.setText(((CleanChattingDetailUI)localObject).getString(2131758289, new Object[] { Util.getSizeKB(l) }));
      AppMethodBeat.o(22870);
      return;
    }
    ((CleanChattingDetailUI)localObject).qqB.setText("");
    AppMethodBeat.o(22870);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22865);
    int i = this.kgc.size();
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
      paramView = this.qqk.getLayoutInflater().inflate(2131493653, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.qqt = ((MMImageView)paramView.findViewById(2131299204));
      paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131307508));
      paramViewGroup.qqv = paramView.findViewById(2131307510);
      paramViewGroup.qqw = paramView.findViewById(2131307567);
      paramViewGroup.qqu = ((ImageView)paramView.findViewById(2131305959));
      paramViewGroup.kgE = ((TextView)paramView.findViewById(2131305220));
      paramView.setTag(paramViewGroup);
      localc = EP(paramInt);
      paramViewGroup.qqt.setTag(localc.filePath);
      paramViewGroup.qqv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22857);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          b.a(b.this, paramInt);
          b.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22857);
        }
      });
      if (!this.oMG.contains(Integer.valueOf(paramInt))) {
        break label320;
      }
      paramViewGroup.jVQ.setChecked(true);
      paramViewGroup.qqw.setVisibility(0);
      label188:
      if (localc.type != 3) {
        break label340;
      }
      paramViewGroup.qqu.setVisibility(0);
    }
    for (;;)
    {
      if (localc.type != 4) {
        break label352;
      }
      q.bcV().a(localc.thumbPath, paramViewGroup.qqt);
      paramViewGroup.qqt.setImageResource(r.bdt(com.tencent.mm.vfs.s.akC(localc.filePath)));
      paramViewGroup.kgE.setText(new o(localc.filePath).getName());
      paramViewGroup.kgE.setVisibility(0);
      Log.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(22867);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label320:
      paramViewGroup.jVQ.setChecked(false);
      paramViewGroup.qqw.setVisibility(8);
      break label188;
      label340:
      paramViewGroup.qqu.setVisibility(8);
    }
    label352:
    if (qql == 0) {
      qql = paramView.getMeasuredWidth();
    }
    Object localObject = new c.a();
    ((c.a)localObject).jbi = 1;
    ((c.a)localObject).jbg = false;
    ((c.a)localObject).hZA = qql;
    ((c.a)localObject).hZz = qql;
    if ((localc.type != 1) && (localc.msgType == 486539313))
    {
      ((c.a)localObject).fullPath = com.tencent.mm.pluginsdk.model.s.bdu(localc.thumbPath);
      ((c.a)localObject).jbi = 5;
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(localc.thumbPath, paramViewGroup.qqt, (com.tencent.mm.av.a.a.c)localObject);
    }
    for (;;)
    {
      paramViewGroup.kgE.setVisibility(8);
      break;
      ((c.a)localObject).fullPath = localc.thumbPath;
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(localc.thumbPath, paramViewGroup.qqt, (com.tencent.mm.av.a.a.c)localObject);
    }
  }
  
  final class a
  {
    int position;
    TextView qqq;
    TextView qqr;
    CheckBox qqs;
    
    a() {}
  }
  
  final class c
  {
    CheckBox jVQ;
    TextView kgE;
    MMImageView qqt;
    ImageView qqu;
    View qqv;
    View qqw;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b
 * JD-Core Version:    0.7.0.1
 */