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
import com.tencent.mm.cd.a;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.o.j;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends x<com.tencent.mm.plugin.game.model.o>
{
  private static w IST;
  private int IFc;
  private View.OnClickListener ISU;
  private View.OnClickListener ISV;
  private v ISW;
  private v ISX;
  private long ISY;
  private int ISZ;
  int ITa;
  private long ITb;
  private com.tencent.mm.plugin.game.model.p ITc;
  private com.tencent.mm.b.f<String, Bitmap> ITd;
  private int hzj;
  private int lNX;
  private Context mContext;
  private int wDI;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.wDI = 15;
    this.lNX = 0;
    this.hzj = 0;
    this.ISY = 0L;
    this.IFc = 0;
    this.ISZ = 0;
    this.ITa = 0;
    this.mContext = paramContext;
    this.IFc = paramInt;
    this.ITb = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh();
    String str = s.H(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.lNX = i;
      this.hzj = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().fGD();
      IST = new w();
      this.ISU = new o(paramContext, paramInt);
      this.ISV = new p(paramContext, paramInt);
      this.ISW = new v(paramContext);
      this.ISW.jh(paramInt, 1);
      this.ISX = new v(paramContext);
      this.ISX.jh(paramInt, 2);
      this.ITc = new com.tencent.mm.plugin.game.model.p(paramContext, this.IFc);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(h.c.HTf);
      int j = this.mContext.getResources().getDimensionPixelSize(h.c.BiggerPadding);
      int k = this.mContext.getResources().getDimensionPixelSize(h.c.MiddlePadding);
      this.ISZ = (a.K(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.ITd = new com.tencent.mm.memory.a.b(30, getClass());
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
  
  private com.tencent.mm.plugin.game.model.o XM(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (XL(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.aYG;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.adDw != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.adDw.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (XN(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!Fv().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.adDw == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.aYG, Fv());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, Fv());
    this.adDw.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean XN(int paramInt)
  {
    return (this.lNX > this.hzj) && (this.hzj > 0) && (paramInt > this.hzj);
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
    if (this.ITd.check(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.ITd.get(paramString);
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
    while (i < paramo.IDq.size())
    {
      localLinkedList.add((o.l)paramo.IDq.get(i));
      i += 1;
    }
    parama.ITr.a(paramo, localLinkedList, this.ISZ, this.IFc, this.ITd);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42262);
    if (Util.isNullOrNil(paramString))
    {
      a.b.g(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    if (!this.ITd.check(paramString))
    {
      n(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.ITd.get(paramString);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      n(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(42262);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.oKn = false;
    locala.IYu = paramFloat;
    e.fIb().a(paramImageView, paramString, locala.fIc(), new e.b()
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
  
  private void fHz()
  {
    AppMethodBeat.i(42274);
    if (this.ITb <= 0L)
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
        com.tencent.mm.plugin.game.model.o localo = XM(i);
        if ((localo != null) && (localo.field_msgId == this.ITb)) {
          this.ITa = i;
        }
      }
      else
      {
        this.ITb = 0L;
        AppMethodBeat.o(42274);
        return;
      }
      i += 1;
    }
  }
  
  private void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.ITd.check(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.ITd.get(paramString);
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
  
  private void n(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42263);
    paramImageView = e.fIb().r(paramImageView, paramString);
    if (paramImageView != null) {
      this.ITd.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  public final boolean XL(int paramInt)
  {
    return (this.lNX > this.hzj) && (this.hzj > 0) && (paramInt == this.hzj);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(42267);
    s locals = ((com.tencent.mm.plugin.game.api.f)h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh();
    int i = this.wDI;
    String str = s.H(new int[] { 2, 5, 6, 10, 11, 100 });
    w(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0" + " order by isRead, createTime desc limit " + i, new String[0]));
    this.wDI = getCount();
    if (this.adDx != null) {
      this.adDx.bWC();
    }
    fHz();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(42268);
    fSd();
    aNy();
    AppMethodBeat.o(42268);
  }
  
  public final boolean dmY()
  {
    return this.wDI >= this.lNX;
  }
  
  public final void fHx()
  {
    AppMethodBeat.i(42270);
    if (dmY())
    {
      if (this.adDx != null) {
        this.adDx.bWC();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.wDI += 15;
    if (this.wDI > this.lNX) {
      this.wDI = this.lNX;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int fHy()
  {
    if ((this.lNX > this.hzj) && (this.hzj > 0)) {
      return 1;
    }
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42271);
    if (this.count < 0) {
      this.count = Fv().getCount();
    }
    if (this.count <= 0)
    {
      AppMethodBeat.o(42271);
      return 0;
    }
    int i = this.count;
    int j = fHy();
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
      localView = View.inflate(this.context, h.f.HZZ, null);
      locala.ITg = ((ImageView)localView.findViewById(h.e.icon_iv));
      locala.ITf = ((LinearLayout)localView.findViewById(h.e.msg));
      locala.ITh = ((LinearLayout)localView.findViewById(h.e.msg_content));
      locala.lBD = ((TextView)localView.findViewById(h.e.nickname_tv));
      locala.ITi = ((ImageView)localView.findViewById(h.e.HTz));
      locala.ttU = ((TextView)localView.findViewById(h.e.tips_tv));
      locala.ITj = ((TextView)localView.findViewById(h.e.HXd));
      locala.ITk = ((LinearLayout)localView.findViewById(h.e.HXf));
      locala.ITl = ((TextView)localView.findViewById(h.e.HXh));
      locala.ITm = ((ImageView)localView.findViewById(h.e.HXg));
      locala.ITn = ((ImageView)localView.findViewById(h.e.HXe));
      locala.ITo = ((TextView)localView.findViewById(h.e.HXj));
      locala.ITp = ((TextView)localView.findViewById(h.e.HXi));
      locala.ITr = ((GameMessageListContainerView)localView.findViewById(h.e.HXk));
      locala.ITq = ((LinearLayout)localView.findViewById(h.e.HXc));
      localView.setTag(locala);
      localo = XM(paramInt);
      if ((localo == null) || (!localo.IEm)) {
        break label342;
      }
      locala.ITf.setVisibility(8);
      locala.ITq.setVisibility(0);
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
    localo.fGp();
    int j;
    int i;
    if (!localo.ICD)
    {
      localo.ICD = true;
      j = paramInt + 1001;
      i = j;
      if (this.hzj > 0)
      {
        i = j;
        if (paramInt > this.hzj) {
          i = paramInt - 1;
        }
      }
      g.a(this.mContext, 13, 1300, i, 1, 0, null, this.IFc, 0, null, null, g.a(null, null, localo.IEi, null));
    }
    locala.ITf.setVisibility(0);
    locala.ITq.setVisibility(8);
    locala.ITo.setText(com.tencent.mm.plugin.game.d.b.r(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.IDs.IEx)
      {
        f = 0.08333334F;
        if (localo.IDV == null) {
          break label1287;
        }
        a(locala.ITg, localo.IDV.IEB, f);
        locala.ITg.setVisibility(0);
        if (Util.isNullOrNil(localo.IDV.IEA)) {
          break label1240;
        }
        locala.lBD.setText(localo.IDV.IEA);
        locala.lBD.setVisibility(0);
        if (Util.isNullOrNil(localo.IDV.IEC)) {
          break label1253;
        }
        l(locala.ITi, localo.IDV.IEC);
        locala.ITi.setVisibility(0);
        if (Util.isNullOrNil(localo.IDV.IEv)) {
          break label1266;
        }
        locala.lBD.setEnabled(true);
        locala.ITg.setEnabled(true);
        paramView = new p.a(localo, localo.IDV.IEv, 1);
        paramViewGroup = new p.a(localo, localo.IDV.IEv, 2);
        locala.lBD.setTag(paramView);
        locala.lBD.setOnClickListener(this.ITc);
        locala.ITg.setTag(paramViewGroup);
        locala.ITg.setOnClickListener(this.ITc);
        label732:
        if (Util.isNullOrNil(localo.IDR)) {
          break label1708;
        }
        paramInt = localo.IDq.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.ttU.setText(this.context.getResources().getString(h.i.IbB, new Object[] { Integer.valueOf(paramInt) }) + localo.IDR);
        label810:
        locala.ttU.setVisibility(0);
        label819:
        if (Util.isNullOrNil(localo.IDS)) {
          break label1721;
        }
        locala.ITj.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, localo.IDS, locala.ITj.getTextSize()));
        locala.ITj.setVisibility(0);
        label867:
        a(localo, locala);
        if (Util.isNullOrNil(localo.IDW.mContent)) {
          break label1759;
        }
        locala.ITk.setVisibility(0);
        if (Util.isNullOrNil(localo.IDW.IEv)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.IDW.IEv, 3);
        locala.ITk.setTag(paramView);
        locala.ITk.setOnClickListener(this.ITc);
        locala.ITk.setEnabled(true);
        label961:
        locala.ITl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, localo.IDW.mContent, locala.ITl.getTextSize()));
        if (Util.isNullOrNil(localo.IDW.IEu)) {
          break label1746;
        }
        l(locala.ITm, localo.IDW.IEu);
        locala.ITm.setVisibility(0);
        label1032:
        if (Util.isNullOrNil(localo.IDT)) {
          break label1784;
        }
        l(locala.ITn, localo.IDT);
        locala.ITn.setVisibility(0);
        if (Util.isNullOrNil(localo.IDU)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.IDU, 3);
        locala.ITn.setTag(paramView);
        locala.ITn.setOnClickListener(this.ITc);
        locala.ITn.setEnabled(true);
        label1123:
        if (Util.isNullOrNil(localo.IDX.mName)) {
          break label1809;
        }
        locala.ITp.setText(localo.IDX.mName);
        locala.ITp.setVisibility(0);
        if (Util.isNullOrNil(localo.IDX.IEv)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.IDX.IEv, 5);
        locala.ITp.setTag(paramView);
        locala.ITp.setOnClickListener(this.ITc);
        locala.ITp.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.lBD.setVisibility(8);
        break label580;
        label1253:
        locala.ITi.setVisibility(8);
        break label620;
        locala.lBD.setEnabled(false);
        locala.ITg.setEnabled(false);
        break label732;
        label1287:
        if (!Util.isNullOrNil(localo.IDq))
        {
          paramViewGroup = (o.l)localo.IDq.get(0);
          if (!Util.isNullOrNil(paramViewGroup.nickName))
          {
            paramView = paramViewGroup.nickName;
            label1326:
            if (Util.isNullOrNil(paramViewGroup.DUN)) {
              break label1596;
            }
            locala.lBD.setEnabled(true);
            locala.ITg.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.DUN, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.DUN, 2);
            locala.lBD.setTag(localObject);
            locala.lBD.setOnClickListener(this.ITc);
            locala.ITg.setTag(locala1);
            locala.ITg.setOnClickListener(this.ITc);
            label1430:
            if (Util.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, paramView, locala.lBD.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.lBD.setVisibility(0);
            label1473:
            locala.ITg.setVisibility(0);
            if (Util.isNullOrNil(paramViewGroup.IED)) {
              break label1630;
            }
            a(locala.ITg, paramViewGroup.IED, f);
          }
          for (;;)
          {
            if (Util.isNullOrNil(paramViewGroup.IEF)) {
              break label1646;
            }
            l(locala.ITi, paramViewGroup.IEF);
            locala.ITi.setVisibility(0);
            break;
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramViewGroup.userName);
            if ((paramView == null) || (Util.isNullOrNil(paramView.aSV())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.aSV();
            break label1326;
            label1596:
            locala.lBD.setEnabled(false);
            locala.ITg.setEnabled(false);
            break label1430;
            label1617:
            locala.lBD.setVisibility(8);
            break label1473;
            label1630:
            b(locala.ITg, paramViewGroup.userName);
          }
          label1646:
          locala.ITi.setVisibility(8);
          break label732;
        }
        locala.ITg.setVisibility(8);
        locala.lBD.setVisibility(8);
        locala.ITi.setVisibility(8);
        break label732;
        label1692:
        locala.ttU.setText(localo.IDR);
        break label810;
        label1708:
        locala.ttU.setVisibility(8);
        break label819;
        label1721:
        locala.ITj.setVisibility(8);
        break label867;
        label1734:
        locala.ITk.setEnabled(false);
        break label961;
        label1746:
        locala.ITm.setVisibility(8);
        break label1032;
        label1759:
        locala.ITk.setVisibility(8);
        break label1032;
        label1772:
        locala.ITn.setEnabled(false);
        break label1123;
        label1784:
        locala.ITn.setVisibility(8);
        break label1123;
        label1797:
        locala.ITp.setEnabled(false);
        continue;
        label1809:
        locala.ITp.setVisibility(8);
      }
    }
    locala.ttU.setVisibility(8);
    locala.ITj.setVisibility(8);
    locala.ITk.setVisibility(8);
    locala.ITm.setVisibility(8);
    locala.ITn.setVisibility(8);
    locala.ITp.setVisibility(8);
    locala.ITp.setEnabled(false);
    locala.ITn.setEnabled(false);
    locala.ITg.setEnabled(false);
    locala.lBD.setEnabled(false);
    locala.ITr.setVisibility(8);
    locala.ITi.setVisibility(8);
    if (!Util.isNullOrNil(localo.IDq))
    {
      localObject = (o.l)localo.IDq.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((o.l)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.aSV();
        label1997:
        paramViewGroup = paramView;
        if (Util.isNullOrNil(paramView)) {
          paramViewGroup = ((o.l)localObject).nickName;
        }
        if (!Util.isNullOrNil(((o.l)localObject).IEE)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.IDq.size();
      if ((!Util.isNullOrNil(localo.IDo)) && ((localo.IDF & 1L) == 0L))
      {
        locala.ITp.setText(localo.IDo);
        locala.ITp.setVisibility(0);
        if ((localo.IDF & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(h.b.HSS);
          locala.ITp.setTextColor(j);
          locala.ITp.setBackgroundResource(h.d.HTn);
          locala.ITp.setOnClickListener(this.ISU);
          locala.ITp.setTag(localo);
          locala.ITp.setEnabled(true);
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
        locala.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, localo.mAppName, locala.lBD.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.lBD.setVisibility(0);
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
          j = this.context.getResources().getColor(h.b.HSK);
          locala.ITp.setTextColor(j);
          locala.ITp.setBackgroundResource(0);
          locala.ITp.setOnClickListener(null);
          locala.ITp.setEnabled(false);
          break label2161;
          label2377:
          if (!Util.isNullOrNil(paramViewGroup))
          {
            locala.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, paramViewGroup, locala.lBD.getTextSize()));
            locala.lBD.setVisibility(0);
          }
          else
          {
            locala.lBD.setVisibility(8);
            continue;
            if (!Util.isNullOrNil(paramViewGroup))
            {
              locala.lBD.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, paramViewGroup, locala.lBD.getTextSize()));
              locala.lBD.setVisibility(0);
              if (paramInt != 0)
              {
                locala.lBD.setOnClickListener(this.ISW);
                locala.lBD.setTag(localo);
                locala.lBD.setEnabled(true);
              }
            }
            else
            {
              locala.lBD.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!Util.isNullOrNil(localo.IDk))
      {
        l(locala.ITg, localo.IDk);
        locala.ITg.setVisibility(0);
        label2558:
        if (!Util.isNullOrNil(localo.xQX))
        {
          if (Util.isNullOrNil(localo.IDw)) {
            break label2709;
          }
          locala.ITj.setText(localo.xQX);
          locala.ITj.setVisibility(0);
        }
      }
      while (!Util.isNullOrNil(localo.IDw))
      {
        l(locala.ITn, localo.IDw);
        locala.ITn.setTag(Long.valueOf(localo.field_msgId));
        locala.ITn.setOnTouchListener(IST);
        locala.ITn.setOnClickListener(this.ISV);
        locala.ITn.setVisibility(0);
        locala.ITn.setEnabled(true);
        break;
        Log.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.ITg.setVisibility(8);
        break label2558;
        label2709:
        locala.ITk.setVisibility(0);
        locala.ITl.setText(localo.xQX);
        locala.ITk.setOnClickListener(this.ISV);
        locala.ITk.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!Util.isNullOrNil(localo.IDq))
      {
        locala.ITg.setVisibility(0);
        if (!Util.isNullOrNil(((o.l)localo.IDq.get(0)).IED))
        {
          l(locala.ITg, ((o.l)localo.IDq.get(0)).IED);
          label2827:
          if (!Util.isNullOrNil(((o.l)localo.IDq.get(0)).IEE))
          {
            locala.ITg.setOnClickListener(this.ISX);
            locala.ITg.setTag(localo);
            locala.ITg.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.ITk.setVisibility(0);
        locala.ITk.setOnClickListener(this.ISV);
        locala.ITk.setTag(Long.valueOf(localo.field_msgId));
        if (localo.IEg != 1) {
          break label3018;
        }
        locala.ITj.setVisibility(0);
        locala.ITj.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, localo.IDJ, locala.ITj.getTextSize()));
        locala.ITl.setText(localo.IDM);
        break;
        b(locala.ITg, ((o.l)localo.IDq.get(0)).userName);
        break label2827;
        locala.ITg.setVisibility(8);
      }
      label3018:
      if (localo.IEg == 2)
      {
        locala.ITj.setVisibility(0);
        locala.ITj.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.context, localo.IDJ, locala.ITj.getTextSize()));
        locala.ITl.setText(localo.IDK);
        break;
      }
      if (localo.IEg != 3) {
        break;
      }
      locala.ttU.setVisibility(0);
      if (i > 1)
      {
        locala.ttU.setText(this.context.getResources().getString(h.i.Ibu, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.ITl.setText(localo.IDM);
        break;
        locala.ttU.setText(this.context.getResources().getString(h.i.Ibv));
      }
      l(locala.ITg, localo.IDk);
      paramView = "礼物";
      if (localo.IDB.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.ttU.setText(this.context.getResources().getString(h.i.Ibz, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.ttU.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.IDB.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.ttU.setText(this.context.getResources().getString(h.i.IbA, new Object[] { paramView }));
      }
      if (!Util.isNullOrNil(localo.IDq))
      {
        locala.ITg.setVisibility(0);
        if (!Util.isNullOrNil(((o.l)localo.IDq.get(0)).IED))
        {
          l(locala.ITg, ((o.l)localo.IDq.get(0)).IED);
          label3402:
          if (!Util.isNullOrNil(((o.l)localo.IDq.get(0)).IEE))
          {
            locala.ITg.setOnClickListener(this.ISX);
            locala.ITg.setTag(localo);
            locala.ITg.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.ttU.setText(this.context.getResources().getString(h.i.Ibw, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.ITk.setVisibility(0);
        locala.ttU.setVisibility(0);
        locala.ITl.setText(localo.IDN);
        locala.ITk.setOnClickListener(this.ISV);
        locala.ITk.setTag(Long.valueOf(localo.field_msgId));
        if (Util.isNullOrNil(localo.IDP)) {
          break;
        }
        locala.ITm.setVisibility(0);
        l(locala.ITm, localo.IDP);
        break;
        b(locala.ITg, ((o.l)localo.IDq.get(0)).userName);
        break label3402;
        locala.ITg.setVisibility(8);
        break label3454;
        label3637:
        locala.ttU.setText(this.context.getResources().getString(h.i.Ibx));
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
    Fv().close();
    aNy();
    AppMethodBeat.o(42273);
  }
  
  static final class a
  {
    public LinearLayout ITf;
    public ImageView ITg;
    public LinearLayout ITh;
    public ImageView ITi;
    public TextView ITj;
    public LinearLayout ITk;
    public TextView ITl;
    public ImageView ITm;
    public ImageView ITn;
    public TextView ITo;
    public TextView ITp;
    public LinearLayout ITq;
    public GameMessageListContainerView ITr;
    public TextView lBD;
    public TextView ttU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */