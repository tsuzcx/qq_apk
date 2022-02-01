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
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.f.e.b;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.o.j;
import com.tencent.mm.plugin.game.model.o.k;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends r<com.tencent.mm.plugin.game.model.o>
{
  private static w uCu;
  private int dla;
  private int fVS;
  private Context mContext;
  private int oPB;
  private int uCA;
  int uCB;
  private long uCC;
  private com.tencent.mm.plugin.game.model.p uCD;
  private com.tencent.mm.b.f<String, Bitmap> uCE;
  private View.OnClickListener uCv;
  private View.OnClickListener uCw;
  private v uCx;
  private v uCy;
  private long uCz;
  private int uoy;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.oPB = 15;
    this.fVS = 0;
    this.dla = 0;
    this.uCz = 0L;
    this.uoy = 0;
    this.uCA = 0;
    this.uCB = 0;
    this.mContext = paramContext;
    this.uoy = paramInt;
    this.uCC = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl();
    String str = s.B(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.fVS = i;
      this.dla = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().dbS();
      uCu = new w();
      this.uCv = new o(paramContext, paramInt);
      this.uCw = new p(paramContext, paramInt);
      this.uCx = new v(paramContext);
      this.uCx.gm(paramInt, 1);
      this.uCy = new v(paramContext);
      this.uCy.gm(paramInt, 2);
      this.uCD = new com.tencent.mm.plugin.game.model.p(paramContext, this.uoy);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131165442);
      int j = this.mContext.getResources().getDimensionPixelSize(2131165198);
      int k = this.mContext.getResources().getDimensionPixelSize(2131165500);
      this.uCA = (a.aA(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.uCE = new com.tencent.mm.memory.a.b(30, getClass());
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
  
  private com.tencent.mm.plugin.game.model.o Ix(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (Iw(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.Jvk;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.Jvm != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.Jvm.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (Iy(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!getCursor().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.Jvm == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.Jvk, getCursor());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, getCursor());
    this.Jvm.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean Iy(int paramInt)
  {
    return (this.fVS > this.dla) && (this.dla > 0) && (paramInt > this.dla);
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
    if (this.uCE.aM(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.uCE.get(paramString);
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
    while (i < paramo.umM.size())
    {
      localLinkedList.add(paramo.umM.get(i));
      i += 1;
    }
    parama.uCS.a(paramo, localLinkedList, this.uCA, this.uoy, this.uCE);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.igi = false;
    locala.uHk = paramFloat;
    e.ddh().a(paramImageView, paramString, locala.ddi(), new e.b()
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
  
  private void dcO()
  {
    AppMethodBeat.i(42274);
    if (this.uCC <= 0L)
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
        com.tencent.mm.plugin.game.model.o localo = Ix(i);
        if ((localo != null) && (localo.field_msgId == this.uCC)) {
          this.uCB = i;
        }
      }
      else
      {
        this.uCC = 0L;
        AppMethodBeat.o(42274);
        return;
      }
      i += 1;
    }
  }
  
  private void h(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42262);
    if (bu.isNullOrNil(paramString))
    {
      a.b.c(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    if (!this.uCE.aM(paramString))
    {
      i(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.uCE.get(paramString);
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
    paramImageView = e.ddh().n(paramImageView, paramString);
    if (paramImageView != null) {
      this.uCE.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  private void j(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.uCE.aM(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.uCE.get(paramString);
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
  
  public final boolean Iw(int paramInt)
  {
    return (this.fVS > this.dla) && (this.dla > 0) && (paramInt == this.dla);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(42267);
    s locals = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl();
    int i = this.oPB;
    String str = s.B(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + i, new String[0]));
    this.oPB = getCount();
    if (this.Jvn != null) {
      this.Jvn.aSR();
    }
    dcO();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(42268);
    dhl();
    ZD();
    AppMethodBeat.o(42268);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(42273);
    getCursor().close();
    ZD();
    AppMethodBeat.o(42273);
  }
  
  public final boolean bYq()
  {
    return this.oPB >= this.fVS;
  }
  
  public final void dcM()
  {
    AppMethodBeat.i(42270);
    if (bYq())
    {
      if (this.Jvn != null) {
        this.Jvn.aSR();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.oPB += 15;
    if (this.oPB > this.fVS) {
      this.oPB = this.fVS;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int dcN()
  {
    if ((this.fVS > this.dla) && (this.dla > 0)) {
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
    int j = dcN();
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
      locala.uCH = ((ImageView)localView.findViewById(2131300891));
      locala.uCG = ((LinearLayout)localView.findViewById(2131302519));
      locala.uCI = ((LinearLayout)localView.findViewById(2131302525));
      locala.fQm = ((TextView)localView.findViewById(2131302867));
      locala.uCJ = ((ImageView)localView.findViewById(2131297065));
      locala.mdu = ((TextView)localView.findViewById(2131305896));
      locala.uCK = ((TextView)localView.findViewById(2131302528));
      locala.uCL = ((LinearLayout)localView.findViewById(2131302544));
      locala.uCM = ((TextView)localView.findViewById(2131302546));
      locala.uCN = ((ImageView)localView.findViewById(2131302545));
      locala.uCO = ((ImageView)localView.findViewById(2131302532));
      locala.uCP = ((TextView)localView.findViewById(2131302552));
      locala.uCQ = ((TextView)localView.findViewById(2131302549));
      locala.uCS = ((GameMessageListContainerView)localView.findViewById(2131302556));
      locala.uCR = ((LinearLayout)localView.findViewById(2131302527));
      localView.setTag(locala);
      localo = Ix(paramInt);
      if ((localo == null) || (!localo.unJ)) {
        break label342;
      }
      locala.uCG.setVisibility(8);
      locala.uCR.setVisibility(0);
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
    localo.dbE();
    int j;
    int i;
    if (!localo.uma)
    {
      localo.uma = true;
      j = paramInt + 1001;
      i = j;
      if (this.dla > 0)
      {
        i = j;
        if (paramInt > this.dla) {
          i = paramInt - 1;
        }
      }
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1300, i, 1, 0, null, this.uoy, 0, null, null, com.tencent.mm.game.report.f.a(null, null, localo.unF, null));
    }
    locala.uCG.setVisibility(0);
    locala.uCR.setVisibility(8);
    locala.uCP.setText(com.tencent.mm.plugin.game.f.b.m(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.umO.unS)
      {
        f = 0.08333334F;
        if (localo.unr == null) {
          break label1287;
        }
        a(locala.uCH, localo.unr.unW, f);
        locala.uCH.setVisibility(0);
        if (bu.isNullOrNil(localo.unr.unV)) {
          break label1240;
        }
        locala.fQm.setText(localo.unr.unV);
        locala.fQm.setVisibility(0);
        if (bu.isNullOrNil(localo.unr.unX)) {
          break label1253;
        }
        j(locala.uCJ, localo.unr.unX);
        locala.uCJ.setVisibility(0);
        if (bu.isNullOrNil(localo.unr.unQ)) {
          break label1266;
        }
        locala.fQm.setEnabled(true);
        locala.uCH.setEnabled(true);
        paramView = new p.a(localo, localo.unr.unQ, 1);
        paramViewGroup = new p.a(localo, localo.unr.unQ, 2);
        locala.fQm.setTag(paramView);
        locala.fQm.setOnClickListener(this.uCD);
        locala.uCH.setTag(paramViewGroup);
        locala.uCH.setOnClickListener(this.uCD);
        label732:
        if (bu.isNullOrNil(localo.unn)) {
          break label1708;
        }
        paramInt = localo.umM.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.mdu.setText(this.context.getResources().getString(2131759951, new Object[] { Integer.valueOf(paramInt) }) + localo.unn);
        label810:
        locala.mdu.setVisibility(0);
        label819:
        if (bu.isNullOrNil(localo.uno)) {
          break label1721;
        }
        locala.uCK.setText(k.b(this.context, localo.uno, locala.uCK.getTextSize()));
        locala.uCK.setVisibility(0);
        label867:
        a(localo, locala);
        if (bu.isNullOrNil(localo.uns.mContent)) {
          break label1759;
        }
        locala.uCL.setVisibility(0);
        if (bu.isNullOrNil(localo.uns.unQ)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.uns.unQ, 3);
        locala.uCL.setTag(paramView);
        locala.uCL.setOnClickListener(this.uCD);
        locala.uCL.setEnabled(true);
        label961:
        locala.uCM.setText(k.b(this.context, localo.uns.mContent, locala.uCM.getTextSize()));
        if (bu.isNullOrNil(localo.uns.unP)) {
          break label1746;
        }
        j(locala.uCN, localo.uns.unP);
        locala.uCN.setVisibility(0);
        label1032:
        if (bu.isNullOrNil(localo.unp)) {
          break label1784;
        }
        j(locala.uCO, localo.unp);
        locala.uCO.setVisibility(0);
        if (bu.isNullOrNil(localo.unq)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.unq, 3);
        locala.uCO.setTag(paramView);
        locala.uCO.setOnClickListener(this.uCD);
        locala.uCO.setEnabled(true);
        label1123:
        if (bu.isNullOrNil(localo.unt.mName)) {
          break label1809;
        }
        locala.uCQ.setText(localo.unt.mName);
        locala.uCQ.setVisibility(0);
        if (bu.isNullOrNil(localo.unt.unQ)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.unt.unQ, 5);
        locala.uCQ.setTag(paramView);
        locala.uCQ.setOnClickListener(this.uCD);
        locala.uCQ.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.fQm.setVisibility(8);
        break label580;
        label1253:
        locala.uCJ.setVisibility(8);
        break label620;
        locala.fQm.setEnabled(false);
        locala.uCH.setEnabled(false);
        break label732;
        label1287:
        if (!bu.ht(localo.umM))
        {
          paramViewGroup = (o.k)localo.umM.get(0);
          if (!bu.isNullOrNil(paramViewGroup.bVF))
          {
            paramView = paramViewGroup.bVF;
            label1326:
            if (bu.isNullOrNil(paramViewGroup.uob)) {
              break label1596;
            }
            locala.fQm.setEnabled(true);
            locala.uCH.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.uob, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.uob, 2);
            locala.fQm.setTag(localObject);
            locala.fQm.setOnClickListener(this.uCD);
            locala.uCH.setTag(locala1);
            locala.uCH.setOnClickListener(this.uCD);
            label1430:
            if (bu.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.fQm.setText(k.b(this.context, paramView, locala.fQm.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.fQm.setVisibility(0);
            label1473:
            locala.uCH.setVisibility(0);
            if (bu.isNullOrNil(paramViewGroup.unY)) {
              break label1630;
            }
            a(locala.uCH, paramViewGroup.unY, f);
          }
          for (;;)
          {
            if (bu.isNullOrNil(paramViewGroup.uoa)) {
              break label1646;
            }
            j(locala.uCJ, paramViewGroup.uoa);
            locala.uCJ.setVisibility(0);
            break;
            paramView = ((l)g.ab(l.class)).azF().BH(paramViewGroup.userName);
            if ((paramView == null) || (bu.isNullOrNil(paramView.adG())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.adG();
            break label1326;
            label1596:
            locala.fQm.setEnabled(false);
            locala.uCH.setEnabled(false);
            break label1430;
            label1617:
            locala.fQm.setVisibility(8);
            break label1473;
            label1630:
            h(locala.uCH, paramViewGroup.userName);
          }
          label1646:
          locala.uCJ.setVisibility(8);
          break label732;
        }
        locala.uCH.setVisibility(8);
        locala.fQm.setVisibility(8);
        locala.uCJ.setVisibility(8);
        break label732;
        label1692:
        locala.mdu.setText(localo.unn);
        break label810;
        label1708:
        locala.mdu.setVisibility(8);
        break label819;
        label1721:
        locala.uCK.setVisibility(8);
        break label867;
        label1734:
        locala.uCL.setEnabled(false);
        break label961;
        label1746:
        locala.uCN.setVisibility(8);
        break label1032;
        label1759:
        locala.uCL.setVisibility(8);
        break label1032;
        label1772:
        locala.uCO.setEnabled(false);
        break label1123;
        label1784:
        locala.uCO.setVisibility(8);
        break label1123;
        label1797:
        locala.uCQ.setEnabled(false);
        continue;
        label1809:
        locala.uCQ.setVisibility(8);
      }
    }
    locala.mdu.setVisibility(8);
    locala.uCK.setVisibility(8);
    locala.uCL.setVisibility(8);
    locala.uCN.setVisibility(8);
    locala.uCO.setVisibility(8);
    locala.uCQ.setVisibility(8);
    locala.uCQ.setEnabled(false);
    locala.uCO.setEnabled(false);
    locala.uCH.setEnabled(false);
    locala.fQm.setEnabled(false);
    locala.uCS.setVisibility(8);
    locala.uCJ.setVisibility(8);
    if (!bu.ht(localo.umM))
    {
      localObject = (o.k)localo.umM.get(0);
      paramView = ((l)g.ab(l.class)).azF().BH(((o.k)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.adG();
        label1997:
        paramViewGroup = paramView;
        if (bu.isNullOrNil(paramView)) {
          paramViewGroup = ((o.k)localObject).bVF;
        }
        if (!bu.isNullOrNil(((o.k)localObject).unZ)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.umM.size();
      if ((!bu.isNullOrNil(localo.umK)) && ((localo.unb & 1L) == 0L))
      {
        locala.uCQ.setText(localo.umK);
        locala.uCQ.setVisibility(0);
        if ((localo.unb & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(2131100440);
          locala.uCQ.setTextColor(j);
          locala.uCQ.setBackgroundResource(2131232492);
          locala.uCQ.setOnClickListener(this.uCv);
          locala.uCQ.setTag(localo);
          locala.uCQ.setEnabled(true);
        }
      }
      else
      {
        label2161:
        if ((localo.field_msgType != 10) && (localo.field_msgType != 11)) {
          break label2433;
        }
        if (bu.isNullOrNil(localo.mAppName)) {
          break label2377;
        }
        locala.fQm.setText(k.b(this.context, localo.mAppName, locala.fQm.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.fQm.setVisibility(0);
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
          ae.e("MicroMsg.GameMessageAdapter", "error msgtype: " + localo.field_msgType);
          break label318;
          j = this.context.getResources().getColor(2131100420);
          locala.uCQ.setTextColor(j);
          locala.uCQ.setBackgroundResource(0);
          locala.uCQ.setOnClickListener(null);
          locala.uCQ.setEnabled(false);
          break label2161;
          label2377:
          if (!bu.isNullOrNil(paramViewGroup))
          {
            locala.fQm.setText(k.b(this.context, paramViewGroup, locala.fQm.getTextSize()));
            locala.fQm.setVisibility(0);
          }
          else
          {
            locala.fQm.setVisibility(8);
            continue;
            if (!bu.isNullOrNil(paramViewGroup))
            {
              locala.fQm.setText(k.b(this.context, paramViewGroup, locala.fQm.getTextSize()));
              locala.fQm.setVisibility(0);
              if (paramInt != 0)
              {
                locala.fQm.setOnClickListener(this.uCx);
                locala.fQm.setTag(localo);
                locala.fQm.setEnabled(true);
              }
            }
            else
            {
              locala.fQm.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!bu.isNullOrNil(localo.umG))
      {
        j(locala.uCH, localo.umG);
        locala.uCH.setVisibility(0);
        label2558:
        if (!bu.isNullOrNil(localo.pOE))
        {
          if (bu.isNullOrNil(localo.umS)) {
            break label2709;
          }
          locala.uCK.setText(localo.pOE);
          locala.uCK.setVisibility(0);
        }
      }
      while (!bu.isNullOrNil(localo.umS))
      {
        j(locala.uCO, localo.umS);
        locala.uCO.setTag(Long.valueOf(localo.field_msgId));
        locala.uCO.setOnTouchListener(uCu);
        locala.uCO.setOnClickListener(this.uCw);
        locala.uCO.setVisibility(0);
        locala.uCO.setEnabled(true);
        break;
        ae.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.uCH.setVisibility(8);
        break label2558;
        label2709:
        locala.uCL.setVisibility(0);
        locala.uCM.setText(localo.pOE);
        locala.uCL.setOnClickListener(this.uCw);
        locala.uCL.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!bu.ht(localo.umM))
      {
        locala.uCH.setVisibility(0);
        if (!bu.isNullOrNil(((o.k)localo.umM.get(0)).unY))
        {
          j(locala.uCH, ((o.k)localo.umM.get(0)).unY);
          label2827:
          if (!bu.isNullOrNil(((o.k)localo.umM.get(0)).unZ))
          {
            locala.uCH.setOnClickListener(this.uCy);
            locala.uCH.setTag(localo);
            locala.uCH.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.uCL.setVisibility(0);
        locala.uCL.setOnClickListener(this.uCw);
        locala.uCL.setTag(Long.valueOf(localo.field_msgId));
        if (localo.unC != 1) {
          break label3018;
        }
        locala.uCK.setVisibility(0);
        locala.uCK.setText(k.b(this.context, localo.unf, locala.uCK.getTextSize()));
        locala.uCM.setText(localo.uni);
        break;
        h(locala.uCH, ((o.k)localo.umM.get(0)).userName);
        break label2827;
        locala.uCH.setVisibility(8);
      }
      label3018:
      if (localo.unC == 2)
      {
        locala.uCK.setVisibility(0);
        locala.uCK.setText(k.b(this.context, localo.unf, locala.uCK.getTextSize()));
        locala.uCM.setText(localo.ung);
        break;
      }
      if (localo.unC != 3) {
        break;
      }
      locala.mdu.setVisibility(0);
      if (i > 1)
      {
        locala.mdu.setText(this.context.getResources().getString(2131759943, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.uCM.setText(localo.uni);
        break;
        locala.mdu.setText(this.context.getResources().getString(2131759944));
      }
      j(locala.uCH, localo.umG);
      paramView = "礼物";
      if (localo.umX.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.mdu.setText(this.context.getResources().getString(2131759949, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.mdu.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.umX.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.mdu.setText(this.context.getResources().getString(2131759950, new Object[] { paramView }));
      }
      if (!bu.ht(localo.umM))
      {
        locala.uCH.setVisibility(0);
        if (!bu.isNullOrNil(((o.k)localo.umM.get(0)).unY))
        {
          j(locala.uCH, ((o.k)localo.umM.get(0)).unY);
          label3402:
          if (!bu.isNullOrNil(((o.k)localo.umM.get(0)).unZ))
          {
            locala.uCH.setOnClickListener(this.uCy);
            locala.uCH.setTag(localo);
            locala.uCH.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.mdu.setText(this.context.getResources().getString(2131759945, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.uCL.setVisibility(0);
        locala.mdu.setVisibility(0);
        locala.uCM.setText(localo.unj);
        locala.uCL.setOnClickListener(this.uCw);
        locala.uCL.setTag(Long.valueOf(localo.field_msgId));
        if (bu.isNullOrNil(localo.unl)) {
          break;
        }
        locala.uCN.setVisibility(0);
        j(locala.uCN, localo.unl);
        break;
        h(locala.uCH, ((o.k)localo.umM.get(0)).userName);
        break label3402;
        locala.uCH.setVisibility(8);
        break label3454;
        label3637:
        locala.mdu.setText(this.context.getResources().getString(2131759946));
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
    public TextView fQm;
    public TextView mdu;
    public LinearLayout uCG;
    public ImageView uCH;
    public LinearLayout uCI;
    public ImageView uCJ;
    public TextView uCK;
    public LinearLayout uCL;
    public TextView uCM;
    public ImageView uCN;
    public ImageView uCO;
    public TextView uCP;
    public TextView uCQ;
    public LinearLayout uCR;
    public GameMessageListContainerView uCS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */