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
import com.tencent.mm.ci.a;
import com.tencent.mm.game.report.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.o.j;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.o.l;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.v.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends com.tencent.mm.ui.v<com.tencent.mm.plugin.game.model.o>
{
  private static w CYD;
  private int CKU;
  private View.OnClickListener CYE;
  private View.OnClickListener CYF;
  private v CYG;
  private v CYH;
  private long CYI;
  private int CYJ;
  int CYK;
  private long CYL;
  private com.tencent.mm.plugin.game.model.p CYM;
  private com.tencent.mm.b.f<String, Bitmap> CYN;
  private int fuP;
  private int jlf;
  private Context mContext;
  private int tzm;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.tzm = 15;
    this.jlf = 0;
    this.fuP = 0;
    this.CYI = 0L;
    this.CKU = 0;
    this.CYJ = 0;
    this.CYK = 0;
    this.mContext = paramContext;
    this.CKU = paramInt;
    this.CYL = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo();
    String str = s.D(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.jlf = i;
      this.fuP = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().eyH();
      CYD = new w();
      this.CYE = new o(paramContext, paramInt);
      this.CYF = new p(paramContext, paramInt);
      this.CYG = new v(paramContext);
      this.CYG.hE(paramInt, 1);
      this.CYH = new v(paramContext);
      this.CYH.hE(paramInt, 2);
      this.CYM = new com.tencent.mm.plugin.game.model.p(paramContext, this.CKU);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(g.c.CgW);
      int j = this.mContext.getResources().getDimensionPixelSize(g.c.BiggerPadding);
      int k = this.mContext.getResources().getDimensionPixelSize(g.c.MiddlePadding);
      this.CYJ = (a.H(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.CYN = new com.tencent.mm.memory.a.b(30, getClass());
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
  
  private com.tencent.mm.plugin.game.model.o TS(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (TR(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.Bbi;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.VZb != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.VZb.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (TT(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!hK().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.VZb == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.Bbi, hK());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, hK());
    this.VZb.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean TT(int paramInt)
  {
    return (this.jlf > this.fuP) && (this.fuP > 0) && (paramInt > this.fuP);
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
    if (this.CYN.check(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.CYN.get(paramString);
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
    while (i < paramo.CJf.size())
    {
      localLinkedList.add(paramo.CJf.get(i));
      i += 1;
    }
    parama.CZb.a(paramo, localLinkedList, this.CYJ, this.CKU, this.CYN);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.lRB = false;
    locala.Ded = paramFloat;
    e.eAa().a(paramImageView, paramString, locala.eAb(), new e.b()
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
  
  private void ezB()
  {
    AppMethodBeat.i(42274);
    if (this.CYL <= 0L)
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
        com.tencent.mm.plugin.game.model.o localo = TS(i);
        if ((localo != null) && (localo.field_msgId == this.CYL)) {
          this.CYK = i;
        }
      }
      else
      {
        this.CYL = 0L;
        AppMethodBeat.o(42274);
        return;
      }
      i += 1;
    }
  }
  
  private void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.CYN.check(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.CYN.get(paramString);
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
  
  private void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42262);
    if (Util.isNullOrNil(paramString))
    {
      a.b.c(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    if (!this.CYN.check(paramString))
    {
      m(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.CYN.get(paramString);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      m(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
    AppMethodBeat.o(42262);
  }
  
  private void m(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42263);
    paramImageView = e.eAa().q(paramImageView, paramString);
    if (paramImageView != null) {
      this.CYN.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  public final boolean TR(int paramInt)
  {
    return (this.jlf > this.fuP) && (this.fuP > 0) && (paramInt == this.fuP);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(42267);
    s locals = ((com.tencent.mm.plugin.game.api.f)h.ae(com.tencent.mm.plugin.game.api.f.class)).evo();
    int i = this.tzm;
    String str = s.D(new int[] { 2, 5, 6, 10, 11, 100 });
    v(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0" + " order by isRead, createTime desc limit " + i, new String[0]));
    this.tzm = getCount();
    if (this.VZc != null) {
      this.VZc.bxN();
    }
    ezB();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(42268);
    eKd();
    atr();
    AppMethodBeat.o(42268);
  }
  
  public final boolean cJI()
  {
    return this.tzm >= this.jlf;
  }
  
  public final int ezA()
  {
    if ((this.jlf > this.fuP) && (this.fuP > 0)) {
      return 1;
    }
    return 0;
  }
  
  public final void ezz()
  {
    AppMethodBeat.i(42270);
    if (cJI())
    {
      if (this.VZc != null) {
        this.VZc.bxN();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.tzm += 15;
    if (this.tzm > this.jlf) {
      this.tzm = this.jlf;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42271);
    if (this.count < 0) {
      this.count = hK().getCount();
    }
    if (this.count <= 0)
    {
      AppMethodBeat.o(42271);
      return 0;
    }
    int i = this.count;
    int j = ezA();
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
      localView = View.inflate(this.context, g.f.CnR, null);
      locala.CYQ = ((ImageView)localView.findViewById(g.e.icon_iv));
      locala.CYP = ((LinearLayout)localView.findViewById(g.e.msg));
      locala.CYR = ((LinearLayout)localView.findViewById(g.e.msg_content));
      locala.iZH = ((TextView)localView.findViewById(g.e.nickname_tv));
      locala.CYS = ((ImageView)localView.findViewById(g.e.Chq));
      locala.qpt = ((TextView)localView.findViewById(g.e.tips_tv));
      locala.CYT = ((TextView)localView.findViewById(g.e.CkV));
      locala.CYU = ((LinearLayout)localView.findViewById(g.e.CkX));
      locala.CYV = ((TextView)localView.findViewById(g.e.CkZ));
      locala.CYW = ((ImageView)localView.findViewById(g.e.CkY));
      locala.CYX = ((ImageView)localView.findViewById(g.e.CkW));
      locala.CYY = ((TextView)localView.findViewById(g.e.Clb));
      locala.CYZ = ((TextView)localView.findViewById(g.e.Cla));
      locala.CZb = ((GameMessageListContainerView)localView.findViewById(g.e.Clc));
      locala.CZa = ((LinearLayout)localView.findViewById(g.e.CkU));
      localView.setTag(locala);
      localo = TS(paramInt);
      if ((localo == null) || (!localo.CKc)) {
        break label342;
      }
      locala.CYP.setVisibility(8);
      locala.CZa.setVisibility(0);
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
    localo.eyt();
    int j;
    int i;
    if (!localo.CIt)
    {
      localo.CIt = true;
      j = paramInt + 1001;
      i = j;
      if (this.fuP > 0)
      {
        i = j;
        if (paramInt > this.fuP) {
          i = paramInt - 1;
        }
      }
      g.a(this.mContext, 13, 1300, i, 1, 0, null, this.CKU, 0, null, null, g.a(null, null, localo.CJY, null));
    }
    locala.CYP.setVisibility(0);
    locala.CZa.setVisibility(8);
    locala.CYY.setText(com.tencent.mm.plugin.game.d.b.p(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.CJh.CKm)
      {
        f = 0.08333334F;
        if (localo.CJK == null) {
          break label1287;
        }
        a(locala.CYQ, localo.CJK.CKq, f);
        locala.CYQ.setVisibility(0);
        if (Util.isNullOrNil(localo.CJK.CKp)) {
          break label1240;
        }
        locala.iZH.setText(localo.CJK.CKp);
        locala.iZH.setVisibility(0);
        if (Util.isNullOrNil(localo.CJK.CKr)) {
          break label1253;
        }
        i(locala.CYS, localo.CJK.CKr);
        locala.CYS.setVisibility(0);
        if (Util.isNullOrNil(localo.CJK.CKk)) {
          break label1266;
        }
        locala.iZH.setEnabled(true);
        locala.CYQ.setEnabled(true);
        paramView = new p.a(localo, localo.CJK.CKk, 1);
        paramViewGroup = new p.a(localo, localo.CJK.CKk, 2);
        locala.iZH.setTag(paramView);
        locala.iZH.setOnClickListener(this.CYM);
        locala.CYQ.setTag(paramViewGroup);
        locala.CYQ.setOnClickListener(this.CYM);
        label732:
        if (Util.isNullOrNil(localo.CJG)) {
          break label1708;
        }
        paramInt = localo.CJf.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.qpt.setText(this.context.getResources().getString(g.i.Cpt, new Object[] { Integer.valueOf(paramInt) }) + localo.CJG);
        label810:
        locala.qpt.setVisibility(0);
        label819:
        if (Util.isNullOrNil(localo.CJH)) {
          break label1721;
        }
        locala.CYT.setText(l.b(this.context, localo.CJH, locala.CYT.getTextSize()));
        locala.CYT.setVisibility(0);
        label867:
        a(localo, locala);
        if (Util.isNullOrNil(localo.CJL.mContent)) {
          break label1759;
        }
        locala.CYU.setVisibility(0);
        if (Util.isNullOrNil(localo.CJL.CKk)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.CJL.CKk, 3);
        locala.CYU.setTag(paramView);
        locala.CYU.setOnClickListener(this.CYM);
        locala.CYU.setEnabled(true);
        label961:
        locala.CYV.setText(l.b(this.context, localo.CJL.mContent, locala.CYV.getTextSize()));
        if (Util.isNullOrNil(localo.CJL.CKj)) {
          break label1746;
        }
        i(locala.CYW, localo.CJL.CKj);
        locala.CYW.setVisibility(0);
        label1032:
        if (Util.isNullOrNil(localo.CJI)) {
          break label1784;
        }
        i(locala.CYX, localo.CJI);
        locala.CYX.setVisibility(0);
        if (Util.isNullOrNil(localo.CJJ)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.CJJ, 3);
        locala.CYX.setTag(paramView);
        locala.CYX.setOnClickListener(this.CYM);
        locala.CYX.setEnabled(true);
        label1123:
        if (Util.isNullOrNil(localo.CJM.mName)) {
          break label1809;
        }
        locala.CYZ.setText(localo.CJM.mName);
        locala.CYZ.setVisibility(0);
        if (Util.isNullOrNil(localo.CJM.CKk)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.CJM.CKk, 5);
        locala.CYZ.setTag(paramView);
        locala.CYZ.setOnClickListener(this.CYM);
        locala.CYZ.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.iZH.setVisibility(8);
        break label580;
        label1253:
        locala.CYS.setVisibility(8);
        break label620;
        locala.iZH.setEnabled(false);
        locala.CYQ.setEnabled(false);
        break label732;
        label1287:
        if (!Util.isNullOrNil(localo.CJf))
        {
          paramViewGroup = (o.l)localo.CJf.get(0);
          if (!Util.isNullOrNil(paramViewGroup.nickName))
          {
            paramView = paramViewGroup.nickName;
            label1326:
            if (Util.isNullOrNil(paramViewGroup.CKv)) {
              break label1596;
            }
            locala.iZH.setEnabled(true);
            locala.CYQ.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.CKv, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.CKv, 2);
            locala.iZH.setTag(localObject);
            locala.iZH.setOnClickListener(this.CYM);
            locala.CYQ.setTag(locala1);
            locala.CYQ.setOnClickListener(this.CYM);
            label1430:
            if (Util.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.iZH.setText(l.b(this.context, paramView, locala.iZH.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.iZH.setVisibility(0);
            label1473:
            locala.CYQ.setVisibility(0);
            if (Util.isNullOrNil(paramViewGroup.CKs)) {
              break label1630;
            }
            a(locala.CYQ, paramViewGroup.CKs, f);
          }
          for (;;)
          {
            if (Util.isNullOrNil(paramViewGroup.CKu)) {
              break label1646;
            }
            i(locala.CYS, paramViewGroup.CKu);
            locala.CYS.setVisibility(0);
            break;
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramViewGroup.userName);
            if ((paramView == null) || (Util.isNullOrNil(paramView.ays())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.ays();
            break label1326;
            label1596:
            locala.iZH.setEnabled(false);
            locala.CYQ.setEnabled(false);
            break label1430;
            label1617:
            locala.iZH.setVisibility(8);
            break label1473;
            label1630:
            l(locala.CYQ, paramViewGroup.userName);
          }
          label1646:
          locala.CYS.setVisibility(8);
          break label732;
        }
        locala.CYQ.setVisibility(8);
        locala.iZH.setVisibility(8);
        locala.CYS.setVisibility(8);
        break label732;
        label1692:
        locala.qpt.setText(localo.CJG);
        break label810;
        label1708:
        locala.qpt.setVisibility(8);
        break label819;
        label1721:
        locala.CYT.setVisibility(8);
        break label867;
        label1734:
        locala.CYU.setEnabled(false);
        break label961;
        label1746:
        locala.CYW.setVisibility(8);
        break label1032;
        label1759:
        locala.CYU.setVisibility(8);
        break label1032;
        label1772:
        locala.CYX.setEnabled(false);
        break label1123;
        label1784:
        locala.CYX.setVisibility(8);
        break label1123;
        label1797:
        locala.CYZ.setEnabled(false);
        continue;
        label1809:
        locala.CYZ.setVisibility(8);
      }
    }
    locala.qpt.setVisibility(8);
    locala.CYT.setVisibility(8);
    locala.CYU.setVisibility(8);
    locala.CYW.setVisibility(8);
    locala.CYX.setVisibility(8);
    locala.CYZ.setVisibility(8);
    locala.CYZ.setEnabled(false);
    locala.CYX.setEnabled(false);
    locala.CYQ.setEnabled(false);
    locala.iZH.setEnabled(false);
    locala.CZb.setVisibility(8);
    locala.CYS.setVisibility(8);
    if (!Util.isNullOrNil(localo.CJf))
    {
      localObject = (o.l)localo.CJf.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(((o.l)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.ays();
        label1997:
        paramViewGroup = paramView;
        if (Util.isNullOrNil(paramView)) {
          paramViewGroup = ((o.l)localObject).nickName;
        }
        if (!Util.isNullOrNil(((o.l)localObject).CKt)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.CJf.size();
      if ((!Util.isNullOrNil(localo.CJd)) && ((localo.CJu & 1L) == 0L))
      {
        locala.CYZ.setText(localo.CJd);
        locala.CYZ.setVisibility(0);
        if ((localo.CJu & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(g.b.CgJ);
          locala.CYZ.setTextColor(j);
          locala.CYZ.setBackgroundResource(g.d.Che);
          locala.CYZ.setOnClickListener(this.CYE);
          locala.CYZ.setTag(localo);
          locala.CYZ.setEnabled(true);
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
        locala.iZH.setText(l.b(this.context, localo.mAppName, locala.iZH.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.iZH.setVisibility(0);
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
          j = this.context.getResources().getColor(g.b.CgB);
          locala.CYZ.setTextColor(j);
          locala.CYZ.setBackgroundResource(0);
          locala.CYZ.setOnClickListener(null);
          locala.CYZ.setEnabled(false);
          break label2161;
          label2377:
          if (!Util.isNullOrNil(paramViewGroup))
          {
            locala.iZH.setText(l.b(this.context, paramViewGroup, locala.iZH.getTextSize()));
            locala.iZH.setVisibility(0);
          }
          else
          {
            locala.iZH.setVisibility(8);
            continue;
            if (!Util.isNullOrNil(paramViewGroup))
            {
              locala.iZH.setText(l.b(this.context, paramViewGroup, locala.iZH.getTextSize()));
              locala.iZH.setVisibility(0);
              if (paramInt != 0)
              {
                locala.iZH.setOnClickListener(this.CYG);
                locala.iZH.setTag(localo);
                locala.iZH.setEnabled(true);
              }
            }
            else
            {
              locala.iZH.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!Util.isNullOrNil(localo.CIZ))
      {
        i(locala.CYQ, localo.CIZ);
        locala.CYQ.setVisibility(0);
        label2558:
        if (!Util.isNullOrNil(localo.uIi))
        {
          if (Util.isNullOrNil(localo.CJl)) {
            break label2709;
          }
          locala.CYT.setText(localo.uIi);
          locala.CYT.setVisibility(0);
        }
      }
      while (!Util.isNullOrNil(localo.CJl))
      {
        i(locala.CYX, localo.CJl);
        locala.CYX.setTag(Long.valueOf(localo.field_msgId));
        locala.CYX.setOnTouchListener(CYD);
        locala.CYX.setOnClickListener(this.CYF);
        locala.CYX.setVisibility(0);
        locala.CYX.setEnabled(true);
        break;
        Log.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.CYQ.setVisibility(8);
        break label2558;
        label2709:
        locala.CYU.setVisibility(0);
        locala.CYV.setText(localo.uIi);
        locala.CYU.setOnClickListener(this.CYF);
        locala.CYU.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!Util.isNullOrNil(localo.CJf))
      {
        locala.CYQ.setVisibility(0);
        if (!Util.isNullOrNil(((o.l)localo.CJf.get(0)).CKs))
        {
          i(locala.CYQ, ((o.l)localo.CJf.get(0)).CKs);
          label2827:
          if (!Util.isNullOrNil(((o.l)localo.CJf.get(0)).CKt))
          {
            locala.CYQ.setOnClickListener(this.CYH);
            locala.CYQ.setTag(localo);
            locala.CYQ.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.CYU.setVisibility(0);
        locala.CYU.setOnClickListener(this.CYF);
        locala.CYU.setTag(Long.valueOf(localo.field_msgId));
        if (localo.CJV != 1) {
          break label3018;
        }
        locala.CYT.setVisibility(0);
        locala.CYT.setText(l.b(this.context, localo.CJy, locala.CYT.getTextSize()));
        locala.CYV.setText(localo.CJB);
        break;
        l(locala.CYQ, ((o.l)localo.CJf.get(0)).userName);
        break label2827;
        locala.CYQ.setVisibility(8);
      }
      label3018:
      if (localo.CJV == 2)
      {
        locala.CYT.setVisibility(0);
        locala.CYT.setText(l.b(this.context, localo.CJy, locala.CYT.getTextSize()));
        locala.CYV.setText(localo.CJz);
        break;
      }
      if (localo.CJV != 3) {
        break;
      }
      locala.qpt.setVisibility(0);
      if (i > 1)
      {
        locala.qpt.setText(this.context.getResources().getString(g.i.Cpm, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.CYV.setText(localo.CJB);
        break;
        locala.qpt.setText(this.context.getResources().getString(g.i.Cpn));
      }
      i(locala.CYQ, localo.CIZ);
      paramView = "礼物";
      if (localo.CJq.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.qpt.setText(this.context.getResources().getString(g.i.Cpr, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.qpt.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.CJq.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.qpt.setText(this.context.getResources().getString(g.i.Cps, new Object[] { paramView }));
      }
      if (!Util.isNullOrNil(localo.CJf))
      {
        locala.CYQ.setVisibility(0);
        if (!Util.isNullOrNil(((o.l)localo.CJf.get(0)).CKs))
        {
          i(locala.CYQ, ((o.l)localo.CJf.get(0)).CKs);
          label3402:
          if (!Util.isNullOrNil(((o.l)localo.CJf.get(0)).CKt))
          {
            locala.CYQ.setOnClickListener(this.CYH);
            locala.CYQ.setTag(localo);
            locala.CYQ.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.qpt.setText(this.context.getResources().getString(g.i.Cpo, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.CYU.setVisibility(0);
        locala.qpt.setVisibility(0);
        locala.CYV.setText(localo.CJC);
        locala.CYU.setOnClickListener(this.CYF);
        locala.CYU.setTag(Long.valueOf(localo.field_msgId));
        if (Util.isNullOrNil(localo.CJE)) {
          break;
        }
        locala.CYW.setVisibility(0);
        i(locala.CYW, localo.CJE);
        break;
        l(locala.CYQ, ((o.l)localo.CJf.get(0)).userName);
        break label3402;
        locala.CYQ.setVisibility(8);
        break label3454;
        label3637:
        locala.qpt.setText(this.context.getResources().getString(g.i.Cpp));
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
    hK().close();
    atr();
    AppMethodBeat.o(42273);
  }
  
  static final class a
  {
    public LinearLayout CYP;
    public ImageView CYQ;
    public LinearLayout CYR;
    public ImageView CYS;
    public TextView CYT;
    public LinearLayout CYU;
    public TextView CYV;
    public ImageView CYW;
    public ImageView CYX;
    public TextView CYY;
    public TextView CYZ;
    public LinearLayout CZa;
    public GameMessageListContainerView CZb;
    public TextView iZH;
    public TextView qpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */