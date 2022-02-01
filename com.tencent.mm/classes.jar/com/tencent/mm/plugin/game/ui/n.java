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
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.f.e.b;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.o.i;
import com.tencent.mm.plugin.game.model.o.j;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends r<com.tencent.mm.plugin.game.model.o>
{
  private static w uqZ;
  private int djY;
  private int fTM;
  private Context mContext;
  private int oIZ;
  private int udq;
  private View.OnClickListener ura;
  private View.OnClickListener urb;
  private v urc;
  private v urd;
  private long ure;
  private int urf;
  int urg;
  private long urh;
  private com.tencent.mm.plugin.game.model.p urj;
  private com.tencent.mm.b.f<String, Bitmap> urk;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt, long paramLong)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(42259);
    this.oIZ = 15;
    this.fTM = 0;
    this.djY = 0;
    this.ure = 0L;
    this.udq = 0;
    this.urf = 0;
    this.urg = 0;
    this.mContext = paramContext;
    this.udq = paramInt;
    this.urh = paramLong;
    paramo = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH();
    String str = s.A(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.fTM = i;
      this.djY = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZi();
      uqZ = new w();
      this.ura = new o(paramContext, paramInt);
      this.urb = new p(paramContext, paramInt);
      this.urc = new v(paramContext);
      this.urc.gm(paramInt, 1);
      this.urd = new v(paramContext);
      this.urd.gm(paramInt, 2);
      this.urj = new com.tencent.mm.plugin.game.model.p(paramContext, this.udq);
      paramInt = c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(2131165442);
      int j = this.mContext.getResources().getDimensionPixelSize(2131165198);
      int k = this.mContext.getResources().getDimensionPixelSize(2131165500);
      this.urf = (a.aA(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.urk = new com.tencent.mm.memory.a.b(30, getClass());
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
  
  private com.tencent.mm.plugin.game.model.o HZ(int paramInt)
  {
    AppMethodBeat.i(42272);
    if (HY(paramInt))
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.JaC;
      AppMethodBeat.o(42272);
      return localo;
    }
    if (this.JaE != null)
    {
      localo = (com.tencent.mm.plugin.game.model.o)this.JaE.get(Integer.valueOf(paramInt));
      if (localo != null)
      {
        AppMethodBeat.o(42272);
        return localo;
      }
    }
    if (Ia(paramInt)) {}
    for (int i = paramInt - 1; (paramInt < 0) || (!getCursor().moveToPosition(i)); i = paramInt)
    {
      AppMethodBeat.o(42272);
      return null;
    }
    if (this.JaE == null)
    {
      localo = a((com.tencent.mm.plugin.game.model.o)this.JaC, getCursor());
      AppMethodBeat.o(42272);
      return localo;
    }
    com.tencent.mm.plugin.game.model.o localo = a(null, getCursor());
    this.JaE.put(Integer.valueOf(paramInt), localo);
    AppMethodBeat.o(42272);
    return localo;
  }
  
  private boolean Ia(int paramInt)
  {
    return (this.fTM > this.djY) && (this.djY > 0) && (paramInt > this.djY);
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
    if (this.urk.aM(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.urk.get(paramString);
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
    while (i < paramo.ubK.size())
    {
      localLinkedList.add(paramo.ubK.get(i));
      i += 1;
    }
    parama.urz.a(paramo, localLinkedList, this.urf, this.udq, this.urk);
    AppMethodBeat.o(42261);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(42266);
    e.a.a locala = new e.a.a();
    locala.idp = false;
    locala.uvL = paramFloat;
    e.dav().a(paramImageView, paramString, locala.daw(), new e.b()
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
  
  private void dad()
  {
    AppMethodBeat.i(42274);
    if (this.urh <= 0L)
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
        com.tencent.mm.plugin.game.model.o localo = HZ(i);
        if ((localo != null) && (localo.field_msgId == this.urh)) {
          this.urg = i;
        }
      }
      else
      {
        this.urh = 0L;
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
    if (!this.urk.aM(paramString))
    {
      i(paramImageView, paramString);
      AppMethodBeat.o(42262);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.urk.get(paramString);
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
    paramImageView = e.dav().n(paramImageView, paramString);
    if (paramImageView != null) {
      this.urk.put(paramString, paramImageView);
    }
    AppMethodBeat.o(42263);
  }
  
  private void j(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42264);
    if (this.urk.aM(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.urk.get(paramString);
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
  
  public final boolean HY(int paramInt)
  {
    return (this.fTM > this.djY) && (this.djY > 0) && (paramInt == this.djY);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(42267);
    s locals = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH();
    int i = this.oIZ;
    String str = s.A(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + i, new String[0]));
    this.oIZ = getCount();
    if (this.JaF != null) {
      this.JaF.aSs();
    }
    dad();
    super.notifyDataSetChanged();
    AppMethodBeat.o(42267);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(42268);
    det();
    Zu();
    AppMethodBeat.o(42268);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(42273);
    getCursor().close();
    Zu();
    AppMethodBeat.o(42273);
  }
  
  public final boolean bXb()
  {
    return this.oIZ >= this.fTM;
  }
  
  public final void dab()
  {
    AppMethodBeat.i(42270);
    if (bXb())
    {
      if (this.JaF != null) {
        this.JaF.aSs();
      }
      AppMethodBeat.o(42270);
      return;
    }
    this.oIZ += 15;
    if (this.oIZ > this.fTM) {
      this.oIZ = this.fTM;
    }
    AppMethodBeat.o(42270);
  }
  
  public final int dac()
  {
    if ((this.fTM > this.djY) && (this.djY > 0)) {
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
    int j = dac();
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
      locala.uro = ((ImageView)localView.findViewById(2131300891));
      locala.urn = ((LinearLayout)localView.findViewById(2131302519));
      locala.urp = ((LinearLayout)localView.findViewById(2131302525));
      locala.fOg = ((TextView)localView.findViewById(2131302867));
      locala.urq = ((ImageView)localView.findViewById(2131297065));
      locala.lZb = ((TextView)localView.findViewById(2131305896));
      locala.urr = ((TextView)localView.findViewById(2131302528));
      locala.urs = ((LinearLayout)localView.findViewById(2131302544));
      locala.urt = ((TextView)localView.findViewById(2131302546));
      locala.uru = ((ImageView)localView.findViewById(2131302545));
      locala.urv = ((ImageView)localView.findViewById(2131302532));
      locala.urw = ((TextView)localView.findViewById(2131302552));
      locala.urx = ((TextView)localView.findViewById(2131302549));
      locala.urz = ((GameMessageListContainerView)localView.findViewById(2131302556));
      locala.ury = ((LinearLayout)localView.findViewById(2131302527));
      localView.setTag(locala);
      localo = HZ(paramInt);
      if ((localo == null) || (!localo.ucF)) {
        break label342;
      }
      locala.urn.setVisibility(8);
      locala.ury.setVisibility(0);
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
    localo.cYU();
    int j;
    int i;
    if (!localo.uaY)
    {
      localo.uaY = true;
      j = paramInt + 1001;
      i = j;
      if (this.djY > 0)
      {
        i = j;
        if (paramInt > this.djY) {
          i = paramInt - 1;
        }
      }
      com.tencent.mm.game.report.f.a(this.mContext, 13, 1300, i, 1, 0, null, this.udq, 0, null, null, com.tencent.mm.game.report.f.a(null, null, localo.ucB, null));
    }
    locala.urn.setVisibility(0);
    locala.ury.setVisibility(8);
    locala.urw.setText(com.tencent.mm.plugin.game.f.b.l(this.context, localo.field_createTime * 1000L));
    label580:
    label620:
    label1266:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      float f;
      if (localo.ubM.ucN)
      {
        f = 0.08333334F;
        if (localo.ucp == null) {
          break label1287;
        }
        a(locala.uro, localo.ucp.ucR, f);
        locala.uro.setVisibility(0);
        if (bt.isNullOrNil(localo.ucp.ucQ)) {
          break label1240;
        }
        locala.fOg.setText(localo.ucp.ucQ);
        locala.fOg.setVisibility(0);
        if (bt.isNullOrNil(localo.ucp.ucS)) {
          break label1253;
        }
        j(locala.urq, localo.ucp.ucS);
        locala.urq.setVisibility(0);
        if (bt.isNullOrNil(localo.ucp.ucL)) {
          break label1266;
        }
        locala.fOg.setEnabled(true);
        locala.uro.setEnabled(true);
        paramView = new p.a(localo, localo.ucp.ucL, 1);
        paramViewGroup = new p.a(localo, localo.ucp.ucL, 2);
        locala.fOg.setTag(paramView);
        locala.fOg.setOnClickListener(this.urj);
        locala.uro.setTag(paramViewGroup);
        locala.uro.setOnClickListener(this.urj);
        label732:
        if (bt.isNullOrNil(localo.ucl)) {
          break label1708;
        }
        paramInt = localo.ubK.size();
        if (paramInt <= 1) {
          break label1692;
        }
        locala.lZb.setText(this.context.getResources().getString(2131759951, new Object[] { Integer.valueOf(paramInt) }) + localo.ucl);
        label810:
        locala.lZb.setVisibility(0);
        label819:
        if (bt.isNullOrNil(localo.ucm)) {
          break label1721;
        }
        locala.urr.setText(k.b(this.context, localo.ucm, locala.urr.getTextSize()));
        locala.urr.setVisibility(0);
        label867:
        a(localo, locala);
        if (bt.isNullOrNil(localo.ucq.mContent)) {
          break label1759;
        }
        locala.urs.setVisibility(0);
        if (bt.isNullOrNil(localo.ucq.ucL)) {
          break label1734;
        }
        paramView = new p.a(localo, localo.ucq.ucL, 3);
        locala.urs.setTag(paramView);
        locala.urs.setOnClickListener(this.urj);
        locala.urs.setEnabled(true);
        label961:
        locala.urt.setText(k.b(this.context, localo.ucq.mContent, locala.urt.getTextSize()));
        if (bt.isNullOrNil(localo.ucq.ucK)) {
          break label1746;
        }
        j(locala.uru, localo.ucq.ucK);
        locala.uru.setVisibility(0);
        label1032:
        if (bt.isNullOrNil(localo.ucn)) {
          break label1784;
        }
        j(locala.urv, localo.ucn);
        locala.urv.setVisibility(0);
        if (bt.isNullOrNil(localo.uco)) {
          break label1772;
        }
        paramView = new p.a(localo, localo.uco, 3);
        locala.urv.setTag(paramView);
        locala.urv.setOnClickListener(this.urj);
        locala.urv.setEnabled(true);
        label1123:
        if (bt.isNullOrNil(localo.ucr.mName)) {
          break label1809;
        }
        locala.urx.setText(localo.ucr.mName);
        locala.urx.setVisibility(0);
        if (bt.isNullOrNil(localo.ucr.ucL)) {
          break label1797;
        }
        paramView = new p.a(localo, localo.ucr.ucL, 5);
        locala.urx.setTag(paramView);
        locala.urx.setOnClickListener(this.urj);
        locala.urx.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(42260);
        return localView;
        f = 0.0F;
        break;
        label1240:
        locala.fOg.setVisibility(8);
        break label580;
        label1253:
        locala.urq.setVisibility(8);
        break label620;
        locala.fOg.setEnabled(false);
        locala.uro.setEnabled(false);
        break label732;
        label1287:
        if (!bt.hj(localo.ubK))
        {
          paramViewGroup = (o.j)localo.ubK.get(0);
          if (!bt.isNullOrNil(paramViewGroup.bVF))
          {
            paramView = paramViewGroup.bVF;
            label1326:
            if (bt.isNullOrNil(paramViewGroup.ucW)) {
              break label1596;
            }
            locala.fOg.setEnabled(true);
            locala.uro.setEnabled(true);
            localObject = new p.a(localo, paramViewGroup.ucW, 1);
            p.a locala1 = new p.a(localo, paramViewGroup.ucW, 2);
            locala.fOg.setTag(localObject);
            locala.fOg.setOnClickListener(this.urj);
            locala.uro.setTag(locala1);
            locala.uro.setOnClickListener(this.urj);
            label1430:
            if (bt.isNullOrNil(paramView)) {
              break label1617;
            }
            locala.fOg.setText(k.b(this.context, paramView, locala.fOg.getTextSize()), TextView.BufferType.SPANNABLE);
            locala.fOg.setVisibility(0);
            label1473:
            locala.uro.setVisibility(0);
            if (bt.isNullOrNil(paramViewGroup.ucT)) {
              break label1630;
            }
            a(locala.uro, paramViewGroup.ucT, f);
          }
          for (;;)
          {
            if (bt.isNullOrNil(paramViewGroup.ucV)) {
              break label1646;
            }
            j(locala.urq, paramViewGroup.ucV);
            locala.urq.setVisibility(0);
            break;
            paramView = ((l)g.ab(l.class)).azp().Bf(paramViewGroup.userName);
            if ((paramView == null) || (bt.isNullOrNil(paramView.adv())))
            {
              paramView = paramViewGroup.userName;
              break label1326;
            }
            paramView = paramView.adv();
            break label1326;
            label1596:
            locala.fOg.setEnabled(false);
            locala.uro.setEnabled(false);
            break label1430;
            label1617:
            locala.fOg.setVisibility(8);
            break label1473;
            label1630:
            h(locala.uro, paramViewGroup.userName);
          }
          label1646:
          locala.urq.setVisibility(8);
          break label732;
        }
        locala.uro.setVisibility(8);
        locala.fOg.setVisibility(8);
        locala.urq.setVisibility(8);
        break label732;
        label1692:
        locala.lZb.setText(localo.ucl);
        break label810;
        label1708:
        locala.lZb.setVisibility(8);
        break label819;
        label1721:
        locala.urr.setVisibility(8);
        break label867;
        label1734:
        locala.urs.setEnabled(false);
        break label961;
        label1746:
        locala.uru.setVisibility(8);
        break label1032;
        label1759:
        locala.urs.setVisibility(8);
        break label1032;
        label1772:
        locala.urv.setEnabled(false);
        break label1123;
        label1784:
        locala.urv.setVisibility(8);
        break label1123;
        label1797:
        locala.urx.setEnabled(false);
        continue;
        label1809:
        locala.urx.setVisibility(8);
      }
    }
    locala.lZb.setVisibility(8);
    locala.urr.setVisibility(8);
    locala.urs.setVisibility(8);
    locala.uru.setVisibility(8);
    locala.urv.setVisibility(8);
    locala.urx.setVisibility(8);
    locala.urx.setEnabled(false);
    locala.urv.setEnabled(false);
    locala.uro.setEnabled(false);
    locala.fOg.setEnabled(false);
    locala.urz.setVisibility(8);
    locala.urq.setVisibility(8);
    if (!bt.hj(localo.ubK))
    {
      localObject = (o.j)localo.ubK.get(0);
      paramView = ((l)g.ab(l.class)).azp().Bf(((o.j)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.adv();
        label1997:
        paramViewGroup = paramView;
        if (bt.isNullOrNil(paramView)) {
          paramViewGroup = ((o.j)localObject).bVF;
        }
        if (!bt.isNullOrNil(((o.j)localObject).ucU)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      i = localo.ubK.size();
      if ((!bt.isNullOrNil(localo.ubI)) && ((localo.ubZ & 1L) == 0L))
      {
        locala.urx.setText(localo.ubI);
        locala.urx.setVisibility(0);
        if ((localo.ubZ & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(2131100440);
          locala.urx.setTextColor(j);
          locala.urx.setBackgroundResource(2131232492);
          locala.urx.setOnClickListener(this.ura);
          locala.urx.setTag(localo);
          locala.urx.setEnabled(true);
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
        locala.fOg.setText(k.b(this.context, localo.mAppName, locala.fOg.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.fOg.setVisibility(0);
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
          locala.urx.setTextColor(j);
          locala.urx.setBackgroundResource(0);
          locala.urx.setOnClickListener(null);
          locala.urx.setEnabled(false);
          break label2161;
          label2377:
          if (!bt.isNullOrNil(paramViewGroup))
          {
            locala.fOg.setText(k.b(this.context, paramViewGroup, locala.fOg.getTextSize()));
            locala.fOg.setVisibility(0);
          }
          else
          {
            locala.fOg.setVisibility(8);
            continue;
            if (!bt.isNullOrNil(paramViewGroup))
            {
              locala.fOg.setText(k.b(this.context, paramViewGroup, locala.fOg.getTextSize()));
              locala.fOg.setVisibility(0);
              if (paramInt != 0)
              {
                locala.fOg.setOnClickListener(this.urc);
                locala.fOg.setTag(localo);
                locala.fOg.setEnabled(true);
              }
            }
            else
            {
              locala.fOg.setVisibility(8);
            }
          }
          label2433:
          break;
        }
      }
      if (!bt.isNullOrNil(localo.ubE))
      {
        j(locala.uro, localo.ubE);
        locala.uro.setVisibility(0);
        label2558:
        if (!bt.isNullOrNil(localo.pIa))
        {
          if (bt.isNullOrNil(localo.ubQ)) {
            break label2709;
          }
          locala.urr.setText(localo.pIa);
          locala.urr.setVisibility(0);
        }
      }
      while (!bt.isNullOrNil(localo.ubQ))
      {
        j(locala.urv, localo.ubQ);
        locala.urv.setTag(Long.valueOf(localo.field_msgId));
        locala.urv.setOnTouchListener(uqZ);
        locala.urv.setOnClickListener(this.urb);
        locala.urv.setVisibility(0);
        locala.urv.setEnabled(true);
        break;
        ad.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.uro.setVisibility(8);
        break label2558;
        label2709:
        locala.urs.setVisibility(0);
        locala.urt.setText(localo.pIa);
        locala.urs.setOnClickListener(this.urb);
        locala.urs.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!bt.hj(localo.ubK))
      {
        locala.uro.setVisibility(0);
        if (!bt.isNullOrNil(((o.j)localo.ubK.get(0)).ucT))
        {
          j(locala.uro, ((o.j)localo.ubK.get(0)).ucT);
          label2827:
          if (!bt.isNullOrNil(((o.j)localo.ubK.get(0)).ucU))
          {
            locala.uro.setOnClickListener(this.urd);
            locala.uro.setTag(localo);
            locala.uro.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.urs.setVisibility(0);
        locala.urs.setOnClickListener(this.urb);
        locala.urs.setTag(Long.valueOf(localo.field_msgId));
        if (localo.ucy != 1) {
          break label3018;
        }
        locala.urr.setVisibility(0);
        locala.urr.setText(k.b(this.context, localo.ucd, locala.urr.getTextSize()));
        locala.urt.setText(localo.ucg);
        break;
        h(locala.uro, ((o.j)localo.ubK.get(0)).userName);
        break label2827;
        locala.uro.setVisibility(8);
      }
      label3018:
      if (localo.ucy == 2)
      {
        locala.urr.setVisibility(0);
        locala.urr.setText(k.b(this.context, localo.ucd, locala.urr.getTextSize()));
        locala.urt.setText(localo.uce);
        break;
      }
      if (localo.ucy != 3) {
        break;
      }
      locala.lZb.setVisibility(0);
      if (i > 1)
      {
        locala.lZb.setText(this.context.getResources().getString(2131759943, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.urt.setText(localo.ucg);
        break;
        locala.lZb.setText(this.context.getResources().getString(2131759944));
      }
      j(locala.uro, localo.ubE);
      paramView = "礼物";
      if (localo.ubV.contains("爱心"))
      {
        paramView = "爱心";
        label3221:
        if (i <= 1) {
          break label3305;
        }
        locala.lZb.setText(this.context.getResources().getString(2131759949, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.lZb.setVisibility(0);
        a(localo, locala);
        break;
        if (!localo.ubV.contains("体力")) {
          break label3221;
        }
        paramView = "体力";
        break label3221;
        label3305:
        locala.lZb.setText(this.context.getResources().getString(2131759950, new Object[] { paramView }));
      }
      if (!bt.hj(localo.ubK))
      {
        locala.uro.setVisibility(0);
        if (!bt.isNullOrNil(((o.j)localo.ubK.get(0)).ucT))
        {
          j(locala.uro, ((o.j)localo.ubK.get(0)).ucT);
          label3402:
          if (!bt.isNullOrNil(((o.j)localo.ubK.get(0)).ucU))
          {
            locala.uro.setOnClickListener(this.urd);
            locala.uro.setTag(localo);
            locala.uro.setEnabled(true);
          }
          label3454:
          if (i <= 1) {
            break label3637;
          }
          locala.lZb.setText(this.context.getResources().getString(2131759945, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.urs.setVisibility(0);
        locala.lZb.setVisibility(0);
        locala.urt.setText(localo.uch);
        locala.urs.setOnClickListener(this.urb);
        locala.urs.setTag(Long.valueOf(localo.field_msgId));
        if (bt.isNullOrNil(localo.ucj)) {
          break;
        }
        locala.uru.setVisibility(0);
        j(locala.uru, localo.ucj);
        break;
        h(locala.uro, ((o.j)localo.ubK.get(0)).userName);
        break label3402;
        locala.uro.setVisibility(8);
        break label3454;
        label3637:
        locala.lZb.setText(this.context.getResources().getString(2131759946));
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
    public TextView fOg;
    public TextView lZb;
    public LinearLayout urn;
    public ImageView uro;
    public LinearLayout urp;
    public ImageView urq;
    public TextView urr;
    public LinearLayout urs;
    public TextView urt;
    public ImageView uru;
    public ImageView urv;
    public TextView urw;
    public TextView urx;
    public LinearLayout ury;
    public GameMessageListContainerView urz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */