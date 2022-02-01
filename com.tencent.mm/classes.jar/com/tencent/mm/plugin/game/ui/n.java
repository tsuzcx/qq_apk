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
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.e.e.b;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.o.j;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.s.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends com.tencent.mm.ui.s<com.tencent.mm.plugin.game.model.o>
{
  private static w xUs;
  private int dCm;
  private int gAZ;
  private Context mContext;
  private int qdp;
  private int xGR;
  private long xUA;
  private com.tencent.mm.plugin.game.model.p xUB;
  private com.tencent.mm.b.f<String, Bitmap> xUC;
  private View.OnClickListener xUt;
  private View.OnClickListener xUu;
  private v xUv;
  private v xUw;
  private long xUx;
  private int xUy;
  int xUz;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.qdp = 15;
    this.gAZ = 0;
    this.dCm = 0;
    this.xUx = 0L;
    this.xGR = 0;
    this.xUy = 0;
    this.xUz = 0;
    this.mContext = paramContext;
    this.xGR = paramInt;
    this.xUA = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK();
    String str = com.tencent.mm.plugin.game.model.s.D(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.gAZ = i;
      this.dCm = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVz();
      xUs = new w();
      this.xUt = new o(paramContext, paramInt);
      this.xUu = new p(paramContext, paramInt);
      this.xUv = new v(paramContext);
      this.xUv.gL(paramInt, 1);
      this.xUw = new v(paramContext);
      this.xUw.gL(paramInt, 2);
      this.xUB = new com.tencent.mm.plugin.game.model.p(paramContext, this.xGR);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131165458);
      int j = this.mContext.getResources().getDimensionPixelSize(2131165201);
      int k = this.mContext.getResources().getDimensionPixelSize(2131165518);
      this.xUy = (a.E(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.xUC = new com.tencent.mm.memory.a.b(30, getClass());
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
  
  private com.tencent.mm.plugin.game.model.o Oy(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (Ox(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.OFE;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.OFH != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.OFH.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (Oz(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!getCursor().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.OFH == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.OFE, getCursor());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, getCursor());
    this.OFH.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean Oz(int paramInt)
  {
    return (this.gAZ > this.dCm) && (this.dCm > 0) && (paramInt > this.dCm);
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
    if (this.xUC.check(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.xUC.get(paramString);
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
    while (i < paramo.xFe.size())
    {
      localLinkedList.add(paramo.xFe.get(i));
      i += 1;
    }
    parama.xUQ.a(paramo, localLinkedList, this.xUy, this.xGR, this.xUC);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.jbd = false;
    locala.xZw = paramFloat;
    e.dWR().a(paramImageView, paramString, locala.dWS(), new e.b()
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
  
  private void dWv()
  {
    AppMethodBeat.i(42274);
    if (this.xUA <= 0L)
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
        com.tencent.mm.plugin.game.model.o localo = Oy(i);
        if ((localo != null) && (localo.field_msgId == this.xUA)) {
          this.xUz = i;
        }
      }
      else
      {
        this.xUA = 0L;
        AppMethodBeat.o(42274);
        return;
      }
      i += 1;
    }
  }
  
  private void k(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42262);
    if (Util.isNullOrNil(paramString))
    {
      a.b.c(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    if (!this.xUC.check(paramString))
    {
      l(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.xUC.get(paramString);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      l(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(42262);
  }
  
  private void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42263);
    paramImageView = e.dWR().q(paramImageView, paramString);
    if (paramImageView != null) {
      this.xUC.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  private void m(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.xUC.check(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.xUC.get(paramString);
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
  
  public final boolean Ox(int paramInt)
  {
    return (this.gAZ > this.dCm) && (this.dCm > 0) && (paramInt == this.dCm);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(42267);
    com.tencent.mm.plugin.game.model.s locals = ((com.tencent.mm.plugin.game.api.f)g.af(com.tencent.mm.plugin.game.api.f.class)).dSK();
    int i = this.qdp;
    String str = com.tencent.mm.plugin.game.model.s.D(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0" + " order by isRead, createTime desc limit " + i, new String[0]));
    this.qdp = getCount();
    if (this.OFI != null) {
      this.OFI.bnE();
    }
    dWv();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(42268);
    ebf();
    anp();
    AppMethodBeat.o(42268);
  }
  
  public final boolean cwg()
  {
    return this.qdp >= this.gAZ;
  }
  
  public final void dWt()
  {
    AppMethodBeat.i(42270);
    if (cwg())
    {
      if (this.OFI != null) {
        this.OFI.bnE();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.qdp += 15;
    if (this.qdp > this.gAZ) {
      this.qdp = this.gAZ;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int dWu()
  {
    if ((this.gAZ > this.dCm) && (this.dCm > 0)) {
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
    int j = dWu();
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
      localView = View.inflate(this.context, 2131494921, null);
      locala.xUF = ((ImageView)localView.findViewById(2131302497));
      locala.xUE = ((LinearLayout)localView.findViewById(2131304947));
      locala.xUG = ((LinearLayout)localView.findViewById(2131304954));
      locala.gvw = ((TextView)localView.findViewById(2131305440));
      locala.xUH = ((ImageView)localView.findViewById(2131297210));
      locala.nnM = ((TextView)localView.findViewById(2131309187));
      locala.xUI = ((TextView)localView.findViewById(2131304958));
      locala.xUJ = ((LinearLayout)localView.findViewById(2131304975));
      locala.xUK = ((TextView)localView.findViewById(2131304977));
      locala.xUL = ((ImageView)localView.findViewById(2131304976));
      locala.xUM = ((ImageView)localView.findViewById(2131304962));
      locala.xUN = ((TextView)localView.findViewById(2131304984));
      locala.xUO = ((TextView)localView.findViewById(2131304980));
      locala.xUQ = ((GameMessageListContainerView)localView.findViewById(2131304988));
      locala.xUP = ((LinearLayout)localView.findViewById(2131304957));
      localView.setTag(locala);
      localo = Oy(paramInt);
      if ((localo == null) || (!localo.xGb)) {
        break label342;
      }
      locala.xUE.setVisibility(8);
      locala.xUP.setVisibility(0);
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
    localo.dVl();
    int j;
    int i;
    if (!localo.xEs)
    {
      localo.xEs = true;
      j = paramInt + 1001;
      i = j;
      if (this.dCm > 0)
      {
        i = j;
        if (paramInt > this.dCm) {
          i = paramInt - 1;
        }
      }
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1300, i, 1, 0, null, this.xGR, 0, null, null, com.tencent.mm.game.report.f.a(null, null, localo.xFX, null));
    }
    locala.xUE.setVisibility(0);
    locala.xUP.setVisibility(8);
    locala.xUN.setText(com.tencent.mm.plugin.game.e.b.n(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.xFg.xGj)
      {
        f = 0.08333334F;
        if (localo.xFJ == null) {
          break label1287;
        }
        a(locala.xUF, localo.xFJ.xGn, f);
        locala.xUF.setVisibility(0);
        if (Util.isNullOrNil(localo.xFJ.xGm)) {
          break label1240;
        }
        locala.gvw.setText(localo.xFJ.xGm);
        locala.gvw.setVisibility(0);
        if (Util.isNullOrNil(localo.xFJ.xGo)) {
          break label1253;
        }
        m(locala.xUH, localo.xFJ.xGo);
        locala.xUH.setVisibility(0);
        if (Util.isNullOrNil(localo.xFJ.xGh)) {
          break label1266;
        }
        locala.gvw.setEnabled(true);
        locala.xUF.setEnabled(true);
        paramView = new p.a(localo, localo.xFJ.xGh, 1);
        paramViewGroup = new p.a(localo, localo.xFJ.xGh, 2);
        locala.gvw.setTag(paramView);
        locala.gvw.setOnClickListener(this.xUB);
        locala.xUF.setTag(paramViewGroup);
        locala.xUF.setOnClickListener(this.xUB);
        label732:
        if (Util.isNullOrNil(localo.xFF)) {
          break label1708;
        }
        paramInt = localo.xFe.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.nnM.setText(this.context.getResources().getString(2131761306, new Object[] { Integer.valueOf(paramInt) }) + localo.xFF);
        label810:
        locala.nnM.setVisibility(0);
        label819:
        if (Util.isNullOrNil(localo.xFG)) {
          break label1721;
        }
        locala.xUI.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localo.xFG, locala.xUI.getTextSize()));
        locala.xUI.setVisibility(0);
        label867:
        a(localo, locala);
        if (Util.isNullOrNil(localo.xFK.mContent)) {
          break label1759;
        }
        locala.xUJ.setVisibility(0);
        if (Util.isNullOrNil(localo.xFK.xGh)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.xFK.xGh, 3);
        locala.xUJ.setTag(paramView);
        locala.xUJ.setOnClickListener(this.xUB);
        locala.xUJ.setEnabled(true);
        label961:
        locala.xUK.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localo.xFK.mContent, locala.xUK.getTextSize()));
        if (Util.isNullOrNil(localo.xFK.xGg)) {
          break label1746;
        }
        m(locala.xUL, localo.xFK.xGg);
        locala.xUL.setVisibility(0);
        label1032:
        if (Util.isNullOrNil(localo.xFH)) {
          break label1784;
        }
        m(locala.xUM, localo.xFH);
        locala.xUM.setVisibility(0);
        if (Util.isNullOrNil(localo.xFI)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.xFI, 3);
        locala.xUM.setTag(paramView);
        locala.xUM.setOnClickListener(this.xUB);
        locala.xUM.setEnabled(true);
        label1123:
        if (Util.isNullOrNil(localo.xFL.mName)) {
          break label1809;
        }
        locala.xUO.setText(localo.xFL.mName);
        locala.xUO.setVisibility(0);
        if (Util.isNullOrNil(localo.xFL.xGh)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.xFL.xGh, 5);
        locala.xUO.setTag(paramView);
        locala.xUO.setOnClickListener(this.xUB);
        locala.xUO.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.gvw.setVisibility(8);
        break label580;
        label1253:
        locala.xUH.setVisibility(8);
        break label620;
        locala.gvw.setEnabled(false);
        locala.xUF.setEnabled(false);
        break label732;
        label1287:
        if (!Util.isNullOrNil(localo.xFe))
        {
          paramViewGroup = (o.k)localo.xFe.get(0);
          if (!Util.isNullOrNil(paramViewGroup.nickName))
          {
            paramView = paramViewGroup.nickName;
            label1326:
            if (Util.isNullOrNil(paramViewGroup.xGs)) {
              break label1596;
            }
            locala.gvw.setEnabled(true);
            locala.xUF.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.xGs, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.xGs, 2);
            locala.gvw.setTag(localObject);
            locala.gvw.setOnClickListener(this.xUB);
            locala.xUF.setTag(locala1);
            locala.xUF.setOnClickListener(this.xUB);
            label1430:
            if (Util.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramView, locala.gvw.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.gvw.setVisibility(0);
            label1473:
            locala.xUF.setVisibility(0);
            if (Util.isNullOrNil(paramViewGroup.xGp)) {
              break label1630;
            }
            a(locala.xUF, paramViewGroup.xGp, f);
          }
          for (;;)
          {
            if (Util.isNullOrNil(paramViewGroup.xGr)) {
              break label1646;
            }
            m(locala.xUH, paramViewGroup.xGr);
            locala.xUH.setVisibility(0);
            break;
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramViewGroup.userName);
            if ((paramView == null) || (Util.isNullOrNil(paramView.arJ())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.arJ();
            break label1326;
            label1596:
            locala.gvw.setEnabled(false);
            locala.xUF.setEnabled(false);
            break label1430;
            label1617:
            locala.gvw.setVisibility(8);
            break label1473;
            label1630:
            k(locala.xUF, paramViewGroup.userName);
          }
          label1646:
          locala.xUH.setVisibility(8);
          break label732;
        }
        locala.xUF.setVisibility(8);
        locala.gvw.setVisibility(8);
        locala.xUH.setVisibility(8);
        break label732;
        label1692:
        locala.nnM.setText(localo.xFF);
        break label810;
        label1708:
        locala.nnM.setVisibility(8);
        break label819;
        label1721:
        locala.xUI.setVisibility(8);
        break label867;
        label1734:
        locala.xUJ.setEnabled(false);
        break label961;
        label1746:
        locala.xUL.setVisibility(8);
        break label1032;
        label1759:
        locala.xUJ.setVisibility(8);
        break label1032;
        label1772:
        locala.xUM.setEnabled(false);
        break label1123;
        label1784:
        locala.xUM.setVisibility(8);
        break label1123;
        label1797:
        locala.xUO.setEnabled(false);
        continue;
        label1809:
        locala.xUO.setVisibility(8);
      }
    }
    locala.nnM.setVisibility(8);
    locala.xUI.setVisibility(8);
    locala.xUJ.setVisibility(8);
    locala.xUL.setVisibility(8);
    locala.xUM.setVisibility(8);
    locala.xUO.setVisibility(8);
    locala.xUO.setEnabled(false);
    locala.xUM.setEnabled(false);
    locala.xUF.setEnabled(false);
    locala.gvw.setEnabled(false);
    locala.xUQ.setVisibility(8);
    locala.xUH.setVisibility(8);
    if (!Util.isNullOrNil(localo.xFe))
    {
      localObject = (o.k)localo.xFe.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(((o.k)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.arJ();
        label1997:
        paramViewGroup = paramView;
        if (Util.isNullOrNil(paramView)) {
          paramViewGroup = ((o.k)localObject).nickName;
        }
        if (!Util.isNullOrNil(((o.k)localObject).xGq)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.xFe.size();
      if ((!Util.isNullOrNil(localo.xFc)) && ((localo.xFt & 1L) == 0L))
      {
        locala.xUO.setText(localo.xFc);
        locala.xUO.setVisibility(0);
        if ((localo.xFt & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(2131100542);
          locala.xUO.setTextColor(j);
          locala.xUO.setBackgroundResource(2131232881);
          locala.xUO.setOnClickListener(this.xUt);
          locala.xUO.setTag(localo);
          locala.xUO.setEnabled(true);
        }
      }
      else
      {
        label2161:
        if ((localo.field_msgType != 10) && (localo.field_msgType != 11)) {
          break label2433;
        }
        if (Util.isNullOrNil(localo.mAppName)) {
          break label2377;
        }
        locala.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localo.mAppName, locala.gvw.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.gvw.setVisibility(0);
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
          Log.e("MicroMsg.GameMessageAdapter", "error msgtype: " + localo.field_msgType);
          break label318;
          j = this.context.getResources().getColor(2131100522);
          locala.xUO.setTextColor(j);
          locala.xUO.setBackgroundResource(0);
          locala.xUO.setOnClickListener(null);
          locala.xUO.setEnabled(false);
          break label2161;
          label2377:
          if (!Util.isNullOrNil(paramViewGroup))
          {
            locala.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramViewGroup, locala.gvw.getTextSize()));
            locala.gvw.setVisibility(0);
          }
          else
          {
            locala.gvw.setVisibility(8);
            continue;
            if (!Util.isNullOrNil(paramViewGroup))
            {
              locala.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramViewGroup, locala.gvw.getTextSize()));
              locala.gvw.setVisibility(0);
              if (paramInt != 0)
              {
                locala.gvw.setOnClickListener(this.xUv);
                locala.gvw.setTag(localo);
                locala.gvw.setEnabled(true);
              }
            }
            else
            {
              locala.gvw.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!Util.isNullOrNil(localo.xEY))
      {
        m(locala.xUF, localo.xEY);
        locala.xUF.setVisibility(0);
        label2558:
        if (!Util.isNullOrNil(localo.rfc))
        {
          if (Util.isNullOrNil(localo.xFk)) {
            break label2709;
          }
          locala.xUI.setText(localo.rfc);
          locala.xUI.setVisibility(0);
        }
      }
      while (!Util.isNullOrNil(localo.xFk))
      {
        m(locala.xUM, localo.xFk);
        locala.xUM.setTag(Long.valueOf(localo.field_msgId));
        locala.xUM.setOnTouchListener(xUs);
        locala.xUM.setOnClickListener(this.xUu);
        locala.xUM.setVisibility(0);
        locala.xUM.setEnabled(true);
        break;
        Log.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.xUF.setVisibility(8);
        break label2558;
        label2709:
        locala.xUJ.setVisibility(0);
        locala.xUK.setText(localo.rfc);
        locala.xUJ.setOnClickListener(this.xUu);
        locala.xUJ.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!Util.isNullOrNil(localo.xFe))
      {
        locala.xUF.setVisibility(0);
        if (!Util.isNullOrNil(((o.k)localo.xFe.get(0)).xGp))
        {
          m(locala.xUF, ((o.k)localo.xFe.get(0)).xGp);
          label2827:
          if (!Util.isNullOrNil(((o.k)localo.xFe.get(0)).xGq))
          {
            locala.xUF.setOnClickListener(this.xUw);
            locala.xUF.setTag(localo);
            locala.xUF.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.xUJ.setVisibility(0);
        locala.xUJ.setOnClickListener(this.xUu);
        locala.xUJ.setTag(Long.valueOf(localo.field_msgId));
        if (localo.xFU != 1) {
          break label3018;
        }
        locala.xUI.setVisibility(0);
        locala.xUI.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localo.xFx, locala.xUI.getTextSize()));
        locala.xUK.setText(localo.xFA);
        break;
        k(locala.xUF, ((o.k)localo.xFe.get(0)).userName);
        break label2827;
        locala.xUF.setVisibility(8);
      }
      label3018:
      if (localo.xFU == 2)
      {
        locala.xUI.setVisibility(0);
        locala.xUI.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, localo.xFx, locala.xUI.getTextSize()));
        locala.xUK.setText(localo.xFy);
        break;
      }
      if (localo.xFU != 3) {
        break;
      }
      locala.nnM.setVisibility(0);
      if (i > 1)
      {
        locala.nnM.setText(this.context.getResources().getString(2131761296, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.xUK.setText(localo.xFA);
        break;
        locala.nnM.setText(this.context.getResources().getString(2131761297));
      }
      m(locala.xUF, localo.xEY);
      paramView = "礼物";
      if (localo.xFp.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.nnM.setText(this.context.getResources().getString(2131761304, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.nnM.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.xFp.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.nnM.setText(this.context.getResources().getString(2131761305, new Object[] { paramView }));
      }
      if (!Util.isNullOrNil(localo.xFe))
      {
        locala.xUF.setVisibility(0);
        if (!Util.isNullOrNil(((o.k)localo.xFe.get(0)).xGp))
        {
          m(locala.xUF, ((o.k)localo.xFe.get(0)).xGp);
          label3402:
          if (!Util.isNullOrNil(((o.k)localo.xFe.get(0)).xGq))
          {
            locala.xUF.setOnClickListener(this.xUw);
            locala.xUF.setTag(localo);
            locala.xUF.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.nnM.setText(this.context.getResources().getString(2131761298, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.xUJ.setVisibility(0);
        locala.nnM.setVisibility(0);
        locala.xUK.setText(localo.xFB);
        locala.xUJ.setOnClickListener(this.xUu);
        locala.xUJ.setTag(Long.valueOf(localo.field_msgId));
        if (Util.isNullOrNil(localo.xFD)) {
          break;
        }
        locala.xUL.setVisibility(0);
        m(locala.xUL, localo.xFD);
        break;
        k(locala.xUF, ((o.k)localo.xFe.get(0)).userName);
        break label3402;
        locala.xUF.setVisibility(8);
        break label3454;
        label3637:
        locala.nnM.setText(this.context.getResources().getString(2131761299));
      }
      paramInt = 0;
      continue;
      paramView = null;
      break label1997;
      paramViewGroup = null;
      paramInt = 0;
    }
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(42273);
    getCursor().close();
    anp();
    AppMethodBeat.o(42273);
  }
  
  static final class a
  {
    public TextView gvw;
    public TextView nnM;
    public LinearLayout xUE;
    public ImageView xUF;
    public LinearLayout xUG;
    public ImageView xUH;
    public TextView xUI;
    public LinearLayout xUJ;
    public TextView xUK;
    public ImageView xUL;
    public ImageView xUM;
    public TextView xUN;
    public TextView xUO;
    public LinearLayout xUP;
    public GameMessageListContainerView xUQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */