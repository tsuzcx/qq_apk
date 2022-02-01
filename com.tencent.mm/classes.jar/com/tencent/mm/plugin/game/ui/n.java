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
import com.tencent.mm.b.f;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.f.e.b;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends q<com.tencent.mm.plugin.game.model.o>
{
  private static w skJ;
  private int dbk;
  private int fwP;
  private Context mContext;
  private int nCF;
  private int rXI;
  private View.OnClickListener skK;
  private View.OnClickListener skL;
  private v skM;
  private v skN;
  private long skO;
  private int skP;
  int skQ;
  private long skR;
  private com.tencent.mm.plugin.game.model.p skS;
  private f<String, Bitmap> skT;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.nCF = 15;
    this.fwP = 0;
    this.dbk = 0;
    this.skO = 0L;
    this.rXI = 0;
    this.skP = 0;
    this.skQ = 0;
    this.mContext = paramContext;
    this.rXI = paramInt;
    this.skR = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd();
    String str = s.A(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.fwP = i;
      this.dbk = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDt();
      skJ = new w();
      this.skK = new o(paramContext, paramInt);
      this.skL = new p(paramContext, paramInt);
      this.skM = new v(paramContext);
      this.skM.fP(paramInt, 1);
      this.skN = new v(paramContext);
      this.skN.fP(paramInt, 2);
      this.skS = new com.tencent.mm.plugin.game.model.p(paramContext, this.rXI);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131165442);
      int j = this.mContext.getResources().getDimensionPixelSize(2131165198);
      int k = this.mContext.getResources().getDimensionPixelSize(2131165500);
      this.skP = (a.ar(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.skT = new com.tencent.mm.memory.a.b(30, getClass());
      AppMethodBeat.o(42259);
      return;
    }
    if (paramo.moveToFirst()) {}
    for (i = paramo.getInt(0);; i = 0)
    {
      paramo.close();
      break;
    }
  }
  
  private com.tencent.mm.plugin.game.model.o EK(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (EJ(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.FNk;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.FNm != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.FNm.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (EL(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!getCursor().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.FNm == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.FNk, getCursor());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, getCursor());
    this.FNm.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean EL(int paramInt)
  {
    return (this.fwP > this.dbk) && (this.dbk > 0) && (paramInt > this.dbk);
  }
  
  private static com.tencent.mm.plugin.game.model.o a(com.tencent.mm.plugin.game.model.o paramo, Cursor paramCursor)
  {
    AppMethodBeat.i(42269);
    com.tencent.mm.plugin.game.model.o localo = paramo;
    if (paramo == null) {
      localo = new com.tencent.mm.plugin.game.model.o();
    }
    localo.convertFrom(paramCursor);
    AppMethodBeat.o(42269);
    return localo;
  }
  
  private void a(ImageView paramImageView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(42265);
    if (this.skT.aN(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.skT.get(paramString);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        b(paramImageView, paramString, paramFloat);
        AppMethodBeat.o(42265);
        return;
      }
      paramImageView.setImageBitmap(localBitmap);
      AppMethodBeat.o(42265);
      return;
    }
    b(paramImageView, paramString, paramFloat);
    AppMethodBeat.o(42265);
  }
  
  private void a(com.tencent.mm.plugin.game.model.o paramo, a parama)
  {
    AppMethodBeat.i(42261);
    LinkedList localLinkedList = new LinkedList();
    int i = 1;
    while (i < paramo.rWc.size())
    {
      localLinkedList.add(paramo.rWc.get(i));
      i += 1;
    }
    parama.slh.a(paramo, localLinkedList, this.skP, this.rXI, this.skT);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.hjS = false;
    locala.soG = paramFloat;
    com.tencent.mm.plugin.game.f.e.cEB().a(paramImageView, paramString, locala.cEC(), new e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42258);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          n.a(n.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(42258);
      }
    });
    AppMethodBeat.o(42266);
  }
  
  private void cEo()
  {
    AppMethodBeat.i(42274);
    if (this.skR <= 0L)
    {
      AppMethodBeat.o(42274);
      return;
    }
    int j = getCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.game.model.o localo = EK(i);
        if ((localo != null) && (localo.field_msgId == this.skR)) {
          this.skQ = i;
        }
      }
      else
      {
        this.skR = 0L;
        AppMethodBeat.o(42274);
        return;
      }
      i += 1;
    }
  }
  
  private void h(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42262);
    if (bt.isNullOrNil(paramString))
    {
      a.b.c(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    if (!this.skT.aN(paramString))
    {
      i(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.skT.get(paramString);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      i(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(42262);
  }
  
  private void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42263);
    paramImageView = com.tencent.mm.plugin.game.f.e.cEB().n(paramImageView, paramString);
    if (paramImageView != null) {
      this.skT.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  private void j(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.skT.aN(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.skT.get(paramString);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        b(paramImageView, paramString, 0.0F);
        AppMethodBeat.o(42264);
        return;
      }
      paramImageView.setImageBitmap(localBitmap);
      AppMethodBeat.o(42264);
      return;
    }
    b(paramImageView, paramString, 0.0F);
    AppMethodBeat.o(42264);
  }
  
  public final boolean EJ(int paramInt)
  {
    return (this.fwP > this.dbk) && (this.dbk > 0) && (paramInt == this.dbk);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(42267);
    s locals = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd();
    int i = this.nCF;
    String str = s.A(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + i, new String[0]));
    this.nCF = getCount();
    if (this.FNn != null) {
      this.FNn.aIp();
    }
    cEo();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void We()
  {
    AppMethodBeat.i(42268);
    cHX();
    Wd();
    AppMethodBeat.o(42268);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(42273);
    getCursor().close();
    Wd();
    AppMethodBeat.o(42273);
  }
  
  public final boolean bLj()
  {
    return this.nCF >= this.fwP;
  }
  
  public final void cEm()
  {
    AppMethodBeat.i(42270);
    if (bLj())
    {
      if (this.FNn != null) {
        this.FNn.aIp();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.nCF += 15;
    if (this.nCF > this.fwP) {
      this.nCF = this.fwP;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int cEn()
  {
    if ((this.fwP > this.dbk) && (this.dbk > 0)) {
      return 1;
    }
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42271);
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    if (this.count <= 0)
    {
      AppMethodBeat.o(42271);
      return 0;
    }
    int i = this.count;
    int j = cEn();
    AppMethodBeat.o(42271);
    return i + j;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42260);
    a locala;
    View localView;
    com.tencent.mm.plugin.game.model.o localo;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.context, 2131494355, null);
      locala.skW = ((ImageView)localView.findViewById(2131300891));
      locala.skV = ((LinearLayout)localView.findViewById(2131302519));
      locala.skX = ((LinearLayout)localView.findViewById(2131302525));
      locala.frs = ((TextView)localView.findViewById(2131302867));
      locala.skY = ((ImageView)localView.findViewById(2131297065));
      locala.kXT = ((TextView)localView.findViewById(2131305896));
      locala.skZ = ((TextView)localView.findViewById(2131302528));
      locala.sla = ((LinearLayout)localView.findViewById(2131302544));
      locala.slb = ((TextView)localView.findViewById(2131302546));
      locala.slc = ((ImageView)localView.findViewById(2131302545));
      locala.sld = ((ImageView)localView.findViewById(2131302532));
      locala.sle = ((TextView)localView.findViewById(2131302552));
      locala.slf = ((TextView)localView.findViewById(2131302549));
      locala.slh = ((GameMessageListContainerView)localView.findViewById(2131302556));
      locala.slg = ((LinearLayout)localView.findViewById(2131302527));
      localView.setTag(locala);
      localo = EK(paramInt);
      if ((localo == null) || (!localo.rWW)) {
        break label342;
      }
      locala.skV.setVisibility(8);
      locala.slg.setVisibility(0);
    }
    label318:
    label342:
    while (localo == null)
    {
      AppMethodBeat.o(42260);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
    }
    localo.cDf();
    int j;
    int i;
    if (!localo.rVq)
    {
      localo.rVq = true;
      j = paramInt + 1001;
      i = j;
      if (this.dbk > 0)
      {
        i = j;
        if (paramInt > this.dbk) {
          i = paramInt - 1;
        }
      }
      com.tencent.mm.game.report.e.a(this.mContext, 13, 1300, i, 1, 0, null, this.rXI, 0, null, null, com.tencent.mm.game.report.e.a(null, null, localo.rWS, null));
    }
    locala.skV.setVisibility(0);
    locala.slg.setVisibility(8);
    locala.sle.setText(com.tencent.mm.plugin.game.f.b.k(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.rWe.rXf)
      {
        f = 0.08333334F;
        if (localo.rWH == null) {
          break label1287;
        }
        a(locala.skW, localo.rWH.rXj, f);
        locala.skW.setVisibility(0);
        if (bt.isNullOrNil(localo.rWH.rXi)) {
          break label1240;
        }
        locala.frs.setText(localo.rWH.rXi);
        locala.frs.setVisibility(0);
        if (bt.isNullOrNil(localo.rWH.rXk)) {
          break label1253;
        }
        j(locala.skY, localo.rWH.rXk);
        locala.skY.setVisibility(0);
        if (bt.isNullOrNil(localo.rWH.rXb)) {
          break label1266;
        }
        locala.frs.setEnabled(true);
        locala.skW.setEnabled(true);
        paramView = new p.a(localo, localo.rWH.rXb, 1);
        paramViewGroup = new p.a(localo, localo.rWH.rXb, 2);
        locala.frs.setTag(paramView);
        locala.frs.setOnClickListener(this.skS);
        locala.skW.setTag(paramViewGroup);
        locala.skW.setOnClickListener(this.skS);
        label732:
        if (bt.isNullOrNil(localo.rWD)) {
          break label1708;
        }
        paramInt = localo.rWc.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.kXT.setText(this.context.getResources().getString(2131759951, new Object[] { Integer.valueOf(paramInt) }) + localo.rWD);
        label810:
        locala.kXT.setVisibility(0);
        label819:
        if (bt.isNullOrNil(localo.rWE)) {
          break label1721;
        }
        locala.skZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.rWE, locala.skZ.getTextSize()));
        locala.skZ.setVisibility(0);
        label867:
        a(localo, locala);
        if (bt.isNullOrNil(localo.rWI.mContent)) {
          break label1759;
        }
        locala.sla.setVisibility(0);
        if (bt.isNullOrNil(localo.rWI.rXb)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.rWI.rXb, 3);
        locala.sla.setTag(paramView);
        locala.sla.setOnClickListener(this.skS);
        locala.sla.setEnabled(true);
        label961:
        locala.slb.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.rWI.mContent, locala.slb.getTextSize()));
        if (bt.isNullOrNil(localo.rWI.rXa)) {
          break label1746;
        }
        j(locala.slc, localo.rWI.rXa);
        locala.slc.setVisibility(0);
        label1032:
        if (bt.isNullOrNil(localo.rWF)) {
          break label1784;
        }
        j(locala.sld, localo.rWF);
        locala.sld.setVisibility(0);
        if (bt.isNullOrNil(localo.rWG)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.rWG, 3);
        locala.sld.setTag(paramView);
        locala.sld.setOnClickListener(this.skS);
        locala.sld.setEnabled(true);
        label1123:
        if (bt.isNullOrNil(localo.rWJ.mName)) {
          break label1809;
        }
        locala.slf.setText(localo.rWJ.mName);
        locala.slf.setVisibility(0);
        if (bt.isNullOrNil(localo.rWJ.rXb)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.rWJ.rXb, 5);
        locala.slf.setTag(paramView);
        locala.slf.setOnClickListener(this.skS);
        locala.slf.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.frs.setVisibility(8);
        break label580;
        label1253:
        locala.skY.setVisibility(8);
        break label620;
        locala.frs.setEnabled(false);
        locala.skW.setEnabled(false);
        break label732;
        label1287:
        if (!bt.gL(localo.rWc))
        {
          paramViewGroup = (o.i)localo.rWc.get(0);
          if (!bt.isNullOrNil(paramViewGroup.bNK))
          {
            paramView = paramViewGroup.bNK;
            label1326:
            if (bt.isNullOrNil(paramViewGroup.rXo)) {
              break label1596;
            }
            locala.frs.setEnabled(true);
            locala.skW.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.rXo, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.rXo, 2);
            locala.frs.setTag(localObject);
            locala.frs.setOnClickListener(this.skS);
            locala.skW.setTag(locala1);
            locala.skW.setOnClickListener(this.skS);
            label1430:
            if (bt.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.frs.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView, locala.frs.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.frs.setVisibility(0);
            label1473:
            locala.skW.setVisibility(0);
            if (bt.isNullOrNil(paramViewGroup.rXl)) {
              break label1630;
            }
            a(locala.skW, paramViewGroup.rXl, f);
          }
          for (;;)
          {
            if (bt.isNullOrNil(paramViewGroup.rXn)) {
              break label1646;
            }
            j(locala.skY, paramViewGroup.rXn);
            locala.skY.setVisibility(0);
            break;
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramViewGroup.userName);
            if ((paramView == null) || (bt.isNullOrNil(paramView.ZX())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.ZX();
            break label1326;
            label1596:
            locala.frs.setEnabled(false);
            locala.skW.setEnabled(false);
            break label1430;
            label1617:
            locala.frs.setVisibility(8);
            break label1473;
            label1630:
            h(locala.skW, paramViewGroup.userName);
          }
          label1646:
          locala.skY.setVisibility(8);
          break label732;
        }
        locala.skW.setVisibility(8);
        locala.frs.setVisibility(8);
        locala.skY.setVisibility(8);
        break label732;
        label1692:
        locala.kXT.setText(localo.rWD);
        break label810;
        label1708:
        locala.kXT.setVisibility(8);
        break label819;
        label1721:
        locala.skZ.setVisibility(8);
        break label867;
        label1734:
        locala.sla.setEnabled(false);
        break label961;
        label1746:
        locala.slc.setVisibility(8);
        break label1032;
        label1759:
        locala.sla.setVisibility(8);
        break label1032;
        label1772:
        locala.sld.setEnabled(false);
        break label1123;
        label1784:
        locala.sld.setVisibility(8);
        break label1123;
        label1797:
        locala.slf.setEnabled(false);
        continue;
        label1809:
        locala.slf.setVisibility(8);
      }
    }
    locala.kXT.setVisibility(8);
    locala.skZ.setVisibility(8);
    locala.sla.setVisibility(8);
    locala.slc.setVisibility(8);
    locala.sld.setVisibility(8);
    locala.slf.setVisibility(8);
    locala.slf.setEnabled(false);
    locala.sld.setEnabled(false);
    locala.skW.setEnabled(false);
    locala.frs.setEnabled(false);
    locala.slh.setVisibility(8);
    locala.skY.setVisibility(8);
    if (!bt.gL(localo.rWc))
    {
      localObject = (o.i)localo.rWc.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((o.i)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.ZX();
        label1997:
        paramViewGroup = paramView;
        if (bt.isNullOrNil(paramView)) {
          paramViewGroup = ((o.i)localObject).bNK;
        }
        if (!bt.isNullOrNil(((o.i)localObject).rXm)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.rWc.size();
      if ((!bt.isNullOrNil(localo.rWa)) && ((localo.rWr & 1L) == 0L))
      {
        locala.slf.setText(localo.rWa);
        locala.slf.setVisibility(0);
        if ((localo.rWr & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(2131100440);
          locala.slf.setTextColor(j);
          locala.slf.setBackgroundResource(2131232492);
          locala.slf.setOnClickListener(this.skK);
          locala.slf.setTag(localo);
          locala.slf.setEnabled(true);
        }
      }
      else
      {
        label2161:
        if ((localo.field_msgType != 10) && (localo.field_msgType != 11)) {
          break label2433;
        }
        if (bt.isNullOrNil(localo.mAppName)) {
          break label2377;
        }
        locala.frs.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.mAppName, locala.frs.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.frs.setVisibility(0);
      }
      for (;;)
      {
        switch (localo.field_msgType)
        {
        case 3: 
        case 4: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          ad.e("MicroMsg.GameMessageAdapter", "error msgtype: " + localo.field_msgType);
          break label318;
          j = this.context.getResources().getColor(2131100420);
          locala.slf.setTextColor(j);
          locala.slf.setBackgroundResource(0);
          locala.slf.setOnClickListener(null);
          locala.slf.setEnabled(false);
          break label2161;
          label2377:
          if (!bt.isNullOrNil(paramViewGroup))
          {
            locala.frs.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramViewGroup, locala.frs.getTextSize()));
            locala.frs.setVisibility(0);
          }
          else
          {
            locala.frs.setVisibility(8);
            continue;
            if (!bt.isNullOrNil(paramViewGroup))
            {
              locala.frs.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramViewGroup, locala.frs.getTextSize()));
              locala.frs.setVisibility(0);
              if (paramInt != 0)
              {
                locala.frs.setOnClickListener(this.skM);
                locala.frs.setTag(localo);
                locala.frs.setEnabled(true);
              }
            }
            else
            {
              locala.frs.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!bt.isNullOrNil(localo.rVW))
      {
        j(locala.skW, localo.rVW);
        locala.skW.setVisibility(0);
        label2558:
        if (!bt.isNullOrNil(localo.oAY))
        {
          if (bt.isNullOrNil(localo.rWi)) {
            break label2709;
          }
          locala.skZ.setText(localo.oAY);
          locala.skZ.setVisibility(0);
        }
      }
      while (!bt.isNullOrNil(localo.rWi))
      {
        j(locala.sld, localo.rWi);
        locala.sld.setTag(Long.valueOf(localo.field_msgId));
        locala.sld.setOnTouchListener(skJ);
        locala.sld.setOnClickListener(this.skL);
        locala.sld.setVisibility(0);
        locala.sld.setEnabled(true);
        break;
        ad.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.skW.setVisibility(8);
        break label2558;
        label2709:
        locala.sla.setVisibility(0);
        locala.slb.setText(localo.oAY);
        locala.sla.setOnClickListener(this.skL);
        locala.sla.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!bt.gL(localo.rWc))
      {
        locala.skW.setVisibility(0);
        if (!bt.isNullOrNil(((o.i)localo.rWc.get(0)).rXl))
        {
          j(locala.skW, ((o.i)localo.rWc.get(0)).rXl);
          label2827:
          if (!bt.isNullOrNil(((o.i)localo.rWc.get(0)).rXm))
          {
            locala.skW.setOnClickListener(this.skN);
            locala.skW.setTag(localo);
            locala.skW.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.sla.setVisibility(0);
        locala.sla.setOnClickListener(this.skL);
        locala.sla.setTag(Long.valueOf(localo.field_msgId));
        if (localo.rWP != 1) {
          break label3018;
        }
        locala.skZ.setVisibility(0);
        locala.skZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.rWv, locala.skZ.getTextSize()));
        locala.slb.setText(localo.rWy);
        break;
        h(locala.skW, ((o.i)localo.rWc.get(0)).userName);
        break label2827;
        locala.skW.setVisibility(8);
      }
      label3018:
      if (localo.rWP == 2)
      {
        locala.skZ.setVisibility(0);
        locala.skZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.rWv, locala.skZ.getTextSize()));
        locala.slb.setText(localo.rWw);
        break;
      }
      if (localo.rWP != 3) {
        break;
      }
      locala.kXT.setVisibility(0);
      if (i > 1)
      {
        locala.kXT.setText(this.context.getResources().getString(2131759943, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.slb.setText(localo.rWy);
        break;
        locala.kXT.setText(this.context.getResources().getString(2131759944));
      }
      j(locala.skW, localo.rVW);
      paramView = "礼物";
      if (localo.rWn.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.kXT.setText(this.context.getResources().getString(2131759949, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.kXT.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.rWn.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.kXT.setText(this.context.getResources().getString(2131759950, new Object[] { paramView }));
      }
      if (!bt.gL(localo.rWc))
      {
        locala.skW.setVisibility(0);
        if (!bt.isNullOrNil(((o.i)localo.rWc.get(0)).rXl))
        {
          j(locala.skW, ((o.i)localo.rWc.get(0)).rXl);
          label3402:
          if (!bt.isNullOrNil(((o.i)localo.rWc.get(0)).rXm))
          {
            locala.skW.setOnClickListener(this.skN);
            locala.skW.setTag(localo);
            locala.skW.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.kXT.setText(this.context.getResources().getString(2131759945, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.sla.setVisibility(0);
        locala.kXT.setVisibility(0);
        locala.slb.setText(localo.rWz);
        locala.sla.setOnClickListener(this.skL);
        locala.sla.setTag(Long.valueOf(localo.field_msgId));
        if (bt.isNullOrNil(localo.rWB)) {
          break;
        }
        locala.slc.setVisibility(0);
        j(locala.slc, localo.rWB);
        break;
        h(locala.skW, ((o.i)localo.rWc.get(0)).userName);
        break label3402;
        locala.skW.setVisibility(8);
        break label3454;
        label3637:
        locala.kXT.setText(this.context.getResources().getString(2131759946));
      }
      paramInt = 0;
      continue;
      paramView = null;
      break label1997;
      paramViewGroup = null;
      paramInt = 0;
    }
  }
  
  static final class a
  {
    public TextView frs;
    public TextView kXT;
    public LinearLayout skV;
    public ImageView skW;
    public LinearLayout skX;
    public ImageView skY;
    public TextView skZ;
    public LinearLayout sla;
    public TextView slb;
    public ImageView slc;
    public ImageView sld;
    public TextView sle;
    public TextView slf;
    public LinearLayout slg;
    public GameMessageListContainerView slh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */