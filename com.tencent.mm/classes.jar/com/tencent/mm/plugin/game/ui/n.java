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
import com.tencent.mm.a.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.o.h;
import com.tencent.mm.plugin.game.model.p.a;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends r<com.tencent.mm.plugin.game.model.o>
{
  private static w ldr;
  private int bFo = 0;
  int dsw = 0;
  int iwi = 15;
  private int kQh = 0;
  private View.OnClickListener lds;
  private View.OnClickListener ldt;
  private v ldu;
  private v ldv;
  private long ldw = 0L;
  private int ldx = 0;
  private com.tencent.mm.plugin.game.model.p ldy;
  private f<String, Bitmap> ldz;
  private Context mContext;
  
  public n(Context paramContext, com.tencent.mm.plugin.game.model.o paramo, int paramInt)
  {
    super(paramContext, paramo);
    this.mContext = paramContext;
    this.kQh = paramInt;
    paramo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf();
    String str = s.n(new int[] { 2, 5, 6, 10, 11, 100 });
    paramo = paramo.rawQuery("select count(*) from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0", new String[0]);
    if (paramo == null)
    {
      this.dsw = i;
      this.bFo = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().aZv();
      ldr = new w();
      this.lds = new o(paramContext, paramInt);
      this.ldt = new p(paramContext, paramInt);
      this.ldu = new v(paramContext);
      this.ldu.cY(paramInt, 1);
      this.ldv = new v(paramContext);
      this.ldv.cY(paramInt, 2);
      this.ldy = new com.tencent.mm.plugin.game.model.p(paramContext, this.kQh);
      paramInt = com.tencent.mm.plugin.game.f.c.getScreenWidth(this.mContext);
      i = this.mContext.getResources().getDimensionPixelSize(g.c.GameRankIconSize);
      int j = this.mContext.getResources().getDimensionPixelSize(g.c.BiggerPadding);
      int k = this.mContext.getResources().getDimensionPixelSize(g.c.MiddlePadding);
      this.ldx = (a.ad(this.mContext, paramInt - j * 2 - i - k) / 34);
      this.ldz = new f(30);
      return;
    }
    if (paramo.moveToFirst()) {}
    for (i = paramo.getInt(0);; i = 0)
    {
      paramo.close();
      break;
    }
  }
  
  private static com.tencent.mm.plugin.game.model.o a(com.tencent.mm.plugin.game.model.o paramo, Cursor paramCursor)
  {
    com.tencent.mm.plugin.game.model.o localo = paramo;
    if (paramo == null) {
      localo = new com.tencent.mm.plugin.game.model.o();
    }
    localo.d(paramCursor);
    return localo;
  }
  
  private void a(com.tencent.mm.plugin.game.model.o paramo, n.a parama)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 1;
    while (i < paramo.kPd.size())
    {
      localLinkedList.add(paramo.kPd.get(i));
      i += 1;
    }
    parama.ldN.a(paramo, localLinkedList, this.ldx, this.kQh, this.ldz);
  }
  
  private void c(ImageView paramImageView, String paramString)
  {
    if (bk.bl(paramString))
    {
      a.b.a(paramImageView, paramString);
      return;
    }
    if (!this.ldz.aC(paramString))
    {
      d(paramImageView, paramString);
      return;
    }
    Bitmap localBitmap = (Bitmap)this.ldz.get(paramString);
    if ((localBitmap == null) || (localBitmap.isRecycled()))
    {
      d(paramImageView, paramString);
      return;
    }
    paramImageView.setImageBitmap(localBitmap);
  }
  
  private void d(ImageView paramImageView, String paramString)
  {
    paramImageView = e.baw().h(paramImageView, paramString);
    if (paramImageView != null) {
      this.ldz.put(paramString, paramImageView);
    }
  }
  
  private void e(ImageView paramImageView, String paramString)
  {
    if (this.ldz.aC(paramString))
    {
      Bitmap localBitmap = (Bitmap)this.ldz.get(paramString);
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        f(paramImageView, paramString);
        return;
      }
      paramImageView.setImageBitmap(localBitmap);
      return;
    }
    f(paramImageView, paramString);
  }
  
  private void f(ImageView paramImageView, String paramString)
  {
    e.a.a locala = new e.a.a();
    locala.erd = false;
    e.baw().a(paramImageView, paramString, locala.bax(), new n.1(this, paramString));
  }
  
  private com.tencent.mm.plugin.game.model.o sl(int paramInt)
  {
    if (sk(paramInt)) {
      localObject = (com.tencent.mm.plugin.game.model.o)this.uMg;
    }
    com.tencent.mm.plugin.game.model.o localo;
    do
    {
      return localObject;
      if (this.uMh == null) {
        break;
      }
      localo = (com.tencent.mm.plugin.game.model.o)this.uMh.get(Integer.valueOf(paramInt));
      localObject = localo;
    } while (localo != null);
    if ((this.dsw > this.bFo) && (this.bFo > 0) && (paramInt > this.bFo))
    {
      i = 1;
      if (i == 0) {
        break label111;
      }
    }
    label111:
    for (int i = paramInt - 1;; i = paramInt)
    {
      if ((paramInt >= 0) && (getCursor().moveToPosition(i))) {
        break label116;
      }
      return null;
      i = 0;
      break;
    }
    label116:
    if (this.uMh == null) {
      return a((com.tencent.mm.plugin.game.model.o)this.uMg, getCursor());
    }
    Object localObject = a(null, getCursor());
    this.uMh.put(Integer.valueOf(paramInt), localObject);
    return localObject;
  }
  
  public final boolean aCc()
  {
    return this.iwi >= this.dsw;
  }
  
  protected final int bam()
  {
    if ((this.dsw > this.bFo) && (this.bFo > 0)) {
      return 1;
    }
    return 0;
  }
  
  public final int getCount()
  {
    if (this.count < 0) {
      this.count = getCursor().getCount();
    }
    if (this.count <= 0) {
      return 0;
    }
    return this.count + bam();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    n.a locala;
    View localView;
    com.tencent.mm.plugin.game.model.o localo;
    if (paramView == null)
    {
      locala = new n.a();
      localView = View.inflate(this.context, g.f.game_message_item, null);
      locala.ldC = ((ImageView)localView.findViewById(g.e.icon_iv));
      locala.ldB = ((LinearLayout)localView.findViewById(g.e.msg));
      locala.ldD = ((LinearLayout)localView.findViewById(g.e.msg_content));
      locala.doV = ((TextView)localView.findViewById(g.e.nickname_tv));
      locala.ldE = ((ImageView)localView.findViewById(g.e.badge_icon));
      locala.gSy = ((TextView)localView.findViewById(g.e.tips_tv));
      locala.ldF = ((TextView)localView.findViewById(g.e.msg_first_line_text));
      locala.ldG = ((LinearLayout)localView.findViewById(g.e.msg_second_line));
      locala.ldH = ((TextView)localView.findViewById(g.e.msg_second_line_text));
      locala.ldI = ((ImageView)localView.findViewById(g.e.msg_second_line_icon));
      locala.ldJ = ((ImageView)localView.findViewById(g.e.msg_img_iv));
      locala.ldK = ((TextView)localView.findViewById(g.e.msg_time_tv));
      locala.ldL = ((TextView)localView.findViewById(g.e.msg_sourcename_tv));
      locala.ldN = ((GameMessageListContainerView)localView.findViewById(g.e.msg_user_icon_view));
      locala.ldM = ((LinearLayout)localView.findViewById(g.e.msg_dividing));
      localView.setTag(locala);
      localo = sl(paramInt);
      if ((localo == null) || (!localo.kPQ)) {
        break label330;
      }
      locala.ldB.setVisibility(8);
      locala.ldM.setVisibility(0);
    }
    label330:
    while (localo == null)
    {
      return localView;
      locala = (n.a)paramView.getTag();
      localView = paramView;
      break;
    }
    localo.aZm();
    locala.ldB.setVisibility(0);
    locala.ldM.setVisibility(8);
    locala.ldK.setText(b.g(this.context, localo.field_createTime * 1000L));
    label506:
    Object localObject;
    if (localo.field_msgType == 100)
    {
      if (localo.kPH != null)
      {
        e(locala.ldC, localo.kPH.kPY);
        locala.ldC.setVisibility(0);
        if (!bk.bl(localo.kPH.kPX))
        {
          locala.doV.setText(localo.kPH.kPX);
          locala.doV.setVisibility(0);
          if (bk.bl(localo.kPH.kPZ)) {
            break label1127;
          }
          e(locala.ldE, localo.kPH.kPZ);
          locala.ldE.setVisibility(0);
          if (bk.bl(localo.kPH.kPT)) {
            break label1140;
          }
          locala.doV.setEnabled(true);
          locala.ldC.setEnabled(true);
          paramView = new p.a(localo, localo.kPH.kPT, 1);
          paramViewGroup = new p.a(localo, localo.kPH.kPT, 2);
          locala.doV.setTag(paramView);
          locala.doV.setOnClickListener(this.ldy);
          locala.ldC.setTag(paramViewGroup);
          locala.ldC.setOnClickListener(this.ldy);
          label618:
          if (bk.bl(localo.kPD)) {
            break label1580;
          }
          paramInt = localo.kPd.size();
          if (paramInt <= 1) {
            break label1564;
          }
          locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_user_count, new Object[] { Integer.valueOf(paramInt) }) + localo.kPD);
          label696:
          locala.gSy.setVisibility(0);
          label705:
          if (bk.bl(localo.kPE)) {
            break label1593;
          }
          locala.ldF.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, localo.kPE, locala.ldF.getTextSize()));
          locala.ldF.setVisibility(0);
          label753:
          a(localo, locala);
          if (bk.bl(localo.kPI.kPW)) {
            break label1631;
          }
          locala.ldG.setVisibility(0);
          if (bk.bl(localo.kPI.kPT)) {
            break label1606;
          }
          paramView = new p.a(localo, localo.kPI.kPT, 3);
          locala.ldG.setTag(paramView);
          locala.ldG.setOnClickListener(this.ldy);
          locala.ldG.setEnabled(true);
          label847:
          locala.ldH.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, localo.kPI.kPW, locala.ldH.getTextSize()));
          if (bk.bl(localo.kPI.kPS)) {
            break label1618;
          }
          e(locala.ldI, localo.kPI.kPS);
          locala.ldI.setVisibility(0);
          label918:
          if (bk.bl(localo.kPF)) {
            break label1656;
          }
          e(locala.ldJ, localo.kPF);
          locala.ldJ.setVisibility(0);
          if (bk.bl(localo.kPG)) {
            break label1644;
          }
          paramView = new p.a(localo, localo.kPG, 3);
          locala.ldJ.setTag(paramView);
          locala.ldJ.setOnClickListener(this.ldy);
          locala.ldJ.setEnabled(true);
        }
      }
      for (;;)
      {
        if (!bk.bl(localo.kPJ.mName))
        {
          locala.ldL.setText(localo.kPJ.mName);
          locala.ldL.setVisibility(0);
          if (!bk.bl(localo.kPJ.kPT))
          {
            paramView = new p.a(localo, localo.kPJ.kPT, 5);
            locala.ldL.setTag(paramView);
            locala.ldL.setOnClickListener(this.ldy);
            locala.ldL.setEnabled(true);
            return localView;
            locala.doV.setVisibility(8);
            break;
            label1127:
            locala.ldE.setVisibility(8);
            break label506;
            label1140:
            locala.doV.setEnabled(false);
            locala.ldC.setEnabled(false);
            break label618;
            if (!bk.dk(localo.kPd))
            {
              paramViewGroup = (o.h)localo.kPd.get(0);
              if (!bk.bl(paramViewGroup.aVr))
              {
                paramView = paramViewGroup.aVr;
                label1200:
                if (bk.bl(paramViewGroup.kQe)) {
                  break label1468;
                }
                locala.doV.setEnabled(true);
                locala.ldC.setEnabled(true);
                localObject = new p.a(localo, paramViewGroup.kQe, 1);
                p.a locala1 = new p.a(localo, paramViewGroup.kQe, 2);
                locala.doV.setTag(localObject);
                locala.doV.setOnClickListener(this.ldy);
                locala.ldC.setTag(locala1);
                locala.ldC.setOnClickListener(this.ldy);
                label1304:
                if (bk.bl(paramView)) {
                  break label1489;
                }
                locala.doV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, paramView, locala.doV.getTextSize()), TextView.BufferType.SPANNABLE);
                locala.doV.setVisibility(0);
                label1347:
                locala.ldC.setVisibility(0);
                if (bk.bl(paramViewGroup.kQb)) {
                  break label1502;
                }
                e(locala.ldC, paramViewGroup.kQb);
              }
              for (;;)
              {
                if (bk.bl(paramViewGroup.kQd)) {
                  break label1518;
                }
                e(locala.ldE, paramViewGroup.kQd);
                locala.ldE.setVisibility(0);
                break;
                paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramViewGroup.userName);
                if ((paramView == null) || (bk.bl(paramView.Bq())))
                {
                  paramView = paramViewGroup.userName;
                  break label1200;
                }
                paramView = paramView.Bq();
                break label1200;
                label1468:
                locala.doV.setEnabled(false);
                locala.ldC.setEnabled(false);
                break label1304;
                label1489:
                locala.doV.setVisibility(8);
                break label1347;
                label1502:
                c(locala.ldC, paramViewGroup.userName);
              }
              label1518:
              locala.ldE.setVisibility(8);
              break label618;
            }
            locala.ldC.setVisibility(8);
            locala.doV.setVisibility(8);
            locala.ldE.setVisibility(8);
            break label618;
            label1564:
            locala.gSy.setText(localo.kPD);
            break label696;
            label1580:
            locala.gSy.setVisibility(8);
            break label705;
            label1593:
            locala.ldF.setVisibility(8);
            break label753;
            label1606:
            locala.ldG.setEnabled(false);
            break label847;
            label1618:
            locala.ldI.setVisibility(8);
            break label918;
            label1631:
            locala.ldG.setVisibility(8);
            break label918;
            label1644:
            locala.ldJ.setEnabled(false);
            continue;
            label1656:
            locala.ldJ.setVisibility(8);
            continue;
          }
          locala.ldL.setEnabled(false);
          return localView;
        }
      }
      locala.ldL.setVisibility(8);
      return localView;
    }
    locala.gSy.setVisibility(8);
    locala.ldF.setVisibility(8);
    locala.ldG.setVisibility(8);
    locala.ldI.setVisibility(8);
    locala.ldJ.setVisibility(8);
    locala.ldL.setVisibility(8);
    locala.ldL.setEnabled(false);
    locala.ldJ.setEnabled(false);
    locala.ldC.setEnabled(false);
    locala.doV.setEnabled(false);
    locala.ldN.setVisibility(8);
    locala.ldE.setVisibility(8);
    if (!bk.dk(localo.kPd))
    {
      localObject = (o.h)localo.kPd.get(0);
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((o.h)localObject).userName);
      if (paramView != null)
      {
        paramView = paramView.Bq();
        label1869:
        paramViewGroup = paramView;
        if (bk.bl(paramView)) {
          paramViewGroup = ((o.h)localObject).aVr;
        }
        if (!bk.bl(((o.h)localObject).kQc)) {
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      int i = localo.kPd.size();
      int j;
      if ((!bk.bl(localo.kPb)) && ((localo.kPr & 1L) == 0L))
      {
        locala.ldL.setText(localo.kPb);
        locala.ldL.setVisibility(0);
        if ((localo.kPr & 0x2) > 0L)
        {
          j = this.context.getResources().getColor(g.b.gc_link_color);
          locala.ldL.setTextColor(j);
          locala.ldL.setBackgroundResource(g.d.game_click_change_bg_selector);
          locala.ldL.setOnClickListener(this.lds);
          locala.ldL.setTag(localo);
          locala.ldL.setEnabled(true);
        }
      }
      else
      {
        label2033:
        if ((localo.field_msgType != 10) && (localo.field_msgType != 11)) {
          break label2305;
        }
        if (bk.bl(localo.mAppName)) {
          break label2249;
        }
        locala.doV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, localo.mAppName, locala.doV.getTextSize()), TextView.BufferType.SPANNABLE);
        locala.doV.setVisibility(0);
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
          y.e("MicroMsg.GameMessageAdapter", "error msgtype: " + localo.field_msgType);
          return localView;
          j = this.context.getResources().getColor(g.b.game_msg_text_color);
          locala.ldL.setTextColor(j);
          locala.ldL.setBackgroundResource(0);
          locala.ldL.setOnClickListener(null);
          locala.ldL.setEnabled(false);
          break label2033;
          label2249:
          if (!bk.bl(paramViewGroup))
          {
            locala.doV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, paramViewGroup, locala.doV.getTextSize()));
            locala.doV.setVisibility(0);
          }
          else
          {
            locala.doV.setVisibility(8);
            continue;
            if (!bk.bl(paramViewGroup))
            {
              locala.doV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, paramViewGroup, locala.doV.getTextSize()));
              locala.doV.setVisibility(0);
              if (paramInt != 0)
              {
                locala.doV.setOnClickListener(this.ldu);
                locala.doV.setTag(localo);
                locala.doV.setEnabled(true);
              }
            }
            else
            {
              locala.doV.setVisibility(8);
            }
          }
          label2305:
          break;
        }
      }
      if (!bk.bl(localo.kOX))
      {
        e(locala.ldC, localo.kOX);
        locala.ldC.setVisibility(0);
        label2430:
        if (!bk.bl(localo.jcc))
        {
          if (bk.bl(localo.kPj)) {
            break label2581;
          }
          locala.ldF.setText(localo.jcc);
          locala.ldF.setVisibility(0);
        }
      }
      while (!bk.bl(localo.kPj))
      {
        e(locala.ldJ, localo.kPj);
        locala.ldJ.setTag(Long.valueOf(localo.field_msgId));
        locala.ldJ.setOnTouchListener(ldr);
        locala.ldJ.setOnClickListener(this.ldt);
        locala.ldJ.setVisibility(0);
        locala.ldJ.setEnabled(true);
        return localView;
        y.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
        locala.ldC.setVisibility(8);
        break label2430;
        label2581:
        locala.ldG.setVisibility(0);
        locala.ldH.setText(localo.jcc);
        locala.ldG.setOnClickListener(this.ldt);
        locala.ldG.setTag(Long.valueOf(localo.field_msgId));
      }
      if (!bk.dk(localo.kPd))
      {
        locala.ldC.setVisibility(0);
        if (!bk.bl(((o.h)localo.kPd.get(0)).kQb))
        {
          e(locala.ldC, ((o.h)localo.kPd.get(0)).kQb);
          if (!bk.bl(((o.h)localo.kPd.get(0)).kQc))
          {
            locala.ldC.setOnClickListener(this.ldv);
            locala.ldC.setTag(localo);
            locala.ldC.setEnabled(true);
          }
        }
      }
      for (;;)
      {
        locala.ldG.setVisibility(0);
        locala.ldG.setOnClickListener(this.ldt);
        locala.ldG.setTag(Long.valueOf(localo.field_msgId));
        if (localo.kPL != 1) {
          break label2890;
        }
        locala.ldF.setVisibility(0);
        locala.ldF.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, localo.kPv, locala.ldF.getTextSize()));
        locala.ldH.setText(localo.kPy);
        return localView;
        c(locala.ldC, ((o.h)localo.kPd.get(0)).userName);
        break;
        locala.ldC.setVisibility(8);
      }
      label2890:
      if (localo.kPL == 2)
      {
        locala.ldF.setVisibility(0);
        locala.ldF.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, localo.kPv, locala.ldF.getTextSize()));
        locala.ldH.setText(localo.kPw);
        return localView;
      }
      if (localo.kPL != 3) {
        break;
      }
      locala.gSy.setVisibility(0);
      if (i > 1)
      {
        locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_group_like_more, new Object[] { String.valueOf(i) }));
        a(localo, locala);
      }
      for (;;)
      {
        locala.ldH.setText(localo.kPy);
        return localView;
        locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_group_like_one));
      }
      e(locala.ldC, localo.kOX);
      paramView = "礼物";
      if (localo.kPo.contains("爱心"))
      {
        paramView = "爱心";
        if (i <= 1) {
          break label3177;
        }
        locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_share_more, new Object[] { String.valueOf(i), paramView }));
      }
      for (;;)
      {
        locala.gSy.setVisibility(0);
        a(localo, locala);
        return localView;
        if (!localo.kPo.contains("体力")) {
          break;
        }
        paramView = "体力";
        break;
        label3177:
        locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_share_one, new Object[] { paramView }));
      }
      if (!bk.dk(localo.kPd))
      {
        locala.ldC.setVisibility(0);
        if (!bk.bl(((o.h)localo.kPd.get(0)).kQb))
        {
          e(locala.ldC, ((o.h)localo.kPd.get(0)).kQb);
          label3274:
          if (!bk.bl(((o.h)localo.kPd.get(0)).kQc))
          {
            locala.ldC.setOnClickListener(this.ldv);
            locala.ldC.setTag(localo);
            locala.ldC.setEnabled(true);
          }
          label3326:
          if (i <= 1) {
            break label3509;
          }
          locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_like_more, new Object[] { String.valueOf(i) }));
          a(localo, locala);
        }
      }
      for (;;)
      {
        locala.ldG.setVisibility(0);
        locala.gSy.setVisibility(0);
        locala.ldH.setText(localo.kPz);
        locala.ldG.setOnClickListener(this.ldt);
        locala.ldG.setTag(Long.valueOf(localo.field_msgId));
        if (bk.bl(localo.kPB)) {
          break;
        }
        locala.ldI.setVisibility(0);
        e(locala.ldI, localo.kPB);
        return localView;
        c(locala.ldC, ((o.h)localo.kPd.get(0)).userName);
        break label3274;
        locala.ldC.setVisibility(8);
        break label3326;
        label3509:
        locala.gSy.setText(this.context.getResources().getString(g.i.game_msg_like_one));
      }
      paramInt = 0;
      continue;
      paramView = null;
      break label1869;
      paramInt = 0;
      paramViewGroup = null;
    }
  }
  
  public final boolean sk(int paramInt)
  {
    return (this.dsw > this.bFo) && (this.bFo > 0) && (paramInt == this.bFo);
  }
  
  public final void yc()
  {
    s locals = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf();
    int i = this.iwi;
    String str = s.n(new int[] { 2, 5, 6, 10, 11, 100 });
    setCursor(locals.rawQuery("select * from GameRawMessage where " + str + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + i, new String[0]));
    this.iwi = getCount();
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.n
 * JD-Core Version:    0.7.0.1
 */