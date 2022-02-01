package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
  implements com.tencent.mm.ui.gridviewheaders.e
{
  private static int nOl = 0;
  private boolean bgc;
  ArrayList<com.tencent.mm.plugin.clean.c.c> dataList;
  boolean isStop;
  AdapterView.OnItemClickListener mUR;
  HashSet<Integer> mtN;
  private CleanChattingDetailUI nOk;
  GridHeadersGridView.c nOm;
  private ap nOn;
  AbsListView.OnScrollListener nOo;
  private String username;
  
  public b(CleanChattingDetailUI paramCleanChattingDetailUI, String paramString)
  {
    AppMethodBeat.i(22864);
    this.isStop = false;
    this.nOm = new GridHeadersGridView.c()
    {
      public final void dH(View paramAnonymousView)
      {
        AppMethodBeat.i(22858);
        paramAnonymousView = (b.a)paramAnonymousView.getTag();
        b.a(b.this, paramAnonymousView);
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(22858);
      }
    };
    this.mUR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(22859);
        ad.i("MicroMsg.CleanChattingDetailAdapter", "Click Item position=%d, count=%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(b.this.getCount()) });
        if ((paramAnonymousInt < 0) || (paramAnonymousInt >= b.this.getCount()))
        {
          AppMethodBeat.o(22859);
          return;
        }
        paramAnonymousAdapterView = b.this.zv(paramAnonymousInt);
        paramAnonymousView = new Intent();
        switch (paramAnonymousAdapterView.type)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(22859);
          return;
          paramAnonymousView.setAction("android.intent.action.VIEW");
          m.a(b.e(b.this), paramAnonymousView, new com.tencent.mm.vfs.e(paramAnonymousAdapterView.filePath), "video/*");
          try
          {
            paramAnonymousAdapterView = b.e(b.this);
            paramAnonymousView = Intent.createChooser(paramAnonymousView, b.e(b.this).getString(2131764704));
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanChattingDetailAdapter$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(22859);
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            AppMethodBeat.o(22859);
            return;
          }
          paramAnonymousView.putExtra("key_title", b.e(b.this).getString(2131757390));
          paramAnonymousView.putExtra("show_menu", false);
          if (i.eK(paramAnonymousAdapterView.filePath)) {}
          for (paramAnonymousAdapterView = paramAnonymousAdapterView.filePath;; paramAnonymousAdapterView = paramAnonymousAdapterView.thumbPath)
          {
            paramAnonymousView.putExtra("key_image_path", paramAnonymousAdapterView);
            d.e(b.e(b.this), ".ui.tools.ShowImageUI", paramAnonymousView);
            AppMethodBeat.o(22859);
            return;
          }
          paramAnonymousView.putExtra("app_msg_id", paramAnonymousAdapterView.ded);
          d.e(b.e(b.this), ".ui.chatting.AppAttachDownloadUI", paramAnonymousView);
        }
      }
    };
    this.nOn = new ap()
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
    this.nOo = new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(22861);
        o.ayJ().cq(paramAnonymousInt);
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
    this.nOk = paramCleanChattingDetailUI;
    this.mtN = new HashSet();
    this.dataList = new ArrayList();
    this.username = paramString;
    AppMethodBeat.o(22864);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22869);
    if (paramView == null)
    {
      ad.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
      paramView = this.nOk.getLayoutInflater().inflate(2131493542, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.nOq = ((TextView)paramView.findViewById(2131300734));
      paramViewGroup.nOr = ((TextView)paramView.findViewById(2131300726));
      paramViewGroup.nOs = ((CheckBox)paramView.findViewById(2131300725));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject = zv(paramInt);
      paramViewGroup.position = paramInt;
      paramViewGroup.nOq.setText(h.formatTime(this.nOk.getString(2131759579), ((com.tencent.mm.plugin.clean.c.c)localObject).hAg / 1000L));
      long l = ((com.tencent.mm.plugin.clean.c.c)localObject).bNR();
      localObject = new HashSet();
      paramInt = 0;
      while (paramInt < this.dataList.size())
      {
        if (((com.tencent.mm.plugin.clean.c.c)this.dataList.get(paramInt)).bNR() == l) {
          ((HashSet)localObject).add(Integer.valueOf(paramInt));
        }
        paramInt += 1;
      }
      ad.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject = ((HashSet)localObject).iterator();
    paramInt = 1;
    if (((Iterator)localObject).hasNext())
    {
      int i = ((Integer)((Iterator)localObject).next()).intValue();
      if (this.mtN.contains(Integer.valueOf(i))) {
        break label295;
      }
      paramInt = 0;
    }
    label295:
    for (;;)
    {
      break;
      if (paramInt != 0) {
        paramViewGroup.nOs.setChecked(true);
      }
      for (;;)
      {
        AppMethodBeat.o(22869);
        return paramView;
        paramViewGroup.nOs.setChecked(false);
      }
    }
  }
  
  public final void bNY()
  {
    AppMethodBeat.i(22871);
    this.mtN.clear();
    bNZ();
    AppMethodBeat.o(22871);
  }
  
  final void bNZ()
  {
    AppMethodBeat.i(22870);
    this.nOk.zx(this.mtN.size());
    Object localObject = this.nOk;
    int i;
    if (this.mtN.size() == this.dataList.size())
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      ((CleanChattingDetailUI)localObject).nOA.setChecked(true);
    }
    long l;
    for (;;)
    {
      localObject = this.mtN.iterator();
      for (l = 0L; ((Iterator)localObject).hasNext(); l = ((com.tencent.mm.plugin.clean.c.c)this.dataList.get(i)).size + l) {
        i = ((Integer)((Iterator)localObject).next()).intValue();
      }
      i = 0;
      break;
      label118:
      ((CleanChattingDetailUI)localObject).nOA.setChecked(false);
    }
    localObject = this.nOk;
    if (l > 0L)
    {
      ((CleanChattingDetailUI)localObject).nOB.setText(((CleanChattingDetailUI)localObject).getString(2131758037, new Object[] { bt.mK(l) }));
      AppMethodBeat.o(22870);
      return;
    }
    ((CleanChattingDetailUI)localObject).nOB.setText("");
    AppMethodBeat.o(22870);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22865);
    int i = this.dataList.size();
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
      paramView = this.nOk.getLayoutInflater().inflate(2131493541, paramViewGroup, false);
      paramViewGroup = new c();
      paramViewGroup.nOt = ((MMImageView)paramView.findViewById(2131298760));
      paramViewGroup.icb = ((CheckBox)paramView.findViewById(2131304502));
      paramViewGroup.nOv = paramView.findViewById(2131304504);
      paramViewGroup.nOw = paramView.findViewById(2131304543);
      paramViewGroup.nOu = ((ImageView)paramView.findViewById(2131303286));
      paramViewGroup.imt = ((TextView)paramView.findViewById(2131302666));
      paramView.setTag(paramViewGroup);
      localc = zv(paramInt);
      paramViewGroup.nOt.setTag(localc.filePath);
      paramViewGroup.nOv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(22857);
          b.a(b.this, paramInt);
          b.this.notifyDataSetChanged();
          AppMethodBeat.o(22857);
        }
      });
      if (!this.mtN.contains(Integer.valueOf(paramInt))) {
        break label320;
      }
      paramViewGroup.icb.setChecked(true);
      paramViewGroup.nOw.setVisibility(0);
      label188:
      if (localc.type != 3) {
        break label340;
      }
      paramViewGroup.nOu.setVisibility(0);
    }
    for (;;)
    {
      if (localc.type != 4) {
        break label352;
      }
      o.ayJ().a(localc.thumbPath, paramViewGroup.nOt);
      paramViewGroup.nOt.setImageResource(q.aAJ(i.RK(localc.filePath)));
      paramViewGroup.imt.setText(new com.tencent.mm.vfs.e(localc.filePath).getName());
      paramViewGroup.imt.setVisibility(0);
      ad.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(22867);
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label320:
      paramViewGroup.icb.setChecked(false);
      paramViewGroup.nOw.setVisibility(8);
      break label188;
      label340:
      paramViewGroup.nOu.setVisibility(8);
    }
    label352:
    if (nOl == 0) {
      nOl = paramView.getMeasuredWidth();
    }
    Object localObject = new c.a();
    ((c.a)localObject).hjX = 1;
    ((c.a)localObject).hjV = false;
    ((c.a)localObject).gjw = nOl;
    ((c.a)localObject).gjv = nOl;
    if ((localc.type != 1) && (localc.msgType == 486539313))
    {
      ((c.a)localObject).gjt = r.aAK(localc.thumbPath);
      ((c.a)localObject).hjX = 5;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(localc.thumbPath, paramViewGroup.nOt, (com.tencent.mm.aw.a.a.c)localObject);
    }
    for (;;)
    {
      paramViewGroup.imt.setVisibility(8);
      break;
      ((c.a)localObject).gjt = localc.thumbPath;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(localc.thumbPath, paramViewGroup.nOt, (com.tencent.mm.aw.a.a.c)localObject);
    }
  }
  
  public final com.tencent.mm.plugin.clean.c.c zv(int paramInt)
  {
    AppMethodBeat.i(22866);
    com.tencent.mm.plugin.clean.c.c localc = (com.tencent.mm.plugin.clean.c.c)this.dataList.get(paramInt);
    AppMethodBeat.o(22866);
    return localc;
  }
  
  public final long zw(int paramInt)
  {
    AppMethodBeat.i(22868);
    long l = ((com.tencent.mm.plugin.clean.c.c)this.dataList.get(paramInt)).bNR();
    AppMethodBeat.o(22868);
    return l;
  }
  
  final class a
  {
    TextView nOq;
    TextView nOr;
    CheckBox nOs;
    int position;
    
    a() {}
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    private void cG(List<com.tencent.mm.plugin.f.b.a> paramList)
    {
      AppMethodBeat.i(22863);
      int j = paramList.size();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.plugin.f.b.a locala = (com.tencent.mm.plugin.f.b.a)paramList.get(i);
        com.tencent.mm.plugin.clean.c.c localc2 = (com.tencent.mm.plugin.clean.c.c)localHashMap.get(Long.valueOf(locala.field_msgId));
        com.tencent.mm.plugin.clean.c.c localc1 = localc2;
        if (localc2 == null)
        {
          localc1 = new com.tencent.mm.plugin.clean.c.c();
          localHashMap.put(Long.valueOf(locala.field_msgId), localc1);
          localArrayList.add(localc1);
        }
        localc1.nNL.add(locala);
        localc1.hAg = locala.field_msgtime;
        localc1.userName = locala.field_username;
        localc1.ded = locala.field_msgId;
        if (!com.tencent.mm.plugin.f.a.yK(locala.field_msgSubType)) {
          localc1.size += locala.field_size;
        }
        localc1.msgType = locala.field_msgType;
        switch (locala.field_msgSubType)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          localc1.filePath = (g.afB().gcV + locala.field_path);
          localc1.type = 3;
          continue;
          if (locala.field_msgType == 486539313) {}
          for (localc1.thumbPath = locala.field_path;; localc1.thumbPath = (g.afB().gcV + locala.field_path))
          {
            localc1.type = 3;
            break;
          }
          localc1.filePath = (g.afB().gcV + locala.field_path);
          localc1.type = 1;
          continue;
          localc1.thumbPath = (g.afB().gcV + locala.field_path);
          localc1.type = 1;
          continue;
          localc1.filePath = (g.afB().gcV + locala.field_path);
          localc1.type = 1;
          continue;
          localc1.thumbPath = (g.afB().gcV + locala.field_path);
          localc1.type = 1;
          continue;
          localc1.filePath = (g.afB().gcV + locala.field_path);
          localc1.type = 4;
          continue;
          localc1.thumbPath = (g.afB().gcV + locala.field_path);
          localc1.type = 4;
          continue;
          localc1.filePath = (g.afB().gcV + locala.field_path);
          localc1.type = 4;
          continue;
          localc1.thumbPath = (g.afB().gcV + locala.field_path);
          localc1.type = 4;
        }
      }
      paramList = localArrayList.iterator();
      while (paramList.hasNext()) {
        if (((com.tencent.mm.plugin.clean.c.c)paramList.next()).size <= 0L) {
          paramList.remove();
        }
      }
      b.d(b.this).addAll(localArrayList);
      AppMethodBeat.o(22863);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: sipush 22862
      //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: new 184	com/tencent/mm/pointers/PLong
      //   9: dup
      //   10: invokespecial 185	com/tencent/mm/pointers/PLong:<init>	()V
      //   13: astore 11
      //   15: new 184	com/tencent/mm/pointers/PLong
      //   18: dup
      //   19: invokespecial 185	com/tencent/mm/pointers/PLong:<init>	()V
      //   22: astore 12
      //   24: invokestatic 191	com/tencent/mm/plugin/f/b:bHc	()Lcom/tencent/mm/plugin/f/b;
      //   27: invokevirtual 195	com/tencent/mm/plugin/f/b:bHd	()Lcom/tencent/mm/plugin/f/b/b;
      //   30: astore 10
      //   32: aload_0
      //   33: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   36: invokestatic 199	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
      //   39: astore 13
      //   41: invokestatic 205	com/tencent/mm/sdk/platformtools/bt:GC	()J
      //   44: lstore_1
      //   45: new 116	java/lang/StringBuilder
      //   48: dup
      //   49: ldc 207
      //   51: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   54: aload 13
      //   56: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: ldc 212
      //   61: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   64: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   67: astore 14
      //   69: aconst_null
      //   70: astore 9
      //   72: aconst_null
      //   73: astore 8
      //   75: aload 10
      //   77: getfield 218	com/tencent/mm/plugin/f/b/b:db	Lcom/tencent/mm/sdk/e/e;
      //   80: aload 14
      //   82: aconst_null
      //   83: invokeinterface 224 3 0
      //   88: astore 10
      //   90: aload 10
      //   92: ifnull +63 -> 155
      //   95: aload 10
      //   97: astore 8
      //   99: aload 10
      //   101: astore 9
      //   103: aload 10
      //   105: invokeinterface 229 1 0
      //   110: ifeq +45 -> 155
      //   113: aload 10
      //   115: astore 8
      //   117: aload 10
      //   119: astore 9
      //   121: aload 11
      //   123: aload 10
      //   125: iconst_0
      //   126: invokeinterface 233 2 0
      //   131: putfield 236	com/tencent/mm/pointers/PLong:value	J
      //   134: aload 10
      //   136: astore 8
      //   138: aload 10
      //   140: astore 9
      //   142: aload 12
      //   144: aload 10
      //   146: iconst_1
      //   147: invokeinterface 233 2 0
      //   152: putfield 236	com/tencent/mm/pointers/PLong:value	J
      //   155: aload 10
      //   157: ifnull +10 -> 167
      //   160: aload 10
      //   162: invokeinterface 239 1 0
      //   167: ldc 241
      //   169: ldc 243
      //   171: iconst_2
      //   172: anewarray 4	java/lang/Object
      //   175: dup
      //   176: iconst_0
      //   177: aload 13
      //   179: aastore
      //   180: dup
      //   181: iconst_1
      //   182: lload_1
      //   183: invokestatic 247	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
      //   186: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   189: aastore
      //   190: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   193: aload 12
      //   195: aload 12
      //   197: getfield 236	com/tencent/mm/pointers/PLong:value	J
      //   200: lconst_1
      //   201: lsub
      //   202: putfield 236	com/tencent/mm/pointers/PLong:value	J
      //   205: aload 11
      //   207: getfield 236	com/tencent/mm/pointers/PLong:value	J
      //   210: lstore 5
      //   212: lload 5
      //   214: ldc2_w 253
      //   217: lsub
      //   218: aload 12
      //   220: getfield 236	com/tencent/mm/pointers/PLong:value	J
      //   223: invokestatic 260	java/lang/Math:max	(JJ)J
      //   226: lstore_3
      //   227: aload_0
      //   228: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   231: invokestatic 263	com/tencent/mm/plugin/clean/ui/fileindexui/b:b	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Z
      //   234: istore 7
      //   236: iload 7
      //   238: ifeq +73 -> 311
      //   241: sipush 22862
      //   244: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   247: return
      //   248: astore 10
      //   250: aload 8
      //   252: astore 9
      //   254: ldc 241
      //   256: aload 10
      //   258: ldc_w 265
      //   261: iconst_1
      //   262: anewarray 4	java/lang/Object
      //   265: dup
      //   266: iconst_0
      //   267: aload 14
      //   269: aastore
      //   270: invokestatic 269	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   273: aload 8
      //   275: ifnull -108 -> 167
      //   278: aload 8
      //   280: invokeinterface 239 1 0
      //   285: goto -118 -> 167
      //   288: astore 8
      //   290: aload 9
      //   292: ifnull +10 -> 302
      //   295: aload 9
      //   297: invokeinterface 239 1 0
      //   302: sipush 22862
      //   305: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   308: aload 8
      //   310: athrow
      //   311: lload_3
      //   312: lstore_1
      //   313: lload_3
      //   314: lload 5
      //   316: lcmp
      //   317: ifne +7 -> 324
      //   320: lload_3
      //   321: lconst_1
      //   322: lsub
      //   323: lstore_1
      //   324: aload_0
      //   325: invokestatic 191	com/tencent/mm/plugin/f/b:bHc	()Lcom/tencent/mm/plugin/f/b;
      //   328: invokevirtual 195	com/tencent/mm/plugin/f/b:bHd	()Lcom/tencent/mm/plugin/f/b/b;
      //   331: aload_0
      //   332: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   335: invokestatic 199	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
      //   338: lload 5
      //   340: lload_1
      //   341: invokevirtual 273	com/tencent/mm/plugin/f/b/b:w	(Ljava/lang/String;JJ)Ljava/util/List;
      //   344: invokespecial 275	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:cG	(Ljava/util/List;)V
      //   347: aload_0
      //   348: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   351: invokestatic 278	com/tencent/mm/plugin/clean/ui/fileindexui/b:c	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)V
      //   354: lload_1
      //   355: lstore_3
      //   356: aload_0
      //   357: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   360: invokestatic 263	com/tencent/mm/plugin/clean/ui/fileindexui/b:b	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Z
      //   363: ifne +77 -> 440
      //   366: lload_3
      //   367: aload 12
      //   369: getfield 236	com/tencent/mm/pointers/PLong:value	J
      //   372: lcmp
      //   373: ifle +67 -> 440
      //   376: lload_3
      //   377: ldc2_w 279
      //   380: lsub
      //   381: aload 12
      //   383: getfield 236	com/tencent/mm/pointers/PLong:value	J
      //   386: invokestatic 260	java/lang/Math:max	(JJ)J
      //   389: lstore 5
      //   391: lload 5
      //   393: lstore_1
      //   394: lload 5
      //   396: lload_3
      //   397: lcmp
      //   398: ifne +8 -> 406
      //   401: lload 5
      //   403: lconst_1
      //   404: lsub
      //   405: lstore_1
      //   406: aload_0
      //   407: invokestatic 191	com/tencent/mm/plugin/f/b:bHc	()Lcom/tencent/mm/plugin/f/b;
      //   410: invokevirtual 195	com/tencent/mm/plugin/f/b:bHd	()Lcom/tencent/mm/plugin/f/b/b;
      //   413: aload_0
      //   414: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   417: invokestatic 199	com/tencent/mm/plugin/clean/ui/fileindexui/b:a	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)Ljava/lang/String;
      //   420: lload_3
      //   421: lload_1
      //   422: invokevirtual 273	com/tencent/mm/plugin/f/b/b:w	(Ljava/lang/String;JJ)Ljava/util/List;
      //   425: invokespecial 275	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:cG	(Ljava/util/List;)V
      //   428: aload_0
      //   429: getfield 15	com/tencent/mm/plugin/clean/ui/fileindexui/b$b:nOp	Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;
      //   432: invokestatic 278	com/tencent/mm/plugin/clean/ui/fileindexui/b:c	(Lcom/tencent/mm/plugin/clean/ui/fileindexui/b;)V
      //   435: lload_1
      //   436: lstore_3
      //   437: goto -81 -> 356
      //   440: sipush 22862
      //   443: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   446: return
      //   447: astore 8
      //   449: ldc_w 282
      //   452: aload 8
      //   454: ldc_w 284
      //   457: iconst_0
      //   458: anewarray 4	java/lang/Object
      //   461: invokestatic 269	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   464: sipush 22862
      //   467: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   470: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	471	0	this	b
      //   44	392	1	l1	long
      //   226	211	3	l2	long
      //   210	192	5	l3	long
      //   234	3	7	bool	boolean
      //   73	206	8	localObject1	Object
      //   288	21	8	localObject2	Object
      //   447	6	8	localException1	Exception
      //   70	226	9	localObject3	Object
      //   30	131	10	localObject4	Object
      //   248	9	10	localException2	Exception
      //   13	193	11	localPLong1	com.tencent.mm.pointers.PLong
      //   22	360	12	localPLong2	com.tencent.mm.pointers.PLong
      //   39	139	13	str1	String
      //   67	201	14	str2	String
      // Exception table:
      //   from	to	target	type
      //   75	90	248	java/lang/Exception
      //   103	113	248	java/lang/Exception
      //   121	134	248	java/lang/Exception
      //   142	155	248	java/lang/Exception
      //   75	90	288	finally
      //   103	113	288	finally
      //   121	134	288	finally
      //   142	155	288	finally
      //   254	273	288	finally
      //   227	236	447	java/lang/Exception
      //   324	354	447	java/lang/Exception
      //   356	391	447	java/lang/Exception
      //   406	435	447	java/lang/Exception
    }
  }
  
  final class c
  {
    CheckBox icb;
    TextView imt;
    MMImageView nOt;
    ImageView nOu;
    View nOv;
    View nOw;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.b
 * JD-Core Version:    0.7.0.1
 */