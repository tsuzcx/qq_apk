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
import com.tencent.mm.cc.a;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends r<com.tencent.mm.plugin.game.model.o>
{
  private static w tsC;
  private int cYG;
  private int fAw;
  private Context mContext;
  private int ofG;
  private int tfA;
  private View.OnClickListener tsD;
  private View.OnClickListener tsE;
  private v tsF;
  private v tsG;
  private long tsH;
  private int tsI;
  int tsJ;
  private long tsK;
  private com.tencent.mm.plugin.game.model.p tsL;
  private f<String, Bitmap> tsM;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.ofG = 15;
    this.fAw = 0;
    this.cYG = 0;
    this.tsH = 0L;
    this.tfA = 0;
    this.tsI = 0;
    this.tsJ = 0;
    this.mContext = paramContext;
    this.tfA = paramInt;
    this.tsK = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm();
    String str = s.A(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.fAw = i;
      this.cYG = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().cQD();
      tsC = new w();
      this.tsD = new o(paramContext, paramInt);
      this.tsE = new p(paramContext, paramInt);
      this.tsF = new v(paramContext);
      this.tsF.fW(paramInt, 1);
      this.tsG = new v(paramContext);
      this.tsG.fW(paramInt, 2);
      this.tsL = new com.tencent.mm.plugin.game.model.p(paramContext, this.tfA);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131165442);
      int j = this.mContext.getResources().getDimensionPixelSize(2131165198);
      int k = this.mContext.getResources().getDimensionPixelSize(2131165500);
      this.tsI = (a.ax(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.tsM = new com.tencent.mm.memory.a.b(30, getClass());
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
  
  private com.tencent.mm.plugin.game.model.o GG(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (GF(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.HmV;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.HmX != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.HmX.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (GH(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!getCursor().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.HmX == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.HmV, getCursor());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, getCursor());
    this.HmX.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean GH(int paramInt)
  {
    return (this.fAw > this.cYG) && (this.cYG > 0) && (paramInt > this.cYG);
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
    if (this.tsM.aK(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.tsM.get(paramString);
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
    while (i < paramo.tdU.size())
    {
      localLinkedList.add(paramo.tdU.get(i));
      i += 1;
    }
    parama.tta.a(paramo, localLinkedList, this.tsI, this.tfA, this.tsM);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.hKv = false;
    locala.twz = paramFloat;
    com.tencent.mm.plugin.game.f.e.cRL().a(paramImageView, paramString, locala.cRM(), new e.b()
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
  
  private void cRy()
  {
    AppMethodBeat.i(42274);
    if (this.tsK <= 0L)
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
        com.tencent.mm.plugin.game.model.o localo = GG(i);
        if ((localo != null) && (localo.field_msgId == this.tsK)) {
          this.tsJ = i;
        }
      }
      else
      {
        this.tsK = 0L;
        AppMethodBeat.o(42274);
        return;
      }
      i += 1;
    }
  }
  
  private void h(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42262);
    if (bs.isNullOrNil(paramString))
    {
      a.b.c(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    if (!this.tsM.aK(paramString))
    {
      i(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.tsM.get(paramString);
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
    paramImageView = com.tencent.mm.plugin.game.f.e.cRL().n(paramImageView, paramString);
    if (paramImageView != null) {
      this.tsM.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  private void j(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.tsM.aK(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.tsM.get(paramString);
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
  
  public final boolean GF(int paramInt)
  {
    return (this.fAw > this.cYG) && (this.cYG > 0) && (paramInt == this.cYG);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(42267);
    s locals = ((com.tencent.mm.plugin.game.api.e)g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm();
    int i = this.ofG;
    String str = s.A(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + i, new String[0]));
    this.ofG = getCount();
    if (this.HmY != null) {
      this.HmY.aPg();
    }
    cRy();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(42268);
    cVi();
    Xb();
    AppMethodBeat.o(42268);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(42273);
    getCursor().close();
    Xb();
    AppMethodBeat.o(42273);
  }
  
  public final boolean bSw()
  {
    return this.ofG >= this.fAw;
  }
  
  public final void cRw()
  {
    AppMethodBeat.i(42270);
    if (bSw())
    {
      if (this.HmY != null) {
        this.HmY.aPg();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.ofG += 15;
    if (this.ofG > this.fAw) {
      this.ofG = this.fAw;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int cRx()
  {
    if ((this.fAw > this.cYG) && (this.cYG > 0)) {
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
    int j = cRx();
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
      locala.tsP = ((ImageView)localView.findViewById(2131300891));
      locala.tsO = ((LinearLayout)localView.findViewById(2131302519));
      locala.tsQ = ((LinearLayout)localView.findViewById(2131302525));
      locala.fuZ = ((TextView)localView.findViewById(2131302867));
      locala.tsR = ((ImageView)localView.findViewById(2131297065));
      locala.lzD = ((TextView)localView.findViewById(2131305896));
      locala.tsS = ((TextView)localView.findViewById(2131302528));
      locala.tsT = ((LinearLayout)localView.findViewById(2131302544));
      locala.tsU = ((TextView)localView.findViewById(2131302546));
      locala.tsV = ((ImageView)localView.findViewById(2131302545));
      locala.tsW = ((ImageView)localView.findViewById(2131302532));
      locala.tsX = ((TextView)localView.findViewById(2131302552));
      locala.tsY = ((TextView)localView.findViewById(2131302549));
      locala.tta = ((GameMessageListContainerView)localView.findViewById(2131302556));
      locala.tsZ = ((LinearLayout)localView.findViewById(2131302527));
      localView.setTag(locala);
      localo = GG(paramInt);
      if ((localo == null) || (!localo.teO)) {
        break label342;
      }
      locala.tsO.setVisibility(8);
      locala.tsZ.setVisibility(0);
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
    localo.cQp();
    int j;
    int i;
    if (!localo.tdi)
    {
      localo.tdi = true;
      j = paramInt + 1001;
      i = j;
      if (this.cYG > 0)
      {
        i = j;
        if (paramInt > this.cYG) {
          i = paramInt - 1;
        }
      }
      com.tencent.mm.game.report.e.a(this.mContext, 13, 1300, i, 1, 0, null, this.tfA, 0, null, null, com.tencent.mm.game.report.e.a(null, null, localo.teK, null));
    }
    locala.tsO.setVisibility(0);
    locala.tsZ.setVisibility(8);
    locala.tsX.setText(com.tencent.mm.plugin.game.f.b.l(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.tdW.teX)
      {
        f = 0.08333334F;
        if (localo.tez == null) {
          break label1287;
        }
        a(locala.tsP, localo.tez.tfb, f);
        locala.tsP.setVisibility(0);
        if (bs.isNullOrNil(localo.tez.tfa)) {
          break label1240;
        }
        locala.fuZ.setText(localo.tez.tfa);
        locala.fuZ.setVisibility(0);
        if (bs.isNullOrNil(localo.tez.tfc)) {
          break label1253;
        }
        j(locala.tsR, localo.tez.tfc);
        locala.tsR.setVisibility(0);
        if (bs.isNullOrNil(localo.tez.teT)) {
          break label1266;
        }
        locala.fuZ.setEnabled(true);
        locala.tsP.setEnabled(true);
        paramView = new p.a(localo, localo.tez.teT, 1);
        paramViewGroup = new p.a(localo, localo.tez.teT, 2);
        locala.fuZ.setTag(paramView);
        locala.fuZ.setOnClickListener(this.tsL);
        locala.tsP.setTag(paramViewGroup);
        locala.tsP.setOnClickListener(this.tsL);
        label732:
        if (bs.isNullOrNil(localo.tev)) {
          break label1708;
        }
        paramInt = localo.tdU.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.lzD.setText(this.context.getResources().getString(2131759951, new Object[] { Integer.valueOf(paramInt) }) + localo.tev);
        label810:
        locala.lzD.setVisibility(0);
        label819:
        if (bs.isNullOrNil(localo.tew)) {
          break label1721;
        }
        locala.tsS.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.tew, locala.tsS.getTextSize()));
        locala.tsS.setVisibility(0);
        label867:
        a(localo, locala);
        if (bs.isNullOrNil(localo.teA.mContent)) {
          break label1759;
        }
        locala.tsT.setVisibility(0);
        if (bs.isNullOrNil(localo.teA.teT)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.teA.teT, 3);
        locala.tsT.setTag(paramView);
        locala.tsT.setOnClickListener(this.tsL);
        locala.tsT.setEnabled(true);
        label961:
        locala.tsU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.teA.mContent, locala.tsU.getTextSize()));
        if (bs.isNullOrNil(localo.teA.teS)) {
          break label1746;
        }
        j(locala.tsV, localo.teA.teS);
        locala.tsV.setVisibility(0);
        label1032:
        if (bs.isNullOrNil(localo.tex)) {
          break label1784;
        }
        j(locala.tsW, localo.tex);
        locala.tsW.setVisibility(0);
        if (bs.isNullOrNil(localo.tey)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.tey, 3);
        locala.tsW.setTag(paramView);
        locala.tsW.setOnClickListener(this.tsL);
        locala.tsW.setEnabled(true);
        label1123:
        if (bs.isNullOrNil(localo.teB.mName)) {
          break label1809;
        }
        locala.tsY.setText(localo.teB.mName);
        locala.tsY.setVisibility(0);
        if (bs.isNullOrNil(localo.teB.teT)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.teB.teT, 5);
        locala.tsY.setTag(paramView);
        locala.tsY.setOnClickListener(this.tsL);
        locala.tsY.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.fuZ.setVisibility(8);
        break label580;
        label1253:
        locala.tsR.setVisibility(8);
        break label620;
        locala.fuZ.setEnabled(false);
        locala.tsP.setEnabled(false);
        break label732;
        label1287:
        if (!bs.gY(localo.tdU))
        {
          paramViewGroup = (o.i)localo.tdU.get(0);
          if (!bs.isNullOrNil(paramViewGroup.bLs))
          {
            paramView = paramViewGroup.bLs;
            label1326:
            if (bs.isNullOrNil(paramViewGroup.tfg)) {
              break label1596;
            }
            locala.fuZ.setEnabled(true);
            locala.tsP.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.tfg, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.tfg, 2);
            locala.fuZ.setTag(localObject);
            locala.fuZ.setOnClickListener(this.tsL);
            locala.tsP.setTag(locala1);
            locala.tsP.setOnClickListener(this.tsL);
            label1430:
            if (bs.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView, locala.fuZ.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.fuZ.setVisibility(0);
            label1473:
            locala.tsP.setVisibility(0);
            if (bs.isNullOrNil(paramViewGroup.tfd)) {
              break label1630;
            }
            a(locala.tsP, paramViewGroup.tfd, f);
          }
          for (;;)
          {
            if (bs.isNullOrNil(paramViewGroup.tff)) {
              break label1646;
            }
            j(locala.tsR, paramViewGroup.tff);
            locala.tsR.setVisibility(0);
            break;
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramViewGroup.userName);
            if ((paramView == null) || (bs.isNullOrNil(paramView.aaS())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.aaS();
            break label1326;
            label1596:
            locala.fuZ.setEnabled(false);
            locala.tsP.setEnabled(false);
            break label1430;
            label1617:
            locala.fuZ.setVisibility(8);
            break label1473;
            label1630:
            h(locala.tsP, paramViewGroup.userName);
          }
          label1646:
          locala.tsR.setVisibility(8);
          break label732;
        }
        locala.tsP.setVisibility(8);
        locala.fuZ.setVisibility(8);
        locala.tsR.setVisibility(8);
        break label732;
        label1692:
        locala.lzD.setText(localo.tev);
        break label810;
        label1708:
        locala.lzD.setVisibility(8);
        break label819;
        label1721:
        locala.tsS.setVisibility(8);
        break label867;
        label1734:
        locala.tsT.setEnabled(false);
        break label961;
        label1746:
        locala.tsV.setVisibility(8);
        break label1032;
        label1759:
        locala.tsT.setVisibility(8);
        break label1032;
        label1772:
        locala.tsW.setEnabled(false);
        break label1123;
        label1784:
        locala.tsW.setVisibility(8);
        break label1123;
        label1797:
        locala.tsY.setEnabled(false);
        continue;
        label1809:
        locala.tsY.setVisibility(8);
      }
    }
    locala.lzD.setVisibility(8);
    locala.tsS.setVisibility(8);
    locala.tsT.setVisibility(8);
    locala.tsV.setVisibility(8);
    locala.tsW.setVisibility(8);
    locala.tsY.setVisibility(8);
    locala.tsY.setEnabled(false);
    locala.tsW.setEnabled(false);
    locala.tsP.setEnabled(false);
    locala.fuZ.setEnabled(false);
    locala.tta.setVisibility(8);
    locala.tsR.setVisibility(8);
    if (!bs.gY(localo.tdU))
    {
      localObject = (o.i)localo.tdU.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((o.i)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.aaS();
        label1997:
        paramViewGroup = paramView;
        if (bs.isNullOrNil(paramView)) {
          paramViewGroup = ((o.i)localObject).bLs;
        }
        if (!bs.isNullOrNil(((o.i)localObject).tfe)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.tdU.size();
      if ((!bs.isNullOrNil(localo.tdS)) && ((localo.tej & 1L) == 0L))
      {
        locala.tsY.setText(localo.tdS);
        locala.tsY.setVisibility(0);
        if ((localo.tej & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(2131100440);
          locala.tsY.setTextColor(j);
          locala.tsY.setBackgroundResource(2131232492);
          locala.tsY.setOnClickListener(this.tsD);
          locala.tsY.setTag(localo);
          locala.tsY.setEnabled(true);
        }
      }
      else
      {
        label2161:
        if ((localo.field_msgType != 10) && (localo.field_msgType != 11)) {
          break label2433;
        }
        if (bs.isNullOrNil(localo.mAppName)) {
          break label2377;
        }
        locala.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.mAppName, locala.fuZ.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.fuZ.setVisibility(0);
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
          ac.e("MicroMsg.GameMessageAdapter", "error msgtype: " + localo.field_msgType);
          break label318;
          j = this.context.getResources().getColor(2131100420);
          locala.tsY.setTextColor(j);
          locala.tsY.setBackgroundResource(0);
          locala.tsY.setOnClickListener(null);
          locala.tsY.setEnabled(false);
          break label2161;
          label2377:
          if (!bs.isNullOrNil(paramViewGroup))
          {
            locala.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramViewGroup, locala.fuZ.getTextSize()));
            locala.fuZ.setVisibility(0);
          }
          else
          {
            locala.fuZ.setVisibility(8);
            continue;
            if (!bs.isNullOrNil(paramViewGroup))
            {
              locala.fuZ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramViewGroup, locala.fuZ.getTextSize()));
              locala.fuZ.setVisibility(0);
              if (paramInt != 0)
              {
                locala.fuZ.setOnClickListener(this.tsF);
                locala.fuZ.setTag(localo);
                locala.fuZ.setEnabled(true);
              }
            }
            else
            {
              locala.fuZ.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!bs.isNullOrNil(localo.tdO))
      {
        j(locala.tsP, localo.tdO);
        locala.tsP.setVisibility(0);
        label2558:
        if (!bs.isNullOrNil(localo.pey))
        {
          if (bs.isNullOrNil(localo.tea)) {
            break label2709;
          }
          locala.tsS.setText(localo.pey);
          locala.tsS.setVisibility(0);
        }
      }
      while (!bs.isNullOrNil(localo.tea))
      {
        j(locala.tsW, localo.tea);
        locala.tsW.setTag(Long.valueOf(localo.field_msgId));
        locala.tsW.setOnTouchListener(tsC);
        locala.tsW.setOnClickListener(this.tsE);
        locala.tsW.setVisibility(0);
        locala.tsW.setEnabled(true);
        break;
        ac.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.tsP.setVisibility(8);
        break label2558;
        label2709:
        locala.tsT.setVisibility(0);
        locala.tsU.setText(localo.pey);
        locala.tsT.setOnClickListener(this.tsE);
        locala.tsT.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!bs.gY(localo.tdU))
      {
        locala.tsP.setVisibility(0);
        if (!bs.isNullOrNil(((o.i)localo.tdU.get(0)).tfd))
        {
          j(locala.tsP, ((o.i)localo.tdU.get(0)).tfd);
          label2827:
          if (!bs.isNullOrNil(((o.i)localo.tdU.get(0)).tfe))
          {
            locala.tsP.setOnClickListener(this.tsG);
            locala.tsP.setTag(localo);
            locala.tsP.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.tsT.setVisibility(0);
        locala.tsT.setOnClickListener(this.tsE);
        locala.tsT.setTag(Long.valueOf(localo.field_msgId));
        if (localo.teH != 1) {
          break label3018;
        }
        locala.tsS.setVisibility(0);
        locala.tsS.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.ten, locala.tsS.getTextSize()));
        locala.tsU.setText(localo.teq);
        break;
        h(locala.tsP, ((o.i)localo.tdU.get(0)).userName);
        break label2827;
        locala.tsP.setVisibility(8);
      }
      label3018:
      if (localo.teH == 2)
      {
        locala.tsS.setVisibility(0);
        locala.tsS.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, localo.ten, locala.tsS.getTextSize()));
        locala.tsU.setText(localo.teo);
        break;
      }
      if (localo.teH != 3) {
        break;
      }
      locala.lzD.setVisibility(0);
      if (i > 1)
      {
        locala.lzD.setText(this.context.getResources().getString(2131759943, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.tsU.setText(localo.teq);
        break;
        locala.lzD.setText(this.context.getResources().getString(2131759944));
      }
      j(locala.tsP, localo.tdO);
      paramView = "礼物";
      if (localo.tef.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.lzD.setText(this.context.getResources().getString(2131759949, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.lzD.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.tef.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.lzD.setText(this.context.getResources().getString(2131759950, new Object[] { paramView }));
      }
      if (!bs.gY(localo.tdU))
      {
        locala.tsP.setVisibility(0);
        if (!bs.isNullOrNil(((o.i)localo.tdU.get(0)).tfd))
        {
          j(locala.tsP, ((o.i)localo.tdU.get(0)).tfd);
          label3402:
          if (!bs.isNullOrNil(((o.i)localo.tdU.get(0)).tfe))
          {
            locala.tsP.setOnClickListener(this.tsG);
            locala.tsP.setTag(localo);
            locala.tsP.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.lzD.setText(this.context.getResources().getString(2131759945, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.tsT.setVisibility(0);
        locala.lzD.setVisibility(0);
        locala.tsU.setText(localo.ter);
        locala.tsT.setOnClickListener(this.tsE);
        locala.tsT.setTag(Long.valueOf(localo.field_msgId));
        if (bs.isNullOrNil(localo.tet)) {
          break;
        }
        locala.tsV.setVisibility(0);
        j(locala.tsV, localo.tet);
        break;
        h(locala.tsP, ((o.i)localo.tdU.get(0)).userName);
        break label3402;
        locala.tsP.setVisibility(8);
        break label3454;
        label3637:
        locala.lzD.setText(this.context.getResources().getString(2131759946));
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
    public TextView fuZ;
    public TextView lzD;
    public LinearLayout tsO;
    public ImageView tsP;
    public LinearLayout tsQ;
    public ImageView tsR;
    public TextView tsS;
    public LinearLayout tsT;
    public TextView tsU;
    public ImageView tsV;
    public ImageView tsW;
    public TextView tsX;
    public TextView tsY;
    public LinearLayout tsZ;
    public GameMessageListContainerView tta;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */