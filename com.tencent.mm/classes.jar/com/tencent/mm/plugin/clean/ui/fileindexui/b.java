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
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.model.w;
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
  private static int tOT = 0;
  private boolean baz;
  boolean isStop;
  ArrayList<com.tencent.mm.plugin.clean.c.c> mXB;
  HashSet<Integer> rOC;
  AdapterView.OnItemClickListener syv;
  private CleanChattingDetailUI tOS;
  GridHeadersGridView.c tOU;
  private MMHandler tOV;
  AbsListView.OnScrollListener tOW;
  private String username;
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, String paramString)
  {
    AppMethodBeat.i(22864);
    this.isStop = false;
    this.tOU = new GridHeadersGridView.c()
    {
      public final void ec(View paramAnonymousView)
      {
        AppMethodBeat.i(22858);
        paramAnonymousView = (b.a)paramAnonymousView.getTag();
        b.a(b.this, paramAnonymousView);
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(22858);
      }
    };
    this.syv = new b.4(this);
    this.tOV = new MMHandler()
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
    this.tOW = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(22861);
        com.tencent.mm.ay.q.bml().onScrollStateChanged(paramAnonymousInt);
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
    this.tOS = paramCleanChattingDetailUI;
    this.rOC = new HashSet();
    this.mXB = new ArrayList();
    this.username = paramString;
    AppMethodBeat.o(22864);
  }
  
  public final com.tencent.mm.plugin.clean.c.c Iw(int paramInt)
  {
    AppMethodBeat.i(22866);
    com.tencent.mm.plugin.clean.c.c localc = (com.tencent.mm.plugin.clean.c.c)this.mXB.get(paramInt);
    AppMethodBeat.o(22866);
    return localc;
  }
  
  public final long Ix(int paramInt)
  {
    AppMethodBeat.i(22868);
    long l = ((com.tencent.mm.plugin.clean.c.c)this.mXB.get(paramInt)).cNg();
    AppMethodBeat.o(22868);
    return l;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22869);
    if (paramView == null)
    {
      Log.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.tOS.getLayoutInflater().inflate(R.i.eeL, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.tOY = ((TextView)paramView.findViewById(R.h.header_tv));
      paramViewGroup.tOZ = ((TextView)paramView.findViewById(R.h.dIt));
      paramViewGroup.tPa = ((CheckBox)paramView.findViewById(R.h.dIs));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = Iw(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.tOY.setText(f.formatTime(this.tOS.getString(R.l.fmt_year_month), ((com.tencent.mm.plugin.clean.c.c)localObject).mhP / 1000L));
      long l = ((com.tencent.mm.plugin.clean.c.c)localObject).cNg();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.mXB.size())
      {
        if (((com.tencent.mm.plugin.clean.c.c)this.mXB.get(paramInt)).cNg() == l) {
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
      if (this.rOC.contains(Integer.valueOf(i))) {
        break label300;
      }
      paramInt = 0;
    }
    label300:
    for (;;)
    {
      break;
      if (paramInt != 0) {
        paramViewGroup.tPa.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(22869);
        return paramView;
        paramViewGroup.tPa.setChecked(false);
      }
    }
  }
  
  public final void cNn()
  {
    AppMethodBeat.i(22871);
    this.rOC.clear();
    cNo();
    AppMethodBeat.o(22871);
  }
  
  final void cNo()
  {
    AppMethodBeat.i(22870);
    this.tOS.Iy(this.rOC.size());
    Object localObject = this.tOS;
    int i;
    if (this.rOC.size() == this.mXB.size())
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      ((CleanChattingDetailUI)localObject).tPi.setChecked(true);
    }
    long l;
    for (;;)
    {
      localObject = this.rOC.iterator();
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((com.tencent.mm.plugin.clean.c.c)this.mXB.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label118:
      ((CleanChattingDetailUI)localObject).tPi.setChecked(false);
    }
    localObject = this.tOS;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).tPj.setText(((CleanChattingDetailUI)localObject).getString(R.l.eBc, new Object[] { Util.getSizeKB(l) }));
      AppMethodBeat.o(22870);
      return;
    }
    ((CleanChattingDetailUI)localObject).tPj.setText("");
    AppMethodBeat.o(22870);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22865);
    int i = this.mXB.size();
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
      paramView = this.tOS.getLayoutInflater().inflate(R.i.eeK, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.tPb = ((MMImageView)paramView.findViewById(R.h.content_iv));
      paramViewGroup.mNd = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramViewGroup.tPd = paramView.findViewById(R.h.dTA);
      paramViewGroup.tPe = paramView.findViewById(R.h.dTF);
      paramViewGroup.tPc = ((ImageView)paramView.findViewById(R.h.dRh));
      paramViewGroup.mYd = ((TextView)paramView.findViewById(R.h.name_tv));
      paramView.setTag(paramViewGroup);
      localc = Iw(paramInt);
      paramViewGroup.tPb.setTag(localc.filePath);
      paramViewGroup.tPd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22857);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.a(b.this, paramInt);
          b.this.notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(22857);
        }
      });
      if (!this.rOC.contains(Integer.valueOf(paramInt))) {
        break label328;
      }
      paramViewGroup.mNd.setChecked(true);
      paramViewGroup.tPe.setVisibility(0);
      label188:
      if (localc.type != 3) {
        break label348;
      }
      paramViewGroup.tPc.setVisibility(0);
    }
    for (;;)
    {
      if (localc.type != 4) {
        break label360;
      }
      com.tencent.mm.ay.q.bml().a(localc.thumbPath, paramViewGroup.tPb);
      paramViewGroup.tPb.setImageResource(v.bpJ(u.asq(localc.filePath)));
      if (localc.filePath != null)
      {
        paramViewGroup.mYd.setText(new com.tencent.mm.vfs.q(localc.filePath).getName());
        paramViewGroup.mYd.setVisibility(0);
      }
      Log.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(22867);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label328:
      paramViewGroup.mNd.setChecked(false);
      paramViewGroup.tPe.setVisibility(8);
      break label188;
      label348:
      paramViewGroup.tPc.setVisibility(8);
    }
    label360:
    if (tOT == 0) {
      tOT = paramView.getMeasuredWidth();
    }
    Object localObject = new c.a();
    ((c.a)localObject).lRG = 1;
    ((c.a)localObject).lRE = false;
    ((c.a)localObject).kOg = tOT;
    ((c.a)localObject).kOf = tOT;
    if ((localc.type != 1) && (localc.msgType == 486539313))
    {
      ((c.a)localObject).fullPath = w.bpO(localc.thumbPath);
      ((c.a)localObject).lRG = 5;
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(localc.thumbPath, paramViewGroup.tPb, (com.tencent.mm.ay.a.a.c)localObject);
    }
    for (;;)
    {
      paramViewGroup.mYd.setVisibility(8);
      break;
      ((c.a)localObject).fullPath = localc.thumbPath;
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(localc.thumbPath, paramViewGroup.tPb, (com.tencent.mm.ay.a.a.c)localObject);
    }
  }
  
  final class a
  {
    int position;
    TextView tOY;
    TextView tOZ;
    CheckBox tPa;
    
    a() {}
  }
  
  final class c
  {
    CheckBox mNd;
    TextView mYd;
    MMImageView tPb;
    ImageView tPc;
    View tPd;
    View tPe;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b
 * JD-Core Version:    0.7.0.1
 */