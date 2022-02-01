package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.model.aa;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ac.b;
import com.tencent.mm.storage.ac.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.x;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.g.b.s;

public final class e
  extends BaseAdapter
{
  List<com.tencent.mm.storage.ab> eXW;
  private int hBm;
  private int lCR;
  ac.c vAF;
  boolean vFW;
  private BizTimeLineNewMsgUI vGF;
  private long vGG;
  boolean vGH;
  
  public e(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI, List<com.tencent.mm.storage.ab> paramList, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(5908);
    this.vGH = false;
    this.vAF = new ac.c()
    {
      public final void onNotifyChange(Object paramAnonymousObject, ac.a paramAnonymousa)
      {
        AppMethodBeat.i(5905);
        if (paramAnonymousa != null)
        {
          if ((paramAnonymousa.acFX != ac.b.acFZ) || (paramAnonymousa.vGS == null)) {
            break label58;
          }
          e.a(e.this).add(0, paramAnonymousa.vGS);
        }
        for (;;)
        {
          e.this.notifyDataSetChanged();
          AppMethodBeat.o(5905);
          return;
          label58:
          if (paramAnonymousa.acFX == ac.b.acGa)
          {
            paramAnonymousa = e.this;
            paramAnonymousObject = paramAnonymousa.dcN();
            if (paramAnonymousObject != null)
            {
              paramAnonymousa.eXW.clear();
              paramAnonymousa = paramAnonymousa.eXW;
              ag localag = af.bHo();
              long l = paramAnonymousObject.field_createTime;
              paramAnonymousa.addAll(ag.s(localag.omV.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[] { String.valueOf(l) }, null, null, "createTime DESC")));
            }
          }
        }
      }
    };
    this.vFW = false;
    this.vGF = paramBizTimeLineNewMsgUI;
    af.bHo().a(this.vAF, Looper.getMainLooper());
    this.eXW = paramList;
    this.lCR = paramInt1;
    this.hBm = paramInt2;
    this.vGG = paramLong;
    AppMethodBeat.o(5908);
  }
  
  private static void d(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(301832);
    if (com.tencent.mm.model.ab.IS(paramString))
    {
      localLayoutParams = paramImageView.getLayoutParams();
      localLayoutParams.width = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      paramImageView.setLayoutParams(localLayoutParams);
      a.b.h(paramImageView, paramString);
      AppMethodBeat.o(301832);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    localLayoutParams.height = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 36);
    paramImageView.setLayoutParams(localLayoutParams);
    a.b.g(paramImageView, paramString);
    AppMethodBeat.o(301832);
  }
  
  public final com.tencent.mm.storage.ab Hk(int paramInt)
  {
    AppMethodBeat.i(5910);
    if (paramInt < this.eXW.size())
    {
      com.tencent.mm.storage.ab localab = (com.tencent.mm.storage.ab)this.eXW.get(paramInt);
      AppMethodBeat.o(5910);
      return localab;
    }
    AppMethodBeat.o(5910);
    return null;
  }
  
  public final void Hl(final int paramInt)
  {
    AppMethodBeat.i(5913);
    if ((this.lCR == 1) && (!this.vGH))
    {
      AppMethodBeat.o(5913);
      return;
    }
    if ((paramInt == getCount() - 1) && (!this.vFW)) {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(301816);
          Object localObject1;
          Object localObject2;
          if ((paramInt == e.this.getCount() - 1) && (!e.this.vFW))
          {
            Log.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(e.this.getCount()) });
            localObject1 = e.this;
            localObject2 = ((e)localObject1).dcN();
            if (localObject2 == null) {
              break label245;
            }
            ag localag = af.bHo();
            long l = ((com.tencent.mm.storage.ab)localObject2).field_createTime;
            localObject2 = ag.s(localag.omV.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[] { String.valueOf(l) }, null, null, "createTime DESC limit 20"));
            ((e)localObject1).eXW.addAll((Collection)localObject2);
            ((e)localObject1).notifyDataSetChanged();
            if (((List)localObject2).size() <= 0) {
              break label245;
            }
          }
          label245:
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              e.this.vFW = true;
              localObject1 = e.b(e.this);
              if (((BizTimeLineNewMsgUI)localObject1).uiE != null)
              {
                ((BizTimeLineNewMsgUI)localObject1).vGP.setVisibility(8);
                ((BizTimeLineNewMsgUI)localObject1).vGQ.setVisibility(0);
                localObject2 = (TextView)((BizTimeLineNewMsgUI)localObject1).vGQ.findViewById(d.e.biz_time_line_no_more_data_tv);
                if (localObject2 != null) {
                  ((TextView)localObject2).setText(((BizTimeLineNewMsgUI)localObject1).getString(d.i.biz_time_line_new_msg_loading_no_more_tips));
                }
              }
            }
            AppMethodBeat.o(301816);
            return;
          }
        }
      }, 300L);
    }
    AppMethodBeat.o(5913);
  }
  
  public final com.tencent.mm.storage.ab dcN()
  {
    AppMethodBeat.i(5912);
    if (this.eXW.size() > 0)
    {
      com.tencent.mm.storage.ab localab = (com.tencent.mm.storage.ab)this.eXW.get(this.eXW.size() - 1);
      AppMethodBeat.o(5912);
      return localab;
    }
    AppMethodBeat.o(5912);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5909);
    int i = this.eXW.size();
    AppMethodBeat.o(5909);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5911);
    com.tencent.mm.storage.ab localab = Hk(paramInt);
    if (localab == null)
    {
      Log.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5911);
      return paramView;
    }
    paramViewGroup = localab.field_talker;
    int j = 0;
    a locala;
    View localView;
    label332:
    label349:
    Object localObject1;
    int i;
    if (paramView == null)
    {
      locala = new a();
      localView = View.inflate(this.vGF, d.f.biz_time_line_new_msg_item, null);
      locala.caK = localView;
      locala.lKK = ((ImageView)localView.findViewById(d.e.avatar_iv));
      locala.pRg = ((TextView)localView.findViewById(d.e.nick_name_tv));
      paramView = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(locala.pRg);
      locala.timeTv = ((TextView)localView.findViewById(d.e.time_tv));
      locala.titleTv = ((TextView)localView.findViewById(d.e.title_tv));
      locala.vGJ = ((TextView)localView.findViewById(d.e.title_tv_two));
      locala.uix = localView.findViewById(d.e.bottom_line);
      locala.vGK = ((ViewGroup)localView.findViewById(d.e.biz_reject_layout));
      locala.vGL = ((AppBrandNearbyShowcaseView)localView.findViewById(d.e.biz_show_case_layout));
      localView.setTag(locala);
      locala.vGK.setVisibility(8);
      if (!localab.iYh()) {
        break label545;
      }
      paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localab.field_talker);
      if ((paramView != null) && (d.rs(paramView.field_type))) {
        break label640;
      }
      if (localab.iYn() != null)
      {
        paramView = new c.a();
        paramView.oKB = d.d.default_avatar;
        paramView.oKo = true;
        paramView.nrc = true;
        r.bKe().a(localab.iYn().nVs, locala.lKK, paramView.bKx());
      }
      if (!localab.iYh()) {
        break label656;
      }
      paramView = localab.iYn().nickName;
      locala.titleTv.setMaxLines(2147483647);
      locala.vGJ.setVisibility(8);
      locala.pRg.setText(p.b(this.vGF, paramView, locala.pRg.getTextSize()));
      locala.timeTv.setText(c.f(this.vGF, localab.field_createTime));
      if (!localab.iYe()) {
        break label668;
      }
      localObject1 = m.Hj(localab.field_content);
      paramView = (View)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramView = this.vGF.getString(d.i.biz_time_line_item_default_title);
      }
      locala.titleTv.setText(paramView);
      paramView = paramViewGroup;
      i = j;
      label469:
      if (paramInt != getCount() - 1) {
        break label1798;
      }
      locala.uix.setVisibility(4);
    }
    for (;;)
    {
      Hl(paramInt);
      ai.a(paramView, 0, i, localab.field_msgId, paramInt, this.hBm, this.lCR - 1, (int)this.vGG);
      AppMethodBeat.o(5911);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
      break;
      label545:
      if (localab.iYi())
      {
        paramView = ai.N(localab);
        if (!TextUtils.isEmpty(paramView))
        {
          localObject1 = new c.a();
          ((c.a)localObject1).oKB = d.d.default_avatar;
          ((c.a)localObject1).oKo = true;
          ((c.a)localObject1).nrc = true;
          r.bKe().a(paramView, locala.lKK, ((c.a)localObject1).bKx());
          break label332;
        }
        paramView = ai.M(localab);
        if (!Util.isNullOrNil(paramView))
        {
          d(locala.lKK, paramView);
          break label332;
        }
      }
      label640:
      d(locala.lKK, localab.field_talker);
      break label332;
      label656:
      paramView = aa.getDisplayName(localab.field_talker);
      break label349;
      label668:
      if (!localab.iYl())
      {
        if (localab.field_type != 10000) {
          break label803;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = ai.i(localab, 0);
          if (!Util.isNullOrNil(paramView))
          {
            locala.titleTv.setText(paramView);
            ai.b(localab, 0, locala.titleTv);
            paramView = ai.i(localab, 1);
            if (!Util.isNullOrNil(paramView))
            {
              locala.vGJ.setText(paramView);
              locala.vGJ.setVisibility(0);
              ai.b(localab, 1, locala.vGJ);
              paramView = ai.Q(localab);
              if (!Util.isNullOrNil(paramView)) {
                locala.pRg.setText(paramView);
              }
            }
            paramView = paramViewGroup;
            i = j;
            break;
            label803:
            i = 0;
            continue;
          }
          locala.titleTv.setText(p.c(this.vGF, localab.field_content, (int)locala.titleTv.getTextSize()));
          paramView = paramViewGroup;
          i = j;
          break;
        }
      }
      if (localab.iYh())
      {
        locala.titleTv.setText(localab.iYn().title);
        paramView = paramViewGroup;
        i = j;
        break label469;
      }
      if (localab.iYk())
      {
        paramView = ai.i(localab, 0);
        if (!Util.isNullOrNil(paramView))
        {
          locala.titleTv.setText(paramView);
          ai.b(localab, 0, locala.titleTv);
          paramView = ai.i(localab, 1);
          if (!Util.isNullOrNil(paramView))
          {
            locala.vGJ.setText(paramView);
            locala.vGJ.setVisibility(0);
            ai.b(localab, 1, locala.vGJ);
          }
          paramView = ai.Q(localab);
          if (!Util.isNullOrNil(paramView)) {
            locala.pRg.setText(paramView);
          }
          paramView = paramViewGroup;
          i = j;
          break label469;
        }
        locala.titleTv.setText(this.vGF.getString(d.i.app_pic));
        paramView = paramViewGroup;
        i = j;
        break label469;
      }
      if (localab.iYj())
      {
        locala.titleTv.setText(this.vGF.getString(d.i.app_voice));
        paramView = paramViewGroup;
        i = j;
        break label469;
      }
      if (localab.field_type == 43) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1109;
        }
        locala.titleTv.setText(this.vGF.getString(d.i.app_video));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label1109:
      if ((localab.field_type == 42) || (localab.field_type == 66)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1170;
        }
        locala.titleTv.setText(this.vGF.getString(d.i.app_product_card_ticket));
        paramView = paramViewGroup;
        i = j;
        break;
      }
      label1170:
      Object localObject2;
      if (ai.O(localab))
      {
        locala.titleTv.setText(ai.h(localab, 0));
        ai.a(localab, 0, locala.titleTv);
        paramView = ai.h(localab, 1);
        if (!Util.isNullOrNil(paramView))
        {
          locala.vGJ.setText(paramView);
          locala.vGJ.setVisibility(0);
          ai.a(localab, 1, locala.vGJ);
        }
        s.u(localab, "info");
        paramView = "";
        localObject1 = ai.P(localab);
        if (localObject1 == null) {}
        for (;;)
        {
          if (!Util.isNullOrNil(paramView)) {
            locala.pRg.setText(paramView);
          }
          paramView = ai.M(localab);
          i = ai.h(localab);
          break;
          localObject2 = new StringBuilder();
          paramViewGroup = (String)((Map)localObject1).get(".msg.appmsg.mmreader.notify_msg.title2");
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = "";
          }
          localObject2 = ((StringBuilder)localObject2).append(paramView).append(' ');
          paramViewGroup = (String)((Map)localObject1).get(".msg.appmsg.mmreader.notify_msg.action");
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = "";
          }
          paramView = paramView;
        }
      }
      if ((localab.field_type & 0xFFFF) == 49)
      {
        i = 1;
        label1402:
        if (i == 0) {
          break label1771;
        }
        localObject2 = k.b.Hf(localab.field_content);
        if (localObject2 == null) {
          break label1771;
        }
        paramView = "";
        switch (((k.b)localObject2).type)
        {
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        if (Util.isNullOrNil(paramView)) {
          localObject1 = ((k.b)localObject2).getTitle();
        }
        locala.titleTv.setText(p.b(this.vGF, (CharSequence)localObject1, locala.titleTv.getTextSize()));
        paramView = paramViewGroup;
        i = j;
        break;
        i = 0;
        break label1402;
        paramView = ((k.b)localObject2).title;
        continue;
        paramView = this.vGF.getString(d.i.app_pic);
        continue;
        paramView = this.vGF.getString(d.i.app_music) + ((k.b)localObject2).title;
        continue;
        paramView = this.vGF.getString(d.i.app_video) + ((k.b)localObject2).title;
        continue;
        paramView = this.vGF.getString(d.i.app_url) + ((k.b)localObject2).getTitle();
        continue;
        paramView = this.vGF.getString(d.i.app_product_card_ticket) + ((k.b)localObject2).getTitle();
        continue;
        paramView = "[" + ((k.b)localObject2).nSI + "]" + ((k.b)localObject2).nSE;
      }
      label1771:
      locala.titleTv.setText(this.vGF.getString(d.i.biz_time_line_item_un_support_type));
      paramView = paramViewGroup;
      i = j;
      break label469;
      label1798:
      locala.uix.setVisibility(0);
    }
  }
  
  static final class a
  {
    View caK;
    ImageView lKK;
    TextView pRg;
    TextView timeTv;
    TextView titleTv;
    View uix;
    TextView vGJ;
    ViewGroup vGK;
    AppBrandNearbyShowcaseView vGL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.e
 * JD-Core Version:    0.7.0.1
 */