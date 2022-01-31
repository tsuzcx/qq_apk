package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.l;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.widget.MMNeatTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
  implements View.OnCreateContextMenuListener
{
  private static int ieG = 0;
  private static int ieH;
  private static int ieI = 0;
  private static int ieJ = 0;
  private static int ieK = 0;
  private static int ieL;
  private static int ieM;
  private static Long ieU = null;
  private static Long ieV = null;
  private static Long ieW = null;
  boolean bNW = false;
  List<q> hfb = new LinkedList();
  r.c ibN = new a.1(this);
  private int idy = 0;
  private int idz = 0;
  private BizTimeLineUI ieF;
  private q ieN;
  private int ieO;
  private int ieP = 0;
  private BizTimeLineHotView ieQ;
  com.tencent.mm.plugin.brandservice.ui.timeline.a.a ieR;
  private boolean ieS = false;
  private long ieT;
  private long ieX = -1L;
  h ieY;
  boolean ieZ = false;
  private com.tencent.mm.ui.widget.b.a iep;
  private b ifa;
  private g ifb;
  private Set<String> ifc = new HashSet();
  private View.OnTouchListener ifd = new a.8(this);
  private View.OnClickListener ife = new a.9(this);
  private View.OnLongClickListener iff = new a.10(this);
  private View.OnClickListener ifg = new a.11(this);
  private j ifh = new a.13(this);
  private View.OnClickListener ifi = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      long l = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.brandservice.a.c.class)).cz(paramAnonymousView);
      paramAnonymousView = com.tencent.mm.ai.z.ME().D(l, "msgId");
      if (paramAnonymousView != null)
      {
        a.d(a.this).c(paramAnonymousView, 4);
        return;
      }
      y.w("MicroMsg.BizTimeLineAdapter", "mediaIconClickListener info is null");
    }
  };
  private n.d ifj = new a.16(this);
  boolean ifk = false;
  
  public a(BizTimeLineUI paramBizTimeLineUI, List<q> paramList, boolean paramBoolean, g paramg, BizTimeLineHotView paramBizTimeLineHotView)
  {
    this.ieF = paramBizTimeLineUI;
    this.ieQ = paramBizTimeLineHotView;
    this.iep = new com.tencent.mm.ui.widget.b.a(this.ieF);
    this.ifb = paramg;
    int i;
    int j;
    if (ieG == 0)
    {
      ieH = paramBizTimeLineUI.getResources().getDimensionPixelSize(b.b.biz_time_line_sub_item_pic_size);
      ieI = paramBizTimeLineUI.getResources().getDimensionPixelSize(b.b.biz_time_line_item_padding_bottom);
      ieJ = paramBizTimeLineUI.getResources().getDimensionPixelSize(b.b.LargePadding);
      ieK = paramBizTimeLineUI.getResources().getDimensionPixelSize(b.b.MiddlePadding);
      ieL = paramBizTimeLineUI.getResources().getDimensionPixelSize(b.b.biz_time_line_top_line_big_padding);
      ieM = com.tencent.mm.cb.a.fromDPToPix(this.ieF, 2);
      i = com.tencent.mm.cb.a.fj(paramBizTimeLineUI);
      j = com.tencent.mm.cb.a.fk(paramBizTimeLineUI);
      if (i >= j) {
        break label378;
      }
    }
    for (;;)
    {
      ieG = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 2.35F);
      com.tencent.mm.ai.z.ME().a(this.ibN, Looper.getMainLooper());
      this.hfb = paramList;
      this.ieY = new h(this);
      this.ieZ = paramBoolean;
      axJ();
      this.ieR = new com.tencent.mm.plugin.brandservice.ui.timeline.a.a(paramBizTimeLineUI, ieG, ieH, this.hfb);
      return;
      label378:
      i = j;
    }
  }
  
  private static void E(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(int paramInt, q paramq, View paramView1, View paramView2)
  {
    int i;
    if (paramInt > 0)
    {
      paramView1.setVisibility(0);
      if (ieU != null) {
        if (ieU.longValue() == paramq.field_orderFlag)
        {
          i = 1;
          if (i == 0) {
            break label154;
          }
          paramView2.setVisibility(0);
          ((TextView)paramView2.findViewById(b.d.biz_time_line_new_tips_tv)).setText(this.ieF.getString(b.h.biz_time_line_item_new_tips));
        }
      }
    }
    for (;;)
    {
      a(paramq);
      return;
      i = 0;
      break;
      long l2 = paramq.cty();
      long l1 = 0L;
      paramView1 = oy(paramInt - 1);
      if (paramView1 != null) {
        l1 = paramView1.cty();
      }
      if ((l2 != l1) && (ieW != null) && (l1 == ieW.longValue()))
      {
        ieU = Long.valueOf(paramq.field_orderFlag);
        i = 1;
        break;
      }
      i = 0;
      break;
      label154:
      if (ieV != null) {
        if ((ieU != null) && (ieU.longValue() <= ieV.longValue()))
        {
          ieV = Long.valueOf(-1L);
          label191:
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label353;
        }
        paramView2.setVisibility(0);
        ((TextView)paramView2.findViewById(b.d.biz_time_line_new_tips_tv)).setText(this.ieF.getString(b.h.biz_time_line_item_one_day_tips));
        break;
        if (ieV.longValue() == paramq.field_orderFlag)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
          continue;
          paramView1 = oy(paramInt - 1);
          if (paramView1 == null) {
            break label191;
          }
          l1 = System.currentTimeMillis();
          if ((l1 - paramq.field_createTime <= 86400000L) || (l1 - paramView1.field_createTime > 86400000L)) {
            break label191;
          }
          if ((!axO()) && ((ieU == null) || (ieU.longValue() <= paramq.field_orderFlag)))
          {
            ieV = Long.valueOf(-1L);
            break label191;
          }
          ieV = Long.valueOf(paramq.field_orderFlag);
          paramInt = 1;
        }
      }
      label353:
      paramView2.setVisibility(8);
      continue;
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
    }
  }
  
  private static void a(View paramView, c.c paramc, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramc.ifA == null) {
        paramc.cC(paramView);
      }
      if (paramc.ifA != null) {
        paramc.ifA.setVisibility(0);
      }
    }
    while (paramc.ifA == null) {
      return;
    }
    paramc.ifA.setVisibility(8);
  }
  
  private void a(ImageView paramImageView, q paramq, int paramInt, String paramString)
  {
    ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramImageView, paramq.field_msgId, paramString, paramq.field_content, paramInt);
    paramImageView.setOnClickListener(this.ifi);
  }
  
  private void a(com.tencent.mm.ae.m paramm, q paramq, int paramInt1, l paraml, View paramView, boolean paramBoolean, int paramInt2)
  {
    ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramm, paramq, paramInt1, paraml, paramView, paramBoolean, paramInt2, this.ifh);
    paramView.setOnTouchListener(this.ifd);
    paramView.setOnLongClickListener(new a.7(this, paramq, paramInt2));
  }
  
  private void a(final c.b paramb, com.tencent.mm.ae.m paramm, q paramq, int paramInt, boolean paramBoolean)
  {
    if (paramm.type == 5)
    {
      paramb.ifH.setVisibility(0);
      paramb.ifH.setImageResource(b.c.biz_msg_video_play_icon);
      paramb.ifH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.ifA.performClick();
        }
      });
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.ieF, 28);
      if (paramm.type == 7) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.ieF, 32);
      }
      paramb = paramb.ifH;
      paramm = paramb.getLayoutParams();
      paramm.width = paramInt;
      paramm.height = paramInt;
      paramb.setLayoutParams(paramm);
      return;
      if (paramm.type == 6)
      {
        paramb.ifH.setVisibility(0);
        if (paramBoolean) {
          if ((paramq.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.ayD())) {
            paramb.ifH.setImageResource(b.c.chatting_item_biz_music_pause_selector);
          }
        }
        for (;;)
        {
          a(paramb.ifH, paramq, paramInt, paramm.dTD);
          break;
          paramb.ifH.setImageResource(b.c.chatting_item_biz_music_play_selector);
          continue;
          if ((paramq.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.ayD())) {
            paramb.ifH.setImageResource(b.g.chatting_item_biz_music_pause_loading_icon);
          } else {
            paramb.ifH.setImageResource(b.g.chatting_item_biz_music_play_loading_icon);
          }
        }
      }
      if (paramm.type == 7)
      {
        paramb.ifH.setVisibility(0);
        Drawable localDrawable = paramb.ifH.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramq.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.ayD()))
        {
          paramb.ifH.setImageResource(b.c.chatting_item_biz_voice_playing_selector);
          if ((paramb.ifH.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)paramb.ifH.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(paramb.ifH, paramq, paramInt, paramm.dTD);
          break;
          paramb.ifH.setImageResource(b.c.chatting_item_biz_voice_play_selector);
        }
      }
      paramb.ifH.setVisibility(8);
    }
  }
  
  private void a(c.c paramc, q paramq)
  {
    a.b.n(paramc.doU, paramq.field_talker);
    String str = com.tencent.mm.model.r.gV(paramq.field_talker);
    if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramq.field_talker).Bl())
    {
      Object localObject = this.ieF.getResources().getDrawable(b.c.biz_timeline_star_icon);
      int i = (int)paramc.ifO.getTextSize();
      ((Drawable)localObject).setBounds(0, 0, i, i);
      localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
      SpannableString localSpannableString = new SpannableString("@");
      localSpannableString.setSpan(localObject, 0, 1, 33);
      paramc.ifO.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.d.j.a(this.ieF, str, paramc.ifO.getTextSize()) + "  ", localSpannableString }));
      if (paramq.field_isRead != 1) {
        break label298;
      }
      paramc.ifO.getPaint().setFakeBoldText(false);
      paramc.ifO.setTextColor(this.ieF.getResources().getColor(b.a.half_alpha_black));
    }
    for (;;)
    {
      paramc.dsz.setText(com.tencent.mm.plugin.brandservice.ui.b.b.e(this.ieF, paramq.field_createTime));
      paramc.ifN.setOnTouchListener(this.ifd);
      paramc.ifN.setTag(paramq);
      paramc.ifN.setOnLongClickListener(this.iff);
      paramc.ifN.setOnClickListener(this.ifg);
      return;
      paramc.ifO.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.ieF, str, paramc.ifO.getTextSize()));
      break;
      label298:
      paramc.ifO.getPaint().setFakeBoldText(true);
      paramc.ifO.setTextColor(this.ieF.getResources().getColor(b.a.black));
    }
  }
  
  private static void a(c.e parame, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(parame.ifV, parame.iga, bool1);
      if (!bool1) {
        break label223;
      }
    }
    label40:
    label69:
    label202:
    label208:
    label220:
    label223:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 8)
      {
        bool1 = true;
        a(parame.ifV, parame.igb, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label196;
        }
        bool1 = true;
        a(parame.ifV, parame.igc, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label202;
        }
        bool1 = true;
        label98:
        a(parame.ifV, parame.igd, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label208;
        }
        bool1 = true;
        label127:
        a(parame.ifV, parame.ige, bool1);
        if (!bool1) {
          break label220;
        }
        i = 1;
      }
      for (;;)
      {
        LinearLayout localLinearLayout = parame.ifV;
        parame = parame.ifZ;
        if ((i == 0) && (paramInt2 > 0) && (paramInt1 != -1)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, parame, bool1);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label40;
          bool1 = false;
          break label69;
          bool1 = false;
          break label98;
          bool1 = false;
          break label127;
        }
      }
    }
  }
  
  private boolean a(View paramView, TextView paramTextView, q paramq, com.tencent.mm.ae.m paramm)
  {
    if ((paramm == null) || (bk.bl(paramm.url)) || (paramq.field_appMsgStatInfoProto == null) || (bk.dk(paramq.field_appMsgStatInfoProto.sxo)))
    {
      paramView.setVisibility(8);
      return false;
    }
    paramq = paramq.field_appMsgStatInfoProto.sxo.iterator();
    ds localds;
    do
    {
      if (!paramq.hasNext()) {
        break;
      }
      localds = (ds)paramq.next();
    } while (!bk.isEqual(localds.url, paramm.url));
    for (int i = localds.sxn;; i = 0)
    {
      if (i > 0)
      {
        paramView.setVisibility(0);
        if (paramm.type == 5) {
          paramTextView.setText(this.ieF.getString(b.h.biz_time_line_friend_seed, new Object[] { Integer.valueOf(i) }));
        }
        for (;;)
        {
          return true;
          paramTextView.setText(this.ieF.getString(b.h.biz_time_line_friend_read, new Object[] { Integer.valueOf(i) }));
        }
      }
      paramView.setVisibility(8);
      return false;
    }
  }
  
  private boolean a(c.c paramc, q paramq, com.tencent.mm.ae.m paramm)
  {
    return a(paramc.ifI, paramc.ifJ, paramq, paramm);
  }
  
  private void axJ()
  {
    axN();
    Object localObject;
    if (this.ieZ)
    {
      localObject = axM();
      if ((localObject != null) && (!((q)localObject).ctC())) {
        localObject = this.hfb.iterator();
      }
    }
    q localq;
    for (long l = -1L;; l = localq.cty()) {
      if (((Iterator)localObject).hasNext())
      {
        localq = (q)((Iterator)localObject).next();
        if ((l != -1L) && (l != localq.cty())) {
          ieU = Long.valueOf(localq.field_orderFlag);
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private b axK()
  {
    if (this.ifa == null) {
      this.ifa = new b(this.ieF);
    }
    return this.ifa;
  }
  
  private boolean axO()
  {
    q localq = axM();
    if (localq != null)
    {
      if (localq.ctC()) {}
      do
      {
        return true;
        if (this.ieX < 0L) {
          axP();
        }
      } while (localq.cty() == this.ieX);
      return false;
    }
    return false;
  }
  
  private void axP()
  {
    q localq = null;
    Cursor localCursor = com.tencent.mm.ai.z.ME().dXo.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localq = new q();
      localq.d(localCursor);
    }
    localCursor.close();
    if (localq != null) {
      this.ieX = localq.cty();
    }
  }
  
  private static void cB(View paramView)
  {
    int i = ieG;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = i;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private static void j(View paramView, int paramInt1, int paramInt2)
  {
    paramView.setPadding(0, paramInt1 - ieM, 0, paramInt2 - ieM);
  }
  
  public final void a(q paramq)
  {
    if (paramq == null) {
      y.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramq.cty();
      l2 = com.tencent.mm.ai.z.ME().ctG();
      y.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.ieZ), Long.valueOf(l1), Long.valueOf(l2) });
    } while ((this.ieZ) || (l1 != l2) || (!s.hB(paramq.field_orderFlag)));
    this.ieF.ayb();
  }
  
  public final q axL()
  {
    if (this.hfb.size() > 0) {
      return (q)this.hfb.get(this.hfb.size() - 1);
    }
    return null;
  }
  
  public final q axM()
  {
    if (this.hfb.size() > 0) {
      return (q)this.hfb.get(0);
    }
    return null;
  }
  
  public final void axN()
  {
    q localq = axM();
    if (localq != null) {
      ieW = Long.valueOf(localq.cty());
    }
    ieU = null;
    ieV = null;
  }
  
  public final int getCount()
  {
    return this.hfb.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    q localq = oy(paramInt);
    if (localq == null)
    {
      y.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
      return 0;
    }
    switch (localq.field_type)
    {
    default: 
      return 0;
    case 1: 
      return 2;
    case 285212721: 
      return 1;
    case 34: 
      return 3;
    }
    return 4;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    q localq = oy(paramInt);
    if (localq == null)
    {
      y.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      return paramView;
    }
    if ((!this.ieZ) && (!this.bNW))
    {
      this.ifb.b(localq, paramInt);
      xS(localq.field_talker);
    }
    if ((paramInt == getCount() - 1) && (!this.ifk)) {
      ai.l(new a.17(this, paramInt), 300L);
    }
    label170:
    Object localObject1;
    Object localObject2;
    l locall;
    LinkedList localLinkedList;
    int k;
    com.tencent.mm.ae.m localm;
    boolean bool1;
    switch (localq.field_type)
    {
    default: 
      if (paramView == null)
      {
        paramViewGroup = new c.m();
        paramView = this.ieF;
        if (paramViewGroup.ifA != null)
        {
          paramView = paramViewGroup.ifA;
          paramView.setTag(paramViewGroup);
          a(paramViewGroup, localq);
          a(paramInt, localq, paramViewGroup.ifz, paramViewGroup.ify);
          return paramView;
        }
      }
      break;
    case 285212721: 
      if (!this.ieZ) {
        com.tencent.mm.plugin.brandservice.ui.b.c.f(localq);
      }
      if (paramView == null)
      {
        paramViewGroup = new c.e();
        paramView = View.inflate(this.ieF, b.e.biz_time_line_item, null);
        paramViewGroup.ifV = ((LinearLayout)paramView.findViewById(b.d.biz_time_line_content_ll));
        paramViewGroup.ifW = ((LinearLayout)paramView.findViewById(b.d.show_more_article_layout));
        paramViewGroup.ifX = ((TextView)paramView.findViewById(b.d.show_more_article_tv));
        paramViewGroup.ify = ((LinearLayout)paramView.findViewById(b.d.biz_time_line_new_tips_layout));
        paramViewGroup.ifz = ((LinearLayout)paramView.findViewById(b.d.biz_time_line_item_top));
        paramViewGroup.ifA = paramView;
        paramViewGroup.axT();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.ifY.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c.b)((Iterator)localObject1).next();
          aq.U(((c.b)localObject2).ifA, 3);
          paramViewGroup.ifV.removeView(((c.b)localObject2).ifA);
        }
        paramViewGroup = (c.e)paramView.getTag();
      }
      paramViewGroup.ifY.clear();
      locall = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).d(localq.field_msgId, localq.field_content);
      localLinkedList = locall.dTx;
      k = localLinkedList.size();
      if (k == 0)
      {
        paramViewGroup.ifV.setVisibility(8);
        a(paramViewGroup, -1, 0);
        return paramView;
      }
      paramViewGroup.ifV.setVisibility(0);
      localm = (com.tencent.mm.ae.m)localLinkedList.get(0);
      bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(localq, localm);
      if (bool1) {
        if ((bk.bl(localm.dTD)) && ((localm.type == 5) || (localm.type == 0))) {
          bool1 = false;
        }
      }
      break;
    }
    label528:
    label555:
    label1097:
    label1230:
    label1266:
    label2674:
    label3319:
    for (;;)
    {
      a(paramViewGroup, -1, k);
      localq.umU = bool1;
      localObject2 = this.ieF.getLayoutInflater();
      int i = paramViewGroup.ifY.size();
      if (i < k)
      {
        localObject1 = aq.GV(3);
        if (localObject1 != null) {
          break label5626;
        }
        localObject1 = ((LayoutInflater)localObject2).inflate(b.e.biz_time_line_item_comm_slot, null);
      }
      label2936:
      label3193:
      label5626:
      for (;;)
      {
        Object localObject3 = paramViewGroup.ifV;
        Object localObject4 = new c.b();
        ((c.b)localObject4).ifA = ((View)localObject1);
        ((c.b)localObject4).ifB = ((View)localObject1).findViewById(b.d.top_line);
        ((c.b)localObject4).ifC = ((View)localObject1).findViewById(b.d.content_ll);
        ((c.b)localObject4).ifD = ((MMNeatTextView)((View)localObject1).findViewById(b.d.title_neat_tv));
        ((c.b)localObject4).ifE = ((TextView)((View)localObject1).findViewById(b.d.summary));
        ((c.b)localObject4).ifF = ((View)localObject1).findViewById(b.d.cover_area);
        ((c.b)localObject4).ifG = ((ImageView)((View)localObject1).findViewById(b.d.cover_iv));
        ((c.b)localObject4).ifH = ((ImageView)((View)localObject1).findViewById(b.d.play_icon));
        ((c.b)localObject4).ifI = ((View)localObject1).findViewById(b.d.stat_layout);
        ((c.b)localObject4).ifJ = ((TextView)((View)localObject1).findViewById(b.d.friends_read_tv));
        ((ViewGroup)localObject3).addView((View)localObject1, ((ViewGroup)localObject3).getChildCount());
        paramViewGroup.ifY.add(localObject4);
        i += 1;
        break label555;
        a(paramViewGroup, ((com.tencent.mm.ae.m)localLinkedList.get(0)).type, k);
        break label528;
        i = 0;
        while (i < paramViewGroup.ifY.size())
        {
          ((c.b)paramViewGroup.ifY.get(i)).ifA.setVisibility(8);
          i += 1;
        }
        boolean bool2;
        int j;
        c.b localb;
        if (bool1)
        {
          if (localm.type != 5) {
            break label1636;
          }
          cB(paramViewGroup.iga.ifK);
          if (bk.bl(localm.title))
          {
            paramViewGroup.iga.ifS.setVisibility(8);
            a(paramViewGroup.iga, localq, localm);
            localObject1 = paramViewGroup.iga.ifK;
            if (k <= 1) {
              break label1595;
            }
            bool2 = true;
            a(localm, localq, paramInt, locall, (View)localObject1, bool2, 0);
            paramViewGroup.iga.ifL.setVisibility(8);
            paramViewGroup.iga.ifS.setTextColor(this.ieF.getResources().getColor(b.a.light_grey_text_color));
            paramViewGroup.iga.ifJ.setTextColor(this.ieF.getResources().getColor(b.a.light_grey_text_color));
            localObject1 = this.ieR;
            localObject2 = localm.dTD;
            localObject3 = paramViewGroup.iga.ifG;
            i = localq.field_type;
            j = ieG;
            localObject4 = new a.4(this, paramViewGroup);
            if (k != 1) {
              break label1601;
            }
            bool2 = true;
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a)localObject1).a((String)localObject2, (ImageView)localObject3, i, j, (e.a)localObject4, bool2);
            if (k != 1) {
              break label1607;
            }
            paramViewGroup.iga.ifM.setBackgroundResource(b.c.biz_time_line_cover_bottom_round_mask_selector);
            paramViewGroup.iga.ifL.setBackgroundResource(b.c.biz_video_msg_cover_bottom_round_mask);
          }
        }
        else
        {
          if ((k <= 2) || (localq.field_isExpand)) {
            break label3307;
          }
          paramViewGroup.ifW.setVisibility(0);
          paramViewGroup.ifX.setText(this.ieF.getString(b.h.biz_time_line_show_more_article, new Object[] { Integer.valueOf(k - 2) }));
          paramViewGroup.ifW.setTag(localq);
          paramViewGroup.ifW.setOnClickListener(this.ife);
          if (!bool1) {
            break label3319;
          }
          i = 1;
          if ((i >= k) || ((!localq.field_isExpand) && (i > 1))) {
            break label4107;
          }
          localObject4 = (com.tencent.mm.ae.m)localLinkedList.get(i);
          localObject1 = paramViewGroup.ifY;
          if (!bool1) {
            break label3325;
          }
          j = i - 1;
          localb = (c.b)((List)localObject1).get(j);
          j = localm.type;
          if (i != 0) {
            break label3332;
          }
          localb.ifB.setVisibility(8);
          if (bool1) {
            break label3652;
          }
          if (i != 0) {
            break label3563;
          }
          if (k != 1) {
            break label3546;
          }
          j(localb.ifC, ieJ, ieI);
          a(localb, (com.tencent.mm.ae.m)localObject4, localq, i, false);
          a(localb.ifI, localb.ifJ, localq, (com.tencent.mm.ae.m)localObject4);
          localb.ifD.R(((com.tencent.mm.ae.m)localObject4).title);
          localb.ifD.setTextColor(this.ieF.getResources().getColor(b.a.black));
          if ((((com.tencent.mm.ae.m)localObject4).dTG != 0) && (((com.tencent.mm.ae.m)localObject4).dTG != 1)) {
            break label4040;
          }
          localb.ifF.setVisibility(0);
          localb.ifD.setTextColor(this.ieF.getResources().getColor(b.a.black));
          if (((com.tencent.mm.ae.m)localObject4).type != 7) {
            break label3744;
          }
          localb.ifG.setVisibility(8);
          if ((bk.bl(((com.tencent.mm.ae.m)localObject4).dTF)) || (((com.tencent.mm.ae.m)localObject4).type != 3)) {
            break label4074;
          }
          localb.ifE.setText(((com.tencent.mm.ae.m)localObject4).dTF);
          localb.ifE.setVisibility(0);
          localb.ifA.setVisibility(0);
          localObject1 = localb.ifA;
          if (k <= 1) {
            break label4087;
          }
          bool2 = true;
          a((com.tencent.mm.ae.m)localObject4, localq, paramInt, locall, (View)localObject1, bool2, i);
          if ((i != k - 1) || (paramViewGroup.ifW.getVisibility() == 0)) {
            break label4093;
          }
          localb.ifA.setBackgroundResource(b.c.chatting_item_multi_bottom);
        }
        for (;;)
        {
          i += 1;
          break label1178;
          paramViewGroup.iga.ifS.R(localm.title);
          paramViewGroup.iga.ifS.getPaint().setFakeBoldText(true);
          paramViewGroup.iga.ifS.setVisibility(0);
          break;
          bool2 = false;
          break label920;
          bool2 = false;
          break label1048;
          paramViewGroup.iga.ifM.setBackgroundResource(b.c.biz_time_line_cover_mask_selector);
          paramViewGroup.iga.ifL.setBackgroundResource(b.c.biz_video_msg_cover_mask);
          break label1097;
          if (localm.type == 8)
          {
            cB(paramViewGroup.igb.igj);
            paramViewGroup.igb.ifL.setVisibility(8);
            paramViewGroup.igb.ifJ.setTextColor(this.ieF.getResources().getColor(b.a.light_grey_text_color));
            paramViewGroup.igb.hic.setBackgroundResource(b.g.chatting_item_biz_pic_loading_icon);
            localObject1 = this.ieR;
            localObject2 = localm.dTD;
            localObject3 = paramViewGroup.igb.ifG;
            i = localq.field_type;
            j = ieG;
            localObject4 = new a.6(this, paramViewGroup);
            if (k == 1)
            {
              bool2 = true;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a)localObject1).a((String)localObject2, (ImageView)localObject3, i, j, (e.a)localObject4, bool2);
              a(paramViewGroup.igb, localq, localm);
              localObject1 = paramViewGroup.igb.ifK;
              if (k <= 1) {
                break label1863;
              }
            }
            for (bool2 = true;; bool2 = false)
            {
              a(localm, localq, paramInt, locall, (View)localObject1, bool2, 0);
              if (k != 1) {
                break label1869;
              }
              paramViewGroup.igb.ifM.setBackgroundResource(b.c.biz_time_line_cover_bottom_round_mask_selector);
              paramViewGroup.igb.ifL.setBackgroundResource(b.c.biz_time_line_pic_cover_bottom_round_gradient_mask);
              break;
              bool2 = false;
              break label1758;
            }
            paramViewGroup.igb.ifM.setBackgroundResource(b.c.biz_time_line_cover_mask_selector);
            paramViewGroup.igb.ifL.setBackgroundResource(b.c.biz_time_line_pic_cover_gradient_mask);
            break label1097;
          }
          if (localm.type == 7)
          {
            if (bk.bl(localm.title))
            {
              paramViewGroup.igc.ifS.setVisibility(8);
              localObject1 = i.hF(localm.dTH);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label2228;
              }
              paramViewGroup.igc.igo.setVisibility(0);
              paramViewGroup.igc.igo.setText((CharSequence)localObject1);
              localObject1 = paramViewGroup.igc.ifH.getDrawable();
              if (((localObject1 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject1).isRunning())) {
                ((AnimationDrawable)localObject1).stop();
              }
              if (!(localq.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.ayD())) {
                break label2243;
              }
              paramViewGroup.igc.ifH.setImageResource(b.c.chatting_item_biz_voice_playing_selector);
              if ((paramViewGroup.igc.ifH.getDrawable() instanceof AnimationDrawable)) {
                ((AnimationDrawable)paramViewGroup.igc.ifH.getDrawable()).start();
              }
              a(paramViewGroup.igc.ifH, localq, 0, localm.dTD);
              a(paramViewGroup.igc, localq, localm);
              localObject1 = paramViewGroup.igc.ifK;
              if (k <= 1) {
                break label2259;
              }
              bool2 = true;
              a(localm, localq, paramInt, locall, (View)localObject1, bool2, 0);
              if (k != 1) {
                break label2265;
              }
              paramViewGroup.igc.ifK.setBackgroundResource(b.c.chatting_item_multi_bottom);
            }
            for (;;)
            {
              paramViewGroup.igc.ifK.setPadding(ieJ, ieI, ieJ, ieI);
              break;
              paramViewGroup.igc.ifS.setVisibility(0);
              paramViewGroup.igc.ifS.R(localm.title);
              break label1931;
              paramViewGroup.igc.igo.setVisibility(8);
              break label1972;
              paramViewGroup.igc.ifH.setImageResource(b.c.chatting_item_biz_voice_play_selector);
              break label2089;
              bool2 = false;
              break label2139;
              paramViewGroup.igc.ifK.setBackgroundResource(b.c.chatting_item_multi_middle);
            }
          }
          if (localm.type == 6)
          {
            localObject1 = (com.tencent.mm.ae.m)localLinkedList.get(0);
            if (bk.bl(((com.tencent.mm.ae.m)localObject1).title))
            {
              paramViewGroup.igd.ifS.setVisibility(8);
              if (TextUtils.isEmpty(((com.tencent.mm.ae.m)localObject1).dTR)) {
                break label2637;
              }
              paramViewGroup.igd.igh.setVisibility(0);
              paramViewGroup.igd.igh.setText(((com.tencent.mm.ae.m)localObject1).dTR);
              if (((com.tencent.mm.ae.m)localObject1).dTS != 2) {
                break label2652;
              }
              paramViewGroup.igd.igi.setImageResource(b.g.chatting_item_biz_kugou_music_watermark);
              a(paramViewGroup.igd.ifH, localq, 0, ((com.tencent.mm.ae.m)localObject1).dTD);
              a(paramViewGroup.igd, localq, (com.tencent.mm.ae.m)localObject1);
              localObject2 = paramViewGroup.igd.ifK;
              if (k <= 1) {
                break label2668;
              }
              bool2 = true;
              a((com.tencent.mm.ae.m)localObject1, localq, paramInt, locall, (View)localObject2, bool2, 0);
              if (!(localq.field_msgId + "_0").equals(com.tencent.mm.plugin.brandservice.ui.b.c.ayD())) {
                break label2674;
              }
              paramViewGroup.igd.ifH.setImageResource(b.g.chatting_item_biz_music_pause_loading_icon);
              paramViewGroup.igd.ifL.setVisibility(8);
              this.ieR.a(((com.tencent.mm.ae.m)localObject1).dTD, paramViewGroup.igd.ifG, localq.field_type, ieH, ieH, "@S", new a.5(this, paramViewGroup, localq));
              localObject1 = paramViewGroup.igd.ifK;
              if (k <= 1) {
                break label2690;
              }
              ((View)localObject1).setPadding(ieJ, ieJ, ieJ, ieJ);
            }
            for (;;)
            {
              if (k != 1) {
                break label2710;
              }
              paramViewGroup.igd.ifK.setBackgroundResource(b.c.chatting_item_multi_bottom);
              break;
              paramViewGroup.igd.ifS.setVisibility(0);
              paramViewGroup.igd.ifS.R(((com.tencent.mm.ae.m)localObject1).title);
              break label2327;
              paramViewGroup.igd.igh.setVisibility(8);
              break label2364;
              paramViewGroup.igd.igi.setImageResource(b.g.chatting_item_biz_qq_music_watermark);
              break label2386;
              bool2 = false;
              break label2436;
              paramViewGroup.igd.ifH.setImageResource(b.g.chatting_item_biz_music_play_loading_icon);
              break label2498;
              ((View)localObject1).setPadding(ieJ, ieJ, ieJ, ieI);
            }
            paramViewGroup.igd.ifK.setBackgroundResource(b.c.chatting_item_multi_middle);
            break label1097;
          }
          if (localm.type == 10)
          {
            if (bk.bl(localm.title))
            {
              paramViewGroup.ige.ifS.setVisibility(8);
              if (k <= 1) {
                break label2995;
              }
              paramViewGroup.ige.igl.setVisibility(8);
              paramViewGroup.ige.ifK.setBackgroundResource(b.c.chatting_item_multi_middle);
              a(paramViewGroup.ige, localq, localm);
              localObject1 = paramViewGroup.ige.ifK;
              if (k <= 1) {
                break label3022;
              }
            }
            for (bool2 = true;; bool2 = false)
            {
              a(localm, localq, paramInt, locall, (View)localObject1, bool2, 0);
              break;
              paramViewGroup.ige.ifS.setVisibility(0);
              paramViewGroup.ige.ifS.R(com.tencent.mm.pluginsdk.ui.d.j.a(this.ieF, localm.title, (int)paramViewGroup.ige.ifS.getTextSize()));
              i = this.ieR.getContentWidth();
              j = (int)(com.tencent.mm.cb.a.getDensity(this.ieF) * 48.0F);
              localObject1 = paramViewGroup.ige.ifS.Je(i - j);
              if (localObject1 != null)
              {
                i = ((com.tencent.neattextview.textview.layout.b)localObject1).cNL();
                localObject1 = (LinearLayout.LayoutParams)paramViewGroup.ige.ifS.getLayoutParams();
                if (i != 1) {
                  break label2985;
                }
              }
              for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
              {
                paramViewGroup.ige.ifS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                break;
                i = 0;
                break label2936;
              }
              paramViewGroup.ige.igl.setVisibility(0);
              paramViewGroup.ige.ifK.setBackgroundResource(b.c.chatting_item_multi_bottom);
              break label2790;
            }
          }
          cB(paramViewGroup.ifZ.ifG);
          paramViewGroup.ifZ.ifS.R(localm.title);
          paramViewGroup.ifZ.ifS.getPaint().setFakeBoldText(true);
          paramViewGroup.ifZ.ifG.setVisibility(0);
          paramViewGroup.ifZ.ifS.setTextColor(this.ieF.getResources().getColor(b.a.light_grey_text_color));
          paramViewGroup.ifZ.ifJ.setTextColor(this.ieF.getResources().getColor(b.a.light_grey_text_color));
          paramViewGroup.ifZ.igk.setBackgroundResource(b.c.mm_trans);
          localObject1 = this.ieR;
          localObject2 = localm.dTD;
          localObject3 = paramViewGroup.ifZ.ifG;
          i = localq.field_type;
          j = ieG;
          localObject4 = new a.3(this, paramViewGroup, k);
          if (k == 1)
          {
            bool2 = true;
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.a)localObject1).a((String)localObject2, (ImageView)localObject3, i, j, (e.a)localObject4, bool2);
            if (k != 1) {
              break label3285;
            }
            paramViewGroup.ifZ.ifM.setBackgroundResource(b.c.biz_time_line_cover_bottom_round_mask_selector);
            a(paramViewGroup.ifZ, localq, localm);
            localObject1 = paramViewGroup.ifZ.ifK;
            if (k <= 1) {
              break label3301;
            }
          }
          for (bool2 = true;; bool2 = false)
          {
            a(localm, localq, paramInt, locall, (View)localObject1, bool2, 0);
            break;
            bool2 = false;
            break label3193;
            paramViewGroup.ifZ.ifM.setBackgroundResource(b.c.biz_time_line_cover_mask_selector);
            break label3229;
          }
          paramViewGroup.ifW.setVisibility(8);
          break label1170;
          i = 0;
          break label1178;
          label3325:
          j = i;
          break label1230;
          if ((bool1) && (i == 1) && ((j == 5) || (j == 8) || (j == 0)))
          {
            localb.ifB.setVisibility(8);
            break label1266;
          }
          localb.ifB.setVisibility(0);
          if ((!bool1) || (i > 1))
          {
            localObject1 = (com.tencent.mm.ae.m)localLinkedList.get(i - 1);
            localObject2 = (com.tencent.mm.ae.m)localLinkedList.get(i);
            if (((((com.tencent.mm.ae.m)localObject1).type != 7) && (((com.tencent.mm.ae.m)localObject1).type != 5) && (((com.tencent.mm.ae.m)localObject1).type != 6) && (bk.bl(((com.tencent.mm.ae.m)localObject1).dTD))) || ((((com.tencent.mm.ae.m)localObject2).type != 7) && (((com.tencent.mm.ae.m)localObject2).type != 5) && (((com.tencent.mm.ae.m)localObject2).type != 6) && (bk.bl(((com.tencent.mm.ae.m)localObject2).dTD))))
            {
              E(localb.ifB, ieJ);
              break label1266;
            }
            E(localb.ifB, ieL);
            break label1266;
          }
          E(localb.ifB, ieJ);
          break label1266;
          j(localb.ifC, ieJ, ieK);
          break label1296;
          if (i == 1)
          {
            if (k == 2)
            {
              j(localb.ifC, ieK, ieI);
              break label1296;
            }
            j(localb.ifC, ieK, ieK);
            break label1296;
          }
          if (i == k - 1)
          {
            j(localb.ifC, ieK, ieI);
            break label1296;
          }
          j(localb.ifC, ieK, ieK);
          break label1296;
          if (i == 1)
          {
            if (i == k - 1)
            {
              j(localb.ifC, ieJ, ieI);
              break label1296;
            }
            j(localb.ifC, ieJ, ieK);
            break label1296;
          }
          if (i == k - 1)
          {
            j(localb.ifC, ieK, ieI);
            break label1296;
          }
          j(localb.ifC, ieK, ieK);
          break label1296;
          if (!bk.bl(((com.tencent.mm.ae.m)localObject4).dTD))
          {
            localb.ifG.setVisibility(0);
            localObject3 = ((com.tencent.mm.ae.m)localObject4).dTD;
            localObject2 = "@S";
            if ((i == 0) && (!bool1) && (!bk.bl(((com.tencent.mm.ae.m)localObject4).dTU))) {
              localObject1 = ((com.tencent.mm.ae.m)localObject4).dTU;
            }
            for (;;)
            {
              this.ieR.a((String)localObject1, localb.ifG, localq.field_type, ieH, ieH, (String)localObject2, new a.2(this, paramViewGroup, localb, (com.tencent.mm.ae.m)localObject4, localq, i));
              break;
              localObject1 = localObject3;
              if (i == 0)
              {
                localObject2 = "@T";
                localObject1 = localObject3;
              }
            }
          }
          if ((((com.tencent.mm.ae.m)localObject4).type == 5) || (((com.tencent.mm.ae.m)localObject4).type == 6))
          {
            localb.ifG.setVisibility(0);
            localObject3 = this.ieR;
            localObject1 = b.c.chatting_item_biz_play_icon_bg;
            localObject2 = localb.ifG;
            j = ieH;
            int m = ieH;
            ((ImageView)localObject2).setContentDescription(((com.tencent.mm.plugin.brandservice.ui.timeline.a.a)localObject3).ieF.getString(b.h.chatting_img_item_desc));
            localObject3 = o.ON();
            c.a locala = new c.a();
            locala.erd = true;
            locala.eru = b.a.chatting_item_biz_default_bg;
            locala = locala.bn(j, m);
            locala.erk = 4;
            ((com.tencent.mm.as.a.a)localObject3).a((String)localObject1, (ImageView)localObject2, locala.OV(), null, new e());
            break label1429;
          }
          localb.ifF.setVisibility(8);
          break label1429;
          localb.ifF.setVisibility(8);
          localb.ifD.setTextColor(this.ieF.getResources().getColor(b.a.hint_text_color));
          break label1429;
          localb.ifE.setVisibility(8);
          break label1471;
          bool2 = false;
          break label1496;
          label4093:
          localb.ifA.setBackgroundResource(b.c.chatting_item_multi_middle);
        }
        a(paramInt, localq, paramViewGroup.ifz, paramViewGroup.ify);
        a(paramViewGroup, localq);
        return paramView;
        if (paramView == null)
        {
          paramViewGroup = new c.f();
          paramView = this.ieF;
          if (paramViewGroup.ifA != null)
          {
            paramView = paramViewGroup.ifA;
            paramView.setTag(paramViewGroup);
            localObject1 = com.tencent.mm.pluginsdk.ui.d.j.a(this.ieF, localq.field_content, (int)paramViewGroup.ifS.getTextSize(), null, null);
            paramViewGroup.ifS.setMaxLines(2147483647);
            paramViewGroup.ifS.R((CharSequence)localObject1);
            i = this.ieR.getContentWidth();
            j = (int)(com.tencent.mm.cb.a.getDensity(this.ieF) * 48.0F);
            localObject1 = paramViewGroup.ifS.Je(i - j);
            if (localObject1 == null) {
              break label4524;
            }
            i = ((com.tencent.neattextview.textview.layout.b)localObject1).cNL();
            if (i <= 5) {
              break label4543;
            }
            if (!localq.field_isExpand) {
              paramViewGroup.ifS.setMaxLines(5);
            }
            paramViewGroup.igf.setVisibility(0);
            if (!localq.field_isExpand) {
              break label4530;
            }
            paramViewGroup.igf.setText(b.h.biz_time_line_item_show_all_text_collapse);
            paramViewGroup.igf.setOnClickListener(new a.12(this, localq, paramViewGroup));
            localObject1 = (LinearLayout.LayoutParams)paramViewGroup.ifS.getLayoutParams();
            if (i != 1) {
              break label4565;
            }
          }
        }
        for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
        {
          paramViewGroup.ifS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          a(paramViewGroup, localq);
          a(paramInt, localq, paramViewGroup.ifz, paramViewGroup.ify);
          paramViewGroup.igg.setOnTouchListener(this.ifd);
          paramViewGroup.igg.setOnLongClickListener(new a.18(this, localq));
          return paramView;
          paramViewGroup.ifA = View.inflate(paramView, b.e.biz_time_line_text_item, null);
          paramViewGroup.axT();
          paramViewGroup.ifS = ((MMNeatTextView)paramViewGroup.ifA.findViewById(b.d.text_tv));
          paramViewGroup.ifS.setOnTouchListener(new f(paramViewGroup.ifS, new com.tencent.mm.pluginsdk.ui.d.m(paramViewGroup.ifS.getContext())));
          paramViewGroup.igf = ((TextView)paramViewGroup.ifA.findViewById(b.d.show_all_tv));
          paramViewGroup.igg = paramViewGroup.ifA.findViewById(b.d.biz_time_line_item_click_area);
          paramView = paramViewGroup.ifA;
          break;
          paramViewGroup = (c.f)paramView.getTag();
          break label4165;
          i = 0;
          break label4257;
          paramViewGroup.igf.setText(b.h.biz_time_line_item_show_all_text);
          break label4305;
          paramViewGroup.ifS.setMaxLines(2147483647);
          paramViewGroup.igf.setVisibility(8);
          break label4323;
        }
        if (paramView == null)
        {
          paramViewGroup = new c.n();
          paramView = this.ieF;
          if (paramViewGroup.ifA != null)
          {
            paramView = paramViewGroup.ifA;
            paramView.setTag(paramViewGroup);
            localq.umU = com.tencent.mm.plugin.brandservice.ui.b.a.e(localq);
            if (!localq.umU) {
              break label5104;
            }
            paramViewGroup.ifT.setVisibility(0);
            paramViewGroup.ifU.setVisibility(8);
            localObject2 = paramViewGroup.ifS;
            localObject1 = paramViewGroup.ifH;
            localObject3 = new n(localq.field_content);
            ((MMNeatTextView)localObject2).R(com.tencent.mm.pluginsdk.f.h.g("yyyy/MM/dd", System.currentTimeMillis() / 1000L));
            if (localq.umU)
            {
              localObject2 = i.hF((int)(((n)localObject3).time / 1000L));
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label5177;
              }
              paramViewGroup.igo.setVisibility(0);
              paramViewGroup.igo.setText((CharSequence)localObject2);
              paramViewGroup.igg.setOnClickListener(new a.20(this));
              paramViewGroup.igg.setBackgroundResource(b.c.chatting_item_multi_bottom);
              paramViewGroup.igg.setPadding(ieJ, ieI, ieJ, ieJ);
            }
            localObject2 = ((ImageView)localObject1).getDrawable();
            if (((localObject2 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject2).isRunning())) {
              ((AnimationDrawable)localObject2).stop();
            }
            if ((!this.ieY.isPlaying()) || (localq.field_msgId != this.ieY.iho)) {
              break label5189;
            }
            ((ImageView)localObject1).setImageResource(b.c.chatting_item_biz_voice_playing_selector);
            if ((((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
              ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
            }
          }
        }
        for (;;)
        {
          ((ImageView)localObject1).setOnClickListener(new a.21(this, localq, (ImageView)localObject1));
          a(paramViewGroup, localq);
          a(paramInt, localq, paramViewGroup.ifz, paramViewGroup.ify);
          return paramView;
          paramViewGroup.ifA = View.inflate(paramView, b.e.biz_time_line_voice_item, null);
          paramViewGroup.axT();
          paramViewGroup.ifS = ((MMNeatTextView)paramViewGroup.ifA.findViewById(b.d.title_tv));
          paramViewGroup.igo = ((TextView)paramViewGroup.ifA.findViewById(b.d.play_time_tv));
          paramViewGroup.ifH = ((ImageView)paramViewGroup.ifA.findViewById(b.d.big_play_icon));
          paramViewGroup.igg = paramViewGroup.ifA.findViewById(b.d.chatting_item_biz_voice_click_view);
          paramViewGroup.ifB = paramViewGroup.ifA.findViewById(b.d.top_line);
          paramViewGroup.igr = ((MMNeatTextView)paramViewGroup.ifA.findViewById(b.d.title_neat_tv));
          paramViewGroup.ifT = paramViewGroup.ifA.findViewById(b.d.chatting_item_biz_voice);
          paramViewGroup.ifU = paramViewGroup.ifA.findViewById(b.d.small_voice_layout);
          paramViewGroup.igp = ((ImageView)paramViewGroup.ifA.findViewById(b.d.play_icon));
          paramViewGroup.igq = ((ImageView)paramViewGroup.ifA.findViewById(b.d.cover_iv));
          paramView = paramViewGroup.ifA;
          break;
          paramViewGroup = (c.n)paramView.getTag();
          break label4609;
          paramViewGroup.ifB.setVisibility(8);
          paramViewGroup.ifT.setVisibility(8);
          paramViewGroup.ifU.setVisibility(0);
          paramViewGroup.igq.setVisibility(8);
          paramViewGroup.igp.setVisibility(0);
          localObject2 = paramViewGroup.igr;
          localObject1 = paramViewGroup.igp;
          paramViewGroup.ifU.setOnClickListener(new a.19(this));
          break label4656;
          paramViewGroup.igo.setVisibility(8);
          break label4736;
          ((ImageView)localObject1).setImageResource(b.c.chatting_item_biz_voice_play_selector);
        }
        if (paramView == null)
        {
          paramViewGroup = new c.d();
          paramView = this.ieF;
          if (paramViewGroup.ifA != null)
          {
            paramView = paramViewGroup.ifA;
            paramView.setTag(paramViewGroup);
          }
        }
        for (;;)
        {
          a(paramViewGroup, localq);
          a(paramInt, localq, paramViewGroup.ifz, paramViewGroup.ify);
          localq.umU = com.tencent.mm.plugin.brandservice.ui.b.a.e(localq);
          if (!localq.umU) {
            break label5514;
          }
          paramViewGroup.ifU.setVisibility(8);
          paramViewGroup.ifT.setVisibility(0);
          cB(paramViewGroup.ifQ);
          cB(paramViewGroup.ifP);
          axK().a(localq, paramInt, paramViewGroup.ifP, ieG);
          paramViewGroup.ifQ.setOnClickListener(new a.22(this, localq));
          paramViewGroup.ifQ.setOnTouchListener(this.ifd);
          paramViewGroup.ifQ.setOnLongClickListener(new a.23(this, localq));
          return paramView;
          paramViewGroup.ifA = View.inflate(paramView, b.e.biz_time_line_img_item, null);
          paramViewGroup.axT();
          paramViewGroup.ifP = ((ImageView)paramViewGroup.ifA.findViewById(b.d.pic_iv));
          paramViewGroup.ifQ = ((ImageView)paramViewGroup.ifA.findViewById(b.d.pic_iv_pressed));
          paramViewGroup.ifR = ((ImageView)paramViewGroup.ifA.findViewById(b.d.cover_iv));
          paramViewGroup.ifB = paramViewGroup.ifA.findViewById(b.d.top_line);
          paramViewGroup.ifT = paramViewGroup.ifA.findViewById(b.d.big_pic_layout);
          paramViewGroup.ifU = paramViewGroup.ifA.findViewById(b.d.small_pic_layout);
          paramViewGroup.ifS = ((MMNeatTextView)paramViewGroup.ifA.findViewById(b.d.title_neat_tv));
          paramView = paramViewGroup.ifA;
          break;
          paramViewGroup = (c.d)paramView.getTag();
        }
        paramViewGroup.ifU.setVisibility(0);
        paramViewGroup.ifT.setVisibility(8);
        paramViewGroup.ifB.setVisibility(8);
        paramViewGroup.ifS.R(this.ieF.getText(b.h.biz_time_line_img_msg_title));
        axK().a(localq, paramInt, paramViewGroup.ifR, 0);
        paramViewGroup.ifU.setOnClickListener(new a.24(this, localq));
        return paramView;
        paramViewGroup.ifA = View.inflate(paramView, b.e.biz_time_line_unknown_item, null);
        paramViewGroup.axT();
        paramView = paramViewGroup.ifA;
        break;
        paramViewGroup = (c.m)paramView.getTag();
        break label170;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 5;
  }
  
  public final boolean isEmpty()
  {
    if (super.isEmpty()) {
      if (com.tencent.mm.ai.z.MF().aAo() <= 0) {}
    }
    for (;;)
    {
      return false;
      bxp localbxp = d.ayg();
      if ((localbxp != null) && (!bk.dk(localbxp.tNF))) {}
      for (int i = 0; i != 0; i = 1) {
        return super.isEmpty();
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (this.ieN == null) {
      y.w("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu mInfo == null");
    }
    do
    {
      return;
      if (this.ieP != 0) {
        break;
      }
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.ieN.field_talker);
      if (paramView == null)
      {
        y.e("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu, contact is null, talker = " + this.ieN.field_talker);
        return;
      }
      paramContextMenuInfo = paramView.Bq();
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(this.ieF, paramContextMenuInfo));
    } while (!com.tencent.mm.n.a.gR(paramView.field_type));
    paramContextMenu.add(0, 2, 0, b.h.main_conversation_longclick_delete_biz_service);
    paramContextMenu.add(0, 10, 0, b.h.biz_time_line_delete_msg);
    return;
    paramContextMenu.add(0, 11, 0, b.h.biz_time_line_egg);
  }
  
  public final q oy(int paramInt)
  {
    if ((paramInt < this.hfb.size()) && (paramInt >= 0)) {
      return (q)this.hfb.get(paramInt);
    }
    return null;
  }
  
  public final void xS(String paramString)
  {
    com.tencent.mm.kernel.g.DQ();
    if ((com.tencent.mm.kernel.a.hw(com.tencent.mm.kernel.g.DN().dJB)) && (!this.ifc.contains(paramString)))
    {
      com.tencent.mm.modelsimple.z.T(paramString, 2);
      this.ifc.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a
 * JD-Core Version:    0.7.0.1
 */