package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.n.f;
import com.tencent.mm.plugin.game.model.n.g;
import com.tencent.mm.plugin.game.model.n.h;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.plugin.game.model.o.a;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.p.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends com.tencent.mm.ui.p<com.tencent.mm.plugin.game.model.n>
{
  private static w nBm;
  private int cmy;
  private int eke;
  private int kxm;
  private Context mContext;
  private View.OnClickListener nBn;
  private View.OnClickListener nBo;
  private v nBp;
  private v nBq;
  private long nBr;
  private int nBs;
  private com.tencent.mm.plugin.game.model.o nBt;
  private f<String, Bitmap> nBu;
  private int nok;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.n paramn, int paramInt)
  {
    super(paramContext, paramn);
    AppMethodBeat.i(112068);
    this.kxm = 15;
    this.eke = 0;
    this.cmy = 0;
    this.nBr = 0L;
    this.nok = 0;
    this.nBs = 0;
    this.mContext = paramContext;
    this.nok = paramInt;
    paramn = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES();
    String str = r.x(new int[] { 2, 5, 6, 10, 11, 100 });
    paramn = paramn.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramn == null)
    {
      this.eke = i;
      this.cmy = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES().bGx();
      nBm = new w();
      this.nBn = new o(paramContext, paramInt);
      this.nBo = new p(paramContext, paramInt);
      this.nBp = new v(paramContext);
      this.nBp.ev(paramInt, 1);
      this.nBq = new v(paramContext);
      this.nBq.ev(paramInt, 2);
      this.nBt = new com.tencent.mm.plugin.game.model.o(paramContext, this.nok);
      paramInt = com.tencent.mm.plugin.game.f.c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131427734);
      int j = this.mContext.getResources().getDimensionPixelSize(2131427506);
      int k = this.mContext.getResources().getDimensionPixelSize(2131427792);
      this.nBs = (a.ar(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.nBu = new com.tencent.mm.memory.a.b(30, getClass());
      AppMethodBeat.o(112068);
      return;
    }
    if (paramn.moveToFirst()) {}
    for (i = paramn.getInt(0);; i = 0)
    {
      paramn.close();
      break;
    }
  }
  
  private static com.tencent.mm.plugin.game.model.n a(com.tencent.mm.plugin.game.model.n paramn, Cursor paramCursor)
  {
    AppMethodBeat.i(112077);
    com.tencent.mm.plugin.game.model.n localn = paramn;
    if (paramn == null) {
      localn = new com.tencent.mm.plugin.game.model.n();
    }
    localn.convertFrom(paramCursor);
    AppMethodBeat.o(112077);
    return localn;
  }
  
  private void a(com.tencent.mm.plugin.game.model.n paramn, n.a parama)
  {
    AppMethodBeat.i(112070);
    LinkedList localLinkedList = new LinkedList();
    int i = 1;
    while (i < paramn.nmZ.size())
    {
      localLinkedList.add(paramn.nmZ.get(i));
      i += 1;
    }
    parama.nBI.a(paramn, localLinkedList, this.nBs, this.nok, this.nBu);
    AppMethodBeat.o(112070);
  }
  
  private void e(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112071);
    if (bo.isNullOrNil(paramString))
    {
      a.b.c(paramImageView, paramString);
      AppMethodBeat.o(112071);
      return;
    }
    if (!this.nBu.Z(paramString))
    {
      f(paramImageView, paramString);
      AppMethodBeat.o(112071);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.nBu.get(paramString);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      f(paramImageView, paramString);
      AppMethodBeat.o(112071);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(112071);
  }
  
  private void f(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112072);
    paramImageView = com.tencent.mm.plugin.game.f.e.bHE().k(paramImageView, paramString);
    if (paramImageView != null) {
      this.nBu.put(paramString, paramImageView);
    }
    AppMethodBeat.o(112072);
  }
  
  private void g(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112073);
    if (this.nBu.Z(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.nBu.get(paramString);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        h(paramImageView, paramString);
        AppMethodBeat.o(112073);
        return;
      }
      paramImageView.setImageBitmap(localBitmap);
      AppMethodBeat.o(112073);
      return;
    }
    h(paramImageView, paramString);
    AppMethodBeat.o(112073);
  }
  
  private void h(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112074);
    e.a.a locala = new e.a.a();
    locala.eNK = false;
    com.tencent.mm.plugin.game.f.e.bHE().a(paramImageView, paramString, locala.bHF(), new n.1(this, paramString));
    AppMethodBeat.o(112074);
  }
  
  private com.tencent.mm.plugin.game.model.n xk(int paramInt)
  {
    AppMethodBeat.i(112080);
    if (xj(paramInt))
    {
      localn = (com.tencent.mm.plugin.game.model.n)this.zan;
      AppMethodBeat.o(112080);
      return localn;
    }
    if (this.zap != null)
    {
      localn = (com.tencent.mm.plugin.game.model.n)this.zap.get(Integer.valueOf(paramInt));
      if (localn != null)
      {
        AppMethodBeat.o(112080);
        return localn;
      }
    }
    if (xl(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!getCursor().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(112080);
      return null;
    }
    if (this.zap == null)
    {
      localn = a((com.tencent.mm.plugin.game.model.n)this.zan, getCursor());
      AppMethodBeat.o(112080);
      return localn;
    }
    com.tencent.mm.plugin.game.model.n localn = a(null, getCursor());
    this.zap.put(Integer.valueOf(paramInt), localn);
    AppMethodBeat.o(112080);
    return localn;
  }
  
  private boolean xl(int paramInt)
  {
    return (this.eke > this.cmy) && (this.cmy > 0) && (paramInt > this.cmy);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(112075);
    r localr = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bES();
    int i = this.kxm;
    String str = r.x(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(localr.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + i, new String[0]));
    this.kxm = getCount();
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(112075);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(112076);
    bKb();
    Ku();
    AppMethodBeat.o(112076);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(151891);
    getCursor().close();
    Ku();
    AppMethodBeat.o(151891);
  }
  
  public final void bHr()
  {
    AppMethodBeat.i(112078);
    if (bem())
    {
      if (this.zaq != null) {
        this.zaq.apT();
      }
      AppMethodBeat.o(112078);
      return;
    }
    this.kxm += 15;
    if (this.kxm > this.eke) {
      this.kxm = this.eke;
    }
    AppMethodBeat.o(112078);
  }
  
  public final int bHs()
  {
    if ((this.eke > this.cmy) && (this.cmy > 0)) {
      return 1;
    }
    return 0;
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112079);
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    if (this.count <= 0)
    {
      AppMethodBeat.o(112079);
      return 0;
    }
    int i = this.count;
    int j = bHs();
    AppMethodBeat.o(112079);
    return i + j;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112069);
    n.a locala;
    View localView;
    com.tencent.mm.plugin.game.model.n localn;
    if (paramView == null)
    {
      locala = new n.a();
      localView = View.inflate(this.context, 2130969793, null);
      locala.nBx = ((ImageView)localView.findViewById(2131821253));
      locala.nBw = ((LinearLayout)localView.findViewById(2131824171));
      locala.nBy = ((LinearLayout)localView.findViewById(2131824700));
      locala.egr = ((TextView)localView.findViewById(2131823254));
      locala.nBz = ((ImageView)localView.findViewById(2131824511));
      locala.ivt = ((TextView)localView.findViewById(2131823916));
      locala.nBA = ((TextView)localView.findViewById(2131824701));
      locala.nBB = ((LinearLayout)localView.findViewById(2131824703));
      locala.nBC = ((TextView)localView.findViewById(2131824705));
      locala.nBD = ((ImageView)localView.findViewById(2131824704));
      locala.nBE = ((ImageView)localView.findViewById(2131824706));
      locala.nBF = ((TextView)localView.findViewById(2131824707));
      locala.nBG = ((TextView)localView.findViewById(2131824708));
      locala.nBI = ((GameMessageListContainerView)localView.findViewById(2131824702));
      locala.nBH = ((LinearLayout)localView.findViewById(2131824709));
      localView.setTag(locala);
      localn = xk(paramInt);
      if ((localn == null) || (!localn.nnP)) {
        break label342;
      }
      locala.nBw.setVisibility(8);
      locala.nBH.setVisibility(0);
    }
    label318:
    label342:
    while (localn == null)
    {
      AppMethodBeat.o(112069);
      return localView;
      locala = (n.a)paramView.getTag();
      localView = paramView;
      break;
    }
    localn.bGm();
    if (!localn.nmt)
    {
      localn.nmt = true;
      com.tencent.mm.game.report.c.a(this.mContext, 13, 1301, paramInt + 1001, 1, 0, null, this.nok, 0, null, null, null);
    }
    locala.nBw.setVisibility(0);
    locala.nBH.setVisibility(8);
    locala.nBF.setText(com.tencent.mm.plugin.game.f.b.h(this.context, localn.field_createTime * 1000L));
    label560:
    label750:
    label759:
    Object localObject;
    if (localn.field_msgType == 100)
    {
      if (localn.nnD != null)
      {
        g(locala.nBx, localn.nnD.nnZ);
        locala.nBx.setVisibility(0);
        if (!bo.isNullOrNil(localn.nnD.nnY))
        {
          locala.egr.setText(localn.nnD.nnY);
          locala.egr.setVisibility(0);
          if (bo.isNullOrNil(localn.nnD.noa)) {
            break label1187;
          }
          g(locala.nBz, localn.nnD.noa);
          locala.nBz.setVisibility(0);
          if (bo.isNullOrNil(localn.nnD.nnU)) {
            break label1200;
          }
          locala.egr.setEnabled(true);
          locala.nBx.setEnabled(true);
          paramView = new o.a(localn, localn.nnD.nnU, 1);
          paramViewGroup = new o.a(localn, localn.nnD.nnU, 2);
          locala.egr.setTag(paramView);
          locala.egr.setOnClickListener(this.nBt);
          locala.nBx.setTag(paramViewGroup);
          locala.nBx.setOnClickListener(this.nBt);
          label672:
          if (bo.isNullOrNil(localn.nnz)) {
            break label1640;
          }
          paramInt = localn.nmZ.size();
          if (paramInt <= 1) {
            break label1624;
          }
          locala.ivt.setText(this.context.getResources().getString(2131300433, new Object[] { Integer.valueOf(paramInt) }) + localn.nnz);
          locala.ivt.setVisibility(0);
          if (bo.isNullOrNil(localn.nnA)) {
            break label1653;
          }
          locala.nBA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, localn.nnA, locala.nBA.getTextSize()));
          locala.nBA.setVisibility(0);
          label807:
          a(localn, locala);
          if (bo.isNullOrNil(localn.nnE.mContent)) {
            break label1691;
          }
          locala.nBB.setVisibility(0);
          if (bo.isNullOrNil(localn.nnE.nnU)) {
            break label1666;
          }
          paramView = new o.a(localn, localn.nnE.nnU, 3);
          locala.nBB.setTag(paramView);
          locala.nBB.setOnClickListener(this.nBt);
          locala.nBB.setEnabled(true);
          label901:
          locala.nBC.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, localn.nnE.mContent, locala.nBC.getTextSize()));
          if (bo.isNullOrNil(localn.nnE.nnT)) {
            break label1678;
          }
          g(locala.nBD, localn.nnE.nnT);
          locala.nBD.setVisibility(0);
          label972:
          if (bo.isNullOrNil(localn.nnB)) {
            break label1716;
          }
          g(locala.nBE, localn.nnB);
          locala.nBE.setVisibility(0);
          if (bo.isNullOrNil(localn.nnC)) {
            break label1704;
          }
          paramView = new o.a(localn, localn.nnC, 3);
          locala.nBE.setTag(paramView);
          locala.nBE.setOnClickListener(this.nBt);
          locala.nBE.setEnabled(true);
          label1063:
          if (bo.isNullOrNil(localn.nnF.mName)) {
            break label1741;
          }
          locala.nBG.setText(localn.nnF.mName);
          locala.nBG.setVisibility(0);
          if (bo.isNullOrNil(localn.nnF.nnU)) {
            break label1729;
          }
          paramView = new o.a(localn, localn.nnF.nnU, 5);
          locala.nBG.setTag(paramView);
          locala.nBG.setOnClickListener(this.nBt);
          locala.nBG.setEnabled(true);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112069);
        return localView;
        locala.egr.setVisibility(8);
        break;
        label1187:
        locala.nBz.setVisibility(8);
        break label560;
        label1200:
        locala.egr.setEnabled(false);
        locala.nBx.setEnabled(false);
        break label672;
        if (!bo.es(localn.nmZ))
        {
          paramViewGroup = (n.i)localn.nmZ.get(0);
          if (!bo.isNullOrNil(paramViewGroup.blZ))
          {
            paramView = paramViewGroup.blZ;
            label1260:
            if (bo.isNullOrNil(paramViewGroup.nof)) {
              break label1528;
            }
            locala.egr.setEnabled(true);
            locala.nBx.setEnabled(true);
            localObject = new o.a(localn, paramViewGroup.nof, 1);
            o.a locala1 = new o.a(localn, paramViewGroup.nof, 2);
            locala.egr.setTag(localObject);
            locala.egr.setOnClickListener(this.nBt);
            locala.nBx.setTag(locala1);
            locala.nBx.setOnClickListener(this.nBt);
            label1364:
            if (bo.isNullOrNil(paramView)) {
              break label1549;
            }
            locala.egr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramView, locala.egr.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.egr.setVisibility(0);
            label1407:
            locala.nBx.setVisibility(0);
            if (bo.isNullOrNil(paramViewGroup.noc)) {
              break label1562;
            }
            g(locala.nBx, paramViewGroup.noc);
          }
          for (;;)
          {
            if (bo.isNullOrNil(paramViewGroup.noe)) {
              break label1578;
            }
            g(locala.nBz, paramViewGroup.noe);
            locala.nBz.setVisibility(0);
            break;
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramViewGroup.userName);
            if ((paramView == null) || (bo.isNullOrNil(paramView.Of())))
            {
              paramView = paramViewGroup.userName;
              break label1260;
            }
            paramView = paramView.Of();
            break label1260;
            label1528:
            locala.egr.setEnabled(false);
            locala.nBx.setEnabled(false);
            break label1364;
            label1549:
            locala.egr.setVisibility(8);
            break label1407;
            label1562:
            e(locala.nBx, paramViewGroup.userName);
          }
          label1578:
          locala.nBz.setVisibility(8);
          break label672;
        }
        locala.nBx.setVisibility(8);
        locala.egr.setVisibility(8);
        locala.nBz.setVisibility(8);
        break label672;
        label1624:
        locala.ivt.setText(localn.nnz);
        break label750;
        label1640:
        locala.ivt.setVisibility(8);
        break label759;
        label1653:
        locala.nBA.setVisibility(8);
        break label807;
        label1666:
        locala.nBB.setEnabled(false);
        break label901;
        label1678:
        locala.nBD.setVisibility(8);
        break label972;
        label1691:
        locala.nBB.setVisibility(8);
        break label972;
        label1704:
        locala.nBE.setEnabled(false);
        break label1063;
        label1716:
        locala.nBE.setVisibility(8);
        break label1063;
        label1729:
        locala.nBG.setEnabled(false);
        continue;
        label1741:
        locala.nBG.setVisibility(8);
      }
    }
    locala.ivt.setVisibility(8);
    locala.nBA.setVisibility(8);
    locala.nBB.setVisibility(8);
    locala.nBD.setVisibility(8);
    locala.nBE.setVisibility(8);
    locala.nBG.setVisibility(8);
    locala.nBG.setEnabled(false);
    locala.nBE.setEnabled(false);
    locala.nBx.setEnabled(false);
    locala.egr.setEnabled(false);
    locala.nBI.setVisibility(8);
    locala.nBz.setVisibility(8);
    if (!bo.es(localn.nmZ))
    {
      localObject = (n.i)localn.nmZ.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((n.i)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.Of();
        label1929:
        paramViewGroup = paramView;
        if (bo.isNullOrNil(paramView)) {
          paramViewGroup = ((n.i)localObject).blZ;
        }
        if (!bo.isNullOrNil(((n.i)localObject).nod)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      int i = localn.nmZ.size();
      int j;
      if ((!bo.isNullOrNil(localn.nmX)) && ((localn.nnn & 1L) == 0L))
      {
        locala.nBG.setText(localn.nmX);
        locala.nBG.setVisibility(0);
        if ((localn.nnn & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(2131690115);
          locala.nBG.setTextColor(j);
          locala.nBG.setBackgroundResource(2130838957);
          locala.nBG.setOnClickListener(this.nBn);
          locala.nBG.setTag(localn);
          locala.nBG.setEnabled(true);
        }
      }
      else
      {
        label2093:
        if ((localn.field_msgType != 10) && (localn.field_msgType != 11)) {
          break label2365;
        }
        if (bo.isNullOrNil(localn.mAppName)) {
          break label2309;
        }
        locala.egr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, localn.mAppName, locala.egr.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.egr.setVisibility(0);
      }
      for (;;)
      {
        switch (localn.field_msgType)
        {
        case 3: 
        case 4: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          ab.e("MicroMsg.GameMessageAdapter", "error msgtype: " + localn.field_msgType);
          break label318;
          j = this.context.getResources().getColor(2131690097);
          locala.nBG.setTextColor(j);
          locala.nBG.setBackgroundResource(0);
          locala.nBG.setOnClickListener(null);
          locala.nBG.setEnabled(false);
          break label2093;
          label2309:
          if (!bo.isNullOrNil(paramViewGroup))
          {
            locala.egr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramViewGroup, locala.egr.getTextSize()));
            locala.egr.setVisibility(0);
          }
          else
          {
            locala.egr.setVisibility(8);
            continue;
            label2365:
            if (!bo.isNullOrNil(paramViewGroup))
            {
              locala.egr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, paramViewGroup, locala.egr.getTextSize()));
              locala.egr.setVisibility(0);
              if (paramInt != 0)
              {
                locala.egr.setOnClickListener(this.nBp);
                locala.egr.setTag(localn);
                locala.egr.setEnabled(true);
              }
            }
            else
            {
              locala.egr.setVisibility(8);
            }
          }
          break;
        }
      }
      if (!bo.isNullOrNil(localn.nmT))
      {
        g(locala.nBx, localn.nmT);
        locala.nBx.setVisibility(0);
        label2490:
        if (!bo.isNullOrNil(localn.lkK))
        {
          if (bo.isNullOrNil(localn.nnf)) {
            break label2641;
          }
          locala.nBA.setText(localn.lkK);
          locala.nBA.setVisibility(0);
        }
      }
      while (!bo.isNullOrNil(localn.nnf))
      {
        g(locala.nBE, localn.nnf);
        locala.nBE.setTag(Long.valueOf(localn.field_msgId));
        locala.nBE.setOnTouchListener(nBm);
        locala.nBE.setOnClickListener(this.nBo);
        locala.nBE.setVisibility(0);
        locala.nBE.setEnabled(true);
        break;
        ab.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.nBx.setVisibility(8);
        break label2490;
        label2641:
        locala.nBB.setVisibility(0);
        locala.nBC.setText(localn.lkK);
        locala.nBB.setOnClickListener(this.nBo);
        locala.nBB.setTag(Long.valueOf(localn.field_msgId));
      }
      if (!bo.es(localn.nmZ))
      {
        locala.nBx.setVisibility(0);
        if (!bo.isNullOrNil(((n.i)localn.nmZ.get(0)).noc))
        {
          g(locala.nBx, ((n.i)localn.nmZ.get(0)).noc);
          label2759:
          if (!bo.isNullOrNil(((n.i)localn.nmZ.get(0)).nod))
          {
            locala.nBx.setOnClickListener(this.nBq);
            locala.nBx.setTag(localn);
            locala.nBx.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.nBB.setVisibility(0);
        locala.nBB.setOnClickListener(this.nBo);
        locala.nBB.setTag(Long.valueOf(localn.field_msgId));
        if (localn.nnK != 1) {
          break label2950;
        }
        locala.nBA.setVisibility(0);
        locala.nBA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, localn.nnr, locala.nBA.getTextSize()));
        locala.nBC.setText(localn.nnu);
        break;
        e(locala.nBx, ((n.i)localn.nmZ.get(0)).userName);
        break label2759;
        locala.nBx.setVisibility(8);
      }
      label2950:
      if (localn.nnK == 2)
      {
        locala.nBA.setVisibility(0);
        locala.nBA.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.context, localn.nnr, locala.nBA.getTextSize()));
        locala.nBC.setText(localn.nns);
        break;
      }
      if (localn.nnK != 3) {
        break;
      }
      locala.ivt.setVisibility(0);
      if (i > 1)
      {
        locala.ivt.setText(this.context.getResources().getString(2131300427, new Object[] { String.valueOf(i) }));
        a(localn, locala);
      }
      for (;;)
      {
        locala.nBC.setText(localn.nnu);
        break;
        locala.ivt.setText(this.context.getResources().getString(2131300428));
      }
      g(locala.nBx, localn.nmT);
      paramView = "礼物";
      if (localn.nnk.contains("爱心"))
      {
        paramView = "爱心";
        label3153:
        if (i <= 1) {
          break label3237;
        }
        locala.ivt.setText(this.context.getResources().getString(2131300431, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.ivt.setVisibility(0);
        a(localn, locala);
        break;
        if (!localn.nnk.contains("体力")) {
          break label3153;
        }
        paramView = "体力";
        break label3153;
        label3237:
        locala.ivt.setText(this.context.getResources().getString(2131300432, new Object[] { paramView }));
      }
      if (!bo.es(localn.nmZ))
      {
        locala.nBx.setVisibility(0);
        if (!bo.isNullOrNil(((n.i)localn.nmZ.get(0)).noc))
        {
          g(locala.nBx, ((n.i)localn.nmZ.get(0)).noc);
          label3334:
          if (!bo.isNullOrNil(((n.i)localn.nmZ.get(0)).nod))
          {
            locala.nBx.setOnClickListener(this.nBq);
            locala.nBx.setTag(localn);
            locala.nBx.setEnabled(true);
          }
          label3386:
          if (i <= 1) {
            break label3569;
          }
          locala.ivt.setText(this.context.getResources().getString(2131300429, new Object[] { String.valueOf(i) }));
          a(localn, locala);
        }
      }
      for (;;)
      {
        locala.nBB.setVisibility(0);
        locala.ivt.setVisibility(0);
        locala.nBC.setText(localn.nnv);
        locala.nBB.setOnClickListener(this.nBo);
        locala.nBB.setTag(Long.valueOf(localn.field_msgId));
        if (bo.isNullOrNil(localn.nnx)) {
          break;
        }
        locala.nBD.setVisibility(0);
        g(locala.nBD, localn.nnx);
        break;
        e(locala.nBx, ((n.i)localn.nmZ.get(0)).userName);
        break label3334;
        locala.nBx.setVisibility(8);
        break label3386;
        label3569:
        locala.ivt.setText(this.context.getResources().getString(2131300430));
      }
      paramInt = 0;
      continue;
      paramView = null;
      break label1929;
      paramInt = 0;
      paramViewGroup = null;
    }
  }
  
  public final boolean xj(int paramInt)
  {
    return (this.eke > this.cmy) && (this.cmy > 0) && (paramInt == this.cmy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */